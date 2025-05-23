package com.tencent.ams.mosaic.load;

import android.content.Context;
import com.tencent.ams.mosaic.load.QuickJSSoLoader;
import com.tencent.ams.mosaic.load.d;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface b {

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface a {
        void onComplete(d dVar);

        void onDownloadFailure(d dVar, d.c cVar, int i3);

        void onDownloadStart(d dVar, d.c cVar);

        void onDownloadSuccess(d dVar, d.c cVar);

        void onFailure(d dVar, int i3);

        void onStart(d dVar);
    }

    boolean isSupportQuickJS();

    void loadSo(Context context, boolean z16, QuickJSSoLoader.a aVar);

    boolean setSoConfigs(Context context, List<d> list);
}
