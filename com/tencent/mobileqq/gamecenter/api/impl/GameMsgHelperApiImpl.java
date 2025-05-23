package com.tencent.mobileqq.gamecenter.api.impl;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.LruCache;
import androidx.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.gamecenter.msginfo.GameCenterSessionInfo;
import com.tencent.mobileqq.gamecenter.protocols.GameCenterUnissoHandler;
import com.tencent.mobileqq.gamecenter.trpcprotocol.GameMsgMgrSvr$GameDetail;
import com.tencent.mobileqq.gamecenter.trpcprotocol.GameMsgMgrSvr$GetAllGameListRsp;
import com.tencent.mobileqq.gamecenter.ui.GameMsgBoxHeaderManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes12.dex */
public class GameMsgHelperApiImpl implements IGameMsgHelperApi {
    private static final int CLICK_THRESHOLD = 800;
    public static final String MMKV_KEY_MSG_BOX_GAME_LIST = "gamecenter_msgbox_game_list";
    private static final String TAG = "GameMsgHelperApiImpl";
    private static final LruCache<String, Long> tagCache = new LruCache<>(10);
    private static volatile List<GameMsgMgrSvr$GameDetail> msgBoxGameList = null;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$notifyC2COrGroupAIODestroy$0() {
        try {
            MobileQQ.sMobileQQ.sendBroadcast(new Intent("action_qgame_aio_on_destroy"));
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
        }
    }

    private List<GameMsgMgrSvr$GameDetail> readGameListFromMMKV() {
        try {
            byte[] decodeBytes = QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations").decodeBytes(MMKV_KEY_MSG_BOX_GAME_LIST, null);
            if (decodeBytes != null && decodeBytes.length > 0) {
                GameMsgMgrSvr$GetAllGameListRsp gameMsgMgrSvr$GetAllGameListRsp = new GameMsgMgrSvr$GetAllGameListRsp();
                gameMsgMgrSvr$GetAllGameListRsp.mergeFrom(decodeBytes);
                return gameMsgMgrSvr$GetAllGameListRsp.games.get();
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "getGameListOfMsgBox e:", th5);
        }
        return null;
    }

    public static void updateGameListOfMsgBox(List<GameMsgMgrSvr$GameDetail> list) {
        if (list != null) {
            msgBoxGameList = list;
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi
    public boolean checkMesssageIsValid(MessageRecord messageRecord) {
        return com.tencent.mobileqq.gamecenter.utils.f.e(messageRecord);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi
    public com.tencent.mobileqq.gamecenter.api.e createGameMsgBoxHeaderManager(Context context) {
        return new GameMsgBoxHeaderManager(context);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi
    public Dialog createProfileGuideDailg(Context context, String str) {
        if (context == null) {
            return null;
        }
        return new com.tencent.mobileqq.gamecenter.ui.ac(context).P(str);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi
    public void delGameSession(String str) {
        com.tencent.mobileqq.gamecenter.utils.f.f(str);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi
    public void destroyGamePriorityView() {
        com.tencent.mobileqq.gamecenter.utils.i.f213440a.i();
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi
    public void enterGameMsgChatPie(AppInterface appInterface, Context context, String str, int i3) {
        com.tencent.mobileqq.gamecenter.utils.f.i(appInterface, context, str, i3);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi
    public boolean getAIOGameEntryShown(String str) {
        return com.tencent.mobileqq.gamecenter.utils.f.k(str);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi
    public List<GameMsgMgrSvr$GameDetail> getGameListOfMsgBox() {
        if (msgBoxGameList == null) {
            msgBoxGameList = readGameListFromMMKV();
            if (msgBoxGameList == null) {
                msgBoxGameList = new ArrayList();
            }
        }
        return msgBoxGameList;
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi
    public Drawable getGameMsgAvatarDrawable(AppInterface appInterface, String str) {
        return com.tencent.mobileqq.gamecenter.utils.f.p(appInterface, str);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi
    public Bitmap getGameRoleBitmap(Message message, AppInterface appInterface) {
        return com.tencent.mobileqq.gamecenter.utils.f.r(message, appInterface);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi
    public Bitmap getGameRoleBitmapNt(RecentContactInfo recentContactInfo, AppInterface appInterface) {
        return com.tencent.mobileqq.gamecenter.utils.f.s(recentContactInfo, appInterface);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi
    public String getGameRoleNickName(MessageRecord messageRecord, AppInterface appInterface) {
        return com.tencent.mobileqq.gamecenter.utils.f.t(messageRecord, appInterface);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi
    public String getGameRoleNickNameNt(RecentContactInfo recentContactInfo, AppInterface appInterface) {
        return com.tencent.mobileqq.gamecenter.utils.f.u(recentContactInfo, appInterface);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi
    public boolean getGameSessionShown(String str) {
        return com.tencent.mobileqq.gamecenter.utils.f.w(str);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi
    public URLDrawable getGameUsrDrawable(Context context, AppInterface appInterface, String str) {
        return com.tencent.mobileqq.gamecenter.utils.f.x(context, appInterface, str);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi
    public MessageRecord getLastGameMsg(AppRuntime appRuntime, String str) {
        return com.tencent.mobileqq.gamecenter.utils.f.z(appRuntime, str);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi
    public long getLastGameSessionClicked(String str) {
        return com.tencent.mobileqq.gamecenter.utils.f.A(str);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi
    public long getLastTopReqMsgTime(AppInterface appInterface) {
        return com.tencent.mobileqq.gamecenter.utils.f.B(appInterface);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi
    public CharSequence getMsgDescp(AppInterface appInterface, RecentBaseData recentBaseData, CharSequence charSequence) {
        return com.tencent.mobileqq.gamecenter.utils.f.C(appInterface, recentBaseData, charSequence);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi
    public String getMsgDescpNt(AppInterface appInterface, RecentContactInfo recentContactInfo, CharSequence charSequence) {
        return com.tencent.mobileqq.gamecenter.utils.f.E(appInterface, recentContactInfo, charSequence);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi
    public String getNetWorkTypeStr() {
        if (AppNetConnInfo.isNetSupport()) {
            if (AppNetConnInfo.isWifiConn()) {
                return "wifi";
            }
            if (AppNetConnInfo.isMobileConn()) {
                int mobileInfo = AppNetConnInfo.getMobileInfo();
                if (mobileInfo != 1) {
                    if (mobileInfo != 2) {
                        if (mobileInfo != 3) {
                            if (mobileInfo == 4) {
                                return "5G";
                            }
                            return "";
                        }
                        return "4G";
                    }
                    return "3G";
                }
                return "2G";
            }
            return "";
        }
        return "";
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi
    public Drawable getRecentGameMsgDrawable(AppInterface appInterface, String str) {
        return com.tencent.mobileqq.gamecenter.utils.f.G(appInterface, str);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi
    public String getTimeString(long j3) {
        return com.tencent.mobileqq.gamecenter.utils.f.I(j3);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi
    public String getUnreadStr(int i3) {
        return com.tencent.mobileqq.gamecenter.utils.f.J(i3);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi
    public boolean handleGameMsgRecentUserSummery(AppInterface appInterface, Message message, int i3, MsgSummary msgSummary) {
        return com.tencent.mobileqq.gamecenter.utils.f.K(appInterface, message, i3, msgSummary);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi
    public boolean isFastClick(@NonNull String str) {
        LruCache<String, Long> lruCache = tagCache;
        Long l3 = lruCache.get(str);
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        if (l3 == null) {
            lruCache.put(str, valueOf);
            return false;
        }
        if (Math.abs(valueOf.longValue() - l3.longValue()) >= 800) {
            lruCache.put(str, valueOf);
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi
    public boolean isIgnoreGameMsg(AppInterface appInterface, int i3) {
        return com.tencent.mobileqq.gamecenter.utils.f.L(appInterface, i3);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi
    public boolean isPubAccountReceiveMsg(AppInterface appInterface) {
        return com.tencent.mobileqq.gamecenter.utils.f.M(appInterface);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi
    public boolean isShowMsg(AppInterface appInterface, String str) {
        return com.tencent.mobileqq.gamecenter.utils.f.N(appInterface, str);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi
    public boolean isToday(long j3) {
        return com.tencent.mobileqq.gamecenter.utils.f.P(j3);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi
    public void notifyC2COrGroupAIODestroy() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.api.impl.ab
            @Override // java.lang.Runnable
            public final void run() {
                GameMsgHelperApiImpl.lambda$notifyC2COrGroupAIODestroy$0();
            }
        }, 16, null, false);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi
    public void openGameMsgSessionPage(Context context, GameCenterSessionInfo gameCenterSessionInfo, String str) {
        com.tencent.mobileqq.gamecenter.utils.f.S(context, gameCenterSessionInfo, str);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi
    public void openGameMsgSessionPageFromToolProcess(Context context, GameCenterSessionInfo gameCenterSessionInfo, String str, String str2) {
        com.tencent.mobileqq.gamecenter.utils.f.U(context, gameCenterSessionInfo, str, str2);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi
    public void openGameMsgSettingPage(Context context, String str) {
        com.tencent.mobileqq.gamecenter.utils.f.V(context, str);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi
    public void report(AppInterface appInterface, String str, int i3, int i16) {
        com.tencent.mobileqq.gamecenter.utils.f.Y(appInterface, str, i3, i16);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi
    public void reportClickMsgBoxEntry883(long j3) {
        com.tencent.mobileqq.gamecenter.utils.f.a0(j3);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi
    public void reportForGameMsg(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        com.tencent.mobileqq.gamecenter.utils.f.c0(str, str2, str3, str4, str5, str6, str7, str8, str9, str10);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi
    public void reportForGameMsg865WithTianJi(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13) {
        com.tencent.mobileqq.gamecenter.utils.f.i0(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi
    public void reportForGameMsgInSubThread(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        com.tencent.mobileqq.gamecenter.utils.f.j0(str, str2, str3, str4, str5, str6, str7, str8, str9, str10);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi
    public void reportForGameMsgNew(String str, String str2, String str3, String str4, String str5, String str6, String str7, Map<Integer, String> map) {
        com.tencent.mobileqq.gamecenter.utils.f.b0(str, str2, str3, str4, str5, str6, str7, map);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi
    public void requestGameListOfMsgBox() {
        GameCenterUnissoHandler.N2().s3();
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi
    public void setAIOGameEntryShown(String str, boolean z16) {
        com.tencent.mobileqq.gamecenter.utils.f.k0(str, z16);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi
    public void setGameSessionShown(String str, boolean z16) {
        com.tencent.mobileqq.gamecenter.utils.f.m0(str, z16);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi
    public void setLastCleanReqMsgTime(String str, long j3) {
        com.tencent.mobileqq.gamecenter.utils.f.n0(str, j3);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi
    public void setLastGameSessionClicked(String str, long j3) {
        com.tencent.mobileqq.gamecenter.utils.f.o0(str, j3);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi
    public void showGamePriorityView(gd1.a aVar, Activity activity, ArrayList<com.tencent.mobileqq.gamecenter.data.g> arrayList, String str, String str2) {
        com.tencent.mobileqq.gamecenter.utils.i.f213440a.j(aVar, activity, arrayList, str, str2);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi
    public void startGame(Context context, String str, gd1.a aVar) {
        com.tencent.mobileqq.gamecenter.utils.f.q0(context, str, aVar);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi
    @Deprecated
    public void enterGameMsgChatPie(Context context, String str, String str2, String str3, int i3) {
        com.tencent.mobileqq.gamecenter.utils.f.g(context, str, str2, str3, i3);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi
    public String getGameRoleNickName(String str, AppInterface appInterface) {
        return com.tencent.mobileqq.gamecenter.utils.f.v(str, appInterface);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi
    public String getMsgDescp(AppInterface appInterface, MessageRecord messageRecord, CharSequence charSequence) {
        return com.tencent.mobileqq.gamecenter.utils.f.D(appInterface, messageRecord, charSequence);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi
    public void report(int i3, int i16) {
        com.tencent.mobileqq.gamecenter.utils.f.X(i3, i16);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi
    public void reportForGameMsg(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13) {
        com.tencent.mobileqq.gamecenter.utils.f.e0(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi
    public void reportForGameMsg865WithTianJi(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        com.tencent.mobileqq.gamecenter.utils.f.h0(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi
    public void enterGameMsgChatPie(AppInterface appInterface, Context context, String str) {
        com.tencent.mobileqq.gamecenter.utils.f.h(appInterface, context, str);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi
    public void reportForGameMsg(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14) {
        com.tencent.mobileqq.gamecenter.utils.f.f0(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi
    public void reportForGameMsg(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12) {
        com.tencent.mobileqq.gamecenter.utils.f.d0(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi
    public void reportForGameMsg(String str, String str2, String str3, String str4, String str5, String str6, String str7, HashMap<String, String> hashMap) {
        com.tencent.mobileqq.gamecenter.utils.f.Z(str, str2, str3, str4, str5, str6, str7, hashMap);
    }
}
