package com.tencent.mobileqq.emotionintegrate;

import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.emoticonview.IStickerGestureDetector;
import com.tencent.mobileqq.emoticonview.api.IRecommendEmotionService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes12.dex */
public class EmotionKeywordLayout extends RelativeLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    a61.b f205163d;

    /* renamed from: e, reason: collision with root package name */
    ViewGroup f205164e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f205165f;

    /* renamed from: h, reason: collision with root package name */
    public boolean f205166h;

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.onAttachedToWindow();
        Object tag = getTag();
        if (!(tag instanceof com.tencent.mobileqq.activity.aio.stickerrecommended.adapter.mvp.c)) {
            return;
        }
        ((com.tencent.mobileqq.activity.aio.stickerrecommended.adapter.mvp.c) tag).getPresenter();
        throw null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.onDetachedFromWindow();
        Object tag = getTag();
        if (!(tag instanceof com.tencent.mobileqq.activity.aio.stickerrecommended.adapter.mvp.c)) {
            return;
        }
        ((com.tencent.mobileqq.activity.aio.stickerrecommended.adapter.mvp.c) tag).getPresenter();
        throw null;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ViewGroup viewGroup;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) motionEvent)).booleanValue();
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    if (QLog.isColorLevel()) {
                        QLog.i("EmotionKeywordLayout", 2, "EmotionKeywordLayout.onTouchEvent ACTION_MOVE");
                    }
                    if (this.f205165f && (viewGroup = this.f205164e) != null) {
                        if (!this.f205166h && (viewGroup instanceof TopGestureLayout)) {
                            Object gestureDetector = ((TopGestureLayout) viewGroup).getGestureDetector();
                            if (gestureDetector instanceof IStickerGestureDetector) {
                                IStickerGestureDetector iStickerGestureDetector = (IStickerGestureDetector) gestureDetector;
                                iStickerGestureDetector.setLastX(motionEvent.getRawX());
                                iStickerGestureDetector.setLastY(motionEvent.getRawY());
                                this.f205166h = true;
                            }
                        }
                        this.f205164e.onTouchEvent(motionEvent);
                        return true;
                    }
                }
            } else {
                if (QLog.isColorLevel()) {
                    QLog.i("EmotionKeywordLayout", 2, "EmotionKeywordLayout.onTouchEvent ACTION_UP");
                }
                if (this.f205165f && this.f205164e != null) {
                    ((IRecommendEmotionService) QRoute.api(IRecommendEmotionService.class)).onEmotionKeywordDimiss(this.f205163d);
                    this.f205165f = false;
                    this.f205166h = false;
                    this.f205164e.onTouchEvent(motionEvent);
                    return true;
                }
                this.f205165f = false;
                this.f205166h = false;
            }
        } else {
            if (QLog.isColorLevel()) {
                QLog.i("EmotionKeywordLayout", 2, "EmotionKeywordLayout.onTouchEvent ACTION_DOWN");
            }
            this.f205166h = false;
            this.f205165f = false;
        }
        return super.onTouchEvent(motionEvent);
    }
}
