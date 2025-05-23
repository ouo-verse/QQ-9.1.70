package com.tencent.mobileqq.qqguildsdk.data.type;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import org.jetbrains.annotations.NotNull;

@Retention(RetentionPolicy.SOURCE)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/qqguildsdk/data/type/IRolePermissionType;", "", "Companion", "a", "qqguild-sdk-api_release"}, k = 1, mv = {1, 7, 1})
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
/* loaded from: classes17.dex */
public @interface IRolePermissionType {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f266744a;
    public static final int MANAGE_CHANNEL_AND_GROUP = 2;
    public static final int MANAGE_GUILD = 1;
    public static final int MANAGE_MEMBER = 3;
    public static final int MANAGE_ROLE = 4;
    public static final int MANAGE_ROLE_NEW = 70000;
    public static final int SPEAK_RULE = 7;
    public static final int SPEAK_THRESHOLD = 8;
    public static final int UNSPECIFIED = 0;
    public static final int VIEW_DATA = 5;
    public static final int VIEW_LOG = 6;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/qqguildsdk/data/type/IRolePermissionType$a;", "", "<init>", "()V", "qqguild-sdk-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqguildsdk.data.type.IRolePermissionType$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f266744a = new Companion();

        Companion() {
        }
    }
}
