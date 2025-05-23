package com.tencent.mobileqq.avatar.dynamicavatar.videodrawable;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
public class DrawableSeekbar extends LinearLayout implements View.OnTouchListener {
    static IPatchRedirector $redirector_;
    int C;
    int D;
    int E;
    boolean F;
    a G;

    /* renamed from: d, reason: collision with root package name */
    ImageView f200080d;

    /* renamed from: e, reason: collision with root package name */
    int f200081e;

    /* renamed from: f, reason: collision with root package name */
    int f200082f;

    /* renamed from: h, reason: collision with root package name */
    int f200083h;

    /* renamed from: i, reason: collision with root package name */
    int f200084i;

    /* renamed from: m, reason: collision with root package name */
    int f200085m;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface a {
        void F1();

        void G();

        void onProgressChanged(int i3);
    }

    public DrawableSeekbar(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.F = false;
            b();
        }
    }

    private void b() {
        this.E = (int) (getResources().getDisplayMetrics().density * 2.0f);
        this.f200080d = new ImageView(getContext());
        addView(this.f200080d, new LinearLayout.LayoutParams(-1, -1));
        this.f200080d.setClickable(true);
        this.f200080d.setOnTouchListener(this);
        this.f200080d.setScaleType(ImageView.ScaleType.FIT_XY);
        this.f200080d.setContentDescription(HardCodeUtil.qqStr(R.string.lss));
    }

    private void d() {
        int i3;
        int i16 = this.D;
        if (i16 != 0) {
            if (this.f200080d.getWidth() + i16 > getWidth()) {
                i16 = getWidth() - this.f200080d.getWidth();
            }
            if (this.G != null) {
                int i17 = this.f200084i;
                int width = (int) ((i16 / (getWidth() - this.f200080d.getWidth())) * this.f200083h);
                this.f200084i = width;
                if (i17 != width) {
                    this.G.onProgressChanged(width);
                }
            }
            ImageView imageView = this.f200080d;
            imageView.layout(i16, 0, imageView.getMeasuredWidth() + i16, this.f200080d.getMeasuredHeight());
            return;
        }
        int i18 = this.f200084i;
        if (i18 != 0 && this.f200083h != 0) {
            i3 = (int) ((i18 * (getMeasuredWidth() - this.f200080d.getMeasuredWidth())) / this.f200083h);
        } else {
            i3 = 0;
        }
        ImageView imageView2 = this.f200080d;
        imageView2.layout(i3, 0, imageView2.getMeasuredWidth() + i3, this.f200080d.getMeasuredHeight());
    }

    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.f200084i;
    }

    public boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        if (this.f200083h > 0) {
            return true;
        }
        return false;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
        } else if (getOrientation() == 1) {
            super.onLayout(z16, i3, i16, i17, i18);
        } else {
            d();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x002c, code lost:
    
        if (r0 != 3) goto L46;
     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouch(View view, MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
        }
        int i3 = 0;
        if (!c()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    int rawX = ((int) motionEvent.getRawX()) - this.f200081e;
                    if (Math.abs(rawX) < this.E) {
                        return true;
                    }
                    this.D = 0;
                    int left = view.getLeft() + rawX;
                    int right = view.getRight() + rawX;
                    if (left < 0) {
                        right = view.getWidth() + 0;
                    } else {
                        i3 = left;
                    }
                    if (right > getWidth()) {
                        right = getWidth();
                        i3 = right - view.getWidth();
                    }
                    if (this.G != null) {
                        int i16 = this.f200084i;
                        int width = (int) ((i3 / (getWidth() - view.getWidth())) * this.f200083h);
                        this.f200084i = width;
                        if (i16 != width) {
                            this.G.onProgressChanged(width);
                        }
                    }
                    view.layout(i3, view.getTop(), right, view.getBottom());
                    view.invalidate();
                    this.f200081e = (int) motionEvent.getRawX();
                    this.f200082f = (int) motionEvent.getRawY();
                }
            }
            getParent().requestDisallowInterceptTouchEvent(false);
            this.F = false;
            a aVar = this.G;
            if (aVar != null) {
                aVar.F1();
            }
        } else {
            getParent().requestDisallowInterceptTouchEvent(true);
            this.f200081e = (int) motionEvent.getRawX();
            this.f200082f = (int) motionEvent.getRawY();
            a aVar2 = this.G;
            if (aVar2 != null) {
                aVar2.G();
            }
            if (this.G != null) {
                int i17 = this.f200084i;
                int left2 = (int) ((view.getLeft() / (getWidth() - view.getWidth())) * this.f200083h);
                this.f200084i = left2;
                if (i17 != left2) {
                    this.G.onProgressChanged(left2);
                }
            }
        }
        return true;
    }

    public void setMax(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else {
            this.f200083h = i3;
        }
    }

    public void setOnProgressChangedListener(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) aVar);
        } else {
            this.G = aVar;
        }
    }

    public void setProgress(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
        } else if (i3 != this.f200084i) {
            this.f200084i = i3;
            requestLayout();
        }
    }

    public void setThumb(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) drawable);
        } else {
            this.f200080d.setImageDrawable(drawable);
        }
    }

    public void setThumbOffset(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
            return;
        }
        this.f200084i = 0;
        if (this.D != i3) {
            this.D = i3;
        }
        requestLayout();
    }

    public void setThumbSize(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (i3 != this.f200085m || i16 != this.C) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f200080d.getLayoutParams();
            layoutParams.width = i3;
            layoutParams.height = i16;
            this.f200080d.setLayoutParams(layoutParams);
        }
    }

    public DrawableSeekbar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        } else {
            this.F = false;
            b();
        }
    }
}
