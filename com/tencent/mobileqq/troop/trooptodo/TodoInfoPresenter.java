package com.tencent.mobileqq.troop.trooptodo;

import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.trooptodo.handler.TroopTodoInfoHandler;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.GroupExt;
import com.tencent.qqnt.troop.TroopListRepo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import tencent.im.oidb.cmd0xf8e.oidb_0xf8e$InfoValue;
import tencent.im.oidb.cmd0xf8e.oidb_0xf8e$UserNode;

/* loaded from: classes19.dex */
public class TodoInfoPresenter {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name */
    private static volatile TodoInfoPresenter f301742i;

    /* renamed from: a, reason: collision with root package name */
    private ut2.b f301743a;

    /* renamed from: b, reason: collision with root package name */
    private final Map<Long, oidb_0xf8e$UserNode> f301744b;

    /* renamed from: c, reason: collision with root package name */
    private final Map<Long, oidb_0xf8e$InfoValue> f301745c;

    /* renamed from: d, reason: collision with root package name */
    private c f301746d;

    /* renamed from: e, reason: collision with root package name */
    private long f301747e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f301748f;

    /* renamed from: g, reason: collision with root package name */
    private final l f301749g;

    /* renamed from: h, reason: collision with root package name */
    private final com.tencent.mobileqq.troop.api.observer.e f301750h;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes19.dex */
    public static final class ErrorType {
        private static final /* synthetic */ ErrorType[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final ErrorType ERROR_CACHE_ERROR;
        public static final ErrorType ERROR_NEW_GROUP_USER;
        public static final ErrorType ERROR_NOT_IN_AIO;
        public static final ErrorType ERROR_NO_TODO_INFO;
        public static final ErrorType ERROR_RSP_TODO_INFO_DETAIL;
        public static final ErrorType ERROR_RSP_TODO_INFO_LIST;
        public static final ErrorType ERROR_TODO_STATUS_CLOSE;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65100);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            ErrorType errorType = new ErrorType("ERROR_NOT_IN_AIO", 0);
            ERROR_NOT_IN_AIO = errorType;
            ErrorType errorType2 = new ErrorType("ERROR_NEW_GROUP_USER", 1);
            ERROR_NEW_GROUP_USER = errorType2;
            ErrorType errorType3 = new ErrorType("ERROR_NO_TODO_INFO", 2);
            ERROR_NO_TODO_INFO = errorType3;
            ErrorType errorType4 = new ErrorType("ERROR_TODO_STATUS_CLOSE", 3);
            ERROR_TODO_STATUS_CLOSE = errorType4;
            ErrorType errorType5 = new ErrorType("ERROR_CACHE_ERROR", 4);
            ERROR_CACHE_ERROR = errorType5;
            ErrorType errorType6 = new ErrorType("ERROR_RSP_TODO_INFO_LIST", 5);
            ERROR_RSP_TODO_INFO_LIST = errorType6;
            ErrorType errorType7 = new ErrorType("ERROR_RSP_TODO_INFO_DETAIL", 6);
            ERROR_RSP_TODO_INFO_DETAIL = errorType7;
            $VALUES = new ErrorType[]{errorType, errorType2, errorType3, errorType4, errorType5, errorType6, errorType7};
        }

        ErrorType(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static ErrorType valueOf(String str) {
            return (ErrorType) Enum.valueOf(ErrorType.class, str);
        }

        public static ErrorType[] values() {
            return (ErrorType[]) $VALUES.clone();
        }
    }

    /* loaded from: classes19.dex */
    class a extends l {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TodoInfoPresenter.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.trooptodo.l
        public void a(int i3, oidb_0xf8e$InfoValue oidb_0xf8e_infovalue, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                TodoInfoPresenter.this.p(i3, oidb_0xf8e_infovalue, i16, i17);
            } else {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), oidb_0xf8e_infovalue, Integer.valueOf(i16), Integer.valueOf(i17));
            }
        }

        @Override // com.tencent.mobileqq.troop.trooptodo.l
        public void b(int i3, List<oidb_0xf8e$UserNode> list, int i16, int i17, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                TodoInfoPresenter.this.q(i3, list, i16, i17, j3);
            } else {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), list, Integer.valueOf(i16), Integer.valueOf(i17), Long.valueOf(j3));
            }
        }
    }

    /* loaded from: classes19.dex */
    class b extends com.tencent.mobileqq.troop.api.observer.e {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TodoInfoPresenter.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.api.observer.e
        protected void onGetTroopInfoExtComplete(boolean z16, String str, GroupExt groupExt) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                TodoInfoPresenter.this.r(z16, str, groupExt);
            } else {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str, groupExt);
            }
        }
    }

    /* loaded from: classes19.dex */
    public interface c {
        void a(d dVar);

        void b(ErrorType errorType);
    }

    TodoInfoPresenter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        this.f301743a = null;
        this.f301744b = new ConcurrentHashMap();
        this.f301745c = new ConcurrentHashMap();
        this.f301746d = null;
        this.f301747e = 0L;
        this.f301748f = false;
        this.f301749g = new a();
        this.f301750h = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A(oidb_0xf8e$InfoValue oidb_0xf8e_infovalue) {
        c cVar = this.f301746d;
        if (cVar != null) {
            cVar.a(d.a(oidb_0xf8e_infovalue, 4));
        }
    }

    private boolean B(long j3) {
        if (l(j3) == null) {
            return true;
        }
        return false;
    }

    private void C(long j3, long j16) {
        if (j16 == 0) {
            O(j3);
            return;
        }
        if (x()) {
            K(j3, 2);
            return;
        }
        if (B(j3)) {
            K(j3, 2);
            return;
        }
        oidb_0xf8e$UserNode l3 = l(j3);
        if (l3 != null && j16 != l3.seq.get()) {
            h(j3);
            K(j3, 2);
        } else {
            if (n(j3) == 2) {
                N(ErrorType.ERROR_TODO_STATUS_CLOSE);
                return;
            }
            oidb_0xf8e$InfoValue k3 = k(j3);
            if (k3 != null) {
                M(k3);
            } else {
                N(ErrorType.ERROR_CACHE_ERROR);
            }
        }
    }

    private void D(List<oidb_0xf8e$UserNode> list) {
        Iterator<oidb_0xf8e$UserNode> it = list.iterator();
        while (it.hasNext()) {
            F(it.next());
        }
    }

    private void E(oidb_0xf8e$InfoValue oidb_0xf8e_infovalue, int i3) {
        oidb_0xf8e$UserNode oidb_0xf8e_usernode = new oidb_0xf8e$UserNode();
        oidb_0xf8e_usernode.group_code.set(oidb_0xf8e_infovalue.group_code.get());
        oidb_0xf8e_usernode.seq.set(oidb_0xf8e_infovalue.seq.get());
        oidb_0xf8e_usernode.status.set(i3);
        F(oidb_0xf8e_usernode);
    }

    private void F(oidb_0xf8e$UserNode oidb_0xf8e_usernode) {
        this.f301744b.put(Long.valueOf(oidb_0xf8e_usernode.group_code.get()), oidb_0xf8e_usernode);
    }

    private void J(long j3, int i3) {
        ut2.b bVar = this.f301743a;
        if (bVar != null) {
            bVar.D1(Long.valueOf(j3), i3);
        }
    }

    private void K(long j3, int i3) {
        ut2.b bVar;
        if ((!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("105902", true) || !this.f301748f || System.currentTimeMillis() - this.f301747e >= 30000) && (bVar = this.f301743a) != null) {
            bVar.K0(Long.valueOf(j3), i3);
            this.f301748f = true;
            this.f301747e = System.currentTimeMillis();
        }
    }

    private void L(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            ThreadManagerV2.getUIHandlerV2().post(runnable);
        }
    }

    private void M(final oidb_0xf8e$InfoValue oidb_0xf8e_infovalue) {
        TroopInfo o16 = o(String.valueOf(oidb_0xf8e_infovalue.group_code.get()));
        if (o16 != null && o16.dwCmdUinJoinTime > oidb_0xf8e_infovalue.create_time.get()) {
            E(oidb_0xf8e_infovalue, 100);
            N(ErrorType.ERROR_NEW_GROUP_USER);
        } else {
            final int n3 = n(oidb_0xf8e_infovalue.group_code.get());
            E(oidb_0xf8e_infovalue, n3);
            L(new Runnable() { // from class: com.tencent.mobileqq.troop.trooptodo.b
                @Override // java.lang.Runnable
                public final void run() {
                    TodoInfoPresenter.this.z(oidb_0xf8e_infovalue, n3);
                }
            });
        }
    }

    private void N(ErrorType errorType) {
        c cVar = this.f301746d;
        if (cVar != null) {
            cVar.b(errorType);
        }
    }

    private void O(long j3) {
        final oidb_0xf8e$InfoValue k3 = k(j3);
        if (k3 == null) {
            return;
        }
        h(j3);
        L(new Runnable() { // from class: com.tencent.mobileqq.troop.trooptodo.c
            @Override // java.lang.Runnable
            public final void run() {
                TodoInfoPresenter.this.A(k3);
            }
        });
    }

    private boolean g(long j3) {
        if (w() || !s(j3)) {
            return true;
        }
        return false;
    }

    private void h(long j3) {
        this.f301744b.remove(Long.valueOf(j3));
        this.f301745c.remove(Long.valueOf(j3));
    }

    private void i(List<oidb_0xf8e$UserNode> list) {
        ArrayList arrayList = new ArrayList();
        for (Long l3 : this.f301744b.keySet()) {
            if (t(l3.longValue(), list)) {
                arrayList.add(l3);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Long l16 : this.f301745c.keySet()) {
            if (t(l16.longValue(), list)) {
                arrayList2.add(l16);
            }
        }
        try {
            Iterator<Long> it = this.f301744b.keySet().iterator();
            while (it.hasNext()) {
                if (arrayList.contains(it.next())) {
                    it.remove();
                }
            }
            Iterator<Long> it5 = this.f301745c.keySet().iterator();
            while (it5.hasNext()) {
                if (arrayList2.contains(it5.next())) {
                    it5.remove();
                }
            }
        } catch (Exception e16) {
            QLog.e("TodoInfoPresenter-TodoInfo", 1, "correctionTodoInfoCache error", e16);
        }
    }

    private oidb_0xf8e$InfoValue k(long j3) {
        return this.f301745c.get(Long.valueOf(j3));
    }

    private oidb_0xf8e$UserNode l(long j3) {
        return this.f301744b.get(Long.valueOf(j3));
    }

    public static TodoInfoPresenter m() {
        if (f301742i == null) {
            synchronized (TodoInfoPresenter.class) {
                if (f301742i == null) {
                    f301742i = new TodoInfoPresenter();
                }
            }
        }
        return f301742i;
    }

    private int n(long j3) {
        oidb_0xf8e$UserNode l3 = l(j3);
        if (l3 != null) {
            return l3.status.get();
        }
        return 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(int i3, oidb_0xf8e$InfoValue oidb_0xf8e_infovalue, int i16, int i17) {
        if (i3 == 0 && oidb_0xf8e_infovalue != null) {
            this.f301745c.put(Long.valueOf(oidb_0xf8e_infovalue.group_code.get()), oidb_0xf8e_infovalue);
            M(oidb_0xf8e_infovalue);
        } else {
            N(ErrorType.ERROR_RSP_TODO_INFO_DETAIL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(int i3, List<oidb_0xf8e$UserNode> list, int i16, int i17, long j3) {
        if (i3 == 0 && list != null && list.size() > 0) {
            i(list);
            D(list);
        } else {
            h(j3);
        }
        if (i17 != 4) {
            if (!u(j3)) {
                J(j3, i17);
            } else {
                h(j3);
            }
        }
        this.f301748f = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(boolean z16, String str, GroupExt groupExt) {
        GroupExt groupExt2;
        int i3;
        if (z16 && !TextUtils.isEmpty(str)) {
            TroopInfo o16 = o(str);
            if (o16 != null && (groupExt2 = o16.groupExt) != null) {
                if (groupExt != null) {
                    i3 = groupExt.todoSeq;
                } else {
                    i3 = -1;
                }
                int i16 = groupExt2.todoSeq;
                if (i16 != i3 || i16 == 0) {
                    C(Long.parseLong(str), i16);
                    return;
                }
                return;
            }
            if (o16 == null) {
                QLog.e("TodoInfoPresenter-TodoInfo", 1, "[handleTodoInfoPushRsp] 0xef0, troopInfo is null! " + str);
                return;
            }
            QLog.e("TodoInfoPresenter-TodoInfo", 1, "[handleTodoInfoPushRsp] 0xef0, troopInfo.groupExt null! " + str + ", troopInfo hashCode: " + o16.hashCode());
        }
    }

    private boolean s(long j3) {
        return this.f301745c.containsKey(Long.valueOf(j3));
    }

    private boolean t(long j3, List<oidb_0xf8e$UserNode> list) {
        Iterator<oidb_0xf8e$UserNode> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().group_code.get() == j3) {
                return false;
            }
        }
        return true;
    }

    private boolean u(long j3) {
        oidb_0xf8e$UserNode l3 = l(j3);
        if (l3 != null && l3.seq.get() == 0) {
            return true;
        }
        return false;
    }

    private boolean w() {
        return this.f301745c.isEmpty();
    }

    private boolean x() {
        return this.f301744b.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z(oidb_0xf8e$InfoValue oidb_0xf8e_infovalue, int i3) {
        c cVar = this.f301746d;
        if (cVar != null) {
            cVar.a(d.a(oidb_0xf8e_infovalue, i3));
        }
    }

    public void G(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, j3);
        } else {
            K(j3, 4);
        }
    }

    public void H(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, j3);
            return;
        }
        if (!v(String.valueOf(j3))) {
            QLog.i("TodoInfoPresenter-TodoInfo", 2, "[requestByEnterGroup] no todo seq exist, return");
            return;
        }
        if (x()) {
            QLog.i("TodoInfoPresenter-TodoInfo", 2, "[requestByEnterGroup] empty TodoInfoListCache, start requestTodoInfoList");
            K(j3, 1);
            return;
        }
        if (B(j3)) {
            if (QLog.isColorLevel()) {
                QLog.i("TodoInfoPresenter-TodoInfo", 2, "[requestByEnterGroup] not hit TodoInfoListCache, start requestTodoInfoList");
            }
            K(j3, 1);
            return;
        }
        if (n(j3) == 2) {
            QLog.w("TodoInfoPresenter-TodoInfo", 1, "[requestByEnterGroup] todo status is close, return.");
            N(ErrorType.ERROR_TODO_STATUS_CLOSE);
            return;
        }
        if (n(j3) == 100) {
            QLog.w("TodoInfoPresenter-TodoInfo", 1, "[requestByEnterGroup] todo status is new user, return");
            N(ErrorType.ERROR_NEW_GROUP_USER);
        } else {
            if (g(j3)) {
                J(j3, 1);
                return;
            }
            oidb_0xf8e$InfoValue k3 = k(j3);
            if (k3 != null) {
                M(k3);
            } else {
                N(ErrorType.ERROR_CACHE_ERROR);
            }
        }
    }

    public void I(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, j3);
        } else {
            K(j3, 2);
        }
    }

    public void f(@NonNull AppInterface appInterface, c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface, (Object) cVar);
            return;
        }
        appInterface.addObserver(this.f301749g);
        appInterface.addObserver(this.f301750h);
        this.f301746d = cVar;
        this.f301743a = (ut2.b) appInterface.getBusinessHandler(TroopTodoInfoHandler.class.getName());
    }

    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.f301743a = null;
            this.f301746d = null;
        }
    }

    protected TroopInfo o(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (TroopInfo) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        }
        return TroopListRepo.INSTANCE.getTroopInfoFromCache(str);
    }

    protected boolean v(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str)).booleanValue();
        }
        TroopInfo o16 = o(str);
        if (o16 != null) {
            if (o16.isExited()) {
                return false;
            }
            GroupExt groupExt = o16.groupExt;
            if (groupExt != null && groupExt.todoSeq == 0) {
                return false;
            }
            return true;
        }
        QLog.i("TodoInfoPresenter-TodoInfo", 2, "[isTodoExist] troopInfo=null");
        return false;
    }

    public boolean y(long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, Long.valueOf(j3), Long.valueOf(j16))).booleanValue();
        }
        if (x()) {
            return false;
        }
        oidb_0xf8e$UserNode l3 = l(j3);
        if (l3 != null && l3.seq.get() == j16) {
            return true;
        }
        return false;
    }
}
