package com.tencent.robot.slash.dialog.content.base;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.robot.slash.dialog.content.base.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import x64.m;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\n\u00a2\u0006\u0004\b\u000e\u0010\u000fJ \u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J \u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/robot/slash/dialog/content/base/a;", "Lx64/m;", "", "isHalfMode", "", "accumulatedValue", "totalAvailableHint", "w0", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mvi/api/ability/b;", "d", "Lcom/tencent/mvi/api/ability/b;", "mFetcher", "<init>", "(Lcom/tencent/mvi/api/ability/b;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a implements m {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mvi.api.ability.b mFetcher;

    public a(@NotNull com.tencent.mvi.api.ability.b mFetcher) {
        Intrinsics.checkNotNullParameter(mFetcher, "mFetcher");
        this.mFetcher = mFetcher;
    }

    @Override // x64.m
    public int Q(boolean isHalfMode, int accumulatedValue, int totalAvailableHint) {
        return this.mFetcher.fetchVBState(new b.FetchVisualHeight(isHalfMode, accumulatedValue, totalAvailableHint)).b().getInt("half_mode_visual_height", 0);
    }

    @Override // x64.m
    public int m() {
        return this.mFetcher.fetchVBState(b.c.f368466b).b().getInt("layout_sequence", 0);
    }

    @Override // x64.m
    public int w0(boolean isHalfMode, int accumulatedValue, int totalAvailableHint) {
        return this.mFetcher.fetchVBState(new b.FetchHeight(isHalfMode, accumulatedValue, totalAvailableHint)).b().getInt("half_mode_height", 0);
    }
}
