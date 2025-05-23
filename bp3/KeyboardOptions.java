package bp3;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0001\nB2\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0017\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0013\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016R \u0010\u000e\u001a\u00020\t8\u0006\u00f8\u0001\u0000\u00f8\u0001\u0001\u00f8\u0001\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R \u0010\u0016\u001a\u00020\u00148\u0006\u00f8\u0001\u0000\u00f8\u0001\u0001\u00f8\u0001\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u000f\u0010\rR \u0010\u0019\u001a\u00020\u00178\u0006\u00f8\u0001\u0000\u00f8\u0001\u0001\u00f8\u0001\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\u000b\u001a\u0004\b\n\u0010\r\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b\u00a1\u001e0\u0001\n\u0002\b!\u00a8\u0006\u001d"}, d2 = {"Lbp3/g;", "", "other", "", "equals", "", "hashCode", "", "toString", "Lcp3/b;", "a", "I", "getCapitalization-OMmoiUA", "()I", "capitalization", "b", "Z", "getAutoCorrect", "()Z", "autoCorrect", "Lcp3/c;", "c", "keyboardType", "Lcp3/a;", "d", "imeAction", "<init>", "(IZIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "e", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: bp3.g, reason: from toString */
/* loaded from: classes39.dex */
public final class KeyboardOptions {

    /* renamed from: f, reason: collision with root package name */
    private static final KeyboardOptions f28893f = new KeyboardOptions(0, false, 0, 0, 15, null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int capitalization;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean autoCorrect;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int keyboardType;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int imeAction;

    public /* synthetic */ KeyboardOptions(int i3, boolean z16, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, z16, i16, i17);
    }

    /* renamed from: a, reason: from getter */
    public final int getImeAction() {
        return this.imeAction;
    }

    /* renamed from: b, reason: from getter */
    public final int getKeyboardType() {
        return this.keyboardType;
    }

    public int hashCode() {
        return (((((cp3.b.d(this.capitalization) * 31) + f.a(this.autoCorrect)) * 31) + cp3.c.l(this.keyboardType)) * 31) + cp3.a.k(this.imeAction);
    }

    public String toString() {
        return "KeyboardOptions(capitalization=" + ((Object) cp3.b.e(this.capitalization)) + ", autoCorrect=" + this.autoCorrect + ", keyboardType=" + ((Object) cp3.c.m(this.keyboardType)) + ", imeAction=" + ((Object) cp3.a.l(this.imeAction)) + ')';
    }

    KeyboardOptions(int i3, boolean z16, int i16, int i17) {
        this.capitalization = i3;
        this.autoCorrect = z16;
        this.keyboardType = i16;
        this.imeAction = i17;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof KeyboardOptions)) {
            return false;
        }
        KeyboardOptions keyboardOptions = (KeyboardOptions) other;
        return cp3.b.c(this.capitalization, keyboardOptions.capitalization) && this.autoCorrect == keyboardOptions.autoCorrect && cp3.c.k(this.keyboardType, keyboardOptions.keyboardType) && cp3.a.j(this.imeAction, keyboardOptions.imeAction);
    }

    public /* synthetic */ KeyboardOptions(int i3, boolean z16, int i16, int i17, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this((i18 & 1) != 0 ? cp3.b.INSTANCE.a() : i3, (i18 & 2) != 0 ? true : z16, (i18 & 4) != 0 ? cp3.c.INSTANCE.h() : i16, (i18 & 8) != 0 ? cp3.a.INSTANCE.a() : i17, null);
    }
}
