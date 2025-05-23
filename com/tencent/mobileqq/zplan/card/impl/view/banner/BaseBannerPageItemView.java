package com.tencent.mobileqq.zplan.card.impl.view.banner;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.pubaccount.weishi.event.WSComboHomePageChangeEvent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.card.report.a;
import com.tencent.sqshow.zootopia.data.ZootopiaCardData;
import com.tencent.sqshow.zootopia.utils.aa;
import com.tencent.sqshow.zootopia.widget.media.ZPlanMediaView;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import pv4.s;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\b\u0007\u0012\u0006\u0010J\u001a\u00020I\u0012\n\b\u0002\u0010L\u001a\u0004\u0018\u00010K\u00a2\u0006\u0004\bM\u0010NJ\b\u0010\u0004\u001a\u00020\u0003H\u0016J#\u0010\n\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a2\u0006\u0004\b\n\u0010\u000bJ:\u0010\u0016\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0007H\u0016J \u0010\u001b\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0007H\u0016J\u0010\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0007H\u0016R\"\u0010$\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010+\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u00100\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010,\u001a\u0004\b%\u0010-\"\u0004\b.\u0010/R\"\u0010\u0015\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u0010,\u001a\u0004\b2\u0010-\"\u0004\b3\u0010/R$\u0010:\u001a\u0004\u0018\u0001048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b\u001e\u00107\"\u0004\b8\u00109R$\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\"\u0010H\u001a\u00020A8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010G\u00a8\u0006O"}, d2 = {"Lcom/tencent/mobileqq/zplan/card/impl/view/banner/BaseBannerPageItemView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mobileqq/zplan/card/impl/view/banner/b;", "Landroid/view/View;", "getView", "Landroidx/viewpager2/widget/ViewPager2;", "viewpager", "", "viewBgColor", "", "b", "(Landroidx/viewpager2/widget/ViewPager2;Ljava/lang/Integer;)V", "Landroidx/lifecycle/LifecycleOwner;", "owner", "Loa4/a;", "mapResViewModel", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "sourceCurrent", "Lcom/tencent/sqshow/zootopia/data/c;", "dataInfo", com.tencent.luggage.wxa.c8.c.G, "cardPos", "a", "position", "", "positionOffset", "positionOffsetPixels", "f", "g", "Lcom/tencent/sqshow/zootopia/card/report/a;", "d", "Lcom/tencent/sqshow/zootopia/card/report/a;", "getReportHelper", "()Lcom/tencent/sqshow/zootopia/card/report/a;", "setReportHelper", "(Lcom/tencent/sqshow/zootopia/card/report/a;)V", "reportHelper", "e", "Lcom/tencent/sqshow/zootopia/data/c;", "getData", "()Lcom/tencent/sqshow/zootopia/data/c;", "setData", "(Lcom/tencent/sqshow/zootopia/data/c;)V", "data", "I", "()I", "setCurPos", "(I)V", "curPos", tl.h.F, "getCardPos", "setCardPos", "Lcom/tencent/sqshow/zootopia/widget/media/ZPlanMediaView;", "i", "Lcom/tencent/sqshow/zootopia/widget/media/ZPlanMediaView;", "()Lcom/tencent/sqshow/zootopia/widget/media/ZPlanMediaView;", "setBannerBg", "(Lcom/tencent/sqshow/zootopia/widget/media/ZPlanMediaView;)V", "bannerBg", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/viewpager2/widget/ViewPager2;", "getViewpager", "()Landroidx/viewpager2/widget/ViewPager2;", "setViewpager", "(Landroidx/viewpager2/widget/ViewPager2;)V", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "getPageChangeCallBack", "()Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "setPageChangeCallBack", "(Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;)V", "pageChangeCallBack", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public class BaseBannerPageItemView extends FrameLayout implements b {

    /* renamed from: C, reason: from kotlin metadata */
    private ViewPager2.OnPageChangeCallback pageChangeCallBack;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.sqshow.zootopia.card.report.a reportHelper;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ZootopiaCardData data;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int curPos;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int cardPos;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ZPlanMediaView bannerBg;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ViewPager2 viewpager;

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/zplan/card/impl/view/banner/BaseBannerPageItemView$a", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "", "position", "", "positionOffset", "positionOffsetPixels", "", WSComboHomePageChangeEvent.EVENT_ON_PAGE_SCROLLED, "onPageSelected", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a extends ViewPager2.OnPageChangeCallback {
        a() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            BaseBannerPageItemView.this.f(position, positionOffset, positionOffsetPixels);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int position) {
            BaseBannerPageItemView.this.g(position);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BaseBannerPageItemView(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(s detail, BaseBannerPageItemView this$0, int i3, View view) {
        List<s> c16;
        s sVar;
        Intrinsics.checkNotNullParameter(detail, "$detail");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!TextUtils.isEmpty(detail.f427682c)) {
            QLog.i("BannerPageItemView", 1, "click - " + detail.f427683d + " - " + detail.f427682c);
            ISchemeApi iSchemeApi = (ISchemeApi) QRoute.api(ISchemeApi.class);
            Context context = this$0.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            String str = detail.f427682c;
            Intrinsics.checkNotNullExpressionValue(str, "detail.jumpUrl");
            iSchemeApi.launchScheme(context, str);
        } else {
            QQToast.makeText(this$0.getContext(), R.string.xm9, 0).show();
            QLog.e("BannerPageItemView", 1, "click launchScheme but url is empty");
        }
        ZootopiaCardData zootopiaCardData = this$0.data;
        if (zootopiaCardData == null || (c16 = zootopiaCardData.c()) == null || (sVar = c16.get(this$0.curPos)) == null) {
            return;
        }
        this$0.reportHelper.a(this$0, i3, this$0.curPos, a.Companion.g(com.tencent.sqshow.zootopia.card.report.a.INSTANCE, sVar.f427681b, null, 2, null), zootopiaCardData, sVar, (r20 & 64) != 0 ? new HashMap() : null, (r20 & 128) != 0 ? "em_zplan_element" : null);
    }

    @Override // com.tencent.mobileqq.zplan.card.impl.view.banner.b
    public void a(LifecycleOwner owner, oa4.a mapResViewModel, ZootopiaSource sourceCurrent, ZootopiaCardData dataInfo, int pos, final int cardPos) {
        List<s> c16;
        final s sVar;
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(mapResViewModel, "mapResViewModel");
        Intrinsics.checkNotNullParameter(sourceCurrent, "sourceCurrent");
        this.cardPos = cardPos;
        this.curPos = pos;
        this.data = dataInfo;
        if (dataInfo == null || (c16 = dataInfo.c()) == null || (sVar = c16.get(pos)) == null) {
            return;
        }
        ZPlanMediaView zPlanMediaView = this.bannerBg;
        if (zPlanMediaView != null) {
            pu4.g gVar = sVar.f427681b;
            Intrinsics.checkNotNullExpressionValue(gVar, "detail.material");
            zPlanMediaView.e(gVar);
        }
        aa.e(this, new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.card.impl.view.banner.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseBannerPageItemView.h(s.this, this, cardPos, view);
            }
        }, 1000L);
    }

    @Override // com.tencent.mobileqq.zplan.card.impl.view.banner.b
    public void b(ViewPager2 viewpager, Integer viewBgColor) {
        this.viewpager = viewpager;
        if (viewpager != null) {
            viewpager.unregisterOnPageChangeCallback(this.pageChangeCallBack);
        }
        if (viewpager != null) {
            viewpager.registerOnPageChangeCallback(this.pageChangeCallBack);
        }
    }

    /* renamed from: d, reason: from getter */
    public final ZPlanMediaView getBannerBg() {
        return this.bannerBg;
    }

    /* renamed from: e, reason: from getter */
    public final int getCurPos() {
        return this.curPos;
    }

    public void g(int position) {
        ZootopiaCardData zootopiaCardData;
        List<s> c16;
        s sVar;
        if (position != this.curPos || (zootopiaCardData = this.data) == null || (c16 = zootopiaCardData.c()) == null || (sVar = c16.get(this.curPos)) == null) {
            return;
        }
        this.reportHelper.c(this, this.cardPos, position, a.Companion.g(com.tencent.sqshow.zootopia.card.report.a.INSTANCE, sVar.f427681b, null, 2, null), zootopiaCardData, sVar, (r24 & 64) != 0 ? new HashMap() : null, (r24 & 128) != 0 ? "em_zplan_element" : null, (r24 & 256) != 0 ? null : null, (r24 & 512) != 0);
    }

    public final void setBannerBg(ZPlanMediaView zPlanMediaView) {
        this.bannerBg = zPlanMediaView;
    }

    public final void setCardPos(int i3) {
        this.cardPos = i3;
    }

    public final void setCurPos(int i3) {
        this.curPos = i3;
    }

    public final void setData(ZootopiaCardData zootopiaCardData) {
        this.data = zootopiaCardData;
    }

    public final void setPageChangeCallBack(ViewPager2.OnPageChangeCallback onPageChangeCallback) {
        Intrinsics.checkNotNullParameter(onPageChangeCallback, "<set-?>");
        this.pageChangeCallBack = onPageChangeCallback;
    }

    public final void setReportHelper(com.tencent.sqshow.zootopia.card.report.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.reportHelper = aVar;
    }

    public final void setViewpager(ViewPager2 viewPager2) {
        this.viewpager = viewPager2;
    }

    public /* synthetic */ BaseBannerPageItemView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseBannerPageItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.reportHelper = new com.tencent.sqshow.zootopia.card.report.a();
        this.pageChangeCallBack = new a();
    }

    @Override // com.tencent.mobileqq.zplan.card.impl.view.banner.b
    public View getView() {
        return this;
    }

    public void f(int position, float positionOffset, int positionOffsetPixels) {
    }
}
