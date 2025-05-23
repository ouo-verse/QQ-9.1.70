package com.tencent.guild.aio.factory.business.holder.msglist;

import com.tencent.qqnt.kernel.nativeinterface.FileTransNotifyInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.AdaptedFunctionReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public /* synthetic */ class GuildMsgListDataVM$registerMsgNotification$3 extends AdaptedFunctionReference implements Function2<FileTransNotifyInfo, Continuation<? super Unit>, Object>, SuspendFunction {
    /* JADX INFO: Access modifiers changed from: package-private */
    public GuildMsgListDataVM$registerMsgNotification$3(Object obj) {
        super(2, obj, GuildMsgListDataVM.class, "onRichMediaDownloadProgressUpdate", "onRichMediaDownloadProgressUpdate(Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;)V", 4);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull FileTransNotifyInfo fileTransNotifyInfo, @NotNull Continuation<? super Unit> continuation) {
        Object S0;
        S0 = GuildMsgListDataVM.S0((GuildMsgListDataVM) this.receiver, fileTransNotifyInfo, continuation);
        return S0;
    }
}
