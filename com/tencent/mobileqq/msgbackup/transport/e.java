package com.tencent.mobileqq.msgbackup.transport;

import com.tencent.mobileqq.msgbackup.data.h;
import com.tencent.mobileqq.msgbackup.util.f;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a:\u0010\n\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0000\u001a\f\u0010\u000b\u001a\u00020\b*\u00020\u0000H\u0002\u00a8\u0006\f"}, d2 = {"", "chatUin", "", "chatType", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mobileqq/msgbackup/data/h;", "clientCanRecvMList", "Lkotlin/Function0;", "", "invoke", "a", "b", "msgbackup_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class e {
    public static final void a(@NotNull String chatUin, int i3, @NotNull ConcurrentHashMap<String, h> clientCanRecvMList, @NotNull Function0<Unit> invoke) {
        Intrinsics.checkNotNullParameter(chatUin, "chatUin");
        Intrinsics.checkNotNullParameter(clientCanRecvMList, "clientCanRecvMList");
        Intrinsics.checkNotNullParameter(invoke, "invoke");
        if (clientCanRecvMList.containsKey(f.t(chatUin, i3))) {
            b("repeat sessionInfo [" + chatUin + ", " + i3 + "] ignore");
            return;
        }
        invoke.invoke();
    }

    private static final void b(String str) {
        QLog.d("MsgBackup_TransportProcessorKt", 1, str);
    }
}
