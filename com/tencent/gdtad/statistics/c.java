package com.tencent.gdtad.statistics;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.ad.tangram.Ad;
import com.tencent.gdtad.log.GdtLog;

/* compiled from: P */
/* loaded from: classes6.dex */
public class c {
    public static void a(@NonNull Ad ad5, int i3) {
        if (ad5 != null && !TextUtils.isEmpty(ad5.getUrlForEffect())) {
            GdtLog.i("GdtTraceReporter", String.format("report %d", Integer.valueOf(i3)));
            GdtReporter.doCgiReport(ad5.getUrlForEffect().replaceAll("__CLICK_ID__", ad5.getTraceId()).replaceAll("__ACTION_ID__", String.valueOf(i3)));
        } else {
            GdtLog.e("GdtTraceReporter", String.format("report %d error", Integer.valueOf(i3)));
        }
    }
}
