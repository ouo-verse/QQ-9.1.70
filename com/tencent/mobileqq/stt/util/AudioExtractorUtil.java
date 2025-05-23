package com.tencent.mobileqq.stt.util;

import android.content.Context;
import android.media.MediaFormat;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.stt.util.e;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes18.dex */
public class AudioExtractorUtil {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface a {
        void a(int i3, MediaFormat mediaFormat, long j3);
    }

    public static void a(Context context, String str, String str2, a aVar) {
        ThreadManagerV2.excute(new Runnable(str2, str, aVar) { // from class: com.tencent.mobileqq.stt.util.AudioExtractorUtil.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f290848d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f290849e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ a f290850f;

            {
                this.f290848d = str2;
                this.f290849e = str;
                this.f290850f = aVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, str2, str, aVar);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                c cVar = new c();
                try {
                    int i3 = cVar.i(this.f290849e, new b(new BufferedOutputStream(new FileOutputStream(this.f290848d))));
                    if (i3 != 0) {
                        AudioExtractorUtil.c("extractAndCompressSoundTrackFromVideo, FAIL, " + i3);
                    }
                    this.f290850f.a(i3, cVar.e(), cVar.f());
                } catch (Exception e16) {
                    AudioExtractorUtil.c("extractAndCompressSoundTrackFromVideo, EXCEPTION=" + e16);
                    this.f290850f.a(1, cVar.e(), 0L);
                }
            }
        }, 64, null, true);
    }

    public static void b(Context context, String str, String str2, a aVar) {
        ThreadManagerV2.excute(new Runnable(str2, context, str, aVar) { // from class: com.tencent.mobileqq.stt.util.AudioExtractorUtil.2
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f290851d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ Context f290852e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ String f290853f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ a f290854h;

            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.stt.util.AudioExtractorUtil$2$a */
            /* loaded from: classes18.dex */
            class a implements e.a {
                static IPatchRedirector $redirector_;

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ e f290855a;

                a(e eVar) {
                    this.f290855a = eVar;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this, (Object) eVar);
                    }
                }

                @Override // com.tencent.mobileqq.stt.util.e.a
                public void onComplete(int i3, int i16) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
                    } else {
                        AnonymousClass2.this.f290854h.a(i3, this.f290855a.e(), i16);
                    }
                }
            }

            {
                this.f290851d = str2;
                this.f290852e = context;
                this.f290853f = str;
                this.f290854h = aVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, str2, context, str, aVar);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                try {
                    e eVar = new e(this.f290852e, this.f290853f, new FileOutputStream(this.f290851d));
                    eVar.f(new a(eVar));
                } catch (IOException e16) {
                    AudioExtractorUtil.c("extractAndCompressSoundTrackFromVideo, EXCEPTION=" + e16);
                    this.f290854h.a(1, null, 0L);
                }
            }
        }, 64, null, true);
    }

    static void c(String str) {
        QLog.i("AudioExtractor", 1, str);
    }
}
