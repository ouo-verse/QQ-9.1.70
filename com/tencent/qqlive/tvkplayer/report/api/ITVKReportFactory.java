package com.tencent.qqlive.tvkplayer.report.api;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqlive.tvkplayer.context.TVKContext;
import com.tencent.qqlive.tvkplayer.plugin.ITVKPlugin;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes23.dex */
public interface ITVKReportFactory {

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes23.dex */
    public @interface QualityReportType {
        public static final String QUALITY_REPORT_DA_V = "quality_report_da_v";
        public static final String QUALITY_REPORT_FEITIAN = "quality_report_feitian";
        public static final String QUALITY_REPORT_LIVE_PERIOD = "quality_report_live_period";
        public static final String QUALITY_REPORT_MEDIALABVR = "quality_report_medialabvr";
    }

    @NonNull
    ITVKDeviceCapabilityReport createDeviceCapabilityReport();

    @Nullable
    ITVKPlugin createQualityReport(@NonNull TVKContext tVKContext, String str);
}
