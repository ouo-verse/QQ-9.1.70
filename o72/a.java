package o72;

import android.os.Bundle;
import com.tencent.avbiz.AVBizModuleFactory;
import com.tencent.avbiz.Constants;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.framebusiness.g;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendEntryApi;
import com.tencent.mobileqq.mini.api.IMiniContainer;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.kuolie.voice_match.voice_match.voice_match$CheckCanAquireVoiceChatFocusRsp;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a extends QIPCModule {

    /* renamed from: d, reason: collision with root package name */
    private static volatile a f422182d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: o72.a$a, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public class C10891a implements EIPCResultCallback {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f422183d;

        C10891a(int i3) {
            this.f422183d = i3;
        }

        @Override // eipc.EIPCResultCallback
        public void onCallback(EIPCResult eIPCResult) {
            if (eIPCResult == null) {
                QLog.i("MatchFriendIpcServer", 1, "result == null");
                a.this.e(this.f422183d, true);
                return;
            }
            if (!eIPCResult.isSuccess()) {
                QLog.e("MatchFriendIpcServer", 1, "result error code=" + eIPCResult.code);
                a.this.e(this.f422183d, true);
                return;
            }
            Bundle bundle = eIPCResult.data;
            if (bundle == null) {
                a.this.e(this.f422183d, true);
                return;
            }
            boolean z16 = bundle.getBoolean("is_in_voice_chat", false);
            QLog.i("MatchFriendIpcServer", 1, "checkCanAcquireVoiceChatFocus inVoiceChat=" + z16);
            a.this.e(this.f422183d, z16 ^ true);
        }
    }

    a() {
        super("MatchFriendIpcServer");
    }

    private void c(int i3) {
        String checkAVFocus = AVBizModuleFactory.getModuleByName(Constants.Business.MATCH_FRIEND).checkAVFocus();
        boolean equals = "true".equals(checkAVFocus);
        QLog.i("MatchFriendIpcServer", 1, "checkCanAcquireVoiceChatFocus canAcquire=" + equals + " avFocusResult=" + checkAVFocus);
        if (!equals) {
            e(i3, false);
        } else {
            QIPCServerHelper.getInstance().callClient(Constants.Process.MATCH_FRIEND_PROCESS, "MatchFriendVoiceChatIpcClient", "CheckIsInVoiceChat", new Bundle(), new C10891a(i3));
        }
    }

    public static a d() {
        if (f422182d == null) {
            synchronized (a.class) {
                if (f422182d == null) {
                    f422182d = new a();
                }
            }
        }
        return f422182d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i3, boolean z16) {
        voice_match$CheckCanAquireVoiceChatFocusRsp voice_match_checkcanaquirevoicechatfocusrsp = new voice_match$CheckCanAquireVoiceChatFocusRsp();
        voice_match_checkcanaquirevoicechatfocusrsp.canAquire.set(z16);
        Bundle bundle = new Bundle();
        bundle.putByteArray("key_data", voice_match_checkcanaquirevoicechatfocusrsp.toByteArray());
        EIPCResult eIPCResult = new EIPCResult();
        eIPCResult.data = bundle;
        callbackResult(i3, eIPCResult);
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("MatchFriendIpcServer", 2, "onCall, params=" + bundle + ", action=" + str + ", callBackId=" + i3);
        }
        if (!(BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
            return null;
        }
        if ("checkCanAcquireVoiceChatFocus".equals(str)) {
            c(i3);
        } else if ("setDynamicTab".equals(str)) {
            g.f182384d = true;
        } else if ("jumpMiniContainerPage".equals(str)) {
            String string = bundle.getString("key_mini_path");
            QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
            if (qBaseActivity != null && !qBaseActivity.isFinishing()) {
                ((IMiniContainer) QRoute.api(IMiniContainer.class)).launchPage(qBaseActivity, string);
            } else {
                ((IMiniContainer) QRoute.api(IMiniContainer.class)).launchPage(BaseApplication.getContext(), string);
            }
        } else if ("jumpMatchFriendAIO".equals(str)) {
            f(bundle);
        }
        return null;
    }

    private void f(Bundle bundle) {
        if (bundle == null) {
            QLog.e("MatchFriendIpcServer", 1, "jumpMatchFriendAIO is error! params is invalid!");
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && peekAppRuntime.isLogin()) {
            ((IMatchFriendEntryApi) QRoute.api(IMatchFriendEntryApi.class)).enterMatchFriendAIO(BaseApplication.getContext(), bundle.getLong("friend_tiny_id"), bundle.getString("key_nickname"), bundle.getInt("key_first_relation_origin"));
            return;
        }
        QLog.e("MatchFriendIpcServer", 1, "jumpMatchFriendAIO is error! not login!");
    }
}
