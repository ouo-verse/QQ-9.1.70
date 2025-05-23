package com.tencent.qqnt.aio.interceptor.sendmsg;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0018\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqnt/aio/interceptor/sendmsg/a;", "", "Lcom/tencent/qqnt/aio/interceptor/sendmsg/c;", "paramWrapper", "Lcom/tencent/qqnt/aio/interceptor/sendmsg/d;", "intercept", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "", "interceptResend", "success", "", "msgId", "", "reportAfterKernelSend", "isOriginBuddy", "reportBeforeKernelSend", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public interface a {
    @NotNull
    d intercept(@NotNull c paramWrapper);

    boolean interceptResend(@NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull com.tencent.aio.data.msglist.a msgItem);

    void reportAfterKernelSend(boolean success, long msgId);

    void reportBeforeKernelSend(boolean isOriginBuddy, long msgId);

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.qqnt.aio.interceptor.sendmsg.a$a, reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    public static final class C9483a {
        public static boolean a(@NotNull a aVar, @NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull com.tencent.aio.data.msglist.a msgItem) {
            Intrinsics.checkNotNullParameter(aioContext, "aioContext");
            Intrinsics.checkNotNullParameter(msgItem, "msgItem");
            return false;
        }

        public static void b(@NotNull a aVar, boolean z16, long j3) {
        }

        public static void c(@NotNull a aVar, boolean z16, long j3) {
        }
    }
}
