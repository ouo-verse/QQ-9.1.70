package com.tencent.ecommerce.biz.common.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.ecommerce.base.ui.ECBasePtsView;
import com.tencent.ecommerce.base.ui.ECBasePtsViewData;
import com.tencent.ecommerce.base.ui.ECBaseViewController;
import com.tencent.ecommerce.base.ui.e;
import com.tencent.ecommerce.biz.common.ui.ECCommonFilterDialog;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebReport;
import com.tencent.pts.core.PTSComposer;
import com.tencent.pts.core.lite.IPTSLiteEventListener;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0003\u001b\u001c\u001dB/\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\b\b\u0003\u0010\u0018\u001a\u00020\u0017\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014R\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/ecommerce/biz/common/ui/ECCommonFilterDialog;", "Landroid/app/Dialog;", "", "Lcom/tencent/ecommerce/biz/common/ui/ECCommonFilterDialog$a;", "filterData", "", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Lcom/tencent/ecommerce/base/ui/ECBaseViewController;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/ecommerce/base/ui/ECBaseViewController;", "ptsController", "D", "Ljava/util/List;", "data", "Lcom/tencent/ecommerce/biz/common/ui/ECCommonFilterDialog$ClickActionHandler;", "E", "Lcom/tencent/ecommerce/biz/common/ui/ECCommonFilterDialog$ClickActionHandler;", "handler", "Landroid/content/Context;", "context", "", "themeId", "<init>", "(Landroid/content/Context;ILjava/util/List;Lcom/tencent/ecommerce/biz/common/ui/ECCommonFilterDialog$ClickActionHandler;)V", "ClickActionHandler", "a", "b", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECCommonFilterDialog extends ReportDialog {

    /* renamed from: C, reason: from kotlin metadata */
    private ECBaseViewController ptsController;

    /* renamed from: D, reason: from kotlin metadata */
    private final List<FilterItem> data;

    /* renamed from: E, reason: from kotlin metadata */
    private final ClickActionHandler handler;

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\"\u0010\u0007\u001a\u00020\u00052\u0018\u0010\u0006\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0004\u0012\u00020\u00050\u0002H&J\b\u0010\b\u001a\u00020\u0005H&J:\u0010\u000f\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0018\u0010\u0006\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0004\u0012\u00020\u00050\u0002H&\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/ecommerce/biz/common/ui/ECCommonFilterDialog$ClickActionHandler;", "", "Lkotlin/Function1;", "", "Lcom/tencent/ecommerce/biz/common/ui/ECCommonFilterDialog$a;", "", "refreshAction", "resetBtnClick", "confirmBtnClick", "Lcom/tencent/ecommerce/biz/common/ui/ECCommonFilterDialog;", "dialog", "", VasWebReport.WEB_CORE_DATA_FLAGS, "Lcom/tencent/ecommerce/biz/common/ui/ECCommonFilterDialog$b;", "optionData", "filterOptionBtnClick", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public interface ClickActionHandler {
        void confirmBtnClick();

        void filterOptionBtnClick(ECCommonFilterDialog dialog, String filterType, FilterOptionItem optionData, Function1<? super List<FilterItem>, Unit> refreshAction);

        void resetBtnClick(Function1<? super List<FilterItem>, Unit> refreshAction);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\b\u0086\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\rB=\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\f\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0006\u0010\u0003\u001a\u00020\u0002JE\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u0006H\u00c6\u0001J\t\u0010\u000e\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\u000f\u001a\u00020\tH\u00d6\u0001J\u0013\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0012R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\b\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0014R\u0014\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u000b\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0014R\u0014\u0010\f\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0014\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/ecommerce/biz/common/ui/ECCommonFilterDialog$b;", "", "Lorg/json/JSONObject;", "c", "", "selected", "", "text", "value", "", "optionType", "start", "end", "a", "toString", "hashCode", "other", "equals", "Z", "b", "Ljava/lang/String;", "d", "I", "e", "f", "<init>", "(ZLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "g", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.common.ui.ECCommonFilterDialog$b, reason: from toString */
    /* loaded from: classes31.dex */
    public static final /* data */ class FilterOptionItem {

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final boolean selected;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final String text;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        public final String value;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        public final int optionType;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        public final String start;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        public final String end;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/ecommerce/biz/common/ui/ECCommonFilterDialog$b$a;", "", "Lorg/json/JSONObject;", "jsonObject", "Lcom/tencent/ecommerce/biz/common/ui/ECCommonFilterDialog$b;", "a", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
        /* renamed from: com.tencent.ecommerce.biz.common.ui.ECCommonFilterDialog$b$a, reason: from kotlin metadata */
        /* loaded from: classes31.dex */
        public static final class Companion {
            Companion() {
            }

            public final FilterOptionItem a(JSONObject jsonObject) {
                return new FilterOptionItem(jsonObject.optBoolean("selected"), jsonObject.optString("str"), jsonObject.optString("key"), jsonObject.optInt("option_type"), jsonObject.optString("start"), jsonObject.optString("end"));
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public FilterOptionItem(boolean z16, String str, String str2, int i3, String str3, String str4) {
            this.selected = z16;
            this.text = str;
            this.value = str2;
            this.optionType = i3;
            this.start = str3;
            this.end = str4;
        }

        public final FilterOptionItem a(boolean selected, String text, String value, int optionType, String start, String end) {
            return new FilterOptionItem(selected, text, value, optionType, start, end);
        }

        public final JSONObject c() {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("key", this.value);
            jSONObject.put("str", this.text);
            jSONObject.put("option_type", this.optionType);
            jSONObject.put("selected", this.selected);
            jSONObject.put("start", this.start);
            jSONObject.put("end", this.end);
            return jSONObject;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v12 */
        /* JADX WARN: Type inference failed for: r0v13 */
        public int hashCode() {
            boolean z16 = this.selected;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            int i3 = r06 * 31;
            String str = this.text;
            int hashCode = (i3 + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.value;
            int hashCode2 = (((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.optionType) * 31;
            String str3 = this.start;
            int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.end;
            return hashCode3 + (str4 != null ? str4.hashCode() : 0);
        }

        public String toString() {
            return "FilterOptionItem(selected=" + this.selected + ", text=" + this.text + ", value=" + this.value + ", optionType=" + this.optionType + ", start=" + this.start + ", end=" + this.end + ")";
        }

        public /* synthetic */ FilterOptionItem(boolean z16, String str, String str2, int i3, String str3, String str4, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this((i16 & 1) != 0 ? false : z16, str, str2, i3, (i16 & 16) != 0 ? "" : str3, (i16 & 32) != 0 ? "" : str4);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FilterOptionItem)) {
                return false;
            }
            FilterOptionItem filterOptionItem = (FilterOptionItem) other;
            return this.selected == filterOptionItem.selected && Intrinsics.areEqual(this.text, filterOptionItem.text) && Intrinsics.areEqual(this.value, filterOptionItem.value) && this.optionType == filterOptionItem.optionType && Intrinsics.areEqual(this.start, filterOptionItem.start) && Intrinsics.areEqual(this.end, filterOptionItem.end);
        }

        public static /* synthetic */ FilterOptionItem b(FilterOptionItem filterOptionItem, boolean z16, String str, String str2, int i3, String str3, String str4, int i16, Object obj) {
            if ((i16 & 1) != 0) {
                z16 = filterOptionItem.selected;
            }
            if ((i16 & 2) != 0) {
                str = filterOptionItem.text;
            }
            String str5 = str;
            if ((i16 & 4) != 0) {
                str2 = filterOptionItem.value;
            }
            String str6 = str2;
            if ((i16 & 8) != 0) {
                i3 = filterOptionItem.optionType;
            }
            int i17 = i3;
            if ((i16 & 16) != 0) {
                str3 = filterOptionItem.start;
            }
            String str7 = str3;
            if ((i16 & 32) != 0) {
                str4 = filterOptionItem.end;
            }
            return filterOptionItem.a(z16, str5, str6, i17, str7, str4);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J<\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\f\u00b8\u0006\u0000"}, d2 = {"com/tencent/ecommerce/biz/common/ui/ECCommonFilterDialog$onCreate$1$3", "Lcom/tencent/ecommerce/base/ui/e;", "", IECDtReport.ACTION_IDENTIFIER, "Ljava/util/HashMap;", "dataMap", "Landroid/view/View;", "view", "Lcom/tencent/pts/core/PTSComposer;", "ptsComposer", "", "onTapEventTriggered", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c extends e {
        c() {
        }

        @Override // com.tencent.pts.core.lite.IPTSLiteEventListener
        public void onTapEventTriggered(String identifier, HashMap<String, String> dataMap, View view, PTSComposer ptsComposer) {
            ECCommonFilterDialog.this.cancel();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J<\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\f\u00b8\u0006\u0000"}, d2 = {"com/tencent/ecommerce/biz/common/ui/ECCommonFilterDialog$onCreate$1$4", "Lcom/tencent/ecommerce/base/ui/e;", "", IECDtReport.ACTION_IDENTIFIER, "Ljava/util/HashMap;", "dataMap", "Landroid/view/View;", "view", "Lcom/tencent/pts/core/PTSComposer;", "ptsComposer", "", "onTapEventTriggered", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class d extends e {
        d() {
        }

        @Override // com.tencent.pts.core.lite.IPTSLiteEventListener
        public void onTapEventTriggered(String identifier, HashMap<String, String> dataMap, View view, PTSComposer ptsComposer) {
            ECCommonFilterDialog.this.handler.confirmBtnClick();
            ECCommonFilterDialog.this.dismiss();
            ECCommonFilterDialog.O(ECCommonFilterDialog.this).g();
        }
    }

    public /* synthetic */ ECCommonFilterDialog(Context context, int i3, List list, ClickActionHandler clickActionHandler, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? R.style.f173260z5 : i3, list, clickActionHandler);
    }

    public static final /* synthetic */ ECBaseViewController O(ECCommonFilterDialog eCCommonFilterDialog) {
        ECBaseViewController eCBaseViewController = eCCommonFilterDialog.ptsController;
        if (eCBaseViewController == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ptsController");
        }
        return eCBaseViewController;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q(List<FilterItem> filterData) {
        JSONObject jSONObject = new JSONObject();
        int i3 = 0;
        for (Object obj : filterData) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            jSONObject.put("filter_" + i3, ((FilterItem) obj).d());
            i3 = i16;
        }
        ECBaseViewController eCBaseViewController = this.ptsController;
        if (eCBaseViewController == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ptsController");
        }
        eCBaseViewController.h(getContext(), new ECBasePtsViewData(null, "common_filter_dialog", jSONObject.toString(), null, 9, null));
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle savedInstanceState) {
        Map<String, ? extends IPTSLiteEventListener> mapOf;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.f167336cr4);
        this.ptsController = new ECBaseViewController(getContext(), (ECBasePtsView) findViewById(R.id.o_p));
        ECBaseViewController eCBaseViewController = new ECBaseViewController(getContext(), (ECBasePtsView) findViewById(R.id.o_p));
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("resetBtnClick", new e() { // from class: com.tencent.ecommerce.biz.common.ui.ECCommonFilterDialog$onCreate$$inlined$apply$lambda$1
            @Override // com.tencent.pts.core.lite.IPTSLiteEventListener
            public void onTapEventTriggered(String identifier, HashMap<String, String> dataMap, View view, PTSComposer ptsComposer) {
                ECCommonFilterDialog.this.handler.resetBtnClick(new Function1<List<? extends ECCommonFilterDialog.FilterItem>, Unit>() { // from class: com.tencent.ecommerce.biz.common.ui.ECCommonFilterDialog$onCreate$$inlined$apply$lambda$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(List<? extends ECCommonFilterDialog.FilterItem> list) {
                        invoke2((List<ECCommonFilterDialog.FilterItem>) list);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(List<ECCommonFilterDialog.FilterItem> list) {
                        ECCommonFilterDialog.this.Q(list);
                    }
                });
            }
        }), TuplesKt.to("filterBtnClick", new e() { // from class: com.tencent.ecommerce.biz.common.ui.ECCommonFilterDialog$onCreate$$inlined$apply$lambda$2
            @Override // com.tencent.pts.core.lite.IPTSLiteEventListener
            public void onTapEventTriggered(String identifier, HashMap<String, String> dataMap, View view, PTSComposer ptsComposer) {
                String str;
                String str2;
                if (dataMap == null || (str = dataMap.get(VasWebReport.WEB_CORE_DATA_FLAGS)) == null || (str2 = dataMap.get("option")) == null) {
                    return;
                }
                ECCommonFilterDialog.this.handler.filterOptionBtnClick(ECCommonFilterDialog.this, str, ECCommonFilterDialog.FilterOptionItem.INSTANCE.a(new JSONObject(str2)), new Function1<List<? extends ECCommonFilterDialog.FilterItem>, Unit>() { // from class: com.tencent.ecommerce.biz.common.ui.ECCommonFilterDialog$onCreate$$inlined$apply$lambda$2.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(List<? extends ECCommonFilterDialog.FilterItem> list) {
                        invoke2((List<ECCommonFilterDialog.FilterItem>) list);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(List<ECCommonFilterDialog.FilterItem> list) {
                        ECCommonFilterDialog.this.Q(list);
                    }
                });
            }
        }), TuplesKt.to("closeBtnClick", new c()), TuplesKt.to("confirmBtnClick", new d()));
        eCBaseViewController.i(mapOf);
        Unit unit = Unit.INSTANCE;
        this.ptsController = eCBaseViewController;
        Q(this.data);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0006\u0010\u0003\u001a\u00020\u0002J-\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u00c6\u0001J\t\u0010\u000b\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\r\u001a\u00020\fH\u00d6\u0001J\u0013\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0011R\u0014\u0010\u0006\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/ecommerce/biz/common/ui/ECCommonFilterDialog$a;", "", "Lorg/json/JSONObject;", "d", "", "title", VasWebReport.WEB_CORE_DATA_FLAGS, "", "Lcom/tencent/ecommerce/biz/common/ui/ECCommonFilterDialog$b;", "optionList", "a", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "b", "c", "Ljava/util/List;", "()Ljava/util/List;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.common.ui.ECCommonFilterDialog$a, reason: from toString */
    /* loaded from: classes31.dex */
    public static final /* data */ class FilterItem {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final String title;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final String filterType;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final List<FilterOptionItem> optionList;

        public FilterItem(String str, String str2, List<FilterOptionItem> list) {
            this.title = str;
            this.filterType = str2;
            this.optionList = list;
        }

        public final FilterItem a(String title, String filterType, List<FilterOptionItem> optionList) {
            return new FilterItem(title, filterType, optionList);
        }

        public final List<FilterOptionItem> c() {
            return this.optionList;
        }

        public final JSONObject d() {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("title", this.title);
            jSONObject.put("filter_type", this.filterType);
            if (Intrinsics.areEqual(this.filterType, QCircleSchemeAttr.CoverFeed.SOURCE_TYPE)) {
                jSONObject.put("items_pre_line", 3);
            } else {
                jSONObject.put("max_items_pre_line", 4);
            }
            JSONArray jSONArray = new JSONArray();
            Iterator<T> it = this.optionList.iterator();
            while (it.hasNext()) {
                jSONArray.mo162put(((FilterOptionItem) it.next()).c());
            }
            jSONObject.put("options", jSONArray);
            return jSONObject;
        }

        public int hashCode() {
            String str = this.title;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.filterType;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            List<FilterOptionItem> list = this.optionList;
            return hashCode2 + (list != null ? list.hashCode() : 0);
        }

        public String toString() {
            return "FilterItem(title=" + this.title + ", filterType=" + this.filterType + ", optionList=" + this.optionList + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FilterItem)) {
                return false;
            }
            FilterItem filterItem = (FilterItem) other;
            return Intrinsics.areEqual(this.title, filterItem.title) && Intrinsics.areEqual(this.filterType, filterItem.filterType) && Intrinsics.areEqual(this.optionList, filterItem.optionList);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ FilterItem b(FilterItem filterItem, String str, String str2, List list, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = filterItem.title;
            }
            if ((i3 & 2) != 0) {
                str2 = filterItem.filterType;
            }
            if ((i3 & 4) != 0) {
                list = filterItem.optionList;
            }
            return filterItem.a(str, str2, list);
        }
    }

    public ECCommonFilterDialog(Context context, int i3, List<FilterItem> list, ClickActionHandler clickActionHandler) {
        super(context, i3);
        this.data = list;
        this.handler = clickActionHandler;
        Window window = getWindow();
        if (window != null) {
            window.setGravity(80);
            window.getDecorView().setPadding(0, 0, 0, 0);
            window.setWindowAnimations(R.style.f173268zd);
            WindowManager.LayoutParams attributes = window.getAttributes();
            if (attributes != null) {
                attributes.width = -1;
            }
            WindowManager.LayoutParams attributes2 = window.getAttributes();
            if (attributes2 != null) {
                attributes2.height = -2;
            }
        }
    }
}
