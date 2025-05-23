package com.huawei.hms.framework.common;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: P */
/* loaded from: classes2.dex */
public class AssetsUtil {
    private static final int GET_SP_TIMEOUT = 5;
    private static final String TAG = "AssetsUtil";
    private static final String THREAD_NAME = "AssetsUtil_Operate";
    private static final ExecutorService EXECUTOR_SERVICE = ExecutorsUtils.newSingleThreadExecutor(THREAD_NAME);

    public static String[] list(final Context context, final String str) {
        if (context == null) {
            Logger.w("AssetsUtil", "context is null");
            return new String[0];
        }
        FutureTask futureTask = new FutureTask(new Callable<String[]>() { // from class: com.huawei.hms.framework.common.AssetsUtil.1
            @Override // java.util.concurrent.Callable
            public String[] call() throws Exception {
                return context.getAssets().list(str);
            }
        });
        EXECUTOR_SERVICE.execute(futureTask);
        try {
            return (String[]) futureTask.get(5L, TimeUnit.SECONDS);
        } catch (InterruptedException e16) {
            Logger.w("AssetsUtil", "get local config files from sp task interrupted", e16);
            return new String[0];
        } catch (Exception unused) {
            Logger.w("AssetsUtil", "get local config files from sp task occur unknown Exception");
            return new String[0];
        } catch (ExecutionException e17) {
            Logger.w("AssetsUtil", "get local config files from sp task failed", e17);
            return new String[0];
        } catch (TimeoutException unused2) {
            Logger.w("AssetsUtil", "get local config files from sp task timed out");
            return new String[0];
        } finally {
            futureTask.cancel(true);
        }
    }

    public static InputStream open(Context context, String str) throws IOException {
        if (context == null) {
            Logger.w("AssetsUtil", "context is null");
            return null;
        }
        try {
            return context.getAssets().open(str);
        } catch (RuntimeException e16) {
            Logger.e("AssetsUtil", "AssetManager has been destroyed", e16);
            return null;
        }
    }
}
