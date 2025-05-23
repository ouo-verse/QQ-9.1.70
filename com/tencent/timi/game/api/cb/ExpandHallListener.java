package com.tencent.timi.game.api.cb;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.timi.game.api.param.ExpandHallLaunchParam;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface ExpandHallListener {

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes26.dex */
    public @interface ExitSource {
    }

    void a(long j3, ExpandHallLaunchParam expandHallLaunchParam);

    void b(long j3, ExpandHallLaunchParam expandHallLaunchParam, int i3, String str);

    boolean c(int i3, ExpandHallLaunchParam expandHallLaunchParam, QBaseActivity qBaseActivity);

    void d(long j3, ExpandHallLaunchParam expandHallLaunchParam, int i3, String str);

    void e(long j3, ExpandHallLaunchParam expandHallLaunchParam, QBaseActivity qBaseActivity);
}
