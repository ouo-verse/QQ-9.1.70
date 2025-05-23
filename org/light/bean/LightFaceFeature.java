package org.light.bean;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes29.dex */
public class LightFaceFeature implements Parcelable {
    public static final Parcelable.Creator<LightFaceFeature> CREATOR = new Parcelable.Creator<LightFaceFeature>() { // from class: org.light.bean.LightFaceFeature.1
        @Override // android.os.Parcelable.Creator
        public LightFaceFeature createFromParcel(Parcel parcel) {
            return new LightFaceFeature(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public LightFaceFeature[] newArray(int i3) {
            return new LightFaceFeature[i3];
        }
    };
    public int age;
    public String emotion;
    public HashMap<String, Boolean> expression_status_;
    public float[] faceBoundsRect;
    public float[] faceFeature256Points;
    public float[] faceFeature256Visibility;
    public float[] faceFeature3DPoints;
    public float[] faceFeaturePoints;
    public float[] faceFeatureVisibility;
    public float[] facePoint83;
    public float[] facePoint83Visibility;
    public float[] facePoint90;
    public float[] facePoint90Visibility;
    public float[] facePoints;
    public float[] facePointsVisible;
    public String gender;
    public boolean hasOutline;
    public float[] imageSize;
    public float[] leBounds;
    public TTFaceOriginDataModel mTTFaceOriginDataModel;
    public float[] mouthBounds;
    public float pitch;
    public float[] reBounds;
    public float roll;
    public int traceId;
    public float[] transform3D;
    public float yaw;

    public LightFaceFeature() {
        this.imageSize = new float[2];
        this.faceBoundsRect = new float[4];
        this.leBounds = new float[4];
        this.reBounds = new float[4];
        this.mouthBounds = new float[4];
        this.facePoints = new float[188];
        this.facePointsVisible = new float[94];
        this.facePoint83 = new float[166];
        this.facePoint83Visibility = new float[83];
        this.facePoint90 = new float[180];
        this.facePoint90Visibility = new float[90];
        this.faceFeaturePoints = new float[166];
        this.faceFeatureVisibility = new float[83];
        this.faceFeature256Points = new float[512];
        this.faceFeature256Visibility = new float[256];
        this.faceFeature3DPoints = new float[3000];
        this.transform3D = new float[16];
        this.expression_status_ = new HashMap<>();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void readFromParcel(Parcel parcel) {
        boolean z16;
        this.imageSize = parcel.createFloatArray();
        this.faceBoundsRect = parcel.createFloatArray();
        this.leBounds = parcel.createFloatArray();
        this.reBounds = parcel.createFloatArray();
        this.mouthBounds = parcel.createFloatArray();
        this.pitch = parcel.readFloat();
        this.yaw = parcel.readFloat();
        this.roll = parcel.readFloat();
        if (parcel.readByte() != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.hasOutline = z16;
        this.gender = parcel.readString();
        this.age = parcel.readInt();
        this.emotion = parcel.readString();
        this.traceId = parcel.readInt();
        this.facePoints = parcel.createFloatArray();
        this.facePointsVisible = parcel.createFloatArray();
        this.facePoint83 = parcel.createFloatArray();
        this.facePoint83Visibility = parcel.createFloatArray();
        this.facePoint90 = parcel.createFloatArray();
        this.facePoint90Visibility = parcel.createFloatArray();
        this.faceFeaturePoints = parcel.createFloatArray();
        this.faceFeatureVisibility = parcel.createFloatArray();
        this.faceFeature256Points = parcel.createFloatArray();
        this.faceFeature256Visibility = parcel.createFloatArray();
        this.faceFeature3DPoints = parcel.createFloatArray();
        this.transform3D = parcel.createFloatArray();
        this.expression_status_ = (HashMap) parcel.readSerializable();
        this.mTTFaceOriginDataModel = (TTFaceOriginDataModel) parcel.readSerializable();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeFloatArray(this.imageSize);
        parcel.writeFloatArray(this.faceBoundsRect);
        parcel.writeFloatArray(this.leBounds);
        parcel.writeFloatArray(this.reBounds);
        parcel.writeFloatArray(this.mouthBounds);
        parcel.writeFloat(this.pitch);
        parcel.writeFloat(this.yaw);
        parcel.writeFloat(this.roll);
        parcel.writeByte(this.hasOutline ? (byte) 1 : (byte) 0);
        parcel.writeString(this.gender);
        parcel.writeInt(this.age);
        parcel.writeString(this.emotion);
        parcel.writeInt(this.traceId);
        parcel.writeFloatArray(this.facePoints);
        parcel.writeFloatArray(this.facePointsVisible);
        parcel.writeFloatArray(this.facePoint83);
        parcel.writeFloatArray(this.facePoint83Visibility);
        parcel.writeFloatArray(this.facePoint90);
        parcel.writeFloatArray(this.facePoint90Visibility);
        parcel.writeFloatArray(this.faceFeaturePoints);
        parcel.writeFloatArray(this.faceFeatureVisibility);
        parcel.writeFloatArray(this.faceFeature256Points);
        parcel.writeFloatArray(this.faceFeature256Visibility);
        parcel.writeFloatArray(this.faceFeature3DPoints);
        parcel.writeFloatArray(this.transform3D);
        parcel.writeSerializable(this.expression_status_);
        parcel.writeSerializable(this.mTTFaceOriginDataModel);
    }

    public LightFaceFeature(float[] fArr, float[] fArr2, float[] fArr3, float[] fArr4, float[] fArr5, float f16, float f17, float f18, boolean z16, String str, float[] fArr6, float[] fArr7, float[] fArr8, float[] fArr9, float[] fArr10, float[] fArr11, float[] fArr12, float[] fArr13, float[] fArr14, float[] fArr15, HashMap<String, Boolean> hashMap, String str2) {
        this.imageSize = new float[2];
        this.faceBoundsRect = new float[4];
        this.leBounds = new float[4];
        this.reBounds = new float[4];
        this.mouthBounds = new float[4];
        this.facePoints = new float[188];
        this.facePointsVisible = new float[94];
        this.facePoint83 = new float[166];
        this.facePoint83Visibility = new float[83];
        this.facePoint90 = new float[180];
        this.facePoint90Visibility = new float[90];
        this.faceFeaturePoints = new float[166];
        this.faceFeatureVisibility = new float[83];
        this.faceFeature256Points = new float[512];
        this.faceFeature256Visibility = new float[256];
        this.faceFeature3DPoints = new float[3000];
        this.transform3D = new float[16];
        new HashMap();
        this.imageSize = fArr;
        this.faceBoundsRect = fArr2;
        this.leBounds = fArr3;
        this.reBounds = fArr4;
        this.mouthBounds = fArr5;
        this.pitch = f16;
        this.yaw = f17;
        this.roll = f18;
        this.hasOutline = z16;
        this.emotion = str;
        this.facePoints = fArr6;
        this.facePointsVisible = fArr7;
        this.facePoint83 = fArr8;
        this.facePoint83Visibility = fArr9;
        this.faceFeaturePoints = fArr8;
        this.faceFeatureVisibility = fArr9;
        this.facePoint90 = fArr10;
        this.facePoint90Visibility = fArr11;
        this.faceFeature256Points = fArr12;
        this.faceFeature256Visibility = fArr13;
        this.faceFeature3DPoints = fArr14;
        this.transform3D = fArr15;
        this.expression_status_ = hashMap;
        this.gender = str2;
        this.mTTFaceOriginDataModel = new TTFaceOriginDataModel(fArr6, fArr7, f16, f17, f18);
    }

    public LightFaceFeature(float[] fArr, float[] fArr2, float[] fArr3, float[] fArr4, float[] fArr5, float f16, float f17, float f18, boolean z16, String str, float[] fArr6, float[] fArr7, float[] fArr8, float[] fArr9, float[] fArr10, float[] fArr11, float[] fArr12, float[] fArr13, float[] fArr14, float[] fArr15, HashMap<String, Boolean> hashMap, String str2, int i3, int i16) {
        this.imageSize = new float[2];
        this.faceBoundsRect = new float[4];
        this.leBounds = new float[4];
        this.reBounds = new float[4];
        this.mouthBounds = new float[4];
        this.facePoints = new float[188];
        this.facePointsVisible = new float[94];
        this.facePoint83 = new float[166];
        this.facePoint83Visibility = new float[83];
        this.facePoint90 = new float[180];
        this.facePoint90Visibility = new float[90];
        this.faceFeaturePoints = new float[166];
        this.faceFeatureVisibility = new float[83];
        this.faceFeature256Points = new float[512];
        this.faceFeature256Visibility = new float[256];
        this.faceFeature3DPoints = new float[3000];
        this.transform3D = new float[16];
        new HashMap();
        this.imageSize = fArr;
        this.faceBoundsRect = fArr2;
        this.leBounds = fArr3;
        this.reBounds = fArr4;
        this.mouthBounds = fArr5;
        this.pitch = f16;
        this.yaw = f17;
        this.roll = f18;
        this.hasOutline = z16;
        this.emotion = str;
        this.facePoints = fArr6;
        this.facePointsVisible = fArr7;
        this.facePoint83 = fArr8;
        this.facePoint83Visibility = fArr9;
        this.faceFeaturePoints = fArr8;
        this.faceFeatureVisibility = fArr9;
        this.facePoint90 = fArr10;
        this.facePoint90Visibility = fArr11;
        this.faceFeature256Points = fArr12;
        this.faceFeature256Visibility = fArr13;
        this.faceFeature3DPoints = fArr14;
        this.transform3D = fArr15;
        this.expression_status_ = hashMap;
        this.gender = str2;
        this.age = i3;
        this.traceId = i16;
        this.mTTFaceOriginDataModel = new TTFaceOriginDataModel(fArr6, fArr7, f16, f17, f18);
    }

    public LightFaceFeature(float[] fArr, float[] fArr2, float[] fArr3, float[] fArr4, float[] fArr5, float f16, float f17, float f18, boolean z16, String str, float[] fArr6, float[] fArr7, float[] fArr8, float[] fArr9, float[] fArr10, float[] fArr11, float[] fArr12, float[] fArr13, float[] fArr14, float[] fArr15, HashMap<String, Boolean> hashMap) {
        this(fArr, fArr2, fArr3, fArr4, fArr5, f16, f17, f18, z16, str, fArr6, fArr7, fArr8, fArr9, fArr10, fArr11, fArr12, fArr13, fArr14, fArr15, hashMap, "");
    }

    protected LightFaceFeature(Parcel parcel) {
        this.imageSize = new float[2];
        this.faceBoundsRect = new float[4];
        this.leBounds = new float[4];
        this.reBounds = new float[4];
        this.mouthBounds = new float[4];
        this.facePoints = new float[188];
        this.facePointsVisible = new float[94];
        this.facePoint83 = new float[166];
        this.facePoint83Visibility = new float[83];
        this.facePoint90 = new float[180];
        this.facePoint90Visibility = new float[90];
        this.faceFeaturePoints = new float[166];
        this.faceFeatureVisibility = new float[83];
        this.faceFeature256Points = new float[512];
        this.faceFeature256Visibility = new float[256];
        this.faceFeature3DPoints = new float[3000];
        this.transform3D = new float[16];
        this.expression_status_ = new HashMap<>();
        this.imageSize = parcel.createFloatArray();
        this.faceBoundsRect = parcel.createFloatArray();
        this.leBounds = parcel.createFloatArray();
        this.reBounds = parcel.createFloatArray();
        this.mouthBounds = parcel.createFloatArray();
        this.pitch = parcel.readFloat();
        this.yaw = parcel.readFloat();
        this.roll = parcel.readFloat();
        this.hasOutline = parcel.readByte() != 0;
        this.gender = parcel.readString();
        this.age = parcel.readInt();
        this.emotion = parcel.readString();
        this.traceId = parcel.readInt();
        this.facePoints = parcel.createFloatArray();
        this.facePointsVisible = parcel.createFloatArray();
        this.facePoint83 = parcel.createFloatArray();
        this.facePoint83Visibility = parcel.createFloatArray();
        this.facePoint90 = parcel.createFloatArray();
        this.facePoint90Visibility = parcel.createFloatArray();
        this.faceFeaturePoints = parcel.createFloatArray();
        this.faceFeatureVisibility = parcel.createFloatArray();
        this.faceFeature256Points = parcel.createFloatArray();
        this.faceFeature256Visibility = parcel.createFloatArray();
        this.faceFeature3DPoints = parcel.createFloatArray();
        this.transform3D = parcel.createFloatArray();
        this.expression_status_ = (HashMap) parcel.readSerializable();
        this.mTTFaceOriginDataModel = (TTFaceOriginDataModel) parcel.readSerializable();
    }
}
