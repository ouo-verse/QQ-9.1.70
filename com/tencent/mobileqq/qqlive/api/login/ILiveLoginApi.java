package com.tencent.mobileqq.qqlive.api.login;

import com.tencent.mobileqq.qqlive.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.mobileqq.qqlive.login.LiveLoginInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&JU\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u00052/\u0010\n\u001a+\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00030\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010\u000bj\u0004\u0018\u0001`\u0010H&J$\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H&\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/qqlive/api/login/ILiveLoginApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getLoginInfo", "Lcom/tencent/mobileqq/qqlive/login/LiveLoginInfo;", "appId", "", "uin", "login", "", ICustomDataEditor.STRING_ARRAY_PARAM_2, "callback", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/qqlive/api/sso/QQLiveResponse;", "Lkotlin/ParameterName;", "name", "response", "Lcom/tencent/mobileqq/qqlive/api/login/LoginCallback;", "updateUserInfo", "", ITVKPlayerEventListener.KEY_USER_INFO, "Lcom/tencent/mobileqq/qqlive/data/user/LiveUserInfo;", "qq-live-sdk-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes17.dex */
public interface ILiveLoginApi extends QRouteApi {
    @Nullable
    LiveLoginInfo getLoginInfo(@NotNull String appId, @Nullable String uin);

    void login(@NotNull String appId, @Nullable String uin, @Nullable String a26, @Nullable Function1<? super QQLiveResponse<LiveLoginInfo>, Unit> callback);

    boolean updateUserInfo(@NotNull String appId, @Nullable String uin, @Nullable LiveUserInfo userInfo);
}
