package com.tencent.qqmini.sdk.launcher.core;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes23.dex */
public interface IScreenRecord {
    public static final int RECORD_STATUS_COMPLETED = 5;
    public static final int RECORD_STATUS_HIDDEN = 1;
    public static final int RECORD_STATUS_SHOWN = 2;
    public static final int RECORD_STATUS_STOPPED = 4;
    public static final int RECORD_STATUS_WORKING = 3;
    public static final int REMOVE_PREVIEW = 1001;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes23.dex */
    public @interface OpFrom {
        public static final int BUBBLE_VIEW = 0;
        public static final int GAME_DESTROY = 3;
        public static final int OVERTIME_VIEW = 2;
        public static final int SETTING_VIEW = 1;
    }

    void attachRecordView();

    void detachRecordView(int i3);

    void prepareAndStartRecord(int i3);

    void removePreview();

    void stopRecord(int i3);
}
