package com.tencent.mobileqq.guild.feed.nativepublish.edittext;

import androidx.core.util.Supplier;
import com.tencent.mobileqq.guild.feed.nativepublish.edittext.specialchar.HashtagCharTextWatcherPlugin;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n\u00a2\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/specialchar/g;", "invoke", "()Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/specialchar/g;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedEditTextVM$hashtagGuildJumpPlugin$2 extends Lambda implements Function0<com.tencent.mobileqq.guild.feed.nativepublish.edittext.specialchar.g> {
    final /* synthetic */ GuildFeedEditTextVM this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildFeedEditTextVM$hashtagGuildJumpPlugin$2(GuildFeedEditTextVM guildFeedEditTextVM) {
        super(0);
        this.this$0 = guildFeedEditTextVM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HashtagCharTextWatcherPlugin b(GuildFeedEditTextVM this$0) {
        HashtagCharTextWatcherPlugin q16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        q16 = this$0.q();
        return q16;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final com.tencent.mobileqq.guild.feed.nativepublish.edittext.specialchar.g invoke() {
        com.tencent.mobileqq.guild.feed.nativepublish.edittext.specialchar.g gVar = new com.tencent.mobileqq.guild.feed.nativepublish.edittext.specialchar.g();
        final GuildFeedEditTextVM guildFeedEditTextVM = this.this$0;
        gVar.k(new Supplier() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.edittext.g
            @Override // androidx.core.util.Supplier
            public final Object get() {
                HashtagCharTextWatcherPlugin b16;
                b16 = GuildFeedEditTextVM$hashtagGuildJumpPlugin$2.b(GuildFeedEditTextVM.this);
                return b16;
            }
        });
        return gVar;
    }
}
