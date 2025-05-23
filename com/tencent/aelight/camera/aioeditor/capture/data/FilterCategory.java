package com.tencent.aelight.camera.aioeditor.capture.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.aelight.camera.aioeditor.capture.data.QIMRedDotConfig;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes32.dex */
public class FilterCategory implements Parcelable {
    public static final Parcelable.Creator<FilterCategory> CREATOR = new a();
    public int C;

    /* renamed from: d, reason: collision with root package name */
    public int f66685d;

    /* renamed from: e, reason: collision with root package name */
    public String f66686e;

    /* renamed from: f, reason: collision with root package name */
    public List<QIMFilterCategoryItem> f66687f;

    /* renamed from: h, reason: collision with root package name */
    public boolean f66688h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f66689i;

    /* renamed from: m, reason: collision with root package name */
    public int f66690m;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a implements Parcelable.Creator<FilterCategory> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public FilterCategory createFromParcel(Parcel parcel) {
            return new FilterCategory(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public FilterCategory[] newArray(int i3) {
            return new FilterCategory[i3];
        }
    }

    public FilterCategory(int i3, String str, boolean z16, boolean z17, int i16, int i17) {
        this.f66690m = 0;
        this.C = 0;
        this.f66685d = i3;
        this.f66686e = str;
        this.f66687f = new ArrayList();
        this.f66688h = z16;
        this.f66689i = z17;
        this.f66690m = i16;
        this.C = i17;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f66685d);
        parcel.writeString(this.f66686e);
        parcel.writeTypedList(this.f66687f);
        parcel.writeByte(this.f66688h ? (byte) 1 : (byte) 0);
    }

    public FilterCategory(JSONObject jSONObject, QIMRedDotConfig qIMRedDotConfig) throws JSONException {
        QIMRedDotConfig.CategoryRedConfig categoryRedConfig;
        JSONArray jSONArray;
        JSONArray jSONArray2;
        int i3 = 0;
        this.f66690m = 0;
        this.C = 0;
        this.f66686e = jSONObject.optString("name");
        this.f66685d = jSONObject.optInt("categoryId");
        this.f66689i = "1".equals(jSONObject.optString("random_position", "0"));
        this.f66690m = jSONObject.optInt("hide_mask", 0);
        this.C = jSONObject.optInt(QCircleSchemeAttr.CoverFeed.SOURCE_TYPE, 0);
        if (qIMRedDotConfig != null) {
            int optInt = jSONObject.optInt("redDotVersion");
            boolean optBoolean = jSONObject.optBoolean("needRedDot");
            categoryRedConfig = qIMRedDotConfig.categories.get(Integer.valueOf(this.f66685d));
            if (categoryRedConfig != null) {
                if (categoryRedConfig.version != optInt) {
                    categoryRedConfig.version = optInt;
                    categoryRedConfig.showRedDot = optBoolean;
                    categoryRedConfig.hasShow = false;
                    categoryRedConfig.firstShowTime = 0L;
                }
            } else {
                categoryRedConfig = new QIMRedDotConfig.CategoryRedConfig();
                categoryRedConfig.categoryId = this.f66685d;
                categoryRedConfig.version = optInt;
                categoryRedConfig.showRedDot = optBoolean;
            }
        } else {
            categoryRedConfig = null;
        }
        if (jSONObject.has("content")) {
            JSONArray jSONArray3 = jSONObject.getJSONArray("content");
            ArrayList arrayList = new ArrayList();
            int length = jSONArray3.length();
            boolean z16 = false;
            for (int i16 = 0; i16 < length; i16++) {
                JSONObject jSONObject2 = jSONArray3.getJSONObject(i16);
                QIMFilterCategoryItem qIMFilterCategoryItem = new QIMFilterCategoryItem();
                qIMFilterCategoryItem.f66700h = jSONObject2.optString("iconUrl");
                qIMFilterCategoryItem.f66698e = jSONObject2.optString("name");
                qIMFilterCategoryItem.E = jSONObject2.optString("camera");
                qIMFilterCategoryItem.f66697d = jSONObject2.optString("id");
                qIMFilterCategoryItem.D = jSONObject2.optString("type_combo");
                qIMFilterCategoryItem.f66701i = this.f66685d;
                qIMFilterCategoryItem.f66702m = this.f66686e;
                qIMFilterCategoryItem.C = this.C;
                qIMFilterCategoryItem.M = jSONObject2.optString("jump_app");
                JSONArray optJSONArray = jSONObject2.optJSONArray("filters");
                if (optJSONArray != null) {
                    int length2 = optJSONArray.length();
                    for (int i17 = i3; i17 < length2; i17++) {
                        JSONObject jSONObject3 = optJSONArray.getJSONObject(i17);
                        String optString = jSONObject3.optString("name");
                        if (!TextUtils.isEmpty(optString)) {
                            qIMFilterCategoryItem.F.add(optString);
                        } else {
                            String optString2 = jSONObject3.optString("name_android");
                            if (!TextUtils.isEmpty(optString2)) {
                                qIMFilterCategoryItem.F.add(optString2);
                            }
                        }
                    }
                }
                qIMFilterCategoryItem.G = jSONObject2.optJSONArray("pasters");
                qIMFilterCategoryItem.H = jSONObject2.optJSONArray("musics");
                qIMFilterCategoryItem.I = jSONObject2.optJSONArray("ufaces");
                qIMFilterCategoryItem.J = jSONObject2.optJSONArray("texts");
                qIMFilterCategoryItem.N = jSONObject2.optString("desc", "");
                JSONArray jSONArray4 = qIMFilterCategoryItem.G;
                if ((jSONArray4 != null && jSONArray4.length() != 0) || (((jSONArray = qIMFilterCategoryItem.H) != null && jSONArray.length() != 0) || ((jSONArray2 = qIMFilterCategoryItem.I) != null && jSONArray2.length() != 0))) {
                    z16 = true;
                    qIMFilterCategoryItem.L = true;
                    i3 = 0;
                } else {
                    i3 = 0;
                    qIMFilterCategoryItem.L = false;
                }
                arrayList.add(qIMFilterCategoryItem);
            }
            this.f66687f = arrayList;
            if (qIMRedDotConfig != null && categoryRedConfig != null) {
                qIMRedDotConfig.categories.put(Integer.valueOf(categoryRedConfig.categoryId), categoryRedConfig);
            }
            this.f66688h = z16;
        }
    }

    protected FilterCategory(Parcel parcel) {
        this.f66690m = 0;
        this.C = 0;
        this.f66685d = parcel.readInt();
        this.f66686e = parcel.readString();
        this.f66687f = parcel.createTypedArrayList(QIMFilterCategoryItem.CREATOR);
        this.f66688h = parcel.readByte() != 0;
    }
}
