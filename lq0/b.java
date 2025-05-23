package lq0;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.util.Consumer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.aio.base.tool.a;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.guild.api.IGuildInfoUtilsApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotPlusPanelFeature;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0017\u0012\u0006\u0010#\u001a\u00020 \u0012\u0006\u0010'\u001a\u00020$\u00a2\u0006\u0004\b1\u00102J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0016J\u0018\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0018\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0004H\u0016J \u0010\u001c\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0010\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u0013H\u0016J\u0010\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u0013H\u0016R\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u001c\u0010)\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010(R \u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020+0\n0*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010,R\u0014\u00100\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010/\u00a8\u00063"}, d2 = {"Llq0/b;", "Landroidx/viewpager/widget/PagerAdapter;", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnLongClickListener;", "", "page", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "i", "", "Llq0/f;", "g", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "guildId", "", "f", "getCount", "Landroid/view/View;", "view", "", "obj", "isViewFromObject", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "position", tl.h.F, "destroyItem", "v", NodeProps.ON_CLICK, NodeProps.ON_LONG_CLICK, "Llq0/i;", "d", "Llq0/i;", "mFactory", "Lcom/tencent/aio/part/root/panel/mvx/config/c;", "e", "Lcom/tencent/aio/part/root/panel/mvx/config/c;", "mPanelParam", "Ljava/util/List;", "mItemList", "Landroidx/core/util/Consumer;", "Lcom/tencent/qqnt/kernel/nativeinterface/GProGuildRobotPlusPanelFeature;", "Landroidx/core/util/Consumer;", "dataArrivedCallback", "Llq0/g;", "Llq0/g;", "mPlusPanelProp", "<init>", "(Llq0/i;Lcom/tencent/aio/part/root/panel/mvx/config/c;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class b extends PagerAdapter implements View.OnClickListener, View.OnLongClickListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final i mFactory;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.aio.part.root.panel.mvx.config.c mPanelParam;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<? extends f> mItemList;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Consumer<List<GProGuildRobotPlusPanelFeature>> dataArrivedCallback;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final g mPlusPanelProp;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"lq0/b$a", "Landroidx/recyclerview/widget/GridLayoutManager;", "", "canScrollVertically", "canScrollHorizontally", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class a extends GridLayoutManager {
        a(Context context, int i3) {
            super(context, i3);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean canScrollHorizontally() {
            return false;
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean canScrollVertically() {
            return false;
        }
    }

    public b(@NotNull i mFactory, @NotNull com.tencent.aio.part.root.panel.mvx.config.c mPanelParam) {
        Intrinsics.checkNotNullParameter(mFactory, "mFactory");
        Intrinsics.checkNotNullParameter(mPanelParam, "mPanelParam");
        this.mFactory = mFactory;
        this.mPanelParam = mPanelParam;
        this.mItemList = new ArrayList();
        Consumer<List<GProGuildRobotPlusPanelFeature>> consumer = new Consumer() { // from class: lq0.a
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                b.e(b.this, (List) obj);
            }
        };
        this.dataArrivedCallback = consumer;
        List<f> e16 = mFactory.e(com.tencent.guild.aio.util.a.g(mPanelParam.b()), com.tencent.guild.aio.util.a.b(mPanelParam.b()), true, consumer);
        ArrayList arrayList = new ArrayList();
        for (Object obj : e16) {
            if (f((f) obj, com.tencent.guild.aio.util.a.f(this.mPanelParam))) {
                arrayList.add(obj);
            }
        }
        this.mItemList = arrayList;
        this.mPlusPanelProp = this.mFactory.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(b this$0, List list) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        List<f> e16 = this$0.mFactory.e(com.tencent.guild.aio.util.a.g(this$0.mPanelParam.b()), com.tencent.guild.aio.util.a.b(this$0.mPanelParam.b()), true, null);
        ArrayList arrayList = new ArrayList();
        for (Object obj : e16) {
            if (this$0.f((f) obj, com.tencent.guild.aio.util.a.f(this$0.mPanelParam))) {
                arrayList.add(obj);
            }
        }
        this$0.mItemList = arrayList;
        this$0.notifyDataSetChanged();
    }

    private final boolean f(f item, String guildId) {
        if (((item instanceof mq0.b) || (item instanceof mq0.a)) && !((IGuildInfoUtilsApi) QRoute.api(IGuildInfoUtilsApi.class)).isSafetySwitchOpen(guildId, 10)) {
            return false;
        }
        return true;
    }

    private final List<f> g(int page) {
        int pageCount = this.mPlusPanelProp.getPageCount() * page;
        int min = Math.min(this.mItemList.size(), this.mPlusPanelProp.getPageCount() + pageCount);
        if (pageCount < this.mItemList.size()) {
            return this.mItemList.subList(pageCount, min);
        }
        return new ArrayList(0);
    }

    private final void i(int page, RecyclerView recyclerView) {
        a.Companion companion = com.tencent.aio.base.tool.a.INSTANCE;
        Context context = recyclerView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "recyclerView.context");
        int b16 = companion.b(context, this.mPlusPanelProp.getPanelPaddingLRDP());
        recyclerView.setPadding(b16, 0, b16, 0);
        recyclerView.setAdapter(new c(this, this, g(page), this.mFactory));
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(@NotNull ViewGroup container, int position, @NotNull Object obj) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(obj, "obj");
        container.removeView((View) obj);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    /* renamed from: getCount */
    public int getF373114d() {
        return ((this.mItemList.size() - 1) / this.mPlusPanelProp.getPageCount()) + 1;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @NotNull
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public View instantiateItem(@NotNull ViewGroup container, int position) {
        Intrinsics.checkNotNullParameter(container, "container");
        RecyclerView recyclerView = new RecyclerView(container.getContext());
        recyclerView.setOverScrollMode(2);
        recyclerView.setLayoutManager(new a(container.getContext(), this.mPlusPanelProp.getColumnCount()));
        i(position, recyclerView);
        container.addView(recyclerView);
        return recyclerView;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NotNull View view, @NotNull Object obj) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(obj, "obj");
        if (view == obj) {
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        Object tag = v3.getTag();
        Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.tencent.guild.aio.panel.plus.GuildPlusPanelItem");
        ((f) tag).f(v3, this.mPanelParam);
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(@NotNull View v3) {
        EventCollector.getInstance().onViewLongClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        EventCollector.getInstance().onViewLongClicked(v3);
        return false;
    }
}
