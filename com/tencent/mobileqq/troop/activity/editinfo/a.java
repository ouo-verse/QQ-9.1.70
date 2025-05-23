package com.tencent.mobileqq.troop.activity.editinfo;

import android.content.Context;
import android.content.Intent;
import android.widget.TextView;

/* compiled from: P */
/* loaded from: classes19.dex */
public interface a {
    Context getContext();

    int getLength();

    int getMaxLength();

    String getText();

    TextView getTipsView();

    void hideInputMethod();

    void loadingProgress(boolean z16);

    void onFinish();

    void onFinishForResult(int i3, Intent intent);

    void showInputMethod();

    void updateEditTextAndNum(CharSequence charSequence);
}
