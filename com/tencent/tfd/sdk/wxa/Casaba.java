package com.tencent.tfd.sdk.wxa;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class Casaba implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f375512a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f375513b = true;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f375514c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Cherry f375515d;

    public Casaba(Cherry cherry, Context context, int i3) {
        this.f375515d = cherry;
        this.f375512a = context;
        this.f375514c = i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, cherry, context, Integer.valueOf(i3));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0073 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        boolean z16;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        Cherry cherry = this.f375515d;
        Context context = this.f375512a;
        boolean z17 = this.f375513b;
        int i16 = this.f375514c;
        cherry.f375533d.getClass();
        String b16 = Chestnut.b(context, "403");
        if (!TextUtils.isEmpty(b16)) {
            z16 = Boolean.valueOf(b16).booleanValue();
            while (i3 < cherry.f375530a.f375483z) {
            }
            if (z16) {
            }
            synchronized (cherry.f375536g) {
            }
        } else {
            z16 = true;
            for (i3 = 0; i3 < cherry.f375530a.f375483z; i3++) {
                Cantaloupe a16 = cherry.a(context, z17, z16, i16);
                cherry.a(a16, true);
                int i17 = a16.f375497c;
                if (i17 == 0 || i17 == -30014) {
                    break;
                }
            }
            if (z16) {
                Chestnut chestnut = cherry.f375533d;
                chestnut.getClass();
                chestnut.a(context, "403", "false", true);
            }
            synchronized (cherry.f375536g) {
                cherry.f375536g.set(Boolean.FALSE);
                cherry.f375536g.notifyAll();
            }
        }
    }
}
