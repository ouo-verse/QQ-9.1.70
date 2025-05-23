package com.tencent.mobileqq.zplan.report;

import av4.d;
import av4.f;
import av4.g;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.zootopia.api.e;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.report.ReportMsgBean;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001a\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0004R\u001b\u0010\u0016\u001a\u00020\u00128FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/zplan/report/ReportMsgProxy;", "", "Lav4/f;", "req", "Lrh3/b;", "cb", "", "a", "", "paramString", "f", "d", "Lcom/tencent/sqshow/zootopia/report/ReportMsgBean;", "param", "c", "Lav4/d;", "msgInfo", "b", "Lcom/tencent/mobileqq/zootopia/service/a;", "Lkotlin/Lazy;", "e", "()Lcom/tencent/mobileqq/zootopia/service/a;", "service", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ReportMsgProxy {

    /* renamed from: a, reason: collision with root package name */
    public static final ReportMsgProxy f335040a = new ReportMsgProxy();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Lazy service;

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/report/ReportMsgProxy$a", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lav4/g;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a implements e<g> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ rh3.b f335042d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ f f335043e;

        a(rh3.b bVar, f fVar) {
            this.f335042d = bVar;
            this.f335043e = fVar;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(g result) {
            Intrinsics.checkNotNullParameter(result, "result");
            this.f335042d.onSuccess();
            QLog.d("ReportMsgProxy", 1, "result:" + result);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            List asList;
            th3.a aVar = th3.a.f436337b;
            d[] dVarArr = this.f335043e.f27019a;
            Intrinsics.checkNotNullExpressionValue(dVarArr, "req.msgList");
            asList = ArraysKt___ArraysJvmKt.asList(dVarArr);
            aVar.i(asList);
            this.f335042d.onFailed(error, message == null ? "failed" : message);
            QLog.d("ReportMsgProxy", 1, "error:" + error + ", message" + message);
        }
    }

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.zootopia.service.a>() { // from class: com.tencent.mobileqq.zplan.report.ReportMsgProxy$service$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.mobileqq.zootopia.service.a invoke() {
                return new com.tencent.mobileqq.zootopia.service.a();
            }
        });
        service = lazy;
    }

    ReportMsgProxy() {
    }

    private final void a(f req, rh3.b cb5) {
        e().e(req, new a(cb5, req));
    }

    private final f f(String paramString, rh3.b cb5) {
        JSONObject jSONObject = new JSONObject(paramString);
        QLog.d("ReportMsgProxy", 1, "params:" + jSONObject);
        JSONArray optJSONArray = jSONObject.optJSONArray("reportList");
        if (optJSONArray != null && optJSONArray.length() != 0) {
            int length = optJSONArray.length();
            d[] dVarArr = new d[length];
            for (int i3 = 0; i3 < length; i3++) {
                Object obj = optJSONArray.get(i3);
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type org.json.JSONObject");
                JSONObject jSONObject2 = (JSONObject) obj;
                d dVar = new d();
                dVar.f27014a = jSONObject2.optLong("msgId", 0L);
                dVar.f27015b = jSONObject2.optInt(QQBrowserActivity.KEY_MSG_TYPE, 0);
                dVar.f27016c = PluginBaseInfoHelper.Base64Helper.decode(jSONObject2.optString("msgBody", ""), 0);
                dVarArr[i3] = dVar;
            }
            f fVar = new f();
            fVar.f27019a = dVarArr;
            return fVar;
        }
        cb5.onFailed(-2, "list is null or empty");
        return null;
    }

    public final void b(d msgInfo, rh3.b cb5) {
        List asList;
        Intrinsics.checkNotNullParameter(msgInfo, "msgInfo");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        f fVar = new f();
        fVar.f27019a = new d[]{msgInfo};
        if (!NetworkUtil.isNetworkAvailable()) {
            QLog.e("ReportMsgProxy", 1, "doReportMsg network, net unavailable!");
            th3.a aVar = th3.a.f436337b;
            d[] dVarArr = fVar.f27019a;
            Intrinsics.checkNotNullExpressionValue(dVarArr, "req.msgList");
            asList = ArraysKt___ArraysJvmKt.asList(dVarArr);
            aVar.i(asList);
            cb5.onFailed(-1, "doReportMsg net unavailable");
            return;
        }
        a(fVar, cb5);
    }

    public final void c(ReportMsgBean param, rh3.b cb5) {
        List asList;
        Intrinsics.checkNotNullParameter(param, "param");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        f convertToReportMsgReq = param.convertToReportMsgReq();
        if (!NetworkUtil.isNetworkAvailable()) {
            QLog.e("ReportMsgProxy", 1, "doReportMsg network, net unavailable!");
            th3.a aVar = th3.a.f436337b;
            d[] dVarArr = convertToReportMsgReq.f27019a;
            Intrinsics.checkNotNullExpressionValue(dVarArr, "req.msgList");
            asList = ArraysKt___ArraysJvmKt.asList(dVarArr);
            aVar.i(asList);
            cb5.onFailed(-1, "doReportMsg net unavailable");
            return;
        }
        a(convertToReportMsgReq, cb5);
    }

    public final void d(String paramString, rh3.b cb5) {
        List asList;
        Intrinsics.checkNotNullParameter(paramString, "paramString");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        f f16 = f(paramString, cb5);
        if (f16 == null) {
            return;
        }
        if (!NetworkUtil.isNetworkAvailable()) {
            QLog.e("ReportMsgProxy", 1, "L2N_ReportMsg network, net unavailable!");
            th3.a aVar = th3.a.f436337b;
            d[] dVarArr = f16.f27019a;
            Intrinsics.checkNotNullExpressionValue(dVarArr, "req.msgList");
            asList = ArraysKt___ArraysJvmKt.asList(dVarArr);
            aVar.i(asList);
            cb5.onFailed(-1, "net unavailable");
            return;
        }
        a(f16, cb5);
    }

    public final com.tencent.mobileqq.zootopia.service.a e() {
        return (com.tencent.mobileqq.zootopia.service.a) service.getValue();
    }
}
