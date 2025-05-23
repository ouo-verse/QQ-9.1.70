package com.tencent.mobileqq.search.business.net.view;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.utils.ViewUtils;

/* compiled from: P */
/* loaded from: classes18.dex */
public class f extends c {
    protected View M;
    protected LinearLayout N;
    protected FrameLayout P;
    protected LinearLayout Q;
    protected LinearLayout R;
    protected RecyclerView S;
    protected RecyclerView T;
    protected ko2.a U;
    protected ko2.b V;
    protected View W;

    public f(ViewGroup viewGroup, int i3) {
        super(viewGroup, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.search.business.net.view.c, sn2.g
    public void a() {
        super.a();
        View j3 = j(this.E);
        this.M = j3;
        if (j3 != null) {
            this.N = (LinearLayout) j3.findViewById(R.id.ecl);
            this.Q = (LinearLayout) this.M.findViewById(R.id.title_container);
            this.P = (FrameLayout) this.M.findViewById(R.id.ddm);
            this.S = (RecyclerView) this.M.findViewById(R.id.f164060sf4);
            this.T = (RecyclerView) this.M.findViewById(R.id.f902051u);
            this.W = this.M.findViewById(R.id.bmt);
            this.R = (LinearLayout) this.M.findViewById(R.id.f901951t);
        }
    }

    public void p(lo2.p pVar) {
        if (pVar == null) {
            return;
        }
        LinearLayout linearLayout = this.N;
        if (linearLayout != null && linearLayout.getParent() != null) {
            ((View) this.N.getParent()).setPadding(0, 0, 0, 0);
        }
        if (b() != null) {
            CharSequence u16 = pVar.u();
            String s16 = pVar.s();
            if (!TextUtils.isEmpty(u16) && !TextUtils.isEmpty(s16)) {
                u16 = SearchUtils.G(u16.toString(), s16, true);
            }
            b().setText(u16);
        }
        if (c() != null) {
            c().setText(pVar.t());
        }
        if ((f() instanceof RoundCornerImageView) && !TextUtils.isEmpty(pVar.X())) {
            f().setImageDrawable(URLDrawable.getDrawable(pVar.X(), (URLDrawable.URLDrawableOptions) null));
            ((RoundCornerImageView) f()).setCorner(ViewUtils.dpToPx(q(pVar.a0())));
        }
        if (pVar.a0()) {
            u(pVar);
        }
    }

    protected int q(boolean z16) {
        throw null;
    }

    protected int r() {
        throw null;
    }

    protected int s() {
        throw null;
    }

    protected int t() {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void u(lo2.p pVar) {
        if (this.P != null && r() != 0) {
            this.P.setLayoutParams(new LinearLayout.LayoutParams(ViewUtils.dpToPx(r()), ViewUtils.dpToPx(r())));
        }
        if (c() != null) {
            c().setSingleLine(false);
            c().setMaxLines(2);
        }
        View view = this.W;
        if (view != null) {
            view.setVisibility(0);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.W.getLayoutParams();
            layoutParams.leftMargin = ViewUtils.dpToPx(s());
            layoutParams.topMargin = ViewUtils.dpToPx(t());
            this.W.setLayoutParams(layoutParams);
        }
    }
}
