package a24;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0086\b\u0018\u0000 '2\u00020\u0001:\u0001\tBI\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0013\u0012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018\u0012\u0006\u0010!\u001a\u00020\u0007\u0012\u0006\u0010\"\u001a\u00020\u0007\u0012\u0006\u0010$\u001a\u00020\u0007\u00a2\u0006\u0004\b%\u0010&J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\t\u0010\u0011R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0016R\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b\u000f\u0010\u001bR\u0017\u0010!\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010\"\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\u001e\u001a\u0004\b\u001d\u0010 R\u0017\u0010$\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b#\u0010\u001e\u001a\u0004\b#\u0010 \u00a8\u0006("}, d2 = {"La24/j;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "d", "()I", "type", "La24/d;", "b", "La24/d;", "()La24/d;", "header", "La24/a;", "c", "La24/a;", "()La24/a;", "robotActivity", "", "La24/g;", "Ljava/util/List;", "()Ljava/util/List;", "items", "e", "Z", "f", "()Z", "isFirstSection", "isEnd", "g", "isRefresh", "<init>", "(ILa24/d;La24/a;Ljava/util/List;ZZZ)V", tl.h.F, "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: a24.j, reason: from toString */
/* loaded from: classes25.dex */
public final /* data */ class CreateCenterPageData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int type;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final d header;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final a robotActivity;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<g> items;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isFirstSection;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isEnd;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isRefresh;

    public CreateCenterPageData(int i3, @Nullable d dVar, @Nullable a aVar, @NotNull List<g> items, boolean z16, boolean z17, boolean z18) {
        Intrinsics.checkNotNullParameter(items, "items");
        this.type = i3;
        this.header = dVar;
        this.robotActivity = aVar;
        this.items = items;
        this.isFirstSection = z16;
        this.isEnd = z17;
        this.isRefresh = z18;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final d getHeader() {
        return this.header;
    }

    @NotNull
    public final List<g> b() {
        return this.items;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final a getRobotActivity() {
        return this.robotActivity;
    }

    /* renamed from: d, reason: from getter */
    public final int getType() {
        return this.type;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getIsEnd() {
        return this.isEnd;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CreateCenterPageData)) {
            return false;
        }
        CreateCenterPageData createCenterPageData = (CreateCenterPageData) other;
        if (this.type == createCenterPageData.type && Intrinsics.areEqual(this.header, createCenterPageData.header) && Intrinsics.areEqual(this.robotActivity, createCenterPageData.robotActivity) && Intrinsics.areEqual(this.items, createCenterPageData.items) && this.isFirstSection == createCenterPageData.isFirstSection && this.isEnd == createCenterPageData.isEnd && this.isRefresh == createCenterPageData.isRefresh) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final boolean getIsFirstSection() {
        return this.isFirstSection;
    }

    /* renamed from: g, reason: from getter */
    public final boolean getIsRefresh() {
        return this.isRefresh;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int i3 = this.type * 31;
        d dVar = this.header;
        int i16 = 0;
        if (dVar == null) {
            hashCode = 0;
        } else {
            hashCode = dVar.hashCode();
        }
        int i17 = (i3 + hashCode) * 31;
        a aVar = this.robotActivity;
        if (aVar != null) {
            i16 = aVar.hashCode();
        }
        int hashCode2 = (((i17 + i16) * 31) + this.items.hashCode()) * 31;
        boolean z16 = this.isFirstSection;
        int i18 = 1;
        int i19 = z16;
        if (z16 != 0) {
            i19 = 1;
        }
        int i26 = (hashCode2 + i19) * 31;
        boolean z17 = this.isEnd;
        int i27 = z17;
        if (z17 != 0) {
            i27 = 1;
        }
        int i28 = (i26 + i27) * 31;
        boolean z18 = this.isRefresh;
        if (!z18) {
            i18 = z18 ? 1 : 0;
        }
        return i28 + i18;
    }

    @NotNull
    public String toString() {
        return "CreateCenterPageData(type=" + this.type + ", header=" + this.header + ", robotActivity=" + this.robotActivity + ", items=" + this.items + ", isFirstSection=" + this.isFirstSection + ", isEnd=" + this.isEnd + ", isRefresh=" + this.isRefresh + ")";
    }
}
