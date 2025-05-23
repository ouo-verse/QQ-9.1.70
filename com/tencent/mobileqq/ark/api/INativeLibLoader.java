package com.tencent.mobileqq.ark.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes11.dex */
public interface INativeLibLoader extends QRouteApi {
    void extractArkLibrary();

    void extractPNGLibrary();

    void extractWordSegmentLibrary();

    boolean isArkLibraryLoaded();

    void loadArkLibrary();

    boolean loadPNGLibrary(Context context);
}
