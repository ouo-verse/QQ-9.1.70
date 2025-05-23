package org.light.bean;

import android.os.Parcel;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes29.dex */
public class LightFaceData {
    public int[] cameraSize;
    public ByteBuffer imageByteBuffer;
    public byte[] imageData;
    public int[] imageSize;
    public List<LightFaceFeature> mLightFaceFeatureList;
    public int[] renderSize;

    public LightFaceData() {
        this.imageSize = new int[2];
        this.cameraSize = new int[2];
        this.renderSize = new int[2];
        this.mLightFaceFeatureList = new ArrayList();
    }

    public void revertFaceFeaturePoint() {
        List<LightFaceFeature> list;
        LightFaceFeature next;
        if (this.imageSize != null && (list = this.mLightFaceFeatureList) != null && list.size() != 0) {
            int i3 = this.imageSize[1];
            Iterator<LightFaceFeature> it = this.mLightFaceFeatureList.iterator();
            while (it.hasNext() && (next = it.next()) != null) {
                int i16 = 1;
                while (true) {
                    float[] fArr = next.facePoints;
                    if (i16 >= fArr.length) {
                        break;
                    }
                    fArr[i16] = i3 - fArr[i16];
                    i16 += 2;
                }
                int i17 = 1;
                while (true) {
                    float[] fArr2 = next.faceFeaturePoints;
                    if (i17 >= fArr2.length) {
                        break;
                    }
                    fArr2[i17] = i3 - fArr2[i17];
                    i17 += 2;
                }
                int i18 = 1;
                while (true) {
                    float[] fArr3 = next.faceFeature256Points;
                    if (i18 < fArr3.length) {
                        fArr3[i18] = i3 - fArr3[i18];
                        i18 += 2;
                    }
                }
            }
        }
    }

    public LightFaceData(int[] iArr, int[] iArr2, int[] iArr3) {
        this.imageSize = new int[2];
        this.cameraSize = new int[2];
        this.renderSize = new int[2];
        this.mLightFaceFeatureList = new ArrayList();
        this.imageSize = iArr;
        this.cameraSize = iArr2;
        this.renderSize = iArr3;
        revertFaceFeaturePoint();
    }

    protected LightFaceData(Parcel parcel) {
        this.imageSize = new int[2];
        this.cameraSize = new int[2];
        this.renderSize = new int[2];
        this.mLightFaceFeatureList = new ArrayList();
        this.imageData = parcel.createByteArray();
        this.imageSize = parcel.createIntArray();
        this.cameraSize = parcel.createIntArray();
        this.renderSize = parcel.createIntArray();
        this.mLightFaceFeatureList = parcel.createTypedArrayList(LightFaceFeature.CREATOR);
    }
}
