package com.tencent.minibox.loader.base;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.minibox.common.log.LogUtils;
import com.tencent.minibox.dynamic.api.IProviderDelegate;
import com.tencent.minibox.loader.core.a;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p51.b;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J%\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u000e\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\rH\u0016\u00a2\u0006\u0002\u0010\u000fJ&\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0016\u001a\u00020\u000bH\u0016J1\u0010\u0017\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00042\u0010\u0010\u0019\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0004\u0018\u00010\rH\u0016\u00a2\u0006\u0002\u0010\u001aJ3\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0010\u0010!\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0004\u0018\u00010\rH\u0016\u00a2\u0006\u0002\u0010\"J\n\u0010#\u001a\u0004\u0018\u00010\u0004H\u0002J\n\u0010$\u001a\u0004\u0018\u00010\u0007H\u0002J%\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020\u0004H\u0016\u00a2\u0006\u0002\u0010'J\u0012\u0010(\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001c\u0010)\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000eH\u0016J\r\u0010*\u001a\u00020+H\u0000\u00a2\u0006\u0002\b,J\b\u0010-\u001a\u00020+H\u0014J\b\u0010.\u001a\u00020\u001cH\u0016J\u0010\u0010/\u001a\u00020\u001c2\u0006\u00100\u001a\u000201H\u0016J\b\u00102\u001a\u00020+H\u0016J\b\u00103\u001a\u00020\u001cH\u0016J\u0010\u00104\u001a\u00020\u001c2\u0006\u00105\u001a\u00020\tH\u0016J\u001a\u00106\u001a\u0004\u0018\u0001072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u00108\u001a\u00020\u0004H\u0016J$\u00106\u001a\u0004\u0018\u0001072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u00108\u001a\u00020\u00042\b\u00109\u001a\u0004\u0018\u00010:H\u0016J\u001a\u0010;\u001a\u0004\u0018\u00010<2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u00108\u001a\u00020\u0004H\u0016J$\u0010;\u001a\u0004\u0018\u00010<2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u00108\u001a\u00020\u00042\b\u00109\u001a\u0004\u0018\u00010:H\u0016J$\u0010=\u001a\u0004\u0018\u0001072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020\u00042\b\u0010>\u001a\u0004\u0018\u00010\u0011H\u0016J.\u0010=\u001a\u0004\u0018\u0001072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020\u00042\b\u0010>\u001a\u0004\u0018\u00010\u00112\b\u00109\u001a\u0004\u0018\u00010:H\u0016JO\u0010?\u001a\u0004\u0018\u00010@2\u0006\u0010\n\u001a\u00020\u000b2\u0010\u0010A\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0004\u0018\u00010\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00042\u0010\u0010\u0019\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0004\u0018\u00010\r2\b\u0010B\u001a\u0004\u0018\u00010\u0004H\u0016\u00a2\u0006\u0002\u0010CJ&\u0010D\u001a\u00020+2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00112\b\u0010E\u001a\u0004\u0018\u00010:H\u0016J\b\u0010F\u001a\u00020\u001cH\u0016J\u0012\u0010G\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0016\u001a\u00020\u000bH\u0016J;\u0010H\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00042\u0010\u0010\u0019\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0004\u0018\u00010\rH\u0016\u00a2\u0006\u0002\u0010IR\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006J"}, d2 = {"Lcom/tencent/minibox/loader/base/DelegatorProvider;", "Landroid/content/ContentProvider;", "()V", "TAG", "", "kotlin.jvm.PlatformType", "mProviderImpl", "Lcom/tencent/minibox/dynamic/api/IProviderDelegate;", "bulkInsert", "", LayoutAttrDefine.CLICK_URI, "Landroid/net/Uri;", "values", "", "Landroid/content/ContentValues;", "(Landroid/net/Uri;[Landroid/content/ContentValues;)I", "call", "Landroid/os/Bundle;", "method", "arg", "extras", "canonicalize", "url", "delete", "selection", "selectionArgs", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", "dump", "", IjkMediaPlayer.OnNativeInvokeListener.ARG_FD, "Ljava/io/FileDescriptor;", "writer", "Ljava/io/PrintWriter;", "args", "(Ljava/io/FileDescriptor;Ljava/io/PrintWriter;[Ljava/lang/String;)V", "getCallingPackageName", "getProviderImpl", "getStreamTypes", "mimeTypeFilter", "(Landroid/net/Uri;Ljava/lang/String;)[Ljava/lang/String;", "getType", "insert", "isCallingPackageValid", "", "isCallingPackageValid$MiniBoxLoader_release", "isTemporary", "onCallingPackageChanged", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "onLowMemory", "onTrimMemory", "level", "openAssetFile", "Landroid/content/res/AssetFileDescriptor;", "mode", "signal", "Landroid/os/CancellationSignal;", "openFile", "Landroid/os/ParcelFileDescriptor;", "openTypedAssetFile", "opts", "query", "Landroid/database/Cursor;", "projection", "sortOrder", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "refresh", "cancellationSignal", "shutdown", "uncanonicalize", "update", "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "MiniBoxLoader_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes9.dex */
public abstract class DelegatorProvider extends ContentProvider {
    private final String TAG = getClass().getSimpleName();
    private IProviderDelegate mProviderImpl;

    private final String getCallingPackageName() {
        boolean z16;
        String[] strArr;
        boolean z17;
        PackageManager packageManager;
        String callingPackage = getCallingPackage();
        if (callingPackage != null && callingPackage.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            return callingPackage;
        }
        Context context = getContext();
        if (context != null && (packageManager = context.getPackageManager()) != null) {
            strArr = packageManager.getPackagesForUid(Binder.getCallingUid());
        } else {
            strArr = null;
        }
        if (strArr != null) {
            if (strArr.length == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (true ^ z17) {
                return strArr[0];
            }
        }
        return null;
    }

    private final IProviderDelegate getProviderImpl() {
        if (!isCallingPackageValid$MiniBoxLoader_release()) {
            return null;
        }
        IProviderDelegate iProviderDelegate = this.mProviderImpl;
        if (iProviderDelegate != null) {
            return iProviderDelegate;
        }
        a aVar = a.f151655b;
        if (!aVar.b()) {
            String TAG = this.TAG;
            Intrinsics.checkExpressionValueIsNotNull(TAG, "TAG");
            LogUtils.d(TAG, "getProviderImpl: dynamic not ready");
            return null;
        }
        IProviderDelegate providerImpl = aVar.a().getProviderImpl(this);
        this.mProviderImpl = providerImpl;
        return providerImpl;
    }

    @Override // android.content.ContentProvider
    public int bulkInsert(@NotNull Uri uri, @NotNull ContentValues[] values) {
        Intrinsics.checkParameterIsNotNull(uri, "uri");
        Intrinsics.checkParameterIsNotNull(values, "values");
        IProviderDelegate providerImpl = getProviderImpl();
        if (providerImpl != null) {
            return providerImpl.bulkInsert(uri, values);
        }
        return 0;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Bundle call(@NotNull String method, @Nullable String arg, @Nullable Bundle extras) {
        Intrinsics.checkParameterIsNotNull(method, "method");
        String TAG = this.TAG;
        Intrinsics.checkExpressionValueIsNotNull(TAG, "TAG");
        LogUtils.d(TAG, "call: method = " + method);
        IProviderDelegate providerImpl = getProviderImpl();
        if (providerImpl != null) {
            return providerImpl.call(method, arg, extras);
        }
        return null;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Uri canonicalize(@NotNull Uri url) {
        Intrinsics.checkParameterIsNotNull(url, "url");
        IProviderDelegate providerImpl = getProviderImpl();
        if (providerImpl != null) {
            return providerImpl.canonicalize(url);
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public int delete(@NotNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        Intrinsics.checkParameterIsNotNull(uri, "uri");
        String TAG = this.TAG;
        Intrinsics.checkExpressionValueIsNotNull(TAG, "TAG");
        LogUtils.d(TAG, "delete");
        IProviderDelegate providerImpl = getProviderImpl();
        if (providerImpl != null) {
            return providerImpl.delete(uri, selection, selectionArgs);
        }
        return 0;
    }

    @Override // android.content.ContentProvider
    public void dump(@Nullable FileDescriptor fd5, @Nullable PrintWriter writer, @Nullable String[] args) {
        IProviderDelegate providerImpl = getProviderImpl();
        if (providerImpl != null) {
            providerImpl.dump(fd5, writer, args);
        }
    }

    @Override // android.content.ContentProvider
    @Nullable
    public String[] getStreamTypes(@NotNull Uri uri, @NotNull String mimeTypeFilter) {
        Intrinsics.checkParameterIsNotNull(uri, "uri");
        Intrinsics.checkParameterIsNotNull(mimeTypeFilter, "mimeTypeFilter");
        IProviderDelegate providerImpl = getProviderImpl();
        if (providerImpl != null) {
            return providerImpl.getStreamTypes(uri, mimeTypeFilter);
        }
        return null;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public String getType(@NotNull Uri uri) {
        Intrinsics.checkParameterIsNotNull(uri, "uri");
        String TAG = this.TAG;
        Intrinsics.checkExpressionValueIsNotNull(TAG, "TAG");
        LogUtils.d(TAG, "getType");
        IProviderDelegate providerImpl = getProviderImpl();
        if (providerImpl != null) {
            return providerImpl.getType(uri);
        }
        return null;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Uri insert(@NotNull Uri uri, @Nullable ContentValues values) {
        Intrinsics.checkParameterIsNotNull(uri, "uri");
        String TAG = this.TAG;
        Intrinsics.checkExpressionValueIsNotNull(TAG, "TAG");
        LogUtils.d(TAG, "insert");
        IProviderDelegate providerImpl = getProviderImpl();
        if (providerImpl != null) {
            return providerImpl.insert(uri, values);
        }
        return null;
    }

    public final boolean isCallingPackageValid$MiniBoxLoader_release() {
        try {
            String callingPackageName = getCallingPackageName();
            if (!b.f425345a.a(callingPackageName)) {
                String TAG = this.TAG;
                Intrinsics.checkExpressionValueIsNotNull(TAG, "TAG");
                LogUtils.e(TAG, "isCallingPackageValid: caller(" + callingPackageName + ") is not supported");
                return false;
            }
            return true;
        } catch (Exception e16) {
            String TAG2 = this.TAG;
            Intrinsics.checkExpressionValueIsNotNull(TAG2, "TAG");
            LogUtils.d(TAG2, "isCallingPackageValid: getCalling package failed: " + e16.getMessage());
            return false;
        }
    }

    @Override // android.content.ContentProvider
    protected boolean isTemporary() {
        IProviderDelegate providerImpl = getProviderImpl();
        if (providerImpl != null) {
            return providerImpl.isTemporary();
        }
        return false;
    }

    @Override // android.content.ContentProvider
    public void onCallingPackageChanged() {
        IProviderDelegate providerImpl = getProviderImpl();
        if (providerImpl != null) {
            providerImpl.onCallingPackageChanged();
        }
    }

    @Override // android.content.ContentProvider, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkParameterIsNotNull(newConfig, "newConfig");
        IProviderDelegate providerImpl = getProviderImpl();
        if (providerImpl != null) {
            providerImpl.onConfigurationChanged(newConfig);
        }
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        String TAG = this.TAG;
        Intrinsics.checkExpressionValueIsNotNull(TAG, "TAG");
        LogUtils.d(TAG, "onCreate");
        IProviderDelegate providerImpl = getProviderImpl();
        if (providerImpl != null) {
            return providerImpl.onCreate();
        }
        return true;
    }

    @Override // android.content.ContentProvider, android.content.ComponentCallbacks
    public void onLowMemory() {
        IProviderDelegate providerImpl = getProviderImpl();
        if (providerImpl != null) {
            providerImpl.onLowMemory();
        }
    }

    @Override // android.content.ContentProvider, android.content.ComponentCallbacks2
    public void onTrimMemory(int level) {
        IProviderDelegate providerImpl = getProviderImpl();
        if (providerImpl != null) {
            providerImpl.onTrimMemory(level);
        }
    }

    @Override // android.content.ContentProvider
    @Nullable
    public AssetFileDescriptor openAssetFile(@NotNull Uri uri, @NotNull String mode) {
        Intrinsics.checkParameterIsNotNull(uri, "uri");
        Intrinsics.checkParameterIsNotNull(mode, "mode");
        IProviderDelegate providerImpl = getProviderImpl();
        if (providerImpl != null) {
            return providerImpl.openAssetFile(uri, mode);
        }
        return null;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public ParcelFileDescriptor openFile(@NotNull Uri uri, @NotNull String mode) {
        Intrinsics.checkParameterIsNotNull(uri, "uri");
        Intrinsics.checkParameterIsNotNull(mode, "mode");
        IProviderDelegate providerImpl = getProviderImpl();
        if (providerImpl != null) {
            return providerImpl.openFile(uri, mode);
        }
        return null;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public AssetFileDescriptor openTypedAssetFile(@NotNull Uri uri, @NotNull String mimeTypeFilter, @Nullable Bundle opts) {
        Intrinsics.checkParameterIsNotNull(uri, "uri");
        Intrinsics.checkParameterIsNotNull(mimeTypeFilter, "mimeTypeFilter");
        IProviderDelegate providerImpl = getProviderImpl();
        if (providerImpl != null) {
            return providerImpl.openTypedAssetFile(uri, mimeTypeFilter, opts);
        }
        return null;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Cursor query(@NotNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        Intrinsics.checkParameterIsNotNull(uri, "uri");
        IProviderDelegate providerImpl = getProviderImpl();
        if (providerImpl != null) {
            return providerImpl.query(uri, projection, selection, selectionArgs, sortOrder);
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean refresh(@Nullable Uri uri, @Nullable Bundle extras, @Nullable CancellationSignal cancellationSignal) {
        IProviderDelegate providerImpl = getProviderImpl();
        if (providerImpl != null) {
            return providerImpl.refresh(uri, extras, cancellationSignal);
        }
        return false;
    }

    @Override // android.content.ContentProvider
    public void shutdown() {
        IProviderDelegate providerImpl = getProviderImpl();
        if (providerImpl != null) {
            providerImpl.shutdown();
        }
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Uri uncanonicalize(@NotNull Uri url) {
        Intrinsics.checkParameterIsNotNull(url, "url");
        IProviderDelegate providerImpl = getProviderImpl();
        if (providerImpl != null) {
            return providerImpl.uncanonicalize(url);
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(@NotNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        Intrinsics.checkParameterIsNotNull(uri, "uri");
        String TAG = this.TAG;
        Intrinsics.checkExpressionValueIsNotNull(TAG, "TAG");
        LogUtils.d(TAG, "delete");
        IProviderDelegate providerImpl = getProviderImpl();
        if (providerImpl != null) {
            return providerImpl.update(uri, values, selection, selectionArgs);
        }
        return 0;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public AssetFileDescriptor openAssetFile(@NotNull Uri uri, @NotNull String mode, @Nullable CancellationSignal signal) {
        Intrinsics.checkParameterIsNotNull(uri, "uri");
        Intrinsics.checkParameterIsNotNull(mode, "mode");
        IProviderDelegate providerImpl = getProviderImpl();
        if (providerImpl != null) {
            return providerImpl.openAssetFile(uri, mode, signal);
        }
        return null;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public ParcelFileDescriptor openFile(@NotNull Uri uri, @NotNull String mode, @Nullable CancellationSignal signal) {
        Intrinsics.checkParameterIsNotNull(uri, "uri");
        Intrinsics.checkParameterIsNotNull(mode, "mode");
        IProviderDelegate providerImpl = getProviderImpl();
        if (providerImpl != null) {
            return providerImpl.openFile(uri, mode, signal);
        }
        return null;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public AssetFileDescriptor openTypedAssetFile(@NotNull Uri uri, @NotNull String mimeTypeFilter, @Nullable Bundle opts, @Nullable CancellationSignal signal) {
        Intrinsics.checkParameterIsNotNull(uri, "uri");
        Intrinsics.checkParameterIsNotNull(mimeTypeFilter, "mimeTypeFilter");
        IProviderDelegate providerImpl = getProviderImpl();
        if (providerImpl != null) {
            return providerImpl.openTypedAssetFile(uri, mimeTypeFilter, opts, signal);
        }
        return null;
    }
}
