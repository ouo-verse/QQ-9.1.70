package com.tencent.mobileqq.guild.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.widget.GuildSwitchButton;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes14.dex */
public class TextAndSwitchButtonBar extends FrameLayout {
    public static String D = "TextAndSwitchButtonBar";
    private View C;

    /* renamed from: d, reason: collision with root package name */
    private ButtonState f236162d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f236163e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f236164f;

    /* renamed from: h, reason: collision with root package name */
    private GuildSwitchButton f236165h;

    /* renamed from: i, reason: collision with root package name */
    private ImageView f236166i;

    /* renamed from: m, reason: collision with root package name */
    private View f236167m;

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public enum ButtonState {
        SWITCH_BUTTON,
        IMAGE_ICON
    }

    public TextAndSwitchButtonBar(Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        View inflate = View.inflate(context, R.layout.f9v, this);
        this.f236163e = (TextView) inflate.findViewById(R.id.jq_);
        this.f236164f = (TextView) inflate.findViewById(R.id.f907953f);
        this.f236165h = (GuildSwitchButton) inflate.findViewById(R.id.i_w);
        this.f236166i = (ImageView) inflate.findViewById(R.id.f166795ia4);
        this.f236167m = inflate.findViewById(R.id.w7b);
        this.C = inflate;
    }

    private void b(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, up1.a.f439624pa);
        String string = obtainStyledAttributes.getString(up1.a.f439689ua);
        String string2 = obtainStyledAttributes.getString(up1.a.f439676ta);
        setShowBottomDividerLine(obtainStyledAttributes.getBoolean(up1.a.f439663sa, false));
        this.f236162d = ButtonState.values()[obtainStyledAttributes.getInt(up1.a.f439637qa, 0)];
        boolean z16 = obtainStyledAttributes.getBoolean(up1.a.f439650ra, false);
        obtainStyledAttributes.recycle();
        setTitle(string);
        setSummary(string2);
        ButtonState buttonState = this.f236162d;
        if (buttonState == ButtonState.SWITCH_BUTTON) {
            setBtnNormal(z16, true);
            return;
        }
        if (buttonState == ButtonState.IMAGE_ICON) {
            setBtnReplacedWithIcon();
            return;
        }
        QLog.e(D, 1, "resolveAttrs(): unknown buttonState: " + this.f236162d);
    }

    public void setBtnNormal(boolean z16, boolean z17) {
        this.f236166i.setVisibility(8);
        this.f236165h.setVisibility(0);
        this.f236165h.setCheckedOnly(z16);
        this.f236165h.setClickable(z17);
    }

    public void setBtnReplacedWithIcon() {
        this.f236165h.setVisibility(8);
        this.f236166i.setVisibility(0);
        this.f236165h.setCheckedOnly(true);
    }

    public void setChecked(boolean z16) {
        this.f236165h.setChecked(z16);
    }

    public void setProperty(String str, String str2, ButtonState buttonState, boolean z16, boolean z17, boolean z18) {
        this.f236162d = buttonState;
        setTitle(str);
        setSummary(str2);
        setShowBottomDividerLine(z18);
        ButtonState buttonState2 = this.f236162d;
        if (buttonState2 == ButtonState.SWITCH_BUTTON) {
            setBtnNormal(z16, z17);
            return;
        }
        if (buttonState2 == ButtonState.IMAGE_ICON) {
            setBtnReplacedWithIcon();
            return;
        }
        QLog.e(D, 1, "resolveInfo(): unknown buttonState: " + this.f236162d);
    }

    public void setRightButtonClickable(boolean z16) {
        if (this.f236162d == ButtonState.SWITCH_BUTTON) {
            this.f236165h.setClickable(z16);
        }
    }

    public void setRightButtonListener(GuildSwitchButton.a aVar) {
        if (this.f236162d == ButtonState.SWITCH_BUTTON) {
            this.f236165h.setOnCheckedChangeListener(aVar);
        }
    }

    public void setRootViewBackgroundDrawable(Drawable drawable) {
        this.C.setBackground(drawable);
    }

    public void setShowBottomDividerLine(boolean z16) {
        int i3;
        View view = this.f236167m;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        view.setVisibility(i3);
    }

    public void setSummary(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f236164f.setText(str);
            this.f236164f.setVisibility(0);
        } else {
            this.f236164f.setVisibility(8);
        }
    }

    public void setSummaryMarginTop(int i3) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f236164f.getLayoutParams();
        layoutParams.topMargin = i3;
        this.f236164f.setLayoutParams(layoutParams);
    }

    public void setTagForSwitchBtn(Object obj) {
        this.f236165h.setTag(obj);
    }

    public void setTitle(String str) {
        this.f236163e.setText(str);
    }

    public TextAndSwitchButtonBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
        b(context, attributeSet);
    }

    public TextAndSwitchButtonBar(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        a(context);
        b(context, attributeSet);
    }
}
