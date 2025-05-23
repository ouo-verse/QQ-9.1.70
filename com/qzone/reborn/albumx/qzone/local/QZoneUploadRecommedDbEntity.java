package com.qzone.reborn.albumx.qzone.local;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneUploadRecommedDbEntity extends Entity {

    @unique
    public String mPath = "none";
    public int mWidth = -1;
    public int mHeight = -1;
    public long mScanTime = -1;
    public String mSmallPicPath = "none";
    public long mTakePicTime = -1;
    public long mAddTime = -1;
    public String mFestival = "none";
    public String mTheDayOfWeek = "none";
    public String mMonthAndDay = "none";
    public String mFullDate = "none";
    public String mYear = "none";
    public String mProvince = "none";
    public String mCity = "none";
    public float mLongitude = -1.0f;
    public float mLatitude = -1.0f;
    public int mFaceSize = -1;
    public String mFaceId1 = "none";
    public String mFaceId2 = "none";
    public String mFaceId3 = "none";
    public String mFaceId4 = "none";
    public int mFaceAge1 = -1;
    public int mFaceAge2 = -1;
    public int mFaceAge3 = -1;
    public int mFaceAge4 = -1;
    public int mFaceGender1 = -1;
    public int mFaceGender2 = -1;
    public int mFaceGender3 = -1;
    public int mFaceGender4 = -1;
    public int mFaceRatio1 = -1;
    public int mFaceRatio2 = -1;
    public int mFaceRatio3 = -1;
    public int mFaceRatio4 = -1;
    public String mTagType = "none";
    public String mTagSubType = "none";
    public long mUploadTime = -1;
    public float mTagScore = -1.0f;
}
