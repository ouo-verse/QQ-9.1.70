package i20;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.beans.QFSCommentItemInfo;
import com.tencent.biz.qqcircle.comment.QFSFastCommentItemView;
import feedcloud.FeedCloudMeta$StFeed;

/* compiled from: P */
/* loaded from: classes4.dex */
public class c extends RecyclerView.ViewHolder {
    public QFSFastCommentItemView E;

    public c(View view) {
        super(view);
    }

    public void l(int i3, FeedCloudMeta$StFeed feedCloudMeta$StFeed, QFSCommentItemInfo qFSCommentItemInfo, com.tencent.biz.qqcircle.widgets.comment.c cVar) {
        View view = this.itemView;
        if (view instanceof QFSFastCommentItemView) {
            QFSFastCommentItemView qFSFastCommentItemView = (QFSFastCommentItemView) view;
            this.E = qFSFastCommentItemView;
            qFSFastCommentItemView.setFeed(feedCloudMeta$StFeed);
            this.E.setOnCommentElementClickListener(cVar);
            this.E.bindData(qFSCommentItemInfo, i3);
        }
    }
}
