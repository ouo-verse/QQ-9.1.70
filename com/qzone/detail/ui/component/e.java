package com.qzone.detail.ui.component;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.qzone.detail.ui.comment.CommentListBaseController;
import com.qzone.proxy.feedcomponent.model.Comment;
import com.qzone.proxy.feedcomponent.model.Reply;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public class e extends FeedElementBaseClickListener {
    public e(Activity activity, b bVar) {
        super(activity, bVar);
    }

    @Override // com.qzone.detail.ui.component.FeedElementBaseClickListener
    protected void e0(View view, Object obj) {
        List<Reply> list;
        Reply reply;
        List<Reply> list2;
        b bVar = this.f46969e.get();
        if (bVar == null) {
            return;
        }
        if (bVar.getAppid() == 334) {
            bVar.Pd();
            return;
        }
        Bundle bundle = (Bundle) obj;
        int i3 = bundle.getInt("position");
        int i16 = bundle.getInt("reply_pos", -1);
        int i17 = bundle.getInt("commenttype", 0);
        Comment comment = CommentListBaseController.A0;
        if (i17 == 0) {
            if (i16 != -1 && comment != null && (list2 = comment.replies) != null && i16 < list2.size()) {
                reply = comment.replies.get(i16);
            }
            reply = null;
        } else {
            if (i17 == 1 && i16 != -1 && comment != null && (list = comment.replies) != null && i16 < list.size()) {
                reply = comment.replies.get(i16);
            }
            reply = null;
        }
        bVar.p6(view, comment, reply, i3, 100);
    }

    @Override // com.qzone.detail.ui.component.FeedElementBaseClickListener
    protected void y(View view, Object obj) {
        b bVar = this.f46969e.get();
        if (bVar == null) {
            return;
        }
        bVar.pc(view, CommentListBaseController.A0, null, ((Bundle) obj).getInt("position"), 100);
    }
}
