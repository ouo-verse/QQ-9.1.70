package com.tencent.mobileqq.guild.media.core.notify;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\n\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u0017\u0010\u0012\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0003\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/notify/ba;", "Lcom/tencent/mobileqq/guild/media/core/notify/x;", "", "d", "J", "c", "()J", "webViewFinishTime", "e", "a", "domReadyTime", "f", "b", "pageLoadedTime", "", tl.h.F, "Z", "()Z", "isMiniApp", "<init>", "(JJJZ)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class ba implements x {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final long webViewFinishTime;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final long domReadyTime;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final long pageLoadedTime;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final boolean isMiniApp;

    public ba(long j3, long j16, long j17, boolean z16) {
        this.webViewFinishTime = j3;
        this.domReadyTime = j16;
        this.pageLoadedTime = j17;
        this.isMiniApp = z16;
    }

    /* renamed from: a, reason: from getter */
    public final long getDomReadyTime() {
        return this.domReadyTime;
    }

    /* renamed from: b, reason: from getter */
    public final long getPageLoadedTime() {
        return this.pageLoadedTime;
    }

    /* renamed from: c, reason: from getter */
    public final long getWebViewFinishTime() {
        return this.webViewFinishTime;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getIsMiniApp() {
        return this.isMiniApp;
    }
}
