package com.tencent.qqnt.textpreview.inject;

import android.app.Activity;
import com.tencent.mobileqq.activity.fling.FlingHandler;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.qqnt.textpreview.PreviewTextContainerView;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes25.dex */
public interface d {
    c<?> a();

    void b(AppRuntime appRuntime, String str, String str2, String str3, String str4, String str5, int i3, int i16, String str6, String str7, String str8, String str9);

    boolean c();

    PreviewTextContainerView d(Activity activity);

    List<b> e();

    e f();

    void g(QBaseActivity qBaseActivity, FlingHandler flingHandler);

    f h();
}
