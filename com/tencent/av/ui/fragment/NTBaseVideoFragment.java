package com.tencent.av.ui.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.RelativeLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.doodle.api.IDoodleApi;
import com.tencent.av.n;
import com.tencent.av.r;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.ControlUIObserver;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.ui.VideoNetStateBar;
import com.tencent.av.ui.api.IAVFoldingDeviceBizApi;
import com.tencent.av.ui.api.IAVVideoRecordBizApi;
import com.tencent.av.ui.api.IAVZplanAvatarBizApi;
import com.tencent.av.ui.effect.menuview.QavEffectBaseMenuView;
import com.tencent.av.ui.m;
import com.tencent.av.ui.part.base.AVHidePart;
import com.tencent.av.ui.part.base.AVNetConnectInfoPart;
import com.tencent.av.ui.part.base.AVSharpInfoPart;
import com.tencent.av.ui.part.base.AVSmallHomeTipsPart;
import com.tencent.av.ui.part.base.AVToolBarPart;
import com.tencent.av.ui.part.base.AVVideoLayerUIPart;
import com.tencent.av.ui.part.base.b;
import com.tencent.av.ui.part.base.c;
import com.tencent.av.ui.part.base.d;
import com.tencent.av.ui.part.base.f;
import com.tencent.av.ui.part.base.h;
import com.tencent.av.ui.part.base.i;
import com.tencent.av.ui.part.base.panel.AVChatTimePart;
import com.tencent.av.ui.part.base.panel.AVEffectPart;
import com.tencent.av.ui.part.base.panel.AVRedTouchMorePart;
import com.tencent.av.ui.part.base.panel.AVScreenSharePart;
import com.tencent.av.ui.part.base.panel.g;
import com.tencent.av.ui.part.dav.panel.AVAvatarEntryPart;
import com.tencent.av.ui.part.dav.panel.AVCameraPart;
import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.VideoUtil;
import com.tencent.av.utils.af;
import com.tencent.av.utils.as;
import com.tencent.av.utils.e;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mw.k;

/* compiled from: P */
/* loaded from: classes32.dex */
public abstract class NTBaseVideoFragment extends QPublicBaseFragment {

    /* renamed from: s0, reason: collision with root package name */
    static String f75610s0 = "NTBaseVideoFragment";

    /* renamed from: t0, reason: collision with root package name */
    static boolean f75611t0 = false;
    int C;
    int D;
    Resources E;
    WeakReference<Context> F;
    public VideoAppInterface G;
    ViewGroup H;
    ControlUIObserver I;
    public QavPanel J;
    int K;
    as L;
    protected boolean M;
    boolean N;
    protected b P;
    protected i Q;
    protected c R;
    protected d S;
    protected AVNetConnectInfoPart T;
    protected f U;
    protected AVSharpInfoPart V;
    protected AVSmallHomeTipsPart W;
    protected h X;
    protected AVToolBarPart Y;
    protected com.tencent.av.ui.part.base.panel.a Z;

    /* renamed from: a0, reason: collision with root package name */
    protected AVAvatarEntryPart f75612a0;

    /* renamed from: b0, reason: collision with root package name */
    protected AVCameraPart f75613b0;

    /* renamed from: c0, reason: collision with root package name */
    protected com.tencent.av.ui.part.base.panel.b f75614c0;

    /* renamed from: d0, reason: collision with root package name */
    protected AVChatTimePart f75615d0;

    /* renamed from: e0, reason: collision with root package name */
    protected pw.a f75616e0;

    /* renamed from: f0, reason: collision with root package name */
    protected AVEffectPart f75617f0;

    /* renamed from: g0, reason: collision with root package name */
    protected com.tencent.av.ui.part.base.panel.c f75618g0;

    /* renamed from: h0, reason: collision with root package name */
    protected AVHidePart f75619h0;

    /* renamed from: i0, reason: collision with root package name */
    protected com.tencent.av.ui.part.dav.panel.d f75620i0;

    /* renamed from: j0, reason: collision with root package name */
    protected AVRedTouchMorePart f75621j0;

    /* renamed from: k0, reason: collision with root package name */
    protected com.tencent.av.ui.part.base.panel.d f75622k0;

    /* renamed from: l0, reason: collision with root package name */
    protected AVScreenSharePart f75623l0;

    /* renamed from: m0, reason: collision with root package name */
    protected com.tencent.av.ui.part.base.panel.f f75624m0;

    /* renamed from: n0, reason: collision with root package name */
    protected g f75625n0;

    /* renamed from: o0, reason: collision with root package name */
    protected com.tencent.av.ui.part.base.panel.h f75626o0;

    /* renamed from: p0, reason: collision with root package name */
    protected AVVideoLayerUIPart f75627p0;

    /* renamed from: q0, reason: collision with root package name */
    private boolean f75628q0;

    /* renamed from: r0, reason: collision with root package name */
    private boolean f75629r0;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a implements as.b {
        a() {
        }

        @Override // com.tencent.av.utils.as.b
        public void a() {
            com.tencent.av.ui.part.base.panel.d dVar = NTBaseVideoFragment.this.f75622k0;
            if (dVar != null) {
                dVar.ia();
            }
        }
    }

    public NTBaseVideoFragment() {
        this.C = 0;
        this.D = 0;
        this.E = null;
        this.J = null;
        this.K = 0;
        this.L = null;
        this.M = false;
        this.N = false;
        this.f75628q0 = false;
        this.f75629r0 = false;
        String str = getClass().getSimpleName() + "_" + e.d();
        f75610s0 = str;
        QLog.d(str, 1, "NTBaseVideoFragment...... " + this, new Throwable());
    }

    private void Fk() {
        AVScreenSharePart aVScreenSharePart = this.f75623l0;
        if (aVScreenSharePart != null) {
            aVScreenSharePart.U9();
        }
    }

    private void Wh(int i3) {
        AVActivity wh5 = wh();
        if (wh5 != null) {
            wh5.getLayoutInflater().inflate(i3, this.H);
        }
    }

    private void Yj(boolean z16) {
        View findViewById;
        ViewGroup viewGroup = this.H;
        if (viewGroup == null || (findViewById = viewGroup.findViewById(m.d.f76003a)) == null) {
            return;
        }
        findViewById.setVisibility(z16 ? 0 : 8);
    }

    private void ik(View view) {
        RFWIocAbilityProvider.g().unregisterSingleIoc(view, k.class);
    }

    private void wj(View view) {
        RFWIocAbilityProvider.g().registerIoc(view, new mw.a(this), k.class);
    }

    public AlphaAnimation Ah(boolean z16) {
        AVToolBarPart aVToolBarPart = this.Y;
        if (aVToolBarPart != null) {
            return aVToolBarPart.P9(z16);
        }
        return null;
    }

    public void Ai(long j3, View view) {
        com.tencent.av.ui.part.base.panel.f fVar = this.f75624m0;
        if (fVar != null) {
            fVar.C9(j3);
        }
    }

    public void Aj(long j3) {
        ((IDoodleApi) QRoute.api(IDoodleApi.class)).restoreDoodle(j3, wh());
    }

    void Ak() {
        com.tencent.av.ui.part.base.panel.d dVar;
        if (isDestroyed() || (dVar = this.f75622k0) == null) {
            return;
        }
        dVar.sa();
    }

    public IAVFoldingDeviceBizApi Bh() {
        return null;
    }

    public void Bi(long j3, View view) {
        AVSmallHomeTipsPart aVSmallHomeTipsPart = this.W;
        if (aVSmallHomeTipsPart != null) {
            aVSmallHomeTipsPart.B9(j3, view);
        }
    }

    public void Bj(String str) {
        d dVar = this.S;
        if (dVar != null) {
            dVar.A9(this.J, str);
        }
    }

    boolean Bk(long j3) {
        com.tencent.av.ui.part.dav.panel.d dVar;
        return (isDestroyed() || (dVar = this.f75620i0) == null || !dVar.H9(j3)) ? false : true;
    }

    public abstract int Ch();

    public void Ci(long j3) {
        QLog.w(f75610s0, 1, "onClick, switch_camera, seq[" + j3 + "]");
        this.I.update(null, new Object[]{107, Long.valueOf(j3)});
        n.e().f().R = n.e().f().R ^ true;
        if (this.J != null) {
            this.J.Q0(m.l.B, this.E.getString(n.e().f().R ? R.string.bhq : R.string.bhp));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Cj(long j3, int i3) {
        AVNetConnectInfoPart aVNetConnectInfoPart = this.T;
        if (aVNetConnectInfoPart != null) {
            aVNetConnectInfoPart.c2(j3, i3);
        }
    }

    public QavEffectBaseMenuView Dh() {
        QavPanel qavPanel = this.J;
        if (qavPanel != null) {
            return (QavEffectBaseMenuView) qavPanel.N(5);
        }
        return null;
    }

    public void Di(long j3, View view) {
        com.tencent.av.ui.part.base.panel.h hVar = this.f75626o0;
        if (hVar != null) {
            hVar.C9(j3, view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Dj(long j3, String str) {
        if (QLog.isDevelopLevel()) {
            QLog.w(f75610s0, 1, "setConnectInfo, str[" + str + "], seq[" + j3 + "]");
        }
        AVNetConnectInfoPart aVNetConnectInfoPart = this.T;
        if (aVNetConnectInfoPart != null) {
            aVNetConnectInfoPart.I9(j3, str);
        }
    }

    void Dk(long j3) {
        AVRedTouchMorePart aVRedTouchMorePart;
        if (isDestroyed() || (aVRedTouchMorePart = this.f75621j0) == null) {
            return;
        }
        aVRedTouchMorePart.H9(j3);
    }

    public QavPanel Eh() {
        return this.J;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Ei(long j3, View view) {
        AVEffectPart aVEffectPart = this.f75617f0;
        if (aVEffectPart != null) {
            aVEffectPart.F9(j3, view);
        }
    }

    public boolean Ej(int i3) {
        return false;
    }

    public void Ek() {
        AVScreenSharePart aVScreenSharePart = this.f75623l0;
        if (aVScreenSharePart != null) {
            aVScreenSharePart.T9();
        }
    }

    public long Fh() {
        return 0L;
    }

    public void Fi(long j3, int i3) {
        if (isDestroyed()) {
            return;
        }
        SessionInfo f16 = n.e().f();
        if (QLog.isColorLevel()) {
            QLog.w(f75610s0, 1, "onClose, type[" + i3 + "], sessionInfo[" + f16 + "], seq[" + j3 + "]");
        }
        if (f16.w()) {
            Oj(i3);
        } else {
            if (i3 == 25 || i3 == 56) {
                Oj(i3);
            }
            Gi();
        }
        as asVar = this.L;
        if (asVar != null) {
            asVar.r(false);
        }
        AVToolBarPart aVToolBarPart = this.Y;
        if (aVToolBarPart != null) {
            aVToolBarPart.Y9();
        }
    }

    public int Gh() {
        i iVar = this.Q;
        if (iVar != null) {
            return iVar.A9(getContext());
        }
        return 0;
    }

    public int Hh(long j3) {
        AVToolBarPart aVToolBarPart = this.Y;
        if (aVToolBarPart != null) {
            return aVToolBarPart.Q9(j3);
        }
        return 0;
    }

    public void Hi(long j3) {
        as asVar = this.L;
        if (asVar != null) {
            asVar.p();
        }
        vj();
        if (QLog.isDevelopLevel()) {
            QLog.i(f75610s0, 4, "onConnected");
        }
    }

    public void Hj(boolean z16) {
        if (Jh() != null) {
            Jh().k(z16);
        }
    }

    public void Hk(long j3) {
        AVScreenSharePart aVScreenSharePart = this.f75623l0;
        if (aVScreenSharePart != null) {
            aVScreenSharePart.F9(j3);
        }
    }

    public int Ih() {
        if (di()) {
            return this.Q.B9();
        }
        return 0;
    }

    public void Ij(int i3, int i16, int i17, String str) {
        if (Jh() != null) {
            Jh().m(i3, i16, i17, str);
        }
    }

    public void Ik(long j3) {
        AVScreenSharePart aVScreenSharePart = this.f75623l0;
        if (aVScreenSharePart != null) {
            aVScreenSharePart.W9(j3);
        }
    }

    public VideoNetStateBar Jh() {
        AVNetConnectInfoPart aVNetConnectInfoPart = this.T;
        if (aVNetConnectInfoPart != null) {
            return aVNetConnectInfoPart.G9();
        }
        QLog.e(f75610s0, 1, "getVideoNetStateBar null........");
        return null;
    }

    public void Jj(boolean z16) {
        if (Jh() != null) {
            Jh().p(z16);
        }
    }

    public void Jk(long j3) {
        com.tencent.av.ui.part.base.panel.f fVar = this.f75624m0;
        if (fVar != null) {
            fVar.E9(j3);
        }
    }

    public IAVVideoRecordBizApi Kh() {
        return null;
    }

    public void Ki(long j3) {
        QLog.d(f75610s0, 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        this.C = 6;
        ek(j3);
        as asVar = this.L;
        if (asVar != null) {
            asVar.r(false);
        }
        this.E = null;
        this.F = null;
        this.G = null;
        ViewGroup viewGroup = this.H;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            this.H = null;
        }
        this.I = null;
        this.L = null;
        if (getView() != null) {
            ik(getView());
        }
        this.f75628q0 = false;
        this.f75629r0 = false;
    }

    public void Kj(boolean z16) {
        if (Jh() != null) {
            Jh().q(z16);
        }
    }

    void Kk() {
        AVCameraPart aVCameraPart;
        if (isDestroyed() || (aVCameraPart = this.f75613b0) == null) {
            return;
        }
        aVCameraPart.Z9();
    }

    public IAVZplanAvatarBizApi Lh(boolean z16) {
        return null;
    }

    public void Li(long j3, int i3) {
        f fVar = this.U;
        if (fVar != null) {
            fVar.P9(j3, i3);
        }
    }

    public void Lj(boolean z16) {
        if (Jh() != null) {
            Jh().r(z16);
        }
    }

    public void Lk(long j3) {
        g gVar = this.f75625n0;
        if (gVar != null) {
            gVar.D9(j3);
        }
    }

    public void Ni(int i3) {
        AVVideoLayerUIPart aVVideoLayerUIPart = this.f75627p0;
        if (aVVideoLayerUIPart != null) {
            aVVideoLayerUIPart.G9(i3);
        }
    }

    public void Oh() {
        h hVar = this.X;
        if (hVar != null) {
            hVar.B9();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Oj(int i3) {
        this.T.N9(i3);
    }

    public void Ok(long j3) {
        com.tencent.av.ui.part.base.panel.h hVar = this.f75626o0;
        if (hVar != null) {
            hVar.D9(j3);
        }
    }

    public void Ph(boolean z16) {
        com.tencent.av.ui.part.base.panel.b bVar = this.f75614c0;
        if (bVar != null) {
            bVar.o7(z16);
        }
    }

    public void Qh(int i3) {
        h hVar = this.X;
        if (hVar != null) {
            hVar.C9(i3);
        }
    }

    public void Qj() {
        AVToolBarPart aVToolBarPart = this.Y;
        if (aVToolBarPart != null) {
            aVToolBarPart.Z9();
        }
    }

    public void Rh(long j3) {
        if (((IDoodleApi) QRoute.api(IDoodleApi.class)).isDoodleShow(j3, wh())) {
            ((IDoodleApi) QRoute.api(IDoodleApi.class)).hideDoodle(j3, wh());
        }
    }

    public void Rj(boolean z16) {
        AVToolBarPart aVToolBarPart = this.Y;
        if (aVToolBarPart != null) {
            aVToolBarPart.ca(z16);
        }
    }

    public void Sh(long j3) {
        AVEffectPart aVEffectPart = this.f75617f0;
        if (aVEffectPart != null) {
            aVEffectPart.C9(j3);
        }
    }

    public void Si() {
        if (Jh() != null) {
            Jh().g();
        }
    }

    public void Sj(long j3, float f16) {
        h hVar = this.X;
        if (hVar != null) {
            hVar.E9(j3, f16);
        }
    }

    public void Uh(String str) {
        AVToolBarPart aVToolBarPart = this.Y;
        if (aVToolBarPart != null) {
            aVToolBarPart.S9(str);
        }
    }

    public void Ui(int i3, long j3) {
        AVVideoLayerUIPart aVVideoLayerUIPart = this.f75627p0;
        if (aVVideoLayerUIPart != null) {
            aVVideoLayerUIPart.H9(i3, j3);
        }
    }

    public void Vh() {
        i iVar = this.Q;
        if (iVar != null) {
            iVar.E9(4);
        }
    }

    public void Vj(boolean z16) {
        AVToolBarPart aVToolBarPart = this.Y;
        if (aVToolBarPart != null) {
            aVToolBarPart.da(z16);
        }
    }

    public void Xi() {
        if (QLog.isColorLevel()) {
            QLog.d(f75610s0, 2, "onPauseAudio");
        }
    }

    public void Xj() {
        AVToolBarPart aVToolBarPart = this.Y;
        if (aVToolBarPart != null) {
            aVToolBarPart.ea();
        }
    }

    public boolean Yh() {
        return false;
    }

    public boolean Zh() {
        return false;
    }

    public void Zj(int i3, String str) {
        h hVar = this.X;
        if (hVar != null) {
            hVar.H9(i3, str);
        }
    }

    public boolean ai() {
        return this.N;
    }

    public abstract void ak(int i3);

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        QLog.d(f75610s0, 1, "assembleParts");
        ArrayList arrayList = new ArrayList();
        b bVar = new b();
        this.P = bVar;
        arrayList.add(bVar);
        i iVar = new i();
        this.Q = iVar;
        arrayList.add(iVar);
        d dVar = new d();
        this.S = dVar;
        arrayList.add(dVar);
        AVNetConnectInfoPart aVNetConnectInfoPart = new AVNetConnectInfoPart();
        this.T = aVNetConnectInfoPart;
        arrayList.add(aVNetConnectInfoPart);
        f fVar = new f();
        this.U = fVar;
        arrayList.add(fVar);
        AVSharpInfoPart aVSharpInfoPart = new AVSharpInfoPart();
        this.V = aVSharpInfoPart;
        arrayList.add(aVSharpInfoPart);
        h hVar = new h();
        this.X = hVar;
        arrayList.add(hVar);
        com.tencent.av.ui.part.base.panel.a aVar = new com.tencent.av.ui.part.base.panel.a(this.J);
        this.Z = aVar;
        arrayList.add(aVar);
        AVCameraPart aVCameraPart = new AVCameraPart(this.J);
        this.f75613b0 = aVCameraPart;
        arrayList.add(aVCameraPart);
        com.tencent.av.ui.part.base.panel.b bVar2 = new com.tencent.av.ui.part.base.panel.b(this.J);
        this.f75614c0 = bVar2;
        arrayList.add(bVar2);
        AVChatTimePart aVChatTimePart = new AVChatTimePart(this.J);
        this.f75615d0 = aVChatTimePart;
        arrayList.add(aVChatTimePart);
        pw.a aVar2 = new pw.a(this.J);
        this.f75616e0 = aVar2;
        arrayList.add(aVar2);
        AVEffectPart aVEffectPart = new AVEffectPart(this.J);
        this.f75617f0 = aVEffectPart;
        arrayList.add(aVEffectPart);
        com.tencent.av.ui.part.base.panel.c cVar = new com.tencent.av.ui.part.base.panel.c(this.J);
        this.f75618g0 = cVar;
        arrayList.add(cVar);
        AVHidePart aVHidePart = new AVHidePart(this.J);
        this.f75619h0 = aVHidePart;
        arrayList.add(aVHidePart);
        com.tencent.av.ui.part.dav.panel.d dVar2 = new com.tencent.av.ui.part.dav.panel.d(this.J);
        this.f75620i0 = dVar2;
        arrayList.add(dVar2);
        AVRedTouchMorePart aVRedTouchMorePart = new AVRedTouchMorePart(this.J);
        this.f75621j0 = aVRedTouchMorePart;
        arrayList.add(aVRedTouchMorePart);
        AVScreenSharePart aVScreenSharePart = new AVScreenSharePart(this.J);
        this.f75623l0 = aVScreenSharePart;
        arrayList.add(aVScreenSharePart);
        com.tencent.av.ui.part.base.panel.f fVar2 = new com.tencent.av.ui.part.base.panel.f(this.J);
        this.f75624m0 = fVar2;
        arrayList.add(fVar2);
        g gVar = new g(this.J);
        this.f75625n0 = gVar;
        arrayList.add(gVar);
        com.tencent.av.ui.part.base.panel.h hVar2 = new com.tencent.av.ui.part.base.panel.h(this.J);
        this.f75626o0 = hVar2;
        arrayList.add(hVar2);
        AVVideoLayerUIPart aVVideoLayerUIPart = new AVVideoLayerUIPart();
        this.f75627p0 = aVVideoLayerUIPart;
        arrayList.add(aVVideoLayerUIPart);
        return arrayList;
    }

    public abstract boolean bi();

    public void bk() {
        i iVar = this.Q;
        if (iVar != null) {
            iVar.E9(0);
        }
    }

    public boolean ci(int i3) {
        if (Dh() != null) {
            return Dh().v(i3);
        }
        return false;
    }

    public void ck(String str) {
        if (n.e().f().f73047l == 11) {
            cw.e.n(this.G, 1015);
        } else if (n.e().f().f73047l == 16) {
            cw.e.n(this.G, 1061);
        } else {
            cw.e.d(this.G, 1047);
        }
    }

    public boolean di() {
        AVToolBarPart aVToolBarPart = this.Y;
        return aVToolBarPart != null && aVToolBarPart.isToolBarDisplay();
    }

    public void dk(long j3) {
        int i3 = this.C;
        if (i3 < 2 || i3 > 4) {
            return;
        }
        AVChatTimePart aVChatTimePart = this.f75615d0;
        if (aVChatTimePart != null) {
            aVChatTimePart.O9(j3);
        }
        Dj(j3, null);
    }

    public boolean ei() {
        AVToolBarPart aVToolBarPart = this.Y;
        return aVToolBarPart != null && aVToolBarPart.T9();
    }

    public void ek(long j3) {
        AVChatTimePart aVChatTimePart = this.f75615d0;
        if (aVChatTimePart != null) {
            aVChatTimePart.P9(j3);
        }
    }

    public void fj() {
        if (QLog.isColorLevel()) {
            QLog.d(f75610s0, 2, "onResumeAudio");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void fk(int i3) {
        com.tencent.av.ui.part.base.panel.d dVar = this.f75622k0;
        if (dVar != null) {
            dVar.qa(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        QLog.d(f75610s0, 1, "getContentLayoutId.", new Throwable());
        return R.layout.f168473x4;
    }

    public abstract void gi(long j3, boolean z16);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void gk(int i3) {
        com.tencent.av.ui.part.base.panel.d dVar = this.f75622k0;
        if (dVar != null) {
            dVar.ra(i3);
        }
    }

    public abstract void hi(long j3, boolean z16, int i3);

    public abstract void hk(int i3);

    public int ii(int i3) {
        VideoUtil.n(this.G, i3);
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void initUI() {
        if (this.H == null) {
            QLog.d(f75610s0, 1, "initUI ERROR : rootView is null.");
            return;
        }
        QLog.d(f75610s0, 1, "initUI inflate");
        Wh(Ch());
        this.J = (QavPanel) this.H.findViewById(R.id.f166587gb4);
        AVActivity wh5 = wh();
        if (wh5 == null) {
            if (QLog.isColorLevel()) {
                QLog.e(f75610s0, 2, "initUI-->can not get AVActivity");
            }
        } else {
            as asVar = this.L;
            if (asVar != null) {
                asVar.r(false);
            }
            as k3 = as.k(this.L, wh5, new a());
            this.L = k3;
            k3.r(true);
        }
    }

    public boolean isDestroyed() {
        return this.C == 6;
    }

    public abstract void ji(long j3);

    public void jj() {
        AVRedTouchMorePart aVRedTouchMorePart = this.f75621j0;
        if (aVRedTouchMorePart != null) {
            aVRedTouchMorePart.E9();
        }
    }

    public void jk(int i3) {
        d dVar = this.S;
        if (dVar != null) {
            dVar.B9(this.J, i3);
        }
    }

    public abstract void ki(long j3);

    public void kk(int i3) {
        d dVar = this.S;
        if (dVar != null) {
            dVar.C9(i3);
        }
    }

    public void li(ArrayList<com.tencent.av.gaudio.c> arrayList) {
        AVVideoLayerUIPart aVVideoLayerUIPart = this.f75627p0;
        if (aVVideoLayerUIPart != null) {
            aVVideoLayerUIPart.F9(arrayList);
        }
    }

    public void lk(long j3, int i3) {
        if (isDestroyed() || this.J == null) {
            return;
        }
        f75611t0 = e.j();
        if ((i3 & 1) == 1) {
            Dk(j3);
        }
        if ((i3 & 2) == 2) {
            mk(j3);
        }
        if ((i3 & 4) == 4) {
            Gk(j3);
        }
        if ((i3 & 8) == 8) {
            zk(j3);
        }
        if ((i3 & 16) == 16) {
            Ak();
        }
        if ((i3 & 32) == 32) {
            Kk();
        }
        if ((i3 & 64) == 64) {
            Bk(j3);
        }
        if ((i3 & 128) == 128) {
            vk(j3);
        }
        if ((i3 & 256) == 256) {
            pk(j3);
        }
        if ((i3 & 16777216) == 16777216) {
            Jk(j3);
        }
        if ((i3 & 512) == 512) {
            Nk(j3);
        }
        if ((i3 & 4096) == 4096) {
            Hk(j3);
            Ik(j3);
        }
        if ((i3 & 8192) == 8192) {
            Ok(j3);
        }
        if ((i3 & 524288) == 524288) {
            wk(j3);
        }
        if ((i3 & 32768) == 32768) {
            Lk(j3);
        }
        if ((i3 & 65536) == 65536) {
            uk(j3);
        }
        if ((i3 & 131072) == 131072) {
            nk(j3);
        }
        int i16 = i3 & 2097152;
        if (i16 == 2097152) {
            Mk(j3);
        }
        if (i16 == 2097152) {
            Fk();
            Ek();
        }
        if ((i3 & 8388608) == 8388608) {
            Qk(j3);
        }
        qk(j3);
        Ck(j3);
        ok(j3);
        this.J.E0();
        if (f75611t0) {
            SessionInfo f16 = n.e().f();
            QLog.w(f75610s0, 1, "updateBtn, sessionInfo[" + f16 + "], screenStyle[" + f16.O1 + "], remoteHasVideo[" + f16.O + "], seq[" + j3 + "]", new Throwable("\u6253\u5370\u8c03\u7528\u6808"));
        }
    }

    public void mi(long j3, View view) {
        int id5 = view.getId();
        if (id5 != m.e.f76014a && id5 != m.b.f75998b) {
            if (id5 == m.l.A) {
                ui(j3, view);
                return;
            }
            if (id5 == m.e.f76016c) {
                QLog.d(f75610s0, 1, "onClick QavPanel.ViewID.ADD_MEMBER");
                ti(j3);
                return;
            }
            if (id5 == m.e.f76030q) {
                Ai(j3, view);
                return;
            }
            if (id5 != m.n.f76085c && id5 != m.p.f76091c && id5 != m.l.f76077w && id5 != m.l.f76078x) {
                if (id5 != m.l.f76073s && id5 != m.l.f76074t) {
                    if (id5 != m.l.O && id5 != m.l.f76060f) {
                        if (id5 != m.l.P && id5 != m.l.f76059e) {
                            if (id5 == m.l.B) {
                                Ci(j3);
                                return;
                            }
                            if (id5 == m.l.L) {
                                if (af.x()) {
                                    QLog.d(f75610s0, 1, "onClick QavPanel.ViewID.Voice.More");
                                    ui(j3, view);
                                    return;
                                }
                                QLog.d(f75610s0, 1, "onClick QavPanel.ViewID.Voice.Effect");
                                Ei(j3, view);
                                SessionInfo f16 = n.e().f();
                                if (f16 == null || f16.f73067q != 1044) {
                                    return;
                                }
                                DataReport.T(null, "dc00898", "", "", "0X800AD94", "0X800AD94", 0, 0, "", "", "", "");
                                return;
                            }
                            if (id5 == m.l.K) {
                                if (af.x()) {
                                    QLog.d(f75610s0, 1, "onClick QavPanel.ViewID.More");
                                    ui(j3, view);
                                    return;
                                } else {
                                    QLog.d(f75610s0, 1, "onClick QavPanel.ViewID.Effect");
                                    qi(j3, view);
                                    return;
                                }
                            }
                            return;
                        }
                        ri(j3);
                        return;
                    }
                    wi(j3, view);
                    return;
                }
                QLog.d(f75610s0, 1, "onClick Hangup ");
                si(j3, view);
                return;
            }
            pi();
            return;
        }
        oi(j3, view);
    }

    public boolean mk(long j3) {
        AVCameraPart aVCameraPart = this.f75613b0;
        return aVCameraPart != null && aVCameraPart.S9(j3);
    }

    public void ni(long j3, View view) {
        AVEffectPart aVEffectPart = this.f75617f0;
        if (aVEffectPart != null) {
            aVEffectPart.D9(j3, view);
        }
    }

    public void nj(boolean z16) {
        AVRedTouchMorePart aVRedTouchMorePart = this.f75621j0;
        if (aVRedTouchMorePart != null) {
            aVRedTouchMorePart.F9(z16);
        }
    }

    public void nk(long j3) {
        com.tencent.av.ui.part.base.panel.a aVar;
        if (isDestroyed() || (aVar = this.Z) == null) {
            return;
        }
        aVar.E9(j3);
    }

    public abstract void oi(long j3, View view);

    public void oj(Boolean bool) {
        int i3;
        Yj(bool.booleanValue());
        SessionInfo f16 = n.e().f();
        if (Yh() || (i3 = f16.f73046k2) == 2 || i3 == 1) {
            tk(false);
        }
    }

    public boolean onBackPressed() {
        if (Dh() == null || !Dh().isShown()) {
            return false;
        }
        return Dh().x();
    }

    public abstract boolean onKeyDown(int i3, KeyEvent keyEvent);

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onNewIntent(Intent intent) {
        AVVideoLayerUIPart aVVideoLayerUIPart = this.f75627p0;
        if (aVVideoLayerUIPart != null) {
            aVVideoLayerUIPart.onPause();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.H = (RelativeLayout) view.findViewById(R.id.g7p);
        QLog.d(f75610s0, 1, "onViewCreated mIsNeedChangeUIForDoubleToMulti=" + this.f75629r0);
        Ii();
        ViewGroup viewGroup = this.H;
        if (viewGroup != null) {
            viewGroup.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.tencent.av.ui.fragment.a
                @Override // android.view.View.OnLayoutChangeListener
                public final void onLayoutChange(View view2, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
                    NTBaseVideoFragment.this.fi(view2, i3, i16, i17, i18, i19, i26, i27, i28);
                }
            });
        }
        if (this.f75629r0) {
            wh().T2();
            this.f75629r0 = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedAfterPartInit(View view, Bundle bundle) {
        super.onViewCreatedAfterPartInit(view, bundle);
        AVCameraPart aVCameraPart = this.f75613b0;
        if (aVCameraPart != null) {
            aVCameraPart.onCreate();
        }
        int i3 = n.e().f().O1;
        if (QLog.isDevelopLevel()) {
            QLog.d(f75610s0, 4, "onViewCreatedAfterPartInit changeVideoLayoutMode Style=" + n.e().f().f73035i + "|" + n.e().f().O1 + "|" + r.h0().H0());
        }
        if (this.f75628q0 && n.e().f().P()) {
            wh().U2(i3);
            this.f75628q0 = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedBeforePartInit(View view, Bundle bundle) {
        super.onViewCreatedBeforePartInit(view, bundle);
        wj(getView());
    }

    void pi() {
        AVChatTimePart aVChatTimePart = this.f75615d0;
        if (aVChatTimePart == null || !aVChatTimePart.I9()) {
            return;
        }
        th(true);
    }

    public void pk(long j3) {
        AVEffectPart aVEffectPart = this.f75617f0;
        if (aVEffectPart != null) {
            aVEffectPart.G9(j3);
        }
    }

    public void qh() {
        AVVideoLayerUIPart aVVideoLayerUIPart = this.f75627p0;
        if (aVVideoLayerUIPart != null) {
            aVVideoLayerUIPart.A9();
        } else {
            this.f75628q0 = true;
            QLog.d(f75610s0, 1, "checkVideoLayerUI part is null....................", new Throwable());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void qi(long j3, View view) {
        AVEffectPart aVEffectPart = this.f75617f0;
        if (aVEffectPart != null) {
            aVEffectPart.E9(j3, view);
        }
    }

    void qk(long j3) {
        AVCameraPart aVCameraPart;
        if (isDestroyed() || (aVCameraPart = this.f75613b0) == null) {
            return;
        }
        aVCameraPart.T9(j3);
    }

    public void rh(MotionEvent motionEvent) {
        AVVideoLayerUIPart aVVideoLayerUIPart = this.f75627p0;
        if (aVVideoLayerUIPart != null) {
            aVVideoLayerUIPart.B9(motionEvent);
        }
    }

    public abstract void ri(long j3);

    public boolean rk(boolean z16, long j3) {
        AVCameraPart aVCameraPart = this.f75613b0;
        return aVCameraPart != null && aVCameraPart.U9(z16, j3);
    }

    public void sh() {
        AVToolBarPart aVToolBarPart = this.Y;
        if (aVToolBarPart != null) {
            aVToolBarPart.displayToolBar();
        }
    }

    public void sk(long j3, boolean z16, int i3) {
        AVCameraPart aVCameraPart = this.f75613b0;
        if (aVCameraPart != null) {
            aVCameraPart.V9(j3, z16, i3);
        }
    }

    public void th(boolean z16) {
        AVSharpInfoPart aVSharpInfoPart = this.V;
        if (aVSharpInfoPart != null) {
            aVSharpInfoPart.F9(z16);
        }
    }

    public abstract void ti(long j3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void tj() {
        if (isDestroyed()) {
            return;
        }
        com.tencent.av.ui.part.base.panel.d dVar = this.f75622k0;
        if (dVar != null) {
            dVar.ga();
        }
        com.tencent.av.ui.part.base.panel.c cVar = this.f75618g0;
        if (cVar != null) {
            cVar.I9();
        }
    }

    public void tk(boolean z16) {
        AVCameraPart aVCameraPart = this.f75613b0;
        if (aVCameraPart != null) {
            aVCameraPart.X9(z16);
        }
    }

    public void uh(long j3) {
        com.tencent.av.ui.part.base.panel.d dVar = this.f75622k0;
        if (dVar != null) {
            dVar.J9(j3);
        }
    }

    public void ui(long j3, View view) {
        AVRedTouchMorePart aVRedTouchMorePart = this.f75621j0;
        if (aVRedTouchMorePart != null) {
            aVRedTouchMorePart.C9(j3, view);
        }
    }

    public void uj() {
        com.tencent.av.ui.part.base.panel.d dVar = this.f75622k0;
        if (dVar != null) {
            dVar.ia();
        }
    }

    public void uk(long j3) {
        com.tencent.av.ui.part.base.panel.b bVar = this.f75614c0;
        if (bVar != null) {
            bVar.D9(j3);
        }
    }

    public void vh(int i3, boolean z16) {
        com.tencent.av.ui.part.base.panel.d dVar = this.f75622k0;
        if (dVar != null) {
            dVar.K9(i3, z16);
        }
    }

    public void vi(long j3, int i3) {
        AVRedTouchMorePart aVRedTouchMorePart = this.f75621j0;
        if (aVRedTouchMorePart != null) {
            aVRedTouchMorePart.D9(j3, i3);
        }
    }

    void vk(long j3) {
        pw.a aVar;
        if (isDestroyed() || (aVar = this.f75616e0) == null) {
            return;
        }
        aVar.F9(j3);
    }

    public AVActivity wh() {
        WeakReference<Context> weakReference = this.F;
        if (weakReference != null && (weakReference.get() instanceof AVActivity)) {
            return (AVActivity) weakReference.get();
        }
        return null;
    }

    public abstract void wi(long j3, View view);

    public int xh() {
        AVToolBarPart aVToolBarPart = this.Y;
        if (aVToolBarPart != null) {
            return aVToolBarPart.O9();
        }
        return 0;
    }

    public void xj(long j3) {
        ControlUIObserver controlUIObserver = this.I;
        if (controlUIObserver != null) {
            controlUIObserver.update(null, new Object[]{106, Long.valueOf(j3)});
        }
    }

    public boolean xk(long j3) {
        AVEffectPart aVEffectPart = this.f75617f0;
        return aVEffectPart != null && aVEffectPart.H9(j3);
    }

    public boolean yh(long j3) {
        AVCameraPart aVCameraPart;
        return (isDestroyed() || (aVCameraPart = this.f75613b0) == null || !aVCameraPart.H9(j3)) ? false : true;
    }

    public void yi(long j3, View view) {
        AVScreenSharePart aVScreenSharePart = this.f75623l0;
        if (aVScreenSharePart != null) {
            aVScreenSharePart.E9(j3, view);
        }
    }

    public void yj(long j3) {
        AVToolBarPart aVToolBarPart;
        if (isDestroyed() || (aVToolBarPart = this.Y) == null) {
            return;
        }
        aVToolBarPart.resetToolBarTimer(j3);
    }

    public boolean yk(long j3) {
        AVEffectPart aVEffectPart = this.f75617f0;
        return aVEffectPart != null && aVEffectPart.I9(j3);
    }

    public int zh() {
        return this.K;
    }

    public void zi(long j3, View view) {
        AVScreenSharePart aVScreenSharePart = this.f75623l0;
        if (aVScreenSharePart != null) {
            aVScreenSharePart.O9();
        }
    }

    public boolean zk(long j3) {
        return xk(j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void fi(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        int abs = Math.abs(i17 - i3);
        if (Math.abs(i27 - i19) == abs) {
            return;
        }
        if (Eh() != null) {
            Eh().t(abs);
        }
        if (Bh() != null) {
            Bh().onCreateUI();
        }
    }

    public void Gj() {
        this.f75629r0 = true;
        QLog.d(f75610s0, 1, "setNeedChangeUIForDoubleToMulti");
    }

    public void Ii() {
        this.C = 1;
    }

    public void Wi(long j3) {
        this.C = 4;
    }

    public void ej(long j3) {
        this.C = 3;
        h hVar = this.X;
        if (hVar != null) {
            hVar.D9(j3);
        }
    }

    public void kj(long j3) {
        this.C = 2;
        f fVar = this.U;
        if (fVar != null) {
            fVar.onStart();
        }
        AVVideoLayerUIPart aVVideoLayerUIPart = this.f75627p0;
        if (aVVideoLayerUIPart != null) {
            aVVideoLayerUIPart.I9(j3);
        }
    }

    public void lj(long j3) {
        this.C = 5;
        ek(j3);
        as asVar = this.L;
        if (asVar != null) {
            asVar.n(false);
        }
    }

    public NTBaseVideoFragment(VideoAppInterface videoAppInterface, AVActivity aVActivity, ControlUIObserver controlUIObserver) {
        this.C = 0;
        this.D = 0;
        this.E = null;
        this.J = null;
        this.K = 0;
        this.L = null;
        this.M = false;
        this.N = false;
        this.f75628q0 = false;
        this.f75629r0 = false;
        String str = getClass().getSimpleName() + "_" + e.d();
        f75610s0 = str;
        QLog.d(str, 1, "NTBaseVideoFragment " + this);
        if (videoAppInterface == null) {
            return;
        }
        this.G = videoAppInterface;
        this.F = new WeakReference<>(aVActivity);
        AVActivity wh5 = wh();
        if (wh5 == null) {
            if (QLog.isColorLevel()) {
                QLog.e(f75610s0, 2, "VideoControlUI-->can not get AVActivity");
                return;
            }
            return;
        }
        Resources resources = wh5.getResources();
        this.E = resources;
        if (resources == null) {
            AVCoreLog.printAllUserLog(f75610s0, "mRes is null. exit video progress");
            QQToast.makeText(wh5.getApplicationContext(), wh5.getString(R.string.ico) + " 0x08", 0).show();
            wh5.finish();
            return;
        }
        if (r.h0() == null) {
            AVCoreLog.printAllUserLog(f75610s0, "VideoController.getInstance() is null. exit video progress");
            QQToast.makeText(wh5.getApplicationContext(), this.E.getString(R.string.ico) + " 0x09", 0).show();
            wh5.finish();
            return;
        }
        this.I = controlUIObserver;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations").contains("KEY_SHARE_MIRROR_SWITCH_IS_OPEN")) {
            return;
        }
        vu.a.o(peekAppRuntime, "KEY_SHARE_MIRROR_SWITCH_IS_OPEN", false);
    }

    public void Ck(long j3) {
    }

    public void Fj(int i3) {
    }

    public void Gk(long j3) {
    }

    void Mk(long j3) {
    }

    public void Nh(boolean z16) {
    }

    public void Nj(String str) {
    }

    void Nk(long j3) {
    }

    public void Qk(long j3) {
    }

    public void Ti(boolean z16) {
    }

    public void Wj(boolean z16) {
    }

    public void Xh(Activity activity) {
    }

    public void cj(int i3) {
    }

    public void ok(long j3) {
    }

    public void pj(long j3) {
    }

    public void qj(long j3) {
    }

    public void wk(long j3) {
    }

    public void xi(long j3) {
    }

    void Gi() {
    }

    public void Ji() {
    }

    public void Mh() {
    }

    public void Oi() {
    }

    public void Pk() {
    }

    public void Ri() {
    }

    public void Rk() {
    }

    public void Th() {
    }

    public void Vi() {
    }

    public void Yi() {
    }

    public void Zi() {
    }

    public void gj() {
    }

    public void hj() {
    }

    public void refreshUI() {
    }

    public void vj() {
    }

    public void Mi(String str, String str2) {
    }

    public void Mj(String str, Bitmap bitmap) {
    }

    public void Pj(long j3, int i3) {
    }

    public void Tj(int i3, boolean z16) {
    }

    public void aj(String str, boolean z16) {
    }

    public void bj(boolean z16, boolean z17) {
    }

    public void dj(long j3, boolean z16) {
    }

    public void ij(boolean z16, boolean z17) {
    }

    public void mj(int i3, int i16) {
    }

    public void si(long j3, View view) {
    }

    public void zj(boolean z16, int i3) {
    }

    public void Pi(long j3, int i3, int i16) {
    }

    public void Qi(long j3, int i3, int i16) {
    }

    public void Uj(long j3, String str, boolean z16) {
    }

    public void sj(int i3, int i16, String str) {
    }

    public void rj(String str, int i3, String str2, int i16) {
    }
}
