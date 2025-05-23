package com.tencent.mobileqq.vas.adapter;

import android.os.Bundle;
import com.etrump.mixlayout.ETTextView;
import com.etrump.mixlayout.k;
import com.etrump.mixlayout.m;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.util.g;
import com.tencent.mobileqq.vas.VasResEngine.VasRes;
import com.tencent.mobileqq.vas.VasResEngine.VasResAdapter;
import com.tencent.mobileqq.vas.VasResEngine.VasResController;
import com.tencent.mobileqq.vas.font.api.FontLoadCallback;
import com.tencent.mobileqq.vas.font.api.IFontManagerService;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.qphone.base.util.QLog;
import java.util.Observable;
import java.util.Observer;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a implements VasResAdapter {

    /* renamed from: a, reason: collision with root package name */
    protected VasResController f307930a;

    /* renamed from: b, reason: collision with root package name */
    protected int f307931b;

    /* renamed from: d, reason: collision with root package name */
    private ETTextView f307933d;

    /* renamed from: e, reason: collision with root package name */
    private float f307934e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f307935f;

    /* renamed from: i, reason: collision with root package name */
    protected WeakReference<AppRuntime> f307938i;

    /* renamed from: j, reason: collision with root package name */
    protected IFontManagerService f307939j;

    /* renamed from: c, reason: collision with root package name */
    private long f307932c = System.currentTimeMillis();

    /* renamed from: g, reason: collision with root package name */
    private int f307936g = 1;

    /* renamed from: h, reason: collision with root package name */
    private int f307937h = 1;

    /* renamed from: k, reason: collision with root package name */
    private c f307940k = new c(this);

    /* renamed from: l, reason: collision with root package name */
    private Observer f307941l = new C8895a();

    /* renamed from: m, reason: collision with root package name */
    private ETTextView.e f307942m = new b();

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.vas.adapter.a$a, reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    class C8895a implements Observer {
        C8895a() {
        }

        @Override // java.util.Observer
        public void update(Observable observable, Object obj) {
            if (QLog.isColorLevel()) {
                QLog.d("SignatureFontAdapter", 2, "SignatureFontAdapter type = " + obj);
            }
            if (obj instanceof Integer) {
                int intValue = ((Integer) obj).intValue();
                if (intValue != 1) {
                    if (intValue == 2) {
                        a.this.f307930a.getUIHanlder().sendEmptyMessage(10002);
                        return;
                    }
                    return;
                }
                a.this.f307930a.getUIHanlder().sendEmptyMessage(10003);
                return;
            }
            a.this.f307930a.getUIHanlder().sendEmptyMessage(10003);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class c implements FontLoadCallback {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<a> f307945d;

        public c(a aVar) {
            this.f307945d = new WeakReference<>(aVar);
        }

        @Override // com.tencent.mobileqq.vas.font.api.FontLoadCallback
        public void onFontLoaded() {
            a aVar = this.f307945d.get();
            if (aVar != null) {
                aVar.g();
            }
        }
    }

    public a(VasRes vasRes, AppRuntime appRuntime, int i3) {
        this.f307930a = vasRes.getVasResController();
        this.f307938i = new WeakReference<>(appRuntime);
        this.f307931b = i3;
        m.e().addObserver(this.f307941l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        IFontManagerService iFontManagerService;
        this.f307930a.getUIHanlder().sendEmptyMessage(10003);
        if (VasNormalToggle.VAS_BUG_113811566_11_29.isEnable(true) && (iFontManagerService = this.f307939j) != null) {
            iFontManagerService.removeFontLoadCallback(this.f307940k);
            this.f307939j = null;
        }
    }

    @Override // com.tencent.mobileqq.vas.VasResEngine.VasResAdapter
    public void destroy() {
        m.e().deleteObserver(this.f307941l);
        ETTextView eTTextView = this.f307933d;
        if (eTTextView != null) {
            eTTextView.setTextAnimationListener(null);
            this.f307933d = null;
        }
        IFontManagerService iFontManagerService = this.f307939j;
        if (iFontManagerService != null) {
            iFontManagerService.removeFontLoadCallback(this.f307940k);
        }
        this.f307939j = null;
        if (this.f307938i != null) {
            this.f307938i = null;
        }
    }

    @Override // com.tencent.mobileqq.vas.VasResEngine.VasResAdapter
    public void downloadDone(int i3, Bundle bundle) {
        if (QLog.isColorLevel()) {
            QLog.d("SignatureFontAdapter", 2, "downloadDone type = " + i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public k f(int i3, int i16) {
        WeakReference<AppRuntime> weakReference = this.f307938i;
        if (weakReference == null) {
            return null;
        }
        AppRuntime appRuntime = weakReference.get();
        if (!(appRuntime instanceof QQAppInterface)) {
            return null;
        }
        IFontManagerService iFontManagerService = (IFontManagerService) appRuntime.getRuntimeService(IFontManagerService.class, "");
        this.f307939j = iFontManagerService;
        iFontManagerService.addFontLoadCallback(this.f307940k);
        return iFontManagerService.getFontInfo(i3, i16, false, ((QQAppInterface) appRuntime).getCurrentUin(), 0);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r6v0 ??, still in use, count: 1, list:
          (r6v0 ?? I:com.etrump.mixlayout.ETFont) from 0x0022: IPUT (r6v0 ?? I:com.etrump.mixlayout.ETFont), (r9v0 ?? I:com.etrump.mixlayout.k) (LINE:35) com.etrump.mixlayout.k.f com.etrump.mixlayout.ETFont
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:151)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:116)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:88)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:87)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:72)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:54)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:34)
        */
    protected void h(
    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r6v0 ??, still in use, count: 1, list:
          (r6v0 ?? I:com.etrump.mixlayout.ETFont) from 0x0022: IPUT (r6v0 ?? I:com.etrump.mixlayout.ETFont), (r9v0 ?? I:com.etrump.mixlayout.k) (LINE:35) com.etrump.mixlayout.k.f com.etrump.mixlayout.ETFont
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:151)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:116)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:88)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:87)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:72)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:54)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r8v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:237)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:223)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:168)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
        */

    public void i(int i3) {
        this.f307936g = i3;
    }

    public void j(ETTextView eTTextView, float f16, boolean z16) {
        this.f307933d = eTTextView;
        this.f307934e = f16;
        this.f307935f = z16;
        eTTextView.setTextAnimationListener(this.f307942m);
    }

    public void k(int i3, int i16) {
        if (i3 == 0) {
            this.f307933d.setFont(0, System.currentTimeMillis());
            return;
        }
        this.f307930a.update(i3);
        this.f307931b = i16;
        load();
    }

    @Override // com.tencent.mobileqq.vas.VasResEngine.VasResAdapter
    public void load() {
        k d16;
        ETTextView eTTextView;
        if (g.b()) {
            d16 = f(this.f307930a.getId(), this.f307931b);
        } else {
            d16 = m.e().d(this.f307930a.getId(), this.f307931b);
        }
        if (d16 != null && (eTTextView = this.f307933d) != null) {
            h(eTTextView, d16, this.f307934e);
        }
    }

    public a(AppInterface appInterface, int i3, int i16) {
        VasRes vasRes = new VasRes(appInterface, i3);
        this.f307930a = vasRes.getVasResController();
        this.f307931b = i16;
        m.e().addObserver(this.f307941l);
        vasRes.setAdapter(this);
        this.f307938i = new WeakReference<>(appInterface);
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class b extends ETTextView.e {
        b() {
        }

        @Override // com.etrump.mixlayout.ETTextView.e
        public void a(ChatMessage chatMessage, int i3) {
            if (a.this.f307936g < 0 || a.this.f307937h < a.this.f307936g) {
                a.this.f307933d.f32619o0 = true;
                a.this.f307933d.X(false, false);
                if (a.this.f307936g > 0) {
                    a.this.f307937h++;
                }
            }
        }

        @Override // com.etrump.mixlayout.ETTextView.e
        public void b(ChatMessage chatMessage, boolean z16, int i3) {
        }
    }
}
