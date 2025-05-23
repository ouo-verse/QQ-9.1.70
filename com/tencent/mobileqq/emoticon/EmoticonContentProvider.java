package com.tencent.mobileqq.emoticon;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmojiManagerServiceProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppContentProvider;
import mqq.app.AppRuntime;

/* loaded from: classes12.dex */
public class EmoticonContentProvider extends AppContentProvider {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private final UriMatcher f204625d;

    public EmoticonContentProvider() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f204625d = new UriMatcher(-1);
        }
    }

    private SQLiteDatabase a(AppRuntime appRuntime, String str, boolean z16) {
        if (appRuntime != null && (appRuntime instanceof BaseQQAppInterface)) {
            BaseQQAppInterface baseQQAppInterface = (BaseQQAppInterface) appRuntime;
            if (z16) {
                return baseQQAppInterface.getReadableDatabase(str);
            }
            return baseQQAppInterface.getWritableDatabase(str);
        }
        return null;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Bundle call(@NonNull String str, @Nullable String str2, @Nullable Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Bundle) iPatchRedirector.redirect((short) 4, this, str, str2, bundle);
        }
        if (QLog.isColorLevel()) {
            QLog.i("EmoticonContentProvider", 2, "call, method = " + str + " arg = " + str2 + " extras = " + bundle);
        }
        if (str2 == null) {
            QLog.e("EmoticonContentProvider", 2, "call, uin = null");
            return null;
        }
        AppRuntime runtime = getRuntime(str2);
        if (runtime instanceof BaseQQAppInterface) {
            BaseQQAppInterface baseQQAppInterface = (BaseQQAppInterface) runtime;
            if (AppConstants.VIPKey.KEY_FOR_VIP_TYPE.equals(str)) {
                return r.a(baseQQAppInterface, str);
            }
        }
        return super.call(str, str2, bundle);
    }

    @Override // android.content.ContentProvider
    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, this, uri, str, strArr)).intValue();
        }
        return 0;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public String getType(@NonNull Uri uri) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this, (Object) uri);
        }
        return null;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Uri) iPatchRedirector.redirect((short) 6, (Object) this, (Object) uri, (Object) contentValues);
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
        this.f204625d.addURI("qq.emoticon", EmojiManagerServiceProxy.EMOTICON_PACKAGE, 1000);
        this.f204625d.addURI("qq.emoticon", "emoticon_tab", 1001);
        this.f204625d.addURI("qq.emoticon", "emoticon_fav", 1002);
        this.f204625d.addURI("qq.emoticon", "emoticon", 1003);
        return true;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Cursor) iPatchRedirector.redirect((short) 3, this, uri, strArr, str, strArr2, str2);
        }
        int match = this.f204625d.match(uri);
        String queryParameter = uri.getQueryParameter("uin");
        Cursor cursor = null;
        if (queryParameter == null) {
            QLog.e("EmoticonContentProvider", 2, "query, uin = null, uri=" + uri.getPath());
            return null;
        }
        if (QLog.isColorLevel()) {
            QLog.i("EmoticonContentProvider", 2, "query, projection = " + strArr + " selection = " + str + " selectionArgs = " + strArr2 + " sortOrder = " + str2);
        }
        SQLiteDatabase a16 = a(getRuntime(queryParameter), queryParameter, true);
        if (a16 == null) {
            QLog.e("EmoticonContentProvider", 1, "query, db null, uri=" + uri);
            return null;
        }
        switch (match) {
            case 1000:
                cursor = a16.query("EmoticonPackage", strArr, str, strArr2, str2, null);
                break;
            case 1001:
                cursor = a16.query("EmoticonTab", strArr, str, strArr2, str2, null);
                break;
            case 1002:
                cursor = a16.query("CustomEmotionData", strArr, str, strArr2, str2, null);
                break;
            case 1003:
                cursor = a16.query("Emoticon", strArr, str, strArr2, str2, null);
                break;
            default:
                if (QLog.isColorLevel()) {
                    QLog.e("EmoticonContentProvider", 2, "Uri match missing! match: " + uri);
                    break;
                }
                break;
        }
        if (cursor != null) {
            cursor.setNotificationUri(getContext().getContentResolver(), uri);
        }
        return cursor;
    }

    @Override // android.content.ContentProvider
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            return 0;
        }
        return ((Integer) iPatchRedirector.redirect((short) 8, this, uri, contentValues, str, strArr)).intValue();
    }
}
