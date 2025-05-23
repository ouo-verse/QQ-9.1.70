package com.tencent.mobileqq.guild.feed.topic.part;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quipagetabbar.QUIPageTabBar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.component.GuildQUIPageTabBar;
import com.tencent.mobileqq.guild.feed.publish.publishV2.IFeedPublishServiceV2;
import com.tencent.mobileqq.guild.feed.topic.PageData;
import com.tencent.mobileqq.guild.feed.topic.TopicListFragment;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextContent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kn1.FeedPublishStateV2;
import kn1.a;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001c\u001dB\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0012\u0010\f\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016R\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/topic/part/TopicViewPagePart;", "Lcom/tencent/mobileqq/guild/feed/topic/part/TopicBasePart;", "Lkn1/b;", "state", "", "G9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "Landroidx/viewpager2/widget/ViewPager2;", tl.h.F, "Landroidx/viewpager2/widget/ViewPager2;", "mViewPage", "Lcom/tencent/mobileqq/guild/feed/topic/part/TopicViewPagePart$b;", "i", "Lcom/tencent/mobileqq/guild/feed/topic/part/TopicViewPagePart$b;", "mAdapter", "Lcom/tencent/mobileqq/guild/component/GuildQUIPageTabBar;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/component/GuildQUIPageTabBar;", "mPageTab", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "b", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class TopicViewPagePart extends TopicBasePart {

    @NotNull
    private static final List<PageData> D;
    private static final int E;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ViewPager2 mViewPage;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private b mAdapter;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private GuildQUIPageTabBar mPageTab;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/topic/part/TopicViewPagePart$b;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "", "getItemCount", "p", "Lcom/tencent/mobileqq/guild/feed/topic/TopicListFragment;", "i0", "Landroidx/fragment/app/Fragment;", "fragment", "<init>", "(Landroidx/fragment/app/Fragment;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends FragmentStateAdapter {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull Fragment fragment) {
            super(fragment);
            Intrinsics.checkNotNullParameter(fragment, "fragment");
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public int getNUM_BACKGOURND_ICON() {
            return TopicViewPagePart.D.size();
        }

        @Override // androidx.viewpager2.adapter.FragmentStateAdapter
        @NotNull
        /* renamed from: i0, reason: merged with bridge method [inline-methods] */
        public TopicListFragment createFragment(int p16) {
            return TopicListFragment.INSTANCE.a((PageData) TopicViewPagePart.D.get(p16));
        }
    }

    static {
        List<PageData> listOf;
        PageData.Companion companion = PageData.INSTANCE;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new PageData[]{companion.a(), companion.b()});
        D = listOf;
        E = listOf.indexOf(companion.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean G9(FeedPublishStateV2 state) {
        if (!Intrinsics.areEqual(String.valueOf(state.getStFeed().channelInfo.sign.guildId), z9().getGuildId())) {
            return false;
        }
        String topicNameRef = z9().getTopicNameRef();
        xn1.e eVar = xn1.e.f448187a;
        ArrayList<GProStRichTextContent> arrayList = state.getStFeed().contents.contents;
        Intrinsics.checkNotNullExpressionValue(arrayList, "state.stFeed.contents.contents");
        if (eVar.d(arrayList, z9().getTopicNameRef())) {
            return true;
        }
        Logger.f235387a.d().i("GTopic_TopicViewPagePart", 1, "filterPublishFeed isNotRelated topicName:" + topicNameRef);
        com.tencent.mobileqq.guild.util.qqui.g.f(2, getContext().getResources().getString(R.string.f143180ld));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9(TopicViewPagePart this$0, int i3, boolean z16) {
        Map mapOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z16) {
            List<PageData> list = D;
            if (i3 < list.size()) {
                GuildQUIPageTabBar guildQUIPageTabBar = this$0.mPageTab;
                GuildQUIPageTabBar guildQUIPageTabBar2 = null;
                if (guildQUIPageTabBar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPageTab");
                    guildQUIPageTabBar = null;
                }
                VideoReport.setElementId(guildQUIPageTabBar, "em_sgrp_forum_section");
                GuildQUIPageTabBar guildQUIPageTabBar3 = this$0.mPageTab;
                if (guildQUIPageTabBar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPageTab");
                } else {
                    guildQUIPageTabBar2 = guildQUIPageTabBar3;
                }
                mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_section_name", list.get(i3).getStr()));
                VideoReport.reportEvent("dt_clck", guildQUIPageTabBar2, mapOf);
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        FragmentActivity fragmentActivity;
        int collectionSizeOrDefault;
        int i3;
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Activity hostActivity = getPartHost().getHostActivity();
        if (hostActivity instanceof FragmentActivity) {
            fragmentActivity = (FragmentActivity) hostActivity;
        } else {
            fragmentActivity = null;
        }
        boolean z16 = true;
        if (fragmentActivity == null) {
            QLog.e("GTopic_TopicViewPagePart", 1, "activity is not FragmentActivity");
            return;
        }
        View findViewById = rootView.findViewById(R.id.f100415sf);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.topic_tab)");
        this.mPageTab = (GuildQUIPageTabBar) findViewById;
        View findViewById2 = rootView.findViewById(R.id.x2p);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.guild_topic_view_pager)");
        this.mViewPage = (ViewPager2) findViewById2;
        Fragment hostFragment = getHostFragment();
        Intrinsics.checkNotNullExpressionValue(hostFragment, "hostFragment");
        this.mAdapter = new b(hostFragment);
        ViewPager2 viewPager2 = this.mViewPage;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPage");
            viewPager2 = null;
        }
        b bVar = this.mAdapter;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            bVar = null;
        }
        viewPager2.setAdapter(bVar);
        if (GuildSplitViewUtils.f235370a.n(getActivity())) {
            ViewPager2 viewPager22 = this.mViewPage;
            if (viewPager22 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewPage");
                viewPager22 = null;
            }
            viewPager22.setSaveEnabled(false);
        }
        GuildQUIPageTabBar guildQUIPageTabBar = this.mPageTab;
        if (guildQUIPageTabBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPageTab");
            guildQUIPageTabBar = null;
        }
        List<PageData> list = D;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new GuildQUIPageTabBar.GuildQUIPagerTabData(((PageData) it.next()).getStr(), null));
        }
        guildQUIPageTabBar.setTabData(arrayList);
        ViewPager2 viewPager23 = this.mViewPage;
        if (viewPager23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPage");
            viewPager23 = null;
        }
        guildQUIPageTabBar.bindViewPager2(viewPager23);
        GuildQUIPageTabBar guildQUIPageTabBar2 = this.mPageTab;
        if (guildQUIPageTabBar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPageTab");
            guildQUIPageTabBar2 = null;
        }
        guildQUIPageTabBar2.setTabChangeListener(new QUIPageTabBar.i() { // from class: com.tencent.mobileqq.guild.feed.topic.part.s
            @Override // com.tencent.biz.qui.quipagetabbar.QUIPageTabBar.i
            public final void I0(int i16, boolean z17) {
                TopicViewPagePart.H9(TopicViewPagePart.this, i16, z17);
            }
        });
        Bundle b16 = com.tencent.mobileqq.guild.feed.part.a.b(this);
        if (b16 == null || !b16.containsKey("VIEW_PAGER_CURRENT_ITEM")) {
            z16 = false;
        }
        if (z16) {
            Bundle b17 = com.tencent.mobileqq.guild.feed.part.a.b(this);
            if (b17 != null) {
                i3 = b17.getInt("VIEW_PAGER_CURRENT_ITEM");
            } else {
                i3 = 0;
            }
            ViewPager2 viewPager24 = this.mViewPage;
            if (viewPager24 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewPage");
                viewPager24 = null;
            }
            viewPager24.setCurrentItem(i3, false);
        }
        final Flow<a.FeedPublishBegin> publishBeginFlow = ((IFeedPublishServiceV2) ch.R0(IFeedPublishServiceV2.class)).publishBeginFlow();
        FlowKt.launchIn(FlowKt.onEach(new Flow<a.FeedPublishBegin>() { // from class: com.tencent.mobileqq.guild.feed.topic.part.TopicViewPagePart$onInitView$$inlined$filter$1

            @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\b"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$lambda-1$$inlined$collect$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 1, mv = {1, 7, 1}, xi = 48)
            /* renamed from: com.tencent.mobileqq.guild.feed.topic.part.TopicViewPagePart$onInitView$$inlined$filter$1$2, reason: invalid class name */
            /* loaded from: classes13.dex */
            public static final class AnonymousClass2 implements FlowCollector<a.FeedPublishBegin> {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ FlowCollector f223701d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ TopicViewPagePart f223702e;

                @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                @DebugMetadata(c = "com.tencent.mobileqq.guild.feed.topic.part.TopicViewPagePart$onInitView$$inlined$filter$1$2", f = "TopicViewPagePart.kt", i = {}, l = {136}, m = "emit", n = {}, s = {})
                /* renamed from: com.tencent.mobileqq.guild.feed.topic.part.TopicViewPagePart$onInitView$$inlined$filter$1$2$1, reason: invalid class name */
                /* loaded from: classes13.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    Object L$1;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, TopicViewPagePart topicViewPagePart) {
                    this.f223701d = flowCollector;
                    this.f223702e = topicViewPagePart;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                @Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public Object emit(a.FeedPublishBegin feedPublishBegin, @NotNull Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    Object coroutine_suspended;
                    int i3;
                    boolean G9;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        int i16 = anonymousClass1.label;
                        if ((i16 & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label = i16 - Integer.MIN_VALUE;
                            Object obj = anonymousClass1.result;
                            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            i3 = anonymousClass1.label;
                            if (i3 == 0) {
                                if (i3 == 1) {
                                    ResultKt.throwOnFailure(obj);
                                } else {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                            } else {
                                ResultKt.throwOnFailure(obj);
                                FlowCollector flowCollector = this.f223701d;
                                G9 = this.f223702e.G9(feedPublishBegin.getState());
                                if (G9) {
                                    anonymousClass1.label = 1;
                                    if (flowCollector.emit(feedPublishBegin, anonymousClass1) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    anonymousClass1 = new AnonymousClass1(continuation);
                    Object obj2 = anonymousClass1.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i3 = anonymousClass1.label;
                    if (i3 == 0) {
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @Nullable
            public Object collect(@NotNull FlowCollector<? super a.FeedPublishBegin> flowCollector, @NotNull Continuation continuation) {
                Object coroutine_suspended;
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, this), continuation);
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (collect == coroutine_suspended) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        }, new TopicViewPagePart$onInitView$4(this, null)), com.tencent.mobileqq.guild.feed.part.a.d(this));
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        if (GuildSplitViewUtils.f235370a.n(activity)) {
            Bundle b16 = com.tencent.mobileqq.guild.feed.part.a.b(this);
            if (b16 != null) {
                ViewPager2 viewPager2 = this.mViewPage;
                if (viewPager2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewPage");
                    viewPager2 = null;
                }
                b16.putInt("VIEW_PAGER_CURRENT_ITEM", viewPager2.getCurrentItem());
            }
            ViewPager2 viewPager22 = this.mViewPage;
            if (viewPager22 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewPage");
                viewPager22 = null;
            }
            viewPager22.setAdapter(null);
        }
        super.onPartDestroy(activity);
    }
}
