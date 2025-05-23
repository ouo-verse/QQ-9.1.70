package com.tencent.mobileqq.qzoneplayer.videosource;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv;
import com.tencent.mobileqq.qzoneplayer.video.p;
import com.tencent.oskplayer.PlayerConfig;
import com.tencent.oskplayer.model.SegmentVideoInfo;
import com.tencent.oskplayer.proxy.HttpRetryLogic;
import com.tencent.oskplayer.util.PlayerUtils;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import cooperation.qzone.webviewplugin.QzoneWebViewOfflinePlugin;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes35.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    private static volatile a f280064b;

    /* renamed from: a, reason: collision with root package name */
    private ConcurrentHashMap<String, HttpRetryLogic> f280065a = new ConcurrentHashMap<>(8, 0.75f, 2);

    public static a d() {
        if (f280064b == null) {
            synchronized (a.class) {
                if (f280064b == null) {
                    f280064b = new a();
                }
            }
        }
        return f280064b;
    }

    private boolean e() {
        int iPStackType = PlayerConfig.g().getIPStackType();
        if (iPStackType != -1 && iPStackType != 0 && iPStackType != 2 && iPStackType != 3) {
            return true;
        }
        FeedVideoEnv.FeedVideoExternalFunc feedVideoExternalFunc = FeedVideoEnv.externalFunc;
        return feedVideoExternalFunc != null && feedVideoExternalFunc.getWnsConfig("VideoSDKSetting", "videoIpv6DirectIpEnable", 1) == 1;
    }

    public boolean a() {
        FeedVideoEnv.FeedVideoExternalFunc feedVideoExternalFunc = FeedVideoEnv.externalFunc;
        return feedVideoExternalFunc != null && feedVideoExternalFunc.getWnsConfig("VideoSDKSetting", "enableDirectIpOnCloudUrl", 1) == 1;
    }

    public boolean b(com.tencent.mobileqq.qzoneplayer.video.e eVar) {
        SegmentVideoInfo.StreamInfo streamInfo;
        if (eVar != null && (streamInfo = eVar.f279991k) != null && streamInfo.getSegment(0) != null && PlayerUtils.isHLSStream(eVar.f279991k.getSegment(0).url)) {
            PlayerUtils.log(4, "SuperPlayerUtils", "[enabledSuperPlayer] hls not supported");
            return false;
        }
        FeedVideoEnv.FeedVideoExternalFunc feedVideoExternalFunc = FeedVideoEnv.externalFunc;
        if (feedVideoExternalFunc != null && feedVideoExternalFunc.isSuperPlayerEnabled()) {
            PlayerUtils.log(4, "SuperPlayerUtils", "[enabledSuperPlayer] support");
            return true;
        }
        PlayerUtils.log(4, "SuperPlayerUtils", "[enabledSuperPlayer] not support");
        return false;
    }

    public HttpRetryLogic c(String str) {
        return this.f280065a.get(str);
    }

    public void f(String str, HttpRetryLogic httpRetryLogic) {
        this.f280065a.put(str, httpRetryLogic);
    }

    public String g(String str) {
        List<String> a16;
        String str2;
        String str3;
        Uri parse = Uri.parse(str);
        String str4 = parse.getHost() + parse.getPath();
        String scheme = parse.getScheme();
        if (TextUtils.isEmpty(scheme)) {
            scheme = "http";
        }
        if (TextUtils.isEmpty(str4) || !e()) {
            return str;
        }
        if (PlayerConfig.g().isEnableWeishiDirectIp() && vl2.b.f(str4)) {
            List<String> weishiVideoIp = FeedVideoEnv.externalFunc.getWeishiVideoIp(str);
            StringBuilder sb5 = new StringBuilder();
            String str5 = str4 + QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER + parse.getQuery();
            if (weishiVideoIp != null && weishiVideoIp.size() > 0) {
                str2 = weishiVideoIp.get(0);
                sb5.append(scheme + QzoneWebViewOfflinePlugin.STR_DEVIDER);
                sb5.append(xl2.a.b(str2) + "/");
                sb5.append(str5);
                sb5.append("&bk_ip_list=");
                if (weishiVideoIp.size() >= 2) {
                    str2 = weishiVideoIp.get(1);
                }
                sb5.append(str2);
                sb5.append(";");
                sb5.append(str);
                str3 = sb5.toString();
            } else {
                str2 = "";
                str3 = str;
            }
            if (FeedVideoEnv.externalFunc.isDebugVersion()) {
                PlayerUtils.log(4, "WeishiVideo_IP_DIRECT", String.format("%s->%s, origin=[%s], current=%s", parse.getHost(), str2, str, str3));
            }
            return str3;
        }
        if (vl2.b.b(str4)) {
            String lastPathSegment = parse.getLastPathSegment();
            if (TextUtils.isEmpty(lastPathSegment) || (a16 = p.a(lastPathSegment)) == null || a16.size() <= 0) {
                return str;
            }
            String str6 = lastPathSegment + QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER + parse.getQuery();
            StringBuilder sb6 = new StringBuilder();
            sb6.append(str);
            sb6.append("&bk_ip_list=");
            Uri parse2 = !TextUtils.isEmpty(a16.get(0)) ? Uri.parse(a16.get(0)) : null;
            if (parse2 != null && a16.size() >= 2) {
                sb6.append(parse2.getHost());
            }
            sb6.append(";");
            sb6.append(a16.get(a16.size() - 1));
            sb6.append(str6);
            return sb6.toString();
        }
        if (vl2.b.d(str4)) {
            List<String> ugcVideoIp = FeedVideoEnv.externalFunc.getUgcVideoIp(str);
            StringBuilder sb7 = new StringBuilder();
            String str7 = str4 + QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER + parse.getQuery();
            if (ugcVideoIp == null || ugcVideoIp.size() <= 0) {
                return str;
            }
            String str8 = ugcVideoIp.get(0);
            sb7.append(scheme + QzoneWebViewOfflinePlugin.STR_DEVIDER);
            sb7.append(xl2.a.b(str8) + "/");
            sb7.append(str7);
            sb7.append("&bk_ip_list=");
            if (ugcVideoIp.size() >= 2) {
                str8 = ugcVideoIp.get(1);
            }
            sb7.append(str8);
            sb7.append(";");
            sb7.append(str);
            return sb7.toString();
        }
        FeedVideoEnv.FeedVideoExternalFunc feedVideoExternalFunc = FeedVideoEnv.externalFunc;
        if (feedVideoExternalFunc == null || !feedVideoExternalFunc.isUgcOnCloudUrl(str)) {
            return str;
        }
        if (!a()) {
            PlayerUtils.log(4, "SuperPlayerUtils", "[spliceUrl] disable direct ip on cloud url");
            return str;
        }
        List<String> ugcVideoIp2 = FeedVideoEnv.externalFunc.getUgcVideoIp(str);
        StringBuilder sb8 = new StringBuilder();
        String str9 = QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER + parse.getQuery();
        if (ugcVideoIp2 == null || ugcVideoIp2.size() <= 0) {
            return str;
        }
        String str10 = ugcVideoIp2.get(0);
        sb8.append(scheme + QzoneWebViewOfflinePlugin.STR_DEVIDER);
        sb8.append(xl2.a.b(str10));
        sb8.append(parse.getPath());
        sb8.append(str9);
        return sb8.toString();
    }
}
