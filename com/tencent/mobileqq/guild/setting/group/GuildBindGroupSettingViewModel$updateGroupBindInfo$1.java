package com.tencent.mobileqq.guild.setting.group;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.guild.setting.group.GuildBindGroupSettingViewModel", f = "GuildBindGroupSettingViewModel.kt", i = {0, 0}, l = {382}, m = "updateGroupBindInfo", n = {"this", "troopUin"}, s = {"L$0", "J$0"})
/* loaded from: classes14.dex */
public final class GuildBindGroupSettingViewModel$updateGroupBindInfo$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GuildBindGroupSettingViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildBindGroupSettingViewModel$updateGroupBindInfo$1(GuildBindGroupSettingViewModel guildBindGroupSettingViewModel, Continuation<? super GuildBindGroupSettingViewModel$updateGroupBindInfo$1> continuation) {
        super(continuation);
        this.this$0 = guildBindGroupSettingViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object y26;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        y26 = this.this$0.y2(0L, this);
        return y26;
    }
}
