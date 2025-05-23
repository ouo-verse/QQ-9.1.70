package com.tencent.mobileqq.settings.business.api;

import android.content.Context;
import com.tencent.mobileqq.activity.newsetting.custom.group.a;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\t\u001a\u00020\bH&J\b\u0010\n\u001a\u00020\u0006H&J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0006H&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/settings/business/api/IGrowthPushSwitchApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/activity/newsetting/custom/group/a;", "createSettingGroup", "", "isContrastGroup", "", "reportTabExposure", "isForceEnabled", NodeProps.ENABLED, "setForceEnabled", "base_proj_ext_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface IGrowthPushSwitchApi extends QRouteApi {
    @NotNull
    a createSettingGroup(@NotNull Context context);

    boolean isContrastGroup();

    boolean isForceEnabled();

    void reportTabExposure();

    void setForceEnabled(boolean enabled);
}
