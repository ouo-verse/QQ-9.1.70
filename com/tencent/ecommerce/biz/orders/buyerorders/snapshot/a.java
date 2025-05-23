package com.tencent.ecommerce.biz.orders.buyerorders.snapshot;

import android.view.View;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.ecommerce.base.ui.ECBasePtsViewData;
import com.tencent.ecommerce.base.ui.e;
import com.tencent.ecommerce.biz.detail.viewmodel.shop.ECShopProductCommentViewModel;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.pts.core.PTSComposer;
import com.tencent.pts.core.lite.IPTSLiteEventListener;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R$\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/snapshot/a;", "Lbh0/d;", "Lcom/tencent/pts/core/PTSComposer;", "ptsComposer", "", "R1", "Lcom/tencent/ecommerce/base/ui/b;", "ptsViewData", "Lcom/tencent/pts/core/lite/IPTSLiteEventListener;", "N1", "Lcom/tencent/ecommerce/biz/orders/buyerorders/snapshot/ISnapshotClickListener;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/ecommerce/biz/orders/buyerorders/snapshot/ISnapshotClickListener;", "P1", "()Lcom/tencent/ecommerce/biz/orders/buyerorders/snapshot/ISnapshotClickListener;", "Q1", "(Lcom/tencent/ecommerce/biz/orders/buyerorders/snapshot/ISnapshotClickListener;)V", "onClickListener", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class a extends bh0.d {

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ISnapshotClickListener onClickListener;

    /* JADX INFO: Access modifiers changed from: private */
    public final void R1(PTSComposer ptsComposer) {
        String jsonData = ptsComposer.getJsonData();
        if (jsonData == null || jsonData.length() == 0) {
            return;
        }
        JSONObject jSONObject = new JSONObject(jsonData);
        JSONObject optJSONObject = jSONObject.optJSONObject("product");
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        optJSONObject.put("showAll", true ^ optJSONObject.optBoolean("showAll", true));
        ptsComposer.setData(jSONObject.toString());
    }

    @Override // bh0.d
    public IPTSLiteEventListener N1(ECBasePtsViewData ptsViewData) {
        return new b();
    }

    /* renamed from: P1, reason: from getter */
    public final ISnapshotClickListener getOnClickListener() {
        return this.onClickListener;
    }

    public final void Q1(ISnapshotClickListener iSnapshotClickListener) {
        this.onClickListener = iSnapshotClickListener;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JN\u0010\f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022&\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/ecommerce/biz/orders/buyerorders/snapshot/a$b", "Lcom/tencent/ecommerce/base/ui/e;", "", IECDtReport.ACTION_IDENTIFIER, "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "dataMap", "Landroid/view/View;", "view", "Lcom/tencent/pts/core/PTSComposer;", "ptsComposer", "", "onTapEventTriggered", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b extends e {
        b() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:30:0x0080, code lost:
        
            r3 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r3);
         */
        @Override // com.tencent.pts.core.lite.IPTSLiteEventListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onTapEventTriggered(String identifier, HashMap<String, String> dataMap, View view, PTSComposer ptsComposer) {
            String str;
            ISnapshotClickListener onClickListener;
            ISnapshotClickListener onClickListener2;
            ISnapshotClickListener onClickListener3;
            String str2;
            Integer intOrNull;
            ISnapshotClickListener onClickListener4;
            if (dataMap == null || !dataMap.keySet().contains("eventType") || ptsComposer == null || (str = dataMap.get("eventType")) == null) {
                return;
            }
            cg0.a.b("ECDetailPageViewModel", "eventType: " + str);
            switch (str.hashCode()) {
                case -2078348594:
                    if (!str.equals("snapshotShopClick") || (onClickListener = a.this.getOnClickListener()) == null) {
                        return;
                    }
                    onClickListener.enterShopDetailPage();
                    return;
                case -1678048983:
                    if (!str.equals("snapshotSpecClick") || (onClickListener2 = a.this.getOnClickListener()) == null) {
                        return;
                    }
                    onClickListener2.showSpecDialog();
                    return;
                case -1303051865:
                    if (!str.equals("expand_detail_list")) {
                        return;
                    }
                    break;
                case -1169601588:
                    if (!str.equals("snapshotTipsClick") || (onClickListener3 = a.this.getOnClickListener()) == null) {
                        return;
                    }
                    onClickListener3.showLatestProductDetail();
                    return;
                case 433923123:
                    if (!str.equals("showPhotoBrowser") || (str2 = dataMap.get("photosData")) == null) {
                        return;
                    }
                    List<String> a16 = ECShopProductCommentViewModel.INSTANCE.a(str2);
                    ISnapshotClickListener onClickListener5 = a.this.getOnClickListener();
                    if (onClickListener5 != null) {
                        int intValue = (identifier == null || intOrNull == null) ? 0 : intOrNull.intValue();
                        onClickListener5.showPhotoInBrowser(a16, intValue);
                        return;
                    }
                    return;
                case 1025781071:
                    if (!str.equals("snapshotPropertyClick") || (onClickListener4 = a.this.getOnClickListener()) == null) {
                        return;
                    }
                    onClickListener4.showPropertyDialog();
                    return;
                case 1861829178:
                    if (!str.equals("collapse_detail_list")) {
                        return;
                    }
                    break;
                default:
                    return;
            }
            a.this.R1(ptsComposer);
        }
    }
}
