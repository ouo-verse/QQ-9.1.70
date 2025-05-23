package n72;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.matchfriend.api.IQQStrangerUserInfoMgr;
import com.tencent.mobileqq.matchfriend.bean.QQStrangerUserInfo;
import com.tencent.mobileqq.matchfriend.request.MatchFriendRequest;
import com.tencent.qphone.base.util.QLog;
import com.tencent.relation.common.servlet.c;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: n72.a$a, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public class C10829a implements c {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ IQQStrangerUserInfoMgr f418551d;

        C10829a(IQQStrangerUserInfoMgr iQQStrangerUserInfoMgr) {
            this.f418551d = iQQStrangerUserInfoMgr;
        }

        /* compiled from: P */
        /* renamed from: n72.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes38.dex */
        class C10830a implements Function1<QQStrangerUserInfo, Unit> {
            C10830a() {
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Unit invoke(QQStrangerUserInfo qQStrangerUserInfo) {
                if (qQStrangerUserInfo == null) {
                    return null;
                }
                C10829a.this.f418551d.setSelfUserInfo(qQStrangerUserInfo);
                return null;
            }
        }

        @Override // mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            if (!z16) {
                QLog.e("MatchFriendChatUtils", 1, "needExecuteLoginReport is error! server is error!");
                return;
            }
            String string = bundle.getString("key_open_id");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            this.f418551d.reqUserInfo(new com.tencent.mobileqq.matchfriend.bean.c(104, 0L, string), new C10830a());
        }
    }

    public static Intent a(Context context, String str) {
        Intent aliasIntent = SplashActivity.getAliasIntent(context);
        aliasIntent.putExtra("uin", str);
        aliasIntent.putExtra("uintype", 1046);
        aliasIntent.putExtra("key_match_friend_is_from_notification", true);
        Intent m3 = BaseAIOUtils.m(aliasIntent, new int[]{2});
        m3.setAction("com.tencent.mobileqq.action.MAINACTIVITY");
        b();
        return m3;
    }

    private static void b() {
        AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        if (appInterface == null) {
            QLog.e("MatchFriendChatUtils", 1, "needExecuteLoginReport is error! app is invalid!");
            return;
        }
        IQQStrangerUserInfoMgr iQQStrangerUserInfoMgr = (IQQStrangerUserInfoMgr) appInterface.getRuntimeService(IQQStrangerUserInfoMgr.class, "all");
        QQStrangerUserInfo selfUserInfo = iQQStrangerUserInfoMgr.getSelfUserInfo();
        if (selfUserInfo == null || TextUtils.isEmpty(selfUserInfo.openId) || selfUserInfo.tinyId == 0) {
            MatchFriendRequest.L(appInterface, new C10829a(iQQStrangerUserInfoMgr));
        }
    }
}
