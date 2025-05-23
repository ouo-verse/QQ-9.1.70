package com.tenpay.api;

import android.content.Context;

/* compiled from: P */
/* loaded from: classes27.dex */
public class TenpayCache extends EnterBase<IApiCache> {
    public static final int TIME_LIMIT_DAY = 86400;
    public static final int TIME_LIMIT_HOUR = 3600;
    public static final int TIME_LIMIT_MINUTE = 60;
    public static final int TIME_MAX_LIMIT = 31536000;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface ICacheEnc {
        String cacheDec(String str);

        String cacheEnc(String str);

        String hashKey(String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class Ins {
        public static TenpayCache mins = new TenpayCache();

        Ins() {
        }
    }

    public static Object getUinValue(Context context, String str, String str2, Object obj) {
        IApiCache logic = instance().getLogic(context);
        if (logic != null) {
            return logic.getUinValue(str, str2, obj);
        }
        return null;
    }

    public static Object getValue(Context context, String str, Object obj) {
        IApiCache logic = instance().getLogic(context);
        if (logic != null) {
            return logic.getValue(str, obj);
        }
        return null;
    }

    public static TenpayCache instance() {
        return Ins.mins;
    }

    public static void removeKey(Context context, String str) {
        IApiCache logic = instance().getLogic(context);
        if (logic != null) {
            logic.removeKey(str);
        }
    }

    public static void removeUinKey(Context context, String str, String str2) {
        IApiCache logic = instance().getLogic(context);
        if (logic != null) {
            logic.removeUinKey(str, str2);
        }
    }

    public static boolean resetCacheTime(Context context, String str, long j3) {
        IApiCache logic = instance().getLogic(context);
        if (logic != null) {
            return logic.resetCacheTime(str, j3);
        }
        return false;
    }

    public static boolean resetUinCacheTime(Context context, String str, String str2, long j3) {
        IApiCache logic = instance().getLogic(context);
        if (logic != null) {
            return logic.resetUinCacheTime(str, str2, j3);
        }
        return false;
    }

    public static void setUinValue(Context context, String str, String str2, Object obj, long j3) {
        IApiCache logic = instance().getLogic(context);
        if (logic != null) {
            logic.setUinValue(str, str2, obj, j3);
        }
    }

    public static void setValue(Context context, String str, Object obj, long j3) {
        IApiCache logic = instance().getLogic(context);
        if (logic != null) {
            logic.setValue(str, obj, j3);
        }
    }

    @Override // com.tenpay.api.EnterBase
    protected String enterApi() {
        return IApiCache.LOGIC;
    }

    TenpayCache() {
    }
}
