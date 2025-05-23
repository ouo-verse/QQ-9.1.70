package com.tencent.mobileqq.guild.feed.batchmanage;

import android.os.Bundle;
import com.tencent.mobileqq.guild.data.GuildSimpleContact;
import com.tencent.mobileqq.guild.data.IGuildParcelizeSimpleContact;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.feed.util.ax;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u001b\u0010\u0006\u001a\u00020\u00028VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u0016\u0010\n\u001a\u0004\u0018\u00010\u00078VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\t\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/guild/feed/batchmanage/GuildFeedBatchManageFragment$fragmentArgsIoc$1", "Lvi1/b;", "Lcom/tencent/mobileqq/guild/data/IGuildParcelizeSimpleContact;", "a", "Lkotlin/Lazy;", "()Lcom/tencent/mobileqq/guild/data/IGuildParcelizeSimpleContact;", "contact", "Landroid/os/Bundle;", "getArguments", "()Landroid/os/Bundle;", "arguments", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedBatchManageFragment$fragmentArgsIoc$1 implements vi1.b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy contact;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ GuildFeedBatchManageFragment f218144b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GuildFeedBatchManageFragment$fragmentArgsIoc$1(final GuildFeedBatchManageFragment guildFeedBatchManageFragment) {
        Lazy lazy;
        this.f218144b = guildFeedBatchManageFragment;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<GuildSimpleContact>() { // from class: com.tencent.mobileqq.guild.feed.batchmanage.GuildFeedBatchManageFragment$fragmentArgsIoc$1$contact$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildSimpleContact invoke() {
                GuildFeedBaseInitBean o16 = ax.o(GuildFeedBatchManageFragment.this);
                if (o16 == null) {
                    return GuildSimpleContact.INSTANCE.a();
                }
                String guildId = o16.getGuildId();
                Intrinsics.checkNotNullExpressionValue(guildId, "bean.guildId");
                String channelId = o16.getChannelId();
                Intrinsics.checkNotNullExpressionValue(channelId, "bean.channelId");
                return new GuildSimpleContact(guildId, channelId);
            }
        });
        this.contact = lazy;
    }

    @Override // vi1.b
    @NotNull
    /* renamed from: a */
    public IGuildParcelizeSimpleContact getContact() {
        return (IGuildParcelizeSimpleContact) this.contact.getValue();
    }

    @Override // vi1.b
    @Nullable
    public Bundle getArguments() {
        return this.f218144b.getArguments();
    }
}
