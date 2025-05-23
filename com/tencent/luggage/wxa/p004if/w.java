package com.tencent.luggage.wxa.p004if;

import com.tencent.luggage.wxa.cp.v;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.xd.a;
import com.tencent.luggage.wxa.xd.d;
import com.tencent.luggage.wxa.ym.a;
import com.tencent.mobileqq.app.face.FaceConstant;
import java.text.DecimalFormat;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class w extends a {
    private static final int CTRL_INDEX = 732;
    public static final String NAME = "getVideoInfo";

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(d dVar, JSONObject jSONObject, int i3) {
        String str;
        if (dVar == null) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.JsApiGetVideoInfo", "fail:internal error");
            return;
        }
        if (jSONObject == null) {
            com.tencent.luggage.wxa.tn.w.f("MicroMsg.JsApiGetVideoInfo", "fail:data is null");
            dVar.a(i3, makeReturnJson("fail:invalid data"));
            return;
        }
        if (dVar.getFileSystem() == null) {
            com.tencent.luggage.wxa.tn.w.f("MicroMsg.JsApiGetVideoInfo", "fail:file system is null");
            dVar.a(i3, makeReturnJson("fail:internal error"));
            return;
        }
        String optString = jSONObject.optString("src");
        if (w0.c(optString)) {
            com.tencent.luggage.wxa.tn.w.f("MicroMsg.JsApiGetVideoInfo", "fail:data src is null");
            dVar.a(i3, makeReturnJson("fail:invalid data"));
            return;
        }
        if (!optString.startsWith("wxfile://")) {
            com.tencent.luggage.wxa.tn.w.f("MicroMsg.JsApiGetVideoInfo", "fail:src path not supported");
            dVar.a(i3, makeReturnJson("fail:src path not be supported"));
            return;
        }
        v absoluteFile = dVar.getFileSystem().getAbsoluteFile(optString);
        if (absoluteFile == null) {
            dVar.a(i3, makeReturnJson("fail:file doesn't exist"));
            return;
        }
        a.b c16 = com.tencent.luggage.wxa.ym.a.c(absoluteFile.g());
        if (c16 == null) {
            com.tencent.luggage.wxa.tn.w.f("MicroMsg.JsApiGetVideoInfo", "fail:videoInfo is null");
            dVar.a(i3, makeReturnJson("fail:can't get info from video file"));
            return;
        }
        int i16 = c16.f146030b;
        if (i16 != 90) {
            if (i16 != 180) {
                if (i16 != 270) {
                    str = "up";
                } else {
                    str = "left";
                }
            } else {
                str = "down";
            }
        } else {
            str = "right";
        }
        HashMap hashMap = new HashMap(8);
        hashMap.put("orientation", str);
        hashMap.put("type", c16.f146031c);
        hashMap.put("duration", Float.valueOf(w0.e(new DecimalFormat("#.#").format((c16.f146032d * 1.0f) / 1000.0f))));
        hashMap.put("size", Integer.valueOf(Math.round((((float) c16.f146033e) * 1.0f) / 1024.0f)));
        hashMap.put("height", Integer.valueOf(c16.f146035g));
        hashMap.put("width", Integer.valueOf(c16.f146034f));
        hashMap.put("bitrate", Integer.valueOf(Math.round((c16.f146036h * 1.0f) / 1000.0f)));
        hashMap.put("fps", Float.valueOf(c16.f146037i));
        dVar.a(i3, makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, hashMap));
    }
}
