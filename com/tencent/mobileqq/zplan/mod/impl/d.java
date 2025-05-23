package com.tencent.mobileqq.zplan.mod.impl;

import com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageCollectionMainActivity;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedsdk.impl.controller.QAdCardExtraData;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.data.ZootopiaEnterParams;
import com.tencent.mobileqq.zplan.authorize.api.CheckResultDefaultProcessor;
import com.tencent.mobileqq.zplan.authorize.api.EnterModCheckResult;
import com.tencent.sqshow.zootopia.utils.ag;
import java.util.HashMap;
import java.util.Map;
import k74.i;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import si3.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJi\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00062\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00062#\u0010\u0011\u001a\u001f\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000bH\u0002JS\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00062#\u0010\u0011\u001a\u001f\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000bH\u0016Ji\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00062\u0014\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00062#\u0010\u0011\u001a\u001f\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000bH\u0016R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/zplan/mod/impl/d;", "Lsi3/c;", "", "modId", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "", "", "", "ueParams", QAdCardExtraData.AdExtraInnerKey.AD_EXTRA_KEY_PAGE_PARAMS, "Lkotlin/Function1;", "Lcom/tencent/mobileqq/zplan/authorize/api/EnterModCheckResult;", "Lkotlin/ParameterName;", "name", "checkResult", "", "callback", "V0", "u", "detailParams", "l0", "Lec3/d;", "b", "Lec3/d;", "reportHelper", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class d implements si3.c {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final ec3.d reportHelper = new ec3.d();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/zplan/mod/impl/d$a", "Lsi3/e;", "Lcom/tencent/mobileqq/zplan/authorize/api/EnterModCheckResult;", "checkResult", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a implements e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Map<String, Object> f334758a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Map<String, Object> f334759b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Function1<EnterModCheckResult, Unit> f334760c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ d f334761d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ZootopiaSource f334762e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<String> f334763f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f334764g;

        /* JADX WARN: Multi-variable type inference failed */
        a(Map<String, ? extends Object> map, Map<String, ? extends Object> map2, Function1<? super EnterModCheckResult, Unit> function1, d dVar, ZootopiaSource zootopiaSource, Ref.ObjectRef<String> objectRef, int i3) {
            this.f334758a = map;
            this.f334759b = map2;
            this.f334760c = function1;
            this.f334761d = dVar;
            this.f334762e = zootopiaSource;
            this.f334763f = objectRef;
            this.f334764g = i3;
        }

        @Override // si3.e
        public void a(EnterModCheckResult checkResult) {
            Intrinsics.checkNotNullParameter(checkResult, "checkResult");
            checkResult.setProcessInner(checkResult.getProcessInner() || CheckResultDefaultProcessor.f331386a.c(checkResult, this.f334758a, this.f334759b));
            Function1<EnterModCheckResult, Unit> function1 = this.f334760c;
            if (function1 != null) {
                function1.invoke(checkResult);
            }
            if (checkResult.isPassed()) {
                ec3.d dVar = this.f334761d.reportHelper;
                ZootopiaEnterParams enterParamsAfterCheck = checkResult.getEnterParamsAfterCheck();
                Intrinsics.checkNotNull(enterParamsAfterCheck);
                dVar.g(enterParamsAfterCheck, ag.f373258a.d(this.f334762e), this.f334763f.element);
                return;
            }
            ec3.d dVar2 = this.f334761d.reportHelper;
            ZootopiaEnterParams enterParamsAfterCheck2 = checkResult.getEnterParamsAfterCheck();
            if (enterParamsAfterCheck2 == null) {
                enterParamsAfterCheck2 = ZootopiaEnterParams.INSTANCE.a(this.f334764g, "");
            }
            dVar2.f(enterParamsAfterCheck2, ag.f373258a.d(this.f334762e), checkResult.getResultCode(), "check failed", this.f334763f.element);
            ((qk3.a) i.INSTANCE.a(qk3.a.class)).clear();
        }
    }

    @Override // si3.c
    public void l0(int modId, ZootopiaSource source, Map<String, ? extends Object> ueParams, Map<String, ? extends Object> detailParams, Function1<? super EnterModCheckResult, Unit> callback) {
        Intrinsics.checkNotNullParameter(source, "source");
        V0(modId, source, ueParams, detailParams, callback);
    }

    @Override // si3.c
    public void u(int modId, ZootopiaSource source, Map<String, ? extends Object> ueParams, Function1<? super EnterModCheckResult, Unit> callback) {
        Intrinsics.checkNotNullParameter(source, "source");
        V0(modId, source, ueParams, null, callback);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [T, java.lang.String] */
    private final void V0(int modId, ZootopiaSource source, Map<String, ? extends Object> ueParams, Map<String, ? extends Object> pageParams, Function1<? super EnterModCheckResult, Unit> callback) {
        Object obj;
        Object obj2;
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = "0";
        if (ueParams != null && (obj2 = ueParams.get(IPublicAccountImageCollectionMainActivity.CLICK_SOURCE)) != null) {
            objectRef.element = obj2.toString();
        }
        com.tencent.mobileqq.zootopia.ueloading.report.b.f329531a.v(modId, (String) objectRef.element);
        Object obj3 = ueParams != null ? ueParams.get("skipRedirect") : null;
        boolean booleanValue = obj3 instanceof Boolean ? ((Boolean) obj3).booleanValue() : false;
        HashMap hashMap = new HashMap();
        if (ueParams != null) {
            hashMap.putAll(ueParams);
        }
        if (pageParams != null && (obj = pageParams.get("serverExtraInfo")) != null) {
            hashMap.put("serverExtraInfo", obj);
        }
        ((si3.d) i.INSTANCE.a(si3.d.class)).startMod(modId, source, booleanValue, hashMap, new a(pageParams, ueParams, callback, this, source, objectRef, modId));
    }
}
