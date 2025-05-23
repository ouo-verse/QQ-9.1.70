package oa1;

import android.text.TextUtils;
import com.tencent.freesia.IConfigData;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class c implements IConfigData {

    /* renamed from: i, reason: collision with root package name */
    public String f422292i;

    /* renamed from: m, reason: collision with root package name */
    public String f422293m;

    /* renamed from: d, reason: collision with root package name */
    public String f422288d = "";

    /* renamed from: e, reason: collision with root package name */
    public String f422289e = "";

    /* renamed from: f, reason: collision with root package name */
    public String f422290f = "";

    /* renamed from: h, reason: collision with root package name */
    public String f422291h = "";
    public String C = "";

    public static c a(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("ExtensionAniStickerConfigData", 1, "parse content null!");
            return null;
        }
        c cVar = new c();
        QLog.i("ExtensionAniStickerConfigData", 1, "parse content:" + str);
        cVar.C = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("ExtAniStickerConfigUrl")) {
                cVar.f422288d = jSONObject.optString("ExtAniStickerConfigUrl");
            }
            if (jSONObject.has("ExtAniStickerConfigMd5")) {
                cVar.f422289e = jSONObject.optString("ExtAniStickerConfigMd5");
            }
            cVar.f422290f = jSONObject.optString("ExtAniStickerSysfaceResUrl");
            cVar.f422291h = jSONObject.optString("ExtAniStickerSysfaceResMd5");
            if (jSONObject.has("ExtAniStickerLottieUrl")) {
                cVar.f422292i = jSONObject.optString("ExtAniStickerLottieUrl");
            }
            if (jSONObject.has("ExtAniStickerLottieMd5")) {
                cVar.f422293m = jSONObject.optString("ExtAniStickerLottieMd5");
            }
        } catch (JSONException e16) {
            QLog.e("ExtensionAniStickerConfigData", 1, "parse config error! stack= ", e16);
        }
        return cVar;
    }

    public String toString() {
        return "ExtensionAniStickerConfigData{, mConfigUrl='" + this.f422288d + "', mConfigMD5='" + this.f422289e + "', mSysFaceResUrl='" + this.f422290f + "', mSysFaceResMD5='" + this.f422291h + "', mAniStickerLottieUrl='" + this.f422292i + "', mAniStickerLottieMd5='" + this.f422293m + "', mJsonContent='" + this.C + "'}";
    }
}
