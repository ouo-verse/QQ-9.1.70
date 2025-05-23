package com.tencent.mobileqq.activity.aio.audiopanel;

import android.os.Handler;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes10.dex */
public interface j extends com.tencent.mvp.c {
    AppActivity a();

    void b();

    Handler c();

    void d(String str);

    void e(String str);

    void f(int i3);

    AppRuntime getApp();

    void reset();

    void setRecordTime(String str);

    void startRecord();
}
