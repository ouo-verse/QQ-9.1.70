package com.tencent.mobileqq.wifiphoto.data;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.PhotoDetailInfo;
import com.tencent.qqnt.kernel.nativeinterface.PhotoSimpleInfo;
import com.tencent.qqnt.kernel.nativeinterface.WiFiPhotoFileType;
import com.tencent.qqnt.qbasealbum.inject.QAlbumPickerContext;
import com.tencent.util.InputMethodUtil;
import com.tencent.weiyun.transmission.db.JobDbManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ(\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J(\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J(\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bH\u0002J@\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2.\u0010\r\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00100\u0006j\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010`\bH\u0002J.\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0011J\u001a\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00102\u0006\u0010\u0016\u001a\u00020\u0011J\"\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00120\u00062\u0006\u0010\u0014\u001a\u00020\u00112\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00110\u0006R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00110\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/wifiphoto/data/WifiPhotoQueryHelper;", "", "Landroid/content/Context;", "context", "", "limit", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/PhotoSimpleInfo;", "Lkotlin/collections/ArrayList;", "d", "g", "Landroid/database/Cursor;", "cursor", "mediaList", "", "b", "Lkotlin/Pair;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/PhotoDetailInfo;", "a", "albumId", "c", "id", "e", "photoBatch", "f", "", "[Ljava/lang/String;", "detailProjection", "<init>", "()V", "wifiphoto_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class WifiPhotoQueryHelper {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final WifiPhotoQueryHelper f317583a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String[] detailProjection;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static final class a<T> implements Comparator {
        static IPatchRedirector $redirector_;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                compareValues = ComparisonsKt__ComparisonsKt.compareValues(Long.valueOf(((PhotoSimpleInfo) t17).creationTime), Long.valueOf(((PhotoSimpleInfo) t16).creationTime));
                return compareValues;
            }
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) t16, (Object) t17)).intValue();
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static final class b<T> implements Comparator {
        static IPatchRedirector $redirector_;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                compareValues = ComparisonsKt__ComparisonsKt.compareValues(Long.valueOf(((PhotoSimpleInfo) t17).creationTime), Long.valueOf(((PhotoSimpleInfo) t16).creationTime));
                return compareValues;
            }
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) t16, (Object) t17)).intValue();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25073);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f317583a = new WifiPhotoQueryHelper();
            detailProjection = new String[]{"_id", "bucket_id", "date_modified", InputMethodUtil.SOUGOU_URI_DISPLAYNAME, "_size", "_data", JobDbManager.COL_UP_MIME_TYPE};
        }
    }

    WifiPhotoQueryHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void a(Cursor cursor, ArrayList<Pair<String, PhotoDetailInfo>> mediaList) {
        boolean startsWith$default;
        boolean startsWith$default2;
        WiFiPhotoFileType wiFiPhotoFileType;
        int columnIndexOrThrow = cursor.getColumnIndexOrThrow("_id");
        int columnIndexOrThrow2 = cursor.getColumnIndexOrThrow("date_modified");
        int columnIndexOrThrow3 = cursor.getColumnIndexOrThrow(InputMethodUtil.SOUGOU_URI_DISPLAYNAME);
        int columnIndexOrThrow4 = cursor.getColumnIndexOrThrow("_size");
        int columnIndexOrThrow5 = cursor.getColumnIndexOrThrow(JobDbManager.COL_UP_MIME_TYPE);
        int columnIndexOrThrow6 = cursor.getColumnIndexOrThrow("_data");
        while (cursor.moveToNext()) {
            String string = cursor.getString(columnIndexOrThrow);
            String string2 = cursor.getString(columnIndexOrThrow3);
            long j3 = cursor.getLong(columnIndexOrThrow2);
            long j16 = cursor.getLong(columnIndexOrThrow4);
            String type = cursor.getString(columnIndexOrThrow5);
            String string3 = cursor.getString(columnIndexOrThrow6);
            PhotoDetailInfo photoDetailInfo = new PhotoDetailInfo();
            photoDetailInfo.photoId = string;
            photoDetailInfo.fileName = string2;
            photoDetailInfo.totalBytes = j16;
            photoDetailInfo.creationTime = j3;
            Intrinsics.checkNotNullExpressionValue(type, "type");
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(type, "image", false, 2, null);
            if (!startsWith$default) {
                startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(type, "video", false, 2, null);
                if (startsWith$default2) {
                    wiFiPhotoFileType = WiFiPhotoFileType.KVIDEO;
                } else {
                    wiFiPhotoFileType = WiFiPhotoFileType.KOTHERS;
                }
            } else {
                wiFiPhotoFileType = WiFiPhotoFileType.KPICTURE;
            }
            photoDetailInfo.fileType = wiFiPhotoFileType;
            Unit unit = Unit.INSTANCE;
            mediaList.add(TuplesKt.to(string3, photoDetailInfo));
        }
    }

    private final void b(Cursor cursor, ArrayList<PhotoSimpleInfo> mediaList) {
        int columnIndexOrThrow = cursor.getColumnIndexOrThrow("_id");
        int columnIndexOrThrow2 = cursor.getColumnIndexOrThrow("date_modified");
        int i3 = 0;
        while (cursor.moveToNext()) {
            i3++;
            String string = cursor.getString(columnIndexOrThrow);
            long j3 = cursor.getLong(columnIndexOrThrow2);
            PhotoSimpleInfo photoSimpleInfo = new PhotoSimpleInfo();
            photoSimpleInfo.photoId = string;
            photoSimpleInfo.creationTime = j3;
            mediaList.add(photoSimpleInfo);
        }
        QLog.i("WifiPhotoQueryHelper", 1, "doQuerySimpleInfo count: " + i3 + ", mediaList size: " + mediaList.size());
    }

    private final ArrayList<PhotoSimpleInfo> d(Context context, int limit) {
        Uri build;
        Cursor cursor = null;
        try {
            try {
                if (limit == -1) {
                    build = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                } else {
                    build = MediaStore.Video.Media.EXTERNAL_CONTENT_URI.buildUpon().appendQueryParameter("limit", String.valueOf(limit)).build();
                }
                Cursor query = ContactsMonitor.query(context.getContentResolver(), build, com.tencent.qqnt.qbasealbum.albumlist.repository.b.f360875a.b(), com.tencent.qqnt.qbasealbum.albumlist.repository.a.f360874a.b(QAlbumPickerContext.f361201a.e().o()), null, "date_modified DESC");
                if (query == null) {
                    ox3.a.g("WifiPhotoQueryHelper", WifiPhotoQueryHelper$queryLocalVideoList$1.INSTANCE);
                    return new ArrayList<>();
                }
                ArrayList<PhotoSimpleInfo> arrayList = new ArrayList<>();
                int columnIndexOrThrow = query.getColumnIndexOrThrow("_id");
                int columnIndexOrThrow2 = query.getColumnIndexOrThrow("date_modified");
                while (query.moveToNext()) {
                    String string = query.getString(columnIndexOrThrow);
                    long j3 = query.getLong(columnIndexOrThrow2);
                    PhotoSimpleInfo photoSimpleInfo = new PhotoSimpleInfo();
                    photoSimpleInfo.photoId = string;
                    photoSimpleInfo.creationTime = j3;
                    arrayList.add(photoSimpleInfo);
                }
                query.close();
                return arrayList;
            } catch (Exception e16) {
                QLog.e("WifiPhotoQueryHelper", 1, "queryLocalVideoList(), query failed", e16);
                throw e16;
            }
        } catch (Throwable th5) {
            if (0 != 0) {
                cursor.close();
            }
            throw th5;
        }
    }

    private final ArrayList<PhotoSimpleInfo> g(Context context, int limit) {
        Uri build;
        Uri build2;
        List mutableList;
        Cursor cursor = null;
        try {
            try {
                if (limit == -1) {
                    build = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                } else {
                    build = MediaStore.Images.Media.EXTERNAL_CONTENT_URI.buildUpon().appendQueryParameter("limit", String.valueOf(limit)).build();
                }
                Uri uri = build;
                if (limit == -1) {
                    build2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                } else {
                    build2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI.buildUpon().appendQueryParameter("limit", String.valueOf(limit)).build();
                }
                ArrayList<PhotoSimpleInfo> arrayList = new ArrayList<>();
                ContentResolver contentResolver = context.getContentResolver();
                com.tencent.qqnt.qbasealbum.albumlist.repository.b bVar = com.tencent.qqnt.qbasealbum.albumlist.repository.b.f360875a;
                String[] a16 = bVar.a();
                com.tencent.qqnt.qbasealbum.albumlist.repository.a aVar = com.tencent.qqnt.qbasealbum.albumlist.repository.a.f360874a;
                QAlbumPickerContext qAlbumPickerContext = QAlbumPickerContext.f361201a;
                Cursor query = ContactsMonitor.query(contentResolver, uri, a16, aVar.a(qAlbumPickerContext.e().o()), null, "date_modified DESC");
                if (query == null) {
                    ox3.a.g("WifiPhotoQueryHelper", WifiPhotoQueryHelper$queryRecentAlbumList$1.INSTANCE);
                } else {
                    b(query, arrayList);
                    query.close();
                }
                cursor = ContactsMonitor.query(context.getContentResolver(), build2, bVar.b(), aVar.b(qAlbumPickerContext.e().o()), null, "date_modified DESC");
                if (cursor == null) {
                    ox3.a.g("WifiPhotoQueryHelper", WifiPhotoQueryHelper$queryRecentAlbumList$2.INSTANCE);
                } else {
                    b(cursor, arrayList);
                }
                if (arrayList.size() > 1) {
                    CollectionsKt__MutableCollectionsJVMKt.sortWith(arrayList, new b());
                }
                if (limit != -1 && arrayList.size() > limit) {
                    List<PhotoSimpleInfo> subList = arrayList.subList(0, limit);
                    Intrinsics.checkNotNullExpressionValue(subList, "mediaList.subList(0, limit)");
                    mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) subList);
                    Intrinsics.checkNotNull(mutableList, "null cannot be cast to non-null type java.util.ArrayList<com.tencent.qqnt.kernel.nativeinterface.PhotoSimpleInfo>{ kotlin.collections.TypeAliasesKt.ArrayList<com.tencent.qqnt.kernel.nativeinterface.PhotoSimpleInfo> }");
                    arrayList = (ArrayList) mutableList;
                }
                return arrayList;
            } catch (Exception e16) {
                QLog.e("WifiPhotoQueryHelper", 1, "queryRecentAlbumList error", e16);
                throw e16;
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    @NotNull
    public final ArrayList<PhotoSimpleInfo> c(@NotNull Context context, int limit, @NotNull String albumId) {
        Uri build;
        Uri build2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ArrayList) iPatchRedirector.redirect((short) 2, this, context, Integer.valueOf(limit), albumId);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(albumId, "albumId");
        com.tencent.qqnt.qbasealbum.model.a aVar = com.tencent.qqnt.qbasealbum.model.a.f361348a;
        if (Intrinsics.areEqual(albumId, aVar.b())) {
            return d(context, limit);
        }
        if (Intrinsics.areEqual(albumId, aVar.a())) {
            return g(context, limit);
        }
        Cursor cursor = null;
        try {
            try {
                if (limit == -1) {
                    build = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                } else {
                    build = MediaStore.Images.Media.EXTERNAL_CONTENT_URI.buildUpon().appendQueryParameter("limit", String.valueOf(limit)).build();
                }
                Uri uri = build;
                if (limit == -1) {
                    build2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                } else {
                    build2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI.buildUpon().appendQueryParameter("limit", String.valueOf(limit)).build();
                }
                ArrayList<PhotoSimpleInfo> arrayList = new ArrayList<>();
                String str = "bucket_id = " + albumId;
                ContentResolver contentResolver = context.getContentResolver();
                com.tencent.qqnt.qbasealbum.albumlist.repository.b bVar = com.tencent.qqnt.qbasealbum.albumlist.repository.b.f360875a;
                Cursor query = ContactsMonitor.query(contentResolver, uri, bVar.a(), str, null, "date_modified DESC");
                if (query != null) {
                    b(query, arrayList);
                    query.close();
                }
                cursor = ContactsMonitor.query(context.getContentResolver(), build2, bVar.b(), str, null, "date_modified DESC");
                if (cursor != null) {
                    b(cursor, arrayList);
                    if (arrayList.size() > 1) {
                        CollectionsKt__MutableCollectionsJVMKt.sortWith(arrayList, new a());
                    }
                    cursor.close();
                    return arrayList;
                }
                return new ArrayList<>();
            } catch (Exception e16) {
                QLog.e("WifiPhotoQueryHelper", 1, "queryAlbumList(), query failed", e16);
                throw e16;
            }
        } catch (Throwable th5) {
            if (cursor != null) {
                cursor.close();
            }
            throw th5;
        }
    }

    @NotNull
    public final Pair<String, PhotoDetailInfo> e(@NotNull String id5) {
        Object firstOrNull;
        Object firstOrNull2;
        Object firstOrNull3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Pair) iPatchRedirector.redirect((short) 3, (Object) this, (Object) id5);
        }
        Intrinsics.checkNotNullParameter(id5, "id");
        ArrayList<Pair<String, PhotoDetailInfo>> arrayList = new ArrayList<>();
        String str = "_id=" + id5;
        ContentResolver contentResolver = BaseApplication.context.getContentResolver();
        Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        String[] strArr = detailProjection;
        Cursor query = ContactsMonitor.query(contentResolver, uri, strArr, str, null, null);
        if (query != null) {
            a(query, arrayList);
            QLog.d("WifiPhotoQueryHelper", 1, "getPhoto photoId: " + id5 + ", path: " + arrayList);
            query.close();
            if (!arrayList.isEmpty()) {
                firstOrNull3 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) arrayList);
                Pair<String, PhotoDetailInfo> pair = (Pair) firstOrNull3;
                if (pair == null) {
                    return TuplesKt.to("", new PhotoDetailInfo());
                }
                return pair;
            }
        }
        Cursor query2 = ContactsMonitor.query(BaseApplication.context.getContentResolver(), MediaStore.Video.Media.EXTERNAL_CONTENT_URI, strArr, str, null, null);
        if (query2 == null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) arrayList);
            Pair<String, PhotoDetailInfo> pair2 = (Pair) firstOrNull;
            if (pair2 == null) {
                return TuplesKt.to("", new PhotoDetailInfo());
            }
            return pair2;
        }
        a(query2, arrayList);
        QLog.d("WifiPhotoQueryHelper", 1, "getPhoto photoId: " + id5 + ", path: " + arrayList);
        query2.close();
        firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) arrayList);
        Pair<String, PhotoDetailInfo> pair3 = (Pair) firstOrNull2;
        if (pair3 == null) {
            return TuplesKt.to("", new PhotoDetailInfo());
        }
        return pair3;
    }

    @NotNull
    public final ArrayList<PhotoDetailInfo> f(@NotNull String albumId, @NotNull ArrayList<String> photoBatch) {
        String joinToString$default;
        List reversed;
        int collectionSizeOrDefault;
        List mutableList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ArrayList) iPatchRedirector.redirect((short) 4, (Object) this, (Object) albumId, (Object) photoBatch);
        }
        Intrinsics.checkNotNullParameter(albumId, "albumId");
        Intrinsics.checkNotNullParameter(photoBatch, "photoBatch");
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(photoBatch, ",", null, null, 0, null, null, 62, null);
        String str = "_id in (" + joinToString$default + ")";
        QLog.d("WifiPhotoQueryHelper", 1, "getMediaInfoBatch selection: " + str);
        ContentResolver contentResolver = BaseApplication.context.getContentResolver();
        Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        String[] strArr = detailProjection;
        Cursor query = ContactsMonitor.query(contentResolver, uri, strArr, str, null, null);
        ArrayList<Pair<String, PhotoDetailInfo>> arrayList = new ArrayList<>();
        if (query != null) {
            a(query, arrayList);
            query.close();
        }
        Cursor query2 = ContactsMonitor.query(BaseApplication.context.getContentResolver(), MediaStore.Video.Media.EXTERNAL_CONTENT_URI, strArr, str, null, null);
        if (query2 != null) {
            a(query2, arrayList);
            query2.close();
        }
        reversed = CollectionsKt___CollectionsKt.reversed(arrayList);
        List list = reversed;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList2.add((PhotoDetailInfo) ((Pair) it.next()).getSecond());
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList2);
        Intrinsics.checkNotNull(mutableList, "null cannot be cast to non-null type java.util.ArrayList<com.tencent.qqnt.kernel.nativeinterface.PhotoDetailInfo>");
        return (ArrayList) mutableList;
    }
}
