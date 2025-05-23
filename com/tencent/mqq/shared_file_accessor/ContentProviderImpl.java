package com.tencent.mqq.shared_file_accessor;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxy;
import com.tencent.mqq.shared_file_accessor.test.AccessRecorder;
import cooperation.qzone.util.WiFiDash;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes21.dex */
public class ContentProviderImpl extends ContentProvider {
    private static final String LOG_TAG = "ContentProviderImpl";
    private static final String[] sMockColums = {"value"};

    private String getParam(Uri uri, String str) {
        try {
            return uri.getQueryParameter(str);
        } catch (NullPointerException | UnsupportedOperationException unused) {
            return null;
        }
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        String param = getParam(uri, "file");
        if ("*".equals(str)) {
            SharedPreferencesProxyManager.getInstance().getProxyInner(param, 0, false).edit().clear();
        } else {
            SharedPreferencesProxyManager.getInstance().getProxyInner(param, 0, false).edit().remove(str);
        }
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return WiFiDash.NOT_AVALIBLE;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        String param = getParam(uri, "file");
        Map.Entry<String, Object> next = contentValues.valueSet().iterator().next();
        if (next == null) {
            return null;
        }
        String key = next.getKey();
        Object value = next.getValue();
        SharedPreferences.Editor edit = SharedPreferencesProxyManager.getInstance().getProxyInner(param, 0, false).edit();
        if (value instanceof Integer) {
            edit.putInt(key, ((Integer) value).intValue());
        } else if (value instanceof Long) {
            edit.putLong(key, ((Long) value).longValue());
        } else if (value instanceof Float) {
            edit.putFloat(key, ((Float) value).floatValue());
        } else if (value instanceof Boolean) {
            edit.putBoolean(key, ((Boolean) value).booleanValue());
        } else {
            if (!(value instanceof String)) {
                return null;
            }
            edit.putString(key, (String) value);
        }
        return uri;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        LogUtil.timeLogEnd("ContentProviderImpl's init", LogUtil.timeLogBegin());
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:71:0x00f2, code lost:
    
        if (r12 == false) goto L61;
     */
    @Override // android.content.ContentProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        String str3;
        int i3;
        Object obj;
        String param = getParam(uri, "file");
        int length = strArr.length;
        int i16 = 0;
        int i17 = 0;
        while (true) {
            if (i17 < length) {
                if ("cmd".equals(strArr[i17])) {
                    str3 = strArr[i17 + 1];
                    break;
                }
                i17 = i17 + 1 + 1;
            } else {
                str3 = "0";
                break;
            }
        }
        Object obj2 = null;
        obj2 = null;
        obj2 = null;
        String str4 = null;
        obj2 = null;
        if ("5".equals(str3)) {
            ((SharedPreferencesProxy.EditorImpl) ((SharedPreferencesProxy) SharedPreferencesProxyManager.getInstance().getProxyInner(param, 0, false)).edit()).commit(false);
            return null;
        }
        if ("101".equals(str3)) {
            String str5 = null;
            String str6 = null;
            while (i16 < strArr.length) {
                if ("process".equals(strArr[i16])) {
                    i16++;
                    str5 = strArr[i16];
                } else if ("log".equals(strArr[i16])) {
                    i16++;
                    str6 = strArr[i16];
                }
                i16++;
            }
            if (!TextUtils.isEmpty(str5) && !TextUtils.isEmpty(str6)) {
                SharedPreferencesProxyManager.getInstance().onModifySp(param, str5, str6);
            }
            return null;
        }
        int length2 = strArr.length;
        int i18 = 0;
        int i19 = -1;
        String str7 = null;
        String str8 = "NO_SUCH_KEY";
        while (i18 < length2) {
            if ("key".equals(strArr[i18])) {
                i18++;
                if (i18 < length2) {
                    str8 = strArr[i18];
                }
            } else if ("value_type".equals(strArr[i18])) {
                i18++;
                if (i18 < length2) {
                    i19 = Integer.parseInt(strArr[i18]);
                }
            } else if ("default".equals(strArr[i18]) && (i18 = i18 + 1) < length2) {
                str7 = strArr[i18];
            }
            i18++;
        }
        if ("NO_SUCH_KEY".equals(str8) || i19 == -1) {
            return null;
        }
        MatrixCursor matrixCursor = new MatrixCursor(sMockColums);
        SharedPreferences proxyInner = SharedPreferencesProxyManager.getInstance().getProxyInner(param, 0, false);
        try {
            switch (i19) {
                case 0:
                    if (proxyInner.contains(str8)) {
                        obj = 0;
                        obj2 = obj;
                        break;
                    }
                    break;
                case 1:
                    obj2 = Integer.valueOf(proxyInner.getInt(str8, Integer.parseInt(str7)));
                    break;
                case 2:
                    obj2 = Long.valueOf(proxyInner.getLong(str8, Long.parseLong(str7)));
                    break;
                case 3:
                    obj2 = Float.valueOf(proxyInner.getFloat(str8, Float.parseFloat(str7)));
                    break;
                case 4:
                    if (!"null".equals(str7)) {
                        str4 = str7;
                    }
                    obj2 = proxyInner.getString(str8, str4);
                    break;
                case 5:
                    if (proxyInner.getBoolean(str8, Boolean.parseBoolean(str7))) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    obj2 = Integer.valueOf(i3);
                    break;
                case 6:
                    Set<String> stringSet = proxyInner.getStringSet(str8, null);
                    if (stringSet != null) {
                        boolean isEmpty = stringSet.isEmpty();
                        obj = stringSet;
                        break;
                    }
                    break;
            }
            if (obj2 != null) {
                if (i19 == 6) {
                    Iterator it = ((Set) obj2).iterator();
                    while (it.hasNext()) {
                        matrixCursor.addRow(new Object[]{(String) it.next()});
                    }
                } else {
                    matrixCursor.addRow(new Object[]{obj2});
                }
            }
        } catch (Exception unused) {
        }
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment == null) {
            return -1;
        }
        if (lastPathSegment.equals("log")) {
            AccessRecorder.getInstance().log(strArr);
            return 0;
        }
        return 0;
    }
}
