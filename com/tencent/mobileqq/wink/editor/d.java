package com.tencent.mobileqq.wink.editor;

import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import androidx.annotation.IdRes;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.wink.editor.WinkEditorViewModel;
import com.tencent.mobileqq.wink.editor.draft.WinkEditUIData;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0012\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\bH\u0010IJ\b\u0010\u0003\u001a\u00020\u0002H'J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\u0006H\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0014J\u0012\u0010\u0011\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0006H\u0014J\u0012\u0010\u0013\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0014J\b\u0010\u0014\u001a\u00020\u0006H\u0016J\b\u0010\u0015\u001a\u00020\u0006H\u0014J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0014J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0004J\n\u0010\u001a\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u001c\u001a\u00020\u001bH\u0016J\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dJ\u0012\u0010 \u001a\u00020\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010\u001dH\u0016R\u001c\u0010$\u001a\n !*\u0004\u0018\u00010\u001b0\u001b8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R$\u0010+\u001a\u0004\u0018\u00010\u00048\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\"\u00107\u001a\u0002008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\"\u0010?\u001a\u0002088\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u0016\u0010A\u001a\u0002008\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b@\u00102R$\u0010\u001f\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010G\u00a8\u0006J"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/d;", "Lcom/tencent/biz/richframework/part/Part;", "", "B9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "z9", "M9", "Lcom/tencent/mobileqq/wink/editor/WinkEditorViewModel$EditMode;", "editMode", "J9", "K9", "initAfterInflation", "Landroid/os/Bundle;", "args", "Q9", "I9", "L9", "x9", "onDismiss", "Lcom/tencent/mobileqq/wink/editor/dr;", "H9", "Lcom/tencent/mobileqq/wink/editor/WinkEditorFragment;", "F9", "getRootView", "", "getLogTag", "Lcom/tencent/mobileqq/wink/editor/draft/WinkEditUIData;", "C9", "uiData", "N9", "kotlin.jvm.PlatformType", "d", "Ljava/lang/String;", "TAG", "e", "Landroid/view/View;", "A9", "()Landroid/view/View;", "setPartRootView", "(Landroid/view/View;)V", "partRootView", "Landroid/view/ViewStub;", "f", "Landroid/view/ViewStub;", "partRootViewStub", "", tl.h.F, "Z", "E9", "()Z", "setViewStubIsInflated", "(Z)V", "viewStubIsInflated", "Lcom/tencent/mobileqq/wink/editor/WinkEditorViewModel;", "i", "Lcom/tencent/mobileqq/wink/editor/WinkEditorViewModel;", "G9", "()Lcom/tencent/mobileqq/wink/editor/WinkEditorViewModel;", "P9", "(Lcom/tencent/mobileqq/wink/editor/WinkEditorViewModel;)V", "winkEditorViewModel", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, NodeProps.VISIBLE, BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/wink/editor/draft/WinkEditUIData;", "D9", "()Lcom/tencent/mobileqq/wink/editor/draft/WinkEditUIData;", "O9", "(Lcom/tencent/mobileqq/wink/editor/draft/WinkEditUIData;)V", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public abstract class d extends Part {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private WinkEditUIData uiData;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public final String TAG = getClass().getSimpleName();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View partRootView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewStub partRootViewStub;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean viewStubIsInflated;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public WinkEditorViewModel winkEditorViewModel;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public boolean visible;

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: A9, reason: from getter */
    public final View getPartRootView() {
        return this.partRootView;
    }

    @IdRes
    public abstract int B9();

    @Nullable
    public final WinkEditUIData C9() {
        WinkEditUIData winkEditUIData = this.uiData;
        if (winkEditUIData != null) {
            return winkEditUIData.updateData();
        }
        return null;
    }

    @Nullable
    /* renamed from: D9, reason: from getter */
    public final WinkEditUIData getUiData() {
        return this.uiData;
    }

    /* renamed from: E9, reason: from getter */
    public final boolean getViewStubIsInflated() {
        return this.viewStubIsInflated;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final WinkEditorFragment F9() {
        if (getHostFragment() instanceof WinkEditorFragment) {
            Fragment hostFragment = getHostFragment();
            Intrinsics.checkNotNull(hostFragment, "null cannot be cast to non-null type com.tencent.mobileqq.wink.editor.WinkEditorFragment");
            return (WinkEditorFragment) hostFragment;
        }
        return null;
    }

    @NotNull
    public final WinkEditorViewModel G9() {
        WinkEditorViewModel winkEditorViewModel = this.winkEditorViewModel;
        if (winkEditorViewModel != null) {
            return winkEditorViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("winkEditorViewModel");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public dr H9() {
        WinkEditorFragment F9 = F9();
        if (F9 != null) {
            return F9.getCurTavCut();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void I9() {
        ViewStub viewStub;
        if (!this.viewStubIsInflated && (viewStub = this.partRootViewStub) != null) {
            try {
                this.viewStubIsInflated = true;
                if (viewStub != null && viewStub.getParent() != null) {
                    this.partRootView = viewStub.inflate();
                }
                View view = this.partRootView;
                if (view != null) {
                    view.setVisibility(4);
                    initAfterInflation(view);
                }
                J9(G9().getEditMode());
            } catch (Throwable th5) {
                w53.b.c(this.TAG, "inflate throwable:" + th5.getMessage());
            }
        }
    }

    public void J9(@NotNull WinkEditorViewModel.EditMode editMode) {
        Intrinsics.checkNotNullParameter(editMode, "editMode");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void L9(@Nullable Bundle args) {
        if (this.visible) {
            return;
        }
        this.visible = true;
        View view = this.partRootView;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    public final void O9(@Nullable WinkEditUIData winkEditUIData) {
        this.uiData = winkEditUIData;
    }

    public final void P9(@NotNull WinkEditorViewModel winkEditorViewModel) {
        Intrinsics.checkNotNullParameter(winkEditorViewModel, "<set-?>");
        this.winkEditorViewModel = winkEditorViewModel;
    }

    public void Q9(@Nullable Bundle args) {
        if (this.visible || this.partRootView == null) {
            return;
        }
        I9();
        L9(args);
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    public String getLogTag() {
        String TAG = this.TAG;
        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        return TAG;
    }

    @Override // com.tencent.biz.richframework.part.Part
    @Nullable
    /* renamed from: getRootView */
    public View getPartRootView() {
        return this.partRootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.Part
    public void initAfterInflation(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.initAfterInflation(rootView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDismiss() {
        if (!this.visible) {
            return;
        }
        this.visible = false;
        View view = this.partRootView;
        if (view != null) {
            view.setVisibility(4);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(B9());
        this.partRootView = findViewById;
        if (findViewById instanceof ViewStub) {
            Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.view.ViewStub");
            this.partRootViewStub = (ViewStub) findViewById;
        } else {
            this.visible = true;
            this.viewStubIsInflated = true;
        }
        ViewModel viewModel = getViewModel(WinkEditorViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(WinkEditorViewModel::class.java)");
        P9((WinkEditorViewModel) viewModel);
        z9(rootView);
    }

    public void x9() {
        if (!this.visible || getPartRootView() == null) {
            return;
        }
        onDismiss();
    }

    public void z9(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
    }

    public void K9() {
    }

    public void M9() {
    }

    public void N9(@Nullable WinkEditUIData uiData) {
    }
}
