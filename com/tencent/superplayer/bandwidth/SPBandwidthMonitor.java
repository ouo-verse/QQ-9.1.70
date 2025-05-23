package com.tencent.superplayer.bandwidth;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.superplayer.api.ISPBandwidthMonitor;
import com.tencent.superplayer.utils.CommonUtil;
import com.tencent.superplayer.utils.LogUtil;
import com.tencent.superplayer.utils.ThreadUtil;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyFactory;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes26.dex */
public class SPBandwidthMonitor implements ISPBandwidthMonitor {

    /* renamed from: a, reason: collision with root package name */
    private int f373892a;

    /* renamed from: b, reason: collision with root package name */
    private int f373893b;

    /* renamed from: e, reason: collision with root package name */
    private ITPDownloadProxy f373896e;

    /* renamed from: g, reason: collision with root package name */
    private ISPBandwidthMonitor.Callback f373898g;

    /* renamed from: i, reason: collision with root package name */
    private int f373900i;

    /* renamed from: c, reason: collision with root package name */
    private long f373894c = 60000;

    /* renamed from: d, reason: collision with root package name */
    private Map<String, ISPBandwidthMonitor.Stat> f373895d = new HashMap();

    /* renamed from: h, reason: collision with root package name */
    private boolean f373899h = false;

    /* renamed from: f, reason: collision with root package name */
    private final Handler f373897f = new Handler(ThreadUtil.getSubThreadLooper());

    public SPBandwidthMonitor(int i3) {
        this.f373892a = i3;
        b();
    }

    private void b() {
        int i3;
        if (this.f373896e == null && (i3 = this.f373892a) > 0) {
            int i16 = CommonUtil.i(i3);
            this.f373893b = i16;
            CommonUtil.j(i16);
            if (this.f373896e != null) {
                this.f373896e = TPDownloadProxyFactory.getTPDownloadProxy(this.f373893b);
            }
        }
    }

    private long c() {
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = this.f373894c;
        return j3 - (currentTimeMillis % j3);
    }

    private Map<String, ISPBandwidthMonitor.Stat> d(Map<String, ISPBandwidthMonitor.Stat> map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, ISPBandwidthMonitor.Stat> entry : map.entrySet()) {
            String key = entry.getKey();
            ISPBandwidthMonitor.Stat value = entry.getValue();
            ISPBandwidthMonitor.Stat stat = this.f373895d.get(key);
            if (stat != null) {
                hashMap.put(key, ISPBandwidthMonitor.Stat.diff(stat, value));
            } else {
                hashMap.put(key, value);
            }
        }
        return hashMap;
    }

    private Map<String, ISPBandwidthMonitor.Stat> e(String str) {
        HashMap hashMap = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject(String.valueOf(this.f373893b));
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str2 = (String) keys.next();
                JSONObject jSONObject2 = jSONObject.getJSONObject(str2);
                ISPBandwidthMonitor.Stat stat = new ISPBandwidthMonitor.Stat();
                stat.httpBandwidth = jSONObject2.optLong("http");
                stat.pcdnBandwidth = jSONObject2.optLong("pcdn");
                stat.p2pBandwidth = jSONObject2.optLong(TPReportKeys.Common.COMMON_P2P);
                stat.p2pUploadBandwidth = jSONObject2.optLong("p2pUpload");
                hashMap.put(str2, stat);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return hashMap;
    }

    private void f(long j3) {
        if (this.f373899h) {
            this.f373897f.postDelayed(new Runnable() { // from class: com.tencent.superplayer.bandwidth.SPBandwidthMonitor.3
                @Override // java.lang.Runnable
                public void run() {
                    SPBandwidthMonitor.this.g();
                }
            }, j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        b();
        long c16 = c();
        ITPDownloadProxy iTPDownloadProxy = this.f373896e;
        if (iTPDownloadProxy != null && this.f373898g != null) {
            String nativeInfo = iTPDownloadProxy.getNativeInfo(11);
            LogUtil.d("SPBandwidthMonitor", "sampleBandwidth, info=" + nativeInfo);
            if (!TextUtils.isEmpty(nativeInfo)) {
                Map<String, ISPBandwidthMonitor.Stat> e16 = e(nativeInfo);
                this.f373898g.onBandwidthUpdate(d(e16));
                this.f373895d = e16;
            }
            f(c16);
            return;
        }
        LogUtil.d("SPBandwidthMonitor", "sampleBandwidth, proxy or callback null");
        f(c16);
    }

    @Override // com.tencent.superplayer.api.ISPBandwidthMonitor
    public void start(Context context, ISPBandwidthMonitor.Callback callback, long j3) {
        if (this.f373900i <= 0 && callback != null) {
            LogUtil.d("SPBandwidthMonitor", "start, interval=" + j3);
            this.f373900i = context.hashCode();
            this.f373899h = true;
            this.f373898g = callback;
            if (j3 > 0) {
                this.f373894c = j3;
            }
            this.f373897f.removeCallbacksAndMessages(null);
            f(0L);
        }
    }

    @Override // com.tencent.superplayer.api.ISPBandwidthMonitor
    public void stop(Context context) {
        if (context.hashCode() == this.f373900i && this.f373899h) {
            LogUtil.d("SPBandwidthMonitor", "stop");
            this.f373899h = false;
            this.f373900i = 0;
            this.f373897f.removeCallbacksAndMessages(null);
            this.f373897f.post(new Runnable() { // from class: com.tencent.superplayer.bandwidth.SPBandwidthMonitor.1
                @Override // java.lang.Runnable
                public void run() {
                    SPBandwidthMonitor.this.g();
                }
            });
            this.f373897f.postDelayed(new Runnable() { // from class: com.tencent.superplayer.bandwidth.SPBandwidthMonitor.2
                @Override // java.lang.Runnable
                public void run() {
                    SPBandwidthMonitor.this.g();
                }
            }, 5000L);
        }
    }
}
