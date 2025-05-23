package org.hapjs.storage;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.hapjs.storage.utils.UtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J(\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0004\u00a8\u0006\u0012"}, d2 = {"Lorg/hapjs/storage/StorageImpl;", "Lorg/hapjs/storage/IStorage;", "target", "", "(Ljava/lang/String;)V", "mTarget", "getMTarget", "()Ljava/lang/String;", "setMTarget", "setSharedData", "", "context", "Landroid/content/Context;", "key", "value", "expired", "", "Companion", "storage-sdk_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes29.dex */
public final class StorageImpl implements IStorage {
    public static final int CODE_WRITE_SHARED_ILLEGAL_ARGUMENTS = 203;
    public static final int CODE_WRITE_SHARED_NO_PERMISSIONS = 202;
    public static final int CODE_WRITE_SHARED_SUCCESS = 200;
    public static final int CODE_WRITE_SHARED_SYSTEM_ERROR = 204;
    public static final int CODE_WRITE_SHARED_UNKNOWN_ERROR = 400;
    public static final int CODE_WRITE_SHARED_UNKNOWN_METHOD = 201;
    private static final String RESPONSE_SHARED_DATA_RESULT = "result";
    private static final String SHARED_DATA_DATA = "__data";
    private static final String SHARED_DATA_EXPIRED = "__expired";
    private static final String SHARED_DATA_KEY = "__key";
    private static final String SHARED_DATA_TARGET = "__target";

    @NotNull
    public static final String TAG = "StorageImpl";

    @Nullable
    private String mTarget;

    public StorageImpl(@Nullable String str) {
        this.mTarget = str;
    }

    @Nullable
    public final String getMTarget() {
        return this.mTarget;
    }

    public final void setMTarget(@Nullable String str) {
        this.mTarget = str;
    }

    @Override // org.hapjs.storage.IStorage
    public int setSharedData(@NotNull Context context, @NotNull String key, @NotNull String value, long expired) {
        ContentProviderClient contentProviderClient;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        Bundle bundle = new Bundle();
        bundle.putString(SHARED_DATA_TARGET, this.mTarget);
        bundle.putString("__key", key);
        bundle.putString(SHARED_DATA_DATA, UtilsKt.checkDataSize(value));
        bundle.putLong("__expired", UtilsKt.checkExpiredTime(expired));
        ContentProviderClient contentProviderClient2 = null;
        Bundle call = null;
        ContentProviderClient contentProviderClient3 = null;
        ContentProviderClient contentProviderClient4 = null;
        try {
            ContentResolver contentResolver = context.getContentResolver();
            if (contentResolver != null) {
                contentProviderClient = contentResolver.acquireUnstableContentProviderClient(Uri.parse("content://com.nearme.instant.platform.sharedDataCentre"));
            } else {
                contentProviderClient = null;
            }
            if (contentProviderClient != null) {
                try {
                    call = contentProviderClient.call("setOrUpdateSharedData", null, bundle);
                } catch (RemoteException unused) {
                    contentProviderClient3 = contentProviderClient;
                    if (contentProviderClient3 != null) {
                        if (Build.VERSION.SDK_INT >= 24) {
                            contentProviderClient3.close();
                        } else {
                            contentProviderClient3.release();
                        }
                    }
                    return 400;
                } catch (Exception unused2) {
                    contentProviderClient4 = contentProviderClient;
                    if (contentProviderClient4 != null) {
                        if (Build.VERSION.SDK_INT >= 24) {
                            contentProviderClient4.close();
                        } else {
                            contentProviderClient4.release();
                        }
                    }
                    return 400;
                } catch (Throwable th5) {
                    contentProviderClient2 = contentProviderClient;
                    th = th5;
                    if (contentProviderClient2 != null) {
                        if (Build.VERSION.SDK_INT >= 24) {
                            contentProviderClient2.close();
                        } else {
                            contentProviderClient2.release();
                        }
                    }
                    throw th;
                }
            }
            if (contentProviderClient != null) {
                if (Build.VERSION.SDK_INT >= 24) {
                    contentProviderClient.close();
                } else {
                    contentProviderClient.release();
                }
            }
            if (call == null) {
                return 400;
            }
            return call.getInt("result");
        } catch (RemoteException unused3) {
        } catch (Exception unused4) {
        } catch (Throwable th6) {
            th = th6;
        }
    }
}
