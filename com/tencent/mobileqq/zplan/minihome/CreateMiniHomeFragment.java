package com.tencent.mobileqq.zplan.minihome;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.filament.zplan.scene.minihome.IMiniHomeLoadCallback;
import com.tencent.filament.zplan.scene.minihome.MiniHomeScene;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.bubble.ZPlanMiniHomeGuidanceBubbleViewController;
import com.tencent.mobileqq.zplan.minihome.aa;
import com.tencent.mobileqq.zplan.minihome.api.IMiniHomeHelper;
import com.tencent.mobileqq.zplan.minihome.view.MiniHomeSampleOutlineView;
import com.tencent.mobileqq.zplan.minihome.view.MiniHomeSampleType;
import com.tencent.mobileqq.zplan.utils.bb;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import com.tencent.state.report.SquareReportConst;
import com.tencent.widget.immersive.ImmersiveUtils;
import fi3.av;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import mqq.app.Constants;
import mqq.util.WeakReference;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\t*\u0002OS\u0018\u0000 Y2\u00020\u0001:\u0001ZB\u0007\u00a2\u0006\u0004\bW\u0010XJ\u0012\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u001d\u0010\u000f\u001a\u00020\u00042\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0011\u001a\u00020\u0004H\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0002J\b\u0010\u0013\u001a\u00020\u0004H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\b\u0010\u0018\u001a\u00020\u0016H\u0016J\b\u0010\u0019\u001a\u00020\u0016H\u0016J\u0012\u0010\u001c\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J$\u0010\"\u001a\u00020!2\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010 \u001a\u0004\u0018\u00010\u001f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0017J\b\u0010#\u001a\u00020\u0016H\u0016J\b\u0010$\u001a\u00020\u0004H\u0016J\b\u0010%\u001a\u00020\u0004H\u0016J\b\u0010&\u001a\u00020\u0004H\u0016J\b\u0010'\u001a\u00020\u0004H\u0016R\u001b\u0010-\u001a\u00020(8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u001c\u00101\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00107\u001a\u0002028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00104R\u0016\u00109\u001a\u0002028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00104R\u0016\u0010;\u001a\u0002028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u00104R\u001b\u0010@\u001a\u00020<8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b=\u0010*\u001a\u0004\b>\u0010?R\u001b\u0010D\u001a\u00020A8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b4\u0010*\u001a\u0004\bB\u0010CR\u0016\u0010G\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010J\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010N\u001a\u00020K8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010R\u001a\u00020O8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0014\u0010V\u001a\u00020S8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bT\u0010U\u00a8\u0006["}, d2 = {"Lcom/tencent/mobileqq/zplan/minihome/CreateMiniHomeFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "", "color", "", "ci", "di", "Lcom/tencent/mobileqq/zplan/minihome/am;", "event", "Ph", "Oh", "Nh", "", "Lr55/b;", "it", "Zh", "([Lr55/b;)V", "Vh", "ai", "bi", "", "Uh", "", "needStatusTrans", "needImmersive", "isWrapContent", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", "onBackEvent", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "onDestroyView", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lfi3/av;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "Rh", "()Lfi3/av;", "binding", "Lkotlinx/coroutines/flow/MutableStateFlow;", "D", "Lkotlinx/coroutines/flow/MutableStateFlow;", "choosing", "", "E", "J", "miniHomeInitStartTime", UserInfo.SEX_FEMALE, "miniHomeRoomLoadStartTime", "G", "pixelCallbackDuration", "H", "roomLoadDuration", "Lcom/tencent/mobileqq/zplan/minihome/y;", "I", "Sh", "()Lcom/tencent/mobileqq/zplan/minihome/y;", "miniHomeController", "Lcom/tencent/mobileqq/zplan/minihome/aa;", "Th", "()Lcom/tencent/mobileqq/zplan/minihome/aa;", "miniHomeReporter", "K", "Z", "hasReportFinishButtonImp", "L", "Landroid/view/View;", "miniHomeView", "Lcom/tencent/mobileqq/zplan/minihome/CreateMiniHomeSource;", "M", "Lcom/tencent/mobileqq/zplan/minihome/CreateMiniHomeSource;", "createHomeSource", "com/tencent/mobileqq/zplan/minihome/CreateMiniHomeFragment$b", "N", "Lcom/tencent/mobileqq/zplan/minihome/CreateMiniHomeFragment$b;", "miniHomeSceneEventCallback", "com/tencent/mobileqq/zplan/minihome/CreateMiniHomeFragment$loadRoomCallback$1", "P", "Lcom/tencent/mobileqq/zplan/minihome/CreateMiniHomeFragment$loadRoomCallback$1;", "loadRoomCallback", "<init>", "()V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class CreateMiniHomeFragment extends QPublicBaseFragment {

    /* renamed from: C, reason: from kotlin metadata */
    private final Lazy binding;

    /* renamed from: D, reason: from kotlin metadata */
    private final MutableStateFlow<r55.b> choosing;

    /* renamed from: E, reason: from kotlin metadata */
    private long miniHomeInitStartTime;

    /* renamed from: F, reason: from kotlin metadata */
    private long miniHomeRoomLoadStartTime;

    /* renamed from: G, reason: from kotlin metadata */
    private long pixelCallbackDuration;

    /* renamed from: H, reason: from kotlin metadata */
    private long roomLoadDuration;

    /* renamed from: I, reason: from kotlin metadata */
    private final Lazy miniHomeController;

    /* renamed from: J, reason: from kotlin metadata */
    private final Lazy miniHomeReporter;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean hasReportFinishButtonImp;

    /* renamed from: L, reason: from kotlin metadata */
    private View miniHomeView;

    /* renamed from: M, reason: from kotlin metadata */
    private CreateMiniHomeSource createHomeSource;

    /* renamed from: N, reason: from kotlin metadata */
    private b miniHomeSceneEventCallback;

    /* renamed from: P, reason: from kotlin metadata */
    private final CreateMiniHomeFragment$loadRoomCallback$1 loadRoomCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.zplan.minihome.CreateMiniHomeFragment$1", f = "CreateMiniHomeFragment.kt", i = {}, l = {509}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.zplan.minihome.CreateMiniHomeFragment$1, reason: invalid class name */
    /* loaded from: classes34.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.zplan.minihome.CreateMiniHomeFragment$1$a */
        /* loaded from: classes34.dex */
        public static final class a implements FlowCollector<r55.b> {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ CreateMiniHomeFragment f334241d;

            public a(CreateMiniHomeFragment createMiniHomeFragment) {
                this.f334241d = createMiniHomeFragment;
            }

            /* JADX WARN: Code restructure failed: missing block: B:18:0x005f, code lost:
            
                if (r3 != false) goto L24;
             */
            /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
            /* JADX WARN: Removed duplicated region for block: B:14:0x002f  */
            /* JADX WARN: Removed duplicated region for block: B:17:0x005b  */
            /* JADX WARN: Removed duplicated region for block: B:20:0x0064  */
            /* JADX WARN: Removed duplicated region for block: B:23:0x0080  */
            /* JADX WARN: Removed duplicated region for block: B:26:0x0088  */
            /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
            @Override // kotlinx.coroutines.flow.FlowCollector
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Object emit(r55.b bVar, Continuation<? super Unit> continuation) {
                boolean z16;
                String str;
                boolean z17;
                String str2;
                View view;
                r55.a aVar;
                byte[] bArr;
                boolean isBlank;
                boolean isBlank2;
                boolean isBlank3;
                r55.b bVar2 = bVar;
                String str3 = bVar2.f430783f;
                boolean z18 = false;
                if (str3 != null) {
                    isBlank3 = StringsKt__StringsJVMKt.isBlank(str3);
                    if (!isBlank3) {
                        z16 = false;
                        if (!z16) {
                            this.f334241d.ci(Color.parseColor(bVar2.f430783f));
                        }
                        str = bVar2.f430786i;
                        if (str != null) {
                            isBlank2 = StringsKt__StringsJVMKt.isBlank(str);
                            if (!isBlank2) {
                                z17 = false;
                                if (!z17) {
                                    this.f334241d.di(Color.parseColor(bVar2.f430786i));
                                }
                                Drawable drawable = AppCompatResources.getDrawable(this.f334241d.Rh().getRoot().getContext(), R.drawable.f159884il3);
                                ImageView imageView = this.f334241d.Rh().f398945e;
                                str2 = bVar2.f430784g;
                                if (str2 != null) {
                                    isBlank = StringsKt__StringsJVMKt.isBlank(str2);
                                }
                                z18 = true;
                                if (!z18) {
                                    String str4 = bVar2.f430784g;
                                    URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                                    obtain.mLoadingDrawable = drawable;
                                    obtain.mFailedDrawable = drawable;
                                    Unit unit = Unit.INSTANCE;
                                    drawable = URLDrawable.getDrawable(str4, obtain);
                                }
                                imageView.setImageDrawable(drawable);
                                view = this.f334241d.miniHomeView;
                                if (view != null) {
                                    view.setAlpha(0.0f);
                                }
                                aVar = bVar2.f430785h;
                                if (aVar != null && (bArr = aVar.f430776d) != null) {
                                    Intrinsics.checkNotNullExpressionValue(bArr, "it.roomDesc.roomDescJson");
                                    String str5 = new String(bArr, Charsets.UTF_8);
                                    QLog.i("CreateMiniHomeFragment", 1, "roomJson: " + str5);
                                    this.f334241d.Sh().h(MiniHomeSceneEnum.SCENE_CREATE);
                                    this.f334241d.Sh().e(QQTheme.isNowThemeIsNight());
                                    this.f334241d.Sh().l();
                                    this.f334241d.Sh().o(MiniHomeScene.Companion.CAMERAMODE.NORMAL);
                                    this.f334241d.miniHomeRoomLoadStartTime = System.currentTimeMillis();
                                    this.f334241d.Sh().c(str5, this.f334241d.loadRoomCallback);
                                }
                                return Unit.INSTANCE;
                            }
                        }
                        z17 = true;
                        if (!z17) {
                        }
                        Drawable drawable2 = AppCompatResources.getDrawable(this.f334241d.Rh().getRoot().getContext(), R.drawable.f159884il3);
                        ImageView imageView2 = this.f334241d.Rh().f398945e;
                        str2 = bVar2.f430784g;
                        if (str2 != null) {
                        }
                        z18 = true;
                        if (!z18) {
                        }
                        imageView2.setImageDrawable(drawable2);
                        view = this.f334241d.miniHomeView;
                        if (view != null) {
                        }
                        aVar = bVar2.f430785h;
                        if (aVar != null) {
                            Intrinsics.checkNotNullExpressionValue(bArr, "it.roomDesc.roomDescJson");
                            String str52 = new String(bArr, Charsets.UTF_8);
                            QLog.i("CreateMiniHomeFragment", 1, "roomJson: " + str52);
                            this.f334241d.Sh().h(MiniHomeSceneEnum.SCENE_CREATE);
                            this.f334241d.Sh().e(QQTheme.isNowThemeIsNight());
                            this.f334241d.Sh().l();
                            this.f334241d.Sh().o(MiniHomeScene.Companion.CAMERAMODE.NORMAL);
                            this.f334241d.miniHomeRoomLoadStartTime = System.currentTimeMillis();
                            this.f334241d.Sh().c(str52, this.f334241d.loadRoomCallback);
                        }
                        return Unit.INSTANCE;
                    }
                }
                z16 = true;
                if (!z16) {
                }
                str = bVar2.f430786i;
                if (str != null) {
                }
                z17 = true;
                if (!z17) {
                }
                Drawable drawable22 = AppCompatResources.getDrawable(this.f334241d.Rh().getRoot().getContext(), R.drawable.f159884il3);
                ImageView imageView22 = this.f334241d.Rh().f398945e;
                str2 = bVar2.f430784g;
                if (str2 != null) {
                }
                z18 = true;
                if (!z18) {
                }
                imageView22.setImageDrawable(drawable22);
                view = this.f334241d.miniHomeView;
                if (view != null) {
                }
                aVar = bVar2.f430785h;
                if (aVar != null) {
                }
                return Unit.INSTANCE;
            }
        }

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                Flow filterNotNull = FlowKt.filterNotNull(CreateMiniHomeFragment.this.choosing);
                a aVar = new a(CreateMiniHomeFragment.this);
                this.label = 1;
                if (filterNotNull.collect(aVar, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zplan/minihome/CreateMiniHomeFragment$b", "Lcom/tencent/mobileqq/zplan/minihome/ac;", "Lcom/tencent/mobileqq/zplan/minihome/am;", "event", "Lcom/tencent/mobileqq/zplan/minihome/MiniHomeSceneEnum;", "sceneEnum", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements ac {

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes34.dex */
        public /* synthetic */ class a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f334243a;

            static {
                int[] iArr = new int[EventType.values().length];
                try {
                    iArr[EventType.EVENT_PIXEL_CALLBACK.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[EventType.EVENT_FIRST_FRAME_IMAGE_READY.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[EventType.EVENT_ERROR_CALLBACK.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                f334243a = iArr;
            }
        }

        b() {
        }

        @Override // com.tencent.mobileqq.zplan.minihome.ac
        public void a(am event, MiniHomeSceneEnum sceneEnum) {
            Intrinsics.checkNotNullParameter(event, "event");
            Intrinsics.checkNotNullParameter(sceneEnum, "sceneEnum");
            if (sceneEnum != MiniHomeSceneEnum.SCENE_CREATE) {
                return;
            }
            int i3 = a.f334243a[event.getType().ordinal()];
            if (i3 == 1) {
                long currentTimeMillis = System.currentTimeMillis();
                CreateMiniHomeFragment createMiniHomeFragment = CreateMiniHomeFragment.this;
                createMiniHomeFragment.pixelCallbackDuration = currentTimeMillis - createMiniHomeFragment.miniHomeInitStartTime;
                QLog.i("CreateMiniHomeFragment", 1, "pixelCallbackDuration: " + CreateMiniHomeFragment.this.pixelCallbackDuration + "; startTime " + CreateMiniHomeFragment.this.miniHomeInitStartTime + ", endTime: " + currentTimeMillis);
                CreateMiniHomeFragment.this.Ph(event);
                return;
            }
            if (i3 != 2) {
                if (i3 != 3) {
                    return;
                }
                QLog.i("CreateMiniHomeFragment", 1, "EVENT_ERROR_CALLBACK");
                CreateMiniHomeFragment.this.Nh(event);
                return;
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            QLog.i("CreateMiniHomeFragment", 1, "firstFrameDuration: " + (currentTimeMillis2 - CreateMiniHomeFragment.this.miniHomeInitStartTime) + "; startTime " + CreateMiniHomeFragment.this.miniHomeInitStartTime + ", endTime: " + currentTimeMillis2);
            CreateMiniHomeFragment.this.Oh(event);
        }
    }

    /* JADX WARN: Type inference failed for: r1v8, types: [com.tencent.mobileqq.zplan.minihome.CreateMiniHomeFragment$loadRoomCallback$1] */
    public CreateMiniHomeFragment() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<av>() { // from class: com.tencent.mobileqq.zplan.minihome.CreateMiniHomeFragment$binding$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final av invoke() {
                return av.g(LayoutInflater.from(CreateMiniHomeFragment.this.getContext()));
            }
        });
        this.binding = lazy;
        this.choosing = StateFlowKt.MutableStateFlow(null);
        this.pixelCallbackDuration = -1L;
        this.roomLoadDuration = -1L;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<y>() { // from class: com.tencent.mobileqq.zplan.minihome.CreateMiniHomeFragment$miniHomeController$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final y invoke() {
                return ((IMiniHomeHelper) QRoute.api(IMiniHomeHelper.class)).getMiniHomeController("createMiniHome", "createMiniHome", MiniHomeSceneEnum.SCENE_CREATE);
            }
        });
        this.miniHomeController = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<aa>() { // from class: com.tencent.mobileqq.zplan.minihome.CreateMiniHomeFragment$miniHomeReporter$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final aa invoke() {
                return ((IMiniHomeHelper) QRoute.api(IMiniHomeHelper.class)).createMiniHomeReporter();
            }
        });
        this.miniHomeReporter = lazy3;
        this.createHomeSource = CreateMiniHomeSource.UNKNOWN;
        this.miniHomeSceneEventCallback = new b();
        this.loadRoomCallback = new IMiniHomeLoadCallback() { // from class: com.tencent.mobileqq.zplan.minihome.CreateMiniHomeFragment$loadRoomCallback$1
            @Override // com.tencent.filament.zplan.scene.minihome.IMiniHomeLoadCallback
            public void onMiniHomeLoadResult(boolean success, String dataJson) {
                long j3;
                long j16;
                long j17;
                QLog.i("CreateMiniHomeFragment", 1, "loadRoom onMiniHomeLoadResult " + success);
                long currentTimeMillis = System.currentTimeMillis();
                CreateMiniHomeFragment createMiniHomeFragment = CreateMiniHomeFragment.this;
                j3 = createMiniHomeFragment.miniHomeRoomLoadStartTime;
                createMiniHomeFragment.roomLoadDuration = currentTimeMillis - j3;
                j16 = CreateMiniHomeFragment.this.roomLoadDuration;
                j17 = CreateMiniHomeFragment.this.miniHomeRoomLoadStartTime;
                QLog.i("CreateMiniHomeFragment", 1, "roomLoadDuration: " + j16 + "; startTime " + j17 + ", endTime: " + currentTimeMillis);
            }
        };
        CorountineFunKt.e(LifecycleOwnerKt.getLifecycleScope(this), "zplan_CreateMiniHomeFragment_\u5207\u6362\u9009\u4e2d\u573a\u666f", null, null, null, new AnonymousClass1(null), 14, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Nh(am event) {
        if (event instanceof EventErrorCallback) {
            QLog.i("CreateMiniHomeFragment", 1, "doOnErrorCallback");
            Th().b("zplanCreateMiniHomeErrorMsg", ((EventErrorCallback) event).getData(), String.valueOf(this.miniHomeInitStartTime == 0 ? -1L : System.currentTimeMillis() - this.miniHomeInitStartTime));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Oh(am event) {
        QLog.i("CreateMiniHomeFragment", 1, "doOnFirstFrameImgReady " + event);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ph(am event) {
        QLog.i("CreateMiniHomeFragment", 1, "doOnPixelCallback");
        if (event instanceof EventPixelCallback) {
            QLog.i("CreateMiniHomeFragment", 1, "doOnPixelCallback, data: " + ((EventPixelCallback) event).getData());
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.minihome.e
                @Override // java.lang.Runnable
                public final void run() {
                    CreateMiniHomeFragment.Qh(CreateMiniHomeFragment.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Qh(CreateMiniHomeFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View view = this$0.miniHomeView;
        if (view == null) {
            return;
        }
        view.setAlpha(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final av Rh() {
        return (av) this.binding.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final y Sh() {
        return (y) this.miniHomeController.getValue();
    }

    private final aa Th() {
        return (aa) this.miniHomeReporter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String Uh() {
        return ((IZPlanApi) QRoute.api(IZPlanApi.class)).generateXWConnectScheme("create_mini_home", null, bb.f335811a.e(), false, null);
    }

    private final void Vh() {
        VideoReport.setElementId(Rh().f398949i, "em_zplan_complete_btn");
        QUIButton qUIButton = Rh().f398949i;
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_ALL;
        VideoReport.setElementExposePolicy(qUIButton, exposurePolicy);
        QUIButton qUIButton2 = Rh().f398949i;
        ClickPolicy clickPolicy = ClickPolicy.REPORT_NONE;
        VideoReport.setElementClickPolicy(qUIButton2, clickPolicy);
        VideoReport.setElementId(Rh().f398942b, "em_zplan_back_btn");
        VideoReport.setElementExposePolicy(Rh().f398942b, exposurePolicy);
        VideoReport.setElementClickPolicy(Rh().f398942b, clickPolicy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Wh(CreateMiniHomeFragment this$0, View view, MotionEvent event) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        y Sh = this$0.Sh();
        Intrinsics.checkNotNullExpressionValue(event, "event");
        Sh.onTouchEvent(event);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Xh(CreateMiniHomeFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.requireActivity().onBackPressed();
        VideoReport.reportEvent("clck", this$0.Rh().f398942b, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Yh(LifecycleCoroutineScope scope, com.tencent.mobileqq.zplan.minihome.view.h adapter, MutableStateFlow source, CreateMiniHomeFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(scope, "$scope");
        Intrinsics.checkNotNullParameter(adapter, "$adapter");
        Intrinsics.checkNotNullParameter(source, "$source");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        CorountineFunKt.e(scope, "zplan_CreateMiniHomeFragment_\u8bbe\u7f6e\u6a21\u677f\u5c0f\u7a9d", null, null, null, new CreateMiniHomeFragment$onCreateView$1$7$1(adapter, source, this$0, null), 14, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Zh(r55.b[] it) {
        if (this.hasReportFinishButtonImp) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("zplan_room_name", it[0].f430778a);
        VideoReport.reportEvent("imp", Rh().f398949i, hashMap);
        this.hasReportFinishButtonImp = true;
    }

    private final void ai() {
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(Rh().getRoot(), "pg_zplan_mini_xiaowo_create");
        VideoReport.setPageParams(Rh().getRoot(), new PageParams(hashMap));
        VideoReport.setPageReportPolicy(Rh().getRoot(), PageReportPolicy.REPORT_ALL);
        VideoReport.reportEvent("pgin", Rh().getRoot(), null);
    }

    private final void bi() {
        VideoReport.reportEvent("pgout", Rh().getRoot(), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ci(final int color) {
        CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.minihome.CreateMiniHomeFragment$setBackgroundColor$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                if (CreateMiniHomeFragment.this.getContext() == null) {
                    return;
                }
                av Rh = CreateMiniHomeFragment.this.Rh();
                int i3 = color;
                CreateMiniHomeFragment createMiniHomeFragment = CreateMiniHomeFragment.this;
                Rh.f398951k.setBackground(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{0, i3}));
                Rh.f398950j.setBackground(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{i3, createMiniHomeFragment.requireContext().getColor(R.color.qui_common_bg_bottom_standard)}));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void di(int color) {
        Rh().f398959s.setTextColor(color);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        return true;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        ZPlanMiniHomeGuidanceBubbleViewController.INSTANCE.j();
        QRouteApi api = QRoute.api(IMiniHomeHelper.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IMiniHomeHelper::class.java)");
        IMiniHomeHelper.a.a((IMiniHomeHelper) api, false, null, 2, null);
        if (this.createHomeSource == CreateMiniHomeSource.MINI_CONNECT && ZPlanQQMC.INSTANCE.destroyMiniConnectWhenJumpOut()) {
            String Uh = Uh();
            if (Uh.length() > 0) {
                IZPlanApi iZPlanApi = (IZPlanApi) QRoute.api(IZPlanApi.class);
                Context requireContext = requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                iZPlanApi.launchScheme(requireContext, Uh);
            }
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        CreateMiniHomeSource createMiniHomeSource;
        String name;
        Intent intent;
        Bundle extras;
        super.onCreate(savedInstanceState);
        try {
            FragmentActivity activity = getActivity();
            if (activity == null || (intent = activity.getIntent()) == null || (extras = intent.getExtras()) == null || (name = extras.getString("source")) == null) {
                name = EditMiniHomeSource.UNKNOWN.name();
            }
            Intrinsics.checkNotNullExpressionValue(name, "activity?.intent?.extras\u2026niHomeSource.UNKNOWN.name");
            createMiniHomeSource = CreateMiniHomeSource.valueOf(name);
        } catch (Exception unused) {
            createMiniHomeSource = CreateMiniHomeSource.UNKNOWN;
        }
        this.createHomeSource = createMiniHomeSource;
        Sh().r(new WeakReference(this.miniHomeSceneEventCallback));
        this.miniHomeInitStartTime = System.currentTimeMillis();
        Sh().create();
        Sh().f();
        Sh().h(MiniHomeSceneEnum.SCENE_CREATE);
        Sh().e(QQTheme.isNowThemeIsNight());
        ai();
        Vh();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final MutableStateFlow b16;
        Drawable drawable;
        Drawable drawable2;
        Drawable.ConstantState constantState;
        Drawable newDrawable;
        Drawable.ConstantState constantState2;
        Drawable newDrawable2;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        av Rh = Rh();
        ci(Color.rgb(63, 161, 149));
        Rh.f398944d.f399002c.setLayoutManager(new StaggeredGridLayoutManager(2, 1));
        final LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
        b16 = CreateMiniHomeFragmentKt.b(lifecycleScope);
        MiniHomeSceneEnum miniHomeSceneEnum = MiniHomeSceneEnum.SCENE_CREATE;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        final com.tencent.mobileqq.zplan.minihome.view.h hVar = new com.tencent.mobileqq.zplan.minihome.view.h(miniHomeSceneEnum, b16, new MiniHomeSampleOutlineView(requireContext, null, 0, 6, null), com.tencent.sqshow.zootopia.utils.i.a(137.75f), com.tencent.sqshow.zootopia.utils.i.a(145.25f), MiniHomeSampleType.CHOOSE, new Function1<r55.b, Unit>() { // from class: com.tencent.mobileqq.zplan.minihome.CreateMiniHomeFragment$onCreateView$1$adapter$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(r55.b bVar) {
                invoke2(bVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(r55.b it) {
                Intrinsics.checkNotNullParameter(it, "it");
                CreateMiniHomeFragment.this.choosing.tryEmit(it);
            }
        });
        View view = null;
        CorountineFunKt.e(lifecycleScope, "zplan_CreateMiniHomeFragment_\u66f4\u65b0\u9762\u677f", null, null, null, new CreateMiniHomeFragment$onCreateView$1$1(b16, hVar, null), 14, null);
        CorountineFunKt.e(lifecycleScope, "zplan_CreateMiniHomeFragment_\u542f\u7528\u5b8c\u6210\u6309\u94ae", null, null, null, new CreateMiniHomeFragment$onCreateView$1$2(b16, Rh, this, null), 14, null);
        Rh.f398944d.f399002c.setAdapter(hVar);
        View view2 = Rh.f398944d.f399001b;
        view2.setBackground(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{0, view2.getResources().getColor(R.color.qui_common_bg_middle_light)}));
        view2.setVisibility(0);
        Rh.f398946f.setOutlineProvider(new ap(com.tencent.sqshow.zootopia.utils.i.e(8)));
        Rh.f398949i.setOutlineProvider(new ap(com.tencent.sqshow.zootopia.utils.i.e(4)));
        RelativeLayout relativeLayout = Rh.f398953m;
        a aVar = a.f334287a;
        relativeLayout.setOutlineProvider(aVar);
        Rh.f398947g.setOutlineProvider(aVar);
        Rh.f398957q.getLayoutParams().height = ImmersiveUtils.getStatusBarHeight(getContext());
        Rh.f398942b.setBackground(AppCompatResources.getDrawable(requireContext(), R.drawable.qui_chevron_left_icon_white));
        ImageView imageView = Rh.f398955o;
        Drawable drawable3 = AppCompatResources.getDrawable(requireContext(), R.drawable.qui_refresh);
        if (drawable3 == null || (constantState2 = drawable3.getConstantState()) == null || (newDrawable2 = constantState2.newDrawable()) == null || (drawable = newDrawable2.mutate()) == null) {
            drawable = null;
        } else {
            drawable.setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_IN));
        }
        imageView.setBackground(drawable);
        ImageView imageView2 = Rh.f398956p;
        Drawable drawable4 = AppCompatResources.getDrawable(requireContext(), R.drawable.qui_remark);
        if (drawable4 == null || (constantState = drawable4.getConstantState()) == null || (newDrawable = constantState.newDrawable()) == null || (drawable2 = newDrawable.mutate()) == null) {
            drawable2 = null;
        } else {
            drawable2.setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_IN));
        }
        imageView2.setBackground(drawable2);
        Rh.f398942b.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.minihome.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                CreateMiniHomeFragment.Xh(CreateMiniHomeFragment.this, view3);
            }
        });
        di(-1);
        Rh.f398949i.setClickable(false);
        Rh.f398949i.setEnabled(false);
        Rh.f398949i.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.minihome.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                CreateMiniHomeFragment.Yh(LifecycleCoroutineScope.this, hVar, b16, this, view3);
            }
        });
        VideoReport.reportEvent("imp", Rh().f398942b, null);
        Sh().createView();
        RelativeLayout relativeLayout2 = Rh().f398952l;
        relativeLayout2.getLayoutParams().height = (int) (relativeLayout2.getContext().getResources().getDisplayMetrics().heightPixels * 0.5f);
        View view3 = Sh().getView();
        this.miniHomeView = view3;
        if (view3 != null) {
            view3.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            view = view3;
        }
        relativeLayout2.addView(view);
        relativeLayout2.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.zplan.minihome.d
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view4, MotionEvent motionEvent) {
                boolean Wh;
                Wh = CreateMiniHomeFragment.Wh(CreateMiniHomeFragment.this, view4, motionEvent);
                return Wh;
            }
        });
        ViewGroup.LayoutParams layoutParams = Rh().f398943c.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.LayoutParams) layoutParams)).topMargin = (int) (requireContext().getResources().getDisplayMetrics().heightPixels * 0.4f);
        ConstraintLayout root = Rh().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Sh().destroy();
        ((IMiniHomeHelper) QRoute.api(IMiniHomeHelper.class)).releaseMiniHomeController();
        aa.a.a(Th(), "zplanCreateMiniHomeExit", "createMiniHome", "exit_create_home", null, String.valueOf(this.pixelCallbackDuration), String.valueOf(this.roomLoadDuration), null, String.valueOf(this.miniHomeInitStartTime == 0 ? -1L : System.currentTimeMillis() - this.miniHomeInitStartTime), 72, null);
        bi();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        Sh().q();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        Sh().pause();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Sh().resume();
    }
}
