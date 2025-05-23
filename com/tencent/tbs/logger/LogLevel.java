package com.tencent.tbs.logger;

import com.tencent.raft.codegenmeta.utils.RLog;

/* compiled from: P */
/* loaded from: classes26.dex */
public enum LogLevel {
    VERBOSE(2),
    DEBUG(3),
    INFO(4),
    WARN(5),
    ERROR(6),
    ALL(Integer.MIN_VALUE),
    NONE(Integer.MAX_VALUE);

    private int mLevelValue;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f374479a;

        static {
            int[] iArr = new int[LogLevel.values().length];
            f374479a = iArr;
            try {
                iArr[LogLevel.VERBOSE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f374479a[LogLevel.DEBUG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f374479a[LogLevel.INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f374479a[LogLevel.WARN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f374479a[LogLevel.ERROR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    LogLevel(int i3) {
        this.mLevelValue = i3;
    }

    public static String getName(LogLevel logLevel) {
        int i3 = a.f374479a[logLevel.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 != 5) {
                            int value = logLevel.getValue();
                            LogLevel logLevel2 = VERBOSE;
                            if (value < logLevel2.getValue()) {
                                return "VERBOSE-" + (logLevel2.getValue() - logLevel.getValue());
                            }
                            return "ERROR+" + (logLevel.getValue() - ERROR.getValue());
                        }
                        return RLog.ERROR;
                    }
                    return "WARN";
                }
                return "INFO";
            }
            return "DEBUG";
        }
        return "VERBOSE";
    }

    public static String getShortName(LogLevel logLevel) {
        int i3 = a.f374479a[logLevel.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 != 5) {
                            int value = logLevel.getValue();
                            LogLevel logLevel2 = VERBOSE;
                            if (value < logLevel2.getValue()) {
                                return "V-" + (logLevel2.getValue() - logLevel.getValue());
                            }
                            return "E+" + (logLevel.getValue() - ERROR.getValue());
                        }
                        return "E";
                    }
                    return "W";
                }
                return "I";
            }
            return "D";
        }
        return "V";
    }

    public int getValue() {
        return this.mLevelValue;
    }

    public static LogLevel valueOf(int i3) {
        if (i3 == 2) {
            return VERBOSE;
        }
        if (i3 == 3) {
            return DEBUG;
        }
        if (i3 == 4) {
            return INFO;
        }
        if (i3 == 5) {
            return WARN;
        }
        if (i3 != 6) {
            return NONE;
        }
        return ERROR;
    }
}
