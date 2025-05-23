package com.tencent.mobileqq.ar.aidl;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.mobileqq.ar.model.ARRelationShip;
import com.tencent.mobileqq.ar.model.ArAwardInfo;
import com.tencent.mobileqq.ar.model.ArFeatureInfo;
import com.tencent.mobileqq.ar.model.ArLBSActivity;
import com.tencent.mobileqq.ar.model.ArModelResource;
import com.tencent.mobileqq.ar.model.ArVideoResourceInfo;
import com.tencent.mobileqq.ar.model.ArWebInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ArCloudConfigInfo implements Parcelable {
    public static final Parcelable.Creator<ArCloudConfigInfo> CREATOR = new a();
    public static int N = 3;
    public int C;
    public ArrayList<ArVideoResourceInfo> D;
    public ArFeatureInfo E;
    public ArModelResource F;
    public ArAwardInfo G;
    public ArWebInfo H;
    public int I;
    public ARRelationShip J;
    public boolean K;
    public ArLBSActivity L;
    public com.tencent.mobileqq.ar.ARPromotion.c M;

    /* renamed from: d, reason: collision with root package name */
    public int f197698d;

    /* renamed from: e, reason: collision with root package name */
    public String f197699e;

    /* renamed from: f, reason: collision with root package name */
    public int f197700f;

    /* renamed from: h, reason: collision with root package name */
    public int f197701h;

    /* renamed from: i, reason: collision with root package name */
    public int f197702i;

    /* renamed from: m, reason: collision with root package name */
    public String f197703m;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a implements Parcelable.Creator<ArCloudConfigInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ArCloudConfigInfo createFromParcel(Parcel parcel) {
            return new ArCloudConfigInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ArCloudConfigInfo[] newArray(int i3) {
            return new ArCloudConfigInfo[i3];
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f197704a = 0;

        /* renamed from: b, reason: collision with root package name */
        public int f197705b = 0;

        /* renamed from: c, reason: collision with root package name */
        public float f197706c = 2.0f;

        /* renamed from: d, reason: collision with root package name */
        public float f197707d = 2.0f;

        /* renamed from: e, reason: collision with root package name */
        public float f197708e = 0.0f;

        /* renamed from: f, reason: collision with root package name */
        public float f197709f = 0.0f;

        /* renamed from: g, reason: collision with root package name */
        public float f197710g = 0.0f;

        public String toString() {
            return "ARVideoLayout {width: " + this.f197704a + ", height: " + this.f197705b + ", scaleX: " + this.f197706c + ", scaleY: " + this.f197707d + ", transX: " + this.f197708e + ", transY: " + this.f197709f + ", transZ: " + this.f197710g + "}";
        }
    }

    public ArCloudConfigInfo() {
        this.D = new ArrayList<>();
        this.K = false;
        this.M = null;
    }

    public boolean a() {
        if (this.I == 1 && this.f197702i == 7) {
            return true;
        }
        return false;
    }

    public boolean b() {
        if (this.f197702i == 8) {
            return true;
        }
        return false;
    }

    public boolean c() {
        if (this.f197698d == 1) {
            return true;
        }
        return false;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean e() {
        if (this.f197702i == 100) {
            return true;
        }
        return false;
    }

    public boolean f() {
        if (this.f197701h == 0) {
            return true;
        }
        return false;
    }

    public boolean g() {
        ArWebInfo arWebInfo = this.H;
        if (arWebInfo == null) {
            return false;
        }
        return arWebInfo.f198433e;
    }

    public boolean j() {
        if (this.f197702i != 6 && (!c() || this.C != 0)) {
            return true;
        }
        return false;
    }

    public boolean k() {
        ArWebInfo arWebInfo = this.H;
        if (arWebInfo == null || !TextUtils.isEmpty(arWebInfo.f198434f) || this.f197698d == 1 || f()) {
            return false;
        }
        return true;
    }

    public boolean l() {
        ArWebInfo arWebInfo = this.H;
        if (arWebInfo == null) {
            return false;
        }
        if ((this.f197698d != 1 || this.C != 1) && TextUtils.isEmpty(arWebInfo.f198434f)) {
            return false;
        }
        return true;
    }

    public boolean m() {
        if (this.f197701h == 2) {
            return true;
        }
        return false;
    }

    public boolean n() {
        if (this.f197701h == 1) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("ArCloudConfigInfo{");
        stringBuffer.append("mArFeatureInfo='");
        stringBuffer.append(this.E);
        stringBuffer.append('\'');
        stringBuffer.append(", modelResource=");
        stringBuffer.append(this.F);
        stringBuffer.append(", mIsRelationShip=");
        stringBuffer.append(this.I);
        stringBuffer.append(", mArLBSActivity = ");
        stringBuffer.append(this.L);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        QLog.i("ArCloudConfigInfo", 1, "writeToParcel  start ");
        parcel.writeInt(this.f197698d);
        parcel.writeString(this.f197699e);
        parcel.writeInt(this.f197700f);
        parcel.writeInt(this.f197701h);
        parcel.writeInt(this.f197702i);
        parcel.writeString(this.f197703m);
        parcel.writeInt(this.C);
        try {
            parcel.writeList(this.D);
            parcel.writeParcelable(this.E, i3);
            parcel.writeParcelable(this.F, i3);
            parcel.writeParcelable(this.G, i3);
            parcel.writeParcelable(this.H, i3);
        } catch (Exception e16) {
            QLog.i("ArCloudConfigInfo", 1, "writeList  fail= " + e16.getMessage());
        }
        try {
            parcel.writeInt(this.I);
            parcel.writeParcelable(this.J, i3);
            parcel.writeParcelable(this.L, i3);
        } catch (Exception e17) {
            QLog.i("ArCloudConfigInfo", 1, "writeToParcel failed. msg = " + e17.getMessage());
        }
        try {
            QLog.i("ArCloudConfigInfo", 1, "writeToParcel  businessId = " + this.f197698d + ",  sDKVersion = " + this.f197699e + ",  closeCache = " + this.f197700f + ",  trackMode = " + this.f197701h + ",  type = " + this.f197702i + ",  picId = " + this.f197703m + ",  mArFeatureInfo = " + this.E + ",  modelResource = " + this.F + ",  mArWebInfo = " + this.H + ", mArLBSActivity = " + this.L);
        } catch (Exception e18) {
            QLog.i("ArCloudConfigInfo", 1, "IQLog" + e18.getMessage());
        }
        QLog.i("ArCloudConfigInfo", 1, "writeToParcel  end VersionCode" + N);
    }

    protected ArCloudConfigInfo(Parcel parcel) {
        this.D = new ArrayList<>();
        this.M = null;
        this.K = true;
        QLog.i("ArCloudConfigInfo", 1, "readParcel  start ");
        this.f197698d = parcel.readInt();
        this.f197699e = parcel.readString();
        this.f197700f = parcel.readInt();
        this.f197701h = parcel.readInt();
        this.f197702i = parcel.readInt();
        this.f197703m = parcel.readString();
        this.C = parcel.readInt();
        try {
            ArrayList<ArVideoResourceInfo> arrayList = new ArrayList<>();
            this.D = arrayList;
            parcel.readList(arrayList, ArVideoResourceInfo.class.getClassLoader());
            this.E = (ArFeatureInfo) parcel.readParcelable(ArFeatureInfo.class.getClassLoader());
            this.F = (ArModelResource) parcel.readParcelable(ArModelResource.class.getClassLoader());
            this.G = (ArAwardInfo) parcel.readParcelable(ArAwardInfo.class.getClassLoader());
            this.H = (ArWebInfo) parcel.readParcelable(ArWebInfo.class.getClassLoader());
        } catch (Exception e16) {
            this.K = false;
            QLog.i("ArCloudConfigInfo", 1, "ArVideoResourceInfo read fail= " + e16.getMessage());
        }
        try {
            if (19 <= N) {
                this.I = parcel.readInt();
                this.J = (ARRelationShip) parcel.readParcelable(ARRelationShip.class.getClassLoader());
                if (20 <= N) {
                    this.L = (ArLBSActivity) parcel.readParcelable(ArLBSActivity.class.getClassLoader());
                }
            }
        } catch (Exception e17) {
            this.K = false;
            QLog.i("ArCloudConfigInfo", 1, "readParcel failed. msg = " + e17.getMessage());
        }
        try {
            QLog.i("ArCloudConfigInfo", 1, "readParcel  businessId = " + this.f197698d + ",  sDKVersion = " + this.f197699e + ",  closeCache = " + this.f197700f + ",  trackMode = " + this.f197701h + ",  type = " + this.f197702i + ",  picId = " + this.f197703m + ",  mArFeatureInfo = " + this.E + ",  modelResource = " + this.F + ",  mArWebInfo = " + this.H + ", mArLBSActivity = " + this.L);
        } catch (Exception e18) {
            this.K = false;
            QLog.i("ArCloudConfigInfo", 1, "IQLog" + e18.getMessage());
        }
        QLog.i("ArCloudConfigInfo", 1, "readParcel  end flag = " + this.K + "  VersionCode :" + N);
    }
}
