package gi1;

import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\b\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0017\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lgi1/i;", "Lgi1/b;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "I", "c", "()I", NodeProps.CUSTOM_PROP_IMAGE_TYPE, "b", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "title", "Z", "d", "()Z", "showRefreshButton", "<init>", "(ILjava/lang/String;Z)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: gi1.i, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class EmptyPageData extends b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int imageType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String title;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean showRefreshButton;

    public EmptyPageData(int i3, @NotNull String title, boolean z16) {
        Intrinsics.checkNotNullParameter(title, "title");
        this.imageType = i3;
        this.title = title;
        this.showRefreshButton = z16;
    }

    /* renamed from: c, reason: from getter */
    public final int getImageType() {
        return this.imageType;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getShowRefreshButton() {
        return this.showRefreshButton;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EmptyPageData)) {
            return false;
        }
        EmptyPageData emptyPageData = (EmptyPageData) other;
        if (this.imageType == emptyPageData.imageType && Intrinsics.areEqual(this.title, emptyPageData.title) && this.showRefreshButton == emptyPageData.showRefreshButton) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.imageType * 31) + this.title.hashCode()) * 31;
        boolean z16 = this.showRefreshButton;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode + i3;
    }

    @NotNull
    public String toString() {
        return "EmptyPageData(imageType=" + this.imageType + ", title=" + this.title + ", showRefreshButton=" + this.showRefreshButton + ")";
    }
}
