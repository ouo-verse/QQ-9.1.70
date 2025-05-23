package com.huya.huyasdk.api;

import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huya.huyasdk.data.HYNSRequest;
import com.huya.huyasdk.jce.GetCdnTokenExReq;
import com.huya.huyasdk.jce.GetCdnTokenExRsp;
import com.huya.huyasdk.jce.UserId;
import hynb.b.h;
import hynb.b.l;
import hynb.n.a;
import hynb.o.e;
import hynb.p.g;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes2.dex */
public class HuyaLiveStream {
    public static final String TAG = "HuyaHuyaLiveStream";

    public static Uri buildNewUriWithToken(Uri uri, String str) {
        String[] split = str.split(ContainerUtils.FIELD_DELIMITER);
        HashMap hashMap = new HashMap();
        for (String str2 : split) {
            String[] split2 = str2.split(ContainerUtils.KEY_VALUE_DELIMITER);
            if (split2.length == 2) {
                hashMap.put(split2[0], split2[1]);
            }
        }
        Set<String> queryParameterNames = uri.getQueryParameterNames();
        Uri.Builder path = new Uri.Builder().scheme(uri.getScheme()).authority(uri.getAuthority()).path(uri.getPath());
        for (String str3 : queryParameterNames) {
            if (!hashMap.containsKey(str3)) {
                path.appendQueryParameter(str3, uri.getQueryParameter(str3));
            }
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            path.appendQueryParameter((String) entry.getKey(), (String) entry.getValue());
        }
        return path.build();
    }

    public static void refreshTokenWithStreamUrl(final String str, final UrlCallback urlCallback) {
        String str2;
        int i3;
        try {
            UserId a16 = e.a(l.i().m());
            final Uri parse = Uri.parse(str);
            String scheme = parse.getScheme();
            String host = parse.getHost();
            String path = parse.getPath();
            try {
                str2 = new URI(scheme, host, path.substring(0, path.lastIndexOf(47)), null, null).toString();
            } catch (Exception e16) {
                g.f406799a.error(TAG, "resolvedUri failed : " + e16);
                str2 = "";
            }
            String substring = path.substring(path.lastIndexOf(47) + 1, path.lastIndexOf(46));
            GetCdnTokenExReq getCdnTokenExReq = new GetCdnTokenExReq();
            getCdnTokenExReq.tId = a16;
            getCdnTokenExReq.sFlvUrl = str2;
            getCdnTokenExReq.sStreamName = substring;
            if (a.a().f406767a.f406775h) {
                i3 = 67;
            } else {
                i3 = 66;
            }
            getCdnTokenExReq.iAppId = i3;
            g.f406799a.a(TAG, "refreshTokenWithStreamUrl: " + getCdnTokenExReq);
            l.i().b(new HYNSRequest.Builder().sServantName("liveui").sFuncName("getCdnTokenInfoEx").jsonBodyObj(getCdnTokenExReq).build(), new h<GetCdnTokenExRsp>() { // from class: com.huya.huyasdk.api.HuyaLiveStream.1
                @Override // hynb.b.h
                public Class<GetCdnTokenExRsp> getResponseClass() {
                    return GetCdnTokenExRsp.class;
                }

                @Override // hynb.b.h
                public void onError(int i16, String str3, GetCdnTokenExRsp getCdnTokenExRsp) {
                    g.f406799a.c(HuyaLiveStream.TAG, "genLiveStreamUrl failed, retValue: %s, errMsg: %s, rsp: %s", Integer.valueOf(i16), str3, getCdnTokenExRsp);
                    UrlCallback urlCallback2 = urlCallback;
                    if (urlCallback2 != null) {
                        urlCallback2.onUrlCallback(str, new IllegalStateException(str3));
                    }
                }

                @Override // hynb.b.h
                public void onResponse(GetCdnTokenExRsp getCdnTokenExRsp) {
                    if (getCdnTokenExRsp != null && !TextUtils.isEmpty(getCdnTokenExRsp.sFlvToken)) {
                        String uri = HuyaLiveStream.buildNewUriWithToken(parse, getCdnTokenExRsp.sFlvToken).toString();
                        g.f406799a.a(HuyaLiveStream.TAG, "genLiveStreamUrl success with token: " + getCdnTokenExRsp + " url: " + uri);
                        UrlCallback urlCallback2 = urlCallback;
                        if (urlCallback2 != null) {
                            urlCallback2.onUrlCallback(uri, null);
                            return;
                        }
                        return;
                    }
                    String str3 = getCdnTokenExRsp == null ? "response is null" : "flvToken is empty";
                    UrlCallback urlCallback3 = urlCallback;
                    if (urlCallback3 != null) {
                        urlCallback3.onUrlCallback("", new IllegalStateException(str3));
                    }
                }
            });
        } catch (Throwable th5) {
            if (urlCallback != null) {
                urlCallback.onUrlCallback("", th5);
            }
        }
    }
}
