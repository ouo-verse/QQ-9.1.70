package com.tencent.nativepreview.wrapper.base;

import androidx.annotation.Keep;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Keep
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J%\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H'\u00a2\u0006\u0002\u0010\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/nativepreview/wrapper/base/ImageExportCallback;", "", "onCallback", "", "successful", "", "paths", "", "", "(Z[Ljava/lang/String;)V", "native_preview_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes21.dex */
public interface ImageExportCallback {
    @Keep
    void onCallback(boolean successful, @Nullable String[] paths);
}
