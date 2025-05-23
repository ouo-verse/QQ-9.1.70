package com.tencent.tedger.init;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.tedger.outapi.api.IInitStateManager;
import com.tencent.tedger.outapi.delegate.ITEdgeRSSDKComponentDelegate;
import com.tencent.tedger.reshub.ResHubHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import ve4.j;

/* compiled from: P */
/* loaded from: classes26.dex */
public class EdgeInitStateManager extends com.tencent.tedgecontext.b implements j {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private IInitStateManager.TEdgeRSInitStep f375242a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f375243b;

    /* renamed from: c, reason: collision with root package name */
    private volatile boolean f375244c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f375245d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.tedger.init.EdgeInitStateManager$4, reason: invalid class name */
    /* loaded from: classes26.dex */
    public class AnonymousClass4 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ j.a f375246d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ IInitStateManager.a f375247e;

        AnonymousClass4(j.a aVar, IInitStateManager.a aVar2) {
            this.f375246d = aVar;
            this.f375247e = aVar2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, EdgeInitStateManager.this, aVar, aVar2);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (!EdgeInitStateManager.this.Z() && !EdgeInitStateManager.this.f375244c) {
                EdgeInitStateManager.this.f375244c = true;
                ResHubHelper.d().g(EdgeInitStateManager.this.getContext());
                ResHubHelper.d().f(EdgeInitStateManager.this.getContext());
                EdgeInitStateManager.this.U(this.f375246d, this.f375247e, new j.b() { // from class: com.tencent.tedger.init.EdgeInitStateManager.4.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass4.this);
                        }
                    }

                    @Override // ve4.j.b
                    public void a(int i3) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                            iPatchRedirector2.redirect((short) 3, (Object) this, i3);
                            return;
                        }
                        IInitStateManager.TEdgeRSInitStep y16 = EdgeInitStateManager.this.y();
                        ((com.tencent.tedgecontext.b) EdgeInitStateManager.this).mLog.e("TEdgeInitStateManager", i3, "init sdk fail.fail step is: " + EdgeInitStateManager.this.c0(y16) + ", current step is: " + y16);
                        EdgeInitStateManager.this.d0();
                        EdgeInitStateManager.this.f375244c = false;
                        AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                        IInitStateManager.a aVar = anonymousClass4.f375247e;
                        if (aVar != null && aVar.b(EdgeInitStateManager.this.c0(y16), i3)) {
                            EdgeInitStateManager.this.asyncRun(new Runnable() { // from class: com.tencent.tedger.init.EdgeInitStateManager.4.1.1
                                static IPatchRedirector $redirector_;

                                {
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                        iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                                    }
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                        iPatchRedirector3.redirect((short) 2, (Object) this);
                                    } else {
                                        AnonymousClass4 anonymousClass42 = AnonymousClass4.this;
                                        EdgeInitStateManager.this.g(anonymousClass42.f375246d, anonymousClass42.f375247e);
                                    }
                                }
                            });
                        }
                    }

                    @Override // ve4.j.b
                    public void success() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        if (EdgeInitStateManager.this.o()) {
                            ((com.tencent.tedgecontext.b) EdgeInitStateManager.this).mLog.c("TEdgeInitStateManager", "init sdk success with edge rank enable.");
                        } else {
                            ((com.tencent.tedgecontext.b) EdgeInitStateManager.this).mLog.c("TEdgeInitStateManager", "init sdk success without edge rank.");
                        }
                        EdgeInitStateManager.this.f375244c = false;
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class a implements ITEdgeRSSDKComponentDelegate.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f375250a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f375251b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ CountDownLatch f375252c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ List f375253d;

        a(String str, int i3, CountDownLatch countDownLatch, List list) {
            this.f375250a = str;
            this.f375251b = i3;
            this.f375252c = countDownLatch;
            this.f375253d = list;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, EdgeInitStateManager.this, str, Integer.valueOf(i3), countDownLatch, list);
            }
        }

        @Override // com.tencent.tedger.outapi.delegate.ITEdgeRSSDKComponentDelegate.a
        public void complete() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (!EdgeInitStateManager.this.getContext().d().f(this.f375250a)) {
                ((com.tencent.tedgecontext.b) EdgeInitStateManager.this).mLog.e("TEdgeInitStateManager", 13, "SDK init fail for load so(" + this.f375250a + ") fail.");
                for (int i3 = 0; i3 < this.f375251b; i3++) {
                    this.f375252c.countDown();
                }
                return;
            }
            this.f375253d.remove(this.f375250a);
            this.f375252c.countDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class b implements IInitStateManager.a.InterfaceC9900a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ j.b f375255a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ j.a f375256b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ IInitStateManager.a f375257c;

        b(j.b bVar, j.a aVar, IInitStateManager.a aVar2) {
            this.f375255a = bVar;
            this.f375256b = aVar;
            this.f375257c = aVar2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, EdgeInitStateManager.this, bVar, aVar, aVar2);
            }
        }

        @Override // com.tencent.tedger.outapi.api.IInitStateManager.a.InterfaceC9900a
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                ((com.tencent.tedgecontext.b) EdgeInitStateManager.this).mLog.c("TEdgeInitStateManager", "edge rank should be need, the sdk will continue init for edge rank.");
                EdgeInitStateManager.this.U(this.f375256b, this.f375257c, this.f375255a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class c implements j.b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IInitStateManager.TEdgeRSInitStep f375259a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ j.a f375260b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ IInitStateManager.a f375261c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ j.b f375262d;

        c(IInitStateManager.TEdgeRSInitStep tEdgeRSInitStep, j.a aVar, IInitStateManager.a aVar2, j.b bVar) {
            this.f375259a = tEdgeRSInitStep;
            this.f375260b = aVar;
            this.f375261c = aVar2;
            this.f375262d = bVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, EdgeInitStateManager.this, tEdgeRSInitStep, aVar, aVar2, bVar);
            }
        }

        @Override // ve4.j.b
        public void a(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
            } else {
                this.f375262d.a(i3);
            }
        }

        @Override // ve4.j.b
        public void success() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                ((com.tencent.tedgecontext.b) EdgeInitStateManager.this).mLog.c("TEdgeInitStateManager", "sdk init success to step: " + this.f375259a);
                EdgeInitStateManager.this.e0(this.f375259a);
                EdgeInitStateManager.this.V(this.f375260b, this.f375261c, this.f375262d);
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static /* synthetic */ class d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f375264a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33670);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[IInitStateManager.TEdgeRSInitStep.values().length];
            f375264a = iArr;
            try {
                iArr[IInitStateManager.TEdgeRSInitStep.GotConfig.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f375264a[IInitStateManager.TEdgeRSInitStep.LoadedSO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f375264a[IInitStateManager.TEdgeRSInitStep.InitializedSO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f375264a[IInitStateManager.TEdgeRSInitStep.CheckedConfig.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f375264a[IInitStateManager.TEdgeRSInitStep.CheckedVersion.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f375264a[IInitStateManager.TEdgeRSInitStep.Begin.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public EdgeInitStateManager(com.tencent.tedgecontext.a aVar) {
        super(aVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
            return;
        }
        this.f375242a = IInitStateManager.TEdgeRSInitStep.Begin;
        this.f375243b = false;
        this.f375244c = false;
        this.f375245d = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public void U(@NonNull j.a aVar, @Nullable IInitStateManager.a aVar2, @NonNull j.b bVar) {
        if (getRouter().a()) {
            this.mLog.c("TEdgeInitStateManager", "sdk init complete for it is be destroyed!");
            return;
        }
        if (y() == IInitStateManager.TEdgeRSInitStep.Begin && aVar2 != null) {
            aVar2.a(y(), null);
        }
        IInitStateManager.TEdgeRSInitStep c06 = c0(y());
        X(aVar, c06, new c(c06, aVar, aVar2, bVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public void V(@NonNull j.a aVar, IInitStateManager.a aVar2, j.b bVar) {
        if (Z()) {
            bVar.success();
            if (aVar2 != null) {
                aVar2.a(y(), null);
                return;
            }
            return;
        }
        if (aVar2 != null && Y()) {
            aVar2.a(y(), new b(bVar, aVar, aVar2));
            return;
        }
        if (aVar2 != null) {
            aVar2.a(y(), null);
        }
        U(aVar, aVar2, bVar);
    }

    @WorkerThread
    private void W(j.b bVar) {
        if (getRouter().f375304b.D()) {
            bVar.success();
        } else {
            this.mLog.f("TEdgeInitStateManager", 12, "SDK init fail for TAB Config checked fail.");
            bVar.a(12);
        }
    }

    private void X(@NonNull j.a aVar, @NonNull IInitStateManager.TEdgeRSInitStep tEdgeRSInitStep, @NonNull j.b bVar) {
        int i3 = d.f375264a[tEdgeRSInitStep.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        bVar.success();
                        return;
                    } else {
                        W(bVar);
                        return;
                    }
                }
                aVar.a(bVar);
                return;
            }
            b0(bVar);
            return;
        }
        a0(bVar);
    }

    private boolean Y() {
        if (y() == IInitStateManager.TEdgeRSInitStep.CheckedConfig) {
            return true;
        }
        return false;
    }

    @WorkerThread
    private void a0(@NonNull j.b bVar) {
        int initConfig = getRouter().f375304b.initConfig();
        if (initConfig == 0) {
            bVar.success();
            return;
        }
        this.mLog.f("TEdgeInitStateManager", 11, "SDK init fail for TAB Config load fail." + initConfig);
        bVar.a(11);
    }

    @WorkerThread
    private void b0(@NonNull j.b bVar) {
        List<String> f16 = getRouter().f375304b.f();
        if (f16 == null) {
            this.mLog.e("TEdgeInitStateManager", 13, "so config don't exist");
            bVar.a(13);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : f16) {
            if (!TextUtils.isEmpty(str) && !getContext().d().f(str)) {
                arrayList.add(str);
            }
        }
        if (arrayList.isEmpty()) {
            bVar.success();
        } else {
            f0(bVar, arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public IInitStateManager.TEdgeRSInitStep c0(IInitStateManager.TEdgeRSInitStep tEdgeRSInitStep) {
        int i3 = d.f375264a[tEdgeRSInitStep.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 != 6) {
                            return IInitStateManager.TEdgeRSInitStep.End;
                        }
                        return IInitStateManager.TEdgeRSInitStep.GotConfig;
                    }
                    return IInitStateManager.TEdgeRSInitStep.LoadedSO;
                }
                return IInitStateManager.TEdgeRSInitStep.CheckedVersion;
            }
            return IInitStateManager.TEdgeRSInitStep.InitializedSO;
        }
        return IInitStateManager.TEdgeRSInitStep.CheckedConfig;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public IInitStateManager.TEdgeRSInitStep d0() {
        int i3 = d.f375264a[c0(y()).ordinal()];
        if (i3 != 1 && i3 != 4) {
            e0(IInitStateManager.TEdgeRSInitStep.CheckedConfig);
        } else {
            e0(IInitStateManager.TEdgeRSInitStep.Begin);
        }
        return y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e0(IInitStateManager.TEdgeRSInitStep tEdgeRSInitStep) {
        synchronized (this) {
            if (tEdgeRSInitStep == IInitStateManager.TEdgeRSInitStep.InitializedSO) {
                this.mLog.d("TEdgeInitStateManager", "");
            }
            this.mLog.d("TEdgeInitStateManager", "setCurrentInitStep: " + tEdgeRSInitStep);
            this.f375242a = tEdgeRSInitStep;
        }
    }

    @WorkerThread
    private void f0(@NonNull j.b bVar, @NonNull List<String> list) {
        int size = list.size();
        CountDownLatch countDownLatch = new CountDownLatch(size);
        for (String str : list) {
            getContext().d().d(str, new a(str, size, countDownLatch, list));
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e16) {
            this.mLog.e("TEdgeInitStateManager", 13, "asyncLoadWaitingSo countDownLatch exception" + e16);
        }
        if (list.isEmpty()) {
            bVar.success();
        } else {
            bVar.a(13);
        }
    }

    public boolean Z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if (y() == IInitStateManager.TEdgeRSInitStep.End) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.tedger.outapi.api.IInitStateManager
    public void c(Map<String, Object> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) map);
        } else if (map != null && map.size() > 0) {
            getContext().d().c(new HashMap(map));
        }
    }

    @Override // ve4.j
    public void g(@NonNull j.a aVar, @Nullable IInitStateManager.a aVar2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar, (Object) aVar2);
        } else {
            if (Z() || this.f375244c) {
                return;
            }
            asyncRun(new AnonymousClass4(aVar, aVar2));
        }
    }

    @Override // com.tencent.tedger.outapi.api.IInitStateManager
    public boolean o() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        synchronized (this) {
            z16 = this.f375245d;
        }
        return z16;
    }

    @Override // com.tencent.tedger.outapi.api.IInitStateManager
    public boolean w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        if (y() == IInitStateManager.TEdgeRSInitStep.End) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.tedger.outapi.api.IInitStateManager
    public IInitStateManager.TEdgeRSInitStep y() {
        IInitStateManager.TEdgeRSInitStep tEdgeRSInitStep;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (IInitStateManager.TEdgeRSInitStep) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        synchronized (this) {
            tEdgeRSInitStep = this.f375242a;
        }
        return tEdgeRSInitStep;
    }
}
