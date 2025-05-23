package com.tencent.mobileqq.qcircle.tempapi.api.impl;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qcircle.tempapi.api.IQCircleChatUtilApi;
import com.tencent.mobileqq.qcircle.tempapi.api.impl.QCircleChatUtilApiImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.utils.aq;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.helper.bh;
import com.tencent.qqnt.aio.helper.cw;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import mqq.app.MobileQQ;
import p61.a;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QCircleChatUtilApiImpl implements IQCircleChatUtilApi {
    private static final String QCIRCLE_GET_QQ_GROUP_NUMBER = "QCIRCLE_GET_QQ_GROUP_NUMBER";
    private static final String TAG = "QCircleChatUtilApiImpl";

    private int getQQGroupDetailSubIdFrom(String str) {
        if (TextUtils.equals("feed", str)) {
            return 50002;
        }
        return 50001;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$preQQGroupInfoForJoin$0(IQCircleChatUtilApi.QQGroupCallBack qQGroupCallBack, long j3, List list, Boolean bool, TroopInfo troopInfo) {
        if (troopInfo.wMemberMax > troopInfo.wMemberNum) {
            qQGroupCallBack.canJoinGroup(j3);
            return null;
        }
        preQQGroupInfoForJoin(list.subList(1, list.size()), qQGroupCallBack);
        return null;
    }

    @Override // com.tencent.mobileqq.qcircle.tempapi.api.IQCircleChatUtilApi
    public void enterChatWin(Context context, String str, int i3, String str2, long j3) {
        Bundle bundle = new Bundle();
        bundle.putString("KEY_OPEN_AIO_INTENT_CLASS_NAME", ChatActivity.class.getName());
        if (j3 > 0) {
            bundle.putBoolean("need_jump_to_msg", true);
            bundle.putLong(AppConstants.Key.KEY_SEARCHED_TIMEORSEQ, j3);
        }
        bundle.putString("key_from", "40");
        RecentUtil.t(context, (QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime(), str, i3, str2, false, bundle);
    }

    @Override // com.tencent.mobileqq.qcircle.tempapi.api.IQCircleChatUtilApi
    public void enterQQGroupDetail(Context context, String str, String str2, String str3) {
        Bundle d16 = aq.d(str, str2, getQQGroupDetailSubIdFrom(str3));
        d16.putInt("exposureSource", 3);
        d16.putInt(AppConstants.Key.TROOP_INFO_FROM_EX, getQQGroupDetailSubIdFrom(str3));
        TroopUtils.I(context, d16, 2);
    }

    @Override // com.tencent.mobileqq.qcircle.tempapi.api.IQCircleChatUtilApi
    public List<String> getChatNoLimitWhiteList() {
        return a.a();
    }

    @Override // com.tencent.mobileqq.qcircle.tempapi.api.IQCircleChatUtilApi
    public h getIceBreakHelper() {
        return new bh();
    }

    @Override // com.tencent.mobileqq.qcircle.tempapi.api.IQCircleChatUtilApi
    public String getMaxUnReadCountText(int i3) {
        return a.b(i3);
    }

    @Override // com.tencent.mobileqq.qcircle.tempapi.api.IQCircleChatUtilApi
    public String getQCircleChatGetUidErrMsgKey() {
        return "qcircle_chat_get_uid_err_msg";
    }

    @Override // com.tencent.mobileqq.qcircle.tempapi.api.IQCircleChatUtilApi
    public String getQCircleFromPersonalPageKey() {
        return "qcircle_chat_from_personal_page";
    }

    @Override // com.tencent.mobileqq.qcircle.tempapi.api.IQCircleChatUtilApi
    public int getQCircleHelperId() {
        return cw.f350650l0;
    }

    @Override // com.tencent.mobileqq.qcircle.tempapi.api.IQCircleChatUtilApi
    public boolean isInQQGroup(String str) {
        QQAppInterface qQAppInterface;
        if (MobileQQ.sProcessId != 1 || (qQAppInterface = (QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime()) == null) {
            return false;
        }
        if (((ITroopInfoService) qQAppInterface.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(str) != null) {
            return true;
        }
        QLog.d(TAG, 1, "user is not in QQGroup, groupID: " + str);
        return false;
    }

    @Override // com.tencent.mobileqq.qcircle.tempapi.api.IQCircleChatUtilApi
    public boolean isQCircleChatType(int i3) {
        return a.f(i3);
    }

    @Override // com.tencent.mobileqq.qcircle.tempapi.api.IQCircleChatUtilApi
    public void preQQGroupInfoForJoin(final List<Long> list, final IQCircleChatUtilApi.QQGroupCallBack qQGroupCallBack) {
        if (((QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime()) != null && list != null && list.size() > 0) {
            final long longValue = list.get(0).longValue();
            if (longValue == 0) {
                preQQGroupInfoForJoin(list.subList(1, list.size()), qQGroupCallBack);
            } else {
                ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).fetchTroopMemberNumForJoin(String.valueOf(longValue), TAG, null, new Function2() { // from class: ce2.a
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Unit lambda$preQQGroupInfoForJoin$0;
                        lambda$preQQGroupInfoForJoin$0 = QCircleChatUtilApiImpl.this.lambda$preQQGroupInfoForJoin$0(qQGroupCallBack, longValue, list, (Boolean) obj, (TroopInfo) obj2);
                        return lambda$preQQGroupInfoForJoin$0;
                    }
                });
            }
        }
    }

    @Override // com.tencent.mobileqq.qcircle.tempapi.api.IQCircleChatUtilApi
    public String qcircleChatHideMenuKey() {
        return "qcircle_chat_hide_menu_key";
    }

    @Override // com.tencent.mobileqq.qcircle.tempapi.api.IQCircleChatUtilApi
    public String qcirlceChatGiftInfoBytesKey() {
        return "qcirlce_chat_gift_info_bytes_key";
    }

    @Override // com.tencent.mobileqq.qcircle.tempapi.api.IQCircleChatUtilApi
    public String qcirlceChatShowFuelTipsKey() {
        return "qcircle_chat_show_fuel_tips_key";
    }

    @Override // com.tencent.mobileqq.qcircle.tempapi.api.IQCircleChatUtilApi
    public void saveChatNoLimitWhiteList(List<String> list) {
        a.h(list);
    }
}
