package com.tencent.qqmini.minigame.ui;

import android.graphics.drawable.Drawable;
import com.tencent.qqmini.minigame.ui.LoadingUI;
import com.tencent.qqmini.sdk.launcher.widget.SquareImageView;

/* compiled from: P */
/* loaded from: classes23.dex */
class LoadingUI$IconDrawableCallback$1 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ Drawable f346762d;
    final /* synthetic */ LoadingUI.a this$0;

    @Override // java.lang.Runnable
    public void run() {
        SquareImageView squareImageView = (SquareImageView) LoadingUI.a.a(null).get();
        if (squareImageView != null) {
            squareImageView.setImageDrawable(this.f346762d);
        }
    }
}
