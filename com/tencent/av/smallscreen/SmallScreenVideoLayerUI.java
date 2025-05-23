package com.tencent.av.smallscreen;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.n;
import com.tencent.av.opengl.texture.YUVTexture;
import com.tencent.av.opengl.ui.GLRootView;
import com.tencent.av.r;
import com.tencent.av.ui.GLVideoView;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.av.ui.VideoLayerUIBase;
import com.tencent.av.ui.x;
import com.tencent.av.utils.ax;
import com.tencent.avcore.jni.NtrtcVideoRender;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.filament.zplan.view.AVFilamentTextureView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qmcf.processor.BaseQmcfProcessor;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

/* compiled from: P */
/* loaded from: classes32.dex */
public class SmallScreenVideoLayerUI extends VideoLayerUIBase {
    private a E0;
    private int F0;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface a {
        void a(int i3);
    }

    public SmallScreenVideoLayerUI(VideoAppInterface videoAppInterface, Context context, View view, a aVar) {
        super(videoAppInterface, context, view);
        this.F0 = 0;
        this.E0 = aVar;
        this.f75294z0 = 2;
        if (ax.c()) {
            com.tencent.av.opengl.texture.c cVar = new com.tencent.av.opengl.texture.c();
            cVar.C(this.f74135r);
            cVar.D(ViewUtils.dpToPx(8.0f));
            this.f74133p = cVar;
        }
        this.f75276h0 = x.b(context, this.R, n.e().f().O1, true);
        J0();
        I0();
        w1();
        H0();
        K0();
        v1();
    }

    private void A1(String str, YUVTexture yUVTexture) {
        if (r.h0().F()) {
            return;
        }
        NtrtcVideoRender.getInstance().setGlRender(str, yUVTexture == null ? null : yUVTexture.S());
        QLog.i("SmallScreenVideoLayerUI", 1, "setGlRender[small_screen], key[" + str + "], yuvTexture[" + yUVTexture + "]");
    }

    private void r1() {
        int s16;
        if (this.f75271c0[0].m() == 0) {
            String currentAccountUin = this.R.getCurrentAccountUin();
            String str = (String) this.f75271c0[0].l(0);
            if (str == null || !str.equals(currentAccountUin) || (s16 = s1()) <= 0) {
                return;
            }
            F1(0, s16);
        }
    }

    private int s1() {
        String currentAccountUin = this.R.getCurrentAccountUin();
        int i3 = 0;
        while (true) {
            GLVideoView[] gLVideoViewArr = this.f75271c0;
            if (i3 >= gLVideoViewArr.length) {
                return -1;
            }
            GLVideoView gLVideoView = gLVideoViewArr[i3];
            String str = (String) gLVideoView.l(0);
            if (gLVideoView.m() == 0 && !TextUtils.isEmpty(str) && !str.equals(currentAccountUin)) {
                return i3;
            }
            i3++;
        }
    }

    private void v1() {
        if (this.f75271c0 == null) {
            return;
        }
        int i3 = 1;
        while (true) {
            GLVideoView[] gLVideoViewArr = this.f75271c0;
            if (i3 >= gLVideoViewArr.length) {
                return;
            }
            gLVideoViewArr[i3].S(-1);
            i3++;
        }
    }

    private void w1() {
        if (QLog.isColorLevel()) {
            QLog.d("SmallScreenVideoLayerUI", 2, "initGlVideoViewBackground");
        }
    }

    private void x1(boolean z16, int i3, int i16, int i17) {
        int i18;
        if (n.e().f().f73063p == 2) {
            GLVideoView gLVideoView = this.f75271c0[0];
            Boolean bool = Boolean.TRUE;
            gLVideoView.e1(bool);
            this.f75271c0[1].e1(bool);
            this.f75271c0[2].e1(bool);
            this.f75271c0[3].e1(bool);
            this.f75271c0[4].e1(bool);
            if (this.f75271c0[0].a0() && (((i18 = this.A0) == 0 || i18 == 180) && !this.f75271c0[0].w0())) {
                if (this.A0 == 0) {
                    this.f75271c0[0].O(0, 0, 0, this.Q.getResources().getDimensionPixelSize(R.dimen.a5x));
                } else {
                    this.f75271c0[0].O(0, this.Q.getResources().getDimensionPixelSize(R.dimen.a5x), 0, 0);
                }
            } else {
                this.f75271c0[0].O(i17, i17, i17, i17);
            }
        }
        this.f75276h0.i(n.e().f(), this.f75271c0, i3, i16, z16, this.A0, this.U);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean B1(boolean z16, boolean z17) {
        int s16;
        long d16 = com.tencent.av.utils.e.d();
        if (QLog.isColorLevel()) {
            QLog.w("SmallScreenVideoLayerUI", 1, "setLocalHasVideo, isLocalHasVideo[" + this.O + "->" + z16 + "], forceToBigView[" + z17 + "], seq[" + d16 + "]");
        }
        if (tv.c.c(this.Q) == 1) {
            return false;
        }
        GLVideoView gLVideoView = null;
        String str = null;
        if (z16) {
            if (!n.e().f().f73098x2) {
                ThreadManagerV2.post(this.f75290v0, 8, null, false);
            }
            String currentAccountUin = this.R.getCurrentAccountUin();
            int w06 = w0("setLocalHasVideo_open", currentAccountUin, 1);
            String i26 = VideoLayerUI.i2(currentAccountUin, 1);
            if (w06 < 0) {
                w06 = C0(0);
                if (w06 >= 0) {
                    GLVideoView gLVideoView2 = this.f75271c0[w06];
                    gLVideoView2.Q(0, currentAccountUin);
                    gLVideoView2.Q(1, 1);
                    gLVideoView2.t1(currentAccountUin);
                    try {
                        NtrtcVideoRender.getInstance().setAccountUin(currentAccountUin);
                        A1(i26, gLVideoView2.I0());
                    } catch (UnsatisfiedLinkError e16) {
                        str = BaseQmcfProcessor.LINK_ERROR + e16.getMessage();
                    }
                    QLog.w("SmallScreenVideoLayerUI", 1, "setGlRender[LocalHasVideo_1], key[" + i26 + "], index[" + w06 + "], log[" + str + "], " + gLVideoView2.t0());
                    r.h0().P2(d16, n.e().f().f73035i, false, false);
                    gLVideoView = gLVideoView2;
                }
                if (w06 > 1) {
                    int i3 = n.e().f().f73035i;
                }
            } else {
                GLVideoView gLVideoView3 = this.f75271c0[w06];
                A1(i26, gLVideoView3.I0());
                QLog.w("SmallScreenVideoLayerUI", 1, "setGlRender[LocalHasVideo_2], key[" + i26 + "], index[" + w06 + "], " + gLVideoView3.t0());
                r.h0().P2(d16, n.e().f().f73035i, false, false);
                gLVideoView = gLVideoView3;
            }
            if (gLVideoView != null) {
                gLVideoView.i1(false);
                gLVideoView.m0(false);
                gLVideoView.o1(true);
                gLVideoView.R(0);
                gLVideoView.q1(ImageView.ScaleType.CENTER_CROP);
                if (com.tencent.av.camera.b.a(this.Q).isCameraOpened(d16)) {
                    gLVideoView.m1(d16, com.tencent.av.camera.b.a(this.Q).isFrontCamera());
                }
                y1();
            }
            if (w06 == 0 && (s16 = s1()) > 0) {
                F1(w06, s16);
            }
            T0(false);
        } else if (!z16) {
            ThreadManagerV2.post(this.f75291w0, 8, null, false);
            String currentAccountUin2 = this.R.getCurrentAccountUin();
            int w07 = w0("setLocalHasVideo_close", currentAccountUin2, 1);
            if (w07 >= 0) {
                String i27 = VideoLayerUI.i2(currentAccountUin2, 1);
                NtrtcVideoRender.getInstance().flushGlRender(i27);
                NtrtcVideoRender.getInstance().clearCameraFrames();
                NtrtcVideoRender.getInstance().setGlRender(i27, null);
                QLog.w("SmallScreenVideoLayerUI", 1, "setGlRender[LocalHasVideo_no], key[" + i27 + "], index[" + w07 + "]");
                r.h0().P2(d16, n.e().f().f73035i, true, false);
                q1(w07);
            }
        }
        this.O = z16;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void C1(int i3, int i16, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("SmallScreenVideoLayerUI", 2, "setOffset topOffset: " + i3 + ", bottomOffset: " + i16);
        }
        this.T = i3;
        this.U = i16;
        T0(true);
        if (n.e().f().f73035i != 4) {
            return;
        }
        if (n.e().f().f73060o0) {
            int i17 = 0;
            while (true) {
                GLVideoView[] gLVideoViewArr = this.f75271c0;
                if (i17 >= gLVideoViewArr.length) {
                    return;
                }
                gLVideoViewArr[i17].C1(false);
                i17++;
            }
        } else {
            int i18 = 0;
            while (true) {
                GLVideoView[] gLVideoViewArr2 = this.f75271c0;
                if (i18 >= gLVideoViewArr2.length) {
                    return;
                }
                GLVideoView gLVideoView = gLVideoViewArr2[i18];
                if (i18 != 0) {
                    gLVideoView.C1(true);
                } else if (i3 != 0 && i16 != 0) {
                    gLVideoView.C1(false);
                } else {
                    gLVideoView.C1(true);
                }
                if (this.f75271c0[i18].H0() == 2) {
                    gLVideoView.C1(false);
                }
                i18++;
            }
        }
    }

    @Override // com.tencent.av.ui.VideoLayerUIBase
    protected int D0() {
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void E1(String str, int i3, String str2, float f16, int i16) {
        int w06 = w0(IECSearchBar.METHOD_SET_TEXT, str, i3);
        if (QLog.isColorLevel()) {
            QLog.d("SmallScreenVideoLayerUI", 2, "setText uin: " + str + ", videoSrcType: " + i3 + ", text: " + str2 + ", textSize: " + f16 + ", textColor: " + i16 + ", index: " + w06);
        }
        if (w06 >= 0) {
            GLVideoView gLVideoView = this.f75271c0[w06];
            gLVideoView.R(0);
            y1();
            r1();
            gLVideoView.u1(str2);
            gLVideoView.y1(f16);
            gLVideoView.v1(i16);
            gLVideoView.w1(w06 != 0);
            if (w06 == 0) {
                gLVideoView.k1(12);
            } else {
                gLVideoView.k1(Integer.MAX_VALUE);
            }
        }
    }

    protected boolean F1(int i3, int i16) {
        if (QLog.isColorLevel()) {
            QLog.d("SmallScreenVideoLayerUI", 2, "switchVideo index1: " + i3 + ", index2: " + i16);
        }
        if (i3 != i16 && i3 >= 0) {
            GLVideoView[] gLVideoViewArr = this.f75271c0;
            if (i3 < gLVideoViewArr.length && i16 >= 0 && i16 < gLVideoViewArr.length) {
                int i17 = N0() ? 2 : 1;
                m1(i3, i16);
                this.f75271c0[i3].o1(i3 < i17);
                this.f75271c0[i16].o1(i16 < i17);
                return true;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("SmallScreenVideoLayerUI", 2, "switchVideo index invalid!");
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.av.ui.VideoLayerUIBase
    public void H0() {
        this.W = (AVFilamentTextureView) this.S.findViewById(R.id.raa);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.av.ui.VideoLayerUIBase
    public void I0() {
        GLRootView gLRootView = (GLRootView) this.S.findViewById(R.id.rab);
        this.V = gLRootView;
        gLRootView.setContentPane(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.av.ui.VideoLayerUIBase
    public void J0() {
        super.J0();
        int i3 = 0;
        while (true) {
            GLVideoView[] gLVideoViewArr = this.f75271c0;
            if (i3 >= gLVideoViewArr.length) {
                return;
            }
            gLVideoViewArr[i3].j1(true);
            i3++;
        }
    }

    @Override // com.tencent.av.ui.VideoLayerUIBase
    protected void K0() {
        ImageView imageView;
        this.X = (ImageView) this.S.findViewById(R.id.ra_);
        Bitmap c16 = com.tencent.av.zplan.avatar.utils.a.f77344a.c(BaseApplicationImpl.getApplication(), "qav_zplan_avatar_bg_v1" + File.separator + "bg_default.png");
        if (c16 == null || (imageView = this.X) == null) {
            return;
        }
        imageView.setImageBitmap(c16);
    }

    @Override // com.tencent.av.ui.VideoLayerUIBase
    public void T0(boolean z16) {
        int n3 = super.n();
        int h16 = super.h();
        SessionInfo f16 = n.e().f();
        if (QLog.isColorLevel()) {
            QLog.w("SmallScreenVideoLayerUI", 1, "layoutVideoView, virtical[" + z16 + "], sessionType[" + f16.f73035i + "], width[" + n3 + "], height[" + h16 + "]");
        }
        this.f75271c0[0].O(0, 0, 0, 0);
        this.f75271c0[0].q(0, 0, n3, h16);
        this.f75271c0[0].I(-15197410);
        if (VideoLayerUIBase.O0(f16)) {
            this.f75276h0.h(this.f75271c0, n3, h16, this.f75294z0, this.T, this.U, !f16.G);
        } else if (VideoLayerUIBase.R0(f16)) {
            x1(z16, n3, h16, 0);
        }
        super.p();
    }

    @Override // com.tencent.av.ui.VideoLayerUIBase
    public void V0() {
        super.V0();
        x xVar = this.f75276h0;
        if (xVar != null) {
            xVar.k();
            this.f75276h0 = null;
        }
    }

    @Override // com.tencent.av.ui.VideoLayerUIBase
    public void e1(int i3, boolean z16) {
        if (!this.O && !S0()) {
            this.f75293y0 = i3;
            return;
        }
        int i16 = this.f75292x0;
        if (i3 != i16 || i3 == this.f75293y0) {
            if (i3 % 90 != i16 % 90) {
                this.f75273e0 = 0;
            }
            long currentTimeMillis = System.currentTimeMillis();
            boolean Y0 = r.h0().Y0();
            QLog.d("SmallScreenVideoLayerUI", 1, "setRotation rotation=" + i3 + " supportLandscape=" + z16 + " isGameMode=" + Y0 + " cost=" + (System.currentTimeMillis() - currentTimeMillis));
            this.f75292x0 = i3;
            this.f75293y0 = i3;
            int O1 = !Y0 ? VideoLayerUI.O1("SmallScreenVideoLayerUI", this.Q, i3, z16, this.B0) : 0;
            if (i3 == 0 || i3 == 90 || i3 == 180 || i3 == 270) {
                for (int i17 = 0; i17 < super.e0(); i17++) {
                    super.d0(i17).P(O1);
                }
                this.A0 = O1;
            }
            if (n.e().f().f73063p == 2) {
                int i18 = this.A0;
                T0(i18 == 0 || i18 == 180);
            }
        }
    }

    @Override // com.tencent.av.ui.VideoLayerUIBase
    protected void f1(int i3) {
        this.f75276h0.l(this.f75271c0, n(), h(), i3, this.T, this.U);
    }

    @Override // com.tencent.av.ui.VideoLayerUIBase
    public void g1(boolean z16) {
        super.g1(z16);
        e(!z16);
    }

    @Override // com.tencent.av.ui.VideoLayerUIBase
    public void m0(int i3) {
        super.m0(i3);
        if (this.f75276h0.c() == i3) {
            return;
        }
        this.f75276h0 = x.b(this.Q, this.R, i3, true);
        T0(true);
        int i16 = 0;
        while (true) {
            GLVideoView[] gLVideoViewArr = this.f75271c0;
            if (i16 >= gLVideoViewArr.length) {
                return;
            }
            gLVideoViewArr[i16].r1(this.f75276h0.d());
            c1(-1049L, this.f75271c0[i16]);
            if (this.f75276h0.d() && i16 < 2) {
                this.f75271c0[i16].o1(true);
            }
            i16++;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.av.opengl.ui.c, com.tencent.av.opengl.ui.b
    public void t() {
        if (QLog.isColorLevel()) {
            QLog.d("SmallScreenVideoLayerUI", 2, "onFirstDraw");
        }
        VideoAppInterface videoAppInterface = this.R;
        if (videoAppInterface != null) {
            videoAppInterface.M().post(new Runnable() { // from class: com.tencent.av.smallscreen.SmallScreenVideoLayerUI.1
                @Override // java.lang.Runnable
                public void run() {
                    if (((VideoLayerUIBase) SmallScreenVideoLayerUI.this).S != null) {
                        ((VideoLayerUIBase) SmallScreenVideoLayerUI.this).S.findViewById(R.id.rac).setVisibility(8);
                    }
                }
            });
        }
    }

    public int u1() {
        return this.f75276h0.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y1() {
        int t16 = t1();
        int i3 = N0() ? 2 : 1;
        int i16 = 0;
        while (i16 < t16) {
            this.f75271c0[i16].o1(i16 < i3);
            this.f75271c0[i16].e(false);
            i16++;
        }
        if (this.F0 != t16) {
            this.F0 = t16;
            a aVar = this.E0;
            if (aVar != null) {
                aVar.a(t16);
            }
        }
    }

    private int t1() {
        int i3 = 0;
        int i16 = 0;
        while (true) {
            GLVideoView[] gLVideoViewArr = this.f75271c0;
            if (i3 >= gLVideoViewArr.length) {
                return i16;
            }
            GLVideoView gLVideoView = gLVideoViewArr[i3];
            String str = (String) gLVideoView.l(0);
            if (gLVideoView.m() == 0 && gLVideoView.A0() && !TextUtils.isEmpty(str)) {
                i16++;
            }
            i3++;
        }
    }

    private void q1(int i3) {
        float f16;
        int i16;
        int i17;
        boolean z16;
        if (QLog.isColorLevel()) {
            QLog.d("SmallScreenVideoLayerUI", 2, "closeVideoView index: " + i3);
        }
        ImageView.ScaleType scaleType = ImageView.ScaleType.CENTER_INSIDE;
        int i18 = n.e().f().f73035i;
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
        int i19 = N0() ? 2 : 1;
        int i26 = i3;
        while (true) {
            GLVideoView[] gLVideoViewArr = this.f75271c0;
            if (i26 < gLVideoViewArr.length) {
                if (i26 >= gLVideoViewArr.length - 1) {
                    break;
                }
                int i27 = i26 + 1;
                if (gLVideoViewArr[i27].m() != 0) {
                    break;
                }
                int o16 = this.f75271c0[i26].o();
                this.f75271c0[i26].S(this.f75271c0[i27].o());
                this.f75271c0[i27].S(o16);
                GLVideoView[] gLVideoViewArr2 = this.f75271c0;
                GLVideoView gLVideoView = gLVideoViewArr2[i26];
                gLVideoViewArr2[i26] = gLVideoViewArr2[i27];
                gLVideoViewArr2[i27] = gLVideoView;
                gLVideoViewArr2[i26].o1(i26 < i19);
                i26 = i27;
            } else {
                break;
            }
        }
        GLVideoView gLVideoView2 = this.f75271c0[i26];
        gLVideoView2.R(1);
        y1();
        gLVideoView2.u1(null);
        gLVideoView2.o1(true);
        gLVideoView2.m0(false);
        gLVideoView2.i1(false);
        gLVideoView2.q0(true);
        gLVideoView2.h1(null, 0);
        gLVideoView2.t1("");
        r1();
        if (i3 == 0) {
            this.f75271c0[0].w1(false);
            this.f75271c0[0].v1(i16);
            this.f75271c0[0].y1(f16);
            this.f75271c0[0].k1(i17);
            this.f75271c0[0].C1(z16);
            if (i18 == 4) {
                this.f75271c0[0].q1(scaleType);
            }
        }
        T0(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void z1(String str, int i3, Bitmap bitmap, boolean z16, boolean z17) {
        int w06 = w0("setBackground", str, i3);
        boolean z18 = true;
        if (w06 < 0) {
            w06 = C0(0);
            if (w06 >= 0) {
                GLVideoView gLVideoView = this.f75271c0[w06];
                gLVideoView.R(0);
                y1();
                r1();
                gLVideoView.Q(0, str);
                gLVideoView.Q(1, Integer.valueOf(i3));
                gLVideoView.t1(this.R.getCurrentAccountUin());
                String i26 = VideoLayerUI.i2(str, i3);
                A1(i26, null);
                A1(i26, gLVideoView.I0());
                long d16 = com.tencent.av.utils.e.d();
                QLog.w("SmallScreenVideoLayerUI", 1, "setGlRender[setBackground], key[" + i26 + "], index[" + w06 + "], seq[" + d16 + "], " + gLVideoView.t0());
                r.h0().P2(d16, n.e().f().f73035i, false, str == null || !str.equals(this.R.getCurrentAccountUin()));
            }
            if (z17 && w06 > 0) {
                F1(0, w06);
                w06 = 0;
            }
        }
        if (w06 >= 0) {
            GLVideoView gLVideoView2 = this.f75271c0[w06];
            gLVideoView2.H(bitmap);
            if (!z16 || (!z17 && w06 != 0)) {
                z18 = false;
            }
            gLVideoView2.o1(z18);
            if (!z18) {
                gLVideoView2.m0(false);
            }
        }
        T0(false);
        if (QLog.isColorLevel()) {
            QLog.d("SmallScreenVideoLayerUI", 2, "setBackground uin: " + str + ", videoSrcType: " + i3 + ", index: " + w06 + ", needRenderVideo: " + z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01df  */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v2, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r15v3 */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r15v5 */
    /* JADX WARN: Type inference failed for: r17v0, types: [com.tencent.av.ui.VideoLayerUIBase, com.tencent.av.smallscreen.SmallScreenVideoLayerUI] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16, types: [com.tencent.av.ui.GLVideoView] */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v21 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void D1(String str, int i3, boolean z16, boolean z17, boolean z18) {
        ?? r152;
        int i16;
        boolean z19 = z17;
        long d16 = com.tencent.av.utils.e.d();
        if (QLog.isColorLevel()) {
            QLog.w("SmallScreenVideoLayerUI", 1, "setRemoteHasVideo, uin[" + str + "], videoSrcType[" + i3 + "], isRemoteHasVideo[" + z16 + "], forceToBigView[" + z19 + "], mIsLocalHasVideo[" + this.O + "], isFillBlackEdge[" + z18 + "], seq[" + d16 + "]");
        }
        if (TextUtils.isEmpty(str) || str.equals(this.R.getCurrentAccountUin()) || tv.c.c(this.Q) == 1) {
            return;
        }
        if (VideoLayerUIBase.O0(n.e().f()) && !z19 && !Q0()) {
            z19 = true;
        }
        r0();
        ?? r65 = 0;
        if (z16) {
            int w06 = w0("setRemoteHasVideo_open", str, i3);
            String i26 = VideoLayerUI.i2(str, i3);
            if (w06 < 0) {
                w06 = C0(0);
                if (w06 >= 0) {
                    GLVideoView gLVideoView = this.f75271c0[w06];
                    gLVideoView.h1(str, i3);
                    if (i3 == 2) {
                        gLVideoView.C1(false);
                    }
                    gLVideoView.t1(this.R.getCurrentAccountUin());
                    try {
                        A1(i26, gLVideoView.I0());
                    } catch (UnsatisfiedLinkError e16) {
                        e16.printStackTrace();
                    }
                    QLog.w("SmallScreenVideoLayerUI", 1, "setGlRender[RemoteHasVideo_1], key[" + i26 + "], index[" + w06 + "], " + gLVideoView.t0());
                    r152 = 0;
                    r.h0().P2(d16, n.e().f().f73035i, false, true);
                    r65 = gLVideoView;
                } else {
                    r152 = 0;
                }
                if (w06 > 1) {
                    int i17 = n.e().f().f73035i;
                }
            } else {
                r152 = 0;
                GLVideoView gLVideoView2 = this.f75271c0[w06];
                A1(i26, gLVideoView2.I0());
                QLog.w("SmallScreenVideoLayerUI", 1, "setGlRender[RemoteHasVideo_2], key[" + i26 + "], index[" + w06 + "], " + gLVideoView2.t0());
                r.h0().P2(d16, n.e().f().f73035i, false, true);
                r65 = gLVideoView2;
            }
            if (r65 != 0) {
                r65.i1(z18);
                r65.m1(d16, this.f75276h0.d());
                r65.m0(true);
                r65.R(r152);
                y1();
                if (n.e().f().f73035i != 4) {
                    i16 = 2;
                    if (n.e().f().f73035i == 2) {
                        r65.q1(ImageView.ScaleType.CENTER_INSIDE);
                    }
                    if (z19 && w06 > 0 && (n.e().f().f73035i != i16 || n.e().f().M)) {
                        F1(r152, w06);
                    }
                    if (w06 > 0) {
                        r1();
                    }
                    T0(r152);
                    return;
                }
                if (w06 == 0) {
                    r65.q1(ImageView.ScaleType.CENTER_INSIDE);
                } else {
                    r65.q1(ImageView.ScaleType.CENTER_CROP);
                }
            }
            i16 = 2;
            if (z19) {
                F1(r152, w06);
            }
            if (w06 > 0) {
            }
            T0(r152);
            return;
        }
        int w07 = w0("setRemoteHasVideo_close", str, i3);
        if (w07 >= 0) {
            String i27 = VideoLayerUI.i2(str, i3);
            NtrtcVideoRender.getInstance().flushGlRender(i27);
            NtrtcVideoRender.getInstance().setGlRender(i27, null);
            QLog.w("SmallScreenVideoLayerUI", 1, "setGlRender[RemoteHasVideo_no], key[" + i27 + "], index[" + w07 + "]");
            r.h0().P2(d16, n.e().f().f73035i, true, true);
            q1(w07);
        }
    }
}
