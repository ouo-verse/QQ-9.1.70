package com.tencent.mobileqq.guild.component.banner;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.mobileqq.guild.component.banner.DownToUpViewSwitcher;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import kotlin.C11734b;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pg1.BannerStyleManager;
import pg1.i;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0083\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001N\u0018\u0000 =2\u00020\u0001:\u000369;B\u001d\b\u0007\u0012\u0006\u0010[\u001a\u00020Z\u0012\n\b\u0002\u0010]\u001a\u0004\u0018\u00010\\\u00a2\u0006\u0004\b^\u0010_J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\nH\u0002J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0002H\u0002J\u000e\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011J\u000e\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0002J\u000e\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0002J\u000e\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\bJ\u000e\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0002J\u000e\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\bJ\u000e\u0010 \u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u001eJ\u0010\u0010\"\u001a\u00020\u00052\b\b\u0002\u0010!\u001a\u00020\bJ\u000e\u0010#\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010&\u001a\u00020\u00052\u0006\u0010%\u001a\u00020$J\u000e\u0010(\u001a\u00020\u00052\u0006\u0010'\u001a\u00020$J\u0012\u0010+\u001a\u00020\u00052\n\u0010*\u001a\u0006\u0012\u0002\b\u00030)J\u0006\u0010,\u001a\u00020\u0002J\u0006\u0010-\u001a\u00020\u0002J\u001a\u0010/\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u00022\b\b\u0002\u0010!\u001a\u00020\bH\u0007J\u0010\u00102\u001a\u00020\b2\u0006\u00101\u001a\u000200H\u0016J\u0018\u00105\u001a\u00020\u00052\u0006\u00103\u001a\u00020\u00022\u0006\u00104\u001a\u00020\u0002H\u0014R\u0016\u00108\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010:\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u00107R\u0016\u0010\u0018\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010>\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010=R\u0016\u0010@\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010<R\u0014\u0010C\u001a\u00020A8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010BR\u0014\u0010G\u001a\u00020D8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u001b\u0010M\u001a\u00020H8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\bI\u0010J\u001a\u0004\bK\u0010LR\u0014\u0010Q\u001a\u00020N8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010T\u001a\u00020R8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010SR\u0016\u0010V\u001a\u00020R8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010SR\u0016\u0010X\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010<R\u0014\u0010Y\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00107\u00a8\u0006`"}, d2 = {"Lcom/tencent/mobileqq/guild/component/banner/DownToUpViewSwitcher;", "Landroid/widget/FrameLayout;", "", "position", "l", "", ReportConstant.COSTREPORT_PREFIX, h.F, "", "k", "Landroid/view/View;", "itemView", "j", "view", "p", "itemHeight", "w", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "pool", "setRecycledViewPool", "margin", "setItemMargin", "count", "setShowItemCount", "loop", "setLoop", LayoutAttrDefine.Gravity.Gravity, "setGravity", "auto", "setAutoScroll", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "callback", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "smoothScroll", "u", DomainData.DOMAIN_NAME, "", WidgetCacheConstellationData.INTERVAL, "setAutoScrollInterval", "duration", "setScrollDurationPerItem", "Lcom/tencent/mobileqq/guild/component/banner/DownToUpViewSwitcher$d;", "adapter", "setAdapter", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "o", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "setCurrentItem", "Landroid/view/MotionEvent;", "ev", "dispatchTouchEvent", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "d", "I", "showItemCount", "e", "itemMargin", "f", "Z", "J", "scrollDurationPerItem", "i", "needIntecepterTouchEvent", "Landroidx/viewpager2/widget/ViewPager2;", "Landroidx/viewpager2/widget/ViewPager2;", "viewPager2", "Lpg1/e;", BdhLogUtil.LogTag.Tag_Conn, "Lpg1/e;", "styleManager", "Landroidx/recyclerview/widget/RecyclerView;", "D", "Lkotlin/Lazy;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "com/tencent/mobileqq/guild/component/banner/DownToUpViewSwitcher$g", "E", "Lcom/tencent/mobileqq/guild/component/banner/DownToUpViewSwitcher$g;", "adapterDataObserver", "", UserInfo.SEX_FEMALE, "touchDownX", "G", "touchDownY", "H", "touchEventHandled", "touchSlop", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class DownToUpViewSwitcher extends FrameLayout {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final BannerStyleManager styleManager;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy recyclerView;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final g adapterDataObserver;

    /* renamed from: F, reason: from kotlin metadata */
    private float touchDownX;

    /* renamed from: G, reason: from kotlin metadata */
    private float touchDownY;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean touchEventHandled;

    /* renamed from: I, reason: from kotlin metadata */
    private final int touchSlop;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int showItemCount;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int itemMargin;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean loop;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private long scrollDurationPerItem;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean needIntecepterTouchEvent;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ViewPager2 viewPager2;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/component/banner/DownToUpViewSwitcher$a", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "", "state", "", "onPageScrollStateChanged", "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class a extends ViewPager2.OnPageChangeCallback {
        a() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int state) {
            if (state != 1) {
                DownToUpViewSwitcher.this.h();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/component/banner/DownToUpViewSwitcher$b", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b extends RecyclerView.OnScrollListener {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, newState);
            if (newState == 0) {
                C11734b c11734b = C11734b.f433780a;
                DownToUpViewSwitcher downToUpViewSwitcher = DownToUpViewSwitcher.this;
                if (QLog.isDebugVersion()) {
                    QLog.d("Guild.component.DownToUpViewSwitcher", 2, downToUpViewSwitcher.viewPager2.hashCode() + " recyclerView contentHeight: " + ((recyclerView.getHeight() - recyclerView.getPaddingTop()) - recyclerView.getPaddingBottom()), (Throwable) null);
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/component/banner/DownToUpViewSwitcher$c", "Landroid/view/View$AccessibilityDelegate;", "Landroid/view/View;", "host", "Landroid/view/accessibility/AccessibilityNodeInfo;", "info", "", "onInitializeAccessibilityNodeInfo", "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class c extends View.AccessibilityDelegate {
        c() {
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(@NotNull View host, @NotNull AccessibilityNodeInfo info) {
            Intrinsics.checkNotNullParameter(host, "host");
            Intrinsics.checkNotNullParameter(info, "info");
            info.setVisibleToUser(false);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\b\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b\b\u0010\tJ\u001f\u0010\n\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&\u00a2\u0006\u0004\b\n\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/component/banner/DownToUpViewSwitcher$d;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "T", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "i0", "<init>", "()V", "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static abstract class d<T extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<T> {
        @NotNull
        public abstract T i0(@NotNull ViewGroup parent, int viewType);

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NotNull
        public final T onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            T i06 = i0(parent, viewType);
            ViewGroup.LayoutParams layoutParams = i06.itemView.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = -1;
                layoutParams.height = -1;
            } else {
                layoutParams = new ViewGroup.LayoutParams(-1, -1);
            }
            i06.itemView.setLayoutParams(layoutParams);
            return i06;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\b\u0006*\u0001\u0011\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\t\u00a2\u0006\u0004\b\u0015\u0010\u000fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/component/banner/DownToUpViewSwitcher$f;", "Lpg1/d;", "Landroidx/viewpager2/widget/ViewPager2;", "viewPager2", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "a", "b", "", "d", "I", "c", "()I", "setMargin", "(I)V", "margin", "com/tencent/mobileqq/guild/component/banner/DownToUpViewSwitcher$f$a", "e", "Lcom/tencent/mobileqq/guild/component/banner/DownToUpViewSwitcher$f$a;", "itemDecoration", "<init>", "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class f extends pg1.d {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private int margin;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final a itemDecoration = new a();

        /* compiled from: P */
        @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/guild/component/banner/DownToUpViewSwitcher$f$a", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes12.dex */
        public static final class a extends RecyclerView.ItemDecoration {
            a() {
            }

            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
                Intrinsics.checkNotNullParameter(outRect, "outRect");
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(parent, "parent");
                Intrinsics.checkNotNullParameter(state, "state");
                super.getItemOffsets(outRect, view, parent, state);
                outRect.set(0, f.this.getMargin(), 0, 0);
            }
        }

        public f(int i3) {
            this.margin = i3;
        }

        @Override // pg1.d
        public void a(@NotNull ViewPager2 viewPager2, @NotNull RecyclerView recyclerView) {
            Intrinsics.checkNotNullParameter(viewPager2, "viewPager2");
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            viewPager2.addItemDecoration(this.itemDecoration);
        }

        @Override // pg1.d
        public void b(@NotNull ViewPager2 viewPager2, @NotNull RecyclerView recyclerView) {
            Intrinsics.checkNotNullParameter(viewPager2, "viewPager2");
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            viewPager2.removeItemDecoration(this.itemDecoration);
        }

        /* renamed from: c, reason: from getter */
        public final int getMargin() {
            return this.margin;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/component/banner/DownToUpViewSwitcher$g", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "", "onChanged", "", "positionStart", "itemCount", "onItemRangeInserted", "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class g extends RecyclerView.AdapterDataObserver {
        g() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(DownToUpViewSwitcher this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.viewPager2.requestTransform();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(DownToUpViewSwitcher this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.viewPager2.requestTransform();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            super.onChanged();
            DownToUpViewSwitcher.this.k();
            DownToUpViewSwitcher.this.styleManager.h();
            DownToUpViewSwitcher.this.h();
            ViewPager2 viewPager2 = DownToUpViewSwitcher.this.viewPager2;
            final DownToUpViewSwitcher downToUpViewSwitcher = DownToUpViewSwitcher.this;
            viewPager2.post(new Runnable() { // from class: com.tencent.mobileqq.guild.component.banner.f
                @Override // java.lang.Runnable
                public final void run() {
                    DownToUpViewSwitcher.g.c(DownToUpViewSwitcher.this);
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int positionStart, int itemCount) {
            super.onItemRangeInserted(positionStart, itemCount);
            DownToUpViewSwitcher.this.k();
            DownToUpViewSwitcher.this.styleManager.h();
            ViewPager2 viewPager2 = DownToUpViewSwitcher.this.viewPager2;
            final DownToUpViewSwitcher downToUpViewSwitcher = DownToUpViewSwitcher.this;
            viewPager2.post(new Runnable() { // from class: com.tencent.mobileqq.guild.component.banner.e
                @Override // java.lang.Runnable
                public final void run() {
                    DownToUpViewSwitcher.g.d(DownToUpViewSwitcher.this);
                }
            });
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DownToUpViewSwitcher(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h() {
        int currentItem = this.viewPager2.getCurrentItem();
        int i3 = this.showItemCount;
        if (currentItem < i3 - 1) {
            this.viewPager2.setCurrentItem(i3 - 1, false);
            this.viewPager2.post(new Runnable() { // from class: com.tencent.mobileqq.guild.component.banner.b
                @Override // java.lang.Runnable
                public final void run() {
                    DownToUpViewSwitcher.i(DownToUpViewSwitcher.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(DownToUpViewSwitcher this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.viewPager2.requestTransform();
    }

    private final void j(View itemView) {
        p(itemView);
        w(itemView.getMeasuredHeight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean k() {
        int i3;
        d dVar;
        RecyclerView.ViewHolder i06;
        pg1.g gVar;
        Object obj;
        if (this.viewPager2.getLayoutParams().height == -1) {
            RecyclerView.Adapter adapter = this.viewPager2.getAdapter();
            if (adapter != null) {
                i3 = adapter.getItemCount();
            } else {
                i3 = 0;
            }
            if (i3 > 0) {
                RecyclerView.Adapter adapter2 = this.viewPager2.getAdapter();
                d dVar2 = null;
                if (adapter2 instanceof d) {
                    dVar = (d) adapter2;
                } else {
                    dVar = null;
                }
                if (dVar == null) {
                    Object adapter3 = this.viewPager2.getAdapter();
                    if (adapter3 instanceof pg1.g) {
                        gVar = (pg1.g) adapter3;
                    } else {
                        gVar = null;
                    }
                    if (gVar != null) {
                        obj = gVar.m();
                    } else {
                        obj = null;
                    }
                    if (obj instanceof d) {
                        dVar2 = (d) obj;
                    }
                } else {
                    dVar2 = dVar;
                }
                if (dVar2 != null && (i06 = dVar2.i0(this.styleManager.getRecyclerView(), dVar2.getItemViewType(0))) != null) {
                    View view = i06.itemView;
                    Intrinsics.checkNotNullExpressionValue(view, "it.itemView");
                    j(view);
                    return true;
                }
            }
        }
        return false;
    }

    private final int l(int position) {
        RecyclerView.Adapter adapter = this.viewPager2.getAdapter();
        if (adapter instanceof i) {
            return ((i) adapter).q(position);
        }
        return position;
    }

    private final void p(View view) {
        int i3;
        int i16;
        int makeMeasureSpec;
        int makeMeasureSpec2;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        int i17 = -2;
        if (layoutParams != null) {
            i3 = layoutParams.width;
        } else {
            i3 = -2;
        }
        ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
        if (layoutParams2 != null) {
            i16 = layoutParams2.height;
        } else {
            i16 = -2;
        }
        if (i3 >= 0) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getWidth(), Integer.MIN_VALUE);
        }
        ViewGroup.LayoutParams layoutParams3 = view.getLayoutParams();
        if (layoutParams3 != null) {
            i17 = layoutParams3.height;
        }
        if (i17 >= 0) {
            makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i16, 1073741824);
        } else {
            makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(makeMeasureSpec, makeMeasureSpec2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(DownToUpViewSwitcher this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.viewPager2.requestTransform();
    }

    private final void s() {
        this.viewPager2.setPageTransformer(new ViewPager2.PageTransformer() { // from class: com.tencent.mobileqq.guild.component.banner.d
            @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
            public final void transformPage(View view, float f16) {
                DownToUpViewSwitcher.t(DownToUpViewSwitcher.this, view, f16);
            }
        });
    }

    public static /* synthetic */ void setCurrentItem$default(DownToUpViewSwitcher downToUpViewSwitcher, int i3, boolean z16, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            z16 = true;
        }
        downToUpViewSwitcher.setCurrentItem(i3, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(DownToUpViewSwitcher this$0, View page, float f16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(page, "page");
        int i3 = -(this$0.showItemCount - 1);
        float f17 = i3;
        if (f16 >= f17 && f16 <= 0) {
            page.setAlpha(1.0f);
            return;
        }
        if (f16 > 0) {
            float f18 = 1;
            if (f16 < f18) {
                page.setAlpha(f18 - f16);
                return;
            }
        }
        if (f16 < f17) {
            float f19 = i3 - 1;
            if (f16 > f19) {
                page.setAlpha(f16 - f19);
                return;
            }
        }
        page.setAlpha(0.0f);
    }

    public static /* synthetic */ void v(DownToUpViewSwitcher downToUpViewSwitcher, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        downToUpViewSwitcher.u(z16);
    }

    private final void w(int itemHeight) {
        int i3 = this.showItemCount + 2;
        int i16 = (i3 * itemHeight) + ((i3 - 1) * this.itemMargin);
        this.viewPager2.getLayoutParams().height = i16;
        this.viewPager2.requestLayout();
        C11734b c11734b = C11734b.f433780a;
        if (QLog.isDebugVersion()) {
            QLog.d("Guild.component.DownToUpViewSwitcher", 2, "updateViewPager2Height, itemHeight: " + itemHeight + ", viewPager2Height: " + i16 + ", edgeDistance: " + ((i16 - itemHeight) / 2), (Throwable) null);
        }
        this.viewPager2.setClipChildren(false);
        this.viewPager2.setClipToPadding(false);
        this.styleManager.getRecyclerView().setClipChildren(false);
        this.styleManager.getRecyclerView().setClipToPadding(false);
        RecyclerView recyclerView = this.styleManager.getRecyclerView();
        int i17 = this.itemMargin;
        recyclerView.setPadding(recyclerView.getPaddingLeft(), i16 - ((itemHeight + i17) * 2), recyclerView.getPaddingRight(), itemHeight + i17);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(@NotNull MotionEvent ev5) {
        int i3;
        boolean z16;
        boolean z17;
        ViewParent parent;
        Intrinsics.checkNotNullParameter(ev5, "ev");
        if (!this.needIntecepterTouchEvent) {
            return super.dispatchTouchEvent(ev5);
        }
        if (this.viewPager2.isUserInputEnabled()) {
            RecyclerView.Adapter adapter = this.viewPager2.getAdapter();
            boolean z18 = false;
            if (adapter != null) {
                i3 = adapter.getItemCount();
            } else {
                i3 = 0;
            }
            if (i3 > 1) {
                if (ev5.getActionMasked() == 0) {
                    ViewParent parent2 = getParent();
                    if (parent2 != null) {
                        parent2.requestDisallowInterceptTouchEvent(true);
                    }
                    this.touchDownX = ev5.getX();
                    this.touchDownY = ev5.getY();
                    this.touchEventHandled = false;
                }
                if (this.touchEventHandled) {
                    return super.dispatchTouchEvent(ev5);
                }
                if (ev5.getActionMasked() == 2) {
                    RecyclerView.LayoutManager layoutManager = this.styleManager.getRecyclerView().getLayoutManager();
                    if (layoutManager != null && layoutManager.canScrollHorizontally()) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (!z16 && Math.abs(ev5.getX() - this.touchDownX) > this.touchSlop) {
                        ViewParent parent3 = getParent();
                        if (parent3 != null) {
                            parent3.requestDisallowInterceptTouchEvent(false);
                        }
                    } else {
                        RecyclerView.LayoutManager layoutManager2 = this.styleManager.getRecyclerView().getLayoutManager();
                        if (layoutManager2 != null && layoutManager2.canScrollVertically()) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        if (!z17 && Math.abs(ev5.getY() - this.touchDownY) > this.touchSlop && (parent = getParent()) != null) {
                            parent.requestDisallowInterceptTouchEvent(false);
                        }
                    }
                }
                boolean dispatchTouchEvent = super.dispatchTouchEvent(ev5);
                if (this.viewPager2.getScrollState() == 1) {
                    z18 = true;
                }
                this.touchEventHandled = z18;
                return dispatchTouchEvent;
            }
        }
        return super.dispatchTouchEvent(ev5);
    }

    public final int m() {
        return this.viewPager2.getCurrentItem();
    }

    public final int n(int position) {
        RecyclerView.Adapter adapter = this.viewPager2.getAdapter();
        if (adapter instanceof i) {
            return ((i) adapter).R(position);
        }
        return position;
    }

    public final int o() {
        return this.viewPager2.getScrollState();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        h();
        k();
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public final void q(@NotNull ViewPager2.OnPageChangeCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.viewPager2.registerOnPageChangeCallback(callback);
    }

    public final void setAdapter(@NotNull d<?> adapter) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        this.viewPager2.getAdapter();
        this.viewPager2.setAdapter(adapter);
        adapter.registerAdapterDataObserver(this.adapterDataObserver);
        this.styleManager.l(this.loop);
        this.viewPager2.setCurrentItem(this.showItemCount - 1, false);
    }

    public final void setAutoScroll(boolean auto) {
        this.styleManager.k(auto);
    }

    public final void setAutoScrollInterval(long interval) {
        this.styleManager.j(interval);
    }

    @JvmOverloads
    public final void setCurrentItem(int i3) {
        setCurrentItem$default(this, i3, false, 2, null);
    }

    public final void setGravity(int gravity) {
        ViewGroup.LayoutParams layoutParams = this.viewPager2.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        layoutParams2.gravity = gravity;
        this.viewPager2.setLayoutParams(layoutParams2);
    }

    public final void setItemMargin(int margin) {
        this.itemMargin = margin;
        this.styleManager.g(new f(margin));
    }

    public final void setLoop(boolean loop) {
        this.loop = loop;
    }

    public final void setRecycledViewPool(@NotNull RecyclerView.RecycledViewPool pool) {
        Intrinsics.checkNotNullParameter(pool, "pool");
        this.styleManager.getRecyclerView().setRecycledViewPool(pool);
    }

    public final void setScrollDurationPerItem(long duration) {
        this.scrollDurationPerItem = duration;
        this.styleManager.n(duration);
    }

    public final void setShowItemCount(int count) {
        this.showItemCount = count;
        h();
    }

    public final void u(boolean smoothScroll) {
        if (this.viewPager2.getAdapter() != null) {
            ViewPager2 viewPager2 = this.viewPager2;
            viewPager2.setCurrentItem(l(viewPager2.getCurrentItem() + 1), smoothScroll);
        }
    }

    public /* synthetic */ DownToUpViewSwitcher(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    @JvmOverloads
    public final void setCurrentItem(int item, boolean smoothScroll) {
        int i3 = this.showItemCount;
        if (item < i3 - 1) {
            this.viewPager2.setCurrentItem(i3 - 1, smoothScroll);
        } else {
            this.viewPager2.setCurrentItem(item, smoothScroll);
        }
        if (smoothScroll) {
            return;
        }
        this.viewPager2.post(new Runnable() { // from class: com.tencent.mobileqq.guild.component.banner.c
            @Override // java.lang.Runnable
            public final void run() {
                DownToUpViewSwitcher.r(DownToUpViewSwitcher.this);
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DownToUpViewSwitcher(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        this.showItemCount = 1;
        this.scrollDurationPerItem = 200L;
        ViewPager2 viewPager2 = new ViewPager2(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        addView(viewPager2, layoutParams);
        this.viewPager2 = viewPager2;
        BannerStyleManager bannerStyleManager = new BannerStyleManager(viewPager2);
        this.styleManager = bannerStyleManager;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<RecyclerView>() { // from class: com.tencent.mobileqq.guild.component.banner.DownToUpViewSwitcher$recyclerView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final RecyclerView invoke() {
                return DownToUpViewSwitcher.this.styleManager.getRecyclerView();
            }
        });
        this.recyclerView = lazy;
        this.adapterDataObserver = new g();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.tencent.mobileqq.guild.component.b.f215763v0, 0, 0);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr\u2026wnToUpViewSwitcher, 0, 0)");
        int i3 = com.tencent.mobileqq.guild.component.b.f215782y0;
        kotlin.g gVar = kotlin.g.f433789a;
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        setItemMargin(obtainStyledAttributes.getDimensionPixelSize(i3, gVar.b(10.0f, resources)));
        setShowItemCount(obtainStyledAttributes.getInt(com.tencent.mobileqq.guild.component.b.B0, this.showItemCount));
        setLoop(obtainStyledAttributes.getBoolean(com.tencent.mobileqq.guild.component.b.f215789z0, this.loop));
        int i16 = obtainStyledAttributes.getInt(com.tencent.mobileqq.guild.component.b.f215775x0, 5000);
        int i17 = obtainStyledAttributes.getInt(com.tencent.mobileqq.guild.component.b.A0, 200);
        setAutoScrollInterval(i16);
        setScrollDurationPerItem(i17);
        setGravity(obtainStyledAttributes.getInt(com.tencent.mobileqq.guild.component.b.f215769w0, 17));
        obtainStyledAttributes.recycle();
        viewPager2.setOrientation(1);
        viewPager2.registerOnPageChangeCallback(new a());
        bannerStyleManager.b(false);
        bannerStyleManager.k(true);
        bannerStyleManager.getRecyclerView().addOnScrollListener(new b());
        s();
        bannerStyleManager.getRecyclerView().setAccessibilityDelegate(new c());
        this.touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }
}
