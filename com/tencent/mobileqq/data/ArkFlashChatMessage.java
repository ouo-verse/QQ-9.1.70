package com.tencent.mobileqq.data;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class ArkFlashChatMessage {
    public String appDesc;
    public String appMinVersion;
    public String appName;
    public int appResId;
    public String appView;
    public String config;
    public int forwardID;
    public String promptText;
    public long uniSeq;
    public final String TAG = "ArkApp.Message";
    public boolean preview = false;

    public ArkFlashChatMessage() {
        reset();
    }

    public boolean fromAppXml(String str) {
        reset();
        if (str != null && str.length() != 0) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.appName = jSONObject.optString("a");
                this.appView = jSONObject.optString(QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO);
                this.appDesc = jSONObject.optString("desc");
                this.appMinVersion = jSONObject.optString("v");
                this.promptText = jSONObject.optString("prompt");
                this.appResId = jSONObject.optInt("resid");
                return true;
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return false;
    }

    public boolean fromBytes(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        try {
            if (!fromAppXml((String) new ObjectInputStream(new ByteArrayInputStream(bArr)).readObject())) {
                return false;
            }
            return true;
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    public String getArkDisplay() {
        if (this.promptText != null) {
            return TextUtils.emoticonToTextWithoutSysEmotion(getSummery());
        }
        return getSummery();
    }

    public String getMeta(long j3, boolean z16) {
        int i3;
        try {
            String r16 = FlashChatManager.r(getArkDisplay());
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("id", String.valueOf(j3));
            jSONObject2.put("text", r16);
            if (z16) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            jSONObject2.put("runstate", i3);
            if (this.preview) {
                jSONObject2.put("preview", 1);
            }
            jSONObject.put("content", jSONObject2);
            return jSONObject.toString();
        } catch (Exception e16) {
            QLog.e("ArkApp.Message", 1, e16, new Object[0]);
            return "";
        }
    }

    public String getSummery() {
        if (!android.text.TextUtils.isEmpty(this.promptText)) {
            return this.promptText;
        }
        return MobileQQ.sMobileQQ.getString(R.string.f170467s2);
    }

    public void reset() {
        this.promptText = null;
        this.appName = null;
        this.appDesc = null;
        this.appView = null;
        this.appMinVersion = null;
        this.config = null;
    }

    public String toAppXml() {
        try {
            JSONObject jSONObject = new JSONObject();
            String str = this.appName;
            if (str != null) {
                jSONObject.put("a", str);
            }
            String str2 = this.appDesc;
            if (str2 != null) {
                jSONObject.put("desc", str2);
            }
            int i3 = this.appResId;
            if (i3 != 0) {
                jSONObject.put("resid", i3);
            }
            String str3 = this.appView;
            if (str3 != null) {
                jSONObject.put(QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, str3);
            }
            String str4 = this.appMinVersion;
            if (str4 != null) {
                jSONObject.put("v", str4);
            }
            String str5 = this.promptText;
            if (str5 != null) {
                jSONObject.put("prompt", str5);
            }
            return jSONObject.toString();
        } catch (JSONException e16) {
            e16.printStackTrace();
            return null;
        } catch (Exception e17) {
            e17.printStackTrace();
            return null;
        }
    }

    public byte[] toBytes() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            new ObjectOutputStream(byteArrayOutputStream).writeObject(toAppXml());
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public byte[] toPbData() {
        String appXml = toAppXml();
        if (appXml == null) {
            return null;
        }
        try {
            return appXml.getBytes("utf-8");
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }
}
