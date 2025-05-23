package com.tencent.mobileqq.guild.util;

import com.tencent.mobileqq.R;
import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000bR<\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u00058\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/util/aw;", "", "Ljava/util/HashMap;", "", "Lcom/tencent/mobileqq/guild/config/r;", "Lkotlin/collections/HashMap;", "b", "Ljava/util/HashMap;", "a", "()Ljava/util/HashMap;", "getGuildAvatarIconInfoMap$annotations", "()V", "guildAvatarIconInfoMap", "<init>", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class aw {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final aw f235452a = new aw();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<Integer, com.tencent.mobileqq.guild.config.r> guildAvatarIconInfoMap;

    static {
        HashMap<Integer, com.tencent.mobileqq.guild.config.r> hashMap = new HashMap<>();
        guildAvatarIconInfoMap = hashMap;
        com.tencent.mobileqq.guild.config.r rVar = new com.tencent.mobileqq.guild.config.r(1, 1, R.drawable.guild_join_video);
        com.tencent.mobileqq.guild.config.r rVar2 = new com.tencent.mobileqq.guild.config.r(13, 10, R.drawable.guild_channel_guild_entrance_state_icon_join_voice_game);
        com.tencent.mobileqq.guild.config.r rVar3 = new com.tencent.mobileqq.guild.config.r(7, 11, R.drawable.guild_join_scrren_share);
        com.tencent.mobileqq.guild.config.r rVar4 = new com.tencent.mobileqq.guild.config.r(9, 12, R.drawable.guild_channel_guild_entrance_state_icon_join_world);
        com.tencent.mobileqq.guild.config.r rVar5 = new com.tencent.mobileqq.guild.config.r(11, 50, R.drawable.guild_channel_guild_entrance_state_icon_join_voice_game);
        com.tencent.mobileqq.guild.config.r rVar6 = new com.tencent.mobileqq.guild.config.r(16, 51, R.drawable.guild_channel_guild_entrance_state_icon_join_voice_music);
        com.tencent.mobileqq.guild.config.r rVar7 = new com.tencent.mobileqq.guild.config.r(2, 52, R.drawable.guild_join_voice);
        com.tencent.mobileqq.guild.config.r rVar8 = new com.tencent.mobileqq.guild.config.r(3, 100, R.drawable.guild_has_video);
        com.tencent.mobileqq.guild.config.r rVar9 = new com.tencent.mobileqq.guild.config.r(14, 110, R.drawable.guild_channel_guild_entrance_state_icon_voice_game);
        com.tencent.mobileqq.guild.config.r rVar10 = new com.tencent.mobileqq.guild.config.r(8, 111, R.drawable.guild_has_scrren_share);
        com.tencent.mobileqq.guild.config.r rVar11 = new com.tencent.mobileqq.guild.config.r(10, 112, R.drawable.guild_channel_guild_entrance_state_icon_world);
        com.tencent.mobileqq.guild.config.r rVar12 = new com.tencent.mobileqq.guild.config.r(12, 151, R.drawable.guild_channel_guild_entrance_state_icon_voice_game);
        com.tencent.mobileqq.guild.config.r rVar13 = new com.tencent.mobileqq.guild.config.r(15, 152, R.drawable.guild_channel_guild_entrance_state_icon_voice_music);
        com.tencent.mobileqq.guild.config.r rVar14 = new com.tencent.mobileqq.guild.config.r(6, 153, R.drawable.guild_has_voice);
        hashMap.put(1, rVar);
        hashMap.put(2, rVar7);
        hashMap.put(3, rVar8);
        hashMap.put(6, rVar14);
        hashMap.put(7, rVar3);
        hashMap.put(8, rVar10);
        hashMap.put(9, rVar4);
        hashMap.put(10, rVar11);
        hashMap.put(11, rVar5);
        hashMap.put(12, rVar12);
        hashMap.put(13, rVar2);
        hashMap.put(14, rVar9);
        hashMap.put(16, rVar6);
        hashMap.put(15, rVar13);
    }

    aw() {
    }

    @NotNull
    public static final HashMap<Integer, com.tencent.mobileqq.guild.config.r> a() {
        return guildAvatarIconInfoMap;
    }
}
