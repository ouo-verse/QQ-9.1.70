package com.tencent.mobileqq.guild.share.util;

import com.tencent.mobileqq.guild.data.GuildSharePageSource;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\n\u0010\u0004\u001a\u00020\u0003*\u00020\u0002J\u0016\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003R \u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\nR \u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR,\u0010\u000f\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\t0\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\n\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/share/util/e;", "", "Lcom/tencent/mobileqq/guild/data/GuildSharePageSource;", "", "a", "channelOrActionId", "scene", "", "b", "", "Ljava/util/Map;", "robotActionAndChannelIdToActionMap", "c", "normalGuildActionAndChannelIdToActionMap", "d", "sceneShareActionIdConvertMap", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f235124a = new e();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<String, Integer> robotActionAndChannelIdToActionMap;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<String, Integer> normalGuildActionAndChannelIdToActionMap;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<String, Map<String, Integer>> sceneShareActionIdConvertMap;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f235128a;

        static {
            int[] iArr = new int[GuildSharePageSource.values().length];
            try {
                iArr[GuildSharePageSource.GUILD_PROFILE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[GuildSharePageSource.MEMBER_LIST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[GuildSharePageSource.AUDIO_TOP_INVITE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[GuildSharePageSource.LIVE_CHANNEL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[GuildSharePageSource.CHANNEL_DETAIL_SCHEDULE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[GuildSharePageSource.SCHEDULE_DETAIL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[GuildSharePageSource.GUILD_QR_CODE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            f235128a = iArr;
        }
    }

    static {
        Map<String, Integer> mapOf;
        Map<String, Integer> mapOf2;
        Map<String, Map<String, Integer>> mapOf3;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("qqfriend", 2), TuplesKt.to("qqchannel", 171), TuplesKt.to("weixin", 9), TuplesKt.to("weixincircle", 10), TuplesKt.to("qzoneshuoshuo", 3), TuplesKt.to(WinkDaTongReportConstant.ElementParamValue.XSJ_SHARE_COPY_LINK, 1), TuplesKt.to("generate_qr_code", 23));
        robotActionAndChannelIdToActionMap = mapOf;
        mapOf2 = MapsKt__MapsKt.mapOf(TuplesKt.to("qqfriend", 2), TuplesKt.to("qqchannel", 171), TuplesKt.to("weixin", 9), TuplesKt.to("weixincircle", 10), TuplesKt.to("qzoneshuoshuo", 3), TuplesKt.to(WinkDaTongReportConstant.ElementParamValue.XSJ_SHARE_COPY_LINK, 1), TuplesKt.to("uppin_homepage", 243), TuplesKt.to("pin_to_homepage", 242), TuplesKt.to("delete", 40), TuplesKt.to("generate_qr_code", 196), TuplesKt.to("copy_channel_number", 213));
        normalGuildActionAndChannelIdToActionMap = mapOf2;
        mapOf3 = MapsKt__MapsKt.mapOf(TuplesKt.to("scene_robot", mapOf), TuplesKt.to("scene_normal_guild", mapOf2));
        sceneShareActionIdConvertMap = mapOf3;
    }

    e() {
    }

    @NotNull
    public final String a(@NotNull GuildSharePageSource guildSharePageSource) {
        Intrinsics.checkNotNullParameter(guildSharePageSource, "<this>");
        switch (a.f235128a[guildSharePageSource.ordinal()]) {
            case 1:
            case 2:
                return "pindao_homepage";
            case 3:
                return "pindao_vedio";
            case 4:
                return "pindao_live";
            case 5:
            case 6:
                return "pindao_schedule";
            case 7:
                return "pindao_qrcode";
            default:
                return "pindao_card";
        }
    }

    public final int b(@NotNull String channelOrActionId, @NotNull String scene) {
        Integer num;
        Intrinsics.checkNotNullParameter(channelOrActionId, "channelOrActionId");
        Intrinsics.checkNotNullParameter(scene, "scene");
        Map<String, Integer> map = sceneShareActionIdConvertMap.get(scene);
        if (map != null && (num = map.get(channelOrActionId)) != null) {
            return num.intValue();
        }
        return 0;
    }
}
