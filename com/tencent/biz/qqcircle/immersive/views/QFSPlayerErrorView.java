package com.tencent.biz.qqcircle.immersive.views;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.immersive.manager.d;
import com.tencent.biz.qqcircle.widgets.QFSPagAnimView;
import com.tencent.biz.richframework.download.RFWDownloaderFactory;
import com.tencent.biz.richframework.video.rfw.player.RFWPlayerOptions;
import com.tencent.biz.richframework.video.rfw.player.monitor.RFWPlayerMonitor;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.thread.RFWThreadManager;
import common.config.service.QzoneConfig;
import java.io.File;
import java.lang.ref.WeakReference;

/* loaded from: classes4.dex */
public class QFSPlayerErrorView extends FrameLayout {
    private View C;
    private View D;
    private QFSPagAnimView E;
    private String F;
    private QFSCheckAnimLoadingTask G;
    private a H;
    private long I;

    /* renamed from: d, reason: collision with root package name */
    private View f90423d;

    /* renamed from: e, reason: collision with root package name */
    private View f90424e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f90425f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f90426h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f90427i;

    /* renamed from: m, reason: collision with root package name */
    private View f90428m;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class QFSCheckAnimLoadingTask implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<QFSPlayerErrorView> f90429d;

        /* renamed from: e, reason: collision with root package name */
        private String f90430e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f90431f;

        public QFSCheckAnimLoadingTask(QFSPlayerErrorView qFSPlayerErrorView, String str, boolean z16) {
            this.f90429d = new WeakReference<>(qFSPlayerErrorView);
            this.f90430e = str;
            this.f90431f = z16;
        }

        @Override // java.lang.Runnable
        public void run() {
            QFSPlayerErrorView qFSPlayerErrorView;
            WeakReference<QFSPlayerErrorView> weakReference = this.f90429d;
            if (weakReference == null) {
                qFSPlayerErrorView = null;
            } else {
                qFSPlayerErrorView = weakReference.get();
            }
            if (qFSPlayerErrorView == null) {
                return;
            }
            qFSPlayerErrorView.E(this.f90430e, this.f90431f, new File(RFWDownloaderFactory.getDownloader(vq3.a.a()).getDefaultSavePath(this.f90430e)).exists());
        }
    }

    /* loaded from: classes4.dex */
    public interface a {
        void a();

        void b();
    }

    public QFSPlayerErrorView(@NonNull Context context) {
        super(context);
        this.I = -1L;
        k();
    }

    private void A(int i3) {
        String str;
        try {
            str = String.format(getResources().getString(R.string.f193694_w), Integer.valueOf(i3));
        } catch (Resources.NotFoundException e16) {
            QLog.e(f(), 1, "[updateErrorMsgToView] error: ", e16);
            str = "Error Code(" + i3 + ")";
        }
        TextView textView = this.f90426h;
        if (textView != null) {
            textView.setText(str);
        }
    }

    private void B() {
        w(this.f90423d, false);
        w(this.f90424e, false);
        w(this.D, false);
    }

    private void C() {
        w(this.f90423d, true);
        w(this.f90424e, false);
        w(this.D, true);
        x(true);
    }

    private void D(int i3) {
        A(i3);
        w(this.f90423d, true);
        w(this.f90424e, true);
        w(this.D, false);
        r(this.f90425f, R.drawable.qvideo_skin_emptystate_img_offline);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(String str, boolean z16, boolean z17) {
        if (!z17) {
            r(this.E, R.drawable.nqb);
            return;
        }
        this.E.setBackground(null);
        if (z16) {
            this.E.M(str);
        } else {
            this.E.L();
        }
    }

    private void F(int i3, int i16) {
        if (!l()) {
            QLog.d(f(), 2, "[updatePlayerErrorViewStatus] current status: " + i3 + ", errorCode: " + i16);
            return;
        }
        if (i3 == 1) {
            B();
        } else if (i3 == 2) {
            D(i16);
        } else if (i3 == 3) {
            C();
        }
        QLog.e(f(), 1, "[updatePlayerErrorViewStatus] status: " + i3 + " | errorCode: " + i16 + " | hashcode: " + hashCode());
    }

    private void d() {
        this.f90428m.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.views.aa
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QFSPlayerErrorView.this.p(view);
            }
        });
        this.C.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.views.ab
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QFSPlayerErrorView.this.q(view);
            }
        });
    }

    private String e() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qcircle_player_error_feedback_url", "https://ti.qq.com/tucao/index.html?productId=342658&_wv=2");
    }

    private String f() {
        return "PEV-QFSPlayerErrorView_" + this.F;
    }

    private void g() {
        QLog.d(f(), 1, "[handleErrorReplay] handle error replay...");
        F(3, -1);
        s();
    }

    private void h() {
        String e16 = e();
        QLog.d(f(), 1, "[handleFeedBackCallback] player error, feedback commit, url: " + e16);
        com.tencent.biz.qqcircle.launcher.c.o0(getContext(), e16, null, -1);
        t();
    }

    private void k() {
        LayoutInflater.from(getContext()).inflate(R.layout.gng, (ViewGroup) this, true);
        this.f90423d = findViewById(R.id.f4921223);
        this.f90424e = findViewById(R.id.f491621y);
        this.f90426h = (TextView) findViewById(R.id.f491721z);
        this.f90427i = (TextView) findViewById(R.id.f4922224);
        this.f90428m = findViewById(R.id.f491421w);
        this.C = findViewById(R.id.f4919221);
        this.f90425f = (ImageView) findViewById(R.id.f491521x);
        this.D = findViewById(R.id.f4920222);
        QFSPagAnimView qFSPagAnimView = (QFSPagAnimView) findViewById(R.id.f4918220);
        this.E = qFSPagAnimView;
        qFSPagAnimView.setResUrl("https://downv6.qq.com/video_story/qcircle/loading/editor_loading_img_wezone.pag");
        w(this.f90428m, n());
        d();
    }

    private boolean l() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qcircle_player_error_display_enabled", 1) == 1) {
            return true;
        }
        return false;
    }

    private boolean m() {
        View view = this.f90423d;
        if (view != null && view.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    private boolean n() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qcircle_player_error_feedback_visible", 0) != 1) {
            return false;
        }
        return true;
    }

    private boolean o() {
        View view = this.D;
        if (view != null && view.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        h();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        g();
        EventCollector.getInstance().onViewClicked(view);
    }

    private void r(View view, int i3) {
        if (this.f90425f == null) {
            QLog.e(f(), 1, "[loadLocalResDrawable] error info cover should not be null.");
            return;
        }
        d.b bVar = new d.b();
        bVar.f(i3);
        bVar.j(view);
        bVar.i(true);
        com.tencent.biz.qqcircle.immersive.manager.d.c().h(bVar);
    }

    private void s() {
        a aVar = this.H;
        if (aVar == null) {
            return;
        }
        aVar.b();
    }

    private void t() {
        a aVar = this.H;
        if (aVar == null) {
            return;
        }
        aVar.a();
    }

    private void u() {
        if (!uq3.c.A0()) {
            return;
        }
        RFWPlayerMonitor.g().upgradeLogLevel(true);
    }

    private void w(View view, boolean z16) {
        int i3;
        if (view == null) {
            return;
        }
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        view.setVisibility(i3);
    }

    private void x(boolean z16) {
        if (this.E == null || !o()) {
            return;
        }
        this.E.setVisibility(0);
        this.G = new QFSCheckAnimLoadingTask(this, "https://downv6.qq.com/video_story/qcircle/loading/editor_loading_img_wezone.pag", z16);
        RFWThreadManager.getInstance().execOnFileThread(this.G);
    }

    private void y() {
        if (this.E == null || !o()) {
            return;
        }
        this.E.setVisibility(8);
        this.E.V();
    }

    private void z(int i3, int i16) {
        ImageView imageView = this.f90425f;
        if (imageView == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        if (!(layoutParams instanceof LinearLayout.LayoutParams)) {
            QLog.d(f(), 1, "[updateErrorCoverParam] params should not linear layout param.");
            return;
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        layoutParams2.width = i3;
        layoutParams2.height = i16;
        this.f90425f.setLayoutParams(layoutParams2);
    }

    public void G(boolean z16) {
        float dimension;
        float dimension2;
        if (z16) {
            dimension = getContext().getResources().getDimension(R.dimen.d48);
            dimension2 = getContext().getResources().getDimension(R.dimen.d47);
        } else {
            dimension = getContext().getResources().getDimension(R.dimen.d46);
            dimension2 = getContext().getResources().getDimension(R.dimen.f159416d45);
        }
        QLog.d(f(), 1, "[updateScreenConfigChange] width: " + dimension + " | height: " + dimension2 + " | isVertical: " + z16);
        z(Math.round(dimension), Math.round(dimension2));
    }

    public void i(RFWPlayerOptions rFWPlayerOptions, int i3, int i16, int i17, String str) {
        if (rFWPlayerOptions == null) {
            QLog.d(f(), 1, "[handlePlayerError] options should not be null.");
            return;
        }
        this.F = rFWPlayerOptions.tag();
        QLog.d(f(), 1, "[handlePlayerError] module: " + i3 + ", errorType: " + i16 + ", errorCode: " + i17 + ", extraInfo: " + str);
        F(2, i17);
        u();
    }

    public void j(long j3, long j16) {
        if (!m() || this.I == j16) {
            return;
        }
        QLog.d(f(), 1, "[handlePlayerProgress] duration: " + j3 + " | progress: " + j16 + " | mCurrentProgress: " + this.I + ", restore play.");
        F(1, -1);
        this.I = j16;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        x(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        y();
    }

    public void setOnPlayerErrorReplayListener(a aVar) {
        this.H = aVar;
    }

    public void v() {
        F(1, -1);
    }

    public QFSPlayerErrorView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.I = -1L;
        k();
    }

    public QFSPlayerErrorView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.I = -1L;
        k();
    }
}
