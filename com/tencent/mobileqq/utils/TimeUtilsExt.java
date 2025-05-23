package com.tencent.mobileqq.utils;

import android.text.format.DateFormat;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0003\u001a\u00020\u0002R\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0004\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/utils/TimeUtilsExt;", "", "", "a", "b", "Lkotlin/Lazy;", "()Z", "is24HourOr24", "<init>", "()V", "qqestablish_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class TimeUtilsExt {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final TimeUtilsExt f307362a = new TimeUtilsExt();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy is24HourOr24;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.utils.TimeUtilsExt$is24HourOr24$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                boolean z16;
                try {
                    z16 = DateFormat.is24HourFormat(BaseApplication.getContext());
                } catch (Throwable unused) {
                    z16 = false;
                }
                return Boolean.valueOf(z16);
            }
        });
        is24HourOr24 = lazy;
    }

    TimeUtilsExt() {
    }

    private final boolean b() {
        return ((Boolean) is24HourOr24.getValue()).booleanValue();
    }

    public final boolean a() {
        try {
            return DateFormat.is24HourFormat(BaseApplication.getContext());
        } catch (Throwable unused) {
            return b();
        }
    }
}
