package com.tencent.mobileqq.selectfriend.api;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH&J \u0010\u000b\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\r0\f2\u0006\u0010\u000f\u001a\u00020\tH&\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/selectfriend/api/IMyNodeApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "forwardRecentItemViewOnClick", "", "v", "Landroid/view/View;", "uin", "", "uinType", "", "forwardAbility", "getMyNodeAdapter", "Ljava/lang/Class;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "myNodeType", "qq_selectfriend_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface IMyNodeApi extends QRouteApi {
    void forwardRecentItemViewOnClick(@NotNull View v3, @NotNull String uin, int uinType, int forwardAbility);

    @NotNull
    Class<? extends RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> getMyNodeAdapter(int myNodeType);
}
