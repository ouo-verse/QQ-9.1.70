package com.tencent.ecommerce.biz.showwindow.fragment;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.RotateAnimation;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;
import ck0.Product;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.d;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.ecommerce.base.fragment.ECBaseFragment;
import com.tencent.ecommerce.base.router.api.IECSchemeCallback;
import com.tencent.ecommerce.base.ui.ECSkin;
import com.tencent.ecommerce.base.ui.SoftKeyboardStateHelper;
import com.tencent.ecommerce.base.ui.g;
import com.tencent.ecommerce.biz.live.LiveTabId;
import com.tencent.ecommerce.biz.showwindow.ui.adapter.a;
import com.tencent.ecommerce.biz.showwindow.viewmodel.b;
import com.tencent.ecommerce.biz.util.ECDebugUtils;
import com.tencent.ecommerce.biz.util.r;
import com.tencent.ecommerce.repo.live.ECShopDetail;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.request.GetAdInfoRequest;
import ei0.c;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import mqq.app.Constants;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ae\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001c\u0018\u0000 \u0088\u00012\u00020\u00012\u00020\u0002:\u0002\u0089\u0001B\t\u00a2\u0006\u0006\b\u0086\u0001\u0010\u0087\u0001J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u001a\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\u0011\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0012\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0013\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0006\u0010\u0014\u001a\u00020\nJ\b\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0017\u001a\u00020\nH\u0002J\u0010\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\fH\u0003J\b\u0010\u001a\u001a\u00020\nH\u0002J\b\u0010\u001b\u001a\u00020\nH\u0002J\b\u0010\u001c\u001a\u00020\nH\u0002J\u001a\u0010 \u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0002J\b\u0010!\u001a\u00020\nH\u0002J\u0010\u0010\"\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\fH\u0002J\u0010\u0010$\u001a\u00020\n2\u0006\u0010#\u001a\u00020\u0015H\u0002J\b\u0010%\u001a\u00020\nH\u0002J\u0010\u0010'\u001a\u00020\n2\u0006\u0010&\u001a\u00020\u001eH\u0002J\b\u0010(\u001a\u00020\nH\u0002J\u0010\u0010)\u001a\u00020\n2\u0006\u0010&\u001a\u00020\u001eH\u0002J\b\u0010*\u001a\u00020\nH\u0002R\u0016\u0010-\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00100\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00104\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00106\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u0010/R\u0016\u00108\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u0010/R\u0016\u0010:\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010/R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010DR&\u0010J\u001a\u0012\u0012\u0004\u0012\u00020F0Ej\b\u0012\u0004\u0012\u00020F`G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010N\u001a\u00020K8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010R\u001a\u00020O8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010V\u001a\u00020S8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010Z\u001a\u00020W8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bX\u0010YR\u0016\u0010^\u001a\u00020[8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\\\u0010]R\u0016\u0010b\u001a\u00020_8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b`\u0010aR\u0016\u0010e\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bc\u0010dR\u0016\u0010g\u001a\u00020[8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bf\u0010]R\u0016\u0010i\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bh\u0010dR\u0016\u0010m\u001a\u00020j8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bk\u0010lR\u0016\u0010q\u001a\u00020n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bo\u0010pR\u0016\u0010s\u001a\u00020j8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\br\u0010lR\u0016\u0010u\u001a\u00020n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bt\u0010pR\u0016\u0010w\u001a\u00020n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bv\u0010pR\u0016\u0010y\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bx\u0010dR\u0016\u0010{\u001a\u00020n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bz\u0010pR\u0016\u0010}\u001a\u00020n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b|\u0010pR\u0016\u0010\u007f\u001a\u00020[8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b~\u0010]R\u0018\u0010\u0081\u0001\u001a\u00020?8\u0002@\u0002X\u0082.\u00a2\u0006\u0007\n\u0005\b\u0080\u0001\u0010AR\u0018\u0010\u0083\u0001\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0082\u0001\u0010LR\u0018\u0010\u0085\u0001\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0084\u0001\u0010L\u00a8\u0006\u008a\u0001"}, d2 = {"Lcom/tencent/ecommerce/biz/showwindow/fragment/ECLiveQShopShowWindowFragment;", "Lcom/tencent/ecommerce/base/fragment/ECBaseFragment;", "Lcom/google/android/material/tabs/TabLayout$d;", "", "getContentLayoutId", "", "getBusinessDescription", "uh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", "Landroid/view/View;", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Lcom/google/android/material/tabs/TabLayout$g;", "tab", "onTabSelected", "onTabUnselected", "onTabReselected", "ni", "", "onBackPressed", "initArguments", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "initView", "ki", "ei", "mi", "position", "Lcom/tencent/ecommerce/biz/showwindow/fragment/ECLiveShowWindowListFragment;", "currentFragment", "gi", "di", "fi", "searching", "oi", "li", "fragment", "ii", "hi", WidgetCacheLunarData.JI, "ci", "P", "I", "windowType", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Ljava/lang/String;", "deliverProductCallbackId", "Lcom/tencent/ecommerce/base/router/api/IECSchemeCallback;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/ecommerce/base/router/api/IECSchemeCallback;", "deliverProductCallback", ExifInterface.LATITUDE_SOUTH, WadlProxyConsts.CHANNEL, "T", GetAdInfoRequest.SOURCE_FROM, "U", "liveUserId", "", "V", "J", "liveRoomId", "Landroid/widget/ImageView;", "W", "Landroid/widget/ImageView;", "backButton", "X", "Lcom/tencent/ecommerce/biz/showwindow/fragment/ECLiveShowWindowListFragment;", "Ljava/util/ArrayList;", "Lcom/tencent/ecommerce/repo/live/h;", "Lkotlin/collections/ArrayList;", "Y", "Ljava/util/ArrayList;", "shopList", "Landroidx/viewpager2/widget/ViewPager2;", "Z", "Landroidx/viewpager2/widget/ViewPager2;", "viewpager", "Lcom/tencent/ecommerce/biz/showwindow/ui/adapter/a;", "a0", "Lcom/tencent/ecommerce/biz/showwindow/ui/adapter/a;", "adapter", "Lcom/google/android/material/tabs/TabLayout;", "b0", "Lcom/google/android/material/tabs/TabLayout;", "tabLayout", "Lcom/tencent/ecommerce/biz/showwindow/viewmodel/a;", "c0", "Lcom/tencent/ecommerce/biz/showwindow/viewmodel/a;", "globalViewModel", "Landroid/view/ViewGroup;", "d0", "Landroid/view/ViewGroup;", "actualSearchBarContainer", "Landroid/widget/EditText;", "e0", "Landroid/widget/EditText;", "actutalSearchBar", "f0", "Landroid/view/View;", "searchDeleteButton", "g0", "titleContainer", "h0", "searchBarContainer", "Landroid/widget/LinearLayout;", "i0", "Landroid/widget/LinearLayout;", "searchBar", "Landroid/widget/TextView;", "j0", "Landroid/widget/TextView;", "searchTextView", "k0", "searchIconAndText", "l0", "searchCancel", "m0", "titleTextView", "n0", "liveEditToolBar", "o0", "liveSelectedNumberTextView", "p0", "liveConfirmBtn", "q0", "loadingLayout", "r0", "loadingIcon", "s0", "isCurrentNightMode", "t0", "needSaveOperateBeforeBack", "<init>", "()V", "u0", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECLiveQShopShowWindowFragment extends ECBaseFragment implements TabLayout.d {

    /* renamed from: R, reason: from kotlin metadata */
    private IECSchemeCallback deliverProductCallback;

    /* renamed from: V, reason: from kotlin metadata */
    private long liveRoomId;

    /* renamed from: W, reason: from kotlin metadata */
    private ImageView backButton;

    /* renamed from: X, reason: from kotlin metadata */
    private ECLiveShowWindowListFragment currentFragment;

    /* renamed from: Z, reason: from kotlin metadata */
    private ViewPager2 viewpager;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private a adapter;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private TabLayout tabLayout;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private com.tencent.ecommerce.biz.showwindow.viewmodel.a globalViewModel;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private ViewGroup actualSearchBarContainer;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private EditText actutalSearchBar;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private View searchDeleteButton;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private ViewGroup titleContainer;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    private View searchBarContainer;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    private LinearLayout searchBar;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    private TextView searchTextView;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    private LinearLayout searchIconAndText;

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    private TextView searchCancel;

    /* renamed from: m0, reason: collision with root package name and from kotlin metadata */
    private TextView titleTextView;

    /* renamed from: n0, reason: collision with root package name and from kotlin metadata */
    private View liveEditToolBar;

    /* renamed from: o0, reason: collision with root package name and from kotlin metadata */
    private TextView liveSelectedNumberTextView;

    /* renamed from: p0, reason: collision with root package name and from kotlin metadata */
    private TextView liveConfirmBtn;

    /* renamed from: q0, reason: collision with root package name and from kotlin metadata */
    private ViewGroup loadingLayout;

    /* renamed from: r0, reason: collision with root package name and from kotlin metadata */
    private ImageView loadingIcon;

    /* renamed from: s0, reason: collision with root package name and from kotlin metadata */
    private boolean isCurrentNightMode;

    /* renamed from: t0, reason: collision with root package name and from kotlin metadata */
    private boolean needSaveOperateBeforeBack;

    /* renamed from: P, reason: from kotlin metadata */
    private int windowType = 1;

    /* renamed from: Q, reason: from kotlin metadata */
    private String deliverProductCallbackId = "";

    /* renamed from: S, reason: from kotlin metadata */
    private String channel = "";

    /* renamed from: T, reason: from kotlin metadata */
    private String sourceFrom = "";

    /* renamed from: U, reason: from kotlin metadata */
    private String liveUserId = "";

    /* renamed from: Y, reason: from kotlin metadata */
    private ArrayList<ECShopDetail> shopList = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/google/android/material/tabs/TabLayout$g;", "tab", "", "position", "", "a", "(Lcom/google/android/material/tabs/TabLayout$g;I)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b implements d.b {
        b() {
        }

        @Override // com.google.android.material.tabs.d.b
        public final void a(TabLayout.g gVar, int i3) {
            gVar.t(ECLiveQShopShowWindowFragment.Oh(ECLiveQShopShowWindowFragment.this).i0(i3));
            View childAt = gVar.f34288i.getChildAt(1);
            if (!(childAt instanceof TextView)) {
                childAt = null;
            }
            TextView textView = (TextView) childAt;
            if (textView != null) {
                textView.setMaxLines(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!ECLiveQShopShowWindowFragment.this.onBackPressed()) {
                ECLiveQShopShowWindowFragment.this.ci();
                ECLiveQShopShowWindowFragment.this.requireActivity().finish();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECLiveQShopShowWindowFragment.Nh(ECLiveQShopShowWindowFragment.this).setText("");
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECLiveQShopShowWindowFragment.this.ni();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/lang/Integer;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class g<T> implements Observer<Integer> {
        g() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(Integer num) {
            TextView Th = ECLiveQShopShowWindowFragment.Th(ECLiveQShopShowWindowFragment.this);
            Context context = ECLiveQShopShowWindowFragment.this.getContext();
            Th.setText(context != null ? context.getString(R.string.wsl, num) : null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class h<T> implements Observer<Boolean> {
        h() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(Boolean bool) {
            ECLiveQShopShowWindowFragment.this.needSaveOperateBeforeBack = bool.booleanValue();
            ECLiveQShopShowWindowFragment.Sh(ECLiveQShopShowWindowFragment.this).setEnabled(Intrinsics.areEqual(bool, Boolean.TRUE));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/lang/Integer;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class i<T> implements Observer<Integer> {
        i() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(Integer num) {
            ECLiveQShopShowWindowFragment.this.needSaveOperateBeforeBack = false;
            ECLiveQShopShowWindowFragment.this.ci();
            FragmentActivity activity = ECLiveQShopShowWindowFragment.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lck0/c;", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/util/List;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class j<T> implements Observer<List<? extends Product>> {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ECLiveShowWindowListFragment f104512e;

        j(ECLiveShowWindowListFragment eCLiveShowWindowListFragment) {
            this.f104512e = eCLiveShowWindowListFragment;
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(List<Product> list) {
            ECLiveQShopShowWindowFragment.Rh(ECLiveQShopShowWindowFragment.this).G3(this.f104512e.getShopId(), list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lck0/c;", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/util/List;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class k<T> implements Observer<List<? extends Product>> {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ECLiveShowWindowListFragment f104514e;

        k(ECLiveShowWindowListFragment eCLiveShowWindowListFragment) {
            this.f104514e = eCLiveShowWindowListFragment;
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(List<Product> list) {
            ECLiveQShopShowWindowFragment.Rh(ECLiveQShopShowWindowFragment.this).H3(this.f104514e.getShopId(), list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lck0/c;", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/util/List;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class l<T> implements Observer<List<? extends Product>> {
        l() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(List<Product> list) {
            ECLiveQShopShowWindowFragment.Wh(ECLiveQShopShowWindowFragment.this).setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/lang/Integer;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class m<T> implements Observer<Integer> {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ECLiveShowWindowListFragment f104517e;

        m(ECLiveShowWindowListFragment eCLiveShowWindowListFragment) {
            this.f104517e = eCLiveShowWindowListFragment;
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(Integer num) {
            Integer value = this.f104517e.bi().H2().getValue();
            if (value == null) {
                value = 0;
            }
            int intValue = value.intValue();
            int z36 = ECLiveQShopShowWindowFragment.Rh(ECLiveQShopShowWindowFragment.this).z3();
            if (num.intValue() > 0 && z36 <= 0) {
                ECLiveQShopShowWindowFragment.Rh(ECLiveQShopShowWindowFragment.this).D3(num.intValue());
            }
            this.f104517e.bi().D3(intValue + ECLiveQShopShowWindowFragment.Rh(ECLiveQShopShowWindowFragment.this).A3());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class n implements View.OnClickListener {
        n() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECLiveQShopShowWindowFragment.this.oi(true);
            com.tencent.ecommerce.biz.common.f.f101556a.d(ECLiveQShopShowWindowFragment.this.channel, "window_search_bar_clk");
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public static final /* synthetic */ EditText Nh(ECLiveQShopShowWindowFragment eCLiveQShopShowWindowFragment) {
        EditText editText = eCLiveQShopShowWindowFragment.actutalSearchBar;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actutalSearchBar");
        }
        return editText;
    }

    public static final /* synthetic */ a Oh(ECLiveQShopShowWindowFragment eCLiveQShopShowWindowFragment) {
        a aVar = eCLiveQShopShowWindowFragment.adapter;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        return aVar;
    }

    public static final /* synthetic */ com.tencent.ecommerce.biz.showwindow.viewmodel.a Rh(ECLiveQShopShowWindowFragment eCLiveQShopShowWindowFragment) {
        com.tencent.ecommerce.biz.showwindow.viewmodel.a aVar = eCLiveQShopShowWindowFragment.globalViewModel;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("globalViewModel");
        }
        return aVar;
    }

    public static final /* synthetic */ TextView Sh(ECLiveQShopShowWindowFragment eCLiveQShopShowWindowFragment) {
        TextView textView = eCLiveQShopShowWindowFragment.liveConfirmBtn;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("liveConfirmBtn");
        }
        return textView;
    }

    public static final /* synthetic */ TextView Th(ECLiveQShopShowWindowFragment eCLiveQShopShowWindowFragment) {
        TextView textView = eCLiveQShopShowWindowFragment.liveSelectedNumberTextView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("liveSelectedNumberTextView");
        }
        return textView;
    }

    public static final /* synthetic */ LinearLayout Uh(ECLiveQShopShowWindowFragment eCLiveQShopShowWindowFragment) {
        LinearLayout linearLayout = eCLiveQShopShowWindowFragment.searchBar;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBar");
        }
        return linearLayout;
    }

    public static final /* synthetic */ ViewPager2 Wh(ECLiveQShopShowWindowFragment eCLiveQShopShowWindowFragment) {
        ViewPager2 viewPager2 = eCLiveQShopShowWindowFragment.viewpager;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewpager");
        }
        return viewPager2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ci() {
        JSONObject jSONObject = new JSONObject();
        com.tencent.ecommerce.biz.showwindow.viewmodel.a aVar = this.globalViewModel;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("globalViewModel");
        }
        jSONObject.put("shop_product_counts", aVar.D2().getValue());
        jSONObject.put("need_update", true);
        jSONObject.put("is_from_shopwindow", true);
        jSONObject.put("live_tab_id", LiveTabId.LIVE_TAB_QSHOP.getValue());
        IECSchemeCallback iECSchemeCallback = this.deliverProductCallback;
        if (iECSchemeCallback != null) {
            iECSchemeCallback.onCallbackFinished(jSONObject);
        }
        cg0.a.b("ECLiveQShopShowWindowFragment", "callbackFinished, callback=" + this.deliverProductCallback + ", json=" + jSONObject);
    }

    private final void di() {
        final Context context = getContext();
        if (context != null) {
            final com.tencent.ecommerce.base.ui.g gVar = new com.tencent.ecommerce.base.ui.g(context);
            gVar.Y(context.getResources().getString(R.string.wnd));
            gVar.b0(context.getResources().getString(R.string.wnl));
            gVar.f0(context.getResources().getString(R.string.wnj));
            gVar.d0(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.showwindow.fragment.ECLiveQShopShowWindowFragment$checkOperationSave$1$1$1
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
                    c cVar = c.f396302a;
                    cVar.l(g.this.X());
                    cVar.k(g.this.S());
                }
            });
            gVar.a0(new Function1<View, Unit>() { // from class: com.tencent.ecommerce.biz.showwindow.fragment.ECLiveQShopShowWindowFragment$checkOperationSave$$inlined$also$lambda$1
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
                    c.f396302a.c(g.this.S());
                    this.ci();
                    FragmentActivity activity = this.getActivity();
                    if (activity != null) {
                        activity.finish();
                    }
                }
            });
            gVar.e0(new Function1<View, Unit>() { // from class: com.tencent.ecommerce.biz.showwindow.fragment.ECLiveQShopShowWindowFragment$checkOperationSave$$inlined$also$lambda$2
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
                    c.f396302a.c(g.this.X());
                    this.ni();
                }
            });
            gVar.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ei() {
        ImageView imageView = this.loadingIcon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingIcon");
        }
        imageView.clearAnimation();
        ViewGroup viewGroup = this.loadingLayout;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingLayout");
        }
        viewGroup.setVisibility(8);
    }

    private final void fi(View rootView) {
        cg0.a.b("ECLiveQShopShowWindowFragment", "[initWindowTypePage], windowType = " + this.windowType);
        this.liveEditToolBar = rootView.findViewById(R.id.o9b);
        this.liveSelectedNumberTextView = (TextView) rootView.findViewById(R.id.odv);
        this.liveConfirmBtn = (TextView) rootView.findViewById(R.id.odu);
        new View(getContext()).setLayoutParams(new ViewGroup.LayoutParams(-1, com.tencent.ecommerce.biz.util.e.c(20.0f)));
        this.actualSearchBarContainer = (ViewGroup) rootView.findViewById(R.id.o2p);
        this.actutalSearchBar = (EditText) rootView.findViewById(R.id.nyr);
        this.titleContainer = (ViewGroup) rootView.findViewById(R.id.o3j);
        this.searchDeleteButton = rootView.findViewById(R.id.o1g);
        EditText editText = this.actutalSearchBar;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actutalSearchBar");
        }
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.tencent.ecommerce.biz.showwindow.fragment.ECLiveQShopShowWindowFragment$initWindowTypePage$1
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
                b bi5;
                if (i3 != 3) {
                    return true;
                }
                ECLiveQShopShowWindowFragment.Wh(ECLiveQShopShowWindowFragment.this).setVisibility(0);
                String obj = textView.getText().toString();
                ECLiveShowWindowListFragment eCLiveShowWindowListFragment = ECLiveQShopShowWindowFragment.this.currentFragment;
                if (eCLiveShowWindowListFragment != null && (bi5 = eCLiveShowWindowListFragment.bi()) != null) {
                    bi5.s3(obj);
                }
                ECLiveShowWindowListFragment eCLiveShowWindowListFragment2 = ECLiveQShopShowWindowFragment.this.currentFragment;
                if (eCLiveShowWindowListFragment2 != null) {
                    ECLiveShowWindowListFragment.ni(eCLiveShowWindowListFragment2, null, false, false, 7, null);
                }
                c.f396302a.h(ECLiveQShopShowWindowFragment.Uh(ECLiveQShopShowWindowFragment.this), obj);
                ECLiveQShopShowWindowFragment.Nh(ECLiveQShopShowWindowFragment.this).post(new Runnable() { // from class: com.tencent.ecommerce.biz.showwindow.fragment.ECLiveQShopShowWindowFragment$initWindowTypePage$1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        ECLiveQShopShowWindowFragment.Nh(ECLiveQShopShowWindowFragment.this).clearFocus();
                        SoftKeyboardStateHelper.INSTANCE.d(ECLiveQShopShowWindowFragment.Nh(ECLiveQShopShowWindowFragment.this));
                    }
                });
                return true;
            }
        });
        View view = this.searchDeleteButton;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchDeleteButton");
        }
        view.setOnClickListener(new e());
        TextView textView = this.liveConfirmBtn;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("liveConfirmBtn");
        }
        textView.setOnClickListener(new f());
        oi(false);
        ei0.c cVar = ei0.c.f396302a;
        cVar.q(this);
        TextView textView2 = this.liveConfirmBtn;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("liveConfirmBtn");
        }
        cVar.j(textView2);
        LinearLayout linearLayout = this.searchBar;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBar");
        }
        TextView textView3 = this.searchTextView;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchTextView");
        }
        cVar.p(linearLayout, textView3.getText().toString());
    }

    private final void hi() {
        com.tencent.ecommerce.biz.showwindow.viewmodel.a aVar = this.globalViewModel;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("globalViewModel");
        }
        aVar.H2().observe(getViewLifecycleOwner(), new g());
        com.tencent.ecommerce.biz.showwindow.viewmodel.a aVar2 = this.globalViewModel;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("globalViewModel");
        }
        aVar2.v2().observe(getViewLifecycleOwner(), new h());
        com.tencent.ecommerce.biz.showwindow.viewmodel.a aVar3 = this.globalViewModel;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("globalViewModel");
        }
        aVar3.D2().observe(getViewLifecycleOwner(), new i());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ii(ECLiveShowWindowListFragment fragment) {
        ji(fragment);
        hi();
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
        if (arguments == null || (str = arguments.getString("scheme_callback_id")) == null) {
            str = "";
        }
        this.deliverProductCallbackId = str;
        this.deliverProductCallback = ug0.a.b(str);
        Bundle arguments2 = getArguments();
        if (arguments2 == null || (str2 = arguments2.getString(WadlProxyConsts.CHANNEL)) == null) {
            str2 = "";
        }
        this.channel = str2;
        Bundle arguments3 = getArguments();
        if (arguments3 == null || (str3 = arguments3.getString("source_from")) == null) {
            str3 = "";
        }
        this.sourceFrom = str3;
        this.isCurrentNightMode = fg0.a.f398587b.a();
        Bundle arguments4 = getArguments();
        if (arguments4 != null && (string2 = arguments4.getString("live_user_id")) != null) {
            str5 = string2;
        }
        this.liveUserId = str5;
        Bundle arguments5 = getArguments();
        if (arguments5 == null || (str4 = arguments5.getString("live_room_id")) == null) {
            str4 = "0";
        }
        this.liveRoomId = Long.parseLong(str4);
        try {
            Bundle arguments6 = getArguments();
            this.windowType = (arguments6 == null || (string = arguments6.getString("window_type")) == null) ? 1 : Integer.parseInt(string);
        } catch (NumberFormatException e16) {
            cg0.a.a("ECLiveQShopShowWindowFragment", "[initArguments]", e16.toString());
        }
        cg0.a.b("ECLiveQShopShowWindowFragment", "[initArguments] deliverProductCallId = " + this.deliverProductCallbackId + ", channel = " + this.channel + ", sourceFrom = " + this.sourceFrom + ", isNightMode = " + this.isCurrentNightMode + ", windowType = " + this.windowType + ", liveUserId = " + this.liveUserId + ", liveRoomId = " + this.liveRoomId);
    }

    private final void ji(ECLiveShowWindowListFragment fragment) {
        fragment.bi().B2().observe(getViewLifecycleOwner(), new j(fragment));
        fragment.bi().G2().observe(getViewLifecycleOwner(), new k(fragment));
        fragment.bi().C3(new Function1<Product, Unit>() { // from class: com.tencent.ecommerce.biz.showwindow.fragment.ECLiveQShopShowWindowFragment$registerLiveWindowDataObserver$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Product product) {
                invoke2(product);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Product product) {
                ECLiveQShopShowWindowFragment.Rh(ECLiveQShopShowWindowFragment.this).E3(product);
            }
        });
        fragment.bi().A2().observe(getViewLifecycleOwner(), new l());
        fragment.bi().x2().observe(getViewLifecycleOwner(), new m(fragment));
    }

    private final void ki() {
        Integer intOrNull;
        mi();
        long j3 = this.liveRoomId;
        String str = this.liveUserId;
        intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(this.channel);
        com.tencent.ecommerce.base.network.service.a.b("trpc.ecom.qqlive_my_window_svr.QqliveMyWindowSvr", "/trpc.ecom.qqlive_my_window_svr.QqliveMyWindowSvr/GetShop", new ej0.a(j3, str, intOrNull != null ? intOrNull.intValue() : 0), new ej0.b(), new ECLiveQShopShowWindowFragment$requestShopList$1(this));
    }

    private final void li() {
        LinearLayout linearLayout = this.searchBar;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBar");
        }
        linearLayout.setOnClickListener(new n());
    }

    private final void mi() {
        ViewGroup viewGroup = this.loadingLayout;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingLayout");
        }
        viewGroup.setVisibility(0);
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
    public final void oi(boolean searching) {
        if (searching) {
            ViewPager2 viewPager2 = this.viewpager;
            if (viewPager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewpager");
            }
            viewPager2.setUserInputEnabled(false);
            TabLayout tabLayout = this.tabLayout;
            if (tabLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
            }
            tabLayout.setVisibility(8);
            ViewGroup viewGroup = this.titleContainer;
            if (viewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
            }
            viewGroup.setVisibility(8);
            View view = this.searchBarContainer;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchBarContainer");
            }
            view.setVisibility(8);
            ViewGroup viewGroup2 = this.actualSearchBarContainer;
            if (viewGroup2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("actualSearchBarContainer");
            }
            viewGroup2.setVisibility(0);
            ViewPager2 viewPager22 = this.viewpager;
            if (viewPager22 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewpager");
            }
            viewPager22.setVisibility(8);
            EditText editText = this.actutalSearchBar;
            if (editText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("actutalSearchBar");
            }
            editText.setText("");
            EditText editText2 = this.actutalSearchBar;
            if (editText2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("actutalSearchBar");
            }
            editText2.post(new Runnable() { // from class: com.tencent.ecommerce.biz.showwindow.fragment.ECLiveQShopShowWindowFragment$updateSearchBarState$1
                @Override // java.lang.Runnable
                public final void run() {
                    ECLiveQShopShowWindowFragment.Nh(ECLiveQShopShowWindowFragment.this).requestFocus();
                    SoftKeyboardStateHelper.INSTANCE.f(ECLiveQShopShowWindowFragment.Nh(ECLiveQShopShowWindowFragment.this));
                }
            });
            return;
        }
        ViewPager2 viewPager23 = this.viewpager;
        if (viewPager23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewpager");
        }
        viewPager23.setUserInputEnabled(true);
        TabLayout tabLayout2 = this.tabLayout;
        if (tabLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
        }
        tabLayout2.setVisibility(0);
        ViewGroup viewGroup3 = this.titleContainer;
        if (viewGroup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
        }
        viewGroup3.setVisibility(0);
        View view2 = this.searchBarContainer;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBarContainer");
        }
        view2.setVisibility(0);
        ViewGroup viewGroup4 = this.actualSearchBarContainer;
        if (viewGroup4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actualSearchBarContainer");
        }
        viewGroup4.setVisibility(8);
        SoftKeyboardStateHelper.Companion companion = SoftKeyboardStateHelper.INSTANCE;
        EditText editText3 = this.actutalSearchBar;
        if (editText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actutalSearchBar");
        }
        companion.d(editText3);
    }

    @Override // com.tencent.ecommerce.base.fragment.api.IECBaseFragment
    /* renamed from: getBusinessDescription */
    public String getTAG() {
        return "ECLiveQShopShowWindowFragment";
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int getContentLayoutId() {
        return R.layout.cqq;
    }

    public final void ni() {
        Bundle bundle = new Bundle();
        bundle.putLong("roomId", this.liveRoomId);
        bundle.putString("userId", this.liveUserId);
        com.tencent.ecommerce.biz.showwindow.viewmodel.a aVar = this.globalViewModel;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("globalViewModel");
        }
        aVar.u3(bundle);
        ei0.c cVar = ei0.c.f396302a;
        com.tencent.ecommerce.biz.showwindow.viewmodel.a aVar2 = this.globalViewModel;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("globalViewModel");
        }
        cVar.e(this, aVar2.B2().getValue(), this.windowType);
        com.tencent.ecommerce.biz.showwindow.viewmodel.a aVar3 = this.globalViewModel;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("globalViewModel");
        }
        cVar.f(this, aVar3.G2().getValue(), this.windowType);
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, com.tencent.ecommerce.base.ui.api.IECFragmentApi
    public boolean onBackPressed() {
        com.tencent.ecommerce.biz.showwindow.viewmodel.b bi5;
        ViewGroup viewGroup = this.actualSearchBarContainer;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actualSearchBarContainer");
        }
        if (viewGroup.getVisibility() == 0) {
            oi(false);
            ECLiveShowWindowListFragment eCLiveShowWindowListFragment = this.currentFragment;
            if (eCLiveShowWindowListFragment != null && (bi5 = eCLiveShowWindowListFragment.bi()) != null) {
                bi5.s3("");
            }
            ECLiveShowWindowListFragment eCLiveShowWindowListFragment2 = this.currentFragment;
            if (eCLiveShowWindowListFragment2 == null) {
                return true;
            }
            ECLiveShowWindowListFragment.ni(eCLiveShowWindowListFragment2, null, false, false, 7, null);
            return true;
        }
        if (!this.needSaveOperateBeforeBack) {
            return false;
        }
        di();
        return true;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setRequestedOrientation(1);
        }
        initArguments();
        r.f104881b.e(getActivity(), true);
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        com.tencent.ecommerce.biz.showwindow.viewmodel.a aVar = (com.tencent.ecommerce.biz.showwindow.viewmodel.a) new ViewModelProvider(this).get(com.tencent.ecommerce.biz.showwindow.viewmodel.a.class);
        Bundle arguments = getArguments();
        if (arguments != null) {
            aVar.Q2(arguments);
        }
        Unit unit = Unit.INSTANCE;
        this.globalViewModel = aVar;
        initView(view);
        fi(view);
        ki();
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int uh() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            com.tencent.ecommerce.biz.showwindow.viewmodel.b bi5;
            view.setVisibility(8);
            ECLiveShowWindowListFragment eCLiveShowWindowListFragment = ECLiveQShopShowWindowFragment.this.currentFragment;
            if (eCLiveShowWindowListFragment != null && (bi5 = eCLiveShowWindowListFragment.bi()) != null) {
                bi5.s3("");
            }
            ECLiveShowWindowListFragment eCLiveShowWindowListFragment2 = ECLiveQShopShowWindowFragment.this.currentFragment;
            if (eCLiveShowWindowListFragment2 != null) {
                ECLiveShowWindowListFragment.ni(eCLiveShowWindowListFragment2, null, false, false, 7, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void gi(int position, ECLiveShowWindowListFragment currentFragment) {
        Integer num;
        com.tencent.ecommerce.biz.showwindow.viewmodel.b bi5;
        com.tencent.ecommerce.biz.showwindow.viewmodel.b bi6;
        MutableLiveData<Integer> H2;
        if (currentFragment == null || (bi6 = currentFragment.bi()) == null || (H2 = bi6.H2()) == null || (num = H2.getValue()) == null) {
            num = 0;
        }
        int intValue = num.intValue();
        com.tencent.ecommerce.biz.showwindow.viewmodel.a aVar = this.globalViewModel;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("globalViewModel");
        }
        if (aVar.z3() < 0 || currentFragment == null || (bi5 = currentFragment.bi()) == null) {
            return;
        }
        com.tencent.ecommerce.biz.showwindow.viewmodel.a aVar2 = this.globalViewModel;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("globalViewModel");
        }
        bi5.D3(intValue + aVar2.A3());
    }

    private final void initView(View rootView) {
        this.backButton = (ImageView) rootView.findViewById(R.id.o18);
        this.searchBarContainer = rootView.findViewById(R.id.o9u);
        this.searchBar = (LinearLayout) rootView.findViewById(R.id.nzi);
        this.searchTextView = (TextView) rootView.findViewById(R.id.oe8);
        this.searchIconAndText = (LinearLayout) rootView.findViewById(R.id.o3c);
        this.searchCancel = (TextView) rootView.findViewById(R.id.oe7);
        this.titleTextView = (TextView) rootView.findViewById(R.id.oer);
        this.loadingLayout = (ViewGroup) rootView.findViewById(R.id.o8a);
        this.loadingIcon = (ImageView) rootView.findViewById(R.id.o8b);
        ViewPager2 viewPager2 = (ViewPager2) rootView.findViewById(R.id.of8);
        this.viewpager = viewPager2;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewpager");
        }
        viewPager2.setOffscreenPageLimit(1);
        ViewPager2 viewPager22 = this.viewpager;
        if (viewPager22 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewpager");
        }
        viewPager22.registerOnPageChangeCallback(new ECLiveQShopShowWindowFragment$initView$1(this));
        this.adapter = new a(this, this.shopList, new Function1<Fragment, Unit>() { // from class: com.tencent.ecommerce.biz.showwindow.fragment.ECLiveQShopShowWindowFragment$initView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Fragment fragment) {
                invoke2(fragment);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Fragment fragment) {
                ECLiveQShopShowWindowFragment eCLiveQShopShowWindowFragment = ECLiveQShopShowWindowFragment.this;
                if (fragment == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.tencent.ecommerce.biz.showwindow.fragment.ECLiveShowWindowListFragment");
                }
                eCLiveQShopShowWindowFragment.ii((ECLiveShowWindowListFragment) fragment);
            }
        });
        ViewPager2 viewPager23 = this.viewpager;
        if (viewPager23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewpager");
        }
        a aVar = this.adapter;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        viewPager23.setAdapter(aVar);
        TabLayout tabLayout = (TabLayout) rootView.findViewById(R.id.ocn);
        this.tabLayout = tabLayout;
        if (tabLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
        }
        ViewPager2 viewPager24 = this.viewpager;
        if (viewPager24 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewpager");
        }
        new com.google.android.material.tabs.d(tabLayout, viewPager24, true, true, new b()).a();
        TabLayout tabLayout2 = this.tabLayout;
        if (tabLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
        }
        tabLayout2.f(this);
        Integer color = ECSkin.INSTANCE.getColor("qecommerce_skin_color_text_primary");
        if (color != null) {
            int intValue = color.intValue();
            TabLayout tabLayout3 = this.tabLayout;
            if (tabLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
            }
            tabLayout3.setSelectedTabIndicatorColor(intValue);
            TabLayout tabLayout4 = this.tabLayout;
            if (tabLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
            }
            tabLayout4.setTabTextColors(intValue, intValue);
        }
        ImageView imageView = this.backButton;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backButton");
        }
        imageView.setOnClickListener(new c());
        TextView textView = this.searchCancel;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchCancel");
        }
        textView.setOnClickListener(new d());
        li();
        ECDebugUtils eCDebugUtils = ECDebugUtils.f104852b;
        TextView textView2 = this.titleTextView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleTextView");
        }
        eCDebugUtils.e(textView2);
    }

    @Override // com.google.android.material.tabs.TabLayout.c
    public void onTabSelected(TabLayout.g tab) {
        TabLayout.TabView tabView;
        View childAt = (tab == null || (tabView = tab.f34288i) == null) ? null : tabView.getChildAt(1);
        TextView textView = (TextView) (childAt instanceof TextView ? childAt : null);
        if (textView != null) {
            textView.setTypeface(Typeface.DEFAULT_BOLD);
        }
    }

    @Override // com.google.android.material.tabs.TabLayout.c
    public void onTabUnselected(TabLayout.g tab) {
        TabLayout.TabView tabView;
        View childAt = (tab == null || (tabView = tab.f34288i) == null) ? null : tabView.getChildAt(1);
        TextView textView = (TextView) (childAt instanceof TextView ? childAt : null);
        if (textView != null) {
            textView.setTypeface(Typeface.DEFAULT);
        }
    }

    @Override // com.google.android.material.tabs.TabLayout.c
    public void onTabReselected(TabLayout.g tab) {
    }
}
