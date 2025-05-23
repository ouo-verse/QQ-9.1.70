package com.tencent.icgame.game.userinfo.api;

import androidx.annotation.Nullable;
import com.tencent.icgame.trpc.yes.common.CommonOuterClass$QQUserId;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes7.dex */
public interface IUserInfo {

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes7.dex */
    public @interface GenderType {
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes7.dex */
    public @interface IdentityType {
    }

    long a();

    long b();

    boolean e(@Nullable CommonOuterClass$QQUserId commonOuterClass$QQUserId);

    String f(@Nullable CommonOuterClass$QQUserId commonOuterClass$QQUserId);

    String g(@Nullable CommonOuterClass$QQUserId commonOuterClass$QQUserId);

    String h(@Nullable CommonOuterClass$QQUserId commonOuterClass$QQUserId);
}
