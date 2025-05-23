package com.tencent.mobileqq.config.business.qmmkv;

import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u001f\u0010\t\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0014J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0014\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/config/business/qmmkv/k;", "Lcom/tencent/mobileqq/config/business/qmmkv/PropertyStorage;", "", "", "key", "value", "", "e", "defValue", "d", "(Ljava/lang/String;Z)Ljava/lang/Boolean;", "b", "c", "<init>", "()V", "a", "startup_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class k extends PropertyStorage<Boolean> {
    @NotNull
    protected String b(@NotNull String key, boolean value) {
        Intrinsics.checkNotNullParameter(key, "key");
        return c(key) + (value ? 1 : 0);
    }

    @NotNull
    protected String c(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return key + "_Z_";
    }

    @NotNull
    public Boolean d(@NotNull String key, boolean defValue) throws RuntimeException {
        boolean z16;
        Intrinsics.checkNotNullParameter(key, "key");
        if (!defValue) {
            z16 = true;
        } else {
            z16 = false;
        }
        try {
            if (new File(a(), b(key, z16)).exists()) {
                return Boolean.valueOf(z16);
            }
            return Boolean.valueOf(defValue);
        } catch (IOException e16) {
            QLog.e("QMMKV_PropertyStorageBoolean", 1, "get IOException", e16);
            return Boolean.valueOf(defValue);
        } catch (Throwable th5) {
            QLog.e("QMMKV_PropertyStorageBoolean", 1, "get exception", th5);
            return Boolean.valueOf(defValue);
        }
    }

    public void e(@NotNull String key, boolean value) throws RuntimeException {
        boolean z16;
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            if (a().exists() && a().isDirectory()) {
                File file = new File(a(), b(key, value));
                if (file.exists()) {
                    return;
                }
                if (!value) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                File file2 = new File(a(), b(key, z16));
                if (file2.exists()) {
                    file2.renameTo(file);
                } else {
                    file.createNewFile();
                }
            }
        } catch (IOException e16) {
            QLog.e("QMMKV_PropertyStorageBoolean", 1, "put IOException", e16);
        } catch (Throwable th5) {
            QLog.e("QMMKV_PropertyStorageBoolean", 1, "put exception", th5);
        }
    }
}
