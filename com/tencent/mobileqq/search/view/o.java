package com.tencent.mobileqq.search.view;

import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes18.dex */
public class o extends com.tencent.mobileqq.search.business.net.view.c {
    public TextView M;
    public TextView N;
    public RelativeLayout P;
    public LinearLayout Q;

    public o(ViewGroup viewGroup, int i3) {
        super(viewGroup, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.search.business.net.view.c, sn2.g
    public void a() {
        this.Q = (LinearLayout) this.f433999d.findViewById(R.id.ikf);
        this.M = (TextView) this.f433999d.findViewById(R.id.e85);
        this.N = (TextView) this.f433999d.findViewById(R.id.ian);
        this.P = (RelativeLayout) this.f433999d.findViewById(R.id.dpq);
    }
}
