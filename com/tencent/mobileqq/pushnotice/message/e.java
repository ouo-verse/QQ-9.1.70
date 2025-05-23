package com.tencent.mobileqq.pushnotice.message;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.ac;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.y;
import com.tencent.qqnt.kernel.nativeinterface.CoreInfo;
import com.tencent.qqnt.kernel.nativeinterface.IDetailInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.ProfileBizType;
import com.tencent.qqnt.kernel.nativeinterface.Source;
import com.tencent.qqnt.kernel.nativeinterface.UserDetailInfo;
import com.tencent.qqnt.kernel.nativeinterface.UserSimpleInfo;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes16.dex */
public class e extends com.tencent.mobileqq.pushnotice.message.a {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        volatile String f261371a;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f261371a = null;
            }
        }
    }

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private Intent i(AppRuntime appRuntime, String str) {
        Intent d16 = d();
        d16.putExtra("uin", str);
        d16.putExtra("uintype", 0);
        d16.putExtra("uinname", j(appRuntime, str));
        return d16;
    }

    private String j(AppRuntime appRuntime, String str) {
        if (!(appRuntime instanceof QQAppInterface)) {
            return str;
        }
        try {
            String R = ac.R((QQAppInterface) appRuntime, str, 0);
            if (!str.equals(R)) {
                return R;
            }
        } catch (Exception e16) {
            QLog.w("C2CPushHandler", 1, "[getNickName] exc=" + e16);
        }
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("c2c_push_get_nickname_from_kernel_126916399", true)) {
            return o(str);
        }
        return str;
    }

    private static String k(UserDetailInfo userDetailInfo) {
        UserSimpleInfo userSimpleInfo;
        CoreInfo coreInfo;
        String str;
        if (userDetailInfo != null && (userSimpleInfo = userDetailInfo.simpleInfo) != null && (coreInfo = userSimpleInfo.coreInfo) != null && (str = coreInfo.nick) != null) {
            return str;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(Context context, Intent intent, Intent intent2, AppRuntime appRuntime) {
        e(context, intent);
        c(intent2, appRuntime);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m(final AppRuntime appRuntime, String str, final Context context, final Intent intent) {
        final Intent i3 = i(appRuntime, str);
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.pushnotice.message.c
            @Override // java.lang.Runnable
            public final void run() {
                e.this.l(context, i3, intent, appRuntime);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void n(String str, a aVar, CountDownLatch countDownLatch, int i3, String str2, Source source, HashMap hashMap) {
        UserDetailInfo userDetailInfo;
        if (hashMap != null) {
            userDetailInfo = (UserDetailInfo) hashMap.get(str);
        } else {
            userDetailInfo = null;
        }
        if (userDetailInfo == null) {
            QLog.w("C2CPushHandler", 1, "[syncGetNicknameFromKernel] no detail info, result=" + i3 + ", errMsg=" + str2);
        } else {
            aVar.f261371a = k(userDetailInfo);
        }
        countDownLatch.countDown();
    }

    private String o(String str) {
        String str2;
        y f16 = com.tencent.qqnt.msg.f.f();
        if (f16 == null) {
            QLog.i("C2CPushHandler", 1, "[syncGetNicknameFromKernel] profile service is null");
            return str;
        }
        final String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str);
        if (TextUtils.isEmpty(uidFromUin)) {
            QLog.i("C2CPushHandler", 1, "[syncGetNicknameFromKernel] uid is empty, uin=" + str);
            return str;
        }
        long currentTimeMillis = System.currentTimeMillis();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final a aVar = new a();
        f16.fetchUserDetailInfo("c2c_push_handler", new ArrayList<>(Collections.singletonList(uidFromUin)), Source.KDB, new ArrayList<>(Collections.singletonList(ProfileBizType.KALL)), new IDetailInfoCallback() { // from class: com.tencent.mobileqq.pushnotice.message.d
            @Override // com.tencent.qqnt.kernel.nativeinterface.IDetailInfoCallback
            public final void onResult(int i3, String str3, Source source, HashMap hashMap) {
                e.n(uidFromUin, aVar, countDownLatch, i3, str3, source, hashMap);
            }
        });
        try {
            boolean await = countDownLatch.await(5L, TimeUnit.SECONDS);
            if (aVar.f261371a == null) {
                str2 = str;
            } else {
                str2 = aVar.f261371a;
            }
            QLog.i("C2CPushHandler", 1, "[syncGetNicknameFromKernel] uin=" + str + ", uid=" + uidFromUin + ", nickname=" + str2 + ", waitSuccess=" + await + ", wait time=" + (System.currentTimeMillis() - currentTimeMillis));
            return str2;
        } catch (Exception e16) {
            QLog.w("C2CPushHandler", 1, "[syncGetNicknameFromKernel] exc=" + e16);
            return str;
        }
    }

    @Override // com.tencent.mobileqq.pushnotice.message.h
    public boolean a(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent)).booleanValue();
        }
        return "57618".equals(intent.getStringExtra("jumptype"));
    }

    @Override // com.tencent.mobileqq.pushnotice.message.h
    public boolean b(final Context context, final Intent intent, final AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, context, intent, appRuntime)).booleanValue();
        }
        final String stringExtra = intent.getStringExtra("fromuin");
        if (TextUtils.isEmpty(stringExtra)) {
            QLog.e("C2CPushHandler", 1, "fromUin is null");
            return true;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.pushnotice.message.b
            @Override // java.lang.Runnable
            public final void run() {
                e.this.m(appRuntime, stringExtra, context, intent);
            }
        }, 16, null, false);
        return false;
    }
}
