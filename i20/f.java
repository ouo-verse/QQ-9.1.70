package i20;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.beans.QFSCommentItemInfo;
import com.tencent.biz.qqcircle.comment.QFSCommentShareAdItemView;
import feedcloud.FeedCloudMeta$StFeed;

/* compiled from: P */
/* loaded from: classes4.dex */
public class f extends RecyclerView.ViewHolder {
    private QFSCommentShareAdItemView E;

    public f(@NonNull View view) {
        super(view);
    }

    public void l(int i3, FeedCloudMeta$StFeed feedCloudMeta$StFeed, QFSCommentItemInfo qFSCommentItemInfo, com.tencent.biz.qqcircle.widgets.comment.c cVar) {
        View view = this.itemView;
        if (view instanceof QFSCommentShareAdItemView) {
            QFSCommentShareAdItemView qFSCommentShareAdItemView = (QFSCommentShareAdItemView) view;
            this.E = qFSCommentShareAdItemView;
            qFSCommentShareAdItemView.setFeed(feedCloudMeta$StFeed);
            this.E.setOnCommentElementClickListener(cVar);
            this.E.bindData(qFSCommentItemInfo, i3);
        }
    }
}
