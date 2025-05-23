package com.tencent.mobileqq.mini.entry.expDesktop.part;

import com.tencent.mobileqq.mini.entry.expDesktop.mvi.MiniAppExpDesktopUIState;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/expDesktop/part/MiniAppExpDesktopPartInterface;", "", "handleUiState", "", "uiState", "Lcom/tencent/mobileqq/mini/entry/expDesktop/mvi/MiniAppExpDesktopUIState;", "onAccountChanged", "onPostThemeChanged", "setLiveDataObserver", "studyModeChange", "isStudyMode", "", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public interface MiniAppExpDesktopPartInterface {
    void handleUiState(MiniAppExpDesktopUIState uiState);

    void onAccountChanged();

    void onPostThemeChanged();

    void setLiveDataObserver();

    void studyModeChange(boolean isStudyMode);
}
