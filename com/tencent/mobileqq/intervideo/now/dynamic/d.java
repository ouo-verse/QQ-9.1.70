package com.tencent.mobileqq.intervideo.now.dynamic;

import android.content.Context;
import android.os.Bundle;
import com.tencent.intervideo.nowproxy.customized_interface.IShadow;
import com.tencent.mobileqq.intervideo.g;
import com.tencent.shadow.dynamic.host.EnterCallback;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

/* compiled from: P */
/* loaded from: classes33.dex */
public class d implements IShadow {
    @Override // com.tencent.intervideo.nowproxy.customized_interface.IShadow
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public g getPluginManager(Context context, String str, String str2) throws InterruptedException, TimeoutException, ExecutionException {
        return com.tencent.mobileqq.intervideo.impl.a.d(context, str, str2);
    }

    @Override // com.tencent.intervideo.nowproxy.customized_interface.IShadow
    public boolean hasPluginManager() {
        return false;
    }

    @Override // com.tencent.intervideo.nowproxy.customized_interface.IShadow
    public void setILoggerFactory() {
        com.tencent.mobileqq.intervideo.impl.a.f();
    }

    @Override // com.tencent.intervideo.nowproxy.customized_interface.IShadow
    public void enter(Context context, long j3, String str, String str2, Bundle bundle, EnterCallback enterCallback) throws InterruptedException, TimeoutException, ExecutionException {
    }
}
