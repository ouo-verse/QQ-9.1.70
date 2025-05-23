package com.tencent.mobileqq.wink.view;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.aelight.camera.ae.util.PagViewMonitor;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.vas.ui.VasPagView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.util.LoadingUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.libpag.PAGFile;
import org.libpag.PAGView;

/* compiled from: P */
/* loaded from: classes21.dex */
public class ai extends Dialog implements View.OnClickListener {

    @Nullable
    private ProgressBar C;
    private boolean D;
    private int E;
    private boolean F;
    private boolean G;
    private Runnable H;
    private Callable<Boolean> I;
    private ImageView J;
    private View K;
    private View L;
    private final List<String> M;
    private int N;
    private Runnable P;

    /* renamed from: d, reason: collision with root package name */
    private String f326942d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f326943e;

    /* renamed from: f, reason: collision with root package name */
    private final Context f326944f;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f326945h;

    /* renamed from: i, reason: collision with root package name */
    private VasPagView f326946i;

    /* renamed from: m, reason: collision with root package name */
    private TextView f326947m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class a implements Function1<PAGView, Unit> {
        a() {
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(PAGView pAGView) {
            ai.this.o(pAGView);
            return null;
        }
    }

    ai(@NonNull Context context, @NonNull int i3) {
        super(context, i3);
        this.f326942d = "wink/pag/editor_loading_img_wezone.pag";
        this.f326943e = true;
        this.F = false;
        this.G = false;
        this.L = null;
        this.M = new ArrayList();
        this.N = 0;
        setCanceledOnTouchOutside(false);
        this.f326944f = context;
    }

    private void A() {
        VasPagView vasPagView = this.f326946i;
        if (vasPagView == null) {
            return;
        }
        vasPagView.api().postAction(new a());
    }

    private void i() {
        w53.b.a("WinkNoExposureLoadingDialog", "cancelTipsTimer");
        if (this.P != null) {
            ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.P);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ai k(boolean z16) {
        this.F = z16;
        return this;
    }

    private void l() {
        VasPagView vasPagView = this.f326946i;
        if (vasPagView == null) {
            return;
        }
        vasPagView.api().build();
        A();
    }

    private void m() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.g2i, (ViewGroup) null);
        this.K = inflate;
        setContentView(inflate);
        ViewStub viewStub = (ViewStub) findViewById(R.id.f89324zg);
        ViewStub viewStub2 = (ViewStub) findViewById(R.id.f89344zi);
        if (this.D) {
            viewStub.inflate();
            this.C = (ProgressBar) findViewById(R.id.g1o);
        } else {
            viewStub2.inflate();
        }
        this.J = (ImageView) findViewById(R.id.y5g);
        this.f326946i = (VasPagView) findViewById(R.id.f219902i);
        int i3 = 8;
        if (this.G) {
            ImageView imageView = this.J;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            VasPagView vasPagView = this.f326946i;
            if (vasPagView != null) {
                vasPagView.setVisibility(0);
            }
            l();
        } else {
            ImageView imageView2 = this.J;
            if (imageView2 != null) {
                imageView2.setVisibility(0);
            }
            VasPagView vasPagView2 = this.f326946i;
            if (vasPagView2 != null) {
                vasPagView2.setVisibility(8);
            }
            ImageView imageView3 = this.J;
            if (imageView3 != null) {
                if (this.f326943e) {
                    imageView3.setImageDrawable(LoadingUtil.getLoadingDrawable(this.f326944f, 2));
                    this.J.setScaleType(ImageView.ScaleType.CENTER);
                } else {
                    URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                    obtain.mUseApngImage = true;
                    obtain.mLoadingDrawable = com.tencent.mobileqq.urldrawable.b.f306350a;
                    this.J.setImageDrawable(URLDrawable.getDrawable("https://downv6.qq.com/shadow_qqcamera/Android/res/loading_white.png", obtain));
                }
            }
        }
        ImageView imageView4 = (ImageView) findViewById(R.id.dum);
        this.f326945h = imageView4;
        imageView4.setOnClickListener(this);
        ImageView imageView5 = this.f326945h;
        if (!this.F) {
            i3 = 0;
        }
        imageView5.setVisibility(i3);
        if (this.G) {
            this.f326946i = (VasPagView) findViewById(R.id.f219902i);
            l();
        }
        this.f326947m = (TextView) findViewById(R.id.kbr);
        if (this.L != null) {
            VideoReport.setLogicParent(findViewById(android.R.id.content), this.L);
        }
        VideoReport.ignorePageInOutEvent(this, true);
        VideoReport.setElementExposePolicy(this, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(this, ClickPolicy.REPORT_NONE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n() {
        int i3 = this.N + 1;
        this.N = i3;
        x(i3);
        if (isShowing() && this.N < this.M.size() - 1) {
            i();
            ThreadManagerV2.getUIHandlerV2().postDelayed(this.P, 2000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(PAGView pAGView) {
        PAGFile Load = PagViewMonitor.Load(this.f326944f.getAssets(), this.f326942d);
        if (Load != null) {
            pAGView.setComposition(Load);
            pAGView.setRepeatCount(0);
            pAGView.play();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ai r(boolean z16) {
        this.D = z16;
        m();
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ai s(boolean z16) {
        this.G = z16;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ai t(String str) {
        this.f326942d = str;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ai w(List<String> list) {
        this.M.addAll(list);
        if (!list.isEmpty()) {
            y(list.get(0));
        }
        return this;
    }

    private void x(int i3) {
        if (!this.M.isEmpty()) {
            y(this.M.get(i3 % this.M.size()));
        }
    }

    private void y(String str) {
        w53.b.a("WinkNoExposureLoadingDialog", "setTipText " + str);
        this.f326947m.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ai z(boolean z16) {
        this.f326943e = z16;
        return this;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        try {
            i();
            super.dismiss();
        } catch (Exception e16) {
            ms.a.c("WinkNoExposureLoadingDialog", "dismiss:exception:" + e16.getMessage());
        }
    }

    public int j() {
        return this.E;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        Boolean bool;
        Callable<Boolean> callable = this.I;
        if (callable != null) {
            try {
                bool = callable.call();
            } catch (Exception e16) {
                QLog.e("WinkNoExposureLoadingDialog", 4, e16, new Object[0]);
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
        if (view.getId() == R.id.dum) {
            Runnable runnable = this.H;
            if (runnable != null) {
                runnable.run();
            }
            dismiss();
        }
    }

    @Override // android.app.Dialog
    protected void onStop() {
        super.onStop();
    }

    public ai p(Callable<Boolean> callable) {
        this.I = callable;
        return this;
    }

    public ai q(Runnable runnable) {
        this.H = runnable;
        return this;
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        if (this.M.size() > 1) {
            w53.b.a("WinkNoExposureLoadingDialog", "startTimer");
            this.P = new Runnable() { // from class: com.tencent.mobileqq.wink.view.ah
                @Override // java.lang.Runnable
                public final void run() {
                    ai.this.n();
                }
            };
            ThreadManagerV2.getUIHandlerV2().postDelayed(this.P, 2000L);
        }
    }

    public ai u(View view) {
        this.L = view;
        return this;
    }

    public void v(@IntRange(from = 0, to = 100) int i3) {
        this.E = i3;
        ProgressBar progressBar = this.C;
        if (progressBar != null) {
            progressBar.setProgress(i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private final Context f326949a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f326950b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f326951c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f326952d;

        /* renamed from: e, reason: collision with root package name */
        private final List<String> f326953e;

        /* renamed from: f, reason: collision with root package name */
        private Runnable f326954f;

        /* renamed from: g, reason: collision with root package name */
        private Callable<Boolean> f326955g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f326956h;

        /* renamed from: i, reason: collision with root package name */
        private String f326957i;

        /* renamed from: j, reason: collision with root package name */
        private View f326958j;

        /* renamed from: k, reason: collision with root package name */
        private int f326959k;

        public b(Context context) {
            this.f326951c = false;
            this.f326952d = true;
            this.f326956h = false;
            this.f326957i = "wink/pag/editor_loading_img_wezone.pag";
            this.f326958j = null;
            this.f326959k = R.style.a5k;
            this.f326949a = context;
            this.f326950b = false;
            this.f326953e = new ArrayList();
        }

        private boolean c() {
            return false;
        }

        public ai a() {
            if (!this.f326953e.isEmpty() || !c()) {
                return new ai(this.f326949a, this.f326959k).u(this.f326958j).s(this.f326951c).t(this.f326957i).z(this.f326952d).k(this.f326956h).r(this.f326950b).q(this.f326954f).p(this.f326955g).w(this.f326953e);
            }
            throw new IllegalArgumentException("Do you forget call withTipList() or withSingleTip() ?");
        }

        public b b(boolean z16) {
            this.f326956h = z16;
            return this;
        }

        public b d(Callable<Boolean> callable) {
            this.f326955g = callable;
            return this;
        }

        public b e(Runnable runnable) {
            this.f326954f = runnable;
            return this;
        }

        public b f(View view) {
            this.f326958j = view;
            return this;
        }

        public b g(List<String> list) {
            this.f326953e.clear();
            this.f326953e.addAll(list);
            return this;
        }

        public b h(boolean z16) {
            this.f326950b = z16;
            return this;
        }

        public b i(String str) {
            if (TextUtils.isEmpty(str)) {
                if (!c()) {
                    return this;
                }
                throw new IllegalArgumentException("singleTip should not be empty");
            }
            this.f326953e.clear();
            this.f326953e.add(str);
            return this;
        }

        public b(Context context, int i3) {
            this.f326951c = false;
            this.f326952d = true;
            this.f326956h = false;
            this.f326957i = "wink/pag/editor_loading_img_wezone.pag";
            this.f326958j = null;
            this.f326959k = R.style.a5k;
            this.f326949a = context;
            this.f326950b = false;
            this.f326953e = new ArrayList();
            this.f326959k = i3;
        }
    }
}
