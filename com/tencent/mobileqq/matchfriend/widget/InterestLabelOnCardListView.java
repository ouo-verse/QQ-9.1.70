package com.tencent.mobileqq.matchfriend.widget;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.relation.common.utils.f;
import com.tencent.relation.common.widget.InterestLabelMoreFlowLayout;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes33.dex */
public class InterestLabelOnCardListView extends InterestLabelMoreFlowLayout implements View.OnClickListener {
    private QBaseActivity K;
    private Context L;
    private ArrayList<TextView> M;
    private ArrayList<String> N;
    private RelativeLayout P;
    private long Q;
    private long R;

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public interface a {
    }

    public InterestLabelOnCardListView(Context context) {
        super(context);
        this.M = new ArrayList<>();
        this.N = new ArrayList<>();
        this.Q = 0L;
        this.R = 3000L;
        this.L = context;
        m();
    }

    private boolean l() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.Q >= this.R) {
            this.Q = currentTimeMillis;
            return false;
        }
        this.R = 1000L;
        return true;
    }

    @Override // com.tencent.relation.common.widget.InterestLabelMoreFlowLayout
    public void e() {
        super.e();
        if (this.F) {
            throw null;
        }
        throw null;
    }

    public void n() {
        String str;
        removeAllViews();
        this.M.clear();
        addView(this.P);
        int dpToPx = ViewUtils.dpToPx(9.0f);
        for (int i3 = 0; i3 < this.N.size(); i3++) {
            TextView textView = new TextView(this.L);
            textView.setText(this.N.get(i3));
            textView.setTextSize(1, 12.0f);
            textView.setHeight(ViewUtils.dpToPx(23.0f));
            textView.setGravity(17);
            textView.setPadding(dpToPx, 0, dpToPx, 0);
            if (f.a()) {
                str = "#96D4FF";
            } else {
                str = "#3385FF";
            }
            textView.setTextColor(Color.parseColor(str));
            textView.setBackgroundDrawable(getResources().getDrawable(f.a() ? R.drawable.fry : R.drawable.fqj));
            textView.setVisibility(0);
            this.M.add(textView);
            addView(textView);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        l();
    }

    public void setActivity(QBaseActivity qBaseActivity) {
        this.K = qBaseActivity;
    }

    public void setAgeAndConstellation(String str, int i3) {
        String str2;
        int parseColor;
        if (TextUtils.isEmpty(str) && i3 != 0 && i3 != 1) {
            this.P.setVisibility(8);
            return;
        }
        if (i3 != 0 && i3 != 1) {
            this.P.findViewById(R.id.oju).setVisibility(8);
        } else {
            this.P.findViewById(R.id.oju).setBackgroundDrawable(getResources().getDrawable(i3 == 0 ? R.drawable.fom : R.drawable.fol));
            this.P.setBackgroundDrawable(getResources().getDrawable(f.a() ? R.drawable.fry : i3 == 0 ? R.drawable.fqj : R.drawable.frp));
            TextView textView = (TextView) this.P.findViewById(R.id.oje);
            if (f.a()) {
                parseColor = Color.parseColor("#96D4FF");
            } else {
                if (i3 == 0) {
                    str2 = "#FF3385FF";
                } else {
                    str2 = "#FFFF93C9";
                }
                parseColor = Color.parseColor(str2);
            }
            textView.setTextColor(parseColor);
        }
        if (!TextUtils.isEmpty(str)) {
            ((TextView) this.P.findViewById(R.id.oje)).setText(str);
        } else {
            this.P.findViewById(R.id.oje).setVisibility(8);
        }
    }

    public void setLabelList(ArrayList<String> arrayList) {
        this.N = arrayList;
    }

    public void setMoreLabelView() {
        this.E = !this.E;
        n();
    }

    private void m() {
        this.E = false;
        setHorizontalSpacing(ViewUtils.dpToPx(5.0f));
        setVerticalSpacing(ViewUtils.dpToPx(5.0f));
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -2);
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.L).inflate(R.layout.cwk, (ViewGroup) null);
        this.P = relativeLayout;
        relativeLayout.setLayoutParams(layoutParams);
        addView(this.P);
    }

    public InterestLabelOnCardListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.M = new ArrayList<>();
        this.N = new ArrayList<>();
        this.Q = 0L;
        this.R = 3000L;
        this.L = context;
        m();
    }

    public InterestLabelOnCardListView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.M = new ArrayList<>();
        this.N = new ArrayList<>();
        this.Q = 0L;
        this.R = 3000L;
        this.L = context;
        m();
    }

    public void setRefreshListener(a aVar) {
    }
}
