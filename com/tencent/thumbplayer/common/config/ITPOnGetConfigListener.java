package com.tencent.thumbplayer.common.config;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalParam;

/* loaded from: classes26.dex */
public interface ITPOnGetConfigListener {
    @Nullable
    TPOptionalParam<?> onGetConfig(@NonNull String str);
}
