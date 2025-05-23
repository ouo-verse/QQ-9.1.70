package com.qzone.detail.ui.comment;

import android.text.TextUtils;
import com.qzone.adapter.feedcomponent.i;
import com.qzone.common.event.Event;
import com.qzone.common.event.EventCenter;
import com.qzone.common.event.IObserver;
import com.qzone.proxy.feedcomponent.model.Comment;
import com.qzone.proxy.feedcomponent.model.Reply;
import com.qzone.proxy.feedcomponent.model.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class b implements IObserver.background {
    public b() {
        a();
    }

    private void a() {
        EventCenter.getInstance().addObserver(this, 3, "WriteOperation", 58, 59, 5, 20, 20, 16);
    }

    private void c() {
        EventCenter.getInstance().removeObserver(this);
    }

    private void d(String str, String str2, boolean z16, int i3) {
        Comment comment = CommentListBaseController.B0;
        if (comment == null || TextUtils.isEmpty(str2) || !str2.equals(comment.commentid) || comment.isliked == z16) {
            return;
        }
        comment.isliked = z16;
        comment.likeNum += z16 ? 1 : -1;
    }

    private void e(String str, String str2, String str3, boolean z16, int i3, String str4, boolean z17, int i16) {
        Comment comment = CommentListBaseController.B0;
        if (comment == null || TextUtils.isEmpty(str4) || !str4.equals(comment.commentid) || comment.isliked == z17) {
            return;
        }
        comment.isliked = z17;
        comment.likeNum += z17 ? 1 : -1;
    }

    private void f(String str, String str2, String str3) {
        List<Reply> list;
        Comment comment = CommentListBaseController.B0;
        if (comment == null || TextUtils.isEmpty(str2) || !str2.equals(comment.commentid) || TextUtils.isEmpty(str3) || (list = comment.replies) == null || list.size() == 0) {
            return;
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            Reply reply = list.get(i3);
            if (reply != null && str3.equals(reply.replyId)) {
                comment.replyNum--;
                list.remove(reply);
                return;
            }
        }
    }

    private void h(String str, String str2, String str3, String str4, User user, Map<String, String> map) {
        Comment comment = CommentListBaseController.B0;
        if (comment == null || TextUtils.isEmpty(str3) || !str3.equals(comment.commentid)) {
            return;
        }
        b(comment, user, str4, str2, map);
    }

    private void i(String str, String str2, boolean z16, String str3, String str4, int i3, int i16, int i17) {
        String str5;
        List<Reply> list;
        List<Reply> list2;
        Comment comment = CommentListBaseController.B0;
        if (comment == null || (str5 = comment.commentid) == null || !str5.equals(str3) || (list = comment.replies) == null || list.size() <= 0 || (list2 = comment.replies) == null || list2.size() == 0) {
            return;
        }
        for (int size = list2.size() - 1; size >= 0; size--) {
            Reply reply = list2.get(size);
            String str6 = reply.fakeUinKey;
            if (str6 != null && str6.equals(str2)) {
                if (z16) {
                    reply.isFake = false;
                    reply.replyId = str4;
                    return;
                } else {
                    list2.remove(reply);
                    comment.replyNum--;
                    return;
                }
            }
        }
    }

    public void g() {
        c();
    }

    @Override // com.qzone.common.event.IObserver.background
    public void onEventBackgroundThread(Event event) {
        Object[] objArr = (Object[]) event.params;
        if ("WriteOperation".equals(event.source.getName())) {
            int i3 = event.what;
            if (i3 == 5) {
                h((String) objArr[0], (String) objArr[1], (String) objArr[2], (String) objArr[3], (User) objArr[5], (Map) objArr[7]);
                return;
            }
            if (i3 == 16) {
                f((String) objArr[0], (String) objArr[1], (String) objArr[2]);
                return;
            }
            if (i3 == 20) {
                i((String) objArr[0], (String) objArr[1], ((Boolean) objArr[2]).booleanValue(), (String) objArr[3], (String) objArr[5], ((Integer) objArr[6]).intValue(), ((Integer) objArr[7]).intValue(), ((Integer) objArr[8]).intValue());
            } else if (i3 == 58) {
                d((String) objArr[0], (String) objArr[1], ((Boolean) objArr[2]).booleanValue(), ((Integer) objArr[3]).intValue());
            } else {
                if (i3 != 59) {
                    return;
                }
                e((String) objArr[0], (String) objArr[1], (String) objArr[2], ((Boolean) objArr[3]).booleanValue(), ((Integer) objArr[4]).intValue(), (String) objArr[5], ((Boolean) objArr[6]).booleanValue(), ((Integer) objArr[7]).intValue());
            }
        }
    }

    private boolean b(Comment comment, User user, String str, String str2, Map<String, String> map) {
        if (comment == null) {
            return false;
        }
        Reply reply = new Reply();
        User user2 = new User();
        reply.user = user2;
        user2.set(i.H().j0(), i.H().k0());
        reply.content = str;
        reply.isFake = true;
        reply.targetUser = user;
        reply.fakeUinKey = str2;
        reply.extendInfo = map;
        List<Reply> list = comment.replies;
        if (list != null && list.size() > 0) {
            for (int i3 = 0; i3 < comment.replies.size(); i3++) {
                if (comment.replies.get(i3).fakeUinKey.equals(reply.fakeUinKey)) {
                    return false;
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        List<Reply> list2 = comment.replies;
        if (list2 != null) {
            arrayList.addAll(list2);
        }
        arrayList.add(reply);
        comment.replies = arrayList;
        comment.replyNum++;
        return true;
    }
}
