package com.tencent.mobileqq.tvideo.account.tenvideo.refresh.impl;

import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \b2\u00020\u0001:\u0001\u000bB\u001f\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u0010\u001a\u00020\u000e\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\t\u001a\u00020\u0007R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0010\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/tvideo/account/tenvideo/refresh/impl/c;", "", "Lbu2/a;", "account", "", "d", "b", "", "e", "f", "Lfu2/a;", "a", "Lfu2/a;", "accountGetter", "Lfu2/c;", "Lfu2/c;", "refreshHandler", "Lfu2/d;", "c", "Lfu2/d;", "scheduleExecutor", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "currTask", "<init>", "(Lfu2/a;Lfu2/c;Lfu2/d;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final fu2.a accountGetter;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final fu2.c refreshHandler;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final fu2.d scheduleExecutor;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Runnable currTask;

    public c(@NotNull fu2.a accountGetter, @NotNull fu2.c refreshHandler, @NotNull fu2.d scheduleExecutor) {
        Intrinsics.checkNotNullParameter(accountGetter, "accountGetter");
        Intrinsics.checkNotNullParameter(refreshHandler, "refreshHandler");
        Intrinsics.checkNotNullParameter(scheduleExecutor, "scheduleExecutor");
        this.accountGetter = accountGetter;
        this.refreshHandler = refreshHandler;
        this.scheduleExecutor = scheduleExecutor;
        this.currTask = new Runnable() { // from class: com.tencent.mobileqq.tvideo.account.tenvideo.refresh.impl.b
            @Override // java.lang.Runnable
            public final void run() {
                c.c(c.this);
            }
        };
    }

    private final long b(bu2.a account) {
        long coerceAtMost;
        long accessTokenExpireTime = account.getAccessTokenExpireTime();
        long videoExpireTime = account.getVideoExpireTime();
        if (accessTokenExpireTime != 0) {
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(accessTokenExpireTime, videoExpireTime);
            return coerceAtMost;
        }
        return videoExpireTime;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(c this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        bu2.a a16 = this$0.accountGetter.a();
        if (a16 != null) {
            this$0.refreshHandler.a(a16, 2);
        }
    }

    private final long d(bu2.a account) {
        long videoCreateTime = account.getVideoCreateTime() + b(account);
        if (videoCreateTime <= 0) {
            videoCreateTime = 0;
        }
        long j3 = videoCreateTime - 18000;
        if (j3 > 0) {
            return j3;
        }
        return videoCreateTime;
    }

    public final synchronized void e() {
        bu2.a a16 = this.accountGetter.a();
        if (a16 != null) {
            long d16 = d(a16);
            long currentTimeMillis = System.currentTimeMillis();
            if (d16 - currentTimeMillis < 0) {
                d16 = 5000 + currentTimeMillis;
                QLog.i("VideoLoginRefreshScheduler", 1, "startRefreshSchedule: refresh time\u5c0f\u4e8e\u5f53\u524d\u65f6\u95f4\uff0c\u4f7f\u7528\u515c\u5e95\u5ef6\u8fdf");
            }
            QLog.i("VideoLoginRefreshScheduler", 1, "startRefreshSchedule: \u5f00\u59cb\u4e0b\u6b21\u7eed\u671f\u5b9a\u65f6\uff0c\u4e0b\u6b21\u7eed\u671f\u7684\u65f6\u95f4\uff1adelay " + (d16 - currentTimeMillis));
            this.scheduleExecutor.b(this.currTask);
            this.scheduleExecutor.a(this.currTask, d16);
        }
    }

    public final synchronized void f() {
        QLog.i("VideoLoginRefreshScheduler", 1, "stopRefreshSchedule");
        this.scheduleExecutor.b(this.currTask);
    }
}
