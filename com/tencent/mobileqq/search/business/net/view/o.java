package com.tencent.mobileqq.search.business.net.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.search.util.aq;
import com.tencent.mobileqq.widget.SquareImageView;

/* compiled from: P */
/* loaded from: classes18.dex */
public class o extends c {
    public RelativeLayout M;
    public Button N;
    public ImageView P;
    public LinearLayout Q;
    public LinearLayout R;
    public TextView S;
    public TextView T;
    public SquareImageView U;
    public LinearLayout V;
    public Button W;

    public o(ViewGroup viewGroup, int i3) {
        super(viewGroup, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.search.business.net.view.c, sn2.g
    public void a() {
        super.a();
        View j3 = j(this.E);
        o(j3);
        this.M = (RelativeLayout) j3.findViewById(R.id.idf);
        this.N = (Button) j3.findViewById(R.id.ajm);
        this.P = (ImageView) j3.findViewById(R.id.dxv);
        this.Q = (LinearLayout) j3.findViewById(R.id.ecz);
        this.R = (LinearLayout) j3.findViewById(R.id.f166089ed0);
        this.S = (TextView) j3.findViewById(R.id.k65);
        this.T = (TextView) j3.findViewById(R.id.f167037k64);
        this.U = (SquareImageView) j3.findViewById(R.id.duc);
        this.V = (LinearLayout) j3.findViewById(R.id.ecy);
        this.W = (Button) j3.findViewById(R.id.aft);
        View findViewById = this.f433999d.findViewById(R.id.f166798ic2);
        if (aq.a()) {
            findViewById.setBackgroundResource(R.drawable.qui_common_fill_light_primary_bg_selector);
            n(b(), R.color.qui_common_text_primary);
            n(k(), R.color.qui_common_text_secondary);
        }
    }
}
