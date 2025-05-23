package com.tencent.mobileqq.qqvideoedit.editor.background.uimanager;

import android.view.View;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qqvideoedit.editor.background.border.EditContainerView;
import com.tencent.mobileqq.qqvideoedit.editor.background.border.EditViewContext;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.SizeF;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b&\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001cB\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u00a2\u0006\u0004\b%\u0010&J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tJH\u0010\u0015\u001a\u00020\u00062@\u0010\u0014\u001a<\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00120\fj\u0002`\u0013JB\u0010\u0019\u001a\u00020\u00062:\u0010\u0018\u001a6\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00160\fj\u0002`\u0017J\u001a\u0010\u001a\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\\\u0010$\u001a<\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00120\fj\u0002`\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001f\u0010!\"\u0004\b\"\u0010#\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/background/uimanager/BaseUIManager;", "", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/SizeF;", "renderSize", "Landroid/view/View;", "previewView", "", "i", "g", "Lcom/tencent/mobileqq/qqvideoedit/editor/background/border/EditContainerView;", "view", "f", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", HippyTKDListViewAdapter.X, "y", "", "Lcom/tencent/mobileqq/qqvideoedit/editor/background/uimanager/AccessTouchedModels;", "accessTouchedModels", "d", "", "Lcom/tencent/mobileqq/qqvideoedit/editor/background/border/AccessTouchedViewId;", "viewId", "e", "c", "Lcom/tencent/mobileqq/qqvideoedit/editor/background/border/EditViewContext;", "a", "Lcom/tencent/mobileqq/qqvideoedit/editor/background/border/EditViewContext;", "editViewContext", "b", "Lkotlin/jvm/functions/Function2;", "()Lkotlin/jvm/functions/Function2;", "setAccessModels", "(Lkotlin/jvm/functions/Function2;)V", "accessModels", "<init>", "(Lcom/tencent/mobileqq/qqvideoedit/editor/background/border/EditViewContext;)V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public abstract class BaseUIManager {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final EditViewContext editViewContext;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Function2<? super Float, ? super Float, ? extends List<? extends Object>> accessModels;

    public BaseUIManager(@NotNull EditViewContext editViewContext) {
        Intrinsics.checkNotNullParameter(editViewContext, "editViewContext");
        this.editViewContext = editViewContext;
        this.accessModels = new Function2<Float, Float, List<? extends Object>>() { // from class: com.tencent.mobileqq.qqvideoedit.editor.background.uimanager.BaseUIManager$accessModels$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ List<? extends Object> invoke(Float f16, Float f17) {
                return invoke(f16.floatValue(), f17.floatValue());
            }

            @NotNull
            public final List<Object> invoke(float f16, float f17) {
                List<Object> emptyList;
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                return emptyList;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(BaseUIManager this$0, SizeF renderSize, View previewView) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(renderSize, "$renderSize");
        Intrinsics.checkNotNullParameter(previewView, "$previewView");
        this$0.i(renderSize, previewView);
    }

    private final void i(SizeF renderSize, View previewView) {
        float width;
        float f16;
        SizeF c16 = c(renderSize, previewView);
        if (renderSize != null) {
            width = renderSize.width;
        } else {
            width = previewView.getWidth();
        }
        if (renderSize != null) {
            f16 = renderSize.height / 1280.0f;
        } else {
            f16 = 1.0f;
        }
        this.editViewContext.T(c16, c16.width / width, f16);
    }

    @NotNull
    public final Function2<Float, Float, List<Object>> b() {
        return this.accessModels;
    }

    @NotNull
    public SizeF c(@Nullable SizeF renderSize, @NotNull View previewView) {
        boolean z16;
        Intrinsics.checkNotNullParameter(previewView, "previewView");
        if (renderSize != null) {
            float f16 = renderSize.height;
            if (f16 == 0.0f) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                float f17 = renderSize.width / f16;
                if (f17 >= 1.0f) {
                    float width = previewView.getWidth();
                    return new SizeF(width, width / f17, null, 4, null);
                }
                float height = previewView.getHeight();
                return new SizeF(height * f17, height, null, 4, null);
            }
        }
        return new SizeF(previewView.getWidth(), previewView.getHeight(), null, 4, null);
    }

    public final void d(@NotNull Function2<? super Float, ? super Float, ? extends List<? extends Object>> accessTouchedModels) {
        Intrinsics.checkNotNullParameter(accessTouchedModels, "accessTouchedModels");
        this.accessModels = accessTouchedModels;
    }

    public final void e(@NotNull Function2<? super Float, ? super Float, String> viewId) {
        Intrinsics.checkNotNullParameter(viewId, "viewId");
        this.editViewContext.N(viewId);
    }

    public final void f(@NotNull EditContainerView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.editViewContext.R(view);
    }

    public void g(@NotNull final SizeF renderSize, @NotNull final View previewView) {
        Intrinsics.checkNotNullParameter(renderSize, "renderSize");
        Intrinsics.checkNotNullParameter(previewView, "previewView");
        ms.a.f("BaseUIManager", "updateRenderSize renderSize:[" + renderSize.width + ", " + renderSize.height + "] preview:" + previewView.getWidth() + "," + previewView.getHeight());
        if (previewView.getWidth() == 0) {
            previewView.post(new Runnable() { // from class: com.tencent.mobileqq.qqvideoedit.editor.background.uimanager.b
                @Override // java.lang.Runnable
                public final void run() {
                    BaseUIManager.h(BaseUIManager.this, renderSize, previewView);
                }
            });
        } else {
            i(renderSize, previewView);
        }
    }
}
