package com.tencent.sqshow.zootopia.widget.tab;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.pubaccount.weishi.event.WSComboHomePageChangeEvent;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.view.ZplanExcludeFontPaddingTextView;
import com.tencent.sqshow.zootopia.widget.tab.BaseZPlanTabTitleData;
import com.tencent.sqshow.zootopia.widget.tab.BaseZPlanTextViewPagerTitle;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;
import vc4.i;
import vc4.l;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u0002*\b\b\u0002\u0010\u0005*\u00020\u00042\u00020\u00062\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0007:\u0001\u001bB'\b\u0007\u0012\u0006\u0010H\u001a\u00020G\u0012\n\b\u0002\u0010J\u001a\u0004\u0018\u00010I\u0012\b\b\u0002\u0010K\u001a\u00020\u000e\u00a2\u0006\u0004\bL\u0010MJ\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\bH\u0002J'\u0010\u0011\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00028\u0001H\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0014\u001a\u00020\u0013H&J\b\u0010\u0015\u001a\u00020\bH\u0014J\u001e\u0010\u0019\u001a\u00020\b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00010\u00162\u0006\u0010\u0018\u001a\u00020\u000eH\u0016J\u0010\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u000eH\u0016J\u0010\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\u0017\u0010 \u001a\u00020\b2\u0006\u0010\u001f\u001a\u00028\u0002H\u0016\u00a2\u0006\u0004\b \u0010!J\b\u0010#\u001a\u00020\"H\u0016R\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010%R\u0018\u0010(\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010'R\u0016\u0010+\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\"\u00102\u001a\u00020,8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u00105\u001a\u00020,8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010-\u001a\u0004\b3\u0010/\"\u0004\b4\u00101R\"\u0010;\u001a\u00020\u000e8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b6\u0010*\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u0016\u0010=\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010*R\u001c\u0010@\u001a\b\u0012\u0004\u0012\u00020\f0>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010?R\"\u0010D\u001a\u00020\u000e8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bA\u0010*\u001a\u0004\bB\u00108\"\u0004\bC\u0010:R\u0018\u0010F\u001a\u0004\u0018\u00018\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010E\u00a8\u0006N"}, d2 = {"Lcom/tencent/sqshow/zootopia/widget/tab/BaseZPlanTextViewPagerTitle;", "T", "Lcom/tencent/sqshow/zootopia/widget/tab/BaseZPlanTabTitleData;", "D", "Lvc4/l;", "L", "Landroid/widget/LinearLayout;", "Lvc4/i;", "", "g", "e", "i", "Lcom/tencent/sqshow/zootopia/widget/tab/BaseZPlanTextViewPagerTitle$a;", "itemView", "", "index", "data", h.F, "(Lcom/tencent/sqshow/zootopia/widget/tab/BaseZPlanTextViewPagerTitle$a;ILcom/tencent/sqshow/zootopia/widget/tab/BaseZPlanTabTitleData;)V", "", "j", "d", "", "titleList", "selectedPos", "setTitleData", "pageIndex", "a", "Landroidx/viewpager/widget/ViewPager;", "viewPager", "b", "l", "setTitleListener", "(Lvc4/l;)V", "Landroid/view/View;", "getView", "Ljava/util/ArrayList;", "Ljava/util/ArrayList;", "mData", "Landroidx/viewpager/widget/ViewPager;", "mViewPager", "f", "I", "mSelectedPos", "", UserInfo.SEX_FEMALE, "getMSelectedTxtSize", "()F", "setMSelectedTxtSize", "(F)V", "mSelectedTxtSize", "getMUnselectedTxtSize", "setMUnselectedTxtSize", "mUnselectedTxtSize", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "getMSelectedTxtColor", "()I", "setMSelectedTxtColor", "(I)V", "mSelectedTxtColor", BdhLogUtil.LogTag.Tag_Conn, "mUnselectedTxtColor", "Ljava/util/LinkedList;", "Ljava/util/LinkedList;", "mItemViewPool", "E", "getMTitleBgColor", "setMTitleBgColor", "mTitleBgColor", "Lvc4/l;", "mListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public abstract class BaseZPlanTextViewPagerTitle<T, D extends BaseZPlanTabTitleData<T>, L extends l> extends LinearLayout implements i<T, D, L> {

    /* renamed from: C, reason: from kotlin metadata */
    private int mUnselectedTxtColor;

    /* renamed from: D, reason: from kotlin metadata */
    private LinkedList<ItemView> mItemViewPool;

    /* renamed from: E, reason: from kotlin metadata */
    private int mTitleBgColor;

    /* renamed from: F, reason: from kotlin metadata */
    private L mListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ArrayList<D> mData;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ViewPager mViewPager;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int mSelectedPos;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private float mSelectedTxtSize;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private float mUnselectedTxtSize;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int mSelectedTxtColor;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BaseZPlanTextViewPagerTitle(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void e() {
        this.mItemViewPool.clear();
        final int i3 = 0;
        for (T t16 : this.mData) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView = new ZplanExcludeFontPaddingTextView(context);
            ItemView itemView = new ItemView(zplanExcludeFontPaddingTextView);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            layoutParams.weight = 1.0f;
            zplanExcludeFontPaddingTextView.setGravity(17);
            addView(itemView.getTxv(), layoutParams);
            h(itemView, i3, (BaseZPlanTabTitleData) t16);
            itemView.getTxv().setOnClickListener(new View.OnClickListener() { // from class: vc4.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BaseZPlanTextViewPagerTitle.f(BaseZPlanTextViewPagerTitle.this, i3, view);
                }
            });
            this.mItemViewPool.add(itemView);
            i3 = i16;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(BaseZPlanTextViewPagerTitle this$0, int i3, View view) {
        L l3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (com.tencent.sqshow.zootopia.utils.h.b(this$0.j() + "-" + i3) && (l3 = this$0.mListener) != null) {
            l3.a(i3);
        }
        ViewPager viewPager = this$0.mViewPager;
        if (viewPager != null) {
            viewPager.setCurrentItem(i3, false);
        }
    }

    private final void g() {
        d();
        setOrientation(0);
        setBackgroundColor(this.mTitleBgColor);
    }

    private final void h(ItemView itemView, int index, D data) {
        boolean z16 = index == this.mSelectedPos;
        itemView.getTxv().setText(data.getTitle());
        if (z16) {
            itemView.getTxv().setTextColor(this.mSelectedTxtColor);
            itemView.getTxv().setTextSize(1, this.mSelectedTxtSize);
        } else {
            itemView.getTxv().setTextColor(this.mUnselectedTxtColor);
            itemView.getTxv().setTextSize(1, this.mUnselectedTxtSize);
        }
    }

    private final void i() {
        int i3 = 0;
        for (T t16 : this.mItemViewPool) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            D d16 = this.mData.get(i3);
            Intrinsics.checkNotNullExpressionValue(d16, "mData[index]");
            h((ItemView) t16, i3, d16);
            i3 = i16;
        }
    }

    @Override // vc4.i
    public void a(int pageIndex) {
        this.mSelectedPos = pageIndex;
        i();
    }

    @Override // vc4.i
    public void b(ViewPager viewPager) {
        Intrinsics.checkNotNullParameter(viewPager, "viewPager");
        this.mViewPager = viewPager;
        viewPager.addOnPageChangeListener(new b(this));
    }

    public abstract String j();

    @Override // vc4.i
    public void setTitleData(List<? extends D> titleList, int selectedPos) {
        Intrinsics.checkNotNullParameter(titleList, "titleList");
        this.mData.clear();
        this.mData.addAll(titleList);
        e();
    }

    public void setTitleListener(L l3) {
        Intrinsics.checkNotNullParameter(l3, "l");
        this.mListener = l3;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BaseZPlanTextViewPagerTitle(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ BaseZPlanTextViewPagerTitle(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\t\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/sqshow/zootopia/widget/tab/BaseZPlanTextViewPagerTitle$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Landroid/widget/TextView;", "a", "Landroid/widget/TextView;", "()Landroid/widget/TextView;", "txv", "<init>", "(Landroid/widget/TextView;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.sqshow.zootopia.widget.tab.BaseZPlanTextViewPagerTitle$a, reason: from toString */
    /* loaded from: classes34.dex */
    public static final /* data */ class ItemView {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final TextView txv;

        public ItemView(TextView txv) {
            Intrinsics.checkNotNullParameter(txv, "txv");
            this.txv = txv;
        }

        /* renamed from: a, reason: from getter */
        public final TextView getTxv() {
            return this.txv;
        }

        public int hashCode() {
            return this.txv.hashCode();
        }

        public String toString() {
            return "ItemView(txv=" + this.txv + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ItemView) && Intrinsics.areEqual(this.txv, ((ItemView) other).txv);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseZPlanTextViewPagerTitle(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mData = new ArrayList<>();
        this.mSelectedTxtSize = 18.0f;
        this.mUnselectedTxtSize = 18.0f;
        this.mSelectedTxtColor = -1;
        this.mUnselectedTxtColor = Color.parseColor("#555555");
        this.mItemViewPool = new LinkedList<>();
        this.mTitleBgColor = -16777216;
        g();
    }

    protected void d() {
    }

    @Override // vc4.i
    public View getView() {
        return this;
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/sqshow/zootopia/widget/tab/BaseZPlanTextViewPagerTitle$b", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "", "position", "", "positionOffset", "positionOffsetPixels", "", WSComboHomePageChangeEvent.EVENT_ON_PAGE_SCROLLED, "onPageSelected", "state", "onPageScrollStateChanged", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements ViewPager.OnPageChangeListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ BaseZPlanTextViewPagerTitle<T, D, L> f373485d;

        b(BaseZPlanTextViewPagerTitle<T, D, L> baseZPlanTextViewPagerTitle) {
            this.f373485d = baseZPlanTextViewPagerTitle;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int position) {
            QLog.i(this.f373485d.j(), 1, "onPageSelected position:" + position);
            this.f373485d.a(position);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int state) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }
    }
}
