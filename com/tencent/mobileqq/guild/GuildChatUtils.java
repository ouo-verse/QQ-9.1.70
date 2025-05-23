package com.tencent.mobileqq.guild;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u000eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R=\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007`\b8FX\u0087\u0084\u0002\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR7\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007`\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\f\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/guild/GuildChatUtils;", "", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "a", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "b", "Lkotlin/Lazy;", "getGuildAvatarBottomIconInfoMap", "()Ljava/util/HashMap;", "getGuildAvatarBottomIconInfoMap$annotations", "()V", "guildAvatarBottomIconInfoMap", "c", "getGuildSummaryActivityIconMap", "guildSummaryActivityIconMap", "<init>", "qqchat_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class GuildChatUtils {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final GuildChatUtils f213838a = new GuildChatUtils();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy guildAvatarBottomIconInfoMap;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy guildSummaryActivityIconMap;

    static {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<HashMap<Integer, Integer>>() { // from class: com.tencent.mobileqq.guild.GuildChatUtils$guildAvatarBottomIconInfoMap$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final HashMap<Integer, Integer> invoke() {
                HashMap<Integer, Integer> hashMap = new HashMap<>();
                hashMap.put(1, Integer.valueOf(R.drawable.guild_join_video_blue));
                hashMap.put(4, Integer.valueOf(R.drawable.guild_join_voice_blue));
                hashMap.put(6, Integer.valueOf(R.drawable.guild_join_scrren_share_blue));
                Integer valueOf = Integer.valueOf(R.drawable.guild_channel_guild_entrance_state_icon_join_voice_game_blue);
                hashMap.put(9, valueOf);
                hashMap.put(18, valueOf);
                hashMap.put(17, Integer.valueOf(R.drawable.guild_channel_guild_entrance_state_icon_join_voice_music_blue));
                return hashMap;
            }
        });
        guildAvatarBottomIconInfoMap = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<HashMap<Integer, Integer>>() { // from class: com.tencent.mobileqq.guild.GuildChatUtils$guildSummaryActivityIconMap$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final HashMap<Integer, Integer> invoke() {
                HashMap<Integer, Integer> hashMap = new HashMap<>();
                hashMap.put(1, Integer.valueOf(R.drawable.guild_channel_state_live));
                hashMap.put(6, Integer.valueOf(R.drawable.guild_channel_state_screen_share));
                Integer valueOf = Integer.valueOf(R.drawable.guild_channel_state_game);
                hashMap.put(9, valueOf);
                hashMap.put(18, valueOf);
                hashMap.put(17, Integer.valueOf(R.drawable.guild_channel_state_music));
                hashMap.put(10000, Integer.valueOf(R.drawable.guild_channel_state_active));
                hashMap.put(10001, Integer.valueOf(R.drawable.guild_feed_square_icon));
                return hashMap;
            }
        });
        guildSummaryActivityIconMap = lazy2;
    }

    GuildChatUtils() {
    }

    public final boolean a(@NotNull com.tencent.qqnt.chats.core.adapter.itemdata.g item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item.q().getBoolean("is_local_cache_data", false);
    }
}
