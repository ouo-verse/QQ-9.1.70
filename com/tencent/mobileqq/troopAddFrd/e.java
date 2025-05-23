package com.tencent.mobileqq.troopAddFrd;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ax;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes19.dex */
public class e extends ax {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: protected */
    public e(BaseQQAppInterface baseQQAppInterface, Context context) {
        super(baseQQAppInterface, context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseQQAppInterface, (Object) context);
        }
    }

    private void F(HashMap<String, String> hashMap) {
        int i3;
        String str = hashMap.get("uin");
        String str2 = hashMap.get("troop_uin");
        if (hashMap.get("type") != null) {
            String str3 = hashMap.get("type");
            Objects.requireNonNull(str3);
            i3 = Integer.parseInt(str3);
        } else {
            i3 = 5193;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).launchAddFriend(this.f307437b, ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).startAddFriend(this.f307437b, 1, str, str2, 3004, d.t(i3), null, null, null, null, null));
        } else {
            QLog.w("TroopAddFriendJumpAction", 1, "[jumpTroopAddFriendCheckPage] failed. recommendUin or troopUin is empty");
        }
    }

    private void G(HashMap<String, String> hashMap) {
        String str;
        boolean z16;
        String str2;
        String str3;
        String str4;
        if (hashMap != null && hashMap.size() != 0) {
            String str5 = hashMap.get("uin");
            if (TextUtils.isEmpty(str5)) {
                QLog.e("TroopAddFriendJumpAction", 1, "jumpTroopAddFriendListPage fail, recommendUin is null");
                return;
            }
            String str6 = hashMap.get("troop_uin");
            String str7 = hashMap.get(AppConstants.Key.TROOP_CODE);
            if (TextUtils.isEmpty(str6) && TextUtils.isEmpty(str7)) {
                QLog.e("TroopAddFriendJumpAction", 1, "jumpTroopAddFriendListPage fail, troopId is null");
                return;
            }
            if (hashMap.get("strategy_id") == null) {
                str = "";
            } else {
                str = hashMap.get("strategy_id");
            }
            String str8 = str;
            if (hashMap.get("is_local") != null && "1".equals(hashMap.get("is_local"))) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16 && !TextUtils.isEmpty(str7) && !str7.equals(str6)) {
                QLog.i("TroopAddFriendJumpAction", 1, "jumpTroopAddFriendListPage. troopCode != troopUin. troopCode: " + str7 + ", troopUin: " + str6);
                str2 = str7;
            } else {
                str2 = str6;
            }
            Context context = this.f307437b;
            if (TextUtils.isEmpty(str7)) {
                str3 = str2;
            } else {
                str3 = str7;
            }
            if (TextUtils.isEmpty(str2)) {
                str4 = str7;
            } else {
                str4 = str2;
            }
            com.tencent.mobileqq.relationx.batchAdd.b.g(context, 6, str3, str4, str5, str8);
            g.a(this.f307436a, str5, str2, str8);
            return;
        }
        QLog.e("TroopAddFriendJumpAction", 1, "jumpTroopAddFriendListPage fail, empty params");
    }

    @Override // com.tencent.mobileqq.utils.ax
    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        QLog.i("TroopAddFriendJumpAction", 1, "doAction: action=" + this.f307440e);
        if ("graytip_addfriend".equals(this.f307440e)) {
            G(this.f307441f);
        } else if ("graytip_friendcheck".equals(this.f307440e)) {
            F(this.f307441f);
        }
        return true;
    }
}
