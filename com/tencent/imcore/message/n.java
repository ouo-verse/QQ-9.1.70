package com.tencent.imcore.message;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.collection.QQConcurrentHashMap;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.proxy.BaseProxy;
import com.tencent.mobileqq.app.proxy.BaseProxyManager;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.NoColumnError;
import com.tencent.mobileqq.persistence.NoColumnErrorHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes7.dex */
public class n extends BaseProxy {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected QQConcurrentHashMap<String, ConversationInfo> f116701a;

    /* renamed from: b, reason: collision with root package name */
    EntityManager f116702b;

    /* renamed from: c, reason: collision with root package name */
    private Object f116703c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f116704d;

    /* renamed from: e, reason: collision with root package name */
    NoColumnErrorHandler f116705e;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class a implements NoColumnErrorHandler {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) n.this);
            }
        }

        @Override // com.tencent.mobileqq.persistence.NoColumnErrorHandler
        public void handleNoColumnError(NoColumnError noColumnError) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) noColumnError);
                return;
            }
            if (noColumnError != null) {
                if ("unreadGiftCount".equals(noColumnError.mColumnName) || "unreadMark".equals(noColumnError.mColumnName)) {
                    if (QLog.isColorLevel()) {
                        QLog.w("Q.unread.Proxy", 2, noColumnError.getMessage(), noColumnError);
                    }
                    n.this.f116704d = true;
                }
            }
        }
    }

    public n(AppRuntime appRuntime, BaseProxyManager baseProxyManager) {
        super(appRuntime, baseProxyManager);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime, (Object) baseProxyManager);
            return;
        }
        this.f116702b = null;
        this.f116703c = new Object();
        this.f116704d = false;
        this.f116705e = new a();
        this.f116701a = new QQConcurrentHashMap<>(Business.Conversation, "ConversationInfo");
    }

    private boolean u(int i3, int i16) {
        if ((i3 == 10010 && i16 == 0) || (i3 == 0 && i16 == 10010)) {
            return true;
        }
        return false;
    }

    private boolean v(int i3, int i16) {
        if ((i3 == 1006 && i16 == 0) || (i3 == 0 && i16 == 1006)) {
            return true;
        }
        return false;
    }

    private boolean w(int i3, int i16) {
        if ((i3 == 1004 && i16 == 0) || (i3 == 0 && i16 == 1004)) {
            return true;
        }
        return false;
    }

    private boolean x(int i3, int i16) {
        if ((i3 == 1022 && i16 == 0) || (i3 == 0 && i16 == 1022)) {
            return true;
        }
        return false;
    }

    private boolean y(int i3, int i16) {
        if ((i3 == 1000 && i16 == 0) || (i3 == 0 && i16 == 1000)) {
            return true;
        }
        return false;
    }

    private boolean z(int i3, int i16) {
        if ((i3 == 1023 && i16 == 0) || (i3 == 0 && i16 == 1023)) {
            return true;
        }
        return false;
    }

    protected void A(String str, int i3, ConversationInfo conversationInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, str, Integer.valueOf(i3), conversationInfo);
        } else {
            g(str, i3, conversationInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void B(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) str, i3);
            return;
        }
        String f16 = ao.f(str, i3);
        if (this.f116701a.containsKey(f16)) {
            f(str, i3, this.f116701a.get(f16));
            this.f116701a.remove(f16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void C(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) str, i3);
            return;
        }
        String f16 = ao.f(str, i3);
        if (this.f116701a.containsKey(f16) && this.f116701a.get(f16) != null) {
            ConversationInfo conversationInfo = this.f116701a.get(f16);
            if (this.f116701a.get(f16).unreadCount > 0 && !AppConstants.KANDIAN_SUBSCRIBE_UIN.equals(str) && !AppConstants.KANDIAN_DAILY_UIN.equals(str) && !AppConstants.Q_CIRCLE_PUBLIC_ACCOUNT_UIN.equals(str)) {
                if (QLog.isColorLevel()) {
                    QLog.d("Q.unread.Proxy", 2, "insertOrUpdatePublicAccountRed return , updateinfo= " + conversationInfo.toString());
                }
                return;
            }
            conversationInfo.setUnread(conversationInfo.unreadCount + 1);
            conversationInfo.extInt3 = this.f116701a.get(f16).extInt3 | 1;
            if (QLog.isColorLevel()) {
                QLog.d("Q.unread.Proxy", 2, "insertOrUpdatePublicAccountRed update=" + conversationInfo.toString());
            }
            E(str, i3, conversationInfo);
        } else {
            ConversationInfo conversationInfo2 = new ConversationInfo(str, i3, 0L, 0);
            conversationInfo2.extInt3 = 1;
            conversationInfo2.setUnread(conversationInfo2.unreadCount + 1);
            if (QLog.isColorLevel()) {
                QLog.d("Q.unread.Proxy", 2, "insertOrUpdatePublicAccountRed insert=" + conversationInfo2.toString());
            }
            this.f116701a.put(f16, conversationInfo2);
            q(str, i3, conversationInfo2);
        }
    }

    public synchronized void D(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (i16 > 0) {
            i16 = 1;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.unread.Proxy", 2, "setUnreadForImax uin=" + str);
        }
        String f16 = ao.f(str, i3);
        if (this.f116701a.containsKey(f16) && this.f116701a.get(f16) != null) {
            ConversationInfo conversationInfo = this.f116701a.get(f16);
            if (conversationInfo.unreadCount != i16) {
                conversationInfo.setUnread(i16);
                QLog.d("Q.unread.Proxy", 1, "setUnreadForImax update=" + conversationInfo.toString());
                E(str, i3, conversationInfo);
            } else if (QLog.isColorLevel()) {
                QLog.d("Q.unread.Proxy", 2, "setUnreadForImax nochange=" + conversationInfo.toString());
            }
        } else {
            ConversationInfo conversationInfo2 = new ConversationInfo(str, i3, 0L, 0);
            conversationInfo2.setUnread(i16);
            QLog.d("Q.unread.Proxy", 1, "setUnreadForImax insert=" + conversationInfo2.toString());
            this.f116701a.put(f16, conversationInfo2);
            q(str, i3, conversationInfo2);
        }
    }

    protected void E(String str, int i3, ConversationInfo conversationInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, Integer.valueOf(i3), conversationInfo);
        } else {
            A(str, i3, conversationInfo);
            this.proxyManager.addMsgQueue(str, i3, ConversationInfo.getConversationInfoTableName(), conversationInfo, 4, null);
        }
    }

    public void F(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (!TextUtils.isEmpty(str) && i3 == 1) {
            String f16 = ao.f(str, i3);
            if (this.f116701a.containsKey(f16) && this.f116701a.get(f16) != null) {
                ConversationInfo conversationInfo = this.f116701a.get(f16);
                conversationInfo.setUnreadTroopGuildCount(i16);
                E(str, i3, conversationInfo);
            } else if (i16 > 0) {
                ConversationInfo conversationInfo2 = new ConversationInfo(str, i3, 0L, 0);
                conversationInfo2.setUnreadTroopGuildCount(i16);
                conversationInfo2.setUnreadGiftCount(0);
                conversationInfo2.setExtInt1(0);
                conversationInfo2.extInt3 = (conversationInfo2.extInt3 >> 1) << 1;
                this.f116701a.put(f16, conversationInfo2);
                q(str, i3, conversationInfo2);
            }
        }
    }

    public boolean b(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, this, str, Integer.valueOf(i3), Integer.valueOf(i16))).booleanValue();
        }
        if (i3 == i16) {
            return false;
        }
        boolean y16 = y(i3, i16);
        if (w(i3, i16)) {
            y16 = true;
        }
        if (v(i3, i16)) {
            y16 = true;
        }
        if (z(i3, i16)) {
            y16 = true;
        }
        if (x(i3, i16)) {
            y16 = true;
        }
        if (u(i3, i16)) {
            y16 = true;
        }
        if (com.tencent.mobileqq.imcore.proxy.business.h.a((BaseQQAppInterface) this.app, str, i3) ^ com.tencent.mobileqq.imcore.proxy.business.h.a((BaseQQAppInterface) this.app, str, i16)) {
            y16 = true;
        }
        QLog.i("Q.unread.Proxy", 1, "canUpdateType() called with: uin = [" + MsfSdkUtils.getShortUin(str) + "], from = [" + i3 + "], to = [" + i16 + "]");
        return y16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
            return;
        }
        if (!this.f116701a.isEmpty()) {
            for (ConversationInfo conversationInfo : this.f116701a.values()) {
                if (conversationInfo.unreadCount > 0 || conversationInfo.unreadMark > 0) {
                    conversationInfo.setUnread(0);
                    conversationInfo.setUnreadGiftCount(0);
                    conversationInfo.setUnreadMark(0);
                    conversationInfo.setExtInt1(0);
                    conversationInfo.extInt3 = (conversationInfo.extInt3 >> 1) << 1;
                    E(conversationInfo.uin, conversationInfo.type, conversationInfo);
                }
                if (conversationInfo.extInt2 > 0) {
                    conversationInfo.setExtInt2(0);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void d(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) str, i3);
            return;
        }
        String f16 = ao.f(str, i3);
        if (this.f116701a.containsKey(f16) && this.f116701a.get(f16) != null) {
            ConversationInfo conversationInfo = this.f116701a.get(f16);
            conversationInfo.extInt3 = (conversationInfo.extInt3 >> 1) << 1;
            E(str, i3, conversationInfo);
        }
    }

    @Override // com.tencent.mobileqq.app.proxy.BaseProxy
    public synchronized void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        this.f116701a.clear();
        EntityManager entityManager = this.f116702b;
        if (entityManager != null && entityManager.isOpen()) {
            this.f116702b.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized Set<ConversationInfo> e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Set) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        try {
            return new HashSet(this.f116701a.values());
        } catch (OutOfMemoryError e16) {
            if (QLog.isColorLevel()) {
                QLog.e("Q.unread.Proxy", 2, "cloneConversationInfoSet OOM!", e16);
            }
            return new HashSet();
        }
    }

    protected void f(String str, int i3, ConversationInfo conversationInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, str, Integer.valueOf(i3), conversationInfo);
        } else {
            this.proxyManager.addMsgQueue(str, i3, ConversationInfo.getConversationInfoTableName(), conversationInfo, 5, null);
        }
    }

    protected void g(String str, int i3, ConversationInfo conversationInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, str, Integer.valueOf(i3), conversationInfo);
            return;
        }
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(str) && conversationInfo != null) {
            bundle.putString("PEER_UIN", str);
            bundle.putInt("MESSAGE_TYPE", i3);
            bundle.putInt("UN_READ_NUM", conversationInfo.unreadCount);
        }
        this.app.notifyObservers(o.class, 0, true, bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized int h(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Integer) iPatchRedirector.redirect((short) 29, (Object) this, (Object) str, i3)).intValue();
        }
        String f16 = ao.f(str, i3);
        if (this.f116701a.containsKey(f16)) {
            return this.f116701a.get(f16).unreadGiftCount;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized ConversationInfo i(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (ConversationInfo) iPatchRedirector.redirect((short) 26, (Object) this, (Object) str, i3);
        }
        String f16 = ao.f(str, i3);
        if (f16 != null && this.f116701a.containsKey(f16)) {
            return this.f116701a.get(f16);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.app.proxy.BaseProxy
    public void init() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized long j(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Long) iPatchRedirector.redirect((short) 28, (Object) this, (Object) str, i3)).longValue();
        }
        String f16 = ao.f(str, i3);
        if (f16 != null && this.f116701a.containsKey(f16)) {
            return this.f116701a.get(f16).lastread;
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized int k(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Integer) iPatchRedirector.redirect((short) 30, (Object) this, (Object) str, i3)).intValue();
        }
        String f16 = ao.f(str, i3);
        if (this.f116701a.containsKey(f16)) {
            return this.f116701a.get(f16).extInt1;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized int l(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Integer) iPatchRedirector.redirect((short) 27, (Object) this, (Object) str, i3)).intValue();
        }
        String f16 = ao.f(str, i3);
        if (f16 != null && this.f116701a.containsKey(f16)) {
            return this.f116701a.get(f16).unreadCount;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized int m(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this, (Object) str, i3)).intValue();
        }
        String f16 = ao.f(str, i3);
        if (f16 != null && this.f116701a.containsKey(f16) && this.f116701a.get(f16) != null) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.unread.Proxy", 2, "getPublicAccountConversationRedMask uin=" + str + " unreadexstr=" + String.valueOf(this.f116701a.get(f16).extInt3 & 1));
            }
            return this.f116701a.get(f16).extInt3 & 1;
        }
        return 0;
    }

    public synchronized boolean n(RecentBaseData recentBaseData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, (Object) recentBaseData)).booleanValue();
        }
        boolean z16 = false;
        if (recentBaseData != null) {
            ConversationInfo conversationInfo = this.f116701a.get(ao.f(recentBaseData.getRecentUserUin(), recentBaseData.getRecentUserType()));
            if (conversationInfo != null) {
                if (conversationInfo.extInt1 > 0) {
                    z16 = true;
                }
                return z16;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void o(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        String f16 = ao.f(str, i3);
        if (this.f116701a.containsKey(f16) && this.f116701a.get(f16) != null) {
            ConversationInfo conversationInfo = this.f116701a.get(f16);
            s(str, i3, conversationInfo.lastread, conversationInfo.unreadCount + i16, conversationInfo.unreadGiftCount, conversationInfo.extInt1);
        } else {
            s(str, i3, 0L, i16, 0, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void p(String str, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, str, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        String f16 = ao.f(str, i3);
        if (this.f116701a.containsKey(f16) && this.f116701a.get(f16) != null) {
            ConversationInfo conversationInfo = this.f116701a.get(f16);
            s(str, i3, conversationInfo.lastread, conversationInfo.unreadCount + i16, conversationInfo.unreadGiftCount + i17, conversationInfo.extInt1 + i18);
        } else {
            s(str, i3, 0L, i16, i17, i18);
        }
    }

    protected void q(String str, int i3, ConversationInfo conversationInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, str, Integer.valueOf(i3), conversationInfo);
        } else {
            this.proxyManager.addMsgQueue(str, i3, ConversationInfo.getConversationInfoTableName(), conversationInfo, 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void r(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        String f16 = ao.f(str, i3);
        if (this.f116701a.containsKey(f16) && this.f116701a.get(f16) != null) {
            ConversationInfo conversationInfo = this.f116701a.get(f16);
            s(str, i3, conversationInfo.lastread, i16, conversationInfo.unreadGiftCount, conversationInfo.extInt1);
        } else {
            s(str, i3, 0L, i16, 0, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void s(String str, int i3, long j3, int i16, int i17, int i18) {
        long j16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, str, Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        String f16 = ao.f(str, i3);
        if (this.f116701a.containsKey(f16) && this.f116701a.get(f16) != null) {
            ConversationInfo conversationInfo = this.f116701a.get(f16);
            if ((conversationInfo.lastread >= j3 || !ConversationFacade.h0(i3)) && ((conversationInfo.lastread == j3 || ConversationFacade.h0(i3)) && conversationInfo.unreadCount == i16 && conversationInfo.unreadGiftCount == i17 && conversationInfo.extInt1 == i18 && conversationInfo.type == i3)) {
                if (QLog.isColorLevel()) {
                    QLog.d("Q.unread.Proxy", 2, "insertOrUpdateUnread  nochange=" + conversationInfo.toString());
                }
            }
            if (ConversationFacade.h0(i3)) {
                j16 = Math.max(conversationInfo.lastread, j3);
            } else {
                j16 = j3;
            }
            conversationInfo.lastread = j16;
            conversationInfo.setUnread(Math.max(0, i16));
            conversationInfo.setUnreadGiftCount(Math.max(0, i17));
            conversationInfo.setExtInt1(Math.max(0, i18));
            if (b(str, conversationInfo.type, i3)) {
                QLog.i("Q.unread.Proxy", 1, "insertOrUpdateUnread() called update type from = [" + conversationInfo.type + "], to = [" + i3 + "], uin = [" + MsfSdkUtils.getShortUin(str) + "]");
                conversationInfo.setType(i3);
            }
            if (i16 == 0) {
                conversationInfo.extInt3 = (conversationInfo.extInt3 >> 1) << 1;
            }
            E(str, i3, conversationInfo);
        } else {
            ConversationInfo conversationInfo2 = new ConversationInfo(str, i3, j3, Math.max(0, i16));
            conversationInfo2.setUnreadGiftCount(Math.max(0, i17));
            conversationInfo2.setExtInt1(Math.max(0, i18));
            if (i16 == 0) {
                conversationInfo2.extInt3 = (conversationInfo2.extInt3 >> 1) << 1;
            }
            QLog.d("Q.unread.Proxy_UnreadMonitor", 1, "insertOrUpdateUnread insert=" + conversationInfo2.toString());
            this.f116701a.put(f16, conversationInfo2);
            q(str, i3, conversationInfo2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void t(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        String f16 = ao.f(str, i3);
        if (this.f116701a.containsKey(f16) && this.f116701a.get(f16) != null) {
            ConversationInfo conversationInfo = this.f116701a.get(f16);
            if (conversationInfo.unreadMark != i16) {
                conversationInfo.setUnreadMark(i16);
                QLog.d("Q.unread.Proxy", 1, "insertOrUpdateUnreadMark update=" + conversationInfo.toString());
                E(str, i3, conversationInfo);
            } else if (QLog.isColorLevel()) {
                QLog.d("Q.unread.Proxy", 2, "insertOrUpdateUnreadMark nochange=" + conversationInfo.toString());
            }
        } else {
            ConversationInfo conversationInfo2 = new ConversationInfo(str, i3, 0L, 0);
            conversationInfo2.setUnreadMark(i16);
            QLog.d("Q.unread.Proxy", 1, "insertOrUpdateUnreadMark insert=" + conversationInfo2.toString());
            this.f116701a.put(f16, conversationInfo2);
            q(str, i3, conversationInfo2);
        }
    }
}
