package com.tencent.mobileqq.qzoneplayer.videosource;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv;
import com.tencent.mobileqq.qzoneplayer.video.n;
import com.tencent.mobileqq.qzoneplayer.video.p;
import com.tencent.mobileqq.qzoneplayer.videosource.TcUtils;
import com.tencent.oskplayer.PlayerConfig;
import com.tencent.oskplayer.datasource.DataSpec;
import com.tencent.oskplayer.datasource.DefaultHttpDataSource;
import com.tencent.oskplayer.datasource.HttpDataSource;
import com.tencent.oskplayer.datasource.TransferListener;
import com.tencent.oskplayer.proxy.HttpRetryLogic;
import com.tencent.oskplayer.proxy.UuidPlayIdMap;
import com.tencent.oskplayer.proxy.VideoRequest;
import com.tencent.oskplayer.service.DNSService;
import com.tencent.oskplayer.util.HttpParser;
import com.tencent.oskplayer.util.PlayerUtils;
import com.tencent.oskplayer.util.Predicate;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import cooperation.qzone.webviewplugin.QzoneWebViewOfflinePlugin;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes35.dex */
public class f extends DefaultHttpDataSource {

    /* renamed from: f, reason: collision with root package name */
    private static int f280104f = 3000;

    /* renamed from: g, reason: collision with root package name */
    private static int f280105g = 3;

    /* renamed from: h, reason: collision with root package name */
    private static int f280106h = 5;

    /* renamed from: i, reason: collision with root package name */
    private static int f280107i = 1;

    /* renamed from: j, reason: collision with root package name */
    private static boolean f280108j;

    /* renamed from: a, reason: collision with root package name */
    private HttpRetryLogic f280109a;

    /* renamed from: b, reason: collision with root package name */
    private VideoRequest f280110b;

    /* renamed from: c, reason: collision with root package name */
    private int f280111c;

    /* renamed from: d, reason: collision with root package name */
    private DNSService f280112d;

    /* renamed from: e, reason: collision with root package name */
    private n f280113e;

    public f(String str, Predicate<String> predicate, TransferListener transferListener, HttpRetryLogic httpRetryLogic, VideoRequest videoRequest) {
        super(str, predicate, transferListener, videoRequest.getContentTypeFixer());
        this.f280111c = 0;
        this.f280112d = null;
        this.f280109a = httpRetryLogic;
        this.f280110b = videoRequest;
        this.TAG = "TcVideoDataSource";
        if (!f280108j) {
            f280104f = FeedVideoEnv.externalFunc.getWnsConfig("VideoSDKSetting", "videoErrorCallbackOverTime", 3000);
            f280105g = FeedVideoEnv.externalFunc.getWnsConfig("VideoSDKSetting", "videoErrorRetryCount", 3);
            f280106h = FeedVideoEnv.externalFunc.getWnsConfig("VideoSDKSetting", "videoErrorRetryOpenCount", 5);
            f280107i = FeedVideoEnv.externalFunc.getWnsConfig("VideoSDKSetting", "videoErrorRetryCountOpenEnable", 1);
            PlayerUtils.log(4, this.TAG, "sErrorCallbackOverTime=" + f280104f + ",sMaxRetryCount=" + f280105g + ",sMaxRetryOpenCount=" + f280106h + ",sMaxRetryOpenCountEnable=" + f280107i);
            f280108j = true;
        }
        this.f280112d = PlayerConfig.g().getDNSService();
        this.f280113e = new n();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x003b, code lost:
    
        r3 = r2.f280063e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003d, code lost:
    
        if (r3 == null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003f, code lost:
    
        r4 = r9.equals(r3.key);
        com.tencent.oskplayer.util.PlayerUtils.log(4, r8.TAG, "keyOrigin = " + r9 + ", dataSpec key = " + r3.key + ", equals = " + r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0071, code lost:
    
        if (r3 == null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0079, code lost:
    
        if (r9.equals(r3.key) == false) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private TcUtils.b a(String str) {
        Map<String, TcUtils.b> map;
        TcUtils.b bVar;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String parseVideoKey = PlayerUtils.parseVideoKey(str);
        if (TextUtils.isEmpty(parseVideoKey) || (map = TcUtils.sRetryUrlMap) == null || map.size() <= 0) {
            return null;
        }
        Iterator<String> it = TcUtils.sRetryUrlMap.keySet().iterator();
        loop0: while (true) {
            bVar = null;
            while (true) {
                if (!it.hasNext()) {
                    break loop0;
                }
                bVar = TcUtils.sRetryUrlMap.get(it.next());
                if (bVar != null) {
                    break;
                }
            }
        }
        return bVar;
    }

    private boolean b(String str) {
        boolean z16 = false;
        if (TextUtils.isEmpty(str)) {
            PlayerUtils.log(4, getLogTag(), "isErrorVideoInfo input key is empty");
            return false;
        }
        Map<String, TcUtils.b> map = TcUtils.sRetryUrlMap;
        if (map != null && map.size() > 0) {
            PlayerUtils.log(4, getLogTag(), "isErrorVideoInfo retry map size = " + TcUtils.sRetryUrlMap.size() + ", key = " + str);
            Iterator<String> it = TcUtils.sRetryUrlMap.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                TcUtils.b bVar = TcUtils.sRetryUrlMap.get(it.next());
                if (bVar != null) {
                    DataSpec dataSpec = bVar.f280063e;
                    if (dataSpec != null) {
                        boolean equals = str.equals(dataSpec.key);
                        PlayerUtils.log(4, this.TAG, "key = " + str + ", dataSpec key = " + dataSpec.key + ", equals = " + equals);
                    }
                    if (dataSpec != null && str.equals(dataSpec.key)) {
                        z16 = true;
                        break;
                    }
                }
            }
        }
        PlayerUtils.log(4, getLogTag(), "isErrorVideoInfo = " + z16);
        return z16;
    }

    private boolean c() {
        int iPStackType = PlayerConfig.g().getIPStackType();
        return (iPStackType == -1 || iPStackType == 0 || iPStackType == 2 || iPStackType == 3) ? false : true;
    }

    private boolean d() {
        int iPStackType = PlayerConfig.g().getIPStackType();
        if (iPStackType != -1 && iPStackType != 0 && iPStackType != 2 && iPStackType != 3) {
            return true;
        }
        FeedVideoEnv.FeedVideoExternalFunc feedVideoExternalFunc = FeedVideoEnv.externalFunc;
        return feedVideoExternalFunc != null && feedVideoExternalFunc.getWnsConfig("VideoSDKSetting", "videoIpv6DirectIpEnable", 1) == 1;
    }

    public String f(String str) {
        List<String> a16;
        String str2;
        String str3;
        Uri parse = Uri.parse(str);
        String str4 = parse.getHost() + parse.getPath();
        String scheme = parse.getScheme();
        if (TextUtils.isEmpty(scheme)) {
            scheme = "http";
        }
        if (TextUtils.isEmpty(str4) || !d()) {
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
        if (!vl2.b.d(str4)) {
            return str;
        }
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

    @Override // com.tencent.oskplayer.datasource.DefaultHttpDataSource, com.tencent.oskplayer.datasource.HttpDataSource, com.tencent.oskplayer.datasource.DataSource
    public int read(byte[] bArr, int i3, int i16) throws HttpDataSource.HttpDataSourceException {
        try {
            return super.read(bArr, i3, i16);
        } catch (HttpDataSource.HttpDataSourceException e16) {
            if (this.f280110b != null && this.f280110b.shouldCancel()) {
                PlayerUtils.log(4, getLogTag(), "abandon readRetry videoRequest is cancelling " + this.f280110b);
                throw new HttpDataSource.InterruptReadException("retry read interrupted " + this.f280110b, getDataSpec());
            }
            return readRetry(bArr, i3, i16, e16);
        }
    }

    private int readRetry(byte[] bArr, int i3, int i16, HttpDataSource.HttpDataSourceException httpDataSourceException) throws HttpDataSource.HttpDataSourceException {
        if (!UuidPlayIdMap.isUuidDeleted(getDataSpec().uuid)) {
            long bytesRead = getDataSpec().position + bytesRead();
            DataSpec dataSpec = new DataSpec(Uri.parse(getUri()), getDataSpec().originUrl, 0L, bytesRead, -1L, (String) null, 0, getDataSpec().uuid);
            int i17 = 0;
            while (i17 < f280105g) {
                if (!this.f280110b.shouldCancel()) {
                    try {
                        PlayerUtils.log(5, getLogTag(), "readRetry retryCount=" + i17 + ", sMaxRetryCount=" + f280105g);
                        open(dataSpec);
                        return read(bArr, i3, i16);
                    } catch (HttpDataSource.HttpDataSourceException e16) {
                        if (!this.f280110b.shouldCancel()) {
                            PlayerUtils.log(4, getLogTag(), "read source error " + e16.toString());
                            i17++;
                            int i18 = i17 * 2000;
                            PlayerUtils.log(4, getLogTag(), "retrying after " + i18 + " seconds, read start at offset " + bytesRead + " retry " + i17 + "/" + f280105g);
                            try {
                                LockMethodProxy.sleep(i18);
                            } catch (InterruptedException unused) {
                                PlayerUtils.log(5, getLogTag(), "readRetry interrupted");
                                Thread.currentThread().interrupt();
                                throw httpDataSourceException;
                            }
                        } else {
                            PlayerUtils.log(4, getLogTag(), "abort retry when exception occurred videoRequest is cancelling " + this.f280110b);
                            throw httpDataSourceException;
                        }
                    }
                } else {
                    PlayerUtils.log(4, getLogTag(), "abort retry videoRequest is cancelling " + this.f280110b);
                    throw httpDataSourceException;
                }
            }
            throw httpDataSourceException;
        }
        throw new HttpDataSource.InterruptReadException("readRetry interrupted UuidDeleted" + this.f280110b, getDataSpec());
    }

    @Override // com.tencent.oskplayer.datasource.DefaultHttpDataSource, com.tencent.oskplayer.datasource.HttpDataSource, com.tencent.oskplayer.datasource.DataSource
    public long open(DataSpec dataSpec) throws HttpDataSource.HttpDataSourceException {
        String uri;
        DataSpec dataSpec2 = dataSpec;
        Map<String, String> parseParams = HttpParser.parseParams(dataSpec2.uri.toString());
        String host = dataSpec2.uri.getHost();
        if (TextUtils.isEmpty(host)) {
            return super.open(dataSpec);
        }
        if (!host.toLowerCase().contains("127.0.0.1")) {
            if (parseParams != null && parseParams.containsKey("v")) {
                uri = parseParams.get("v");
                try {
                    uri = URLDecoder.decode(uri, "UTF-8");
                } catch (UnsupportedEncodingException e16) {
                    PlayerUtils.log(6, getLogTag(), "invalid url " + PlayerUtils.getPrintableStackTrace(e16));
                }
            } else {
                uri = dataSpec2.uri.toString();
            }
            String str = uri;
            String localUrl = b.b().getLocalUrl(f(str), str, dataSpec2.uuid, this.extraLogTag);
            if (!TextUtils.isEmpty(str) && str.equals(localUrl)) {
                FeedVideoEnv.externalFunc.reportTcDownloadProxySuccessRate(false);
            } else {
                FeedVideoEnv.externalFunc.reportTcDownloadProxySuccessRate(true);
            }
            DataSpec dataSpec3 = new DataSpec(Uri.parse(localUrl), str, dataSpec2.absoluteStreamPosition, dataSpec2.position, dataSpec2.length, dataSpec2.key, dataSpec2.flags, dataSpec2.uuid);
            PlayerUtils.log(4, getLogTag(), "url=" + localUrl + ",dataSpec=" + dataSpec3);
            dataSpec2 = dataSpec3;
        }
        try {
            return super.open(dataSpec2);
        } catch (HttpDataSource.HttpDataSourceException e17) {
            if (this.f280110b != null && this.f280110b.shouldCancel()) {
                PlayerUtils.log(4, getLogTag(), "abort retryTcOpen videoRequest is cancelling " + this.f280110b + ",reason=" + PlayerUtils.getPrintableStackTrace(e17));
                throw new HttpDataSource.InterruptConnectServerException("retry open interrupted " + this.f280110b, getDataSpec());
            }
            if (f280107i > 0) {
                int i3 = this.f280111c;
                if (i3 < f280106h) {
                    int i16 = i3 + 1;
                    this.f280111c = i16;
                    int i17 = i16 * 2000;
                    PlayerUtils.log(4, getLogTag(), "retryTcOpen retrying after " + i17 + " seconds  retry " + this.f280111c + "/" + f280106h);
                    try {
                        LockMethodProxy.sleep(i17);
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        throw new HttpDataSource.InterruptConnectServerException("retryTcOpen interrupted " + this.f280110b, getDataSpec());
                    }
                } else {
                    PlayerUtils.log(5, getLogTag(), "retryTcOpen maxRetry reached " + this.f280111c + "/" + f280106h);
                    throw new HttpDataSource.InterruptConnectServerException("retry open interrupted " + this.f280110b, getDataSpec());
                }
            }
            return e(dataSpec2, e17, 0);
        }
    }

    public long e(DataSpec dataSpec, HttpDataSource.HttpDataSourceException httpDataSourceException, int i3) throws HttpDataSource.HttpDataSourceException {
        PlayerUtils.log(4, getLogTag(), "errorCode = " + httpDataSourceException.toString());
        TcUtils.b a16 = a(dataSpec.originUrl);
        if (a16 == null || a16.f280062d == 0) {
            try {
                LockMethodProxy.sleep(f280104f);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
            a16 = a(dataSpec.originUrl);
        }
        if (a16 != null) {
            PlayerUtils.log(4, getLogTag(), "videoRetryInfo != null\uff0c video url = " + a16.f280059a + ", video errorCode = " + a16.f280062d + ", video key = " + PlayerUtils.parseVideoKey(a16.f280059a));
        } else {
            PlayerUtils.log(4, getLogTag(), "videoRetryInfo is null");
        }
        if (!UuidPlayIdMap.isUuidDeleted(dataSpec.uuid)) {
            boolean z16 = httpDataSourceException instanceof HttpDataSource.InvalidResponseCodeException;
            if (z16) {
                HttpDataSource.InvalidResponseCodeException invalidResponseCodeException = (HttpDataSource.InvalidResponseCodeException) httpDataSourceException;
                PlayerUtils.log(4, getLogTag(), "detected internal proxy error \r\n" + invalidResponseCodeException.responseCode + " headers: \r\n" + HttpParser.getHeaders(invalidResponseCodeException.headerFields));
                if (invalidResponseCodeException.responseCode == 500) {
                    long subErrorCode = PlayerUtils.getSubErrorCode(invalidResponseCodeException.headerFields);
                    if (subErrorCode <= -19994) {
                        PlayerUtils.log(4, getLogTag(), "\u89c6\u9891\u4e0b\u8f7d dns failed " + subErrorCode);
                    }
                    if (this.f280112d != null && c()) {
                        PlayerUtils.log(4, getLogTag(), "httpdns retry");
                        String str = dataSpec.originUrl;
                        String parseDomain = PlayerUtils.parseDomain(str);
                        if (!TextUtils.isEmpty(parseDomain)) {
                            boolean isHostEnableHttpDNSService = PlayerConfig.g().isHostEnableHttpDNSService(parseDomain);
                            boolean isHostEnableHttpDNSServicePrependIp = PlayerConfig.g().isHostEnableHttpDNSServicePrependIp(parseDomain);
                            if (isHostEnableHttpDNSService) {
                                String probeRealUrl = PlayerUtils.probeRealUrl(str, this.f280112d, isHostEnableHttpDNSServicePrependIp ? 1 : 0, getLogTag());
                                PlayerUtils.log(4, getLogTag(), "httpdns probeRealUrl=" + probeRealUrl);
                                if (TextUtils.isEmpty(probeRealUrl)) {
                                    if (isHostEnableHttpDNSServicePrependIp) {
                                        probeRealUrl = PlayerUtils.replaceDomainPrependIp(this.f280112d, str, 2000L);
                                    } else {
                                        probeRealUrl = PlayerUtils.replaceDomain(this.f280112d, str, 2000L);
                                    }
                                }
                                PlayerUtils.log(4, getLogTag(), "httpdns result originUrl=" + str + ", httpDNSUrl=" + probeRealUrl);
                                if (!probeRealUrl.equals(str)) {
                                    PlayerUtils.log(4, getLogTag(), "retry using httpdns url=" + probeRealUrl);
                                    b.b().stopPlay(dataSpec.uuid, str);
                                    return open(new DataSpec(Uri.parse(probeRealUrl), dataSpec.originUrl, dataSpec.absoluteStreamPosition, dataSpec.position, dataSpec.length, dataSpec.key, dataSpec.flags, dataSpec.uuid));
                                }
                            }
                        }
                    }
                    String str2 = dataSpec.originUrl;
                    b.b().stopPlay(dataSpec.uuid, str2);
                    return open(new DataSpec(Uri.parse(str2), dataSpec.originUrl, dataSpec.absoluteStreamPosition, dataSpec.position, dataSpec.length, dataSpec.key, dataSpec.flags, dataSpec.uuid));
                }
            } else if (httpDataSourceException instanceof HttpDataSource.UnableConnectServerException) {
                if (this.f280112d != null) {
                    PlayerUtils.log(4, getLogTag(), "httpdns retry");
                    String str3 = dataSpec.originUrl;
                    String parseDomain2 = PlayerUtils.parseDomain(str3);
                    if (!TextUtils.isEmpty(parseDomain2)) {
                        boolean isHostEnableHttpDNSService2 = PlayerConfig.g().isHostEnableHttpDNSService(parseDomain2);
                        boolean isHostEnableHttpDNSServicePrependIp2 = PlayerConfig.g().isHostEnableHttpDNSServicePrependIp(parseDomain2);
                        if (isHostEnableHttpDNSService2) {
                            String probeRealUrl2 = PlayerUtils.probeRealUrl(str3, this.f280112d, isHostEnableHttpDNSServicePrependIp2 ? 1 : 0, getLogTag());
                            PlayerUtils.log(4, getLogTag(), "httpdns probeRealUrl=" + probeRealUrl2);
                            if (TextUtils.isEmpty(probeRealUrl2)) {
                                if (isHostEnableHttpDNSServicePrependIp2) {
                                    probeRealUrl2 = PlayerUtils.replaceDomainPrependIp(this.f280112d, str3, 2000L);
                                } else {
                                    probeRealUrl2 = PlayerUtils.replaceDomain(this.f280112d, str3, 2000L);
                                }
                            }
                            PlayerUtils.log(4, getLogTag(), "httpdns result originUrl=" + str3 + ", httpDNSUrl=" + probeRealUrl2);
                            if (!probeRealUrl2.equals(str3)) {
                                PlayerUtils.log(4, getLogTag(), "retry using httpdns url=" + probeRealUrl2);
                                b.b().stopPlay(dataSpec.uuid, str3);
                                return open(new DataSpec(Uri.parse(probeRealUrl2), dataSpec.originUrl, dataSpec.absoluteStreamPosition, dataSpec.position, dataSpec.length, dataSpec.key, dataSpec.flags, dataSpec.uuid));
                            }
                        }
                    }
                }
                String str4 = dataSpec.originUrl;
                b.b().stopPlay(dataSpec.uuid, str4);
                return open(new DataSpec(Uri.parse(str4), dataSpec.originUrl, dataSpec.absoluteStreamPosition, dataSpec.position, dataSpec.length, dataSpec.key, dataSpec.flags, dataSpec.uuid));
            }
            boolean z17 = z16 && ((HttpDataSource.InvalidResponseCodeException) httpDataSourceException).responseCode == 403;
            if ((this.f280109a != null && a16 != null && a16.f280062d == 403) || z17) {
                String str5 = dataSpec.originUrl;
                PlayerUtils.log(4, getLogTag(), "originUrl = " + str5 + ", key = " + PlayerUtils.parseVideoKey(str5));
                if (str5 != null && b(PlayerUtils.parseVideoKey(str5))) {
                    int i16 = a16.f280062d;
                    PlayerUtils.log(4, getLogTag(), "videoRetryInfo = " + a16 + "retryCount = " + a16.f280060b);
                    this.f280113e.a("\u89c6\u9891\u94fe\u63a5\u5df2\u8fc7\u671f\uff0c\u5efa\u8bae\u5237\u65b0\u6216\u91cd\u65b0\u6253\u5f00\u9875\u9762");
                    String retryUrl = this.f280109a.getRetryUrl(str5, a16.f280060b, i16, null);
                    PlayerUtils.log(4, getLogTag(), "retryCount=" + a16.f280060b + " retryUrl=" + retryUrl);
                    b.b().stopPlay(dataSpec.uuid, str5);
                    if (!TextUtils.isEmpty(retryUrl)) {
                        if (!retryUrl.equals(str5)) {
                            return open(new DataSpec(Uri.parse(retryUrl), dataSpec.originUrl, dataSpec.absoluteStreamPosition, dataSpec.position, dataSpec.length, dataSpec.key, dataSpec.flags, dataSpec.uuid));
                        }
                        throw httpDataSourceException;
                    }
                    throw httpDataSourceException;
                }
            } else if (httpDataSourceException instanceof HttpDataSource.MalformedResponseException) {
                PlayerUtils.log(4, getLogTag(), "HttpDataSource.MalformedResponseException");
                return super.open(dataSpec);
            }
            PlayerUtils.log(4, getLogTag(), "throw exception = " + httpDataSourceException.toString());
            throw httpDataSourceException;
        }
        throw new HttpDataSource.InterruptConnectServerException("retryTcOpen interrupted UuidDeleted" + this.f280110b, getDataSpec());
    }
}
