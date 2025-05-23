package i20;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.comment.QFSCommentFeedbackItemView;
import feedcloud.FeedCloudMeta$StFeed;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0006\u00a2\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\r"}, d2 = {"Li20/e;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lfeedcloud/FeedCloudMeta$StFeed;", "feed", "", "l", "Lcom/tencent/biz/qqcircle/comment/QFSCommentFeedbackItemView;", "E", "Lcom/tencent/biz/qqcircle/comment/QFSCommentFeedbackItemView;", "feedbackItemView", "itemView", "<init>", "(Lcom/tencent/biz/qqcircle/comment/QFSCommentFeedbackItemView;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class e extends RecyclerView.ViewHolder {

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final QFSCommentFeedbackItemView feedbackItemView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(@NotNull QFSCommentFeedbackItemView itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        this.feedbackItemView = itemView;
    }

    public final void l(@NotNull FeedCloudMeta$StFeed feed) {
        Intrinsics.checkNotNullParameter(feed, "feed");
        this.feedbackItemView.setFeed(feed);
    }
}
