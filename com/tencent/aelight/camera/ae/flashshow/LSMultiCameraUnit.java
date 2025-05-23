package com.tencent.aelight.camera.ae.flashshow;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEBeautyProviderViewModel;
import com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel;
import com.tencent.aelight.camera.ae.flashshow.LSCameraManager;
import com.tencent.aelight.camera.ae.flashshow.LSMultiCameraUnit;
import com.tencent.aelight.camera.ae.flashshow.ax;
import com.tencent.aelight.camera.ae.flashshow.receiver.LSMultiCameraBroadcastReceiver;
import com.tencent.aelight.camera.ae.flashshow.util.CameraFocusView;
import com.tencent.aelight.camera.ae.g;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.struct.camera.AEPhotoCaptureResult;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.xsad.rewarded.dynamic.method.AdCommonMethodHandler;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.activity.ComponentBaseActivity;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.forward.ForwardMiniChooseFriendOption;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qqpermission.view.PermissionRequestDialog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.ttpic.openapi.filter.GLGestureProxy;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ac\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\b\u0010Q\u001a\u0004\u0018\u00010P\u0012\b\u0010S\u001a\u0004\u0018\u00010R\u00a2\u0006\u0004\bT\u0010UJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\t\u001a\u00020\u0003H\u0014J\u0014\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014J\b\u0010\f\u001a\u00020\u0003H\u0014J\b\u0010\r\u001a\u00020\u0003H\u0014J\b\u0010\u000f\u001a\u00020\u000eH\u0014J\b\u0010\u0010\u001a\u00020\u0003H\u0014J-\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00112\u000e\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u00132\u0006\u0010\u0017\u001a\u00020\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u001a\u001a\u00020\u0003H\u0014J\b\u0010\u001c\u001a\u00020\u001bH\u0016J\b\u0010\u001d\u001a\u00020\u0003H\u0015J\b\u0010\u001e\u001a\u00020\u0003H\u0014J\b\u0010\u001f\u001a\u00020\u0003H\u0016J\u0012\u0010\"\u001a\u00020\u00032\b\u0010!\u001a\u0004\u0018\u00010 H\u0016J\b\u0010#\u001a\u00020\u0003H\u0014J\b\u0010$\u001a\u00020\u001bH\u0016J \u0010)\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u00112\u0006\u0010&\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020'H\u0016J\b\u0010*\u001a\u00020\u0003H\u0016J\b\u0010+\u001a\u00020\u0003H\u0016J\u001a\u0010/\u001a\u00020\u001b2\b\u0010,\u001a\u0004\u0018\u00010\u00072\u0006\u0010.\u001a\u00020-H\u0016J\b\u00100\u001a\u00020\u0003H\u0014J\b\u00101\u001a\u00020\u0003H\u0016J\n\u00103\u001a\u0004\u0018\u000102H\u0014J\n\u00105\u001a\u0004\u0018\u000104H\u0014J\u0006\u00106\u001a\u00020\u0003J\u0006\u00107\u001a\u00020\u0003R\u0018\u0010;\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u001b\u0010@\u001a\u00020<8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010=\u001a\u0004\b>\u0010?R\u001b\u0010E\u001a\u00020A8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\bB\u0010=\u001a\u0004\bC\u0010DR\u0018\u0010I\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010L\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010O\u001a\u00020M8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010N\u00a8\u0006V"}, d2 = {"Lcom/tencent/aelight/camera/ae/flashshow/LSMultiCameraUnit;", "Lcom/tencent/aelight/camera/ae/flashshow/LSMiddleCameraUnit;", "Lcom/tencent/aelight/camera/ae/flashshow/LSCameraGLSurfaceView$t;", "", "d3", "Landroid/view/ViewGroup;", "parentView", "Landroid/view/View;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "T1", "Llq/b;", "u1", "u", "V1", "Lxp/a;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "S1", "", "requestCode", "", "", "permissions", "", "grantResults", "k3", "(I[Ljava/lang/String;[I)V", "a0", "", "e", "d1", "e1", "g", "Lcom/tencent/aelight/camera/struct/camera/AEPhotoCaptureResult;", "result", "onPhotoCaptured", "X", "onBackPressed", "whichCamera", "needWideAngleLens", "Lcom/tencent/aelight/camera/ae/flashshow/LSCameraManager$b;", "openCallback", "r", "onActivityPause", "onActivityResume", "v", "Landroid/view/MotionEvent;", "event", "onTouch", "y1", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/content/BroadcastReceiver;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/content/IntentFilter;", "B", "l3", ICustomDataEditor.NUMBER_PARAM_3, "Lcom/tencent/mobileqq/qqpermission/QQPermission;", "t1", "Lcom/tencent/mobileqq/qqpermission/QQPermission;", "mQQPermission", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/AEBeautyProviderViewModel;", "Lkotlin/Lazy;", "b3", "()Lcom/tencent/aelight/camera/ae/camera/ui/panel/AEBeautyProviderViewModel;", "mBeautyViewModel", "Lcom/tencent/aelight/camera/ae/flashshow/ax;", "v1", "c3", "()Lcom/tencent/aelight/camera/ae/flashshow/ax;", "mLsMultiCameraViewModel", "Landroid/widget/ImageView;", "w1", "Landroid/widget/ImageView;", "captureBtn", "x1", "I", "cameraHeight", "Lcom/tencent/aelight/camera/ae/flashshow/receiver/LSMultiCameraBroadcastReceiver;", "Lcom/tencent/aelight/camera/ae/flashshow/receiver/LSMultiCameraBroadcastReceiver;", "mReceiver", "Lor/e;", ParseCommon.CONTAINER, "Lor/d;", QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, "<init>", "(Lor/e;Lor/d;)V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class LSMultiCameraUnit extends LSMiddleCameraUnit {

    /* renamed from: t1, reason: collision with root package name and from kotlin metadata */
    private QQPermission mQQPermission;

    /* renamed from: u1, reason: collision with root package name and from kotlin metadata */
    private final Lazy mBeautyViewModel;

    /* renamed from: v1, reason: collision with root package name and from kotlin metadata */
    private final Lazy mLsMultiCameraViewModel;

    /* renamed from: w1, reason: collision with root package name and from kotlin metadata */
    private ImageView captureBtn;

    /* renamed from: x1, reason: collision with root package name and from kotlin metadata */
    private int cameraHeight;

    /* renamed from: y1, reason: collision with root package name and from kotlin metadata */
    private LSMultiCameraBroadcastReceiver mReceiver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J$\u0010\t\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004H\u0016J\u001e\u0010\r\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/aelight/camera/ae/flashshow/LSMultiCameraUnit$a", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "", "", "permissions", "", ForwardMiniChooseFriendOption.RESULT_LIST, "onDenied", "Lcom/tencent/mobileqq/qqpermission/view/PermissionRequestDialog;", "dialog", "deniedPermissions", AdCommonMethodHandler.AdCommonEvent.ON_DIALOG_SHOW, "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class a extends QQPermission.BasePermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ComponentBaseActivity f64028a;

        a(ComponentBaseActivity componentBaseActivity) {
            this.f64028a = componentBaseActivity;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(ComponentBaseActivity activity, View view) {
            Intrinsics.checkNotNullParameter(activity, "$activity");
            activity.finish();
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> permissions, List<Integer> results) {
            Intrinsics.checkNotNullParameter(permissions, "permissions");
            Intrinsics.checkNotNullParameter(results, "results");
            super.onDenied(permissions, results);
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDialogShow(PermissionRequestDialog dialog, List<String> deniedPermissions) {
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            Intrinsics.checkNotNullParameter(deniedPermissions, "deniedPermissions");
            final ComponentBaseActivity componentBaseActivity = this.f64028a;
            dialog.setOnDisAllowClickListener(new View.OnClickListener() { // from class: com.tencent.aelight.camera.ae.flashshow.aw
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LSMultiCameraUnit.a.b(ComponentBaseActivity.this, view);
                }
            });
            super.onDialogShow(dialog, deniedPermissions);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AEBeautyProviderViewModel b3() {
        return (AEBeautyProviderViewModel) this.mBeautyViewModel.getValue();
    }

    private final void d3() {
        c3().e2(K());
        MutableLiveData<Boolean> S1 = c3().S1();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.aelight.camera.ae.flashshow.LSMultiCameraUnit$initLSCameraViewModel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                LSMultiCameraUnit.this.v();
            }
        };
        S1.observe(this, new Observer() { // from class: com.tencent.aelight.camera.ae.flashshow.aq
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LSMultiCameraUnit.e3(Function1.this, obj);
            }
        });
        MutableLiveData<Boolean> X1 = c3().X1();
        final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: com.tencent.aelight.camera.ae.flashshow.LSMultiCameraUnit$initLSCameraViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                LSMultiCameraUnit.this.m0();
            }
        };
        X1.observe(this, new Observer() { // from class: com.tencent.aelight.camera.ae.flashshow.ar
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LSMultiCameraUnit.f3(Function1.this, obj);
            }
        });
        MutableLiveData<HashMap<String, String>> T1 = c3().T1();
        final Function1<HashMap<String, String>, Unit> function13 = new Function1<HashMap<String, String>, Unit>() { // from class: com.tencent.aelight.camera.ae.flashshow.LSMultiCameraUnit$initLSCameraViewModel$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(HashMap<String, String> hashMap) {
                invoke2(hashMap);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HashMap<String, String> hashMap) {
                Integer valueOf = hashMap != null ? Integer.valueOf(hashMap.size()) : null;
                if (valueOf != null && valueOf.intValue() == 2) {
                    LSMultiCameraUnit.this.c3().P1().postValue(new ax.a(3, hashMap, LSMultiCameraUnit.this.K()));
                    return;
                }
                if (valueOf != null && valueOf.intValue() == 0) {
                    if (LSMultiCameraUnit.this.c3().getSelectedCamera() != LSMultiCameraUnit.this.K()) {
                        ax mLsMultiCameraViewModel = LSMultiCameraUnit.this.c3();
                        Intrinsics.checkNotNullExpressionValue(mLsMultiCameraViewModel, "mLsMultiCameraViewModel");
                        ax.i2(mLsMultiCameraViewModel, true, null, 2, null);
                    }
                    LSMultiCameraUnit.this.c3().P1().postValue(new ax.a(1, null, LSMultiCameraUnit.this.c3().getSelectedCamera()));
                }
            }
        };
        T1.observe(this, new Observer() { // from class: com.tencent.aelight.camera.ae.flashshow.as
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LSMultiCameraUnit.g3(Function1.this, obj);
            }
        });
        MutableLiveData<Boolean> W1 = c3().W1();
        final Function1<Boolean, Unit> function14 = new Function1<Boolean, Unit>() { // from class: com.tencent.aelight.camera.ae.flashshow.LSMultiCameraUnit$initLSCameraViewModel$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean it) {
                AEBeautyProviderViewModel b36;
                b36 = LSMultiCameraUnit.this.b3();
                if (b36 != null) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    b36.S1(it.booleanValue());
                }
            }
        };
        W1.observe(this, new Observer() { // from class: com.tencent.aelight.camera.ae.flashshow.at
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LSMultiCameraUnit.h3(Function1.this, obj);
            }
        });
        MutableLiveData<Pair<String, String>> R1 = c3().R1();
        final Function1<Pair<? extends String, ? extends String>, Unit> function15 = new Function1<Pair<? extends String, ? extends String>, Unit>() { // from class: com.tencent.aelight.camera.ae.flashshow.LSMultiCameraUnit$initLSCameraViewModel$5
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends String, ? extends String> pair) {
                invoke2((Pair<String, String>) pair);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Pair<String, String> pair) {
                if (LSMultiCameraUnit.this.f63953x0 == null || pair.getFirst() == null || pair.getSecond() == null) {
                    return;
                }
                LSMultiCameraUnit.this.f63953x0.y(pair.getFirst(), pair.getSecond(), true);
            }
        };
        R1.observe(this, new Observer() { // from class: com.tencent.aelight.camera.ae.flashshow.au
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LSMultiCameraUnit.i3(Function1.this, obj);
            }
        });
        MutableLiveData<AEVideoStoryTopBarViewModel.Ratio> O1 = c3().O1();
        final Function1<AEVideoStoryTopBarViewModel.Ratio, Unit> function16 = new Function1<AEVideoStoryTopBarViewModel.Ratio, Unit>() { // from class: com.tencent.aelight.camera.ae.flashshow.LSMultiCameraUnit$initLSCameraViewModel$6

            /* compiled from: P */
            @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
            /* loaded from: classes32.dex */
            public /* synthetic */ class a {

                /* renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f64029a;

                static {
                    int[] iArr = new int[AEVideoStoryTopBarViewModel.Ratio.values().length];
                    try {
                        iArr[AEVideoStoryTopBarViewModel.Ratio.R_4_3.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[AEVideoStoryTopBarViewModel.Ratio.R_1_1.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[AEVideoStoryTopBarViewModel.Ratio.R_16_9.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[AEVideoStoryTopBarViewModel.Ratio.FULL.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    f64029a = iArr;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AEVideoStoryTopBarViewModel.Ratio ratio) {
                invoke2(ratio);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(AEVideoStoryTopBarViewModel.Ratio ratio) {
                View view;
                float f16;
                float f17;
                float f18;
                int i3;
                int i16;
                Resources resources;
                DisplayMetrics displayMetrics;
                if (ratio == null || (view = LSMultiCameraUnit.this.D) == null) {
                    return;
                }
                int i17 = (view == null || (resources = view.getResources()) == null || (displayMetrics = resources.getDisplayMetrics()) == null) ? 1080 : displayMetrics.widthPixels;
                LSMultiCameraUnit lSMultiCameraUnit = LSMultiCameraUnit.this;
                int i18 = a.f64029a[ratio.ordinal()];
                if (i18 != 1) {
                    if (i18 != 2) {
                        if (i18 == 3) {
                            f16 = i17;
                            f17 = 0.5625f;
                        } else if (i18 != 4) {
                            throw new NoWhenBranchMatchedException();
                        }
                    }
                    f18 = i17 / 1.0f;
                    lSMultiCameraUnit.cameraHeight = (int) f18;
                    View view2 = LSMultiCameraUnit.this.D;
                    Intrinsics.checkNotNull(view2);
                    CardView cardView = (CardView) view2.findViewById(R.id.rxd);
                    ViewGroup.LayoutParams layoutParams = cardView.getLayoutParams();
                    Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    marginLayoutParams.bottomMargin = ImmersiveUtils.getStatusBarHeight(LSMultiCameraUnit.this.A());
                    i3 = LSMultiCameraUnit.this.cameraHeight;
                    marginLayoutParams.height = i3;
                    cardView.setLayoutParams(marginLayoutParams);
                    View view3 = LSMultiCameraUnit.this.D;
                    Intrinsics.checkNotNull(view3);
                    LSCameraGLSurfaceView lSCameraGLSurfaceView = (LSCameraGLSurfaceView) view3.findViewById(R.id.rxc);
                    ViewGroup.LayoutParams layoutParams2 = lSCameraGLSurfaceView.getLayoutParams();
                    Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                    i16 = LSMultiCameraUnit.this.cameraHeight;
                    marginLayoutParams2.height = i16;
                    marginLayoutParams2.bottomMargin = ImmersiveUtils.getStatusBarHeight(LSMultiCameraUnit.this.A());
                    lSCameraGLSurfaceView.setLayoutParams(marginLayoutParams2);
                    ms.a.f(LSMultiCameraUnit.this.f63731f, " mCurrentRatio---onChanged: ratio=" + ratio);
                    LSMultiCameraUnit lSMultiCameraUnit2 = LSMultiCameraUnit.this;
                    lSMultiCameraUnit2.V = ratio;
                    lSMultiCameraUnit2.E.setCurrentRatio(ratio);
                }
                f16 = i17;
                f17 = 0.75f;
                f18 = f16 / f17;
                lSMultiCameraUnit.cameraHeight = (int) f18;
                View view22 = LSMultiCameraUnit.this.D;
                Intrinsics.checkNotNull(view22);
                CardView cardView2 = (CardView) view22.findViewById(R.id.rxd);
                ViewGroup.LayoutParams layoutParams3 = cardView2.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams3;
                marginLayoutParams3.bottomMargin = ImmersiveUtils.getStatusBarHeight(LSMultiCameraUnit.this.A());
                i3 = LSMultiCameraUnit.this.cameraHeight;
                marginLayoutParams3.height = i3;
                cardView2.setLayoutParams(marginLayoutParams3);
                View view32 = LSMultiCameraUnit.this.D;
                Intrinsics.checkNotNull(view32);
                LSCameraGLSurfaceView lSCameraGLSurfaceView2 = (LSCameraGLSurfaceView) view32.findViewById(R.id.rxc);
                ViewGroup.LayoutParams layoutParams22 = lSCameraGLSurfaceView2.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams22, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                ViewGroup.MarginLayoutParams marginLayoutParams22 = (ViewGroup.MarginLayoutParams) layoutParams22;
                i16 = LSMultiCameraUnit.this.cameraHeight;
                marginLayoutParams22.height = i16;
                marginLayoutParams22.bottomMargin = ImmersiveUtils.getStatusBarHeight(LSMultiCameraUnit.this.A());
                lSCameraGLSurfaceView2.setLayoutParams(marginLayoutParams22);
                ms.a.f(LSMultiCameraUnit.this.f63731f, " mCurrentRatio---onChanged: ratio=" + ratio);
                LSMultiCameraUnit lSMultiCameraUnit22 = LSMultiCameraUnit.this;
                lSMultiCameraUnit22.V = ratio;
                lSMultiCameraUnit22.E.setCurrentRatio(ratio);
            }
        };
        O1.observe(this, new Observer() { // from class: com.tencent.aelight.camera.ae.flashshow.av
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LSMultiCameraUnit.j3(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.LSBaseCameraUnit
    protected IntentFilter B() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(AECameraConstants.AE_CAMERA_QZONE_RES_DOWNLOAD_FINISH_BROADCAST_ACTION);
        return intentFilter;
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit, com.tencent.aelight.camera.ae.flashshow.LSBaseCameraUnit
    protected BroadcastReceiver C() {
        return this.mReceiver;
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit, com.tencent.aelight.camera.ae.flashshow.LSBaseCameraUnit
    protected xp.a Q() {
        xp.a param = super.Q();
        param.l(g.a.C0559a.f65249c);
        Intrinsics.checkNotNullExpressionValue(param, "param");
        return param;
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit
    protected void S1() {
        this.f63954y0.g();
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit
    protected void T1() {
        this.f63948s0 = new jq.a(A(), this.A0);
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit
    protected void V1() {
        super.V1();
        d3();
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit, com.tencent.aelight.camera.ae.flashshow.LSBaseCameraUnit
    protected void X() {
        ms.a.f(this.f63731f, "onCameraChange");
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.LSBaseCameraUnit
    protected void a0() {
        if (this.f63732h.getActivity() instanceof ComponentBaseActivity) {
            Activity activity = this.f63732h.getActivity();
            Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.tencent.biz.richframework.activity.ComponentBaseActivity");
            ComponentBaseActivity componentBaseActivity = (ComponentBaseActivity) activity;
            boolean z16 = componentBaseActivity.checkSelfPermission(QQPermissionConstants.Permission.CAMERA) != 0;
            LinkedList linkedList = new LinkedList();
            if (z16) {
                linkedList.add(QQPermissionConstants.Permission.CAMERA);
            }
            if (linkedList.isEmpty()) {
                return;
            }
            if (this.mQQPermission == null) {
                this.mQQPermission = QQPermissionFactory.getQQPermission(componentBaseActivity, new BusinessConfig(QQPermissionConstants.Business.ID.GY_FLASH_SHOW_UNIT, QQPermissionConstants.Business.SCENE.GY_FLASH_SHOW_UNIT));
            }
            QQPermission qQPermission = this.mQQPermission;
            if (qQPermission != null) {
                Object[] array = linkedList.toArray(new String[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                qQPermission.requestPermissions((String[]) array, 2, new a(componentBaseActivity));
            }
        }
    }

    public final ax c3() {
        return (ax) this.mLsMultiCameraViewModel.getValue();
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit
    protected void d1() {
        View view = this.D;
        Intrinsics.checkNotNull(view);
        this.captureBtn = (ImageView) view.findViewById(R.id.rxe);
        View view2 = this.D;
        Intrinsics.checkNotNull(view2);
        ((CardView) view2.findViewById(R.id.rxd)).setOnTouchListener(this);
        n3();
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit, com.tencent.aelight.camera.ae.flashshow.ui.captureButton.AbsLSCaptureButton.a
    public boolean e() {
        boolean O = O();
        if (!O) {
            G2();
        }
        return O;
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit
    protected void e1() {
        ms.a.a(this.f63731f, "actionAfterStartPreviewFirstFrame");
        ms.a.a(this.f63731f, "selectedCamera " + c3().getSelectedCamera() + " lastCamera " + K());
        HashMap<String, String> value = c3().T1().getValue();
        if (value == null || value.size() != 1) {
            return;
        }
        c3().P1().postValue(new ax.a(2, value, K()));
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit, com.tencent.aelight.camera.ae.flashshow.LSBaseCameraUnit, com.tencent.aelight.camera.ae.flashshow.ui.captureButton.AbsLSCaptureButton.a
    public void g() {
        this.f63954y0.q(262147, new Object[0]);
    }

    public final void k3(int requestCode, String[] permissions, int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        QQPermission qQPermission = this.mQQPermission;
        if (qQPermission != null) {
            qQPermission.onRequestPermissionResult(requestCode, permissions, grantResults);
        }
    }

    public final void l3() {
        MutableLiveData<ax.c> Z1;
        ax c36 = c3();
        if (c36 == null || (Z1 = c36.Z1()) == null) {
            return;
        }
        Z1.postValue(new ax.c(2));
    }

    public final void n3() {
        MutableLiveData<ax.d> a26;
        ax c36 = c3();
        if (c36 == null || (a26 = c36.a2()) == null) {
            return;
        }
        a26.postValue(new ax.d(1));
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit, com.tencent.aelight.camera.ae.flashshow.LSBaseCameraUnit, com.tencent.aelight.camera.aebase.e, com.tencent.aelight.camera.ae.q
    public void onActivityPause() {
        ax.a value = c3().P1().getValue();
        boolean z16 = false;
        if (value != null && value.getStatus() == 2) {
            z16 = true;
        }
        if (z16) {
            c3().M1();
        }
        super.onActivityPause();
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit, com.tencent.aelight.camera.ae.flashshow.LSBaseCameraUnit, com.tencent.aelight.camera.aebase.e, com.tencent.aelight.camera.ae.q
    public void onActivityResume() {
        if (c3().getSelectedCamera() != K()) {
            ax mLsMultiCameraViewModel = c3();
            Intrinsics.checkNotNullExpressionValue(mLsMultiCameraViewModel, "mLsMultiCameraViewModel");
            ax.i2(mLsMultiCameraViewModel, true, null, 2, null);
        }
        super.onActivityResume();
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit, com.tencent.aelight.camera.ae.q
    public boolean onBackPressed() {
        ax.a value = c3().P1().getValue();
        if (value != null && value.getStatus() == 1) {
            return false;
        }
        c3().M1();
        return true;
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit, com.tencent.aelight.camera.ae.flashshow.LSBaseCameraUnit, com.tencent.aelight.camera.aebase.e, com.tencent.aelight.camera.ae.q
    public void onDestroy() {
        super.onDestroy();
        c3().S1().removeObservers(this);
        c3().X1().removeObservers(this);
        c3().T1().removeObservers(this);
        c3().W1().removeObservers(this);
        c3().R1().removeObservers(this);
        c3().O1().removeObservers(this);
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit, com.tencent.aelight.camera.ae.flashshow.LSCameraGLSurfaceView.y
    public void onPhotoCaptured(AEPhotoCaptureResult result) {
        ms.a.a(this.f63731f, "capture result is: " + (result != null ? result.filePath : null));
        HashMap<String, String> value = c3().T1().getValue();
        boolean z16 = false;
        if (value != null && value.size() == 1) {
            z16 = true;
        }
        if (z16) {
            c3().d2(AECameraConstants.AE_MULTI_CAMERA_SMALL_PATH, result != null ? result.filePath : null);
            return;
        }
        c3().d2(AECameraConstants.AE_MULTI_CAMERA_BIG_PATH, result != null ? result.filePath : null);
        ax mLsMultiCameraViewModel = c3();
        Intrinsics.checkNotNullExpressionValue(mLsMultiCameraViewModel, "mLsMultiCameraViewModel");
        ax.i2(mLsMultiCameraViewModel, true, null, 2, null);
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit, android.view.View.OnTouchListener
    public boolean onTouch(View v3, MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        boolean onTouchEvent = GLGestureProxy.getInstance().onTouchEvent(event, false, this.captureBtn, this.E);
        GestureDetector gestureDetector = this.f63952w0;
        if (gestureDetector == null || onTouchEvent) {
            return true;
        }
        gestureDetector.onTouchEvent(event);
        return true;
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit, com.tencent.aelight.camera.ae.flashshow.LSBaseCameraUnit, com.tencent.aelight.camera.ae.q
    public View q(ViewGroup parentView) {
        this.D = parentView;
        u();
        d0();
        this.f63953x0 = z1();
        this.f63954y0 = u1(parentView);
        V1();
        S1();
        T1();
        Intrinsics.checkNotNull(parentView);
        return parentView;
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit, com.tencent.aelight.camera.ae.flashshow.LSCameraGLSurfaceView.t
    public void r(int whichCamera, boolean needWideAngleLens, LSCameraManager.b openCallback) {
        Intrinsics.checkNotNullParameter(openCallback, "openCallback");
        super.r(whichCamera, needWideAngleLens, openCallback);
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit, com.tencent.aelight.camera.ae.flashshow.LSBaseCameraUnit
    protected void u() {
        this.E = (LSCameraGLSurfaceView) this.D.findViewById(R.id.rxc);
        this.I = (ViewStub) this.D.findViewById(R.id.f163794s15);
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit
    protected lq.b u1(ViewGroup parentView) {
        Activity activity = this.f63732h.getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "mContainer.activity");
        View mRootView = this.D;
        Intrinsics.checkNotNullExpressionValue(mRootView, "mRootView");
        return new ap(activity, mRootView, this);
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit
    protected void y1() {
        super.y1();
        View view = this.D;
        Intrinsics.checkNotNull(view);
        View findViewById = view.findViewById(R.id.rqa);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView!!.findViewById(R.id.camera_focus)");
        CameraFocusView cameraFocusView = (CameraFocusView) findViewById;
        cameraFocusView.setAdjustViewBounds(true);
        cameraFocusView.setMaxHeight(this.cameraHeight);
    }

    public LSMultiCameraUnit(or.e eVar, or.d dVar) {
        super(eVar, dVar, null);
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<AEBeautyProviderViewModel>() { // from class: com.tencent.aelight.camera.ae.flashshow.LSMultiCameraUnit$mBeautyViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AEBeautyProviderViewModel invoke() {
                return (AEBeautyProviderViewModel) com.tencent.aelight.camera.ae.n.a(LSMultiCameraUnit.this).get(AEBeautyProviderViewModel.class);
            }
        });
        this.mBeautyViewModel = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<ax>() { // from class: com.tencent.aelight.camera.ae.flashshow.LSMultiCameraUnit$mLsMultiCameraViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ax invoke() {
                return (ax) com.tencent.aelight.camera.ae.n.a(LSMultiCameraUnit.this).get(ax.class);
            }
        });
        this.mLsMultiCameraViewModel = lazy2;
        this.mReceiver = new LSMultiCameraBroadcastReceiver(this);
    }
}
