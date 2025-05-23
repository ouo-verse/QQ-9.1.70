package com.tencent.ad.tangram.analysis.sqlite;

import android.content.ContentValues;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.ad.tangram.analysis.AdAnalysisEvent;
import com.tencent.biz.common.util.WebViewConstants;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class AdAnalysisSQLiteEntry {

    @Nullable
    public String eventString;
    public int strategy;
    public long timeMillis;

    @Nullable
    public String uuid;

    public AdAnalysisSQLiteEntry() {
        this.timeMillis = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        this.strategy = Integer.MIN_VALUE;
    }

    @Nullable
    public ContentValues getContentValues() {
        if (!isValid()) {
            return null;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("uuid", this.uuid);
        contentValues.put(AdAnalysisSQLiteColumns.COLUMN_NAME_TIME_MILLIS, Long.valueOf(this.timeMillis));
        contentValues.put(AdAnalysisSQLiteColumns.COLUMN_NAME_STRATEGY, Integer.valueOf(this.strategy));
        contentValues.put("event", this.eventString);
        return contentValues;
    }

    public boolean isValid() {
        if (!TextUtils.isEmpty(this.uuid) && this.timeMillis != WebViewConstants.WV.ENABLE_WEBAIO_SWITCH && this.strategy != Integer.MIN_VALUE && !TextUtils.isEmpty(this.eventString)) {
            return true;
        }
        return false;
    }

    public AdAnalysisSQLiteEntry(@Nullable AdAnalysisEvent adAnalysisEvent) {
        this.timeMillis = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        this.strategy = Integer.MIN_VALUE;
        if (adAnalysisEvent == null) {
            return;
        }
        this.uuid = adAnalysisEvent.getUUID();
        this.timeMillis = adAnalysisEvent.getTime();
        this.strategy = adAnalysisEvent.getStrategy();
        this.eventString = adAnalysisEvent.toString();
    }
}
