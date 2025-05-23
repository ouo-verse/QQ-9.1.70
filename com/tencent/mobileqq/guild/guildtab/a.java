package com.tencent.mobileqq.guild.guildtab;

import com.tencent.mobileqq.guild.guildtab.impl.GuildUserServiceImpl;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.qqnt.kernel.nativeinterface.FirstViewGroupGuildInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupGuildNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.GuildMsgAbFlag;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.msg.api.b;
import com.tencent.qqnt.msg.data.h;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\n\u001a\u00020\u00078BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/guildtab/a;", "Lcom/tencent/qqnt/msg/api/b;", "", "flag", "", "onRecvUDCFlag", "onRecvGroupGuildFlag", "Lcom/tencent/mobileqq/guild/guildtab/impl/GuildUserServiceImpl;", "c", "()Lcom/tencent/mobileqq/guild/guildtab/impl/GuildUserServiceImpl;", "guildUserServiceImpl", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a implements com.tencent.qqnt.msg.api.b {
    private final GuildUserServiceImpl c() {
        AppRuntime m3 = ch.m();
        Intrinsics.checkNotNullExpressionValue(m3, "appRuntime()");
        IRuntimeService runtimeService = m3.getRuntimeService(IGuildUserService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "runtimeService");
        Intrinsics.checkNotNull(runtimeService, "null cannot be cast to non-null type com.tencent.mobileqq.guild.guildtab.impl.GuildUserServiceImpl");
        return (GuildUserServiceImpl) runtimeService;
    }

    @Override // com.tencent.qqnt.msg.api.b
    public void a(@NotNull h hVar) {
        b.a.h(this, hVar);
    }

    @Override // com.tencent.qqnt.msg.api.b
    public void b(@NotNull byte[] bArr) {
        b.a.g(this, bArr);
    }

    @Override // com.tencent.qqnt.msg.api.b
    public void onFirstViewGroupGuildMapping(@NotNull ArrayList<FirstViewGroupGuildInfo> arrayList) {
        b.a.a(this, arrayList);
    }

    @Override // com.tencent.qqnt.msg.api.b
    public void onGroupGuildUpdate(@NotNull GroupGuildNotifyInfo groupGuildNotifyInfo) {
        b.a.b(this, groupGuildNotifyInfo);
    }

    @Override // com.tencent.qqnt.msg.api.b
    public void onGuildMsgAbFlagChanged(@NotNull GuildMsgAbFlag guildMsgAbFlag) {
        b.a.c(this, guildMsgAbFlag);
    }

    @Override // com.tencent.qqnt.msg.api.b
    public void onRecvGroupGuildFlag(int flag) {
        c().setGroupGuildFlag(flag);
    }

    @Override // com.tencent.qqnt.msg.api.b
    public void onRecvMsg(@NotNull ArrayList<MsgRecord> arrayList) {
        b.a.e(this, arrayList);
    }

    @Override // com.tencent.qqnt.msg.api.b
    public void onRecvUDCFlag(int flag) {
        c().setGuildUDCFlag(flag);
    }
}
