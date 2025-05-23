package com.tencent.qqlive.tvkplayer.context;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.api.ITVKReportEventListener;
import java.util.Collections;
import java.util.HashMap;

/* loaded from: classes23.dex */
public class TVKReportEventParamsInner extends ITVKReportEventListener.ReportEventParams {

    /* loaded from: classes23.dex */
    public static class Builder {
        private final TVKReportEventParamsInner mParams = new TVKReportEventParamsInner();

        public Builder addReportMapParam(String str, Object obj) {
            if (TextUtils.isEmpty(str)) {
                return this;
            }
            if (((ITVKReportEventListener.ReportEventParams) this.mParams).reportMap == null) {
                ((ITVKReportEventListener.ReportEventParams) this.mParams).reportMap = new HashMap();
            }
            ((ITVKReportEventListener.ReportEventParams) this.mParams).reportMap.put(str, obj);
            return this;
        }

        public TVKReportEventParamsInner build() {
            return this.mParams;
        }

        public Builder flowId(String str) {
            ((ITVKReportEventListener.ReportEventParams) this.mParams).flowId = str;
            return this;
        }

        public Builder setTimeSince1970Ms(long j3) {
            ((ITVKReportEventListener.ReportEventParams) this.mParams).timeSince1970Ms = j3;
            return this;
        }
    }

    @NonNull
    public String toString() {
        return "TimeSince1970Ms=" + getTimeSince1970Ms() + ", " + Collections.singletonList(getReportMap());
    }

    TVKReportEventParamsInner() {
        this.timeSince1970Ms = System.currentTimeMillis();
    }
}
