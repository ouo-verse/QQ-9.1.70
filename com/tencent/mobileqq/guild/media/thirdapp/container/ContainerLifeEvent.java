package com.tencent.mobileqq.guild.media.thirdapp.container;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0018\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/container/ContainerLifeEvent;", "", "", "status", "I", "<init>", "(Ljava/lang/String;II)V", "Companion", "a", "UNKNOWN", "ON_CREATE", "ON_BEFORE_LOAD_URL", "ON_PAGE_STARTED", "ON_PAGE_FINISH", "ON_PAUSE", "ON_RESUME", "ON_DESTROY", "ON_REMOTE_WEB_DESTROY", "ON_REMOTE_WEB_SWITCH_SURFACE", "ON_SURFACE_CREATED", "ON_SURFACE_CHANGED", "ON_SURFACE_DESTROY", "ON_MINIAPP_DISMISS", "ON_REMOTE_WEB_REBUILD", "ON_APP_FOREGROUND", "ON_APP_BACKGROUND", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public enum ContainerLifeEvent {
    UNKNOWN(-1),
    ON_CREATE(0),
    ON_BEFORE_LOAD_URL(1),
    ON_PAGE_STARTED(2),
    ON_PAGE_FINISH(3),
    ON_PAUSE(4),
    ON_RESUME(5),
    ON_DESTROY(6),
    ON_REMOTE_WEB_DESTROY(7),
    ON_REMOTE_WEB_SWITCH_SURFACE(8),
    ON_SURFACE_CREATED(9),
    ON_SURFACE_CHANGED(10),
    ON_SURFACE_DESTROY(11),
    ON_MINIAPP_DISMISS(12),
    ON_REMOTE_WEB_REBUILD(13),
    ON_APP_FOREGROUND(14),
    ON_APP_BACKGROUND(15);

    private final int status;

    ContainerLifeEvent(int i3) {
        this.status = i3;
    }

    /* renamed from: status, reason: from getter */
    public final int getStatus() {
        return this.status;
    }
}
