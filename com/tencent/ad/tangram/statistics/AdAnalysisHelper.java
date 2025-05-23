package com.tencent.ad.tangram.statistics;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.analysis.AdAnalysisUtil;
import com.tencent.ad.tangram.annotation.AdKeep;
import com.tencent.ad.tangram.protocol.gdt_analysis_event;

/* compiled from: P */
@AdKeep
/* loaded from: classes3.dex */
public final class AdAnalysisHelper {
    @NonNull
    public static gdt_analysis_event createEventForAd(Context context, int i3, @Nullable Ad ad5) {
        String str;
        int i16;
        String str2 = null;
        if (ad5 != null) {
            str = ad5.getPosId();
        } else {
            str = null;
        }
        if (ad5 != null) {
            str2 = String.valueOf(ad5.getAId());
        }
        if (ad5 != null) {
            i16 = ad5.getCreativeSize();
        } else {
            i16 = Integer.MIN_VALUE;
        }
        int i17 = 0;
        if (ad5 != null && !TextUtils.isEmpty(ad5.getExtJSON())) {
            i17 = 1;
        }
        gdt_analysis_event gdt_analysis_eventVar = new gdt_analysis_event();
        AdAnalysisUtil.initEvent(context, i3, gdt_analysis_eventVar);
        gdt_analysis_eventVar.posId = str;
        gdt_analysis_eventVar.aid = str2;
        gdt_analysis_eventVar.creativeSize = i16;
        gdt_analysis_eventVar.networkType = i17;
        return gdt_analysis_eventVar;
    }
}
