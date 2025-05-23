package com.tencent.qqmini.sdk.core.utils;

import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0006\u0010\u0003\u001a\u00020\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001e\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0004R\u001a\u0010\u0013\u001a\u00020\u00048\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\t\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/qqmini/sdk/core/utils/e;", "Lcom/tencent/qqmini/sdk/core/utils/a;", "", "b", "", "key", "Lcom/tencent/qqmini/sdk/core/utils/ImageItem;", "get", "value", "a", "", "has", "Ljava/io/InputStream;", "inputStream", "mimeType", "c", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "TAG", "Lcom/tencent/qqmini/sdk/core/utils/a;", "cacheProxy", "<init>", "()V", "lib_minisdk_internalRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes23.dex */
public final class e implements a {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static a cacheProxy;

    /* renamed from: c, reason: collision with root package name */
    public static final e f348080c = new e();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String TAG = "ImageCache";

    e() {
    }

    @Override // com.tencent.qqmini.sdk.core.utils.a
    public void a(@NotNull String key, @NotNull ImageItem value) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        Intrinsics.checkParameterIsNotNull(value, "value");
        b();
        a aVar = cacheProxy;
        if (aVar != null) {
            aVar.a(key, value);
        }
    }

    public final void b() {
        if (cacheProxy == null) {
            a aVar = (a) ProxyManager.get(a.class);
            String str = TAG;
            QMLog.i(str, "get img cache proxy");
            if (aVar != null) {
                QMLog.i(str, "proxy is not null " + aVar.toString());
                try {
                    cacheProxy = aVar;
                    QMLog.i(str, "transfer to cacheProxy");
                } catch (Exception e16) {
                    QMLog.e(TAG, "check error", e16);
                }
            }
        }
    }

    @NotNull
    public final InputStream c(@NotNull String key, @NotNull InputStream inputStream, @NotNull String mimeType) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        Intrinsics.checkParameterIsNotNull(inputStream, "inputStream");
        Intrinsics.checkParameterIsNotNull(mimeType, "mimeType");
        String str = TAG;
        QMLog.i(str, "save in the cache");
        b();
        if (cacheProxy != null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                ByteStreamsKt.copyTo$default(inputStream, byteArrayOutputStream, 0, 2, null);
                CloseableKt.closeFinally(inputStream, null);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                a(key, new ImageItem(mimeType, byteArray));
                return new ByteArrayInputStream(byteArray);
            } finally {
            }
        } else {
            QMLog.i(str, "proxy is null ");
            return inputStream;
        }
    }

    @Override // com.tencent.qqmini.sdk.core.utils.a
    @Nullable
    public ImageItem get(@NotNull String key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        b();
        a aVar = cacheProxy;
        if (aVar != null) {
            return aVar.get(key);
        }
        return null;
    }

    @Override // com.tencent.qqmini.sdk.core.utils.a
    public boolean has(@NotNull String key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        b();
        a aVar = cacheProxy;
        if (aVar != null) {
            return aVar.has(key);
        }
        return false;
    }
}
