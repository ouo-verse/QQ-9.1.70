package com.tencent.timi.game.ad.data;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/timi/game/ad/data/IOperationItemType;", "", "Companion", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.FIELD, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER})
@Retention(RetentionPolicy.SOURCE)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
/* loaded from: classes26.dex */
public @interface IOperationItemType {
    public static final int BATTERY_TASK_ENTRANCE = 3;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f376224a;
    public static final int SUBSCRIPT_ENTRANCE = 4;
    public static final int TIAN_SHU = 1;
    public static final int TIMI_LOTTERY_RED_POCKET = 2;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/timi/game/ad/data/IOperationItemType$a;", "", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.timi.game.ad.data.IOperationItemType$a, reason: from kotlin metadata */
    /* loaded from: classes26.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f376224a = new Companion();

        Companion() {
        }
    }
}
