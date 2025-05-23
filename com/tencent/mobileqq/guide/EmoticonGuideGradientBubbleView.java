package com.tencent.mobileqq.guide;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes12.dex */
public class EmoticonGuideGradientBubbleView extends RelativeLayout implements com.tencent.mobileqq.guide.a {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    protected Context f213828d;

    /* renamed from: e, reason: collision with root package name */
    protected View f213829e;

    /* renamed from: f, reason: collision with root package name */
    private View f213830f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements Animation.AnimationListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) EmoticonGuideGradientBubbleView.this);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
            } else {
                QLog.d("EmoticonGradientGuideBubbleView", 2, "removeGuideBubble fadeoutanimation ended");
                EmoticonGuideGradientBubbleView.this.setVisibility(8);
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
                QLog.d("EmoticonGradientGuideBubbleView", 2, "removeGuideBubble onAnimationStart");
            }
        }
    }

    public EmoticonGuideGradientBubbleView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f213828d = context;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 8388613;
        setLayoutParams(layoutParams);
        setGravity(8388613);
        setVisibility(8);
        setClipChildren(false);
        setClipToPadding(false);
        setPadding(0, 0, 0, ViewUtils.dip2px(6.0f));
    }

    private int c(ViewGroup viewGroup, int i3, int i16, boolean z16) {
        int i17;
        int dip2px;
        int right = viewGroup.getRight();
        int i18 = i(viewGroup);
        int width = this.f213829e.getWidth();
        int measuredWidth = getMeasuredWidth();
        if (z16) {
            i17 = (((((width / 2) + i18) - right) + measuredWidth) + i16) - ((i3 * 3) / 4);
            dip2px = ViewUtils.dip2px(1.0f);
        } else {
            i17 = (((right - i18) - (width / 2)) - ((i3 * 3) / 4)) - i16;
            dip2px = ViewUtils.dip2px(1.0f);
        }
        int i19 = i17 + dip2px;
        if (QLog.isColorLevel()) {
            QLog.d("EmoticonGradientGuideBubbleView", 2, "calcArrowOffset arrowOffset:", Integer.valueOf(i19), " ,emoIconWidth:", Integer.valueOf(width), " ,emoIconLocationX:", Integer.valueOf(i18), " ,arrowWidth:", Integer.valueOf(i3), " ,panelRight:", Integer.valueOf(right));
        }
        return e(i19);
    }

    private int d(View view, boolean z16) {
        int i3;
        int i16;
        int right = view.getRight();
        int i17 = i(view);
        int width = this.f213829e.getWidth();
        measure(0, 0);
        int measuredWidth = getMeasuredWidth();
        if (z16) {
            i3 = right - (i17 - ViewUtils.dip2px(20.0f));
            i16 = measuredWidth / 2;
        } else {
            i3 = right - ((width / 2) + i17);
            i16 = measuredWidth / 2;
        }
        int i18 = i3 - i16;
        if (QLog.isColorLevel()) {
            QLog.d("EmoticonGradientGuideBubbleView", 2, "calcOffset offset:", Integer.valueOf(i18), " ,bubbleWidth:", Integer.valueOf(measuredWidth), " ,emoIconWidth:", Integer.valueOf(width), " ,emoIconLocationX:", Integer.valueOf(i17), " ,panelRight:", Integer.valueOf(right));
        }
        return e(i18);
    }

    private int e(int i3) {
        if (i3 <= 0 || getMeasuredWidth() + i3 >= ViewUtils.getScreenWidth()) {
            return ViewUtils.dip2px(6.0f);
        }
        return i3;
    }

    private QUICustomGradientBubbleView f() {
        QUICustomGradientBubbleView qUICustomGradientBubbleView = new QUICustomGradientBubbleView(this.f213828d);
        qUICustomGradientBubbleView.setBubbleColor(getResources().getColor(R.color.qui_common_fill_light_secondary));
        qUICustomGradientBubbleView.setArrowPosition(0);
        qUICustomGradientBubbleView.setEnableShadow(false);
        qUICustomGradientBubbleView.setEnableBound(false);
        qUICustomGradientBubbleView.setPadding(ViewUtils.dip2px(2.0f), ViewUtils.dip2px(2.0f), ViewUtils.dip2px(2.0f), ViewUtils.dip2px(2.0f));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(5, this.f213830f.getId());
        layoutParams.addRule(7, this.f213830f.getId());
        layoutParams.addRule(6, this.f213830f.getId());
        layoutParams.addRule(8, this.f213830f.getId());
        qUICustomGradientBubbleView.setLayoutParams(layoutParams);
        addView(qUICustomGradientBubbleView);
        return qUICustomGradientBubbleView;
    }

    private void g(List<Integer> list, String str) {
        if (this.f213830f == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.duu, (ViewGroup) null);
            this.f213830f = inflate;
            inflate.setId(R.id.uta);
        }
        TextView textView = (TextView) this.f213830f.findViewById(R.id.f1063668i);
        if (!TextUtils.isEmpty(str)) {
            textView.setText(str);
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
        }
        LinearLayout linearLayout = (LinearLayout) this.f213830f.findViewById(R.id.xi6);
        if (list != null && !list.isEmpty()) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewUtils.dip2px(24.0f), ViewUtils.dip2px(24.0f));
            for (Integer num : list) {
                URLImageView uRLImageView = new URLImageView(getContext());
                Drawable faceGifDrawable = QQSysFaceUtil.getFaceGifDrawable(num.intValue());
                if (faceGifDrawable != null) {
                    uRLImageView.setBackground(faceGifDrawable);
                    linearLayout.addView(uRLImageView, layoutParams);
                    linearLayout.setVisibility(0);
                }
            }
            return;
        }
        linearLayout.setVisibility(8);
    }

    private int i(View view) {
        int i3;
        if (view == null) {
            return 0;
        }
        int right = view.getRight();
        int[] iArr = new int[2];
        this.f213829e.getLocationOnScreen(iArr);
        int i16 = iArr[0];
        if (AppSetting.t(getContext()) && (i3 = iArr[0]) > right) {
            i16 = i3 - right;
        }
        if (QLog.isColorLevel()) {
            QLog.d("EmoticonGradientGuideBubbleView", 4, "[getEmoIconLocationX] : emoIconLocation[0] = " + iArr[0] + " panelRight = " + right + " emoIconLocationX = " + i16);
        }
        return i16;
    }

    @Override // com.tencent.mobileqq.guide.a
    public void b(ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) viewGroup);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("EmoticonGradientGuideBubbleView", 2, "removeGuideBubble ");
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

    /* JADX WARN: Removed duplicated region for block: B:33:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00db  */
    @Override // com.tencent.mobileqq.guide.a
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public EmoticonGuideGradientBubbleView a(ViewGroup viewGroup, ViewGroup viewGroup2, View view, Map<String, Object> map) {
        String str;
        Exception e16;
        List<Integer> list;
        boolean z16;
        View view2;
        int d16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (EmoticonGuideGradientBubbleView) iPatchRedirector.redirect((short) 2, this, viewGroup, viewGroup2, view, map);
        }
        if (viewGroup != null && viewGroup2 != null) {
            if (getVisibility() == 0) {
                b(viewGroup);
                return null;
            }
            if (view != null) {
                this.f213829e = view;
            }
            if (this.f213829e != null && map != null && !map.isEmpty()) {
                try {
                    list = (List) map.get("res_id_list");
                    try {
                        str = (String) map.get("text");
                        try {
                            z16 = ((Boolean) map.get("now_theme_is_simple")).booleanValue();
                        } catch (Exception e17) {
                            e16 = e17;
                            if (QLog.isColorLevel()) {
                                QLog.w("EmoticonGradientGuideBubbleView", 2, "generateGuideBubble Exception:", e16);
                            }
                            z16 = false;
                            removeAllViews();
                            if (QLog.isColorLevel()) {
                            }
                            g(list, str);
                            QUICustomGradientBubbleView f16 = f();
                            view2 = this.f213830f;
                            if (view2 != null) {
                            }
                            if (list == null) {
                            }
                            setVisibility(8);
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
                    } catch (Exception e18) {
                        str = "";
                        e16 = e18;
                    }
                } catch (Exception e19) {
                    str = "";
                    e16 = e19;
                    list = null;
                }
                removeAllViews();
                if (QLog.isColorLevel()) {
                    QLog.d("EmoticonGradientGuideBubbleView", 2, "generateGuideBubble start");
                }
                g(list, str);
                QUICustomGradientBubbleView f162 = f();
                view2 = this.f213830f;
                if (view2 != null) {
                    removeView(view2);
                    addView(this.f213830f);
                }
                if (list == null && !list.isEmpty()) {
                    setVisibility(0);
                } else {
                    setVisibility(8);
                }
                AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
                setAnimation(alphaAnimation2);
                alphaAnimation2.setDuration(500L);
                alphaAnimation2.setFillAfter(true);
                startAnimation(alphaAnimation2);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) getLayoutParams();
                d16 = d(viewGroup2, z16);
                if (d16 > 0) {
                    f162.setArrowOffsetX(c(viewGroup2, f162.g(), d16, z16));
                }
                layoutParams2.rightMargin = d16;
                setLayoutParams(layoutParams2);
                return this;
            }
        }
        return null;
    }
}
