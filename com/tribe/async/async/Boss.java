package com.tribe.async.async;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface Boss {
    <Result> void cancelJob(Future<Result> future, boolean z16);

    @NonNull
    Executor getExecutor(int i3);

    @NonNull
    Executor[] getExecutors();

    @NonNull
    JobController getJobController();

    @NonNull
    Executor getLightWeightExecutor();

    @NonNull
    <Params, Progress, Result> Future<Result> postJob(Job<Params, Progress, Result> job);

    @NonNull
    <Params, Progress, Result> Future<Result> postJob(Job<Params, Progress, Result> job, @Nullable FutureListener<Progress, Result> futureListener, @Nullable Params params);

    @NonNull
    <Params, Progress, Result> Future<Result> postJob(Job<Params, Progress, Result> job, @Nullable Params params);

    void postLightWeightJob(Runnable runnable, int i3);

    @NonNull
    <Params, Progress, Result> Worker<Progress, Result> prepareWorker(Job<Params, Progress, Result> job, int i3, @Nullable FutureListener<Progress, Result> futureListener, @Nullable Params params);

    @NonNull
    <Params, Progress, Result> Future<Result> scheduleJob(Job<Params, Progress, Result> job);

    @NonNull
    <Params, Progress, Result> Future<Result> scheduleJob(Job<Params, Progress, Result> job, @Nullable FutureListener<Progress, Result> futureListener, @Nullable Params params);

    @NonNull
    <Params, Progress, Result> Future<Result> scheduleJob(Job<Params, Progress, Result> job, @Nullable Params params);

    @NonNull
    <Params, Progress, Result> Future<Result> scheduleJobDelayed(Job<Params, Progress, Result> job, int i3);

    @NonNull
    <Params, Progress, Result> Future<Result> scheduleJobDelayed(Job<Params, Progress, Result> job, int i3, @Nullable FutureListener<Progress, Result> futureListener, @Nullable Params params);

    @NonNull
    <Params, Progress, Result> Future<Result> scheduleJobDelayed(Job<Params, Progress, Result> job, int i3, @Nullable Params params);

    void shutdown();
}
