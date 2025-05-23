package com.tencent.mobileqq.vasgift.utils;

import android.util.LruCache;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

/* compiled from: P */
/* loaded from: classes20.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private static final LruCache<String, Long> f312029a = new LruCache<>(100);

    public static void a(@NonNull String str) {
        try {
            f312029a.remove(str);
        } catch (Exception e16) {
            QLog.e("QQGiftResDownloadUtil", 1, "clearNeedDownload e:" + e16.getMessage());
        }
    }

    public static boolean b(@NonNull String str) {
        if (VasToggle.VAS_GUILD_GIFT_DOWNLOAD_CONFIG.isEnable(true)) {
            return true;
        }
        LruCache<String, Long> lruCache = f312029a;
        Long l3 = lruCache.get(str);
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        if (l3 == null) {
            lruCache.put(str, valueOf);
            return true;
        }
        if (Math.abs(valueOf.longValue() - l3.longValue()) >= 120000) {
            lruCache.put(str, valueOf);
            return true;
        }
        return false;
    }

    public static boolean c(@NonNull String str, String str2) {
        if (VasToggle.VAS_GUILD_GIFT_DOWNLOAD_CONFIG.isEnable(true)) {
            return !new File(str2).exists();
        }
        return b(str);
    }
}
