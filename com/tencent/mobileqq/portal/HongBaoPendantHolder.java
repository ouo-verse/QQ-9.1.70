package com.tencent.mobileqq.portal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.springhb.api.ISpringHbTempApi;
import com.tencent.mobileqq.springhb.entry.model.PendantData;
import com.tencent.mobileqq.springhb.preload.SpringResApi;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes16.dex */
public class HongBaoPendantHolder extends com.tencent.mobileqq.portal.a {
    static IPatchRedirector $redirector_;
    private final Drawable.Callback G;
    RectF H;
    RectF I;
    com.tencent.mobileqq.portal.a J;
    com.tencent.mobileqq.portal.a K;
    public Context L;
    public View M;
    public boolean N;
    public int P;

    /* loaded from: classes16.dex */
    class a implements Drawable.Callback {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) HongBaoPendantHolder.this);
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(@NonNull Drawable drawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) drawable);
            } else {
                HongBaoPendantHolder.this.M.invalidate();
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, drawable, runnable, Long.valueOf(j3));
            } else {
                HongBaoPendantHolder.this.M.postDelayed(runnable, j3 - SystemClock.uptimeMillis());
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) drawable, (Object) runnable);
            } else {
                HongBaoPendantHolder.this.M.removeCallbacks(runnable);
            }
        }
    }

    public HongBaoPendantHolder(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) view);
            return;
        }
        this.G = new a();
        this.H = new RectF();
        this.I = new RectF();
        this.N = false;
        this.P = 0;
        this.M = view;
        this.L = view.getContext();
    }

    private void h(Drawable drawable) {
        boolean z16;
        if (n(drawable)) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable(drawable) { // from class: com.tencent.mobileqq.portal.HongBaoPendantHolder.3
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Drawable f259180d;

                {
                    this.f259180d = drawable;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) HongBaoPendantHolder.this, (Object) drawable);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    ApngDrawable apngDrawable = (ApngDrawable) ((URLDrawable) this.f259180d).getCurrDrawable();
                    apngDrawable.repaly();
                    apngDrawable.resume();
                    ApngImage.playByTag(26);
                }
            });
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.i("HongBaoPendantHolder", 2, "doPlayDrumAnim: playSuccess:" + z16);
        }
    }

    private String j(@NonNull PendantData pendantData) {
        return "game_spring_pendant_normal.png";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(@NonNull PendantData pendantData) {
        if (QLog.isColorLevel()) {
            QLog.d("HongBaoPendantHolder", 2, "pendantData " + pendantData);
        }
        Resources resources = this.M.getResources();
        if (this.f259364m == null) {
            new Bundle().putBoolean(VasApngUtil.KEY_PLAY_APNG, true);
            String j3 = j(pendantData);
            Bundle bundle = new Bundle();
            int apngPlayCount = ((ISpringHbTempApi) QRoute.api(ISpringHbTempApi.class)).getApngPlayCount();
            QLog.i("HongBaoPendantHolder", 1, "playCount = " + apngPlayCount);
            bundle.putInt("key_loop", apngPlayCount);
            bundle.putBoolean("key_get_reset_loop", false);
            bundle.putBoolean("key_stop_on_first", false);
            Drawable b16 = SpringResApi.k(pendantData.pendantImgUrl, SpringResApi.i(j3, bundle).b(), bundle).b();
            this.f259364m = b16;
            b16.setCallback(this.G);
        }
        int dimension = (int) resources.getDimension(R.dimen.afc);
        int dimension2 = (int) resources.getDimension(R.dimen.afr);
        int dimension3 = (int) resources.getDimension(R.dimen.afn);
        int dimension4 = (int) resources.getDimension(R.dimen.afq);
        int width = (this.M.getWidth() - dimension2) - dimension3;
        p(pendantData.showCloseBtn);
        c(width, dimension4, dimension2, dimension, this.M);
        h(this.f259364m);
        this.M.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.portal.g
            @Override // java.lang.Runnable
            public final void run() {
                HongBaoPendantHolder.this.o();
            }
        }, 1000L);
    }

    private boolean n(Drawable drawable) {
        if ((drawable instanceof URLDrawable) && (((URLDrawable) drawable).getCurrDrawable() instanceof ApngDrawable)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o() {
        this.M.invalidate();
    }

    private void p(boolean z16) {
        if (z16) {
            this.J = new com.tencent.mobileqq.portal.a();
            Resources resources = this.M.getResources();
            int dimension = (int) resources.getDimension(R.dimen.d6s);
            int dimension2 = (int) resources.getDimension(R.dimen.d6p);
            int dimension3 = (int) resources.getDimension(R.dimen.d6q);
            int width = (this.M.getWidth() - dimension3) - dimension;
            if (QLog.isColorLevel()) {
                QLog.d("HongBaoPendantHolder", 2, "init close Btn, mParentView.getWidth() = " + this.M.getWidth() + "closeBtnRightMargin = " + dimension3 + "closeBtnWidth = " + dimension + "closeBtnLeft = " + width);
            }
            int dimension4 = (int) resources.getDimension(R.dimen.d6r);
            this.J.f259364m = SpringResApi.i("game_spring_pendant_close.png", new Bundle()).b();
            this.J.c(width, dimension4, dimension, dimension2, this.M);
            return;
        }
        this.J = null;
    }

    @Override // com.tencent.mobileqq.portal.a
    public boolean b(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) canvas)).booleanValue();
        }
        boolean e16 = super.e();
        canvas.save();
        canvas.translate(0.0f, this.P);
        super.d(canvas);
        com.tencent.mobileqq.portal.a aVar = this.J;
        if (aVar != null) {
            aVar.b(canvas);
        }
        com.tencent.mobileqq.portal.a aVar2 = this.K;
        if (aVar2 != null) {
            aVar2.b(canvas);
        }
        canvas.restore();
        return e16;
    }

    public RectF i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (RectF) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        com.tencent.mobileqq.portal.a aVar = this.J;
        if (aVar != null) {
            float f16 = aVar.f259362h;
            RectF rectF = this.I;
            int i3 = aVar.f259360e;
            int i16 = aVar.f259361f;
            int i17 = this.P;
            rectF.set(i3 - f16, (i16 - f16) + i17, i3 + r1 + f16, i16 + aVar.f259363i + f16 + i17);
            if (QLog.isColorLevel()) {
                QLog.d("HongBaoPendantHolder", 2, "getCloseBtnTouchRect debug click event, span = " + f16 + ", closeBtnHolder.x = " + this.J.f259360e + ", closeBtnHolder.y = " + this.J.f259361f + ", closeBtnHolder.width = " + this.J.f259362h + ", closeBtnHolder.height = " + this.J.f259363i + ", offsetY = " + this.P + ", closeBtnTouchRect = " + this.I);
            }
            return this.I;
        }
        return null;
    }

    public RectF k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (RectF) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        RectF rectF = this.H;
        int i3 = this.f259360e;
        int i16 = this.f259361f;
        int i17 = this.P;
        rectF.set(i3, i16 + i17, i3 + this.f259362h, i16 + this.f259363i + i17);
        return this.H;
    }

    public void l(@NonNull PendantData pendantData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) pendantData);
        } else {
            ThreadManagerV2.excute(new Runnable(pendantData) { // from class: com.tencent.mobileqq.portal.HongBaoPendantHolder.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ PendantData f259179d;

                {
                    this.f259179d = pendantData;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) HongBaoPendantHolder.this, (Object) pendantData);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        HongBaoPendantHolder.this.m(this.f259179d);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            }, 16, null, false);
        }
    }
}
