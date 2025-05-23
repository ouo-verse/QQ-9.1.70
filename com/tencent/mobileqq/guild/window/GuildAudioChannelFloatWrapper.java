package com.tencent.mobileqq.guild.window;

import android.content.Context;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \n2\u00020\u0001:\u0001\u000bB\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/window/GuildAudioChannelFloatWrapper;", "Lcom/tencent/mobileqq/guild/window/a;", "Lcom/tencent/mobileqq/guild/window/usecase/g;", "O0", "", "Q0", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Companion", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class GuildAudioChannelFloatWrapper extends a {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/window/GuildAudioChannelFloatWrapper$a;", "", "Landroid/view/View;", "a", "", "b", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.window.GuildAudioChannelFloatWrapper$a, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final View a() {
            return a.INSTANCE.a();
        }

        public final void b() {
            GuildFloatWindowManager guildFloatWindowManager = GuildFloatWindowManager.f236656d;
            String name = GuildAudioChannelFloatWrapper.class.getName();
            Intrinsics.checkNotNullExpressionValue(name, "GuildAudioChannelFloatWrapper::class.java.name");
            guildFloatWindowManager.g(name);
        }

        Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildAudioChannelFloatWrapper(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        J0("GuildAudioChannelFloatWrapper");
        I0(true);
        H0(false);
    }

    @Override // com.tencent.mobileqq.guild.window.a
    @NotNull
    public com.tencent.mobileqq.guild.window.usecase.g O0() {
        return new com.tencent.mobileqq.guild.window.usecase.e(t0(), r0(), this);
    }

    @Override // com.tencent.mobileqq.guild.window.a
    public void Q0() {
        INSTANCE.b();
    }
}
