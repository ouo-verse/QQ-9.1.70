package com.tencent.mobileqq.activity.troop.config;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.friend.api.IFriendNameService;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.aw;
import com.tencent.mobileqq.utils.ac;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MemberExtInfo;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes10.dex */
public class p extends com.tencent.mobileqq.troop.api.config.m {
    static IPatchRedirector $redirector_;

    public p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void b(@NonNull AppInterface appInterface, @NonNull Bundle bundle, @NonNull Map<String, String> map, MemberExtInfo memberExtInfo) {
        String nickName;
        StringBuffer stringBuffer = new StringBuffer();
        long longValue = Long.valueOf(bundle.getString("troopUin")).longValue();
        String valueOf = String.valueOf(memberExtInfo.getUin());
        if (QLog.isColorLevel()) {
            stringBuffer.append(" uin=");
            stringBuffer.append(valueOf.substring(0, 4));
        }
        boolean z16 = bundle.getBoolean("force_nick_by_multi_forward", false);
        String strName = memberExtInfo.getStrName();
        String str = "";
        if (!z16 && strName != null && strName.length() > 0) {
            int i3 = bundle.getInt(ac.f307393c, ac.f307394d);
            long j3 = bundle.getLong(ac.f307397g, 0L);
            if (i3 == ac.f307395e) {
                MessageRecord P = ((QQAppInterface) appInterface).getMessageFacade().P(longValue + "", 1, j3);
                if (P instanceof MessageForUniteGrayTip) {
                    ((MessageForUniteGrayTip) P).updateUniteGrayTipMsg(appInterface, "".concat(BaseApplicationImpl.getApplication().getString(R.string.cdg)));
                }
            }
            nickName = com.tencent.mobileqq.vas.f.o(strName);
            if (QLog.isColorLevel()) {
                stringBuffer.append(" troopCard=");
                stringBuffer.append(aw.a(nickName));
                stringBuffer.append(LogTag.TAG_TROOP_REVOKED_MSG_GET_TROOP_MEM_CARD);
                stringBuffer.append("|extraUpdateTarget:");
                stringBuffer.append(i3);
                stringBuffer.append("|uniseq:");
                stringBuffer.append(j3);
            }
        } else {
            boolean z17 = bundle.getBoolean("needRemark", false);
            boolean isFriend = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(valueOf), "TroopMemberInfoProcessor");
            if (!z16 && TextUtils.isEmpty("") && z17 && isFriend) {
                str = ((IFriendNameService) appInterface.getRuntimeService(IFriendNameService.class, "")).getFriendName(valueOf, false);
            }
            nickName = memberExtInfo.getNickName();
            if (!TextUtils.isEmpty(nickName) && TextUtils.isEmpty(str)) {
                if (QLog.isColorLevel()) {
                    stringBuffer.append(" nick=");
                    stringBuffer.append(aw.a(nickName));
                }
            } else {
                nickName = str;
            }
        }
        if (TextUtils.isEmpty(nickName)) {
            if (QLog.isColorLevel()) {
                stringBuffer.append(" empty here");
            }
            if (z16) {
                nickName = BaseApplicationImpl.getApplication().getString(R.string.zya);
            } else {
                nickName = "  ";
            }
        }
        map.put(valueOf, nickName);
        if (QLog.isColorLevel()) {
            QLog.d("TroopMemberInfoProcessor", 2, stringBuffer.toString());
        }
    }

    @Override // com.tencent.mobileqq.troop.api.config.m
    public void a(@NonNull AppInterface appInterface, @NonNull Bundle bundle, @NonNull Map<String, String> map, List<MemberExtInfo> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, appInterface, bundle, map, list);
        } else {
            if (list == null) {
                return;
            }
            Iterator<MemberExtInfo> it = list.iterator();
            while (it.hasNext()) {
                b(appInterface, bundle, map, it.next());
            }
        }
    }
}
