package com.tencent.mobileqq.troop.data;

import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.troop.api.ITroopAioKeywordService;
import com.tencent.mobileqq.troop.org.pb.oidb_0x496$AioKeyword;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopAioKeywordTipManager implements Manager {
    static IPatchRedirector $redirector_;
    protected boolean C;
    protected boolean D;

    /* renamed from: d, reason: collision with root package name */
    protected QQAppInterface f294765d;

    /* renamed from: e, reason: collision with root package name */
    protected final List<String> f294766e;

    /* renamed from: f, reason: collision with root package name */
    protected final Map<String, h> f294767f;

    /* renamed from: h, reason: collision with root package name */
    protected final SparseArray<i> f294768h;

    /* renamed from: i, reason: collision with root package name */
    protected final SparseArray<TroopAioKeywordTipInfo> f294769i;

    /* renamed from: m, reason: collision with root package name */
    protected final List<String> f294770m;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.troop.data.TroopAioKeywordTipManager$1, reason: invalid class name */
    /* loaded from: classes19.dex */
    class AnonymousClass1 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ List f294771d;
        final /* synthetic */ TroopAioKeywordTipManager this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            Iterator it = this.f294771d.iterator();
            while (it.hasNext()) {
                this.this$0.n((MessageRecord) it.next());
            }
            Iterator it5 = this.f294771d.iterator();
            ArrayList arrayList = null;
            while (it5.hasNext()) {
                List j3 = this.this$0.j((MessageRecord) it5.next());
                if (j3 != null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.addAll(j3);
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                this.this$0.r(arrayList);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.troop.data.TroopAioKeywordTipManager$3, reason: invalid class name */
    /* loaded from: classes19.dex */
    class AnonymousClass3 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ List f294774d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ List f294775e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f294776f;
        final /* synthetic */ TroopAioKeywordTipManager this$0;

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.troop.data.TroopAioKeywordTipManager$3$1, reason: invalid class name */
        /* loaded from: classes19.dex */
        class AnonymousClass1 implements Runnable {
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ MessageRecord f294777d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ AnonymousClass3 f294778e;

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                MessageRecord messageRecord = this.f294777d;
                if (messageRecord != null) {
                    messageRecord.getExtInfoFromExtStr("key_aio_keyword");
                }
                this.f294778e.getClass();
                throw null;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:30:0x0097  */
        /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            TroopAioKeywordTipInfo troopAioKeywordTipInfo;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            Pair<MessageRecord, Integer> i3 = this.this$0.i(this.f294774d, this.f294775e, this.f294776f);
            Integer num = (Integer) i3.second;
            MessageRecord messageRecord = (MessageRecord) i3.first;
            if (num == null) {
                this.this$0.o(null, null, null);
                return;
            }
            i iVar = this.this$0.f294768h.get(num.intValue());
            synchronized (this.this$0.f294768h) {
                if (iVar == null) {
                    this.this$0.o(messageRecord, null, null);
                    return;
                }
                synchronized (this.this$0.f294769i) {
                    troopAioKeywordTipInfo = this.this$0.f294769i.get(num.intValue());
                }
                boolean z16 = true;
                if (troopAioKeywordTipInfo != null) {
                    if (troopAioKeywordTipInfo.version == iVar.f294911f) {
                        this.this$0.o(messageRecord, troopAioKeywordTipInfo, null);
                        z16 = false;
                    }
                    if (!z16) {
                        this.this$0.p(num, messageRecord, null);
                        return;
                    }
                    return;
                }
                TroopAioKeywordTipInfo e16 = g.e(this.this$0.f294765d, String.valueOf(num));
                if (e16 != null && iVar.f294911f == e16.version) {
                    this.this$0.o(messageRecord, e16, null);
                    synchronized (this.this$0.f294769i) {
                        this.this$0.f294769i.put(e16.ruleId, e16);
                    }
                    z16 = false;
                }
                if (!z16) {
                }
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.troop.data.TroopAioKeywordTipManager$5, reason: invalid class name */
    /* loaded from: classes19.dex */
    class AnonymousClass5 implements Runnable {
        static IPatchRedirector $redirector_;
        final /* synthetic */ TroopAioKeywordTipManager this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            throw null;
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.troop.data.TroopAioKeywordTipManager$6, reason: invalid class name */
    /* loaded from: classes19.dex */
    class AnonymousClass6 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f294783d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f294784e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Integer f294785f;
        final /* synthetic */ TroopAioKeywordTipManager this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                String g16 = this.this$0.g(this.f294783d, this.f294784e, this.f294785f);
                synchronized (this.this$0.f294770m) {
                    if (!this.this$0.f294770m.contains(g16)) {
                        this.this$0.f294770m.add(g16);
                    }
                }
                g.h(this.this$0.f294765d, g16);
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static abstract class a {
        static IPatchRedirector $redirector_;
    }

    public TroopAioKeywordTipManager(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f294766e = new ArrayList();
        this.f294767f = new HashMap();
        this.f294768h = new SparseArray<>();
        this.f294769i = new SparseArray<>();
        this.f294770m = new ArrayList();
        this.C = false;
        this.D = false;
        this.f294765d = qQAppInterface;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String g(String str, String str2, Integer num) {
        return str + "_" + str2 + "_" + num;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<Integer> j(MessageRecord messageRecord) {
        String extInfoFromExtStr = messageRecord.getExtInfoFromExtStr("key_aio_keyword");
        if (!TextUtils.isEmpty(extInfoFromExtStr)) {
            synchronized (this.f294767f) {
                h hVar = this.f294767f.get(extInfoFromExtStr);
                if (hVar != null) {
                    return hVar.f294905b;
                }
                return null;
            }
        }
        return null;
    }

    private List<String> k(MessageRecord messageRecord) {
        ArrayList arrayList = new ArrayList();
        int i3 = messageRecord.msgtype;
        if (i3 != -1000 && i3 != -1051) {
            if (i3 == -2011) {
                MessageForStructing messageForStructing = (MessageForStructing) messageRecord;
                if (messageForStructing.structingMsg == null) {
                    messageForStructing.parse();
                }
                AbsStructMsg absStructMsg = messageForStructing.structingMsg;
                if (absStructMsg instanceof AbsShareMsg) {
                    AbsShareMsg absShareMsg = (AbsShareMsg) absStructMsg;
                    if (!TextUtils.isEmpty(absShareMsg.mContentTitle)) {
                        arrayList.add(absShareMsg.mContentTitle.toLowerCase());
                    }
                    if (!TextUtils.isEmpty(absShareMsg.mContentSummary)) {
                        arrayList.add(absShareMsg.mContentSummary.toLowerCase());
                    }
                    if (!TextUtils.isEmpty(absShareMsg.mMsgUrl)) {
                        arrayList.add(absShareMsg.mMsgUrl.toLowerCase());
                    }
                }
            }
        } else {
            MessageForText messageForText = (MessageForText) messageRecord;
            if (messageForText.charStr == null) {
                messageForText.parse();
            }
            CharSequence charSequence = messageForText.charStr;
            if (charSequence != null) {
                arrayList.add(charSequence.toString().toLowerCase());
            }
        }
        return arrayList;
    }

    private boolean l(Integer num, int i3, MessageRecord messageRecord) {
        i iVar;
        synchronized (this.f294768h) {
            iVar = this.f294768h.get(num.intValue());
        }
        if (iVar == null) {
            return false;
        }
        synchronized (this.f294770m) {
            if (!this.D) {
                this.f294770m.addAll(g.d(this.f294765d));
                this.D = true;
            }
            String g16 = g(this.f294765d.getCurrentAccountUin(), messageRecord.getExtInfoFromExtStr("key_aio_keyword"), num);
            if (!messageRecord.isSend() && this.f294770m.contains(g16)) {
                if (QLog.isColorLevel()) {
                    QLog.i("TroopAioKeywordTipManager", 2, "isSupportedRuleId, blackUinKeyRuleId=" + g16);
                }
                return false;
            }
            if (iVar.f294907b <= NetConnInfoCenter.getServerTime() && iVar.f294908c >= NetConnInfoCenter.getServerTime()) {
                if ((iVar.f294909d & i3) == 0) {
                    if (QLog.isColorLevel()) {
                        QLog.i("TroopAioKeywordTipManager", 2, "isSupportedRuleId, not support positionFlag, ruleInfo.positionFlag=" + iVar.f294909d + ", curInvokeType=" + i3);
                    }
                    return false;
                }
                List<Integer> list = iVar.f294910e;
                if (list != null && list.size() > 0) {
                    if (QLog.isColorLevel()) {
                        QLog.i("TroopAioKeywordTipManager", 2, "isSupportedRuleId, ruleInfo.troopTypes == null");
                    }
                    TroopInfo B = ((TroopManager) this.f294765d.getManager(QQManagerFactory.TROOP_MANAGER)).B(messageRecord.frienduin);
                    if (!iVar.f294910e.contains(Integer.valueOf((int) B.dwGroupClassExt))) {
                        if (QLog.isColorLevel()) {
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("[");
                            Iterator<Integer> it = iVar.f294910e.iterator();
                            while (it.hasNext()) {
                                sb5.append(it.next().intValue());
                                sb5.append(",");
                            }
                            sb5.append("]");
                            QLog.i("TroopAioKeywordTipManager", 2, "isSupportedRuleId, not support troopType, troopTypes=" + sb5.toString() + ",mCurType=" + B.dwGroupClassExt);
                        }
                        return false;
                    }
                }
                return true;
            }
            if (QLog.isColorLevel()) {
                QLog.i("TroopAioKeywordTipManager", 2, "isSupportedRuleId, not support timelimit, currentTime=" + NetConnInfoCenter.getServerTime() + ",ruleInfo.startTime =" + iVar.f294907b + ",ruleInfo.endTime=" + iVar.f294908c);
            }
            return false;
        }
    }

    private String m(String str) {
        String str2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.f294766e) {
            int i3 = Integer.MAX_VALUE;
            for (String str3 : this.f294766e) {
                int indexOf = str.indexOf(str3);
                if (indexOf >= 0 && indexOf < i3) {
                    str2 = str3;
                    if (indexOf == 0) {
                        break;
                    }
                    i3 = indexOf;
                }
            }
        }
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean n(MessageRecord messageRecord) {
        h();
        synchronized (this.f294766e) {
            if (this.f294766e.size() == 0) {
                return false;
            }
            if (TextUtils.equals(messageRecord.getExtInfoFromExtStr("key_is_checked_aio_keyword"), "1")) {
                return !TextUtils.isEmpty(messageRecord.getExtInfoFromExtStr("key_aio_keyword"));
            }
            Iterator<String> it = k(messageRecord).iterator();
            String str = null;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                str = m(it.next());
                if (!TextUtils.isEmpty(str)) {
                    messageRecord.saveExtInfoToExtStr("key_aio_keyword", str);
                    break;
                }
            }
            messageRecord.saveExtInfoToExtStr("key_is_checked_aio_keyword", "1");
            this.f294765d.getMessageFacade().a1(messageRecord.frienduin, messageRecord.istroop, messageRecord.uniseq, AppConstants.Key.COLUMN_EXT_STR, messageRecord.extStr);
            return !TextUtils.isEmpty(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(Integer num, MessageRecord messageRecord, a aVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(num);
        ((ITroopAioKeywordService) this.f294765d.getRuntimeService(ITroopAioKeywordService.class, "")).getTroopAioKeywordTipInfo(arrayList, new com.tencent.mobileqq.troop.observer.b(messageRecord, aVar) { // from class: com.tencent.mobileqq.troop.data.TroopAioKeywordTipManager.4
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ MessageRecord f294779d;

            {
                this.f294779d = messageRecord;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, TroopAioKeywordTipManager.this, messageRecord, aVar);
                }
            }

            @Override // com.tencent.mobileqq.troop.observer.b
            public void b(boolean z16, List<TroopAioKeywordTipInfo> list) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), list);
                    return;
                }
                if (!z16) {
                    TroopAioKeywordTipManager.this.o(this.f294779d, null, null);
                    return;
                }
                if (list == null || list.size() <= 0) {
                    TroopAioKeywordTipManager.this.o(this.f294779d, null, null);
                    return;
                }
                TroopAioKeywordTipManager.this.o(this.f294779d, list.get(0), null);
                synchronized (TroopAioKeywordTipManager.this.f294769i) {
                    TroopAioKeywordTipManager.this.f294769i.put(list.get(0).ruleId, list.get(0));
                }
                ThreadManagerV2.post(new Runnable(list) { // from class: com.tencent.mobileqq.troop.data.TroopAioKeywordTipManager.4.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ List f294781d;

                    {
                        this.f294781d = list;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass4.this, (Object) list);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else {
                            g.i(TroopAioKeywordTipManager.this.f294765d, this.f294781d);
                        }
                    }
                }, 2, null, true);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(List<Integer> list) {
        if (list != null && list.size() != 0) {
            ThreadManagerV2.post(new Runnable(list) { // from class: com.tencent.mobileqq.troop.data.TroopAioKeywordTipManager.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ List f294772d;

                /* compiled from: P */
                /* renamed from: com.tencent.mobileqq.troop.data.TroopAioKeywordTipManager$2$a */
                /* loaded from: classes19.dex */
                class a extends com.tencent.mobileqq.troop.observer.b {
                    static IPatchRedirector $redirector_;

                    a() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this);
                        }
                    }

                    @Override // com.tencent.mobileqq.troop.observer.b
                    public void b(boolean z16, List<TroopAioKeywordTipInfo> list) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), list);
                            return;
                        }
                        if (z16) {
                            synchronized (TroopAioKeywordTipManager.this.f294769i) {
                                if (list != null) {
                                    for (TroopAioKeywordTipInfo troopAioKeywordTipInfo : list) {
                                        TroopAioKeywordTipManager.this.f294769i.put(troopAioKeywordTipInfo.ruleId, troopAioKeywordTipInfo);
                                    }
                                }
                            }
                        }
                    }
                }

                {
                    this.f294772d = list;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopAioKeywordTipManager.this, (Object) list);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    ArrayList<Integer> arrayList;
                    ArrayList arrayList2;
                    boolean z16;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    synchronized (TroopAioKeywordTipManager.this.f294769i) {
                        synchronized (TroopAioKeywordTipManager.this.f294768h) {
                            arrayList = null;
                            arrayList2 = null;
                            for (Integer num : this.f294772d) {
                                if (TroopAioKeywordTipManager.this.f294768h.get(num.intValue()) != null) {
                                    TroopAioKeywordTipInfo troopAioKeywordTipInfo = TroopAioKeywordTipManager.this.f294769i.get(num.intValue());
                                    if (troopAioKeywordTipInfo == null) {
                                        if (arrayList == null) {
                                            arrayList = new ArrayList();
                                        }
                                        arrayList.add(num);
                                    } else if (troopAioKeywordTipInfo.version != TroopAioKeywordTipManager.this.f294768h.get(num.intValue()).f294911f) {
                                        if (arrayList2 == null) {
                                            arrayList2 = new ArrayList();
                                        }
                                        if (!arrayList2.contains(num)) {
                                            arrayList2.add(num);
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (arrayList != null && arrayList.size() > 0) {
                        int size = arrayList.size();
                        String[] strArr = new String[size];
                        for (int i3 = 0; i3 < size; i3++) {
                            strArr[i3] = String.valueOf(arrayList.get(i3));
                        }
                        List<TroopAioKeywordTipInfo> f16 = g.f(TroopAioKeywordTipManager.this.f294765d, strArr);
                        synchronized (TroopAioKeywordTipManager.this.f294769i) {
                            synchronized (TroopAioKeywordTipManager.this.f294768h) {
                                for (Integer num2 : arrayList) {
                                    Iterator<TroopAioKeywordTipInfo> it = f16.iterator();
                                    while (true) {
                                        if (it.hasNext()) {
                                            TroopAioKeywordTipInfo next = it.next();
                                            if (next.ruleId == num2.intValue() && TroopAioKeywordTipManager.this.f294768h.get(num2.intValue()).f294911f == next.version) {
                                                TroopAioKeywordTipManager.this.f294769i.put(num2.intValue(), next);
                                                z16 = true;
                                                break;
                                            }
                                        } else {
                                            z16 = false;
                                            break;
                                        }
                                    }
                                    if (!z16) {
                                        if (arrayList2 == null) {
                                            arrayList2 = new ArrayList();
                                        }
                                        if (!arrayList2.contains(num2)) {
                                            arrayList2.add(num2);
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (arrayList2 != null && arrayList2.size() > 0) {
                        ((ITroopAioKeywordService) TroopAioKeywordTipManager.this.f294765d.getRuntimeService(ITroopAioKeywordService.class, "")).getTroopAioKeywordTipInfo(arrayList2, new a());
                    }
                }
            }, 8, null, true);
        }
    }

    public synchronized void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (!this.C) {
            oidb_0x496$AioKeyword c16 = g.c();
            q(g.a(c16), g.b(c16));
        }
    }

    public Pair<MessageRecord, Integer> i(List<MessageRecord> list, List<String> list2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Pair) iPatchRedirector.redirect((short) 6, this, list, list2, Integer.valueOf(i3));
        }
        Integer num = null;
        MessageRecord messageRecord = null;
        for (MessageRecord messageRecord2 : list) {
            if (n(messageRecord2)) {
                List<Integer> j3 = j(messageRecord2);
                if (j3 != null && j3.size() > 0) {
                    Iterator<Integer> it = j3.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Integer next = it.next();
                        if (list2 != null) {
                            if (list2.contains(messageRecord2.getExtInfoFromExtStr("key_aio_keyword") + "_" + next)) {
                                continue;
                            }
                        }
                        if (l(next, i3, messageRecord2)) {
                            messageRecord = messageRecord2;
                            num = next;
                            break;
                        }
                    }
                }
                if (num != null) {
                    break;
                }
            }
        }
        return new Pair<>(messageRecord, num);
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        }
    }

    public synchronized void q(List<h> list, List<i> list2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) list, (Object) list2);
            return;
        }
        if (list != null) {
            synchronized (this.f294766e) {
                this.f294766e.clear();
                Iterator<h> it = list.iterator();
                while (it.hasNext()) {
                    this.f294766e.add(it.next().f294904a.toLowerCase());
                }
            }
            synchronized (this.f294767f) {
                this.f294767f.clear();
                for (h hVar : list) {
                    this.f294767f.put(hVar.f294904a.toLowerCase(), hVar);
                }
            }
        }
        if (list2 != null) {
            synchronized (this.f294768h) {
                this.f294768h.clear();
                for (i iVar : list2) {
                    this.f294768h.put(iVar.f294906a, iVar);
                }
            }
        }
        this.C = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(MessageRecord messageRecord, TroopAioKeywordTipInfo troopAioKeywordTipInfo, a aVar) {
    }
}
