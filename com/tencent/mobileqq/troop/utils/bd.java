package com.tencent.mobileqq.troop.utils;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.ChatSettingFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.troop.TroopMemberNickInfo;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relationx.icebreaking.IceBreakingUtil;
import com.tencent.mobileqq.troop.org.pb.oidb_0x496$RobotSubscribeCategory;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.utils.ea;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import com.tencent.relation.common.nt.api.IRelationMsgService;
import com.tencent.robot.api.IRobotMMKVCleanApi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import mqq.util.LogUtil;

/* compiled from: P */
/* loaded from: classes19.dex */
public class bd implements Manager {
    static IPatchRedirector $redirector_;
    protected AppInterface C;
    protected String D;
    protected HashMap<Long, MessageForUniteGrayTip> E;
    protected boolean F;
    public String G;
    public String H;
    public String I;
    public String J;
    private HashMap<String, ArrayList<String>> K;
    private String L;
    private String M;
    private boolean N;
    private String P;
    private com.tencent.mobileqq.app.ar Q;
    private final com.tencent.mobileqq.friend.observer.a R;
    HashMap<String, Long> S;

    /* renamed from: d, reason: collision with root package name */
    protected List<String> f302106d;

    /* renamed from: e, reason: collision with root package name */
    protected List<String> f302107e;

    /* renamed from: f, reason: collision with root package name */
    protected List<String> f302108f;

    /* renamed from: h, reason: collision with root package name */
    List<oidb_0x496$RobotSubscribeCategory> f302109h;

    /* renamed from: i, reason: collision with root package name */
    protected int f302110i;

    /* renamed from: m, reason: collision with root package name */
    protected Handler f302111m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a extends com.tencent.mobileqq.app.ar {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) bd.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.ar
        public void onUpdateDelFriend(boolean z16, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), obj);
                return;
            }
            String str = "" + obj;
            if (((ITroopRobotService) bd.this.C.getRuntimeService(ITroopRobotService.class, "all")).isRobotUin(str) && z16) {
                QLog.d("TroopRobotManager", 1, "onUpdateDelFriend del robot:" + LogUtil.getSafePrintUin(str));
                bd.this.n(str);
                AppInterface appInterface = bd.this.C;
                if (appInterface instanceof QQAppInterface) {
                    QQAppInterface qQAppInterface = (QQAppInterface) appInterface;
                    ((FriendsManager) appInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).l(str);
                    IceBreakingUtil.z(qQAppInterface, str);
                    com.tencent.mobileqq.tofumsg.m.c(qQAppInterface, str);
                    bd.this.g(str);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class b extends com.tencent.mobileqq.friend.observer.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) bd.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.friend.observer.a
        public void onUpdateAddFriend(boolean z16, boolean z17, boolean z18, String str, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), str, bundle);
            } else if (((ITroopRobotService) bd.this.C.getRuntimeService(ITroopRobotService.class, "all")).isRobotUin(str) && z16) {
                bd.this.n(str);
            }
        }
    }

    public bd(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
            return;
        }
        this.f302106d = new ArrayList(5);
        this.f302107e = new ArrayList(5);
        this.f302108f = new ArrayList(5);
        this.f302109h = new ArrayList();
        this.f302110i = 60000;
        this.f302111m = new Handler(Looper.getMainLooper());
        this.D = null;
        this.E = new HashMap<>();
        this.F = false;
        this.G = null;
        this.H = null;
        this.I = null;
        this.J = null;
        this.K = new HashMap<>();
        this.L = "";
        this.M = "";
        this.N = false;
        this.P = null;
        b bVar = new b();
        this.R = bVar;
        this.S = new HashMap<>();
        this.C = appInterface;
        if (appInterface != null) {
        }
        h();
        AppInterface appInterface2 = this.C;
        if (appInterface2 != null) {
            appInterface2.addObserver(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(final String str) {
        ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.troop.utils.bb
            @Override // java.lang.Runnable
            public final void run() {
                bd.j(str);
            }
        }, 16, null, true, 500L);
        ((IRobotMMKVCleanApi) QRoute.api(IRobotMMKVCleanApi.class)).cleanRobotMMKV(str);
        MqqHandler handler = this.C.getHandler(ChatSettingFragment.class);
        if (handler != null) {
            handler.sendMessage(handler.obtainMessage(16711681, str));
        }
    }

    private void h() {
        AppInterface appInterface;
        if (this.Q == null && (appInterface = this.C) != null && (appInterface instanceof QQAppInterface)) {
            a aVar = new a();
            this.Q = aVar;
            this.C.addObserver(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void i(int i3, String str) {
        if (QLog.isColorLevel()) {
            QLog.i("TroopRobotManager", 2, "handleDelFriend deleteRecentContacts! result " + i3 + " errMsg " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void j(String str) {
        ((IRelationMsgService) QRoute.api(IRelationMsgService.class)).deleteRecentContacts(new com.tencent.relation.common.nt.data.a(str, 0, ""), new IOperateCallback() { // from class: com.tencent.mobileqq.troop.utils.bc
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str2) {
                bd.i(i3, str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit k(ChatMessage chatMessage, QQAppInterface qQAppInterface, Context context, SessionInfo sessionInfo, EditText editText, a61.c cVar, String str, TroopMemberNickInfo troopMemberNickInfo) {
        String str2;
        if (troopMemberNickInfo != null) {
            str2 = troopMemberNickInfo.getShowName();
        } else {
            str2 = chatMessage.senderuin;
        }
        SpannableString f16 = com.tencent.mobileqq.troop.text.a.f(qQAppInterface, context, sessionInfo.f179557e, chatMessage.senderuin, str2, false, editText, true, true);
        ArrayList<AtTroopMemberInfo> arrayList = new ArrayList<>();
        String c16 = com.tencent.mobileqq.troop.text.a.c(f16, arrayList);
        String extInfoFromExtStr = chatMessage.getExtInfoFromExtStr(ITroopRobotService.ROBOT_NEWS_CLASS_ID);
        try {
        } catch (Exception unused) {
        }
        try {
            m(cVar, c16 + " " + str, arrayList, Integer.parseInt(extInfoFromExtStr));
            new com.tencent.mobileqq.statistics.q(qQAppInterface).i("dc00899").a("Grp_robot").f("sub_page").d("next_msg_clk").b(chatMessage.frienduin, extInfoFromExtStr).g();
            return null;
        } catch (Exception unused2) {
            if (QLog.isColorLevel()) {
                QLog.e("TroopRobotManager", 2, "parse robotNewTipsClsId error");
                return null;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(String str) {
        QQAppInterface qQAppInterface;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        AppInterface appInterface = this.C;
        if (appInterface instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) appInterface;
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface == null) {
            return;
        }
        ea.k3(qQAppInterface.getApplication(), qQAppInterface.getCurrentUin(), str, false);
    }

    private void o() {
        AppInterface appInterface;
        com.tencent.mobileqq.app.ar arVar = this.Q;
        if (arVar != null && (appInterface = this.C) != null) {
            appInterface.removeObserver(arVar);
            this.Q = null;
        }
    }

    public void f(long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Long.valueOf(j3), Long.valueOf(j16));
            return;
        }
        MessageForUniteGrayTip remove = this.E.remove(Long.valueOf(j3));
        if (remove != null) {
            remove.shmsgseq = j16;
            com.tencent.mobileqq.graytip.f.a((QQAppInterface) this.C, remove);
        }
    }

    public void l(final Context context, final a61.c cVar, final QQAppInterface qQAppInterface, final EditText editText, final SessionInfo sessionInfo, final ChatMessage chatMessage, final String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, context, cVar, qQAppInterface, editText, sessionInfo, chatMessage, str);
        } else {
            ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberName(chatMessage.frienduin, chatMessage.senderuin, "TroopRobotManager", new Function1() { // from class: com.tencent.mobileqq.troop.utils.ba
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit k3;
                    k3 = bd.this.k(chatMessage, qQAppInterface, context, sessionInfo, editText, cVar, str, (TroopMemberNickInfo) obj);
                    return k3;
                }
            });
        }
    }

    public void m(a61.c cVar, String str, ArrayList<AtTroopMemberInfo> arrayList, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, cVar, str, arrayList, Integer.valueOf(i3));
        }
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopRobotManager", 2, "TroopRobotManager: onDestroy");
        }
        o();
        AppInterface appInterface = this.C;
        if (appInterface != null) {
            appInterface.removeObserver(this.R);
        }
    }
}
