package cooperation.vip.ad.processors;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.hippy.qq.api.IHippyMessageTabAd;
import com.tencent.mobileqq.activity.home.chats.biz.tianshu.TianShuConversationThirdView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.data.TianShuAdPosItemData;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.ad.GrowHalfLayerHelper;
import cooperation.vip.ad.GrowHalfLayerTechReporter;
import cooperation.vip.ad.TianshuBigInsertPage;
import cooperation.vip.ad.TianshuPendantHolder;
import cooperation.vip.ad.processors.a;
import cooperation.vip.ad.y;
import cooperation.vip.pb.TianShuAccess;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 A2\u00020\u0001:\u0001BB\u0007\u00a2\u0006\u0004\b?\u0010@J$\u0010\t\u001a\u00020\b2\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0013\u001a\u00020\u0003H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J4\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u00192\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0003H\u0016J\b\u0010\u001d\u001a\u00020\u0017H\u0016J\u0010\u0010 \u001a\u00020\b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eJ\u0006\u0010!\u001a\u00020\bJ\b\u0010\"\u001a\u00020\bH\u0016J\b\u0010#\u001a\u00020\bH\u0016R\u0018\u0010&\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010%R\u0018\u0010)\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010(R\u0018\u0010,\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010+R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u00101R$\u00108\u001a\u0004\u0018\u0001028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\"\u0010;\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>\u00a8\u0006C"}, d2 = {"Lcooperation/vip/ad/processors/h;", "Lcooperation/vip/ad/processors/a;", "", "", "Lcooperation/vip/pb/TianShuAccess$RspEntry;", "mapEntries", "", "traceId", "", "l", "Lcooperation/vip/pb/TianShuAccess$AdItem;", "adItem", "o", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "r", DomainData.DOMAIN_NAME, "p", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "time", "", "Lcom/tencent/mobileqq/tianshu/data/TianShuAdPosItemData;", "d", "", "f", "Lcooperation/vip/pb/TianShuAccess$GetAdsRsp;", "getAdsRsp", InnerAudioPlugin.AUDIO_PROPERTY_CURRENTTIME, "i", "e", "Lcom/tencent/mobileqq/activity/home/chats/biz/tianshu/TianShuConversationThirdView;", "thirdView", "u", "k", "onAccountChange", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcooperation/vip/ad/TianshuBigInsertPage;", "Lcooperation/vip/ad/TianshuBigInsertPage;", "tianshuBigInsertPage", "Lcooperation/vip/ad/k;", "Lcooperation/vip/ad/k;", "tianshuBreathLight", "Lcooperation/vip/ad/TianshuPendantHolder;", "Lcooperation/vip/ad/TianshuPendantHolder;", "tianshuPendantHolder", "Lcooperation/vip/ad/y;", tl.h.F, "Lcooperation/vip/ad/y;", "userLeadingDialogHelper", "Lcom/tencent/mobileqq/activity/home/chats/biz/tianshu/TianShuConversationThirdView;", "Landroid/app/Activity;", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", ReportConstant.COSTREPORT_PREFIX, "(Landroid/app/Activity;)V", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, BdhLogUtil.LogTag.Tag_Conn, "Z", "isContainerShowing", "()Z", "t", "(Z)V", "<init>", "()V", "D", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes28.dex */
public final class h implements a {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean isContainerShowing;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TianshuBigInsertPage tianshuBigInsertPage;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private cooperation.vip.ad.k tianshuBreathLight;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TianshuPendantHolder tianshuPendantHolder;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private y userLeadingDialogHelper;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TianShuConversationThirdView thirdView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Activity activity;

    private final void l(Map<Integer, TianShuAccess.RspEntry> mapEntries, String traceId) {
        TianShuAccess.AdItem adItem;
        TianShuAccess.AdPlacementInfo adPlacementInfo;
        PBRepeatMessageField<TianShuAccess.AdItem> pBRepeatMessageField;
        List<TianShuAccess.AdItem> list;
        Object orNull;
        TianShuAccess.RspEntry rspEntry = mapEntries.get(973);
        if (rspEntry != null) {
            GrowHalfLayerTechReporter.i(traceId);
        }
        if (rspEntry != null && (adPlacementInfo = rspEntry.value) != null && (pBRepeatMessageField = adPlacementInfo.lst) != null && (list = pBRepeatMessageField.get()) != null) {
            orNull = CollectionsKt___CollectionsKt.getOrNull(list, 0);
            adItem = (TianShuAccess.AdItem) orNull;
        } else {
            adItem = null;
        }
        if (adItem != null) {
            int m3 = m(adItem);
            if (m3 != 1) {
                if (m3 != 2) {
                    QLog.d("TianshuCommonAdProcessor", 1, "handleBusinessEntries  | UserLeading.adId = " + adItem.iAdId.get());
                    q(adItem);
                    return;
                }
                GrowHalfLayerHelper.g(adItem, this.activity, traceId, 973);
                return;
            }
            QLog.d("TianshuCommonAdProcessor", 1, "handleBusinessEntries  | HippyMessageTabAd.adId = " + adItem.iAdId.get());
            ((IHippyMessageTabAd) QRoute.api(IHippyMessageTabAd.class)).handleMessageTabAd(adItem);
        }
    }

    private final int m(TianShuAccess.AdItem adItem) {
        if (adItem.argList.get() == null) {
            return 0;
        }
        Iterator<TianShuAccess.MapEntry> it = adItem.argList.get().iterator();
        while (it.hasNext()) {
            TianShuAccess.MapEntry next = it.next();
            String str = next.key.get();
            String value = next.value.get();
            if (Intrinsics.areEqual("type", str)) {
                if (TextUtils.isEmpty(value)) {
                    return 0;
                }
                try {
                    Intrinsics.checkNotNullExpressionValue(value, "value");
                    return Integer.parseInt(value);
                } catch (NumberFormatException e16) {
                    QLog.e("TianshuCommonAdProcessor", 1, "getUserLeadingDialogType e:", e16);
                }
            }
        }
        return 0;
    }

    private final void n(TianShuAccess.AdItem adItem) {
        if (!r()) {
            return;
        }
        if (this.tianshuBigInsertPage == null) {
            this.tianshuBigInsertPage = new TianshuBigInsertPage(this.activity);
        }
        TianshuBigInsertPage tianshuBigInsertPage = this.tianshuBigInsertPage;
        if (tianshuBigInsertPage != null) {
            tianshuBigInsertPage.l(adItem);
        }
    }

    private final void o(TianShuAccess.AdItem adItem) {
        TianShuConversationThirdView tianShuConversationThirdView = this.thirdView;
        if (tianShuConversationThirdView != null) {
            if (this.tianshuBreathLight == null) {
                cooperation.vip.ad.k kVar = new cooperation.vip.ad.k(tianShuConversationThirdView);
                this.tianshuBreathLight = kVar;
                kVar.n();
            }
            cooperation.vip.ad.k kVar2 = this.tianshuBreathLight;
            if (kVar2 != null) {
                kVar2.o(adItem);
            }
            TianShuConversationThirdView tianShuConversationThirdView2 = this.thirdView;
            if (tianShuConversationThirdView2 != null) {
                tianShuConversationThirdView2.e(this.tianshuBreathLight);
            }
        }
    }

    private final void p(TianShuAccess.AdItem adItem) {
        if (this.thirdView != null) {
            if (this.tianshuPendantHolder == null) {
                this.tianshuPendantHolder = new TianshuPendantHolder(cooperation.vip.ad.i.b(), this.thirdView);
            }
            TianshuPendantHolder tianshuPendantHolder = this.tianshuPendantHolder;
            if (tianshuPendantHolder != null) {
                tianshuPendantHolder.r();
            }
            TianshuPendantHolder tianshuPendantHolder2 = this.tianshuPendantHolder;
            if (tianshuPendantHolder2 != null) {
                tianshuPendantHolder2.u(adItem);
            }
            TianShuConversationThirdView tianShuConversationThirdView = this.thirdView;
            if (tianShuConversationThirdView != null) {
                tianShuConversationThirdView.setPendantHolder(this.tianshuPendantHolder);
            }
            TianShuConversationThirdView tianShuConversationThirdView2 = this.thirdView;
            if (tianShuConversationThirdView2 != null) {
                tianShuConversationThirdView2.setOnPendentClickListener(this.tianshuPendantHolder);
            }
        }
    }

    private final void q(TianShuAccess.AdItem adItem) {
        if (!r()) {
            return;
        }
        y yVar = new y(adItem, cooperation.vip.ad.i.b(), this.activity);
        this.userLeadingDialogHelper = yVar;
        yVar.showLayer(this.activity);
    }

    private final boolean r() {
        boolean h16 = GrowHalfLayerHelper.h();
        QLog.d("TianshuCommonAdProcessor", 1, "isConversationVisible , isConversationVisible = " + h16);
        return h16;
    }

    @Override // cooperation.vip.ad.processors.a
    public int a() {
        return a.C10126a.h(this);
    }

    @Override // cooperation.vip.ad.processors.a
    public void b(int i3) {
        a.C10126a.a(this, i3);
    }

    @Override // cooperation.vip.ad.processors.a
    public boolean c(int i3) {
        return a.C10126a.e(this, i3);
    }

    @Override // cooperation.vip.ad.processors.a
    @NotNull
    public List<TianShuAdPosItemData> d(int time) {
        ArrayList arrayList = new ArrayList();
        if (this.activity != null && this.thirdView != null) {
            arrayList.addAll(cooperation.vip.ad.i.f());
            if (!this.isContainerShowing && !GrowHalfLayerHelper.w(this.activity)) {
                arrayList.add(cooperation.vip.ad.i.d());
            }
            return arrayList;
        }
        QLog.i("TianshuCommonAdProcessor", 2, "sendTianshuAdRequest mActivity is null");
        return arrayList;
    }

    @Override // cooperation.vip.ad.processors.a
    @NotNull
    public int[] e() {
        return new int[]{4, 1, 3, 2, 99};
    }

    @Override // cooperation.vip.ad.processors.a
    @NotNull
    public int[] f() {
        return new int[]{339, 340, 341, 973};
    }

    @Override // cooperation.vip.ad.processors.a
    public void g(long j3) {
        a.C10126a.i(this, j3);
    }

    @Override // cooperation.vip.ad.processors.a
    public boolean h(int i3) {
        return a.C10126a.d(this, i3);
    }

    @Override // cooperation.vip.ad.processors.a
    public void i(@NotNull TianShuAccess.GetAdsRsp getAdsRsp, @NotNull Map<Integer, TianShuAccess.RspEntry> mapEntries, @NotNull String traceId, int currentTime) {
        TianShuAccess.AdItem adItem;
        TianShuAccess.AdItem adItem2;
        com.tencent.mobileqq.armap.d dVar;
        TianShuAccess.AdPlacementInfo adPlacementInfo;
        PBRepeatMessageField<TianShuAccess.AdItem> pBRepeatMessageField;
        List<TianShuAccess.AdItem> list;
        Object orNull;
        TianShuAccess.AdPlacementInfo adPlacementInfo2;
        PBRepeatMessageField<TianShuAccess.AdItem> pBRepeatMessageField2;
        List<TianShuAccess.AdItem> list2;
        Object orNull2;
        TianShuAccess.AdPlacementInfo adPlacementInfo3;
        PBRepeatMessageField<TianShuAccess.AdItem> pBRepeatMessageField3;
        List<TianShuAccess.AdItem> list3;
        Object orNull3;
        Intrinsics.checkNotNullParameter(getAdsRsp, "getAdsRsp");
        Intrinsics.checkNotNullParameter(mapEntries, "mapEntries");
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        TianShuAccess.RspEntry rspEntry = mapEntries.get(340);
        TianShuAccess.AdItem adItem3 = null;
        if (rspEntry != null && (adPlacementInfo3 = rspEntry.value) != null && (pBRepeatMessageField3 = adPlacementInfo3.lst) != null && (list3 = pBRepeatMessageField3.get()) != null) {
            orNull3 = CollectionsKt___CollectionsKt.getOrNull(list3, 0);
            adItem = (TianShuAccess.AdItem) orNull3;
        } else {
            adItem = null;
        }
        if (adItem != null) {
            QLog.d("TianshuCommonAdProcessor", 1, "handleBusinessEntries | bigInsertPage.adId = " + adItem.iAdId);
            n(adItem);
        }
        TianShuAccess.RspEntry rspEntry2 = mapEntries.get(341);
        if (rspEntry2 != null && (adPlacementInfo2 = rspEntry2.value) != null && (pBRepeatMessageField2 = adPlacementInfo2.lst) != null && (list2 = pBRepeatMessageField2.get()) != null) {
            orNull2 = CollectionsKt___CollectionsKt.getOrNull(list2, 0);
            adItem2 = (TianShuAccess.AdItem) orNull2;
        } else {
            adItem2 = null;
        }
        if (adItem2 != null) {
            QLog.d("TianshuCommonAdProcessor", 1, "handleBusinessEntries | PendantHolder.adId = " + adItem2.iAdId.get());
            p(adItem2);
        }
        TianShuConversationThirdView tianShuConversationThirdView = this.thirdView;
        if (tianShuConversationThirdView != null) {
            if (tianShuConversationThirdView != null) {
                dVar = tianShuConversationThirdView.f182983h;
            } else {
                dVar = null;
            }
            if (dVar == null) {
                TianShuAccess.RspEntry rspEntry3 = mapEntries.get(339);
                if (rspEntry3 != null && (adPlacementInfo = rspEntry3.value) != null && (pBRepeatMessageField = adPlacementInfo.lst) != null && (list = pBRepeatMessageField.get()) != null) {
                    orNull = CollectionsKt___CollectionsKt.getOrNull(list, 0);
                    adItem3 = (TianShuAccess.AdItem) orNull;
                }
                if (adItem3 != null) {
                    QLog.d("TianshuCommonAdProcessor", 1, "handleBusinessEntries BreathLight.adId = " + adItem3.iAdId.get());
                    o(adItem3);
                }
            }
        }
        l(mapEntries, traceId);
    }

    @Override // cooperation.vip.ad.processors.a
    public long j() {
        return a.C10126a.b(this);
    }

    public final void k() {
        TianShuConversationThirdView tianShuConversationThirdView = this.thirdView;
        if (tianShuConversationThirdView != null) {
            tianShuConversationThirdView.setPendantHolder(null);
        }
    }

    @Override // cooperation.vip.ad.processors.a
    public void onAccountChange() {
        TianShuConversationThirdView tianShuConversationThirdView = this.thirdView;
        if (tianShuConversationThirdView != null) {
            tianShuConversationThirdView.setPendantHolder(null);
        }
        TianShuConversationThirdView tianShuConversationThirdView2 = this.thirdView;
        if (tianShuConversationThirdView2 != null) {
            tianShuConversationThirdView2.c();
        }
        TianShuConversationThirdView tianShuConversationThirdView3 = this.thirdView;
        if (tianShuConversationThirdView3 != null) {
            tianShuConversationThirdView3.setOnPendentClickListener(null);
        }
        this.tianshuBreathLight = null;
        this.tianshuPendantHolder = null;
        this.userLeadingDialogHelper = null;
    }

    @Override // cooperation.vip.ad.processors.a
    public void onDestroy() {
        a.C10126a.g(this);
        y yVar = this.userLeadingDialogHelper;
        if (yVar != null) {
            yVar.onDestroy();
        }
        this.userLeadingDialogHelper = null;
    }

    public final void s(@Nullable Activity activity) {
        this.activity = activity;
    }

    public final void t(boolean z16) {
        this.isContainerShowing = z16;
    }

    public final void u(@Nullable TianShuConversationThirdView thirdView) {
        this.thirdView = thirdView;
    }
}
