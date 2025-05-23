package com.tencent.ttpic.openapi;

import java.util.ArrayList;

/* loaded from: classes27.dex */
public class PTGenderAttr {
    public static final int GENDER_FEMALE = 0;
    public static final int GENDER_MALE = 1;
    private ArrayList<GenderInfo> genderInfos;

    /* loaded from: classes27.dex */
    public class GenderInfo {
        public float confidence;
        public int curGender;
        public long faceId;
        public int gender;
        public float[] rect;

        GenderInfo(long j3, float[] fArr, int i3, int i16, float f16) {
            this.faceId = j3;
            this.rect = fArr;
            this.gender = i3;
            this.confidence = f16;
            this.curGender = i16;
        }
    }

    public void addGenderInfo(long j3, float[] fArr, int i3, int i16, float f16) {
        if (this.genderInfos == null) {
            this.genderInfos = new ArrayList<>();
        }
        this.genderInfos.add(new GenderInfo(j3, fArr, i3, i16, f16));
    }

    public ArrayList<GenderInfo> getGenderInfos() {
        return this.genderInfos;
    }
}
