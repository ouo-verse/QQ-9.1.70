package com.tencent.mobileqq.qzoneplayer.videosource;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.oskplayer.PlayerConfig;
import com.tencent.oskplayer.util.PlayerUtils;

/* compiled from: P */
/* loaded from: classes35.dex */
public class h {

    /* renamed from: c, reason: collision with root package name */
    private static volatile int f280121c = -1;

    /* renamed from: a, reason: collision with root package name */
    private int f280122a = -1;

    /* renamed from: b, reason: collision with root package name */
    private String f280123b;

    public h(Context context) {
        if (f280121c == 0) {
            return;
        }
        PlayerUtils.log(4, "TcVideoDownload", "cache data dir = " + PlayerConfig.g().getCacheDir());
        PlayerUtils.log(4, "TcVideoDownload", "init result = " + f280121c);
        if (f280121c == 0) {
            PlayerConfig.g().isEnableCache();
        }
    }

    public int a() {
        return 0;
    }

    public boolean b(String str) {
        String c16 = c(str);
        if (TextUtils.isEmpty(c16)) {
            PlayerUtils.log(4, "TcVideoDownload", "delete file on disk failed: field is empty");
            return false;
        }
        PlayerUtils.log(4, "TcVideoDownload", "delete file on disk = fileId: " + c16 + " result: 0");
        return true;
    }

    public String c(String str) {
        return PlayerUtils.parseVideoKey(str);
    }

    public String d() {
        if (this.f280122a == -1) {
            PlayerUtils.log(4, "TcVideoDownload", "get local url failed: playdataId = -1");
            return this.f280123b;
        }
        return this.f280123b;
    }

    public boolean e(String str, int i3) {
        if (TextUtils.isEmpty(c(str))) {
            PlayerUtils.log(4, "TcVideoDownload", "is clip complete on disk failed: field is empty");
        }
        return false;
    }

    public int f() {
        return 0;
    }

    public boolean g(int i3, int i16) {
        return false;
    }

    public int h() {
        return 0;
    }

    public void i(boolean z16) {
        PlayerUtils.log(4, "TcVideoDownload", "setNetworkState isWifiOn= " + z16);
    }

    public int j(String str, long j3, int i3, int i16, String str2) {
        this.f280123b = str;
        int i17 = i3 / 1000;
        if (TextUtils.isEmpty(c(str))) {
            this.f280122a = -1;
        }
        PlayerUtils.log(4, str2 + "TcVideoDownload", "set playDataId = " + this.f280122a + ", file duration = " + i17);
        return this.f280122a;
    }

    public void m() {
    }

    public void n(int i3) {
    }

    public void k(int i3, int i16) {
    }

    public void l(int i3, int i16) {
    }
}
