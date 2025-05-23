package com.tencent.qzonehub.api.zipanimate.impl;

import android.content.Context;
import com.tencent.qzonehub.api.zipanimate.IZipDrawableLoader;
import cooperation.qzone.zipanimate.ZipDrawableLoader;
import cooperation.qzone.zipanimate.ZipDrawableLoaderInterface;

/* compiled from: P */
/* loaded from: classes34.dex */
public class ZipDrawableLoaderImpl implements IZipDrawableLoader {
    @Override // com.tencent.qzonehub.api.zipanimate.IZipDrawableLoader
    public ZipDrawableLoaderInterface getZipDrawableLoader(Context context) {
        return new ZipDrawableLoader(context);
    }
}
