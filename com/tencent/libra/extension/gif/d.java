package com.tencent.libra.extension.gif;

import com.tencent.biz.richframework.delegate.util.RFWConfigExtKt;
import com.tencent.thread.monitor.plugin.proxy.BaseScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes7.dex */
public final class d extends BaseScheduledThreadPoolExecutor {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private static final d f118747a = new d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d a() {
        return b.f118747a;
    }

    d() {
        super(RFWConfigExtKt.isInnerVerOrRemoteCfgEnabled("RFW_GIF_RENDER_USE_MULTI_CORE_SIZE") ? 4 : 1, new ThreadPoolExecutor.DiscardPolicy());
    }
}
