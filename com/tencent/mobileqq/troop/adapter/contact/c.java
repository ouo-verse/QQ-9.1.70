package com.tencent.mobileqq.troop.adapter.contact;

import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes19.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f293804a;

    /* renamed from: b, reason: collision with root package name */
    public TroopInfo f293805b;

    /* renamed from: c, reason: collision with root package name */
    public DiscussionInfo f293806c;

    /* renamed from: d, reason: collision with root package name */
    public int f293807d;

    public c(int i3, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3, obj);
            return;
        }
        this.f293804a = i3;
        if (obj instanceof TroopInfo) {
            this.f293805b = (TroopInfo) obj;
        } else if (obj instanceof DiscussionInfo) {
            this.f293806c = (DiscussionInfo) obj;
        }
    }

    public c(int i3, DiscussionInfo discussionInfo, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), discussionInfo, Integer.valueOf(i16));
            return;
        }
        this.f293804a = i3;
        this.f293806c = discussionInfo;
        this.f293807d = i16;
    }
}
