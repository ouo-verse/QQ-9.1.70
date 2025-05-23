package com.tencent.mobileqq.config.business.qmmkv;

import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u001f\u0010\t\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0014J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0014\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/config/business/qmmkv/l;", "Lcom/tencent/mobileqq/config/business/qmmkv/PropertyStorage;", "", "", "key", "value", "", "e", "defValue", "d", "(Ljava/lang/String;I)Ljava/lang/Integer;", "b", "c", "<init>", "()V", "a", "startup_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class l extends PropertyStorage<Integer> {
    @NotNull
    protected String b(@NotNull String key, int value) {
        Intrinsics.checkNotNullParameter(key, "key");
        return c(key) + value;
    }

    @NotNull
    protected String c(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return key + "_I_";
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003d A[Catch: all -> 0x0072, IOException -> 0x007a, LOOP:0: B:6:0x001c->B:13:0x003d, LOOP_END, TryCatch #0 {IOException -> 0x007a, blocks: (B:3:0x000a, B:5:0x001a, B:7:0x001e, B:9:0x0026, B:17:0x0043, B:19:0x0049, B:21:0x0059, B:24:0x0062, B:29:0x006d, B:13:0x003d), top: B:2:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003c A[SYNTHETIC] */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Integer d(@NotNull String key, int defValue) throws RuntimeException {
        File file;
        int i3;
        String name;
        boolean z16;
        boolean startsWith$default;
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            try {
                String c16 = c(key);
                File[] listFiles = a().listFiles();
                boolean z17 = false;
                String str = null;
                if (listFiles != null) {
                    int length = listFiles.length;
                    for (int i16 = 0; i16 < length; i16++) {
                        file = listFiles[i16];
                        if (file.exists()) {
                            String name2 = file.getName();
                            Intrinsics.checkNotNullExpressionValue(name2, "it.name");
                            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(name2, c16, false, 2, null);
                            if (startsWith$default) {
                                z16 = true;
                                if (!z16) {
                                    break;
                                }
                            }
                        }
                        z16 = false;
                        if (!z16) {
                        }
                    }
                }
                file = null;
                if (file != null && (name = file.getName()) != null) {
                    str = name.substring(c16.length());
                    Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String).substring(startIndex)");
                }
                if (str == null || str.length() == 0) {
                    z17 = true;
                }
                if (z17) {
                    return Integer.valueOf(defValue);
                }
                try {
                    i3 = Integer.parseInt(str);
                } catch (Exception unused) {
                    i3 = defValue;
                }
                return Integer.valueOf(i3);
            } catch (Throwable th5) {
                QLog.e("QMMKV_PropertyStorageInt", 1, "get exception", th5);
                return Integer.valueOf(defValue);
            }
        } catch (IOException e16) {
            QLog.e("QMMKV_PropertyStorageInt", 1, "get IOException", e16);
            return Integer.valueOf(defValue);
        }
    }

    public void e(@NotNull String key, int value) throws RuntimeException {
        boolean startsWith$default;
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            if (a().exists() && a().isDirectory()) {
                File[] listFiles = a().listFiles();
                if (listFiles != null) {
                    for (File file : listFiles) {
                        if (file.exists()) {
                            String name = file.getName();
                            Intrinsics.checkNotNullExpressionValue(name, "it.name");
                            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(name, c(key), false, 2, null);
                            if (startsWith$default) {
                                file.delete();
                            }
                        }
                    }
                }
                new File(a(), b(key, value)).createNewFile();
            }
        } catch (IOException e16) {
            QLog.e("QMMKV_PropertyStorageInt", 1, "put IOException", e16);
        } catch (Throwable th5) {
            QLog.e("QMMKV_PropertyStorageInt", 1, "put exception", th5);
        }
    }
}
