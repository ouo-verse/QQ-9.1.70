package com.tencent.mobileqq.guild.setting.guildmanage.guildappmanage.part;

import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.guild.setting.guildmanage.guildappmanage.viewmodel.GuildApplicationManageViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u001a\u0010\u0007\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/guildappmanage/part/a;", "Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/mobileqq/guild/setting/guildmanage/guildappmanage/viewmodel/GuildApplicationManageViewModel;", "d", "Lcom/tencent/mobileqq/guild/setting/guildmanage/guildappmanage/viewmodel/GuildApplicationManageViewModel;", "getViewModel", "()Lcom/tencent/mobileqq/guild/setting/guildmanage/guildappmanage/viewmodel/GuildApplicationManageViewModel;", "viewModel", "<init>", "(Lcom/tencent/mobileqq/guild/setting/guildmanage/guildappmanage/viewmodel/GuildApplicationManageViewModel;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public abstract class a extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildApplicationManageViewModel viewModel;

    public a(@NotNull GuildApplicationManageViewModel viewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        this.viewModel = viewModel;
    }
}
