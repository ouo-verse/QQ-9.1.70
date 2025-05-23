package hn3;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import or4.n;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00062\u00020\u0001:\u0001\u000eB\u001b\u0012\u0006\u0010\u0012\u001a\u00020\r\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0013\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u001d\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bJ\b\u0010\f\u001a\u00020\nH\u0016R\u0017\u0010\u0012\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0014\u001a\u0004\b\u000e\u0010\u0015R\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0017\u00a8\u0006\u001a"}, d2 = {"Lhn3/b;", "", "", "Lor4/n;", "items", "", "d", "([Lor4/n;)V", "", "uid", "", "c", "toString", "", "a", "I", "b", "()I", "type", "Lhn3/a;", "Lhn3/a;", "()Lhn3/a;", "linkScreenAnchorInfo", "[Lor4/n;", "<init>", "(ILhn3/a;)V", "qq-live-linkscreen-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: hn3.b, reason: from toString */
/* loaded from: classes22.dex */
public final class LinkScreenEvent {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int type;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final LinkScreenAnchorInfo linkScreenAnchorInfo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private n[] items;

    public LinkScreenEvent(int i3, @Nullable LinkScreenAnchorInfo linkScreenAnchorInfo) {
        this.type = i3;
        this.linkScreenAnchorInfo = linkScreenAnchorInfo;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final LinkScreenAnchorInfo getLinkScreenAnchorInfo() {
        return this.linkScreenAnchorInfo;
    }

    /* renamed from: b, reason: from getter */
    public final int getType() {
        return this.type;
    }

    @NotNull
    public final String c(long uid) {
        boolean z16;
        n[] nVarArr = this.items;
        if (nVarArr != null) {
            for (n nVar : nVarArr) {
                if (nVar.f423524a == uid) {
                    or4.a[] aVarArr = nVar.f423525b.f423527b.f423483a;
                    Intrinsics.checkNotNullExpressionValue(aVarArr, "it.stream.frame.addresses");
                    if (aVarArr.length == 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (!z16) {
                        String str = nVar.f423525b.f423527b.f423483a[0].f423473a;
                        Intrinsics.checkNotNullExpressionValue(str, "it.stream.frame.addresses[0].url");
                        return str;
                    }
                }
            }
            return "";
        }
        return "";
    }

    public final void d(@Nullable n[] items) {
        this.items = items;
    }

    @NotNull
    public String toString() {
        return "LinkScreenEvent(type=" + this.type + ')';
    }

    public /* synthetic */ LinkScreenEvent(int i3, LinkScreenAnchorInfo linkScreenAnchorInfo, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, (i16 & 2) != 0 ? null : linkScreenAnchorInfo);
    }
}
