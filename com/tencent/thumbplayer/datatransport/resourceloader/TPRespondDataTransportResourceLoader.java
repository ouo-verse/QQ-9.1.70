package com.tencent.thumbplayer.datatransport.resourceloader;

import androidx.annotation.NonNull;
import com.tencent.thumbplayer.api.resourceloader.ITPResourceLoader;
import com.tencent.thumbplayer.api.resourceloader.TPResourceLoaderData;
import com.tencent.thumbplayer.api.resourceloader.TPResourceLoaderMediaContentInfo;
import com.tencent.thumbplayer.core.datatransport.resourceloader.ITPDataTransportResourceLoaderListener;
import com.tencent.thumbplayer.core.datatransport.resourceloader.TPDataTransportResourceLoaderData;
import com.tencent.thumbplayer.core.datatransport.resourceloader.TPDataTransportResourceLoaderMediaContentInfo;

/* loaded from: classes26.dex */
public class TPRespondDataTransportResourceLoader implements ITPDataTransportResourceLoaderListener {
    private final ITPResourceLoader mResourceLoader;

    public TPRespondDataTransportResourceLoader(@NonNull ITPResourceLoader iTPResourceLoader) {
        this.mResourceLoader = iTPResourceLoader;
    }

    private int transformRetCodeToDataTransportCode(int i3) {
        if (i3 == -1) {
            return -1;
        }
        if (i3 != 0) {
            return -2;
        }
        return 0;
    }

    @Override // com.tencent.thumbplayer.core.datatransport.resourceloader.ITPDataTransportResourceLoaderListener
    public void close(int i3, @NonNull String str) {
        this.mResourceLoader.close(i3, str);
    }

    @Override // com.tencent.thumbplayer.core.datatransport.resourceloader.ITPDataTransportResourceLoaderListener
    public boolean open(int i3, @NonNull String str) {
        return this.mResourceLoader.open(i3, str);
    }

    @Override // com.tencent.thumbplayer.core.datatransport.resourceloader.ITPDataTransportResourceLoaderListener
    public TPDataTransportResourceLoaderData readData(int i3, @NonNull String str, long j3) {
        TPResourceLoaderData readData = this.mResourceLoader.readData(i3, str, j3);
        if (readData == null) {
            return null;
        }
        return new TPDataTransportResourceLoaderData(readData.getData(), transformRetCodeToDataTransportCode(readData.getRetCode()));
    }

    @Override // com.tencent.thumbplayer.core.datatransport.resourceloader.ITPDataTransportResourceLoaderListener
    public TPDataTransportResourceLoaderMediaContentInfo readMediaContentInfo(int i3, @NonNull String str) {
        TPResourceLoaderMediaContentInfo readMediaContentInfo = this.mResourceLoader.readMediaContentInfo(i3, str);
        if (readMediaContentInfo == null) {
            return null;
        }
        return new TPDataTransportResourceLoaderMediaContentInfo(readMediaContentInfo.getContentType(), readMediaContentInfo.getContentLength(), transformRetCodeToDataTransportCode(readMediaContentInfo.getRetCode()));
    }

    @Override // com.tencent.thumbplayer.core.datatransport.resourceloader.ITPDataTransportResourceLoaderListener
    public int seekData(int i3, @NonNull String str, long j3) {
        return transformRetCodeToDataTransportCode(this.mResourceLoader.seekData(i3, str, j3));
    }
}
