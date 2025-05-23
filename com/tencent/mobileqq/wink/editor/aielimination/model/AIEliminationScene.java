package com.tencent.mobileqq.wink.editor.aielimination.model;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/aielimination/model/AIEliminationScene;", "", "scene", "", "busId", "", "(Ljava/lang/String;IILjava/lang/String;)V", "getBusId", "()Ljava/lang/String;", "getScene", "()I", "WINK_EDITOR", "QZONE_HOME_PAGE", "AIO_EDITOR", "OTHER", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public enum AIEliminationScene {
    WINK_EDITOR(1, "qzone_auto_removal"),
    QZONE_HOME_PAGE(2, "qzone_auto_removal"),
    AIO_EDITOR(3, "aio_auto_removal"),
    OTHER(0, "qzone_auto_removal");


    @NotNull
    private final String busId;
    private final int scene;

    AIEliminationScene(int i3, String str) {
        this.scene = i3;
        this.busId = str;
    }

    @NotNull
    public final String getBusId() {
        return this.busId;
    }

    public final int getScene() {
        return this.scene;
    }
}
