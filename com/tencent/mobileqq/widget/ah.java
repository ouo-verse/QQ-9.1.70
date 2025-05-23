package com.tencent.mobileqq.widget;

import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.mobileqq.vas.profilecard.util.LevelUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ah implements URLDrawableDownListener {

    /* renamed from: d, reason: collision with root package name */
    final WeakReference<View> f316612d;

    /* renamed from: e, reason: collision with root package name */
    final String f316613e;

    /* renamed from: f, reason: collision with root package name */
    final String f316614f;

    public ah(View view, String str, String str2) {
        this.f316612d = new WeakReference<>(view);
        this.f316614f = str;
        this.f316613e = str2;
    }

    @Override // com.tencent.image.URLDrawableDownListener
    public void onLoadFailed(View view, URLDrawable uRLDrawable, Throwable th5) {
        View view2 = this.f316612d.get();
        if (view2 != null) {
            QLog.e(LevelUtil.PROFILE_CARD_TAG, 1, this.f316613e + this.f316614f);
            view2.setVisibility(8);
        }
    }

    @Override // com.tencent.image.URLDrawableDownListener
    public void onLoadSuccessed(View view, URLDrawable uRLDrawable) {
        View view2 = this.f316612d.get();
        if (view2 != null) {
            view2.setVisibility(0);
        }
    }

    @Override // com.tencent.image.URLDrawableDownListener
    public void onLoadCancelled(View view, URLDrawable uRLDrawable) {
    }

    @Override // com.tencent.image.URLDrawableDownListener
    public void onLoadInterrupted(View view, URLDrawable uRLDrawable, InterruptedException interruptedException) {
    }

    @Override // com.tencent.image.URLDrawableDownListener
    public void onLoadProgressed(View view, URLDrawable uRLDrawable, int i3) {
    }
}
