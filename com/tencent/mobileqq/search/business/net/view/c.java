package com.tencent.mobileqq.search.business.net.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.SquareImageView;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class c extends sn2.g {
    public RelativeLayout F;
    public SquareImageView G;
    public ImageView H;
    public TextView I;
    public TextView J;
    public SquareImageView K;
    public TextView L;

    /* JADX INFO: Access modifiers changed from: protected */
    public c() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // sn2.g
    public void a() {
        super.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o(View view) {
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.icv);
        this.F = relativeLayout;
        if (relativeLayout == null) {
            this.F = (RelativeLayout) view.findViewById(R.id.ddu);
        }
        this.G = (SquareImageView) view.findViewById(R.id.f165942dw2);
        this.H = (ImageView) view.findViewById(R.id.duw);
        this.I = (TextView) view.findViewById(R.id.kbj);
        this.J = (TextView) view.findViewById(R.id.ka_);
        this.K = (SquareImageView) view.findViewById(R.id.i_r);
        this.L = (TextView) view.findViewById(R.id.i_s);
        if (ThemeUtil.isNowThemeIsNight(MobileQQ.sMobileQQ.peekAppRuntime(), false, null)) {
            TextView textView = this.J;
            textView.setTextColor(textView.getContext().getResources().getColor(R.color.acg));
            TextView textView2 = this.L;
            textView2.setTextColor(textView2.getContext().getResources().getColor(R.color.acg));
            return;
        }
        TextView textView3 = this.J;
        textView3.setTextColor(textView3.getContext().getResources().getColor(R.color.f158017al3));
        TextView textView4 = this.L;
        textView4.setTextColor(textView4.getContext().getResources().getColor(R.color.f158017al3));
    }

    public c(ViewGroup viewGroup, int i3) {
        this.E = i3;
        viewGroup.getResources();
        LinearLayout linearLayout = new LinearLayout(viewGroup.getContext());
        linearLayout.setOrientation(1);
        linearLayout.addView(LayoutInflater.from(viewGroup.getContext()).inflate(i3, (ViewGroup) null, false), new LinearLayout.LayoutParams(-1, -2));
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        this.f433999d = linearLayout;
        a();
    }
}
