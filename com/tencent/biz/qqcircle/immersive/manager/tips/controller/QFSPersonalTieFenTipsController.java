package com.tencent.biz.qqcircle.immersive.manager.tips.controller;

import android.animation.ObjectAnimator;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.richframework.animation.drawable.AnimationDrawableCreateOption;
import com.tencent.biz.richframework.animation.drawable.AnimationDrawableFactory;
import com.tencent.biz.richframework.animation.drawable.QQAnimationDrawable;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.animation.QCircleAnimationHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.bubble.controller.RFWTipsBaseController;

/* loaded from: classes4.dex */
public class QFSPersonalTieFenTipsController extends RFWTipsBaseController {

    /* renamed from: h, reason: collision with root package name */
    private static final int f87242h = cx.a(2.0f);

    /* renamed from: d, reason: collision with root package name */
    private ImageView f87243d;

    /* renamed from: e, reason: collision with root package name */
    private QQAnimationDrawable f87244e;

    /* renamed from: f, reason: collision with root package name */
    private Runnable f87245f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements AnimationDrawableFactory.CreateResultListener {
        a() {
        }

        @Override // com.tencent.biz.richframework.animation.drawable.AnimationDrawableFactory.CreateResultListener
        public void onCreateResult(boolean z16, QQAnimationDrawable qQAnimationDrawable) {
            if (!z16) {
                QLog.d("QFSPersonalTieFenTipsController", 1, "TieFen Animation downloaded fail!");
                return;
            }
            qQAnimationDrawable.setOneShot(true);
            QFSPersonalTieFenTipsController.this.f87244e = qQAnimationDrawable;
            QFSPersonalTieFenTipsController.this.k();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        ImageView imageView = this.f87243d;
        if (imageView == null) {
            return;
        }
        imageView.postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.manager.tips.controller.QFSPersonalTieFenTipsController.5
            @Override // java.lang.Runnable
            public void run() {
                QFSPersonalTieFenTipsController.this.dismiss();
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        ImageView imageView = this.f87243d;
        if (imageView == null) {
            return;
        }
        imageView.postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.manager.tips.controller.QFSPersonalTieFenTipsController.4
            @Override // java.lang.Runnable
            public void run() {
                QFSPersonalTieFenTipsController.this.j();
                QFSPersonalTieFenTipsController.this.g();
            }
        }, 2700L);
    }

    private AnimationDrawableFactory.CreateResultListener i() {
        return new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f87243d, c.f123400v, 1.0f, 0.0f);
        ofFloat.setDuration(200L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        QQAnimationDrawable qQAnimationDrawable;
        ImageView imageView = this.f87243d;
        if (imageView != null && (qQAnimationDrawable = this.f87244e) != null) {
            imageView.setImageDrawable(qQAnimationDrawable);
            this.f87244e.setListener(new b());
            Runnable runnable = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.manager.tips.controller.QFSPersonalTieFenTipsController.3
                @Override // java.lang.Runnable
                public void run() {
                    QFSPersonalTieFenTipsController.this.f87244e.start();
                }
            };
            this.f87245f = runnable;
            this.f87243d.post(runnable);
        }
    }

    private void l() {
        if (this.f87244e != null) {
            k();
            return;
        }
        AnimationDrawableCreateOption.Builder defaultBuilder = QCircleAnimationHelper.getDefaultBuilder("https://downv6.qq.com/video_story/qcircle/zip/defaultmode/890/rocket/qvideo_tips_profilepage_tiefen_seq.zip");
        defaultBuilder.setFrameDuration(25);
        defaultBuilder.setCreateTimeOut(5000L);
        defaultBuilder.setRequestWidth(cx.a(60.0f));
        defaultBuilder.setRequestHeight(cx.a(24.0f));
        AnimationDrawableFactory.getInstance().createFromUrl(hashCode(), defaultBuilder.build(), i());
    }

    @Override // com.tencent.richframework.bubble.controller.RFWTipsBaseController
    protected boolean clickPopupWindowDismiss() {
        return false;
    }

    @Override // com.tencent.richframework.bubble.controller.RFWTipsBaseController
    public void dismiss() {
        ImageView imageView = this.f87243d;
        if (imageView != null) {
            imageView.removeCallbacks(this.f87245f);
        }
        super.dismiss();
    }

    @Override // com.tencent.richframework.bubble.controller.RFWTipsBaseController
    protected int getGravity() {
        return 0;
    }

    @Override // com.tencent.richframework.bubble.controller.RFWTipsBaseController
    protected int getLayoutId() {
        return R.layout.gnb;
    }

    @Override // com.tencent.richframework.bubble.controller.RFWTipsBaseController
    protected int[] getShowXY(View view, PopupWindow popupWindow) {
        if (view != null && popupWindow != null) {
            int width = view.getWidth();
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            return new int[]{(iArr[0] + width) - cx.a(8.0f), iArr[1] - cx.a(24.0f)};
        }
        return new int[2];
    }

    @Override // com.tencent.richframework.bubble.controller.RFWTipsBaseController
    protected void initView(View view) {
        this.f87243d = (ImageView) view.findViewById(R.id.f487420t);
    }

    @Override // com.tencent.richframework.bubble.controller.RFWTipsBaseController
    public void startShowTip() {
        super.startShowTip();
        l();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b implements QQAnimationDrawable.QQAnimationListener {
        b() {
        }

        @Override // com.tencent.biz.richframework.animation.drawable.QQAnimationDrawable.QQAnimationListener
        public void onStop() {
            QFSPersonalTieFenTipsController.this.h();
        }

        @Override // com.tencent.biz.richframework.animation.drawable.QQAnimationDrawable.QQAnimationListener
        public void onStart() {
        }

        @Override // com.tencent.biz.richframework.animation.drawable.QQAnimationDrawable.QQAnimationListener
        public void onPlay(int i3) {
        }
    }
}
