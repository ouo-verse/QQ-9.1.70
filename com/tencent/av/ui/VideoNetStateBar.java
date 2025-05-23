package com.tencent.av.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.m;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
public class VideoNetStateBar {

    /* renamed from: e, reason: collision with root package name */
    WeakReference<Context> f75304e;

    /* renamed from: f, reason: collision with root package name */
    VideoAppInterface f75305f;

    /* renamed from: g, reason: collision with root package name */
    WeakReference<ViewGroup> f75306g;

    /* renamed from: h, reason: collision with root package name */
    Resources f75307h;

    /* renamed from: u, reason: collision with root package name */
    boolean f75320u;

    /* renamed from: a, reason: collision with root package name */
    boolean f75300a = false;

    /* renamed from: b, reason: collision with root package name */
    boolean f75301b = false;

    /* renamed from: c, reason: collision with root package name */
    boolean f75302c = false;

    /* renamed from: d, reason: collision with root package name */
    boolean f75303d = false;

    /* renamed from: i, reason: collision with root package name */
    Runnable f75308i = null;

    /* renamed from: j, reason: collision with root package name */
    ImageView f75309j = null;

    /* renamed from: k, reason: collision with root package name */
    ImageView f75310k = null;

    /* renamed from: l, reason: collision with root package name */
    View f75311l = null;

    /* renamed from: m, reason: collision with root package name */
    ImageView f75312m = null;

    /* renamed from: n, reason: collision with root package name */
    TextView f75313n = null;

    /* renamed from: o, reason: collision with root package name */
    int f75314o = 0;

    /* renamed from: p, reason: collision with root package name */
    int f75315p = 0;

    /* renamed from: q, reason: collision with root package name */
    String f75316q = null;

    /* renamed from: r, reason: collision with root package name */
    String f75317r = null;

    /* renamed from: s, reason: collision with root package name */
    boolean f75318s = false;

    /* renamed from: t, reason: collision with root package name */
    long f75319t = -1;

    /* renamed from: v, reason: collision with root package name */
    GAudioUIObserver f75321v = new a();

    /* renamed from: w, reason: collision with root package name */
    private int f75322w = 0;

    /* renamed from: x, reason: collision with root package name */
    private boolean f75323x = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class GroupNetLevelRunnable implements Runnable {
        GroupNetLevelRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.tencent.av.r.h0() != null && !VideoNetStateBar.this.f75320u) {
                int a06 = com.tencent.av.r.h0().a0();
                VideoNetStateBar videoNetStateBar = VideoNetStateBar.this;
                videoNetStateBar.f75318s = true;
                if (a06 != 0 && a06 != 1) {
                    if (a06 != 2) {
                        if (a06 == 3) {
                            videoNetStateBar.f75315p = 1;
                        }
                    } else {
                        videoNetStateBar.f75315p = 2;
                    }
                } else {
                    videoNetStateBar.f75315p = 3;
                }
                videoNetStateBar.f75314o = 1;
                if (QLog.isColorLevel()) {
                    QLog.d("VideoNetStateBar", 2, String.format("getGAudioNetLevel[%s], mCurNetLevel[%s]", Integer.valueOf(a06), Integer.valueOf(VideoNetStateBar.this.f75315p)));
                }
                if (VideoNetStateBar.this.f75308i != null && com.tencent.av.r.h0() != null && !VideoNetStateBar.this.f75320u && com.tencent.av.r.h0().D() != null) {
                    com.tencent.av.r.h0().D().postDelayed(VideoNetStateBar.this.f75308i, 2000L);
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("VideoNetStateBar", 2, "VideoController.getInstance() == null");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a extends GAudioUIObserver {
        a() {
        }

        @Override // com.tencent.av.app.GAudioUIObserver
        protected void g(long j3, long j16) {
            if (QLog.isColorLevel()) {
                QLog.d("VideoNetStateBar", 2, "onCreateRoomSuc-->GroupID=" + j16);
            }
            VideoNetStateBar.this.h();
        }

        @Override // com.tencent.av.app.GAudioUIObserver
        protected void k(long j3, long j16) {
            if (QLog.isColorLevel()) {
                QLog.d("VideoNetStateBar", 2, "onEnterRoomSuc-->GroupID=" + j16);
            }
            VideoNetStateBar.this.h();
        }
    }

    public VideoNetStateBar(VideoAppInterface videoAppInterface, AVActivity aVActivity, ViewGroup viewGroup) {
        this.f75320u = false;
        if (QLog.isColorLevel()) {
            QLog.d("VideoNetStateBar", 2, "VideoNetStateBar");
        }
        this.f75304e = new WeakReference<>(aVActivity);
        this.f75305f = videoAppInterface;
        this.f75320u = false;
        this.f75306g = new WeakReference<>(viewGroup);
        this.f75307h = aVActivity.getResources();
    }

    boolean a() {
        SessionInfo f16;
        int i3;
        int i16;
        if (com.tencent.av.r.h0() != null && !this.f75320u && (f16 = com.tencent.av.n.e().f()) != null) {
            if (this.f75302c && ((i16 = f16.f73035i) == 1 || i16 == 2)) {
                ReportController.o(null, "CliOper", "", "", "0X8005966", "0X8005966", 0, 0, "", "", "", "");
                return true;
            }
            if (this.f75301b && ((i3 = f16.f73035i) == 3 || i3 == 4)) {
                ReportController.o(null, "CliOper", "", "", "0X8005966", "0X8005966", 0, 0, "", "", "", "");
                return true;
            }
        }
        return false;
    }

    public boolean b() {
        return this.f75318s;
    }

    void c() {
        SessionInfo f16;
        int i3;
        if (com.tencent.av.r.h0() != null && !this.f75320u && (f16 = com.tencent.av.n.e().f()) != null) {
            if (!f16.f73060o0 && (i3 = f16.f73035i) != 1 && i3 != 2) {
                if (i3 == 3 || i3 == 4) {
                    ReportController.o(null, "CliOper", "", "", "0X8005921", "0X8005921", 0, 0, "", "", "", "");
                    return;
                }
                return;
            }
            ReportController.o(null, "CliOper", "", "", "0X8005922", "0X8005922", 0, 0, "", "", "", "");
        }
    }

    void d() {
        WeakReference<ViewGroup> weakReference = this.f75306g;
        if (weakReference != null && weakReference.get() != null) {
            this.f75309j = (ImageView) this.f75306g.get().findViewById(m.p.f76090b);
            this.f75310k = (ImageView) this.f75306g.get().findViewById(m.n.f76084b);
            this.f75311l = this.f75306g.get().findViewById(m.o.f76086a);
            this.f75312m = (ImageView) this.f75306g.get().findViewById(m.o.f76087b);
            this.f75313n = (TextView) this.f75306g.get().findViewById(m.o.f76088c);
            n();
            if (com.tencent.av.utils.e.e(0) == 1) {
                this.f75311l.setBackgroundColor(-822034433);
            }
        }
    }

    public void e() {
        SessionInfo f16;
        GAudioUIObserver gAudioUIObserver;
        if (QLog.isColorLevel()) {
            QLog.d("VideoNetStateBar", 2, "onCreate");
        }
        w();
        this.f75300a = false;
        this.f75301b = false;
        this.f75302c = false;
        this.f75315p = 0;
        this.f75314o = 0;
        this.f75316q = null;
        this.f75317r = null;
        this.f75319t = -1L;
        d();
        VideoAppInterface videoAppInterface = this.f75305f;
        if (videoAppInterface != null && (gAudioUIObserver = this.f75321v) != null) {
            videoAppInterface.addObserver(gAudioUIObserver);
        }
        if (com.tencent.av.r.h0() != null && !this.f75320u && (f16 = com.tencent.av.n.e().f()) != null) {
            if (f16.f73036i0) {
                f16.f73036i0 = false;
                int i3 = f16.f73035i;
                if (i3 == 1 || i3 == 2 || i3 == 3 || i3 == 4) {
                    this.f75315p = f16.f73040j0;
                    this.f75314o = f16.f73044k0;
                }
            }
            this.f75301b = f16.K;
            this.f75302c = f16.L;
        }
        i("onCreate");
    }

    public void f() {
        GAudioUIObserver gAudioUIObserver;
        SessionInfo f16;
        if (QLog.isColorLevel()) {
            QLog.d("VideoNetStateBar", 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
        if (com.tencent.av.r.h0() != null && !this.f75320u && (f16 = com.tencent.av.n.e().f()) != null) {
            f16.f73044k0 = this.f75314o;
            f16.f73040j0 = this.f75315p;
            f16.f73036i0 = true;
        }
        VideoAppInterface videoAppInterface = this.f75305f;
        if (videoAppInterface != null && (gAudioUIObserver = this.f75321v) != null) {
            videoAppInterface.deleteObserver(gAudioUIObserver);
        }
        w();
        this.f75304e = null;
        this.f75305f = null;
        this.f75320u = true;
        this.f75307h = null;
        this.f75309j = null;
        this.f75310k = null;
        this.f75311l = null;
        this.f75312m = null;
        this.f75313n = null;
        this.f75321v = null;
        this.f75306g = null;
    }

    public void g() {
        if (QLog.isColorLevel()) {
            QLog.d("VideoNetStateBar", 2, "onDoubleConnected");
        }
        this.f75315p = 3;
        this.f75319t = System.currentTimeMillis();
        i("onDoubleConnected");
    }

    public void h() {
        if (QLog.isColorLevel()) {
            QLog.d("VideoNetStateBar", 2, "onMultiConnected");
        }
        this.f75315p = 3;
        i("onMultiConnected");
        x();
    }

    void i(String str) {
        int i3;
        String string;
        boolean z16;
        if (this.f75309j == null || this.f75310k == null || this.f75312m == null || this.f75307h == null || (i3 = this.f75315p) == 0) {
            return;
        }
        int i16 = this.f75314o;
        boolean z17 = true;
        if (!TextUtils.isEmpty(this.f75316q)) {
            string = this.f75316q;
        } else if (i3 != 1) {
            if (i3 != 2) {
                if (i16 == 2) {
                    string = this.f75307h.getString(R.string.dgg);
                } else if (i16 == 1) {
                    string = this.f75307h.getString(R.string.dgj);
                } else {
                    string = this.f75307h.getString(R.string.dgc);
                }
            } else if (i16 == 2) {
                string = this.f75307h.getString(R.string.dgh);
            } else if (i16 == 1) {
                string = this.f75307h.getString(R.string.dgk);
            } else {
                string = this.f75307h.getString(R.string.dge);
            }
        } else if (i16 == 2) {
            string = this.f75307h.getString(R.string.dgf);
        } else if (i16 == 1) {
            string = this.f75307h.getString(R.string.dgi);
        } else {
            string = this.f75307h.getString(R.string.dgb);
        }
        o();
        if (this.f75303d) {
            string = this.f75307h.getString(R.string.dgd);
            this.f75309j.setImageResource(R.drawable.dd_);
            this.f75312m.setImageResource(R.drawable.dd_);
            this.f75310k.setImageResource(R.drawable.dd_);
        } else if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    this.f75309j.setImageResource(R.drawable.dd6);
                    this.f75312m.setImageResource(R.drawable.dd6);
                    this.f75310k.setImageResource(R.drawable.dd6);
                } else {
                    this.f75309j.setImageResource(R.drawable.dd6);
                    this.f75312m.setImageResource(R.drawable.dd6);
                    this.f75310k.setImageResource(R.drawable.dd6);
                }
            } else {
                this.f75309j.setImageResource(R.drawable.dd8);
                this.f75312m.setImageResource(R.drawable.dd8);
                this.f75310k.setImageResource(R.drawable.dd8);
            }
        } else {
            this.f75309j.setImageResource(R.drawable.f161374dd4);
            this.f75312m.setImageResource(R.drawable.f161374dd4);
            this.f75310k.setImageResource(R.drawable.f161374dd4);
        }
        if (i3 == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.f75317r = null;
        if (!this.f75303d && !z16) {
            cw.e.d(this.f75305f, 3001);
        } else {
            if (System.currentTimeMillis() - this.f75319t <= 3000 && !this.f75303d) {
                z17 = false;
            }
            if (z17) {
                cw.e.p(this.f75305f, 3001, string);
            }
        }
        if (this.f75300a) {
            if (!this.f75303d && !z16) {
                View view = this.f75311l;
                if (view != null) {
                    view.setVisibility(8);
                }
            } else {
                View view2 = this.f75311l;
                if (view2 != null) {
                    view2.setVisibility(0);
                }
                c();
            }
        } else {
            View view3 = this.f75311l;
            if (view3 != null) {
                view3.setVisibility(8);
            }
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("VideoNetStateBar", 4, "refreshNetLevelTextAndIcon, from[" + str + "], noNet[" + this.f75303d + "], bShowNetIcon[" + z16 + "]");
        }
    }

    public void j(String str) {
        TextView textView = this.f75313n;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void k(boolean z16) {
        if (this.f75300a != z16) {
            this.f75300a = z16;
            i("setImmersiveFlag");
        }
    }

    public void l() {
        ImageView imageView = this.f75310k;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    public void m(int i3, int i16, int i17, String str) {
        int i18 = 3;
        boolean z16 = true;
        if (QLog.isDevelopLevel()) {
            QLog.d("VideoNetStateBar", 4, String.format("setNetLevel, emNetLevel[%s], selfNetLevel[%s], peerNetLevel[%s], strDetail[%s]", Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), str));
        }
        if (i16 != i17) {
            if (i16 > 0) {
                i18 = 1;
            } else if (i17 > 0) {
                i18 = 2;
            } else {
                i18 = 0;
            }
        }
        if (this.f75315p == i3 && i18 == this.f75314o && TextUtils.equals(this.f75316q, str)) {
            z16 = false;
        } else {
            this.f75315p = i3;
            this.f75314o = i18;
            this.f75316q = str;
        }
        if (z16) {
            i("setNetLevel");
        }
    }

    void n() {
        ImageView imageView = this.f75312m;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    void o() {
        ImageView imageView = this.f75309j;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    public void p(boolean z16) {
        this.f75303d = z16;
        i("setNoNetworkFlag");
    }

    public void q(boolean z16) {
        this.f75302c = z16;
        if (z16) {
            a();
        }
        i("setPeerCloseMICFlag");
    }

    public void r(boolean z16) {
        this.f75301b = z16;
        if (z16) {
            a();
        }
        i("setSelfCloseMICFlag");
    }

    public void s(boolean z16) {
        View findViewById;
        boolean z17 = false;
        if (z16) {
            if (this.f75306g.get() == null) {
                findViewById = null;
            } else {
                findViewById = this.f75306g.get().findViewById(R.id.f166584gb1);
            }
            if (findViewById != null) {
                z17 = true;
            }
            this.f75323x = z17;
            return;
        }
        this.f75323x = false;
    }

    public void t(int i3) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        View view = this.f75311l;
        if (view == null || (marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams()) == null) {
            return;
        }
        marginLayoutParams.topMargin = i3;
        this.f75311l.setLayoutParams(marginLayoutParams);
    }

    public void u(int i3) {
        Context context;
        ViewGroup.LayoutParams layoutParams;
        if (!this.f75323x || i3 == this.f75322w || this.f75311l == null) {
            return;
        }
        WeakReference<Context> weakReference = this.f75304e;
        View view = null;
        if (weakReference == null) {
            context = null;
        } else {
            context = weakReference.get();
        }
        if (context == null) {
            return;
        }
        if (this.f75306g.get() != null) {
            view = this.f75306g.get().findViewById(R.id.f166584gb1);
        }
        if (view == null || (layoutParams = this.f75311l.getLayoutParams()) == null) {
            return;
        }
        this.f75322w = i3;
        if (i3 != 90 && i3 != 270) {
            layoutParams.width = -2;
            layoutParams.height = -2;
            this.f75311l.setLayoutParams(layoutParams);
            this.f75311l.setRotation(0.0f);
            if (this.f75322w == 0) {
                view.setScaleY(1.0f);
                view.setScaleX(1.0f);
                return;
            } else {
                view.setScaleY(-1.0f);
                view.setScaleX(-1.0f);
                return;
            }
        }
        int dimensionPixelSize = context.getResources().getDisplayMetrics().widthPixels - context.getResources().getDimensionPixelSize(R.dimen.a7m);
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = dimensionPixelSize;
        this.f75311l.setLayoutParams(layoutParams);
        this.f75311l.setRotation(90.0f);
        if (this.f75322w == 270) {
            view.setScaleY(1.0f);
            view.setScaleX(1.0f);
        } else {
            view.setScaleY(-1.0f);
            view.setScaleX(-1.0f);
        }
    }

    void v() {
        if (this.f75305f == null) {
            return;
        }
        if (this.f75308i == null) {
            this.f75308i = new GroupNetLevelRunnable();
        }
        if (this.f75308i != null && com.tencent.av.r.h0() != null && !this.f75320u && com.tencent.av.r.h0().D() != null) {
            com.tencent.av.r.h0().D().removeCallbacks(this.f75308i);
            com.tencent.av.r.h0().D().postDelayed(this.f75308i, 2000L);
        }
    }

    void w() {
        if (this.f75305f == null) {
            return;
        }
        if (this.f75308i != null && com.tencent.av.r.h0() != null && !this.f75320u && com.tencent.av.r.h0().D() != null) {
            com.tencent.av.r.h0().D().removeCallbacks(this.f75308i);
        }
        this.f75308i = null;
        this.f75318s = false;
    }

    void x() {
        SessionInfo f16;
        if (com.tencent.av.r.h0() != null && !this.f75320u && (f16 = com.tencent.av.n.e().f()) != null) {
            int i3 = f16.f73035i;
            if (i3 == 3 || i3 == 4) {
                v();
            }
        }
    }
}
