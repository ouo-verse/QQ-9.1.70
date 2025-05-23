package com.tencent.intervideo.nowproxy.customized_interface;

import android.content.Context;
import android.os.Bundle;
import com.tencent.shadow.dynamic.host.EnterCallback;
import com.tencent.shadow.dynamic.host.PluginManager;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

/* compiled from: P */
/* loaded from: classes7.dex */
public interface IShadow {
    void enter(Context context, long j3, String str, String str2, Bundle bundle, EnterCallback enterCallback) throws InterruptedException, TimeoutException, ExecutionException;

    PluginManager getPluginManager(Context context, String str, String str2) throws InterruptedException, TimeoutException, ExecutionException;

    boolean hasPluginManager();

    void setILoggerFactory();
}
