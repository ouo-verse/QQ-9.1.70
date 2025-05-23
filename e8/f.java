package e8;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import com.huawei.hms.framework.common.ContainerUtils;
import com.qzone.common.account.LoginData;
import com.qzone.personalize.music.business.QusicService;
import com.qzone.personalize.music.model.UserMusicInfo;
import com.qzone.personalize.music.ui.FriendMusicPlayerBar;
import com.qzone.personalize.music.ui.HomepageMusicPlayerBar;
import com.qzone.personalize.music.ui.MusicPlayerDIYBar;
import com.qzone.util.ToastUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.music.BroadcastMusicInfo;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.musicgene.MusicPlayerActivity;
import com.tencent.qphone.base.util.BaseApplication;
import common.config.service.QzoneConfig;
import cooperation.qzone.cache.CacheManager;
import cooperation.qzone.music.QzoneMusicConst;
import cooperation.qzone.util.QZLog;
import e8.e;
import java.util.List;

/* compiled from: P */
/* loaded from: classes38.dex */
public class f {

    /* renamed from: c, reason: collision with root package name */
    protected static String f395863c = "QQMusicManager";

    /* renamed from: d, reason: collision with root package name */
    private static f f395864d = null;

    /* renamed from: e, reason: collision with root package name */
    private static Object f395865e = new Object();

    /* renamed from: f, reason: collision with root package name */
    public static long f395866f = -1;

    /* renamed from: g, reason: collision with root package name */
    public static String f395867g = "";

    /* renamed from: a, reason: collision with root package name */
    d f395868a = new a();

    /* renamed from: b, reason: collision with root package name */
    c f395869b = new b();

    /* compiled from: P */
    /* loaded from: classes38.dex */
    class a implements d {
        a() {
        }

        private Intent l(long j3, String str, String str2) {
            if (TextUtils.isEmpty(str2)) {
                QZLog.w(f.f395863c, "go FM List TextUtils.isEmpty(url)");
                return null;
            }
            String str3 = str2 + "#t=" + System.currentTimeMillis();
            if (!TextUtils.isEmpty(str)) {
                try {
                    if (str3.indexOf("#") != -1) {
                        str3 = str3.replaceFirst("#", ContainerUtils.FIELD_DELIMITER + str + "#");
                    }
                } catch (Exception e16) {
                    QZLog.e(QZLog.TO_DEVICE_TAG, "QQmusicMangeer replace  " + str3 + "  " + e16.toString());
                }
            }
            Intent intent = new Intent(BaseApplication.getContext(), (Class<?>) QQBrowserDelegationActivity.class);
            intent.putExtra("url", str3);
            intent.putExtra("fromQZone", true);
            intent.putExtra("injectrecommend", true);
            intent.putExtra("source_name", BaseApplication.getContext().getString(R.string.ghh));
            yo.b.a(intent);
            return intent;
        }

        @Override // e8.d
        public Intent b(long j3, String str) {
            if (f.e()) {
                f.f("\u97f3\u4e50\u64ad\u653e\u9700android2.2\u53ca\u4ee5\u4e0a\u7248\u672c\u652f\u6301");
                QZLog.w(f.f395863c, "go FM List TIPS_LOW_VERSION");
                return null;
            }
            String config = QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_BG_FM_BROCAST_MANAGER_URL, "https://fm.qzone.qq.com/bgmusic/index?_wv=2097155&appUrl=2130&sourceInfo=adpos%3D10030%26exp_id%3D0%26ts%3D&uin={loginuin}&guestuin={guestuin}");
            String uinString = LoginData.getInstance().getUinString();
            if (uinString == null) {
                uinString = "";
            }
            String replace = config.replace("{loginuin}", uinString);
            String valueOf = String.valueOf(j3);
            return l(j3, str, replace.replace("{guestuin}", valueOf != null ? valueOf : ""));
        }

        @Override // e8.d
        public Intent c(String str) {
            if (f.e()) {
                f.f("\u97f3\u4e50\u64ad\u653e\u9700android2.2\u53ca\u4ee5\u4e0a\u7248\u672c\u652f\u6301");
                QZLog.w(f.f395863c, "goQQMusicPlayer TIPS_LOW_VERSION");
                return null;
            }
            if (TextUtils.isEmpty(str)) {
                QZLog.w(f.f395863c, "goMusicPlayer TextUtils.isEmpty(url)");
                return null;
            }
            Intent intent = new Intent(BaseApplication.getContext(), (Class<?>) MusicPlayerActivity.class);
            intent.putExtra("url", str);
            intent.putExtra("fromQZone", true);
            intent.putExtra("injectrecommend", true);
            intent.putExtra("source_name", BaseApplication.getContext().getString(R.string.ghh));
            intent.setData(Uri.parse(str));
            if (QZLog.isDevelopLevel()) {
                QZLog.d(f.f395863c, 4, "\u64ad\u653eurl\uff1a" + str);
            }
            return intent;
        }

        @Override // e8.d
        public Intent d(String str) {
            Intent intent = new Intent(BaseApplication.getContext(), (Class<?>) QQBrowserDelegationActivity.class);
            intent.putExtra("url", str);
            intent.putExtra("fromQZone", true);
            yo.b.a(intent);
            return intent;
        }

        @Override // e8.d
        public Intent e(long j3, String str) {
            if (f.e()) {
                f.f("\u97f3\u4e50\u64ad\u653e\u9700android2.2\u53ca\u4ee5\u4e0a\u7248\u672c\u652f\u6301");
                QZLog.w(f.f395863c, "goQQMusicList TIPS_LOW_VERSION");
                return null;
            }
            String config = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_BG_MUSIC_MANAGER_URL, "https://y.qq.com/m/qzonemusic/mqzindex.html?uin={uin}&guestuin={guestuin}&sid={SID}&qqsc=qqbgmusic&_wv=3&_bid=203&supportSetPlayMode=1");
            String uinString = LoginData.getInstance().getUinString();
            if (uinString == null) {
                uinString = "";
            }
            String replace = config.replace("{uin}", uinString);
            String valueOf = String.valueOf(j3);
            return l(j3, str, replace.replace("{guestuin}", valueOf != null ? valueOf : ""));
        }

        @Override // e8.d
        public Intent f(long j3, String str, String str2) {
            if (f.e()) {
                f.f("\u97f3\u4e50\u64ad\u653e\u9700android2.2\u53ca\u4ee5\u4e0a\u7248\u672c\u652f\u6301");
                QZLog.w(f.f395863c, "go QZVIPMusicDetailPage TIPS_LOW_VERSION");
                return null;
            }
            String config = QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_MUSIC_DETAIL_PAGE_FOR_QZVIP_MANAGER_URL, "https://h5.qzone.qq.com/bgmusic/detail?_wv=16777223&_mid={mid}");
            if (str == null) {
                str = "";
            }
            return l(j3, str2, config.replace("{mid}", str));
        }

        @Override // e8.d
        public View g(Context context, long j3, int i3) {
            if (f.e()) {
                return null;
            }
            if (i3 == 1) {
                return new HomepageMusicPlayerBar(context, j3);
            }
            if (i3 != 2) {
                return new HomepageMusicPlayerBar(context, j3);
            }
            return new MusicPlayerDIYBar(context, j3);
        }

        @Override // e8.d
        public Intent i(long j3) {
            if (f.e()) {
                f.f("\u97f3\u4e50\u64ad\u653e\u9700android2.2\u53ca\u4ee5\u4e0a\u7248\u672c\u652f\u6301");
                QZLog.w(f.f395863c, "goQQMusicPlayer TIPS_LOW_VERSION");
                return null;
            }
            String config = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_MUSIC_PLAY_DETAIL_URL, "https://data.music.qq.com/playsong.html?uin={uin}&songid={songid}&sid={SID}&qqsc=qqbgmusic&_wv=3&_bid=203&supportSetPlayMode=1");
            if (TextUtils.isEmpty(config)) {
                QZLog.w(f.f395863c, "goQQMusicPlayer TextUtils.isEmpty(url)");
                return null;
            }
            String valueOf = String.valueOf(LoginData.getInstance().getUin());
            if (valueOf == null) {
                valueOf = "";
            }
            String c16 = yo.f.c(yo.f.u(config.replace("{uin}", valueOf).replace("{songid}", String.valueOf(j3))), 2097152L, true);
            Intent intent = new Intent(BaseApplication.getContext(), (Class<?>) MusicPlayerActivity.class);
            intent.putExtra("url", c16);
            intent.putExtra("fromQZone", true);
            intent.putExtra("injectrecommend", true);
            intent.putExtra("source_name", BaseApplication.getContext().getString(R.string.ghh));
            intent.setData(Uri.parse(c16));
            if (QZLog.isDevelopLevel()) {
                QZLog.d(f.f395863c, 4, "\u64ad\u653eurl\uff1a" + c16);
            }
            return intent;
        }

        @Override // e8.d
        public View j(Context context, e8.b bVar) {
            if (f.e()) {
                return null;
            }
            return new FriendMusicPlayerBar(context, bVar);
        }

        @Override // e8.d
        public Intent k(long j3, String str) {
            if (f.e()) {
                f.f("\u97f3\u4e50\u64ad\u653e\u9700android2.2\u53ca\u4ee5\u4e0a\u7248\u672c\u652f\u6301");
                QZLog.w(f.f395863c, "go QZVIPMusicList TIPS_LOW_VERSION");
                return null;
            }
            String config = QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_BG_MUSIC_FOR_QZVIP_MANAGER_URL, "https://h5.qzone.qq.com/vipbg/music?_wv=3&_uin={uin}");
            String valueOf = String.valueOf(j3);
            if (valueOf == null) {
                valueOf = "";
            }
            return l(j3, str, config.replace("{uin}", valueOf));
        }

        @Override // e8.d
        public void a(View view, List<BroadcastMusicInfo> list, boolean z16, int i3, byte b16, byte b17, int i16, int i17, byte b18) {
            if (!f.e() && (view instanceof HomepageMusicPlayerBar)) {
                ((HomepageMusicPlayerBar) view).R(list, z16, i3, b16, b17, i16, i17, b18);
            }
        }

        @Override // e8.d
        public void h(View view, List<UserMusicInfo> list, boolean z16, int i3, byte b16, byte b17, int i16, int i17, byte b18) {
            if (!f.e() && (view instanceof HomepageMusicPlayerBar)) {
                ((HomepageMusicPlayerBar) view).S(list, z16, i3, b16, b17, i16, i17, b18);
            }
        }
    }

    f() {
    }

    public static f a() {
        if (f395864d == null) {
            synchronized (f395865e) {
                if (f395864d == null) {
                    f395864d = new f();
                }
            }
        }
        return f395864d;
    }

    public static final boolean d() {
        return !CacheManager.isExternalAvailable();
    }

    public static final boolean e() {
        return false;
    }

    public static final void f(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ToastUtil.r(str);
    }

    public c b() {
        return this.f395869b;
    }

    public d c() {
        return this.f395868a;
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    class b implements c {
        b() {
        }

        @Override // e8.c
        public void a() {
            if (f.e()) {
                f.f("\u97f3\u4e50\u64ad\u653e\u9700android2.2\u53ca\u4ee5\u4e0a\u7248\u672c\u652f\u6301");
            } else if (f.d()) {
                f.f("\u97f3\u4e50\u9700\u5b89\u88c5SD\u5361\u624d\u80fd\u64ad\u653e");
            } else {
                QusicService.O().x0();
            }
        }

        @Override // e8.c
        public void b() {
            if (f.e()) {
                f.f("\u97f3\u4e50\u64ad\u653e\u9700android2.2\u53ca\u4ee5\u4e0a\u7248\u672c\u652f\u6301");
            } else if (f.d()) {
                f.f("\u97f3\u4e50\u9700\u5b89\u88c5SD\u5361\u624d\u80fd\u64ad\u653e");
            } else {
                QusicService.O().r0();
            }
        }

        @Override // e8.c
        public void c(String str, String str2, String str3, String str4, String str5, String str6) {
            Intent d16;
            if (f.e()) {
                f.f("\u97f3\u4e50\u64ad\u653e\u9700android2.2\u53ca\u4ee5\u4e0a\u7248\u672c\u652f\u6301");
                return;
            }
            if (f.d()) {
                f.f("\u97f3\u4e50\u9700\u5b89\u88c5SD\u5361\u624d\u80fd\u64ad\u653e");
                return;
            }
            QusicService O = QusicService.O();
            long uin = LoginData.getInstance().getUin();
            if (TextUtils.isEmpty(str6)) {
                d16 = f.this.c().c(str2);
            } else {
                d16 = f.this.c().d(str6);
            }
            O.E(str, str3, uin, d16, str4, str5);
        }

        @Override // e8.c
        public void clear() {
            QusicService.O().C();
        }

        @Override // e8.c
        public void d(List<SongInfo> list, int i3, int i16, long j3, int i17, int i18) {
            if (f.e()) {
                f.f("\u97f3\u4e50\u64ad\u653e\u9700android2.2\u53ca\u4ee5\u4e0a\u7248\u672c\u652f\u6301");
            } else if (f.d()) {
                f.f("\u97f3\u4e50\u9700\u5b89\u88c5SD\u5361\u624d\u80fd\u64ad\u653e");
            } else {
                QusicService.O().h0(list, i3, i16, j3, i17, f.this.c().b(j3, QzoneMusicConst.QusicFrom.HOME_PAGE), i18);
            }
        }

        @Override // e8.c
        public e.a f() {
            if (f.e() || f.d()) {
                return null;
            }
            return QusicService.O().L();
        }

        @Override // e8.c
        public void g(e eVar) {
            QusicService.O().A(eVar, true);
        }

        @Override // e8.c
        public e.a getCurrentState() {
            if (f.e() || f.d()) {
                return null;
            }
            return QusicService.O().M();
        }

        @Override // e8.c
        public void h() {
            if (f.e()) {
                return;
            }
            QusicService.O().m0(LoginData.getInstance().getUin());
        }

        @Override // e8.c
        public void i(SongInfo songInfo, String str, String str2, String str3) {
            if (f.e()) {
                f.f("\u97f3\u4e50\u64ad\u653e\u9700android2.2\u53ca\u4ee5\u4e0a\u7248\u672c\u652f\u6301");
            } else if (f.d()) {
                f.f("\u97f3\u4e50\u9700\u5b89\u88c5SD\u5361\u624d\u80fd\u64ad\u653e");
            } else {
                QusicService.O().D(songInfo, str, LoginData.getInstance().getUin(), f.this.c().i(songInfo.f251867d), str2, str3);
            }
        }

        @Override // e8.c
        public void init() {
            try {
                QusicService.O().X();
            } catch (Throwable th5) {
                QZLog.w(th5);
            }
        }

        @Override // e8.c
        public void j(int i3, int i16, int i17) {
            QusicService.O().s0(i3, i16, i17);
        }

        @Override // e8.c
        public void k(List<SongInfo> list, int i3, int i16, long j3, int i17, int i18) {
            if (f.e()) {
                f.f("\u97f3\u4e50\u64ad\u653e\u9700android2.2\u53ca\u4ee5\u4e0a\u7248\u672c\u652f\u6301");
                return;
            }
            if (f.d()) {
                f.f("\u97f3\u4e50\u9700\u5b89\u88c5SD\u5361\u624d\u80fd\u64ad\u653e");
            } else {
                if (list == null || list.size() <= 0) {
                    return;
                }
                QusicService.O().f0(list, i3, i16, j3, i17, f.this.c().b(j3, QzoneMusicConst.QusicFrom.MINI_BAR), i18);
            }
        }

        @Override // e8.c
        public void l(SongInfo songInfo) {
            Intent i3;
            if (f.e()) {
                f.f("\u97f3\u4e50\u64ad\u653e\u9700android2.2\u53ca\u4ee5\u4e0a\u7248\u672c\u652f\u6301");
                return;
            }
            if (f.d()) {
                f.f("\u97f3\u4e50\u9700\u5b89\u88c5SD\u5361\u624d\u80fd\u64ad\u653e");
                return;
            }
            int i16 = songInfo.I;
            if (i16 == 6) {
                i3 = f.this.c().b(LoginData.getInstance().getUin(), "");
            } else if (i16 == 11) {
                i3 = f.this.c().f(LoginData.getInstance().getUin(), songInfo.E, "");
            } else {
                i3 = f.this.c().i(songInfo.f251867d);
            }
            QusicService.O().g0(songInfo, LoginData.getInstance().getUin(), i3);
        }

        @Override // e8.c
        public void m(SongInfo songInfo) {
            if (f.e()) {
                f.f("\u97f3\u4e50\u64ad\u653e\u9700android2.2\u53ca\u4ee5\u4e0a\u7248\u672c\u652f\u6301");
            } else if (f.d()) {
                f.f("\u97f3\u4e50\u9700\u5b89\u88c5SD\u5361\u624d\u80fd\u64ad\u653e");
            } else {
                QusicService.O().j0(songInfo);
            }
        }

        @Override // e8.c
        public void n(List<SongInfo> list, int i3, int i16, long j3, int i17) {
            if (f.e()) {
                f.f("\u97f3\u4e50\u64ad\u653e\u9700android2.2\u53ca\u4ee5\u4e0a\u7248\u672c\u652f\u6301");
                return;
            }
            if (f.d()) {
                f.f("\u97f3\u4e50\u9700\u5b89\u88c5SD\u5361\u624d\u80fd\u64ad\u653e");
                return;
            }
            if (list != null && list.size() > 0 && list.get(0).I == 8) {
                QusicService.O().i0(list, i3, i16, j3, i17, f.this.c().b(j3, QzoneMusicConst.QusicFrom.HOME_PAGE));
            } else if (list != null && list.size() > 0 && list.get(0).I == 11) {
                QusicService.O().i0(list, i3, i16, j3, i17, f.this.c().k(j3, QzoneMusicConst.QusicFrom.HOME_PAGE));
            } else {
                QusicService.O().i0(list, i3, i16, j3, i17, f.this.c().e(j3, QzoneMusicConst.QusicFrom.HOME_PAGE));
            }
        }

        @Override // e8.c
        public void o(e eVar) {
            QusicService.O().p0(eVar);
        }

        @Override // e8.c
        public void pauseMusic() {
            if (f.e()) {
                f.f("\u97f3\u4e50\u64ad\u653e\u9700android2.2\u53ca\u4ee5\u4e0a\u7248\u672c\u652f\u6301");
            } else if (f.d()) {
                f.f("\u97f3\u4e50\u9700\u5b89\u88c5SD\u5361\u624d\u80fd\u64ad\u653e");
            } else {
                QusicService.O().e0();
            }
        }

        @Override // e8.c
        public void release() {
            QusicService.O().o0();
        }

        @Override // e8.c
        public void setPlayMode(int i3) {
            QusicService.O().u0(i3);
        }

        @Override // e8.c
        public void e(String str, String str2, String str3, String str4, String str5) {
            c(str, str2, str3, str4, str5, null);
        }
    }
}
