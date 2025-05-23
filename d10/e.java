package d10;

import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI;
import com.tencent.biz.pubaccount.weishi.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi.util.ba;
import com.tencent.biz.pubaccount.weishi.view.WSRoundedImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;

/* compiled from: P */
/* loaded from: classes38.dex */
public class e extends AbsWsUI<c10.a> implements View.OnClickListener {
    private static final int J = Color.parseColor("#e1e1e1");
    private WSRoundedImageView C;
    private TextView D;
    private TextView E;
    private final Context F;
    private final stSimpleMetaFeed G;
    private String H;
    private int I;

    /* renamed from: m, reason: collision with root package name */
    private View f392644m;

    public e(Context context, stSimpleMetaFeed stsimplemetafeed) {
        super(context);
        this.F = context;
        this.G = stsimplemetafeed;
        p(context);
    }

    private void p(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.fxe, (ViewGroup) null);
        this.f392644m = inflate;
        WSRoundedImageView wSRoundedImageView = (WSRoundedImageView) inflate.findViewById(R.id.v2n);
        this.C = wSRoundedImageView;
        wSRoundedImageView.setStrokeWidth(ba.f81727b);
        this.C.setStrokeColor(J);
        this.D = (TextView) this.f392644m.findViewById(R.id.v2p);
        this.E = (TextView) this.f392644m.findViewById(R.id.v2o);
        this.f392644m.setOnClickListener(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void h() {
        this.D.setText(((c10.a) this.f80413i).d());
        this.E.setText(((c10.a) this.f80413i).c());
        WSPicLoader.g().j(this.F, this.C, ((c10.a) this.f80413i).a());
    }

    public void o(ViewGroup viewGroup) {
        if (((ViewGroup) this.f392644m.getParent()) != null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, ViewUtils.dpToPx(36.0f));
        int dpToPx = ViewUtils.dpToPx(7.5f);
        layoutParams.bottomMargin = dpToPx;
        layoutParams.topMargin = dpToPx;
        viewGroup.addView(this.f392644m, layoutParams);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.tencent.biz.pubaccount.weishi.util.n.c(b(), this.G, ((c10.a) this.f80413i).b(), this.f80411f, this.I, this.H);
    }

    public void q() {
        ViewGroup viewGroup = (ViewGroup) this.f392644m.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(this.f392644m);
        }
    }

    public void r(c10.a aVar) {
        super.j(aVar);
    }

    public void s(int i3) {
        this.I = i3;
    }

    public void t(String str) {
        this.H = str;
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void f() {
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void g() {
    }
}
