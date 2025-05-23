package com.tencent.mobileqq.guild.channel.joinchannel;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import org.jetbrains.annotations.NotNull;

@Retention(RetentionPolicy.SOURCE)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/guild/channel/joinchannel/JoinSuccessPageSource;", "", "Companion", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
/* loaded from: classes12.dex */
public @interface JoinSuccessPageSource {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f214967a;
    public static final int DEFAULT = 0;
    public static final int DIALOG_STANDALONE = 2;
    public static final int DIRECT_MESSAGE = 12;
    public static final int FEED_CHANNEL = 4;
    public static final int FEED_DETAIL = 9;
    public static final int FULL_STANDALONE = 1;
    public static final int LIVE_CHANNEL = 5;
    public static final int MEDIA_CHANNEL = 7;
    public static final int PROFILE_CARD = 11;
    public static final int SCHEDULE_CHANNEL = 6;
    public static final int SCHEDULE_DETAIL = 10;
    public static final int TEXT_CHANNEL = 3;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/guild/channel/joinchannel/JoinSuccessPageSource$a;", "", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.channel.joinchannel.JoinSuccessPageSource$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f214967a = new Companion();

        Companion() {
        }
    }
}
