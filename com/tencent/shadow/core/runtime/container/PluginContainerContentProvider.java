package com.tencent.shadow.core.runtime.container;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.res.Configuration;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.tencent.shadow.core.runtime.container.ContentProviderDelegateProviderHolder;
import java.io.FileNotFoundException;

/* loaded from: classes25.dex */
public class PluginContainerContentProvider extends ContentProvider {
    private static final String TAG = "ContentProvider_";
    private HostContentProviderDelegate hostContentProviderDelegate;

    public PluginContainerContentProvider() {
        ContentProviderDelegateProviderHolder.setDelegateProviderHolderPrepareListener(new ContentProviderDelegateProviderHolder.DelegateProviderHolderPrepareListener() { // from class: com.tencent.shadow.core.runtime.container.PluginContainerContentProvider.1
            @Override // com.tencent.shadow.core.runtime.container.ContentProviderDelegateProviderHolder.DelegateProviderHolderPrepareListener
            public void onPrepare() {
                HostContentProviderDelegate hostContentProviderDelegate;
                ContentProviderDelegateProvider contentProviderDelegateProvider = ContentProviderDelegateProviderHolder.contentProviderDelegateProvider;
                if (contentProviderDelegateProvider != null) {
                    hostContentProviderDelegate = contentProviderDelegateProvider.getHostContentProviderDelegate();
                    hostContentProviderDelegate.onCreate();
                } else {
                    Log.e(PluginContainerContentProvider.TAG, "PluginContainerContentProvider: DelegateProviderHolder\u6ca1\u6709\u521d\u59cb\u5316");
                    hostContentProviderDelegate = null;
                }
                PluginContainerContentProvider.this.hostContentProviderDelegate = hostContentProviderDelegate;
            }
        });
    }

    private void checkHostContentProviderDelegate() {
        if (this.hostContentProviderDelegate != null) {
            return;
        }
        throw new IllegalArgumentException("hostContentProviderDelegate is null ,\u8bf7\u68c0\u67e5ContentProviderDelegateProviderHolder.setDelegateProviderHolderPrepareListener\u662f\u5426\u8c03\u7528\uff0c\u6216" + getClass().getSimpleName() + " \u662f\u5426\u548c\u63d2\u4ef6\u5728\u540c\u4e00\u8fdb\u7a0b");
    }

    @Override // android.content.ContentProvider
    public int bulkInsert(Uri uri, ContentValues[] contentValuesArr) {
        checkHostContentProviderDelegate();
        HostContentProviderDelegate hostContentProviderDelegate = this.hostContentProviderDelegate;
        if (hostContentProviderDelegate != null) {
            return hostContentProviderDelegate.bulkInsert(uri, contentValuesArr);
        }
        return 0;
    }

    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, Bundle bundle) {
        checkHostContentProviderDelegate();
        HostContentProviderDelegate hostContentProviderDelegate = this.hostContentProviderDelegate;
        if (hostContentProviderDelegate != null) {
            return hostContentProviderDelegate.call(str, str2, bundle);
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        checkHostContentProviderDelegate();
        HostContentProviderDelegate hostContentProviderDelegate = this.hostContentProviderDelegate;
        if (hostContentProviderDelegate != null) {
            return hostContentProviderDelegate.delete(uri, str, strArr);
        }
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        checkHostContentProviderDelegate();
        HostContentProviderDelegate hostContentProviderDelegate = this.hostContentProviderDelegate;
        if (hostContentProviderDelegate != null) {
            return hostContentProviderDelegate.getType(uri);
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        checkHostContentProviderDelegate();
        HostContentProviderDelegate hostContentProviderDelegate = this.hostContentProviderDelegate;
        if (hostContentProviderDelegate != null) {
            return hostContentProviderDelegate.insert(uri, contentValues);
        }
        return null;
    }

    @Override // android.content.ContentProvider, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        HostContentProviderDelegate hostContentProviderDelegate = this.hostContentProviderDelegate;
        if (hostContentProviderDelegate != null) {
            hostContentProviderDelegate.onConfigurationChanged(configuration);
        }
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return false;
    }

    @Override // android.content.ContentProvider, android.content.ComponentCallbacks
    public void onLowMemory() {
        HostContentProviderDelegate hostContentProviderDelegate = this.hostContentProviderDelegate;
        if (hostContentProviderDelegate != null) {
            hostContentProviderDelegate.onLowMemory();
        }
    }

    @Override // android.content.ContentProvider, android.content.ComponentCallbacks2
    public void onTrimMemory(int i3) {
        HostContentProviderDelegate hostContentProviderDelegate = this.hostContentProviderDelegate;
        if (hostContentProviderDelegate != null) {
            hostContentProviderDelegate.onTrimMemory(i3);
        }
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri uri, String str) throws FileNotFoundException {
        checkHostContentProviderDelegate();
        HostContentProviderDelegate hostContentProviderDelegate = this.hostContentProviderDelegate;
        if (hostContentProviderDelegate != null) {
            return hostContentProviderDelegate.openFile(uri, str);
        }
        return super.openFile(uri, str);
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        checkHostContentProviderDelegate();
        HostContentProviderDelegate hostContentProviderDelegate = this.hostContentProviderDelegate;
        if (hostContentProviderDelegate != null) {
            return hostContentProviderDelegate.query(uri, strArr, str, strArr2, str2);
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        checkHostContentProviderDelegate();
        HostContentProviderDelegate hostContentProviderDelegate = this.hostContentProviderDelegate;
        if (hostContentProviderDelegate != null) {
            return hostContentProviderDelegate.update(uri, contentValues, str, strArr);
        }
        return 0;
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri uri, String str, CancellationSignal cancellationSignal) throws FileNotFoundException {
        checkHostContentProviderDelegate();
        HostContentProviderDelegate hostContentProviderDelegate = this.hostContentProviderDelegate;
        if (hostContentProviderDelegate != null) {
            return hostContentProviderDelegate.openFile(uri, str, cancellationSignal);
        }
        return super.openFile(uri, str);
    }
}
