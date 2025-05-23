package com.tencent.mobileqq.activity.recent.gamemsgbox.manager;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.gamecenter.message.TinyInfo;
import com.tencent.mobileqq.gamecenter.msginfo.GameCenterSessionInfo;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class b extends com.tencent.mobileqq.activity.recent.gamemsgbox.manager.a implements Observer {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.mobileqq.activity.recent.gamemsgbox.repo.a f185539f;

    /* renamed from: h, reason: collision with root package name */
    private volatile boolean f185540h;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.activity.recent.gamemsgbox.manager.b$b, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C7202b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static b f185541a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21552);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f185541a = new b(null);
            }
        }
    }

    /* synthetic */ b(a aVar) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 15)) {
            return;
        }
        iPatchRedirector.redirect((short) 15, (Object) this, (Object) aVar);
    }

    private MessageRecord d(Object obj) {
        if (!(obj instanceof MessageRecord)) {
            return null;
        }
        MessageRecord messageRecord = (MessageRecord) obj;
        if (messageRecord.istroop != 10007) {
            return null;
        }
        return messageRecord;
    }

    private GameCenterSessionInfo e(MessageRecord messageRecord, String str) {
        QLog.d("GameMsgSessionInfoManager", 2, "[createSessionInfo] create new sessionInfo." + messageRecord);
        GameCenterSessionInfo gameCenterSessionInfo = new GameCenterSessionInfo();
        gameCenterSessionInfo.j0(messageRecord.frienduin);
        String str2 = "";
        Message firstUnreadMessage = ((IMessageFacade) this.f185537d.getRuntimeService(IMessageFacade.class, "")).getFirstUnreadMessage(messageRecord.frienduin, messageRecord.istroop);
        if (firstUnreadMessage != null) {
            if (!TextUtils.isEmpty(firstUnreadMessage.emoRecentMsg)) {
                str2 = firstUnreadMessage.emoRecentMsg.toString();
            }
            gameCenterSessionInfo.E(str2);
            gameCenterSessionInfo.F(firstUnreadMessage.time);
        }
        gameCenterSessionInfo.i0(str);
        gameCenterSessionInfo.N(h(messageRecord));
        gd1.a e16 = d.f().e(str);
        if (e16 != null) {
            t(gameCenterSessionInfo, e16);
        }
        return gameCenterSessionInfo;
    }

    private GameCenterSessionInfo f(RecentUser recentUser, String str, String str2) {
        GameCenterSessionInfo gameCenterSessionInfo = new GameCenterSessionInfo();
        if (recentUser != null && this.f185537d != null) {
            QLog.i("GameMsgSessionInfoManager", 1, "[createSessionInfo] info:" + recentUser.toString());
            IMessageFacade iMessageFacade = (IMessageFacade) this.f185537d.getRuntimeService(IMessageFacade.class, "");
            Message lastMessage = iMessageFacade.getLastMessage(recentUser.uin, recentUser.getType());
            if (lastMessage != null) {
                CharSequence charSequence = lastMessage.emoRecentMsg;
                if (!TextUtils.isEmpty(charSequence)) {
                    gameCenterSessionInfo.Z(charSequence.toString());
                }
                gameCenterSessionInfo.a0(lastMessage.time);
            }
            Message firstUnreadMessage = iMessageFacade.getFirstUnreadMessage(recentUser.uin, recentUser.getType());
            if (firstUnreadMessage != null) {
                CharSequence charSequence2 = firstUnreadMessage.emoRecentMsg;
                if (!TextUtils.isEmpty(charSequence2)) {
                    gameCenterSessionInfo.E(charSequence2.toString());
                }
                gameCenterSessionInfo.F(firstUnreadMessage.time);
            }
            gameCenterSessionInfo.j0(recentUser.uin);
            gameCenterSessionInfo.C(recentUser.getType());
            gameCenterSessionInfo.m0(n(recentUser.uin, recentUser.getType()));
            gameCenterSessionInfo.i0(str);
            gameCenterSessionInfo.N(str2);
            t(gameCenterSessionInfo, d.f().e(str));
        }
        return gameCenterSessionInfo;
    }

    private String g(String str) {
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str);
        if (TextUtils.isEmpty(uidFromUin)) {
            return str;
        }
        com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(uidFromUin, "GameMsgSessionInfoManager");
        if (friendsSimpleInfoWithUid != null) {
            return friendsSimpleInfoWithUid.m();
        }
        return str;
    }

    private String h(MessageRecord messageRecord) {
        if (messageRecord == null) {
            return "";
        }
        String extInfoFromExtStr = messageRecord.getExtInfoFromExtStr(TinyInfo.EXT_KEY_GAME_MSG_INFO);
        if (TextUtils.isEmpty(extInfoFromExtStr)) {
            return "";
        }
        try {
            return new JSONObject(extInfoFromExtStr).optString(TinyInfo.KEY_GAME_APP_ID);
        } catch (JSONException e16) {
            QLog.e("GameMsgSessionInfoManager", 1, "getGameIdByMessage parse json err", e16);
            return "";
        }
    }

    private List<RecentUser> i() {
        RecentUser recentUser;
        ArrayList arrayList = new ArrayList();
        List<RecentUser> recentList = ((IRecentUserProxyService) this.f185537d.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache().getRecentList(true, false);
        if (recentList == null) {
            return arrayList;
        }
        for (int i3 = 0; i3 < recentList.size(); i3++) {
            RecentUser recentUser2 = recentList.get(i3);
            if (10007 == recentUser2.type) {
                arrayList.add(recentUser2);
            }
        }
        com.tencent.mobileqq.activity.recent.gamemsgbox.data.a a16 = com.tencent.mobileqq.activity.recent.gamemsgbox.data.a.a();
        if (a16 != null && (recentUser = a16.f185504a) != null) {
            arrayList.add(recentUser);
        }
        return arrayList;
    }

    public static b j() {
        return C7202b.f185541a;
    }

    private String k(MessageRecord messageRecord) {
        if (messageRecord == null) {
            return "";
        }
        String extInfoFromExtStr = messageRecord.getExtInfoFromExtStr(TinyInfo.EXT_KEY_GAME_MSG_INFO);
        if (TextUtils.isEmpty(extInfoFromExtStr)) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject(extInfoFromExtStr);
            String optString = jSONObject.optString(TinyInfo.KEY_FROM_FOLE_ID);
            String optString2 = jSONObject.optString(TinyInfo.KEY_TO_FOLE_ID);
            if (messageRecord.isSendFromLocal()) {
                return optString2;
            }
            return optString;
        } catch (JSONException e16) {
            QLog.e("GameMsgSessionInfoManager", 1, "getRoleIdByMessage parse json err", e16);
            return "";
        }
    }

    private int n(String str, int i3) {
        AppInterface appInterface = this.f185537d;
        if (appInterface == null) {
            return 0;
        }
        return ((IConversationFacade) appInterface.getRuntimeService(IConversationFacade.class, "")).getUnreadCount(str, i3);
    }

    private void o() {
        q();
        p();
    }

    private void p() {
        AppInterface appInterface = this.f185537d;
        if (appInterface == null) {
            return;
        }
        ((IMessageFacade) appInterface.getRuntimeService(IMessageFacade.class, "")).addObserver(this);
    }

    private void q() {
        if (this.f185537d == null) {
            QLog.d("GameMsgSessionInfoManager", 1, "initSessionInfo mApp is null");
            return;
        }
        try {
            List<RecentUser> i3 = i();
            QLog.d("GameMsgSessionInfoManager", 1, "recentUsers : " + i3.size());
            if (i3.size() > 0) {
                this.f185540h = true;
            }
            for (RecentUser recentUser : i3) {
                AppInterface appInterface = this.f185537d;
                if (appInterface == null) {
                    return;
                }
                Message lastMessage = ((IMessageFacade) appInterface.getRuntimeService(IMessageFacade.class, "")).getLastMessage(recentUser.uin, 10007);
                String k3 = k(lastMessage);
                String h16 = h(lastMessage);
                if (!TextUtils.isEmpty(k3)) {
                    GameCenterSessionInfo f16 = f(recentUser, k3, h16);
                    if (!TextUtils.isEmpty(f16.w()) && com.tencent.mobileqq.activity.recent.gamemsgbox.util.a.a(this.f185537d, f16.m())) {
                        this.f185539f.a(f16.m(), f16);
                        r(f16);
                    }
                }
            }
        } catch (NullPointerException unused) {
            QLog.e("GameMsgSessionInfoManager", 1, "initSessionInfo and mApp is null");
        }
    }

    @Override // com.tencent.mobileqq.activity.recent.gamemsgbox.manager.a
    public void b(AppRuntime appRuntime, EntityManager entityManager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime, (Object) entityManager);
            return;
        }
        super.b(appRuntime, entityManager);
        if (this.f185537d == null) {
            return;
        }
        o();
    }

    @Override // com.tencent.mobileqq.activity.recent.gamemsgbox.manager.a
    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.c();
        this.f185539f.b();
        this.f185540h = false;
    }

    public GameCenterSessionInfo l(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (GameCenterSessionInfo) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        }
        com.tencent.mobileqq.activity.recent.gamemsgbox.repo.a aVar = this.f185539f;
        if (aVar == null) {
            return null;
        }
        return aVar.e(str);
    }

    public GameCenterSessionInfo m(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (GameCenterSessionInfo) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        }
        com.tencent.mobileqq.activity.recent.gamemsgbox.repo.a aVar = this.f185539f;
        if (aVar == null) {
            return null;
        }
        return aVar.e(str);
    }

    public void r(GameCenterSessionInfo gameCenterSessionInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) gameCenterSessionInfo);
            return;
        }
        if (gameCenterSessionInfo != null && this.f185537d != null && !TextUtils.isEmpty(gameCenterSessionInfo.m())) {
            String m3 = gameCenterSessionInfo.m();
            GameCenterSessionInfo d16 = this.f185539f.d();
            if (com.tencent.mobileqq.activity.recent.gamemsgbox.util.a.a(this.f185537d, m3) && !c.e().f(m3) && gameCenterSessionInfo.q() >= d16.q()) {
                this.f185539f.g(gameCenterSessionInfo);
            }
        }
    }

    public void s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        if (this.f185539f != null && this.f185537d != null) {
            GameCenterSessionInfo gameCenterSessionInfo = new GameCenterSessionInfo();
            for (String str : this.f185539f.c()) {
                if (com.tencent.mobileqq.activity.recent.gamemsgbox.util.a.a(this.f185537d, str) && !c.e().f(str)) {
                    ConcurrentHashMap<String, GameCenterSessionInfo> f16 = this.f185539f.f(str);
                    if (f16.size() != 0) {
                        GameCenterSessionInfo gameCenterSessionInfo2 = (GameCenterSessionInfo) Collections.min(f16.values());
                        if (gameCenterSessionInfo2.q() > gameCenterSessionInfo.q()) {
                            gameCenterSessionInfo = gameCenterSessionInfo2;
                        }
                    }
                }
            }
            this.f185539f.g(gameCenterSessionInfo);
        }
    }

    public void t(GameCenterSessionInfo gameCenterSessionInfo, gd1.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) gameCenterSessionInfo, (Object) aVar);
            return;
        }
        if (gameCenterSessionInfo != null && aVar != null) {
            gameCenterSessionInfo.i0(aVar.f401937a);
            gameCenterSessionInfo.g0(aVar.f401938b);
            gameCenterSessionInfo.f0(g(aVar.f401938b));
            gameCenterSessionInfo.c0(aVar.f401941e);
            gameCenterSessionInfo.N(aVar.f401939c);
            gameCenterSessionInfo.e0(aVar.f401946j);
            gameCenterSessionInfo.D(aVar.f401940d);
            gameCenterSessionInfo.V(aVar.f401947k);
            gameCenterSessionInfo.d0(aVar.f401950n);
            gameCenterSessionInfo.M(aVar.f401948l);
        }
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) observable, obj);
            return;
        }
        MessageRecord d16 = d(obj);
        if (d16 != null && this.f185537d != null) {
            GameCenterSessionInfo m3 = m(d16.frienduin);
            if (m3 == null) {
                m3 = e(d16, k(d16));
                this.f185539f.a(m3.m(), m3);
            }
            m3.m0(n(d16.frienduin, 10007));
            m3.C(10007);
            m3.a0(d16.time);
            r(m3);
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f185540h = false;
            this.f185539f = new com.tencent.mobileqq.activity.recent.gamemsgbox.repo.a();
        }
    }
}
