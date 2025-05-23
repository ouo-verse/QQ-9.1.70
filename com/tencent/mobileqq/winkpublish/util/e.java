package com.tencent.mobileqq.winkpublish.util;

import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.util.NetworkState;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/util/e;", "", "", "fileSize", "b", "", "exportType", "videoDurationMs", "a", "<init>", "()V", "qq_winkpublish_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f327447a = new e();

    e() {
    }

    public final long a(int exportType, long videoDurationMs) {
        double d16;
        if (exportType != 0) {
            d16 = 2.01d;
            if (exportType != 1) {
                if (exportType != 2) {
                    if (exportType != 3) {
                        if (exportType != 4) {
                            d16 = exportType != 5 ? 1.0d : 0.44d;
                        }
                    } else {
                        d16 = 1.01d;
                    }
                } else {
                    d16 = 23.56d;
                }
            }
        } else {
            d16 = 1.05d;
        }
        return (long) (videoDurationMs / d16);
    }

    public final long b(long fileSize) {
        long j3;
        int networkType = NetworkState.getNetworkType();
        if (networkType == 1) {
            j3 = LocalMultiProcConfig.getLong("key_video_compress_speed_WIFI", 1536000L);
        } else if (networkType == 2) {
            j3 = LocalMultiProcConfig.getLong("key_video_compress_speed_2G", 256000L);
        } else if (networkType == 3) {
            j3 = LocalMultiProcConfig.getLong("key_video_compress_speed_3G", 358400L);
        } else if (networkType == 4) {
            j3 = LocalMultiProcConfig.getLong("key_video_compress_speed_4G", 512000L);
        } else if (networkType != 5) {
            j3 = LocalMultiProcConfig.getLong("key_video_compress_speed_4G", 512000L);
        } else {
            j3 = LocalMultiProcConfig.getLong("key_video_compress_speed_5G", 1126400L);
        }
        return (((float) fileSize) * 1000.0f) / ((float) j3);
    }
}
