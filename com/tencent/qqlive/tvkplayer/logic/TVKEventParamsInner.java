package com.tencent.qqlive.tvkplayer.logic;

import android.text.TextUtils;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import java.util.HashMap;

/* loaded from: classes23.dex */
public class TVKEventParamsInner extends ITVKPlayerEventListener.EventParams {

    /* loaded from: classes23.dex */
    public static class Builder {
        private TVKEventParamsInner paramsInner = new TVKEventParamsInner();

        public Builder addExtraParam(String str, Object obj) {
            if (TextUtils.isEmpty(str)) {
                return this;
            }
            if (((ITVKPlayerEventListener.EventParams) this.paramsInner).extraParam == null) {
                ((ITVKPlayerEventListener.EventParams) this.paramsInner).extraParam = new HashMap();
            }
            ((ITVKPlayerEventListener.EventParams) this.paramsInner).extraParam.put(str, obj);
            return this;
        }

        public TVKEventParamsInner build() {
            return this.paramsInner;
        }

        public Builder currentPosMs(long j3) {
            ((ITVKPlayerEventListener.EventParams) this.paramsInner).currentPosMs = j3;
            return this;
        }

        public Builder flowId(String str) {
            ((ITVKPlayerEventListener.EventParams) this.paramsInner).flowId = str;
            return this;
        }
    }

    public TVKEventParamsInner() {
        this.eventTime = System.currentTimeMillis();
    }
}
