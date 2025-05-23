package com.tencent.aelight.camera.aioeditor.capture.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.gcore.abase.utils.PatternUtils;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.m;
import com.tencent.av.opengl.filter.qqavimage.QQAVImageFilterConstants;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes32.dex */
public class QIMFilterCategoryItem implements Parcelable, Cloneable {
    public static final Parcelable.Creator<QIMFilterCategoryItem> CREATOR = new a();
    public int C;
    public String D;
    public String E;
    public ArrayList<String> F;
    public JSONArray G;
    public JSONArray H;
    public JSONArray I;
    public JSONArray J;
    public int K;
    public boolean L;
    public String M;
    public String N;

    /* renamed from: d, reason: collision with root package name */
    public String f66697d;

    /* renamed from: e, reason: collision with root package name */
    public String f66698e;

    /* renamed from: f, reason: collision with root package name */
    public String f66699f;

    /* renamed from: h, reason: collision with root package name */
    public String f66700h;

    /* renamed from: i, reason: collision with root package name */
    public int f66701i;

    /* renamed from: m, reason: collision with root package name */
    public String f66702m;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a implements Parcelable.Creator<QIMFilterCategoryItem> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public QIMFilterCategoryItem createFromParcel(Parcel parcel) {
            return new QIMFilterCategoryItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public QIMFilterCategoryItem[] newArray(int i3) {
            return new QIMFilterCategoryItem[i3];
        }
    }

    public QIMFilterCategoryItem() {
        this.f66699f = "";
        this.C = 0;
        this.E = null;
        this.F = new ArrayList<>();
        this.K = 0;
        this.N = "";
    }

    public static boolean f(QIMFilterCategoryItem qIMFilterCategoryItem) {
        Iterator<String> it = qIMFilterCategoryItem.F.iterator();
        while (it.hasNext()) {
            FilterDesc m3 = m.n().m(it.next());
            if (m3 != null && m3.f281357id == 9) {
                return true;
            }
        }
        return false;
    }

    public static boolean m(QIMFilterCategoryItem qIMFilterCategoryItem) {
        return false;
    }

    public boolean a() {
        Iterator<String> it = this.F.iterator();
        while (it.hasNext()) {
            String next = it.next();
            for (String str : f.f66733a) {
                if (str.equals(next)) {
                    return false;
                }
            }
        }
        return true;
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public QIMFilterCategoryItem clone() {
        try {
            return (QIMFilterCategoryItem) super.clone();
        } catch (CloneNotSupportedException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public JSONObject c() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", this.f66697d);
            jSONObject.put("name", this.f66698e);
            jSONObject.put("camera", this.E);
            jSONObject.put("iconUrl", this.f66700h);
            jSONObject.put("categoryId", this.f66701i);
            jSONObject.put("categoryName", this.f66702m);
            ArrayList<String> arrayList = this.F;
            if (arrayList != null && !arrayList.isEmpty()) {
                JSONArray jSONArray = new JSONArray();
                Iterator<String> it = this.F.iterator();
                while (it.hasNext()) {
                    jSONArray.mo162put(it.next());
                }
                jSONObject.put("filterIds", jSONArray);
            }
            jSONObject.put("isCombo", this.L);
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean e() {
        ArrayList<String> arrayList = this.F;
        return arrayList != null && arrayList.contains("AIFilter");
    }

    public int hashCode() {
        return this.f66697d.intern().hashCode();
    }

    public boolean j() {
        ArrayList<String> arrayList;
        return !this.L && (arrayList = this.F) != null && arrayList.size() == 1 && QQAVImageFilterConstants.getFilterType(m.n().m(this.F.get(0)).f281357id) == 0;
    }

    public boolean k() {
        ArrayList<String> arrayList = this.F;
        if (arrayList != null) {
            return arrayList.contains(PatternUtils.NO_MATCH) || this.F.contains("EMPTY2");
        }
        return false;
    }

    public boolean l() {
        ArrayList<String> arrayList = this.F;
        return arrayList != null && arrayList.contains(PatternUtils.NO_MATCH);
    }

    public boolean n() {
        return "2".equals(this.D) || "3".equals(this.D);
    }

    public String toString() {
        return "FilterCategoryItem{id='" + this.f66697d + "', name='" + this.f66698e + "', isCombo=" + this.L + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f66697d);
        parcel.writeString(this.f66698e);
        parcel.writeString(this.E);
        parcel.writeString(this.f66700h);
        parcel.writeInt(this.f66701i);
        parcel.writeString(this.f66702m);
        parcel.writeStringList(this.F);
        parcel.writeInt(0);
        parcel.writeByte(this.L ? (byte) 1 : (byte) 0);
        parcel.writeString(this.M);
        parcel.writeString(this.N);
    }

    public boolean equals(Object obj) {
        return obj != null && obj.hashCode() == hashCode();
    }

    protected QIMFilterCategoryItem(Parcel parcel) {
        this.f66699f = "";
        this.C = 0;
        this.E = null;
        this.F = new ArrayList<>();
        this.K = 0;
        this.N = "";
        this.f66697d = parcel.readString();
        this.f66698e = parcel.readString();
        this.E = parcel.readString();
        this.f66700h = parcel.readString();
        this.f66701i = parcel.readInt();
        this.f66702m = parcel.readString();
        this.F = parcel.createStringArrayList();
        parcel.readInt();
        this.L = parcel.readByte() != 0;
        this.M = parcel.readString();
        this.N = parcel.readString();
    }
}
