package com.tencent.mobileqq.content;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.persistence.TableBuilder;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vas.VasKeyValue;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.AppContentProvider;
import mqq.app.AppRuntime;

/* loaded from: classes10.dex */
public class FriendListProvider extends AppContentProvider {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private final UriMatcher f203003d;

    public FriendListProvider() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f203003d = new UriMatcher(-1);
        }
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, this, uri, str, strArr)).intValue();
        }
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this, (Object) uri);
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Uri) iPatchRedirector.redirect((short) 5, (Object) this, (Object) uri, (Object) contentValues);
        }
        return null;
    }

    @Override // mqq.app.AppContentProvider, android.content.ContentProvider
    public boolean onCreate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        super.onCreate();
        this.f203003d.addURI("qq.friendlist", "group/#", 1000);
        this.f203003d.addURI("qq.friendlist", "friendlist/#", 1001);
        this.f203003d.addURI("qq.friendlist", "trooplist/#", 1002);
        this.f203003d.addURI("qq.friendlist", "troopmemberinfo/#/#/#", 1003);
        this.f203003d.addURI("qq.friendlist", "troopname/#/#", 1004);
        this.f203003d.addURI("qq.friendlist", "discussinfo/#/#", 1005);
        this.f203003d.addURI("qq.friendlist", "discussmenberinfo/#/#/#", 1006);
        this.f203003d.addURI("qq.friendlist", "individuationUserData/#", 1007);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x014f  */
    @Override // android.content.ContentProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        String str3;
        MatrixCursor matrixCursor;
        Cursor cursor;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Cursor) iPatchRedirector.redirect((short) 3, this, uri, strArr, str, strArr2, str2);
        }
        int match = this.f203003d.match(uri);
        String str4 = uri.getPathSegments().get(1);
        SQLiteDatabase a16 = new a().a(getRuntime(str4), str4, true);
        Cursor cursor2 = null;
        if (a16 == null) {
            QLog.e("FriendListProvider", 1, "query, db null, uri=" + uri);
            return null;
        }
        switch (match) {
            case 1000:
                cursor2 = a16.query(new Groups().getTableName(), new String[]{"group_name", "group_online_friend_count", "group_friend_count", "group_id", "seqid"}, str, strArr2, str2, null);
                break;
            case 1001:
                cursor2 = a16.query(new Friends().getTableName(), strArr, str, strArr2, str2, null);
                break;
            case 1002:
                QLog.e("FriendListProvider", 2, "query troop info unsupport");
                break;
            case 1003:
                QLog.e("FriendListProvider", 2, "query troop member info unsupport");
                break;
            case 1004:
                QLog.e("FriendListProvider", 2, "query troop name info unsupport");
                break;
            case 1005:
                List<String> pathSegments = uri.getPathSegments();
                if (pathSegments.size() >= 3) {
                    cursor2 = a16.query(new DiscussionInfo().getTableName(), null, "uin=?", new String[]{pathSegments.get(2)}, null, null);
                    break;
                }
                break;
            case 1006:
                List<String> pathSegments2 = uri.getPathSegments();
                if (pathSegments2.size() >= 4) {
                    if ("0".equals(pathSegments2.get(3))) {
                        cursor2 = a16.query(new DiscussionMemberInfo().getTableName(), null, "discussionUin=?", new String[]{pathSegments2.get(2)}, null, null);
                        break;
                    } else {
                        cursor2 = a16.query(new DiscussionMemberInfo().getTableName(), null, "discussionUin=? AND memberUin=?", new String[]{pathSegments2.get(2), pathSegments2.get(3)}, null, null);
                        break;
                    }
                }
                break;
            case 1007:
                long uptimeMillis = SystemClock.uptimeMillis();
                try {
                    try {
                        str3 = "FriendListProvider";
                        try {
                            Cursor query = a16.query(VasKeyValue.class.getSimpleName(), null, str, strArr2, "_id desc", "1");
                            try {
                                try {
                                    if (QLog.isColorLevel()) {
                                        QLog.d(str3, 2, "query, individuationUserData, rawCursor=" + query);
                                    }
                                    if (query != null && query.moveToFirst()) {
                                        matrixCursor = new MatrixCursor(new String[]{"key", "value"});
                                        String string = query.getString(query.getColumnIndex("key"));
                                        String string2 = query.getString(query.getColumnIndex("value"));
                                        matrixCursor.addRow(new Object[]{string, string2});
                                        try {
                                            if (QLog.isColorLevel()) {
                                                QLog.d(str3, 2, "query, table VasKeyValue, count=" + query.getCount() + ", key=" + string + ", value=" + string2);
                                            }
                                            cursor2 = matrixCursor;
                                        } catch (Exception e16) {
                                            e = e16;
                                            cursor2 = query;
                                            QLog.e(str3, 1, "query, table VasKeyValue, exception=", e);
                                            if (cursor2 != null) {
                                            }
                                            cursor2 = matrixCursor;
                                            if (QLog.isColorLevel()) {
                                            }
                                            cursor = cursor2;
                                            if (cursor != null) {
                                            }
                                            return cursor;
                                        }
                                    }
                                    if (query != null) {
                                        query.close();
                                    }
                                } catch (Throwable th5) {
                                    th = th5;
                                    cursor2 = query;
                                    if (cursor2 != null) {
                                        cursor2.close();
                                    }
                                    throw th;
                                }
                            } catch (Exception e17) {
                                e = e17;
                                matrixCursor = null;
                            }
                        } catch (Exception e18) {
                            e = e18;
                            matrixCursor = null;
                            QLog.e(str3, 1, "query, table VasKeyValue, exception=", e);
                            if (cursor2 != null) {
                                cursor2.close();
                            }
                            cursor2 = matrixCursor;
                            if (QLog.isColorLevel()) {
                            }
                            cursor = cursor2;
                            if (cursor != null) {
                            }
                            return cursor;
                        }
                    } catch (Exception e19) {
                        e = e19;
                        str3 = "FriendListProvider";
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(str3, 2, "query, table VasKeyValue, duration=" + (SystemClock.uptimeMillis() - uptimeMillis));
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
                break;
            default:
                if (QLog.isColorLevel()) {
                    QLog.e("FriendListProvider", 2, "Uri match missing! match: " + uri);
                    break;
                }
                break;
        }
        cursor = cursor2;
        if (cursor != null) {
            cursor.setNotificationUri(getContext().getContentResolver(), uri);
        }
        return cursor;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, this, uri, contentValues, str, strArr)).intValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d("FriendListProvider", 2, "update, uri=" + uri + ", values=" + contentValues);
        }
        if (uri == null) {
            QLog.e("FriendListProvider", 1, "update, uri null");
            return 0;
        }
        String str2 = uri.getPathSegments().get(1);
        if (TextUtils.isEmpty(str2)) {
            QLog.e("FriendListProvider", 1, "update, uin null");
            return 0;
        }
        AppRuntime runtime = getRuntime(str2);
        if (runtime == null) {
            QLog.e("FriendListProvider", 1, "update, runtime null");
            return 0;
        }
        SQLiteDatabase a16 = new a().a(runtime, str2, false);
        if (a16 == null) {
            QLog.e("FriendListProvider", 1, "update, db null");
            return 0;
        }
        if (this.f203003d.match(uri) != 1007) {
            return 0;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        String simpleName = VasKeyValue.class.getSimpleName();
        if (!a16.containsTable(simpleName)) {
            boolean execSQL = a16.execSQL(TableBuilder.createSQLStatement(new VasKeyValue()));
            if (QLog.isColorLevel()) {
                QLog.d("FriendListProvider", 2, "update, table VasKeyValue, isCreated=" + execSQL);
            }
            if (!execSQL) {
                QLog.d("FriendListProvider", 1, "update, create table VasKeyValue failure");
                return 0;
            }
        }
        String asString = contentValues.getAsString("key");
        String asString2 = contentValues.getAsString("value");
        if (QLog.isColorLevel()) {
            QLog.d("FriendListProvider", 2, "update, table VasKeyValue, newKey=" + asString + ", newValue=" + asString2);
        }
        if (TextUtils.isEmpty(asString)) {
            QLog.d("FriendListProvider", 1, "update, table VasKeyValue, key null");
            return 0;
        }
        Cursor cursor = null;
        try {
            try {
            } catch (Exception e16) {
                e = e16;
            } catch (Throwable th5) {
                th = th5;
            }
            try {
                cursor = a16.query(simpleName, null, "key=?", new String[]{asString}, null, null);
                if (cursor != null) {
                    try {
                        if (cursor.getCount() > 0 && cursor.moveToFirst()) {
                            String string = cursor.getString(cursor.getColumnIndex("key"));
                            String string2 = cursor.getString(cursor.getColumnIndex("value"));
                            if (QLog.isColorLevel()) {
                                QLog.d("FriendListProvider", 2, "update, table VasKeyValue, oldKey=" + string + ", oldValue=" + string2 + ", count=" + cursor.getCount());
                            }
                            int update = a16.update(simpleName, contentValues, "key=?", new String[]{asString});
                            if (QLog.isColorLevel()) {
                                QLog.d("FriendListProvider", 2, "update, table VasKeyValue, result=" + update + ", duration=" + (SystemClock.uptimeMillis() - uptimeMillis));
                            }
                            cursor.close();
                            return update;
                        }
                    } catch (Exception e17) {
                        e = e17;
                        QLog.e("FriendListProvider", 1, "update, table VasKeyValue, exception=", e);
                        if (cursor != null) {
                            cursor.close();
                        }
                        return 0;
                    }
                }
                long insert = a16.insert(simpleName, null, contentValues);
                if (QLog.isColorLevel()) {
                    QLog.d("FriendListProvider", 2, "insert, table VasKeyValue, result=" + insert + ", duration=" + (SystemClock.uptimeMillis() - uptimeMillis));
                }
                if (insert != -1) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                if (cursor != null) {
                    cursor.close();
                }
                return i3;
            } catch (Exception e18) {
                e = e18;
                cursor = null;
            } catch (Throwable th6) {
                th = th6;
                cursor = null;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (Throwable th7) {
            th = th7;
        }
    }
}
