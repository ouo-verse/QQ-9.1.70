package com.tencent.mobileqq.wink.picker.core.repository;

import android.content.Context;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumBaseUtil;
import com.tencent.mobileqq.activity.photo.album.QAlbumCustomAlbumConstants;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.mobileqq.wink.picker.MediaFilter;
import com.tencent.mobileqq.wink.picker.TabType;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.weiyun.transmission.db.JobDbManager;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00132\u00020\u0001:\u0002\u001b\u0013B\u0007\u00a2\u0006\u0004\b+\u0010,J&\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J*\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J*\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J*\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\u00162\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\u0016\u0010\u001a\u001a\u00020\u00192\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\u0016H\u0002J\u0016\u0010\u001b\u001a\u00020\t2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\u0016\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u001c\u001a\u00020\u000fH\u0002J\u0016\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u001c\u001a\u00020\u000fH\u0002J\u0012\u0010 \u001a\u00020\u00022\b\u0010\u001f\u001a\u0004\u0018\u00010\rH\u0002J \u0010$\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u0006H\u0002J\u0016\u0010'\u001a\u00020\u00192\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010&\u001a\u00020%R\u0014\u0010*\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010)\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/core/repository/e;", "", "", "queryImage", "Landroid/content/Context;", "context", "", "limit", "", "Lcom/tencent/mobileqq/data/QQAlbumInfo;", "j", "Landroid/net/Uri;", LayoutAttrDefine.CLICK_URI, "", "selection", "Landroid/database/Cursor;", "e", "images", "videos", "b", "imageAlbums", "videoAlbums", "", "g", "albums", "", "k", "a", "cursor", "c", "d", "name", "f", "path", "width", "height", tl.h.F, "Lcom/tencent/mobileqq/wink/picker/core/repository/e$a;", "listener", "i", "Lcom/tencent/mobileqq/wink/picker/TabType;", "Lcom/tencent/mobileqq/wink/picker/TabType;", "tabType", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class e {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final String[] f324650c = {"bucket_id", "bucket_display_name", "_id", "date_modified", "_data", "orientation", JobDbManager.COL_UP_MIME_TYPE, "width", "height"};

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TabType tabType = com.tencent.mobileqq.wink.picker.core.c.f324480a.b().getLocalMediaTabType();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/core/repository/e$a;", "", "", "Lcom/tencent/mobileqq/data/QQAlbumInfo;", "albums", "", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public interface a {
        void a(@NotNull List<? extends QQAlbumInfo> albums);
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f324652a;

        static {
            int[] iArr = new int[TabType.values().length];
            try {
                iArr[TabType.ONLY_IMAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TabType.ALL_MEDIA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TabType.ONLY_VIDEO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f324652a = iArr;
        }
    }

    private final QQAlbumInfo a(List<? extends QQAlbumInfo> albums) {
        Object orNull;
        LocalMediaInfo localMediaInfo;
        QQAlbumInfo qQAlbumInfo = new QQAlbumInfo();
        qQAlbumInfo.f203112id = QAlbumCustomAlbumConstants.RECENT_ALBUM_ID;
        qQAlbumInfo.name = MobileQQ.sMobileQQ.getApplicationContext().getResources().getString(R.string.f240907qf);
        int i3 = 0;
        orNull = CollectionsKt___CollectionsKt.getOrNull(albums, 0);
        QQAlbumInfo qQAlbumInfo2 = (QQAlbumInfo) orNull;
        if (qQAlbumInfo2 == null || (localMediaInfo = qQAlbumInfo2.mCoverInfo) == null) {
            localMediaInfo = new LocalMediaInfo();
        }
        qQAlbumInfo.mCoverInfo = localMediaInfo;
        qQAlbumInfo.coverDate = localMediaInfo.modifiedDate;
        Iterator<T> it = albums.iterator();
        while (it.hasNext()) {
            i3 += ((QQAlbumInfo) it.next()).mMediaFileCount;
        }
        qQAlbumInfo.mMediaFileCount = i3;
        return qQAlbumInfo;
    }

    private final List<QQAlbumInfo> b(List<? extends QQAlbumInfo> images, List<? extends QQAlbumInfo> videos) {
        List<QQAlbumInfo> g16 = g(images, videos);
        if (g16.isEmpty()) {
            return g16;
        }
        k(g16);
        g16.add(0, a(g16));
        return g16;
    }

    private final List<QQAlbumInfo> c(Cursor cursor) {
        List<QQAlbumInfo> list;
        int i3;
        int i16;
        int i17;
        boolean z16;
        boolean z17;
        w53.b.f("WinkLocalAlbumRepo", "[doQueryImageAlbum] count=" + cursor.getCount() + ", columnCount=" + cursor.getColumnCount());
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        int columnIndex = cursor.getColumnIndex("bucket_id");
        int columnIndex2 = cursor.getColumnIndex("bucket_display_name");
        int columnIndex3 = cursor.getColumnIndex("_data");
        int columnIndex4 = cursor.getColumnIndex("date_modified");
        int columnIndex5 = cursor.getColumnIndex("_id");
        int columnIndex6 = cursor.getColumnIndex("orientation");
        int columnIndex7 = cursor.getColumnIndex(JobDbManager.COL_UP_MIME_TYPE);
        int columnIndex8 = cursor.getColumnIndex("width");
        int columnIndex9 = cursor.getColumnIndex("height");
        while (cursor.moveToNext()) {
            int i18 = cursor.getInt(columnIndex8);
            int i19 = cursor.getInt(columnIndex9);
            String string = cursor.getString(columnIndex3);
            if (i18 > 0 && i19 > 0) {
                i16 = columnIndex3;
                i17 = columnIndex8;
            } else {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                int[] iArr = new int[2];
                QAlbumBaseUtil.getWHByPath(string, options, iArr);
                MediaFilter queryMediaFilter = com.tencent.mobileqq.wink.picker.core.c.f324480a.b().getQueryMediaFilter();
                int imageMinWidth = queryMediaFilter.getImageMinWidth();
                i16 = columnIndex3;
                int imageMaxWidth = queryMediaFilter.getImageMaxWidth();
                i17 = columnIndex8;
                int i26 = iArr[0];
                if (imageMinWidth <= i26 && i26 <= imageMaxWidth) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    int imageMinHeight = queryMediaFilter.getImageMinHeight();
                    int imageMaxHeight = queryMediaFilter.getImageMaxHeight();
                    int i27 = iArr[1];
                    if (imageMinHeight <= i27 && i27 <= imageMaxHeight) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (!z17) {
                    }
                }
                columnIndex3 = i16;
                columnIndex8 = i17;
            }
            String bucketId = cursor.getString(columnIndex);
            String string2 = cursor.getString(columnIndex2);
            if (string2 == null) {
                string2 = "IN2010";
            }
            if (!TextUtils.isEmpty(bucketId) && !TextUtils.isEmpty(string2)) {
                Intrinsics.checkNotNullExpressionValue(bucketId, "bucketId");
                Object obj = linkedHashMap.get(bucketId);
                if (obj == null) {
                    obj = 0;
                }
                linkedHashMap.put(bucketId, Integer.valueOf(((Number) obj).intValue() + 1));
                if (((QQAlbumInfo) linkedHashMap2.get(bucketId)) == null) {
                    QQAlbumInfo qQAlbumInfo = new QQAlbumInfo();
                    qQAlbumInfo.name = string2;
                    qQAlbumInfo.f203112id = bucketId;
                    qQAlbumInfo.coverDate = cursor.getLong(columnIndex4);
                    LocalMediaInfo localMediaInfo = qQAlbumInfo.mCoverInfo;
                    localMediaInfo.path = string;
                    localMediaInfo._id = cursor.getLong(columnIndex5);
                    LocalMediaInfo localMediaInfo2 = qQAlbumInfo.mCoverInfo;
                    localMediaInfo2.modifiedDate = qQAlbumInfo.coverDate;
                    localMediaInfo2.orientation = cursor.getInt(columnIndex6);
                    qQAlbumInfo.mCoverInfo.mMimeType = cursor.getString(columnIndex7);
                    if (Intrinsics.areEqual(qQAlbumInfo.mCoverInfo.mMimeType, "*/*")) {
                        qQAlbumInfo.mCoverInfo.mMimeType = "image";
                    }
                    linkedHashMap2.put(bucketId, qQAlbumInfo);
                }
            }
            columnIndex3 = i16;
            columnIndex8 = i17;
        }
        for (Map.Entry entry : linkedHashMap2.entrySet()) {
            QQAlbumInfo qQAlbumInfo2 = (QQAlbumInfo) entry.getValue();
            Integer num = (Integer) linkedHashMap.get(entry.getKey());
            if (num != null) {
                i3 = num.intValue();
            } else {
                i3 = 0;
            }
            qQAlbumInfo2.mMediaFileCount = i3;
        }
        list = CollectionsKt___CollectionsKt.toList(linkedHashMap2.values());
        return list;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0129 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final List<QQAlbumInfo> d(Cursor cursor) {
        List<QQAlbumInfo> list;
        int i3;
        int i16;
        int i17;
        int i18;
        boolean z16;
        boolean contains$default;
        String bucketId;
        String string;
        Object obj;
        w53.b.f("WinkLocalAlbumRepo", "[doQueryVideoAlbum] count=" + cursor.getCount() + ", columnCount=" + cursor.getColumnCount());
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        int columnIndex = cursor.getColumnIndex("bucket_id");
        int columnIndex2 = cursor.getColumnIndex("_id");
        int columnIndex3 = cursor.getColumnIndex("bucket_display_name");
        int columnIndex4 = cursor.getColumnIndex("_data");
        int columnIndex5 = cursor.getColumnIndex("date_modified");
        int columnIndex6 = cursor.getColumnIndex(JobDbManager.COL_UP_MIME_TYPE);
        int columnIndex7 = cursor.getColumnIndex("width");
        int columnIndex8 = cursor.getColumnIndex("height");
        while (cursor.moveToNext()) {
            int i19 = cursor.getInt(columnIndex7);
            int i26 = cursor.getInt(columnIndex8);
            String path = cursor.getString(columnIndex4);
            String string2 = cursor.getString(columnIndex6);
            if (i19 > 0 && i26 > 0) {
                i16 = columnIndex4;
                i17 = columnIndex6;
                i18 = columnIndex7;
            } else {
                if (string2 != null) {
                    i16 = columnIndex4;
                    i17 = columnIndex6;
                    i18 = columnIndex7;
                    contains$default = StringsKt__StringsKt.contains$default((CharSequence) string2, (CharSequence) "video/mp4", false, 2, (Object) null);
                    if (contains$default) {
                        z16 = true;
                        if (z16) {
                            Intrinsics.checkNotNullExpressionValue(path, "path");
                            if (!h(path, i19, i26)) {
                                columnIndex4 = i16;
                                columnIndex6 = i17;
                                columnIndex7 = i18;
                            }
                            bucketId = cursor.getString(columnIndex);
                            string = cursor.getString(columnIndex3);
                            if (string == null) {
                                string = "IN2010";
                            }
                            if (!TextUtils.isEmpty(bucketId) && !TextUtils.isEmpty(string)) {
                                Intrinsics.checkNotNullExpressionValue(bucketId, "bucketId");
                                obj = linkedHashMap.get(bucketId);
                                if (obj == null) {
                                    obj = 0;
                                }
                                linkedHashMap.put(bucketId, Integer.valueOf(((Number) obj).intValue() + 1));
                                if (((QQAlbumInfo) linkedHashMap2.get(bucketId)) != null) {
                                    QQAlbumInfo qQAlbumInfo = new QQAlbumInfo();
                                    linkedHashMap2.put(bucketId, qQAlbumInfo);
                                    qQAlbumInfo.name = string;
                                    qQAlbumInfo.f203112id = bucketId;
                                    qQAlbumInfo.coverDate = cursor.getLong(columnIndex5);
                                    LocalMediaInfo localMediaInfo = qQAlbumInfo.mCoverInfo;
                                    localMediaInfo.path = path;
                                    localMediaInfo._id = cursor.getLong(columnIndex2);
                                    LocalMediaInfo localMediaInfo2 = qQAlbumInfo.mCoverInfo;
                                    localMediaInfo2.modifiedDate = qQAlbumInfo.coverDate;
                                    localMediaInfo2.mMimeType = string2;
                                    qQAlbumInfo.mMediaFileCount = 0;
                                }
                            }
                            columnIndex4 = i16;
                            columnIndex6 = i17;
                            columnIndex7 = i18;
                        }
                    }
                } else {
                    i16 = columnIndex4;
                    i17 = columnIndex6;
                    i18 = columnIndex7;
                }
                z16 = false;
                if (z16) {
                }
            }
            bucketId = cursor.getString(columnIndex);
            string = cursor.getString(columnIndex3);
            if (string == null) {
            }
            if (!TextUtils.isEmpty(bucketId)) {
                Intrinsics.checkNotNullExpressionValue(bucketId, "bucketId");
                obj = linkedHashMap.get(bucketId);
                if (obj == null) {
                }
                linkedHashMap.put(bucketId, Integer.valueOf(((Number) obj).intValue() + 1));
                if (((QQAlbumInfo) linkedHashMap2.get(bucketId)) != null) {
                }
            }
            columnIndex4 = i16;
            columnIndex6 = i17;
            columnIndex7 = i18;
        }
        for (Map.Entry entry : linkedHashMap2.entrySet()) {
            QQAlbumInfo qQAlbumInfo2 = (QQAlbumInfo) entry.getValue();
            Integer num = (Integer) linkedHashMap.get(entry.getKey());
            if (num != null) {
                i3 = num.intValue();
            } else {
                i3 = 0;
            }
            qQAlbumInfo2.mMediaFileCount = i3;
        }
        list = CollectionsKt___CollectionsKt.toList(linkedHashMap2.values());
        return list;
    }

    private final Cursor e(Context context, Uri uri, String selection, int limit) {
        w53.b.f("WinkLocalAlbumRepo", "[getBucketsCursor] selection=" + selection + ", limit=" + limit);
        if (Build.VERSION.SDK_INT >= 30) {
            Bundle bundle = new Bundle();
            bundle.putString("android:query-arg-sql-selection", selection);
            bundle.putString("android:query-arg-sql-sort-order", "date_modified DESC");
            bundle.putString("android:query-arg-sql-limit", String.valueOf(limit));
            return ContactsMonitor.query(context.getContentResolver(), uri, f324650c, bundle, null);
        }
        if (limit != -1) {
            uri = uri.buildUpon().appendQueryParameter("limit", String.valueOf(limit)).build();
        }
        return ContactsMonitor.query(context.getContentResolver(), uri, f324650c, selection, null, "date_modified DESC");
    }

    private final boolean f(String name) {
        boolean equals;
        boolean equals2;
        if (name == null) {
            return false;
        }
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        String lowerCase = name.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        equals = StringsKt__StringsJVMKt.equals(lowerCase, "camera", true);
        if (!equals) {
            equals2 = StringsKt__StringsJVMKt.equals(lowerCase, "100media", true);
            return equals2;
        }
        return true;
    }

    private final List<QQAlbumInfo> g(List<? extends QQAlbumInfo> imageAlbums, List<? extends QQAlbumInfo> videoAlbums) {
        List<QQAlbumInfo> mutableList;
        HashMap hashMap = new HashMap();
        for (QQAlbumInfo qQAlbumInfo : videoAlbums) {
            String str = qQAlbumInfo.f203112id;
            Intrinsics.checkNotNull(str);
            hashMap.put(str, qQAlbumInfo);
        }
        for (QQAlbumInfo qQAlbumInfo2 : imageAlbums) {
            if (hashMap.containsKey(qQAlbumInfo2.f203112id)) {
                QQAlbumInfo qQAlbumInfo3 = (QQAlbumInfo) hashMap.get(qQAlbumInfo2.f203112id);
                if (qQAlbumInfo3 != null) {
                    Intrinsics.checkNotNullExpressionValue(qQAlbumInfo3, "result[it.id] ?: return@forEach");
                    qQAlbumInfo3.mMediaFileCount += qQAlbumInfo2.mMediaFileCount;
                }
            } else {
                String str2 = qQAlbumInfo2.f203112id;
                Intrinsics.checkNotNull(str2);
                hashMap.put(str2, qQAlbumInfo2);
            }
        }
        Collection values = hashMap.values();
        Intrinsics.checkNotNullExpressionValue(values, "result.values");
        mutableList = CollectionsKt___CollectionsKt.toMutableList(values);
        return mutableList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v2, types: [android.media.MediaMetadataRetriever] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    private final boolean h(String path, int width, int height) {
        MediaFilter queryMediaFilter;
        MediaMetadataRetriever mediaMetadataRetriever;
        int videoMinWidth;
        boolean z16;
        boolean z17;
        ?? r16 = 0;
        MediaMetadataRetriever mediaMetadataRetriever2 = null;
        try {
            try {
                queryMediaFilter = com.tencent.mobileqq.wink.picker.core.c.f324480a.b().getQueryMediaFilter();
                mediaMetadataRetriever = new MediaMetadataRetriever();
                try {
                    mediaMetadataRetriever.setDataSource(path);
                    String extractMetadata = mediaMetadataRetriever.extractMetadata(18);
                    if (extractMetadata != null) {
                        width = Integer.parseInt(extractMetadata);
                    }
                    videoMinWidth = queryMediaFilter.getVideoMinWidth();
                    if (width <= queryMediaFilter.getVideoMaxWidth() && videoMinWidth <= width) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                } catch (Exception e16) {
                    e = e16;
                    mediaMetadataRetriever2 = mediaMetadataRetriever;
                    w53.b.d("WinkLocalAlbumRepo", "get mmr failed:" + path, e);
                    r16 = mediaMetadataRetriever2;
                    if (mediaMetadataRetriever2 != null) {
                        mediaMetadataRetriever2.release();
                        r16 = mediaMetadataRetriever2;
                    }
                    return true;
                } catch (Throwable th5) {
                    th = th5;
                    r16 = mediaMetadataRetriever;
                    if (r16 != 0) {
                        r16.release();
                    }
                    throw th;
                }
            } catch (Exception e17) {
                e = e17;
            }
            if (!z16) {
                mediaMetadataRetriever.release();
                return false;
            }
            String extractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
            if (extractMetadata2 != null) {
                height = Integer.parseInt(extractMetadata2);
            }
            int videoMinHeight = queryMediaFilter.getVideoMinHeight();
            if (height <= queryMediaFilter.getVideoMaxHeight() && videoMinHeight <= height) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17) {
                mediaMetadataRetriever.release();
                return false;
            }
            mediaMetadataRetriever.release();
            r16 = videoMinWidth;
            return true;
        } catch (Throwable th6) {
            th = th6;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x006f, code lost:
    
        if (0 == 0) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final List<QQAlbumInfo> j(boolean queryImage, Context context, int limit) {
        List<QQAlbumInfo> emptyList;
        Cursor e16;
        List<QQAlbumInfo> d16;
        List<QQAlbumInfo> emptyList2;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        Cursor cursor = null;
        try {
            try {
                if (queryImage) {
                    Uri EXTERNAL_CONTENT_URI = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                    Intrinsics.checkNotNullExpressionValue(EXTERNAL_CONTENT_URI, "EXTERNAL_CONTENT_URI");
                    String a16 = d93.a.a(com.tencent.mobileqq.wink.picker.core.c.f324480a.b().getQueryMediaFilter());
                    Intrinsics.checkNotNullExpressionValue(a16, "getImageCursorBucketSele\u2026(config.queryMediaFilter)");
                    e16 = e(context, EXTERNAL_CONTENT_URI, a16, limit);
                } else {
                    Uri EXTERNAL_CONTENT_URI2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                    Intrinsics.checkNotNullExpressionValue(EXTERNAL_CONTENT_URI2, "EXTERNAL_CONTENT_URI");
                    String b16 = d93.a.b(com.tencent.mobileqq.wink.picker.core.c.f324480a.b().getQueryMediaFilter());
                    Intrinsics.checkNotNullExpressionValue(b16, "getVideoCursorBucketSele\u2026(config.queryMediaFilter)");
                    e16 = e(context, EXTERNAL_CONTENT_URI2, b16, limit);
                }
                cursor = e16;
            } catch (Exception e17) {
                w53.b.d("WinkLocalAlbumRepo", "queryBuckets(), query failed", e17);
            }
            if (cursor == null) {
                w53.b.f("WinkLocalAlbumRepo", "cursor create failed");
                emptyList2 = CollectionsKt__CollectionsKt.emptyList();
                return emptyList2;
            }
            if (queryImage) {
                d16 = c(cursor);
            } else {
                d16 = d(cursor);
            }
            emptyList = d16;
            cursor.close();
            return emptyList;
        } catch (Throwable th5) {
            if (0 != 0) {
                cursor.close();
            }
            throw th5;
        }
    }

    private final void k(List<QQAlbumInfo> albums) {
        int size = albums.size();
        for (int i3 = 1; i3 < size; i3++) {
            QQAlbumInfo qQAlbumInfo = albums.get(i3);
            if (f(qQAlbumInfo.name)) {
                albums.remove(qQAlbumInfo);
                albums.add(0, qQAlbumInfo);
            }
        }
    }

    public final void i(int limit, @NotNull a listener) {
        List<QQAlbumInfo> j3;
        List<QQAlbumInfo> j16;
        Intrinsics.checkNotNullParameter(listener, "listener");
        Context context = MobileQQ.sMobileQQ.getApplicationContext();
        TabType tabType = this.tabType;
        int[] iArr = c.f324652a;
        int i3 = iArr[tabType.ordinal()];
        if (i3 != 1 && i3 != 2) {
            j3 = CollectionsKt__CollectionsKt.emptyList();
        } else {
            Intrinsics.checkNotNullExpressionValue(context, "context");
            j3 = j(true, context, limit);
        }
        int i16 = iArr[this.tabType.ordinal()];
        if (i16 != 2 && i16 != 3) {
            j16 = CollectionsKt__CollectionsKt.emptyList();
        } else {
            Intrinsics.checkNotNullExpressionValue(context, "context");
            j16 = j(false, context, limit);
        }
        listener.a(b(j3, j16));
        if (limit != -1) {
            if (j3.size() == limit || j16.size() == limit) {
                i(-1, listener);
            }
        }
    }
}
