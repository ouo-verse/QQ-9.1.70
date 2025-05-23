package o72;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendEntryApi;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendRequest;
import com.tencent.mobileqq.matchfriend.api.IQQStrangerUserInfoMgr;
import com.tencent.mobileqq.matchfriend.bean.QQStrangerUserInfo;
import com.tencent.mobileqq.matchfriend.report.api.IMatchFriendJubaoApi;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOVideoResultApi;
import com.tencent.qqnt.kernel.nativeinterface.LocalAVRecordElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import eipc.EIPCResult;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes38.dex */
public class c extends QIPCModule {

    /* compiled from: P */
    /* loaded from: classes38.dex */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final c f422186a = new c();
    }

    c() {
        super("MatchFriendVoiceChatIpcServer");
    }

    public static c c() {
        return a.f422186a;
    }

    private void d(QQAppInterface qQAppInterface, int i3) {
        String str;
        QQStrangerUserInfo selfUserInfo = ((IQQStrangerUserInfoMgr) qQAppInterface.getRuntimeService(IQQStrangerUserInfoMgr.class, "all")).getSelfUserInfo();
        QLog.i("MatchFriendVoiceChatIpcServer", 1, "getSelfProfile, selfUserInfo = " + selfUserInfo);
        Bundle bundle = new Bundle();
        String str2 = "";
        if (selfUserInfo == null) {
            str = "";
        } else {
            str = selfUserInfo.avatar;
        }
        bundle.putString("key_avatar", str);
        if (selfUserInfo != null) {
            str2 = selfUserInfo.nick;
        }
        bundle.putString("key_nickname", str2);
        EIPCResult eIPCResult = new EIPCResult();
        eIPCResult.data = bundle;
        eIPCResult.code = 0;
        callbackResult(i3, eIPCResult);
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("MatchFriendVoiceChatIpcServer", 2, "onCall, params=" + bundle + ", action=" + str + ", callBackId=" + i3);
        }
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (!(runtime instanceof QQAppInterface)) {
            return null;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) runtime;
        if ("InsertVoiceChatRecord".equals(str)) {
            e(qQAppInterface, bundle);
        } else if ("startJubaoOperation".equals(str)) {
            g(qQAppInterface, bundle);
        } else if ("voiceChatGetSelfProfile".equals(str)) {
            d(qQAppInterface, i3);
        } else if ("enterVoiceChat".equals(str)) {
            b(qQAppInterface, bundle);
        } else if ("openProfile".equals(str)) {
            f(qQAppInterface, bundle);
        }
        return null;
    }

    private void f(QQAppInterface qQAppInterface, Bundle bundle) {
        if (bundle == null) {
            return;
        }
        boolean z16 = bundle.getBoolean("key_is_self", false);
        int i3 = bundle.getInt("key_first_relation_origin", 2);
        int i16 = bundle.getInt("key_from_source", 6);
        if (z16) {
            ((IMatchFriendEntryApi) QRoute.api(IMatchFriendEntryApi.class)).enterProfileCard(qQAppInterface, BaseApplication.getContext(), bundle.getLong("key_self_tiny_id"), i3, i16);
        } else {
            ((IMatchFriendEntryApi) QRoute.api(IMatchFriendEntryApi.class)).enterProfileCard(BaseApplication.getContext(), bundle.getString("key_open_id"), i3, i16);
        }
    }

    private void b(QQAppInterface qQAppInterface, Bundle bundle) {
        if (qQAppInterface == null || bundle == null) {
            return;
        }
        long j3 = bundle.getLong("friend_tiny_id");
        if (j3 == 0) {
            QLog.e("MatchFriendVoiceChatIpcServer", 1, "ipc enterVoiceChat friendTinyId == 0");
        } else {
            ((IMatchFriendRequest) QRoute.api(IMatchFriendRequest.class)).setFirstRelationOrigin(qQAppInterface, j3, 2, null);
        }
    }

    private void g(QQAppInterface qQAppInterface, Bundle bundle) {
        if (qQAppInterface == null || bundle == null) {
            return;
        }
        long j3 = bundle.getLong("friend_tiny_id");
        ((IMatchFriendJubaoApi) QRoute.api(IMatchFriendJubaoApi.class)).startMatchFriendJubaoByScene(qQAppInterface, BaseApplication.getContext(), IMatchFriendJubaoApi.From.VOICE_MATCH, String.valueOf(j3), bundle.getString("content_id", ""), null);
    }

    private void e(QQAppInterface qQAppInterface, Bundle bundle) {
        if (qQAppInterface == null || bundle == null) {
            return;
        }
        long j3 = bundle.getLong("friend_tiny_id");
        String string = bundle.getString("time_text");
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        String str = BaseApplication.getContext().getString(R.string.idh) + " " + string;
        ((IAIOVideoResultApi) com.tencent.qqnt.aio.adapter.a.b(IAIOVideoResultApi.class)).addLocalAVRecordMsg(new Contact(104, String.valueOf(j3), ""), new LocalAVRecordElement(7, currentTimeMillis, qQAppInterface.getCurrentUid(), 1, str, str, true, System.currentTimeMillis() / 1000, 0));
    }
}
