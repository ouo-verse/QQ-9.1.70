package com.tencent.sqshow.zootopia.nativeui.view.customerface;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.google.gson.Gson;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.ecommerce.base.runtime.api.IECScreenReceiver;
import com.tencent.filament.zplan.app.api.IFilamentNativeAppV2305;
import com.tencent.filament.zplan.manager.FilamentRenderFactory;
import com.tencent.filament.zplan.scene.pinchface.PinchFaceScene;
import com.tencent.filament.zplan.view.controller.FilamentTouchController;
import com.tencent.filament.zplan.view.event.TouchEvent;
import com.tencent.filament.zplanservice.feature.FilamentFeatureUtil;
import com.tencent.filament.zplanservice.feature.model.FilamentUrlTemplate;
import com.tencent.filament.zplanservice.pbjava.PinchFaceEvent$NativePinchFaceHistoryReq;
import com.tencent.filament.zplanservice.pbjava.PinchFaceEvent$NativePinchFaceSelectGroupReq;
import com.tencent.filament.zplanservice.pbjava.PinchFaceEvent$NativePinchFaceSideReq;
import com.tencent.filament.zplanservice.pbjava.PinchFaceEvent$PinchFaceUiInfo;
import com.tencent.filament.zplanservice.pbjava.avatar_info.AvatarDressInfo$FaceInfo;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import com.tencent.sqshow.zootopia.utils.aa;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import mqq.app.Constants;
import n74.bp;
import zk0.a;

@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0002GK\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\bW\u0010XJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0004H\u0002J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0010\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0011H\u0002J\u0010\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0012\u0010\u001b\u001a\u00020\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0002J\b\u0010\u001c\u001a\u00020\u0002H\u0002J\b\u0010\u001d\u001a\u00020\u0002H\u0002J\u0012\u0010 \u001a\u00020\u00022\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J&\u0010%\u001a\u0004\u0018\u00010\b2\u0006\u0010\"\u001a\u00020!2\b\u0010$\u001a\u0004\u0018\u00010#2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010&\u001a\u00020\u0002H\u0016J\b\u0010'\u001a\u00020\u0002H\u0016J\b\u0010(\u001a\u00020\u0002H\u0016J\b\u0010)\u001a\u00020\u0002H\u0016R\u0014\u0010,\u001a\u00020\u00048\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00104\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R$\u0010:\u001a\u00020\u00112\u0006\u00105\u001a\u00020\u00118\u0002@BX\u0082\u000e\u00a2\u0006\f\n\u0004\b6\u00107\"\u0004\b8\u00109R$\u0010=\u001a\u00020\u00112\u0006\u00105\u001a\u00020\u00118\u0002@BX\u0082\u000e\u00a2\u0006\f\n\u0004\b;\u00107\"\u0004\b<\u00109R\u0016\u0010?\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u00107R\u0016\u0010A\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010@R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u00107R\u0016\u0010F\u001a\u00020C8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0014\u0010J\u001a\u00020G8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0014\u0010N\u001a\u00020K8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bL\u0010MR\"\u0010R\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00040O8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0018\u0010V\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010U\u00a8\u0006Y"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/customerface/ZPlanPinchFaceFragment;", "Landroidx/fragment/app/Fragment;", "", "back", "", "tip", "hi", "li", "Landroid/view/View;", "bgView", "Landroid/widget/TextView;", "tv", "fi", "Lcom/tencent/image/URLImageView;", "selectedImageView", "selectedImageUrl", "gi", "", "isSide", "ci", "isRedo", "di", "", "point", "ei", "Lcom/tencent/filament/zplanservice/pbjava/PinchFaceEvent$PinchFaceUiInfo;", "uiInfo", "ki", "Zh", "ii", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "onCreateView", "onDestroyView", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "TAG", "Lcom/tencent/filament/zplan/app/api/IFilamentNativeAppV2305;", "D", "Lcom/tencent/filament/zplan/app/api/IFilamentNativeAppV2305;", "nativeApp", "Lcom/tencent/zplan/zplantracing/b;", "E", "Lcom/tencent/zplan/zplantracing/b;", "rootSpan", "value", UserInfo.SEX_FEMALE, "Z", "bi", "(Z)V", "canRollbackPreviousStep", "G", "ai", "canRollbackNextStep", "H", "isSaving", "I", "selectGroup", "J", "Ln74/bp;", "K", "Ln74/bp;", "binding", "com/tencent/sqshow/zootopia/nativeui/view/customerface/ZPlanPinchFaceFragment$broadcastReceiver$1", "L", "Lcom/tencent/sqshow/zootopia/nativeui/view/customerface/ZPlanPinchFaceFragment$broadcastReceiver$1;", "broadcastReceiver", "com/tencent/sqshow/zootopia/nativeui/view/customerface/ZPlanPinchFaceFragment$cEvents$1", "M", "Lcom/tencent/sqshow/zootopia/nativeui/view/customerface/ZPlanPinchFaceFragment$cEvents$1;", "cEvents", "", "N", "Ljava/util/Map;", "selectedImageUrls", "Lcom/tencent/filament/zplan/view/controller/FilamentTouchController;", "P", "Lcom/tencent/filament/zplan/view/controller/FilamentTouchController;", "touchController", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanPinchFaceFragment extends Fragment {

    /* renamed from: D, reason: from kotlin metadata */
    private IFilamentNativeAppV2305 nativeApp;

    /* renamed from: E, reason: from kotlin metadata */
    private com.tencent.zplan.zplantracing.b rootSpan;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean canRollbackPreviousStep;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean canRollbackNextStep;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean isSaving;

    /* renamed from: I, reason: from kotlin metadata */
    private int selectGroup;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean isSide;

    /* renamed from: K, reason: from kotlin metadata */
    private bp binding;

    /* renamed from: N, reason: from kotlin metadata */
    private Map<URLImageView, String> selectedImageUrls;

    /* renamed from: P, reason: from kotlin metadata */
    private FilamentTouchController touchController;

    /* renamed from: C, reason: from kotlin metadata */
    private final String TAG = "ZPlanPinchFaceFragment";

    /* renamed from: L, reason: from kotlin metadata */
    private final ZPlanPinchFaceFragment$broadcastReceiver$1 broadcastReceiver = new BroadcastReceiver() { // from class: com.tencent.sqshow.zootopia.nativeui.view.customerface.ZPlanPinchFaceFragment$broadcastReceiver$1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String str;
            IFilamentNativeAppV2305 iFilamentNativeAppV2305;
            IFilamentNativeAppV2305 iFilamentNativeAppV23052;
            str = ZPlanPinchFaceFragment.this.TAG;
            QLog.i(str, 1, "broadcastReceiver.onReceive, action: " + (intent != null ? intent.getAction() : null));
            if (intent != null) {
                ZPlanPinchFaceFragment zPlanPinchFaceFragment = ZPlanPinchFaceFragment.this;
                String action = intent.getAction();
                if (action != null) {
                    int hashCode = action.hashCode();
                    if (hashCode != -1631108101) {
                        if (hashCode == -652791834 && action.equals(IECScreenReceiver.ACTION_QQ_BACKGROUND) && (iFilamentNativeAppV23052 = zPlanPinchFaceFragment.nativeApp) != null) {
                            iFilamentNativeAppV23052.dispatchEvent(a.C11692a.f452692a);
                            return;
                        }
                        return;
                    }
                    if (!action.equals(IECScreenReceiver.ACTION_QQ_FOREGROUND) || (iFilamentNativeAppV2305 = zPlanPinchFaceFragment.nativeApp) == null) {
                        return;
                    }
                    iFilamentNativeAppV2305.dispatchEvent(a.b.f452693a);
                }
            }
        }
    };

    /* renamed from: M, reason: from kotlin metadata */
    private final ZPlanPinchFaceFragment$cEvents$1 cEvents = new tk0.a() { // from class: com.tencent.sqshow.zootopia.nativeui.view.customerface.ZPlanPinchFaceFragment$cEvents$1
        @Override // tk0.a
        public void call(tk0.b event) {
            Intrinsics.checkNotNullParameter(event, "event");
            if (event instanceof PinchFaceScene.a) {
                ZPlanPinchFaceFragment.this.ki(((PinchFaceScene.a) event).getUiInfo());
            }
        }
    };

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/view/customerface/ZPlanPinchFaceFragment$a", "Lcom/tencent/filament/zplan/view/controller/FilamentTouchController$b;", "Lcom/tencent/filament/zplan/view/event/TouchEvent;", "event", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a implements FilamentTouchController.b {
        a() {
        }

        @Override // com.tencent.filament.zplan.view.controller.FilamentTouchController.b
        public void q(TouchEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            IFilamentNativeAppV2305 iFilamentNativeAppV2305 = ZPlanPinchFaceFragment.this.nativeApp;
            if (iFilamentNativeAppV2305 != null) {
                iFilamentNativeAppV2305.dispatchEvent(null, "onTouchEvent", new Gson().toJson(event));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Nh(ZPlanPinchFaceFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i(this$0.TAG, 1, "click save");
        this$0.Zh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Oh(ZPlanPinchFaceFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Map<URLImageView, String> map = this$0.selectedImageUrls;
        bp bpVar = null;
        if (map == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectedImageUrls");
            map = null;
        }
        bp bpVar2 = this$0.binding;
        if (bpVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bpVar2 = null;
        }
        String str = map.get(bpVar2.f418882h);
        if (str != null) {
            bp bpVar3 = this$0.binding;
            if (bpVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                bpVar = bpVar3;
            }
            URLImageView uRLImageView = bpVar.f418882h;
            Intrinsics.checkNotNullExpressionValue(uRLImageView, "binding.pinchFaceFaceIcon");
            this$0.gi(uRLImageView, str);
        }
        this$0.ei(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ph(ZPlanPinchFaceFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Map<URLImageView, String> map = this$0.selectedImageUrls;
        bp bpVar = null;
        if (map == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectedImageUrls");
            map = null;
        }
        bp bpVar2 = this$0.binding;
        if (bpVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bpVar2 = null;
        }
        String str = map.get(bpVar2.f418881g);
        if (str != null) {
            bp bpVar3 = this$0.binding;
            if (bpVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                bpVar = bpVar3;
            }
            URLImageView uRLImageView = bpVar.f418881g;
            Intrinsics.checkNotNullExpressionValue(uRLImageView, "binding.pinchFaceEyebrowIcon");
            this$0.gi(uRLImageView, str);
        }
        this$0.ei(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Qh(ZPlanPinchFaceFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Map<URLImageView, String> map = this$0.selectedImageUrls;
        bp bpVar = null;
        if (map == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectedImageUrls");
            map = null;
        }
        bp bpVar2 = this$0.binding;
        if (bpVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bpVar2 = null;
        }
        String str = map.get(bpVar2.f418880f);
        if (str != null) {
            bp bpVar3 = this$0.binding;
            if (bpVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                bpVar = bpVar3;
            }
            URLImageView uRLImageView = bpVar.f418880f;
            Intrinsics.checkNotNullExpressionValue(uRLImageView, "binding.pinchFaceEyeIcon");
            this$0.gi(uRLImageView, str);
        }
        this$0.ei(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Rh(ZPlanPinchFaceFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Map<URLImageView, String> map = this$0.selectedImageUrls;
        bp bpVar = null;
        if (map == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectedImageUrls");
            map = null;
        }
        bp bpVar2 = this$0.binding;
        if (bpVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bpVar2 = null;
        }
        String str = map.get(bpVar2.f418883i);
        if (str != null) {
            bp bpVar3 = this$0.binding;
            if (bpVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                bpVar = bpVar3;
            }
            URLImageView uRLImageView = bpVar.f418883i;
            Intrinsics.checkNotNullExpressionValue(uRLImageView, "binding.pinchFaceMouthIcon");
            this$0.gi(uRLImageView, str);
        }
        this$0.ei(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Sh(ZPlanPinchFaceFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Map<URLImageView, String> map = this$0.selectedImageUrls;
        bp bpVar = null;
        if (map == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectedImageUrls");
            map = null;
        }
        bp bpVar2 = this$0.binding;
        if (bpVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bpVar2 = null;
        }
        String str = map.get(bpVar2.f418884j);
        if (str != null) {
            bp bpVar3 = this$0.binding;
            if (bpVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                bpVar = bpVar3;
            }
            URLImageView uRLImageView = bpVar.f418884j;
            Intrinsics.checkNotNullExpressionValue(uRLImageView, "binding.pinchFaceNoseIcon");
            this$0.gi(uRLImageView, str);
        }
        this$0.ei(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Th(ZPlanPinchFaceFragment this$0, View view, MotionEvent event) {
        GestureDetector m3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FilamentTouchController filamentTouchController = this$0.touchController;
        if (filamentTouchController != null) {
            Intrinsics.checkNotNullExpressionValue(event, "event");
            filamentTouchController.z(event);
        }
        FilamentTouchController filamentTouchController2 = this$0.touchController;
        if (filamentTouchController2 == null || (m3 = filamentTouchController2.m()) == null) {
            return true;
        }
        m3.onTouchEvent(event);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Uh(ZPlanPinchFaceFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.canRollbackPreviousStep) {
            this$0.ii();
        } else {
            this$0.back();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Vh(ZPlanPinchFaceFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i(this$0.TAG, 1, "click lastIgv");
        if (this$0.canRollbackPreviousStep) {
            this$0.di(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Wh(ZPlanPinchFaceFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i(this$0.TAG, 1, "click nextIgv");
        if (this$0.canRollbackNextStep) {
            this$0.di(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Xh(ZPlanPinchFaceFragment this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isSide) {
            this$0.isSide = false;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            bp bpVar = this$0.binding;
            if (bpVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                bpVar = null;
            }
            TextView textView = bpVar.f418887m;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.side1Tv");
            this$0.fi(it, textView);
            QLog.i(this$0.TAG, 1, "click front");
            this$0.ci(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Yh(ZPlanPinchFaceFragment this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isSide) {
            return;
        }
        this$0.isSide = true;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        bp bpVar = this$0.binding;
        if (bpVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bpVar = null;
        }
        TextView textView = bpVar.f418889o;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.side2Tv");
        this$0.fi(it, textView);
        QLog.i(this$0.TAG, 1, "click side");
        this$0.ci(true);
    }

    private final void Zh() {
        if (this.isSaving) {
            return;
        }
        this.isSaving = true;
        PinchFaceScene.c cVar = new PinchFaceScene.c(new Function2<Boolean, AvatarDressInfo$FaceInfo, Unit>() { // from class: com.tencent.sqshow.zootopia.nativeui.view.customerface.ZPlanPinchFaceFragment$saveFaceInfo$saveEvent$1

            /* JADX INFO: Access modifiers changed from: package-private */
            @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
            @DebugMetadata(c = "com.tencent.sqshow.zootopia.nativeui.view.customerface.ZPlanPinchFaceFragment$saveFaceInfo$saveEvent$1$1", f = "ZPlanPinchFaceFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: com.tencent.sqshow.zootopia.nativeui.view.customerface.ZPlanPinchFaceFragment$saveFaceInfo$saveEvent$1$1, reason: invalid class name */
            /* loaded from: classes34.dex */
            public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ AvatarDressInfo$FaceInfo $faceInfo;
                final /* synthetic */ boolean $isSuccess;
                int label;
                final /* synthetic */ ZPlanPinchFaceFragment this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(ZPlanPinchFaceFragment zPlanPinchFaceFragment, boolean z16, AvatarDressInfo$FaceInfo avatarDressInfo$FaceInfo, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.this$0 = zPlanPinchFaceFragment;
                    this.$isSuccess = z16;
                    this.$faceInfo = avatarDressInfo$FaceInfo;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass1(this.this$0, this.$isSuccess, this.$faceInfo, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label == 0) {
                        ResultKt.throwOnFailure(obj);
                        this.this$0.isSaving = false;
                        if (!this.$isSuccess) {
                            Toast.makeText(this.this$0.getContext(), "\u4fdd\u5b58\u5931\u8d25", 0).show();
                        } else {
                            AvatarDressInfo$FaceInfo avatarDressInfo$FaceInfo = this.$faceInfo;
                            Intrinsics.checkNotNull(avatarDressInfo$FaceInfo);
                            qu4.j c16 = qu4.j.c(avatarDressInfo$FaceInfo.toByteArray());
                            com.tencent.sqshow.zootopia.nativeui.data.c cVar = com.tencent.sqshow.zootopia.nativeui.data.c.f370920a;
                            m94.a b16 = cVar.m().b();
                            qu4.a h16 = bj3.a.h(b16.getAvatarCharacter());
                            h16.f429573b = c16;
                            cVar.m().e(new m94.a(b16.getGender(), b16.b(), h16));
                            this.this$0.back();
                        }
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, AvatarDressInfo$FaceInfo avatarDressInfo$FaceInfo) {
                invoke(bool.booleanValue(), avatarDressInfo$FaceInfo);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16, AvatarDressInfo$FaceInfo avatarDressInfo$FaceInfo) {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AnonymousClass1(ZPlanPinchFaceFragment.this, z16, avatarDressInfo$FaceInfo, null), 3, null);
            }
        });
        IFilamentNativeAppV2305 iFilamentNativeAppV2305 = this.nativeApp;
        if (iFilamentNativeAppV2305 != null) {
            iFilamentNativeAppV2305.dispatchEvent(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ai(boolean z16) {
        if (this.canRollbackNextStep != z16) {
            this.canRollbackNextStep = z16;
            li();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void back() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void bi(boolean z16) {
        if (this.canRollbackPreviousStep != z16) {
            this.canRollbackPreviousStep = z16;
            li();
        }
    }

    private final void ci(boolean isSide) {
        PinchFaceEvent$NativePinchFaceSideReq pinchFaceEvent$NativePinchFaceSideReq = new PinchFaceEvent$NativePinchFaceSideReq();
        pinchFaceEvent$NativePinchFaceSideReq.is_side_view.set(isSide);
        PinchFaceScene.b bVar = new PinchFaceScene.b(pinchFaceEvent$NativePinchFaceSideReq, new Function1<PinchFaceEvent$PinchFaceUiInfo, Unit>() { // from class: com.tencent.sqshow.zootopia.nativeui.view.customerface.ZPlanPinchFaceFragment$setPinchFaceSide$event$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PinchFaceEvent$PinchFaceUiInfo pinchFaceEvent$PinchFaceUiInfo) {
                invoke2(pinchFaceEvent$PinchFaceUiInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PinchFaceEvent$PinchFaceUiInfo pinchFaceEvent$PinchFaceUiInfo) {
                ZPlanPinchFaceFragment.this.ki(pinchFaceEvent$PinchFaceUiInfo);
            }
        });
        IFilamentNativeAppV2305 iFilamentNativeAppV2305 = this.nativeApp;
        if (iFilamentNativeAppV2305 != null) {
            iFilamentNativeAppV2305.dispatchEvent(bVar);
        }
    }

    private final void di(boolean isRedo) {
        PinchFaceEvent$NativePinchFaceHistoryReq pinchFaceEvent$NativePinchFaceHistoryReq = new PinchFaceEvent$NativePinchFaceHistoryReq();
        pinchFaceEvent$NativePinchFaceHistoryReq.is_redo.set(isRedo);
        PinchFaceScene.e eVar = new PinchFaceScene.e(pinchFaceEvent$NativePinchFaceHistoryReq, new Function1<PinchFaceEvent$PinchFaceUiInfo, Unit>() { // from class: com.tencent.sqshow.zootopia.nativeui.view.customerface.ZPlanPinchFaceFragment$setRedo$event$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PinchFaceEvent$PinchFaceUiInfo pinchFaceEvent$PinchFaceUiInfo) {
                invoke2(pinchFaceEvent$PinchFaceUiInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PinchFaceEvent$PinchFaceUiInfo pinchFaceEvent$PinchFaceUiInfo) {
                ZPlanPinchFaceFragment.this.ki(pinchFaceEvent$PinchFaceUiInfo);
            }
        });
        IFilamentNativeAppV2305 iFilamentNativeAppV2305 = this.nativeApp;
        if (iFilamentNativeAppV2305 != null) {
            iFilamentNativeAppV2305.dispatchEvent(eVar);
        }
    }

    private final void ei(int point) {
        if (this.selectGroup == point) {
            return;
        }
        this.selectGroup = point;
        PinchFaceEvent$NativePinchFaceSelectGroupReq pinchFaceEvent$NativePinchFaceSelectGroupReq = new PinchFaceEvent$NativePinchFaceSelectGroupReq();
        pinchFaceEvent$NativePinchFaceSelectGroupReq.point.set(point);
        PinchFaceScene.d dVar = new PinchFaceScene.d(pinchFaceEvent$NativePinchFaceSelectGroupReq, new Function1<PinchFaceEvent$PinchFaceUiInfo, Unit>() { // from class: com.tencent.sqshow.zootopia.nativeui.view.customerface.ZPlanPinchFaceFragment$setSelectGroup$event$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PinchFaceEvent$PinchFaceUiInfo pinchFaceEvent$PinchFaceUiInfo) {
                invoke2(pinchFaceEvent$PinchFaceUiInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PinchFaceEvent$PinchFaceUiInfo pinchFaceEvent$PinchFaceUiInfo) {
                ZPlanPinchFaceFragment.this.ki(pinchFaceEvent$PinchFaceUiInfo);
            }
        });
        IFilamentNativeAppV2305 iFilamentNativeAppV2305 = this.nativeApp;
        if (iFilamentNativeAppV2305 != null) {
            iFilamentNativeAppV2305.dispatchEvent(dVar);
        }
    }

    private final void fi(View bgView, TextView tv5) {
        bp bpVar = this.binding;
        bp bpVar2 = null;
        if (bpVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bpVar = null;
        }
        bpVar.f418886l.setBackground(null);
        bp bpVar3 = this.binding;
        if (bpVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bpVar3 = null;
        }
        bpVar3.f418888n.setBackground(null);
        bp bpVar4 = this.binding;
        if (bpVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bpVar4 = null;
        }
        bpVar4.f418887m.setTextColor(requireContext().getResources().getColor(R.color.f8326n));
        bp bpVar5 = this.binding;
        if (bpVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            bpVar2 = bpVar5;
        }
        bpVar2.f418889o.setTextColor(requireContext().getResources().getColor(R.color.f8326n));
        bgView.setBackgroundResource(R.drawable.f159870h45);
        tv5.setTextColor(requireContext().getResources().getColor(R.color.black));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hi(String tip) {
        bp bpVar = null;
        if (tip.length() == 0) {
            bp bpVar2 = this.binding;
            if (bpVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                bpVar = bpVar2;
            }
            bpVar.f418892r.setVisibility(8);
            return;
        }
        bp bpVar3 = this.binding;
        if (bpVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bpVar3 = null;
        }
        bpVar3.f418892r.setVisibility(0);
        bp bpVar4 = this.binding;
        if (bpVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            bpVar = bpVar4;
        }
        bpVar.f418891q.setText(tip);
    }

    private final void ii() {
        Context context = getContext();
        if (context == null) {
            return;
        }
        Dialog createDialog = ActionSheetHelper.createDialog(context, null);
        final ActionSheet actionSheet = createDialog instanceof ActionSheet ? (ActionSheet) createDialog : null;
        if (actionSheet != null) {
            actionSheet.setMainTitle(context.getResources().getString(R.string.xpg));
            actionSheet.addButton(context.getResources().getString(R.string.xt9), 5);
            actionSheet.addButton(context.getResources().getString(R.string.xpf), 3);
            actionSheet.addCancelButton(R.string.cancel);
            actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.sqshow.zootopia.nativeui.view.customerface.k
                @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
                public final void onClick(View view, int i3) {
                    ZPlanPinchFaceFragment.ji(ZPlanPinchFaceFragment.this, actionSheet, view, i3);
                }
            });
            actionSheet.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ji(ZPlanPinchFaceFragment this$0, ActionSheet this_apply, View view, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        if (i3 == 0) {
            this$0.Zh();
        } else if (i3 == 1) {
            this$0.back();
        }
        this_apply.dismiss();
    }

    private final void li() {
        bp bpVar = this.binding;
        bp bpVar2 = null;
        if (bpVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bpVar = null;
        }
        bpVar.f418876b.setAlpha(this.canRollbackPreviousStep ? 1.0f : 0.3f);
        bp bpVar3 = this.binding;
        if (bpVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            bpVar2 = bpVar3;
        }
        bpVar2.f418877c.setAlpha(this.canRollbackNextStep ? 1.0f : 0.3f);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        sk0.a aVar;
        QLog.i(this.TAG, 1, "onCreate");
        super.onCreate(savedInstanceState);
        Context context = getContext();
        if (context != null) {
            FilamentUrlTemplate F = FilamentFeatureUtil.f106409g.F();
            fl0.a aVar2 = fl0.a.f399763a;
            aVar = new sk0.a(F, true, context, 30, (dl0.k) aVar2.a(dl0.k.class), (dl0.d) aVar2.a(dl0.d.class), (dl0.g) aVar2.a(dl0.g.class));
        } else {
            aVar = null;
        }
        IFilamentNativeAppV2305 c16 = aVar != null ? FilamentRenderFactory.f105773b.c(aVar) : null;
        this.nativeApp = c16;
        if (c16 != null) {
            com.tencent.zplan.zplantracing.b bVar = this.rootSpan;
            c16.startWithEntry(bVar != null ? bVar.c() : null, "bundle/scenes/pinch_face/main.js");
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(IECScreenReceiver.ACTION_QQ_FOREGROUND);
        intentFilter.addAction(IECScreenReceiver.ACTION_QQ_BACKGROUND);
        Context context2 = getContext();
        if (context2 != null) {
            context2.registerReceiver(this.broadcastReceiver, intentFilter);
        }
        IFilamentNativeAppV2305 iFilamentNativeAppV2305 = this.nativeApp;
        if (iFilamentNativeAppV2305 != null) {
            iFilamentNativeAppV2305.register(tk0.c.f436439a.a(Reflection.getOrCreateKotlinClass(PinchFaceScene.a.class)), this.cEvents);
        }
        Context context3 = getContext();
        this.touchController = context3 != null ? new FilamentTouchController(context3, new a()) : null;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Map<URLImageView, String> mapOf;
        TextureView view;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        QLog.i(this.TAG, 1, "onCreateView");
        bp g16 = bp.g(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context))");
        this.binding = g16;
        Pair[] pairArr = new Pair[5];
        bp bpVar = null;
        if (g16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            g16 = null;
        }
        pairArr[0] = TuplesKt.to(g16.f418882h, "https://image.superqqshow.qq.com/icon/mall/makeup/4_select.png");
        bp bpVar2 = this.binding;
        if (bpVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bpVar2 = null;
        }
        pairArr[1] = TuplesKt.to(bpVar2.f418881g, "https://image.superqqshow.qq.com/icon/mall/makeup/5_select.png");
        bp bpVar3 = this.binding;
        if (bpVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bpVar3 = null;
        }
        pairArr[2] = TuplesKt.to(bpVar3.f418880f, "https://image.superqqshow.qq.com/icon/mall/makeup/6_select.png");
        bp bpVar4 = this.binding;
        if (bpVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bpVar4 = null;
        }
        pairArr[3] = TuplesKt.to(bpVar4.f418883i, "https://image.superqqshow.qq.com/icon/mall/makeup/11_select.png");
        bp bpVar5 = this.binding;
        if (bpVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bpVar5 = null;
        }
        pairArr[4] = TuplesKt.to(bpVar5.f418884j, "https://image.superqqshow.qq.com/icon/mall/makeup/10_select.png");
        mapOf = MapsKt__MapsKt.mapOf(pairArr);
        this.selectedImageUrls = mapOf;
        bp bpVar6 = this.binding;
        if (bpVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bpVar6 = null;
        }
        RelativeLayout relativeLayout = bpVar6.f418879e;
        IFilamentNativeAppV2305 iFilamentNativeAppV2305 = this.nativeApp;
        if (iFilamentNativeAppV2305 != null && (view = iFilamentNativeAppV2305.getView()) != null) {
            relativeLayout.addView(view, 0, new RelativeLayout.LayoutParams(-1, -1));
            QLog.i(this.TAG, 1, "add textureView");
        }
        bp bpVar7 = this.binding;
        if (bpVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bpVar7 = null;
        }
        bpVar7.f418879e.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.sqshow.zootopia.nativeui.view.customerface.h
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                boolean Th;
                Th = ZPlanPinchFaceFragment.Th(ZPlanPinchFaceFragment.this, view2, motionEvent);
                return Th;
            }
        });
        bp bpVar8 = this.binding;
        if (bpVar8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bpVar8 = null;
        }
        ImageView imageView = bpVar8.f418893s;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.titleBackButton");
        aa.d(imageView, new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.nativeui.view.customerface.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ZPlanPinchFaceFragment.Uh(ZPlanPinchFaceFragment.this, view2);
            }
        });
        bp bpVar9 = this.binding;
        if (bpVar9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bpVar9 = null;
        }
        ImageView imageView2 = bpVar9.f418876b;
        Intrinsics.checkNotNullExpressionValue(imageView2, "binding.lastIgv");
        aa.d(imageView2, new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.nativeui.view.customerface.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ZPlanPinchFaceFragment.Vh(ZPlanPinchFaceFragment.this, view2);
            }
        });
        bp bpVar10 = this.binding;
        if (bpVar10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bpVar10 = null;
        }
        ImageView imageView3 = bpVar10.f418877c;
        Intrinsics.checkNotNullExpressionValue(imageView3, "binding.nextIgv");
        aa.d(imageView3, new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.nativeui.view.customerface.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ZPlanPinchFaceFragment.Wh(ZPlanPinchFaceFragment.this, view2);
            }
        });
        bp bpVar11 = this.binding;
        if (bpVar11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bpVar11 = null;
        }
        LinearLayout linearLayout = bpVar11.f418886l;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.side1");
        aa.d(linearLayout, new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.nativeui.view.customerface.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ZPlanPinchFaceFragment.Xh(ZPlanPinchFaceFragment.this, view2);
            }
        });
        bp bpVar12 = this.binding;
        if (bpVar12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bpVar12 = null;
        }
        LinearLayout linearLayout2 = bpVar12.f418888n;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.side2");
        aa.d(linearLayout2, new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.nativeui.view.customerface.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ZPlanPinchFaceFragment.Yh(ZPlanPinchFaceFragment.this, view2);
            }
        });
        bp bpVar13 = this.binding;
        if (bpVar13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bpVar13 = null;
        }
        TextView textView = bpVar13.f418885k;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.saveBtn");
        aa.d(textView, new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.nativeui.view.customerface.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ZPlanPinchFaceFragment.Nh(ZPlanPinchFaceFragment.this, view2);
            }
        });
        Map<URLImageView, String> map = this.selectedImageUrls;
        if (map == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectedImageUrls");
            map = null;
        }
        bp bpVar14 = this.binding;
        if (bpVar14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bpVar14 = null;
        }
        String str = map.get(bpVar14.f418882h);
        if (str != null) {
            bp bpVar15 = this.binding;
            if (bpVar15 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                bpVar15 = null;
            }
            URLImageView uRLImageView = bpVar15.f418882h;
            Intrinsics.checkNotNullExpressionValue(uRLImageView, "binding.pinchFaceFaceIcon");
            gi(uRLImageView, str);
        }
        bp bpVar16 = this.binding;
        if (bpVar16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bpVar16 = null;
        }
        URLImageView uRLImageView2 = bpVar16.f418882h;
        Intrinsics.checkNotNullExpressionValue(uRLImageView2, "binding.pinchFaceFaceIcon");
        aa.d(uRLImageView2, new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.nativeui.view.customerface.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ZPlanPinchFaceFragment.Oh(ZPlanPinchFaceFragment.this, view2);
            }
        });
        bp bpVar17 = this.binding;
        if (bpVar17 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bpVar17 = null;
        }
        URLImageView uRLImageView3 = bpVar17.f418881g;
        Intrinsics.checkNotNullExpressionValue(uRLImageView3, "binding.pinchFaceEyebrowIcon");
        aa.d(uRLImageView3, new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.nativeui.view.customerface.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ZPlanPinchFaceFragment.Ph(ZPlanPinchFaceFragment.this, view2);
            }
        });
        bp bpVar18 = this.binding;
        if (bpVar18 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bpVar18 = null;
        }
        URLImageView uRLImageView4 = bpVar18.f418880f;
        Intrinsics.checkNotNullExpressionValue(uRLImageView4, "binding.pinchFaceEyeIcon");
        aa.d(uRLImageView4, new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.nativeui.view.customerface.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ZPlanPinchFaceFragment.Qh(ZPlanPinchFaceFragment.this, view2);
            }
        });
        bp bpVar19 = this.binding;
        if (bpVar19 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bpVar19 = null;
        }
        URLImageView uRLImageView5 = bpVar19.f418883i;
        Intrinsics.checkNotNullExpressionValue(uRLImageView5, "binding.pinchFaceMouthIcon");
        aa.d(uRLImageView5, new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.nativeui.view.customerface.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ZPlanPinchFaceFragment.Rh(ZPlanPinchFaceFragment.this, view2);
            }
        });
        bp bpVar20 = this.binding;
        if (bpVar20 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bpVar20 = null;
        }
        URLImageView uRLImageView6 = bpVar20.f418884j;
        Intrinsics.checkNotNullExpressionValue(uRLImageView6, "binding.pinchFaceNoseIcon");
        aa.d(uRLImageView6, new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.nativeui.view.customerface.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ZPlanPinchFaceFragment.Sh(ZPlanPinchFaceFragment.this, view2);
            }
        });
        bp bpVar21 = this.binding;
        if (bpVar21 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            bpVar = bpVar21;
        }
        return bpVar.getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        IFilamentNativeAppV2305 iFilamentNativeAppV2305 = this.nativeApp;
        if (iFilamentNativeAppV2305 != null) {
            iFilamentNativeAppV2305.unregister(tk0.c.f436439a.a(Reflection.getOrCreateKotlinClass(PinchFaceScene.a.class)), this.cEvents);
        }
        QLog.i(this.TAG, 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        IFilamentNativeAppV2305 iFilamentNativeAppV23052 = this.nativeApp;
        if (iFilamentNativeAppV23052 != null) {
            iFilamentNativeAppV23052.destroy();
        }
        this.nativeApp = null;
        try {
            Context context = getContext();
            if (context != null) {
                context.unregisterReceiver(this.broadcastReceiver);
            }
        } catch (Throwable th5) {
            QLog.e(this.TAG, 1, "destroy, unregisterReceiver failed.", th5);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        QLog.i(this.TAG, 1, "onDestroyView");
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        QLog.i(this.TAG, 1, MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
        IFilamentNativeAppV2305 iFilamentNativeAppV2305 = this.nativeApp;
        if (iFilamentNativeAppV2305 != null) {
            iFilamentNativeAppV2305.pause();
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setRequestedOrientation(-1);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        QLog.i(this.TAG, 1, "onResume");
        IFilamentNativeAppV2305 iFilamentNativeAppV2305 = this.nativeApp;
        if (iFilamentNativeAppV2305 != null) {
            iFilamentNativeAppV2305.resume();
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setRequestedOrientation(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void gi(URLImageView selectedImageView, String selectedImageUrl) {
        Map mapOf;
        Pair[] pairArr = new Pair[5];
        bp bpVar = this.binding;
        bp bpVar2 = null;
        if (bpVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bpVar = null;
        }
        pairArr[0] = TuplesKt.to(bpVar.f418882h, "https://image.superqqshow.qq.com/icon/mall/makeup/4.png");
        bp bpVar3 = this.binding;
        if (bpVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bpVar3 = null;
        }
        pairArr[1] = TuplesKt.to(bpVar3.f418881g, "https://image.superqqshow.qq.com/icon/mall/makeup/5.png");
        bp bpVar4 = this.binding;
        if (bpVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bpVar4 = null;
        }
        pairArr[2] = TuplesKt.to(bpVar4.f418880f, "https://image.superqqshow.qq.com/icon/mall/makeup/6.png");
        bp bpVar5 = this.binding;
        if (bpVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bpVar5 = null;
        }
        pairArr[3] = TuplesKt.to(bpVar5.f418883i, "https://image.superqqshow.qq.com/icon/mall/makeup/11.png");
        bp bpVar6 = this.binding;
        if (bpVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            bpVar2 = bpVar6;
        }
        pairArr[4] = TuplesKt.to(bpVar2.f418884j, "https://image.superqqshow.qq.com/icon/mall/makeup/10.png");
        mapOf = MapsKt__MapsKt.mapOf(pairArr);
        for (Map.Entry entry : mapOf.entrySet()) {
            URLImageView imageView = (URLImageView) entry.getKey();
            String str = (String) entry.getValue();
            Intrinsics.checkNotNullExpressionValue(imageView, "imageView");
            CommonExKt.w(imageView, str, null, null, 6, null);
        }
        CommonExKt.w(selectedImageView, selectedImageUrl, null, null, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ki(PinchFaceEvent$PinchFaceUiInfo uiInfo) {
        if (uiInfo == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new ZPlanPinchFaceFragment$showUiInfo$1(this, uiInfo, null), 3, null);
    }
}
