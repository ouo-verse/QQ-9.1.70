package com.tencent.mobileqq.gamecenter.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface ITempApi extends QRouteApi {
    public static final String EXTRA_KEY_TAB_INDEX = "tab_index";
    public static final int TAB_INDEX_ALL = 0;
    public static final int TAB_INDEX_PARTNER = 1;

    void addTinySessionKey(String str, String str2, byte[] bArr);

    boolean canNotDisturb();

    Intent getIntentFromMsg(Context context, Message message, AppInterface appInterface);

    Intent getIntentFromMsgNt(Context context, RecentContactInfo recentContactInfo, AppInterface appInterface, Intent intent);

    byte[] getTinySessionKey(String str, String str2);

    boolean isSplashActivity(Activity activity);

    void openGameMsgBox(Activity activity);

    void openGameMsgBox(Activity activity, int i3);

    void refreshAppBadge(AppInterface appInterface);

    void startGame(String str, String str2, String str3, Context context);

    void startGameForDistributeBtn(String str, String str2, boolean z16, Context context);

    void updateRecentList(AppInterface appInterface);
}
