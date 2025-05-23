package com.tencent.ad.tangram.mini;

import android.support.annotation.Nullable;
import com.tencent.ad.tangram.AdError;
import com.tencent.ad.tangram.annotation.AdKeep;
import com.tencent.ad.tangram.mini.AdQQMINIProgram;

@AdKeep
/* loaded from: classes3.dex */
public interface AdQQMINIProgramAdapter {
    @Nullable
    AdError show(AdQQMINIProgram.Params params);
}
