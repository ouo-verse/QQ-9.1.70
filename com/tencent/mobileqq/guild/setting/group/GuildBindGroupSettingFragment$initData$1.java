package com.tencent.mobileqq.guild.setting.group;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public /* synthetic */ class GuildBindGroupSettingFragment$initData$1 extends FunctionReferenceImpl implements Function1<GroupChatData, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public GuildBindGroupSettingFragment$initData$1(Object obj) {
        super(1, obj, GuildBindGroupSettingFragment.class, "updateGroupBindState", "updateGroupBindState(Lcom/tencent/mobileqq/guild/setting/group/GroupChatData;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GroupChatData groupChatData) {
        invoke2(groupChatData);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull GroupChatData p06) {
        Intrinsics.checkNotNullParameter(p06, "p0");
        ((GuildBindGroupSettingFragment) this.receiver).Wh(p06);
    }
}
