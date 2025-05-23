package com.tencent.gdtad.statistics;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.ad.tangram.Ad;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.qqproxy.GdtVersionUtil;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import tencent.gdt.landing_page_collect_data;

/* compiled from: P */
/* loaded from: classes6.dex */
public class GdtActionReporter {
    private static final String TAG = "GdtActionReporter";

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class Params {

        /* renamed from: ad, reason: collision with root package name */
        public Ad f109471ad;

        @NonNull
        public landing_page_collect_data.LandingPageCollectData data = new landing_page_collect_data.LandingPageCollectData();

        public boolean isValid() {
            landing_page_collect_data.LandingPageCollectData landingPageCollectData;
            Ad ad5 = this.f109471ad;
            if (ad5 != null && !TextUtils.isEmpty(ad5.getUrlForAction()) && !TextUtils.isEmpty(this.f109471ad.getTraceId()) && (landingPageCollectData = this.data) != null && landingPageCollectData.landing_page_action_type.has()) {
                return true;
            }
            return false;
        }
    }

    public static void report(@Nullable Params params) {
        if (params != null && params.isValid()) {
            try {
                String replace = params.f109471ad.getUrlForAction().replace("__TRACE_ID__", URLEncoder.encode(params.f109471ad.getTraceId(), "utf-8")).replace("__PAGE_ACTION_ID__", String.valueOf(params.data.landing_page_action_type.get()));
                if (params.data.latency_ms.has()) {
                    replace = replace.replace("__PAGE_TIME__", String.valueOf(params.data.latency_ms.get()));
                }
                if (params.data.landing_error_code.has()) {
                    replace = replace.replace("__LANDING_ERROR_CODE__", String.valueOf(params.data.landing_error_code.get()));
                }
                String replace2 = replace.replace("__OS_TYPE__", String.valueOf(2)).replace("__VERSION__", URLEncoder.encode(GdtVersionUtil.getQQVersion(), "utf-8"));
                GdtLog.i(TAG, "GdtActionReporter report url = " + replace2);
                GdtReporter.doCgiReport(replace2);
                return;
            } catch (UnsupportedEncodingException e16) {
                GdtLog.e(TAG, "report error", e16);
                return;
            }
        }
        GdtLog.e(TAG, "report error");
    }
}
