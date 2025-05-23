package com.tencent.mobileqq.guild.aiocombinestyle.component.local;

import android.graphics.Color;
import android.view.View;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.common.app.AppInterface;
import com.tencent.guild.aio.component.combinestyle.GuildMediaAioAvatarComponent;
import com.tencent.guild.aio.component.combinestyle.GuildMediaAioCombineStyleChain;
import com.tencent.guild.aio.component.combinestyle.GuildMediaAioTextComponent;
import com.tencent.guild.aio.component.combinestyle.aa;
import com.tencent.guild.aio.component.combinestyle.ae;
import com.tencent.guild.aio.component.combinestyle.am;
import com.tencent.guild.aio.component.combinestyle.an;
import com.tencent.guild.aio.component.combinestyle.f;
import com.tencent.guild.aio.component.combinestyle.y;
import com.tencent.guild.aio.util.ui.UIUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.aiocombinestyle.imagestrategy.d;
import com.tencent.mobileqq.guild.media.core.notify.NotifyGiftRankChanged;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b&\u0010'J\u00a3\u0001\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u00072`\u0010\u0010\u001a\\\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u000b0\rJ4\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00142\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0016J \u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\u0004J?\u0010\u001f\u001a\u00020\u00112\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001b\u001a\u00020\u00042\b\b\u0002\u0010\u001c\u001a\u00020\u00042\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u001e\u001a\u00020\u0019\u00a2\u0006\u0004\b\u001f\u0010 R\u001b\u0010%\u001a\u00020\u00198FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/guild/aiocombinestyle/component/local/LocalCombineStyleChainFactory;", "", "Lcom/tencent/mobileqq/guild/media/core/notify/af;", "event", "", "guildId", "channelId", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "tinyId", "", "openGuildMemberCard", "Lkotlin/Function4;", "rankType", "durationType", "openGiftRankingH5", "Lcom/tencent/guild/aio/component/combinestyle/i;", "f", "nickName", "", "isGuest", "Lkotlin/Function0;", "e", "d", "", "resId", "content", "preSuffix", "bgRes", "contentColor", "a", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;I)Lcom/tencent/guild/aio/component/combinestyle/i;", "b", "Lkotlin/Lazy;", "c", "()I", "defaultTextColor", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class LocalCombineStyleChainFactory {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final LocalCombineStyleChainFactory f213886a = new LocalCombineStyleChainFactory();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy defaultTextColor;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001J\u0019\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0003H\u0096\u0002\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/aiocombinestyle/component/local/LocalCombineStyleChainFactory$a", "Lkotlin/Function2;", "Landroid/view/View;", "Lcom/tencent/guild/aio/component/combinestyle/aa;", "", "view", "handleText", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class a implements Function2<View, aa, Unit> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f213888d;

        a(Function0<Unit> function0) {
            this.f213888d = function0;
        }

        public void a(@NotNull View view, @NotNull aa handleText) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(handleText, "handleText");
            this.f213888d.invoke();
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(View view, aa aaVar) {
            a(view, aaVar);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001J\u0019\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0003H\u0096\u0002\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/aiocombinestyle/component/local/LocalCombineStyleChainFactory$b", "Lkotlin/Function2;", "Landroid/view/View;", "Lcom/tencent/guild/aio/component/combinestyle/aa;", "", "view", "handleText", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b implements Function2<View, aa, Unit> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function1<String, Unit> f213889d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ NotifyGiftRankChanged f213890e;

        /* JADX WARN: Multi-variable type inference failed */
        b(Function1<? super String, Unit> function1, NotifyGiftRankChanged notifyGiftRankChanged) {
            this.f213889d = function1;
            this.f213890e = notifyGiftRankChanged;
        }

        public void a(@NotNull View view, @NotNull aa handleText) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(handleText, "handleText");
            this.f213889d.invoke(this.f213890e.getTinyId());
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(View view, aa aaVar) {
            a(view, aaVar);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001J\u0019\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0003H\u0096\u0002\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/aiocombinestyle/component/local/LocalCombineStyleChainFactory$c", "Lkotlin/Function2;", "Landroid/view/View;", "Lcom/tencent/guild/aio/component/combinestyle/aa;", "", "view", "handleText", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class c implements Function2<View, aa, Unit> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function4<String, String, String, String, Unit> f213891d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f213892e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f213893f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f213894h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f213895i;

        /* JADX WARN: Multi-variable type inference failed */
        c(Function4<? super String, ? super String, ? super String, ? super String, Unit> function4, String str, String str2, String str3, String str4) {
            this.f213891d = function4;
            this.f213892e = str;
            this.f213893f = str2;
            this.f213894h = str3;
            this.f213895i = str4;
        }

        public void a(@NotNull View view, @NotNull aa handleText) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(handleText, "handleText");
            this.f213891d.invoke(this.f213892e, this.f213893f, this.f213894h, this.f213895i);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(View view, aa aaVar) {
            a(view, aaVar);
            return Unit.INSTANCE;
        }
    }

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.mobileqq.guild.aiocombinestyle.component.local.LocalCombineStyleChainFactory$defaultTextColor$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                return Integer.valueOf(UIUtil.f112434a.x().getColor(R.color.bpx));
            }
        });
        defaultTextColor = lazy;
    }

    LocalCombineStyleChainFactory() {
    }

    public static /* synthetic */ GuildMediaAioCombineStyleChain b(LocalCombineStyleChainFactory localCombineStyleChainFactory, Integer num, String str, String str2, Integer num2, int i3, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            str2 = "";
        }
        String str3 = str2;
        if ((i16 & 8) != 0) {
            num2 = -1;
        }
        Integer num3 = num2;
        if ((i16 & 16) != 0) {
            i3 = localCombineStyleChainFactory.c();
        }
        return localCombineStyleChainFactory.a(num, str, str3, num3, i3);
    }

    @NotNull
    public final GuildMediaAioCombineStyleChain a(@Nullable Integer resId, @NotNull String content, @NotNull String preSuffix, @Nullable Integer bgRes, int contentColor) {
        int i3;
        d dVar;
        boolean z16;
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(preSuffix, "preSuffix");
        y yVar = new y();
        if (bgRes != null) {
            i3 = bgRes.intValue();
        } else {
            i3 = -1;
        }
        y d16 = yVar.d(i3);
        if (resId != null) {
            resId.intValue();
            dVar = new d(resId.intValue(), null, null, 0, 0, 30, null);
        } else {
            dVar = null;
        }
        y a16 = d16.a(new GuildMediaAioAvatarComponent(dVar, false, null, null, null, 30, null));
        am amVar = new am(contentColor);
        if (preSuffix.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            a16.a(new GuildMediaAioTextComponent(preSuffix, new am(f213886a.c()), false, 0, 0, 0, null, null, null, false, 1020, null));
            amVar = null;
        }
        a16.a(new GuildMediaAioTextComponent(content, amVar, false, 0, 0, 0, null, null, null, false, 1020, null));
        return a16.i();
    }

    public final int c() {
        return ((Number) defaultTextColor.getValue()).intValue();
    }

    @NotNull
    public final String d(@NotNull String nickName, @Nullable String guildId, @NotNull String tinyId) {
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        boolean z16;
        Intrinsics.checkNotNullParameter(nickName, "nickName");
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        if (guildId != null) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            String str = null;
            if (peekAppRuntime instanceof AppInterface) {
                appInterface = (AppInterface) peekAppRuntime;
            } else {
                appInterface = null;
            }
            if (appInterface != null) {
                iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
            } else {
                iRuntimeService = null;
            }
            IGPSService iGPSService = (IGPSService) iRuntimeService;
            if (iGPSService != null) {
                str = iGPSService.getGuildUserDisplayNameInternal(guildId, tinyId);
            }
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                return str;
            }
        }
        return nickName;
    }

    @NotNull
    public final GuildMediaAioCombineStyleChain e(@NotNull String guildId, @NotNull String tinyId, @NotNull String nickName, boolean isGuest, @NotNull Function0<Unit> openGuildMemberCard) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        Intrinsics.checkNotNullParameter(nickName, "nickName");
        Intrinsics.checkNotNullParameter(openGuildMemberCard, "openGuildMemberCard");
        y a16 = new y().j(f.f110215a.c()).c(false).a(new GuildMediaAioAvatarComponent(new d(R.drawable.guild_live_channel_icon_system_head, null, null, 0, 0, 30, null), false, null, null, null, 30, null)).a(new GuildMediaAioTextComponent(d(nickName, guildId, tinyId) + " ", new an(null, tinyId), true, 0, 0, 0, new a(openGuildMemberCard), null, null, false, 952, null));
        if (isGuest) {
            a16.a(new GuildMediaAioTextComponent(" " + UIUtil.f112434a.x().getString(R.string.f158281p7) + " ", null, true, Color.parseColor("#FF79798C"), ViewUtils.dpToPx(3.0f), ViewUtils.dpToPx(11.0f), null, null, null, false, 962, null));
        }
        return a16.a(new GuildMediaAioTextComponent(" \u6765\u4e86", new am(UIUtil.f112434a.x().getColor(R.color.bpx)), false, 0, 0, 0, null, null, null, false, 1020, null)).i();
    }

    @NotNull
    public final GuildMediaAioCombineStyleChain f(@NotNull NotifyGiftRankChanged event, @NotNull String guildId, @NotNull String channelId, @NotNull Function1<? super String, Unit> openGuildMemberCard, @NotNull Function4<? super String, ? super String, ? super String, ? super String, Unit> openGiftRankingH5) {
        boolean contains$default;
        String str;
        boolean contains$default2;
        String str2;
        HashMap<String, Object> hashMapOf;
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(openGuildMemberCard, "openGuildMemberCard");
        Intrinsics.checkNotNullParameter(openGiftRankingH5, "openGiftRankingH5");
        boolean areEqual = Intrinsics.areEqual(event.getTinyId(), ch.f());
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) event.getRankType(), (CharSequence) "\u8d21\u732e", false, 2, (Object) null);
        if (contains$default) {
            str = "contribution";
        } else {
            str = "charm";
        }
        contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) event.getRankType(), (CharSequence) "\u5468", false, 2, (Object) null);
        if (contains$default2) {
            str2 = WidgetCacheLunarData.WEEK;
        } else {
            str2 = "day";
        }
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("rankType", str), TuplesKt.to("durationType", str2), TuplesKt.to("guildId", guildId), TuplesKt.to("channelId", channelId), TuplesKt.to("param_element_id", "em_sgrp_on_list_tip"));
        y a16 = new y().e("em_sgrp_on_list_tip", hashMapOf).a(new GuildMediaAioAvatarComponent(new d(R.drawable.guild_media_aio_item_gift_top_list_icon, null, null, 0, 0, 30, null), false, null, null, null, 30, null)).a(new GuildMediaAioTextComponent("\u606d\u559c", null, false, 0, 0, 0, null, null, null, false, 1022, null));
        if (areEqual) {
            a16.a(new GuildMediaAioTextComponent("\u4f60", null, false, 0, 0, 0, null, null, null, false, 1022, null));
        } else {
            a16.a(new GuildMediaAioTextComponent(" " + event.getNickName() + " ", new am((int) event.getRoleColor()), true, 0, 0, 0, new b(openGuildMemberCard, event), null, null, false, 952, null));
        }
        return a16.a(new GuildMediaAioTextComponent("\u8363\u767b" + event.getRankType() + "\u7b2c" + event.getRankNum() + "\u540d", null, false, 0, 0, 0, null, null, null, false, 1022, null)).a(new GuildMediaAioTextComponent(" \u67e5\u770b\u8be6\u60c5", new am(ae.a()), true, 0, 0, 0, new c(openGiftRankingH5, guildId, channelId, str, str2), "em_sgrp_on_list_tip", hashMapOf, false, PlayerResources.ViewId.EXTENDED_VIEW_BTN_NORMAL_BUTTON, null)).i();
    }
}
