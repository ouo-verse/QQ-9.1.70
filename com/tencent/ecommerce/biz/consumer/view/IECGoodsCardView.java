package com.tencent.ecommerce.biz.consumer.view;

import android.view.View;
import com.tencent.ecommerce.biz.consumer.ECContentInfo;
import com.tencent.ecommerce.biz.consumer.report.b;
import com.tencent.ecommerce.repo.consumer.resp.JumpInfo;
import com.tencent.ecommerce.repo.consumer.resp.UIInfo;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\u001fJ\b\u0010\u0003\u001a\u00020\u0002H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0002H&J\b\u0010\u0006\u001a\u00020\u0005H&J\"\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u0005H&J\u0012\u0010\u0010\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH&J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0005H&J,\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00122\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\b\u001a\u00020\u0007H&J,\u0010\u0018\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00122\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u0014H&J$\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00122\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u0014H&J\u0010\u0010\u001a\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0005H&J\u001c\u0010\u001e\u001a\u00020\f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001bH&\u00a8\u0006 "}, d2 = {"Lcom/tencent/ecommerce/biz/consumer/view/IECGoodsCardView;", "", "Landroid/view/View;", "getView", "getBigView", "", "getUIType", "Lcom/tencent/ecommerce/biz/consumer/ECContentInfo;", "contentInfo", "Lcom/tencent/ecommerce/repo/consumer/resp/UIInfo;", "uiInfo", "uiType", "", "configCardUI", "Lcom/tencent/ecommerce/biz/consumer/view/IECGoodsCardView$IGoodsCardClickListener;", "listener", "setGoodsCardClickListener", "updateUIByType", "Lcom/tencent/ecommerce/biz/consumer/report/b;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS, "", "", "ext", "onWrapperViewAppear", "onWrapperViewDisappear", "onClickReport", "resetToSmallCardIfNeed", "Landroid/view/View$OnClickListener;", "animStartListener", "animEndListener", "setCloseClickEventListener", "IGoodsCardClickListener", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public interface IECGoodsCardView {
    void configCardUI(ECContentInfo contentInfo, UIInfo uiInfo, int uiType);

    View getBigView();

    int getUIType();

    View getView();

    void onClickReport(b reportParams, Map<String, String> ext);

    void onWrapperViewAppear(b reportParams, Map<String, String> ext, ECContentInfo contentInfo);

    void onWrapperViewDisappear(int uiType, b reportParams, Map<String, String> ext);

    void resetToSmallCardIfNeed(int uiType);

    void setCloseClickEventListener(View.OnClickListener animStartListener, View.OnClickListener animEndListener);

    void setGoodsCardClickListener(IGoodsCardClickListener listener);

    void updateUIByType(int uiType);

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J:\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u001c\b\u0002\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000bH\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/ecommerce/biz/consumer/view/IECGoodsCardView$IGoodsCardClickListener;", "", NodeProps.ON_CLICK, "", "view", "Landroid/view/View;", "url", "", "jumpInfoList", "Ljava/util/ArrayList;", "Lcom/tencent/ecommerce/repo/consumer/resp/JumpInfo;", "Lkotlin/collections/ArrayList;", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public interface IGoodsCardClickListener {
        void onClick(View view, String url, ArrayList<JumpInfo> jumpInfoList);

        /* compiled from: P */
        @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
        /* loaded from: classes31.dex */
        public static final class a {
            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ void a(IGoodsCardClickListener iGoodsCardClickListener, View view, String str, ArrayList arrayList, int i3, Object obj) {
                if (obj == null) {
                    if ((i3 & 2) != 0) {
                        str = null;
                    }
                    if ((i3 & 4) != 0) {
                        arrayList = null;
                    }
                    iGoodsCardClickListener.onClick(view, str, arrayList);
                    return;
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onClick");
            }
        }
    }
}
