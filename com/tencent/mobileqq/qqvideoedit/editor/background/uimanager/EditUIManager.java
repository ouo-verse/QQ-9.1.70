package com.tencent.mobileqq.qqvideoedit.editor.background.uimanager;

import android.view.View;
import com.tencent.mobileqq.qqvideoedit.editor.background.border.EditViewContext;
import com.tencent.mobileqq.qqvideoedit.thirdparty.logger.Logger;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.MediaModel;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.SizeF;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00072\u00020\u0001:\u0001\u001cB\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016R\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/background/uimanager/EditUIManager;", "Lcom/tencent/mobileqq/qqvideoedit/editor/background/uimanager/BaseUIManager;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/SizeF;", "renderSize", "Landroid/view/View;", "previewView", "", "g", "Lcom/tencent/mobileqq/qqvideoedit/editor/background/uimanager/EditUIScene;", "scene", "j", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/MediaModel;", "d", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/MediaModel;", "currentMediaModel", "Lcom/tencent/mobileqq/qqvideoedit/editor/background/uimanager/e;", "e", "Lcom/tencent/mobileqq/qqvideoedit/editor/background/uimanager/e;", "previewEditViewManager", "", "Lcom/tencent/mobileqq/qqvideoedit/editor/background/uimanager/f;", "f", "Ljava/util/List;", "renderLayers", "Lcom/tencent/mobileqq/qqvideoedit/editor/background/border/EditViewContext;", "editViewContext", "<init>", "(Lcom/tencent/mobileqq/qqvideoedit/editor/background/border/EditViewContext;)V", "a", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class EditUIManager extends BaseUIManager {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private MediaModel currentMediaModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private e previewEditViewManager;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<f> renderLayers;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditUIManager(@NotNull final EditViewContext editViewContext) {
        super(editViewContext);
        List<f> mutableListOf;
        Intrinsics.checkNotNullParameter(editViewContext, "editViewContext");
        this.currentMediaModel = new MediaModel(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 524287, null);
        this.previewEditViewManager = new e(editViewContext);
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new d(editViewContext));
        this.renderLayers = mutableListOf;
        e(new Function2<Float, Float, String>() { // from class: com.tencent.mobileqq.qqvideoedit.editor.background.uimanager.EditUIManager.1

            /* compiled from: P */
            @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
            /* renamed from: com.tencent.mobileqq.qqvideoedit.editor.background.uimanager.EditUIManager$1$a */
            /* loaded from: classes17.dex */
            public /* synthetic */ class a {

                /* renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f275266a;

                static {
                    int[] iArr = new int[EditViewContext.EditScene.values().length];
                    try {
                        iArr[EditViewContext.EditScene.MULTIMEDIA.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    f275266a = iArr;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ String invoke(Float f16, Float f17) {
                return invoke(f16.floatValue(), f17.floatValue());
            }

            @NotNull
            public final String invoke(float f16, float f17) {
                if (EditUIManager.this.b().invoke(Float.valueOf(f16), Float.valueOf(f17)).isEmpty()) {
                    return a.f275266a[editViewContext.getEditScene().ordinal()] == 1 ? editViewContext.getCurUuid() : "invalidViewId";
                }
                return "invalidViewId";
            }
        });
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.background.uimanager.BaseUIManager
    public void g(@NotNull SizeF renderSize, @NotNull View previewView) {
        Intrinsics.checkNotNullParameter(renderSize, "renderSize");
        Intrinsics.checkNotNullParameter(previewView, "previewView");
        super.g(renderSize, previewView);
    }

    public void j(@Nullable EditUIScene scene) {
        if (scene == null) {
            Logger.f275870a.c("EditUIManager", "EditUIScene == NULL!!! check scene you should define it in map ");
            return;
        }
        this.previewEditViewManager.a(scene);
        Iterator<T> it = this.renderLayers.iterator();
        while (it.hasNext()) {
            ((f) it.next()).a(scene);
        }
    }
}
