package com.tencent.mobileqq.qqgamepub.web.delegate;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qqgamepub.mvp.presenter.buisness.QQGameWebPresenter;
import com.tencent.mobileqq.qqgamepub.view.GameSessionView;
import com.tencent.mobileqq.qqgamepub.web.view.GameContentView;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes16.dex */
public class GameContentViewDelegate extends a<QQGameWebPresenter> implements GameContentView.a {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    private GameContentView f264825f;

    /* renamed from: h, reason: collision with root package name */
    private GameSessionView f264826h;

    /* renamed from: i, reason: collision with root package name */
    private View f264827i;

    public GameContentViewDelegate(QQGameWebPresenter qQGameWebPresenter, View view) {
        super(qQGameWebPresenter, view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQGameWebPresenter, (Object) view);
            return;
        }
        GameContentView gameContentView = (GameContentView) view.findViewById(R.id.yee);
        this.f264825f = gameContentView;
        this.f264826h = gameContentView.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(View view, boolean z16) {
        for (ViewParent parent = view.getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
            ((ViewGroup) parent).setClipChildren(z16);
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.web.view.GameContentView.a
    public void M3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        GameContentView gameContentView = this.f264825f;
        if (gameContentView != null) {
            gameContentView.post(new Runnable() { // from class: com.tencent.mobileqq.qqgamepub.web.delegate.GameContentViewDelegate.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GameContentViewDelegate.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        ((QQGameWebPresenter) GameContentViewDelegate.this.f264838d).V();
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.web.view.GameContentView.a
    public void O5(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, j3);
            return;
        }
        GameSessionView gameSessionView = this.f264826h;
        if (gameSessionView != null) {
            gameSessionView.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.qqgamepub.web.delegate.GameContentViewDelegate.2
                static IPatchRedirector $redirector_;

                /* compiled from: P */
                /* renamed from: com.tencent.mobileqq.qqgamepub.web.delegate.GameContentViewDelegate$2$a */
                /* loaded from: classes16.dex */
                class a implements Animation.AnimationListener {
                    static IPatchRedirector $redirector_;

                    a() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this);
                        }
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                            iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
                            return;
                        }
                        GameContentViewDelegate.this.f264826h.setVisibility(8);
                        GameContentViewDelegate gameContentViewDelegate = GameContentViewDelegate.this;
                        gameContentViewDelegate.h(gameContentViewDelegate.f264826h, true);
                        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, -45.0f, 1, 0.5f, 1, 0.5f);
                        rotateAnimation.setRepeatMode(2);
                        rotateAnimation.setRepeatCount(1);
                        rotateAnimation.setDuration(80L);
                        GameContentViewDelegate.this.f264827i.startAnimation(rotateAnimation);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                            iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
                        }
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
                        }
                    }
                }

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GameContentViewDelegate.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (GameContentViewDelegate.this.f264827i == null) {
                        return;
                    }
                    GameContentViewDelegate.this.f264827i.getLocationInWindow(r0);
                    int[] iArr = {iArr[0] + (GameContentViewDelegate.this.f264827i.getWidth() / 2), iArr[1] + (GameContentViewDelegate.this.f264827i.getHeight() / 2)};
                    GameContentViewDelegate.this.f264826h.getLocationInWindow(r2);
                    int height = r2[1] + (GameContentViewDelegate.this.f264826h.getHeight() / 2);
                    int[] iArr2 = {iArr2[0] + (GameContentViewDelegate.this.f264826h.getWidth() / 2), height};
                    iArr[0] = iArr[0] - iArr2[0];
                    iArr[1] = iArr[1] - height;
                    ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.1f, 1.0f, 0.1f, 1, 0.5f, 1, 0.5f);
                    scaleAnimation.setDuration(300L);
                    TranslateAnimation translateAnimation = new TranslateAnimation(GameContentViewDelegate.this.f264826h.getLeft(), r2 + iArr[0], GameContentViewDelegate.this.f264826h.getTop(), r7 + iArr[1]);
                    translateAnimation.setStartOffset(300L);
                    translateAnimation.setDuration(200L);
                    AnimationSet animationSet = new AnimationSet(false);
                    animationSet.addAnimation(scaleAnimation);
                    animationSet.addAnimation(translateAnimation);
                    animationSet.setAnimationListener(new a());
                    GameContentViewDelegate gameContentViewDelegate = GameContentViewDelegate.this;
                    gameContentViewDelegate.h(gameContentViewDelegate.f264826h, false);
                    GameContentViewDelegate.this.f264826h.startAnimation(animationSet);
                }
            }, j3);
        }
    }

    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        QIPCClientHelper.getInstance().callServer("QQGameIPCModule", "doOnDestory", null, null);
        GameContentView gameContentView = this.f264825f;
        if (gameContentView != null) {
            gameContentView.f();
        }
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            QIPCClientHelper.getInstance().callServer("QQGameIPCModule", "doOnResume", null, null);
        }
    }

    public int f() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        GameContentView gameContentView = this.f264825f;
        if (gameContentView != null && gameContentView.getVisibility() == 0) {
            i3 = this.f264825f.a();
        } else {
            i3 = 0;
        }
        if (QLog.isColorLevel()) {
            QLog.d("GameContentViewDelegate", 1, "gameContentHeight=" + i3);
        }
        return i3;
    }

    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        GameContentView gameContentView = this.f264825f;
        if (gameContentView != null) {
            gameContentView.c();
            this.f264825f.setUiRefresh(this);
        }
    }

    public void i(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
        } else {
            this.f264827i = view;
        }
    }
}
