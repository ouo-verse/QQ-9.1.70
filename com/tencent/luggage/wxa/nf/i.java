package com.tencent.luggage.wxa.nf;

import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.yi.r;
import com.tencent.luggage.wxa.yi.s;
import com.tencent.mobileqq.app.face.FaceConstant;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class i extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 347;
    public static final String NAME = "operateSocketTask";

    /* renamed from: a, reason: collision with root package name */
    public boolean f135805a = false;

    /* renamed from: b, reason: collision with root package name */
    public boolean f135806b = false;

    /* renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f135807c = new AtomicBoolean(false);

    /* renamed from: d, reason: collision with root package name */
    public r.f f135808d;

    public i(r.f fVar) {
        this.f135808d = fVar;
    }

    public final void b(com.tencent.luggage.wxa.xd.d dVar) {
        r.f fVar = this.f135808d;
        if (fVar != null) {
            this.f135805a = fVar.a(dVar.getAppId());
            this.f135806b = this.f135808d.b(dVar.getAppId());
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        w.a("MicroMsg.JsApiOperateSocketTask", "JsApiOperateSocketTask");
        if (!this.f135807c.getAndSet(true)) {
            b(dVar);
        }
        if (jSONObject == null) {
            dVar.a(i3, makeReturnJson("fail:data is null"));
            w.b("MicroMsg.JsApiOperateSocketTask", "data is null");
            return;
        }
        String optString = jSONObject.optString("socketTaskId");
        if (w0.c(optString)) {
            w.b("MicroMsg.JsApiOperateSocketTask", "taskId is null");
            dVar.a(i3, makeReturnJson("fail:taskId is null or nil"));
            return;
        }
        String optString2 = jSONObject.optString("operationType");
        if (w0.c(optString2)) {
            w.b("MicroMsg.JsApiOperateSocketTask", "operationType is null");
            dVar.a(i3, makeReturnJson("fail:operationType is null or nil"));
            return;
        }
        com.tencent.luggage.wxa.kh.d a16 = s.b().a(dVar.getAppId());
        if (a16 == null) {
            dVar.a(i3, makeReturnJson("fail:no task"));
            w.f("MicroMsg.JsApiOperateSocketTask", "client is null");
            return;
        }
        com.tencent.luggage.wxa.kh.e a17 = a16.a(optString);
        if (a17 == null) {
            dVar.a(i3, makeReturnJson("fail:taskID not exist"));
            w.f("MicroMsg.JsApiOperateSocketTask", "webSocketClient is null");
            return;
        }
        if (optString2.equals("close")) {
            int optInt = jSONObject.optInt("code", 1000);
            if (optInt != 1000 && (optInt < 3000 || optInt >= 5000)) {
                dVar.a(i3, makeReturnJson("fail:The code must be either 1000, or between 3000 and 4999"));
                return;
            }
            String optString3 = jSONObject.optString("reason", "");
            a16.a(a17, optInt, optString3);
            dVar.a(i3, makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
            w.d("MicroMsg.JsApiOperateSocketTask", "closeSocket taskId:%s, code %d, reason %s", optString, Integer.valueOf(optInt), optString3);
            return;
        }
        if (optString2.equals("send")) {
            if (!a16.b(a17)) {
                dVar.a(i3, makeReturnJson("fail:don't send before socket connected"));
                w.h("MicroMsg.JsApiOperateSocketTask", "send fail taskId: %s", optString);
                return;
            }
            Object opt = jSONObject.opt("data");
            if (opt != null) {
                try {
                    if (opt instanceof ByteBuffer) {
                        w.a("MicroMsg.JsApiOperateSocketTask", "sendSocketMessage ok message:%s", opt);
                        a16.a(a17, (ByteBuffer) opt);
                        ((com.tencent.luggage.wxa.zj.b) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.b.class)).a(972L, 4L, 1L, false);
                    } else if (opt instanceof String) {
                        w.a("MicroMsg.JsApiOperateSocketTask", "sendSocketMessage ok message");
                        a16.a(a17, (String) opt);
                        ((com.tencent.luggage.wxa.zj.b) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.b.class)).a(972L, 4L, 1L, false);
                    } else {
                        w.f("MicroMsg.JsApiOperateSocketTask", "sendSocketMessage error message type wrong");
                        dVar.a(i3, makeReturnJson("fail:unknown data"));
                        return;
                    }
                    dVar.a(i3, makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
                    return;
                } catch (Exception e16) {
                    dVar.a(i3, makeReturnJson("fail:" + e16.getMessage()));
                    if (!this.f135805a && !this.f135806b) {
                        ((com.tencent.luggage.wxa.zj.b) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.b.class)).a(972L, 5L, 1L, false);
                        return;
                    } else {
                        ((com.tencent.luggage.wxa.zj.b) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.b.class)).a(972L, 6L, 1L, false);
                        return;
                    }
                }
            }
            dVar.a(i3, makeReturnJson("fail:message is null or nil"));
            w.h("MicroMsg.JsApiOperateSocketTask", "sendSocketMessage fail:%s", opt);
            return;
        }
        dVar.a(i3, makeReturnJson("fail:unknown operationType"));
        w.f("MicroMsg.JsApiOperateSocketTask", "sendSocketMessage fail:unknown operationType");
    }
}
