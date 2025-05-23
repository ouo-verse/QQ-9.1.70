package com.tencent.sqshow.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.zootopia.FragmentSource;
import com.tencent.mobileqq.zootopia.Source;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.api.b;
import com.tencent.mobileqq.zplan.api.IFrameHelperActivityApi;
import com.tencent.mobileqq.zplan.api.IZplanCacheApi;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqmini.sdk.request.GetAdInfoRequest;
import com.tencent.sqshow.zootopia.utils.ag;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\b&\u0018\u0000 <2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001=B\u0007\u00a2\u0006\u0004\b:\u0010;J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\f\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\bH$J\u0012\u0010\u0010\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u001a\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0014\u001a\u00020\nH\u0016J\b\u0010\u0015\u001a\u00020\nH\u0016J\b\u0010\u0016\u001a\u00020\nH\u0016J\b\u0010\u0017\u001a\u00020\nH\u0016J\b\u0010\u0018\u001a\u00020\nH\u0016J\b\u0010\u0019\u001a\u00020\nH\u0016J\u0010\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001d\u001a\u00020\nH\u0016J\b\u0010\u001f\u001a\u00020\u001eH\u0016J\u0010\u0010!\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u001aH\u0014J\u0006\u0010#\u001a\u00020\"R\u001b\u0010)\u001a\u00020$8DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u001b\u0010,\u001a\u00020$8DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\b*\u0010&\u001a\u0004\b+\u0010(R\u0018\u0010/\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00102\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00105\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00107\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00100R\u0016\u00109\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00104\u00a8\u0006>"}, d2 = {"Lcom/tencent/sqshow/fragment/ZootopiaBaseFragment;", "Lcom/tencent/sqshow/fragment/ZPlanPublicBaseFragment;", "Lcom/tencent/mobileqq/zootopia/api/b;", "", "Lcom/tencent/mobileqq/zootopia/FragmentSource;", "Ah", "Lcom/tencent/mobileqq/zootopia/Source;", "yh", "", OcrConfig.CHINESE, "", "vh", "Gh", "getSubSource", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/View;", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onStart", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, DKHippyEvent.EVENT_STOP, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onDestroyView", "", "hidden", "onHiddenChanged", "Eh", "", "xh", NodeProps.VISIBLE, "Fh", "", "Bh", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", UserInfo.SEX_FEMALE, "Lkotlin/Lazy;", "Dh", "()Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", GetAdInfoRequest.SOURCE_FROM, "G", "Ch", "sourceCurrent", "H", "Landroid/view/View;", "mainView", "I", "Ljava/lang/Object;", "windowFocusChangeListener", "J", "Z", "hasWindowFocus", "K", "realStatusBarHeight", "L", "lastDrawerEnabled", "<init>", "()V", "M", "a", "superqqshow-portal-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public abstract class ZootopiaBaseFragment extends ZPlanPublicBaseFragment implements b {

    /* renamed from: F, reason: from kotlin metadata */
    private final Lazy sourceFrom;

    /* renamed from: G, reason: from kotlin metadata */
    private final Lazy sourceCurrent;

    /* renamed from: H, reason: from kotlin metadata */
    private View mainView;

    /* renamed from: I, reason: from kotlin metadata */
    private Object windowFocusChangeListener;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean hasWindowFocus;

    /* renamed from: K, reason: from kotlin metadata */
    private int realStatusBarHeight;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean lastDrawerEnabled;

    public ZootopiaBaseFragment() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ZootopiaSource>() { // from class: com.tencent.sqshow.fragment.ZootopiaBaseFragment$sourceFrom$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZootopiaSource invoke() {
                FragmentSource Ah;
                ZootopiaSource from;
                Ah = ZootopiaBaseFragment.this.Ah();
                return (Ah == null || (from = Ah.getFrom()) == null) ? ZootopiaSource.INSTANCE.i() : from;
            }
        });
        this.sourceFrom = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<ZootopiaSource>() { // from class: com.tencent.sqshow.fragment.ZootopiaBaseFragment$sourceCurrent$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZootopiaSource invoke() {
                Source yh5;
                ZootopiaSource.Companion companion = ZootopiaSource.INSTANCE;
                yh5 = ZootopiaBaseFragment.this.yh();
                return companion.c(yh5, ZootopiaBaseFragment.this.getSubSource(), ZootopiaBaseFragment.this.Dh());
            }
        });
        this.sourceCurrent = lazy2;
        this.lastDrawerEnabled = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentSource Ah() {
        Intent intent;
        ZootopiaSource.Companion companion = ZootopiaSource.INSTANCE;
        FragmentSource f16 = companion.f(getArguments());
        if (f16 != null) {
            return f16;
        }
        FragmentActivity activity = getActivity();
        return companion.f((activity == null || (intent = activity.getIntent()) == null) ? null : intent.getExtras());
    }

    private final void Gh() {
        ViewTreeObserver viewTreeObserver;
        View view = this.mainView;
        if (view == null) {
            return;
        }
        Object obj = this.windowFocusChangeListener;
        ViewTreeObserver.OnWindowFocusChangeListener onWindowFocusChangeListener = obj instanceof ViewTreeObserver.OnWindowFocusChangeListener ? (ViewTreeObserver.OnWindowFocusChangeListener) obj : null;
        if (onWindowFocusChangeListener != null && (viewTreeObserver = view.getViewTreeObserver()) != null) {
            viewTreeObserver.removeOnWindowFocusChangeListener(onWindowFocusChangeListener);
        }
        this.mainView = null;
    }

    private final void vh() {
        ViewTreeObserver viewTreeObserver;
        View view = this.mainView;
        if (view == null) {
            return;
        }
        if (this.windowFocusChangeListener == null) {
            this.windowFocusChangeListener = new ViewTreeObserver.OnWindowFocusChangeListener() { // from class: com.tencent.sqshow.fragment.a
                @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
                public final void onWindowFocusChanged(boolean z16) {
                    ZootopiaBaseFragment.wh(ZootopiaBaseFragment.this, z16);
                }
            };
        }
        Object obj = this.windowFocusChangeListener;
        ViewTreeObserver.OnWindowFocusChangeListener onWindowFocusChangeListener = obj instanceof ViewTreeObserver.OnWindowFocusChangeListener ? (ViewTreeObserver.OnWindowFocusChangeListener) obj : null;
        if (onWindowFocusChangeListener == null || (viewTreeObserver = view.getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnWindowFocusChangeListener(onWindowFocusChangeListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wh(ZootopiaBaseFragment this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Fh(z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Source yh() {
        Source current;
        FragmentSource Ah = Ah();
        return (Ah == null || (current = Ah.getCurrent()) == null) ? Source.UnSet : current;
    }

    private final String zh() {
        return "[mainSource:" + Ch().getMainSource().name() + ", subSource:" + Ch().getSubSource() + "][fromMain:" + Dh().getMainSource().name() + ", fromSub:" + Dh().getSubSource() + "][hasWindowFocus:" + this.hasWindowFocus + ']';
    }

    public final int Bh() {
        int statusBarHeight;
        if (this.realStatusBarHeight <= 0) {
            LiuHaiUtils.initLiuHaiProperty(getActivity());
            if (LiuHaiUtils.isLiuHaiUseValid()) {
                statusBarHeight = LiuHaiUtils.getNotchInScreenHeight(getActivity());
            } else {
                statusBarHeight = ImmersiveUtils.getStatusBarHeight(getActivity());
            }
            this.realStatusBarHeight = statusBarHeight;
            QLog.i("ZootopiaBaseFragment", 1, "getRealStatusBarHeight init = " + this.realStatusBarHeight);
        }
        return this.realStatusBarHeight;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ZootopiaSource Ch() {
        return (ZootopiaSource) this.sourceCurrent.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ZootopiaSource Dh() {
        return (ZootopiaSource) this.sourceFrom.getValue();
    }

    public void Eh() {
        Gh();
        QLog.i("ZootopiaBaseFragment", 1, "[FragmentLifeCycle]" + zh() + "onActivityFinish");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Fh(boolean visible) {
        this.hasWindowFocus = visible;
        QLog.i("ZootopiaBaseFragment", 1, "[FragmentLifeCycle]" + zh() + "onWindowFocusChange");
        if (visible) {
            ag.f373258a.f(Ch());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract String getSubSource();

    @Override // com.tencent.sqshow.fragment.ZPlanPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        QLog.i("ZootopiaBaseFragment", 1, "[FragmentLifeCycle]" + zh() + "onCreate");
    }

    @Override // com.tencent.sqshow.fragment.ZPlanPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Gh();
        QLog.i("ZootopiaBaseFragment", 1, "[FragmentLifeCycle]" + zh() + MosaicConstants$JsFunction.FUNC_ON_DESTROY);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        Context context = getContext();
        if (context != null) {
            ((IZplanCacheApi) QRoute.api(IZplanCacheApi.class)).clearCache(context);
        }
        super.onDestroyView();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        QLog.i("ZootopiaBaseFragment", 1, "[FragmentLifeCycle]" + zh() + "onHiddenChanged:" + hidden);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        QRouteApi api = QRoute.api(IFrameHelperActivityApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IFrameHelperActivityApi::class.java)");
        ((IFrameHelperActivityApi) api).setDrawerFrameEnable(this.lastDrawerEnabled);
        ag.f373258a.f(null);
        QLog.i("ZootopiaBaseFragment", 1, "[FragmentLifeCycle]" + zh() + MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
    }

    @Override // com.tencent.sqshow.fragment.ZPlanPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        QRouteApi api = QRoute.api(IFrameHelperActivityApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IFrameHelperActivityApi::class.java)");
        IFrameHelperActivityApi iFrameHelperActivityApi = (IFrameHelperActivityApi) api;
        boolean isDrawerEnabled = iFrameHelperActivityApi.isDrawerEnabled();
        this.lastDrawerEnabled = isDrawerEnabled;
        if (isDrawerEnabled) {
            iFrameHelperActivityApi.setDrawerFrameEnable(false);
        }
        ag.f373258a.f(Ch());
        QLog.i("ZootopiaBaseFragment", 1, "[FragmentLifeCycle]" + zh() + "onResume");
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        QLog.i("ZootopiaBaseFragment", 1, "[FragmentLifeCycle]" + zh() + "onStart");
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        QLog.i("ZootopiaBaseFragment", 1, "[FragmentLifeCycle]" + zh() + DKHippyEvent.EVENT_STOP);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.mainView = view;
        vh();
    }

    public long xh() {
        return 0L;
    }
}
