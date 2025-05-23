package com.tencent.mobileqq.wink.aieliminate;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.airbnb.lottie.LottieAnimationView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.richframework.part.ImmersivePartFragment;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vas.api.IVasYellowDiamondPay;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.aieliminate.AIEliminateHomeFragment;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.editor.aielimination.WinkAiEliminationViewModel;
import com.tencent.mobileqq.wink.editor.aielimination.model.AIEliminationButtonStatus;
import com.tencent.mobileqq.wink.picker.Config;
import com.tencent.mobileqq.wink.picker.TabType;
import com.tencent.mobileqq.wink.picker.f;
import com.tencent.mobileqq.wink.report.WinkHomeReportHelper;
import com.tencent.mobileqq.wink.view.QCircleCommonLoadingDialog;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qzonehub.api.IQZoneApiProxy;
import com.tencent.videocut.utils.e;
import cooperation.qzone.QzoneIPCModule;
import cooperation.qzone.report.lp.QZoneLoginReportHelper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 q2\u00020\u00012\u00020\u0002:\u0001rB\u0007\u00a2\u0006\u0004\bo\u0010pJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0003H\u0002J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J2\u0010\u0016\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0012\u001a\u00020\u00112\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013H\u0002J\b\u0010\u0017\u001a\u00020\u0005H\u0002J\b\u0010\u0018\u001a\u00020\u0005H\u0002J\b\u0010\u0019\u001a\u00020\u0005H\u0002J\u0012\u0010\u001c\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\u001a\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001f\u001a\u00020\u001eH\u0014J\b\u0010 \u001a\u00020\u0005H\u0016J\u000e\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0!H\u0016J\b\u0010$\u001a\u00020\u000eH\u0014J\u0006\u0010%\u001a\u00020\u0011J\b\u0010&\u001a\u00020\u000eH\u0014J\u0012\u0010(\u001a\u00020\u00052\b\u0010'\u001a\u0004\u0018\u00010\u0003H\u0016J\"\u0010-\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020\u000e2\b\u0010,\u001a\u0004\u0018\u00010+H\u0016J\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00140\u0013J\u0006\u0010/\u001a\u00020\u0005R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0018\u00107\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010;\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010=\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u00106R\u0018\u0010?\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u00106R\u0018\u0010A\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010:R\u0016\u0010E\u001a\u00020B8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010G\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bF\u00102R\u0016\u0010I\u001a\u0002088\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bH\u0010:R\u0016\u0010K\u001a\u0002088\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bJ\u0010:R\u0016\u0010M\u001a\u0002048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bL\u00106R\u0016\u0010O\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bN\u00102R\u0014\u0010S\u001a\u00020P8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u001c\u0010W\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0T8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bU\u0010VR\u001f\u0010]\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0X8\u0006\u00a2\u0006\f\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\R\u0016\u0010`\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010_R\u0016\u0010c\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\ba\u0010bR\u0016\u0010g\u001a\u00020d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\be\u0010fR#\u0010n\u001a\n i*\u0004\u0018\u00010h0h8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bj\u0010k\u001a\u0004\bl\u0010m\u00a8\u0006s"}, d2 = {"Lcom/tencent/mobileqq/wink/aieliminate/AIEliminateHomeFragment;", "Lcom/tencent/biz/richframework/part/ImmersivePartFragment;", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", "view", "", "initViews", "Lh", "Ih", "Lcom/tencent/mobileqq/wink/editor/aielimination/model/c;", "info", "Hh", "contentView", "registerDaTongReportPageId", "", "paySource", "Gh", "", "elementId", "", "", QQBrowserActivity.APP_PARAM, OcrConfig.CHINESE, "Fh", "Eh", "Mh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "isUseDarkTextStatusBar", "onResume", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "getContentLayoutId", "getPageId", "getStatusBarColor", "v", NodeProps.ON_CLICK, "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "Dh", "yh", "Landroid/widget/LinearLayout;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/LinearLayout;", "buttonView", "Landroid/widget/ImageView;", "D", "Landroid/widget/ImageView;", "buttonViewIcon", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "buttonViewTextView", UserInfo.SEX_FEMALE, "backImageIcon", "G", "shareImageIcon", "H", "eliminateTimesText", "Lcom/airbnb/lottie/LottieAnimationView;", "I", "Lcom/airbnb/lottie/LottieAnimationView;", "posterImage", "J", "posterLayout", "K", "payGuideYellowText", "L", "payGuideBlackTextRight", "M", "yellowDiamondIcon", "N", "diamondLayout", "Lkotlinx/coroutines/CoroutineScope;", "P", "Lkotlinx/coroutines/CoroutineScope;", "viewModelScope", "Lkotlinx/coroutines/flow/MutableStateFlow;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lkotlinx/coroutines/flow/MutableStateFlow;", "_countInfo", "Lkotlinx/coroutines/flow/StateFlow;", BdhLogUtil.LogTag.Tag_Req, "Lkotlinx/coroutines/flow/StateFlow;", "Bh", "()Lkotlinx/coroutines/flow/StateFlow;", "countInfo", ExifInterface.LATITUDE_SOUTH, "Ljava/lang/String;", "source", "T", "Z", "defaultPoster", "Lcom/tencent/mobileqq/wink/view/QCircleCommonLoadingDialog;", "U", "Lcom/tencent/mobileqq/wink/view/QCircleCommonLoadingDialog;", "shareDialog", "Lcom/tencent/mobileqq/wink/editor/aielimination/WinkAiEliminationViewModel;", "kotlin.jvm.PlatformType", "V", "Lkotlin/Lazy;", "Ch", "()Lcom/tencent/mobileqq/wink/editor/aielimination/WinkAiEliminationViewModel;", "eliminationViewModel", "<init>", "()V", "W", "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class AIEliminateHomeFragment extends ImmersivePartFragment implements View.OnClickListener {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private LinearLayout buttonView;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private ImageView buttonViewIcon;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private TextView buttonViewTextView;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private ImageView backImageIcon;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private ImageView shareImageIcon;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private TextView eliminateTimesText;

    /* renamed from: I, reason: from kotlin metadata */
    private LottieAnimationView posterImage;

    /* renamed from: J, reason: from kotlin metadata */
    private LinearLayout posterLayout;

    /* renamed from: K, reason: from kotlin metadata */
    private TextView payGuideYellowText;

    /* renamed from: L, reason: from kotlin metadata */
    private TextView payGuideBlackTextRight;

    /* renamed from: M, reason: from kotlin metadata */
    private ImageView yellowDiamondIcon;

    /* renamed from: N, reason: from kotlin metadata */
    private LinearLayout diamondLayout;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final CoroutineScope viewModelScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain()));

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final MutableStateFlow<com.tencent.mobileqq.wink.editor.aielimination.model.c> _countInfo;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final StateFlow<com.tencent.mobileqq.wink.editor.aielimination.model.c> countInfo;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private String source;

    /* renamed from: T, reason: from kotlin metadata */
    private boolean defaultPoster;

    /* renamed from: U, reason: from kotlin metadata */
    private QCircleCommonLoadingDialog shareDialog;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private final Lazy eliminationViewModel;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f317884a;

        static {
            int[] iArr = new int[AIEliminationButtonStatus.values().length];
            try {
                iArr[AIEliminationButtonStatus.SHARE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AIEliminationButtonStatus.OPEN_YELLOW_DIAMOND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f317884a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/wink/aieliminate/AIEliminateHomeFragment$c", "Lcom/tencent/mobileqq/vas/api/IVasYellowDiamondPay$a;", "", "isSuccess", "", "code", "", "msg", "", "onResult", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c implements IVasYellowDiamondPay.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f317886b;

        c(int i3) {
            this.f317886b = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(AIEliminateHomeFragment this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.Lh();
        }

        @Override // com.tencent.mobileqq.vas.api.IVasYellowDiamondPay.a
        public void onResult(boolean isSuccess, int code, @NotNull String msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            QLog.d("WinkAIEliminationFragment", 1, "onResult  isSuccess=" + isSuccess + ", code=" + code + ", msg=" + msg2);
            if (isSuccess) {
                Handler mainHandler = AIEliminateHomeFragment.this.getMainHandler();
                final AIEliminateHomeFragment aIEliminateHomeFragment = AIEliminateHomeFragment.this;
                mainHandler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.wink.aieliminate.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        AIEliminateHomeFragment.c.b(AIEliminateHomeFragment.this);
                    }
                }, 2000L);
            }
            AIEliminateHomeFragment.this.Ch().U1(this.f317886b, isSuccess ? 1 : 0);
        }
    }

    public AIEliminateHomeFragment() {
        Lazy lazy;
        MutableStateFlow<com.tencent.mobileqq.wink.editor.aielimination.model.c> MutableStateFlow = StateFlowKt.MutableStateFlow(null);
        this._countInfo = MutableStateFlow;
        this.countInfo = MutableStateFlow;
        this.source = "0";
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<WinkAiEliminationViewModel>() { // from class: com.tencent.mobileqq.wink.aieliminate.AIEliminateHomeFragment$eliminationViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final WinkAiEliminationViewModel invoke() {
                return (WinkAiEliminationViewModel) AIEliminateHomeFragment.this.getViewModel(WinkAiEliminationViewModel.class);
            }
        });
        this.eliminationViewModel = lazy;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void Ah(AIEliminateHomeFragment aIEliminateHomeFragment, View view, String str, Map map, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            map = null;
        }
        aIEliminateHomeFragment.zh(view, str, map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WinkAiEliminationViewModel Ch() {
        return (WinkAiEliminationViewModel) this.eliminationViewModel.getValue();
    }

    private final void Eh() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    private final void Fh() {
        Bundle bundle;
        Intent intent;
        int i3 = b.f317884a[Ch().getMButtonStatus().ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                Context context = getContext();
                if (context != null) {
                    f fVar = f.f324854a;
                    String traceId = WinkContext.INSTANCE.d().getTraceId();
                    Config.Companion companion = Config.INSTANCE;
                    Config.a aVar = new Config.a();
                    aVar.i(TabType.ONLY_IMAGE);
                    aVar.f(false);
                    aVar.o(com.tencent.mobileqq.wink.picker.qcircle.c.f324971a.c());
                    aVar.g("");
                    Unit unit = Unit.INSTANCE;
                    Config a16 = aVar.a();
                    FragmentActivity activity = getActivity();
                    if (activity == null || (intent = activity.getIntent()) == null || (bundle = intent.getExtras()) == null) {
                        bundle = new Bundle();
                    }
                    fVar.c(context, this, 101, traceId, a16, bundle);
                    return;
                }
                return;
            }
            Gh(1);
            return;
        }
        Mh();
    }

    private final void Gh(int paySource) {
        WinkAiEliminationViewModel Ch = Ch();
        Activity hostActivity = getHostActivity();
        Intrinsics.checkNotNullExpressionValue(hostActivity, "hostActivity");
        Ch.R2(hostActivity, new c(paySource));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Hh(com.tencent.mobileqq.wink.editor.aielimination.model.c info) {
        boolean z16;
        String format;
        String str = info.getPayInfo().text.get();
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        CharSequence charSequence = null;
        if (z16) {
            ImageView imageView = this.yellowDiamondIcon;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("yellowDiamondIcon");
                imageView = null;
            }
            imageView.setVisibility(8);
            TextView textView = this.payGuideYellowText;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("payGuideYellowText");
                textView = null;
            }
            textView.setVisibility(8);
        } else {
            ImageView imageView2 = this.yellowDiamondIcon;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("yellowDiamondIcon");
                imageView2 = null;
            }
            imageView2.setVisibility(0);
            TextView textView2 = this.payGuideYellowText;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("payGuideYellowText");
                textView2 = null;
            }
            textView2.setVisibility(0);
            TextView textView3 = this.payGuideYellowText;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("payGuideYellowText");
                textView3 = null;
            }
            textView3.setText(info.getPayInfo().text.get());
        }
        TextView textView4 = this.payGuideBlackTextRight;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("payGuideBlackTextRight");
            textView4 = null;
        }
        textView4.setText(info.getPayInfo().desc.get());
        if (info.getPayInfo().type.get() == 1) {
            TextView textView5 = this.eliminateTimesText;
            if (textView5 != null) {
                textView5.setVisibility(0);
            }
        } else {
            TextView textView6 = this.eliminateTimesText;
            if (textView6 != null) {
                textView6.setVisibility(8);
            }
        }
        int q26 = Ch().q2();
        int A2 = Ch().A2();
        TextView textView7 = this.eliminateTimesText;
        if (textView7 != null) {
            int i3 = q26 + A2;
            if (i3 <= 0) {
                format = getResources().getString(R.string.f240607pm);
            } else {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String string = getResources().getString(R.string.f240597pl);
                Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st\u2026i_elimination_count_text)");
                format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(i3)}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            }
            textView7.setText(format);
        }
        if (!Ch().O2() && Ch().q2() + Ch().A2() <= 0) {
            if (Ch().D2() > 0) {
                TextView textView8 = this.buttonViewTextView;
                if (textView8 != null) {
                    textView8.setText(getResources().getString(R.string.f240817q7));
                }
                ImageView imageView3 = this.buttonViewIcon;
                if (imageView3 != null) {
                    imageView3.setVisibility(8);
                }
                Ch().d3(AIEliminationButtonStatus.SHARE);
            } else {
                TextView textView9 = this.buttonViewTextView;
                if (textView9 != null) {
                    textView9.setText(getResources().getString(R.string.f240647pq));
                }
                ImageView imageView4 = this.buttonViewIcon;
                if (imageView4 != null) {
                    imageView4.setVisibility(0);
                }
                Ch().d3(AIEliminationButtonStatus.OPEN_YELLOW_DIAMOND);
            }
        } else {
            TextView textView10 = this.buttonViewTextView;
            if (textView10 != null) {
                textView10.setText(getResources().getString(R.string.f240657pr));
            }
            ImageView imageView5 = this.buttonViewIcon;
            if (imageView5 != null) {
                imageView5.setVisibility(8);
            }
            Ch().d3(AIEliminationButtonStatus.NORMAL);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        TextView textView11 = this.buttonViewTextView;
        if (textView11 != null) {
            charSequence = textView11.getText();
        }
        if (charSequence == null) {
            charSequence = "";
        }
        linkedHashMap.put(WinkDaTongReportConstant.ElementParamKey.BUTTON_NAME, charSequence);
        zh(this.buttonView, WinkDaTongReportConstant.ElementId.EM_QZ_SELECT_PICTURE, linkedHashMap);
    }

    private final void Ih() {
        LifecycleOwnerKt.getLifecycleScope(this).launchWhenResumed(new AIEliminateHomeFragment$initObserver$1(this, null));
        LiveData<Long> B2 = Ch().B2();
        LifecycleOwner lifecycleOwner = getLifecycleOwner();
        final Function1<Long, Unit> function1 = new Function1<Long, Unit>() { // from class: com.tencent.mobileqq.wink.aieliminate.AIEliminateHomeFragment$initObserver$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l3) {
                invoke2(l3);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Long l3) {
                if ((l3 != null && l3.longValue() == 7003) || (l3 != null && l3.longValue() == 0)) {
                    QQToast.makeText(AIEliminateHomeFragment.this.getContext(), 5, (l3 != null && l3.longValue() == 7003) ? R.string.f240767q2 : R.string.f240777q3, 0).show();
                }
                AIEliminateHomeFragment.this.Lh();
            }
        };
        B2.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.wink.aieliminate.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AIEliminateHomeFragment.Jh(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Jh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Kh(AIEliminateHomeFragment this$0) {
        int coerceAtMost;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LottieAnimationView lottieAnimationView = this$0.posterImage;
        LottieAnimationView lottieAnimationView2 = null;
        if (lottieAnimationView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("posterImage");
            lottieAnimationView = null;
        }
        float width = lottieAnimationView.getWidth() * 1.2441472f;
        LinearLayout linearLayout = this$0.posterLayout;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("posterLayout");
            linearLayout = null;
        }
        int height = linearLayout.getHeight() - e.f384236a.a(20.0f);
        LottieAnimationView lottieAnimationView3 = this$0.posterImage;
        if (lottieAnimationView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("posterImage");
            lottieAnimationView3 = null;
        }
        ViewGroup.LayoutParams layoutParams = lottieAnimationView3.getLayoutParams();
        coerceAtMost = RangesKt___RangesKt.coerceAtMost((int) width, height);
        layoutParams.height = coerceAtMost;
        LottieAnimationView lottieAnimationView4 = this$0.posterImage;
        if (lottieAnimationView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("posterImage");
        } else {
            lottieAnimationView2 = lottieAnimationView4;
        }
        w53.b.f("AIEliminateHomeFragment", "width, height: " + lottieAnimationView2.getWidth() + ", " + width + ", " + height);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Lh() {
        BuildersKt__Builders_commonKt.launch$default(this.viewModelScope, null, null, new AIEliminateHomeFragment$refreshEliminateTimes$1(this, null), 3, null);
    }

    private final void Mh() {
        FragmentActivity activity;
        if (!FastClickUtils.isFastDoubleClick("AIEliminateHomeFragment_Share") && (activity = getActivity()) != null) {
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AIEliminateHomeFragment$shareEvent$1$1(activity, this, null), 3, null);
        }
    }

    private final void initViews(View view) {
        requireView().setBackgroundResource(R.drawable.qui_common_bg_bottom_light_bg);
        this.buttonView = (LinearLayout) view.findViewById(R.id.vqq);
        this.buttonViewIcon = (ImageView) view.findViewById(R.id.f24940_h);
        this.buttonViewTextView = (TextView) view.findViewById(R.id.f25190a6);
        this.backImageIcon = (ImageView) view.findViewById(R.id.t2q);
        this.shareImageIcon = (ImageView) view.findViewById(R.id.f84334lz);
        this.eliminateTimesText = (TextView) view.findViewById(R.id.urx);
        View findViewById = view.findViewById(R.id.f26640e3);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.poster_image)");
        this.posterImage = (LottieAnimationView) findViewById;
        View findViewById2 = view.findViewById(R.id.f26650e4);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.poster_layout)");
        this.posterLayout = (LinearLayout) findViewById2;
        View findViewById3 = view.findViewById(R.id.yrl);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.ll_yellow_diamond_layout)");
        this.diamondLayout = (LinearLayout) findViewById3;
        View findViewById4 = view.findViewById(R.id.f228204r);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.pay_guide_yellow)");
        this.payGuideYellowText = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R.id.f228104q);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.pay_guide_black)");
        this.payGuideBlackTextRight = (TextView) findViewById5;
        View findViewById6 = view.findViewById(R.id.f125827n4);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "view.findViewById(R.id.yellow_diamond_icon)");
        this.yellowDiamondIcon = (ImageView) findViewById6;
        LottieAnimationView lottieAnimationView = this.posterImage;
        ImageView imageView = null;
        if (lottieAnimationView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("posterImage");
            lottieAnimationView = null;
        }
        ViewTreeObserver viewTreeObserver = lottieAnimationView.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.tencent.mobileqq.wink.aieliminate.b
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public final void onGlobalLayout() {
                    AIEliminateHomeFragment.Kh(AIEliminateHomeFragment.this);
                }
            });
        }
        WinkAiEliminationViewModel Ch = Ch();
        LottieAnimationView lottieAnimationView2 = this.posterImage;
        if (lottieAnimationView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("posterImage");
            lottieAnimationView2 = null;
        }
        Ch.P2(lottieAnimationView2, this.defaultPoster);
        LinearLayout linearLayout = this.buttonView;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(this);
        }
        ImageView imageView2 = this.backImageIcon;
        if (imageView2 != null) {
            imageView2.setOnClickListener(this);
        }
        ImageView imageView3 = this.shareImageIcon;
        if (imageView3 != null) {
            imageView3.setOnClickListener(this);
        }
        Ah(this, this.shareImageIcon, WinkDaTongReportConstant.ElementId.EM_QZ_SHARE_BTN, null, 4, null);
        TextView textView = this.payGuideYellowText;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("payGuideYellowText");
            textView = null;
        }
        textView.setOnClickListener(this);
        ImageView imageView4 = this.yellowDiamondIcon;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("yellowDiamondIcon");
        } else {
            imageView = imageView4;
        }
        imageView.setOnClickListener(this);
        QCircleCommonLoadingDialog a16 = new QCircleCommonLoadingDialog.c(getContext()).p("\u52a0\u8f7d\u4e2d").n(false).j("wink_ai_elimination_share").b().a();
        Intrinsics.checkNotNullExpressionValue(a16, "Builder(context)\n       \u2026tn()\n            .build()");
        this.shareDialog = a16;
    }

    private final void registerDaTongReportPageId(View contentView) {
        WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.QZONE_PUBLISH_ID, ((IQZoneApiProxy) QRoute.api(IQZoneApiProxy.class)).getPublishId());
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_USER_FROM, this.source);
        WinkHomeReportHelper.f326257a.c(getActivity(), contentView, getPageId(), linkedHashMap);
        QZoneLoginReportHelper.reportLoginFromAIEliminate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zh(View view, String elementId, Map<String, ? extends Object> extraParams) {
        if (view == null) {
            return;
        }
        VideoReport.setElementId(view, elementId);
        Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
        if (extraParams != null) {
            buildElementParams.putAll(extraParams);
        }
        VideoReport.setElementParams(view, buildElementParams);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
    }

    @NotNull
    public final StateFlow<com.tencent.mobileqq.wink.editor.aielimination.model.c> Bh() {
        return this.countInfo;
    }

    @NotNull
    public final Map<String, Object> Dh() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_USER_FROM, this.source);
        linkedHashMap.put("pgid", getPageId());
        linkedHashMap.put("qq_pgid", getPageId());
        return linkedHashMap;
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        return new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.gu5;
    }

    @NotNull
    public final String getPageId() {
        return WinkDaTongReportConstant.PageId.PG_QZ_ELIMINATION_FUNCTION_GUIDE;
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    protected int getStatusBarColor() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    public boolean isUseDarkTextStatusBar() {
        if (!uq3.c.P6()) {
            return true;
        }
        return !QQTheme.isNowThemeIsNight();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        w53.b.f("AIEliminateHomeFragment", "onActivityResult: requestCode: " + requestCode + ", resultCode: " + resultCode);
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == -1) {
            switch (requestCode) {
                case 52133:
                case 52135:
                    yh();
                    return;
                case 52134:
                    boolean z16 = false;
                    if (data != null && data.getIntExtra("PUBLISH_RESULT_CODE", 0) == 1) {
                        z16 = true;
                    }
                    if (z16) {
                        Ch().V2();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        Integer num;
        EventCollector.getInstance().onViewClickedBefore(v3);
        if (v3 != null) {
            num = Integer.valueOf(v3.getId());
        } else {
            num = null;
        }
        if (num != null && num.intValue() == R.id.vqq) {
            Fh();
        } else if (num != null && num.intValue() == R.id.t2q) {
            Eh();
        } else if (num != null && num.intValue() == R.id.f84334lz) {
            Mh();
        } else {
            boolean z16 = true;
            if ((num == null || num.intValue() != R.id.f228204r) && (num == null || num.intValue() != R.id.f125827n4)) {
                z16 = false;
            }
            if (z16) {
                Gh(2);
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        String str;
        String str2;
        super.onCreate(savedInstanceState);
        Map map = (Map) requireActivity().getIntent().getSerializableExtra("key_attrs");
        if (map != null && (str2 = (String) map.get("source")) != null) {
            this.source = str2;
        }
        if (map != null && (str = (String) map.get(QCircleScheme.AttrQQPublish.DEFAULT_POSTER)) != null) {
            this.defaultPoster = Intrinsics.areEqual(str, "1");
        }
        w53.b.a("AIEliminateHomeFragment", "source: " + this.source);
        Ch().J2();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        w53.b.a("AIEliminateHomeFragment", "currentTraceId: " + Ch().getCurrentTraceId());
        WinkContext.Companion companion = WinkContext.INSTANCE;
        WinkContext h16 = companion.h(Ch().getCurrentTraceId());
        if (h16 != null) {
            companion.o(h16);
        }
        Lh();
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        Ih();
        Lh();
        registerDaTongReportPageId(view);
    }

    public final void yh() {
        Ch().V2();
    }
}
