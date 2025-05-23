package com.tencent.guild.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import yq0.a;

/* compiled from: P */
/* loaded from: classes6.dex */
public class GuildCheckBox extends CheckBox {

    /* renamed from: d, reason: collision with root package name */
    private int f112672d;

    /* renamed from: e, reason: collision with root package name */
    private int f112673e;

    public GuildCheckBox(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void c() {
        g();
        f();
        d(this);
        a();
    }

    private static void d(CheckBox checkBox) {
        checkBox.setButtonDrawable((Drawable) null);
        checkBox.setGravity(17);
        checkBox.setTextColor(-1);
    }

    private static void e(CheckBox checkBox, int i3, int i16) {
        float f16 = i3;
        checkBox.setWidth(ViewUtils.dip2px(f16));
        checkBox.setHeight(ViewUtils.dip2px(f16));
        ViewGroup.LayoutParams layoutParams = checkBox.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-2, -2);
        }
        layoutParams.width = ViewUtils.dip2px(f16);
        layoutParams.height = ViewUtils.dip2px(f16);
        checkBox.setLayoutParams(layoutParams);
        checkBox.setTextSize(i16);
    }

    private void f() {
        if (!isEnabled()) {
            if (this.f112672d == 2) {
                setBackgroundResource(R.drawable.qui_common_check_box_no_bg);
                return;
            } else {
                setBackgroundResource(R.drawable.qui_common_check_box_disable);
                return;
            }
        }
        int i3 = this.f112672d;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            setBackgroundResource(R.drawable.qui_common_check_box);
                            return;
                        } else {
                            setBackgroundResource(R.drawable.qui_common_check_box_with_text_white_border);
                            return;
                        }
                    }
                    setBackgroundResource(R.drawable.qui_common_check_box_white_border);
                    return;
                }
                setBackgroundResource(R.drawable.qui_common_check_box_no_bg);
                return;
            }
            setBackgroundResource(R.drawable.qui_common_check_box_with_text);
            return;
        }
        setBackgroundResource(R.drawable.qui_common_check_box);
    }

    private void g() {
        int i3 = this.f112673e;
        if (i3 == 0) {
            e(this, 24, 14);
            return;
        }
        if (i3 == 1) {
            e(this, 20, 12);
        } else if (i3 == 2) {
            e(this, 16, 12);
        } else {
            e(this, 24, 14);
        }
    }

    public void a() {
        int dip2px = ViewUtils.dip2px(32.0f);
        b(dip2px, dip2px, dip2px, dip2px);
    }

    public void b(final int i3, final int i16, final int i17, final int i18) {
        post(new Runnable() { // from class: com.tencent.guild.widgets.GuildCheckBox.1
            @Override // java.lang.Runnable
            public void run() {
                Rect rect = new Rect();
                GuildCheckBox.this.getHitRect(rect);
                rect.top -= i3;
                rect.bottom += i16;
                rect.left -= i17;
                rect.right += i18;
                TouchDelegate touchDelegate = new TouchDelegate(rect, GuildCheckBox.this);
                if (GuildCheckBox.this.getParent() instanceof View) {
                    ((View) GuildCheckBox.this.getParent()).setTouchDelegate(touchDelegate);
                }
            }
        });
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean z16) {
        super.setEnabled(z16);
        f();
    }

    public void setSizeType(int i3) {
        this.f112673e = i3;
        c();
    }

    public void setType(int i3) {
        this.f112672d = i3;
        c();
    }

    public GuildCheckBox(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    public GuildCheckBox(Context context, AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        this.f112672d = 0;
        this.f112673e = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.f450841g3);
        this.f112672d = obtainStyledAttributes.getInteger(a.i3, 0);
        this.f112673e = obtainStyledAttributes.getInteger(a.f450848h3, 0);
        obtainStyledAttributes.recycle();
        c();
    }

    public GuildCheckBox(Context context) {
        super(context);
        this.f112672d = 0;
        this.f112673e = 0;
        c();
    }
}
