package com.tencent.mobileqq.utils.confighandler;

import com.tencent.mobileqq.utils.QQAudioHelper;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ConfigUtil {

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface DownloadStatus {
        public static final int downloading = 1;
        public static final int fail = -1;
        public static final int none = 0;
        public static final int suc = 2;
    }

    public static boolean isActivity(long j3, long j16) {
        long e16 = QQAudioHelper.e();
        if (j3 < e16 && j16 > e16) {
            return true;
        }
        return false;
    }

    public static boolean isExpired(long j3) {
        if (j3 < QQAudioHelper.e()) {
            return true;
        }
        return false;
    }
}
