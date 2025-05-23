package com.tencent.av.business.manager.magicface;

import android.graphics.Point;
import android.graphics.Rect;
import android.text.TextUtils;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.util.JSONUtils;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    protected String f73367a;

    /* renamed from: b, reason: collision with root package name */
    protected String f73368b;

    /* renamed from: c, reason: collision with root package name */
    protected MagicfaceDataVideoJason f73369c;

    /* renamed from: d, reason: collision with root package name */
    protected MagicfaceDataAudioJason f73370d;

    /* renamed from: e, reason: collision with root package name */
    protected Map<String, MagicfaceDataPendantJason> f73371e;

    /* renamed from: f, reason: collision with root package name */
    protected Rect f73372f;

    /* renamed from: g, reason: collision with root package name */
    protected int f73373g;

    /* renamed from: h, reason: collision with root package name */
    protected int f73374h;

    public c(String str, String str2, String str3) {
        AVCoreLog.printColorLog("AVMagicfaceData", "init|config=" + str2 + "|" + str3 + "|" + str);
        this.f73367a = str2;
        this.f73368b = str3;
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = jSONObject.getJSONObject("video");
            MagicfaceDataVideoJason magicfaceDataVideoJason = (MagicfaceDataVideoJason) JSONUtils.b(jSONObject2, MagicfaceDataVideoJason.class);
            this.f73369c = magicfaceDataVideoJason;
            if (magicfaceDataVideoJason != null) {
                int i3 = magicfaceDataVideoJason.location_x;
                if (i3 > 0) {
                    magicfaceDataVideoJason.location_x = i3 * 2;
                }
                int i16 = magicfaceDataVideoJason.location_y;
                if (i16 > 0) {
                    magicfaceDataVideoJason.location_y = i16 * 2;
                }
                int i17 = magicfaceDataVideoJason.width;
                if (i17 > 0) {
                    magicfaceDataVideoJason.width = i17 * 2;
                }
                int i18 = magicfaceDataVideoJason.height;
                if (i18 > 0) {
                    magicfaceDataVideoJason.height = i18 * 2;
                }
                JSONArray optJSONArray = jSONObject2.optJSONArray("locations");
                if (optJSONArray != null) {
                    for (int i19 = 0; i19 < optJSONArray.length(); i19++) {
                        JSONObject jSONObject3 = (JSONObject) optJSONArray.get(i19);
                        this.f73369c.pointArrayList.add(new Point(jSONObject3.optInt(HippyTKDListViewAdapter.X), jSONObject3.optInt("y")));
                    }
                } else {
                    ArrayList<Point> arrayList = this.f73369c.pointArrayList;
                    MagicfaceDataVideoJason magicfaceDataVideoJason2 = this.f73369c;
                    arrayList.add(new Point(magicfaceDataVideoJason2.location_x, magicfaceDataVideoJason2.location_y));
                }
            }
            if (jSONObject.has("audio")) {
                this.f73370d = (MagicfaceDataAudioJason) JSONUtils.b(jSONObject.getJSONObject("audio"), MagicfaceDataAudioJason.class);
            }
            this.f73371e = new HashMap();
            if (jSONObject.has(IndividuationUrlHelper.UrlId.PENDANT_HOME)) {
                JSONArray jSONArray = jSONObject.getJSONArray(IndividuationUrlHelper.UrlId.PENDANT_HOME);
                for (int i26 = 0; i26 < jSONArray.length(); i26++) {
                    MagicfaceDataPendantJason magicfaceDataPendantJason = (MagicfaceDataPendantJason) JSONUtils.b((JSONObject) jSONArray.get(i26), MagicfaceDataPendantJason.class);
                    if (magicfaceDataPendantJason != null && !TextUtils.isEmpty(magicfaceDataPendantJason.name)) {
                        AVCoreLog.printErrorLog("AVMagicfaceData", "Pendant: " + magicfaceDataPendantJason.toString());
                        magicfaceDataPendantJason.duration = magicfaceDataPendantJason.duration * 1000;
                        this.f73371e.put(magicfaceDataPendantJason.name, magicfaceDataPendantJason);
                    }
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (this.f73369c == null) {
            AVCoreLog.printErrorLog("AVMagicfaceData", "MagicfaceData error!");
            this.f73369c = new MagicfaceDataVideoJason();
        }
        if (this.f73370d == null) {
            this.f73370d = new MagicfaceDataAudioJason();
        }
        MagicfaceDataVideoJason magicfaceDataVideoJason3 = this.f73369c;
        if (magicfaceDataVideoJason3.persistent) {
            magicfaceDataVideoJason3.repeat_count = 50000;
            if (magicfaceDataVideoJason3.frame_count == 0) {
                magicfaceDataVideoJason3.frame_count = 3;
            }
            this.f73370d.is_repeat = true;
        }
        AVCoreLog.printErrorLog("AVMagicfaceData", "MagicfaceData:: " + this.f73369c.toString());
        MagicfaceDataVideoJason magicfaceDataVideoJason4 = this.f73369c;
        this.f73373g = magicfaceDataVideoJason4.frame_count;
        Point location = magicfaceDataVideoJason4.getLocation(-1);
        int i27 = location.x;
        int i28 = location.y;
        MagicfaceDataVideoJason magicfaceDataVideoJason5 = this.f73369c;
        this.f73372f = new Rect(i27, i28, magicfaceDataVideoJason5.width + i27, magicfaceDataVideoJason5.height + i28);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int a();

    public String b() {
        return this.f73367a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract String c(int i3);

    public boolean d() {
        return this.f73368b.equalsIgnoreCase(IndividuationUrlHelper.UrlId.PENDANT_HOME);
    }

    public boolean e(c cVar) {
        if (cVar == null || TextUtils.isEmpty(this.f73368b) || !TextUtils.isEmpty(cVar.f73368b) || !this.f73368b.equalsIgnoreCase(IndividuationUrlHelper.UrlId.PENDANT_HOME)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f(int i3) {
        MagicfaceDataVideoJason magicfaceDataVideoJason = this.f73369c;
        if (magicfaceDataVideoJason == null) {
            return i3;
        }
        Point location = magicfaceDataVideoJason.getLocation(i3);
        int i16 = location.x;
        int i17 = location.y;
        MagicfaceDataVideoJason magicfaceDataVideoJason2 = this.f73369c;
        this.f73372f = new Rect(i16, i17, magicfaceDataVideoJason2.width + i16, magicfaceDataVideoJason2.height + i17);
        return this.f73369c.lastLocationIndex;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void g(int i3, int i16);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void h();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void i();

    public String toString() {
        return "Id[" + this.f73367a + "], type[" + this.f73368b + "]";
    }
}
