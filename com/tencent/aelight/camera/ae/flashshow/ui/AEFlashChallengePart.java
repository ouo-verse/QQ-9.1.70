package com.tencent.aelight.camera.ae.flashshow.ui;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.ae.flashshow.AEFlashShowCameraUnit;
import com.tencent.aelight.camera.ae.flashshow.ui.AEFlashShowMaterialManager;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.wink.model.InteractiveModel;
import com.tencent.mobileqq.wink.tag.TagRetriever;
import com.tencent.mobileqq.wink.view.InteractiveFrameLayout;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 82\u00020\u0001:\u00019B\u001f\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u0012\u0006\u0010\u001b\u001a\u00020\u0016\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u00a2\u0006\u0004\b6\u00107J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0014J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J8\u0010\u000e\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\b2\u0006\u0010\n\u001a\u00020\t2\u0016\u0010\r\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\f0\u000b\"\u0004\u0018\u00010\fH\u0096\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0015\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u001b\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010-\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010\u0018R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b3\u00104\u00a8\u0006:"}, d2 = {"Lcom/tencent/aelight/camera/ae/flashshow/ui/AEFlashChallengePart;", "Llq/a;", "", ReportConstant.COSTREPORT_PREFIX, "p", "e", tl.h.F, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "T", "", "action", "", "", "args", "d", "(I[Ljava/lang/Object;)Ljava/lang/Object;", "Landroid/app/Activity;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/app/Activity;", "getMActivity", "()Landroid/app/Activity;", "mActivity", "Landroid/view/View;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", "getMRootView", "()Landroid/view/View;", "mRootView", "Llq/b;", "D", "Llq/b;", "mPartManger", "Lcom/tencent/aelight/camera/ae/flashshow/AEFlashShowCameraUnit;", "E", "Lcom/tencent/aelight/camera/ae/flashshow/AEFlashShowCameraUnit;", "mUnit", "Lcom/tencent/aelight/camera/ae/flashshow/ui/aa;", UserInfo.SEX_FEMALE, "Lcom/tencent/aelight/camera/ae/flashshow/ui/aa;", "challengeViewModel", "Lcom/tencent/mobileqq/wink/view/InteractiveFrameLayout;", "G", "Lcom/tencent/mobileqq/wink/view/InteractiveFrameLayout;", "interactiveFrameLayout", "H", "customView", "Landroid/widget/TextView;", "I", "Landroid/widget/TextView;", "textView", "Lcom/tencent/aelight/camera/ae/flashshow/ui/AEFlashShowMaterialManager;", "J", "Lcom/tencent/aelight/camera/ae/flashshow/ui/AEFlashShowMaterialManager;", "mTemplateManager", "<init>", "(Landroid/app/Activity;Landroid/view/View;Llq/b;)V", "K", "a", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class AEFlashChallengePart extends lq.a {

    /* renamed from: C, reason: from kotlin metadata */
    private final View mRootView;

    /* renamed from: D, reason: from kotlin metadata */
    private final lq.b mPartManger;

    /* renamed from: E, reason: from kotlin metadata */
    private AEFlashShowCameraUnit mUnit;

    /* renamed from: F, reason: from kotlin metadata */
    private aa challengeViewModel;

    /* renamed from: G, reason: from kotlin metadata */
    private InteractiveFrameLayout interactiveFrameLayout;

    /* renamed from: H, reason: from kotlin metadata */
    private View customView;

    /* renamed from: I, reason: from kotlin metadata */
    private TextView textView;

    /* renamed from: J, reason: from kotlin metadata */
    private AEFlashShowMaterialManager mTemplateManager;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final Activity mActivity;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AEFlashChallengePart(Activity mActivity, View mRootView, lq.b mPartManger) {
        super(mActivity, mRootView, mPartManger);
        Intrinsics.checkNotNullParameter(mActivity, "mActivity");
        Intrinsics.checkNotNullParameter(mRootView, "mRootView");
        Intrinsics.checkNotNullParameter(mPartManger, "mPartManger");
        this.mActivity = mActivity;
        this.mRootView = mRootView;
        this.mPartManger = mPartManger;
        Object b16 = mPartManger.b(65537, new Object[0]);
        Intrinsics.checkNotNullExpressionValue(b16, "mPartManger.get<AEFlashS\u2026.MANAGER_GET_ACTION_UNIT)");
        this.mUnit = (AEFlashShowCameraUnit) b16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void s() {
        View inflate;
        ViewStub viewStub = (ViewStub) this.f415376e.findViewById(R.id.rqw);
        if (this.interactiveFrameLayout == null) {
            this.interactiveFrameLayout = (InteractiveFrameLayout) viewStub.inflate().findViewById(R.id.xpb);
            if (z73.a.f452126a.a()) {
                inflate = LayoutInflater.from(this.f415377f).inflate(R.layout.f168933hd4, (ViewGroup) this.interactiveFrameLayout, false);
                Intrinsics.checkNotNullExpressionValue(inflate, "{\n                Layout\u2026out, false)\n            }");
            } else {
                inflate = LayoutInflater.from(this.f415377f).inflate(R.layout.f168932hd3, (ViewGroup) this.interactiveFrameLayout, false);
                Intrinsics.checkNotNullExpressionValue(inflate, "{\n                Layout\u2026out, false)\n            }");
            }
            this.customView = inflate;
            View view = null;
            if (inflate == null) {
                Intrinsics.throwUninitializedPropertyAccessException("customView");
                inflate = null;
            }
            View findViewById = inflate.findViewById(R.id.f164762tr2);
            Intrinsics.checkNotNullExpressionValue(findViewById, "customView.findViewById(\u2026ink.R.id.challenge_topic)");
            this.textView = (TextView) findViewById;
            InteractiveFrameLayout interactiveFrameLayout = this.interactiveFrameLayout;
            Intrinsics.checkNotNull(interactiveFrameLayout);
            View view2 = this.customView;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("customView");
            } else {
                view = view2;
            }
            interactiveFrameLayout.K(view);
            InteractiveFrameLayout interactiveFrameLayout2 = this.interactiveFrameLayout;
            Intrinsics.checkNotNull(interactiveFrameLayout2);
            interactiveFrameLayout2.setVisibility(8);
            InteractiveFrameLayout interactiveFrameLayout3 = this.interactiveFrameLayout;
            Intrinsics.checkNotNull(interactiveFrameLayout3);
            interactiveFrameLayout3.setOnCenterViewClick(new b());
        }
    }

    @Override // lq.a
    public <T> T d(int action, Object... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        if (action == 1114113) {
            InteractiveFrameLayout interactiveFrameLayout = this.interactiveFrameLayout;
            T t16 = interactiveFrameLayout != null ? (T) interactiveFrameLayout.H() : null;
            if (t16 == null) {
                t16 = null;
            }
            if (t16 == null) {
                return null;
            }
            return t16;
        }
        return (T) super.d(action, Arrays.copyOf(args, args.length));
    }

    @Override // lq.a
    protected void e() {
        if (this.f415376e == null) {
            return;
        }
        s();
        p();
    }

    @Override // lq.a
    public void h() {
        super.h();
        if (com.tencent.mobileqq.wink.model.b.isShowChallengeFromCapture.getSecond().booleanValue()) {
            return;
        }
        InteractiveFrameLayout interactiveFrameLayout = this.interactiveFrameLayout;
        if (interactiveFrameLayout != null) {
            interactiveFrameLayout.G();
        }
        InteractiveFrameLayout interactiveFrameLayout2 = this.interactiveFrameLayout;
        if (interactiveFrameLayout2 == null) {
            return;
        }
        interactiveFrameLayout2.setVisibility(8);
    }

    @Override // lq.a
    public void onDestroy() {
        super.onDestroy();
        AEFlashShowMaterialManager aEFlashShowMaterialManager = this.mTemplateManager;
        if (aEFlashShowMaterialManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTemplateManager");
            aEFlashShowMaterialManager = null;
        }
        aEFlashShowMaterialManager.c0(113);
    }

    private final void p() {
        com.tencent.aelight.camera.ae.control.b b16 = com.tencent.aelight.camera.ae.control.a.b(3);
        Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type com.tencent.aelight.camera.ae.flashshow.ui.AEFlashShowMaterialManager");
        AEFlashShowMaterialManager aEFlashShowMaterialManager = (AEFlashShowMaterialManager) b16;
        this.mTemplateManager = aEFlashShowMaterialManager;
        aa aaVar = null;
        if (aEFlashShowMaterialManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTemplateManager");
            aEFlashShowMaterialManager = null;
        }
        aEFlashShowMaterialManager.p(new yq2.c() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.a
            @Override // yq2.c
            public final void notify(Object obj, int i3, Object[] objArr) {
                AEFlashChallengePart.q(AEFlashChallengePart.this, obj, i3, objArr);
            }
        }, 113);
        ViewModel viewModel = com.tencent.aelight.camera.ae.n.a(this.mUnit).get(aa.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "of(mUnit).get(\n         \u2026del::class.java\n        )");
        aa aaVar2 = (aa) viewModel;
        this.challengeViewModel = aaVar2;
        if (aaVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("challengeViewModel");
            aaVar2 = null;
        }
        LiveData<InteractiveModel> L1 = aaVar2.L1();
        AEFlashShowCameraUnit aEFlashShowCameraUnit = this.mUnit;
        final Function1<InteractiveModel, Unit> function1 = new Function1<InteractiveModel, Unit>() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.AEFlashChallengePart$initViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InteractiveModel interactiveModel) {
                invoke2(interactiveModel);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InteractiveModel interactiveModel) {
                InteractiveFrameLayout interactiveFrameLayout;
                InteractiveFrameLayout interactiveFrameLayout2;
                InteractiveFrameLayout interactiveFrameLayout3;
                InteractiveFrameLayout interactiveFrameLayout4;
                Unit unit = null;
                if (interactiveModel != null) {
                    AEFlashChallengePart aEFlashChallengePart = AEFlashChallengePart.this;
                    interactiveFrameLayout3 = aEFlashChallengePart.interactiveFrameLayout;
                    if (interactiveFrameLayout3 != null) {
                        interactiveFrameLayout3.setVisibility(0);
                    }
                    com.tencent.mobileqq.wink.model.b.isShowChallengeFromCapture = new Pair<>(interactiveModel.getTagName(), Boolean.TRUE);
                    interactiveFrameLayout4 = aEFlashChallengePart.interactiveFrameLayout;
                    if (interactiveFrameLayout4 != null) {
                        interactiveFrameLayout4.b0(interactiveModel, true);
                        unit = Unit.INSTANCE;
                    }
                }
                if (unit == null) {
                    AEFlashChallengePart aEFlashChallengePart2 = AEFlashChallengePart.this;
                    com.tencent.mobileqq.wink.model.b.isShowChallengeFromCapture = new Pair<>("", Boolean.FALSE);
                    interactiveFrameLayout = aEFlashChallengePart2.interactiveFrameLayout;
                    if (interactiveFrameLayout != null) {
                        interactiveFrameLayout.G();
                    }
                    interactiveFrameLayout2 = aEFlashChallengePart2.interactiveFrameLayout;
                    if (interactiveFrameLayout2 == null) {
                        return;
                    }
                    interactiveFrameLayout2.setVisibility(8);
                }
            }
        };
        L1.observe(aEFlashShowCameraUnit, new Observer() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AEFlashChallengePart.r(Function1.this, obj);
            }
        });
        aa aaVar3 = this.challengeViewModel;
        if (aaVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("challengeViewModel");
        } else {
            aaVar = aaVar3;
        }
        aaVar.M1(this.f415377f.getIntent());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void q(AEFlashChallengePart this$0, Object obj, int i3, Object[] objArr) {
        boolean z16;
        Unit unit;
        String str;
        boolean isBlank;
        boolean isBlank2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 != 113 || !com.tencent.mobileqq.wink.model.b.f324006a.d()) {
            return;
        }
        String i16 = TagRetriever.f326413a.i(this$0.f415377f.getIntent());
        if (i16 != null) {
            isBlank2 = StringsKt__StringsJVMKt.isBlank(i16);
            if (!isBlank2) {
                z16 = false;
                if (z16) {
                    return;
                }
                AEFlashShowMaterialManager.Companion companion = AEFlashShowMaterialManager.INSTANCE;
                AEMaterialMetaData c16 = companion.c();
                if (c16 == null || (str = c16.challengeTopic) == null) {
                    unit = null;
                } else {
                    isBlank = StringsKt__StringsJVMKt.isBlank(str);
                    if (!isBlank) {
                        AEMaterialMetaData c17 = companion.c();
                        InteractiveModel interactiveModel = new InteractiveModel(0.0f, 0.0f, 0.0f, 0.0f, str, c17 != null ? c17.challengeJoinsNums : 0L, 15, null);
                        aa aaVar = this$0.challengeViewModel;
                        if (aaVar == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("challengeViewModel");
                            aaVar = null;
                        }
                        aaVar.N1(interactiveModel);
                    } else {
                        com.tencent.xaction.log.b.a("AEFlashChallengePart", 1, "addAdapterObserver... challengeTopic is empty");
                        aa aaVar2 = this$0.challengeViewModel;
                        if (aaVar2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("challengeViewModel");
                            aaVar2 = null;
                        }
                        aaVar2.N1(null);
                    }
                    unit = Unit.INSTANCE;
                }
                if (unit == null) {
                    com.tencent.xaction.log.b.a("AEFlashChallengePart", 1, "addAdapterObserver... challengeTopic is null");
                    aa aaVar3 = this$0.challengeViewModel;
                    if (aaVar3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("challengeViewModel");
                        aaVar3 = null;
                    }
                    aaVar3.N1(null);
                    return;
                }
                return;
            }
        }
        z16 = true;
        if (z16) {
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/aelight/camera/ae/flashshow/ui/AEFlashChallengePart$b", "Lcom/tencent/mobileqq/wink/view/InteractiveFrameLayout$d;", "Lcom/tencent/mobileqq/wink/model/InteractiveModel;", "model", "", "b", "c", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class b implements InteractiveFrameLayout.d {
        b() {
        }

        @Override // com.tencent.mobileqq.wink.view.InteractiveFrameLayout.d
        public void a() {
            InteractiveFrameLayout.d.a.a(this);
        }

        @Override // com.tencent.mobileqq.wink.view.InteractiveFrameLayout.d
        public void c(InteractiveModel model) {
            com.tencent.mobileqq.wink.model.b.isShowChallengeFromCapture = new Pair<>("", Boolean.FALSE);
        }

        @Override // com.tencent.mobileqq.wink.view.InteractiveFrameLayout.d
        public void d(InteractiveModel interactiveModel) {
            InteractiveFrameLayout.d.a.b(this, interactiveModel);
        }

        @Override // com.tencent.mobileqq.wink.view.InteractiveFrameLayout.d
        public void b(InteractiveModel model) {
        }
    }
}
