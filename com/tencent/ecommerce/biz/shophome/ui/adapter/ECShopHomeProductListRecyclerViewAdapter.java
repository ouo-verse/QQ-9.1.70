package com.tencent.ecommerce.biz.shophome.ui.adapter;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.cache.service.PtsComposerCache;
import com.tencent.ecommerce.base.imageloader.api.IECImageLoader;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.ecommerce.base.ui.ECSkin;
import com.tencent.ecommerce.biz.shophome.fragment.ECShopHomeFragment;
import com.tencent.ecommerce.biz.shophome.model.ECOrderByTabInfo;
import com.tencent.ecommerce.biz.shophome.model.ECShopProductInfo;
import com.tencent.ecommerce.biz.shophome.ui.view.ECShopCardView;
import com.tencent.ecommerce.biz.shophome.util.ECShopHomePageType;
import com.tencent.ecommerce.biz.shophome.util.ECShopHomeScene;
import com.tencent.ecommerce.biz.shophome.util.ECShopReportParams;
import com.tencent.ecommerce.biz.util.ECThreadUtilKt;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.pts.core.PTSComposer;
import com.tencent.pts.core.lite.IPTSLiteEventListener;
import com.tencent.pts.utils.PTSDeviceUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u00ae\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u0080\u00012\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0081\u0001B!\u0012\u0006\u0010s\u001a\u000207\u0012\b\u0010w\u001a\u0004\u0018\u00010t\u0012\u0006\u0010}\u001a\u00020x\u00a2\u0006\u0004\b~\u0010\u007fJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005H\u0002J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J$\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u00102\u0006\u0010\u000f\u001a\u00020\r2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010H\u0002J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0002J\b\u0010\u0018\u001a\u00020\u0003H\u0002J\b\u0010\u0019\u001a\u00020\rH\u0002J\u0010\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0016H\u0007J\u0018\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u0003H\u0017J\u0018\u0010!\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\"\u001a\u00020\u0003H\u0016J\u0010\u0010#\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010&\u001a\u00020\n2\u0006\u0010%\u001a\u00020$H\u0016J\u001e\u0010(\u001a\u00020\n2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00050\u00102\b\b\u0002\u0010\u000f\u001a\u00020\rJ\u0006\u0010)\u001a\u00020\nR\u0014\u0010,\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010.\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010+R\u0014\u00101\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0014\u00103\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u0010+R\u0014\u00105\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00100R\u001a\u0010:\u001a\b\u0012\u0004\u0012\u000207068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00109R$\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00050;j\b\u0012\u0004\u0012\u00020\u0005`<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u0010>R \u0010B\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00160?8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b@\u0010AR*\u0010J\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010C8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\"\u0010P\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bK\u0010@\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u0016\u0010R\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010@R\u0016\u0010T\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010@R$\u0010\\\u001a\u0004\u0018\u00010U8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\"\u0010d\u001a\u00020]8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b^\u0010_\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR\"\u0010l\u001a\u00020e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bf\u0010g\u001a\u0004\bh\u0010i\"\u0004\bj\u0010kR \u0010p\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00050m8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bn\u0010oR\u0014\u0010s\u001a\u0002078\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\bq\u0010rR\u0016\u0010w\u001a\u0004\u0018\u00010t8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\bu\u0010vR\u0017\u0010}\u001a\u00020x8\u0006\u00a2\u0006\f\n\u0004\by\u0010z\u001a\u0004\b{\u0010|\u00a8\u0006\u0082\u0001"}, d2 = {"Lcom/tencent/ecommerce/biz/shophome/ui/adapter/ECShopHomeProductListRecyclerViewAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "position", "Lcom/tencent/ecommerce/biz/shophome/model/c;", "z0", "Lcom/tencent/ecommerce/biz/shophome/ui/adapter/k;", "viewHolder", "productInfo", "", "L0", "s0", "", "C0", "showNoMoreData", "", "productDataList", "r0", "B0", "Lcom/tencent/pts/core/lite/IPTSLiteEventListener;", "E0", "", "v0", "w0", "D0", "saasProductId", "M0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "onCreateViewHolder", "holder", "onBindViewHolder", "getItemCount", "getItemViewType", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "onAttachedToRecyclerView", "newProductDataList", "J0", "t0", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/String;", "adClickId", BdhLogUtil.LogTag.Tag_Conn, "_isSelect", "D", "Z", "isSelectHost", "E", "_isDistribution", UserInfo.SEX_FEMALE, "isDistribution", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "G", "Ljava/lang/ref/WeakReference;", "weakReference", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "H", "Ljava/util/ArrayList;", "Lcom/tencent/ecommerce/base/cache/service/PtsComposerCache;", "I", "Lcom/tencent/ecommerce/base/cache/service/PtsComposerCache;", "ptsComposerCacheManager", "Lkotlin/Function0;", "J", "Lkotlin/jvm/functions/Function0;", "A0", "()Lkotlin/jvm/functions/Function0;", "K0", "(Lkotlin/jvm/functions/Function0;)V", "onPreload", "K", "getPreloadItemCount", "()I", "setPreloadItemCount", "(I)V", "preloadItemCount", "L", HippyTKDListViewAdapter.SCROLL_STATE, "M", "footerCount", "Lcom/tencent/ecommerce/biz/shophome/model/a;", "N", "Lcom/tencent/ecommerce/biz/shophome/model/a;", "getCurrentOrderTabInfo", "()Lcom/tencent/ecommerce/biz/shophome/model/a;", "F0", "(Lcom/tencent/ecommerce/biz/shophome/model/a;)V", "currentOrderTabInfo", "Lcom/tencent/ecommerce/biz/shophome/util/ECShopHomeScene;", "P", "Lcom/tencent/ecommerce/biz/shophome/util/ECShopHomeScene;", "y0", "()Lcom/tencent/ecommerce/biz/shophome/util/ECShopHomeScene;", "I0", "(Lcom/tencent/ecommerce/biz/shophome/util/ECShopHomeScene;)V", "currentScene", "Lcom/tencent/ecommerce/biz/shophome/util/ECShopHomePageType;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/ecommerce/biz/shophome/util/ECShopHomePageType;", "x0", "()Lcom/tencent/ecommerce/biz/shophome/util/ECShopHomePageType;", "H0", "(Lcom/tencent/ecommerce/biz/shophome/util/ECShopHomePageType;)V", "currentPageType", "", BdhLogUtil.LogTag.Tag_Req, "Ljava/util/Map;", "productIdMap", ExifInterface.LATITUDE_SOUTH, "Landroid/app/Activity;", "context", "Landroid/os/Bundle;", "T", "Landroid/os/Bundle;", "arguments", "Lcom/tencent/ecommerce/biz/shophome/ui/adapter/ECShopHomeProductCardCallback;", "U", "Lcom/tencent/ecommerce/biz/shophome/ui/adapter/ECShopHomeProductCardCallback;", "u0", "()Lcom/tencent/ecommerce/biz/shophome/ui/adapter/ECShopHomeProductCardCallback;", "callback", "<init>", "(Landroid/app/Activity;Landroid/os/Bundle;Lcom/tencent/ecommerce/biz/shophome/ui/adapter/ECShopHomeProductCardCallback;)V", "V", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECShopHomeProductListRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: C, reason: from kotlin metadata */
    private final String _isSelect;

    /* renamed from: D, reason: from kotlin metadata */
    private final boolean isSelectHost;

    /* renamed from: E, reason: from kotlin metadata */
    private final String _isDistribution;

    /* renamed from: F, reason: from kotlin metadata */
    private final boolean isDistribution;

    /* renamed from: G, reason: from kotlin metadata */
    private final WeakReference<Activity> weakReference;

    /* renamed from: H, reason: from kotlin metadata */
    private final ArrayList<ECShopProductInfo> productDataList;

    /* renamed from: I, reason: from kotlin metadata */
    private final PtsComposerCache<ECShopProductInfo, String> ptsComposerCacheManager;

    /* renamed from: J, reason: from kotlin metadata */
    private Function0<Unit> onPreload;

    /* renamed from: K, reason: from kotlin metadata */
    private int preloadItemCount;

    /* renamed from: L, reason: from kotlin metadata */
    private int scrollState;

    /* renamed from: M, reason: from kotlin metadata */
    private int footerCount;

    /* renamed from: N, reason: from kotlin metadata */
    private ECOrderByTabInfo currentOrderTabInfo;

    /* renamed from: P, reason: from kotlin metadata */
    private ECShopHomeScene currentScene;

    /* renamed from: Q, reason: from kotlin metadata */
    private ECShopHomePageType currentPageType;

    /* renamed from: R, reason: from kotlin metadata */
    private final Map<String, ECShopProductInfo> productIdMap;

    /* renamed from: S, reason: from kotlin metadata */
    public final Activity context;

    /* renamed from: T, reason: from kotlin metadata */
    public final Bundle arguments;

    /* renamed from: U, reason: from kotlin metadata */
    private final ECShopHomeProductCardCallback callback;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final String adClickId;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/ecommerce/biz/shophome/ui/adapter/ECShopHomeProductListRecyclerViewAdapter$b", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b extends RecyclerView.OnScrollListener {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            Function0<Unit> A0;
            super.onScrollStateChanged(recyclerView, newState);
            ECShopHomeProductListRecyclerViewAdapter.this.scrollState = newState;
            if (recyclerView.canScrollVertically(1) || (A0 = ECShopHomeProductListRecyclerViewAdapter.this.A0()) == null) {
                return;
            }
            A0.invoke();
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002#\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001j\u0002`\u0007J\u0013\u0010\b\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0096\u0002\u00a8\u0006\t"}, d2 = {"com/tencent/ecommerce/biz/shophome/ui/adapter/ECShopHomeProductListRecyclerViewAdapter$c", "Lkotlin/Function1;", "Landroid/graphics/drawable/Drawable;", "Lkotlin/ParameterName;", "name", "drawable", "", "Lcom/tencent/ecommerce/base/imageloader/api/Callback;", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c implements Function1<Drawable, Unit> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ RecyclerView.ViewHolder f104265d;

        c(RecyclerView.ViewHolder viewHolder) {
            this.f104265d = viewHolder;
        }

        public void a(Drawable drawable) {
            ((i) this.f104265d).itemIcon.setImageDrawable(drawable);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Drawable drawable) {
            a(drawable);
            return Unit.INSTANCE;
        }
    }

    public ECShopHomeProductListRecyclerViewAdapter(Activity activity, Bundle bundle, ECShopHomeProductCardCallback eCShopHomeProductCardCallback) {
        String string;
        String string2;
        this.context = activity;
        this.arguments = bundle;
        this.callback = eCShopHomeProductCardCallback;
        this.adClickId = (bundle == null || (string2 = bundle.getString("qz_gdt")) == null) ? "" : string2;
        String str = "0";
        String str2 = (bundle == null || (str2 = bundle.getString("is_select")) == null) ? "0" : str2;
        this._isSelect = str2;
        ECShopHomeFragment.Companion companion = ECShopHomeFragment.INSTANCE;
        this.isSelectHost = companion.c(str2);
        if (bundle != null && (string = bundle.getString("is_distributor")) != null) {
            str = string;
        }
        this._isDistribution = str;
        this.isDistribution = companion.c(str);
        this.weakReference = new WeakReference<>(activity);
        this.productDataList = new ArrayList<>();
        this.ptsComposerCacheManager = new PtsComposerCache<>(new Function1<ECShopProductInfo, String>() { // from class: com.tencent.ecommerce.biz.shophome.ui.adapter.ECShopHomeProductListRecyclerViewAdapter$ptsComposerCacheManager$1
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(ECShopProductInfo eCShopProductInfo) {
                return eCShopProductInfo.id;
            }
        }, new Function1<ECShopProductInfo, String>() { // from class: com.tencent.ecommerce.biz.shophome.ui.adapter.ECShopHomeProductListRecyclerViewAdapter$ptsComposerCacheManager$2
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(ECShopProductInfo eCShopProductInfo) {
                return String.valueOf(eCShopProductInfo.getDataJson());
            }
        }, new Function1<String, IPTSLiteEventListener>() { // from class: com.tencent.ecommerce.biz.shophome.ui.adapter.ECShopHomeProductListRecyclerViewAdapter$ptsComposerCacheManager$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final IPTSLiteEventListener invoke(String str3) {
                IPTSLiteEventListener E0;
                E0 = ECShopHomeProductListRecyclerViewAdapter.this.E0();
                return E0;
            }
        }, null, 8, null);
        this.preloadItemCount = 5;
        this.currentScene = ECShopHomeScene.SCENE_SHOP_HOME;
        this.currentPageType = ECShopHomePageType.PAGE_TYPE_ALL;
        this.productIdMap = new LinkedHashMap();
    }

    private final boolean B0(int position) {
        return position >= 0 && getNUM_BACKGOURND_ICON() > position && z0(position).viewType == 2;
    }

    private final boolean C0(int position) {
        return position >= getNUM_BACKGOURND_ICON() - this.footerCount;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean D0() {
        return this.currentScene == ECShopHomeScene.SCENE_SHOP_HOME_SEARCH_RESULT_RECOMMEND;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IPTSLiteEventListener E0() {
        return new d();
    }

    private final void L0(k viewHolder, ECShopProductInfo productInfo) {
        viewHolder.itemView.setOnClickListener(new e(productInfo));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<ECShopProductInfo> r0(boolean showNoMoreData, List<ECShopProductInfo> productDataList) {
        this.footerCount = showNoMoreData ? 1 : 0;
        cg0.a.b("ECShopHomeProductListRecyclerViewAdapter", "[addFooterView] footerCount = " + this.footerCount);
        if (this.footerCount <= 0 || productDataList.isEmpty()) {
            return productDataList;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(productDataList);
        arrayList.add(new ECShopProductInfo("", "", "", null, 1, false, 40, null));
        return arrayList;
    }

    private final void s0(int position) {
        Function0<Unit> function0 = this.onPreload;
        if (function0 == null || this.scrollState == 0 || position != (getNUM_BACKGOURND_ICON() - this.preloadItemCount) - 1) {
            return;
        }
        function0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String v0() {
        ECOrderByTabInfo eCOrderByTabInfo;
        String str;
        return (this.currentScene == ECShopHomeScene.SCENE_SHOP_HOME_SEARCH_RESULT_RECOMMEND || (eCOrderByTabInfo = this.currentOrderTabInfo) == null || (str = eCOrderByTabInfo.orderByKey) == null) ? "" : str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int w0() {
        ECOrderByTabInfo eCOrderByTabInfo;
        if (this.currentScene == ECShopHomeScene.SCENE_SHOP_HOME_SEARCH_RESULT_RECOMMEND || (eCOrderByTabInfo = this.currentOrderTabInfo) == null) {
            return 0;
        }
        return eCOrderByTabInfo.getOrderByValue();
    }

    private final ECShopProductInfo z0(int position) {
        return this.productDataList.get(position);
    }

    public final Function0<Unit> A0() {
        return this.onPreload;
    }

    public final void F0(ECOrderByTabInfo eCOrderByTabInfo) {
        this.currentOrderTabInfo = eCOrderByTabInfo;
    }

    public final void H0(ECShopHomePageType eCShopHomePageType) {
        this.currentPageType = eCShopHomePageType;
    }

    public final void I0(ECShopHomeScene eCShopHomeScene) {
        this.currentScene = eCShopHomeScene;
    }

    public final void J0(final List<ECShopProductInfo> newProductDataList, final boolean showNoMoreData) {
        String str;
        if (newProductDataList.isEmpty()) {
            return;
        }
        Function0<ArrayList<ECShopProductInfo>> function0 = new Function0<ArrayList<ECShopProductInfo>>() { // from class: com.tencent.ecommerce.biz.shophome.ui.adapter.ECShopHomeProductListRecyclerViewAdapter$setData$oldListGenerator$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ArrayList<ECShopProductInfo> invoke() {
                ArrayList arrayList;
                arrayList = ECShopHomeProductListRecyclerViewAdapter.this.productDataList;
                return new ArrayList<>(arrayList);
            }
        };
        if (this.isDistribution) {
            str = "qshop_home_distribution";
        } else if (this.isSelectHost) {
            str = "shop_home_product_card_host";
        } else {
            str = "shop_home_product_card";
        }
        PtsComposerCache.i(this.ptsComposerCacheManager, str, function0, new Function0<List<? extends ECShopProductInfo>>() { // from class: com.tencent.ecommerce.biz.shophome.ui.adapter.ECShopHomeProductListRecyclerViewAdapter$setData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends ECShopProductInfo> invoke() {
                return newProductDataList;
            }
        }, null, new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.shophome.ui.adapter.ECShopHomeProductListRecyclerViewAdapter$setData$2
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
                ArrayList arrayList;
                List r06;
                ArrayList arrayList2;
                arrayList = ECShopHomeProductListRecyclerViewAdapter.this.productDataList;
                arrayList.clear();
                r06 = ECShopHomeProductListRecyclerViewAdapter.this.r0(showNoMoreData, newProductDataList);
                arrayList2 = ECShopHomeProductListRecyclerViewAdapter.this.productDataList;
                arrayList2.addAll(r06);
                ECShopHomeProductListRecyclerViewAdapter.this.notifyItemRangeChanged(0, r06.size());
            }
        }, 8, null);
    }

    public final void K0(Function0<Unit> function0) {
        this.onPreload = function0;
    }

    public final void M0(String saasProductId) {
        ECShopProductInfo eCShopProductInfo = this.productIdMap.get(saasProductId);
        if (eCShopProductInfo != null) {
            PTSComposer g16 = this.ptsComposerCacheManager.g(eCShopProductInfo);
            if (g16 != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("is_added", 1);
                g16.updateData(jSONObject.toString());
            }
            notifyDataSetChanged();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.productDataList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        if (C0(position)) {
            return 1;
        }
        return B0(position) ? 2 : 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        recyclerView.addOnScrollListener(new b());
    }

    public final void t0() {
        this.ptsComposerCacheManager.j(new Function0<ArrayList<ECShopProductInfo>>() { // from class: com.tencent.ecommerce.biz.shophome.ui.adapter.ECShopHomeProductListRecyclerViewAdapter$destroyPtsComposerList$listGenerator$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ArrayList<ECShopProductInfo> invoke() {
                ArrayList arrayList;
                arrayList = ECShopHomeProductListRecyclerViewAdapter.this.productDataList;
                return new ArrayList<>(arrayList);
            }
        });
    }

    /* renamed from: u0, reason: from getter */
    public final ECShopHomeProductCardCallback getCallback() {
        return this.callback;
    }

    /* renamed from: x0, reason: from getter */
    public final ECShopHomePageType getCurrentPageType() {
        return this.currentPageType;
    }

    /* renamed from: y0, reason: from getter */
    public final ECShopHomeScene getCurrentScene() {
        return this.currentScene;
    }

    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JN\u0010\f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022&\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/ecommerce/biz/shophome/ui/adapter/ECShopHomeProductListRecyclerViewAdapter$d", "Lcom/tencent/ecommerce/base/ui/e;", "", IECDtReport.ACTION_IDENTIFIER, "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "dataMap", "Landroid/view/View;", "view", "Lcom/tencent/pts/core/PTSComposer;", "ptsComposer", "", "onTapEventTriggered", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class d extends com.tencent.ecommerce.base.ui.e {
        d() {
        }

        @Override // com.tencent.pts.core.lite.IPTSLiteEventListener
        public void onTapEventTriggered(String identifier, HashMap<String, String> dataMap, View view, PTSComposer ptsComposer) {
            String str;
            if (dataMap == null || (str = dataMap.get("eventType")) == null) {
                return;
            }
            cg0.a.b("ECShopHomeProductListFragment", "[onTapEventTriggered] " + str);
            ECShopProductInfo eCShopProductInfo = (ECShopProductInfo) ECShopHomeProductListRecyclerViewAdapter.this.productIdMap.get(identifier);
            int hashCode = str.hashCode();
            if (hashCode != 105087985) {
                if (hashCode == 1598760206 && str.equals("addProduct") && eCShopProductInfo != null) {
                    ECShopHomeProductListRecyclerViewAdapter.this.getCallback().onAddProductToDeliver(eCShopProductInfo);
                    return;
                }
                return;
            }
            if (!str.equals("addWindow") || eCShopProductInfo == null) {
                return;
            }
            ECShopHomeProductListRecyclerViewAdapter.this.getCallback().onAddProductToWindow(eCShopProductInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class e implements View.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ECShopProductInfo f104268e;

        e(ECShopProductInfo eCShopProductInfo) {
            this.f104268e = eCShopProductInfo;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            JSONObject dataJson = this.f104268e.getDataJson();
            if (!(dataJson != null ? dataJson.optBoolean("is_price_exceed") : false)) {
                String str = this.f104268e.url;
                cg0.a.b("ECShopHomeProductListRecyclerViewAdapter", "[setupClickListener] jumpUrl = " + str);
                if (!TextUtils.isEmpty(str)) {
                    if (ECShopHomeProductListRecyclerViewAdapter.this.adClickId.length() > 0) {
                        str = str + "&qz_gdt=" + ECShopHomeProductListRecyclerViewAdapter.this.adClickId;
                    }
                    com.tencent.ecommerce.biz.shophome.util.b bVar = com.tencent.ecommerce.biz.shophome.util.b.f104380a;
                    ECShopHomeProductListRecyclerViewAdapter eCShopHomeProductListRecyclerViewAdapter = ECShopHomeProductListRecyclerViewAdapter.this;
                    bVar.g(eCShopHomeProductListRecyclerViewAdapter.context, eCShopHomeProductListRecyclerViewAdapter.arguments, str);
                    com.tencent.ecommerce.biz.shophome.util.a aVar = com.tencent.ecommerce.biz.shophome.util.a.f104379a;
                    ECShopReportParams c16 = aVar.c(ECShopHomeProductListRecyclerViewAdapter.this.arguments);
                    JSONObject dataJson2 = this.f104268e.getDataJson();
                    if (dataJson2 == null) {
                        dataJson2 = new JSONObject();
                    }
                    String optString = dataJson2.optString("spu_id", "");
                    String optString2 = dataJson2.optString("sku_id", "");
                    JSONObject optJSONObject = dataJson2.optJSONObject("active_info");
                    if (optJSONObject == null) {
                        optJSONObject = new JSONObject();
                    }
                    aVar.h(c16.role, c16.shopId, c16.source, optString, optString2, ECShopHomeProductListRecyclerViewAdapter.this.getCurrentScene(), ECShopHomeProductListRecyclerViewAdapter.this.v0(), ECShopHomeProductListRecyclerViewAdapter.this.w0(), ECShopHomeProductListRecyclerViewAdapter.this.getCurrentPageType(), optJSONObject.optString("active_id", ""), optJSONObject.optInt("active_type", 0), aVar.b(dataJson2));
                    if (ECShopHomeProductListRecyclerViewAdapter.this.D0()) {
                        aVar.p(c16.role, c16.shopId, c16.source, optString, (r18 & 16) != 0 ? "" : null, (r18 & 32) != 0 ? "" : null, (r18 & 64) != 0 ? "" : null);
                    }
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final String str;
        JSONObject jSONObject;
        if (C0(position)) {
            ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
            boolean z16 = this.isSelectHost;
            if (z16) {
                if (layoutParams == null) {
                    holder.itemView.setLayoutParams(new LinearLayout.LayoutParams(-1, com.tencent.ecommerce.biz.util.e.c(132.0f)));
                    return;
                }
                return;
            } else {
                if (z16) {
                    return;
                }
                if (layoutParams == null) {
                    View view = holder.itemView;
                    StaggeredGridLayoutManager.LayoutParams layoutParams2 = new StaggeredGridLayoutManager.LayoutParams(-1, com.tencent.ecommerce.biz.util.e.c(132.0f));
                    layoutParams2.setFullSpan(true);
                    Unit unit = Unit.INSTANCE;
                    view.setLayoutParams(layoutParams2);
                    return;
                }
                if (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) {
                    ((StaggeredGridLayoutManager.LayoutParams) layoutParams).setFullSpan(true);
                    return;
                }
                return;
            }
        }
        if (B0(position)) {
            ViewGroup.LayoutParams layoutParams3 = holder.itemView.getLayoutParams();
            if (layoutParams3 == null) {
                View view2 = holder.itemView;
                StaggeredGridLayoutManager.LayoutParams layoutParams4 = new StaggeredGridLayoutManager.LayoutParams(-1, com.tencent.ecommerce.biz.util.e.c(290.0f));
                layoutParams4.setFullSpan(true);
                Unit unit2 = Unit.INSTANCE;
                view2.setLayoutParams(layoutParams4);
            } else if (layoutParams3 instanceof StaggeredGridLayoutManager.LayoutParams) {
                ((StaggeredGridLayoutManager.LayoutParams) layoutParams3).setFullSpan(true);
            }
        }
        if (holder instanceof i) {
            JSONObject dataJson = z0(position).getDataJson();
            if (dataJson == null || (jSONObject = dataJson.optJSONObject("default_info")) == null) {
                jSONObject = new JSONObject();
            }
            String optString = jSONObject.optString("pic_url");
            String optString2 = jSONObject.optString("description");
            if (optString.length() > 0) {
                i iVar = (i) holder;
                int i3 = iVar.itemIcon.getLayoutParams().width;
                int i16 = iVar.itemIcon.getLayoutParams().height;
                QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getImageLoader().fetchDrawable(this.context, optString, (i3 <= 0 || i16 <= 0) ? null : new IECImageLoader.ImageLoaderOption(i3, i16, 0, null, null, null, false, false, null, 508, null), new c(holder));
            }
            if (optString2.length() > 0) {
                ((i) holder).itemText.setText(optString2);
            }
        }
        if (!(holder instanceof k) || position < 0 || position >= getNUM_BACKGOURND_ICON() - this.footerCount) {
            return;
        }
        final ECShopProductInfo z06 = z0(position);
        k kVar = (k) holder;
        ECShopCardView eCShopCardView = kVar.ptsItemCardView;
        if (!this.isSelectHost && !this.isDistribution) {
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams5.leftMargin = (int) PTSDeviceUtil.dp2px(6.0f);
            layoutParams5.rightMargin = (int) PTSDeviceUtil.dp2px(6.0f);
            layoutParams5.bottomMargin = (int) PTSDeviceUtil.dp2px(12.0f);
            eCShopCardView.setLayoutParams(layoutParams5);
        }
        JSONObject dataJson2 = z06.getDataJson();
        if (dataJson2 == null || (str = dataJson2.optString("spu_id")) == null) {
            str = "";
        }
        this.productIdMap.put(str, z06);
        PTSComposer g16 = this.ptsComposerCacheManager.g(z06);
        if (g16 != null) {
            eCShopCardView.g(g16, E0());
        }
        L0(kVar, z06);
        s0(position);
        if (z06.getHasExposed()) {
            return;
        }
        ECThreadUtilKt.a(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.shophome.ui.adapter.ECShopHomeProductListRecyclerViewAdapter$onBindViewHolder$5
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
                com.tencent.ecommerce.biz.shophome.util.a aVar = com.tencent.ecommerce.biz.shophome.util.a.f104379a;
                ECShopReportParams c16 = aVar.c(ECShopHomeProductListRecyclerViewAdapter.this.arguments);
                JSONObject dataJson3 = z06.getDataJson();
                if (dataJson3 == null) {
                    dataJson3 = new JSONObject();
                }
                String optString3 = dataJson3.optString("sku_id", "");
                JSONObject optJSONObject = dataJson3.optJSONObject("active_info");
                if (optJSONObject == null) {
                    optJSONObject = new JSONObject();
                }
                aVar.i(c16.role, c16.shopId, c16.source, str, optString3, ECShopHomeProductListRecyclerViewAdapter.this.getCurrentScene(), ECShopHomeProductListRecyclerViewAdapter.this.v0(), ECShopHomeProductListRecyclerViewAdapter.this.w0(), ECShopHomeProductListRecyclerViewAdapter.this.getCurrentPageType(), optJSONObject.optString("active_id", ""), optJSONObject.optInt("active_type", 0), aVar.b(dataJson3));
                if (ECShopHomeProductListRecyclerViewAdapter.this.D0()) {
                    aVar.r(c16.role, c16.shopId, c16.source, str, (r18 & 16) != 0 ? "" : null, (r18 & 32) != 0 ? "" : null, (r18 & 64) != 0 ? "" : null);
                }
            }
        });
        z06.c(true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        IECImageLoader.ImageLoaderOption imageLoaderOption = null;
        if (viewType == 1) {
            return new j(LayoutInflater.from(this.context).inflate(R.layout.cu6, (ViewGroup) null, false));
        }
        if (viewType != 2) {
            return new k(new ECShopCardView(this.context, this.isSelectHost ? 0.0f : PTSDeviceUtil.dp2px(4.0f)));
        }
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.cu8, (ViewGroup) null, false);
        final ImageView imageView = (ImageView) inflate.findViewById(R.id.oaa);
        TextView textView = (TextView) inflate.findViewById(R.id.oab);
        int i3 = imageView.getLayoutParams().width;
        int i16 = imageView.getLayoutParams().height;
        if (i3 > 0 && i16 > 0) {
            imageLoaderOption = new IECImageLoader.ImageLoaderOption(i3, i16, 0, null, null, null, false, false, null, 508, null);
        }
        ECSkin.INSTANCE.getDrawable("qecommerce_skin_emptystate_img_sousuo", imageLoaderOption, new Function1<Drawable, Unit>() { // from class: com.tencent.ecommerce.biz.shophome.ui.adapter.ECShopHomeProductListRecyclerViewAdapter$onCreateViewHolder$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Drawable drawable) {
                invoke2(drawable);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Drawable drawable) {
                if (drawable != null) {
                    imageView.setImageDrawable(drawable);
                } else {
                    imageView.setVisibility(8);
                }
            }
        });
        return new i(inflate, imageView, textView);
    }
}
