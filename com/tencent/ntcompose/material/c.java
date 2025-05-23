package com.tencent.ntcompose.material;

import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0087@\u0018\u0000 \u00122\u00020\u0001:\u0001\fB\u0014\b\u0000\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0007J\u0010\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003\u00a2\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0010\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u0088\u0001\u0010\u0092\u0001\u00020\u0005\u00f8\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/ntcompose/material/c;", "", "", "f", "(I)Ljava/lang/String;", "", "e", "(I)I", "other", "", "d", "(ILjava/lang/Object;)Z", "a", "I", HippyTextInputController.COMMAND_getValue, "()I", "value", "c", "b", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
@JvmInline
/* loaded from: classes34.dex */
public final class c {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: collision with root package name */
    private static final int f339413c = c(1);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int value;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR \u0010\u0003\u001a\u00020\u00028\u0006\u00f8\u0001\u0000\u00f8\u0001\u0001\u00f8\u0001\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b\u00a1\u001e0\u0001\n\u0002\b!\u00a8\u0006\t"}, d2 = {"Lcom/tencent/ntcompose/material/c$a;", "", "Lcom/tencent/ntcompose/material/c;", "Center", "I", "a", "()I", "<init>", "()V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.ntcompose.material.c$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return c.f339413c;
        }

        Companion() {
        }
    }

    /* synthetic */ c(int i3) {
        this.value = i3;
    }

    public static final /* synthetic */ c b(int i3) {
        return new c(i3);
    }

    public static boolean d(int i3, Object obj) {
        return (obj instanceof c) && i3 == ((c) obj).getValue();
    }

    public static String f(int i3) {
        return "Alignment(value=" + i3 + ')';
    }

    public boolean equals(Object obj) {
        return d(this.value, obj);
    }

    /* renamed from: g, reason: from getter */
    public final /* synthetic */ int getValue() {
        return this.value;
    }

    public int hashCode() {
        return e(this.value);
    }

    public String toString() {
        return f(this.value);
    }

    public static int c(int i3) {
        return i3;
    }

    public static int e(int i3) {
        return i3;
    }
}
