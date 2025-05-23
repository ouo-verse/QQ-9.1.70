package com.tencent.mobileqq.qqgamepub.ipc;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes16.dex */
public class QQGameIPCHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private static volatile QQGameIPCHandler f264587b;

    /* renamed from: a, reason: collision with root package name */
    private Map<String, a> f264588a;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes16.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private String f264595a;

        /* renamed from: b, reason: collision with root package name */
        private b f264596b;

        public a(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            } else {
                this.f264595a = str;
            }
        }

        public void d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                this.f264596b = null;
            }
        }
    }

    /* loaded from: classes16.dex */
    public interface b {
        void a(String str, EIPCResult eIPCResult);
    }

    QQGameIPCHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f264588a = Collections.synchronizedMap(new HashMap());
        }
    }

    public static QQGameIPCHandler e() {
        if (f264587b == null) {
            synchronized (QQGameIPCHandler.class) {
                if (f264587b == null) {
                    f264587b = new QQGameIPCHandler();
                }
            }
        }
        return f264587b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        a aVar;
        Map<String, a> map = this.f264588a;
        if (map != null && map.size() == 1 && this.f264588a.containsKey("task_qgame_task_all_complete") && (aVar = this.f264588a.get("task_qgame_task_all_complete")) != null && aVar.f264596b != null) {
            aVar.f264596b.a("task_qgame_task_all_complete", new EIPCResult());
            this.f264588a.remove(aVar);
        }
    }

    public void c(String str, b bVar) {
        Map<String, a> map;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) bVar);
        } else if (bVar != null && (map = this.f264588a) != null && map.containsKey(str)) {
            this.f264588a.get(str).f264596b = bVar;
        }
    }

    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        Map<String, a> map = this.f264588a;
        if (map != null) {
            map.clear();
            this.f264588a.put("task_get_qgame_msg", new a("findMessage"));
            this.f264588a.put("task_get_qgame_session_msg", new a("getGameMsg"));
            this.f264588a.put("task_qgame_task_all_complete", new a("task_qgame_task_all_complete"));
        }
    }

    public void f(String str, boolean z16) {
        a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, Boolean.valueOf(z16));
            return;
        }
        Map<String, a> map = this.f264588a;
        if (map == null || (aVar = map.get(str)) == null) {
            return;
        }
        QIPCClientHelper.getInstance().callServer("QQGameIPCModule", aVar.f264595a, null, new EIPCResultCallback(aVar, str, z16) { // from class: com.tencent.mobileqq.qqgamepub.ipc.QQGameIPCHandler.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ a f264589d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f264590e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ boolean f264591f;

            {
                this.f264589d = aVar;
                this.f264590e = str;
                this.f264591f = z16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, QQGameIPCHandler.this, aVar, str, Boolean.valueOf(z16));
                }
            }

            @Override // eipc.EIPCResultCallback
            public void onCallback(EIPCResult eIPCResult) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) eIPCResult);
                } else {
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable(eIPCResult) { // from class: com.tencent.mobileqq.qqgamepub.ipc.QQGameIPCHandler.1.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ EIPCResult f264593d;

                        {
                            this.f264593d = eIPCResult;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this, (Object) eIPCResult);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                                return;
                            }
                            if (AnonymousClass1.this.f264589d.f264596b != null) {
                                AnonymousClass1.this.f264589d.f264596b.a(AnonymousClass1.this.f264590e, this.f264593d);
                            }
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            if (anonymousClass1.f264591f) {
                                QQGameIPCHandler.this.f264588a.remove(AnonymousClass1.this.f264590e);
                                QQGameIPCHandler.this.g();
                            }
                        }
                    });
                }
            }
        });
    }

    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        try {
            Map<String, a> map = this.f264588a;
            if (map != null) {
                Iterator<Map.Entry<String, a>> it = map.entrySet().iterator();
                while (it.hasNext()) {
                    it.next().getValue().d();
                }
                this.f264588a.clear();
            }
            f264587b = null;
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    public void i(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            return;
        }
        Map<String, a> map = this.f264588a;
        if (map != null && map.containsKey(str)) {
            this.f264588a.get(str).f264596b = null;
        }
    }
}
