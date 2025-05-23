package com.tencent.rmonitor.common.util;

import com.vivo.push.PushClientConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0006\u001a\u00020\u00052\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\u0007J#\u0010\t\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0007\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/rmonitor/common/util/c;", "", "obj", "", PushClientConstants.TAG_CLASS_NAME, "", "b", "", "withIndex", "a", "(Ljava/lang/Object;Ljava/lang/Integer;)Ljava/lang/String;", "<init>", "()V", "rmonitor-core_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f365536a = new c();

    c() {
    }

    @JvmStatic
    @NotNull
    public static final String a(@NotNull Object obj, @Nullable Integer withIndex) {
        Intrinsics.checkParameterIsNotNull(obj, "obj");
        if (withIndex != null) {
            String str = obj.getClass().getName() + '[' + withIndex.intValue() + ']';
            if (str != null) {
                return str;
            }
        }
        String name = obj.getClass().getName();
        Intrinsics.checkExpressionValueIsNotNull(name, "obj.javaClass.name");
        return name;
    }

    @JvmStatic
    public static final boolean b(@Nullable Object obj, @NotNull String className) {
        Intrinsics.checkParameterIsNotNull(className, "className");
        if (obj == null) {
            return false;
        }
        try {
            return Class.forName(className).isInstance(obj);
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }
}
