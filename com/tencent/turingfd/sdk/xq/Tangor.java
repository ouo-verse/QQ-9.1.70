package com.tencent.turingfd.sdk.xq;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Tangor implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f383130a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f383131b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f383132c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Vermillion f383133d;

    public Tangor(Vermillion vermillion, Context context, boolean z16, int i3) {
        this.f383133d = vermillion;
        this.f383130a = context;
        this.f383131b = z16;
        this.f383132c = i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, vermillion, context, Boolean.valueOf(z16), Integer.valueOf(i3));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0073 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        boolean z16;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        Vermillion vermillion = this.f383133d;
        Context context = this.f383130a;
        boolean z17 = this.f383131b;
        int i16 = this.f383132c;
        vermillion.f383186d.getClass();
        String b16 = Walnut.b(context, "403");
        if (!TextUtils.isEmpty(b16)) {
            z16 = Boolean.valueOf(b16).booleanValue();
            while (i3 < vermillion.f383183a.f383103y) {
            }
            if (z16) {
            }
            synchronized (vermillion.f383189g) {
            }
        } else {
            z16 = true;
            for (i3 = 0; i3 < vermillion.f383183a.f383103y; i3++) {
                Sultana a16 = vermillion.a(context, z17, z16, i16);
                vermillion.a(a16, true);
                int i17 = a16.f383115c;
                if (i17 == 0 || i17 == -30014) {
                    break;
                }
            }
            if (z16) {
                Walnut walnut = vermillion.f383186d;
                walnut.getClass();
                walnut.a(context, "403", "false", true);
            }
            synchronized (vermillion.f383189g) {
                vermillion.f383189g.set(Boolean.FALSE);
                vermillion.f383189g.notifyAll();
            }
        }
    }
}
