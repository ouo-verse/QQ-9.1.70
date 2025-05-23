package os2;

import android.content.DialogInterface;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.qzone.module.covercomponent.model.CoverDBCacheData;
import com.tencent.common.config.pad.DeviceType;
import com.tencent.common.config.pad.PadUtil;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.aio.helper.u;
import com.tencent.mobileqq.activity.aio.p;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.guild.temp.api.ITroopGuildTempApi;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetPopupInfoRsp;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.redpoint.api.IRedPointUtilsApi;
import com.tencent.mobileqq.troop.troopsetting.api.ITroopSettingApi;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.GroupExt;
import com.tencent.troopguild.api.ITroopGuildApi;
import com.tencent.troopguild.api.ITroopUpgradeUtilsApi;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import os2.d;
import tl.h;
import wh2.cs;
import wh2.eq;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\b\u0004\n\u0002\b\u0007*\u0002.2\u0018\u0000 \u00192\u00020\u0001:\u00017B\u000f\u0012\u0006\u0010(\u001a\u00020#\u00a2\u0006\u0004\b5\u00106J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\"\u0010\r\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J/\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u000e\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u000eH\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0003J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\u0018\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\u001a\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002J\u0018\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\u0010\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010!\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u001bH\u0016J\u0006\u0010\"\u001a\u00020\u0013R\u0017\u0010(\u001a\u00020#8\u0006\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0016\u0010+\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010-\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010*R\u0014\u00101\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0014\u00104\u001a\u0002028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u00103\u00a8\u00068"}, d2 = {"Los2/d;", "Lcom/tencent/mobileqq/activity/aio/helper/u;", "", "g", "", "troopUin", "u", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "i", "Lcom/tencent/troopguild/api/ITroopUpgradeUtilsApi;", "upgradeUtilsApi", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGetPopupInfoRsp;", "rsp", "v", "", CoverDBCacheData.URLS, "r", "(Ljava/lang/String;Lcom/tencent/troopguild/api/ITroopUpgradeUtilsApi;[Ljava/lang/String;)V", "w", "", "k", "y", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "troopInfo", "o", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "retCode", "t", HippyTKDListViewAdapter.X, "p", "state", "onMoveToState", DomainData.DOMAIN_NAME, "La61/a;", "d", "La61/a;", "l", "()La61/a;", "aioContext", "e", "Z", "hasReceivedTroopUpgradeNotification", "f", "hasDialogShown", "os2/d$c", h.F, "Los2/d$c;", "troopExtInfoObserver", "os2/d$b", "Los2/d$b;", "dialogListener", "<init>", "(La61/a;)V", "a", "qqguild_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class d implements u {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final a61.a aioContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean hasReceivedTroopUpgradeNotification;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean hasDialogShown;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final c troopExtInfoObserver;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final b dialogListener;

    public d(a61.a aioContext) {
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        this.aioContext = aioContext;
        this.troopExtInfoObserver = new c();
        this.dialogListener = new b();
    }

    private final void g() {
        p d16 = this.aioContext.d();
        final String str = d16 != null ? d16.f179557e : null;
        if (str == null) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: os2.a
            @Override // java.lang.Runnable
            public final void run() {
                d.h(d.this, str);
            }
        }, 64, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(d this$0, String troopUin) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(troopUin, "$troopUin");
        this$0.u(troopUin);
    }

    private final void i(final String troopUin) {
        IGPSService iGPSService;
        if (QLog.isDebugVersion()) {
            QLog.i("TroopGuildUpgradeDialogHelper", 4, "callRequestServerApi  " + troopUin);
        }
        QQAppInterface j3 = this.aioContext.j();
        if (j3 == null || (iGPSService = (IGPSService) j3.getRuntimeService(IGPSService.class)) == null) {
            return;
        }
        iGPSService.getPopupInfo(Long.parseLong(troopUin), 0, new cs() { // from class: os2.b
            @Override // wh2.cs
            public final void a(int i3, String str, IGProGetPopupInfoRsp iGProGetPopupInfoRsp) {
                d.j(d.this, troopUin, i3, str, iGProGetPopupInfoRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(d this$0, String troopUin, int i3, String str, IGProGetPopupInfoRsp iGProGetPopupInfoRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(troopUin, "$troopUin");
        this$0.t(troopUin, i3);
        if (i3 == 0 && iGProGetPopupInfoRsp != null) {
            QLog.i("TroopGuildUpgradeDialogHelper", 1, "onResult = " + i3);
            ITroopUpgradeUtilsApi iTroopUpgradeUtilsApi = (ITroopUpgradeUtilsApi) QRoute.api(ITroopUpgradeUtilsApi.class);
            Intrinsics.checkNotNullExpressionValue(iTroopUpgradeUtilsApi, "this");
            this$0.v(troopUin, iTroopUpgradeUtilsApi, iGProGetPopupInfoRsp);
            this$0.r(troopUin, iTroopUpgradeUtilsApi, new String[]{iGProGetPopupInfoRsp.getImgUrl(), iGProGetPopupInfoRsp.getGifUrl()});
            return;
        }
        QLog.e("TroopGuildUpgradeDialogHelper", 1, troopUin + " getPopupInfo failed, result = " + i3 + " errMsg = " + str);
    }

    private final boolean k(String troopUin) {
        if (this.hasDialogShown) {
            return false;
        }
        p d16 = this.aioContext.d();
        if (!Intrinsics.areEqual(d16 != null ? d16.f179559f : null, troopUin)) {
            p d17 = this.aioContext.d();
            QLog.i("TroopGuildUpgradeDialogHelper", 1, "troopUin=" + troopUin + ", currentTroopUin=" + (d17 != null ? d17.f179559f : null));
            return false;
        }
        if (this.aioContext.k() == 4) {
            return true;
        }
        QLog.i("TroopGuildUpgradeDialogHelper", 1, "aio isn't resumed, shouldn't show dialog");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TroopInfo m(String troopUin) {
        ITroopInfoService iTroopInfoService;
        QQAppInterface j3 = this.aioContext.j();
        if (j3 == null || (iTroopInfoService = (ITroopInfoService) j3.getRuntimeService(ITroopInfoService.class)) == null) {
            return null;
        }
        return iTroopInfoService.findTroopInfo(troopUin);
    }

    private final boolean o(TroopInfo troopInfo) {
        String currentAccountUin;
        QQAppInterface j3 = this.aioContext.j();
        if (j3 != null && (currentAccountUin = j3.getCurrentAccountUin()) != null) {
            Boolean valueOf = troopInfo != null ? Boolean.valueOf(troopInfo.isOwnerOrAdmin(currentAccountUin)) : null;
            if (valueOf != null) {
                return valueOf.booleanValue();
            }
        }
        return false;
    }

    private final boolean p(String troopUin) {
        return System.currentTimeMillis() - ((ITroopUpgradeUtilsApi) QRoute.api(ITroopUpgradeUtilsApi.class)).lastTimeOfRequestServerForDialog(troopUin) < 86400000;
    }

    private final boolean q(TroopInfo troopInfo) {
        return ((ITroopGuildApi) QRoute.api(ITroopGuildApi.class)).isTroopGuild(troopInfo);
    }

    private final void r(final String troopUin, final ITroopUpgradeUtilsApi upgradeUtilsApi, String[] urls) {
        if (k(troopUin)) {
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
                ((ITroopGuildTempApi) QRoute.api(ITroopGuildTempApi.class)).preDownloadImage(urls, new Runnable() { // from class: os2.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        d.s(d.this, troopUin, upgradeUtilsApi);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(d this$0, String troopUin, ITroopUpgradeUtilsApi upgradeUtilsApi) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(troopUin, "$troopUin");
        Intrinsics.checkNotNullParameter(upgradeUtilsApi, "$upgradeUtilsApi");
        this$0.w(troopUin, upgradeUtilsApi);
    }

    private final void u(String troopUin) {
        if (!((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).isTroopGuildUpgradeSwitchOn()) {
            QLog.i("TroopGuildUpgradeDialogHelper", 1, "requestServerIfNeeded | switch off");
            return;
        }
        TroopInfo m3 = m(troopUin);
        if (o(m3)) {
            if (q(m3)) {
                QLog.i("TroopGuildUpgradeDialogHelper", 1, "requestServerIfNeeded  " + troopUin + " | isTroopGuild");
                return;
            }
            if (p(troopUin)) {
                QLog.i("TroopGuildUpgradeDialogHelper", 1, "requestServerIfNeeded  " + troopUin + " | Time not yet");
                z(troopUin);
                return;
            }
            i(troopUin);
        }
    }

    private final void w(String troopUin, ITroopUpgradeUtilsApi upgradeUtilsApi) {
        if (k(troopUin)) {
            this.hasDialogShown = true;
            upgradeUtilsApi.noteDialogHasShown(troopUin, true);
            upgradeUtilsApi.noteUseRecentCacheToShowDialogPassively(troopUin);
            this.dialogListener.g(false);
            this.dialogListener.f(troopUin);
            FragmentManager supportFragmentManager = this.aioContext.i().getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "aioContext.activity.supportFragmentManager");
            b bVar = this.dialogListener;
            upgradeUtilsApi.showUpgradeGuideDialogInAIO(troopUin, supportFragmentManager, bVar, bVar, this.aioContext.h());
        }
    }

    private final void x(String troopUin) {
        QQAppInterface j3 = this.aioContext.j();
        if (j3 != null) {
            QLog.d("TroopGuildUpgradeDialogHelper", 1, "ShowTroopSettingEntryRedDot " + troopUin);
            ((IRedPointUtilsApi) QRoute.api(IRedPointUtilsApi.class)).updateRedPointInfo(j3, troopUin, "troop", 6, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y(String troopUin) {
        QRouteApi api = QRoute.api(ITroopUpgradeUtilsApi.class);
        ITroopUpgradeUtilsApi iTroopUpgradeUtilsApi = (ITroopUpgradeUtilsApi) api;
        if (!(!iTroopUpgradeUtilsApi.hasTouchRedDotOfTroopUpgrade(troopUin) && iTroopUpgradeUtilsApi.shouldShowTroopUpgradeSetting(this.aioContext.j(), troopUin))) {
            api = null;
        }
        if (((ITroopUpgradeUtilsApi) api) != null) {
            x(troopUin);
        }
    }

    private final void z(String troopUin) {
        QRouteApi api = QRoute.api(ITroopUpgradeUtilsApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(ITroopUpgradeUtilsApi::class.java)");
        ITroopUpgradeUtilsApi iTroopUpgradeUtilsApi = (ITroopUpgradeUtilsApi) api;
        if (!iTroopUpgradeUtilsApi.hasCacheUpgradeDialogUIData(troopUin)) {
            QLog.d("TroopGuildUpgradeDialogHelper", 1, "requestServerIfNeeded " + troopUin + " | no cache");
            return;
        }
        if (iTroopUpgradeUtilsApi.hasUseRecentCacheToShowDialogPassively(troopUin)) {
            QLog.i("TroopGuildUpgradeDialogHelper", 1, "requestServerIfNeeded " + troopUin + " | dialog has shown recently");
            return;
        }
        String[] imageUrlsFromUIDataOf = iTroopUpgradeUtilsApi.getImageUrlsFromUIDataOf(troopUin);
        if (imageUrlsFromUIDataOf != null) {
            r(troopUin, iTroopUpgradeUtilsApi, imageUrlsFromUIDataOf);
        }
    }

    /* renamed from: l, reason: from getter */
    public final a61.a getAioContext() {
        return this.aioContext;
    }

    /* renamed from: n, reason: from getter */
    public final boolean getHasReceivedTroopUpgradeNotification() {
        return this.hasReceivedTroopUpgradeNotification;
    }

    private final void v(String troopUin, ITroopUpgradeUtilsApi upgradeUtilsApi, IGProGetPopupInfoRsp rsp) {
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

    /* compiled from: P */
    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u001a\u0010\t\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016R\"\u0010\u0011\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001a"}, d2 = {"os2/d$b", "Landroid/content/DialogInterface$OnDismissListener;", "Landroid/content/DialogInterface$OnClickListener;", "", "d", "Landroid/content/DialogInterface;", "dialog", "", "which", NodeProps.ON_CLICK, "onDismiss", "", "Z", "getUserClickedConfirm", "()Z", "g", "(Z)V", "userClickedConfirm", "", "e", "Ljava/lang/String;", "getTroopUin", "()Ljava/lang/String;", "f", "(Ljava/lang/String;)V", "troopUin", "qqguild_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
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
                QLog.d("TroopGuildUpgradeDialogHelper", 2, "delay upgrade  " + this$0.troopUin + " | result=" + i3 + ", errMsg=" + str);
            }
        }

        private final void d() {
            IGPSService iGPSService;
            ArrayList<Long> arrayListOf;
            ((ITroopUpgradeUtilsApi) QRoute.api(ITroopUpgradeUtilsApi.class)).noteUserConfirmUpgrade(this.troopUin);
            QQAppInterface j3 = d.this.getAioContext().j();
            if (j3 == null || (iGPSService = (IGPSService) j3.getRuntimeService(IGPSService.class)) == null) {
                return;
            }
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(Long.valueOf(Long.parseLong(this.troopUin)));
            iGPSService.upgradeGroupFeed(arrayListOf, 1, new eq() { // from class: os2.e
                @Override // wh2.eq
                public final void onUpgradeGroupCallback(int i3, String str, ArrayList arrayList) {
                    d.b.e(d.b.this, i3, str, arrayList);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(b this$0, int i3, String str, ArrayList arrayList) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            QLog.d("TroopGuildUpgradeDialogHelper", 1, "now upgrade  " + this$0.troopUin + " | result = " + i3 + ", errMsg = " + str);
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
            IGPSService iGPSService;
            ArrayList<Long> arrayListOf;
            if (this.userClickedConfirm) {
                return;
            }
            QQAppInterface j3 = d.this.getAioContext().j();
            if (j3 != null && (iGPSService = (IGPSService) j3.getRuntimeService(IGPSService.class)) != null) {
                arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(Long.valueOf(Long.parseLong(this.troopUin)));
                iGPSService.upgradeGroupFeed(arrayListOf, 2, new eq() { // from class: os2.f
                    @Override // wh2.eq
                    public final void onUpgradeGroupCallback(int i3, String str, ArrayList arrayList) {
                        d.b.c(d.b.this, i3, str, arrayList);
                    }
                });
            }
            d.this.y(this.troopUin);
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
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J$\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014\u00a8\u0006\f"}, d2 = {"os2/d$c", "Lcom/tencent/mobileqq/troop/api/observer/e;", "", "isSucc", "", "troopUin", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupExt;", "oldTroppInfoExtObj", "a", "b", "", "onGetTroopInfoExtComplete", "qqguild_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class c extends com.tencent.mobileqq.troop.api.observer.e {
        c() {
        }

        private final boolean b() {
            FragmentManager supportFragmentManager;
            List<Fragment> fragments;
            if (PadUtil.a(d.this.getAioContext().i()) == DeviceType.PHONE) {
                return false;
            }
            String name = ((ITroopSettingApi) QRoute.api(ITroopSettingApi.class)).getTroopSettingFragmentClass().getName();
            BaseActivity i3 = d.this.getAioContext().i();
            if (i3 == null || (supportFragmentManager = i3.getSupportFragmentManager()) == null || (fragments = supportFragmentManager.getFragments()) == null) {
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
                    p d16 = d.this.getAioContext().d();
                    if (Intrinsics.areEqual(troopUin, d16 != null ? d16.f179559f : null)) {
                        Long valueOf = oldTroppInfoExtObj != null ? Long.valueOf(oldTroppInfoExtObj.bindGuildId) : null;
                        TroopInfo m3 = d.this.m(troopUin);
                        if (Intrinsics.areEqual(valueOf, m3 != null ? Long.valueOf(m3.getTroopGuildId()) : null)) {
                            return false;
                        }
                        QLog.i("TroopGuildUpgradeDialogHelper", 1, "onReceiveTroopUpgradeNotification");
                        d.this.hasReceivedTroopUpgradeNotification = true;
                        return d.this.getAioContext().k() == 4 && !b();
                    }
                }
            }
            return false;
        }
    }

    private final void t(String troopUin, int retCode) {
        if (retCode == 0 || retCode == -2) {
            ((ITroopUpgradeUtilsApi) QRoute.api(ITroopUpgradeUtilsApi.class)).noteLastTimeOfRequestServerForDialog(troopUin, System.currentTimeMillis());
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.z
    public void onMoveToState(int state) {
        QQAppInterface j3;
        if (state == 4) {
            this.hasDialogShown = false;
            QQAppInterface j16 = this.aioContext.j();
            if (j16 != null) {
                j16.addObserver(this.troopExtInfoObserver);
                return;
            }
            return;
        }
        if (state == 9) {
            g();
        } else if (state == 15 && (j3 = this.aioContext.j()) != null) {
            j3.removeObserver(this.troopExtInfoObserver);
        }
    }
}
