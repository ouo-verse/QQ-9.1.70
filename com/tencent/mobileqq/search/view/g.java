package com.tencent.mobileqq.search.view;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.search.model.ac;
import com.tencent.mobileqq.search.util.aq;
import com.tencent.widget.HorizontalListView;

/* compiled from: P */
/* loaded from: classes18.dex */
public class g extends com.tencent.mobileqq.search.business.net.view.c implements HorizontalListView.OnScrollStateChangedListener {
    public HorizontalListView M;
    public ac N;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            motionEvent.getAction();
            return true;
        }
    }

    public g(ViewGroup viewGroup, int i3) {
        super(viewGroup, i3);
        LinearLayout linearLayout = (LinearLayout) j(i3);
        HorizontalListView horizontalListView = (HorizontalListView) linearLayout.findViewById(R.id.ikf);
        this.M = horizontalListView;
        horizontalListView.setOnScrollStateChangedListener(this);
        this.M.setOnTouchListener(new a());
        if (aq.a()) {
            linearLayout.setBackgroundResource(R.drawable.qui_common_fill_light_primary_bg_selector);
        }
    }

    @Override // com.tencent.widget.HorizontalListView.OnScrollStateChangedListener
    public void onScrollStateChanged(int i3) {
        if (i3 == 4097) {
            this.N.f283476j0 = this.M.getCurrentX();
        }
    }
}
