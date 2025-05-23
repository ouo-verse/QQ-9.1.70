package com.tencent.qqnt.indicators.magicindicator.buildins.commonnavigator.titles;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.qqnt.indicators.magicindicator.buildins.a;
import com.tencent.qqnt.indicators.magicindicator.buildins.commonnavigator.abs.b;

/* loaded from: classes24.dex */
public class SimplePagerTitleView extends TextView implements b {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    protected ColorStateList f357097d;

    /* renamed from: e, reason: collision with root package name */
    protected ColorStateList f357098e;

    public SimplePagerTitleView(Context context) {
        super(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            e(context);
        }
    }

    private void e(Context context) {
        setGravity(17);
        int a16 = a.a(context, 10.0d);
        setPadding(a16, 0, a16, 0);
        setSingleLine();
        setEllipsize(TextUtils.TruncateAt.END);
    }

    @Override // com.tencent.qqnt.indicators.magicindicator.buildins.commonnavigator.abs.b
    public int a() {
        String charSequence;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        Rect rect = new Rect();
        if (getText().toString().contains("\n")) {
            charSequence = "";
            for (String str : getText().toString().split(RedTouch.NEWLINE_CHAR)) {
                if (str.length() > charSequence.length()) {
                    charSequence = str;
                }
            }
        } else {
            charSequence = getText().toString();
        }
        getPaint().getTextBounds(charSequence, 0, charSequence.length(), rect);
        return getLeft() + (getWidth() / 2) + (rect.width() / 2);
    }

    @Override // com.tencent.qqnt.indicators.magicindicator.buildins.commonnavigator.abs.b
    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        Paint.FontMetrics fontMetrics = getPaint().getFontMetrics();
        return (int) ((getHeight() / 2) + ((fontMetrics.bottom - fontMetrics.top) / 2.0f));
    }

    @Override // com.tencent.qqnt.indicators.magicindicator.buildins.commonnavigator.abs.b
    public int c() {
        String charSequence;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        Rect rect = new Rect();
        if (getText().toString().contains("\n")) {
            charSequence = "";
            for (String str : getText().toString().split(RedTouch.NEWLINE_CHAR)) {
                if (str.length() > charSequence.length()) {
                    charSequence = str;
                }
            }
        } else {
            charSequence = getText().toString();
        }
        getPaint().getTextBounds(charSequence, 0, charSequence.length(), rect);
        return (getLeft() + (getWidth() / 2)) - (rect.width() / 2);
    }

    @Override // com.tencent.qqnt.indicators.magicindicator.buildins.commonnavigator.abs.b
    public int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        Paint.FontMetrics fontMetrics = getPaint().getFontMetrics();
        return (int) ((getHeight() / 2) - ((fontMetrics.bottom - fontMetrics.top) / 2.0f));
    }

    public void setNormalColor(ColorStateList colorStateList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) colorStateList);
        } else {
            this.f357098e = colorStateList;
        }
    }

    public void setSelectedColor(ColorStateList colorStateList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) colorStateList);
        } else {
            this.f357097d = colorStateList;
        }
    }
}
