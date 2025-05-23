package com.qzone.reborn.albumx.qzone.local;

import com.tencent.biz.richframework.localupload.recommend.bean.RFWMediaInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0004\u00a8\u0006\n"}, d2 = {"Lcom/qzone/reborn/albumx/qzone/local/h;", "", "Lcom/tencent/biz/richframework/localupload/recommend/bean/RFWMediaInfo;", "mediaInfo", "Lcom/qzone/reborn/albumx/qzone/local/QZoneUploadRecommedDbEntity;", "a", "dbEntity", "b", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final h f52663a = new h();

    h() {
    }

    public final QZoneUploadRecommedDbEntity a(RFWMediaInfo mediaInfo) {
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        QZoneUploadRecommedDbEntity qZoneUploadRecommedDbEntity = new QZoneUploadRecommedDbEntity();
        qZoneUploadRecommedDbEntity.setId(mediaInfo.getMId());
        qZoneUploadRecommedDbEntity.mFaceSize = mediaInfo.getMFaceSize();
        qZoneUploadRecommedDbEntity.mFaceId1 = mediaInfo.getMFaceId1();
        qZoneUploadRecommedDbEntity.mFaceId2 = mediaInfo.getMFaceId2();
        qZoneUploadRecommedDbEntity.mFaceId3 = mediaInfo.getMFaceId3();
        qZoneUploadRecommedDbEntity.mFaceId4 = mediaInfo.getMFaceId4();
        qZoneUploadRecommedDbEntity.mFaceAge1 = mediaInfo.getMFaceAge1();
        qZoneUploadRecommedDbEntity.mFaceAge2 = mediaInfo.getMFaceAge2();
        qZoneUploadRecommedDbEntity.mFaceAge3 = mediaInfo.getMFaceAge3();
        qZoneUploadRecommedDbEntity.mFaceAge4 = mediaInfo.getMFaceAge4();
        qZoneUploadRecommedDbEntity.mFaceGender1 = mediaInfo.getMFaceGender1();
        qZoneUploadRecommedDbEntity.mFaceGender2 = mediaInfo.getMFaceGender2();
        qZoneUploadRecommedDbEntity.mFaceGender3 = mediaInfo.getMFaceGender3();
        qZoneUploadRecommedDbEntity.mFaceGender4 = mediaInfo.getMFaceGender4();
        qZoneUploadRecommedDbEntity.mFaceRatio1 = mediaInfo.getMFaceRatio1();
        qZoneUploadRecommedDbEntity.mFaceRatio2 = mediaInfo.getMFaceRatio2();
        qZoneUploadRecommedDbEntity.mFaceRatio3 = mediaInfo.getMFaceRatio3();
        qZoneUploadRecommedDbEntity.mFaceRatio4 = mediaInfo.getMFaceRatio4();
        qZoneUploadRecommedDbEntity.mCity = mediaInfo.getMCity();
        qZoneUploadRecommedDbEntity.mProvince = mediaInfo.getMProvince();
        qZoneUploadRecommedDbEntity.mPath = mediaInfo.getMPath();
        qZoneUploadRecommedDbEntity.mWidth = mediaInfo.getMWidth();
        qZoneUploadRecommedDbEntity.mHeight = mediaInfo.getMHeight();
        qZoneUploadRecommedDbEntity.mScanTime = mediaInfo.getMScanTime();
        qZoneUploadRecommedDbEntity.mSmallPicPath = mediaInfo.getMSmallPicPath();
        qZoneUploadRecommedDbEntity.mTagType = mediaInfo.getMTagType();
        qZoneUploadRecommedDbEntity.mTagSubType = mediaInfo.getMTagSubType();
        qZoneUploadRecommedDbEntity.mUploadTime = mediaInfo.getMUploadTime();
        qZoneUploadRecommedDbEntity.mTagScore = mediaInfo.getMTagScore();
        qZoneUploadRecommedDbEntity.mLatitude = mediaInfo.getMLatitude();
        qZoneUploadRecommedDbEntity.mLongitude = mediaInfo.getMLongitude();
        qZoneUploadRecommedDbEntity.mTakePicTime = mediaInfo.getMTakePicTime();
        qZoneUploadRecommedDbEntity.mAddTime = mediaInfo.getMAddTime();
        qZoneUploadRecommedDbEntity.mTheDayOfWeek = mediaInfo.getMTheDayOfWeek();
        qZoneUploadRecommedDbEntity.mMonthAndDay = mediaInfo.getMMonthAndDay();
        qZoneUploadRecommedDbEntity.mFullDate = mediaInfo.getMFullDate();
        qZoneUploadRecommedDbEntity.mYear = mediaInfo.getMYear();
        qZoneUploadRecommedDbEntity.mFestival = mediaInfo.getMFestival();
        return qZoneUploadRecommedDbEntity;
    }

    public final RFWMediaInfo b(QZoneUploadRecommedDbEntity dbEntity) {
        Intrinsics.checkNotNullParameter(dbEntity, "dbEntity");
        RFWMediaInfo rFWMediaInfo = new RFWMediaInfo();
        rFWMediaInfo.setMId(dbEntity.getId());
        rFWMediaInfo.setMFaceSize(dbEntity.mFaceSize);
        String str = dbEntity.mFaceId1;
        Intrinsics.checkNotNullExpressionValue(str, "dbEntity.mFaceId1");
        rFWMediaInfo.setMFaceId1(str);
        String str2 = dbEntity.mFaceId2;
        Intrinsics.checkNotNullExpressionValue(str2, "dbEntity.mFaceId2");
        rFWMediaInfo.setMFaceId2(str2);
        String str3 = dbEntity.mFaceId3;
        Intrinsics.checkNotNullExpressionValue(str3, "dbEntity.mFaceId3");
        rFWMediaInfo.setMFaceId3(str3);
        String str4 = dbEntity.mFaceId4;
        Intrinsics.checkNotNullExpressionValue(str4, "dbEntity.mFaceId4");
        rFWMediaInfo.setMFaceId4(str4);
        rFWMediaInfo.setMFaceAge1(dbEntity.mFaceAge1);
        rFWMediaInfo.setMFaceAge2(dbEntity.mFaceAge2);
        rFWMediaInfo.setMFaceAge3(dbEntity.mFaceAge3);
        rFWMediaInfo.setMFaceAge4(dbEntity.mFaceAge4);
        rFWMediaInfo.setMFaceGender1(dbEntity.mFaceGender1);
        rFWMediaInfo.setMFaceGender2(dbEntity.mFaceGender2);
        rFWMediaInfo.setMFaceGender3(dbEntity.mFaceGender3);
        rFWMediaInfo.setMFaceGender4(dbEntity.mFaceGender4);
        rFWMediaInfo.setMFaceRatio1(dbEntity.mFaceRatio1);
        rFWMediaInfo.setMFaceRatio2(dbEntity.mFaceRatio2);
        rFWMediaInfo.setMFaceRatio3(dbEntity.mFaceRatio3);
        rFWMediaInfo.setMFaceRatio4(dbEntity.mFaceRatio4);
        String str5 = dbEntity.mCity;
        Intrinsics.checkNotNullExpressionValue(str5, "dbEntity.mCity");
        rFWMediaInfo.setMCity(str5);
        String str6 = dbEntity.mProvince;
        Intrinsics.checkNotNullExpressionValue(str6, "dbEntity.mProvince");
        rFWMediaInfo.setMProvince(str6);
        String str7 = dbEntity.mPath;
        Intrinsics.checkNotNullExpressionValue(str7, "dbEntity.mPath");
        rFWMediaInfo.setMPath(str7);
        rFWMediaInfo.setMWidth(dbEntity.mWidth);
        rFWMediaInfo.setMHeight(dbEntity.mHeight);
        rFWMediaInfo.setMScanTime(dbEntity.mScanTime);
        String str8 = dbEntity.mSmallPicPath;
        Intrinsics.checkNotNullExpressionValue(str8, "dbEntity.mSmallPicPath");
        rFWMediaInfo.setMSmallPicPath(str8);
        String str9 = dbEntity.mTagType;
        Intrinsics.checkNotNullExpressionValue(str9, "dbEntity.mTagType");
        rFWMediaInfo.setMTagType(str9);
        String str10 = dbEntity.mTagSubType;
        Intrinsics.checkNotNullExpressionValue(str10, "dbEntity.mTagSubType");
        rFWMediaInfo.setMTagSubType(str10);
        rFWMediaInfo.setMUploadTime(dbEntity.mUploadTime);
        rFWMediaInfo.setMTagScore(dbEntity.mTagScore);
        rFWMediaInfo.setMLatitude(dbEntity.mLatitude);
        rFWMediaInfo.setMLongitude(dbEntity.mLongitude);
        rFWMediaInfo.setMTakePicTime(dbEntity.mTakePicTime);
        rFWMediaInfo.setMAddTime(dbEntity.mAddTime);
        String str11 = dbEntity.mTheDayOfWeek;
        Intrinsics.checkNotNullExpressionValue(str11, "dbEntity.mTheDayOfWeek");
        rFWMediaInfo.setMTheDayOfWeek(str11);
        String str12 = dbEntity.mMonthAndDay;
        Intrinsics.checkNotNullExpressionValue(str12, "dbEntity.mMonthAndDay");
        rFWMediaInfo.setMMonthAndDay(str12);
        String str13 = dbEntity.mFullDate;
        Intrinsics.checkNotNullExpressionValue(str13, "dbEntity.mFullDate");
        rFWMediaInfo.setMFullDate(str13);
        String str14 = dbEntity.mYear;
        Intrinsics.checkNotNullExpressionValue(str14, "dbEntity.mYear");
        rFWMediaInfo.setMYear(str14);
        String str15 = dbEntity.mFestival;
        Intrinsics.checkNotNullExpressionValue(str15, "dbEntity.mFestival");
        rFWMediaInfo.setMFestival(str15);
        return rFWMediaInfo;
    }
}
