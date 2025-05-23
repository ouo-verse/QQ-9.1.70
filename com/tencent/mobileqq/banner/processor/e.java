package com.tencent.mobileqq.banner.processor;

import android.os.Message;
import android.view.View;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes11.dex */
public interface e {
    @Deprecated
    int defaultTipsBarType();

    int getId();

    View initBanner(com.tencent.mobileqq.banner.a aVar);

    void onAccountChanged();

    void onBeforeAccountChanged(AppRuntime appRuntime);

    void onCreate(a aVar);

    void onMessage(Message message, long j3, boolean z16);

    void updateBanner(com.tencent.mobileqq.banner.a aVar, Message message);
}
