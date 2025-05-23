package com.tencent.mobileqq.vas.kuikly.api.impl;

import android.util.Size;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.kuikly.core.render.android.context.KuiklyRenderCoreExecuteMode;
import com.tencent.kuikly.core.render.android.exception.ErrorReason;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyFactory;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.g;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.vas.kuikly.api.IVasKuiklyLogicApi;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s13.KuikLyConfig;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\"\u0010\u000f\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/vas/kuikly/api/impl/VasKuiklyLogicApiImpl;", "Lcom/tencent/mobileqq/vas/kuikly/api/IVasKuiklyLogicApi;", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/h;", "Ls13/a;", DownloadInfo.spKey_Config, "", "sendEvent", "destroy", "openLucky", "", "isSucceed", "Lcom/tencent/kuikly/core/render/android/exception/ErrorReason;", HiAnalyticsConstant.HaKey.BI_KEY_ERRORREASON, "Lcom/tencent/kuikly/core/render/android/context/KuiklyRenderCoreExecuteMode;", "executeMode", "onPageLoadComplete", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/g;", "renderLogicView", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/g;", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class VasKuiklyLogicApiImpl implements IVasKuiklyLogicApi, h {

    @Nullable
    private g renderLogicView;

    private final void sendEvent(KuikLyConfig config) {
        g gVar = this.renderLogicView;
        if (gVar != null) {
            String eventName = config.getEventName();
            Map<String, String> d16 = config.d();
            if (d16 == null) {
                d16 = MapsKt__MapsKt.emptyMap();
            }
            gVar.sentEvent(eventName, d16);
        }
    }

    @Override // com.tencent.mobileqq.vas.kuikly.api.IVasKuiklyLogicApi
    public void destroy() {
        try {
            g gVar = this.renderLogicView;
            if (gVar != null) {
                gVar.onDetach();
            }
            this.renderLogicView = null;
        } catch (Exception unused) {
        }
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void hideErrorView() {
        h.a.a(this);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void hideLoadingView() {
        h.a.b(this);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void onPageLoadComplete(boolean isSucceed, @Nullable ErrorReason errorReason, @NotNull KuiklyRenderCoreExecuteMode executeMode) {
        Intrinsics.checkNotNullParameter(executeMode, "executeMode");
    }

    @Override // com.tencent.mobileqq.vas.kuikly.api.IVasKuiklyLogicApi
    public void openLucky(@NotNull KuikLyConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        if (this.renderLogicView == null) {
            IQQKuiklyFactory iQQKuiklyFactory = (IQQKuiklyFactory) QRoute.api(IQQKuiklyFactory.class);
            BaseApplication context = BaseApplication.context;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            this.renderLogicView = iQQKuiklyFactory.createKuiklyRenderView(context, this);
            HashMap hashMap = new HashMap();
            hashMap.put("bundle_name", config.getModuleName());
            Map<String, String> d16 = config.d();
            if (d16 != null) {
                hashMap.putAll(d16);
            }
            g gVar = this.renderLogicView;
            if (gVar != null) {
                gVar.b(config.getPageName(), hashMap, new Size(0, 0));
                return;
            }
            return;
        }
        sendEvent(config);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void showErrorView() {
        h.a.c(this);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void showLoadingView() {
        h.a.d(this);
    }
}
