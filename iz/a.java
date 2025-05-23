package iz;

import UserGrowth.stCallInfo;
import UserGrowth.stCommentConfig;
import UserGrowth.stGlobalConfig;
import UserGrowth.stJumpInfo;
import UserGrowth.stPopWindowsConfig;
import UserGrowth.stUserAuth;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.biz.pubaccount.weishi.download.b;
import com.tencent.biz.pubaccount.weishi.util.ai;
import com.tencent.biz.pubaccount.weishi.util.x;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private stGlobalConfig f408987a;

    /* renamed from: b, reason: collision with root package name */
    private SparseArray<stGlobalConfig> f408988b = new SparseArray<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* renamed from: iz.a$a, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public static class C10555a {

        /* renamed from: a, reason: collision with root package name */
        private static final a f408989a = new a();
    }

    a() {
    }

    public static a g() {
        return C10555a.f408989a;
    }

    private stPopWindowsConfig k(int i3) {
        ArrayList<stPopWindowsConfig> arrayList;
        stGlobalConfig m3 = m(i3);
        if (m3 == null || (arrayList = m3.windows_config) == null || arrayList.size() <= 0) {
            return null;
        }
        return m3.windows_config.get(0);
    }

    private boolean u() {
        stGlobalConfig stglobalconfig = this.f408987a;
        return stglobalconfig == null || stglobalconfig.download == null;
    }

    private boolean v(int i3) {
        return m(i3) == null || m(i3).linkConfig == null;
    }

    public String a() {
        if (!u()) {
            return this.f408987a.download.packageName;
        }
        return "";
    }

    public int b() {
        if (u()) {
            return 0;
        }
        return this.f408987a.download.vendorId;
    }

    public int c(int i3) {
        if (v(i3)) {
            return 10000;
        }
        return m(i3).linkConfig.callCount;
    }

    public String d() {
        stCommentConfig stcommentconfig;
        stGlobalConfig stglobalconfig = this.f408987a;
        if (stglobalconfig != null && (stcommentconfig = stglobalconfig.commentConfig) != null) {
            return stcommentconfig.guideText;
        }
        return "";
    }

    public int e() {
        if (u()) {
            return 0;
        }
        return this.f408987a.download.versionCode;
    }

    public String f() {
        if (Thread.currentThread().getId() != Looper.getMainLooper().getThread().getId()) {
            String i3 = ai.i("encryptedDeviceId", "");
            x.i("WSGlobalConfigLog", "WSSharePreferencesUtil load encrypted_deviceid:" + i3);
            return i3;
        }
        stGlobalConfig stglobalconfig = this.f408987a;
        if (stglobalconfig != null) {
            String str = stglobalconfig.encrypted_deviceid;
            if (!TextUtils.isEmpty(str)) {
                ai.p("encryptedDeviceId", str);
                x.i("WSGlobalConfigLog", "WSSharePreferencesUtil save encrypted_deviceid:" + str);
                return str;
            }
        }
        String i16 = ai.i("encryptedDeviceId", "");
        x.i("WSGlobalConfigLog", "WSSharePreferencesUtil load encrypted_deviceid:" + i16);
        return i16;
    }

    public stJumpInfo h(int i3) {
        stGlobalConfig m3 = m(i3);
        if (m3 != null) {
            return m3.jumpinfo;
        }
        return null;
    }

    public String i() {
        if (!u()) {
            return this.f408987a.download.downloadUrl;
        }
        return "";
    }

    public String j() {
        if (!u()) {
            if (TextUtils.isEmpty(this.f408987a.download.qqDownloadUrl)) {
                this.f408987a.download.qqDownloadUrl = b.b() + "&versioncode=" + e();
                StringBuilder sb5 = new StringBuilder();
                sb5.append("\u670d\u52a1\u5668\u4e0b\u53d1QQDownloadUrl\u5931\u8d25\uff0c\u4f7f\u7528\u9ed8\u8ba4\u7684:");
                sb5.append(this.f408987a.download.qqDownloadUrl);
                x.l("WeishiDownloadUtil", sb5.toString());
            }
            x.f("WeishiDownloadUtil", "\u670d\u52a1\u5668\u4e0b\u53d1QQDownloadUrl: " + this.f408987a.download.qqDownloadUrl);
            return this.f408987a.download.qqDownloadUrl;
        }
        return b.b();
    }

    public int l(int i3) {
        stPopWindowsConfig k3 = k(i3);
        if (k3 != null) {
            return k3.index;
        }
        return -1;
    }

    public stGlobalConfig m(int i3) {
        return this.f408988b.get(i3);
    }

    public stCallInfo n() {
        stGlobalConfig stglobalconfig = this.f408987a;
        if (stglobalconfig == null) {
            return null;
        }
        return stglobalconfig.callinfo;
    }

    public stUserAuth o() {
        stGlobalConfig stglobalconfig = this.f408987a;
        if (stglobalconfig == null) {
            return null;
        }
        return stglobalconfig.user_auth;
    }

    @Deprecated
    public int p() {
        stGlobalConfig stglobalconfig = this.f408987a;
        if (stglobalconfig != null) {
            return stglobalconfig.link_strategy_type;
        }
        return 1;
    }

    public int q(int i3) {
        stGlobalConfig m3 = m(i3);
        if (m3 != null) {
            return m3.link_strategy_type;
        }
        return 1;
    }

    public void s(int i3, stGlobalConfig stglobalconfig) {
        this.f408988b.put(i3, stglobalconfig);
        this.f408987a = stglobalconfig;
        x.f("WSGlobalConfigLog", "initGlobalConfig globalConfig:" + stglobalconfig);
        y(stglobalconfig);
    }

    public boolean t() {
        return !u() && this.f408987a.download.appStoreSwitch;
    }

    public boolean w(int i3) {
        if (v(i3)) {
            return true;
        }
        return m(i3).linkConfig.isOpenVideoPage;
    }

    public boolean x(int i3, int i16) {
        stJumpInfo h16 = h(i16);
        if (h16 == null || h16.index < 0 || h16.f25121id <= 0) {
            return false;
        }
        x.i("WSGlobalConfigLog", "\u5168\u5c4f\u963b\u65ad\u9875\u662f\u7b2c" + h16.index + "\u4e2a,id\u4e3a\uff1a" + h16.f25121id);
        return i3 == h16.index;
    }

    public int r() {
        stGlobalConfig m3 = m(1);
        if (m3 != null) {
            return m3.cache_size;
        }
        return 14;
    }

    private void y(stGlobalConfig stglobalconfig) {
        if (stglobalconfig == null) {
            return;
        }
        x.f("WSGlobalConfigLog", "globalConfig info:stGlobalConfig: {\nis_call_weishi=" + ((int) stglobalconfig.is_call_weishi) + ", link_strategy_type=" + stglobalconfig.link_strategy_type + ", open_4g_autodownload=" + stglobalconfig.open_4g_autodownload + ", cache_size=" + stglobalconfig.cache_size + ", is_direct_open=" + ((int) stglobalconfig.is_direct_open) + ", encrypted_deviceid=" + stglobalconfig.encrypted_deviceid + "\ncommentConfig=" + stglobalconfig.commentConfig + "\nlinkConfig=" + stglobalconfig.linkConfig + "\ndownload=" + stglobalconfig.download + "\nmapExt=" + stglobalconfig.mapExt + "\n}");
    }
}
