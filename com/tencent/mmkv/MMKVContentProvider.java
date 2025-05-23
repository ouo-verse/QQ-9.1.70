package com.tencent.mmkv;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;

/* loaded from: classes9.dex */
public class MMKVContentProvider extends ContentProvider {

    /* renamed from: d, reason: collision with root package name */
    private static Uri f154050d;

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public static Uri a(Context context) {
        String d16;
        Uri uri = f154050d;
        if (uri != null) {
            return uri;
        }
        if (context == null || (d16 = d(context)) == null) {
            return null;
        }
        Uri parse = Uri.parse("content://" + d16);
        f154050d = parse;
        return parse;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String b(Context context, int i3) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        if (activityManager != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : SystemMethodProxy.getRunningAppProcesses(activityManager)) {
                if (runningAppProcessInfo.pid == i3) {
                    return runningAppProcessInfo.processName;
                }
            }
            return "";
        }
        return "";
    }

    private Bundle c(String str, int i3, int i16, String str2) throws RuntimeException {
        MMKV Z = MMKV.Z(getContext(), str, i3, i16, str2);
        ParcelableMMKV parcelableMMKV = new ParcelableMMKV(Z);
        Log.i("MMKV", str + " fd = " + Z.ashmemFD() + ", meta fd = " + Z.ashmemMetaFD());
        Bundle bundle = new Bundle();
        bundle.putParcelable("KEY", parcelableMMKV);
        return bundle;
    }

    private static String d(Context context) {
        ProviderInfo providerInfo;
        try {
            ComponentName componentName = new ComponentName(context, MMKVContentProvider.class.getName());
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (providerInfo = packageManager.getProviderInfo(componentName, 0)) != null) {
                return providerInfo.authority;
            }
            return null;
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Bundle call(@NonNull String str, @Nullable String str2, @Nullable Bundle bundle) {
        if (str.equals("mmkvFromAshmemID") && bundle != null) {
            try {
                return c(str2, bundle.getInt("KEY_SIZE"), bundle.getInt("KEY_MODE"), bundle.getString("KEY_CRYPT"));
            } catch (Exception e16) {
                Log.e("MMKV", e16.getMessage());
            }
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        throw new UnsupportedOperationException("Not implement in MMKV");
    }

    @Override // android.content.ContentProvider
    @Nullable
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        throw new UnsupportedOperationException("Not implement in MMKV");
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        if (getContext() == null) {
            return false;
        }
        return true;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        throw new UnsupportedOperationException("Not implement in MMKV");
    }

    @Override // android.content.ContentProvider
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        throw new UnsupportedOperationException("Not implement in MMKV");
    }
}
