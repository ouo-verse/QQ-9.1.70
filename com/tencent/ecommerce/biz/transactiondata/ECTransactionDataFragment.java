package com.tencent.ecommerce.biz.transactiondata;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Observer;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.ecommerce.base.fragment.ECBaseFragment;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.ecommerce.base.ui.ECBasePtsView;
import com.tencent.ecommerce.base.ui.ECBasePtsViewData;
import com.tencent.ecommerce.base.ui.ECBaseViewController;
import com.tencent.ecommerce.biz.datepicker.ECCustomDatePicker;
import com.tencent.ecommerce.biz.transactiondata.trendchart.ECNewChartView;
import com.tencent.ecommerce.biz.util.ECDateUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.pts.core.PTSComposer;
import com.tencent.pts.core.lite.IPTSLiteEventListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.plugins.SensorJsPlugin;
import cooperation.qqcircle.report.QCircleLpReportDc05502;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jj0.ECTransactionReqTimeRange;
import jj0.ECTransactionSaasInfo;
import jj0.a;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ae\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 j2\u00020\u0001:\u0001kB\u0007\u00a2\u0006\u0004\bh\u0010iJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\u001a\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u000f\u001a\u00020\rH\u0016J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\tH\u0002J4\u0010\u0017\u001a\u00020\r2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u00122\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00122\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0007H\u0002J\u0010\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\tH\u0002J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\tH\u0002J\u001c\u0010\u001e\u001a\u00020\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002J\u001a\u0010\u001f\u001a\u00020\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001d\u001a\u00020\u001cH\u0002J\u001c\u0010#\u001a\u0004\u0018\u00010\"2\b\u0010 \u001a\u0004\u0018\u00010\u00052\u0006\u0010!\u001a\u00020\u0005H\u0002J\b\u0010$\u001a\u00020\u0007H\u0002J\u0012\u0010'\u001a\u00020&2\b\u0010%\u001a\u0004\u0018\u00010\"H\u0002J\u0012\u0010*\u001a\u00020)2\b\u0010(\u001a\u0004\u0018\u00010\"H\u0002J\u001a\u0010,\u001a\u00020\u00052\b\u0010 \u001a\u0004\u0018\u00010\u00052\u0006\u0010+\u001a\u00020\u001cH\u0002J\u0010\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0012H\u0002J\u0010\u0010.\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u0005H\u0002J(\u00102\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\"2\u0006\u00100\u001a\u00020\u00142\u0006\u00101\u001a\u00020\u0014H\u0002J\u0018\u00105\u001a\u00020\r2\u0006\u00103\u001a\u00020\u00142\u0006\u00104\u001a\u00020\u0014H\u0002J\b\u00106\u001a\u00020\u0014H\u0002J\b\u00107\u001a\u00020\u0007H\u0002J\b\u00108\u001a\u00020\u0007H\u0002R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010H\u001a\u00020E8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010L\u001a\u00020I8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010P\u001a\u00020M8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010/\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010U\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010W\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bV\u0010TR\u0016\u0010Y\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bX\u0010TR\u0016\u0010[\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bZ\u0010TR\u0018\u0010_\u001a\u0004\u0018\u00010\\8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010^R\u0018\u0010c\u001a\u0004\u0018\u00010`8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\ba\u0010bR\u001c\u0010g\u001a\b\u0012\u0004\u0012\u00020\u00140d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\be\u0010f\u00a8\u0006l"}, d2 = {"Lcom/tencent/ecommerce/biz/transactiondata/ECTransactionDataFragment;", "Lcom/tencent/ecommerce/base/fragment/ECBaseFragment;", "", "uh", "getContentLayoutId", "", "getBusinessDescription", "", "Eh", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, MosaicConstants$JsFunction.FUNC_ON_DESTROY, MosaicConstants$JsProperty.PROP_ROOT_VIEW, "initView", "", "label", "", "data", "isMoneyTab", "Ai", SensorJsPlugin.SENSOR_INTERVAL_UI, "Lcom/tencent/pts/core/lite/IPTSLiteEventListener;", "vi", IECDtReport.ACTION_IDENTIFIER, "Lorg/json/JSONArray;", "filterList", "Di", "wi", "commissionJsonStr", "filterListName", "Lorg/json/JSONObject;", "si", "xi", "selectTime", "Ljj0/d;", "qi", "selectOrderChannel", "Ljj0/e;", "ri", "saasInfoJsonArray", "oi", "getDataList", "pi", "commissionJson", "startTimeStamp", "endTimeStamp", WidgetCacheLunarData.YI, "startTime", "endTime", "zi", "ti", "Ci", "Bi", "Ljj0/a;", "P", "Ljj0/a;", "sumDataViewModel", "Ljj0/b;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Ljj0/b;", "historyCurveViewModel", "Ljj0/c;", BdhLogUtil.LogTag.Tag_Req, "Ljj0/c;", "transactionModel", "Lcom/tencent/ecommerce/base/ui/b;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/ecommerce/base/ui/b;", "commissionPtsViewData", "Lcom/tencent/ecommerce/base/ui/ECBaseViewController;", "T", "Lcom/tencent/ecommerce/base/ui/ECBaseViewController;", "commissionContainerController", "Ljj0/f;", "U", "Ljj0/f;", "saasInfoReq", "V", "Lorg/json/JSONObject;", "W", "Lorg/json/JSONArray;", "orderTimeFilterList", "X", "orderChannelFilterList", "Y", "timeFilterList", "Z", "conditionFilterList", "Lcom/tencent/ecommerce/biz/transactiondata/trendchart/ECNewChartView;", "a0", "Lcom/tencent/ecommerce/biz/transactiondata/trendchart/ECNewChartView;", "chartView", "Lcom/tencent/ecommerce/biz/datepicker/ECCustomDatePicker;", "b0", "Lcom/tencent/ecommerce/biz/datepicker/ECCustomDatePicker;", "datePicker", "Ljava/util/ArrayList;", "c0", "Ljava/util/ArrayList;", "reqTimeWindow", "<init>", "()V", "d0", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECTransactionDataFragment extends ECBaseFragment {

    /* renamed from: P, reason: from kotlin metadata */
    private a sumDataViewModel;

    /* renamed from: Q, reason: from kotlin metadata */
    private jj0.b historyCurveViewModel;

    /* renamed from: R, reason: from kotlin metadata */
    private jj0.c transactionModel;

    /* renamed from: S, reason: from kotlin metadata */
    private ECBasePtsViewData commissionPtsViewData;

    /* renamed from: T, reason: from kotlin metadata */
    private ECBaseViewController commissionContainerController;

    /* renamed from: U, reason: from kotlin metadata */
    private jj0.f saasInfoReq;

    /* renamed from: V, reason: from kotlin metadata */
    private JSONObject commissionJson;

    /* renamed from: W, reason: from kotlin metadata */
    private JSONArray orderTimeFilterList;

    /* renamed from: X, reason: from kotlin metadata */
    private JSONArray orderChannelFilterList;

    /* renamed from: Y, reason: from kotlin metadata */
    private JSONArray timeFilterList;

    /* renamed from: Z, reason: from kotlin metadata */
    private JSONArray conditionFilterList;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private ECNewChartView chartView;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private ECCustomDatePicker datePicker;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private ArrayList<Long> reqTimeWindow = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lorg/json/JSONObject;", "kotlin.jvm.PlatformType", "it", "", "a", "(Lorg/json/JSONObject;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class d<T> implements Observer<JSONObject> {
        d() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(JSONObject jSONObject) {
            JSONObject jSONObject2 = new JSONObject(ECTransactionDataFragment.Oh(ECTransactionDataFragment.this).getProteusData());
            jSONObject2.put("sum_info", jSONObject);
            ECTransactionDataFragment.Oh(ECTransactionDataFragment.this).d(jSONObject2.toString());
            ECTransactionDataFragment.Mh(ECTransactionDataFragment.this).h(ECTransactionDataFragment.this.requireContext(), ECTransactionDataFragment.Oh(ECTransactionDataFragment.this));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class e<T> implements Observer<Boolean> {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f104827e;

        e(View view) {
            this.f104827e = view;
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(Boolean bool) {
            List dataList = ECTransactionDataFragment.this.getDataList();
            if (dataList != null) {
                ECTransactionDataFragment eCTransactionDataFragment = ECTransactionDataFragment.this;
                eCTransactionDataFragment.Ai(ECTransactionDataFragment.Sh(eCTransactionDataFragment).d(), dataList, this.f104827e, ECTransactionDataFragment.this.xi());
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J<\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/ecommerce/biz/transactiondata/ECTransactionDataFragment$f", "Lcom/tencent/ecommerce/base/ui/e;", "", IECDtReport.ACTION_IDENTIFIER, "Ljava/util/HashMap;", "dataMap", "Landroid/view/View;", "view", "Lcom/tencent/pts/core/PTSComposer;", "ptsComposer", "", "onTapEventTriggered", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class f extends com.tencent.ecommerce.base.ui.e {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f104829b;

        f(View view) {
            this.f104829b = view;
        }

        @Override // com.tencent.pts.core.lite.IPTSLiteEventListener
        public void onTapEventTriggered(String identifier, HashMap<String, String> dataMap, View view, PTSComposer ptsComposer) {
            if (identifier != null) {
                boolean z16 = true;
                if (!(identifier.length() == 0)) {
                    cg0.a.b("ECTransactionDataFragment", "[clickItem] identifier = " + identifier);
                    if (Intrinsics.areEqual(identifier, "orderDetailView")) {
                        yi0.a.r(Uri.parse(String.valueOf(6)));
                    }
                    String proteusData = ECTransactionDataFragment.Oh(ECTransactionDataFragment.this).getProteusData();
                    if (proteusData != null && proteusData.length() != 0) {
                        z16 = false;
                    }
                    if (z16) {
                        return;
                    }
                    ECTransactionDataFragment.this.commissionJson = new JSONObject(proteusData);
                    ECTransactionDataFragment eCTransactionDataFragment = ECTransactionDataFragment.this;
                    JSONArray optJSONArray = ECTransactionDataFragment.Nh(eCTransactionDataFragment).optJSONArray("order_time_filter_list");
                    if (optJSONArray == null) {
                        optJSONArray = new JSONArray();
                    }
                    eCTransactionDataFragment.orderTimeFilterList = optJSONArray;
                    ECTransactionDataFragment eCTransactionDataFragment2 = ECTransactionDataFragment.this;
                    JSONArray optJSONArray2 = ECTransactionDataFragment.Nh(eCTransactionDataFragment2).optJSONArray("order_channel_filter_list");
                    if (optJSONArray2 == null) {
                        optJSONArray2 = new JSONArray();
                    }
                    eCTransactionDataFragment2.orderChannelFilterList = optJSONArray2;
                    ECTransactionDataFragment eCTransactionDataFragment3 = ECTransactionDataFragment.this;
                    JSONArray optJSONArray3 = ECTransactionDataFragment.Nh(eCTransactionDataFragment3).optJSONArray("history_time_filter_list");
                    if (optJSONArray3 == null) {
                        optJSONArray3 = new JSONArray();
                    }
                    eCTransactionDataFragment3.timeFilterList = optJSONArray3;
                    ECTransactionDataFragment eCTransactionDataFragment4 = ECTransactionDataFragment.this;
                    JSONArray optJSONArray4 = ECTransactionDataFragment.Nh(eCTransactionDataFragment4).optJSONArray("history_data_filter_list");
                    if (optJSONArray4 == null) {
                        optJSONArray4 = new JSONArray();
                    }
                    eCTransactionDataFragment4.conditionFilterList = optJSONArray4;
                    ECTransactionDataFragment eCTransactionDataFragment5 = ECTransactionDataFragment.this;
                    eCTransactionDataFragment5.Di(identifier, ECTransactionDataFragment.Uh(eCTransactionDataFragment5));
                    ECTransactionDataFragment eCTransactionDataFragment6 = ECTransactionDataFragment.this;
                    eCTransactionDataFragment6.Di(identifier, ECTransactionDataFragment.Th(eCTransactionDataFragment6));
                    ECTransactionDataFragment eCTransactionDataFragment7 = ECTransactionDataFragment.this;
                    eCTransactionDataFragment7.Di(identifier, ECTransactionDataFragment.ai(eCTransactionDataFragment7));
                    ECTransactionDataFragment eCTransactionDataFragment8 = ECTransactionDataFragment.this;
                    eCTransactionDataFragment8.Di(identifier, ECTransactionDataFragment.Ph(eCTransactionDataFragment8));
                    ECTransactionDataFragment.Oh(ECTransactionDataFragment.this).d(ECTransactionDataFragment.Nh(ECTransactionDataFragment.this).toString());
                    if (ptsComposer != null) {
                        ptsComposer.updateData(ECTransactionDataFragment.Oh(ECTransactionDataFragment.this).getProteusData());
                    }
                    ECTransactionDataFragment eCTransactionDataFragment9 = ECTransactionDataFragment.this;
                    if (eCTransactionDataFragment9.wi(identifier, ECTransactionDataFragment.Uh(eCTransactionDataFragment9))) {
                        if (Intrinsics.areEqual(identifier, "order_time_diy")) {
                            ECTransactionDataFragment.this.pi(identifier);
                            return;
                        }
                        ECTransactionDataFragment eCTransactionDataFragment10 = ECTransactionDataFragment.this;
                        JSONObject si5 = eCTransactionDataFragment10.si(ECTransactionDataFragment.Oh(eCTransactionDataFragment10).getProteusData(), "order_time_filter_list");
                        ECTransactionDataFragment eCTransactionDataFragment11 = ECTransactionDataFragment.this;
                        ECTransactionDataFragment.Zh(ECTransactionDataFragment.this).f(ECTransactionDataFragment.this.qi(si5), ECTransactionDataFragment.this.ri(eCTransactionDataFragment11.si(ECTransactionDataFragment.Oh(eCTransactionDataFragment11).getProteusData(), "order_channel_filter_list")), ECTransactionDataFragment.this.Ci());
                        return;
                    }
                    ECTransactionDataFragment eCTransactionDataFragment12 = ECTransactionDataFragment.this;
                    if (eCTransactionDataFragment12.wi(identifier, ECTransactionDataFragment.Th(eCTransactionDataFragment12))) {
                        ECTransactionDataFragment eCTransactionDataFragment13 = ECTransactionDataFragment.this;
                        ECTransactionSaasInfo ri5 = ECTransactionDataFragment.this.ri(eCTransactionDataFragment13.si(ECTransactionDataFragment.Oh(eCTransactionDataFragment13).getProteusData(), "order_channel_filter_list"));
                        ECTransactionDataFragment eCTransactionDataFragment14 = ECTransactionDataFragment.this;
                        ECTransactionDataFragment.Zh(ECTransactionDataFragment.this).f(ECTransactionDataFragment.this.qi(eCTransactionDataFragment14.si(ECTransactionDataFragment.Oh(eCTransactionDataFragment14).getProteusData(), "order_time_filter_list")), ri5, ECTransactionDataFragment.this.Ci());
                        return;
                    }
                    ECTransactionDataFragment eCTransactionDataFragment15 = ECTransactionDataFragment.this;
                    if (eCTransactionDataFragment15.wi(identifier, ECTransactionDataFragment.ai(eCTransactionDataFragment15))) {
                        ECTransactionDataFragment eCTransactionDataFragment16 = ECTransactionDataFragment.this;
                        ECTransactionDataFragment.Sh(ECTransactionDataFragment.this).n(ECTransactionDataFragment.this.qi(eCTransactionDataFragment16.si(ECTransactionDataFragment.Oh(eCTransactionDataFragment16).getProteusData(), "history_time_filter_list")), ECTransactionDataFragment.this.Bi());
                        return;
                    }
                    ECTransactionDataFragment eCTransactionDataFragment17 = ECTransactionDataFragment.this;
                    if (eCTransactionDataFragment17.wi(identifier, ECTransactionDataFragment.Ph(eCTransactionDataFragment17))) {
                        Object[] array = ECTransactionDataFragment.Sh(ECTransactionDataFragment.this).d().toArray(new String[0]);
                        if (array != null) {
                            List dataList = ECTransactionDataFragment.this.getDataList();
                            if (dataList != null) {
                                ECTransactionDataFragment eCTransactionDataFragment18 = ECTransactionDataFragment.this;
                                eCTransactionDataFragment18.Ai(ECTransactionDataFragment.Sh(eCTransactionDataFragment18).d(), dataList, this.f104829b, ECTransactionDataFragment.this.xi());
                                return;
                            }
                            return;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                    }
                    return;
                }
            }
            cg0.a.b("ECTransactionDataFragment", "initPTSListener, identifier is null");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECTransactionDataFragment.this.requireActivity().finish();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ai(List<String> label, List<Long> data, View rootView, boolean isMoneyTab) {
        if (label.isEmpty() || data.isEmpty()) {
            return;
        }
        ECNewChartView eCNewChartView = new ECNewChartView(requireContext(), null, 0, false, 6, null);
        this.chartView = eCNewChartView;
        eCNewChartView.g(label, data, isMoneyTab, (r13 & 8) != 0 ? null : null, (r13 & 16) != 0 ? null : null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        FrameLayout frameLayout = (FrameLayout) rootView.findViewById(R.id.ocx);
        frameLayout.removeAllViews();
        frameLayout.addView(this.chartView, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean Bi() {
        ECBasePtsViewData eCBasePtsViewData = this.commissionPtsViewData;
        if (eCBasePtsViewData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commissionPtsViewData");
        }
        JSONObject si5 = si(eCBasePtsViewData.getProteusData(), "history_time_filter_list");
        String optString = si5 != null ? si5.optString("key") : null;
        ECBasePtsViewData eCBasePtsViewData2 = this.commissionPtsViewData;
        if (eCBasePtsViewData2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commissionPtsViewData");
        }
        JSONObject si6 = si(eCBasePtsViewData2.getProteusData(), "history_data_filter_list");
        return Intrinsics.areEqual(optString, "time_filter_last_7") && Intrinsics.areEqual(si6 != null ? si6.optString("key") : null, "data_amount");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean Ci() {
        ECBasePtsViewData eCBasePtsViewData = this.commissionPtsViewData;
        if (eCBasePtsViewData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commissionPtsViewData");
        }
        JSONObject si5 = si(eCBasePtsViewData.getProteusData(), "order_time_filter_list");
        String optString = si5 != null ? si5.optString("key") : null;
        ECBasePtsViewData eCBasePtsViewData2 = this.commissionPtsViewData;
        if (eCBasePtsViewData2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commissionPtsViewData");
        }
        JSONObject si6 = si(eCBasePtsViewData2.getProteusData(), "order_channel_filter_list");
        return Intrinsics.areEqual(optString, "order_time_today") && Intrinsics.areEqual(si6 != null ? si6.optString("key") : null, "all");
    }

    public static final /* synthetic */ ECBaseViewController Mh(ECTransactionDataFragment eCTransactionDataFragment) {
        ECBaseViewController eCBaseViewController = eCTransactionDataFragment.commissionContainerController;
        if (eCBaseViewController == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commissionContainerController");
        }
        return eCBaseViewController;
    }

    public static final /* synthetic */ JSONObject Nh(ECTransactionDataFragment eCTransactionDataFragment) {
        JSONObject jSONObject = eCTransactionDataFragment.commissionJson;
        if (jSONObject == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commissionJson");
        }
        return jSONObject;
    }

    public static final /* synthetic */ ECBasePtsViewData Oh(ECTransactionDataFragment eCTransactionDataFragment) {
        ECBasePtsViewData eCBasePtsViewData = eCTransactionDataFragment.commissionPtsViewData;
        if (eCBasePtsViewData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commissionPtsViewData");
        }
        return eCBasePtsViewData;
    }

    public static final /* synthetic */ JSONArray Ph(ECTransactionDataFragment eCTransactionDataFragment) {
        JSONArray jSONArray = eCTransactionDataFragment.conditionFilterList;
        if (jSONArray == null) {
            Intrinsics.throwUninitializedPropertyAccessException("conditionFilterList");
        }
        return jSONArray;
    }

    public static final /* synthetic */ jj0.b Sh(ECTransactionDataFragment eCTransactionDataFragment) {
        jj0.b bVar = eCTransactionDataFragment.historyCurveViewModel;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("historyCurveViewModel");
        }
        return bVar;
    }

    public static final /* synthetic */ JSONArray Th(ECTransactionDataFragment eCTransactionDataFragment) {
        JSONArray jSONArray = eCTransactionDataFragment.orderChannelFilterList;
        if (jSONArray == null) {
            Intrinsics.throwUninitializedPropertyAccessException("orderChannelFilterList");
        }
        return jSONArray;
    }

    public static final /* synthetic */ JSONArray Uh(ECTransactionDataFragment eCTransactionDataFragment) {
        JSONArray jSONArray = eCTransactionDataFragment.orderTimeFilterList;
        if (jSONArray == null) {
            Intrinsics.throwUninitializedPropertyAccessException("orderTimeFilterList");
        }
        return jSONArray;
    }

    public static final /* synthetic */ a Zh(ECTransactionDataFragment eCTransactionDataFragment) {
        a aVar = eCTransactionDataFragment.sumDataViewModel;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sumDataViewModel");
        }
        return aVar;
    }

    public static final /* synthetic */ JSONArray ai(ECTransactionDataFragment eCTransactionDataFragment) {
        JSONArray jSONArray = eCTransactionDataFragment.timeFilterList;
        if (jSONArray == null) {
            Intrinsics.throwUninitializedPropertyAccessException("timeFilterList");
        }
        return jSONArray;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<Long> getDataList() {
        ECBasePtsViewData eCBasePtsViewData = this.commissionPtsViewData;
        if (eCBasePtsViewData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commissionPtsViewData");
        }
        JSONObject si5 = si(eCBasePtsViewData.getProteusData(), "history_data_filter_list");
        if (si5 != null) {
            if (Intrinsics.areEqual(si5.optString("key"), "data_amount")) {
                jj0.b bVar = this.historyCurveViewModel;
                if (bVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("historyCurveViewModel");
                }
                return bVar.h();
            }
            if (Intrinsics.areEqual(si5.optString("key"), "data_count")) {
                jj0.b bVar2 = this.historyCurveViewModel;
                if (bVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("historyCurveViewModel");
                }
                return bVar2.j();
            }
            if (Intrinsics.areEqual(si5.optString("key"), "data_people")) {
                jj0.b bVar3 = this.historyCurveViewModel;
                if (bVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("historyCurveViewModel");
                }
                return bVar3.l();
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void pi(String identifier) {
        if (this.datePicker == null) {
            ECCustomDatePicker eCCustomDatePicker = new ECCustomDatePicker(requireContext(), new b(identifier), ECDateUtil.c(12), System.currentTimeMillis(), true, null, 32, null);
            this.datePicker = eCCustomDatePicker;
            eCCustomDatePicker.o(false);
            ECCustomDatePicker eCCustomDatePicker2 = this.datePicker;
            if (eCCustomDatePicker2 != null) {
                eCCustomDatePicker2.p(false);
            }
            ECCustomDatePicker eCCustomDatePicker3 = this.datePicker;
            if (eCCustomDatePicker3 != null) {
                eCCustomDatePicker3.n(false);
            }
        }
        ECCustomDatePicker eCCustomDatePicker4 = this.datePicker;
        if (eCCustomDatePicker4 != null) {
            eCCustomDatePicker4.s(System.currentTimeMillis());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ECTransactionReqTimeRange qi(JSONObject selectTime) {
        long ti5 = ti();
        if (selectTime == null) {
            return new ECTransactionReqTimeRange(0L, 0L, 3, null);
        }
        String string = selectTime.getString("key");
        if (string != null) {
            switch (string.hashCode()) {
                case -635827441:
                    if (string.equals("order_time_last_7")) {
                        return new ECTransactionReqTimeRange(ECDateUtil.b(6), ti5);
                    }
                    break;
                case -96875887:
                    if (string.equals("time_filter_last_30")) {
                        return new ECTransactionReqTimeRange(ECDateUtil.b(29), ti5);
                    }
                    break;
                case 402921696:
                    if (string.equals("order_time_today")) {
                        return new ECTransactionReqTimeRange(ECDateUtil.b(0), ti5);
                    }
                    break;
                case 930011635:
                    if (string.equals("order_time_diy")) {
                        return new ECTransactionReqTimeRange(this.reqTimeWindow.get(0).longValue(), this.reqTimeWindow.get(1).longValue());
                    }
                    break;
                case 1243800963:
                    if (string.equals("time_filter_last_7")) {
                        return new ECTransactionReqTimeRange(ECDateUtil.b(6), ti5);
                    }
                    break;
                case 1764185733:
                    if (string.equals("order_time_last_30")) {
                        return new ECTransactionReqTimeRange(ECDateUtil.b(29), ti5);
                    }
                    break;
            }
        }
        return new ECTransactionReqTimeRange(0L, 0L, 3, null);
    }

    private final long ti() {
        long currentTimeMillis = System.currentTimeMillis();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(currentTimeMillis);
        calendar.set(11, 23);
        calendar.set(12, 59);
        calendar.set(13, 59);
        return calendar.getTimeInMillis() / 1000;
    }

    private final void ui(View rootView) {
        long ti5 = ti();
        jj0.f fVar = new jj0.f();
        this.saasInfoReq = fVar;
        fVar.a().observe(getViewLifecycleOwner(), new c());
        jj0.f fVar2 = this.saasInfoReq;
        if (fVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("saasInfoReq");
        }
        fVar2.b();
        ECTransactionReqTimeRange eCTransactionReqTimeRange = new ECTransactionReqTimeRange(ECDateUtil.b(0), ti5);
        ECTransactionSaasInfo eCTransactionSaasInfo = new ECTransactionSaasInfo("\u5168\u90e8", "all", 0);
        a aVar = this.sumDataViewModel;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sumDataViewModel");
        }
        aVar.f(eCTransactionReqTimeRange, eCTransactionSaasInfo, Ci());
        ECTransactionReqTimeRange eCTransactionReqTimeRange2 = new ECTransactionReqTimeRange(ECDateUtil.b(6), ti5);
        jj0.b bVar = this.historyCurveViewModel;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("historyCurveViewModel");
        }
        bVar.n(eCTransactionReqTimeRange2, Bi());
        a aVar2 = this.sumDataViewModel;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sumDataViewModel");
        }
        aVar2.e().observe(getViewLifecycleOwner(), new d());
        jj0.b bVar2 = this.historyCurveViewModel;
        if (bVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("historyCurveViewModel");
        }
        bVar2.m().observe(getViewLifecycleOwner(), new e(rootView));
    }

    private final IPTSLiteEventListener vi(View rootView) {
        return new f(rootView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean wi(String identifier, JSONArray filterList) {
        int length = filterList.length();
        for (int i3 = 0; i3 < length; i3++) {
            if (Intrinsics.areEqual(filterList.optJSONObject(i3).optString("key"), identifier)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean xi() {
        ECBasePtsViewData eCBasePtsViewData = this.commissionPtsViewData;
        if (eCBasePtsViewData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commissionPtsViewData");
        }
        JSONObject si5 = si(eCBasePtsViewData.getProteusData(), "history_data_filter_list");
        return si5 != null && si5.optString("key").equals("data_amount");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void yi(String identifier, JSONObject commissionJson, long startTimeStamp, long endTimeStamp) {
        JSONArray optJSONArray = commissionJson.optJSONArray("order_time_filter_list");
        if (optJSONArray != null) {
            if (identifier.length() > 0) {
                int length = optJSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                    if (Intrinsics.areEqual(optJSONObject.optString("key"), identifier)) {
                        optJSONObject.put("selected", true);
                    } else {
                        optJSONObject.put("selected", false);
                    }
                }
                JSONObject jSONObject = new JSONObject();
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(startTimeStamp);
                Calendar calendar2 = Calendar.getInstance();
                calendar2.setTimeInMillis(endTimeStamp);
                StringBuilder sb5 = new StringBuilder();
                sb5.append(calendar.get(1));
                sb5.append(".");
                sb5.append(calendar.get(2) + 1);
                sb5.append(".");
                sb5.append(calendar.get(5));
                StringBuilder sb6 = new StringBuilder();
                sb6.append(calendar2.get(1));
                sb6.append(".");
                sb6.append(calendar2.get(2) + 1);
                sb6.append(".");
                sb6.append(calendar2.get(5));
                jSONObject.put(QCircleLpReportDc05502.KEY_BEGIN_TIME, sb5);
                jSONObject.put("end_time", sb6);
                commissionJson.put("custom_time", jSONObject);
                ECBasePtsViewData eCBasePtsViewData = this.commissionPtsViewData;
                if (eCBasePtsViewData == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("commissionPtsViewData");
                }
                eCBasePtsViewData.d(commissionJson.toString());
                ECBaseViewController eCBaseViewController = this.commissionContainerController;
                if (eCBaseViewController == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("commissionContainerController");
                }
                Context requireContext = requireContext();
                ECBasePtsViewData eCBasePtsViewData2 = this.commissionPtsViewData;
                if (eCBasePtsViewData2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("commissionPtsViewData");
                }
                eCBaseViewController.h(requireContext, eCBasePtsViewData2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zi(long startTime, long endTime) {
        ECTransactionReqTimeRange eCTransactionReqTimeRange = new ECTransactionReqTimeRange(startTime, endTime);
        ECBasePtsViewData eCBasePtsViewData = this.commissionPtsViewData;
        if (eCBasePtsViewData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commissionPtsViewData");
        }
        JSONObject si5 = si(eCBasePtsViewData.getProteusData(), "order_channel_filter_list");
        a aVar = this.sumDataViewModel;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sumDataViewModel");
        }
        aVar.f(eCTransactionReqTimeRange, ri(si5), Ci());
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public boolean Eh() {
        return false;
    }

    @Override // com.tencent.ecommerce.base.fragment.api.IECBaseFragment
    /* renamed from: getBusinessDescription */
    public String getTAG() {
        return "ECTransactionDataFragment";
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int getContentLayoutId() {
        return R.layout.cv6;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        ECBaseViewController eCBaseViewController = this.commissionContainerController;
        if (eCBaseViewController == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commissionContainerController");
        }
        eCBaseViewController.g();
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        ui(view);
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int uh() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lorg/json/JSONArray;", "kotlin.jvm.PlatformType", "it", "", "a", "(Lorg/json/JSONArray;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c<T> implements Observer<JSONArray> {
        c() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(JSONArray jSONArray) {
            if (jSONArray == null) {
                jSONArray = new JSONArray();
            }
            ECBasePtsViewData Oh = ECTransactionDataFragment.Oh(ECTransactionDataFragment.this);
            ECTransactionDataFragment eCTransactionDataFragment = ECTransactionDataFragment.this;
            Oh.d(eCTransactionDataFragment.oi(ECTransactionDataFragment.Oh(eCTransactionDataFragment).getProteusData(), jSONArray));
            ECTransactionDataFragment.Mh(ECTransactionDataFragment.this).h(ECTransactionDataFragment.this.requireContext(), ECTransactionDataFragment.Oh(ECTransactionDataFragment.this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ECTransactionSaasInfo ri(JSONObject selectOrderChannel) {
        if (selectOrderChannel != null) {
            return new ECTransactionSaasInfo(selectOrderChannel.optString("title"), selectOrderChannel.optString("key"), Integer.valueOf(selectOrderChannel.optInt("typeNum")));
        }
        return new ECTransactionSaasInfo("\u5168\u90e8", "all", 0);
    }

    private final void initView(View rootView) {
        Map<String, ? extends IPTSLiteEventListener> mapOf;
        rootView.findViewById(R.id.o2l).setOnClickListener(new g());
        this.sumDataViewModel = new a();
        this.historyCurveViewModel = new jj0.b();
        a aVar = this.sumDataViewModel;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sumDataViewModel");
        }
        this.transactionModel = new jj0.c(aVar.d());
        View findViewById = rootView.findViewById(R.id.ocw);
        if (findViewById != null) {
            this.commissionContainerController = new ECBaseViewController(requireContext(), (ECBasePtsView) findViewById);
            jj0.c cVar = this.transactionModel;
            if (cVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("transactionModel");
            }
            this.commissionPtsViewData = new ECBasePtsViewData(null, "transaction_data_card", cVar.a(), null, 9, null);
            ECBaseViewController eCBaseViewController = this.commissionContainerController;
            if (eCBaseViewController == null) {
                Intrinsics.throwUninitializedPropertyAccessException("commissionContainerController");
            }
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("allInOneJump", vi(rootView)), TuplesKt.to("orderTimeOptionClick", vi(rootView)), TuplesKt.to("orderChannelOptionClick", vi(rootView)), TuplesKt.to("historyTimeOptionClick", vi(rootView)), TuplesKt.to("historyDataOptionClick", vi(rootView)));
            eCBaseViewController.i(mapOf);
            ECBaseViewController eCBaseViewController2 = this.commissionContainerController;
            if (eCBaseViewController2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("commissionContainerController");
            }
            Context requireContext = requireContext();
            ECBasePtsViewData eCBasePtsViewData = this.commissionPtsViewData;
            if (eCBasePtsViewData == null) {
                Intrinsics.throwUninitializedPropertyAccessException("commissionPtsViewData");
            }
            eCBaseViewController2.h(requireContext, eCBasePtsViewData);
            jj0.b bVar = this.historyCurveViewModel;
            if (bVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("historyCurveViewModel");
            }
            ArrayList<String> e16 = bVar.e();
            jj0.b bVar2 = this.historyCurveViewModel;
            if (bVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("historyCurveViewModel");
            }
            Ai(e16, bVar2.f(), rootView, true);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.tencent.ecommerce.base.ui.ECBasePtsView");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String oi(String commissionJsonStr, JSONArray saasInfoJsonArray) {
        if (commissionJsonStr == null || commissionJsonStr.length() == 0) {
            return "";
        }
        JSONObject jSONObject = new JSONObject(commissionJsonStr);
        JSONArray optJSONArray = jSONObject.optJSONArray("order_channel_filter_list");
        if (optJSONArray == null) {
            return commissionJsonStr;
        }
        int length = saasInfoJsonArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject optJSONObject = saasInfoJsonArray.optJSONObject(i3);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("key", optJSONObject.optString("type_str"));
            jSONObject2.put("title", optJSONObject.optString("type_name"));
            jSONObject2.put("typeNum", optJSONObject.optInt("type_num"));
            jSONObject2.put("selected", false);
            optJSONArray.mo162put(jSONObject2);
        }
        return jSONObject.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JSONObject si(String commissionJsonStr, String filterListName) {
        JSONArray optJSONArray;
        if (!(commissionJsonStr == null || commissionJsonStr.length() == 0) && (optJSONArray = new JSONObject(commissionJsonStr).optJSONArray(filterListName)) != null) {
            int length = optJSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                if (optJSONObject.optBoolean("selected")) {
                    return optJSONObject;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Di(String identifier, JSONArray filterList) {
        if ((identifier == null || identifier.length() == 0) || filterList == null || !wi(identifier, filterList) || Intrinsics.areEqual(identifier, "order_time_diy")) {
            return;
        }
        int length = filterList.length();
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject optJSONObject = filterList.optJSONObject(i3);
            if (Intrinsics.areEqual(optJSONObject.optString("key"), identifier)) {
                optJSONObject.put("selected", true);
            } else {
                optJSONObject.put("selected", false);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/ecommerce/biz/transactiondata/ECTransactionDataFragment$b", "Lcom/tencent/ecommerce/biz/datepicker/ECCustomDatePicker$Callback;", "", "startTimeMillis", "endTimeMillis", "", "onConfirmTimeSelected", "onCancel", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b implements ECCustomDatePicker.Callback {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f104823b;

        b(String str) {
            this.f104823b = str;
        }

        @Override // com.tencent.ecommerce.biz.datepicker.ECCustomDatePicker.Callback
        public void onConfirmTimeSelected(long startTimeMillis, long endTimeMillis) {
            ECTransactionDataFragment.this.reqTimeWindow.clear();
            long j3 = 1000;
            ECTransactionDataFragment.this.reqTimeWindow.add(Long.valueOf(startTimeMillis / j3));
            ECTransactionDataFragment.this.reqTimeWindow.add(Long.valueOf(endTimeMillis / j3));
            ECTransactionDataFragment eCTransactionDataFragment = ECTransactionDataFragment.this;
            eCTransactionDataFragment.yi(this.f104823b, ECTransactionDataFragment.Nh(eCTransactionDataFragment), startTimeMillis, endTimeMillis);
            ECTransactionDataFragment eCTransactionDataFragment2 = ECTransactionDataFragment.this;
            eCTransactionDataFragment2.zi(((Number) eCTransactionDataFragment2.reqTimeWindow.get(0)).longValue(), ((Number) ECTransactionDataFragment.this.reqTimeWindow.get(1)).longValue());
        }

        @Override // com.tencent.ecommerce.biz.datepicker.ECCustomDatePicker.Callback
        public void onCancel() {
        }
    }
}
