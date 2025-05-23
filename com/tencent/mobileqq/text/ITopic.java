package com.tencent.mobileqq.text;

import android.view.View;

/* compiled from: P */
/* loaded from: classes18.dex */
public interface ITopic {

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface OnTopicClickListener {
        void onClick(ITopic iTopic, View view);
    }

    Object getData();

    void onClick(View view);

    void setCustomFont(boolean z16);

    void setPressed(View view, boolean z16);
}
