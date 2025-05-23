package com.tencent.libra.listener;

import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;

/* loaded from: classes7.dex */
public interface IPicLoadStateListener {
    void onStateChange(LoadState loadState, Option option);
}
