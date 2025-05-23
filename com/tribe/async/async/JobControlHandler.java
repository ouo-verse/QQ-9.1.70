package com.tribe.async.async;

import android.support.annotation.NonNull;
import com.tribe.async.async.JobController;
import java.util.concurrent.Executor;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface JobControlHandler {
    boolean accept(@NonNull Job job);

    void handleCancel(@NonNull JobController.CancelCommand cancelCommand);

    void handleDone(@NonNull Worker worker);

    void handleExecute(@NonNull Executor[] executorArr, @NonNull Worker worker);
}
