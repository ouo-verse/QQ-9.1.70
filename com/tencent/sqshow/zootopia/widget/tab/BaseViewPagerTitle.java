package com.tencent.sqshow.zootopia.widget.tab;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.viewpager.widget.ViewPager;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.pubaccount.weishi.event.WSComboHomePageChangeEvent;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.widget.tab.BaseViewPagerTitle;
import com.tencent.sqshow.zootopia.widget.tab.BaseViewPagerTitle.a;
import com.tencent.sqshow.zootopia.widget.tab.BaseViewPagerTitle.c;
import com.tencent.sqshow.zootopia.widget.tab.BaseZPlanTabTitleData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import t74.u;
import tl.h;
import vc4.i;
import vc4.l;

@Metadata(d1 = {"\u0000\u00a3\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001g\b&\u0018\u0000 w*\b\b\u0000\u0010\u0002*\u00020\u0001*\u0004\b\u0001\u0010\u0003*\u000e\b\u0002\u0010\u0005*\b\u0012\u0004\u0012\u00028\u00010\u0004*\b\b\u0003\u0010\u0007*\u00020\u00062\u00020\b2\u0014\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\t:\u0003<?xB'\b\u0007\u0012\u0006\u0010q\u001a\u00020p\u0012\n\b\u0002\u0010s\u001a\u0004\u0018\u00010r\u0012\b\b\u0002\u0010t\u001a\u00020\u0010\u00a2\u0006\u0004\bu\u0010vJ\b\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\nH\u0002J/\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00028\u00022\u0006\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00020\fH\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\"\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u0018H\u0002J\"\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u0018H\u0002J\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001d\u001a\u00020\u0010H\u0002J\u0018\u0010\"\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u0010H\u0002J\b\u0010$\u001a\u00020#H$J\u0017\u0010%\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00028\u0002H$\u00a2\u0006\u0004\b%\u0010&J/\u0010'\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00028\u00022\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00028\u0000H&\u00a2\u0006\u0004\b'\u0010(J9\u0010*\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00028\u00002\u0006\u0010)\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00028\u00022\b\b\u0002\u0010\u001a\u001a\u00020\u0018H&\u00a2\u0006\u0004\b*\u0010+J'\u0010,\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00028\u0002H&\u00a2\u0006\u0004\b,\u0010-J\u0017\u0010.\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b.\u0010/J\b\u00100\u001a\u00020\nH\u0014J\u0016\u00104\u001a\u00020\n2\u0006\u00102\u001a\u0002012\u0006\u00103\u001a\u00020\u0010J\u0010\u00107\u001a\u00020\n2\b\u00106\u001a\u0004\u0018\u000105J\u001e\u0010:\u001a\u00020\n2\f\u00109\u001a\b\u0012\u0004\u0012\u00028\u0002082\u0006\u0010\u0017\u001a\u00020\u0010H\u0016J\u0010\u0010<\u001a\u00020\n2\u0006\u0010;\u001a\u00020\u0010H\u0016J\u0010\u0010?\u001a\u00020\n2\u0006\u0010>\u001a\u00020=H\u0016J\u0017\u0010@\u001a\u00020\n2\u0006\u0010%\u001a\u00028\u0003H\u0016\u00a2\u0006\u0004\b@\u0010AJ\u0006\u0010B\u001a\u00020\nJ\b\u0010D\u001a\u00020CH\u0016R\u001a\u0010I\u001a\u00020\f8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bG\u0010HR\u0014\u0010L\u001a\u00020C8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u001a\u0010O\u001a\b\u0012\u0004\u0012\u00028\u00000M8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010NR \u0010T\u001a\b\u0012\u0004\u0012\u00028\u00020P8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\"\u0010Q\u001a\u0004\bR\u0010SR\u0018\u0010V\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010UR\u0016\u0010X\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010WR\"\u0010_\u001a\u00020Y8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010Z\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R\"\u0010a\u001a\u00020Y8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010Z\u001a\u0004\b`\u0010\\\"\u0004\bZ\u0010^R\u0018\u0010c\u001a\u0004\u0018\u00018\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010bR\u0018\u0010e\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010dR\u0016\u0010f\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010WR,\u0010j\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030g8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bh\u0010iR$\u00106\u001a\u0004\u0018\u0001058\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bW\u0010k\u001a\u0004\bl\u0010m\"\u0004\bn\u0010o\u00a8\u0006y"}, d2 = {"Lcom/tencent/sqshow/zootopia/widget/tab/BaseViewPagerTitle;", "Lcom/tencent/sqshow/zootopia/widget/tab/BaseViewPagerTitle$a;", "V", "T", "Lcom/tencent/sqshow/zootopia/widget/tab/BaseZPlanTabTitleData;", "D", "Lcom/tencent/sqshow/zootopia/widget/tab/BaseViewPagerTitle$c;", "L", "Landroid/widget/FrameLayout;", "Lvc4/i;", "", "t", "Landroid/widget/LinearLayout;", "titleContainer", "r", ReportConstant.COSTREPORT_PREFIX, "", "index", "data", "holder", ParseCommon.CONTAINER, "f", "(ILcom/tencent/sqshow/zootopia/widget/tab/BaseZPlanTabTitleData;Lcom/tencent/sqshow/zootopia/widget/tab/BaseViewPagerTitle$a;Landroid/widget/LinearLayout;)V", "selectedPos", "", "withAnim", "formUserSelected", "B", HippyTKDListViewAdapter.X, "position", "Landroid/graphics/Rect;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "end", "indicatorWidth", h.F, "", "G", "l", "(Lcom/tencent/sqshow/zootopia/widget/tab/BaseZPlanTabTitleData;)Lcom/tencent/sqshow/zootopia/widget/tab/BaseViewPagerTitle$a;", "u", "(ILcom/tencent/sqshow/zootopia/widget/tab/BaseZPlanTabTitleData;Landroid/widget/LinearLayout;Lcom/tencent/sqshow/zootopia/widget/tab/BaseViewPagerTitle$a;)V", "selected", BdhLogUtil.LogTag.Tag_Conn, "(Lcom/tencent/sqshow/zootopia/widget/tab/BaseViewPagerTitle$a;ZILcom/tencent/sqshow/zootopia/widget/tab/BaseZPlanTabTitleData;Z)V", "v", "(Lcom/tencent/sqshow/zootopia/widget/tab/BaseViewPagerTitle$a;ILcom/tencent/sqshow/zootopia/widget/tab/BaseZPlanTabTitleData;)V", "w", "(Lcom/tencent/sqshow/zootopia/widget/tab/BaseViewPagerTitle$a;)V", "i", "Landroid/widget/HorizontalScrollView;", "view", "selfLeftMarin", "k", "Landroidx/lifecycle/LifecycleOwner;", "owner", "j", "", "titleList", "setTitleData", "pageIndex", "a", "Landroidx/viewpager/widget/ViewPager;", "viewPager", "b", "setTitleListener", "(Lcom/tencent/sqshow/zootopia/widget/tab/BaseViewPagerTitle$c;)V", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Landroid/view/View;", "getView", "d", "Landroid/widget/LinearLayout;", "o", "()Landroid/widget/LinearLayout;", "mTitleContainer", "e", "Landroid/view/View;", "mIndicatorView", "Ljava/util/LinkedList;", "Ljava/util/LinkedList;", "mTitleItemHolderPool", "Ljava/util/ArrayList;", "Ljava/util/ArrayList;", "p", "()Ljava/util/ArrayList;", "mTitleData", "Landroidx/viewpager/widget/ViewPager;", "mViewPager", "I", "mSelectedPos", "", UserInfo.SEX_FEMALE, DomainData.DOMAIN_NAME, "()F", "E", "(F)V", "mSelectedTxtSize", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "mUnselectedTxtSize", "Lcom/tencent/sqshow/zootopia/widget/tab/BaseViewPagerTitle$c;", "mTitleListener", "Landroid/widget/HorizontalScrollView;", "mParentScrollView", "mSelfLeftMarin", "com/tencent/sqshow/zootopia/widget/tab/BaseViewPagerTitle$d", "H", "Lcom/tencent/sqshow/zootopia/widget/tab/BaseViewPagerTitle$d;", "mPageChangeListener", "Landroidx/lifecycle/LifecycleOwner;", "getOwner", "()Landroidx/lifecycle/LifecycleOwner;", "setOwner", "(Landroidx/lifecycle/LifecycleOwner;)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "J", "c", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public abstract class BaseViewPagerTitle<V extends a, T, D extends BaseZPlanTabTitleData<T>, L extends c> extends FrameLayout implements i<T, D, L> {

    /* renamed from: C, reason: from kotlin metadata */
    private float mSelectedTxtSize;

    /* renamed from: D, reason: from kotlin metadata */
    private float mUnselectedTxtSize;

    /* renamed from: E, reason: from kotlin metadata */
    private L mTitleListener;

    /* renamed from: F, reason: from kotlin metadata */
    private HorizontalScrollView mParentScrollView;

    /* renamed from: G, reason: from kotlin metadata */
    private int mSelfLeftMarin;

    /* renamed from: H, reason: from kotlin metadata */
    private final d mPageChangeListener;

    /* renamed from: I, reason: from kotlin metadata */
    private LifecycleOwner owner;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final LinearLayout mTitleContainer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final View mIndicatorView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final LinkedList<V> mTitleItemHolderPool;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<D> mTitleData;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ViewPager mViewPager;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int mSelectedPos;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lcom/tencent/sqshow/zootopia/widget/tab/BaseViewPagerTitle$a;", "", "Landroid/view/View;", "a", "Landroid/view/View;", "()Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "<init>", "(Landroid/view/View;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final View rootView;

        public a(View rootView) {
            Intrinsics.checkNotNullParameter(rootView, "rootView");
            this.rootView = rootView;
        }

        /* renamed from: a, reason: from getter */
        public final View getRootView() {
            return this.rootView;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/sqshow/zootopia/widget/tab/BaseViewPagerTitle$c;", "Lvc4/l;", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public interface c extends l {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BaseViewPagerTitle(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void B(int selectedPos, boolean withAnim, boolean formUserSelected) {
        Iterator<V> it = this.mTitleItemHolderPool.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            int i16 = i3 + 1;
            V next = it.next();
            boolean z16 = i3 == selectedPos;
            if (formUserSelected && z16) {
                w(next);
            }
            D d16 = this.mTitleData.get(i3);
            Intrinsics.checkNotNullExpressionValue(d16, "mTitleData[index]");
            D(this, next, z16, i3, d16, false, 16, null);
            i3 = i16;
        }
        ViewPager viewPager = this.mViewPager;
        if (viewPager != null) {
            viewPager.setCurrentItem(selectedPos, withAnim);
        }
    }

    private final void f(final int index, final D data, final V holder, LinearLayout container) {
        boolean z16 = index == this.mSelectedPos;
        holder.getRootView().setOnClickListener(new View.OnClickListener() { // from class: vc4.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseViewPagerTitle.g(BaseViewPagerTitle.this, index, holder, data, view);
            }
        });
        D(this, holder, z16, index, data, false, 16, null);
        u(index, data, container, holder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(BaseViewPagerTitle this$0, int i3, a holder, BaseZPlanTabTitleData data, View view) {
        L l3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(holder, "$holder");
        Intrinsics.checkNotNullParameter(data, "$data");
        boolean b16 = com.tencent.sqshow.zootopia.utils.h.b(this$0.G() + "-" + i3);
        if (i3 >= this$0.mTitleData.size()) {
            QLog.e(this$0.G(), 1, "BAD index. {index=" + i3 + ", mTitleData=" + this$0.mTitleData);
            return;
        }
        if (b16 && (l3 = this$0.mTitleListener) != null) {
            l3.a(i3);
        }
        this$0.v(holder, i3, data);
        y(this$0, i3, true, false, 4, null);
    }

    private final void h(int end, int indicatorWidth) {
        HorizontalScrollView horizontalScrollView = this.mParentScrollView;
        if (horizontalScrollView == null) {
            return;
        }
        horizontalScrollView.smoothScrollTo((int) (((end + this.mSelfLeftMarin) - (u.INSTANCE.c(getContext()) * 0.5f)) + (indicatorWidth / 2)), 0);
    }

    private final Rect m(int position) {
        View childAt = this.mTitleContainer.getChildAt(position);
        if (childAt == null) {
            return null;
        }
        int width = childAt.getWidth();
        int height = childAt.getHeight();
        Rect rect = new Rect();
        rect.left = childAt.getLeft();
        int top = childAt.getTop();
        rect.top = top;
        rect.right = rect.left + width;
        rect.bottom = top + height;
        return rect;
    }

    private final void s() {
        this.mTitleContainer.removeAllViews();
        this.mTitleItemHolderPool.clear();
        Iterator<D> it = this.mTitleData.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            D next = it.next();
            V l3 = l(next);
            f(i3, next, l3, this.mTitleContainer);
            this.mTitleItemHolderPool.add(l3);
            i3++;
        }
    }

    private final void t() {
        i();
        r(this.mTitleContainer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x(int selectedPos, boolean withAnim, boolean formUserSelected) {
        ViewPager viewPager = this.mViewPager;
        Integer valueOf = viewPager != null ? Integer.valueOf(viewPager.getCurrentItem()) : null;
        if (this.mSelectedPos == selectedPos && valueOf != null && selectedPos == valueOf.intValue()) {
            QLog.d(G(), 4, "pageSelected do nothing");
            return;
        }
        QLog.i(G(), 1, "pageSelected. old: { mSelectedPos:" + this.mSelectedPos + " }, new: { selectedPos:" + selectedPos + ", currentPage:" + valueOf + " }");
        this.mSelectedPos = selectedPos;
        B(selectedPos, withAnim, formUserSelected);
        post(new Runnable() { // from class: vc4.a
            @Override // java.lang.Runnable
            public final void run() {
                BaseViewPagerTitle.z(BaseViewPagerTitle.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(BaseViewPagerTitle this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.A();
    }

    public final void A() {
        Rect m3 = m(this.mSelectedPos);
        if (m3 == null) {
            return;
        }
        h(m3.left, m3.width());
    }

    public abstract void C(V holder, boolean selected, int index, D data, boolean formUserSelected);

    /* JADX INFO: Access modifiers changed from: protected */
    public final void E(float f16) {
        this.mSelectedTxtSize = f16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void F(float f16) {
        this.mUnselectedTxtSize = f16;
    }

    protected abstract String G();

    @Override // vc4.i
    public void a(int pageIndex) {
        QLog.i(G(), 1, "pageSelected pageIndex:" + pageIndex);
        y(this, pageIndex, false, false, 4, null);
    }

    @Override // vc4.i
    public void b(ViewPager viewPager) {
        Intrinsics.checkNotNullParameter(viewPager, "viewPager");
        this.mViewPager = viewPager;
        viewPager.removeOnPageChangeListener(this.mPageChangeListener);
        viewPager.addOnPageChangeListener(this.mPageChangeListener);
        y(this, this.mSelectedPos, false, false, 4, null);
    }

    public final void j(LifecycleOwner owner) {
        this.owner = owner;
    }

    public final void k(HorizontalScrollView view, int selfLeftMarin) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.mParentScrollView = view;
        this.mSelfLeftMarin = selfLeftMarin;
    }

    protected abstract V l(D data);

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: n, reason: from getter */
    public final float getMSelectedTxtSize() {
        return this.mSelectedTxtSize;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: o, reason: from getter */
    public final LinearLayout getMTitleContainer() {
        return this.mTitleContainer;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ArrayList<D> p() {
        return this.mTitleData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: q, reason: from getter */
    public final float getMUnselectedTxtSize() {
        return this.mUnselectedTxtSize;
    }

    public void setTitleData(List<? extends D> titleList, int selectedPos) {
        Intrinsics.checkNotNullParameter(titleList, "titleList");
        QLog.i(G(), 1, "setTitleData titleList:" + titleList + ", selectedPos:" + selectedPos);
        this.mTitleData.clear();
        this.mTitleData.addAll(titleList);
        s();
        y(this, selectedPos, false, false, 4, null);
    }

    public abstract void u(int index, D data, LinearLayout container, V holder);

    public abstract void v(V holder, int index, D data);

    public void w(V holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BaseViewPagerTitle(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void r(LinearLayout titleContainer) {
        titleContainer.setOrientation(0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        addView(titleContainer, layoutParams);
    }

    public void setTitleListener(L l3) {
        Intrinsics.checkNotNullParameter(l3, "l");
        this.mTitleListener = l3;
    }

    public /* synthetic */ BaseViewPagerTitle(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseViewPagerTitle(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mTitleContainer = new LinearLayout(context);
        this.mIndicatorView = new View(context);
        this.mTitleItemHolderPool = new LinkedList<>();
        this.mTitleData = new ArrayList<>();
        this.mSelectedTxtSize = 17.0f;
        this.mUnselectedTxtSize = 15.0f;
        this.mPageChangeListener = new d(this);
        t();
    }

    static /* synthetic */ void y(BaseViewPagerTitle baseViewPagerTitle, int i3, boolean z16, boolean z17, int i16, Object obj) {
        if (obj == null) {
            if ((i16 & 4) != 0) {
                z17 = false;
            }
            baseViewPagerTitle.x(i3, z16, z17);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: pageSelected");
    }

    public static /* synthetic */ void D(BaseViewPagerTitle baseViewPagerTitle, a aVar, boolean z16, int i3, BaseZPlanTabTitleData baseZPlanTabTitleData, boolean z17, int i16, Object obj) {
        if (obj == null) {
            if ((i16 & 16) != 0) {
                z17 = false;
            }
            baseViewPagerTitle.C(aVar, z16, i3, baseZPlanTabTitleData, z17);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: refreshViewHolder");
    }

    @Override // vc4.i
    public View getView() {
        return this;
    }

    protected void i() {
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/sqshow/zootopia/widget/tab/BaseViewPagerTitle$d", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "", "position", "", "positionOffset", "positionOffsetPixels", "", WSComboHomePageChangeEvent.EVENT_ON_PAGE_SCROLLED, "onPageSelected", "state", "onPageScrollStateChanged", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class d implements ViewPager.OnPageChangeListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ BaseViewPagerTitle<V, T, D, L> f373467d;

        d(BaseViewPagerTitle<V, T, D, L> baseViewPagerTitle) {
            this.f373467d = baseViewPagerTitle;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int position) {
            QLog.i(this.f373467d.G(), 1, "onPageSelected position:" + position);
            this.f373467d.x(position, true, true);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int state) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }
    }
}
