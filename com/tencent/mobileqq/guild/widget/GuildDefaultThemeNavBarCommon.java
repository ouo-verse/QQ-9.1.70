package com.tencent.mobileqq.guild.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.FadeIconImageView;
import java.util.Arrays;
import oh1.DrawableType;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildDefaultThemeNavBarCommon extends RelativeLayout implements View.OnClickListener, View.OnLongClickListener {
    private ImageView C;
    private TextView D;
    private ImageView E;
    private RelativeLayout F;
    private TextView G;
    private TextView H;
    private a I;
    private ViewStub J;
    private boolean K;
    private RelativeLayout L;
    private TextView M;
    protected boolean N;

    /* renamed from: d, reason: collision with root package name */
    private TextView f235837d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f235838e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f235839f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f235840h;

    /* renamed from: i, reason: collision with root package name */
    private ImageView f235841i;

    /* renamed from: m, reason: collision with root package name */
    private TextView f235842m;

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface a {
        boolean onItemLongClick(View view, int i3);

        void onItemSelect(View view, int i3);
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static abstract class b implements a {
        @Override // com.tencent.mobileqq.guild.widget.GuildDefaultThemeNavBarCommon.a
        public boolean onItemLongClick(View view, int i3) {
            return false;
        }
    }

    public GuildDefaultThemeNavBarCommon(Context context) {
        super(context);
        this.K = true;
        this.N = false;
        i(context);
    }

    private int e(int i3) {
        if (i3 != R.id.ivTitleBtnLeft && i3 != R.id.k4f && i3 != R.id.f165972dz1) {
            if (i3 == R.id.ivTitleBtnRightText) {
                return 2;
            }
            if (i3 == R.id.ivTitleBtnRightImage) {
                return 4;
            }
            if (i3 == R.id.f165893dt0) {
                return 3;
            }
            if (i3 == R.id.dsr) {
                return 5;
            }
            if (i3 != R.id.ivTitleName && i3 != R.id.jp7) {
                if (i3 == R.id.ivTitleBtnLeftButton) {
                    return 8;
                }
                return 0;
            }
            return 7;
        }
        return 1;
    }

    private void i(Context context) {
        vp1.ah f16 = vp1.ah.f(LayoutInflater.from(context), this);
        setBackgroundResource(R.drawable.qq_title_immersive_bar);
        this.f235837d = f16.f442208b;
        this.f235842m = f16.f442218l;
        this.C = f16.f442212f;
        this.f235838e = f16.f442209c;
        this.f235839f = f16.f442211e;
        this.F = f16.f442216j;
        this.G = f16.f442217k;
        this.H = f16.f442214h;
        this.f235840h = (TextView) f16.getRoot().findViewById(R.id.ivTitleBtnRightText);
        this.E = (ImageView) f16.getRoot().findViewById(R.id.dsr);
        this.D = (TextView) f16.getRoot().findViewById(R.id.f165893dt0);
        this.f235841i = (ImageView) f16.getRoot().findViewById(R.id.ivTitleBtnRightImage);
        this.J = f16.f442215i;
        RelativeLayout root = f16.f442213g.getRoot();
        this.L = root;
        this.M = (TextView) root.findViewById(R.id.ivTitleBtnRightText);
        if (AppSetting.f99565y) {
            AccessibilityUtil.d(this.f235837d, Button.class.getName());
            AccessibilityUtil.d(this.f235842m, Button.class.getName());
            AccessibilityUtil.d(this.C, Button.class.getName());
        }
    }

    public static void setLayerType(View view) {
        if (view == null) {
            return;
        }
        view.setLayerType(0, null);
    }

    public void a() {
        setBackground(getResources().getDrawable(R.drawable.qui_common_bg_bottom_light_bg));
        new DrawableType(R.drawable.guild_back_left, Integer.valueOf(R.color.qui_common_icon_primary)).a(this.f235837d);
        ColorStateList r16 = GuildUIUtils.r(getResources().getColor(R.color.qui_common_text_primary));
        this.M.setTextColor(r16);
        this.f235837d.setTextColor(r16);
        this.f235842m.setTextColor(r16);
        this.f235838e.setTextColor(r16);
        this.f235839f.setTextColor(r16);
        TextView textView = this.G;
        if (textView != null) {
            textView.setTextColor(r16);
        }
        TextView textView2 = this.H;
        if (textView2 != null) {
            textView2.setTextColor(r16);
        }
    }

    public void b(int i3) {
        setBackgroundResource(i3);
        ColorStateList colorStateList = getResources().getColorStateList(R.color.guild_bar_btn_black);
        this.f235837d.setTextColor(colorStateList);
        this.f235837d.setBackgroundResource(R.drawable.guild_skin_leftbar_guide_icon);
        this.f235838e.setTextColor(colorStateList);
        this.f235842m.setTextColor(colorStateList);
        this.f235839f.setTextColor(colorStateList);
        this.f235840h.setTextColor(colorStateList);
        this.D.setTextColor(colorStateList);
        this.M.setTextColor(colorStateList);
    }

    public void c(boolean z16) {
        this.f235840h.setEnabled(z16);
    }

    public TextView d() {
        return this.H;
    }

    public TextView f() {
        return this.f235837d;
    }

    public TextView g() {
        return this.f235838e;
    }

    public TextView h() {
        return this.f235840h;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int e16;
        EventCollector.getInstance().onViewClickedBefore(view);
        if (this.I != null && (e16 = e(view.getId())) != 0) {
            this.I.onItemSelect(view, e16);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        int e16;
        EventCollector.getInstance().onViewLongClickedBefore(view);
        boolean z16 = false;
        if (this.I != null && (e16 = e(view.getId())) != 0) {
            z16 = this.I.onItemLongClick(view, e16);
        }
        EventCollector.getInstance().onViewLongClicked(view);
        return z16;
    }

    public void setCustomView(View view) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, ViewUtils.dip2px(29.0f));
        this.f235839f.setVisibility(8);
        layoutParams.addRule(13, -1);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.F.getLayoutParams();
        int dip2px = ViewUtils.dip2px(24.0f);
        layoutParams2.leftMargin = dip2px;
        layoutParams2.rightMargin = dip2px;
        this.F.setLayoutParams(layoutParams2);
        this.F.addView(view, layoutParams);
        this.F.setVisibility(0);
    }

    public void setLeftBackVisible(int i3) {
        ViewUtils.setVisible(this.f235837d, i3);
    }

    public void setLeftText(int i3) {
        this.f235837d.setVisibility(8);
        TextView textView = (TextView) findViewById(R.id.ivTitleBtnLeftButton);
        this.f235838e = textView;
        setLayerType(textView);
        this.f235838e.setVisibility(0);
        this.f235838e.setText(i3);
    }

    public void setLeftTextColor(ColorStateList colorStateList) {
        this.f235838e.setTextColor(colorStateList);
    }

    public void setLeftViewName(Bundle bundle) {
        if (this.f235837d == null || bundle == null) {
            return;
        }
        TextView textView = this.f235838e;
        if (textView != null) {
            textView.setVisibility(8);
        }
        try {
            TextView textView2 = this.f235837d;
            String string = bundle.getString(AppConstants.LeftViewText.LEFTVIEWTEXT);
            int i3 = bundle.getInt("individuation_url_type");
            if (i3 >= 40300 && i3 <= 40313 && !TextUtils.isEmpty(string) && string.contains(HardCodeUtil.qqStr(R.string.f142560jp))) {
                string = getContext().getString(R.string.f142510jk);
            }
            if (string == null) {
                string = getContext().getString(R.string.f142510jk);
            }
            if (this.K) {
                textView2.setText("  ");
            } else {
                textView2.setText(string);
            }
            textView2.setVisibility(0);
            if (AppSetting.f99565y) {
                if (!string.contains(getContext().getString(R.string.f142510jk))) {
                    string = getContext().getString(R.string.f142510jk) + string;
                }
                this.f235837d.setContentDescription(string);
            }
        } catch (Exception unused) {
        }
    }

    public void setNotShowLeftText(boolean z16) {
        this.K = z16;
    }

    public void setOnItemSelectListener(a aVar) {
        this.I = aVar;
        for (View view : Arrays.asList(this.f235837d, this.f235842m, this.C, this.f235838e, this.f235840h, this.D, this.f235841i, this.E, this.f235839f, this.F)) {
            view.setOnClickListener(this);
            view.setOnLongClickListener(this);
        }
    }

    public void setRightButton2(int i3) {
        this.D.setVisibility(0);
        this.f235841i.setVisibility(8);
        this.D.setText(i3);
        this.D.setEnabled(true);
        if (AppSetting.f99565y) {
            this.f235840h.setContentDescription(((Object) this.f235840h.getText()) + HardCodeUtil.qqStr(R.string.f142520jl));
        }
    }

    public void setRightDrawable(@DrawableRes int i3) {
        FadeIconImageView fadeIconImageView = (FadeIconImageView) findViewById(R.id.ivTitleBtnRightImage);
        if (i3 == 0) {
            fadeIconImageView.setVisibility(8);
        } else {
            fadeIconImageView.setImageResource(i3);
            fadeIconImageView.setVisibility(0);
        }
    }

    public void setRightImage(Drawable drawable) {
        this.E.setVisibility(0);
        this.f235840h.setVisibility(8);
        this.E.setImageDrawable(drawable);
    }

    public void setRightImage2(Drawable drawable) {
        this.f235841i.setImageDrawable(drawable);
        this.f235841i.setVisibility(0);
        this.D.setVisibility(8);
    }

    public void setRightImage2Desc(String str) {
        this.f235841i.setContentDescription(str);
    }

    public void setRightImageDesc(String str) {
        this.E.setContentDescription(str);
    }

    public void setRightText(int i3) {
        this.f235840h.setVisibility(0);
        this.E.setVisibility(8);
        this.f235840h.setText(i3);
        this.f235840h.setEnabled(true);
        if (AppSetting.f99565y) {
            this.f235840h.setContentDescription(((Object) this.f235840h.getText()) + HardCodeUtil.qqStr(R.string.f142520jl));
        }
    }

    public void setRightViewTextVisible(int i3) {
        ViewUtils.setVisible(this.f235840h, i3);
    }

    public void setSubTitleWithIcon(String str, String str2, @Nullable Drawable drawable) {
        this.f235839f.setVisibility(8);
        this.F.setVisibility(0);
        this.G.setText(str);
        this.H.setText(str2);
        if (drawable != null) {
            drawable.setBounds(0, 0, QQGuildUIUtil.f(11.0f), QQGuildUIUtil.f(11.0f));
            this.H.setCompoundDrawablesRelative(drawable, null, null, null);
        }
    }

    public void setTitle(CharSequence charSequence) {
        TextView textView = this.f235839f;
        if (textView != null) {
            textView.setText(charSequence);
            this.f235839f.setVisibility(0);
        }
        RelativeLayout relativeLayout = this.F;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
    }

    public void setTitleColor(int i3) {
        TextView textView = this.f235839f;
        if (textView != null) {
            textView.setTextColor(i3);
            this.f235839f.setVisibility(0);
        }
    }

    public void setRightImage(Drawable drawable, Drawable drawable2) {
        this.E.setVisibility(0);
        this.f235840h.setVisibility(8);
        this.E.setImageDrawable(drawable);
        this.E.setBackgroundDrawable(drawable2);
    }

    public void setTitleColor(ColorStateList colorStateList) {
        TextView textView = this.f235839f;
        if (textView != null) {
            textView.setTextColor(colorStateList);
            this.f235839f.setVisibility(0);
        }
    }

    public GuildDefaultThemeNavBarCommon(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.K = true;
        this.N = false;
        i(context);
    }

    public void setLeftText(String str) {
        this.f235837d.setVisibility(8);
        TextView textView = (TextView) findViewById(R.id.ivTitleBtnLeftButton);
        this.f235838e = textView;
        setLayerType(textView);
        this.f235838e.setVisibility(0);
        this.f235838e.setText(str);
    }

    public void setTitle(CharSequence charSequence, String str) {
        TextView textView = this.f235839f;
        if (textView != null) {
            if (textView.getVisibility() != 0) {
                this.f235839f.setVisibility(0);
            }
            if (!TextUtils.equals(charSequence, this.f235839f.getText())) {
                this.f235839f.setText(charSequence);
            }
            if (!TextUtils.equals(str, this.f235839f.getContentDescription()) && AppSetting.f99565y) {
                this.f235839f.setContentDescription(str);
            }
        }
        RelativeLayout relativeLayout = this.F;
        if (relativeLayout == null || relativeLayout.getVisibility() == 8) {
            return;
        }
        this.F.setVisibility(8);
    }

    public void setRightText(@Nullable String str) {
        if (str == null) {
            this.f235840h.setVisibility(8);
            return;
        }
        this.f235840h.setVisibility(0);
        this.E.setVisibility(8);
        this.f235840h.setText(str);
        this.f235840h.setEnabled(true);
        if (AppSetting.f99565y) {
            this.f235840h.setContentDescription(((Object) this.f235840h.getText()) + HardCodeUtil.qqStr(R.string.f142520jl));
        }
    }

    public GuildDefaultThemeNavBarCommon(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.K = true;
        this.N = false;
        i(context);
    }

    public void setTitle(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4) {
        if (this.f235839f.getVisibility() != 8) {
            this.f235839f.setVisibility(8);
        }
        if (this.F.getVisibility() != 0) {
            this.F.setVisibility(0);
        }
        if (!TextUtils.equals(charSequence, this.G.getText())) {
            this.G.setText(charSequence);
            this.G.setContentDescription(charSequence2);
        }
        if (TextUtils.equals(charSequence3, this.H.getText())) {
            return;
        }
        this.H.setText(charSequence3);
        this.H.setContentDescription(charSequence4);
    }

    public void setLeftViewName(int i3) {
        if (this.f235837d != null) {
            TextView textView = this.f235838e;
            if (textView != null) {
                textView.setVisibility(8);
            }
            String string = getContext().getString(i3);
            TextView textView2 = this.f235837d;
            if ("".equals(string)) {
                string = getContext().getString(R.string.f142510jk);
            }
            if (this.K) {
                textView2.setText("  ");
            } else {
                textView2.setText(string);
            }
            textView2.setVisibility(0);
            if (AppSetting.f99565y) {
                if (!string.contains(getContext().getString(R.string.f142510jk))) {
                    string = getContext().getString(R.string.f142510jk) + string;
                }
                this.f235837d.setContentDescription(string);
            }
        }
    }
}
