package com.tencent.mobileqq.zplan.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.utils.featureswitch.ZPlanFeatureSwitch;

/* loaded from: classes34.dex */
public class ZPlanRoundImageLayout extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    private Context f335913d;

    /* renamed from: e, reason: collision with root package name */
    private RoundImageView f335914e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f335915f;

    /* renamed from: h, reason: collision with root package name */
    private RoundImageView f335916h;

    /* renamed from: i, reason: collision with root package name */
    private RoundImageView f335917i;

    /* renamed from: m, reason: collision with root package name */
    private URLDrawable f335918m;

    public ZPlanRoundImageLayout(Context context) {
        super(context);
        this.f335913d = context;
        c();
    }

    private URLDrawable b(String str) {
        URLDrawable drawable;
        ColorDrawable colorDrawable = new ColorDrawable(0);
        if (TextUtils.isEmpty(str)) {
            QLog.e("ZPlanRoundImageLayout", 1, "[getURLDrawable] url is empty");
            return null;
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = colorDrawable;
        obtain.mFailedDrawable = colorDrawable;
        try {
            if (str.startsWith("/storage/")) {
                drawable = URLDrawable.getFileDrawable(str, obtain);
            } else {
                drawable = URLDrawable.getDrawable(str, obtain);
            }
            if (drawable.getStatus() == 2) {
                drawable.restartDownload();
            }
            return drawable;
        } catch (Throwable th5) {
            QLog.e("ZPlanRoundImageLayout", 1, "getDrawable: " + str, th5);
            return null;
        }
    }

    private void c() {
        RoundImageView roundImageView = new RoundImageView(this.f335913d);
        this.f335914e = roundImageView;
        roundImageView.setmRadius(ViewUtils.dpToPx(136.0f), false);
        this.f335915f = new ImageView(this.f335913d, null, 0);
        RoundImageView roundImageView2 = new RoundImageView(this.f335913d);
        this.f335916h = roundImageView2;
        roundImageView2.setmRadius(ViewUtils.dpToPx(136.0f), false);
        RoundImageView roundImageView3 = new RoundImageView(this.f335913d);
        this.f335917i = roundImageView3;
        roundImageView3.setmRadius(ViewUtils.dpToPx(141.0f), false);
        int dpToPx = ViewUtils.dpToPx(9.0f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.setMargins(dpToPx, dpToPx, dpToPx, dpToPx);
        addView(this.f335914e, layoutParams);
        int dpToPx2 = ViewUtils.dpToPx(4.0f);
        ViewGroup.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.setMargins(dpToPx2, dpToPx2, dpToPx2, dpToPx2);
        this.f335917i.setImageDrawable(this.f335913d.getDrawable(R.drawable.gow));
        addView(this.f335917i, layoutParams2);
        addView(this.f335915f, layoutParams);
        addView(this.f335916h, layoutParams);
    }

    public void setAvatarImageUrl(String str, Boolean bool, Double d16) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("ZPlanRoundImageLayout", 1, "[setAvatarImageUrl] url is empty");
            return;
        }
        URLDrawable b16 = b(str);
        if (b16 == null) {
            QLog.e("ZPlanRoundImageLayout", 1, "setAvatarImageUrl failed, urlDrawable null.");
            return;
        }
        if (bool.booleanValue()) {
            if (d16 == null) {
                d16 = Double.valueOf(0.25d);
            }
            com.tencent.mobileqq.avatar.widget.a aVar = new com.tencent.mobileqq.avatar.widget.a(b16, d16.doubleValue());
            this.f335916h.setVisibility(8);
            this.f335915f.setVisibility(0);
            this.f335915f.setImageDrawable(aVar);
            long a26 = ZPlanFeatureSwitch.f369852a.a2();
            if (a26 > 0) {
                ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.zplan.view.ZPlanRoundImageLayout.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ZPlanRoundImageLayout.this.f335915f.invalidate();
                    }
                }, a26);
                return;
            }
            return;
        }
        this.f335915f.setVisibility(8);
        this.f335916h.setVisibility(0);
        this.f335916h.setImageDrawable(b16);
    }

    public void setBackgroundImageColor(int i3) {
        this.f335914e.setImageDrawable(new ColorDrawable(i3));
    }

    public void setBackgroundImageUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("ZPlanRoundImageLayout", 1, "[setBackgroundImageUrl] url is empty");
        }
        URLDrawable b16 = b(str);
        this.f335918m = b16;
        this.f335914e.setImageDrawable(b16);
    }

    public void setInnerMargin(int i3) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f335914e.getLayoutParams();
        layoutParams.setMargins(i3, i3, i3, i3);
        this.f335914e.setLayoutParams(layoutParams);
        this.f335915f.setLayoutParams(layoutParams);
        this.f335916h.setLayoutParams(layoutParams);
    }

    public void setRadius(int i3) {
        float f16 = i3;
        this.f335914e.setmRadius(ViewUtils.dpToPx(f16), false);
        this.f335916h.setmRadius(ViewUtils.dpToPx(f16), false);
    }

    public void setStrokeDrawable(Drawable drawable) {
        this.f335917i.setImageDrawable(drawable);
    }

    public ZPlanRoundImageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f335913d = context;
        c();
    }

    public ZPlanRoundImageLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f335913d = context;
        c();
    }
}
