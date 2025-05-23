package com.tencent.mobileqq.profilecard.view.vas;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes35.dex */
public class SurroundContentView extends LinearLayout {
    private ImageView arrow;
    private ImageView arrow2;
    private View line1;
    private View line2;
    private View line3;
    private View line4;
    private View line5;
    private LinearLayout rootView;
    private TextView sloganTv;
    private TextView star1;
    private TextView star2;
    private TextView tagTv;

    public SurroundContentView(Context context, int i3) {
        super(context);
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.hhg, (ViewGroup) this, true);
        this.rootView = linearLayout;
        this.sloganTv = (TextView) linearLayout.findViewById(R.id.f909753x);
        this.tagTv = (TextView) this.rootView.findViewById(R.id.f909853y);
        this.star1 = (TextView) this.rootView.findViewById(R.id.f87854vh);
        this.star2 = (TextView) this.rootView.findViewById(R.id.f87864vi);
        this.line1 = this.rootView.findViewById(R.id.e_3);
        this.line2 = this.rootView.findViewById(R.id.e_4);
        this.line3 = this.rootView.findViewById(R.id.yie);
        this.line4 = this.rootView.findViewById(R.id.yif);
        this.line5 = this.rootView.findViewById(R.id.yig);
        this.arrow = (ImageView) this.rootView.findViewById(R.id.f909353t);
        this.arrow2 = (ImageView) this.rootView.findViewById(R.id.f909453u);
        setColor(i3);
    }

    public void setColor(int i3) {
        this.sloganTv.setTextColor(i3);
        this.tagTv.setTextColor(i3);
        this.star1.setTextColor(i3);
        this.star2.setTextColor(i3);
        this.line1.setBackgroundColor(i3);
        this.line2.setBackgroundColor(i3);
        this.line3.setBackgroundColor(i3);
        this.line4.setBackgroundColor(i3);
        this.line5.setBackgroundColor(i3);
        this.arrow.setColorFilter(i3);
        this.arrow2.setColorFilter(i3);
    }

    public void setSloganText(String str) {
        if (TextUtils.isEmpty(str)) {
            this.arrow2.setVisibility(0);
            this.sloganTv.setVisibility(8);
        } else {
            this.arrow2.setVisibility(8);
            this.sloganTv.setVisibility(0);
            this.sloganTv.setText(str);
        }
    }

    public void setTagText(String str) {
        if (TextUtils.isEmpty(str)) {
            this.line5.setVisibility(0);
            this.tagTv.setVisibility(8);
        } else {
            this.line5.setVisibility(8);
            this.tagTv.setVisibility(0);
            this.tagTv.setText(str);
        }
    }
}
