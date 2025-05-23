package com.tencent.mobileqq.qqguildsdk.data.type;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import org.jetbrains.annotations.NotNull;

@Retention(RetentionPolicy.SOURCE)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/qqguildsdk/data/type/IPermissionType;", "", "Companion", "a", "qqguild-sdk-api_release"}, k = 1, mv = {1, 7, 1})
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
/* loaded from: classes17.dex */
public @interface IPermissionType {
    public static final int AUDIT_MEMBER_JOIN = 80001;
    public static final int BIND_WHEN_CREATING_CHANNEL = 20004;
    public static final int BLACKLIST_MEMBER = 100002;
    public static final int CHANGE_ROLE_MEMBER = 70005;
    public static final int CLEAR_MEMBER_MESSAGE = 30007;
    public static final int CREATE_CHANNEL = 20001;
    public static final int CREATE_GROUP = 20005;
    public static final int CREATE_ROLE = 70001;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f266742a;
    public static final int DELETE_CHANNEL = 20002;
    public static final int DELETE_GROUP = 20007;
    public static final int DELETE_ROLE = 70004;
    public static final int FORBIDDEN_WORDS = 90001;
    public static final int GAME_CHANNEL_CONTENT = 30006;
    public static final int JOIN_MODE_SETTINGS = 80002;
    public static final int LIVE_CHANNEL_CONTENT = 30004;
    public static final int MANAGER_CHECKIN = 10009;
    public static final int MANAGE_BIND_GROUP = 110001;
    public static final int MANAGE_SORT_GROUP = 110003;
    public static final int MANAGE_UNBIND_GROUP = 110002;
    public static final int MODIFY_CHANNEL_NAME = 20003;
    public static final int MODIFY_CHANNEL_SPEAK = 70007;
    public static final int MODIFY_CHANNEL_VIEW = 70006;
    public static final int MODIFY_FORUM_CHANNEL = 20011;
    public static final int MODIFY_GROUP_NAME = 20006;
    public static final int MODIFY_GUILD_INFO = 10001;
    public static final int MODIFY_ROLE = 70002;
    public static final int MODIFY_SCHEDULE_CHANNEL = 20014;
    public static final int MODIFY_SPEAK_RULE = 10004;
    public static final int MODIFY_SPEAK_THRESHOLD = 10005;
    public static final int MODIFY_VIDEO_CHANNEL = 20013;
    public static final int MODIFY_VOICE_CHANNEL = 20012;
    public static final int MODIFY_WORD_APPLICATION_CHANNEL = 20015;
    public static final int MODIFY_WORD_CHANNEL = 20010;
    public static final int MODIFY_WORLD_CHANNEL = 20019;
    public static final int ORDER_ROLE = 70003;
    public static final int OTHER_PLATFORM_IDENTITY = 10003;
    public static final int POST_CHANNEL_CONTENT = 30002;
    public static final int PUBLIC_NOTICE = 40001;
    public static final int REMOVE_MEMBER = 100001;
    public static final int SCHEDULE_CHANNEL_CONTENT = 30005;
    public static final int TEXT_CHANNEL_CONTENT = 30001;
    public static final int UNSPECIFIED = 0;
    public static final int VIEW_DATA = 50001;
    public static final int VIEW_LOG = 60001;
    public static final int VOICE_CHANNEL_CONTENT = 30003;
    public static final int VOICE_CHANNEL_MUTE_OTHER = 90002;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/qqguildsdk/data/type/IPermissionType$a;", "", "<init>", "()V", "qqguild-sdk-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqguildsdk.data.type.IPermissionType$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f266742a = new Companion();

        Companion() {
        }
    }
}
