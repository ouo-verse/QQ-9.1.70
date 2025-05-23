package com.tencent.mobileqq.qqgamepub.api;

import Wallet.AcsMsg;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qqgamepub.data.GmpEnterInfoRsp;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.util.Pair;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IQQGameHelper extends QRouteApi {

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface a {
        void onGetMsgInfo(JSONArray jSONArray);
    }

    Pair<String, JSONObject> addQQGameArkField(String str, String str2, String str3, JSONObject jSONObject) throws JSONException;

    void dispatchVideoEvent(int i3);

    void enterAIO(Activity activity);

    void enterAIO(Activity activity, boolean z16);

    void enterGameCenter(String str);

    void findGameMallRecentMessage(int i3, a aVar);

    ActivityURIRequest getAIOURIRequest(Context context);

    String getAccount();

    long getClickAioTime();

    List<QQGameMsgInfo> getCurrentMsgList();

    com.tencent.mobileqq.qqgamepub.view.a getGameArkView(Activity activity);

    String getGameMallPeerUid();

    long getGamePubLastReadTime();

    String getGamePubPeerUid();

    com.tencent.mobileqq.qqgamepub.view.a getMoreMsgHeaderView(Activity activity);

    QIPCModule getQQGameIPCModule();

    String getQQGameIPCModuleName();

    @Deprecated
    int getRedDotUnreadCount();

    int getUnreadCount();

    void initClickAioTime();

    boolean isFollowPubAccount();

    boolean isInValidGameAppId(String str);

    boolean isNewPubStyle(Context context, String str);

    boolean isQQGamePubAccount(String str);

    void preDownloadDirectJumpRes(JSONObject jSONObject);

    void publicAccountTianshuReport(int i3, QQGameMsgInfo qQGameMsgInfo, int i16);

    void reportAioListItemClick(String str, String str2, int i3, String str3, MsgRecord msgRecord);

    void reportAioListItemExposure(String str, int i3, MsgRecord msgRecord);

    void reportNoticeToDc87(int i3, AcsMsg acsMsg);

    void reportNoticeToDc87(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8);

    void reportWangzheRedpacketEggs(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8);

    void showGameEnterCacheInfo(View view, GmpEnterInfoRsp gmpEnterInfoRsp);

    void startGameCenterActivity(Context context, String str);

    boolean startGameMallPubAccount(Context context, int i3);

    void startQQGamePubAccount(Context context, int i3);

    void startQQGamePubAccount(Context context, int i3, HashMap<String, String> hashMap);

    void startQQGamePubFromRecent(Context context, int i3);
}
