package com.tencent.mobileqq.settings.business.api;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u001a\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u001a\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u001a\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u001a\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/settings/business/api/ISettingSearchHightApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "startQUIBottomTabSettingPage", "", "context", "Landroid/content/Context;", "params", "Landroid/content/Intent;", "startQUIChatHistorySettingPage", "startQUIPrivacyInteractionSettingPage", "startQUISoundPage", "startQUITempMsgSettingPage", "base_proj_ext_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface ISettingSearchHightApi extends QRouteApi {
    void startQUIBottomTabSettingPage(@NotNull Context context, @Nullable Intent params);

    void startQUIChatHistorySettingPage(@NotNull Context context, @Nullable Intent params);

    void startQUIPrivacyInteractionSettingPage(@NotNull Context context, @Nullable Intent params);

    void startQUISoundPage(@NotNull Context context, @Nullable Intent params);

    void startQUITempMsgSettingPage(@NotNull Context context, @Nullable Intent params);
}
