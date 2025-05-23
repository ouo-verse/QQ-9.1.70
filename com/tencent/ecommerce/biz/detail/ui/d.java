package com.tencent.ecommerce.biz.detail.ui;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.ecommerce.base.ui.ECBasePtsView;
import com.tencent.ecommerce.base.ui.ECBasePtsViewData;
import com.tencent.ecommerce.base.ui.ECSkin;
import com.tencent.ecommerce.biz.bulletin.BulletinScene;
import com.tencent.ecommerce.biz.router.ECScheme;
import com.tencent.ecommerce.biz.transactiondata.trendchart.ECNewChartView;
import com.tencent.ecommerce.biz.util.e;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.pts.core.PTSComposer;
import com.tencent.pts.core.lite.IPTSLiteEventListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kj0.ECChartViewData;
import kj0.ECChartViewExtData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 C2\u00020\u0001:\u0001DB\u0017\u0012\u0006\u0010>\u001a\u00020=\u0012\u0006\u0010@\u001a\u00020?\u00a2\u0006\u0004\bA\u0010BJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0018\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0010H\u0002J\u001e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0018\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0002H\u0002J\u0010\u0010\u001f\u001a\u00020\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dJ\u0010\u0010!\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u0015H\u0016J\u0018\u0010%\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u0015H\u0016J\u0018\u0010&\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u0015H\u0016J\u0006\u0010'\u001a\u00020\u0006R\u001c\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00020(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R(\u00102\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020/0.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R)\u00108\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020/038\u0006\u00a2\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u0018\u0010<\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;\u00a8\u0006E"}, d2 = {"Lcom/tencent/ecommerce/biz/detail/ui/d;", "Lbh0/b;", "", "pageName", "Landroid/view/View;", "view", "", "x0", "Lorg/json/JSONObject;", "productData", "", "z0", "Lkj0/a;", "s0", "Lbh0/c;", "holder", "Lcom/tencent/ecommerce/biz/transactiondata/trendchart/ECNewChartView;", "q0", "chartView", "Lcom/tencent/pts/core/lite/IPTSLiteEventListener;", "w0", "", "selectedIndex", "", "Lkj0/b;", "t0", "anchor", "hintTxt", "v0", "Lcom/tencent/ecommerce/biz/detail/utils/c;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS, "y0", "position", "getItemViewType", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "l0", "k0", "r0", "", "G", "Ljava/util/List;", "recommendExpList", "H", "Lcom/tencent/ecommerce/biz/detail/utils/c;", "Landroidx/lifecycle/MutableLiveData;", "", "I", "Landroidx/lifecycle/MutableLiveData;", "_reportStatus", "Landroidx/lifecycle/LiveData;", "J", "Landroidx/lifecycle/LiveData;", "u0", "()Landroidx/lifecycle/LiveData;", "reportStatus", "Landroid/widget/PopupWindow;", "K", "Landroid/widget/PopupWindow;", "hintPopup", "Landroid/content/Context;", "context", "Lbh0/d;", "viewModel", "<init>", "(Landroid/content/Context;Lbh0/d;)V", "L", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class d extends bh0.b {

    /* renamed from: G, reason: from kotlin metadata */
    private List<String> recommendExpList;

    /* renamed from: H, reason: from kotlin metadata */
    private com.tencent.ecommerce.biz.detail.utils.c reportParams;

    /* renamed from: I, reason: from kotlin metadata */
    private MutableLiveData<Map<String, String>> _reportStatus;

    /* renamed from: J, reason: from kotlin metadata */
    private final LiveData<Map<String, String>> reportStatus;

    /* renamed from: K, reason: from kotlin metadata */
    private PopupWindow hintPopup;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c implements View.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ECBasePtsViewData f102412e;

        c(ECBasePtsViewData eCBasePtsViewData) {
            this.f102412e = eCBasePtsViewData;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            String proteusData = this.f102412e.getProteusData();
            if (proteusData != null) {
                String optString = new JSONObject(proteusData).optString("url");
                if (optString == null) {
                    optString = "";
                }
                if (optString.length() > 0) {
                    ECScheme.g(optString, null, 2, null);
                    com.tencent.ecommerce.biz.common.c.f101553a.d();
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("QSTORE_PRD_DETAIL_EVENT_CODE", "qstore_prd_detail_pg_recommend_ck");
                Map<String, String> p16 = ECScheme.f104135d.p(Uri.parse(optString));
                String str = p16.get("shop_id");
                if (str == null) {
                    str = "";
                }
                linkedHashMap.put("shop_id", str);
                String str2 = p16.get("spu_id");
                linkedHashMap.put("spu_id", str2 != null ? str2 : "");
                linkedHashMap.put("scene", "1");
                d.this._reportStatus.postValue(linkedHashMap);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public d(Context context, bh0.d dVar) {
        super(context, dVar);
        this.recommendExpList = new ArrayList();
        MutableLiveData<Map<String, String>> mutableLiveData = new MutableLiveData<>();
        this._reportStatus = mutableLiveData;
        this.reportStatus = mutableLiveData;
    }

    private final ECNewChartView q0(bh0.c holder) {
        View view = holder.itemView;
        if (view != null) {
            ECBasePtsView eCBasePtsView = (ECBasePtsView) view;
            eCBasePtsView.getCustomViewContainer().removeAllViews();
            ECNewChartView eCNewChartView = new ECNewChartView(this.context, null, 0, true, 6, null);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, e.c(252.0f));
            layoutParams.setMarginStart(e.c(16.0f));
            layoutParams.setMarginEnd(e.c(16.0f));
            layoutParams.bottomMargin = e.c(12.0f);
            eCBasePtsView.getCustomViewContainer().setBackgroundColor(ECSkin.INSTANCE.getColor(R.color.f6491p));
            eCBasePtsView.getCustomViewContainer().addView(eCNewChartView, layoutParams);
            return eCNewChartView;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.tencent.ecommerce.base.ui.ECBasePtsView");
    }

    private final ECChartViewData s0(JSONObject productData) {
        ECChartViewData eCChartViewData = new ECChartViewData(null, null, false, 7, null);
        JSONObject optJSONObject = productData.optJSONObject(WinkDaTongReportConstant.ElementParamValue.XSJ_BANNER_TYPE_PROMOTE);
        JSONArray optJSONArray = optJSONObject != null ? optJSONObject.optJSONArray("promote_datas") : null;
        JSONObject optJSONObject2 = optJSONArray != null ? optJSONArray.optJSONObject(0) : null;
        JSONArray optJSONArray2 = optJSONObject2 != null ? optJSONObject2.optJSONArray("dates") : null;
        JSONArray optJSONArray3 = optJSONObject2 != null ? optJSONObject2.optJSONArray("datas") : null;
        if (optJSONArray2 != null && optJSONArray3 != null) {
            ArrayList arrayList = new ArrayList();
            int length = optJSONArray2.length();
            for (int i3 = 0; i3 < length; i3++) {
                arrayList.add(optJSONArray2.get(i3).toString());
            }
            ArrayList arrayList2 = new ArrayList();
            int length2 = optJSONArray3.length();
            for (int i16 = 0; i16 < length2; i16++) {
                arrayList2.add(Long.valueOf(Long.parseLong(optJSONArray3.get(i16).toString())));
            }
            eCChartViewData.d(arrayList);
            eCChartViewData.c(arrayList2);
        }
        return eCChartViewData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<ECChartViewExtData> t0(JSONObject productData, int selectedIndex) {
        ArrayList arrayList = new ArrayList();
        JSONObject optJSONObject = productData.optJSONObject(WinkDaTongReportConstant.ElementParamValue.XSJ_BANNER_TYPE_PROMOTE);
        JSONArray optJSONArray = optJSONObject != null ? optJSONObject.optJSONArray("promote_datas") : null;
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            int i3 = 0;
            while (i3 < length) {
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i3);
                JSONArray optJSONArray2 = optJSONObject2 != null ? optJSONObject2.optJSONArray("datas") : null;
                if (optJSONArray2 != null) {
                    String optString = optJSONObject2.optString("key");
                    if (optString == null) {
                        optString = "";
                    }
                    arrayList.add(new ECChartViewExtData(optString, optJSONArray2, i3 == selectedIndex));
                }
                i3++;
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v0(View anchor, String hintTxt) {
        PopupWindow popupWindow = this.hintPopup;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        PopupWindow popupWindow2 = new PopupWindow(this.context);
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.f167350cu3, (ViewGroup) null, false);
        ((TextView) inflate.findViewById(R.id.o6o)).setText(hintTxt);
        popupWindow2.setContentView(inflate);
        popupWindow2.setBackgroundDrawable(null);
        popupWindow2.showAsDropDown(anchor, e.c(-82.0f), 0, 17);
        Unit unit = Unit.INSTANCE;
        this.hintPopup = popupWindow2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IPTSLiteEventListener w0(bh0.c holder, ECNewChartView chartView) {
        return new b(holder, chartView);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0027, code lost:
    
        if (r2.equals("product_detail_saas_card") != false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0031, code lost:
    
        if (r2.equals("shop_home_product_card") != false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x003b, code lost:
    
        if (r2.equals("qshop_detail_footer_cell") != false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0045, code lost:
    
        if (r2.equals("qshop_detail_recommen_none") != false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001d, code lost:
    
        if (r2.equals("apply_sample_recommend_card") != false) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void x0(String pageName, View view) {
        switch (pageName.hashCode()) {
            case -2108187815:
                break;
            case -1803512080:
                break;
            case -1722880329:
                break;
            case -1514428463:
                break;
            case -918731305:
                break;
            case -864579656:
                if (pageName.equals("qshop_detail_recommen_title_new")) {
                    view.setBackgroundColor(0);
                    return;
                }
                view.setBackgroundColor(ECSkin.INSTANCE.getColor(R.color.f6491p));
                return;
            default:
                view.setBackgroundColor(ECSkin.INSTANCE.getColor(R.color.f6491p));
                return;
        }
        view.setBackgroundColor(ECSkin.INSTANCE.getColor(R.color.f6471n));
    }

    private final boolean z0(JSONObject productData) {
        JSONArray optJSONArray;
        JSONObject optJSONObject = productData.optJSONObject(WinkDaTongReportConstant.ElementParamValue.XSJ_BANNER_TYPE_PROMOTE);
        return (optJSONObject == null || (optJSONArray = optJSONObject.optJSONArray("promote_datas")) == null || optJSONArray.length() <= 0) ? false : true;
    }

    @Override // bh0.b, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        ECBasePtsViewData i06 = i0(position);
        if (i06 != null) {
            String pageName = i06.getPageName();
            if (pageName.hashCode() == -1803512080 && pageName.equals("qshop_detail_footer_cell")) {
                return 1;
            }
            return super.getItemViewType(position);
        }
        throw new NullPointerException("null cannot be cast to non-null type com.tencent.ecommerce.base.ui.ECBasePtsViewData");
    }

    public final void r0() {
        PopupWindow popupWindow = this.hintPopup;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    public final LiveData<Map<String, String>> u0() {
        return this.reportStatus;
    }

    public final void y0(com.tencent.ecommerce.biz.detail.utils.c reportParams) {
        this.reportParams = reportParams;
    }

    @Override // bh0.b, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: l0 */
    public bh0.c onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType != 1) {
            return super.onCreateViewHolder(parent, viewType);
        }
        return new bh0.c(LayoutInflater.from(this.context).inflate(R.layout.cu6, (ViewGroup) null, false), viewType, null);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00ae, code lost:
    
        if (r6.equals("shop_home_product_card") != false) goto L38;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:13:0x0042. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00d1 A[Catch: Exception -> 0x01cb, TryCatch #0 {Exception -> 0x01cb, blocks: (B:3:0x0006, B:5:0x0015, B:6:0x001f, B:8:0x0025, B:10:0x002b, B:11:0x0034, B:14:0x0047, B:16:0x0050, B:19:0x0062, B:22:0x0073, B:25:0x007f, B:26:0x01b8, B:31:0x0059, B:32:0x0093, B:35:0x00b0, B:38:0x00c2, B:40:0x00d1, B:42:0x00ee, B:44:0x00f8, B:45:0x0102, B:46:0x00b9, B:47:0x009d, B:50:0x00a7, B:52:0x0111, B:54:0x011a, B:57:0x012e, B:59:0x0137, B:61:0x013b, B:63:0x014c, B:66:0x015b, B:68:0x0161, B:69:0x0167, B:71:0x016b, B:73:0x0171, B:75:0x0177, B:76:0x0187, B:78:0x0156, B:79:0x0125, B:81:0x01a5, B:82:0x01b0, B:83:0x01c2, B:84:0x01ca), top: B:2:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00f8 A[Catch: Exception -> 0x01cb, TryCatch #0 {Exception -> 0x01cb, blocks: (B:3:0x0006, B:5:0x0015, B:6:0x001f, B:8:0x0025, B:10:0x002b, B:11:0x0034, B:14:0x0047, B:16:0x0050, B:19:0x0062, B:22:0x0073, B:25:0x007f, B:26:0x01b8, B:31:0x0059, B:32:0x0093, B:35:0x00b0, B:38:0x00c2, B:40:0x00d1, B:42:0x00ee, B:44:0x00f8, B:45:0x0102, B:46:0x00b9, B:47:0x009d, B:50:0x00a7, B:52:0x0111, B:54:0x011a, B:57:0x012e, B:59:0x0137, B:61:0x013b, B:63:0x014c, B:66:0x015b, B:68:0x0161, B:69:0x0167, B:71:0x016b, B:73:0x0171, B:75:0x0177, B:76:0x0187, B:78:0x0156, B:79:0x0125, B:81:0x01a5, B:82:0x01b0, B:83:0x01c2, B:84:0x01ca), top: B:2:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00b9 A[Catch: Exception -> 0x01cb, TryCatch #0 {Exception -> 0x01cb, blocks: (B:3:0x0006, B:5:0x0015, B:6:0x001f, B:8:0x0025, B:10:0x002b, B:11:0x0034, B:14:0x0047, B:16:0x0050, B:19:0x0062, B:22:0x0073, B:25:0x007f, B:26:0x01b8, B:31:0x0059, B:32:0x0093, B:35:0x00b0, B:38:0x00c2, B:40:0x00d1, B:42:0x00ee, B:44:0x00f8, B:45:0x0102, B:46:0x00b9, B:47:0x009d, B:50:0x00a7, B:52:0x0111, B:54:0x011a, B:57:0x012e, B:59:0x0137, B:61:0x013b, B:63:0x014c, B:66:0x015b, B:68:0x0161, B:69:0x0167, B:71:0x016b, B:73:0x0171, B:75:0x0177, B:76:0x0187, B:78:0x0156, B:79:0x0125, B:81:0x01a5, B:82:0x01b0, B:83:0x01c2, B:84:0x01ca), top: B:2:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01a5 A[Catch: Exception -> 0x01cb, TryCatch #0 {Exception -> 0x01cb, blocks: (B:3:0x0006, B:5:0x0015, B:6:0x001f, B:8:0x0025, B:10:0x002b, B:11:0x0034, B:14:0x0047, B:16:0x0050, B:19:0x0062, B:22:0x0073, B:25:0x007f, B:26:0x01b8, B:31:0x0059, B:32:0x0093, B:35:0x00b0, B:38:0x00c2, B:40:0x00d1, B:42:0x00ee, B:44:0x00f8, B:45:0x0102, B:46:0x00b9, B:47:0x009d, B:50:0x00a7, B:52:0x0111, B:54:0x011a, B:57:0x012e, B:59:0x0137, B:61:0x013b, B:63:0x014c, B:66:0x015b, B:68:0x0161, B:69:0x0167, B:71:0x016b, B:73:0x0171, B:75:0x0177, B:76:0x0187, B:78:0x0156, B:79:0x0125, B:81:0x01a5, B:82:0x01b0, B:83:0x01c2, B:84:0x01ca), top: B:2:0x0006 }] */
    @Override // bh0.b, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onBindViewHolder(bh0.c holder, int position) {
        StaggeredGridLayoutManager.LayoutParams layoutParams;
        ECBasePtsViewData i06;
        JSONArray jSONArray;
        ECBasePtsViewData i07;
        PTSComposer ptsComposer;
        String proteusData;
        String optString;
        String optString2;
        try {
            layoutParams = StaggeredGridLayoutManager.LayoutParams.class.isInstance(holder.itemView.getLayoutParams()) ? (StaggeredGridLayoutManager.LayoutParams) holder.itemView.getLayoutParams() : null;
            i06 = i0(position);
        } catch (Exception e16) {
            cg0.a.b("ECShopProductDetailRecyclerViewAdapter", "onBindViewHolder report error:" + e16.getMessage());
        }
        if (i06 != null) {
            View view = holder.itemView;
            if (view instanceof ECBasePtsView) {
                ((ECBasePtsView) view).getCustomViewContainer().removeAllViews();
            }
            String pageName = i06.getPageName();
            switch (pageName.hashCode()) {
                case -2036921889:
                    if (pageName.equals("qshop_chart_info_view_container")) {
                        View view2 = holder.itemView;
                        String proteusData2 = i06.getProteusData();
                        if (proteusData2 == null) {
                            proteusData2 = new JSONObject().toString();
                        }
                        JSONObject jSONObject = new JSONObject(proteusData2);
                        if (!z0(jSONObject)) {
                            super.onBindViewHolder(holder, position);
                            return;
                        }
                        ECChartViewData s06 = s0(jSONObject);
                        ECNewChartView q06 = q0(holder);
                        JSONObject optJSONObject = jSONObject.optJSONObject(WinkDaTongReportConstant.ElementParamValue.XSJ_BANNER_TYPE_PROMOTE);
                        if (optJSONObject == null || (jSONArray = optJSONObject.optJSONArray("promote_datas")) == null) {
                            jSONArray = new JSONArray();
                        }
                        JSONObject optJSONObject2 = jSONArray.optJSONObject(0);
                        if (optJSONObject2 != null) {
                            optJSONObject2.put("isSelected", true);
                        }
                        if ((view2 instanceof ECBasePtsView) && (i07 = i0(position)) != null && (ptsComposer = i07.getPtsComposer()) != null) {
                            ptsComposer.setData(jSONObject.toString());
                            ((ECBasePtsView) view2).b(ptsComposer, w0(holder, q06));
                        }
                        q06.g(s06.b(), s06.a(), false, (r13 & 8) != 0 ? null : t0(jSONObject, 0), (r13 & 16) != 0 ? null : null);
                        holder.itemView.setOnClickListener(null);
                        return;
                    }
                    if (layoutParams == null) {
                        layoutParams = new StaggeredGridLayoutManager.LayoutParams(-1, -2);
                        holder.itemView.setLayoutParams(layoutParams);
                    }
                    layoutParams.setFullSpan(true);
                    holder.itemView.setOnClickListener(null);
                    x0(i06.getPageName(), holder.itemView);
                    super.onBindViewHolder(holder, position);
                    return;
                case -1722880329:
                    break;
                case -1514428463:
                    if (pageName.equals("product_detail_saas_card")) {
                        proteusData = i06.getProteusData();
                        if (proteusData != null) {
                            proteusData = new JSONObject().toString();
                        }
                        optString = new JSONObject(proteusData).optString("spu_id");
                        if (!this.recommendExpList.contains(optString)) {
                            this.recommendExpList.add(optString);
                            LinkedHashMap linkedHashMap = new LinkedHashMap();
                            linkedHashMap.put("to_spu_id", optString);
                            linkedHashMap.put("scene", "1");
                            com.tencent.ecommerce.biz.detail.utils.c cVar = this.reportParams;
                            if (cVar != null) {
                                com.tencent.ecommerce.biz.detail.utils.d.f102466a.f(cVar, linkedHashMap, "qstore_prd_detail_pg_recommend_exp");
                            }
                        }
                        if (layoutParams == null) {
                            layoutParams = new StaggeredGridLayoutManager.LayoutParams(-2, -2);
                            holder.itemView.setLayoutParams(layoutParams);
                        }
                        layoutParams.setFullSpan(false);
                        holder.itemView.setOnClickListener(new c(i06));
                        x0(i06.getPageName(), holder.itemView);
                        super.onBindViewHolder(holder, position);
                        return;
                    }
                    if (layoutParams == null) {
                    }
                    layoutParams.setFullSpan(true);
                    holder.itemView.setOnClickListener(null);
                    x0(i06.getPageName(), holder.itemView);
                    super.onBindViewHolder(holder, position);
                    return;
                case -918731305:
                    if (pageName.equals("apply_sample_recommend_card")) {
                        proteusData = i06.getProteusData();
                        if (proteusData != null) {
                        }
                        optString = new JSONObject(proteusData).optString("spu_id");
                        if (!this.recommendExpList.contains(optString)) {
                        }
                        if (layoutParams == null) {
                        }
                        layoutParams.setFullSpan(false);
                        holder.itemView.setOnClickListener(new c(i06));
                        x0(i06.getPageName(), holder.itemView);
                        super.onBindViewHolder(holder, position);
                        return;
                    }
                    if (layoutParams == null) {
                    }
                    layoutParams.setFullSpan(true);
                    holder.itemView.setOnClickListener(null);
                    x0(i06.getPageName(), holder.itemView);
                    super.onBindViewHolder(holder, position);
                    return;
                case 1863254141:
                    if (pageName.equals("qshop_detail_bulletin")) {
                        String proteusData3 = i06.getProteusData();
                        if (proteusData3 == null) {
                            proteusData3 = new JSONObject().toString();
                        }
                        JSONObject jSONObject2 = new JSONObject(proteusData3);
                        com.tencent.ecommerce.biz.bulletin.b bVar = com.tencent.ecommerce.biz.bulletin.b.f101349a;
                        JSONObject optJSONObject3 = jSONObject2.optJSONObject("shop");
                        com.tencent.ecommerce.biz.bulletin.b.e(bVar, (optJSONObject3 == null || (optString2 = optJSONObject3.optString("id", "")) == null) ? "" : optString2, jSONObject2.optString("spu_id", ""), BulletinScene.GOOD_DETAIL_PAGE, null, 8, null);
                        holder.itemView.setOnClickListener(null);
                        x0(i06.getPageName(), holder.itemView);
                        super.onBindViewHolder(holder, position);
                        return;
                    }
                    if (layoutParams == null) {
                    }
                    layoutParams.setFullSpan(true);
                    holder.itemView.setOnClickListener(null);
                    x0(i06.getPageName(), holder.itemView);
                    super.onBindViewHolder(holder, position);
                    return;
                default:
                    if (layoutParams == null) {
                    }
                    layoutParams.setFullSpan(true);
                    holder.itemView.setOnClickListener(null);
                    x0(i06.getPageName(), holder.itemView);
                    super.onBindViewHolder(holder, position);
                    return;
            }
        } else {
            throw new NullPointerException("null cannot be cast to non-null type com.tencent.ecommerce.base.ui.ECBasePtsViewData");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J<\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/ecommerce/biz/detail/ui/d$b", "Lcom/tencent/ecommerce/base/ui/e;", "", IECDtReport.ACTION_IDENTIFIER, "Ljava/util/HashMap;", "dataMap", "Landroid/view/View;", "view", "Lcom/tencent/pts/core/PTSComposer;", "ptsComposer", "", "onTapEventTriggered", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b extends com.tencent.ecommerce.base.ui.e {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ bh0.c f102409b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ ECNewChartView f102410c;

        b(bh0.c cVar, ECNewChartView eCNewChartView) {
            this.f102409b = cVar;
            this.f102410c = eCNewChartView;
        }

        /* JADX WARN: Can't wrap try/catch for region: R(20:7|(1:65)|11|(16:60|61|14|(1:59)|18|(3:20|(1:28)(3:(1:23)(1:27)|24|25)|26)|29|(2:31|(1:33))|34|(1:36)|37|38|39|40|41|(1:55)(8:44|(1:46)|47|48|(1:50)|51|52|53))|13|14|(1:16)|59|18|(0)|29|(0)|34|(0)|37|38|39|40|41|(1:55)(1:56)) */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x00d9, code lost:
        
            cg0.a.a("ECDetailPageViewModel", "", "");
         */
        /* JADX WARN: Removed duplicated region for block: B:20:0x008e  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x00a4  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00cc  */
        @Override // com.tencent.pts.core.lite.IPTSLiteEventListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onTapEventTriggered(String identifier, HashMap<String, String> dataMap, View view, PTSComposer ptsComposer) {
            String str;
            String jSONObject;
            int parseInt;
            JSONObject optJSONObject;
            JSONArray jSONArray;
            int length;
            int i3;
            String str2;
            JSONArray optJSONArray;
            if (dataMap == null || (str = dataMap.get("eventType")) == null) {
                return;
            }
            if (Intrinsics.areEqual(str, "tapPromoteItem")) {
                d.this.r0();
                if (ptsComposer == null || (jSONObject = ptsComposer.getJsonData()) == null) {
                    jSONObject = new JSONObject().toString();
                }
                JSONObject jSONObject2 = new JSONObject(jSONObject);
                if (identifier != null) {
                    try {
                        parseInt = Integer.parseInt(identifier);
                    } catch (Exception e16) {
                        cg0.a.a("ECShopProductDetailRecyclerViewAdapter", "initChartViewListener", "parse params error, identifier = " + identifier + " error = " + e16);
                    }
                    optJSONObject = jSONObject2.optJSONObject(WinkDaTongReportConstant.ElementParamValue.XSJ_BANNER_TYPE_PROMOTE);
                    if (optJSONObject != null || (jSONArray = optJSONObject.optJSONArray("promote_datas")) == null) {
                        jSONArray = new JSONArray();
                    }
                    length = jSONArray.length();
                    i3 = 0;
                    while (i3 < length) {
                        JSONObject optJSONObject2 = jSONArray.optJSONObject(i3);
                        if (optJSONObject2 != null) {
                            optJSONObject2.put("isSelected", i3 == parseInt);
                        }
                        i3++;
                    }
                    if (ptsComposer != null) {
                        ptsComposer.setData(jSONObject2.toString());
                        bh0.c cVar = this.f102409b;
                        View view2 = cVar.itemView;
                        if (view2 instanceof ECBasePtsView) {
                            ((ECBasePtsView) view2).b(ptsComposer, d.this.w0(cVar, this.f102410c));
                        }
                    }
                    str2 = dataMap.get("promoteItem");
                    if (str2 == null) {
                        str2 = "";
                    }
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3 = new JSONObject(str2);
                    optJSONArray = jSONObject3.optJSONArray("dates");
                    JSONArray optJSONArray2 = jSONObject3.optJSONArray("datas");
                    if (optJSONArray != null || optJSONArray2 == null) {
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    int length2 = optJSONArray.length();
                    for (int i16 = 0; i16 < length2; i16++) {
                        arrayList.add(optJSONArray.get(i16).toString());
                    }
                    int length3 = optJSONArray2.length();
                    for (int i17 = 0; i17 < length3; i17++) {
                        arrayList2.add(Long.valueOf(Long.parseLong(optJSONArray2.get(i17).toString())));
                    }
                    this.f102410c.g(arrayList, arrayList2, false, (r13 & 8) != 0 ? null : d.this.t0(jSONObject2, parseInt), (r13 & 16) != 0 ? null : null);
                    return;
                }
                parseInt = 0;
                optJSONObject = jSONObject2.optJSONObject(WinkDaTongReportConstant.ElementParamValue.XSJ_BANNER_TYPE_PROMOTE);
                if (optJSONObject != null) {
                }
                jSONArray = new JSONArray();
                length = jSONArray.length();
                i3 = 0;
                while (i3 < length) {
                }
                if (ptsComposer != null) {
                }
                str2 = dataMap.get("promoteItem");
                if (str2 == null) {
                }
                JSONObject jSONObject32 = new JSONObject();
                jSONObject32 = new JSONObject(str2);
                optJSONArray = jSONObject32.optJSONArray("dates");
                JSONArray optJSONArray22 = jSONObject32.optJSONArray("datas");
                if (optJSONArray != null) {
                    return;
                } else {
                    return;
                }
            }
            if (Intrinsics.areEqual(str, "tapPromoteItemHint")) {
                String str3 = dataMap.get("promoteItemTips");
                String str4 = str3 != null ? str3 : "";
                if (!(str4.length() > 0) || view == null) {
                    return;
                }
                d.this.v0(view, str4);
            }
        }
    }
}
