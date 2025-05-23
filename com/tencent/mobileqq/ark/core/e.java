package com.tencent.mobileqq.ark.core;

import android.os.Bundle;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.ark.api.IArkService;
import com.tencent.mobileqq.ark.p;
import com.tencent.mobileqq.mini.servlet.GetCMShowInfoServlet;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes11.dex */
public class e implements k91.a {

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a implements BusinessObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Bundle f199334d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f199335e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ k91.c f199336f;

        a(Bundle bundle, String str, k91.c cVar) {
            this.f199334d = bundle;
            this.f199335e = str;
            this.f199336f = cVar;
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int i3, boolean z16, Object obj) {
            e.d(i3, z16, (String) obj, this.f199334d, this.f199335e, this.f199336f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class b implements k91.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f199338a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f199339b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f199340c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f199341d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ c f199342e;

        b(String str, String str2, int i3, int i16, c cVar) {
            this.f199338a = str;
            this.f199339b = str2;
            this.f199340c = i3;
            this.f199341d = i16;
            this.f199342e = cVar;
        }

        @Override // k91.b
        public void a(boolean z16, Bundle bundle) {
            int i3;
            String str;
            if (bundle != null) {
                z16 = bundle.getBoolean("result_is_success");
                i3 = bundle.getInt("result_notify_type");
                str = bundle.getString(GetCMShowInfoServlet.EXTRA_RESULT_DATA);
            } else {
                i3 = 0;
                str = "";
            }
            this.f199342e.a(z16, i3, str);
        }

        @Override // k91.b
        public Bundle getArguments() {
            Bundle bundle = new Bundle();
            bundle.putString(MiniChatConstants.PARAM_CMD, this.f199338a);
            bundle.putString("param_data", this.f199339b);
            bundle.putInt("param_timeout", this.f199340c);
            bundle.putInt("param_notify_type", this.f199341d);
            return bundle;
        }

        @Override // k91.b
        public String getMethod() {
            return "ARK.SendSSOMsg";
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface c {
        void a(boolean z16, int i3, String str);
    }

    static void d(int i3, boolean z16, String str, Bundle bundle, String str2, k91.c cVar) {
        Bundle bundle2 = new Bundle();
        bundle2.putAll(bundle);
        bundle2.putBoolean("result_is_success", z16);
        bundle2.putInt("result_notify_type", i3);
        bundle2.putString(GetCMShowInfoServlet.EXTRA_RESULT_DATA, str);
        EIPCResult createResult = EIPCResult.createResult(0, bundle2);
        QLog.i("ArkApp.ArkAppSSOIPCHandler", 1, "receive reply, cmd:" + str2 + ", success=" + z16);
        cVar.a(createResult);
    }

    protected static void e(g gVar, String str, String str2, int i3, int i16, c cVar) {
        gVar.call(new b(str, str2, i3, i16, cVar));
    }

    public static void f(String str, String str2, int i3, int i16, c cVar) {
        e(g.e(), str, str2, i3, i16, cVar);
    }

    @Override // k91.a
    public void a(Bundle bundle, k91.c cVar) {
        String string = bundle.getString(MiniChatConstants.PARAM_CMD);
        String string2 = bundle.getString("param_data");
        int i3 = bundle.getInt("param_timeout");
        int i16 = bundle.getInt("param_notify_type");
        p c16 = c();
        if (c16 == null) {
            QLog.i("ArkApp.ArkAppSSOIPCHandler", 1, "ark sso is null");
            cVar.a(EIPCResult.createResult(-102, new Bundle()));
        } else {
            c16.sendAppMsg(string, string2, i3, i16, new a(bundle, string, cVar));
        }
    }

    protected p c() {
        return ((IArkService) MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IArkService.class, "")).getSSO();
    }

    @Override // k91.d
    public String getMethod() {
        return "ARK.SendSSOMsg";
    }
}
