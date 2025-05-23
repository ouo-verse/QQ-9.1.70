package com.tenpay.sdk.net.utils;

import com.tencent.BuildConfig;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a8\u0006\b"}, d2 = {"Lcom/tenpay/sdk/net/utils/ExceptionUtils;", "", "()V", "getStackTrace", "", "e", "", "toSimpleString", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class ExceptionUtils {

    @NotNull
    public static final ExceptionUtils INSTANCE = new ExceptionUtils();

    ExceptionUtils() {
    }

    @Nullable
    public final String getStackTrace(@Nullable Throwable e16) {
        StackTraceElement[] stackTraceElementArr;
        boolean z16;
        if (e16 != null) {
            stackTraceElementArr = e16.getStackTrace();
        } else {
            stackTraceElementArr = null;
        }
        if (stackTraceElementArr != null) {
            StackTraceElement[] stackTrace = e16.getStackTrace();
            Intrinsics.checkNotNullExpressionValue(stackTrace, "e.stackTrace");
            if (stackTrace.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(e16.toString());
                sb5.append("\n");
                StackTraceElement[] stackTrace2 = e16.getStackTrace();
                Intrinsics.checkNotNullExpressionValue(stackTrace2, "e.stackTrace");
                for (StackTraceElement stackTraceElement : stackTrace2) {
                    sb5.append(stackTraceElement.toString());
                    sb5.append("\n");
                }
                return sb5.toString();
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x005a A[LOOP:0: B:10:0x002a->B:17:0x005a, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0058 A[SYNTHETIC] */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String toSimpleString(@Nullable Throwable e16) {
        StackTraceElement[] stackTraceElementArr;
        boolean z16;
        Object first;
        boolean contains$default;
        boolean z17;
        boolean contains$default2;
        StackTraceElement stackTraceElement = null;
        if (e16 != null) {
            stackTraceElementArr = e16.getStackTrace();
        } else {
            stackTraceElementArr = null;
        }
        if (stackTraceElementArr != null) {
            StackTraceElement[] stackTrace = e16.getStackTrace();
            Intrinsics.checkNotNullExpressionValue(stackTrace, "e.stackTrace");
            if (stackTrace.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                StackTraceElement[] stackTrace2 = e16.getStackTrace();
                Intrinsics.checkNotNullExpressionValue(stackTrace2, "e.stackTrace");
                int length = stackTrace2.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    }
                    StackTraceElement stackTraceElement2 = stackTrace2[i3];
                    String className = stackTraceElement2.getClassName();
                    Intrinsics.checkNotNullExpressionValue(className, "it.className");
                    contains$default = StringsKt__StringsKt.contains$default((CharSequence) className, (CharSequence) BuildConfig.LIBRARY_PACKAGE_NAME, false, 2, (Object) null);
                    if (!contains$default) {
                        String className2 = stackTraceElement2.getClassName();
                        Intrinsics.checkNotNullExpressionValue(className2, "it.className");
                        contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) className2, (CharSequence) "com.tenpay", false, 2, (Object) null);
                        if (!contains$default2) {
                            z17 = false;
                            if (!z17) {
                                stackTraceElement = stackTraceElement2;
                                break;
                            }
                            i3++;
                        }
                    }
                    z17 = true;
                    if (!z17) {
                    }
                }
                if (stackTraceElement == null) {
                    StackTraceElement[] stackTrace3 = e16.getStackTrace();
                    Intrinsics.checkNotNullExpressionValue(stackTrace3, "e.stackTrace");
                    first = ArraysKt___ArraysKt.first(stackTrace3);
                    stackTraceElement = (StackTraceElement) first;
                }
                return ("(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getMethodName() + ":" + stackTraceElement.getLineNumber() + ")") + e16;
            }
        }
        return null;
    }
}
