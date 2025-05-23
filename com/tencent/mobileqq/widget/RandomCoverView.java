package com.tencent.mobileqq.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.VasLogReporter;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;

/* compiled from: P */
/* loaded from: classes20.dex */
public class RandomCoverView extends FrameLayout {
    protected boolean C;
    protected URLDrawable D;
    protected boolean E;
    protected int F;

    /* renamed from: d, reason: collision with root package name */
    protected QQAppInterface f316143d;

    /* renamed from: e, reason: collision with root package name */
    protected String f316144e;

    /* renamed from: f, reason: collision with root package name */
    private URLImageView f316145f;

    /* renamed from: h, reason: collision with root package name */
    private View f316146h;

    /* renamed from: i, reason: collision with root package name */
    protected Paint f316147i;

    /* renamed from: m, reason: collision with root package name */
    protected String f316148m;

    public RandomCoverView(Context context) {
        super(context);
        this.f316145f = null;
        this.f316146h = null;
        this.f316147i = null;
        this.f316148m = null;
        this.C = true;
        this.D = null;
        this.E = false;
        this.F = 0;
        f();
    }

    private void f() {
        int color;
        this.f316145f = new URLImageView(getContext());
        this.f316146h = new View(getContext());
        try {
            if (ThemeUtil.isInNightMode(this.f316143d)) {
                color = -1308622848;
            } else {
                color = getResources().getColor(R.color.f156937fr);
            }
            this.f316146h.setBackgroundColor(color);
        } catch (Throwable unused) {
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        super.addView(this.f316145f, layoutParams);
        super.addView(this.f316146h, layoutParams);
        this.f316145f.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    public void a(int i3) {
        if (i3 == this.F) {
            return;
        }
        this.F = i3;
        if (i3 == 1) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams != null) {
                int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.title_bar_height);
                int statusBarHeight = ImmersiveUtils.getStatusBarHeight(getContext());
                int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.a0d);
                layoutParams.width = -1;
                layoutParams.height = dimensionPixelSize2 + dimensionPixelSize + statusBarHeight;
                setLayoutParams(layoutParams);
            }
            this.f316146h.setBackgroundColor(getResources().getColor(R.color.aju));
            this.f316145f.setVisibility(8);
            return;
        }
        if (i3 == 4) {
            ViewGroup.LayoutParams layoutParams2 = getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.width = -1;
                layoutParams2.height = ViewUtils.getScreenHeight() - ViewUtils.dip2px(140.0f);
                setLayoutParams(layoutParams2);
            }
            this.E = false;
            setDefaultCoverBg();
            return;
        }
        ViewGroup.LayoutParams layoutParams3 = getLayoutParams();
        if (layoutParams3 != null) {
            layoutParams3.width = -1;
            layoutParams3.height = getResources().getDimensionPixelSize(R.dimen.a0m);
            setLayoutParams(layoutParams3);
        }
        this.f316146h.setBackgroundColor(getResources().getColor(R.color.f156937fr));
        this.f316145f.setVisibility(0);
    }

    public View b() {
        return this.f316146h;
    }

    public int c() {
        return this.F;
    }

    public URLImageView d() {
        return this.f316145f;
    }

    public void e(QQAppInterface qQAppInterface, String str, int i3, String str2, boolean z16) {
        this.f316143d = qQAppInterface;
        this.f316144e = str;
        a(i3);
        if (i3 == 4) {
            return;
        }
        VasLogReporter.getProfileCard().reportLow("init custom_cover mode[" + i3 + "] coverUrl[" + str2 + "] isDefault[" + z16 + "]");
        if (TextUtils.isEmpty(str2)) {
            setDefaultCoverBg();
        } else {
            g(str2, z16);
        }
        if (qQAppInterface.getCurrentAccountUin().equals(this.f316144e) && (TextUtils.isEmpty(str2) || z16)) {
            if (this.f316147i == null) {
                float c16 = com.tencent.mobileqq.util.x.c(getContext(), 14.0f);
                Paint paint = new Paint();
                this.f316147i = paint;
                paint.setAntiAlias(true);
                this.f316147i.setColor(Color.parseColor("#4CFFFFFF"));
                this.f316147i.setTextSize(c16);
            }
            this.f316148m = getResources().getString(R.string.f171192d14);
            this.C = true;
        } else {
            this.C = false;
        }
        this.E = true;
    }

    public void g(String str, boolean z16) {
        if (!TextUtils.isEmpty(str)) {
            try {
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                URLDrawable uRLDrawable = this.D;
                if (uRLDrawable != null) {
                    obtain.mLoadingDrawable = uRLDrawable.getCurrDrawable();
                    obtain.mFailedDrawable = this.D.getCurrDrawable();
                } else {
                    Drawable drawable = getResources().getDrawable(R.drawable.f2v);
                    obtain.mLoadingDrawable = drawable;
                    obtain.mFailedDrawable = drawable;
                }
                Activity activity = (Activity) getContext();
                obtain.mRequestHeight = ProfileCardUtil.q(activity);
                obtain.mRequestWidth = ProfileCardUtil.s(activity);
                URLDrawable drawable2 = URLDrawable.getDrawable(str, obtain);
                this.D = drawable2;
                this.f316145f.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.f316145f.setImageDrawable(drawable2);
                this.C = z16;
                if (QLog.isColorLevel()) {
                    QLog.i(LogTag.PROFILE_CARD, 2, "updateCover " + str + " isDef:" + z16);
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.i(LogTag.PROFILE_CARD, 2, e16.toString());
                }
            } catch (OutOfMemoryError e17) {
                QLog.e(LogTag.PROFILE_CARD, 1, "updateCover OutOfMemoryError happened.", e17);
            }
        }
    }

    public void h(String str, boolean z16, int i3, int i16) {
        URLDrawable fileDrawable;
        if (!TextUtils.isEmpty(str)) {
            try {
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                URLDrawable uRLDrawable = this.D;
                if (uRLDrawable != null) {
                    obtain.mLoadingDrawable = uRLDrawable.getCurrDrawable();
                    obtain.mFailedDrawable = this.D.getCurrDrawable();
                } else {
                    Drawable drawable = getResources().getDrawable(R.drawable.f2v);
                    obtain.mLoadingDrawable = drawable;
                    obtain.mFailedDrawable = drawable;
                }
                obtain.mRequestHeight = i16;
                obtain.mRequestWidth = i3;
                if (z16) {
                    fileDrawable = URLDrawable.getDrawable(str, obtain);
                    this.D = fileDrawable;
                } else {
                    fileDrawable = URLDrawable.getFileDrawable(str, obtain);
                    this.D = fileDrawable;
                }
                this.f316145f.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.f316145f.setImageDrawable(fileDrawable);
                this.f316146h.setVisibility(0);
                setCoverMaskColor();
                if (QLog.isColorLevel()) {
                    QLog.i(LogTag.PROFILE_CARD, 2, "updateCover " + str);
                }
            } catch (Exception | OutOfMemoryError e16) {
                if (QLog.isColorLevel()) {
                    QLog.i(LogTag.PROFILE_CARD, 2, e16.toString());
                }
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f316147i != null && !TextUtils.isEmpty(this.f316148m) && getHeight() != 0 && getWidth() != 0 && this.C && this.E) {
            float measureText = this.f316147i.measureText(this.f316148m);
            canvas.drawText(this.f316148m, (getWidth() - ((int) measureText)) / 2, getHeight() / 2, this.f316147i);
        }
    }

    public void setCoverMaskColor() {
        Resources resources;
        int i3;
        View view = this.f316146h;
        if (QQTheme.isNowThemeIsNight()) {
            resources = getResources();
            i3 = R.color.f156941fv;
        } else {
            resources = getResources();
            i3 = R.color.f156937fr;
        }
        view.setBackgroundColor(resources.getColor(i3));
    }

    public void setDefaultCoverBg() {
        this.f316146h.setVisibility(8);
        this.f316145f.setImageDrawable(null);
    }

    public RandomCoverView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f316145f = null;
        this.f316146h = null;
        this.f316147i = null;
        this.f316148m = null;
        this.C = true;
        this.D = null;
        this.E = false;
        this.F = 0;
        f();
    }

    public RandomCoverView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f316145f = null;
        this.f316146h = null;
        this.f316147i = null;
        this.f316148m = null;
        this.C = true;
        this.D = null;
        this.E = false;
        this.F = 0;
        f();
    }
}
