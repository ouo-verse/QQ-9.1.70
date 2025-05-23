package com.tencent.imcore.message;

import android.content.SharedPreferences;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.persistence.service.ICommonFunctionPublishConfigService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes7.dex */
public class ConversationFacade extends Observable implements Manager {
    static IPatchRedirector $redirector_;
    public static b C;

    /* renamed from: d, reason: collision with root package name */
    private final AppRuntime f116399d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f116400e;

    /* renamed from: f, reason: collision with root package name */
    private final List<c> f116401f;

    /* renamed from: h, reason: collision with root package name */
    private Set<String> f116402h;

    /* renamed from: i, reason: collision with root package name */
    private Set<String> f116403i;

    /* renamed from: m, reason: collision with root package name */
    private Object f116404m;

    /* compiled from: P */
    /* renamed from: com.tencent.imcore.message.ConversationFacade$2, reason: invalid class name */
    /* loaded from: classes7.dex */
    class AnonymousClass2 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ List f116405d;
        final /* synthetic */ ConversationFacade this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            Iterator it = this.f116405d.iterator();
            while (it.hasNext()) {
                ((c) it.next()).onRegisterProxyDone();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class a implements b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.imcore.message.ConversationFacade.b
        public long A(AppRuntime appRuntime, String str, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
                return ((Long) iPatchRedirector.redirect((short) 21, this, appRuntime, str, Integer.valueOf(i3), Integer.valueOf(i16))).longValue();
            }
            return 0L;
        }

        @Override // com.tencent.imcore.message.ConversationFacade.b
        public boolean B(AppRuntime appRuntime, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
                return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this, (Object) appRuntime, (Object) str)).booleanValue();
            }
            return false;
        }

        @Override // com.tencent.imcore.message.ConversationFacade.b
        public ConversationInfo C(ConversationInfo conversationInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (ConversationInfo) iPatchRedirector.redirect((short) 3, (Object) this, (Object) conversationInfo);
            }
            return conversationInfo;
        }

        @Override // com.tencent.imcore.message.ConversationFacade.b
        public String D() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
                return (String) iPatchRedirector.redirect((short) 32, (Object) this);
            }
            return null;
        }

        @Override // com.tencent.imcore.message.ConversationFacade.b
        public boolean a(MessageRecord messageRecord) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
                return ((Boolean) iPatchRedirector.redirect((short) 30, (Object) this, (Object) messageRecord)).booleanValue();
            }
            return false;
        }

        @Override // com.tencent.imcore.message.ConversationFacade.b
        public boolean b(MessageRecord messageRecord) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
                return ((Boolean) iPatchRedirector.redirect((short) 37, (Object) this, (Object) messageRecord)).booleanValue();
            }
            return false;
        }

        @Override // com.tencent.imcore.message.ConversationFacade.b
        public void c(AppRuntime appRuntime, boolean z16, boolean z17, ConversationFacade conversationFacade) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
                iPatchRedirector.redirect((short) 19, this, appRuntime, Boolean.valueOf(z16), Boolean.valueOf(z17), conversationFacade);
            }
        }

        @Override // com.tencent.imcore.message.ConversationFacade.b
        public String d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
                return (String) iPatchRedirector.redirect((short) 31, (Object) this);
            }
            return null;
        }

        @Override // com.tencent.imcore.message.ConversationFacade.b
        public boolean e(AppRuntime appRuntime, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
                return ((Boolean) iPatchRedirector.redirect((short) 27, (Object) this, (Object) appRuntime, (Object) str)).booleanValue();
            }
            return false;
        }

        @Override // com.tencent.imcore.message.ConversationFacade.b
        public BaseApplication f(AppRuntime appRuntime) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return (BaseApplication) iPatchRedirector.redirect((short) 15, (Object) this, (Object) appRuntime);
            }
            return null;
        }

        @Override // com.tencent.imcore.message.ConversationFacade.b
        public void g(AppRuntime appRuntime, int i3, MessageRecord messageRecord, List<MessageRecord> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                iPatchRedirector.redirect((short) 13, this, appRuntime, Integer.valueOf(i3), messageRecord, list);
            }
        }

        @Override // com.tencent.imcore.message.ConversationFacade.b
        public RecentUserProxy getRecentUserProxy(AppRuntime appRuntime) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (RecentUserProxy) iPatchRedirector.redirect((short) 8, (Object) this, (Object) appRuntime);
            }
            return null;
        }

        @Override // com.tencent.imcore.message.ConversationFacade.b
        public boolean h(AppRuntime appRuntime, MessageRecord messageRecord) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) appRuntime, (Object) messageRecord)).booleanValue();
            }
            return false;
        }

        @Override // com.tencent.imcore.message.ConversationFacade.b
        public List<MessageRecord> i(AppRuntime appRuntime, MessageRecord messageRecord, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (List) iPatchRedirector.redirect((short) 5, this, appRuntime, messageRecord, Integer.valueOf(i3));
            }
            return null;
        }

        @Override // com.tencent.imcore.message.ConversationFacade.b
        public boolean isFileAssistantAio(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
                return ((Boolean) iPatchRedirector.redirect((short) 29, (Object) this, (Object) str)).booleanValue();
            }
            return false;
        }

        @Override // com.tencent.imcore.message.ConversationFacade.b
        public boolean isRedPacketMsg(MessageRecord messageRecord) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
                return ((Boolean) iPatchRedirector.redirect((short) 36, (Object) this, (Object) messageRecord)).booleanValue();
            }
            return false;
        }

        @Override // com.tencent.imcore.message.ConversationFacade.b
        public void j(AppRuntime appRuntime, ConversationFacade conversationFacade, String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                iPatchRedirector.redirect((short) 16, this, appRuntime, conversationFacade, str, Integer.valueOf(i3));
            }
        }

        @Override // com.tencent.imcore.message.ConversationFacade.b
        public n k(AppRuntime appRuntime) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (n) iPatchRedirector.redirect((short) 7, (Object) this, (Object) appRuntime);
            }
            return null;
        }

        @Override // com.tencent.imcore.message.ConversationFacade.b
        public boolean l(AppRuntime appRuntime, RecentUser recentUser) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
                return ((Boolean) iPatchRedirector.redirect((short) 28, (Object) this, (Object) appRuntime, (Object) recentUser)).booleanValue();
            }
            return false;
        }

        @Override // com.tencent.imcore.message.ConversationFacade.b
        public Message m(AppRuntime appRuntime, String str, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (Message) iPatchRedirector.redirect((short) 6, this, appRuntime, str, Integer.valueOf(i3), Integer.valueOf(i16));
            }
            return null;
        }

        @Override // com.tencent.imcore.message.ConversationFacade.b
        public boolean n(MessageRecord messageRecord) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
                return ((Boolean) iPatchRedirector.redirect((short) 35, (Object) this, (Object) messageRecord)).booleanValue();
            }
            return false;
        }

        @Override // com.tencent.imcore.message.ConversationFacade.b
        public ConversationFacade o(AppRuntime appRuntime) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (ConversationFacade) iPatchRedirector.redirect((short) 10, (Object) this, (Object) appRuntime);
            }
            return null;
        }

        @Override // com.tencent.imcore.message.ConversationFacade.b
        public long p(AppRuntime appRuntime, String str, int i3, int i16, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                return ((Long) iPatchRedirector.redirect((short) 17, this, appRuntime, str, Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j3))).longValue();
            }
            return 0L;
        }

        @Override // com.tencent.imcore.message.ConversationFacade.b
        public void q(AppRuntime appRuntime, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
                iPatchRedirector.redirect((short) 23, (Object) this, (Object) appRuntime, (Object) str);
            }
        }

        @Override // com.tencent.imcore.message.ConversationFacade.b
        public void r(AppRuntime appRuntime, boolean z16, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                iPatchRedirector.redirect((short) 11, this, appRuntime, Boolean.valueOf(z16), obj);
            }
        }

        @Override // com.tencent.imcore.message.ConversationFacade.b
        public void refreshAppBadge(AppRuntime appRuntime) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
            }
        }

        @Override // com.tencent.imcore.message.ConversationFacade.b
        public void s(MessageRecord messageRecord, ConversationFacade conversationFacade) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
                iPatchRedirector.redirect((short) 34, (Object) this, (Object) messageRecord, (Object) conversationFacade);
            }
        }

        @Override // com.tencent.imcore.message.ConversationFacade.b
        public int t(AppRuntime appRuntime, String str, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 20)) {
                return 0;
            }
            return ((Integer) iPatchRedirector.redirect((short) 20, this, appRuntime, str, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
        }

        @Override // com.tencent.imcore.message.ConversationFacade.b
        public boolean u(MessageRecord messageRecord) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
                return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this, (Object) messageRecord)).booleanValue();
            }
            return false;
        }

        @Override // com.tencent.imcore.message.ConversationFacade.b
        public f v(AppRuntime appRuntime, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (f) iPatchRedirector.redirect((short) 9, (Object) this, (Object) appRuntime, i3);
            }
            return null;
        }

        @Override // com.tencent.imcore.message.ConversationFacade.b
        public boolean w(AppRuntime appRuntime, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
                return ((Boolean) iPatchRedirector.redirect((short) 25, (Object) this, (Object) appRuntime, (Object) str)).booleanValue();
            }
            return false;
        }

        @Override // com.tencent.imcore.message.ConversationFacade.b
        public boolean x(MessageRecord messageRecord) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
                return ((Boolean) iPatchRedirector.redirect((short) 33, (Object) this, (Object) messageRecord)).booleanValue();
            }
            return false;
        }

        @Override // com.tencent.imcore.message.ConversationFacade.b
        public void y(AppRuntime appRuntime, ConversationInfo conversationInfo, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                iPatchRedirector.redirect((short) 14, this, appRuntime, conversationInfo, Integer.valueOf(i3));
            }
        }

        @Override // com.tencent.imcore.message.ConversationFacade.b
        public void z(String str, int i3, boolean z16, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
                iPatchRedirector.redirect((short) 26, this, str, Integer.valueOf(i3), Boolean.valueOf(z16), Long.valueOf(j3));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface b {
        long A(AppRuntime appRuntime, String str, int i3, int i16);

        boolean B(AppRuntime appRuntime, String str);

        ConversationInfo C(ConversationInfo conversationInfo);

        String D();

        boolean a(MessageRecord messageRecord);

        boolean b(MessageRecord messageRecord);

        void c(AppRuntime appRuntime, boolean z16, boolean z17, ConversationFacade conversationFacade);

        String d();

        boolean e(AppRuntime appRuntime, String str);

        BaseApplication f(AppRuntime appRuntime);

        void g(AppRuntime appRuntime, int i3, MessageRecord messageRecord, List<MessageRecord> list);

        RecentUserProxy getRecentUserProxy(AppRuntime appRuntime);

        boolean h(AppRuntime appRuntime, MessageRecord messageRecord);

        List<MessageRecord> i(AppRuntime appRuntime, MessageRecord messageRecord, int i3);

        boolean isFileAssistantAio(String str);

        boolean isRedPacketMsg(MessageRecord messageRecord);

        void j(AppRuntime appRuntime, ConversationFacade conversationFacade, String str, int i3);

        n k(AppRuntime appRuntime);

        boolean l(AppRuntime appRuntime, RecentUser recentUser);

        Message m(AppRuntime appRuntime, String str, int i3, int i16);

        boolean n(MessageRecord messageRecord);

        ConversationFacade o(AppRuntime appRuntime);

        long p(AppRuntime appRuntime, String str, int i3, int i16, long j3);

        void q(AppRuntime appRuntime, String str);

        void r(AppRuntime appRuntime, boolean z16, Object obj);

        void refreshAppBadge(AppRuntime appRuntime);

        void s(MessageRecord messageRecord, ConversationFacade conversationFacade);

        int t(AppRuntime appRuntime, String str, int i3, int i16);

        boolean u(MessageRecord messageRecord);

        f v(AppRuntime appRuntime, int i3);

        boolean w(AppRuntime appRuntime, String str);

        boolean x(MessageRecord messageRecord);

        void y(AppRuntime appRuntime, ConversationInfo conversationInfo, int i3);

        void z(String str, int i3, boolean z16, long j3);
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface c {
        void onRegisterProxyDone();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private int f116407a;

        /* renamed from: b, reason: collision with root package name */
        private List<MessageRecord> f116408b;

        /* renamed from: c, reason: collision with root package name */
        private long f116409c;

        /* renamed from: d, reason: collision with root package name */
        private int f116410d;

        /* renamed from: e, reason: collision with root package name */
        private int f116411e;

        /* renamed from: f, reason: collision with root package name */
        private int f116412f;

        /* renamed from: g, reason: collision with root package name */
        private Set<String> f116413g;

        /* renamed from: h, reason: collision with root package name */
        private Map<String, Set<MessageRecord>> f116414h;

        public d(int i3, List<MessageRecord> list, long j3, int i16, int i17, int i18, Set<String> set, Map<String, Set<MessageRecord>> map) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, ConversationFacade.this, Integer.valueOf(i3), list, Long.valueOf(j3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), set, map);
                return;
            }
            this.f116407a = i3;
            this.f116408b = list;
            this.f116409c = j3;
            this.f116410d = i16;
            this.f116411e = i17;
            this.f116412f = i18;
            this.f116413g = set;
            this.f116414h = map;
        }

        private void a(MessageRecord messageRecord, long j3) {
            if (j3 <= this.f116409c) {
                if (messageRecord.isLongMsg()) {
                    if (this.f116414h == null) {
                        this.f116414h = new HashMap();
                    }
                    String g16 = ao.g(messageRecord);
                    if (this.f116414h.containsKey(ao.g(messageRecord))) {
                        Set<MessageRecord> set = this.f116414h.get(g16);
                        if (set != null && !set.isEmpty() && !ConversationFacade.this.Y(messageRecord, set)) {
                            set.add(messageRecord);
                            return;
                        }
                        return;
                    }
                    HashSet hashSet = new HashSet();
                    hashSet.add(messageRecord);
                    this.f116414h.put(g16, hashSet);
                    return;
                }
                if (ao.y(messageRecord.msgtype) && !messageRecord.isread) {
                    this.f116410d++;
                    this.f116411e += ConversationFacade.this.B(messageRecord);
                    this.f116412f += ConversationFacade.this.L(messageRecord);
                }
            }
        }

        private void f(MessageRecord messageRecord, long j3) {
            if (j3 > this.f116409c) {
                if (ao.x(messageRecord.msgtype)) {
                    this.f116410d--;
                    return;
                }
                if (ConversationFacade.h0(this.f116407a) && ConversationFacade.C.a(messageRecord)) {
                    this.f116410d--;
                    return;
                }
                if (messageRecord.isLongMsg()) {
                    Map<String, Set<MessageRecord>> map = this.f116414h;
                    if (map != null && map.containsKey(ao.g(messageRecord)) && ConversationFacade.this.Y(messageRecord, this.f116414h.get(ao.g(messageRecord)))) {
                        this.f116410d--;
                        return;
                    }
                    if (this.f116413g == null) {
                        this.f116413g = new HashSet();
                    }
                    String g16 = ao.g(messageRecord);
                    if (ConversationFacade.C.b(messageRecord)) {
                        if (ConversationFacade.C.h(ConversationFacade.this.f116399d, messageRecord)) {
                            this.f116410d--;
                            return;
                        } else {
                            if (this.f116413g.contains(g16)) {
                                this.f116410d--;
                                return;
                            }
                            this.f116413g.add(g16);
                        }
                    } else if (this.f116413g.contains(g16)) {
                        this.f116413g.remove(g16);
                    }
                }
                this.f116411e += ConversationFacade.this.B(messageRecord);
                this.f116412f += ConversationFacade.this.L(messageRecord);
            }
        }

        public int b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.f116410d;
        }

        public int c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.f116411e;
        }

        public int d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return this.f116412f;
        }

        public d e() {
            long j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (d) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            for (MessageRecord messageRecord : this.f116408b) {
                if (ConversationFacade.h0(this.f116407a)) {
                    j3 = messageRecord.shmsgseq;
                } else {
                    j3 = messageRecord.time;
                }
                a(messageRecord, j3);
                f(messageRecord, j3);
            }
            return this;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37164);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 60)) {
            redirector.redirect((short) 60);
        } else {
            s.a();
            C = new a();
        }
    }

    public ConversationFacade(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime);
            return;
        }
        this.f116404m = new Object();
        this.f116399d = appRuntime;
        this.f116401f = new ArrayList();
    }

    private n A() {
        return C.k(this.f116399d);
    }

    private f D(int i3) {
        return C.v(this.f116399d, i3);
    }

    public static int G(ConversationInfo conversationInfo) {
        if (conversationInfo == null) {
            return 0;
        }
        return conversationInfo.unreadCount;
    }

    public static int I(ConversationInfo conversationInfo) {
        if (conversationInfo == null) {
            return 0;
        }
        return conversationInfo.unreadMark;
    }

    private RecentUserProxy K() {
        return C.getRecentUserProxy(this.f116399d);
    }

    private static SharedPreferences M(AppRuntime appRuntime, int i3) {
        String str;
        if (i3 == 1001) {
            str = "sp_nearby_summary_" + appRuntime.getAccount();
        } else {
            str = "";
        }
        if (!TextUtils.isEmpty(str)) {
            return SharedPreferencesProxyManager.getInstance().getProxy("sp_nearby_summary_" + appRuntime.getAccount(), 0);
        }
        return null;
    }

    private Set<String> N(int i3) {
        if (i3 == 1010) {
            if (this.f116402h == null) {
                this.f116402h = e0(AppConstants.DATE_SAY_HELLO_LIST_UIN, i3, "date_box_last_read_time");
            }
            return this.f116402h;
        }
        if (i3 == 1001) {
            if (this.f116403i == null) {
                this.f116403i = e0(AppConstants.LBS_SAY_HELLO_LIST_UIN, i3, "lbs_box_last_read_time");
            }
            return this.f116403i;
        }
        return null;
    }

    private static String O(String str, int i3, boolean z16) {
        String str2;
        if (z16) {
            str2 = "lastuin";
        } else {
            str2 = "sm";
        }
        return String.format("%s_%s_%s", str2, str, Integer.valueOf(i3));
    }

    public static int Q(ConversationInfo conversationInfo) {
        if (conversationInfo == null) {
            return 0;
        }
        try {
            ConversationInfo C2 = C.C(conversationInfo);
            if (C2.unreadMark > m.b() && ((ICommonFunctionPublishConfigService) QRoute.api(ICommonFunctionPublishConfigService.class)).isIgnoreInvalidUnreadMark()) {
                QLog.e("Q.unread.Facade", 1, "ignore Invalid UnreadMark. info: ", C2);
                return Math.max(C2.unreadCount, 0);
            }
            return Math.max(C2.unreadCount, C2.unreadMark);
        } catch (Exception e16) {
            QLog.d("Q.unread.Facade", 1, "getUnreadCount", e16);
            return 0;
        }
    }

    public static int T(ConversationInfo conversationInfo) {
        if (conversationInfo == null) {
            return 0;
        }
        return conversationInfo.extInt2;
    }

    private void X(ConversationInfo conversationInfo) {
        C.y(this.f116399d, conversationInfo, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Y(MessageRecord messageRecord, Set<MessageRecord> set) {
        if (set != null && !set.isEmpty()) {
            Iterator<MessageRecord> it = set.iterator();
            while (it.hasNext()) {
                if (ao.D(messageRecord, it.next())) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean a0(MessageRecord messageRecord) {
        int i3 = messageRecord.msgtype;
        if (i3 == -2055) {
            C.s(messageRecord, this);
            return false;
        }
        if (i3 == -2053 && (!C.n(messageRecord) || R(messageRecord.frienduin, messageRecord.msgtype) > 0)) {
            return true;
        }
        if (AppConstants.LBS_HELLO_UIN.equals(messageRecord.frienduin)) {
            A().p(messageRecord.senderuin, 1001, 1, B(messageRecord), L(messageRecord));
            return false;
        }
        A().p(messageRecord.frienduin, 1001, 1, B(messageRecord), L(messageRecord));
        return false;
    }

    private void b0(MessageRecord messageRecord) {
        if (C.u(messageRecord)) {
            A().C(messageRecord.frienduin, messageRecord.istroop);
            return;
        }
        if (AppConstants.KANDIAN_SUBSCRIBE_UIN.equals(messageRecord.frienduin) || AppConstants.KANDIAN_DAILY_UIN.equals(messageRecord.frienduin)) {
            A().d(messageRecord.frienduin, messageRecord.istroop);
        }
        if (AppConstants.Q_CIRCLE_PUBLIC_ACCOUNT_UIN.equals(messageRecord.frienduin) && A().m(messageRecord.frienduin, messageRecord.istroop) > 0) {
            A().r(messageRecord.frienduin, messageRecord.istroop, 0);
            A().d(messageRecord.frienduin, messageRecord.istroop);
        }
        A().p(messageRecord.frienduin, messageRecord.istroop, 1, B(messageRecord), L(messageRecord));
    }

    private boolean d(List<MessageRecord> list, Set<String> set, boolean z16) {
        for (MessageRecord messageRecord : list) {
            if (!messageRecord.isSendFromLocal() && !messageRecord.isread && (messageRecord.msgtype != -2006 || !C.x(messageRecord))) {
                if (messageRecord.isLongMsg()) {
                    String g16 = ao.g(messageRecord);
                    if (set == null) {
                        set = new HashSet<>();
                    }
                    if (C.b(messageRecord)) {
                        if (!C.h(this.f116399d, messageRecord) && !set.contains(g16)) {
                            set.add(g16);
                        }
                    } else if (set.contains(g16)) {
                        set.remove(g16);
                    }
                }
                if (!d0(list, messageRecord) && ao.r(messageRecord.istroop)) {
                    z16 = true;
                }
            }
        }
        return z16;
    }

    private boolean d0(List<MessageRecord> list, MessageRecord messageRecord) {
        boolean z16;
        int i3 = messageRecord.istroop;
        if (1001 != i3 && 10002 != i3) {
            if (1009 == i3) {
                A().p(messageRecord.frienduin, 1009, 1, B(messageRecord), L(messageRecord));
            } else if (1033 != i3 && 1034 != i3) {
                if (1008 == i3) {
                    b0(messageRecord);
                } else if (1044 == ao.c(i3)) {
                    A().p(messageRecord.frienduin, messageRecord.istroop, 1, B(messageRecord), L(messageRecord));
                    C.g(this.f116399d, 1044, messageRecord, list);
                } else if (10008 == ao.c(messageRecord.istroop)) {
                    A().p(messageRecord.frienduin, messageRecord.istroop, 1, B(messageRecord), L(messageRecord));
                    C.g(this.f116399d, 10008, messageRecord, list);
                } else {
                    l0(messageRecord, A().i(messageRecord.frienduin, messageRecord.istroop));
                    int i16 = messageRecord.istroop;
                    if (i16 == 10005) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        A().D(messageRecord.frienduin, messageRecord.istroop, 1);
                    } else {
                        if (1038 == i16) {
                            C.g(this.f116399d, 1038, messageRecord, list);
                        }
                        A().p(messageRecord.frienduin, messageRecord.istroop, 1, B(messageRecord), L(messageRecord));
                    }
                }
            } else {
                C.g(this.f116399d, 1033, messageRecord, list);
            }
        } else if (a0(messageRecord)) {
            return true;
        }
        return false;
    }

    private Set<String> e0(String str, int i3, String str2) {
        long j3;
        if (QLog.isColorLevel()) {
            j3 = System.currentTimeMillis();
            QLog.d(LogTag.MSGBOX, 2, "initSayHelloSet,boxType:" + i3 + ",startTime:" + j3);
        } else {
            j3 = 0;
        }
        SharedPreferences sharedPreferences = C.f(this.f116399d).getSharedPreferences(this.f116399d.getAccount(), 0);
        HashSet hashSet = new HashSet();
        List<MessageRecord> o16 = D(i3).o(str, i3);
        long j16 = sharedPreferences.getLong(str2, 0L);
        for (MessageRecord messageRecord : o16) {
            if (QLog.isDevelopLevel()) {
                QLog.d(LogTag.MSGBOX, 4, "lastTime:" + j16 + ",mr.time:" + messageRecord.time + ",uin:" + messageRecord.senderuin + ",istroop:" + messageRecord.istroop);
            }
            if (R(messageRecord.senderuin, i3) > 0 && messageRecord.time > j16) {
                hashSet.add(messageRecord.senderuin);
            }
        }
        if (QLog.isColorLevel()) {
            long currentTimeMillis = System.currentTimeMillis();
            QLog.d(LogTag.MSGBOX, 2, "initSayHelloSet,endTime:" + currentTimeMillis + ",costTime:" + (currentTimeMillis - j3));
        }
        return hashSet;
    }

    public static boolean h0(int i3) {
        if (i3 == 3000 || i3 == 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        j(AppConstants.NEARBY_LBS_HELLO_UIN, 1001);
        j(AppConstants.LBS_HELLO_UIN, 1001);
        j(AppConstants.SAME_STATE_BOX_UIN, 1009);
        j(AppConstants.DATE_UIN, 1010);
        j(AppConstants.CONFESS_UIN, 1032);
        j(AppConstants.MATCH_CHAT_UIN, 1044);
        j(AppConstants.QCIRCLE_CHAT_UIN, 10008);
    }

    private void l0(MessageRecord messageRecord, ConversationInfo conversationInfo) {
        p0(messageRecord, conversationInfo, 1044);
        p0(messageRecord, conversationInfo, 10008);
        p0(messageRecord, conversationInfo, 1045);
    }

    private boolean m(String str, int i3, long j3, List<MessageRecord> list) {
        if (((h0(i3) && list.get(list.size() - 1).shmsgseq <= j3) || (!h0(i3) && list.get(list.size() - 1).time <= j3)) && !ao.G(i3) && !ao.n(i3) && !C.isFileAssistantAio(str)) {
            if (A().l(str, i3) <= 0 && A().h(str, i3) <= 0 && A().k(str, i3) <= 0) {
                if (j3 > 0 && C(str, i3) < j3) {
                    o(str, i3, j3, false);
                }
                return true;
            }
            o(str, i3, j3, false);
            return true;
        }
        return false;
    }

    private void p0(MessageRecord messageRecord, ConversationInfo conversationInfo, int i3) {
        if (conversationInfo != null && conversationInfo.type == i3 && messageRecord.istroop != i3) {
            n0(messageRecord.frienduin, i3);
            if (QLog.isColorLevel()) {
                QLog.d("Q.unread.Facade", 2, "addUnread, remove old ConversationInfo,  uin=" + messageRecord.frienduin + ",new type" + messageRecord.istroop);
            }
        }
    }

    public static void r0(b bVar) {
        C = bVar;
    }

    private void u0() {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            ConcurrentHashMap<String, List<MessageRecord>> d16 = D(0).I().d();
            if (d16.get(ao.f(AppConstants.LBS_HELLO_UIN, 1001)) != null || d16.get(ao.f(AppConstants.SAME_STATE_BOX_UIN, 1009)) != null || d16.get(ao.f(AppConstants.DATE_UIN, 1010)) != null || d16.get(ao.f(AppConstants.CONFESS_UIN, 1032)) != null || d16.get(ao.f(AppConstants.NEARBY_LBS_HELLO_UIN, 1001)) != null || d16.get(ao.f(AppConstants.MATCH_CHAT_UIN, 1044)) != null || d16.get(ao.f(AppConstants.QCIRCLE_CHAT_UIN, 10008)) != null) {
                ThreadManagerV2.post(new Runnable() { // from class: com.tencent.imcore.message.ConversationFacade.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) ConversationFacade.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                            ConversationFacade.this.i();
                            ConversationFacade.C.r(ConversationFacade.this.f116399d, true, null);
                        } else {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                        }
                    }
                }, 8, null, false);
                return;
            }
            return;
        }
        i();
    }

    public int B(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            return ((Integer) iPatchRedirector.redirect((short) 47, (Object) this, (Object) messageRecord)).intValue();
        }
        if (messageRecord != null && !messageRecord.isSend() && !messageRecord.isread && messageRecord.msgtype == -2038) {
            return 1;
        }
        return 0;
    }

    public long C(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Long) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str, i3)).longValue();
        }
        return A().j(str, i3);
    }

    public String E(String str, int i3, String str2, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            return (String) iPatchRedirector.redirect((short) 56, this, str, Integer.valueOf(i3), str2, Integer.valueOf(i16));
        }
        if (!TextUtils.isEmpty(str) && ao.H(i3)) {
            SharedPreferences M = M(this.f116399d, i3);
            if (i3 != 1001 && i3 != 10002) {
                str = null;
            } else if (i16 >= 0 && i16 <= 0) {
                String str3 = AppConstants.LBS_HELLO_UIN;
                if (str3.equals(str)) {
                    str = M.getString(O(str3, i16, true), "");
                    String str4 = AppConstants.LBS_SAY_HELLO_LIST_UIN;
                    if (str4.equals(str)) {
                        str = M.getString(O(str4, i16, true), "");
                    }
                } else {
                    String str5 = AppConstants.LBS_SAY_HELLO_LIST_UIN;
                    if (str5.equals(str)) {
                        str = M.getString(O(str5, i16, true), "");
                    }
                }
            } else {
                return str2;
            }
            if (!TextUtils.isEmpty(str)) {
                return SecurityUtile.decode(M.getString(O(str, i16, false), str2));
            }
            return str2;
        }
        return str2;
    }

    public int F(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this, (Object) str, i3)).intValue();
        }
        return A().m(str, i3);
    }

    public int H(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, i3)).intValue();
        }
        return G(A().i(str, i3));
    }

    public int J(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, i3)).intValue();
        }
        return I(A().i(str, i3));
    }

    public int L(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            return ((Integer) iPatchRedirector.redirect((short) 48, (Object) this, (Object) messageRecord)).intValue();
        }
        if (messageRecord == null || messageRecord.isSend() || messageRecord.isread || !C.isRedPacketMsg(messageRecord)) {
            return 0;
        }
        return 1;
    }

    public ConversationInfo P(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            return (ConversationInfo) iPatchRedirector.redirect((short) 59, (Object) this, (Object) str, i3);
        }
        return A().i(str, i3);
    }

    public int R(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, i3)).intValue();
        }
        return Q(A().i(str, i3));
    }

    public int S(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, this, str, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
        }
        return C.t(this.f116399d, str, i3, i16);
    }

    public int U(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, i3)).intValue();
        }
        return T(A().i(str, i3));
    }

    public int V(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this, (Object) str, i3)).intValue();
        }
        return A().h(str, i3);
    }

    public int W(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this, (Object) str, i3)).intValue();
        }
        return A().k(str, i3);
    }

    public void c0(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.unread.Facade", 2, "increaseUnread uin=" + str + ",type" + i3 + ",count" + i16);
        }
        A().o(str, i3, i16);
        if (ao.r(i3)) {
            u0();
        }
    }

    public void e(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            iPatchRedirector.redirect((short) 50, (Object) this, i3, (Object) str);
            return;
        }
        Set<String> N = N(i3);
        if (N != null && !TextUtils.isEmpty(str)) {
            synchronized (this.f116404m) {
                if (!N.contains(str)) {
                    N.add(str);
                }
            }
        }
    }

    public synchronized void f(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, (Object) this, (Object) cVar);
            return;
        }
        if (this.f116400e) {
            ThreadManagerV2.excute(new Runnable(cVar) { // from class: com.tencent.imcore.message.ConversationFacade.3
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ c f116406d;

                {
                    this.f116406d = cVar;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ConversationFacade.this, (Object) cVar);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        this.f116406d.onRegisterProxyDone();
                    }
                }
            }, 16, null, true);
        } else if (!this.f116401f.contains(cVar)) {
            this.f116401f.add(cVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00cd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean f0(String str, int i3) {
        String str2;
        List<MessageRecord> o16;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Boolean) iPatchRedirector.redirect((short) 31, (Object) this, (Object) str, i3)).booleanValue();
        }
        if (str == null) {
            return false;
        }
        List<MessageRecord> list = null;
        if (i3 == 1009) {
            o16 = D(i3).o(AppConstants.SAME_STATE_BOX_UIN, 1009);
        } else {
            if (i3 == 1001) {
                list = D(i3).o(AppConstants.LBS_HELLO_UIN, 1001);
                if (list != null) {
                    list.addAll(D(i3).o(AppConstants.NEARBY_LBS_HELLO_UIN, 1001));
                } else {
                    list = D(i3).o(AppConstants.NEARBY_LBS_HELLO_UIN, 1001);
                }
                str2 = AppConstants.LBS_SAY_HELLO_LIST_UIN;
            } else if (i3 == 1010) {
                list = D(i3).o(AppConstants.DATE_UIN, 1010);
                str2 = AppConstants.DATE_SAY_HELLO_LIST_UIN;
            } else if (i3 == 1032) {
                o16 = D(i3).o(AppConstants.CONFESS_UIN, 1032);
            } else if (i3 == 1044) {
                o16 = D(i3).o(AppConstants.MATCH_CHAT_UIN, 1044);
            } else if (i3 == 10008) {
                o16 = D(i3).o(AppConstants.QCIRCLE_CHAT_UIN, 10008);
            } else {
                str2 = null;
            }
            if (list != null && !list.isEmpty()) {
                z16 = false;
                for (MessageRecord messageRecord : list) {
                    if (str.equals(messageRecord.senderuin)) {
                        return true;
                    }
                    if (str2 != null && !z16 && str2.equals(messageRecord.senderuin)) {
                        z16 = true;
                    }
                }
                if (z16) {
                    return g0(str, i3, str2);
                }
            }
            return false;
        }
        list = o16;
        str2 = null;
        if (list != null) {
            z16 = false;
            while (r2.hasNext()) {
            }
            if (z16) {
            }
        }
        return false;
    }

    public void g(List<MessageRecord> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) list);
            return;
        }
        if (list != null) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.unread.Facade", 2, "addUnread msg size=" + list.size());
            }
            if (d(list, null, false)) {
                u0();
            }
        }
    }

    public boolean g0(String str, int i3, String str2) {
        List<MessageRecord> o16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return ((Boolean) iPatchRedirector.redirect((short) 32, this, str, Integer.valueOf(i3), str2)).booleanValue();
        }
        if (str != null && !TextUtils.isEmpty(str2) && (o16 = D(i3).o(str2, i3)) != null && !o16.isEmpty()) {
            Iterator<MessageRecord> it = o16.iterator();
            while (it.hasNext()) {
                if (str.equals(it.next().senderuin)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void h(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this, (Object) str, i3);
        } else {
            C.j(this.f116399d, this, str, i3);
        }
    }

    public boolean i0(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return ((Boolean) iPatchRedirector.redirect((short) 39, (Object) this, (Object) str, i3)).booleanValue();
        }
        RecentUser findRecentUser = K().findRecentUser(str, i3);
        if (findRecentUser != null) {
            if (!C.l(this.f116399d, findRecentUser)) {
                return true;
            }
            return false;
        }
        if (7000 == i3) {
            return false;
        }
        if (!h0(i3)) {
            return j0(str);
        }
        if (C.e(this.f116399d, str)) {
            return true;
        }
        return false;
    }

    public void j(String str, int i3) {
        String str2;
        long j3;
        MessageRecord next;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) str, i3);
            return;
        }
        if (!ConversationFacadeExt.f116416a.b(str, i3)) {
            return;
        }
        if (AppConstants.CONFESS_UIN.equals(str)) {
            h(str, i3);
            return;
        }
        List<MessageRecord> o16 = D(i3).o(str, i3);
        if (o16 != null && !o16.isEmpty()) {
            if (ao.F(str)) {
                k(str, i3);
                return;
            }
            Iterator<MessageRecord> it = o16.iterator();
            boolean z16 = false;
            String str3 = "";
            int i16 = 0;
            int i17 = 0;
            int i18 = 0;
            loop0: while (true) {
                str2 = str3;
                while (it.hasNext()) {
                    next = it.next();
                    if (ao.F(next.senderuin)) {
                        k(next.senderuin, next.istroop);
                    } else if (!ao.B(next)) {
                        i17 += R(next.senderuin, next.istroop);
                    }
                    i18 += V(next.senderuin, next.istroop);
                    i16 += W(next.senderuin, next.istroop);
                    if (!TextUtils.isEmpty(str2) || i16 <= 0) {
                    }
                }
                str3 = next.senderuin;
            }
            if (W(str, i3) != i16) {
                z16 = true;
            }
            boolean z17 = z16;
            if (R(str, i3) != i17 || V(str, i3) != i18 || z17) {
                ConversationInfo i19 = A().i(str, i3);
                n A = A();
                if (i19 == null) {
                    j3 = 0;
                } else {
                    j3 = i19.lastread;
                }
                A.s(str, i3, j3, i17, i18, i16);
                if (ao.H(i3) && z17) {
                    v0(A().i(str, i3), str2);
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("Q.unread.Facade", 2, "calculateMsgBoxUnreadCount boxUin=" + str + ", unread=" + i17 + ", giftCount=" + i18 + ", redPacketCount=" + i16);
            }
        }
    }

    public boolean j0(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return ((Boolean) iPatchRedirector.redirect((short) 40, (Object) this, (Object) str)).booleanValue();
        }
        return K().isUinInRecentNotSubAccount(str);
    }

    public void k(String str, int i3) {
        boolean z16;
        String str2;
        long j3;
        int i16;
        Iterator<MessageRecord> it;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, (Object) str, i3);
            return;
        }
        List<MessageRecord> o16 = D(i3).o(str, i3);
        if (o16 != null && !o16.isEmpty()) {
            long j16 = this.f116399d.getPreferences().getLong(C.D(), 0L);
            long j17 = this.f116399d.getPreferences().getLong(C.d(), 0L);
            Iterator<MessageRecord> it5 = o16.iterator();
            String str3 = "";
            int i17 = 0;
            int i18 = 0;
            int i19 = 0;
            int i26 = 0;
            while (it5.hasNext()) {
                MessageRecord next = it5.next();
                Iterator<MessageRecord> it6 = it5;
                for (Iterator<MessageRecord> it7 = D(next.istroop).p(next.senderuin, next.istroop).iterator(); it7.hasNext(); it7 = it) {
                    MessageRecord next2 = it7.next();
                    long j18 = next2.time;
                    if (j18 > j16) {
                        it = it7;
                        if (!next2.isread) {
                            i17++;
                        }
                    } else {
                        it = it7;
                    }
                    if (j18 > j17 && !next2.isread) {
                        i19++;
                    }
                }
                if (V(next.senderuin, next.istroop) > 0 || W(next.senderuin, next.istroop) > 0) {
                    for (MessageRecord messageRecord : C.i(this.f116399d, next, R(next.senderuin, next.istroop) * 2)) {
                        if (messageRecord.time > j17) {
                            i26 += B(messageRecord);
                            i18 += L(messageRecord);
                        }
                    }
                }
                if (i18 > 0 && TextUtils.isEmpty(str3)) {
                    str3 = next.senderuin;
                }
                it5 = it6;
            }
            this.f116399d.getPreferences().edit().putInt("sp_key_sayhello_box_unread_count", i17).commit();
            if (W(str, i3) != i18) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (R(str, i3) == i19 && V(str, i3) == i26 && !z16) {
                str2 = str;
                i16 = 2;
            } else {
                str2 = str;
                ConversationInfo i27 = A().i(str2, i3);
                n A = A();
                if (i27 == null) {
                    j3 = 0;
                } else {
                    j3 = i27.lastread;
                }
                i16 = 2;
                A.s(str, i3, j3, i19, i26, i18);
                if (ao.H(i3) && z16) {
                    v0(A().i(str2, i3), str3);
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("Q.unread.Facade", i16, "calculateSayHelloBoxUnreadCount boxUin=" + str2 + ", unread=" + i19 + ", giftCount=" + i26 + ", redPacketCount=" + i18);
            }
        }
    }

    @Deprecated
    public void k0(String str, int i3, String str2, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, this, str, Integer.valueOf(i3), str2, Integer.valueOf(i16));
            return;
        }
        int l3 = A().l(str2, i16);
        int l16 = A().l(str, i3);
        if (QLog.isColorLevel()) {
            QLog.d("Q.unread.Facade", 2, "moveBoxToMessageTab innerItemUnread=" + l3 + ", convsItemUnread=" + l16);
        }
        j(str, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.unread.Facade", 2, "cleanAllUnread needUpdateMsgtable=" + z16 + ",needDelMark=" + z17);
        }
        if (z16) {
            for (ConversationInfo conversationInfo : A().e()) {
                if (Q(conversationInfo) > 0 && !AppConstants.FRIEND_SYSTEM_MSG_UIN.equals(conversationInfo.uin)) {
                    String str = AppConstants.ACTIVATE_FRIENDS_UIN;
                    if (!str.equals(conversationInfo.uin) || str.equals(conversationInfo.uin)) {
                        r(conversationInfo.uin, conversationInfo.type, z17);
                    }
                }
                X(conversationInfo);
            }
            C.c(this.f116399d, true, z17, this);
            return;
        }
        A().c();
        C.c(this.f116399d, false, z17, this);
    }

    public synchronized void m0(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, (Object) this, (Object) cVar);
        } else {
            if (cVar != null) {
                this.f116401f.remove(cVar);
            }
        }
    }

    public void n(String str, int i3, int i16, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, str, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16));
        } else if (i3 != 1033 && i3 != 1034) {
            o(str, i3, A().j(str, i3), z16);
        } else {
            q(str, i3, C.A(this.f116399d, str, i3, i16), true, z16, i16);
        }
    }

    public void n0(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) str, i3);
        } else {
            r(str, i3, true);
            A().B(str, i3);
        }
    }

    public void o(String str, int i3, long j3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, str, Integer.valueOf(i3), Long.valueOf(j3), Boolean.valueOf(z16));
        } else {
            p(str, i3, j3, true, z16);
        }
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, (Object) this);
            return;
        }
        deleteObservers();
        synchronized (this) {
            this.f116401f.clear();
        }
    }

    public void p(String str, int i3, long j3, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, str, Integer.valueOf(i3), Long.valueOf(j3), Boolean.valueOf(z16), Boolean.valueOf(z17));
        } else {
            SystemClock.elapsedRealtime();
            q(str, i3, j3, z16, z17, 0);
        }
    }

    public void q(String str, int i3, long j3, boolean z16, boolean z17, int i16) {
        long j16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, str, Integer.valueOf(i3), Long.valueOf(j3), Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(i16));
            return;
        }
        if (i3 != 1033 && i3 != 1034) {
            j16 = A().l(str, i3);
            if (z17) {
                A().t(str, i3, 0);
            }
            A().s(str, i3, j3, 0, 0, 0);
        } else {
            C.p(this.f116399d, str, i3, i16, j3);
            j16 = 0;
        }
        if (j16 > 0) {
            if (ao.r(i3) && z16) {
                u0();
            }
            Message m3 = C.m(this.f116399d, str, i3, i16);
            if (m3 != null) {
                D(i3).u0(str, i3, m3, i16);
            }
        }
        C.z(str, i3, true, 0L);
    }

    public void q0(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.unread.Facade", 2, "rewriteUnreadCount uin=" + str + ",type" + i3 + ",unread" + i16);
        }
        A().r(str, i3, i16);
    }

    public void r(String str, int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, str, Integer.valueOf(i3), Boolean.valueOf(z16));
        } else {
            n(str, i3, 0, z16);
        }
    }

    public void s(String str, int i3, long j3) {
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, str, Integer.valueOf(i3), Long.valueOf(j3));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.unread.Facade", 2, "cleanUnreadFrom uin=" + str + ",type=" + i3 + ",lastread=" + j3);
        }
        if (i3 == 1008) {
            z16 = C.B(this.f116399d, str);
        } else {
            z16 = false;
        }
        if (i3 == 1008 && C.w(this.f116399d, str) && !z16) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.unread.Facade", 2, "isTroopBarAccount");
                return;
            }
            return;
        }
        if (i3 == 1008 && TextUtils.equals(str, AppConstants.NEW_KANDIAN_UIN)) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.unread.Facade", 2, "NEW_KANDIAN_UIN not unread");
                return;
            }
            return;
        }
        t0(str, i3, j3);
        D(i3).v0(str, i3, j3);
        if (i3 == 1008 && z16) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.unread.Facade", 2, "inServiceAccountFolder uin=" + str);
            }
            C.q(this.f116399d, str);
        }
        C.refreshAppBadge(this.f116399d);
        if (R(str, i3) == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        C.z(str, i3, z17, j3);
    }

    public void s0(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            A().t(str, i3, i16);
        }
    }

    public void t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            iPatchRedirector.redirect((short) 52, (Object) this);
        } else {
            C.c(this.f116399d, true, true, this);
        }
    }

    public void t0(String str, int i3, long j3) {
        long j16;
        long r06;
        long j17;
        String str2;
        long j18;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, str, Integer.valueOf(i3), Long.valueOf(j3));
            return;
        }
        List<MessageRecord> p16 = D(i3).p(str, i3);
        if (p16 != null && !p16.isEmpty()) {
            if (m(str, i3, j3, p16)) {
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("Q.unread.Facade", 2, "updateLastReadSeq uin=" + str + ",type=" + i3 + ",lastread=" + j3);
            }
            ConversationInfo i17 = A().i(str, i3);
            if (i17 != null) {
                if (h0(i3)) {
                    j18 = Math.max(j3, i17.lastread);
                } else {
                    j18 = j3;
                }
                i16 = i17.unreadCount;
                j16 = j18;
            } else {
                j16 = j3;
            }
            if (h0(i3)) {
                r06 = p16.get(p16.size() - 1).shmsgseq - j16;
            } else {
                r06 = D(i3).r0(str, i3, j3);
            }
            int i18 = (int) r06;
            if (QLog.isColorLevel()) {
                QLog.d("Q.unread.Facade", 2, "updateLastReadSeq unread =" + i18);
            }
            long j19 = j16;
            int i19 = i16;
            d e16 = new d(i3, p16, j19, i18, 0, 0, null, null).e();
            int b16 = e16.b();
            int c16 = e16.c();
            int d16 = e16.d();
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("updateLastReadSeq before=");
                if (i17 != null) {
                    str2 = i17.toString();
                } else {
                    str2 = null;
                }
                sb5.append(str2);
                sb5.append(" , end unread=");
                sb5.append(b16);
                sb5.append(", lastread=");
                j17 = j19;
                sb5.append(j17);
                sb5.append(",unreadGift=");
                sb5.append(c16);
                sb5.append(",unreadRedPacket=");
                sb5.append(d16);
                QLog.d("Q.unread.Facade", 2, sb5.toString());
            } else {
                j17 = j19;
            }
            A().s(str, i3, j17, b16, c16, d16);
            if (b16 != i19 && ao.r(i3)) {
                u0();
                return;
            }
            return;
        }
        if (A().l(str, i3) > 0) {
            o(str, i3, j3, true);
        }
    }

    public void u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            iPatchRedirector.redirect((short) 57, (Object) this);
            return;
        }
        SharedPreferences M = M(this.f116399d, 1001);
        SharedPreferences.Editor edit = M.edit();
        ConversationFacade o16 = C.o(this.f116399d);
        int i3 = 0;
        boolean z16 = false;
        for (MessageRecord messageRecord : D(1001).o(AppConstants.LBS_HELLO_UIN, 1001)) {
            if (o16.W(messageRecord.senderuin, 1001) <= 0) {
                String O = O(messageRecord.senderuin, 0, false);
                if (M.contains(O)) {
                    edit.remove(O);
                    i3++;
                    z16 = true;
                }
            }
        }
        for (MessageRecord messageRecord2 : D(1001).o(AppConstants.LBS_SAY_HELLO_LIST_UIN, 1001)) {
            if (o16.W(messageRecord2.senderuin, 1001) <= 0) {
                String O2 = O(messageRecord2.senderuin, 0, false);
                if (M.contains(O2)) {
                    edit.remove(O2);
                    i3++;
                    z16 = true;
                }
            }
        }
        if (z16) {
            edit.commit();
        }
        if (QLog.isColorLevel()) {
            QLog.i(LogTag.MSGBOX, 2, "clearMrSummary2, count=" + i3);
        }
    }

    public void v(int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            iPatchRedirector.redirect((short) 51, this, Integer.valueOf(i3), Long.valueOf(j3));
            return;
        }
        Set<String> N = N(i3);
        if (N == null) {
            return;
        }
        synchronized (this.f116404m) {
            N.clear();
        }
        SharedPreferences sharedPreferences = C.f(this.f116399d).getSharedPreferences(this.f116399d.getAccount(), 0);
        if (i3 == 1010) {
            sharedPreferences.edit().putLong("date_box_last_read_time", j3).commit();
        } else if (i3 == 1001) {
            sharedPreferences.edit().putLong("lbs_box_last_read_time", j3).commit();
        }
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.MSGBOX, 2, "clearNewSayHelloSet,boxType:" + i3 + ",time:" + j3);
        }
    }

    public void v0(ConversationInfo conversationInfo, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            iPatchRedirector.redirect((short) 54, (Object) this, (Object) conversationInfo, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(LogTag.MSGBOX, 2, "updateSummaryLastUin info = " + conversationInfo + ", lbsHongbaoLastUin = " + str);
        }
        if (conversationInfo != null && ao.H(conversationInfo.type) && !TextUtils.isEmpty(conversationInfo.uin)) {
            SharedPreferences.Editor edit = M(this.f116399d, conversationInfo.type).edit();
            int i3 = conversationInfo.type;
            boolean z16 = false;
            if (i3 == 1001 || i3 == 10002) {
                if (!AppConstants.LBS_SAY_HELLO_LIST_UIN.equals(conversationInfo.uin) && !AppConstants.LBS_HELLO_UIN.equals(conversationInfo.uin)) {
                    return;
                }
                if (conversationInfo.extInt1 > 0 && !TextUtils.isEmpty(str)) {
                    edit.putString(O(conversationInfo.uin, 0, true), str);
                } else {
                    edit.remove(O(conversationInfo.uin, 0, true));
                }
                z16 = true;
            }
            if (z16) {
                edit.commit();
            }
        }
    }

    public void w(String str, int i3, MessageRecord messageRecord) {
        int i16;
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, this, str, Integer.valueOf(i3), messageRecord);
            return;
        }
        if (messageRecord != null) {
            i16 = B(messageRecord) * (-1);
            i17 = L(messageRecord) * (-1);
        } else {
            i16 = 0;
            i17 = 0;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.unread.Facade", 2, "increaseUnread uin=" + str + ",type" + i3 + ",unreadDiff-1,unreadGiftDiff=" + i16 + ",unreadRedPacketDiff=" + i17 + ",mr=" + messageRecord);
        }
        A().p(str, i3, -1, i16, i17);
        if (ao.r(i3)) {
            u0();
        }
    }

    public void w0(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            A().F(str, i3, i16);
        }
    }

    public void x(String str, int i3, List<MessageRecord> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, this, str, Integer.valueOf(i3), list);
            return;
        }
        int i16 = 0;
        int i17 = 0;
        for (MessageRecord messageRecord : list) {
            int B = B(messageRecord) * (-1);
            int L = L(messageRecord) * (-1);
            if (messageRecord != null) {
                i16 += B;
                i17 += L;
                if (QLog.isColorLevel()) {
                    QLog.d("Q.unread.Facade", 2, "increaseUnread uin=" + str + ",type" + i3 + ",unreadDiff-1,unreadGiftDiff=" + B + ",unreadRedPacketDiff=" + L + ",mr=" + messageRecord);
                }
            }
        }
        A().p(str, i3, list.size(), i16, i17);
        if (ao.r(i3)) {
            u0();
        }
    }

    public synchronized ConversationInfo y(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            return (ConversationInfo) iPatchRedirector.redirect((short) 58, (Object) this, (Object) str, i3);
        }
        return A().i(str, i3);
    }

    public Set<ConversationInfo> z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (Set) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return A().e();
    }
}
