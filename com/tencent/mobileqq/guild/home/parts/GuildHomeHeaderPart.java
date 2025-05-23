package com.tencent.mobileqq.guild.home.parts;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Space;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ar1.h;
import bp1.HeaderCollapsedState;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.guild.channellist.GuildTextChannelListFragment;
import com.tencent.mobileqq.guild.constant.GuildFacadeType;
import com.tencent.mobileqq.guild.home.checkin.GuildCheckinDialogFragment;
import com.tencent.mobileqq.guild.home.decoration.GuildHomeNavigationBarBubbleDecoration;
import com.tencent.mobileqq.guild.home.subhome.g;
import com.tencent.mobileqq.guild.home.viewmodels.header.GuildHomeCoverColors;
import com.tencent.mobileqq.guild.home.views.GuildHomeCoverBelowList;
import com.tencent.mobileqq.guild.home.views.header.GuildHomeGuildInfoLayout;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadService;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.widget.RecyclerViewWithHeaderFooter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildCheckinRsp;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qcircle.weseevideo.model.utils.LocaleUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.QzoneIPCModule;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import zq1.GuildChannelUnread;

@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 H2\u00020\u0001:\u0001IB\u0007\u00a2\u0006\u0004\bF\u0010GJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016J\u0006\u0010\f\u001a\u00020\u0002J\"\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u001c\u0010\u0017\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u0018\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b6\u00107R\u001b\u0010>\u001a\u0002098BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u001b\u0010B\u001a\u00020\u00078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b?\u0010;\u001a\u0004\b@\u0010AR\u0014\u0010E\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bC\u0010D\u00a8\u0006J"}, d2 = {"Lcom/tencent/mobileqq/guild/home/parts/GuildHomeHeaderPart;", "Lcom/tencent/mobileqq/guild/home/parts/a;", "", "initData", "ha", "Lcom/tencent/mobileqq/guild/home/subhome/g;", LocaleUtils.L_JAPANESE, "Lar1/h;", "ia", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "V9", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "Lcom/tencent/mobileqq/guild/home/views/GuildHomeCoverBelowList;", "e", "Lcom/tencent/mobileqq/guild/home/views/GuildHomeCoverBelowList;", "coverBelow", "Lcom/tencent/mobileqq/guild/widget/RecyclerViewWithHeaderFooter;", "f", "Lcom/tencent/mobileqq/guild/widget/RecyclerViewWithHeaderFooter;", "recyclerView", "Lhp1/a;", tl.h.F, "Lhp1/a;", "headerBarsAdapter", "Lcom/tencent/mobileqq/guild/home/views/header/GuildHomeGuildInfoLayout;", "i", "Lcom/tencent/mobileqq/guild/home/views/header/GuildHomeGuildInfoLayout;", "guildTitleContainerInList", "Lcom/tencent/mobileqq/guild/home/decoration/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/home/decoration/a;", "headerBgDecoration", "Lcom/tencent/mobileqq/guild/home/decoration/GuildHomeNavigationBarBubbleDecoration;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/home/decoration/GuildHomeNavigationBarBubbleDecoration;", "navigationBubbleDecoration", "Lcom/tencent/mobileqq/activity/recent/cur/DragFrameLayout;", "D", "Lcom/tencent/mobileqq/activity/recent/cur/DragFrameLayout;", "dragHost", "Landroid/widget/Space;", "E", "Landroid/widget/Space;", "windowAnchor", "Lap1/a;", UserInfo.SEX_FEMALE, "Lkotlin/Lazy;", "W9", "()Lap1/a;", "guildChannelListJumpHandler", "G", "X9", "()Lar1/h;", "guildChannelListUnreadHandler", "H", "Lcom/tencent/mobileqq/guild/home/subhome/g;", "onStateUpdate", "<init>", "()V", "I", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildHomeHeaderPart extends a {

    /* renamed from: C, reason: from kotlin metadata */
    private GuildHomeNavigationBarBubbleDecoration navigationBubbleDecoration;

    /* renamed from: D, reason: from kotlin metadata */
    private DragFrameLayout dragHost;

    /* renamed from: E, reason: from kotlin metadata */
    private Space windowAnchor;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy guildChannelListJumpHandler;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy guildChannelListUnreadHandler;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.home.subhome.g onStateUpdate;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private GuildHomeCoverBelowList coverBelow;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private RecyclerViewWithHeaderFooter recyclerView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private hp1.a headerBarsAdapter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private GuildHomeGuildInfoLayout guildTitleContainerInList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.guild.home.decoration.a headerBgDecoration;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/home/parts/GuildHomeHeaderPart$c", "Lcom/tencent/mobileqq/guild/home/subhome/g;", "Lbp1/a;", "state", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c implements com.tencent.mobileqq.guild.home.subhome.g {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f224940b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ GuildHomeHeaderPart f224941c;

        public c(String str, GuildHomeHeaderPart guildHomeHeaderPart) {
            this.f224940b = str;
            this.f224941c = guildHomeHeaderPart;
        }

        @Override // com.tencent.mobileqq.guild.home.subhome.g
        public void a(@NotNull bp1.a state) {
            boolean z16;
            Intrinsics.checkNotNullParameter(state, "state");
            RecyclerViewWithHeaderFooter recyclerViewWithHeaderFooter = this.f224941c.recyclerView;
            RecyclerViewWithHeaderFooter recyclerViewWithHeaderFooter2 = null;
            if (recyclerViewWithHeaderFooter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                recyclerViewWithHeaderFooter = null;
            }
            RecyclerView.LayoutManager layoutManager = recyclerViewWithHeaderFooter.getLayoutManager();
            Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            int i3 = 0;
            if (((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                GuildHomeGuildInfoLayout guildHomeGuildInfoLayout = this.f224941c.guildTitleContainerInList;
                if (guildHomeGuildInfoLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("guildTitleContainerInList");
                    guildHomeGuildInfoLayout = null;
                }
                guildHomeGuildInfoLayout.setAlpha(1 - state.getFloatTitleAlpha());
            } else {
                GuildHomeGuildInfoLayout guildHomeGuildInfoLayout2 = this.f224941c.guildTitleContainerInList;
                if (guildHomeGuildInfoLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("guildTitleContainerInList");
                    guildHomeGuildInfoLayout2 = null;
                }
                guildHomeGuildInfoLayout2.setAlpha(0.0f);
            }
            RecyclerViewWithHeaderFooter recyclerViewWithHeaderFooter3 = this.f224941c.recyclerView;
            if (recyclerViewWithHeaderFooter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            } else {
                recyclerViewWithHeaderFooter2 = recyclerViewWithHeaderFooter3;
            }
            if (state instanceof HeaderCollapsedState) {
                i3 = 4;
            }
            recyclerViewWithHeaderFooter2.setVisibility(i3);
        }
    }

    public GuildHomeHeaderPart() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ap1.a>() { // from class: com.tencent.mobileqq.guild.home.parts.GuildHomeHeaderPart$guildChannelListJumpHandler$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ap1.a invoke() {
                return new ap1.a();
            }
        });
        this.guildChannelListJumpHandler = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<ar1.h>() { // from class: com.tencent.mobileqq.guild.home.parts.GuildHomeHeaderPart$guildChannelListUnreadHandler$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ar1.h invoke() {
                ar1.h ia5;
                ia5 = GuildHomeHeaderPart.this.ia();
                return ia5;
            }
        });
        this.guildChannelListUnreadHandler = lazy2;
        this.onStateUpdate = ja();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ap1.a W9() {
        return (ap1.a) this.guildChannelListJumpHandler.getValue();
    }

    private final ar1.h X9() {
        return (ar1.h) this.guildChannelListUnreadHandler.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void aa(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ba(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ca(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void da(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ea(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ga(GuildHomeHeaderPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        GuildHomeGuildInfoLayout guildHomeGuildInfoLayout = this$0.guildTitleContainerInList;
        GuildHomeCoverBelowList guildHomeCoverBelowList = null;
        if (guildHomeGuildInfoLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildTitleContainerInList");
            guildHomeGuildInfoLayout = null;
        }
        GuildHomeCoverBelowList guildHomeCoverBelowList2 = this$0.coverBelow;
        if (guildHomeCoverBelowList2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coverBelow");
        } else {
            guildHomeCoverBelowList = guildHomeCoverBelowList2;
        }
        guildHomeGuildInfoLayout.k(guildHomeCoverBelowList, "GuildHomeHeaderPart");
    }

    private final void ha() {
        GuildHomeGuildInfoLayout guildHomeGuildInfoLayout = this.guildTitleContainerInList;
        com.tencent.mobileqq.guild.home.decoration.a aVar = null;
        if (guildHomeGuildInfoLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildTitleContainerInList");
            guildHomeGuildInfoLayout = null;
        }
        GuildHomeCoverBelowList guildHomeCoverBelowList = this.coverBelow;
        if (guildHomeCoverBelowList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coverBelow");
            guildHomeCoverBelowList = null;
        }
        this.headerBgDecoration = new com.tencent.mobileqq.guild.home.decoration.a(guildHomeGuildInfoLayout, guildHomeCoverBelowList);
        if (B9() != GuildFacadeType.GameCenter) {
            RecyclerViewWithHeaderFooter recyclerViewWithHeaderFooter = this.recyclerView;
            if (recyclerViewWithHeaderFooter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                recyclerViewWithHeaderFooter = null;
            }
            com.tencent.mobileqq.guild.home.decoration.a aVar2 = this.headerBgDecoration;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("headerBgDecoration");
            } else {
                aVar = aVar2;
            }
            recyclerViewWithHeaderFooter.addItemDecoration(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ar1.h ia() {
        return new ar1.h(new b());
    }

    private final void initData() {
        LiveData<List<com.tencent.mobileqq.guild.home.viewmodels.header.uidata.b>> b26 = E9().getGuildHomeHeaderBarsViewModel().b2();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final GuildHomeHeaderPart$initData$1 guildHomeHeaderPart$initData$1 = new GuildHomeHeaderPart$initData$1(this);
        b26.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.home.parts.af
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildHomeHeaderPart.Y9(Function1.this, obj);
            }
        });
        LiveData<GuildHomeCoverColors> T1 = E9().getHeaderColorsViewModel().T1();
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final Function1<GuildHomeCoverColors, Unit> function1 = new Function1<GuildHomeCoverColors, Unit>() { // from class: com.tencent.mobileqq.guild.home.parts.GuildHomeHeaderPart$initData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GuildHomeCoverColors guildHomeCoverColors) {
                invoke2(guildHomeCoverColors);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(GuildHomeCoverColors it) {
                com.tencent.mobileqq.guild.home.decoration.a aVar;
                GuildHomeGuildInfoLayout guildHomeGuildInfoLayout = GuildHomeHeaderPart.this.guildTitleContainerInList;
                com.tencent.mobileqq.guild.home.decoration.a aVar2 = null;
                if (guildHomeGuildInfoLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("guildTitleContainerInList");
                    guildHomeGuildInfoLayout = null;
                }
                Intrinsics.checkNotNullExpressionValue(it, "it");
                guildHomeGuildInfoLayout.g(it);
                aVar = GuildHomeHeaderPart.this.headerBgDecoration;
                if (aVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("headerBgDecoration");
                } else {
                    aVar2 = aVar;
                }
                aVar2.f(it);
            }
        };
        T1.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.guild.home.parts.ag
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildHomeHeaderPart.Z9(Function1.this, obj);
            }
        });
        LiveData<IGProGuildInfo> e26 = E9().getGuildHomeTitleViewModel().e2();
        LifecycleOwner lifecycleOwner3 = getPartHost().getLifecycleOwner();
        final Function1<IGProGuildInfo, Unit> function12 = new Function1<IGProGuildInfo, Unit>() { // from class: com.tencent.mobileqq.guild.home.parts.GuildHomeHeaderPart$initData$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(IGProGuildInfo iGProGuildInfo) {
                invoke2(iGProGuildInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable IGProGuildInfo iGProGuildInfo) {
                if (iGProGuildInfo != null) {
                    GuildHomeGuildInfoLayout guildHomeGuildInfoLayout = GuildHomeHeaderPart.this.guildTitleContainerInList;
                    if (guildHomeGuildInfoLayout == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("guildTitleContainerInList");
                        guildHomeGuildInfoLayout = null;
                    }
                    guildHomeGuildInfoLayout.i(iGProGuildInfo);
                }
            }
        };
        e26.observe(lifecycleOwner3, new Observer() { // from class: com.tencent.mobileqq.guild.home.parts.ah
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildHomeHeaderPart.aa(Function1.this, obj);
            }
        });
        LiveData<Integer> d26 = E9().getGuildHomePermissionViewModel().d2();
        LifecycleOwner lifecycleOwner4 = getPartHost().getLifecycleOwner();
        final Function1<Integer, Unit> function13 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.guild.home.parts.GuildHomeHeaderPart$initData$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer cnt) {
                Intrinsics.checkNotNullExpressionValue(cnt, "cnt");
                if (cnt.intValue() < 10000) {
                    GuildHomeGuildInfoLayout guildHomeGuildInfoLayout = GuildHomeHeaderPart.this.guildTitleContainerInList;
                    if (guildHomeGuildInfoLayout == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("guildTitleContainerInList");
                        guildHomeGuildInfoLayout = null;
                    }
                    guildHomeGuildInfoLayout.e(cnt.intValue());
                }
            }
        };
        d26.observe(lifecycleOwner4, new Observer() { // from class: com.tencent.mobileqq.guild.home.parts.ai
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildHomeHeaderPart.ba(Function1.this, obj);
            }
        });
        MutableLiveData<Boolean> S1 = E9().getGuildNetViewModel().S1();
        LifecycleOwner lifecycleOwner5 = getPartHost().getLifecycleOwner();
        final Function1<Boolean, Unit> function14 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.home.parts.GuildHomeHeaderPart$initData$5
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                IGProGuildInfo value = GuildHomeHeaderPart.this.E9().getGuildHomeTitleViewModel().e2().getValue();
                if (value != null) {
                    GuildHomeGuildInfoLayout guildHomeGuildInfoLayout = GuildHomeHeaderPart.this.guildTitleContainerInList;
                    if (guildHomeGuildInfoLayout == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("guildTitleContainerInList");
                        guildHomeGuildInfoLayout = null;
                    }
                    guildHomeGuildInfoLayout.i(value);
                }
            }
        };
        S1.observe(lifecycleOwner5, new Observer() { // from class: com.tencent.mobileqq.guild.home.parts.aj
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildHomeHeaderPart.ca(Function1.this, obj);
            }
        });
        LiveData<IGProGuildCheckinRsp> f26 = E9().getGuildCheckinViewModel().f2();
        LifecycleOwner lifecycleOwner6 = getPartHost().getLifecycleOwner();
        final Function1<IGProGuildCheckinRsp, Unit> function15 = new Function1<IGProGuildCheckinRsp, Unit>() { // from class: com.tencent.mobileqq.guild.home.parts.GuildHomeHeaderPart$initData$6
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(IGProGuildCheckinRsp iGProGuildCheckinRsp) {
                invoke2(iGProGuildCheckinRsp);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(IGProGuildCheckinRsp iGProGuildCheckinRsp) {
                if (iGProGuildCheckinRsp != null) {
                    GuildCheckinDialogFragment.a aVar = GuildCheckinDialogFragment.J;
                    FragmentManager supportFragmentManager = GuildHomeHeaderPart.this.x9().getSupportFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
                    String str = GuildHomeHeaderPart.this.z9().f227656e;
                    Intrinsics.checkNotNullExpressionValue(str, "facadeArgsData.guildId");
                    aVar.a(supportFragmentManager, str, iGProGuildCheckinRsp);
                }
            }
        };
        f26.observe(lifecycleOwner6, new Observer() { // from class: com.tencent.mobileqq.guild.home.parts.ak
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildHomeHeaderPart.da(Function1.this, obj);
            }
        });
        LiveData<cf1.b> toastEvent = E9().getGuildCheckinViewModel().getToastEvent();
        LifecycleOwner lifecycleOwner7 = getPartHost().getLifecycleOwner();
        final Function1<cf1.b, Unit> function16 = new Function1<cf1.b, Unit>() { // from class: com.tencent.mobileqq.guild.home.parts.GuildHomeHeaderPart$initData$7
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(cf1.b bVar) {
                invoke2(bVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(cf1.b bVar) {
                if (bVar != null) {
                    QQToast.makeText(GuildHomeHeaderPart.this.x9(), 1, bVar.f30774a, 1).show();
                }
            }
        };
        toastEvent.observe(lifecycleOwner7, new Observer() { // from class: com.tencent.mobileqq.guild.home.parts.al
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildHomeHeaderPart.ea(Function1.this, obj);
            }
        });
        GuildHomeCoverBelowList guildHomeCoverBelowList = this.coverBelow;
        if (guildHomeCoverBelowList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coverBelow");
            guildHomeCoverBelowList = null;
        }
        guildHomeCoverBelowList.post(new Runnable() { // from class: com.tencent.mobileqq.guild.home.parts.am
            @Override // java.lang.Runnable
            public final void run() {
                GuildHomeHeaderPart.ga(GuildHomeHeaderPart.this);
            }
        });
    }

    private final com.tencent.mobileqq.guild.home.subhome.g ja() {
        g.Companion companion = com.tencent.mobileqq.guild.home.subhome.g.INSTANCE;
        return new c("Guild.NewHome.GuildHomeHeaderPart", this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void la(GuildHomeHeaderPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.D9().i().e(view, this$0.E9().getGuildHomeTitleViewModel().e2().getValue());
        EventCollector.getInstance().onViewClicked(view);
    }

    public final void V9() {
        GuildHomeNavigationBarBubbleDecoration guildHomeNavigationBarBubbleDecoration = this.navigationBubbleDecoration;
        if (guildHomeNavigationBarBubbleDecoration == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navigationBubbleDecoration");
            guildHomeNavigationBarBubbleDecoration = null;
        }
        String str = z9().f227656e;
        Intrinsics.checkNotNullExpressionValue(str, "facadeArgsData.guildId");
        guildHomeNavigationBarBubbleDecoration.b(str);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        D9().j(requestCode, resultCode, data);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        View findViewById = rootView.findViewById(R.id.u_r);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.cover_below)");
        this.coverBelow = (GuildHomeCoverBelowList) findViewById;
        View findViewById2 = rootView.findViewById(R.id.f98755ny);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.title_recyclerview)");
        this.recyclerView = (RecyclerViewWithHeaderFooter) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.ulf);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.drag_frame_layout)");
        this.dragHost = (DragFrameLayout) findViewById3;
        View findViewById4 = rootView.findViewById(R.id.f915155d);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.id.system_window_anchor)");
        this.windowAnchor = (Space) findViewById4;
        ar1.h X9 = X9();
        DragFrameLayout dragFrameLayout = this.dragHost;
        GuildHomeNavigationBarBubbleDecoration guildHomeNavigationBarBubbleDecoration = null;
        if (dragFrameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dragHost");
            dragFrameLayout = null;
        }
        X9.a(dragFrameLayout);
        RecyclerViewWithHeaderFooter recyclerViewWithHeaderFooter = this.recyclerView;
        if (recyclerViewWithHeaderFooter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerViewWithHeaderFooter = null;
        }
        recyclerViewWithHeaderFooter.setLayoutManager(new LinearLayoutManager(getContext()));
        RecyclerViewWithHeaderFooter recyclerViewWithHeaderFooter2 = this.recyclerView;
        if (recyclerViewWithHeaderFooter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerViewWithHeaderFooter2 = null;
        }
        recyclerViewWithHeaderFooter2.setItemAnimator(null);
        Context context = rootView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "partHost.hostLifecycleOwner");
        this.headerBarsAdapter = new hp1.a(context, lifecycleOwner, new hp1.b(new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.home.parts.GuildHomeHeaderPart$onInitView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                GuildHomeHeaderPart.this.E9().getGuildHomeHeaderBarsViewModel().o2();
            }
        }, new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.home.parts.GuildHomeHeaderPart$onInitView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                GuildTextChannelListFragment.Companion companion = GuildTextChannelListFragment.f215265g0;
                Context context2 = GuildHomeHeaderPart.this.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "context");
                JumpGuildParam a16 = GuildHomeHeaderPart.this.z9().a();
                Intrinsics.checkNotNullExpressionValue(a16, "facadeArgsData.covert2JumpGuildParam()");
                companion.a(context2, a16);
            }
        }, new Function1<String, Unit>() { // from class: com.tencent.mobileqq.guild.home.parts.GuildHomeHeaderPart$onInitView$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String it) {
                ap1.a W9;
                ap1.a W92;
                Intrinsics.checkNotNullParameter(it, "it");
                IGProChannelInfo B = com.tencent.mobileqq.guild.util.ch.B(it);
                if (B != null) {
                    GuildHomeHeaderPart guildHomeHeaderPart = GuildHomeHeaderPart.this;
                    W9 = guildHomeHeaderPart.W9();
                    W9.a(guildHomeHeaderPart.z9());
                    W92 = guildHomeHeaderPart.W9();
                    Context context2 = guildHomeHeaderPart.getContext();
                    Intrinsics.checkNotNullExpressionValue(context2, "context");
                    W92.b(B, true, context2);
                    return;
                }
                com.tencent.mobileqq.guild.util.qqui.g.f(-1, "\u5b50\u9891\u9053\u4e0d\u5b58\u5728\u4e86");
            }
        }), X9());
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        GuildHomeGuildInfoLayout guildHomeGuildInfoLayout = new GuildHomeGuildInfoLayout(context2);
        guildHomeGuildInfoLayout.setId(R.id.f165534wi4);
        Space space = this.windowAnchor;
        if (space == null) {
            Intrinsics.throwUninitializedPropertyAccessException("windowAnchor");
            space = null;
        }
        guildHomeGuildInfoLayout.setWindowAnchor(space);
        this.guildTitleContainerInList = guildHomeGuildInfoLayout;
        guildHomeGuildInfoLayout.f(B9());
        GuildHomeGuildInfoLayout guildHomeGuildInfoLayout2 = this.guildTitleContainerInList;
        if (guildHomeGuildInfoLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildTitleContainerInList");
            guildHomeGuildInfoLayout2 = null;
        }
        guildHomeGuildInfoLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.home.parts.ae
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildHomeHeaderPart.la(GuildHomeHeaderPart.this, view);
            }
        });
        RecyclerViewWithHeaderFooter recyclerViewWithHeaderFooter3 = this.recyclerView;
        if (recyclerViewWithHeaderFooter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerViewWithHeaderFooter3 = null;
        }
        GuildHomeGuildInfoLayout guildHomeGuildInfoLayout3 = this.guildTitleContainerInList;
        if (guildHomeGuildInfoLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildTitleContainerInList");
            guildHomeGuildInfoLayout3 = null;
        }
        recyclerViewWithHeaderFooter3.D(guildHomeGuildInfoLayout3);
        RecyclerViewWithHeaderFooter recyclerViewWithHeaderFooter4 = this.recyclerView;
        if (recyclerViewWithHeaderFooter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerViewWithHeaderFooter4 = null;
        }
        hp1.a aVar = this.headerBarsAdapter;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("headerBarsAdapter");
            aVar = null;
        }
        recyclerViewWithHeaderFooter4.setAdapter(aVar);
        GuildFacadeType B9 = B9();
        hp1.a aVar2 = this.headerBarsAdapter;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("headerBarsAdapter");
            aVar2 = null;
        }
        this.navigationBubbleDecoration = new GuildHomeNavigationBarBubbleDecoration(B9, new GuildHomeHeaderPart$onInitView$6(aVar2));
        RecyclerViewWithHeaderFooter recyclerViewWithHeaderFooter5 = this.recyclerView;
        if (recyclerViewWithHeaderFooter5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerViewWithHeaderFooter5 = null;
        }
        GuildHomeNavigationBarBubbleDecoration guildHomeNavigationBarBubbleDecoration2 = this.navigationBubbleDecoration;
        if (guildHomeNavigationBarBubbleDecoration2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navigationBubbleDecoration");
        } else {
            guildHomeNavigationBarBubbleDecoration = guildHomeNavigationBarBubbleDecoration2;
        }
        recyclerViewWithHeaderFooter5.addItemDecoration(guildHomeNavigationBarBubbleDecoration);
        V9();
        ha();
        initData();
    }

    @Override // com.tencent.mobileqq.guild.home.parts.a, com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        A9().h(this.onStateUpdate);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        A9().C(this.onStateUpdate);
        ar1.h X9 = X9();
        DragFrameLayout dragFrameLayout = this.dragHost;
        if (dragFrameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dragHost");
            dragFrameLayout = null;
        }
        X9.b(dragFrameLayout);
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/home/parts/GuildHomeHeaderPart$b", "Lar1/h$b;", "", "b", "a", "Lzq1/e;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "c", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements h.b {
        b() {
        }

        @Override // ar1.h.b
        public void c(@NotNull zq1.e item) {
            List<String> listOf;
            Intrinsics.checkNotNullParameter(item, "item");
            if (item instanceof GuildChannelUnread) {
                Logger.f235387a.d().i("Guild.NewHome.GuildHomeHeaderPart", 1, "onRedPointDragged GuildChannelUnread: " + item);
                IRuntimeService S0 = com.tencent.mobileqq.guild.util.ch.S0(IGuildUnreadService.class, "");
                Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
                GuildChannelUnread guildChannelUnread = (GuildChannelUnread) item;
                String guildId = guildChannelUnread.getGuildId();
                listOf = CollectionsKt__CollectionsJVMKt.listOf(guildChannelUnread.getChannelUin());
                ((IGuildUnreadService) S0).setChannelRead(guildId, listOf, false);
                return;
            }
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "onRedPointDragged unknown item:" + item;
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.NewHome.GuildHomeHeaderPart", 1, (String) it.next(), null);
            }
        }

        @Override // ar1.h.b
        public void a() {
        }

        @Override // ar1.h.b
        public void b() {
        }
    }
}
