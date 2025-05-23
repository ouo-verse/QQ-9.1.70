package com.tencent.biz.qqcircle.immersive.feed.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0007R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/feed/event/QFSCommentPicSelectEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "path", "", "width", "", "height", "(Ljava/lang/String;II)V", "getHeight", "()I", "getPath", "()Ljava/lang/String;", "getWidth", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class QFSCommentPicSelectEvent extends SimpleBaseEvent {
    private final int height;

    @NotNull
    private final String path;
    private final int width;

    public QFSCommentPicSelectEvent(@NotNull String path, int i3, int i16) {
        Intrinsics.checkNotNullParameter(path, "path");
        this.path = path;
        this.width = i3;
        this.height = i16;
    }

    public final int getHeight() {
        return this.height;
    }

    @NotNull
    public final String getPath() {
        return this.path;
    }

    public final int getWidth() {
        return this.width;
    }
}
