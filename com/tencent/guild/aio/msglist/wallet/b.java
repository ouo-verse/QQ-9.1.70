package com.tencent.guild.aio.msglist.wallet;

import androidx.lifecycle.LifecycleOwner;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListIntent;
import com.tencent.guild.aio.msglist.holder.component.nick.GuildMsgNickState;
import com.tencent.guild.aio.msglist.holder.component.t;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.mvi.base.route.j;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000)\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\b\u0007*\u0001\u000e\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\bH\u0016R\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/guild/aio/msglist/wallet/b;", "Lcom/tencent/guild/aio/msglist/holder/component/t;", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "l", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/aio/api/runtime/a;", "context", "", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "d", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "gpsObserver", "com/tencent/guild/aio/msglist/wallet/b$a", "e", "Lcom/tencent/guild/aio/msglist/wallet/b$a;", "action", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class b extends t {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GPServiceObserver gpsObserver = l();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a action = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/guild/aio/msglist/wallet/b$a", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class a implements com.tencent.mvi.base.route.a {
        a() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            if (i3 instanceof GuildMsgListIntent.GuildApngPlayEvent) {
                b.this.updateUI(new GuildWalletHbApngUiState(((GuildMsgListIntent.GuildApngPlayEvent) i3).getPlay()));
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0014J\u001c\u0010\u0007\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0014J\u0012\u0010\b\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0014J\u001c\u0010\n\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0014\u00a8\u0006\u000b"}, d2 = {"com/tencent/guild/aio/msglist/wallet/b$b", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "guildId", "tinyId", "", "onMemberTopRoleChanged", "onGuildMemberClientIdentityUpdate", "onUserDisplayNameUpdate", "userMedalUrl", "onGuildUserMedalsUpdated", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.guild.aio.msglist.wallet.b$b, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C1207b extends GPServiceObserver {
        C1207b() {
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onGuildMemberClientIdentityUpdate(@Nullable String guildId, @Nullable String tinyId) {
            b.this.updateUI(new GuildMsgNickState(3, tinyId));
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onGuildUserMedalsUpdated(@Nullable String tinyId, @Nullable String userMedalUrl) {
            b.this.updateUI(new GuildMsgNickState(5, tinyId));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onMemberTopRoleChanged(@Nullable String guildId, @Nullable String tinyId) {
            b.this.updateUI(new GuildMsgNickState(2, tinyId));
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onUserDisplayNameUpdate(@Nullable String tinyId) {
            b.this.updateUI(new GuildMsgNickState(1, tinyId));
        }
    }

    private final GPServiceObserver l() {
        return new C1207b();
    }

    private final IGPSService m() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return null;
        }
        return (IGPSService) peekAppRuntime.getRuntimeService(IGPSService.class, "");
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        super.onDestroy();
        IGPSService m3 = m();
        if (m3 != null) {
            m3.deleteObserver(this.gpsObserver);
        }
    }

    @Override // com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(context, "context");
        IGPSService m3 = m();
        if (m3 != null) {
            m3.addObserver(this.gpsObserver);
        }
        j e16 = context.e();
        String qualifiedName = Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GuildApngPlayEvent.class).getQualifiedName();
        a aVar = this.action;
        LifecycleOwner d16 = context.d();
        Intrinsics.checkNotNullExpressionValue(d16, "context.lifecycleOwner");
        e16.c(qualifiedName, aVar, d16);
    }
}
