package com.tencent.kuikly.core.render.android.context;

import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0011\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u0002J\u000e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u0004J\u000e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u0006J\u000e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\bJ\u000e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\nJ\u000e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\fR\"\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u0010\u0010\u001b\u00a8\u0006 "}, d2 = {"Lcom/tencent/kuikly/core/render/android/context/KRKValue;", "", "", "asInt", "", "asLong", "", "asFloat", "", "asDouble", "", "asBoolean", "", "asString", "v", "", HippyTextInputController.COMMAND_setValue, "type", "I", "getType", "()I", "setType", "(I)V", "value", "Ljava/lang/Object;", HippyTextInputController.COMMAND_getValue, "()Ljava/lang/Object;", "(Ljava/lang/Object;)V", "<init>", "()V", "Companion", "a", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class KRKValue {
    public static final int TYPE_BOOLEAN = 5;
    public static final int TYPE_DOUBLE = 4;
    public static final int TYPE_FLOAT = 3;
    public static final int TYPE_INT = 1;
    public static final int TYPE_LONG = 2;
    public static final int TYPE_NULL = 0;
    public static final int TYPE_STRING = 6;
    private int type;

    @Nullable
    private Object value;

    public final boolean asBoolean() {
        Object obj = this.value;
        if (obj != null) {
            return ((Boolean) obj).booleanValue();
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
    }

    public final double asDouble() {
        Object obj = this.value;
        if (obj != null) {
            return ((Double) obj).doubleValue();
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Double");
    }

    public final float asFloat() {
        Object obj = this.value;
        if (obj != null) {
            return ((Float) obj).floatValue();
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }

    public final int asInt() {
        Object obj = this.value;
        if (obj != null) {
            return ((Integer) obj).intValue();
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    public final long asLong() {
        Object obj = this.value;
        if (obj != null) {
            return ((Long) obj).longValue();
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
    }

    @NotNull
    public final String asString() {
        Object obj = this.value;
        if (obj != null) {
            return (String) obj;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    public final int getType() {
        return this.type;
    }

    @Nullable
    public final Object getValue() {
        return this.value;
    }

    public final void setType(int i3) {
        this.type = i3;
    }

    public final void setValue(@Nullable Object obj) {
        this.value = obj;
    }

    public final void setValue(int v3) {
        this.value = Integer.valueOf(v3);
    }

    public final void setValue(long v3) {
        this.value = Long.valueOf(v3);
    }

    public final void setValue(float v3) {
        this.value = Float.valueOf(v3);
    }

    public final void setValue(double v3) {
        this.value = Double.valueOf(v3);
    }

    public final void setValue(boolean v3) {
        this.value = Boolean.valueOf(v3);
    }

    public final void setValue(@NotNull String v3) {
        Intrinsics.checkNotNullParameter(v3, "v");
        this.value = v3;
    }
}
