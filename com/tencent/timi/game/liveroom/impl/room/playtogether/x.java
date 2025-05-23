package com.tencent.timi.game.liveroom.impl.room.playtogether;

import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.timi.game.utils.IResultListener;
import hk4.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pf4.PlayTogetherSettingModel;
import trpc.yes.common.YoloTeamOuterClass$GuildLiveRoomJoinCondition;
import trpc.yes.common.YoloTeamOuterClass$YoloTeamEnterConditionRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u001a\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/playtogether/x;", "Lpf4/d;", "", "enterCondition", "Lpf4/g;", "settingModel", "Lpf4/c;", "l", "", "d", "c", "b", "Lpf4/a;", "a", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class x implements pf4.d {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/playtogether/x$a", "Lcom/tencent/timi/game/utils/IResultListener;", "Ltrpc/yes/common/YoloTeamOuterClass$YoloTeamEnterConditionRsp;", "result", "", "a", "", "errorCode", "", "errorMessage", "onError", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class a implements IResultListener<YoloTeamOuterClass$YoloTeamEnterConditionRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ pf4.c f378412a;

        a(pf4.c cVar) {
            this.f378412a = cVar;
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable YoloTeamOuterClass$YoloTeamEnterConditionRsp result) {
            pf4.c cVar = this.f378412a;
            if (cVar != null) {
                cVar.b();
            }
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int errorCode, @Nullable String errorMessage) {
            pf4.c cVar = this.f378412a;
            if (cVar != null) {
                cVar.a(errorCode, errorMessage);
            }
        }
    }

    private final void d(int enterCondition, PlayTogetherSettingModel settingModel, pf4.c l3) {
        Long longOrNull;
        long j3;
        Long longOrNull2;
        a.b bVar = new a.b();
        bVar.f405218c = settingModel.getGameId();
        bVar.f405221f = settingModel.getShowInfo().getGender();
        bVar.f405220e = settingModel.getShowInfo().getAvatarUrl();
        bVar.f405219d = settingModel.getShowInfo().getNickName();
        YoloTeamOuterClass$GuildLiveRoomJoinCondition yoloTeamOuterClass$GuildLiveRoomJoinCondition = new YoloTeamOuterClass$GuildLiveRoomJoinCondition();
        yoloTeamOuterClass$GuildLiveRoomJoinCondition.enter_condition.set(enterCondition);
        PBUInt64Field pBUInt64Field = yoloTeamOuterClass$GuildLiveRoomJoinCondition.guild_id;
        String str = settingModel.getGuildSettingModel().getGuildInfo().f412310a;
        Intrinsics.checkNotNullExpressionValue(str, "settingModel.guildSettingModel.guildInfo.guildId");
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(str);
        long j16 = 0;
        if (longOrNull != null) {
            j3 = longOrNull.longValue();
        } else {
            j3 = 0;
        }
        pBUInt64Field.set(j3);
        PBUInt64Field pBUInt64Field2 = yoloTeamOuterClass$GuildLiveRoomJoinCondition.channel_id;
        String str2 = settingModel.getGuildSettingModel().getGuildInfo().f412311b;
        Intrinsics.checkNotNullExpressionValue(str2, "settingModel.guildSettingModel.guildInfo.channelId");
        longOrNull2 = StringsKt__StringNumberConversionsKt.toLongOrNull(str2);
        if (longOrNull2 != null) {
            j16 = longOrNull2.longValue();
        }
        pBUInt64Field2.set(j16);
        bVar.f405217b = yoloTeamOuterClass$GuildLiveRoomJoinCondition;
        hk4.a.a(bVar, new a(l3));
    }

    @Override // pf4.d
    @NotNull
    public pf4.a a(@NotNull PlayTogetherSettingModel settingModel) {
        Intrinsics.checkNotNullParameter(settingModel, "settingModel");
        return new w(settingModel);
    }

    @Override // pf4.d
    public void b(@NotNull PlayTogetherSettingModel settingModel, @Nullable pf4.c l3) {
        Intrinsics.checkNotNullParameter(settingModel, "settingModel");
        d(5, settingModel, l3);
    }

    @Override // pf4.d
    public void c(@NotNull PlayTogetherSettingModel settingModel, @Nullable pf4.c l3) {
        Intrinsics.checkNotNullParameter(settingModel, "settingModel");
        d(4, settingModel, l3);
    }
}
