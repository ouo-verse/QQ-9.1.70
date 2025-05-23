package mz4;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.open.business.base.MobileInfoUtil;
import jz4.c;

/* compiled from: P */
/* loaded from: classes28.dex */
public class a extends SQLiteOpenHelper {

    /* renamed from: d, reason: collision with root package name */
    private static int f417905d = 1;

    /* renamed from: e, reason: collision with root package name */
    public static final Object f417906e = new Object();

    /* renamed from: f, reason: collision with root package name */
    private static final String[] f417907f = {"package_name", "TEXT", "message_ts", " LONG DEFAULT 0 ", "bytes", " LONG DEFAULT 0 ", "network_type", " INT DEFAULT -1 ", "rcv", " INT DEFAULT -1 ", MobileInfoUtil.IMSI, "TEXT"};

    public a(Context context) {
        super(context, "traffic.db", (SQLiteDatabase.CursorFactory) null, f417905d);
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        StringBuilder sb5 = new StringBuilder("CREATE TABLE traffic(_id INTEGER  PRIMARY KEY ,");
        int i3 = 0;
        while (true) {
            String[] strArr = f417907f;
            if (i3 < strArr.length - 1) {
                if (i3 != 0) {
                    sb5.append(",");
                }
                sb5.append(strArr[i3]);
                sb5.append(" ");
                sb5.append(strArr[i3 + 1]);
                i3 += 2;
            } else {
                sb5.append(");");
                sQLiteDatabase.execSQL(sb5.toString());
                return;
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        synchronized (f417906e) {
            try {
                a(sQLiteDatabase);
            } catch (SQLException e16) {
                c.q(e16);
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
    }
}
