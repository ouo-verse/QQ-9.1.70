package com.tenpay.sdk.net.utils;

import android.database.Cursor;
import java.io.Closeable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a8\u0006\t"}, d2 = {"Lcom/tenpay/sdk/net/utils/IOUtils;", "", "()V", "closeSilently", "", "cursor", "Landroid/database/Cursor;", "closeable", "Ljava/io/Closeable;", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class IOUtils {

    @NotNull
    public static final IOUtils INSTANCE = new IOUtils();

    IOUtils() {
    }

    public final void closeSilently(@Nullable Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (Throwable unused) {
        }
    }

    public final void closeSilently(@Nullable Cursor cursor) {
        if (cursor == null || cursor.isClosed()) {
            return;
        }
        try {
            cursor.close();
        } catch (Throwable unused) {
        }
    }
}
