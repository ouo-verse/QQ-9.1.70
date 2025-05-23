package com.tencent.mobileqq.zplan.card.impl.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zplan.api.IZplanCacheApi;
import com.tencent.mobileqq.zplan.api.ZplanCacheComponentType;
import com.tencent.sqshow.zootopia.card.base.ZootopiaBaseCard;
import com.tencent.sqshow.zootopia.data.ZootopiaCardData;
import com.tencent.sqshow.zootopia.view.ZootopiaLoadFailView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001 B/\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010\u001c\u001a\u00020\n\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J\b\u0010\u000f\u001a\u00020\rH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/zplan/card/impl/view/ZPlanCommonFailCard;", "Lcom/tencent/sqshow/zootopia/card/base/ZootopiaBaseCard;", "Landroid/content/Context;", "context", "Landroid/view/ViewGroup;", "viewParent", "Landroid/view/View;", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/sqshow/zootopia/data/c;", "dataInfo", "", "position", "totalCount", "", "f", "c", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/sqshow/zootopia/view/ZootopiaLoadFailView;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/sqshow/zootopia/view/ZootopiaLoadFailView;", "errorView", "Landroidx/lifecycle/LifecycleOwner;", "owner", "Loa4/a;", "mapResViewModel", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "sourceCurrent", "itemViewType", "<init>", "(Landroid/content/Context;Landroidx/lifecycle/LifecycleOwner;Loa4/a;Lcom/tencent/mobileqq/zootopia/ZootopiaSource;I)V", ExifInterface.LATITUDE_SOUTH, "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanCommonFailCard extends ZootopiaBaseCard {

    /* renamed from: R, reason: from kotlin metadata */
    private ZootopiaLoadFailView errorView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanCommonFailCard(Context context, LifecycleOwner owner, oa4.a mapResViewModel, ZootopiaSource sourceCurrent, int i3) {
        super(context, owner, mapResViewModel, sourceCurrent, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(mapResViewModel, "mapResViewModel");
        Intrinsics.checkNotNullParameter(sourceCurrent, "sourceCurrent");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(ZPlanCommonFailCard this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IZplanCacheApi iZplanCacheApi = (IZplanCacheApi) QRoute.api(IZplanCacheApi.class);
        Context context = this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Object cache = iZplanCacheApi.getCache(context, ZplanCacheComponentType.PARENT_PAGE_HANDLER);
        k84.a aVar = cache instanceof k84.a ? (k84.a) cache : null;
        if (aVar != null) {
            aVar.ne();
        }
    }

    @Override // com.tencent.sqshow.zootopia.card.base.ZootopiaBaseCard, l84.a
    public void c() {
        y("startPlayWhenHighlight, selfPos = " + getSelfPos(), true);
    }

    @Override // l84.a
    public void f(ZootopiaCardData dataInfo, int position, int totalCount) {
        Button btnNetworkError;
        Intrinsics.checkNotNullParameter(dataInfo, "dataInfo");
        y(getSelfItemType() + " - bindItemInfo, position=" + position + ", totalCount=" + totalCount, true);
        ZootopiaLoadFailView zootopiaLoadFailView = this.errorView;
        if (zootopiaLoadFailView == null || (btnNetworkError = zootopiaLoadFailView.getBtnNetworkError()) == null) {
            return;
        }
        btnNetworkError.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.card.impl.view.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZPlanCommonFailCard.E(ZPlanCommonFailCard.this, view);
            }
        });
    }

    @Override // com.tencent.sqshow.zootopia.card.base.ZootopiaBaseCard
    public View s(Context context, ViewGroup viewParent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewParent, "viewParent");
        View view = LayoutInflater.from(context).inflate(R.layout.d7e, viewParent, true);
        this.errorView = (ZootopiaLoadFailView) view.findViewById(R.id.r3k);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return view;
    }

    @Override // com.tencent.sqshow.zootopia.card.base.ZootopiaBaseCard
    public String z() {
        return "ZPlanCommonFailCard";
    }
}
