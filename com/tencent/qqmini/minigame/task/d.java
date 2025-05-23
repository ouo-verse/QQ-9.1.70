package com.tencent.qqmini.minigame.task;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.triton.TritonPlatform;
import com.tencent.qqmini.minigame.GameRuntime;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.task.TaskExecutionStatics;
import java.util.Collections;

/* compiled from: P */
/* loaded from: classes23.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private long f346740a = 0;

    /* renamed from: b, reason: collision with root package name */
    private boolean f346741b = false;

    public TaskExecutionStatics a() {
        TaskExecutionStatics.Status status;
        if (this.f346741b) {
            status = TaskExecutionStatics.Status.SUCCESS;
        } else {
            status = TaskExecutionStatics.Status.FAIL;
        }
        long j3 = this.f346740a;
        return new TaskExecutionStatics("InitGameRuntime", j3, j3, status, "", Collections.emptyList());
    }

    public void b(@NonNull GameRuntime gameRuntime, @NonNull TritonPlatform tritonPlatform, @NonNull MiniAppInfo miniAppInfo, b bVar) {
        this.f346740a = 0L;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            gameRuntime.init(tritonPlatform);
            gameRuntime.loadMiniApp(miniAppInfo);
            this.f346741b = true;
            this.f346740a = System.currentTimeMillis() - currentTimeMillis;
            bVar.onInitGameRuntimeSuccess();
        } catch (Throwable th5) {
            QMLog.e("InitGameRuntimeLoader", th5.getMessage(), th5);
            bVar.onInitGameRuntimeFailed(-1, "init game runtime throw t:" + th5.getMessage());
        }
    }
}
