package com.tencent.ecommerce.biz.showwindow.ui.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.RecyclerView;
import ck0.Product;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.imageloader.api.IECImageLoader;
import com.tencent.ecommerce.base.report.api.IECDataReport;
import com.tencent.ecommerce.base.router.api.IECSchemeCallback;
import com.tencent.ecommerce.base.style.service.ECPTSStyleManager;
import com.tencent.ecommerce.base.ui.ECSkin;
import com.tencent.ecommerce.base.ui.api.ECToastIcon;
import com.tencent.ecommerce.base.ui.i;
import com.tencent.ecommerce.biz.router.ECScheme;
import com.tencent.ecommerce.biz.showwindow.fragment.ECShowWindowFragment;
import com.tencent.ecommerce.biz.showwindow.viewmodel.ECShowWindowViewModel;
import com.tencent.ecommerce.biz.util.ECDebugUtils;
import com.tencent.ecommerce.biz.util.ECThreadUtilKt;
import com.tencent.ecommerce.biz.util.p;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.pts.core.PTSComposer;
import com.tencent.pts.core.itemview.PTSItemView;
import com.tencent.pts.core.lite.IPTSLiteEventListener;
import com.tencent.pts.utils.PTSDeviceUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u00b0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 t2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002uvBC\u0012\u0006\u0010a\u001a\u00020^\u0012\u0006\u0010e\u001a\u00020b\u0012\n\b\u0002\u0010i\u001a\u0004\u0018\u00010f\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010m\u001a\u00020;\u0012\u0006\u0010o\u001a\u00020;\u0012\u0006\u0010q\u001a\u00020\t\u00a2\u0006\u0004\br\u0010sJ\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u001c\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J\u001a\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0002J\"\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0002J\u0018\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002J\b\u0010\u0018\u001a\u00020\tH\u0016J\u0010\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\tH\u0016J\u000e\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\tJ\u0010\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\tH\u0016J\u000e\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0012J\u000e\u0010!\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0012J\u0014\u0010%\u001a\u00020\u00072\f\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\"J\u0018\u0010'\u001a\u00020\u00072\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\"H\u0007J\u0018\u0010+\u001a\u00020\u00022\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020\tH\u0016J\u0018\u0010-\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\tH\u0016R\u0014\u00101\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\"\u00106\u001a\u0010\u0012\f\u0012\n 3*\u0004\u0018\u00010\u00030\u0003028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00105R\u001c\u00109\u001a\b\u0012\u0004\u0012\u00020#0\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R2\u0010?\u001a\u001e\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020\t0:j\u000e\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020\t`<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010B\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0014\u0010F\u001a\u00020C8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010J\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010K\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010IR\u0018\u0010M\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010IR\u0018\u0010P\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0018\u0010S\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010RR&\u0010X\u001a\u0012\u0012\u0004\u0012\u00020\u00030Tj\b\u0012\u0004\u0012\u00020\u0003`U8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010\u001e\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010ZR\u0016\u0010 \u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010ZR\u0016\u0010]\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010ZR\u0014\u0010a\u001a\u00020^8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b_\u0010`R\u0014\u0010e\u001a\u00020b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bc\u0010dR\u0016\u0010i\u001a\u0004\u0018\u00010f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bg\u0010hR\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bj\u0010ZR\u0014\u0010m\u001a\u00020;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bk\u0010lR\u0014\u0010o\u001a\u00020;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bn\u0010lR\u0014\u0010q\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bp\u0010A\u00a8\u0006w"}, d2 = {"Lcom/tencent/ecommerce/biz/showwindow/ui/adapter/ECShowWindowProductListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/ecommerce/biz/showwindow/ui/adapter/d;", "Lck0/c;", "product", "Landroid/view/View;", "view", "", "D0", "", "index", "", "", "s0", "productItemViewHolder", "E0", "productItemView", "C0", "", "isMaster", "y0", "x0", "Lcom/tencent/pts/core/lite/IPTSLiteEventListener;", "u0", "getItemCount", "position", "getItemViewType", "t0", "", "getItemId", "isLoadingMore", "B0", "isEndMoreData", "z0", "", "Lck0/a;", "bannerList", "A0", "productList", "setData", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "w0", "holder", "v0", "Lcom/tencent/ecommerce/biz/showwindow/ui/adapter/c;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/ecommerce/biz/showwindow/ui/adapter/c;", "diffCallback", "Landroidx/recyclerview/widget/AsyncListDiffer;", "kotlin.jvm.PlatformType", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/recyclerview/widget/AsyncListDiffer;", "differ", "D", "Ljava/util/List;", "headerBannerInfo", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "E", "Ljava/util/HashMap;", "pageNameToViewTypeMap", UserInfo.SEX_FEMALE, "I", "viewTypeCountTotal", "Landroid/view/LayoutInflater;", "G", "Landroid/view/LayoutInflater;", "inflater", "Landroid/graphics/drawable/Drawable;", "H", "Landroid/graphics/drawable/Drawable;", "disableDrawable", "selectedDrawable", "J", "unSelectedDrawable", "K", "Ljava/lang/Boolean;", "hasEdited", "L", "Lcom/tencent/pts/core/lite/IPTSLiteEventListener;", "ptsLiteEventListener", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "M", "Ljava/util/ArrayList;", "productDataList", "N", "Z", "P", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "hasBannerReportExp", "Landroid/content/Context;", BdhLogUtil.LogTag.Tag_Req, "Landroid/content/Context;", "context", "Lcom/tencent/ecommerce/biz/showwindow/viewmodel/ECShowWindowViewModel;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/ecommerce/biz/showwindow/viewmodel/ECShowWindowViewModel;", "viewModel", "Lcom/tencent/ecommerce/base/router/api/IECSchemeCallback;", "T", "Lcom/tencent/ecommerce/base/router/api/IECSchemeCallback;", "deliverProductCallback", "U", "V", "Ljava/lang/String;", WadlProxyConsts.CHANNEL, "W", "mediaId", "X", "windowType", "<init>", "(Landroid/content/Context;Lcom/tencent/ecommerce/biz/showwindow/viewmodel/ECShowWindowViewModel;Lcom/tencent/ecommerce/base/router/api/IECSchemeCallback;ZLjava/lang/String;Ljava/lang/String;I)V", "Y", "a", "b", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECShowWindowProductListAdapter extends RecyclerView.Adapter<com.tencent.ecommerce.biz.showwindow.ui.adapter.d> {

    /* renamed from: C, reason: from kotlin metadata */
    private final AsyncListDiffer<Product> differ;

    /* renamed from: D, reason: from kotlin metadata */
    private List<ck0.a> headerBannerInfo;

    /* renamed from: E, reason: from kotlin metadata */
    private HashMap<String, Integer> pageNameToViewTypeMap;

    /* renamed from: F, reason: from kotlin metadata */
    private int viewTypeCountTotal;

    /* renamed from: G, reason: from kotlin metadata */
    private final LayoutInflater inflater;

    /* renamed from: H, reason: from kotlin metadata */
    private Drawable disableDrawable;

    /* renamed from: I, reason: from kotlin metadata */
    private Drawable selectedDrawable;

    /* renamed from: J, reason: from kotlin metadata */
    private Drawable unSelectedDrawable;

    /* renamed from: K, reason: from kotlin metadata */
    private Boolean hasEdited;

    /* renamed from: L, reason: from kotlin metadata */
    private IPTSLiteEventListener ptsLiteEventListener;

    /* renamed from: M, reason: from kotlin metadata */
    private ArrayList<Product> productDataList;

    /* renamed from: N, reason: from kotlin metadata */
    private boolean isLoadingMore;

    /* renamed from: P, reason: from kotlin metadata */
    private boolean isEndMoreData;

    /* renamed from: Q, reason: from kotlin metadata */
    private boolean hasBannerReportExp;

    /* renamed from: R, reason: from kotlin metadata */
    private final Context context;

    /* renamed from: S, reason: from kotlin metadata */
    private final ECShowWindowViewModel viewModel;

    /* renamed from: T, reason: from kotlin metadata */
    private final IECSchemeCallback deliverProductCallback;

    /* renamed from: U, reason: from kotlin metadata */
    private final boolean isMaster;

    /* renamed from: V, reason: from kotlin metadata */
    private final String channel;

    /* renamed from: W, reason: from kotlin metadata */
    private final String mediaId;

    /* renamed from: X, reason: from kotlin metadata */
    private final int windowType;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.ecommerce.biz.showwindow.ui.adapter.c diffCallback;

    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001BC\u0012\u0016\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\u0012j\b\u0012\u0004\u0012\u00020\u000e`\u0013\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001a\u0012\u0006\u0010'\u001a\u00020!\u0012\u0006\u0010*\u001a\u00020\u0002\u0012\u0006\u0010,\u001a\u00020\u0002\u00a2\u0006\u0004\b-\u0010.JN\u0010\f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022&\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002JN\u0010\r\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022&\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002JN\u0010\u0011\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022&\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016R2\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\u0012j\b\u0012\u0004\u0012\u00020\u000e`\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010 \u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010'\u001a\u00020!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0014\u0010*\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010,\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010)\u00a8\u0006/"}, d2 = {"Lcom/tencent/ecommerce/biz/showwindow/ui/adapter/ECShowWindowProductListAdapter$b;", "Lcom/tencent/ecommerce/base/ui/e;", "", "id", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "dataMap", "Landroid/view/View;", "view", "Lcom/tencent/pts/core/PTSComposer;", "ptsComposer", "", "a", "b", "Lck0/c;", "product", "c", "onTapEventTriggered", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "getProductDataList", "()Ljava/util/ArrayList;", "setProductDataList", "(Ljava/util/ArrayList;)V", "productDataList", "Lcom/tencent/ecommerce/base/router/api/IECSchemeCallback;", "Lcom/tencent/ecommerce/base/router/api/IECSchemeCallback;", "getDeliverProductCallback", "()Lcom/tencent/ecommerce/base/router/api/IECSchemeCallback;", "setDeliverProductCallback", "(Lcom/tencent/ecommerce/base/router/api/IECSchemeCallback;)V", "deliverProductCallback", "Landroid/content/Context;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "context", "d", "Ljava/lang/String;", WadlProxyConsts.CHANNEL, "e", "mediaId", "<init>", "(Ljava/util/ArrayList;Lcom/tencent/ecommerce/base/router/api/IECSchemeCallback;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b extends com.tencent.ecommerce.base.ui.e {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private ArrayList<Product> productDataList;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private IECSchemeCallback deliverProductCallback;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private Context context;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        public final String channel;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        public final String mediaId;

        public b(ArrayList<Product> arrayList, IECSchemeCallback iECSchemeCallback, Context context, String str, String str2) {
            this.productDataList = arrayList;
            this.deliverProductCallback = iECSchemeCallback;
            this.context = context;
            this.channel = str;
            this.mediaId = str2;
        }

        private final void a(String id5, HashMap<String, String> dataMap, View view, PTSComposer ptsComposer) {
            Iterator<Product> it = this.productDataList.iterator();
            while (it.hasNext()) {
                Product next = it.next();
                if (TextUtils.equals(next.getMediaProductId(), id5)) {
                    i.f101155b.d(this.context.getResources().getString(R.string.wf6), ECToastIcon.ICON_SUCCESS, 0);
                    cg0.a.b("ECShowWindowProductListAdapter", "[handleAddBtnClick] id = " + id5 + ", saasProductId = " + next.getSaasProductId() + ", title = " + next.getTitle());
                    IECSchemeCallback iECSchemeCallback = this.deliverProductCallback;
                    if (iECSchemeCallback != null) {
                        JSONObject dataJson = next.getDataJson();
                        if (dataJson == null) {
                            dataJson = new JSONObject();
                        }
                        iECSchemeCallback.onCallbackFinished(dataJson);
                    }
                    c(next);
                    Context context = this.context;
                    if (context instanceof Activity) {
                        if (context != null) {
                            ((Activity) context).finish();
                            return;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
                    }
                    return;
                }
            }
        }

        private final void b(String id5, HashMap<String, String> dataMap, View view, PTSComposer ptsComposer) {
            Product product;
            Map<Object, Object> emptyMap;
            Iterator<Product> it = this.productDataList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    product = null;
                    break;
                }
                product = it.next();
                if (TextUtils.equals(product.getMediaProductId(), id5)) {
                    cg0.a.b("ECShowWindowProductListAdapter", "[handleAllInOneJump] id = " + id5 + ", saasProductId = " + product.getSaasProductId() + ", title = " + product.getTitle());
                    break;
                }
            }
            String str = dataMap != null ? dataMap.get(WadlProxyConsts.KEY_JUMP_URL) : null;
            cg0.a.b("ECShowWindowProductListAdapter", "[handleAllInOneJump] id = " + id5 + ", jumpUrl = " + str);
            if (str != null) {
                if (product == null) {
                    emptyMap = MapsKt__MapsKt.emptyMap();
                } else {
                    emptyMap = zh0.a.f452541a.b(str, this.mediaId, product);
                }
                ECScheme.e(str, emptyMap);
            }
        }

        private final void c(Product product) {
            com.tencent.ecommerce.biz.common.d.f101554a.e(this.channel, product, "window_goods_card_stockup", (r18 & 8) != 0 ? "" : null, (r18 & 16) != 0 ? "" : null, (r18 & 32) != 0 ? 1 : 0, (r18 & 64) != 0 ? null : null);
        }

        @Override // com.tencent.pts.core.lite.IPTSLiteEventListener
        public void onTapEventTriggered(String id5, HashMap<String, String> dataMap, View view, PTSComposer ptsComposer) {
            cg0.a.b("ECShowWindowProductListAdapter", "[onTapEventTriggered] id = " + id5);
            if (Intrinsics.areEqual("addProduct", dataMap != null ? dataMap.get("eventType") : null)) {
                a(id5, dataMap, view, ptsComposer);
                return;
            }
            if (Intrinsics.areEqual("allInOneJump", dataMap != null ? dataMap.get("eventType") : null)) {
                b(id5, dataMap, view, ptsComposer);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c implements View.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Product f104741e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ com.tencent.ecommerce.biz.showwindow.ui.adapter.d f104742f;

        c(Product product, com.tencent.ecommerce.biz.showwindow.ui.adapter.d dVar) {
            this.f104741e = product;
            this.f104742f = dVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ImageView selectedIconView;
            ImageView selectedIconView2;
            ImageView selectedIconView3;
            if (this.f104741e.getEditable()) {
                com.tencent.ecommerce.biz.showwindow.ui.adapter.d dVar = this.f104742f;
                if (dVar == null || (selectedIconView = dVar.getSelectedIconView()) == null || !selectedIconView.isEnabled()) {
                    return;
                }
                if (!this.f104741e.getSelected()) {
                    com.tencent.ecommerce.biz.showwindow.ui.adapter.d dVar2 = this.f104742f;
                    if (dVar2 != null && (selectedIconView3 = dVar2.getSelectedIconView()) != null) {
                        selectedIconView3.setImageDrawable(ECShowWindowProductListAdapter.this.selectedDrawable);
                    }
                } else {
                    com.tencent.ecommerce.biz.showwindow.ui.adapter.d dVar3 = this.f104742f;
                    if (dVar3 != null && (selectedIconView2 = dVar3.getSelectedIconView()) != null) {
                        selectedIconView2.setImageDrawable(ECShowWindowProductListAdapter.this.unSelectedDrawable);
                    }
                }
                ECShowWindowViewModel eCShowWindowViewModel = ECShowWindowProductListAdapter.this.viewModel;
                Product product = this.f104741e;
                eCShowWindowViewModel.d3(product, true ^ product.getSelected());
                return;
            }
            String detailUrl = this.f104741e.getDetailUrl();
            cg0.a.b("ECShowWindowProductListAdapter", "[clickItem] jumpUrl = " + detailUrl);
            ECScheme.e(detailUrl, zh0.a.f452541a.b(detailUrl, ECShowWindowProductListAdapter.this.mediaId, this.f104741e));
            ECShowWindowProductListAdapter eCShowWindowProductListAdapter = ECShowWindowProductListAdapter.this;
            eCShowWindowProductListAdapter.x0(eCShowWindowProductListAdapter.isMaster, this.f104741e);
            ECDebugUtils.f104852b.d(ECShowWindowProductListAdapter.this.context, this.f104741e);
            if (ECShowWindowProductListAdapter.this.isMaster) {
                return;
            }
            com.tencent.ecommerce.biz.common.c.f101553a.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK, "com/tencent/ecommerce/biz/showwindow/ui/adapter/ECShowWindowProductListAdapter$updateHeaderBannerViewUI$1$4"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class d implements View.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ LinearLayout f104744e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ double f104745f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ double f104746h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ ck0.a f104747i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ int f104748m;

        d(LinearLayout linearLayout, double d16, double d17, ck0.a aVar, int i3) {
            this.f104744e = linearLayout;
            this.f104745f = d16;
            this.f104746h = d17;
            this.f104747i = aVar;
            this.f104748m = i3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QQEcommerceSdk.jumpScheme(this.f104747i.getUrl());
            IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "wzwindow_banner_entry_clk", ECShowWindowProductListAdapter.this.s0(this.f104748m), false, 4, null);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public ECShowWindowProductListAdapter(Context context, ECShowWindowViewModel eCShowWindowViewModel, IECSchemeCallback iECSchemeCallback, boolean z16, String str, String str2, int i3) {
        this.context = context;
        this.viewModel = eCShowWindowViewModel;
        this.deliverProductCallback = iECSchemeCallback;
        this.isMaster = z16;
        this.channel = str;
        this.mediaId = str2;
        this.windowType = i3;
        com.tencent.ecommerce.biz.showwindow.ui.adapter.c cVar = new com.tencent.ecommerce.biz.showwindow.ui.adapter.c();
        this.diffCallback = cVar;
        this.differ = new AsyncListDiffer<>(this, cVar);
        this.headerBannerInfo = new ArrayList();
        this.pageNameToViewTypeMap = ECPTSStyleManager.f100993b.d(1);
        this.viewTypeCountTotal = 1;
        Object systemService = context.getSystemService("layout_inflater");
        if (systemService != null) {
            this.inflater = (LayoutInflater) systemService;
            this.hasEdited = Boolean.FALSE;
            this.productDataList = new ArrayList<>();
            this.viewTypeCountTotal += this.pageNameToViewTypeMap.size();
            ECSkin eCSkin = ECSkin.INSTANCE;
            this.disableDrawable = eCSkin.getDrawable(R.drawable.e6w);
            this.selectedDrawable = eCSkin.getDrawable(R.drawable.e6v);
            this.unSelectedDrawable = eCSkin.getDrawable(R.drawable.e5s);
            cg0.a.b("ECShowWindowProductListAdapter", "[init] viewTypeNativeCount = 0, viewTypeCountTotal = " + this.viewTypeCountTotal);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.LayoutInflater");
    }

    private final void C0(Product product, View productItemView, com.tencent.ecommerce.biz.showwindow.ui.adapter.d productItemViewHolder) {
        productItemView.setOnClickListener(new c(product, productItemViewHolder));
    }

    private final void E0(Product product, com.tencent.ecommerce.biz.showwindow.ui.adapter.d productItemViewHolder) {
        ImageView selectedIconView;
        if (this.isMaster) {
            if (product.getEditable()) {
                ImageView selectedIconView2 = productItemViewHolder != null ? productItemViewHolder.getSelectedIconView() : null;
                if (selectedIconView2 != null) {
                    selectedIconView2.setEnabled(true);
                }
                if (selectedIconView2 != null && selectedIconView2.getVisibility() != 0) {
                    selectedIconView2.setVisibility(0);
                }
                if (!ECShowWindowFragment.INSTANCE.a(this.windowType) || (product.getState() == 1 && product.getInventory() > 0)) {
                    if (selectedIconView2 != null) {
                        selectedIconView2.setEnabled(true);
                    }
                    if (product.getSelected()) {
                        if (selectedIconView2 != null) {
                            selectedIconView2.setImageDrawable(this.selectedDrawable);
                        }
                    } else if (selectedIconView2 != null) {
                        selectedIconView2.setImageDrawable(this.unSelectedDrawable);
                    }
                } else {
                    if (selectedIconView2 != null) {
                        selectedIconView2.setEnabled(false);
                    }
                    if (selectedIconView2 != null) {
                        selectedIconView2.setImageDrawable(this.disableDrawable);
                    }
                }
            } else if (productItemViewHolder != null && (selectedIconView = productItemViewHolder.getSelectedIconView()) != null && selectedIconView.getVisibility() != 8) {
                selectedIconView.setVisibility(8);
            }
        }
        if (productItemViewHolder != null) {
            View view = productItemViewHolder.itView;
            if (view != null) {
                LinearLayout linearLayout = (LinearLayout) view;
                Object tag = linearLayout.getTag();
                if (tag != null) {
                    linearLayout.removeView((View) tag);
                }
                PTSItemView pTSItemView = new PTSItemView(linearLayout.getContext());
                pTSItemView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                linearLayout.addView(pTSItemView);
                linearLayout.setTag(pTSItemView);
                PTSComposer ptsComposer = product.getPtsComposer();
                if (ptsComposer != null) {
                    ptsComposer.layoutToView(pTSItemView, u0());
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<Object, Object> s0(int index) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("bus_id", 2);
        linkedHashMap.put("uin", String.valueOf(QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getAccountManager().getCurrentAccount()));
        linkedHashMap.put("entry", Integer.valueOf(index + 1));
        return linkedHashMap;
    }

    private final IPTSLiteEventListener u0() {
        if (this.ptsLiteEventListener == null) {
            this.ptsLiteEventListener = new b(this.productDataList, this.deliverProductCallback, this.context, this.channel, this.mediaId);
        }
        return this.ptsLiteEventListener;
    }

    public final void A0(List<ck0.a> bannerList) {
        this.headerBannerInfo = bannerList;
    }

    public final void B0(boolean isLoadingMore) {
        this.isLoadingMore = isLoadingMore;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.differ.getCurrentList().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        return position;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        Product product = this.differ.getCurrentList().get(position);
        if (product.getViewType() == Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (product.getViewType() == 1) {
            return 1;
        }
        return product.getViewType();
    }

    public final Product t0(int position) {
        return this.differ.getCurrentList().get(position);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: v0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(final com.tencent.ecommerce.biz.showwindow.ui.adapter.d holder, int position) {
        if (getItemViewType(position) == 1) {
            D0(t0(position), holder.itView);
            return;
        }
        if (getItemViewType(position) == Integer.MAX_VALUE) {
            TextView textView = (TextView) holder.itView.findViewById(R.id.ofo);
            if (this.isLoadingMore) {
                textView.setText(this.context.getResources().getString(R.string.wnv));
                return;
            } else {
                if (this.isEndMoreData) {
                    textView.setText(this.context.getResources().getString(R.string.wog));
                    return;
                }
                return;
            }
        }
        final Product t06 = t0(position);
        cg0.a.b("ECShowWindowProductListAdapter", "setUpClickListener position=" + position + ", product=" + System.identityHashCode(t06));
        C0(t06, holder.itView, holder);
        E0(t06, holder);
        if (t06.getHasExposedAndPreload()) {
            return;
        }
        ECThreadUtilKt.a(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.showwindow.ui.adapter.ECShowWindowProductListAdapter$onBindViewHolder$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                int i3;
                int i16;
                ECShowWindowProductListAdapter eCShowWindowProductListAdapter = ECShowWindowProductListAdapter.this;
                eCShowWindowProductListAdapter.y0(eCShowWindowProductListAdapter.isMaster, t06);
                ECShowWindowFragment.Companion companion = ECShowWindowFragment.INSTANCE;
                i3 = ECShowWindowProductListAdapter.this.windowType;
                if (companion.a(i3)) {
                    ei0.c cVar = ei0.c.f396302a;
                    View view = holder.itView;
                    Product product = t06;
                    i16 = ECShowWindowProductListAdapter.this.windowType;
                    cVar.n(view, product, i16);
                }
            }
        });
        t06.N(true);
    }

    public final void z0(boolean isEndMoreData) {
        this.isEndMoreData = isEndMoreData;
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002#\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001j\u0002`\u0007J\u0013\u0010\b\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0096\u0002\u00a8\u0006\t"}, d2 = {"com/tencent/ecommerce/biz/showwindow/ui/adapter/ECShowWindowProductListAdapter$e", "Lkotlin/Function1;", "Landroid/graphics/drawable/Drawable;", "Lkotlin/ParameterName;", "name", "drawable", "", "Lcom/tencent/ecommerce/base/imageloader/api/Callback;", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class e implements Function1<Drawable, Unit> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ LinearLayout f104749d;

        e(LinearLayout linearLayout) {
            this.f104749d = linearLayout;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Drawable drawable) {
            a(drawable);
            return Unit.INSTANCE;
        }

        public void a(Drawable drawable) {
            if (drawable != null) {
                this.f104749d.setBackground(drawable);
            }
        }
    }

    public final void setData(List<Product> productList) {
        this.productDataList.clear();
        if (productList != null) {
            List<Product> list = productList;
            if (!list.isEmpty()) {
                if (!this.headerBannerInfo.isEmpty()) {
                    this.productDataList.add(new Product(null, null, null, null, 0L, 0L, 0L, 0L, 0.0d, 0L, 0L, 0L, 0L, 0L, 0L, null, null, null, false, null, null, null, false, false, null, false, false, false, 0, null, false, false, false, 0, null, false, null, null, 1, false, false, null, this.headerBannerInfo, -1, 959, null));
                }
                this.productDataList.addAll(list);
                this.productDataList.add(new Product(null, null, null, null, 0L, 0L, 0L, 0L, 0.0d, 0L, 0L, 0L, 0L, 0L, 0L, null, null, null, false, null, null, null, false, false, null, false, false, false, 0, null, false, false, false, 0, null, false, null, null, Integer.MAX_VALUE, false, false, null, null, -1, 1983, null));
            }
        }
        Boolean value = this.viewModel.s2().getValue();
        boolean booleanValue = value != null ? value.booleanValue() : false;
        if ((!Intrinsics.areEqual(Boolean.valueOf(booleanValue), this.hasEdited)) && !ECShowWindowFragment.INSTANCE.a(this.windowType)) {
            this.hasEdited = Boolean.valueOf(booleanValue);
            notifyDataSetChanged();
        } else {
            this.differ.submitList(new ArrayList(this.productDataList));
        }
    }

    private final void D0(Product product, View view) {
        List listOf;
        int i3;
        if (product.l().size() <= 2) {
            int i16 = 0;
            boolean z16 = true;
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new LinearLayout[]{(LinearLayout) view.findViewById(R.id.o2j), (LinearLayout) view.findViewById(R.id.f163095o94)});
            double screenWidthPx = PTSDeviceUtil.getScreenWidthPx() * 0.44666666666666666d;
            double d16 = (60 * screenWidthPx) / 167.5d;
            int size = product.l().size();
            int i17 = 0;
            while (i17 < size) {
                ck0.a aVar = product.l().get(i17);
                LinearLayout linearLayout = (LinearLayout) listOf.get(i17);
                linearLayout.setVisibility(i16);
                linearLayout.getLayoutParams().height = (int) d16;
                linearLayout.getLayoutParams().width = (int) screenWidthPx;
                TextView textView = (TextView) linearLayout.findViewById(R.id.nqd);
                textView.setText(aVar.title);
                textView.setTextSize(i16, (PTSDeviceUtil.getScreenWidthPx() / 375.0f) * 14.0f);
                TextView textView2 = (TextView) linearLayout.findViewById(R.id.nqc);
                textView2.setText(aVar.desc);
                textView2.setTextSize(i16, (PTSDeviceUtil.getScreenWidthPx() / 375.0f) * 10.0f);
                IECImageLoader.a.a(QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getImageLoader(), linearLayout.getContext(), p.f104878a.a(aVar.pic), null, new e(linearLayout), 4, null);
                int i18 = i17;
                double d17 = d16;
                linearLayout.setOnClickListener(new d(linearLayout, d16, screenWidthPx, aVar, i18));
                if (this.hasBannerReportExp) {
                    i3 = i18;
                } else {
                    i3 = i18;
                    IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "wzwindow_banner_entry_exp", s0(i3), false, 4, null);
                }
                i17 = i3 + 1;
                d16 = d17;
                i16 = 0;
                z16 = true;
            }
            this.hasBannerReportExp = z16;
            return;
        }
        cg0.a.a("ECShowWindowProductListAdapter", "updateHeaderBannerViewUI", "error, headerBannerInfo.size = " + product.l().size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x0(boolean isMaster, Product product) {
        if (isMaster) {
            com.tencent.ecommerce.biz.common.d.f101554a.e(this.channel, product, "window_goods_card_clk", (r18 & 8) != 0 ? "" : null, (r18 & 16) != 0 ? "" : null, (r18 & 32) != 0 ? 1 : this.windowType, (r18 & 64) != 0 ? null : null);
        } else {
            com.tencent.ecommerce.biz.common.d.f101554a.e(this.channel, product, "window_goods_card_clk_by_customer", (r18 & 8) != 0 ? "" : this.mediaId, (r18 & 16) != 0 ? "" : null, (r18 & 32) != 0 ? 1 : 0, (r18 & 64) != 0 ? null : null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y0(boolean isMaster, Product product) {
        if (isMaster) {
            com.tencent.ecommerce.biz.common.d.f101554a.e(this.channel, product, "window_goods_card_exp", (r18 & 8) != 0 ? "" : null, (r18 & 16) != 0 ? "" : null, (r18 & 32) != 0 ? 1 : this.windowType, (r18 & 64) != 0 ? null : null);
        } else {
            com.tencent.ecommerce.biz.common.d.f101554a.e(this.channel, product, "window_goods_card_exp_to_customer", (r18 & 8) != 0 ? "" : this.mediaId, (r18 & 16) != 0 ? "" : null, (r18 & 32) != 0 ? 1 : 0, (r18 & 64) != 0 ? null : null);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: w0, reason: merged with bridge method [inline-methods] */
    public com.tencent.ecommerce.biz.showwindow.ui.adapter.d onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 1) {
            View inflate = this.inflater.inflate(R.layout.ct9, (ViewGroup) null, false);
            if (inflate != null) {
                return new com.tencent.ecommerce.biz.showwindow.ui.adapter.d((RelativeLayout) inflate, null);
            }
            throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout");
        }
        if (viewType == 0) {
            View inflate2 = this.inflater.inflate(R.layout.ct8, (ViewGroup) null, false);
            if (inflate2 != null) {
                LinearLayout linearLayout = (LinearLayout) inflate2;
                return new com.tencent.ecommerce.biz.showwindow.ui.adapter.d(linearLayout, (ImageView) linearLayout.findViewById(R.id.o_n));
            }
            throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout");
        }
        return new com.tencent.ecommerce.biz.showwindow.ui.adapter.d(this.inflater.inflate(R.layout.crw, (ViewGroup) null, false), null);
    }
}
