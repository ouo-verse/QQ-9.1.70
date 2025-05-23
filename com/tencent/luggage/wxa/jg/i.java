package com.tencent.luggage.wxa.jg;

import android.content.ClipData;
import android.content.ClipboardManager;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.qmethod.pandoraex.monitor.ClipboardMonitor;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class i extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 169;
    public static final String NAME = "getClipboardData";

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        ClipboardManager clipboardManager = (ClipboardManager) com.tencent.luggage.wxa.tn.z.c().getSystemService("clipboard");
        if (clipboardManager == null) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.JsApiGetClipboardData", "getSystemService(CLIPBOARD_SERVICE) failed.");
            dVar.a(i3, makeReturnJson("fail"));
            return;
        }
        try {
            ClipData primaryClip = ClipboardMonitor.getPrimaryClip(clipboardManager);
            String str = "";
            if (primaryClip != null && primaryClip.getItemCount() > 0) {
                ClipData.Item itemAt = primaryClip.getItemAt(0);
                if (itemAt.getText() != null) {
                    str = itemAt.getText().toString();
                }
            }
            HashMap hashMap = new HashMap();
            hashMap.put("data", str);
            dVar.a(i3, makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, hashMap));
        } catch (Exception e16) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.JsApiGetClipboardData", "invoke with appId:%s, but get Exception:%s", dVar.getAppId(), e16);
        }
    }
}
