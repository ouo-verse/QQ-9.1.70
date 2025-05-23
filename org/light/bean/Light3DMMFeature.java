package org.light.bean;

import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes29.dex */
public class Light3DMMFeature implements Parcelable {
    public static final Parcelable.Creator<Light3DMMFeature> CREATOR = new Parcelable.Creator() { // from class: org.light.bean.Light3DMMFeature.1
        @Override // android.os.Parcelable.Creator
        public Light3DMMFeature createFromParcel(Parcel parcel) {
            return new Light3DMMFeature(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public Light3DMMFeature[] newArray(int i3) {
            return new Light3DMMFeature[i3];
        }
    };
    public float[] euler;
    public float[] exp;
    public int face_kit_vertex_num;
    public float[] face_kit_vertices;
    public boolean is_kissing;
    public float point_scale;
    public float[] proj_face_vertices;
    public float scale;
    public int trace_id;
    public float[][] trans_matrix;
    public float[][] transform;
    public PointF translate;

    public Light3DMMFeature(float[][] fArr, float[][] fArr2, float[] fArr3, float[] fArr4, PointF pointF, int i3, float[] fArr5, float[] fArr6, int i16, float f16, float f17, boolean z16) {
        this.trans_matrix = fArr;
        this.transform = fArr2;
        this.euler = fArr3;
        this.exp = fArr4;
        this.translate = pointF;
        this.face_kit_vertex_num = i3;
        this.face_kit_vertices = fArr5;
        this.proj_face_vertices = fArr6;
        this.trace_id = i16;
        this.point_scale = f16;
        this.scale = f17;
        this.is_kissing = z16;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void readFromParcel(Parcel parcel) {
        this.trans_matrix = new float[parcel.readInt()];
        boolean z16 = false;
        for (int i3 = 0; i3 < this.trans_matrix.length; i3++) {
            float[] fArr = new float[parcel.readInt()];
            this.trans_matrix[i3] = fArr;
            parcel.readFloatArray(fArr);
        }
        this.transform = new float[parcel.readInt()];
        for (int i16 = 0; i16 < this.transform.length; i16++) {
            float[] fArr2 = new float[parcel.readInt()];
            this.transform[i16] = fArr2;
            parcel.readFloatArray(fArr2);
        }
        this.euler = parcel.createFloatArray();
        this.exp = parcel.createFloatArray();
        this.translate = (PointF) parcel.readParcelable(PointF.class.getClassLoader());
        this.face_kit_vertex_num = parcel.readInt();
        this.face_kit_vertices = parcel.createFloatArray();
        this.proj_face_vertices = parcel.createFloatArray();
        this.trace_id = parcel.readInt();
        this.point_scale = parcel.readFloat();
        this.scale = parcel.readFloat();
        if (parcel.readByte() != 0) {
            z16 = true;
        }
        this.is_kissing = z16;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.trans_matrix.length);
        for (float[] fArr : this.trans_matrix) {
            parcel.writeFloat(fArr.length);
            parcel.writeFloatArray(fArr);
        }
        parcel.writeInt(this.transform.length);
        for (float[] fArr2 : this.transform) {
            parcel.writeFloat(fArr2.length);
            parcel.writeFloatArray(fArr2);
        }
        parcel.writeFloatArray(this.euler);
        parcel.writeFloatArray(this.exp);
        parcel.writeParcelable(this.translate, i3);
        parcel.writeInt(this.face_kit_vertex_num);
        parcel.writeFloatArray(this.face_kit_vertices);
        parcel.writeFloatArray(this.proj_face_vertices);
        parcel.writeInt(this.trace_id);
        parcel.writeFloat(this.point_scale);
        parcel.writeFloat(this.scale);
        parcel.writeByte(this.is_kissing ? (byte) 1 : (byte) 0);
    }

    protected Light3DMMFeature(Parcel parcel) {
        this.trans_matrix = new float[parcel.readInt()];
        for (int i3 = 0; i3 < this.trans_matrix.length; i3++) {
            float[] fArr = new float[parcel.readInt()];
            this.trans_matrix[i3] = fArr;
            parcel.readFloatArray(fArr);
        }
        this.transform = new float[parcel.readInt()];
        for (int i16 = 0; i16 < this.transform.length; i16++) {
            float[] fArr2 = new float[parcel.readInt()];
            this.transform[i16] = fArr2;
            parcel.readFloatArray(fArr2);
        }
        this.euler = parcel.createFloatArray();
        this.exp = parcel.createFloatArray();
        this.translate = (PointF) parcel.readParcelable(PointF.class.getClassLoader());
        this.face_kit_vertex_num = parcel.readInt();
        this.face_kit_vertices = parcel.createFloatArray();
        this.proj_face_vertices = parcel.createFloatArray();
        this.trace_id = parcel.readInt();
        this.point_scale = parcel.readFloat();
        this.scale = parcel.readFloat();
        this.is_kissing = parcel.readByte() != 0;
    }
}
