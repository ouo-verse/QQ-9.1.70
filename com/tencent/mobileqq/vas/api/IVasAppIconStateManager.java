package com.tencent.mobileqq.vas.api;

import android.content.ComponentName;
import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001f\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00030\b0\u0007H&\u00a2\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u0005H&J\b\u0010\u000b\u001a\u00020\u0005H&J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&J\b\u0010\u0010\u001a\u00020\u0003H&J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0012\u001a\u00020\u0013H&J\b\u0010\u0014\u001a\u00020\u0013H&J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0013H&J\u0010\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0013H&\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/vas/api/IVasAppIconStateManager;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getAliasActivityName", "", "id", "", "getAllAlias", "", "Lkotlin/Pair;", "()[Lkotlin/Pair;", "getNowIconId", "getPrepareIconId", "getSplashActivityComponent", "Landroid/content/ComponentName;", "context", "Landroid/content/Context;", "getSplashActivityName", "isSupport", "isTestMode", "", "isUseAppIcon", "setNowIconId", "", "setPrepareIconId", "setTestMode", "b", "setUseAppIcon", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IVasAppIconStateManager extends QRouteApi {
    @Nullable
    String getAliasActivityName(int id5);

    @NotNull
    Pair<Integer, String>[] getAllAlias();

    int getNowIconId();

    int getPrepareIconId();

    @NotNull
    ComponentName getSplashActivityComponent(@NotNull Context context);

    @NotNull
    String getSplashActivityName();

    int isSupport(int id5);

    boolean isTestMode();

    boolean isUseAppIcon();

    void setNowIconId(int id5);

    void setPrepareIconId(int id5);

    void setTestMode(boolean b16);

    void setUseAppIcon(boolean b16);
}
