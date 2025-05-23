package com.tencent.mobileqq.guild.setting.guildmanage.profile;

import android.view.View;
import com.tencent.mobileqq.guild.rolegroup.model.repositories.IRoleGroupListRepository;
import com.tencent.mobileqq.guild.setting.guildmanage.profile.GuildProfileViewModel;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/profile/GuildProfileViewModel$d;", "kotlin.jvm.PlatformType", "itemShow", "", "invoke", "(Lcom/tencent/mobileqq/guild/setting/guildmanage/profile/GuildProfileViewModel$d;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildProfileFragment$relativeChatGroupSettingConfig$1 extends Lambda implements Function1<GuildProfileViewModel.RelativeChatGroupItemShow, Unit> {
    final /* synthetic */ QUIListItemAdapter $adapter;
    final /* synthetic */ tz1.b<x.b.d> $config;
    final /* synthetic */ GuildProfileFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildProfileFragment$relativeChatGroupSettingConfig$1(tz1.b<x.b.d> bVar, GuildProfileFragment guildProfileFragment, QUIListItemAdapter qUIListItemAdapter) {
        super(1);
        this.$config = bVar;
        this.this$0 = guildProfileFragment;
        this.$adapter = qUIListItemAdapter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(GuildProfileFragment this$0, boolean z16, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(view, "view");
        this$0.li(view, z16);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GuildProfileViewModel.RelativeChatGroupItemShow relativeChatGroupItemShow) {
        invoke2(relativeChatGroupItemShow);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GuildProfileViewModel.RelativeChatGroupItemShow relativeChatGroupItemShow) {
        final boolean z16;
        this.$config.O().h(relativeChatGroupItemShow.getContent());
        String str = this.this$0.guildId;
        String str2 = null;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildId");
            str = null;
        }
        if (!ch.n0(str)) {
            IRoleGroupListRepository p16 = com.tencent.mobileqq.guild.rolegroup.model.repositories.r.p();
            String str3 = this.this$0.guildId;
            if (str3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guildId");
            } else {
                str2 = str3;
            }
            if (!p16.getGuildPermission(str2).g()) {
                z16 = false;
                this.$config.V(!z16);
                tz1.b<x.b.d> bVar = this.$config;
                final GuildProfileFragment guildProfileFragment = this.this$0;
                bVar.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.profile.x
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        GuildProfileFragment$relativeChatGroupSettingConfig$1.b(GuildProfileFragment.this, z16, view);
                    }
                });
                this.$adapter.l0(this.$config);
            }
        }
        z16 = true;
        this.$config.V(!z16);
        tz1.b<x.b.d> bVar2 = this.$config;
        final GuildProfileFragment guildProfileFragment2 = this.this$0;
        bVar2.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.profile.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildProfileFragment$relativeChatGroupSettingConfig$1.b(GuildProfileFragment.this, z16, view);
            }
        });
        this.$adapter.l0(this.$config);
    }
}
