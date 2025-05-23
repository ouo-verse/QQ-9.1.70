package com.tencent.mobileqq.kandian.biz.video;

import android.content.Context;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.video.api.IBandwidthMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISPBandwidthMonitor;
import com.tencent.superplayer.api.SuperPlayerFactory;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import r62.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\r\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00110\u0010H\u0002J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/kandian/biz/video/BandwidthMonitor;", "Lcom/tencent/mobileqq/kandian/biz/video/api/IBandwidthMonitor;", "()V", "ACTION", "", "TAG", "enable", "", "getEnable", "()Z", "isADEnable", "monitor", "Lcom/tencent/superplayer/api/ISPBandwidthMonitor;", "dealCallback", "", "stats", "", "Lcom/tencent/superplayer/api/ISPBandwidthMonitor$Stat;", "start", "context", "Landroid/content/Context;", "stop", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class BandwidthMonitor implements IBandwidthMonitor {
    private static final String ACTION = "0X800BD0B";
    private static final String TAG = "BandwidthMonitor";
    public static final BandwidthMonitor INSTANCE = new BandwidthMonitor();
    private static final boolean enable = true;
    private static final boolean isADEnable = false;
    private static ISPBandwidthMonitor monitor = SuperPlayerFactory.createBandwidthMonitor(104);

    BandwidthMonitor() {
    }

    private final void dealCallback(Map<String, ? extends ISPBandwidthMonitor.Stat> stats) {
        long currentTimeMillis = System.currentTimeMillis();
        for (Map.Entry<String, ? extends ISPBandwidthMonitor.Stat> entry : stats.entrySet()) {
            ISPBandwidthMonitor.Stat value = entry.getValue();
            String key = entry.getKey();
            long j3 = value.httpBandwidth;
            long j16 = value.pcdnBandwidth;
            long j17 = value.p2pBandwidth;
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "dealCallback: host=" + key + ", httpBw=" + j3 + ", pcdnBw=" + j16 + ", p2pBw=" + j17);
            }
            if (j3 > 0 || j16 > 0 || j17 > 0) {
                String a16 = new b.a("").put("report_timestamp", Long.valueOf(currentTimeMillis)).put("host", key).put("httpBw", Long.valueOf(j3)).put("pcdnBw", Long.valueOf(j16)).put("p2pBw", Long.valueOf(j17)).a();
                Intrinsics.checkNotNullExpressionValue(a16, "Builder(\"\")\n            \u2026          .toJsonString()");
                PublicAccountReportUtils.l(null, "", ACTION, ACTION, 0, 0, "", "", "", a16, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void start$lambda$0(Map it) {
        BandwidthMonitor bandwidthMonitor = INSTANCE;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        bandwidthMonitor.dealCallback(it);
    }

    public final boolean getEnable() {
        return enable;
    }

    public final boolean isADEnable() {
        return isADEnable;
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.api.IBandwidthMonitor
    public void start(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (enable) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "start: ");
            }
            ISPBandwidthMonitor iSPBandwidthMonitor = monitor;
            if (iSPBandwidthMonitor != null) {
                iSPBandwidthMonitor.start(context, new ISPBandwidthMonitor.Callback() { // from class: com.tencent.mobileqq.kandian.biz.video.a
                    @Override // com.tencent.superplayer.api.ISPBandwidthMonitor.Callback
                    public final void onBandwidthUpdate(Map map) {
                        BandwidthMonitor.start$lambda$0(map);
                    }
                }, 60000L);
            }
        }
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.api.IBandwidthMonitor
    public void stop(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (enable) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "stop: ");
            }
            ISPBandwidthMonitor iSPBandwidthMonitor = monitor;
            if (iSPBandwidthMonitor != null) {
                iSPBandwidthMonitor.stop(context);
            }
        }
    }
}
