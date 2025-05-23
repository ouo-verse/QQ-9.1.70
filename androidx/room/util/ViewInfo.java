package androidx.room.util;

import android.database.Cursor;
import androidx.annotation.RestrictTo;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public final class ViewInfo {
    public final String name;
    public final String sql;

    public ViewInfo(String str, String str2) {
        this.name = str;
        this.sql = str2;
    }

    public static ViewInfo read(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
        Cursor query = supportSQLiteDatabase.query("SELECT name, sql FROM sqlite_master WHERE type = 'view' AND name = '" + str + "'");
        try {
            if (query.moveToFirst()) {
                return new ViewInfo(query.getString(0), query.getString(1));
            }
            return new ViewInfo(str, null);
        } finally {
            query.close();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ViewInfo)) {
            return false;
        }
        ViewInfo viewInfo = (ViewInfo) obj;
        String str = this.name;
        if (str == null ? viewInfo.name == null : str.equals(viewInfo.name)) {
            String str2 = this.sql;
            if (str2 != null) {
                if (str2.equals(viewInfo.sql)) {
                    return true;
                }
            } else if (viewInfo.sql == null) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i3;
        String str = this.name;
        int i16 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i17 = i3 * 31;
        String str2 = this.sql;
        if (str2 != null) {
            i16 = str2.hashCode();
        }
        return i17 + i16;
    }

    public String toString() {
        return "ViewInfo{name='" + this.name + "', sql='" + this.sql + "'}";
    }
}
