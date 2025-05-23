package com.tencent.qqlive.tvkplayer.api;

/* loaded from: classes23.dex */
public interface ITVKPreloadMgr {
    public static final int INVALID_REQUESTID = -1;

    /* loaded from: classes23.dex */
    public interface IPreloadListener {

        /* loaded from: classes23.dex */
        public static class DownloadProgressInfo {
            private long mCurrentDownloadSizeByte;
            private int mDownloadSpeedKBs;
            private String mExtraInfo;
            private int mPlayableDurationMs;
            private long mTotalFileSizeByte;

            public long getCurrentDownloadSizeByte() {
                return this.mCurrentDownloadSizeByte;
            }

            public int getDownloadSpeedKBs() {
                return this.mDownloadSpeedKBs;
            }

            public String getExtraInfo() {
                return this.mExtraInfo;
            }

            public int getPlayableDurationMs() {
                return this.mPlayableDurationMs;
            }

            public long getTotalFileSizeByte() {
                return this.mTotalFileSizeByte;
            }

            public void setCurrentDownloadSizeByte(long j3) {
                this.mCurrentDownloadSizeByte = j3;
            }

            public void setDownloadSpeedKBs(int i3) {
                this.mDownloadSpeedKBs = i3;
            }

            public void setExtraInfo(String str) {
                this.mExtraInfo = str;
            }

            public void setPlayableDurationMs(int i3) {
                this.mPlayableDurationMs = i3;
            }

            public void setTotalFileSizeByte(long j3) {
                this.mTotalFileSizeByte = j3;
            }
        }

        void onPreloadDownloadProgressUpdate(int i3, DownloadProgressInfo downloadProgressInfo);

        void onPreloadError(int i3);

        void onPreloadSuccess(int i3);
    }

    /* loaded from: classes23.dex */
    public static class PreloadParam {
        private long mPreloadDurationMs;
        private long mPreloadSizeByte;
        private long mSkipEndPositionMs;
        private long mStartPositionMs;
        private long mPreloadHttpStartTimeMs = -1;
        private boolean mUseSurfaceView = true;

        public long getPreloadDurationMs() {
            return this.mPreloadDurationMs;
        }

        public long getPreloadHttpStartTimeMs() {
            return this.mPreloadHttpStartTimeMs;
        }

        public long getPreloadSize() {
            return this.mPreloadSizeByte;
        }

        public long getSkipEndPositionMs() {
            return this.mSkipEndPositionMs;
        }

        public long getStartPositionMs() {
            return this.mStartPositionMs;
        }

        public boolean isUseSurfaceView() {
            return this.mUseSurfaceView;
        }

        public void setPreloadDurationMs(long j3) {
            this.mPreloadDurationMs = j3;
        }

        public void setPreloadHttpStartTimeMs(long j3) {
            this.mPreloadHttpStartTimeMs = j3;
        }

        public void setPreloadSize(long j3) {
            this.mPreloadSizeByte = j3;
        }

        public void setSkipEndPositionMs(long j3) {
            this.mSkipEndPositionMs = j3;
        }

        public void setStartPositionMs(long j3) {
            this.mStartPositionMs = j3;
        }

        public void setUseSurfaceView(boolean z16) {
            this.mUseSurfaceView = z16;
        }

        public String toString() {
            return "startPositionMs=" + this.mStartPositionMs + ", skipEndPositionMs=" + this.mSkipEndPositionMs + ", preloadSizeByte=" + this.mPreloadSizeByte + ", preloadDurationMs=" + this.mPreloadDurationMs + ", preloadHttpStartTimeMs=" + this.mPreloadHttpStartTimeMs + ", isUseSurfaceView=" + this.mUseSurfaceView;
        }
    }

    int preload(TVKUserInfo tVKUserInfo, TVKPlayerVideoInfo tVKPlayerVideoInfo, String str, PreloadParam preloadParam, IPreloadListener iPreloadListener);

    void stopPreload(int i3);
}
