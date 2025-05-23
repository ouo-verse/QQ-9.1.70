package com.tencent.mobileqq.guild.media.aio;

import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.tencent.guild.aio.component.combinestyle.GuildMediaAioAvatarComponent;
import com.tencent.guild.aio.component.combinestyle.GuildMediaAioCombineStyleChain;
import com.tencent.guild.aio.component.combinestyle.GuildMediaAioTextComponent;
import com.tencent.guild.aio.component.combinestyle.GuildMediaAioTextDrawableComponent;
import com.tencent.guild.aio.component.combinestyle.ad;
import com.tencent.guild.aio.component.combinestyle.ae;
import com.tencent.guild.aio.component.combinestyle.am;
import com.tencent.guild.aio.util.ui.UIUtil;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.aiocombinestyle.component.local.LocalCombineStyleChainFactory;
import com.tencent.mobileqq.guild.aiocombinestyle.imagestrategy.LoadImageStrategyFromMedia;
import com.tencent.mobileqq.guild.api.IGuildMediaChannelApi;
import com.tencent.mobileqq.guild.gift.module.ShowPanelTab;
import com.tencent.mobileqq.guild.media.core.notify.NotifyGiftRankChanged;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProSendGiftEventData;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProUser;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dt0.MediaUserEnterTipsModel;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 :2\u00020\u0001:\u00015B\u0011\u0012\b\u00107\u001a\u0004\u0018\u000104\u00a2\u0006\u0004\b8\u00109J0\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0004H\u0002J\u001a\u0010\u0010\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0002J\u000e\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0006J\u0006\u0010\u0016\u001a\u00020\nJ\u000e\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0017J\u0006\u0010\u001a\u001a\u00020\nJ\u0014\u0010\u001e\u001a\u00020\n2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bJ?\u0010\"\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u001f\u001a\u00020\u00062\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010!\u001a\u00020\u0004\u00a2\u0006\u0004\b\"\u0010#J(\u0010'\u001a\u00020\n2\b\u0010$\u001a\u0004\u0018\u00010\u00062\u0006\u0010%\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006J.\u0010,\u001a\u00020\n2\u0006\u0010(\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u0006J\u001e\u00100\u001a\u00020\n2\u0006\u0010-\u001a\u00020\u00062\u000e\b\u0002\u0010/\u001a\b\u0012\u0004\u0012\u00020\n0.J\u0018\u00103\u001a\u00020\n2\u0006\u0010)\u001a\u00020\u00062\b\b\u0002\u00102\u001a\u000201R\u0016\u00107\u001a\u0004\u0018\u0001048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00106\u00a8\u0006;"}, d2 = {"Lcom/tencent/mobileqq/guild/media/aio/GuildMediaLocalCombineStyleItemManager;", "", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProSendGiftEventData;", "giftAnimData", "", "resId", "", "content", "clickTextDesc", "reportElementId", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "curType", "u", "openIndex", "tag", HippyTKDListViewAdapter.X, "r", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, DomainData.DOMAIN_NAME, "tips", "y", "o", "Lcom/tencent/mobileqq/guild/media/core/notify/af;", "event", ReportConstant.COSTREPORT_PREFIX, "p", "", "Ldt0/a;", "enterTipsList", "t", "preSuffix", "bgRes", "contentColor", "k", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;I)V", "iconUrl", "activeMsg", "btnMsg", tl.h.F, "guildId", "tinyId", "nickName", "tipsContent", "g", "reason", "Lkotlin/Function0;", "onConfirm", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "isRobot", "v", "Lus0/b;", "a", "Lus0/b;", "aioCtrl", "<init>", "(Lus0/b;)V", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildMediaLocalCombineStyleItemManager {

    /* renamed from: a, reason: from kotlin metadata */
    @Nullable
    private final us0.b aioCtrl;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001J\u0019\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0003H\u0096\u0002\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/media/aio/GuildMediaLocalCombineStyleItemManager$b", "Lkotlin/Function2;", "Landroid/view/View;", "Lcom/tencent/guild/aio/component/combinestyle/aa;", "", "view", "handleText", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements Function2<View, com.tencent.guild.aio.component.combinestyle.aa, Unit> {

        /* renamed from: e */
        final /* synthetic */ String f227809e;

        /* renamed from: f */
        final /* synthetic */ String f227810f;

        b(String str, String str2) {
            this.f227809e = str;
            this.f227810f = str2;
        }

        public void a(@NotNull View view, @NotNull com.tencent.guild.aio.component.combinestyle.aa handleText) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(handleText, "handleText");
            GuildMediaLocalCombineStyleItemManager.this.x(this.f227809e, this.f227810f);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(View view, com.tencent.guild.aio.component.combinestyle.aa aaVar) {
            a(view, aaVar);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001J\u0019\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0003H\u0096\u0002\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/media/aio/GuildMediaLocalCombineStyleItemManager$c", "Lkotlin/Function2;", "Landroid/view/View;", "Lcom/tencent/guild/aio/component/combinestyle/aa;", "", "view", "handleText", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c implements Function2<View, com.tencent.guild.aio.component.combinestyle.aa, Unit> {

        /* renamed from: e */
        final /* synthetic */ IGProSendGiftEventData f227812e;

        c(IGProSendGiftEventData iGProSendGiftEventData) {
            this.f227812e = iGProSendGiftEventData;
        }

        public void a(@NotNull View view, @NotNull com.tencent.guild.aio.component.combinestyle.aa handleText) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(handleText, "handleText");
            GuildMediaLocalCombineStyleItemManager.w(GuildMediaLocalCombineStyleItemManager.this, String.valueOf(this.f227812e.getReceiverMember().getTinyId()), false, 2, null);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(View view, com.tencent.guild.aio.component.combinestyle.aa aaVar) {
            a(view, aaVar);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001J\u0019\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0003H\u0096\u0002\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/media/aio/GuildMediaLocalCombineStyleItemManager$d", "Lkotlin/Function2;", "Landroid/view/View;", "Lcom/tencent/guild/aio/component/combinestyle/aa;", "", "view", "handleText", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class d implements Function2<View, com.tencent.guild.aio.component.combinestyle.aa, Unit> {

        /* renamed from: e */
        final /* synthetic */ IGProSendGiftEventData f227814e;

        d(IGProSendGiftEventData iGProSendGiftEventData) {
            this.f227814e = iGProSendGiftEventData;
        }

        public void a(@NotNull View view, @NotNull com.tencent.guild.aio.component.combinestyle.aa handleText) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(handleText, "handleText");
            GuildMediaLocalCombineStyleItemManager.w(GuildMediaLocalCombineStyleItemManager.this, String.valueOf(this.f227814e.getSenderMember().getTinyId()), false, 2, null);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(View view, com.tencent.guild.aio.component.combinestyle.aa aaVar) {
            a(view, aaVar);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001J\u0019\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0003H\u0096\u0002\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/media/aio/GuildMediaLocalCombineStyleItemManager$e", "Lkotlin/Function2;", "Landroid/view/View;", "Lcom/tencent/guild/aio/component/combinestyle/aa;", "", "view", "handleText", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class e implements Function2<View, com.tencent.guild.aio.component.combinestyle.aa, Unit> {

        /* renamed from: d */
        final /* synthetic */ us0.b f227815d;

        e(us0.b bVar) {
            this.f227815d = bVar;
        }

        public void a(@NotNull View view, @NotNull com.tencent.guild.aio.component.combinestyle.aa handleText) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(handleText, "handleText");
            IGuildMediaChannelApi iGuildMediaChannelApi = (IGuildMediaChannelApi) QRoute.api(IGuildMediaChannelApi.class);
            FragmentActivity requireActivity = this.f227815d.a().requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "ctrl.getChatFragment().requireActivity()");
            iGuildMediaChannelApi.showPanel(null, requireActivity);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(View view, com.tencent.guild.aio.component.combinestyle.aa aaVar) {
            a(view, aaVar);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001J\u0019\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0003H\u0096\u0002\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/media/aio/GuildMediaLocalCombineStyleItemManager$f", "Lkotlin/Function2;", "Landroid/view/View;", "Lcom/tencent/guild/aio/component/combinestyle/aa;", "", "view", "handleText", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class f implements Function2<View, com.tencent.guild.aio.component.combinestyle.aa, Unit> {
        f() {
        }

        public void a(@NotNull View view, @NotNull com.tencent.guild.aio.component.combinestyle.aa handleText) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(handleText, "handleText");
            com.tencent.mobileqq.guild.media.core.l c16 = com.tencent.mobileqq.guild.media.core.j.c();
            QRouteApi api = QRoute.api(IGuildMediaChannelApi.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IGuildMediaChannelApi::class.java)");
            IGuildMediaChannelApi.a.j((IGuildMediaChannelApi) api, null, c16.r(), c16.e(), 0, null, 25, null);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(View view, com.tencent.guild.aio.component.combinestyle.aa aaVar) {
            a(view, aaVar);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001J\u0019\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0003H\u0096\u0002\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/media/aio/GuildMediaLocalCombineStyleItemManager$g", "Lkotlin/Function2;", "Landroid/view/View;", "Lcom/tencent/guild/aio/component/combinestyle/aa;", "", "view", "handleText", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class g implements Function2<View, com.tencent.guild.aio.component.combinestyle.aa, Unit> {
        g() {
        }

        public void a(@NotNull View view, @NotNull com.tencent.guild.aio.component.combinestyle.aa handleText) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(handleText, "handleText");
            us0.b bVar = GuildMediaLocalCombineStyleItemManager.this.aioCtrl;
            if (bVar != null) {
                com.tencent.mobileqq.guild.media.core.logic.gift.a b06 = com.tencent.mobileqq.guild.media.core.j.a().b0();
                FragmentActivity requireActivity = bVar.a().requireActivity();
                Intrinsics.checkNotNullExpressionValue(requireActivity, "it.getChatFragment().requireActivity()");
                b06.K(requireActivity, ShowPanelTab.Pack);
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(View view, com.tencent.guild.aio.component.combinestyle.aa aaVar) {
            a(view, aaVar);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0011\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0002H\u0096\u0002\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/aio/GuildMediaLocalCombineStyleItemManager$h", "Lkotlin/Function1;", "", "", "tinyId", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class h implements Function1<String, Unit> {
        h() {
        }

        public void a(@NotNull String tinyId) {
            Intrinsics.checkNotNullParameter(tinyId, "tinyId");
            if (GuildMediaLocalCombineStyleItemManager.this.aioCtrl != null) {
                GuildMediaLocalCombineStyleItemManager.w(GuildMediaLocalCombineStyleItemManager.this, tinyId, false, 2, null);
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            a(str);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002 \u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J)\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0096\u0002\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/media/aio/GuildMediaLocalCombineStyleItemManager$i", "Lkotlin/Function4;", "", "", "guildId", "channelId", "rankType", "durationType", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class i implements Function4<String, String, String, String, Unit> {

        /* renamed from: d */
        final /* synthetic */ com.tencent.mobileqq.guild.media.core.l f227818d;

        i(com.tencent.mobileqq.guild.media.core.l lVar) {
            this.f227818d = lVar;
        }

        public void a(@NotNull String guildId, @NotNull String channelId, @NotNull String rankType, @NotNull String durationType) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            Intrinsics.checkNotNullParameter(rankType, "rankType");
            Intrinsics.checkNotNullParameter(durationType, "durationType");
            QRouteApi api = QRoute.api(IGuildMediaChannelApi.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IGuildMediaChannelApi::class.java)");
            IGuildMediaChannelApi.a.i((IGuildMediaChannelApi) api, this.f227818d.r(), this.f227818d.e(), null, rankType, durationType, null, 36, null);
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(String str, String str2, String str3, String str4) {
            a(str, str2, str3, str4);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u0096\u0002\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/guild/media/aio/GuildMediaLocalCombineStyleItemManager$j", "Lkotlin/Function0;", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class j implements Function0<Unit> {

        /* renamed from: e */
        final /* synthetic */ MediaUserEnterTipsModel f227820e;

        j(MediaUserEnterTipsModel mediaUserEnterTipsModel) {
            this.f227820e = mediaUserEnterTipsModel;
        }

        public void a() {
            GuildMediaLocalCombineStyleItemManager.this.v(this.f227820e.getTinyId(), this.f227820e.getIsRobot());
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001J\u0019\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0003H\u0096\u0002\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/media/aio/GuildMediaLocalCombineStyleItemManager$k", "Lkotlin/Function2;", "Landroid/view/View;", "Lcom/tencent/guild/aio/component/combinestyle/aa;", "", "view", "handleText", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class k implements Function2<View, com.tencent.guild.aio.component.combinestyle.aa, Unit> {
        k() {
        }

        public void a(@NotNull View view, @NotNull com.tencent.guild.aio.component.combinestyle.aa handleText) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(handleText, "handleText");
            ((IGuildMediaChannelApi) QRoute.api(IGuildMediaChannelApi.class)).openMediaThemeChooseDialog("2", "GuildMediaLocalCombineStyleItemManager");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(View view, com.tencent.guild.aio.component.combinestyle.aa aaVar) {
            a(view, aaVar);
            return Unit.INSTANCE;
        }
    }

    public GuildMediaLocalCombineStyleItemManager(@Nullable us0.b bVar) {
        this.aioCtrl = bVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void A(GuildMediaLocalCombineStyleItemManager guildMediaLocalCombineStyleItemManager, String str, Function0 function0, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            function0 = new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.media.aio.GuildMediaLocalCombineStyleItemManager$showOneBtnDialog$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
        }
        guildMediaLocalCombineStyleItemManager.z(str, function0);
    }

    public static final void B(Function0 onConfirm, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(onConfirm, "$onConfirm");
        onConfirm.invoke();
    }

    public static final boolean i(GuildMediaLocalCombineStyleItemManager this$0, String openIndex, String tag, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(openIndex, "$openIndex");
        Intrinsics.checkNotNullParameter(tag, "$tag");
        this$0.x(openIndex, tag);
        return false;
    }

    public static final void j(GuildMediaLocalCombineStyleItemManager this$0, String openIndex, String tag, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(openIndex, "$openIndex");
        Intrinsics.checkNotNullParameter(tag, "$tag");
        this$0.x(openIndex, tag);
        EventCollector.getInstance().onViewClicked(view);
    }

    public static /* synthetic */ void l(GuildMediaLocalCombineStyleItemManager guildMediaLocalCombineStyleItemManager, Integer num, String str, String str2, Integer num2, int i3, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            str2 = "";
        }
        String str3 = str2;
        if ((i16 & 8) != 0) {
            num2 = -1;
        }
        Integer num3 = num2;
        if ((i16 & 16) != 0) {
            i3 = LocalCombineStyleChainFactory.f213886a.c();
        }
        guildMediaLocalCombineStyleItemManager.k(num, str, str3, num3, i3);
    }

    private final void m(IGProSendGiftEventData iGProSendGiftEventData, int i3, String str, String str2, String str3) {
        us0.b bVar = this.aioCtrl;
        if (bVar != null) {
            bVar.c(com.tencent.guild.aio.component.combinestyle.y.f(new com.tencent.guild.aio.component.combinestyle.y(), str3, null, 2, null).a(new GuildMediaAioAvatarComponent(new com.tencent.mobileqq.guild.aiocombinestyle.imagestrategy.d(i3, null, null, 0, 0, 30, null), false, null, null, null, 30, null)).a(new GuildMediaAioTextComponent(str, null, false, 0, 0, 0, null, null, null, false, 1022, null)).a(new GuildMediaAioTextComponent(str2, new am(ae.a()), true, 0, 0, 0, new c(iGProSendGiftEventData), str3, null, false, 824, null)).i());
        }
    }

    public final String u(int curType) {
        if (curType == ((IGuildMediaChannelApi) QRoute.api(IGuildMediaChannelApi.class)).getHAS_OPEN_MIC()) {
            String string = UIUtil.f112434a.x().getString(R.string.f1495012g);
            Intrinsics.checkNotNullExpressionValue(string, "{\n                resour\u2026e_mic_open)\n            }");
            return string;
        }
        if (curType == ((IGuildMediaChannelApi) QRoute.api(IGuildMediaChannelApi.class)).getHAS_RAISE_HAND()) {
            String string2 = UIUtil.f112434a.x().getString(R.string.f1495212i);
            Intrinsics.checkNotNullExpressionValue(string2, "{\n                resour\u2026raise_hand)\n            }");
            return string2;
        }
        if (curType == ((IGuildMediaChannelApi) QRoute.api(IGuildMediaChannelApi.class)).getHAS_IN_MIC_QUEUE()) {
            String string3 = UIUtil.f112434a.x().getString(R.string.f1494812e);
            Intrinsics.checkNotNullExpressionValue(string3, "{\n                resour\u2026_mic_queue)\n            }");
            return string3;
        }
        return "";
    }

    public static /* synthetic */ void w(GuildMediaLocalCombineStyleItemManager guildMediaLocalCombineStyleItemManager, String str, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        guildMediaLocalCombineStyleItemManager.v(str, z16);
    }

    public final void x(String str, String str2) {
        ((IGuildMediaChannelApi) QRoute.api(IGuildMediaChannelApi.class)).openMediaThemeChooseDialog(str, str2);
    }

    public final void g(@NotNull String guildId, @NotNull String tinyId, @NotNull String nickName, @NotNull String tipsContent, @NotNull final String btnMsg) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        Intrinsics.checkNotNullParameter(nickName, "nickName");
        Intrinsics.checkNotNullParameter(tipsContent, "tipsContent");
        Intrinsics.checkNotNullParameter(btnMsg, "btnMsg");
        com.tencent.guild.aio.component.combinestyle.y yVar = new com.tencent.guild.aio.component.combinestyle.y();
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("sgrp_msg_type", "1");
        Unit unit = Unit.INSTANCE;
        GuildMediaAioCombineStyleChain i3 = yVar.e("pg_sgrp_avchannel_aio_interactive_message", hashMap).a(new GuildMediaAioAvatarComponent(new com.tencent.mobileqq.guild.aiocombinestyle.imagestrategy.d(R.drawable.guild_open_mic_icon, null, null, 0, 0, 30, null), false, null, null, null, 30, null)).a(new GuildMediaAioTextComponent(tipsContent + "  ", null, false, 0, 0, 0, null, null, null, false, 1022, null)).b(new ad() { // from class: com.tencent.mobileqq.guild.media.aio.GuildMediaLocalCombineStyleItemManager$addInviteOpenMicToDisplay$inviteOpenMicComponent$2
            @Override // com.tencent.guild.aio.component.combinestyle.ad
            @NotNull
            public com.tencent.guild.aio.component.combinestyle.ac a(@NotNull com.tencent.guild.aio.component.combinestyle.aa combineStyleAioItem) {
                String u16;
                Intrinsics.checkNotNullParameter(combineStyleAioItem, "combineStyleAioItem");
                int checkHasAlreadyDoRequest = ((IGuildMediaChannelApi) QRoute.api(IGuildMediaChannelApi.class)).checkHasAlreadyDoRequest();
                if (checkHasAlreadyDoRequest != ((IGuildMediaChannelApi) QRoute.api(IGuildMediaChannelApi.class)).getNONE()) {
                    combineStyleAioItem.F(R.drawable.guild_media_aio_nav_tips_press_bg);
                    u16 = GuildMediaLocalCombineStyleItemManager.this.u(checkHasAlreadyDoRequest);
                    return new GuildMediaAioTextComponent(u16, new am(Color.parseColor("#999999")), true, 0, 0, 0, null, null, null, false, 1016, null);
                }
                combineStyleAioItem.F(R.drawable.guild_media_aio_nav_tips_bg);
                String str = btnMsg;
                am amVar = new am(ae.a());
                final GuildMediaLocalCombineStyleItemManager guildMediaLocalCombineStyleItemManager = GuildMediaLocalCombineStyleItemManager.this;
                Function2<View, com.tencent.guild.aio.component.combinestyle.aa, Unit> function2 = new Function2<View, com.tencent.guild.aio.component.combinestyle.aa, Unit>() { // from class: com.tencent.mobileqq.guild.media.aio.GuildMediaLocalCombineStyleItemManager$addInviteOpenMicToDisplay$inviteOpenMicComponent$2$componentIntercept$1
                    public void a(@NotNull View textView, @NotNull final com.tencent.guild.aio.component.combinestyle.aa combineStyleAioItem2) {
                        Intrinsics.checkNotNullParameter(textView, "textView");
                        Intrinsics.checkNotNullParameter(combineStyleAioItem2, "combineStyleAioItem");
                        combineStyleAioItem2.F(R.drawable.guild_media_aio_nav_tips_press_bg);
                        IGuildMediaChannelApi iGuildMediaChannelApi = (IGuildMediaChannelApi) QRoute.api(IGuildMediaChannelApi.class);
                        final GuildMediaLocalCombineStyleItemManager guildMediaLocalCombineStyleItemManager2 = GuildMediaLocalCombineStyleItemManager.this;
                        iGuildMediaChannelApi.openMicByClickInviteMsg(new Function3<Integer, String, Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.media.aio.GuildMediaLocalCombineStyleItemManager$addInviteOpenMicToDisplay$inviteOpenMicComponent$2$componentIntercept$1$invoke$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str2, Boolean bool) {
                                invoke(num.intValue(), str2, bool.booleanValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(int i16, @NotNull String retMsg, boolean z16) {
                                Intrinsics.checkNotNullParameter(retMsg, "retMsg");
                                if (i16 != 0 && z16) {
                                    GuildMediaLocalCombineStyleItemManager.A(GuildMediaLocalCombineStyleItemManager.this, retMsg, null, 2, null);
                                } else {
                                    combineStyleAioItem2.k0();
                                }
                            }
                        });
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(View view, com.tencent.guild.aio.component.combinestyle.aa aaVar) {
                        a(view, aaVar);
                        return Unit.INSTANCE;
                    }
                };
                HashMap hashMap2 = new HashMap();
                hashMap2.put("sgrp_msg_type", "1");
                Unit unit2 = Unit.INSTANCE;
                return new GuildMediaAioTextComponent(str, amVar, true, 0, 0, 0, function2, "pg_sgrp_avchannel_aio_interactive_message", hashMap2, true, 56, null);
            }
        }).i();
        us0.b bVar = this.aioCtrl;
        if (bVar != null) {
            bVar.c(i3);
        }
    }

    public final void h(@Nullable String str, @NotNull String activeMsg, @NotNull String btnMsg, @NotNull final String openIndex) {
        com.tencent.mobileqq.guild.aiocombinestyle.imagestrategy.c cVar;
        Intrinsics.checkNotNullParameter(activeMsg, "activeMsg");
        Intrinsics.checkNotNullParameter(btnMsg, "btnMsg");
        Intrinsics.checkNotNullParameter(openIndex, "openIndex");
        com.tencent.guild.aio.component.combinestyle.y yVar = new com.tencent.guild.aio.component.combinestyle.y();
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("sgrp_msg_type", "0");
        Unit unit = Unit.INSTANCE;
        com.tencent.guild.aio.component.combinestyle.y d16 = yVar.e("pg_sgrp_avchannel_aio_interactive_message", hashMap).d(R.drawable.guild_media_aio_nav_tips_bg);
        if (str != null) {
            cVar = new com.tencent.mobileqq.guild.aiocombinestyle.imagestrategy.c(str);
        } else {
            cVar = null;
        }
        com.tencent.guild.aio.component.combinestyle.y a16 = d16.a(new GuildMediaAioAvatarComponent(cVar, false, null, null, null, 30, null));
        final String str2 = "GuildMediaNavigationTipsComponent";
        GuildMediaAioCombineStyleChain i3 = a16.a(new GuildMediaAioTextComponent(activeMsg + "  ", null, false, 0, 0, 0, null, null, null, false, 1022, null)).a(new GuildMediaAioTextComponent(btnMsg, new am(ae.a()), true, 0, 0, 0, new b(openIndex, "GuildMediaNavigationTipsComponent"), null, null, false, 952, null)).g(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.media.aio.v
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildMediaLocalCombineStyleItemManager.j(GuildMediaLocalCombineStyleItemManager.this, openIndex, str2, view);
            }
        }).h(new View.OnLongClickListener() { // from class: com.tencent.mobileqq.guild.media.aio.w
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean i16;
                i16 = GuildMediaLocalCombineStyleItemManager.i(GuildMediaLocalCombineStyleItemManager.this, openIndex, str2, view);
                return i16;
            }
        }).i();
        us0.b bVar = this.aioCtrl;
        if (bVar != null) {
            bVar.c(i3);
        }
    }

    public final void k(@Nullable Integer resId, @NotNull String content, @NotNull String preSuffix, @Nullable Integer bgRes, int contentColor) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(preSuffix, "preSuffix");
        GuildMediaAioCombineStyleChain a16 = LocalCombineStyleChainFactory.f213886a.a(resId, content, preSuffix, bgRes, contentColor);
        us0.b bVar = this.aioCtrl;
        if (bVar != null) {
            bVar.c(a16);
        }
    }

    public final void n(@NotNull IGProSendGiftEventData giftAnimData) {
        boolean z16;
        Intrinsics.checkNotNullParameter(giftAnimData, "giftAnimData");
        us0.b bVar = this.aioCtrl;
        if (bVar != null) {
            int giftId = giftAnimData.getGiftInfo().getGiftId();
            String giftName = giftAnimData.getGiftInfo().getGiftName();
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("qq_gift_id", Integer.valueOf(giftId));
            hashMap.put("qq_gift_name", giftName);
            com.tencent.guild.aio.component.combinestyle.y a16 = new com.tencent.guild.aio.component.combinestyle.y().e("em_sgrp_get_free_gift_return_tip", hashMap).a(new GuildMediaAioAvatarComponent(new com.tencent.mobileqq.guild.aiocombinestyle.imagestrategy.d(R.drawable.guild_media_aio_item_gift_rebate_icon, null, null, 0, 0, 30, null), false, null, null, null, 30, null));
            IGProUser senderMember = giftAnimData.getSenderMember();
            String memberName = senderMember.getMemberName();
            if (memberName.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                memberName = senderMember.getNickName();
            }
            com.tencent.guild.aio.component.combinestyle.y a17 = a16.a(new GuildMediaAioTextComponent(memberName, new am((int) giftAnimData.getSenderMember().getRoleManagementTag().getColor()), true, 0, 0, 0, new d(giftAnimData), null, null, false, 952, null));
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            UIUtil uIUtil = UIUtil.f112434a;
            String string = uIUtil.x().getString(R.string.f1494312_);
            Intrinsics.checkNotNullExpressionValue(string, "UIUtil.resources.getStri\u2026ia_gift_rebate_send_text)");
            String format = String.format(string, Arrays.copyOf(new Object[]{giftAnimData.getGiftInfo().getGiftName()}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            com.tencent.guild.aio.component.combinestyle.y a18 = a17.a(new GuildMediaAioTextComponent(format, null, false, 0, 0, 0, null, null, null, false, 1022, null)).a(new GuildMediaAioTextDrawableComponent(new LoadImageStrategyFromMedia(Integer.valueOf(giftAnimData.getGiftInfo().getMaterialId()), null, null, 0, 0, 30, null), 0, false, null, null, null, 62, null));
            String string2 = uIUtil.x().getString(R.string.f14942129);
            am amVar = new am(ae.a());
            e eVar = new e(bVar);
            HashMap hashMap2 = new HashMap();
            hashMap2.put("qq_gift_id", Integer.valueOf(giftId));
            hashMap2.put("qq_gift_name", giftName);
            Unit unit = Unit.INSTANCE;
            bVar.c(a18.a(new GuildMediaAioTextComponent(string2, amVar, true, 0, 0, 0, eVar, "em_sgrp_get_free_gift_return_tip", hashMap2, false, PlayerResources.ViewId.EXTENDED_VIEW_BTN_NORMAL_BUTTON, null)).i());
        }
    }

    public final void o() {
        GuildMediaAioCombineStyleChain i3 = com.tencent.guild.aio.component.combinestyle.y.f(new com.tencent.guild.aio.component.combinestyle.y(), "em_sgrp_first_get_free_gift_tip", null, 2, null).a(new GuildMediaAioAvatarComponent(new com.tencent.mobileqq.guild.aiocombinestyle.imagestrategy.d(R.drawable.guild_media_bottom_free_gift, null, null, 0, 0, 30, null), false, null, null, null, 30, null)).a(new GuildMediaAioTextDrawableComponent(new com.tencent.mobileqq.guild.aiocombinestyle.imagestrategy.d(R.drawable.guild_aio_free_gift_plus_one, null, null, 0, 0, 30, null), 0, false, null, null, null, 62, null)).a(new GuildMediaAioTextComponent("\u7ee7\u7eed\u505c\u7559\u53ef\u83b7\u5f97\u66f4\u591a\u661f\u661f\u54e6~", null, false, 0, 0, 0, null, null, null, false, 1022, null)).a(new GuildMediaAioTextComponent(" \u67e5\u770b\u8be6\u60c5", new am(ae.a()), true, 0, 0, 0, new f(), "em_sgrp_first_get_free_gift_tip", null, false, 824, null)).i();
        us0.b bVar = this.aioCtrl;
        if (bVar != null) {
            bVar.c(i3);
        }
    }

    public final void p() {
        GuildMediaAioCombineStyleChain i3 = com.tencent.guild.aio.component.combinestyle.y.f(new com.tencent.guild.aio.component.combinestyle.y(), "em_sgrp_get_free_gift_full_tip", null, 2, null).a(new GuildMediaAioAvatarComponent(new com.tencent.mobileqq.guild.aiocombinestyle.imagestrategy.d(R.drawable.guild_aio_free_gift_max_number, null, null, 0, 0, 30, null), false, null, null, null, 30, null)).a(new GuildMediaAioTextComponent("\u661f\u661f\u5df2\u6512\u6ee1" + com.tencent.mobileqq.guild.media.core.j.c().getFreeGiftInfo().getFreeGiftAccountBalance() + "\u4e2a\u5566", null, false, 0, 0, 0, null, null, null, false, 1022, null)).a(new GuildMediaAioTextComponent(" \u7acb\u5373\u9001\u51fa", new am(UIUtil.f112434a.x().getColor(R.color.bm5)), true, 0, 0, 0, new g(), "em_sgrp_on_list_tip", null, false, 824, null)).i();
        us0.b bVar = this.aioCtrl;
        if (bVar != null) {
            bVar.c(i3);
        }
    }

    public final void q(@NotNull IGProSendGiftEventData giftAnimData) {
        Intrinsics.checkNotNullParameter(giftAnimData, "giftAnimData");
        m(giftAnimData, R.drawable.guild_media_aio_item_system_notify_icon, "\u6536\u5230\u91d1\u5e01\u793c\u7269\u8d8a\u591a\uff0c\u9b45\u529b\u503c\u8d8a\u9ad8\uff0c\u53bb\u8d44\u6599\u5361 ", "\u67e5\u770b\u9b45\u529b\u503c", "em_sgrp_get_pay_gift_tip");
    }

    public final void r(@NotNull IGProSendGiftEventData giftAnimData) {
        Intrinsics.checkNotNullParameter(giftAnimData, "giftAnimData");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("\u53ef\u4ee5\u5728\u8d44\u6599\u5361\u67e5\u770b\u6700\u8fd1\u6536\u5230\u7684%s\u54e6\uff5e", Arrays.copyOf(new Object[]{giftAnimData.getGiftInfo().getGiftName()}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        m(giftAnimData, R.drawable.guild_media_aio_item_system_notify_icon, format, "\u67e5\u770b\u8be6\u60c5", "em_sgrp_get_free_gift_tip");
    }

    public final void s(@NotNull NotifyGiftRankChanged event) {
        Intrinsics.checkNotNullParameter(event, "event");
        com.tencent.mobileqq.guild.media.core.l c16 = com.tencent.mobileqq.guild.media.core.j.c();
        GuildMediaAioCombineStyleChain f16 = LocalCombineStyleChainFactory.f213886a.f(event, c16.r(), c16.e(), new h(), new i(c16));
        us0.b bVar = this.aioCtrl;
        if (bVar != null) {
            bVar.c(f16);
        }
    }

    public final void t(@NotNull List<MediaUserEnterTipsModel> enterTipsList) {
        Intrinsics.checkNotNullParameter(enterTipsList, "enterTipsList");
        com.tencent.mobileqq.guild.media.core.l c16 = com.tencent.mobileqq.guild.media.core.j.c();
        for (MediaUserEnterTipsModel mediaUserEnterTipsModel : enterTipsList) {
            GuildMediaAioCombineStyleChain e16 = LocalCombineStyleChainFactory.f213886a.e(c16.r(), mediaUserEnterTipsModel.getTinyId(), mediaUserEnterTipsModel.getNickName(), mediaUserEnterTipsModel.getIsGuest(), new j(mediaUserEnterTipsModel));
            us0.b bVar = this.aioCtrl;
            if (bVar != null) {
                bVar.c(e16);
            }
        }
    }

    public final void v(@NotNull String tinyId, boolean isRobot) {
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        us0.b bVar = this.aioCtrl;
        if (bVar != null) {
            com.tencent.guild.aio.util.h hVar = com.tencent.guild.aio.util.h.f112401a;
            FragmentActivity requireActivity = bVar.a().requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "aioCtrl.getChatFragment().requireActivity()");
            String str = com.tencent.mobileqq.guild.media.core.j.c().getSelfUserInfo().P;
            Intrinsics.checkNotNullExpressionValue(str, "getDataHub().selfUserInfo.guildId");
            hVar.z(requireActivity, str, com.tencent.mobileqq.guild.media.core.j.c().e(), tinyId, isRobot);
        }
    }

    public final void y(@NotNull String tips) {
        Intrinsics.checkNotNullParameter(tips, "tips");
        GuildMediaAioCombineStyleChain i3 = com.tencent.guild.aio.component.combinestyle.y.f(new com.tencent.guild.aio.component.combinestyle.y(), "pg_sgrp_avchannel_aio_interactive_message", null, 2, null).d(R.drawable.guild_media_aio_nav_tips_bg).a(new GuildMediaAioAvatarComponent(new com.tencent.mobileqq.guild.aiocombinestyle.imagestrategy.d(R.drawable.guild_media_aio_game, null, null, 0, 0, 30, null), false, null, null, null, 30, null)).a(new GuildMediaAioTextComponent(tips, null, false, 0, 0, 0, null, null, null, false, 1022, null)).a(new GuildMediaAioTextComponent(" \u53bb\u53d1\u8d77", new am(ae.a()), true, 0, 0, 0, new k(), "pg_sgrp_avchannel_aio_interactive_message", null, false, 824, null)).i();
        us0.b bVar = this.aioCtrl;
        if (bVar != null) {
            bVar.c(i3);
        }
    }

    public final void z(@NotNull String reason, @NotNull final Function0<Unit> onConfirm) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        Intrinsics.checkNotNullParameter(onConfirm, "onConfirm");
        Activity resumeActivity = MobileQQ.sMobileQQ.getResumeActivity();
        if (resumeActivity != null && !resumeActivity.isFinishing()) {
            com.tencent.mobileqq.guild.util.qqui.c.b(resumeActivity, 230, null, reason, null, resumeActivity.getString(R.string.f146610un), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.media.aio.x
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    GuildMediaLocalCombineStyleItemManager.B(Function0.this, dialogInterface, i3);
                }
            }, null).show();
        }
    }
}
