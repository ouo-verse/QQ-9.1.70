package com.tencent.mobileqq.pymk.api;

import com.tencent.mobileqq.pymk.i;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&J\b\u0010\f\u001a\u00020\u0002H&J\b\u0010\r\u001a\u00020\u0002H&J\b\u0010\u000e\u001a\u00020\u0002H&J\b\u0010\u000f\u001a\u00020\u0004H&J\b\u0010\u0010\u001a\u00020\u0004H&J\b\u0010\u0011\u001a\u00020\u0004H&J\b\u0010\u0012\u001a\u00020\u0004H&\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/pymk/api/IPYMKSwitchAGuideApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "recordGuideClose", "", "isAbleToShowPYMKGuide", "Lcom/tencent/mobileqq/pymk/i;", "listener", "", "from", "addPYMKSwitchChangeListener", "removePYMKSwitchChangeListener", "removePYMKData", "reqOpenPYMKSetting", "reqGetPYMKSetting", "getPYMKSetting", "hasPYMKSwitchSaved", "getIsFirstTimeUpTo9025", "simplifyTop2", "base_proj_ext_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IPYMKSwitchAGuideApi extends QRouteApi {
    void addPYMKSwitchChangeListener(@NotNull i listener, @NotNull String from);

    boolean getIsFirstTimeUpTo9025();

    boolean getPYMKSetting();

    boolean hasPYMKSwitchSaved();

    boolean isAbleToShowPYMKGuide();

    void recordGuideClose();

    void removePYMKData();

    void removePYMKSwitchChangeListener(@NotNull i listener, @NotNull String from);

    void reqGetPYMKSetting();

    void reqOpenPYMKSetting();

    boolean simplifyTop2();
}
