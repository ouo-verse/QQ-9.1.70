package com.tencent.aelight.camera.aioeditor.takevideo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;

/* compiled from: P */
/* loaded from: classes32.dex */
public interface aa {
    void dismissLoadingDialog();

    void finish(int i3, Intent intent, int i16, int i17);

    void finish(int i3, Intent intent, int i16, int i17, boolean z16);

    Activity getActivity();

    Context getContext();

    Intent getPublishIntent(fs.b bVar);

    View getRootView();

    void showLoadingDialog(CharSequence charSequence, boolean z16, long j3);
}
