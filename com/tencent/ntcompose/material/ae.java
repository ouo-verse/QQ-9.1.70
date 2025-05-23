package com.tencent.ntcompose.material;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0087@\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0014\b\u0000\u0012\u0006\u0010\f\u001a\u00020\t\u00f8\u0001\u0000\u00a2\u0006\u0004\b\r\u0010\u000bJ\r\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016\u00a2\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\n\u001a\u00020\tH\u00d6\u0001\u00a2\u0006\u0004\b\n\u0010\u000b\u0088\u0001\f\u0092\u0001\u00020\t\u00f8\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/ntcompose/material/ae;", "", "", "g", "(I)Z", "", "e", "(I)Ljava/lang/String;", tl.h.F, "", "f", "(I)I", "value", "c", "a", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
@JvmInline
/* loaded from: classes34.dex */
public final class ae {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name */
    private static final int f339367b = c(0);

    /* renamed from: c, reason: collision with root package name */
    private static final int f339368c = c(1);

    /* renamed from: d, reason: collision with root package name */
    private static final int f339369d = c(2);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR \u0010\u0003\u001a\u00020\u00028\u0006\u00f8\u0001\u0000\u00f8\u0001\u0001\u00f8\u0001\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R \u0010\u0007\u001a\u00020\u00028\u0006\u00f8\u0001\u0000\u00f8\u0001\u0001\u00f8\u0001\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b\u00a1\u001e0\u0001\n\u0002\b!\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/ntcompose/material/ae$a;", "", "Lcom/tencent/ntcompose/material/ae;", "Butt", "I", "a", "()I", "Round", "b", "<init>", "()V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.ntcompose.material.ae$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return ae.f339367b;
        }

        public final int b() {
            return ae.f339368c;
        }

        Companion() {
        }
    }

    public static final boolean d(int i3, int i16) {
        if (i3 == i16) {
            return true;
        }
        return false;
    }

    public static final String e(int i3) {
        if (d(i3, f339367b)) {
            return "butt";
        }
        if (d(i3, f339368c)) {
            return "round";
        }
        if (d(i3, f339369d)) {
            return "square";
        }
        return "unknown";
    }

    public static final boolean g(int i3) {
        return (d(i3, f339368c) || d(i3, f339367b) || d(i3, f339369d)) ? false : true;
    }

    public static String h(int i3) {
        if (d(i3, f339367b)) {
            return "Butt";
        }
        if (d(i3, f339368c)) {
            return "Round";
        }
        if (d(i3, f339369d)) {
            return "Square";
        }
        return "Unknown";
    }

    public static int c(int i3) {
        return i3;
    }

    public static int f(int i3) {
        return i3;
    }
}
