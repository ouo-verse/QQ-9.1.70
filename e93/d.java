package e93;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0004\u0010\u0006\u00a8\u0006\n"}, d2 = {"Le93/d;", "Le93/a;", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "a", "Ljava/util/List;", "()Ljava/util/List;", "selectedMedia", "<init>", "(Ljava/util/List;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class d extends a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<LocalMediaInfo> selectedMedia;

    /* JADX WARN: Multi-variable type inference failed */
    public d(@NotNull List<? extends LocalMediaInfo> selectedMedia) {
        Intrinsics.checkNotNullParameter(selectedMedia, "selectedMedia");
        this.selectedMedia = selectedMedia;
    }

    @NotNull
    public final List<LocalMediaInfo> a() {
        return this.selectedMedia;
    }
}
