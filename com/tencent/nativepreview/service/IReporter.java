package com.tencent.nativepreview.service;

import androidx.annotation.Keep;
import cooperation.qqcircle.report.QCircleWeakNetReporter;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Keep
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0005H'\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/nativepreview/service/IReporter;", "", "report", "", "tag", "", "name", "time", "", QCircleWeakNetReporter.KEY_COST, "extraInfo", "native_preview_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes21.dex */
public interface IReporter {
    @Keep
    void report(@NotNull String tag, @NotNull String name, long time, long cost, @NotNull String extraInfo);
}
