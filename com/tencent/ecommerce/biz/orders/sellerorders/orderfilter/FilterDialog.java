package com.tencent.ecommerce.biz.orders.sellerorders.orderfilter;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.ecommerce.base.ui.ECBasePtsView;
import com.tencent.ecommerce.base.ui.ECBasePtsViewData;
import com.tencent.ecommerce.base.ui.ECBaseViewController;
import com.tencent.ecommerce.biz.datepicker.ECCustomDatePicker;
import com.tencent.ecommerce.biz.orders.sellerorders.orderfilter.g;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebReport;
import com.tencent.pts.core.PTSComposer;
import com.tencent.pts.core.lite.IPTSLiteEventListener;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0081\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007*\u00018\u0018\u00002\u00020\u0001:\u0002IJBQ\u0012\u0006\u0010E\u001a\u00020D\u0012\u0006\u0010F\u001a\u00020\u0004\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u000e\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u000e\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u000e\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010C\u001a\u00020@\u00a2\u0006\u0004\bG\u0010HJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001c\u0010\n\u001a\u00020\u00022\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002JL\u0010\u0013\u001a\u00020\u0002\"\u0004\b\u0000\u0010\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u0010\u001a\u00020\u00042\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0018\u0010\u0012\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000e\u0012\u0004\u0012\u00020\u00020\u0007H\u0002J:\u0010\u001c\u001a\u00020\u001b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u000e2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u000e2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u000e2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002Ji\u0010$\u001a\u00020#\"\u0004\b\u0000\u0010\r*\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001b2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00042\f\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001b0\u0007H\u0002\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010(\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020&H\u0002J\f\u0010*\u001a\u00020#*\u00020)H\u0002J\u0012\u0010-\u001a\u00020\u00022\b\u0010,\u001a\u0004\u0018\u00010+H\u0014R$\u00103\u001a\u00020\u00192\u0006\u0010.\u001a\u00020\u00198\u0002@BX\u0082\u000e\u00a2\u0006\f\n\u0004\b/\u00100\"\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0014\u0010;\u001a\u0002088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b>\u0010=R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010=R\u0014\u0010C\u001a\u00020@8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010B\u00a8\u0006K"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/sellerorders/orderfilter/FilterDialog;", "Landroid/app/Dialog;", "", "g0", "", "index", "i0", "Lkotlin/Function1;", "Lcom/tencent/ecommerce/biz/orders/sellerorders/orderfilter/g;", "callback", "Z", "f0", "e0", "T", "", "list", "beUpdateIndex", "currentSelectedOption", "updater", "a0", "timeOptions", "Lcom/tencent/ecommerce/biz/orders/sellerorders/orderfilter/c;", "saasPlatforms", "Lcom/tencent/ecommerce/biz/orders/sellerorders/orderfilter/b;", "orderStatuses", "Lcom/tencent/ecommerce/biz/orders/sellerorders/orderfilter/a;", "selectedOptions", "", "X", "title", "type", "max_items_pre_line", "itemsPerLine", "selectedItems", "labelGenerator", "Lorg/json/JSONObject;", "c0", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Lkotlin/jvm/functions/Function1;)Lorg/json/JSONObject;", "", "timeMillis", "W", "Lcom/tencent/ecommerce/biz/orders/sellerorders/orderfilter/FilterDialog$a;", "b0", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "value", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/ecommerce/biz/orders/sellerorders/orderfilter/a;", "Y", "(Lcom/tencent/ecommerce/biz/orders/sellerorders/orderfilter/a;)V", "currentSelectedOptions", "Lcom/tencent/ecommerce/base/ui/ECBaseViewController;", "D", "Lcom/tencent/ecommerce/base/ui/ECBaseViewController;", "ptsController", "com/tencent/ecommerce/biz/orders/sellerorders/orderfilter/FilterDialog$b", "E", "Lcom/tencent/ecommerce/biz/orders/sellerorders/orderfilter/FilterDialog$b;", "filterBtnHandler", UserInfo.SEX_FEMALE, "Ljava/util/List;", "G", "H", "Lcom/tencent/ecommerce/biz/orders/sellerorders/orderfilter/FilterDialog$OnDismissListener;", "I", "Lcom/tencent/ecommerce/biz/orders/sellerorders/orderfilter/FilterDialog$OnDismissListener;", "onDismissListener", "Landroid/content/Context;", "context", "themeResId", "<init>", "(Landroid/content/Context;ILjava/util/List;Ljava/util/List;Ljava/util/List;Lcom/tencent/ecommerce/biz/orders/sellerorders/orderfilter/a;Lcom/tencent/ecommerce/biz/orders/sellerorders/orderfilter/FilterDialog$OnDismissListener;)V", "OnDismissListener", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class FilterDialog extends ReportDialog {

    /* renamed from: C, reason: from kotlin metadata */
    private FilterDialogSelectedOption currentSelectedOptions;

    /* renamed from: D, reason: from kotlin metadata */
    private ECBaseViewController ptsController;

    /* renamed from: E, reason: from kotlin metadata */
    private final b filterBtnHandler;

    /* renamed from: F, reason: from kotlin metadata */
    private final List<g> timeOptions;

    /* renamed from: G, reason: from kotlin metadata */
    private final List<com.tencent.ecommerce.biz.orders.sellerorders.orderfilter.c> saasPlatforms;

    /* renamed from: H, reason: from kotlin metadata */
    private final List<com.tencent.ecommerce.biz.orders.sellerorders.orderfilter.b> orderStatuses;

    /* renamed from: I, reason: from kotlin metadata */
    private final OnDismissListener onDismissListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/sellerorders/orderfilter/FilterDialog$OnDismissListener;", "", "Lcom/tencent/ecommerce/biz/orders/sellerorders/orderfilter/a;", "selectedOptions", "", "onDismiss", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public interface OnDismissListener {
        void onDismiss(FilterDialogSelectedOption selectedOptions);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J<\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\f\u00b8\u0006\u0000"}, d2 = {"com/tencent/ecommerce/biz/orders/sellerorders/orderfilter/FilterDialog$onCreate$1$1", "Lcom/tencent/ecommerce/base/ui/e;", "", IECDtReport.ACTION_IDENTIFIER, "Ljava/util/HashMap;", "dataMap", "Landroid/view/View;", "view", "Lcom/tencent/pts/core/PTSComposer;", "ptsComposer", "", "onTapEventTriggered", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c extends com.tencent.ecommerce.base.ui.e {
        c() {
        }

        @Override // com.tencent.pts.core.lite.IPTSLiteEventListener
        public void onTapEventTriggered(String identifier, HashMap<String, String> dataMap, View view, PTSComposer ptsComposer) {
            FilterDialog.this.Y(new FilterDialogSelectedOption(null, null, null, 7, null));
            FilterDialog.this.g0();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J<\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\f\u00b8\u0006\u0000"}, d2 = {"com/tencent/ecommerce/biz/orders/sellerorders/orderfilter/FilterDialog$onCreate$1$2", "Lcom/tencent/ecommerce/base/ui/e;", "", IECDtReport.ACTION_IDENTIFIER, "Ljava/util/HashMap;", "dataMap", "Landroid/view/View;", "view", "Lcom/tencent/pts/core/PTSComposer;", "ptsComposer", "", "onTapEventTriggered", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class d extends com.tencent.ecommerce.base.ui.e {
        d() {
        }

        @Override // com.tencent.pts.core.lite.IPTSLiteEventListener
        public void onTapEventTriggered(String identifier, HashMap<String, String> dataMap, View view, PTSComposer ptsComposer) {
            FilterDialog.this.cancel();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J<\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\f\u00b8\u0006\u0000"}, d2 = {"com/tencent/ecommerce/biz/orders/sellerorders/orderfilter/FilterDialog$onCreate$1$3", "Lcom/tencent/ecommerce/base/ui/e;", "", IECDtReport.ACTION_IDENTIFIER, "Ljava/util/HashMap;", "dataMap", "Landroid/view/View;", "view", "Lcom/tencent/pts/core/PTSComposer;", "ptsComposer", "", "onTapEventTriggered", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class e extends com.tencent.ecommerce.base.ui.e {
        e() {
        }

        @Override // com.tencent.pts.core.lite.IPTSLiteEventListener
        public void onTapEventTriggered(String identifier, HashMap<String, String> dataMap, View view, PTSComposer ptsComposer) {
            FilterDialog.this.onDismissListener.onDismiss(FilterDialog.this.currentSelectedOptions);
            FilterDialog.this.dismiss();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/ecommerce/biz/orders/sellerorders/orderfilter/FilterDialog$f", "Lcom/tencent/ecommerce/biz/datepicker/ECCustomDatePicker$Callback;", "", "startTimeMillis", "endTimeMillis", "", "onConfirmTimeSelected", "onCancel", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class f implements ECCustomDatePicker.Callback {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function1 f103849b;

        f(Function1 function1) {
            this.f103849b = function1;
        }

        @Override // com.tencent.ecommerce.biz.datepicker.ECCustomDatePicker.Callback
        public void onCancel() {
            FilterDialog.this.show();
        }

        @Override // com.tencent.ecommerce.biz.datepicker.ECCustomDatePicker.Callback
        public void onConfirmTimeSelected(long startTimeMillis, long endTimeMillis) {
            FilterDialog.this.show();
            long j3 = 1000;
            this.f103849b.invoke(new g.b(startTimeMillis / j3, endTimeMillis / j3));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FilterDialog(Context context, int i3, List<? extends g> list, List<com.tencent.ecommerce.biz.orders.sellerorders.orderfilter.c> list2, List<? extends com.tencent.ecommerce.biz.orders.sellerorders.orderfilter.b> list3, FilterDialogSelectedOption filterDialogSelectedOption, OnDismissListener onDismissListener) {
        super(context, i3);
        this.timeOptions = list;
        this.saasPlatforms = list2;
        this.orderStatuses = list3;
        this.onDismissListener = onDismissListener;
        this.currentSelectedOptions = filterDialogSelectedOption;
        this.filterBtnHandler = new b();
    }

    private final String W(long timeMillis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeMillis);
        StringBuilder sb5 = new StringBuilder();
        sb5.append(calendar.get(1));
        sb5.append('.');
        sb5.append(calendar.get(2) + 1);
        sb5.append('.');
        sb5.append(calendar.get(5));
        return sb5.toString();
    }

    private final String X(List<? extends g> timeOptions, List<com.tencent.ecommerce.biz.orders.sellerorders.orderfilter.c> saasPlatforms, List<? extends com.tencent.ecommerce.biz.orders.sellerorders.orderfilter.b> orderStatuses, FilterDialogSelectedOption selectedOptions) {
        List listOf;
        JSONObject jSONObject = new JSONObject();
        listOf = CollectionsKt__CollectionsJVMKt.listOf(selectedOptions.timeOption);
        jSONObject.put("filter_0", d0(this, timeOptions, "\u65f6\u95f4", "time", 4, null, listOf, new Function1<g, String>() { // from class: com.tencent.ecommerce.biz.orders.sellerorders.orderfilter.FilterDialog$getPtsJSON$1$1
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(g gVar) {
                return gVar.label;
            }
        }, 8, null));
        jSONObject.put("filter_1", d0(this, orderStatuses, "\u8ba2\u5355\u72b6\u6001", "order", null, 4, selectedOptions.c(), new Function1<com.tencent.ecommerce.biz.orders.sellerorders.orderfilter.b, String>() { // from class: com.tencent.ecommerce.biz.orders.sellerorders.orderfilter.FilterDialog$getPtsJSON$1$2
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(b bVar) {
                return bVar.showName;
            }
        }, 4, null));
        jSONObject.put("filter_2", d0(this, saasPlatforms, "\u5e73\u53f0", "platform", null, 3, selectedOptions.d(), new Function1<com.tencent.ecommerce.biz.orders.sellerorders.orderfilter.c, String>() { // from class: com.tencent.ecommerce.biz.orders.sellerorders.orderfilter.FilterDialog$getPtsJSON$1$3
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(c cVar) {
                return cVar.name;
            }
        }, 4, null));
        return jSONObject.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Y(FilterDialogSelectedOption filterDialogSelectedOption) {
        this.currentSelectedOptions = filterDialogSelectedOption;
        g0();
    }

    private final void Z(Function1<? super g, Unit> callback) {
        hide();
        ECCustomDatePicker eCCustomDatePicker = new ECCustomDatePicker(getContext(), new f(callback), 10L, System.currentTimeMillis(), true, null, 32, null);
        eCCustomDatePicker.o(false);
        eCCustomDatePicker.p(false);
        eCCustomDatePicker.n(false);
        eCCustomDatePicker.s(System.currentTimeMillis());
    }

    private final <T> void a0(List<? extends T> list, int beUpdateIndex, List<? extends T> currentSelectedOption, Function1<? super List<? extends T>, Unit> updater) {
        boolean z16;
        ArrayList arrayList;
        List plus;
        List listOf;
        T t16 = list.get(beUpdateIndex);
        Intrinsics.checkNotNull(t16);
        List<? extends T> list2 = currentSelectedOption;
        if (!(list2 instanceof Collection) || !list2.isEmpty()) {
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                if (Intrinsics.areEqual(it.next(), t16)) {
                    z16 = true;
                    break;
                }
            }
        }
        z16 = false;
        boolean z17 = !z16;
        if (z17 || currentSelectedOption.size() != 1) {
            if (beUpdateIndex == 0) {
                listOf = CollectionsKt__CollectionsJVMKt.listOf(t16);
                arrayList = listOf;
            } else if (z17) {
                plus = CollectionsKt___CollectionsKt.plus((Collection) ((Collection<? extends Object>) currentSelectedOption), (Object) t16);
                ArrayList arrayList2 = new ArrayList();
                for (T t17 : plus) {
                    Intrinsics.checkNotNull(list.get(0));
                    if (!Intrinsics.areEqual(r1, t17)) {
                        arrayList2.add(t17);
                    }
                }
                arrayList = arrayList2;
            } else {
                arrayList = new ArrayList();
                for (T t18 : list2) {
                    if (!Intrinsics.areEqual(t18, t16)) {
                        arrayList.add(t18);
                    }
                }
            }
            updater.invoke(arrayList);
        }
    }

    private final JSONObject b0(PtsSelectableItem ptsSelectableItem) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("key", ptsSelectableItem.key);
        jSONObject.put("str", ptsSelectableItem.label);
        jSONObject.put("selected", ptsSelectableItem.getSelected());
        jSONObject.put("option_type", ptsSelectableItem.optionType);
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e0(int index) {
        a0(this.orderStatuses, index, this.currentSelectedOptions.c(), new Function1<List<? extends com.tencent.ecommerce.biz.orders.sellerorders.orderfilter.b>, Unit>() { // from class: com.tencent.ecommerce.biz.orders.sellerorders.orderfilter.FilterDialog$updateOrderStatuses$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends b> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<? extends b> list) {
                FilterDialog filterDialog = FilterDialog.this;
                filterDialog.Y(FilterDialogSelectedOption.b(filterDialog.currentSelectedOptions, null, null, list, 3, null));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f0(int index) {
        a0(this.saasPlatforms, index, this.currentSelectedOptions.d(), new Function1<List<? extends com.tencent.ecommerce.biz.orders.sellerorders.orderfilter.c>, Unit>() { // from class: com.tencent.ecommerce.biz.orders.sellerorders.orderfilter.FilterDialog$updatePlatformsOptions$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends c> list) {
                invoke2((List<c>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<c> list) {
                FilterDialog filterDialog = FilterDialog.this;
                filterDialog.Y(FilterDialogSelectedOption.b(filterDialog.currentSelectedOptions, null, list, null, 5, null));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g0() {
        ECBaseViewController eCBaseViewController = this.ptsController;
        if (eCBaseViewController == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ptsController");
        }
        eCBaseViewController.h(getContext(), new ECBasePtsViewData(null, "common_filter_dialog", X(this.timeOptions, this.saasPlatforms, this.orderStatuses, this.currentSelectedOptions), null, 9, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i0(int index) {
        if (index == this.timeOptions.size() - 1) {
            Z(new Function1<g, Unit>() { // from class: com.tencent.ecommerce.biz.orders.sellerorders.orderfilter.FilterDialog$updateTimeOption$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(g gVar) {
                    invoke2(gVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(g gVar) {
                    FilterDialog filterDialog = FilterDialog.this;
                    filterDialog.Y(FilterDialogSelectedOption.b(filterDialog.currentSelectedOptions, gVar, null, null, 6, null));
                }
            });
        } else {
            Y(FilterDialogSelectedOption.b(this.currentSelectedOptions, this.timeOptions.get(index), null, null, 6, null));
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle savedInstanceState) {
        Map<String, ? extends IPTSLiteEventListener> mapOf;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.f167336cr4);
        ECBaseViewController eCBaseViewController = new ECBaseViewController(getContext(), (ECBasePtsView) findViewById(R.id.o_p));
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("resetBtnClick", new c()), TuplesKt.to("filterBtnClick", this.filterBtnHandler), TuplesKt.to("closeBtnClick", new d()), TuplesKt.to("confirmBtnClick", new e()));
        eCBaseViewController.i(mapOf);
        Unit unit = Unit.INSTANCE;
        this.ptsController = eCBaseViewController;
        g0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0082\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u000b\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\"\u0010\u0014\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\t\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\r\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/sellerorders/orderfilter/FilterDialog$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "key", "b", "Ljava/lang/String;", "label", "c", "Z", "()Z", "setSelected", "(Z)V", "selected", "d", "optionType", "<init>", "(ILjava/lang/String;ZLjava/lang/String;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.orders.sellerorders.orderfilter.FilterDialog$a, reason: from toString */
    /* loaded from: classes31.dex */
    public static final /* data */ class PtsSelectableItem {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final int key;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final String label;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private boolean selected;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        public final String optionType;

        public PtsSelectableItem(int i3, String str, boolean z16, String str2) {
            this.key = i3;
            this.label = str;
            this.selected = z16;
            this.optionType = str2;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getSelected() {
            return this.selected;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int i3 = this.key * 31;
            String str = this.label;
            int hashCode = (i3 + (str != null ? str.hashCode() : 0)) * 31;
            boolean z16 = this.selected;
            int i16 = z16;
            if (z16 != 0) {
                i16 = 1;
            }
            int i17 = (hashCode + i16) * 31;
            String str2 = this.optionType;
            return i17 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "PtsSelectableItem(key=" + this.key + ", label=" + this.label + ", selected=" + this.selected + ", optionType=" + this.optionType + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PtsSelectableItem)) {
                return false;
            }
            PtsSelectableItem ptsSelectableItem = (PtsSelectableItem) other;
            return this.key == ptsSelectableItem.key && Intrinsics.areEqual(this.label, ptsSelectableItem.label) && this.selected == ptsSelectableItem.selected && Intrinsics.areEqual(this.optionType, ptsSelectableItem.optionType);
        }
    }

    private final <T> JSONObject c0(List<? extends T> list, String str, String str2, Integer num, Integer num2, List<? extends T> list2, Function1<? super T, String> function1) {
        boolean z16;
        String str3;
        Object firstOrNull;
        JSONArray jSONArray = new JSONArray();
        int i3 = 0;
        for (T t16 : list) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            String invoke = function1.invoke(t16);
            List<? extends T> list3 = list2;
            if (!(list3 instanceof Collection) || !list3.isEmpty()) {
                for (T t17 : list3) {
                    z16 = true;
                    if (Intrinsics.areEqual(t17, t16) || ((t17 instanceof g.b) && (t16 instanceof g.b))) {
                        break;
                    }
                }
            }
            z16 = false;
            boolean z17 = t16 instanceof g.b;
            if (z17) {
                str3 = "1";
            } else {
                str3 = "0";
            }
            JSONObject b06 = b0(new PtsSelectableItem(i3, invoke, z16, str3));
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list2);
            if (z17 && (firstOrNull instanceof g.b)) {
                Pair<Long, Long> b16 = com.tencent.ecommerce.biz.orders.sellerorders.orderfilter.e.b((g) firstOrNull);
                long longValue = b16.component1().longValue();
                long longValue2 = b16.component2().longValue();
                long j3 = 1000;
                b06.put("start", W(longValue * j3));
                b06.put("end", W(longValue2 * j3));
            }
            jSONArray.mo162put(b06);
            i3 = i16;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("title", str);
        jSONObject.put("filter_type", str2);
        if (num2 != null) {
            jSONObject.put("items_pre_line", num2.intValue());
        }
        if (num != null) {
            jSONObject.put("max_items_pre_line", num.intValue());
        }
        jSONObject.put("options", jSONArray);
        return jSONObject;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J<\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/ecommerce/biz/orders/sellerorders/orderfilter/FilterDialog$b", "Lcom/tencent/ecommerce/base/ui/e;", "", IECDtReport.ACTION_IDENTIFIER, "Ljava/util/HashMap;", "dataMap", "Landroid/view/View;", "view", "Lcom/tencent/pts/core/PTSComposer;", "ptsComposer", "", "onTapEventTriggered", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b extends com.tencent.ecommerce.base.ui.e {
        b() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:5:0x000f, code lost:
        
            r1 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r1);
         */
        @Override // com.tencent.pts.core.lite.IPTSLiteEventListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onTapEventTriggered(String identifier, HashMap<String, String> dataMap, View view, PTSComposer ptsComposer) {
            String str;
            Integer intOrNull;
            if (identifier == null || dataMap == null || (str = dataMap.get(VasWebReport.WEB_CORE_DATA_FLAGS)) == null || intOrNull == null) {
                return;
            }
            int intValue = intOrNull.intValue();
            int hashCode = str.hashCode();
            if (hashCode == 3560141) {
                if (str.equals("time")) {
                    FilterDialog.this.i0(intValue);
                }
            } else {
                if (hashCode != 106006350) {
                    if (hashCode == 1874684019 && str.equals("platform")) {
                        FilterDialog.this.f0(intValue);
                        return;
                    }
                    return;
                }
                if (str.equals("order")) {
                    FilterDialog.this.e0(intValue);
                }
            }
        }
    }

    static /* synthetic */ JSONObject d0(FilterDialog filterDialog, List list, String str, String str2, Integer num, Integer num2, List list2, Function1 function1, int i3, Object obj) {
        return filterDialog.c0(list, str, str2, (i3 & 4) != 0 ? null : num, (i3 & 8) != 0 ? null : num2, list2, function1);
    }
}
