package com.tencent.qzonehub.api.impl;

import android.view.View;
import com.tencent.qzonehub.api.IQzoneQcircleRedDotApi;

/* compiled from: P */
/* loaded from: classes34.dex */
public class QzoneQcircleRedDotApiImpl implements IQzoneQcircleRedDotApi {
    @Override // com.tencent.qzonehub.api.IQzoneQcircleRedDotApi
    public String getPrefixLogTag() {
        return "QZ_QFS_";
    }

    @Override // com.tencent.qzonehub.api.IQzoneQcircleRedDotApi
    public void saveAlbumEntranceRedDotVisible(boolean z16) {
        dh.a.f393805d.j(z16);
    }

    @Override // com.tencent.qzonehub.api.IQzoneQcircleRedDotApi
    public void showAlbumEntranceGuideBubble(View view, boolean z16) {
        dh.a.f393805d.n(view, z16);
    }

    @Override // com.tencent.qzonehub.api.IQzoneQcircleRedDotApi
    public boolean showAlbumEntranceRedDot() {
        return dh.a.f393805d.o();
    }
}
