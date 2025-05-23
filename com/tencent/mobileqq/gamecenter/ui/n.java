package com.tencent.mobileqq.gamecenter.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.image.ApngDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gamecenter.api.IGameCenterRedPointConfigApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.ui.TianshuRedTouch;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes12.dex */
public class n implements v {

    /* renamed from: d, reason: collision with root package name */
    private WeakReference<com.tencent.mobileqq.gamecenter.api.c> f213327d;

    /* renamed from: e, reason: collision with root package name */
    private WeakReference<o> f213328e;

    /* renamed from: f, reason: collision with root package name */
    private Handler f213329f = new a(ThreadManagerV2.getUIHandlerV2().getLooper());

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            super.handleMessage(message);
            if (message.what == 1) {
                QLog.i("GameCenterDynamicViewCtrl", 1, "[handleMessage] start animation");
                if (n.this.f213328e == null) {
                    QLog.i("GameCenterDynamicViewCtrl", 1, "[handleMessage] mChildViewRef is null");
                    return;
                }
                o oVar = (o) n.this.f213328e.get();
                if (oVar == null) {
                    QLog.i("GameCenterDynamicViewCtrl", 1, "[handleMessage] childView is null");
                } else {
                    n.this.k(oVar.f213345h, oVar.f213347j);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class c extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f213333d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ObjectAnimator f213334e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ View f213335f;

        /* compiled from: P */
        /* loaded from: classes12.dex */
        class a extends AnimatorListenerAdapter {
            a() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c.this.f213333d.setRotationY(0.0f);
            }
        }

        c(View view, ObjectAnimator objectAnimator, View view2) {
            this.f213333d = view;
            this.f213334e = objectAnimator;
            this.f213335f = view2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f213333d.setVisibility(8);
            this.f213334e.addListener(new a());
            this.f213334e.start();
            this.f213335f.setVisibility(0);
            ((IGameCenterRedPointConfigApi) QRoute.api(IGameCenterRedPointConfigApi.class)).addSepcialRedPointShowCnt();
        }
    }

    public n(com.tencent.mobileqq.gamecenter.api.c cVar) {
        this.f213327d = new WeakReference<>(cVar);
    }

    private void e(String str, ImageView imageView, int i3, int i16) {
        URLDrawable uRLDrawable;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams.width = i3;
        layoutParams.height = i16;
        if (!TextUtils.isEmpty(str)) {
            ApngOptions apngOptions = new ApngOptions();
            apngOptions.setLoadingDrawable(new ColorDrawable(0));
            apngOptions.setRequestWidth(i3);
            apngOptions.setRequestHeight(i16);
            uRLDrawable = ((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getApngURLDrawable(m.class.getName(), str, apngOptions);
        } else {
            uRLDrawable = null;
        }
        if (uRLDrawable == null) {
            QLog.w("GameCenterDynamicViewCtrl", 1, "drawable is null.");
            return;
        }
        if (uRLDrawable.getStatus() == 1) {
            QLog.i("GameCenterDynamicViewCtrl", 1, "drawable exists in local path.");
            imageView.setImageDrawable(uRLDrawable);
            f();
        } else {
            uRLDrawable.setURLDrawableListener(new b(imageView));
            uRLDrawable.startDownload();
            QLog.i("GameCenterDynamicViewCtrl", 1, "drawable start to download");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        WeakReference<o> weakReference = this.f213328e;
        if (weakReference == null) {
            QLog.i("GameCenterDynamicViewCtrl", 1, "[attachViewIfBothReady] mChildViewRef is null");
            return;
        }
        o oVar = weakReference.get();
        if (oVar == null) {
            QLog.i("GameCenterDynamicViewCtrl", 1, "[attachViewIfBothReady] childView is null");
            return;
        }
        Drawable drawable = oVar.f213347j.getDrawable();
        if (drawable instanceof ApngDrawable) {
            j();
        } else if ((drawable instanceof URLDrawable) && ((URLDrawable) drawable).getStatus() == 1) {
            QLog.i("GameCenterDynamicViewCtrl", 1, "both are ready. Start to attach.");
            j();
        }
    }

    private com.tencent.mobileqq.gamecenter.api.c g() {
        WeakReference<com.tencent.mobileqq.gamecenter.api.c> weakReference = this.f213327d;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    private boolean h() {
        WeakReference<o> weakReference = this.f213328e;
        if (weakReference == null) {
            QLog.i("GameCenterDynamicViewCtrl", 1, "[isChildViewValid] mChildViewRef is null");
            return false;
        }
        o oVar = weakReference.get();
        if (oVar == null) {
            QLog.i("GameCenterDynamicViewCtrl", 1, "[isChildViewValid] childView is null");
            return false;
        }
        if (oVar.f213340c == null || oVar.f213339b == null || oVar.f213338a == null || oVar.f213344g == null || oVar.f213342e == null || oVar.f213343f == null) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.gamecenter.ui.v
    public void a() {
        if (g() == null) {
            QLog.w("GameCenterDynamicViewCtrl", 1, "FAIL to remove view.");
            return;
        }
        if (!h()) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("GameCenterDynamicViewCtrl", 2, "[removeView] remove view");
        }
        WeakReference<o> weakReference = this.f213328e;
        if (weakReference == null) {
            QLog.i("GameCenterDynamicViewCtrl", 1, "[handleMessage] mChildViewRef is null");
            return;
        }
        o oVar = weakReference.get();
        if (oVar == null) {
            QLog.i("GameCenterDynamicViewCtrl", 1, "[handleMessage] childView is null");
            return;
        }
        oVar.f213343f.g();
        oVar.f213340c.setVisibility(8);
        oVar.f213344g.setVisibility(8);
        oVar.f213338a.setVisibility(0);
    }

    @Override // com.tencent.mobileqq.gamecenter.ui.v
    public void b(com.tencent.mobileqq.gamecenter.data.d dVar) {
        if (dVar == null) {
            return;
        }
        com.tencent.mobileqq.gamecenter.api.c g16 = g();
        if (g16 == null) {
            QLog.w("GameCenterDynamicViewCtrl", 1, "fail to add view. feedViewHelper is NULL");
            return;
        }
        WeakReference<o> weakReference = new WeakReference<>(g16.c());
        this.f213328e = weakReference;
        o oVar = weakReference.get();
        if (oVar == null) {
            QLog.w("GameCenterDynamicViewCtrl", 1, "child view is NULL.");
            return;
        }
        if (!h()) {
            QLog.w("GameCenterDynamicViewCtrl", 1, "child view is invalid.");
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("GameCenterDynamicViewCtrl", 2, "[addView] add view");
        }
        oVar.f213338a.setVisibility(8);
        ApngOptions apngOptions = new ApngOptions();
        apngOptions.setRequestWidth(com.tencent.mobileqq.gamecenter.utils.c.d(23.0f, oVar.f213338a.getResources()));
        apngOptions.setRequestHeight(com.tencent.mobileqq.gamecenter.utils.c.d(36.0f, oVar.f213338a.getResources()));
        if (i(dVar)) {
            oVar.f213344g.setVisibility(0);
            oVar.f213348k.setText(dVar.f212005n);
            com.tencent.mobileqq.gamecenter.api.c cVar = this.f213327d.get();
            if (TextUtils.isEmpty(dVar.f212004m)) {
                if (cVar != null && !TextUtils.isEmpty(cVar.b())) {
                    oVar.f213345h.setImageDrawable(((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getApngURLDrawable(m.class.getName(), cVar.b(), apngOptions));
                }
            } else {
                String str = dVar.f212004m;
                ImageView imageView = oVar.f213347j;
                e(str, imageView, com.tencent.mobileqq.gamecenter.utils.c.d(24.0f, imageView.getResources()), com.tencent.mobileqq.gamecenter.utils.c.d(24.0f, oVar.f213347j.getResources()));
            }
            if (cVar != null && !TextUtils.isEmpty(cVar.b())) {
                oVar.f213345h.setImageDrawable(((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getApngURLDrawable(m.class.getName(), cVar.b(), apngOptions));
            }
            oVar.f213345h.setVisibility(0);
            oVar.f213347j.setVisibility(8);
            if (!TianshuRedTouch.INSTANCE.j()) {
                oVar.f213341d.setVisibility(0);
                return;
            }
            return;
        }
        oVar.f213344g.setVisibility(8);
        oVar.f213340c.setVisibility(0);
        oVar.f213343f.setText(dVar.f211997f);
        oVar.f213342e.setImageDrawable(((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getApngURLDrawable(m.class.getName(), dVar.f211996e, apngOptions));
        if (!TianshuRedTouch.INSTANCE.j()) {
            oVar.f213346i.setVisibility(0);
        }
    }

    boolean i(com.tencent.mobileqq.gamecenter.data.d dVar) {
        if (dVar.f211992a != 4 && TextUtils.isEmpty(dVar.f212005n)) {
            return false;
        }
        return true;
    }

    void j() {
        this.f213329f.removeMessages(1);
        this.f213329f.sendEmptyMessage(1);
    }

    void k(View view, View view2) {
        if (view != null && view2 != null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, BasicAnimation.KeyPath.ROTATION_Y, 0.0f, 90.0f);
            ofFloat.setDuration(500L);
            ofFloat.setInterpolator(new AccelerateInterpolator());
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view2, BasicAnimation.KeyPath.ROTATION_Y, -90.0f, 0.0f);
            ofFloat2.setDuration(500L);
            ofFloat2.setInterpolator(new DecelerateInterpolator());
            ofFloat.addListener(new c(view, ofFloat2, view2));
            ofFloat.start();
            return;
        }
        QLog.i("GameCenterDynamicViewCtrl", 1, "[handleMessage] front is null");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b implements URLDrawable.URLDrawableListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ImageView f213331d;

        b(ImageView imageView) {
            this.f213331d = imageView;
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable uRLDrawable) {
            QLog.i("GameCenterDynamicViewCtrl", 1, "drawable download succeed.");
            this.f213331d.setImageDrawable(uRLDrawable);
            n.this.f();
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable uRLDrawable) {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable uRLDrawable, int i3) {
        }
    }
}
