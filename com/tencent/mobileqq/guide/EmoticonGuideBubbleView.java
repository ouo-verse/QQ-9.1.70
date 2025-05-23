package com.tencent.mobileqq.guide;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes12.dex */
public class EmoticonGuideBubbleView extends LinearLayout implements com.tencent.mobileqq.guide.a {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    protected Context f213824d;

    /* renamed from: e, reason: collision with root package name */
    protected Drawable f213825e;

    /* renamed from: f, reason: collision with root package name */
    protected View f213826f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements Animation.AnimationListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) EmoticonGuideBubbleView.this);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
            } else {
                QLog.d("EmoticonGuideBubbleView", 2, "removeGuideBubble fadeoutanimation ended");
                EmoticonGuideBubbleView.this.setVisibility(8);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            } else {
                QLog.d("EmoticonGuideBubbleView", 2, "removeGuideBubble onAnimationStart");
            }
        }
    }

    public EmoticonGuideBubbleView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f213824d = context;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 8388613;
        setLayoutParams(layoutParams);
        setOrientation(1);
        setGravity(8388613);
        setVisibility(8);
    }

    private int c(ViewGroup viewGroup, ImageView imageView, int i3, boolean z16) {
        int right = viewGroup.getRight();
        int[] iArr = new int[2];
        this.f213826f.getLocationOnScreen(iArr);
        int width = this.f213826f.getWidth();
        imageView.measure(0, 0);
        int measuredWidth = (((right - iArr[0]) - (width / 2)) - (imageView.getMeasuredWidth() / 4)) - i3;
        if (QLog.isColorLevel()) {
            QLog.d("EmoticonGuideBubbleView", 2, "calcArrowOffset arrowOffset:", Integer.valueOf(measuredWidth), " ,eW:", Integer.valueOf(width), " ,eLX:", Integer.valueOf(iArr[0]));
        }
        return e(measuredWidth);
    }

    private int d(View view, boolean z16) {
        int i3;
        int i16;
        int right = view.getRight();
        int[] iArr = new int[2];
        this.f213826f.getLocationOnScreen(iArr);
        int width = this.f213826f.getWidth();
        measure(0, 0);
        int measuredWidth = getMeasuredWidth();
        if (z16) {
            i3 = right - (iArr[0] - ViewUtils.dip2px(20.0f));
            i16 = measuredWidth / 2;
        } else {
            i3 = right - (iArr[0] + (width / 2));
            i16 = measuredWidth / 2;
        }
        int i17 = i3 - i16;
        if (QLog.isColorLevel()) {
            QLog.d("EmoticonGuideBubbleView", 2, "calcOffset offset:", Integer.valueOf(i17), " ,bW:", Integer.valueOf(measuredWidth), " ,eW:", Integer.valueOf(width), " ,eLX:", Integer.valueOf(iArr[0]));
        }
        return e(i17);
    }

    private int e(int i3) {
        if (i3 <= 0 || getMeasuredWidth() + i3 >= ViewUtils.getScreenWidth()) {
            return ViewUtils.dip2px(6.0f);
        }
        return i3;
    }

    @Override // com.tencent.mobileqq.guide.a
    public void b(ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) viewGroup);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("EmoticonGuideBubbleView", 2, "removeGuideBubble ");
        }
        if (viewGroup != null && getVisibility() != 8) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            setAnimation(alphaAnimation);
            alphaAnimation.setDuration(500L);
            alphaAnimation.setFillAfter(true);
            alphaAnimation.setAnimationListener(new a());
            startAnimation(alphaAnimation);
            viewGroup.removeView(this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00a2 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0092  */
    @Override // com.tencent.mobileqq.guide.a
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public EmoticonGuideBubbleView a(ViewGroup viewGroup, ViewGroup viewGroup2, View view, Map<String, Object> map) {
        int i3;
        int i16;
        boolean z16;
        String str;
        int i17;
        Drawable g16;
        int dip2px;
        int d16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (EmoticonGuideBubbleView) iPatchRedirector.redirect((short) 2, this, viewGroup, viewGroup2, view, map);
        }
        if (viewGroup != null && viewGroup2 != null) {
            if (getVisibility() == 0) {
                b(viewGroup);
                return null;
            }
            if (view != null) {
                this.f213826f = view;
            }
            if (this.f213826f != null && map != null && !map.isEmpty()) {
                String str2 = "";
                try {
                    str = (String) map.get("drawable_url");
                    try {
                        i17 = ((Integer) map.get("width")).intValue();
                        try {
                            i16 = ((Integer) map.get("height")).intValue();
                            try {
                                z16 = ((Boolean) map.get("now_theme_is_simple")).booleanValue();
                            } catch (Exception e16) {
                                e = e16;
                                i3 = i17;
                                str2 = str;
                                if (QLog.isColorLevel()) {
                                    QLog.w("EmoticonGuideBubbleView", 2, "generateGuideBubble Exception:", e);
                                }
                                z16 = false;
                                int i18 = i3;
                                str = str2;
                                i17 = i18;
                                if (!TextUtils.isEmpty(str)) {
                                    removeAllViews();
                                    ImageView imageView = new ImageView(this.f213824d);
                                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                                    g16 = g(str, null, true);
                                    if (g16 instanceof URLDrawable) {
                                        QLog.d("EmoticonGuideBubbleView", 2, "showGuideBubble drawable status: " + ((URLDrawable) g16).getStatus());
                                    }
                                    imageView.setImageDrawable(g16);
                                    dip2px = ViewUtils.dip2px(i17 >> 1);
                                    int dip2px2 = ViewUtils.dip2px(i16 >> 1);
                                    if (dip2px >= ViewUtils.getScreenWidth()) {
                                    }
                                    imageView.setLayoutParams(new ViewGroup.LayoutParams(dip2px, dip2px2));
                                    imageView.setBackgroundResource(R.drawable.aio_emoticon_guide_bg);
                                    addView(imageView);
                                    setVisibility(0);
                                    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                                    setAnimation(alphaAnimation);
                                    alphaAnimation.setDuration(500L);
                                    alphaAnimation.setFillAfter(true);
                                    startAnimation(alphaAnimation);
                                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getLayoutParams();
                                    d16 = d(viewGroup2, z16);
                                    if (d16 > 0) {
                                    }
                                    layoutParams.rightMargin = d16;
                                    setLayoutParams(layoutParams);
                                    return this;
                                }
                                return null;
                            }
                        } catch (Exception e17) {
                            e = e17;
                            i16 = 0;
                        }
                    } catch (Exception e18) {
                        e = e18;
                        str2 = str;
                        i3 = 0;
                        i16 = 0;
                        if (QLog.isColorLevel()) {
                        }
                        z16 = false;
                        int i182 = i3;
                        str = str2;
                        i17 = i182;
                        if (!TextUtils.isEmpty(str)) {
                        }
                        return null;
                    }
                } catch (Exception e19) {
                    e = e19;
                }
                if (!TextUtils.isEmpty(str) && i17 > 0 && i16 > 0) {
                    removeAllViews();
                    ImageView imageView2 = new ImageView(this.f213824d);
                    imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
                    g16 = g(str, null, true);
                    if ((g16 instanceof URLDrawable) && QLog.isColorLevel()) {
                        QLog.d("EmoticonGuideBubbleView", 2, "showGuideBubble drawable status: " + ((URLDrawable) g16).getStatus());
                    }
                    imageView2.setImageDrawable(g16);
                    dip2px = ViewUtils.dip2px(i17 >> 1);
                    int dip2px22 = ViewUtils.dip2px(i16 >> 1);
                    if (dip2px >= ViewUtils.getScreenWidth()) {
                        int screenWidth = ViewUtils.getScreenWidth() / 2;
                        dip2px22 = (dip2px22 * screenWidth) / dip2px;
                        dip2px = screenWidth;
                    }
                    imageView2.setLayoutParams(new ViewGroup.LayoutParams(dip2px, dip2px22));
                    imageView2.setBackgroundResource(R.drawable.aio_emoticon_guide_bg);
                    addView(imageView2);
                    setVisibility(0);
                    AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
                    setAnimation(alphaAnimation2);
                    alphaAnimation2.setDuration(500L);
                    alphaAnimation2.setFillAfter(true);
                    startAnimation(alphaAnimation2);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) getLayoutParams();
                    d16 = d(viewGroup2, z16);
                    if (d16 > 0) {
                        ImageView imageView3 = new ImageView(this.f213824d);
                        imageView3.setImageDrawable(getResources().getDrawable(R.drawable.emoticon_guide_bubble_arrow));
                        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(ViewUtils.dip2px(13.0f), ViewUtils.dip2px(8.0f));
                        layoutParams3.gravity = 8388613;
                        layoutParams3.rightMargin = c(viewGroup2, imageView3, d16, z16);
                        layoutParams3.topMargin = -ViewUtils.dip2px(1.0f);
                        imageView3.setLayoutParams(layoutParams3);
                        addView(imageView3);
                    }
                    layoutParams2.rightMargin = d16;
                    setLayoutParams(layoutParams2);
                    return this;
                }
            }
        }
        return null;
    }

    protected Drawable g(String str, Drawable drawable, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Drawable) iPatchRedirector.redirect((short) 3, this, str, drawable, Boolean.valueOf(z16));
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        if (drawable == null) {
            if (this.f213825e == null) {
                this.f213825e = new ColorDrawable(0);
            }
            Drawable drawable2 = this.f213825e;
            obtain.mLoadingDrawable = drawable2;
            obtain.mFailedDrawable = drawable2;
        } else {
            obtain.mLoadingDrawable = drawable;
            obtain.mFailedDrawable = drawable;
        }
        obtain.mPlayGifImage = z16;
        return h(str, obtain);
    }

    protected URLDrawable h(String str, URLDrawable.URLDrawableOptions uRLDrawableOptions) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (URLDrawable) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) uRLDrawableOptions);
        }
        return URLDrawable.getDrawable(str, uRLDrawableOptions);
    }
}
