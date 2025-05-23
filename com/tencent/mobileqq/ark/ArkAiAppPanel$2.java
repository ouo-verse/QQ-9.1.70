package com.tencent.mobileqq.ark;

import android.view.View;

/* loaded from: classes11.dex */
class ArkAiAppPanel$2 implements Runnable {
    final /* synthetic */ c this$0;

    @Override // java.lang.Runnable
    public void run() {
        View selectedView = c.c(null).getSelectedView();
        if (selectedView != null) {
            selectedView.setSelected(true);
        }
    }
}
