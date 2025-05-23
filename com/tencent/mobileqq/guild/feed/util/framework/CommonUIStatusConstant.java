package com.tencent.mobileqq.guild.feed.util.framework;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/util/framework/CommonUIStatusConstant;", "", "Companion", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.FIELD, AnnotationTarget.PROPERTY})
@Retention(RetentionPolicy.SOURCE)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
/* loaded from: classes13.dex */
public @interface CommonUIStatusConstant {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f223904a;
    public static final int EMPTY = 1;
    public static final int ERROR = 4;
    public static final int LOADING = 2;
    public static final int NETWORK_UNAVAILABLE = 3;
    public static final int NORMAL = 0;
    public static final int SECURITY_ERR = 10001;
    public static final int UNINITIALIZED = -1;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/util/framework/CommonUIStatusConstant$a;", "", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.util.framework.CommonUIStatusConstant$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f223904a = new Companion();

        Companion() {
        }
    }
}
