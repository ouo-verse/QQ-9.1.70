package k61;

import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.activity.aio.intimate.k;
import com.tencent.mobileqq.activity.aio.intimate.reborn.model.ShareItemClickEvent;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import j61.IntimateBaseModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014J*\u0010\u000e\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\t2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0014J\b\u0010\u000f\u001a\u00020\u0002H\u0016R\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lk61/z;", "Lk61/d;", "", ReportConstant.COSTREPORT_PREFIX, "Landroid/view/View;", "containerView", "onInitView", "Lj61/a;", "data", "", "position", "", "", "payload", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "e", "Z", "hasReportExpo", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class z extends d {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean hasReportExpo;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(IntimateInfo.MemoryDayInfo memoryDayInfo) {
        SimpleEventBus.getInstance().dispatchEvent(new ShareItemClickEvent());
    }

    private final void s() {
        if (this.hasReportExpo) {
            return;
        }
        ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).reportItemEvent("dt_imp", "pg_aio_swipleft", "em_bas_special_day_entry", j61.d.f409515a.d(), null);
        this.hasReportExpo = true;
    }

    @Override // k61.d, com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onDestroy() {
        Object obj;
        super.onDestroy();
        View view = this.mRootView;
        com.tencent.mobileqq.activity.aio.intimate.k kVar = null;
        if (view != null) {
            obj = view.getTag();
        } else {
            obj = null;
        }
        if (obj instanceof com.tencent.mobileqq.activity.aio.intimate.k) {
            kVar = (com.tencent.mobileqq.activity.aio.intimate.k) obj;
        }
        if (kVar != null) {
            kVar.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@Nullable View containerView) {
        s();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public void onBindData(@Nullable IntimateBaseModel data, int position, @Nullable List<Object> payload) {
        Object obj;
        String str;
        IntimateInfo intimateInfo;
        List<IntimateInfo.MemoryDayInfo> list;
        View view = this.mRootView;
        com.tencent.mobileqq.activity.aio.intimate.k kVar = null;
        if (view != null) {
            obj = view.getTag();
        } else {
            obj = null;
        }
        if (obj instanceof com.tencent.mobileqq.activity.aio.intimate.k) {
            kVar = (com.tencent.mobileqq.activity.aio.intimate.k) obj;
        }
        if (kVar != null) {
            AbstractGifImage.resumeAll();
            if (data == null || (str = data.getFriendUin()) == null) {
                str = "";
            }
            kVar.j(str);
            ArrayList<IntimateInfo.MemoryDayInfo> arrayList = new ArrayList<>();
            if (data != null && (intimateInfo = data.getIntimateInfo()) != null && (list = intimateInfo.memoryDayInfoList) != null) {
                arrayList.addAll(list);
            }
            kVar.i(this.mRootView.getContext(), arrayList);
            kVar.k(new k.d() { // from class: k61.y
                @Override // com.tencent.mobileqq.activity.aio.intimate.k.d
                public final void a(IntimateInfo.MemoryDayInfo memoryDayInfo) {
                    z.r(memoryDayInfo);
                }
            });
        }
    }
}
