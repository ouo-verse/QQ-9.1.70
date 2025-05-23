package com.tencent.qmethod.pandoraex.core.strategy;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.MatrixCursor;
import com.tencent.qmethod.pandoraex.core.o;
import com.tencent.qmethod.pandoraex.provider.PandoraExProvider;

/* compiled from: P */
/* loaded from: classes22.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static volatile SharedPreferences f344162a;

    public static void a(Context context) {
        f(context).edit().clear().apply();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean b(Cursor cursor) {
        if (cursor == null) {
            return false;
        }
        try {
            if (cursor.getCount() == 0) {
                cursor.close();
                return false;
            }
            try {
                boolean moveToFirst = cursor.moveToFirst();
                cursor.close();
                return moveToFirst;
            } catch (Exception e16) {
                o.d("SharedPreferencesManager", "cursor query data exception is ", e16);
                cursor.close();
                return false;
            }
        } catch (Throwable unused) {
            cursor.close();
            return false;
        }
    }

    public static Boolean c(Context context, String str) {
        if (!f(context).contains(str)) {
            return null;
        }
        return Boolean.valueOf(f(context).getBoolean(str, false));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Boolean d(Cursor cursor) {
        if (cursor == null) {
            return Boolean.FALSE;
        }
        if (cursor.getCount() == 0) {
            cursor.close();
            return Boolean.FALSE;
        }
        Boolean bool = Boolean.FALSE;
        try {
            try {
                if (cursor.moveToFirst()) {
                    bool = Boolean.valueOf(cursor.getString(1).equals("true"));
                }
                cursor.close();
                return bool;
            } catch (Exception e16) {
                o.d("SharedPreferencesManager", "cursor query data exception is ", e16);
                cursor.close();
                return bool;
            }
        } catch (Throwable unused) {
            cursor.close();
            return bool;
        }
    }

    public static String e(Context context, String str) {
        if (!f(context).contains(str)) {
            return null;
        }
        return f(context).getString(str, "");
    }

    public static SharedPreferences f(Context context) {
        if (f344162a == null) {
            synchronized (c.class) {
                if (f344162a == null) {
                    if (context == null) {
                        o.c("SharedPreferencesManager", "sharedPreferences init error context is null");
                        return null;
                    }
                    f344162a = context.getSharedPreferences("PandoraManager", 4);
                }
            }
        }
        return f344162a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Integer g(Cursor cursor) {
        int i3 = 0;
        if (cursor == null) {
            return i3;
        }
        try {
            if (cursor.getCount() == 0) {
                cursor.close();
                return i3;
            }
            try {
                if (cursor.moveToFirst()) {
                    i3 = Integer.valueOf(cursor.getInt(1));
                }
                cursor.close();
                return i3;
            } catch (Exception e16) {
                o.d("SharedPreferencesManager", "cursor query data exception is ", e16);
                cursor.close();
                return i3;
            }
        } catch (Throwable unused) {
            cursor.close();
            return i3;
        }
    }

    public static Integer h(Context context, String str) {
        if (!f(context).contains(str)) {
            return null;
        }
        return Integer.valueOf(f(context).getInt(str, 0));
    }

    public static Long i(Context context, String str) {
        if (!f(context).contains(str)) {
            return null;
        }
        return Long.valueOf(f(context).getLong(str, 0L));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Long j(Cursor cursor) {
        long j3 = 0L;
        if (cursor == null) {
            return j3;
        }
        try {
            if (cursor.getCount() == 0) {
                cursor.close();
                return j3;
            }
            try {
                if (cursor.moveToFirst()) {
                    j3 = Long.valueOf(cursor.getLong(1));
                }
                cursor.close();
                return j3;
            } catch (Exception e16) {
                o.d("SharedPreferencesManager", "cursor query data exception is ", e16);
                cursor.close();
                return j3;
            }
        } catch (Throwable unused) {
            cursor.close();
            return j3;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String k(Cursor cursor) {
        String str = "data is null";
        if (cursor == null) {
            return "data is null";
        }
        if (cursor.getCount() == 0) {
            cursor.close();
            return "data is null";
        }
        try {
            try {
                if (cursor.moveToFirst()) {
                    str = cursor.getString(1);
                }
                cursor.close();
                return str;
            } catch (Exception e16) {
                o.d("SharedPreferencesManager", "cursor query data exception is ", e16);
                cursor.close();
                return "data is null";
            }
        } catch (Throwable unused) {
            cursor.close();
            return "data is null";
        }
    }

    public static Boolean l(Context context, String str) {
        return Boolean.valueOf(f(context).contains(str));
    }

    public static MatrixCursor m(Context context, String str, String str2) {
        String str3;
        int i3;
        long j3;
        boolean z16;
        MatrixCursor matrixCursor = new MatrixCursor(PandoraExProvider.f344170e);
        if ("Boolean".equals(str2)) {
            if (l(context, str).booleanValue()) {
                z16 = c(context, str).booleanValue();
            } else {
                z16 = false;
            }
            matrixCursor.addRow(new Object[]{str, Boolean.valueOf(z16)});
        } else if ("Long".equals(str2)) {
            if (l(context, str).booleanValue()) {
                j3 = i(context, str);
            } else {
                j3 = 0L;
            }
            matrixCursor.addRow(new Object[]{str, j3});
        } else if ("Integer".equals(str2)) {
            if (l(context, str).booleanValue()) {
                i3 = h(context, str);
            } else {
                i3 = 0;
            }
            matrixCursor.addRow(new Object[]{str, i3});
        } else if ("CT".equals(str2)) {
            if (l(context, str).booleanValue()) {
                matrixCursor.addRow(new Object[]{str, ""});
            }
        } else {
            if (l(context, str).booleanValue()) {
                str3 = e(context, str);
            } else {
                str3 = "data is null";
            }
            matrixCursor.addRow(new Object[]{str, str3});
        }
        return matrixCursor;
    }

    public static void n(Context context, String str) {
        f(context).edit().remove(str).apply();
    }

    public static void o(Context context, String str, Object obj) {
        if (obj instanceof String) {
            f(context).edit().putString(str, (String) obj).apply();
            return;
        }
        if (obj instanceof Boolean) {
            f(context).edit().putBoolean(str, ((Boolean) obj).booleanValue()).apply();
        } else if (obj instanceof Long) {
            f(context).edit().putLong(str, ((Long) obj).longValue()).apply();
        } else if (obj instanceof Integer) {
            f(context).edit().putLong(str, ((Integer) obj).intValue()).apply();
        }
    }
}
