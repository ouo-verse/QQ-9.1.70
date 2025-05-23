package com.tencent.ecommerce.biz.consumer.view.topview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tencent.ecommerce.base.device.a;
import com.tencent.ecommerce.biz.consumer.ECContentInfo;
import com.tencent.ecommerce.biz.consumer.report.b;
import com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView;
import com.tencent.ecommerce.repo.consumer.resp.PlayUI;
import com.tencent.ecommerce.repo.consumer.resp.UIInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import java.util.Map;
import kotlin.Metadata;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010-\u001a\u00020,\u00a2\u0006\u0004\b.\u0010/J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J \u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0006H\u0016J\u0012\u0010\u0011\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0006H\u0016J,\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00132\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\t\u001a\u00020\bH\u0016J,\u0010\u0019\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00132\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00160\u0015H\u0016J$\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00132\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00160\u0015H\u0016J\u0010\u0010\u001b\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0006H\u0016J\u001c\u0010\u001f\u001a\u00020\r2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001cH\u0016R\u0016\u0010\f\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010$\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010(\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010+\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*\u00a8\u00060"}, d2 = {"Lcom/tencent/ecommerce/biz/consumer/view/topview/ECBottomFloatingCardView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/ecommerce/biz/consumer/view/IECGoodsCardView;", "Landroid/view/View;", "getView", "getBigView", "", "getUIType", "Lcom/tencent/ecommerce/biz/consumer/ECContentInfo;", "contentInfo", "Lcom/tencent/ecommerce/repo/consumer/resp/UIInfo;", "uiInfo", "uiType", "", "configCardUI", "Lcom/tencent/ecommerce/biz/consumer/view/IECGoodsCardView$IGoodsCardClickListener;", "listener", "setGoodsCardClickListener", "updateUIByType", "Lcom/tencent/ecommerce/biz/consumer/report/b;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS, "", "", "ext", "onWrapperViewAppear", "onWrapperViewDisappear", "onClickReport", "resetToSmallCardIfNeed", "Landroid/view/View$OnClickListener;", "animStartListener", "animEndListener", "setCloseClickEventListener", "d", "I", "e", "Landroid/view/View;", "bottomFloatingCardLayout", "Landroid/widget/LinearLayout;", "f", "Landroid/widget/LinearLayout;", "bottomFloatingEntry", h.F, "Lcom/tencent/ecommerce/repo/consumer/resp/UIInfo;", "cardUIInfo", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECBottomFloatingCardView extends FrameLayout implements IECGoodsCardView {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int uiType;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final View bottomFloatingCardLayout;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final LinearLayout bottomFloatingEntry;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private UIInfo cardUIInfo;

    public ECBottomFloatingCardView(Context context) {
        super(context);
        this.uiType = PlayUI.UIType.BOTTOM_FLOATING_CARD;
        a.f100685b.f(context, LayoutInflater.from(context).inflate(R.layout.coy, (ViewGroup) this, true));
        this.bottomFloatingCardLayout = findViewById(R.id.o2e);
        this.bottomFloatingEntry = (LinearLayout) findViewById(R.id.o2f);
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView
    public void configCardUI(ECContentInfo contentInfo, UIInfo uiInfo, int uiType) {
        this.cardUIInfo = uiInfo;
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView
    public View getBigView() {
        return null;
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView
    /* renamed from: getUIType, reason: from getter */
    public int getUiType() {
        return this.uiType;
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView
    public void updateUIByType(int uiType) {
        this.uiType = uiType;
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView
    public View getView() {
        return this;
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView
    public void resetToSmallCardIfNeed(int uiType) {
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView
    public void setGoodsCardClickListener(IECGoodsCardView.IGoodsCardClickListener listener) {
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView
    public void onClickReport(b reportParams, Map<String, String> ext) {
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView
    public void setCloseClickEventListener(View.OnClickListener animStartListener, View.OnClickListener animEndListener) {
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView
    public void onWrapperViewAppear(b reportParams, Map<String, String> ext, ECContentInfo contentInfo) {
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView
    public void onWrapperViewDisappear(int uiType, b reportParams, Map<String, String> ext) {
    }
}
