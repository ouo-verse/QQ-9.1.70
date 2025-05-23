package com.tencent.mqq.shared_file_accessor;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mqq.shared_file_accessor.CommonConstants;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes21.dex */
public class ContentProviderClient {
    private static final String CP_URI_BASE = "content://com.tencent.mqq.shared_file_accessor.ContentProviderImpl";
    private static final String DEFAULT_SP_NAME = "default";
    private static final String LOG_TAG = "ContentProviderClient";
    private WeakReference<Context> mContext;
    private Uri mUri;

    public ContentProviderClient(WeakReference<Context> weakReference, String str) {
        this.mUri = null;
        this.mContext = weakReference;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("content://com.tencent.mqq.shared_file_accessor.ContentProviderImpl/params?file=");
        sb5.append(str == null ? "default" : str);
        this.mUri = Uri.parse(sb5.toString());
    }

    private static ContentValues castPair(String str, Object obj) {
        ContentValues contentValues = new ContentValues(1);
        if (obj instanceof Integer) {
            contentValues.put(str, (Integer) obj);
        } else if (obj instanceof Long) {
            contentValues.put(str, (Long) obj);
        } else if (obj instanceof Float) {
            contentValues.put(str, (Float) obj);
        } else if (obj instanceof String) {
            contentValues.put(str, (String) obj);
        } else if (obj instanceof Boolean) {
            contentValues.put(str, (Boolean) obj);
        } else {
            contentValues.put(str, "");
        }
        return contentValues;
    }

    private static Object getDataFromCursor(Cursor cursor, CommonConstants.ValueType valueType) {
        if (cursor == null) {
            return null;
        }
        try {
            boolean z16 = true;
            switch (valueType.mEnumValue) {
                case 0:
                    if (cursor.getCount() == 0) {
                        z16 = false;
                    }
                    return Boolean.valueOf(z16);
                case 1:
                    return Integer.valueOf(cursor.getInt(0));
                case 2:
                    return Long.valueOf(cursor.getLong(0));
                case 3:
                    return Float.valueOf(cursor.getFloat(0));
                case 4:
                    return cursor.getString(0);
                case 5:
                    if (cursor.getInt(0) == 0) {
                        z16 = false;
                    }
                    return Boolean.valueOf(z16);
                case 6:
                    HashSet hashSet = new HashSet();
                    do {
                        String string = cursor.getString(0);
                        if (!TextUtils.isEmpty(string)) {
                            hashSet.add(string);
                        }
                    } while (cursor.moveToNext());
                    return hashSet;
                default:
                    return null;
            }
        } catch (Exception unused) {
            return null;
        }
    }

    public void clear(String str) {
        delete("*");
    }

    public void commit() {
        Context context;
        Cursor cursor;
        WeakReference<Context> weakReference = this.mContext;
        if (weakReference == null || (context = weakReference.get()) == null) {
            return;
        }
        try {
            cursor = context.getContentResolver().query(this.mUri, new String[]{"cmd", "5"}, null, null, null);
        } catch (Exception unused) {
            cursor = null;
        }
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Throwable unused2) {
            }
        }
    }

    public void delete(String str) {
        Context context;
        WeakReference<Context> weakReference = this.mContext;
        if (weakReference == null || (context = weakReference.get()) == null) {
            return;
        }
        try {
            context.getContentResolver().delete(this.mUri, str, null);
        } catch (Exception unused) {
        }
    }

    public Object read(String str, CommonConstants.ValueType valueType, Object obj) {
        Cursor cursor;
        WeakReference<Context> weakReference = this.mContext;
        if (weakReference == null) {
            return obj;
        }
        Context context = weakReference.get();
        if (context == null) {
            return obj;
        }
        try {
            cursor = context.getContentResolver().query(this.mUri, new String[]{"cmd", "0", "key", str, "value_type", Integer.toString(valueType.mEnumValue), "default", "" + obj}, null, null, null);
        } catch (Exception unused) {
            cursor = null;
        }
        if (cursor == null) {
            return obj;
        }
        try {
            try {
                if (!cursor.moveToFirst()) {
                    try {
                        cursor.close();
                    } catch (Throwable unused2) {
                    }
                    return obj;
                }
                Object dataFromCursor = getDataFromCursor(cursor, valueType);
                if (dataFromCursor != null) {
                    try {
                        cursor.close();
                    } catch (Throwable unused3) {
                    }
                    return dataFromCursor;
                }
                try {
                    cursor.close();
                } catch (Throwable unused4) {
                }
                return obj;
            } catch (Throwable unused5) {
                return obj;
            }
        } catch (Throwable unused6) {
            cursor.close();
            return obj;
        }
    }

    public Map<String, ?> readAll() {
        return null;
    }

    public void write(String str, Object obj, CommonConstants.ValueType valueType) {
        Context context;
        WeakReference<Context> weakReference = this.mContext;
        if (weakReference == null || (context = weakReference.get()) == null) {
            return;
        }
        if (obj == null) {
            delete(str);
        } else {
            try {
                context.getContentResolver().insert(this.mUri, castPair(str, obj));
            } catch (Exception unused) {
            }
        }
    }
}
