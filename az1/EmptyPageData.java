package az1;

import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\b\u001a\u00020\u0002H\u00d6\u0001J\u0013\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u00d6\u0003R\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0016\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Laz1/b;", "Laz1/a;", "", "e", "", "getItemId", "", "toString", "hashCode", "", "other", "", "equals", "b", "I", "d", "()I", NodeProps.CUSTOM_PROP_IMAGE_TYPE, "c", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "title", "<init>", "(ILjava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: az1.b, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class EmptyPageData extends a {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int imageType;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String title;

    public EmptyPageData(int i3, @NotNull String title) {
        Intrinsics.checkNotNullParameter(title, "title");
        this.imageType = i3;
        this.title = title;
    }

    /* renamed from: d, reason: from getter */
    public final int getImageType() {
        return this.imageType;
    }

    public int e() {
        return 3;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EmptyPageData)) {
            return false;
        }
        EmptyPageData emptyPageData = (EmptyPageData) other;
        if (this.imageType == emptyPageData.imageType && Intrinsics.areEqual(this.title, emptyPageData.title)) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @Override // az1.d
    public long getItemId() {
        return Objects.hash(Integer.valueOf(e()), this.title);
    }

    public int hashCode() {
        return (this.imageType * 31) + this.title.hashCode();
    }

    @NotNull
    public String toString() {
        return "EmptyPageData(imageType=" + this.imageType + ", title=" + this.title + ")";
    }
}
