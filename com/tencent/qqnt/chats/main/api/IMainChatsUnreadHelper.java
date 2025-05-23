package com.tencent.qqnt.chats.main.api;

import android.view.View;
import androidx.annotation.MainThread;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'J\b\u0010\u0007\u001a\u00020\u0004H'J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH'J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bH'\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/chats/main/api/IMainChatsUnreadHelper;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Landroid/view/View;", "view", "", "bindView", "unbindView", "notifyClearAll", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "notifyClearItem", "", "getBindViews", "chats_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {""})
/* loaded from: classes24.dex */
public interface IMainChatsUnreadHelper extends QRouteApi {
    @MainThread
    void bindView(@NotNull View view);

    @MainThread
    @NotNull
    List<View> getBindViews();

    @MainThread
    void notifyClearAll();

    @MainThread
    void notifyClearItem(@NotNull g item);

    @MainThread
    void unbindView(@NotNull View view);
}
