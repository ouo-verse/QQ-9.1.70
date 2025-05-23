package com.xiaomi.push.providers;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import com.tencent.bugly.library.BuglyMonitorName;
import com.tencent.open.business.base.MobileInfoUtil;
import com.xiaomi.push.fo;
import mz4.a;

/* loaded from: classes28.dex */
public class TrafficProvider extends ContentProvider {

    /* renamed from: e, reason: collision with root package name */
    public static final Uri f389472e = Uri.parse("content://com.xiaomi.push.providers.TrafficProvider/traffic");

    /* renamed from: f, reason: collision with root package name */
    private static final UriMatcher f389473f;

    /* renamed from: d, reason: collision with root package name */
    private SQLiteOpenHelper f389474d;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        f389473f = uriMatcher;
        uriMatcher.addURI("com.xiaomi.push.providers.TrafficProvider", BuglyMonitorName.TRAFFIC, 1);
        uriMatcher.addURI("com.xiaomi.push.providers.TrafficProvider", "update_imsi", 2);
    }

    @Override // android.content.ContentProvider
    public int bulkInsert(Uri uri, ContentValues[] contentValuesArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        if (f389473f.match(uri) == 1) {
            return "vnd.android.cursor.dir/vnd.xiaomi.push.traffic";
        }
        throw new IllegalArgumentException("Unknown URI " + uri);
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        this.f389474d = new a(getContext());
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Cursor query;
        synchronized (a.f417906e) {
            if (f389473f.match(uri) == 1) {
                query = this.f389474d.getReadableDatabase().query(BuglyMonitorName.TRAFFIC, strArr, str, strArr2, null, null, str2);
            } else {
                throw new IllegalArgumentException("Unknown URI " + uri);
            }
        }
        return query;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        if (f389473f.match(uri) == 2 && contentValues != null && contentValues.containsKey(MobileInfoUtil.IMSI)) {
            fo.m(contentValues.getAsString(MobileInfoUtil.IMSI));
            return 0;
        }
        return 0;
    }
}
