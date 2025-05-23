package com.tencent.qqprotect.accountassistant.chat.data.model.db;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
@Database(entities = {c.class}, exportSchema = false, version = 5)
/* loaded from: classes25.dex */
public abstract class AssistantRobotDatabase extends RoomDatabase {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static volatile AssistantRobotDatabase f363459a;

    public AssistantRobotDatabase() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static AssistantRobotDatabase c(Context context) {
        if (f363459a == null) {
            synchronized (AssistantRobotDatabase.class) {
                if (f363459a == null) {
                    f363459a = (AssistantRobotDatabase) Room.databaseBuilder(context.getApplicationContext(), AssistantRobotDatabase.class, "assistant_robot_db").fallbackToDestructiveMigration().build();
                }
            }
        }
        return f363459a;
    }

    public abstract a d();
}
