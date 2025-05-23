package com.tencent.mobileqq.matchfriend.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;

/* compiled from: P */
/* loaded from: classes33.dex */
public class InterestLabelListViewNew extends InterestLabelListView {
    private Drawable T;
    private Drawable U;
    private RelativeLayout V;

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
                if (InterestLabelListViewNew.this.V != null) {
                    InterestLabelListViewNew.this.V.setAlpha(0.5f);
                }
                return false;
            }
            if (action == 1 || action == 3) {
                InterestLabelListViewNew.this.V.setAlpha(1.0f);
            }
            return false;
        }
    }

    public InterestLabelListViewNew(Context context) {
        super(context);
        this.T = null;
        this.U = null;
        n();
    }

    @Override // com.tencent.mobileqq.matchfriend.widget.InterestLabelListView
    public void setMaxLabelNumberAndView(int i3) {
        this.Q = i3;
        this.M.clear();
        for (int i16 = 0; i16 < this.Q; i16++) {
            TextView textView = new TextView(this.L);
            textView.setTextSize(1, 12.0f);
            textView.setGravity(17);
            textView.setHeight(ViewUtils.dpToPx(27.0f));
            textView.setPadding(ViewUtils.dpToPx(8.0f), ViewUtils.dpToPx(4.0f), ViewUtils.dpToPx(8.0f), ViewUtils.dpToPx(4.0f));
            textView.setTextColor(getResources().getColorStateList(R.color.qui_common_text_primary));
            textView.setBackgroundDrawable(getResources().getDrawable(R.drawable.fno));
            textView.setOnClickListener(this);
            textView.setVisibility(0);
            this.M.add(textView);
        }
    }

    private void n() {
        setHorizontalSpacing(ViewUtils.dpToPx(10.0f));
        setVerticalSpacing(ViewUtils.dpToPx(10.0f));
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, ViewUtils.dpToPx(27.0f));
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.L).inflate(R.layout.cwi, (ViewGroup) null);
        this.V = relativeLayout;
        relativeLayout.setPadding(ViewUtils.dpToPx(8.0f), ViewUtils.dpToPx(4.0f), ViewUtils.dpToPx(8.0f), ViewUtils.dpToPx(4.0f));
        this.V.setLayoutParams(layoutParams);
        this.V.setOnClickListener(this);
        this.V.setOnTouchListener(new a());
        if (this.K.booleanValue()) {
            addView(this.V);
        }
    }

    public InterestLabelListViewNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.T = null;
        this.U = null;
        n();
    }

    public InterestLabelListViewNew(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.T = null;
        this.U = null;
        n();
    }
}
