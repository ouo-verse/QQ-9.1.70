package com.tencent.qqmini.sdk.launcher.core.proxy;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;

/* loaded from: classes23.dex */
public abstract class MapProxy {

    /* loaded from: classes23.dex */
    public interface MapSnapshotCallback {
        void onSnapshotReady(Bitmap bitmap);
    }

    public void captureImage(IMiniAppContext iMiniAppContext, View view, ViewGroup viewGroup, MapSnapshotCallback mapSnapshotCallback) {
    }
}
