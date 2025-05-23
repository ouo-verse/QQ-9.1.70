package com.tencent.sqshow.zootopia.recommend.characterV2.view.smallhome;

import android.content.Context;
import android.text.Html;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import cb4.g;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.zplan.ipc.api.IZPlanIPCHelper;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import com.tencent.sqshow.zootopia.recommend.characterV2.view.smallhome.ZPlanSmallHomeBubbleView;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import com.tencent.sqshow.zootopia.utils.i;
import com.tencent.sqshow.zootopia.utils.q;
import com.tencent.sqshow.zootopia.utils.ui.RoundCornerImageView;
import com.tencent.sqshow.zootopia.utils.ui.ZPlanViewState;
import com.tencent.state.report.SquareReportConst;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import n74.cn;
import tl.h;
import zu4.t;
import zu4.u;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 62\u00020\u0001:\u000278B'\b\u0007\u0012\u0006\u00100\u001a\u00020/\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u000101\u0012\b\b\u0002\u00103\u001a\u00020\u0012\u00a2\u0006\u0004\b4\u00105J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J$\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007`\bH\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0016\u0010\u000f\u001a\u00020\u00022\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\rH\u0002J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0016\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0012J\u0006\u0010\u0016\u001a\u00020\u0015J\u0006\u0010\u0017\u001a\u00020\u0002J\u0006\u0010\u0018\u001a\u00020\u0002J\u0006\u0010\u0019\u001a\u00020\u0002R\u0014\u0010\u001c\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u001eR\u0016\u0010!\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010 R\u0016\u0010#\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\"R\u0014\u0010&\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010.\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-\u00a8\u00069"}, d2 = {"Lcom/tencent/sqshow/zootopia/recommend/characterV2/view/smallhome/ZPlanSmallHomeBubbleView;", "Landroid/widget/FrameLayout;", "", "b", "", "f", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "g", "Lzu4/t;", "data", "l", "", "iconUrlList", "k", h.F, "d", "", "bubbleIndex", "j", "Lcom/tencent/sqshow/zootopia/utils/ui/ZPlanViewState;", "e", DomainData.DOMAIN_NAME, "i", "c", "Ln74/cn;", "Ln74/cn;", "mBinding", "Lcb4/g;", "Lcb4/g;", "mAnimHelper", "Lzu4/t;", "mData", "I", "mBubbleIndex", "Lcom/tencent/sqshow/zootopia/recommend/characterV2/view/smallhome/ZPlanSmallHomeBubbleView$DelayHideTask;", "Lcom/tencent/sqshow/zootopia/recommend/characterV2/view/smallhome/ZPlanSmallHomeBubbleView$DelayHideTask;", "mDelayHideTask", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "mDestroyed", "Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "mReporter", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "D", "a", "DelayHideTask", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanSmallHomeBubbleView extends FrameLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private final ZplanViewReportHelper mReporter;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final cn mBinding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final g mAnimHelper;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private t mData;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int mBubbleIndex;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final DelayHideTask mDelayHideTask;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean mDestroyed;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/sqshow/zootopia/recommend/characterV2/view/smallhome/ZPlanSmallHomeBubbleView$DelayHideTask;", "Ljava/lang/Runnable;", "", TencentLocation.RUN_MODE, "Ljava/lang/ref/WeakReference;", "Lcom/tencent/sqshow/zootopia/recommend/characterV2/view/smallhome/ZPlanSmallHomeBubbleView;", "d", "Ljava/lang/ref/WeakReference;", "getRef", "()Ljava/lang/ref/WeakReference;", "ref", "<init>", "(Ljava/lang/ref/WeakReference;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class DelayHideTask implements Runnable {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final WeakReference<ZPlanSmallHomeBubbleView> ref;

        public DelayHideTask(WeakReference<ZPlanSmallHomeBubbleView> ref) {
            Intrinsics.checkNotNullParameter(ref, "ref");
            this.ref = ref;
        }

        @Override // java.lang.Runnable
        public void run() {
            ZPlanSmallHomeBubbleView zPlanSmallHomeBubbleView = this.ref.get();
            if (zPlanSmallHomeBubbleView != null) {
                zPlanSmallHomeBubbleView.i();
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZPlanSmallHomeBubbleView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void b() {
        ZplanViewReportHelper zplanViewReportHelper = this.mReporter;
        View mRv = this.mBinding.getMRv();
        Intrinsics.checkNotNullExpressionValue(mRv, "mBinding.root");
        zplanViewReportHelper.g(mRv, f(), (r16 & 4) != 0 ? null : g(), (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
    }

    private final void d(t data) {
        ((IZPlanIPCHelper) QRoute.api(IZPlanIPCHelper.class)).reportSmallHomeBubbleExpose(data, this.mBubbleIndex);
    }

    private final String f() {
        if (this.mBubbleIndex == 2) {
            return "em_zplan_avatar_qqpet_bubble";
        }
        return "em_zplan_avatar_xiaowo_bubble";
    }

    private final HashMap<String, Object> g() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(SquareReportConst.Key.KEY_ZPLAN_BUBBLE_TYPE, String.valueOf(this.mData.f453480a));
        u uVar = this.mData.f453482c;
        String str = uVar != null ? uVar.f453486b : null;
        if (str == null) {
            str = "";
        }
        hashMap.put("zplan_bubble_content", str);
        return hashMap;
    }

    private final void h(t data) {
        long coerceAtLeast;
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(data.f453484e * 1000, 2000L);
        QLog.i("ZPlanSmallHomeBubbleView_", 1, "handleDelayHideTask delayTime=" + coerceAtLeast + ", mDestroyed:" + this.mDestroyed);
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.mDelayHideTask);
        if (this.mDestroyed) {
            return;
        }
        ThreadManagerV2.getUIHandlerV2().postDelayed(this.mDelayHideTask, coerceAtLeast);
    }

    private final void k(List<String> iconUrlList) {
        Iterable<IndexedValue> withIndex;
        this.mBinding.f419044e.removeAllViews();
        ViewGroup.LayoutParams layoutParams = this.mBinding.f419041b.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        if (iconUrlList.isEmpty()) {
            this.mBinding.f419044e.setVisibility(8);
            layoutParams2.leftMargin = i.b(12);
            layoutParams2.rightMargin = i.b(12);
        } else {
            this.mBinding.f419044e.setVisibility(0);
            layoutParams2.leftMargin = i.b(4);
            layoutParams2.rightMargin = i.b(5);
        }
        this.mBinding.f419041b.setLayoutParams(layoutParams2);
        withIndex = CollectionsKt___CollectionsKt.withIndex(iconUrlList);
        for (IndexedValue indexedValue : withIndex) {
            int index = indexedValue.getIndex();
            String str = (String) indexedValue.component2();
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(i.b(21), i.b(21));
            if (index != 0) {
                layoutParams3.leftMargin = i.b(-10);
            }
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            RoundCornerImageView roundCornerImageView = new RoundCornerImageView(context, null, 0, 6, null);
            roundCornerImageView.setRadius(i.d(10.5f));
            CommonExKt.w(roundCornerImageView, str, q.b(R.drawable.i5g), null, 4, null);
            this.mBinding.f419044e.addView(roundCornerImageView, layoutParams3);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x000a, code lost:
    
        r0 = kotlin.collections.ArraysKt___ArraysKt.toList(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void l(t data) {
        List<String> emptyList;
        u uVar = this.mData.f453482c;
        if (uVar == null || (r0 = uVar.f453485a) == null || emptyList == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        }
        u uVar2 = this.mData.f453482c;
        String str = uVar2 != null ? uVar2.f453486b : null;
        if (str == null) {
            str = "";
        }
        if (str.length() == 0) {
            setVisibility(8);
            return;
        }
        h(data);
        d(data);
        u uVar3 = this.mData.f453482c;
        QLog.i("ZPlanSmallHomeBubbleView_", 1, "refreshView urls:" + emptyList + ", content:" + (uVar3 != null ? uVar3.f453486b : null));
        k(emptyList);
        this.mBinding.f419041b.setText(Html.fromHtml(str));
        setOnClickListener(new View.OnClickListener() { // from class: cb4.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZPlanSmallHomeBubbleView.m(ZPlanSmallHomeBubbleView.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(ZPlanSmallHomeBubbleView this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.i();
        ZplanViewReportHelper zplanViewReportHelper = this$0.mReporter;
        View mRv = this$0.mBinding.getMRv();
        Intrinsics.checkNotNullExpressionValue(mRv, "mBinding.root");
        zplanViewReportHelper.e(mRv, "em_zplan_avatar_xiaowo_bubble", this$0.g());
        String jumUrl = this$0.mData.f453481b;
        Intrinsics.checkNotNullExpressionValue(jumUrl, "jumUrl");
        if (jumUrl.length() == 0) {
            QLog.e("ZPlanSmallHomeBubbleView_", 1, "mData.jumpUrl is empty!");
            return;
        }
        ISchemeApi iSchemeApi = (ISchemeApi) QRoute.api(ISchemeApi.class);
        Context context = this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        iSchemeApi.launchScheme(context, jumUrl);
    }

    public final void c() {
        i();
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.mDelayHideTask);
        this.mDestroyed = true;
    }

    public final ZPlanViewState e() {
        return this.mAnimHelper.getMState();
    }

    public final void i() {
        QLog.i("ZPlanSmallHomeBubbleView_", 1, "hide");
        g.i(this.mAnimHelper, null, 1, null);
    }

    public final void j(t data, int bubbleIndex) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.mData = data;
        this.mBubbleIndex = bubbleIndex;
        l(data);
        b();
    }

    public final void n() {
        QLog.i("ZPlanSmallHomeBubbleView_", 1, "show");
        g.n(this.mAnimHelper, null, 1, null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZPlanSmallHomeBubbleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ ZPlanSmallHomeBubbleView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanSmallHomeBubbleView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        cn f16 = cn.f(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.mBinding = f16;
        this.mAnimHelper = new g(f16);
        this.mData = new t();
        this.mDelayHideTask = new DelayHideTask(new WeakReference(this));
        this.mReporter = new ZplanViewReportHelper();
        setClipChildren(false);
        setClipToPadding(false);
    }
}
