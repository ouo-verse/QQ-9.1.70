package com.tencent.ecommerce.base.fragment;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.view.LayoutInflaterCompat;
import androidx.core.view.ViewKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.eventbus.LifecycleEventBus;
import com.tencent.ecommerce.base.fragment.api.IECBaseFragment;
import com.tencent.ecommerce.base.fragment.api.IECContentDescProvider;
import com.tencent.ecommerce.base.permission.api.PermissionListener;
import com.tencent.ecommerce.base.plugin.ECPluginApplication;
import com.tencent.ecommerce.base.router.api.IECSchemeCallback;
import com.tencent.ecommerce.base.ui.ECSkin;
import com.tencent.ecommerce.biz.util.r;
import com.tencent.ecommerce.repo.ServiceLocator;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.pts.utils.PTSDeviceUtil;
import com.tencent.pts.utils.PTSFileUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import oicq.wlogin_sdk.tools.util;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\b&\u0018\u0000 w2\u00020\u00012\u00020\u0002:\u0001xB\u0007\u00a2\u0006\u0004\bu\u0010vJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\u0005H\u0002J%\u0010\u0010\u001a\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0012H\u0016J\b\u0010\u0016\u001a\u00020\u0012H\u0016J/\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00172\u000e\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\b\u0010 \u001a\u00020\u0001H\u0016J\u0010\u0010#\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020!H\u0016J\u0012\u0010&\u001a\u00020\u00052\b\u0010%\u001a\u0004\u0018\u00010$H\u0016J\u0012\u0010'\u001a\u00020\u00052\b\u0010%\u001a\u0004\u0018\u00010$H\u0016J&\u0010+\u001a\u0004\u0018\u00010*2\u0006\u0010)\u001a\u00020(2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010%\u001a\u0004\u0018\u00010$H\u0017J\b\u0010,\u001a\u00020\u0017H\u0016J\b\u0010-\u001a\u00020\u0012H\u0016J\b\u0010.\u001a\u00020\u0017H'J\u0010\u00100\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\fH\u0014J\u0012\u00100\u001a\u00020\u00052\b\b\u0001\u00101\u001a\u00020\u0017H\u0014J\u0010\u00103\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u0012H\u0004J\u0012\u00105\u001a\u00020\u00052\b\b\u0001\u00104\u001a\u00020\u0017H\u0004J\u0010\u00108\u001a\u00020\u00052\u0006\u00107\u001a\u000206H\u0004J\b\u00109\u001a\u00020\u0005H\u0014J\b\u0010:\u001a\u00020\u0017H\u0014J\u001a\u0010<\u001a\u00020\u00052\u0006\u0010;\u001a\u00020*2\b\u0010%\u001a\u0004\u0018\u00010$H\u0016J\u0012\u0010=\u001a\u00020\u00052\b\u0010%\u001a\u0004\u0018\u00010$H\u0016J\b\u0010>\u001a\u00020\u0005H\u0016J\b\u0010?\u001a\u00020\u0005H\u0017J\b\u0010@\u001a\u00020\u0005H\u0017J\b\u0010A\u001a\u00020\u0005H\u0017J\u0010\u0010C\u001a\u00020\u00052\u0006\u0010B\u001a\u00020$H\u0017J\b\u0010D\u001a\u00020\u0005H\u0016J\b\u0010E\u001a\u00020\u0005H\u0016J\b\u0010F\u001a\u00020\u0005H\u0016J\b\u0010G\u001a\u00020\u0012H\u0016J\u000e\u0010I\u001a\u00020\u00052\u0006\u0010H\u001a\u00020\fJ\u0006\u0010J\u001a\u00020\fJ\u0006\u0010K\u001a\u00020\u0005R\u001b\u0010P\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bL\u0010M\u001a\u0004\bN\u0010OR\u001b\u0010U\u001a\u00020Q8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bR\u0010M\u001a\u0004\bS\u0010TR\u0014\u0010Y\u001a\u00020V8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bW\u0010XR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u0014\u0010_\u001a\u00020\\8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b]\u0010^R\"\u0010g\u001a\u00020`8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\ba\u0010b\u001a\u0004\bc\u0010d\"\u0004\be\u0010fR\u0018\u0010k\u001a\u0004\u0018\u00010h8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bi\u0010jR\u0018\u0010o\u001a\u0004\u0018\u00010l8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bm\u0010nR\u0018\u0010q\u001a\u0004\u0018\u00010l8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bp\u0010nR\u0016\u0010t\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\br\u0010s\u00a8\u0006y"}, d2 = {"Lcom/tencent/ecommerce/base/fragment/ECBaseFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/tencent/ecommerce/base/fragment/api/IECBaseFragment;", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "", OcrConfig.CHINESE, "Kh", "th", "sh", "rh", "", "", "permissions", "Lcom/tencent/ecommerce/base/permission/api/PermissionListener;", "permissionListener", "Gh", "([Ljava/lang/String;Lcom/tencent/ecommerce/base/permission/api/PermissionListener;)V", "", "Eh", "Dh", "Ah", "Ch", "", "requestCode", "", "grantResults", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "realFragment", "Landroid/content/Context;", "context", "onAttach", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "onActivityCreated", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/View;", "onCreateView", "uh", "Bh", "getContentLayoutId", "title", "setTitle", "titleResId", "isVisible", "Hh", "resId", "Jh", "Landroid/view/View$OnClickListener;", "listener", "Ih", "Fh", "wh", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onViewStateRestored", "onStart", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, DKHippyEvent.EVENT_STOP, "outState", "onSaveInstanceState", "onDestroyView", "onDetach", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onBackPressed", "desc", "setContentDescription", "getContentDescription", "finish", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "vh", "()Ljava/lang/String;", "businessDesc", "Lcom/tencent/ecommerce/base/fragment/b;", "D", "xh", "()Lcom/tencent/ecommerce/base/fragment/b;", "fragmentLifecycleDelegate", "Lcom/tencent/ecommerce/base/fragment/api/IECContentDescProvider;", "E", "Lcom/tencent/ecommerce/base/fragment/api/IECContentDescProvider;", "contentDescProviderDelegate", UserInfo.SEX_FEMALE, "Lcom/tencent/ecommerce/base/permission/api/PermissionListener;", "Landroidx/activity/result/contract/ActivityResultContracts$RequestMultiplePermissions;", "G", "Landroidx/activity/result/contract/ActivityResultContracts$RequestMultiplePermissions;", "requestMultiplePermissions", "Landroid/widget/LinearLayout;", "H", "Landroid/widget/LinearLayout;", "yh", "()Landroid/widget/LinearLayout;", "setRootView", "(Landroid/widget/LinearLayout;)V", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/widget/TextView;", "I", "Landroid/widget/TextView;", "titleTv", "Landroid/widget/ImageView;", "J", "Landroid/widget/ImageView;", "leftNavigationBtn", "K", "rightNavigationBtn", "L", "Z", "isSubFragment", "<init>", "()V", "N", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public abstract class ECBaseFragment extends Fragment implements IECBaseFragment {

    /* renamed from: C, reason: from kotlin metadata */
    private final Lazy businessDesc;

    /* renamed from: D, reason: from kotlin metadata */
    private final Lazy fragmentLifecycleDelegate;

    /* renamed from: E, reason: from kotlin metadata */
    private final IECContentDescProvider contentDescProviderDelegate;

    /* renamed from: F, reason: from kotlin metadata */
    private PermissionListener permissionListener;

    /* renamed from: G, reason: from kotlin metadata */
    private final ActivityResultContracts.RequestMultiplePermissions requestMultiplePermissions;

    /* renamed from: H, reason: from kotlin metadata */
    protected LinearLayout rootView;

    /* renamed from: I, reason: from kotlin metadata */
    private TextView titleTv;

    /* renamed from: J, reason: from kotlin metadata */
    private ImageView leftNavigationBtn;

    /* renamed from: K, reason: from kotlin metadata */
    private ImageView rightNavigationBtn;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean isSubFragment;

    /* renamed from: N, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final List<Fragment> M = Collections.synchronizedList(new LinkedList());

    /* compiled from: P */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\b\u001a\u00020\u0007R\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000bR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R8\u0010\u0016\u001a&\u0012\f\u0012\n \u0014*\u0004\u0018\u00010\u00020\u0002 \u0014*\u0012\u0012\f\u0012\n \u0014*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00150\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/ecommerce/base/fragment/ECBaseFragment$a;", "", "Landroidx/fragment/app/Fragment;", "fragment", "", "c", "b", "", "a", "", "CODE_CLOSE_PAGE", "I", "EC_REGISTER_OFFLINE_DEBUG", "Z", "ENABLE_CLEAR_PTS_FILE_UTIL_DATA", "PERMISSION_REQUEST_CODE", "", "TAG", "Ljava/lang/String;", "", "kotlin.jvm.PlatformType", "", "fragments", "Ljava/util/List;", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.base.fragment.ECBaseFragment$a, reason: from kotlin metadata */
    /* loaded from: classes32.dex */
    public static final class Companion {
        Companion() {
        }

        public final boolean a() {
            return ECBaseFragment.M.isEmpty();
        }

        public final void b(Fragment fragment) {
            ECBaseFragment.M.remove(fragment);
        }

        public final void c(Fragment fragment) {
            ECBaseFragment.M.add(fragment);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK, "com/tencent/ecommerce/base/fragment/ECBaseFragment$initNavigationBar$1$1"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes32.dex */
    public static final class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECBaseFragment.this.Fh();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public ECBaseFragment() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.ecommerce.base.fragment.ECBaseFragment$businessDesc$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return ECBaseFragment.this.getTAG() + util.base64_pad_url + ECBaseFragment.this.hashCode();
            }
        });
        this.businessDesc = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.ecommerce.base.fragment.b>() { // from class: com.tencent.ecommerce.base.fragment.ECBaseFragment$fragmentLifecycleDelegate$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                String vh5;
                String tag = ECBaseFragment.this.getTAG();
                vh5 = ECBaseFragment.this.vh();
                return new b(tag, vh5);
            }
        });
        this.fragmentLifecycleDelegate = lazy2;
        this.contentDescProviderDelegate = new a(new Function0<View>() { // from class: com.tencent.ecommerce.base.fragment.ECBaseFragment$contentDescProviderDelegate$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final View invoke() {
                return ECBaseFragment.this.getView();
            }
        });
        this.requestMultiplePermissions = new ActivityResultContracts.RequestMultiplePermissions();
    }

    private final void Kh() {
        Window window;
        View decorView;
        Window window2;
        View decorView2;
        Window window3;
        Window window4;
        FragmentActivity activity = getActivity();
        if (activity != null && (window4 = activity.getWindow()) != null) {
            window4.addFlags(Integer.MIN_VALUE);
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null && (window3 = activity2.getWindow()) != null) {
            window3.setStatusBarColor(0);
        }
        FragmentActivity activity3 = getActivity();
        if (activity3 != null && (window2 = activity3.getWindow()) != null && (decorView2 = window2.getDecorView()) != null) {
            decorView2.setSystemUiVisibility(1280);
        }
        FragmentActivity activity4 = getActivity();
        if (activity4 == null || (window = activity4.getWindow()) == null || (decorView = window.getDecorView()) == null) {
            return;
        }
        decorView.setSystemUiVisibility(9472);
    }

    private final void rh() {
        QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getImageLoader().cleanCache();
        ug0.b bVar = ug0.b.f438933d;
        bVar.a();
        bVar.b();
        PTSFileUtil.clearCache();
        com.tencent.ecommerce.biz.detail.repo.shop.data.d.f102363c.c();
        ServiceLocator.f104891i.j().clearMemoryCache();
        cg0.a.b("ECBaseFragment", "all fragment destroy, current fragment:" + getTAG());
    }

    private final void sh() {
        String str;
        Bundle arguments = getArguments();
        if (arguments == null || (str = arguments.getString("scheme_callback_id")) == null) {
            str = "";
        }
        if (str.length() > 0) {
            ug0.a.d(str);
        }
    }

    private final void th() {
        String str;
        Bundle arguments = getArguments();
        if (arguments == null || (str = arguments.getString("scheme_callback_id")) == null) {
            str = "";
        }
        IECSchemeCallback b16 = ug0.a.b(str);
        if (b16 != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", 1);
            jSONObject.put("msg", "close ecommerce page.");
            b16.onCallbackFinished(jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String vh() {
        return (String) this.businessDesc.getValue();
    }

    private final com.tencent.ecommerce.base.fragment.b xh() {
        return (com.tencent.ecommerce.base.fragment.b) this.fragmentLifecycleDelegate.getValue();
    }

    public boolean Ah() {
        return true;
    }

    public boolean Bh() {
        return false;
    }

    public boolean Ch() {
        return true;
    }

    public boolean Dh() {
        return false;
    }

    public boolean Eh() {
        return false;
    }

    protected void Fh() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    public final void Gh(String[] permissions, PermissionListener permissionListener) {
        if (this.requestMultiplePermissions.getSynchronousResult(requireContext(), permissions) != null) {
            permissionListener.onAllGranted();
        } else {
            this.permissionListener = permissionListener;
            requestPermissions(permissions, 10001);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void Hh(boolean isVisible) {
        ImageView imageView = this.leftNavigationBtn;
        if (imageView != null) {
            imageView.setVisibility(isVisible ? 0 : 4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void Ih(View.OnClickListener listener) {
        ImageView imageView = this.rightNavigationBtn;
        if (imageView != null) {
            imageView.setOnClickListener(listener);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void Jh(int resId) {
        ImageView imageView = this.rightNavigationBtn;
        if (imageView != null) {
            ViewKt.setVisible(imageView, true);
        }
        ImageView imageView2 = this.rightNavigationBtn;
        if (imageView2 != null) {
            imageView2.setImageDrawable(ECSkin.INSTANCE.getDrawable(resId));
        }
    }

    public final void finish() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    @Override // com.tencent.ecommerce.base.fragment.api.IECContentDescProvider
    /* renamed from: getContentDescription */
    public final String getContentDesc() {
        return this.contentDescProviderDelegate.getContentDesc();
    }

    public abstract int getContentLayoutId();

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle savedInstanceState) {
        FragmentActivity activity;
        Window window;
        super.onActivityCreated(savedInstanceState);
        c.f100710b.c(this);
        if (Ah()) {
            if (Eh() || Bh()) {
                Kh();
            }
            LinearLayout linearLayout = this.rootView;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            }
            linearLayout.setFitsSystemWindows(Dh() || Bh());
            if (!(uh() != 0) || (activity = getActivity()) == null || (window = activity.getWindow()) == null) {
                return;
            }
            r.f104881b.c(!fg0.a.f398587b.a(), window);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        xh().a();
    }

    @Override // com.tencent.ecommerce.base.ui.api.IECFragmentApi
    public boolean onBackPressed() {
        boolean z16 = false;
        for (Fragment fragment : getChildFragmentManager().getFragments()) {
            if ((fragment instanceof ECBaseFragment) && (z16 = ((ECBaseFragment) fragment).onBackPressed())) {
                break;
            }
        }
        return z16;
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        PTSDeviceUtil.init(requireContext());
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        FragmentActivity activity;
        Application application;
        ECPluginApplication.Companion companion = ECPluginApplication.INSTANCE;
        if (!companion.b() && (activity = getActivity()) != null && (application = activity.getApplication()) != null) {
            companion.c(application);
        }
        try {
            LayoutInflater.Factory2 skinFactory2 = ECSkin.INSTANCE.getSkinFactory2();
            if (skinFactory2 != null) {
                LayoutInflaterCompat.setFactory2(LayoutInflater.from(getContext()), skinFactory2);
            }
        } catch (IllegalStateException unused) {
        }
        super.onCreate(savedInstanceState);
        ECSkin.INSTANCE.loadResource();
        xh().b();
        if (Ch()) {
            INSTANCE.c(this);
        }
        PTSDeviceUtil.init(requireContext());
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        c.f100710b.d(this);
        xh().c();
        if (!this.isSubFragment) {
            th();
            sh();
        }
        if (Ch()) {
            INSTANCE.b(this);
        } else {
            if (((Number) com.tencent.ecommerce.base.config.service.b.f100655b.b(102720, "clearPtsFileUtilData", 0)).intValue() == 1) {
                PTSFileUtil.clearCache();
            }
        }
        if (INSTANCE.a()) {
            rh();
            ug0.a.a();
            LifecycleEventBus.f100688b.f(new e());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        xh().d();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        xh().e();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        xh().f();
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 10001) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int length = permissions.length;
            int i3 = 0;
            int i16 = 0;
            while (i3 < length) {
                int i17 = i16 + 1;
                linkedHashMap.put(permissions[i3], Boolean.valueOf(grantResults[i16] == 0));
                i3++;
                i16 = i17;
            }
            if (!linkedHashMap.isEmpty() && !linkedHashMap.containsValue(Boolean.FALSE)) {
                PermissionListener permissionListener = this.permissionListener;
                if (permissionListener != null) {
                    permissionListener.onAllGranted();
                }
            } else {
                PermissionListener permissionListener2 = this.permissionListener;
                if (permissionListener2 != null) {
                    permissionListener2.onDenied(linkedHashMap);
                }
            }
            this.permissionListener = null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        xh().g();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        xh().h(outState);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        xh().i();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        xh().j();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        xh().k(getArguments());
        view.setContentDescription(this.contentDescProviderDelegate.getContentDesc());
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        xh().l(savedInstanceState);
    }

    @Override // com.tencent.ecommerce.base.fragment.api.IECContentDescProvider
    public final void setContentDescription(String desc) {
        this.contentDescProviderDelegate.setContentDescription(desc);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setTitle(String title) {
        TextView textView = this.titleTv;
        if (textView != null) {
            textView.setText(title);
        }
    }

    public int uh() {
        return ECSkin.INSTANCE.getColor(R.color.f6491p);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinearLayout yh() {
        LinearLayout linearLayout = this.rootView;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
        }
        return linearLayout;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setTitle(int titleResId) {
        setTitle(getString(titleResId));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int wh() {
        Resources.Theme theme;
        int c16 = com.tencent.ecommerce.biz.util.e.c(44.0f);
        Context context = getContext();
        TypedArray obtainStyledAttributes = (context == null || (theme = context.getTheme()) == null) ? null : theme.obtainStyledAttributes(new int[]{android.R.attr.actionBarSize});
        if (obtainStyledAttributes == null) {
            return c16;
        }
        int dimension = (int) obtainStyledAttributes.getDimension(0, 0.0f);
        obtainStyledAttributes.recycle();
        return dimension;
    }

    private final void zh(ViewGroup container) {
        ((ViewStub) container.findViewById(R.id.f163013nu3)).inflate();
        this.titleTv = (TextView) container.findViewById(R.id.ocm);
        ImageView imageView = (ImageView) container.findViewById(R.id.o2l);
        imageView.setOnClickListener(new b());
        Unit unit = Unit.INSTANCE;
        this.leftNavigationBtn = imageView;
        this.rightNavigationBtn = (ImageView) container.findViewById(R.id.o96);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.isSubFragment = container == null || container.getId() != R.id.nx_;
        View inflate = inflater.inflate(R.layout.cqg, container, false);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.o9j);
        this.rootView = linearLayout;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
        }
        linearLayout.setBackgroundColor(uh());
        View inflate2 = inflater.inflate(getContentLayoutId(), container, false);
        if (Bh()) {
            LinearLayout linearLayout2 = this.rootView;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            }
            zh(linearLayout2);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
        layoutParams.weight = 1.0f;
        LinearLayout linearLayout3 = this.rootView;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
        }
        linearLayout3.addView(inflate2, layoutParams);
        return inflate;
    }

    @Override // com.tencent.ecommerce.base.fragment.api.IECBaseFragment
    public Fragment realFragment() {
        return this;
    }
}
