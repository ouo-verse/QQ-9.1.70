package com.tencent.tencentmap.mapsdk.maps.model;

/* compiled from: P */
/* loaded from: classes26.dex */
public class LoggerConfig {
    private boolean mToFile = false;
    private boolean mToConsole = false;
    private int mLevel = 6;
    private String[] mTags = new String[0];
    private LogCallback mLogCallback = null;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class Builder {
        private final LoggerConfig mLoggerConfig;

        public Builder(LoggerConfig loggerConfig) {
            if (loggerConfig != null) {
                this.mLoggerConfig = loggerConfig;
            } else {
                this.mLoggerConfig = new LoggerConfig();
            }
        }

        public LoggerConfig build() {
            return this.mLoggerConfig;
        }

        public Builder level(int i3) {
            this.mLoggerConfig.mLevel = i3;
            return this;
        }

        public Builder logCallback(LogCallback logCallback) {
            this.mLoggerConfig.mLogCallback = logCallback;
            return this;
        }

        public Builder tags(String... strArr) {
            this.mLoggerConfig.mTags = strArr;
            return this;
        }

        public Builder toConsole(boolean z16) {
            this.mLoggerConfig.mToConsole = z16;
            return this;
        }

        public Builder toFile(boolean z16) {
            this.mLoggerConfig.mToFile = z16;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface LogCallback {
        void onLog(String str);
    }

    public static Builder newBuilder() {
        return newBuilder(null);
    }

    public int getLevel() {
        return this.mLevel;
    }

    public LogCallback getLogCallback() {
        return this.mLogCallback;
    }

    public String[] getTags() {
        return this.mTags;
    }

    public boolean isToConsole() {
        return this.mToConsole;
    }

    public boolean isToFile() {
        return this.mToFile;
    }

    public static Builder newBuilder(LoggerConfig loggerConfig) {
        return new Builder(loggerConfig);
    }
}
