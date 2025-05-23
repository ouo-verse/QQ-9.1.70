package com.tencent.aelight.camera.report.atta;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.raft.measure.report.ATTAReporter;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002J\u001a\u0010\b\u001a\u00020\u0003*\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002J.\u0010\u000e\u001a\u00020\u0003*\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0018\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00030\u000bH\u0002J>\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\t2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0018\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00030\u000b\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/aelight/camera/report/atta/f;", "", "Lcom/tencent/mobileqq/transfile/HttpNetReq;", "", "d", "", "", "content", "b", "", "token", "Lkotlin/Function2;", "", "callback", "c", "Lcom/tencent/common/app/AppInterface;", "app", "a", "<init>", "()V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final f f69041a = new f();

    f() {
    }

    private final void b(HttpNetReq httpNetReq, List<String> list) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("attaid", "0b500065156");
        jSONObject.put("token", "6846246265");
        jSONObject.put("type", "batch");
        jSONObject.put("version", "v1.0.0");
        jSONObject.put("datas", new JSONArray((Collection) list));
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().apply {\n   \u2026nt))\n        }.toString()");
        byte[] bytes = jSONObject2.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        httpNetReq.mSendData = bytes;
    }

    private final void c(HttpNetReq httpNetReq, long j3, Function2<? super Long, ? super Boolean, Unit> function2) {
        httpNetReq.mCallback = new a(function2, j3);
    }

    private final void d(HttpNetReq httpNetReq) {
        HashMap<String, String> hashMap = httpNetReq.mReqProperties;
        hashMap.put(ATTAReporter.ATTA_TYPE, ATTAReporter.BATCH_REPORT);
        hashMap.put("Content-Type", "application/x-www-form-urlencoded");
    }

    public final void a(AppInterface app, long token, List<String> content, Function2<? super Long, ? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(callback, "callback");
        IHttpEngineService iHttpEngineService = (IHttpEngineService) app.getRuntimeService(IHttpEngineService.class, "all");
        HttpNetReq httpNetReq = new HttpNetReq();
        httpNetReq.mReqUrl = "https://h.trace.qq.com/kv";
        httpNetReq.mHttpMethod = 1;
        httpNetReq.mExcuteTimeLimit = 15000L;
        httpNetReq.mPrioty = 1;
        f fVar = f69041a;
        fVar.d(httpNetReq);
        fVar.b(httpNetReq, content);
        fVar.c(httpNetReq, token, callback);
        iHttpEngineService.sendReq(httpNetReq);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\"\u0010\u000b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/aelight/camera/report/atta/f$a", "Lcom/tencent/mobileqq/transfile/INetEngineListener;", "Lcom/tencent/mobileqq/transfile/NetResp;", "resp", "", "onResp", "Lcom/tencent/mobileqq/transfile/NetReq;", "req", "", "curOffset", "totalLen", "onUpdateProgeress", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class a implements INetEngineListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function2<Long, Boolean, Unit> f69042d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f69043e;

        /* JADX WARN: Multi-variable type inference failed */
        a(Function2<? super Long, ? super Boolean, Unit> function2, long j3) {
            this.f69042d = function2;
            this.f69043e = j3;
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onResp(NetResp resp) {
            this.f69042d.invoke(Long.valueOf(this.f69043e), Boolean.valueOf(resp != null && resp.mResult == 0));
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onUpdateProgeress(NetReq req, long curOffset, long totalLen) {
        }
    }
}
