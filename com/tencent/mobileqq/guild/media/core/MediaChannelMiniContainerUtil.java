package com.tencent.mobileqq.guild.media.core;

import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.webview.swift.injector.aa;
import com.tencent.mobileqq.webview.util.t;
import com.tencent.smtt.sdk.QbSdk;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\u0007\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0007R\u0016\u0010\t\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/MediaChannelMiniContainerUtil;", "", "", "a", "Lkotlin/Function0;", "", "realInitBlock", "b", "Z", "hasCheckX5", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class MediaChannelMiniContainerUtil {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final MediaChannelMiniContainerUtil f228044a = new MediaChannelMiniContainerUtil();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static volatile boolean hasCheckX5;

    MediaChannelMiniContainerUtil() {
    }

    private final boolean a() {
        boolean z16;
        int tbsVersionForCrash = QbSdk.getTbsVersionForCrash(MobileQQ.sMobileQQ.getApplicationContext());
        if (1 <= tbsVersionForCrash && tbsVersionForCrash < 46522) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 || !((com.tencent.mobileqq.webview.swift.injector.c) aa.k(com.tencent.mobileqq.webview.swift.injector.c.class)).isSwitchOn("wv_x5core_46521_fallback_syscore", true)) {
            return true;
        }
        Logger.f235387a.d().d("MediaChannelMiniContainerUtil", 1, "[canUseX5Core] oInit tbsCoreVer: " + tbsVersionForCrash + " should fallback sysCore");
        return false;
    }

    @JvmStatic
    public static final void b(@NotNull final Function0<Unit> realInitBlock) {
        Intrinsics.checkNotNullParameter(realInitBlock, "realInitBlock");
        if (hasCheckX5) {
            realInitBlock.invoke();
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        hasCheckX5 = true;
        final boolean a16 = f228044a.a();
        final int tbsVersionForCrash = QbSdk.getTbsVersionForCrash(MobileQQ.sMobileQQ.getApplicationContext());
        com.tencent.mobileqq.webview.swift.utils.p.a(new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.media.core.MediaChannelMiniContainerUtil$initX5With$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                if (!a16) {
                    QbSdk.forceSysWebView();
                    com.tencent.mobileqq.webview.util.t.INSTANCE.a().d("guild_media_force_syscore_flag", Boolean.TRUE);
                } else {
                    t.Companion companion = com.tencent.mobileqq.webview.util.t.INSTANCE;
                    if (((Boolean) companion.a().b("guild_media_force_syscore_flag", Boolean.FALSE)).booleanValue()) {
                        QbSdk.unForceSysWebView();
                        companion.a().l("guild_media_force_syscore_flag");
                        Logger logger = Logger.f235387a;
                        int i3 = tbsVersionForCrash;
                        logger.d().d("MediaChannelMiniContainerUtil", 1, "[initX5With] doInit tbsCoreVer: " + i3 + " should restore x5Core");
                    }
                }
                Logger logger2 = Logger.f235387a;
                long j3 = currentTimeMillis;
                logger2.d().d("MediaChannelMiniContainerUtil", 1, "[initX5With] cose=" + (System.currentTimeMillis() - j3));
                realInitBlock.invoke();
            }
        });
    }
}
