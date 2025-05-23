package com.tencent.minibox.dynamic.api;

import android.content.ContentValues;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes9.dex */
public abstract class BaseProviderDelegate implements IProviderDelegate {
    @Override // com.tencent.minibox.dynamic.api.IProviderDelegate
    public int bulkInsert(@NotNull Uri uri, @NotNull ContentValues[] contentValuesArr) {
        return 0;
    }

    @Override // com.tencent.minibox.dynamic.api.IProviderDelegate
    @Nullable
    public Bundle call(@NotNull String str, @Nullable String str2, @Nullable Bundle bundle) {
        return null;
    }

    @Override // com.tencent.minibox.dynamic.api.IProviderDelegate
    @Nullable
    public Uri canonicalize(@NotNull Uri uri) {
        return null;
    }

    @Override // com.tencent.minibox.dynamic.api.IProviderDelegate
    public int delete(@NotNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        return 0;
    }

    @Override // com.tencent.minibox.dynamic.api.IProviderDelegate
    public void dump(@Nullable FileDescriptor fileDescriptor, @Nullable PrintWriter printWriter, @Nullable String[] strArr) {
        if (printWriter != null) {
            printWriter.println("nothing to dump");
        }
    }

    @Override // com.tencent.minibox.dynamic.api.IProviderDelegate
    @Nullable
    public String[] getStreamTypes(@NotNull Uri uri, @NotNull String str) {
        return null;
    }

    @Override // com.tencent.minibox.dynamic.api.IProviderDelegate
    @Nullable
    public String getType(@NotNull Uri uri) {
        return null;
    }

    @Override // com.tencent.minibox.dynamic.api.IProviderDelegate
    @Nullable
    public Uri insert(@NotNull Uri uri, @Nullable ContentValues contentValues) {
        return null;
    }

    @Override // com.tencent.minibox.dynamic.api.IProviderDelegate
    public boolean isTemporary() {
        return false;
    }

    @Override // com.tencent.minibox.dynamic.api.IProviderDelegate
    public boolean onCreate() {
        return true;
    }

    @Override // com.tencent.minibox.dynamic.api.IProviderDelegate
    @Nullable
    public AssetFileDescriptor openAssetFile(@NotNull Uri uri, @NotNull String str) {
        return null;
    }

    @Override // com.tencent.minibox.dynamic.api.IProviderDelegate
    @Nullable
    public ParcelFileDescriptor openFile(@NotNull Uri uri, @NotNull String str) {
        return null;
    }

    @Override // com.tencent.minibox.dynamic.api.IProviderDelegate
    @Nullable
    public AssetFileDescriptor openTypedAssetFile(@NotNull Uri uri, @NotNull String str, @Nullable Bundle bundle) {
        return null;
    }

    @Override // com.tencent.minibox.dynamic.api.IProviderDelegate
    @Nullable
    public Cursor query(@NotNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        return null;
    }

    @Override // com.tencent.minibox.dynamic.api.IProviderDelegate
    public boolean refresh(@Nullable Uri uri, @Nullable Bundle bundle, @Nullable CancellationSignal cancellationSignal) {
        return false;
    }

    @Override // com.tencent.minibox.dynamic.api.IProviderDelegate
    @Nullable
    public Uri uncanonicalize(@NotNull Uri uri) {
        return null;
    }

    @Override // com.tencent.minibox.dynamic.api.IProviderDelegate
    public int update(@NotNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        return 0;
    }

    @Override // com.tencent.minibox.dynamic.api.IProviderDelegate
    @Nullable
    public AssetFileDescriptor openAssetFile(@NotNull Uri uri, @NotNull String str, @Nullable CancellationSignal cancellationSignal) {
        return null;
    }

    @Override // com.tencent.minibox.dynamic.api.IProviderDelegate
    @Nullable
    public ParcelFileDescriptor openFile(@NotNull Uri uri, @NotNull String str, @Nullable CancellationSignal cancellationSignal) {
        return null;
    }

    @Override // com.tencent.minibox.dynamic.api.IProviderDelegate
    @Nullable
    public AssetFileDescriptor openTypedAssetFile(@NotNull Uri uri, @NotNull String str, @Nullable Bundle bundle, @Nullable CancellationSignal cancellationSignal) {
        return null;
    }

    @Override // com.tencent.minibox.dynamic.api.IProviderDelegate
    public void onCallingPackageChanged() {
    }

    @Override // com.tencent.minibox.dynamic.api.IProviderDelegate
    public void onConfigurationChanged(@NotNull Configuration configuration) {
    }

    @Override // com.tencent.minibox.dynamic.api.IProviderDelegate
    public void onLowMemory() {
    }

    @Override // com.tencent.minibox.dynamic.api.IProviderDelegate
    public void onTrimMemory(int i3) {
    }

    @Override // com.tencent.minibox.dynamic.api.IProviderDelegate
    public void shutdown() {
    }
}
