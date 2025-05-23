package com.tencent.mobileqq.imcore;

import android.content.Context;
import android.support.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.ao;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.imcore.proxy.basic.CaughtExceptionReportProxy;
import com.tencent.mobileqq.imcore.proxy.basic.StatisticCollectorProxy;
import com.tencent.mobileqq.imcore.proxy.basic.b;
import com.tencent.mobileqq.imcore.proxy.basic.c;
import com.tencent.mobileqq.imcore.proxy.business.a;
import com.tencent.mobileqq.imcore.proxy.business.b;
import com.tencent.mobileqq.imcore.proxy.business.c;
import com.tencent.mobileqq.imcore.proxy.business.e;
import com.tencent.mobileqq.imcore.proxy.business.f;
import com.tencent.mobileqq.imcore.proxy.business.g;
import com.tencent.mobileqq.imcore.proxy.business.h;
import com.tencent.mobileqq.imcore.proxy.db.SQLiteFTSUtilsProxy;
import com.tencent.mobileqq.imcore.proxy.db.ThreadRegulatorProxy;
import com.tencent.mobileqq.imcore.proxy.db.ThreadTraceHelperProxy;
import com.tencent.mobileqq.imcore.proxy.msg.AIOUtilsProxy;
import com.tencent.mobileqq.imcore.proxy.msg.a;
import com.tencent.mobileqq.imcore.proxy.msg.b;
import com.tencent.mobileqq.imcore.proxy.msg.c;
import com.tencent.mobileqq.imcore.proxy.msg.d;
import com.tencent.mobileqq.imcore.proxy.troop.a;
import com.tencent.mobileqq.imcore.proxy.utils.a;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.text.AbsQQText;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.utils.bt;
import com.tencent.mobileqq.utils.en;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.opt.threadpriority.ThreadRegulator;
import java.util.HashMap;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.imcore.a$a, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public class C7932a implements SQLiteFTSUtilsProxy.Proxy {
        static IPatchRedirector $redirector_;

        C7932a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.imcore.proxy.db.SQLiteFTSUtilsProxy.Proxy
        public int getFTSNotifyFlag() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return vy2.b.g(BaseApplicationImpl.getApplication());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class b implements ThreadTraceHelperProxy.Proxy {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.imcore.proxy.db.ThreadTraceHelperProxy.Proxy
        public void addWaitingTransThread(long j3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), str);
            } else {
                com.tencent.mobileqq.perf.thread.b.c(j3, str);
            }
        }

        @Override // com.tencent.mobileqq.imcore.proxy.db.ThreadTraceHelperProxy.Proxy
        public void removeWaitingTransThread(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, j3);
            } else {
                com.tencent.mobileqq.perf.thread.b.o(j3);
            }
        }

        @Override // com.tencent.mobileqq.imcore.proxy.db.ThreadTraceHelperProxy.Proxy
        public void setCurrentTransThread(long j3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Long.valueOf(j3), str);
            } else {
                com.tencent.mobileqq.perf.thread.b.q(j3, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class c implements StatisticCollectorProxy.Proxy {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.imcore.proxy.basic.StatisticCollectorProxy.Proxy
        public void collectPerformance(String str, String str2, boolean z16, long j3, long j16, HashMap<String, String> hashMap, String str3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(str, str2, z16, j3, j16, hashMap, str3);
            } else {
                iPatchRedirector.redirect((short) 2, this, str, str2, Boolean.valueOf(z16), Long.valueOf(j3), Long.valueOf(j16), hashMap, str3);
            }
        }

        @Override // com.tencent.mobileqq.imcore.proxy.basic.StatisticCollectorProxy.Proxy
        public void collectPerformance(String str, String str2, boolean z16, long j3, long j16, HashMap<String, String> hashMap, String str3, boolean z17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(str, str2, z16, j3, j16, hashMap, str3, z17);
            } else {
                iPatchRedirector.redirect((short) 3, this, str, str2, Boolean.valueOf(z16), Long.valueOf(j3), Long.valueOf(j16), hashMap, str3, Boolean.valueOf(z17));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class d implements CaughtExceptionReportProxy.Proxy {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.imcore.proxy.basic.CaughtExceptionReportProxy.Proxy
        public void e(@NonNull Throwable th5, @NonNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) th5, (Object) str);
            } else {
                com.tencent.qqperf.monitor.crash.catchedexception.a.c(th5, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class e implements b.a {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.imcore.proxy.basic.b.a
        public boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return AppSetting.f99565y;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class f implements d.a {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.imcore.proxy.msg.d.a
        public AbsQQText a(CharSequence charSequence, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (AbsQQText) iPatchRedirector.redirect((short) 2, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16));
            }
            return new QQText(charSequence, i3, i16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class g implements ThreadRegulatorProxy.Proxy {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.imcore.proxy.db.ThreadRegulatorProxy.Proxy
        public void checkInNextBusiness() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                ThreadRegulator.d().c();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class h implements b.a {
        static IPatchRedirector $redirector_;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class i implements f.a {
        static IPatchRedirector $redirector_;

        i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class j implements g.a {
        static IPatchRedirector $redirector_;

        j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class k implements AIOUtilsProxy.Proxy {
        static IPatchRedirector $redirector_;

        k() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.imcore.proxy.msg.AIOUtilsProxy.Proxy
        public boolean getLogcatDBOperation() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return com.tencent.mobileqq.activity.aio.l.f179530f;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class l implements h.a {
        static IPatchRedirector $redirector_;

        l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.imcore.proxy.business.h.a
        public boolean a(BaseQQAppInterface baseQQAppInterface, String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, this, baseQQAppInterface, str, Integer.valueOf(i3))).booleanValue();
            }
            if (!(baseQQAppInterface instanceof QQAppInterface)) {
                return false;
            }
            return ((ITempMsgBoxManager) baseQQAppInterface.getRuntimeService(ITempMsgBoxManager.class, "")).isBelongToMsgBox(str, i3);
        }

        @Override // com.tencent.mobileqq.imcore.proxy.business.h.a
        public void b(BaseQQAppInterface baseQQAppInterface, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, baseQQAppInterface, Boolean.valueOf(z16));
            } else {
                if (!(baseQQAppInterface instanceof QQAppInterface)) {
                    return;
                }
                ((ITempMsgBoxManager) baseQQAppInterface.getRuntimeService(ITempMsgBoxManager.class, "")).setMsgBoxRead(z16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class m implements c.a {
        static IPatchRedirector $redirector_;

        m() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class n implements c.a {
        static IPatchRedirector $redirector_;

        n() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.imcore.proxy.msg.c.a
        public void a(Context context, BaseQQAppInterface baseQQAppInterface, Message message, int i3, MsgSummary msgSummary, boolean z16, boolean z17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, context, baseQQAppInterface, message, Integer.valueOf(i3), msgSummary, Boolean.valueOf(z16), Boolean.valueOf(z17));
            } else {
                bt.c(context, baseQQAppInterface, message, i3, msgSummary, z16, z17);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class o implements b.InterfaceC7936b {
        static IPatchRedirector $redirector_;

        o() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.imcore.proxy.msg.b.InterfaceC7936b
        public boolean a(Entity entity) {
            MessageRecord messageRecord;
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) entity)).booleanValue();
            }
            if (!(entity instanceof MessageRecord) || (i3 = (messageRecord = (MessageRecord) entity).istroop) == 6000) {
                return false;
            }
            return ao.t(i3, messageRecord.frienduin);
        }

        @Override // com.tencent.mobileqq.imcore.proxy.msg.b.InterfaceC7936b
        public b.a b(Entity entity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (b.a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) entity);
            }
            if (!(entity instanceof MessageRecord)) {
                return null;
            }
            MessageRecord messageRecord = (MessageRecord) entity;
            if (!ao.t(messageRecord.istroop, messageRecord.frienduin)) {
                return null;
            }
            return new b.a(messageRecord.istroop, messageRecord.frienduin);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class p implements a.InterfaceC7935a {
        static IPatchRedirector $redirector_;

        p() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.imcore.proxy.msg.a.InterfaceC7935a
        public int a(Message message, BaseQQAppInterface baseQQAppInterface) {
            ConversationFacade conversationFacade;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) message, (Object) baseQQAppInterface)).intValue();
            }
            if ((baseQQAppInterface instanceof QQAppInterface) && (message instanceof Message) && (conversationFacade = ((QQAppInterface) baseQQAppInterface).getConversationFacade()) != null) {
                return conversationFacade.R(message.frienduin, message.istroop);
            }
            return 0;
        }

        @Override // com.tencent.mobileqq.imcore.proxy.msg.a.InterfaceC7935a
        public void b(BaseQQAppInterface baseQQAppInterface, String str, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, baseQQAppInterface, str, Integer.valueOf(i3), Integer.valueOf(i16));
            } else if (baseQQAppInterface instanceof QQAppInterface) {
                ((QQAppInterface) baseQQAppInterface).getConversationFacade().s0(str, i3, i16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class q implements a.InterfaceC7938a {
        static IPatchRedirector $redirector_;

        q() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.imcore.proxy.utils.a.InterfaceC7938a
        public String a(BaseQQAppInterface baseQQAppInterface, String str, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, this, baseQQAppInterface, str, Boolean.valueOf(z16));
            }
            if (baseQQAppInterface instanceof QQAppInterface) {
                return ac.g0((QQAppInterface) baseQQAppInterface, str, true);
            }
            return str;
        }

        @Override // com.tencent.mobileqq.imcore.proxy.utils.a.InterfaceC7938a
        public String b(BaseQQAppInterface baseQQAppInterface, String str, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, this, baseQQAppInterface, str, Boolean.valueOf(z16));
            }
            if (baseQQAppInterface instanceof QQAppInterface) {
                return ac.g((QQAppInterface) baseQQAppInterface, str, true);
            }
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class r implements c.a {
        static IPatchRedirector $redirector_;

        r() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.imcore.proxy.basic.c.a
        public String a(StringBuffer stringBuffer, long j3, boolean z16, String str, boolean z17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, this, stringBuffer, Long.valueOf(j3), Boolean.valueOf(z16), str, Boolean.valueOf(z17));
            }
            return en.r(stringBuffer, j3, z16, str, z17);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class s implements a.InterfaceC7934a {
        static IPatchRedirector $redirector_;

        s() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class t implements e.a {
        static IPatchRedirector $redirector_;

        t() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class u implements a.InterfaceC7937a {
        static IPatchRedirector $redirector_;

        u() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.imcore.proxy.troop.a.InterfaceC7937a
        public TroopInfo a(BaseQQAppInterface baseQQAppInterface, String str) {
            TroopManager troopManager;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (TroopInfo) iPatchRedirector.redirect((short) 2, (Object) this, (Object) baseQQAppInterface, (Object) str);
            }
            if ((baseQQAppInterface instanceof QQAppInterface) && (troopManager = (TroopManager) baseQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)) != null) {
                return troopManager.l(str, true);
            }
            return null;
        }
    }

    public static void a() {
        if (QLog.isColorLevel()) {
            QLog.d("IMCoreProxyRegister", 2, "initModuleProxyNotImport Start, process=", MobileQQ.processName);
        }
        com.tencent.imcore.message.s.a();
        b();
        d();
        e();
        c();
        g();
        f();
        if (QLog.isColorLevel()) {
            QLog.d("IMCoreProxyRegister", 2, "initModuleProxyNotImport finish, process=", MobileQQ.processName);
        }
    }

    private static void b() {
        StatisticCollectorProxy.registerProxy(new c());
        CaughtExceptionReportProxy.registerProxy(new d());
        com.tencent.mobileqq.imcore.proxy.basic.b.b(new e());
        com.tencent.mobileqq.imcore.proxy.msg.d.b(new f());
        ThreadRegulatorProxy.registerProxy(new g());
    }

    private static void c() {
        com.tencent.mobileqq.imcore.proxy.business.a.a(new s());
        com.tencent.mobileqq.imcore.proxy.business.e.a(new t());
    }

    private static void d() {
        SQLiteFTSUtilsProxy.registerProxy(new C7932a());
        ThreadTraceHelperProxy.registerProxy(new b());
    }

    private static void e() {
        AIOUtilsProxy.registerProxy(new k());
        com.tencent.mobileqq.imcore.proxy.msg.c.b(new n());
        com.tencent.mobileqq.imcore.proxy.msg.b.c(new o());
        com.tencent.mobileqq.imcore.proxy.msg.a.b(new p());
        com.tencent.mobileqq.imcore.proxy.utils.a.c(new q());
        com.tencent.mobileqq.imcore.proxy.basic.c.b(new r());
    }

    public static void f() {
        com.tencent.mobileqq.imcore.proxy.business.b.a(new h());
        com.tencent.mobileqq.imcore.proxy.business.f.a(new i());
        com.tencent.mobileqq.imcore.proxy.business.g.a(new j());
        com.tencent.mobileqq.imcore.proxy.business.h.b(new l());
        com.tencent.mobileqq.imcore.proxy.business.c.a(new m());
    }

    private static void g() {
        com.tencent.mobileqq.imcore.proxy.troop.a.b(new u());
    }
}
