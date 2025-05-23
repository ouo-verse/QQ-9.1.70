package com.tencent.biz.richframework.localupload.recommend.bean;

import android.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.localupload.recommend.RecommendContext;
import com.tencent.biz.richframework.localupload.recommend.utils.RFWRecommendDateUtils;
import com.tencent.biz.richframework.localupload.recommend.utils.RFWRecommendUtil;
import com.tencent.mobileqq.wink.model.a;
import com.tencent.weiyun.poi.PoiDbManager;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b;\n\u0002\u0010\u0007\n\u0002\bM\u0018\u0000 \u009d\u00012\u00020\u0001:\u0004\u009d\u0001\u009e\u0001B\t\u00a2\u0006\u0006\b\u009b\u0001\u0010\u009c\u0001J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J$\u0010\u000b\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bJ\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0011\u001a\u00020\u000fJ\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012J\u000e\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0012J\u000e\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0016J\u0006\u0010\u0019\u001a\u00020\bJ\u0006\u0010\u001a\u001a\u00020\fJ\u0006\u0010\u001b\u001a\u00020\u000fR\"\u0010\u001c\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010\"\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010(\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u0010.\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010)\u001a\u0004\b/\u0010+\"\u0004\b0\u0010-R\"\u00101\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u0010\u001d\u001a\u0004\b2\u0010\u001f\"\u0004\b3\u0010!R\"\u00104\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b4\u0010#\u001a\u0004\b5\u0010%\"\u0004\b6\u0010'R\"\u00107\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b7\u0010\u001d\u001a\u0004\b8\u0010\u001f\"\u0004\b9\u0010!R\"\u0010:\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b:\u0010\u001d\u001a\u0004\b;\u0010\u001f\"\u0004\b<\u0010!R\"\u0010=\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b=\u0010#\u001a\u0004\b>\u0010%\"\u0004\b?\u0010'R\"\u0010@\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b@\u0010#\u001a\u0004\bA\u0010%\"\u0004\bB\u0010'R\"\u0010C\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bC\u0010#\u001a\u0004\bD\u0010%\"\u0004\bE\u0010'R\"\u0010F\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bF\u0010#\u001a\u0004\bG\u0010%\"\u0004\bH\u0010'R\"\u0010I\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bI\u0010#\u001a\u0004\bJ\u0010%\"\u0004\bK\u0010'R\"\u0010L\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bL\u0010#\u001a\u0004\bM\u0010%\"\u0004\bN\u0010'R\"\u0010O\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bO\u0010#\u001a\u0004\bP\u0010%\"\u0004\bQ\u0010'R\"\u0010S\u001a\u00020R8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bS\u0010T\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\"\u0010Y\u001a\u00020R8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bY\u0010T\u001a\u0004\bZ\u0010V\"\u0004\b[\u0010XR\"\u0010\\\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\\\u0010)\u001a\u0004\b]\u0010+\"\u0004\b^\u0010-R\"\u0010_\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b_\u0010#\u001a\u0004\b`\u0010%\"\u0004\ba\u0010'R\"\u0010b\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bb\u0010#\u001a\u0004\bc\u0010%\"\u0004\bd\u0010'R\"\u0010e\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\be\u0010#\u001a\u0004\bf\u0010%\"\u0004\bg\u0010'R\"\u0010h\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bh\u0010#\u001a\u0004\bi\u0010%\"\u0004\bj\u0010'R\"\u0010k\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bk\u0010)\u001a\u0004\bl\u0010+\"\u0004\bm\u0010-R\"\u0010n\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bn\u0010)\u001a\u0004\bo\u0010+\"\u0004\bp\u0010-R\"\u0010q\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bq\u0010)\u001a\u0004\br\u0010+\"\u0004\bs\u0010-R\"\u0010t\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bt\u0010)\u001a\u0004\bu\u0010+\"\u0004\bv\u0010-R\"\u0010w\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bw\u0010)\u001a\u0004\bx\u0010+\"\u0004\by\u0010-R\"\u0010z\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bz\u0010)\u001a\u0004\b{\u0010+\"\u0004\b|\u0010-R\"\u0010}\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b}\u0010)\u001a\u0004\b~\u0010+\"\u0004\b\u007f\u0010-R&\u0010\u0080\u0001\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u0080\u0001\u0010)\u001a\u0005\b\u0081\u0001\u0010+\"\u0005\b\u0082\u0001\u0010-R&\u0010\u0083\u0001\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u0083\u0001\u0010)\u001a\u0005\b\u0084\u0001\u0010+\"\u0005\b\u0085\u0001\u0010-R&\u0010\u0086\u0001\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u0086\u0001\u0010)\u001a\u0005\b\u0087\u0001\u0010+\"\u0005\b\u0088\u0001\u0010-R&\u0010\u0089\u0001\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u0089\u0001\u0010)\u001a\u0005\b\u008a\u0001\u0010+\"\u0005\b\u008b\u0001\u0010-R&\u0010\u008c\u0001\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u008c\u0001\u0010)\u001a\u0005\b\u008d\u0001\u0010+\"\u0005\b\u008e\u0001\u0010-R&\u0010\u008f\u0001\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u008f\u0001\u0010#\u001a\u0005\b\u0090\u0001\u0010%\"\u0005\b\u0091\u0001\u0010'R&\u0010\u0092\u0001\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u0092\u0001\u0010#\u001a\u0005\b\u0093\u0001\u0010%\"\u0005\b\u0094\u0001\u0010'R&\u0010\u0095\u0001\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u0095\u0001\u0010\u001d\u001a\u0005\b\u0096\u0001\u0010\u001f\"\u0005\b\u0097\u0001\u0010!R&\u0010\u0098\u0001\u001a\u00020R8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u0098\u0001\u0010T\u001a\u0005\b\u0099\u0001\u0010V\"\u0005\b\u009a\u0001\u0010X\u00a8\u0006\u009f\u0001"}, d2 = {"Lcom/tencent/biz/richframework/localupload/recommend/bean/RFWMediaInfo;", "", "Lcom/tencent/mobileqq/wink/model/a;", "result", "", "fillResearchInfo", "", "facedRect", "", "imageWidth", "imageHeight", "calculateFaceRate", "", PoiDbManager.TBL_POI, "fillPoiInfo", "", "needRunResearch", "havePoiInfo", "Lcom/tencent/biz/richframework/localupload/recommend/RecommendContext;", "context", "fillInfoByExif", "fileExists", "", "maxVal", "isMatchTimeDistance", "getSharpness", "getDebugInfo", "needRequestPoi", "mId", "J", "getMId", "()J", "setMId", "(J)V", "mPath", "Ljava/lang/String;", "getMPath", "()Ljava/lang/String;", "setMPath", "(Ljava/lang/String;)V", "mWidth", "I", "getMWidth", "()I", "setMWidth", "(I)V", "mHeight", "getMHeight", "setMHeight", "mScanTime", "getMScanTime", "setMScanTime", "mSmallPicPath", "getMSmallPicPath", "setMSmallPicPath", "mTakePicTime", "getMTakePicTime", "setMTakePicTime", "mAddTime", "getMAddTime", "setMAddTime", "mFestival", "getMFestival", "setMFestival", "mTheDayOfWeek", "getMTheDayOfWeek", "setMTheDayOfWeek", "mMonthAndDay", "getMMonthAndDay", "setMMonthAndDay", "mFullDate", "getMFullDate", "setMFullDate", "mYear", "getMYear", "setMYear", "mProvince", "getMProvince", "setMProvince", "mCity", "getMCity", "setMCity", "", "mLongitude", UserInfo.SEX_FEMALE, "getMLongitude", "()F", "setMLongitude", "(F)V", "mLatitude", "getMLatitude", "setMLatitude", "mFaceSize", "getMFaceSize", "setMFaceSize", "mFaceId1", "getMFaceId1", "setMFaceId1", "mFaceId2", "getMFaceId2", "setMFaceId2", "mFaceId3", "getMFaceId3", "setMFaceId3", "mFaceId4", "getMFaceId4", "setMFaceId4", "mFaceAge1", "getMFaceAge1", "setMFaceAge1", "mFaceAge2", "getMFaceAge2", "setMFaceAge2", "mFaceAge3", "getMFaceAge3", "setMFaceAge3", "mFaceAge4", "getMFaceAge4", "setMFaceAge4", "mFaceGender1", "getMFaceGender1", "setMFaceGender1", "mFaceGender2", "getMFaceGender2", "setMFaceGender2", "mFaceGender3", "getMFaceGender3", "setMFaceGender3", "mFaceGender4", "getMFaceGender4", "setMFaceGender4", "mFaceRatio1", "getMFaceRatio1", "setMFaceRatio1", "mFaceRatio2", "getMFaceRatio2", "setMFaceRatio2", "mFaceRatio3", "getMFaceRatio3", "setMFaceRatio3", "mFaceRatio4", "getMFaceRatio4", "setMFaceRatio4", "mTagType", "getMTagType", "setMTagType", "mTagSubType", "getMTagSubType", "setMTagSubType", "mUploadTime", "getMUploadTime", "setMUploadTime", "mTagScore", "getMTagScore", "setMTagScore", "<init>", "()V", "Companion", "DataUpdateType", "local-upload-recommend-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class RFWMediaInfo {

    @NotNull
    private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
    private long mId = -1;

    @NotNull
    private String mPath = "none";
    private int mWidth = -1;
    private int mHeight = -1;
    private long mScanTime = -1;

    @NotNull
    private String mSmallPicPath = "none";
    private long mTakePicTime = -1;
    private long mAddTime = -1;

    @NotNull
    private String mFestival = "none";

    @NotNull
    private String mTheDayOfWeek = "none";

    @NotNull
    private String mMonthAndDay = "none";

    @NotNull
    private String mFullDate = "none";

    @NotNull
    private String mYear = "none";

    @NotNull
    private String mProvince = "none";

    @NotNull
    private String mCity = "none";
    private float mLongitude = -1.0f;
    private float mLatitude = -1.0f;
    private int mFaceSize = -1;

    @NotNull
    private String mFaceId1 = "none";

    @NotNull
    private String mFaceId2 = "none";

    @NotNull
    private String mFaceId3 = "none";

    @NotNull
    private String mFaceId4 = "none";
    private int mFaceAge1 = -1;
    private int mFaceAge2 = -1;
    private int mFaceAge3 = -1;
    private int mFaceAge4 = -1;
    private int mFaceGender1 = -1;
    private int mFaceGender2 = -1;
    private int mFaceGender3 = -1;
    private int mFaceGender4 = -1;
    private int mFaceRatio1 = -1;
    private int mFaceRatio2 = -1;
    private int mFaceRatio3 = -1;
    private int mFaceRatio4 = -1;

    @NotNull
    private String mTagType = "none";

    @NotNull
    private String mTagSubType = "none";
    private long mUploadTime = -1;
    private float mTagScore = -1.0f;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/biz/richframework/localupload/recommend/bean/RFWMediaInfo$DataUpdateType;", "", "(Ljava/lang/String;I)V", "DEFAULT", "FIRST_PAGE_HOLDER", "BASE_DATA", "RESEARCH_DATA", "POI_DATA", "ALL_DATA", "CACHE_PLACEHOLDER", "NO_UPDATE_AND_USE_CACHE", "local-upload-recommend-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public enum DataUpdateType {
        DEFAULT,
        FIRST_PAGE_HOLDER,
        BASE_DATA,
        RESEARCH_DATA,
        POI_DATA,
        ALL_DATA,
        CACHE_PLACEHOLDER,
        NO_UPDATE_AND_USE_CACHE
    }

    public final int calculateFaceRate(@NotNull List<Object> facedRect, int imageWidth, int imageHeight) {
        Intrinsics.checkNotNullParameter(facedRect, "facedRect");
        if (facedRect.size() >= 4 && imageWidth > 0 && imageHeight > 0 && (facedRect.get(2) instanceof Integer) && (facedRect.get(3) instanceof Integer)) {
            Object obj = facedRect.get(2);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            int intValue = ((Integer) obj).intValue();
            Intrinsics.checkNotNull(facedRect.get(3), "null cannot be cast to non-null type kotlin.Int");
            return (int) (((intValue * ((Integer) r4).intValue()) * 100.0f) / (imageWidth * imageHeight));
        }
        return -1;
    }

    public final boolean fileExists(@NotNull RecommendContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        boolean exists = new File(this.mPath).exists();
        if (!exists) {
            context.d("RFWMediaInfo", "[fileExists] file " + this.mPath + " is not exists");
        }
        return exists;
    }

    public final void fillInfoByExif(@NotNull RecommendContext context) {
        boolean z16;
        long j3;
        Intrinsics.checkNotNullParameter(context, "context");
        boolean z17 = true;
        try {
            ExifInterface exifInterface = new ExifInterface(this.mPath);
            String attribute = exifInterface.getAttribute("DateTime");
            if (attribute != null) {
                Date parse = SDF.parse(attribute);
                if (parse != null) {
                    j3 = parse.getTime();
                } else {
                    j3 = -1;
                }
                this.mTakePicTime = j3;
            }
            float[] rationalLatLon = RFWRecommendUtil.INSTANCE.getRationalLatLon(context, exifInterface, this.mPath);
            if (rationalLatLon != null) {
                this.mLatitude = rationalLatLon[0];
                this.mLongitude = rationalLatLon[1];
            }
            context.dev("RFWMediaInfo", "[fillInfoByExif] result, path: " + this.mPath + ", mTakePicTime: " + this.mTakePicTime + ", mLatitude: " + this.mLatitude + ", mLongitude: " + this.mLongitude);
        } catch (Exception e16) {
            context.e("RFWMediaInfo", "[fillInfoByExif] error:" + e16 + ",path:" + this.mPath);
        }
        long j16 = this.mTakePicTime;
        if (j16 != -1) {
            String holidayName = RFWRecommendDateUtils.getHolidayName(j16);
            if (holidayName == null) {
                holidayName = "";
            }
            this.mFestival = holidayName;
        } else {
            this.mTakePicTime = this.mAddTime;
            this.mFestival = "";
        }
        String dayOfWeek = RFWRecommendDateUtils.getDayOfWeek(this.mTakePicTime);
        Intrinsics.checkNotNullExpressionValue(dayOfWeek, "getDayOfWeek(mTakePicTime)");
        this.mTheDayOfWeek = dayOfWeek;
        String monthAndDay = RFWRecommendDateUtils.getMonthAndDay(this.mTakePicTime);
        Intrinsics.checkNotNullExpressionValue(monthAndDay, "getMonthAndDay(mTakePicTime)");
        this.mMonthAndDay = monthAndDay;
        String dateTime = RFWRecommendDateUtils.getDateTime(this.mTakePicTime);
        Intrinsics.checkNotNullExpressionValue(dateTime, "getDateTime(mTakePicTime)");
        this.mFullDate = dateTime;
        this.mYear = String.valueOf(RFWRecommendDateUtils.getYear(this.mTakePicTime));
        if (this.mLatitude == -1.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (this.mLongitude != -1.0f) {
                z17 = false;
            }
            if (z17) {
                this.mLatitude = 0.0f;
                this.mLongitude = 0.0f;
                this.mCity = "";
            }
        }
    }

    public final void fillPoiInfo(@NotNull String poi) {
        Intrinsics.checkNotNullParameter(poi, "poi");
        this.mCity = poi;
    }

    public final void fillResearchInfo(@NotNull a result) {
        Intrinsics.checkNotNullParameter(result, "result");
        result.b().isEmpty();
        String classifyType = result.b().get(0).getClassifyType();
        if (classifyType != null) {
            this.mTagType = classifyType;
        }
        String classifyName = result.b().get(0).getClassifyName();
        if (classifyName != null) {
            this.mTagSubType = classifyName;
        }
        this.mTagScore = result.b().get(0).getClassifyConfidence();
        this.mFaceSize = result.a().size();
        if (result.a().size() > 0) {
            a.b bVar = result.a().get(0);
            this.mFaceAge1 = bVar.getAge();
            this.mFaceGender1 = bVar.getGender();
            this.mFaceRatio1 = calculateFaceRate(bVar.b(), bVar.getFrameW(), bVar.getFrameH());
        }
        if (result.a().size() > 1) {
            a.b bVar2 = result.a().get(1);
            this.mFaceAge2 = bVar2.getAge();
            this.mFaceGender2 = bVar2.getGender();
            this.mFaceRatio2 = calculateFaceRate(bVar2.b(), bVar2.getFrameW(), bVar2.getFrameH());
        }
        if (result.a().size() > 2) {
            a.b bVar3 = result.a().get(2);
            this.mFaceAge3 = bVar3.getAge();
            this.mFaceGender3 = bVar3.getGender();
            this.mFaceRatio3 = calculateFaceRate(bVar3.b(), bVar3.getFrameW(), bVar3.getFrameH());
        }
        if (result.a().size() > 3) {
            a.b bVar4 = result.a().get(3);
            this.mFaceAge4 = bVar4.getAge();
            this.mFaceGender4 = bVar4.getGender();
            this.mFaceRatio4 = calculateFaceRate(bVar4.b(), bVar4.getFrameW(), bVar4.getFrameH());
        }
    }

    @NotNull
    public final String getDebugInfo() {
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(this.mTakePicTime));
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format2 = String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(this.mTagScore)}, 1));
        Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
        return " tag: " + this.mTagType + ", " + this.mTagSubType + ", " + format2 + " \n city: " + this.mCity + ", " + this.mLongitude + ", " + this.mLatitude + "\n wh: " + this.mWidth + ", " + this.mHeight + "; " + this.mFaceRatio1 + "," + this.mFaceRatio2 + "\n " + format + "\n " + this.mPath;
    }

    public final long getMAddTime() {
        return this.mAddTime;
    }

    @NotNull
    public final String getMCity() {
        return this.mCity;
    }

    public final int getMFaceAge1() {
        return this.mFaceAge1;
    }

    public final int getMFaceAge2() {
        return this.mFaceAge2;
    }

    public final int getMFaceAge3() {
        return this.mFaceAge3;
    }

    public final int getMFaceAge4() {
        return this.mFaceAge4;
    }

    public final int getMFaceGender1() {
        return this.mFaceGender1;
    }

    public final int getMFaceGender2() {
        return this.mFaceGender2;
    }

    public final int getMFaceGender3() {
        return this.mFaceGender3;
    }

    public final int getMFaceGender4() {
        return this.mFaceGender4;
    }

    @NotNull
    public final String getMFaceId1() {
        return this.mFaceId1;
    }

    @NotNull
    public final String getMFaceId2() {
        return this.mFaceId2;
    }

    @NotNull
    public final String getMFaceId3() {
        return this.mFaceId3;
    }

    @NotNull
    public final String getMFaceId4() {
        return this.mFaceId4;
    }

    public final int getMFaceRatio1() {
        return this.mFaceRatio1;
    }

    public final int getMFaceRatio2() {
        return this.mFaceRatio2;
    }

    public final int getMFaceRatio3() {
        return this.mFaceRatio3;
    }

    public final int getMFaceRatio4() {
        return this.mFaceRatio4;
    }

    public final int getMFaceSize() {
        return this.mFaceSize;
    }

    @NotNull
    public final String getMFestival() {
        return this.mFestival;
    }

    @NotNull
    public final String getMFullDate() {
        return this.mFullDate;
    }

    public final int getMHeight() {
        return this.mHeight;
    }

    public final long getMId() {
        return this.mId;
    }

    public final float getMLatitude() {
        return this.mLatitude;
    }

    public final float getMLongitude() {
        return this.mLongitude;
    }

    @NotNull
    public final String getMMonthAndDay() {
        return this.mMonthAndDay;
    }

    @NotNull
    public final String getMPath() {
        return this.mPath;
    }

    @NotNull
    public final String getMProvince() {
        return this.mProvince;
    }

    public final long getMScanTime() {
        return this.mScanTime;
    }

    @NotNull
    public final String getMSmallPicPath() {
        return this.mSmallPicPath;
    }

    public final float getMTagScore() {
        return this.mTagScore;
    }

    @NotNull
    public final String getMTagSubType() {
        return this.mTagSubType;
    }

    @NotNull
    public final String getMTagType() {
        return this.mTagType;
    }

    public final long getMTakePicTime() {
        return this.mTakePicTime;
    }

    @NotNull
    public final String getMTheDayOfWeek() {
        return this.mTheDayOfWeek;
    }

    public final long getMUploadTime() {
        return this.mUploadTime;
    }

    public final int getMWidth() {
        return this.mWidth;
    }

    @NotNull
    public final String getMYear() {
        return this.mYear;
    }

    public final int getSharpness() {
        return this.mWidth * this.mHeight;
    }

    public final boolean havePoiInfo() {
        boolean z16;
        if (Intrinsics.areEqual(this.mCity, "none")) {
            return false;
        }
        if (this.mCity.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        return true;
    }

    public final boolean isMatchTimeDistance(long maxVal) {
        long currentTimeMillis = System.currentTimeMillis() - this.mTakePicTime;
        if (currentTimeMillis >= 0 && currentTimeMillis <= maxVal) {
            return true;
        }
        return false;
    }

    public final boolean needRequestPoi() {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        if (!Intrinsics.areEqual(this.mCity, "none")) {
            return false;
        }
        float f16 = this.mLatitude;
        if (f16 == 0.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return false;
        }
        float f17 = this.mLongitude;
        if (f17 == 0.0f) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            return false;
        }
        if (f16 == -1.0f) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z18) {
            return false;
        }
        if (f17 == -1.0f) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (z19) {
            return false;
        }
        return true;
    }

    public final boolean needRunResearch() {
        if (this.mFaceSize != -1 && !Intrinsics.areEqual(this.mTagType, "none")) {
            return false;
        }
        return true;
    }

    public final void setMAddTime(long j3) {
        this.mAddTime = j3;
    }

    public final void setMCity(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mCity = str;
    }

    public final void setMFaceAge1(int i3) {
        this.mFaceAge1 = i3;
    }

    public final void setMFaceAge2(int i3) {
        this.mFaceAge2 = i3;
    }

    public final void setMFaceAge3(int i3) {
        this.mFaceAge3 = i3;
    }

    public final void setMFaceAge4(int i3) {
        this.mFaceAge4 = i3;
    }

    public final void setMFaceGender1(int i3) {
        this.mFaceGender1 = i3;
    }

    public final void setMFaceGender2(int i3) {
        this.mFaceGender2 = i3;
    }

    public final void setMFaceGender3(int i3) {
        this.mFaceGender3 = i3;
    }

    public final void setMFaceGender4(int i3) {
        this.mFaceGender4 = i3;
    }

    public final void setMFaceId1(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mFaceId1 = str;
    }

    public final void setMFaceId2(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mFaceId2 = str;
    }

    public final void setMFaceId3(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mFaceId3 = str;
    }

    public final void setMFaceId4(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mFaceId4 = str;
    }

    public final void setMFaceRatio1(int i3) {
        this.mFaceRatio1 = i3;
    }

    public final void setMFaceRatio2(int i3) {
        this.mFaceRatio2 = i3;
    }

    public final void setMFaceRatio3(int i3) {
        this.mFaceRatio3 = i3;
    }

    public final void setMFaceRatio4(int i3) {
        this.mFaceRatio4 = i3;
    }

    public final void setMFaceSize(int i3) {
        this.mFaceSize = i3;
    }

    public final void setMFestival(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mFestival = str;
    }

    public final void setMFullDate(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mFullDate = str;
    }

    public final void setMHeight(int i3) {
        this.mHeight = i3;
    }

    public final void setMId(long j3) {
        this.mId = j3;
    }

    public final void setMLatitude(float f16) {
        this.mLatitude = f16;
    }

    public final void setMLongitude(float f16) {
        this.mLongitude = f16;
    }

    public final void setMMonthAndDay(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mMonthAndDay = str;
    }

    public final void setMPath(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mPath = str;
    }

    public final void setMProvince(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mProvince = str;
    }

    public final void setMScanTime(long j3) {
        this.mScanTime = j3;
    }

    public final void setMSmallPicPath(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mSmallPicPath = str;
    }

    public final void setMTagScore(float f16) {
        this.mTagScore = f16;
    }

    public final void setMTagSubType(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mTagSubType = str;
    }

    public final void setMTagType(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mTagType = str;
    }

    public final void setMTakePicTime(long j3) {
        this.mTakePicTime = j3;
    }

    public final void setMTheDayOfWeek(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mTheDayOfWeek = str;
    }

    public final void setMUploadTime(long j3) {
        this.mUploadTime = j3;
    }

    public final void setMWidth(int i3) {
        this.mWidth = i3;
    }

    public final void setMYear(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mYear = str;
    }
}
