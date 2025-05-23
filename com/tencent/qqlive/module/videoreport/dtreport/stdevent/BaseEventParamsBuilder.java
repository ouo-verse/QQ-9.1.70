package com.tencent.qqlive.module.videoreport.dtreport.stdevent;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes22.dex */
abstract class BaseEventParamsBuilder<T> implements IEventParamsBuilder {
    Map<String, String> mEventParams = new HashMap();

    /* loaded from: classes22.dex */
    static class CheckResult {
        final String errMsg;
        final boolean success;

        public CheckResult(boolean z16, String str) {
            this.success = z16;
            this.errMsg = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean checkSingleParam(StringBuilder sb5, String str, Object obj) {
        String obj2;
        if (obj == null) {
            obj2 = null;
        } else {
            obj2 = obj.toString();
        }
        if (TextUtils.isEmpty(obj2)) {
            sb5.append("[");
            sb5.append(str);
            sb5.append("] \u662f\u5fc5\u586b\u9879\uff0c\u8bf7\u4fee\u6539\n");
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract CheckResult checkValidity();

    /* JADX INFO: Access modifiers changed from: package-private */
    public void putSingleParam(Map<String, String> map, String str, Object obj) {
        String obj2;
        if (obj == null) {
            obj2 = null;
        } else {
            obj2 = obj.toString();
        }
        map.put(str, obj2);
    }

    public T setCustomParams(Map<String, String> map) {
        if (map != null) {
            this.mEventParams.putAll(map);
        }
        return self();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public T self() {
        return this;
    }
}
