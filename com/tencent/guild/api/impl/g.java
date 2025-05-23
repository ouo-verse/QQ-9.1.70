package com.tencent.guild.api.impl;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.IGuildManageUtilApi;
import com.tencent.mobileqq.guild.guildtab.IGuildUserService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.ad;
import com.tencent.qqnt.kernel.api.t;
import kotlin.Metadata;
import kotlin.Unit;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00132\u00020\u00012\u00020\u0002:\u0001\nB\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0011\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0005J\b\u0010\u0007\u001a\u00020\u0003H\u0002J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u000b\u001a\u00020\u0003H\u0016J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fH\u0016R\u001e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\b8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u00168BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u001a8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/guild/api/impl/g;", "Lcom/tencent/qqnt/kernel/api/ad;", "Lcom/tencent/mobileqq/guild/guildtab/IGuildUserService$c;", "", "k", "()Lkotlin/Unit;", tl.h.F, "i", "Lmqq/app/AppRuntime;", "appRuntime", "a", "c", "", "isGuildUser", "b", "Lmqq/util/WeakReference;", "d", "Lmqq/util/WeakReference;", "weakApp", "e", "()Lmqq/app/AppRuntime;", "app", "Lcom/tencent/qqnt/kernel/api/t;", "g", "()Lcom/tencent/qqnt/kernel/api/t;", "msgService", "Lcom/tencent/mobileqq/guild/guildtab/IGuildUserService;", "f", "()Lcom/tencent/mobileqq/guild/guildtab/IGuildUserService;", "guildTabService", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class g implements ad, IGuildUserService.c {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<AppRuntime> weakApp;

    private final AppRuntime e() {
        WeakReference<AppRuntime> weakReference = this.weakApp;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private final IGuildUserService f() {
        AppRuntime e16 = e();
        if (e16 != null) {
            return (IGuildUserService) e16.getRuntimeService(IGuildUserService.class, "");
        }
        return null;
    }

    private final t g() {
        IKernelService iKernelService;
        AppRuntime e16 = e();
        if (e16 != null && (iKernelService = (IKernelService) e16.getRuntimeService(IKernelService.class, "")) != null) {
            return iKernelService.getGuildMsgService();
        }
        return null;
    }

    private final Unit h() {
        t g16 = g();
        if (g16 != null) {
            g16.setBuildMode(1);
            return Unit.INSTANCE;
        }
        return null;
    }

    private final void i() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.guild.api.impl.f
            @Override // java.lang.Runnable
            public final void run() {
                g.j();
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j() {
        ((IGuildManageUtilApi) QRoute.api(IGuildManageUtilApi.class)).setConfigForNT();
    }

    private final Unit k() {
        t g16 = g();
        if (g16 != null) {
            IGuildUserService f16 = f();
            int i3 = 1;
            boolean z16 = false;
            if (f16 != null && !f16.isGuildUser()) {
                z16 = true;
            }
            if (z16) {
                i3 = 2;
            }
            g16.setGuildTabUserFlag(i3);
            return Unit.INSTANCE;
        }
        return null;
    }

    @Override // com.tencent.qqnt.kernel.api.ad
    public void a(@Nullable AppRuntime appRuntime) {
        this.weakApp = new WeakReference<>(appRuntime);
        IGuildUserService f16 = f();
        if (f16 != null) {
            f16.addListener(this);
        }
        k();
        h();
        i();
    }

    @Override // com.tencent.mobileqq.guild.guildtab.IGuildUserService.c
    public void b(boolean isGuildUser) {
        k();
    }

    @Override // com.tencent.qqnt.kernel.api.ad
    public void c() {
        IGuildUserService f16 = f();
        if (f16 != null) {
            f16.removeListener(this);
        }
    }
}
