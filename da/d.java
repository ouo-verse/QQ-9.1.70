package da;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B-\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\b\u0002\u0010\u000e\u001a\u00020\n\u00a2\u0006\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0004\u0010\u0006R\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\b\u0010\u0006R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lda/d;", "Lda/a;", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "a", "Ljava/util/List;", "()Ljava/util/List;", "removedMediaList", "b", "selectedMedia", "", "c", "I", "()I", "validStatus", "<init>", "(Ljava/util/List;Ljava/util/List;I)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class d extends a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final List<LocalMediaInfo> removedMediaList;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final List<LocalMediaInfo> selectedMedia;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int validStatus;

    /* JADX WARN: Multi-variable type inference failed */
    public d(List<? extends LocalMediaInfo> removedMediaList, List<? extends LocalMediaInfo> selectedMedia, int i3) {
        Intrinsics.checkNotNullParameter(removedMediaList, "removedMediaList");
        Intrinsics.checkNotNullParameter(selectedMedia, "selectedMedia");
        this.removedMediaList = removedMediaList;
        this.selectedMedia = selectedMedia;
        this.validStatus = i3;
    }

    public final List<LocalMediaInfo> a() {
        return this.removedMediaList;
    }

    public final List<LocalMediaInfo> b() {
        return this.selectedMedia;
    }

    /* renamed from: c, reason: from getter */
    public final int getValidStatus() {
        return this.validStatus;
    }
}
