package com.tencent.qqnt.aio.helper;

import android.content.DialogInterface;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import com.qzone.module.covercomponent.model.CoverDBCacheData;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.pad.DeviceType;
import com.tencent.common.config.pad.PadUtil;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.guild.temp.api.ITroopGuildTempApi;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetPopupInfoRsp;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.redpoint.api.IRedPointUtilsApi;
import com.tencent.mobileqq.troop.troopsetting.api.ITroopSettingApi;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.helper.en;
import com.tencent.qqnt.kernel.nativeinterface.GroupExt;
import com.tencent.troopguild.api.ITroopGuildApi;
import com.tencent.troopguild.api.ITroopUpgradeUtilsApi;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\b*\u00028<\b\u0007\u0018\u0000 A2\u00020\u0001:\u0001BB\u0007\u00a2\u0006\u0004\b?\u0010@J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\"\u0010\r\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J/\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u000e\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u000eH\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0003J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\u0018\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\u001a\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002J\u0018\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\u0010\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010 \u001a\u00020\u0004H\u0016J\b\u0010!\u001a\u00020\u001bH\u0016J\u0010\u0010$\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\"H\u0016J\b\u0010&\u001a\u00020%H\u0016J\u0010\u0010(\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u001bH\u0016J\b\u0010)\u001a\u00020\u0002H\u0016R\u0016\u0010,\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010.\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010+R\u0016\u00100\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010+R\u0016\u00103\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0014\u0010;\u001a\u0002088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0014\u0010>\u001a\u00020<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010=\u00a8\u0006C"}, d2 = {"Lcom/tencent/qqnt/aio/helper/en;", "Lcom/tencent/aio/main/businesshelper/h;", "", "k", "", "troopUin", HippyTKDListViewAdapter.X, BdhLogUtil.LogTag.Tag_Conn, DomainData.DOMAIN_NAME, "Lcom/tencent/troopguild/api/ITroopUpgradeUtilsApi;", "upgradeUtilsApi", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGetPopupInfoRsp;", "rsp", "y", "", CoverDBCacheData.URLS, "u", "(Ljava/lang/String;Lcom/tencent/troopguild/api/ITroopUpgradeUtilsApi;[Ljava/lang/String;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "p", "B", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "troopInfo", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "t", "", "retCode", "w", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, ReportConstant.COSTREPORT_PREFIX, "getTag", "getId", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", "", "interestedIn", "state", "onMoveToState", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "d", "Z", "hasReceivedTroopUpgradeNotification", "e", "hasDialogShown", "f", "hasHelperResume", tl.h.F, "Ljava/lang/String;", "mTroopUin", "Lcom/tencent/aio/api/runtime/a;", "i", "Lcom/tencent/aio/api/runtime/a;", "mAIOContext", "com/tencent/qqnt/aio/helper/en$c", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/qqnt/aio/helper/en$c;", "troopExtInfoObserver", "com/tencent/qqnt/aio/helper/en$b", "Lcom/tencent/qqnt/aio/helper/en$b;", "dialogListener", "<init>", "()V", "D", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes34.dex */
public final class en implements com.tencent.aio.main.businesshelper.h {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean hasReceivedTroopUpgradeNotification;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean hasDialogShown;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean hasHelperResume;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private String mTroopUin;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a mAIOContext;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final c troopExtInfoObserver = new c();

    /* renamed from: C, reason: from kotlin metadata */
    private final b dialogListener = new b();

    private final void A(String troopUin) {
        AppInterface e16 = com.tencent.mobileqq.troop.utils.bg.e();
        if (e16 != null) {
            QLog.d("TroopGuildUpgradeHelper", 1, "ShowTroopSettingEntryRedDot " + troopUin);
            ((IRedPointUtilsApi) QRoute.api(IRedPointUtilsApi.class)).updateRedPointInfo(e16, troopUin, "troop", 6, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B(String troopUin) {
        QRouteApi api = QRoute.api(ITroopUpgradeUtilsApi.class);
        ITroopUpgradeUtilsApi iTroopUpgradeUtilsApi = (ITroopUpgradeUtilsApi) api;
        if (!(!iTroopUpgradeUtilsApi.hasTouchRedDotOfTroopUpgrade(troopUin) && iTroopUpgradeUtilsApi.shouldShowTroopUpgradeSetting(com.tencent.mobileqq.troop.utils.bg.e(), troopUin))) {
            api = null;
        }
        if (((ITroopUpgradeUtilsApi) api) != null) {
            A(troopUin);
        }
    }

    private final void C(String troopUin) {
        QRouteApi api = QRoute.api(ITroopUpgradeUtilsApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(ITroopUpgradeUtilsApi::class.java)");
        ITroopUpgradeUtilsApi iTroopUpgradeUtilsApi = (ITroopUpgradeUtilsApi) api;
        if (!iTroopUpgradeUtilsApi.hasCacheUpgradeDialogUIData(troopUin)) {
            QLog.d("TroopGuildUpgradeHelper", 1, "requestServerIfNeeded " + troopUin + " | no cache");
            return;
        }
        if (iTroopUpgradeUtilsApi.hasUseRecentCacheToShowDialogPassively(troopUin)) {
            QLog.i("TroopGuildUpgradeHelper", 1, "requestServerIfNeeded " + troopUin + " | dialog has shown recently");
            return;
        }
        String[] imageUrlsFromUIDataOf = iTroopUpgradeUtilsApi.getImageUrlsFromUIDataOf(troopUin);
        if (imageUrlsFromUIDataOf != null) {
            u(troopUin, iTroopUpgradeUtilsApi, imageUrlsFromUIDataOf);
        }
    }

    private final void k() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.aio.helper.ek
            @Override // java.lang.Runnable
            public final void run() {
                en.m(en.this);
            }
        }, 64, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(en this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String str = this$0.mTroopUin;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTroopUin");
            str = null;
        }
        this$0.x(str);
    }

    private final void n(final String troopUin) {
        if (QLog.isDebugVersion()) {
            QLog.i("TroopGuildUpgradeHelper", 4, "callRequestServerApi  " + troopUin);
        }
        IGPSService iGPSService = (IGPSService) com.tencent.mobileqq.troop.utils.bg.l(IGPSService.class);
        if (iGPSService != null) {
            iGPSService.getPopupInfo(Long.parseLong(troopUin), 0, new wh2.cs() { // from class: com.tencent.qqnt.aio.helper.el
                @Override // wh2.cs
                public final void a(int i3, String str, IGProGetPopupInfoRsp iGProGetPopupInfoRsp) {
                    en.o(en.this, troopUin, i3, str, iGProGetPopupInfoRsp);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(en this$0, String troopUin, int i3, String str, IGProGetPopupInfoRsp iGProGetPopupInfoRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(troopUin, "$troopUin");
        this$0.w(troopUin, i3);
        if (i3 == 0 && iGProGetPopupInfoRsp != null) {
            QLog.i("TroopGuildUpgradeHelper", 1, "onResult = " + i3);
            ITroopUpgradeUtilsApi iTroopUpgradeUtilsApi = (ITroopUpgradeUtilsApi) QRoute.api(ITroopUpgradeUtilsApi.class);
            Intrinsics.checkNotNullExpressionValue(iTroopUpgradeUtilsApi, "this");
            this$0.y(troopUin, iTroopUpgradeUtilsApi, iGProGetPopupInfoRsp);
            this$0.u(troopUin, iTroopUpgradeUtilsApi, new String[]{iGProGetPopupInfoRsp.getImgUrl(), iGProGetPopupInfoRsp.getGifUrl()});
            return;
        }
        QLog.e("TroopGuildUpgradeHelper", 1, troopUin + " getPopupInfo failed, result = " + i3 + " errMsg = " + str);
    }

    private final boolean p(String troopUin) {
        if (this.hasDialogShown) {
            return false;
        }
        String str = this.mTroopUin;
        com.tencent.aio.api.runtime.a aVar = null;
        String str2 = null;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTroopUin");
            str = null;
        }
        if (!Intrinsics.areEqual(str, troopUin)) {
            String str3 = this.mTroopUin;
            if (str3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTroopUin");
            } else {
                str2 = str3;
            }
            QLog.i("TroopGuildUpgradeHelper", 1, "troopUin=" + troopUin + ", currentTroopUin=" + str2);
            return false;
        }
        com.tencent.aio.api.runtime.a aVar2 = this.mAIOContext;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
        } else {
            aVar = aVar2;
        }
        if (aVar.d().getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED)) {
            return true;
        }
        QLog.i("TroopGuildUpgradeHelper", 1, "aio isn't resumed, shouldn't show dialog");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TroopInfo q(String troopUin) {
        ITroopInfoService iTroopInfoService = (ITroopInfoService) com.tencent.mobileqq.troop.utils.bg.l(ITroopInfoService.class);
        if (iTroopInfoService != null) {
            return iTroopInfoService.findTroopInfo(troopUin);
        }
        return null;
    }

    private final boolean r(TroopInfo troopInfo) {
        String currentAccountUin;
        AppInterface e16 = com.tencent.mobileqq.troop.utils.bg.e();
        if (e16 != null && (currentAccountUin = e16.getCurrentAccountUin()) != null) {
            Boolean valueOf = troopInfo != null ? Boolean.valueOf(troopInfo.isOwnerOrAdmin(currentAccountUin)) : null;
            if (valueOf != null) {
                return valueOf.booleanValue();
            }
        }
        return false;
    }

    private final boolean s(String troopUin) {
        return System.currentTimeMillis() - ((ITroopUpgradeUtilsApi) QRoute.api(ITroopUpgradeUtilsApi.class)).lastTimeOfRequestServerForDialog(troopUin) < 86400000;
    }

    private final boolean t(TroopInfo troopInfo) {
        return ((ITroopGuildApi) QRoute.api(ITroopGuildApi.class)).isTroopGuild(troopInfo);
    }

    private final void u(final String troopUin, final ITroopUpgradeUtilsApi upgradeUtilsApi, String[] urls) {
        if (p(troopUin)) {
            int length = urls.length;
            boolean z16 = false;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    z16 = true;
                    break;
                } else if (!(true ^ TextUtils.isEmpty(urls[i3]))) {
                    break;
                } else {
                    i3++;
                }
            }
            if (!z16) {
                urls = null;
            }
            if (urls != null) {
                ((ITroopGuildTempApi) QRoute.api(ITroopGuildTempApi.class)).preDownloadImage(urls, new Runnable() { // from class: com.tencent.qqnt.aio.helper.em
                    @Override // java.lang.Runnable
                    public final void run() {
                        en.v(en.this, troopUin, upgradeUtilsApi);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(en this$0, String troopUin, ITroopUpgradeUtilsApi upgradeUtilsApi) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(troopUin, "$troopUin");
        Intrinsics.checkNotNullParameter(upgradeUtilsApi, "$upgradeUtilsApi");
        this$0.z(troopUin, upgradeUtilsApi);
    }

    private final void x(String troopUin) {
        if (!((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).isTroopGuildUpgradeSwitchOn()) {
            QLog.i("TroopGuildUpgradeHelper", 1, "requestServerIfNeeded | switch off");
            return;
        }
        TroopInfo q16 = q(troopUin);
        if (r(q16)) {
            if (t(q16)) {
                QLog.i("TroopGuildUpgradeHelper", 1, "requestServerIfNeeded  " + troopUin + " | isTroopGuild");
                return;
            }
            if (s(troopUin)) {
                QLog.i("TroopGuildUpgradeHelper", 1, "requestServerIfNeeded  " + troopUin + " | Time not yet");
                C(troopUin);
                return;
            }
            n(troopUin);
        }
    }

    private final void z(String troopUin, ITroopUpgradeUtilsApi upgradeUtilsApi) {
        FragmentManager supportFragmentManager;
        if (p(troopUin)) {
            this.hasDialogShown = true;
            upgradeUtilsApi.noteDialogHasShown(troopUin, true);
            upgradeUtilsApi.noteUseRecentCacheToShowDialogPassively(troopUin);
            this.dialogListener.g(false);
            this.dialogListener.f(troopUin);
            com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
            com.tencent.aio.api.runtime.a aVar2 = null;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
                aVar = null;
            }
            FragmentActivity activity = aVar.c().getActivity();
            if (activity == null || (supportFragmentManager = activity.getSupportFragmentManager()) == null) {
                return;
            }
            b bVar = this.dialogListener;
            com.tencent.aio.api.runtime.a aVar3 = this.mAIOContext;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            } else {
                aVar2 = aVar3;
            }
            upgradeUtilsApi.showUpgradeGuideDialogInAIO(troopUin, supportFragmentManager, bVar, bVar, aVar2.c().getView());
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return cw.f350641i0;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public String getTag() {
        return "TroopGuildUpgradeHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(com.tencent.aio.main.businesshelper.b param) {
        Intrinsics.checkNotNullParameter(param, "param");
        com.tencent.aio.api.runtime.a a16 = param.a();
        this.mAIOContext = a16;
        if (a16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            a16 = null;
        }
        this.mTroopUin = a16.g().r().c().j();
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onDestroy() {
        h.a.b(this);
        this.hasReceivedTroopUpgradeNotification = false;
        this.hasDialogShown = false;
        this.hasHelperResume = false;
    }

    private final void y(String troopUin, ITroopUpgradeUtilsApi upgradeUtilsApi, IGProGetPopupInfoRsp rsp) {
        String[] strArr = new String[5];
        String title = rsp != null ? rsp.getTitle() : null;
        if (title == null) {
            title = "";
        }
        strArr[0] = title;
        String imgUrl = rsp != null ? rsp.getImgUrl() : null;
        if (imgUrl == null) {
            imgUrl = "";
        }
        strArr[1] = imgUrl;
        String gifUrl = rsp != null ? rsp.getGifUrl() : null;
        if (gifUrl == null) {
            gifUrl = "";
        }
        strArr[2] = gifUrl;
        String buttonText = rsp != null ? rsp.getButtonText() : null;
        if (buttonText == null) {
            buttonText = "";
        }
        strArr[3] = buttonText;
        String footText = rsp != null ? rsp.getFootText() : null;
        strArr[4] = footText != null ? footText : "";
        upgradeUtilsApi.encodeUpgradeDialogUIData(troopUin, strArr);
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public int[] interestedIn() {
        return new int[]{12, 3, 0};
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u001a\u0010\t\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016R\"\u0010\u0011\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001a"}, d2 = {"com/tencent/qqnt/aio/helper/en$b", "Landroid/content/DialogInterface$OnDismissListener;", "Landroid/content/DialogInterface$OnClickListener;", "", "d", "Landroid/content/DialogInterface;", "dialog", "", "which", NodeProps.ON_CLICK, "onDismiss", "", "Z", "getUserClickedConfirm", "()Z", "g", "(Z)V", "userClickedConfirm", "", "e", "Ljava/lang/String;", "getTroopUin", "()Ljava/lang/String;", "f", "(Ljava/lang/String;)V", "troopUin", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements DialogInterface.OnDismissListener, DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private boolean userClickedConfirm;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private String troopUin = "";

        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(b this$0, int i3, String str, ArrayList arrayList) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (QLog.isColorLevel()) {
                QLog.d("TroopGuildUpgradeHelper", 2, "delay upgrade  " + this$0.troopUin + " | result=" + i3 + ", errMsg=" + str);
            }
        }

        private final void d() {
            ArrayList<Long> arrayListOf;
            ((ITroopUpgradeUtilsApi) QRoute.api(ITroopUpgradeUtilsApi.class)).noteUserConfirmUpgrade(this.troopUin);
            IGPSService iGPSService = (IGPSService) com.tencent.mobileqq.troop.utils.bg.l(IGPSService.class);
            if (iGPSService != null) {
                arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(Long.valueOf(Long.parseLong(this.troopUin)));
                iGPSService.upgradeGroupFeed(arrayListOf, 1, new wh2.eq() { // from class: com.tencent.qqnt.aio.helper.ep
                    @Override // wh2.eq
                    public final void onUpgradeGroupCallback(int i3, String str, ArrayList arrayList) {
                        en.b.e(en.b.this, i3, str, arrayList);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(b this$0, int i3, String str, ArrayList arrayList) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            QLog.d("TroopGuildUpgradeHelper", 1, "now upgrade  " + this$0.troopUin + " | result = " + i3 + ", errMsg = " + str);
        }

        public final void f(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.troopUin = str;
        }

        public final void g(boolean z16) {
            this.userClickedConfirm = z16;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialog) {
            ArrayList<Long> arrayListOf;
            if (this.userClickedConfirm) {
                return;
            }
            IGPSService iGPSService = (IGPSService) com.tencent.mobileqq.troop.utils.bg.l(IGPSService.class);
            if (iGPSService != null) {
                arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(Long.valueOf(Long.parseLong(this.troopUin)));
                iGPSService.upgradeGroupFeed(arrayListOf, 2, new wh2.eq() { // from class: com.tencent.qqnt.aio.helper.eo
                    @Override // wh2.eq
                    public final void onUpgradeGroupCallback(int i3, String str, ArrayList arrayList) {
                        en.b.c(en.b.this, i3, str, arrayList);
                    }
                });
            }
            en.this.B(this.troopUin);
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialog, int which) {
            if (which == -1 && !this.userClickedConfirm) {
                this.userClickedConfirm = true;
                d();
            }
            if (dialog != null) {
                dialog.dismiss();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J$\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014\u00a8\u0006\f"}, d2 = {"com/tencent/qqnt/aio/helper/en$c", "Lcom/tencent/mobileqq/troop/api/observer/e;", "", "isSucc", "", "troopUin", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupExt;", "oldTroppInfoExtObj", "a", "b", "", "onGetTroopInfoExtComplete", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c extends com.tencent.mobileqq.troop.api.observer.e {
        c() {
        }

        private final boolean b() {
            FragmentManager supportFragmentManager;
            List<Fragment> fragments;
            com.tencent.aio.api.runtime.a aVar = en.this.mAIOContext;
            com.tencent.aio.api.runtime.a aVar2 = null;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
                aVar = null;
            }
            if (PadUtil.a(aVar.c().getActivity()) == DeviceType.PHONE) {
                return false;
            }
            String name = ((ITroopSettingApi) QRoute.api(ITroopSettingApi.class)).getTroopSettingFragmentClass().getName();
            com.tencent.aio.api.runtime.a aVar3 = en.this.mAIOContext;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            } else {
                aVar2 = aVar3;
            }
            FragmentActivity activity = aVar2.c().getActivity();
            if (activity == null || (supportFragmentManager = activity.getSupportFragmentManager()) == null || (fragments = supportFragmentManager.getFragments()) == null) {
                return false;
            }
            for (Fragment fragment : fragments) {
                if (Intrinsics.areEqual(fragment.getClass().getName(), name)) {
                    if (fragment != null) {
                        return fragment.isVisible();
                    }
                    return false;
                }
            }
            throw new NoSuchElementException("Collection contains no element matching the predicate.");
        }

        @Override // com.tencent.mobileqq.troop.api.observer.e
        protected void onGetTroopInfoExtComplete(boolean isSucc, String troopUin, GroupExt oldTroppInfoExtObj) {
            a(isSucc, troopUin, oldTroppInfoExtObj);
        }

        private final boolean a(boolean isSucc, String troopUin, GroupExt oldTroppInfoExtObj) {
            if (isSucc) {
                if (!(troopUin == null || troopUin.length() == 0)) {
                    String str = en.this.mTroopUin;
                    com.tencent.aio.api.runtime.a aVar = null;
                    if (str == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mTroopUin");
                        str = null;
                    }
                    if (Intrinsics.areEqual(troopUin, str)) {
                        Long valueOf = oldTroppInfoExtObj != null ? Long.valueOf(oldTroppInfoExtObj.bindGuildId) : null;
                        TroopInfo q16 = en.this.q(troopUin);
                        if (Intrinsics.areEqual(valueOf, q16 != null ? Long.valueOf(q16.getTroopGuildId()) : null)) {
                            return false;
                        }
                        QLog.i("TroopGuildUpgradeHelper", 1, "onReceiveTroopUpgradeNotification");
                        en.this.hasReceivedTroopUpgradeNotification = true;
                        com.tencent.aio.api.runtime.a aVar2 = en.this.mAIOContext;
                        if (aVar2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
                        } else {
                            aVar = aVar2;
                        }
                        return (aVar.d().getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED) || b()) ? false : true;
                    }
                }
            }
            return false;
        }
    }

    private final void w(String troopUin, int retCode) {
        if (retCode == 0 || retCode == -2) {
            ((ITroopUpgradeUtilsApi) QRoute.api(ITroopUpgradeUtilsApi.class)).noteLastTimeOfRequestServerForDialog(troopUin, System.currentTimeMillis());
        }
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        AppInterface e16;
        if (state == 0) {
            this.hasDialogShown = false;
            AppInterface e17 = com.tencent.mobileqq.troop.utils.bg.e();
            if (e17 != null) {
                e17.addObserver(this.troopExtInfoObserver);
                return;
            }
            return;
        }
        if (state != 3) {
            if (state == 12 && (e16 = com.tencent.mobileqq.troop.utils.bg.e()) != null) {
                e16.removeObserver(this.troopExtInfoObserver);
                return;
            }
            return;
        }
        if (this.hasHelperResume) {
            return;
        }
        this.hasHelperResume = true;
        k();
    }
}
