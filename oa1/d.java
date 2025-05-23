package oa1;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.freesia_wrapper.FreesiaWrapperImpl;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class d {

    /* renamed from: j, reason: collision with root package name */
    public String f422303j;

    /* renamed from: k, reason: collision with root package name */
    public String f422304k;

    /* renamed from: a, reason: collision with root package name */
    public String f422294a = "";

    /* renamed from: b, reason: collision with root package name */
    public String f422295b = "";

    /* renamed from: c, reason: collision with root package name */
    public String f422296c = "";

    /* renamed from: d, reason: collision with root package name */
    public String f422297d = "";

    /* renamed from: e, reason: collision with root package name */
    public String f422298e = "";

    /* renamed from: f, reason: collision with root package name */
    public String f422299f = "";

    /* renamed from: g, reason: collision with root package name */
    public String f422300g = "";

    /* renamed from: h, reason: collision with root package name */
    public int f422301h = 510;

    /* renamed from: i, reason: collision with root package name */
    public int f422302i = 510;

    /* renamed from: l, reason: collision with root package name */
    public String f422305l = "";

    /* renamed from: m, reason: collision with root package name */
    public b f422306m = new b();

    /* renamed from: n, reason: collision with root package name */
    public a f422307n = new a();

    /* renamed from: o, reason: collision with root package name */
    @Deprecated
    public int f422308o = 3;

    public static d a(String str) {
        d dVar = new d();
        if (TextUtils.isEmpty(str)) {
            return dVar;
        }
        QLog.i("SystemAndEmojiConfBean", 1, "parse content:" + str);
        dVar.f422305l = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            dVar.f422294a = jSONObject.optString("exp", "default");
            if (jSONObject.has("config_url")) {
                QLog.i("SystemAndEmojiConfBean", 2, "ConfigUrl=" + jSONObject.optString("config_url"));
                dVar.f422295b = jSONObject.optString("config_url");
            }
            if (jSONObject.has("config_md5")) {
                dVar.f422296c = jSONObject.optString("config_md5");
            }
            if (jSONObject.has("sysface_apng_res_url")) {
                dVar.f422297d = jSONObject.optString("sysface_apng_res_url");
            } else if (jSONObject.has("sysface_res_url")) {
                dVar.f422297d = jSONObject.optString("sysface_res_url");
            }
            if (jSONObject.has("sysface_apng_res_md5")) {
                dVar.f422298e = jSONObject.optString("sysface_apng_res_md5");
            } else if (jSONObject.has("sysface_res_md5")) {
                dVar.f422298e = jSONObject.optString("sysface_res_md5");
            }
            if (jSONObject.has("emoji_res_url")) {
                dVar.f422299f = jSONObject.optString("emoji_res_url");
            }
            if (jSONObject.has("emoji_res_md5")) {
                dVar.f422300g = jSONObject.optString("emoji_res_md5");
            }
            if (jSONObject.has("AniStickerWidth")) {
                dVar.f422301h = jSONObject.optInt("AniStickerWidth");
            }
            if (jSONObject.has("AniStickerHeight")) {
                dVar.f422302i = jSONObject.optInt("AniStickerHeight");
            }
            if (jSONObject.has("AniStickerLottieUrl")) {
                dVar.f422303j = jSONObject.optString("AniStickerLottieUrl");
            }
            if (jSONObject.has("AniStickerLottieMd5")) {
                dVar.f422304k = jSONObject.optString("AniStickerLottieMd5");
            }
            if (jSONObject.has("sysface_recent_line_cnt")) {
                QLog.i("SystemAndEmojiConfBean", 2, "sysFaceLineCnt=" + jSONObject.optInt("sysface_recent_line_cnt", 0));
                dVar.f422308o = jSONObject.optInt("sysface_recent_line_cnt", 3);
            }
            String loadConfigAsString = FreesiaWrapperImpl.INSTANCE.b().loadConfigAsString("102385", "");
            if (!TextUtils.isEmpty(loadConfigAsString)) {
                dVar.f422306m = b.c(new JSONObject(loadConfigAsString));
            }
            dVar.f422307n = a.a(jSONObject);
        } catch (JSONException e16) {
            QLog.e("SystemAndEmojiConfBean", 1, "parse content error!", e16);
        }
        return dVar;
    }

    public String toString() {
        return "SystemAndEmojiConfBean{mExp='" + this.f422294a + "', mConfigUrl='" + this.f422295b + "', mConfigMD5='" + this.f422296c + "', mSysFaceResUrl='" + this.f422297d + "', mSysFaceResMD5='" + this.f422298e + "', mEmojiResUrl='" + this.f422299f + "', mEmojiResMD5='" + this.f422300g + "', mAniStickerWidth=" + this.f422301h + ", mAniStickerHeight=" + this.f422302i + ", mAniStickerLottieUrl='" + this.f422303j + "', mAniStickerLottieMd5='" + this.f422304k + "', mJsonContent='" + this.f422305l + "', mEmoticonGuideConfBean=" + this.f422306m + ", mAnimEmoCountConfBean=" + this.f422307n + ", mSysFaceRecentLineCnt=" + this.f422308o + '}';
    }
}
