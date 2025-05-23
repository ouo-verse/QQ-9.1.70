package com.tencent.mobileqq.qwallet.utils.impl;

import androidx.lifecycle.SavedStateHandle;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u001f\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/qwallet/utils/impl/c;", "", "Landroidx/lifecycle/SavedStateHandle;", "stateHandle", "", "key", "b", "", "a", "(Landroidx/lifecycle/SavedStateHandle;Ljava/lang/String;)Ljava/lang/Integer;", "<init>", "()V", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f279281a = new c();

    c() {
    }

    @Nullable
    public final Integer a(@NotNull SavedStateHandle stateHandle, @NotNull String key) {
        Object obj;
        Intrinsics.checkNotNullParameter(stateHandle, "stateHandle");
        Intrinsics.checkNotNullParameter(key, "key");
        if (!stateHandle.contains(key)) {
            return null;
        }
        try {
            obj = stateHandle.get(key);
        } catch (Exception e16) {
            QLog.w("StateHandleUtil", 1, "getInt error: ", e16);
        }
        if (obj instanceof Integer) {
            return (Integer) obj;
        }
        if (obj instanceof String) {
            return Integer.valueOf(Integer.parseInt((String) obj));
        }
        return null;
    }

    @Nullable
    public final String b(@NotNull SavedStateHandle stateHandle, @NotNull String key) {
        Intrinsics.checkNotNullParameter(stateHandle, "stateHandle");
        Intrinsics.checkNotNullParameter(key, "key");
        if (!stateHandle.contains(key)) {
            return null;
        }
        try {
            return String.valueOf(stateHandle.get(key));
        } catch (Exception e16) {
            QLog.w("StateHandleUtil", 1, "getString error: ", e16);
            return null;
        }
    }
}
