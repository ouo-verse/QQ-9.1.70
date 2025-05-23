package com.tencent.imcore.message;

import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.util.ArrayMap;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.message.IMessageManager;
import com.tencent.mobileqq.app.proxy.ProxyListener;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.automator.api.IAutomatorApi;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.msf.MSFAccountChangeRegisterTask;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.msg.api.IMessageRecordFactory;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.revokemsg.RevokeMsgInfo;
import com.tencent.mobileqq.vas.util.impl.VasNamePlateUtilImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.smtt.sdk.stat.MttLoader;
import com.tencent.util.DeprecatedMethodInvokeReport;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.concurrent.locks.Lock;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes7.dex */
public abstract class BaseMessageManager extends Observable implements IMessageManager {
    static IPatchRedirector $redirector_;
    public static b D;
    private Object C;

    /* renamed from: d, reason: collision with root package name */
    public AppRuntime f116281d;

    /* renamed from: e, reason: collision with root package name */
    public IMessageFacade f116282e;

    /* renamed from: f, reason: collision with root package name */
    protected IConversationFacade f116283f;

    /* renamed from: h, reason: collision with root package name */
    protected MsgPool f116284h;

    /* renamed from: i, reason: collision with root package name */
    private Object f116285i;

    /* renamed from: m, reason: collision with root package name */
    private Object f116286m;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    private static class RefreshRunnable implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private final String f116289d;

        /* renamed from: e, reason: collision with root package name */
        private final int f116290e;

        /* renamed from: f, reason: collision with root package name */
        private final int f116291f;

        /* renamed from: h, reason: collision with root package name */
        private final aj f116292h;

        /* renamed from: i, reason: collision with root package name */
        private final String f116293i;

        /* renamed from: m, reason: collision with root package name */
        private final WeakReference<BaseMessageManager> f116294m;

        /* compiled from: P */
        /* loaded from: classes7.dex */
        private class RemoveRefreshKeyRunnable implements Runnable {
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            private final BaseMessageManager f116295d;

            RemoveRefreshKeyRunnable(BaseMessageManager baseMessageManager) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) RefreshRunnable.this, (Object) baseMessageManager);
                } else {
                    this.f116295d = baseMessageManager;
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                QLog.d("Q.msg.BaseMessageManager", 1, "refreshMessageListHead getRefreshActionMap remove mKey: " + RefreshRunnable.this.f116293i);
                this.f116295d.f116282e.getRefreshActionMap().remove(RefreshRunnable.this.f116293i);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            BaseMessageManager baseMessageManager = this.f116294m.get();
            if (baseMessageManager == null) {
                return;
            }
            baseMessageManager.e(this.f116289d, this.f116290e, this.f116291f, this.f116292h);
            baseMessageManager.f116282e.qLogColor("refreshMessageListHead uin = " + this.f116289d + ", type = " + this.f116290e + ", count = " + this.f116291f + ", context = " + this.f116292h, ", timestamp = " + System.currentTimeMillis());
            baseMessageManager.n(this.f116289d, this.f116290e, this.f116291f, this.f116292h);
            baseMessageManager.d(this.f116289d, this.f116290e, this.f116291f, this.f116292h);
            baseMessageManager.N(this.f116292h);
            baseMessageManager.f116282e.getFacadeHandler().post(new RemoveRefreshKeyRunnable(baseMessageManager));
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public Map<String, RecentUser> f116296a;

        /* renamed from: b, reason: collision with root package name */
        public Map<String, MessageRecord> f116297b;

        /* renamed from: c, reason: collision with root package name */
        public Map<String, MessageRecord> f116298c;

        /* renamed from: d, reason: collision with root package name */
        public Map<String, MessageRecord> f116299d;

        /* renamed from: e, reason: collision with root package name */
        public Map<String, MessageRecord> f116300e;

        /* renamed from: f, reason: collision with root package name */
        public Map<String, List<MessageRecord>> f116301f;

        /* renamed from: g, reason: collision with root package name */
        public Map<String, List<MessageRecord>> f116302g;

        /* renamed from: h, reason: collision with root package name */
        public Map<String, MessageRecord> f116303h;

        /* renamed from: i, reason: collision with root package name */
        public Manager f116304i;

        /* renamed from: j, reason: collision with root package name */
        public Manager f116305j;

        /* renamed from: k, reason: collision with root package name */
        public RecentUserProxy f116306k;

        /* renamed from: l, reason: collision with root package name */
        public IConversationFacade f116307l;

        public a(AppRuntime appRuntime) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime);
                return;
            }
            this.f116296a = new HashMap();
            this.f116297b = new HashMap();
            this.f116298c = new HashMap();
            this.f116299d = new HashMap();
            this.f116300e = new HashMap();
            this.f116301f = new HashMap();
            this.f116302g = new HashMap();
            this.f116303h = new HashMap();
            this.f116304i = BaseMessageManager.D.H(appRuntime);
            this.f116305j = BaseMessageManager.D.G(appRuntime);
            this.f116306k = ((IRecentUserProxyService) appRuntime.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache();
            this.f116307l = (IConversationFacade) appRuntime.getRuntimeService(IConversationFacade.class, "");
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface b {
        void A(AppRuntime appRuntime, List<MessageRecord> list, boolean z16);

        void B(AppRuntime appRuntime, ArrayMap<String, List<Long>> arrayMap, boolean z16);

        void C(AppRuntime appRuntime, IMessageFacade iMessageFacade, IConversationFacade iConversationFacade, String str, int i3, String str2, String str3, long j3);

        void D(AppRuntime appRuntime, String str);

        boolean E(MessageRecord messageRecord, Message message);

        void F(AppRuntime appRuntime, List<ChatMessage> list, List<ChatMessage> list2);

        Manager G(AppRuntime appRuntime);

        Manager H(AppRuntime appRuntime);

        boolean a(AppRuntime appRuntime, RecentUser recentUser);

        void b(AppRuntime appRuntime, boolean z16, boolean z17);

        f c(int i3, AppRuntime appRuntime);

        void d(AppRuntime appRuntime, String str, int i3, int i16, int i17);

        void e(AppRuntime appRuntime, BaseMessageManager baseMessageManager, IMessageFacade iMessageFacade, String str, int i3, String str2, String str3, int i16, int i17, boolean z16);

        boolean f(AppRuntime appRuntime, MessageRecord messageRecord);

        String g(AppRuntime appRuntime, int i3, String str, String str2, MessageForUniteGrayTip messageForUniteGrayTip);

        void h(MessageForUniteGrayTip messageForUniteGrayTip);

        void i(BaseMessageManager baseMessageManager, AppRuntime appRuntime, int i3, String str, List<MessageRecord> list, List<MessageRecord> list2, boolean z16, boolean z17);

        boolean isRobotUin(AppRuntime appRuntime, String str);

        boolean j(AppRuntime appRuntime, String str, int i3);

        boolean k(AppRuntime appRuntime, Message message);

        String l(AppRuntime appRuntime, int i3, String str, String str2, MessageForUniteGrayTip messageForUniteGrayTip, String str3);

        void m(AppRuntime appRuntime, IMessageFacade iMessageFacade, BaseMessageManager baseMessageManager, MessageRecord messageRecord);

        void n(AppRuntime appRuntime, List<MessageRecord> list, boolean z16);

        void o(MessageForUniteGrayTip messageForUniteGrayTip, Bundle bundle);

        boolean p(BaseMessageManager baseMessageManager, MessageRecord messageRecord);

        void pretreatmentAIOMsg(int i3, List<MessageRecord> list, AppRuntime appRuntime);

        void q(List<? extends MessageRecord> list);

        void r(AppRuntime appRuntime, String str, int i3);

        void refreshAppBadge(AppRuntime appRuntime);

        boolean s(MessageRecord messageRecord, List<MessageRecord> list);

        void t(AppRuntime appRuntime, List<MessageRecord> list, MessageRecord messageRecord);

        String u(AppRuntime appRuntime, String str);

        void v(AppRuntime appRuntime, String str, int i3);

        String w(String str, String str2);

        void x(AppRuntime appRuntime, MessageRecord messageRecord, long j3);

        void y(AppRuntime appRuntime, IMessageFacade iMessageFacade, boolean z16, int i3, boolean z17, List<MessageRecord> list, MessageRecord messageRecord);

        void z(IMessageFacade iMessageFacade, String str, int i3, List<MessageRecord> list, BaseMessageManager baseMessageManager);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36449);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 72)) {
            redirector.redirect((short) 72);
        } else {
            s.a();
        }
    }

    public BaseMessageManager(AppRuntime appRuntime, MsgPool msgPool) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime, (Object) msgPool);
            return;
        }
        this.f116285i = new Object();
        this.f116286m = new Object();
        this.C = new Object();
        this.f116281d = appRuntime;
        this.f116282e = (IMessageFacade) appRuntime.getRuntimeService(IMessageFacade.class, "");
        this.f116283f = (IConversationFacade) appRuntime.getRuntimeService(IConversationFacade.class, "");
        this.f116284h = msgPool;
    }

    @Nullable
    private Message O(String str, Message message, StringBuilder sb5) {
        try {
            Message message2 = this.f116282e.getCachedMsg().get(str);
            if (message2 == null) {
                if (QLog.isColorLevel()) {
                    sb5.append(" : case 1 : null inplace");
                }
                h(message);
                this.f116282e.getCachedMsg().put(str, message);
                return message;
            }
            if (A(message2) < A(message)) {
                if (QLog.isColorLevel()) {
                    sb5.append(" : case 2 : new inplace");
                }
                h(message);
                this.f116282e.getCachedMsg().put(str, message);
                return message;
            }
            if (!message2.isCacheValid && message.isCacheValid) {
                if (QLog.isColorLevel()) {
                    sb5.append(" : case 3 : valid inplace");
                }
                h(message);
                this.f116282e.getCachedMsg().put(str, message);
                return message;
            }
            if (QLog.isColorLevel()) {
                sb5.append(" : case 4 :invalid inplace");
            }
            message2.isCacheValid = true;
            return message2;
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager", 2, "refreshSingleLastMsg ERROR", th5);
                return message;
            }
            return message;
        }
    }

    private void P(Message message) {
        List<MessageRecord> p16;
        if (((!AppConstants.LBS_HELLO_UIN.equals(message.frienduin) && (ao.c(message.istroop) == 1001 || ao.c(message.istroop) == 10002)) || ao.c(message.istroop) == 10010 || (!AppConstants.DATE_UIN.equals(message.frienduin) && ao.c(message.istroop) == 1010)) && (p16 = y(message.istroop).p(message.frienduin, message.istroop)) != null && p16.size() > 0) {
            for (MessageRecord messageRecord : p16) {
                String str = messageRecord.senderuin;
                if (str != null && str.equals(messageRecord.frienduin) && !com.tencent.mobileqq.service.message.s.j(messageRecord.msgtype)) {
                    message.hasReply = true;
                    if (QLog.isColorLevel()) {
                        QLog.d("Q.msg.BaseMessageManager", 2, "refreshSingleLastMsg = " + message + ",hasReply=" + message.hasReply);
                        return;
                    }
                    return;
                }
            }
        }
    }

    private void T(String str, Message message) {
        if ((str.equals(String.valueOf(AppConstants.DATALINE_PC_UIN)) || str.equals(String.valueOf(AppConstants.DATALINE_IPAD_UIN))) && message.msgData != null) {
            D.E(null, message);
        }
    }

    public static void e0(b bVar) {
        D = bVar;
    }

    private boolean i(Message message) {
        return false;
    }

    private com.tencent.mobileqq.graytip.g j0(int i3, String str, String str2, String str3, String str4, MessageForUniteGrayTip messageForUniteGrayTip, long j3) {
        String w3 = w(i3, str2, str3, messageForUniteGrayTip, "");
        String string = this.f116281d.getApp().getString(R.string.f171414eu2);
        int length = str.length() + string.length();
        int length2 = w3.length() + length;
        String str5 = str + string + w3 + this.f116281d.getApp().getString(R.string.f171415eu3);
        com.tencent.mobileqq.graytip.g gVar = new com.tencent.mobileqq.graytip.g(str3, str4, str5, i3, MessageRecord.MSG_TYPE_UNITE_GRAY_NORMAL, 1, j3);
        Bundle bundle = new Bundle();
        f0(messageForUniteGrayTip, bundle);
        bundle.putInt("key_action", 28);
        bundle.putString("troop_mem_uin", String.valueOf(str2));
        bundle.putBoolean("need_update_nick", true);
        gVar.b(length, length2, bundle);
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager", 2, "revoke message wording", str5, Integer.valueOf(length), " end:", Integer.valueOf(length2));
        }
        return gVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:114:0x043e  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0471  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0494  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x049d  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x04a2  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x04bd  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x04f0  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0508  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x051e  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x04f6  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x04e7  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x04b6  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x047d  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0464  */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v33 */
    /* JADX WARN: Type inference failed for: r2v73 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void k(ArrayList<RevokeMsgInfo> arrayList, boolean z16) {
        boolean z17;
        String str;
        String str2;
        RevokeMsgInfo revokeMsgInfo;
        boolean z18;
        int i3;
        boolean z19;
        long j3;
        String str3;
        String str4;
        String z26;
        String str5;
        boolean z27;
        RevokeMsgInfo revokeMsgInfo2;
        ArrayMap<String, List<Long>> arrayMap;
        int i16;
        String str6;
        int i17;
        BaseApplication app;
        int i18;
        boolean z28;
        int i19;
        MessageForUniteGrayTip messageForUniteGrayTip;
        ?? r26;
        com.tencent.mobileqq.graytip.g gVar;
        String str7;
        boolean z29;
        boolean z36;
        RevokeMsgInfo revokeMsgInfo3;
        long j16;
        boolean z37;
        MessageForUniteGrayTip messageForUniteGrayTip2;
        List<MessageRecord> z38;
        String concat;
        boolean z39;
        RevokeMsgInfo revokeMsgInfo4 = arrayList.get(0);
        if (revokeMsgInfo4.F > 1) {
            z17 = true;
        } else {
            z17 = false;
        }
        int i26 = revokeMsgInfo4.f281286d;
        String str8 = revokeMsgInfo4.f281289h;
        String str9 = revokeMsgInfo4.f281288f;
        String str10 = revokeMsgInfo4.D;
        String str11 = revokeMsgInfo4.H;
        int i27 = revokeMsgInfo4.I;
        int i28 = revokeMsgInfo4.J;
        boolean z46 = revokeMsgInfo4.K;
        int i29 = revokeMsgInfo4.L;
        String str12 = revokeMsgInfo4.M;
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            str = str12;
            sb5.append("revoke msg doHandleRevokedNotifyAndNotify fromUin = ");
            sb5.append(str8);
            sb5.append(", istroop = ");
            sb5.append(i26);
            sb5.append(",toUin=");
            sb5.append(str9);
            sb5.append(",groupUin=");
            sb5.append(str10);
            sb5.append(",authorUin=");
            sb5.append(str11);
            sb5.append(",opType= ");
            sb5.append(i27);
            sb5.append(",anonyType ");
            sb5.append(i28);
            sb5.append(", needShow = ");
            sb5.append(z46);
            sb5.append(", grayTipsWordingId = ");
            sb5.append(i29);
            QLog.i("Q.msg.BaseMessageManager", 2, sb5.toString());
        } else {
            str = str12;
        }
        String account = this.f116281d.getAccount();
        if (i26 != 1004 && i26 != 1000) {
            str2 = str8;
        } else {
            str2 = str10;
        }
        boolean equals = TextUtils.equals(account, str8);
        if (i26 != 3000 && i26 != 1 && !equals) {
            str9 = str8;
        }
        String str13 = str9;
        ArrayList arrayList2 = new ArrayList();
        ArrayMap<String, List<Long>> arrayMap2 = new ArrayMap<>();
        Iterator<RevokeMsgInfo> it = arrayList.iterator();
        while (it.hasNext()) {
            Iterator<RevokeMsgInfo> it5 = it;
            RevokeMsgInfo next = it.next();
            String str14 = str13;
            int i36 = i28;
            boolean z47 = z46;
            String str15 = str11;
            int i37 = i27;
            RevokeMsgInfo revokeMsgInfo5 = revokeMsgInfo4;
            ArrayList arrayList3 = arrayList2;
            String str16 = str2;
            String str17 = str;
            List<MessageRecord> queryMsgItemByShmsgseq = this.f116282e.queryMsgItemByShmsgseq(str14, i26, next.f281287e, next.f281291m);
            if (queryMsgItemByShmsgseq != null && !queryMsgItemByShmsgseq.isEmpty()) {
                if (i26 == 0) {
                    for (MessageRecord messageRecord : queryMsgItemByShmsgseq) {
                        if (TextUtils.equals(messageRecord.senderuin, str8)) {
                            arrayList3.add(messageRecord);
                        }
                    }
                } else {
                    arrayList3.addAll(queryMsgItemByShmsgseq);
                }
            }
            if (next.f281286d == 1) {
                List<Long> list = arrayMap2.get(next.f281288f);
                if (list == null) {
                    list = new ArrayList<>();
                    arrayMap2.put(next.f281288f, list);
                }
                list.add(Long.valueOf(next.f281287e));
            }
            arrayList2 = arrayList3;
            z46 = z47;
            revokeMsgInfo4 = revokeMsgInfo5;
            it = it5;
            str13 = str14;
            str = str17;
            str2 = str16;
            i28 = i36;
            str11 = str15;
            i27 = i37;
        }
        String str18 = str13;
        String str19 = str2;
        int i38 = i28;
        String str20 = str11;
        int i39 = i27;
        RevokeMsgInfo revokeMsgInfo6 = revokeMsgInfo4;
        String str21 = str;
        ArrayList arrayList4 = arrayList2;
        boolean z48 = z46;
        if (z17) {
            try {
                Collections.sort(arrayList4, ad.f116467n);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.BaseMessageManager", 2, "sort long msg error", e16);
                }
            }
        }
        J(arrayList4, "doHandleRevokedNotifyAndNotify");
        if (arrayList4.size() == 1) {
            if (com.tencent.mobileqq.graytip.f.e(arrayList4.get(0))) {
                return;
            }
            if (arrayList4.get(0).msgtype == -2006) {
                if (D.E(arrayList4.get(0), null)) {
                    if (QLog.isColorLevel()) {
                        QLog.d("Q.msg.BaseMessageManager", 2, "revoke msg doHandleRevokedNotifyAndNotify, error: msg is fold redbag msg");
                        return;
                    }
                    return;
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.d("Q.msg.BaseMessageManager", 2, "revoke msg doHandleRevokedNotifyAndNotify, error: same revoke msg");
                        return;
                    }
                    return;
                }
            }
        }
        if (arrayList4.isEmpty()) {
            if (!((IAutomatorApi) QRoute.api(IAutomatorApi.class)).isSyncNormalMsgFinish()) {
                ((com.tencent.mobileqq.service.message.e) this.f116281d.getMsgCache()).J(arrayList);
                return;
            } else {
                revokeMsgInfo = revokeMsgInfo6;
                z18 = false;
            }
        } else {
            revokeMsgInfo = revokeMsgInfo6;
            z18 = true;
        }
        if (revokeMsgInfo.J == 1 && !equals) {
            i3 = i39;
            if (i3 == 0) {
                z39 = true;
            } else {
                z39 = false;
            }
            if (z39 && arrayList4.size() > 0) {
                z19 = arrayList4.get(0).isSend();
            } else {
                z19 = false;
            }
        } else {
            i3 = i39;
            z19 = equals;
        }
        MessageForUniteGrayTip messageForUniteGrayTip3 = new MessageForUniteGrayTip();
        if (z18 && arrayList4.get(0).msgtype != -2006) {
            j3 = arrayList4.get(0).time;
        } else {
            j3 = revokeMsgInfo.C;
        }
        long j17 = j3;
        if (z19) {
            if (i3 == 0 && revokeMsgInfo.J == 0 && !TextUtils.isEmpty(str21)) {
                z26 = D.u(this.f116281d, str8);
            } else {
                z26 = HardCodeUtil.qqStr(R.string.jyv);
            }
            str3 = str18;
            str4 = str19;
        } else {
            str3 = str18;
            str4 = str19;
            z26 = z(i26, str3, str4, messageForUniteGrayTip3);
        }
        this.f116281d.getApp().getString(R.string.f171416eu4);
        String string = this.f116281d.getApp().getString(R.string.f181193d4);
        String string2 = this.f116281d.getApp().getString(R.string.f181183d3);
        if (i3 != 1 && i3 != 2) {
            String str22 = string2;
            if (revokeMsgInfo.J == 1) {
                if (z19) {
                    concat = z26.concat(string);
                }
                String str23 = str3;
                String str24 = str4;
                String str25 = str3;
                String str26 = str22;
                str5 = str25;
                arrayMap = arrayMap2;
                z27 = z19;
                revokeMsgInfo2 = revokeMsgInfo;
                i16 = i3;
                gVar = new com.tencent.mobileqq.graytip.g(str23, str24, str26, i26, MessageRecord.MSG_TYPE_UNITE_GRAY_NORMAL, 1, j17);
                i19 = i26;
                messageForUniteGrayTip = messageForUniteGrayTip3;
                z29 = true;
                str6 = str8;
                i17 = i38;
            } else {
                if (z26.length() > 9) {
                    z26 = z26.substring(0, 8) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
                }
                concat = z26.concat(BaseApplication.getContext().getString(R.string.cdg));
                if (!TextUtils.isEmpty(str21)) {
                    concat = concat.concat("\uff0c" + str21);
                }
            }
            str22 = concat;
            String str232 = str3;
            String str242 = str4;
            String str252 = str3;
            String str262 = str22;
            str5 = str252;
            arrayMap = arrayMap2;
            z27 = z19;
            revokeMsgInfo2 = revokeMsgInfo;
            i16 = i3;
            gVar = new com.tencent.mobileqq.graytip.g(str232, str242, str262, i26, MessageRecord.MSG_TYPE_UNITE_GRAY_NORMAL, 1, j17);
            i19 = i26;
            messageForUniteGrayTip = messageForUniteGrayTip3;
            z29 = true;
            str6 = str8;
            i17 = i38;
        } else {
            str5 = str3;
            z27 = z19;
            revokeMsgInfo2 = revokeMsgInfo;
            arrayMap = arrayMap2;
            i16 = i3;
            if (TextUtils.equals(str8, this.f116281d.getAccount())) {
                if (str20 != null && !E(str20)) {
                    str6 = str8;
                    gVar = j0(i26, z26, str20, str5, str4, messageForUniteGrayTip3, j17);
                    String str27 = gVar.f213683f;
                    i19 = i26;
                    messageForUniteGrayTip = messageForUniteGrayTip3;
                    i17 = i38;
                    z29 = true;
                } else {
                    String str28 = str4;
                    str6 = str8;
                    String concat2 = z26.concat(this.f116281d.getApp().getString(R.string.f171416eu4));
                    i17 = i38;
                    if (i17 == 1) {
                        str7 = z26.concat(string);
                    } else {
                        str7 = concat2;
                    }
                    gVar = new com.tencent.mobileqq.graytip.g(str5, str28, str7, i26, MessageRecord.MSG_TYPE_UNITE_GRAY_NORMAL, 1, j17);
                    z28 = z17;
                    messageForUniteGrayTip = messageForUniteGrayTip3;
                    r26 = 1;
                    i19 = i26;
                }
            } else {
                String str29 = str4;
                str6 = str8;
                i17 = i38;
                if (i16 == 2) {
                    app = this.f116281d.getApp();
                    i18 = R.string.euv;
                } else {
                    app = this.f116281d.getApp();
                    i18 = R.string.euu;
                }
                String string3 = app.getString(i18);
                int length = string3.length();
                int length2 = string3.length() + z26.length();
                z28 = z17;
                i19 = i26;
                com.tencent.mobileqq.graytip.g gVar2 = new com.tencent.mobileqq.graytip.g(str5, str29, string3 + z26 + this.f116281d.getApp().getString(R.string.f171416eu4), i26, MessageRecord.MSG_TYPE_UNITE_GRAY_NORMAL, 1, j17);
                Bundle bundle = new Bundle();
                messageForUniteGrayTip = messageForUniteGrayTip3;
                f0(messageForUniteGrayTip, bundle);
                bundle.putInt("key_action", 5);
                bundle.putString("troop_mem_uin", String.valueOf(str6));
                r26 = 1;
                bundle.putBoolean("need_update_nick", true);
                gVar2.b(length, length2, bundle);
                gVar = gVar2;
            }
            if (!QLog.isColorLevel()) {
                Object[] objArr = new Object[6];
                objArr[0] = "revoke msg doHandleRevokedNotifyAndNotify isRevokeSender = ";
                objArr[r26] = Boolean.valueOf(z27);
                objArr[2] = ",selfuin=";
                objArr[3] = account;
                objArr[4] = ",fromUin=";
                objArr[5] = str6;
                QLog.d("Q.msg.BaseMessageManager", 2, objArr);
                z36 = true;
            } else {
                z36 = r26;
            }
            gVar.f213690m = z36;
            gVar.f213695r = false;
            messageForUniteGrayTip.initGrayTipMsg(this.f116281d, gVar);
            if (!z18) {
                j16 = arrayList4.get(0).msgUid;
                revokeMsgInfo3 = revokeMsgInfo2;
            } else {
                revokeMsgInfo3 = revokeMsgInfo2;
                j16 = revokeMsgInfo3.f281291m;
            }
            messageForUniteGrayTip.msgUid = j16;
            messageForUniteGrayTip.shmsgseq = revokeMsgInfo3.f281287e;
            messageForUniteGrayTip.saveExtInfoToExtStr("revoke_op_type", String.valueOf(i16));
            if (i17 == 1) {
                D.h(messageForUniteGrayTip);
            }
            z37 = z27;
            if (z37) {
                com.tencent.mobileqq.graytip.f.f(arrayList4);
            }
            if (!z18) {
                messageForUniteGrayTip2 = messageForUniteGrayTip;
                D.y(this.f116281d, this.f116282e, z28, i19, z48, arrayList4, null);
            } else {
                messageForUniteGrayTip2 = messageForUniteGrayTip;
            }
            if (!arrayMap.isEmpty()) {
                D.B(this.f116281d, arrayMap, z37);
            }
            int i46 = i19;
            String str30 = str5;
            z38 = y(i46).z(str30, i46);
            if (z38 == null && !z38.isEmpty()) {
                if (z48) {
                    D(i46, str30, messageForUniteGrayTip2, z38);
                }
            } else if (QLog.isColorLevel()) {
                QLog.w("Q.msg.BaseMessageManager", 2, "doHandleRevokedNotifyAndNotify: AIO is empty");
            }
            if (!z48) {
                com.tencent.mobileqq.graytip.f.a(this.f116281d, messageForUniteGrayTip2);
            } else if (arrayList4.size() > 0) {
                this.f116282e.setChangeAndNotify(arrayList4.get(0));
            }
            if (!z18) {
                Iterator<MessageRecord> it6 = arrayList4.iterator();
                while (it6.hasNext()) {
                    this.f116282e.cancelNotificationWhenRevokeMessage(it6.next());
                }
            } else {
                this.f116282e.cancelNotificationWhenRevokeMessage(messageForUniteGrayTip2);
            }
            if (z18 && !arrayList4.get(0).isread) {
                D.refreshAppBadge(this.f116281d);
            }
            D.n(this.f116281d, arrayList4, z37);
        }
        z28 = z17;
        r26 = z29;
        if (!QLog.isColorLevel()) {
        }
        gVar.f213690m = z36;
        gVar.f213695r = false;
        messageForUniteGrayTip.initGrayTipMsg(this.f116281d, gVar);
        if (!z18) {
        }
        messageForUniteGrayTip.msgUid = j16;
        messageForUniteGrayTip.shmsgseq = revokeMsgInfo3.f281287e;
        messageForUniteGrayTip.saveExtInfoToExtStr("revoke_op_type", String.valueOf(i16));
        if (i17 == 1) {
        }
        z37 = z27;
        if (z37) {
        }
        if (!z18) {
        }
        if (!arrayMap.isEmpty()) {
        }
        int i462 = i19;
        String str302 = str5;
        z38 = y(i462).z(str302, i462);
        if (z38 == null) {
        }
        if (QLog.isColorLevel()) {
        }
        if (!z48) {
        }
        if (!z18) {
        }
        if (z18) {
            D.refreshAppBadge(this.f116281d);
        }
        D.n(this.f116281d, arrayList4, z37);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:45:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0297  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x02b3  */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v14, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v24 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void p(ArrayList<RevokeMsgInfo> arrayList) {
        String str;
        MessageRecord messageRecord;
        int i3;
        String str2;
        long j3;
        ?? r06;
        List<MessageRecord> list;
        int i16;
        int i17;
        String str3;
        int i18;
        String account;
        MessageForUniteGrayTip messageForUniteGrayTip;
        com.tencent.mobileqq.graytip.g gVar;
        boolean z16;
        String str4;
        RevokeMsgInfo revokeMsgInfo = arrayList.get(0);
        int i19 = revokeMsgInfo.f281286d;
        String str5 = revokeMsgInfo.f281288f;
        String str6 = revokeMsgInfo.f281289h;
        int i26 = revokeMsgInfo.I;
        int i27 = revokeMsgInfo.L;
        String str7 = revokeMsgInfo.M;
        String str8 = "Q.msg.BaseMessageManager";
        if (QLog.isColorLevel()) {
            QLog.w("Q.msg.BaseMessageManager", 2, "revoke msg doReplaceRevokedMsgAndNotify frienduin = " + str5 + ", fromUin = " + str6 + ", istroop = " + i19 + ", grayTipsWordingId = " + i27 + ", senderUin = " + revokeMsgInfo.D);
        }
        List<MessageRecord> l3 = y(i19).l(str5, i19);
        if (l3 != null && !l3.isEmpty()) {
            List<MessageRecord> q16 = q(l3, str5, i19, arrayList);
            if (q16 != null && !q16.isEmpty()) {
                if (q16.size() == 1 && com.tencent.mobileqq.graytip.f.e(q16.get(0))) {
                    if (QLog.isColorLevel()) {
                        QLog.w("Q.msg.BaseMessageManager", 2, "revoke msg doReplaceRevokedMsgAndNotify same gray msg");
                    }
                    MessageRecord messageRecord2 = q16.get(0);
                    if (messageRecord2 instanceof MessageForUniteGrayTip) {
                        com.tencent.mobileqq.graytip.f.d(this.f116281d, (MessageForUniteGrayTip) messageRecord2);
                        return;
                    }
                    return;
                }
                MessageRecord messageRecord3 = q16.get(0);
                Iterator<MessageRecord> it = q16.iterator();
                while (true) {
                    if (it.hasNext()) {
                        MessageRecord next = it.next();
                        Iterator<MessageRecord> it5 = it;
                        str = str8;
                        if (next.shmsgseq == revokeMsgInfo.f281287e && next.msgUid == revokeMsgInfo.f281291m) {
                            messageRecord = next;
                            break;
                        } else {
                            it = it5;
                            str8 = str;
                        }
                    } else {
                        str = str8;
                        messageRecord = messageRecord3;
                        break;
                    }
                }
                MessageForUniteGrayTip messageForUniteGrayTip2 = new MessageForUniteGrayTip();
                String string = this.f116281d.getApp().getString(R.string.f181193d4);
                this.f116281d.getApp().getString(R.string.f181183d3);
                int i28 = revokeMsgInfo.J;
                if (i26 != 1 && i26 != 2) {
                    String str9 = HardCodeUtil.qqStr(R.string.jyr) + BaseApplication.getContext().getString(R.string.cdg);
                    account = messageRecord.senderuin;
                    if (i28 == 1) {
                        str9 = HardCodeUtil.qqStr(R.string.jyr) + string;
                    } else if (!TextUtils.isEmpty(str7)) {
                        if (TextUtils.isEmpty(str6)) {
                            str6 = this.f116281d.getAccount();
                        }
                        String u16 = D.u(this.f116281d, str6);
                        if (!TextUtils.isEmpty(u16)) {
                            if (u16.length() > 9) {
                                u16 = u16.substring(0, 8) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
                            }
                            str9 = u16.concat(BaseApplication.getContext().getString(R.string.cdg));
                        }
                        str9 = str9.concat("\uff0c" + str7);
                    }
                    i3 = i28;
                    str2 = str;
                    gVar = new com.tencent.mobileqq.graytip.g(str5, account, str9, i19, MessageRecord.MSG_TYPE_UNITE_GRAY_NORMAL, 1, messageRecord.time);
                    list = q16;
                    i17 = i19;
                    str3 = str5;
                    i16 = i26;
                    messageForUniteGrayTip = messageForUniteGrayTip2;
                    z16 = true;
                } else {
                    i3 = i28;
                    str2 = str;
                    String qqStr = HardCodeUtil.qqStr(R.string.jyw);
                    String account2 = this.f116281d.getAccount();
                    if (q16.get(0).msgtype != -2006) {
                        j3 = q16.get(0).time;
                    } else {
                        j3 = revokeMsgInfo.C;
                    }
                    String str10 = revokeMsgInfo.D;
                    if (str10 != null && !E(str10)) {
                        list = q16;
                        i16 = i26;
                        messageForUniteGrayTip = messageForUniteGrayTip2;
                        i17 = i19;
                        str3 = str5;
                        com.tencent.mobileqq.graytip.g j06 = j0(i19, qqStr, revokeMsgInfo.D, str5, account2, messageForUniteGrayTip, j3);
                        String str11 = j06.f213683f;
                        gVar = j06;
                        z16 = true;
                        account = account2;
                    } else {
                        r06 = 1;
                        list = q16;
                        i16 = i26;
                        i17 = i19;
                        str3 = str5;
                        String str12 = HardCodeUtil.qqStr(R.string.jyt) + BaseApplication.getContext().getString(R.string.f171416eu4);
                        i18 = i3;
                        if (i18 == 1) {
                            str12 = qqStr.concat(string);
                        }
                        account = this.f116281d.getAccount();
                        messageForUniteGrayTip = messageForUniteGrayTip2;
                        gVar = new com.tencent.mobileqq.graytip.g(str3, account, str12, i17, MessageRecord.MSG_TYPE_UNITE_GRAY_NORMAL, 1, messageRecord.time);
                        gVar.f213690m = r06;
                        gVar.f213695r = false;
                        messageForUniteGrayTip.initGrayTipMsg(this.f116281d, gVar);
                        messageForUniteGrayTip.msgUid = messageRecord.msgUid;
                        messageForUniteGrayTip.shmsgseq = messageRecord.shmsgseq;
                        messageForUniteGrayTip.saveExtInfoToExtStr("revoke_op_type", String.valueOf(i16));
                        if (i18 == r06) {
                            D.h(messageForUniteGrayTip);
                        }
                        if (!QLog.isColorLevel()) {
                            Object[] objArr = new Object[4];
                            objArr[0] = "revoke msg doReplaceRevokedMsgAndNotify senderUin=";
                            objArr[r06] = account;
                            objArr[2] = ",frienduin=";
                            str4 = str3;
                            objArr[3] = str4;
                            QLog.d(str2, 2, objArr);
                        } else {
                            str4 = str3;
                        }
                        D.y(this.f116281d, this.f116282e, true, 0, true, list, messageRecord);
                        int i29 = i17;
                        D(i29, str4, messageForUniteGrayTip, y(i29).z(str4, i29));
                        com.tencent.mobileqq.graytip.f.a(this.f116281d, messageForUniteGrayTip);
                        D.n(this.f116281d, null, r06);
                        D.A(this.f116281d, list, r06);
                        return;
                    }
                }
                i18 = i3;
                r06 = z16;
                gVar.f213690m = r06;
                gVar.f213695r = false;
                messageForUniteGrayTip.initGrayTipMsg(this.f116281d, gVar);
                messageForUniteGrayTip.msgUid = messageRecord.msgUid;
                messageForUniteGrayTip.shmsgseq = messageRecord.shmsgseq;
                messageForUniteGrayTip.saveExtInfoToExtStr("revoke_op_type", String.valueOf(i16));
                if (i18 == r06) {
                }
                if (!QLog.isColorLevel()) {
                }
                D.y(this.f116281d, this.f116282e, true, 0, true, list, messageRecord);
                int i292 = i17;
                D(i292, str4, messageForUniteGrayTip, y(i292).z(str4, i292));
                com.tencent.mobileqq.graytip.f.a(this.f116281d, messageForUniteGrayTip);
                D.n(this.f116281d, null, r06);
                D.A(this.f116281d, list, r06);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.w("Q.msg.BaseMessageManager", 2, "revoke msg doReplaceRevokedMsgAndNotify error: can't find previous msg in AIO");
            }
            D.d(this.f116281d, str5, i19, BaseMessageProcessor.f116325e, BaseMessageProcessor.f116332l);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.w("Q.msg.BaseMessageManager", 2, "revoke msg doReplaceRevokedMsgAndNotify error: AIO is empty");
        }
        D.d(this.f116281d, str5, i19, BaseMessageProcessor.f116325e, BaseMessageProcessor.f116331k);
    }

    private void v0(MessageRecord messageRecord, Message message, boolean z16) {
        int i3 = messageRecord.msgtype;
        if (i3 == -1013 || i3 == -1019 || i3 == -1018) {
            this.f116282e.setIncomingMsg(message);
        }
        if (!String.valueOf(AppConstants.RECOMMEND_CONTACT_UIN).equals(message.frienduin) && (!ao.B(message) || ad.F(this.f116281d, messageRecord))) {
            D.E(messageRecord, message);
            this.f116282e.setIncomingMsg(message);
        }
        int i16 = message.msgtype;
        if ((i16 == -2009 || i16 == -2016) && z16) {
            Message message2 = new Message();
            MessageRecord.copyMessageRecordBaseField(message2, messageRecord);
            message2.emoRecentMsg = null;
            message2.fileType = -1;
            message.lastMsg = null;
            this.f116282e.setIncomingMsg(message2);
        }
        if (AppConstants.TROOP_SYSTEM_MSG_UIN.equals(message.frienduin)) {
            this.f116282e.setIncomingMsg(null);
        }
    }

    private String w(int i3, String str, String str2, MessageForUniteGrayTip messageForUniteGrayTip, String str3) {
        return D.l(this.f116281d, i3, str, str2, messageForUniteGrayTip, str3);
    }

    private long x(String str, int i3) {
        List<MessageRecord> list;
        List<MessageRecord> o16;
        if (str == null) {
            return 0L;
        }
        String str2 = "";
        if (ao.c(i3) == 1009) {
            list = y(i3).o(AppConstants.SAME_STATE_BOX_UIN, 1009);
        } else if (ao.c(i3) == 1001) {
            list = y(i3).o(AppConstants.LBS_HELLO_UIN, 1001);
            str2 = AppConstants.LBS_SAY_HELLO_LIST_UIN;
        } else if (ao.c(i3) == 1010) {
            list = y(i3).o(AppConstants.DATE_UIN, 1010);
            str2 = AppConstants.DATE_SAY_HELLO_LIST_UIN;
        } else if (ao.c(i3) == 10002) {
            list = y(i3).o(AppConstants.LBS_HELLO_UIN, 10002);
            str2 = AppConstants.LBS_SAY_HELLO_LIST_UIN;
        } else {
            list = null;
        }
        boolean z16 = false;
        if (list != null && !list.isEmpty()) {
            for (MessageRecord messageRecord : list) {
                if (str.equals(messageRecord.senderuin)) {
                    return messageRecord.uniseq;
                }
                if (!TextUtils.isEmpty(str2) && (AppConstants.LBS_SAY_HELLO_LIST_UIN.equals(messageRecord.senderuin) || AppConstants.DATE_SAY_HELLO_LIST_UIN.equals(messageRecord.senderuin))) {
                    z16 = true;
                }
            }
        }
        if (z16 && (o16 = y(i3).o(str2, ao.c(i3))) != null && !o16.isEmpty()) {
            for (MessageRecord messageRecord2 : o16) {
                if (str.equals(messageRecord2.senderuin)) {
                    return messageRecord2.uniseq;
                }
            }
        }
        return 0L;
    }

    public abstract long A(MessageRecord messageRecord);

    public abstract void B(String str, int i3, List<MessageRecord> list, List<MessageRecord> list2, Bundle bundle);

    public void C(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 62)) {
            iPatchRedirector.redirect((short) 62, (Object) this, (Object) messageRecord);
        } else {
            ThreadManagerV2.executeOnNetWorkThread(new Runnable(messageRecord, System.currentTimeMillis()) { // from class: com.tencent.imcore.message.BaseMessageManager.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ MessageRecord f116287d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ long f116288e;

                {
                    this.f116287d = messageRecord;
                    this.f116288e = r7;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, BaseMessageManager.this, messageRecord, Long.valueOf(r7));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    ((com.tencent.mobileqq.service.message.e) BaseMessageManager.this.f116281d.getMsgCache()).U1(this.f116287d);
                    BaseMessageManager.this.b0();
                    long currentTimeMillis = 15000 - (System.currentTimeMillis() - this.f116288e);
                    com.tencent.mobileqq.service.message.e eVar = (com.tencent.mobileqq.service.message.e) BaseMessageManager.this.f116281d.getMsgCache();
                    MessageRecord messageRecord2 = this.f116287d;
                    if (!eVar.k1(messageRecord2.frienduin, messageRecord2.istroop, messageRecord2.uniseq)) {
                        BaseMessageManager.D.x(BaseMessageManager.this.f116281d, this.f116287d, currentTimeMillis);
                    } else {
                        b bVar = BaseMessageManager.D;
                        AppRuntime appRuntime = BaseMessageManager.this.f116281d;
                        MessageRecord messageRecord3 = this.f116287d;
                        bVar.d(appRuntime, messageRecord3.frienduin, messageRecord3.istroop, BaseMessageProcessor.f116326f, BaseMessageProcessor.f116334n);
                    }
                    ((com.tencent.mobileqq.service.message.e) BaseMessageManager.this.f116281d.getMsgCache()).U1(null);
                }
            });
        }
    }

    public <T extends MessageRecord> void D(int i3, String str, T t16, List<T> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 64)) {
            iPatchRedirector.redirect((short) 64, this, Integer.valueOf(i3), str, t16, list);
            return;
        }
        Lock e16 = this.f116284h.e(str, i3);
        e16.lock();
        try {
            ad.o(list, t16, true);
        } finally {
            e16.unlock();
        }
    }

    public boolean E(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 70)) {
            return ((Boolean) iPatchRedirector.redirect((short) 70, (Object) this, (Object) str)).booleanValue();
        }
        if (!TextUtils.equals(str, MSFAccountChangeRegisterTask.MSF_DEFAULT_UIN) && !TextUtils.equals(str, VasNamePlateUtilImpl.WILDCARD) && !TextUtils.equals(str, "50000000") && !TextUtils.equals(str, "80000000") && !F(str)) {
            return false;
        }
        return true;
    }

    protected boolean F(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 71)) {
            return ((Boolean) iPatchRedirector.redirect((short) 71, (Object) this, (Object) str)).booleanValue();
        }
        return D.isRobotUin(this.f116281d, str);
    }

    protected boolean G(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return ((Boolean) iPatchRedirector.redirect((short) 35, (Object) this, (Object) str, i3)).booleanValue();
        }
        return D.j(this.f116281d, str, i3);
    }

    protected void H(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, (Object) str, i3);
        } else {
            D.v(this.f116281d, str, i3);
        }
    }

    public void I(List<MessageRecord> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 69)) {
            iPatchRedirector.redirect((short) 69, (Object) this, (Object) list);
            return;
        }
        if (Looper.myLooper() != Looper.getMainLooper() && list != null) {
            Iterator<MessageRecord> it = list.iterator();
            while (it.hasNext()) {
                D.E(it.next(), null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void J(List<MessageRecord> list, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 65)) {
            iPatchRedirector.redirect((short) 65, (Object) this, (Object) list, (Object) str);
            return;
        }
        for (MessageRecord messageRecord : list) {
            if (com.tencent.mobileqq.graytip.f.e(messageRecord)) {
                QLog.d("Q.msg.BaseMessageManager", 1, "pull Revoke Gray Tip: ", str, messageRecord);
            }
        }
    }

    public void K(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) message);
        }
    }

    public void L(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) message);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void M(aj ajVar, int i3) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) ajVar, i3);
            return;
        }
        QLog.d("Q.msg.BaseMessageManager", 4, "refreshHeadComplete " + i3 + " " + ajVar);
        List<MessageRecord> list = ajVar.f116524b;
        if (list != null && list.size() > 0) {
            synchronized (ajVar.f116524b) {
                D.pretreatmentAIOMsg(i3, ajVar.f116524b, this.f116281d);
                if (ajVar.f116524b.size() > 0) {
                    ad.P(ajVar.f116541s, ajVar.f116542t, ajVar.f116524b, (com.tencent.mobileqq.service.message.e) this.f116281d.getMsgCache());
                }
            }
            z16 = true;
        } else {
            z16 = false;
        }
        String str = ajVar.f116541s;
        int i16 = ajVar.f116543u;
        if (ajVar.f116528f && z16 && ajVar.f116524b.isEmpty() && ajVar.f116535m < 9) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager", 2, "refreshHeadComplete : the list is empty after the filter, trying to get more. [ index:" + ajVar.f116535m + " ]");
            }
            ajVar.f116535m++;
            n(str, i3, i16, ajVar);
            return;
        }
        QLog.d("Q.msg.BaseMessageManager", 4, "refreshHeadComplete  setChangeAndNotify");
        ajVar.f116535m = 0;
        ajVar.f116536n = 0;
        if (ajVar.f116531i) {
            this.f116282e.setChangeAndNotify(ajVar);
        }
    }

    protected void N(aj ajVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            iPatchRedirector.redirect((short) 52, (Object) this, (Object) ajVar);
            return;
        }
        synchronized (this.f116285i) {
            if (ajVar.f116544v) {
                ajVar.f116544v = false;
                this.f116285i.notify();
                if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.BaseMessageManager", 2, "refreshMessageListHead notify");
                }
            }
        }
    }

    public Message Q(String str, int i3, EntityManager entityManager) {
        Message O;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Message) iPatchRedirector.redirect((short) 7, this, str, Integer.valueOf(i3), entityManager);
        }
        if (str == null) {
            return new Message();
        }
        D.r(this.f116281d, str, i3);
        String f16 = ao.f(str, i3);
        Message message = this.f116282e.getCachedMsg().get(f16);
        StringBuilder sb5 = new StringBuilder("CACHE : refreshSingleLastMsg:uin:" + str + " uinType:" + i3);
        if (message != null && message.isCacheValid) {
            if (QLog.isColorLevel()) {
                sb5.append(" : case 5 : not null or isValid : " + message);
            }
            O = null;
        } else {
            String w3 = D.w(MessageRecord.getTableName(str, i3), str);
            Message S = y(i3).S(w3, entityManager);
            if (S == null && (ao.r(i3) || i3 == 1 || i3 == 3000)) {
                w3 = MessageRecord.getOldTableName(str, i3);
                S = y(i3).S(w3, entityManager);
            }
            if (QLog.isColorLevel()) {
                sb5.append(" message:" + S);
            }
            if (S != null && S.uniseq == 0) {
                y(S.istroop).p(S.frienduin, S.istroop);
                S = y(S.istroop).S(w3, entityManager);
                if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.BaseMessageManager", 2, "CACHE : requeryLastMessage = " + S);
                }
            }
            if (S != null && S.isSendFromLocal() && S.extraflag == 32772 && !((com.tencent.mobileqq.service.message.e) this.f116281d.getMsgCache()).t1(S)) {
                QLog.e("Q.msg.BaseMessageManager", 1, "set sending message FAILED: ", S);
                S.setExtraFlag(32768);
            }
            if (S != null) {
                T(str, S);
                P(S);
            } else {
                S = new Message();
                S.frienduin = str;
                S.istroop = i3;
            }
            O = O(f16, S, sb5);
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager", 2, sb5.toString());
        }
        if (O != null && ao.z(O.frienduin, O.istroop)) {
            O.istroop = ao.c(O.istroop);
        }
        return O;
    }

    public Message R(String str, int i3, EntityManager entityManager, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Message) iPatchRedirector.redirect((short) 9, this, str, Integer.valueOf(i3), entityManager, Integer.valueOf(i16));
        }
        if (i3 == 1033 || i3 == 1034) {
            z16 = true;
        }
        if (z16) {
            return S(str, i3, entityManager, i16);
        }
        return Q(str, i3, entityManager);
    }

    public Message S(String str, int i3, EntityManager entityManager, int i16) {
        Message O;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Message) iPatchRedirector.redirect((short) 10, this, str, Integer.valueOf(i3), entityManager, Integer.valueOf(i16));
        }
        if (str == null) {
            return new Message();
        }
        String f16 = ao.f(str, i3);
        Message message = this.f116282e.getCachedMsg().get(f16);
        StringBuilder sb5 = new StringBuilder("CACHE : refreshSingleLastMsg:uin:" + str + " uinType:" + i3);
        if (message != null && message.isCacheValid && message.getConfessTopicId() == i16) {
            if (QLog.isColorLevel()) {
                sb5.append(" : case 5 : not null or isValid : " + message);
            }
            O = null;
        } else {
            String tableName = MessageRecord.getTableName(str, i3);
            Message T = y(i3).T(tableName, entityManager, i16);
            if (T != null && T.uniseq == 0) {
                y(T.istroop).p(T.frienduin, T.istroop);
                T = y(T.istroop).T(tableName, entityManager, i16);
                if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.BaseMessageManager", 2, "CACHE : requeryLastMessage = " + T);
                }
            }
            if (T == null) {
                T = new Message();
                T.frienduin = str;
                T.istroop = i3;
                T.setConfessTopicId(i16);
            }
            O = O(f16, T, sb5);
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager", 2, sb5.toString());
        }
        if (O != null && ao.z(O.frienduin, O.istroop)) {
            O.istroop = ao.c(O.istroop);
        }
        return O;
    }

    public void U(aj ajVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            iPatchRedirector.redirect((short) 53, (Object) this, (Object) ajVar);
            return;
        }
        synchronized (this.f116285i) {
            if (ajVar.f116544v) {
                try {
                    this.f116285i.wait(40000L);
                } catch (InterruptedException e16) {
                    e16.printStackTrace();
                }
                if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.BaseMessageManager", 2, "refreshTroopUnreadMessage wait over");
                }
            }
        }
    }

    public void V(MessageRecord messageRecord, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z18 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, messageRecord, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (D.s(messageRecord, arrayList)) {
            z18 = ao.D(messageRecord, this.f116282e.getLastMessage(messageRecord.frienduin, messageRecord.istroop));
        } else {
            arrayList.add(messageRecord);
            if (!this.f116282e.isTheLastTabMsg(messageRecord)) {
                z18 = false;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager", 2, "-->removeMsgByMessageRecord :" + messageRecord);
        }
        String f16 = ao.f(messageRecord.frienduin, messageRecord.istroop);
        if (this.f116282e.getCachedMsg().containsKey(f16)) {
            Message message = this.f116282e.getCachedMsg().get(f16);
            if (!messageRecord.isread && message != null) {
                this.f116283f.decreaseUnread(message.frienduin, message.istroop, message);
            }
        }
        this.f116282e.stopHttpProcessorIfNeed(messageRecord);
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            MessageRecord messageRecord2 = (MessageRecord) arrayList.get(i3);
            y(messageRecord2.istroop).u(messageRecord2, z17);
            ((com.tencent.mobileqq.service.message.e) this.f116281d.getMsgCache()).R(messageRecord2);
        }
        if (z16) {
            D.t(this.f116281d, null, messageRecord);
        }
        if (z18) {
            s0(messageRecord);
        }
        if (z17) {
            y(messageRecord.istroop).G0();
        }
        D.q(Collections.singletonList(messageRecord));
    }

    public void W(String str, int i3, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, str, Integer.valueOf(i3), str2, str3);
        } else {
            Y(str, i3, str2, str3, true);
        }
    }

    public void X(String str, int i3, String str2, String str3, int i16, int i17, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, str, Integer.valueOf(i3), str2, str3, Integer.valueOf(i16), Integer.valueOf(i17), Boolean.valueOf(z16));
        } else {
            D.e(this.f116281d, this, this.f116282e, str, i3, str2, str3, i16, i17, z16);
        }
    }

    public void Y(String str, int i3, String str2, String str3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, str, Integer.valueOf(i3), str2, str3, Boolean.valueOf(z16));
        } else {
            X(str, i3, str2, str3, i3, 0, z16);
        }
    }

    public void Z(List<? extends MessageRecord> list, boolean z16, boolean z17) {
        Message message;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z18 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, list, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        if (list.size() == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        MessageRecord messageRecord = list.get(0);
        for (int i3 = 1; i3 < list.size(); i3++) {
            MessageRecord messageRecord2 = list.get(i3);
            int i16 = messageRecord2.istroop;
            if (i16 != 1 && i16 != 3000) {
                long j3 = messageRecord2.time;
                long j16 = messageRecord.time;
                if (j3 <= j16) {
                    if (j3 == j16) {
                        if (messageRecord2.getId() <= messageRecord.getId()) {
                        }
                    }
                }
                messageRecord = messageRecord2;
            } else {
                long j17 = messageRecord2.shmsgseq;
                long j18 = messageRecord.shmsgseq;
                if (j17 <= j18) {
                    if (j17 == j18) {
                        if (messageRecord2.getId() <= messageRecord.getId()) {
                        }
                    }
                }
                messageRecord = messageRecord2;
            }
        }
        for (MessageRecord messageRecord3 : list) {
            if (!D.s(messageRecord3, arrayList)) {
                arrayList.add(messageRecord3);
            }
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager", 2, "-->removeMsgByMessageRecord :" + messageRecord3);
            }
            this.f116282e.stopHttpProcessorIfNeed(messageRecord3);
        }
        String f16 = ao.f(messageRecord.frienduin, messageRecord.istroop);
        if (this.f116282e.getCachedMsg().containsKey(f16) && (message = this.f116282e.getCachedMsg().get(f16)) != null) {
            ArrayList arrayList2 = new ArrayList();
            for (MessageRecord messageRecord4 : list) {
                if (!messageRecord4.isread) {
                    arrayList2.add(messageRecord4);
                }
            }
            if (arrayList2.size() != 0) {
                this.f116283f.decreaseUnreads(message.frienduin, message.istroop, arrayList2);
            }
        }
        y(messageRecord.istroop).v(arrayList, z17);
        Iterator<MessageRecord> it = arrayList.iterator();
        while (it.hasNext()) {
            ((com.tencent.mobileqq.service.message.e) this.f116281d.getMsgCache()).R(it.next());
        }
        if (z16) {
            D.t(this.f116281d, arrayList, null);
        }
        if (D.s(messageRecord, null)) {
            z18 = ao.D(messageRecord, this.f116282e.getLastMessage(messageRecord.frienduin, messageRecord.istroop));
        } else if (this.f116282e.isTheLastTabMsg(messageRecord)) {
            z18 = true;
        }
        if (z18) {
            s0(messageRecord);
        }
        if (z17) {
            y(messageRecord.istroop).G0();
        }
        D.q(list);
    }

    public void a(MessageRecord messageRecord, EntityManager entityManager, boolean z16, boolean z17, boolean z18, boolean z19, a aVar) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, messageRecord, entityManager, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), Boolean.valueOf(z19), aVar);
            return;
        }
        if (messageRecord == null) {
            return;
        }
        Map<String, MessageRecord> map = aVar.f116299d;
        if (messageRecord.time == 0) {
            messageRecord.time = com.tencent.mobileqq.service.message.e.K0();
        }
        if (messageRecord.msgseq == 0) {
            messageRecord.msgseq = (int) messageRecord.time;
        }
        String str = messageRecord.frienduin;
        int i16 = messageRecord.istroop;
        if (messageRecord.isSendFromLocal() && (((i3 = messageRecord.istroop) == 3000 || i3 == 1 || i3 == 0 || i3 == 10014) && messageRecord.extraflag == 0)) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager", 2, "addMessage set sendmsg extra " + messageRecord.getBaseInfoString());
            }
            messageRecord.setExtraFlag(32772);
            messageRecord.setSendFailCode(0);
        }
        Iterator<com.tencent.imcore.message.adder.h> it = this.f116282e.getRegistry().b().iterator();
        while (it.hasNext()) {
            it.next().a(this.f116281d, this, messageRecord, z16, z17, z19, map, str, i16);
        }
    }

    public void a0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            iPatchRedirector.redirect((short) 55, (Object) this);
            return;
        }
        synchronized (this.f116286m) {
            this.f116286m.notify();
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager", 2, "doMsgRevokeRequest notify");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this, (Object) str, i3);
        }
    }

    public void b0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            iPatchRedirector.redirect((short) 54, (Object) this);
            return;
        }
        synchronized (this.f116286m) {
            try {
                this.f116286m.wait(15000L);
                if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.BaseMessageManager", 2, "doMsgRevokeRequest wait over");
                }
            } catch (InterruptedException e16) {
                e16.printStackTrace();
                if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.BaseMessageManager", 2, "doMsgRevokeRequest wait interrupted");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(String str, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, this, str, Integer.valueOf(i3), Long.valueOf(j3));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c0(MessageRecord messageRecord, ProxyListener proxyListener, boolean z16, boolean z17, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            iPatchRedirector.redirect((short) 56, this, messageRecord, proxyListener, Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(i3));
        } else {
            y(messageRecord.istroop).c(messageRecord.frienduin, messageRecord.istroop, messageRecord, proxyListener, z16, z17, true);
            o0(messageRecord, true, i3);
        }
    }

    public void d(String str, int i3, int i16, aj ajVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, Integer.valueOf(i3), Integer.valueOf(i16), ajVar);
        } else if ((this instanceof C2CMessageManager) || (this instanceof BaseMessageManagerForTroopAndDisc)) {
            com.tencent.imcore.message.report.a.e(this.f116281d, ajVar);
        }
    }

    public void d0(String str, int i3, boolean z16, boolean z17) {
        String str2;
        boolean z18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, this, str, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager", 2, "setBoxReaded boxUin=" + str + ",boxType=" + i3 + ",needDelMark=" + z17);
        }
        if (str == null) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager", 2, "setBoxReaded return : boxUin=null");
                return;
            }
            return;
        }
        if (!ao.z(str, i3)) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager", 2, "setBoxReaded return : is not msgbox");
                return;
            }
            return;
        }
        DeprecatedMethodInvokeReport.d("Message", "MessageManager.setBoxReaded", DeprecatedMethodInvokeReport.b.a(i3, str, 0, ""));
        if (str.equals(AppConstants.LBS_HELLO_UIN)) {
            str2 = AppConstants.LBS_SAY_HELLO_LIST_UIN;
        } else if (str.equals(AppConstants.DATE_UIN)) {
            str2 = AppConstants.DATE_SAY_HELLO_LIST_UIN;
        } else {
            str2 = null;
        }
        String str3 = str2;
        long j3 = 0;
        if (str3 != null) {
            if (this.f116283f.getUnreadCount(str3, i3) > 0) {
                MessageRecord E = y(i3).E(str3, i3);
                IConversationFacade iConversationFacade = this.f116283f;
                if (E != null) {
                    j3 = A(E);
                }
                iConversationFacade.cleanUnread(str3, i3, j3, z16, z17);
                b(str3, i3);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager", 2, "setBoxReaded return : childbox unread = 0");
            }
        }
        if (this.f116283f.getUnreadCount(str, i3) > 0) {
            MessageRecord E2 = y(i3).E(str, i3);
            IConversationFacade iConversationFacade2 = this.f116283f;
            if (E2 != null) {
                j3 = A(E2);
            }
            iConversationFacade2.cleanUnread(str, i3, j3, z16, z17);
            b(str, i3);
            z18 = true;
        } else {
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager", 2, "setBoxReaded return : box unread = 0");
            }
            z18 = false;
        }
        if (str.equals(AppConstants.CONFESS_UIN)) {
            D.b(this.f116281d, true, true);
            D.b(this.f116281d, true, false);
        }
        if (z18) {
            IMessageFacade iMessageFacade = this.f116282e;
            iMessageFacade.setChangeAndNotify(iMessageFacade.getLastMessage(str, i3));
        }
    }

    public void e(String str, int i3, int i16, aj ajVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, Integer.valueOf(i3), Integer.valueOf(i16), ajVar);
            return;
        }
        ajVar.C = System.currentTimeMillis();
        ajVar.D = 0L;
        ajVar.E = 0L;
    }

    public int f(String str, int i3, boolean z16, boolean z17) {
        RecentUser findRecentUserByUin;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Integer) iPatchRedirector.redirect((short) 19, this, str, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17))).intValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager", 2, "clearHistory uin = " + str + ", type = " + i3 + ", needDeleteDB = " + z16);
        }
        if (com.tencent.imcore.message.config.b.a(str, i3)) {
            this.f116283f.removeUnreadItem(str, i3);
        }
        Message lastMessage = this.f116282e.getLastMessage(str, i3);
        int j3 = y(i3).j(str, i3, z16);
        if (i3 == 0) {
            D.D(this.f116281d, str);
        }
        if (3000 != i3 && 1 != i3 && 5000 != i3) {
            this.f116282e.clearTransFileInfo(str);
        }
        if (j3 > 0) {
            lastMessage.cleanMessageRecordBaseField();
        }
        if (i3 != 3000 && i3 != 1 && this.f116283f.isInMsgBox(str, ao.c(i3))) {
            if (ao.c(i3) == 1009) {
                g(str, AppConstants.SAME_STATE_BOX_UIN, 1009);
            } else if (ao.c(i3) == 1001) {
                g(str, AppConstants.LBS_HELLO_UIN, 1001);
            } else if (ao.c(i3) == 1010) {
                g(str, AppConstants.DATE_UIN, 1010);
            } else if (ao.c(i3) == 10002) {
                g(str, AppConstants.LBS_HELLO_UIN, 10002);
            } else if (ao.c(i3) == 1044) {
                g(str, AppConstants.MATCH_CHAT_UIN, 1044);
            } else if (ao.c(i3) == 10008) {
                g(str, AppConstants.QCIRCLE_CHAT_UIN, 10008);
            }
        }
        if (z17 && (findRecentUserByUin = ((IRecentUserProxyService) this.f116281d.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache().findRecentUserByUin(str, lastMessage.istroop)) != null) {
            this.f116282e.removeRecentUser(findRecentUserByUin);
        }
        this.f116282e.getCachedMsg().remove(ao.f(str, i3));
        this.f116282e.setChangeAndNotify(lastMessage);
        return j3;
    }

    public void f0(MessageForUniteGrayTip messageForUniteGrayTip, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 68)) {
            iPatchRedirector.redirect((short) 68, (Object) this, (Object) messageForUniteGrayTip, (Object) bundle);
        } else {
            D.o(messageForUniteGrayTip, bundle);
        }
    }

    public void g(String str, String str2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, str, str2, Integer.valueOf(i3));
            return;
        }
        W(str2, i3, str, this.f116281d.getAccount());
        Message lastMessage = this.f116282e.getLastMessage(str2, i3);
        String str3 = lastMessage.senderuin;
        if (str3 != null && str3.equals(str)) {
            lastMessage.cleanMessageRecordBaseField();
        }
    }

    public void g0(String str, int i3, long j3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, this, str, Integer.valueOf(i3), Long.valueOf(j3), Boolean.valueOf(z16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager", 2, "setReadFrom uin=" + str + ",type=" + i3 + MttLoader.QQBROWSER_PARAMS_FROME + j3 + ",force=" + z16);
        }
        if (j3 < 0) {
            return;
        }
        if (str == null) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager", 2, "setReadFrom return : uin=null");
            }
        } else if (this.f116283f.getUnreadCount(str, i3) <= 0 && !z16) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager", 2, "setReadFrom return : unread=0");
            }
            this.f116283f.cleanUnread(str, i3, j3, true);
        } else {
            this.f116283f.cleanUnreadFrom(str, i3, j3);
            c(str, i3, j3);
            IMessageFacade iMessageFacade = this.f116282e;
            iMessageFacade.setChangeAndNotify(iMessageFacade.getLastMessage(str, i3));
            H(str, i3);
        }
    }

    public void h(Message message) throws Throwable {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) message);
            return;
        }
        if (message == null) {
            return;
        }
        DeprecatedMethodInvokeReport.d("Message", "MessageManager.decodeMsg", "");
        if (i(message)) {
            return;
        }
        Iterator<com.tencent.imcore.message.decoder.j> it = this.f116282e.getRegistry().l().iterator();
        while (it.hasNext()) {
            it.next().a(message, this, this.f116281d);
        }
    }

    public void h0(String str, int i3, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, this, str, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17));
        } else {
            i0(str, i3, z16, z17, 0);
        }
    }

    public void i0(String str, int i3, boolean z16, boolean z17, int i16) {
        long j3;
        long j16;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z18 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, this, str, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(i16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager", 2, "setReaded uin=" + str + ",type=" + i3 + ",needDelMark=" + z17);
        }
        if (str == null) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager", 2, "setReaded return : uin=null");
                return;
            }
            return;
        }
        DeprecatedMethodInvokeReport.d("Message", "MessageManager.setReaded", DeprecatedMethodInvokeReport.b.a(i3, str, 0, ""));
        boolean G = G(str, i3);
        if (i3 != 1033 && i3 != 1034) {
            if (this.f116283f.getUnreadCount(str, i3) > 0) {
                MessageRecord E = y(i3).E(str, i3);
                IConversationFacade iConversationFacade = this.f116283f;
                if (E != null) {
                    j16 = A(E);
                } else {
                    j16 = 0;
                }
                iConversationFacade.cleanUnread(str, i3, j16, z16, z17);
                b(str, i3);
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.BaseMessageManager", 2, "setReaded return : unread=0");
                }
                z18 = G;
            }
        } else if (this.f116283f.getUnreadCountConfess(str, i3, i16) > 0) {
            MessageRecord F = y(i3).F(str, i3, i16);
            IConversationFacade iConversationFacade2 = this.f116283f;
            if (F != null) {
                j3 = A(F);
            } else {
                j3 = 0;
            }
            iConversationFacade2.cleanUnread(str, i3, j3, z16, z17, i16);
            b(str, i3);
        } else {
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager", 2, "setReaded return : unread=0");
            }
            z18 = G;
        }
        if (z18) {
            IMessageFacade iMessageFacade = this.f116282e;
            iMessageFacade.setChangeAndNotify(iMessageFacade.getLastMessage(str, i3, i16));
            H(str, i3);
        }
    }

    public void j(ArrayList<RevokeMsgInfo> arrayList, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 66)) {
            iPatchRedirector.redirect((short) 66, this, arrayList, Boolean.valueOf(z16));
        } else {
            if (com.tencent.mobileqq.graytip.f.c()) {
                synchronized (this.C) {
                    k(arrayList, z16);
                }
                return;
            }
            k(arrayList, z16);
        }
    }

    public void k0(String str, int i3, MessageRecord messageRecord, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            iPatchRedirector.redirect((short) 51, this, str, Integer.valueOf(i3), messageRecord, Integer.valueOf(i16));
            return;
        }
        if (i3 != 3000 && i3 != 1) {
            long x16 = x(str, i3);
            if (x16 != 0) {
                if (ao.c(i3) == 1009) {
                    IMessageFacade iMessageFacade = this.f116282e;
                    String str2 = AppConstants.SAME_STATE_BOX_UIN;
                    Message lastMessage = iMessageFacade.getLastMessage(str2, 1009);
                    String str3 = lastMessage.senderuin;
                    if (str3 != null && str3.equals(str)) {
                        MessageRecord createMsgRecordByMsgType = ((IMessageRecordFactory) QRoute.api(IMessageRecordFactory.class)).createMsgRecordByMsgType(messageRecord.msgtype);
                        MessageRecord.copyMessageRecordBaseField(createMsgRecordByMsgType, messageRecord);
                        createMsgRecordByMsgType.selfuin = messageRecord.selfuin;
                        createMsgRecordByMsgType.senderuin = messageRecord.frienduin;
                        createMsgRecordByMsgType.frienduin = str2;
                        if (i16 == 3) {
                            o0(createMsgRecordByMsgType, true, i16);
                            y(i3).C0(str2, 1009, x16, messageRecord.extraflag, lastMessage.sendFailCode);
                            y(i3).E0(str2, 1009, x16, messageRecord.time, messageRecord.shmsgseq);
                            return;
                        } else if (i16 == 2) {
                            o0(createMsgRecordByMsgType, true, i16);
                            y(i3).A0(str2, 1009, x16, messageRecord.f203106msg);
                            return;
                        } else {
                            if (i16 == 4) {
                                y(i3).k(str2, 1009, createMsgRecordByMsgType.senderuin, createMsgRecordByMsgType.selfuin, 0);
                                c0(createMsgRecordByMsgType, null, false, true, i16);
                                o0(createMsgRecordByMsgType, true, i16);
                                return;
                            }
                            return;
                        }
                    }
                    return;
                }
                if (ao.c(i3) != 1001 && ao.c(i3) != 10002) {
                    if (ao.c(i3) == 1010) {
                        boolean B = ao.B(messageRecord);
                        if (B) {
                            z16 = this.f116283f.isInMsgBox(str, 1010, AppConstants.DATE_UIN);
                        }
                        if (B && !z16) {
                            IMessageFacade iMessageFacade2 = this.f116282e;
                            String str4 = AppConstants.DATE_SAY_HELLO_LIST_UIN;
                            Message lastMessage2 = iMessageFacade2.getLastMessage(str4, 1010);
                            String str5 = lastMessage2.senderuin;
                            if (str5 != null && str5.equals(str)) {
                                MessageRecord createMsgRecordByMsgType2 = ((IMessageRecordFactory) QRoute.api(IMessageRecordFactory.class)).createMsgRecordByMsgType(messageRecord.msgtype);
                                MessageRecord.copyMessageRecordBaseField(createMsgRecordByMsgType2, messageRecord);
                                createMsgRecordByMsgType2.frienduin = str4;
                                createMsgRecordByMsgType2.senderuin = messageRecord.frienduin;
                                createMsgRecordByMsgType2.istroop = lastMessage2.istroop;
                                MessageRecord createMsgRecordByMsgType3 = ((IMessageRecordFactory) QRoute.api(IMessageRecordFactory.class)).createMsgRecordByMsgType(messageRecord.msgtype);
                                MessageRecord.copyMessageRecordBaseField(createMsgRecordByMsgType3, messageRecord);
                                String str6 = AppConstants.DATE_UIN;
                                createMsgRecordByMsgType3.frienduin = str6;
                                createMsgRecordByMsgType3.senderuin = str4;
                                createMsgRecordByMsgType3.istroop = lastMessage2.istroop;
                                Message lastMessage3 = this.f116282e.getLastMessage(str6, 1010);
                                if (i16 == 3) {
                                    o0(createMsgRecordByMsgType2, true, i16);
                                    y(i3).C0(str4, 1010, x16, messageRecord.extraflag, createMsgRecordByMsgType2.sendFailCode);
                                    y(i3).E0(str4, 1010, x16, messageRecord.time, messageRecord.shmsgseq);
                                    String str7 = lastMessage3.senderuin;
                                    if (str7 != null && str7.equals(str4)) {
                                        o0(createMsgRecordByMsgType3, true, i16);
                                        y(i3).C0(str6, 1010, x16, messageRecord.extraflag, createMsgRecordByMsgType3.sendFailCode);
                                        y(i3).E0(str6, 1010, x16, messageRecord.time, messageRecord.shmsgseq);
                                        return;
                                    }
                                    return;
                                }
                                if (i16 == 2) {
                                    o0(createMsgRecordByMsgType2, true, i16);
                                    y(i3).A0(str4, 1010, x16, messageRecord.f203106msg);
                                    String str8 = lastMessage3.senderuin;
                                    if (str8 != null && str8.equals(str4)) {
                                        o0(createMsgRecordByMsgType3, true, i16);
                                        y(i3).A0(str6, 1010, x16, messageRecord.f203106msg);
                                        return;
                                    }
                                    return;
                                }
                                if (i16 == 4) {
                                    y(i3).k(str4, 1010, createMsgRecordByMsgType2.senderuin, createMsgRecordByMsgType2.selfuin, 0);
                                    c0(createMsgRecordByMsgType2, null, false, true, 1);
                                    y(i3).k(str6, 1010, createMsgRecordByMsgType3.senderuin, createMsgRecordByMsgType3.selfuin, 0);
                                    c0(createMsgRecordByMsgType3, null, false, true, 1);
                                    o0(createMsgRecordByMsgType2, true, i16);
                                    String str9 = lastMessage3.senderuin;
                                    if (str9 != null && str9.equals(str4)) {
                                        o0(createMsgRecordByMsgType3, true, i16);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        IMessageFacade iMessageFacade3 = this.f116282e;
                        String str10 = AppConstants.DATE_UIN;
                        Message lastMessage4 = iMessageFacade3.getLastMessage(str10, 1010);
                        String str11 = lastMessage4.senderuin;
                        if (str11 != null && str11.equals(str)) {
                            MessageRecord createMsgRecordByMsgType4 = ((IMessageRecordFactory) QRoute.api(IMessageRecordFactory.class)).createMsgRecordByMsgType(messageRecord.msgtype);
                            MessageRecord.copyMessageRecordBaseField(createMsgRecordByMsgType4, messageRecord);
                            createMsgRecordByMsgType4.selfuin = messageRecord.selfuin;
                            createMsgRecordByMsgType4.senderuin = messageRecord.frienduin;
                            createMsgRecordByMsgType4.frienduin = str10;
                            if (i16 == 3) {
                                o0(createMsgRecordByMsgType4, true, i16);
                                y(i3).C0(str10, 1010, x16, messageRecord.extraflag, lastMessage4.sendFailCode);
                                y(i3).E0(str10, 1010, x16, messageRecord.time, messageRecord.shmsgseq);
                                return;
                            } else if (i16 == 2) {
                                o0(createMsgRecordByMsgType4, true, i16);
                                y(i3).A0(str10, 1010, x16, messageRecord.f203106msg);
                                return;
                            } else {
                                if (i16 == 4) {
                                    y(i3).k(str10, 1010, createMsgRecordByMsgType4.senderuin, createMsgRecordByMsgType4.selfuin, 0);
                                    c0(createMsgRecordByMsgType4, null, false, true, i16);
                                    o0(createMsgRecordByMsgType4, true, i16);
                                    return;
                                }
                                return;
                            }
                        }
                        return;
                    }
                    return;
                }
                int c16 = ao.c(i3);
                boolean B2 = ao.B(messageRecord);
                if (B2) {
                    z16 = this.f116283f.isInMsgBox(str, c16, AppConstants.LBS_HELLO_UIN);
                }
                if (B2 && !z16) {
                    IMessageFacade iMessageFacade4 = this.f116282e;
                    String str12 = AppConstants.LBS_SAY_HELLO_LIST_UIN;
                    Message lastMessage5 = iMessageFacade4.getLastMessage(str12, c16);
                    String str13 = lastMessage5.senderuin;
                    if (str13 != null && str13.equals(str)) {
                        MessageRecord createMsgRecordByMsgType5 = ((IMessageRecordFactory) QRoute.api(IMessageRecordFactory.class)).createMsgRecordByMsgType(messageRecord.msgtype);
                        MessageRecord.copyMessageRecordBaseField(createMsgRecordByMsgType5, messageRecord);
                        createMsgRecordByMsgType5.frienduin = str12;
                        createMsgRecordByMsgType5.senderuin = messageRecord.frienduin;
                        createMsgRecordByMsgType5.istroop = lastMessage5.istroop;
                        MessageRecord createMsgRecordByMsgType6 = ((IMessageRecordFactory) QRoute.api(IMessageRecordFactory.class)).createMsgRecordByMsgType(messageRecord.msgtype);
                        MessageRecord.copyMessageRecordBaseField(createMsgRecordByMsgType6, messageRecord);
                        String str14 = AppConstants.LBS_HELLO_UIN;
                        createMsgRecordByMsgType6.frienduin = str14;
                        createMsgRecordByMsgType6.senderuin = str12;
                        createMsgRecordByMsgType6.istroop = lastMessage5.istroop;
                        Message lastMessage6 = this.f116282e.getLastMessage(str14, c16);
                        if (i16 == 3) {
                            o0(createMsgRecordByMsgType5, true, i16);
                            y(i3).C0(str12, c16, x16, messageRecord.extraflag, createMsgRecordByMsgType5.sendFailCode);
                            y(i3).E0(str12, c16, x16, messageRecord.time, messageRecord.shmsgseq);
                            String str15 = lastMessage6.senderuin;
                            if (str15 != null && str15.equals(str12)) {
                                o0(createMsgRecordByMsgType6, true, i16);
                                y(i3).C0(str14, c16, x16, messageRecord.extraflag, createMsgRecordByMsgType6.sendFailCode);
                                y(i3).E0(str14, c16, x16, messageRecord.time, messageRecord.shmsgseq);
                                return;
                            }
                            return;
                        }
                        if (i16 == 2) {
                            o0(createMsgRecordByMsgType5, true, i16);
                            y(i3).A0(str12, c16, x16, messageRecord.f203106msg);
                            String str16 = lastMessage6.senderuin;
                            if (str16 != null && str16.equals(str12)) {
                                o0(createMsgRecordByMsgType6, true, i16);
                                y(i3).A0(str14, c16, x16, messageRecord.f203106msg);
                                return;
                            }
                            return;
                        }
                        if (i16 == 4) {
                            y(i3).k(str12, c16, createMsgRecordByMsgType5.senderuin, createMsgRecordByMsgType5.selfuin, 0);
                            c0(createMsgRecordByMsgType5, null, false, true, 1);
                            y(i3).k(str14, c16, createMsgRecordByMsgType6.senderuin, createMsgRecordByMsgType6.selfuin, 0);
                            c0(createMsgRecordByMsgType6, null, false, true, 1);
                            o0(createMsgRecordByMsgType5, true, i16);
                            String str17 = lastMessage6.senderuin;
                            if (str17 != null && str17.equals(str12)) {
                                o0(createMsgRecordByMsgType6, true, i16);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                IMessageFacade iMessageFacade5 = this.f116282e;
                String str18 = AppConstants.LBS_HELLO_UIN;
                Message lastMessage7 = iMessageFacade5.getLastMessage(str18, c16);
                String str19 = lastMessage7.senderuin;
                if (str19 != null && str19.equals(str)) {
                    MessageRecord createMsgRecordByMsgType7 = ((IMessageRecordFactory) QRoute.api(IMessageRecordFactory.class)).createMsgRecordByMsgType(messageRecord.msgtype);
                    MessageRecord.copyMessageRecordBaseField(createMsgRecordByMsgType7, messageRecord);
                    createMsgRecordByMsgType7.selfuin = messageRecord.selfuin;
                    createMsgRecordByMsgType7.senderuin = messageRecord.frienduin;
                    createMsgRecordByMsgType7.frienduin = str18;
                    if (i16 == 3) {
                        o0(createMsgRecordByMsgType7, true, i16);
                        y(i3).C0(str18, c16, x16, messageRecord.extraflag, lastMessage7.sendFailCode);
                        y(i3).E0(str18, c16, x16, messageRecord.time, messageRecord.shmsgseq);
                    } else if (i16 == 2) {
                        o0(createMsgRecordByMsgType7, true, i16);
                        y(i3).A0(str18, c16, x16, messageRecord.f203106msg);
                    } else if (i16 == 4) {
                        y(i3).k(str18, c16, createMsgRecordByMsgType7.senderuin, createMsgRecordByMsgType7.selfuin, 0);
                        c0(createMsgRecordByMsgType7, null, false, true, i16);
                        o0(createMsgRecordByMsgType7, true, i16);
                    }
                }
            }
        }
    }

    public boolean l(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 61)) {
            return ((Boolean) iPatchRedirector.redirect((short) 61, (Object) this, (Object) messageRecord)).booleanValue();
        }
        return D.p(this, messageRecord);
    }

    public void l0(String str, int i3, MessageRecord messageRecord, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            iPatchRedirector.redirect((short) 50, this, str, Integer.valueOf(i3), messageRecord, Integer.valueOf(i16));
            return;
        }
        List<MessageRecord> p16 = y(i3).p(str, i3);
        Message lastMessage = this.f116282e.getLastMessage(str, i3);
        if (messageRecord != null && messageRecord.isLongMsg()) {
            if (ao.D(messageRecord, lastMessage)) {
                if ((i16 == 3 && messageRecord.extraflag == 32768) || messageRecord.longMsgIndex == lastMessage.longMsgIndex) {
                    o0(messageRecord, true, i16);
                    k0(str, i3, messageRecord, i16);
                    return;
                }
                return;
            }
            return;
        }
        if (messageRecord != null && p16 != null && !p16.isEmpty() && messageRecord.uniseq == p16.get(p16.size() - 1).uniseq) {
            o0(messageRecord, true, i16);
            k0(str, i3, messageRecord, i16);
        }
    }

    public void m(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            iPatchRedirector.redirect((short) 59, (Object) this, (Object) messageRecord);
        }
    }

    public void m0(String str, int i3, String str2, String str3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, this, str, Integer.valueOf(i3), str2, str3, Long.valueOf(j3));
        } else {
            D.C(this.f116281d, this.f116282e, this.f116283f, str, i3, str2, str3, j3);
        }
    }

    public abstract void n(String str, int i3, int i16, aj ajVar);

    public void n0(MessageRecord messageRecord) {
        Message lastMessage;
        String str;
        String str2;
        String str3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            iPatchRedirector.redirect((short) 57, (Object) this, (Object) messageRecord);
            return;
        }
        MessageRecord lastMsgForMsgTabWithAutoInit = this.f116282e.getLastMsgForMsgTabWithAutoInit(messageRecord.frienduin, messageRecord.istroop);
        if (lastMsgForMsgTabWithAutoInit != null) {
            o0(lastMsgForMsgTabWithAutoInit, true, 4);
            k0(lastMsgForMsgTabWithAutoInit.frienduin, lastMsgForMsgTabWithAutoInit.istroop, lastMsgForMsgTabWithAutoInit, 4);
            return;
        }
        String account = this.f116281d.getAccount();
        int c16 = ao.c(messageRecord.istroop);
        if (c16 != 1001 && c16 != 10002) {
            if (ao.c(messageRecord.istroop) == 1009) {
                String str4 = AppConstants.SAME_STATE_BOX_UIN;
                W(str4, 1009, messageRecord.frienduin, account);
                lastMessage = this.f116282e.getLastMessage(str4, 1009);
            } else {
                if (ao.c(messageRecord.istroop) == 1010) {
                    if (ao.B(messageRecord)) {
                        String str5 = AppConstants.DATE_SAY_HELLO_LIST_UIN;
                        W(str5, 1010, messageRecord.frienduin, account);
                        Message lastMessage2 = this.f116282e.getLastMessage(str5, 1010);
                        if (lastMessage2 != null && (str3 = lastMessage2.senderuin) != null && str3.equals(messageRecord.frienduin)) {
                            lastMessage2.cleanMessageRecordBaseField();
                        }
                    } else {
                        String str6 = AppConstants.DATE_UIN;
                        W(str6, 1010, messageRecord.frienduin, account);
                        lastMessage = this.f116282e.getLastMessage(str6, 1010);
                    }
                }
                lastMessage = null;
            }
        } else if (ao.B(messageRecord)) {
            String str7 = AppConstants.LBS_SAY_HELLO_LIST_UIN;
            W(str7, c16, messageRecord.frienduin, account);
            Message lastMessage3 = this.f116282e.getLastMessage(str7, c16);
            if (lastMessage3 != null && (str = lastMessage3.senderuin) != null && str.equals(messageRecord.frienduin)) {
                lastMessage3.cleanMessageRecordBaseField();
            }
            lastMessage = null;
        } else {
            String str8 = AppConstants.LBS_HELLO_UIN;
            W(str8, c16, messageRecord.frienduin, account);
            lastMessage = this.f116282e.getLastMessage(str8, c16);
        }
        if (lastMessage != null && (str2 = lastMessage.senderuin) != null && str2.equals(messageRecord.frienduin)) {
            lastMessage.cleanMessageRecordBaseField();
        }
    }

    public void o(ArrayList<RevokeMsgInfo> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 63)) {
            iPatchRedirector.redirect((short) 63, (Object) this, (Object) arrayList);
        } else {
            if (com.tencent.mobileqq.graytip.f.c()) {
                synchronized (this.C) {
                    p(arrayList);
                }
                return;
            }
            p(arrayList);
        }
    }

    public boolean o0(MessageRecord messageRecord, boolean z16, int i3) {
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z18 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return ((Boolean) iPatchRedirector.redirect((short) 41, this, messageRecord, Boolean.valueOf(z16), Integer.valueOf(i3))).booleanValue();
        }
        if (messageRecord == null) {
            return false;
        }
        if (messageRecord.isLongMsg()) {
            if (((com.tencent.mobileqq.service.message.e) this.f116281d.getMsgCache()).p1(messageRecord)) {
                z0(messageRecord, i3);
                return false;
            }
            messageRecord = this.f116282e.findLongMsgHead(messageRecord);
        }
        MessageRecord messageRecord2 = messageRecord;
        if (messageRecord2.istroop == 1036 || D.f(this.f116281d, messageRecord2) || !messageRecord2.isValid || ad.D(messageRecord2.msgtype)) {
            return false;
        }
        if (messageRecord2.frienduin.equals(AppConstants.MAYKNOW_RECOMMEND_UIN) && messageRecord2.istroop == 0) {
            return false;
        }
        if (messageRecord2.frienduin.equals(AppConstants.FRIEND_ANNIVER_UIN) && messageRecord2.istroop == 0) {
            return false;
        }
        Message lastMessage = this.f116282e.getLastMessage(messageRecord2.frienduin, messageRecord2.istroop);
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager", 2, "updateMsgTab getLastMessage " + lastMessage.getBaseInfoString());
        }
        if (x0(messageRecord2)) {
            return false;
        }
        if (i3 == 1) {
            boolean p06 = p0(messageRecord2, lastMessage);
            if (ao.D(messageRecord2, lastMessage)) {
                if (messageRecord2.longMsgIndex >= lastMessage.longMsgIndex) {
                    return false;
                }
                z17 = false;
            } else {
                z17 = p06;
            }
            z18 = q0(messageRecord2, z16, false, lastMessage, z17);
        } else if (i3 != 4 && i3 != 2) {
            if (i3 == 3) {
                y0(messageRecord2, lastMessage);
            } else {
                z18 = false;
            }
        } else {
            t0(messageRecord2, z16, lastMessage);
        }
        w0(z18, lastMessage);
        return z18;
    }

    protected boolean p0(MessageRecord messageRecord, Message message) {
        boolean u06;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            return ((Boolean) iPatchRedirector.redirect((short) 46, (Object) this, (Object) messageRecord, (Object) message)).booleanValue();
        }
        int i3 = messageRecord.istroop;
        if (i3 != 3000) {
            u06 = true;
            if (i3 != 1 && i3 != 10014) {
                if (!ao.r(i3) || messageRecord.isSendFromLocal() || messageRecord.time >= message.time) {
                    u06 = false;
                }
                if (!ao.w(messageRecord.senderuin) && TextUtils.equals(messageRecord.senderuin, message.senderuin)) {
                    return false;
                }
                return u06;
            }
        }
        u06 = u0(messageRecord, message, false);
        if (!ao.w(messageRecord.senderuin)) {
        }
        return u06;
    }

    public List<MessageRecord> q(List<MessageRecord> list, String str, int i3, ArrayList<RevokeMsgInfo> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 60)) {
            return (List) iPatchRedirector.redirect((short) 60, this, list, str, Integer.valueOf(i3), arrayList);
        }
        if (i3 == 3000 || i3 == 1) {
            z16 = true;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<RevokeMsgInfo> it = arrayList.iterator();
        while (it.hasNext()) {
            RevokeMsgInfo next = it.next();
            for (MessageRecord messageRecord : list) {
                if (z16 && messageRecord.shmsgseq == next.f281287e) {
                    if (!messageRecord.isSendFromLocal() || messageRecord.extraflag == 0) {
                        if (!ad.B(messageRecord)) {
                            arrayList2.add(messageRecord);
                        }
                    }
                }
                if (!z16 && messageRecord.shmsgseq == next.f281287e && messageRecord.msgUid == next.f281291m && TextUtils.equals(messageRecord.senderuin, next.f281289h)) {
                    arrayList2.add(messageRecord);
                }
            }
        }
        return arrayList2;
    }

    public boolean q0(MessageRecord messageRecord, boolean z16, boolean z17, Message message, boolean z18) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z19 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            return ((Boolean) iPatchRedirector.redirect((short) 45, this, messageRecord, Boolean.valueOf(z16), Boolean.valueOf(z17), message, Boolean.valueOf(z18))).booleanValue();
        }
        if (!z18) {
            t0(messageRecord, z16, message);
            z17 = true;
        }
        if (!messageRecord.isSend() && !com.tencent.mobileqq.service.message.s.j(messageRecord.msgtype)) {
            message.hasReply = true;
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager", 2, "updateMsgTab = " + message + ",hasReply=" + message.hasReply);
            }
        }
        int i16 = messageRecord.istroop;
        if (i16 == 1033 || i16 == 1034) {
            z19 = true;
        }
        if ((!messageRecord.isSendFromLocal() && !messageRecord.isread && !z19) || (i3 = messageRecord.msgtype) == -1013 || i3 == -1019 || i3 == -1018) {
            v0(messageRecord, message, z18);
        }
        return z17;
    }

    public List<ChatMessage> r(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (List) iPatchRedirector.redirect((short) 24, (Object) this, (Object) str, i3);
        }
        return s(str, i3, -1L);
    }

    public void r0(MessageRecord messageRecord) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            iPatchRedirector.redirect((short) 58, (Object) this, (Object) messageRecord);
            return;
        }
        String str = messageRecord.frienduin;
        int i16 = messageRecord.istroop;
        String f16 = ao.f(str, i16);
        if (this.f116282e.getCachedMsg().containsKey(f16)) {
            if (i16 == 1026) {
                i3 = 1;
            } else {
                i3 = i16;
            }
            RecentUser findRecentUser = ((IRecentUserProxyService) this.f116281d.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache().findRecentUser(str, i3);
            MessageRecord lastMsgForMsgTabWithAutoInit = this.f116282e.getLastMsgForMsgTabWithAutoInit(str, i16);
            if (lastMsgForMsgTabWithAutoInit != null) {
                o0(lastMsgForMsgTabWithAutoInit, true, 4);
                if (findRecentUser != null) {
                    int i17 = lastMsgForMsgTabWithAutoInit.istroop;
                    if (i17 == 1000 || i17 == 1020 || i17 == 1004) {
                        findRecentUser.troopUin = lastMsgForMsgTabWithAutoInit.senderuin;
                    }
                    findRecentUser.setType(i3);
                    findRecentUser.lastmsgtime = lastMsgForMsgTabWithAutoInit.time;
                    D.a(this.f116281d, findRecentUser);
                    ((IRecentUserProxyService) this.f116281d.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache().saveRecentUser(findRecentUser);
                }
            } else if (findRecentUser != null) {
                if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.BaseMessageManager", 2, "updateMsgTabAfterDelMsg : No MessageRecord for replacing the mstTab, delete the ru.");
                }
                this.f116282e.removeRecentUser(findRecentUser);
                this.f116282e.getCachedMsg().remove(f16);
            }
            if (findRecentUser != null) {
                this.f116282e.setChangeAndNotify(findRecentUser);
            }
        }
    }

    public List<ChatMessage> s(String str, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (List) iPatchRedirector.redirect((short) 25, this, str, Integer.valueOf(i3), Long.valueOf(j3));
        }
        return u(str, i3, j3, false);
    }

    public void s0(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) messageRecord);
        } else {
            D.m(this.f116281d, this.f116282e, this, messageRecord);
        }
    }

    public List<ChatMessage> t(String str, int i3, long j3, int i16, boolean z16) {
        List<MessageRecord> A;
        ArrayList arrayList;
        ArrayList arrayList2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (List) iPatchRedirector.redirect((short) 27, this, str, Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16), Boolean.valueOf(z16));
        }
        if (j3 >= 0) {
            A = y(i3).B(str, i3, j3, i16);
        } else {
            A = y(i3).A(str, i3, i16, true);
        }
        if (A == null) {
            return new ArrayList();
        }
        ArrayList<MessageRecord> arrayList3 = new ArrayList(A.size());
        arrayList3.addAll(A);
        D.i(this, this.f116281d, i3, str, arrayList3, null, false, true);
        D.pretreatmentAIOMsg(i3, arrayList3, this.f116281d);
        ad.P(str, i3, arrayList3, (com.tencent.mobileqq.service.message.e) this.f116281d.getMsgCache());
        D.z(this.f116282e, str, i3, arrayList3, this);
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager", 2, "newAIOCursor clone " + Integer.valueOf(arrayList3.size()));
        }
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        for (MessageRecord messageRecord : arrayList3) {
            Iterator<com.tencent.imcore.message.aiolist.f> it = this.f116282e.getRegistry().d().iterator();
            MessageRecord messageRecord2 = messageRecord;
            while (true) {
                if (it.hasNext()) {
                    arrayList = arrayList6;
                    arrayList2 = arrayList5;
                    Object[] a16 = it.next().a(this.f116281d, str, i3, z16, arrayList4, arrayList5, arrayList6, messageRecord2);
                    messageRecord2 = (MessageRecord) a16[0];
                    if (((Boolean) a16[1]).booleanValue()) {
                        break;
                    }
                    arrayList6 = arrayList;
                    arrayList5 = arrayList2;
                } else {
                    arrayList = arrayList6;
                    arrayList2 = arrayList5;
                    break;
                }
            }
            arrayList6 = arrayList;
            arrayList5 = arrayList2;
        }
        ArrayList arrayList7 = arrayList6;
        ArrayList arrayList8 = arrayList5;
        if (!z16) {
            D.F(this.f116281d, arrayList8, arrayList7);
        }
        return arrayList4;
    }

    protected void t0(MessageRecord messageRecord, boolean z16, Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            iPatchRedirector.redirect((short) 48, this, messageRecord, Boolean.valueOf(z16), message);
            return;
        }
        MessageRecord.copyMessageRecordBaseField(message, messageRecord);
        message.emoRecentMsg = null;
        message.fileType = -1;
        message.lastMsg = null;
        if (!z16 && D.k(this.f116281d, message)) {
            z16 = true;
        }
        if (z16) {
            try {
                h(message);
            } catch (Throwable th5) {
                if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.BaseMessageManager", 2, "updateMsgTab ERROR", th5);
                }
            }
        }
    }

    public List<ChatMessage> u(String str, int i3, long j3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (List) iPatchRedirector.redirect((short) 26, this, str, Integer.valueOf(i3), Long.valueOf(j3), Boolean.valueOf(z16));
        }
        return t(str, i3, j3, 0, z16);
    }

    protected boolean u0(MessageRecord messageRecord, Message message, boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            return ((Boolean) iPatchRedirector.redirect((short) 49, this, messageRecord, message, Boolean.valueOf(z16))).booleanValue();
        }
        int i16 = (int) (message.shmsgseq - messageRecord.shmsgseq);
        int i17 = messageRecord.msgtype;
        if (i17 == -1012 || i17 == -5021) {
            int i18 = message.msgtype;
            if (i18 == -1012 || i18 == -5021) {
                z17 = true;
            }
            if (i16 == 0) {
                if (z17) {
                    i3 = (int) (message.time - messageRecord.time);
                } else {
                    i3 = -1;
                }
                i16 = i3;
            }
            if (i16 > 0) {
                z16 = true;
            }
            if (QLog.isColorLevel()) {
                QLog.d("GrayTipsForTroop", 2, "updateMsgTab mrIsOld " + z16);
            }
        }
        if (!messageRecord.isSendFromLocal() && i16 > 0) {
            return true;
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public List<MessageRecord> v(AppRuntime appRuntime, String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (List) iPatchRedirector.redirect((short) 28, this, appRuntime, str, Integer.valueOf(i3));
        }
        return this.f116284h.b().get(ao.f(str, i3));
    }

    public void w0(boolean z16, Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, this, Boolean.valueOf(z16), message);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager", 2, "updateMsgTab fin " + message.getBaseInfoString() + " , result = " + z16);
        }
        if (ao.z(message.frienduin, message.istroop)) {
            message.istroop = ao.c(message.istroop);
        }
    }

    public boolean x0(MessageRecord messageRecord) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return ((Boolean) iPatchRedirector.redirect((short) 42, (Object) this, (Object) messageRecord)).booleanValue();
        }
        if ((messageRecord.isBlessMsg || messageRecord.isCheckNeedShowInListTypeMsg) && com.tencent.mobileqq.service.message.remote.a.b(messageRecord.issend)) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager", 2, "updateMsgTab isBlessMsg:" + messageRecord.isBlessMsg + " needUpdateMsgTag:" + messageRecord.needUpdateMsgTag + " isCheckNeedShowInListTypeMsg:" + messageRecord.isCheckNeedShowInListTypeMsg + " needNeedShowInList:" + messageRecord.needNeedShowInList);
            }
            if (messageRecord.isBlessMsg && messageRecord.needUpdateMsgTag) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (messageRecord.isCheckNeedShowInListTypeMsg && messageRecord.needNeedShowInList) {
                z16 = false;
            }
            if (z16) {
                return true;
            }
        }
        return false;
    }

    public f y(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (f) iPatchRedirector.redirect((short) 8, (Object) this, i3);
        }
        return D.c(i3, this.f116281d);
    }

    protected void y0(MessageRecord messageRecord, Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            iPatchRedirector.redirect((short) 47, (Object) this, (Object) messageRecord, (Object) message);
            return;
        }
        if (message.uniseq == messageRecord.uniseq) {
            MessageRecord.copyMessageRecordStatusField(message, messageRecord);
            return;
        }
        MessageRecord.copyMessageRecordBaseField(message, messageRecord);
        message.emoRecentMsg = null;
        message.fileType = -1;
        message.lastMsg = null;
        try {
            h(message);
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager", 2, "updateMsgTab ERROR", th5);
            }
        }
    }

    public String z(int i3, String str, String str2, MessageForUniteGrayTip messageForUniteGrayTip) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 67)) {
            return (String) iPatchRedirector.redirect((short) 67, this, Integer.valueOf(i3), str, str2, messageForUniteGrayTip);
        }
        return D.g(this.f116281d, i3, str, str2, messageForUniteGrayTip);
    }

    public void z0(MessageRecord messageRecord, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, (Object) this, (Object) messageRecord, i3);
        } else if (i3 == 1 && !messageRecord.isSendFromLocal() && !messageRecord.isread && !String.valueOf(AppConstants.RECOMMEND_CONTACT_UIN).equals(messageRecord.frienduin)) {
            this.f116282e.setIncomingMsg(null);
        }
    }
}
