package com.tencent.mobileqq.vaswebviewplugin;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.vas.util.ChatBackgroundUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPluginV2;
import java.io.ByteArrayOutputStream;
import java.io.File;
import org.json.JSONObject;

/* loaded from: classes35.dex */
public class QQAioBackgroundPlugin extends VasWebviewJsPluginV2 {
    public static final String BUSINESS_NAME = "background";

    @VasWebviewJsPluginV2.JsbridgeSubscribe(args = "callback|chatUin", method = "getCurBackground")
    public void getCurBackground(String str, Object obj) {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject.put("data", jSONObject2);
            String chatBackgroundPath = ChatBackgroundUtil.getChatBackgroundPath(this.mRuntime.a(), this.mRuntime.b().getCurrentAccountUin(), String.valueOf(obj));
            if ("null".equals(chatBackgroundPath)) {
                jSONObject.put("result", 0);
                jSONObject2.put("imageSize", 0);
                jSONObject2.put("bgId", 0);
            } else {
                String id5 = ChatBackgroundUtil.getId(chatBackgroundPath);
                Bitmap bitmap = null;
                if (new File(chatBackgroundPath).exists()) {
                    try {
                        bitmap = BitmapFactory.decodeFile(chatBackgroundPath, BaseImageUtil.calculateInSampleSize(new BitmapFactory.Options(), chatBackgroundPath, 200));
                    } catch (OutOfMemoryError unused) {
                    }
                }
                if (bitmap == null) {
                    jSONObject.put("result", 1002);
                } else {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                    String encodeToString = PluginBaseInfoHelper.Base64Helper.encodeToString(byteArrayOutputStream.toByteArray(), 2);
                    jSONObject.put("result", 0);
                    jSONObject2.put("image", "data:image/png;base64," + encodeToString);
                    jSONObject2.put("imageSize", bitmap.getWidth());
                    jSONObject2.put("bgId", id5);
                    byteArrayOutputStream.close();
                }
            }
            super.callJs(str, jSONObject.toString());
        } catch (Exception e16) {
            super.callJsOnError(str, e16.getMessage());
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "background";
    }
}
