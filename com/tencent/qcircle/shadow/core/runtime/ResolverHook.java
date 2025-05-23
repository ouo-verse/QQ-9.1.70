package com.tencent.qcircle.shadow.core.runtime;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;

/* compiled from: P */
/* loaded from: classes22.dex */
public class ResolverHook {
    public static int bulkInsert(ContentResolver contentResolver, Uri uri, ContentValues[] contentValuesArr) {
        return contentResolver.bulkInsert(UriConverter.parse(uri.toString()), contentValuesArr);
    }

    public static Bundle call(ContentResolver contentResolver, Uri uri, String str, String str2, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        return contentResolver.call(UriConverter.parseCall(uri.toString(), bundle), str, str2, bundle);
    }

    public static int delete(ContentResolver contentResolver, Uri uri, String str, String[] strArr) {
        return py3.b.e(contentResolver, UriConverter.parse(uri.toString()), str, strArr);
    }

    public static Uri insert(ContentResolver contentResolver, Uri uri, ContentValues contentValues) {
        return contentResolver.insert(UriConverter.parse(uri.toString()), contentValues);
    }

    @TargetApi(26)
    public static Cursor query(ContentResolver contentResolver, Uri uri, String[] strArr, Bundle bundle, CancellationSignal cancellationSignal) {
        return ContactsMonitor.query(contentResolver, UriConverter.parse(uri.toString()), strArr, bundle, cancellationSignal);
    }

    public static int update(ContentResolver contentResolver, Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return contentResolver.update(UriConverter.parse(uri.toString()), contentValues, str, strArr);
    }

    public static Cursor query(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return ContactsMonitor.query(contentResolver, UriConverter.parse(uri.toString()), strArr, str, strArr2, str2);
    }

    public static Cursor query(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
        return ContactsMonitor.query(contentResolver, UriConverter.parse(uri.toString()), strArr, str, strArr2, str2, cancellationSignal);
    }
}
