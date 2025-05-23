package jd0;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.qqstory.network.pb.qqstory_struct$MusicConfigInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.util.cl;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class d {

    /* renamed from: n, reason: collision with root package name */
    public static final d f409834n = new d(0, HardCodeUtil.qqStr(R.string.f172487r80));

    /* renamed from: o, reason: collision with root package name */
    public static final d f409835o = new d(1, HardCodeUtil.qqStr(R.string.r7x));

    /* renamed from: p, reason: collision with root package name */
    public static final d f409836p = new d(2, "QQ\u97f3\u4e50\u66f2\u5e93");

    /* renamed from: a, reason: collision with root package name */
    public String f409837a;

    /* renamed from: b, reason: collision with root package name */
    public String f409838b;

    /* renamed from: c, reason: collision with root package name */
    String f409839c;

    /* renamed from: d, reason: collision with root package name */
    public String f409840d;

    /* renamed from: e, reason: collision with root package name */
    String f409841e;

    /* renamed from: f, reason: collision with root package name */
    String f409842f;

    /* renamed from: g, reason: collision with root package name */
    int f409843g;

    /* renamed from: h, reason: collision with root package name */
    public int f409844h;

    /* renamed from: i, reason: collision with root package name */
    public int f409845i;

    /* renamed from: j, reason: collision with root package name */
    public String f409846j;

    /* renamed from: k, reason: collision with root package name */
    public int f409847k;

    /* renamed from: l, reason: collision with root package name */
    public int f409848l;

    /* renamed from: m, reason: collision with root package name */
    public int f409849m;

    public d() {
        this.f409837a = null;
        this.f409838b = null;
        this.f409839c = null;
        this.f409840d = null;
        this.f409841e = null;
        this.f409842f = null;
        this.f409843g = 0;
        this.f409844h = -1;
        this.f409845i = 0;
        this.f409846j = null;
        this.f409847k = 0;
        this.f409848l = 0;
        this.f409849m = 0;
    }

    public static final ArrayList<d> b(Context context) {
        ArrayList<d> arrayList = null;
        try {
            JSONArray jSONArray = new JSONArray(cl.d(context, "qqstory_savedMusicList"));
            int length = jSONArray.length();
            ArrayList<d> arrayList2 = new ArrayList<>(length);
            for (int i3 = 0; i3 < length; i3++) {
                try {
                    arrayList2.add(new d(jSONArray.optString(i3)));
                } catch (JSONException e16) {
                    e = e16;
                    arrayList = arrayList2;
                    if (QLog.isColorLevel()) {
                        QLog.e("MusicInfo", 2, QLog.getStackTraceString(e));
                    }
                    return arrayList;
                }
            }
            return arrayList2;
        } catch (JSONException e17) {
            e = e17;
        }
    }

    public static final void c(Context context, ArrayList<d> arrayList) {
        String str;
        if (arrayList != null) {
            int size = arrayList.size();
            JSONArray jSONArray = new JSONArray();
            for (int i3 = 0; i3 < size; i3++) {
                jSONArray.mo162put(arrayList.get(i3).d());
            }
            str = jSONArray.toString();
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            cl.g(context, "qqstory_savedMusicList");
        } else {
            cl.j(context, "qqstory_savedMusicList", str);
        }
    }

    public void a(d dVar) {
        this.f409837a = dVar.f409837a;
        this.f409838b = dVar.f409838b;
        this.f409839c = dVar.f409839c;
        this.f409840d = dVar.f409840d;
        this.f409841e = dVar.f409841e;
        this.f409842f = dVar.f409842f;
        this.f409843g = dVar.f409843g;
        this.f409844h = dVar.f409844h;
        this.f409845i = dVar.f409845i;
        this.f409846j = dVar.f409846j;
        this.f409847k = dVar.f409847k;
        this.f409848l = dVar.f409848l;
        this.f409849m = dVar.f409849m;
    }

    public String d() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("title", this.f409838b);
            jSONObject.put(AppConstants.Key.SHARE_REQ_AUDIO_URL, this.f409840d);
            jSONObject.put("type", 3);
            jSONObject.put("id", this.f409837a);
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.e("MusicInfo", 2, QLog.getStackTraceString(e16));
            }
        }
        return jSONObject.toString();
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        d dVar = (d) obj;
        int i3 = dVar.f409844h;
        if (i3 == 0 && this.f409844h == 0) {
            return true;
        }
        if (i3 == 1 && this.f409844h == 1) {
            return true;
        }
        if (i3 == this.f409844h && (str = dVar.f409838b) != null && str.equals(this.f409838b) && (str2 = dVar.f409840d) != null && str2.equals(this.f409840d)) {
            return true;
        }
        return super.equals(obj);
    }

    public d(String str) {
        this.f409837a = null;
        this.f409838b = null;
        this.f409839c = null;
        this.f409840d = null;
        this.f409841e = null;
        this.f409842f = null;
        this.f409843g = 0;
        this.f409844h = -1;
        this.f409845i = 0;
        this.f409846j = null;
        this.f409847k = 0;
        this.f409848l = 0;
        this.f409849m = 0;
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f409838b = jSONObject.optString("title");
            this.f409840d = jSONObject.optString(AppConstants.Key.SHARE_REQ_AUDIO_URL);
            if (jSONObject.has("type")) {
                this.f409844h = jSONObject.optInt("type");
            } else {
                this.f409844h = 2;
            }
            this.f409837a = jSONObject.optString("id");
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.e("MusicInfo", 2, QLog.getStackTraceString(e16));
            }
        }
    }

    public d(int i3, String str) {
        this.f409837a = null;
        this.f409839c = null;
        this.f409840d = null;
        this.f409841e = null;
        this.f409842f = null;
        this.f409843g = 0;
        this.f409845i = 0;
        this.f409846j = null;
        this.f409847k = 0;
        this.f409848l = 0;
        this.f409849m = 0;
        this.f409844h = i3;
        this.f409838b = str;
    }

    public d(qqstory_struct$MusicConfigInfo qqstory_struct_musicconfiginfo) {
        this.f409837a = null;
        this.f409838b = null;
        this.f409839c = null;
        this.f409840d = null;
        this.f409841e = null;
        this.f409842f = null;
        this.f409843g = 0;
        this.f409844h = -1;
        this.f409845i = 0;
        this.f409846j = null;
        this.f409847k = 0;
        this.f409848l = 0;
        this.f409849m = 0;
        this.f409838b = qqstory_struct_musicconfiginfo.title.get().toStringUtf8();
        this.f409840d = qqstory_struct_musicconfiginfo.audio_url.get().toStringUtf8();
        this.f409844h = 3;
        this.f409837a = String.valueOf(qqstory_struct_musicconfiginfo.f94086id.get());
    }
}
