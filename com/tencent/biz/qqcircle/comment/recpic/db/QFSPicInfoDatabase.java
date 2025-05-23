package com.tencent.biz.qqcircle.comment.recpic.db;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.tencent.biz.qqcircle.comment.recpic.QFSRecPicInfo;
import com.tencent.richframework.thread.pool.RFWSubThreadPool;
import com.tencent.xaction.log.b;
import java.util.concurrent.ExecutorService;

@Database(entities = {QFSRecPicInfo.class}, exportSchema = false, version = 1)
/* loaded from: classes4.dex */
public abstract class QFSPicInfoDatabase extends RoomDatabase {

    /* renamed from: a, reason: collision with root package name */
    private static volatile QFSPicInfoDatabase f83819a;

    /* renamed from: b, reason: collision with root package name */
    static final ExecutorService f83820b = new RFWSubThreadPool();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c() {
        synchronized (QFSPicInfoDatabase.class) {
            try {
                try {
                    if (f83819a != null && f83819a.isOpen()) {
                        f83819a.close();
                    }
                } catch (Exception e16) {
                    b.a("QFSPicInfoDatabase", 1, "closeDatabase error, " + e16);
                }
            } finally {
                f83819a = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static QFSPicInfoDatabase d(Context context) {
        if (f83819a == null) {
            synchronized (QFSPicInfoDatabase.class) {
                if (f83819a == null) {
                    f83819a = (QFSPicInfoDatabase) Room.databaseBuilder(context, QFSPicInfoDatabase.class, "rec_pic_database").enableMultiInstanceInvalidation().setQueryExecutor(f83820b).build();
                }
            }
        }
        return f83819a;
    }

    public abstract v20.b e();
}
