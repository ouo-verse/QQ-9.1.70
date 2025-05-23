package com.tencent.mobileqq.vas.inject;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.vas.api.IVasRecentData;
import com.tencent.mobileqq.vas.image.j;
import com.tencent.mobileqq.vas.manager.api.IGXHManager;
import com.tencent.mobileqq.vip.api.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public interface IVasInject {

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface ActionResult {
        void onCancel();

        void onConfirm();
    }

    boolean containsKeyword(String str, String str2);

    boolean darkModeUserSetThemeAction(Activity activity, String str, ActionResult actionResult);

    void forceUpdateVasUserData(int i3);

    String getChatBackgroundId(String str);

    IVasRecentData.FriendsVipData getVipIconInfo(Card card);

    boolean isApngSoLoaded();

    boolean isShowColorName();

    boolean isShowGameIcon();

    boolean isShowTroopLiang();

    boolean isShowTroopVipIcon();

    boolean isShowVipIconForSimpleMode();

    void itemLyPay(String str, String str2, int i3, int i16, String str3, Activity activity, k kVar);

    void itemLyPay(String str, String str2, String str3, Activity activity, k kVar);

    void loadApngSo(j.a aVar);

    View.OnClickListener newClickListener(String str, String str2);

    void openUrl(Activity activity, String str);

    void preloadKuiklyBundle(String str, String str2);

    void publicAccountTianshuReport(int i3, int i16, String str, String str2);

    void quickSwitchDefaultMode(Function1<JSONObject, Unit> function1);

    void requestCheckLoveState(String str);

    void setShowColorName(boolean z16);

    void setShowTroopLiang(boolean z16);

    void setShowTroopVipIcon(Context context, boolean z16);

    void setShowVipIconForSimpleMode(boolean z16);

    void startForwardFriendListActivity(Activity activity, IGXHManager.FriendSelectParams friendSelectParams);

    JSONObject wallpaperSetChatBg(Activity activity, String str);
}
