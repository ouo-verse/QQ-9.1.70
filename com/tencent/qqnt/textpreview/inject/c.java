package com.tencent.qqnt.textpreview.inject;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.qqnt.textpreview.PreviewTextContainerView;

/* compiled from: P */
/* loaded from: classes25.dex */
public interface c<T extends QBaseActivity> {
    void a(T t16, PreviewTextContainerView previewTextContainerView);

    void b(PreviewTextContainerView previewTextContainerView);

    void c(String str);

    boolean onBackPress();

    void onPause();

    void onResume();
}
