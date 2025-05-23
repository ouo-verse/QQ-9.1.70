package com.tencent.mobileqq.activity.home.chats.callbcak;

import com.tencent.mobileqq.activity.bm;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.ui.ConversationContainer;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes10.dex */
public class c implements a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    Conversation f182999a;

    public c(Conversation conversation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) conversation);
        } else {
            this.f182999a = conversation;
        }
    }

    @Override // com.tencent.mobileqq.activity.home.chats.callbcak.a
    public boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return this.f182999a.mIsChatList;
    }

    @Override // com.tencent.mobileqq.activity.home.chats.callbcak.a
    public FrameHelperActivity b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (FrameHelperActivity) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f182999a.mFrameHelperActivity;
    }

    @Override // com.tencent.mobileqq.activity.home.chats.callbcak.a
    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return this.f182999a.mTitleArea.getHeight();
    }

    @Override // com.tencent.mobileqq.activity.home.chats.callbcak.a
    public MqqHandler d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (MqqHandler) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.f182999a.handler;
    }

    @Override // com.tencent.mobileqq.activity.home.chats.callbcak.a
    public Conversation e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (Conversation) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.f182999a;
    }

    @Override // com.tencent.mobileqq.activity.home.chats.callbcak.a
    public bm f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (bm) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.f182999a.mTitleEntranceCtrlManager;
    }

    @Override // com.tencent.mobileqq.activity.home.chats.callbcak.a
    public boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return this.f182999a.isListFirstItemTop();
    }

    @Override // com.tencent.mobileqq.activity.home.chats.callbcak.a
    public BannerManager getBannerManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (BannerManager) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f182999a.mBannerMang;
    }

    @Override // com.tencent.mobileqq.activity.home.chats.callbcak.a
    public ConversationContainer getRootView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (ConversationContainer) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.f182999a.mRootView;
    }

    @Override // com.tencent.mobileqq.activity.home.chats.callbcak.a
    public boolean h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.f182999a.mIsForeground;
    }

    @Override // com.tencent.mobileqq.activity.home.chats.callbcak.a
    public QQAppInterface i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (QQAppInterface) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.f182999a.getApp();
    }
}
