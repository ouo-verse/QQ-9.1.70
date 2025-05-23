package com.tencent.mobileqq.guild.util;

import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aV\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022>\b\u0002\u0010\n\u001a8\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0015\u0012\u0013\u0018\u00010\u0000\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004\u001ae\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022>\b\u0002\u0010\n\u001a8\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0015\u0012\u0013\u0018\u00010\u0000\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\r\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000f"}, d2 = {"", "guildId", "", "readScene", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "result", "msg", "", "cb", "b", "Luh2/c;", "a", "(Ljava/lang/String;ILkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildNoticeKtKt {
    @Nullable
    public static final Object a(@NotNull String str, int i3, @Nullable Function2<? super Integer, ? super String, Unit> function2, @NotNull Continuation<? super uh2.c> continuation) {
        return CoroutineScopeKt.coroutineScope(new GuildNoticeKtKt$clearGuildReadScene$2(str, i3, function2, null), continuation);
    }

    public static final void b(@NotNull String guildId, int i3, @Nullable Function2<? super Integer, ? super String, Unit> function2) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        QLog.d("GuildNoticeKt", 1, "[markRead] guildId=" + guildId + ", readScene=" + i3);
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.e.f261783e);
        Intrinsics.checkNotNull(f16);
        CorountineFunKt.e(f16, "markRead", null, null, Boolean.TRUE, new GuildNoticeKtKt$markRead$1(guildId, i3, function2, null), 6, null);
    }

    public static /* synthetic */ void c(String str, int i3, Function2 function2, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            function2 = null;
        }
        b(str, i3, function2);
    }
}
