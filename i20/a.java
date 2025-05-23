package i20;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.beans.QFSCommentItemInfo;
import com.tencent.biz.qqcircle.comment.QFSCommentAdDescItemView;
import feedcloud.FeedCloudMeta$StFeed;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a extends RecyclerView.ViewHolder {
    public QFSCommentAdDescItemView E;

    public a(View view) {
        super(view);
    }

    public void l(int i3, QFSCommentItemInfo qFSCommentItemInfo, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        View view = this.itemView;
        if (view instanceof QFSCommentAdDescItemView) {
            QFSCommentAdDescItemView qFSCommentAdDescItemView = (QFSCommentAdDescItemView) view;
            this.E = qFSCommentAdDescItemView;
            qFSCommentAdDescItemView.setFeed(feedCloudMeta$StFeed);
            this.E.bindData(qFSCommentItemInfo, i3);
        }
    }
}
