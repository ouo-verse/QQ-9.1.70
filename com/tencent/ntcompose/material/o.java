package com.tencent.ntcompose.material;

import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0087@\u0018\u0000 \u00122\u00020\u0001:\u0001\fB\u0014\b\u0000\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0007J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003\u00a2\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0010\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u0088\u0001\u0010\u0092\u0001\u00020\u0005\u00f8\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/ntcompose/material/o;", "", "", tl.h.F, "(I)Ljava/lang/String;", "", "g", "(I)I", "other", "", "e", "(ILjava/lang/Object;)Z", "a", "I", HippyTextInputController.COMMAND_getValue, "()I", "value", "d", "b", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
@JvmInline
/* loaded from: classes34.dex */
public final class o {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: collision with root package name */
    private static final int f339439c = d(0);

    /* renamed from: d, reason: collision with root package name */
    private static final int f339440d = d(1);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int value;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR \u0010\u0003\u001a\u00020\u00028\u0006\u00f8\u0001\u0000\u00f8\u0001\u0001\u00f8\u0001\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R \u0010\u0007\u001a\u00020\u00028\u0006\u00f8\u0001\u0000\u00f8\u0001\u0001\u00f8\u0001\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b\u00a1\u001e0\u0001\n\u0002\b!\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/ntcompose/material/o$a;", "", "Lcom/tencent/ntcompose/material/o;", "Normal", "I", "b", "()I", "Italic", "a", "<init>", "()V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.ntcompose.material.o$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return o.f339440d;
        }

        public final int b() {
            return o.f339439c;
        }

        Companion() {
        }
    }

    /* synthetic */ o(int i3) {
        this.value = i3;
    }

    public static final /* synthetic */ o c(int i3) {
        return new o(i3);
    }

    public static boolean e(int i3, Object obj) {
        return (obj instanceof o) && i3 == ((o) obj).getValue();
    }

    public static final boolean f(int i3, int i16) {
        if (i3 == i16) {
            return true;
        }
        return false;
    }

    public static String h(int i3) {
        if (f(i3, f339439c)) {
            return "Normal";
        }
        if (f(i3, f339440d)) {
            return "Italic";
        }
        return "Invalid";
    }

    public boolean equals(Object obj) {
        return e(this.value, obj);
    }

    public int hashCode() {
        return g(this.value);
    }

    /* renamed from: i, reason: from getter */
    public final /* synthetic */ int getValue() {
        return this.value;
    }

    public String toString() {
        return h(this.value);
    }

    public static int d(int i3) {
        return i3;
    }

    public static int g(int i3) {
        return i3;
    }
}
