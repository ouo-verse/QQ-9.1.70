package com.tencent.qzonehub.api;

import android.view.View;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface IQzoneQcircleRedDotApi extends QRouteApi {
    String getPrefixLogTag();

    void saveAlbumEntranceRedDotVisible(boolean z16);

    void showAlbumEntranceGuideBubble(View view, boolean z16);

    boolean showAlbumEntranceRedDot();
}
