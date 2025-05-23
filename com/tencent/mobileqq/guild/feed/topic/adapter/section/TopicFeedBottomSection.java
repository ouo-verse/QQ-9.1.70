package com.tencent.mobileqq.guild.feed.topic.adapter.section;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.core.util.Supplier;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Observer;
import com.tencent.biz.richframework.adapter.section.SectionIOCKt;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedBottomComponents;
import com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedPostFailedEditComponents;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.data.GProStFeedDetailRspWrapper;
import com.tencent.mobileqq.guild.feed.publish.bean.GuildTaskProgressState;
import com.tencent.mobileqq.guild.feed.topic.adapter.section.TopicFeedBottomSection;
import com.tencent.mobileqq.guild.feed.util.GuildFeedBottomSectionHelper;
import com.tencent.mobileqq.guild.feed.util.bn;
import com.tencent.mobileqq.guild.mainframe.GuildFeedReportSourceInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.common.EventAgingType;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProFeedEntry;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
import zp1.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 02\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00040\u0003:\u00011B\u0007\u00a2\u0006\u0004\b.\u0010/J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0004H\u0002J\u0012\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u0002H\u0002J\b\u0010\u000e\u001a\u00020\nH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0014J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011H\u0014J(\u0010\u0019\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00142\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016H\u0014J\u0012\u0010\u001a\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\nH\u0016R\u001a\u0010!\u001a\u00060\u001dj\u0002`\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/topic/adapter/section/TopicFeedBottomSection;", "Lcom/tencent/mobileqq/guild/feed/topic/adapter/section/b;", "Lvn1/b;", "Landroidx/lifecycle/Observer;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "", BdhLogUtil.LogTag.Tag_Conn, "B", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "newStFeed", "", HippyTKDListViewAdapter.X, "data", "w", "v", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "", "position", "", "", "payload", "y", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "attached", "onAttachedChanged", "Lqj1/h;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/data/IFeedMainDisplayable;", "d", "Lqj1/h;", "lastFeedInfo", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedBottomComponents;", "e", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedBottomComponents;", "components", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedPostFailedEditComponents;", "f", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedPostFailedEditComponents;", "postFailedEditComponents", "Lcom/tencent/mobileqq/guild/feed/util/GuildFeedBottomSectionHelper;", tl.h.F, "Lcom/tencent/mobileqq/guild/feed/util/GuildFeedBottomSectionHelper;", "bottomSectionHelper", "<init>", "()V", "i", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class TopicFeedBottomSection extends com.tencent.mobileqq.guild.feed.topic.adapter.section.b<vn1.b> implements Observer<GProStFeed> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private qj1.h lastFeedInfo;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildFeedBottomComponents components = new GuildFeedBottomComponents(new b());

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private GuildFeedPostFailedEditComponents postFailedEditComponents;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildFeedBottomSectionHelper bottomSectionHelper;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J \u0010\r\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u0006H\u0016\u00a8\u0006\u0011"}, d2 = {"com/tencent/mobileqq/guild/feed/topic/adapter/section/TopicFeedBottomSection$b", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedBottomComponents$b;", "", "b", "d", "g", "", "isEnable", "e", "Landroid/view/View;", "share", "comment", "prefer", "c", "", "a", "f", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements GuildFeedBottomComponents.b {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Map i(TopicFeedBottomSection this$0, String str) {
            int i3;
            Map mapOf;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Pair[] pairArr = new Pair[2];
            int i16 = 0;
            if (((vn1.b) ((Section) this$0).mData).d().getPreferStatus() == 1) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            pairArr[0] = TuplesKt.to("sgrp_state", Integer.valueOf(i3));
            if (((vn1.b) ((Section) this$0).mData).d().getPreferStatus() == 1) {
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
            TopicFeedBottomSection.this.A();
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedBottomComponents.b
        public void c(@NotNull View share, @NotNull View comment, @NotNull View prefer) {
            Intrinsics.checkNotNullParameter(share, "share");
            Intrinsics.checkNotNullParameter(comment, "comment");
            Intrinsics.checkNotNullParameter(prefer, "prefer");
            EventAgingType eventAgingType = EventAgingType.REALTIME;
            VideoReport.setEventType(share, eventAgingType);
            String str = ((vn1.b) ((Section) TopicFeedBottomSection.this).mData).hashCode() + "#" + share.hashCode();
            ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_NONE;
            if1.a.b(share, "em_sgrp_forum_share", str, null, exposurePolicy, null, null, null, null, 244, null);
            VideoReport.setEventType(comment, eventAgingType);
            if1.a.b(comment, "em_sgrp_forum_comment", ((vn1.b) ((Section) TopicFeedBottomSection.this).mData).hashCode() + "#" + comment.hashCode(), null, exposurePolicy, null, null, null, null, 244, null);
            VideoReport.setEventType(prefer, eventAgingType);
            String str2 = ((vn1.b) ((Section) TopicFeedBottomSection.this).mData).hashCode() + "#" + prefer.hashCode();
            final TopicFeedBottomSection topicFeedBottomSection = TopicFeedBottomSection.this;
            if1.a.b(prefer, "em_sgrp_forum_up", str2, null, null, null, null, null, new IDynamicParams() { // from class: com.tencent.mobileqq.guild.feed.topic.adapter.section.f
                @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
                public final Map getDynamicParams(String str3) {
                    Map i3;
                    i3 = TopicFeedBottomSection.b.i(TopicFeedBottomSection.this, str3);
                    return i3;
                }
            }, 124, null);
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedBottomComponents.b
        public void d() {
            TopicFeedBottomSection.this.B();
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedBottomComponents.b
        public boolean e() {
            boolean z16;
            if (!((vn1.b) ((Section) TopicFeedBottomSection.this).mData).d().w()) {
                return false;
            }
            GuildTaskProgressState taskProgressState = ((vn1.b) ((Section) TopicFeedBottomSection.this).mData).getTaskProgressState();
            if (taskProgressState != null && kn1.c.a(taskProgressState)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16 || !bn.h(false, true)) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedBottomComponents.b
        public boolean f() {
            return false;
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedBottomComponents.b
        public void g() {
            TopicFeedBottomSection.this.C();
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedBottomComponents.b
        public boolean isEnable() {
            boolean z16;
            GuildTaskProgressState taskProgressState = ((vn1.b) ((Section) TopicFeedBottomSection.this).mData).getTaskProgressState();
            if (taskProgressState != null && kn1.c.a(taskProgressState)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16 || !((vn1.b) ((Section) TopicFeedBottomSection.this).mData).d().w()) {
                return true;
            }
            return false;
        }
    }

    public TopicFeedBottomSection() {
        GuildFeedBottomSectionHelper guildFeedBottomSectionHelper = new GuildFeedBottomSectionHelper();
        guildFeedBottomSectionHelper.u("TopicFeedBottomSection");
        this.bottomSectionHelper = guildFeedBottomSectionHelper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void A() {
        if (v()) {
            return;
        }
        if (((vn1.b) this.mData).d().getCommentCount() > 0) {
            xn1.e eVar = xn1.e.f448187a;
            T mData = this.mData;
            Intrinsics.checkNotNullExpressionValue(mData, "mData");
            eVar.i(this, w((vn1.b) mData));
            return;
        }
        xn1.e eVar2 = xn1.e.f448187a;
        View rootView = getRootView();
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        T mData2 = this.mData;
        Intrinsics.checkNotNullExpressionValue(mData2, "mData");
        eVar2.j(rootView, (vn1.b) mData2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void B() {
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
        this.components.n(((vn1.b) this.mData).d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C() {
        com.tencent.mobileqq.guild.feed.topic.a aVar;
        if (v() || (aVar = (com.tencent.mobileqq.guild.feed.topic.a) SectionIOCKt.getIocInterface(this, com.tencent.mobileqq.guild.feed.topic.a.class)) == null) {
            return;
        }
        zp1.a<vn1.b> b16 = aVar.b();
        int i3 = this.mPosition;
        T mData = this.mData;
        Intrinsics.checkNotNullExpressionValue(mData, "mData");
        a.C11708a.a(b16, i3, mData, new Supplier() { // from class: com.tencent.mobileqq.guild.feed.topic.adapter.section.e
            @Override // androidx.core.util.Supplier
            public final Object get() {
                Map D;
                D = TopicFeedBottomSection.D();
                return D;
            }
        }, 0, 8, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map D() {
        Map emptyMap;
        emptyMap = MapsKt__MapsKt.emptyMap();
        return emptyMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean v() {
        bn bnVar = bn.f223895a;
        T mData = this.mData;
        Intrinsics.checkNotNullExpressionValue(mData, "mData");
        return bnVar.g((vn1.b) mData);
    }

    private final GProStFeed w(vn1.b data) {
        Object a16 = data.d().a();
        if (a16 instanceof GProStFeed) {
            return (GProStFeed) a16;
        }
        return null;
    }

    private final boolean x(GProStFeed newStFeed) {
        qj1.h hVar;
        if (this.mData != 0 && (hVar = this.lastFeedInfo) != null) {
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return this.components.i();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onAttachedChanged(boolean attached) {
        T mData = this.mData;
        Intrinsics.checkNotNullExpressionValue(mData, "mData");
        GProStFeed w3 = w((vn1.b) mData);
        if (w3 != null && !TextUtils.isEmpty(w3.idd)) {
            if (attached) {
                jj1.b.c().observerGlobalState(w3, this);
            } else {
                jj1.b.c().removeObserverGlobalState(w3, this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@NotNull View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        this.components.o(containerView);
        GuildFeedBottomSectionHelper guildFeedBottomSectionHelper = this.bottomSectionHelper;
        Context context = getRootView().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
        guildFeedBottomSectionHelper.s(context);
        this.postFailedEditComponents = new GuildFeedPostFailedEditComponents(containerView, new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.feed.topic.adapter.section.TopicFeedBottomSection$onInitView$1
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
                GuildFeedBottomSectionHelper guildFeedBottomSectionHelper2;
                guildFeedBottomSectionHelper2 = TopicFeedBottomSection.this.bottomSectionHelper;
                guildFeedBottomSectionHelper2.n();
            }
        }, new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.feed.topic.adapter.section.TopicFeedBottomSection$onInitView$2
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
                GuildFeedBottomSectionHelper guildFeedBottomSectionHelper2;
                guildFeedBottomSectionHelper2 = TopicFeedBottomSection.this.bottomSectionHelper;
                guildFeedBottomSectionHelper2.o();
            }
        }, new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.feed.topic.adapter.section.TopicFeedBottomSection$onInitView$3
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
                GuildFeedBottomSectionHelper guildFeedBottomSectionHelper2;
                guildFeedBottomSectionHelper2 = TopicFeedBottomSection.this.bottomSectionHelper;
                guildFeedBottomSectionHelper2.q();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void onBindData(@NotNull vn1.b data, int position, @Nullable List<Object> payload) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.bottomSectionHelper.x(data.getTaskProgressState());
        GProStFeed w3 = w(data);
        GuildFeedPostFailedEditComponents guildFeedPostFailedEditComponents = null;
        byte b16 = 0;
        byte b17 = 0;
        if (w3 != null) {
            this.lastFeedInfo = new GProStFeedDetailRspWrapper(w3, b17 == true ? 1 : 0, 2, b16 == true ? 1 : 0);
            this.bottomSectionHelper.w(w3);
            GuildFeedBottomSectionHelper guildFeedBottomSectionHelper = this.bottomSectionHelper;
            qj1.h hVar = this.lastFeedInfo;
            if (hVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("lastFeedInfo");
                hVar = null;
            }
            guildFeedBottomSectionHelper.t(hVar);
        }
        this.components.m(data.d(), position, payload);
        GuildTaskProgressState taskProgressState = data.getTaskProgressState();
        boolean z16 = false;
        if (taskProgressState != null && kn1.c.a(taskProgressState)) {
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

    @Override // androidx.lifecycle.Observer
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void onChanged(@Nullable GProStFeed newStFeed) {
        if (newStFeed != null && x(newStFeed)) {
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
            GuildFeedBottomComponents guildFeedBottomComponents = this.components;
            qj1.h hVar3 = this.lastFeedInfo;
            if (hVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("lastFeedInfo");
            } else {
                hVar = hVar3;
            }
            guildFeedBottomComponents.n(hVar);
        }
    }
}
