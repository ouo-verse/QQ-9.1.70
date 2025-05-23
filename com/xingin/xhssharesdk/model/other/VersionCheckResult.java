package com.xingin.xhssharesdk.model.other;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: P */
@Keep
/* loaded from: classes28.dex */
public class VersionCheckResult {
    public static final int NOT_INSTALL = -1;
    public static final int SUPPORT_SHARE_NOTE = 0;
    public static final int VERSION_IS_NOT_SUPPORT = -2;
    public int checkResultCode;

    @NonNull
    public String errorMessage;

    @Nullable
    public Throwable exception;

    public VersionCheckResult(int i3, @NonNull String str, @Nullable Throwable th5) {
        this.checkResultCode = i3;
        this.errorMessage = str;
        this.exception = th5;
    }
}
