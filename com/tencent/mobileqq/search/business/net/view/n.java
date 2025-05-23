package com.tencent.mobileqq.search.business.net.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes18.dex */
public class n extends c {
    public URLImageView M;
    public TextView N;
    public TextView P;
    public ImageView Q;
    public TextView R;

    public n(ViewGroup viewGroup, int i3) {
        super(viewGroup, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.search.business.net.view.c, sn2.g
    public void a() {
        View j3 = j(this.E);
        this.M = (URLImageView) j3.findViewById(R.id.joy);
        this.N = (TextView) j3.findViewById(R.id.cbf);
        this.P = (TextView) j3.findViewById(R.id.f0q);
        this.Q = (ImageView) j3.findViewById(R.id.f06);
        this.R = (TextView) j3.findViewById(R.id.il9);
    }
}
