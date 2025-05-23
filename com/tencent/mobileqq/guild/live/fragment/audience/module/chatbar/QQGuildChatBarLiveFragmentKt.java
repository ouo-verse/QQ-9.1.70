package com.tencent.mobileqq.guild.live.fragment.audience.module.chatbar;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.tencent.guild.aio.component.combinestyle.GuildMediaAioAvatarComponent;
import com.tencent.guild.aio.component.combinestyle.GuildMediaAioTextComponent;
import com.tencent.guild.aio.component.combinestyle.aa;
import com.tencent.guild.aio.component.combinestyle.ae;
import com.tencent.guild.aio.component.combinestyle.am;
import com.tencent.guild.aio.component.combinestyle.y;
import com.tencent.guild.aio.util.ui.UIUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.aiocombinestyle.component.local.LocalCombineStyleChainFactory;
import com.tencent.mobileqq.guild.api.IGuildMediaChannelApi;
import com.tencent.mobileqq.guild.live.livemanager.GLiveChannelCore;
import com.tencent.mobileqq.guild.media.core.notify.NotifyGiftRankChanged;
import com.tencent.mobileqq.guild.media.core.notify.NotifyReceivePayGiftChanged;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rs0.LiveUserEnterTipsModel;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u0012\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0012\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0005\u001aC\u0010\u000e\u001a\u00020\u0003*\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\r\u001a\u00020\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000f\u001a\u001c\u0010\u0013\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0010\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u001a\u001a\u0010\u0017\u001a\u00020\u0003*\u00020\u00002\u000e\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u0014\u001a\u0006\u0010\u0018\u001a\u00020\u0011\"\u001b\u0010\u001c\u001a\u00020\u00078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/guild/live/fragment/audience/module/chatbar/QQGuildChatBarLiveFragment;", "Lcom/tencent/mobileqq/guild/media/core/notify/af;", "event", "", "e", "Lcom/tencent/mobileqq/guild/media/core/notify/ag;", "d", "", "resId", "", "content", "preSuffix", "bgRes", "contentColor", "b", "(Lcom/tencent/mobileqq/guild/live/fragment/audience/module/chatbar/QQGuildChatBarLiveFragment;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;I)V", "tinyId", "", "isRobot", "g", "", "Lrs0/a;", "liveUserEnterTipsModels", "a", "f", "Lkotlin/Lazy;", "c", "()I", "defaultTextColor", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class QQGuildChatBarLiveFragmentKt {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final Lazy f226599a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001J\u0019\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0003H\u0096\u0002\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/live/fragment/audience/module/chatbar/QQGuildChatBarLiveFragmentKt$a", "Lkotlin/Function2;", "Landroid/view/View;", "Lcom/tencent/guild/aio/component/combinestyle/aa;", "", "view", "handleText", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class a implements Function2<View, aa, Unit> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QQGuildChatBarLiveFragment f226600d;

        a(QQGuildChatBarLiveFragment qQGuildChatBarLiveFragment) {
            this.f226600d = qQGuildChatBarLiveFragment;
        }

        public void a(@NotNull View view, @NotNull aa handleText) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(handleText, "handleText");
            if (QQGuildChatBarLiveFragmentKt.f()) {
                return;
            }
            QQGuildChatBarLiveFragment qQGuildChatBarLiveFragment = this.f226600d;
            String f16 = ch.f();
            Intrinsics.checkNotNullExpressionValue(f16, "accountTinyId()");
            QQGuildChatBarLiveFragmentKt.h(qQGuildChatBarLiveFragment, f16, false, 2, null);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(View view, aa aaVar) {
            a(view, aaVar);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0011\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0002H\u0096\u0002\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/live/fragment/audience/module/chatbar/QQGuildChatBarLiveFragmentKt$b", "Lkotlin/Function1;", "", "", "tinyId", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements Function1<String, Unit> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QQGuildChatBarLiveFragment f226601d;

        b(QQGuildChatBarLiveFragment qQGuildChatBarLiveFragment) {
            this.f226601d = qQGuildChatBarLiveFragment;
        }

        public void a(@NotNull String tinyId) {
            Intrinsics.checkNotNullParameter(tinyId, "tinyId");
            if (QQGuildChatBarLiveFragmentKt.f()) {
                return;
            }
            QQGuildChatBarLiveFragmentKt.h(this.f226601d, tinyId, false, 2, null);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            a(str);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002 \u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J)\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0096\u0002\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/live/fragment/audience/module/chatbar/QQGuildChatBarLiveFragmentKt$c", "Lkotlin/Function4;", "", "", "guildId", "channelId", "rankType", "durationType", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c implements Function4<String, String, String, String, Unit> {
        c() {
        }

        public void a(@NotNull String guildId, @NotNull String channelId, @NotNull String rankType, @NotNull String durationType) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            Intrinsics.checkNotNullParameter(rankType, "rankType");
            Intrinsics.checkNotNullParameter(durationType, "durationType");
            QRouteApi api = QRoute.api(IGuildMediaChannelApi.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IGuildMediaChannelApi::class.java)");
            IGuildMediaChannelApi.a.i((IGuildMediaChannelApi) api, guildId, channelId, null, rankType, durationType, null, 36, null);
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(String str, String str2, String str3, String str4) {
            a(str, str2, str3, str4);
            return Unit.INSTANCE;
        }
    }

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.mobileqq.guild.live.fragment.audience.module.chatbar.QQGuildChatBarLiveFragmentKt$defaultTextColor$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                return Integer.valueOf(UIUtil.f112434a.x().getColor(R.color.bpx));
            }
        });
        f226599a = lazy;
    }

    public static final void a(@NotNull QQGuildChatBarLiveFragment qQGuildChatBarLiveFragment, @NotNull List<? extends LiveUserEnterTipsModel> liveUserEnterTipsModels) {
        Intrinsics.checkNotNullParameter(qQGuildChatBarLiveFragment, "<this>");
        Intrinsics.checkNotNullParameter(liveUserEnterTipsModels, "liveUserEnterTipsModels");
        EnterTipsMessageManagerStrategy enterTipsMessageManagerStrategy = qQGuildChatBarLiveFragment.K;
        if (enterTipsMessageManagerStrategy != null) {
            enterTipsMessageManagerStrategy.g(liveUserEnterTipsModels);
        }
    }

    public static final void b(@NotNull QQGuildChatBarLiveFragment qQGuildChatBarLiveFragment, @Nullable Integer num, @NotNull String content, @NotNull String preSuffix, @Nullable Integer num2, int i3) {
        int i16;
        com.tencent.mobileqq.guild.aiocombinestyle.imagestrategy.d dVar;
        boolean z16;
        Intrinsics.checkNotNullParameter(qQGuildChatBarLiveFragment, "<this>");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(preSuffix, "preSuffix");
        y yVar = new y();
        if (num2 != null) {
            i16 = num2.intValue();
        } else {
            i16 = -1;
        }
        y d16 = yVar.d(i16);
        if (num != null) {
            num.intValue();
            dVar = new com.tencent.mobileqq.guild.aiocombinestyle.imagestrategy.d(num.intValue(), null, null, 0, 0, 30, null);
        } else {
            dVar = null;
        }
        y a16 = d16.a(new GuildMediaAioAvatarComponent(dVar, false, null, null, null, 30, null));
        am amVar = new am(i3);
        if (preSuffix.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            a16.a(new GuildMediaAioTextComponent(preSuffix, new am(c()), false, 0, 0, 0, null, null, null, false, 1020, null));
            amVar = null;
        }
        a16.a(new GuildMediaAioTextComponent(content, amVar, false, 0, 0, 0, null, null, null, false, 1020, null));
        qQGuildChatBarLiveFragment.J.c(a16.i());
    }

    private static final int c() {
        return ((Number) f226599a.getValue()).intValue();
    }

    public static final void d(@NotNull QQGuildChatBarLiveFragment qQGuildChatBarLiveFragment, @NotNull NotifyReceivePayGiftChanged event) {
        Intrinsics.checkNotNullParameter(qQGuildChatBarLiveFragment, "<this>");
        Intrinsics.checkNotNullParameter(event, "event");
        qQGuildChatBarLiveFragment.J.c(y.f(new y(), "em_sgrp_get_pay_gift_tip", null, 2, null).a(new GuildMediaAioAvatarComponent(new com.tencent.mobileqq.guild.aiocombinestyle.imagestrategy.d(R.drawable.guild_media_aio_item_system_notify_icon, null, null, 0, 0, 30, null), false, null, null, null, 30, null)).a(new GuildMediaAioTextComponent("\u6536\u5230\u91d1\u5e01\u793c\u7269\u8d8a\u591a\uff0c\u9b45\u529b\u503c\u8d8a\u9ad8\uff0c\u53bb\u8d44\u6599\u5361 ", null, false, 0, 0, 0, null, null, null, false, 1022, null)).a(new GuildMediaAioTextComponent(" \u67e5\u770b\u9b45\u529b\u503c", new am(ae.a()), true, 0, 0, 0, new a(qQGuildChatBarLiveFragment), "em_sgrp_get_pay_gift_tip", null, false, 824, null)).i());
    }

    public static final void e(@NotNull QQGuildChatBarLiveFragment qQGuildChatBarLiveFragment, @NotNull NotifyGiftRankChanged event) {
        Intrinsics.checkNotNullParameter(qQGuildChatBarLiveFragment, "<this>");
        Intrinsics.checkNotNullParameter(event, "event");
        GLiveChannelCore gLiveChannelCore = GLiveChannelCore.f226698a;
        qQGuildChatBarLiveFragment.J.c(LocalCombineStyleChainFactory.f213886a.f(event, gLiveChannelCore.s().getGuildId(), gLiveChannelCore.s().getChannelId(), new b(qQGuildChatBarLiveFragment), new c()));
    }

    public static final boolean f() {
        Integer value = GLiveChannelCore.f226698a.t().l().getValue();
        if (value != null && value.intValue() == 2) {
            return true;
        }
        return false;
    }

    public static final void g(@NotNull QQGuildChatBarLiveFragment qQGuildChatBarLiveFragment, @NotNull String tinyId, boolean z16) {
        Intrinsics.checkNotNullParameter(qQGuildChatBarLiveFragment, "<this>");
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        FragmentActivity activity = qQGuildChatBarLiveFragment.getActivity();
        if (activity != null) {
            com.tencent.guild.aio.util.h hVar = com.tencent.guild.aio.util.h.f112401a;
            GLiveChannelCore gLiveChannelCore = GLiveChannelCore.f226698a;
            hVar.z(activity, gLiveChannelCore.s().getGuildId(), gLiveChannelCore.s().getChannelId(), tinyId, z16);
        }
    }

    public static /* synthetic */ void h(QQGuildChatBarLiveFragment qQGuildChatBarLiveFragment, String str, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        g(qQGuildChatBarLiveFragment, str, z16);
    }
}
