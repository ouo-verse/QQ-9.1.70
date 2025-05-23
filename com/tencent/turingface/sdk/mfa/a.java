package com.tencent.turingface.sdk.mfa;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.turingcam.A0y4R;
import com.tencent.turingcam.Bp8QH;
import com.tencent.turingcam.Ckq8l;
import com.tencent.turingcam.IEttU;
import com.tencent.turingcam.IyjbE;
import com.tencent.turingcam.KKOXW;
import com.tencent.turingcam.LJPko;
import com.tencent.turingcam.NbXuL;
import com.tencent.turingcam.QGmZm;
import com.tencent.turingcam.RbRz0;
import com.tencent.turingcam.UMDtK;
import com.tencent.turingcam.VBlVU;
import com.tencent.turingcam.WT9z5;
import com.tencent.turingcam.Xjpd8;
import com.tencent.turingcam.YQO0e;
import com.tencent.turingcam.ZIDl7;
import com.tencent.turingcam.c9YSQ;
import com.tencent.turingcam.ck9wY;
import com.tencent.turingcam.eh5ma;
import com.tencent.turingcam.f4Dke;
import com.tencent.turingcam.fDI6Z;
import com.tencent.turingcam.hxUS9;
import com.tencent.turingcam.jb1kT;
import com.tencent.turingcam.kGAMq;
import com.tencent.turingcam.qbihQ;
import com.tencent.turingcam.sh4jo;
import com.tencent.turingcam.tZ3Yi;
import com.tencent.turingcam.tmnyR;
import com.tencent.turingcam.y3oBE;
import com.tencent.turingface.sdk.mfa.c;
import com.tencent.turingface.sdk.mfa.j;
import com.tencent.turingface.sdk.mfa.m;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: P */
/* loaded from: classes27.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    public static final IyjbE<a> f382478c;

    /* renamed from: a, reason: collision with root package name */
    public HandlerC10029a f382479a;

    /* renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f382480b;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class b extends IyjbE<a> {
        static IPatchRedirector $redirector_;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.tencent.turingface.sdk.mfa.a, java.lang.Object] */
        @Override // com.tencent.turingcam.IyjbE
        public a a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return new a();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18653);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f382478c = new b();
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f382479a = null;
            this.f382480b = new AtomicBoolean(false);
        }
    }

    public static a a() {
        return f382478c.b();
    }

    public synchronized j a(int i3, int i16, int i17, byte[] bArr, long j3, NbXuL nbXuL) {
        j jVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (j) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), bArr, Long.valueOf(j3), nbXuL);
        }
        synchronized (this) {
            if (this.f382480b.get()) {
                Object obj = new Object();
                AtomicReference atomicReference = new AtomicReference();
                AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                j.a aVar = new j.a();
                aVar.f382531a = -4;
                atomicReference.set(new j(aVar));
                k kVar = new k(atomicBoolean, atomicReference, obj);
                HandlerC10029a handlerC10029a = this.f382479a;
                c.b bVar = new c.b(i3, i16, i17);
                bVar.f382506d = null;
                bVar.f382507e = bArr;
                bVar.f382508f = null;
                bVar.f382503a = kVar;
                bVar.f382509g = nbXuL;
                Message.obtain(handlerC10029a, 2, new c(bVar)).sendToTarget();
                synchronized (obj) {
                    try {
                        obj.wait(j3);
                    } catch (InterruptedException unused) {
                    }
                }
                atomicBoolean.set(true);
                jVar = (j) atomicReference.get();
            } else {
                throw new RuntimeException("Must call after initialized");
            }
        }
        return jVar;
    }

    /* compiled from: P */
    /* renamed from: com.tencent.turingface.sdk.mfa.a$a, reason: collision with other inner class name */
    /* loaded from: classes27.dex */
    public static class HandlerC10029a extends Handler {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final RbRz0 f382481a;

        /* renamed from: b, reason: collision with root package name */
        public int f382482b;

        /* renamed from: c, reason: collision with root package name */
        public int f382483c;

        /* renamed from: d, reason: collision with root package name */
        public final qbihQ f382484d;

        /* renamed from: e, reason: collision with root package name */
        public final m f382485e;

        /* renamed from: f, reason: collision with root package name */
        public final int f382486f;

        /* renamed from: g, reason: collision with root package name */
        public final NbXuL f382487g;

        /* compiled from: P */
        /* renamed from: com.tencent.turingface.sdk.mfa.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes27.dex */
        public class C10030a implements NbXuL {
            static IPatchRedirector $redirector_;

            public C10030a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // com.tencent.turingcam.NbXuL
            public boolean a(j jVar) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) jVar)).booleanValue();
                }
                return !jVar.a();
            }
        }

        public HandlerC10029a(Looper looper, m mVar, RbRz0 rbRz0, int i3) {
            super(looper);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, looper, mVar, rbRz0, Integer.valueOf(i3));
                return;
            }
            this.f382482b = 1;
            this.f382483c = 1;
            this.f382487g = new C10030a();
            this.f382485e = mVar;
            qbihQ qbihq = new qbihQ();
            this.f382484d = qbihq;
            qbihq.f382348f = 91;
            this.f382481a = rbRz0;
            this.f382486f = i3;
        }

        /* JADX WARN: Code restructure failed: missing block: B:113:0x0210, code lost:
        
            if (r3.length != 0) goto L135;
         */
        /* JADX WARN: Code restructure failed: missing block: B:74:0x01ce, code lost:
        
            if (r10 == null) goto L151;
         */
        /* JADX WARN: Removed duplicated region for block: B:124:0x0236  */
        /* JADX WARN: Removed duplicated region for block: B:133:0x00cc  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00c4  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x015c A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:40:0x015d  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final j a(Context context, c cVar) {
            tZ3Yi tz3yi;
            int i3;
            byte[] bArr;
            j a16;
            jb1kT jb1kt;
            LJPko lJPko;
            ArrayList<IEttU> arrayList;
            Iterator<IEttU> it;
            IEttU iEttU;
            byte[] a17;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (j) iPatchRedirector.redirect((short) 4, (Object) this, (Object) context, (Object) cVar);
            }
            int i16 = cVar.f382496a;
            byte[] bArr2 = cVar.f382500e;
            if (bArr2 == null) {
                UMDtK uMDtK = cVar.f382499d;
                Xjpd8 xjpd8 = new Xjpd8(128);
                xjpd8.f382097b = "UTF-8";
                uMDtK.a(xjpd8);
                bArr2 = xjpd8.a();
            }
            int i17 = this.f382482b;
            this.f382482b = i17 + 1;
            if (i17 >= Integer.MAX_VALUE) {
                this.f382482b = 1;
            }
            kGAMq kgamq = new kGAMq();
            kgamq.f382293b = this.f382482b;
            kgamq.f382292a = i16;
            kgamq.f382294c = 0;
            kgamq.f382298g = 0;
            kgamq.f382295d = bArr2;
            RbRz0 rbRz0 = this.f382481a;
            synchronized (rbRz0) {
                if (rbRz0.f382021b == null) {
                    rbRz0.a();
                }
                tz3yi = rbRz0.f382021b;
            }
            String a18 = g.a(context);
            qbihQ qbihq = this.f382484d;
            qbihq.f382347e = tz3yi.f382389d;
            qbihq.f382345c = a18;
            int i18 = this.f382483c;
            this.f382483c = i18 + 1;
            if (i18 >= Integer.MAX_VALUE) {
                this.f382483c = 1;
            }
            f4Dke f4dke = new f4Dke();
            ArrayList<kGAMq> arrayList2 = new ArrayList<>();
            f4dke.f382213d = arrayList2;
            arrayList2.add(kgamq);
            f4dke.f382210a = this.f382483c;
            f4dke.f382212c = this.f382484d;
            Xjpd8 xjpd82 = new Xjpd8(128);
            xjpd82.f382097b = "UTF-8";
            f4dke.a(xjpd82);
            byte[] a19 = xjpd82.a();
            String str = f4dke.f382212c.f382345c;
            int i19 = tz3yi.f382386a;
            int i26 = f4dke.f382210a;
            int i27 = f4dke.f382211b;
            try {
            } catch (Exception unused) {
                i3 = 0;
                a19 = null;
            }
            if (a19.length > 50 && (a17 = Bp8QH.a(a19)) != null) {
                if (a17.length < a19.length) {
                    a19 = a17;
                    i3 = 0;
                    if (a19 != null) {
                        a16 = j.a(-13);
                    } else {
                        byte[] bArr3 = tz3yi.f382387b;
                        String str2 = tz3yi.f382389d;
                        RbRz0 rbRz02 = this.f382481a;
                        rbRz02.getClass();
                        try {
                            fDI6Z fdi6z = rbRz02.f382020a;
                            byte[] a26 = Ckq8l.a(tz3yi.f382388c);
                            fdi6z.getClass();
                            bArr = VBlVU.b(a19, a26);
                        } catch (UnsupportedEncodingException unused2) {
                            bArr = null;
                        }
                        Xjpd8 xjpd83 = new Xjpd8(128);
                        xjpd83.f382097b = "UTF-8";
                        xjpd83.a(2);
                        xjpd83.b((byte) 10, 0);
                        if (str2 != null) {
                            xjpd83.a(str2, 1);
                        }
                        if (i3 != 0) {
                            xjpd83.a(i3, 2);
                        }
                        if (str != null) {
                            xjpd83.a(str, 3);
                        }
                        xjpd83.a(i19, 4);
                        if (i26 != 0) {
                            xjpd83.a(i26, 5);
                        }
                        if (i27 != 0) {
                            xjpd83.a(i27, 6);
                        }
                        xjpd83.a(2);
                        xjpd83.b((byte) 11, 0);
                        if (bArr3 != null) {
                            xjpd83.a(bArr3, 1);
                        }
                        if (bArr != null) {
                            xjpd83.a(bArr, 2);
                        }
                        byte[] a27 = xjpd83.a();
                        m mVar = this.f382485e;
                        if (mVar == null) {
                            a16 = j.a(-5);
                        } else {
                            try {
                                m.a a28 = ((h) mVar).a(a27);
                                j.a aVar = new j.a();
                                aVar.f382531a = a28.f382540a;
                                aVar.f382534d = a28.f382541b;
                                a16 = new j(aVar);
                            } catch (Throwable unused3) {
                                a16 = j.a(-6);
                            }
                        }
                    }
                    if (a16.f382527a == 0) {
                        return a16;
                    }
                    c9YSQ c9ysq = (c9YSQ) YQO0e.a(a16.f382530d, new c9YSQ(), false);
                    if (c9ysq != null && (jb1kt = c9ysq.f382168a) != null) {
                        int i28 = jb1kt.f382264b;
                        if (i28 == 2) {
                            RbRz0 rbRz03 = this.f382481a;
                            synchronized (rbRz03) {
                                rbRz03.a();
                            }
                            return j.a(-9);
                        }
                        if (i28 != 0) {
                            return j.a(-12);
                        }
                        int i29 = cVar.f382497b;
                        byte[] bArr4 = c9ysq.f382169b;
                        if (bArr4 != null && bArr4.length > 0) {
                            RbRz0 rbRz04 = this.f382481a;
                            rbRz04.getClass();
                            ZIDl7 zIDl7 = (ZIDl7) YQO0e.a(bArr4, new ZIDl7(), false);
                            if (zIDl7 == null || TextUtils.isEmpty(zIDl7.f382117a)) {
                                tz3yi = null;
                            } else {
                                tZ3Yi tz3yi2 = new tZ3Yi(tz3yi.f382386a, null, tz3yi.f382388c, zIDl7.f382117a, zIDl7.f382118b);
                                synchronized (rbRz04) {
                                    rbRz04.f382021b = tz3yi2;
                                }
                                tz3yi = tz3yi2;
                            }
                        }
                        byte[] bArr5 = c9ysq.f382170c;
                        if (bArr5 != null && bArr5.length != 0) {
                            int i36 = jb1kt.f382263a;
                            if (bArr5.length != 0) {
                                if ((i36 & 2) == 0) {
                                    RbRz0 rbRz05 = this.f382481a;
                                    rbRz05.getClass();
                                    try {
                                        fDI6Z fdi6z2 = rbRz05.f382020a;
                                        byte[] a29 = Ckq8l.a(tz3yi.f382388c);
                                        fdi6z2.getClass();
                                        bArr5 = VBlVU.a(bArr5, a29);
                                    } catch (UnsupportedEncodingException unused4) {
                                        bArr5 = null;
                                    }
                                }
                                if (bArr5 != null) {
                                    if (bArr5.length != 0) {
                                        if ((i36 & 1) == 0) {
                                            bArr5 = Bp8QH.b(bArr5);
                                            if (bArr5 != null) {
                                            }
                                        }
                                        if (bArr5 != null && bArr5.length != 0 && (lJPko = (LJPko) YQO0e.a(bArr5, new LJPko(), false)) != null && (arrayList = lJPko.f381880c) != null) {
                                            it = arrayList.iterator();
                                            while (it.hasNext()) {
                                                IEttU next = it.next();
                                                if (next.f381838a == i29) {
                                                    iEttU = next;
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            bArr5 = null;
                            if (bArr5 != null) {
                                it = arrayList.iterator();
                                while (it.hasNext()) {
                                }
                            }
                        }
                        iEttU = null;
                        if (iEttU == null) {
                            return j.a(-7);
                        }
                        int i37 = iEttU.f381841d;
                        if (i37 == 0 && iEttU.f381842e == 0) {
                            j.a aVar2 = new j.a();
                            aVar2.f382531a = 0;
                            aVar2.f382534d = iEttU.f381843f;
                            return new j(aVar2);
                        }
                        j.a aVar3 = new j.a();
                        aVar3.f382531a = -14;
                        aVar3.f382532b = i37;
                        aVar3.f382533c = iEttU.f381842e;
                        return new j(aVar3);
                    }
                    return j.a(-7);
                }
            }
            i3 = 1;
            if (a19 != null) {
            }
            if (a16.f382527a == 0) {
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Context context;
            Context context2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            int i3 = message.what;
            if (i3 != 1) {
                if (i3 == 2) {
                    c cVar = (c) message.obj;
                    c.a aVar = cVar.f382498c;
                    synchronized (eh5ma.class) {
                        context2 = eh5ma.f382207a;
                    }
                    if (TextUtils.isEmpty(g.a(context2))) {
                        j a16 = a(context2);
                        if (a16.f382527a != 0) {
                            ((k) aVar).a(a16);
                            return;
                        }
                    }
                    j a17 = a(context2, cVar);
                    NbXuL nbXuL = cVar.f382502g;
                    int i16 = 0;
                    if (nbXuL == null) {
                        nbXuL = this.f382487g;
                    }
                    while (i16 < this.f382486f && nbXuL.a(a17)) {
                        i16++;
                        a17 = a(context2, cVar);
                    }
                    ((k) cVar.f382498c).a(a17);
                    return;
                }
                return;
            }
            System.currentTimeMillis();
            synchronized (eh5ma.class) {
                context = eh5ma.f382207a;
            }
            if (TextUtils.isEmpty(g.a(context))) {
                a(context);
            }
        }

        /* JADX WARN: Can't wrap try/catch for region: R(61:8|(2:9|10)|(2:11|12)|(1:14)|15|(2:16|17)|18|(8:20|21|22|24|25|27|28|(4:30|31|32|33)(7:37|(1:39)(1:48)|40|41|42|43|44))|66|(1:68)|69|(3:237|238|(52:240|241|72|73|74|(1:76)|77|78|79|80|(1:82)|83|84|85|86|(1:88)|89|(1:91)|92|(1:94)|95|(1:97)|98|(1:100)|101|(1:103)|104|105|106|107|108|109|(1:111)|112|113|114|115|(3:116|117|(1:119)(1:120))|121|122|123|124|(1:126)|127|128|129|(1:131)(3:152|(1:154)(2:156|(1:158)(2:159|(5:161|162|163|(1:165)|166)(2:167|(6:169|170|171|172|173|(1:178)(1:177))(2:179|(1:181)(2:182|(7:184|185|186|(1:196)(1:192)|193|(1:195)|166)(2:197|(1:199)))))))|155)|(1:133)|134|3ee|139|(1:141)(2:142|(2:144|145)(2:146|147)))(1:242))|71|72|73|74|(0)|77|78|79|80|(0)|83|84|85|86|(0)|89|(0)|92|(0)|95|(0)|98|(0)|101|(0)|104|105|106|107|108|109|(0)|112|113|114|115|(4:116|117|(0)(0)|119)|121|122|123|124|(0)|127|128|129|(0)(0)|(0)|134|3ee) */
        /* JADX WARN: Can't wrap try/catch for region: R(63:8|9|10|(2:11|12)|(1:14)|15|16|17|18|(8:20|21|22|24|25|27|28|(4:30|31|32|33)(7:37|(1:39)(1:48)|40|41|42|43|44))|66|(1:68)|69|(3:237|238|(52:240|241|72|73|74|(1:76)|77|78|79|80|(1:82)|83|84|85|86|(1:88)|89|(1:91)|92|(1:94)|95|(1:97)|98|(1:100)|101|(1:103)|104|105|106|107|108|109|(1:111)|112|113|114|115|(3:116|117|(1:119)(1:120))|121|122|123|124|(1:126)|127|128|129|(1:131)(3:152|(1:154)(2:156|(1:158)(2:159|(5:161|162|163|(1:165)|166)(2:167|(6:169|170|171|172|173|(1:178)(1:177))(2:179|(1:181)(2:182|(7:184|185|186|(1:196)(1:192)|193|(1:195)|166)(2:197|(1:199)))))))|155)|(1:133)|134|3ee|139|(1:141)(2:142|(2:144|145)(2:146|147)))(1:242))|71|72|73|74|(0)|77|78|79|80|(0)|83|84|85|86|(0)|89|(0)|92|(0)|95|(0)|98|(0)|101|(0)|104|105|106|107|108|109|(0)|112|113|114|115|(4:116|117|(0)(0)|119)|121|122|123|124|(0)|127|128|129|(0)(0)|(0)|134|3ee) */
        /* JADX WARN: Can't wrap try/catch for region: R(64:8|9|10|11|12|(1:14)|15|16|17|18|(8:20|21|22|24|25|27|28|(4:30|31|32|33)(7:37|(1:39)(1:48)|40|41|42|43|44))|66|(1:68)|69|(3:237|238|(52:240|241|72|73|74|(1:76)|77|78|79|80|(1:82)|83|84|85|86|(1:88)|89|(1:91)|92|(1:94)|95|(1:97)|98|(1:100)|101|(1:103)|104|105|106|107|108|109|(1:111)|112|113|114|115|(3:116|117|(1:119)(1:120))|121|122|123|124|(1:126)|127|128|129|(1:131)(3:152|(1:154)(2:156|(1:158)(2:159|(5:161|162|163|(1:165)|166)(2:167|(6:169|170|171|172|173|(1:178)(1:177))(2:179|(1:181)(2:182|(7:184|185|186|(1:196)(1:192)|193|(1:195)|166)(2:197|(1:199)))))))|155)|(1:133)|134|3ee|139|(1:141)(2:142|(2:144|145)(2:146|147)))(1:242))|71|72|73|74|(0)|77|78|79|80|(0)|83|84|85|86|(0)|89|(0)|92|(0)|95|(0)|98|(0)|101|(0)|104|105|106|107|108|109|(0)|112|113|114|115|(4:116|117|(0)(0)|119)|121|122|123|124|(0)|127|128|129|(0)(0)|(0)|134|3ee) */
        /* JADX WARN: Code restructure failed: missing block: B:200:0x03cc, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:201:0x03cd, code lost:
        
            com.tencent.turingcam.A0y4R.a((java.lang.Object) r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:203:0x02ce, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:204:0x02cf, code lost:
        
            com.tencent.turingcam.A0y4R.a(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:228:0x02ed, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:229:0x02ee, code lost:
        
            com.tencent.turingcam.A0y4R.a(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:231:0x025d, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:232:0x025e, code lost:
        
            com.tencent.turingcam.A0y4R.a(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x0124, code lost:
        
            if (r0 != null) goto L53;
         */
        /* JADX WARN: Removed duplicated region for block: B:100:0x0212  */
        /* JADX WARN: Removed duplicated region for block: B:103:0x021b  */
        /* JADX WARN: Removed duplicated region for block: B:111:0x0263  */
        /* JADX WARN: Removed duplicated region for block: B:119:0x02b5 A[Catch: all -> 0x02bf, LOOP:0: B:116:0x02af->B:119:0x02b5, LOOP_END, TRY_LEAVE, TryCatch #24 {all -> 0x02bf, blocks: (B:117:0x02af, B:119:0x02b5), top: B:116:0x02af, outer: #20 }] */
        /* JADX WARN: Removed duplicated region for block: B:120:0x02b9 A[EDGE_INSN: B:120:0x02b9->B:121:0x02b9 BREAK  A[LOOP:0: B:116:0x02af->B:119:0x02b5], SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:126:0x02f3  */
        /* JADX WARN: Removed duplicated region for block: B:131:0x0304  */
        /* JADX WARN: Removed duplicated region for block: B:133:0x03d2  */
        /* JADX WARN: Removed duplicated region for block: B:136:0x03ef A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:152:0x0306 A[Catch: Exception -> 0x03cc, TryCatch #1 {Exception -> 0x03cc, blocks: (B:129:0x02fc, B:152:0x0306, B:154:0x0315, B:156:0x031a, B:158:0x0323, B:159:0x0328, B:161:0x0331, B:163:0x0337, B:165:0x033d, B:167:0x0345, B:169:0x034e, B:171:0x0354, B:173:0x035a, B:175:0x0360, B:177:0x0366, B:178:0x037c, B:179:0x0380, B:181:0x0389, B:182:0x038d, B:184:0x0396, B:186:0x039c, B:188:0x03a2, B:190:0x03ab, B:192:0x03ae, B:193:0x03b2, B:195:0x03b8, B:197:0x03bc, B:199:0x03c5), top: B:128:0x02fc }] */
        /* JADX WARN: Removed duplicated region for block: B:237:0x014d A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:68:0x0144  */
        /* JADX WARN: Removed duplicated region for block: B:76:0x0194 A[Catch: all -> 0x01d8, TryCatch #16 {all -> 0x01d8, blocks: (B:74:0x018a, B:76:0x0194, B:77:0x019c), top: B:73:0x018a }] */
        /* JADX WARN: Removed duplicated region for block: B:82:0x01ba A[Catch: all -> 0x01d7, TryCatch #13 {all -> 0x01d7, blocks: (B:80:0x01b0, B:82:0x01ba, B:83:0x01c2), top: B:79:0x01b0 }] */
        /* JADX WARN: Removed duplicated region for block: B:88:0x01de  */
        /* JADX WARN: Removed duplicated region for block: B:91:0x01e7  */
        /* JADX WARN: Removed duplicated region for block: B:94:0x01f0  */
        /* JADX WARN: Removed duplicated region for block: B:97:0x0205  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final j a(Context context) {
            int i3;
            String sb5;
            int i16;
            File[] listFiles;
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            String str6;
            String str7;
            String str8;
            Context context2;
            String str9;
            String str10;
            String[] split;
            BufferedReader bufferedReader;
            StringBuilder sb6;
            String readLine;
            File rootDirectory;
            File dataDirectory;
            BufferedReader bufferedReader2;
            InputStreamReader inputStreamReader;
            long j3;
            String readLine2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (j) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
            }
            System.currentTimeMillis();
            String str11 = g.f382510a;
            AtomicReference<String> atomicReference = sh4jo.f382370a;
            int i17 = -1;
            try {
                WindowManager windowManager = (WindowManager) context.getSystemService("window");
                DisplayMetrics displayMetrics = new DisplayMetrics();
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                i3 = displayMetrics.widthPixels;
            } catch (Throwable unused) {
                i3 = -1;
            }
            try {
                WindowManager windowManager2 = (WindowManager) context.getSystemService("window");
                DisplayMetrics displayMetrics2 = new DisplayMetrics();
                windowManager2.getDefaultDisplay().getMetrics(displayMetrics2);
                i17 = displayMetrics2.heightPixels;
            } catch (Throwable unused2) {
            }
            if (i3 >= i17) {
                int i18 = i3;
                i3 = i17;
                i17 = i18;
            }
            y3oBE y3obe = new y3oBE();
            y3obe.L = "";
            y3obe.f382432d = "0";
            y3obe.f382434e = "0";
            y3obe.f382436f = 92;
            y3obe.f382438g = "FC6D5B0A7013DB60";
            y3obe.f382440h = 91;
            StringBuilder a16 = tmnyR.a("");
            a16.append(WT9z5.f382088a);
            y3obe.f382441i = a16.toString();
            y3obe.f382442j = 2;
            y3obe.f382443k = 201;
            y3obe.f382444l = false;
            try {
                y3obe.f382445m = context.getPackageName();
            } catch (Throwable unused3) {
            }
            y3obe.f382447o = Build.VERSION.SDK_INT;
            y3obe.f382449q = (short) 2052;
            y3obe.f382450r = 1;
            ck9wY.a();
            Random random = Ckq8l.f381753a;
            y3obe.V = "";
            StringBuilder a17 = tmnyR.a("");
            long j16 = ck9wY.f382178a;
            String str12 = null;
            long j17 = 0;
            if (-1 == j16) {
                try {
                    try {
                        inputStreamReader = new InputStreamReader(new FileInputStream("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq"), "UTF-8");
                        try {
                            bufferedReader2 = new BufferedReader(inputStreamReader);
                            try {
                                readLine2 = bufferedReader2.readLine();
                            } catch (IOException unused4) {
                                if (inputStreamReader != null) {
                                    inputStreamReader.close();
                                }
                            } catch (Throwable unused5) {
                                if (inputStreamReader != null) {
                                    inputStreamReader.close();
                                }
                                if (bufferedReader2 != null) {
                                    j3 = 0;
                                    bufferedReader2.close();
                                    j16 = j3;
                                    ck9wY.f382178a = j16;
                                    a17.append(j16);
                                    sb5 = a17.toString();
                                    if (sb5 == null) {
                                    }
                                    y3obe.f382452t = sb5;
                                    if (ck9wY.f382179b == null) {
                                    }
                                    i16 = ck9wY.f382179b.intValue();
                                    y3obe.f382453u = i16;
                                    y3obe.f382454v = i17 + "*" + i3;
                                    rootDirectory = Environment.getRootDirectory();
                                    if (!rootDirectory.exists()) {
                                    }
                                    StatFs statFs = new StatFs(rootDirectory.getPath());
                                    long blockSize = statFs.getBlockSize() * statFs.getBlockCount();
                                    dataDirectory = Environment.getDataDirectory();
                                    if (!dataDirectory.exists()) {
                                    }
                                    StatFs statFs2 = new StatFs(dataDirectory.getPath());
                                    j17 = statFs2.getBlockSize() * statFs2.getBlockCount();
                                    j17 += blockSize;
                                    y3obe.f382456x = j17;
                                    str = Build.BRAND;
                                    if (str == null) {
                                    }
                                    y3obe.f382458z = str;
                                    str2 = Build.VERSION.INCREMENTAL;
                                    if (str2 == null) {
                                    }
                                    y3obe.A = str2;
                                    str3 = Build.VERSION.RELEASE;
                                    if (str3 == null) {
                                    }
                                    y3obe.B = str3;
                                    y3obe.P = "1.0.0";
                                    y3obe.Q = 1;
                                    y3obe.R = "";
                                    str4 = Build.MANUFACTURER;
                                    if (str4 == null) {
                                    }
                                    y3obe.E = str4;
                                    y3obe.H = 0;
                                    y3obe.I = 0;
                                    str5 = Build.DEVICE;
                                    if (str5 == null) {
                                    }
                                    y3obe.S = str5;
                                    str6 = Build.BOARD;
                                    if (str6 == null) {
                                    }
                                    y3obe.T = str6;
                                    ck9wY.a();
                                    y3obe.U = "";
                                    ck9wY.a();
                                    y3obe.W = "";
                                    ck9wY.a();
                                    y3obe.X = "";
                                    ck9wY.a();
                                    y3obe.Y = "";
                                    str7 = "";
                                    str7 = (String) Class.forName("android.os.Build").getMethod("getRadioVersion", new Class[0]).invoke(null, new Object[0]);
                                    if (str7 == null) {
                                    }
                                    y3obe.Z = str7;
                                    ck9wY.a();
                                    y3obe.F = "";
                                    ck9wY.a();
                                    y3obe.f382429b0 = "";
                                    ck9wY.a();
                                    y3obe.G = "";
                                    ck9wY.a();
                                    y3obe.C = "";
                                    ck9wY.a();
                                    y3obe.D = "";
                                    str8 = "";
                                    FileInputStream fileInputStream = new FileInputStream("/proc/version");
                                    bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream), 8192);
                                    sb6 = new StringBuilder("");
                                    while (true) {
                                        try {
                                            try {
                                                readLine = bufferedReader.readLine();
                                                if (readLine != null) {
                                                }
                                                sb6.append(readLine);
                                            } catch (Throwable th5) {
                                                try {
                                                    A0y4R.a(th5);
                                                    bufferedReader.close();
                                                } finally {
                                                }
                                            }
                                        } catch (Throwable th6) {
                                            A0y4R.a(th6);
                                        }
                                    }
                                    bufferedReader.close();
                                    fileInputStream.close();
                                    str8 = sb6.toString();
                                    if (str8 == null) {
                                    }
                                    y3obe.f382431c0 = str8;
                                    y3obe.J = false;
                                    y3obe.f382433d0 = 0;
                                    str9 = Build.MANUFACTURER;
                                    if (TextUtils.isEmpty(str9)) {
                                    }
                                    if (str12 == null) {
                                    }
                                    y3obe.f382435e0 = str12;
                                    c.b bVar = new c.b(1, 10001, 0);
                                    bVar.f382506d = y3obe;
                                    bVar.f382508f = new KKOXW();
                                    c cVar = new c(bVar);
                                    synchronized (eh5ma.class) {
                                    }
                                }
                                j16 = 0;
                                ck9wY.f382178a = j16;
                                a17.append(j16);
                                sb5 = a17.toString();
                                if (sb5 == null) {
                                }
                                y3obe.f382452t = sb5;
                                if (ck9wY.f382179b == null) {
                                }
                                i16 = ck9wY.f382179b.intValue();
                                y3obe.f382453u = i16;
                                y3obe.f382454v = i17 + "*" + i3;
                                rootDirectory = Environment.getRootDirectory();
                                if (!rootDirectory.exists()) {
                                }
                                StatFs statFs3 = new StatFs(rootDirectory.getPath());
                                long blockSize2 = statFs3.getBlockSize() * statFs3.getBlockCount();
                                dataDirectory = Environment.getDataDirectory();
                                if (!dataDirectory.exists()) {
                                }
                                StatFs statFs22 = new StatFs(dataDirectory.getPath());
                                j17 = statFs22.getBlockSize() * statFs22.getBlockCount();
                                j17 += blockSize2;
                                y3obe.f382456x = j17;
                                str = Build.BRAND;
                                if (str == null) {
                                }
                                y3obe.f382458z = str;
                                str2 = Build.VERSION.INCREMENTAL;
                                if (str2 == null) {
                                }
                                y3obe.A = str2;
                                str3 = Build.VERSION.RELEASE;
                                if (str3 == null) {
                                }
                                y3obe.B = str3;
                                y3obe.P = "1.0.0";
                                y3obe.Q = 1;
                                y3obe.R = "";
                                str4 = Build.MANUFACTURER;
                                if (str4 == null) {
                                }
                                y3obe.E = str4;
                                y3obe.H = 0;
                                y3obe.I = 0;
                                str5 = Build.DEVICE;
                                if (str5 == null) {
                                }
                                y3obe.S = str5;
                                str6 = Build.BOARD;
                                if (str6 == null) {
                                }
                                y3obe.T = str6;
                                ck9wY.a();
                                y3obe.U = "";
                                ck9wY.a();
                                y3obe.W = "";
                                ck9wY.a();
                                y3obe.X = "";
                                ck9wY.a();
                                y3obe.Y = "";
                                str7 = "";
                                str7 = (String) Class.forName("android.os.Build").getMethod("getRadioVersion", new Class[0]).invoke(null, new Object[0]);
                                if (str7 == null) {
                                }
                                y3obe.Z = str7;
                                ck9wY.a();
                                y3obe.F = "";
                                ck9wY.a();
                                y3obe.f382429b0 = "";
                                ck9wY.a();
                                y3obe.G = "";
                                ck9wY.a();
                                y3obe.C = "";
                                ck9wY.a();
                                y3obe.D = "";
                                str8 = "";
                                FileInputStream fileInputStream2 = new FileInputStream("/proc/version");
                                bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream2), 8192);
                                sb6 = new StringBuilder("");
                                while (true) {
                                    readLine = bufferedReader.readLine();
                                    if (readLine != null) {
                                    }
                                    sb6.append(readLine);
                                }
                                bufferedReader.close();
                                fileInputStream2.close();
                                str8 = sb6.toString();
                                if (str8 == null) {
                                }
                                y3obe.f382431c0 = str8;
                                y3obe.J = false;
                                y3obe.f382433d0 = 0;
                                str9 = Build.MANUFACTURER;
                                if (TextUtils.isEmpty(str9)) {
                                }
                                if (str12 == null) {
                                }
                                y3obe.f382435e0 = str12;
                                c.b bVar2 = new c.b(1, 10001, 0);
                                bVar2.f382506d = y3obe;
                                bVar2.f382508f = new KKOXW();
                                c cVar2 = new c(bVar2);
                                synchronized (eh5ma.class) {
                                }
                            }
                        } catch (IOException unused6) {
                            bufferedReader2 = null;
                        } catch (Throwable unused7) {
                            bufferedReader2 = null;
                        }
                    } catch (IOException unused8) {
                        bufferedReader2 = null;
                        inputStreamReader = null;
                    } catch (Throwable unused9) {
                        bufferedReader2 = null;
                        inputStreamReader = null;
                    }
                } catch (IOException e16) {
                    e = e16;
                    j3 = 0;
                    A0y4R.a(e.getMessage());
                    A0y4R.a((Throwable) e);
                    j16 = j3;
                    ck9wY.f382178a = j16;
                    a17.append(j16);
                    sb5 = a17.toString();
                    if (sb5 == null) {
                    }
                    y3obe.f382452t = sb5;
                    if (ck9wY.f382179b == null) {
                    }
                    i16 = ck9wY.f382179b.intValue();
                    y3obe.f382453u = i16;
                    y3obe.f382454v = i17 + "*" + i3;
                    rootDirectory = Environment.getRootDirectory();
                    if (!rootDirectory.exists()) {
                    }
                    StatFs statFs32 = new StatFs(rootDirectory.getPath());
                    long blockSize22 = statFs32.getBlockSize() * statFs32.getBlockCount();
                    dataDirectory = Environment.getDataDirectory();
                    if (!dataDirectory.exists()) {
                    }
                    StatFs statFs222 = new StatFs(dataDirectory.getPath());
                    j17 = statFs222.getBlockSize() * statFs222.getBlockCount();
                    j17 += blockSize22;
                    y3obe.f382456x = j17;
                    str = Build.BRAND;
                    if (str == null) {
                    }
                    y3obe.f382458z = str;
                    str2 = Build.VERSION.INCREMENTAL;
                    if (str2 == null) {
                    }
                    y3obe.A = str2;
                    str3 = Build.VERSION.RELEASE;
                    if (str3 == null) {
                    }
                    y3obe.B = str3;
                    y3obe.P = "1.0.0";
                    y3obe.Q = 1;
                    y3obe.R = "";
                    str4 = Build.MANUFACTURER;
                    if (str4 == null) {
                    }
                    y3obe.E = str4;
                    y3obe.H = 0;
                    y3obe.I = 0;
                    str5 = Build.DEVICE;
                    if (str5 == null) {
                    }
                    y3obe.S = str5;
                    str6 = Build.BOARD;
                    if (str6 == null) {
                    }
                    y3obe.T = str6;
                    ck9wY.a();
                    y3obe.U = "";
                    ck9wY.a();
                    y3obe.W = "";
                    ck9wY.a();
                    y3obe.X = "";
                    ck9wY.a();
                    y3obe.Y = "";
                    str7 = "";
                    str7 = (String) Class.forName("android.os.Build").getMethod("getRadioVersion", new Class[0]).invoke(null, new Object[0]);
                    if (str7 == null) {
                    }
                    y3obe.Z = str7;
                    ck9wY.a();
                    y3obe.F = "";
                    ck9wY.a();
                    y3obe.f382429b0 = "";
                    ck9wY.a();
                    y3obe.G = "";
                    ck9wY.a();
                    y3obe.C = "";
                    ck9wY.a();
                    y3obe.D = "";
                    str8 = "";
                    FileInputStream fileInputStream22 = new FileInputStream("/proc/version");
                    bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream22), 8192);
                    sb6 = new StringBuilder("");
                    while (true) {
                        readLine = bufferedReader.readLine();
                        if (readLine != null) {
                        }
                        sb6.append(readLine);
                    }
                    bufferedReader.close();
                    fileInputStream22.close();
                    str8 = sb6.toString();
                    if (str8 == null) {
                    }
                    y3obe.f382431c0 = str8;
                    y3obe.J = false;
                    y3obe.f382433d0 = 0;
                    str9 = Build.MANUFACTURER;
                    if (TextUtils.isEmpty(str9)) {
                    }
                    if (str12 == null) {
                    }
                    y3obe.f382435e0 = str12;
                    c.b bVar22 = new c.b(1, 10001, 0);
                    bVar22.f382506d = y3obe;
                    bVar22.f382508f = new KKOXW();
                    c cVar22 = new c(bVar22);
                    synchronized (eh5ma.class) {
                    }
                }
                if (readLine2 == null) {
                    inputStreamReader.close();
                    bufferedReader2.close();
                    try {
                        inputStreamReader.close();
                        bufferedReader2.close();
                    } catch (IOException e17) {
                        A0y4R.a(e17.getMessage());
                        A0y4R.a((Throwable) e17);
                    }
                    j16 = 0;
                } else {
                    String trim = readLine2.trim();
                    j3 = trim.length() > 0 ? Long.parseLong(trim) : 0L;
                    try {
                        inputStreamReader.close();
                        bufferedReader2.close();
                    } catch (IOException e18) {
                        e = e18;
                        A0y4R.a(e.getMessage());
                        A0y4R.a((Throwable) e);
                        j16 = j3;
                        ck9wY.f382178a = j16;
                        a17.append(j16);
                        sb5 = a17.toString();
                        if (sb5 == null) {
                        }
                        y3obe.f382452t = sb5;
                        if (ck9wY.f382179b == null) {
                        }
                        i16 = ck9wY.f382179b.intValue();
                        y3obe.f382453u = i16;
                        y3obe.f382454v = i17 + "*" + i3;
                        rootDirectory = Environment.getRootDirectory();
                        if (!rootDirectory.exists()) {
                        }
                        StatFs statFs322 = new StatFs(rootDirectory.getPath());
                        long blockSize222 = statFs322.getBlockSize() * statFs322.getBlockCount();
                        dataDirectory = Environment.getDataDirectory();
                        if (!dataDirectory.exists()) {
                        }
                        StatFs statFs2222 = new StatFs(dataDirectory.getPath());
                        j17 = statFs2222.getBlockSize() * statFs2222.getBlockCount();
                        j17 += blockSize222;
                        y3obe.f382456x = j17;
                        str = Build.BRAND;
                        if (str == null) {
                        }
                        y3obe.f382458z = str;
                        str2 = Build.VERSION.INCREMENTAL;
                        if (str2 == null) {
                        }
                        y3obe.A = str2;
                        str3 = Build.VERSION.RELEASE;
                        if (str3 == null) {
                        }
                        y3obe.B = str3;
                        y3obe.P = "1.0.0";
                        y3obe.Q = 1;
                        y3obe.R = "";
                        str4 = Build.MANUFACTURER;
                        if (str4 == null) {
                        }
                        y3obe.E = str4;
                        y3obe.H = 0;
                        y3obe.I = 0;
                        str5 = Build.DEVICE;
                        if (str5 == null) {
                        }
                        y3obe.S = str5;
                        str6 = Build.BOARD;
                        if (str6 == null) {
                        }
                        y3obe.T = str6;
                        ck9wY.a();
                        y3obe.U = "";
                        ck9wY.a();
                        y3obe.W = "";
                        ck9wY.a();
                        y3obe.X = "";
                        ck9wY.a();
                        y3obe.Y = "";
                        str7 = "";
                        str7 = (String) Class.forName("android.os.Build").getMethod("getRadioVersion", new Class[0]).invoke(null, new Object[0]);
                        if (str7 == null) {
                        }
                        y3obe.Z = str7;
                        ck9wY.a();
                        y3obe.F = "";
                        ck9wY.a();
                        y3obe.f382429b0 = "";
                        ck9wY.a();
                        y3obe.G = "";
                        ck9wY.a();
                        y3obe.C = "";
                        ck9wY.a();
                        y3obe.D = "";
                        str8 = "";
                        FileInputStream fileInputStream222 = new FileInputStream("/proc/version");
                        bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream222), 8192);
                        sb6 = new StringBuilder("");
                        while (true) {
                            readLine = bufferedReader.readLine();
                            if (readLine != null) {
                            }
                            sb6.append(readLine);
                        }
                        bufferedReader.close();
                        fileInputStream222.close();
                        str8 = sb6.toString();
                        if (str8 == null) {
                        }
                        y3obe.f382431c0 = str8;
                        y3obe.J = false;
                        y3obe.f382433d0 = 0;
                        str9 = Build.MANUFACTURER;
                        if (TextUtils.isEmpty(str9)) {
                        }
                        if (str12 == null) {
                        }
                        y3obe.f382435e0 = str12;
                        c.b bVar222 = new c.b(1, 10001, 0);
                        bVar222.f382506d = y3obe;
                        bVar222.f382508f = new KKOXW();
                        c cVar222 = new c(bVar222);
                        synchronized (eh5ma.class) {
                        }
                    }
                    j16 = j3;
                    ck9wY.f382178a = j16;
                }
            }
            a17.append(j16);
            sb5 = a17.toString();
            if (sb5 == null) {
                sb5 = "";
            }
            y3obe.f382452t = sb5;
            if (ck9wY.f382179b == null) {
                try {
                    listFiles = new File("/sys/devices/system/cpu/").listFiles(new QGmZm());
                } catch (Throwable unused10) {
                }
                if (listFiles != null) {
                    ck9wY.f382179b = Integer.valueOf(listFiles.length);
                } else {
                    i16 = 1;
                    y3obe.f382453u = i16;
                    y3obe.f382454v = i17 + "*" + i3;
                    rootDirectory = Environment.getRootDirectory();
                    if (!rootDirectory.exists()) {
                        rootDirectory = new File("/system");
                    }
                    StatFs statFs3222 = new StatFs(rootDirectory.getPath());
                    long blockSize2222 = statFs3222.getBlockSize() * statFs3222.getBlockCount();
                    dataDirectory = Environment.getDataDirectory();
                    if (!dataDirectory.exists()) {
                        dataDirectory = new File("/data");
                    }
                    StatFs statFs22222 = new StatFs(dataDirectory.getPath());
                    j17 = statFs22222.getBlockSize() * statFs22222.getBlockCount();
                    j17 += blockSize2222;
                    y3obe.f382456x = j17;
                    str = Build.BRAND;
                    if (str == null) {
                        str = "";
                    }
                    y3obe.f382458z = str;
                    str2 = Build.VERSION.INCREMENTAL;
                    if (str2 == null) {
                        str2 = "";
                    }
                    y3obe.A = str2;
                    str3 = Build.VERSION.RELEASE;
                    if (str3 == null) {
                        str3 = "";
                    }
                    y3obe.B = str3;
                    y3obe.P = "1.0.0";
                    y3obe.Q = 1;
                    y3obe.R = "";
                    str4 = Build.MANUFACTURER;
                    if (str4 == null) {
                        str4 = "UNKNOWN";
                    }
                    y3obe.E = str4;
                    y3obe.H = 0;
                    y3obe.I = 0;
                    str5 = Build.DEVICE;
                    if (str5 == null) {
                        str5 = "";
                    }
                    y3obe.S = str5;
                    str6 = Build.BOARD;
                    if (str6 == null) {
                        str6 = "";
                    }
                    y3obe.T = str6;
                    ck9wY.a();
                    y3obe.U = "";
                    ck9wY.a();
                    y3obe.W = "";
                    ck9wY.a();
                    y3obe.X = "";
                    ck9wY.a();
                    y3obe.Y = "";
                    str7 = "";
                    str7 = (String) Class.forName("android.os.Build").getMethod("getRadioVersion", new Class[0]).invoke(null, new Object[0]);
                    if (str7 == null) {
                        str7 = "";
                    }
                    y3obe.Z = str7;
                    ck9wY.a();
                    y3obe.F = "";
                    ck9wY.a();
                    y3obe.f382429b0 = "";
                    ck9wY.a();
                    y3obe.G = "";
                    ck9wY.a();
                    y3obe.C = "";
                    ck9wY.a();
                    y3obe.D = "";
                    str8 = "";
                    FileInputStream fileInputStream2222 = new FileInputStream("/proc/version");
                    bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream2222), 8192);
                    sb6 = new StringBuilder("");
                    while (true) {
                        readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            break;
                        }
                        sb6.append(readLine);
                    }
                    bufferedReader.close();
                    fileInputStream2222.close();
                    str8 = sb6.toString();
                    if (str8 == null) {
                        str8 = "";
                    }
                    y3obe.f382431c0 = str8;
                    y3obe.J = false;
                    y3obe.f382433d0 = 0;
                    str9 = Build.MANUFACTURER;
                    if (TextUtils.isEmpty(str9)) {
                        String lowerCase = str9.toLowerCase(Locale.ENGLISH);
                        if (lowerCase.contains(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_HUAWEI)) {
                            hxUS9.a();
                        } else if (lowerCase.contains("xiaomi")) {
                            hxUS9.a();
                        } else if (lowerCase.contains("gionee")) {
                            hxUS9.a();
                            str10 = "";
                            if (TextUtils.isEmpty("")) {
                                hxUS9.a();
                            }
                            str12 = str10;
                        } else if (lowerCase.contains(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_VIVO)) {
                            hxUS9.a();
                            hxUS9.a();
                            if (!TextUtils.isEmpty("") && !TextUtils.isEmpty("")) {
                                str12 = "_";
                            } else {
                                hxUS9.a();
                            }
                        } else if (lowerCase.contains("meizu")) {
                            hxUS9.a();
                        } else if (lowerCase.contains(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_LENOVO)) {
                            hxUS9.a();
                            str10 = (TextUtils.isEmpty("") || (split = "".split("_")) == null || split.length <= 0) ? null : split[0];
                            if (TextUtils.isEmpty(str10)) {
                                hxUS9.a();
                            }
                            str12 = str10;
                        } else if (lowerCase.contains("letv")) {
                            hxUS9.a();
                        }
                        str12 = "";
                    }
                    if (str12 == null) {
                        str12 = "";
                    }
                    y3obe.f382435e0 = str12;
                    c.b bVar2222 = new c.b(1, 10001, 0);
                    bVar2222.f382506d = y3obe;
                    bVar2222.f382508f = new KKOXW();
                    c cVar2222 = new c(bVar2222);
                    synchronized (eh5ma.class) {
                        context2 = eh5ma.f382207a;
                    }
                    j a18 = a(context2, cVar2222);
                    if (!a18.a()) {
                        return a18;
                    }
                    UMDtK a19 = YQO0e.a(a18.f382530d, cVar2222.f382501f, false);
                    if (a19 instanceof KKOXW) {
                        g.a(context, ((KKOXW) a19).f381875a);
                        return a18;
                    }
                    return j.a(-11);
                }
            }
            i16 = ck9wY.f382179b.intValue();
            y3obe.f382453u = i16;
            y3obe.f382454v = i17 + "*" + i3;
            rootDirectory = Environment.getRootDirectory();
            if (!rootDirectory.exists()) {
            }
            StatFs statFs32222 = new StatFs(rootDirectory.getPath());
            long blockSize22222 = statFs32222.getBlockSize() * statFs32222.getBlockCount();
            dataDirectory = Environment.getDataDirectory();
            if (!dataDirectory.exists()) {
            }
            StatFs statFs222222 = new StatFs(dataDirectory.getPath());
            j17 = statFs222222.getBlockSize() * statFs222222.getBlockCount();
            j17 += blockSize22222;
            y3obe.f382456x = j17;
            str = Build.BRAND;
            if (str == null) {
            }
            y3obe.f382458z = str;
            str2 = Build.VERSION.INCREMENTAL;
            if (str2 == null) {
            }
            y3obe.A = str2;
            str3 = Build.VERSION.RELEASE;
            if (str3 == null) {
            }
            y3obe.B = str3;
            y3obe.P = "1.0.0";
            y3obe.Q = 1;
            y3obe.R = "";
            str4 = Build.MANUFACTURER;
            if (str4 == null) {
            }
            y3obe.E = str4;
            y3obe.H = 0;
            y3obe.I = 0;
            str5 = Build.DEVICE;
            if (str5 == null) {
            }
            y3obe.S = str5;
            str6 = Build.BOARD;
            if (str6 == null) {
            }
            y3obe.T = str6;
            ck9wY.a();
            y3obe.U = "";
            ck9wY.a();
            y3obe.W = "";
            ck9wY.a();
            y3obe.X = "";
            ck9wY.a();
            y3obe.Y = "";
            str7 = "";
            str7 = (String) Class.forName("android.os.Build").getMethod("getRadioVersion", new Class[0]).invoke(null, new Object[0]);
            if (str7 == null) {
            }
            y3obe.Z = str7;
            ck9wY.a();
            y3obe.F = "";
            ck9wY.a();
            y3obe.f382429b0 = "";
            ck9wY.a();
            y3obe.G = "";
            ck9wY.a();
            y3obe.C = "";
            ck9wY.a();
            y3obe.D = "";
            str8 = "";
            FileInputStream fileInputStream22222 = new FileInputStream("/proc/version");
            bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream22222), 8192);
            sb6 = new StringBuilder("");
            while (true) {
                readLine = bufferedReader.readLine();
                if (readLine != null) {
                }
                sb6.append(readLine);
            }
            bufferedReader.close();
            fileInputStream22222.close();
            str8 = sb6.toString();
            if (str8 == null) {
            }
            y3obe.f382431c0 = str8;
            y3obe.J = false;
            y3obe.f382433d0 = 0;
            str9 = Build.MANUFACTURER;
            if (TextUtils.isEmpty(str9)) {
            }
            if (str12 == null) {
            }
            y3obe.f382435e0 = str12;
            c.b bVar22222 = new c.b(1, 10001, 0);
            bVar22222.f382506d = y3obe;
            bVar22222.f382508f = new KKOXW();
            c cVar22222 = new c(bVar22222);
            synchronized (eh5ma.class) {
            }
        }
    }
}
