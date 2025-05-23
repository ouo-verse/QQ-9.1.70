package com.tencent.mobileqq.mini.entry.newdesktop.part;

import com.tencent.mobileqq.mini.entry.newdesktop.mvi.MiniAppDeskTopUIState;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u0003H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/newdesktop/part/MiniAppDesktopPartInterface;", "", "handleUiState", "", "uiState", "Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopUIState;", "onAccountChanged", "Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopUIState$OnAccountChanged;", "onPostThemeChanged", "Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopUIState$OnPostThemeChanged;", "setLiveDataObserver", "studyModeChange", "isStudyMode", "", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public interface MiniAppDesktopPartInterface {
    void handleUiState(MiniAppDeskTopUIState uiState);

    void onAccountChanged(MiniAppDeskTopUIState.OnAccountChanged uiState);

    void onPostThemeChanged(MiniAppDeskTopUIState.OnPostThemeChanged uiState);

    void setLiveDataObserver();

    void studyModeChange(boolean isStudyMode);
}
