package com.tencent.aelight.camera.aeeditor.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.aelight.camera.ae.util.PagViewMonitor;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.vas.ui.VasPagView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.libpag.PAGFile;
import org.libpag.PAGView;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AEEditorLoadingView extends FrameLayout {
    private static final String Q;
    private static final String R;
    private static final String S;
    private static final String T;
    private static final String U;
    private TextView C;
    private TextView D;
    private TextView E;
    private View F;
    private View G;
    private View H;
    private TextView I;
    private int J;
    private int K;
    private String L;
    private ObjectAnimator M;
    private CountDownTimer N;
    private boolean P;

    /* renamed from: d, reason: collision with root package name */
    private View f66231d;

    /* renamed from: e, reason: collision with root package name */
    private LinearLayout f66232e;

    /* renamed from: f, reason: collision with root package name */
    private VasPagView f66233f;

    /* renamed from: h, reason: collision with root package name */
    private VasPagView f66234h;

    /* renamed from: i, reason: collision with root package name */
    private ProgressBar f66235i;

    /* renamed from: m, reason: collision with root package name */
    private RelativeLayout f66236m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            AEEditorLoadingView.this.j();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class b implements Function1<PAGView, Unit> {
        b() {
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(PAGView pAGView) {
            if (AEEditorLoadingView.this.P) {
                AEEditorLoadingView.this.n(pAGView, AEEditorLoadingView.Q);
                return null;
            }
            AEEditorLoadingView.this.n(pAGView, AEEditorLoadingView.U);
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class c implements Function1<PAGView, Unit> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f66239d;

        c(int i3) {
            this.f66239d = i3;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(PAGView pAGView) {
            String str;
            int i3 = this.f66239d;
            if (i3 == 1) {
                str = AEEditorLoadingView.R;
            } else {
                str = i3 != 2 ? i3 != 4 ? AEEditorLoadingView.T : "" : AEEditorLoadingView.S;
            }
            AEEditorLoadingView.this.n(pAGView, str);
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface e {
    }

    static {
        StringBuilder sb5 = new StringBuilder();
        String str = ar.e.f26776b;
        sb5.append(str);
        String str2 = File.separator;
        sb5.append(str2);
        sb5.append("editor_loading_img_bmp.pag");
        Q = sb5.toString();
        R = str + str2 + "editor_loading_text_filter_bmp.pag";
        S = str + str2 + "editor_loading_text_dapian_bmp.pag";
        T = str + str2 + "editor_loading_text_muban_bmp.pag";
        U = WinkEditorResourceManager.a1().c1();
    }

    public AEEditorLoadingView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        i();
    }

    private void k(Context context) {
        this.f66231d = LayoutInflater.from(context).inflate(R.layout.dno, this);
        l();
        m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(PAGView pAGView, String str) {
        PAGFile Load;
        File file = new File(str);
        if (!file.exists() || (Load = PagViewMonitor.Load(file.getAbsolutePath())) == null) {
            return;
        }
        pAGView.setComposition(Load);
        pAGView.setRepeatCount(0);
        pAGView.play();
    }

    public void i() {
        if (getParent() == null) {
            return;
        }
        ((ViewGroup) getParent()).removeAllViews();
        CountDownTimer countDownTimer = this.N;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    public void o(int i3) {
        this.f66231d.setAlpha(0.0f);
        if (i3 == 4) {
            this.f66235i.setVisibility(8);
            this.H.setVisibility(8);
        } else {
            this.f66235i.setVisibility(0);
            this.H.setVisibility(0);
        }
        ObjectAnimator duration = ObjectAnimator.ofInt(this.f66235i, "progress", 0, 80).setDuration(3000L);
        this.M = duration;
        duration.start();
        ObjectAnimator.ofFloat(this.f66231d, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f).setDuration(500L).start();
        this.f66233f.api().postAction(new b());
        this.f66234h.api().postAction(new c(i3));
        if (i3 == 4) {
            this.I.setVisibility(0);
        } else {
            this.I.setVisibility(8);
        }
        d dVar = new d(10000L, 1000L, i3);
        this.N = dVar;
        dVar.start();
    }

    public void setFromQCircle(boolean z16) {
        this.P = z16;
    }

    public void setSceneText(String str, String str2, String str3) {
        this.L = str;
        TextView textView = this.C;
        if (textView != null) {
            textView.setText(str);
        }
        TextView textView2 = this.D;
        if (textView2 != null) {
            textView2.setText(str2);
        }
        TextView textView3 = this.E;
        if (textView3 != null) {
            textView3.setText(str3);
        }
    }

    public AEEditorLoadingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AEEditorLoadingView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.P = true;
        k(context);
    }

    private void l() {
        this.f66232e = (LinearLayout) findViewById(R.id.rwl);
        this.f66235i = (ProgressBar) findViewById(R.id.ryr);
        this.f66233f = (VasPagView) findViewById(R.id.s4y);
        this.f66234h = (VasPagView) findViewById(R.id.s4z);
        this.f66233f.api().build();
        this.f66234h.api().build();
        this.I = (TextView) findViewById(R.id.rxk);
        View findViewById = findViewById(R.id.s39);
        this.H = findViewById;
        findViewById.setOnClickListener(new a());
    }

    private void m() {
        this.f66236m = (RelativeLayout) findViewById(R.id.rzs);
        this.C = (TextView) findViewById(R.id.s2a);
        this.D = (TextView) findViewById(R.id.s2b);
        this.E = (TextView) findViewById(R.id.s2c);
        this.F = findViewById(R.id.rzm);
        this.G = findViewById(R.id.f163817s54);
        this.J = UIUtils.b(getContext(), 80.0f);
        this.K = UIUtils.b(getContext(), 7.0f);
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class d extends CountDownTimer {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f66241a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(long j3, long j16, int i3) {
            super(j3, j16);
            this.f66241a = i3;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            AEEditorLoadingView.this.j();
            if (this.f66241a == 4) {
                QQToast.makeText(BaseApplication.getContext(), R.string.y5a, 1).show();
            } else {
                QQToast.makeText(BaseApplication.getContext(), R.string.y4z, 1).show();
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j3) {
        }
    }

    public void setLoadingListener(e eVar) {
    }
}
