package com.tencent.timi.game.liveroom.impl.room.report;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.ams.adcore.mma.api.Global;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataRoomAttr;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataUserInfo;
import com.tencent.mobileqq.qqlive.data.login.LoginInfo;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.timi.game.liveroom.impl.room.report.a;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes26.dex */
public class AnchorQualityHelper {

    /* renamed from: j, reason: collision with root package name */
    private int f378440j;

    /* renamed from: k, reason: collision with root package name */
    private String f378441k;

    /* renamed from: l, reason: collision with root package name */
    private String f378442l;

    /* renamed from: n, reason: collision with root package name */
    @RoomMode
    private String f378444n;

    /* renamed from: s, reason: collision with root package name */
    private String f378449s;

    /* renamed from: a, reason: collision with root package name */
    private String f378431a = null;

    /* renamed from: b, reason: collision with root package name */
    private String f378432b = null;

    /* renamed from: c, reason: collision with root package name */
    private String f378433c = null;

    /* renamed from: d, reason: collision with root package name */
    private String f378434d = null;

    /* renamed from: e, reason: collision with root package name */
    private String f378435e = null;

    /* renamed from: f, reason: collision with root package name */
    private long f378436f = 0;

    /* renamed from: g, reason: collision with root package name */
    private String f378437g = null;

    /* renamed from: h, reason: collision with root package name */
    private long f378438h = 0;

    /* renamed from: i, reason: collision with root package name */
    private String f378439i = null;

    /* renamed from: m, reason: collision with root package name */
    private int f378443m = 0;

    /* renamed from: o, reason: collision with root package name */
    private long f378445o = 0;

    /* renamed from: p, reason: collision with root package name */
    private String f378446p = "null";

    /* renamed from: q, reason: collision with root package name */
    private String f378447q = "null";

    /* renamed from: r, reason: collision with root package name */
    private long f378448r = 0;

    /* renamed from: t, reason: collision with root package name */
    private long f378450t = 0;

    /* renamed from: u, reason: collision with root package name */
    private long f378451u = 0;

    /* renamed from: v, reason: collision with root package name */
    private long f378452v = 0;

    /* renamed from: w, reason: collision with root package name */
    private String f378453w = "";

    /* renamed from: x, reason: collision with root package name */
    private long f378454x = 0;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public @interface RoomMode {
        public static final String ECOMMERCE = "ecommerce";
        public static final String NORMAL = "normal";
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public @interface RoomType {
        public static final String END_LIVE = "end_live";
        public static final String GOTO_BACK = "goto_back";
        public static final String GOTO_FRONT = "goto_front";
        public static final String LIVE_SUSPEND = "live_suspend";
        public static final String START_AV_CHAT = "start_av_chat";
        public static final String START_AV_CHAT_FAIL = "start_av_chat_fail";
        public static final String START_LIVE = "start_live";
        public static final String START_LIVE_FAIL = "start_live_fail";
        public static final String STOP_AV_CHAT = "stop_av_chat";
        public static final String STOP_AV_CHAT_FAIL = "stop_av_chat_fail";
    }

    private String a(Context context) {
        if (context != null) {
            try {
                return InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 16384).versionName;
            } catch (Exception e16) {
                QLog.e("AnchorQualityHelper", 1, e16.getLocalizedMessage());
                return "unknown";
            }
        }
        return "";
    }

    private String c() {
        switch (NetworkUtil.getNetWorkType()) {
            case 1:
                return Global.TRACKING_WIFI;
            case 2:
                return Constants.MMCCID;
            case 3:
                return Constants.EMULATOR_INFO;
            case 4:
                return Constants.DEBUG_INFO;
            case 5:
                return "CABLE";
            case 6:
                return Constants.ELECTRONIC_INFO;
            default:
                return "NONE";
        }
    }

    private void f() {
        final a t16 = new a.C9952a().x(this.f378431a).C(this.f378432b).D(this.f378433c).M(this.f378434d).J(this.f378435e).F(this.f378436f).H(this.f378437g).v(this.f378438h).w(this.f378439i).I(this.f378443m).y(this.f378445o).u(this.f378446p).A(this.f378447q).G(this.f378444n).E(this.f378441k).z(this.f378440j).B(this.f378442l).K(this.f378448r).L(this.f378449s).t();
        Objects.requireNonNull(t16);
        h(new Runnable() { // from class: tk4.b
            @Override // java.lang.Runnable
            public final void run() {
                com.tencent.timi.game.liveroom.impl.room.report.a.this.a();
            }
        });
    }

    public void b(Context context) {
        this.f378432b = DeviceInfoMonitor.getModel();
        this.f378431a = Build.BRAND;
        this.f378433c = c();
        this.f378434d = a(context);
        this.f378435e = AppSetting.f99554n;
    }

    public void d() {
        this.f378450t = System.currentTimeMillis();
        this.f378445o = 0L;
        this.f378446p = "start_live";
        f();
    }

    public void e() {
        if (this.f378454x > 0 && !TextUtils.isEmpty(this.f378453w)) {
            g(this.f378453w);
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.f378451u = currentTimeMillis;
        long j3 = this.f378450t;
        if (j3 != 0) {
            this.f378445o = currentTimeMillis - j3;
            this.f378450t = 0L;
        } else {
            this.f378445o = 0L;
        }
        this.f378446p = "end_live";
        f();
    }

    public void g(String str) {
        this.f378445o = System.currentTimeMillis() - this.f378454x;
        this.f378446p = "stop_av_chat";
        this.f378447q = str;
        f();
        this.f378454x = 0L;
        this.f378453w = "";
    }

    void h(Runnable runnable) {
        ThreadManagerV2.excute(runnable, 128, null, true);
    }

    public void i(QQLiveAnchorRoomInfo qQLiveAnchorRoomInfo, LoginInfo loginInfo) {
        QQLiveAnchorDataRoomAttr qQLiveAnchorDataRoomAttr;
        int i3;
        String str;
        LiveUserInfo liveUserInfo;
        if (qQLiveAnchorRoomInfo != null && (qQLiveAnchorDataRoomAttr = qQLiveAnchorRoomInfo.roomAttr) != null) {
            this.f378436f = qQLiveAnchorDataRoomAttr.roomId;
            this.f378437g = qQLiveAnchorDataRoomAttr.roomName;
            if (qQLiveAnchorDataRoomAttr.liveRoomType == 0) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            this.f378443m = i3;
            if (qQLiveAnchorDataRoomAttr.isECGoodsLive) {
                str = "ecommerce";
            } else {
                str = "normal";
            }
            this.f378444n = str;
            this.f378441k = qQLiveAnchorRoomInfo.roomData.programId;
            QQLiveAnchorDataUserInfo qQLiveAnchorDataUserInfo = qQLiveAnchorRoomInfo.userDta;
            long j3 = qQLiveAnchorDataUserInfo.f271213id;
            this.f378438h = j3;
            String str2 = qQLiveAnchorDataUserInfo.nickName;
            this.f378439i = str2;
            if (loginInfo != null && (liveUserInfo = loginInfo.userInfo) != null) {
                if (j3 == 0) {
                    this.f378438h = liveUserInfo.uid;
                }
                if (TextUtils.isEmpty(str2)) {
                    this.f378439i = loginInfo.userInfo.nick;
                }
            }
        }
    }
}
