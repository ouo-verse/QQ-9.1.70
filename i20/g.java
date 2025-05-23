package i20;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.beans.QFSReplyItemInfo;
import com.tencent.biz.qqcircle.comment.QFSReplyItemView;
import feedcloud.FeedCloudMeta$StComment;
import feedcloud.FeedCloudMeta$StFeed;

/* compiled from: P */
/* loaded from: classes4.dex */
public class g extends RecyclerView.ViewHolder {
    public QFSReplyItemView E;
    private final ViewGroup F;

    public g(View view, ViewGroup viewGroup) {
        super(view);
        this.F = viewGroup;
    }

    public void l(QFSReplyItemInfo qFSReplyItemInfo, FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3, FeedCloudMeta$StComment feedCloudMeta$StComment, int i16, com.tencent.biz.qqcircle.widgets.comment.c cVar) {
        View view = this.itemView;
        if (view instanceof QFSReplyItemView) {
            QFSReplyItemView qFSReplyItemView = (QFSReplyItemView) view;
            this.E = qFSReplyItemView;
            qFSReplyItemView.setPreData(feedCloudMeta$StFeed, feedCloudMeta$StComment, i16);
            this.E.setHostRecyclerView(this.F);
            this.E.setOnCommentElementClickListener(cVar);
            this.E.bindData(qFSReplyItemInfo, i3);
        }
    }
}
