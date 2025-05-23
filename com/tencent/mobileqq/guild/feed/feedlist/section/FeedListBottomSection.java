package com.tencent.mobileqq.guild.feed.feedlist.section;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.guild.api.FeedListSectionType;
import com.tencent.mobileqq.guild.feed.feedlist.section.FeedListBottomSection;
import com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedBottomComponents;
import com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedPostFailedEditComponents;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.data.GProStFeedDetailRspWrapper;
import com.tencent.mobileqq.guild.feed.publish.bean.GuildTaskProgressState;
import com.tencent.mobileqq.guild.feed.util.GuildFeedBottomSectionHelper;
import com.tencent.mobileqq.guild.feed.util.bn;
import com.tencent.mobileqq.guild.mainframe.GuildFeedReportSourceInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.common.EventAgingType;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProFeedEntry;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rj1.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \"*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u00032\b\u0012\u0004\u0012\u00020\u00050\u0004:\u00018B\u0007\u00a2\u0006\u0004\b6\u00107J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0005H\u0002J\n\u0010\f\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\r\u001a\u00020\nH\u0002J\b\u0010\u000e\u001a\u00020\u0006H\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0014J\u0012\u0010\u0013\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0014J0\u0010\u001b\u001a\u00020\u00062\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00142\u0006\u0010\u0017\u001a\u00020\u00162\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018H\u0014J\u0012\u0010\u001c\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\nH\u0016R\u001a\u0010$\u001a\u00020\u001f8\u0014X\u0094\u0004\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001a\u0010)\u001a\u00060%j\u0002`&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u001b\u0010/\u001a\u00020*8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u0016\u00102\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\r\u00101R\u0014\u00105\u001a\u0002038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u00104\u00a8\u00069"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedlist/section/FeedListBottomSection;", "Lrj1/b;", "Ext", "Ltk1/a;", "Landroidx/lifecycle/Observer;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "", "N", "M", "newStFeed", "", "K", "J", UserInfo.SEX_FEMALE, "O", "", "getViewStubLayoutId", "Landroid/view/View;", "initContainerView", "onInitView", "Ltk1/c;", "bindData", "", "position", "", "", "payload", "u", "L", "attached", "onAttachedChanged", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedBottomComponents$b;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedBottomComponents$b;", "H", "()Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedBottomComponents$b;", "depends", "Lqj1/h;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/data/IFeedMainDisplayable;", "D", "Lqj1/h;", "lastFeedInfo", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedBottomComponents;", "E", "Lkotlin/Lazy;", "G", "()Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedBottomComponents;", "components", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedPostFailedEditComponents;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedPostFailedEditComponents;", "postFailedEditComponents", "Lcom/tencent/mobileqq/guild/feed/util/GuildFeedBottomSectionHelper;", "Lcom/tencent/mobileqq/guild/feed/util/GuildFeedBottomSectionHelper;", "bottomSectionHelper", "<init>", "()V", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public class FeedListBottomSection<Ext extends rj1.b> extends tk1.a<Ext> implements Observer<GProStFeed> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final GuildFeedBottomComponents.b depends;

    /* renamed from: D, reason: from kotlin metadata */
    private qj1.h lastFeedInfo;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy components;

    /* renamed from: F, reason: from kotlin metadata */
    private GuildFeedPostFailedEditComponents postFailedEditComponents;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final GuildFeedBottomSectionHelper bottomSectionHelper;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J \u0010\r\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u0006H\u0016\u00a8\u0006\u0011"}, d2 = {"com/tencent/mobileqq/guild/feed/feedlist/section/FeedListBottomSection$b", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedBottomComponents$b;", "", "b", "d", "g", "", "isEnable", "e", "Landroid/view/View;", "share", "comment", "prefer", "c", "", "a", "f", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements GuildFeedBottomComponents.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FeedListBottomSection<Ext> f218584a;

        b(FeedListBottomSection<Ext> feedListBottomSection) {
            this.f218584a = feedListBottomSection;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Map i(FeedListBottomSection this$0, String str) {
            int i3;
            Map mapOf;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Pair[] pairArr = new Pair[2];
            int i16 = 0;
            if (this$0.r().getPreferStatus() == 1) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            pairArr[0] = TuplesKt.to("sgrp_state", Integer.valueOf(i3));
            if (this$0.r().getPreferStatus() == 1) {
                i16 = 1;
            }
            pairArr[1] = TuplesKt.to("sgrp_action_result", Integer.valueOf(i16));
            mapOf = MapsKt__MapsKt.mapOf(pairArr);
            return mapOf;
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedBottomComponents.b
        public int a() {
            return 0;
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedBottomComponents.b
        public void b() {
            this.f218584a.M();
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedBottomComponents.b
        public void c(@NotNull View share, @NotNull View comment, @NotNull View prefer) {
            Intrinsics.checkNotNullParameter(share, "share");
            Intrinsics.checkNotNullParameter(comment, "comment");
            Intrinsics.checkNotNullParameter(prefer, "prefer");
            EventAgingType eventAgingType = EventAgingType.REALTIME;
            VideoReport.setEventType(share, eventAgingType);
            String str = this.f218584a.r().hashCode() + "#" + share.hashCode();
            ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_NONE;
            if1.a.b(share, "em_sgrp_forum_share", str, null, exposurePolicy, null, null, null, null, 244, null);
            VideoReport.setEventType(comment, eventAgingType);
            if1.a.b(comment, "em_sgrp_forum_comment", this.f218584a.r().hashCode() + "#" + comment.hashCode(), null, exposurePolicy, null, null, null, null, 244, null);
            VideoReport.setEventType(prefer, eventAgingType);
            String str2 = this.f218584a.r().hashCode() + "#" + prefer.hashCode();
            final FeedListBottomSection<Ext> feedListBottomSection = this.f218584a;
            if1.a.b(prefer, "em_sgrp_forum_up", str2, null, null, null, null, null, new IDynamicParams() { // from class: com.tencent.mobileqq.guild.feed.feedlist.section.a
                @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
                public final Map getDynamicParams(String str3) {
                    Map i3;
                    i3 = FeedListBottomSection.b.i(FeedListBottomSection.this, str3);
                    return i3;
                }
            }, 124, null);
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedBottomComponents.b
        public void d() {
            this.f218584a.N();
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedBottomComponents.b
        public boolean e() {
            return false;
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedBottomComponents.b
        public boolean f() {
            return false;
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedBottomComponents.b
        public void g() {
            if (this.f218584a.F()) {
                return;
            }
            this.f218584a.O();
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedBottomComponents.b
        public boolean isEnable() {
            return true;
        }
    }

    public FeedListBottomSection() {
        super(FeedListSectionType.Bottom);
        Lazy lazy;
        this.depends = new b(this);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GuildFeedBottomComponents>(this) { // from class: com.tencent.mobileqq.guild.feed.feedlist.section.FeedListBottomSection$components$2
            final /* synthetic */ FeedListBottomSection<Ext> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildFeedBottomComponents invoke() {
                return new GuildFeedBottomComponents(this.this$0.getDepends());
            }
        });
        this.components = lazy;
        GuildFeedBottomSectionHelper guildFeedBottomSectionHelper = new GuildFeedBottomSectionHelper();
        guildFeedBottomSectionHelper.u("FeedListBottomSection");
        this.bottomSectionHelper = guildFeedBottomSectionHelper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean F() {
        return bn.f223895a.d(((rj1.b) s()).e());
    }

    private final GuildFeedBottomComponents G() {
        return (GuildFeedBottomComponents) this.components.getValue();
    }

    private final GProStFeed J() {
        Object a16 = r().a();
        if (a16 instanceof GProStFeed) {
            return (GProStFeed) a16;
        }
        return null;
    }

    private final boolean K(GProStFeed newStFeed) {
        qj1.h hVar = this.lastFeedInfo;
        if (hVar != null) {
            String str = newStFeed.idd;
            if (hVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("lastFeedInfo");
                hVar = null;
            }
            if (Intrinsics.areEqual(str, hVar.getFeedId())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M() {
        if (F()) {
            return;
        }
        if (r().getCommentCount() > 0) {
            rj1.a.f431544a.f(this, J());
            return;
        }
        rj1.a aVar = rj1.a.f431544a;
        View rootView = getRootView();
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        aVar.g(rootView, r(), (rj1.b) s());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N() {
        int collectionSizeOrDefault;
        GuildFeedReportSourceInfo guildFeedReportSourceInfo = new GuildFeedReportSourceInfo();
        List<GProFeedEntry> f16 = yl1.i.f450608a.f();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(f16, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (GProFeedEntry gProFeedEntry : f16) {
            guildFeedReportSourceInfo.addReportItem(gProFeedEntry.key, gProFeedEntry.value);
            arrayList.add(Unit.INSTANCE);
        }
        this.bottomSectionHelper.p(guildFeedReportSourceInfo);
        G().n(r());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: H, reason: from getter */
    public GuildFeedBottomComponents.b getDepends() {
        return this.depends;
    }

    @Override // androidx.lifecycle.Observer
    /* renamed from: L, reason: merged with bridge method [inline-methods] */
    public void onChanged(@Nullable GProStFeed newStFeed) {
        if (newStFeed != null && K(newStFeed)) {
            qj1.h hVar = null;
            this.lastFeedInfo = new GProStFeedDetailRspWrapper(newStFeed, 0 == true ? 1 : 0, 2, 0 == true ? 1 : 0);
            GuildFeedBottomSectionHelper guildFeedBottomSectionHelper = this.bottomSectionHelper;
            guildFeedBottomSectionHelper.w(newStFeed);
            qj1.h hVar2 = this.lastFeedInfo;
            if (hVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("lastFeedInfo");
                hVar2 = null;
            }
            guildFeedBottomSectionHelper.t(hVar2);
            GuildFeedBottomComponents G = G();
            qj1.h hVar3 = this.lastFeedInfo;
            if (hVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("lastFeedInfo");
            } else {
                hVar = hVar3;
            }
            G.n(hVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return G().i();
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onAttachedChanged(boolean attached) {
        GProStFeed J = J();
        if (J != null && !TextUtils.isEmpty(J.idd)) {
            if (attached) {
                jj1.b.c().observerGlobalState(J, this);
            } else {
                jj1.b.c().removeObserverGlobalState(J, this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tk1.a, com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@Nullable View initContainerView) {
        super.onInitView(initContainerView);
        GuildFeedBottomComponents G = G();
        View rootView = getRootView();
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        G.o(rootView);
        GuildFeedBottomSectionHelper guildFeedBottomSectionHelper = this.bottomSectionHelper;
        Context context = getRootView().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
        guildFeedBottomSectionHelper.s(context);
        View rootView2 = getRootView();
        Intrinsics.checkNotNullExpressionValue(rootView2, "rootView");
        this.postFailedEditComponents = new GuildFeedPostFailedEditComponents(rootView2, new Function0<Unit>(this) { // from class: com.tencent.mobileqq.guild.feed.feedlist.section.FeedListBottomSection$onInitView$1
            final /* synthetic */ FeedListBottomSection<Ext> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                GuildFeedBottomSectionHelper guildFeedBottomSectionHelper2;
                guildFeedBottomSectionHelper2 = ((FeedListBottomSection) this.this$0).bottomSectionHelper;
                guildFeedBottomSectionHelper2.n();
            }
        }, new Function0<Unit>(this) { // from class: com.tencent.mobileqq.guild.feed.feedlist.section.FeedListBottomSection$onInitView$2
            final /* synthetic */ FeedListBottomSection<Ext> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                GuildFeedBottomSectionHelper guildFeedBottomSectionHelper2;
                guildFeedBottomSectionHelper2 = ((FeedListBottomSection) this.this$0).bottomSectionHelper;
                guildFeedBottomSectionHelper2.o();
            }
        }, new Function0<Unit>(this) { // from class: com.tencent.mobileqq.guild.feed.feedlist.section.FeedListBottomSection$onInitView$3
            final /* synthetic */ FeedListBottomSection<Ext> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                GuildFeedBottomSectionHelper guildFeedBottomSectionHelper2;
                guildFeedBottomSectionHelper2 = ((FeedListBottomSection) this.this$0).bottomSectionHelper;
                guildFeedBottomSectionHelper2.q();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tk1.a, com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: u */
    public void onBindData(@Nullable tk1.c<Ext> bindData, int position, @Nullable List<Object> payload) {
        super.onBindData(bindData, position, payload);
        GuildTaskProgressState c16 = ((rj1.b) s()).c();
        this.bottomSectionHelper.x(c16);
        GProStFeed J = J();
        GuildFeedPostFailedEditComponents guildFeedPostFailedEditComponents = null;
        byte b16 = 0;
        byte b17 = 0;
        if (J != null) {
            this.lastFeedInfo = new GProStFeedDetailRspWrapper(J, b17 == true ? 1 : 0, 2, b16 == true ? 1 : 0);
            this.bottomSectionHelper.w(J);
            GuildFeedBottomSectionHelper guildFeedBottomSectionHelper = this.bottomSectionHelper;
            qj1.h hVar = this.lastFeedInfo;
            if (hVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("lastFeedInfo");
                hVar = null;
            }
            guildFeedBottomSectionHelper.t(hVar);
        }
        G().m(r(), position, payload);
        boolean z16 = false;
        if (c16 != null && kn1.c.a(c16)) {
            z16 = true;
        }
        GuildFeedPostFailedEditComponents guildFeedPostFailedEditComponents2 = this.postFailedEditComponents;
        if (guildFeedPostFailedEditComponents2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("postFailedEditComponents");
        } else {
            guildFeedPostFailedEditComponents = guildFeedPostFailedEditComponents2;
        }
        guildFeedPostFailedEditComponents.g(z16);
    }

    public void O() {
    }
}
