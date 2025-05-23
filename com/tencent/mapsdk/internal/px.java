package com.tencent.mapsdk.internal;

import android.text.TextUtils;
import com.tencent.gdtad.jsbridge.GdtGetUserInfoHandler;
import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.JsonParser;
import com.tencent.map.tools.json.annotation.Json;
import com.tencent.mapsdk.core.utils.log.LogUtil;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptor;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngDeserializer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class px extends JsonComposer {

    /* renamed from: a, reason: collision with root package name */
    @Json(name = "detail")
    public d f149690a;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class a extends JsonComposer {

        /* renamed from: a, reason: collision with root package name */
        @Json(name = "aoi_latitude")
        String f149691a;

        /* renamed from: b, reason: collision with root package name */
        @Json(name = "aoi_longitude")
        String f149692b;

        /* renamed from: c, reason: collision with root package name */
        @Json(name = GdtGetUserInfoHandler.KEY_AREA)
        b f149693c;

        public final String toString() {
            StringBuffer stringBuffer = new StringBuffer("PoiArea{");
            stringBuffer.append("latitude=");
            stringBuffer.append(this.f149691a);
            stringBuffer.append(", longitude=");
            stringBuffer.append(this.f149692b);
            stringBuffer.append(", area=");
            stringBuffer.append(this.f149693c);
            stringBuffer.append('}');
            return stringBuffer.toString();
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class b extends JsonComposer implements JsonParser.Deserializer<List<List<LatLng>>> {

        /* renamed from: a, reason: collision with root package name */
        @Json(name = "type")
        String f149694a;

        /* renamed from: b, reason: collision with root package name */
        @Json(deserializer = b.class, name = "coordinates")
        List<List<LatLng>> f149695b;

        private static List<List<LatLng>> a(Object obj) throws JSONException {
            ArrayList arrayList = null;
            if (obj == null) {
                return null;
            }
            if (obj instanceof JSONArray) {
                JSONArray jSONArray = (JSONArray) obj;
                arrayList = new ArrayList();
                int length = jSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    Object obj2 = jSONArray.get(i3);
                    ArrayList arrayList2 = new ArrayList();
                    if (obj2 instanceof JSONArray) {
                        JSONArray jSONArray2 = (JSONArray) obj2;
                        int length2 = jSONArray2.length();
                        for (int i16 = 0; i16 < length2; i16++) {
                            Object obj3 = jSONArray2.get(i16);
                            if (obj3 instanceof JSONArray) {
                                JSONArray jSONArray3 = (JSONArray) obj3;
                                if (jSONArray3.length() == 2) {
                                    arrayList2.add(new LatLng(jSONArray3.optDouble(1), jSONArray3.optDouble(0)));
                                }
                            }
                        }
                        if (arrayList2.size() != length2) {
                            LogUtil.d("coordinates's data deserialize error!!");
                        }
                    }
                    arrayList.add(arrayList2);
                }
                if (arrayList.size() != length) {
                    LogUtil.d("coordinates's area deserialize error!!");
                }
            }
            return arrayList;
        }

        @Override // com.tencent.map.tools.json.JsonParser.Deserializer
        public final /* synthetic */ List<List<LatLng>> deserialize(Object obj, String str, Object obj2) throws JSONException {
            if (obj2 != null && (obj2 instanceof JSONArray)) {
                JSONArray jSONArray = (JSONArray) obj2;
                ArrayList arrayList = new ArrayList();
                int length = jSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    Object obj3 = jSONArray.get(i3);
                    ArrayList arrayList2 = new ArrayList();
                    if (obj3 instanceof JSONArray) {
                        JSONArray jSONArray2 = (JSONArray) obj3;
                        int length2 = jSONArray2.length();
                        for (int i16 = 0; i16 < length2; i16++) {
                            Object obj4 = jSONArray2.get(i16);
                            if (obj4 instanceof JSONArray) {
                                JSONArray jSONArray3 = (JSONArray) obj4;
                                if (jSONArray3.length() == 2) {
                                    arrayList2.add(new LatLng(jSONArray3.optDouble(1), jSONArray3.optDouble(0)));
                                }
                            }
                        }
                        if (arrayList2.size() != length2) {
                            LogUtil.d("coordinates's data deserialize error!!");
                        }
                    }
                    arrayList.add(arrayList2);
                }
                if (arrayList.size() != length) {
                    LogUtil.d("coordinates's area deserialize error!!");
                }
                return arrayList;
            }
            return null;
        }

        public final String toString() {
            int[] iArr;
            List<List<LatLng>> list = this.f149695b;
            int i3 = 0;
            if (list != null) {
                int size = list.size();
                iArr = new int[size];
                while (i3 < size) {
                    iArr[i3] = this.f149695b.get(i3).size();
                    i3++;
                }
                i3 = size;
            } else {
                iArr = null;
            }
            StringBuffer stringBuffer = new StringBuffer("AreaData{");
            stringBuffer.append("type='");
            stringBuffer.append(this.f149694a);
            stringBuffer.append('\'');
            stringBuffer.append(", coordinates=");
            stringBuffer.append(i3);
            stringBuffer.append("#");
            stringBuffer.append(Arrays.toString(iArr));
            stringBuffer.append('}');
            return stringBuffer.toString();
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class c extends JsonComposer {

        /* renamed from: a, reason: collision with root package name */
        @Json(name = "fill_color")
        String f149696a;

        /* renamed from: b, reason: collision with root package name */
        @Json(name = "stroke_color")
        String f149697b;

        /* renamed from: c, reason: collision with root package name */
        @Json(name = "stroke_width")
        int f149698c;

        public final String toString() {
            StringBuffer stringBuffer = new StringBuffer("AoiStyle{");
            stringBuffer.append("fillColor='");
            stringBuffer.append(this.f149696a);
            stringBuffer.append('\'');
            stringBuffer.append(", strokeColor='");
            stringBuffer.append(this.f149697b);
            stringBuffer.append('\'');
            stringBuffer.append(", strokeWidth=");
            stringBuffer.append(this.f149698c);
            stringBuffer.append('}');
            return stringBuffer.toString();
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class d extends JsonComposer {

        /* renamed from: a, reason: collision with root package name */
        @Json(ignore = true)
        public int f149699a = -1;

        /* renamed from: b, reason: collision with root package name */
        @Json(name = "uid")
        String f149700b;

        /* renamed from: c, reason: collision with root package name */
        @Json(name = "name")
        String f149701c;

        /* renamed from: d, reason: collision with root package name */
        @Json(name = NotificationActivity.KEY_ALIAS)
        String f149702d;

        /* renamed from: e, reason: collision with root package name */
        @Json(name = "type")
        String f149703e;

        /* renamed from: f, reason: collision with root package name */
        @Json(name = "styles")
        List<e> f149704f;

        /* renamed from: g, reason: collision with root package name */
        @Json(name = "shinei_id")
        String f149705g;

        /* renamed from: h, reason: collision with root package name */
        @Json(deserializer = LatLngDeserializer.class, name = "location")
        LatLng f149706h;

        /* renamed from: i, reason: collision with root package name */
        @Json(name = "aoi_info")
        a f149707i;

        /* renamed from: j, reason: collision with root package name */
        @Json(name = "sub_pois")
        public List<d> f149708j;

        public final String a() {
            if (!TextUtils.isEmpty(this.f149702d)) {
                return this.f149702d;
            }
            return this.f149701c;
        }

        public final String toString() {
            StringBuffer stringBuffer = new StringBuffer("PoiDetail{");
            stringBuffer.append("displayId=");
            stringBuffer.append(this.f149699a);
            stringBuffer.append(", poiId='");
            stringBuffer.append(this.f149700b);
            stringBuffer.append('\'');
            stringBuffer.append(", name='");
            stringBuffer.append(this.f149701c);
            stringBuffer.append('\'');
            stringBuffer.append(", alias='");
            stringBuffer.append(this.f149702d);
            stringBuffer.append('\'');
            stringBuffer.append(", type='");
            stringBuffer.append(this.f149703e);
            stringBuffer.append('\'');
            stringBuffer.append(", poiStyles=");
            stringBuffer.append(this.f149704f);
            stringBuffer.append(", indoorId='");
            stringBuffer.append(this.f149705g);
            stringBuffer.append('\'');
            stringBuffer.append(", point=");
            stringBuffer.append(this.f149706h);
            stringBuffer.append(", poiArea=");
            stringBuffer.append(this.f149707i);
            stringBuffer.append(", subPois=");
            stringBuffer.append(this.f149708j);
            stringBuffer.append('}');
            return stringBuffer.toString();
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class e extends JsonComposer {

        /* renamed from: a, reason: collision with root package name */
        @Json(ignore = true)
        BitmapDescriptor f149709a;

        /* renamed from: b, reason: collision with root package name */
        @Json(ignore = true)
        BitmapDescriptor f149710b;

        /* renamed from: c, reason: collision with root package name */
        @Json(name = "style_class")
        int f149711c;

        /* renamed from: d, reason: collision with root package name */
        @Json(name = "icon_url")
        String f149712d;

        /* renamed from: e, reason: collision with root package name */
        @Json(name = "icon_type")
        int f149713e;

        /* renamed from: f, reason: collision with root package name */
        @Json(name = "font_color")
        String f149714f;

        /* renamed from: g, reason: collision with root package name */
        @Json(name = "font_size")
        int f149715g;

        /* renamed from: h, reason: collision with root package name */
        @Json(name = "font_stroke_color")
        String f149716h;

        /* renamed from: i, reason: collision with root package name */
        @Json(name = "font_stroke_width")
        int f149717i;

        /* renamed from: j, reason: collision with root package name */
        @Json(name = "level")
        int f149718j;

        /* renamed from: k, reason: collision with root package name */
        @Json(name = "zindex")
        int f149719k;

        /* renamed from: l, reason: collision with root package name */
        @Json(name = "aoi")
        c f149720l;

        public final String toString() {
            StringBuffer stringBuffer = new StringBuffer("PoiStyle{");
            stringBuffer.append("icon=");
            stringBuffer.append(this.f149709a);
            stringBuffer.append(", type=");
            stringBuffer.append(this.f149711c);
            stringBuffer.append(", iconUrl='");
            stringBuffer.append(this.f149712d);
            stringBuffer.append('\'');
            stringBuffer.append(", iconDisplayType=");
            stringBuffer.append(this.f149713e);
            stringBuffer.append(", fontColor='");
            stringBuffer.append(this.f149714f);
            stringBuffer.append('\'');
            stringBuffer.append(", fontSize=");
            stringBuffer.append(this.f149715g);
            stringBuffer.append(", fontStrokeColor='");
            stringBuffer.append(this.f149716h);
            stringBuffer.append('\'');
            stringBuffer.append(", fontStrokeWidth=");
            stringBuffer.append(this.f149717i);
            stringBuffer.append(", level=");
            stringBuffer.append(this.f149718j);
            stringBuffer.append(", zindex=");
            stringBuffer.append(this.f149719k);
            stringBuffer.append(", aoiStyle=");
            stringBuffer.append(this.f149720l);
            stringBuffer.append('}');
            return stringBuffer.toString();
        }
    }

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer("AoiInfo{");
        stringBuffer.append("poiDetail=");
        stringBuffer.append(this.f149690a);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
