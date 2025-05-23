package com.tencent.mobileqq.search.business.net.view;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.SquareImageView;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class p extends c {
    public ImageView M;
    public ImageView N;
    public TextView P;
    public LinearLayout Q;
    public SquareImageView R;
    public ImageView S;
    public FrameLayout T;
    public int U;

    public p(ViewGroup viewGroup, int i3) {
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
        this.U = this.Q.getChildCount();
        TextView b16 = b();
        TextView c16 = c();
        TextView k3 = k();
        if (ThemeUtil.isNowThemeIsNight(MobileQQ.sMobileQQ.peekAppRuntime(), false, null)) {
            if (b16 != null) {
                b16.setTextColor(b16.getContext().getResources().getColor(R.color.acg));
            }
            if (c16 != null) {
                c16.setTextColor(c16.getContext().getResources().getColor(R.color.acf));
            }
            if (k3 != null) {
                k3.setTextColor(k3.getContext().getResources().getColor(R.color.acf));
                return;
            }
            return;
        }
        if (b16 != null) {
            b16.setTextColor(Color.parseColor("#262626"));
        }
        if (c16 != null) {
            c16.setTextColor(Color.parseColor("#737373"));
        }
        if (k3 != null) {
            k3.setTextColor(Color.parseColor("#737373"));
        }
    }
}
