package com.tencent.mobileqq.mini.entry.newdesktop.part;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.mini.entry.newdesktop.mvi.MiniAppDeskTopUIState;
import com.tencent.mobileqq.mini.entry.newdesktop.mvi.MiniAppDeskTopViewModel;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0011H\u0016J\u0012\u0010\u0012\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\rH\u0016J\u0010\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016R\u001b\u0010\u0004\u001a\u00020\u00058DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/newdesktop/part/MiniAppDesktopAbstractPart;", "Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/mobileqq/mini/entry/newdesktop/part/MiniAppDesktopPartInterface;", "()V", "mMiniAppDesktopViewModel", "Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopViewModel;", "getMMiniAppDesktopViewModel", "()Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopViewModel;", "mMiniAppDesktopViewModel$delegate", "Lkotlin/Lazy;", "getLogTag", "", "handleUiState", "", "uiState", "Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopUIState;", "onAccountChanged", "Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopUIState$OnAccountChanged;", "onInitView", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/view/View;", "onPostThemeChanged", "Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopUIState$OnPostThemeChanged;", "setLiveDataObserver", "studyModeChange", "isStudyMode", "", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public abstract class MiniAppDesktopAbstractPart extends Part implements MiniAppDesktopPartInterface {

    /* renamed from: mMiniAppDesktopViewModel$delegate, reason: from kotlin metadata */
    private final Lazy mMiniAppDesktopViewModel;

    public MiniAppDesktopAbstractPart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<MiniAppDeskTopViewModel>() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopAbstractPart$mMiniAppDesktopViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MiniAppDeskTopViewModel invoke() {
                ViewModel viewModel = new ViewModelProvider(MiniAppDesktopAbstractPart.this.getPartHost()).get(MiniAppDeskTopViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(partHo\u2026TopViewModel::class.java)");
                MiniAppDeskTopViewModel miniAppDeskTopViewModel = (MiniAppDeskTopViewModel) viewModel;
                miniAppDeskTopViewModel.setContextHashCode(MiniAppDesktopAbstractPart.this.getPartHost().getHostActivity().hashCode());
                return miniAppDeskTopViewModel;
            }
        });
        this.mMiniAppDesktopViewModel = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onInitView$lambda$0(MiniAppDesktopAbstractPart this$0, MiniAppDeskTopUIState it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (it instanceof MiniAppDeskTopUIState.StudyModeChange) {
            this$0.studyModeChange(((MiniAppDeskTopUIState.StudyModeChange) it).getIsStudyMode());
            return;
        }
        if (it instanceof MiniAppDeskTopUIState.OnAccountChanged) {
            this$0.onAccountChanged(MiniAppDeskTopUIState.OnAccountChanged.INSTANCE);
        } else if (it instanceof MiniAppDeskTopUIState.OnPostThemeChanged) {
            this$0.onPostThemeChanged(MiniAppDeskTopUIState.OnPostThemeChanged.INSTANCE);
        } else {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            this$0.handleUiState(it);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "MiniAppDesktopAbstractPart";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final MiniAppDeskTopViewModel getMMiniAppDesktopViewModel() {
        return (MiniAppDeskTopViewModel) this.mMiniAppDesktopViewModel.getValue();
    }

    @Override // com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopPartInterface
    public void handleUiState(MiniAppDeskTopUIState uiState) {
        Intrinsics.checkNotNullParameter(uiState, "uiState");
    }

    @Override // com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopPartInterface
    public void onAccountChanged(MiniAppDeskTopUIState.OnAccountChanged uiState) {
        Intrinsics.checkNotNullParameter(uiState, "uiState");
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        getMMiniAppDesktopViewModel().obtainUiState().observe(getPartHost().getLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MiniAppDesktopAbstractPart.onInitView$lambda$0(MiniAppDesktopAbstractPart.this, (MiniAppDeskTopUIState) obj);
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

    @Override // com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopPartInterface
    public void onPostThemeChanged(MiniAppDeskTopUIState.OnPostThemeChanged uiState) {
        Intrinsics.checkNotNullParameter(uiState, "uiState");
    }

    @Override // com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopPartInterface
    public void setLiveDataObserver() {
    }

    @Override // com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopPartInterface
    public void studyModeChange(boolean isStudyMode) {
    }
}
