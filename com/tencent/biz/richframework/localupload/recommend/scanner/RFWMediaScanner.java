package com.tencent.biz.richframework.localupload.recommend.scanner;

import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.biz.richframework.localupload.recommend.RecommendContext;
import com.tencent.biz.richframework.localupload.recommend.bean.RFWMediaInfo;
import com.tencent.biz.richframework.localupload.recommend.utils.RFWRecommendUtil;
import com.tencent.weiyun.transmission.db.JobDbManager;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsJVMKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000bH\u0002J\"\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\bH\u0002J \u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\bH\u0002J\u001e\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/biz/richframework/localupload/recommend/scanner/RFWMediaScanner;", "", "mContext", "Lcom/tencent/biz/richframework/localupload/recommend/RecommendContext;", "(Lcom/tencent/biz/richframework/localupload/recommend/RecommendContext;)V", "filterPhotoSize", "", "width", "", "height", "getPicRateConfig", "", "configKey", "", RemoteHandleConst.PARAM_DEFAULT_VALUE, "loadPhotoFromCursor", "", "Lcom/tencent/biz/richframework/localupload/recommend/bean/RFWMediaInfo;", "cursor", "Landroid/database/Cursor;", "maxPhotoNum", "scanPhoto", "Lcom/tencent/biz/richframework/localupload/recommend/scanner/RFWMediaScanResult;", "startSecond", "", "endSecond", "startScan", "Companion", "local-upload-recommend-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class RFWMediaScanner {

    @NotNull
    private final RecommendContext mContext;

    public RFWMediaScanner(@NotNull RecommendContext mContext) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        this.mContext = mContext;
    }

    private final boolean filterPhotoSize(int width, int height) {
        float f16 = width;
        float f17 = height;
        if (f16 <= f17 * 2.5f && f17 <= 2.5f * f16) {
            float f18 = (1.0f * f16) / f17;
            float picRateConfig = getPicRateConfig("width_height_ratio_min", 0.5f);
            float picRateConfig2 = getPicRateConfig("width_height_ratio_max", 2.0f);
            if (f18 >= picRateConfig && f18 <= picRateConfig2) {
                float picRateConfig3 = getPicRateConfig("width_height_min", 1000.0f);
                if (f16 >= picRateConfig3 && f17 >= picRateConfig3) {
                    return false;
                }
                this.mContext.d("RFWMediaScanner", "[loadPhotoFromCursor] filter low pixel pic");
                return true;
            }
            this.mContext.d("RFWMediaScanner", "[loadPhotoFromCursor] filter abnormal size pic: " + f18);
            return true;
        }
        this.mContext.d("RFWMediaScanner", "[loadPhotoFromCursor] filter long pic");
        return true;
    }

    private final float getPicRateConfig(String configKey, float defaultValue) {
        Float floatOrNull;
        floatOrNull = StringsKt__StringNumberConversionsJVMKt.toFloatOrNull(RFWRecommendUtil.INSTANCE.getClassifyConfig(this.mContext, configKey));
        if (floatOrNull != null) {
            return floatOrNull.floatValue();
        }
        return defaultValue;
    }

    private final List<RFWMediaInfo> loadPhotoFromCursor(Cursor cursor, int maxPhotoNum) {
        RFWMediaScanner rFWMediaScanner = this;
        Cursor cursor2 = cursor;
        if (cursor2 != null && cursor.getCount() != 0) {
            int columnIndexOrThrow = cursor2.getColumnIndexOrThrow("_id");
            int columnIndexOrThrow2 = cursor2.getColumnIndexOrThrow("_data");
            int columnIndexOrThrow3 = cursor2.getColumnIndexOrThrow("date_added");
            int columnIndexOrThrow4 = cursor2.getColumnIndexOrThrow(JobDbManager.COL_UP_MIME_TYPE);
            int columnIndexOrThrow5 = cursor2.getColumnIndexOrThrow("width");
            int columnIndexOrThrow6 = cursor2.getColumnIndexOrThrow("height");
            ArrayList arrayList = new ArrayList();
            while (true) {
                if (!cursor.moveToNext()) {
                    break;
                }
                int i3 = cursor2.getInt(columnIndexOrThrow);
                String photoPath = cursor2.getString(columnIndexOrThrow2);
                String string = cursor2.getString(columnIndexOrThrow4);
                long j3 = cursor2.getLong(columnIndexOrThrow3);
                int i16 = columnIndexOrThrow;
                if (!TextUtils.isEmpty(photoPath) && !TextUtils.isEmpty(string)) {
                    int i17 = cursor2.getInt(columnIndexOrThrow5);
                    int i18 = cursor2.getInt(columnIndexOrThrow6);
                    if (!rFWMediaScanner.filterPhotoSize(i17, i18)) {
                        RFWMediaInfo rFWMediaInfo = new RFWMediaInfo();
                        rFWMediaInfo.setMAddTime(j3 * 1000);
                        Intrinsics.checkNotNullExpressionValue(photoPath, "photoPath");
                        rFWMediaInfo.setMPath(photoPath);
                        rFWMediaInfo.setMWidth(i17);
                        rFWMediaInfo.setMHeight(i18);
                        rFWMediaInfo.setMScanTime(System.currentTimeMillis());
                        arrayList.add(rFWMediaInfo);
                        rFWMediaScanner.mContext.dev("RFWMediaScanner", "scan photo info:" + photoPath);
                        if (maxPhotoNum != -1 && arrayList.size() >= maxPhotoNum) {
                            rFWMediaScanner.mContext.d("RFWMediaScanner", "[loadPhotoFromCursor] over scan limit " + maxPhotoNum);
                            break;
                        }
                    } else {
                        continue;
                    }
                } else {
                    rFWMediaScanner.mContext.e("RFWMediaScanner", "[loadPhotoFromCursor] data error, photoId=" + i3 + ", photoPath=" + photoPath + ", mimeType=" + string + ", addTime=" + j3);
                    rFWMediaScanner = this;
                    cursor2 = cursor;
                }
                columnIndexOrThrow = i16;
            }
            cursor.close();
            return arrayList;
        }
        return null;
    }

    private final RFWMediaScanResult scanPhoto(long startSecond, long endSecond, int maxPhotoNum) {
        List<RFWMediaInfo> loadPhotoFromCursor;
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            try {
                RFWLocalPhotoMediaUtil rFWLocalPhotoMediaUtil = RFWLocalPhotoMediaUtil.INSTANCE;
                String generateQuerySelection = rFWLocalPhotoMediaUtil.generateQuerySelection(this.mContext, startSecond, endSecond, 200, Integer.MAX_VALUE);
                this.mContext.dev("RFWMediaScanner", "do scan photo : " + generateQuerySelection);
                cursor = rFWLocalPhotoMediaUtil.queryImages(this.mContext, generateQuerySelection, null, maxPhotoNum * 2, 0);
                if (cursor != null && cursor.getCount() > 0 && (loadPhotoFromCursor = loadPhotoFromCursor(cursor, maxPhotoNum)) != null && (!loadPhotoFromCursor.isEmpty())) {
                    arrayList.addAll(loadPhotoFromCursor);
                }
                this.mContext.d("RFWMediaScanner", "scan finish: " + arrayList.size());
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
                return new RFWMediaScanResult(true, arrayList);
            } catch (Exception e16) {
                this.mContext.e("RFWMediaScanner", "scanPhotoAndVideo failed : " + e16);
                RFWMediaScanResult rFWMediaScanResult = new RFWMediaScanResult(false, arrayList);
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
                return rFWMediaScanResult;
            }
        } catch (Throwable th5) {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            throw th5;
        }
    }

    @NotNull
    public final RFWMediaScanResult startScan(long startSecond, long endSecond, int maxPhotoNum) {
        long currentTimeMillis = System.currentTimeMillis();
        RFWMediaScanResult scanPhoto = scanPhoto(startSecond, endSecond, maxPhotoNum);
        long currentTimeMillis2 = System.currentTimeMillis();
        this.mContext.d("RFWMediaScanner", "isSuccess : " + scanPhoto.getIsSuccess() + " mediaInfo size : " + scanPhoto.getMediaList().size() + ",cost:" + (currentTimeMillis2 - currentTimeMillis) + ",startTime:" + startSecond + ",endSecond:" + endSecond);
        return scanPhoto;
    }
}
