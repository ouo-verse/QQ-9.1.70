package com.tencent.mobileqq.qqgamepub.utils;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.avcore.jni.codec.HWColorFormat;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.qqgamepub.view.GameSessionView;
import com.tencent.mobileqq.qqgamepub.web.view.GameContentView;
import com.tencent.mobileqq.utils.en;
import com.tencent.mtt.hippy.views.list.HippyListView;
import com.tencent.mtt.supportui.views.recyclerview.LinearLayoutManager;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QQGameUIHelper {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static View f264698a;

    public static void b() {
        f264698a = null;
    }

    public static int c(HippyListView hippyListView) {
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) hippyListView.getLayoutManager();
        int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        View findViewByPosition = linearLayoutManager.findViewByPosition(findFirstVisibleItemPosition);
        if (findViewByPosition != null) {
            return (findFirstVisibleItemPosition * findViewByPosition.getHeight()) - findViewByPosition.getTop();
        }
        return 0;
    }

    public static void d(LinearLayout linearLayout, Context context) {
        linearLayout.removeAllViews();
        TextView textView = new TextView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = g.a(7.0f, context.getResources());
        textView.setText(HardCodeUtil.qqStr(R.string.f17638314));
        textView.setTextColor(HWColorFormat.COLOR_FormatVendorStartUnused);
        ImageView imageView = new ImageView(context);
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mFailedDrawable = MobileQQ.sMobileQQ.getResources().getDrawable(R.drawable.fos);
        obtain.mLoadingDrawable = MobileQQ.sMobileQQ.getResources().getDrawable(R.drawable.fos);
        imageView.setImageDrawable(URLDrawable.getDrawable(MiniGamePublicAccountConst.HEAD_REFRESH, obtain));
        imageView.setVisibility(0);
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 359.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setDuration(1000L);
        imageView.startAnimation(rotateAnimation);
        linearLayout.addView(imageView, new LinearLayout.LayoutParams(g.a(15.0f, MobileQQ.sMobileQQ.getResources()), g.a(15.0f, MobileQQ.sMobileQQ.getResources())));
        linearLayout.addView(textView, layoutParams);
    }

    public static void e(View view, LinearLayout linearLayout, Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i3 = displayMetrics.heightPixels;
        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.eet);
        int a16 = g.a(418.0f, MobileQQ.sMobileQQ.getResources());
        ViewGroup.LayoutParams layoutParams = linearLayout2.getLayoutParams();
        layoutParams.height = g.a(i3 - a16, MobileQQ.sMobileQQ.getResources());
        linearLayout2.setLayoutParams(layoutParams);
        com.tencent.mobileqq.qwallet.preload.a.h();
        com.tencent.mobileqq.qwallet.preload.a.j(MiniGamePublicAccountConst.QQGAME_WEB_LOADING_APNG, false, 0);
        d(linearLayout2, context);
    }

    public static Pair<TextView, RelativeLayout.LayoutParams> f(QQGameMsgInfo qQGameMsgInfo, Context context) {
        TextView textView = new TextView(context);
        textView.setTextColor(-1);
        textView.setTextSize(1, 10.0f);
        textView.setBackgroundColor(0);
        textView.setText(en.d(context, 3, qQGameMsgInfo.msgTime * 1000));
        textView.setPadding(12, 0, 12, 0);
        textView.setId(R.id.f97385k9);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) textView.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(-2, g.a(15.0f, MobileQQ.sMobileQQ.getResources()));
        }
        textView.setGravity(17);
        layoutParams.addRule(14);
        layoutParams.addRule(10);
        textView.bringToFront();
        return new Pair<>(textView, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(View view, boolean z16) {
        for (ViewParent parent = view.getParent(); parent != null && (parent instanceof ViewGroup); parent = parent.getParent()) {
            ((ViewGroup) parent).setClipChildren(z16);
        }
    }

    public static void h(long j3, GameContentView gameContentView, View view) {
        if (gameContentView != null) {
            gameContentView.postDelayed(new Runnable(view) { // from class: com.tencent.mobileqq.qqgamepub.utils.QQGameUIHelper.1
                static IPatchRedirector $redirector_;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ View f264700e;

                /* compiled from: P */
                /* renamed from: com.tencent.mobileqq.qqgamepub.utils.QQGameUIHelper$1$a */
                /* loaded from: classes16.dex */
                class a implements Animation.AnimationListener {
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ GameSessionView f264701d;

                    a(GameSessionView gameSessionView) {
                        this.f264701d = gameSessionView;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this, (Object) gameSessionView);
                        }
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                            iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
                            return;
                        }
                        this.f264701d.setVisibility(8);
                        QQGameUIHelper.g(this.f264701d, true);
                        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, -45.0f, 1, 0.5f, 1, 0.5f);
                        rotateAnimation.setRepeatMode(2);
                        rotateAnimation.setRepeatCount(1);
                        rotateAnimation.setDuration(80L);
                        AnonymousClass1.this.f264700e.startAnimation(rotateAnimation);
                        this.f264701d.u();
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
                    this.f264700e = view;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) GameContentView.this, (Object) view);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    GameSessionView b16 = GameContentView.this.b();
                    if (b16 == null) {
                        return;
                    }
                    this.f264700e.getLocationInWindow(r2);
                    int[] iArr = {iArr[0] + (this.f264700e.getWidth() / 2), iArr[1] + (this.f264700e.getHeight() / 2)};
                    b16.getLocationInWindow(r3);
                    int height = r3[1] + (b16.getHeight() / 2);
                    int[] iArr2 = {iArr2[0] + (b16.getWidth() / 2), height};
                    iArr[0] = iArr[0] - iArr2[0];
                    iArr[1] = iArr[1] - height;
                    ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.1f, 1.0f, 0.1f, 1, 0.5f, 1, 0.5f);
                    scaleAnimation.setDuration(300L);
                    TranslateAnimation translateAnimation = new TranslateAnimation(b16.getLeft(), r3 + iArr[0], b16.getTop(), r8 + iArr[1]);
                    translateAnimation.setStartOffset(300L);
                    translateAnimation.setDuration(200L);
                    AnimationSet animationSet = new AnimationSet(false);
                    animationSet.addAnimation(scaleAnimation);
                    animationSet.addAnimation(translateAnimation);
                    animationSet.setAnimationListener(new a(b16));
                    QQGameUIHelper.g(b16, false);
                    b16.startAnimation(animationSet);
                }
            }, j3);
        }
    }

    public static void i(long j3, GameSessionView gameSessionView, View view) {
        if (gameSessionView != null) {
            gameSessionView.postDelayed(new Runnable(view) { // from class: com.tencent.mobileqq.qqgamepub.utils.QQGameUIHelper.2
                static IPatchRedirector $redirector_;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ View f264704e;

                /* compiled from: P */
                /* renamed from: com.tencent.mobileqq.qqgamepub.utils.QQGameUIHelper$2$a */
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
                        GameSessionView.this.setVisibility(8);
                        QQGameUIHelper.g(GameSessionView.this, true);
                        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, -45.0f, 1, 0.5f, 1, 0.5f);
                        rotateAnimation.setRepeatMode(2);
                        rotateAnimation.setRepeatCount(1);
                        rotateAnimation.setDuration(80L);
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
                    this.f264704e = view;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) GameSessionView.this, (Object) view);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (GameSessionView.this == null) {
                        return;
                    }
                    this.f264704e.getLocationInWindow(r0);
                    int[] iArr = {iArr[0] + (this.f264704e.getWidth() / 2), iArr[1] + (this.f264704e.getHeight() / 2)};
                    GameSessionView.this.getLocationInWindow(r2);
                    int height = r2[1] + (GameSessionView.this.getHeight() / 2);
                    int[] iArr2 = {iArr2[0] + (GameSessionView.this.getWidth() / 2), height};
                    iArr[0] = iArr[0] - iArr2[0];
                    iArr[1] = iArr[1] - height;
                    ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.1f, 1.0f, 0.1f, 1, 0.5f, 1, 0.5f);
                    scaleAnimation.setDuration(300L);
                    TranslateAnimation translateAnimation = new TranslateAnimation(GameSessionView.this.getLeft(), r2 + iArr[0], GameSessionView.this.getTop(), r7 + iArr[1]);
                    translateAnimation.setStartOffset(300L);
                    translateAnimation.setDuration(200L);
                    AnimationSet animationSet = new AnimationSet(false);
                    animationSet.addAnimation(scaleAnimation);
                    animationSet.addAnimation(translateAnimation);
                    animationSet.setAnimationListener(new a());
                    QQGameUIHelper.g(GameSessionView.this, false);
                    GameSessionView.this.startAnimation(animationSet);
                }
            }, j3);
        }
    }
}
