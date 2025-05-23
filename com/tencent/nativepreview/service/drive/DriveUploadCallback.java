package com.tencent.nativepreview.service.drive;

import androidx.annotation.Keep;
import com.tencent.nativepreview.wrapper.model.DocInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Keep
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH'\u00a8\u0006\n"}, d2 = {"Lcom/tencent/nativepreview/service/drive/DriveUploadCallback;", "", "onCallback", "", "ret", "", "message", "", "docInfo", "Lcom/tencent/nativepreview/wrapper/model/DocInfo;", "native_preview_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes21.dex */
public interface DriveUploadCallback {
    @Keep
    void onCallback(int ret, @Nullable String message, @Nullable DocInfo docInfo);
}
