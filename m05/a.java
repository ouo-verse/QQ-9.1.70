package m05;

import androidx.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes28.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public boolean f415949a = false;

    /* renamed from: b, reason: collision with root package name */
    public String f415950b;

    /* renamed from: c, reason: collision with root package name */
    public String f415951c;

    /* renamed from: d, reason: collision with root package name */
    public String f415952d;

    /* renamed from: e, reason: collision with root package name */
    public String f415953e;

    public static String a(a aVar) {
        if (aVar == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mIsUseAnchor", aVar.f415949a);
            jSONObject.put("mWatchPluginUrl", aVar.f415950b);
            jSONObject.put("mWatchPluginMd5", aVar.f415951c);
            jSONObject.put("mAnchorPluginUrl", aVar.f415952d);
            jSONObject.put("mAnchorPluginMd5", aVar.f415953e);
        } catch (JSONException e16) {
            QLog.e("IliveConfigBean", 1, e16, new Object[0]);
        }
        return jSONObject.toString();
    }

    @NonNull
    public String toString() {
        return "mIsUseAnchor = " + this.f415949a + " mWatchPluginMd5 =  " + this.f415951c + " , mAnchorPluginMd5 = " + this.f415953e;
    }
}
