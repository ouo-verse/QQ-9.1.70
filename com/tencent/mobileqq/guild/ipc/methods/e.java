package com.tencent.mobileqq.guild.ipc.methods;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.guild.ipc.methods.AbsIpcMethod;
import com.tencent.mobileqq.guild.usecases.FetchGuildInfoUseCase;
import eipc.EIPCResult;

/* compiled from: P */
/* loaded from: classes13.dex */
public class e extends AbsIpcMethod {

    /* compiled from: P */
    /* loaded from: classes13.dex */
    class a implements FetchGuildInfoUseCase.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AbsIpcMethod.a f226339a;

        a(AbsIpcMethod.a aVar) {
            this.f226339a = aVar;
        }

        @Override // com.tencent.mobileqq.guild.usecases.FetchGuildInfoUseCase.a
        public void a(@NonNull ri1.a aVar, @NonNull FetchGuildInfoUseCase.GuildInfo guildInfo) {
            Bundle K = aq1.h.K(aVar.f431477a, aVar.f431478b, aVar.f431479c);
            K.putParcelable("data", guildInfo);
            this.f226339a.b(K);
        }
    }

    @Override // com.tencent.mobileqq.guild.ipc.methods.AbsIpcMethod
    public EIPCResult a(AbsIpcMethod.a aVar, String str, Object... objArr) {
        FetchGuildInfoUseCase.c((String) objArr[0], new a(aVar));
        return null;
    }
}
