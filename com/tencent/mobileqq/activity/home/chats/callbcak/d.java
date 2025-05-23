package com.tencent.mobileqq.activity.home.chats.callbcak;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.activity.framebusiness.controllerinject.TabDataHelper;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.home.chats.NtBasePartFrame;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.cv;

/* compiled from: P */
/* loaded from: classes10.dex */
public class d implements com.tencent.qqnt.chats.core.ui.listener.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    Conversation f183000a;

    /* renamed from: b, reason: collision with root package name */
    NtBasePartFrame f183001b;

    public d(Conversation conversation, NtBasePartFrame ntBasePartFrame) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) conversation, (Object) ntBasePartFrame);
        } else {
            this.f183000a = conversation;
            this.f183001b = ntBasePartFrame;
        }
    }

    @Override // com.tencent.qqnt.chats.core.ui.listener.a
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.f183001b.g();
        }
    }

    @Override // com.tencent.qqnt.chats.core.ui.listener.a
    public void b(@NonNull RecyclerView recyclerView, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, recyclerView, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.f183001b.O(recyclerView, i3, i16);
        }
    }

    @Override // com.tencent.qqnt.chats.core.ui.listener.a
    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            cv.a(TabDataHelper.TAB_CONVERSATION);
        }
    }

    @Override // com.tencent.qqnt.chats.core.ui.listener.a
    public void d(@NonNull RecyclerView recyclerView, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) recyclerView, i3);
        } else {
            this.f183001b.N(recyclerView, i3);
        }
    }
}
