package com.tencent.mobileqq.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;

/* loaded from: classes20.dex */
public class KPLScoreView extends LinearLayout {
    TextView C;
    TextView D;
    TextView E;

    /* renamed from: d, reason: collision with root package name */
    private Context f315766d;

    /* renamed from: e, reason: collision with root package name */
    LinearLayout f315767e;

    /* renamed from: f, reason: collision with root package name */
    LinearLayout f315768f;

    /* renamed from: h, reason: collision with root package name */
    LinearLayout f315769h;

    /* renamed from: i, reason: collision with root package name */
    LinearLayout f315770i;

    /* renamed from: m, reason: collision with root package name */
    TextView f315771m;

    public KPLScoreView(Context context) {
        this(context, null);
    }

    private void a() {
        LayoutInflater.from(this.f315766d).inflate(R.layout.avn, (ViewGroup) this, true);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.f4_);
        this.f315767e = linearLayout;
        this.f315771m = (TextView) linearLayout.findViewById(R.id.k8z);
        LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.j8d);
        this.f315768f = linearLayout2;
        this.C = (TextView) linearLayout2.findViewById(R.id.f167053k92);
        LinearLayout linearLayout3 = (LinearLayout) findViewById(R.id.hvk);
        this.f315769h = linearLayout3;
        this.D = (TextView) linearLayout3.findViewById(R.id.f167051k90);
        LinearLayout linearLayout4 = (LinearLayout) findViewById(R.id.ifd);
        this.f315770i = linearLayout4;
        this.E = (TextView) linearLayout4.findViewById(R.id.f167052k91);
    }

    public void setKplValue(String str, String str2, String str3, String str4) {
        int i3;
        int i16;
        int i17;
        int i18;
        if (str.length() > 0) {
            i3 = str.length() - 1;
        } else {
            i3 = 0;
        }
        if (str2.length() > 0) {
            i16 = str2.length() - 1;
        } else {
            i16 = 0;
        }
        if (str3.length() > 0) {
            i17 = str3.length() - 1;
        } else {
            i17 = 0;
        }
        if (str4.length() > 0) {
            i18 = str4.length() - 1;
        } else {
            i18 = 0;
        }
        SpannableString spannableString = new SpannableString(str);
        SpannableString spannableString2 = new SpannableString(str2);
        SpannableString spannableString3 = new SpannableString(str3);
        SpannableString spannableString4 = new SpannableString(str4);
        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(27, true);
        AbsoluteSizeSpan absoluteSizeSpan2 = new AbsoluteSizeSpan(14, true);
        StyleSpan styleSpan = new StyleSpan(1);
        spannableString.setSpan(absoluteSizeSpan, 0, i3, 17);
        spannableString.setSpan(absoluteSizeSpan2, i3, i3 + 1, 17);
        spannableString.setSpan(styleSpan, 0, i3, 17);
        spannableString2.setSpan(absoluteSizeSpan, 0, i16, 17);
        spannableString2.setSpan(absoluteSizeSpan2, i16, i16 + 1, 17);
        spannableString2.setSpan(styleSpan, 0, i16, 17);
        spannableString3.setSpan(absoluteSizeSpan, 0, i17, 17);
        spannableString3.setSpan(absoluteSizeSpan2, i17, i17 + 1, 17);
        spannableString3.setSpan(styleSpan, 0, i17, 17);
        spannableString4.setSpan(absoluteSizeSpan, 0, i18, 17);
        spannableString4.setSpan(absoluteSizeSpan2, i18, i18 + 1, 17);
        spannableString4.setSpan(styleSpan, 0, i18, 17);
        this.f315771m.setText(spannableString);
        this.C.setText(spannableString2);
        this.D.setText(spannableString3);
        this.E.setText(spannableString4);
        this.f315771m.measure(0, 0);
        this.C.measure(0, 0);
        this.D.measure(0, 0);
        this.E.measure(0, 0);
        int measuredWidth = this.f315771m.getMeasuredWidth();
        int measuredWidth2 = this.C.getMeasuredWidth();
        int width = ((((WindowManager) this.f315766d.getSystemService("window")).getDefaultDisplay().getWidth() - (((measuredWidth + measuredWidth2) + this.D.getMeasuredWidth()) + this.E.getMeasuredWidth())) - BaseAIOUtils.f(24.0f, this.f315766d.getResources())) / 3;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(width, 0, 0, 0);
        this.f315768f.setLayoutParams(layoutParams);
        this.f315769h.setLayoutParams(layoutParams);
        this.f315770i.setLayoutParams(layoutParams);
    }

    public KPLScoreView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f315766d = context;
        a();
    }
}
