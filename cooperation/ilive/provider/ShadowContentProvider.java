package cooperation.ilive.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.res.Configuration;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import com.tencent.shadow.core.runtime.container.PluginContainerContentProvider;
import java.io.FileNotFoundException;

/* loaded from: classes28.dex */
public class ShadowContentProvider extends ContentProvider {

    /* renamed from: d, reason: collision with root package name */
    Object f390139d;

    /* renamed from: e, reason: collision with root package name */
    Class<?> f390140e;

    public ShadowContentProvider() {
        try {
            this.f390140e = PluginContainerContentProvider.class;
            this.f390139d = PluginContainerContentProvider.class.newInstance();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    @Override // android.content.ContentProvider
    public int bulkInsert(Uri uri, ContentValues[] contentValuesArr) {
        Integer num = 0;
        try {
            num = (Integer) this.f390140e.getMethod("bulkInsert", Uri.class, ContentValues[].class).invoke(this.f390139d, uri, contentValuesArr);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return num.intValue();
    }

    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, Bundle bundle) {
        try {
            return (Bundle) this.f390140e.getMethod("call", String.class, String.class, Bundle.class).invoke(this.f390139d, str, str2, bundle);
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        Integer num = 0;
        try {
            num = (Integer) this.f390140e.getMethod("delete", Uri.class, String.class, String[].class).invoke(this.f390139d, uri, str, strArr);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return num.intValue();
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        try {
            return (String) this.f390140e.getMethod("getType", Uri.class).invoke(this.f390139d, uri);
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        try {
            return (Uri) this.f390140e.getMethod("insert", Uri.class, ContentValues.class).invoke(this.f390139d, uri, contentValues);
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    @Override // android.content.ContentProvider, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        try {
            this.f390140e.getMethod("onConfigurationChanged", Configuration.class).invoke(this.f390139d, configuration);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return false;
    }

    @Override // android.content.ContentProvider, android.content.ComponentCallbacks
    public void onLowMemory() {
        try {
            this.f390140e.getMethod("onLowMemory", new Class[0]).invoke(this.f390139d, new Object[0]);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    @Override // android.content.ContentProvider, android.content.ComponentCallbacks2
    public void onTrimMemory(int i3) {
        try {
            this.f390140e.getMethod("onTrimMemory", Integer.TYPE).invoke(this.f390139d, Integer.valueOf(i3));
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri uri, String str) throws FileNotFoundException {
        try {
            return (ParcelFileDescriptor) this.f390140e.getMethod("openFile", Uri.class, String.class).invoke(this.f390139d, uri, str);
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        try {
            return (Cursor) this.f390140e.getMethod("query", Uri.class, String[].class, String.class, String[].class, String.class).invoke(this.f390139d, uri, strArr, str, strArr2, str2);
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        Integer num = 0;
        try {
            num = (Integer) this.f390140e.getMethod("update", Uri.class, ContentValues.class, String.class, String[].class).invoke(this.f390139d, uri, contentValues, str, strArr);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return num.intValue();
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri uri, String str, CancellationSignal cancellationSignal) throws FileNotFoundException {
        try {
            return (ParcelFileDescriptor) this.f390140e.getMethod("openFile", Uri.class, String.class, CancellationSignal.class).invoke(this.f390139d, uri, str, cancellationSignal);
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }
}
