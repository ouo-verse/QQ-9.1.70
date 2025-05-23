package com.tencent.mobileqq.search.view;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.search.util.aq;

/* compiled from: P */
/* loaded from: classes18.dex */
public class j extends com.tencent.mobileqq.search.business.net.view.i {
    public RelativeLayout M;
    public ImageView N;
    public TextView P;
    public FrameLayout Q;
    public TextView R;

    public j(ViewGroup viewGroup, int i3) {
        super(viewGroup, R.layout.fum);
        q(i3);
        if (aq.a()) {
            this.f433999d.setBackgroundResource(R.drawable.qui_common_fill_light_primary_bg_selector);
        }
    }

    private void p(int i3) {
        ViewGroup.LayoutParams layoutParams = this.M.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = i3;
            layoutParams.height = i3;
        }
    }

    private void q(int i3) {
        this.M = (RelativeLayout) this.f433999d.findViewById(R.id.f27800h8);
        this.N = (ImageView) this.f433999d.findViewById(R.id.f27810h9);
        this.P = (TextView) this.f433999d.findViewById(R.id.f27840hb);
        this.Q = (FrameLayout) this.f433999d.findViewById(R.id.f27820h_);
        this.R = (TextView) this.f433999d.findViewById(R.id.f5e);
        p(i3);
    }
}
