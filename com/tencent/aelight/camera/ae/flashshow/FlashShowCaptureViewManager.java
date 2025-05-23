package com.tencent.aelight.camera.ae.flashshow;

import android.content.Intent;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.ae.flashshow.FlashShowCaptureViewManager$cameraLifeCallbackDelegate$2;
import com.tencent.aelight.camera.ae.flashshow.ui.AEFlashCameraCaptureButtonLayout;
import com.tencent.aelight.camera.ae.flashshow.ui.AEFlashShowBottomPanelViewModel;
import com.tencent.aelight.camera.ae.flashshow.ui.PanelTag;
import com.tencent.aelight.camera.ae.flashshow.view.FlashShowSwitchLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.wink.editor.music.vo.Scene;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import cooperation.qzone.QzoneIPCModule;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 Y2\u00020\u0001:\u0001\u001dB\u0017\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\u0006\u0010#\u001a\u00020 \u00a2\u0006\u0004\bW\u0010XJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\u0002H\u0003J\b\u0010\u000f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000bH\u0002J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0015\u001a\u00020\u0002H\u0002J\b\u0010\u0016\u001a\u00020\u0002H\u0002J\u000e\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0017J\u0006\u0010\u001a\u001a\u00020\u0002J\u0006\u0010\u001b\u001a\u00020\u0002R\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010%\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010\u001aR\u0016\u0010(\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010*\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010'R\u0016\u0010,\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010'R\u0018\u0010/\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0018\u00107\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010K\u001a\u00020H8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u001b\u0010Q\u001a\u00020L8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bM\u0010N\u001a\u0004\bO\u0010PR\u001b\u0010V\u001a\u00020R8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\bS\u0010N\u001a\u0004\bT\u0010U\u00a8\u0006Z"}, d2 = {"Lcom/tencent/aelight/camera/ae/flashshow/FlashShowCaptureViewManager;", "", "", "G", "J", UserInfo.SEX_FEMALE, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, HippyTKDListViewAdapter.X, "y", "", "mode", "N", "O", "u", "position", "w", "", NodeProps.VISIBLE, "M", "K", "L", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, ReportConstant.COSTREPORT_PREFIX, "I", "H", "Landroidx/fragment/app/FragmentActivity;", "a", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/aelight/camera/ae/flashshow/AEFlashShowCameraUnit;", "b", "Lcom/tencent/aelight/camera/ae/flashshow/AEFlashShowCameraUnit;", "cameraUnit", "c", "currentMode", "d", "Z", "hasCameraViewShown", "e", "hasCameraUnitViewCreated", "f", "hasCameraUnitResumed", "g", "Landroid/view/ViewGroup;", "parentView", "Landroid/view/ViewStub;", tl.h.F, "Landroid/view/ViewStub;", "mSwitcherViewStub", "Lcom/tencent/aelight/camera/ae/flashshow/view/FlashShowSwitchLayout;", "i", "Lcom/tencent/aelight/camera/ae/flashshow/view/FlashShowSwitchLayout;", "mSwitcherView", "Lcom/tencent/aelight/camera/ae/flashshow/ui/ab;", "j", "Lcom/tencent/aelight/camera/ae/flashshow/ui/ab;", "mCaptureViewModel", "Lcom/tencent/aelight/camera/ae/part/a;", "k", "Lcom/tencent/aelight/camera/ae/part/a;", "mStateViewModel", "Lcom/tencent/aelight/camera/ae/flashshow/ui/AEFlashShowBottomPanelViewModel;", "l", "Lcom/tencent/aelight/camera/ae/flashshow/ui/AEFlashShowBottomPanelViewModel;", "mBottomPanelViewModel", "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/a;", "mMusicPlayerViewModel", "", DomainData.DOMAIN_NAME, "Ljava/lang/String;", "schemaFrom", "Landroid/os/Vibrator;", "o", "Lkotlin/Lazy;", "v", "()Landroid/os/Vibrator;", "mVibrator", "Lcom/tencent/aelight/camera/ae/q;", "p", "t", "()Lcom/tencent/aelight/camera/ae/q;", "cameraLifeCallbackDelegate", "<init>", "(Landroidx/fragment/app/FragmentActivity;Lcom/tencent/aelight/camera/ae/flashshow/AEFlashShowCameraUnit;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class FlashShowCaptureViewManager {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final FragmentActivity activity;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final AEFlashShowCameraUnit cameraUnit;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int currentMode;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean hasCameraViewShown;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean hasCameraUnitViewCreated;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean hasCameraUnitResumed;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private ViewGroup parentView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ViewStub mSwitcherViewStub;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private FlashShowSwitchLayout mSwitcherView;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aelight.camera.ae.flashshow.ui.ab mCaptureViewModel;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aelight.camera.ae.part.a mStateViewModel;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private AEFlashShowBottomPanelViewModel mBottomPanelViewModel;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.wink.editor.music.viewmodel.a mMusicPlayerViewModel;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private String schemaFrom;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private final Lazy mVibrator;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private final Lazy cameraLifeCallbackDelegate;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/aelight/camera/ae/flashshow/FlashShowCaptureViewManager$b", "Lcom/tencent/aelight/camera/ae/flashshow/view/FlashShowSwitchLayout$b;", "", "position", "", "a", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class b implements FlashShowSwitchLayout.b {
        b() {
        }

        @Override // com.tencent.aelight.camera.ae.flashshow.view.FlashShowSwitchLayout.b
        public void a(int position) {
            int i3;
            int w3 = FlashShowCaptureViewManager.this.w(position);
            if (w3 != 0) {
                i3 = 1;
                if (w3 != 1) {
                    i3 = 2;
                    if (w3 != 2) {
                        ms.a.c("FlashShowCaptureViewManager", "ignore invalid position");
                        return;
                    }
                }
            } else {
                i3 = 0;
            }
            ms.a.f("FlashShowCaptureViewManager", "switch to mode: " + i3);
            FlashShowCaptureViewManager.this.N(i3);
        }
    }

    public FlashShowCaptureViewManager(FragmentActivity activity, AEFlashShowCameraUnit cameraUnit) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(cameraUnit, "cameraUnit");
        this.activity = activity;
        this.cameraUnit = cameraUnit;
        this.currentMode = 1;
        this.schemaFrom = "";
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Vibrator>() { // from class: com.tencent.aelight.camera.ae.flashshow.FlashShowCaptureViewManager$mVibrator$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Vibrator invoke() {
                FragmentActivity fragmentActivity;
                fragmentActivity = FlashShowCaptureViewManager.this.activity;
                Object systemService = fragmentActivity.getSystemService("vibrator");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.Vibrator");
                return (Vibrator) systemService;
            }
        });
        this.mVibrator = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<FlashShowCaptureViewManager$cameraLifeCallbackDelegate$2.a>() { // from class: com.tencent.aelight.camera.ae.flashshow.FlashShowCaptureViewManager$cameraLifeCallbackDelegate$2

            /* compiled from: P */
            @Metadata(d1 = {"\u0000K\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016J\"\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0004H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\"\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u000f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001b\u001a\u00020\u0016H\u0016J\u001a\u0010\u001f\u001a\u00020\u00162\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001b\u001a\u00020\u0016H\u0016J\u0012\u0010!\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010#\u001a\u00020\u00042\b\u0010\"\u001a\u0004\u0018\u00010\u0002H\u0016J\u0018\u0010&\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u000fH\u0016J\u0010\u0010(\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u0016H\u0016\u00a8\u0006)"}, d2 = {"com/tencent/aelight/camera/ae/flashshow/FlashShowCaptureViewManager$cameraLifeCallbackDelegate$2$a", "Lcom/tencent/aelight/camera/ae/q;", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", "Landroid/view/ViewGroup;", "parentView", "Landroid/view/View;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "onActivityResume", "onActivityPause", "onActivityStart", "onActivityStop", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "finish", "", "onBackPressed", "keyCode", "Landroid/view/KeyEvent;", "event", "b", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/MotionEvent;", "ev", "onTouchEvent", "intent", "onNewIntent", "outState", "onSaveInstanceState", "width", "height", DomainData.DOMAIN_NAME, "hasFocus", "onWindowFocusChanged", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes32.dex */
            public static final class a implements com.tencent.aelight.camera.ae.q {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ FlashShowCaptureViewManager f63725d;

                a(FlashShowCaptureViewManager flashShowCaptureViewManager) {
                    this.f63725d = flashShowCaptureViewManager;
                }

                @Override // com.tencent.aelight.camera.ae.q
                public void finish() {
                    AEFlashShowCameraUnit aEFlashShowCameraUnit;
                    aEFlashShowCameraUnit = this.f63725d.cameraUnit;
                    aEFlashShowCameraUnit.finish();
                }

                @Override // com.tencent.aelight.camera.ae.q
                public boolean m(int keyCode, KeyEvent event, boolean b16) {
                    boolean z16;
                    int i3;
                    AEFlashShowCameraUnit aEFlashShowCameraUnit;
                    z16 = this.f63725d.hasCameraViewShown;
                    if (z16) {
                        i3 = this.f63725d.currentMode;
                        if (i3 != 2) {
                            aEFlashShowCameraUnit = this.f63725d.cameraUnit;
                            return aEFlashShowCameraUnit.m(keyCode, event, b16);
                        }
                    }
                    return false;
                }

                @Override // com.tencent.aelight.camera.ae.q
                public void n(int width, int height) {
                    boolean z16;
                    AEFlashShowCameraUnit aEFlashShowCameraUnit;
                    z16 = this.f63725d.hasCameraUnitViewCreated;
                    if (z16) {
                        aEFlashShowCameraUnit = this.f63725d.cameraUnit;
                        aEFlashShowCameraUnit.n(width, height);
                    }
                }

                @Override // com.tencent.aelight.camera.ae.q
                public void onActivityPause() {
                    boolean z16;
                    AEFlashShowCameraUnit aEFlashShowCameraUnit;
                    z16 = this.f63725d.hasCameraUnitResumed;
                    if (z16) {
                        this.f63725d.hasCameraUnitResumed = false;
                        aEFlashShowCameraUnit = this.f63725d.cameraUnit;
                        aEFlashShowCameraUnit.onActivityPause();
                    }
                }

                @Override // com.tencent.aelight.camera.ae.q
                public void onActivityResult(int requestCode, int resultCode, Intent data) {
                    AEFlashShowCameraUnit aEFlashShowCameraUnit;
                    aEFlashShowCameraUnit = this.f63725d.cameraUnit;
                    aEFlashShowCameraUnit.onActivityResult(requestCode, resultCode, data);
                }

                @Override // com.tencent.aelight.camera.ae.q
                public void onActivityResume() {
                    boolean z16;
                    AEFlashShowCameraUnit aEFlashShowCameraUnit;
                    z16 = this.f63725d.hasCameraViewShown;
                    if (z16) {
                        this.f63725d.hasCameraUnitResumed = true;
                        aEFlashShowCameraUnit = this.f63725d.cameraUnit;
                        aEFlashShowCameraUnit.onActivityResume();
                    }
                }

                @Override // com.tencent.aelight.camera.ae.q
                public void onActivityStart() {
                    boolean z16;
                    AEFlashShowCameraUnit aEFlashShowCameraUnit;
                    z16 = this.f63725d.hasCameraViewShown;
                    if (z16) {
                        aEFlashShowCameraUnit = this.f63725d.cameraUnit;
                        aEFlashShowCameraUnit.onActivityStart();
                    }
                }

                @Override // com.tencent.aelight.camera.ae.q
                public void onActivityStop() {
                    boolean z16;
                    AEFlashShowCameraUnit aEFlashShowCameraUnit;
                    z16 = this.f63725d.hasCameraViewShown;
                    if (z16) {
                        aEFlashShowCameraUnit = this.f63725d.cameraUnit;
                        aEFlashShowCameraUnit.onActivityStop();
                    }
                }

                @Override // com.tencent.aelight.camera.ae.q
                public boolean onBackPressed() {
                    boolean z16;
                    int i3;
                    AEFlashShowCameraUnit aEFlashShowCameraUnit;
                    z16 = this.f63725d.hasCameraViewShown;
                    if (z16) {
                        i3 = this.f63725d.currentMode;
                        if (i3 != 2) {
                            aEFlashShowCameraUnit = this.f63725d.cameraUnit;
                            return aEFlashShowCameraUnit.onBackPressed();
                        }
                    }
                    return false;
                }

                @Override // com.tencent.aelight.camera.ae.q
                public void onCreate(Bundle savedInstanceState) {
                    AEFlashShowCameraUnit aEFlashShowCameraUnit;
                    aEFlashShowCameraUnit = this.f63725d.cameraUnit;
                    aEFlashShowCameraUnit.onCreate(savedInstanceState);
                }

                @Override // com.tencent.aelight.camera.ae.q
                public void onDestroy() {
                    FlashShowSwitchLayout flashShowSwitchLayout;
                    AEFlashShowCameraUnit aEFlashShowCameraUnit;
                    flashShowSwitchLayout = this.f63725d.mSwitcherView;
                    if (flashShowSwitchLayout != null) {
                        flashShowSwitchLayout.g();
                    }
                    aEFlashShowCameraUnit = this.f63725d.cameraUnit;
                    aEFlashShowCameraUnit.onDestroy();
                }

                @Override // com.tencent.aelight.camera.ae.q
                public void onNewIntent(Intent intent) {
                    AEFlashShowCameraUnit aEFlashShowCameraUnit;
                    aEFlashShowCameraUnit = this.f63725d.cameraUnit;
                    aEFlashShowCameraUnit.onNewIntent(intent);
                }

                @Override // com.tencent.aelight.camera.ae.q
                public void onSaveInstanceState(Bundle outState) {
                    AEFlashShowCameraUnit aEFlashShowCameraUnit;
                    aEFlashShowCameraUnit = this.f63725d.cameraUnit;
                    aEFlashShowCameraUnit.onSaveInstanceState(outState);
                }

                @Override // com.tencent.aelight.camera.ae.q
                public boolean onTouchEvent(MotionEvent ev5, boolean b16) {
                    boolean z16;
                    int i3;
                    AEFlashShowCameraUnit aEFlashShowCameraUnit;
                    z16 = this.f63725d.hasCameraViewShown;
                    if (z16) {
                        i3 = this.f63725d.currentMode;
                        if (i3 != 2) {
                            aEFlashShowCameraUnit = this.f63725d.cameraUnit;
                            return aEFlashShowCameraUnit.onTouchEvent(ev5, b16);
                        }
                    }
                    return false;
                }

                @Override // com.tencent.aelight.camera.ae.q
                public void onWindowFocusChanged(boolean hasFocus) {
                    boolean z16;
                    AEFlashShowCameraUnit aEFlashShowCameraUnit;
                    z16 = this.f63725d.hasCameraUnitViewCreated;
                    if (z16) {
                        aEFlashShowCameraUnit = this.f63725d.cameraUnit;
                        aEFlashShowCameraUnit.onWindowFocusChanged(hasFocus);
                    }
                }

                @Override // com.tencent.aelight.camera.ae.q
                public View q(ViewGroup parentView) {
                    AEFlashShowCameraUnit aEFlashShowCameraUnit;
                    Intrinsics.checkNotNullParameter(parentView, "parentView");
                    this.f63725d.hasCameraUnitViewCreated = true;
                    aEFlashShowCameraUnit = this.f63725d.cameraUnit;
                    View q16 = aEFlashShowCameraUnit.q(parentView);
                    Intrinsics.checkNotNullExpressionValue(q16, "cameraUnit.onCreateView(parentView)");
                    return q16;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final a invoke() {
                return new a(FlashShowCaptureViewManager.this);
            }
        });
        this.cameraLifeCallbackDelegate = lazy2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(FlashShowCaptureViewManager this$0, Boolean visible) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(visible, "visible");
        if (visible.booleanValue()) {
            AEFlashShowBottomPanelViewModel aEFlashShowBottomPanelViewModel = this$0.mBottomPanelViewModel;
            if (aEFlashShowBottomPanelViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBottomPanelViewModel");
                aEFlashShowBottomPanelViewModel = null;
            }
            if (!aEFlashShowBottomPanelViewModel.o2()) {
                z16 = true;
                this$0.M(z16);
            }
        }
        z16 = false;
        this$0.M(z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(FlashShowCaptureViewManager this$0, Boolean bool) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (bool.booleanValue()) {
            return;
        }
        this$0.M(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(FlashShowCaptureViewManager this$0, AEFlashCameraCaptureButtonLayout.Style style) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (style == AEFlashCameraCaptureButtonLayout.Style.VIDEO_STYLE && this$0.currentMode != 1) {
            FlashShowSwitchLayout flashShowSwitchLayout = this$0.mSwitcherView;
            if (flashShowSwitchLayout != null) {
                flashShowSwitchLayout.setCurrentItem(1, false);
            }
            this$0.O();
        }
        if (style != AEFlashCameraCaptureButtonLayout.Style.PIC_STYLE || this$0.currentMode == 0) {
            return;
        }
        FlashShowSwitchLayout flashShowSwitchLayout2 = this$0.mSwitcherView;
        if (flashShowSwitchLayout2 != null) {
            flashShowSwitchLayout2.setCurrentItem(0, false);
        }
        this$0.O();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(FlashShowCaptureViewManager this$0, Boolean bool) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.M(true);
    }

    private final void F() {
        if (this.hasCameraUnitResumed) {
            this.cameraUnit.f4();
            this.cameraUnit.q4();
        }
    }

    private final void G() {
        if (this.hasCameraUnitViewCreated) {
            if (!this.hasCameraViewShown) {
                J();
                this.hasCameraViewShown = true;
                tq.b.h().v(System.currentTimeMillis(), false, false);
                t().onActivityStart();
                t().onActivityResume();
                return;
            }
            if (this.hasCameraUnitResumed) {
                J();
                tq.b.h().v(System.currentTimeMillis(), false, true);
                this.cameraUnit.j4();
                com.tencent.aelight.camera.ae.flashshow.ui.ab abVar = this.mCaptureViewModel;
                if (abVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCaptureViewModel");
                    abVar = null;
                }
                if (abVar.L1().getValue() == AEFlashCameraCaptureButtonLayout.Style.VIDEO_STYLE) {
                    this.cameraUnit.p4();
                }
            }
        }
    }

    private final void J() {
        ms.a.f("FlashShowCaptureViewManager", "register datong pageId to flash show camera");
        VideoReport.addToDetectionWhitelist(this.activity);
        VideoReport.setPageId(this.parentView, WinkDaTongReportConstant.PageId.PG_XSJ_CAMERA_PAGE);
        HashMap<String, Object> g16 = ab.c().g();
        Intrinsics.checkNotNullExpressionValue(g16, "g().generatePageParams()");
        Intent intent = this.activity.getIntent();
        Serializable serializableExtra = intent != null ? intent.getSerializableExtra("key_attrs") : null;
        HashMap hashMap = serializableExtra instanceof HashMap ? (HashMap) serializableExtra : null;
        if (hashMap != null && hashMap.containsKey(QCircleScheme.AttrQQPublish.FROM_ENTRANCE)) {
            g16.put(WinkDaTongReportConstant.ElementParamKey.XSJ_LIVE_AVATAR_ENTRANCE, hashMap.get(QCircleScheme.AttrQQPublish.FROM_ENTRANCE));
        }
        VideoReport.setPageParams(this.parentView, new PageParams(g16));
    }

    private final void K() {
        FlashShowSwitchLayout flashShowSwitchLayout = this.mSwitcherView;
        if (flashShowSwitchLayout == null) {
            return;
        }
        VideoReport.setElementId(flashShowSwitchLayout, "em_xsj_picture_tab");
        VideoReport.setElementParams(flashShowSwitchLayout, ab.c().e());
        VideoReport.reportEvent("dt_clck", flashShowSwitchLayout, null);
    }

    private final void L() {
        FlashShowSwitchLayout flashShowSwitchLayout = this.mSwitcherView;
        if (flashShowSwitchLayout == null) {
            return;
        }
        VideoReport.setElementId(flashShowSwitchLayout, "em_xsj_video_tab");
        VideoReport.setElementParams(flashShowSwitchLayout, ab.c().e());
        VideoReport.reportEvent("dt_clck", flashShowSwitchLayout, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M(boolean visible) {
        if (this.cameraUnit.Y.d() != 1 && this.cameraUnit.Y.d() != 5) {
            FlashShowSwitchLayout flashShowSwitchLayout = this.mSwitcherView;
            if (flashShowSwitchLayout == null) {
                return;
            }
            flashShowSwitchLayout.setVisibility(4);
            return;
        }
        FlashShowSwitchLayout flashShowSwitchLayout2 = this.mSwitcherView;
        if (flashShowSwitchLayout2 == null) {
            return;
        }
        flashShowSwitchLayout2.setVisibility(visible ? 0 : 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N(int mode) {
        int i3 = this.currentMode;
        if (mode == 2) {
            F();
        } else if (i3 == 2) {
            G();
        }
        com.tencent.mobileqq.wink.editor.music.viewmodel.a aVar = null;
        if (mode == 0) {
            com.tencent.aelight.camera.ae.flashshow.ui.ab abVar = this.mCaptureViewModel;
            if (abVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCaptureViewModel");
                abVar = null;
            }
            abVar.L1().postValue(AEFlashCameraCaptureButtonLayout.Style.PIC_STYLE);
            com.tencent.mobileqq.wink.editor.music.viewmodel.a aVar2 = this.mMusicPlayerViewModel;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMusicPlayerViewModel");
            } else {
                aVar = aVar2;
            }
            aVar.P1();
        } else if (mode == 1) {
            com.tencent.aelight.camera.ae.flashshow.ui.ab abVar2 = this.mCaptureViewModel;
            if (abVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCaptureViewModel");
                abVar2 = null;
            }
            abVar2.L1().postValue(AEFlashCameraCaptureButtonLayout.Style.VIDEO_STYLE);
            com.tencent.mobileqq.wink.editor.music.viewmodel.a aVar3 = this.mMusicPlayerViewModel;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMusicPlayerViewModel");
            } else {
                aVar = aVar3;
            }
            aVar.O1();
        }
        this.currentMode = mode;
        if (mode == 1) {
            L();
        } else if (mode == 0) {
            K();
        }
    }

    private final void O() {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.aa
            @Override // java.lang.Runnable
            public final void run() {
                FlashShowCaptureViewManager.P(FlashShowCaptureViewManager.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(FlashShowCaptureViewManager this$0) {
        VibrationEffect createOneShot;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (Build.VERSION.SDK_INT > 25) {
            createOneShot = VibrationEffect.createOneShot(50L, -1);
            this$0.v().vibrate(createOneShot);
        } else {
            this$0.v().vibrate(50L);
        }
    }

    private final int u() {
        int d16 = this.cameraUnit.Y.d();
        if (d16 != 2) {
            return (d16 == 3 || d16 != 5) ? 1 : 0;
        }
        return 0;
    }

    private final Vibrator v() {
        return (Vibrator) this.mVibrator.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int w(int position) {
        int d16 = this.cameraUnit.Y.d();
        if (d16 == 2) {
            return 0;
        }
        if (d16 != 3) {
            return position;
        }
        return 1;
    }

    private final void y(View rootView) {
        View inflate;
        if (this.cameraUnit.Y.d() == 2 || this.cameraUnit.Y.d() == 3) {
            return;
        }
        ViewStub viewStub = (ViewStub) rootView.findViewById(R.id.rqd);
        this.mSwitcherViewStub = viewStub;
        FlashShowSwitchLayout flashShowSwitchLayout = (viewStub == null || (inflate = viewStub.inflate()) == null) ? null : (FlashShowSwitchLayout) inflate.findViewById(R.id.rqc);
        this.mSwitcherView = flashShowSwitchLayout;
        if (flashShowSwitchLayout != null) {
            flashShowSwitchLayout.setTabSwitchListener(new b());
        }
        FlashShowSwitchLayout flashShowSwitchLayout2 = this.mSwitcherView;
        if (flashShowSwitchLayout2 != null) {
            FlashShowSwitchLayout.setCurrentItem$default(flashShowSwitchLayout2, u(), false, 2, null);
        }
        FlashShowSwitchLayout flashShowSwitchLayout3 = this.mSwitcherView;
        if (flashShowSwitchLayout3 == null) {
            return;
        }
        flashShowSwitchLayout3.setVisibility(8);
    }

    private final void z() {
        ViewModel viewModel = com.tencent.aelight.camera.ae.n.a(this.cameraUnit).get(com.tencent.aelight.camera.ae.flashshow.ui.ab.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "of(cameraUnit).get(AEFla\u2026odeViewModel::class.java)");
        this.mCaptureViewModel = (com.tencent.aelight.camera.ae.flashshow.ui.ab) viewModel;
        ViewModel viewModel2 = com.tencent.aelight.camera.ae.n.a(this.cameraUnit).get(com.tencent.aelight.camera.ae.part.a.class);
        Intrinsics.checkNotNullExpressionValue(viewModel2, "of(cameraUnit).get(AEVid\u2026ateViewModel::class.java)");
        this.mStateViewModel = (com.tencent.aelight.camera.ae.part.a) viewModel2;
        Object systemService = this.activity.getSystemService("audio");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        ViewModel viewModel3 = new ViewModelProvider(this.activity, new com.tencent.mobileqq.wink.editor.music.viewmodel.f((AudioManager) systemService, Scene.CAMERA)).get(com.tencent.mobileqq.wink.editor.music.viewmodel.a.class);
        Intrinsics.checkNotNullExpressionValue(viewModel3, "ViewModelProvider(activi\u2026yerViewModel::class.java]");
        this.mMusicPlayerViewModel = (com.tencent.mobileqq.wink.editor.music.viewmodel.a) viewModel3;
        ViewModel viewModel4 = com.tencent.aelight.camera.ae.n.a(this.cameraUnit).get(AEFlashShowBottomPanelViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel4, "of(cameraUnit).get(AEFla\u2026nelViewModel::class.java)");
        AEFlashShowBottomPanelViewModel aEFlashShowBottomPanelViewModel = (AEFlashShowBottomPanelViewModel) viewModel4;
        this.mBottomPanelViewModel = aEFlashShowBottomPanelViewModel;
        com.tencent.aelight.camera.ae.part.a aVar = null;
        if (aEFlashShowBottomPanelViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBottomPanelViewModel");
            aEFlashShowBottomPanelViewModel = null;
        }
        MediatorLiveData<Pair<PanelTag, Boolean>> e26 = aEFlashShowBottomPanelViewModel.e2();
        AEFlashShowCameraUnit aEFlashShowCameraUnit = this.cameraUnit;
        final Function1<Pair<? extends PanelTag, ? extends Boolean>, Unit> function1 = new Function1<Pair<? extends PanelTag, ? extends Boolean>, Unit>() { // from class: com.tencent.aelight.camera.ae.flashshow.FlashShowCaptureViewManager$initViewModel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends PanelTag, ? extends Boolean> pair) {
                invoke2((Pair<? extends PanelTag, Boolean>) pair);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Pair<? extends PanelTag, Boolean> pair) {
                if (pair == null) {
                    return;
                }
                FlashShowCaptureViewManager.this.M(!pair.getSecond().booleanValue());
            }
        };
        e26.observe(aEFlashShowCameraUnit, new Observer() { // from class: com.tencent.aelight.camera.ae.flashshow.v
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FlashShowCaptureViewManager.A(Function1.this, obj);
            }
        });
        com.tencent.aelight.camera.ae.part.a aVar2 = this.mStateViewModel;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mStateViewModel");
            aVar2 = null;
        }
        aVar2.M1().observe(this.cameraUnit, new Observer() { // from class: com.tencent.aelight.camera.ae.flashshow.w
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FlashShowCaptureViewManager.B(FlashShowCaptureViewManager.this, (Boolean) obj);
            }
        });
        AEFlashShowBottomPanelViewModel aEFlashShowBottomPanelViewModel2 = this.mBottomPanelViewModel;
        if (aEFlashShowBottomPanelViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBottomPanelViewModel");
            aEFlashShowBottomPanelViewModel2 = null;
        }
        aEFlashShowBottomPanelViewModel2.f2().observe(this.cameraUnit, new Observer() { // from class: com.tencent.aelight.camera.ae.flashshow.x
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FlashShowCaptureViewManager.C(FlashShowCaptureViewManager.this, (Boolean) obj);
            }
        });
        com.tencent.aelight.camera.ae.flashshow.ui.ab abVar = this.mCaptureViewModel;
        if (abVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCaptureViewModel");
            abVar = null;
        }
        abVar.M1().observe(this.cameraUnit, new Observer() { // from class: com.tencent.aelight.camera.ae.flashshow.y
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FlashShowCaptureViewManager.D(FlashShowCaptureViewManager.this, (AEFlashCameraCaptureButtonLayout.Style) obj);
            }
        });
        com.tencent.aelight.camera.ae.part.a aVar3 = this.mStateViewModel;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mStateViewModel");
        } else {
            aVar = aVar3;
        }
        aVar.O1().observe(this.cameraUnit, new Observer() { // from class: com.tencent.aelight.camera.ae.flashshow.z
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FlashShowCaptureViewManager.E(FlashShowCaptureViewManager.this, (Boolean) obj);
            }
        });
    }

    public final void H() {
        if (this.currentMode != 2) {
            F();
        }
    }

    public final void I() {
        if (this.currentMode != 2) {
            G();
        }
    }

    public final View s(ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        this.parentView = parent;
        z();
        View rootView = LayoutInflater.from(this.activity).inflate(R.layout.dnt, parent, false);
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        x(rootView);
        y(rootView);
        return rootView;
    }

    public final com.tencent.aelight.camera.ae.q t() {
        return (com.tencent.aelight.camera.ae.q) this.cameraLifeCallbackDelegate.getValue();
    }

    private final void x(View rootView) {
        ((FrameLayout) rootView.findViewById(R.id.rqb)).addView(t().q(this.parentView), new ViewGroup.LayoutParams(-1, -1));
    }
}
