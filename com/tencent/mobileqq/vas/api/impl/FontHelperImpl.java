package com.tencent.mobileqq.vas.api.impl;

import com.tencent.mobileqq.vas.api.IFontHelper;
import com.tencent.mobileqq.vas.font.manager.FontInfoManager;
import com.tencent.mobileqq.vas.font.report.VasFontReporter;
import cooperation.qqcircle.report.QCircleWeakNetReporter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J(\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/vas/api/impl/FontHelperImpl;", "Lcom/tencent/mobileqq/vas/api/IFontHelper;", "()V", "clearFontListener", "", "report", "id", "", QCircleWeakNetReporter.KEY_COST, "task", "", "text", "vas_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class FontHelperImpl implements IFontHelper {
    @Override // com.tencent.mobileqq.vas.api.IFontHelper
    public void clearFontListener() {
        FontInfoManager.INSTANCE.b().t();
    }

    @Override // com.tencent.mobileqq.vas.api.IFontHelper
    public void report(long id5, long cost, @NotNull String task, @NotNull String text) {
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(text, "text");
        VasFontReporter.INSTANCE.report(id5, cost, task, text);
    }
}
