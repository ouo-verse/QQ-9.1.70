package com.tencent.mobileqq.pymk.api;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.pymk.g;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u000bH&J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rH&J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rH&\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/pymk/api/IPYMKAddFrinedApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Landroid/content/Context;", "context", "Landroid/widget/LinearLayout;", "getPYMKItemView", "view", "Lcom/tencent/mobileqq/persistence/Entity;", "entity", "", "bindData", "Landroid/view/View;", "initMediaLayout", "Lcom/tencent/mobileqq/pymk/g;", "listener", "addOnSwitchChangeListener", "removeOnSwitchChangeListener", "qqaddfriend-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IPYMKAddFrinedApi extends QRouteApi {
    void addOnSwitchChangeListener(@NotNull g listener);

    void bindData(@NotNull LinearLayout view, @NotNull Entity entity);

    @NotNull
    LinearLayout getPYMKItemView(@NotNull Context context);

    void initMediaLayout(@NotNull View view);

    void removeOnSwitchChangeListener(@NotNull g listener);
}
