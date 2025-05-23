package com.tencent.aelight.camera.ae.flashshow;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel;
import com.tencent.aelight.camera.ae.flashshow.ui.AEFlashShowBottomPanelViewModel;
import com.tencent.aelight.camera.ae.flashshow.ui.AEFlashShowMaterialManager;
import com.tencent.aelight.camera.ae.flashshow.ui.PanelTag;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.event.CaptureUIEvent;
import com.tencent.mobileqq.wink.pager.FragmentPager;
import com.tencent.mobileqq.winkpublish.report.WinkDc5507ReportData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import cooperation.qzone.QzoneIPCModule;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import mqq.app.Constants;
import mqq.util.WeakReference;
import yq.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 l2\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001mB\u0013\u0012\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0004\bj\u0010kJ\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0005H\u0002J\b\u0010\u000b\u001a\u00020\u0005H\u0002J\b\u0010\f\u001a\u00020\u0005H\u0002J\u0012\u0010\u000f\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u0012\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J&\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00172\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\rH\u0016J\u0010\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J/\u0010'\u001a\u00020\u00052\u0006\u0010!\u001a\u00020 2\u000e\u0010$\u001a\n\u0012\u0006\b\u0001\u0012\u00020#0\"2\u0006\u0010&\u001a\u00020%H\u0016\u00a2\u0006\u0004\b'\u0010(J\b\u0010)\u001a\u00020\u0005H\u0016J\b\u0010*\u001a\u00020\u0005H\u0016J\b\u0010+\u001a\u00020\u0005H\u0016J\b\u0010-\u001a\u00020,H\u0016J\b\u0010.\u001a\u00020\u0005H\u0016J\b\u0010/\u001a\u00020\u0005H\u0016J\"\u00102\u001a\u00020\u00052\u0006\u0010!\u001a\u00020 2\u0006\u00100\u001a\u00020 2\b\u00101\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u00103\u001a\u00020\u0005H\u0016J\u0018\u00106\u001a\u00020\u00052\u0006\u00104\u001a\u00020#2\u0006\u00105\u001a\u00020,H\u0016J\u0010\u00109\u001a\u00020\u00052\u0006\u00108\u001a\u000207H\u0016J\b\u0010:\u001a\u00020\u0005H\u0016J\u0012\u0010<\u001a\u00020\u00052\b\u0010;\u001a\u0004\u0018\u00010\u0004H\u0016J$\u0010@\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040>0=j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040>`?H\u0016R\u0019\u0010E\u001a\u0004\u0018\u00010\r8\u0006\u00a2\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010DR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0018\u0010K\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010N\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010Q\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010S\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010PR\u0018\u0010V\u001a\u0004\u0018\u00010T8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010UR\u0018\u0010Z\u001a\u0004\u0018\u00010W8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010YR\u0018\u0010^\u001a\u0004\u0018\u00010[8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010]R\u0018\u0010a\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b_\u0010`R\u0016\u0010e\u001a\u00020b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bc\u0010dR\u0016\u0010i\u001a\u00020f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bg\u0010h\u00a8\u0006n"}, d2 = {"Lcom/tencent/aelight/camera/ae/flashshow/WinkCaptureFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Lcom/tencent/mobileqq/wink/pager/FragmentPager$d;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "Ah", "Lcom/tencent/aelight/camera/ae/flashshow/AEFlashShowCameraUnit;", "cameraUnit", "Bh", "yh", OcrConfig.CHINESE, "Ih", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/content/Intent;", "intent", "onNewIntent", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "outState", "onSaveInstanceState", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "", "requestCode", "", "", "permissions", "", "grantResults", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V", "onStart", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "", "onBackEvent", DKHippyEvent.EVENT_STOP, MosaicConstants$JsFunction.FUNC_ON_DESTROY, QzoneIPCModule.RESULT_CODE, "data", "onActivityResult", "xc", "curPageId", "isSelf", "X9", "Lcom/tencent/mobileqq/wink/pager/FragmentPager$b;", "callback", "P6", "onDestroyView", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", BdhLogUtil.LogTag.Tag_Conn, "Landroid/os/Bundle;", "getCaptureBundle", "()Landroid/os/Bundle;", "captureBundle", "D", "Lcom/tencent/aelight/camera/ae/flashshow/AEFlashShowCameraUnit;", "Lcom/tencent/aelight/camera/ae/flashshow/FlashShowCaptureViewManager;", "E", "Lcom/tencent/aelight/camera/ae/flashshow/FlashShowCaptureViewManager;", "cameraViewManager", UserInfo.SEX_FEMALE, "Z", "hasCaptureViewAdded", "G", "I", "widthPixels", "H", "heightPixels", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/p;", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/p;", "pickerUIViewModel", "Lcom/tencent/aelight/camera/ae/flashshow/ui/AEFlashShowBottomPanelViewModel;", "J", "Lcom/tencent/aelight/camera/ae/flashshow/ui/AEFlashShowBottomPanelViewModel;", "bottomPanelViewModel", "Lcom/tencent/aelight/camera/ae/camera/ui/topbar/AEVideoStoryTopBarViewModel;", "K", "Lcom/tencent/aelight/camera/ae/camera/ui/topbar/AEVideoStoryTopBarViewModel;", "videoStoryTopBarViewModel", "L", "Lcom/tencent/mobileqq/wink/pager/FragmentPager$b;", "pagerCallback", "Lyq/d;", "M", "Lyq/d;", "aeResumeManager", "Landroid/view/ViewTreeObserver$OnWindowFocusChangeListener;", "N", "Landroid/view/ViewTreeObserver$OnWindowFocusChangeListener;", "onWindowFocusListener", "<init>", "(Landroid/os/Bundle;)V", "P", "a", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class WinkCaptureFragment extends QPublicBaseFragment implements FragmentPager.d, SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: C, reason: from kotlin metadata */
    private final Bundle captureBundle;

    /* renamed from: D, reason: from kotlin metadata */
    private AEFlashShowCameraUnit cameraUnit;

    /* renamed from: E, reason: from kotlin metadata */
    private FlashShowCaptureViewManager cameraViewManager;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean hasCaptureViewAdded;

    /* renamed from: G, reason: from kotlin metadata */
    private int widthPixels;

    /* renamed from: H, reason: from kotlin metadata */
    private int heightPixels;

    /* renamed from: I, reason: from kotlin metadata */
    private com.tencent.mobileqq.wink.picker.core.viewmodel.p pickerUIViewModel;

    /* renamed from: J, reason: from kotlin metadata */
    private AEFlashShowBottomPanelViewModel bottomPanelViewModel;

    /* renamed from: K, reason: from kotlin metadata */
    private AEVideoStoryTopBarViewModel videoStoryTopBarViewModel;

    /* renamed from: L, reason: from kotlin metadata */
    private FragmentPager.b pagerCallback;

    /* renamed from: M, reason: from kotlin metadata */
    private yq.d aeResumeManager;

    /* renamed from: N, reason: from kotlin metadata */
    private ViewTreeObserver.OnWindowFocusChangeListener onWindowFocusListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/aelight/camera/ae/flashshow/WinkCaptureFragment$b", "Lyq/d$a;", "Landroid/os/Handler;", "getMainHandler", "", "isResumed", "", "doOnResume", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class b implements d.a {
        b() {
        }

        @Override // yq.d.a
        public void doOnResume() {
            WinkCaptureFragment.this.zh();
        }

        @Override // yq.d.a
        public Handler getMainHandler() {
            Handler mainHandler = WinkCaptureFragment.this.getMainHandler();
            Intrinsics.checkNotNullExpressionValue(mainHandler, "this@WinkCaptureFragment.mainHandler");
            return mainHandler;
        }

        @Override // yq.d.a
        public boolean isResumed() {
            return WinkCaptureFragment.this.isResumed();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"com/tencent/aelight/camera/ae/flashshow/WinkCaptureFragment$d", "Lor/d;", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class d implements or.d {
        d() {
        }
    }

    public WinkCaptureFragment() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    private final void Ah() {
        this.aeResumeManager.k(new b());
    }

    private final void Bh(AEFlashShowCameraUnit cameraUnit) {
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        this.pickerUIViewModel = com.tencent.mobileqq.wink.picker.core.viewmodel.q.a(requireActivity);
        this.bottomPanelViewModel = (AEFlashShowBottomPanelViewModel) com.tencent.aelight.camera.ae.n.a(cameraUnit).get(AEFlashShowBottomPanelViewModel.class);
        this.videoStoryTopBarViewModel = (AEVideoStoryTopBarViewModel) com.tencent.aelight.camera.ae.n.a(cameraUnit).get(AEVideoStoryTopBarViewModel.class);
        MutableLiveData<Boolean> M1 = ((com.tencent.aelight.camera.ae.part.a) com.tencent.aelight.camera.ae.n.a(cameraUnit).get(com.tencent.aelight.camera.ae.part.a.class)).M1();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.aelight.camera.ae.flashshow.WinkCaptureFragment$initViewModel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:7:0x0013, code lost:
            
                r0 = r3.this$0.pagerCallback;
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke2(Boolean it) {
                AEFlashShowBottomPanelViewModel aEFlashShowBottomPanelViewModel;
                FragmentPager.b bVar;
                aEFlashShowBottomPanelViewModel = WinkCaptureFragment.this.bottomPanelViewModel;
                boolean z16 = false;
                if (aEFlashShowBottomPanelViewModel != null && aEFlashShowBottomPanelViewModel.o2()) {
                    z16 = true;
                }
                if (z16 || bVar == null) {
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(it, "it");
                bVar.a(it.booleanValue());
            }
        };
        M1.observe(cameraUnit, new Observer() { // from class: com.tencent.aelight.camera.ae.flashshow.bb
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkCaptureFragment.Ch(Function1.this, obj);
            }
        });
        AEFlashShowBottomPanelViewModel aEFlashShowBottomPanelViewModel = this.bottomPanelViewModel;
        Intrinsics.checkNotNull(aEFlashShowBottomPanelViewModel);
        MediatorLiveData<Pair<PanelTag, Boolean>> e26 = aEFlashShowBottomPanelViewModel.e2();
        final Function1<Pair<? extends PanelTag, ? extends Boolean>, Unit> function12 = new Function1<Pair<? extends PanelTag, ? extends Boolean>, Unit>() { // from class: com.tencent.aelight.camera.ae.flashshow.WinkCaptureFragment$initViewModel$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends PanelTag, ? extends Boolean> pair) {
                invoke2((Pair<? extends PanelTag, Boolean>) pair);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:6:0x000b, code lost:
            
                r0 = r1.this$0.pagerCallback;
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke2(Pair<? extends PanelTag, Boolean> pair) {
                FragmentPager.b bVar;
                if (pair == null || !WinkCaptureFragment.this.isResumed() || bVar == null) {
                    return;
                }
                bVar.a(!pair.getSecond().booleanValue());
            }
        };
        e26.observe(cameraUnit, new Observer() { // from class: com.tencent.aelight.camera.ae.flashshow.bc
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkCaptureFragment.Dh(Function1.this, obj);
            }
        });
        MutableLiveData<Boolean> f26 = aEFlashShowBottomPanelViewModel.f2();
        final Function1<Boolean, Unit> function13 = new Function1<Boolean, Unit>() { // from class: com.tencent.aelight.camera.ae.flashshow.WinkCaptureFragment$initViewModel$2$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:3:0x0006, code lost:
            
                r2 = r1.this$0.pagerCallback;
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke2(Boolean bool) {
                FragmentPager.b bVar;
                if (bool.booleanValue() || bVar == null) {
                    return;
                }
                bVar.a(false);
            }
        };
        f26.observe(cameraUnit, new Observer() { // from class: com.tencent.aelight.camera.ae.flashshow.bd
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkCaptureFragment.Eh(Function1.this, obj);
            }
        });
        com.tencent.mobileqq.wink.picker.core.viewmodel.p pVar = this.pickerUIViewModel;
        Intrinsics.checkNotNull(pVar);
        LiveData<String> Q1 = pVar.Q1();
        FragmentActivity requireActivity2 = requireActivity();
        final WinkCaptureFragment$initViewModel$3$1 winkCaptureFragment$initViewModel$3$1 = new Function1<String, Unit>() { // from class: com.tencent.aelight.camera.ae.flashshow.WinkCaptureFragment$initViewModel$3$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String it) {
                SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
                Intrinsics.checkNotNullExpressionValue(it, "it");
                simpleEventBus.dispatchEvent(new CaptureUIEvent(it));
            }
        };
        Q1.observe(requireActivity2, new Observer() { // from class: com.tencent.aelight.camera.ae.flashshow.be
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkCaptureFragment.Fh(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ch(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Dh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Eh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Fh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Gh(AEFlashShowCameraUnit it, String materialId) {
        Intrinsics.checkNotNullParameter(it, "$it");
        Intrinsics.checkNotNullParameter(materialId, "$materialId");
        it.m4(materialId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Hh(WinkCaptureFragment this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.aeResumeManager.i(z16);
    }

    private final void Ih() {
        Intent intent;
        FragmentActivity activity = getActivity();
        Serializable serializableExtra = (activity == null || (intent = activity.getIntent()) == null) ? null : intent.getSerializableExtra("key_attrs");
        if (serializableExtra instanceof HashMap) {
            TypeIntrinsics.asMutableMap((Map) serializableExtra).remove("content");
        }
    }

    private final void yh() {
        View s16;
        if (this.hasCaptureViewAdded) {
            return;
        }
        View view = getView();
        ViewGroup viewGroup = view instanceof ViewGroup ? (ViewGroup) view : null;
        if (viewGroup != null) {
            tq.b.h().o("unitOnCreateView-begin");
            FlashShowCaptureViewManager flashShowCaptureViewManager = this.cameraViewManager;
            if (flashShowCaptureViewManager == null || (s16 = flashShowCaptureViewManager.s(viewGroup)) == null) {
                return;
            }
            tq.b.h().o("unitOnCreateView-end");
            this.hasCaptureViewAdded = true;
            Bundle bundle = this.captureBundle;
            boolean z16 = bundle != null ? bundle.getBoolean(QQWinkConstants.WINK_CAPTURE_FRAGMENT_IGNORE_BOTTOM_HEIGHT, false) : false;
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            if (com.tencent.mobileqq.wink.picker.core.viewmodel.q.a(requireActivity).O1() && !z16) {
                QLog.i("WinkCaptureFragment", 1, "need bottomGap");
                ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -1);
                marginLayoutParams.bottomMargin = WinkHomeActivity.INSTANCE.a();
                viewGroup.addView(s16, 0, marginLayoutParams);
                return;
            }
            viewGroup.addView(s16, 0, new ViewGroup.LayoutParams(-1, -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zh() {
        FlashShowCaptureViewManager flashShowCaptureViewManager = this.cameraViewManager;
        if (flashShowCaptureViewManager != null) {
            flashShowCaptureViewManager.t().onActivityResume();
            flashShowCaptureViewManager.I();
        }
        FragmentActivity activity = getActivity();
        t53.a.c(activity != null ? activity.getIntent() : null, new Function1<WinkDc5507ReportData.a, Unit>() { // from class: com.tencent.aelight.camera.ae.flashshow.WinkCaptureFragment$doOnResume$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(WinkDc5507ReportData.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(WinkDc5507ReportData.a dc5507Report) {
                Intrinsics.checkNotNullParameter(dc5507Report, "$this$dc5507Report");
                dc5507Report.b(1001);
                dc5507Report.j(1);
            }
        });
    }

    @Override // com.tencent.mobileqq.wink.pager.FragmentPager.d
    public void P6(FragmentPager.b callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.pagerCallback = callback;
    }

    @Override // com.tencent.mobileqq.wink.pager.FragmentPager.d
    public void X9(String curPageId, boolean isSelf) {
        AEVideoStoryTopBarViewModel aEVideoStoryTopBarViewModel;
        Intrinsics.checkNotNullParameter(curPageId, "curPageId");
        if (isSelf || (aEVideoStoryTopBarViewModel = this.videoStoryTopBarViewModel) == null) {
            return;
        }
        aEVideoStoryTopBarViewModel.R1(false);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(CaptureUIEvent.class);
        return arrayList;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        com.tencent.aelight.camera.ae.q t16;
        super.onActivityResult(requestCode, resultCode, data);
        FlashShowCaptureViewManager flashShowCaptureViewManager = this.cameraViewManager;
        if (flashShowCaptureViewManager == null || (t16 = flashShowCaptureViewManager.t()) == null) {
            return;
        }
        t16.onActivityResult(requestCode, resultCode, data);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        com.tencent.aelight.camera.ae.q t16;
        LiveData<Boolean> Q1;
        AEVideoStoryTopBarViewModel aEVideoStoryTopBarViewModel = this.videoStoryTopBarViewModel;
        boolean z16 = false;
        if ((aEVideoStoryTopBarViewModel == null || (Q1 = aEVideoStoryTopBarViewModel.Q1()) == null) ? false : Intrinsics.areEqual(Q1.getValue(), Boolean.TRUE)) {
            AEFlashShowBottomPanelViewModel aEFlashShowBottomPanelViewModel = this.bottomPanelViewModel;
            if (aEFlashShowBottomPanelViewModel != null && aEFlashShowBottomPanelViewModel.o2()) {
                z16 = true;
            }
            if (z16) {
                AEFlashShowBottomPanelViewModel aEFlashShowBottomPanelViewModel2 = this.bottomPanelViewModel;
                if (aEFlashShowBottomPanelViewModel2 != null) {
                    aEFlashShowBottomPanelViewModel2.c2();
                }
            } else {
                FragmentPager.b bVar = this.pagerCallback;
                if (bVar != null) {
                    bVar.b("MEDIA_PICKER_PAGE");
                }
            }
            return true;
        }
        FlashShowCaptureViewManager flashShowCaptureViewManager = this.cameraViewManager;
        return (flashShowCaptureViewManager == null || (t16 = flashShowCaptureViewManager.t()) == null || t16.onBackPressed()) ? false : true;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        com.tencent.aelight.camera.ae.q t16;
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        if (com.tencent.aelight.camera.ae.p.e()) {
            DisplayMetrics c16 = com.tencent.aelight.camera.ae.flashshow.util.g.c(getContext());
            if (c16 != null) {
                int i3 = this.widthPixels;
                int i16 = c16.widthPixels;
                if (i3 != i16 || this.heightPixels != c16.heightPixels) {
                    this.widthPixels = i16;
                    this.heightPixels = c16.heightPixels;
                    FlashShowCaptureViewManager flashShowCaptureViewManager = this.cameraViewManager;
                    if (flashShowCaptureViewManager != null && (t16 = flashShowCaptureViewManager.t()) != null) {
                        t16.n(this.widthPixels, this.heightPixels);
                    }
                }
            }
            if (QLog.isColorLevel()) {
                Intrinsics.checkNotNull(c16);
                QLog.i("WinkCaptureFragment", 2, "onConfigurationChanged width:" + c16.widthPixels + ", height:" + c16.heightPixels);
            }
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Activity hostActivity = getHostActivity();
        if (hostActivity != null) {
            ab.c().a(hostActivity);
        }
        DisplayMetrics c16 = com.tencent.aelight.camera.ae.flashshow.util.g.c(getContext());
        if (c16 != null) {
            this.widthPixels = c16.widthPixels;
            this.heightPixels = c16.heightPixels;
        }
        c cVar = new c();
        d dVar = new d();
        SimpleEventBus.getInstance().registerReceiver(this);
        this.cameraUnit = new AEFlashShowCameraUnit(cVar, dVar, this.captureBundle);
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        AEFlashShowCameraUnit aEFlashShowCameraUnit = this.cameraUnit;
        Intrinsics.checkNotNull(aEFlashShowCameraUnit);
        FlashShowCaptureViewManager flashShowCaptureViewManager = new FlashShowCaptureViewManager(requireActivity, aEFlashShowCameraUnit);
        flashShowCaptureViewManager.t().onCreate(savedInstanceState);
        this.cameraViewManager = flashShowCaptureViewManager;
        AEFlashShowCameraUnit aEFlashShowCameraUnit2 = this.cameraUnit;
        Intrinsics.checkNotNull(aEFlashShowCameraUnit2);
        Bh(aEFlashShowCameraUnit2);
        Ah();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(R.layout.dox, container, false);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        com.tencent.aelight.camera.ae.q t16;
        ViewTreeObserver viewTreeObserver;
        super.onDestroy();
        View view = getView();
        if (view != null && (viewTreeObserver = view.getViewTreeObserver()) != null) {
            viewTreeObserver.removeOnWindowFocusChangeListener(this.onWindowFocusListener);
        }
        this.aeResumeManager.d();
        FlashShowCaptureViewManager flashShowCaptureViewManager = this.cameraViewManager;
        if (flashShowCaptureViewManager != null && (t16 = flashShowCaptureViewManager.t()) != null) {
            t16.onDestroy();
        }
        this.cameraViewManager = null;
        this.cameraUnit = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        AEFlashShowCameraUnit aEFlashShowCameraUnit = this.cameraUnit;
        if (aEFlashShowCameraUnit != null) {
            aEFlashShowCameraUnit.onNewIntent(intent);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.aeResumeManager.e();
        FlashShowCaptureViewManager flashShowCaptureViewManager = this.cameraViewManager;
        if (flashShowCaptureViewManager != null) {
            flashShowCaptureViewManager.t().onActivityPause();
            flashShowCaptureViewManager.H();
        }
        Ih();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        final AEFlashShowCameraUnit aEFlashShowCameraUnit;
        if (event instanceof CaptureUIEvent) {
            QLog.i("WinkCaptureFragment", 1, "onReceiveEvent CaptureUIEvent ");
            final String materialId = ((CaptureUIEvent) event).getMaterialId();
            if (TextUtils.isEmpty(materialId) || (aEFlashShowCameraUnit = this.cameraUnit) == null) {
                return;
            }
            lq.b bVar = aEFlashShowCameraUnit.f63954y0;
            if (bVar != null && bVar.f(983041)) {
                aEFlashShowCameraUnit.m4(materialId);
            } else {
                ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.ba
                    @Override // java.lang.Runnable
                    public final void run() {
                        WinkCaptureFragment.Gh(AEFlashShowCameraUnit.this, materialId);
                    }
                }, 2000L);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        AEFlashShowCameraUnit aEFlashShowCameraUnit = this.cameraUnit;
        if (aEFlashShowCameraUnit != null) {
            aEFlashShowCameraUnit.e4(requestCode, permissions, grantResults);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.aeResumeManager.f();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        com.tencent.aelight.camera.ae.q t16;
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        FlashShowCaptureViewManager flashShowCaptureViewManager = this.cameraViewManager;
        if (flashShowCaptureViewManager == null || (t16 = flashShowCaptureViewManager.t()) == null) {
            return;
        }
        t16.onSaveInstanceState(outState);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStart() {
        com.tencent.aelight.camera.ae.q t16;
        super.onStart();
        FlashShowCaptureViewManager flashShowCaptureViewManager = this.cameraViewManager;
        if (flashShowCaptureViewManager == null || (t16 = flashShowCaptureViewManager.t()) == null) {
            return;
        }
        t16.onActivityStart();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        com.tencent.aelight.camera.ae.q t16;
        super.onStop();
        this.aeResumeManager.h();
        FlashShowCaptureViewManager flashShowCaptureViewManager = this.cameraViewManager;
        if (flashShowCaptureViewManager == null || (t16 = flashShowCaptureViewManager.t()) == null) {
            return;
        }
        t16.onActivityStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (o83.a.f422212a.d()) {
            com.tencent.aelight.camera.ae.control.b b16 = com.tencent.aelight.camera.ae.control.a.b(3);
            Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type com.tencent.aelight.camera.ae.flashshow.ui.AEFlashShowMaterialManager");
            ((AEFlashShowMaterialManager) b16).k0(true);
        }
        yh();
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.addOnWindowFocusChangeListener(this.onWindowFocusListener);
        }
    }

    public WinkCaptureFragment(Bundle bundle) {
        this.captureBundle = bundle;
        this.aeResumeManager = new yq.d();
        this.onWindowFocusListener = new ViewTreeObserver.OnWindowFocusChangeListener() { // from class: com.tencent.aelight.camera.ae.flashshow.az
            @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
            public final void onWindowFocusChanged(boolean z16) {
                WinkCaptureFragment.Hh(WinkCaptureFragment.this, z16);
            }
        };
    }

    public /* synthetic */ WinkCaptureFragment(Bundle bundle, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : bundle);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/aelight/camera/ae/flashshow/WinkCaptureFragment$c", "Lor/e;", "Landroid/app/Activity;", "kotlin.jvm.PlatformType", "getActivity", "", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lmqq/util/WeakReference;", BdhLogUtil.LogTag.Tag_Req, "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class c implements or.e {
        c() {
        }

        @Override // or.e
        public WeakReference<Activity> R() {
            return new WeakReference<>(WinkCaptureFragment.this.getHostActivity());
        }

        @Override // or.e
        public Activity getActivity() {
            return WinkCaptureFragment.this.getHostActivity();
        }

        @Override // or.e
        public void Q() {
        }
    }

    @Override // com.tencent.mobileqq.wink.pager.FragmentPager.d
    public void xc() {
    }
}
