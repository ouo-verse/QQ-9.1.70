package com.tencent.timi.game.ad.ui;

import af4.OperationData;
import af4.OperationItem;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.ViewPager;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.pubaccount.weishi.event.WSComboHomePageChangeEvent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.timi.game.liveroom.impl.room.widget.ChildViewPager;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import nr2.l;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 C2\u00020\u0001:\u0003DEFB;\b\u0007\u0012\u0006\u0010=\u001a\u00020<\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010>\u0012\b\b\u0002\u0010@\u001a\u00020\t\u0012\b\b\u0002\u0010\u001e\u001a\u00020\t\u0012\b\b\u0002\u0010%\u001a\u00020\u0005\u00a2\u0006\u0004\bA\u0010BJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\u0002H\u0002J\u000e\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0012\u001a\u00020\u0002J\u0010\u0010\u0015\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013J\u000e\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016J\u0006\u0010\u0019\u001a\u00020\u0002R\u0017\u0010\u001e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\"\u0010%\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010*R\u0014\u0010.\u001a\u00020,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010-R\u0016\u0010/\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u001bR$\u00104\u001a\u0012\u0012\u0004\u0012\u00020\u000b00j\b\u0012\u0004\u0012\u00020\u000b`18\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00107\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0014\u0010;\u001a\u0002088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u0010:\u00a8\u0006G"}, d2 = {"Lcom/tencent/timi/game/ad/ui/OperationItemView;", "Landroid/widget/RelativeLayout;", "", "i", "k", "", "reCreate", "p", "l", "", "index", "Landroid/view/View;", "indicator", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, "Laf4/c;", "data", "setData", "o", "Lcom/tencent/timi/game/ad/ui/OperationItemView$b;", "jumpInterceptor", "setJumpInterceptor", "Lcom/tencent/timi/game/ad/ui/OperationItemView$c;", "skinCallback", "setSkinCallback", h.F, "d", "I", "getPos", "()I", com.tencent.luggage.wxa.c8.c.G, "e", "Z", "getMIsLandscape", "()Z", "setMIsLandscape", "(Z)V", "mIsLandscape", "Lnr2/l;", "f", "Lnr2/l;", "binding", "Laf4/c;", "mData", "Lcom/tencent/timi/game/ad/ui/f;", "Lcom/tencent/timi/game/ad/ui/f;", "mPageAdapter", "mCurrentIndex", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/ArrayList;", "mIndicatorViews", "D", "Lcom/tencent/timi/game/ad/ui/OperationItemView$c;", "mSkinCallback", "Ljava/lang/Runnable;", "E", "Ljava/lang/Runnable;", "mLoopTask", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;IIZ)V", UserInfo.SEX_FEMALE, "a", "b", "c", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class OperationItemView extends RelativeLayout {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<View> mIndicatorViews;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private c mSkinCallback;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Runnable mLoopTask;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int pos;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean mIsLandscape;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private l binding;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private OperationData mData;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final f mPageAdapter;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int mCurrentIndex;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/timi/game/ad/ui/OperationItemView$b;", "", "Laf4/d;", "itemData", "", "a", "", "b", "c", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public interface b {
        void a(@NotNull OperationItem itemData);

        boolean b(@NotNull OperationItem itemData);

        void c(@NotNull OperationItem itemData);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/timi/game/ad/ui/OperationItemView$c;", "", "", "b", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public interface c {
        int a();

        int b();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/timi/game/ad/ui/OperationItemView$e", "Lcom/tencent/timi/game/ad/ui/OperationItemView$c;", "", "b", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class e implements c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f376242a;

        e(Context context) {
            this.f376242a = context;
        }

        @Override // com.tencent.timi.game.ad.ui.OperationItemView.c
        public int a() {
            return this.f376242a.getResources().getColor(R.color.ala);
        }

        @Override // com.tencent.timi.game.ad.ui.OperationItemView.c
        public int b() {
            return -1;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OperationItemView(@NotNull Context context) {
        this(context, null, 0, 0, false, 30, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void i() {
        this.binding.f421091c.setAdapter(this.mPageAdapter);
        this.binding.f421091c.setOffscreenPageLimit(3);
        this.binding.f421091c.setPageMargin(com.tencent.timi.game.utils.b.a(16));
        this.binding.f421091c.addOnPageChangeListener(new d());
        n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(OperationItemView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.mData.i().isEmpty()) {
            return;
        }
        boolean z16 = true;
        int size = (this$0.mCurrentIndex + 1) % this$0.mData.i().size();
        if (size != this$0.binding.f421091c.getCurrentItem()) {
            ChildViewPager childViewPager = this$0.binding.f421091c;
            if (size == 0) {
                z16 = false;
            }
            childViewPager.setCurrentItem(size, z16);
        }
    }

    private final void k() {
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.mLoopTask);
        this.mPageAdapter.h(this.mData);
        this.mCurrentIndex = this.binding.f421091c.getCurrentItem();
        p(true);
        ThreadManagerV2.getUIHandlerV2().postDelayed(this.mLoopTask, 5000L);
    }

    private final void l() {
        if (this.mIndicatorViews.size() <= 1) {
            this.binding.f421090b.setVisibility(8);
            return;
        }
        this.binding.f421090b.removeAllViews();
        Iterator<View> it = this.mIndicatorViews.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            int i16 = i3 + 1;
            View next = it.next();
            m(i3, next);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.tencent.timi.game.utils.b.a(4), com.tencent.timi.game.utils.b.a(4));
            layoutParams.leftMargin = com.tencent.timi.game.utils.b.a(2);
            layoutParams.rightMargin = com.tencent.timi.game.utils.b.a(2);
            this.binding.f421090b.addView(next, layoutParams);
            i3 = i16;
        }
        this.binding.f421090b.setVisibility(0);
    }

    private final void m(int index, View indicator) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        if (index == this.mCurrentIndex) {
            gradientDrawable.setColor(this.mSkinCallback.b());
        } else {
            gradientDrawable.setColor(this.mSkinCallback.a());
        }
        indicator.setBackgroundDrawable(gradientDrawable);
    }

    private final void n() {
        try {
            int i3 = ViewPager.SCROLL_STATE_IDLE;
            Field declaredField = ViewPager.class.getDeclaredField("mScroller");
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            zn4.c cVar = new zn4.c(context, new zn4.a(0.25f, 0.1f, 0.25f, 1.0f));
            declaredField.setAccessible(true);
            declaredField.set(this.binding.f421091c, cVar);
        } catch (Exception e16) {
            QLog.e("OperationItemView_", 1, "initViewPager error:", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p(boolean reCreate) {
        if (this.mData.i().size() <= 1) {
            l();
            return;
        }
        if (reCreate) {
            this.mIndicatorViews.clear();
            for (OperationItem operationItem : this.mData.i()) {
                this.mIndicatorViews.add(new View(getContext()));
            }
            l();
            return;
        }
        Iterator<View> it = this.mIndicatorViews.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            m(i3, it.next());
            i3++;
        }
    }

    public final void h() {
        this.mPageAdapter.destroy();
    }

    public final void o() {
        this.mPageAdapter.j();
    }

    public final void setData(@NotNull OperationData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.mData = data;
        k();
    }

    public final void setJumpInterceptor(@Nullable b jumpInterceptor) {
        this.mPageAdapter.i(jumpInterceptor);
    }

    public final void setMIsLandscape(boolean z16) {
        this.mIsLandscape = z16;
    }

    public final void setSkinCallback(@NotNull c skinCallback) {
        Intrinsics.checkNotNullParameter(skinCallback, "skinCallback");
        this.mSkinCallback = skinCallback;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OperationItemView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, false, 28, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OperationItemView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0, false, 24, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ OperationItemView(Context context, AttributeSet attributeSet, int i3, int i16, boolean z16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i17 & 2) != 0 ? null : attributeSet, (i17 & 4) != 0 ? 0 : i3, (i17 & 8) != 0 ? 0 : i16, (i17 & 16) != 0 ? false : z16);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OperationItemView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16, boolean z16) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.pos = i16;
        this.mIsLandscape = z16;
        this.mData = new OperationData(0, null, 3, null);
        this.mIndicatorViews = new ArrayList<>();
        this.mSkinCallback = new e(context);
        l f16 = l.f(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.binding = f16;
        this.mPageAdapter = new f(context, i16, this.mIsLandscape);
        i();
        this.mLoopTask = new Runnable() { // from class: com.tencent.timi.game.ad.ui.g
            @Override // java.lang.Runnable
            public final void run() {
                OperationItemView.j(OperationItemView.this);
            }
        };
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/timi/game/ad/ui/OperationItemView$d", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "", "p0", "", "p1", "p2", "", WSComboHomePageChangeEvent.EVENT_ON_PAGE_SCROLLED, com.tencent.luggage.wxa.c8.c.G, "onPageSelected", "onPageScrollStateChanged", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class d implements ViewPager.OnPageChangeListener {
        d() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int pos) {
            com.tencent.timi.game.utils.l.i("OperationItemView_", "onPageSelected pos:" + pos);
            OperationItemView operationItemView = OperationItemView.this;
            operationItemView.mCurrentIndex = operationItemView.binding.f421091c.getCurrentItem();
            OperationItemView.this.p(false);
            ThreadManagerV2.getUIHandlerV2().removeCallbacks(OperationItemView.this.mLoopTask);
            ThreadManagerV2.getUIHandlerV2().postDelayed(OperationItemView.this.mLoopTask, 5000L);
            OperationData operationData = OperationItemView.this.mData;
            OperationItemView operationItemView2 = OperationItemView.this;
            if (operationItemView2.mCurrentIndex < operationData.i().size()) {
                OperationItem operationItem = operationData.i().get(operationItemView2.mCurrentIndex);
                af4.g.f26031a.g(String.valueOf(operationItem.getIAdId()), operationItem.getTraceInfo(), 101);
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
