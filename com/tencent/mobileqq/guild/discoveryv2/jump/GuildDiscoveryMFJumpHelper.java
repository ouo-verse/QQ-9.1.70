package com.tencent.mobileqq.guild.discoveryv2.jump;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.guild.mainframe.GuildMainFrameConstants;
import com.tencent.mobileqq.guild.util.Logger;
import hi1.a;
import hi1.b;
import hi1.c;
import hi1.d;
import hi1.e;
import hi1.f;
import hi1.g;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007R'\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/jump/GuildDiscoveryMFJumpHelper;", "", "Landroid/content/Context;", "context", "Landroid/os/Bundle;", "jumpExtra", "", "b", "", "", "Lhi1/g;", "Lkotlin/Lazy;", "a", "()Ljava/util/Map;", "jumperMap", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildDiscoveryMFJumpHelper {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final GuildDiscoveryMFJumpHelper f217504a = new GuildDiscoveryMFJumpHelper();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy jumperMap;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Map<Integer, ? extends g>>() { // from class: com.tencent.mobileqq.guild.discoveryv2.jump.GuildDiscoveryMFJumpHelper$jumperMap$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Map<Integer, ? extends g> invoke() {
                Map<Integer, ? extends g> mapOf;
                mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(Integer.valueOf(GuildMainFrameConstants.D), new d()), TuplesKt.to(Integer.valueOf(GuildMainFrameConstants.C), new b()), TuplesKt.to(Integer.valueOf(GuildMainFrameConstants.F), new e()), TuplesKt.to(Integer.valueOf(GuildMainFrameConstants.f227277u), new a()), TuplesKt.to(Integer.valueOf(GuildMainFrameConstants.f227282z), new c()), TuplesKt.to(Integer.valueOf(GuildMainFrameConstants.f227278v), new f()));
                return mapOf;
            }
        });
        jumperMap = lazy;
    }

    GuildDiscoveryMFJumpHelper() {
    }

    private final Map<Integer, g> a() {
        return (Map) jumperMap.getValue();
    }

    @JvmStatic
    public static final void b(@NotNull Context context, @Nullable Bundle jumpExtra) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (jumpExtra == null) {
            return;
        }
        int i3 = jumpExtra.getInt("goto_guildtab_actiontype", 0);
        Bundle bundle = jumpExtra.getBundle("goto_guildtab_actionextra");
        if (bundle == null) {
            return;
        }
        g gVar = f217504a.a().get(Integer.valueOf(i3));
        if (gVar != null) {
            gVar.a(context, bundle);
            return;
        }
        Logger.f235387a.d().w("GuildDiscoveryMFJumpHelper", 1, "handleJumpAction jumpExtra:" + jumpExtra);
    }
}
