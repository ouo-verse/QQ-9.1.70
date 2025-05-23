package androidx.room.util;

import android.database.Cursor;
import android.database.MatrixCursor;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import java.util.Arrays;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class CursorUtil {
    CursorUtil() {
    }

    @NonNull
    public static Cursor copyAndClose(@NonNull Cursor cursor) {
        try {
            MatrixCursor matrixCursor = new MatrixCursor(cursor.getColumnNames(), cursor.getCount());
            while (cursor.moveToNext()) {
                Object[] objArr = new Object[cursor.getColumnCount()];
                for (int i3 = 0; i3 < cursor.getColumnCount(); i3++) {
                    int type = cursor.getType(i3);
                    if (type != 0) {
                        if (type != 1) {
                            if (type != 2) {
                                if (type != 3) {
                                    if (type == 4) {
                                        objArr[i3] = cursor.getBlob(i3);
                                    } else {
                                        throw new IllegalStateException();
                                    }
                                } else {
                                    objArr[i3] = cursor.getString(i3);
                                }
                            } else {
                                objArr[i3] = Double.valueOf(cursor.getDouble(i3));
                            }
                        } else {
                            objArr[i3] = Long.valueOf(cursor.getLong(i3));
                        }
                    } else {
                        objArr[i3] = null;
                    }
                }
                matrixCursor.addRow(objArr);
            }
            return matrixCursor;
        } finally {
            cursor.close();
        }
    }

    private static int findColumnIndexBySuffix(@NonNull Cursor cursor, @NonNull String str) {
        if (Build.VERSION.SDK_INT <= 25 && str.length() != 0) {
            return findColumnIndexBySuffix(cursor.getColumnNames(), str);
        }
        return -1;
    }

    public static int getColumnIndex(@NonNull Cursor cursor, @NonNull String str) {
        int columnIndex = cursor.getColumnIndex(str);
        if (columnIndex >= 0) {
            return columnIndex;
        }
        int columnIndex2 = cursor.getColumnIndex("`" + str + "`");
        if (columnIndex2 >= 0) {
            return columnIndex2;
        }
        return findColumnIndexBySuffix(cursor, str);
    }

    public static int getColumnIndexOrThrow(@NonNull Cursor cursor, @NonNull String str) {
        String str2;
        int columnIndex = getColumnIndex(cursor, str);
        if (columnIndex >= 0) {
            return columnIndex;
        }
        try {
            str2 = Arrays.toString(cursor.getColumnNames());
        } catch (Exception e16) {
            Log.d("RoomCursorUtil", "Cannot collect column names for debug purposes", e16);
            str2 = "";
        }
        throw new IllegalArgumentException("column '" + str + "' does not exist. Available columns: " + str2);
    }

    @VisibleForTesting(otherwise = 2)
    static int findColumnIndexBySuffix(String[] strArr, String str) {
        String str2 = "." + str;
        String str3 = "." + str + "`";
        for (int i3 = 0; i3 < strArr.length; i3++) {
            String str4 = strArr[i3];
            if (str4.length() >= str.length() + 2) {
                if (str4.endsWith(str2)) {
                    return i3;
                }
                if (str4.charAt(0) == '`' && str4.endsWith(str3)) {
                    return i3;
                }
            }
        }
        return -1;
    }
}
