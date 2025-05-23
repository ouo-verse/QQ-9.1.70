package com.tencent.mobileqq.mini.entry.expDesktop.part;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.mini.entry.expDesktop.mvi.MiniAppExpDesktopUIState;
import com.tencent.mobileqq.mini.entry.expDesktop.mvi.MiniAppExpDesktopViewModel;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\rH\u0016J\u0012\u0010\u0011\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0014\u001a\u00020\rH\u0016J\b\u0010\u0015\u001a\u00020\rH\u0016J\u0010\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016R\u001b\u0010\u0004\u001a\u00020\u00058DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/expDesktop/part/MiniAppExpDesktopAbstractPart;", "Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/mobileqq/mini/entry/expDesktop/part/MiniAppExpDesktopPartInterface;", "()V", "mMiniAppDesktopViewModel", "Lcom/tencent/mobileqq/mini/entry/expDesktop/mvi/MiniAppExpDesktopViewModel;", "getMMiniAppDesktopViewModel", "()Lcom/tencent/mobileqq/mini/entry/expDesktop/mvi/MiniAppExpDesktopViewModel;", "mMiniAppDesktopViewModel$delegate", "Lkotlin/Lazy;", "getLogTag", "", "handleUiState", "", "uiState", "Lcom/tencent/mobileqq/mini/entry/expDesktop/mvi/MiniAppExpDesktopUIState;", "onAccountChanged", "onInitView", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/view/View;", "onPostThemeChanged", "setLiveDataObserver", "studyModeChange", "isStudyMode", "", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public abstract class MiniAppExpDesktopAbstractPart extends Part implements MiniAppExpDesktopPartInterface {

    /* renamed from: mMiniAppDesktopViewModel$delegate, reason: from kotlin metadata */
    private final Lazy mMiniAppDesktopViewModel;

    public MiniAppExpDesktopAbstractPart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<MiniAppExpDesktopViewModel>() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopAbstractPart$mMiniAppDesktopViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MiniAppExpDesktopViewModel invoke() {
                ViewModel viewModel = new ViewModelProvider(MiniAppExpDesktopAbstractPart.this.getPartHost()).get(MiniAppExpDesktopViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(partHo\u2026topViewModel::class.java)");
                MiniAppExpDesktopViewModel miniAppExpDesktopViewModel = (MiniAppExpDesktopViewModel) viewModel;
                miniAppExpDesktopViewModel.setContextHashCode(MiniAppExpDesktopAbstractPart.this.getPartHost().getHostActivity().hashCode());
                return miniAppExpDesktopViewModel;
            }
        });
        this.mMiniAppDesktopViewModel = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onInitView$lambda$0(MiniAppExpDesktopAbstractPart this$0, MiniAppExpDesktopUIState it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (it instanceof MiniAppExpDesktopUIState.StudyModeChange) {
            this$0.studyModeChange(((MiniAppExpDesktopUIState.StudyModeChange) it).getIsStudyMode());
            return;
        }
        if (it instanceof MiniAppExpDesktopUIState.OnAccountChanged) {
            this$0.onAccountChanged();
        } else if (it instanceof MiniAppExpDesktopUIState.OnPostThemeChanged) {
            this$0.onPostThemeChanged();
        } else {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            this$0.handleUiState(it);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "MiniAppExpDesktopAbstractPart";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final MiniAppExpDesktopViewModel getMMiniAppDesktopViewModel() {
        return (MiniAppExpDesktopViewModel) this.mMiniAppDesktopViewModel.getValue();
    }

    @Override // com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopPartInterface
    public void handleUiState(MiniAppExpDesktopUIState uiState) {
        Intrinsics.checkNotNullParameter(uiState, "uiState");
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        getMMiniAppDesktopViewModel().obtainUiState().observe(getPartHost().getLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.part.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MiniAppExpDesktopAbstractPart.onInitView$lambda$0(MiniAppExpDesktopAbstractPart.this, (MiniAppExpDesktopUIState) obj);
            }
        });
        setLiveDataObserver();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public /* bridge */ /* synthetic */ void onPartCreate(Activity activity, Bundle bundle) {
        com.tencent.biz.richframework.part.b.a(this, activity, bundle);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public /* bridge */ /* synthetic */ void onPartPause(Activity activity) {
        com.tencent.biz.richframework.part.b.c(this, activity);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public /* bridge */ /* synthetic */ void onPartResume(Activity activity) {
        com.tencent.biz.richframework.part.b.d(this, activity);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public /* bridge */ /* synthetic */ void onPartSaveInstanceState(Activity activity, Bundle bundle) {
        com.tencent.biz.richframework.part.b.e(this, activity, bundle);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public /* bridge */ /* synthetic */ void onPartStart(Activity activity) {
        com.tencent.biz.richframework.part.b.f(this, activity);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public /* bridge */ /* synthetic */ void onPartStop(Activity activity) {
        com.tencent.biz.richframework.part.b.g(this, activity);
    }

    @Override // com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopPartInterface
    public void onAccountChanged() {
    }

    @Override // com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopPartInterface
    public void onPostThemeChanged() {
    }

    @Override // com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopPartInterface
    public void setLiveDataObserver() {
    }

    @Override // com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopPartInterface
    public void studyModeChange(boolean isStudyMode) {
    }
}
