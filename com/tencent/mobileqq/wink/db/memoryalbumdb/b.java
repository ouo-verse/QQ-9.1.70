package com.tencent.mobileqq.wink.db.memoryalbumdb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.templatelibrary.memoryalbum.WinkMemoryAlbumConfig;
import com.tencent.mobileqq.wink.utils.ak;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000  2\u00020\u0001:\u0001\u001fB\u0011\u0012\b\u0010%\u001a\u0004\u0018\u00010$\u00a2\u0006\u0004\b&\u0010'J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u001e\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\t0\u0004H\u0002J\u0016\u0010\r\u001a\u00020\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u000bH\u0016J\u0006\u0010\u000e\u001a\u00020\u0007J\u0016\u0010\u000f\u001a\u00020\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u000bH\u0016J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bH\u0016J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\u000bH\u0016J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0016\u0010\u0016\u001a\u00020\u00072\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bH\u0016J\u0010\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0005H\u0016J \u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\b\u0010\u001f\u001a\u00020\u0007H\u0016J\b\u0010 \u001a\u00020\u0007H\u0016R\u0014\u0010#\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\"\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/wink/db/memoryalbumdb/b;", "", "Landroid/database/Cursor;", "cursor", "", "Ls53/a;", "lists", "", "k", "Ls53/b;", "l", "", "winkMemoryPhotos", "g", "c", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "e", "f", "Lcom/tencent/mobileqq/wink/templatelibrary/memoryalbum/l;", DownloadInfo.spKey_Config, "d", "winkMemoryAlbums", h.F, "winkMemoryAlbum", "i", "", "albumId", "photoId", "Landroid/database/sqlite/SQLiteDatabase;", TVKNetVideoInfo.AUDIO_TRACK_DOLBY, "j", "a", "b", "Lcom/tencent/mobileqq/wink/db/memoryalbumdb/a;", "Lcom/tencent/mobileqq/wink/db/memoryalbumdb/a;", "winkMemoryAlbumDbOpenHandler", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a winkMemoryAlbumDbOpenHandler;

    public b(@Nullable Context context) {
        this.winkMemoryAlbumDbOpenHandler = new a(context, "wink_memory_album.db", null, 3);
    }

    private final void k(Cursor cursor, List<s53.a> lists) {
        while (cursor.moveToNext()) {
            s53.a a16 = s53.a.INSTANCE.a(cursor);
            if (a16 != null) {
                lists.add(a16);
            }
        }
    }

    private final void l(Cursor cursor, List<s53.b> lists) {
        while (cursor.moveToNext()) {
            s53.b a16 = s53.b.INSTANCE.a(cursor);
            if (a16 != null) {
                lists.add(a16);
            }
        }
        cursor.close();
    }

    public void a() {
        this.winkMemoryAlbumDbOpenHandler.close();
    }

    public void b() {
        SQLiteDatabase writableDatabase = this.winkMemoryAlbumDbOpenHandler.getWritableDatabase();
        writableDatabase.delete("t_wink_memory_album", null, null);
        writableDatabase.delete("t_wink_memory_album_photo", null, null);
    }

    public final void c() {
        SQLiteDatabase writableDatabase = this.winkMemoryAlbumDbOpenHandler.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("isdeleted", (Integer) 1);
        writableDatabase.update("t_wink_memory_photo", contentValues, null, null);
    }

    @NotNull
    public List<s53.a> d(@NotNull WinkMemoryAlbumConfig config) {
        List split$default;
        Object random;
        List split$default2;
        Object random2;
        List<String> list;
        Intrinsics.checkNotNullParameter(config, "config");
        ArrayList arrayList = new ArrayList();
        Cursor rawQuery = this.winkMemoryAlbumDbOpenHandler.getReadableDatabase().rawQuery(config.getStorySQL(), null);
        if (QLog.isColorLevel()) {
            QLog.d("WinkMemoryAlbumSQLiteDAOImpl", 1, "executeQueryAlbum, config:" + config.b() + ", rows:" + rawQuery.getCount());
        }
        while (rawQuery.moveToNext()) {
            int columnIndex = rawQuery.getColumnIndex("ids");
            if (columnIndex == -1) {
                if (QLog.isColorLevel()) {
                    QLog.d("WinkMemoryAlbumSQLiteDAOImpl", 1, "executeQueryAlbum, idsIndex is -1, storyId:" + config.getCom.tencent.mobileqq.wink.api.QQWinkConstants.STORY_ID java.lang.String() + ", storyName:" + config.getStoryName());
                }
            } else {
                String idArray = rawQuery.getString(columnIndex);
                Intrinsics.checkNotNullExpressionValue(idArray, "idArray");
                boolean z16 = false;
                Object[] array = new Regex(",").split(idArray, 0).toArray(new String[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                String[] strArr = (String[]) array;
                if (strArr.length == 0) {
                    z16 = true;
                }
                if (!z16 && config.getMinPhotoCnt() <= strArr.length) {
                    String b16 = ak.f326673a.b(idArray);
                    WinkMemoryAlbumConfig clone = config.clone();
                    split$default = StringsKt__StringsKt.split$default((CharSequence) config.getStoryName(), new String[]{","}, false, 0, 6, (Object) null);
                    Random.Companion companion = Random.INSTANCE;
                    random = CollectionsKt___CollectionsKt.random(split$default, companion);
                    clone.m((String) random);
                    split$default2 = StringsKt__StringsKt.split$default((CharSequence) config.getTemplateID(), new String[]{","}, false, 0, 6, (Object) null);
                    random2 = CollectionsKt___CollectionsKt.random(split$default2, companion);
                    clone.n((String) random2);
                    s53.a aVar = new s53.a(config.getCom.tencent.mobileqq.wink.api.QQWinkConstants.STORY_ID java.lang.String() + b16, clone.getCom.tencent.mobileqq.wink.api.QQWinkConstants.STORY_ID java.lang.String());
                    aVar.o(clone);
                    list = ArraysKt___ArraysKt.toList(strArr);
                    aVar.b(list);
                    arrayList.add(aVar);
                } else if (QLog.isColorLevel()) {
                    String str = config.getCom.tencent.mobileqq.wink.api.QQWinkConstants.STORY_ID java.lang.String();
                    String storyName = config.getStoryName();
                    String arrays = Arrays.toString(strArr);
                    Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
                    QLog.d("WinkMemoryAlbumSQLiteDAOImpl", 1, "executeQueryAlbum, idArrays size is invalid, storyId:" + str + ", storyName:" + storyName + ", idArrays:" + arrays + ", minPhotoCnt:" + config.getMinPhotoCnt());
                }
            }
        }
        rawQuery.close();
        if (QLog.isColorLevel()) {
            QLog.d("WinkMemoryAlbumSQLiteDAOImpl", 1, "executeQueryAlbum, ret lists:" + arrayList.size());
        }
        return arrayList;
    }

    @NotNull
    public List<s53.a> e() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = this.winkMemoryAlbumDbOpenHandler.getReadableDatabase().query("t_wink_memory_album", null, null, null, null, null, null);
        Intrinsics.checkNotNullExpressionValue(cursor, "cursor");
        k(cursor, arrayList);
        cursor.close();
        return arrayList;
    }

    @NotNull
    public List<s53.b> f() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = this.winkMemoryAlbumDbOpenHandler.getReadableDatabase().query("t_wink_memory_photo", null, null, null, null, null, null);
        Intrinsics.checkNotNullExpressionValue(cursor, "cursor");
        l(cursor, arrayList);
        return arrayList;
    }

    public void g(@NotNull List<s53.b> winkMemoryPhotos) {
        Intrinsics.checkNotNullParameter(winkMemoryPhotos, "winkMemoryPhotos");
        SQLiteDatabase writableDatabase = this.winkMemoryAlbumDbOpenHandler.getWritableDatabase();
        writableDatabase.beginTransaction();
        for (s53.b bVar : winkMemoryPhotos) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", bVar.getId());
            contentValues.put("mediatype", Integer.valueOf(bVar.getMediaType()));
            contentValues.put("year", Integer.valueOf(bVar.getYear()));
            contentValues.put("month", Integer.valueOf(bVar.getMonth()));
            contentValues.put("dayofmonth", Integer.valueOf(bVar.getDayOfMonth()));
            contentValues.put("dayofweek", Integer.valueOf(bVar.getDayOfWeek()));
            contentValues.put(WidgetCacheLunarData.WEEK, Integer.valueOf(bVar.getCom.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData.WEEK java.lang.String()));
            contentValues.put("path", bVar.getPath());
            contentValues.put("timestamp", Long.valueOf(bVar.getTimestamp()));
            contentValues.put("haveface", Integer.valueOf(bVar.getHaveFace()));
            contentValues.put("isdeleted", Integer.valueOf(bVar.getIsDeleted()));
            contentValues.put("width", Integer.valueOf(bVar.getWidth()));
            contentValues.put("height", Integer.valueOf(bVar.getHeight()));
            contentValues.put("duration", Integer.valueOf(bVar.getDuration()));
            writableDatabase.insertWithOnConflict("t_wink_memory_photo", null, contentValues, 4);
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("isdeleted", (Integer) 0);
            writableDatabase.update("t_wink_memory_photo", contentValues2, "id=?", new String[]{bVar.getId()});
        }
        writableDatabase.setTransactionSuccessful();
        writableDatabase.endTransaction();
    }

    public void h(@NotNull List<s53.a> winkMemoryAlbums) {
        Intrinsics.checkNotNullParameter(winkMemoryAlbums, "winkMemoryAlbums");
        SQLiteDatabase writableDatabase = this.winkMemoryAlbumDbOpenHandler.getWritableDatabase();
        writableDatabase.beginTransaction();
        Iterator<T> it = winkMemoryAlbums.iterator();
        while (it.hasNext()) {
            i((s53.a) it.next());
        }
        writableDatabase.setTransactionSuccessful();
        writableDatabase.endTransaction();
    }

    public void i(@NotNull s53.a winkMemoryAlbum) {
        Intrinsics.checkNotNullParameter(winkMemoryAlbum, "winkMemoryAlbum");
        ContentValues contentValues = new ContentValues();
        SQLiteDatabase db5 = this.winkMemoryAlbumDbOpenHandler.getWritableDatabase();
        contentValues.put("id", winkMemoryAlbum.getId());
        contentValues.put(QQWinkConstants.STORY_ID, winkMemoryAlbum.getCom.tencent.mobileqq.wink.api.QQWinkConstants.STORY_ID java.lang.String());
        contentValues.put("coverPhotoId", winkMemoryAlbum.getCoverPhotoId());
        contentValues.put("timestamp", Long.valueOf(winkMemoryAlbum.getTimestamp()));
        db5.insertWithOnConflict("t_wink_memory_album", null, contentValues, 5);
        for (String str : winkMemoryAlbum.n()) {
            String id5 = winkMemoryAlbum.getId();
            Intrinsics.checkNotNullExpressionValue(db5, "db");
            j(id5, str, db5);
        }
    }

    public void j(@NotNull String albumId, @NotNull String photoId, @NotNull SQLiteDatabase db5) {
        Intrinsics.checkNotNullParameter(albumId, "albumId");
        Intrinsics.checkNotNullParameter(photoId, "photoId");
        Intrinsics.checkNotNullParameter(db5, "db");
        ContentValues contentValues = new ContentValues();
        contentValues.put(QCircleScheme.AttrQQPublish.PICKER_ALBUM_ID, albumId);
        contentValues.put("photo_id", photoId);
        db5.insertWithOnConflict("t_wink_memory_album_photo", null, contentValues, 5);
    }

    public void m(@NotNull List<s53.b> winkMemoryPhotos) {
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        int collectionSizeOrDefault3;
        String joinToString$default;
        int collectionSizeOrDefault4;
        String joinToString$default2;
        boolean z16;
        Intrinsics.checkNotNullParameter(winkMemoryPhotos, "winkMemoryPhotos");
        SQLiteDatabase writableDatabase = this.winkMemoryAlbumDbOpenHandler.getWritableDatabase();
        List<s53.b> list = winkMemoryPhotos;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (true) {
            boolean z17 = false;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((s53.b) next).getHaveFace() == 2) {
                z17 = true;
            }
            if (z17) {
                arrayList.add(next);
            }
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator it5 = arrayList.iterator();
        while (it5.hasNext()) {
            arrayList2.add(((s53.b) it5.next()).getId());
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : list) {
            if (((s53.b) obj).getHaveFace() == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                arrayList3.add(obj);
            }
        }
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList3, 10);
        ArrayList arrayList4 = new ArrayList(collectionSizeOrDefault2);
        Iterator it6 = arrayList3.iterator();
        while (it6.hasNext()) {
            arrayList4.add(((s53.b) it6.next()).getId());
        }
        collectionSizeOrDefault3 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10);
        ArrayList arrayList5 = new ArrayList(collectionSizeOrDefault3);
        Iterator it7 = arrayList2.iterator();
        while (it7.hasNext()) {
            arrayList5.add("\"" + ((String) it7.next()) + "\"");
        }
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList5, ",", null, null, 0, null, null, 62, null);
        writableDatabase.execSQL("update t_wink_memory_photo set haveface = 2 where id in (" + joinToString$default + ")");
        collectionSizeOrDefault4 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList4, 10);
        ArrayList arrayList6 = new ArrayList(collectionSizeOrDefault4);
        Iterator it8 = arrayList4.iterator();
        while (it8.hasNext()) {
            arrayList6.add("\"" + ((String) it8.next()) + "\"");
        }
        joinToString$default2 = CollectionsKt___CollectionsKt.joinToString$default(arrayList6, ",", null, null, 0, null, null, 62, null);
        writableDatabase.execSQL("update t_wink_memory_photo set haveface = 1 where id in (" + joinToString$default2 + ")");
    }
}
