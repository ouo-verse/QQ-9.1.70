package com.tencent.biz.pubaccount.weishi;

import UserGrowth.stPublisherGuide;
import UserGrowth.stPublisherRsp;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi.report.WSPublicAccReport;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdConfigDefine$APPID;

/* compiled from: P */
/* loaded from: classes32.dex */
public class r extends com.tencent.biz.subscribe.comment.p implements View.OnClickListener {
    private Context D;
    private View E;
    private TextView F;
    private TextView G;
    private URLImageView H;
    private ImageView I;
    private LinearLayout J;
    private stPublisherRsp K;
    private o L;
    private cz.a M;
    private String N;

    public r(Context context) {
        this(context, -1, -1);
    }

    private void P() {
        if (isShowing()) {
            dismiss();
        }
    }

    private void Q() {
        cz.a aVar;
        if (this.K == null || (aVar = this.M) == null) {
            return;
        }
        aVar.onClick();
    }

    private void R(String str, String str2, int i3) {
        WSPublicAccReport.getInstance().reportPublisher(str, this.N, str2, i3);
    }

    private void initView() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.fwi, (ViewGroup) null, false);
        this.E = inflate;
        setContentView(inflate);
        this.F = (TextView) this.E.findViewById(R.id.f125427m1);
        this.G = (TextView) this.E.findViewById(R.id.f125437m2);
        this.H = (URLImageView) this.E.findViewById(R.id.f125197le);
        this.I = (ImageView) this.E.findViewById(R.id.f125207lf);
        this.J = (LinearLayout) this.E.findViewById(R.id.f125247lj);
        RelativeLayout relativeLayout = (RelativeLayout) this.E.findViewById(R.id.f125287ln);
        this.I.setOnClickListener(this);
        this.J.setOnClickListener(this);
        relativeLayout.setOnClickListener(this);
        R("gzh_exposure", "publish_popup", 0);
    }

    public void S(stPublisherRsp stpublisherrsp) {
        stPublisherGuide stpublisherguide;
        this.K = stpublisherrsp;
        Drawable drawable = this.D.getResources().getDrawable(R.drawable.d7y);
        stPublisherRsp stpublisherrsp2 = this.K;
        if (stpublisherrsp2 != null && (stpublisherguide = stpublisherrsp2.guide) != null) {
            String str = stpublisherguide.imageUrl;
            this.F.setText(stpublisherguide.desc);
            this.G.setText(this.K.guide.btnText);
            o oVar = new o();
            this.L = oVar;
            oVar.f(this.H, drawable, str, true, false);
            return;
        }
        this.H.setImageDrawable(drawable);
    }

    public void U(cz.a aVar) {
        this.M = aVar;
    }

    public void W(String str) {
        this.N = str;
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        o oVar = this.L;
        if (oVar != null) {
            oVar.c();
            this.L = null;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id5 = view.getId();
        if (id5 == R.id.f125207lf) {
            R("gzh_click", "publish_popup", QAdConfigDefine$APPID.QQLIVE);
            P();
        } else if (id5 == R.id.f125247lj) {
            Q();
            P();
        } else {
            if (id5 != R.id.f125287ln) {
                return;
            }
            R("gzh_click", "publish_popup", 1000001);
            P();
        }
    }

    public r(Context context, int i3, int i16) {
        this(context, R.style.f174285y0, i3, i16);
    }

    protected r(Context context, int i3, int i16, int i17) {
        super(context, i3);
        this.D = context;
        initView();
        Window window = getWindow();
        if (window == null) {
            com.tencent.biz.pubaccount.weishi.util.x.a("WSPublisherDialog", 2, "ScrollMoreDialog() window == null.");
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (attributes == null) {
            com.tencent.biz.pubaccount.weishi.util.x.a("WSPublisherDialog", 2, "ScrollMoreDialog() params == null.");
        } else {
            attributes.width = i16;
            attributes.height = i17;
        }
    }
}
