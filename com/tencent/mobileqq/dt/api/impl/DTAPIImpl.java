package com.tencent.mobileqq.dt.api.impl;

import android.content.Context;
import android.text.TextUtils;
import com.google.protobuf.nano.MessageNano;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.guard.guardinterface.GuardManagerCallbackDispatcher;
import com.tencent.mobileqq.dt.api.IDTAPI;
import com.tencent.mobileqq.dt.api.ScanPicData;
import com.tencent.mobileqq.dt.api.f;
import com.tencent.mobileqq.dt.api.g;
import com.tencent.mobileqq.dt.api.h;
import com.tencent.mobileqq.dt.api.i;
import com.tencent.mobileqq.dt.app.GuardManager;
import com.tencent.mobileqq.dt.kuikly.module.O3Module;
import com.tencent.mobileqq.dt.kuikly.ui.HRQUSHalfScreenFloatingView;
import com.tencent.mobileqq.dt.model.TuringWrapper;
import com.tencent.mobileqq.dt.model.WebCheck;
import com.tencent.mobileqq.dt.tip.O3AIONotifyBannerManager;
import com.tencent.mobileqq.dt.web.O3BusinessHandler;
import com.tencent.mobileqq.fe.FEKit;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class DTAPIImpl implements IDTAPI {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "FEKitMainDTAPIImpl";
    private final GuardManager mGuardManager;
    private final com.tencent.mobileqq.dt.app.c mUinManager;

    /* loaded from: classes5.dex */
    class a implements Function0<i01.a> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DTAPIImpl.this);
            }
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public i01.a invoke() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (i01.a) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return new O3Module();
        }
    }

    /* loaded from: classes5.dex */
    class b implements Function1<Context, i01.c> {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DTAPIImpl.this);
            }
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public i01.c invoke(Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (i01.c) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            }
            return new HRQUSHalfScreenFloatingView(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class c extends com.tencent.mobileqq.dt.web.a {
        static IPatchRedirector $redirector_;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ O3BusinessHandler f203675f;

        c(O3BusinessHandler o3BusinessHandler) {
            this.f203675f = o3BusinessHandler;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DTAPIImpl.this, (Object) o3BusinessHandler);
            }
        }

        @Override // com.tencent.mobileqq.dt.web.a
        public void b(int i3, byte[] bArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) bArr);
                return;
            }
            QLog.i(DTAPIImpl.TAG, 1, "GetSocialLockStatus code " + i3);
            if (bArr != null && bArr.length != 0) {
                try {
                    JSONObject jSONObject = new JSONObject(new String(bArr));
                    if (jSONObject.optBoolean("is_locked", false)) {
                        int optInt = jSONObject.optInt("rsp_code", 0);
                        QLog.i(DTAPIImpl.TAG, 1, "GetSocialLockStatus locked " + optInt);
                        this.f203675f.D2("recError", String.valueOf(optInt), null);
                    }
                } catch (Exception e16) {
                    QLog.e(DTAPIImpl.TAG, 1, "parse GetSocialLockStatus error", e16);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    class d extends com.tencent.mobileqq.dt.web.a {
        static IPatchRedirector $redirector_;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ f f203677f;

        d(f fVar) {
            this.f203677f = fVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DTAPIImpl.this, (Object) fVar);
            }
        }

        @Override // com.tencent.mobileqq.dt.web.a
        public void b(int i3, byte[] bArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) bArr);
                return;
            }
            QLog.i(DTAPIImpl.TAG, 1, "getSecureEntryList onResult " + i3);
            if (bArr != null && bArr.length != 0) {
                DTAPIImpl.this.onGetSecureEntryResult(i3, bArr, this.f203677f);
            } else {
                this.f203677f.onResult(i3, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class e implements Comparator<g> {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DTAPIImpl.this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(g gVar, g gVar2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) gVar, (Object) gVar2)).intValue();
            }
            return Integer.compare(gVar.f203666a, gVar2.f203666a);
        }
    }

    public DTAPIImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mUinManager = new com.tencent.mobileqq.dt.app.c();
            this.mGuardManager = new GuardManager();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getSocialLockStatus() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            O3BusinessHandler o3BusinessHandler = (O3BusinessHandler) ((AppInterface) peekAppRuntime).getBusinessHandler(O3BusinessHandler.class.getName());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("cmd", "GetSocialLockStatus");
                jSONObject.put("data", "{}");
            } catch (JSONException e16) {
                QLog.e(TAG, 1, "parse json error", e16);
            }
            o3BusinessHandler.D2("sendRequest", jSONObject.toString(), new c(o3BusinessHandler));
            return;
        }
        QLog.e(TAG, 1, "GetSocialLockStatus but app is null");
    }

    private boolean isValidData(com.tencent.mobileqq.dt.data.a aVar) {
        if (aVar.f203762a >= 0 && !TextUtils.isEmpty(aVar.f203763b) && !TextUtils.isEmpty(aVar.f203764c)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onGetSecureEntryResult(int i3, byte[] bArr, f fVar) {
        try {
            com.tencent.mobileqq.dt.data.d c16 = com.tencent.mobileqq.dt.data.d.c(bArr);
            ArrayList arrayList = new ArrayList();
            HashSet hashSet = new HashSet();
            for (com.tencent.mobileqq.dt.data.a aVar : c16.f203768a) {
                if (isValidData(aVar) && !hashSet.contains(Integer.valueOf(aVar.f203762a))) {
                    arrayList.add(new g(aVar.f203762a, aVar.f203763b, aVar.f203764c));
                    hashSet.add(Integer.valueOf(aVar.f203762a));
                }
            }
            Collections.sort(arrayList, new e());
            fVar.onResult(i3, arrayList);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "parse GetEntryConfigRsp error", e16);
            fVar.onResult(-1, null);
        }
    }

    @Override // com.tencent.mobileqq.dt.api.IDTAPI
    public String getO3MMKVData(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
        }
        return com.tencent.mobileqq.fe.f.a().g(str);
    }

    @Override // com.tencent.mobileqq.dt.api.IDTAPI
    public Class<?> getO3SchemeParserClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (Class) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return com.tencent.mobileqq.dt.report.b.class;
    }

    @Override // com.tencent.mobileqq.dt.api.IDTAPI
    public void getSecureEntryList(f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) fVar);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            O3BusinessHandler o3BusinessHandler = (O3BusinessHandler) ((AppInterface) peekAppRuntime).getBusinessHandler(O3BusinessHandler.class.getName());
            com.tencent.mobileqq.dt.data.c cVar = new com.tencent.mobileqq.dt.data.c();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("cmd", "GetEntryConfig");
                jSONObject.put("data", new String(MessageNano.toByteArray(cVar)));
            } catch (JSONException e16) {
                QLog.e(TAG, 1, "parse json error", e16);
            }
            o3BusinessHandler.D2("sendRequest", jSONObject.toString(), new d(fVar));
            return;
        }
        QLog.e(TAG, 1, "getSecureEntryList but app is null");
        fVar.onResult(-1, null);
    }

    @Override // com.tencent.mobileqq.dt.api.IDTAPI
    public void initO3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.dt.api.impl.DTAPIImpl.5
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DTAPIImpl.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    try {
                        FEKit.getInstance().setContext(MobileQQ.sMobileQQ);
                        GuardManagerCallbackDispatcher.registerCallBack(new com.tencent.mobileqq.dt.api.impl.a());
                        boolean h16 = com.tencent.mobileqq.dt.app.a.c().d().h();
                        com.tencent.mobileqq.fe.d.l(h16);
                        int f16 = com.tencent.mobileqq.dt.app.a.c().d().f();
                        int g16 = com.tencent.mobileqq.dt.app.a.c().d().g();
                        com.tencent.mobileqq.fe.d.j(f16, g16);
                        QLog.e("FEKitMain_FESoManager", 1, "SafeMode:" + h16 + ",count: " + f16 + ",timeGap:" + g16);
                        com.tencent.mobileqq.dt.model.g.c();
                        ((AppInterface) MobileQQ.sMobileQQ.peekAppRuntime()).getCurrentAccountUin();
                        O3AIONotifyBannerManager.f203873a.g();
                        DTAPIImpl.this.getSocialLockStatus();
                    } catch (Throwable th5) {
                        QLog.e("FEKitMain_FESoManager", 2, "exception:" + th5.getMessage());
                    }
                }
            }, 128, null, true);
        }
    }

    @Override // com.tencent.mobileqq.dt.api.IDTAPI
    public void jumpReport(Context context, com.tencent.mobileqq.dt.api.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            jumpReport(context, bVar, null);
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) bVar);
        }
    }

    @Override // com.tencent.mobileqq.dt.api.IDTAPI
    public void onSecDispatchToAppEvent(String str, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) str, (Object) bArr);
        } else {
            com.tencent.mobileqq.dt.model.b.c(str, bArr);
        }
    }

    @Override // com.tencent.mobileqq.dt.api.IDTAPI
    public void preInitO3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.dt.api.impl.DTAPIImpl.3
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DTAPIImpl.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        DTAPIImpl.this.mUinManager.g();
                        DTAPIImpl.this.mGuardManager.c();
                    }
                }
            }, 64, null, true);
            ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.dt.api.impl.DTAPIImpl.4
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DTAPIImpl.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    try {
                        com.tencent.mobileqq.dt.app.a.c().d().i();
                        QLog.e("FEKitMain_FESoManager", 1, "bd:" + com.tencent.mobileqq.dt.app.a.c().d().j());
                        com.tencent.mobileqq.dt.model.a.c().d();
                    } catch (Throwable unused) {
                    }
                }
            }, 128, null, true, 60000L);
        }
    }

    @Override // com.tencent.mobileqq.dt.api.IDTAPI
    public void registerExternalModule(com.tencent.kuikly.core.render.android.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bVar);
        } else {
            bVar.a("QQKuiklySecurityModule", new a());
        }
    }

    @Override // com.tencent.mobileqq.dt.api.IDTAPI
    public void registerExternalView(com.tencent.kuikly.core.render.android.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) bVar);
        } else {
            bVar.g("HRQUSHalfScreenFloatingView", new b(), null);
        }
    }

    @Override // com.tencent.mobileqq.dt.api.IDTAPI
    public void scanCameraSecurity(com.tencent.mobileqq.dt.api.e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) eVar);
        } else {
            com.tencent.mobileqq.dt.model.f.f203845a.g(eVar);
        }
    }

    @Override // com.tencent.mobileqq.dt.api.IDTAPI
    public void scanPressSecurityReport(ScanPicData scanPicData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) scanPicData);
        } else {
            com.tencent.mobileqq.dt.model.f.f203845a.h(scanPicData);
        }
    }

    @Override // com.tencent.mobileqq.dt.api.IDTAPI
    public void tryDLFEKIT() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        try {
            AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
            if (com.tencent.mobileqq.dt.app.a.c().d().d() && com.tencent.mobileqq.app.guard.GuardManager.sInstance.isApplicationForeground()) {
                com.tencent.mobileqq.turingfd.a.g(BaseApplication.getContext(), appInterface, true);
            }
            if (com.tencent.mobileqq.dt.app.a.c().d().e() && com.tencent.mobileqq.app.guard.GuardManager.sInstance.isApplicationForeground()) {
                QLog.e("FEKitMain", 2, "turingid enable");
                TuringWrapper.c();
            }
        } catch (Throwable th5) {
            QLog.e("FEKitMain", 2, "exception:" + th5.getMessage());
        }
    }

    @Override // com.tencent.mobileqq.dt.api.IDTAPI
    public void webCheck(i iVar, h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) iVar, (Object) hVar);
        } else {
            QLog.i(TAG, 1, "start webCheck");
            WebCheck.c(iVar, hVar);
        }
    }

    @Override // com.tencent.mobileqq.dt.api.IDTAPI
    public void jumpReport(Context context, com.tencent.mobileqq.dt.api.b bVar, com.tencent.mobileqq.dt.api.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            com.tencent.mobileqq.dt.report.c.b(context, bVar, dVar);
        } else {
            iPatchRedirector.redirect((short) 3, this, context, bVar, dVar);
        }
    }
}
