package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import android.content.Context;
import android.os.BatteryManager;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.l;
import com.tencent.mobileqq.activity.contacts.base.Contacts;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.guard.guardinterface.GuardManagerCallbackDispatcher;
import com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.guild.api.IGuildDelayInitializeService;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.kandian.glue.report.WeishiReportUtil;
import com.tencent.mobileqq.leba.ILebaFrameApi;
import com.tencent.mobileqq.mp.mobileqq_mp$ButtonInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qcircle.api.IQCircleConfigApi;
import com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountMessageService;
import com.tencent.mobileqq.qcircle.api.IQCircleRedPointService;
import com.tencent.mobileqq.qcircle.api.constant.QCircleRedPointAppidContants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.tianshu.ui.TianshuRedTouch;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.UfsGROUPMASK;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a;

/* loaded from: classes33.dex */
public class ReadinjoySPEventReport {
    private static long E;

    /* renamed from: n, reason: collision with root package name */
    private static volatile ReadinjoySPEventReport f239768n;

    /* renamed from: i, reason: collision with root package name */
    private c f239789i;

    /* renamed from: k, reason: collision with root package name */
    private boolean f239791k;

    /* renamed from: p, reason: collision with root package name */
    public static final Lock f239770p = new ReentrantLock();

    /* renamed from: o, reason: collision with root package name */
    public static final long f239769o = System.currentTimeMillis();

    /* renamed from: q, reason: collision with root package name */
    private static long f239771q = 0;

    /* renamed from: r, reason: collision with root package name */
    private static long f239772r = 0;

    /* renamed from: s, reason: collision with root package name */
    private static long f239773s = 0;

    /* renamed from: t, reason: collision with root package name */
    private static int f239774t = 0;

    /* renamed from: u, reason: collision with root package name */
    public static long f239775u = -1;

    /* renamed from: v, reason: collision with root package name */
    private static boolean f239776v = false;

    /* renamed from: w, reason: collision with root package name */
    private static long f239777w = 0;

    /* renamed from: x, reason: collision with root package name */
    private static long f239778x = 0;

    /* renamed from: y, reason: collision with root package name */
    private static long f239779y = 0;

    /* renamed from: z, reason: collision with root package name */
    private static int f239780z = 0;
    private static long A = System.currentTimeMillis();
    private static boolean B = true;
    private static boolean C = false;
    private static volatile boolean D = false;
    private static long F = System.currentTimeMillis();

    /* renamed from: a, reason: collision with root package name */
    private StringBuilder f239781a = new StringBuilder(1024);

    /* renamed from: b, reason: collision with root package name */
    private List<Object> f239782b = new LinkedList();

    /* renamed from: c, reason: collision with root package name */
    String f239783c = "";

    /* renamed from: d, reason: collision with root package name */
    boolean f239784d = false;

    /* renamed from: e, reason: collision with root package name */
    long f239785e = -1;

    /* renamed from: f, reason: collision with root package name */
    private List<Pair<Long, Integer>> f239786f = Collections.synchronizedList(new ArrayList());

    /* renamed from: g, reason: collision with root package name */
    private List<Pair<Long, Integer>> f239787g = Collections.synchronizedList(new ArrayList());

    /* renamed from: h, reason: collision with root package name */
    private CopyOnWriteArrayList<Pair<Long, Integer>> f239788h = new CopyOnWriteArrayList<>();

    /* renamed from: j, reason: collision with root package name */
    private boolean f239790j = false;

    /* renamed from: l, reason: collision with root package name */
    private Handler f239792l = new Handler(ThreadManagerV2.getSubThreadLooper());

    /* renamed from: m, reason: collision with root package name */
    private Runnable f239793m = new Runnable() { // from class: com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport.7
        @Override // java.lang.Runnable
        public void run() {
            ReadinjoySPEventReport.this.v0(1);
        }
    };

    /* loaded from: classes33.dex */
    class a implements IGuardInterface {
        a() {
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onApplicationBackground() {
            ReadinjoySPEventReport.s0(false);
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onApplicationForeground() {
            ReadinjoySPEventReport.o0(false);
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onScreensStateChanged(boolean z16) {
            QLog.d("ReadinjoySPEventReport", 2, "receive screen off broadcast");
            ReadinjoySPEventReport.B0(z16);
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onBackgroundTimeTick(long j3) {
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onBackgroundUnguardTimeTick(long j3) {
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onLiteTimeTick(long j3) {
        }
    }

    /* loaded from: classes33.dex */
    public class c {

        /* renamed from: a, reason: collision with root package name */
        public oidb_cmd0x80a.AttributeList f239808a;

        /* renamed from: b, reason: collision with root package name */
        public oidb_cmd0x80a.AttributeList f239809b;

        /* renamed from: c, reason: collision with root package name */
        public oidb_cmd0x80a.AttributeList f239810c;

        /* renamed from: d, reason: collision with root package name */
        public oidb_cmd0x80a.AttributeList f239811d;

        public c() {
        }
    }

    /* loaded from: classes33.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        private static int f239813a = -1;

        /* renamed from: b, reason: collision with root package name */
        private static Map<Integer, v62.b> f239814b = new ConcurrentHashMap();

        /* renamed from: c, reason: collision with root package name */
        private static List<v62.b> f239815c = new ArrayList();

        /* renamed from: d, reason: collision with root package name */
        public static int f239816d = 2;

        /* renamed from: e, reason: collision with root package name */
        public static long f239817e;

        /* renamed from: f, reason: collision with root package name */
        public static long f239818f;

        /* renamed from: g, reason: collision with root package name */
        public static long f239819g;

        /* renamed from: h, reason: collision with root package name */
        public static long f239820h;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes33.dex */
        public class a implements v62.b {
            a() {
            }

            @Override // v62.b
            public void a() {
                ReadinjoySPEventReport.J().d0(false);
            }

            @Override // v62.b
            public void b() {
                ReadinjoySPEventReport.J().b0(null, false);
            }
        }

        static {
            e();
        }

        public static synchronized void a(v62.b bVar) {
            synchronized (d.class) {
                if (bVar == null) {
                    return;
                }
                if (!f239815c.contains(bVar)) {
                    f239815c.add(bVar);
                }
            }
        }

        public static synchronized void b() {
            v62.b bVar;
            synchronized (d.class) {
                f239816d = 2;
                if (f() && (bVar = f239814b.get(Integer.valueOf(f239813a))) != null) {
                    bVar.a();
                }
                for (v62.b bVar2 : f239815c) {
                    if (bVar2 != null) {
                        bVar2.a();
                    }
                }
            }
        }

        public static synchronized void d() {
            v62.b bVar;
            synchronized (d.class) {
                f239816d = 1;
                ReadinjoySPEventReport.f239771q = System.currentTimeMillis();
                if (f() && (bVar = f239814b.get(Integer.valueOf(f239813a))) != null) {
                    bVar.b();
                }
                for (v62.b bVar2 : f239815c) {
                    if (bVar2 != null) {
                        bVar2.b();
                    }
                }
            }
        }

        private static void e() {
            f239814b.put(2, new a());
            f239814b.put(3, new b());
            f239814b.put(25, new c());
            f239814b.put(4, new C7958d());
        }

        private static boolean f() {
            int i3 = f239813a;
            if (i3 > 0) {
                return i3 == 2 || i3 == 3 || i3 == 4 || i3 == 25;
            }
            return false;
        }

        public static synchronized void g(v62.b bVar) {
            synchronized (d.class) {
                if (bVar != null) {
                    f239815c.remove(bVar);
                }
            }
        }

        public static void h(int i3) {
            f239813a = i3;
            if (i3 == 2) {
                f239817e = System.currentTimeMillis();
                return;
            }
            if (i3 == 3) {
                f239818f = System.currentTimeMillis();
            } else if (i3 == 4) {
                f239820h = System.currentTimeMillis();
            } else {
                if (i3 != 25) {
                    return;
                }
                f239819g = System.currentTimeMillis();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes33.dex */
        public class c implements v62.b {
            c() {
            }

            @Override // v62.b
            public void a() {
                WeishiReportUtil.p(9, "", "", "", "", d.f239819g, "", false);
            }

            @Override // v62.b
            public void b() {
                WeishiReportUtil.m(9, "", "", "", "");
            }
        }

        public static void c() {
            f239813a = -1;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes33.dex */
        public class b implements v62.b {
            b() {
            }

            @Override // v62.b
            public void a() {
                ReadinjoySPEventReport.J().q0("2909288299", d.f239818f, false, null, false);
            }

            @Override // v62.b
            public void b() {
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport$d$d, reason: collision with other inner class name */
        /* loaded from: classes33.dex */
        public class C7958d implements v62.b {
            C7958d() {
            }

            @Override // v62.b
            public void a() {
            }

            @Override // v62.b
            public void b() {
            }
        }
    }

    /* loaded from: classes33.dex */
    public static class f {

        /* renamed from: a, reason: collision with root package name */
        public static long f239826a = -1;

        /* renamed from: b, reason: collision with root package name */
        public static long f239827b = -1;

        /* renamed from: c, reason: collision with root package name */
        public static long f239828c;

        /* renamed from: d, reason: collision with root package name */
        public static List<g> f239829d = new ArrayList();

        public static void a(g gVar) {
            if (!f239829d.isEmpty()) {
                if (gVar.f239832c - f239829d.get(r0.size() - 1).f239832c > f239826a) {
                    b();
                }
            }
            f239829d.add(gVar);
            f239828c += gVar.f239831b;
            if (c()) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(f239829d);
                f239829d.clear();
                ReadinjoySPEventReport.w0(arrayList);
            }
        }

        public static void b() {
            f239829d.clear();
            f239828c = 0L;
        }

        public static boolean c() {
            return f239828c > f239827b;
        }
    }

    /* loaded from: classes33.dex */
    public static class g {

        /* renamed from: a, reason: collision with root package name */
        int f239830a;

        /* renamed from: b, reason: collision with root package name */
        long f239831b;

        /* renamed from: c, reason: collision with root package name */
        long f239832c;

        /* renamed from: d, reason: collision with root package name */
        int f239833d;

        /* renamed from: e, reason: collision with root package name */
        int f239834e;

        /* renamed from: f, reason: collision with root package name */
        int f239835f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes33.dex */
    public static class h {
        public static String a(boolean z16, String str, String str2) {
            if (!z16) {
                return str2;
            }
            return str;
        }

        public static <T> boolean b(T t16, T t17) {
            if (t16 == t17) {
                return true;
            }
            return false;
        }

        public static <T, S> String c(List<Pair<T, S>> list, String str, String str2) {
            StringBuilder sb5 = new StringBuilder(1024);
            if (list.size() > 0) {
                ArrayList arrayList = new ArrayList(list);
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    Pair pair = (Pair) arrayList.get(i3);
                    if (i3 != 0) {
                        sb5.append(str2);
                    }
                    sb5.append(pair.first);
                    if (i3 != 0) {
                        sb5.append(str);
                        sb5.append(pair.second);
                    }
                }
                list.removeAll(arrayList);
            }
            return sb5.toString();
        }
    }

    ReadinjoySPEventReport() {
        W();
    }

    private static boolean A(int i3, long j3) {
        return (SPEventReportSwitch.a() && j3 - f239773s >= ((long) (SPEventReportSwitch.c() * 1000)) && f239774t <= 1) || SPEventReportSwitch.d(i3);
    }

    private static boolean B(int i3) {
        return (com.tencent.mobileqq.kandian.base.utils.b.c() instanceof QQAppInterface) && QBaseActivity.mAppForground && SPEventReportSwitch.d(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void B0(final boolean z16) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport.3
            @Override // java.lang.Runnable
            public void run() {
                String valueOf;
                String str;
                if (z16 || ReadinjoySPEventReport.B) {
                    if (z16) {
                        ReadinjoySPEventReport.A = System.currentTimeMillis();
                        ReadinjoySPEventReport.C = true;
                    }
                    ReadinjoySPEventReport.B = z16;
                    if (ReadinjoySPEventReport.x(9)) {
                        ArrayList arrayList = new ArrayList();
                        oidb_cmd0x80a.AttributeList attributeList = new oidb_cmd0x80a.AttributeList();
                        attributeList.att_id.set(1);
                        attributeList.att_name.set("isOn");
                        PBStringField pBStringField = attributeList.att_value;
                        if (z16) {
                            valueOf = String.valueOf(1);
                        } else {
                            valueOf = String.valueOf(0);
                        }
                        pBStringField.set(valueOf);
                        arrayList.add(attributeList);
                        if (!z16) {
                            long currentTimeMillis = (System.currentTimeMillis() - ReadinjoySPEventReport.A) / 1000;
                            oidb_cmd0x80a.AttributeList attributeList2 = new oidb_cmd0x80a.AttributeList();
                            attributeList2.att_id.set(2);
                            attributeList2.att_name.set("time");
                            attributeList2.att_value.set(String.valueOf(currentTimeMillis));
                            arrayList.add(attributeList2);
                            oidb_cmd0x80a.AttributeList attributeList3 = new oidb_cmd0x80a.AttributeList();
                            attributeList3.att_id.set(3);
                            attributeList3.att_name.set("isScreenTime");
                            PBStringField pBStringField2 = attributeList3.att_value;
                            if (ReadinjoySPEventReport.C) {
                                str = "1";
                            } else {
                                str = "0";
                            }
                            pBStringField2.set(str);
                            arrayList.add(attributeList3);
                        }
                        ReadinjoyReportUtils.b(9, arrayList);
                        if (z16) {
                            ReadinjoySPEventReport.f239773s = System.currentTimeMillis();
                            ReadinjoySPEventReport.f239774t = 0;
                        } else {
                            ReadinjoySPEventReport.f239774t++;
                        }
                    }
                    if (d.f239816d == 1) {
                        ReadinjoySPEventReport.s0(false);
                    }
                }
            }
        }, 128, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c C(List<ChatMessage> list) {
        c cVar = new c();
        Pair<Integer, Integer> l3 = ReadInJoyHelper.l();
        long intValue = ((Integer) l3.first).intValue();
        long intValue2 = ((Integer) l3.second).intValue();
        long serverTime = NetConnInfoCenter.getServerTime();
        int i3 = 0;
        int i16 = 0;
        for (int size = list.size() - 1; size >= 0; size--) {
            ChatMessage chatMessage = list.get(size);
            long j3 = serverTime - chatMessage.time;
            if (j3 > intValue && j3 > intValue2) {
                break;
            }
            if (!chatMessage.isSendFromLocal() && j3 <= intValue) {
                i16++;
            } else if (chatMessage.isSendFromLocal() && j3 <= intValue2) {
                i3++;
            }
        }
        AppRuntime c16 = com.tencent.mobileqq.kandian.base.utils.b.c();
        int H1 = (c16 == null || !(c16 instanceof QQAppInterface)) ? 0 : ((QQAppInterface) c16).getMessageFacade().H1();
        oidb_cmd0x80a.AttributeList attributeList = new oidb_cmd0x80a.AttributeList();
        attributeList.att_id.set(1);
        attributeList.att_name.set("Time");
        attributeList.att_value.set(String.valueOf(System.currentTimeMillis() / 1000));
        oidb_cmd0x80a.AttributeList attributeList2 = new oidb_cmd0x80a.AttributeList();
        attributeList2.att_id.set(2);
        attributeList2.att_name.set("MsgPulse");
        attributeList2.att_value.set(intValue + ":" + i16 + "`" + intValue2 + ":" + i3);
        oidb_cmd0x80a.AttributeList attributeList3 = new oidb_cmd0x80a.AttributeList();
        attributeList3.att_id.set(3);
        attributeList3.att_name.set("Keyword");
        attributeList3.att_value.set("");
        oidb_cmd0x80a.AttributeList attributeList4 = new oidb_cmd0x80a.AttributeList();
        attributeList4.att_id.set(4);
        attributeList4.att_name.set("leftBtmRedCnt");
        attributeList4.att_value.set(String.valueOf(H1));
        cVar.f239808a = attributeList;
        cVar.f239809b = attributeList2;
        cVar.f239810c = attributeList3;
        cVar.f239811d = attributeList4;
        return cVar;
    }

    public static void C0() {
        Automator automator;
        QQAppInterface e16 = com.tencent.mobileqq.kandian.base.utils.b.e();
        ThreadManager.getSubThreadHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport.11
            @Override // java.lang.Runnable
            public void run() {
                String valueOf;
                String valueOf2;
                String valueOf3;
                if (ReadinjoySPEventReport.x(24)) {
                    ArrayList arrayList = new ArrayList();
                    BaseActivity baseActivity = BaseActivity.sTopActivity;
                    if (baseActivity instanceof SplashActivity) {
                        try {
                            MainFragment mainFragment = (MainFragment) ((SplashActivity) baseActivity).getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
                            if (mainFragment == null) {
                                return;
                            }
                            Boolean hasRedBadge = mainFragment.hasRedBadge(com.tencent.mobileqq.activity.home.impl.b.f183049l + "_num");
                            oidb_cmd0x80a.AttributeList attributeList = new oidb_cmd0x80a.AttributeList();
                            attributeList.att_id.set(1);
                            attributeList.att_name.set("MsgRedStatus");
                            PBStringField pBStringField = attributeList.att_value;
                            if (hasRedBadge.booleanValue()) {
                                valueOf = String.valueOf(1);
                            } else {
                                valueOf = String.valueOf(0);
                            }
                            pBStringField.set(valueOf);
                            arrayList.add(attributeList);
                            boolean booleanValue = mainFragment.hasRedBadge(com.tencent.mobileqq.activity.home.impl.b.f183050m).booleanValue();
                            oidb_cmd0x80a.AttributeList attributeList2 = new oidb_cmd0x80a.AttributeList();
                            attributeList2.att_id.set(2);
                            attributeList2.att_name.set("ContactsRedStatus");
                            PBStringField pBStringField2 = attributeList2.att_value;
                            if (booleanValue) {
                                valueOf2 = String.valueOf(1);
                            } else {
                                valueOf2 = String.valueOf(0);
                            }
                            pBStringField2.set(valueOf2);
                            arrayList.add(attributeList2);
                            boolean booleanValue2 = mainFragment.hasRedBadge(com.tencent.mobileqq.activity.home.impl.b.f183052o).booleanValue();
                            oidb_cmd0x80a.AttributeList attributeList3 = new oidb_cmd0x80a.AttributeList();
                            attributeList3.att_id.set(3);
                            attributeList3.att_name.set("TrendsRedStatus");
                            PBStringField pBStringField3 = attributeList3.att_value;
                            if (booleanValue2) {
                                valueOf3 = String.valueOf(1);
                            } else {
                                valueOf3 = String.valueOf(0);
                            }
                            pBStringField3.set(valueOf3);
                            arrayList.add(attributeList3);
                            oidb_cmd0x80a.AttributeList attributeList4 = new oidb_cmd0x80a.AttributeList();
                            attributeList4.att_id.set(5);
                            attributeList4.att_name.set("tab");
                            int S = ReadinjoySPEventReport.S(mainFragment.getCurrentTab());
                            attributeList4.att_value.set("" + S);
                            arrayList.add(attributeList4);
                            if (S == 1 && !TextUtils.isEmpty("")) {
                                oidb_cmd0x80a.AttributeList attributeList5 = new oidb_cmd0x80a.AttributeList();
                                attributeList5.att_id.set(6);
                                attributeList5.att_name.set("FuncRed");
                                attributeList5.att_value.set("");
                                arrayList.add(attributeList5);
                            }
                        } catch (Exception e17) {
                            if (QLog.isColorLevel()) {
                                QLog.d("ReadinjoySPEventReport", 2, "reportTabExposure_ERROR : ", e17);
                            }
                        }
                    }
                    ReadinjoyReportUtils.b(24, arrayList);
                }
            }
        }, (e16 == null || (automator = e16.mAutomator) == null || !automator.isInRealActionLoginB()) ? 0L : 3000L);
    }

    public static int E(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 3000) {
                    return 1;
                }
                return -1;
            }
            return 0;
        }
        return 2;
    }

    private static int F() {
        return SystemMethodProxy.getIntProperty((BatteryManager) BaseApplicationImpl.getApplication().getSystemService("batterymanager"), 4);
    }

    public static void G0() {
        f239779y = System.currentTimeMillis();
    }

    public static String H() {
        Calendar calendar = Calendar.getInstance();
        if (calendar == null) {
            return "";
        }
        int i3 = calendar.get(1);
        return String.valueOf(i3) + calendar.get(2) + calendar.get(5);
    }

    public static void H0(long j3) {
        f239777w = j3;
    }

    public static long I(long j3) {
        return System.currentTimeMillis() - Math.max(Math.max(M(), A), j3);
    }

    public static void I0() {
        f239778x = NetConnInfoCenter.getServerTime();
    }

    public static ReadinjoySPEventReport J() {
        if (f239768n == null) {
            synchronized (ReadinjoySPEventReport.class) {
                if (f239768n == null) {
                    f239768n = new ReadinjoySPEventReport();
                }
            }
        }
        return f239768n;
    }

    public static long L() {
        return f239779y;
    }

    public static long M() {
        return f239777w;
    }

    public static long N() {
        return f239778x;
    }

    private String O(List<ChatMessage> list) {
        StringBuilder sb5 = new StringBuilder(1024);
        if (list != null && !list.isEmpty()) {
            ChatMessage chatMessage = list.get(list.size() - 1);
            if (chatMessage instanceof MessageForStructing) {
                AbsStructMsg absStructMsg = ((MessageForStructing) chatMessage).structingMsg;
                if (absStructMsg instanceof StructMsgForGeneralShare) {
                    for (AbsStructMsgElement absStructMsgElement : ((StructMsgForGeneralShare) absStructMsg).mStructMsgItemLists) {
                        if (absStructMsgElement instanceof com.tencent.mobileqq.structmsg.a) {
                            String U = U((com.tencent.mobileqq.structmsg.a) absStructMsgElement);
                            if (!TextUtils.isEmpty(U)) {
                                if (sb5.length() > 0) {
                                    sb5.append("`");
                                }
                                sb5.append(U);
                            }
                        }
                    }
                }
            }
            return sb5.toString();
        }
        return "";
    }

    private Pair<Integer, Long> P(QQAppInterface qQAppInterface) {
        return new Pair<>(Integer.valueOf(((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).getPubAccountRecentUserPosInMessageList()), Long.valueOf(((IQCirclePublicAccountMessageService) qQAppInterface.getRuntimeService(IQCirclePublicAccountMessageService.class)).getRedDotTypeFromCached().getType()));
    }

    private int Q() {
        return ((IQCircleRedPointService) com.tencent.mobileqq.kandian.base.utils.b.c().getRuntimeService(IQCircleRedPointService.class, "all")).getRedPointNumberByAppid(QCircleRedPointAppidContants.QCIRCLE_ENTRANCE);
    }

    private int R() {
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        if (qQAppInterface != null && qQAppInterface.isLogin()) {
            new oidb_cmd0x80a.AttributeList();
            QQMessageFacade messageFacade = qQAppInterface.getMessageFacade();
            if (messageFacade != null) {
                return messageFacade.H1();
            }
        }
        return 0;
    }

    public static int S(int i3) {
        if (i3 == com.tencent.mobileqq.activity.home.impl.a.f183038a) {
            return 1;
        }
        if (i3 == com.tencent.mobileqq.activity.home.impl.a.f183040c) {
            return 2;
        }
        if (i3 == com.tencent.mobileqq.activity.home.impl.a.f183044g) {
            return 3;
        }
        if (i3 == com.tencent.mobileqq.activity.home.impl.a.f183041d) {
            return 4;
        }
        if (i3 == com.tencent.mobileqq.activity.home.impl.a.f183046i) {
            return 5;
        }
        return i3 == com.tencent.mobileqq.activity.home.impl.a.f183047j ? 6 : 0;
    }

    private static int T() {
        return ((IQCircleConfigApi) QRoute.api(IQCircleConfigApi.class)).isShowQQCircleMainTabEntrance() ? 2 : 0;
    }

    private String U(com.tencent.mobileqq.structmsg.a aVar) {
        Iterator<AbsStructMsgElement> it = aVar.U0.iterator();
        while (it.hasNext()) {
            AbsStructMsgElement next = it.next();
            if (next instanceof StructMsgItemTitle) {
                return ((StructMsgItemTitle) next).t();
            }
        }
        return "";
    }

    public static boolean X() {
        return f239776v;
    }

    public static void Z() {
        f.b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v26 */
    /* JADX WARN: Type inference failed for: r6v31 */
    /* JADX WARN: Type inference failed for: r6v32 */
    /* JADX WARN: Type inference failed for: r6v33 */
    /* JADX WARN: Type inference failed for: r6v34 */
    /* JADX WARN: Type inference failed for: r6v35 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void e0(int i3) {
        ?? r65;
        MainFragment mainFragment;
        int i16;
        BaseActivity baseActivity = BaseActivity.sTopActivity;
        if ((baseActivity instanceof SplashActivity) && (mainFragment = (MainFragment) ((SplashActivity) baseActivity).getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName())) != null) {
            try {
                i16 = 1;
                try {
                } catch (Exception e16) {
                    e = e16;
                }
            } catch (Exception e17) {
                e = e17;
                i16 = 0;
            }
            if (i3 == com.tencent.mobileqq.activity.home.impl.a.f183038a) {
                r65 = V(mainFragment, com.tencent.mobileqq.activity.home.impl.b.f183049l + "_num").booleanValue();
            } else if (i3 == com.tencent.mobileqq.activity.home.impl.a.f183040c) {
                i16 = 2;
                r65 = V(mainFragment, com.tencent.mobileqq.activity.home.impl.b.f183050m).booleanValue();
            } else if (i3 == com.tencent.mobileqq.activity.home.impl.a.f183044g) {
                i16 = 3;
                r65 = V(mainFragment, com.tencent.mobileqq.activity.home.impl.b.f183054q).booleanValue();
            } else if (i3 == com.tencent.mobileqq.activity.home.impl.a.f183041d) {
                i16 = 4;
                r65 = V(mainFragment, com.tencent.mobileqq.activity.home.impl.b.f183052o).booleanValue();
            } else if (i3 == com.tencent.mobileqq.activity.home.impl.a.f183046i) {
                i16 = 5;
                r65 = V(mainFragment, com.tencent.mobileqq.activity.home.impl.b.f183055r).booleanValue();
            } else if (i3 == com.tencent.mobileqq.activity.home.impl.a.f183047j) {
                r65 = 6;
                try {
                    if (TianshuRedTouch.INSTANCE.j()) {
                        r2 = 6;
                        r65 = V(mainFragment, com.tencent.mobileqq.activity.home.impl.b.f183056s).booleanValue();
                    } else {
                        r2 = 6;
                        r65 = ((IGuildDelayInitializeService) ((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime()).getRuntimeService(IGuildDelayInitializeService.class, "")).getGuildTabUnreadCountSafely().getCount() > 0 ? 1 : 0;
                    }
                } catch (Exception e18) {
                    i16 = r65;
                    e = e18;
                    l.r("onMainFragmentTabClick", "onMainFragmentTabClick", e);
                    r65 = r2;
                    r2 = i16;
                    if (r2 == 0) {
                    }
                }
                if (r2 == 0) {
                    i0(r2, r65);
                    return;
                }
                return;
            }
            r2 = i16;
            if (r2 == 0) {
            }
        }
        r65 = 0;
        if (r2 == 0) {
        }
    }

    public static void g0() {
        if (D) {
            return;
        }
        D = true;
        try {
            GuardManagerCallbackDispatcher.registerCallBack(new a());
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public static void h0(int i3) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport.14
            @Override // java.lang.Runnable
            public void run() {
                int i16;
                ArrayList arrayList;
                try {
                    if (ReadinjoySPEventReport.x(61)) {
                        BaseActivity baseActivity = BaseActivity.sTopActivity;
                        if (baseActivity instanceof SplashActivity) {
                            SplashActivity splashActivity = (SplashActivity) baseActivity;
                            if (SplashActivity.currentFragment == 1) {
                                int currentTab = splashActivity.getCurrentTab();
                                if (currentTab == com.tencent.mobileqq.activity.home.impl.a.f183044g) {
                                    i16 = 3;
                                } else if (currentTab == com.tencent.mobileqq.activity.home.impl.a.f183040c) {
                                    i16 = 2;
                                } else if (currentTab == com.tencent.mobileqq.activity.home.impl.a.f183038a) {
                                    i16 = 1;
                                } else {
                                    i16 = currentTab == com.tencent.mobileqq.activity.home.impl.a.f183041d ? 4 : 0;
                                }
                                oidb_cmd0x80a.AttributeList attributeList = new oidb_cmd0x80a.AttributeList();
                                attributeList.att_id.set(1);
                                attributeList.att_name.set("tab");
                                attributeList.att_value.set(String.valueOf(i16));
                                oidb_cmd0x80a.AttributeList attributeList2 = new oidb_cmd0x80a.AttributeList();
                                attributeList2.att_id.set(2);
                                attributeList2.att_name.set("type");
                                attributeList2.att_value.set("4");
                                arrayList = new ArrayList();
                                arrayList.add(attributeList);
                                arrayList.add(attributeList2);
                                if (i16 == 1 && !TextUtils.isEmpty("")) {
                                    oidb_cmd0x80a.AttributeList attributeList3 = new oidb_cmd0x80a.AttributeList();
                                    attributeList3.att_id.set(3);
                                    attributeList3.att_name.set("FuncRed");
                                    attributeList3.att_value.set("");
                                    arrayList.add(attributeList3);
                                }
                                ReadinjoyReportUtils.b(61, arrayList);
                            }
                        }
                        i16 = -1;
                        oidb_cmd0x80a.AttributeList attributeList4 = new oidb_cmd0x80a.AttributeList();
                        attributeList4.att_id.set(1);
                        attributeList4.att_name.set("tab");
                        attributeList4.att_value.set(String.valueOf(i16));
                        oidb_cmd0x80a.AttributeList attributeList22 = new oidb_cmd0x80a.AttributeList();
                        attributeList22.att_id.set(2);
                        attributeList22.att_name.set("type");
                        attributeList22.att_value.set("4");
                        arrayList = new ArrayList();
                        arrayList.add(attributeList4);
                        arrayList.add(attributeList22);
                        if (i16 == 1) {
                            oidb_cmd0x80a.AttributeList attributeList32 = new oidb_cmd0x80a.AttributeList();
                            attributeList32.att_id.set(3);
                            attributeList32.att_name.set("FuncRed");
                            attributeList32.att_value.set("");
                            arrayList.add(attributeList32);
                        }
                        ReadinjoyReportUtils.b(61, arrayList);
                    }
                } catch (Throwable th5) {
                    th5.fillInStackTrace();
                }
            }
        }, 128, null, true);
    }

    public static void i0(final int i3, final boolean z16) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport.10
            @Override // java.lang.Runnable
            public void run() {
                String str;
                if (ReadinjoySPEventReport.x(7)) {
                    oidb_cmd0x80a.AttributeList attributeList = new oidb_cmd0x80a.AttributeList();
                    attributeList.att_id.set(1);
                    attributeList.att_name.set("tab");
                    attributeList.att_value.set(String.valueOf(i3));
                    oidb_cmd0x80a.AttributeList attributeList2 = new oidb_cmd0x80a.AttributeList();
                    attributeList2.att_id.set(4);
                    attributeList2.att_name.set("redStatus");
                    PBStringField pBStringField = attributeList2.att_value;
                    if (z16) {
                        str = "1";
                    } else {
                        str = "0";
                    }
                    pBStringField.set(str);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(attributeList);
                    arrayList.add(attributeList2);
                    ReadinjoyReportUtils.b(7, arrayList);
                }
            }
        }, 128, null, true);
    }

    public static void j0(int i3) {
        String H = H();
        if (TextUtils.equals(H, (String) com.tencent.mobileqq.kandian.base.utils.c.c("dau_report_type_" + i3, ""))) {
            QLog.d("ReadinjoySPEventReport", 2, "has report dau for type today, type :" + i3);
            return;
        }
        com.tencent.mobileqq.kandian.base.utils.c.e("dau_report_type_" + i3, H);
        oidb_cmd0x80a.AttributeList attributeList = new oidb_cmd0x80a.AttributeList();
        attributeList.att_id.set(1);
        attributeList.att_name.set("Type");
        attributeList.att_value.set(i3 + "");
        ArrayList arrayList = new ArrayList();
        arrayList.add(attributeList);
        ReadinjoyReportUtils.b(94, arrayList);
    }

    public static void l0(final int i3, final int i16, final List<ChatMessage> list) {
        if (E(i3) < 0) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport.12
            @Override // java.lang.Runnable
            public void run() {
                String str;
                if (ReadinjoySPEventReport.x(60)) {
                    long N = ReadinjoySPEventReport.N();
                    long I = ReadinjoySPEventReport.I(N * 1000) / 1000;
                    boolean z16 = false;
                    boolean z17 = false;
                    for (int size = list.size() - 1; size >= 0; size--) {
                        ChatMessage chatMessage = (ChatMessage) list.get(size);
                        if (chatMessage.time <= N) {
                            break;
                        }
                        if (chatMessage.isSendFromLocal()) {
                            z16 = true;
                        } else {
                            z17 = true;
                        }
                    }
                    ArrayList arrayList = new ArrayList();
                    oidb_cmd0x80a.AttributeList attributeList = new oidb_cmd0x80a.AttributeList();
                    attributeList.att_id.set(1);
                    attributeList.att_name.set("aiotype");
                    attributeList.att_value.set(String.valueOf(ReadinjoySPEventReport.E(i3)));
                    arrayList.add(attributeList);
                    oidb_cmd0x80a.AttributeList attributeList2 = new oidb_cmd0x80a.AttributeList();
                    attributeList2.att_id.set(2);
                    attributeList2.att_name.set("unreadmsg");
                    attributeList2.att_value.set("" + i16);
                    arrayList.add(attributeList2);
                    oidb_cmd0x80a.AttributeList attributeList3 = new oidb_cmd0x80a.AttributeList();
                    attributeList3.att_id.set(3);
                    attributeList3.att_name.set("hassendmsg");
                    PBStringField pBStringField = attributeList3.att_value;
                    String str2 = "1";
                    if (z16) {
                        str = "1";
                    } else {
                        str = "0";
                    }
                    pBStringField.set(str);
                    arrayList.add(attributeList3);
                    oidb_cmd0x80a.AttributeList attributeList4 = new oidb_cmd0x80a.AttributeList();
                    attributeList4.att_id.set(4);
                    attributeList4.att_name.set("hasrecvmsg");
                    PBStringField pBStringField2 = attributeList4.att_value;
                    if (!z17) {
                        str2 = "0";
                    }
                    pBStringField2.set(str2);
                    arrayList.add(attributeList4);
                    oidb_cmd0x80a.AttributeList attributeList5 = new oidb_cmd0x80a.AttributeList();
                    attributeList5.att_id.set(5);
                    attributeList5.att_name.set("costtime");
                    attributeList5.att_value.set("" + I);
                    arrayList.add(attributeList5);
                    ReadinjoyReportUtils.b(60, arrayList);
                }
            }
        }, 128, null, true);
    }

    public static void w0(final List<g> list) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport.13
            @Override // java.lang.Runnable
            public void run() {
                if (ReadinjoySPEventReport.x(19)) {
                    ArrayList arrayList = new ArrayList();
                    StringBuilder sb5 = new StringBuilder();
                    long j3 = 0;
                    int i3 = 0;
                    int i16 = 0;
                    for (int i17 = 0; i17 < list.size(); i17++) {
                        g gVar = (g) list.get(i17);
                        sb5.append(gVar.f239830a + "-" + gVar.f239831b + "-" + gVar.f239833d + "-" + gVar.f239834e);
                        if (i17 != list.size() - 1) {
                            sb5.append(":");
                        } else {
                            i16 = gVar.f239835f;
                        }
                        i3 += gVar.f239833d;
                        j3 += gVar.f239831b;
                    }
                    oidb_cmd0x80a.AttributeList attributeList = new oidb_cmd0x80a.AttributeList();
                    attributeList.att_id.set(1);
                    attributeList.att_name.set("scrollstep");
                    attributeList.att_value.set(sb5.toString());
                    arrayList.add(attributeList);
                    oidb_cmd0x80a.AttributeList attributeList2 = new oidb_cmd0x80a.AttributeList();
                    attributeList2.att_id.set(2);
                    attributeList2.att_name.set("distancetotal");
                    attributeList2.att_value.set("" + i3);
                    arrayList.add(attributeList2);
                    oidb_cmd0x80a.AttributeList attributeList3 = new oidb_cmd0x80a.AttributeList();
                    attributeList3.att_id.set(3);
                    attributeList3.att_name.set("scrolltimetotal");
                    attributeList3.att_value.set("" + j3);
                    arrayList.add(attributeList3);
                    oidb_cmd0x80a.AttributeList attributeList4 = new oidb_cmd0x80a.AttributeList();
                    attributeList4.att_id.set(4);
                    attributeList4.att_name.set("items");
                    attributeList4.att_value.set("" + i16);
                    arrayList.add(attributeList4);
                    ReadinjoyReportUtils.b(19, arrayList);
                }
                f.b();
            }
        }, 128, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean x(int i3) {
        QLog.d("ReadinjoySPEventReport", 2, "canReport : eventID " + i3);
        long currentTimeMillis = System.currentTimeMillis();
        if (i3 != 7) {
            if (i3 == 8) {
                return y(i3, currentTimeMillis);
            }
            if (i3 == 9) {
                return A(i3, currentTimeMillis);
            }
            if (i3 == 11) {
                return z(i3);
            }
            if (i3 == 12) {
                return true;
            }
            if (i3 == 14) {
                try {
                    Pair<Integer, Integer> o16 = ReadInJoyHelper.o();
                    int longValue = (int) (Long.valueOf(com.tencent.mobileqq.kandian.base.utils.b.a()).longValue() % 100);
                    if (o16 != null && longValue >= ((Integer) o16.first).intValue()) {
                        if (longValue <= ((Integer) o16.second).intValue()) {
                            return true;
                        }
                    }
                    return false;
                } catch (Exception e16) {
                    e16.printStackTrace();
                    return false;
                }
            }
            if (i3 != 19 && i3 != 23 && i3 != 24) {
                if (i3 == 60) {
                    return NetConnInfoCenter.getServerTime() - E < f239775u;
                }
                if (i3 != 61) {
                    return false;
                }
                return B(i3);
            }
        }
        return SPEventReportSwitch.d(i3);
    }

    private static boolean y(int i3, long j3) {
        return (SPEventReportSwitch.a() && j3 - f239772r >= ((long) (SPEventReportSwitch.b() * 1000))) || SPEventReportSwitch.d(i3);
    }

    private static boolean z(int i3) {
        if (Calendar.getInstance().get(5) != f239780z) {
            return true;
        }
        return SPEventReportSwitch.a() && SPEventReportSwitch.d(i3);
    }

    public void A0(String str, long j3, boolean z16, String str2, String str3) {
        String str4;
        try {
            oidb_cmd0x80a.AttributeList attributeList = new oidb_cmd0x80a.AttributeList();
            attributeList.att_id.set(1);
            attributeList.att_name.set("ActType");
            attributeList.att_value.set(str);
            oidb_cmd0x80a.AttributeList attributeList2 = new oidb_cmd0x80a.AttributeList();
            attributeList2.att_id.set(2);
            attributeList2.att_name.set("HasRedPnt");
            PBStringField pBStringField = attributeList2.att_value;
            if (z16) {
                str4 = "1";
            } else {
                str4 = "0";
            }
            pBStringField.set(str4);
            oidb_cmd0x80a.AttributeList attributeList3 = new oidb_cmd0x80a.AttributeList();
            attributeList3.att_id.set(3);
            attributeList3.att_name.set("Time");
            attributeList3.att_value.set(String.valueOf(I(j3)));
            oidb_cmd0x80a.AttributeList attributeList4 = new oidb_cmd0x80a.AttributeList();
            attributeList4.att_id.set(4);
            attributeList4.att_name.set("Exposures");
            attributeList4.att_value.set(str2);
            oidb_cmd0x80a.AttributeList attributeList5 = new oidb_cmd0x80a.AttributeList();
            attributeList5.att_id.set(5);
            attributeList5.att_name.set("Clicks");
            attributeList5.att_value.set(str3);
            ArrayList arrayList = new ArrayList(3);
            arrayList.add(attributeList);
            arrayList.add(attributeList2);
            arrayList.add(attributeList3);
            arrayList.add(attributeList4);
            arrayList.add(attributeList5);
            ReadinjoyReportUtils.b(3, arrayList);
            if (QLog.isColorLevel()) {
                QLog.d("ReadinjoySPEventReport", 2, "reportQQNewsAction actType:" + str);
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("ReadinjoySPEventReport", 2, "reportQQNewsAction", e16);
            }
        }
    }

    public void D(String str) {
        if ("2909288299".equals(str)) {
            d.h(3);
        }
    }

    public void E0(int i3) {
        this.f239792l.removeCallbacks(this.f239793m);
        this.f239792l.postDelayed(this.f239793m, i3 * 1000);
    }

    public void F0(boolean z16) {
        f239776v = z16;
    }

    public List<oidb_cmd0x80a.AttributeList> G(int i3) {
        long currentTimeMillis;
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        ArrayList arrayList = new ArrayList();
        QQAppInterface qQAppInterface = runtime instanceof QQAppInterface ? (QQAppInterface) runtime : null;
        if (qQAppInterface == null) {
            return arrayList;
        }
        b bVar = new b(arrayList);
        if (MobileQQ.sProcessId != 1) {
            return arrayList;
        }
        bVar.a(0, "UnreadMsg", String.valueOf(R())).a(100, "FolderStatus", "").b(101, "KDInScreen", false).a(102, "KDAttrL", ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).constructAttributeL()).a(103, "LeftBtmRedPntPulse", h.c(this.f239786f, ":", "`")).a(104, "FirstScnRedPntPulse", h.c(this.f239787g, ":", "`")).a(105, "AIOPulse", h.c(this.f239788h, ":", "`")).a(106, "LastRedExposureTime", ":").b(107, "dt_red", X());
        if (M() > 0) {
            currentTimeMillis = M();
        } else {
            currentTimeMillis = System.currentTimeMillis();
        }
        bVar.a(108, "last_inforeground_time", String.valueOf(currentTimeMillis / 1000));
        bVar.a(109, "last_in_aio_time", String.valueOf(N()));
        c K = J().K();
        if (K != null) {
            K.f239809b.att_id.set(110);
            bVar.c(K.f239809b);
        }
        bVar.b(112, "UniversalStateBit", ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).isMsgTabStoryNodeListVisible());
        bVar.b(120, "PushPreviewQ", SettingCloneUtil.readValue((Context) BaseApplication.getContext(), com.tencent.mobileqq.kandian.base.utils.b.a(), "", AppConstants.QQSETTING_NOTIFY_SHOWCONTENT_KEY, true));
        bVar.b(121, "NoDisturbAtNight", FriendsStatusUtil.c(BaseApplicationImpl.getApplication()));
        int u16 = ReadInJoyHelper.u((QQAppInterface) com.tencent.mobileqq.kandian.base.utils.b.c());
        if (u16 != -1) {
            bVar.a(122, "DongTaiKandian", String.valueOf(u16));
        }
        bVar.b(124, "MsgListFristDataIsVisable", h.b(Integer.valueOf(e.b()), 0));
        bVar.a(126, "ScreenInfo", "").b(128, "is_jcjj_mode", QQTheme.isNowSimpleUI()).a(129, "network", v62.a.a() + "").a(130, "battery", F() + "").a(131, "sessionID", (F / 1000) + "").a(132, "redDot", R() + "_" + h.a(false, "0", "1") + "_" + h.a(X(), String.valueOf(1), String.valueOf(0))).a(133, "app_install_list", "").b(134, "is_study_mode", StudyModeManager.t());
        bVar.a(135, "kdTabNumRed", "0");
        bVar.a(136, "4TabRedStatus", "");
        bVar.a(140, "third_tab_display", T() + "");
        Pair<Integer, Long> P = P(qQAppInterface);
        bVar.a(141, "xsj_msgbox_pos", P.first + "").a(142, "xsj_msgbox_red", P.second + "").a(143, "xsj_tab_red", Q() + "");
        return bVar.d();
    }

    public c K() {
        c cVar = this.f239789i;
        this.f239789i = null;
        return cVar;
    }

    public boolean Y(int i3) {
        if (i3 == 1008 || i3 < 1000 || i3 > 1034) {
            return false;
        }
        return true;
    }

    public void d0(boolean z16) {
        if (TextUtils.isEmpty(this.f239783c)) {
            return;
        }
        ReadinjoyReportUtils.a(this.f239783c, this.f239784d, this.f239785e);
        if (z16) {
            this.f239783c = "";
            d.c();
        }
    }

    public void f0() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport.6
            @Override // java.lang.Runnable
            public void run() {
                ArrayList arrayList = new ArrayList();
                oidb_cmd0x80a.AttributeList attributeList = new oidb_cmd0x80a.AttributeList();
                attributeList.att_id.set(1);
                attributeList.att_name.set("OneClickRead");
                attributeList.att_value.set(String.valueOf(System.currentTimeMillis() / 1000));
                arrayList.add(attributeList);
                ReadinjoyReportUtils.b(13, arrayList);
            }
        }, 128, null, true);
        this.f239791k = true;
    }

    public void m0(final String str, final long j3) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport.8
            @Override // java.lang.Runnable
            public void run() {
                ArrayList arrayList = new ArrayList();
                oidb_cmd0x80a.AttributeList attributeList = new oidb_cmd0x80a.AttributeList();
                attributeList.att_id.set(1);
                attributeList.att_name.set("uin");
                attributeList.att_value.set("" + str);
                oidb_cmd0x80a.AttributeList attributeList2 = new oidb_cmd0x80a.AttributeList();
                attributeList2.att_id.set(2);
                attributeList2.att_name.set("time");
                attributeList2.att_value.set(String.valueOf(ReadinjoySPEventReport.I(j3) / 1000));
                arrayList.add(attributeList);
                arrayList.add(attributeList2);
                ReadinjoyReportUtils.b(21, arrayList);
            }
        }, 128, null, true);
    }

    public void q0(String str, long j3, boolean z16, List<ChatMessage> list, boolean z17) {
        if ("2909288299".equals(str)) {
            A0("Enter", j3, z16, O(list), this.f239781a.toString());
            this.f239781a.setLength(0);
            if (z17) {
                d.c();
            }
        }
    }

    public void t0() {
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport.1
            @Override // java.lang.Runnable
            public void run() {
                ReadinjoySPEventReport.this.u0();
            }
        }, 8, null, true);
    }

    public void u0() {
        try {
            int H1 = ((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime()).getMessageFacade().H1();
            oidb_cmd0x80a.AttributeList attributeList = new oidb_cmd0x80a.AttributeList();
            attributeList.att_id.set(1);
            attributeList.att_name.set("UnreadMsg");
            attributeList.att_value.set(String.valueOf(H1));
            oidb_cmd0x80a.AttributeList attributeList2 = new oidb_cmd0x80a.AttributeList();
            attributeList2.att_id.set(2);
            attributeList2.att_name.set("KDInScreen");
            attributeList2.att_value.set("0");
            oidb_cmd0x80a.AttributeList attributeList3 = new oidb_cmd0x80a.AttributeList();
            attributeList3.att_id.set(3);
            attributeList3.att_name.set("FoldStatus");
            attributeList3.att_value.set("");
            ArrayList arrayList = new ArrayList(3);
            arrayList.add(attributeList);
            arrayList.add(attributeList2);
            arrayList.add(attributeList3);
            ReadinjoyReportUtils.b(1, arrayList);
            if (QLog.isColorLevel()) {
                QLog.d("ReadinjoySPEventReport", 2, "reportManualRefresMsg unRead:" + H1 + " isFirst:false");
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("ReadinjoySPEventReport", 2, "reportManualRefresMsg", e16);
            }
        }
    }

    public void w(final int i3, final List list, String str, int i16, int i17) {
        ArrayList arrayList = new ArrayList(this.f239788h);
        if (i3 == 0 && (arrayList.isEmpty() || ((Integer) ((Pair) arrayList.get(arrayList.size() - 1)).second).intValue() == 0)) {
            return;
        }
        if (i16 == 0 || i16 == 1 || i16 == 3000 || Y(i16)) {
            if (i3 == 1) {
                I0();
            } else {
                l0(i16, i17, list);
            }
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport.5
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        int size = ReadinjoySPEventReport.this.f239788h.size();
                        long j3 = size;
                        if (j3 > ReadInJoyHelper.w(com.tencent.mobileqq.kandian.base.utils.b.c())) {
                            long w3 = j3 - ReadInJoyHelper.w(com.tencent.mobileqq.kandian.base.utils.b.c());
                            while (true) {
                                long j16 = w3 - 1;
                                if (w3 <= 0) {
                                    break;
                                }
                                if (ReadinjoySPEventReport.this.f239788h.size() > 1) {
                                    ReadinjoySPEventReport.this.f239788h.remove(1);
                                }
                                w3 = j16;
                            }
                        }
                        if (size == 0) {
                            ReadinjoySPEventReport.this.f239788h.add(new Pair(Long.valueOf(System.currentTimeMillis() / 1000), 0));
                        }
                        try {
                            ReadinjoySPEventReport.this.f239788h.add(new Pair(Long.valueOf((System.currentTimeMillis() / 1000) - ((Long) ((Pair) ReadinjoySPEventReport.this.f239788h.get(0)).first).longValue()), Integer.valueOf(i3)));
                        } catch (IndexOutOfBoundsException unused) {
                            QLog.e(ReadinjoySPEventReport.class.getSimpleName(), 2, "add aio enter IndexOutOfBoundsException, type : " + i3);
                            ReadinjoySPEventReport.this.f239788h.add(new Pair(Long.valueOf(System.currentTimeMillis() / 1000), Integer.valueOf(i3)));
                        }
                        QLog.d(ReadinjoySPEventReport.class.getSimpleName(), 2, "add aio enter or out info, type : " + i3);
                        List list2 = list;
                        if (list2 != null) {
                            ReadinjoySPEventReport readinjoySPEventReport = ReadinjoySPEventReport.this;
                            readinjoySPEventReport.f239789i = readinjoySPEventReport.C(list2);
                        }
                        if (i3 == 0 && ReadinjoySPEventReport.this.f239790j) {
                            ReadinjoySPEventReport.this.f239790j = false;
                            c cVar = ReadinjoySPEventReport.this.f239789i;
                            if (cVar != null) {
                                ReadinjoySPEventReport.this.k0(cVar);
                            } else {
                                ReadinjoySPEventReport.this.v0(0);
                            }
                        }
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                }
            }, 128, null, true);
            return;
        }
        if (i3 == 1) {
            G0();
        } else {
            J().m0(str, L());
        }
    }

    public void x0(String str, AbsStructMsgElement absStructMsgElement) {
        if ("2909288299".equals(str)) {
            z0("ClickMsg");
            if (absStructMsgElement == null || !(absStructMsgElement instanceof com.tencent.mobileqq.structmsg.a)) {
                return;
            }
            String U = U((com.tencent.mobileqq.structmsg.a) absStructMsgElement);
            if (TextUtils.isEmpty(U)) {
                return;
            }
            if (this.f239781a.length() > 0) {
                this.f239781a.append("`");
            }
            this.f239781a.append(U);
        }
    }

    public void y0(String str, int i3, int i16, mobileqq_mp$ButtonInfo mobileqq_mp_buttoninfo) {
        try {
            if ("2909288299".equals(str)) {
                z0("GetNextMsg");
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("ReadinjoySPEventReport", 2, "reportPubAioMenuAction", e16);
            }
        }
    }

    public void z0(String str) {
        try {
            oidb_cmd0x80a.AttributeList attributeList = new oidb_cmd0x80a.AttributeList();
            attributeList.att_id.set(1);
            attributeList.att_name.set("ActType");
            attributeList.att_value.set(str);
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(attributeList);
            ReadinjoyReportUtils.b(3, arrayList);
            if (QLog.isColorLevel()) {
                QLog.d("ReadinjoySPEventReport", 2, "reportQQNewsAction actType:" + str);
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("ReadinjoySPEventReport", 2, "reportQQNewsAction", e16);
            }
        }
    }

    /* loaded from: classes33.dex */
    private class b {

        /* renamed from: a, reason: collision with root package name */
        private List<oidb_cmd0x80a.AttributeList> f239806a;

        public b(List<oidb_cmd0x80a.AttributeList> list) {
            this.f239806a = new ArrayList();
            if (list != null) {
                this.f239806a = list;
            }
        }

        public b a(int i3, String str, String str2) {
            if (TextUtils.isEmpty(str2)) {
                QLog.d("CommonAttrBulder", 1, "attr value is Empty ! id : " + i3 + ", name : " + str);
                return this;
            }
            oidb_cmd0x80a.AttributeList attributeList = new oidb_cmd0x80a.AttributeList();
            attributeList.att_id.set(i3);
            attributeList.att_name.set(str);
            attributeList.att_value.set(str2);
            this.f239806a.add(attributeList);
            return this;
        }

        public b b(int i3, String str, boolean z16) {
            return a(i3, str, h.a(z16, "1", "0"));
        }

        public List<oidb_cmd0x80a.AttributeList> d() {
            return this.f239806a;
        }

        public b c(oidb_cmd0x80a.AttributeList attributeList) {
            if (attributeList != null) {
                this.f239806a.add(attributeList);
            }
            return this;
        }
    }

    /* loaded from: classes33.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        static long f239821a = 0;

        /* renamed from: b, reason: collision with root package name */
        static long f239822b = 0;

        /* renamed from: c, reason: collision with root package name */
        static int f239823c = -1;

        /* renamed from: d, reason: collision with root package name */
        static int f239824d = -1;

        /* renamed from: e, reason: collision with root package name */
        static int f239825e;

        static int a() {
            return f239823c > f239824d ? 0 : 1;
        }

        public static int b() {
            return f239825e;
        }

        static void d(AbsListView absListView) {
            g gVar = new g();
            int lastVisiblePosition = absListView.getLastVisiblePosition();
            int count = absListView.getAdapter().getCount();
            gVar.f239830a = a();
            gVar.f239833d = Math.abs(f239824d - f239823c);
            long j3 = f239822b;
            gVar.f239831b = j3 - f239821a;
            gVar.f239834e = count - lastVisiblePosition;
            gVar.f239832c = j3;
            gVar.f239835f = count;
            f.a(gVar);
        }

        public static void c(AbsListView absListView, int i3) {
            if (absListView == null || absListView.getChildCount() == 0 || absListView.getAdapter() == null) {
                return;
            }
            e(absListView, i3);
            if (f.f239826a < 0 || f.f239827b < 0) {
                return;
            }
            if (i3 != 0) {
                if (i3 != 1) {
                    return;
                }
                f239823c = absListView.getFirstVisiblePosition();
                f239821a = NetConnInfoCenter.getServerTimeMillis();
                f239824d = -1;
                f239822b = -1L;
                return;
            }
            if (f239824d >= 0 || f239822b >= 0) {
                return;
            }
            f239824d = absListView.getFirstVisiblePosition();
            f239822b = NetConnInfoCenter.getServerTimeMillis();
            d(absListView);
        }

        private static void e(AbsListView absListView, int i3) {
            if (i3 != 0) {
                return;
            }
            int firstVisiblePosition = absListView.getFirstVisiblePosition() - ((ListView) absListView).getHeaderViewsCount();
            f239825e = firstVisiblePosition;
            if (firstVisiblePosition < 0) {
                f239825e = 0;
            }
            QLog.d("ReadinjoySPEventReport", 2, "[onScrollStateChanged] record firstItemPos : ", Integer.valueOf(f239825e));
        }
    }

    public static String D0(long j3) {
        String str = "KongJian";
        switch ((int) j3) {
            case 0:
            case 10000:
                break;
            case 489:
                str = "YouXi";
                break;
            case 763:
                str = "ChiHe";
                break;
            case 769:
                str = "YueDu";
                break;
            case BusinessInfoCheckUpdateItem.UIAPPID_XINGQU_BULUO /* 826 */:
                str = "BuLuo";
                break;
            case 858:
                str = "YunDong";
                break;
            case 871:
            case UfsGROUPMASK.GROUP_MASK_DSJ_PLOT /* 7102 */:
                str = "XinWen";
                break;
            case 879:
                str = "Now";
                break;
            case BusinessInfoCheckUpdateItem.UIAPPID_LEBA_NEARBY_TROOPS /* 886 */:
                str = "FujinQun";
                break;
            case 1041:
                str = "KeTang";
                break;
            case 1047:
                str = "YinYue";
                break;
            case 1113:
                str = "DongMan";
                break;
            case 3050:
                str = "RiJi";
                break;
            case 3053:
                str = "GouWu";
                break;
            case 10001:
                str = "FuJin";
                break;
            case 10004:
                str = "XiaoYuan";
                break;
            default:
                str = null;
                break;
        }
        return TextUtils.isEmpty(str) ? String.valueOf(j3) : str;
    }

    public static void n0() {
        o0(true);
    }

    public static void r0() {
        s0(true);
    }

    public void a0(int i3, boolean z16) {
        this.f239783c = D0(i3);
        this.f239784d = z16;
        this.f239785e = System.currentTimeMillis();
        d.h(2);
    }

    public void c0() {
        d0(true);
    }

    private static Boolean V(MainFragment mainFragment, String str) {
        if (mainFragment != null) {
            return mainFragment.hasRedBadge(str);
        }
        return Boolean.FALSE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k0(c cVar) {
        if (!x(14) || cVar == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(cVar.f239808a);
        arrayList.add(cVar.f239810c);
        arrayList.add(cVar.f239811d);
        ReadinjoyReportUtils.b(14, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v0(int i3) {
        if (x(12)) {
            ArrayList arrayList = new ArrayList();
            oidb_cmd0x80a.AttributeList attributeList = new oidb_cmd0x80a.AttributeList();
            attributeList.att_id.set(1);
            attributeList.att_name.set("Type");
            attributeList.att_value.set(String.valueOf(i3));
            arrayList.add(attributeList);
            ReadinjoyReportUtils.b(12, arrayList);
        }
    }

    public void b0(String str, boolean z16) {
        if (str != null) {
            this.f239783c = str;
        }
        this.f239784d = z16;
        this.f239785e = System.currentTimeMillis();
        d.h(2);
    }

    public static void o0(boolean z16) {
        if (z16) {
            return;
        }
        H0(System.currentTimeMillis());
        d.d();
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport.2
            @Override // java.lang.Runnable
            public void run() {
                String str;
                if (ReadinjoySPEventReport.x(8)) {
                    ArrayList arrayList = new ArrayList();
                    oidb_cmd0x80a.AttributeList attributeList = new oidb_cmd0x80a.AttributeList();
                    attributeList.att_id.set(1);
                    attributeList.att_name.set("DTHasRed");
                    attributeList.att_value.set(String.valueOf(ReadinjoySPEventReport.f239776v ? 1 : 0));
                    arrayList.add(attributeList);
                    BaseActivity baseActivity = BaseActivity.sTopActivity;
                    if (baseActivity != null && (baseActivity instanceof SplashActivity)) {
                        MainFragment mainFragment = (MainFragment) ((SplashActivity) baseActivity).getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
                        String currentTabName = mainFragment != null ? mainFragment.getCurrentTabName() : null;
                        if (currentTabName != null) {
                            if (currentTabName.equals(Conversation.class.getName())) {
                                str = "1";
                            } else if (currentTabName.equals(Contacts.class.getName())) {
                                str = "2";
                            } else if (((ILebaFrameApi) QRoute.api(ILebaFrameApi.class)).isLeba(currentTabName)) {
                                str = "4";
                            } else {
                                str = "0";
                            }
                            oidb_cmd0x80a.AttributeList attributeList2 = new oidb_cmd0x80a.AttributeList();
                            attributeList2.att_id.set(2);
                            attributeList2.att_name.set("tab");
                            attributeList2.att_value.set(str);
                            arrayList.add(attributeList2);
                        }
                    }
                    ReadinjoyReportUtils.b(8, arrayList);
                    ReadinjoySPEventReport.f239772r = System.currentTimeMillis();
                }
            }
        }, 128, null, true);
    }

    public static void s0(boolean z16) {
        if (z16 || d.f239816d == 2) {
            return;
        }
        d.b();
        final long I = I(M());
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport.9
            @Override // java.lang.Runnable
            public void run() {
                if (ReadinjoySPEventReport.x(23)) {
                    oidb_cmd0x80a.AttributeList attributeList = new oidb_cmd0x80a.AttributeList();
                    attributeList.att_id.set(1);
                    attributeList.att_name.set("time");
                    attributeList.att_value.set(String.valueOf(I / 1000));
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(attributeList);
                    ReadinjoyReportUtils.b(23, arrayList);
                }
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport.9.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ReadinjoySPEventReport.H0(-1L);
                    }
                }, 128, null, true);
            }
        }, 128, null, true);
    }

    public void p0(String str, long j3, boolean z16, List<ChatMessage> list) {
        q0(str, j3, z16, list, true);
    }

    private void W() {
    }
}
