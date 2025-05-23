package com.tencent.mobileqq.gamecenter.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.kernel.nativeinterface.TempChatGameSession;
import java.util.HashMap;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IGameCenterCommonApi extends QRouteApi {
    void checkNewConfiguredUrl(String str, String str2, i iVar);

    boolean handleGameActScheme(HashMap<String, String> hashMap, Context context);

    boolean isApplyPartnerBox(com.tencent.qqnt.chats.core.adapter.itemdata.g gVar);

    boolean isApplyPartnerContact(com.tencent.qqnt.chats.core.adapter.itemdata.g gVar);

    boolean isApplyPartnerContact(TempChatGameSession tempChatGameSession);

    boolean isGamePartnerContact(com.tencent.qqnt.chats.core.adapter.itemdata.g gVar);

    boolean isGamePartnerContact(TempChatGameSession tempChatGameSession);

    boolean isWangZheContact(com.tencent.qqnt.chats.core.adapter.itemdata.g gVar);

    void saveActUrl(String str, String str2, long j3);
}
