package com.tencent.mobileqq.search.business.net.view;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class b extends c {
    public TextView M;
    public TextView N;
    public TextView P;
    public TextView Q;
    public RelativeLayout R;
    public ImageView S;
    public ImageView T;

    public b(ViewGroup viewGroup, int i3) {
        super(viewGroup, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.search.business.net.view.c, sn2.g
    public void a() {
        super.a();
        View j3 = j(this.E);
        this.M = (TextView) j3.findViewById(R.id.title);
        this.R = (RelativeLayout) j3.findViewById(R.id.e7m);
        this.S = (ImageView) j3.findViewById(R.id.dce);
        this.T = (ImageView) j3.findViewById(R.id.bb6);
        this.N = (TextView) j3.findViewById(R.id.jb7);
        this.P = (TextView) j3.findViewById(R.id.j8b);
        this.Q = (TextView) j3.findViewById(R.id.bgt);
        if (ThemeUtil.isNowThemeIsNight(MobileQQ.sMobileQQ.peekAppRuntime(), false, null)) {
            TextView textView = this.P;
            if (textView != null) {
                textView.setTextColor(textView.getContext().getResources().getColor(R.color.acf));
            }
            TextView textView2 = this.Q;
            if (textView2 != null) {
                textView2.setTextColor(textView2.getContext().getResources().getColor(R.color.acf));
                return;
            }
            return;
        }
        TextView textView3 = this.P;
        if (textView3 != null) {
            textView3.setTextColor(Color.parseColor("#737373"));
        }
        TextView textView4 = this.Q;
        if (textView4 != null) {
            textView4.setTextColor(Color.parseColor("#737373"));
        }
    }
}
