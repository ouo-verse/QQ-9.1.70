package com.tencent.richframework.engineer.test.api;

import com.tencent.biz.richframework.delegate.impl.RFWLog;

/* compiled from: P */
/* loaded from: classes25.dex */
public class RFWExecutorFactory {
    public static RFWRuleExecutor createRuleExecutor(Class<RFWRuleExecutor> cls) {
        if (cls == null) {
            RFWLog.e("RFWRuleExecutorFactory", RFWLog.USR, "createRuleExecutor aClass is null");
            return null;
        }
        try {
            return cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e16) {
            RFWLog.e("RFWRuleExecutorFactory", RFWLog.USR, "createRuleExecutor error:" + e16);
            return null;
        }
    }

    public static RFWRuleExecutor createRuleExecutor(String str) {
        try {
            return createRuleExecutor((Class<RFWRuleExecutor>) Class.forName(str));
        } catch (ClassNotFoundException e16) {
            RFWLog.e("RFWRuleExecutorFactory", RFWLog.USR, "createRuleExecutor error:" + e16);
            return null;
        }
    }
}
