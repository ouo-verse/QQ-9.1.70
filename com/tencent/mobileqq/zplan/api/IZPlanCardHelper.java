package com.tencent.mobileqq.zplan.api;

import android.content.Context;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@QRouteFactory(singleton = true)
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/zplan/api/IZPlanCardHelper;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "createCard", "Landroid/view/View;", "viewType", "", "context", "Landroid/content/Context;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "mapResViewModel", "", "sourceCurrent", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "zplan_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IZPlanCardHelper extends QRouteApi {
    @NotNull
    View createCard(int viewType, @NotNull Context context, @NotNull LifecycleOwner owner, @NotNull Object mapResViewModel, @NotNull ZootopiaSource sourceCurrent);
}
