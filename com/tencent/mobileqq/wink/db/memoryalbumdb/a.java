package com.tencent.mobileqq.wink.db.memoryalbumdb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/wink/db/memoryalbumdb/a;", "Landroid/database/sqlite/SQLiteOpenHelper;", "Landroid/database/sqlite/SQLiteDatabase;", TVKNetVideoInfo.AUDIO_TRACK_DOLBY, "", "onCreate", "", "oldVersion", "newVersion", "onUpgrade", "Landroid/content/Context;", "context", "", "name", "Landroid/database/sqlite/SQLiteDatabase$CursorFactory;", "factory", "version", "<init>", "(Landroid/content/Context;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;I)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a extends SQLiteOpenHelper {
    public a(@Nullable Context context, @Nullable String str, @Nullable SQLiteDatabase.CursorFactory cursorFactory, int i3) {
        super(context, str, cursorFactory, i3);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(@NotNull SQLiteDatabase db5) {
        Intrinsics.checkNotNullParameter(db5, "db");
        db5.execSQL("create table if not exists t_wink_memory_photo(id text primary key, mediatype integer, year integer, month integer, dayofmonth integer, dayofweek integer, week integer, path text, timestamp long, haveface integer, isdeleted integer,width integer, height integer, duration integer)");
        db5.execSQL("create table if not exists t_wink_memory_album(id text primary key, storyId text, coverPhotoId text, timestamp long)");
        db5.execSQL("create table if not exists t_wink_memory_album_photo(id integer primary key autoincrement, photo_id text, album_id text)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(@NotNull SQLiteDatabase db5, int oldVersion, int newVersion) {
        Intrinsics.checkNotNullParameter(db5, "db");
        db5.execSQL("drop table if exists t_wink_memory_photo");
        db5.execSQL("drop table if exists t_wink_memory_album");
        db5.execSQL("drop table if exists t_wink_memory_album_photo");
        onCreate(db5);
    }
}
