package com.tencent.mobileqq.flock.publish.part;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.flock.publish.event.FlockPublishFinishEvent;
import com.tencent.mobileqq.flock.publish.viewmodel.FlockPublishUIStateViewModel;
import com.tencent.mobileqq.flock.publish.viewmodel.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.createtroopblacklist.CreateTroopUnblockType;
import com.tencent.mobileqq.troop.createtroopblacklist.api.ICreateTroopBlackListUtilApi;
import com.tencent.mobileqq.winkpublish.report.WinkBaseErrorCodeKt;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.util.LoadingUtil;
import com.tencent.util.QQToastUtil;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 (2\u00020\u0001:\u0001)B\u0007\u00a2\u0006\u0004\b&\u0010'J\u000e\u0010\u0004\u001a\u00020\u0003*\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0012\u0010\u000f\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016R\u001b\u0010\u0015\u001a\u00020\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u001a\u001a\u00020\u00168BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001f\u001a\u00020\u001b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\u0012\u001a\u0004\b\u001d\u0010\u001eR#\u0010%\u001a\n !*\u0004\u0018\u00010 0 8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\"\u0010\u0012\u001a\u0004\b#\u0010$\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/flock/publish/part/FlockPublishActionPart;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/view/View;", "", "P9", "K9", "Lcom/tencent/mobileqq/troop/createtroopblacklist/CreateTroopUnblockType;", "type", "Q9", "", "H9", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "Lcom/tencent/mobileqq/flock/publish/viewmodel/FlockPublishUIStateViewModel;", "d", "Lkotlin/Lazy;", "J9", "()Lcom/tencent/mobileqq/flock/publish/viewmodel/FlockPublishUIStateViewModel;", "uiViewModel", "Lcom/tencent/mobileqq/flock/publish/viewmodel/b;", "e", "G9", "()Lcom/tencent/mobileqq/flock/publish/viewmodel/b;", "galleryViewModel", "Lcom/tencent/mobileqq/flock/publish/viewmodel/f;", "f", "I9", "()Lcom/tencent/mobileqq/flock/publish/viewmodel/f;", "publishSendViewModel", "Landroid/app/Dialog;", "kotlin.jvm.PlatformType", tl.h.F, "F9", "()Landroid/app/Dialog;", "dialog", "<init>", "()V", "i", "a", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class FlockPublishActionPart extends Part {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy uiViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy galleryViewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy publishSendViewModel;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy dialog;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/flock/publish/part/FlockPublishActionPart$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.flock.publish.part.FlockPublishActionPart$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48218);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public FlockPublishActionPart() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<FlockPublishUIStateViewModel>() { // from class: com.tencent.mobileqq.flock.publish.part.FlockPublishActionPart$uiViewModel$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FlockPublishActionPart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final FlockPublishUIStateViewModel invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (FlockPublishUIStateViewModel) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    FlockPublishActionPart flockPublishActionPart = FlockPublishActionPart.this;
                    Intent intent = flockPublishActionPart.getActivity().getIntent();
                    Intrinsics.checkNotNullExpressionValue(intent, "activity.intent");
                    return com.tencent.mobileqq.flock.publish.a.f(flockPublishActionPart, intent);
                }
            });
            this.uiViewModel = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.flock.publish.viewmodel.b>() { // from class: com.tencent.mobileqq.flock.publish.part.FlockPublishActionPart$galleryViewModel$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FlockPublishActionPart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final com.tencent.mobileqq.flock.publish.viewmodel.b invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (com.tencent.mobileqq.flock.publish.viewmodel.b) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    FlockPublishActionPart flockPublishActionPart = FlockPublishActionPart.this;
                    Intent intent = flockPublishActionPart.getActivity().getIntent();
                    Intrinsics.checkNotNullExpressionValue(intent, "activity.intent");
                    return com.tencent.mobileqq.flock.publish.a.b(flockPublishActionPart, intent);
                }
            });
            this.galleryViewModel = lazy2;
            lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.flock.publish.viewmodel.f>() { // from class: com.tencent.mobileqq.flock.publish.part.FlockPublishActionPart$publishSendViewModel$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FlockPublishActionPart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final com.tencent.mobileqq.flock.publish.viewmodel.f invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (com.tencent.mobileqq.flock.publish.viewmodel.f) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    FlockPublishActionPart flockPublishActionPart = FlockPublishActionPart.this;
                    Intent intent = flockPublishActionPart.getActivity().getIntent();
                    Intrinsics.checkNotNullExpressionValue(intent, "activity.intent");
                    return com.tencent.mobileqq.flock.publish.a.e(flockPublishActionPart, intent);
                }
            });
            this.publishSendViewModel = lazy3;
            lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<Dialog>() { // from class: com.tencent.mobileqq.flock.publish.part.FlockPublishActionPart$dialog$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FlockPublishActionPart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Dialog invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? LoadingUtil.showLoadingDialog(FlockPublishActionPart.this.getContext(), "\u53d1\u5e03\u4e2d", false) : (Dialog) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.dialog = lazy4;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Dialog F9() {
        return (Dialog) this.dialog.getValue();
    }

    private final com.tencent.mobileqq.flock.publish.viewmodel.b G9() {
        return (com.tencent.mobileqq.flock.publish.viewmodel.b) this.galleryViewModel.getValue();
    }

    private final int H9() {
        return Intrinsics.areEqual(J9().d2().getValue(), Boolean.TRUE) ? 1 : 0;
    }

    private final com.tencent.mobileqq.flock.publish.viewmodel.f I9() {
        return (com.tencent.mobileqq.flock.publish.viewmodel.f) this.publishSendViewModel.getValue();
    }

    private final FlockPublishUIStateViewModel J9() {
        return (FlockPublishUIStateViewModel) this.uiViewModel.getValue();
    }

    private final void K9() {
        LiveData<f.b> l26 = I9().l2();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<f.b, Unit> function1 = new Function1<f.b, Unit>() { // from class: com.tencent.mobileqq.flock.publish.part.FlockPublishActionPart$observerData$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) FlockPublishActionPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(f.b bVar) {
                invoke2(bVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(f.b bVar) {
                Dialog F9;
                Dialog F92;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar);
                    return;
                }
                QLog.d("FlockPublishActionPart", 1, "observerData... receive finish... isSuccess:" + bVar.f() + " retCode:" + bVar.d());
                F9 = FlockPublishActionPart.this.F9();
                if (F9.isShowing()) {
                    F92 = FlockPublishActionPart.this.F9();
                    F92.dismiss();
                }
                if (bVar.f() && bVar.d() == 0) {
                    if (bVar.e()) {
                        QQToastUtil.showQQToast(2, "\u7f16\u8f91\u6210\u529f");
                    } else if (bVar.c() != 0 && bVar.c() != 1 && bVar.c() != 4) {
                        QQToastUtil.showQQToast(2, "\u53d1\u5e03\u6210\u529f\uff0c\u53ef\u5728\u201c\u6211\u7684\u201d\u9875\u67e5\u770b");
                    } else {
                        QQToastUtil.showQQToast(2, "\u53d1\u5e03\u6210\u529f");
                    }
                    SimpleEventBus.getInstance().dispatchEvent(new FlockPublishFinishEvent(bVar.b(), bVar.e()));
                    FlockPublishActionPart.this.getActivity().finish();
                    return;
                }
                if (bVar.d() == 20007) {
                    FlockPublishActionPart.this.Q9(CreateTroopUnblockType.TIME);
                    return;
                }
                if (bVar.d() == 20008) {
                    FlockPublishActionPart.this.Q9(CreateTroopUnblockType.FACE);
                    return;
                }
                if (bVar.d() >= 20000) {
                    QQToastUtil.showQQToast(1, bVar.a());
                    FlockPublishActionPart.this.getActivity().finish();
                } else if (bVar.d() != -999999 && bVar.d() != WinkBaseErrorCodeKt.ERROR_REQUEST_TIMEOUT) {
                    QQToastUtil.showQQToast(1, "\u53d1\u5e03\u5931\u8d25\uff0c\u8bf7\u91cd\u8bd5");
                } else {
                    QQToastUtil.showQQToast(1, bVar.a());
                }
            }
        };
        l26.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.flock.publish.part.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FlockPublishActionPart.L9(Function1.this, obj);
            }
        });
        LiveData<Pair<Boolean, String>> g26 = I9().g2();
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final FlockPublishActionPart$observerData$2 flockPublishActionPart$observerData$2 = new FlockPublishActionPart$observerData$2(this);
        g26.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.flock.publish.part.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FlockPublishActionPart.M9(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O9(FlockPublishActionPart this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.I9().c2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P9(View view) {
        String str;
        String str2;
        Map mutableMapOf;
        if (!J9().S1()) {
            return;
        }
        y45.b f26 = J9().f2();
        Pair[] pairArr = new Pair[6];
        pairArr[0] = TuplesKt.to("activity_name", f26.f449371f);
        y45.l lVar = f26.f449376k;
        String str3 = null;
        if (lVar != null) {
            str = lVar.f449420b;
        } else {
            str = null;
        }
        String str4 = "";
        if (str == null) {
            str = "";
        }
        pairArr[1] = TuplesKt.to("activity_location", str);
        pairArr[2] = TuplesKt.to("is_select_public_distribution", Integer.valueOf(H9()));
        y45.a aVar = f26.f449374i;
        if (aVar != null) {
            str2 = Long.valueOf(aVar.f449361a).toString();
        } else {
            str2 = null;
        }
        pairArr[3] = TuplesKt.to("activity_start_time", str2);
        y45.a aVar2 = f26.f449374i;
        if (aVar2 != null) {
            str3 = Long.valueOf(aVar2.f449362b).toString();
        }
        pairArr[4] = TuplesKt.to("activity_end_time", str3);
        String b16 = com.tencent.mobileqq.flock.ktx.e.b(f26);
        if (b16 != null) {
            str4 = b16;
        }
        pairArr[5] = TuplesKt.to("activity_topic", str4);
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        VideoReport.setElementParams(view, mutableMapOf);
        I9().q2(G9().Q1(), f26);
        F9().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q9(CreateTroopUnblockType type) {
        QLog.i("FlockPublishActionPart", 1, "[showCreateTroopSecurityDialog] start. use local default params");
        com.tencent.mobileqq.troop.createtroopblacklist.api.a aVar = new com.tencent.mobileqq.troop.createtroopblacklist.api.a(null, null, null, null, null, null, null, 127, null);
        aVar.g(type);
        ((ICreateTroopBlackListUtilApi) QRoute.api(ICreateTroopBlackListUtilApi.class)).showCreateTroopSecurityDialog(getActivity(), aVar);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        final View onInitView$lambda$1 = rootView.findViewById(R.id.vbj);
        LiveData<Boolean> e26 = J9().e2();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>(onInitView$lambda$1) { // from class: com.tencent.mobileqq.flock.publish.part.FlockPublishActionPart$onInitView$1$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ View $this_with;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$this_with = onInitView$lambda$1;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) onInitView$lambda$1);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean it) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                View view = this.$this_with;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                view.setEnabled(it.booleanValue());
            }
        };
        e26.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.flock.publish.part.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FlockPublishActionPart.N9(Function1.this, obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(onInitView$lambda$1, "onInitView$lambda$1");
        com.tencent.mobileqq.flock.ktx.i.d(onInitView$lambda$1, 0L, new Function1<View, Unit>(onInitView$lambda$1) { // from class: com.tencent.mobileqq.flock.publish.part.FlockPublishActionPart$onInitView$1$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ View $this_with;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$this_with = onInitView$lambda$1;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FlockPublishActionPart.this, (Object) onInitView$lambda$1);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View it) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                } else {
                    Intrinsics.checkNotNullParameter(it, "it");
                    FlockPublishActionPart.this.P9(this.$this_with);
                }
            }
        }, 1, null);
        VideoReport.setElementId(onInitView$lambda$1, "em_bas_search_partner_publish");
        F9().setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.tencent.mobileqq.flock.publish.part.b
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                FlockPublishActionPart.O9(FlockPublishActionPart.this, dialogInterface);
            }
        });
        K9();
        I9().h2();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity);
        } else {
            super.onPartDestroy(activity);
            I9().onDestroy();
        }
    }
}
