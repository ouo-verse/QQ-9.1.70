package c.t.m.g;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.ads.data.AdParam;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes.dex */
public class a3 implements Parcelable {
    public static final Parcelable.Creator<a3> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public String f29479a;

    /* renamed from: b, reason: collision with root package name */
    public String f29480b;

    /* renamed from: c, reason: collision with root package name */
    public String f29481c;

    /* renamed from: d, reason: collision with root package name */
    public double f29482d;

    /* renamed from: e, reason: collision with root package name */
    public double f29483e;

    /* renamed from: f, reason: collision with root package name */
    public double f29484f;

    /* renamed from: g, reason: collision with root package name */
    public String f29485g;

    /* renamed from: h, reason: collision with root package name */
    public String f29486h;

    public a3() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "AddressData{name=" + this.f29479a + ",dtype=" + this.f29480b + ",pointx=" + this.f29482d + ",pointy=" + this.f29483e + ",dist=" + this.f29484f + ",direction=" + this.f29485g + ",tag=" + this.f29486h + ",}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f29479a);
        parcel.writeString(this.f29480b);
        parcel.writeString(this.f29481c);
        parcel.writeDouble(this.f29482d);
        parcel.writeDouble(this.f29483e);
        parcel.writeDouble(this.f29484f);
        parcel.writeString(this.f29485g);
        parcel.writeString(this.f29486h);
    }

    public a3(JSONObject jSONObject) {
        this.f29479a = jSONObject.optString("name");
        this.f29480b = jSONObject.optString(AdParam.DTYPE);
        this.f29481c = jSONObject.optString("addr");
        this.f29482d = jSONObject.optDouble("pointx");
        this.f29483e = jSONObject.optDouble("pointy");
        this.f29484f = jSONObject.optDouble("dist");
        this.f29485g = jSONObject.optString("direction");
        this.f29486h = jSONObject.optString("tag");
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public class a implements Parcelable.Creator<a3> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a3 createFromParcel(Parcel parcel) {
            a3 a3Var = new a3();
            a3Var.f29479a = parcel.readString();
            a3Var.f29480b = parcel.readString();
            a3Var.f29481c = parcel.readString();
            a3Var.f29482d = parcel.readDouble();
            a3Var.f29483e = parcel.readDouble();
            a3Var.f29484f = parcel.readDouble();
            a3Var.f29485g = parcel.readString();
            a3Var.f29486h = parcel.readString();
            return a3Var;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a3[] newArray(int i3) {
            return new a3[i3];
        }
    }
}
