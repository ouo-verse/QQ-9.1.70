package com.tencent.mobileqq.search.view;

import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes18.dex */
public class n extends com.tencent.mobileqq.search.business.net.view.c {
    public TextView M;
    public LinearLayout N;

    public n(ViewGroup viewGroup, int i3) {
        super(viewGroup, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.search.business.net.view.c, sn2.g
    public void a() {
        this.M = (TextView) this.f433999d.findViewById(R.id.kbs);
        this.N = (LinearLayout) this.f433999d.findViewById(R.id.f164479z5);
    }
}
