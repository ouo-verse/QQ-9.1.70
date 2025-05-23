package com.tencent.mobileqq.guild.feed.feedsquare.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.feedsquare.widget.GuildFeedSquareTopView$feedItemClickListener$2;
import com.tencent.mobileqq.guild.feed.squarehead.topFeed.TopFeedListAdapter;
import com.tencent.mobileqq.guild.feed.widget.GuildBaseWidgetView;
import com.tencent.mobileqq.guild.util.cw;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 <2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001=B\u0011\b\u0016\u0012\u0006\u00104\u001a\u000203\u00a2\u0006\u0004\b5\u00106B\u001b\b\u0016\u0012\u0006\u00104\u001a\u000203\u0012\b\u00108\u001a\u0004\u0018\u000107\u00a2\u0006\u0004\b5\u00109B#\b\u0016\u0012\u0006\u00104\u001a\u000203\u0012\b\u00108\u001a\u0004\u0018\u000107\u0012\u0006\u0010:\u001a\u00020\u0007\u00a2\u0006\u0004\b5\u0010;J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J$\u0010\u000b\u001a\u00020\u00042\u001c\u0010\n\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0004\u0018\u00010\tJ\u0014\u0010\u000e\u001a\u00020\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\fJ\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u0007H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u000fH\u0016J\u000e\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u000fR\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001cR\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010%\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010\u0014R\u001b\u0010+\u001a\u00020&8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R,\u0010.\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u001b\u00102\u001a\u00020\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b/\u0010(\u001a\u0004\b0\u00101\u00a8\u0006>"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/widget/GuildFeedSquareTopView;", "Lcom/tencent/mobileqq/guild/feed/widget/GuildBaseWidgetView;", "Lij1/h;", "Lsn1/a;", "", "initView", "u0", "", "getLayoutId", "Lkotlin/Function2;", "listener", "setOnFeedTopItemClickListener", "", "listData", "setFeedTopListData", "", "k", "totalSize", "Lsn1/b;", "j0", "I", "isFirst", "v0", "Landroidx/recyclerview/widget/RecyclerView;", "d", "Landroidx/recyclerview/widget/RecyclerView;", "feedTopListViewContainer", "e", "Z", "isNeedAnim", "f", "isFold", "", tl.h.F, "Ljava/util/List;", "feedTopDataList", "i", "currentIndex", "Lcom/tencent/mobileqq/guild/feed/squarehead/topFeed/TopFeedListAdapter;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/Lazy;", "s0", "()Lcom/tencent/mobileqq/guild/feed/squarehead/topFeed/TopFeedListAdapter;", "feedTopListAdapter", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/jvm/functions/Function2;", "itemClickListener", "D", "r0", "()Lsn1/b;", "feedItemClickListener", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "E", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedSquareTopView extends GuildBaseWidgetView<ij1.h> implements sn1.a {
    private static final int F = (int) cw.c(44.0f);
    private static final int G = (int) cw.c(8.0f);

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private Function2<? super ij1.h, ? super Integer, Unit> itemClickListener;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy feedItemClickListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private RecyclerView feedTopListViewContainer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isNeedAnim;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isFold;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<ij1.h> feedTopDataList;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int currentIndex;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy feedTopListAdapter;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GuildFeedSquareTopView(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void initView() {
        View findViewById = findViewById(R.id.f165193v42);
        RecyclerView recyclerView = (RecyclerView) findViewById;
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(s0());
        recyclerView.setItemAnimator(null);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<RecyclerVie\u2026Animator = null\n        }");
        this.feedTopListViewContainer = recyclerView;
    }

    private final sn1.b r0() {
        return (sn1.b) this.feedItemClickListener.getValue();
    }

    private final TopFeedListAdapter s0() {
        return (TopFeedListAdapter) this.feedTopListAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u0() {
        ArrayList arrayListOf;
        QLog.d("GuildFeedSquareTopView", 1, "updateFeedTopListView: size[" + this.feedTopDataList.size() + "]");
        if (!this.feedTopDataList.isEmpty()) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(this.feedTopDataList.get(this.currentIndex));
            if (!this.isFold) {
                int i3 = totalSize();
                for (int i16 = 1; i16 < i3; i16++) {
                    arrayListOf.add(this.feedTopDataList.get((this.currentIndex + i16) % i3));
                }
            }
            s0().m0(arrayListOf);
            setVisibility(0);
            return;
        }
        setVisibility(8);
    }

    @Override // sn1.a
    /* renamed from: I, reason: from getter */
    public boolean getIsNeedAnim() {
        return this.isNeedAnim;
    }

    @Override // com.tencent.mobileqq.guild.feed.widget.GuildBaseWidgetView, com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.f9a;
    }

    @Override // sn1.a
    @NotNull
    public sn1.b j0() {
        return r0();
    }

    @Override // sn1.a
    /* renamed from: k, reason: from getter */
    public boolean getIsFold() {
        return this.isFold;
    }

    public final void setFeedTopListData(@NotNull List<? extends ij1.h> listData) {
        Intrinsics.checkNotNullParameter(listData, "listData");
        QLog.d("GuildFeedSquareTopView", 1, "setFeedTopListData: size[" + listData.size() + "]");
        this.feedTopDataList.clear();
        this.feedTopDataList.addAll(listData);
        this.currentIndex = 0;
        u0();
    }

    public final void setOnFeedTopItemClickListener(@Nullable Function2<? super ij1.h, ? super Integer, Unit> listener) {
        this.itemClickListener = listener;
    }

    @Override // sn1.a
    public int totalSize() {
        int coerceAtMost;
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(this.feedTopDataList.size(), 3);
        return coerceAtMost;
    }

    public final void v0(boolean isFirst) {
        this.isFold = true;
        if (!isFirst) {
            this.isNeedAnim = false;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GuildFeedSquareTopView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildFeedSquareTopView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(context, "context");
        this.isNeedAnim = true;
        this.isFold = true;
        this.feedTopDataList = new ArrayList();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<TopFeedListAdapter>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.widget.GuildFeedSquareTopView$feedTopListAdapter$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TopFeedListAdapter invoke() {
                return new TopFeedListAdapter(GuildFeedSquareTopView.this);
            }
        });
        this.feedTopListAdapter = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<GuildFeedSquareTopView$feedItemClickListener$2.a>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.widget.GuildFeedSquareTopView$feedItemClickListener$2

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/feed/feedsquare/widget/GuildFeedSquareTopView$feedItemClickListener$2$a", "Lsn1/b;", "Landroid/view/View;", "v", "Lij1/h;", "data", "", "b", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes13.dex */
            public static final class a implements sn1.b {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ GuildFeedSquareTopView f219466a;

                a(GuildFeedSquareTopView guildFeedSquareTopView) {
                    this.f219466a = guildFeedSquareTopView;
                }

                @Override // sn1.b
                public void a(@NotNull View v3) {
                    boolean z16;
                    boolean z17;
                    Intrinsics.checkNotNullParameter(v3, "v");
                    this.f219466a.isNeedAnim = false;
                    GuildFeedSquareTopView guildFeedSquareTopView = this.f219466a;
                    z16 = guildFeedSquareTopView.isFold;
                    guildFeedSquareTopView.isFold = !z16;
                    this.f219466a.u0();
                    z17 = this.f219466a.isFold;
                    if (!z17) {
                        VideoReport.reportEvent("dt_clck", v3, null);
                    }
                }

                @Override // sn1.b
                public void b(@NotNull View v3, @Nullable ij1.h data) {
                    Function2 function2;
                    boolean z16;
                    int i3;
                    Intrinsics.checkNotNullParameter(v3, "v");
                    this.f219466a.isNeedAnim = false;
                    function2 = this.f219466a.itemClickListener;
                    if (function2 != null) {
                        function2.invoke(data, 0);
                    }
                    z16 = this.f219466a.isFold;
                    if (z16) {
                        GuildFeedSquareTopView guildFeedSquareTopView = this.f219466a;
                        i3 = guildFeedSquareTopView.currentIndex;
                        guildFeedSquareTopView.currentIndex = (i3 + 1) % this.f219466a.totalSize();
                        this.f219466a.u0();
                    }
                    VideoReport.reportEvent("dt_clck", v3, null);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final a invoke() {
                return new a(GuildFeedSquareTopView.this);
            }
        });
        this.feedItemClickListener = lazy2;
        initView();
    }
}
