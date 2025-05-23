package da;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\t\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u0017\u0010\u000b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\nR\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000fR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0011\u0010\u0005\u00a8\u0006\u0015"}, d2 = {"Lda/f;", "Lda/a;", "", "a", "I", "()I", "indexInSelectedMedia", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "b", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "()Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "removedMedia", "", "c", "Ljava/util/List;", "()Ljava/util/List;", "selectedMedia", "d", "validStatus", "<init>", "(ILcom/tencent/mobileqq/activity/photo/LocalMediaInfo;Ljava/util/List;I)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class f extends a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int indexInSelectedMedia;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final LocalMediaInfo removedMedia;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final List<LocalMediaInfo> selectedMedia;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int validStatus;

    /* JADX WARN: Multi-variable type inference failed */
    public f(int i3, LocalMediaInfo removedMedia, List<? extends LocalMediaInfo> selectedMedia, int i16) {
        Intrinsics.checkNotNullParameter(removedMedia, "removedMedia");
        Intrinsics.checkNotNullParameter(selectedMedia, "selectedMedia");
        this.indexInSelectedMedia = i3;
        this.removedMedia = removedMedia;
        this.selectedMedia = selectedMedia;
        this.validStatus = i16;
    }

    /* renamed from: a, reason: from getter */
    public final int getIndexInSelectedMedia() {
        return this.indexInSelectedMedia;
    }

    /* renamed from: b, reason: from getter */
    public final LocalMediaInfo getRemovedMedia() {
        return this.removedMedia;
    }

    public final List<LocalMediaInfo> c() {
        return this.selectedMedia;
    }

    /* renamed from: d, reason: from getter */
    public final int getValidStatus() {
        return this.validStatus;
    }
}
