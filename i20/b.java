package i20;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.beans.QFSCommentItemInfo;
import com.tencent.biz.qqcircle.comment.QFSCommentDefaultItemView;
import feedcloud.FeedCloudMeta$StFeed;

/* compiled from: P */
/* loaded from: classes4.dex */
public class b extends RecyclerView.ViewHolder {
    public QFSCommentDefaultItemView E;
    private final ViewGroup F;

    public b(View view, ViewGroup viewGroup) {
        super(view);
        this.F = viewGroup;
    }

    public void l(int i3, FeedCloudMeta$StFeed feedCloudMeta$StFeed, QFSCommentItemInfo qFSCommentItemInfo, com.tencent.biz.qqcircle.widgets.comment.c cVar) {
        m(i3, feedCloudMeta$StFeed, qFSCommentItemInfo, cVar, true);
    }

    public void m(int i3, FeedCloudMeta$StFeed feedCloudMeta$StFeed, QFSCommentItemInfo qFSCommentItemInfo, com.tencent.biz.qqcircle.widgets.comment.c cVar, boolean z16) {
        View view = this.itemView;
        if (view instanceof QFSCommentDefaultItemView) {
            ((QFSCommentDefaultItemView) view).setEnableReplyList(z16);
            ((QFSCommentDefaultItemView) this.itemView).setFeed(feedCloudMeta$StFeed);
            ((QFSCommentDefaultItemView) this.itemView).setHostRecyclerView(this.F);
            ((QFSCommentDefaultItemView) this.itemView).setOnCommentElementClickListener(cVar);
            ((QFSCommentDefaultItemView) this.itemView).bindData(qFSCommentItemInfo, i3);
            this.E = (QFSCommentDefaultItemView) this.itemView;
        }
    }
}
