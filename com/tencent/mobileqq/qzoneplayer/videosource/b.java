package com.tencent.mobileqq.qzoneplayer.videosource;

import android.text.TextUtils;
import com.tencent.mobileqq.haoliyou.JefsClass;
import com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv;
import com.tencent.oskplayer.cache.Cache;
import com.tencent.oskplayer.proxy.DataSourceBuilder;
import com.tencent.oskplayer.proxy.HttpRetryLogic;
import com.tencent.oskplayer.proxy.ITcDataSourceUtils;
import com.tencent.oskplayer.proxy.UuidPlayIdMap;
import com.tencent.oskplayer.proxy.VideoManager;
import com.tencent.oskplayer.proxy.VideoRequest;
import com.tencent.oskplayer.util.PlayerUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes35.dex */
public class b implements ITcDataSourceUtils {

    /* renamed from: b, reason: collision with root package name */
    private static volatile b f280066b;

    /* renamed from: c, reason: collision with root package name */
    private static Object f280067c;

    /* renamed from: d, reason: collision with root package name */
    private static Map<String, d> f280068d = new ConcurrentHashMap();

    /* renamed from: e, reason: collision with root package name */
    private static Map<String, Long> f280069e = new ConcurrentHashMap();

    /* renamed from: a, reason: collision with root package name */
    private h f280070a = new h(FeedVideoEnv.getApplicationContext());

    b() {
    }

    private long a(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        String[] split = str.split(";");
        long totalLength = VideoManager.getInstance().getTotalLength(split[0]);
        if (totalLength == -1) {
            return 0L;
        }
        PlayerUtils.log(4, "TcDataSourceUtils", "setFileSize=" + totalLength + JefsClass.INDEX_URL + split[0]);
        return totalLength;
    }

    public static b b() {
        if (f280066b == null) {
            synchronized (b.class) {
                if (f280066b == null) {
                    f280066b = new b();
                }
            }
        }
        return f280066b;
    }

    private String c(String str, String str2) {
        return str + "_" + str2;
    }

    private boolean d(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("_");
        sb5.append(str2);
        return str.lastIndexOf(sb5.toString()) > 0;
    }

    @Override // com.tencent.oskplayer.proxy.ITcDataSourceUtils
    public int cleanStorage() {
        return this.f280070a.a();
    }

    @Override // com.tencent.oskplayer.proxy.ITcDataSourceUtils
    public boolean deleteFileOnDisk(String str) {
        return this.f280070a.b(str);
    }

    public void e(boolean z16) {
        this.f280070a.i(z16);
    }

    public void f(String str, long j3) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String fileId = getFileId(str);
        if (TextUtils.isEmpty(fileId) || f280069e.containsKey(fileId)) {
            return;
        }
        f280069e.put(fileId, Long.valueOf(j3));
    }

    @Override // com.tencent.oskplayer.proxy.ITcDataSourceUtils
    public DataSourceBuilder getDataSourceBuilder(Cache cache, HttpRetryLogic httpRetryLogic, VideoRequest videoRequest) {
        return new g(cache, httpRetryLogic, videoRequest);
    }

    @Override // com.tencent.oskplayer.proxy.ITcDataSourceUtils
    public String getFileId(String str) {
        String c16 = this.f280070a.c(str);
        return TextUtils.isEmpty(c16) ? str : c16;
    }

    @Override // com.tencent.oskplayer.proxy.ITcDataSourceUtils
    public boolean isClipCompleteOnDisk(String str, int i3) {
        return this.f280070a.e(str, i3);
    }

    @Override // com.tencent.oskplayer.proxy.ITcDataSourceUtils
    public boolean isEnabled() {
        return true;
    }

    @Override // com.tencent.oskplayer.proxy.ITcDataSourceUtils
    public boolean isUseDefaultSourceBuilder(String str) {
        PlayerUtils.log(4, "TcDataSourceUtils", "isNeedUseDefaultSourceBuilder=" + str);
        if (str == null) {
            return false;
        }
        if (str.startsWith("https")) {
            return true;
        }
        return FeedVideoEnv.externalFunc.getLoginUin() % 10 <= ((long) FeedVideoEnv.externalFunc.getWnsConfig("VideoSDKSetting", "VideoUseDefaultSourceBuilder", -1));
    }

    @Override // com.tencent.oskplayer.proxy.ITcDataSourceUtils
    public int pauseStorageIO() {
        return this.f280070a.f();
    }

    @Override // com.tencent.oskplayer.proxy.ITcDataSourceUtils
    public boolean preload(String str, long j3, int i3, int i16, int i17, String str2) {
        int j16;
        synchronized (this) {
            j16 = this.f280070a.j(str, j3, i3, i16, str2);
        }
        return this.f280070a.g(j16, i17);
    }

    @Override // com.tencent.oskplayer.proxy.ITcDataSourceUtils
    public int resumeStorageIO() {
        return this.f280070a.h();
    }

    @Override // com.tencent.oskplayer.proxy.ITcDataSourceUtils
    public void setPlayerState(String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        for (Map.Entry<String, d> entry : f280068d.entrySet()) {
            if (d(entry.getKey(), str)) {
                this.f280070a.k(entry.getValue().f280096b, i3);
            }
        }
    }

    @Override // com.tencent.oskplayer.proxy.ITcDataSourceUtils
    public void setRemainTime(String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        for (Map.Entry<String, d> entry : f280068d.entrySet()) {
            if (d(entry.getKey(), str)) {
                this.f280070a.l(entry.getValue().f280096b, i3);
            }
        }
    }

    @Override // com.tencent.oskplayer.proxy.ITcDataSourceUtils
    public void stopAllPreload() {
        this.f280070a.m();
    }

    @Override // com.tencent.oskplayer.proxy.ITcDataSourceUtils
    @Deprecated
    public void stopPlay(int i3) {
        if (i3 > 0) {
            PlayerUtils.log(4, "TcDataSourceUtils", "stopPlay by playDataId=" + i3);
            this.f280070a.n(i3);
            ArrayList arrayList = new ArrayList();
            for (String str : f280068d.keySet()) {
                d dVar = f280068d.get(str);
                if (dVar != null && dVar.f280096b == i3) {
                    arrayList.add(str);
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                PlayerUtils.log(4, "TcDataSourceUtils", "stopPlay case 3 remove from playUrlMap key=" + str2 + ",playid=" + i3);
                f280068d.remove(str2);
            }
            PlayerUtils.log(4, "TcDataSourceUtils", "stopPlay case 3 remove from playUrlMap sPlayUrlMap size =" + f280068d.size());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0095  */
    @Override // com.tencent.oskplayer.proxy.ITcDataSourceUtils
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized String getLocalUrl(String str, String str2, String str3, String str4) {
        int i3;
        String str5;
        long j3;
        Object obj;
        FeedVideoEnv.FeedVideoExternalFunc feedVideoExternalFunc;
        Long l3;
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        String str6 = str4 + "TcDataSourceUtils";
        String fileId = getFileId(str2);
        String c16 = c(fileId, str3);
        if (f280068d != null && !TextUtils.isEmpty(c16) && f280068d.containsKey(c16)) {
            d dVar = f280068d.get(c16);
            PlayerUtils.log(4, str6, "reuse playid=" + dVar.f280096b + ", playUrlMapKey=" + c16);
            return dVar.f280097c;
        }
        if (f280068d != null) {
            long j16 = 0;
            if (!TextUtils.isEmpty(str2)) {
                String fileId2 = getFileId(str2);
                if (!TextUtils.isEmpty(fileId2) && (l3 = f280069e.get(fileId2)) != null) {
                    j3 = l3.longValue();
                    if (j3 > 0) {
                        j3 = 0;
                    }
                    if (f280067c == null && (feedVideoExternalFunc = FeedVideoEnv.externalFunc) != null) {
                        boolean z16 = true;
                        if (feedVideoExternalFunc.getWnsConfig("VideoSDKSetting", "videoEnableTcSetFileSize", 1) > 0) {
                            z16 = false;
                        }
                        f280067c = Boolean.valueOf(z16);
                    }
                    h hVar = this.f280070a;
                    obj = f280067c;
                    if (obj != null && ((Boolean) obj).booleanValue()) {
                        j16 = a(str);
                    }
                    i3 = hVar.j(str, j16, (int) j3, 1, str4);
                }
            }
            j3 = 0;
            if (j3 > 0) {
            }
            if (f280067c == null) {
                boolean z162 = true;
                if (feedVideoExternalFunc.getWnsConfig("VideoSDKSetting", "videoEnableTcSetFileSize", 1) > 0) {
                }
                f280067c = Boolean.valueOf(z162);
            }
            h hVar2 = this.f280070a;
            obj = f280067c;
            if (obj != null) {
                j16 = a(str);
            }
            i3 = hVar2.j(str, j16, (int) j3, 1, str4);
        } else {
            i3 = -1;
        }
        int i16 = i3;
        PlayerUtils.log(4, str6, "directIpUrls = " + str + ", fileId = " + fileId + ", playDataId = " + i16);
        if (i16 < 0) {
            PlayerUtils.log(5, str6, "invalid playDataId = " + i16 + ", using originUrl=" + str2);
            str5 = str2;
        } else {
            str5 = this.f280070a.d() + "&play_id=" + i16 + "&mType=qzone_video_player";
            Map<String, d> map = f280068d;
            if (map != null && !map.containsKey(c16)) {
                PlayerUtils.log(4, str6, "sPlayUrlMap put playUrlMapKey=" + c16 + ", playId=" + i16);
                f280068d.put(c16, new d(fileId, i16, str5, str, str2, str3));
                this.f280070a.l(i16, 0);
                PlayerUtils.log(4, str6, "sPlayUrlMap size =" + f280068d.size());
            } else {
                PlayerUtils.log(6, str6, "sPlayUrlMap playid generated without save, playUrlMapKey=" + c16 + ", playDataId=" + f280068d.get(c16).f280096b + " already exists");
            }
            UuidPlayIdMap.addPlayId(str3, i16 + "");
        }
        return str5;
    }

    @Override // com.tencent.oskplayer.proxy.ITcDataSourceUtils
    public void stopPlay(String str, String str2) {
        PlayerUtils.log(4, "TcDataSourceUtils", "stopPlay by uuid_url uuid=" + str + ", url=" + str2);
        String c16 = c(getFileId(str2), str);
        if (f280068d == null || TextUtils.isEmpty(c16) || !f280068d.containsKey(c16)) {
            return;
        }
        int i3 = f280068d.get(c16).f280096b;
        this.f280070a.n(i3);
        f280068d.remove(c16);
        PlayerUtils.log(4, "TcDataSourceUtils", "stopPlay case 2 remove from playUrlMap key=" + c16 + ",playid=" + i3 + ",sPlayUrlMap size =" + f280068d.size());
    }

    @Override // com.tencent.oskplayer.proxy.ITcDataSourceUtils
    public void stopPlay(String str) {
        PlayerUtils.log(4, "TcDataSourceUtils", "stopPlay by uuid " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Iterator<Map.Entry<String, d>> it = f280068d.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, d> next = it.next();
            String key = next.getKey();
            if (d(key, str)) {
                int i3 = next.getValue().f280096b;
                this.f280070a.n(i3);
                it.remove();
                PlayerUtils.log(4, "TcDataSourceUtils", "stopPlay case 1 remove from playUrlMap key=" + key + ",playid=" + i3 + ",sPlayUrlMap size =" + f280068d.size());
            }
        }
    }
}
