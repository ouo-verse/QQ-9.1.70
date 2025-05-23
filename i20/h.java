package i20;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.beans.QFSReplyItemInfo;
import com.tencent.biz.qqcircle.comment.QFSMoreReplyItemView;
import feedcloud.FeedCloudMeta$StComment;
import feedcloud.FeedCloudMeta$StFeed;

/* compiled from: P */
/* loaded from: classes4.dex */
public class h extends RecyclerView.ViewHolder {
    public h(View view) {
        super(view);
    }

    public void l(QFSReplyItemInfo qFSReplyItemInfo, FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3, FeedCloudMeta$StComment feedCloudMeta$StComment, int i16, com.tencent.biz.qqcircle.widgets.comment.c cVar) {
        View view = this.itemView;
        if (view instanceof QFSMoreReplyItemView) {
            ((QFSMoreReplyItemView) view).setPreData(feedCloudMeta$StFeed, feedCloudMeta$StComment, i16);
            ((QFSMoreReplyItemView) this.itemView).setOnCommentElementClickListener(cVar);
            ((QFSMoreReplyItemView) this.itemView).bindData(qFSReplyItemInfo, i3);
        }
    }
}
