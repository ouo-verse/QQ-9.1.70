package com.tencent.ecommerce.biz.transactiondata.trendchart;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.ecommerce.biz.util.e;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.ArrayList;
import java.util.List;
import kj0.ECChartViewExtData;
import kj0.ECChartViewPointAttr;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 92\u00020\u0001:\u0001:B/\u0012\u0006\u00103\u001a\u000202\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u000104\u0012\b\b\u0002\u00106\u001a\u00020\u0005\u0012\b\b\u0002\u00101\u001a\u00020\r\u00a2\u0006\u0004\b7\u00108J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0003JH\u0010\u0013\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\b2\u0006\u0010\u000e\u001a\u00020\r2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u001dR\u0018\u0010 \u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001aR\u0018\u0010#\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\"R\u0018\u0010%\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010\"R\u0014\u0010(\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010*R\u001e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010*R\u0017\u00101\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\u00a8\u0006;"}, d2 = {"Lcom/tencent/ecommerce/biz/transactiondata/trendchart/ECNewChartView;", "Landroid/widget/RelativeLayout;", "", "f", "j", "", "index", "i", "", "", "label", "", "data", "", "isMoneyTab", "Lkj0/b;", "extDataList", "Lkj0/c;", "chartPointAttr", "g", "Lcom/tencent/ecommerce/biz/transactiondata/trendchart/ECChartView;", "d", "Lcom/tencent/ecommerce/biz/transactiondata/trendchart/ECChartView;", "chartView", "Landroid/widget/FrameLayout;", "e", "Landroid/widget/FrameLayout;", "chartViewContainer", "Landroid/view/View;", "Landroid/view/View;", "indicatorLine", h.F, "indicatorPoint", "Landroid/widget/LinearLayout;", "Landroid/widget/LinearLayout;", "indicatorInfoView", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "indicatorInfoContainer", BdhLogUtil.LogTag.Tag_Conn, "I", "indicatorInfoViewWidth", "D", "Ljava/util/List;", "E", UserInfo.SEX_FEMALE, "G", "Z", "getNeedIndicator", "()Z", "needIndicator", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;IZ)V", "H", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECNewChartView extends RelativeLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private final int indicatorInfoViewWidth;

    /* renamed from: D, reason: from kotlin metadata */
    private List<String> label;

    /* renamed from: E, reason: from kotlin metadata */
    private List<Long> data;

    /* renamed from: F, reason: from kotlin metadata */
    private List<ECChartViewExtData> extDataList;

    /* renamed from: G, reason: from kotlin metadata */
    private final boolean needIndicator;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ECChartView chartView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private FrameLayout chartViewContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private View indicatorLine;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private FrameLayout indicatorPoint;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private LinearLayout indicatorInfoView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private LinearLayout indicatorInfoContainer;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/ecommerce/biz/transactiondata/trendchart/ECNewChartView$b", "Lcom/tencent/ecommerce/biz/transactiondata/trendchart/IChartViewActionCallback;", "", "xPosition", "yPosition", "", "focusIndex", "", "refreshIndicatorView", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b implements IChartViewActionCallback {
        b() {
        }

        @Override // com.tencent.ecommerce.biz.transactiondata.trendchart.IChartViewActionCallback
        public void refreshIndicatorView(float xPosition, float yPosition, int focusIndex) {
            View view = ECNewChartView.this.indicatorLine;
            if (view != null) {
                view.setVisibility(0);
            }
            FrameLayout frameLayout = ECNewChartView.this.indicatorPoint;
            if (frameLayout != null) {
                frameLayout.setVisibility(0);
            }
            LinearLayout linearLayout = ECNewChartView.this.indicatorInfoView;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
            int measuredWidth = (ECNewChartView.this.getMeasuredWidth() - ECNewChartView.this.getPaddingLeft()) - ECNewChartView.this.getPaddingRight();
            int i3 = (int) xPosition;
            int c16 = e.c(16.0f) + i3;
            if (ECNewChartView.this.indicatorInfoViewWidth + c16 > measuredWidth) {
                c16 = (i3 - e.c(16.0f)) - ECNewChartView.this.indicatorInfoViewWidth;
            }
            ECNewChartView.this.i(focusIndex);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ECNewChartView.this.indicatorInfoViewWidth, -2);
            layoutParams.setMarginStart(c16);
            layoutParams.topMargin = e.c(40.0f);
            LinearLayout linearLayout2 = ECNewChartView.this.indicatorInfoView;
            if (linearLayout2 != null) {
                linearLayout2.setLayoutParams(layoutParams);
            }
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(e.c(1.0f), e.c(219.0f));
            layoutParams2.bottomMargin = e.c(32.0f);
            layoutParams2.topMargin = e.c(10.0f);
            layoutParams2.setMarginStart(i3 - e.c(0.5f));
            View view2 = ECNewChartView.this.indicatorLine;
            if (view2 != null) {
                view2.setLayoutParams(layoutParams2);
            }
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(e.c(6.0f), e.c(6.0f));
            layoutParams3.topMargin = ((int) yPosition) - e.c(3.0f);
            layoutParams3.setMarginStart(i3 - e.c(3.0f));
            FrameLayout frameLayout2 = ECNewChartView.this.indicatorPoint;
            if (frameLayout2 != null) {
                frameLayout2.setLayoutParams(layoutParams3);
            }
        }
    }

    public /* synthetic */ ECNewChartView(Context context, AttributeSet attributeSet, int i3, boolean z16, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3, (i16 & 8) != 0 ? false : z16);
    }

    private final void f() {
        LayoutInflater.from(getContext()).inflate(R.layout.cpj, this);
        this.chartViewContainer = (FrameLayout) getRootView().findViewById(R.id.f163007nt2);
        this.indicatorLine = getRootView().findViewById(R.id.f163009nt4);
        this.indicatorPoint = (FrameLayout) getRootView().findViewById(R.id.nt5);
        LinearLayout linearLayout = (LinearLayout) getRootView().findViewById(R.id.f163008nt3);
        this.indicatorInfoView = linearLayout;
        this.indicatorInfoContainer = linearLayout != null ? (LinearLayout) linearLayout.findViewById(R.id.f163046o10) : null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(int index) {
        LinearLayout linearLayout = this.indicatorInfoContainer;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
        }
        List<ECChartViewExtData> list = this.extDataList;
        if (list != null) {
            for (ECChartViewExtData eCChartViewExtData : list) {
                Object systemService = getContext().getSystemService("layout_inflater");
                if (systemService != null) {
                    View inflate = ((LayoutInflater) systemService).inflate(R.layout.cpm, (ViewGroup) null);
                    TextView textView = (TextView) inflate.findViewById(R.id.ocm);
                    TextView textView2 = (TextView) inflate.findViewById(R.id.f163125of4);
                    if (eCChartViewExtData.getTitle() == null) {
                        textView.setVisibility(8);
                    } else {
                        textView.setText(eCChartViewExtData.getTitle());
                    }
                    textView2.setText(eCChartViewExtData.getDataArr().optString(index));
                    LinearLayout linearLayout2 = this.indicatorInfoContainer;
                    if (linearLayout2 != null) {
                        linearLayout2.addView(inflate);
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.view.LayoutInflater");
                }
            }
        }
    }

    private final void j() {
        ECChartView eCChartView = this.chartView;
        if (eCChartView != null) {
            eCChartView.setActionCallback(new b());
        }
    }

    public final void g(List<String> label, List<Long> data, boolean isMoneyTab, List<ECChartViewExtData> extDataList, ECChartViewPointAttr chartPointAttr) {
        if (label.isEmpty() || data.isEmpty()) {
            return;
        }
        removeAllViews();
        f();
        ECChartView eCChartView = new ECChartView(getContext(), label, data, isMoneyTab);
        eCChartView.setYLabelCount(5);
        eCChartView.setXLabelCount(4);
        eCChartView.setPointAttr(chartPointAttr);
        eCChartView.setShouldDrawIndicatorView(this.needIndicator);
        Unit unit = Unit.INSTANCE;
        this.chartView = eCChartView;
        if (this.needIndicator) {
            j();
        }
        ECChartView eCChartView2 = this.chartView;
        if (eCChartView2 != null) {
            eCChartView2.h();
        }
        FrameLayout frameLayout = this.chartViewContainer;
        if (frameLayout != null) {
            frameLayout.addView(this.chartView);
        }
        this.label = label;
        this.data = data;
        this.extDataList = extDataList;
    }

    public ECNewChartView(Context context, AttributeSet attributeSet, int i3, boolean z16) {
        super(context, attributeSet, i3);
        this.needIndicator = z16;
        this.indicatorInfoViewWidth = e.c(144.0f);
        this.label = new ArrayList();
        this.data = new ArrayList();
        f();
    }
}
