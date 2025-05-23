package com.tencent.ecommerce.biz.qq.api;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.minigame.kuikly.MiniGameKuiklyModule;
import com.tencent.qqmini.sdk.plugins.QQFriendJsPlugin;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0007H&J\u0012\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\u0007H&J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u0007H&J\b\u0010\u0010\u001a\u00020\u0007H&J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0012\u001a\u00020\u0007H&JT\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00072:\b\u0002\u0010\u0014\u001a4\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\u0016\u0012\b\b\u0006\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\u0016\u0012\b\b\u0006\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0015H&Jl\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u000f2:\b\u0002\u0010\u0014\u001a4\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\u0016\u0012\b\b\u0006\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\u0016\u0012\b\b\u0006\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0015H&JP\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u000726\u0010\u0014\u001a2\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\u0016\u0012\b\b\u0006\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\u0016\u0012\b\b\u0006\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00030\u0015H&J\u0018\u0010\u001e\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0007H&J\u0018\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0007H&J\u0018\u0010 \u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0007H&\u00a8\u0006!"}, d2 = {"Lcom/tencent/ecommerce/biz/qq/api/IECQQApi;", "", QQFriendJsPlugin.API_ADD_FRIEND, "", "context", "Landroid/content/Context;", "name", "", "uin", "addFriendWithParams", "con", "params", "getContactFaceDrawable", "Landroid/graphics/drawable/Drawable;", "getFriendStatus", "", "getLbsInfo", "getTroopFaceDrawable", "troopUin", "joinDaZi", "callback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "code", "msg", "joinTroop", "troopName", "authSign", "sourceId", MiniGameKuiklyModule.METHOD_OPEN_MINI_APP, "openProfileCard", "openSearchEmoticonPage", "openTroopPage", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public interface IECQQApi {
    void addFriend(@NotNull Context context, @NotNull String name, @NotNull String uin);

    void addFriendWithParams(@NotNull Context con, @NotNull String params);

    @Nullable
    Drawable getContactFaceDrawable(@NotNull String uin);

    int getFriendStatus(@NotNull String uin);

    @NotNull
    String getLbsInfo();

    @Nullable
    Drawable getTroopFaceDrawable(@NotNull String troopUin);

    void joinDaZi(@NotNull Context context, @NotNull String params, @Nullable Function2<? super Integer, ? super String, Unit> callback);

    void joinTroop(@NotNull Context context, @NotNull String troopUin, @NotNull String troopName, @NotNull String authSign, int sourceId, @Nullable Function2<? super Integer, ? super String, Unit> callback);

    void openMiniApp(@NotNull Context context, @NotNull String params, @NotNull Function2<? super Integer, ? super String, Unit> callback);

    void openProfileCard(@NotNull Context con, @NotNull String params);

    void openSearchEmoticonPage(@NotNull Context context, @NotNull String params);

    void openTroopPage(@NotNull Context context, @NotNull String params);
}
