package pk2;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0004\u001a\u00020\u0002H\u0007R*\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00028\u0006@BX\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u0006\u0010\b\u00a8\u0006\r"}, d2 = {"Lpk2/a;", "", "", "c", "a", "<set-?>", "b", "I", "()I", "getValue$annotations", "()V", "value", "<init>", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f426412a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static int value;

    a() {
    }

    @JvmStatic
    public static final int a() {
        int i3 = value - 1;
        value = i3;
        return i3;
    }

    public static final int b() {
        return value;
    }

    @JvmStatic
    public static final int c() {
        int i3 = value + 1;
        value = i3;
        return i3;
    }
}
