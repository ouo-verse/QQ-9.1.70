package e93;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u0017\u0010\b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\u0007\u0010\u0005R\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\u00a8\u0006\u0011"}, d2 = {"Le93/e;", "Le93/a;", "", "a", "I", "()I", "indexInSelectedMediaFrom", "b", "indexInSelectedMediaTo", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "c", "Ljava/util/List;", "()Ljava/util/List;", "selectedMedia", "<init>", "(IILjava/util/List;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class e extends a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int indexInSelectedMediaFrom;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int indexInSelectedMediaTo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<LocalMediaInfo> selectedMedia;

    /* JADX WARN: Multi-variable type inference failed */
    public e(int i3, int i16, @NotNull List<? extends LocalMediaInfo> selectedMedia) {
        Intrinsics.checkNotNullParameter(selectedMedia, "selectedMedia");
        this.indexInSelectedMediaFrom = i3;
        this.indexInSelectedMediaTo = i16;
        this.selectedMedia = selectedMedia;
    }

    /* renamed from: a, reason: from getter */
    public final int getIndexInSelectedMediaFrom() {
        return this.indexInSelectedMediaFrom;
    }

    /* renamed from: b, reason: from getter */
    public final int getIndexInSelectedMediaTo() {
        return this.indexInSelectedMediaTo;
    }

    @NotNull
    public final List<LocalMediaInfo> c() {
        return this.selectedMedia;
    }
}
