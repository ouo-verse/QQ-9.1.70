package com.tencent.ad.tangram.analysis;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.ad.tangram.annotation.AdKeep;
import com.tencent.ad.tangram.json.AdJSON;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.protocol.gdt_analysis_event;
import com.tencent.biz.common.util.WebViewConstants;
import java.util.UUID;

/* compiled from: P */
@AdKeep
/* loaded from: classes3.dex */
public final class AdAnalysisEvent {
    public static final int STRATEGY_BATCH = 102;
    public static final int STRATEGY_BATCH_WITHOUT_ABTEST = 103;
    public static final int STRATEGY_INSTANT = 101;
    private static final String TAG = "AdAnalysisEvent";
    private gdt_analysis_event event;
    private int strategy;
    private String uuid;

    public AdAnalysisEvent(gdt_analysis_event gdt_analysis_eventVar, int i3) {
        this.strategy = Integer.MIN_VALUE;
        this.event = gdt_analysis_eventVar;
        try {
            this.uuid = UUID.randomUUID().toString();
        } catch (Throwable th5) {
            AdLog.e(TAG, "[AdAnalysisEvent] create UUID error", th5);
        }
        this.strategy = i3;
    }

    @Nullable
    public String getId() {
        if (isValid()) {
            return this.event.eventId;
        }
        return null;
    }

    public int getStrategy() {
        if (isValid()) {
            return this.strategy;
        }
        return Integer.MIN_VALUE;
    }

    public long getTime() {
        if (!isValid()) {
            AdLog.e(TAG, "getTime error");
            return WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        }
        try {
            return Long.valueOf(this.event.currentTime).longValue();
        } catch (Throwable th5) {
            AdLog.e(TAG, "getTime", th5);
            return WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        }
    }

    @Nullable
    public String getUUID() {
        if (isValid()) {
            return this.uuid;
        }
        return null;
    }

    public boolean isValid() {
        gdt_analysis_event gdt_analysis_eventVar = this.event;
        if (gdt_analysis_eventVar != null && !TextUtils.isEmpty(gdt_analysis_eventVar.eventId) && this.event.currentTime != WebViewConstants.WV.ENABLE_WEBAIO_SWITCH && !TextUtils.isEmpty(this.uuid) && this.strategy != Integer.MIN_VALUE) {
            return true;
        }
        return false;
    }

    @Nullable
    public String toString() {
        Object obj;
        if (!isValid()) {
            AdLog.e(TAG, "toString error");
            return null;
        }
        try {
            obj = AdJSON.fromObject(this.event);
        } catch (Throwable th5) {
            AdLog.e(TAG, "toString", th5);
            obj = null;
        }
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }
}
