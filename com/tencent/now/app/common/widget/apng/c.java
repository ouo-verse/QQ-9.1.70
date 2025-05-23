package com.tencent.now.app.common.widget.apng;

import android.annotation.TargetApi;
import android.os.AsyncTask;

/* compiled from: P */
/* loaded from: classes22.dex */
public class c {
    @TargetApi(11)
    public static <Params, Progress, Result> void a(AsyncTask<Params, Progress, Result> asyncTask, Params... paramsArr) {
        asyncTask.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, paramsArr);
    }
}
