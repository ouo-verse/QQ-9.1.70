package com.tencent.qqlive.common.ratelimit;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qqlive.common.api.IAegisLogApi;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 %2\u00020\u0001:\u0001\nB\u0013\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b#\u0010$J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR \u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000f0\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0010R0\u0010\u0016\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u0012j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004`\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R&\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u001aj\b\u0012\u0004\u0012\u00020\u0002`\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006&"}, d2 = {"Lcom/tencent/qqlive/common/ratelimit/c;", "", "", "rateKey", "", "curTime", "Lcom/tencent/qqlive/common/ratelimit/RateLimitConfig;", DownloadInfo.spKey_Config, "", "b", "a", "Lcom/tencent/qqlive/common/ratelimit/RateLimitConfig;", "getConfig", "()Lcom/tencent/qqlive/common/ratelimit/RateLimitConfig;", "Lcom/tencent/qqlive/common/ratelimit/LRULinkedHashMap;", "Lcom/tencent/qqlive/common/ratelimit/d;", "Lcom/tencent/qqlive/common/ratelimit/LRULinkedHashMap;", "mReqMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "c", "Ljava/util/HashMap;", "mAlarmMap", "d", "J", "mLastReqTimestamp", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "e", "Ljava/util/HashSet;", "whiteSet", "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "f", "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "aegisLog", "<init>", "(Lcom/tencent/qqlive/common/ratelimit/RateLimitConfig;)V", "g", "qq-live-common-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final RateLimitConfig config;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long mLastReqTimestamp;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IAegisLogApi aegisLog;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LRULinkedHashMap<String, d> mReqMap = new LRULinkedHashMap<>(50);

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<String, Long> mAlarmMap = new HashMap<>();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private HashSet<String> whiteSet = new HashSet<>();

    public c(@Nullable RateLimitConfig rateLimitConfig) {
        boolean z16;
        this.config = rateLimitConfig;
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        this.aegisLog = (IAegisLogApi) api;
        Intrinsics.checkNotNull(rateLimitConfig);
        List<String> whiteList = rateLimitConfig.getWhiteList();
        if (whiteList != null && !whiteList.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            HashSet<String> hashSet = this.whiteSet;
            List<String> whiteList2 = rateLimitConfig.getWhiteList();
            Intrinsics.checkNotNull(whiteList2);
            hashSet.addAll(whiteList2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0071, code lost:
    
        if ((r3.longValue() - r13) > r15.getAlertInterval()) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean b(String rateKey, long curTime, RateLimitConfig config) {
        d dVar = this.mReqMap.get(rateKey);
        Intrinsics.checkNotNull(dVar);
        long j3 = curTime - dVar.f345202c;
        dVar.f345202c = curTime;
        boolean z16 = false;
        if (j3 > config.getMinReqInterval()) {
            dVar.a();
        } else {
            dVar.f345201b.c(Long.valueOf(curTime));
            if (dVar.f345201b.d() == config.getFrequency()) {
                Long b16 = dVar.f345201b.b();
                Intrinsics.checkNotNullExpressionValue(b16, "reqTimestamps.first");
                long longValue = curTime - b16.longValue();
                if (longValue <= config.getPeriod()) {
                    if (this.mAlarmMap.containsKey(rateKey)) {
                        Long l3 = this.mAlarmMap.get(rateKey);
                        Intrinsics.checkNotNull(l3);
                    }
                    this.aegisLog.a("RateLimitController", rateKey + ",\u8be5\u547d\u4ee4\u5b57\u6700\u8fd1" + config.getFrequency() + "\u6b21\u8bf7\u6c42\u95f4\u9694\u65f6\u95f4\u8fc7\u77ed\u4e3a" + longValue + "ms,\u6700\u8fd1\u4e24\u6b21\u8bf7\u6c42\u95f4\u9694\u4e3a" + j3 + "ms,\u5df2\u8fc7\u6ee4\u6b64\u6b21\u8bf7\u6c42,\u8be5\u544a\u8b66" + config.getAlertInterval() + "ms\u5185\u53ea\u544a\u8b66\u4e00\u6b21");
                    this.mAlarmMap.put(rateKey, Long.valueOf(curTime));
                    if (config.getEnableFrequencyFix() != 0) {
                        z16 = true;
                    }
                }
            }
        }
        this.mReqMap.put(rateKey, dVar);
        return z16;
    }

    public boolean a(@NotNull String rateKey) {
        Intrinsics.checkNotNullParameter(rateKey, "rateKey");
        boolean z16 = false;
        if (!TextUtils.isEmpty(rateKey) && !this.whiteSet.contains(rateKey)) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j3 = elapsedRealtime - this.mLastReqTimestamp;
            RateLimitConfig rateLimitConfig = this.config;
            Intrinsics.checkNotNull(rateLimitConfig);
            if (j3 > rateLimitConfig.getPeriod()) {
                this.mReqMap.clear();
                this.mReqMap.put(rateKey, new d(rateKey, this.config.getFrequency()));
            } else if (this.mReqMap.containsKey(rateKey)) {
                z16 = b(rateKey, elapsedRealtime, this.config);
            } else {
                this.mReqMap.put(rateKey, new d(rateKey, this.config.getFrequency()));
            }
            this.mLastReqTimestamp = elapsedRealtime;
        }
        return z16;
    }
}
