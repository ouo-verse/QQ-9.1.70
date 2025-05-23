package com.tencent.mobileqq.guild.guildtab;

import android.os.Looper;
import com.tencent.mobileqq.app.ThreadManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
final class GuildTabRedLogic$mGuildTabUnreadCallback$1 extends Lambda implements Function0<Unit> {
    public static final GuildTabRedLogic$mGuildTabUnreadCallback$1 INSTANCE = new GuildTabRedLogic$mGuildTabUnreadCallback$1();

    GuildTabRedLogic$mGuildTabUnreadCallback$1() {
        super(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c() {
        GuildTabRedLogic.f224628d.j();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            GuildTabRedLogic.f224628d.j();
        } else {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.guild.guildtab.b
                @Override // java.lang.Runnable
                public final void run() {
                    GuildTabRedLogic$mGuildTabUnreadCallback$1.c();
                }
            });
        }
    }
}
