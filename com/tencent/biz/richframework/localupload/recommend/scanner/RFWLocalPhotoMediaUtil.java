package com.tencent.biz.richframework.localupload.recommend.scanner;

import android.app.Application;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import com.tencent.biz.richframework.localupload.recommend.RecommendContext;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.weiyun.transmission.db.JobDbManager;
import common.config.service.QzoneConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J.\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bJA\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u000f\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00112\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/biz/richframework/localupload/recommend/scanner/RFWLocalPhotoMediaUtil;", "", "", "getMediaBucketNameConfig", "getMediaDataConfig", "getMediaTypeConfig", "Lcom/tencent/biz/richframework/localupload/recommend/RecommendContext;", "context", "", "startSecond", "endSecond", "", NodeProps.MIN_WIDTH, NodeProps.MAX_WIDTH, "generateQuerySelection", "recommendContext", "selection", "", "selectionArgs", "fetchNum", "offsetNum", "Landroid/database/Cursor;", "queryImages", "(Lcom/tencent/biz/richframework/localupload/recommend/RecommendContext;Ljava/lang/String;[Ljava/lang/String;II)Landroid/database/Cursor;", "NEED_FILTER_MEDIA_BUCKET", "[Ljava/lang/String;", "NEED_FILTER_MEDIA_DATA", "<init>", "()V", "local-upload-recommend-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class RFWLocalPhotoMediaUtil {

    @NotNull
    public static final RFWLocalPhotoMediaUtil INSTANCE = new RFWLocalPhotoMediaUtil();

    @NotNull
    private static final String[] NEED_FILTER_MEDIA_BUCKET = {"Screenshots", QzoneConfig.RECENT_PHOTO_BLOCK_PATHS_DEFAULT, "weibo", "weibovideo", "douyin", "baidu", "QQBrowser", "BaiduNetdisk"};

    @NotNull
    private static final String[] NEED_FILTER_MEDIA_DATA = {"%/Screenshots/%", "%/Camera_XHS%", "%/Camera_xhs%.mp4", "%/Camera/share_%.mp4"};

    RFWLocalPhotoMediaUtil() {
    }

    private final String getMediaBucketNameConfig() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("(");
        String[] strArr = NEED_FILTER_MEDIA_BUCKET;
        int length = strArr.length;
        int i3 = 0;
        int i16 = 0;
        while (i3 < length) {
            int i17 = i16 + 1;
            sb5.append("bucket_display_name != '" + strArr[i3] + "'");
            if (i16 < NEED_FILTER_MEDIA_BUCKET.length - 1) {
                sb5.append(" and ");
            }
            i3++;
            i16 = i17;
        }
        sb5.append(")");
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "configBuilder.toString()");
        return sb6;
    }

    private final String getMediaDataConfig() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("(");
        String[] strArr = NEED_FILTER_MEDIA_DATA;
        int length = strArr.length;
        int i3 = 0;
        int i16 = 0;
        while (i3 < length) {
            int i17 = i16 + 1;
            sb5.append("_data not like '" + strArr[i3] + "'");
            if (i16 < NEED_FILTER_MEDIA_DATA.length - 1) {
                sb5.append(" and ");
            }
            i3++;
            i16 = i17;
        }
        sb5.append(")");
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "configBuilder.toString()");
        return sb6;
    }

    private final String getMediaTypeConfig() {
        return " (mime_type='image/jpeg' or (mime_type='*/*' and _display_name LIKE'%.jpeg%' )  or (mime_type='*/*' and _display_name LIKE'%.jpg%' )  or mime_type='image/heif' or mime_type='image/heic')";
    }

    @NotNull
    public final String generateQuerySelection(@NotNull RecommendContext context, long startSecond, long endSecond, int minWidth, int maxWidth) {
        Intrinsics.checkNotNullParameter(context, "context");
        context.d("LocalPhotoMediaUtil", "generateQuerySelection | startSecond : " + startSecond + "; endSecond : " + endSecond);
        return "width> " + minWidth + " and width< " + maxWidth + " and " + getMediaBucketNameConfig() + " and " + getMediaDataConfig() + " and " + getMediaTypeConfig() + " and date_added >=" + startSecond + " and date_added<=" + endSecond;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v4, types: [android.database.Cursor] */
    @Nullable
    public final Cursor queryImages(@NotNull RecommendContext recommendContext, @Nullable String selection, @Nullable String[] selectionArgs, int fetchNum, int offsetNum) {
        Cursor query;
        Intrinsics.checkNotNullParameter(recommendContext, "recommendContext");
        String[] strArr = {"_id", "_data", "date_added", "date_modified", "width", "height", JobDbManager.COL_UP_MIME_TYPE};
        recommendContext.d("LocalPhotoMediaUtil", "[queryImages]");
        Integer num = null;
        try {
            Application androidContext = recommendContext.getAndroidContext();
            if (Build.VERSION.SDK_INT >= 30) {
                ContentResolver contentResolver = androidContext.getContentResolver();
                Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                Bundle bundle = new Bundle();
                bundle.putString("android:query-arg-sql-selection", selection);
                bundle.putStringArray("android:query-arg-sql-selection-args", selectionArgs);
                bundle.putStringArray("android:query-arg-sort-columns", new String[]{"date_added"});
                bundle.putInt("android:query-arg-sort-direction", 1);
                if (fetchNum > 0) {
                    bundle.putInt("android:query-arg-limit", fetchNum);
                }
                bundle.putInt("android:query-arg-offset", offsetNum);
                Unit unit = Unit.INSTANCE;
                query = ContactsMonitor.query(contentResolver, uri, strArr, bundle, null);
            } else {
                String str = " desc";
                if (fetchNum > 0) {
                    str = " desc limit " + fetchNum + " OFFSET " + offsetNum;
                }
                query = ContactsMonitor.query(androidContext.getContentResolver(), MediaStore.Images.Media.EXTERNAL_CONTENT_URI, strArr, selection, selectionArgs, "date_added" + str);
            }
            ?? r26 = query;
            if (r26 != 0) {
                try {
                    num = Integer.valueOf(r26.getCount());
                } catch (Exception e16) {
                    e = e16;
                    num = r26;
                    recommendContext.e("LocalPhotoMediaUtil", "query error, selection: " + selection + ", exception: " + e);
                    return num;
                }
            }
            recommendContext.d("LocalPhotoMediaUtil", "[queryImages] finish: " + num);
            return r26;
        } catch (Exception e17) {
            e = e17;
        }
    }
}
