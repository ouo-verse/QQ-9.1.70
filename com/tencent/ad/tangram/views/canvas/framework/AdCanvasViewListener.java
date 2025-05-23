package com.tencent.ad.tangram.views.canvas.framework;

import android.support.annotation.Nullable;
import com.tencent.ad.tangram.annotation.AdKeep;
import com.tencent.ad.tangram.views.canvas.AdCanvasData;
import com.tencent.ad.tangram.views.canvas.components.AdCanvasComponentData;
import com.tencent.ad.tangram.views.canvas.components.appbutton.AdAppDownloadManager;

/* compiled from: P */
@AdKeep
/* loaded from: classes3.dex */
public interface AdCanvasViewListener {
    @Nullable
    AdCanvasPageView getContentView();

    @Nullable
    AdCanvasData getData();

    @Nullable
    AdAppDownloadManager getDownloadManager();

    void hotAreaClick(String str, String str2, String str3);

    void onLoaded(AdCanvasComponentData adCanvasComponentData, long j3, boolean z16);

    void setPageViewTopMargin(int i3);

    void showProgressBar(String str, boolean z16);
}
