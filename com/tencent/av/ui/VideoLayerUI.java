package com.tencent.av.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.widget.ExploreByTouchHelper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.ImageView;
import com.tencent.aelight.camera.api.IWinkZShowViewForOnlineStatusProvider;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.camera.api.ICameraManagerApi;
import com.tencent.av.gaudio.AVPhoneUserInfo;
import com.tencent.av.opengl.texture.YUVTexture;
import com.tencent.av.opengl.ui.GLRootView;
import com.tencent.av.opengl.ui.b;
import com.tencent.av.p;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.av.utils.VideoUtil;
import com.tencent.av.utils.ba;
import com.tencent.avcore.jni.NtrtcVideoRender;
import com.tencent.avcore.jni.NtrtcVideoRenderTexture;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.filament.zplan.view.AVFilamentTextureView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ea;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.util.LogUtil;
import nv.b;
import org.slf4j.Marker;
import sv.a;

/* compiled from: P */
/* loaded from: classes3.dex */
public class VideoLayerUI extends VideoLayerUIBase {
    private final boolean E0;
    public GestureDetector F0;
    public int G0;
    public int H0;
    public int I0;
    public int J0;
    protected MultiVideoOpenAnimation K0;
    int L0;
    boolean M0;
    VideoUtil.AnimationTrigger N0;
    long O0;
    private b.a P0;
    private nv.b Q0;
    private ScaleGestureDetector R0;
    private int S0;
    private int T0;
    private volatile boolean U0;
    private Rect V0;
    private Rect W0;
    private ArrayList<com.tencent.av.opengl.ui.b> X0;
    private int Y0;
    private int Z0;

    /* renamed from: a1, reason: collision with root package name */
    private boolean f75196a1;

    /* renamed from: b1, reason: collision with root package name */
    private int f75197b1;

    /* renamed from: c1, reason: collision with root package name */
    private int f75198c1;

    /* renamed from: d1, reason: collision with root package name */
    private int f75199d1;

    /* renamed from: e1, reason: collision with root package name */
    private volatile int f75200e1;

    /* renamed from: f1, reason: collision with root package name */
    private GestureDetector f75201f1;

    /* renamed from: g1, reason: collision with root package name */
    private com.tencent.av.opengl.ui.f f75202g1;

    /* renamed from: h1, reason: collision with root package name */
    private boolean f75203h1;

    /* renamed from: i1, reason: collision with root package name */
    private boolean f75204i1;

    /* renamed from: j1, reason: collision with root package name */
    private DisplayMetrics f75205j1;

    /* renamed from: k1, reason: collision with root package name */
    private long f75206k1;

    /* renamed from: l1, reason: collision with root package name */
    private int f75207l1;

    /* renamed from: m1, reason: collision with root package name */
    private an f75208m1;

    /* renamed from: n1, reason: collision with root package name */
    private ak f75209n1;

    /* renamed from: o1, reason: collision with root package name */
    private ConcurrentHashMap<Long, am> f75210o1;

    /* renamed from: p1, reason: collision with root package name */
    private boolean f75211p1;

    /* renamed from: q1, reason: collision with root package name */
    private int f75212q1;

    /* renamed from: r1, reason: collision with root package name */
    private int f75213r1;

    /* renamed from: s1, reason: collision with root package name */
    private p.a f75214s1;

    /* renamed from: t1, reason: collision with root package name */
    private long f75215t1;

    /* renamed from: u1, reason: collision with root package name */
    private l f75216u1;

    /* renamed from: v1, reason: collision with root package name */
    private f f75217v1;

    /* renamed from: w1, reason: collision with root package name */
    private i f75218w1;

    /* renamed from: x1, reason: collision with root package name */
    protected int f75219x1;

    /* renamed from: y1, reason: collision with root package name */
    private int f75220y1;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class FilamentSmallScreenMoveAnimation implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private Rect f75225d = new Rect();

        /* renamed from: e, reason: collision with root package name */
        private Rect f75226e = new Rect();

        /* renamed from: f, reason: collision with root package name */
        private int f75227f = 0;

        protected FilamentSmallScreenMoveAnimation(Rect rect, Rect rect2) {
            this.f75225d.set(rect);
            this.f75226e.set(rect2);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (VideoLayerUI.this.f75217v1 == null) {
                return;
            }
            if (this.f75227f >= 10) {
                VideoLayerUI.this.f75217v1.C = false;
                return;
            }
            if (VideoLayerUI.this.M0()) {
                VideoLayerUI.this.f75217v1.C = false;
                return;
            }
            if (com.tencent.av.r.h0() == null || VideoLayerUI.this.W == null || com.tencent.av.r.h0().J0() == null || VideoLayerUI.this.Y == null) {
                VideoLayerUI.this.f75217v1.C = false;
                return;
            }
            ax.j J0 = com.tencent.av.r.h0().J0();
            int i3 = this.f75227f + 1;
            this.f75227f = i3;
            int i16 = 10 - i3;
            Rect rect = this.f75225d;
            int i17 = rect.left * i16;
            Rect rect2 = this.f75226e;
            int i18 = (i17 + (rect2.left * i3)) / 10;
            int i19 = ((rect.right * i16) + (rect2.right * i3)) / 10;
            int i26 = ((rect.top * i16) + (rect2.top * i3)) / 10;
            int i27 = ((rect.bottom * i16) + (rect2.bottom * i3)) / 10;
            int height = VideoLayerUI.this.W.getHeight();
            VideoLayerUI.this.Y.set(i18, i26, i19, i27);
            J0.p0(VideoLayerUI.this.Y.width(), VideoLayerUI.this.Y.height(), i18, height - i27);
            VideoAppInterface videoAppInterface = VideoLayerUI.this.R;
            if (videoAppInterface != null) {
                videoAppInterface.M().postDelayed(this, 20L);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class MultiVideoOpenAnimation implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private int f75228d;

        /* renamed from: e, reason: collision with root package name */
        private int f75229e = 0;

        /* renamed from: f, reason: collision with root package name */
        private float f75230f;

        public MultiVideoOpenAnimation(int i3) {
            this.f75228d = i3;
            GLVideoView gLVideoView = VideoLayerUI.this.f75271c0[i3];
            Rect f16 = gLVideoView.f();
            this.f75230f = f16.width() / 10.0f;
            int i16 = f16.right;
            gLVideoView.q(i16, f16.top, f16.width() + i16, f16.bottom);
            gLVideoView.p();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f75229e == 9) {
                VideoLayerUI.this.T0(false);
            } else {
                GLVideoView gLVideoView = VideoLayerUI.this.f75271c0[this.f75228d];
                Rect f16 = gLVideoView.f();
                int i3 = (int) (f16.left - this.f75230f);
                gLVideoView.q(i3, f16.top, f16.width() + i3, f16.bottom);
                gLVideoView.p();
            }
            int i16 = this.f75229e + 1;
            this.f75229e = i16;
            if (i16 <= 9) {
                VideoLayerUI.this.R.M().postDelayed(this, 30L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class a implements a.InterfaceC11254a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ GLVideoView f75231a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f75232b;

        a(GLVideoView gLVideoView, boolean z16) {
            this.f75231a = gLVideoView;
            this.f75232b = z16;
        }

        @Override // sv.a.InterfaceC11254a
        public void onAnimationEnd() {
            this.f75231a.c1(true);
            this.f75231a.m1(-1044L, this.f75232b);
            VideoLayerUI.this.Q1(this.f75231a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class b implements a.InterfaceC11254a {
        b() {
        }

        @Override // sv.a.InterfaceC11254a
        public void onAnimationEnd() {
            com.tencent.av.utils.c.a("switch_camera", "onAnimationEnd", 2, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class c implements p.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f75235a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f75236b;

        c(int i3, boolean z16) {
            this.f75235a = i3;
            this.f75236b = z16;
        }

        @Override // com.tencent.av.p.a
        public void a() {
            GLVideoView[] gLVideoViewArr = VideoLayerUI.this.f75271c0;
            if (gLVideoViewArr != null && gLVideoViewArr.length > this.f75235a) {
                com.tencent.av.utils.c.a("switch_camera", "onSwitchCameraFirstFrame", 3, new Object[0]);
                VideoLayerUI videoLayerUI = VideoLayerUI.this;
                videoLayerUI.P1(videoLayerUI.f75271c0[this.f75235a], this.f75236b);
            } else if (QLog.isColorLevel()) {
                QLog.d(VideoLayerUI.this.N, 2, "onSwitchCameraFirstFrame Error : Index = " + this.f75235a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class d implements a.InterfaceC11254a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f75238a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f75239b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f75240c;

        d(int i3, int i16, int i17) {
            this.f75238a = i3;
            this.f75239b = i16;
            this.f75240c = i17;
        }

        @Override // sv.a.InterfaceC11254a
        public void onAnimationEnd() {
            VideoLayerUI.this.f75271c0[this.f75238a].S(this.f75239b);
            VideoLayerUI.this.f75271c0[this.f75238a].e1(Boolean.TRUE);
            VideoLayerUI.this.f75215t1 = 0L;
            VideoLayerUI.this.m1(this.f75240c, this.f75238a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class e implements a.InterfaceC11254a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f75242a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f75243b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f75244c;

        e(int i3, int i16, int i17) {
            this.f75242a = i3;
            this.f75243b = i16;
            this.f75244c = i17;
        }

        @Override // sv.a.InterfaceC11254a
        public void onAnimationEnd() {
            VideoLayerUI.this.f75271c0[this.f75242a].S(this.f75243b);
            VideoLayerUI.this.f75215t1 = 0L;
            VideoLayerUI.this.m1(this.f75244c, this.f75242a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private class f implements View.OnTouchListener {

        /* renamed from: d, reason: collision with root package name */
        private int f75246d = -1;

        /* renamed from: e, reason: collision with root package name */
        private int f75247e = -1;

        /* renamed from: f, reason: collision with root package name */
        private int f75248f = -1;

        /* renamed from: h, reason: collision with root package name */
        private int f75249h = -1;

        /* renamed from: i, reason: collision with root package name */
        private boolean f75250i = false;

        /* renamed from: m, reason: collision with root package name */
        private boolean f75251m = false;
        private boolean C = false;
        private int D = 0;

        f() {
        }

        private void b() {
            if (com.tencent.av.r.h0() != null && com.tencent.av.r.h0().J0() != null && !VideoLayerUI.this.M0()) {
                VideoLayerUI.this.Z = !r0.Z;
                com.tencent.av.r.h0().J0().m0(VideoLayerUI.this.Z);
            }
        }

        private boolean c(MotionEvent motionEvent) {
            if (!this.f75250i) {
                return false;
            }
            long eventTime = motionEvent.getEventTime() - motionEvent.getDownTime();
            if (this.f75251m && eventTime <= 100) {
                b();
            }
            g(motionEvent);
            f();
            return true;
        }

        private boolean d(MotionEvent motionEvent) {
            ax.j J0;
            int i3 = 0;
            if (!this.f75250i || com.tencent.av.r.h0() == null || VideoLayerUI.this.M0() || (J0 = com.tencent.av.r.h0().J0()) == null) {
                return false;
            }
            int x16 = (int) motionEvent.getX();
            int y16 = (int) motionEvent.getY();
            int i16 = x16 - this.f75246d;
            int i17 = y16 - this.f75247e;
            this.f75246d = x16;
            this.f75247e = y16;
            int width = VideoLayerUI.this.Y.width();
            int height = VideoLayerUI.this.Y.height();
            int width2 = VideoLayerUI.this.W.getWidth();
            int height2 = VideoLayerUI.this.W.getHeight();
            if (this.f75251m) {
                int i18 = this.f75248f;
                int i19 = (x16 - i18) * (x16 - i18);
                int i26 = this.f75249h;
                if (i19 + ((y16 - i26) * y16 * i26) > 64) {
                    this.f75251m = false;
                }
            }
            Rect rect = VideoLayerUI.this.Y;
            int i27 = rect.left + i16;
            int i28 = rect.top + i17;
            int i29 = i27 + width;
            int i36 = i28 + height;
            if (i27 < 0) {
                i29 = width + 0;
                i27 = 0;
            }
            if (i29 > width2) {
                i27 = width2 - width;
            } else {
                width2 = i29;
            }
            if (i28 < 0) {
                i36 = height + 0;
            } else {
                i3 = i28;
            }
            if (i36 > height2) {
                i3 = height2 - height;
                i36 = height2;
            }
            rect.set(i27, i3, width2, i36);
            J0.p0(width, height, i27, height2 - i36);
            return true;
        }

        private boolean e(MotionEvent motionEvent) {
            SessionInfo f16;
            this.f75250i = false;
            if (this.C || VideoLayerUI.this.N0() || com.tencent.av.r.h0() == null || VideoLayerUI.this.M0() || (f16 = com.tencent.av.n.e().f()) == null || !f16.f73098x2 || !f16.f73102y2 || VideoLayerUI.this.Y == null) {
                return false;
            }
            int x16 = (int) motionEvent.getX();
            int y16 = (int) motionEvent.getY();
            if (!VideoLayerUI.this.Y.contains(x16, y16)) {
                return false;
            }
            this.f75250i = true;
            this.f75246d = x16;
            this.f75247e = y16;
            this.f75248f = x16;
            this.f75249h = y16;
            this.f75251m = true;
            VideoLayerUI videoLayerUI = VideoLayerUI.this;
            this.D = com.tencent.av.zplan.avatar.utils.b.b(videoLayerUI.Y, videoLayerUI.W.getWidth(), VideoLayerUI.this.W.getHeight());
            return true;
        }

        private void f() {
            this.f75250i = false;
            this.f75251m = false;
            this.f75246d = -1;
            this.f75248f = -1;
            this.f75249h = -1;
            this.f75247e = -1;
        }

        private void g(MotionEvent motionEvent) {
            VideoLayerUI videoLayerUI = VideoLayerUI.this;
            if (videoLayerUI.Y != null && videoLayerUI.W != null) {
                int x16 = (int) motionEvent.getX();
                int y16 = (int) motionEvent.getY();
                int width = VideoLayerUI.this.W.getWidth();
                int height = VideoLayerUI.this.W.getHeight();
                int A0 = VideoLayerUI.this.A0(this.D, com.tencent.av.zplan.avatar.utils.b.b(VideoLayerUI.this.Y, width, height), this.f75248f, this.f75249h, x16, y16);
                Rect rect = new Rect();
                com.tencent.av.zplan.avatar.utils.b.c(VideoLayerUI.this.Q.getResources(), A0, width, height, rect);
                if (rect.equals(VideoLayerUI.this.Y)) {
                    return;
                }
                VideoLayerUI videoLayerUI2 = VideoLayerUI.this;
                if (videoLayerUI2.R != null) {
                    this.C = true;
                    VideoLayerUI.this.R.M().post(new FilamentSmallScreenMoveAnimation(videoLayerUI2.Y, rect));
                }
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action != 2) {
                        if (action != 3) {
                            f();
                            return false;
                        }
                    } else {
                        return d(motionEvent);
                    }
                }
                return c(motionEvent);
            }
            return e(motionEvent);
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class g extends GestureDetector.SimpleOnGestureListener {
        public g() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            VideoLayerUI videoLayerUI;
            int i3;
            VideoLayerUI videoLayerUI2 = VideoLayerUI.this;
            if (videoLayerUI2.f75274f0 == 0 && ((videoLayerUI2.U == 0 || videoLayerUI2.T == 0) && 2 == videoLayerUI2.f75271c0[0].H0() && !VideoLayerUIBase.R0(com.tencent.av.n.e().f()))) {
                int x16 = (int) motionEvent.getX();
                int y16 = (int) motionEvent.getY();
                float B0 = VideoLayerUI.this.f75271c0[0].B0();
                VideoLayerUI videoLayerUI3 = VideoLayerUI.this;
                int i16 = videoLayerUI3.f75273e0 + 1;
                videoLayerUI3.f75273e0 = i16;
                if (i16 % 2 == 1) {
                    VideoLayerUI.this.f75271c0[0].p1(videoLayerUI3.f75271c0[0].y0() / B0, x16, y16);
                } else {
                    float z06 = videoLayerUI3.f75271c0[0].z0() / B0;
                    int n3 = VideoLayerUI.this.f75271c0[0].n() / 2;
                    int h16 = VideoLayerUI.this.f75271c0[0].h() / 2;
                    VideoLayerUI.this.f75271c0[0].p1(z06, n3, h16);
                    VideoLayerUI.this.f75271c0[0].A1(n3, h16, true);
                }
                return true;
            }
            x xVar = VideoLayerUI.this.f75276h0;
            if (xVar != null && xVar.c() == 3) {
                if (QLog.isColorLevel()) {
                    String str = VideoLayerUI.this.N;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("GestureListener-->onDoubleTap in STYLE_MULTI_GRID_SCREEN  Index=");
                    sb5.append(VideoLayerUI.this.f75274f0);
                    sb5.append(",visibility:=");
                    VideoLayerUI videoLayerUI4 = VideoLayerUI.this;
                    sb5.append(videoLayerUI4.f75271c0[Math.max(videoLayerUI4.f75274f0, 0)].m());
                    QLog.d(str, 2, sb5.toString());
                }
                if (VideoLayerUI.this.S1() && (i3 = (videoLayerUI = VideoLayerUI.this).f75274f0) != -1) {
                    GLVideoView[] gLVideoViewArr = videoLayerUI.f75271c0;
                    if (i3 < gLVideoViewArr.length && gLVideoViewArr[i3].m() != 1 && com.tencent.av.n.e().f().f73045k1.size() > 0) {
                        VideoLayerUI videoLayerUI5 = VideoLayerUI.this;
                        int i17 = videoLayerUI5.f75274f0;
                        if (i17 != 0) {
                            long parseLong = Long.parseLong(videoLayerUI5.f75271c0[i17].G0());
                            VideoLayerUI videoLayerUI6 = VideoLayerUI.this;
                            int H0 = videoLayerUI6.f75271c0[videoLayerUI6.f75274f0].H0();
                            com.tencent.av.gaudio.c cVar = com.tencent.av.n.e().f().f73045k1.get(0);
                            int i18 = 0;
                            while (true) {
                                if (i18 >= com.tencent.av.n.e().f().f73045k1.size()) {
                                    break;
                                }
                                com.tencent.av.gaudio.c cVar2 = com.tencent.av.n.e().f().f73045k1.get(i18);
                                if (parseLong == cVar2.f73827a && H0 == cVar2.f73828b) {
                                    cVar.f73829c = false;
                                    cVar2.f73829c = true;
                                    com.tencent.av.n.e().f().f73045k1.set(0, cVar2);
                                    com.tencent.av.n.e().f().f73045k1.set(i18, cVar);
                                    synchronized (com.tencent.av.n.e().f().f73053m1) {
                                        com.tencent.av.n.e().f().f73053m1.set(0, cVar2);
                                        com.tencent.av.n.e().f().f73053m1.set(i18, cVar);
                                        com.tencent.av.n.e().f().S();
                                    }
                                    break;
                                }
                                i18++;
                            }
                            VideoLayerUI videoLayerUI7 = VideoLayerUI.this;
                            videoLayerUI7.l1("onDoubleTap", 0, videoLayerUI7.f75274f0);
                        } else if (com.tencent.av.n.e().f().f73045k1.size() > 0 && !com.tencent.av.n.e().f().f73045k1.get(0).f73829c) {
                            com.tencent.av.n.e().f().f73045k1.get(0).f73829c = true;
                            if (QLog.isColorLevel()) {
                                QLog.d(VideoLayerUI.this.N, 2, "VideoUiLayer onLayoutModeChange --> displayList  not has big one");
                            }
                        }
                        ReportController.o(null, "CliOper", "", "", "0X8009F61", "0X8009F61", 0, 0, "", "", "", "");
                        ((AVActivity) VideoLayerUI.this.Q).U2(4);
                    }
                }
                return true;
            }
            x xVar2 = VideoLayerUI.this.f75276h0;
            if (xVar2 != null && xVar2.c() == 4) {
                if (!VideoLayerUI.this.S1()) {
                    return true;
                }
                ReportController.o(null, "CliOper", "", "", "0X8009F60", "0X8009F60", 0, 0, "", "", "", "");
                ((AVActivity) VideoLayerUI.this.Q).U2(3);
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
            boolean z16;
            aj ajVar;
            boolean z17;
            boolean z18;
            boolean z19;
            boolean z26;
            boolean z27;
            float y16;
            float x16;
            float x17;
            int i3;
            int i16;
            boolean z28;
            boolean z29;
            boolean z36;
            boolean z37;
            boolean z38;
            boolean z39;
            boolean z46;
            if (VideoLayerUI.this.R == null || com.tencent.av.r.h0() == null || motionEvent == null || motionEvent2 == null || VideoLayerUI.this.M0()) {
                return false;
            }
            if (VideoLayerUI.this.O0 > motionEvent2.getDownTime()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                QLog.w(VideoLayerUI.this.N, 1, "onFling, lastHandledEventTime[" + VideoLayerUI.this.O0 + "], e1[" + motionEvent + "], e2[" + motionEvent2 + "]");
                return false;
            }
            AVActivity e26 = VideoLayerUI.this.e2();
            if (e26 == null || (ajVar = e26.I0) == null || ajVar.p() == null || e26.f74657h1 == null) {
                return false;
            }
            boolean I = e26.I0.I();
            SessionInfo f18 = com.tencent.av.n.e().f();
            if (!e26.f74657h1.p() && !f18.f73098x2) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (f18.f73035i == 4) {
                z18 = true;
            } else {
                z18 = false;
            }
            boolean w3 = e26.w3();
            GLVideoView[] gLVideoViewArr = VideoLayerUI.this.f75271c0;
            if (!gLVideoViewArr[0].R && !gLVideoViewArr[1].R) {
                z19 = false;
            } else {
                z19 = true;
            }
            if (z18 && w3 && z19) {
                z26 = true;
            } else {
                z26 = false;
            }
            boolean z47 = !f18.B();
            if ((!e26.I0.p().v0(5) || e26.f74657h1.p()) && !z26 && z47 && !x.g(e26) && !f18.f73098x2 && !f18.f73102y2 && !e26.I0.p().v0(6)) {
                z27 = true;
            } else {
                z27 = false;
            }
            long d16 = com.tencent.av.utils.e.d();
            if (VideoLayerUI.this.f75220y1 != 90 && VideoLayerUI.this.f75220y1 != 270) {
                y16 = motionEvent2.getX() - motionEvent.getX();
                x16 = motionEvent2.getY();
                x17 = motionEvent.getY();
            } else {
                y16 = motionEvent2.getY() - motionEvent.getY();
                x16 = motionEvent2.getX();
                x17 = motionEvent.getX();
            }
            float f19 = x16 - x17;
            float abs = Math.abs(y16);
            float abs2 = Math.abs(f19);
            boolean z48 = z27;
            if (VideoLayerUI.this.f75220y1 != 180 && VideoLayerUI.this.f75220y1 != 270) {
                i3 = -1;
            } else {
                i3 = 1;
            }
            if (VideoLayerUI.this.f75220y1 != 90 && VideoLayerUI.this.f75220y1 != 180) {
                i16 = -1;
            } else {
                i16 = 1;
            }
            if (abs < abs2) {
                float f26 = i3;
                float f27 = f26 * f19;
                int i17 = VideoLayerUI.this.L0;
                if (f27 >= i17) {
                    z39 = true;
                } else {
                    z39 = false;
                }
                if (f26 * (-f19) >= i17) {
                    z38 = true;
                } else {
                    z38 = false;
                }
                z28 = z17;
                z29 = false;
                z37 = false;
            } else {
                float f28 = i16;
                float f29 = f28 * y16;
                int i18 = VideoLayerUI.this.L0;
                z28 = z17;
                if (f29 >= i18) {
                    z29 = true;
                } else {
                    z29 = false;
                }
                if (f28 * (-y16) >= i18) {
                    z36 = true;
                } else {
                    z36 = false;
                }
                z37 = z36;
                z38 = false;
                z39 = false;
            }
            QLog.w(VideoLayerUI.this.N, 1, "onFling, e1[" + motionEvent + "], e2[" + motionEvent2 + "], velocityX[" + f16 + "], velocityY[" + f17 + "], xOffset[" + abs + "], yOffset[" + abs2 + "], up[" + z39 + "], down[" + z38 + "], left[" + z29 + "], right[" + z37 + "], handle[" + z16 + "], lastHandledEventTime[" + VideoLayerUI.this.O0 + "], seq[" + d16 + "]");
            if (!I && (z39 || z38)) {
                return false;
            }
            if (z39 && z28) {
                QavPanel p16 = e26.I0.p();
                if (p16.v0(0) || p16.v0(-1)) {
                    SessionInfo f36 = com.tencent.av.n.e().f();
                    if (f36 != null && f36.S0 == 3) {
                        int i19 = f36.f73046k2;
                        if (i19 != 2) {
                            z46 = true;
                            if (i19 == 1) {
                                return false;
                            }
                        } else {
                            return false;
                        }
                    } else {
                        z46 = true;
                    }
                    if (e26.I0.l1(d16)) {
                        DataReport.a.a(z46);
                        e26.Z0.n(d16, e26, 0, 0);
                        e26.I0.p().V0(d16, -1);
                        return true;
                    }
                    return false;
                }
                return false;
            }
            if (z38 && z28) {
                if (e26.I0.p().v0(5)) {
                    DataReport.a.a(false);
                    e26.I0.p().X0(d16, 0, true);
                    return true;
                }
                return false;
            }
            if (z37 && z48) {
                e26.f74657h1.o(1);
                com.tencent.av.chatroom.c.e("0X800A8D2");
                return false;
            }
            if (z29 && z48) {
                e26.I0.p().X0(d16, 0, false);
                e26.Z0.n(d16, e26, 0, 1);
                e26.f74657h1.A(2);
                if (!I) {
                    e26.I0.V0();
                }
                com.tencent.av.chatroom.c.e("0X800A8D1");
                return false;
            }
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            int i3;
            if (VideoLayerUI.this.R == null || com.tencent.av.r.h0() == null || VideoLayerUI.this.M0()) {
                return false;
            }
            try {
                long d16 = com.tencent.av.utils.e.d();
                boolean N0 = VideoLayerUI.this.N0();
                boolean R1 = VideoLayerUI.this.R1();
                if (QLog.isColorLevel()) {
                    QLog.w(VideoLayerUI.this.N, 1, "onSingleTapConfirmed, mTargetIndex[" + VideoLayerUI.this.f75274f0 + "], isDoubleScreen[" + N0 + "], canMove[" + R1 + "], seq[" + d16 + "]");
                }
                SessionInfo f16 = com.tencent.av.n.e().f();
                if (!VideoLayerUI.this.C2()) {
                    VideoLayerUI videoLayerUI = VideoLayerUI.this;
                    if (videoLayerUI.f75274f0 > 0 && !N0 && videoLayerUI.o2() != 7 && !f16.f73098x2 && !f16.f73102y2) {
                        if (f16.f73035i == 2) {
                            if (VideoLayerUI.this.f75276h0.a()) {
                                VideoLayerUI videoLayerUI2 = VideoLayerUI.this;
                                videoLayerUI2.p3(0, videoLayerUI2.f75274f0);
                            }
                        } else {
                            if (R1) {
                                VideoLayerUI videoLayerUI3 = VideoLayerUI.this;
                                GLVideoView[] gLVideoViewArr = videoLayerUI3.f75271c0;
                                if (gLVideoViewArr != null && (i3 = videoLayerUI3.f75274f0) > 0 && i3 < gLVideoViewArr.length) {
                                    if (videoLayerUI3.f75276h0.a()) {
                                        VideoLayerUI videoLayerUI4 = VideoLayerUI.this;
                                        GLVideoView[] gLVideoViewArr2 = videoLayerUI4.f75271c0;
                                        GLVideoView gLVideoView = gLVideoViewArr2[0];
                                        GLVideoView gLVideoView2 = gLVideoViewArr2[videoLayerUI4.f75274f0];
                                        if (gLVideoView != null && gLVideoView2 != null) {
                                            VideoLayerUI.this.R.k0(new Object[]{115, gLVideoView.G0(), Integer.valueOf(gLVideoView.H0()), gLVideoView2.G0(), Integer.valueOf(gLVideoView2.H0())});
                                        }
                                        return true;
                                    }
                                    if (VideoLayerUI.this.f75276h0.c() == 3) {
                                        VideoLayerUI.this.R.k0(new Object[]{110, Long.valueOf(d16)});
                                    }
                                }
                                return true;
                            }
                            VideoLayerUI.this.R.k0(new Object[]{110, Long.valueOf(d16)});
                        }
                        return true;
                    }
                }
                VideoLayerUI.this.R.k0(new Object[]{110, Long.valueOf(d16)});
                return true;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(VideoLayerUI.this.N, 2, "onSingleTapConfirmed --> Exception = " + e16);
                }
                return true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class h implements b.a {

        /* renamed from: a, reason: collision with root package name */
        private int f75253a = 0;

        /* renamed from: b, reason: collision with root package name */
        private int f75254b = 0;

        /* renamed from: c, reason: collision with root package name */
        private int f75255c = 0;

        h() {
        }

        @Override // nv.b.a
        public void a(nv.b bVar) {
            if (QLog.isColorLevel()) {
                QLog.d(VideoLayerUI.this.N, 2, "onMoveEnd");
            }
            if (VideoLayerUI.this.f75276h0.c() == 2) {
                return;
            }
            PointF h16 = bVar.h();
            int i3 = (int) h16.x;
            int i16 = (int) h16.y;
            VideoLayerUI videoLayerUI = VideoLayerUI.this;
            int i17 = videoLayerUI.f75274f0;
            if (i17 == 0) {
                videoLayerUI.f75271c0[0].A1(i3, i16, true);
            } else if (i17 == 1 && videoLayerUI.R1()) {
                VideoLayerUI.this.n0(i3, i16);
                int i18 = (int) bVar.i();
                int j3 = (int) bVar.j();
                VideoLayerUI videoLayerUI2 = VideoLayerUI.this;
                videoLayerUI2.f75294z0 = videoLayerUI2.z0(this.f75255c, this.f75253a, this.f75254b, i18, j3);
                VideoLayerUI videoLayerUI3 = VideoLayerUI.this;
                videoLayerUI3.l0(videoLayerUI3.f75294z0);
            }
            VideoLayerUI.this.J2(6503, Boolean.FALSE);
        }

        @Override // nv.b.a
        public boolean b(nv.b bVar) {
            if (VideoLayerUI.this.f75276h0.c() == 2) {
                return false;
            }
            if (QLog.isDevelopLevel()) {
                QLog.d(VideoLayerUI.this.N, 2, "onMove");
            }
            PointF h16 = bVar.h();
            int i3 = (int) h16.x;
            int i16 = (int) h16.y;
            VideoLayerUI videoLayerUI = VideoLayerUI.this;
            int i17 = videoLayerUI.f75274f0;
            if (i17 == 0) {
                videoLayerUI.f75271c0[0].A1(i3, i16, false);
            } else if (i17 == 1 && videoLayerUI.R1()) {
                VideoLayerUI.this.n0(i3, i16);
            }
            return true;
        }

        @Override // nv.b.a
        public boolean c(nv.b bVar) {
            VideoLayerUI videoLayerUI = VideoLayerUI.this;
            int i3 = videoLayerUI.f75274f0;
            if (i3 == 0) {
                PointF h16 = bVar.h();
                VideoLayerUI.this.f75271c0[0].A1((int) h16.x, (int) h16.y, false);
            } else if (i3 == 1 && videoLayerUI.R1()) {
                this.f75253a = (int) bVar.i();
                this.f75254b = (int) bVar.j();
                this.f75255c = VideoLayerUI.this.B0();
            }
            if (QLog.isColorLevel()) {
                QLog.w(VideoLayerUI.this.N, 1, "onMoveBegin, mTargetIndex[" + VideoLayerUI.this.f75274f0 + "], startX[" + this.f75253a + "], startY[" + this.f75254b + "], startPosition[" + this.f75255c + "], mTopOffset[" + VideoLayerUI.this.T + "], mBottomOffset[" + VideoLayerUI.this.U + "], mRecordCtrlBottom[" + VideoLayerUI.this.G0 + "]");
                QLog.d(VideoLayerUI.this.N, 2, "onMoveBegin");
            }
            VideoLayerUI.this.J2(6503, Boolean.TRUE);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class i extends ExploreByTouchHelper {
        public i(View view) {
            super(view);
        }

        private String a(int i3) {
            int i16;
            String str;
            am n26;
            String str2;
            GLVideoView[] gLVideoViewArr = VideoLayerUI.this.f75271c0;
            if (gLVideoViewArr != null && i3 >= 0 && i3 < gLVideoViewArr.length) {
                int i17 = com.tencent.av.n.e().f().f73067q;
                if (i17 == 3000) {
                    i16 = 1004;
                } else if (i17 == 1) {
                    i16 = 1000;
                } else if (i17 == 0) {
                    i16 = 0;
                } else {
                    i16 = -1;
                }
                Resources resources = VideoLayerUI.this.Q.getApplicationContext().getResources();
                String currentAccountUin = VideoLayerUI.this.R.getCurrentAccountUin();
                String G0 = VideoLayerUI.this.f75271c0[i3].G0();
                if (G0 != null) {
                    if (G0.equals(currentAccountUin)) {
                        str = resources.getString(R.string.cfm) + resources.getString(R.string.dck);
                    } else {
                        str = VideoLayerUI.this.R.G(i16, G0, String.valueOf(com.tencent.av.n.e().f().P0)) + resources.getString(R.string.dck);
                    }
                    if (((com.tencent.av.n.e().f().S0 == 1 && com.tencent.av.n.e().f().f73063p == 10) || com.tencent.av.n.e().f().S0 == 2) && (n26 = VideoLayerUI.this.n2(Long.parseLong(G0))) != null) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(str);
                        if (n26.d()) {
                            str2 = "\uff0c\u9ea6\u514b\u98ce\u5df2\u5173\u95ed";
                        } else {
                            str2 = "\uff0c\u9ea6\u514b\u98ce\u5df2\u5f00\u542f";
                        }
                        sb5.append(str2);
                        return sb5.toString();
                    }
                    return str;
                }
            }
            return "";
        }

        private Rect getBoundsForIndex(int i3) {
            Rect rect = new Rect(0, 0, 1, 1);
            GLVideoView[] gLVideoViewArr = VideoLayerUI.this.f75271c0;
            if (gLVideoViewArr != null && gLVideoViewArr[i3].m() == 0) {
                rect.set(VideoLayerUI.this.f75271c0[i3].f());
            }
            return rect;
        }

        @Override // android.support.v4.widget.ExploreByTouchHelper
        protected int getVirtualViewAt(float f16, float f17) {
            GLVideoView[] gLVideoViewArr = VideoLayerUI.this.f75271c0;
            if (gLVideoViewArr != null) {
                for (int length = gLVideoViewArr.length - 1; length >= 0; length--) {
                    if (VideoLayerUI.this.f75271c0[length].m() == 0 && VideoLayerUI.this.f75271c0[length].f().contains((int) f16, (int) f17)) {
                        return length;
                    }
                }
            }
            return 0;
        }

        @Override // android.support.v4.widget.ExploreByTouchHelper
        protected void getVisibleVirtualViews(List<Integer> list) {
            GLVideoView[] gLVideoViewArr = VideoLayerUI.this.f75271c0;
            if (gLVideoViewArr != null) {
                int length = gLVideoViewArr.length;
                for (int i3 = 0; i3 < length; i3++) {
                    list.add(Integer.valueOf(i3));
                }
            }
        }

        @Override // android.support.v4.widget.ExploreByTouchHelper
        protected boolean onPerformActionForVirtualView(int i3, int i16, Bundle bundle) {
            return false;
        }

        @Override // android.support.v4.widget.ExploreByTouchHelper
        protected void onPopulateEventForVirtualView(int i3, AccessibilityEvent accessibilityEvent) {
            accessibilityEvent.setContentDescription(a(i3));
        }

        @Override // android.support.v4.widget.ExploreByTouchHelper
        protected void onPopulateNodeForVirtualView(int i3, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            accessibilityNodeInfoCompat.addAction(16);
            accessibilityNodeInfoCompat.setContentDescription(a(i3));
            Rect boundsForIndex = getBoundsForIndex(i3);
            if (boundsForIndex.isEmpty()) {
                boundsForIndex.set(0, 0, 1, 1);
            }
            accessibilityNodeInfoCompat.setBoundsInParent(boundsForIndex);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class j implements GestureDetector.OnGestureListener {

        /* renamed from: d, reason: collision with root package name */
        private boolean f75258d;

        /* renamed from: e, reason: collision with root package name */
        private long f75259e = -1;

        j() {
        }

        private void a() {
            if (!this.f75258d) {
                return;
            }
            this.f75258d = false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
            a();
            int l26 = VideoLayerUI.this.l2();
            if (l26 == 0) {
                return false;
            }
            VideoLayerUI.this.f75202g1.b((int) (-f16), 0, l26);
            VideoLayerUI.this.p();
            VideoLayerUI.this.Y2(-1000L);
            return true;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            a();
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
            a();
            VideoLayerUI.this.p();
            VideoLayerUI.this.Y2(TroopMemberInfo.VALUE_MEMBER_CLOSE_SHARE_LBS);
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f75259e > 100) {
                ReportController.o(null, "CliOper", "", "", "0X8009F62", "0X8009F62", 0, 0, "", "", "", "");
                this.f75259e = currentTimeMillis;
                return true;
            }
            return true;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onShowPress(MotionEvent motionEvent) {
            if (this.f75258d) {
                return;
            }
            if (VideoLayerUI.this.m2(motionEvent.getX()) != -1) {
                this.f75258d = true;
            } else {
                QLog.d(VideoLayerUI.this.N, 1, "error condition print onShowPress");
            }
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            boolean z16;
            boolean z17;
            boolean z18;
            long d16 = com.tencent.av.utils.e.d();
            a();
            VideoLayerUI.this.Y2(-1002L);
            if (!VideoLayerUI.this.f75204i1 && VideoLayerUI.this.S1()) {
                int m26 = VideoLayerUI.this.m2(motionEvent.getX());
                boolean z19 = false;
                if (VideoLayerUI.this.f75203h1) {
                    if (m26 == -1) {
                        return true;
                    }
                    GLVideoView gLVideoView = VideoLayerUI.this.f75271c0[0];
                    String G0 = gLVideoView.G0();
                    int H0 = gLVideoView.H0();
                    if (TextUtils.isEmpty(G0)) {
                        QLog.d(VideoLayerUI.this.N, 1, "onSingleTapUp with empty UIN");
                        return true;
                    }
                    ArrayList<am> e16 = VideoLayerUI.this.p2().e();
                    if (e16.size() > 16) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (m26 == 14 && z16) {
                        ReportController.o(null, "CliOper", "", "", "0X800A069", "0X800A069", 0, 0, "", "", "", "");
                        AVActivity aVActivity = (AVActivity) VideoLayerUI.this.Q;
                        if (com.tencent.av.n.e().f().f73037i1 || com.tencent.av.n.e().f().f73041j1) {
                            z19 = true;
                        }
                        VideoMsgTools.x(aVActivity, String.valueOf(com.tencent.av.n.e().f().P0), z19, true);
                        QLog.d(VideoLayerUI.this.N, 1, "onSingleTapUp jumpTo lists");
                        return true;
                    }
                    int i3 = m26 + 1;
                    if (i3 > e16.size() - 1) {
                        QLog.d(VideoLayerUI.this.N, 1, "onSingleTapUp ArrayOutOfList");
                        VideoLayerUI.this.R.k0(new Object[]{110, Long.valueOf(d16)});
                        return true;
                    }
                    am amVar = e16.get(i3);
                    if (amVar != null && amVar.g()) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (amVar != null && G0.equalsIgnoreCase(String.valueOf(amVar.f75350b)) && amVar.b() == H0) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i(VideoLayerUI.this.N, 2, "onSingleTapUp, isVideoIn[" + z17 + "], isSame[" + z18 + "], uin[" + G0 + "], currentSelect[" + amVar + "], index[" + m26 + "]");
                    }
                    if (amVar != null && !z18) {
                        boolean a16 = VideoLayerUI.this.f75276h0.a();
                        if (a16 && z17) {
                            ReportController.o(null, "CliOper", "", "", "0X8009F63", "0X8009F63", 0, 0, "", "", "", "");
                            VideoLayerUI.this.R.k0(new Object[]{115, gLVideoView.G0(), Integer.valueOf(gLVideoView.H0()), String.valueOf(amVar.f75350b), Integer.valueOf(amVar.b())});
                            QLog.d(VideoLayerUI.this.N, 1, "onSingleTapUp mTargetIndex:=" + m26 + ";Numberlist:=" + e16.size());
                        } else if (QLog.isColorLevel()) {
                            QLog.i(VideoLayerUI.this.N, 2, "onSingleTapUp, canSwitchView[" + a16 + "], isVideoIn[" + z17 + "]");
                        }
                        if (!z17) {
                            if (amVar.c()) {
                                if (amVar.a() == VideoLayerUI.this.R.getLongAccountUin()) {
                                    z19 = true;
                                }
                                if (z19) {
                                    cw.e.n(VideoLayerUI.this.R, 1051);
                                } else {
                                    cw.e.n(VideoLayerUI.this.R, 1052);
                                }
                                QLog.d(VideoLayerUI.this.N, 1, "not open camera isSelfUin:=" + z19);
                            } else {
                                cw.e.n(VideoLayerUI.this.R, 1053);
                                QLog.d(VideoLayerUI.this.N, 1, "not attend video talking");
                            }
                            ReportController.o(null, "CliOper", "", "", "0X800A068", "0X800A068", 0, 0, "", "", "", "");
                        }
                    }
                    return true;
                }
                if (m26 != -1) {
                    int i16 = m26 + 1;
                    VideoLayerUI videoLayerUI = VideoLayerUI.this;
                    GLVideoView[] gLVideoViewArr = videoLayerUI.f75271c0;
                    if (gLVideoViewArr != null && i16 > 0 && i16 < gLVideoViewArr.length) {
                        GLVideoView gLVideoView2 = gLVideoViewArr[0];
                        GLVideoView gLVideoView3 = gLVideoViewArr[i16];
                        if (gLVideoView2 != null && gLVideoView3 != null) {
                            if (videoLayerUI.f75276h0.a()) {
                                ReportController.o(null, "CliOper", "", "", "0X8009F63", "0X8009F63", 0, 0, "", "", "", "");
                                VideoLayerUI.this.R.k0(new Object[]{115, gLVideoView2.G0(), Integer.valueOf(gLVideoView2.H0()), gLVideoView3.G0(), Integer.valueOf(gLVideoView3.H0())});
                            }
                            QLog.d(VideoLayerUI.this.N, 1, "condition print onSingleTapUp mTargetIndex:=" + VideoLayerUI.this.f75274f0 + ",canSwitchView=" + VideoLayerUI.this.f75276h0.a());
                        }
                    }
                    return true;
                }
                QLog.d(VideoLayerUI.this.N, 1, "error condition print onSingleTapUp");
            }
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class k extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        public k() {
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (QLog.isColorLevel()) {
                QLog.d(VideoLayerUI.this.N, 2, "onScale");
            }
            if (VideoLayerUI.this.S0 < 0) {
                VideoLayerUI.this.S0 = (int) scaleGestureDetector.getFocusX();
            }
            if (VideoLayerUI.this.T0 < 0) {
                VideoLayerUI.this.T0 = (int) scaleGestureDetector.getFocusY();
            }
            float scaleFactor = scaleGestureDetector.getScaleFactor();
            VideoLayerUI videoLayerUI = VideoLayerUI.this;
            videoLayerUI.f75271c0[0].p1(scaleFactor, videoLayerUI.S0, VideoLayerUI.this.T0);
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            if (QLog.isColorLevel()) {
                QLog.d(VideoLayerUI.this.N, 2, "onScaleEnd");
            }
            float B0 = VideoLayerUI.this.f75271c0[0].B0();
            float z06 = VideoLayerUI.this.f75271c0[0].z0();
            float y06 = VideoLayerUI.this.f75271c0[0].y0();
            if (B0 < z06) {
                VideoLayerUI videoLayerUI = VideoLayerUI.this;
                videoLayerUI.x3(videoLayerUI.f75271c0[0], z06 / B0, 60L);
            } else if (B0 > y06) {
                VideoLayerUI videoLayerUI2 = VideoLayerUI.this;
                videoLayerUI2.x3(videoLayerUI2.f75271c0[0], y06 / B0, 60L);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class l implements b.a {

        /* renamed from: a, reason: collision with root package name */
        private float f75262a = 0.0f;

        /* renamed from: b, reason: collision with root package name */
        private float f75263b = 0.0f;

        /* renamed from: c, reason: collision with root package name */
        private long f75264c = 0;

        /* renamed from: d, reason: collision with root package name */
        private boolean f75265d = false;

        /* renamed from: e, reason: collision with root package name */
        private boolean f75266e = false;

        public l() {
        }

        @Override // com.tencent.av.opengl.ui.b.a
        public boolean a(com.tencent.av.opengl.ui.b bVar, MotionEvent motionEvent) {
            boolean b16 = b(bVar, motionEvent);
            if (motionEvent.getAction() == 1) {
                VideoLayerUI.this.O0 = 0L;
            }
            return b16;
        }

        boolean b(com.tencent.av.opengl.ui.b bVar, MotionEvent motionEvent) {
            VideoUtil.AnimationTrigger animationTrigger;
            if (bVar == null || motionEvent == null || VideoLayerUI.this.R == null || com.tencent.av.r.h0() == null || VideoLayerUI.this.M0()) {
                return false;
            }
            if (com.tencent.av.n.e().f().f73056n0 == 1) {
                return true;
            }
            if (motionEvent.getAction() == 0) {
                this.f75262a = 0.0f;
                this.f75263b = 0.0f;
                this.f75264c = System.currentTimeMillis();
                this.f75262a = motionEvent.getX();
                this.f75263b = motionEvent.getY();
                if (QLog.isColorLevel()) {
                    QLog.e(VideoLayerUI.this.N, 2, "[childLock] touch onDown: " + this.f75262a + " x " + this.f75263b + " ==========");
                }
                if (VideoLayerUI.this.N0 != null) {
                    if (com.tencent.av.n.e().f().f73048l0) {
                        VideoLayerUI.this.N0.g();
                    } else {
                        VideoLayerUI.this.N0.f(this.f75262a, this.f75263b);
                    }
                }
                this.f75265d = false;
                this.f75266e = false;
            }
            if (!com.tencent.av.n.e().f().f73048l0 && (motionEvent.getAction() == 1 || motionEvent.getPointerCount() > 1 || (motionEvent.getAction() == 2 && (Math.abs(motionEvent.getX() - this.f75262a) > 70.0f || Math.abs(motionEvent.getY() - this.f75263b) > 70.0f)))) {
                VideoLayerUI videoLayerUI = VideoLayerUI.this;
                if (videoLayerUI.N0 != null) {
                    videoLayerUI.R.M().removeCallbacks(VideoLayerUI.this.N0);
                    if (VideoLayerUI.this.N0.e()) {
                        if (motionEvent.getAction() == 1) {
                            VideoLayerUI.this.N0.cancel();
                        }
                        if (QLog.isColorLevel()) {
                            QLog.e(VideoLayerUI.this.N, 2, "[childLock] cancel animation");
                        }
                    }
                }
                if (QLog.isDevelopLevel()) {
                    QLog.e(VideoLayerUI.this.N, 2, "[childLock] touch end ==========");
                }
            }
            if (com.tencent.av.n.e().f().f73048l0) {
                if (motionEvent.getAction() == 1 && System.currentTimeMillis() - this.f75264c < 200 && (animationTrigger = VideoLayerUI.this.N0) != null) {
                    animationTrigger.h();
                }
                return true;
            }
            VideoLayerUI videoLayerUI2 = VideoLayerUI.this;
            videoLayerUI2.f75274f0 = -1;
            GLVideoView[] gLVideoViewArr = videoLayerUI2.f75271c0;
            int length = gLVideoViewArr.length;
            int i3 = 0;
            int i16 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                if (bVar == gLVideoViewArr[i3]) {
                    VideoLayerUI.this.f75274f0 = i16;
                    break;
                }
                i16++;
                i3++;
            }
            if (VideoLayerUI.this.C2() && VideoLayerUI.this.f75201f1 != null && com.tencent.av.r.h0() != null && VideoLayerUIBase.R0(com.tencent.av.n.e().f()) && com.tencent.av.n.e().f().f73045k1 != null && com.tencent.av.n.e().f().f73045k1.size() > 0) {
                int x16 = (int) motionEvent.getX();
                int y16 = (int) motionEvent.getY();
                if (motionEvent.getAction() == 0 && VideoLayerUI.this.W0.contains(x16, y16) && (!VideoLayerUI.this.B2() || com.tencent.av.utils.af.A())) {
                    VideoLayerUI.this.O0 = motionEvent.getEventTime();
                    this.f75265d = true;
                }
                if (this.f75265d) {
                    if (VideoLayerUI.this.W0.contains(x16, y16) && (!VideoLayerUI.this.B2() || com.tencent.av.utils.af.A())) {
                        VideoLayerUI.this.f75201f1.onTouchEvent(motionEvent);
                        int action = motionEvent.getAction();
                        if (action != 0) {
                            if (action == 1) {
                                VideoLayerUI.this.p();
                            }
                        } else {
                            VideoLayerUI.this.f75204i1 = !r9.f75202g1.e();
                            VideoLayerUI.this.f75202g1.c();
                        }
                    } else if (!this.f75266e) {
                        MotionEvent obtain = MotionEvent.obtain(motionEvent);
                        obtain.setAction(3);
                        VideoLayerUI.this.f75201f1.onTouchEvent(obtain);
                        this.f75266e = true;
                        VideoLayerUI.this.O0 = motionEvent.getEventTime();
                    }
                }
            }
            ImageView imageView = VideoLayerUI.this.f75275g0;
            if (imageView != null && imageView.getVisibility() == 0) {
                VideoLayerUI.this.f75274f0 = 0;
            }
            GestureDetector gestureDetector = VideoLayerUI.this.F0;
            if (gestureDetector != null && !this.f75265d) {
                gestureDetector.onTouchEvent(motionEvent);
            }
            if (VideoLayerUIBase.O0(com.tencent.av.n.e().f())) {
                VideoLayerUI videoLayerUI3 = VideoLayerUI.this;
                if (videoLayerUI3.f75274f0 == 1 && videoLayerUI3.Q0 != null) {
                    if (!VideoLayerUI.this.Q0.c() && motionEvent.getAction() != 0) {
                        MotionEvent obtain2 = MotionEvent.obtain(motionEvent);
                        obtain2.setAction(0);
                        VideoLayerUI.this.Q0.d(obtain2);
                        obtain2.recycle();
                    }
                    VideoLayerUI.this.Q0.d(motionEvent);
                    VideoLayerUI.this.O0 = motionEvent.getEventTime();
                }
            } else if (!this.f75265d) {
                VideoLayerUI videoLayerUI4 = VideoLayerUI.this;
                if (videoLayerUI4.f75274f0 == 0 && videoLayerUI4.B2() && 2 == VideoLayerUI.this.f75271c0[0].H0() && VideoLayerUI.this.R0 != null) {
                    VideoLayerUI.this.O0 = motionEvent.getEventTime();
                    VideoLayerUI.this.R0.onTouchEvent(motionEvent);
                    if (!VideoLayerUI.this.R0.isInProgress() && VideoLayerUI.this.Q0 != null) {
                        VideoLayerUI.this.Q0.d(motionEvent);
                    }
                }
            }
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class m implements b.a {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<l> f75268a;

        public m(l lVar) {
            this.f75268a = new WeakReference<>(lVar);
        }

        @Override // com.tencent.av.opengl.ui.b.a
        public boolean a(com.tencent.av.opengl.ui.b bVar, MotionEvent motionEvent) {
            l lVar = this.f75268a.get();
            if (lVar != null) {
                return lVar.a(bVar, motionEvent);
            }
            return false;
        }
    }

    public VideoLayerUI(VideoAppInterface videoAppInterface, Context context, View view) {
        super(videoAppInterface, context, view);
        this.E0 = true;
        this.F0 = null;
        this.G0 = 0;
        this.H0 = 144;
        this.I0 = 144;
        this.J0 = 4;
        this.K0 = null;
        this.L0 = 0;
        this.M0 = false;
        this.N0 = null;
        this.O0 = 0L;
        this.P0 = null;
        this.Q0 = null;
        this.R0 = null;
        this.S0 = -1;
        this.T0 = -1;
        this.U0 = false;
        this.V0 = new Rect();
        this.W0 = new Rect();
        this.X0 = new ArrayList<>();
        this.Y0 = 0;
        this.Z0 = 0;
        this.f75196a1 = true;
        this.f75197b1 = 0;
        this.f75198c1 = 0;
        this.f75200e1 = -1;
        this.f75203h1 = true;
        this.f75205j1 = new DisplayMetrics();
        this.f75206k1 = -1L;
        this.f75207l1 = -1;
        this.f75210o1 = new ConcurrentHashMap<>();
        this.f75211p1 = false;
        this.f75212q1 = -1;
        this.f75213r1 = -1;
        this.f75214s1 = null;
        this.f75215t1 = 0L;
        this.f75216u1 = new l();
        this.f75217v1 = null;
        this.f75219x1 = 0;
        this.f75220y1 = 0;
        this.f75276h0 = x.b(this.Q, this.R, 1, false);
        if (com.tencent.av.n.e().f().F()) {
            p2();
        }
        if (C2()) {
            z2();
        }
        x2();
        J0();
        w2();
        I0();
        t2();
        A2();
        u2();
        QLog.w(this.N, 1, "VideoLayerUI");
    }

    private void A2() {
        this.R0 = new ScaleGestureDetector(this.Q, new k());
        this.F0 = new GestureDetector(this.Q, new g());
        this.Q0 = new nv.b(this.Q, new h());
        m mVar = new m(this.f75216u1);
        this.P0 = mVar;
        M(mVar);
        this.L0 = BaseAIOUtils.f(20.0f, this.Q.getResources());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean C2() {
        x xVar = this.f75276h0;
        if (xVar != null && xVar.c() == 4 && !this.U0) {
            return true;
        }
        return false;
    }

    private boolean N1(int i3, int i16) {
        if (this.f75215t1 != 0 && System.currentTimeMillis() - this.f75215t1 < 1000) {
            QLog.w(this.N, 1, "bigWindowToSmallWindowAnim, \u5927\u5c0f\u7a97\u6b63\u5728\u5207\u6362\u4e2d[" + this.f75215t1 + "]");
            return false;
        }
        GLVideoView gLVideoView = this.f75271c0[i16];
        gLVideoView.e1(Boolean.FALSE);
        gLVideoView.O(0, 0, 0, 0);
        int o16 = gLVideoView.o();
        gLVideoView.S(1);
        float f16 = gLVideoView.f().left;
        float f17 = gLVideoView.f().top;
        Rect k3 = super.k();
        sv.a aVar = new sv.a();
        aVar.o(100);
        aVar.s(f16, f17, 0.0f, -k3.left, -k3.top, 0.0f);
        aVar.q(gLVideoView.f().width(), gLVideoView.f().height(), super.n() + k3.left + k3.right, super.h() + k3.top + k3.bottom);
        aVar.n(new d(i16, o16, i3));
        aVar.r(2);
        gLVideoView.T(aVar);
        gLVideoView.p();
        this.f75215t1 = System.currentTimeMillis();
        return true;
    }

    public static int O1(String str, Context context, int i3, boolean z16, Display display) {
        if (z16) {
            int rotation = display.getRotation();
            int i16 = ((rotation * 90) + i3) % 360;
            com.tencent.av.camera.b.a(context).setSupportLandscape(true);
            if (QLog.isDevelopLevel()) {
                QLog.w(str, 1, "setRotation, rotation[" + i3 + "], displayRotation[" + rotation + "], viewRotation[" + i16 + "]");
            }
            return i16;
        }
        com.tencent.av.camera.b.a(context).setSupportLandscape(false);
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P1(GLVideoView gLVideoView, boolean z16) {
        sv.a aVar = new sv.a();
        aVar.o(50);
        aVar.p(0.0f, 0.0f, 0.0f, 90.0f, 0.0f, 0.0f);
        aVar.n(new a(gLVideoView, z16));
        aVar.r(1);
        gLVideoView.T(aVar);
        gLVideoView.p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q1(GLVideoView gLVideoView) {
        sv.a aVar = new sv.a();
        aVar.o(50);
        aVar.p(0.0f, 0.0f, -90.0f, 0.0f, 0.0f, 0.0f);
        aVar.r(2);
        aVar.n(new b());
        gLVideoView.T(aVar);
        gLVideoView.p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean S1() {
        long j3 = this.f75206k1;
        long currentTimeMillis = System.currentTimeMillis();
        this.f75206k1 = currentTimeMillis;
        if (currentTimeMillis - j3 > 1000) {
            return true;
        }
        this.f75206k1 = j3;
        QLog.d(this.N, 1, "canPerformClick not allowed");
        return false;
    }

    private void T2(long j3, Boolean bool) {
        int w06 = w0("openSelfVideo", this.R.getCurrentAccountUin(), 1);
        SessionInfo f16 = com.tencent.av.n.e().f();
        Context context = this.Q;
        AVActivity aVActivity = (AVActivity) context;
        if (x.g(context) && !f16.F()) {
            aVActivity.handleVideoCountChangeLayout(true, f16.O);
        }
        P2(j3);
        if (bool.booleanValue() && w06 > 0) {
            if (f16.f73035i != 2 || f16.M) {
                p3(0, w06);
            }
        }
    }

    private Bitmap U1(Bitmap bitmap) {
        Object obj;
        if (bitmap == null || bitmap.isRecycled() || bitmap.getConfig() == null) {
            bitmap = ba.getBitmapFromResourceId(this.Q, R.drawable.bqc);
            if (QLog.isDevelopLevel()) {
                String str = this.N;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("memory not enough or binder bad,so quit load headIcon,bitmap.getConfig():=");
                if (bitmap != null) {
                    obj = bitmap.getConfig();
                } else {
                    obj = "bitmap null";
                }
                sb5.append(obj);
                QLog.d(str, 1, sb5.toString());
            }
        }
        return bitmap;
    }

    private void U2(int i3, int i16) {
        int size = this.X0.size();
        int i17 = i3 + this.J0;
        int i18 = this.H0 + i17;
        for (int i19 = 1; i19 <= size; i19++) {
            this.X0.get(i19 - 1).q(i17, i16, i18, this.I0 + i16);
            int i26 = this.H0;
            i17 += this.J0 + i26;
            i18 = i26 + i17;
        }
        int i27 = this.H0;
        int i28 = this.J0;
        this.f75200e1 = (size * (i27 + i28)) + i28;
    }

    private void V1() {
        this.Y0 = 0;
        this.Z0 = 0;
        this.f75196a1 = true;
    }

    private void W2(long j3, int i3) {
        int w06 = w0("refreshMicState", String.valueOf(j3), 1);
        if (w06 != -1) {
            this.f75271c0[w06].T0(i3);
        }
        if (w06 == 0 && e2() != null) {
            e2().I0.g1(i3);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0233 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r10v18, types: [com.tencent.av.ui.GLVideoView[]] */
    /* JADX WARN: Type inference failed for: r10v19, types: [com.tencent.av.ui.GLVideoView] */
    /* JADX WARN: Type inference failed for: r15v3 */
    /* JADX WARN: Type inference failed for: r15v4, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r15v5 */
    /* JADX WARN: Type inference failed for: r15v7 */
    /* JADX WARN: Type inference failed for: r24v0, types: [com.tencent.av.ui.VideoLayerUIBase, com.tencent.av.ui.VideoLayerUI, com.tencent.av.opengl.ui.b, com.tencent.av.opengl.ui.c] */
    /* JADX WARN: Type inference failed for: r2v54, types: [com.tencent.av.opengl.ui.b, com.tencent.av.ui.GLVideoView, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v9, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void X2(ov.a aVar) {
        ArrayList<am> d16;
        boolean z16;
        ArrayList<am> arrayList;
        String str;
        int i3;
        int i16;
        boolean z17;
        am amVar;
        boolean z18;
        boolean z19;
        ArrayList<am> arrayList2;
        boolean z26;
        String str2;
        int i17;
        boolean z27;
        boolean z28;
        boolean z29;
        boolean z36;
        int i18;
        ?? r152;
        boolean z37;
        boolean a16 = this.f75202g1.a(com.tencent.av.opengl.ui.a.a());
        this.X0.clear();
        try {
            GLVideoView gLVideoView = (GLVideoView) d0(0);
            long parseLong = Long.parseLong(gLVideoView.G0());
            int H0 = gLVideoView.H0();
            AVActivity e26 = e2();
            an p26 = p2();
            if (e26 != null && !e26.w3()) {
                d16 = p26.d(false);
            } else {
                p26.g(com.tencent.av.r.h0().Y());
                d16 = p26.d(true);
                if (d16.size() == 0) {
                    QLog.d("GLLinearLayout", 1, "videoMemmberInfos size is zero");
                }
            }
            String str3 = "renderSliderWindowStyle";
            if (this.f75203h1) {
                if (this.f75209n1 == null) {
                    this.f75209n1 = new ak(this.Q, this.R, this);
                }
                this.f75209n1.c(d16);
                if (d16.size() > 16) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                int i19 = 1;
                int i26 = 1;
                boolean z38 = z18;
                while (i19 < d16.size() && (this.X0.size() != 14 || !z38)) {
                    am amVar2 = d16.get(i19);
                    long a17 = amVar2.a();
                    int b16 = amVar2.b();
                    boolean z39 = amVar2.f75352d;
                    boolean g16 = amVar2.g();
                    if (g16) {
                        if (a17 == parseLong && b16 == H0) {
                            if (QLog.isDevelopLevel()) {
                                z19 = a16;
                                String str4 = this.N;
                                arrayList2 = d16;
                                StringBuilder sb5 = new StringBuilder();
                                z37 = z38;
                                sb5.append("arraysToList3 bigindex index:=");
                                sb5.append(i19);
                                QLog.d(str4, 1, sb5.toString());
                            } else {
                                z19 = a16;
                                arrayList2 = d16;
                                z37 = z38;
                            }
                            i26++;
                            z36 = z37;
                        } else {
                            z19 = a16;
                            arrayList2 = d16;
                            z36 = z38;
                        }
                        int w06 = w0(str3, String.valueOf(a17), b16);
                        if (w06 != -1) {
                            ?? r102 = this.f75271c0[w06];
                            boolean d17 = amVar2.d();
                            if (!d17) {
                                if (amVar2.f()) {
                                    i18 = 2;
                                } else {
                                    i18 = 3;
                                }
                            } else {
                                i18 = d17 ? 1 : 0;
                            }
                            r102.T0(i18);
                            if (TextUtils.isEmpty(r102.D0())) {
                                str2 = str3;
                                String j26 = j2(amVar2);
                                r102.u1(j26);
                                i17 = i19;
                                r152 = 1;
                                r152 = 1;
                                if (e26 != null) {
                                    e26.D3(w06, true, j26, i18);
                                }
                            } else {
                                str2 = str3;
                                i17 = i19;
                                r152 = 1;
                            }
                            r102.k1(12);
                            r102.y1(ba.dp2px(this.Q, 12.0f));
                            r102.w1(r152);
                            if (a17 == parseLong && b16 == H0) {
                                QLog.d(this.N, (int) r152, "[renderSliderWindowStyle] big video do not add. bigUin=" + parseLong);
                            } else {
                                this.X0.add(this.f75271c0[w06]);
                            }
                            i26++;
                            z26 = z36;
                        } else {
                            str2 = str3;
                            i17 = i19;
                            z28 = false;
                            z27 = z36;
                            if ((g16 && z39) || !z28) {
                                ?? a18 = this.f75209n1.a(a17);
                                a18.w1(true);
                                boolean d18 = amVar2.d();
                                ?? r95 = d18;
                                if (!d18) {
                                    if (amVar2.f()) {
                                        r95 = 2;
                                    } else {
                                        r95 = 3;
                                    }
                                }
                                a18.T0(r95);
                                if (!((Boolean) a18.l(2)).booleanValue()) {
                                    a18.u1(j2(amVar2));
                                    a18.C1(true);
                                    Bitmap h26 = h2(amVar2);
                                    if (Build.VERSION.SDK_INT == 23) {
                                        h26 = U1(h26);
                                    }
                                    com.tencent.av.opengl.texture.b bVar = new com.tencent.av.opengl.texture.b(h26);
                                    bVar.I(aVar);
                                    a18.J(bVar);
                                    a18.n0(true);
                                } else {
                                    this.X0.add(a18);
                                }
                                a18.g1(false);
                            } else if (z39) {
                                GLVideoView a19 = this.f75209n1.a(a17);
                                int parseColor = Color.parseColor("#4C000000");
                                a19.d1(parseColor);
                                a19.T0(-1);
                                a19.w1(true);
                                if (!((Boolean) a19.l(2)).booleanValue()) {
                                    a19.u1(j2(amVar2));
                                    a19.C1(true);
                                    Bitmap h27 = h2(amVar2);
                                    if (Build.VERSION.SDK_INT == 23) {
                                        h27 = U1(h27);
                                    }
                                    com.tencent.av.opengl.texture.b bVar2 = new com.tencent.av.opengl.texture.b(h27);
                                    bVar2.I(aVar);
                                    bVar2.N(parseColor);
                                    a19.J(bVar2);
                                    z29 = true;
                                    a19.n0(true);
                                } else {
                                    z29 = true;
                                    this.X0.add(a19);
                                }
                                a19.g1(z29);
                            }
                            i19 = i17 + 1;
                            str3 = str2;
                            a16 = z19;
                            d16 = arrayList2;
                            z38 = z27;
                        }
                    } else {
                        z19 = a16;
                        arrayList2 = d16;
                        z26 = z38;
                        str2 = str3;
                        i17 = i19;
                    }
                    z28 = true;
                    z27 = z26;
                    if (g16) {
                    }
                    if (z39) {
                    }
                    i19 = i17 + 1;
                    str3 = str2;
                    a16 = z19;
                    d16 = arrayList2;
                    z38 = z27;
                }
                z16 = a16;
                arrayList = d16;
                str = str3;
                if (z38) {
                    this.f75272d0.u1(((arrayList.size() - 16) + 1) + Marker.ANY_NON_NULL_MARKER);
                    if (((Boolean) this.f75272d0.l(2)).booleanValue()) {
                        this.X0.add(this.f75272d0);
                    } else {
                        this.f75272d0.Q(2, Boolean.TRUE);
                    }
                }
                i3 = i26;
            } else {
                z16 = a16;
                arrayList = d16;
                str = "renderSliderWindowStyle";
                int i27 = 0;
                while (true) {
                    GLVideoView[] gLVideoViewArr = this.f75271c0;
                    if (i27 >= gLVideoViewArr.length) {
                        break;
                    }
                    GLVideoView gLVideoView2 = gLVideoViewArr[i27];
                    if (gLVideoView2.b() && i27 != 0) {
                        this.X0.add(gLVideoView2);
                    }
                    i27++;
                }
                i3 = 1;
            }
            if (i3 >= 2 && ba.isEnableShowTips(2)) {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.av.ui.VideoLayerUI.2
                    @Override // java.lang.Runnable
                    public void run() {
                        cw.e.n(VideoLayerUI.this.R, 1055);
                        ba.disableShowTips(2);
                    }
                });
            }
            aVar.e(n() / 2, h() / 2, 0.0f);
            D(aVar);
            aVar.e((-n()) / 2, (-h()) / 2, 0.0f);
            ArrayList<am> arrayList3 = arrayList;
            int w07 = w0(str, String.valueOf(arrayList3.get(0).f75350b), arrayList3.get(0).b());
            if (w07 == -1) {
                w07 = 0;
            }
            GLVideoView gLVideoView3 = this.f75271c0[w07];
            boolean d19 = arrayList3.get(0).d();
            if (!d19) {
                if (arrayList3.get(0).f()) {
                    i16 = 2;
                } else {
                    i16 = 3;
                }
            } else {
                i16 = d19 ? 1 : 0;
            }
            gLVideoView3.T0(i16);
            gLVideoView3.w1(false);
            gLVideoView3.O(0, 0, 0, 0);
            gLVideoView3.q(0, 0, super.n(), super.h());
            String D0 = gLVideoView3.D0();
            gLVideoView3.y1(ba.dp2px(this.Q, 18.0f));
            if (e26 != null && e26.I0.I()) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (arrayList3.isEmpty()) {
                amVar = null;
            } else {
                amVar = arrayList3.get(0);
            }
            if (TextUtils.isEmpty(D0) && amVar != null && gLVideoView3.G0().equals(String.valueOf(amVar.f75350b))) {
                D0 = j2(amVar);
                gLVideoView3.u1(D0);
            }
            if (e26 != null) {
                e26.D3(w07, z17, D0, i16);
            }
            d2(aVar, gLVideoView3, true);
            if (!gLVideoView3.b() && QLog.isDevelopLevel()) {
                QLog.d(this.N, 1, "error happen big screen can not render with Uin:=" + gLVideoView3.G0() + ",srcType:=" + gLVideoView3.H0());
            }
            Rect rect = this.W0;
            U2(rect.left, rect.top);
            u3(this.f75202g1.d(), this.f75196a1);
            if (this.f75196a1) {
                this.f75196a1 = false;
            }
            aVar.k(-this.Y0, -this.Z0);
            for (int i28 = 0; i28 < this.X0.size(); i28++) {
                d2(aVar, this.X0.get(i28), false);
            }
            aVar.k(this.Y0, this.Z0);
            if (z16) {
                p();
            }
        } catch (NumberFormatException e16) {
            e16.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y2(long j3) {
        Context context = this.Q;
        if (context != null && !this.M0) {
            ((AVActivity) context).I0.H0(j3);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v11, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v4 */
    private void b2(String str, int i3) {
        float f16;
        int i16;
        int i17;
        boolean z16;
        boolean z17;
        ?? r65;
        GLVideoView[] gLVideoViewArr;
        QLog.w(this.N, 1, "closeVideoView[" + str + "], index[" + i3 + "]");
        ImageView.ScaleType scaleType = ImageView.ScaleType.CENTER_INSIDE;
        int i18 = com.tencent.av.n.e().f().f73035i;
        if (i3 == 0) {
            i16 = this.f75271c0[0].E0();
            f16 = this.f75271c0[0].F0();
            i17 = this.f75271c0[0].x0();
            z16 = this.f75271c0[0].P0();
            if (i18 == 4) {
                scaleType = this.f75271c0[0].C0();
            }
        } else {
            f16 = 0.0f;
            i16 = 0;
            i17 = 0;
            z16 = false;
        }
        if (i18 == 4 && this.f75276h0.c() == 3) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            int i19 = i3 + 1;
            int i26 = -1;
            while (true) {
                gLVideoViewArr = this.f75271c0;
                if (i19 >= gLVideoViewArr.length) {
                    break;
                }
                if (gLVideoViewArr[i19].m() == 0) {
                    i26 = i19;
                }
                i19++;
            }
            if (i26 != -1) {
                int o16 = gLVideoViewArr[i3].o();
                this.f75271c0[i3].S(this.f75271c0[i26].o());
                this.f75271c0[i26].S(o16);
                GLVideoView[] gLVideoViewArr2 = this.f75271c0;
                GLVideoView gLVideoView = gLVideoViewArr2[i3];
                gLVideoViewArr2[i3] = gLVideoViewArr2[i26];
                gLVideoViewArr2[i26] = gLVideoView;
                gLVideoView.t1("");
            } else {
                i26 = i3;
            }
            GLVideoView gLVideoView2 = this.f75271c0[i26];
            gLVideoView2.R(1);
            gLVideoView2.u1(null);
            gLVideoView2.o1(true);
            r65 = 0;
            gLVideoView2.m0(false);
            gLVideoView2.i1(false);
            gLVideoView2.q0(true);
            gLVideoView2.h1(null, 0);
        } else {
            int i27 = i3;
            while (true) {
                GLVideoView[] gLVideoViewArr3 = this.f75271c0;
                if (i27 < gLVideoViewArr3.length) {
                    if (i27 >= gLVideoViewArr3.length - 1) {
                        break;
                    }
                    int i28 = i27 + 1;
                    if (gLVideoViewArr3[i28].m() != 0) {
                        break;
                    }
                    int o17 = this.f75271c0[i27].o();
                    this.f75271c0[i27].S(this.f75271c0[i28].o());
                    this.f75271c0[i28].S(o17);
                    GLVideoView[] gLVideoViewArr4 = this.f75271c0;
                    GLVideoView gLVideoView3 = gLVideoViewArr4[i27];
                    gLVideoViewArr4[i27] = gLVideoViewArr4[i28];
                    gLVideoViewArr4[i28] = gLVideoView3;
                    i27 = i28;
                } else {
                    r65 = 0;
                    break;
                }
            }
            GLVideoView gLVideoView4 = this.f75271c0[i27];
            gLVideoView4.R(1);
            gLVideoView4.u1(null);
            gLVideoView4.o1(true);
            r65 = 0;
            gLVideoView4.m0(false);
            gLVideoView4.i1(false);
            gLVideoView4.q0(true);
            gLVideoView4.h1(null, 0);
            gLVideoView4.t1("");
        }
        if (i3 == 0) {
            this.f75271c0[r65].w1(r65);
            this.f75271c0[r65].v1(i16);
            this.f75271c0[r65].y1(f16);
            this.f75271c0[r65].k1(i17);
            VideoAppInterface videoAppInterface = this.R;
            Object[] objArr = new Object[3];
            objArr[r65] = 9100;
            objArr[1] = Integer.valueOf((int) r65);
            objArr[2] = Boolean.valueOf(z16);
            videoAppInterface.k0(objArr);
            if (i18 == 4) {
                if (this.f75271c0[r65].H0() == 2) {
                    this.f75271c0[r65].q1(ImageView.ScaleType.CENTER_INSIDE);
                } else {
                    this.f75271c0[r65].q1(scaleType);
                }
            }
        }
        T0(r65);
    }

    private void c3(int i3, boolean z16) {
        if (this.f75199d1 == i3 && !z16) {
            return;
        }
        this.f75199d1 = i3;
        w3();
    }

    private void d2(ov.a aVar, com.tencent.av.opengl.ui.b bVar, boolean z16) {
        boolean z17;
        boolean z18;
        boolean z19 = true;
        if ((!bVar.b() && !bVar.i()) || (B2() && !z16 && !com.tencent.av.utils.af.A())) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (bVar.f().left - this.Y0 <= this.f75205j1.widthPixels && bVar.f().right - this.Y0 >= 0) {
            z18 = false;
        } else {
            z18 = true;
        }
        if (!z18 || z16) {
            z19 = false;
        }
        if (z17 && !z19) {
            float f16 = 0;
            aVar.k(f16, f16);
            bVar.C(aVar);
            float f17 = 0;
            aVar.k(f17, f17);
        }
    }

    private int f2() {
        Rect rect = this.V0;
        return rect.right - rect.left;
    }

    private Bitmap h2(am amVar) {
        if (amVar.f75349a == 0) {
            return com.tencent.av.r.h0().S(String.valueOf(amVar.f75350b), String.valueOf(com.tencent.av.n.e().f().P0), com.tencent.av.n.e().f().S0, true, false);
        }
        return ((BitmapDrawable) this.Q.getResources().getDrawable(R.drawable.dbo)).getBitmap();
    }

    private void h3(boolean z16) {
        GLVideoView[] gLVideoViewArr = this.f75271c0;
        GLVideoView gLVideoView = gLVideoViewArr[0];
        if (gLVideoView != null && gLVideoViewArr[1] != null) {
            gLVideoView.s1(z16);
            this.f75271c0[1].s1(z16);
        }
    }

    public static String i2(String str, int i3) {
        return str + "_" + i3;
    }

    private String j2(am amVar) {
        String str;
        if (amVar.f75349a == 0) {
            if (TextUtils.isEmpty(amVar.f75351c)) {
                return com.tencent.av.r.h0().U(String.valueOf(amVar.f75350b), String.valueOf(com.tencent.av.n.e().f().P0), com.tencent.av.n.e().f().S0);
            }
            return amVar.f75351c;
        }
        long j3 = amVar.f75350b;
        AVPhoneUserInfo aVPhoneUserInfo = amVar.f75354f;
        if (aVPhoneUserInfo == null) {
            aVPhoneUserInfo = com.tencent.av.r.h0().C(j3, com.tencent.av.n.e().f().f73061o1);
        }
        if (aVPhoneUserInfo != null && (str = aVPhoneUserInfo.telInfo.mobile) != null) {
            amVar.f75351c = str;
            String P = VideoAppInterface.N().P(aVPhoneUserInfo.telInfo.mobile);
            if (P == null) {
                return com.tencent.av.utils.ae.g(aVPhoneUserInfo.telInfo.mobile, 4);
            }
            return P;
        }
        if (aVPhoneUserInfo != null && QLog.isColorLevel()) {
            QLog.d(this.N, 2, "getMemmberName --> can not get Open Id. PhoneInfo = " + aVPhoneUserInfo);
        }
        return this.Q.getResources().getString(R.string.box);
    }

    private int k2() {
        return q2();
    }

    private void k3(int i3, int i16) {
        if (i3 == this.f75197b1 && i16 == this.f75198c1) {
            return;
        }
        if (i3 < i16) {
            this.f75197b1 = i3;
            this.f75198c1 = i16;
        } else {
            this.f75198c1 = 0;
            this.f75197b1 = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int l2() {
        return Math.max(this.f75200e1 - f2(), 0);
    }

    public static void l3(View view, boolean z16) {
        View findViewById;
        if (view == null || (findViewById = view.findViewById(R.id.a2c)) == null) {
            return;
        }
        if (z16) {
            findViewById.setVisibility(0);
        } else {
            findViewById.setVisibility(8);
        }
    }

    private boolean m3(int i3, int i16) {
        boolean z16;
        if (this.f75215t1 != 0 && System.currentTimeMillis() - this.f75215t1 < 1000) {
            QLog.w(this.N, 1, "sliderWindowBigToSmallAnimation, \u5927\u5c0f\u7a97\u6b63\u5728\u5207\u6362\u4e2d[" + this.f75215t1 + "]");
            return false;
        }
        GLVideoView gLVideoView = this.f75271c0[i16];
        gLVideoView.e1(Boolean.FALSE);
        gLVideoView.O(0, 0, 0, 0);
        if (this.f75211p1 && i3 == this.f75212q1 && i16 == this.f75213r1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            l1("sliderWindowBigToSmallAnimation", i3, i16);
        } else {
            this.f75211p1 = false;
        }
        p();
        this.f75215t1 = System.currentTimeMillis();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public an p2() {
        if (this.f75208m1 == null && !M0()) {
            this.f75208m1 = new an(this);
        }
        return this.f75208m1;
    }

    private int q2() {
        int i3 = 0;
        for (GLVideoView gLVideoView : this.f75271c0) {
            String G0 = gLVideoView.G0();
            if (gLVideoView.m() == 0 && !TextUtils.isEmpty(G0)) {
                i3++;
            }
        }
        return i3;
    }

    private am q3(long j3) {
        am amVar = this.f75210o1.get(Long.valueOf(j3));
        if (amVar == null) {
            am amVar2 = new am();
            amVar2.f75350b = j3;
            this.f75210o1.put(Long.valueOf(j3), amVar2);
            return amVar2;
        }
        return amVar;
    }

    private boolean r2(int i3, int i16) {
        if (this.f75215t1 != 0 && System.currentTimeMillis() - this.f75215t1 < 1000) {
            QLog.w(this.N, 1, "bigWindowToSmallWindowAnim, \u5927\u5c0f\u7a97\u6b63\u5728\u5207\u6362\u4e2d[" + this.f75215t1 + "]");
            return false;
        }
        GLVideoView[] gLVideoViewArr = this.f75271c0;
        GLVideoView gLVideoView = gLVideoViewArr[i3];
        GLVideoView gLVideoView2 = gLVideoViewArr[i16];
        Boolean bool = Boolean.FALSE;
        gLVideoView.e1(bool);
        gLVideoView.O(0, 0, 0, 0);
        gLVideoView2.e1(bool);
        gLVideoView2.O(0, 0, 0, 0);
        int o16 = gLVideoView2.o();
        gLVideoView2.S(gLVideoView.o());
        Rect f16 = gLVideoView2.f();
        Rect f17 = gLVideoView.f();
        sv.a aVar = new sv.a();
        aVar.o(300);
        aVar.s(f16.left, f16.top, 0.0f, f17.left, f17.top, 0.0f);
        aVar.q(f16.width(), f16.height(), f17.width(), f17.height());
        aVar.n(new e(i16, o16, i3));
        aVar.r(2);
        gLVideoView2.T(aVar);
        gLVideoView2.p();
        this.f75215t1 = System.currentTimeMillis();
        return true;
    }

    private void t2() {
        i iVar = new i(this.V);
        this.f75218w1 = iVar;
        ViewCompat.setAccessibilityDelegate(this.V, iVar);
    }

    private void u2() {
        Object parent = this.S.getParent();
        if (parent instanceof View) {
            this.f75269a0 = (ViewGroup) ((View) parent).findViewById(R.id.t0d);
        }
    }

    private void u3(int i3, boolean z16) {
        if (!z16 && i3 == this.Y0) {
            return;
        }
        this.Y0 = i3;
        int l26 = l2();
        if (this.Y0 > l26 && this.f75202g1.e()) {
            this.f75202g1.h(this.Y0);
            this.Y0 = l26;
        }
        c3(this.Y0, z16);
    }

    private void w2() {
        int i3;
        if (com.tencent.av.r.h0() != null && com.tencent.av.n.e().f().f73067q == 1008) {
            i3 = R.drawable.dbb;
        } else {
            i3 = R.drawable.d_0;
        }
        this.f75271c0[0].H(ba.getBitmapFromResourceId(this.Q, i3));
        super.H(ba.getBitmapFromResourceId(this.Q, i3));
    }

    private void w3() {
        int max = Math.max(0, this.f75199d1 / (this.H0 + this.J0));
        k3(max, Math.min(k2() - 1, ((int) Math.ceil(((f2() - (((max + 1) * (this.H0 + this.J0)) - r0)) * 1.0f) / (this.H0 + this.J0))) + max));
    }

    private void x2() {
        this.f75294z0 = ea.U0(this.Q).getInt("video_position", 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x3(final GLVideoView gLVideoView, float f16, long j3) {
        final long j16 = j3 / 10;
        final float pow = (float) Math.pow(f16, 1.0d / j16);
        A(new Runnable() { // from class: com.tencent.av.ui.VideoLayerUI.8

            /* renamed from: d, reason: collision with root package name */
            long f75221d = 0;

            @Override // java.lang.Runnable
            public void run() {
                long j17 = this.f75221d;
                this.f75221d = 1 + j17;
                if (j17 < j16) {
                    gLVideoView.p1(pow, VideoLayerUI.this.S0, VideoLayerUI.this.T0);
                    gLVideoView.B(this, 10L);
                } else {
                    gLVideoView.A1(0, 0, true);
                    VideoLayerUI.this.S0 = -1;
                    VideoLayerUI.this.T0 = -1;
                }
            }
        });
    }

    private void y2(GLVideoView gLVideoView, String str, int i3) {
        if (gLVideoView != null) {
            gLVideoView.h1(str, i3);
            gLVideoView.R(0);
            gLVideoView.t1(this.R.getCurrentAccountUin());
        }
    }

    private void z2() {
        if (this.f75272d0 != null) {
            return;
        }
        this.f75205j1 = new DisplayMetrics();
        ((Activity) this.Q).getWindowManager().getDefaultDisplay().getRealMetrics(this.f75205j1);
        int dimensionPixelSize = this.Q.getResources().getDimensionPixelSize(R.dimen.a8x);
        this.J0 = dimensionPixelSize;
        DisplayMetrics displayMetrics = this.f75205j1;
        int i3 = (displayMetrics.widthPixels - (dimensionPixelSize * 5)) / 4;
        this.H0 = i3;
        this.I0 = i3;
        int i16 = displayMetrics.heightPixels;
        if (ScreenUtil.checkNavigationBarShow(this.Q)) {
            i16 -= ScreenUtil.getNavigationBarHeight(this.Q);
        }
        int dimensionPixelSize2 = i16 - this.Q.getResources().getDimensionPixelSize(R.dimen.b26);
        this.V0 = new Rect(0, dimensionPixelSize2 - this.I0, this.f75205j1.widthPixels, dimensionPixelSize2);
        this.f75201f1 = new GestureDetector(this.Q, new j());
        com.tencent.av.opengl.ui.f fVar = new com.tencent.av.opengl.ui.f(this.Q);
        this.f75202g1 = fVar;
        fVar.g(true);
        this.f75202g1.f((int) ba.dp2px(this.Q, 50.0f));
        GLVideoView gLVideoView = new GLVideoView(this.Q, this.R, String.format("%s_%s", this.N, 1000), com.tencent.av.r.h0().q0());
        this.f75272d0 = gLVideoView;
        gLVideoView.R(1);
        this.f75272d0.t1(this.R.getCurrentAccountUin());
        this.f75272d0.h1("null", 1);
        this.f75272d0.L(true);
        this.f75272d0.r1(false);
        this.f75272d0.w1(false);
        this.f75272d0.x1(true);
        this.f75272d0.y1(BaseAIOUtils.f(16.0f, this.Q.getResources()));
        this.f75272d0.C1(true);
        this.f75272d0.I(Color.parseColor("#686E6C"));
        this.f75272d0.Q(2, Boolean.FALSE);
        this.f75272d0.S(999);
        X(this.f75272d0);
    }

    public boolean B2() {
        if (e2() != null && e2().I0 != null) {
            return !e2().I0.I();
        }
        return false;
    }

    boolean D2() {
        if (tv.c.c(this.Q) == 2) {
            return true;
        }
        return false;
    }

    public void E2(long j3, Boolean bool) {
        if (!D2()) {
            return;
        }
        this.O = true;
        T2(j3, bool);
    }

    boolean F2() {
        Context context = this.Q;
        boolean z16 = false;
        if (context instanceof AVActivity) {
            boolean x36 = ((AVActivity) context).x3();
            boolean z17 = !Q0();
            if (x36 && z17) {
                z16 = true;
            }
            AVCoreLog.printColorLog(this.N, "SwitchLocalToBigView:" + x36 + "|" + z17);
        }
        return z16;
    }

    public void G2(ArrayList<com.tencent.av.e> arrayList) {
        if (QLog.isDevelopLevel()) {
            QLog.w(this.N, 1, "notifyAudioMemberChange");
        }
        an p26 = p2();
        if (p26 != null) {
            p26.g(arrayList);
        }
    }

    @Override // com.tencent.av.ui.VideoLayerUIBase
    protected void H0() {
        super.H0();
        if (this.W != null) {
            if (this.f75217v1 == null) {
                this.f75217v1 = new f();
            }
            this.W.setOnTouchListener(this.f75217v1);
            this.W.setTextureParam(new AVFilamentTextureView.FilamentTextureParam(false, Boolean.TRUE));
        }
    }

    public void H2(long j3, boolean z16) {
        if (QLog.isDevelopLevel()) {
            QLog.w(this.N, 1, "notifyAudioMemberChange");
        }
        int i3 = 2;
        if ((com.tencent.av.n.e().f().S0 == 1 && com.tencent.av.n.e().f().f73063p == 10) || com.tencent.av.n.e().f().S0 == 2) {
            am q36 = q3(j3);
            q36.f75353e = z16;
            boolean z17 = q36.f75355g;
            if (!z17) {
                if (!q36.f()) {
                    i3 = 3;
                }
            } else {
                i3 = z17 ? 1 : 0;
            }
            W2(j3, i3);
            an p26 = p2();
            if (p26 != null && p26.h(j3, z16)) {
                p();
            }
        }
    }

    @Override // com.tencent.av.ui.VideoLayerUIBase
    protected void I0() {
        super.I0();
        this.V.post(new Runnable() { // from class: com.tencent.av.ui.VideoLayerUI.1
            @Override // java.lang.Runnable
            public void run() {
                GLRootView gLRootView = VideoLayerUI.this.V;
                if (gLRootView == null) {
                    return;
                }
                int height = gLRootView.getHeight();
                int width = VideoLayerUI.this.V.getWidth();
                if (height != 0 && width != 0) {
                    int dimensionPixelSize = VideoLayerUI.this.Q.getResources().getDimensionPixelSize(R.dimen.b26);
                    VideoLayerUI videoLayerUI = VideoLayerUI.this;
                    int i3 = height - dimensionPixelSize;
                    VideoLayerUI videoLayerUI2 = VideoLayerUI.this;
                    videoLayerUI.V0 = new Rect(0, i3 - videoLayerUI2.I0, videoLayerUI2.f75205j1.widthPixels, i3);
                    VideoLayerUI.this.T0(true);
                    QLog.w(VideoLayerUI.this.N, 1, "initGlRootView mSlideWindowAreas init end");
                }
            }
        });
    }

    public void I2(long j3, int i3, int i16, boolean z16) {
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        if (QLog.isDevelopLevel()) {
            QLog.w(this.N, 1, "notifyControlUIOffset, mTopOffset[" + this.T + "->" + i3 + "], mBottomOffset[" + this.U + "->" + i16 + "], mFullScreen[" + this.M0 + "->" + z16 + "], seq[" + j3 + "]");
        }
        this.M0 = z16;
        this.T = i3;
        this.U = i16;
        T0(true);
        if (com.tencent.av.n.e().f().f73035i == 4) {
            int i17 = 1;
            while (true) {
                GLVideoView[] gLVideoViewArr = this.f75271c0;
                if (i17 >= gLVideoViewArr.length) {
                    break;
                }
                gLVideoViewArr[i17].C1(true);
                i17++;
            }
            if (com.tencent.av.n.e().f().f73045k1.size() <= 1) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (com.tencent.av.n.e().f().O1 == 4) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (e2() != null && e2().I0.I()) {
                z19 = true;
            } else {
                z19 = false;
            }
            if (!z19 && (!z17 || !z18)) {
                z26 = false;
            } else {
                z26 = true;
            }
            this.R.k0(new Object[]{9100, 0, Boolean.valueOf(z26)});
        }
    }

    protected void J2(Integer num, Object obj) {
        AVCoreLog.printColorLog(this.N, "notifyEvent :" + num + "|" + obj);
        this.R.k0(new Object[]{num, obj});
    }

    public void K2(long j3, int i3, long j16, int i16) {
        this.f75212q1 = w0("notifyGLVideoViewChange", String.valueOf(j3), i3);
        int w06 = w0("notifyGLVideoViewChange", String.valueOf(j16), i16);
        this.f75213r1 = w06;
        int i17 = this.f75212q1;
        this.f75211p1 = true;
        if (i17 >= 0 && w06 >= 0) {
            l1("notifyGLVideoViewChange", i17, w06);
        }
    }

    public void L2(boolean z16) {
        com.tencent.av.utils.c.a("switch_camera", "onCameraSwitched", 3, new Object[0]);
        if (QLog.isColorLevel()) {
            QLog.d(this.N, 2, "onCameraSwitched isFrontCamera: " + z16);
        }
        String currentAccountUin = this.R.getCurrentAccountUin();
        int w06 = w0("onCameraSwitched", currentAccountUin, 1);
        if (w06 >= 0) {
            NtrtcVideoRender.getInstance().clearCameraFrames();
            NtrtcVideoRender.getInstance().flushGlRender(currentAccountUin + "_1");
            this.f75271c0[w06].c1(false);
            this.f75214s1 = new c(w06, z16);
            com.tencent.av.r.h0().I().n(true, this.f75214s1);
        }
        if (com.tencent.av.n.e().f().f73035i == 4) {
            if (com.tencent.av.n.e().f().f73067q == 3000) {
                if (z16) {
                    ReportController.o(null, "CliOper", "", "", "0X80041B5", "0X80041B5", 0, 0, "", "", "", "");
                } else {
                    ReportController.o(null, "CliOper", "", "", "0X80041B4", "0X80041B4", 0, 0, "", "", "", "");
                }
            } else if (com.tencent.av.n.e().f().f73067q == 1) {
                if (z16) {
                    if (com.tencent.av.n.e().f().f73063p == 10) {
                        ReportController.o(null, "CliOper", "", "", "0X800593B", "0X800593B", 0, 0, "", "", "", "");
                    } else {
                        ReportController.o(null, "CliOper", "", "", "0X80046E2", "0X80046E2", 0, 0, "", "", "", "");
                    }
                } else if (com.tencent.av.n.e().f().f73063p == 10) {
                    ReportController.o(null, "CliOper", "", "", "0X800593A", "0X800593A", 0, 0, "", "", "", "");
                } else {
                    ReportController.o(null, "CliOper", "", "", "0X80046E1", "0X80046E1", 0, 0, "", "", "", "");
                }
            }
        }
        if (com.tencent.av.n.e().f().f73060o0) {
            if (z16) {
                ReportController.o(null, "CliOper", "", "", "0X8005211", "0X8005211", 0, 0, "", "", "", "");
            } else {
                ReportController.o(null, "CliOper", "", "", "0X8005210", "0X8005210", 0, 0, "", "", "", "");
            }
        }
    }

    public void M2(int i3) {
        boolean z16;
        boolean z17;
        if (this.f75276h0 != null && VideoLayerUIBase.O0(com.tencent.av.n.e().f())) {
            boolean z18 = true;
            if (i3 != 2) {
                z16 = true;
            } else {
                z16 = false;
            }
            T0(z16);
            if (i3 != 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            h3(z17);
            ICameraManagerApi a16 = com.tencent.av.camera.b.a(this.Q);
            if (i3 == 0) {
                z18 = false;
            }
            a16.setCameraSensorMode(z18);
        }
        this.f75219x1 = i3;
    }

    public void N2() {
        GLRootView gLRootView = this.V;
        if (gLRootView != null) {
            gLRootView.onResume();
        }
    }

    void O2(long j3, String str, int i3, boolean z16, boolean z17) {
        boolean z18;
        boolean z19;
        boolean z26;
        boolean z27;
        Context context = this.Q;
        AVActivity aVActivity = (AVActivity) context;
        if (x.g(context) && !com.tencent.av.n.e().f().F()) {
            aVActivity.handleVideoCountChangeLayout(true, com.tencent.av.n.e().f().N);
        }
        int w06 = w0("openPeerVideo, seq[" + j3 + "]", str, i3);
        if (VideoLayerUIBase.O0(com.tencent.av.n.e().f())) {
            boolean z28 = (z16 || Q0()) ? z16 : true;
            if (w06 > 1) {
                SmallScreenUtils.m();
                QLog.e(this.N, 1, "SetGlRender index break!!!!!! index=" + w06 + ", remotehasvideo=" + com.tencent.av.n.e().f().O);
                return;
            }
            z18 = z28;
        } else {
            z18 = z16;
        }
        String i26 = i2(str, i3);
        GLVideoView gLVideoView = null;
        if (w06 < 0) {
            int C0 = C0(0);
            if (C0 >= 0) {
                GLVideoView gLVideoView2 = this.f75271c0[C0];
                v2(j3, gLVideoView2, str, i3, true);
                gLVideoView = gLVideoView2;
            }
            if (gLVideoView != null && com.tencent.av.n.e().f().f73045k1.size() <= 1 && com.tencent.av.n.e().f().f73035i == 4) {
                gLVideoView.y1(BaseAIOUtils.f(18.0f, this.Q.getResources()));
            }
            w06 = C0;
            z19 = C0 > 1 && com.tencent.av.n.e().f().f73035i == 4;
        } else {
            GLVideoView gLVideoView3 = this.f75271c0[w06];
            YUVTexture I0 = gLVideoView3 == null ? null : gLVideoView3.I0();
            NtrtcVideoRender.getInstance().setGlRender(i26, I0 != null ? I0.S() : null);
            String str2 = this.N;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("setGlRender[openPeerVideo], key[");
            sb5.append(LogUtil.getSafePrintUin(str));
            sb5.append("_");
            sb5.append(i3);
            sb5.append("], seq[");
            sb5.append(j3);
            sb5.append("], index[");
            sb5.append(w06);
            sb5.append("], ");
            sb5.append(gLVideoView3 == null ? "" : gLVideoView3.t0());
            QLog.w(str2, 1, sb5.toString());
            com.tencent.av.r.h0().P2(j3, com.tencent.av.n.e().f().f73035i, false, true);
            z19 = false;
            gLVideoView = gLVideoView3;
        }
        if (gLVideoView != null) {
            if (com.tencent.av.n.e().f().f73045k1.size() > 1) {
                z26 = z17;
                z27 = true;
            } else {
                z26 = z17;
                z27 = false;
            }
            gLVideoView.i1(z26);
            gLVideoView.m1(j3, this.f75276h0.d());
            gLVideoView.m0(!z16);
            gLVideoView.R(0);
            if (com.tencent.av.n.e().f().f73035i == 4) {
                if (w06 == 0) {
                    gLVideoView.q1(ImageView.ScaleType.CENTER_INSIDE);
                    if (com.tencent.av.n.e().f().O1 == 3) {
                        gLVideoView.w1(z27);
                    }
                } else {
                    gLVideoView.q1(ImageView.ScaleType.CENTER_CROP);
                }
            } else if (com.tencent.av.n.e().f().f73035i == 2) {
                if (com.tencent.av.n.e().f().O1 == 8) {
                    gLVideoView.q1(ImageView.ScaleType.CENTER_CROP);
                } else {
                    gLVideoView.q1(ImageView.ScaleType.CENTER_INSIDE);
                }
            }
        }
        if (z18 && w06 > 0 && !F2() && (com.tencent.av.n.e().f().f73035i != 2 || com.tencent.av.n.e().f().M)) {
            p3(0, w06);
        }
        if (z19) {
            n3(w06);
        }
    }

    public void P2(long j3) {
        YUVTexture I0;
        String t06;
        VideoAppInterface videoAppInterface = this.R;
        boolean z16 = true;
        if (videoAppInterface == null) {
            QLog.e(this.N, 1, "openSelfRender ERROR: app is null.");
            return;
        }
        String currentAccountUin = videoAppInterface.getCurrentAccountUin();
        int w06 = w0("openSelfVideo", currentAccountUin, 1);
        NtrtcVideoRenderTexture ntrtcVideoRenderTexture = null;
        GLVideoView gLVideoView = null;
        if (w06 < 0) {
            int C0 = C0(0);
            if (C0 >= 0) {
                GLVideoView gLVideoView2 = this.f75271c0[C0];
                v2(j3, gLVideoView2, currentAccountUin, 1, false);
                gLVideoView = gLVideoView2;
            }
            if (C0 == 0 && gLVideoView != null && com.tencent.av.n.e().f().f73035i == 4) {
                gLVideoView.w1(false);
            }
        } else {
            String i26 = i2(currentAccountUin, 1);
            GLVideoView gLVideoView3 = this.f75271c0[w06];
            if (gLVideoView3 == null) {
                I0 = null;
            } else {
                I0 = gLVideoView3.I0();
            }
            if (I0 != null) {
                ntrtcVideoRenderTexture = I0.S();
            }
            NtrtcVideoRender.getInstance().setGlRender(i26, ntrtcVideoRenderTexture);
            String str = this.N;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("setGlRender[openSelfVideo], key[");
            sb5.append(LogUtil.getSafePrintUin(currentAccountUin));
            sb5.append("_");
            sb5.append(1);
            sb5.append("], index[");
            sb5.append(w06);
            sb5.append("], forceToBigView[");
            sb5.append(false);
            sb5.append("], ");
            if (gLVideoView3 == null) {
                t06 = "";
            } else {
                t06 = gLVideoView3.t0();
            }
            sb5.append(t06);
            QLog.w(str, 1, sb5.toString());
            gLVideoView = gLVideoView3;
        }
        if (gLVideoView != null) {
            if (com.tencent.av.camera.b.a(this.Q).isCameraOpened(j3)) {
                gLVideoView.m1(j3, com.tencent.av.camera.b.a(this.Q).isFrontCamera());
            }
            gLVideoView.i1(false);
            gLVideoView.m0(false);
            if (com.tencent.av.n.e().f().f73098x2 || com.tencent.av.n.e().f().f73102y2) {
                z16 = false;
            }
            gLVideoView.o1(z16);
            gLVideoView.R(0);
            gLVideoView.q1(ImageView.ScaleType.CENTER_CROP);
        }
    }

    public void Q2(Boolean bool) {
        String currentAccountUin = this.R.getCurrentAccountUin();
        R2();
        int w06 = w0("openSelfScreenShare", currentAccountUin, 2);
        if (bool.booleanValue() && w06 > 0) {
            p3(0, w06);
        }
    }

    boolean R1() {
        int i3;
        if (this.f75276h0.c() == 1) {
            return true;
        }
        if ((this.U == 0 || (i3 = this.T) == 0 || i3 == this.G0 || this.M0) && this.f75276h0.c() != 6 && this.f75276h0.c() != 7 && this.f75276h0.c() != 8) {
            return true;
        }
        return false;
    }

    public void R2() {
        GLVideoView gLVideoView;
        String currentAccountUin = this.R.getCurrentAccountUin();
        int w06 = w0("openSelfScreenShareRender", currentAccountUin, 2);
        if (w06 < 0) {
            w06 = C0(0);
            if (w06 >= 0) {
                gLVideoView = this.f75271c0[w06];
                y2(gLVideoView, currentAccountUin, 2);
            } else {
                gLVideoView = null;
            }
            if (w06 == 0 && gLVideoView != null && com.tencent.av.n.e().f().f73035i == 4) {
                gLVideoView.w1(false);
            }
        } else {
            String i26 = i2(currentAccountUin, 2);
            gLVideoView = this.f75271c0[w06];
            if (QLog.isDebugVersion() && gLVideoView != null) {
                QLog.w(this.N, 1, "setGlRender[openSelfScreenShareRender], key[" + i26 + "], index[" + w06 + "], forceToBigView[false], " + gLVideoView.t0());
            }
        }
        QLog.w(this.N, 1, "setGlRender[openSelfScreenShareRender], index:=" + w06);
        if (gLVideoView != null) {
            gLVideoView.i1(false);
            gLVideoView.m0(false);
            gLVideoView.o1(true);
            gLVideoView.R(0);
            gLVideoView.q1(ImageView.ScaleType.CENTER_CROP);
        }
    }

    void S2(long j3, Boolean bool) {
        ThreadManagerV2.post(this.f75290v0, 8, null, false);
        T2(j3, bool);
    }

    @Override // com.tencent.av.ui.VideoLayerUIBase
    public void T0(boolean z16) {
        int n3 = super.n();
        int h16 = super.h();
        SessionInfo f16 = com.tencent.av.n.e().f();
        if (VideoLayerUIBase.O0(f16)) {
            this.f75276h0.h(this.f75271c0, n3, h16, this.f75294z0, this.T, this.U, !f16.G);
        } else if (VideoLayerUIBase.R0(f16)) {
            this.f75276h0.j(this.U, this.V0, this.W0, this.f75210o1);
            this.f75276h0.i(f16, this.f75271c0, n3, h16, z16, this.A0, this.U);
        }
        super.p();
    }

    public void T1(int i3) {
        int w06 = w0("enableAvatar2D", com.tencent.av.n.e().f().f73091w, 1);
        if (w06 >= 0) {
            if (i3 != 6 && i3 != 8 && i3 != 9) {
                this.f75271c0[w06].q1(ImageView.ScaleType.CENTER_INSIDE);
            } else {
                this.f75271c0[w06].q1(ImageView.ScaleType.CENTER_CROP);
            }
        }
    }

    @Override // com.tencent.av.ui.VideoLayerUIBase
    public void V0() {
        x xVar;
        String str;
        if (this.f75214s1 != null) {
            com.tencent.av.r.h0().I().l();
            this.f75214s1 = null;
        }
        VideoAppInterface videoAppInterface = this.R;
        if (videoAppInterface != null) {
            videoAppInterface.M().removeCallbacks(this.K0);
        }
        M(null);
        this.P0 = null;
        this.F0 = null;
        this.Q0 = null;
        this.R0 = null;
        this.K0 = null;
        this.f75201f1 = null;
        this.f75202g1 = null;
        this.f75216u1 = null;
        this.f75218w1 = null;
        this.f75205j1 = null;
        this.V0 = null;
        this.W0 = null;
        int i3 = this.f75207l1;
        boolean z16 = true;
        if (i3 != -1 && i3 != 2 && i3 != 1) {
            z16 = false;
        }
        if (!z16 && (xVar = this.f75276h0) != null) {
            if (xVar.c() == 3) {
                str = "1";
            } else {
                str = "2";
            }
            ReportController.o(null, "CliOper", "", "", "0X8009F5D", "0X8009F5D", 0, 0, str, "", "", "");
        }
        x xVar2 = this.f75276h0;
        if (xVar2 != null) {
            xVar2.k();
            this.f75276h0 = null;
        }
        V1();
        an anVar = this.f75208m1;
        if (anVar != null) {
            anVar.b();
            this.f75208m1 = null;
        }
        this.f75210o1.clear();
        this.X0.clear();
        ak akVar = this.f75209n1;
        if (akVar != null) {
            akVar.d();
            this.f75209n1 = null;
        }
        super.V0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void V2(long j3, boolean z16) {
        if ((com.tencent.av.n.e().f().S0 == 1 && com.tencent.av.n.e().f().f73063p == 10) || com.tencent.av.n.e().f().S0 == 2) {
            am q36 = q3(j3);
            q36.f75355g = z16;
            int i3 = z16;
            if (z16 == 0) {
                if (q36.f()) {
                    i3 = 2;
                } else {
                    i3 = 3;
                }
            }
            W2(j3, i3);
            an p26 = p2();
            if (p26 != null && p26.f()) {
                p();
            }
        }
    }

    public void W1(long j3, String str, int i3) {
        int w06 = w0("closePeerVideo", str, i3);
        if (w06 >= 0) {
            String i26 = i2(str, i3);
            NtrtcVideoRender.getInstance().flushGlRender(i26);
            NtrtcVideoRender.getInstance().setGlRender(i26, null);
            QLog.w(this.N, 1, "setGlRender[closePeerVideo_no], key[" + LogUtil.getSafePrintUin(str) + "_" + i3 + "], index[" + w06 + "], seq[" + j3 + "]");
            com.tencent.av.r.h0().P2(j3, com.tencent.av.n.e().f().f73035i, true, true);
            b2("closePeerVideo", w06);
        }
    }

    public void X1() {
        int w06 = w0("closeSelfRender", this.R.getCurrentAccountUin(), 1);
        if (w06 >= 0) {
            b2("closeSelfRender", w06);
        }
    }

    public void Y1(long j3) {
        String currentAccountUin = this.R.getCurrentAccountUin();
        int w06 = w0("closeSelfScreenShare", currentAccountUin, 2);
        if (w06 >= 0) {
            String i26 = i2(LogUtil.getSafePrintUin(currentAccountUin), 2);
            QLog.w(this.N, 1, "setGlRender[closeSelfVideo_no], key[" + i26 + "], index[" + w06 + "], seq[" + j3 + "]");
            Z1();
        }
    }

    @Override // com.tencent.av.ui.VideoLayerUIBase
    protected void Z0(ov.a aVar, boolean z16) {
        if (C2()) {
            X2(aVar);
            return;
        }
        this.f74132o = 0;
        this.f74131n = 0;
        this.Y0 = 0;
        this.Z0 = 0;
        super.Z0(aVar, z16);
    }

    public void Z1() {
        int w06 = w0("closeSelfScreenShareRender", this.R.getCurrentAccountUin(), 2);
        if (w06 >= 0) {
            b2("closeSelfScreenShareRender", w06);
        }
    }

    public void Z2() {
        ThreadManagerV2.post(this.f75290v0, 8, null, false);
    }

    public void a2(long j3) {
        ThreadManagerV2.post(this.f75291w0, 8, null, false);
        String currentAccountUin = this.R.getCurrentAccountUin();
        int w06 = w0("closeSelfVideo", currentAccountUin, 1);
        if (w06 >= 0) {
            String i26 = i2(currentAccountUin, 1);
            NtrtcVideoRender.getInstance().flushGlRender(i26);
            NtrtcVideoRender.getInstance().clearCameraFrames();
            NtrtcVideoRender.getInstance().setGlRender(i26, null);
            QLog.w(this.N, 1, "setGlRender[closeSelfVideo_no], key[" + LogUtil.getSafePrintUin(currentAccountUin) + "_1], index[" + w06 + "], seq[" + j3 + "]");
            com.tencent.av.r.h0().P2(j3, com.tencent.av.n.e().f().f73035i, true, false);
            X1();
        }
    }

    public void a3(VideoUtil.AnimationTrigger animationTrigger) {
        this.N0 = animationTrigger;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x005a, code lost:
    
        if (r0 > 0) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b3(long j3, String str, int i3, Bitmap bitmap, boolean z16, boolean z17) {
        boolean z18;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        int w06 = w0("setBackground", str, i3);
        if (w06 < 0) {
            int C0 = C0(0);
            z18 = true;
            if (C0 >= 0) {
                boolean z19 = !str.equals(this.R.getCurrentAccountUin());
                GLVideoView gLVideoView = this.f75271c0[C0];
                v2(j3, gLVideoView, str, i3, z19);
                if (gLVideoView != null && !z19) {
                    gLVideoView.m1(j3, com.tencent.av.camera.b.a(this.Q).isFrontCamera());
                }
            }
            if (z17 && C0 > 0) {
                p3(0, C0);
                w06 = 0;
            } else {
                w06 = C0;
            }
        }
        z18 = false;
        if (w06 >= 0) {
            GLVideoView gLVideoView2 = this.f75271c0[w06];
            gLVideoView2.H(bitmap);
            gLVideoView2.o1(z16);
            if (!z16) {
                gLVideoView2.m0(false);
            }
        }
        if (z18) {
            n3(w06);
        }
        if (QLog.isColorLevel()) {
            QLog.d(this.N, 2, "setBackground uin: " + str + ", videoSrcType: " + i3 + ", index: " + w06 + ", needRenderVideo: " + z16);
        }
    }

    public boolean c2(MotionEvent motionEvent) {
        i iVar = this.f75218w1;
        if (iVar != null && iVar.dispatchHoverEvent(motionEvent)) {
            return true;
        }
        return false;
    }

    public void d3(int i3) {
        this.f75220y1 = i3;
    }

    @Override // com.tencent.av.ui.VideoLayerUIBase
    public void e1(int i3, boolean z16) {
        if (!this.O && !S0()) {
            this.f75293y0 = i3;
            return;
        }
        int i16 = this.f75292x0;
        if (i3 == i16 && i3 != this.f75293y0) {
            return;
        }
        boolean z17 = false;
        if (i3 % 90 != i16 % 90) {
            this.f75273e0 = 0;
        }
        this.f75292x0 = i3;
        this.f75293y0 = i3;
        int O1 = O1(this.N, this.Q, i3, z16, this.B0);
        if (i3 == 0 || i3 == 90 || i3 == 180 || i3 == 270) {
            for (int i17 = 0; i17 < super.e0(); i17++) {
                super.d0(i17).P(O1);
            }
            this.A0 = O1;
        }
        if (com.tencent.av.n.e().f().f73063p == 2) {
            int i18 = this.A0;
            if (i18 == 0 || i18 == 180) {
                z17 = true;
            }
            T0(z17);
        }
    }

    AVActivity e2() {
        Context context = this.Q;
        if (context instanceof AVActivity) {
            return (AVActivity) context;
        }
        return null;
    }

    public boolean e3(long j3, boolean z16, boolean z17) {
        if (!D2()) {
            return false;
        }
        if (z16) {
            Q2(Boolean.valueOf(z17));
        } else {
            Y1(j3);
        }
        this.P = z16;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.av.opengl.ui.c
    public void f0(ov.a aVar) {
        super.f0(aVar);
    }

    @Override // com.tencent.av.ui.VideoLayerUIBase
    protected void f1(int i3) {
        this.f75276h0.l(this.f75271c0, i3, n(), h(), this.T, this.U);
    }

    public boolean f3(long j3, boolean z16, boolean z17) {
        if (!D2()) {
            return false;
        }
        if (z16) {
            S2(j3, Boolean.valueOf(z17));
        } else {
            a2(j3);
        }
        this.O = z16;
        return true;
    }

    public int g2() {
        return this.f75219x1;
    }

    public void g3(long j3, String str, int i3, boolean z16, boolean z17, boolean z18) {
        if (QLog.isColorLevel()) {
            QLog.w(this.N, 1, "setRemoteHasVideo, uin[" + str + "], videoSrcType[" + i3 + "], isRemoteHasVideo[" + z16 + "], forceToBigView[" + z17 + "], mIsLocalHasVideo[" + this.O + "], isFillBlackEdge[" + z18 + "], seq[" + j3 + "]");
        }
        if (!TextUtils.isEmpty(str) && !str.equals(this.R.getCurrentAccountUin()) && D2()) {
            r0();
            if (z16) {
                O2(j3, str, i3, z17, z18);
            } else {
                W1(j3, str, i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x009f, code lost:
    
        if (r0 != 0) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void i3(String str, int i3, String str2, float f16, int i16) {
        int w06 = w0(IECSearchBar.METHOD_SET_TEXT, str, i3);
        boolean z16 = true;
        if (QLog.isColorLevel()) {
            QLog.w(this.N, 1, "setText, uin[" + str + "], videoSrcType[" + i3 + "], textSize[" + f16 + "], textColor[" + i16 + "], index[" + w06 + "]");
        }
        if (w06 >= 0) {
            GLVideoView gLVideoView = this.f75271c0[w06];
            gLVideoView.R(0);
            gLVideoView.u1(str2);
            gLVideoView.y1(f16);
            gLVideoView.v1(i16);
            if (w06 == 0 && e2() != null) {
                e2().I0.J0(str2);
            }
            if (o2() == 3) {
                if (w06 <= 0 && com.tencent.av.n.e().f().f73045k1.size() <= 1) {
                    gLVideoView.y1(BaseAIOUtils.f(18.0f, this.Q.getResources()));
                    z16 = false;
                }
                gLVideoView.w1(z16);
                if (w06 == 0) {
                    if (com.tencent.av.n.e().f().f73063p == 2) {
                        gLVideoView.u1("");
                        return;
                    } else {
                        gLVideoView.k1(12);
                        return;
                    }
                }
                if (VideoLayerUIBase.R0(com.tencent.av.n.e().f())) {
                    gLVideoView.k1(12);
                } else {
                    gLVideoView.k1(Integer.MAX_VALUE);
                }
            }
        }
    }

    public boolean j3(String str, String str2) {
        int w06 = w0("setVideoToBigView", str2, 1);
        boolean z16 = false;
        if (w06 > 0) {
            z16 = p3(0, w06);
        }
        if (QLog.isDevelopLevel()) {
            QLog.d(this.N, 1, "setVideoToBigView[" + str + "], uin[" + str2 + "], index[" + w06 + "], bRet[" + z16 + "]");
        }
        return z16;
    }

    @Override // com.tencent.av.ui.VideoLayerUIBase
    public void m0(int i3) {
        char c16;
        boolean z16;
        long d16 = com.tencent.av.utils.e.d();
        QLog.w(this.N, 1, "changeLayoutMode, screenStyle[" + com.tencent.av.n.e().f().O1 + "->" + i3 + "], ScreenLayout[" + this.f75276h0.c() + "->" + i3 + "], seq[" + d16 + "]");
        if (VideoLayerUIBase.R0(com.tencent.av.n.e().f()) && i3 == 1) {
            QLog.d(this.N, 1, "changeLayoutMode with error happen", new Throwable());
        }
        super.m0(i3);
        int c17 = this.f75276h0.c();
        if (c17 != i3) {
            this.U0 = true;
            x b16 = x.b(this.Q, this.R, i3, false);
            this.f75276h0 = b16;
            if (b16.c() == 4) {
                z2();
            }
            if (N0()) {
                super.H(null);
                super.I(-15197410);
            } else {
                w2();
            }
            T0(true);
            if (c17 == 3 && i3 == 4) {
                c16 = 1;
            } else if (c17 == 4 && i3 == 3) {
                c16 = 2;
            } else if (i3 == 3) {
                c16 = 3;
            } else {
                c16 = 0;
            }
            if (c16 == 1) {
                float dp2px = ba.dp2px(this.Q, 12.0f);
                float dp2px2 = ba.dp2px(this.Q, 18.0f);
                int i16 = 0;
                while (true) {
                    GLVideoView[] gLVideoViewArr = this.f75271c0;
                    if (i16 >= gLVideoViewArr.length) {
                        break;
                    }
                    if (i16 == 0) {
                        gLVideoViewArr[i16].w1(false);
                        this.f75271c0[i16].k1(12);
                        this.f75271c0[i16].y1(dp2px2);
                    } else {
                        gLVideoViewArr[i16].w1(true);
                        this.f75271c0[i16].k1(12);
                        this.f75271c0[i16].y1(dp2px);
                    }
                    this.f75271c0[i16].r0();
                    i16++;
                }
            }
            for (GLVideoView gLVideoView : this.f75271c0) {
                gLVideoView.r1(this.f75276h0.d());
                if (i3 == 3) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                gLVideoView.n1(z16);
                c1(d16, gLVideoView);
            }
            Context context = this.Q;
            if (context instanceof AVActivity) {
                ((AVActivity) context).R2(d16);
            }
            this.U0 = false;
            if (com.tencent.av.n.e().f().f73035i == 4) {
                v3(i3);
            }
        }
    }

    public int m2(float f16) {
        int round = Math.round(f16) + this.f75199d1;
        if (round < 0) {
            return -1;
        }
        return round / (this.H0 + this.J0);
    }

    public am n2(long j3) {
        return this.f75210o1.get(Long.valueOf(j3));
    }

    void n3(int i3) {
        if (this.K0 != null) {
            this.R.M().removeCallbacks(this.K0);
            this.K0 = null;
            T0(false);
        }
        if (!C2()) {
            this.K0 = new MultiVideoOpenAnimation(i3);
            this.R.M().post(this.K0);
        }
    }

    public int o2() {
        return this.f75276h0.c();
    }

    public void o3(String str) {
        if (this.f75276h0.c() != 2) {
            j3("switchLocalView_" + str, this.R.getCurrentAccountUin());
        }
    }

    protected boolean p3(int i3, int i16) {
        if (QLog.isColorLevel()) {
            String G0 = this.f75271c0[i3].G0();
            String G02 = this.f75271c0[i16].G0();
            QLog.w(this.N, 1, "switchVideo, begin, [" + i3 + "]=[" + G0 + "], [" + i16 + "]=[" + G02 + "]", new Throwable("\u6253\u5370\u8c03\u7528\u6808"));
        }
        if (i3 != i16 && i3 >= 0) {
            GLVideoView[] gLVideoViewArr = this.f75271c0;
            if (i3 < gLVideoViewArr.length && i16 >= 0 && i16 < gLVideoViewArr.length) {
                if (i16 == 0) {
                    m1(i3, i16);
                    return true;
                }
                if (com.tencent.av.n.e().f().f73035i == 4) {
                    if (i3 == 0) {
                        this.f75271c0[i16].q1(ImageView.ScaleType.CENTER_INSIDE);
                    }
                    if (this.R.getCurrentAccountUin().equals(this.f75271c0[i16].G0())) {
                        this.f75271c0[i16].q1(ImageView.ScaleType.CENTER_CROP);
                    }
                }
                x xVar = this.f75276h0;
                if (xVar != null && xVar.c() == 3) {
                    return r2(i3, i16);
                }
                x xVar2 = this.f75276h0;
                if (xVar2 != null && xVar2.c() == 4) {
                    return m3(i3, i16);
                }
                return N1(i3, i16);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(this.N, 2, "switchVideo index invalid!");
            return false;
        }
        return false;
    }

    public void r3(SessionInfo sessionInfo) {
        QLog.w(this.N, 1, "tryRegisterMemmberChangeListener");
        sessionInfo.U(p2());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean s2(String str, int i3) {
        if (w0("hasVideoView", str, i3) >= 0) {
            return true;
        }
        return false;
    }

    public void s3(int i3) {
        IWinkZShowViewForOnlineStatusProvider.a aVar;
        ViewGroup viewGroup = this.f75269a0;
        if (viewGroup == null || viewGroup.getVisibility() == 8 || (aVar = this.f75270b0) == null) {
            return;
        }
        aVar.f0().setText(i3 + "%");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void t3(boolean z16, boolean z17) {
        if (this.f75269a0 == null) {
            return;
        }
        if ((!z16 && this.f75270b0 == null) || com.tencent.av.utils.e.j()) {
            return;
        }
        if (this.f75270b0 == null) {
            IWinkZShowViewForOnlineStatusProvider.a a16 = com.tencent.av.zplan.avatar.utils.b.a(this.Q, z17);
            this.f75270b0 = a16;
            if (a16 instanceof View) {
                this.f75269a0.addView((View) a16);
            }
        }
        if (z16) {
            this.f75270b0.show();
            this.f75269a0.setVisibility(0);
        } else {
            this.f75270b0.hide();
            this.f75269a0.setVisibility(8);
        }
    }

    @Override // com.tencent.av.ui.VideoLayerUIBase, com.tencent.av.opengl.ui.b
    protected void u(boolean z16, int i3, int i16, int i17, int i18) {
        super.u(z16, i3, i16, i17, i18);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.av.opengl.ui.b
    public void v(int i3, int i16) {
        super.v(i3, i16);
    }

    void v2(long j3, GLVideoView gLVideoView, String str, int i3, boolean z16) {
        NtrtcVideoRenderTexture S;
        if (gLVideoView != null) {
            String i26 = i2(str, i3);
            gLVideoView.h1(str, i3);
            gLVideoView.R(0);
            gLVideoView.t1(this.R.getCurrentAccountUin());
            try {
                NtrtcVideoRender.getInstance().setAccountUin(this.R.getCurrentAccountUin());
                YUVTexture I0 = gLVideoView.I0();
                if (I0 == null) {
                    S = null;
                } else {
                    S = I0.S();
                }
                NtrtcVideoRender.getInstance().setGlRender(i26, S);
                QLog.w(this.N, 1, "setGlRender[initGLVideoViewBasePara], key[" + LogUtil.getSafePrintUin(str) + "], debug[" + gLVideoView.t0() + "], videoSrcType[" + i3 + "], yuvTexture[" + I0 + "]");
                com.tencent.av.r.h0().P2(j3, com.tencent.av.n.e().f().f73035i, false, z16);
            } catch (UnsatisfiedLinkError e16) {
                e16.printStackTrace();
            }
        }
    }

    public void v3(int i3) {
        if (this.f75207l1 != i3) {
            this.f75207l1 = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.av.opengl.ui.b
    public void w() {
        super.w();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.av.opengl.ui.b
    public void x() {
        super.x();
    }
}
