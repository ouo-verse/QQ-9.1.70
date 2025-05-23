package com.tencent.mobileqq.webview.swift.component;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.smtt.sdk.WebAccelerator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
/* loaded from: classes20.dex */
class SwiftBrowserWebViewHandler$1 implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ Context f314430d;
    final /* synthetic */ x this$0;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.webview.swift.component.SwiftBrowserWebViewHandler$1$1, reason: invalid class name */
    /* loaded from: classes20.dex */
    class AnonymousClass1 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ SwiftBrowserWebViewHandler$1 f314431d;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                this.f314431d.getClass();
                throw null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit b(Context context) {
        WebAccelerator.initTbsEnvironment(context, 2);
        return null;
    }

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        System.currentTimeMillis();
        final Context context = this.f314430d;
        com.tencent.mobileqq.webview.swift.utils.p.a(new Function0() { // from class: com.tencent.mobileqq.webview.swift.component.w
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit b16;
                b16 = SwiftBrowserWebViewHandler$1.b(context);
                return b16;
            }
        });
        throw null;
    }
}
