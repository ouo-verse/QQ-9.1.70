package com.tencent.mobileqq.guild.homev2.parts;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.CallSuper;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.constant.GuildFacadeType;
import com.tencent.mobileqq.guild.homev2.misc.GuildHomeV2FragmentBehavior;
import com.tencent.mobileqq.guild.homev2.viewmodels.GuildHomeViewModel;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0017R\"\u0010\u000f\u001a\u00020\b8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u0003\u001a\u00020\u00108F\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0016\u001a\u00020\u00138F\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u001a\u001a\u00020\u00178F\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001e\u001a\u00020\u001b8F\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/guild/homev2/parts/a;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onPartCreate", "Lmp1/a;", "d", "Lmp1/a;", "B9", "()Lmp1/a;", "D9", "(Lmp1/a;)V", "guildHomeProvider", "Lcom/tencent/mobileqq/app/QBaseActivity;", "x9", "()Lcom/tencent/mobileqq/app/QBaseActivity;", "Lcom/tencent/mobileqq/guild/homev2/misc/GuildHomeV2FragmentBehavior;", "z9", "()Lcom/tencent/mobileqq/guild/homev2/misc/GuildHomeV2FragmentBehavior;", "fragmentBehavior", "Lcom/tencent/mobileqq/guild/homev2/viewmodels/GuildHomeViewModel;", "C9", "()Lcom/tencent/mobileqq/guild/homev2/viewmodels/GuildHomeViewModel;", "homeViewModel", "Lcom/tencent/mobileqq/guild/constant/GuildFacadeType;", "A9", "()Lcom/tencent/mobileqq/guild/constant/GuildFacadeType;", "guildFacadeType", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public abstract class a extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    protected mp1.a guildHomeProvider;

    @NotNull
    public final GuildFacadeType A9() {
        return B9().a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final mp1.a B9() {
        mp1.a aVar = this.guildHomeProvider;
        if (aVar != null) {
            return aVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("guildHomeProvider");
        return null;
    }

    @NotNull
    public final GuildHomeViewModel C9() {
        return B9().getHomeViewModel();
    }

    protected final void D9(@NotNull mp1.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.guildHomeProvider = aVar;
    }

    @Override // com.tencent.biz.richframework.part.Part
    @CallSuper
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        Object iocInterface = RFWIocAbilityProvider.g().getIocInterface(mp1.a.class, getPartRootView(), null);
        Intrinsics.checkNotNullExpressionValue(iocInterface, "g().getIocInterface(\n   \u2026 rootView, null\n        )");
        D9((mp1.a) iocInterface);
    }

    @NotNull
    public final QBaseActivity x9() {
        return B9().getActivity();
    }

    @NotNull
    public final GuildHomeV2FragmentBehavior z9() {
        return B9().e();
    }
}
