package com.tencent.mobileqq.guild.setting.guildsetting.fragment;

import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.util.UiThreadUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "isSuccess", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final class GuildModifyMemberNameAndAvatarFragment$sendClearGuildAvatarRequest$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ GuildModifyMemberNameAndAvatarFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildModifyMemberNameAndAvatarFragment$sendClearGuildAvatarRequest$1(GuildModifyMemberNameAndAvatarFragment guildModifyMemberNameAndAvatarFragment) {
        super(1);
        this.this$0 = guildModifyMemberNameAndAvatarFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(GuildModifyMemberNameAndAvatarFragment this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Uh(i3, "", null, 2);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z16) {
        Logger.f235387a.d().d("GuildModifyMemberNameAndAvatarFragment", 1, "[sendClearGuildAvatarRequest] result " + z16);
        final int i3 = z16 ? 0 : -1;
        final GuildModifyMemberNameAndAvatarFragment guildModifyMemberNameAndAvatarFragment = this.this$0;
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.fragment.k
            @Override // java.lang.Runnable
            public final void run() {
                GuildModifyMemberNameAndAvatarFragment$sendClearGuildAvatarRequest$1.b(GuildModifyMemberNameAndAvatarFragment.this, i3);
            }
        });
    }
}
