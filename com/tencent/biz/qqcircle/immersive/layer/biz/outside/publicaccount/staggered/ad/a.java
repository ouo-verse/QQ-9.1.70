package com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.ad;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b'\u0010(R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0014\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\f\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\"\u0010\u001b\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0003\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001e\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0017\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\"\u0010$\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010 \u001a\u0004\b\u0016\u0010!\"\u0004\b\"\u0010#R\"\u0010&\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010 \u001a\u0004\b\u000b\u0010!\"\u0004\b%\u0010#\u00a8\u0006)"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/ad/a;", "", "", "a", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "l", "(Ljava/lang/String;)V", "videoReportUrl", "", "b", "J", "e", "()J", "k", "(J)V", "startTime", "c", "i", "endTime", "", "d", "I", "()I", "g", "(I)V", "actionType", "getPauseType", "setPauseType", "pauseType", "", "Z", "()Z", "j", "(Z)V", "pause", tl.h.F, "complete", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private long startTime;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private long endTime;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean pause;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean complete;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String videoReportUrl = "";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int actionType = 11;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int pauseType = 3;

    /* renamed from: a, reason: from getter */
    public final int getActionType() {
        return this.actionType;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getComplete() {
        return this.complete;
    }

    /* renamed from: c, reason: from getter */
    public final long getEndTime() {
        return this.endTime;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getPause() {
        return this.pause;
    }

    /* renamed from: e, reason: from getter */
    public final long getStartTime() {
        return this.startTime;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getVideoReportUrl() {
        return this.videoReportUrl;
    }

    public final void g(int i3) {
        this.actionType = i3;
    }

    public final void h(boolean z16) {
        this.complete = z16;
    }

    public final void i(long j3) {
        this.endTime = j3;
    }

    public final void j(boolean z16) {
        this.pause = z16;
    }

    public final void k(long j3) {
        this.startTime = j3;
    }

    public final void l(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.videoReportUrl = str;
    }
}
