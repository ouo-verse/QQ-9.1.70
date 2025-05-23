package cp3;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0087@\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0014\b\u0000\u0012\u0006\u0010\b\u001a\u00020\u0005\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\u0007J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001\u00a2\u0006\u0004\b\u0006\u0010\u0007\u0088\u0001\b\u0092\u0001\u00020\u0005\u00f8\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000b"}, d2 = {"Lcp3/b;", "", "", "e", "(I)Ljava/lang/String;", "", "d", "(I)I", "value", "b", "a", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
@JvmInline
/* loaded from: classes38.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name */
    private static final int f391555b = b(0);

    /* renamed from: c, reason: collision with root package name */
    private static final int f391556c = b(1);

    /* renamed from: d, reason: collision with root package name */
    private static final int f391557d = b(2);

    /* renamed from: e, reason: collision with root package name */
    private static final int f391558e = b(3);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\bR)\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001\u00f8\u0001\u0002\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b\u00a1\u001e0\u0001\n\u0002\b!\u00a8\u0006\n"}, d2 = {"Lcp3/b$a;", "", "Lcp3/b;", "None", "I", "a", "()I", "getNone-OMmoiUA$annotations", "()V", "<init>", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: cp3.b$a, reason: from kotlin metadata */
    /* loaded from: classes38.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return b.f391555b;
        }

        Companion() {
        }
    }

    public static final boolean c(int i3, int i16) {
        if (i3 == i16) {
            return true;
        }
        return false;
    }

    public static String e(int i3) {
        if (c(i3, f391555b)) {
            return "None";
        }
        if (c(i3, f391556c)) {
            return "Characters";
        }
        if (c(i3, f391557d)) {
            return "Words";
        }
        if (c(i3, f391558e)) {
            return "Sentences";
        }
        return "Invalid";
    }

    public static int b(int i3) {
        return i3;
    }

    public static int d(int i3) {
        return i3;
    }
}
