package gt1;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes14.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private boolean f403340a = true;

    /* renamed from: b, reason: collision with root package name */
    private boolean f403341b = true;

    /* renamed from: c, reason: collision with root package name */
    private boolean f403342c = true;

    /* renamed from: d, reason: collision with root package name */
    private int f403343d = 20;

    /* renamed from: e, reason: collision with root package name */
    private int f403344e = 3;

    public static a f(String str) {
        a aVar = new a();
        if (QLog.isColorLevel()) {
            QLog.d("GuildPicDownloadConfig", 2, "content : " + str);
        }
        if (TextUtils.isEmpty(str)) {
            return aVar;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            jSONObject.optInt("PreThumbPreBig", 11);
            aVar.f403342c = jSONObject.optBoolean("isPreDownWhenScrollView", true);
            aVar.f403343d = jSONObject.optInt("preDownMsgCountWhenScrollView", aVar.f403343d);
            aVar.f403344e = jSONObject.optInt("preDownImageCountWhenScrollView", aVar.f403344e);
            aVar.f403340a = jSONObject.optBoolean("use720Flag", aVar.f403340a);
            aVar.f403341b = jSONObject.optBoolean("useHttpsFlag", aVar.f403341b);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        if (QLog.isColorLevel()) {
            QLog.d("GuildPicDownloadConfig", 2, "content : " + str);
        }
        return aVar;
    }

    public int a() {
        return this.f403344e;
    }

    public int b() {
        return this.f403343d;
    }

    public boolean c() {
        return this.f403342c;
    }

    public Boolean d() {
        return Boolean.valueOf(this.f403340a);
    }

    public Boolean e() {
        return Boolean.valueOf(this.f403341b);
    }
}
