package com.tencent.mobileqq.profilesetting.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilesetting.ReqSetSettingItem;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.ArrayList;

@QAPI(process = {""})
/* loaded from: classes16.dex */
public interface IProfileSettingApi extends QRouteApi {
    public static final int ALL_NOT_VISIBLE_STATE = 2;
    public static final int FIELD_PRIVACY_CONSTELLATION = 41609;
    public static final int INVALID_STATE = -1;

    int getProfileDisplaySettingStateFromCard(int i3, Card card, AppInterface appInterface);

    int getProfileSettingStateFromCard(int i3, Card card);

    boolean reqGetCardDisplaySetting(AppInterface appInterface, ArrayList<Integer> arrayList);

    void requestProfileSettingState(AppInterface appInterface, ArrayList<Integer> arrayList);

    void requestSetCardDisplaySetting(AppInterface appInterface, ArrayList<ReqSetSettingItem> arrayList);
}
