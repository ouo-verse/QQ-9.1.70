package com.tencent.biz.qqcircle.immersive.utils;

import com.tencent.biz.qqcircle.immersive.viewmodel.wink.QFSPublishFeedViewModel;
import com.tencent.biz.qqcircle.widgets.QFSPublishPagBubble;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/utils/ap;", "", "Lcom/tencent/biz/qqcircle/immersive/viewmodel/wink/QFSPublishFeedViewModel;", "viewModel", "Lcom/tencent/biz/qqcircle/widgets/QFSPublishPagBubble$PagBubbleType;", "f", "", "e", "d", "", "a", "c", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_SHOW_TYPE, "b", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class ap {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ap f90138a = new ap();

    ap() {
    }

    @JvmStatic
    @NotNull
    public static final int[] d(@NotNull QFSPublishFeedViewModel viewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        if (viewModel.w2()) {
            return new int[]{ImmersiveUtils.dpToPx(3.0f), ImmersiveUtils.dpToPx(-6.0f)};
        }
        return new int[]{ImmersiveUtils.dpToPx(14.0f), ImmersiveUtils.dpToPx(-6.0f)};
    }

    @JvmStatic
    @NotNull
    public static final int[] e(@NotNull QFSPublishFeedViewModel viewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        if (viewModel.w2()) {
            return new int[]{1, 0};
        }
        return new int[]{3, 4};
    }

    @JvmStatic
    @NotNull
    public static final QFSPublishPagBubble.PagBubbleType f(@NotNull QFSPublishFeedViewModel viewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        if (viewModel.w2()) {
            return QFSPublishPagBubble.PagBubbleType.TYPE_NEW_USER;
        }
        return QFSPublishPagBubble.PagBubbleType.TYPE_NEW_USER_ABOVE;
    }

    public final int a(@NotNull QFSPublishFeedViewModel viewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        if (viewModel.w2() || !viewModel.x2()) {
            return 1;
        }
        return 0;
    }

    @NotNull
    public final int[] b(@NotNull QFSPublishFeedViewModel viewModel, @NotNull String showType) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(showType, "showType");
        int i3 = 0;
        if (viewModel.w2()) {
            return new int[]{0, ImmersiveUtils.dpToPx(-10.0f)};
        }
        if (viewModel.x2()) {
            boolean areEqual = Intrinsics.areEqual(showType, WadlProxyConsts.KEY_MATERIAL);
            int[] iArr = new int[2];
            iArr[0] = ImmersiveUtils.dpToPx(-1.0f);
            if (!areEqual) {
                i3 = ImmersiveUtils.dpToPx(-20.0f);
            }
            iArr[1] = i3;
            return iArr;
        }
        return new int[]{0, 0};
    }

    @NotNull
    public final int[] c(@NotNull QFSPublishFeedViewModel viewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        if (viewModel.w2()) {
            return new int[]{1, 0};
        }
        if (viewModel.x2()) {
            return new int[]{2, 4};
        }
        return new int[]{1, 3};
    }
}
