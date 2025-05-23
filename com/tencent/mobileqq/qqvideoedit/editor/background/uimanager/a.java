package com.tencent.mobileqq.qqvideoedit.editor.background.uimanager;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0010\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016R(\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u00078\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0014\u001a\u00020\u00038\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/background/uimanager/a;", "T", "Lcom/tencent/mobileqq/qqvideoedit/editor/background/uimanager/f;", "Lcom/tencent/mobileqq/qqvideoedit/editor/background/uimanager/EditUIScene;", "scene", "", "a", "", "Ljava/util/List;", "getCurrentList", "()Ljava/util/List;", "setCurrentList", "(Ljava/util/List;)V", "currentList", "b", "Lcom/tencent/mobileqq/qqvideoedit/editor/background/uimanager/EditUIScene;", "getCurrentScene", "()Lcom/tencent/mobileqq/qqvideoedit/editor/background/uimanager/EditUIScene;", "setCurrentScene", "(Lcom/tencent/mobileqq/qqvideoedit/editor/background/uimanager/EditUIScene;)V", "currentScene", "<init>", "()V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public abstract class a<T> implements f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<? extends T> currentList;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private EditUIScene currentScene;

    public a() {
        List<? extends T> emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.currentList = emptyList;
        this.currentScene = EditUIScene.DEFAULT;
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.background.uimanager.f
    public void a(@NotNull EditUIScene scene) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        this.currentScene = scene;
    }
}
