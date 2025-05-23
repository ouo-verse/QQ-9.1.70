package com.tencent.aelight.camera.aioeditor.richmedia.capture.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.aelight.camera.aioeditor.richmedia.capture.data.CaptureRedDotConfig;
import com.tencent.aelight.camera.struct.editor.FilterCategoryItem;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes32.dex */
public class FilterCategory implements Parcelable {
    public static final Parcelable.Creator<FilterCategory> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    public int f67455d;

    /* renamed from: e, reason: collision with root package name */
    public String f67456e;

    /* renamed from: f, reason: collision with root package name */
    public List<FilterCategoryItem> f67457f;

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

    public FilterCategory(JSONObject jSONObject, CaptureRedDotConfig captureRedDotConfig) throws JSONException {
        CaptureRedDotConfig.CategoryRedConfig categoryRedConfig;
        this.f67456e = jSONObject.optString("name");
        this.f67455d = jSONObject.optInt("categoryId");
        if (captureRedDotConfig != null) {
            int optInt = jSONObject.optInt("redDotVersion");
            boolean optBoolean = jSONObject.optBoolean("needRedDot");
            categoryRedConfig = captureRedDotConfig.categories.get(Integer.valueOf(this.f67455d));
            if (categoryRedConfig != null) {
                if (categoryRedConfig.version != optInt) {
                    categoryRedConfig.version = optInt;
                    categoryRedConfig.showRedDot = optBoolean;
                    categoryRedConfig.hasShow = false;
                    categoryRedConfig.firstShowTime = 0L;
                }
            } else {
                categoryRedConfig = new CaptureRedDotConfig.CategoryRedConfig();
                categoryRedConfig.categoryId = this.f67455d;
                categoryRedConfig.version = optInt;
                categoryRedConfig.showRedDot = optBoolean;
            }
        } else {
            categoryRedConfig = null;
        }
        if (jSONObject.has("content")) {
            JSONArray jSONArray = jSONObject.getJSONArray("content");
            ArrayList arrayList = new ArrayList();
            int length = jSONArray.length();
            int i3 = 0;
            while (i3 < length) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                FilterCategoryItem filterCategoryItem = new FilterCategoryItem();
                filterCategoryItem.f69063h = jSONObject2.optString("iconUrl");
                filterCategoryItem.f69061e = jSONObject2.optString("name");
                filterCategoryItem.f69060d = jSONObject2.optString("id");
                filterCategoryItem.f69065m = this.f67455d;
                filterCategoryItem.C = jSONObject2.optString("englishName");
                filterCategoryItem.D = jSONObject2.optString("usedPeople");
                boolean optBoolean2 = jSONObject2.optBoolean("advertisement");
                filterCategoryItem.E = optBoolean2;
                if (optBoolean2) {
                    QLog.d("FilterCategory", 2, "item.advertisement is true name is:" + filterCategoryItem.f69061e);
                    try {
                        filterCategoryItem.J = jSONObject2.optString("badgeurl");
                        filterCategoryItem.G = jSONObject2.optString("openurl");
                        filterCategoryItem.F = jSONObject2.optString("androidopenurlheader");
                        filterCategoryItem.H = jSONObject2.optString("storeurl");
                        filterCategoryItem.I = jSONObject2.optBoolean("popup");
                        filterCategoryItem.M = jSONObject2.optString("popupbtn");
                        filterCategoryItem.L = jSONObject2.optString("popupcontent");
                        filterCategoryItem.P = jSONObject2.optString("popupbtn2");
                        filterCategoryItem.N = jSONObject2.optString("popupcontent2");
                        filterCategoryItem.K = jSONObject2.optString("popupimgurl");
                        filterCategoryItem.Q = jSONObject2.optString("buttonbgcolor");
                    } catch (Exception e16) {
                        QLog.e("FilterCategory", 2, "item.advertisement is true has Exception", e16);
                    }
                } else {
                    JSONArray optJSONArray = jSONObject2.optJSONArray("filters");
                    if (optJSONArray != null) {
                        int length2 = optJSONArray.length();
                        for (int i16 = 0; i16 < length2; i16++) {
                            String optString = optJSONArray.getJSONObject(i16).optString("name");
                            if (!TextUtils.isEmpty(optString)) {
                                filterCategoryItem.S.add(optString);
                            }
                        }
                    }
                    FilterDesc b16 = filterCategoryItem.b();
                    i3 = (b16 == null || b16.type != 1 || QmcfManager.getInstance().hasQmcfEntrance(1)) ? i3 : i3 + 1;
                }
                arrayList.add(filterCategoryItem);
            }
            this.f67457f = arrayList;
            if (captureRedDotConfig == null || categoryRedConfig == null) {
                return;
            }
            captureRedDotConfig.categories.put(Integer.valueOf(categoryRedConfig.categoryId), categoryRedConfig);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f67455d);
        parcel.writeString(this.f67456e);
        parcel.writeTypedList(this.f67457f);
    }

    protected FilterCategory(Parcel parcel) {
        this.f67455d = parcel.readInt();
        this.f67456e = parcel.readString();
        this.f67457f = parcel.createTypedArrayList(FilterCategoryItem.CREATOR);
    }
}
