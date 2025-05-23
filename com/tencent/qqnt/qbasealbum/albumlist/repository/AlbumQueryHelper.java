package com.tencent.qqnt.qbasealbum.albumlist.repository;

import android.content.Context;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.qqnt.qbasealbum.filter.MediaFilter;
import com.tencent.qqnt.qbasealbum.inject.QAlbumPickerContext;
import com.tencent.weiyun.transmission.db.JobDbManager;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J \u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0002J&\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\f2\b\b\u0002\u0010\u0005\u001a\u00020\u0004J&\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\f2\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/albumlist/repository/AlbumQueryHelper;", "", "Landroid/database/Cursor;", "cursor", "", "isRealAlbumID", "", "Lcom/tencent/qqnt/qbasealbum/model/b;", "a", "b", "", "path", "", "width", "height", "c", "Landroid/content/Context;", "context", "limit", "d", "e", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class AlbumQueryHelper {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final AlbumQueryHelper f360873a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34213);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f360873a = new AlbumQueryHelper();
        }
    }

    AlbumQueryHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final List<com.tencent.qqnt.qbasealbum.model.b> a(Cursor cursor, boolean isRealAlbumID) {
        List<com.tencent.qqnt.qbasealbum.model.b> list;
        int i3;
        int i16;
        int i17;
        boolean z16;
        boolean z17;
        ox3.a.c("QBaseAlbum.AlbumQuery", AlbumQueryHelper$doQueryImageAlbum$1.INSTANCE);
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
            int i26 = columnIndex3;
            if (i18 > 0 && i19 > 0) {
                i16 = columnIndex8;
                i17 = columnIndex9;
            } else {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                int[] iArr = new int[2];
                com.tencent.qqnt.qbasealbum.query.b.f361494a.d(string, options, iArr);
                MediaFilter o16 = QAlbumPickerContext.f361201a.e().o();
                int g16 = o16.g();
                i16 = columnIndex8;
                int c16 = o16.c();
                i17 = columnIndex9;
                int i27 = iArr[0];
                if (g16 <= i27 && i27 <= c16) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    int e16 = o16.e();
                    int a16 = o16.a();
                    int i28 = iArr[1];
                    if (e16 <= i28 && i28 <= a16) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (!z17) {
                    }
                }
                columnIndex3 = i26;
                columnIndex8 = i16;
                columnIndex9 = i17;
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
                if (((com.tencent.qqnt.qbasealbum.model.b) linkedHashMap2.get(bucketId)) == null) {
                    com.tencent.qqnt.qbasealbum.model.b bVar = new com.tencent.qqnt.qbasealbum.model.b(0, null, 0L, null, 0, 0, null, 127, null);
                    bVar.m(string2);
                    bVar.i(bucketId);
                    int i29 = columnIndex;
                    int i36 = columnIndex2;
                    bVar.h(cursor.getLong(columnIndex4));
                    bVar.c().setPath(string);
                    bVar.c().set_id(cursor.getLong(columnIndex5));
                    bVar.c().setModifiedDate(bVar.a());
                    bVar.c().setOrientation(cursor.getInt(columnIndex6));
                    bVar.c().setMMimeType(cursor.getString(columnIndex7));
                    if (Intrinsics.areEqual(bVar.c().getMMimeType(), "*/*")) {
                        bVar.c().setMMimeType("image");
                    }
                    if (isRealAlbumID) {
                        bVar.n(Long.valueOf(Long.parseLong(bucketId)));
                    }
                    linkedHashMap2.put(bucketId, bVar);
                    columnIndex = i29;
                    columnIndex2 = i36;
                }
            }
            columnIndex3 = i26;
            columnIndex8 = i16;
            columnIndex9 = i17;
        }
        ox3.a.c("QBaseAlbum.AlbumQuery", AlbumQueryHelper$doQueryImageAlbum$3.INSTANCE);
        for (Map.Entry entry : linkedHashMap2.entrySet()) {
            com.tencent.qqnt.qbasealbum.model.b bVar2 = (com.tencent.qqnt.qbasealbum.model.b) entry.getValue();
            Integer num = (Integer) linkedHashMap.get(entry.getKey());
            if (num != null) {
                i3 = num.intValue();
            } else {
                i3 = 0;
            }
            bVar2.k(i3);
        }
        list = CollectionsKt___CollectionsKt.toList(linkedHashMap2.values());
        return list;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final List<com.tencent.qqnt.qbasealbum.model.b> b(Cursor cursor, boolean isRealAlbumID) {
        List<com.tencent.qqnt.qbasealbum.model.b> list;
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        boolean z16;
        boolean contains$default;
        ox3.a.c("QBaseAlbum.AlbumQuery", AlbumQueryHelper$doQueryVideoAlbum$1.INSTANCE);
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
            int i26 = cursor.getInt(columnIndex7);
            int i27 = cursor.getInt(columnIndex8);
            String path = cursor.getString(columnIndex4);
            String string = cursor.getString(columnIndex6);
            int i28 = columnIndex4;
            if (i26 > 0 && i27 > 0) {
                i17 = columnIndex6;
                i18 = columnIndex7;
                i19 = columnIndex8;
            } else {
                if (string != null) {
                    i17 = columnIndex6;
                    i18 = columnIndex7;
                    i19 = columnIndex8;
                    contains$default = StringsKt__StringsKt.contains$default((CharSequence) string, (CharSequence) "video/mp4", false, 2, (Object) null);
                    if (contains$default) {
                        z16 = true;
                        if (!z16) {
                            Intrinsics.checkNotNullExpressionValue(path, "path");
                            if (!c(path, i26, i27)) {
                                columnIndex4 = i28;
                                columnIndex6 = i17;
                                columnIndex7 = i18;
                                columnIndex8 = i19;
                            }
                        }
                    }
                } else {
                    i17 = columnIndex6;
                    i18 = columnIndex7;
                    i19 = columnIndex8;
                }
                z16 = false;
                if (!z16) {
                }
            }
            String bucketId = cursor.getString(columnIndex);
            String string2 = cursor.getString(columnIndex3);
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
                if (((com.tencent.qqnt.qbasealbum.model.b) linkedHashMap2.get(bucketId)) == null) {
                    com.tencent.qqnt.qbasealbum.model.b bVar = new com.tencent.qqnt.qbasealbum.model.b(0, null, 0L, null, 0, 0, null, 127, null);
                    linkedHashMap2.put(bucketId, bVar);
                    bVar.m(string2);
                    bVar.i(bucketId);
                    int i29 = columnIndex3;
                    bVar.h(cursor.getLong(columnIndex5));
                    bVar.c().setPath(path);
                    bVar.c().set_id(cursor.getLong(columnIndex2));
                    bVar.c().setModifiedDate(bVar.a());
                    bVar.c().setMMimeType(string);
                    bVar.k(0);
                    if (isRealAlbumID) {
                        bVar.n(Long.valueOf(Long.parseLong(bucketId)));
                    }
                    columnIndex3 = i29;
                }
            }
            columnIndex4 = i28;
            columnIndex6 = i17;
            columnIndex7 = i18;
            columnIndex8 = i19;
        }
        ox3.a.c("QBaseAlbum.AlbumQuery", AlbumQueryHelper$doQueryVideoAlbum$3.INSTANCE);
        for (Map.Entry entry : linkedHashMap2.entrySet()) {
            com.tencent.qqnt.qbasealbum.model.b bVar2 = (com.tencent.qqnt.qbasealbum.model.b) entry.getValue();
            Integer num = (Integer) linkedHashMap.get(entry.getKey());
            if (num != null) {
                i3 = num.intValue();
            } else {
                i3 = 0;
            }
            bVar2.l(i3);
            com.tencent.qqnt.qbasealbum.model.b bVar3 = (com.tencent.qqnt.qbasealbum.model.b) entry.getValue();
            Integer num2 = (Integer) linkedHashMap.get(entry.getKey());
            if (num2 != null) {
                i16 = num2.intValue();
            } else {
                i16 = 0;
            }
            bVar3.k(i16);
        }
        list = CollectionsKt___CollectionsKt.toList(linkedHashMap2.values());
        return list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v2, types: [android.media.MediaMetadataRetriever] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    private final boolean c(final String path, int width, int height) {
        MediaFilter o16;
        MediaMetadataRetriever mediaMetadataRetriever;
        boolean z16;
        boolean z17;
        ox3.a.a("QBaseAlbum.AlbumQuery", AlbumQueryHelper$needCount$1.INSTANCE);
        ?? r26 = 0;
        MediaMetadataRetriever mediaMetadataRetriever2 = null;
        try {
            try {
                o16 = QAlbumPickerContext.f361201a.e().o();
                mediaMetadataRetriever = new MediaMetadataRetriever();
                try {
                    mediaMetadataRetriever.setDataSource(path);
                    String extractMetadata = mediaMetadataRetriever.extractMetadata(18);
                    if (extractMetadata != null) {
                        width = Integer.parseInt(extractMetadata);
                    }
                    int s16 = o16.s();
                    if (width <= o16.o() && s16 <= width) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                } catch (Exception e16) {
                    e = e16;
                    mediaMetadataRetriever2 = mediaMetadataRetriever;
                    ox3.a.a("QBaseAlbum.MediaQuery", new Function0<String>(path, e) { // from class: com.tencent.qqnt.qbasealbum.albumlist.repository.AlbumQueryHelper$needCount$4
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ Exception $e;
                        final /* synthetic */ String $path;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                            this.$path = path;
                            this.$e = e;
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, (Object) this, (Object) path, (Object) e);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function0
                        @NotNull
                        public final String invoke() {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                            }
                            return "get mmr failed:" + this.$path + ", " + this.$e;
                        }
                    });
                    r26 = mediaMetadataRetriever2;
                    if (mediaMetadataRetriever2 != null) {
                        mediaMetadataRetriever2.release();
                        r26 = mediaMetadataRetriever2;
                    }
                    return true;
                } catch (Throwable th5) {
                    th = th5;
                    r26 = mediaMetadataRetriever;
                    if (r26 != 0) {
                        r26.release();
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
            ox3.a.a("QBaseAlbum.AlbumQuery", AlbumQueryHelper$needCount$2.INSTANCE);
            String extractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
            if (extractMetadata2 != null) {
                height = Integer.parseInt(extractMetadata2);
            }
            int q16 = o16.q();
            int m3 = o16.m();
            if (height <= m3 && q16 <= height) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17) {
                mediaMetadataRetriever.release();
                return false;
            }
            ox3.a.a("QBaseAlbum.AlbumQuery", AlbumQueryHelper$needCount$3.INSTANCE);
            mediaMetadataRetriever.release();
            r26 = m3;
            return true;
        } catch (Throwable th6) {
            th = th6;
        }
    }

    @NotNull
    public final List<com.tencent.qqnt.qbasealbum.model.b> d(@NotNull Context context, int limit, boolean isRealAlbumID) {
        List<com.tencent.qqnt.qbasealbum.model.b> emptyList;
        Uri build;
        List<com.tencent.qqnt.qbasealbum.model.b> emptyList2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, this, context, Integer.valueOf(limit), Boolean.valueOf(isRealAlbumID));
        }
        Intrinsics.checkNotNullParameter(context, "context");
        ox3.a.c("QBaseAlbum.AlbumQuery", AlbumQueryHelper$queryImageBuckets$1.INSTANCE);
        Cursor cursor = null;
        try {
            try {
                if (limit == -1) {
                    build = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                } else {
                    build = MediaStore.Images.Media.EXTERNAL_CONTENT_URI.buildUpon().appendQueryParameter("limit", String.valueOf(limit)).build();
                }
                Cursor query = ContactsMonitor.query(context.getContentResolver(), build, b.f360875a.a(), a.f360874a.a(QAlbumPickerContext.f361201a.e().o()), null, "date_modified DESC");
                if (query == null) {
                    ox3.a.c("QBaseAlbum.AlbumQuery", AlbumQueryHelper$queryImageBuckets$2.INSTANCE);
                    emptyList2 = CollectionsKt__CollectionsKt.emptyList();
                    return emptyList2;
                }
                ox3.a.c("QBaseAlbum.AlbumQuery", AlbumQueryHelper$queryImageBuckets$3.INSTANCE);
                List<com.tencent.qqnt.qbasealbum.model.b> a16 = a(query, isRealAlbumID);
                query.close();
                return a16;
            } catch (Exception unused) {
                ox3.a.c("QBaseAlbum.AlbumQuery", AlbumQueryHelper$queryImageBuckets$4.INSTANCE);
                if (0 != 0) {
                    cursor.close();
                }
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                return emptyList;
            }
        } catch (Throwable th5) {
            if (0 != 0) {
                cursor.close();
            }
            throw th5;
        }
    }

    @NotNull
    public final List<com.tencent.qqnt.qbasealbum.model.b> e(@NotNull Context context, int limit, boolean isRealAlbumID) {
        List<com.tencent.qqnt.qbasealbum.model.b> emptyList;
        Uri build;
        List<com.tencent.qqnt.qbasealbum.model.b> emptyList2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, this, context, Integer.valueOf(limit), Boolean.valueOf(isRealAlbumID));
        }
        Intrinsics.checkNotNullParameter(context, "context");
        ox3.a.c("QBaseAlbum.AlbumQuery", AlbumQueryHelper$queryVideoBuckets$1.INSTANCE);
        Cursor cursor = null;
        try {
            try {
                if (limit == -1) {
                    build = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                } else {
                    build = MediaStore.Video.Media.EXTERNAL_CONTENT_URI.buildUpon().appendQueryParameter("limit", String.valueOf(limit)).build();
                }
                Cursor query = ContactsMonitor.query(context.getContentResolver(), build, b.f360875a.b(), a.f360874a.b(QAlbumPickerContext.f361201a.e().o()), null, "date_modified DESC");
                if (query == null) {
                    ox3.a.c("QBaseAlbum.AlbumQuery", AlbumQueryHelper$queryVideoBuckets$2.INSTANCE);
                    emptyList2 = CollectionsKt__CollectionsKt.emptyList();
                    return emptyList2;
                }
                ox3.a.c("QBaseAlbum.AlbumQuery", AlbumQueryHelper$queryVideoBuckets$3.INSTANCE);
                List<com.tencent.qqnt.qbasealbum.model.b> b16 = b(query, isRealAlbumID);
                query.close();
                return b16;
            } catch (Exception e16) {
                ox3.a.c("QBaseAlbum.AlbumQuery", new Function0<String>(e16) { // from class: com.tencent.qqnt.qbasealbum.albumlist.repository.AlbumQueryHelper$queryVideoBuckets$4
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ Exception $e;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        this.$e = e16;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) e16);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final String invoke() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                        }
                        return "queryVideoBuckets(), query failed: " + this.$e;
                    }
                });
                if (0 != 0) {
                    cursor.close();
                }
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                return emptyList;
            }
        } catch (Throwable th5) {
            if (0 != 0) {
                cursor.close();
            }
            throw th5;
        }
    }
}
