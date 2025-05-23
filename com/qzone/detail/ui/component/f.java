package com.qzone.detail.ui.component;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.qzone.detail.ui.comment.CommentListBaseController;
import com.qzone.proxy.feedcomponent.model.Comment;
import com.qzone.proxy.feedcomponent.model.Reply;
import com.tencent.mobileqq.R;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public class f extends FeedElementBaseClickListener {
    public f(Activity activity, b bVar) {
        super(activity, bVar);
    }

    @Override // com.qzone.detail.ui.component.FeedElementBaseClickListener
    protected void e0(View view, Object obj) {
        List<Reply> list;
        b bVar = this.f46969e.get();
        if (bVar == null) {
            return;
        }
        int i3 = ((Bundle) obj).getInt("reply_pos", -1);
        Comment comment = CommentListBaseController.B0;
        Reply reply = (i3 == -1 || comment == null || (list = comment.replies) == null || i3 >= list.size()) ? null : comment.replies.get(i3);
        view.setTag(R.id.jam, Boolean.TRUE);
        bVar.p6(view, comment, reply, 0, 100);
    }

    @Override // com.qzone.detail.ui.component.FeedElementBaseClickListener
    protected void y(View view, Object obj) {
        b bVar = this.f46969e.get();
        if (bVar == null) {
            return;
        }
        bVar.pc(view, CommentListBaseController.B0, null, 0, 100);
    }
}
