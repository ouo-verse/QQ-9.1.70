package com.tencent.mobileqq.ar.aidl;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.ar.model.ArDefaultSetting;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ArEffectConfig implements Parcelable {
    public static final Parcelable.Creator<ArEffectConfig> CREATOR = new a();
    public int C;
    public int D;
    public int E;
    public int F;
    public int G;
    public int H;
    public ArrayList<ArDefaultSetting> I;

    /* renamed from: d, reason: collision with root package name */
    public int f197711d;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList<String> f197712e;

    /* renamed from: f, reason: collision with root package name */
    public ArrayList<String> f197713f;

    /* renamed from: h, reason: collision with root package name */
    public ArrayList<String> f197714h;

    /* renamed from: i, reason: collision with root package name */
    public ArrayList<String> f197715i;

    /* renamed from: m, reason: collision with root package name */
    public int f197716m;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a implements Parcelable.Creator<ArEffectConfig> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ArEffectConfig createFromParcel(Parcel parcel) {
            return new ArEffectConfig(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ArEffectConfig[] newArray(int i3) {
            return new ArEffectConfig[i3];
        }
    }

    public ArEffectConfig() {
        this.f197712e = new ArrayList<>();
        this.f197713f = new ArrayList<>();
        this.f197714h = new ArrayList<>();
        this.f197715i = new ArrayList<>();
        this.f197716m = 80;
        this.C = 80;
        this.D = 80;
        this.E = 30;
        this.F = 30;
        this.G = 30;
        this.H = 30;
        this.I = new ArrayList<>();
    }

    public static ArEffectConfig a() {
        return null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("ArEffectConfig{");
        stringBuffer.append("version=");
        stringBuffer.append(this.f197711d);
        stringBuffer.append(", toplevelModel=");
        stringBuffer.append(this.f197712e);
        stringBuffer.append(", toplevelGPU=");
        stringBuffer.append(this.f197713f);
        stringBuffer.append(", blacklistModel=");
        stringBuffer.append(this.f197714h);
        stringBuffer.append(", blacklistGPU=");
        stringBuffer.append(this.f197715i);
        stringBuffer.append(", topModelStandard=");
        stringBuffer.append(this.f197716m);
        stringBuffer.append(", removeShadowLevel=");
        stringBuffer.append(this.C);
        stringBuffer.append(", adjustBone=");
        stringBuffer.append(this.D);
        stringBuffer.append(", traceQuality2=");
        stringBuffer.append(this.E);
        stringBuffer.append(", traceQuality3=");
        stringBuffer.append(this.F);
        stringBuffer.append(", traceQuality4=");
        stringBuffer.append(this.G);
        stringBuffer.append(", traceQuality5=");
        stringBuffer.append(this.H);
        stringBuffer.append(", defaultSettings=");
        stringBuffer.append(this.I);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f197711d);
        parcel.writeList(this.f197712e);
        parcel.writeList(this.f197713f);
        parcel.writeList(this.f197714h);
        parcel.writeList(this.f197715i);
        parcel.writeInt(this.f197716m);
        parcel.writeInt(this.C);
        parcel.writeInt(this.D);
        parcel.writeInt(this.E);
        parcel.writeInt(this.F);
        parcel.writeInt(this.G);
        parcel.writeInt(this.H);
        parcel.writeList(this.I);
    }

    public ArEffectConfig(Parcel parcel) {
        this.f197712e = new ArrayList<>();
        this.f197713f = new ArrayList<>();
        this.f197714h = new ArrayList<>();
        this.f197715i = new ArrayList<>();
        this.f197716m = 80;
        this.C = 80;
        this.D = 80;
        this.E = 30;
        this.F = 30;
        this.G = 30;
        this.H = 30;
        this.I = new ArrayList<>();
        this.f197711d = parcel.readInt();
        parcel.readList(this.f197712e, String.class.getClassLoader());
        parcel.readList(this.f197713f, String.class.getClassLoader());
        parcel.readList(this.f197714h, String.class.getClassLoader());
        parcel.readList(this.f197715i, String.class.getClassLoader());
        this.f197716m = parcel.readInt();
        this.C = parcel.readInt();
        this.D = parcel.readInt();
        this.E = parcel.readInt();
        this.F = parcel.readInt();
        this.G = parcel.readInt();
        this.H = parcel.readInt();
        parcel.readList(this.I, ArDefaultSetting.class.getClassLoader());
    }
}
