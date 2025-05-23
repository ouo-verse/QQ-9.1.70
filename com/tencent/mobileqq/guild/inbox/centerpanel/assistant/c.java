package com.tencent.mobileqq.guild.inbox.centerpanel.assistant;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001Bw\u00126\u0010\r\u001a2\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0002\u00126\u0010\u000f\u001a2\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\b0\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011RG\u0010\r\u001a2\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fRG\u0010\u000f\u001a2\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\b0\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\t\u0010\f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/inbox/centerpanel/assistant/c;", "", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "guildId", "url", "", "a", "Lkotlin/jvm/functions/Function2;", "b", "()Lkotlin/jvm/functions/Function2;", "urlJumpCallback", "joinSign", "guildJumpCallback", "<init>", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function2<String, String, Unit> urlJumpCallback;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function2<String, String, Unit> guildJumpCallback;

    /* JADX WARN: Multi-variable type inference failed */
    public c(@NotNull Function2<? super String, ? super String, Unit> urlJumpCallback, @NotNull Function2<? super String, ? super String, Unit> guildJumpCallback) {
        Intrinsics.checkNotNullParameter(urlJumpCallback, "urlJumpCallback");
        Intrinsics.checkNotNullParameter(guildJumpCallback, "guildJumpCallback");
        this.urlJumpCallback = urlJumpCallback;
        this.guildJumpCallback = guildJumpCallback;
    }

    @NotNull
    public final Function2<String, String, Unit> a() {
        return this.guildJumpCallback;
    }

    @NotNull
    public final Function2<String, String, Unit> b() {
        return this.urlJumpCallback;
    }
}
