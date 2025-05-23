package com.qzone.common.activities.titlebuilder;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qzone.util.ar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.util.cu;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.TipsElementData;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import common.config.service.QzoneConfig;
import cooperation.qzone.widget.ExtendButton;

/* compiled from: P */
/* loaded from: classes39.dex */
public class c extends b {

    /* renamed from: l0, reason: collision with root package name */
    TextView f45577l0;

    /* renamed from: m0, reason: collision with root package name */
    String f45578m0;

    /* renamed from: n0, reason: collision with root package name */
    String f45579n0;

    /* renamed from: o0, reason: collision with root package name */
    String f45580o0;

    /* renamed from: p0, reason: collision with root package name */
    String f45581p0;

    /* renamed from: q0, reason: collision with root package name */
    String f45582q0;

    public c(f fVar) {
        super(fVar);
        this.f45578m0 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "TitlePublishMoodLeftView", "\u8fd4\u56de");
        this.f45579n0 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "TitlePublishMoodRightViewFinish", "\u5b8c\u6210");
        this.f45580o0 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "TitlePublishMoodCenterView", "\u79fb\u52a8\u548c\u88c1\u526a");
        this.f45581p0 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "TitlePublishMoodLeftButton", "\u53d6\u6d88");
        this.f45582q0 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "TitlePublishMoodRightViewPublish", "\u53d1\u8868");
    }

    public static boolean M() {
        return (cu.f() || cu.h()) && Build.VERSION.SDK_INT == 23;
    }

    private void N(View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        ViewGroup viewGroup = this.f45558h;
        if (viewGroup != null) {
            viewGroup.setBackgroundResource(R.drawable.qq_title_immersive_bar);
        }
        TextView textView = this.f45557f;
        if (textView != null) {
            textView.setTextColor(getResources().getColorStateList(R.color.skin_bar_btn));
            this.f45557f.setEnabled(true);
            this.f45557f.setText(this.f45579n0);
            this.f45557f.setVisibility(0);
            this.f45557f.setOnClickListener(onClickListener);
        }
        TextView textView2 = this.f45555d;
        if (textView2 != null) {
            textView2.setTextColor(getResources().getColorStateList(R.color.skin_bar_btn));
            this.f45555d.setText(this.f45578m0);
            this.f45555d.setOnClickListener(onClickListener2);
            this.f45555d.setVisibility(0);
        }
        SystemBarCompact systemBarCompact = this.C;
        if (systemBarCompact != null) {
            systemBarCompact.setStatusBarDrawable(getResources().getDrawable(R.drawable.qq_title_immersive_bar));
        }
        TextView textView3 = this.f45556e;
        if (textView3 != null) {
            textView3.setText(this.f45580o0);
            this.f45556e.setVisibility(0);
        }
        LinearLayout linearLayout = this.f45573h0;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        TextView textView4 = this.f45577l0;
        if (textView4 != null) {
            textView4.setVisibility(8);
        }
    }

    private void O(View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.f45574i0.setVisibility(8);
        ViewGroup viewGroup = this.f45558h;
        if (viewGroup != null) {
            viewGroup.setBackgroundColor(Color.parseColor("#000000"));
        }
        TextView textView = this.f45557f;
        if (textView != null) {
            textView.setText(this.f45582q0);
            this.f45557f.setVisibility(0);
            this.f45557f.setEnabled(true);
            this.f45557f.setOnClickListener(onClickListener);
        }
        TextView textView2 = this.f45577l0;
        if (textView2 != null) {
            textView2.setVisibility(0);
            this.f45577l0.setTextColor(Color.parseColor(TipsElementData.DEFAULT_COLOR));
            this.f45577l0.setText(this.f45581p0);
            this.f45577l0.setOnClickListener(onClickListener2);
        }
        if (this.C != null) {
            if (M()) {
                this.C.setgetStatusBarVisible(true, 0);
            }
            this.C.setStatusBarColor(Color.parseColor("#000000"));
            if (ImmersiveUtils.couldSetStatusTextColor()) {
                ImmersiveUtils.setStatusTextColor(false, f().getWindow());
            }
        }
        LinearLayout linearLayout = this.f45573h0;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        ExtendButton extendButton = this.f45566a0;
        if (extendButton != null) {
            extendButton.setTextColor(getResources().getColorStateList(R.color.f157912a92));
            this.f45566a0.setBackgroundColor(0);
            this.f45569d0.setVisibility(8);
            this.f45566a0.getPaint().setFakeBoldText(false);
        }
        ExtendButton extendButton2 = this.f45567b0;
        if (extendButton2 != null) {
            extendButton2.setTextColor(getResources().getColorStateList(R.color.f157912a92));
            this.f45567b0.setBackgroundColor(0);
            this.f45570e0.setVisibility(0);
            this.f45567b0.getPaint().setFakeBoldText(true);
        }
        J(false);
        L(true);
        ExtendButton extendButton3 = this.f45567b0;
        if (extendButton3 != null) {
            extendButton3.setClickable(false);
        }
        ExtendButton extendButton4 = this.f45566a0;
        if (extendButton4 != null) {
            extendButton4.setClickable(true);
        }
        TextView textView3 = this.f45555d;
        if (textView3 != null) {
            textView3.setVisibility(8);
        }
        TextView textView4 = this.f45556e;
        if (textView4 != null) {
            textView4.setVisibility(8);
        }
    }

    private void Q(View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        int color;
        this.f45574i0.setVisibility(0);
        ViewGroup viewGroup = this.f45558h;
        if (viewGroup != null) {
            if (com.tencent.mobileqq.simpleui.b.c()) {
                color = SimpleUIUtil.getSimpleUiBgColor();
            } else {
                color = getResources().getColor(R.color.qzone_skin_common_white2black_color);
            }
            viewGroup.setBackgroundColor(color);
        }
        if (this.f45557f != null) {
            if (com.tencent.mobileqq.simpleui.b.c() && SimpleUIUtil.getSimpleUiBgColor() != -1 && SimpleUIUtil.getSimpleUiBgColor() != -657670) {
                this.f45557f.setBackgroundResource(R.drawable.hin);
                this.f45557f.setTextColor(-16777216);
            } else {
                this.f45557f.setBackgroundResource(R.drawable.art);
            }
            this.f45557f.setText(this.f45582q0);
            ((RelativeLayout.LayoutParams) this.f45557f.getLayoutParams()).setMargins(0, 0, ar.d(12.0f), 0);
            this.f45557f.setVisibility(0);
            this.f45557f.setOnClickListener(onClickListener);
        }
        if (this.f45577l0 != null) {
            if (com.tencent.mobileqq.simpleui.b.c() && !SimpleUIUtil.useDarkResource()) {
                this.f45577l0.setTextColor(-1);
            } else {
                this.f45577l0.setTextColor(getResources().getColor(R.color.qzone_skin_common_black2white_color));
            }
            this.f45577l0.setText(this.f45581p0);
            this.f45577l0.setGravity(3);
            ((RelativeLayout.LayoutParams) this.f45577l0.getLayoutParams()).setMargins(ar.d(8.0f), 0, 0, 0);
            this.f45577l0.setOnClickListener(onClickListener2);
            this.f45577l0.setVisibility(0);
        }
        if (this.C != null) {
            if (com.tencent.mobileqq.simpleui.b.c()) {
                this.C.setStatusBarColor(SimpleUIUtil.getSimpleUiBgColor());
                if (ImmersiveUtils.couldSetStatusTextColor()) {
                    ImmersiveUtils.setStatusTextColor(SimpleUIUtil.useDarkResource(), f().getWindow());
                } else {
                    this.C.setStatusBarColor(SimpleUIUtil.SIMPLE_UI_STATUS_BAR_COLOR_PRE_M);
                }
            } else {
                this.C.setStatusBarColor(getResources().getColor(R.color.qzone_skin_common_white2black_color));
                if (ImmersiveUtils.couldSetStatusTextColor()) {
                    ImmersiveUtils.setStatusTextColor(!QQTheme.isNowThemeIsNightForQzone(), f().getWindow());
                } else {
                    this.C.setStatusBarColor(SimpleUIUtil.SIMPLE_UI_STATUS_BAR_COLOR_PRE_M);
                }
            }
            if (M()) {
                this.C.setStatusBarColor(getResources().getColor(R.color.f158017al3));
            }
        }
        LinearLayout linearLayout = this.f45573h0;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        if (this.f45566a0 != null) {
            if (com.tencent.mobileqq.simpleui.b.c() && !SimpleUIUtil.useDarkResource()) {
                this.f45566a0.setTextColor(-1);
            } else {
                this.f45566a0.setTextColor(getResources().getColor(R.color.qzone_skin_common_black2white_color));
            }
            this.f45566a0.setBackgroundColor(0);
            this.f45569d0.setVisibility(0);
            this.f45566a0.getPaint().setFakeBoldText(true);
        }
        if (this.f45567b0 != null) {
            if (com.tencent.mobileqq.simpleui.b.c() && !SimpleUIUtil.useDarkResource()) {
                this.f45567b0.setTextColor(-1);
            } else {
                this.f45567b0.setTextColor(getResources().getColorStateList(R.color.a8l));
            }
            this.f45567b0.setBackgroundColor(0);
            this.f45570e0.setVisibility(8);
            this.f45567b0.getPaint().setFakeBoldText(false);
        }
        J(true);
        L(false);
        ExtendButton extendButton = this.f45567b0;
        if (extendButton != null) {
            extendButton.setClickable(true);
        }
        ExtendButton extendButton2 = this.f45566a0;
        if (extendButton2 != null) {
            extendButton2.setClickable(false);
        }
        TextView textView = this.f45556e;
        if (textView != null) {
            textView.setVisibility(8);
        }
        TextView textView2 = this.f45555d;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
    }

    @Override // com.qzone.common.activities.titlebuilder.b, com.qzone.common.activities.titlebuilder.QzoneBaseTitle, com.qzone.common.activities.titlebuilder.a
    public void K3(Intent intent) {
        super.K3(intent);
        this.f45577l0 = (TextView) d(R.id.ivTitleBtnLeftButton);
        this.f45557f.setTextColor(getResources().getColorStateList(R.color.f157916aa0));
        this.f45557f.setBackgroundResource(R.drawable.art);
        this.f45557f.setTextSize(2, 14.0f);
        this.f45557f.setPadding(ar.e(15.0f), ar.e(3.5f), ar.e(15.0f), ar.e(3.5f));
        this.f45557f.getLayoutParams().height = ar.e(29.0f);
    }

    public void R(SystemBarCompact systemBarCompact) {
        this.C = systemBarCompact;
    }

    @Override // com.qzone.common.activities.titlebuilder.QzoneBaseTitle
    protected View q() {
        return this.f45556e;
    }

    public void S(int i3, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        if (i3 == 0) {
            Q(onClickListener, onClickListener2);
        } else if (i3 == 1) {
            O(onClickListener, onClickListener2);
        } else if (i3 == 2) {
            N(onClickListener, onClickListener2);
        }
    }
}
