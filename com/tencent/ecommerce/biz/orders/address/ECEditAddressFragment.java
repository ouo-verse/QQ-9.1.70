package com.tencent.ecommerce.biz.orders.address;

import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.fragment.ECBaseFragment;
import com.tencent.ecommerce.base.ktx.ISoftKeyBoardStateListenerRegistry;
import com.tencent.ecommerce.base.permission.api.PermissionListener;
import com.tencent.ecommerce.base.router.api.IECSchemeCallback;
import com.tencent.ecommerce.base.ui.SoftKeyboardStateHelper;
import com.tencent.ecommerce.base.ui.api.ECToastIcon;
import com.tencent.ecommerce.base.ui.i;
import com.tencent.ecommerce.biz.orders.address.ECEditAddressFragment;
import com.tencent.ecommerce.biz.orders.address.ECSmartParseCopyAddressAdapter;
import com.tencent.ecommerce.biz.util.ECDeviceUtils;
import com.tencent.hippy.qq.view.boodo.CommonVideoViewController;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.servlet.MiniAppSendSmsCodeServlet;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vas.config.business.qvip.QVipPrettyAccountProcessor;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qmethod.pandoraex.monitor.ClipboardMonitor;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.plugins.SensorJsPlugin;
import gi0.b;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import mqq.app.Constants;
import org.apache.httpcore.message.TokenParser;
import org.json.JSONObject;
import org.slf4j.Marker;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ce\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u0097\u00012\u00020\u00012\u00020\u0002:\u0004\u0098\u0001\u0099\u0001B\b\u00a2\u0006\u0005\b\u0096\u0001\u0010{J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u001a\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0007H\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u000bH\u0016J\b\u0010\u0012\u001a\u00020\u000bH\u0016J\b\u0010\u0013\u001a\u00020\u000fH\u0016J\b\u0010\u0014\u001a\u00020\u000fH\u0016J\u0010\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u0016\u001a\u00020\u000bH\u0002J\b\u0010\u0017\u001a\u00020\u000bH\u0002J\u001a\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u00182\b\b\u0001\u0010\u001a\u001a\u00020\u0005H\u0002J\u0010\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u0003H\u0002J\u0010\u0010 \u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002J\u0010\u0010!\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002J\u0010\u0010\"\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002J0\u0010(\u001a\u00020\u000b\"\u0004\b\u0000\u0010#2\f\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000$2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000b0&H\u0002J\u0012\u0010)\u001a\u00020\u000b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0002J\b\u0010*\u001a\u00020\u000bH\u0002J\b\u0010+\u001a\u00020\u000fH\u0002J\u0018\u0010-\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u00032\u0006\u0010,\u001a\u00020\u000fH\u0002J\u0018\u00100\u001a\u00020\u000b2\u0006\u0010/\u001a\u00020.2\u0006\u0010,\u001a\u00020\u000fH\u0002J\u001e\u00104\u001a\u00020\u000b2\u0006\u0010/\u001a\u00020.2\f\u00103\u001a\b\u0012\u0004\u0012\u00020201H\u0002J\u0010\u00106\u001a\u00020\u000b2\u0006\u00105\u001a\u00020\u0003H\u0002J\b\u00107\u001a\u00020\u000bH\u0002J\b\u00108\u001a\u00020\u000bH\u0002J<\u0010=\u001a\u00020\u000b2\u0006\u00109\u001a\u00020\u00072\b\b\u0002\u0010:\u001a\u00020\u00032\f\u00103\u001a\b\u0012\u0004\u0012\u00020;012\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b0&H\u0002J\u0012\u0010>\u001a\b\u0012\u0004\u0012\u00020201*\u00020.H\u0002R\u001b\u0010D\u001a\u00020?8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010CR\u0016\u0010H\u001a\u00020E8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010L\u001a\u00020I8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010N\u001a\u00020I8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bM\u0010KR\u0016\u0010Q\u001a\u00020O8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010PR\u0016\u0010S\u001a\u00020O8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bR\u0010PR\u0016\u0010V\u001a\u00020\u00078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010X\u001a\u00020I8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bW\u0010KR\u0016\u0010Z\u001a\u00020\u00078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bY\u0010UR\u0016\u0010\\\u001a\u00020O8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b[\u0010PR\u0016\u0010^\u001a\u00020E8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b]\u0010GR\u0016\u0010`\u001a\u00020E8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b_\u0010GR\u0016\u0010b\u001a\u00020E8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\ba\u0010GR\u0016\u0010f\u001a\u00020c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bd\u0010eR\u0016\u0010j\u001a\u00020g8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bh\u0010iR\u0016\u0010n\u001a\u00020k8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bl\u0010mR\u0018\u0010q\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bo\u0010pR4\u0010|\u001a\u0004\u0018\u00010r2\b\u0010s\u001a\u0004\u0018\u00010r8\u0006@FX\u0087\u000e\u00a2\u0006\u0018\n\u0004\bt\u0010u\u0012\u0004\bz\u0010{\u001a\u0004\bv\u0010w\"\u0004\bx\u0010yR\u001e\u0010\u0081\u0001\u001a\n ~*\u0004\u0018\u00010}0}8\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u007f\u0010\u0080\u0001R\u0018\u0010\u0085\u0001\u001a\u00030\u0082\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0083\u0001\u0010\u0084\u0001R\u001c\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u0086\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0087\u0001\u0010\u0088\u0001R\u0019\u0010\u008c\u0001\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008a\u0001\u0010\u008b\u0001R\u001c\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u008d\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008e\u0001\u0010\u008f\u0001R\u0018\u0010\u0092\u0001\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0091\u0001\u0010]R\u0017\u0010\u0095\u0001\u001a\u00020\u00038BX\u0082\u0004\u00a2\u0006\b\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001\u00a8\u0006\u009a\u0001"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/address/ECEditAddressFragment;", "Lcom/tencent/ecommerce/base/fragment/ECBaseFragment;", "Landroid/view/View$OnClickListener;", "", "getBusinessDescription", "", "getContentLayoutId", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "v", NodeProps.ON_CLICK, "", "onBackPressed", "onResume", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Eh", "Dh", "initView", "initArguments", SensorJsPlugin.SENSOR_INTERVAL_UI, "", "content", "toast", "ii", MiniAppSendSmsCodeServlet.KEY_PHONE_NUMBER, "oi", "Lcom/tencent/ecommerce/biz/orders/address/ECAddress;", "address", "gi", "Ci", "qi", "T", "Lkotlinx/coroutines/flow/Flow;", "flow", "Lkotlin/Function1;", "callback", "ti", "hi", "zi", "Ai", CommonVideoViewController.PropName.SHOW_ERROR_TOAST, "pi", "Lag0/c;", "addressParseResult", "Bi", "", "Lcom/tencent/ecommerce/biz/orders/address/ECSmartParseCopyAddressAdapter$a;", "itemDataList", "ki", "keyWord", "ri", WidgetCacheLunarData.JI, "si", "anchor", "title", "Lgi0/b$a;", "itemClickCallback", "wi", WidgetCacheLunarData.YI, "Lcom/tencent/ecommerce/biz/orders/address/ECEditAddressViewModel;", "P", "Lkotlin/Lazy;", "ni", "()Lcom/tencent/ecommerce/biz/orders/address/ECEditAddressViewModel;", "viewModel", "Landroid/widget/ImageView;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/widget/ImageView;", "backBtn", "Landroid/widget/TextView;", BdhLogUtil.LogTag.Tag_Req, "Landroid/widget/TextView;", "deleteBtn", ExifInterface.LATITUDE_SOUTH, "pasteBtn", "Landroid/widget/EditText;", "Landroid/widget/EditText;", "consigneeEditText", "U", "phoneNumberEditText", "V", "Landroid/view/View;", "districtContainer", "W", "addressText", "X", "detailAddressContainer", "Y", "detailAddressEditText", "Z", "consigneeClearBtn", "a0", "phoneNumberClearBtn", "b0", "detailAddressClearBtn", "Landroid/widget/Button;", "c0", "Landroid/widget/Button;", "saveBtn", "Landroid/widget/Switch;", "d0", "Landroid/widget/Switch;", "switchBtn", "Lcom/tencent/ecommerce/base/ktx/ISoftKeyBoardStateListenerRegistry;", "e0", "Lcom/tencent/ecommerce/base/ktx/ISoftKeyBoardStateListenerRegistry;", "softKeyBoardStateListenerRegistry", "f0", "Lcom/tencent/ecommerce/biz/orders/address/ECAddress;", "originAddress", "Lcom/tencent/ecommerce/biz/orders/address/ECEditAddressFragment$b;", "value", "g0", "Lcom/tencent/ecommerce/biz/orders/address/ECEditAddressFragment$b;", "mi", "()Lcom/tencent/ecommerce/biz/orders/address/ECEditAddressFragment$b;", "vi", "(Lcom/tencent/ecommerce/biz/orders/address/ECEditAddressFragment$b;)V", "getDistrictInfo$annotations", "()V", "districtInfo", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "h0", "Ljava/util/regex/Pattern;", "pattern", "Landroid/view/View$OnLongClickListener;", "i0", "Landroid/view/View$OnLongClickListener;", "longClickListener", "Landroid/app/Dialog;", "j0", "Landroid/app/Dialog;", "pasteAddressDialog", "k0", "Ljava/lang/String;", "oldCopyAddress", "Lgi0/b;", "l0", "Lgi0/b;", "listPopupWindow", "m0", "shouldShowPopupWindow", "li", "()Ljava/lang/String;", "copyAddress", "<init>", "n0", "a", "b", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECEditAddressFragment extends ECBaseFragment implements View.OnClickListener {

    /* renamed from: P, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* renamed from: Q, reason: from kotlin metadata */
    private ImageView backBtn;

    /* renamed from: R, reason: from kotlin metadata */
    private TextView deleteBtn;

    /* renamed from: S, reason: from kotlin metadata */
    private TextView pasteBtn;

    /* renamed from: T, reason: from kotlin metadata */
    private EditText consigneeEditText;

    /* renamed from: U, reason: from kotlin metadata */
    private EditText phoneNumberEditText;

    /* renamed from: V, reason: from kotlin metadata */
    private View districtContainer;

    /* renamed from: W, reason: from kotlin metadata */
    private TextView addressText;

    /* renamed from: X, reason: from kotlin metadata */
    private View detailAddressContainer;

    /* renamed from: Y, reason: from kotlin metadata */
    private EditText detailAddressEditText;

    /* renamed from: Z, reason: from kotlin metadata */
    private ImageView consigneeClearBtn;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private ImageView phoneNumberClearBtn;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private ImageView detailAddressClearBtn;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private Button saveBtn;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private Switch switchBtn;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private ISoftKeyBoardStateListenerRegistry softKeyBoardStateListenerRegistry;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private ECAddress originAddress;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private DistrictInfo districtInfo;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    private final Pattern pattern;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    private final View.OnLongClickListener longClickListener;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    private Dialog pasteAddressDialog;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    private String oldCopyAddress;

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    private gi0.b listPopupWindow;

    /* renamed from: m0, reason: collision with root package name and from kotlin metadata */
    private boolean shouldShowPopupWindow;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u000bB-\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002J\t\u0010\u0005\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\fR\u0014\u0010\u0010\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\fR\u0017\u0010\u0013\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000b\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/address/ECEditAddressFragment$b;", "", "", "", "b", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "province", "city", "c", "district", "d", "()Ljava/lang/String;", "street", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "e", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.orders.address.ECEditAddressFragment$b, reason: from toString */
    /* loaded from: classes31.dex */
    public static final /* data */ class DistrictInfo {

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final String province;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final String city;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        public final String district;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final String street;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/address/ECEditAddressFragment$b$a;", "", "Lorg/json/JSONObject;", "jsonObject", "Lcom/tencent/ecommerce/biz/orders/address/ECEditAddressFragment$b;", "a", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
        /* renamed from: com.tencent.ecommerce.biz.orders.address.ECEditAddressFragment$b$a, reason: from kotlin metadata */
        /* loaded from: classes31.dex */
        public static final class Companion {
            Companion() {
            }

            public final DistrictInfo a(JSONObject jsonObject) {
                String optString = jsonObject.optString("Province");
                String optString2 = jsonObject.optString("City");
                String optString3 = jsonObject.optString("District");
                String optString4 = jsonObject.optString("Street");
                if (optString.length() == 0) {
                    if (optString2.length() == 0) {
                        return null;
                    }
                }
                return new DistrictInfo(optString, optString2, optString3, optString4);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public DistrictInfo(String str, String str2, String str3, String str4) {
            this.province = str;
            this.city = str2;
            this.district = str3;
            this.street = str4;
        }

        /* renamed from: a, reason: from getter */
        public final String getStreet() {
            return this.street;
        }

        public int hashCode() {
            String str = this.province;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.city;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.district;
            int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.street;
            return hashCode3 + (str4 != null ? str4.hashCode() : 0);
        }

        public String toString() {
            return "DistrictInfo(province=" + this.province + ", city=" + this.city + ", district=" + this.district + ", street=" + this.street + ")";
        }

        public /* synthetic */ DistrictInfo(String str, String str2, String str3, String str4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? "" : str3, (i3 & 8) != 0 ? "" : str4);
        }

        public final Map<String, String> b() {
            Map<String, String> mapOf;
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("Province", this.province), TuplesKt.to("City", this.city), TuplesKt.to("District", this.district), TuplesKt.to("Street", this.street));
            return mapOf;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DistrictInfo)) {
                return false;
            }
            DistrictInfo districtInfo = (DistrictInfo) other;
            return Intrinsics.areEqual(this.province, districtInfo.province) && Intrinsics.areEqual(this.city, districtInfo.city) && Intrinsics.areEqual(this.district, districtInfo.district) && Intrinsics.areEqual(this.street, districtInfo.street);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001c\u0010\b\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/ecommerce/biz/orders/address/ECEditAddressFragment$c", "Lcom/tencent/ecommerce/base/permission/api/PermissionListener;", "", "onAllGranted", "", "", "", "result", "onDenied", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c implements PermissionListener {
        c() {
        }

        @Override // com.tencent.ecommerce.base.permission.api.PermissionListener
        public void onAllGranted() {
            ECEditAddressFragment.this.si();
        }

        @Override // com.tencent.ecommerce.base.permission.api.PermissionListener
        public void onDenied(Map<String, Boolean> result) {
            cg0.a.a("ECEditAddressFragment", "checkPermissionAndRequestCurrentLocationAddressList", "denied location permission");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/ecommerce/biz/orders/address/ECEditAddressFragment$e", "Lcom/tencent/ecommerce/base/ui/SoftKeyboardStateHelper$SoftKeyboardStateListener;", "", "keyboardHeightInPx", "", "onSoftKeyboardOpened", "onSoftKeyboardClosed", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class e implements SoftKeyboardStateHelper.SoftKeyboardStateListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f103026b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f103027c;

        public e(View view, ECEditAddressFragment eCEditAddressFragment, View view2) {
            this.f103026b = view;
            this.f103027c = view2;
        }

        @Override // com.tencent.ecommerce.base.ui.SoftKeyboardStateHelper.SoftKeyboardStateListener
        public void onSoftKeyboardClosed() {
            this.f103027c.scrollTo(0, 0);
            ECEditAddressFragment.Nh(ECEditAddressFragment.this).setVisibility(8);
            ECEditAddressFragment.Uh(ECEditAddressFragment.this).setVisibility(8);
            ECEditAddressFragment.Ph(ECEditAddressFragment.this).setVisibility(8);
        }

        @Override // com.tencent.ecommerce.base.ui.SoftKeyboardStateHelper.SoftKeyboardStateListener
        public void onSoftKeyboardOpened(int keyboardHeightInPx) {
            if (ECEditAddressFragment.Rh(ECEditAddressFragment.this).isFocused()) {
                this.f103026b.scrollTo(0, (int) ECEditAddressFragment.Sh(ECEditAddressFragment.this).getY());
                if (ECEditAddressFragment.Rh(ECEditAddressFragment.this).getText().length() > 0) {
                    ECEditAddressFragment eCEditAddressFragment = ECEditAddressFragment.this;
                    eCEditAddressFragment.ri(ECEditAddressFragment.Rh(eCEditAddressFragment).getText().toString());
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_LONG_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    static final class j implements View.OnLongClickListener {
        j() {
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View view) {
            EventCollector.getInstance().onViewLongClickedBefore(view);
            boolean Ai = ECEditAddressFragment.this.Ai();
            EventCollector.getInstance().onViewLongClicked(view);
            return Ai;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004H\n\u00a2\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "T", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class k implements DialogInterface.OnCancelListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Job f103035d;

        k(Job job) {
            this.f103035d = job;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface dialogInterface) {
            if (this.f103035d.isActive()) {
                Job.DefaultImpls.cancel$default(this.f103035d, (CancellationException) null, 1, (Object) null);
            }
        }
    }

    public ECEditAddressFragment() {
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.tencent.ecommerce.biz.orders.address.ECEditAddressFragment$$special$$inlined$viewModels$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ECEditAddressViewModel.class), new Function0<ViewModelStore>() { // from class: com.tencent.ecommerce.biz.orders.address.ECEditAddressFragment$$special$$inlined$viewModels$2
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
        this.pattern = Pattern.compile("^1[3456789]\\d{9}$");
        this.longClickListener = new j();
        this.oldCopyAddress = "";
        this.shouldShowPopupWindow = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean Ai() {
        Dialog dialog;
        if (((Number) com.tencent.ecommerce.base.config.service.b.f100655b.a(QVipPrettyAccountProcessor.CMD, "paste_type", 1)).intValue() != 0) {
            return false;
        }
        if ((li().length() == 0) || (((dialog = this.pasteAddressDialog) != null && dialog.isShowing()) || Intrinsics.areEqual(this.oldCopyAddress, li()))) {
            return false;
        }
        this.oldCopyAddress = li();
        pi(li(), false);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Bi(final ag0.c addressParseResult, boolean showErrorToast) {
        final List<ECSmartParseCopyAddressAdapter.ItemData> yi5 = yi(addressParseResult);
        if (yi5.isEmpty()) {
            cg0.a.a("ECEditAddressFragment", "tryShowAddressParseResultDialog", "parse result content is empty");
            if (showErrorToast) {
                com.tencent.ecommerce.base.ui.i.e(com.tencent.ecommerce.base.ui.i.f101155b, R.string.wol, null, 0, 6, null);
                return;
            }
            return;
        }
        com.tencent.ecommerce.base.ui.h hVar = new com.tencent.ecommerce.base.ui.h(requireContext(), new ECSmartParseCopyAddressAdapter(yi5, new Function2<ECSmartParseCopyAddressAdapter.ItemType, Boolean, Unit>() { // from class: com.tencent.ecommerce.biz.orders.address.ECEditAddressFragment$tryShowAddressParseResultDialog$adapter$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(ECSmartParseCopyAddressAdapter.ItemType itemType, Boolean bool) {
                invoke(itemType, bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(ECSmartParseCopyAddressAdapter.ItemType itemType, boolean z16) {
                for (ECSmartParseCopyAddressAdapter.ItemData itemData : yi5) {
                    if (itemData.type == itemType) {
                        itemData.c(z16);
                        return;
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }), null, 4, null);
        hVar.setTitle(getString(R.string.wit));
        hVar.P(new Function1<View, Unit>() { // from class: com.tencent.ecommerce.biz.orders.address.ECEditAddressFragment$tryShowAddressParseResultDialog$$inlined$apply$lambda$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                ECEditAddressFragment.this.ki(addressParseResult, yi5);
            }
        });
        hVar.setCanceledOnTouchOutside(false);
        Unit unit = Unit.INSTANCE;
        this.pasteAddressDialog = hVar;
        hVar.show();
    }

    private final void Ci(final ECAddress address) {
        ti(ni().P1(address), new Function1<Boolean, Unit>() { // from class: com.tencent.ecommerce.biz.orders.address.ECEditAddressFragment$updateAddress$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                if (z16) {
                    ECEditAddressFragment.this.hi(address);
                    ECEditAddressFragment.this.requireActivity().finish();
                } else {
                    i.f101155b.d(ECEditAddressFragment.this.getString(R.string.f169640ws4), ECToastIcon.ICON_ERROR, 0);
                }
            }
        });
    }

    public static final /* synthetic */ ImageView Nh(ECEditAddressFragment eCEditAddressFragment) {
        ImageView imageView = eCEditAddressFragment.consigneeClearBtn;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("consigneeClearBtn");
        }
        return imageView;
    }

    public static final /* synthetic */ EditText Oh(ECEditAddressFragment eCEditAddressFragment) {
        EditText editText = eCEditAddressFragment.consigneeEditText;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("consigneeEditText");
        }
        return editText;
    }

    public static final /* synthetic */ ImageView Ph(ECEditAddressFragment eCEditAddressFragment) {
        ImageView imageView = eCEditAddressFragment.detailAddressClearBtn;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailAddressClearBtn");
        }
        return imageView;
    }

    public static final /* synthetic */ View Qh(ECEditAddressFragment eCEditAddressFragment) {
        View view = eCEditAddressFragment.detailAddressContainer;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailAddressContainer");
        }
        return view;
    }

    public static final /* synthetic */ EditText Rh(ECEditAddressFragment eCEditAddressFragment) {
        EditText editText = eCEditAddressFragment.detailAddressEditText;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailAddressEditText");
        }
        return editText;
    }

    public static final /* synthetic */ View Sh(ECEditAddressFragment eCEditAddressFragment) {
        View view = eCEditAddressFragment.districtContainer;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("districtContainer");
        }
        return view;
    }

    public static final /* synthetic */ ImageView Uh(ECEditAddressFragment eCEditAddressFragment) {
        ImageView imageView = eCEditAddressFragment.phoneNumberClearBtn;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("phoneNumberClearBtn");
        }
        return imageView;
    }

    public static final /* synthetic */ EditText Vh(ECEditAddressFragment eCEditAddressFragment) {
        EditText editText = eCEditAddressFragment.phoneNumberEditText;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("phoneNumberEditText");
        }
        return editText;
    }

    public static final /* synthetic */ ISoftKeyBoardStateListenerRegistry Xh(ECEditAddressFragment eCEditAddressFragment) {
        ISoftKeyBoardStateListenerRegistry iSoftKeyBoardStateListenerRegistry = eCEditAddressFragment.softKeyBoardStateListenerRegistry;
        if (iSoftKeyBoardStateListenerRegistry == null) {
            Intrinsics.throwUninitializedPropertyAccessException("softKeyBoardStateListenerRegistry");
        }
        return iSoftKeyBoardStateListenerRegistry;
    }

    private final void gi(ECAddress address) {
        ti(ni().L1(address), new Function1<ECAddress, Unit>() { // from class: com.tencent.ecommerce.biz.orders.address.ECEditAddressFragment$addAddress$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ECAddress eCAddress) {
                invoke2(eCAddress);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ECAddress eCAddress) {
                if (eCAddress != null) {
                    ECEditAddressFragment.this.hi(eCAddress);
                    ECEditAddressFragment.this.requireActivity().finish();
                } else {
                    i.f101155b.d(ECEditAddressFragment.this.getString(R.string.f169640ws4), ECToastIcon.ICON_ERROR, 0);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hi(ECAddress address) {
        String str;
        JSONObject jSONObject;
        Bundle arguments = getArguments();
        if (arguments == null || (str = arguments.getString("scheme_callback_id")) == null) {
            str = "";
        }
        IECSchemeCallback b16 = ug0.a.b(str);
        if (b16 != null) {
            JSONObject jSONObject2 = new JSONObject();
            if (address == null || (jSONObject = b.d(address)) == null) {
                jSONObject = new JSONObject();
            }
            jSONObject2.put("callbackAddress", jSONObject);
            Unit unit = Unit.INSTANCE;
            b16.onCallbackFinished(jSONObject2);
        }
    }

    private final boolean ii(CharSequence content, int toast) {
        if (!(content.length() == 0)) {
            return false;
        }
        com.tencent.ecommerce.base.ui.i.f101155b.d(getString(toast), ECToastIcon.ICON_ERROR, 0);
        return true;
    }

    private final void initArguments() {
        String string;
        String string2;
        Bundle arguments = getArguments();
        if (arguments != null && (string2 = arguments.getString("addressInfo")) != null) {
            this.originAddress = ECAddress.INSTANCE.a(new JSONObject(string2));
        }
        ECAddress eCAddress = this.originAddress;
        if (eCAddress != null) {
            TextView textView = this.deleteBtn;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("deleteBtn");
            }
            textView.setVisibility(0);
            EditText editText = this.consigneeEditText;
            if (editText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("consigneeEditText");
            }
            editText.setText(eCAddress.consignee);
            EditText editText2 = this.phoneNumberEditText;
            if (editText2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("phoneNumberEditText");
            }
            editText2.setText(eCAddress.phoneNumber);
            EditText editText3 = this.detailAddressEditText;
            if (editText3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("detailAddressEditText");
            }
            editText3.setText(eCAddress.detailAddress);
            Switch r26 = this.switchBtn;
            if (r26 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("switchBtn");
            }
            r26.setChecked(eCAddress.isDefaultAddress);
            vi(new DistrictInfo(eCAddress.province, eCAddress.city, eCAddress.district, eCAddress.street));
        }
        TextView textView2 = this.pasteBtn;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pasteBtn");
        }
        textView2.setVisibility(this.originAddress == null ? 0 : 8);
        Bundle arguments2 = getArguments();
        if (arguments2 == null || (string = arguments2.getString("from")) == null) {
            return;
        }
        com.tencent.ecommerce.biz.orders.address.d.f103051a.a(string);
    }

    private final void ji() {
        jg0.a aVar = jg0.a.f409882a;
        if (aVar.b(requireActivity(), "android.permission.ACCESS_COARSE_LOCATION")) {
            si();
        } else {
            aVar.d(this, new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"}, new c());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ki(ag0.c addressParseResult, List<ECSmartParseCopyAddressAdapter.ItemData> itemDataList) {
        for (ECSmartParseCopyAddressAdapter.ItemData itemData : itemDataList) {
            if (itemData.getIsSelected()) {
                ECSmartParseCopyAddressAdapter.ItemType itemType = itemData.type;
                if (itemType == ECSmartParseCopyAddressAdapter.ItemType.Consignee) {
                    addressParseResult.getClass();
                } else if (itemType == ECSmartParseCopyAddressAdapter.ItemType.Phone) {
                    addressParseResult.getClass();
                } else if (itemType == ECSmartParseCopyAddressAdapter.ItemType.District) {
                    addressParseResult.getClass();
                } else if (itemType == ECSmartParseCopyAddressAdapter.ItemType.DetailAddress) {
                    EditText editText = this.detailAddressEditText;
                    if (editText == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("detailAddressEditText");
                    }
                    addressParseResult.getClass();
                    editText.setText((CharSequence) null);
                }
            }
        }
    }

    private final String li() {
        ClipData primaryClip;
        ClipData.Item itemAt;
        CharSequence text;
        String obj;
        Object systemService = requireContext().getSystemService("clipboard");
        if (systemService != null) {
            ClipboardManager clipboardManager = (ClipboardManager) systemService;
            ClipDescription primaryClipDescription = ClipboardMonitor.getPrimaryClipDescription(clipboardManager);
            return (primaryClipDescription == null || !primaryClipDescription.hasMimeType("text/plain") || (primaryClip = ClipboardMonitor.getPrimaryClip(clipboardManager)) == null || (itemAt = primaryClip.getItemAt(0)) == null || (text = itemAt.getText()) == null || (obj = text.toString()) == null) ? "" : obj;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.content.ClipboardManager");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ECEditAddressViewModel ni() {
        return (ECEditAddressViewModel) this.viewModel.getValue();
    }

    private final void pi(String address, final boolean showErrorToast) {
        if (!(address.length() == 0)) {
            QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getLocationService().smartParseAddress(requireContext(), gi0.a.f402075a.a(address), new Function3<Integer, String, ag0.c, Unit>() { // from class: com.tencent.ecommerce.biz.orders.address.ECEditAddressFragment$parseCopyAddress$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str, ag0.c cVar) {
                    invoke(num.intValue(), str, cVar);
                    return Unit.INSTANCE;
                }

                public final void invoke(int i3, String str, ag0.c cVar) {
                    if (i3 == 0 && cVar != null) {
                        ECEditAddressFragment.this.Bi(cVar, showErrorToast);
                        return;
                    }
                    cg0.a.a("ECEditAddressFragment", "identifyCopyAddress", "smart parse address err. errCode:" + i3 + ", errMsg\uff1a" + str);
                    if (showErrorToast) {
                        i.e(i.f101155b, R.string.wol, null, 0, 6, null);
                    }
                }
            });
        } else if (showErrorToast) {
            com.tencent.ecommerce.base.ui.i.e(com.tencent.ecommerce.base.ui.i.f101155b, R.string.wol, null, 0, 6, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void qi(ECAddress address) {
        ti(ni().M1(address.id), new Function1<Boolean, Unit>() { // from class: com.tencent.ecommerce.biz.orders.address.ECEditAddressFragment$removeAddress$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                if (z16) {
                    ECEditAddressFragment.this.hi(null);
                    ECEditAddressFragment.this.requireActivity().finish();
                } else {
                    i.f101155b.d(ECEditAddressFragment.this.getString(R.string.wj8), ECToastIcon.ICON_ERROR, 0);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ri(String keyWord) {
        if (keyWord.length() == 0) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new ECEditAddressFragment$requestAddressListWithKeyWord$$inlined$launchAndRepeatWithViewLifecycle$1(this, Lifecycle.State.STARTED, null, this, keyWord), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void si() {
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new ECEditAddressFragment$requestCurrentLocationAddressList$$inlined$launchAndRepeatWithViewLifecycle$1(this, Lifecycle.State.STARTED, null, this), 3, null);
    }

    private final <T> void ti(Flow<? extends T> flow, Function1<? super T, Unit> callback) {
        Job launch$default;
        com.tencent.ecommerce.base.ui.d dVar = new com.tencent.ecommerce.base.ui.d(requireContext(), null, 2, null);
        dVar.show();
        launch$default = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new ECEditAddressFragment$requestNetworkAndShowLoadingDialog$$inlined$launchAndRepeatWithViewLifecycle$1(this, Lifecycle.State.STARTED, null, flow, dVar, callback), 3, null);
        dVar.setOnCancelListener(new k(launch$default));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void wi(View anchor, String title, List<b.ItemData> itemDataList, Function1<? super Integer, Unit> itemClickCallback) {
        gi0.b bVar;
        gi0.b bVar2 = this.listPopupWindow;
        if (bVar2 != null && bVar2.isShowing() && (bVar = this.listPopupWindow) != null) {
            bVar.dismiss();
        }
        gi0.b bVar3 = new gi0.b(requireContext(), itemClickCallback);
        bVar3.b(title);
        bVar3.a(itemDataList);
        bVar3.setWidth(ECDeviceUtils.f104857e.f() - com.tencent.ecommerce.biz.util.e.c(32.0f));
        bVar3.setOutsideTouchable(true);
        Unit unit = Unit.INSTANCE;
        this.listPopupWindow = bVar3;
        bVar3.showAsDropDown(anchor, com.tencent.ecommerce.biz.util.e.c(16.0f), 0);
    }

    private final List<ECSmartParseCopyAddressAdapter.ItemData> yi(ag0.c cVar) {
        ArrayList arrayList = new ArrayList();
        cVar.getClass();
        return arrayList;
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
        return "ECAddressAddFragment";
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int getContentLayoutId() {
        return R.layout.cqe;
    }

    /* renamed from: mi, reason: from getter */
    public final DistrictInfo getDistrictInfo() {
        return this.districtInfo;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, com.tencent.ecommerce.base.ui.api.IECFragmentApi
    public boolean onBackPressed() {
        zi();
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        int id5 = v3.getId();
        if (id5 == R.id.nqa) {
            zi();
        } else if (id5 == R.id.f163018nv3) {
            final ECAddress eCAddress = this.originAddress;
            if (eCAddress != null) {
                com.tencent.ecommerce.base.ui.g gVar = new com.tencent.ecommerce.base.ui.g(requireContext());
                gVar.Z(1);
                gVar.Y(getResources().getString(R.string.wj7));
                gVar.e0(new Function1<View, Unit>() { // from class: com.tencent.ecommerce.biz.orders.address.ECEditAddressFragment$onClick$$inlined$let$lambda$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(View view) {
                        invoke2(view);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(View view) {
                        this.qi(ECAddress.this);
                    }
                });
                gVar.show();
            }
        } else if (id5 == R.id.o67) {
            pi(li(), true);
        } else if (id5 == R.id.nu6) {
            EditText editText = this.consigneeEditText;
            if (editText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("consigneeEditText");
            }
            editText.setText("");
            ImageView imageView = this.consigneeClearBtn;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("consigneeClearBtn");
            }
            imageView.setVisibility(8);
        } else if (id5 == R.id.o6m) {
            EditText editText2 = this.phoneNumberEditText;
            if (editText2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("phoneNumberEditText");
            }
            editText2.setText("");
            ImageView imageView2 = this.phoneNumberClearBtn;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("phoneNumberClearBtn");
            }
            imageView2.setVisibility(8);
        } else if (id5 == R.id.nv_) {
            EditText editText3 = this.detailAddressEditText;
            if (editText3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("detailAddressEditText");
            }
            editText3.setText("");
            ImageView imageView3 = this.detailAddressClearBtn;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("detailAddressClearBtn");
            }
            imageView3.setVisibility(8);
        } else if (id5 == R.id.npf) {
            ui();
        } else if (id5 == R.id.o3q) {
            SoftKeyboardStateHelper.INSTANCE.a(requireActivity());
            ji();
        } else if (id5 == R.id.npj || id5 == R.id.npl) {
            com.tencent.ecommerce.biz.orders.address.c.d(requireActivity(), this.districtInfo, false, new Function1<DistrictInfo, Unit>() { // from class: com.tencent.ecommerce.biz.orders.address.ECEditAddressFragment$onClick$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ECEditAddressFragment.DistrictInfo districtInfo) {
                    invoke2(districtInfo);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ECEditAddressFragment.DistrictInfo districtInfo) {
                    ECEditAddressFragment.this.vi(districtInfo);
                }
            }, 4, null);
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        ISoftKeyBoardStateListenerRegistry iSoftKeyBoardStateListenerRegistry = this.softKeyBoardStateListenerRegistry;
        if (iSoftKeyBoardStateListenerRegistry == null) {
            Intrinsics.throwUninitializedPropertyAccessException("softKeyBoardStateListenerRegistry");
        }
        iSoftKeyBoardStateListenerRegistry.unregister();
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        yh().post(new Runnable() { // from class: com.tencent.ecommerce.biz.orders.address.ECEditAddressFragment$onResume$1
            @Override // java.lang.Runnable
            public final void run() {
                ECEditAddressFragment.this.Ai();
            }
        });
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initArguments();
    }

    public final void vi(DistrictInfo districtInfo) {
        this.districtInfo = districtInfo;
        if (districtInfo == null) {
            TextView textView = this.addressText;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("addressText");
            }
            textView.setText("");
            return;
        }
        TextView textView2 = this.addressText;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addressText");
        }
        textView2.setText(districtInfo.province + TokenParser.SP + districtInfo.city + TokenParser.SP + districtInfo.district + TokenParser.SP + districtInfo.getStreet());
    }

    private final boolean oi(String phoneNumber) {
        boolean startsWith$default;
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(phoneNumber, Marker.ANY_NON_NULL_MARKER, false, 2, null);
        if (startsWith$default) {
            return true;
        }
        return this.pattern.matcher(phoneNumber).matches();
    }

    private final void ui() {
        String replace$default;
        ECAddress a16;
        EditText editText = this.consigneeEditText;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("consigneeEditText");
        }
        CharSequence text = editText.getText();
        EditText editText2 = this.phoneNumberEditText;
        if (editText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("phoneNumberEditText");
        }
        CharSequence text2 = editText2.getText();
        TextView textView = this.addressText;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addressText");
        }
        CharSequence text3 = textView.getText();
        EditText editText3 = this.detailAddressEditText;
        if (editText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailAddressEditText");
        }
        replace$default = StringsKt__StringsJVMKt.replace$default(editText3.getText().toString(), "\n", "", false, 4, (Object) null);
        if (ii(text, R.string.wih) || ii(text2, R.string.wpa) || ii(text3, R.string.wqu) || ii(replace$default, R.string.wjk)) {
            return;
        }
        if (!oi(text2.toString())) {
            com.tencent.ecommerce.base.ui.i.f101155b.d(getString(R.string.wp_), ECToastIcon.ICON_ERROR, 0);
            return;
        }
        ECAddress eCAddress = this.originAddress;
        if (eCAddress != null) {
            DistrictInfo districtInfo = this.districtInfo;
            if (districtInfo != null) {
                String str = districtInfo.province;
                String str2 = districtInfo.city;
                String str3 = districtInfo.district;
                String street = districtInfo.getStreet();
                String obj = text.toString();
                String obj2 = text2.toString();
                Switch r16 = this.switchBtn;
                if (r16 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("switchBtn");
                }
                a16 = eCAddress.a((r26 & 1) != 0 ? eCAddress.id : 0L, (r26 & 2) != 0 ? eCAddress.province : str, (r26 & 4) != 0 ? eCAddress.city : str2, (r26 & 8) != 0 ? eCAddress.district : str3, (r26 & 16) != 0 ? eCAddress.street : street, (r26 & 32) != 0 ? eCAddress.detailAddress : replace$default, (r26 & 64) != 0 ? eCAddress.consignee : obj, (r26 & 128) != 0 ? eCAddress.phoneNumber : obj2, (r26 & 256) != 0 ? eCAddress.maskedPhoneNumber : null, (r26 & 512) != 0 ? eCAddress.isDefaultAddress : r16.isChecked(), (r26 & 1024) != 0 ? eCAddress.label : null);
                Ci(a16);
                return;
            }
            return;
        }
        DistrictInfo districtInfo2 = this.districtInfo;
        if (districtInfo2 != null) {
            String str4 = districtInfo2.province;
            String str5 = districtInfo2.city;
            String str6 = districtInfo2.district;
            String street2 = districtInfo2.getStreet();
            String obj3 = text.toString();
            String obj4 = text2.toString();
            Switch r17 = this.switchBtn;
            if (r17 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("switchBtn");
            }
            gi(new ECAddress(0L, str4, str5, str6, street2, replace$default, obj3, obj4, null, r17.isChecked(), null, 1281, null));
        }
    }

    private final void zi() {
        ECAddress a16;
        String street;
        String str;
        String str2;
        String str3;
        ECAddress eCAddress = this.originAddress;
        if (eCAddress == null) {
            eCAddress = new ECAddress(0L, "", "", "", "", "", "", "", null, false, null, 1281, null);
        }
        EditText editText = this.consigneeEditText;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("consigneeEditText");
        }
        Editable text = editText.getText();
        EditText editText2 = this.phoneNumberEditText;
        if (editText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("phoneNumberEditText");
        }
        Editable text2 = editText2.getText();
        EditText editText3 = this.detailAddressEditText;
        if (editText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailAddressEditText");
        }
        Editable text3 = editText3.getText();
        DistrictInfo districtInfo = this.districtInfo;
        String str4 = (districtInfo == null || (str3 = districtInfo.province) == null) ? "" : str3;
        String str5 = (districtInfo == null || (str2 = districtInfo.city) == null) ? "" : str2;
        String str6 = (districtInfo == null || (str = districtInfo.district) == null) ? "" : str;
        String str7 = (districtInfo == null || (street = districtInfo.getStreet()) == null) ? "" : street;
        String obj = text3.toString();
        String obj2 = text.toString();
        String obj3 = text2.toString();
        Switch r26 = this.switchBtn;
        if (r26 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("switchBtn");
        }
        a16 = r17.a((r26 & 1) != 0 ? r17.id : 0L, (r26 & 2) != 0 ? r17.province : str4, (r26 & 4) != 0 ? r17.city : str5, (r26 & 8) != 0 ? r17.district : str6, (r26 & 16) != 0 ? r17.street : str7, (r26 & 32) != 0 ? r17.detailAddress : obj, (r26 & 64) != 0 ? r17.consignee : obj2, (r26 & 128) != 0 ? r17.phoneNumber : obj3, (r26 & 256) != 0 ? r17.maskedPhoneNumber : null, (r26 & 512) != 0 ? r17.isDefaultAddress : r26.isChecked(), (r26 & 1024) != 0 ? eCAddress.label : null);
        if (Intrinsics.areEqual(eCAddress, a16)) {
            requireActivity().finish();
            return;
        }
        com.tencent.ecommerce.base.ui.g gVar = new com.tencent.ecommerce.base.ui.g(requireContext());
        gVar.Y(getResources().getString(this.originAddress == null ? R.string.wex : R.string.f169618wo2));
        gVar.e0(new Function1<View, Unit>() { // from class: com.tencent.ecommerce.biz.orders.address.ECEditAddressFragment$tryFinishActivity$$inlined$apply$lambda$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                ECEditAddressFragment.this.requireActivity().finish();
            }
        });
        gVar.show();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "hasFocus", "", "onFocusChange"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class f implements View.OnFocusChangeListener {
        f() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public final void onFocusChange(View view, boolean z16) {
            if (z16) {
                ECEditAddressFragment.Uh(ECEditAddressFragment.this).setVisibility(8);
                ECEditAddressFragment.Ph(ECEditAddressFragment.this).setVisibility(8);
            }
            ImageView Nh = ECEditAddressFragment.Nh(ECEditAddressFragment.this);
            Editable text = ECEditAddressFragment.Oh(ECEditAddressFragment.this).getText();
            Nh.setVisibility(text == null || text.length() == 0 ? 8 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "hasFocus", "", "onFocusChange"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class h implements View.OnFocusChangeListener {
        h() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public final void onFocusChange(View view, boolean z16) {
            if (z16) {
                ECEditAddressFragment.Nh(ECEditAddressFragment.this).setVisibility(8);
                ECEditAddressFragment.Ph(ECEditAddressFragment.this).setVisibility(8);
            }
            ImageView Uh = ECEditAddressFragment.Uh(ECEditAddressFragment.this);
            Editable text = ECEditAddressFragment.Vh(ECEditAddressFragment.this).getText();
            Uh.setVisibility(text == null || text.length() == 0 ? 8 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "hasFocus", "", "onFocusChange"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class i implements View.OnFocusChangeListener {
        i() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public final void onFocusChange(View view, boolean z16) {
            if (z16) {
                ECEditAddressFragment.Nh(ECEditAddressFragment.this).setVisibility(8);
                ECEditAddressFragment.Uh(ECEditAddressFragment.this).setVisibility(8);
            }
            ImageView Ph = ECEditAddressFragment.Ph(ECEditAddressFragment.this);
            Editable text = ECEditAddressFragment.Rh(ECEditAddressFragment.this).getText();
            Ph.setVisibility(text == null || text.length() == 0 ? 8 : 0);
        }
    }

    private final void initView(View view) {
        List mutableList;
        this.backBtn = (ImageView) view.findViewById(R.id.nqa);
        this.deleteBtn = (TextView) view.findViewById(R.id.f163018nv3);
        this.pasteBtn = (TextView) view.findViewById(R.id.o67);
        this.consigneeEditText = (EditText) view.findViewById(R.id.nu5);
        this.consigneeClearBtn = (ImageView) view.findViewById(R.id.nu6);
        this.phoneNumberEditText = (EditText) view.findViewById(R.id.o6l);
        this.phoneNumberClearBtn = (ImageView) view.findViewById(R.id.o6m);
        this.addressText = (TextView) view.findViewById(R.id.npj);
        this.detailAddressEditText = (EditText) view.findViewById(R.id.nv9);
        this.detailAddressClearBtn = (ImageView) view.findViewById(R.id.nv_);
        this.saveBtn = (Button) view.findViewById(R.id.npf);
        this.switchBtn = (Switch) view.findViewById(R.id.obt);
        this.districtContainer = view.findViewById(R.id.nvl);
        this.detailAddressContainer = view.findViewById(R.id.nva);
        view.findViewById(R.id.o3q).setOnClickListener(this);
        View findViewById = view.findViewById(R.id.f163048o12);
        EditText editText = this.consigneeEditText;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("consigneeEditText");
        }
        EditText editText2 = this.consigneeEditText;
        if (editText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("consigneeEditText");
        }
        String string = getResources().getString(R.string.f169612wl3);
        ImageView imageView = this.consigneeClearBtn;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("consigneeClearBtn");
        }
        editText.addTextChangedListener(new com.tencent.ecommerce.biz.orders.address.g(editText2, 20, string, imageView));
        EditText editText3 = this.consigneeEditText;
        if (editText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("consigneeEditText");
        }
        editText3.setOnLongClickListener(this.longClickListener);
        EditText editText4 = this.consigneeEditText;
        if (editText4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("consigneeEditText");
        }
        editText4.setOnFocusChangeListener(new f());
        EditText editText5 = this.phoneNumberEditText;
        if (editText5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("phoneNumberEditText");
        }
        editText5.addTextChangedListener(new g());
        EditText editText6 = this.phoneNumberEditText;
        if (editText6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("phoneNumberEditText");
        }
        editText6.setOnLongClickListener(this.longClickListener);
        EditText editText7 = this.phoneNumberEditText;
        if (editText7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("phoneNumberEditText");
        }
        editText7.setOnFocusChangeListener(new h());
        SoftKeyboardStateHelper softKeyboardStateHelper = new SoftKeyboardStateHelper(requireActivity().findViewById(android.R.id.content), false, 2, null);
        e eVar = new e(findViewById, this, findViewById);
        softKeyboardStateHelper.a(eVar);
        this.softKeyBoardStateListenerRegistry = new com.tencent.ecommerce.base.ktx.i(softKeyboardStateHelper, eVar);
        EditText editText8 = this.detailAddressEditText;
        if (editText8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailAddressEditText");
        }
        EditText editText9 = this.detailAddressEditText;
        if (editText9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailAddressEditText");
        }
        mutableList = ArraysKt___ArraysKt.toMutableList(editText9.getFilters());
        mutableList.add(new com.tencent.ecommerce.biz.comment.f(100, new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.orders.address.ECEditAddressFragment$initView$$inlined$apply$lambda$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                i.f101155b.d(ECEditAddressFragment.this.getResources().getString(R.string.f169611wl2), ECToastIcon.ICON_ERROR, 0);
            }
        }));
        Unit unit = Unit.INSTANCE;
        Object[] array = mutableList.toArray(new InputFilter[0]);
        if (array != null) {
            editText8.setFilters((InputFilter[]) array);
            EditText editText10 = this.detailAddressEditText;
            if (editText10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("detailAddressEditText");
            }
            editText10.addTextChangedListener(new d());
            EditText editText11 = this.detailAddressEditText;
            if (editText11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("detailAddressEditText");
            }
            editText11.setOnLongClickListener(this.longClickListener);
            EditText editText12 = this.detailAddressEditText;
            if (editText12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("detailAddressEditText");
            }
            editText12.setOnFocusChangeListener(new i());
            TextView textView = this.addressText;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("addressText");
            }
            textView.setOnLongClickListener(this.longClickListener);
            TextView textView2 = this.addressText;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("addressText");
            }
            textView2.setOnClickListener(this);
            ImageView imageView2 = this.backBtn;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("backBtn");
            }
            imageView2.setOnClickListener(this);
            TextView textView3 = this.deleteBtn;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("deleteBtn");
            }
            textView3.setOnClickListener(this);
            TextView textView4 = this.pasteBtn;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pasteBtn");
            }
            textView4.setOnClickListener(this);
            ImageView imageView3 = this.consigneeClearBtn;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("consigneeClearBtn");
            }
            imageView3.setOnClickListener(this);
            ImageView imageView4 = this.phoneNumberClearBtn;
            if (imageView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("phoneNumberClearBtn");
            }
            imageView4.setOnClickListener(this);
            ImageView imageView5 = this.detailAddressClearBtn;
            if (imageView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("detailAddressClearBtn");
            }
            imageView5.setOnClickListener(this);
            view.findViewById(R.id.npl).setOnClickListener(this);
            Button button = this.saveBtn;
            if (button == null) {
                Intrinsics.throwUninitializedPropertyAccessException("saveBtn");
            }
            button.setOnClickListener(this);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void xi(ECEditAddressFragment eCEditAddressFragment, View view, String str, List list, Function1 function1, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = "";
        }
        eCEditAddressFragment.wi(view, str, list, function1);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J*\u0010\f\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0016J*\u0010\u000e\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016\u00a8\u0006\u000f\u00b8\u0006\u0000"}, d2 = {"androidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1", "Landroid/text/TextWatcher;", "Landroid/text/Editable;", ReportConstant.COSTREPORT_PREFIX, "", "afterTextChanged", "", "text", "", "start", "count", "after", "beforeTextChanged", "before", "onTextChanged", "core-ktx_release"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class d implements TextWatcher {
        public d() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0027, code lost:
        
            if (r0 != false) goto L18;
         */
        /* JADX WARN: Removed duplicated region for block: B:12:0x0023  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x001c  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x001a  */
        @Override // android.text.TextWatcher
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void afterTextChanged(Editable s16) {
            boolean z16;
            boolean isBlank;
            ImageView Ph = ECEditAddressFragment.Ph(ECEditAddressFragment.this);
            boolean z17 = false;
            if (s16 != null) {
                if (s16.length() > 0) {
                    z16 = true;
                    Ph.setVisibility(!z16 ? 0 : 8);
                    if (s16 != null) {
                        isBlank = StringsKt__StringsJVMKt.isBlank(s16);
                    }
                    z17 = true;
                    if (!z17 && ECEditAddressFragment.this.shouldShowPopupWindow && ECEditAddressFragment.Xh(ECEditAddressFragment.this).isKeyboardOpened()) {
                        ECEditAddressFragment.this.ri(s16.toString());
                    }
                    ECEditAddressFragment.this.shouldShowPopupWindow = true;
                }
            }
            z16 = false;
            Ph.setVisibility(!z16 ? 0 : 8);
            if (s16 != null) {
            }
            z17 = true;
            if (!z17) {
                ECEditAddressFragment.this.ri(s16.toString());
            }
            ECEditAddressFragment.this.shouldShowPopupWindow = true;
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence text, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence text, int start, int before, int count) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J(\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\fH\u0016R\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0015"}, d2 = {"com/tencent/ecommerce/biz/orders/address/ECEditAddressFragment$g", "Landroid/text/TextWatcher;", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "count", "after", "", "beforeTextChanged", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "", "d", "Ljava/lang/String;", "preValue", "e", "I", "cursor", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class g implements TextWatcher {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private String preValue = "";

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private int cursor;

        g() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:4:0x0011, code lost:
        
            if (r0 != false) goto L6;
         */
        @Override // android.text.TextWatcher
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void afterTextChanged(Editable s16) {
            boolean startsWith$default;
            if (s16.length() > 11) {
                startsWith$default = StringsKt__StringsKt.startsWith$default((CharSequence) s16, '+', false, 2, (Object) null);
            }
            if (s16.length() <= 15) {
                ECEditAddressFragment.Uh(ECEditAddressFragment.this).setVisibility(s16.length() > 0 ? 0 : 8);
                return;
            }
            com.tencent.ecommerce.base.ui.i.f101155b.c(R.string.wl5, ECToastIcon.ICON_ERROR, 0);
            ECEditAddressFragment.Vh(ECEditAddressFragment.this).removeTextChangedListener(this);
            ECEditAddressFragment.Vh(ECEditAddressFragment.this).setText(this.preValue);
            ECEditAddressFragment.Vh(ECEditAddressFragment.this).setSelection(this.cursor);
            ECEditAddressFragment.Vh(ECEditAddressFragment.this).addTextChangedListener(this);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s16, int start, int count, int after) {
            this.preValue = s16.toString();
            this.cursor = start;
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence s16, int start, int before, int count) {
        }
    }
}
