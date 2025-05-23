package com.tencent.biz.pubaccount.weishi.profile;

import UserGrowth.stSimpleMetaFeed;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi.util.ak;
import com.tencent.biz.pubaccount.weishi.util.ba;
import com.tencent.biz.pubaccount.weishi.verticalvideo.data.j;
import com.tencent.biz.pubaccount.weishi.view.RoundCornerImageView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes32.dex */
public class f extends z10.b<j> {
    public static final int K = ba.f81748w;
    private RoundCornerImageView F;
    private TextView G;
    private View H;
    private e I;
    private stSimpleMetaFeed J;

    private int p() {
        return ((ba.o() - (ba.f81735j * 2)) - (ba.f81729d * 2)) / 3;
    }

    private Pair<Integer, Integer> q() {
        return new Pair<>(-1, Integer.valueOf((int) (p() * 1.3333334f)));
    }

    private void r() {
        this.F = (RoundCornerImageView) this.itemView.findViewById(R.id.p5v);
        this.G = (TextView) this.itemView.findViewById(R.id.p8a);
    }

    private void s() {
        int adapterPosition = getAdapterPosition();
        if (adapterPosition == 0) {
            this.F.setCorner(ba.f81748w, 2);
        } else if (adapterPosition != 2) {
            this.F.setCorner(0, -1);
        } else {
            this.F.setCorner(ba.f81748w, 3);
        }
    }

    private void t(int i3) {
        View view = this.H;
        if (view == null) {
            return;
        }
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.p3u);
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (i3 == 0) {
            int i16 = K;
            gradientDrawable.setCornerRadii(new float[]{i16, i16, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f});
        } else if (i3 == 2) {
            int i17 = K;
            gradientDrawable.setCornerRadii(new float[]{0.0f, 0.0f, i17, i17, 0.0f, 0.0f, 0.0f, 0.0f});
        }
        gradientDrawable.setColor(getContext().getResources().getColor(R.color.alw));
        frameLayout.setBackgroundDrawable(gradientDrawable);
    }

    private void u(int i3, int i16) {
        ViewGroup.LayoutParams layoutParams = this.itemView.getLayoutParams();
        layoutParams.width = i3;
        layoutParams.height = i16;
        this.itemView.setLayoutParams(layoutParams);
    }

    private void v(int i3, int i16) {
        stSimpleMetaFeed stsimplemetafeed;
        if (this.I != null && (stsimplemetafeed = this.J) != null && !TextUtils.isEmpty(stsimplemetafeed.f25129id) && TextUtils.equals(this.I.v0(), this.J.f25129id)) {
            if (this.H == null) {
                View inflate = ((ViewStub) this.itemView.findViewById(R.id.p46)).inflate();
                this.H = inflate;
                TextView textView = (TextView) inflate.findViewById(R.id.p7d);
                Drawable drawable = getContext().getResources().getDrawable(R.drawable.b8i);
                int i17 = ba.f81737l;
                drawable.setBounds(new Rect(0, 0, i17, i17));
                textView.setCompoundDrawablePadding(ba.f81729d);
                textView.setCompoundDrawables(drawable, null, null, null);
            }
            View view = this.H;
            if (view != null) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
                layoutParams.width = i3;
                layoutParams.height = i16;
                this.H.setLayoutParams(layoutParams);
                this.H.setVisibility(0);
            }
            t(getAdapterPosition());
            return;
        }
        View view2 = this.H;
        if (view2 != null) {
            view2.setVisibility(8);
        }
    }

    public void m(j jVar) {
        super.l(jVar);
        if (jVar != null) {
            stSimpleMetaFeed e16 = jVar.e();
            this.J = e16;
            if (e16 == null) {
                return;
            }
            s();
            WSPicLoader.g().m(this.F, this.J, true, "homepage_main", getAdapterPosition());
            Drawable drawable = getContext().getResources().getDrawable(R.drawable.b8i);
            int i3 = ba.f81734i;
            drawable.setBounds(new Rect(0, 0, i3, i3));
            this.G.setCompoundDrawablePadding(ba.f81729d);
            this.G.setCompoundDrawables(drawable, null, null, null);
            this.G.setText(ak.b(this.J.playNum));
            Pair<Integer, Integer> q16 = q();
            u(((Integer) q16.first).intValue(), ((Integer) q16.second).intValue());
            v(((Integer) q16.first).intValue(), ((Integer) q16.second).intValue());
        }
    }

    public stSimpleMetaFeed o() {
        return this.J;
    }

    public f(ViewGroup viewGroup, e eVar) {
        super(viewGroup, R.layout.d1e);
        this.I = eVar;
        r();
    }
}
