package d92;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.launch.MiniSdkLauncher;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import d92.h;
import mqq.os.MqqHandler;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes38.dex */
public class h {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes38.dex */
    public class a implements MiniAppCmdInterface {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ d92.a f393234a;

        a(d92.a aVar) {
            this.f393234a = aVar;
        }

        @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
        public void onCmdListener(boolean z16, JSONObject jSONObject) {
            final long optLong = jSONObject.optLong("retCode");
            final String optString = jSONObject.optString("errMsg");
            if (!z16) {
                MqqHandler uIHandler = ThreadManager.getUIHandler();
                final d92.a aVar = this.f393234a;
                uIHandler.post(new Runnable() { // from class: d92.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        h.a.d(a.this, optLong, optString);
                    }
                });
                return;
            }
            MiniAppInfo miniAppInfo = (MiniAppInfo) jSONObject.opt("mini_app_info_data");
            if (miniAppInfo != null) {
                final com.tencent.qqmini.sdk.launcher.model.MiniAppInfo convert = MiniSdkLauncher.convert(new MiniAppConfig(miniAppInfo));
                MqqHandler uIHandler2 = ThreadManager.getUIHandler();
                final d92.a aVar2 = this.f393234a;
                uIHandler2.post(new Runnable() { // from class: d92.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.this.onSuccess(convert);
                    }
                });
                return;
            }
            MqqHandler uIHandler3 = ThreadManager.getUIHandler();
            final d92.a aVar3 = this.f393234a;
            uIHandler3.post(new Runnable() { // from class: d92.g
                @Override // java.lang.Runnable
                public final void run() {
                    h.a.f(a.this, optLong);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void d(d92.a aVar, long j3, String str) {
            aVar.onFail((int) j3, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void f(d92.a aVar, long j3) {
            aVar.onFail((int) j3, "appInfo opt failed.");
        }
    }

    private static MiniAppCmdInterface a(d92.a aVar) {
        return new a(aVar);
    }

    public static void b(String str, String str2, String str3, d92.a aVar) {
        MiniAppCmdUtil.getInstance().getAppInfoById(null, str, str2, str3, null, a(aVar));
    }
}
