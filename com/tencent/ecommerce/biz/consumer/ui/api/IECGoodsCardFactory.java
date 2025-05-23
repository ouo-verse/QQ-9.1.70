package com.tencent.ecommerce.biz.consumer.ui.api;

import android.content.Context;
import com.tencent.ecommerce.biz.consumer.ECContentInfo;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\nH&J(\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\nH&J\u0018\u0010\r\u001a\u00020\f2\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/ecommerce/biz/consumer/ui/api/IECGoodsCardFactory;", "", "getViewModel", "Lcom/tencent/ecommerce/biz/consumer/ui/api/IECGoodsViewModel;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_UNIQUE_ID, "", "contextWeakReference", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "contentInfo", "Lcom/tencent/ecommerce/biz/consumer/ECContentInfo;", "preloadViewModel", "", "releaseViewModels", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public interface IECGoodsCardFactory {
    @Nullable
    IECGoodsViewModel getViewModel(@NotNull String uniqueId, @Nullable WeakReference<Context> contextWeakReference, @NotNull ECContentInfo contentInfo);

    void preloadViewModel(@NotNull String uniqueId, @Nullable WeakReference<Context> contextWeakReference, @NotNull ECContentInfo contentInfo);

    void releaseViewModels(@Nullable WeakReference<Context> contextWeakReference);
}
