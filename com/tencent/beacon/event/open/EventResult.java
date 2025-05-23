package com.tencent.beacon.event.open;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class EventResult {
    public static final int ERROR_CODE_LOGID_NOT_INIT = 107;
    public static final int ERROR_CODE_NAME_NULL = 106;
    public static final int ERROR_CODE_NOT_ENABLE = 102;
    public static final int ERROR_CODE_OFFER_FAIL = 103;
    public static final int ERROR_CODE_OTHER = 199;
    public static final int ERROR_CODE_PREVENT = 100;
    public static final int ERROR_CODE_SAMPLE = 101;
    public static final int ERROR_CODE_SAMPLE_BY_USER = 108;
    public static final int ERROR_CODE_SUCCESS = 0;
    public static final int ERROR_PARAMS_LONG = 105;
    public String errMsg;
    public int errorCode;
    public long eventID;

    public EventResult(int i3, long j3, String str) {
        this.errorCode = i3;
        this.eventID = j3;
        this.errMsg = str;
    }

    public boolean isSuccess() {
        if (this.errorCode == 0) {
            return true;
        }
        return false;
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class a {
        public static EventResult a(int i3) {
            switch (i3) {
                case 100:
                    return new EventResult(i3, -1L, "not allowed in strategy (false).");
                case 101:
                    return new EventResult(i3, -1L, "sampled by svr rate (false).");
                case 102:
                    return new EventResult(i3, -1L, "event report not enable!");
                case 103:
                    return new EventResult(i3, -1L, "insert event to db error!");
                case 104:
                default:
                    return null;
                case 105:
                    return new EventResult(i3, -1L, "event params length > 45K!");
                case 106:
                    return new EventResult(i3, -1L, "event code isEmpty!");
                case 107:
                    return new EventResult(i3, -1L, "not init LogIDGenerator");
                case 108:
                    return new EventResult(i3, -1L, "sampled by user.");
            }
        }

        public static EventResult a(long j3) {
            return new EventResult(0, j3, null);
        }
    }
}
