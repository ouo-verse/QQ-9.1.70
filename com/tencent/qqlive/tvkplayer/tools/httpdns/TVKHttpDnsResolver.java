package com.tencent.qqlive.tvkplayer.tools.httpdns;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.qqlive.tvkplayer.api.ITVKHttpDnsResolver;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import com.tencent.qqlive.tvkplayer.tools.http.TVKHttpProcessorFactory;
import com.tencent.qqlive.tvkplayer.tools.http.api.ITVKHttpProcessor;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKGlobalEventNotifier;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKHttpUtils;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKUrlBuilder;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKHttpDnsResolver implements ITVKHttpDnsResolver {
    private static final long CACHE_TTL_MS = 120000;
    private static final String HTTP_REQUEST_TAG = "TVKHttpDnsResolver";
    private static final int REQUEST_TIMEOUT_MS = 2000;
    private static final String TAG = "[TVKPlayer]TVKHttpDnsResolver";
    private static final TVKHttpDnsResolver sInstance = new TVKHttpDnsResolver();
    private final Map<String, DnsCacheInfo> mCachedIpAddresses = new ConcurrentHashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class DnsCacheInfo {
        private final long mExpiredTimeMs;
        private final List<InetAddress> mIpAddressList;

        public DnsCacheInfo(List<InetAddress> list, long j3) {
            this.mIpAddressList = list;
            this.mExpiredTimeMs = j3;
        }

        public long getExpiredTimeMs() {
            return this.mExpiredTimeMs;
        }

        public List<InetAddress> getIpAddressList() {
            return this.mIpAddressList;
        }
    }

    TVKHttpDnsResolver() {
        TVKGlobalEventNotifier.getInstance().addEventListener(new TVKGlobalEventNotifier.OnGlobalEventChangeListener() { // from class: com.tencent.qqlive.tvkplayer.tools.httpdns.a
            @Override // com.tencent.qqlive.tvkplayer.tools.utils.TVKGlobalEventNotifier.OnGlobalEventChangeListener
            public final void onEvent(int i3, int i16, int i17, Object obj) {
                TVKHttpDnsResolver.this.lambda$new$0(i3, i16, i17, obj);
            }
        });
    }

    public static TVKHttpDnsResolver getInstance() {
        return sInstance;
    }

    private String getResponseContent(ITVKHttpProcessor.TVKHttpResponse tVKHttpResponse) {
        try {
            String str = new String(tVKHttpResponse.getData(), StandardCharsets.UTF_8);
            TVKLogUtil.i(TAG, "httpdns response dnsContent = " + str);
            int i3 = TVKMediaPlayerConfig.PlayerConfig.http_dns_request_type;
            if (i3 != 0) {
                if (i3 != 1) {
                    return str;
                }
                return TVKHttpDnsCryptoUtils.decrypt(str, TVKHttpDnsCryptoUtils.ENCRYPTION_TYPE_AES);
            }
            return TVKHttpDnsCryptoUtils.decrypt(str, TVKHttpDnsCryptoUtils.ENCRYPTION_TYPE_DES);
        } catch (Exception e16) {
            TVKLogUtil.e(TAG, e16);
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(int i3, int i16, int i17, Object obj) {
        if (i3 == 100003) {
            clearDnsCache();
        }
    }

    private List<InetAddress> parseIpAddressFromResponse(String str) {
        TVKLogUtil.i(TAG, "decrypt dnsContent = " + str);
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        try {
            Iterator<String> it = TVKHttpUtils.getIpAddress(str).iterator();
            while (it.hasNext()) {
                arrayList.add(InetAddress.getByName(it.next()));
            }
        } catch (Exception e16) {
            TVKLogUtil.e(TAG, e16);
        }
        return arrayList;
    }

    public void clearDnsCache() {
        TVKLogUtil.i(TAG, "clear httpDns Cache");
        this.mCachedIpAddresses.clear();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKHttpDnsResolver
    public synchronized List<InetAddress> lookup(String str) {
        if (TextUtils.isEmpty(str)) {
            TVKLogUtil.i(TAG, "hostname is empty");
            return Collections.emptyList();
        }
        if (TVKHttpUtils.isIpAddress(str)) {
            TVKLogUtil.i(TAG, "hostname: " + str + " is pure ip");
            try {
                return Arrays.asList(InetAddress.getByName(str));
            } catch (UnknownHostException unused) {
                return Collections.emptyList();
            }
        }
        DnsCacheInfo dnsCacheInfo = this.mCachedIpAddresses.get(str);
        if (dnsCacheInfo != null && SystemClock.elapsedRealtime() < dnsCacheInfo.getExpiredTimeMs()) {
            return dnsCacheInfo.getIpAddressList();
        }
        try {
            TVKHttpDnsRequestBuilder tVKHttpDnsRequestBuilder = new TVKHttpDnsRequestBuilder(str);
            String buildUrl = new TVKUrlBuilder().setUrl(tVKHttpDnsRequestBuilder.buildRequestUrl()).addParam(tVKHttpDnsRequestBuilder.buildRequestParams()).buildUrl();
            TVKLogUtil.i(TAG, "httpdns request url = " + buildUrl);
            List<InetAddress> parseIpAddressFromResponse = parseIpAddressFromResponse(getResponseContent(TVKHttpProcessorFactory.getHttpRequester().execute(new ITVKHttpProcessor.TVKHttpRequest.Builder(ITVKHttpProcessor.TVKHttpRequest.HttpMethod.GET, buildUrl).reqTag(HTTP_REQUEST_TAG).callTimeoutMs(2000L).build())));
            if (!parseIpAddressFromResponse.isEmpty()) {
                this.mCachedIpAddresses.put(str, new DnsCacheInfo(parseIpAddressFromResponse, SystemClock.elapsedRealtime() + 120000));
            }
            return parseIpAddressFromResponse;
        } catch (Exception e16) {
            TVKLogUtil.e(TAG, e16);
            return Collections.emptyList();
        }
    }
}
