package n84;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.sqshow.zootopia.widget.media.ZPlanMediaView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Ln84/a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/sqshow/zootopia/widget/media/ZPlanMediaView;", "E", "Lcom/tencent/sqshow/zootopia/widget/media/ZPlanMediaView;", "l", "()Lcom/tencent/sqshow/zootopia/widget/media/ZPlanMediaView;", "mediaView", "<init>", "(Lcom/tencent/sqshow/zootopia/widget/media/ZPlanMediaView;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a extends RecyclerView.ViewHolder {

    /* renamed from: E, reason: from kotlin metadata */
    private final ZPlanMediaView mediaView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(ZPlanMediaView mediaView) {
        super(mediaView);
        Intrinsics.checkNotNullParameter(mediaView, "mediaView");
        this.mediaView = mediaView;
    }

    /* renamed from: l, reason: from getter */
    public final ZPlanMediaView getMediaView() {
        return this.mediaView;
    }
}
