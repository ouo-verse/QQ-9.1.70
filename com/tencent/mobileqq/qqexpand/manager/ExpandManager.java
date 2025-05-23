package com.tencent.mobileqq.qqexpand.manager;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.LruCache;
import android.view.KeyEvent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.leba.ILebaHelperService;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.profile.i;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import com.tencent.mobileqq.qqexpand.bean.profile.ExpandUserInfo;
import com.tencent.mobileqq.qqexpand.chat.utils.ExpandChatUtil;
import com.tencent.mobileqq.qqexpand.config.ExpandConfig;
import com.tencent.mobileqq.qqexpand.config.banner.ExpandBannerConfBean$BannerItem;
import com.tencent.mobileqq.qqexpand.flutter.channel.chat.ExpandChatRepository;
import com.tencent.mobileqq.qqexpand.network.ExpandCmdHandler;
import com.tencent.mobileqq.qqexpand.network.ExpandObserver;
import com.tencent.mobileqq.qqexpand.network.impl.ExpandHandlerImpl;
import com.tencent.mobileqq.qqexpand.utils.CampusHelper;
import com.tencent.mobileqq.qqexpand.utils.ColdPalaceHelper;
import com.tencent.mobileqq.qqexpand.utils.IExpandForbiddenUtils;
import com.tencent.mobileqq.qqexpand.utils.g;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.qzone.QZoneUnreadServletLogic;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xdb1.oidb_0xdb1$RspBody;
import tencent.im.oidb.cmd0xdb1.oidb_0xdb1$SchoolInfo;
import tencent.im.oidb.cmd0xdb1.oidb_0xdb1$SearchKeyWord;
import tencent.im.oidb.cmd0xdb1.oidb_0xdb1$matchTaskInfo;
import tencent.im.oidb.cmd0xe03.oidb_0xe03$RspBody;
import tencent.im.oidb.cmd0xe03.oidb_0xe03$matchTaskInfo;

/* compiled from: P */
/* loaded from: classes35.dex */
public class ExpandManager implements Manager, com.tencent.mobileqq.qqexpand.manager.e {
    private final ExtendFriendSearchHistoryManager C;
    private int D;
    private String E;
    private boolean F;
    private final LruCache<String, ExpandUserInfo> G;
    private final EntityManager H;
    private final ArrayList<String> I;
    private final ArrayList<String> J;
    private int K;
    private int L;
    private long M;
    private int N;
    private String P;
    private long Q;
    private long R;
    private String S;
    private final List<vg2.a> T;
    private final ColdPalaceHelper U;
    private final ExpandChatRepository V;
    private final ExpandCmdHandler W;
    private final ah2.a X;
    private int Y;
    private String Z;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f263859a0;

    /* renamed from: b0, reason: collision with root package name */
    private volatile boolean f263860b0;

    /* renamed from: c0, reason: collision with root package name */
    private oidb_0xdb1$SchoolInfo f263861c0;

    /* renamed from: d, reason: collision with root package name */
    public String f263862d;

    /* renamed from: d0, reason: collision with root package name */
    private i f263863d0;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.mobileqq.qqexpand.bean.feed.a f263864e;

    /* renamed from: e0, reason: collision with root package name */
    private long f263865e0;

    /* renamed from: f, reason: collision with root package name */
    private final ch2.c f263866f;

    /* renamed from: f0, reason: collision with root package name */
    private volatile boolean f263867f0;

    /* renamed from: g0, reason: collision with root package name */
    private final ProfileCardObserver f263868g0;

    /* renamed from: h, reason: collision with root package name */
    private final com.tencent.mobileqq.qqexpand.manager.b f263869h;

    /* renamed from: h0, reason: collision with root package name */
    private final ExpandObserver f263870h0;

    /* renamed from: i, reason: collision with root package name */
    private QQAppInterface f263871i;

    /* renamed from: i0, reason: collision with root package name */
    private volatile boolean f263872i0;

    /* renamed from: j0, reason: collision with root package name */
    private volatile boolean f263873j0;

    /* renamed from: k0, reason: collision with root package name */
    private volatile long f263874k0;

    /* renamed from: l0, reason: collision with root package name */
    private final Object f263875l0;

    /* renamed from: m, reason: collision with root package name */
    private final ExtendFriendSearchHistoryManager f263876m;

    /* renamed from: m0, reason: collision with root package name */
    private List<Object> f263877m0;

    /* renamed from: n0, reason: collision with root package name */
    private int f263878n0;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.qqexpand.manager.ExpandManager$4, reason: invalid class name */
    /* loaded from: classes35.dex */
    class AnonymousClass4 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f263879d;
        final /* synthetic */ ExpandManager this$0;

        @Override // java.lang.Runnable
        public void run() {
            ExpandChatUtil.g(this.this$0.f263871i, this.f263879d);
        }
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes35.dex */
    public @interface CertificateStatus {
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class b implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f263883d;

        b(Activity activity) {
            this.f263883d = activity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
            this.f263883d.finish();
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class e implements g {
        e() {
        }

        @Override // com.tencent.mobileqq.qqexpand.utils.g
        public void a(boolean z16, vg2.b bVar) {
            if (ExpandManager.this.f263871i == null) {
                QLog.e("ExtendFriendManager", 2, "enterExtendFriend onGetLocationInfo null");
                return;
            }
            if (!z16) {
                QLog.e("ExtendFriendManager", 2, "enterExtendFriend onGetLocationInfo NOT suc");
            }
            if (ExpandManager.this.B0()) {
                ((ExpandHandlerImpl) ExpandManager.this.f263871i.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER)).F2(bVar);
                QLog.i("ExtendFriendManager", 2, "enterExtendFriend onGetLocationInfo NOT suc:" + z16);
                return;
            }
            QLog.e("ExtendFriendManager", 2, "enterExtendFriend onGetLocationInfo NOT In extendfriend");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class f extends LbsManagerServiceOnLocationChangeListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ g f263888a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(String str, boolean z16, g gVar) {
            super(str, z16);
            this.f263888a = gVar;
        }

        @Override // com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener
        public void onLocationFinish(int i3, SosoLbsInfo sosoLbsInfo) {
            if (QLog.isColorLevel()) {
                QLog.d("ExtendFriendManager", 2, "getExtendFriendLocationInfoAsync onLocationFinish " + i3);
            }
            g gVar = this.f263888a;
            if (gVar != null) {
                ExpandManager.this.m0(i3 == 0, sosoLbsInfo, gVar);
            }
        }
    }

    static {
        com.tencent.mobileqq.qqexpand.utils.d.d();
        QLog.i("ExtendFriendManager", 1, "init expand tunnel");
    }

    public ExpandManager(QQAppInterface qQAppInterface) {
        ch2.c cVar = new ch2.c();
        this.f263866f = cVar;
        this.f263869h = new com.tencent.mobileqq.qqexpand.manager.b();
        this.G = new LruCache<>(50);
        this.I = new ArrayList<>();
        this.J = new ArrayList<>();
        this.M = 0L;
        this.N = 0;
        this.P = "";
        this.S = "";
        this.T = new ArrayList();
        this.Z = "";
        this.f263859a0 = false;
        this.f263860b0 = false;
        this.f263865e0 = 0L;
        this.f263867f0 = false;
        c cVar2 = new c();
        this.f263868g0 = cVar2;
        d dVar = new d();
        this.f263870h0 = dVar;
        this.f263872i0 = false;
        this.f263873j0 = false;
        this.f263874k0 = 0L;
        this.f263875l0 = new Object();
        this.f263878n0 = 0;
        this.f263865e0 = SystemClock.uptimeMillis();
        this.f263871i = qQAppInterface;
        qQAppInterface.addObserver(cVar2);
        this.f263871i.addObserver(dVar);
        this.V = new ExpandChatRepository(this.f263871i);
        this.W = new ExpandCmdHandler(this.f263871i);
        this.X = new ah2.a(this.f263871i);
        this.f263876m = new ExtendFriendSearchHistoryManager(this.f263871i, 2);
        this.C = new ExtendFriendSearchHistoryManager(this.f263871i, 1);
        this.H = qQAppInterface.getEntityManagerFactory().createEntityManager();
        this.U = new ColdPalaceHelper(qQAppInterface);
        cVar.a();
        ThreadManagerV2.postImmediately(new Runnable() { // from class: com.tencent.mobileqq.qqexpand.manager.ExpandManager.3
            @Override // java.lang.Runnable
            public void run() {
                ExpandChatUtil.h(ExpandManager.this.f263871i);
                ExpandChatUtil.g(ExpandManager.this.f263871i, false);
                ExpandManager.this.G0();
                ExpandManager.this.p0();
            }
        }, null, true);
    }

    private JSONObject C0(BusinessInfoCheckUpdate.AppInfo appInfo) {
        if (appInfo == null) {
            return null;
        }
        try {
        } catch (Throwable th5) {
            QLog.e("ExtendFriendManager", 1, "getTianShuSrcInfo() JSONException ", th5);
        }
        if (!appInfo.buffer.has()) {
            return null;
        }
        String str = appInfo.buffer.get();
        if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendManager", 2, "TianShuBufferJsonStr = " + str);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        String optString = jSONObject.optString("_show_mission");
        if (!TextUtils.isEmpty(optString)) {
            return new JSONObject(jSONObject.optJSONObject("msg").optJSONObject(optString).optString("src"));
        }
        return null;
    }

    public static boolean F0() {
        int i3 = Build.VERSION.SDK_INT;
        if (BaseApplicationImpl.getApplication().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) {
            return true;
        }
        if (!QLog.isColorLevel()) {
            return false;
        }
        QLog.d("ExtendFriendManager", 2, "hasLocationPermission no permission " + i3);
        return false;
    }

    private void J0(boolean z16) {
        QLog.i("ExtendFriendManager", 2, "setExtendFriendUsing o " + z16);
        this.f263873j0 = z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R0() {
        QQAppInterface qQAppInterface = this.f263871i;
        if (qQAppInterface != null) {
            try {
                Card r16 = ((FriendsManager) qQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).r(this.f263871i.getCurrentUin());
                if (r16 != null) {
                    boolean z16 = !TextUtils.isEmpty(r16.declaration);
                    boolean z17 = r16.isShowCard;
                    if (QLog.isColorLevel()) {
                        QLog.d("ExtendFriendManager", 2, String.format("updateSwitchInCacheData profileComplete=%s showCard=%s", Boolean.valueOf(z16), Boolean.valueOf(z17)));
                    }
                    com.tencent.mobileqq.qqexpand.bean.feed.a aVar = this.f263864e;
                    if (aVar != null) {
                        aVar.f263475b = z16;
                        aVar.f263476c = z17;
                    }
                }
            } catch (Exception e16) {
                QLog.e("ExtendFriendManager", 1, "updateSwitchInCacheData fail.", e16);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendManager", 2, String.format("updateSwitchInCacheData %s", this.f263864e));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m0(boolean z16, SosoLbsInfo sosoLbsInfo, g gVar) {
        gVar.a(z16, vg2.b.a(sosoLbsInfo));
    }

    public static QQAppInterface q0() {
        AppRuntime runtime = BaseApplicationImpl.sApplication.getRuntime();
        if (runtime instanceof QQAppInterface) {
            return (QQAppInterface) runtime;
        }
        return null;
    }

    private static long y0(BaseQQAppInterface baseQQAppInterface) {
        return 0L;
    }

    private static int z0(BaseQQAppInterface baseQQAppInterface) {
        return 0;
    }

    public int A0() {
        if (this.D == 0) {
            ExpandConfig b16 = this.X.b();
            if (b16 != null && b16.maxPlayers > 0) {
                this.D = b16.minPlayers + new Random().nextInt(b16.maxPlayers - b16.minPlayers);
            } else {
                this.D = new Random().nextInt(10000000);
            }
        }
        return this.D;
    }

    @Override // com.tencent.mobileqq.qqexpand.manager.e
    public boolean B() {
        return false;
    }

    public boolean B0() {
        QLog.i("ExtendFriendManager", 2, "getIsExtendFriendUsing " + this.f263873j0);
        return this.f263873j0;
    }

    @Override // com.tencent.mobileqq.qqexpand.manager.e
    public boolean C() {
        return false;
    }

    public String D0() {
        return "";
    }

    @Override // com.tencent.mobileqq.qqexpand.manager.e
    public void E(wg2.a aVar) {
        this.X.a(aVar);
    }

    public void E0(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, oidb_0xdb1$RspBody oidb_0xdb1_rspbody) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        int i3 = oidb_0xdb1_rspbody.enum_school_verify_status.has() ? oidb_0xdb1_rspbody.enum_school_verify_status.get() : 0;
        if (!oidb_0xdb1_rspbody.str_school_verify_tips.has()) {
            str = "";
        } else {
            str = oidb_0xdb1_rspbody.str_school_verify_tips.get();
        }
        V(i3, TextUtils.isEmpty(str) ? 1 : 2);
        this.f263860b0 = (oidb_0xdb1_rspbody.uint32_user_identity.has() ? oidb_0xdb1_rspbody.uint32_user_identity.get() : 0) == 1;
        S0(this.f263860b0);
        this.f263859a0 = (oidb_0xdb1_rspbody.uint32_need_display_school_info.has() ? oidb_0xdb1_rspbody.uint32_need_display_school_info.get() : 0) == 1;
        this.f263861c0 = oidb_0xdb1_rspbody.msg_new_school_info.has() ? oidb_0xdb1_rspbody.msg_new_school_info.get() : null;
        if (!oidb_0xdb1_rspbody.str_suggest_school_name.has()) {
            str2 = "";
        } else {
            str2 = oidb_0xdb1_rspbody.str_suggest_school_name.get();
        }
        this.Z = str2;
        oidb_0xdb1$SchoolInfo oidb_0xdb1_schoolinfo = oidb_0xdb1_rspbody.msg_kuolie_school_info.has() ? oidb_0xdb1_rspbody.msg_kuolie_school_info.get() : null;
        L0(oidb_0xdb1_schoolinfo);
        if (oidb_0xdb1_schoolinfo == null || !oidb_0xdb1_schoolinfo.str_school_name.has()) {
            str3 = "";
        } else {
            str3 = oidb_0xdb1_schoolinfo.str_school_name.get();
        }
        int i16 = (toServiceMsg.extraData.getBoolean("key_need_get_online_number", false) && oidb_0xdb1_rspbody.uint32_online_num.has()) ? oidb_0xdb1_rspbody.uint32_online_num.get() : 0;
        this.K = i16;
        if (toServiceMsg.extraData.getBoolean("key_need_get_search_keywords", false)) {
            List<oidb_0xdb1$SearchKeyWord> list = oidb_0xdb1_rspbody.msg_campus_search_keywords.has() ? oidb_0xdb1_rspbody.msg_campus_search_keywords.get() : null;
            List<oidb_0xdb1$SearchKeyWord> list2 = oidb_0xdb1_rspbody.msg_voice_search_keywords.has() ? oidb_0xdb1_rspbody.msg_voice_search_keywords.get() : null;
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (list != null && list.size() > 0) {
                for (oidb_0xdb1$SearchKeyWord oidb_0xdb1_searchkeyword : list) {
                    if (!oidb_0xdb1_searchkeyword.str_school_name.has()) {
                        str5 = "";
                    } else {
                        str5 = oidb_0xdb1_searchkeyword.str_school_name.get();
                    }
                    if (!TextUtils.isEmpty(str5)) {
                        arrayList.add(str5);
                    }
                }
            }
            if (list2 != null && list2.size() > 0) {
                for (oidb_0xdb1$SearchKeyWord oidb_0xdb1_searchkeyword2 : list2) {
                    if (!oidb_0xdb1_searchkeyword2.str_school_name.has()) {
                        str4 = "";
                    } else {
                        str4 = oidb_0xdb1_searchkeyword2.str_school_name.get();
                    }
                    if (!TextUtils.isEmpty(str4)) {
                        arrayList2.add(str4);
                    }
                }
            }
            P0(arrayList, arrayList2);
        }
        int i17 = oidb_0xdb1_rspbody.uint32_forbid_flag.has() ? oidb_0xdb1_rspbody.uint32_forbid_flag.get() : 0;
        long j3 = oidb_0xdb1_rspbody.uint32_forbid_end_time.has() ? oidb_0xdb1_rspbody.uint32_forbid_end_time.get() : 0L;
        M0(this.f263871i, i17, j3);
        this.L = oidb_0xdb1_rspbody.bytes_birthday.has() ? ByteBuffer.wrap(oidb_0xdb1_rspbody.bytes_birthday.get().toByteArray()).getInt() : 0;
        N0(oidb_0xdb1_rspbody);
        if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendManager", 2, "handleGetExtendFriendPermissionAndStatusResponse. ,verifyStatus = " + i3 + ",verifyTips = " + str + ",serverSuggestSchoolName = " + this.Z + ",schoolNameInExtendFriendCard = " + str3 + ",onlineNumber = " + i16 + ",needShowEduBackgroundUpdateDialog = " + this.f263859a0 + ",profileNewSchoolInfo = " + this.f263861c0 + ",isUserStudentOrNot = " + this.f263860b0 + ",userBirthday = " + this.L + ",forbidFlag = " + i17 + ",forbidEndTime = " + j3);
        }
    }

    @Override // com.tencent.mobileqq.qqexpand.manager.e
    public boolean F() {
        return u0().f();
    }

    @Override // com.tencent.mobileqq.qqexpand.manager.e
    public String G() {
        return this.Z;
    }

    public void G0() {
        this.X.e();
    }

    @Override // com.tencent.mobileqq.qqexpand.manager.e
    public void H(String str, String str2, int i3) {
        QQAppInterface qQAppInterface = this.f263871i;
        if (qQAppInterface == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendManager", 2, "getUnlimitMatchUserInfo() uin = " + str + " matchUin = " + str2 + "uinType=" + i3);
        }
        ((ExpandHandlerImpl) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER)).H2(str, str2, i3);
    }

    public boolean H0() {
        return this.X.h();
    }

    @Override // com.tencent.mobileqq.qqexpand.manager.e
    public void I() {
        this.R++;
        if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendManager", 2, "increaseMatchedCount matchedCount = " + this.R);
        }
    }

    public void I0() {
        this.f263869h.b();
    }

    @Override // com.tencent.mobileqq.qqexpand.manager.e
    public int J() {
        if (!this.X.g() || this.X.b() == null) {
            return 1;
        }
        int i3 = this.X.b().coldPalaceGrayTipPosition;
        if (!QLog.isColorLevel()) {
            return i3;
        }
        QLog.d("ExtendFriendManager", 2, "coldPalaceGrayTipPosition  " + i3);
        return i3;
    }

    @Override // com.tencent.mobileqq.qqexpand.manager.e
    public String K() {
        return this.P;
    }

    public void K0(String str) {
        this.P = str;
    }

    @Override // com.tencent.mobileqq.qqexpand.manager.e
    public boolean L(ExpandConfig expandConfig) {
        return false;
    }

    @Override // com.tencent.mobileqq.qqexpand.manager.e
    public int N() {
        return this.Y;
    }

    public void N0(oidb_0xdb1$RspBody oidb_0xdb1_rspbody) {
        this.Q = oidb_0xdb1_rspbody.uint64_max_match_times.has() ? oidb_0xdb1_rspbody.uint64_max_match_times.get() : 0L;
        this.R = oidb_0xdb1_rspbody.uint64_matched_times.has() ? oidb_0xdb1_rspbody.uint64_matched_times.get() : 0L;
        oidb_0xdb1$matchTaskInfo oidb_0xdb1_matchtaskinfo = oidb_0xdb1_rspbody.msg_task_info.has() ? oidb_0xdb1_rspbody.msg_task_info.get() : null;
        ArrayList arrayList = new ArrayList();
        if (oidb_0xdb1_matchtaskinfo != null) {
            if (oidb_0xdb1_matchtaskinfo.msg_base_info.has()) {
                vg2.a aVar = new vg2.a();
                aVar.f441593a = 1;
                aVar.f441594b = oidb_0xdb1_matchtaskinfo.msg_base_info.uint32_task_match_times.get();
                aVar.f441595c = oidb_0xdb1_matchtaskinfo.msg_base_info.str_msg.get();
                aVar.f441596d = oidb_0xdb1_matchtaskinfo.msg_base_info.uint32_task_status.get();
                arrayList.add(aVar);
            }
            if (oidb_0xdb1_matchtaskinfo.msg_kuolie_school.has()) {
                vg2.a aVar2 = new vg2.a();
                aVar2.f441593a = 2;
                aVar2.f441594b = oidb_0xdb1_matchtaskinfo.msg_kuolie_school.uint32_task_match_times.get();
                aVar2.f441595c = oidb_0xdb1_matchtaskinfo.msg_kuolie_school.str_msg.get();
                aVar2.f441596d = oidb_0xdb1_matchtaskinfo.msg_kuolie_school.uint32_task_status.get();
                arrayList.add(aVar2);
            }
            if (oidb_0xdb1_matchtaskinfo.msg_kuolie_declaration.has()) {
                vg2.a aVar3 = new vg2.a();
                aVar3.f441593a = 3;
                aVar3.f441594b = oidb_0xdb1_matchtaskinfo.msg_kuolie_declaration.uint32_task_match_times.get();
                aVar3.f441595c = oidb_0xdb1_matchtaskinfo.msg_kuolie_declaration.str_msg.get();
                aVar3.f441596d = oidb_0xdb1_matchtaskinfo.msg_kuolie_declaration.uint32_task_status.get();
                arrayList.add(aVar3);
            }
            if (oidb_0xdb1_matchtaskinfo.msg_personal_label.has()) {
                vg2.a aVar4 = new vg2.a();
                aVar4.f441593a = 4;
                aVar4.f441594b = oidb_0xdb1_matchtaskinfo.msg_personal_label.uint32_task_match_times.get();
                aVar4.f441595c = oidb_0xdb1_matchtaskinfo.msg_personal_label.str_msg.get();
                aVar4.f441596d = oidb_0xdb1_matchtaskinfo.msg_personal_label.uint32_task_status.get();
                arrayList.add(aVar4);
            }
            if (oidb_0xdb1_matchtaskinfo.msg_photo.has()) {
                vg2.a aVar5 = new vg2.a();
                aVar5.f441593a = 5;
                aVar5.f441594b = oidb_0xdb1_matchtaskinfo.msg_photo.uint32_task_match_times.get();
                aVar5.f441595c = oidb_0xdb1_matchtaskinfo.msg_photo.str_msg.get();
                aVar5.f441596d = oidb_0xdb1_matchtaskinfo.msg_photo.uint32_task_status.get();
                arrayList.add(aVar5);
            }
        }
        this.T.clear();
        this.T.addAll(arrayList);
        if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendManager", 2, "updateMatchChatCompletePersonalDataTaskBy0xdb1 ,maxMatchCount" + this.Q + ",matchedCount" + this.R + ",completePesonalDataTasks" + this.T);
        }
    }

    @Override // com.tencent.mobileqq.qqexpand.manager.e
    public void O(com.tencent.mobileqq.qqexpand.bean.feed.a aVar) {
        this.f263864e = aVar;
    }

    public void O0(oidb_0xe03$RspBody oidb_0xe03_rspbody) {
        int i3 = oidb_0xe03_rspbody.enum_matchopretcode.has() ? oidb_0xe03_rspbody.enum_matchopretcode.get() : -1;
        if (12 == i3) {
            this.Q = oidb_0xe03_rspbody.uint64_max_match_times.has() ? oidb_0xe03_rspbody.uint64_max_match_times.get() : 0L;
            this.R = oidb_0xe03_rspbody.uint64_matched_times.has() ? oidb_0xe03_rspbody.uint64_matched_times.get() : 0L;
            oidb_0xe03$matchTaskInfo oidb_0xe03_matchtaskinfo = oidb_0xe03_rspbody.msg_task_info.has() ? oidb_0xe03_rspbody.msg_task_info.get() : null;
            ArrayList arrayList = new ArrayList();
            if (oidb_0xe03_matchtaskinfo != null) {
                if (oidb_0xe03_matchtaskinfo.msg_base_info.has()) {
                    vg2.a aVar = new vg2.a();
                    aVar.f441593a = 1;
                    aVar.f441594b = oidb_0xe03_matchtaskinfo.msg_base_info.uint32_task_match_times.get();
                    aVar.f441595c = oidb_0xe03_matchtaskinfo.msg_base_info.str_msg.get();
                    aVar.f441596d = oidb_0xe03_matchtaskinfo.msg_base_info.uint32_task_status.get();
                    arrayList.add(aVar);
                }
                if (oidb_0xe03_matchtaskinfo.msg_kuolie_school.has()) {
                    vg2.a aVar2 = new vg2.a();
                    aVar2.f441593a = 2;
                    aVar2.f441594b = oidb_0xe03_matchtaskinfo.msg_kuolie_school.uint32_task_match_times.get();
                    aVar2.f441595c = oidb_0xe03_matchtaskinfo.msg_kuolie_school.str_msg.get();
                    aVar2.f441596d = oidb_0xe03_matchtaskinfo.msg_kuolie_school.uint32_task_status.get();
                    arrayList.add(aVar2);
                }
                if (oidb_0xe03_matchtaskinfo.msg_kuolie_declaration.has()) {
                    vg2.a aVar3 = new vg2.a();
                    aVar3.f441593a = 3;
                    aVar3.f441594b = oidb_0xe03_matchtaskinfo.msg_kuolie_declaration.uint32_task_match_times.get();
                    aVar3.f441595c = oidb_0xe03_matchtaskinfo.msg_kuolie_declaration.str_msg.get();
                    aVar3.f441596d = oidb_0xe03_matchtaskinfo.msg_kuolie_declaration.uint32_task_status.get();
                    arrayList.add(aVar3);
                }
                if (oidb_0xe03_matchtaskinfo.msg_personal_label.has()) {
                    vg2.a aVar4 = new vg2.a();
                    aVar4.f441593a = 4;
                    aVar4.f441594b = oidb_0xe03_matchtaskinfo.msg_personal_label.uint32_task_match_times.get();
                    aVar4.f441595c = oidb_0xe03_matchtaskinfo.msg_personal_label.str_msg.get();
                    aVar4.f441596d = oidb_0xe03_matchtaskinfo.msg_personal_label.uint32_task_status.get();
                    arrayList.add(aVar4);
                }
                if (oidb_0xe03_matchtaskinfo.msg_photo.has()) {
                    vg2.a aVar5 = new vg2.a();
                    aVar5.f441593a = 5;
                    aVar5.f441594b = oidb_0xe03_matchtaskinfo.msg_photo.uint32_task_match_times.get();
                    aVar5.f441595c = oidb_0xe03_matchtaskinfo.msg_photo.str_msg.get();
                    aVar5.f441596d = oidb_0xe03_matchtaskinfo.msg_photo.uint32_task_status.get();
                    arrayList.add(aVar5);
                }
            }
            this.T.clear();
            this.T.addAll(arrayList);
        } else if (i3 == 0) {
            this.R = oidb_0xe03_rspbody.uint64_matched_times.has() ? oidb_0xe03_rspbody.uint64_matched_times.get() : 0L;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendManager", 2, "updateMatchChatCompletePersonalDataTaskBy0xe03 ,retCode " + i3 + ",maxMatchCount " + this.Q + ",matchedCount " + this.R + ",completePesonalDataTasks " + this.T);
        }
    }

    @Override // com.tencent.mobileqq.qqexpand.manager.e
    public boolean P() {
        this.X.j();
        return false;
    }

    @Override // com.tencent.mobileqq.qqexpand.manager.e
    public void Q() {
        synchronized (this.f263875l0) {
            List<Object> list = this.f263877m0;
            if (list != null) {
                list.clear();
            }
        }
    }

    @Override // com.tencent.mobileqq.qqexpand.manager.e
    public boolean T() {
        return this.X.i();
    }

    @Override // com.tencent.mobileqq.qqexpand.manager.e
    public void U() {
        this.G.evictAll();
        EntityManager entityManager = this.H;
        if (entityManager == null || !entityManager.isOpen()) {
            return;
        }
        this.H.drop(ExpandUserInfo.class);
    }

    @Override // com.tencent.mobileqq.qqexpand.manager.e
    public void V(int i3, int i16) {
        if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendManager", 2, "updateCampusCertificateStatus campusCertificateStatus = " + this.Y + ",new status = " + i3);
        }
        this.Y = i3;
        CampusHelper.j(this.f263871i, i3, i16);
    }

    @Override // com.tencent.mobileqq.qqexpand.manager.e
    public boolean W(BaseQQAppInterface baseQQAppInterface) {
        if (this.f263871i == null) {
            QLog.e("ExtendFriendManager", 1, "isShowExpandEntry: mApp is null!");
            return false;
        }
        boolean C = ExpandChatUtil.C(baseQQAppInterface);
        if (C && !this.f263867f0) {
            this.f263867f0 = true;
            ((ILebaHelperService) this.f263871i.getRuntimeService(ILebaHelperService.class, "")).notifyPluginListChanged();
            QLog.i("ExtendFriendManagerexpand.enter.", 1, "begin show Entry. time cost=" + (SystemClock.uptimeMillis() - this.f263865e0) + " ms");
        }
        return C;
    }

    @Override // com.tencent.mobileqq.qqexpand.manager.e
    public int X() {
        return 0;
    }

    @Override // com.tencent.mobileqq.qqexpand.manager.e
    public String Y() {
        if (this.X.g() && this.X.b() != null) {
            return this.X.b().mBeatWarning;
        }
        return "";
    }

    @Override // com.tencent.mobileqq.qqexpand.manager.e
    public int a() {
        return this.X.d();
    }

    @Override // com.tencent.mobileqq.qqexpand.manager.e
    public com.tencent.mobileqq.qqexpand.bean.feed.a a0() {
        return this.f263864e;
    }

    @Override // com.tencent.mobileqq.qqexpand.manager.e
    public boolean c() {
        return false;
    }

    @Override // com.tencent.mobileqq.qqexpand.manager.e
    public String c0() {
        return this.f263862d;
    }

    @Override // com.tencent.mobileqq.qqexpand.manager.e
    public ExtendFriendSearchHistoryManager d() {
        return this.f263876m;
    }

    @Override // com.tencent.mobileqq.qqexpand.manager.e
    public int d0() {
        if (!this.X.g() || this.X.b() == null) {
            return 0;
        }
        return this.X.b().tabIndex;
    }

    @Override // com.tencent.mobileqq.qqexpand.manager.e
    public ExpandConfig e() {
        return u0().b();
    }

    @Override // com.tencent.mobileqq.qqexpand.manager.e
    public ExtendFriendSearchHistoryManager e0() {
        return this.C;
    }

    @Override // com.tencent.mobileqq.qqexpand.manager.e
    public int f(String str) {
        return 0;
    }

    @Override // com.tencent.mobileqq.qqexpand.manager.e
    public ExpandConfig g() {
        return this.X.c();
    }

    @Override // com.tencent.mobileqq.qqexpand.manager.e
    public ArrayList<ExpandBannerConfBean$BannerItem> getBannerConfigList() {
        return null;
    }

    @Override // com.tencent.mobileqq.qqexpand.manager.e
    public int h() {
        return this.f263878n0;
    }

    @Override // com.tencent.mobileqq.qqexpand.manager.e
    public String i() {
        String str = this.S;
        return str == null ? "" : str;
    }

    @Override // com.tencent.mobileqq.qqexpand.manager.e
    public boolean isResourceReady() {
        if (!this.F) {
            QLog.e("ExtendFriendManager", 2, "isResourceReady NOT READY!");
        }
        return this.F;
    }

    @Override // com.tencent.mobileqq.qqexpand.manager.e
    public void j(int i3, String str, String str2, int i16) {
        if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendManager", 2, "updateCurExtendFriendSchoolInfo ,idx = " + i3 + ",schoolName = " + str + ",schoolId = " + str2 + ",schoolCategory = " + i16);
        }
        if (TextUtils.isEmpty(str)) {
            this.f263863d0 = null;
            return;
        }
        if (this.f263863d0 == null) {
            this.f263863d0 = new i();
        }
        i iVar = this.f263863d0;
        iVar.f260182a = i3;
        iVar.f260185d = str;
        iVar.f260184c = str2;
        iVar.f260183b = i16;
    }

    @Override // com.tencent.mobileqq.qqexpand.manager.e
    public void k(Activity activity) {
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.qqexpand.manager.ExpandManager.5
            @Override // java.lang.Runnable
            public void run() {
                if (QLog.isColorLevel()) {
                    QLog.d("ExtendFriendManagerLimitchat", 2, "checkToDownloadResource");
                }
                if (!ExpandManager.this.X.g()) {
                    QLog.d("ExtendFriendManagerLimitchat", 2, "checkToDownloadResource !inited");
                }
                if (com.tencent.mobileqq.qqexpand.utils.c.f()) {
                    return;
                }
                QLog.e("ExtendFriendManagerLimitchat", 2, "isBgPicFileExist  no\uff01");
                if (ExpandManager.this.X.b() == null) {
                    QLog.d("ExtendFriendManagerLimitchat", 2, "mConfig  IS NOT READY");
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                long j3 = currentTimeMillis - ExpandManager.this.M;
                if (NetworkUtil.isWifiConnected(BaseApplication.getContext()) || j3 >= ShortVideoConstants.VIDEO_MAX_DURATION || ExpandManager.this.N <= 2) {
                    return;
                }
                QLog.e("ExtendFriendManagerLimitchat", 2, " limitChatResList IS NOT READY currentTime" + currentTimeMillis + " lastDownloadTime " + ExpandManager.this.M + " downloadTimes" + ExpandManager.this.N);
            }
        });
    }

    @Override // com.tencent.mobileqq.qqexpand.manager.e
    public String l() {
        ExpandConfig e16;
        String str = (!this.X.g() || (e16 = e()) == null) ? null : e16.searchHint;
        return TextUtils.isEmpty(str) ? HardCodeUtil.qqStr(R.string.mbq) : str;
    }

    @Override // com.tencent.mobileqq.qqexpand.manager.e
    public void m(ExpandUserInfo expandUserInfo) {
        if (expandUserInfo != null && !TextUtils.isEmpty(expandUserInfo.uin)) {
            this.G.put(expandUserInfo.uin, expandUserInfo);
            EntityManager entityManager = this.H;
            if (entityManager != null && entityManager.isOpen()) {
                if (expandUserInfo.getStatus() == 1000) {
                    this.H.persistOrReplace(expandUserInfo);
                } else if (expandUserInfo.getStatus() == 1001) {
                    this.H.update(expandUserInfo);
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("ExtendFriendManager", 2, "updateExtendFriendUserInfo " + expandUserInfo);
                return;
            }
            return;
        }
        QLog.w("ExtendFriendManager", 1, "updateExtendFriendUserInfo but extendFriendUserInfo is empty");
    }

    @Override // com.tencent.mobileqq.qqexpand.manager.e
    public void n() {
        if (this.f263871i == null) {
            return;
        }
        J0(true);
        v0(this.f263871i.getApp().getBaseContext(), new e());
        n0();
    }

    @Override // com.tencent.mobileqq.qqexpand.manager.e
    public ExpandUserInfo o(String str, boolean z16) {
        if (TextUtils.isEmpty(str)) {
            QLog.w("ExtendFriendManager", 1, "getExtendFriendUserInfoCache but uin is empty");
            return null;
        }
        ExpandUserInfo expandUserInfo = this.G.get(str);
        if (expandUserInfo == null && z16 && (expandUserInfo = x0(str)) != null) {
            this.G.put(str, expandUserInfo);
        }
        return expandUserInfo;
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        QQAppInterface qQAppInterface = this.f263871i;
        if (qQAppInterface != null) {
            qQAppInterface.removeObserver(this.f263868g0);
            this.f263871i.removeObserver(this.f263870h0);
        }
        this.f263871i = null;
        this.f263866f.b();
        this.f263864e = null;
        LruCache<String, ExpandUserInfo> lruCache = this.G;
        if (lruCache != null) {
            lruCache.evictAll();
        }
        ExpandChatRepository expandChatRepository = this.V;
        if (expandChatRepository != null) {
            expandChatRepository.u();
        }
        ExpandCmdHandler expandCmdHandler = this.W;
        if (expandCmdHandler != null) {
            expandCmdHandler.e();
        }
    }

    @Override // com.tencent.mobileqq.qqexpand.manager.e
    public boolean p() {
        return this.X.b() != null && this.X.b().bLimitchatOpen == 1;
    }

    @Override // com.tencent.mobileqq.qqexpand.manager.e
    public List<String> q(int i3) {
        ArrayList arrayList = new ArrayList();
        if (i3 == 1) {
            if (this.I.size() > 0) {
                arrayList.addAll(this.I);
            }
        } else if (this.J.size() > 0) {
            arrayList.addAll(this.J);
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqexpand.manager.e
    public List<String> r(int i3) {
        ArrayList arrayList = new ArrayList();
        if (i3 == 1) {
            QQAppInterface qQAppInterface = this.f263871i;
            if (qQAppInterface == null) {
                if (QLog.isColorLevel()) {
                    QLog.w("ExtendFriendManager", 2, String.format("getDefaultTags app is null check here!", new Object[0]));
                }
                return arrayList;
            }
            String[] r16 = QZoneUnreadServletLogic.r(qQAppInterface.getLongAccountUin());
            if (QLog.isColorLevel()) {
                QLog.d("ExtendFriendManager", 2, String.format("getDefaultTags campusHotTags=%s", Arrays.toString(r16)));
            }
            if (r16 != null && r16.length > 0) {
                this.I.clear();
                this.I.addAll(Arrays.asList(r16));
            }
            int size = this.I.size();
            if (size > 0) {
                arrayList.addAll(this.I.subList(0, Math.min(size, 10)));
            }
        } else {
            int size2 = this.J.size();
            if (size2 > 0) {
                arrayList.addAll(this.J.subList(0, Math.min(size2, 5)));
            }
        }
        arrayList.add(0, "\u63a8\u8350");
        return arrayList;
    }

    public ExpandChatRepository r0() {
        return this.V;
    }

    @Override // com.tencent.mobileqq.qqexpand.manager.e
    public boolean s() {
        int i3;
        QQAppInterface qQAppInterface = this.f263871i;
        boolean z16 = true;
        if (qQAppInterface == null) {
            QLog.w("ExtendFriendManager", 1, "call isNeedShowCertificateBanner after manager destroy!");
            return false;
        }
        boolean a16 = CampusHelper.a(qQAppInterface);
        if (!a16 || ((i3 = this.Y) != 0 && i3 != 2 && i3 != 3)) {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendManager", 2, "isNeedShowCertificateBanner result = " + z16 + ",showFlag = " + a16);
        }
        return z16;
    }

    public ExpandCmdHandler s0() {
        return this.W;
    }

    @Override // com.tencent.mobileqq.qqexpand.manager.e
    public String t() {
        i iVar = this.f263863d0;
        if (iVar != null) {
            return iVar.f260185d;
        }
        return "";
    }

    public ColdPalaceHelper t0() {
        return this.U;
    }

    @Override // com.tencent.mobileqq.qqexpand.manager.e
    public boolean u() {
        return this.f263860b0;
    }

    public ah2.a u0() {
        return this.X;
    }

    @Override // com.tencent.mobileqq.qqexpand.manager.e
    public void v(String str) {
        this.f263862d = str;
    }

    @Override // com.tencent.mobileqq.qqexpand.manager.e
    public vg2.b w() {
        if (this.f263871i == null) {
            QLog.e("ExtendFriendManager", 2, "getExtendFriendLocationInfoSync: mApp is null!");
            return null;
        }
        SosoLbsInfo cachedLbsInfo = ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("extend_friend");
        vg2.b a16 = cachedLbsInfo != null ? vg2.b.a(cachedLbsInfo) : null;
        if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendManager", 2, "getExtendFriendLocationInfoSync " + a16);
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (NetworkUtil.isNetSupport(this.f263871i.getApp().getBaseContext()) && F0() && currentTimeMillis - this.f263874k0 > 3600000) {
            if (QLog.isColorLevel()) {
                QLog.d("ExtendFriendManager", 2, "getExtendFriendLocationInfoSync start");
            }
            this.f263874k0 = currentTimeMillis;
            ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.qqexpand.manager.ExpandManager.9

                /* compiled from: P */
                /* renamed from: com.tencent.mobileqq.qqexpand.manager.ExpandManager$9$a */
                /* loaded from: classes35.dex */
                class a extends LbsManagerServiceOnLocationChangeListener {
                    a(String str, boolean z16) {
                        super(str, z16);
                    }

                    @Override // com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener
                    public void onLocationFinish(int i3, SosoLbsInfo sosoLbsInfo) {
                        if (QLog.isColorLevel()) {
                            QLog.d("ExtendFriendManager", 2, "getExtendFriendLocationInfoSync onLocationFinish " + i3);
                        }
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).startLocation(new a("extend_friend", false));
                }
            });
        }
        return a16;
    }

    @Override // com.tencent.mobileqq.qqexpand.manager.e
    /* renamed from: w0, reason: merged with bridge method [inline-methods] */
    public i x() {
        return this.f263863d0;
    }

    public ExpandUserInfo x0(String str) {
        EntityManager entityManager;
        if (TextUtils.isEmpty(str) || (entityManager = this.H) == null || !entityManager.isOpen()) {
            return null;
        }
        return (ExpandUserInfo) DBMethodProxy.find(this.H, (Class<? extends Entity>) ExpandUserInfo.class, str);
    }

    @Override // com.tencent.mobileqq.qqexpand.manager.e
    public boolean y() {
        return ((!this.X.g() || this.X.b() == null) ? 1 : this.X.b().matchChatIceBreakSwitch) == 1;
    }

    @Override // com.tencent.mobileqq.qqexpand.manager.e
    public String z() {
        if (TextUtils.isEmpty(this.E)) {
            String valueOf = String.valueOf(A0());
            int length = valueOf.length() + (valueOf.length() / 3);
            int length2 = valueOf.length() % 3;
            if (length2 == 0) {
                length2 += 3;
                length--;
            }
            char[] cArr = new char[length];
            int i3 = 0;
            for (int i16 = 0; i16 < length; i16++) {
                if (i16 == length2) {
                    length2 += 4;
                    cArr[i16] = ',';
                    i3++;
                } else {
                    cArr[i16] = valueOf.charAt(i16 - i3);
                }
            }
            this.E = new String(cArr);
        }
        return this.E;
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class d extends ExpandObserver {
        d() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqexpand.network.ExpandObserver
        public void b(boolean z16) {
            if (z16) {
                ExpandManager.this.R0();
            }
        }
    }

    @Override // com.tencent.mobileqq.qqexpand.manager.e
    public void D(String str, Bundle bundle) {
        ExpandUserInfo o16 = o(str, true);
        if (o16 == null) {
            o16 = new ExpandUserInfo();
        }
        o16.uin = str;
        o16.fromType = bundle.getInt(IProfileCardConst.KEY_FROM_TYPE, 3);
        m(o16);
    }

    @Override // com.tencent.mobileqq.qqexpand.manager.e
    public void b() {
        J0(false);
        QQAppInterface qQAppInterface = this.f263871i;
        if (qQAppInterface != null) {
            ((ExpandHandlerImpl) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER)).X2();
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class a implements DialogInterface.OnKeyListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f263881d;

        a(Activity activity) {
            this.f263881d = activity;
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i3, KeyEvent keyEvent) {
            if (i3 != 4) {
                return false;
            }
            dialogInterface.dismiss();
            this.f263881d.finish();
            return true;
        }
    }

    private void L0(oidb_0xdb1$SchoolInfo oidb_0xdb1_schoolinfo) {
        String str;
        if (oidb_0xdb1_schoolinfo != null) {
            i iVar = new i();
            this.f263863d0 = iVar;
            iVar.f260182a = oidb_0xdb1_schoolinfo.uint32_idx.has() ? oidb_0xdb1_schoolinfo.uint32_idx.get() : 0;
            this.f263863d0.f260183b = oidb_0xdb1_schoolinfo.uint32_category.has() ? oidb_0xdb1_schoolinfo.uint32_category.get() : 0;
            i iVar2 = this.f263863d0;
            String str2 = "";
            if (!oidb_0xdb1_schoolinfo.str_school_id.has()) {
                str = "";
            } else {
                str = oidb_0xdb1_schoolinfo.str_school_id.get();
            }
            iVar2.f260184c = str;
            i iVar3 = this.f263863d0;
            if (oidb_0xdb1_schoolinfo.str_school_name.has()) {
                str2 = oidb_0xdb1_schoolinfo.str_school_name.get();
            }
            iVar3.f260185d = str2;
            return;
        }
        this.f263863d0 = null;
    }

    public void P0(List<String> list, List<String> list2) {
        if (list2 != null) {
            this.J.clear();
            this.J.addAll(list2);
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class c extends ProfileCardObserver {
        c() {
        }

        @Override // com.tencent.mobileqq.profilecard.observer.ProfileCardObserver
        protected void onSetProfileDetail(boolean z16, int i3, Card card) {
            if (z16 && i3 == 0) {
                ExpandManager.this.R0();
            }
        }
    }

    private void v0(Context context, g gVar) {
        if (gVar == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendManager", 2, "getExtendFriendLocationInfoAsync start");
        }
        if (NetworkUtil.isNetSupport(context) && F0()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f263874k0 < 3600000) {
                if (QLog.isColorLevel()) {
                    QLog.d("ExtendFriendManager", 2, "getExtendFriendLocationInfoAsync get cache");
                }
                SosoLbsInfo cachedLbsInfo = ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("extend_friend");
                if (cachedLbsInfo != null && cachedLbsInfo.mLocation != null) {
                    m0(true, cachedLbsInfo, gVar);
                    return;
                }
            }
            this.f263874k0 = currentTimeMillis;
            ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).startLocation(new f("extend_friend", false, gVar));
            return;
        }
        m0(false, null, gVar);
    }

    @Override // com.tencent.mobileqq.qqexpand.manager.e
    public void S(BusinessInfoCheckUpdate.AppInfo appInfo) {
        if (appInfo == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendManager", 2, String.format("updateTianShuWaveStatus iNewFlag: %d , exposure_max: %d", Integer.valueOf(appInfo.iNewFlag.get()), Integer.valueOf(appInfo.exposure_max.get())));
        }
        if (appInfo.iNewFlag.get() != 0 && appInfo.exposure_max.get() >= 0) {
            JSONObject C0 = C0(appInfo);
            if (C0 != null) {
                try {
                    this.S = C0.optJSONObject("waves").optString("waves_type");
                    QLog.i("ExtendFriendManager", 1, "TianShuSrcInfo: " + C0.toString());
                    return;
                } catch (Throwable th5) {
                    QLog.e("ExtendFriendManager", 1, "updateTianShuWaveStatus() JSONException ", th5);
                }
            }
            this.S = "";
            return;
        }
        this.S = "";
    }

    @Override // com.tencent.mobileqq.qqexpand.manager.e
    public boolean A(Activity activity, BaseQQAppInterface baseQQAppInterface) {
        int z06;
        if (activity == null || baseQQAppInterface == null || activity.isFinishing() || (z06 = z0(baseQQAppInterface)) == 0) {
            return false;
        }
        long y06 = y0(baseQQAppInterface) - NetConnInfoCenter.getServerTime();
        boolean z16 = z06 != 1 || y06 > 8640000;
        if (!z16 && y06 <= 0) {
            M0(baseQQAppInterface, 0, 0L);
            return false;
        }
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(activity, 230);
        createCustomDialog.setTitle(activity.getString(R.string.f198614n7)).setMessage(((IExpandForbiddenUtils) QRoute.api(IExpandForbiddenUtils.class)).getForbidDialogMessage(activity, activity.getString(R.string.f198584n4), z16, y06, true)).setPositiveButton(activity.getString(R.string.f198574n3), new b(activity)).setOnKeyListener(new a(activity));
        createCustomDialog.show();
        ReportController.o(baseQQAppInterface, "dc00898", "", "", "0X800B076", "0X800B076", (int) (y06 / 86400), 0, "", "", "", "");
        return true;
    }

    private void S0(boolean z16) {
    }

    @Override // com.tencent.mobileqq.qqexpand.manager.e
    public void M(boolean z16) {
    }

    @Override // com.tencent.mobileqq.qqexpand.manager.e
    public void R(int i3) {
    }

    @Override // com.tencent.mobileqq.qqexpand.manager.e
    public void b0(boolean z16) {
    }

    private void n0() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p0() {
    }

    private static void M0(BaseQQAppInterface baseQQAppInterface, int i3, long j3) {
    }
}
