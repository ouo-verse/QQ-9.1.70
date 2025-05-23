package com.tencent.ntcompose.material;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0087@\u0018\u0000 \u00102\u00020\u0001:\u0001\fB\u0014\b\u0000\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0007J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u00058\u0000X\u0080\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u0088\u0001\u000e\u0092\u0001\u00020\u0005\u00f8\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/ntcompose/material/an;", "", "", "i", "(I)Ljava/lang/String;", "", tl.h.F, "(I)I", "other", "", "f", "(ILjava/lang/Object;)Z", "a", "I", "value", "e", "b", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
@JvmInline
/* loaded from: classes34.dex */
public final class an {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: collision with root package name */
    private static final int f339401c = e(1);

    /* renamed from: d, reason: collision with root package name */
    private static final int f339402d = e(2);

    /* renamed from: e, reason: collision with root package name */
    private static final int f339403e = e(3);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int value;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\bR)\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001\u00f8\u0001\u0002\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R)\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001\u00f8\u0001\u0002\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0004\u0012\u0004\b\u000b\u0010\b\u001a\u0004\b\n\u0010\u0006R)\u0010\f\u001a\u00020\u00028\u0006X\u0087\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001\u00f8\u0001\u0002\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0004\u0012\u0004\b\u000e\u0010\b\u001a\u0004\b\r\u0010\u0006\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b\u00a1\u001e0\u0001\n\u0002\b!\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/ntcompose/material/an$a;", "", "Lcom/tencent/ntcompose/material/an;", "Clip", "I", "a", "()I", "getClip-mCHapTc$annotations", "()V", "Middle", "c", "getMiddle-mCHapTc$annotations", "Ellipsis", "b", "getEllipsis-mCHapTc$annotations", "<init>", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.ntcompose.material.an$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return an.f339401c;
        }

        public final int b() {
            return an.f339403e;
        }

        public final int c() {
            return an.f339402d;
        }

        Companion() {
        }
    }

    /* synthetic */ an(int i3) {
        this.value = i3;
    }

    public static final /* synthetic */ an d(int i3) {
        return new an(i3);
    }

    public static boolean f(int i3, Object obj) {
        return (obj instanceof an) && i3 == ((an) obj).getValue();
    }

    public static final boolean g(int i3, int i16) {
        if (i3 == i16) {
            return true;
        }
        return false;
    }

    public static String i(int i3) {
        if (g(i3, f339401c)) {
            return "Clip";
        }
        if (g(i3, f339403e)) {
            return "Ellipsis";
        }
        return "Invalid";
    }

    public boolean equals(Object obj) {
        return f(this.value, obj);
    }

    public int hashCode() {
        return h(this.value);
    }

    /* renamed from: j, reason: from getter */
    public final /* synthetic */ int getValue() {
        return this.value;
    }

    public String toString() {
        return i(this.value);
    }

    public static int e(int i3) {
        return i3;
    }

    public static int h(int i3) {
        return i3;
    }
}
