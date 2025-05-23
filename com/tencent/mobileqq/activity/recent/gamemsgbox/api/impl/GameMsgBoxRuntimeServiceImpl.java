package com.tencent.mobileqq.activity.recent.gamemsgbox.api.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxManager;
import com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxRuntimeService;
import com.tencent.mobileqq.activity.recent.gamemsgbox.data.a;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.gamecenter.message.TinyInfo;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.util.cl;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class GameMsgBoxRuntimeServiceImpl implements IGameMsgBoxRuntimeService {
    static IPatchRedirector $redirector_ = null;
    private static final String DELETE_SP_KEY = "delete_";
    public static final String TAG = "GameMsgBoxRuntimeServiceImpl";
    public static final AtomicBoolean dataReady;
    private static final Map<String, Boolean> sMigrateCache;
    public final int AUTHORIZE_MAX_TIME;
    private final String SP_GAME_MSG_READ;
    private final String SP_KEY_GAME_MSG_READ;
    private final String SP_KEY_TIME_SET;
    private long enterGameBoxTs;
    private String enterGameMsgAIOAppId;
    private AtomicBoolean isRead;
    private AppRuntime mAppRuntime;
    private View mElementView;
    IConversationFacade mIConversationFacade;
    private LinearLayout mPageView;
    private SharedPreferences mSharedPreferences;
    private Set<String> timeSet;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20731);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
        } else {
            dataReady = new AtomicBoolean(false);
            sMigrateCache = new ConcurrentHashMap();
        }
    }

    public GameMsgBoxRuntimeServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.SP_GAME_MSG_READ = "sp_game_msg_read";
        this.SP_KEY_GAME_MSG_READ = "sp_key_game_msg_read";
        this.SP_KEY_TIME_SET = "sp_key_game_time_set";
        this.AUTHORIZE_MAX_TIME = 1;
        this.isRead = new AtomicBoolean(true);
        this.timeSet = new HashSet();
    }

    public static boolean isToday(long j3) {
        if (((int) ((System.currentTimeMillis() - j3) / 86400000)) == 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxRuntimeService
    public synchronized void addAuthorizeShow(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            return;
        }
        if (this.timeSet.contains(str)) {
            QLog.d(TAG, 1, "addAuth but exist");
            return;
        }
        boolean isToday = isToday(getLastAuthTime().longValue() * 1000);
        if (QLog.isColorLevel()) {
            Object[] objArr = new Object[4];
            boolean z16 = false;
            objArr[0] = "addAuthShow: ";
            if (!isToday && this.timeSet.size() < 1) {
                z16 = true;
            }
            objArr[1] = Boolean.valueOf(z16);
            objArr[2] = " times is: ";
            objArr[3] = str;
            QLog.d(TAG, 1, objArr);
        }
        if (!isToday && this.timeSet.size() < 1) {
            this.timeSet.add(String.valueOf(str));
            this.mSharedPreferences.edit().putStringSet("sp_key_game_time_set" + this.mAppRuntime.getAccount(), this.timeSet).apply();
        }
    }

    @Override // com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxRuntimeService
    public void buildGameBoxAuthSummary(JSONObject jSONObject) {
        MqqHandler mqqHandler;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) jSONObject);
            return;
        }
        if (this.mAppRuntime == null) {
            return;
        }
        a.b(jSONObject);
        a a16 = a.a();
        if (!((IGameMsgBoxManager) this.mAppRuntime.getRuntimeService(IGameMsgBoxManager.class, "")).isGameInGameBox(a16.appid)) {
            return;
        }
        String str = AppConstants.GAME_MSG_BOX_UIN;
        RecentUser recentUser = new RecentUser(str.concat("_").concat(this.mAppRuntime.getCurrentUin()), 10007);
        recentUser.lastmsgtime = a16.time;
        recentUser.msgType = 10007;
        recentUser.isHiddenChat = 1;
        a16.f185504a = recentUser;
        MessageRecord messageRecord = new MessageRecord();
        messageRecord.time = a16.time;
        messageRecord.f203106msg = a16.summary;
        messageRecord.frienduin = str.concat("_").concat(this.mAppRuntime.getCurrentUin());
        messageRecord.msgtype = 10007;
        if (messageRecord.mExJsonObject == null) {
            messageRecord.mExJsonObject = new JSONObject();
        }
        try {
            messageRecord.mExJsonObject.put(IGameMsgBoxRuntimeService.MR_EXT_SHOW_TIME, String.valueOf(a16.time));
        } catch (JSONException e16) {
            QLog.e(TAG, 1, "Json put err!", e16);
        }
        a16.f185505b = messageRecord;
        try {
            AppInterface appInterface = (AppInterface) this.mAppRuntime;
            String str2 = Conversation.TAG;
            mqqHandler = appInterface.getHandler(Conversation.class);
        } catch (ClassNotFoundException unused) {
            QLog.d(TAG, 1, "refresh box err");
            mqqHandler = null;
        }
        if (mqqHandler != null) {
            mqqHandler.sendEmptyMessage(1014);
        }
    }

    @Override // com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxRuntimeService
    public boolean getDataReady() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return dataReady.get();
    }

    @Override // com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxRuntimeService
    public String getEnterGameMsgAIOAppId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.enterGameMsgAIOAppId;
    }

    @Override // com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxRuntimeService
    public String getGameAppIdFromMessage(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this, (Object) messageRecord);
        }
        try {
            return new JSONObject(messageRecord.getExtInfoFromExtStr(TinyInfo.EXT_KEY_GAME_MSG_INFO)).optString(TinyInfo.KEY_GAME_APP_ID);
        } catch (JSONException e16) {
            QLog.e(TAG, 1, "parse js err! ", e16);
            return "";
        }
    }

    @Override // com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxRuntimeService
    public synchronized Long getLastAuthTime() {
        long parseLong;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Long) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        String str = null;
        for (String str2 : this.timeSet) {
            if (str == null || Long.parseLong(str) < Long.parseLong(str2)) {
                str = str2;
            }
        }
        if (str == null) {
            parseLong = 0;
        } else {
            parseLong = Long.parseLong(str);
        }
        return Long.valueOf(parseLong);
    }

    @Override // com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxRuntimeService
    public synchronized boolean isAuthorizeShow(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str)).booleanValue();
        }
        boolean z16 = true;
        if (this.timeSet.contains(str)) {
            return true;
        }
        if (this.timeSet.size() >= 1 || Long.parseLong(str) <= getLastAuthTime().longValue() || isToday(getLastAuthTime().longValue() * 1000)) {
            z16 = false;
        }
        return z16;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
            return;
        }
        this.mAppRuntime = appRuntime;
        SharedPreferences sharedPreferences = appRuntime.getApplication().getSharedPreferences("sp_game_msg_read", 0);
        this.mSharedPreferences = sharedPreferences;
        this.isRead.set(sharedPreferences.getBoolean("sp_key_game_msg_read" + this.mAppRuntime.getAccount(), false));
        this.mIConversationFacade = (IConversationFacade) appRuntime.getRuntimeService(IConversationFacade.class, "");
        this.timeSet = this.mSharedPreferences.getStringSet("sp_key_game_time_set" + this.mAppRuntime.getAccount(), this.timeSet);
        this.mPageView = new LinearLayout(appRuntime.getApp());
        View view = new View(appRuntime.getApp());
        this.mElementView = view;
        this.mPageView.addView(view);
        this.enterGameBoxTs = 0L;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.enterGameMsgAIOAppId = null;
        }
    }

    @Override // com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxRuntimeService
    public void setEnterGameMsgAIOAppId(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        } else {
            this.enterGameMsgAIOAppId = str;
        }
    }

    @Override // com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxRuntimeService
    public void setShouldShowNewUnAuthorizedSummary(boolean z16, Context context) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), context);
            return;
        }
        String concat = "new_summary".concat(this.mAppRuntime.getCurrentUin());
        if (z16) {
            str = "1";
        } else {
            str = "0";
        }
        cl.k(context, TAG, concat, str);
    }

    @Override // com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxRuntimeService
    public boolean shouldFilterUnintendedMultiClicks() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = (currentTimeMillis - this.enterGameBoxTs) / 1000;
        this.enterGameBoxTs = currentTimeMillis;
        if (j3 < 1) {
            return true;
        }
        return false;
    }
}
