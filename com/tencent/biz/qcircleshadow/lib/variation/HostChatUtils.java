package com.tencent.biz.qcircleshadow.lib.variation;

import android.content.Context;
import com.tencent.mobileqq.qcircle.tempapi.api.IQCircleChatUtilApi;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class HostChatUtils {
    public static String QCIRCLE_CHAT_GET_UID_ERR_MSG_KEY() {
        return ((IQCircleChatUtilApi) QRoute.api(IQCircleChatUtilApi.class)).getQCircleChatGetUidErrMsgKey();
    }

    public static String QCIRCLE_CHAT_HIDE_MENU_KEY() {
        return ((IQCircleChatUtilApi) QRoute.api(IQCircleChatUtilApi.class)).qcircleChatHideMenuKey();
    }

    public static String QCIRLCE_CHAT_GIFT_INFO_BYTES_KEY() {
        return ((IQCircleChatUtilApi) QRoute.api(IQCircleChatUtilApi.class)).qcirlceChatGiftInfoBytesKey();
    }

    public static String QCIRLCE_CHAT_SHOW_FUEL_TIPS_KEY() {
        return ((IQCircleChatUtilApi) QRoute.api(IQCircleChatUtilApi.class)).qcirlceChatShowFuelTipsKey();
    }

    public static void enterChatWin(Context context, String str, int i3, String str2) {
        enterChatWin(context, str, i3, str2, -1L);
    }

    public static void enterQQGroupDetail(Context context, String str, String str2, String str3) {
        ((IQCircleChatUtilApi) QRoute.api(IQCircleChatUtilApi.class)).enterQQGroupDetail(context, str, str2, str3);
    }

    public static List<String> getChatNoLimitWhiteList() {
        return ((IQCircleChatUtilApi) QRoute.api(IQCircleChatUtilApi.class)).getChatNoLimitWhiteList();
    }

    public static String getMaxUnReadCountText(int i3) {
        return ((IQCircleChatUtilApi) QRoute.api(IQCircleChatUtilApi.class)).getMaxUnReadCountText(i3);
    }

    public static String getQCircleFromPersonalPageKey() {
        return ((IQCircleChatUtilApi) QRoute.api(IQCircleChatUtilApi.class)).getQCircleFromPersonalPageKey();
    }

    public static int getQCircleHelperId() {
        return ((IQCircleChatUtilApi) QRoute.api(IQCircleChatUtilApi.class)).getQCircleHelperId();
    }

    public static boolean isQCircleChatType(int i3) {
        return ((IQCircleChatUtilApi) QRoute.api(IQCircleChatUtilApi.class)).isQCircleChatType(i3);
    }

    public static void saveChatNoLimitWhiteList(List<String> list) {
        ((IQCircleChatUtilApi) QRoute.api(IQCircleChatUtilApi.class)).saveChatNoLimitWhiteList(list);
    }

    public static void enterChatWin(Context context, String str, int i3, String str2, long j3) {
        ((IQCircleChatUtilApi) QRoute.api(IQCircleChatUtilApi.class)).enterChatWin(context, str, i3, str2, j3);
    }
}
