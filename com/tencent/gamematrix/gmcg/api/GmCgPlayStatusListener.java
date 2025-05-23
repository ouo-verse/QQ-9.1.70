package com.tencent.gamematrix.gmcg.api;

import androidx.annotation.MainThread;
import androidx.annotation.Nullable;

/* loaded from: classes6.dex */
public interface GmCgPlayStatusListener {
    void onGmCgNetworkCarrierMismatch(String[] strArr, String str, @Nullable String str2);

    @MainThread
    void onGmCgPlayError(GmCgError gmCgError);

    @MainThread
    void onGmCgPlayEventGalleryOpen();

    @MainThread
    void onGmCgPlayEventGpsSwitched(boolean z16);

    @MainThread
    void onGmCgPlayEventVoiceSwitched(boolean z16);

    @MainThread
    void onGmCgPlayLoadingProgressUpdate(GmCgPlayStatus gmCgPlayStatus, int i3, boolean z16);

    @MainThread
    void onGmCgPlaySoftKeyboardShow(boolean z16);

    @MainThread
    void onGmCgPlayStatusUpdate(GmCgPlayStatus gmCgPlayStatus, Object obj);

    @MainThread
    void onGmCgPlaySuperResolutionTypeChanged(int i3);

    @MainThread
    void onGmCgPlayWarning(GmCgError gmCgError);
}
