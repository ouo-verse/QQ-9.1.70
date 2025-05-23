package com.tencent.qqlive.tvkplayer.qqliveasset.strategy;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes23.dex */
public interface ITVKSwitchDispatcher {
    public static final int RET_CODE_DISCARD_TASK = 4;
    public static final int RET_CODE_DUPLICATE_TASK = 1;
    public static final int RET_CODE_NON_EXISTENT_TASK = 2;
    public static final int RET_CODE_NOT_LATEST_TASK = 3;
    public static final int RET_CODE_OK = 0;
    public static final int STATE_CGING = 1;
    public static final int STATE_COMPLETE = 3;
    public static final int STATE_PLAYER_SWITCHING = 2;
    public static final int SWITCH_DEFINITION_TYPE_SELF_ADAPTION = 1;
    public static final int SWITCH_DEFINITION_TYPE_USER = 0;
    public static final long TASK_ID_NON_EXIST = -1;
    public static final int TYPE_SWITCH_AUDIO_TRACK = 1;
    public static final int TYPE_SWITCH_DEFINITION = 0;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class Ret {
        public SwitchInfo info;
        public int retCode;
        public long taskId;
        public int type;
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes23.dex */
    public @interface RetCode {
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes23.dex */
    public @interface State {
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes23.dex */
    public @interface SwitchDefinitionType {
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class SwitchInfo {
        private String mAudioTrack;
        private String mDefinition;
        private int mDefnSwitchType;
        private String mSubtitle;
        private String mTaskName;

        /* compiled from: P */
        /* loaded from: classes23.dex */
        public static class Builder {
            private String mAudioTrack;
            private String mDefinition;
            private int mDefnSwitchType;
            private String mSubtitle;
            private String mTaskName;

            public Builder audioTrack(String str) {
                this.mAudioTrack = str;
                if (TextUtils.isEmpty(this.mTaskName)) {
                    this.mTaskName = str;
                }
                return this;
            }

            public SwitchInfo build() {
                return new SwitchInfo(this);
            }

            public Builder definition(String str) {
                this.mDefinition = str;
                if (TextUtils.isEmpty(this.mTaskName)) {
                    this.mTaskName = str;
                }
                return this;
            }

            public Builder defnSwitchType(int i3) {
                this.mDefnSwitchType = i3;
                return this;
            }

            public Builder subtitle(String str) {
                this.mSubtitle = str;
                if (TextUtils.isEmpty(this.mTaskName)) {
                    this.mTaskName = str;
                }
                return this;
            }

            public Builder taskName(String str) {
                this.mTaskName = str;
                return this;
            }
        }

        public String getAudioTrack() {
            return this.mAudioTrack;
        }

        public String getDefinition() {
            return this.mDefinition;
        }

        public int getDefnSwitchType() {
            return this.mDefnSwitchType;
        }

        public String getSubtitle() {
            return this.mSubtitle;
        }

        public String getTaskName() {
            return this.mTaskName;
        }

        SwitchInfo(Builder builder) {
            this.mDefnSwitchType = builder.mDefnSwitchType;
            this.mDefinition = builder.mDefinition;
            this.mAudioTrack = builder.mAudioTrack;
            this.mSubtitle = builder.mSubtitle;
            this.mTaskName = builder.mTaskName;
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class Task {
        SwitchInfo info;
        int state;
        long taskId;
        long timeMs;
        int type;
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes23.dex */
    public @interface Type {
    }

    Ret addTask(@NonNull SwitchInfo switchInfo);

    void clear();

    Ret driveTaskWhenCGIFailed(long j3);

    Ret driveTaskWhenCGISuccess(long j3);

    Ret driveTaskWhenPlayerFailed(long j3);

    Ret driveTaskWhenPlayerSuccess(long j3);

    Ret queryTaskByTaskId(long j3);
}
