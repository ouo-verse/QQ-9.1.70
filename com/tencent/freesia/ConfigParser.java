package com.tencent.freesia;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes6.dex */
public interface ConfigParser {
    @Nullable
    IConfigData defaultConfig();

    @Nullable
    IConfigData doParse(@NonNull String str, @NonNull String str2, @NonNull byte[] bArr);

    boolean isAccountRelated();

    void onCdnDownload(boolean z16);

    void onCdnNotUpdate();

    void onConfigUpdate(@Nullable IConfigData iConfigData);

    void onReceive(boolean z16);

    void onReceiveNotUpdate(@NonNull NetworkResult networkResult);

    void onRemoved();

    void onSend(@NonNull String str);
}
