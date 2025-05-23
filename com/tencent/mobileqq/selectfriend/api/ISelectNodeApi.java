package com.tencent.mobileqq.selectfriend.api;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bg\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/selectfriend/api/ISelectNodeApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getSelectEnterAdapter", "Ljava/lang/Class;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "selectEnterType", "", "qq_selectfriend_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface ISelectNodeApi extends QRouteApi {
    @NotNull
    Class<? extends RecyclerView.Adapter<?>> getSelectEnterAdapter(int selectEnterType);
}
