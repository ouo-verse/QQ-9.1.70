package com.tencent.ecommerce.biz.showwindow.editor.ui.view;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.ecommerce.base.config.service.ECLocalConfig;
import com.tencent.ecommerce.base.fragment.ECBaseFragment;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.ecommerce.base.router.api.IECRouterLauncher;
import com.tencent.ecommerce.base.router.api.IECSchemeCallback;
import com.tencent.ecommerce.base.ui.ECBasePtsView;
import com.tencent.ecommerce.base.ui.ECBasePtsViewData;
import com.tencent.ecommerce.base.ui.ECBaseViewController;
import com.tencent.ecommerce.base.ui.ECSkin;
import com.tencent.ecommerce.base.ui.api.ECToastIcon;
import com.tencent.ecommerce.base.ui.api.IECCoreSkinApi;
import com.tencent.ecommerce.biz.showwindow.editor.ui.ECProductCardEditorViewModel;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.pts.core.PTSComposer;
import com.tencent.pts.core.lite.IPTSLiteEventListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import com.tencent.qqmini.sdk.plugins.SensorJsPlugin;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.Constants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0019\u0018\u0000 g2\u00020\u0001:\u0001hB\u0007\u00a2\u0006\u0004\be\u0010fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\bH\u0016J\"\u0010\u0012\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0002H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0016\u001a\u00020\bH\u0002J\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0004H\u0002J\u001a\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u00142\b\b\u0002\u0010\u001a\u001a\u00020\nH\u0002J\b\u0010\u001c\u001a\u00020\bH\u0002J\u0010\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\b\u0010 \u001a\u00020\bH\u0002J\b\u0010\"\u001a\u00020!H\u0002J\b\u0010#\u001a\u00020\bH\u0002J\b\u0010$\u001a\u00020\bH\u0002J\b\u0010%\u001a\u00020\bH\u0002J\u0010\u0010'\u001a\u00020\b2\u0006\u0010&\u001a\u00020\nH\u0002J\b\u0010(\u001a\u00020\bH\u0002J\u0010\u0010*\u001a\u00020\b2\u0006\u0010)\u001a\u00020\u0014H\u0002J\b\u0010+\u001a\u00020\u001dH\u0002J(\u00101\u001a\u00020\b2\u0006\u0010,\u001a\u00020\u00142\u0006\u0010-\u001a\u00020\u00142\u0006\u0010.\u001a\u00020\u00142\u0006\u00100\u001a\u00020/H\u0002J\u0010\u00103\u001a\u00020\n2\u0006\u00102\u001a\u00020/H\u0002R\u001b\u00109\u001a\u0002048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010A\u001a\u00020>8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010E\u001a\u00020B8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010G\u001a\u00020B8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bF\u0010DR\u0016\u0010K\u001a\u00020H8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010O\u001a\u00020L8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010S\u001a\u00020P8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010V\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010,\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010UR\u0016\u0010Y\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010UR\u0016\u0010[\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010UR\u0016\u0010]\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010UR\u0016\u0010`\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010_R\u0016\u0010b\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\ba\u0010_R\u0016\u0010d\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bc\u0010_\u00a8\u0006i"}, d2 = {"Lcom/tencent/ecommerce/biz/showwindow/editor/ui/view/ECProductCardEditorFragment;", "Lcom/tencent/ecommerce/base/fragment/ECBaseFragment;", "", "uh", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "Dh", "Eh", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "getContentLayoutId", "", "getBusinessDescription", "initArguments", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "initViews", "text", "needToast", WidgetCacheLunarData.JI, "oi", "Lorg/json/JSONObject;", "resultJson", "qi", "ri", "Lcom/tencent/pts/core/lite/IPTSLiteEventListener;", "pi", "initData", "ti", "wi", "enable", SensorJsPlugin.SENSOR_INTERVAL_UI, "si", "msg", "toast", "mi", "productId", "productTitle", "productMainPic", "", PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY, "vi", "localTimeStamp", "li", "Lcom/tencent/ecommerce/biz/showwindow/editor/ui/ECProductCardEditorViewModel;", "P", "Lkotlin/Lazy;", "ni", "()Lcom/tencent/ecommerce/biz/showwindow/editor/ui/ECProductCardEditorViewModel;", "viewModel", "Landroid/widget/LinearLayout;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/widget/LinearLayout;", "previewButton", "Landroid/widget/EditText;", BdhLogUtil.LogTag.Tag_Req, "Landroid/widget/EditText;", "editTextView", "Landroid/widget/ImageView;", ExifInterface.LATITUDE_SOUTH, "Landroid/widget/ImageView;", "backButton", "T", "editTitleIcon", "Landroid/widget/Button;", "U", "Landroid/widget/Button;", "saveButton", "Lcom/tencent/ecommerce/base/ui/ECBasePtsView;", "V", "Lcom/tencent/ecommerce/base/ui/ECBasePtsView;", "baseView", "Lcom/tencent/ecommerce/base/ui/ECBaseViewController;", "W", "Lcom/tencent/ecommerce/base/ui/ECBaseViewController;", "productCardController", "X", "Ljava/lang/String;", "spuId", "Y", "Z", "productName", "a0", "goodsType", "b0", "selectedUrl", "c0", "Lorg/json/JSONObject;", "productInfoToPTS", "d0", "productInfoToPublisher", "e0", "localCacheShowData", "<init>", "()V", "f0", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECProductCardEditorFragment extends ECBaseFragment {

    /* renamed from: P, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* renamed from: Q, reason: from kotlin metadata */
    private LinearLayout previewButton;

    /* renamed from: R, reason: from kotlin metadata */
    private EditText editTextView;

    /* renamed from: S, reason: from kotlin metadata */
    private ImageView backButton;

    /* renamed from: T, reason: from kotlin metadata */
    private ImageView editTitleIcon;

    /* renamed from: U, reason: from kotlin metadata */
    private Button saveButton;

    /* renamed from: V, reason: from kotlin metadata */
    private ECBasePtsView baseView;

    /* renamed from: W, reason: from kotlin metadata */
    private ECBaseViewController productCardController;

    /* renamed from: X, reason: from kotlin metadata */
    private String spuId;

    /* renamed from: Y, reason: from kotlin metadata */
    private String productId;

    /* renamed from: Z, reason: from kotlin metadata */
    private String productName;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private String goodsType;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private String selectedUrl;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private JSONObject productInfoToPTS;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private JSONObject productInfoToPublisher;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private JSONObject localCacheShowData;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"<anonymous>", "", "T", "t", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Object;)V", "androidx/lifecycle/LiveDataKt$observe$wrappedObserver$1"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b<T> implements Observer<T> {
        public b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.Observer
        public final void onChanged(T t16) {
            if (((Boolean) t16).booleanValue()) {
                return;
            }
            ECProductCardEditorFragment.this.wi();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"<anonymous>", "", "T", "t", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Object;)V", "androidx/lifecycle/LiveDataKt$observe$wrappedObserver$1"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c<T> implements Observer<T> {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f104453e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ long f104454f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f104455h;

        public c(String str, long j3, String str2) {
            this.f104453e = str;
            this.f104454f = j3;
            this.f104455h = str2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.Observer
        public final void onChanged(T t16) {
            String str;
            Map<String, ? extends IPTSLiteEventListener> mapOf;
            JSONObject jSONObject = (JSONObject) t16;
            JSONObject a16 = com.tencent.ecommerce.biz.showwindow.editor.ui.a.a(jSONObject);
            JSONArray b16 = a16 != null ? com.tencent.ecommerce.biz.showwindow.editor.ui.a.b(a16) : null;
            ECProductCardEditorFragment eCProductCardEditorFragment = ECProductCardEditorFragment.this;
            JSONObject a17 = com.tencent.ecommerce.biz.showwindow.editor.ui.a.a(jSONObject);
            if (a17 == null || (str = com.tencent.ecommerce.biz.showwindow.editor.ui.a.c(a17)) == null) {
                str = "";
            }
            eCProductCardEditorFragment.productName = str;
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(ReportDataBuilder.KEY_PRODUCT_ID, ECProductCardEditorFragment.this.spuId);
            jSONObject2.put("product_name", ECProductCardEditorFragment.this.productName);
            jSONObject2.put("goods_type", ECProductCardEditorFragment.this.goodsType);
            com.tencent.ecommerce.biz.showwindow.editor.ui.view.b.f104479a.a("goods_card_edit_page_exp", jSONObject2);
            if (ECProductCardEditorFragment.this.li(this.f104454f) && Intrinsics.areEqual(ECProductCardEditorFragment.this.spuId, this.f104453e)) {
                if (this.f104455h.length() > 0) {
                    cg0.a.b("ECProductCardEditorFragment", "\u5982\u679c\u672c\u5730\u6709URL\u6570\u636e\u800c\u4e14\u572810\u79d2\u4ee5\u5185 \u5c55\u793a\u56fe\u7247URL\uff1a" + this.f104455h);
                    jSONObject.put("cover_img", this.f104455h);
                    com.tencent.ecommerce.biz.util.i iVar = com.tencent.ecommerce.biz.util.i.f104869a;
                    jSONObject.put("price_yuan", iVar.d(jSONObject.optLong("price")));
                    jSONObject.put("commission_yuan", iVar.d(jSONObject.optLong("commission")));
                    ECProductCardEditorFragment.this.productInfoToPTS = jSONObject;
                    ECBasePtsViewData eCBasePtsViewData = new ECBasePtsViewData(null, "modify_page_card", ECProductCardEditorFragment.this.productInfoToPTS.toString(), null, 9, null);
                    ECProductCardEditorFragment.this.productCardController = new ECBaseViewController(ECProductCardEditorFragment.this.requireContext(), ECProductCardEditorFragment.Mh(ECProductCardEditorFragment.this));
                    ECProductCardEditorFragment.Qh(ECProductCardEditorFragment.this).h(ECProductCardEditorFragment.this.requireContext(), eCBasePtsViewData);
                    ECBaseViewController Qh = ECProductCardEditorFragment.Qh(ECProductCardEditorFragment.this);
                    mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("pickProductCoverImg", ECProductCardEditorFragment.this.pi()));
                    Qh.i(mapOf);
                }
            }
            if (b16 != null && b16.length() >= 1) {
                Object obj = b16.get(0);
                cg0.a.b("ECProductCardEditorFragment", "\u5982\u679c\u672c\u5730\u6ca1\u6709URL\u6570\u636e \u5c55\u793a\u7f51\u7edc\u56fe\u7247\u7684\u7b2c\u4e00\u5f20\uff1a" + obj);
                jSONObject.put("cover_img", obj);
            }
            com.tencent.ecommerce.biz.util.i iVar2 = com.tencent.ecommerce.biz.util.i.f104869a;
            jSONObject.put("price_yuan", iVar2.d(jSONObject.optLong("price")));
            jSONObject.put("commission_yuan", iVar2.d(jSONObject.optLong("commission")));
            ECProductCardEditorFragment.this.productInfoToPTS = jSONObject;
            ECBasePtsViewData eCBasePtsViewData2 = new ECBasePtsViewData(null, "modify_page_card", ECProductCardEditorFragment.this.productInfoToPTS.toString(), null, 9, null);
            ECProductCardEditorFragment.this.productCardController = new ECBaseViewController(ECProductCardEditorFragment.this.requireContext(), ECProductCardEditorFragment.Mh(ECProductCardEditorFragment.this));
            ECProductCardEditorFragment.Qh(ECProductCardEditorFragment.this).h(ECProductCardEditorFragment.this.requireContext(), eCBasePtsViewData2);
            ECBaseViewController Qh2 = ECProductCardEditorFragment.Qh(ECProductCardEditorFragment.this);
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("pickProductCoverImg", ECProductCardEditorFragment.this.pi()));
            Qh2.i(mapOf);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECProductCardEditorFragment eCProductCardEditorFragment = ECProductCardEditorFragment.this;
            eCProductCardEditorFragment.vi(eCProductCardEditorFragment.spuId, ECProductCardEditorFragment.this.productName, ECProductCardEditorFragment.this.selectedUrl, System.currentTimeMillis());
            ECProductCardEditorFragment.this.requireActivity().finish();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            boolean isBlank;
            EventCollector.getInstance().onViewClickedBefore(view);
            ECProductCardEditorFragment eCProductCardEditorFragment = ECProductCardEditorFragment.this;
            boolean ki5 = ECProductCardEditorFragment.ki(eCProductCardEditorFragment, ECProductCardEditorFragment.Nh(eCProductCardEditorFragment).getText().toString(), false, 2, null);
            if (ki5) {
                ECProductCardEditorFragment eCProductCardEditorFragment2 = ECProductCardEditorFragment.this;
                String obj = ECProductCardEditorFragment.Nh(eCProductCardEditorFragment2).getText().toString();
                isBlank = StringsKt__StringsJVMKt.isBlank(obj);
                if (isBlank) {
                    obj = ECProductCardEditorFragment.this.ni().W1();
                }
                eCProductCardEditorFragment2.productName = obj;
                ECProductCardEditorFragment.this.ui(ki5);
                ECProductCardEditorFragment.this.productInfoToPublisher.put("promotion_task_id", ECProductCardEditorFragment.this.productId);
                ECProductCardEditorFragment.this.productInfoToPublisher.put("promotion_task_name", ECProductCardEditorFragment.this.productName);
                ECProductCardEditorFragment.this.productInfoToPublisher.put("promotion_cover_url", ECProductCardEditorFragment.this.selectedUrl);
                if (ECProductCardEditorFragment.this.productInfoToPublisher.length() > 0) {
                    cg0.a.b("ECProductCardEditorFragment", "\u4fdd\u5b58\u4fe1\u606f: json=" + ECProductCardEditorFragment.this.productInfoToPublisher);
                    ECProductCardEditorFragment eCProductCardEditorFragment3 = ECProductCardEditorFragment.this;
                    eCProductCardEditorFragment3.vi(eCProductCardEditorFragment3.spuId, ECProductCardEditorFragment.this.productName, ECProductCardEditorFragment.this.selectedUrl, System.currentTimeMillis());
                    ECProductCardEditorFragment.this.si();
                    ECProductCardEditorFragment eCProductCardEditorFragment4 = ECProductCardEditorFragment.this;
                    eCProductCardEditorFragment4.qi(eCProductCardEditorFragment4.productInfoToPublisher);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            cg0.a.b("ECProductCardEditorFragment", "[clickItem] ");
            com.tencent.ecommerce.biz.showwindow.editor.ui.view.b.f104479a.c("goods_card_example_clk", new JSONObject());
            Bundle bundle = new Bundle();
            bundle.putString("is_trans_activity", "1");
            IECRouterLauncher a16 = xi0.a.INSTANCE.a();
            ECProductCardEditorFragment.this.startActivityForResult(a16 != null ? a16.getIntent(ECProductCardEditorFragment.this.requireContext(), ECProductCardEditorPreviewFragment.class, bundle) : null, 0);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002#\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001j\u0002`\u0007J\u0013\u0010\b\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0096\u0002\u00a8\u0006\t"}, d2 = {"com/tencent/ecommerce/biz/showwindow/editor/ui/view/ECProductCardEditorFragment$j", "Lkotlin/Function1;", "Landroid/graphics/drawable/Drawable;", "Lkotlin/ParameterName;", "name", "drawable", "", "Lcom/tencent/ecommerce/base/imageloader/api/Callback;", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class j implements Function1<Drawable, Unit> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ImageView f104462d;

        j(ImageView imageView) {
            this.f104462d = imageView;
        }

        public void a(Drawable drawable) {
            this.f104462d.setImageDrawable(drawable);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Drawable drawable) {
            a(drawable);
            return Unit.INSTANCE;
        }
    }

    public ECProductCardEditorFragment() {
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.tencent.ecommerce.biz.showwindow.editor.ui.view.ECProductCardEditorFragment$$special$$inlined$viewModels$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ECProductCardEditorViewModel.class), new Function0<ViewModelStore>() { // from class: com.tencent.ecommerce.biz.showwindow.editor.ui.view.ECProductCardEditorFragment$$special$$inlined$viewModels$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) Function0.this.invoke()).get_viewModelStore();
                Intrinsics.checkExpressionValueIsNotNull(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, null);
        this.spuId = "";
        this.productId = "";
        this.productName = "";
        this.goodsType = "";
        this.selectedUrl = "";
        this.productInfoToPTS = new JSONObject();
        this.productInfoToPublisher = new JSONObject();
        this.localCacheShowData = new JSONObject();
    }

    public static final /* synthetic */ ECBasePtsView Mh(ECProductCardEditorFragment eCProductCardEditorFragment) {
        ECBasePtsView eCBasePtsView = eCProductCardEditorFragment.baseView;
        if (eCBasePtsView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseView");
        }
        return eCBasePtsView;
    }

    public static final /* synthetic */ EditText Nh(ECProductCardEditorFragment eCProductCardEditorFragment) {
        EditText editText = eCProductCardEditorFragment.editTextView;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editTextView");
        }
        return editText;
    }

    public static final /* synthetic */ ImageView Oh(ECProductCardEditorFragment eCProductCardEditorFragment) {
        ImageView imageView = eCProductCardEditorFragment.editTitleIcon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editTitleIcon");
        }
        return imageView;
    }

    public static final /* synthetic */ ECBaseViewController Qh(ECProductCardEditorFragment eCProductCardEditorFragment) {
        ECBaseViewController eCBaseViewController = eCProductCardEditorFragment.productCardController;
        if (eCBaseViewController == null) {
            Intrinsics.throwUninitializedPropertyAccessException("productCardController");
        }
        return eCBaseViewController;
    }

    public static final /* synthetic */ Button Vh(ECProductCardEditorFragment eCProductCardEditorFragment) {
        Button button = eCProductCardEditorFragment.saveButton;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("saveButton");
        }
        return button;
    }

    private final void initArguments() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString("saas_product_id");
            if (string == null) {
                string = "";
            }
            this.spuId = string;
            String string2 = arguments.getString(ReportDataBuilder.KEY_PRODUCT_ID);
            if (string2 == null) {
                string2 = "";
            }
            this.productId = string2;
            String string3 = arguments.getString("goods_type");
            this.goodsType = string3 != null ? string3 : "";
        }
    }

    private final void initData() {
        JSONObject mi5 = mi();
        this.localCacheShowData = mi5;
        String optString = mi5.optString("product_name");
        if (optString == null) {
            optString = "";
        }
        String optString2 = this.localCacheShowData.optString("product_main_pic_url");
        String str = optString2 != null ? optString2 : "";
        long optLong = this.localCacheShowData.optLong("time_stamp");
        String optString3 = this.localCacheShowData.optString(ReportDataBuilder.KEY_PRODUCT_ID);
        if ((optString.length() > 0) && li(optLong) && Intrinsics.areEqual(this.spuId, optString3)) {
            EditText editText = this.editTextView;
            if (editText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("editTextView");
            }
            editText.setText(optString);
            ji(optString, false);
            cg0.a.b("ECProductCardEditorFragment", "\u5982\u679c\u672c\u5730\u5b58\u4e86\u7f16\u8f91\u8fc7\u7684\u5546\u54c1\u6570\u636e\uff0c\u800c\u4e14" + System.currentTimeMillis() + "\u5728\u5341\u5206\u949f\u4e4b\u5185 \u5c55\u793a\u6807\u9898\uff1a" + optString);
        }
        ti();
        ni().P1().observe(getViewLifecycleOwner(), new b());
        ni().R1().observe(getViewLifecycleOwner(), new c(optString3, optLong, str));
    }

    private final boolean ji(String text, boolean needToast) {
        if (text.length() < 4) {
            if (needToast) {
                toast("\u6807\u9898\u6700\u5c11\u8f93\u51654\u4e2a\u5b57");
            }
            ui(false);
            return false;
        }
        if (text.length() > 12) {
            if (needToast) {
                toast("\u8bf7\u9650\u5236\u572812\u4e2a\u5b57\u4ee5\u5185");
            }
            ui(false);
            return false;
        }
        int length = text.length() - 1;
        for (int i3 = 0; i3 < length; i3++) {
            int type = Character.getType(text.charAt(i3));
            if (type == 19 || type == 28) {
                if (needToast) {
                    toast("\u4ec5\u652f\u6301\u4e2d\u82f1\u6587\u3001\u6807\u70b9\u3001\u6570\u5b57");
                }
                ui(false);
                return false;
            }
        }
        if (!Pattern.compile("[\\p{P}\\p{Z}\\p{N}\\p{L}\\p{M}]+$").matcher(text).matches()) {
            if (needToast) {
                toast("\u4ec5\u652f\u6301\u4e2d\u82f1\u6587\u3001\u6807\u70b9\u3001\u6570\u5b57");
            }
            ui(false);
            return false;
        }
        ui(true);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean li(long localTimeStamp) {
        return System.currentTimeMillis() - localTimeStamp <= ((long) 600000);
    }

    private final JSONObject mi() {
        String string = ECLocalConfig.f100650f.getString("product_json_data_sp_key", "", Boolean.TRUE);
        if (!Intrinsics.areEqual(string, "")) {
            try {
                return new JSONObject(string);
            } catch (JSONException unused) {
                cg0.a.a("ECProductCardEditorFragment", "getCacheObjFromLocal()", "JSONString can not be converted to JSONObject");
            }
        }
        return new JSONObject();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ECProductCardEditorViewModel ni() {
        return (ECProductCardEditorViewModel) this.viewModel.getValue();
    }

    private final void oi() {
        pi();
        initData();
        ImageView imageView = this.backButton;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backButton");
        }
        imageView.setOnClickListener(new d());
        Button button = this.saveButton;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("saveButton");
        }
        button.setBackgroundResource(R.color.f6571x);
        ImageView imageView2 = this.editTitleIcon;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editTitleIcon");
        }
        imageView2.setVisibility(0);
        EditText editText = this.editTextView;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editTextView");
        }
        editText.setOnFocusChangeListener(new e());
        h hVar = new h();
        EditText editText2 = this.editTextView;
        if (editText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editTextView");
        }
        editText2.addTextChangedListener(hVar);
        Button button2 = this.saveButton;
        if (button2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("saveButton");
        }
        button2.setOnClickListener(new f());
        LinearLayout linearLayout = this.previewButton;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("previewButton");
        }
        linearLayout.setOnClickListener(new g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IPTSLiteEventListener pi() {
        return new i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void qi(JSONObject resultJson) {
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("scheme_callback_id") : null;
        if (string != null) {
            cg0.a.b("ECProductCardEditorFragment", "\u56de\u4f20\u7ed9\u53d1\u5e03\u5668 json=" + resultJson);
            IECSchemeCallback b16 = ug0.a.b(string);
            if (b16 != null) {
                b16.onCallbackFinished(resultJson);
            }
        }
        requireActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ri() {
        List<String> O1 = ni().O1();
        Bundle bundle = new Bundle();
        bundle.putString("is_trans_activity", "1");
        if (O1 != null) {
            bundle.putStringArrayList("bundle_key_candidate_pic_list", (ArrayList) O1);
            IECRouterLauncher a16 = xi0.a.INSTANCE.a();
            startActivityForResult(a16 != null ? a16.getIntent(requireContext(), ECProductCardEditorPickCoverImgFragment.class, bundle) : null, 0);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.ArrayList<kotlin.String> /* = java.util.ArrayList<kotlin.String> */");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void si() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(ReportDataBuilder.KEY_PRODUCT_ID, this.productId);
        jSONObject.put("saas_id", this.spuId);
        jSONObject.put("product_name", this.productName);
        jSONObject.put("goods_type", this.goodsType);
        jSONObject.put("edited_cover", this.selectedUrl);
        jSONObject.put("edited_title", this.productName);
        com.tencent.ecommerce.biz.showwindow.editor.ui.view.b.f104479a.b("goods_card_edition_save", jSONObject);
    }

    private final void ti() {
        ni().X1(this.spuId);
    }

    private final void toast(String msg2) {
        com.tencent.ecommerce.base.ui.i.f101155b.a().makeText(requireContext(), msg2, ECToastIcon.ICON_ERROR, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ui(boolean enable) {
        if (enable) {
            Button button = this.saveButton;
            if (button == null) {
                Intrinsics.throwUninitializedPropertyAccessException("saveButton");
            }
            button.setClickable(true);
            Button button2 = this.saveButton;
            if (button2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("saveButton");
            }
            button2.setBackgroundResource(R.color.f6581y);
            cg0.a.b("ECProductCardEditorFragment", "Button state Enabled");
            return;
        }
        Button button3 = this.saveButton;
        if (button3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("saveButton");
        }
        button3.setClickable(false);
        Button button4 = this.saveButton;
        if (button4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("saveButton");
        }
        button4.setBackgroundResource(R.color.f6571x);
        cg0.a.b("ECProductCardEditorFragment", "Button state Disabled");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void vi(String productId, String productTitle, String productMainPic, long timeStamp) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(ReportDataBuilder.KEY_PRODUCT_ID, productId);
        jSONObject.put("product_name", productTitle);
        jSONObject.put("product_main_pic_url", productMainPic);
        jSONObject.put("time_stamp", timeStamp);
        cg0.a.b("ECProductCardEditorFragment", "Save to local " + jSONObject);
        ECLocalConfig.f100650f.setString("product_json_data_sp_key", jSONObject.toString(), Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void wi() {
        ((FrameLayout) yh().findViewById(R.id.nzg)).setVisibility(0);
        ((FrameLayout) yh().findViewById(R.id.nzd)).setVisibility(8);
        ((TextView) yh().findViewById(R.id.od6)).setVisibility(8);
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public boolean Dh() {
        return true;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public boolean Eh() {
        return true;
    }

    @Override // com.tencent.ecommerce.base.fragment.api.IECBaseFragment
    /* renamed from: getBusinessDescription */
    public String getTAG() {
        return "ECProductCardEditorFragment";
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int getContentLayoutId() {
        return R.layout.cuk;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initArguments();
        initViews(view);
        oi();
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int uh() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "hasFocus", "", "onFocusChange"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class e implements View.OnFocusChangeListener {
        e() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public final void onFocusChange(View view, boolean z16) {
            if (z16) {
                ECProductCardEditorFragment.Vh(ECProductCardEditorFragment.this).setText(ECProductCardEditorFragment.this.getResources().getString(R.string.ws5));
                if (ECProductCardEditorFragment.Oh(ECProductCardEditorFragment.this).getVisibility() == 0) {
                    ECProductCardEditorFragment.Oh(ECProductCardEditorFragment.this).setVisibility(4);
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JN\u0010\f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022&\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/ecommerce/biz/showwindow/editor/ui/view/ECProductCardEditorFragment$i", "Lcom/tencent/ecommerce/base/ui/e;", "", IECDtReport.ACTION_IDENTIFIER, "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "dataMap", "Landroid/view/View;", "view", "Lcom/tencent/pts/core/PTSComposer;", "ptsComposer", "", "onTapEventTriggered", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class i extends com.tencent.ecommerce.base.ui.e {
        i() {
        }

        @Override // com.tencent.pts.core.lite.IPTSLiteEventListener
        public void onTapEventTriggered(String identifier, HashMap<String, String> dataMap, View view, PTSComposer ptsComposer) {
            String str = dataMap != null ? dataMap.get("eventType") : null;
            if (str != null && str.hashCode() == -865877958 && str.equals("pickProductCoverImg")) {
                ECProductCardEditorFragment.this.ri();
            }
        }
    }

    private final void initViews(View rootView) {
        this.backButton = (ImageView) rootView.findViewById(R.id.o18);
        this.editTextView = (EditText) rootView.findViewById(R.id.nyk);
        this.previewButton = (LinearLayout) rootView.findViewById(R.id.f163060o32);
        this.saveButton = (Button) rootView.findViewById(R.id.nz8);
        this.editTitleIcon = (ImageView) rootView.findViewById(R.id.o1s);
        this.baseView = (ECBasePtsView) rootView.findViewById(R.id.nw6);
        ImageView imageView = (ImageView) rootView.findViewById(R.id.o1m);
        if (imageView != null) {
            IECCoreSkinApi.a.a(ECSkin.INSTANCE, "qecommerce_skin_emptystate_img_dongtai", null, new j(imageView), 2, null);
        }
        ui(false);
    }

    static /* synthetic */ boolean ki(ECProductCardEditorFragment eCProductCardEditorFragment, String str, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        return eCProductCardEditorFragment.ji(str, z16);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        String str;
        boolean isBlank;
        boolean isBlank2;
        if (requestCode == 0 && resultCode == 100) {
            if (data == null || (str = data.getStringExtra("selectedURL")) == null) {
                str = "";
            }
            isBlank = StringsKt__StringsJVMKt.isBlank(str);
            if (!isBlank) {
                this.selectedUrl = str;
                cg0.a.b("ECProductCardEditorFragment", "selectedIndex and " + this.selectedUrl);
                ui(true);
                this.productInfoToPublisher.put("promotion_task_id", this.productId);
                EditText editText = this.editTextView;
                if (editText == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("editTextView");
                }
                String obj = editText.getText().toString();
                isBlank2 = StringsKt__StringsJVMKt.isBlank(obj);
                if (isBlank2) {
                    obj = ni().W1();
                }
                this.productName = obj;
                this.productInfoToPublisher.put("promotion_task_name", obj);
                this.productInfoToPublisher.put("promotion_cover_url", this.selectedUrl);
                this.productInfoToPTS.put("cover_img", this.selectedUrl);
                ECBasePtsViewData eCBasePtsViewData = new ECBasePtsViewData(null, "modify_page_card", this.productInfoToPTS.toString(), null, 9, null);
                ECBaseViewController eCBaseViewController = this.productCardController;
                if (eCBaseViewController == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("productCardController");
                }
                eCBaseViewController.h(requireContext(), eCBasePtsViewData);
                Button button = this.saveButton;
                if (button == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("saveButton");
                }
                button.setText(getResources().getString(R.string.ws5));
                return;
            }
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J*\u0010\u000b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0016J*\u0010\r\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/ecommerce/biz/showwindow/editor/ui/view/ECProductCardEditorFragment$h", "Landroid/text/TextWatcher;", "Landroid/text/Editable;", ReportConstant.COSTREPORT_PREFIX, "", "afterTextChanged", "", "", "start", "count", "after", "beforeTextChanged", "before", "onTextChanged", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class h implements TextWatcher {
        h() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s16) {
            cg0.a.b("ECProductCardEditorFragment", "CHECK: after text change trigger " + ((Object) ECProductCardEditorFragment.Nh(ECProductCardEditorFragment.this).getText()));
            ECProductCardEditorFragment.this.productName = String.valueOf(s16);
            ECProductCardEditorFragment eCProductCardEditorFragment = ECProductCardEditorFragment.this;
            ECProductCardEditorFragment.this.ui(ECProductCardEditorFragment.ki(eCProductCardEditorFragment, ECProductCardEditorFragment.Nh(eCProductCardEditorFragment).getText().toString(), false, 2, null));
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s16, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence s16, int start, int before, int count) {
        }
    }
}
