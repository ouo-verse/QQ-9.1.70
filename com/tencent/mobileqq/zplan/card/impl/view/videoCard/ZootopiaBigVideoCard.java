package com.tencent.mobileqq.zplan.card.impl.view.videoCard;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.view.ZootopiaDownloadButtonVideoStyle;
import com.tencent.mobileqq.zplan.card.impl.view.banner.itemView.ZplanBaseDownloadButtonItemView;
import com.tencent.mobileqq.zplan.card.impl.view.videoCard.ZootopiaBigVideoCard;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.card.base.ZootopiaBaseCard;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import com.tencent.sqshow.zootopia.card.report.a;
import com.tencent.sqshow.zootopia.data.ZootopiaCardData;
import com.tencent.sqshow.zootopia.data.ZootopiaDownloadBarType;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pv4.s;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 ,2\u00020\u0001:\u0001-B/\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0018\u001a\u00020\u0013\u0012\u0006\u0010'\u001a\u00020&\u0012\u0006\u0010)\u001a\u00020(\u0012\u0006\u0010\u001d\u001a\u00020\f\u00a2\u0006\u0004\b*\u0010+J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J \u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0016J\b\u0010\u0011\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u000fH\u0016R\u0017\u0010\u0018\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001d\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/zplan/card/impl/view/videoCard/ZootopiaBigVideoCard;", "Lcom/tencent/sqshow/zootopia/card/base/ZootopiaBaseCard;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Landroid/content/Context;", "context", "Landroid/view/ViewGroup;", "viewParent", "Landroid/view/View;", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/sqshow/zootopia/data/c;", "dataInfo", "", "position", "totalCount", "", "f", "c", "i", "Landroidx/lifecycle/LifecycleOwner;", BdhLogUtil.LogTag.Tag_Req, "Landroidx/lifecycle/LifecycleOwner;", "getOwner", "()Landroidx/lifecycle/LifecycleOwner;", "owner", ExifInterface.LATITUDE_SOUTH, "I", "getItemViewType", "()I", "itemViewType", "Lcom/tencent/mobileqq/zplan/card/impl/view/videoCard/ZootopiaBigVideoView;", "T", "Lcom/tencent/mobileqq/zplan/card/impl/view/videoCard/ZootopiaBigVideoView;", "contentView", "Lcom/tencent/sqshow/zootopia/card/report/a;", "U", "Lcom/tencent/sqshow/zootopia/card/report/a;", "reportHelper", "Loa4/a;", "mapResViewModel", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "sourceCurrent", "<init>", "(Landroid/content/Context;Landroidx/lifecycle/LifecycleOwner;Loa4/a;Lcom/tencent/mobileqq/zootopia/ZootopiaSource;I)V", "V", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaBigVideoCard extends ZootopiaBaseCard {

    /* renamed from: R, reason: from kotlin metadata */
    private final LifecycleOwner owner;

    /* renamed from: S, reason: from kotlin metadata */
    private final int itemViewType;

    /* renamed from: T, reason: from kotlin metadata */
    private ZootopiaBigVideoView contentView;

    /* renamed from: U, reason: from kotlin metadata */
    private final a reportHelper;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZootopiaBigVideoCard(Context context, LifecycleOwner owner, oa4.a mapResViewModel, ZootopiaSource sourceCurrent, int i3) {
        super(context, owner, mapResViewModel, sourceCurrent, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(mapResViewModel, "mapResViewModel");
        Intrinsics.checkNotNullParameter(sourceCurrent, "sourceCurrent");
        this.owner = owner;
        this.itemViewType = i3;
        this.reportHelper = new a();
    }

    @Override // com.tencent.sqshow.zootopia.card.base.ZootopiaBaseCard, l84.a
    public void c() {
        ZootopiaBigVideoView zootopiaBigVideoView = this.contentView;
        if (zootopiaBigVideoView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentView");
            zootopiaBigVideoView = null;
        }
        zootopiaBigVideoView.p();
        QLog.d("BigVideoCard", 1, "startPlayWhenHighlight");
    }

    @Override // com.tencent.sqshow.zootopia.card.base.ZootopiaBaseCard, l84.a
    public void i() {
        ZootopiaBigVideoView zootopiaBigVideoView = this.contentView;
        if (zootopiaBigVideoView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentView");
            zootopiaBigVideoView = null;
        }
        zootopiaBigVideoView.p();
        QLog.d("BigVideoCard", 1, "triggerVideoPlay");
    }

    @Override // com.tencent.sqshow.zootopia.card.base.ZootopiaBaseCard
    public View s(Context context, ViewGroup viewParent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewParent, "viewParent");
        ZootopiaBigVideoView zootopiaBigVideoView = new ZootopiaBigVideoView(context, this.owner, p());
        this.contentView = zootopiaBigVideoView;
        viewParent.addView(zootopiaBigVideoView);
        ZootopiaBigVideoView zootopiaBigVideoView2 = this.contentView;
        if (zootopiaBigVideoView2 != null) {
            return zootopiaBigVideoView2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("contentView");
        return null;
    }

    @Override // com.tencent.sqshow.zootopia.card.base.ZootopiaBaseCard
    public String z() {
        return "BigVideoCard";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(ZootopiaBigVideoCard this$0, s data, int i3, int i16, String elementType, ZootopiaCardData dataInfo, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        Intrinsics.checkNotNullParameter(elementType, "$elementType");
        Intrinsics.checkNotNullParameter(dataInfo, "$dataInfo");
        ZootopiaBigVideoView zootopiaBigVideoView = null;
        ZootopiaBaseCard.w(this$0, data.f427682c, false, 2, null);
        a aVar = this$0.reportHelper;
        ZootopiaBigVideoView zootopiaBigVideoView2 = this$0.contentView;
        if (zootopiaBigVideoView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentView");
        } else {
            zootopiaBigVideoView = zootopiaBigVideoView2;
        }
        aVar.a(zootopiaBigVideoView, i3, i16, elementType, dataInfo, data, (r20 & 64) != 0 ? new HashMap() : null, (r20 & 128) != 0 ? "em_zplan_element" : null);
    }

    @Override // l84.a
    public void f(final ZootopiaCardData dataInfo, final int position, int totalCount) {
        ZootopiaBigVideoView zootopiaBigVideoView;
        ZootopiaBigVideoView zootopiaBigVideoView2;
        ZootopiaBigVideoView zootopiaBigVideoView3;
        Intrinsics.checkNotNullParameter(dataInfo, "dataInfo");
        List<s> c16 = dataInfo.c();
        if (c16 == null) {
            return;
        }
        if (c16.isEmpty()) {
            QLog.e("BigVideoCard", 1, "data can`t be null");
            return;
        }
        final s sVar = c16.get(0);
        HashMap<String, Object> a16 = ZplanViewReportHelper.INSTANCE.a(dataInfo, position, 0, "4", sVar);
        final String g16 = a.Companion.g(a.INSTANCE, sVar.f427681b, null, 2, null);
        ZootopiaBigVideoView zootopiaBigVideoView4 = this.contentView;
        if (zootopiaBigVideoView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentView");
            zootopiaBigVideoView = null;
        } else {
            zootopiaBigVideoView = zootopiaBigVideoView4;
        }
        ZplanBaseDownloadButtonItemView.f(zootopiaBigVideoView, sVar, r(), o(), ZootopiaDownloadButtonVideoStyle.class, ZootopiaDownloadBarType.VIDEO_DOWNLOAD_BAR, 2, false, a16, null, 256, null);
        ZootopiaBigVideoView zootopiaBigVideoView5 = this.contentView;
        if (zootopiaBigVideoView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentView");
            zootopiaBigVideoView5 = null;
        }
        zootopiaBigVideoView5.z(sVar);
        ZootopiaBigVideoView zootopiaBigVideoView6 = this.contentView;
        if (zootopiaBigVideoView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentView");
            zootopiaBigVideoView2 = null;
        } else {
            zootopiaBigVideoView2 = zootopiaBigVideoView6;
        }
        final int i3 = 0;
        zootopiaBigVideoView2.setContentClickListener(new View.OnClickListener() { // from class: cg3.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZootopiaBigVideoCard.E(ZootopiaBigVideoCard.this, sVar, position, i3, g16, dataInfo, view);
            }
        });
        a aVar = this.reportHelper;
        ZootopiaBigVideoView zootopiaBigVideoView7 = this.contentView;
        if (zootopiaBigVideoView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentView");
            zootopiaBigVideoView3 = null;
        } else {
            zootopiaBigVideoView3 = zootopiaBigVideoView7;
        }
        aVar.c(zootopiaBigVideoView3, position, 0, g16, dataInfo, sVar, (r24 & 64) != 0 ? new HashMap() : null, (r24 & 128) != 0 ? "em_zplan_element" : null, (r24 & 256) != 0 ? null : null, (r24 & 512) != 0);
    }
}
