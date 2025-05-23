package com.tencent.mobileqq.activity.home.chats.callbcak;

import com.tencent.mobileqq.activity.bm;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.ui.ConversationContainer;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes10.dex */
public interface a {
    boolean a();

    FrameHelperActivity b();

    int c();

    MqqHandler d();

    Conversation e();

    bm f();

    boolean g();

    BannerManager getBannerManager();

    ConversationContainer getRootView();

    boolean h();

    QQAppInterface i();
}
