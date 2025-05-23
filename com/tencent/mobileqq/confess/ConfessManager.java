package com.tencent.mobileqq.confess;

import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForConfessNews;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.service.message.q;
import com.tencent.mobileqq.utils.ac;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import mqq.manager.Manager;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ConfessManager implements Manager {
    static IPatchRedirector $redirector_;
    a C;
    a D;
    final ArrayList<b> E;
    final Object F;
    b G;
    b H;

    /* renamed from: d, reason: collision with root package name */
    QQAppInterface f202084d;

    /* renamed from: e, reason: collision with root package name */
    ConfessConfig f202085e;

    /* renamed from: f, reason: collision with root package name */
    final d f202086f;

    /* renamed from: h, reason: collision with root package name */
    final com.tencent.mobileqq.confess.a f202087h;

    /* renamed from: i, reason: collision with root package name */
    final ArrayList<a> f202088i;

    /* renamed from: m, reason: collision with root package name */
    final Object f202089m;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.confess.ConfessManager$2, reason: invalid class name */
    /* loaded from: classes5.dex */
    class AnonymousClass2 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f202090d;
        final /* synthetic */ ConfessManager this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            a aVar = this.this$0.C;
            if (aVar == null) {
                return;
            }
            if (TextUtils.isEmpty(aVar.f202103g)) {
                aVar.f202103g = ac.F(this.this$0.f202084d, aVar.f202104h);
            }
            if (aVar.f202109m == 0) {
                aVar.f202109m = this.this$0.d(this.f202090d, aVar.f202104h, aVar.f202105i, aVar.f202097a);
            }
            if (aVar.f202109m == 1) {
                long K0 = com.tencent.mobileqq.service.message.e.K0();
                this.this$0.a(this.f202090d, aVar, K0, K0);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.confess.ConfessManager$3, reason: invalid class name */
    /* loaded from: classes5.dex */
    class AnonymousClass3 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f202091d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ a f202092e;
        final /* synthetic */ ConfessManager this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                this.this$0.s(this.f202091d, this.f202092e);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.confess.ConfessManager$4, reason: invalid class name */
    /* loaded from: classes5.dex */
    class AnonymousClass4 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f202093d;
        final /* synthetic */ ConfessManager this$0;

        @Override // java.lang.Runnable
        public void run() {
            long abs;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            ConfessManager confessManager = this.this$0;
            b bVar = confessManager.G;
            if (bVar != null && confessManager.f202084d != null) {
                TextUtils.isEmpty(bVar.f202115f);
                if (bVar.f202122m == 0) {
                    bVar.f202122m = this.this$0.c(this.f202093d, bVar.f202117h, bVar.f202111b, bVar.f202118i, bVar.f202112c);
                }
                if (bVar.f202122m == 1) {
                    long K0 = com.tencent.mobileqq.service.message.e.K0();
                    List<ChatMessage> l16 = this.this$0.f202084d.getMessageFacade().l1(this.f202093d, 1);
                    if (l16 != null && !l16.isEmpty()) {
                        abs = l16.get(l16.size() - 1).shmsgseq + 1;
                    } else {
                        abs = Math.abs(new Random().nextInt());
                        bVar.f202123n = true;
                    }
                    long j3 = abs;
                    if (QLog.isDevelopLevel()) {
                        QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "enterGroupRecConfessChat shmsgseq: %s isRandomShmsgseq:%s", Long.valueOf(j3), Boolean.valueOf(bVar.f202123n)));
                    }
                    this.this$0.b(this.f202093d, bVar, K0, K0, j3);
                }
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.confess.ConfessManager$5, reason: invalid class name */
    /* loaded from: classes5.dex */
    class AnonymousClass5 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f202094d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ b f202095e;
        final /* synthetic */ ConfessManager this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                this.this$0.t(this.f202094d, this.f202095e);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.confess.ConfessManager$6, reason: invalid class name */
    /* loaded from: classes5.dex */
    class AnonymousClass6 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f202096d;
        final /* synthetic */ ConfessManager this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            a aVar = this.this$0.C;
            if (aVar == null) {
                return;
            }
            if (TextUtils.isEmpty(aVar.f202103g)) {
                aVar.f202103g = ac.F(this.this$0.f202084d, aVar.f202104h);
            }
            if (aVar.f202109m == 0) {
                aVar.f202109m = this.this$0.d(this.f202096d, aVar.f202104h, aVar.f202105i, aVar.f202097a);
            }
            if (aVar.f202109m == 1) {
                long K0 = com.tencent.mobileqq.service.message.e.K0();
                this.this$0.a(this.f202096d, aVar, K0, K0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f202097a;

        /* renamed from: b, reason: collision with root package name */
        public int f202098b;

        /* renamed from: c, reason: collision with root package name */
        public int f202099c;

        /* renamed from: d, reason: collision with root package name */
        public int f202100d;

        /* renamed from: e, reason: collision with root package name */
        public int f202101e;

        /* renamed from: f, reason: collision with root package name */
        public int f202102f;

        /* renamed from: g, reason: collision with root package name */
        public String f202103g;

        /* renamed from: h, reason: collision with root package name */
        public String f202104h;

        /* renamed from: i, reason: collision with root package name */
        public String f202105i;

        /* renamed from: j, reason: collision with root package name */
        public String f202106j;

        /* renamed from: k, reason: collision with root package name */
        public String f202107k;

        /* renamed from: l, reason: collision with root package name */
        public long f202108l;

        /* renamed from: m, reason: collision with root package name */
        public int f202109m;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("nTopicId", this.f202097a);
                jSONObject.put("nBGType", this.f202098b);
                jSONObject.put("nConfessorSex", this.f202099c);
                jSONObject.put("strRecNick", this.f202103g);
                jSONObject.put("strRecUin", this.f202104h);
                jSONObject.put("strConfessorUin", this.f202105i);
                jSONObject.put("strConfessorDesc", this.f202106j);
                jSONObject.put("strConfessorNick", this.f202107k);
                jSONObject.put("flag", this.f202109m);
                jSONObject.put("confessTime", this.f202108l);
                jSONObject.put("nConfessNum", this.f202100d);
                jSONObject.put("nGetConfessSex", this.f202101e);
                jSONObject.put("nBizType", this.f202102f);
                return jSONObject.toString();
            } catch (Exception e16) {
                e16.printStackTrace();
                return "";
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f202110a;

        /* renamed from: b, reason: collision with root package name */
        public String f202111b;

        /* renamed from: c, reason: collision with root package name */
        public int f202112c;

        /* renamed from: d, reason: collision with root package name */
        public int f202113d;

        /* renamed from: e, reason: collision with root package name */
        public int f202114e;

        /* renamed from: f, reason: collision with root package name */
        public String f202115f;

        /* renamed from: g, reason: collision with root package name */
        public int f202116g;

        /* renamed from: h, reason: collision with root package name */
        public String f202117h;

        /* renamed from: i, reason: collision with root package name */
        public String f202118i;

        /* renamed from: j, reason: collision with root package name */
        public String f202119j;

        /* renamed from: k, reason: collision with root package name */
        public String f202120k;

        /* renamed from: l, reason: collision with root package name */
        public long f202121l;

        /* renamed from: m, reason: collision with root package name */
        public int f202122m;

        /* renamed from: n, reason: collision with root package name */
        public boolean f202123n;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f202123n = false;
            }
        }

        public String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("strGroupUin", this.f202110a);
                jSONObject.put("strSendUin", this.f202111b);
                jSONObject.put("nTopicId", this.f202112c);
                jSONObject.put("nBGType", this.f202113d);
                jSONObject.put("nConfessorSex", this.f202114e);
                jSONObject.put("strRecNick", this.f202115f);
                jSONObject.put("nRecNickType", this.f202116g);
                jSONObject.put("strRecUin", this.f202117h);
                jSONObject.put("strConfessorUin", this.f202118i);
                jSONObject.put("strConfessorDesc", this.f202119j);
                jSONObject.put("strConfessorNick", this.f202120k);
                jSONObject.put("flag", this.f202122m);
                jSONObject.put("confessTime", this.f202121l);
                jSONObject.put("isRandomShmsgseq", this.f202123n);
                return jSONObject.toString();
            } catch (Exception e16) {
                e16.printStackTrace();
                return "";
            }
        }
    }

    public ConfessManager(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f202089m = new Object();
        this.C = null;
        this.D = null;
        this.F = new Object();
        this.G = null;
        this.H = null;
        this.f202084d = qQAppInterface;
        this.f202088i = new ArrayList<>();
        this.f202086f = new d(qQAppInterface.getAccount());
        this.f202087h = new com.tencent.mobileqq.confess.a();
        this.f202085e = new ConfessConfig(this.f202084d.getAccount());
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.confess.ConfessManager.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ConfessManager.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                d dVar = ConfessManager.this.f202086f;
                if (!dVar.f202177c) {
                    dVar.a();
                }
            }
        }, 5, null, true);
        this.E = new ArrayList<>();
    }

    private a k(String str, String str2, int i3) {
        a aVar;
        synchronized (this.f202088i) {
            Iterator<a> it = this.f202088i.iterator();
            while (true) {
                if (it.hasNext()) {
                    aVar = it.next();
                    if (aVar != null && aVar.f202097a == i3 && TextUtils.equals(aVar.f202104h, str) && TextUtils.equals(aVar.f202105i, str2)) {
                        break;
                    }
                } else {
                    aVar = null;
                    break;
                }
            }
            if (aVar == null) {
                aVar = new a();
                aVar.f202104h = str;
                aVar.f202105i = str2;
                aVar.f202097a = i3;
                aVar.f202109m = 0;
                this.f202088i.add(aVar);
            }
        }
        return aVar;
    }

    private b m(String str, String str2, String str3, String str4, int i3) {
        b bVar;
        synchronized (this.E) {
            Iterator<b> it = this.E.iterator();
            while (true) {
                if (it.hasNext()) {
                    bVar = it.next();
                    if (bVar != null && bVar.f202112c == i3 && TextUtils.equals(bVar.f202110a, str) && TextUtils.equals(bVar.f202117h, str2) && TextUtils.equals(bVar.f202111b, str3) && TextUtils.equals(bVar.f202118i, str4)) {
                        break;
                    }
                } else {
                    bVar = null;
                    break;
                }
            }
            if (bVar == null) {
                bVar = new b();
                bVar.f202110a = str;
                bVar.f202117h = str2;
                bVar.f202111b = str3;
                bVar.f202118i = str4;
                bVar.f202112c = i3;
                bVar.f202122m = 0;
                this.E.add(bVar);
            }
        }
        return bVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(String str, a aVar, long j3, long j16) {
        Object obj;
        int i3;
        char c16;
        String a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, str, aVar, Long.valueOf(j3), Long.valueOf(j16));
            return;
        }
        if (aVar != null && !TextUtils.isEmpty(str)) {
            Object obj2 = this.f202089m;
            synchronized (obj2) {
                try {
                } catch (Throwable th5) {
                    th = th5;
                }
                try {
                    if (aVar.f202109m == 0) {
                        aVar.f202109m = d(str, aVar.f202104h, aVar.f202105i, aVar.f202097a);
                    }
                    if (aVar.f202109m == 1) {
                        try {
                            a16 = aVar.a();
                        } catch (Exception e16) {
                            e = e16;
                            obj = obj2;
                            i3 = 1;
                            c16 = 0;
                        }
                        if (!TextUtils.isEmpty(a16)) {
                            MessageRecord d16 = q.d(MessageRecord.MSG_TYPE_CONFESS_NEWS);
                            obj = obj2;
                            i3 = 1;
                            try {
                                d16.init(this.f202084d.getCurrentAccountUin(), str, str, a16, j3, MessageRecord.MSG_TYPE_CONFESS_NEWS, 0, j16);
                                d16.isread = true;
                                c16 = 0;
                                try {
                                    if (!MessageHandlerUtils.msgFilter(this.f202084d, d16, false)) {
                                        this.f202084d.getMessageFacade().c(d16, d16.selfuin);
                                    }
                                } catch (Exception e17) {
                                    e = e17;
                                    QLog.i("ConfessManager", i3, "addFrdConfessNews error: " + e.getMessage());
                                    if (QLog.isDevelopLevel()) {
                                    }
                                }
                            } catch (Exception e18) {
                                e = e18;
                                c16 = 0;
                            }
                            if (QLog.isDevelopLevel()) {
                                Locale locale = Locale.getDefault();
                                Object[] objArr = new Object[4];
                                objArr[c16] = str;
                                objArr[i3] = aVar.f202104h;
                                objArr[2] = aVar.f202105i;
                                objArr[3] = Integer.valueOf(aVar.f202097a);
                                QLog.i("ConfessManager", 4, String.format(locale, "addFrdConfessNews frdUin: %s recUin: %s, confessorUin: %s topicId: %s", objArr));
                                return;
                            }
                            return;
                        }
                    }
                    obj = obj2;
                    i3 = 1;
                    c16 = 0;
                    if (QLog.isDevelopLevel()) {
                    }
                } catch (Throwable th6) {
                    th = th6;
                    throw th;
                }
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(String str, b bVar, long j3, long j16, long j17) {
        Object obj;
        int i3;
        char c16;
        int i16;
        String a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, str, bVar, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17));
            return;
        }
        if (bVar != null && !TextUtils.isEmpty(str)) {
            Object obj2 = this.F;
            synchronized (obj2) {
                try {
                } catch (Throwable th5) {
                    th = th5;
                }
                try {
                    if (bVar.f202122m == 0) {
                        bVar.f202122m = c(str, bVar.f202117h, bVar.f202111b, bVar.f202118i, bVar.f202112c);
                    }
                    if (bVar.f202122m == 1) {
                        try {
                            a16 = bVar.a();
                        } catch (Exception e16) {
                            e = e16;
                            obj = obj2;
                            i3 = 1;
                            c16 = 0;
                            i16 = 4;
                        }
                        if (!TextUtils.isEmpty(a16)) {
                            MessageRecord d16 = q.d(MessageRecord.MSG_TYPE_CONFESS_NEWS);
                            obj = obj2;
                            i3 = 1;
                            c16 = 0;
                            i16 = 4;
                            try {
                                d16.init(this.f202084d.getCurrentAccountUin(), str, bVar.f202111b, a16, j3, MessageRecord.MSG_TYPE_CONFESS_NEWS, 1, j16);
                                d16.isread = true;
                                d16.shmsgseq = j17;
                                if (QLog.isDevelopLevel()) {
                                    QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "addGroupConfessNews in 1 %s", Long.valueOf(j17)));
                                }
                                if (!MessageHandlerUtils.msgFilter(this.f202084d, d16, false)) {
                                    this.f202084d.getMessageFacade().c(d16, d16.selfuin);
                                    if (QLog.isDevelopLevel()) {
                                        QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "addGroupConfessNews in 2", new Object[0]));
                                    }
                                }
                            } catch (Exception e17) {
                                e = e17;
                                QLog.i("ConfessManager", i3, "addGroupConfessNews error: " + e.getMessage());
                                if (QLog.isDevelopLevel()) {
                                }
                            }
                            if (QLog.isDevelopLevel()) {
                                Locale locale = Locale.getDefault();
                                Object[] objArr = new Object[5];
                                objArr[c16] = str;
                                objArr[i3] = bVar.f202117h;
                                objArr[2] = bVar.f202111b;
                                objArr[3] = bVar.f202118i;
                                objArr[i16] = Integer.valueOf(bVar.f202112c);
                                QLog.i("ConfessManager", i16, String.format(locale, "addGroupConfessNews groupUin: %s recUin: %s, sendUin: %s, confessorUin: %s topicId: %s", objArr));
                                return;
                            }
                            return;
                        }
                    }
                    obj = obj2;
                    i3 = 1;
                    c16 = 0;
                    i16 = 4;
                    if (QLog.isDevelopLevel()) {
                    }
                } catch (Throwable th6) {
                    th = th6;
                    throw th;
                }
            }
            throw th;
        }
    }

    public int c(String str, String str2, String str3, String str4, int i3) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, this, str, str2, str3, str4, Integer.valueOf(i3))).intValue();
        }
        List<MessageRecord> D = this.f202084d.getMessageFacade().D(str, 1, new int[]{MessageRecord.MSG_TYPE_CONFESS_NEWS});
        if (D != null && D.size() > 0) {
            for (MessageRecord messageRecord : D) {
                if (messageRecord instanceof MessageForConfessNews) {
                    MessageForConfessNews messageForConfessNews = (MessageForConfessNews) messageRecord;
                    messageForConfessNews.parse();
                    if (messageForConfessNews.nTopicId == i3 && TextUtils.equals(str, messageForConfessNews.strGroupUin) && TextUtils.equals(str3, messageForConfessNews.senderuin) && TextUtils.equals(str4, messageForConfessNews.strConfessorUin) && TextUtils.equals(str2, messageForConfessNews.strRecUin)) {
                        i16 = 2;
                        break;
                    }
                }
            }
        }
        i16 = 1;
        if (QLog.isDevelopLevel()) {
            QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "checkGroupNeedAddConfessElem groupUin: %s, sendUin: %s, confessorUin: %s, topicId: %s, flag: %s", str, str3, str4, Integer.valueOf(i3), Integer.valueOf(i16)));
        }
        return i16;
    }

    public int d(String str, String str2, String str3, int i3) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, this, str, str2, str3, Integer.valueOf(i3))).intValue();
        }
        List<MessageRecord> D = this.f202084d.getMessageFacade().D(str, 0, new int[]{MessageRecord.MSG_TYPE_CONFESS_NEWS});
        if (D != null && D.size() > 0) {
            for (MessageRecord messageRecord : D) {
                if (messageRecord instanceof MessageForConfessNews) {
                    MessageForConfessNews messageForConfessNews = (MessageForConfessNews) messageRecord;
                    messageForConfessNews.parse();
                    if (messageForConfessNews.nTopicId == i3 && TextUtils.equals(str3, messageForConfessNews.strConfessorUin) && TextUtils.equals(str2, messageForConfessNews.strRecUin)) {
                        i16 = 2;
                        break;
                    }
                }
            }
        }
        i16 = 1;
        if (QLog.isDevelopLevel()) {
            QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "checkNeedAddConfessElem frdUin: %s, confessorUin: %s, topicId: %s, flag: %s", str, str3, Integer.valueOf(i3), Integer.valueOf(i16)));
        }
        return i16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4, types: [int] */
    /* JADX WARN: Type inference failed for: r7v6 */
    public void e(String str, String str2, String str3, String str4, int i3, long j3) {
        List<MessageRecord> D;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        boolean z17 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, str, str2, str3, str4, Integer.valueOf(i3), Long.valueOf(j3));
            return;
        }
        Iterator<b> it = this.E.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            b next = it.next();
            if (next != null) {
                if (next.f202112c == i3 && TextUtils.equals(next.f202110a, str) && TextUtils.equals(next.f202117h, str2) && TextUtils.equals(next.f202111b, str3) && TextUtils.equals(next.f202118i, str4)) {
                    if (next.f202123n) {
                        next.f202123n = z16;
                    } else {
                        List<MessageRecord> N = this.f202084d.getMessageFacade().N(str, z17 ? 1 : 0, 6);
                        if (N != null && N.size() > 0) {
                            for (?? r75 = z16; r75 < N.size(); r75++) {
                                MessageRecord messageRecord = N.get(r75);
                                if (messageRecord instanceof MessageForConfessNews) {
                                    MessageForConfessNews messageForConfessNews = (MessageForConfessNews) messageRecord;
                                    messageForConfessNews.parse();
                                    if (messageForConfessNews.nTopicId == i3 && TextUtils.equals(str, messageForConfessNews.strGroupUin) && TextUtils.equals(str3, messageForConfessNews.senderuin) && TextUtils.equals(str4, messageForConfessNews.strConfessorUin) && TextUtils.equals(str2, messageForConfessNews.strRecUin) && (i16 = r75 + 1) < N.size()) {
                                        MessageRecord messageRecord2 = N.get(i16);
                                        this.f202084d.getMessageFacade().g2(messageRecord2.frienduin, messageRecord2.istroop, messageRecord2.uniseq, messageRecord2.shmsgseq, messageRecord2.time);
                                    }
                                }
                            }
                        }
                    }
                } else {
                    z16 = false;
                    z17 = true;
                }
            }
        }
        z17 = false;
        if (QLog.isDevelopLevel()) {
            QLog.i("ConfessManager", 4, "checkUpdateGroupMessageForConfessNewsShmsgseq find: " + z17 + " shmsgseq: " + j3);
        }
        if (z17 && (D = this.f202084d.getMessageFacade().D(str, 1, new int[]{MessageRecord.MSG_TYPE_CONFESS_NEWS})) != null && D.size() > 0) {
            for (MessageRecord messageRecord3 : D) {
                if (messageRecord3 instanceof MessageForConfessNews) {
                    MessageForConfessNews messageForConfessNews2 = (MessageForConfessNews) messageRecord3;
                    messageForConfessNews2.parse();
                    if (messageForConfessNews2.nTopicId == i3 && TextUtils.equals(str, messageForConfessNews2.strGroupUin) && TextUtils.equals(str3, messageForConfessNews2.senderuin) && TextUtils.equals(str4, messageForConfessNews2.strConfessorUin) && TextUtils.equals(str2, messageForConfessNews2.strRecUin)) {
                        this.f202084d.getMessageFacade().g2(messageForConfessNews2.frienduin, messageForConfessNews2.istroop, messageForConfessNews2.uniseq, j3, messageForConfessNews2.time);
                        if (QLog.isDevelopLevel()) {
                            QLog.i("ConfessManager", 4, "checkUpdateGroupMessageForConfessNewsShmsgseq updated");
                            return;
                        }
                        return;
                    }
                }
            }
        }
    }

    public com.tencent.mobileqq.confess.a f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.mobileqq.confess.a) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f202087h;
    }

    public ConfessConfig g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (ConfessConfig) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.f202085e;
    }

    public ConfessConfig h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ConfessConfig) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        if (QLog.isColorLevel()) {
            QLog.i("ConfessManager", 2, "getConfigSync");
        }
        this.f202085e.f();
        return this.f202085e;
    }

    public a i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (a) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.C;
    }

    public b j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (b) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return this.G;
    }

    public d l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (d) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        d dVar = this.f202086f;
        if (!dVar.f202177c) {
            dVar.a();
        }
        return this.f202086f;
    }

    public boolean n(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this, (Object) str)).booleanValue();
        }
        b bVar = this.G;
        if (TextUtils.isEmpty(str) || bVar == null || !TextUtils.equals(bVar.f202110a, str)) {
            return false;
        }
        if (bVar.f202122m == 0) {
            bVar.f202122m = c(str, bVar.f202117h, bVar.f202111b, bVar.f202118i, bVar.f202112c);
        }
        if (bVar.f202122m != 1) {
            return false;
        }
        return true;
    }

    public boolean o(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str)).booleanValue();
        }
        a aVar = this.C;
        if (TextUtils.isEmpty(str) || aVar == null || !TextUtils.equals(aVar.f202104h, str)) {
            return false;
        }
        if (aVar.f202109m == 0) {
            aVar.f202109m = d(str, aVar.f202104h, aVar.f202105i, aVar.f202097a);
        }
        if (aVar.f202109m != 1) {
            return false;
        }
        return true;
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        }
    }

    public void p(String str, String str2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, str, str2, Integer.valueOf(i3));
            return;
        }
        k(str, str2, i3).f202109m = 2;
        if (QLog.isDevelopLevel()) {
            QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "markFrdChatExtra recUin: %s, confessorUin: %s, topicId: %s", str, str2, Integer.valueOf(i3)));
        }
    }

    public void q(String str, String str2, String str3, String str4, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, str, str2, str3, str4, Integer.valueOf(i3));
            return;
        }
        m(str, str2, str3, str4, i3).f202122m = 2;
        if (QLog.isDevelopLevel()) {
            QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "markGroupChatExtra groupUin: %s recUin: %s, confessorUin: %s, topicId: %s", str, str2, str4, Integer.valueOf(i3)));
        }
    }

    public void r(RedTouchItem redTouchItem) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) redTouchItem);
            return;
        }
        if (redTouchItem == null) {
            return;
        }
        d dVar = this.f202086f;
        if (!dVar.f202177c) {
            dVar.a();
        }
        d dVar2 = this.f202086f;
        if (dVar2.f202179e >= redTouchItem.lastRecvTime && dVar2.f202178d == redTouchItem.count) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            dVar2.c(redTouchItem);
            ConfessMsgUtil.t(this.f202084d, false, false);
            ((ConfessHandler) this.f202084d.getBusinessHandler(BusinessHandlerFactory.CONFESS_HANDLER)).F2(this.f202086f);
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "onFrdRecNewConfess bNeedUpdate: %s, info: %s", Boolean.valueOf(z16), this.f202086f));
        }
    }

    public void s(String str, a aVar) {
        List<MessageRecord> D;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) str, (Object) aVar);
            return;
        }
        if (aVar != null && !TextUtils.isEmpty(str)) {
            synchronized (this.f202089m) {
                if (aVar.f202109m == 1 && (D = this.f202084d.getMessageFacade().D(str, 0, new int[]{MessageRecord.MSG_TYPE_CONFESS_NEWS})) != null && D.size() > 0) {
                    for (MessageRecord messageRecord : D) {
                        if (messageRecord instanceof MessageForConfessNews) {
                            MessageForConfessNews messageForConfessNews = (MessageForConfessNews) messageRecord;
                            messageForConfessNews.parse();
                            if (messageForConfessNews.nTopicId == aVar.f202097a && TextUtils.equals(aVar.f202105i, messageForConfessNews.strConfessorUin) && TextUtils.equals(aVar.f202104h, messageForConfessNews.strRecUin)) {
                                this.f202084d.getMessageFacade().A0(messageRecord.frienduin, 0, messageRecord.msgtype, messageRecord.uniseq);
                                this.f202084d.getMessageFacade().T1(messageRecord.frienduin, messageRecord.istroop, messageRecord.uniseq);
                            }
                        }
                    }
                }
            }
            if (QLog.isDevelopLevel()) {
                QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "removeFrdConfessNews frdUin: %s confessorUin: %s topicId: %s", aVar.f202104h, aVar.f202105i, Integer.valueOf(aVar.f202097a)));
            }
        }
    }

    public void t(String str, b bVar) {
        List<MessageRecord> D;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) str, (Object) bVar);
            return;
        }
        if (bVar != null && !TextUtils.isEmpty(str)) {
            synchronized (this.F) {
                if (bVar.f202122m == 1 && (D = this.f202084d.getMessageFacade().D(str, 1, new int[]{MessageRecord.MSG_TYPE_CONFESS_NEWS})) != null && D.size() > 0) {
                    for (MessageRecord messageRecord : D) {
                        if (messageRecord instanceof MessageForConfessNews) {
                            MessageForConfessNews messageForConfessNews = (MessageForConfessNews) messageRecord;
                            messageForConfessNews.parse();
                            if (messageForConfessNews.nTopicId == bVar.f202112c && TextUtils.equals(bVar.f202110a, messageForConfessNews.strGroupUin) && TextUtils.equals(bVar.f202118i, messageForConfessNews.strConfessorUin) && TextUtils.equals(bVar.f202111b, messageForConfessNews.senderuin) && TextUtils.equals(bVar.f202117h, messageForConfessNews.strRecUin)) {
                                this.f202084d.getMessageFacade().A0(messageRecord.frienduin, 1, messageRecord.msgtype, messageRecord.uniseq);
                                this.f202084d.getMessageFacade().T1(messageRecord.frienduin, messageRecord.istroop, messageRecord.uniseq);
                            }
                        }
                    }
                }
            }
            if (QLog.isDevelopLevel()) {
                QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "removeGroupConfessNews groupUin: %s, strRecUin: %s, sendUin: %s, confessorUin: %s, topicId: %s", bVar.f202110a, bVar.f202117h, bVar.f202111b, bVar.f202118i, Integer.valueOf(bVar.f202112c)));
            }
        }
    }
}
