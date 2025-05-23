package com.tencent.mobileqq.pushnotice.message;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.data.troop.TroopMemberNickInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes16.dex */
public class g extends a {
    static IPatchRedirector $redirector_;

    public g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private Intent g(String str, String str2, String str3) {
        Intent d16 = d();
        d16.putExtra("uin", str);
        d16.putExtra("uintype", 1000);
        d16.putExtra("uinname", str3);
        if (!TextUtils.isEmpty(str2)) {
            d16.putExtra("troop_uin", str2);
        }
        return d16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit h(String str, String str2, Context context, Intent intent, AppRuntime appRuntime, TroopMemberNickInfo troopMemberNickInfo) {
        String str3;
        if (troopMemberNickInfo != null) {
            str3 = troopMemberNickInfo.getShowName();
        } else {
            str3 = str;
        }
        e(context, g(str, str2, str3));
        c(intent, appRuntime);
        return null;
    }

    @Override // com.tencent.mobileqq.pushnotice.message.h
    public boolean a(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent)).booleanValue();
        }
        return "57620".equals(intent.getStringExtra("jumptype"));
    }

    @Override // com.tencent.mobileqq.pushnotice.message.h
    public boolean b(final Context context, final Intent intent, final AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, context, intent, appRuntime)).booleanValue();
        }
        final String stringExtra = intent.getStringExtra("fromuin");
        final String stringExtra2 = intent.getStringExtra("groupuin");
        if (TextUtils.isEmpty(stringExtra)) {
            QLog.e("GroupMemberStrangePushHandler", 1, "fromUin is null");
            return true;
        }
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("offline_push_require_group_uin_8983_112950972", false) && TextUtils.isEmpty(stringExtra2)) {
            QLog.w("GroupMemberStrangePushHandler", 1, "troop uin is empty");
            return true;
        }
        QLog.i("GroupMemberStrangePushHandler", 2, "doAction from=" + stringExtra + "\uff0ctroop=" + stringExtra2);
        ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberName(stringExtra2, stringExtra, "GroupMemberStrangePushHandler", new Function1() { // from class: com.tencent.mobileqq.pushnotice.message.f
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit h16;
                h16 = g.this.h(stringExtra, stringExtra2, context, intent, appRuntime, (TroopMemberNickInfo) obj);
                return h16;
            }
        });
        return false;
    }
}
