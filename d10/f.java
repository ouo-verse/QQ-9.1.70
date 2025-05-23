package d10;

import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stWaterFallCardStyle;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi.t;
import com.tencent.biz.pubaccount.weishi.util.ba;
import com.tencent.biz.pubaccount.weishi.view.RoundCornerImageView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes38.dex */
public class f extends com.tencent.biz.pubaccount.weishi.baseui.b<stSimpleMetaFeed> {
    private static final int I = com.tencent.biz.pubaccount.weishi.util.r.H(5.0f);
    private RoundCornerImageView C;
    private final View D;
    private View E;
    private t F;
    private final int G;
    private stSimpleMetaFeed H;

    public f(Context context, View view, int i3, t tVar) {
        super(context);
        this.G = i3;
        this.D = view;
        this.F = tVar;
    }

    private void u() {
        this.C.setCorner(I, this.G);
        v();
    }

    private void v() {
        View view = this.E;
        if (view == null) {
            return;
        }
        TextView textView = (TextView) view.findViewById(R.id.f107936br);
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (this.G == 1) {
            int i3 = I;
            gradientDrawable.setCornerRadii(new float[]{i3, i3, i3, i3, 0.0f, 0.0f, 0.0f, 0.0f});
        } else {
            int i16 = I;
            gradientDrawable.setCornerRadii(new float[]{i16, i16, i16, i16, i16, i16, i16, i16});
        }
        gradientDrawable.setColor(e().getColor(R.color.f156803br));
        textView.setBackgroundDrawable(gradientDrawable);
    }

    private void w() {
        String str;
        stWaterFallCardStyle stwaterfallcardstyle = this.H.waterFallCardStyle;
        ((StaggeredGridLayoutManager.LayoutParams) this.D.getLayoutParams()).setFullSpan(stwaterfallcardstyle != null && stwaterfallcardstyle.isFullSpan);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.C.getLayoutParams();
        Pair<Integer, Integer> i3 = ba.i(this.H);
        layoutParams.width = -1;
        layoutParams.height = ((Integer) i3.second).intValue();
        this.C.setLayoutParams(layoutParams);
        t tVar = this.F;
        if (tVar != null && !TextUtils.isEmpty(tVar.F)) {
            str = "feeds_" + this.F.F;
        } else {
            str = "feeds";
        }
        WSPicLoader g16 = WSPicLoader.g();
        RoundCornerImageView roundCornerImageView = this.C;
        stSimpleMetaFeed stsimplemetafeed = this.H;
        g16.l(roundCornerImageView, stsimplemetafeed, ba.m(stsimplemetafeed), str, true, d());
        x(i3);
    }

    private void x(Pair<Integer, Integer> pair) {
        if (this.F != null && !TextUtils.isEmpty(this.H.f25129id) && TextUtils.equals(this.F.G, this.H.f25129id) && this.F.H) {
            if (this.E == null) {
                this.E = ((ViewStub) this.D.findViewById(R.id.xtv)).inflate();
            }
            View view = this.E;
            if (view != null) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
                layoutParams.width = ((Integer) pair.first).intValue();
                layoutParams.height = ((Integer) pair.second).intValue();
                this.E.setLayoutParams(layoutParams);
                this.E.setVisibility(0);
                return;
            }
            return;
        }
        View view2 = this.E;
        if (view2 != null) {
            view2.setVisibility(8);
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void g() {
        this.H = c();
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void h() {
        w();
        u();
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.b
    protected int q() {
        return R.layout.fxf;
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.b
    protected void s() {
        this.C = (RoundCornerImageView) p(R.id.xwv);
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void f() {
    }
}
