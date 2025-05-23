package com.tencent.mobileqq.wxsetting.api;

import androidx.lifecycle.Lifecycle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.mobileqq.widget.listitem.Group;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/wxsetting/api/IWxMiniSettingProvider;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getWxMiniSettingConfig", "Lcom/tencent/mobileqq/widget/listitem/Group;", "registerWxMiniGroupLifecycle", "", VipFunCallConstants.KEY_GROUP, "lifecycle", "Landroidx/lifecycle/Lifecycle;", "qqmini-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {""})
/* loaded from: classes21.dex */
public interface IWxMiniSettingProvider extends QRouteApi {
    @NotNull
    Group getWxMiniSettingConfig();

    void registerWxMiniGroupLifecycle(@NotNull Group group, @NotNull Lifecycle lifecycle);
}
