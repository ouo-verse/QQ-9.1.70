package com.tencent.mobileqq.qqvideoedit.editor.background.uimanager;

import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.qqvideoedit.editor.background.border.EditViewContext;
import com.tencent.mobileqq.qqvideoedit.thirdparty.logger.Logger;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.MediaModel;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.model.EditViewTransform;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00192\u00020\u0001:\u0002\u0017'B\u0017\u0012\u0006\u0010\u001d\u001a\u00020\u001b\u0012\u0006\u0010\u001f\u001a\u00020\u0004\u00a2\u0006\u0004\b%\u0010&J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J(\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u001a\u0010\u0013\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0012\u001a\u00020\tH\u0002J\u000e\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0002H\u0016J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0002H\u0016J\u0018\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\tH\u0016J\u0010\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0002H\u0016J\u0018\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\tH\u0016R\u0014\u0010\u001d\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001eR\u0016\u0010\"\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010!R\u0018\u0010$\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010#\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/background/uimanager/EditViewStateObserver;", "Lcom/tencent/mobileqq/qqvideoedit/editor/background/border/d;", "", "id", "Lcom/tencent/mobileqq/qqvideoedit/editor/background/border/EditViewContext$EditScene;", "scene", "", "f", "j", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/render/model/a;", "transform", "i", "g", "editViewTransform", "Lcom/tencent/mobileqq/qqvideoedit/editor/background/uimanager/EditViewStateObserver$EditType;", "editType", h.F, MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_FIRST, MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_SECOND, "k", "l", "uuid", "d", "a", "c", "e", "b", "Lcom/tencent/mobileqq/qqvideoedit/editor/background/border/EditViewContext;", "Lcom/tencent/mobileqq/qqvideoedit/editor/background/border/EditViewContext;", "editViewContext", "Lcom/tencent/mobileqq/qqvideoedit/editor/background/border/EditViewContext$EditScene;", "currentEditViewScene", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/MediaModel;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/MediaModel;", "currentMediaModel", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/render/model/a;", "beginEditTransform", "<init>", "(Lcom/tencent/mobileqq/qqvideoedit/editor/background/border/EditViewContext;Lcom/tencent/mobileqq/qqvideoedit/editor/background/border/EditViewContext$EditScene;)V", "EditType", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class EditViewStateObserver implements com.tencent.mobileqq.qqvideoedit.editor.background.border.d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final EditViewContext editViewContext;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private EditViewContext.EditScene currentEditViewScene;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private MediaModel currentMediaModel;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private EditViewTransform beginEditTransform;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/background/uimanager/EditViewStateObserver$EditType;", "", "(Ljava/lang/String;I)V", "MOVE", "ROTATE", "SCALE", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes17.dex */
    public enum EditType {
        MOVE,
        ROTATE,
        SCALE
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes17.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f275272a;

        static {
            int[] iArr = new int[EditViewContext.EditScene.values().length];
            try {
                iArr[EditViewContext.EditScene.FRAME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EditViewContext.EditScene.MULTIMEDIA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f275272a = iArr;
        }
    }

    public EditViewStateObserver(@NotNull EditViewContext editViewContext, @NotNull EditViewContext.EditScene currentEditViewScene) {
        Intrinsics.checkNotNullParameter(editViewContext, "editViewContext");
        Intrinsics.checkNotNullParameter(currentEditViewScene, "currentEditViewScene");
        this.editViewContext = editViewContext;
        this.currentEditViewScene = currentEditViewScene;
        this.currentMediaModel = new MediaModel(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 524287, null);
    }

    private final void i(String id5, EditViewContext.EditScene scene, EditViewTransform transform) {
        int i3 = b.f275272a[scene.ordinal()];
    }

    private final EditType k(EditViewTransform first, EditViewTransform second) {
        float coerceAtLeast;
        float coerceAtLeast2;
        float coerceAtLeast3;
        float coerceAtLeast4;
        float coerceAtLeast5;
        float coerceAtLeast6;
        boolean z16;
        if (first == null) {
            return EditType.SCALE;
        }
        float abs = Math.abs(second.getAnchorX() - first.getAnchorX());
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(first.getAnchorX(), 1.0f);
        float f16 = abs / coerceAtLeast;
        float abs2 = Math.abs(second.getAnchorY() - first.getAnchorY());
        coerceAtLeast2 = RangesKt___RangesKt.coerceAtLeast(first.getAnchorY(), 1.0f);
        float f17 = (f16 + (abs2 / coerceAtLeast2)) / 2;
        float abs3 = Math.abs(Math.abs(second.getRotation()) - Math.abs(first.getRotation()));
        coerceAtLeast3 = RangesKt___RangesKt.coerceAtLeast(Math.abs(first.getRotation()), 360.0f);
        float f18 = abs3 / coerceAtLeast3;
        float abs4 = Math.abs(second.getScale() - first.getScale());
        coerceAtLeast4 = RangesKt___RangesKt.coerceAtLeast(first.getScale(), 1.0f);
        float f19 = abs4 / coerceAtLeast4;
        coerceAtLeast5 = RangesKt___RangesKt.coerceAtLeast(f17, f18);
        coerceAtLeast6 = RangesKt___RangesKt.coerceAtLeast(coerceAtLeast5, f19);
        boolean z17 = true;
        if (coerceAtLeast6 == f17) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return EditType.MOVE;
        }
        if (coerceAtLeast6 != f18) {
            z17 = false;
        }
        if (z17) {
            return EditType.ROTATE;
        }
        return EditType.SCALE;
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.background.border.d
    public void a(@NotNull String uuid) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        this.beginEditTransform = null;
        j(uuid, this.currentEditViewScene);
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.background.border.d
    public void b(@NotNull String uuid, @NotNull EditViewTransform editViewTransform) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(editViewTransform, "editViewTransform");
        EditType k3 = k(this.beginEditTransform, editViewTransform);
        this.beginEditTransform = this.editViewContext.getCurEditTransform();
        h(uuid, this.currentEditViewScene, editViewTransform, k3);
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.background.border.d
    public void c(@NotNull String uuid, @NotNull EditViewTransform editViewTransform) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(editViewTransform, "editViewTransform");
        Logger.f275870a.b("EditViewStateObserver", "onEditViewTransformChanged  id = " + uuid + "   transform= " + editViewTransform);
        i(uuid, this.currentEditViewScene, editViewTransform);
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.background.border.d
    public void d(@NotNull String uuid) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        this.beginEditTransform = this.editViewContext.getCurEditTransform();
        f(uuid, this.currentEditViewScene);
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.background.border.d
    public void e(@NotNull String uuid) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        g(uuid, this.currentEditViewScene);
    }

    public final void l(@NotNull EditViewContext.EditScene scene) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        this.currentEditViewScene = scene;
    }

    private final void f(String id5, EditViewContext.EditScene scene) {
    }

    private final void g(String id5, EditViewContext.EditScene scene) {
    }

    private final void j(String id5, EditViewContext.EditScene scene) {
    }

    private final void h(String id5, EditViewContext.EditScene scene, EditViewTransform editViewTransform, EditType editType) {
    }
}
