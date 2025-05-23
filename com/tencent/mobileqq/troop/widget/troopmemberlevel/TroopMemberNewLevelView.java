package com.tencent.mobileqq.troop.widget.troopmemberlevel;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.troopmemberlist.ITroopMemberListActivityApi;
import com.tencent.mobileqq.troop.troopmemberlevel.a;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopMemberNewLevelView extends RelativeLayout {
    static IPatchRedirector $redirector_;
    private int[] C;
    private int D;
    private int E;
    private String F;

    /* renamed from: d, reason: collision with root package name */
    private boolean f302662d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f302663e;

    /* renamed from: f, reason: collision with root package name */
    private int f302664f;

    /* renamed from: h, reason: collision with root package name */
    private String f302665h;

    /* renamed from: i, reason: collision with root package name */
    private float f302666i;

    /* renamed from: m, reason: collision with root package name */
    private int[] f302667m;

    public TroopMemberNewLevelView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f302662d = false;
        this.f302663e = false;
        this.f302664f = 0;
        this.f302665h = "";
        this.f302666i = 0.0f;
        this.f302667m = null;
        this.C = null;
        this.D = 0;
        this.E = 0;
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            this.F = "";
        }
    }

    public float b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Float) iPatchRedirector.redirect((short) 6, (Object) this)).floatValue();
        }
        char[] charArray = String.valueOf(this.f302664f).toCharArray();
        if (this.f302663e && this.f302662d && (charArray == null || charArray.length == 0)) {
            return 0.0f;
        }
        return ViewUtils.dip2px(0.0f + ViewUtils.pxToDp(this.f302666i) + 4.0f + 4.0f + 1.0f);
    }

    public boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return this.f302662d;
    }

    public boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return this.f302663e;
    }

    public void setTroopMemberNewLevel(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar);
        } else {
            if (aVar == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("TroopMemberNewLevelView", 2, "setTroopMemberNewLevel item is null");
                    return;
                }
                return;
            }
            setTroopMemberNewLevel(aVar.f300595f, aVar.f300596g, aVar.f300591b, aVar.f300592c, aVar.f300594e, aVar.f300593d, aVar.f300598i, aVar.f300597h, aVar.f300599j);
        }
    }

    public void setTroopMemberNewLevel(boolean z16, boolean z17, int i3, String str, int[] iArr, int[] iArr2, int i16, int i17, String str2) {
        Typeface create;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(i3), str, iArr, iArr2, Integer.valueOf(i16), Integer.valueOf(i17), str2);
            return;
        }
        if (z16 && !z17 && (i3 < 1 || iArr == null || iArr.length < 2)) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopMemberNewLevelView", 2, "setTroopMemberNewLevel error isShowLevel : " + z16 + ", isShowRank:" + z17 + ",newLevel:" + i3);
            }
            setContentDescription("");
            return;
        }
        if (z17 && (TextUtils.isEmpty(str) || iArr2 == null || iArr2.length < 2)) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopMemberNewLevelView", 2, "setTroopMemberNewLevel error isShowRank:" + z17 + ",rankTitle:" + str);
            }
            setContentDescription("");
            return;
        }
        if (this.f302662d == z16 && this.f302663e == z17 && this.f302664f == i3 && this.f302665h.equals(str) && Arrays.equals(iArr, this.f302667m) && Arrays.equals(iArr2, this.C) && this.D == i16 && this.E == i17 && TextUtils.equals(this.F, str2)) {
            setVisibility(0);
            return;
        }
        removeAllViews();
        setVisibility(8);
        this.f302664f = i3;
        this.f302665h = str;
        this.f302662d = z16;
        this.f302663e = z17;
        this.f302667m = iArr;
        this.C = iArr2;
        this.D = i16;
        this.E = i17;
        this.F = str2;
        if (z16 || z17) {
            StringBuffer stringBuffer = new StringBuffer();
            StringBuilder sb5 = new StringBuilder();
            if (z16 && z17) {
                GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TL_BR, iArr2);
                gradientDrawable.setCornerRadius(ViewUtils.dpToPx(4.0f));
                setBackgroundDrawable(gradientDrawable);
                setGravity(16);
                stringBuffer.append(HardCodeUtil.qqStr(R.string.f2061257g));
                stringBuffer.append(i3);
                sb5.append("LV");
                sb5.append(i3);
                sb5.append(" ");
                sb5.append(str);
                setVisibility(0);
            } else if (z16) {
                GradientDrawable gradientDrawable2 = new GradientDrawable(GradientDrawable.Orientation.TL_BR, iArr);
                gradientDrawable2.setCornerRadius(ViewUtils.dpToPx(4.0f));
                setBackgroundDrawable(gradientDrawable2);
                setGravity(16);
                sb5.append("LV");
                sb5.append(i3);
                setVisibility(0);
            } else if (z17) {
                GradientDrawable gradientDrawable3 = new GradientDrawable(GradientDrawable.Orientation.TL_BR, iArr2);
                gradientDrawable3.setCornerRadius(ViewUtils.dpToPx(4.0f));
                setBackgroundDrawable(gradientDrawable3);
                stringBuffer.append(str);
                sb5.append(str);
                setVisibility(0);
            }
            TextView textView = new TextView(getContext());
            textView.setText(sb5);
            stringBuffer.append(str);
            textView.setGravity(48);
            textView.setTextSize(2, 10.0f);
            if (Build.VERSION.SDK_INT >= 28) {
                try {
                    create = Typeface.create(null, 600, false);
                    textView.setTypeface(create);
                } catch (Exception e16) {
                    QLog.e("TroopMemberNewLevelView", 1, "FontError: " + e16);
                }
            }
            textView.setIncludeFontPadding(false);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setSingleLine();
            textView.setTextColor(i17);
            textView.setGravity(17);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, ViewUtils.dip2px(16.0f));
            layoutParams.leftMargin = ViewUtils.dip2px(4.0f);
            layoutParams.rightMargin = ViewUtils.dip2px(4.0f);
            layoutParams.addRule(13);
            addView(textView, layoutParams);
            this.f302666i = textView.getPaint().measureText(sb5.toString());
            setContentDescription(stringBuffer.toString());
            ((ITroopMemberListActivityApi) QRoute.api(ITroopMemberListActivityApi.class)).clothEffectView(getContext(), this, (int) b(), str2);
        }
    }

    public TroopMemberNewLevelView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f302662d = false;
        this.f302663e = false;
        this.f302664f = 0;
        this.f302665h = "";
        this.f302666i = 0.0f;
        this.f302667m = null;
        this.C = null;
        this.D = 0;
        this.E = 0;
    }

    public TroopMemberNewLevelView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f302662d = false;
        this.f302663e = false;
        this.f302664f = 0;
        this.f302665h = "";
        this.f302666i = 0.0f;
        this.f302667m = null;
        this.C = null;
        this.D = 0;
        this.E = 0;
    }
}
