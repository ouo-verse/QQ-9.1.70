package com.tencent.qqnt.qwallet.grab;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.StringRes;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ark.ark;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.event.AIOMsgSendEvent;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.base.FragmentAnimation;
import com.tencent.mobileqq.base.QWalletBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.forward.ForwardMiniChooseFriendOption;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.annotation.QQPermissionConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.IQWalletNickNameApi;
import com.tencent.mobileqq.qwallet.api.IQWalletUnitedConfigApi;
import com.tencent.mobileqq.qwallet.hb.grap.RecordMicView;
import com.tencent.mobileqq.qwallet.k;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqnt.qwallet.aio.AIOContextHolder;
import com.tencent.util.LoadingUtil;
import com.tenpay.anim.GrabHbViewAnimator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rx3.f;
import sk2.QWalletHbCommonConfig;

/* compiled from: P */
@QQPermissionConfig(id = QQPermissionConstants.Business.ID.QQ_QWALLET, scene = QQPermissionConstants.Business.SCENE.QWALLET_START_VOICE_RECORD)
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\n*\u0002V^\b\u0007\u0018\u0000 d2\u00020\u0001:\u0002efB\u0007\u00a2\u0006\u0004\bb\u0010cJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\u0012\u0010\r\u001a\u00020\u00042\b\b\u0001\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J\b\u0010\u0011\u001a\u00020\u0004H\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0016J&\u0010\u001b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J\u001a\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J\u0012\u0010\u001d\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001e\u001a\u00020\u0004H\u0016R\u0016\u0010!\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010 R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010-\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010*R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00103\u001a\u00020.8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00100R\u0016\u00105\u001a\u00020.8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u00100R\u0016\u00107\u001a\u00020.8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b6\u00100R\u0016\u00109\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b8\u0010*R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u001b\u0010C\u001a\u00020>8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010BR#\u0010I\u001a\n E*\u0004\u0018\u00010D0D8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bF\u0010@\u001a\u0004\bG\u0010HR\u0018\u0010M\u001a\u0004\u0018\u00010J8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0014\u0010Q\u001a\u00020N8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010U\u001a\u0004\u0018\u00010R8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bS\u0010TR\u0014\u0010Y\u001a\u00020V8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bW\u0010XR\u0014\u0010]\u001a\u00020Z8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b[\u0010\\R\u0014\u0010a\u001a\u00020^8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b_\u0010`\u00a8\u0006g"}, d2 = {"Lcom/tencent/qqnt/qwallet/grab/GrabVoiceHbFragment;", "Lcom/tencent/mobileqq/base/QWalletBaseFragment;", "Landroid/view/View;", "view", "", "initView", "Mh", "initData", "Fh", "Hh", "Nh", "", "errResId", "Kh", "", "Ch", "showLoadingDialog", "Lh", "Oh", "Lcom/tencent/mobileqq/base/FragmentAnimation;", "getFragmentAnimation", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreateView", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", "backMask", "D", "hbLayout", "Landroid/widget/ImageButton;", "E", "Landroid/widget/ImageButton;", "closeBtn", "Landroid/widget/ImageView;", UserInfo.SEX_FEMALE, "Landroid/widget/ImageView;", "hbTopBg", "G", "hbBottomBg", "Landroid/widget/TextView;", "H", "Landroid/widget/TextView;", "detailTxt", "I", "tipsText", "J", "pwdTitle", "K", QQWinkConstants.TAB_SUBTITLE, "L", "recordingLottie", "Lcom/tencent/mobileqq/qwallet/hb/grap/RecordMicView;", "M", "Lcom/tencent/mobileqq/qwallet/hb/grap/RecordMicView;", "recordBtn", "Lcom/tencent/qqnt/qwallet/grab/GrabVoiceHbViewModel;", "N", "Lkotlin/Lazy;", "Eh", "()Lcom/tencent/qqnt/qwallet/grab/GrabVoiceHbViewModel;", "viewModel", "Lcom/tencent/mobileqq/qqpermission/QQPermission;", "kotlin.jvm.PlatformType", "P", "Dh", "()Lcom/tencent/mobileqq/qqpermission/QQPermission;", "qqPermission", "Landroid/app/Dialog;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/app/Dialog;", "loadingDialog", "Ljava/util/concurrent/atomic/AtomicBoolean;", BdhLogUtil.LogTag.Tag_Req, "Ljava/util/concurrent/atomic/AtomicBoolean;", "isRegistered", "", ExifInterface.LATITUDE_SOUTH, "Ljava/lang/String;", "msgSendType", "com/tencent/qqnt/qwallet/grab/GrabVoiceHbFragment$c", "T", "Lcom/tencent/qqnt/qwallet/grab/GrabVoiceHbFragment$c;", "msgSendAction", "Ljava/lang/Runnable;", "U", "Ljava/lang/Runnable;", "grabVoiceHbTimeOut", "com/tencent/qqnt/qwallet/grab/GrabVoiceHbFragment$d", "V", "Lcom/tencent/qqnt/qwallet/grab/GrabVoiceHbFragment$d;", "recordStatusListener", "<init>", "()V", "W", "a", "EnumRecordStatus", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class GrabVoiceHbFragment extends QWalletBaseFragment {

    @NotNull
    private static final String[] X = {QQPermissionConstants.Permission.RECORD_AUDIO};

    /* renamed from: C, reason: from kotlin metadata */
    private View backMask;

    /* renamed from: D, reason: from kotlin metadata */
    private View hbLayout;

    /* renamed from: E, reason: from kotlin metadata */
    private ImageButton closeBtn;

    /* renamed from: F, reason: from kotlin metadata */
    private ImageView hbTopBg;

    /* renamed from: G, reason: from kotlin metadata */
    private ImageView hbBottomBg;

    /* renamed from: H, reason: from kotlin metadata */
    private TextView detailTxt;

    /* renamed from: I, reason: from kotlin metadata */
    private TextView tipsText;

    /* renamed from: J, reason: from kotlin metadata */
    private TextView pwdTitle;

    /* renamed from: K, reason: from kotlin metadata */
    private TextView subTitle;

    /* renamed from: L, reason: from kotlin metadata */
    private ImageView recordingLottie;

    /* renamed from: M, reason: from kotlin metadata */
    private RecordMicView recordBtn;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(GrabVoiceHbViewModel.class), new Function0<ViewModelStore>() { // from class: com.tencent.qqnt.qwallet.grab.GrabVoiceHbFragment$special$$inlined$activityViewModels$default$1
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final ViewModelStore invoke() {
            FragmentActivity requireActivity = Fragment.this.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            ViewModelStore viewModelStore = requireActivity.getViewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }, new Function0<ViewModelProvider.Factory>() { // from class: com.tencent.qqnt.qwallet.grab.GrabVoiceHbFragment$special$$inlined$activityViewModels$default$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final ViewModelProvider.Factory invoke() {
            FragmentActivity requireActivity = Fragment.this.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            return requireActivity.getDefaultViewModelProviderFactory();
        }
    });

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final Lazy qqPermission;

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private Dialog loadingDialog;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final AtomicBoolean isRegistered;

    /* renamed from: S, reason: from kotlin metadata */
    @Nullable
    private final String msgSendType;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final c msgSendAction;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private final Runnable grabVoiceHbTimeOut;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private final d recordStatusListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/qqnt/qwallet/grab/GrabVoiceHbFragment$EnumRecordStatus;", "", "(Ljava/lang/String;I)V", "STATUS_INIT", "STATUS_CANCEL", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public enum EnumRecordStatus {
        STATUS_INIT,
        STATUS_CANCEL
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\b\u001a\u00020\u00072\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/qqnt/qwallet/grab/GrabVoiceHbFragment$b", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "", "permissions", "", ForwardMiniChooseFriendOption.RESULT_LIST, "", "onDeniedWithoutShowDlg", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b extends QQPermission.BasePermissionsListener {
        b() {
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDeniedWithoutShowDlg(@Nullable List<String> permissions, @Nullable List<Integer> results) {
            super.onDeniedWithoutShowDlg(permissions, results);
            QQToast.makeText(GrabVoiceHbFragment.this.getContext(), R.string.f17677326, 1).show();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/qwallet/grab/GrabVoiceHbFragment$c", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class c implements com.tencent.mvi.base.route.a {
        c() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            Long l3;
            Intrinsics.checkNotNullParameter(i3, "i");
            if (i3 instanceof AIOMsgSendEvent.OnMsgSendSuccessEvent) {
                long b16 = ((AIOMsgSendEvent.OnMsgSendSuccessEvent) i3).b();
                QLog.i("GrabVoiceHbFragment", 1, "onMsgSendSuccessEvent successMsgId = " + b16);
                AIOMsgSendEvent.PttSendEvent sendVoiceIntent = GrabVoiceHbFragment.this.Eh().getSendVoiceIntent();
                if (sendVoiceIntent != null) {
                    l3 = sendVoiceIntent.d();
                } else {
                    l3 = null;
                }
                if (l3 != null && l3.longValue() == b16) {
                    ThreadManagerV2.getUIHandlerV2().removeCallbacks(GrabVoiceHbFragment.this.grabVoiceHbTimeOut);
                    GrabVoiceHbFragment.this.Fh();
                }
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/qqnt/qwallet/grab/GrabVoiceHbFragment$d", "Lcom/tencent/mobileqq/qwallet/hb/grap/RecordMicView$a;", "", "a", "onEnd", "onCancel", "b", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class d implements RecordMicView.a {
        d() {
        }

        @Override // com.tencent.mobileqq.qwallet.hb.grap.RecordMicView.a
        public void a() {
            if (GrabVoiceHbFragment.this.Ch()) {
                GrabVoiceHbFragment.this.Nh();
            } else {
                QLog.d("GrabVoiceHbFragment", 1, "onBegin: record permission has not granted");
            }
        }

        @Override // com.tencent.mobileqq.qwallet.hb.grap.RecordMicView.a
        public void b() {
            GrabVoiceHbFragment.this.Kh(R.string.d88);
        }

        @Override // com.tencent.mobileqq.qwallet.hb.grap.RecordMicView.a
        public void onCancel() {
            GrabVoiceHbFragment.this.Kh(R.string.d87);
        }

        @Override // com.tencent.mobileqq.qwallet.hb.grap.RecordMicView.a
        public void onEnd() {
            TextView textView = GrabVoiceHbFragment.this.tipsText;
            ImageView imageView = null;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tipsText");
                textView = null;
            }
            textView.setText(GrabVoiceHbFragment.this.getResources().getString(R.string.d8_));
            f fVar = f.f432901a;
            ImageView imageView2 = GrabVoiceHbFragment.this.recordingLottie;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recordingLottie");
            } else {
                imageView = imageView2;
            }
            fVar.f(imageView);
            GrabVoiceHbFragment.this.Eh().n2();
        }
    }

    public GrabVoiceHbFragment() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QQPermission>() { // from class: com.tencent.qqnt.qwallet.grab.GrabVoiceHbFragment$qqPermission$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final QQPermission invoke() {
                return QQPermissionFactory.getQQPermission(GrabVoiceHbFragment.this);
            }
        });
        this.qqPermission = lazy;
        this.isRegistered = new AtomicBoolean(false);
        this.msgSendType = Reflection.getOrCreateKotlinClass(AIOMsgSendEvent.OnMsgSendSuccessEvent.class).getQualifiedName();
        this.msgSendAction = new c();
        this.grabVoiceHbTimeOut = new Runnable() { // from class: com.tencent.qqnt.qwallet.grab.c
            @Override // java.lang.Runnable
            public final void run() {
                GrabVoiceHbFragment.Gh(GrabVoiceHbFragment.this);
            }
        };
        this.recordStatusListener = new d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean Ch() {
        if (Dh().hasPermission(QQPermissionConstants.Permission.RECORD_AUDIO) == 0) {
            return true;
        }
        Dh().requestPermissions(X, 2, new b());
        return false;
    }

    private final QQPermission Dh() {
        return (QQPermission) this.qqPermission.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GrabVoiceHbViewModel Eh() {
        return (GrabVoiceHbViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Fh() {
        RouteUtils.startActivity(getContext(), Eh().X1(), RouterConstants.UI_ROUTER_PAY_BRIDGE);
        Oh();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Gh(GrabVoiceHbFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        boolean z16 = false;
        if (activity != null && !activity.isFinishing()) {
            z16 = true;
        }
        if (z16) {
            QLog.i("GrabVoiceHbFragment", 1, "Recorder Success grab voice hb time out");
            this$0.Fh();
        }
    }

    private final void Hh() {
        View view = this.hbLayout;
        RecordMicView recordMicView = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hbLayout");
            view = null;
        }
        view.setContentDescription(getResources().getString(R.string.f17676325, Eh().getCommand(), getResources().getString(R.string.d87)));
        RecordMicView recordMicView2 = this.recordBtn;
        if (recordMicView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recordBtn");
        } else {
            recordMicView = recordMicView2;
        }
        AccessibilityUtil.c(recordMicView, getResources().getString(R.string.f17675324), View.class.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ih(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Jh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Kh(@StringRes int errResId) {
        if (isFinishing()) {
            return;
        }
        TextView textView = this.tipsText;
        ImageView imageView = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tipsText");
            textView = null;
        }
        textView.setText(errResId);
        Eh().d2().setValue(EnumRecordStatus.STATUS_CANCEL);
        Eh().n2();
        RecordMicView recordMicView = this.recordBtn;
        if (recordMicView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recordBtn");
            recordMicView = null;
        }
        recordMicView.b();
        f fVar = f.f432901a;
        ImageView imageView2 = this.recordingLottie;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recordingLottie");
            imageView2 = null;
        }
        fVar.f(imageView2);
        ImageView imageView3 = this.recordingLottie;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recordingLottie");
        } else {
            imageView = imageView3;
        }
        imageView.setVisibility(8);
    }

    private final void Lh() {
        QLog.d("GrabVoiceHbFragment", 4, "register: isRegistered " + this.isRegistered.get());
        if (this.isRegistered.compareAndSet(false, true)) {
            AIOContextHolder.f361707d.b(this.msgSendType, this.msgSendAction);
        }
    }

    private final void Mh() {
        View view = this.hbLayout;
        ImageButton imageButton = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hbLayout");
            view = null;
        }
        if (view.getVisibility() != 0) {
            View view2 = this.hbLayout;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("hbLayout");
                view2 = null;
            }
            view2.setVisibility(0);
            View view3 = this.hbLayout;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("hbLayout");
                view3 = null;
            }
            ImageButton imageButton2 = this.closeBtn;
            if (imageButton2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("closeBtn");
            } else {
                imageButton = imageButton2;
            }
            new GrabHbViewAnimator(view3, imageButton).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Nh() {
        Pair<Boolean, Integer> S1 = Eh().S1();
        if (!S1.getFirst().booleanValue()) {
            Kh(S1.getSecond().intValue());
            return;
        }
        Context context = getContext();
        if (context == null) {
            return;
        }
        TextView textView = this.tipsText;
        ImageView imageView = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tipsText");
            textView = null;
        }
        textView.setText(getResources().getString(R.string.d89));
        f fVar = f.f432901a;
        ImageView imageView2 = this.recordingLottie;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recordingLottie");
            imageView2 = null;
        }
        fVar.c(context, imageView2, "qvip_pay_wallet_voice_recording.json");
        ImageView imageView3 = this.recordingLottie;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recordingLottie");
        } else {
            imageView = imageView3;
        }
        imageView.setVisibility(0);
        Eh().m2(context);
    }

    private final void Oh() {
        QLog.d("GrabVoiceHbFragment", 4, "unregister: isRegistered " + this.isRegistered.get());
        if (this.isRegistered.compareAndSet(true, false)) {
            AIOContextHolder.f361707d.e(this.msgSendType, this.msgSendAction);
        }
    }

    private final void initData() {
        TextView textView;
        TextView textView2 = this.pwdTitle;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pwdTitle");
            textView2 = null;
        }
        textView2.setText(Eh().getCommand());
        ((IQWalletNickNameApi) QRoute.api(IQWalletNickNameApi.class)).getNickName(Eh().getGroupId(), Eh().getSenderUin(), new GrabVoiceHbFragment$initData$1(this));
        TextView textView3 = this.tipsText;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tipsText");
            textView3 = null;
        }
        textView3.setText(getResources().getString(R.string.d87));
        RecordMicView recordMicView = this.recordBtn;
        if (recordMicView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recordBtn");
            recordMicView = null;
        }
        recordMicView.setRecordTime(Eh().getRecordDurationMillis());
        RecordMicView recordMicView2 = this.recordBtn;
        if (recordMicView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recordBtn");
            recordMicView2 = null;
        }
        recordMicView2.setStatusListener(this.recordStatusListener);
        if (Eh().getIsSelfSend()) {
            TextView textView4 = this.detailTxt;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("detailTxt");
                textView4 = null;
            }
            textView4.setVisibility(0);
            TextView textView5 = this.detailTxt;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("detailTxt");
                textView = null;
            } else {
                textView = textView5;
            }
            k.d(textView, 0L, new Function0<Unit>() { // from class: com.tencent.qqnt.qwallet.grab.GrabVoiceHbFragment$initData$2
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
                    if (GrabVoiceHbFragment.this.Eh().getToDetailJson().length() == 0) {
                        return;
                    }
                    Intent intent = new Intent();
                    intent.putExtra(ark.ARKMETADATA_JSON, GrabVoiceHbFragment.this.Eh().getToDetailJson());
                    intent.putExtra("callbackSn", "0");
                    intent.putExtra("pay_requestcode", 5);
                    RouteUtils.startActivity(GrabVoiceHbFragment.this.getContext(), intent, RouterConstants.UI_ROUTER_PAY_BRIDGE);
                }
            }, 1, null);
        }
        MutableLiveData<Integer> W1 = Eh().W1();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Integer, Unit> function1 = new Function1<Integer, Unit>() { // from class: com.tencent.qqnt.qwallet.grab.GrabVoiceHbFragment$initData$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer it) {
                GrabVoiceHbFragment grabVoiceHbFragment = GrabVoiceHbFragment.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                grabVoiceHbFragment.Kh(it.intValue());
            }
        };
        W1.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.qqnt.qwallet.grab.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GrabVoiceHbFragment.Ih(Function1.this, obj);
            }
        });
        MutableLiveData<Integer> b26 = Eh().b2();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<Integer, Unit> function12 = new Function1<Integer, Unit>() { // from class: com.tencent.qqnt.qwallet.grab.GrabVoiceHbFragment$initData$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer num) {
                if (num != null && num.intValue() == 1) {
                    TextView textView6 = GrabVoiceHbFragment.this.tipsText;
                    if (textView6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("tipsText");
                        textView6 = null;
                    }
                    textView6.setText(R.string.sxt);
                    AIOMsgSendEvent.PttSendEvent sendVoiceIntent = GrabVoiceHbFragment.this.Eh().getSendVoiceIntent();
                    if (sendVoiceIntent != null) {
                        AIOContextHolder.f361707d.c(sendVoiceIntent);
                    }
                    QWalletHbCommonConfig qWalletHbCommonConfig = (QWalletHbCommonConfig) ((IQWalletUnitedConfigApi) QRoute.api(IQWalletUnitedConfigApi.class)).getConfig(IQWalletUnitedConfigApi.QWALLET_HB_COMMON_CONFIG, new QWalletHbCommonConfig(null, null, false, false, 15, null));
                    if (GrabVoiceHbFragment.this.Eh().getGroupType() == 0 && !qWalletHbCommonConfig.getGrabVoiceHbNow()) {
                        QLog.i("GrabVoiceHbFragment", 1, "Recorder Success grab voice hb not now");
                        GrabVoiceHbFragment.this.showLoadingDialog();
                        ThreadManagerV2.getUIHandlerV2().postDelayed(GrabVoiceHbFragment.this.grabVoiceHbTimeOut, 3000L);
                        return;
                    } else {
                        QLog.i("GrabVoiceHbFragment", 1, "Recorder Success grab voice hb now");
                        GrabVoiceHbFragment.this.Fh();
                        return;
                    }
                }
                GrabVoiceHbFragment.this.Kh(R.string.d8a);
            }
        };
        b26.observe(viewLifecycleOwner2, new Observer() { // from class: com.tencent.qqnt.qwallet.grab.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GrabVoiceHbFragment.Jh(Function1.this, obj);
            }
        });
    }

    private final void initView(View view) {
        View view2;
        ImageButton imageButton;
        View findViewById = view.findViewById(R.id.f67383d7);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(com.te\u2026i.R.id.qwallet_hb_layout)");
        this.hbLayout = findViewById;
        View findViewById2 = view.findViewById(R.id.f67333d2);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(com.te\u2026.id.qwallet_hb_back_mask)");
        this.backMask = findViewById2;
        View findViewById3 = view.findViewById(R.id.f67353d4);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(com.te\u2026.id.qwallet_hb_close_btn)");
        this.closeBtn = (ImageButton) findViewById3;
        View findViewById4 = view.findViewById(R.id.f67503di);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.qwallet_hb_top_bg)");
        this.hbTopBg = (ImageView) findViewById4;
        View findViewById5 = view.findViewById(R.id.f67343d3);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.qwallet_hb_bottom_bg)");
        this.hbBottomBg = (ImageView) findViewById5;
        View findViewById6 = view.findViewById(R.id.f67363d5);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "view.findViewById(com.te\u2026i.R.id.qwallet_hb_detail)");
        this.detailTxt = (TextView) findViewById6;
        View findViewById7 = view.findViewById(R.id.jnh);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "view.findViewById(com.te\u2026q.qqpay.ui.R.id.tips_txt)");
        this.tipsText = (TextView) findViewById7;
        View findViewById8 = view.findViewById(R.id.i3o);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "view.findViewById(com.te\u2026.qqpay.ui.R.id.recordBtn)");
        this.recordBtn = (RecordMicView) findViewById8;
        View findViewById9 = view.findViewById(R.id.g6_);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "view.findViewById(com.te\u2026.qqpay.ui.R.id.pwd_title)");
        this.pwdTitle = (TextView) findViewById9;
        View findViewById10 = view.findViewById(R.id.f67483dg);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "view.findViewById(R.id.qwallet_hb_sub_title)");
        this.subTitle = (TextView) findViewById10;
        View findViewById11 = view.findViewById(R.id.f1201078n);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "view.findViewById(com.te\u2026d.voice_recording_lottie)");
        this.recordingLottie = (ImageView) findViewById11;
        View view3 = this.hbLayout;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hbLayout");
            view3 = null;
        }
        k.b(view3, ViewUtils.dpToPx(13.5f));
        View view4 = this.backMask;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backMask");
            view2 = null;
        } else {
            view2 = view4;
        }
        k.d(view2, 0L, new Function0<Unit>() { // from class: com.tencent.qqnt.qwallet.grab.GrabVoiceHbFragment$initView$1
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
                GrabVoiceHbFragment.this.finish();
            }
        }, 1, null);
        ImageButton imageButton2 = this.closeBtn;
        if (imageButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closeBtn");
            imageButton = null;
        } else {
            imageButton = imageButton2;
        }
        k.d(imageButton, 0L, new Function0<Unit>() { // from class: com.tencent.qqnt.qwallet.grab.GrabVoiceHbFragment$initView$2
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
                GrabVoiceHbFragment.this.finish();
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showLoadingDialog() {
        Dialog dialog = this.loadingDialog;
        if (dialog == null) {
            dialog = LoadingUtil.showLoadingDialog(getContext(), "\u52a0\u8f7d\u4e2d", false);
            Window window = dialog.getWindow();
            if (window != null) {
                window.setDimAmount(0.0f);
            }
            this.loadingDialog = dialog;
            Intrinsics.checkNotNullExpressionValue(dialog, "showLoadingDialog(contex\u2026ngDialog = this\n        }");
        }
        if (!dialog.isShowing()) {
            dialog.show();
        }
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment
    @NotNull
    public FragmentAnimation getFragmentAnimation() {
        return FragmentAnimation.NONE;
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Lh();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.hj_, container, false);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Oh();
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        Mh();
        initData();
        Hh();
    }
}
