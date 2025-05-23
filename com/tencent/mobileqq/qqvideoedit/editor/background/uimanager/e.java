package com.tencent.mobileqq.qqvideoedit.editor.background.uimanager;

import com.tencent.mobileqq.qqvideoedit.editor.background.border.EditViewContext;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.MediaModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0005B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\n\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/background/uimanager/e;", "", "Lcom/tencent/mobileqq/qqvideoedit/editor/background/uimanager/EditUIScene;", "scene", "", "a", "Lcom/tencent/mobileqq/qqvideoedit/editor/background/border/EditViewContext;", "Lcom/tencent/mobileqq/qqvideoedit/editor/background/border/EditViewContext;", "getEditViewContext", "()Lcom/tencent/mobileqq/qqvideoedit/editor/background/border/EditViewContext;", "editViewContext", "b", "Lcom/tencent/mobileqq/qqvideoedit/editor/background/uimanager/EditUIScene;", "currentScene", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/MediaModel;", "c", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/MediaModel;", "mediaModel", "Lcom/tencent/mobileqq/qqvideoedit/editor/background/uimanager/EditViewStateObserver;", "d", "Lcom/tencent/mobileqq/qqvideoedit/editor/background/uimanager/EditViewStateObserver;", "editViewStateObserver", "<init>", "(Lcom/tencent/mobileqq/qqvideoedit/editor/background/border/EditViewContext;)V", "e", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final EditViewContext editViewContext;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private EditUIScene currentScene;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private MediaModel mediaModel;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final EditViewStateObserver editViewStateObserver;

    public e(@NotNull EditViewContext editViewContext) {
        Intrinsics.checkNotNullParameter(editViewContext, "editViewContext");
        this.editViewContext = editViewContext;
        this.currentScene = EditUIScene.DEFAULT;
        this.mediaModel = new MediaModel(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 524287, null);
        this.editViewStateObserver = new EditViewStateObserver(editViewContext, c.a(this.currentScene));
    }

    public final void a(@NotNull EditUIScene scene) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        this.currentScene = scene;
        EditViewContext.EditScene a16 = c.a(scene);
        this.editViewContext.S(a16);
        this.editViewStateObserver.l(a16);
    }
}
