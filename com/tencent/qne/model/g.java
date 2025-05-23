package com.tencent.qne.model;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u00a8\u0006\u0003"}, d2 = {"", "Lcom/tencent/qne/model/PreloadStatusCode;", "a", "qne_debug"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes22.dex */
public final class g {
    @NotNull
    public static final PreloadStatusCode a(int i3) {
        PreloadStatusCode preloadStatusCode = PreloadStatusCode.DownloadSuccess;
        if (i3 != preloadStatusCode.getValue()) {
            PreloadStatusCode preloadStatusCode2 = PreloadStatusCode.NotNeedDownload;
            if (i3 != preloadStatusCode2.getValue()) {
                PreloadStatusCode preloadStatusCode3 = PreloadStatusCode.DownloadOrCheckFail;
                if (i3 != preloadStatusCode3.getValue()) {
                    PreloadStatusCode preloadStatusCode4 = PreloadStatusCode.CreateDirFail;
                    if (i3 != preloadStatusCode4.getValue()) {
                        PreloadStatusCode preloadStatusCode5 = PreloadStatusCode.UnzipFail;
                        if (i3 != preloadStatusCode5.getValue()) {
                            PreloadStatusCode preloadStatusCode6 = PreloadStatusCode.CheckNetworkFail;
                            if (i3 != preloadStatusCode6.getValue()) {
                                return PreloadStatusCode.OtherFail;
                            }
                            return preloadStatusCode6;
                        }
                        return preloadStatusCode5;
                    }
                    return preloadStatusCode4;
                }
                return preloadStatusCode3;
            }
            return preloadStatusCode2;
        }
        return preloadStatusCode;
    }
}
