package com.tencent.mobileqq.guild.setting.guildsetting.part;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.CallSuper;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.mainframe.startpanel.rightpart.facade.FacadeArgsData;
import com.tencent.mobileqq.guild.setting.guildsetting.GuildSettingFragment;
import com.tencent.mobileqq.guild.setting.guildsetting.viewmodel.GuildSettingViewModel;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b#\u0010$J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0017J\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0017\u001a\u00020\u00148F\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u001b\u001a\u00020\u00188F\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0003\u001a\u00020\u001c8F\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\"\u001a\u00020\u001f8F\u00a2\u0006\u0006\u001a\u0004\b \u0010!\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildsetting/part/a;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onPartCreate", "", "Lcom/tencent/mobileqq/widget/listitem/Group;", "D9", "()[Lcom/tencent/mobileqq/widget/listitem/Group;", "Lcom/tencent/mobileqq/guild/setting/guildsetting/GuildSettingFragment;", "C9", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "z9", "Lxz1/a;", "d", "Lxz1/a;", "guildSettingIoc", "", "getGuildId", "()Ljava/lang/String;", "guildId", "Lcom/tencent/mobileqq/guild/setting/guildsetting/viewmodel/GuildSettingViewModel;", "B9", "()Lcom/tencent/mobileqq/guild/setting/guildsetting/viewmodel/GuildSettingViewModel;", "guildSettingViewModel", "Lcom/tencent/mobileqq/app/QBaseActivity;", "x9", "()Lcom/tencent/mobileqq/app/QBaseActivity;", "Lcom/tencent/mobileqq/guild/mainframe/startpanel/rightpart/facade/FacadeArgsData;", "A9", "()Lcom/tencent/mobileqq/guild/mainframe/startpanel/rightpart/facade/FacadeArgsData;", "facadeArgsData", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public abstract class a extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private xz1.a guildSettingIoc;

    @NotNull
    public final FacadeArgsData A9() {
        xz1.a aVar = this.guildSettingIoc;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildSettingIoc");
            aVar = null;
        }
        return aVar.getFacadeArgsData();
    }

    @NotNull
    public final GuildSettingViewModel B9() {
        xz1.a aVar = this.guildSettingIoc;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildSettingIoc");
            aVar = null;
        }
        return aVar.getGuildSettingViewModel();
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: C9, reason: merged with bridge method [inline-methods] */
    public GuildSettingFragment getPartHost() {
        IPartHost partHost = super.getPartHost();
        Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type com.tencent.mobileqq.guild.setting.guildsetting.GuildSettingFragment");
        return (GuildSettingFragment) partHost;
    }

    @NotNull
    public Group[] D9() {
        return new Group[0];
    }

    @NotNull
    public final String getGuildId() {
        xz1.a aVar = this.guildSettingIoc;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildSettingIoc");
            aVar = null;
        }
        return aVar.getGuildId();
    }

    @Override // com.tencent.biz.richframework.part.Part
    @CallSuper
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        Object iocInterface = RFWIocAbilityProvider.g().getIocInterface(xz1.a.class, getPartRootView(), null);
        Intrinsics.checkNotNullExpressionValue(iocInterface, "g().getIocInterface(\n   \u2026 rootView, null\n        )");
        this.guildSettingIoc = (xz1.a) iocInterface;
    }

    @NotNull
    public final QBaseActivity x9() {
        xz1.a aVar = this.guildSettingIoc;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildSettingIoc");
            aVar = null;
        }
        return aVar.getActivity();
    }

    @Nullable
    public final QUIListItemAdapter z9() {
        return getPartHost().Mh().getAdapter();
    }
}
