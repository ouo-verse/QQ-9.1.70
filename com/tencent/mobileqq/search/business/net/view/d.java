package com.tencent.mobileqq.search.business.net.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes18.dex */
public class d extends c {
    public RelativeLayout M;
    public URLImageView N;
    public TextView P;
    public TextView Q;
    public TextView R;
    public TextView S;

    public d(ViewGroup viewGroup, int i3) {
        super(viewGroup, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.search.business.net.view.c, sn2.g
    public void a() {
        super.a();
        View j3 = j(this.E);
        this.M = (RelativeLayout) j3.findViewById(R.id.e2a);
        this.N = (URLImageView) j3.findViewById(R.id.a8i);
        this.P = (TextView) j3.findViewById(R.id.icon);
        this.Q = (TextView) j3.findViewById(R.id.cb6);
        this.R = (TextView) j3.findViewById(R.id.f166838il1);
        this.S = (TextView) j3.findViewById(R.id.f163959dq);
    }
}
