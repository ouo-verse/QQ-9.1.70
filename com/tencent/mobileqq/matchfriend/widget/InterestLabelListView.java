package com.tencent.mobileqq.matchfriend.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.relation.common.widget.InterestLabelMoreFlowLayout;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes33.dex */
public class InterestLabelListView extends InterestLabelMoreFlowLayout implements View.OnClickListener {
    public Boolean K;
    protected Context L;
    protected ArrayList<TextView> M;
    protected ArrayList<String> N;
    private RelativeLayout P;
    protected int Q;
    private long R;
    private long S;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                if (InterestLabelListView.this.P != null) {
                    InterestLabelListView.this.P.setAlpha(0.5f);
                }
                return false;
            }
            if (action == 1 || action == 3) {
                InterestLabelListView.this.P.setAlpha(1.0f);
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public interface b {
    }

    public InterestLabelListView(Context context) {
        super(context);
        this.K = Boolean.TRUE;
        this.M = new ArrayList<>();
        this.N = new ArrayList<>();
        this.Q = 0;
        this.R = 0L;
        this.S = 3000L;
        this.L = context;
        n();
    }

    private boolean m() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.R >= this.S) {
            this.R = currentTimeMillis;
            return false;
        }
        this.S = 1000L;
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        m();
    }

    public void setLabelList(ArrayList<String> arrayList) {
        this.N = arrayList;
    }

    public void setMaxLabelNumberAndView(int i3) {
        this.Q = i3;
        this.M.clear();
        int dpToPx = ViewUtils.dpToPx(18.0f);
        for (int i16 = 0; i16 < this.Q; i16++) {
            TextView textView = new TextView(this.L);
            textView.setTextSize(1, 16.0f);
            textView.setGravity(17);
            textView.setHeight(ViewUtils.dpToPx(36.0f));
            textView.setPadding(dpToPx, 0, dpToPx, 0);
            textView.setTextColor(getResources().getColor(R.color.qui_common_text_primary));
            textView.setBackgroundDrawable(getResources().getDrawable(R.drawable.fm6));
            textView.setOnClickListener(this);
            textView.setVisibility(0);
            this.M.add(textView);
        }
    }

    private void n() {
        setHorizontalSpacing(ViewUtils.dpToPx(10.0f));
        setVerticalSpacing(ViewUtils.dpToPx(10.0f));
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -2);
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.L).inflate(R.layout.cwh, (ViewGroup) null);
        this.P = relativeLayout;
        relativeLayout.setLayoutParams(layoutParams);
        this.P.setOnClickListener(this);
        this.P.setOnTouchListener(new a());
        if (this.K.booleanValue()) {
            addView(this.P);
        }
    }

    public InterestLabelListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.K = Boolean.TRUE;
        this.M = new ArrayList<>();
        this.N = new ArrayList<>();
        this.Q = 0;
        this.R = 0L;
        this.S = 3000L;
        this.L = context;
        n();
    }

    public InterestLabelListView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.K = Boolean.TRUE;
        this.M = new ArrayList<>();
        this.N = new ArrayList<>();
        this.Q = 0;
        this.R = 0L;
        this.S = 3000L;
        this.L = context;
        n();
    }

    public void setClickListener(b bVar) {
    }
}
