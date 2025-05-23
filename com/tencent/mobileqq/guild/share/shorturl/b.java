package com.tencent.mobileqq.guild.share.shorturl;

import com.tencent.mobileqq.guild.data.GuildSharePageSource;
import com.tencent.mobileqq.guild.util.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\"\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/guild/data/GuildSharePageSource;", "Lcom/tencent/mobileqq/guild/share/shorturl/ShareServiceType;", "a", "(Lcom/tencent/mobileqq/guild/data/GuildSharePageSource;)Lcom/tencent/mobileqq/guild/share/shorturl/ShareServiceType;", "shareServiceType", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class b {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f235103a;

        static {
            int[] iArr = new int[GuildSharePageSource.values().length];
            try {
                iArr[GuildSharePageSource.GAMEQA_CHANNEL_INVITE_WORD_LINK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[GuildSharePageSource.SCHEDULE_DETAIL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[GuildSharePageSource.CHANNEL_DETAIL_SCHEDULE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[GuildSharePageSource.LIVE_CHANNEL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[GuildSharePageSource.LIVE_SUCCESS_QUICK_SHARE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[GuildSharePageSource.MEMBER_LIST.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[GuildSharePageSource.GUILD_PROFILE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[GuildSharePageSource.GUILD_QR_CODE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[GuildSharePageSource.AUDIO_TOP_INVITE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[GuildSharePageSource.AUDIO_MEMBER_INVITE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[GuildSharePageSource.GUILD_AUDIO_MEMBER_INVITE.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[GuildSharePageSource.UNKNOWN.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            f235103a = iArr;
        }
    }

    @NotNull
    public static final ShareServiceType a(@NotNull GuildSharePageSource guildSharePageSource) {
        Intrinsics.checkNotNullParameter(guildSharePageSource, "<this>");
        switch (a.f235103a[guildSharePageSource.ordinal()]) {
            case 1:
                return ShareServiceType.FEED;
            case 2:
            case 3:
                return ShareServiceType.SCHEDULE;
            case 4:
            case 5:
                return ShareServiceType.LIVE;
            case 6:
            case 7:
            case 8:
                return ShareServiceType.HOME;
            case 9:
            case 10:
            case 11:
                return ShareServiceType.AUDIO;
            case 12:
                Logger.f235387a.d().e("GuildSharePageSource", 1, "map unknown " + guildSharePageSource);
                return ShareServiceType.HOME;
            default:
                Logger.f235387a.d().e("GuildSharePageSource", 1, "can't map " + guildSharePageSource);
                return ShareServiceType.HOME;
        }
    }
}
