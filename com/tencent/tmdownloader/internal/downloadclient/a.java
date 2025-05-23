package com.tencent.tmdownloader.internal.downloadclient;

import android.content.Context;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.tencent.assistant.sdk.remote.SDKConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistantbase.util.r;
import com.tencent.tmassistantsdk.internal.openSDK.param.jce.BatchSDKDownloadActionResponse;
import com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCRequest;
import com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCResponse;
import com.tencent.tmassistantsdk.internal.openSDK.param.jce.SubScribeSDKDownloadTaskByViaRequest;
import com.tencent.tmassistantsdk.internal.openSDK.param.jce.SubScribeSDKDownloadTaskByViaResponse;
import com.tencent.tmassistantsdk.internal.openSDK.param.jce.SyncSDKDownloadTaskRequest;
import com.tencent.tmassistantsdk.internal.openSDK.param.jce.SyncSDKHandShakeRequest;
import com.tencent.tmdownloader.d;
import com.tencent.tmdownloader.e;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: g, reason: collision with root package name */
    private static String f380670g = "TMAssistantYYBManager";

    /* renamed from: a, reason: collision with root package name */
    private volatile com.tencent.tmassistantsdk.a.b.b f380671a;

    /* renamed from: b, reason: collision with root package name */
    private e f380672b;

    /* renamed from: c, reason: collision with root package name */
    private Context f380673c;

    /* renamed from: d, reason: collision with root package name */
    private String f380674d;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.tmassistantsdk.a.b.a f380675e;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.tmdownloader.b f380676f;

    /* compiled from: P */
    /* renamed from: com.tencent.tmdownloader.internal.downloadclient.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    class C10003a implements com.tencent.tmassistantsdk.a.b.a {
        static IPatchRedirector $redirector_;

        C10003a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // com.tencent.tmassistantsdk.a.b.a
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            r.b(a.f380670g, "onDownloadSDKServiceInvalid yybOpenClient......");
            synchronized (a.this) {
                a.this.f380671a = null;
            }
        }

        @Override // com.tencent.tmassistantsdk.a.b.a
        public void onActionResult(byte[] bArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) bArr);
                return;
            }
            if (bArr != null && bArr.length > 0) {
                IPCResponse a16 = com.tencent.tmassistantsdk.internal.openSDK.e.a.a(bArr);
                JceStruct a17 = com.tencent.tmassistantsdk.internal.openSDK.e.a.a(a16);
                r.b(a.f380670g, "response.head.cmdId = " + a16.head.cmdId);
                int i3 = a16.head.cmdId;
                if (i3 != 10) {
                    if (i3 == 13) {
                        r.b("jimluo", "_BatchDownloadAction......");
                        if (a17 != null) {
                            a.this.a((BatchSDKDownloadActionResponse) a17);
                            return;
                        }
                        return;
                    }
                    return;
                }
                r.b("jimluo", "_SubScribeSDKDownloadTask......");
                if (a17 != null) {
                    a.this.a((SubScribeSDKDownloadTaskByViaResponse) a17);
                    return;
                }
                return;
            }
            r.b(a.f380670g, "onActionResult reponseData = null");
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class b implements Runnable {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (a.this.f380671a == null) {
                return;
            }
            SyncSDKHandShakeRequest syncSDKHandShakeRequest = new SyncSDKHandShakeRequest();
            syncSDKHandShakeRequest.extra = "hello YYB";
            byte[] a16 = a.a(syncSDKHandShakeRequest, "");
            if (a16 != null && a16.length > 0) {
                try {
                    if (a.this.f380671a != null) {
                        a.this.f380671a.a(a16);
                    }
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19123);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f380675e = new C10003a();
            this.f380676f = new c();
        }
    }

    public void b(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) str);
            return;
        }
        this.f380673c = context;
        r.b(f380670g, "initYYBClient yybOpenClient......" + this.f380671a);
        if (this.f380671a == null) {
            synchronized (this) {
                this.f380671a = new com.tencent.tmassistantsdk.a.b.b(context, str, SDKConst.SERVICE_NAME);
                this.f380671a.initTMAssistantDownloadSDK();
                this.f380671a.a(this.f380675e);
            }
        }
    }

    public void a(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context, (Object) str);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f380673c = context;
        this.f380674d = str;
        if (this.f380672b == null) {
            this.f380674d = str;
            e eVar = new e(context, str);
            this.f380672b = eVar;
            eVar.a(this.f380676f);
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class c implements com.tencent.tmdownloader.b {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // com.tencent.tmdownloader.b
        public void a(TMAssistantDownloadTaskInfo tMAssistantDownloadTaskInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) tMAssistantDownloadTaskInfo);
                return;
            }
            r.b(a.f380670g, "onSyncSDKDownloadInfo......");
            if (tMAssistantDownloadTaskInfo == null) {
                return;
            }
            SyncSDKDownloadTaskRequest syncSDKDownloadTaskRequest = new SyncSDKDownloadTaskRequest();
            syncSDKDownloadTaskRequest.data = com.tencent.tmassistantsdk.internal.openSDK.e.a.a(tMAssistantDownloadTaskInfo);
            byte[] a16 = a.a(syncSDKDownloadTaskRequest, "");
            if (a16 == null || a16.length <= 0) {
                return;
            }
            try {
                if (a.this.f380671a != null) {
                    a.this.f380671a.a(a16);
                }
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }

        @Override // com.tencent.tmdownloader.b
        public void a(List<String> list, List<TMAssistantDownloadTaskInfo> list2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) list, (Object) list2);
                return;
            }
            SubScribeSDKDownloadTaskByViaRequest subScribeSDKDownloadTaskByViaRequest = new SubScribeSDKDownloadTaskByViaRequest();
            subScribeSDKDownloadTaskByViaRequest.viaList = (ArrayList) list;
            subScribeSDKDownloadTaskByViaRequest.data = (ArrayList) com.tencent.tmassistantsdk.internal.openSDK.e.a.a(list2);
            byte[] a16 = a.a(subScribeSDKDownloadTaskByViaRequest, "");
            if (a16 == null || a16.length <= 0) {
                return;
            }
            try {
                if (a.this.f380671a != null) {
                    a.this.f380671a.a(a16);
                }
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }

        @Override // com.tencent.tmdownloader.b
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            } else if (a.this.f380672b != null) {
                a.this.f380672b.b();
                a.this.f380672b = null;
            }
        }
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            d.a().post(new b());
        } else {
            iPatchRedirector.redirect((short) 5, (Object) this);
        }
    }

    public void a(SubScribeSDKDownloadTaskByViaResponse subScribeSDKDownloadTaskByViaResponse) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) subScribeSDKDownloadTaskByViaResponse);
            return;
        }
        if (this.f380672b == null) {
            e eVar = new e(this.f380673c, this.f380674d);
            this.f380672b = eVar;
            eVar.a(this.f380676f);
        }
        try {
            this.f380672b.a(subScribeSDKDownloadTaskByViaResponse);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public void a(BatchSDKDownloadActionResponse batchSDKDownloadActionResponse) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) batchSDKDownloadActionResponse);
            return;
        }
        if (this.f380672b == null) {
            e eVar = new e(this.f380673c, this.f380674d);
            this.f380672b = eVar;
            eVar.a(this.f380676f);
        }
        try {
            this.f380672b.a(batchSDKDownloadActionResponse);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public static byte[] a(JceStruct jceStruct, String str) {
        r.b(f380670g, "jceStruct = " + jceStruct);
        IPCRequest a16 = com.tencent.tmassistantsdk.internal.openSDK.e.a.a(jceStruct, str);
        if (a16 != null) {
            byte[] a17 = com.tencent.tmassistantsdk.internal.openSDK.e.a.a(a16);
            if (a17 != null && a17.length > 0) {
                r.b(f380670g, "return sendData length = " + a17.length);
                return a17;
            }
            r.b(f380670g, "handleUriAction sendData = null");
            return null;
        }
        r.b(f380670g, "handleUriAction IPCRequest = null");
        return null;
    }
}
