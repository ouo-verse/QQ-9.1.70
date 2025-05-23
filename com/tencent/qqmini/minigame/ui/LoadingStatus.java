package com.tencent.qqmini.minigame.ui;

import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes23.dex */
public class LoadingStatus {
    private String message;
    private float progress;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class Builder {
        private LoadingStatus mStatus = new LoadingStatus();

        public LoadingStatus build() {
            return this.mStatus;
        }

        public Builder setMessage(String str) {
            this.mStatus.message = str;
            return this;
        }

        public Builder setProgress(float f16) {
            this.mStatus.progress = f16;
            return this;
        }
    }

    public String getMessage() {
        return this.message;
    }

    public String getProcessInPercentage() {
        return ((int) (this.progress * 100.0f)) + "%";
    }

    public float getProgress() {
        return this.progress;
    }

    public boolean isInProgress() {
        float f16 = this.progress;
        if (f16 > 0.0f && f16 < 1.0f) {
            return true;
        }
        return false;
    }

    @NonNull
    public String toString() {
        return "LoadingStatus {progress=" + this.progress + "} ";
    }

    LoadingStatus() {
        this.message = "";
        this.progress = 0.0f;
    }
}
