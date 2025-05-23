package com.tencent.ecommerce.biz.showwindow.fragment;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cg0.a;
import ck0.Category;
import ck0.Product;
import com.qzone.module.feedcomponent.manage.FeedManager;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.ecommerce.base.eventbus.EventObserver;
import com.tencent.ecommerce.base.eventbus.LifecycleEventBus;
import com.tencent.ecommerce.base.eventbus.ThreadMode;
import com.tencent.ecommerce.base.fragment.ECBaseFragment;
import com.tencent.ecommerce.base.report.service.ECShowPageCostTimeScene;
import com.tencent.ecommerce.base.report.service.k;
import com.tencent.ecommerce.base.rmonitor.service.ECRMonitorManager;
import com.tencent.ecommerce.base.style.service.ECPTSStyleManager;
import com.tencent.ecommerce.base.ui.component.ECBaseRecyclerView;
import com.tencent.ecommerce.biz.showwindow.ui.adapter.ECShowWindowProductListAdapter;
import com.tencent.ecommerce.biz.showwindow.viewmodel.ECShowWindowViewModel;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.pts.core.PTSComposer;
import com.tencent.pts.core.itemview.PTSItemView;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqmini.sdk.request.GetAdInfoRequest;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.apache.httpcore.message.TokenParser;
import org.json.JSONObject;
import ri0.ECAddProductToWindowEvent;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0087\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\t*\u0001j\u0018\u0000 p2\u00020\u0001:\u0001qB\t\b\u0002\u00a2\u0006\u0004\bn\u0010oJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\u0002H\u0002J\b\u0010\u0010\u001a\u00020\u0002H\u0002J\b\u0010\u0011\u001a\u00020\u0002H\u0002J\b\u0010\u0012\u001a\u00020\u0002H\u0002J\b\u0010\u0013\u001a\u00020\u0002H\u0002J\b\u0010\u0014\u001a\u00020\u0002H\u0002J\b\u0010\u0015\u001a\u00020\u0002H\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\u0012\u0010\u001a\u001a\u00020\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u001b\u001a\u00020\u0016H\u0016J\u001a\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u001e\u001a\u00020\u0002H\u0016J\b\u0010\u001f\u001a\u00020\u0002H\u0016J\b\u0010 \u001a\u00020\u0002H\u0016J\u0006\u0010!\u001a\u00020\u0002J$\u0010&\u001a\u00020\u00022\b\b\u0002\u0010#\u001a\u00020\"2\b\b\u0002\u0010$\u001a\u00020\f2\b\b\u0002\u0010%\u001a\u00020\fJ\b\u0010'\u001a\u00020\"H\u0016R\u0016\u0010*\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010-\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010/\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010,R\u0016\u00101\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010,R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\"\u0010;\u001a\u00020\"8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b6\u0010,\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R$\u0010@\u001a\u0010\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020\u0002\u0018\u00010<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\"\u0010H\u001a\u00020A8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u0016\u0010L\u001a\u00020I8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010P\u001a\u00020M8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010T\u001a\u00020Q8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010X\u001a\u00020U8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010[\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bY\u0010ZR\u0016\u0010]\u001a\u00020Q8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\\\u0010SR\u0016\u0010a\u001a\u00020^8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b_\u0010`R\u0016\u0010c\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bb\u0010RR\u0014\u0010g\u001a\u00020d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\be\u0010fR\u0016\u0010i\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bh\u0010RR\u0014\u0010m\u001a\u00020j8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bk\u0010l\u00a8\u0006r"}, d2 = {"Lcom/tencent/ecommerce/biz/showwindow/fragment/ECLiveShowWindowListFragment;", "Lcom/tencent/ecommerce/base/fragment/ECBaseFragment;", "", "initArguments", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "ei", "ci", "initViews", "di", "fi", "ki", "", "isVisible", "pi", "hi", "gi", "ii", "li", WidgetCacheLunarData.JI, "oi", "Zh", "", "uh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "getContentLayoutId", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "qi", "", "cookie", FeedManager.LOAD_MORE, "firstScreen", "mi", "getBusinessDescription", "P", "I", "windowType", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Ljava/lang/String;", WadlProxyConsts.CHANNEL, BdhLogUtil.LogTag.Tag_Req, GetAdInfoRequest.SOURCE_FROM, ExifInterface.LATITUDE_SOUTH, "liveUserId", "", "T", "J", "liveRoomId", "U", "ai", "()Ljava/lang/String;", "setShopId", "(Ljava/lang/String;)V", "shopId", "Lkotlin/Function1;", "Landroidx/fragment/app/Fragment;", "V", "Lkotlin/jvm/functions/Function1;", "createdCallback", "Lcom/tencent/ecommerce/biz/showwindow/viewmodel/b;", "W", "Lcom/tencent/ecommerce/biz/showwindow/viewmodel/b;", "bi", "()Lcom/tencent/ecommerce/biz/showwindow/viewmodel/b;", "setViewModel", "(Lcom/tencent/ecommerce/biz/showwindow/viewmodel/b;)V", "viewModel", "Lcom/tencent/ecommerce/base/ui/component/ECBaseRecyclerView;", "X", "Lcom/tencent/ecommerce/base/ui/component/ECBaseRecyclerView;", "productListView", "Lcom/tencent/ecommerce/biz/showwindow/ui/adapter/ECShowWindowProductListAdapter;", "Y", "Lcom/tencent/ecommerce/biz/showwindow/ui/adapter/ECShowWindowProductListAdapter;", "productListAdapter", "Landroid/widget/FrameLayout;", "Z", "Landroid/widget/FrameLayout;", "emptyContainer", "Lcom/tencent/pts/core/PTSComposer;", "a0", "Lcom/tencent/pts/core/PTSComposer;", "emptyPtsComposer", "b0", "Landroid/view/View;", "isLoadingFooter", "c0", "loadingPage", "Landroid/widget/ImageView;", "d0", "Landroid/widget/ImageView;", "loadingIcon", "e0", "isCurrentNightMode", "Lcom/tencent/ecommerce/base/report/service/k;", "f0", "Lcom/tencent/ecommerce/base/report/service/k;", "showPageCostTime", "g0", "isProductListEmpty", "com/tencent/ecommerce/biz/showwindow/fragment/ECLiveShowWindowListFragment$b", "h0", "Lcom/tencent/ecommerce/biz/showwindow/fragment/ECLiveShowWindowListFragment$b;", "addProductEventObserve", "<init>", "()V", "i0", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECLiveShowWindowListFragment extends ECBaseFragment {

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: P, reason: from kotlin metadata */
    private int windowType;

    /* renamed from: Q, reason: from kotlin metadata */
    private String channel;

    /* renamed from: R, reason: from kotlin metadata */
    private String sourceFrom;

    /* renamed from: S, reason: from kotlin metadata */
    private String liveUserId;

    /* renamed from: T, reason: from kotlin metadata */
    private long liveRoomId;

    /* renamed from: U, reason: from kotlin metadata */
    private String shopId;

    /* renamed from: V, reason: from kotlin metadata */
    private Function1<? super Fragment, Unit> createdCallback;

    /* renamed from: W, reason: from kotlin metadata */
    public com.tencent.ecommerce.biz.showwindow.viewmodel.b viewModel;

    /* renamed from: X, reason: from kotlin metadata */
    private ECBaseRecyclerView productListView;

    /* renamed from: Y, reason: from kotlin metadata */
    private ECShowWindowProductListAdapter productListAdapter;

    /* renamed from: Z, reason: from kotlin metadata */
    private FrameLayout emptyContainer;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private PTSComposer emptyPtsComposer;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private View isLoadingFooter;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private FrameLayout loadingPage;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private ImageView loadingIcon;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private boolean isCurrentNightMode;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private final k showPageCostTime;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private boolean isProductListEmpty;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    private final b addProductEventObserve;

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J&\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004R\u0014\u0010\u000b\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000e\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0014\u0010\u000f\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\fR\u0014\u0010\u0010\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\fR\u0014\u0010\u0011\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\fR\u0014\u0010\u0012\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\fR\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00138\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\f\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/ecommerce/biz/showwindow/fragment/ECLiveShowWindowListFragment$a;", "", "Landroid/os/Bundle;", "args", "Lkotlin/Function1;", "Landroidx/fragment/app/Fragment;", "", "createdCallback", "Lcom/tencent/ecommerce/biz/showwindow/fragment/ECLiveShowWindowListFragment;", "a", "", "ARG_LIVE_ROOM_ID", "Ljava/lang/String;", "ARG_LIVE_SHOP_ID", "ARG_LIVE_SHOP_NAME", "ARG_LIVE_USER_ID", "ARG_WINDOW_TYPE", "DEFAULT_MEDIA_NAME", "EMPTY_PAGE_NAME", "", "EXTERNAL_LINK_REQUEST_CODE", "I", "LOAD_MORE_PRE_COUNT", "TAG", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.showwindow.fragment.ECLiveShowWindowListFragment$a, reason: from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        public final ECLiveShowWindowListFragment a(Bundle args, Function1<? super Fragment, Unit> createdCallback) {
            ECLiveShowWindowListFragment eCLiveShowWindowListFragment = new ECLiveShowWindowListFragment(null);
            Bundle bundle = new Bundle();
            if (args != null) {
                bundle.putAll(args);
            }
            eCLiveShowWindowListFragment.setArguments(bundle);
            eCLiveShowWindowListFragment.createdCallback = createdCallback;
            return eCLiveShowWindowListFragment;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/ecommerce/biz/showwindow/fragment/ECLiveShowWindowListFragment$b", "Lcom/tencent/ecommerce/base/eventbus/EventObserver;", "Lri0/a;", "event", "", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b implements EventObserver<ECAddProductToWindowEvent> {
        b() {
        }

        @Override // com.tencent.ecommerce.base.eventbus.EventObserver
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onEvent(ECAddProductToWindowEvent event) {
            if (event.isAdded) {
                ECLiveShowWindowListFragment.ni(ECLiveShowWindowListFragment.this, null, false, true, 3, null);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JN\u0010\f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022&\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/ecommerce/biz/showwindow/fragment/ECLiveShowWindowListFragment$c", "Lcom/tencent/ecommerce/base/ui/e;", "", "id", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "dataMap", "Landroid/view/View;", "veiw", "Lcom/tencent/pts/core/PTSComposer;", "ptsComposer", "", "onTapEventTriggered", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c extends com.tencent.ecommerce.base.ui.e {
        c() {
        }

        @Override // com.tencent.pts.core.lite.IPTSLiteEventListener
        public void onTapEventTriggered(String id5, HashMap<String, String> dataMap, View veiw, PTSComposer ptsComposer) {
            a.b("ECLiveShowWindowListFragment", "[onTapEventTriggered] id = " + id5);
            yi0.a.r(Uri.parse(String.valueOf(10)));
            fj0.b.f399473a.a(ECLiveShowWindowListFragment.this.channel, 2);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/ecommerce/biz/showwindow/fragment/ECLiveShowWindowListFragment$d", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "dx", "dy", "onScrolled", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class d extends RecyclerView.OnScrollListener {
        d() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager != null) {
                Integer.valueOf(((LinearLayoutManager) layoutManager).findLastVisibleItemPosition()).intValue();
                if (newState == 0) {
                    Boolean value = ECLiveShowWindowListFragment.this.bi().S2().getValue();
                    Boolean bool = Boolean.TRUE;
                    if (Intrinsics.areEqual(value, bool)) {
                        a.b("ECLiveShowWindowListFragment", "[onScrollStateChanged] isEnd, no more data.");
                        return;
                    } else {
                        if (Intrinsics.areEqual(ECLiveShowWindowListFragment.this.bi().T2().getValue(), bool)) {
                            a.b("ECLiveShowWindowListFragment", "[onScrollStateChanged] isLoadingMore, do not load again.");
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int dx5, int dy5) {
            super.onScrolled(recyclerView, dx5, dy5);
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager != null) {
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                Boolean value = ECLiveShowWindowListFragment.this.bi().T2().getValue();
                Boolean bool = Boolean.TRUE;
                if (Intrinsics.areEqual(value, bool) || Integer.valueOf(linearLayoutManager.findFirstVisibleItemPosition()).intValue() == 0) {
                    return;
                }
                if (Intrinsics.areEqual(ECLiveShowWindowListFragment.this.bi().S2().getValue(), bool)) {
                    a.b("ECLiveShowWindowListFragment", "[onScrollStateChanged] isEnd, no more data.");
                    return;
                }
                int intValue = Integer.valueOf(linearLayoutManager.findLastVisibleItemPosition()).intValue();
                if (ECLiveShowWindowListFragment.Rh(ECLiveShowWindowListFragment.this).getNUM_BACKGOURND_ICON() - intValue <= 8) {
                    a.b("ECLiveShowWindowListFragment", "[onScrollStateChanged] lastVisiblePosition = " + intValue + TokenParser.SP + ", count = " + ECLiveShowWindowListFragment.Rh(ECLiveShowWindowListFragment.this).getNUM_BACKGOURND_ICON());
                    ECLiveShowWindowListFragment.ni(ECLiveShowWindowListFragment.this, ECLiveShowWindowListFragment.this.bi().getLastCookie(), true, false, 4, null);
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/lang/Integer;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class e<T> implements Observer<Integer> {
        e() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(Integer num) {
            JSONObject jSONObject = new JSONObject();
            Resources resources = ECLiveShowWindowListFragment.this.requireContext().getResources();
            if (num != null && num.intValue() == -1) {
                ECLiveShowWindowListFragment.Nh(ECLiveShowWindowListFragment.this).setVisibility(8);
            } else if (num != null && num.intValue() == 0) {
                if (ECLiveShowWindowListFragment.this.windowType == 4) {
                    jSONObject.put("imageToken", "qecommerce_skin_emptystate_img_wenjian");
                    jSONObject.put("cus_text", resources.getString(R.string.wur));
                } else {
                    jSONObject.put("imageToken", "qecommerce_skin_emptystate_img_wenjian");
                    jSONObject.put("cus_text", resources.getString(R.string.wuk));
                    jSONObject.put("second_text", resources.getString(R.string.wug));
                }
            } else if (num != null && num.intValue() == 1) {
                if (ECLiveShowWindowListFragment.this.windowType == 4) {
                    jSONObject.put("imageToken", "qecommerce_skin_emptystate_img_wenjian");
                } else {
                    jSONObject.put("imageToken", "qecommerce_skin_emptystate_img_sousuo");
                }
                jSONObject.put("cus_text", resources.getString(R.string.wsa));
            } else if (num != null && num.intValue() == 2) {
                jSONObject.put("imageToken", "qecommerce_skin_emptystate_img_wuwangluo");
                jSONObject.put("cus_text", resources.getString(R.string.wui));
            } else if (num != null && num.intValue() == 3) {
                jSONObject.put("imageToken", "qecommerce_skin_emptystate_img_wenjian");
                jSONObject.put("cus_text", resources.getString(R.string.wix));
            }
            if ((num == null || -1 != num.intValue()) && ECLiveShowWindowListFragment.this.isProductListEmpty) {
                ECLiveShowWindowListFragment.Nh(ECLiveShowWindowListFragment.this).setVisibility(0);
            }
            ECLiveShowWindowListFragment.Oh(ECLiveShowWindowListFragment.this).setData(jSONObject.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class f<T> implements Observer<Boolean> {
        f() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(Boolean bool) {
            a.b("ECLiveShowWindowListFragment", "registerIsLoadingLiveDataObserver " + bool);
            ECLiveShowWindowListFragment.Rh(ECLiveShowWindowListFragment.this).B0(bool.booleanValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class g<T> implements Observer<Boolean> {
        g() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(Boolean bool) {
            ECLiveShowWindowListFragment.Qh(ECLiveShowWindowListFragment.this).setVisibility(bool.booleanValue() ? 0 : 8);
            if (bool.booleanValue()) {
                ECLiveShowWindowListFragment.this.Zh();
                ECLiveShowWindowListFragment.this.oi();
                ECLiveShowWindowListFragment.Nh(ECLiveShowWindowListFragment.this).setVisibility(8);
                return;
            }
            ECLiveShowWindowListFragment.Ph(ECLiveShowWindowListFragment.this).clearAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lck0/c;", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/util/List;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class h<T> implements Observer<List<? extends Product>> {
        h() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(List<Product> list) {
            ECLiveShowWindowListFragment.this.isProductListEmpty = list.isEmpty();
            ECLiveShowWindowListFragment.Rh(ECLiveShowWindowListFragment.this).setData(list);
            ECLiveShowWindowListFragment.this.pi(list.isEmpty());
            if (list.isEmpty()) {
                ECLiveShowWindowListFragment.this.bi().n3(false);
                ECLiveShowWindowListFragment.this.Zh();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class i<T> implements Observer<Boolean> {
        i() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(Boolean bool) {
            a.b("ECLiveShowWindowListFragment", "registerNoMoreDataLiveDataObserver " + bool);
            ECLiveShowWindowListFragment.Rh(ECLiveShowWindowListFragment.this).z0(bool.booleanValue());
        }
    }

    ECLiveShowWindowListFragment() {
        this.windowType = 1;
        this.channel = "";
        this.sourceFrom = "";
        this.liveUserId = "";
        this.shopId = "";
        this.showPageCostTime = new k(ECShowPageCostTimeScene.SHOW_COST_TIME_SCENE_WINDOW);
        this.isProductListEmpty = true;
        this.addProductEventObserve = new b();
    }

    public static final /* synthetic */ FrameLayout Nh(ECLiveShowWindowListFragment eCLiveShowWindowListFragment) {
        FrameLayout frameLayout = eCLiveShowWindowListFragment.emptyContainer;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emptyContainer");
        }
        return frameLayout;
    }

    public static final /* synthetic */ PTSComposer Oh(ECLiveShowWindowListFragment eCLiveShowWindowListFragment) {
        PTSComposer pTSComposer = eCLiveShowWindowListFragment.emptyPtsComposer;
        if (pTSComposer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emptyPtsComposer");
        }
        return pTSComposer;
    }

    public static final /* synthetic */ ImageView Ph(ECLiveShowWindowListFragment eCLiveShowWindowListFragment) {
        ImageView imageView = eCLiveShowWindowListFragment.loadingIcon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingIcon");
        }
        return imageView;
    }

    public static final /* synthetic */ FrameLayout Qh(ECLiveShowWindowListFragment eCLiveShowWindowListFragment) {
        FrameLayout frameLayout = eCLiveShowWindowListFragment.loadingPage;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingPage");
        }
        return frameLayout;
    }

    public static final /* synthetic */ ECShowWindowProductListAdapter Rh(ECLiveShowWindowListFragment eCLiveShowWindowListFragment) {
        ECShowWindowProductListAdapter eCShowWindowProductListAdapter = eCLiveShowWindowListFragment.productListAdapter;
        if (eCShowWindowProductListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("productListAdapter");
        }
        return eCShowWindowProductListAdapter;
    }

    public static final /* synthetic */ ECBaseRecyclerView Sh(ECLiveShowWindowListFragment eCLiveShowWindowListFragment) {
        ECBaseRecyclerView eCBaseRecyclerView = eCLiveShowWindowListFragment.productListView;
        if (eCBaseRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("productListView");
        }
        return eCBaseRecyclerView;
    }

    private final void di() {
        Object systemService = requireContext().getSystemService("layout_inflater");
        if (systemService != null) {
            LayoutInflater layoutInflater = (LayoutInflater) systemService;
            ECBaseRecyclerView eCBaseRecyclerView = this.productListView;
            if (eCBaseRecyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("productListView");
            }
            this.isLoadingFooter = layoutInflater.inflate(R.layout.crw, (ViewGroup) eCBaseRecyclerView, false);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.LayoutInflater");
    }

    private final void fi(View rootView) {
        a.b("ECLiveShowWindowListFragment", "[initWindowTypePage], windowType = " + this.windowType);
        com.tencent.ecommerce.biz.showwindow.viewmodel.b bVar = this.viewModel;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        bVar.n3(true);
        com.tencent.ecommerce.biz.showwindow.viewmodel.b bVar2 = this.viewModel;
        if (bVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        bVar2.e3(true);
        new View(getContext()).setLayoutParams(new ViewGroup.LayoutParams(-1, com.tencent.ecommerce.biz.util.e.c(20.0f)));
        ei0.c cVar = ei0.c.f396302a;
        ECBaseRecyclerView eCBaseRecyclerView = this.productListView;
        if (eCBaseRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("productListView");
        }
        cVar.m(eCBaseRecyclerView, getArguments());
    }

    private final void gi() {
        com.tencent.ecommerce.biz.showwindow.viewmodel.b bVar = this.viewModel;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        bVar.m2().observe(getViewLifecycleOwner(), new Observer<Boolean>() { // from class: com.tencent.ecommerce.biz.showwindow.fragment.ECLiveShowWindowListFragment$registerBackToTopLiveDataObserver$1
            @Override // androidx.lifecycle.Observer
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final void onChanged(Boolean bool) {
                if (bool.booleanValue()) {
                    ECLiveShowWindowListFragment.Sh(ECLiveShowWindowListFragment.this).post(new Runnable() { // from class: com.tencent.ecommerce.biz.showwindow.fragment.ECLiveShowWindowListFragment$registerBackToTopLiveDataObserver$1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            RecyclerView.LayoutManager layoutManager = ECLiveShowWindowListFragment.Sh(ECLiveShowWindowListFragment.this).getLayoutManager();
                            if (layoutManager != null) {
                                layoutManager.scrollToPosition(0);
                            }
                        }
                    });
                }
            }
        });
    }

    private final void hi() {
        com.tencent.ecommerce.biz.showwindow.viewmodel.b bVar = this.viewModel;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        bVar.t2().observe(getViewLifecycleOwner(), new e());
    }

    private final void ii() {
        com.tencent.ecommerce.biz.showwindow.viewmodel.b bVar = this.viewModel;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        bVar.T2().observe(getViewLifecycleOwner(), new f());
    }

    private final void initArguments() {
        String str;
        String str2;
        String str3;
        String str4;
        String string;
        String string2;
        Bundle arguments = getArguments();
        String str5 = "";
        if (arguments == null || (str = arguments.getString(WadlProxyConsts.CHANNEL)) == null) {
            str = "";
        }
        this.channel = str;
        Bundle arguments2 = getArguments();
        if (arguments2 == null || (str2 = arguments2.getString("source_from")) == null) {
            str2 = "";
        }
        this.sourceFrom = str2;
        this.isCurrentNightMode = fg0.a.f398587b.a();
        Bundle arguments3 = getArguments();
        if (arguments3 == null || (str3 = arguments3.getString("live_user_id")) == null) {
            str3 = "";
        }
        this.liveUserId = str3;
        Bundle arguments4 = getArguments();
        if (arguments4 == null || (str4 = arguments4.getString("live_room_id")) == null) {
            str4 = "0";
        }
        this.liveRoomId = Long.parseLong(str4);
        Bundle arguments5 = getArguments();
        if (arguments5 != null && (string2 = arguments5.getString("shop_id")) != null) {
            str5 = string2;
        }
        this.shopId = str5;
        try {
            Bundle arguments6 = getArguments();
            this.windowType = (arguments6 == null || (string = arguments6.getString("window_type")) == null) ? 1 : Integer.parseInt(string);
        } catch (NumberFormatException e16) {
            a.a("ECLiveShowWindowListFragment", "[initArguments]", e16.toString());
        }
        a.b("ECLiveShowWindowListFragment", "[initArguments] deliverProductCallchannel = " + this.channel + ", sourceFrom = " + this.sourceFrom + ", isNightMode = " + this.isCurrentNightMode + ", windowType = " + this.windowType + ", liveUserId = " + this.liveUserId + ", liveRoomId = " + this.liveRoomId + ", shopId= " + this.shopId);
    }

    private final void ji() {
        com.tencent.ecommerce.biz.showwindow.viewmodel.b bVar = this.viewModel;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        bVar.V2().observe(getViewLifecycleOwner(), new g());
    }

    private final void ki() {
        com.tencent.ecommerce.biz.showwindow.viewmodel.b bVar = this.viewModel;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        bVar.A2().observe(getViewLifecycleOwner(), new h());
        gi();
        hi();
        ii();
        li();
        ji();
    }

    private final void li() {
        com.tencent.ecommerce.biz.showwindow.viewmodel.b bVar = this.viewModel;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        bVar.S2().observe(getViewLifecycleOwner(), new i());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void oi() {
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(800L);
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setRepeatMode(1);
        ImageView imageView = this.loadingIcon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingIcon");
        }
        imageView.clearAnimation();
        ImageView imageView2 = this.loadingIcon;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingIcon");
        }
        imageView2.startAnimation(rotateAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void pi(boolean isVisible) {
        FrameLayout frameLayout = this.emptyContainer;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emptyContainer");
        }
        frameLayout.setVisibility(isVisible ? 0 : 8);
        if (isVisible) {
            com.tencent.ecommerce.biz.showwindow.viewmodel.b bVar = this.viewModel;
            if (bVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            if (bVar.getIsNetworkErrorLastTime()) {
                return;
            }
            com.tencent.ecommerce.biz.showwindow.viewmodel.b bVar2 = this.viewModel;
            if (bVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            String value = bVar2.r2().getValue();
            if (value == null) {
                value = "";
            }
            if (TextUtils.isEmpty(value)) {
                com.tencent.ecommerce.biz.showwindow.viewmodel.b bVar3 = this.viewModel;
                if (bVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                }
                bVar3.t3(0);
                return;
            }
            com.tencent.ecommerce.biz.showwindow.viewmodel.b bVar4 = this.viewModel;
            if (bVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            bVar4.t3(1);
        }
    }

    /* renamed from: ai, reason: from getter */
    public final String getShopId() {
        return this.shopId;
    }

    public final com.tencent.ecommerce.biz.showwindow.viewmodel.b bi() {
        com.tencent.ecommerce.biz.showwindow.viewmodel.b bVar = this.viewModel;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return bVar;
    }

    @Override // com.tencent.ecommerce.base.fragment.api.IECBaseFragment
    /* renamed from: getBusinessDescription */
    public String getTAG() {
        return "ECLiveShowWindowListFragment";
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int getContentLayoutId() {
        return R.layout.cqu;
    }

    public final void mi(String cookie, boolean loadMore, boolean firstScreen) {
        String valueOf;
        Bundle bundle = new Bundle();
        bundle.putLong("roomId", this.liveRoomId);
        bundle.putString("userId", this.liveUserId);
        bundle.putString("shopId", this.shopId);
        com.tencent.ecommerce.biz.showwindow.viewmodel.b bVar = this.viewModel;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        com.tencent.ecommerce.biz.showwindow.viewmodel.b bVar2 = this.viewModel;
        if (bVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        String value = bVar2.r2().getValue();
        String str = "";
        if (value == null) {
            value = "";
        }
        com.tencent.ecommerce.biz.showwindow.viewmodel.b bVar3 = this.viewModel;
        if (bVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        Category value2 = bVar3.q2().getValue();
        if (value2 != null && (valueOf = String.valueOf(value2.id)) != null) {
            str = valueOf;
        }
        ECShowWindowViewModel.z2(bVar, 1, value, str, this.windowType, cookie, loadMore, firstScreen, bundle, 0, 256, null);
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setRequestedOrientation(1);
        }
        initArguments();
        com.tencent.ecommerce.biz.showwindow.viewmodel.b bVar = (com.tencent.ecommerce.biz.showwindow.viewmodel.b) new ViewModelProvider(this).get(com.tencent.ecommerce.biz.showwindow.viewmodel.b.class);
        Bundle arguments = getArguments();
        if (arguments != null) {
            bVar.Q2(arguments);
        }
        bVar.f3(false);
        bVar.h3(this.showPageCostTime);
        Unit unit = Unit.INSTANCE;
        this.viewModel = bVar;
        Function1<? super Fragment, Unit> function1 = this.createdCallback;
        if (function1 != null) {
            function1.invoke(this);
        }
        LifecycleEventBus.f100688b.d(ThreadMode.ORIGIN, ECAddProductToWindowEvent.class, this.addProductEventObserve);
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.tencent.ecommerce.biz.showwindow.viewmodel.b bVar = this.viewModel;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        bVar.j2();
        LifecycleEventBus.f100688b.e(this.addProductEventObserve);
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        com.tencent.ecommerce.biz.common.d.f101554a.b(this.channel, "window_exit", this.windowType);
        ECRMonitorManager.f100953c.b("EC_STAGE_SHOW_WINDOW_HOST");
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        com.tencent.ecommerce.biz.common.d.f101554a.c(this.channel, "window_exp", this.windowType);
        ECRMonitorManager.f100953c.c("EC_STAGE_SHOW_WINDOW_HOST");
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        ei(view);
        ci(view);
        fi(view);
        di();
        ki();
        ni(this, null, false, true, 3, null);
    }

    public final void qi() {
        Bundle bundle = new Bundle();
        bundle.putLong("roomId", this.liveRoomId);
        bundle.putString("userId", this.liveUserId);
        com.tencent.ecommerce.biz.showwindow.viewmodel.b bVar = this.viewModel;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        bVar.u3(bundle);
        ei0.c cVar = ei0.c.f396302a;
        com.tencent.ecommerce.biz.showwindow.viewmodel.b bVar2 = this.viewModel;
        if (bVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        cVar.e(this, bVar2.B2().getValue(), this.windowType);
        com.tencent.ecommerce.biz.showwindow.viewmodel.b bVar3 = this.viewModel;
        if (bVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        cVar.f(this, bVar3.G2().getValue(), this.windowType);
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int uh() {
        return 0;
    }

    private final void ci(View rootView) {
        this.emptyContainer = (FrameLayout) rootView.findViewById(R.id.nzb);
        this.emptyPtsComposer = gh0.d.f402041a.b("empty_page_card", ECPTSStyleManager.e("empty_page_card", requireContext()), "", new c());
        PTSItemView pTSItemView = new PTSItemView(requireContext());
        PTSComposer pTSComposer = this.emptyPtsComposer;
        if (pTSComposer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emptyPtsComposer");
        }
        pTSComposer.layoutToView(pTSItemView);
        FrameLayout frameLayout = this.emptyContainer;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emptyContainer");
        }
        frameLayout.addView(pTSItemView);
    }

    private final void ei(View rootView) {
        this.productListView = (ECBaseRecyclerView) rootView.findViewById(R.id.f163065o41);
        Context requireContext = requireContext();
        com.tencent.ecommerce.biz.showwindow.viewmodel.b bVar = this.viewModel;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        this.productListAdapter = new ECShowWindowProductListAdapter(requireContext, bVar, null, true, this.channel, "", this.windowType);
        ECBaseRecyclerView eCBaseRecyclerView = this.productListView;
        if (eCBaseRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("productListView");
        }
        ECShowWindowProductListAdapter eCShowWindowProductListAdapter = this.productListAdapter;
        if (eCShowWindowProductListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("productListAdapter");
        }
        eCBaseRecyclerView.setAdapter(eCShowWindowProductListAdapter);
        ECBaseRecyclerView eCBaseRecyclerView2 = this.productListView;
        if (eCBaseRecyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("productListView");
        }
        eCBaseRecyclerView2.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        ECBaseRecyclerView eCBaseRecyclerView3 = this.productListView;
        if (eCBaseRecyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("productListView");
        }
        eCBaseRecyclerView3.addOnScrollListener(new d());
    }

    private final void initViews(View rootView) {
        this.loadingPage = (FrameLayout) rootView.findViewById(R.id.nze);
        this.loadingIcon = (ImageView) rootView.findViewById(R.id.o1l);
    }

    public static /* synthetic */ void ni(ECLiveShowWindowListFragment eCLiveShowWindowListFragment, String str, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = "";
        }
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        if ((i3 & 4) != 0) {
            z17 = false;
        }
        eCLiveShowWindowListFragment.mi(str, z16, z17);
    }

    public /* synthetic */ ECLiveShowWindowListFragment(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Zh() {
    }
}
