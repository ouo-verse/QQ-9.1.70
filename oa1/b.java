package oa1;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.config.business.ba;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.freesia_wrapper.FreesiaWrapperImpl;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class b {

    /* renamed from: g, reason: collision with root package name */
    public long f422282g;

    /* renamed from: k, reason: collision with root package name */
    public List<Integer> f422286k;

    /* renamed from: a, reason: collision with root package name */
    public int f422276a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f422277b = 0;

    /* renamed from: c, reason: collision with root package name */
    public String f422278c = "";

    /* renamed from: d, reason: collision with root package name */
    public String f422279d = "";

    /* renamed from: e, reason: collision with root package name */
    public int f422280e = -1;

    /* renamed from: f, reason: collision with root package name */
    public int f422281f = -1;

    /* renamed from: h, reason: collision with root package name */
    public int f422283h = 0;

    /* renamed from: i, reason: collision with root package name */
    public int f422284i = 0;

    /* renamed from: j, reason: collision with root package name */
    public int f422285j = 0;

    /* renamed from: l, reason: collision with root package name */
    public String f422287l = "";

    @NonNull
    public static b a() {
        String loadConfigAsString = FreesiaWrapperImpl.INSTANCE.b().loadConfigAsString("102385", "");
        if (!TextUtils.isEmpty(loadConfigAsString)) {
            try {
                return c(new JSONObject(loadConfigAsString));
            } catch (JSONException e16) {
                QLog.e("EmoticonGuideConfBean", 1, "parse content error!", e16);
            }
        }
        return new b();
    }

    @NonNull
    public static b c(@NonNull JSONObject jSONObject) {
        b bVar = new b();
        if (QLog.isColorLevel()) {
            QLog.i("EmoticonGuideConfBean", 2, "parse GuideConfBean: ");
        }
        if (jSONObject.has("emoticon_guide_url")) {
            bVar.f422278c = jSONObject.optString("emoticon_guide_url");
        }
        if (jSONObject.has("emoticon_guide_night_url")) {
            bVar.f422279d = jSONObject.optString("emoticon_guide_night_url");
        }
        if (jSONObject.has("emoticon_guide_serverid")) {
            bVar.f422280e = jSONObject.optInt("emoticon_guide_serverid", -1);
        }
        if (jSONObject.has("emoticon_guide_serverid_type")) {
            bVar.f422281f = jSONObject.optInt("emoticon_guide_serverid_type", -1);
        }
        if (jSONObject.has("emoticon_guide_width")) {
            bVar.f422283h = jSONObject.optInt("emoticon_guide_width", 0);
        }
        if (jSONObject.has("emoticon_guide_height")) {
            bVar.f422284i = jSONObject.optInt("emoticon_guide_height", 0);
        }
        if (jSONObject.has("emoticon_guide_open")) {
            bVar.f422276a = jSONObject.optInt("emoticon_guide_open", 0);
        }
        if (jSONObject.has("emoticon_guide_version")) {
            bVar.f422277b = jSONObject.optInt("emoticon_guide_version", 0);
        }
        if (jSONObject.has("emoticon_guide_time")) {
            bVar.f422285j = jSONObject.optInt("emoticon_guide_time", 0);
        }
        if (jSONObject.has("emoticon_guide_invalid_time")) {
            String optString = jSONObject.optString("emoticon_guide_invalid_time", null);
            if (!TextUtils.isEmpty(optString)) {
                try {
                    bVar.f422282g = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).parse(optString).getTime();
                } catch (Exception e16) {
                    QLog.d("EmoticonGuideConfBean", 2, "parse invalidTime failed!", e16);
                }
            }
        }
        if (jSONObject.has("emoticon_guide_emoji_list")) {
            bVar.f422286k = d(jSONObject, "emoticon_guide_emoji_list");
        }
        if (jSONObject.has("emoticon_guide_tips")) {
            bVar.f422287l = jSONObject.optString("emoticon_guide_tips");
        }
        return bVar;
    }

    private static List<Integer> d(JSONObject jSONObject, String str) {
        JSONArray optJSONArray;
        ArrayList arrayList = new ArrayList();
        if (jSONObject == null) {
            if (QLog.isColorLevel()) {
                QLog.d("EmoticonGuideConfBean", 1, "parseToList obj == null");
            }
            return arrayList;
        }
        if (TextUtils.isEmpty(str)) {
            if (QLog.isColorLevel()) {
                QLog.i("EmoticonGuideConfBean", 1, "parseToList parseKey == null");
            }
            return arrayList;
        }
        try {
            optJSONArray = jSONObject.optJSONArray(str);
        } catch (Exception e16) {
            QLog.w("EmoticonGuideConfBean", 1, "parseToList Exception \uff01\uff01\uff01" + e16.getMessage());
        }
        if (optJSONArray != null && optJSONArray.length() > 0) {
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                arrayList.add(Integer.valueOf(optJSONArray.optInt(i3)));
            }
            return arrayList;
        }
        return arrayList;
    }

    public boolean b() {
        if (QLog.isColorLevel()) {
            QLog.i("EmoticonGuideConfBean", 2, "currentTimeMillis: " + System.currentTimeMillis() + " mInvalidTime: " + this.f422282g);
        }
        if (this.f422276a == 1 && System.currentTimeMillis() < this.f422282g) {
            return true;
        }
        return false;
    }

    public boolean e() {
        String str = null;
        try {
            str = MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount();
        } catch (Throwable unused) {
            QLog.e("EmoticonGuideConfBean", 1, "getAccount faild \uff01\uff01\uff01");
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        SharedPreferences b16 = ba.INSTANCE.b();
        if (this.f422277b <= b16.getInt("key_emoticon_guide_version", 0)) {
            return false;
        }
        b16.edit().putInt("key_emoticon_guide_version", this.f422277b).putBoolean("key_show_emoticon_guide", true).apply();
        return true;
    }

    public String toString() {
        return "{mOpen=" + this.f422276a + ", mDrawableUrl='" + this.f422278c + "', mNightDrawableUrl=" + this.f422279d + ", mServerId=" + this.f422280e + ", mEmoType=" + this.f422281f + ", mInvalidTime=" + this.f422282g + '}';
    }
}
