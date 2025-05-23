package com.tencent.mobileqq.app.face;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.av.utils.ae;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.face.util.AvatarOptimiseConfigUtil;
import com.tencent.mobileqq.app.n;
import com.tencent.mobileqq.avatar.api.IQQAvatarHandlerService;
import com.tencent.mobileqq.avatar.handler.DiscussionAvatarHandler;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.proavatar.api.IProAvatarUtilsApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.util.bl;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.ah;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.manager.ActivityResultManager;
import com.tencent.qqnt.troop.ITroopExtInfoDBApi;
import com.tencent.qqnt.troopmemberlist.ITroopMemberExtInfoRepoApi;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes11.dex */
public class GroupIconHelper extends com.tencent.mobileqq.avatar.observer.a implements Handler.Callback, od2.a {
    static IPatchRedirector $redirector_;
    private static boolean K;
    private Set<String> C;
    private Set<String> D;
    private BusinessHandler E;
    private CheckDisIconThread F;
    private Object G;
    int H;
    ConcurrentLinkedQueue<GenerateIconRunner> I;
    AtomicInteger J;

    /* renamed from: d, reason: collision with root package name */
    private int f195522d;

    /* renamed from: e, reason: collision with root package name */
    private int f195523e;

    /* renamed from: f, reason: collision with root package name */
    private String f195524f;

    /* renamed from: h, reason: collision with root package name */
    private b f195525h;

    /* renamed from: i, reason: collision with root package name */
    private HashMap<String, a> f195526i;

    /* renamed from: m, reason: collision with root package name */
    private Hashtable<String, Long> f195527m;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class CheckDisIconThread implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        public boolean f195528d;

        CheckDisIconThread() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) GroupIconHelper.this);
            } else {
                this.f195528d = true;
            }
        }

        private int a(int i3, long j3, ArrayList<Pair<String, a>> arrayList, ArrayList<String> arrayList2) {
            a aVar;
            while (true) {
                int i16 = i3;
                for (String str : GroupIconHelper.this.f195526i.keySet()) {
                    aVar = (a) GroupIconHelper.this.f195526i.get(str);
                    if (aVar != null && aVar.f195538g >= 8) {
                        if (GroupIconHelper.this.E instanceof DiscussionHandler) {
                            ((DiscussionHandler) GroupIconHelper.this.E).m4(false, true, str);
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("Q.qqhead.dih", 2, "CheckDisIcon, maxCreateCnt: " + str + ",crateIconCount=" + aVar.f195538g);
                        }
                    } else if (aVar != null && !aVar.f195543l) {
                        if (QLog.isColorLevel()) {
                            QLog.d("Q.qqhead.dih", 2, "CheckDisIcon isFromCreate: " + str + ",fromCreate is false");
                        }
                    } else if (aVar != null && aVar.f195536e != null && aVar.f195533b != 3) {
                        break;
                    }
                }
                return i16;
                i3 = b(i16, j3, arrayList, arrayList2, str, aVar);
            }
        }

        private int b(int i3, long j3, ArrayList<Pair<String, a>> arrayList, ArrayList<String> arrayList2, String str, a aVar) {
            boolean z16 = true;
            if (aVar.f195533b == 1 && j3 - aVar.f195535d >= GroupIconHelper.this.f195522d) {
                if (GroupIconHelper.K(str)) {
                    str = GroupIconHelper.C(str);
                }
                int size = aVar.f195540i.size();
                aVar.f195533b = (byte) 2;
                boolean z17 = false;
                if (size > 0) {
                    if (aVar.f195539h != null) {
                        if (aVar.f195539h.equals(GroupIconHelper.A(aVar.f195540i, false))) {
                            z16 = false;
                        }
                    }
                    if (z16) {
                        arrayList.add(Pair.create(str, aVar));
                        GroupIconHelper.this.f195527m.remove(str);
                    }
                    z17 = z16;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("Q.qqhead.dih", 2, "CheckDisIcon expired: " + str + ", isTryCreate: " + z17 + aVar.toString());
                }
            } else if (aVar.f195533b == 2 && j3 - aVar.f195535d >= GroupIconHelper.this.f195523e) {
                if (QLog.isColorLevel()) {
                    QLog.d("Q.qqhead.dih", 2, "CheckDisIcon timeout: " + str + aVar.toString());
                }
                arrayList2.add(str);
            } else if (aVar.f195533b == 3) {
                return i3;
            }
            return i3 + 1;
        }

        @Override // java.lang.Runnable
        public void run() {
            int a16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("Q.qqhead.dih", 2, "CheckDisIconThread start.");
            }
            while (this.f195528d) {
                long currentTimeMillis = System.currentTimeMillis();
                ArrayList<Pair<String, a>> arrayList = new ArrayList<>();
                ArrayList<String> arrayList2 = new ArrayList<>();
                synchronized (GroupIconHelper.this.f195526i) {
                    a16 = a(0, currentTimeMillis, arrayList, arrayList2);
                }
                if (this.f195528d) {
                    for (int i3 = 0; i3 < arrayList.size() && this.f195528d; i3++) {
                        Pair<String, a> pair = arrayList.get(i3);
                        GroupIconHelper.this.N((String) pair.first, (a) pair.second, true);
                    }
                }
                if (this.f195528d) {
                    for (int i16 = 0; i16 < arrayList2.size() && this.f195528d; i16++) {
                        GroupIconHelper.this.u(arrayList2.get(i16));
                    }
                }
                if (a16 == 0) {
                    break;
                }
                if (this.f195528d) {
                    synchronized (GroupIconHelper.this.G) {
                        try {
                            GroupIconHelper.this.G.wait(GroupIconHelper.this.f195522d / 10);
                        } catch (InterruptedException unused) {
                        }
                    }
                }
            }
            synchronized (GroupIconHelper.this.G) {
                GroupIconHelper.this.F = null;
            }
            if (QLog.isColorLevel()) {
                QLog.d("Q.qqhead.dih", 2, "CheckDisIconThread exit. isRunning=" + this.f195528d);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class CheckIsLowPerformanceMachineRunner implements Runnable {
        static IPatchRedirector $redirector_;

        CheckIsLowPerformanceMachineRunner() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) GroupIconHelper.this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            long l3 = ah.l();
            int n3 = ah.n();
            if (l3 != 0 && l3 < 1024 && n3 <= 1) {
                GroupIconHelper.K = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class GenerateIconRunner implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private int f195529d;

        /* renamed from: e, reason: collision with root package name */
        private String f195530e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f195531f;

        public GenerateIconRunner(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, GroupIconHelper.this, Integer.valueOf(i3), str);
                return;
            }
            this.f195531f = false;
            this.f195529d = i3;
            this.f195530e = str;
            if (GroupIconHelper.K(str)) {
                this.f195530e = GroupIconHelper.C(str);
                this.f195531f = true;
            }
        }

        private void a(a aVar) {
            a D = GroupIconHelper.this.D(this.f195530e, true, aVar, false);
            if (QLog.isDevelopLevel()) {
                QLog.d("Q.qqhead.dih", 2, "CheckAndCreateDisIcon Done: " + this.f195530e + ", isChanged=" + D.f195532a);
            }
            if (D.f195532a) {
                if (D.f195541j) {
                    GroupIconHelper.this.B(GroupIconHelper.F(this.f195530e));
                } else {
                    GroupIconHelper.this.B(this.f195530e);
                }
            }
        }

        private void b(a aVar, int i3) {
            byte b16;
            int i16 = aVar.f195537f;
            if (i3 >= i16 || (((b16 = aVar.f195533b) == 1 && i3 >= 4 && i16 > 4) || ((b16 == 2 && i3 > 0) || aVar.f195542k))) {
                GroupIconHelper.this.N(this.f195530e, aVar, false);
                if (i3 >= aVar.f195537f) {
                    GroupIconHelper.this.f195527m.remove(this.f195530e);
                }
            }
            if (i3 < aVar.f195537f && GroupIconHelper.this.F == null) {
                synchronized (GroupIconHelper.this.G) {
                    if (GroupIconHelper.this.F == null) {
                        GroupIconHelper groupIconHelper = GroupIconHelper.this;
                        groupIconHelper.F = new CheckDisIconThread();
                        ThreadManagerV2.post(GroupIconHelper.this.F, 8, null, false);
                    }
                }
            }
        }

        private void f(QQAppInterface qQAppInterface) {
            a E = GroupIconHelper.this.E(this.f195530e, true, new a(), true, false);
            boolean z16 = false;
            if (E.f195532a) {
                if (GroupIconHelper.this.f195526i.containsKey(this.f195530e)) {
                    GroupIconHelper.this.R(this.f195530e);
                    GroupIconHelper.this.z(this.f195530e);
                    z16 = true;
                } else if (qQAppInterface != null) {
                    File file = new File(qQAppInterface.getCustomFaceFilePath(GroupIconHelper.this.H, this.f195530e, 0));
                    if (file.exists()) {
                        file.delete();
                    }
                    qQAppInterface.removeFaceIconCache(GroupIconHelper.this.H, this.f195530e, 0);
                    GroupIconHelper.this.f195527m.remove(this.f195530e);
                }
            } else {
                GroupIconHelper.this.f195527m.remove(this.f195530e);
            }
            if (QLog.isColorLevel()) {
                QLog.d("Q.qqhead.dih", 2, "refreshDisIcon: " + this.f195530e + ", isChanged=" + E.f195532a + ", isCreated=" + z16);
            }
        }

        private void g(a aVar, QQAppInterface qQAppInterface) {
            String[] split;
            aVar.f195543l = true;
            if (!aVar.f195534c) {
                aVar.f195534c = true;
                aVar.f195540i.clear();
                String str = aVar.f195536e;
                if (str != null && str.length() > 1 && (split = aVar.f195536e.split(";")) != null) {
                    for (String str2 : split) {
                        if (str2 != null && str2.length() != 0) {
                            if (!qQAppInterface.isFaceFileExist(1, str2, 0, 0)) {
                                ((IQQAvatarHandlerService) qQAppInterface.getRuntimeService(IQQAvatarHandlerService.class, "")).getCustomHead(str2, (byte) 0, (byte) 2);
                            } else {
                                aVar.f195540i.add(str2);
                            }
                        }
                    }
                }
            }
            try {
                QLog.d("Q.qqhead.dih", 1, "TYPE_CREAT. disUin=" + MobileQQ.getShortUinStr(this.f195530e) + aVar.toString());
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("Q.qqhead.dih", 2, "TYPE_CREAT", e16);
                }
            }
        }

        public void e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            if (this.f195530e == null) {
                return;
            }
            a aVar = (a) GroupIconHelper.this.f195526i.get(this.f195530e);
            if (this.f195531f) {
                aVar = (a) GroupIconHelper.this.f195526i.get(GroupIconHelper.F(this.f195530e));
            }
            if (aVar != null || this.f195529d == 3) {
                QQAppInterface G = GroupIconHelper.this.G();
                int i3 = this.f195529d;
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 == 3) {
                            f(G);
                            return;
                        }
                        return;
                    }
                    synchronized (this.f195530e) {
                        if (aVar != null) {
                            try {
                                if (aVar.f195536e == null) {
                                    aVar = GroupIconHelper.this.D(this.f195530e, false, aVar, true);
                                }
                            } finally {
                            }
                        }
                        if (aVar == null) {
                            QLog.d("Q.qqhead.dih", 2, "TYPE_CREAT. iconinfo is null, disUin=" + this.f195530e);
                            return;
                        }
                        if (QLog.isDevelopLevel()) {
                            QLog.d("Q.qqhead.dih", 4, "TYPE_CREAT. disUin=" + this.f195530e + " ,isSyncFace=" + aVar.f195534c + ", faceUinSet=" + aVar.f195536e);
                        }
                        if (G != null) {
                            g(aVar, G);
                        }
                        if (aVar.f195533b == 2 && aVar.f195539h != null) {
                            if (aVar.f195539h.equals(GroupIconHelper.A(aVar.f195540i, false))) {
                                return;
                            }
                        }
                        b(aVar, aVar.f195540i.size());
                        return;
                    }
                }
                a(aVar);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            e();
            GroupIconHelper.this.J.decrementAndGet();
            GroupIconHelper.this.S();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public boolean f195532a;

        /* renamed from: b, reason: collision with root package name */
        public byte f195533b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f195534c;

        /* renamed from: d, reason: collision with root package name */
        public long f195535d;

        /* renamed from: e, reason: collision with root package name */
        public String f195536e;

        /* renamed from: f, reason: collision with root package name */
        public int f195537f;

        /* renamed from: g, reason: collision with root package name */
        public int f195538g;

        /* renamed from: h, reason: collision with root package name */
        public String f195539h;

        /* renamed from: i, reason: collision with root package name */
        public ArrayList<String> f195540i;

        /* renamed from: j, reason: collision with root package name */
        public boolean f195541j;

        /* renamed from: k, reason: collision with root package name */
        public boolean f195542k;

        /* renamed from: l, reason: collision with root package name */
        public boolean f195543l;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) GroupIconHelper.this);
                return;
            }
            this.f195533b = (byte) 1;
            this.f195540i = new ArrayList<>();
            this.f195541j = false;
            this.f195542k = false;
            this.f195543l = false;
        }

        public void a(byte b16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Byte.valueOf(b16));
                return;
            }
            if (b16 == 3) {
                this.f195532a = false;
                this.f195533b = (byte) 1;
                this.f195534c = false;
                this.f195536e = null;
                this.f195537f = 0;
                this.f195538g = 0;
                this.f195539h = null;
                this.f195540i.clear();
                this.f195541j = false;
                this.f195542k = false;
                this.f195543l = false;
                return;
            }
            if (b16 == 2) {
                this.f195534c = false;
                this.f195543l = true;
            }
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("\nGroupIconInfo");
            sb5.append("\n |-");
            sb5.append("isChanged:");
            sb5.append(this.f195532a);
            sb5.append("\n |-");
            sb5.append("state:");
            sb5.append((int) this.f195533b);
            sb5.append("\n |-");
            sb5.append("isSyncFace:");
            sb5.append(this.f195534c);
            sb5.append("\n |-");
            sb5.append("startTime:");
            sb5.append(this.f195535d);
            sb5.append("\n |-");
            sb5.append("faceUinSet:");
            sb5.append(this.f195536e);
            sb5.append("\n |-");
            sb5.append("faceCount:");
            sb5.append(this.f195537f);
            sb5.append("\n |-");
            sb5.append("crateIconCount:");
            sb5.append(this.f195538g);
            sb5.append("\n |-");
            sb5.append("lastCreatedFaceUinSet:");
            sb5.append(this.f195539h);
            sb5.append("\n |-");
            sb5.append("isPstnIcon:");
            sb5.append(this.f195541j);
            sb5.append("\n |-");
            sb5.append("hasRealPstnUser:");
            sb5.append(this.f195542k);
            sb5.append("\n |-");
            sb5.append("isFromCreate:");
            sb5.append(this.f195543l);
            try {
                sb5.append("\n |-");
                sb5.append("memberFaceList:");
                sb5.append(this.f195540i);
            } catch (Exception unused) {
            }
            return sb5.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class b extends MqqHandler {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<Handler.Callback> f195545d;

        b(Looper looper, Handler.Callback callback) {
            super(looper);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) looper, (Object) callback);
            } else {
                this.f195545d = new WeakReference<>(callback);
            }
        }

        @Override // mqq.os.MqqHandler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            Handler.Callback callback = this.f195545d.get();
            if (callback != null) {
                callback.handleMessage(message);
            }
        }
    }

    public GroupIconHelper(String str, BusinessHandler businessHandler) {
        Looper mainLooper;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) businessHandler);
            return;
        }
        this.f195522d = 60000;
        this.f195523e = 90000;
        this.F = null;
        this.G = new Object();
        this.I = new ConcurrentLinkedQueue<>();
        this.J = new AtomicInteger(0);
        this.f195524f = str;
        if (QLog.isDevelopLevel()) {
            QLog.d("Q.qqhead.dih", 4, "Create GroupIconHelper For [" + this.f195524f + "]");
        }
        this.f195526i = new HashMap<>();
        this.f195527m = new Hashtable<>();
        this.C = new HashSet();
        this.D = new HashSet();
        QQAppInterface G = G();
        if (G != null && G.getApp() != null) {
            mainLooper = G.getApp().getMainLooper();
        } else {
            mainLooper = Looper.getMainLooper();
        }
        this.f195525h = new b(mainLooper, this);
        this.E = businessHandler;
        if (G != null) {
            G.execute(new CheckIsLowPerformanceMachineRunner());
        }
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.app.face.GroupIconHelper.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GroupIconHelper.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    QQAppInterface G2 = GroupIconHelper.this.G();
                    if (G2 != null) {
                        G2.addObserver(GroupIconHelper.this);
                        try {
                            ((IPhoneContactService) G2.getRuntimeService(IPhoneContactService.class, "")).addListener(GroupIconHelper.this);
                            return;
                        } catch (Exception e16) {
                            QLog.d("Q.qqhead.dih", 2, "init phoneContactService", e16);
                            return;
                        }
                    }
                    return;
                }
                iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        if (this.E instanceof DiscussionHandler) {
            this.H = 101;
        } else {
            this.H = 113;
        }
    }

    public static String A(ArrayList<String> arrayList, boolean z16) {
        String str;
        if (arrayList != null && arrayList.size() > 0) {
            StringBuilder sb5 = new StringBuilder(128);
            ArrayList arrayList2 = (ArrayList) arrayList.clone();
            int i3 = 0;
            for (int i16 = 0; i16 < arrayList2.size(); i16++) {
                sb5.append((String) arrayList2.get(i16));
                sb5.append(";");
                i3++;
                if ((z16 && J() && i3 >= 4) || i3 >= 9) {
                    break;
                }
            }
            str = sb5.toString();
        } else {
            str = " ";
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("Q.qqhead.dih", 2, "createFaceUinSet, ret=" + str + ",sureChanged=" + z16);
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(String str) {
        this.f195525h.removeMessages(ActivityResultManager.ACTION_REQUEST_PERMISSION, str);
        this.f195525h.sendMessageDelayed(this.f195525h.obtainMessage(ActivityResultManager.ACTION_REQUEST_PERMISSION, str), 300L);
    }

    public static String C(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.i("Q.qqhead.dih", 1, "===getDiscussionUinFromPstn pstnDiscussionUin is null ===");
            return null;
        }
        int indexOf = str.indexOf("_");
        if (indexOf >= 0 && indexOf <= str.length()) {
            return str.substring(0, indexOf);
        }
        QLog.i("Q.qqhead.dih", 1, "===getDiscussionUinFromPstn pstnDiscussionUin is invalid, pstnDiscussionUin | " + str);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a D(String str, boolean z16, a aVar, boolean z17) {
        return E(str, z16, aVar, z17, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a E(String str, boolean z16, a aVar, boolean z17, boolean z18) {
        ArrayList<String> arrayList;
        QQAppInterface G = G();
        if (G != null) {
            if (this.H == 101) {
                arrayList = ((n) G.getManager(QQManagerFactory.DISCUSSION_MANAGER)).o(str);
            } else {
                TroopManager troopManager = (TroopManager) G.getManager(QQManagerFactory.TROOP_MANAGER);
                ArrayList<String> C = troopManager.C(str);
                TroopInfo B = troopManager.B(str);
                if (B != null && C.size() == 0 && z18 && B.wMemberNum > 1) {
                    ((ITroopMemberExtInfoRepoApi) QRoute.api(ITroopMemberExtInfoRepoApi.class)).fetchNewTroopHeadUinList(str);
                }
                I(C, B);
                arrayList = C;
            }
        } else {
            arrayList = null;
        }
        if (QLog.isDevelopLevel()) {
            if (arrayList != null && arrayList.size() != 0) {
                StringBuilder sb5 = new StringBuilder();
                Iterator<String> it = arrayList.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (next != null && next.length() > 5) {
                        sb5.append(next.substring(0, 4));
                    } else {
                        sb5.append(next);
                    }
                    sb5.append(";");
                }
                QLog.d("Q.qqhead.dih", 2, "discussionUin=" + MobileQQ.getShortUinStr(str) + " memberUinList is:" + sb5.toString());
            } else {
                QLog.d("Q.qqhead.dih", 4, "discussionUin=" + str + " memberUinList is empty...");
            }
        }
        if (arrayList != null && arrayList.size() != 0) {
            aVar.f195537f = arrayList.size();
        } else {
            aVar.f195537f = 0;
        }
        String A = A(arrayList, z17);
        aVar.f195536e = A;
        t(str, z16, aVar, G, A);
        return aVar;
    }

    public static String F(String str) {
        if (str != null && str.length() != 0) {
            return str + "_1001";
        }
        QLog.i("Q.qqhead.dih", 1, "===getPstnDiscussionUin discussionUin is null ===");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public QQAppInterface G() {
        BaseApplicationImpl application = BaseApplicationImpl.getApplication();
        if (application == null) {
            return null;
        }
        AppRuntime runtime = application.getRuntime();
        if (!(runtime instanceof QQAppInterface)) {
            return null;
        }
        return (QQAppInterface) runtime;
    }

    public static ArrayList<String> H(ArrayList<String> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            ArrayList<String> arrayList2 = (ArrayList) arrayList.clone();
            int size = arrayList.size();
            String account = BaseApplicationImpl.getApplication().getRuntime().getAccount();
            if (size <= 9) {
                if (!arrayList2.contains(account)) {
                    arrayList2.add(account);
                }
            } else {
                arrayList2.remove(account);
            }
            if (QLog.isDevelopLevel()) {
                QLog.d("Q.qqhead.dih", 4, "handleNewGroupSecHeadUins, memberUinSize=" + arrayList2.size());
            }
            return arrayList2;
        }
        QLog.d("Q.qqhead.dih", 2, "handleDiscussionSecHeadUins memberUinList is null");
        return arrayList;
    }

    public static ArrayList<String> I(ArrayList<String> arrayList, TroopInfo troopInfo) {
        if (arrayList != null && !arrayList.isEmpty()) {
            if (troopInfo == null) {
                QLog.d("Q.qqhead.dih", 2, "handleNewGroupSecHeadUins troopInfo is null");
                return arrayList;
            }
            ArrayList<String> arrayList2 = (ArrayList) arrayList.clone();
            AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
            if (runtime != null) {
                String account = runtime.getAccount();
                if (arrayList2.size() <= 9) {
                    if (!arrayList2.contains(account)) {
                        arrayList2.add(account);
                    }
                } else {
                    arrayList2.remove(account);
                }
            } else {
                QLog.e("Q.qqhead.dih", 1, "handleNewGroupSecHeadUins app is null");
            }
            if (QLog.isDevelopLevel()) {
                QLog.d("Q.qqhead.dih", 2, "handleNewGroupSecHeadUins, discussionUin=" + troopInfo.troopuin + ",NumClient=" + troopInfo.getMemberNumClient() + ",memberUinSize=" + arrayList2);
            }
            return arrayList2;
        }
        QLog.d("Q.qqhead.dih", 2, "handleNewGroupSecHeadUins memberUinList is null");
        return arrayList;
    }

    public static boolean J() {
        return K;
    }

    public static boolean K(String str) {
        if (str != null && str.length() != 0) {
            return str.contains("_1001");
        }
        QLog.i("Q.qqhead.dih", 1, "===isPstnDiscussionUin discussionUin is null ===");
        return false;
    }

    private boolean L(String str, boolean z16, boolean z17, QQAppInterface qQAppInterface, String str2, File file) {
        Bitmap bitmap;
        if (str != null && str.trim().length() <= 0) {
            if (file != null && file.exists() && file.isFile()) {
                file.delete();
            }
            if (!z16 || (z16 && !z17)) {
                int i3 = this.H;
                if (i3 == 101) {
                    bitmap = BaseImageUtil.getDefaultDiscusionFaceBitmap();
                } else if (i3 == 113) {
                    bitmap = BaseImageUtil.getDefaultDiscusionFaceBitmap();
                } else {
                    bitmap = null;
                }
                if (bitmap != null) {
                    qQAppInterface.putBitmapToCache(str2, bitmap, (byte) 2);
                    return true;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    private boolean M(String str, boolean z16) {
        a aVar;
        boolean z17;
        synchronized (this.f195526i) {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.f195526i.containsKey(str)) {
                aVar = this.f195526i.get(str);
                if (aVar.f195533b == 3) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if ((!z17 && currentTimeMillis - aVar.f195535d < this.f195523e) || (z17 && !z16 && currentTimeMillis - aVar.f195535d < 3600000)) {
                    if (QLog.isDevelopLevel()) {
                        QLog.d("Q.qqhead.dih", 4, "putDiscussionIconInfo notDo, disUin=" + str + ",isFromCreate=" + z16 + ",isRealCreated=" + z17 + ",startTime=" + aVar.f195535d + ",state=" + ((int) aVar.f195533b));
                    }
                    return false;
                }
                if (QLog.isDevelopLevel() && !z17) {
                    QLog.d("Q.qqhead.dih", 4, "putDiscussionIconInfo reset, disUin=" + str + ",isFromCreate=" + z16 + ",isRealCreated=" + z17 + ",state=" + ((int) aVar.f195533b));
                }
                aVar.a(aVar.f195533b);
            } else {
                aVar = new a();
                this.f195526i.put(str, aVar);
                if (QLog.isDevelopLevel()) {
                    QLog.d("Q.qqhead.dih", 2, "putDiscussionIconInfo  not hit, disUin=" + str);
                }
            }
            if (K(str)) {
                QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
                aVar.f195541j = true;
                aVar.f195542k = ae.f(qQAppInterface, C(str), 3000);
            }
            aVar.f195535d = currentTimeMillis;
            this.f195526i.put(str, aVar);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(String str, a aVar, boolean z16) {
        DiscussionInfo discussionInfo;
        if (aVar.f195533b == 3) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.qqhead.dih", 2, "CreateIcon created: " + str + ", iconCount=" + aVar.f195540i.size() + ", totalCount=" + aVar.f195537f);
                return;
            }
            return;
        }
        QQAppInterface G = G();
        if (G == null) {
            QLog.d("Q.qqhead.dih", 1, "CreateIcon fail app is null, group: " + str);
            return;
        }
        Pair<Boolean, Boolean> w3 = w(aVar.f195536e, str, aVar.f195540i, aVar.f195541j, aVar.f195542k);
        boolean booleanValue = ((Boolean) w3.first).booleanValue();
        boolean booleanValue2 = ((Boolean) w3.second).booleanValue();
        if (booleanValue) {
            aVar.f195538g++;
            String A = A(aVar.f195540i, z16);
            aVar.f195539h = A;
            String str2 = null;
            if (this.H == 101) {
                n nVar = (n) G.getManager(QQManagerFactory.DISCUSSION_MANAGER);
                if (nVar != null) {
                    discussionInfo = nVar.h(str);
                } else {
                    discussionInfo = null;
                }
                if (discussionInfo != null) {
                    discussionInfo.faceUinSet = A;
                    EntityManager createEntityManager = G.getEntityManagerFactory().createEntityManager();
                    createEntityManager.update(discussionInfo);
                    createEntityManager.close();
                    if (QLog.isColorLevel()) {
                        str2 = discussionInfo.discussionName;
                    }
                }
            } else {
                TroopInfo troopInfo = ((ITroopInfoService) G.getRuntimeService(ITroopInfoService.class, "")).getTroopInfo(str);
                if (troopInfo != null) {
                    A = A(I(aVar.f195540i, troopInfo), z16);
                    aVar.f195539h = A;
                    troopInfo.extDBInfo.headerUinsOld = A;
                    ((ITroopExtInfoDBApi) QRoute.api(ITroopExtInfoDBApi.class)).updateHeaderUinOld(troopInfo.troopuin, A, "Q.qqhead.dih");
                    str2 = troopInfo.getTroopDisplayName();
                }
            }
            if (aVar.f195540i.size() >= aVar.f195537f && booleanValue2) {
                aVar.f195533b = (byte) 3;
            }
            BusinessHandler businessHandler = this.E;
            if (businessHandler instanceof DiscussionHandler) {
                if (aVar.f195541j) {
                    ((DiscussionHandler) businessHandler).m4(booleanValue, booleanValue2, F(str));
                    ((DiscussionAvatarHandler) G.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_AVATAR_HANDLER)).D2(booleanValue, booleanValue2, F(str));
                } else {
                    ((DiscussionHandler) businessHandler).m4(booleanValue, booleanValue2, str);
                    ((DiscussionAvatarHandler) G.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_AVATAR_HANDLER)).D2(booleanValue, booleanValue2, str);
                    G.sendQQHeadBroadcast(101, str, 0, G.getCustomFaceFilePath(101, str, 0));
                }
            } else if (businessHandler instanceof com.tencent.mobileqq.troop.api.handler.b) {
                G.getBusinessHandler(BusinessHandlerFactory.TROOP_AVATAR_HANDLER).notifyUI(com.tencent.mobileqq.troop.api.observer.a.TYPE_NOTIFY_GET_NEW_TROOP_HEAD, booleanValue, Pair.create(Boolean.valueOf(booleanValue2), str));
                G.sendQQHeadBroadcast(113, str, 0, G.getCustomFaceFilePath(113, str, 0));
            }
            if (QLog.isColorLevel()) {
                if (str2 != null && str2.length() > 3) {
                    str2 = str2.substring(0, 2) + "." + str2.charAt(str2.length() - 1);
                }
                QLog.d("Q.qqhead.dih", 2, "CreateIcon Done: uin=" + str + ", name=" + str2 + ", isComplete=" + booleanValue2 + ", newFaceUinSet=" + A + aVar.toString());
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.qqhead.dih", 2, "CreateIcon fail: " + str + ", iconCount=" + aVar.f195540i.size() + ", totalCount=" + aVar.f195537f);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00cc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Pair<Boolean, Boolean> O(String str, String str2, boolean z16, boolean z17, boolean z18, String str3, QQAppInterface qQAppInterface, byte b16, String str4, File file, boolean z19, Bitmap bitmap) {
        boolean z26;
        BufferedOutputStream bufferedOutputStream;
        QQAppInterface qQAppInterface2;
        String str5;
        Bitmap bitmap2;
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            if (z16) {
                Set<String> set = this.D;
                if (set != null) {
                    synchronized (set) {
                        this.D.add(str2);
                    }
                }
                bufferedOutputStream = null;
                z26 = true;
            } else {
                if (file == null) {
                    if (QLog.isColorLevel()) {
                        QLog.i("Q.qqhead.dih", 2, "createAndSaveDiscussionIcon2File | file is null ");
                    }
                    return Pair.create(Boolean.valueOf(z18), Boolean.FALSE);
                }
                if (!file.exists()) {
                    file.createNewFile();
                }
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                try {
                    z26 = bitmap.compress(Bitmap.CompressFormat.PNG, 90, bufferedOutputStream);
                    bufferedOutputStream.flush();
                } catch (Throwable unused) {
                    bufferedOutputStream2 = bufferedOutputStream;
                    if (bufferedOutputStream2 != null) {
                        try {
                            bufferedOutputStream2.close();
                        } catch (Throwable th5) {
                            th5.printStackTrace();
                        }
                    }
                    z26 = false;
                    return Pair.create(Boolean.valueOf(z26), Boolean.valueOf(z19));
                }
            }
            if (QLog.isDevelopLevel()) {
                QLog.i("Q.qqhead.dih", 4, "createAndSaveDiscussionIcon2File,[" + z26 + "," + str2 + "," + str + "," + str3 + "],hasPstnIcon | " + z16 + ",hasRealPstnUser: " + z17);
            }
        } catch (Throwable unused2) {
        }
        if (b16 == 3) {
            bitmap2 = QQAppInterface.getCircleFaceBitmap(bitmap, 50, 50);
        } else if (b16 == 1) {
            bitmap2 = QQAppInterface.getShapeRoundFaceBitmap(bitmap, 10, 50, 50);
        } else {
            qQAppInterface2 = qQAppInterface;
            str5 = str4;
            bitmap2 = bitmap;
            qQAppInterface2.putBitmapToCache(str5, bitmap2, (byte) 2);
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (Throwable th6) {
                    th6.printStackTrace();
                }
            }
            return Pair.create(Boolean.valueOf(z26), Boolean.valueOf(z19));
        }
        qQAppInterface2 = qQAppInterface;
        str5 = str4;
        qQAppInterface2.putBitmapToCache(str5, bitmap2, (byte) 2);
        if (bufferedOutputStream != null) {
        }
        return Pair.create(Boolean.valueOf(z26), Boolean.valueOf(z19));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S() {
        GenerateIconRunner poll;
        if (QLog.isDevelopLevel()) {
            QLog.d("Q.qqhead.dih", 2, "runNext: mRunningTaskNum=" + this.J.get() + ", queueSize=" + this.I.size());
        }
        if (this.J.get() < 3 && (poll = this.I.poll()) != null) {
            this.J.incrementAndGet();
            ThreadManagerV2.post(poll, 10, null, true);
        }
    }

    private void s(GenerateIconRunner generateIconRunner) {
        if (AvatarOptimiseConfigUtil.b()) {
            return;
        }
        this.I.offer(generateIconRunner);
        S();
    }

    private void t(String str, boolean z16, a aVar, QQAppInterface qQAppInterface, String str2) {
        TroopInfo B;
        if (z16) {
            String str3 = null;
            if (qQAppInterface != null) {
                int i3 = this.H;
                if (i3 == 101) {
                    DiscussionInfo h16 = ((n) qQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)).h(str);
                    if (h16 != null) {
                        str3 = h16.faceUinSet;
                    }
                } else if (i3 == 113 && (B = ((TroopManager) qQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).B(str)) != null) {
                    str3 = B.extDBInfo.headerUinsOld;
                }
            }
            boolean z17 = false;
            if (((str3 != null && !"".equals(str3.trim())) || (str2 != null && !"".equals(str2.trim()))) && ((str2 != null && !str2.equals(str3)) || ((str3 != null && !str3.equals(str2)) || (aVar.f195533b == 2 && str2 != null && !str2.equals(aVar.f195539h) && aVar.f195543l)))) {
                z17 = true;
            }
            aVar.f195532a = z17;
        }
    }

    private Pair<Boolean, Boolean> w(String str, String str2, ArrayList<String> arrayList, boolean z16, boolean z17) {
        String str3;
        String str4;
        File file;
        Bitmap bitmap;
        boolean z18;
        if (str2 != null && (str != null || z17)) {
            QQAppInterface G = G();
            if (G == null) {
                QLog.e("Q.qqhead.dih", 1, "createAndSaveDiscussionIcon2File app is null");
                Boolean bool = Boolean.FALSE;
                return Pair.create(bool, bool);
            }
            if (!z16) {
                str3 = G.getCustomFaceFilePath(this.H, str2, 0);
            } else {
                str3 = null;
            }
            byte a16 = com.tencent.mobileqq.avatar.utils.c.a((byte) 3);
            String faceBitmapCacheKey = G.getFaceBitmapCacheKey(this.H, str2, a16, 0);
            if (z16) {
                str4 = G.getFaceBitmapCacheKey(1001, F(str2), a16, 0);
            } else {
                str4 = faceBitmapCacheKey;
            }
            if (!TextUtils.isEmpty(str3)) {
                file = new File(str3);
            } else {
                file = null;
            }
            if (L(str, z16, z17, G, str4, file)) {
                Boolean bool2 = Boolean.TRUE;
                return Pair.create(bool2, bool2);
            }
            try {
                Pair<Boolean, Bitmap> y16 = y(str, str2, arrayList, z16, z17);
                Bitmap bitmap2 = (Bitmap) y16.second;
                z18 = ((Boolean) y16.first).booleanValue();
                bitmap = bitmap2;
            } catch (Throwable unused) {
                bitmap = null;
                z18 = true;
            }
            if (bitmap == null) {
                Boolean bool3 = Boolean.FALSE;
                return Pair.create(bool3, bool3);
            }
            return O(str, str2, z16, z17, false, str3, G, a16, str4, file, z18, bitmap);
        }
        Boolean bool4 = Boolean.FALSE;
        return Pair.create(bool4, bool4);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(20:1|(1:(2:73|74)(1:75))(1:5)|6|(1:8)|9|(1:11)|(1:13)(1:71)|14|(2:16|(1:18)(1:69))(1:70)|(1:68)(2:21|(12:25|b5|30|31|(3:33|(2:41|42)(4:35|(1:37)|38|39)|40)|43|(2:47|(2:50|48))|51|52|53|54|55))|67|31|(0)|43|(3:45|47|(1:48))|51|52|53|54|55) */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0134, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x013a, code lost:
    
        if (com.tencent.qphone.base.util.QLog.isColorLevel() != false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x013c, code lost:
    
        com.tencent.qphone.base.util.QLog.d("Q.qqhead.dih", 2, "createDiscussionIcon fail, disUin=" + r18 + ", throwable : " + r0.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0161, code lost:
    
        r5 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0121 A[LOOP:1: B:48:0x011b->B:50:0x0121, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Pair<Boolean, Bitmap> y(String str, String str2, ArrayList<String> arrayList, boolean z16, boolean z17) {
        boolean z18;
        String[] strArr;
        int i3;
        List<Bitmap> list;
        int i16;
        int i17;
        int i18;
        boolean z19 = true;
        boolean z26 = false;
        if (str != null && str.length() > 1) {
            z18 = false;
        } else {
            if (!z17) {
                return Pair.create(Boolean.FALSE, null);
            }
            z18 = true;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        float f16 = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().density;
        if (f16 < 1.0f) {
            f16 = 1.0f;
        }
        int i19 = (int) ((50.0f * f16) + 0.5d);
        if (QLog.isDevelopLevel()) {
            QLog.d("Q.qqhead.dih", 2, "createDiscussionIcon density=" + f16 + ";imageWidth=" + i19 + ",hasPstnIcon: " + z16 + ", hasRealPhoneUser: " + z17);
        }
        if (!z18) {
            strArr = str.split(";");
        } else {
            strArr = null;
        }
        if (strArr != null) {
            if (strArr.length > 9) {
                i3 = 9;
            } else {
                i3 = strArr.length;
            }
        } else {
            i3 = 0;
        }
        if (i3 < 9 && z16) {
            list = ae.d(qQAppInterface, str2, 3000, 9 - i3);
            if (list != null && list.size() > 0) {
                i16 = list.size() + i3;
                synchronized (this.C) {
                    this.C.add(str2);
                }
                Bitmap[] bitmapArr = new Bitmap[i16];
                for (i17 = 0; i17 < i3; i17++) {
                    String str3 = strArr[i17];
                    Pair<Boolean, Bitmap> scaledFaceBitmap = qQAppInterface.getScaledFaceBitmap(str3, (byte) 5, 0, 0);
                    if (!((Boolean) scaledFaceBitmap.first).booleanValue()) {
                        if (QLog.isDevelopLevel()) {
                            QLog.d("Q.qqhead.dih", 2, "getScaledFaceBitmap fail, disUin=" + str2 + ", uin=" + str3);
                        }
                        arrayList.remove(str3);
                        z19 = false;
                    }
                    bitmapArr[i17] = (Bitmap) scaledFaceBitmap.second;
                }
                if (list != null && list.size() > 0) {
                    for (i18 = 0; i18 < list.size(); i18++) {
                        bitmapArr[i18 + i3] = list.get(i18);
                    }
                }
                Bitmap bitmap = x(i19, bitmapArr);
                z26 = z19;
                return Pair.create(Boolean.valueOf(z26), bitmap);
            }
        } else {
            list = null;
        }
        i16 = i3;
        Bitmap[] bitmapArr2 = new Bitmap[i16];
        while (i17 < i3) {
        }
        if (list != null) {
            while (i18 < list.size()) {
            }
        }
        Bitmap bitmap2 = x(i19, bitmapArr2);
        z26 = z19;
        return Pair.create(Boolean.valueOf(z26), bitmap2);
    }

    @Override // od2.a
    public void B7(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, j3);
        }
    }

    @Override // od2.a
    public void L1(int i3) {
        Set<String> set;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3);
            return;
        }
        if (i3 == 1 && (set = this.C) != null) {
            synchronized (set) {
                if (this.C.size() > 0) {
                    ArrayList arrayList = new ArrayList(this.C);
                    int size = arrayList.size();
                    for (int i16 = 0; i16 < size; i16++) {
                        String str = (String) arrayList.get(i16);
                        if (str != null && str.length() != 0) {
                            T(str);
                        }
                    }
                    this.C.clear();
                }
            }
        }
    }

    public void P(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f195527m.containsKey(str)) {
            Long l3 = this.f195527m.get(str);
            if (l3 == null) {
                l3 = 0L;
            }
            if (currentTimeMillis - l3.longValue() < this.f195522d) {
                if (QLog.isDevelopLevel()) {
                    QLog.d("Q.qqhead.dih", 4, "refreshDisIcon repeat: " + str);
                    return;
                }
                return;
            }
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("Q.qqhead.dih", 4, "refreshDisIcon: " + str);
        }
        this.f195527m.put(str, Long.valueOf(currentTimeMillis));
        s(new GenerateIconRunner(3, str));
        Set<String> set = this.D;
        if (set != null && set.contains(str)) {
            if (QLog.isDevelopLevel()) {
                QLog.d("Q.qqhead.dih", 4, "refreshDisIcon mDisCallUinSet has it " + str);
            }
            synchronized (this.D) {
                this.D.remove(str);
            }
            T(str);
        }
    }

    public void Q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.qqhead.dih", 2, "GroupIconHelper release.");
        }
        CheckDisIconThread checkDisIconThread = this.F;
        if (checkDisIconThread != null) {
            checkDisIconThread.f195528d = false;
            synchronized (this.G) {
                this.G.notifyAll();
            }
        }
        synchronized (this.f195526i) {
            this.f195526i.notifyAll();
            for (String str : this.f195526i.keySet()) {
                a aVar = this.f195526i.get(str);
                if (aVar != null && (aVar instanceof a) && aVar.f195533b != 3) {
                    BusinessHandler businessHandler = this.E;
                    if (businessHandler instanceof DiscussionHandler) {
                        ((DiscussionHandler) businessHandler).m4(false, true, str);
                    }
                }
            }
            this.f195526i.clear();
        }
        QQAppInterface G = G();
        if (G != null) {
            IPhoneContactService iPhoneContactService = (IPhoneContactService) G.getRuntimeService(IPhoneContactService.class, "");
            if (iPhoneContactService != null) {
                iPhoneContactService.removeListener(this);
            }
            G.removeObserver(this);
        }
        this.E = null;
    }

    public void R(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("Q.qqhead.dih", 4, "removeDiscussion: " + str);
        }
        synchronized (this.f195526i) {
            this.f195526i.remove(str);
        }
    }

    public void T(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
            return;
        }
        String F = F(str);
        if (this.f195526i.containsKey(F)) {
            QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
            R(F);
            qQAppInterface.removeBitmapFromCache(qQAppInterface.getFaceBitmapCacheKey(1001, F(str), (byte) 3, 0));
            z(F);
        }
    }

    @Override // od2.a
    public void T2(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3);
        }
    }

    @Override // od2.a
    public void Ug(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
        }
    }

    @Override // od2.a
    public void e7(boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, Boolean.valueOf(z16), Integer.valueOf(i3));
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) message)).booleanValue();
        }
        if (message.what == 9527) {
            String str = (String) message.obj;
            if (QLog.isDevelopLevel()) {
                QLog.d("Q.qqhead.dih", 4, "handleMessage ACTION_GENERATE_DISCUSSION: groupUin=" + str);
            }
            s(new GenerateIconRunner(2, str));
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.avatar.observer.a
    public void onUpdateCustomHead(boolean z16, String str) {
        ArrayList arrayList;
        a aVar;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Boolean.valueOf(z16), str);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("Q.qqhead.dih", 4, "onUpdateCustomHead isSuccess | " + z16 + ", uin=" + str);
        }
        synchronized (this.f195526i) {
            arrayList = null;
            for (String str3 : this.f195526i.keySet()) {
                a aVar2 = this.f195526i.get(str3);
                if (aVar2 != null && (aVar2 instanceof a)) {
                    aVar = aVar2;
                } else {
                    aVar = null;
                }
                if (aVar != null && (str2 = aVar.f195536e) != null) {
                    if (aVar.f195541j) {
                        if (z16 && str2.contains(str)) {
                            if (QLog.isDevelopLevel()) {
                                QLog.d("Q.qqhead.dih", 4, "onUpdateCustomHead pstn: disUin=" + str3 + ", uin=" + str + ", faceUinSet=" + str2);
                            }
                            if (aVar.f195533b != 3) {
                                aVar.f195540i.add(str);
                                B(str3);
                            } else {
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                }
                                arrayList.add(str3);
                            }
                        }
                    } else if (aVar.f195533b != 3 && z16 && str2.contains(str)) {
                        if (QLog.isDevelopLevel()) {
                            QLog.d("Q.qqhead.dih", 4, "onUpdateCustomHead: disUin=" + str3 + ", uin=" + str + ", faceUinSet=" + str2);
                        }
                        aVar.f195540i.add(str);
                        B(str3);
                    }
                }
            }
        }
        if (arrayList != null && arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                T(C((String) it.next()));
            }
        }
    }

    public void u(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            return;
        }
        boolean M = M(str, false);
        if (M) {
            if (QLog.isDevelopLevel()) {
                QLog.d("Q.qqhead.dih", 2, "checkDisIcon: " + str + ", isNeedToDo=" + M);
            }
            s(new GenerateIconRunner(1, str));
        }
    }

    public void v(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            return;
        }
        String b16 = ae.b((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime(), str, 3000);
        if ((b16 == null || b16.length() == 0) && this.C.contains(str)) {
            synchronized (this.C) {
                this.C.remove(str);
            }
            T(str);
        }
    }

    public Bitmap x(int i3, Bitmap[] bitmapArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Bitmap) iPatchRedirector.redirect((short) 8, (Object) this, i3, (Object) bitmapArr);
        }
        Bitmap bitmap = null;
        try {
            bitmap = ((IProAvatarUtilsApi) QRoute.api(IProAvatarUtilsApi.class)).getGroupAvatar(i3, bitmapArr);
            if (bitmap == null) {
                bitmap = bl.a(i3, bitmapArr);
            }
            if (QLog.isColorLevel() && bitmap == null) {
                QLog.i("Q.qqhead.dih", 2, "createDiscussionIcon| mask = ");
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.i("Q.qqhead.dih", 2, e16.toString());
            }
        } catch (OutOfMemoryError e17) {
            if (QLog.isColorLevel()) {
                QLog.i("Q.qqhead.dih", 2, e17.toString());
            }
        } catch (Error e18) {
            if (QLog.isColorLevel()) {
                QLog.i("Q.qqhead.dih", 2, e18.toString());
            }
        }
        return bitmap;
    }

    public void z(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            return;
        }
        boolean M = M(str, true);
        if (QLog.isDevelopLevel()) {
            QLog.d("Q.qqhead.dih", 2, "createDisIcon: " + str + ", isNeedToDo=" + M);
        }
        if (M) {
            B(str);
        }
    }
}
