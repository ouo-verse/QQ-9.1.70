package com.tencent.mobileqq.guild.feed.nativedetail.content.part;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.PartIOCKt;
import com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegatesManager;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.feed.feedsquare.data.GuildFeedPublishInfo;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.event.FeedConfigurationChangeEvent;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.event.FeedContentScrollEvent;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.event.PageOpenAnimationEvent;
import com.tencent.mobileqq.guild.feed.nativedetail.content.model.DataChangedState;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl1.g;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00c6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\t*\u0004aeim\u0018\u0000 s2\u00020\u0001:\u0001tB\u001b\u0012\u0012\u0010B\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020?0>0=\u00a2\u0006\u0004\bq\u0010rJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\n\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\b\u0010\r\u001a\u00020\tH\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\tH\u0002J\b\u0010\u0011\u001a\u00020\u000fH\u0002J\b\u0010\u0012\u001a\u00020\tH\u0002J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0005H\u0002J\u0012\u0010\u0017\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002J\u0012\u0010\u0018\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002J\u0010\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u0012\u0010\u001e\u001a\u00020\u000f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0015H\u0002J\u0012\u0010 \u001a\u00020\u000f2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0015H\u0002J$\u0010$\u001a\u00020\u000f2\u001a\u0010#\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00150\"0!H\u0002J\u001e\u0010&\u001a\u00020\u00022\u0014\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00150\"H\u0002J\u0010\u0010(\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020'H\u0002J$\u0010+\u001a\u00020\u000f2\u001a\u0010*\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00150\"0)H\u0002J\u0012\u0010-\u001a\u00020\u000f2\b\u0010,\u001a\u0004\u0018\u00010\u0015H\u0002J\u001a\u0010/\u001a\u00020\u000f2\u0006\u0010.\u001a\u00020\t2\b\u0010,\u001a\u0004\u0018\u00010\u0015H\u0002J\b\u00100\u001a\u00020\tH\u0002J\b\u00101\u001a\u00020\tH\u0002J\u0012\u00102\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u00105\u001a\u00020\u000f2\b\u00104\u001a\u0004\u0018\u0001032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u00108\u001a\u00020\u000f2\b\u00107\u001a\u0004\u0018\u000106H\u0016J\u001e\u00109\u001a\u0004\u0018\u00010\u00152\b\u00104\u001a\u0004\u0018\u0001032\b\u0010\u001d\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010<\u001a\u00020\u000f2\b\u0010;\u001a\u0004\u0018\u00010:H\u0016R \u0010B\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020?0>0=8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010F\u001a\u00020C8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010J\u001a\u00020G8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010N\u001a\u00020K8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010R\u001a\u00020O8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0018\u0010V\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010Y\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010XR(\u0010\\\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00150\"0)8CX\u0082\u0004\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u0016\u0010`\u001a\u00020]8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b^\u0010_R\u0014\u0010d\u001a\u00020a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bb\u0010cR\u0014\u0010h\u001a\u00020e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bf\u0010gR\u0014\u0010l\u001a\u00020i8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bj\u0010kR\u0016\u0010p\u001a\u00020m8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bn\u0010o\u00a8\u0006u"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/part/s;", "Lcom/tencent/biz/richframework/part/Part;", "", "Z9", "H9", "Landroid/view/View;", "view", "G9", "ea", "", com.tencent.luggage.wxa.c8.c.G, "L9", "W9", "K9", "newState", "", "ca", "aa", "O9", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "X9", "", "args", "P9", "V9", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "I9", "msg", "U9", "message", "Q9", "Ljava/util/LinkedList;", "Lkotlin/Pair;", "list", "ba", "pair", "Y9", "Ltl1/g$l;", "ga", "Ljava/util/Queue;", "changeSourceList", "J9", "payload", "S9", "dataChangedSource", "da", "N9", "M9", "onInitView", "", "action", "handleBroadcastMessage", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "getMessage", "Landroid/content/res/Configuration;", "configuration", "onConfigurationChanged", "Lcom/tencent/biz/richframework/part/adapter/delegate/AdapterDelegatesManager;", "", "Lhl1/g;", "d", "Lcom/tencent/biz/richframework/part/adapter/delegate/AdapterDelegatesManager;", "contentDelegatesManager", "Landroidx/recyclerview/widget/RecyclerView;", "e", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "f", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "concatAdapter", "Lhl1/f;", tl.h.F, "Lhl1/f;", "contentAdapter", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "i", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "detailRecycledViewPool", "Landroidx/recyclerview/widget/RecyclerView$ItemAnimator;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/recyclerview/widget/RecyclerView$ItemAnimator;", "defaultAnimator", BdhLogUtil.LogTag.Tag_Conn, "Z", "commentDataLoaded", "D", "Ljava/util/Queue;", "submitCallbackClosureQueue", "Lcom/tencent/biz/richframework/part/block/base/SafeLinearLayoutManager;", "E", "Lcom/tencent/biz/richframework/part/block/base/SafeLinearLayoutManager;", "safeLayoutManager", "com/tencent/mobileqq/guild/feed/nativedetail/content/part/s$d", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/part/s$d;", "feedDetailExtraParamIoc", "com/tencent/mobileqq/guild/feed/nativedetail/content/part/s$e", "G", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/part/s$e;", "listUIOperationApiIoc", "com/tencent/mobileqq/guild/feed/nativedetail/content/part/s$b", "H", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/part/s$b;", "childHelperApiIoc", "com/tencent/mobileqq/guild/feed/nativedetail/content/part/s$f", "I", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/part/s$f;", "onScrollerListener", "<init>", "(Lcom/tencent/biz/richframework/part/adapter/delegate/AdapterDelegatesManager;)V", "J", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class s extends Part {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean commentDataLoaded;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Queue<Pair<Integer, Object>> submitCallbackClosureQueue;

    /* renamed from: E, reason: from kotlin metadata */
    private SafeLinearLayoutManager safeLayoutManager;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final d feedDetailExtraParamIoc;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final e listUIOperationApiIoc;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final b childHelperApiIoc;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private f onScrollerListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AdapterDelegatesManager<List<hl1.g>> contentDelegatesManager;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private RecyclerView recyclerView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private RFWConcatAdapter concatAdapter;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private hl1.f contentAdapter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private RecyclerView.RecycledViewPool detailRecycledViewPool;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RecyclerView.ItemAnimator defaultAnimator;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/feed/nativedetail/content/part/s$b", "Lvi1/g;", "", "position", "Landroid/view/View;", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements vi1.g {
        b() {
        }

        @Override // vi1.g
        @Nullable
        public View a(int position) {
            if (position >= 0) {
                hl1.f fVar = s.this.contentAdapter;
                if (fVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("contentAdapter");
                    fVar = null;
                }
                if (position < fVar.getItems().size()) {
                    if (s.this.recyclerView != null) {
                        RecyclerView recyclerView = s.this.recyclerView;
                        if (recyclerView == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                            recyclerView = null;
                        }
                        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                        if (layoutManager == null) {
                            return null;
                        }
                        return layoutManager.findViewByPosition(position);
                    }
                    QLog.w("FeedNativeDetail.ContentContentPart", 1, "getChild |check calling time!");
                    return null;
                }
            }
            QLog.w("FeedNativeDetail.ContentContentPart", 1, "getChild an invalid Position: " + position);
            return null;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0004\u001a\u00020\u0002H\u0014J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0014J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0014\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/feed/nativedetail/content/part/s$c", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "", "getHorizontalSnapPreference", "getVerticalSnapPreference", "dx", "calculateTimeForDeceleration", "calculateTimeForScrolling", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c extends LinearSmoothScroller {
        c(Context context) {
            super(context);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public int calculateTimeForDeceleration(int dx5) {
            return 50;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public int calculateTimeForScrolling(int dx5) {
            return 50;
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        protected int getHorizontalSnapPreference() {
            return -1;
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        protected int getVerticalSnapPreference() {
            return -1;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000A\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0016\u0010\r\u001a\u0004\u0018\u00010\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\u0004R\u0014\u0010\u0011\u001a\u00020\u000e8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u00158VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u0017R\u0016\u0010\u001e\u001a\u0004\u0018\u00010\u001b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u0004\u0018\u00010\u001f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b \u0010!R\u0016\u0010&\u001a\u0004\u0018\u00010#8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b$\u0010%R\u0016\u0010(\u001a\u0004\u0018\u00010\u001b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b'\u0010\u001d\u00a8\u0006)"}, d2 = {"com/tencent/mobileqq/guild/feed/nativedetail/content/part/s$d", "Lrl1/a;", "", "getBusinessType", "()Ljava/lang/Integer;", "businessType", "a", "immersiveSource", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam$JoinInfoParam;", "b", "()Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam$JoinInfoParam;", "joinInfoParam", "f", "anchorPosition", "", "d", "()Ljava/lang/Boolean;", "needScrollToCommentArea", "c", "()I", "getCommentTitlePosition", "", "getTraceId", "()Ljava/lang/String;", "traceId", "getFeedId", "feedId", "", "getStartTime", "()Ljava/lang/Long;", "startTime", "Landroidx/lifecycle/LifecycleOwner;", "getHostLifecycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "hostLifecycleOwner", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/GuildFeedPublishInfo;", "e", "()Lcom/tencent/mobileqq/guild/feed/feedsquare/data/GuildFeedPublishInfo;", "feedPublishInfo", "getTopicId", "topicId", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class d implements rl1.a {
        d() {
        }

        @Override // rl1.a
        @Nullable
        public Integer a() {
            return Integer.valueOf(GuildSplitViewUtils.f235370a.h(s.this.getPartHost()).getInt("feed_immersive_source", 6));
        }

        @Override // rl1.a
        @Nullable
        public JumpGuildParam.JoinInfoParam b() {
            return (JumpGuildParam.JoinInfoParam) GuildSplitViewUtils.f235370a.h(s.this.getPartHost()).getParcelable("join_info_param");
        }

        @Override // rl1.a
        public int c() {
            return s.this.K9();
        }

        @Override // rl1.a
        @NotNull
        public Boolean d() {
            return Boolean.valueOf(s.this.Z9());
        }

        @Override // rl1.a
        @Nullable
        public GuildFeedPublishInfo e() {
            return yl1.n.q(GuildSplitViewUtils.f235370a.h(s.this.getPartHost()));
        }

        @Nullable
        public Integer f() {
            return Integer.valueOf(GuildSplitViewUtils.f235370a.h(s.this.getPartHost()).getInt("start_intent_interact_action"));
        }

        @Override // rl1.a
        @Nullable
        public Integer getBusinessType() {
            return Integer.valueOf(GuildSplitViewUtils.f235370a.h(s.this.getPartHost()).getInt("business_type"));
        }

        @Override // rl1.a
        @Nullable
        public String getFeedId() {
            return GuildSplitViewUtils.f235370a.h(s.this.getPartHost()).getString("feed_id");
        }

        @Override // rl1.a
        @Nullable
        public LifecycleOwner getHostLifecycleOwner() {
            IPartHost partHost = s.this.getPartHost();
            if (partHost != null) {
                return partHost.getLifecycleOwner();
            }
            return null;
        }

        @Override // rl1.a
        @Nullable
        public Long getStartTime() {
            return Long.valueOf(GuildSplitViewUtils.f235370a.h(s.this.getPartHost()).getLong("start_time"));
        }

        @Override // rl1.a
        @Nullable
        public Long getTopicId() {
            return Long.valueOf(GuildSplitViewUtils.f235370a.h(s.this.getPartHost()).getLong("feed_topic_id", 0L));
        }

        @Override // rl1.a
        @NotNull
        public String getTraceId() {
            String string = GuildSplitViewUtils.f235370a.h(s.this.getPartHost()).getString("trace_Id", "");
            if (string == null) {
                return "";
            }
            return string;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/feed/nativedetail/content/part/s$e", "Lvi1/h;", "", "position", "", "B1", "y", "V3", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class e implements vi1.h {
        e() {
        }

        @Override // vi1.h
        public void B1(int position) {
            if (position >= 0) {
                hl1.f fVar = s.this.contentAdapter;
                RecyclerView recyclerView = null;
                if (fVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("contentAdapter");
                    fVar = null;
                }
                if (position < fVar.getItems().size()) {
                    if (s.this.recyclerView != null) {
                        RecyclerView recyclerView2 = s.this.recyclerView;
                        if (recyclerView2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                        } else {
                            recyclerView = recyclerView2;
                        }
                        recyclerView.scrollToPosition(position);
                        return;
                    }
                    QLog.w("FeedNativeDetail.ContentContentPart", 1, "scrollToPosition|check calling time!");
                    return;
                }
            }
            QLog.w("FeedNativeDetail.ContentContentPart", 1, "scroll to an invalid Position: " + position);
        }

        @Override // vi1.h
        public void V3(int y16) {
            if (s.this.recyclerView != null) {
                RecyclerView recyclerView = s.this.recyclerView;
                if (recyclerView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                    recyclerView = null;
                }
                recyclerView.scrollBy(0, y16);
                return;
            }
            QLog.w("FeedNativeDetail.ContentContentPart", 1, "scrollTo|check calling time!");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/feed/nativedetail/content/part/s$f", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class f extends RecyclerView.OnScrollListener {
        f() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, newState);
            if (newState != 0) {
                if (newState == 1 || newState == 2) {
                    AbstractGifImage.pauseAll();
                    ApngImage.pauseAll();
                    URLDrawable.pause();
                }
            } else {
                AbstractGifImage.resumeAll();
                try {
                    ApngImage.resumeAll();
                } catch (Exception e16) {
                    QLog.e("FeedNativeDetail.ContentContentPart", 1, "onScrollStateChanged exception: " + e16.getMessage());
                }
                URLDrawable.resume();
                s.this.aa();
                VideoReport.traversePage(recyclerView);
            }
            s.this.ca(newState);
        }
    }

    public s(@NotNull AdapterDelegatesManager<List<hl1.g>> contentDelegatesManager) {
        Intrinsics.checkNotNullParameter(contentDelegatesManager, "contentDelegatesManager");
        this.contentDelegatesManager = contentDelegatesManager;
        this.submitCallbackClosureQueue = new LinkedList();
        this.feedDetailExtraParamIoc = new d();
        this.listUIOperationApiIoc = new e();
        this.childHelperApiIoc = new b();
        this.onScrollerListener = new f();
    }

    private final boolean G9(View view) {
        int screenHeight;
        Configuration configuration;
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        Resources resources = view.getResources();
        if (resources != null && (configuration = resources.getConfiguration()) != null) {
            screenHeight = ViewUtils.dpToPx(configuration.screenHeightDp);
        } else {
            screenHeight = ViewUtils.getScreenHeight();
        }
        if (iArr[1] <= screenHeight - com.tencent.guild.aio.util.c.b(30)) {
            return true;
        }
        return false;
    }

    private final boolean H9() {
        View ea5 = ea();
        if (ea5 == null) {
            return false;
        }
        return G9(ea5);
    }

    private final LinearSmoothScroller I9(Context context) {
        return new c(context);
    }

    private final void J9(Queue<Pair<Integer, Object>> changeSourceList) {
        Iterator<T> it = changeSourceList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            da(((Number) pair.getFirst()).intValue(), pair.getSecond());
            if (((Number) pair.getFirst()).intValue() == 2) {
                S9(pair.getSecond());
            } else if (((Number) pair.getFirst()).intValue() == 1 && this.commentDataLoaded) {
                QLog.d("FeedNativeDetail.ContentContentPart", 1, "force scroll to comment area");
                S9(null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int K9() {
        int i3;
        Integer num;
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter != null) {
            i3 = adapter.getItemCount();
        } else {
            i3 = 0;
        }
        for (int i16 = 0; i16 < i3; i16++) {
            try {
                RecyclerView recyclerView2 = this.recyclerView;
                if (recyclerView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                    recyclerView2 = null;
                }
                RecyclerView.Adapter adapter2 = recyclerView2.getAdapter();
                if (adapter2 != null) {
                    num = Integer.valueOf(adapter2.getItemViewType(i16));
                } else {
                    num = null;
                }
                if (num != null && num.intValue() == 5) {
                    return i16;
                }
            } catch (Exception e16) {
                QLog.e("FeedNativeDetail.ContentContentPart", 1, "findCommentTitlePosition fail " + e16);
                return 2;
            }
        }
        return 2;
    }

    private final View L9(int pos) {
        try {
            SafeLinearLayoutManager safeLinearLayoutManager = this.safeLayoutManager;
            if (safeLinearLayoutManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("safeLayoutManager");
                safeLinearLayoutManager = null;
            }
            return safeLinearLayoutManager.findViewByPosition(pos);
        } catch (Exception unused) {
            return null;
        }
    }

    private final int M9() {
        int coerceAtLeast;
        hl1.f fVar = this.contentAdapter;
        if (fVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentAdapter");
            fVar = null;
        }
        List<hl1.g> items = fVar.getItems();
        Intrinsics.checkNotNullExpressionValue(items, "contentAdapter.items");
        Iterator<hl1.g> it = items.iterator();
        int i3 = 0;
        while (true) {
            if (it.hasNext()) {
                if (it.next() instanceof jl1.b) {
                    break;
                }
                i3++;
            } else {
                i3 = -1;
                break;
            }
        }
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(i3, 0);
        return coerceAtLeast;
    }

    private final int N9() {
        int coerceAtLeast;
        hl1.f fVar = this.contentAdapter;
        if (fVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentAdapter");
            fVar = null;
        }
        List<hl1.g> items = fVar.getItems();
        Intrinsics.checkNotNullExpressionValue(items, "contentAdapter.items");
        Iterator<hl1.g> it = items.iterator();
        int i3 = 0;
        while (true) {
            if (it.hasNext()) {
                if (it.next() instanceof jl1.f) {
                    break;
                }
                i3++;
            } else {
                i3 = -1;
                break;
            }
        }
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(i3, 0);
        return coerceAtLeast;
    }

    private final int O9() {
        RecyclerView recyclerView = this.recyclerView;
        RecyclerView recyclerView2 = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
            RecyclerView recyclerView3 = this.recyclerView;
            if (recyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            } else {
                recyclerView2 = recyclerView3;
            }
            RecyclerView.LayoutManager layoutManager = recyclerView2.getLayoutManager();
            Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            return ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
        }
        return 0;
    }

    private final void P9(Object args) {
        Boolean bool;
        if (args instanceof Boolean) {
            bool = (Boolean) args;
        } else {
            bool = null;
        }
        if (bool != null) {
            SimpleEventBus.getInstance().dispatchEvent(new PageOpenAnimationEvent(bool.booleanValue()));
        }
    }

    private final void Q9(Object message) {
        LinkedList<DataChangedState> linkedList;
        List emptyList;
        if (!(message instanceof g.OnDataListChangedMessage)) {
            return;
        }
        g.OnDataListChangedMessage onDataListChangedMessage = (g.OnDataListChangedMessage) message;
        hl1.f fVar = null;
        if (onDataListChangedMessage.getChangedSource() == 15) {
            Object payload = onDataListChangedMessage.getPayload();
            if (payload instanceof LinkedList) {
                linkedList = (LinkedList) payload;
            } else {
                linkedList = null;
            }
            if (linkedList != null) {
                for (DataChangedState dataChangedState : linkedList) {
                    emptyList = CollectionsKt__CollectionsKt.emptyList();
                    Q9(new g.OnDataListChangedMessage(emptyList, dataChangedState.getDataChangedSource(), dataChangedState.getPayload()));
                }
            }
        }
        if (onDataListChangedMessage.getChangedSource() == 2) {
            this.commentDataLoaded = true;
        }
        ga(onDataListChangedMessage);
        this.submitCallbackClosureQueue.offer(TuplesKt.to(Integer.valueOf(onDataListChangedMessage.getChangedSource()), onDataListChangedMessage.getPayload()));
        List<hl1.g> b16 = onDataListChangedMessage.b();
        if (b16.isEmpty()) {
            b16 = null;
        }
        final List<hl1.g> list = b16;
        hl1.f fVar2 = this.contentAdapter;
        if (fVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentAdapter");
        } else {
            fVar = fVar2;
        }
        fVar.setItems(list, new Runnable() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.part.q
            @Override // java.lang.Runnable
            public final void run() {
                s.R9(s.this, list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R9(s this$0, List list) {
        Integer num;
        int i3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LinkedList<Pair<Integer, Object>> linkedList = new LinkedList<>(this$0.submitCallbackClosureQueue);
        this$0.submitCallbackClosureQueue.clear();
        if (list != null) {
            num = Integer.valueOf(list.size());
        } else {
            num = null;
        }
        QLog.i("FeedNativeDetail.ContentContentPart", 1, "itemCount=" + num + " flush queue: " + linkedList);
        if (list != null) {
            i3 = list.size();
        } else {
            i3 = 0;
        }
        this$0.broadcastMessage("message_data_changed_render_on_screen", new g.OnDataChangedRenderOnScreenMessage(i3, linkedList));
        this$0.J9(linkedList);
        this$0.ba(linkedList);
    }

    private final void S9(final Object payload) {
        aa();
        Integer f16 = this.feedDetailExtraParamIoc.f();
        if ((f16 == null || f16.intValue() != 2) && (f16 == null || f16.intValue() != 3)) {
            return;
        }
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.part.r
            @Override // java.lang.Runnable
            public final void run() {
                s.T9(payload, this);
            }
        }, 50L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T9(Object obj, s this$0) {
        Integer num;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SafeLinearLayoutManager safeLinearLayoutManager = null;
        if (obj instanceof Integer) {
            num = (Integer) obj;
        } else {
            num = null;
        }
        if (num == null) {
            SafeLinearLayoutManager safeLinearLayoutManager2 = this$0.safeLayoutManager;
            if (safeLinearLayoutManager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("safeLayoutManager");
            } else {
                safeLinearLayoutManager = safeLinearLayoutManager2;
            }
            safeLinearLayoutManager.scrollToPositionWithOffset(this$0.N9(), 0);
            return;
        }
        SafeLinearLayoutManager safeLinearLayoutManager3 = this$0.safeLayoutManager;
        if (safeLinearLayoutManager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("safeLayoutManager");
        } else {
            safeLinearLayoutManager = safeLinearLayoutManager3;
        }
        safeLinearLayoutManager.scrollToPositionWithOffset(num.intValue() + this$0.M9(), 0);
    }

    private final void U9(Object msg2) {
        hl1.f fVar = null;
        String str = null;
        if (!(msg2 instanceof g.OnItemDataChangedMessage)) {
            if (msg2 != null) {
                str = msg2.getClass().getName();
            }
            QLog.e("FeedNativeDetail.ContentContentPart", 1, "handleItemDataChanged|args type error, " + str);
            return;
        }
        g.OnItemDataChangedMessage onItemDataChangedMessage = (g.OnItemDataChangedMessage) msg2;
        int position = onItemDataChangedMessage.getPosition();
        if (tl1.f.f436523a.a().contains(Integer.valueOf(onItemDataChangedMessage.getChangedSource()))) {
            position += M9();
        }
        hl1.f fVar2 = this.contentAdapter;
        if (fVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentAdapter");
        } else {
            fVar = fVar2;
        }
        fVar.notifyItemChanged(position, onItemDataChangedMessage.getPayload());
    }

    private final void V9(Object args) {
        SafeLinearLayoutManager safeLinearLayoutManager = null;
        String str = null;
        SafeLinearLayoutManager safeLinearLayoutManager2 = null;
        if (!(args instanceof g.ScrollToPositionMessageData)) {
            if (args != null) {
                str = args.getClass().getName();
            }
            QLog.e("FeedNativeDetail.ContentContentPart", 1, "handleScrollToPosition, " + str);
            return;
        }
        g.ScrollToPositionMessageData scrollToPositionMessageData = (g.ScrollToPositionMessageData) args;
        QLog.i("FeedNativeDetail.ContentContentPart", 1, "handleScrollToPosition anim=" + scrollToPositionMessageData.getAnim() + " pos=" + scrollToPositionMessageData.getPosition());
        if (scrollToPositionMessageData.getAnim()) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            LinearSmoothScroller I9 = I9(context);
            I9.setTargetPosition(scrollToPositionMessageData.getPosition());
            SafeLinearLayoutManager safeLinearLayoutManager3 = this.safeLayoutManager;
            if (safeLinearLayoutManager3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("safeLayoutManager");
            } else {
                safeLinearLayoutManager2 = safeLinearLayoutManager3;
            }
            safeLinearLayoutManager2.startSmoothScroll(I9);
            return;
        }
        SafeLinearLayoutManager safeLinearLayoutManager4 = this.safeLayoutManager;
        if (safeLinearLayoutManager4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("safeLayoutManager");
        } else {
            safeLinearLayoutManager = safeLinearLayoutManager4;
        }
        safeLinearLayoutManager.scrollToPosition(scrollToPositionMessageData.getPosition());
    }

    private final boolean W9() {
        int i3;
        Integer num;
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter != null) {
            i3 = adapter.getItemCount();
        } else {
            i3 = 0;
        }
        for (int i16 = 0; i16 < i3; i16++) {
            try {
                RecyclerView recyclerView2 = this.recyclerView;
                if (recyclerView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                    recyclerView2 = null;
                }
                RecyclerView.Adapter adapter2 = recyclerView2.getAdapter();
                if (adapter2 != null) {
                    num = Integer.valueOf(adapter2.getItemViewType(i16));
                } else {
                    num = null;
                }
                if (num != null && num.intValue() == 7) {
                    return true;
                }
                if (num.intValue() == 6) {
                    return true;
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    private final void X9(View rootView) {
        View findViewById = rootView.findViewById(R.id.v1q);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026il_content_recycler_view)");
        this.recyclerView = (RecyclerView) findViewById;
        SafeLinearLayoutManager safeLinearLayoutManager = new SafeLinearLayoutManager(getContext());
        safeLinearLayoutManager.setOrientation(1);
        this.safeLayoutManager = safeLinearLayoutManager;
        hl1.f fVar = new hl1.f(new hl1.d(), this.contentDelegatesManager);
        fVar.setHasStableIds(true);
        this.contentAdapter = fVar;
        RFWConcatAdapter.Config build = new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(false).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build();
        RecyclerView.Adapter[] adapterArr = new RecyclerView.Adapter[2];
        hl1.f fVar2 = this.contentAdapter;
        RecyclerView.RecycledViewPool recycledViewPool = null;
        if (fVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentAdapter");
            fVar2 = null;
        }
        adapterArr[0] = fVar2;
        Object broadcastGetMessage = broadcastGetMessage("action_get_comment_load_more_adapter", null);
        Intrinsics.checkNotNull(broadcastGetMessage, "null cannot be cast to non-null type com.tencent.mobileqq.guild.feed.nativedetail.content.feedcomment.adapter.CommentLoadMoreAdapter");
        adapterArr[1] = (il1.c) broadcastGetMessage;
        this.concatAdapter = new RFWConcatAdapter(build, (RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) adapterArr);
        RecyclerView.RecycledViewPool recycledViewPool2 = new RecyclerView.RecycledViewPool();
        recycledViewPool2.setMaxRecycledViews(6, 8);
        recycledViewPool2.setMaxRecycledViews(7, 8);
        this.detailRecycledViewPool = recycledViewPool2;
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        SafeLinearLayoutManager safeLinearLayoutManager2 = this.safeLayoutManager;
        if (safeLinearLayoutManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("safeLayoutManager");
            safeLinearLayoutManager2 = null;
        }
        recyclerView.setLayoutManager(safeLinearLayoutManager2);
        RFWConcatAdapter rFWConcatAdapter = this.concatAdapter;
        if (rFWConcatAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("concatAdapter");
            rFWConcatAdapter = null;
        }
        recyclerView.setAdapter(rFWConcatAdapter);
        RecyclerView.RecycledViewPool recycledViewPool3 = this.detailRecycledViewPool;
        if (recycledViewPool3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailRecycledViewPool");
        } else {
            recycledViewPool = recycledViewPool3;
        }
        recyclerView.setRecycledViewPool(recycledViewPool);
        recyclerView.addOnScrollListener(this.onScrollerListener);
        recyclerView.setOverScrollMode(2);
        this.defaultAnimator = new DefaultItemAnimator();
    }

    private final boolean Y9(Pair<Integer, ? extends Object> pair) {
        if (tl1.f.f436523a.a().contains(pair.getFirst()) && pair.getFirst().intValue() != 11) {
            return true;
        }
        if (15 == pair.getFirst().intValue() && (pair.getSecond() instanceof LinkedList)) {
            Object second = pair.getSecond();
            Intrinsics.checkNotNull(second, "null cannot be cast to non-null type java.util.LinkedList<*>");
            Iterator it = ((LinkedList) second).iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if ((next instanceof DataChangedState) && tl1.f.f436523a.a().contains(Integer.valueOf(((DataChangedState) next).getDataChangedSource()))) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean Z9() {
        return !H9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void aa() {
        boolean z16;
        if (O9() >= 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        broadcastMessage("message_comment_list_visibility_change", new g.CommentListVisibilityChangeMessage(z16));
    }

    private final void ba(LinkedList<Pair<Integer, Object>> list) {
        Iterator<Pair<Integer, Object>> it = list.iterator();
        while (it.hasNext()) {
            Pair<Integer, Object> pair = it.next();
            Intrinsics.checkNotNullExpressionValue(pair, "pair");
            if (Y9(pair)) {
                broadcastMessage("message_update_load_more_view_visible", null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ca(int newState) {
        Context context;
        int i3;
        SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
        FeedContentScrollEvent feedContentScrollEvent = new FeedContentScrollEvent(newState);
        View partRootView = getPartRootView();
        if (partRootView != null) {
            context = partRootView.getContext();
        } else {
            context = null;
        }
        if (context != null) {
            i3 = context.hashCode();
        } else {
            i3 = 0;
        }
        feedContentScrollEvent.mHashCode = i3;
        simpleEventBus.dispatchEvent(feedContentScrollEvent);
    }

    private final void da(int dataChangedSource, Object payload) {
        Integer num;
        int M9;
        SafeLinearLayoutManager safeLinearLayoutManager = null;
        if (dataChangedSource == 13 && Intrinsics.areEqual(payload, Boolean.TRUE)) {
            SafeLinearLayoutManager safeLinearLayoutManager2 = this.safeLayoutManager;
            if (safeLinearLayoutManager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("safeLayoutManager");
                safeLinearLayoutManager2 = null;
            }
            if (safeLinearLayoutManager2.findFirstVisibleItemPosition() > N9()) {
                SafeLinearLayoutManager safeLinearLayoutManager3 = this.safeLayoutManager;
                if (safeLinearLayoutManager3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("safeLayoutManager");
                    safeLinearLayoutManager3 = null;
                }
                safeLinearLayoutManager3.scrollToPositionWithOffset(N9(), 0);
            }
        }
        if (dataChangedSource == 6) {
            if (payload instanceof Integer) {
                num = (Integer) payload;
            } else {
                num = null;
            }
            if (num != null) {
                int intValue = num.intValue();
                SafeLinearLayoutManager safeLinearLayoutManager4 = this.safeLayoutManager;
                if (safeLinearLayoutManager4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("safeLayoutManager");
                } else {
                    safeLinearLayoutManager = safeLinearLayoutManager4;
                }
                if (intValue == 0) {
                    M9 = N9();
                } else {
                    M9 = intValue + M9();
                }
                safeLinearLayoutManager.scrollToPositionWithOffset(M9, 0);
            }
        }
    }

    private final View ea() {
        SafeLinearLayoutManager safeLinearLayoutManager = this.safeLayoutManager;
        if (safeLinearLayoutManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("safeLayoutManager");
            safeLinearLayoutManager = null;
        }
        SafeLinearLayoutManager safeLinearLayoutManager2 = this.safeLayoutManager;
        if (safeLinearLayoutManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("safeLayoutManager");
            safeLinearLayoutManager2 = null;
        }
        int findLastVisibleItemPosition = safeLinearLayoutManager2.findLastVisibleItemPosition();
        boolean W9 = W9();
        for (int findFirstVisibleItemPosition = safeLinearLayoutManager.findFirstVisibleItemPosition(); findFirstVisibleItemPosition <= findLastVisibleItemPosition; findFirstVisibleItemPosition++) {
            if (findFirstVisibleItemPosition >= 0) {
                RFWConcatAdapter rFWConcatAdapter = this.concatAdapter;
                if (rFWConcatAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("concatAdapter");
                    rFWConcatAdapter = null;
                }
                if (findFirstVisibleItemPosition <= rFWConcatAdapter.getItemCount()) {
                    RFWConcatAdapter rFWConcatAdapter2 = this.concatAdapter;
                    if (rFWConcatAdapter2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("concatAdapter");
                        rFWConcatAdapter2 = null;
                    }
                    int itemViewType = rFWConcatAdapter2.getItemViewType(findFirstVisibleItemPosition);
                    if (W9) {
                        if (itemViewType == 6 || itemViewType == 7) {
                            return L9(findFirstVisibleItemPosition);
                        }
                    } else if (itemViewType == 5) {
                        return L9(findFirstVisibleItemPosition);
                    }
                }
            }
            QLog.e("FeedNativeDetail.ContentContentPart", 1, "searchFistVisibleCommentTypeItemView IndexOutOfBounds");
            break;
        }
        return null;
    }

    private final void ga(g.OnDataListChangedMessage message) {
        RecyclerView recyclerView = null;
        if (tl1.f.f436523a.b().contains(Integer.valueOf(message.getChangedSource()))) {
            RecyclerView recyclerView2 = this.recyclerView;
            if (recyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            } else {
                recyclerView = recyclerView2;
            }
            recyclerView.setItemAnimator(this.defaultAnimator);
            return;
        }
        RecyclerView recyclerView3 = this.recyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView3 = null;
        }
        recyclerView3.setItemAnimator(null);
    }

    @Override // com.tencent.biz.richframework.part.Part
    @Nullable
    public Object getMessage(@Nullable String action, @Nullable Object msg2) {
        if (Intrinsics.areEqual(action, "action_get_comment_item_offset")) {
            return new g.GetCommentItemOffsetMessage(M9());
        }
        return null;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        super.handleBroadcastMessage(action, args);
        if (action != null) {
            switch (action.hashCode()) {
                case -147387757:
                    if (action.equals("message_item_data_changed")) {
                        U9(args);
                        return;
                    }
                    return;
                case 544073503:
                    if (action.equals("message_content_list_scroll_to_pos")) {
                        V9(args);
                        return;
                    }
                    return;
                case 1157992528:
                    if (action.equals("message_data_list_changed")) {
                        Q9(args);
                        return;
                    }
                    return;
                case 1583791999:
                    if (action.equals("message_on_animation_ing")) {
                        P9(args);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(@Nullable Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (QQGuildUIUtil.z()) {
            SimpleEventBus.getInstance().dispatchEvent(new FeedConfigurationChangeEvent());
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        super.onInitView(rootView);
        if (rootView == null) {
            return;
        }
        X9(rootView);
        RFWIocAbilityProvider g16 = RFWIocAbilityProvider.g();
        g16.registerIoc(rootView, this.feedDetailExtraParamIoc, rl1.a.class);
        g16.registerIoc(rootView, this.listUIOperationApiIoc, vi1.h.class);
        g16.registerIoc(rootView, this.childHelperApiIoc, vi1.g.class);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        recyclerView.removeOnScrollListener(this.onScrollerListener);
        RFWIocAbilityProvider.g();
        PartIOCKt.unregisterIoc(this, vi1.h.class);
        PartIOCKt.unregisterIoc(this, rl1.a.class);
        PartIOCKt.unregisterIoc(this, vi1.g.class);
    }
}
