package com.tencent.minibox.dynamic.api;

import android.content.ContentValues;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import androidx.annotation.Keep;
import com.tencent.ditto.shell.LayoutAttrDefine;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\bg\u0018\u00002\u00020\u0001J%\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007H&\u00a2\u0006\u0002\u0010\tJ&\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000bH&J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0011\u001a\u00020\u0005H&J1\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\r2\u0010\u0010\u0014\u001a\f\u0012\u0006\b\u0001\u0012\u00020\r\u0018\u00010\u0007H&\u00a2\u0006\u0002\u0010\u0015J3\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0010\u0010\u001c\u001a\f\u0012\u0006\b\u0001\u0012\u00020\r\u0018\u00010\u0007H&\u00a2\u0006\u0002\u0010\u001dJ%\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\rH&\u00a2\u0006\u0002\u0010 J\u0012\u0010!\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001c\u0010\"\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\bH&J\b\u0010#\u001a\u00020$H&J\b\u0010%\u001a\u00020\u0017H&J\u0010\u0010&\u001a\u00020\u00172\u0006\u0010'\u001a\u00020(H&J\b\u0010)\u001a\u00020$H&J\b\u0010*\u001a\u00020\u0017H&J\u0010\u0010+\u001a\u00020\u00172\u0006\u0010,\u001a\u00020\u0003H&J\u001a\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\rH&J$\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\r2\b\u00100\u001a\u0004\u0018\u000101H&J\u001a\u00102\u001a\u0004\u0018\u0001032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\rH&J$\u00102\u001a\u0004\u0018\u0001032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\r2\b\u00100\u001a\u0004\u0018\u000101H&J$\u00104\u001a\u0004\u0018\u00010.2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\r2\b\u00105\u001a\u0004\u0018\u00010\u000bH&J.\u00104\u001a\u0004\u0018\u00010.2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\r2\b\u00105\u001a\u0004\u0018\u00010\u000b2\b\u00100\u001a\u0004\u0018\u000101H&JO\u00106\u001a\u0004\u0018\u0001072\u0006\u0010\u0004\u001a\u00020\u00052\u0010\u00108\u001a\f\u0012\u0006\b\u0001\u0012\u00020\r\u0018\u00010\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\r2\u0010\u0010\u0014\u001a\f\u0012\u0006\b\u0001\u0012\u00020\r\u0018\u00010\u00072\b\u00109\u001a\u0004\u0018\u00010\rH&\u00a2\u0006\u0002\u0010:J&\u0010;\u001a\u00020$2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\b\u0010<\u001a\u0004\u0018\u000101H&J\b\u0010=\u001a\u00020\u0017H&J\u0012\u0010>\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0011\u001a\u00020\u0005H&J;\u0010?\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\r2\u0010\u0010\u0014\u001a\f\u0012\u0006\b\u0001\u0012\u00020\r\u0018\u00010\u0007H&\u00a2\u0006\u0002\u0010@\u00a8\u0006A"}, d2 = {"Lcom/tencent/minibox/dynamic/api/IProviderDelegate;", "", "bulkInsert", "", LayoutAttrDefine.CLICK_URI, "Landroid/net/Uri;", "values", "", "Landroid/content/ContentValues;", "(Landroid/net/Uri;[Landroid/content/ContentValues;)I", "call", "Landroid/os/Bundle;", "method", "", "arg", "extras", "canonicalize", "url", "delete", "selection", "selectionArgs", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", "dump", "", IjkMediaPlayer.OnNativeInvokeListener.ARG_FD, "Ljava/io/FileDescriptor;", "writer", "Ljava/io/PrintWriter;", "args", "(Ljava/io/FileDescriptor;Ljava/io/PrintWriter;[Ljava/lang/String;)V", "getStreamTypes", "mimeTypeFilter", "(Landroid/net/Uri;Ljava/lang/String;)[Ljava/lang/String;", "getType", "insert", "isTemporary", "", "onCallingPackageChanged", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "onLowMemory", "onTrimMemory", "level", "openAssetFile", "Landroid/content/res/AssetFileDescriptor;", "mode", "signal", "Landroid/os/CancellationSignal;", "openFile", "Landroid/os/ParcelFileDescriptor;", "openTypedAssetFile", "opts", "query", "Landroid/database/Cursor;", "projection", "sortOrder", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "refresh", "cancellationSignal", "shutdown", "uncanonicalize", "update", "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "MiniBoxDynamicApi_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes9.dex */
public interface IProviderDelegate {
    int bulkInsert(@NotNull Uri uri, @NotNull ContentValues[] values);

    @Nullable
    Bundle call(@NotNull String method, @Nullable String arg, @Nullable Bundle extras);

    @Nullable
    Uri canonicalize(@NotNull Uri url);

    int delete(@NotNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs);

    void dump(@Nullable FileDescriptor fd5, @Nullable PrintWriter writer, @Nullable String[] args);

    @Nullable
    String[] getStreamTypes(@NotNull Uri uri, @NotNull String mimeTypeFilter);

    @Nullable
    String getType(@NotNull Uri uri);

    @Nullable
    Uri insert(@NotNull Uri uri, @Nullable ContentValues values);

    boolean isTemporary();

    void onCallingPackageChanged();

    void onConfigurationChanged(@NotNull Configuration newConfig);

    boolean onCreate();

    void onLowMemory();

    void onTrimMemory(int level);

    @Nullable
    AssetFileDescriptor openAssetFile(@NotNull Uri uri, @NotNull String mode);

    @Nullable
    AssetFileDescriptor openAssetFile(@NotNull Uri uri, @NotNull String mode, @Nullable CancellationSignal signal);

    @Nullable
    ParcelFileDescriptor openFile(@NotNull Uri uri, @NotNull String mode);

    @Nullable
    ParcelFileDescriptor openFile(@NotNull Uri uri, @NotNull String mode, @Nullable CancellationSignal signal);

    @Nullable
    AssetFileDescriptor openTypedAssetFile(@NotNull Uri uri, @NotNull String mimeTypeFilter, @Nullable Bundle opts);

    @Nullable
    AssetFileDescriptor openTypedAssetFile(@NotNull Uri uri, @NotNull String mimeTypeFilter, @Nullable Bundle opts, @Nullable CancellationSignal signal);

    @Nullable
    Cursor query(@NotNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder);

    boolean refresh(@Nullable Uri uri, @Nullable Bundle extras, @Nullable CancellationSignal cancellationSignal);

    void shutdown();

    @Nullable
    Uri uncanonicalize(@NotNull Uri url);

    int update(@NotNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs);
}
