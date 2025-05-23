package org.hapjs.storage;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.ditto.shell.LayoutAttrDefine;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.hapjs.storage.utils.LogUtil;
import org.hapjs.storage.utils.PermissionUtil;
import org.hapjs.storage.utils.UtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u0000 &2\u00020\u0001:\u0001&B\u0005\u00a2\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\t\u001a\u00020\nH\u0002J1\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00062\u0010\u0010\u0010\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0006\u0018\u00010\u0011H\u0016\u00a2\u0006\u0002\u0010\u0012J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0014\u001a\u00020\u0015H&J\u001c\u0010\u0016\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0006H\u0002J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0014\u0010\u001a\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0002J\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010\u001e\u001a\u00020\nH\u0016JO\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010\r\u001a\u00020\u000e2\u0010\u0010!\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0006\u0018\u00010\u00112\b\u0010\u000f\u001a\u0004\u0018\u00010\u00062\u0010\u0010\u0010\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0006\u0018\u00010\u00112\b\u0010\"\u001a\u0004\u0018\u00010\u0006H\u0016\u00a2\u0006\u0002\u0010#J;\u0010$\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00062\u0010\u0010\u0010\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0006\u0018\u00010\u0011H\u0016\u00a2\u0006\u0002\u0010%\u00a8\u0006'"}, d2 = {"Lorg/hapjs/storage/BaseSharedProvider;", "Landroid/content/ContentProvider;", "()V", "call", "Landroid/os/Bundle;", "method", "", "arg", "extras", "checkPermission", "", "delete", "", LayoutAttrDefine.CLICK_URI, "Landroid/net/Uri;", "selection", "selectionArgs", "", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", "doHandleRequestData", Const.BUNDLE_KEY_REQUEST, "Lorg/hapjs/storage/Request;", "getRequest", "key", "sourceRpk", "getType", "handleRequestData", "insert", "values", "Landroid/content/ContentValues;", "onCreate", "query", "Landroid/database/Cursor;", "projection", "sortOrder", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "update", "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "Companion", "storage-sdk_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes29.dex */
public abstract class BaseSharedProvider extends ContentProvider {
    private static final List<String> ALLOW_CALLER_WHITE_LIST;

    @NotNull
    public static final String METHOD_REQUEST_DATA = "requestdata";

    @NotNull
    public static final String PARAMS_KEY_DATA_KEY = "__key";

    @NotNull
    public static final String PARAMS_KEY_RPK = "__rpk";

    @NotNull
    public static final String RESPONSE_REQUEST_DATA_DATA = "__sharedData";

    @NotNull
    public static final String RESPONSE_REQUEST_DATA_EXPIRED = "__expired";

    @NotNull
    public static final String TAG = "BaseSharedProvider";

    static {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"com.coloros.assistantscreen", "com.coloros.launcher", "com.android.launcher", "com.nearme.instant.platform"});
        ALLOW_CALLER_WHITE_LIST = listOf;
    }

    private final boolean checkPermission() {
        PackageManager packageManager;
        String[] packagesForUid;
        Context context = getContext();
        if (context != null && (packageManager = context.getPackageManager()) != null && (packagesForUid = packageManager.getPackagesForUid(Binder.getCallingUid())) != null) {
            for (String str : packagesForUid) {
                PermissionUtil permissionUtil = PermissionUtil.INSTANCE;
                Context context2 = getContext();
                Intrinsics.checkNotNull(context2);
                Intrinsics.checkNotNullExpressionValue(context2, "this.context!!");
                if (permissionUtil.isTrustedHost(context2, str, false)) {
                    return true;
                }
            }
        }
        return false;
    }

    private final Request getRequest(String key, String sourceRpk) {
        return new Request(key, sourceRpk);
    }

    private final Bundle handleRequestData(Bundle extras) {
        String str;
        String str2;
        String str3;
        Long l3;
        if (extras != null) {
            str = extras.getString(PARAMS_KEY_DATA_KEY);
        } else {
            str = null;
        }
        if (extras != null) {
            str2 = extras.getString(PARAMS_KEY_RPK);
        } else {
            str2 = null;
        }
        Bundle doHandleRequestData = doHandleRequestData(getRequest(str, str2));
        if (doHandleRequestData != null) {
            str3 = doHandleRequestData.getString(RESPONSE_REQUEST_DATA_DATA);
        } else {
            str3 = null;
        }
        if (doHandleRequestData != null) {
            l3 = Long.valueOf(doHandleRequestData.getLong(RESPONSE_REQUEST_DATA_EXPIRED));
        } else {
            l3 = null;
        }
        if (str3 != null && l3 != null) {
            Bundle bundle = new Bundle();
            bundle.putString(RESPONSE_REQUEST_DATA_DATA, UtilsKt.checkDataSize(str3));
            bundle.putLong(RESPONSE_REQUEST_DATA_EXPIRED, UtilsKt.checkExpiredTime(l3.longValue()));
            return bundle;
        }
        LogUtil.INSTANCE.w(TAG, "response data error");
        return null;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Bundle call(@NotNull String method, @Nullable String arg, @Nullable Bundle extras) {
        Intrinsics.checkNotNullParameter(method, "method");
        if (!checkPermission()) {
            return null;
        }
        if (method.hashCode() == 1150550713 && method.equals(METHOD_REQUEST_DATA)) {
            return handleRequestData(extras);
        }
        LogUtil.INSTANCE.w(TAG, "unknown method!");
        return null;
    }

    @Override // android.content.ContentProvider
    public int delete(@NotNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return 0;
    }

    @Nullable
    public abstract Bundle doHandleRequestData(@NotNull Request request);

    @Override // android.content.ContentProvider
    @Nullable
    public String getType(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Uri insert(@NotNull Uri uri, @Nullable ContentValues values) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Cursor query(@NotNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(@NotNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return 0;
    }
}
