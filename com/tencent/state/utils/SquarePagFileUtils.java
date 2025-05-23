package com.tencent.state.utils;

import com.tencent.state.square.IDownloadListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/tencent/state/utils/SquarePagFileUtils;", "", "()V", "TAG", "", "downloadPagFile", "", "url", "listener", "Lcom/tencent/state/square/IDownloadListener;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquarePagFileUtils {
    public static final SquarePagFileUtils INSTANCE = new SquarePagFileUtils();
    private static final String TAG = "PagFileUtils";

    SquarePagFileUtils() {
    }

    public final void downloadPagFile(String url, IDownloadListener listener) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(listener, "listener");
        DownloadUtils.INSTANCE.downloadFile(url, new SquarePagFileUtils$downloadPagFile$1(listener));
    }
}
