package com.tencent.mobileqq.vas.adv.kuikly.cardad;

import android.text.TextUtils;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.util.SsoReporter;
import com.tencent.mobileqq.ad.api.IAdApi;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vas.adv.api.IVasAdvApi;
import com.tencent.mobileqq.vas.adv.common.callback.VasAdCallback;
import com.tencent.mobileqq.vas.adv.common.data.MaskAdvName;
import com.tencent.mobileqq.vas.adv.common.data.VasNewAdParams;
import com.tencent.mobileqq.vas.adv.maskad.MaskAdLoadHelper;
import com.tencent.mobileqq.vas.adv.preload.api.IVasMaskAdvPreloadApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.request.GetAdInfoRequest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.gdt.access;
import tencent.gdt.qq_ad_get;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b<\u0010=J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\u000bH\u0002J\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u000e\u001a\u00020\u0004H\u0002J\u001e\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tJ*\u0010\u0018\u001a\u00020\u000b2\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u0004J\u0016\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0019J\u0016\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tJ\u0016\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001dJ\u000e\u0010 \u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002J\"\u0010\"\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u0004J\u0010\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010%\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u0002J \u0010)\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020\u00152\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010(\u001a\u00020'R\"\u00100\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u0016\u00102\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u00101R\u0016\u00103\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u00101R2\u00107\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000f04j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000f`58\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u00106R \u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u000209088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010:\u00a8\u0006>"}, d2 = {"Lcom/tencent/mobileqq/vas/adv/kuikly/cardad/VasKuiklyCardAdManager;", "", "", "index", "", "posId", "Lcom/tencent/mobileqq/vas/adv/common/callback/VasAdCallback;", "f", "advCallback", "Lcom/tencent/mobileqq/vas/adv/kuikly/cardad/d;", "reqParams", "", "r", "e", "pageName", "Lcom/tencent/mobileqq/vas/adv/kuikly/cardad/c;", "j", "adIndex", "g", "", "posIds", "", "enableShowMask", GetAdInfoRequest.SOURCE_FROM, "d", "Ltencent/gdt/access$AdGetRsp;", "adRsp", "t", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/vas/adv/kuikly/cardad/VasKuiklyCardAdView;", "kuiklyCardAdView", "c", "o", "event", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/gdtad/aditem/GdtAd;", h.F, "l", "isAsyncRequest", "", "time", "p", "b", "Z", "i", "()Z", ReportConstant.COSTREPORT_PREFIX, "(Z)V", "hasCheckedShowMaskAd", "Ljava/lang/String;", "mCurrentPageName", "mLastPageName", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "mPageToModelMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mobileqq/vas/adv/kuikly/cardad/a;", "Ljava/util/concurrent/ConcurrentHashMap;", "mAsyncCardAdMap", "<init>", "()V", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class VasKuiklyCardAdManager {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean hasCheckedShowMaskAd;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final VasKuiklyCardAdManager f308031a = new VasKuiklyCardAdManager();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String mCurrentPageName = "default_page";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String mLastPageName = "default_page";

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static HashMap<String, c> mPageToModelMap = new HashMap<>();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<Integer, AsyncCardAdRequest> mAsyncCardAdMap = new ConcurrentHashMap<>();

    VasKuiklyCardAdManager() {
    }

    private final void e() {
        mAsyncCardAdMap.clear();
        hasCheckedShowMaskAd = false;
        com.tencent.mobileqq.ad.cardad.utils.b.f186729a.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final VasAdCallback f(final int index, final String posId) {
        final long currentTimeMillis = System.currentTimeMillis();
        return new VasAdCallback() { // from class: com.tencent.mobileqq.vas.adv.kuikly.cardad.VasKuiklyCardAdManager$createAsyncRequestCallback$1
            @Override // com.tencent.mobileqq.vas.adv.common.callback.VasAdCallback
            public void onRsp(int retCode, @Nullable access.AdGetRsp adRsp, @NotNull String msg2) {
                boolean z16;
                List<qq_ad_get.QQAdGetRsp.PosAdInfo> list;
                PBRepeatMessageField<qq_ad_get.QQAdGetRsp.PosAdInfo> pBRepeatMessageField;
                PBRepeatMessageField<qq_ad_get.QQAdGetRsp.PosAdInfo> pBRepeatMessageField2;
                Intrinsics.checkNotNullParameter(msg2, "msg");
                if (retCode == 0 && adRsp != null) {
                    qq_ad_get.QQAdGetRsp qQAdGetRsp = adRsp.qq_ad_get_rsp;
                    if (qQAdGetRsp != null && (pBRepeatMessageField2 = qQAdGetRsp.pos_ads_info) != null && !pBRepeatMessageField2.has()) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (!z16) {
                        final qq_ad_get.QQAdGetRsp.AdInfo adInfo = null;
                        c k3 = VasKuiklyCardAdManager.k(VasKuiklyCardAdManager.f308031a, null, 1, null);
                        if (k3 != null) {
                            k3.o(index, adRsp);
                        }
                        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new VasKuiklyCardAdManager$createAsyncRequestCallback$1$onRsp$2$1(posId, System.currentTimeMillis() - currentTimeMillis, null), 3, null);
                        try {
                            qq_ad_get.QQAdGetRsp qQAdGetRsp2 = adRsp.qq_ad_get_rsp;
                            if (qQAdGetRsp2 != null && (pBRepeatMessageField = qQAdGetRsp2.pos_ads_info) != null) {
                                list = pBRepeatMessageField.get();
                            } else {
                                list = null;
                            }
                            if (list == null) {
                                return;
                            }
                            Iterator<qq_ad_get.QQAdGetRsp.PosAdInfo> it = list.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                qq_ad_get.QQAdGetRsp.PosAdInfo next = it.next();
                                if (next.has() && !next.ads_info.get().isEmpty()) {
                                    adInfo = next.ads_info.get().get(0);
                                    break;
                                }
                                QLog.d("VasKuiklyCardAdManager", 2, "adInfo inValid\uff0cpos_id is" + next.pos_id.get());
                            }
                            com.tencent.mobileqq.ad.cardad.utils.d dVar = com.tencent.mobileqq.ad.cardad.utils.d.f186735a;
                            final int i3 = index;
                            dVar.h(new Function0<Unit>() { // from class: com.tencent.mobileqq.vas.adv.kuikly.cardad.VasKuiklyCardAdManager$createAsyncRequestCallback$1$onRsp$3
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
                                /* JADX WARN: Removed duplicated region for block: B:7:0x0027  */
                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                /*
                                    Code decompiled incorrectly, please refer to instructions dump.
                                */
                                public final void invoke2() {
                                    AsyncCardAdRequest asyncCardAdRequest;
                                    ConcurrentHashMap concurrentHashMap;
                                    qq_ad_get.QQAdGetRsp.AdInfo adInfo2 = qq_ad_get.QQAdGetRsp.AdInfo.this;
                                    if (adInfo2 != null) {
                                        int i16 = i3;
                                        concurrentHashMap = VasKuiklyCardAdManager.mAsyncCardAdMap;
                                        asyncCardAdRequest = (AsyncCardAdRequest) concurrentHashMap.get(Integer.valueOf(i16));
                                        if (asyncCardAdRequest != null) {
                                            asyncCardAdRequest.b(true);
                                            asyncCardAdRequest.c(new GdtAd(adInfo2));
                                            if (asyncCardAdRequest == null) {
                                                int i17 = i3;
                                                c k16 = VasKuiklyCardAdManager.k(VasKuiklyCardAdManager.f308031a, null, 1, null);
                                                if (k16 != null) {
                                                    k16.c(i17);
                                                    return;
                                                }
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                    asyncCardAdRequest = null;
                                    if (asyncCardAdRequest == null) {
                                    }
                                }
                            });
                            return;
                        } catch (Throwable th5) {
                            QLog.e("VasKuiklyCardAdManager", 1, "onAdRsp parse ad error:", th5);
                            return;
                        }
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.d("VasKuiklyCardAdManager", 2, "async ad rsp failed");
                }
                com.tencent.mobileqq.ad.cardad.utils.d dVar2 = com.tencent.mobileqq.ad.cardad.utils.d.f186735a;
                final int i16 = index;
                dVar2.h(new Function0<Unit>() { // from class: com.tencent.mobileqq.vas.adv.kuikly.cardad.VasKuiklyCardAdManager$createAsyncRequestCallback$1$onRsp$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        ConcurrentHashMap concurrentHashMap;
                        concurrentHashMap = VasKuiklyCardAdManager.mAsyncCardAdMap;
                        concurrentHashMap.remove(Integer.valueOf(i16));
                        c k16 = VasKuiklyCardAdManager.k(VasKuiklyCardAdManager.f308031a, null, 1, null);
                        if (k16 != null) {
                            k16.b(i16);
                        }
                    }
                });
            }
        };
    }

    private final c j(String pageName) {
        if (!mPageToModelMap.containsKey(pageName)) {
            mPageToModelMap.put(pageName, new c(pageName));
        }
        return mPageToModelMap.get(pageName);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ c k(VasKuiklyCardAdManager vasKuiklyCardAdManager, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = mCurrentPageName;
        }
        return vasKuiklyCardAdManager.j(str);
    }

    public static /* synthetic */ void n(VasKuiklyCardAdManager vasKuiklyCardAdManager, int i3, int i16, String str, int i17, Object obj) {
        if ((i17 & 2) != 0) {
            i16 = -1;
        }
        if ((i17 & 4) != 0) {
            str = "";
        }
        vasKuiklyCardAdManager.m(i3, i16, str);
    }

    private final void r(VasAdCallback advCallback, VasKuiklyCardAdReqParams reqParams) {
        QLog.d("VasKuiklyCardAdManager", 1, "requestNormalAd");
        IVasAdvApi iVasAdvApi = (IVasAdvApi) QRoute.api(IVasAdvApi.class);
        VasNewAdParams build = new VasNewAdParams.Builder().build();
        String posId = reqParams.getPosId();
        if (posId != null) {
            build.getAdvPos().add(posId);
        }
        build.setUin(MaskAdLoadHelper.INSTANCE.getCurrentUin());
        build.setBusiType(Integer.valueOf(com.tencent.mobileqq.vas.adv.api.impl.b.f307952a.a(reqParams.getPosId(), reqParams.getBusiType())));
        build.setExtIds(reqParams.c());
        iVasAdvApi.requestAd(build, advCallback);
    }

    public final void c(int index, @NotNull VasKuiklyCardAdView kuiklyCardAdView) {
        Intrinsics.checkNotNullParameter(kuiklyCardAdView, "kuiklyCardAdView");
        QLog.d("VasKuiklyCardAdManager", 1, "addToNotifyView:", Integer.valueOf(index));
        c k3 = k(this, null, 1, null);
        if (k3 != null) {
            k3.a(index, kuiklyCardAdView);
        }
    }

    public final void d(@Nullable List<String> posIds, boolean enableShowMask, @NotNull String sourceFrom) {
        boolean z16;
        Intrinsics.checkNotNullParameter(sourceFrom, "sourceFrom");
        List<String> list = posIds;
        int i3 = 0;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        for (Object obj : posIds) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            String str = (String) obj;
            mAsyncCardAdMap.put(Integer.valueOf(i3), new AsyncCardAdRequest(str, false, null, 6, null));
            if (TextUtils.equals(str, "1082214467882419")) {
                mCurrentPageName = "QQSport";
            }
            i3 = i16;
        }
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new VasKuiklyCardAdManager$asyncRequestKuiklyCardAd$2(posIds, enableShowMask, sourceFrom, null), 3, null);
    }

    public final void g(int adIndex, @NotNull VasAdCallback advCallback, @NotNull VasKuiklyCardAdReqParams reqParams) {
        access.AdGetRsp adGetRsp;
        Intrinsics.checkNotNullParameter(advCallback, "advCallback");
        Intrinsics.checkNotNullParameter(reqParams, "reqParams");
        QLog.d("VasKuiklyCardAdManager", 1, "getAd adIndex:", Integer.valueOf(adIndex));
        if (mPageToModelMap.containsKey(mCurrentPageName)) {
            c cVar = mPageToModelMap.get(mCurrentPageName);
            if (cVar != null) {
                adGetRsp = cVar.e(adIndex);
            } else {
                adGetRsp = null;
            }
            if (adGetRsp != null) {
                advCallback.onRsp(0, adGetRsp, "");
                return;
            } else {
                q(advCallback, reqParams);
                return;
            }
        }
        mPageToModelMap.put(mCurrentPageName, new c(mCurrentPageName));
        q(advCallback, reqParams);
    }

    @Nullable
    public final GdtAd h(int index) {
        AsyncCardAdRequest asyncCardAdRequest = mAsyncCardAdMap.get(Integer.valueOf(index));
        if (asyncCardAdRequest != null) {
            return asyncCardAdRequest.getResult();
        }
        return null;
    }

    public final boolean i() {
        return hasCheckedShowMaskAd;
    }

    public final boolean l(int index) {
        return mAsyncCardAdMap.containsKey(Integer.valueOf(index));
    }

    public final void m(int event, int adIndex, @NotNull String pageName) {
        Intrinsics.checkNotNullParameter(pageName, "pageName");
        switch (event) {
            case 1:
                if (!TextUtils.isEmpty(pageName)) {
                    mCurrentPageName = pageName;
                }
                c k3 = k(this, null, 1, null);
                if (k3 != null) {
                    k3.i();
                    return;
                }
                return;
            case 2:
                if (TextUtils.isEmpty(pageName)) {
                    pageName = mCurrentPageName;
                }
                c j3 = j(pageName);
                if (j3 != null) {
                    j3.j();
                }
                e();
                return;
            case 3:
                if (!TextUtils.isEmpty(pageName)) {
                    mCurrentPageName = pageName;
                }
                c k16 = k(this, null, 1, null);
                if (k16 != null) {
                    k16.h();
                    return;
                }
                return;
            case 4:
                mLastPageName = mCurrentPageName;
                c k17 = k(this, null, 1, null);
                if (k17 != null) {
                    k17.k();
                    return;
                }
                return;
            case 5:
                c k18 = k(this, null, 1, null);
                if (k18 != null) {
                    k18.g();
                    return;
                }
                return;
            case 6:
                c k19 = k(this, null, 1, null);
                if (k19 != null) {
                    k19.l(adIndex);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void o(int index) {
        boolean z16;
        if (!TextUtils.equals(mLastPageName, mCurrentPageName)) {
            c j3 = j(mLastPageName);
            if (j3 != null && !j3.m()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                QLog.d("VasKuiklyCardAdManager", 1, "removeFromNotifyView:", Integer.valueOf(index), ",", mLastPageName);
                c j16 = j(mLastPageName);
                if (j16 != null) {
                    j16.n(index);
                    return;
                }
                return;
            }
        }
        QLog.d("VasKuiklyCardAdManager", 1, "removeFromNotifyView:", Integer.valueOf(index), ",", mCurrentPageName);
        c k3 = k(this, null, 1, null);
        if (k3 != null) {
            k3.n(index);
        }
    }

    public final void p(boolean isAsyncRequest, @Nullable String posId, long time) {
        String str;
        Map<String, String> mapOf;
        QLog.i("VasKuiklyCardAdManager", 1, "isAsyncRequest: " + isAsyncRequest + ", posId: " + posId + ", cost: " + time + "ms");
        IAdApi iAdApi = (IAdApi) QRoute.api(IAdApi.class);
        Pair[] pairArr = new Pair[3];
        if (isAsyncRequest) {
            str = "1";
        } else {
            str = "0";
        }
        pairArr[0] = TuplesKt.to("is_async", str);
        if (posId == null) {
            posId = "";
        }
        pairArr[1] = TuplesKt.to(SsoReporter.POS_ID_KEY, posId);
        pairArr[2] = TuplesKt.to("cost_time", String.valueOf(time));
        mapOf = MapsKt__MapsKt.mapOf(pairArr);
        iAdApi.report("card_ad_request_time_cost", mapOf);
    }

    public final void q(@NotNull VasAdCallback advCallback, @NotNull VasKuiklyCardAdReqParams reqParams) {
        Intrinsics.checkNotNullParameter(advCallback, "advCallback");
        Intrinsics.checkNotNullParameter(reqParams, "reqParams");
        if (reqParams.getEnableShowMask() && !TextUtils.isEmpty(reqParams.getPosId()) && TextUtils.equals(reqParams.getPosId(), "1082214467882419")) {
            String healthPosId = ((IVasMaskAdvPreloadApi) QRoute.api(IVasMaskAdvPreloadApi.class)).getHealthPosId();
            String healthTianShuPosId = ((IVasMaskAdvPreloadApi) QRoute.api(IVasMaskAdvPreloadApi.class)).getHealthTianShuPosId();
            boolean a16 = com.tencent.mobileqq.vas.adv.maskad.a.f308093a.a();
            QLog.d("VasKuiklyCardAdManager", 1, "requestMaskAd QQHealth");
            vz2.b.f443772a.d(advCallback, healthPosId, healthTianShuPosId, reqParams.getSourceFrom(), MaskAdvName.QQ_HEALTH, a16);
            return;
        }
        if (reqParams.getEnableShowMask() && !TextUtils.isEmpty(reqParams.getPosId()) && TextUtils.equals(reqParams.getPosId(), "7085109922408095")) {
            QLog.d("VasKuiklyCardAdManager", 1, "requestMaskAd QQShop");
            vz2.b.e(vz2.b.f443772a, advCallback, "7085109922408095", "", reqParams.getSourceFrom(), MaskAdvName.QQ_SHOP, false, 32, null);
        } else {
            r(advCallback, reqParams);
        }
    }

    public final void s(boolean z16) {
        hasCheckedShowMaskAd = z16;
    }

    public final void t(int adIndex, @NotNull access.AdGetRsp adRsp) {
        Intrinsics.checkNotNullParameter(adRsp, "adRsp");
        QLog.d("VasKuiklyCardAdManager", 1, "updateAd adIndex:", Integer.valueOf(adIndex));
        c k3 = k(this, null, 1, null);
        if (k3 != null) {
            k3.o(adIndex, adRsp);
        }
    }
}
