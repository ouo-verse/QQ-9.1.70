package com.tencent.mobileqq.ar.ARRenderModel;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.ar.ARRenderModel.h;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.model.ArFeatureInfo;
import com.tencent.mobileqq.ar.model.ArVideoResourceInfo;
import com.tencent.mobileqq.ar.model.ArWebInfo;
import com.tencent.mobileqq.ar.model.QQARSession;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: P */
/* loaded from: classes11.dex */
public class MultiFragmentAnimRenderable implements a, Handler.Callback, c {

    /* renamed from: d, reason: collision with root package name */
    private c f197183d;

    /* renamed from: e, reason: collision with root package name */
    private o f197184e;

    /* renamed from: f, reason: collision with root package name */
    private a f197185f;

    /* renamed from: h, reason: collision with root package name */
    private a f197186h;

    /* renamed from: i, reason: collision with root package name */
    private ArVideoResourceInfo f197187i;

    /* renamed from: m, reason: collision with root package name */
    h.a f197188m = null;
    private int C = 0;
    private ReentrantLock E = new ReentrantLock();
    private boolean F = false;
    private boolean G = false;
    private Handler D = new Handler(ThreadManagerV2.getSubThreadLooper(), this);

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.ar.ARRenderModel.MultiFragmentAnimRenderable$3, reason: invalid class name */
    /* loaded from: classes11.dex */
    class AnonymousClass3 implements Runnable {
        final /* synthetic */ MultiFragmentAnimRenderable this$0;

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.onDestroy();
            if (this.this$0.f197183d != null) {
                this.this$0.f197183d.h(1, 0);
            }
        }
    }

    public MultiFragmentAnimRenderable(c cVar, o oVar) {
        this.f197183d = cVar;
        this.f197184e = oVar;
    }

    private e r(ArVideoResourceInfo arVideoResourceInfo) {
        int i3;
        ArCloudConfigInfo arCloudConfigInfo = new ArCloudConfigInfo();
        arCloudConfigInfo.f197702i = arVideoResourceInfo.D;
        if (QLog.isDebugVersion() && (i3 = arVideoResourceInfo.D) != 2 && i3 != 3 && i3 != 4) {
            QLog.e("AREngine_MultiFragmentAnimRenderable", 1, HardCodeUtil.qqStr(R.string.obq));
            QLog.i("AREngine_MultiFragmentAnimRenderable", 2, "buildARRenderResourceInfoForFragmentAnim animInfo.type=" + arVideoResourceInfo.D);
        }
        ArrayList<ArVideoResourceInfo> arrayList = new ArrayList<>();
        arrayList.add(arVideoResourceInfo);
        arCloudConfigInfo.D = arrayList;
        ArFeatureInfo arFeatureInfo = new ArFeatureInfo();
        arFeatureInfo.f198409d = arVideoResourceInfo.f198430i;
        o oVar = this.f197184e;
        ArCloudConfigInfo arCloudConfigInfo2 = oVar.f197319i;
        arFeatureInfo.f198413i = arCloudConfigInfo2.E.f198413i;
        arCloudConfigInfo.E = arFeatureInfo;
        arCloudConfigInfo.f197701h = arCloudConfigInfo2.f197701h;
        return QQARSession.v0(arCloudConfigInfo, true, oVar.f197227c, oVar.f197229e, oVar.f197230f, oVar.f197231g, oVar.f197232h);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x00a3, code lost:
    
        if (r8 != 2048) goto L27;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00d0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private a s(ArVideoResourceInfo arVideoResourceInfo, int i3) {
        int i16;
        int i17;
        e r16 = r(arVideoResourceInfo);
        a a16 = g.a(this, r16, null);
        boolean z16 = true;
        QLog.d("AREngine_MultiFragmentAnimRenderable", 1, "create new render here " + a16);
        if (a16 != null) {
            if (!TextUtils.isEmpty(arVideoResourceInfo.F) && FileUtils.fileExists(arVideoResourceInfo.F) && this.f197184e.f197319i.D.size() > (i17 = i3 + 1)) {
                ArVideoResourceInfo arVideoResourceInfo2 = this.f197184e.f197319i.D.get(i17);
                if (arVideoResourceInfo2.D == 4 && !TextUtils.isEmpty(arVideoResourceInfo2.F) && !FileUtils.fileExists(arVideoResourceInfo2.F)) {
                    if (QLog.isColorLevel()) {
                        QLog.w("AREngine_MultiFragmentAnimRenderable", 2, "preload next online video, " + arVideoResourceInfo2.E + ", " + arVideoResourceInfo2.F);
                    }
                    y81.a.e(BaseApplication.getContext(), arVideoResourceInfo2);
                }
            }
            if (r16.f197226b == 5) {
                long j3 = r16.f197227c;
                if (j3 != 2) {
                }
                this.f197183d.k().f();
                this.f197183d.k().g(z16, r16);
                i16 = r16.f197226b;
                if (i16 != 0) {
                    this.f197183d.k().a(r16.f197228d, r16.f197226b, ((k) r16).f197286l);
                } else if (i16 != 2 && i16 != 3) {
                    if (i16 == 4) {
                        this.f197183d.k().a(r16.f197228d, r16.f197226b, ((q) r16).f197331o);
                    }
                } else {
                    this.f197183d.k().a(r16.f197228d, r16.f197226b, ((p) r16).f197324m);
                }
            }
            z16 = false;
            this.f197183d.k().f();
            this.f197183d.k().g(z16, r16);
            i16 = r16.f197226b;
            if (i16 != 0) {
            }
        }
        return a16;
    }

    private void t() {
        if (!this.f197184e.f197319i.D.isEmpty()) {
            int size = this.f197184e.f197319i.D.size();
            int i3 = this.C;
            if (size > i3 + 1) {
                ArVideoResourceInfo arVideoResourceInfo = this.f197184e.f197319i.D.get(i3 + 1);
                final a s16 = s(arVideoResourceInfo, this.C + 1);
                if (s16 == null) {
                    this.D.sendEmptyMessageDelayed(0, 100L);
                    return;
                }
                this.f197186h = this.f197185f;
                this.f197185f = s16;
                this.f197187i = arVideoResourceInfo;
                this.C++;
                this.f197183d.i(new Runnable() { // from class: com.tencent.mobileqq.ar.ARRenderModel.MultiFragmentAnimRenderable.1
                    @Override // java.lang.Runnable
                    public void run() {
                        s16.init();
                        s16.start();
                    }
                });
            }
        }
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.a
    public boolean canRender() {
        a aVar;
        a aVar2 = this.f197185f;
        if (aVar2 != null) {
            if (!aVar2.o() && (aVar = this.f197186h) != null) {
                return aVar.canRender();
            }
            return this.f197185f.canRender();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.c
    public Context d() {
        return this.f197183d.d();
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.c
    public Object e(int i3) {
        return this.f197183d.e(i3);
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.a
    public int g() {
        a aVar = this.f197185f;
        if (aVar != null) {
            if (this.f197186h != null && !aVar.o()) {
                return this.f197186h.g();
            }
            return this.f197185f.g();
        }
        return 2;
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.a
    public int getType() {
        a aVar;
        a aVar2 = this.f197185f;
        if (aVar2 != null) {
            if (!aVar2.o() && (aVar = this.f197186h) != null) {
                return aVar.getType();
            }
            return this.f197185f.getType();
        }
        return 5;
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.a
    public String getUniqueKey() {
        return this.f197184e.f197225a;
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.c
    public void h(int i3, int i16) {
        if (QLog.isColorLevel()) {
            QLog.d("AREngine_MultiFragmentAnimRenderable", 2, "notifyAnimationPlayStatusChange state:" + i3 + " remainTimes:" + i16);
        }
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        return;
                    }
                } else {
                    ArVideoResourceInfo arVideoResourceInfo = this.f197187i;
                    if (arVideoResourceInfo != null && (arVideoResourceInfo.b() || this.f197184e.f197319i.D.size() == this.C + 1)) {
                        ArWebInfo arWebInfo = this.f197184e.f197319i.H;
                        if ((arWebInfo == null || !arWebInfo.f198432d || i16 <= 0) && !this.F && this.f197186h == null) {
                            this.F = true;
                            this.f197183d.h(i3, 0);
                            return;
                        }
                        return;
                    }
                    ArVideoResourceInfo arVideoResourceInfo2 = this.f197187i;
                    if (arVideoResourceInfo2 != null && arVideoResourceInfo2.c()) {
                        if (!this.G) {
                            this.G = true;
                            this.f197183d.n(this.f197187i, this);
                            return;
                        }
                        return;
                    }
                    ArVideoResourceInfo arVideoResourceInfo3 = this.f197187i;
                    if (arVideoResourceInfo3 != null && arVideoResourceInfo3.a() && i16 <= 0) {
                        t();
                        return;
                    }
                    return;
                }
            }
            this.D.sendEmptyMessage(0);
            return;
        }
        if (this.C == 0) {
            this.f197183d.h(i3, i16);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        c cVar;
        if (message.what == 0 && (cVar = this.f197183d) != null) {
            cVar.i(new Runnable() { // from class: com.tencent.mobileqq.ar.ARRenderModel.MultiFragmentAnimRenderable.4
                @Override // java.lang.Runnable
                public void run() {
                    MultiFragmentAnimRenderable.this.onDestroy();
                    if (MultiFragmentAnimRenderable.this.f197183d != null) {
                        MultiFragmentAnimRenderable.this.f197183d.h(1, 0);
                    }
                }
            });
            return false;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.c
    public void i(Runnable runnable) {
        this.f197183d.i(runnable);
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.a
    public void init() {
        if (!this.f197184e.f197319i.D.isEmpty()) {
            this.C = 0;
            ArVideoResourceInfo arVideoResourceInfo = this.f197184e.f197319i.D.get(0);
            this.f197185f = s(arVideoResourceInfo, this.C);
            this.f197187i = arVideoResourceInfo;
        }
        a aVar = this.f197185f;
        if (aVar == null) {
            this.D.sendEmptyMessageDelayed(0, 100L);
        } else {
            aVar.init();
        }
        this.F = false;
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.c
    public void j(ArVideoResourceInfo arVideoResourceInfo) {
        t();
        this.G = false;
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.c
    public h k() {
        return this.f197183d.k();
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.a
    public void l(h.a aVar) {
        a aVar2 = this.f197185f;
        if (aVar2 != null) {
            if (!aVar2.o() && this.f197186h != null && this.f197188m != null) {
                this.E.lock();
                a aVar3 = this.f197186h;
                if (aVar3 != null) {
                    aVar3.l(this.f197188m);
                }
                this.E.unlock();
                return;
            }
            if (this.f197186h != null) {
                this.f197183d.i(new Runnable() { // from class: com.tencent.mobileqq.ar.ARRenderModel.MultiFragmentAnimRenderable.2
                    @Override // java.lang.Runnable
                    public void run() {
                        MultiFragmentAnimRenderable.this.E.lock();
                        if (MultiFragmentAnimRenderable.this.f197186h != null) {
                            MultiFragmentAnimRenderable.this.f197186h.onDestroy();
                            MultiFragmentAnimRenderable.this.f197186h = null;
                        }
                        MultiFragmentAnimRenderable.this.E.unlock();
                    }
                });
            }
            this.f197185f.l(aVar);
            this.f197188m = aVar;
        }
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.a
    public boolean o() {
        a aVar = this.f197185f;
        if (aVar != null) {
            if (this.f197186h != null && !aVar.o()) {
                return this.f197186h.o();
            }
            return this.f197185f.o();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.a
    public void onDestroy() {
        if (QLog.isColorLevel()) {
            QLog.w("AREngine_MultiFragmentAnimRenderable", 2, "onDestroy currentRenderable " + this.f197185f + "  lastRenderable " + this.f197186h);
        }
        a aVar = this.f197185f;
        if (aVar != null) {
            aVar.onDestroy();
            this.f197185f = null;
        }
        a aVar2 = this.f197186h;
        if (aVar2 != null) {
            aVar2.onDestroy();
            this.f197186h = null;
        }
        this.f197188m = null;
        Handler handler = this.D;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.F = false;
        this.G = false;
        y81.a.f();
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.a
    public void onUpdate() {
        a aVar = this.f197185f;
        if (aVar != null) {
            aVar.onUpdate();
        }
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.c
    public void requestRender() {
        this.f197183d.requestRender();
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.a
    public void start() {
        a aVar = this.f197185f;
        if (aVar != null) {
            aVar.start();
        }
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.c
    public void f(String str) {
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.a
    public void c(int i3, int i16) {
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.c
    public void n(ArVideoResourceInfo arVideoResourceInfo, c cVar) {
    }

    @Override // com.tencent.mobileqq.ar.ARRenderModel.c
    public void m(a aVar, ArCloudConfigInfo arCloudConfigInfo, int i3, int i16, Object obj) {
    }
}
