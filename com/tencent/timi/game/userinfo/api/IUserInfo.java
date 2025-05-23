package com.tencent.timi.game.userinfo.api;

import androidx.annotation.Nullable;
import bo4.e;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.GameRoleOuterClass$SmobaGameRoleInfo;
import trpc.yes.common.UserProxyCmdOuterClass$UserGameOpenid;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface IUserInfo {

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes26.dex */
    public @interface GenderType {
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes26.dex */
    public @interface IdentityType {
    }

    long a();

    long b();

    Long c();

    @Nullable
    e d();

    boolean e(@Nullable CommonOuterClass$QQUserId commonOuterClass$QQUserId);

    String f(@Nullable CommonOuterClass$QQUserId commonOuterClass$QQUserId);

    @Nullable
    @Deprecated
    GameRoleOuterClass$SmobaGameRoleInfo g();

    String h(@Nullable CommonOuterClass$QQUserId commonOuterClass$QQUserId);

    String i(@Nullable CommonOuterClass$QQUserId commonOuterClass$QQUserId);

    String j(@Nullable CommonOuterClass$QQUserId commonOuterClass$QQUserId);

    boolean k(long j3);

    @Nullable
    UserProxyCmdOuterClass$UserGameOpenid l();

    String m(@Nullable CommonOuterClass$QQUserId commonOuterClass$QQUserId);

    boolean n();
}
