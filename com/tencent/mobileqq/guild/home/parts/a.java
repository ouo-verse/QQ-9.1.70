package com.tencent.mobileqq.guild.home.parts;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.CallSuper;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.constant.GuildFacadeType;
import com.tencent.mobileqq.guild.home.subhome.GuildHomeSubFragmentBehavior;
import com.tencent.mobileqq.guild.home.viewmodels.GuildHomeViewModel;
import com.tencent.mobileqq.guild.home.views.header.handler.GuildHomeHeaderTitleJumpHandler;
import com.tencent.mobileqq.guild.mainframe.startpanel.rightpart.facade.FacadeArgsData;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b'\u0010(J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0017R\"\u0010\u000f\u001a\u00020\b8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u0013\u001a\u00020\u00108F\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0003\u001a\u00020\u00148F\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u001a\u001a\u00020\u00178F\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001e\u001a\u00020\u001b8F\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\"\u001a\u00020\u001f8F\u00a2\u0006\u0006\u001a\u0004\b \u0010!R\u0011\u0010&\u001a\u00020#8F\u00a2\u0006\u0006\u001a\u0004\b$\u0010%\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/guild/home/parts/a;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onPartCreate", "Lwo1/b;", "d", "Lwo1/b;", "C9", "()Lwo1/b;", "F9", "(Lwo1/b;)V", "guildHomeProvider", "Lcom/tencent/mobileqq/guild/mainframe/startpanel/rightpart/facade/FacadeArgsData;", "z9", "()Lcom/tencent/mobileqq/guild/mainframe/startpanel/rightpart/facade/FacadeArgsData;", "facadeArgsData", "Lcom/tencent/mobileqq/app/QBaseActivity;", "x9", "()Lcom/tencent/mobileqq/app/QBaseActivity;", "Lcom/tencent/mobileqq/guild/home/subhome/GuildHomeSubFragmentBehavior;", "A9", "()Lcom/tencent/mobileqq/guild/home/subhome/GuildHomeSubFragmentBehavior;", "fragmentBehavior", "Lcom/tencent/mobileqq/guild/home/viewmodels/GuildHomeViewModel;", "E9", "()Lcom/tencent/mobileqq/guild/home/viewmodels/GuildHomeViewModel;", "homeViewModel", "Lcom/tencent/mobileqq/guild/constant/GuildFacadeType;", "B9", "()Lcom/tencent/mobileqq/guild/constant/GuildFacadeType;", "guildFacadeType", "Lcom/tencent/mobileqq/guild/home/views/header/handler/GuildHomeHeaderTitleJumpHandler;", "D9", "()Lcom/tencent/mobileqq/guild/home/views/header/handler/GuildHomeHeaderTitleJumpHandler;", "guildTitleJumpHandler", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public abstract class a extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    protected wo1.b guildHomeProvider;

    @NotNull
    public final GuildHomeSubFragmentBehavior A9() {
        return C9().e();
    }

    @NotNull
    public final GuildFacadeType B9() {
        return C9().a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final wo1.b C9() {
        wo1.b bVar = this.guildHomeProvider;
        if (bVar != null) {
            return bVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("guildHomeProvider");
        return null;
    }

    @NotNull
    public final GuildHomeHeaderTitleJumpHandler D9() {
        return C9().f();
    }

    @NotNull
    public final GuildHomeViewModel E9() {
        mp1.b d16 = C9().d();
        Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type com.tencent.mobileqq.guild.home.viewmodels.GuildHomeViewModel");
        return (GuildHomeViewModel) d16;
    }

    protected final void F9(@NotNull wo1.b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<set-?>");
        this.guildHomeProvider = bVar;
    }

    @Override // com.tencent.biz.richframework.part.Part
    @CallSuper
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        Object iocInterface = RFWIocAbilityProvider.g().getIocInterface(wo1.b.class, getPartRootView(), null);
        Intrinsics.checkNotNullExpressionValue(iocInterface, "g().getIocInterface(\n   \u2026 rootView, null\n        )");
        F9((wo1.b) iocInterface);
    }

    @NotNull
    public final QBaseActivity x9() {
        return C9().getActivity();
    }

    @NotNull
    public final FacadeArgsData z9() {
        return C9().c();
    }
}
