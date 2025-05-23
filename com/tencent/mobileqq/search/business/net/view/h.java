package com.tencent.mobileqq.search.business.net.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.SquareImageView;

/* compiled from: P */
/* loaded from: classes18.dex */
public class h extends c {
    public ImageView M;
    public ImageView N;
    public TextView P;
    public LinearLayout Q;
    public SquareImageView R;
    public ImageView S;
    public FrameLayout T;
    public RelativeLayout U;
    public LinearLayout V;
    public TextView W;
    public URLImageView X;
    public TextView Y;
    public URLImageView Z;

    /* renamed from: a0, reason: collision with root package name */
    public TextView f283047a0;

    /* renamed from: b0, reason: collision with root package name */
    public int f283048b0;

    public h(ViewGroup viewGroup, int i3) {
        super(viewGroup, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.search.business.net.view.c, sn2.g
    public void a() {
        super.a();
        View j3 = j(this.E);
        this.N = (ImageView) j3.findViewById(R.id.bb6);
        this.M = (ImageView) j3.findViewById(R.id.icon);
        this.P = (TextView) j3.findViewById(R.id.jb7);
        this.Q = (LinearLayout) j3.findViewById(R.id.fsi);
        FrameLayout frameLayout = (FrameLayout) j3.findViewById(R.id.iwn);
        this.T = frameLayout;
        this.R = (SquareImageView) frameLayout.findViewById(R.id.de8);
        this.S = (ImageView) this.T.findViewById(R.id.f166006e23);
        this.f283048b0 = this.Q.getChildCount();
        this.V = (LinearLayout) j3.findViewById(R.id.bqw);
        this.U = (RelativeLayout) j3.findViewById(R.id.br8);
        this.W = (TextView) j3.findViewById(R.id.hw8);
        this.X = (URLImageView) j3.findViewById(R.id.l78);
        this.Y = (TextView) j3.findViewById(R.id.l7_);
        this.Z = (URLImageView) j3.findViewById(R.id.b48);
        this.f283047a0 = (TextView) j3.findViewById(R.id.f164860b51);
    }
}
