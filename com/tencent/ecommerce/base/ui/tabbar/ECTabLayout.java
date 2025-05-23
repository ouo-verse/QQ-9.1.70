package com.tencent.ecommerce.base.ui.tabbar;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.ecommerce.base.ui.ECSkin;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 I2\u00020\u0001:\u0002JKB\u0011\b\u0016\u0012\u0006\u0010A\u001a\u00020@\u00a2\u0006\u0004\bB\u0010CB\u001b\b\u0016\u0012\u0006\u0010A\u001a\u00020@\u0012\b\u0010E\u001a\u0004\u0018\u00010D\u00a2\u0006\u0004\bB\u0010FB#\b\u0016\u0012\u0006\u0010A\u001a\u00020@\u0012\b\u0010E\u001a\u0004\u0018\u00010D\u0012\u0006\u0010G\u001a\u00020\r\u00a2\u0006\u0004\bB\u0010HJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J \u0010\u000f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J \u0010\u0011\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\rH\u0002J \u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\rH\u0002J\u0010\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0012\u001a\u00020\rH\u0002J\u0010\u0010\u001c\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\rH\u0002J\u0010\u0010\u001d\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\rH\u0002J\u0010\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\rH\u0002J\u0012\u0010!\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0014J\u0014\u0010$\u001a\u00020\u00042\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00060\"J\u000e\u0010&\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\rJ\u000e\u0010'\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\rJ\u000e\u0010)\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\rJ\u0016\u0010*\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0016J\u000e\u0010-\u001a\u00020\u00042\u0006\u0010,\u001a\u00020+J\u0010\u0010.\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0012\u001a\u00020\rJ\u0006\u0010/\u001a\u00020\rR\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00106\u001a\u00020\u000b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u00108\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u00107R\u0016\u0010:\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u00109R\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00060;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010<R\u0016\u0010%\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u00109R\u0018\u0010?\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>\u00a8\u0006L"}, d2 = {"Lcom/tencent/ecommerce/base/ui/tabbar/ECTabLayout;", "Landroid/widget/FrameLayout;", "Landroid/view/LayoutInflater;", "layoutInflater", "", "l", "Lcom/tencent/ecommerce/base/ui/tabbar/a;", "tabCoverInfo", "f", "u", "tabInfo", "Landroid/view/View;", "itemView", "", "position", "v", "tabView", "w", "index", "g", "currentIndex", "targetIndex", "", "offset", DomainData.DOMAIN_NAME, "o", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "k", "j", "r", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "", VideoTemplateParser.ITEM_LIST, HippyTKDListViewAdapter.X, "selectedIndex", "t", ReportConstant.COSTREPORT_PREFIX, "state", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/ecommerce/base/ui/tabbar/ECTabLayout$OnTabClickListener;", "listener", "setOnTabClickListener", h.F, "i", "Landroid/widget/LinearLayout;", "d", "Landroid/widget/LinearLayout;", "tabLayout", "e", "Landroid/view/View;", "indicator", UserInfo.SEX_FEMALE, "lastOffset", "I", HippyTKDListViewAdapter.SCROLL_STATE, "", "Ljava/util/List;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/ecommerce/base/ui/tabbar/ECTabLayout$OnTabClickListener;", "onTabClickListener", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "D", "a", "OnTabClickListener", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final class ECTabLayout extends FrameLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private OnTabClickListener onTabClickListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private LinearLayout tabLayout;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View indicator;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private float lastOffset;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int scrollState;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private List<ECTabCoverInfo> itemList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int selectedIndex;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/ecommerce/base/ui/tabbar/ECTabLayout$OnTabClickListener;", "", "Lcom/tencent/ecommerce/base/ui/tabbar/a;", "data", "", "position", "", "onTabClick", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes32.dex */
    public interface OnTabClickListener {
        void onTabClick(ECTabCoverInfo data, int position);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes32.dex */
    public static final class b implements View.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ECTabCoverInfo f101258e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f101259f;

        b(ECTabCoverInfo eCTabCoverInfo, int i3) {
            this.f101258e = eCTabCoverInfo;
            this.f101259f = i3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            OnTabClickListener onTabClickListener = ECTabLayout.this.onTabClickListener;
            if (onTabClickListener != null) {
                onTabClickListener.onTabClick(this.f101258e, this.f101259f);
            }
            ECTabLayout.this.o(this.f101259f);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public ECTabLayout(Context context) {
        super(context);
        this.itemList = new ArrayList();
        l(LayoutInflater.from(context));
    }

    public static final /* synthetic */ View a(ECTabLayout eCTabLayout) {
        View view = eCTabLayout.indicator;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("indicator");
        }
        return view;
    }

    private final void f(ECTabCoverInfo tabCoverInfo) {
        int i3 = tabCoverInfo.res;
        if (i3 == 0) {
            i3 = R.layout.f167353cv1;
        }
        LinearLayout linearLayout = this.tabLayout;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
        }
        LayoutInflater from = LayoutInflater.from(getContext());
        LinearLayout linearLayout2 = this.tabLayout;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
        }
        linearLayout.addView(from.inflate(i3, (ViewGroup) linearLayout2, false));
    }

    private final void g(final int index) {
        LinearLayout linearLayout = this.tabLayout;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
        }
        linearLayout.post(new Runnable() { // from class: com.tencent.ecommerce.base.ui.tabbar.ECTabLayout$doOnPageSelected$1
            @Override // java.lang.Runnable
            public final void run() {
                cg0.a.b("ECTabLayout", "onPageSelected:" + index);
                ECTabLayout.this.u();
                ECTabLayout.this.r(index);
            }
        });
    }

    private final int j(int index) {
        LinearLayout linearLayout = this.tabLayout;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
        }
        View childAt = linearLayout.getChildAt(index);
        if (childAt == null) {
            return 0;
        }
        int defaultTabWidth = this.itemList.get(index).getDefaultTabWidth();
        return childAt.getWidth() < defaultTabWidth ? defaultTabWidth : childAt.getWidth();
    }

    private final void n(int currentIndex, int targetIndex, float offset) {
        if (m(currentIndex) || m(targetIndex)) {
            return;
        }
        int k3 = k(currentIndex);
        int k16 = k(targetIndex);
        if (k3 == 0 || k16 == 0) {
            return;
        }
        View view = this.indicator;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("indicator");
        }
        if (view.getVisibility() != 0) {
            View view2 = this.indicator;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("indicator");
            }
            view2.setVisibility(0);
        }
        View view3 = this.indicator;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("indicator");
        }
        view3.setTranslationX(k3 + ((k16 - k3) * offset));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(int targetIndex) {
        if (m(targetIndex)) {
            cg0.a.b("ECTabLayout", "moveIndicatorToTargetIndex:" + targetIndex + " out of index");
            return;
        }
        int k3 = k(targetIndex);
        cg0.a.b("ECTabLayout", "moveIndicatorToTargetIndex: " + targetIndex + ", targetTranslateX: " + k3);
        if (k3 != 0) {
            View view = this.indicator;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("indicator");
            }
            view.setTranslationX(k3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r(int index) {
        if (this.scrollState == 0) {
            o(index);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u() {
        LinearLayout linearLayout = this.tabLayout;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
        }
        int childCount = linearLayout.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            LinearLayout linearLayout2 = this.tabLayout;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
            }
            View childAt = linearLayout2.getChildAt(i3);
            ECTabCoverInfo eCTabCoverInfo = this.itemList.get(i3);
            v(eCTabCoverInfo, childAt, i3);
            childAt.setOnClickListener(new b(eCTabCoverInfo, i3));
        }
    }

    private final void w(ECTabCoverInfo tabInfo, View tabView, int position) {
        if (tabView instanceof TextView) {
            TextView textView = (TextView) tabView;
            textView.setText(tabInfo.tabName);
            int color = ECSkin.INSTANCE.getColor(R.color.f156569ky);
            if (position == this.selectedIndex) {
                color = tabInfo.getTextSelectedColor();
            }
            textView.setTextColor(color);
            textView.setTextSize(2, tabInfo.textSize);
        }
    }

    public final View h(int index) {
        LinearLayout linearLayout = this.tabLayout;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
        }
        return linearLayout.getChildAt(index);
    }

    /* renamed from: i, reason: from getter */
    public final int getSelectedIndex() {
        return this.selectedIndex;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    public final void p(int state) {
        this.scrollState = state;
        r(this.selectedIndex);
    }

    public final void q(int index, float offset) {
        if (offset < this.lastOffset) {
            n(index + 1, index, 1 - offset);
        } else {
            n(index, index + 1, offset);
        }
        this.lastOffset = offset;
    }

    public final void s(int selectedIndex) {
        cg0.a.b("ECTabLayout", "switchImmersiveMode selectedIndex=" + selectedIndex);
        this.selectedIndex = selectedIndex;
        g(selectedIndex);
    }

    public final void setOnTabClickListener(OnTabClickListener listener) {
        this.onTabClickListener = listener;
    }

    public final void t(final int selectedIndex) {
        cg0.a.b("ECTabLayout", "switchImmersiveMode selectedIndex=" + selectedIndex);
        this.selectedIndex = selectedIndex;
        LinearLayout linearLayout = this.tabLayout;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
        }
        linearLayout.post(new Runnable() { // from class: com.tencent.ecommerce.base.ui.tabbar.ECTabLayout$switchUnIndicatorSelectIndex$1
            @Override // java.lang.Runnable
            public final void run() {
                ECTabLayout.this.u();
                ECTabLayout.this.o(selectedIndex);
            }
        });
    }

    public final void x(final List<ECTabCoverInfo> itemList) {
        LinearLayout linearLayout = this.tabLayout;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
        }
        linearLayout.removeAllViews();
        this.itemList.clear();
        this.itemList.addAll(itemList);
        View view = this.indicator;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("indicator");
        }
        view.setVisibility(4);
        int size = this.itemList.size();
        for (int i3 = 0; i3 < size; i3++) {
            f(itemList.get(i3));
            if (itemList.get(i3).showIdentifier) {
                post(new Runnable() { // from class: com.tencent.ecommerce.base.ui.tabbar.ECTabLayout$updateUI$$inlined$repeat$lambda$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        ECTabLayout.a(ECTabLayout.this).setVisibility(0);
                        ECTabLayout.this.o(0);
                    }
                });
            }
        }
    }

    public ECTabLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.itemList = new ArrayList();
        l(LayoutInflater.from(context));
    }

    private final boolean m(int index) {
        if (index < 0) {
            return true;
        }
        LinearLayout linearLayout = this.tabLayout;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
        }
        return index > linearLayout.getChildCount() - 1;
    }

    private final void v(ECTabCoverInfo tabInfo, View itemView, int position) {
        View findViewById = itemView.findViewById(R.id.oer);
        if (findViewById != null) {
            w(tabInfo, findViewById, position);
        }
    }

    private final int k(int index) {
        int i3 = 0;
        for (int i16 = 0; i16 < index; i16++) {
            i3 += j(i16);
        }
        int j3 = j(index) / 2;
        View view = this.indicator;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("indicator");
        }
        return i3 + (j3 - (view.getMeasuredWidth() / 2));
    }

    private final void l(LayoutInflater layoutInflater) {
        layoutInflater.inflate(R.layout.f167354cv2, (ViewGroup) this, true);
        this.tabLayout = (LinearLayout) findViewById(R.id.obw);
        this.indicator = findViewById(R.id.obv);
        LinearLayout linearLayout = this.tabLayout;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
        }
        linearLayout.setHorizontalFadingEdgeEnabled(false);
        LinearLayout linearLayout2 = this.tabLayout;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
        }
        linearLayout2.setOverScrollMode(2);
    }

    public ECTabLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.itemList = new ArrayList();
        l(LayoutInflater.from(context));
    }
}
