package com.tencent.timi.game.emo.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.pubaccount.weishi.event.WSComboHomePageChangeEvent;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.timi.game.emo.ui.EmoPanelIndicator;
import com.tencent.timi.game.utils.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import nr2.x;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import xg4.m;
import zn4.b;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 .2\u00020\u0001:\u0001/B'\b\u0007\u0012\u0006\u0010(\u001a\u00020'\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010)\u0012\b\b\u0002\u0010+\u001a\u00020\u0012\u00a2\u0006\u0004\b,\u0010-J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0014\u0010\n\u001a\u00020\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u0006\u0010\u000b\u001a\u00020\u0002J\u0006\u0010\f\u001a\u00020\u0002J\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u000f\u001a\u00020\rJ\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010J\u000e\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R$\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0019j\b\u0012\u0004\u0012\u00020\b`\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u001eR\u0016\u0010!\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010 R0\u0010&\u001a\u001e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020#0\"j\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020#`$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010%\u00a8\u00060"}, d2 = {"Lcom/tencent/timi/game/emo/ui/TimiEmoPanelView;", "Landroid/widget/FrameLayout;", "", "g", "Lxg4/m;", "param", "setCreateParam", "", "Lxg4/a;", "data", "setData", "e", "j", "", "i", h.F, "Landroid/view/View;", "f", "", "yesGameId", "k", "Lnr2/x;", "d", "Lnr2/x;", "binding", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "mDataList", "Landroidx/viewpager/widget/PagerAdapter;", "Landroidx/viewpager/widget/PagerAdapter;", "mPageAdapter", "Lxg4/m;", "mCreateParam", "Ljava/util/HashMap;", "Lbh4/a;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "pageViewCachePool", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "b", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class TimiEmoPanelView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private x binding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<xg4.a> mDataList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final PagerAdapter mPageAdapter;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private m mCreateParam;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<Integer, bh4.a> pageViewCachePool;

    @Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J \u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0007H\u0016\u00a8\u0006\u0011"}, d2 = {"com/tencent/timi/game/emo/ui/TimiEmoPanelView$a", "Landroidx/viewpager/widget/PagerAdapter;", "", "getCount", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "position", "", "instantiateItem", "Landroid/view/View;", "view", "object", "", "isViewFromObject", "obj", "", "destroyItem", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class a extends PagerAdapter {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Context f376815e;

        a(Context context) {
            this.f376815e = context;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(@NotNull ViewGroup container, int position, @NotNull Object obj) {
            bh4.a aVar;
            Intrinsics.checkNotNullParameter(container, "container");
            Intrinsics.checkNotNullParameter(obj, "obj");
            View view = null;
            if (obj instanceof bh4.a) {
                aVar = (bh4.a) obj;
            } else {
                aVar = null;
            }
            if (aVar != null) {
                view = aVar.getView();
            }
            container.removeView(view);
            TimiEmoPanelView.this.pageViewCachePool.remove(Integer.valueOf(position));
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return TimiEmoPanelView.this.mDataList.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @NotNull
        public Object instantiateItem(@NotNull ViewGroup container, int position) {
            Intrinsics.checkNotNullParameter(container, "container");
            zg4.d dVar = zg4.d.f452533a;
            Context context = this.f376815e;
            Object obj = TimiEmoPanelView.this.mDataList.get(position);
            Intrinsics.checkNotNullExpressionValue(obj, "mDataList[position]");
            bh4.a b16 = dVar.b(context, (xg4.a) obj, position, TimiEmoPanelView.this.mCreateParam);
            container.addView(b16.getView(), new ViewGroup.LayoutParams(-1, -1));
            TimiEmoPanelView.this.pageViewCachePool.put(Integer.valueOf(position), b16);
            return b16;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(@NotNull View view, @NotNull Object object) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(object, "object");
            if (view == object) {
                return true;
            }
            return false;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/timi/game/emo/ui/TimiEmoPanelView$d", "Lcom/tencent/timi/game/emo/ui/EmoPanelIndicator$c;", "", com.tencent.luggage.wxa.c8.c.G, "", "c", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class d implements EmoPanelIndicator.c {
        d() {
        }

        @Override // com.tencent.timi.game.emo.ui.EmoPanelIndicator.c
        public void c(int pos) {
            TimiEmoPanelView.this.binding.f421162c.setCurrentItem(pos, true);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TimiEmoPanelView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void g() {
        this.binding.f421162c.setAdapter(this.mPageAdapter);
        this.binding.f421162c.setOffscreenPageLimit(3);
        this.binding.f421162c.addOnPageChangeListener(new c());
        b bVar = b.f452827a;
        ViewPager viewPager = this.binding.f421162c;
        Intrinsics.checkNotNullExpressionValue(viewPager, "binding.panelViewPager");
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        bVar.a(viewPager, context);
        this.binding.f421161b.setItemClickListener(new d());
        this.binding.f421161b.setIndicatorLeftMarin(com.tencent.timi.game.utils.b.c(16));
    }

    public final void e() {
        Iterator<Map.Entry<Integer, bh4.a>> it = this.pageViewCachePool.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().destroy();
        }
    }

    @Nullable
    public final View f() {
        bh4.a aVar;
        View b16;
        int currentItem = this.binding.f421162c.getCurrentItem();
        if (!this.pageViewCachePool.containsKey(Integer.valueOf(currentItem)) || (aVar = this.pageViewCachePool.get(Integer.valueOf(currentItem))) == null || (b16 = aVar.b()) == null) {
            return null;
        }
        return b16;
    }

    public final boolean h() {
        bh4.a aVar;
        int currentItem = this.binding.f421162c.getCurrentItem();
        if (!this.pageViewCachePool.containsKey(Integer.valueOf(currentItem)) || (aVar = this.pageViewCachePool.get(Integer.valueOf(currentItem))) == null) {
            return false;
        }
        return aVar.d();
    }

    public final boolean i() {
        bh4.a aVar;
        int currentItem = this.binding.f421162c.getCurrentItem();
        if (!this.pageViewCachePool.containsKey(Integer.valueOf(currentItem)) || (aVar = this.pageViewCachePool.get(Integer.valueOf(currentItem))) == null) {
            return false;
        }
        return aVar.onBackEvent();
    }

    public final void j() {
        AbstractGifImage.resumeAll();
        Iterator<Map.Entry<Integer, bh4.a>> it = this.pageViewCachePool.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().a();
        }
    }

    public final void k(int yesGameId) {
        Iterator<Map.Entry<Integer, bh4.a>> it = this.pageViewCachePool.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().g(yesGameId);
        }
    }

    public final void setCreateParam(@NotNull m param) {
        Intrinsics.checkNotNullParameter(param, "param");
        this.mCreateParam = param;
    }

    public final void setData(@NotNull List<xg4.a> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.binding.f421161b.setData(data);
        this.mDataList.clear();
        this.mDataList.addAll(data);
        this.mPageAdapter.notifyDataSetChanged();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TimiEmoPanelView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ TimiEmoPanelView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TimiEmoPanelView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mDataList = new ArrayList<>();
        this.mCreateParam = new m(context, null, 0L, null, null, null, 0, 126, null);
        this.pageViewCachePool = new HashMap<>();
        x f16 = x.f(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.binding = f16;
        this.mPageAdapter = new a(context);
        g();
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/timi/game/emo/ui/TimiEmoPanelView$c", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "", "p0", "", "p1", "p2", "", WSComboHomePageChangeEvent.EVENT_ON_PAGE_SCROLLED, com.tencent.luggage.wxa.c8.c.G, "onPageSelected", "onPageScrollStateChanged", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c implements ViewPager.OnPageChangeListener {
        c() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int pos) {
            l.i("TimiEmoPanelView_", "onPageSelected pos:" + pos);
            TimiEmoPanelView.this.binding.f421161b.setSelectedPos(pos);
            Iterator it = TimiEmoPanelView.this.pageViewCachePool.entrySet().iterator();
            while (it.hasNext()) {
                ((bh4.a) ((Map.Entry) it.next()).getValue()).onPageSelected(pos);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int p06) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int p06, float p16, int p26) {
        }
    }
}
