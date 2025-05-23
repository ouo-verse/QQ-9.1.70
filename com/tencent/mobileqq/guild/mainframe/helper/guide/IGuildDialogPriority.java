package com.tencent.mobileqq.guild.mainframe.helper.guide;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.annotation.AnnotationTarget;
import org.jetbrains.annotations.NotNull;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/guild/mainframe/helper/guide/IGuildDialogPriority;", "", "Companion", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
@Deprecated(message = "\u53ef\u4ee5\u5220\u9664\u4e86")
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.FIELD, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes14.dex */
public @interface IGuildDialogPriority {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f227433a;
    public static final int GUILD_COVER_NOTICE_MSG_BUBBLE = 0;
    public static final int NEW_USER_CHANNEL_NOTICE_GUIDE = 6;
    public static final int NEW_USER_GUIDE_FIRST_STEP = 1;
    public static final int NEW_USER_GUIDE_SECOND_STEP = 2;
    public static final int NEW_USER_GUIDE_THIRD_STEP = 3;
    public static final int NEW_VERSION_GUIDE = 5;
    public static final int RECOMMENDED_CHANNEL_GUIDE = 4;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/guild/mainframe/helper/guide/IGuildDialogPriority$a;", "", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.mainframe.helper.guide.IGuildDialogPriority$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f227433a = new Companion();

        Companion() {
        }
    }
}
