package com.tencent.mobileqq.qqexpand.ipc;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.matchchat.MatchChatMsgUtil;
import com.tencent.mobileqq.mini.appbrand.jsapi.PluginConst;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.qqexpand.bean.common.GenericSerializable;
import com.tencent.mobileqq.qqexpand.chat.utils.ExpandChatUtil;
import com.tencent.mobileqq.qqexpand.chat.utils.LimitChatUtil;
import com.tencent.mobileqq.qqexpand.flutter.channel.chat.ExtendFriendInfo;
import com.tencent.mobileqq.qqexpand.ipc.b;
import com.tencent.mobileqq.qqexpand.manager.ExpandManager;
import com.tencent.mobileqq.qqexpand.network.ExpandObserver;
import com.tencent.mobileqq.qqexpand.plugin.entrance.ExpandPluginLauncher;
import com.tencent.mobileqq.qqexpand.utils.CampusHelper;
import com.tencent.mobileqq.relationx.icebreaking.IceBreakingMng;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;

/* loaded from: classes35.dex */
public class ExpandFlutterIPCServer extends QIPCModule {

    /* renamed from: h, reason: collision with root package name */
    private static volatile ExpandFlutterIPCServer f263821h;

    /* renamed from: d, reason: collision with root package name */
    final com.tencent.mobileqq.qqexpand.ipc.b f263822d;

    /* renamed from: e, reason: collision with root package name */
    private final ExpandObserver f263823e;

    /* renamed from: f, reason: collision with root package name */
    private String f263824f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes35.dex */
    public class a implements b.a {
        a() {
        }

        @Override // com.tencent.mobileqq.qqexpand.ipc.b.a
        public Bundle a(String str, Bundle bundle, int i3) {
            return ExpandFlutterIPCServer.this.N(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes35.dex */
    public class b implements b.a {
        b() {
        }

        @Override // com.tencent.mobileqq.qqexpand.ipc.b.a
        public Bundle a(String str, Bundle bundle, int i3) {
            return ExpandFlutterIPCServer.this.A(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes35.dex */
    public class c implements b.a {
        c() {
        }

        @Override // com.tencent.mobileqq.qqexpand.ipc.b.a
        public Bundle a(String str, Bundle bundle, int i3) {
            return ExpandFlutterIPCServer.this.H();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes35.dex */
    public class d implements b.a {
        d() {
        }

        @Override // com.tencent.mobileqq.qqexpand.ipc.b.a
        public Bundle a(String str, Bundle bundle, int i3) {
            return ExpandFlutterIPCServer.this.O(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes35.dex */
    public class e implements b.a {
        e() {
        }

        @Override // com.tencent.mobileqq.qqexpand.ipc.b.a
        public Bundle a(String str, Bundle bundle, int i3) {
            return ExpandFlutterIPCServer.this.P();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes35.dex */
    public class f implements b.a {
        f() {
        }

        @Override // com.tencent.mobileqq.qqexpand.ipc.b.a
        public Bundle a(String str, Bundle bundle, int i3) {
            return ExpandFlutterIPCServer.this.I();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes35.dex */
    public class g implements b.a {
        g() {
        }

        @Override // com.tencent.mobileqq.qqexpand.ipc.b.a
        public Bundle a(String str, Bundle bundle, int i3) {
            return ExpandFlutterIPCServer.this.C(bundle, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes35.dex */
    public class h implements b.a {
        h() {
        }

        @Override // com.tencent.mobileqq.qqexpand.ipc.b.a
        public Bundle a(String str, Bundle bundle, int i3) {
            return ExpandFlutterIPCServer.this.G();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes35.dex */
    public class i implements b.a {
        i() {
        }

        @Override // com.tencent.mobileqq.qqexpand.ipc.b.a
        public Bundle a(String str, Bundle bundle, int i3) {
            return ExpandFlutterIPCServer.this.M(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes35.dex */
    public class j implements b.a {
        j() {
        }

        @Override // com.tencent.mobileqq.qqexpand.ipc.b.a
        public Bundle a(String str, Bundle bundle, int i3) {
            return ExpandFlutterIPCServer.this.D();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes35.dex */
    public class k implements b.a {
        k() {
        }

        @Override // com.tencent.mobileqq.qqexpand.ipc.b.a
        public Bundle a(String str, Bundle bundle, int i3) {
            return ExpandFlutterIPCServer.this.Q(bundle, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes35.dex */
    public class l implements b.a {
        l() {
        }

        @Override // com.tencent.mobileqq.qqexpand.ipc.b.a
        public Bundle a(String str, Bundle bundle, int i3) {
            return ExpandFlutterIPCServer.this.L(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes35.dex */
    public class m implements b.a {
        m() {
        }

        @Override // com.tencent.mobileqq.qqexpand.ipc.b.a
        public Bundle a(String str, Bundle bundle, int i3) {
            return ExpandFlutterIPCServer.this.F();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes35.dex */
    public class n extends BroadcastReceiver {
        n() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            ExpandFlutterIPCServer.this.f263824f = "";
        }
    }

    /* loaded from: classes35.dex */
    class o implements b.a {
        o() {
        }

        @Override // com.tencent.mobileqq.qqexpand.ipc.b.a
        public Bundle a(String str, Bundle bundle, int i3) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes35.dex */
    public class p extends ExpandObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f263845d;

        p(int i3) {
            this.f263845d = i3;
        }

        @Override // com.tencent.mobileqq.qqexpand.network.ExpandObserver
        protected void q(boolean z16, Object obj, int i3) {
            if (QLog.isColorLevel()) {
                QLog.d("expand.ipc.ExpandFlutterIPCServer", 2, "[getExpandUserInfo] onPreLoadDataForAvatarProfileCard. isSuccess = ", Boolean.valueOf(z16), " data = ", obj, " type = ", Integer.valueOf(i3));
            }
            Bundle bundle = new Bundle();
            if (obj != null) {
                bundle.putString("data", obj.toString());
            }
            EIPCResult eIPCResult = new EIPCResult();
            eIPCResult.data = bundle;
            eIPCResult.code = z16 ? 0 : -102;
            ExpandFlutterIPCServer.this.callbackResult(this.f263845d, eIPCResult);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes35.dex */
    public class s implements b.a {
        s() {
        }

        @Override // com.tencent.mobileqq.qqexpand.ipc.b.a
        public Bundle a(String str, Bundle bundle, int i3) {
            return ExpandFlutterIPCServer.this.K();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes35.dex */
    public class t implements b.a {
        t() {
        }

        @Override // com.tencent.mobileqq.qqexpand.ipc.b.a
        public Bundle a(String str, Bundle bundle, int i3) {
            return ExpandFlutterIPCServer.this.J();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes35.dex */
    public class u implements b.a {
        u() {
        }

        @Override // com.tencent.mobileqq.qqexpand.ipc.b.a
        public Bundle a(String str, Bundle bundle, int i3) {
            return ExpandFlutterIPCServer.this.E(bundle, i3);
        }
    }

    ExpandFlutterIPCServer() {
        super("ExpandFlutterIPCServer");
        ExpandObserver expandObserver = new ExpandObserver() { // from class: com.tencent.mobileqq.qqexpand.ipc.ExpandFlutterIPCServer.1
            @Override // com.tencent.mobileqq.qqexpand.network.ExpandObserver
            protected void B(final int i3) {
                if (QLog.isColorLevel()) {
                    QLog.e("expand.ipc.ExpandFlutterIPCServer", 2, "onUpdateRedPoint " + i3);
                }
                ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.qqexpand.ipc.ExpandFlutterIPCServer.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ExpandFlutterIPCServer.this.T(i3);
                    }
                });
            }
        };
        this.f263823e = expandObserver;
        this.f263824f = "";
        this.f263822d = new com.tencent.mobileqq.qqexpand.ipc.b(this, new o());
        R();
        W();
        AppRuntime w3 = w();
        if (w3 instanceof QQAppInterface) {
            ((QQAppInterface) w3).addObserver(expandObserver);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bundle A(int i3) {
        Card q16 = ((FriendsManager) ExpandManager.q0().getManager(QQManagerFactory.FRIENDS_MANAGER)).q(ExpandManager.q0().getCurrentAccountUin());
        ExtendFriendInfo extendFriendInfo = new ExtendFriendInfo();
        extendFriendInfo.nickName = q16.strNick;
        extendFriendInfo.declaration = q16.declaration;
        extendFriendInfo.voiceUrl = q16.voiceUrl;
        Bundle bundle = new Bundle();
        com.tencent.mobileqq.qqexpand.network.e eVar = (com.tencent.mobileqq.qqexpand.network.e) ExpandManager.q0().getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER);
        if (eVar != null) {
            bundle.putInt(TroopAvatarWallPreviewActivity.KEY_SEQ_NUM, eVar.l1(ExpandManager.q0().getCurrentAccountUin(), false));
        }
        bundle.putString("data", new Gson().toJson(extendFriendInfo));
        EIPCResult eIPCResult = new EIPCResult();
        eIPCResult.data = bundle;
        callbackResult(i3, eIPCResult);
        return null;
    }

    private EIPCResult B(AppInterface appInterface) {
        Bundle bundle = new Bundle();
        bundle.putInt("redPointNum", MatchChatMsgUtil.d((QQAppInterface) appInterface));
        return EIPCResult.createSuccessResult(bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bundle C(final Bundle bundle, final int i3) {
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.qqexpand.ipc.ExpandFlutterIPCServer.6
            @Override // java.lang.Runnable
            public void run() {
                ArrayList<String> stringArrayList = bundle.getStringArrayList("data");
                if (stringArrayList != null && !stringArrayList.isEmpty()) {
                    String json = new Gson().toJson(new HashMap(com.tencent.mobileqq.qqexpand.flutter.channel.chat.b.b(stringArrayList)));
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("data", json);
                    if (QLog.isColorLevel()) {
                        QLog.d("expand.ipc.ExpandFlutterIPCServer", 1, "get sys emoj file path " + json);
                    }
                    EIPCResult eIPCResult = new EIPCResult();
                    eIPCResult.data = bundle2;
                    ExpandFlutterIPCServer.this.callbackResult(i3, eIPCResult);
                    return;
                }
                QLog.w("expand.ipc.ExpandFlutterIPCServer", 1, "METHOD_GET_SYS_EMOJI_FILE_PATHparams error");
                EIPCResult eIPCResult2 = new EIPCResult();
                Bundle bundle3 = new Bundle();
                bundle3.putString("data", "");
                eIPCResult2.data = bundle3;
                ExpandFlutterIPCServer.this.callbackResult(i3, eIPCResult2);
            }
        });
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bundle D() {
        String account = BaseApplicationImpl.getApplication().getRuntime().getAccount();
        if (!TextUtils.isEmpty(account) && TextUtils.isEmpty(this.f263824f)) {
            this.f263824f = com.tencent.mobileqq.qqexpand.utils.f.b(account);
        }
        Bundle bundle = new Bundle();
        bundle.putString("data", this.f263824f);
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bundle F() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qqexpand.ipc.ExpandFlutterIPCServer.24
            @Override // java.lang.Runnable
            public void run() {
                AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
                if (runtime instanceof QQAppInterface) {
                    QQAppInterface qQAppInterface = (QQAppInterface) runtime;
                    if (qQAppInterface == null) {
                        QLog.i("expand.ipc.ExpandFlutterIPCServer", 2, "handleClearAllMsgs app is null!");
                        return;
                    }
                    ReportController.o(qQAppInterface, "dc00898", "", "", "0X800A699", "0X800A699", 0, 0, "", "", "", "");
                    com.tencent.mobileqq.qqexpand.utils.d.e("click#message_setting_page#delete_all_message", true, -1L, -1L, null, true, true);
                    MatchChatMsgUtil.a(qQAppInterface);
                    ExpandChatUtil.i(qQAppInterface);
                    ((ExpandManager) qQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).U();
                    ((com.tencent.mobileqq.qqexpand.manager.c) qQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_LIMIT_CHAT_MANAGER)).a();
                    ((IceBreakingMng) qQAppInterface.getManager(QQManagerFactory.ICE_BREAKING_MNG)).P();
                }
            }
        }, 80, null, true);
        Bundle bundle = new Bundle();
        bundle.putString("data", "");
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bundle G() {
        Bundle bundle = new Bundle();
        bundle.putString("ret", "{}");
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bundle H() {
        Bundle bundle = new Bundle();
        bundle.putLong("birthdate", ((FriendsManager) ExpandManager.q0().getManager(QQManagerFactory.FRIENDS_MANAGER)).q(ExpandManager.q0().getCurrentAccountUin()).lBirthday);
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bundle I() {
        Bundle bundle = new Bundle();
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        bundle.putBoolean("showflag", runtime instanceof QQAppInterface ? CampusHelper.c((QQAppInterface) runtime) : false);
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bundle J() {
        return new Bundle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bundle K() {
        String D0 = ((ExpandManager) w().getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).D0();
        if (QLog.isColorLevel()) {
            QLog.d("expand.ipc.ExpandFlutterIPCServer", 2, String.format("getUnzipValidResourcePath=%s", D0));
        }
        Bundle bundle = new Bundle();
        bundle.putString("ret", D0);
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bundle L(int i3) {
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (!(runtime instanceof QQAppInterface)) {
            return null;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) runtime;
        boolean d16 = ((com.tencent.mobileqq.qqexpand.manager.c) qQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_LIMIT_CHAT_MANAGER)).d(qQAppInterface);
        Bundle bundle = new Bundle();
        bundle.putBoolean("data", d16);
        EIPCResult eIPCResult = new EIPCResult();
        eIPCResult.data = bundle;
        if (QLog.isColorLevel()) {
            QLog.i("expand.ipc.ExpandFlutterIPCServer", 2, "handleGetQuietMode open:" + d16 + ", result: " + eIPCResult);
        }
        callbackResult(i3, eIPCResult);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bundle M(int i3) {
        return new Bundle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bundle N(Bundle bundle) {
        return new Bundle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bundle O(Bundle bundle) {
        CardHandler cardHandler;
        Bundle bundle2 = new Bundle();
        if (bundle == null) {
            QLog.w("expand.ipc.ExpandFlutterIPCServer", 1, "handleMessage params is null METHOD_SET_BIRTH_DATE");
            return null;
        }
        int i3 = bundle.getInt("birthdate");
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if ((runtime instanceof QQAppInterface) && (cardHandler = (CardHandler) ((QQAppInterface) runtime).getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)) != null && i3 != 0) {
            Bundle bundle3 = new Bundle();
            bundle3.putInt("birthday", i3);
            cardHandler.g5(bundle3);
        }
        return bundle2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bundle P() {
        Bundle bundle = new Bundle();
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime instanceof QQAppInterface) {
            CampusHelper.g((QQAppInterface) runtime);
        }
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bundle Q(Bundle bundle, int i3) {
        return null;
    }

    private void R() {
        this.f263822d.b("METHOD_GET_FLUTTER_RESOURCE_PATH", new s());
        this.f263822d.b("METHOD_GET_EXPAND_CONFIG", new t());
        this.f263822d.b("METHOD_CHAT_GET_CONVERSATION_LIST", new u());
        this.f263822d.b("METHOD_CHAT_REMOVE_CONVERSATION", new a());
        this.f263822d.b("METHOD_REFRESH_EXTEND_FRIEND_INFO", new b());
        this.f263822d.b("METHOD_GET_BIRTH_DATE", new c());
        this.f263822d.b("METHOD_SET_BIRTH_DATE", new d());
        this.f263822d.b("METHOD_SET_BIRTH_DIALOG_FLAG", new e());
        this.f263822d.b("METHOD_GET_BIRTH_DIALOG_FLAG", new f());
        this.f263822d.b("METHOD_GET_SYS_EMOJI_FILE_PATH", new g());
        this.f263822d.b("METHOD_GET_EXPAND_FRIEND_BANNER_CONFIG_LIST", new h());
        this.f263822d.b("METHOD_GET_SECURITY_INFO", new i());
        this.f263822d.b("METHOD_GET_ABTEST_INFO", new j());
        this.f263822d.b("METHOD_SET_QUIET_MODE", new k());
        this.f263822d.b("METHOD_GET_QUIET_MODE", new l());
        this.f263822d.b("METHOD_CLEAR_ALL_MSGS", new m());
    }

    private void S(AppInterface appInterface, String str, byte[] bArr) {
        com.tencent.mobileqq.qqexpand.manager.c cVar = (com.tencent.mobileqq.qqexpand.manager.c) appInterface.getManager(QQManagerFactory.EXTEND_FRIEND_LIMIT_CHAT_MANAGER);
        if (cVar == null) {
            QLog.w("expand.ipc.ExpandFlutterIPCServer", 1, "limitChatManager is null ");
        } else {
            LimitChatUtil.X((QQAppInterface) appInterface, Long.valueOf(Long.parseLong(str)), new r(appInterface, str));
            cVar.y(str, appInterface.getCurrentAccountUin(), bArr);
        }
    }

    private EIPCResult U(AppInterface appInterface, Bundle bundle) {
        String string = bundle.getString("match_uin");
        int i3 = bundle.getInt("match_type");
        int i16 = bundle.getInt("from_page");
        int i17 = bundle.getInt("accost_type");
        int i18 = bundle.getInt("is_passive");
        int i19 = bundle.getInt("choose_condition");
        int i26 = bundle.getInt("dating_purpose");
        int i27 = bundle.getInt("matchRelationSource");
        byte[] byteArray = bundle.getByteArray(PreloadTRTCPlayerParams.KEY_SIG);
        Bundle bundle2 = new Bundle();
        if (i16 == 6) {
            LimitChatUtil.q((QQAppInterface) appInterface, string, i17, i26);
            return EIPCResult.createSuccessResult(bundle2);
        }
        ((com.tencent.mobileqq.qqexpand.manager.c) appInterface.getManager(QQManagerFactory.EXTEND_FRIEND_LIMIT_CHAT_MANAGER)).y(string, appInterface.getCurrentAccountUin(), byteArray);
        LimitChatUtil.p((QQAppInterface) appInterface, string, i16, i3, i18, i17, i19, i26, i27);
        return EIPCResult.createSuccessResult(bundle2);
    }

    private void V(QQAppInterface qQAppInterface, Bundle bundle) {
        String string = bundle.getString("data");
        if (TextUtils.isEmpty(string)) {
            QLog.e("expand.ipc.ExpandFlutterIPCServer", 1, "openSchema error, schema is null!");
            return;
        }
        ax c16 = bi.c(qQAppInterface, BaseApplication.getContext(), string);
        if (c16 == null) {
            QLog.e("expand.ipc.ExpandFlutterIPCServer", 1, "openSchema error, action is null! schema = ", string);
        } else {
            c16.b();
        }
    }

    private void W() {
        if (BaseApplication.getContext() == null || BaseApplication.getContext().getContentResolver() == null) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(NewIntent.ACTION_ACCOUNT_KICKED);
        intentFilter.addAction(NewIntent.ACTION_FORCE_LOGOUT);
        intentFilter.addAction(NewIntent.ACTION_ACCOUNT_CHANGED);
        intentFilter.addAction(NewIntent.ACTION_LOGOUT);
        MobileQQ.sMobileQQ.registerReceiver(new n(), intentFilter);
    }

    private EIPCResult X(QQAppInterface qQAppInterface, Bundle bundle) {
        String string = bundle.getString("plan");
        ((ExpandManager) qQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).K0(string);
        if (QLog.isColorLevel()) {
            QLog.d("expand.ipc.ExpandFlutterIPCServer", 2, "onCall ACTION_SET_TAB_TEST_PLAN ,plan = " + string);
        }
        return EIPCResult.createSuccessResult(new Bundle());
    }

    public static String getProcessName() {
        if (((ExpandManager) w().getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).H0()) {
            return "com.tencent.mobileqq:plugins";
        }
        return "com.tencent.mobileqq:tool";
    }

    private EIPCResult s(AppInterface appInterface, Bundle bundle) {
        String string = bundle.getString("matchInfoMap");
        if (((com.tencent.mobileqq.qqexpand.manager.c) appInterface.getManager(QQManagerFactory.EXTEND_FRIEND_LIMIT_CHAT_MANAGER)) != null && !TextUtils.isEmpty(string)) {
            try {
                JsonArray asJsonArray = new JsonParser().parse(string).getAsJsonArray();
                int size = asJsonArray.size();
                for (int i3 = 0; i3 < size; i3++) {
                    S(appInterface, asJsonArray.get(i3).getAsJsonObject().getAsJsonPrimitive("uin").getAsString(), asJsonArray.get(i3).getAsJsonObject().getAsJsonPrimitive(PreloadTRTCPlayerParams.KEY_SIG).getAsString().getBytes(StandardCharsets.ISO_8859_1));
                }
            } catch (Exception e16) {
                QLog.e("expand.ipc.ExpandFlutterIPCServer", 2, e16, "batchCreateMessageNode error!");
            }
            return EIPCResult.createSuccessResult(new Bundle());
        }
        return EIPCResult.createSuccessResult(new Bundle());
    }

    private EIPCResult t() {
        if (QLog.isColorLevel()) {
            QLog.i("expand.ipc.ExpandFlutterIPCServer", 2, "clearRedPoint() not implemented");
        }
        return EIPCResult.createSuccessResult(new Bundle());
    }

    private EIPCResult u(AppInterface appInterface, Bundle bundle) {
        String string = bundle.getString("match_uin");
        if (!TextUtils.isEmpty(string)) {
            LimitChatUtil.X((QQAppInterface) appInterface, Long.valueOf(Long.parseLong(string)), new q(appInterface, string));
        }
        return EIPCResult.createSuccessResult(new Bundle());
    }

    private EIPCResult v(QQAppInterface qQAppInterface, Bundle bundle) {
        String string = bundle.getString("event");
        GenericSerializable genericSerializable = (GenericSerializable) bundle.getSerializable("params");
        if (genericSerializable != null) {
            com.tencent.mobileqq.qqexpand.utils.d.f(string, true, (Map) genericSerializable.get());
        }
        return EIPCResult.createSuccessResult(new Bundle());
    }

    private static AppRuntime w() {
        return BaseApplicationImpl.getApplication().getRuntime();
    }

    private void x(QQAppInterface qQAppInterface, int i3) {
        LimitChatUtil.Y(qQAppInterface, Long.valueOf(qQAppInterface.getLongAccountUin()), new p(i3));
    }

    public static ExpandFlutterIPCServer y() {
        if (f263821h == null) {
            synchronized (ExpandFlutterIPCServer.class) {
                if (f263821h == null) {
                    f263821h = new ExpandFlutterIPCServer();
                }
            }
        }
        return f263821h;
    }

    private EIPCResult z(QQAppInterface qQAppInterface) {
        boolean d16 = ((com.tencent.mobileqq.qqexpand.manager.c) qQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_LIMIT_CHAT_MANAGER)).d(qQAppInterface);
        Bundle bundle = new Bundle();
        bundle.putBoolean("sp_match_switch_type", d16);
        if (QLog.isColorLevel()) {
            QLog.d("expand.ipc.ExpandFlutterIPCServer", 2, "onCall ACTION_GET_MATCH_SWITCH ,open = " + d16);
        }
        return EIPCResult.createSuccessResult(bundle);
    }

    public void T(int i3) {
        Bundle bundle = new Bundle();
        bundle.putInt("redPointNum", i3);
        QIPCServerHelper.getInstance().getServer().callClient(getProcessName(), 1, "ExpandFlutterIPCClient", "notifyRedPointEvent", bundle, null);
    }

    public void notifyPushEvent(long j3, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("data", bArr);
        bundle.putLong("pushType", j3);
        QIPCServerHelper.getInstance().getServer().callClient(getProcessName(), 1, "ExpandFlutterIPCClient", "notifyPushEvent", bundle);
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("expand.ipc.ExpandFlutterIPCServer", 2, "onCall, params=" + bundle + ", action=" + str + ", callBackId=" + i3);
        }
        AppRuntime w3 = w();
        if (!(w3 instanceof QQAppInterface)) {
            return null;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) w3;
        if ("notifySetTABTestPlan".equals(str)) {
            EIPCResult X = X(qQAppInterface, bundle);
            callbackResult(i3, X);
            return X;
        }
        if ("notifyGetMatchSwitch".equals(str)) {
            EIPCResult z16 = z(qQAppInterface);
            callbackResult(i3, z16);
            return z16;
        }
        if ("notifyDoReport".equals(str)) {
            EIPCResult v3 = v(qQAppInterface, bundle);
            callbackResult(i3, v3);
            return v3;
        }
        if ("notifyOpenAio".equals(str)) {
            EIPCResult U = U(qQAppInterface, bundle);
            callbackResult(i3, U);
            return U;
        }
        if ("getRedPoint".equals(str)) {
            EIPCResult B = B(qQAppInterface);
            callbackResult(i3, B);
            return B;
        }
        if ("clearRedPoint".equals(str)) {
            EIPCResult t16 = t();
            callbackResult(i3, t16);
            return t16;
        }
        if ("closeLoading".equals(str)) {
            ExpandPluginLauncher.y().t(bundle);
        } else if ("preloadServiceStarted".equals(str)) {
            ExpandPluginLauncher.y().D(bundle.getInt("pluginPid", 0));
        } else if ("METHOD_CREATE_MESSAGE_NODE_IF_NEED".equals(str)) {
            u(qQAppInterface, bundle);
        } else if ("notifyBatchCreateMessageNodeIfNeed".equals(str)) {
            s(qQAppInterface, bundle);
        } else if (PluginConst.ExpandJsPluginConst.API_GET_GET_EXPAND_USER_INFO.equals(str)) {
            x(qQAppInterface, i3);
        } else if ("notifyOpenSchema".equals(str)) {
            V(qQAppInterface, bundle);
            return null;
        }
        try {
            return this.f263822d.a(str, bundle, i3);
        } catch (Exception e16) {
            QLog.d("expand.ipc.ExpandFlutterIPCServer", 2, "Exception happens" + e16.getMessage());
            callbackResult(i3, null);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes35.dex */
    public class q implements BusinessObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AppInterface f263847d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f263848e;

        q(AppInterface appInterface, String str) {
            this.f263847d = appInterface;
            this.f263848e = str;
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int i3, boolean z16, Object obj) {
            if (!z16 || obj == null) {
                return;
            }
            LimitChatUtil.D((QQAppInterface) this.f263847d, this.f263848e, 1044, true, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes35.dex */
    public class r implements BusinessObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AppInterface f263850d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f263851e;

        r(AppInterface appInterface, String str) {
            this.f263850d = appInterface;
            this.f263851e = str;
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int i3, boolean z16, Object obj) {
            if (!z16 || obj == null) {
                return;
            }
            LimitChatUtil.D((QQAppInterface) this.f263850d, this.f263851e, 1044, true, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bundle E(Bundle bundle, int i3) {
        if (bundle != null) {
            return null;
        }
        QLog.w("expand.ipc.ExpandFlutterIPCServer", 1, "handleMessage params is null METHOD_CHAT_GET_CONVERSATION_LIST");
        return new Bundle();
    }
}
