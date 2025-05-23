package com.tencent.mobileqq.guild.gift.module;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import lo1.GuildGiftConfig;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0015\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\u001a\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00012\b\b\u0002\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/guild/gift/module/a;", "", "Lnh2/c;", "sdk", "Llo1/b;", DownloadInfo.spKey_Config, "Lmo1/b;", "eventBus", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "j", "event", "", "mainThread", "o", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "d", "Lnh2/c;", "l", "()Lnh2/c;", "setSdk", "(Lnh2/c;)V", "e", "Llo1/b;", "k", "()Llo1/b;", "setConfig", "(Llo1/b;)V", "f", "Lmo1/b;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public abstract class a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private nh2.c sdk;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GuildGiftConfig config;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private mo1.b eventBus;

    public static /* synthetic */ void p(a aVar, Object obj, boolean z16, int i3, Object obj2) {
        if (obj2 == null) {
            if ((i3 & 2) != 0) {
                z16 = true;
            }
            aVar.o(obj, z16);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendEvent");
    }

    public void j() {
        mo1.b bVar = this.eventBus;
        Intrinsics.checkNotNull(bVar);
        q(bVar);
        this.sdk = null;
        this.config = null;
        this.eventBus = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: k, reason: from getter */
    public final GuildGiftConfig getConfig() {
        return this.config;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: l, reason: from getter */
    public final nh2.c getSdk() {
        return this.sdk;
    }

    public void m(@NotNull nh2.c sdk, @NotNull GuildGiftConfig config, @NotNull mo1.b eventBus) {
        Intrinsics.checkNotNullParameter(sdk, "sdk");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(eventBus, "eventBus");
        this.sdk = sdk;
        this.config = config;
        this.eventBus = eventBus;
        n(eventBus);
    }

    public void n(@NotNull mo1.b eventBus) {
        Intrinsics.checkNotNullParameter(eventBus, "eventBus");
    }

    public void o(@NotNull Object event, boolean mainThread) {
        Intrinsics.checkNotNullParameter(event, "event");
        mo1.b bVar = this.eventBus;
        if (bVar != null) {
            bVar.c(event, mainThread);
        }
    }

    public void q(@NotNull mo1.b eventBus) {
        Intrinsics.checkNotNullParameter(eventBus, "eventBus");
    }
}
