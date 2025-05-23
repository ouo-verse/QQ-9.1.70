package o72;

import android.os.Bundle;
import com.tencent.mobileqq.matchfriend.voicechat.VoiceChatController;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

/* compiled from: P */
/* loaded from: classes38.dex */
public class b extends QIPCModule {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final b f422185a = new b("MatchFriendVoiceChatIpcClient");
    }

    b(String str) {
        super(str);
    }

    private void b(int i3) {
        boolean N = VoiceChatController.I().N();
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_in_voice_chat", N);
        EIPCResult eIPCResult = new EIPCResult();
        eIPCResult.data = bundle;
        callbackResult(i3, eIPCResult);
    }

    public static b c() {
        return a.f422185a;
    }

    public static void register() {
        try {
            QIPCClientHelper.getInstance().register(c());
        } catch (Exception e16) {
            QLog.d("MatchFriendVoiceChatIpcClient", 1, "register error: ", e16);
        }
    }

    public static void unregister() {
        if (QIPCClientHelper.getInstance().getClient() == null) {
            return;
        }
        try {
            QIPCClientHelper.getInstance().getClient().unRegisterModule(c());
        } catch (Exception e16) {
            QLog.d("MatchFriendVoiceChatIpcClient", 1, "unregister error: ", e16);
        }
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        if (QLog.isColorLevel()) {
            QLog.i("MatchFriendVoiceChatIpcClient", 2, "onCall, action[" + str + "]");
        }
        if (!"CheckIsInVoiceChat".equals(str)) {
            return null;
        }
        b(i3);
        return null;
    }
}
