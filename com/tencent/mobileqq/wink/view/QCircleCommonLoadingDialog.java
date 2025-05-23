package com.tencent.mobileqq.wink.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.tencent.aelight.camera.ae.util.PagViewMonitor;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.ui.VasPagView;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.util.LoadingUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.libpag.PAGFile;
import org.libpag.PAGView;

/* compiled from: P */
/* loaded from: classes21.dex */
public class QCircleCommonLoadingDialog extends ReportDialog implements View.OnClickListener {

    /* renamed from: b0, reason: collision with root package name */
    private static final Interpolator f326815b0 = PathInterpolatorCompat.create(0.4f, 0.0f, 0.2f, 1.0f);
    private String C;
    private boolean D;
    private final WeakReference<Context> E;
    private ImageView F;
    private VasPagView G;
    private TextView H;

    @Nullable
    private ProgressBar I;
    private final List<String> J;
    private int K;
    private boolean L;
    private boolean M;
    private int N;
    private boolean P;
    private boolean Q;
    private long R;
    private boolean S;
    private Runnable T;
    private View.OnClickListener U;
    private Callable<Boolean> V;
    private Runnable W;
    private ImageView X;
    private View Y;
    private String Z;

    /* renamed from: a0, reason: collision with root package name */
    private final Runnable f326816a0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class a implements Function1<PAGView, Unit> {
        a() {
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(PAGView pAGView) {
            QCircleCommonLoadingDialog.this.o0(pAGView);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class b extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        boolean f326818d = false;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ AnimatorSet f326819e;

        b(AnimatorSet animatorSet) {
            this.f326819e = animatorSet;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            QLog.d("QCircleCustomLoadingDialog", 4, "onAnimationCancel");
            this.f326818d = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f326819e.removeListener(this);
            if (!this.f326818d) {
                QCircleCommonLoadingDialog qCircleCommonLoadingDialog = QCircleCommonLoadingDialog.this;
                int i3 = qCircleCommonLoadingDialog.K + 1;
                qCircleCommonLoadingDialog.K = i3;
                qCircleCommonLoadingDialog.K = i3 % QCircleCommonLoadingDialog.this.J.size();
                QCircleCommonLoadingDialog qCircleCommonLoadingDialog2 = QCircleCommonLoadingDialog.this;
                qCircleCommonLoadingDialog2.D0((String) qCircleCommonLoadingDialog2.J.get(QCircleCommonLoadingDialog.this.K));
                this.f326819e.start();
                QCircleCommonLoadingDialog.this.H.setTag(this.f326819e);
            }
        }
    }

    QCircleCommonLoadingDialog(@NonNull Context context, @NonNull int i3) {
        super(context, i3);
        this.C = "wink/pag/editor_loading_img_wezone.pag";
        this.D = true;
        this.P = true;
        this.Q = false;
        this.R = 1500L;
        this.S = false;
        this.Z = "none";
        this.f326816a0 = new Runnable() { // from class: com.tencent.mobileqq.wink.view.QCircleCommonLoadingDialog.1
            @Override // java.lang.Runnable
            public void run() {
                QCircleCommonLoadingDialog.this.n0();
                ThreadManagerV2.getUIHandlerV2().postDelayed(QCircleCommonLoadingDialog.this.f326816a0, QCircleCommonLoadingDialog.this.R + 1000);
            }
        };
        setCanceledOnTouchOutside(false);
        this.E = new WeakReference<>(context);
        this.J = new ArrayList();
        this.K = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public QCircleCommonLoadingDialog A0(String str) {
        this.C = str;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public QCircleCommonLoadingDialog C0(List<String> list) {
        this.J.addAll(list);
        if (!list.isEmpty()) {
            D0(list.get(0));
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D0(String str) {
        this.H.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public QCircleCommonLoadingDialog H0(boolean z16) {
        this.D = z16;
        return this;
    }

    private void I0() {
        VasPagView vasPagView = this.G;
        if (vasPagView == null) {
            return;
        }
        vasPagView.api().postAction(new a());
    }

    private Context g0() {
        return this.E.get();
    }

    private void initView() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.g2i, (ViewGroup) null);
        this.Y = inflate;
        setContentView(inflate);
        ViewStub viewStub = (ViewStub) findViewById(R.id.f89324zg);
        ViewStub viewStub2 = (ViewStub) findViewById(R.id.f89344zi);
        if (this.M) {
            viewStub.inflate();
            this.I = (ProgressBar) findViewById(R.id.g1o);
        } else {
            viewStub2.inflate();
        }
        this.X = (ImageView) findViewById(R.id.y5g);
        this.G = (VasPagView) findViewById(R.id.f219902i);
        int i3 = 8;
        if (this.S) {
            this.X.setVisibility(8);
            this.G.setVisibility(0);
            m0();
        } else {
            this.X.setVisibility(0);
            this.G.setVisibility(8);
            if (this.D) {
                this.X.setImageDrawable(LoadingUtil.getLoadingDrawable(getContext(), 2));
                this.X.setScaleType(ImageView.ScaleType.CENTER);
            } else {
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                obtain.mUseApngImage = true;
                obtain.mLoadingDrawable = com.tencent.mobileqq.urldrawable.b.f306350a;
                this.X.setImageDrawable(URLDrawable.getDrawable("https://downv6.qq.com/shadow_qqcamera/Android/res/loading_white.png", obtain));
            }
        }
        ImageView imageView = (ImageView) findViewById(R.id.dum);
        this.F = imageView;
        imageView.setOnClickListener(this);
        ImageView imageView2 = this.F;
        if (!this.Q) {
            i3 = 0;
        }
        imageView2.setVisibility(i3);
        this.H = (TextView) findViewById(R.id.kbr);
        q0(WinkDaTongReportConstant.PageId.PG_XSJ_EDIT_PAGE, null);
        p0(WinkDaTongReportConstant.ElementId.EM_XSJ_LOADING_PANEL, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public QCircleCommonLoadingDialog l0(boolean z16) {
        this.Q = z16;
        return this;
    }

    private void m0() {
        VasPagView vasPagView = this.G;
        if (vasPagView == null) {
            return;
        }
        vasPagView.api().build();
        I0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n0() {
        if (!this.P && this.K == this.J.size() - 1) {
            Runnable runnable = this.W;
            if (runnable != null) {
                runnable.run();
                return;
            }
            return;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.H, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f);
        ofFloat.setDuration(400L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.H, "translationX", 0.0f, ViewUtils.dip2px(32.0f));
        ofFloat2.setDuration(500L);
        animatorSet.playTogether(ofFloat, ofFloat2);
        Interpolator interpolator = f326815b0;
        animatorSet.setInterpolator(interpolator);
        AnimatorSet animatorSet2 = new AnimatorSet();
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.H, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
        ofFloat.setDuration(400L);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.H, "translationX", -ViewUtils.dip2px(32.0f), 0.0f);
        ofFloat2.setDuration(500L);
        animatorSet2.playTogether(ofFloat3, ofFloat4);
        animatorSet2.setInterpolator(interpolator);
        animatorSet.start();
        this.H.setTag(animatorSet);
        animatorSet.addListener(new b(animatorSet2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o0(PAGView pAGView) {
        PAGFile Load;
        Context g06 = g0();
        if (g06 != null && (Load = PagViewMonitor.Load(g06.getAssets(), this.C)) != null) {
            pAGView.setComposition(Load);
            pAGView.setRepeatCount(0);
            pAGView.play();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public QCircleCommonLoadingDialog u0(boolean z16) {
        this.L = z16;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public QCircleCommonLoadingDialog w0(boolean z16) {
        this.M = z16;
        initView();
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public QCircleCommonLoadingDialog x0(boolean z16) {
        this.S = z16;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public QCircleCommonLoadingDialog y0(boolean z16) {
        this.P = z16;
        return this;
    }

    public QCircleCommonLoadingDialog B0(String str) {
        this.Z = str;
        return this;
    }

    public QCircleCommonLoadingDialog E0(Runnable runnable) {
        this.W = runnable;
        return this;
    }

    public QCircleCommonLoadingDialog F0(long j3) {
        this.R = j3;
        return this;
    }

    public void J0(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.w("QCircleCustomLoadingDialog", 4, "updateTip, updateTip is empty");
        } else {
            if (this.L) {
                QLog.w("QCircleCustomLoadingDialog", 4, "updateTip, mFixedIntervalMarquee mode do not support update tip");
                return;
            }
            this.J.clear();
            this.J.add(str);
            n0();
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        try {
            if (this.L) {
                ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.f326816a0);
            }
            super.cancel();
        } catch (Exception e16) {
            ms.a.d("QCircleCustomLoadingDialog", "[cancel]", e16);
        }
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        try {
            super.dismiss();
            if (this.L) {
                ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.f326816a0);
            }
        } catch (Exception e16) {
            ms.a.d("QCircleCustomLoadingDialog", "[dismiss]", e16);
        }
        if (this.H.getTag() instanceof Animator) {
            ((Animator) this.H.getTag()).cancel();
            ((Animator) this.H.getTag()).removeAllListeners();
            this.H.setTag(null);
        }
        Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
        buildElementParams.put("xsj_eid", this.Z);
        VideoReport.reportEvent("dt_imp_end", this.F, buildElementParams);
        if (this.Z.equals("image_enhance")) {
            buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IMAGE_ENHANCE_ALGORITHM_WATERMARK, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_IMAGE_ENHANCE_ALGORITHM_WATERMARK));
            buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IMAGE_ENHANCE_ALGORITHM_DEBLUR, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_IMAGE_ENHANCE_ALGORITHM_DEBLUR));
            buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IMAGE_ENHANCE_ALGORITHM_VIDEOLENGTH, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_IMAGE_ENHANCE_ALGORITHM_VIDEOLENGTH));
            buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IMAGE_ENHANCE_ALGORITHM_FACE, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_IMAGE_ENHANCE_ALGORITHM_FACE));
            VideoReport.reportEvent("ev_xsj_camera_action", this.F, buildElementParams);
        }
    }

    public ImageView i0() {
        return this.F;
    }

    public int j0() {
        return this.K;
    }

    public int k0() {
        return this.N;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        Boolean bool;
        Callable<Boolean> callable = this.V;
        if (callable != null) {
            try {
                bool = callable.call();
            } catch (Exception e16) {
                QLog.e("QCircleCustomLoadingDialog", 4, e16, new Object[0]);
                super.onBackPressed();
                bool = null;
            }
            if (bool == null || !bool.booleanValue()) {
                super.onBackPressed();
                return;
            }
            return;
        }
        super.onBackPressed();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.dum) {
            Runnable runnable = this.T;
            if (runnable != null) {
                runnable.run();
            }
            View.OnClickListener onClickListener = this.U;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
            dismiss();
            Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
            buildElementParams.put("xsj_eid", this.Z);
            VideoReport.reportEvent("dt_clck", this.F, buildElementParams);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void p0(String str, Map<String, Object> map) {
        if (this.F == null) {
            return;
        }
        Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
        if (map != null && map.size() > 0) {
            buildElementParams.putAll(map);
        }
        VideoReport.setElementId(this.F, str);
        VideoReport.setElementParams(this.F, buildElementParams);
        VideoReport.setElementExposePolicy(this.F, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(this.F, ClickPolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(this.F, EndExposurePolicy.REPORT_ALL);
    }

    public void q0(String str, Map<String, Object> map) {
        if (this.Y == null) {
            return;
        }
        VideoReport.addToDetectionWhitelist(getOwnerActivity());
        VideoReport.setPageId(this.Y, str);
        VideoReport.setPageParams(this.Y, new WinkDTParamBuilder().buildPageParams(map, WinkContext.INSTANCE.d().getDtParams().c()));
        VideoReport.ignorePageInOutEvent(this.Y, true);
    }

    public QCircleCommonLoadingDialog r0(Callable<Boolean> callable) {
        this.V = callable;
        return this;
    }

    @Deprecated
    public QCircleCommonLoadingDialog s0(Runnable runnable) {
        this.T = runnable;
        return this;
    }

    public void setProgress(@IntRange(from = 0, to = 100) int i3) {
        this.N = i3;
        ProgressBar progressBar = this.I;
        if (progressBar != null) {
            progressBar.setProgress(i3);
        }
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog
    public void show() {
        super.show();
        if (this.L) {
            ThreadManagerV2.getUIHandlerV2().postDelayed(this.f326816a0, this.R);
        }
        Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
        buildElementParams.put("xsj_eid", this.Z);
        VideoReport.reportEvent("dt_imp", this.F, buildElementParams);
    }

    public QCircleCommonLoadingDialog z0(View.OnClickListener onClickListener) {
        this.U = onClickListener;
        return this;
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        private final Context f326821a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f326822b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f326823c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f326824d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f326825e;

        /* renamed from: f, reason: collision with root package name */
        private final List<String> f326826f;

        /* renamed from: g, reason: collision with root package name */
        @Deprecated
        private Runnable f326827g;

        /* renamed from: h, reason: collision with root package name */
        private View.OnClickListener f326828h;

        /* renamed from: i, reason: collision with root package name */
        private Callable<Boolean> f326829i;

        /* renamed from: j, reason: collision with root package name */
        private Runnable f326830j;

        /* renamed from: k, reason: collision with root package name */
        private boolean f326831k;

        /* renamed from: l, reason: collision with root package name */
        private boolean f326832l;

        /* renamed from: m, reason: collision with root package name */
        private long f326833m;

        /* renamed from: n, reason: collision with root package name */
        private String f326834n;

        /* renamed from: o, reason: collision with root package name */
        private String f326835o;

        /* renamed from: p, reason: collision with root package name */
        private int f326836p;

        public c(Context context) {
            this.f326823c = false;
            this.f326824d = true;
            this.f326831k = true;
            this.f326832l = false;
            this.f326833m = 1500L;
            this.f326834n = "wink/pag/editor_loading_img_wezone.pag";
            this.f326835o = "none";
            this.f326836p = R.style.a5k;
            this.f326821a = context;
            this.f326822b = false;
            this.f326825e = false;
            this.f326826f = new ArrayList();
        }

        private boolean c() {
            return false;
        }

        public QCircleCommonLoadingDialog a() {
            if (!this.f326826f.isEmpty() || !c()) {
                return new QCircleCommonLoadingDialog(this.f326821a, this.f326836p).B0(this.f326835o).x0(this.f326823c).H0(this.f326824d).A0(this.f326834n).l0(this.f326832l).w0(this.f326822b).u0(this.f326825e).s0(this.f326827g).z0(this.f326828h).r0(this.f326829i).E0(this.f326830j).y0(this.f326831k).F0(this.f326833m).C0(this.f326826f);
            }
            throw new IllegalArgumentException("Do you forget call withTipList() or withSingleTip() ?");
        }

        public c b() {
            this.f326832l = true;
            return this;
        }

        public c d(Callable<Boolean> callable) {
            this.f326829i = callable;
            return this;
        }

        @Deprecated
        public c e(Runnable runnable) {
            this.f326827g = runnable;
            return this;
        }

        public c f(long j3) {
            this.f326833m = j3;
            return this;
        }

        public c g(boolean z16) {
            this.f326831k = z16;
            return this;
        }

        public c h(View.OnClickListener onClickListener) {
            this.f326828h = onClickListener;
            return this;
        }

        public c i(String str) {
            this.f326834n = str;
            return this;
        }

        public c j(String str) {
            this.f326835o = str;
            return this;
        }

        public c k(Runnable runnable) {
            this.f326830j = runnable;
            return this;
        }

        public c l(long j3) {
            this.f326833m = j3;
            return this;
        }

        public c m(boolean z16) {
            this.f326823c = z16;
            return this;
        }

        public c n(boolean z16) {
            this.f326822b = z16;
            return this;
        }

        public c o(boolean z16) {
            this.f326824d = z16;
            return this;
        }

        public c p(String str) {
            if (TextUtils.isEmpty(str)) {
                if (!c()) {
                    this.f326825e = false;
                    return this;
                }
                throw new IllegalArgumentException("singleTip should not be empty");
            }
            this.f326826f.clear();
            this.f326826f.add(str);
            this.f326825e = false;
            return this;
        }

        public c q(List<String> list) {
            boolean z16 = false;
            if (list != null && !list.isEmpty()) {
                this.f326826f.clear();
                this.f326826f.addAll(list);
                if (list.size() > 1) {
                    z16 = true;
                }
                this.f326825e = z16;
                return this;
            }
            if (!c()) {
                this.f326825e = false;
                return this;
            }
            throw new IllegalArgumentException("tipList should not be null or empty");
        }

        public c(Context context, int i3) {
            this.f326823c = false;
            this.f326824d = true;
            this.f326831k = true;
            this.f326832l = false;
            this.f326833m = 1500L;
            this.f326834n = "wink/pag/editor_loading_img_wezone.pag";
            this.f326835o = "none";
            this.f326836p = R.style.a5k;
            this.f326821a = context;
            this.f326822b = false;
            this.f326825e = false;
            this.f326826f = new ArrayList();
            this.f326836p = i3;
        }
    }
}
