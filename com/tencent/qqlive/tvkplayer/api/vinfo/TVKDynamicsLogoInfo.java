package com.tencent.qqlive.tvkplayer.api.vinfo;

import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKDynamicsLogoInfo implements Serializable {
    public static final int PLAY_POSITION_CHANGED_SHOW_LOGO = 1;
    public static final int SYSTEM_TIME_CHANGED_SHOW_LOGO = 2;
    private int mDurationMs;
    private int mRepeat;
    private int mScale;
    private int mStartTimeMs;
    private int mRunMode = 0;
    private final List<Scenes> mSceneList = new ArrayList();

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes23.dex */
    public @interface RunMode {
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class Scenes implements Serializable {
        private int mEnd;
        private int mInTimeMs;
        private List<TVKLogoInfo> mLogoInfoList;
        private int mOutTimeMs;
        private int mStart;

        public int getEnd() {
            return this.mEnd;
        }

        public int getInTimeMs() {
            return this.mInTimeMs;
        }

        public List<TVKLogoInfo> getLogoInfoList() {
            return this.mLogoInfoList;
        }

        public int getOutTimeMs() {
            return this.mOutTimeMs;
        }

        public int getStart() {
            return this.mStart;
        }

        public void setEnd(int i3) {
            this.mEnd = i3;
        }

        public void setInTimeMs(int i3) {
            this.mInTimeMs = i3;
        }

        public void setLogoInfoList(List<TVKLogoInfo> list) {
            this.mLogoInfoList = list;
        }

        public void setOutTimeMs(int i3) {
            this.mOutTimeMs = i3;
        }

        public void setStart(int i3) {
            this.mStart = i3;
        }
    }

    public void addScenes(Scenes scenes) {
        this.mSceneList.add(scenes);
    }

    public int getDurationMs() {
        return this.mDurationMs;
    }

    public int getRepeat() {
        return this.mRepeat;
    }

    public int getRunMode() {
        return this.mRunMode;
    }

    public int getScale() {
        return this.mScale;
    }

    public List<Scenes> getSceneList() {
        return this.mSceneList;
    }

    public int getStartTimeMs() {
        return this.mStartTimeMs;
    }

    public void setDurationMs(int i3) {
        this.mDurationMs = i3;
    }

    public void setRepeat(int i3) {
        this.mRepeat = i3;
    }

    public void setRunMode(int i3) {
        this.mRunMode = i3;
    }

    public void setScale(int i3) {
        this.mScale = i3;
    }

    public void setStartTimeMs(int i3) {
        this.mStartTimeMs = i3;
    }
}
