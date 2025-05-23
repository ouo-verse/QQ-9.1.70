package i20;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.beans.QFSCommentItemInfo;
import com.tencent.biz.qqcircle.comment.QFSCommentFeedDescItemView;
import feedcloud.FeedCloudMeta$StFeed;

/* compiled from: P */
/* loaded from: classes4.dex */
public class d extends RecyclerView.ViewHolder {
    public QFSCommentFeedDescItemView E;

    public d(View view) {
        super(view);
    }

    public void l(int i3, FeedCloudMeta$StFeed feedCloudMeta$StFeed, QFSCommentItemInfo qFSCommentItemInfo, com.tencent.biz.qqcircle.widgets.comment.c cVar) {
        View view = this.itemView;
        if (view instanceof QFSCommentFeedDescItemView) {
            QFSCommentFeedDescItemView qFSCommentFeedDescItemView = (QFSCommentFeedDescItemView) view;
            this.E = qFSCommentFeedDescItemView;
            qFSCommentFeedDescItemView.setFeed(feedCloudMeta$StFeed);
            this.E.setOnCommentElementClickListener(cVar);
            this.E.bindData(qFSCommentItemInfo, i3);
        }
    }
}
