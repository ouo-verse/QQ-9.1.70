package com.tencent.mobileqq.search.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.troop.widget.TroopActiveLayout;
import com.tencent.mobileqq.troop.widget.TroopLabelLayout;
import com.tencent.mobileqq.widget.FolderTextView;
import com.tencent.widget.ThemeImageView;
import com.tencent.widget.ThemeImageWrapper;

/* compiled from: P */
/* loaded from: classes18.dex */
public class q extends sn2.g {
    private int F;
    private TroopLabelLayout G;
    private TextView H;
    private ImageView I;
    public Button J;
    private TextView K;
    private TroopLabelLayout L;
    private TextView M;
    public ImageView N;
    public ImageView P;
    private View Q;
    private View R;
    private View S;
    private TroopActiveLayout T;
    private FolderTextView U;

    public q(ViewGroup viewGroup, int i3) {
        this.F = i3;
        if (i3 != 3) {
            if (i3 != 1107) {
                if (i3 != 268435456) {
                    if (i3 != 1001) {
                        if (i3 != 1002) {
                            this.E = R.layout.a0u;
                        }
                    } else {
                        this.E = R.layout.ayg;
                    }
                } else {
                    this.E = R.layout.fug;
                }
            }
            this.E = R.layout.ayh;
        } else {
            this.E = R.layout.acm;
        }
        viewGroup.getResources();
        LinearLayout linearLayout = new LinearLayout(viewGroup.getContext());
        linearLayout.setOrientation(1);
        linearLayout.addView(LayoutInflater.from(viewGroup.getContext()).inflate(this.E, (ViewGroup) null, false), new LinearLayout.LayoutParams(-1, -2));
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        this.f433999d = linearLayout;
        a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // sn2.g
    public void a() {
        super.a();
        this.H = (TextView) this.f433999d.findViewById(R.id.icon);
        this.I = (ImageView) this.f433999d.findViewById(R.id.bb6);
        int i3 = this.F;
        if (i3 != 1001) {
            if (i3 != 1002) {
                if (i3 == 1107) {
                    ImageView imageView = (ImageView) this.f433999d.findViewById(R.id.jxg);
                    this.N = imageView;
                    imageView.setVisibility(8);
                    LinearLayout linearLayout = (LinearLayout) this.f433999d.findViewById(R.id.title_container);
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
                    layoutParams.addRule(15, -1);
                    layoutParams.addRule(10, 0);
                    linearLayout.setLayoutParams(layoutParams);
                    View findViewById = this.f433999d.findViewById(R.id.b_b);
                    this.Q = findViewById;
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
                    layoutParams2.addRule(15, -1);
                    layoutParams2.addRule(10, 0);
                    this.Q.setLayoutParams(layoutParams2);
                }
            } else {
                this.N = (ImageView) this.f433999d.findViewById(R.id.jxg);
                this.P = (ImageView) this.f433999d.findViewById(R.id.jwi);
                this.G = (TroopLabelLayout) this.f433999d.findViewById(R.id.jzj);
                TextView textView = this.f434000e;
                if (textView != null) {
                    int dip2px = ScreenUtil.SCREEN_WIDTH - ScreenUtil.dip2px(187.0f);
                    if (dip2px <= 0) {
                        dip2px = ScreenUtil.dip2px(220.0f);
                    }
                    textView.setMaxWidth(dip2px);
                }
            }
        } else {
            this.J = (Button) this.f433999d.findViewById(R.id.i8s);
            this.K = (TextView) this.f433999d.findViewById(R.id.f166787i92);
            this.L = (TroopLabelLayout) this.f433999d.findViewById(R.id.jzj);
            this.M = (TextView) this.f433999d.findViewById(R.id.f166195ls0);
            this.S = this.f433999d.findViewById(R.id.kab);
        }
        View findViewById2 = this.f433999d.findViewById(R.id.b_b);
        this.Q = findViewById2;
        if (findViewById2 != null) {
            findViewById2.setTag("ActiveEntitySearchResultPresenter_add_troop");
        }
        View findViewById3 = this.f433999d.findViewById(R.id.fzj);
        this.R = findViewById3;
        if (findViewById3 != null) {
            findViewById3.setTag("ActiveEntitySearchResultPresenter_pay_troop");
            View view = this.R;
            if (view instanceof ThemeImageView) {
                ((ThemeImageView) view).setMaskShape(ThemeImageWrapper.MODE_OTHER);
            }
        }
        TroopActiveLayout troopActiveLayout = (TroopActiveLayout) this.f433999d.findViewById(R.id.f163957dn);
        this.T = troopActiveLayout;
        if (troopActiveLayout != null) {
            troopActiveLayout.setTag("ActiveEntitySearchResultPresenter_hot_troop");
        }
        FolderTextView folderTextView = (FolderTextView) this.f433999d.findViewById(R.id.lic);
        this.U = folderTextView;
        if (folderTextView != null) {
            folderTextView.setTag("ActiveEntitySearchResultPresenter_expand_desc");
        }
    }

    @Override // sn2.g, sn2.c
    public View h(String str) {
        if ("ActiveEntitySearchResultPresenter_add_troop".equals(str)) {
            return this.Q;
        }
        if ("ActiveEntitySearchResultPresenter_pay_troop".equals(str)) {
            return this.R;
        }
        if ("ActiveEntitySearchResultPresenter_hot_troop".equals(str)) {
            return this.T;
        }
        if ("ActiveEntitySearchResultPresenter_expand_desc".equals(str)) {
            return this.U;
        }
        return super.h(str);
    }

    public ImageView o() {
        return this.I;
    }

    public TextView p() {
        return this.H;
    }

    public TroopLabelLayout q() {
        return this.G;
    }

    public View r() {
        return this.S;
    }

    public TroopLabelLayout s() {
        return this.L;
    }

    public TextView t() {
        return this.K;
    }

    public TextView u() {
        return this.J;
    }

    public TextView v() {
        return this.M;
    }
}
