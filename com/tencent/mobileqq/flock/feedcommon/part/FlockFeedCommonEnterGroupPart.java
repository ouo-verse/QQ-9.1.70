package com.tencent.mobileqq.flock.feedcommon.part;

import android.app.Activity;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.flock.ktx.e;
import com.tencent.mobileqq.flock.utils.FlockJumpHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.util.QQToastUtil;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import y45.k;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 !2\u00020\u0001:\u0001\"B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\u000b\u001a\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\tH\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\u001c\u0010\u0012\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010\u0015\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016R#\u0010\u001c\u001a\n \u0017*\u0004\u0018\u00010\u00160\u00168BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/flock/feedcommon/part/FlockFeedCommonEnterGroupPart;", "Lcom/tencent/mobileqq/flock/base/b;", "Lcom/tencent/mobileqq/flock/feedcommon/part/a;", "enterGroupBean", "", "I9", "F9", "J9", "E9", "Lcom/tencent/richframework/data/base/UIStateData;", "it", "H9", "L9", "D9", "", "action", "", "args", "handleBroadcastMessage", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lcom/tencent/mobileqq/flock/feeddetail/viewmodel/b;", "kotlin.jvm.PlatformType", "d", "Lkotlin/Lazy;", "G9", "()Lcom/tencent/mobileqq/flock/feeddetail/viewmodel/b;", "vm", "e", "Lcom/tencent/mobileqq/flock/feedcommon/part/a;", "<init>", "()V", "f", "a", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class FlockFeedCommonEnterGroupPart extends com.tencent.mobileqq.flock.base.b {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy vm;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private a enterGroupBean;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/flock/feedcommon/part/FlockFeedCommonEnterGroupPart$a;", "", "", "ACTION_MSG_JOIN_GROUP", "Ljava/lang/String;", "TAG", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.flock.feedcommon.part.FlockFeedCommonEnterGroupPart$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24945);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public FlockFeedCommonEnterGroupPart() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.flock.feeddetail.viewmodel.b>() { // from class: com.tencent.mobileqq.flock.feedcommon.part.FlockFeedCommonEnterGroupPart$vm$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FlockFeedCommonEnterGroupPart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final com.tencent.mobileqq.flock.feeddetail.viewmodel.b invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (com.tencent.mobileqq.flock.feeddetail.viewmodel.b) FlockFeedCommonEnterGroupPart.this.getViewModel(com.tencent.mobileqq.flock.feeddetail.viewmodel.b.class) : (com.tencent.mobileqq.flock.feeddetail.viewmodel.b) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.vm = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void D9() {
        broadcastMessage("ACTION_MSG_HIDE_LOADING", null);
    }

    private final void E9(a enterGroupBean) {
        QLog.i("FlockFeedCommonEnterGroupPart", 1, "doEnterGroup");
        String valueOf = String.valueOf(enterGroupBean.a().f449367b);
        byte[] bArr = enterGroupBean.a().f449381p;
        Intrinsics.checkNotNullExpressionValue(bArr, "enterGroupBean.feed.joinGroupAuthsig");
        com.tencent.mobileqq.troop.troopjoin.a aVar = new com.tencent.mobileqq.troop.troopjoin.a(valueOf, new String(bArr, Charsets.UTF_8), enterGroupBean.b(), false, null, false, 56, null);
        FlockJumpHelper.Companion companion = FlockJumpHelper.INSTANCE;
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        FlockJumpHelper.Companion.d(companion, activity, aVar, enterGroupBean.a().f449382q, false, FlockFeedCommonEnterGroupPart$doEnterGroup$1.INSTANCE, 8, null);
    }

    private final void F9(a enterGroupBean) {
        QLog.i("FlockFeedCommonEnterGroupPart", 1, "doJoinGroup");
        this.enterGroupBean = enterGroupBean;
        G9().N1(enterGroupBean.a());
    }

    private final com.tencent.mobileqq.flock.feeddetail.viewmodel.b G9() {
        return (com.tencent.mobileqq.flock.feeddetail.viewmodel.b) this.vm.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H9(UIStateData<Unit> it) {
        D9();
        QQToastUtil.showQQToast(1, it.getMsg());
    }

    private final void I9(a enterGroupBean) {
        k kVar = enterGroupBean.a().f449379n;
        boolean z16 = false;
        if (kVar != null && e.h(kVar)) {
            z16 = true;
        }
        if (z16) {
            E9(enterGroupBean);
        } else {
            F9(enterGroupBean);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J9(a enterGroupBean) {
        D9();
        E9(enterGroupBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L9() {
        broadcastMessage("ACTION_MSG_SHOW_LOADING", null);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) action, args);
        } else if (Intrinsics.areEqual(action, "ACTION_MSG_JOIN_GROUP") && (args instanceof a)) {
            I9((a) args);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        LiveData<UIStateData<Unit>> M1 = G9().M1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<UIStateData<Unit>, Unit> function1 = new Function1<UIStateData<Unit>, Unit>() { // from class: com.tencent.mobileqq.flock.feedcommon.part.FlockFeedCommonEnterGroupPart$onInitView$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FlockFeedCommonEnterGroupPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UIStateData<Unit> uIStateData) {
                invoke2(uIStateData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(UIStateData<Unit> it) {
                a aVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                int state = it.getState();
                if (state == 1) {
                    FlockFeedCommonEnterGroupPart.this.L9();
                    return;
                }
                if (state != 3) {
                    if (state != 4) {
                        return;
                    }
                    FlockFeedCommonEnterGroupPart flockFeedCommonEnterGroupPart = FlockFeedCommonEnterGroupPart.this;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    flockFeedCommonEnterGroupPart.H9(it);
                    return;
                }
                QLog.i("FlockFeedCommonEnterGroupPart", 1, "handleSuccessState\uff1a");
                FlockFeedCommonEnterGroupPart flockFeedCommonEnterGroupPart2 = FlockFeedCommonEnterGroupPart.this;
                aVar = flockFeedCommonEnterGroupPart2.enterGroupBean;
                if (aVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("enterGroupBean");
                    aVar = null;
                }
                flockFeedCommonEnterGroupPart2.J9(aVar);
            }
        };
        M1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.flock.feedcommon.part.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FlockFeedCommonEnterGroupPart.K9(Function1.this, obj);
            }
        });
    }
}
