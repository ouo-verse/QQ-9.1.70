package com.tencent.mobileqq.icgame.base.room.pageconfig;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Target({ElementType.PARAMETER, ElementType.TYPE_USE})
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/icgame/base/room/pageconfig/ComponentConfigType;", "", "Companion", "a", "ic-game-room-base_release"}, k = 1, mv = {1, 7, 1})
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.TYPE})
@Retention(RetentionPolicy.SOURCE)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
/* loaded from: classes15.dex */
public @interface ComponentConfigType {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f237233a;

    @NotNull
    public static final String ENTERTAINMENT = "entertainment";

    @NotNull
    public static final String ENTERTAINMENT_ANCHOR = "entertainment_anchor";

    @NotNull
    public static final String GAME = "game";

    @NotNull
    public static final String OD = "od";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/icgame/base/room/pageconfig/ComponentConfigType$a;", "", "<init>", "()V", "ic-game-room-base_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.icgame.base.room.pageconfig.ComponentConfigType$a, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f237233a = new Companion();

        Companion() {
        }
    }
}
