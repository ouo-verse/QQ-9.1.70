package com.tencent.kuikly.core.views.compose;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.kuikly.core.base.AbstractBaseView;
import com.tencent.kuikly.core.base.k;
import com.tencent.kuikly.core.views.PageListView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b?\u0010@JZ\u0010\u000e\u001a\u00020\n\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032>\u0010\r\u001a:\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0006\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005j\b\u0012\u0004\u0012\u00028\u0000`\u000b\u00a2\u0006\u0002\b\fR\"\u0010\u0016\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u001e\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010&\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010*\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010!\u001a\u0004\b(\u0010#\"\u0004\b)\u0010%R\"\u0010.\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010\u0019\u001a\u0004\b,\u0010\u001b\"\u0004\b-\u0010\u001dR*\u00103\u001a\u00020\u000f2\u0006\u0010/\u001a\u00020\u000f8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u0010\u0011\u001a\u0004\b1\u0010\u0013\"\u0004\b2\u0010\u0015R\"\u00107\u001a\u00020\u000f8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b4\u0010\u0011\u001a\u0004\b5\u0010\u0013\"\u0004\b6\u0010\u0015R=\u0010>\u001a\u001d\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0006\u0012\u0004\u0012\u00020\n\u0018\u000108\u00a2\u0006\u0002\b\f8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=\u00a8\u0006A"}, d2 = {"Lcom/tencent/kuikly/core/views/compose/SliderPageAttr;", "Lcom/tencent/kuikly/core/base/k;", "T", "", "dataList", "Lkotlin/Function2;", "Lcom/tencent/kuikly/core/views/PageListView;", "Lkotlin/ParameterName;", "name", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "Lcom/tencent/kuikly/core/views/compose/SliderItemCreator;", "Lkotlin/ExtensionFunctionType;", "creator", "o", "", "a", "I", h.F, "()I", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(I)V", "defaultPageIndex", "", "b", "Z", "p", "()Z", "r", "(Z)V", "isHorizontal", "", "c", UserInfo.SEX_FEMALE, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()F", "u", "(F)V", "pageItemWidth", "d", "l", "t", "pageItemHeight", "e", DomainData.DOMAIN_NAME, "v", "scrollEnable", "value", "f", "k", ReportConstant.COSTREPORT_PREFIX, "loopPlayIntervalTimeMs", "g", "i", "setItemCount$core_release", "itemCount", "Lkotlin/Function1;", "Lkotlin/jvm/functions/Function1;", "j", "()Lkotlin/jvm/functions/Function1;", "setLazyCreateItemsTask$core_release", "(Lkotlin/jvm/functions/Function1;)V", "lazyCreateItemsTask", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class SliderPageAttr extends k {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int defaultPageIndex;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private float pageItemWidth;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private float pageItemHeight;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int itemCount;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private Function1<? super PageListView<?, ?>, Unit> lazyCreateItemsTask;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean isHorizontal = true;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean scrollEnable = true;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int loopPlayIntervalTimeMs = 3000;

    /* renamed from: h, reason: from getter */
    public final int getDefaultPageIndex() {
        return this.defaultPageIndex;
    }

    /* renamed from: i, reason: from getter */
    public final int getItemCount() {
        return this.itemCount;
    }

    public final Function1<PageListView<?, ?>, Unit> j() {
        return this.lazyCreateItemsTask;
    }

    /* renamed from: k, reason: from getter */
    public final int getLoopPlayIntervalTimeMs() {
        return this.loopPlayIntervalTimeMs;
    }

    /* renamed from: l, reason: from getter */
    public final float getPageItemHeight() {
        return this.pageItemHeight;
    }

    /* renamed from: m, reason: from getter */
    public final float getPageItemWidth() {
        return this.pageItemWidth;
    }

    /* renamed from: n, reason: from getter */
    public final boolean getScrollEnable() {
        return this.scrollEnable;
    }

    public final <T> void o(final List<? extends T> dataList, final Function2<? super PageListView<?, ?>, ? super T, Unit> creator) {
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        Intrinsics.checkNotNullParameter(creator, "creator");
        if (dataList.isEmpty()) {
            return;
        }
        this.itemCount = dataList.size();
        this.lazyCreateItemsTask = new Function1<PageListView<?, ?>, Unit>() { // from class: com.tencent.kuikly.core.views.compose.SliderPageAttr$initSliderItems$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PageListView<?, ?> pageListView) {
                invoke2(pageListView);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PageListView<?, ?> pageListView) {
                Object first;
                Object last;
                Intrinsics.checkNotNullParameter(pageListView, "$this$null");
                if (SliderPageAttr.this.getItemCount() > 1) {
                    Function2<PageListView<?, ?>, T, Unit> function2 = creator;
                    last = CollectionsKt___CollectionsKt.last((List<? extends Object>) dataList);
                    function2.invoke(pageListView, last);
                }
                Iterable iterable = dataList;
                Function2<PageListView<?, ?>, T, Unit> function22 = creator;
                Iterator it = iterable.iterator();
                while (it.hasNext()) {
                    function22.invoke(pageListView, it.next());
                }
                if (SliderPageAttr.this.getItemCount() > 1) {
                    Function2<PageListView<?, ?>, T, Unit> function23 = creator;
                    first = CollectionsKt___CollectionsKt.first((List<? extends Object>) dataList);
                    function23.invoke(pageListView, first);
                }
            }
        };
    }

    /* renamed from: p, reason: from getter */
    public final boolean getIsHorizontal() {
        return this.isHorizontal;
    }

    public final void q(int i3) {
        this.defaultPageIndex = i3;
    }

    public final void r(boolean z16) {
        this.isHorizontal = z16;
    }

    public final void s(int i3) {
        if (i3 != this.loopPlayIntervalTimeMs) {
            this.loopPlayIntervalTimeMs = i3;
            AbstractBaseView<?, ?> view = view();
            SliderPageView sliderPageView = view instanceof SliderPageView ? (SliderPageView) view : null;
            if (sliderPageView != null) {
                sliderPageView.y();
            }
        }
    }

    public final void t(float f16) {
        this.pageItemHeight = f16;
    }

    public final void u(float f16) {
        this.pageItemWidth = f16;
    }

    public final void v(boolean z16) {
        this.scrollEnable = z16;
    }
}
