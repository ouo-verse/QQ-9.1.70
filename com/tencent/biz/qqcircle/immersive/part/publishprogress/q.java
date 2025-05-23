package com.tencent.biz.qqcircle.immersive.part.publishprogress;

import com.tencent.biz.qqcircle.immersive.part.at;
import com.tencent.mobileqq.qcircle.api.IQCircleABTestApi;
import com.tencent.mobileqq.qcircle.api.global.QCircleHostGlobalInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\b\u001a\u00020\u0004R\u0014\u0010\u000b\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\nR\u0016\u0010\r\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/part/publishprogress/q;", "", "", "pageType", "", "c", "", "b", "a", "Lcom/tencent/mobileqq/qcircle/api/IQCircleABTestApi;", "Lcom/tencent/mobileqq/qcircle/api/IQCircleABTestApi;", "abTestApi", "Z", "useRectBoxUI", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final q f88294a = new q();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final IQCircleABTestApi abTestApi;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static boolean useRectBoxUI;

    static {
        QRouteApi api = QRoute.api(IQCircleABTestApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IQCircleABTestApi::class.java)");
        abTestApi = (IQCircleABTestApi) api;
    }

    q() {
    }

    public final boolean a() {
        if (useRectBoxUI) {
            return m.INSTANCE.a();
        }
        return at.F;
    }

    public final void b() {
        abTestApi.reportExpExposure("exp_QQ_shortvideo_author_afterpublishguidance_new");
    }

    public final boolean c(int pageType) {
        boolean z16;
        if (abTestApi.isExperiment("exp_QQ_shortvideo_author_afterpublishguidance_new") && QCircleHostGlobalInfo.getFolderUIType() == 3 && pageType == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        useRectBoxUI = z16;
        return z16;
    }
}
