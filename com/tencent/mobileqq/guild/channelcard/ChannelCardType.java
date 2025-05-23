package com.tencent.mobileqq.guild.channelcard;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Retention(RetentionPolicy.SOURCE)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/guild/channelcard/ChannelCardType;", "", "Companion", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
/* loaded from: classes12.dex */
public @interface ChannelCardType {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f215207a;
    public static final int FEED = 1;
    public static final int LIVE = 2;
    public static final int TEXT = 7;
    public static final int UNKOWN = 0;
    public static final int VOICE = 3;
    public static final int VOICE_LISTENING_TOGETHER = 8;
    public static final int VOICE_PLAY_TOGETHER = 12;
    public static final int VOICE_SCREEN_SHARE = 4;
    public static final int VOICE_SMOBA = 5;
    public static final int WORLD = 6;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/guild/channelcard/ChannelCardType$a;", "", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.channelcard.ChannelCardType$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f215207a = new Companion();

        Companion() {
        }
    }
}
