package com.tencent.mobileqq.richstatus;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.richstatus.comment.bean.CommentItem;
import java.io.Serializable;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class HistorySignItem implements Serializable {
    static IPatchRedirector $redirector_;
    public List<CommentItem> commentItemList;
    public List<com.tencent.mobileqq.richstatus.comment.bean.a> likeItemList;
    public RichStatus richStatus;
    public long totalLikeNum;

    public HistorySignItem() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
