package com.tencent.shadow.core.runtime.container;

import android.content.ContentValues;
import android.content.res.Configuration;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;

/* loaded from: classes25.dex */
public interface HostContentProviderDelegate {
    int bulkInsert(Uri uri, ContentValues[] contentValuesArr);

    Bundle call(String str, String str2, Bundle bundle);

    int delete(Uri uri, String str, String[] strArr);

    String getType(Uri uri);

    Uri insert(Uri uri, ContentValues contentValues);

    void onConfigurationChanged(Configuration configuration);

    boolean onCreate();

    void onLowMemory();

    void onTrimMemory(int i3);

    ParcelFileDescriptor openFile(Uri uri, String str);

    ParcelFileDescriptor openFile(Uri uri, String str, CancellationSignal cancellationSignal);

    Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2);

    int update(Uri uri, ContentValues contentValues, String str, String[] strArr);
}
