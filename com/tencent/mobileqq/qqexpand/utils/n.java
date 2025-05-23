package com.tencent.mobileqq.qqexpand.utils;

import android.net.TrafficStats;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/qqexpand/utils/n;", "", "", "startSize", "", "b", WidgetCacheConstellationData.INTERVAL, "", "bytes", "a", "<init>", "()V", "qqexpand_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class n {
    private final double b(long startSize) {
        return ((TrafficStats.getTotalRxBytes() - startSize) / 1024) * 1.0d;
    }

    public final double a(double interval, int bytes, long startSize) {
        double b16 = b(startSize);
        double d16 = b16 / interval;
        QLog.d("NetSpeedChecker", 4, "downloadData " + b16 + " speed " + d16 + " kb/s bytes " + bytes);
        return (bytes / 1024) / d16;
    }
}
