package com.tencent.gamecenter.wadl.sdk.common.b.j;

import com.tencent.gamecenter.wadl.sdk.downloader.IThreadPool;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes6.dex */
public class a implements IThreadPool {
    @Override // com.tencent.gamecenter.wadl.sdk.downloader.IThreadPool
    public ThreadPoolExecutor getThreadPool(String str, int i3, int i16, int i17, int i18) {
        return new e(i3, i16, i18, TimeUnit.SECONDS, new c(i17), new b(str));
    }
}
