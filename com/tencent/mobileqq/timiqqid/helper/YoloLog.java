package com.tencent.mobileqq.timiqqid.helper;

import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bH\u0007J\u001e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bH\u0007J\u001e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bH\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/timiqqid/helper/YoloLog;", "", "()V", "d", "", "tag", "", "msgLambda", "Lkotlin/Function0;", "e", "i", "timi-qqid-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes18.dex */
public final class YoloLog {

    @NotNull
    public static final YoloLog INSTANCE = new YoloLog();

    YoloLog() {
    }

    @JvmStatic
    public static final void d(@NotNull String tag, @NotNull Function0<String> msgLambda) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msgLambda, "msgLambda");
        QLog.e(tag, 1, msgLambda.invoke());
    }

    @JvmStatic
    public static final void e(@NotNull String tag, @NotNull Function0<String> msgLambda) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msgLambda, "msgLambda");
        QLog.e(tag, 1, msgLambda.invoke());
    }

    @JvmStatic
    public static final void i(@NotNull String tag, @NotNull Function0<String> msgLambda) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msgLambda, "msgLambda");
        QLog.e(tag, 1, msgLambda.invoke());
    }
}
