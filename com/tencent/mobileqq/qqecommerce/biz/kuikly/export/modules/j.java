package com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.hippy.qq.utils.AttaReporter;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.container.QQKuiklyRenderView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.http.api.IHttpService;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0003B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0002J?\u0010\r\u001a\u00020\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u000bH\u0002JI\u0010\u000f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000e\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u000bH\u0016J\b\u0010\u0010\u001a\u00020\nH\u0016R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/export/modules/j;", "Li01/e;", "", "a", "params", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "c", "method", "call", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/tencent/qqnt/http/api/b;", "d", "Ljava/util/concurrent/CopyOnWriteArrayList;", "reportTask", "<init>", "()V", "e", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class j extends i01.e {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final CopyOnWriteArrayList<com.tencent.qqnt.http.api.b> reportTask = new CopyOnWriteArrayList<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/qqecommerce/biz/kuikly/export/modules/j$b", "Lcom/tencent/qqnt/http/api/l;", "Lcom/tencent/qqnt/http/api/b;", "task", "Lcom/tencent/qqnt/http/api/m;", "result", "", "onSuccess", "onFailed", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements com.tencent.qqnt.http.api.l {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f263012a;

        b(Function1<Object, Unit> function1) {
            this.f263012a = function1;
        }

        @Override // com.tencent.qqnt.http.api.l
        public void onFailed(com.tencent.qqnt.http.api.b task, com.tencent.qqnt.http.api.m result) {
            Map mapOf;
            Intrinsics.checkNotNullParameter(task, "task");
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.e("QQKuiklyPerformanceModule", 1, "[onFailed] code:" + result.a() + "httpCode:" + result.c() + " errMsg:" + result.b());
            Function1<Object, Unit> function1 = this.f263012a;
            if (function1 != null) {
                Pair[] pairArr = new Pair[2];
                Integer c16 = result.c();
                pairArr[0] = TuplesKt.to("errCode", Integer.valueOf(c16 != null ? c16.intValue() : 0));
                String b16 = result.b();
                if (b16 == null) {
                    b16 = "";
                }
                pairArr[1] = TuplesKt.to("errMsg", b16);
                mapOf = MapsKt__MapsKt.mapOf(pairArr);
                function1.invoke(mapOf);
            }
        }

        @Override // com.tencent.qqnt.http.api.l
        public void onSuccess(com.tencent.qqnt.http.api.b task, com.tencent.qqnt.http.api.m result) {
            Map mapOf;
            Intrinsics.checkNotNullParameter(task, "task");
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.i("QQKuiklyPerformanceModule", 1, "[onSuccess]");
            Function1<Object, Unit> function1 = this.f263012a;
            if (function1 != null) {
                Integer c16 = result.c();
                mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("errCode", Integer.valueOf(c16 != null ? c16.intValue() : 0)));
                function1.invoke(mapOf);
            }
        }
    }

    private final String a() {
        com.tencent.mobileqq.qqecommerce.biz.kuikly.api.i launchPerformance;
        String a16;
        QQKuiklyRenderView c16 = com.tencent.mobileqq.qqecommerce.biz.kuikly.export.g.c(this);
        return (c16 == null || (launchPerformance = c16.getLaunchPerformance()) == null || (a16 = launchPerformance.a()) == null) ? "{}" : a16;
    }

    @Override // i01.e, i01.a
    public Object call(String method, String params, Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        if (Intrinsics.areEqual(method, "getLaunchPerformanceData")) {
            return a();
        }
        if (Intrinsics.areEqual(method, "reportPerformanceToAtta")) {
            c(params, callback);
            return Unit.INSTANCE;
        }
        return super.call(method, params, callback);
    }

    @Override // i01.e, i01.a
    public void onDestroy() {
        super.onDestroy();
        for (com.tencent.qqnt.http.api.b it : this.reportTask) {
            IHttpService iHttpService = (IHttpService) QRoute.api(IHttpService.class);
            Intrinsics.checkNotNullExpressionValue(it, "it");
            iHttpService.cancel(it);
        }
        this.reportTask.clear();
    }

    private final void c(String params, Function1<Object, Unit> callback) {
        if (params == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQKuiklyPerformanceModule", 1, "[reportAtta], body:", params);
        }
        String optString = new JSONObject(params).optString("attainfo");
        Intrinsics.checkNotNullExpressionValue(optString, "paramsObj.optString(KEY_ATTA_INFO)");
        if (optString.length() == 0) {
            QLog.w("QQKuiklyPerformanceModule", 1, "---req body is empty----");
        } else {
            this.reportTask.add(AttaReporter.INSTANCE.doReport(optString, new b(callback)));
        }
    }
}
