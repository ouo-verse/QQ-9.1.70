package com.tribe.async.async;

import android.support.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface JobContext<Progress> {

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface CancelListener {
        void onCancel();
    }

    @Nullable
    Object getValue(int i3);

    boolean isJobCancelled();

    void publishJobProgress(Progress progress);

    void setCancelListener(@Nullable CancelListener cancelListener);

    void setValue(int i3, Object obj);
}
