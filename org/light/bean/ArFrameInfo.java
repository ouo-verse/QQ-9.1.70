package org.light.bean;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ArFrameInfo {
    public float[] cameraModelMatrix;
    public List<Plane> planeList;
    public double[] projectionMatrix;

    public ArFrameInfo() {
        this.cameraModelMatrix = new float[16];
        this.projectionMatrix = new double[16];
    }

    public double[] float2double(float[] fArr) {
        double[] dArr = new double[fArr.length];
        for (int i3 = 0; i3 < fArr.length; i3++) {
            dArr[i3] = fArr[i3];
        }
        return dArr;
    }

    public String printFloatArray(float[] fArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (float f16 : fArr) {
            stringBuffer.append(f16);
            stringBuffer.append(",");
        }
        return stringBuffer.toString();
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class Plane implements Parcelable {
        public static final Parcelable.Creator<Plane> CREATOR = new Parcelable.Creator<Plane>() { // from class: org.light.bean.ArFrameInfo.Plane.1
            @Override // android.os.Parcelable.Creator
            public Plane createFromParcel(Parcel parcel) {
                return new Plane(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public Plane[] newArray(int i3) {
                return new Plane[i3];
            }
        };
        public float[] arbitraryPoint;
        public float[] normal;

        public Plane() {
            this.arbitraryPoint = new float[3];
            this.normal = new float[3];
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeFloatArray(this.arbitraryPoint);
            parcel.writeFloatArray(this.normal);
        }

        protected Plane(Parcel parcel) {
            this.arbitraryPoint = new float[3];
            this.normal = new float[3];
            this.arbitraryPoint = parcel.createFloatArray();
            this.normal = parcel.createFloatArray();
        }
    }

    protected ArFrameInfo(Parcel parcel) {
        this.cameraModelMatrix = new float[16];
        this.projectionMatrix = new double[16];
        this.cameraModelMatrix = parcel.createFloatArray();
        this.projectionMatrix = parcel.createDoubleArray();
        this.planeList = parcel.createTypedArrayList(Plane.CREATOR);
    }
}
