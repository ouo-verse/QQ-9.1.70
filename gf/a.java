package gf;

import android.content.Intent;
import android.view.View;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.ClickedComment;
import com.qzone.proxy.feedcomponent.model.Comment;
import com.qzone.proxy.feedcomponent.model.Reply;

/* compiled from: P */
/* loaded from: classes38.dex */
public interface a {
    void H7(View view, BusinessFeedData businessFeedData, Comment comment, Reply reply, int i3);

    void a9(Intent intent);

    void c1(BusinessFeedData businessFeedData, ClickedComment clickedComment, int i3);

    void f6(com.qzone.reborn.feedx.bean.b bVar);

    void s6(com.qzone.reborn.feedx.bean.c cVar);

    void x1(ClickedComment clickedComment);

    void z1(BusinessFeedData businessFeedData, ClickedComment clickedComment, int i3);
}
