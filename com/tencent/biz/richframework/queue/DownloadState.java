package com.tencent.biz.richframework.queue;

/* compiled from: P */
/* loaded from: classes5.dex */
public enum DownloadState {
    STATE_WAITING,
    STATE_START_RUN,
    STATE_RUNNING,
    STATE_PAUSE,
    STATE_SUCCESS,
    STATE_ERROR,
    STATE_CANCEL;

    public static DownloadState fromCode(int i3) {
        for (DownloadState downloadState : values()) {
            if (downloadState.ordinal() == i3) {
                return downloadState;
            }
        }
        return STATE_ERROR;
    }
}
