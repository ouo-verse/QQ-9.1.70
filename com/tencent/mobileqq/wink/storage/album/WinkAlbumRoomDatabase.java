package com.tencent.mobileqq.wink.storage.album;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import da3.a;
import ha3.PhotoFace;
import java.util.concurrent.ExecutorService;

/* compiled from: P */
@Database(entities = {PhotoFace.class}, exportSchema = false, version = 1)
/* loaded from: classes21.dex */
public abstract class WinkAlbumRoomDatabase extends RoomDatabase {

    /* renamed from: a, reason: collision with root package name */
    private static volatile WinkAlbumRoomDatabase f326399a;

    /* renamed from: b, reason: collision with root package name */
    private static final ExecutorService f326400b = ProxyExecutors.newFixedThreadPool(4);

    private static WinkAlbumRoomDatabase c(Context context) {
        return (WinkAlbumRoomDatabase) Room.databaseBuilder(context.getApplicationContext(), WinkAlbumRoomDatabase.class, "wink_album_db").enableMultiInstanceInvalidation().setQueryExecutor(f326400b).build();
    }

    public static WinkAlbumRoomDatabase d(Context context) {
        if (f326399a == null) {
            synchronized (WinkAlbumRoomDatabase.class) {
                if (f326399a == null) {
                    f326399a = c(context);
                }
            }
        }
        return f326399a;
    }

    public abstract a e();
}
