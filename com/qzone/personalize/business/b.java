package com.qzone.personalize.business;

import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.model.AvatarCacheData;
import com.qzone.common.event.EventCenter;
import com.qzone.component.cache.database.DbCacheManager;
import com.qzone.component.cache.database.c;
import com.qzone.homepage.business.model.CmActionListData;
import com.qzone.homepage.business.model.QzoneCustomTrackData;
import com.qzone.personalize.floatobject.business.model.FloatCacheData;
import com.qzone.personalize.model.CustomFriendNaviData;
import com.qzone.personalize.model.CustomHighFiveData;
import com.qzone.personalize.model.CustomNaviCacheData;
import com.qzone.personalize.model.CustomPlayerData;
import com.qzone.proxy.personalitycomponent.util.QzoneVipDataMMKVUtil;
import com.qzone.util.al;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.util.QZLog;
import cooperation.vip.manager.MonitorManager;
import java.util.WeakHashMap;
import n7.a;

/* compiled from: P */
/* loaded from: classes39.dex */
public class b {

    /* renamed from: u, reason: collision with root package name */
    public static String f49179u = "leftHighFiveResUrl";

    /* renamed from: v, reason: collision with root package name */
    public static String f49180v = "rightHighFiveResUrl";

    /* renamed from: w, reason: collision with root package name */
    public static String f49181w = "https://d3g.qq.com/sngapp/app/update/20181107171919_6759/default_master.zip";

    /* renamed from: x, reason: collision with root package name */
    public static String f49182x = "https://d3g.qq.com/sngapp/app/update/20181107171908_4538/default_guest.zip";

    /* renamed from: y, reason: collision with root package name */
    private static final al<b, Void> f49183y = new a();

    /* renamed from: e, reason: collision with root package name */
    private CustomFriendNaviData f49188e;

    /* renamed from: f, reason: collision with root package name */
    private CustomHighFiveData f49189f;

    /* renamed from: g, reason: collision with root package name */
    private QzoneCustomTrackData f49190g;

    /* renamed from: h, reason: collision with root package name */
    private CmActionListData f49191h;

    /* renamed from: a, reason: collision with root package name */
    private AvatarCacheData f49184a = null;

    /* renamed from: b, reason: collision with root package name */
    private AnimationDrawable f49185b = null;

    /* renamed from: c, reason: collision with root package name */
    private String f49186c = "";

    /* renamed from: d, reason: collision with root package name */
    private boolean f49187d = true;

    /* renamed from: i, reason: collision with root package name */
    private String f49192i = QzoneConfig.getInstance().getConfig("QZoneSetting", f49179u, f49182x);

    /* renamed from: j, reason: collision with root package name */
    private String f49193j = QzoneConfig.getInstance().getConfig("QZoneSetting", f49180v, f49181w);

    /* renamed from: k, reason: collision with root package name */
    private WeakHashMap<Integer, Bitmap> f49194k = new WeakHashMap<>();

    /* renamed from: l, reason: collision with root package name */
    private boolean f49195l = VasNormalToggle.QZONE_SP_MOVE_SWITCH_2.isEnable(true);

    /* renamed from: m, reason: collision with root package name */
    private final C0416b f49196m = new C0416b("TABLE_CUSTOM", CustomNaviCacheData.class);

    /* renamed from: n, reason: collision with root package name */
    private final C0416b f49197n = new C0416b("table_avatar", AvatarCacheData.class);

    /* renamed from: o, reason: collision with root package name */
    private final C0416b f49198o = new C0416b("table_floatitem", FloatCacheData.class);

    /* renamed from: p, reason: collision with root package name */
    private final C0416b f49199p = new C0416b("TABLE_CUSTOM_PLAYER", CustomPlayerData.class);

    /* renamed from: q, reason: collision with root package name */
    private final C0416b f49200q = new C0416b("TABLE_CUSTOM_FRIEND_NAVIDECO", CustomFriendNaviData.class);

    /* renamed from: r, reason: collision with root package name */
    private final C0416b f49201r = new C0416b("TABLE_HIGH_FIVE", CustomHighFiveData.class);

    /* renamed from: s, reason: collision with root package name */
    private final C0416b f49202s = new C0416b("TABLE_CUSTOM_TRACK", QzoneCustomTrackData.class);

    /* renamed from: t, reason: collision with root package name */
    private final C0416b f49203t = new C0416b("TABLE_CM_ACTION_LIST", CmActionListData.class);

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a extends al<b, Void> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.qzone.util.al
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public b a(Void r16) {
            return new b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.qzone.personalize.business.b$b, reason: collision with other inner class name */
    /* loaded from: classes39.dex */
    public static final class C0416b {

        /* renamed from: a, reason: collision with root package name */
        long f49204a;

        /* renamed from: b, reason: collision with root package name */
        DbCacheManager f49205b;

        /* renamed from: c, reason: collision with root package name */
        String f49206c;

        /* renamed from: d, reason: collision with root package name */
        Class<? extends com.qzone.component.cache.database.a> f49207d;

        /* renamed from: e, reason: collision with root package name */
        a.InterfaceC10828a f49208e = new a();

        /* compiled from: P */
        /* renamed from: com.qzone.personalize.business.b$b$a */
        /* loaded from: classes39.dex */
        class a implements a.InterfaceC10828a {
            a() {
            }

            @Override // n7.a.InterfaceC10828a
            public void onClosed(n7.a aVar) {
                C0416b c0416b = C0416b.this;
                c0416b.f49204a = 0L;
                c0416b.f49205b = null;
            }
        }

        public C0416b(String str, Class<? extends com.qzone.component.cache.database.a> cls) {
            this.f49206c = str;
            this.f49207d = cls;
        }
    }

    public b() {
        B();
    }

    private DbCacheManager h(C0416b c0416b) {
        a(c0416b);
        return c0416b.f49205b;
    }

    private DbCacheManager m() {
        return h(this.f49200q);
    }

    public static b n() {
        return f49183y.get(null);
    }

    private DbCacheManager p() {
        return h(this.f49196m);
    }

    public void B() {
        this.f49187d = LocalMultiProcConfig.getBool(LocalMultiProcConfig.QZONE_FEED_CUSTOM_BROWSER_DECO_SWITCH, true);
    }

    public AvatarCacheData c(long j3) {
        AvatarCacheData avatarCacheData;
        synchronized (this.f49197n) {
            a(this.f49197n);
            avatarCacheData = (AvatarCacheData) this.f49197n.f49205b.k0("uin=?", new String[]{"" + j3});
            if (QZLog.isColorLevel()) {
                QZLog.d("QzoneCustomService", 2, "getAvatarIntoCache for mUin:" + j3 + " cacheData:" + avatarCacheData);
            }
        }
        return avatarCacheData;
    }

    public boolean d() {
        return this.f49187d;
    }

    public CustomHighFiveData e(long j3) {
        CustomHighFiveData customHighFiveData;
        CustomHighFiveData customHighFiveData2;
        if (j3 == LoginData.getInstance().getUin() && (customHighFiveData2 = this.f49189f) != null) {
            return customHighFiveData2;
        }
        if (VasNormalToggle.QZONE_SP_MOVE_SWITCH.isEnable(true)) {
            return QzoneVipDataMMKVUtil.INSTANCE.getCustomHighFiveData(j3);
        }
        synchronized (this.f49201r) {
            a(this.f49201r);
            customHighFiveData = (CustomHighFiveData) this.f49201r.f49205b.k0("uin=?", new String[]{"" + j3});
        }
        return customHighFiveData;
    }

    public CustomPlayerData f(long j3) {
        CustomPlayerData customPlayerData;
        synchronized (this.f49199p) {
            a(this.f49199p);
            customPlayerData = (CustomPlayerData) this.f49199p.f49205b.k0("uin=?", new String[]{"" + j3});
        }
        return customPlayerData;
    }

    public QzoneCustomTrackData g(long j3) {
        QzoneCustomTrackData qzoneCustomTrackData;
        QzoneCustomTrackData qzoneCustomTrackData2;
        if (j3 == LoginData.getInstance().getUin() && (qzoneCustomTrackData2 = this.f49190g) != null) {
            return qzoneCustomTrackData2;
        }
        synchronized (this.f49202s) {
            a(this.f49202s);
            qzoneCustomTrackData = (QzoneCustomTrackData) this.f49202s.f49205b.k0("uin=?", new String[]{"" + j3});
        }
        return qzoneCustomTrackData;
    }

    public String i() {
        return this.f49192i;
    }

    public String j() {
        return this.f49193j;
    }

    public FloatCacheData k(long j3) {
        FloatCacheData floatCacheData;
        if (this.f49195l) {
            return QzoneVipDataMMKVUtil.INSTANCE.getFloatItemFromCache(j3);
        }
        synchronized (this.f49198o) {
            a(this.f49198o);
            floatCacheData = (FloatCacheData) this.f49198o.f49205b.k0("uin=?", new String[]{"" + j3});
        }
        return floatCacheData;
    }

    public CustomFriendNaviData l(long j3) {
        CustomFriendNaviData customFriendNaviData;
        CustomFriendNaviData customFriendNaviData2;
        if (j3 == LoginData.getInstance().getUin() && (customFriendNaviData2 = this.f49188e) != null) {
            return customFriendNaviData2;
        }
        DbCacheManager m3 = m();
        if (m3 != null) {
            customFriendNaviData = (CustomFriendNaviData) m3.k0("uin=?", new String[]{j3 + ""});
        } else {
            customFriendNaviData = null;
        }
        this.f49188e = customFriendNaviData;
        return customFriendNaviData;
    }

    public CustomNaviCacheData o(long j3) {
        DbCacheManager p16 = p();
        if (p16 == null) {
            return null;
        }
        return (CustomNaviCacheData) p16.k0("uin=?", new String[]{j3 + ""});
    }

    public void x(long j3, String str) {
        FloatCacheData createFromJsonString = FloatCacheData.createFromJsonString(j3, str);
        y(createFromJsonString);
        EventCenter.getInstance().post("Personalize", 11, createFromJsonString);
    }

    public static boolean q(CustomNaviCacheData customNaviCacheData) {
        return (customNaviCacheData == null || customNaviCacheData.itemId == -1 || QQTheme.isNowThemeIsNightForQzone()) ? false : true;
    }

    public static boolean r(CustomFriendNaviData customFriendNaviData) {
        return (customFriendNaviData == null || customFriendNaviData.iItemId == -1 || QQTheme.isNowThemeIsNightForQzone()) ? false : true;
    }

    public void s(CustomFriendNaviData customFriendNaviData) {
        if (customFriendNaviData == null) {
            QZLog.i("QzoneCustomService", "@newnavi cacheData is null");
            return;
        }
        this.f49188e = customFriendNaviData;
        DbCacheManager m3 = m();
        if (m3 != null) {
            m3.r0("uin=?");
            m3.t0(new String[]{"" + customFriendNaviData.uin});
            m3.o0(customFriendNaviData, 2);
        }
    }

    public void t(AvatarCacheData avatarCacheData) {
        if (avatarCacheData != null) {
            synchronized (this.f49197n) {
                a(this.f49197n);
                this.f49197n.f49205b.r0("uin=?");
                this.f49197n.f49205b.t0(new String[]{"" + avatarCacheData.uin});
                this.f49197n.f49205b.o0(avatarCacheData, 2);
                if (QZLog.isColorLevel()) {
                    QZLog.d("QzoneCustomService", 2, "saveAvatarIntoCache for uin:" + avatarCacheData.uin + " avatar:" + avatarCacheData);
                }
                if (LoginData.getInstance().getUin() == avatarCacheData.uin) {
                    this.f49184a = avatarCacheData;
                }
            }
        }
    }

    public void u(CmActionListData cmActionListData) {
        if (cmActionListData != null) {
            this.f49191h = cmActionListData;
            synchronized (cmActionListData) {
                try {
                    a(this.f49203t);
                    this.f49203t.f49205b.r0("uin=?");
                    this.f49203t.f49205b.t0(new String[]{"" + cmActionListData.uin});
                    this.f49203t.f49205b.o0(cmActionListData, 2);
                } catch (Exception e16) {
                    QZLog.e("QzoneCustomService", "saveCmActionListDataToCache exception.", e16);
                }
            }
        }
    }

    public void v(CustomPlayerData customPlayerData) {
        if (customPlayerData != null) {
            synchronized (this.f49199p) {
                try {
                    a(this.f49199p);
                    this.f49199p.f49205b.r0("uin=?");
                    this.f49199p.f49205b.t0(new String[]{"" + customPlayerData.uin});
                    this.f49199p.f49205b.o0(customPlayerData, 2);
                } catch (NullPointerException e16) {
                    MonitorManager.f().h(6, 9, " save data exception " + e16, false);
                    QZLog.w("QzoneCustomService", "saveFloatIntoCache NPE.", e16);
                }
            }
            EventCenter.getInstance().post("CustomPlayer", 1, customPlayerData);
        }
    }

    public void w(QzoneCustomTrackData qzoneCustomTrackData) {
        if (qzoneCustomTrackData == null || qzoneCustomTrackData.iItemId == 0) {
            return;
        }
        this.f49190g = qzoneCustomTrackData;
        synchronized (qzoneCustomTrackData) {
            try {
                a(this.f49202s);
                this.f49202s.f49205b.r0("uin=?");
                this.f49202s.f49205b.t0(new String[]{"" + qzoneCustomTrackData.uin});
                this.f49202s.f49205b.o0(qzoneCustomTrackData, 2);
            } catch (NullPointerException e16) {
                QZLog.w("QzoneCustomService", "saveCustomTrackDataToCache NPE.", e16);
            }
        }
    }

    public void y(FloatCacheData floatCacheData) {
        if (floatCacheData != null) {
            if (this.f49195l) {
                QzoneVipDataMMKVUtil.INSTANCE.saveFloatIntoCache(floatCacheData);
                return;
            }
            synchronized (this.f49198o) {
                try {
                    a(this.f49198o);
                    this.f49198o.f49205b.r0("uin=?");
                    this.f49198o.f49205b.t0(new String[]{"" + floatCacheData.uin});
                    this.f49198o.f49205b.o0(floatCacheData, 2);
                } catch (NullPointerException e16) {
                    MonitorManager.f().h(8, 9, " save data exception " + e16, false);
                    QZLog.w("QzoneCustomService", "saveFloatIntoCache NPE.", e16);
                }
            }
        }
    }

    public void z(CustomHighFiveData customHighFiveData) {
        CustomHighFiveData customHighFiveData2;
        if (customHighFiveData != null && (customHighFiveData2 = this.f49189f) != null && customHighFiveData2.equals(customHighFiveData)) {
            QZLog.i("QzoneCustomService", "saveHighFiveDataInToCache data same");
            return;
        }
        this.f49189f = customHighFiveData;
        if (customHighFiveData != null) {
            if (VasNormalToggle.QZONE_SP_MOVE_SWITCH.isEnable(true)) {
                QzoneVipDataMMKVUtil.INSTANCE.saveCustomHighFiveData(customHighFiveData);
                return;
            }
            synchronized (customHighFiveData) {
                try {
                    a(this.f49201r);
                    this.f49201r.f49205b.r0("uin=?");
                    this.f49201r.f49205b.t0(new String[]{"" + customHighFiveData.uin});
                    this.f49201r.f49205b.o0(customHighFiveData, 2);
                } catch (NullPointerException e16) {
                    MonitorManager.f().h(14, 9, " save data exception " + e16, false);
                    QZLog.w("QzoneCustomService", "saveFloatIntoCache NPE.", e16);
                }
            }
        }
    }

    private void a(C0416b c0416b) {
        DbCacheManager dbCacheManager;
        if (c0416b == null) {
            return;
        }
        long uin = LoginData.getInstance().getUin();
        if (uin != c0416b.f49204a || (dbCacheManager = c0416b.f49205b) == null || dbCacheManager.isClosed()) {
            c0416b.f49204a = uin;
            DbCacheManager e16 = c.g().e(c0416b.f49207d, uin, c0416b.f49206c);
            c0416b.f49205b = e16;
            e16.U(c0416b.f49208e);
        }
    }

    public void A(CustomNaviCacheData customNaviCacheData) {
        DbCacheManager p16;
        if (customNaviCacheData == null || (p16 = p()) == null) {
            return;
        }
        p16.r0("uin=?");
        p16.t0(new String[]{"" + customNaviCacheData.uin});
        p16.o0(customNaviCacheData, 2);
    }

    public static boolean b(CustomFriendNaviData customFriendNaviData, CustomFriendNaviData customFriendNaviData2) {
        return (customFriendNaviData == null || customFriendNaviData2 == null) ? customFriendNaviData == null && customFriendNaviData2 == null : customFriendNaviData.iItemId == customFriendNaviData2.iItemId;
    }
}
