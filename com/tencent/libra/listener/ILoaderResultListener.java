package com.tencent.libra.listener;

import com.tencent.libra.request.Option;

/* compiled from: P */
/* loaded from: classes7.dex */
public interface ILoaderResultListener {
    void onDecodeResult(Option option, int i3);

    void onDownloadResult(Option option, int i3);

    void onLoadResult(Option option, int i3);
}
