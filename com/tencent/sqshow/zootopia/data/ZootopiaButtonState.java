package com.tencent.sqshow.zootopia.data;

import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/sqshow/zootopia/data/ZootopiaButtonState;", "Ljava/io/Serializable;", "()V", "progress", "", HippyQQPagView.FunctionName.GET_PROGRESS, "()F", HippyQQPagView.FunctionName.SET_PROGRESS, "(F)V", "status", "Lcom/tencent/sqshow/zootopia/data/ButtonStatus;", ThemeReporter.BUNDLE_KEY_TASK_GET_STATUS, "()Lcom/tencent/sqshow/zootopia/data/ButtonStatus;", "setStatus", "(Lcom/tencent/sqshow/zootopia/data/ButtonStatus;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class ZootopiaButtonState implements Serializable {
    private float progress;
    private ButtonStatus status = ButtonStatus.INIT;

    public final float getProgress() {
        return this.progress;
    }

    public final ButtonStatus getStatus() {
        return this.status;
    }

    public final void setProgress(float f16) {
        this.progress = f16;
    }

    public final void setStatus(ButtonStatus buttonStatus) {
        Intrinsics.checkNotNullParameter(buttonStatus, "<set-?>");
        this.status = buttonStatus;
    }
}
