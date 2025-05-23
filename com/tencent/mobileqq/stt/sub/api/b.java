package com.tencent.mobileqq.stt.sub.api;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class b extends QIPCModule {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final b f290753a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25598);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f290753a = new b("VideoSubtitleQIPC");
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.stt.sub.api.b$b, reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    public static class C8626b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final b f290754a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.stt.sub.api.b$b$a */
        /* loaded from: classes18.dex */
        public class a implements com.tencent.mobileqq.stt.sub.api.a {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f290755a;

            a(int i3) {
                this.f290755a = i3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) C8626b.this, i3);
                }
            }

            @Override // com.tencent.mobileqq.stt.sub.api.a
            public void a(int i3, String str) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) str);
                } else {
                    C8626b.this.f290754a.callbackResult(this.f290755a, EIPCResult.createResult(0, d.b(i3, str)));
                }
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.stt.sub.api.b$b$b, reason: collision with other inner class name */
        /* loaded from: classes18.dex */
        class C8627b implements EIPCResultCallback {
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ com.tencent.mobileqq.stt.sub.api.a f290757d;

            C8627b(com.tencent.mobileqq.stt.sub.api.a aVar) {
                this.f290757d = aVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
                }
            }

            @Override // eipc.EIPCResultCallback
            public void onCallback(EIPCResult eIPCResult) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) eIPCResult);
                    return;
                }
                d dVar = new d();
                if (eIPCResult.code == 0) {
                    dVar = d.a(eIPCResult.data);
                }
                this.f290757d.a(dVar.f290764a, dVar.f290765b);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.stt.sub.api.b$b$c */
        /* loaded from: classes18.dex */
        public static class c {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            String f290758a;

            /* renamed from: b, reason: collision with root package name */
            int f290759b;

            /* renamed from: c, reason: collision with root package name */
            long f290760c;

            /* renamed from: d, reason: collision with root package name */
            String f290761d;

            /* renamed from: e, reason: collision with root package name */
            String f290762e;

            /* renamed from: f, reason: collision with root package name */
            int f290763f;

            c() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            static c a(Bundle bundle) {
                c cVar = new c();
                if (bundle != null) {
                    cVar.f290758a = bundle.getString("KEY_MSG_UIN");
                    cVar.f290759b = bundle.getInt("KEY_MSG_UIN_TYPE");
                    cVar.f290760c = bundle.getLong("KEY_MSG_UNI_SEQ");
                    cVar.f290761d = bundle.getString("KEY_VIDEO_PATH");
                    cVar.f290762e = bundle.getString("KEY_VIDEO_MD5");
                    cVar.f290763f = bundle.getInt("KEY_TIMEOUT");
                }
                return cVar;
            }

            Bundle b() {
                Bundle bundle = new Bundle();
                bundle.putString("KEY_MSG_UIN", this.f290758a);
                bundle.putInt("KEY_MSG_UIN_TYPE", this.f290759b);
                bundle.putLong("KEY_MSG_UNI_SEQ", this.f290760c);
                bundle.putString("KEY_VIDEO_PATH", this.f290761d);
                bundle.putString("KEY_VIDEO_MD5", this.f290762e);
                bundle.putInt("KEY_TIMEOUT", this.f290763f);
                return bundle;
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.stt.sub.api.b$b$d */
        /* loaded from: classes18.dex */
        static class d {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            int f290764a;

            /* renamed from: b, reason: collision with root package name */
            String f290765b;

            d() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                } else {
                    this.f290764a = 10;
                    this.f290765b = null;
                }
            }

            static d a(Bundle bundle) {
                d dVar = new d();
                if (bundle != null) {
                    dVar.f290764a = bundle.getInt("RESULT_ERROR_CODE");
                    dVar.f290765b = bundle.getString("RESULT_SUBTITLE_PATH");
                }
                return dVar;
            }

            static Bundle b(int i3, String str) {
                Bundle bundle = new Bundle();
                bundle.putInt("RESULT_ERROR_CODE", i3);
                bundle.putString("RESULT_SUBTITLE_PATH", str);
                return bundle;
            }
        }

        C8626b(b bVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) bVar);
            } else {
                this.f290754a = bVar;
            }
        }

        public static void a(String str, int i3, long j3, String str2, String str3, int i16, com.tencent.mobileqq.stt.sub.api.a aVar) {
            c cVar = new c();
            cVar.f290758a = str;
            cVar.f290759b = i3;
            cVar.f290760c = j3;
            cVar.f290761d = str2;
            cVar.f290762e = str3;
            cVar.f290763f = i16;
            QIPCClientHelper.getInstance().callServer("VideoSubtitleQIPC", "ACTION_GET_VIDEO_SUBTITLE", cVar.b(), new C8627b(aVar));
        }

        void b(@NonNull AppRuntime appRuntime, Bundle bundle, int i3) {
            c a16 = c.a(bundle);
            ((IVideoSubtitleManager) appRuntime.getRuntimeService(IVideoSubtitleManager.class, "")).getVideoSubtitle(a16.f290758a, a16.f290759b, a16.f290760c, a16.f290761d, a16.f290762e, a16.f290763f, new a(i3));
        }
    }

    public b(String str) {
        super(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        }
    }

    public static b b() {
        return a.f290753a;
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (EIPCResult) iPatchRedirector.redirect((short) 2, this, str, bundle, Integer.valueOf(i3));
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.i("VideoSubtitleQIPC", 1, "onCall, no app runtime, action=" + str);
            callbackResult(i3, EIPCResult.createResult(-1, new Bundle()));
            return null;
        }
        if ("ACTION_GET_VIDEO_SUBTITLE".equals(str)) {
            new C8626b(this).b(peekAppRuntime, bundle, i3);
        }
        return null;
    }
}
