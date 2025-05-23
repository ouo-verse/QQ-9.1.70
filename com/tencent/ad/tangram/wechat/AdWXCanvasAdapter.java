package com.tencent.ad.tangram.wechat;

import android.support.annotation.NonNull;
import com.tencent.ad.tangram.AdError;
import com.tencent.ad.tangram.annotation.AdKeep;
import com.tencent.ad.tangram.wechat.AdWXCanvas;

/* compiled from: P */
@AdKeep
/* loaded from: classes3.dex */
public interface AdWXCanvasAdapter {
    @NonNull
    AdError show(AdWXCanvas.Params params);
}
