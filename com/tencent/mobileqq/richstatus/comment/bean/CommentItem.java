package com.tencent.mobileqq.richstatus.comment.bean;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes18.dex */
public class CommentItem implements Serializable {
    static IPatchRedirector $redirector_;
    public String content;
    public String feedId;

    /* renamed from: id, reason: collision with root package name */
    public long f282319id;
    public long targetId;
    public long timeStamp;
    public b toReplyUser;
    public b user;

    public CommentItem() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
