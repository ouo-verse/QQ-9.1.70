package com.tencent.mobileqq.vas.adv.recommendad;

import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.ad.report.api.IAdAttaReporterApi;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.adv.api.IVasAdvApi;
import com.tencent.mobileqq.vas.adv.common.callback.VasAdCallback;
import com.tencent.mobileqq.vas.adv.common.data.VasNewAdParams;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.gdt.access;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\bB\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J(\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0016\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bJ\u001e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002J\u001e\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002R'\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0010j\b\u0012\u0004\u0012\u00020\u0002`\u00118\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/vas/adv/recommendad/f;", "", "", "aid", "posId", "traceId", "action", "", "a", "", "adSecondCategory", "Lcom/tencent/mobileqq/vas/adv/recommendad/f$a;", "callback", "d", "b", "c", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "Ljava/util/HashSet;", "getMExposedRecommendAdCache", "()Ljava/util/HashSet;", "mExposedRecommendAdCache", "<init>", "()V", "vas-adv-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f308307a = new f();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashSet<String> mExposedRecommendAdCache = new HashSet<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/vas/adv/recommendad/f$a;", "", "", "Lcom/tencent/gdtad/aditem/GdtAd;", "recommendAdList", "", "a", "vas-adv-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public interface a {
        void a(@NotNull List<? extends GdtAd> recommendAdList);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/vas/adv/recommendad/f$b", "Lcom/tencent/mobileqq/vas/adv/common/callback/VasAdCallback;", "", "retCode", "Ltencent/gdt/access$AdGetRsp;", "adRsp", "", "msg", "", "onRsp", "vas-adv-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class b implements VasAdCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f308309a;

        b(a aVar) {
            this.f308309a = aVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x002a  */
        /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
        @Override // com.tencent.mobileqq.vas.adv.common.callback.VasAdCallback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onRsp(int retCode, @Nullable access.AdGetRsp adRsp, @NotNull String msg2) {
            List<qq_ad_get.QQAdGetRsp.AdInfo> list;
            qq_ad_get.QQAdGetRsp qQAdGetRsp;
            PBRepeatMessageField<qq_ad_get.QQAdGetRsp.PosAdInfo> pBRepeatMessageField;
            List<qq_ad_get.QQAdGetRsp.PosAdInfo> list2;
            Object firstOrNull;
            PBRepeatMessageField<qq_ad_get.QQAdGetRsp.AdInfo> pBRepeatMessageField2;
            Intrinsics.checkNotNullParameter(msg2, "msg");
            if (adRsp != null && (qQAdGetRsp = adRsp.qq_ad_get_rsp) != null && (pBRepeatMessageField = qQAdGetRsp.pos_ads_info) != null && (list2 = pBRepeatMessageField.get()) != null) {
                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list2);
                qq_ad_get.QQAdGetRsp.PosAdInfo posAdInfo = (qq_ad_get.QQAdGetRsp.PosAdInfo) firstOrNull;
                if (posAdInfo != null && (pBRepeatMessageField2 = posAdInfo.ads_info) != null) {
                    list = pBRepeatMessageField2.get();
                    if (list == null) {
                        a aVar = this.f308309a;
                        ArrayList arrayList = new ArrayList();
                        for (qq_ad_get.QQAdGetRsp.AdInfo adInfo : list) {
                            if (adInfo != null) {
                                Intrinsics.checkNotNullExpressionValue(adInfo, "adInfo");
                                arrayList.add(new GdtAd(adInfo));
                            }
                        }
                        aVar.a(arrayList);
                        return;
                    }
                    return;
                }
            }
            list = null;
            if (list == null) {
            }
        }
    }

    f() {
    }

    private final void a(String aid, String posId, String traceId, String action) {
        HashMap hashMap = new HashMap();
        hashMap.put("ext1", aid);
        hashMap.put("ext2", posId);
        hashMap.put("ext3", traceId);
        ((IAdAttaReporterApi) QRoute.api(IAdAttaReporterApi.class)).report("qzone", "similar_ad", action, hashMap);
    }

    public final void b(@NotNull String aid, @NotNull String posId, @NotNull String traceId) {
        Intrinsics.checkNotNullParameter(aid, "aid");
        Intrinsics.checkNotNullParameter(posId, "posId");
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        a(aid, posId, traceId, "click");
    }

    public final void c(@NotNull String aid, @NotNull String posId, @NotNull String traceId) {
        Intrinsics.checkNotNullParameter(aid, "aid");
        Intrinsics.checkNotNullParameter(posId, "posId");
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        a(aid, posId, traceId, "expo");
    }

    public final void d(int adSecondCategory, @NotNull a callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        VasNewAdParams build = new VasNewAdParams.Builder().build();
        build.getAdvPos().add("1191031734491781");
        build.setBusiType(78);
        build.setAdCount(3);
        build.setAllowedCategory(Integer.valueOf(adSecondCategory));
        ((IVasAdvApi) QRoute.api(IVasAdvApi.class)).requestAd(build, new b(callback));
    }
}
