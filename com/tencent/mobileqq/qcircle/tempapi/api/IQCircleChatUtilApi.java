package com.tencent.mobileqq.qcircle.tempapi.api;

import android.content.Context;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IQCircleChatUtilApi extends QRouteApi {

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface QQGroupCallBack {
        void canJoinGroup(long j3);
    }

    void enterChatWin(Context context, String str, int i3, String str2, long j3);

    void enterQQGroupDetail(Context context, String str, String str2, String str3);

    List<String> getChatNoLimitWhiteList();

    h getIceBreakHelper();

    String getMaxUnReadCountText(int i3);

    String getQCircleChatGetUidErrMsgKey();

    String getQCircleFromPersonalPageKey();

    int getQCircleHelperId();

    boolean isInQQGroup(String str);

    boolean isQCircleChatType(int i3);

    void preQQGroupInfoForJoin(List<Long> list, QQGroupCallBack qQGroupCallBack);

    String qcircleChatHideMenuKey();

    String qcirlceChatGiftInfoBytesKey();

    String qcirlceChatShowFuelTipsKey();

    void saveChatNoLimitWhiteList(List<String> list);
}
