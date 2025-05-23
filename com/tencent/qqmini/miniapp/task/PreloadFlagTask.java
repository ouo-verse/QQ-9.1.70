package com.tencent.qqmini.miniapp.task;

import android.content.Context;
import com.tencent.qqmini.sdk.annotation.ClassTag;
import com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader;
import com.tencent.qqmini.sdk.task.AsyncTask;

@ClassTag(tag = "PreloadFlagTask")
/* loaded from: classes23.dex */
public class PreloadFlagTask extends AsyncTask {
    public PreloadFlagTask(Context context, BaseRuntimeLoader baseRuntimeLoader) {
        super(context, baseRuntimeLoader);
    }

    @Override // com.tencent.qqmini.sdk.task.AsyncTask
    public void executeAsync() {
        onTaskSucceed();
    }
}
