package nj;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qzone.reborn.configx.g;
import com.qzone.util.ar;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenDefaultHeaderView;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenFloatingView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;

/* compiled from: P */
/* loaded from: classes38.dex */
public class e extends ReportDialog {
    View C;
    private View D;
    private ImageView E;
    private TextView F;
    private QUIButton G;
    private QUSHalfScreenFloatingView H;
    private com.qzone.reborn.intimate.bean.init.a I;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes38.dex */
    public class a extends com.tencent.mobileqq.widget.qus.e {
        a() {
        }

        @Override // com.tencent.mobileqq.widget.qus.d
        /* renamed from: createContentView */
        public View getF57419d() {
            e eVar = e.this;
            eVar.D = LayoutInflater.from(eVar.getContext()).inflate(R.layout.cjs, (ViewGroup) null);
            e.this.D.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            e.this.initView();
            return e.this.D;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int maxHeight() {
            return (int) ((ar.l() * 1.549f) + ar.d(36.0f));
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int showMode() {
            return 1;
        }
    }

    private void S() {
        this.H.setDraggable(true);
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        relativeLayout.setBackgroundResource(R.drawable.f15774s);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, ar.d(36.0f)));
        relativeLayout.addView(new QUSHalfScreenDefaultHeaderView(getContext(), null, 0));
        this.H.setHeaderView(relativeLayout);
        this.H.setQUSDragFloatController(new a());
        this.H.setOnDismissListener(new QUSBaseHalfScreenFloatingView.l() { // from class: nj.c
            @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.l
            public final void onDismiss() {
                e.this.U();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = this.H;
        if (qUSHalfScreenFloatingView != null) {
            qUSHalfScreenFloatingView.t();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private void X() {
        String pageId;
        com.qzone.reborn.intimate.bean.init.a aVar = this.I;
        if (aVar == null) {
            pageId = "qzone_base_pageId";
        } else {
            pageId = aVar.getPageId();
        }
        VideoReport.setPageId(this.C, pageId);
        VideoReport.setPageReportPolicy(this.C, PageReportPolicy.REPORT_NONE);
        View view = this.C;
        QCircleDTParamBuilder qCircleDTParamBuilder = new QCircleDTParamBuilder();
        com.qzone.reborn.intimate.bean.init.a aVar2 = this.I;
        VideoReport.setPageParams(view, qCircleDTParamBuilder.buildPageParams("QZoneIntimateLoveSpaceOldUserGuideDialog", aVar2 == null ? null : aVar2.b()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initView() {
        String y16;
        this.E = (ImageView) this.D.findViewById(R.id.n4u);
        int a16 = ef.a.f396213a.a("#FFF5F6", getContext().getColor(R.color.qui_common_bg_top_light));
        com.qzone.reborn.intimate.bean.init.a aVar = this.I;
        if (aVar != null && !TextUtils.isEmpty(aVar.getCom.qzone.proxy.feedcomponent.model.RegionData.KEY_BG_IMG_URL java.lang.String())) {
            y16 = this.I.getCom.qzone.proxy.feedcomponent.model.RegionData.KEY_BG_IMG_URL java.lang.String();
        } else {
            y16 = g.f53821a.h().y();
        }
        QLog.d("QZoneIntimateLoveSpaceOldUserGuideDialog", 1, "[initView] bgImgUrl = " + y16);
        com.tencent.mobileqq.qzone.picload.c.a().h(Option.obtain().setUrl(y16).setTargetView(this.E).setFailedDrawableColor(a16).setLoadingDrawableColor(a16));
        TextView textView = (TextView) this.D.findViewById(R.id.n4x);
        this.F = textView;
        textView.setText(g.f53821a.h().z());
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.F.getLayoutParams();
        layoutParams.topMargin = (int) (ar.l() * 0.024f);
        this.F.setLayoutParams(layoutParams);
        QUIButton qUIButton = (QUIButton) this.D.findViewById(R.id.n4v);
        this.G = qUIButton;
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) qUIButton.getLayoutParams();
        layoutParams2.bottomMargin = (int) (ar.l() * 0.17f);
        this.G.setLayoutParams(layoutParams2);
        this.G.setOnClickListener(new View.OnClickListener() { // from class: nj.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.this.W(view);
            }
        });
        fo.c.o(this.C, "em_bas_couples_space_floating_layer", new fo.b().g(ClickPolicy.REPORT_NONE));
    }

    private void initWindow() {
        Window window = getWindow();
        if (window == null) {
            return;
        }
        window.requestFeature(1);
        try {
            ImmersiveUtils.clearCoverForStatus(window, true);
        } catch (Exception e16) {
            QLog.e("QZoneIntimateLoveSpaceOldUserGuideDialog", 1, "clearCoverForStatus fail:" + e16.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U() {
        QLog.d("QZoneIntimateLoveSpaceOldUserGuideDialog", 1, "[onDismiss]");
        dismiss();
    }

    public e(Context context, com.qzone.reborn.intimate.bean.init.a aVar) {
        super(context, R.style.f173448dl);
        initWindow();
        setContentView(R.layout.cjr);
        this.C = findViewById(R.id.n4w);
        this.I = aVar;
        this.H = (QUSHalfScreenFloatingView) findViewById(R.id.miy);
        X();
        S();
    }
}
