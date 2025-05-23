package com.tencent.mobileqq.aio.robot.inputbar;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.mobileqq.aio.input.AIOInputExpandableVB;
import com.tencent.mobileqq.aio.input.AIOInputUIState;
import com.tencent.mobileqq.aio.input.AIOInputUtil;
import com.tencent.mobileqq.aio.input.blockstate.GroupBlockInputVB;
import com.tencent.mobileqq.aio.input.communicationshare.CommunicationShareBarVB;
import com.tencent.mobileqq.aio.input.f;
import com.tencent.mobileqq.aio.input.longshot.LongShotBarVB;
import com.tencent.mobileqq.aio.robot.inputbar.RobotInputUIState;
import com.tencent.mobileqq.aio.robot.multiselect.RobotMultiSelectBarVB;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qui.QUIImmersiveHelper;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.ITroopApi;
import com.tencent.qqnt.robot.api.IRobotShareMultiSelectBarApi;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.HashSet;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 d2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001eB\u001d\u0012\n\u0010`\u001a\u0006\u0012\u0002\b\u00030_\u0012\b\b\u0002\u0010a\u001a\u00020\u000f\u00a2\u0006\u0004\bb\u0010cJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0012\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001a\u0010\r\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u000fH\u0002J\b\u0010\u0013\u001a\u00020\u0006H\u0002J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u000fH\u0002J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J&\u0010\u001e\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\b\u0001\u0012\u00020\u001c\u0012\u0006\b\u0001\u0012\u00020\u001d0\u00010\u001b2\u0006\u0010\u001a\u001a\u00020\u0018H\u0016J\u0014\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u001fH\u0016J\b\u0010!\u001a\u00020\u0006H\u0016J\b\u0010\"\u001a\u00020\u0006H\u0016J\u0010\u0010$\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u0003H\u0016J\u0006\u0010%\u001a\u00020\u0004J\u0006\u0010&\u001a\u00020\u0004R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010-\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010/\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010,R\u0016\u00101\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010,R\u0016\u00104\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00106\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u0010,R\u0016\u00108\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u0010,R+\u0010=\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020\u001c\u0012\u0006\b\u0001\u0012\u00020\u001d0\u00018BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R+\u0010@\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020\u001c\u0012\u0006\b\u0001\u0012\u00020\u001d0\u00018BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b>\u0010:\u001a\u0004\b?\u0010<R\u001b\u0010E\u001a\u00020A8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bB\u0010:\u001a\u0004\bC\u0010DR\u001b\u0010J\u001a\u00020F8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bG\u0010:\u001a\u0004\bH\u0010IR\u001b\u0010O\u001a\u00020K8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bL\u0010:\u001a\u0004\bM\u0010NR+\u0010R\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020\u001c\u0012\u0006\b\u0001\u0012\u00020\u001d0\u00018BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bP\u0010:\u001a\u0004\bQ\u0010<R'\u0010U\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00018BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bS\u0010:\u001a\u0004\bT\u0010<R;\u0010[\u001a\"\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00010Vj\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0001`W8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bX\u0010:\u001a\u0004\bY\u0010ZR\u0016\u0010]\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010,R\u0016\u0010\u0014\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010,\u00a8\u0006f"}, d2 = {"Lcom/tencent/mobileqq/aio/robot/inputbar/RobotAIOInputContainerVB;", "Lcom/tencent/aio/base/mvvm/a;", "Lat/a;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "", "visibility", "", "v1", "r1", "", "source", "d1", "u1", "w1", ICustomDataEditor.STRING_PARAM_1, "", "q1", "show", "y1", "z1", OpenHippyInfo.EXTRA_KEY_IS_FULL_SCREEN, "o1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "hostView", "", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "initializeChildVB", "Lcom/tencent/aio/base/mvvm/b;", "e1", "bindViewAndData", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "state", "p1", "getInputBarHeight", "g1", "Landroid/widget/RelativeLayout;", "d", "Landroid/widget/RelativeLayout;", "mInputContainer", "e", "Z", "isLongShotMode", "f", "isCommunicationShareMode", h.F, "isMultiSelectMode", "i", "Ljava/lang/String;", "multiSelectSource", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "isAiVoiceChatMode", BdhLogUtil.LogTag.Tag_Conn, "isTroopBlockMode", "D", "Lkotlin/Lazy;", "m1", "()Lcom/tencent/aio/base/mvvm/a;", "mMultiSelectBar", "E", ICustomDataEditor.NUMBER_PARAM_1, "mShareViewVB", "Lcom/tencent/mobileqq/aio/input/communicationshare/CommunicationShareBarVB;", UserInfo.SEX_FEMALE, "i1", "()Lcom/tencent/mobileqq/aio/input/communicationshare/CommunicationShareBarVB;", "mCommunicationShareBar", "Lcom/tencent/mobileqq/aio/input/blockstate/GroupBlockInputVB;", "G", "j1", "()Lcom/tencent/mobileqq/aio/input/blockstate/GroupBlockInputVB;", "mGroupBlockInputVB", "Lcom/tencent/mobileqq/aio/input/longshot/LongShotBarVB;", "H", "l1", "()Lcom/tencent/mobileqq/aio/input/longshot/LongShotBarVB;", "mLongShotBar", "I", "f1", "aiVoiceChatBar", "J", "k1", "mInputBar", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "K", "h1", "()Ljava/util/HashSet;", "mChildVb", "L", "destoryed", "M", "Lcom/tencent/mobileqq/aio/input/adorn/a;", "inputBarAdornApi", "enableExpandable", "<init>", "(Lcom/tencent/mobileqq/aio/input/adorn/a;Z)V", "N", "a", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class RobotAIOInputContainerVB extends com.tencent.aio.base.mvvm.a<at.a, InputUIState> {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean isTroopBlockMode;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy mMultiSelectBar;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy mShareViewVB;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy mCommunicationShareBar;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy mGroupBlockInputVB;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Lazy mLongShotBar;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Lazy aiVoiceChatBar;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Lazy mInputBar;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final Lazy mChildVb;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean destoryed;

    /* renamed from: M, reason: from kotlin metadata */
    private boolean isFullScreen;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private RelativeLayout mInputContainer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isLongShotMode;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isCommunicationShareMode;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isMultiSelectMode;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String multiSelectSource;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isAiVoiceChatMode;

    public RobotAIOInputContainerVB(@NotNull final com.tencent.mobileqq.aio.input.adorn.a<?> inputBarAdornApi, final boolean z16) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Lazy lazy6;
        Lazy lazy7;
        Lazy lazy8;
        Intrinsics.checkNotNullParameter(inputBarAdornApi, "inputBarAdornApi");
        this.multiSelectSource = "";
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<RobotMultiSelectBarVB>() { // from class: com.tencent.mobileqq.aio.robot.inputbar.RobotAIOInputContainerVB$mMultiSelectBar$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final RobotMultiSelectBarVB invoke() {
                return new RobotMultiSelectBarVB();
            }
        });
        this.mMultiSelectBar = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState>>() { // from class: com.tencent.mobileqq.aio.robot.inputbar.RobotAIOInputContainerVB$mShareViewVB$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState> invoke() {
                return ((IRobotShareMultiSelectBarApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IRobotShareMultiSelectBarApi.class)).getRobotShareMultiSelectBar();
            }
        });
        this.mShareViewVB = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<CommunicationShareBarVB>() { // from class: com.tencent.mobileqq.aio.robot.inputbar.RobotAIOInputContainerVB$mCommunicationShareBar$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final CommunicationShareBarVB invoke() {
                return new CommunicationShareBarVB();
            }
        });
        this.mCommunicationShareBar = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<GroupBlockInputVB>() { // from class: com.tencent.mobileqq.aio.robot.inputbar.RobotAIOInputContainerVB$mGroupBlockInputVB$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GroupBlockInputVB invoke() {
                return new GroupBlockInputVB();
            }
        });
        this.mGroupBlockInputVB = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<LongShotBarVB>() { // from class: com.tencent.mobileqq.aio.robot.inputbar.RobotAIOInputContainerVB$mLongShotBar$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final LongShotBarVB invoke() {
                return new LongShotBarVB();
            }
        });
        this.mLongShotBar = lazy5;
        lazy6 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState>>() { // from class: com.tencent.mobileqq.aio.robot.inputbar.RobotAIOInputContainerVB$aiVoiceChatBar$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState> invoke() {
                return ((ITroopApi) QRoute.api(ITroopApi.class)).getAIVoiceChatVB();
            }
        });
        this.aiVoiceChatBar = lazy6;
        lazy7 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.aio.base.mvvm.a<at.a, InputUIState>>() { // from class: com.tencent.mobileqq.aio.robot.inputbar.RobotAIOInputContainerVB$mInputBar$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.aio.base.mvvm.a<at.a, InputUIState> invoke() {
                if (z16) {
                    return new AIOInputExpandableVB(inputBarAdornApi);
                }
                return new com.tencent.mobileqq.aio.input.inputbar.a(inputBarAdornApi);
            }
        });
        this.mInputBar = lazy7;
        lazy8 = LazyKt__LazyJVMKt.lazy(new Function0<HashSet<com.tencent.aio.base.mvvm.a<?, ?>>>() { // from class: com.tencent.mobileqq.aio.robot.inputbar.RobotAIOInputContainerVB$mChildVb$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final HashSet<com.tencent.aio.base.mvvm.a<?, ?>> invoke() {
                com.tencent.aio.base.mvvm.a<?, ?> k16;
                HashSet<com.tencent.aio.base.mvvm.a<?, ?>> hashSet = new HashSet<>();
                k16 = RobotAIOInputContainerVB.this.k1();
                hashSet.add(k16);
                return hashSet;
            }
        });
        this.mChildVb = lazy8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A1(RobotAIOInputContainerVB this$0) {
        QBaseActivity qBaseActivity;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.destoryed && (qBaseActivity = QBaseActivity.sTopActivity) != null) {
            QUIImmersiveHelper.s(qBaseActivity, false, true);
        }
    }

    private final void d1(String source) {
        if (q1(source)) {
            if (!h1().contains(n1())) {
                addChildVB(n1());
                h1().add(n1());
                return;
            }
            return;
        }
        if (!h1().contains(m1())) {
            addChildVB(m1());
            h1().add(m1());
        }
    }

    private final com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState> f1() {
        return (com.tencent.aio.base.mvvm.a) this.aiVoiceChatBar.getValue();
    }

    private final HashSet<com.tencent.aio.base.mvvm.a<?, ?>> h1() {
        return (HashSet) this.mChildVb.getValue();
    }

    private final CommunicationShareBarVB i1() {
        return (CommunicationShareBarVB) this.mCommunicationShareBar.getValue();
    }

    private final GroupBlockInputVB j1() {
        return (GroupBlockInputVB) this.mGroupBlockInputVB.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.aio.base.mvvm.a<at.a, InputUIState> k1() {
        return (com.tencent.aio.base.mvvm.a) this.mInputBar.getValue();
    }

    private final LongShotBarVB l1() {
        return (LongShotBarVB) this.mLongShotBar.getValue();
    }

    private final com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState> m1() {
        return (com.tencent.aio.base.mvvm.a) this.mMultiSelectBar.getValue();
    }

    private final com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState> n1() {
        return (com.tencent.aio.base.mvvm.a) this.mShareViewVB.getValue();
    }

    private final void o1(boolean isFullScreen) {
        if (QLog.isColorLevel()) {
            QLog.d("RobotAIOInputContainerVB", 1, "handleFullScreenEvent isFullScreen = " + isFullScreen);
        }
        this.isFullScreen = isFullScreen;
        RelativeLayout relativeLayout = null;
        if (isFullScreen) {
            RelativeLayout relativeLayout2 = this.mInputContainer;
            if (relativeLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInputContainer");
                relativeLayout2 = null;
            }
            relativeLayout2.setTranslationZ(1.0f);
            RelativeLayout relativeLayout3 = this.mInputContainer;
            if (relativeLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInputContainer");
                relativeLayout3 = null;
            }
            RelativeLayout relativeLayout4 = this.mInputContainer;
            if (relativeLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInputContainer");
                relativeLayout4 = null;
            }
            ViewGroup.LayoutParams layoutParams = relativeLayout4.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            layoutParams.height = -1;
            relativeLayout3.setLayoutParams(layoutParams);
            RelativeLayout relativeLayout5 = this.mInputContainer;
            if (relativeLayout5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInputContainer");
                relativeLayout5 = null;
            }
            relativeLayout5.setBackground(new ColorDrawable(-16777216));
            RelativeLayout relativeLayout6 = this.mInputContainer;
            if (relativeLayout6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInputContainer");
            } else {
                relativeLayout = relativeLayout6;
            }
            relativeLayout.getBackground().mutate().setAlpha(0);
            return;
        }
        RelativeLayout relativeLayout7 = this.mInputContainer;
        if (relativeLayout7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInputContainer");
            relativeLayout7 = null;
        }
        RelativeLayout relativeLayout8 = this.mInputContainer;
        if (relativeLayout8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInputContainer");
            relativeLayout8 = null;
        }
        ViewGroup.LayoutParams layoutParams2 = relativeLayout8.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        layoutParams2.height = -2;
        relativeLayout7.setLayoutParams(layoutParams2);
        RelativeLayout relativeLayout9 = this.mInputContainer;
        if (relativeLayout9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInputContainer");
            relativeLayout9 = null;
        }
        relativeLayout9.setBackground(null);
        RelativeLayout relativeLayout10 = this.mInputContainer;
        if (relativeLayout10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInputContainer");
            relativeLayout10 = null;
        }
        relativeLayout10.setTranslationZ(0.0f);
        RelativeLayout relativeLayout11 = this.mInputContainer;
        if (relativeLayout11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInputContainer");
            relativeLayout11 = null;
        }
        relativeLayout11.requestLayout();
        RelativeLayout relativeLayout12 = this.mInputContainer;
        if (relativeLayout12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInputContainer");
        } else {
            relativeLayout = relativeLayout12;
        }
        relativeLayout.invalidate();
    }

    private final boolean q1(String source) {
        return Intrinsics.areEqual(source, "RobotActionBarShare");
    }

    private final void r1() {
        if (h1().contains(m1())) {
            removeChildVB(m1());
            h1().remove(m1());
        }
        if (h1().contains(n1())) {
            removeChildVB(n1());
            h1().remove(n1());
        }
    }

    private final void s1(int visibility) {
        if (visibility == 0) {
            this.isAiVoiceChatMode = true;
            if (!h1().contains(f1())) {
                addChildVB(f1());
                h1().add(f1());
            }
            k1().getHostView().setVisibility(8);
            return;
        }
        this.isAiVoiceChatMode = false;
        if (h1().contains(f1())) {
            removeChildVB(f1());
            h1().remove(f1());
        }
        k1().getHostView().setVisibility(0);
    }

    private final void u1(int visibility) {
        if (visibility == 0) {
            this.isCommunicationShareMode = true;
            if (!h1().contains(i1())) {
                addChildVB(i1());
                h1().add(i1());
            }
            r1();
            if (h1().contains(f1())) {
                removeChildVB(f1());
                h1().remove(f1());
            }
            k1().getHostView().setVisibility(8);
            return;
        }
        this.isCommunicationShareMode = false;
        if (h1().contains(i1())) {
            removeChildVB(i1());
            h1().remove(i1());
        }
        if (this.isAiVoiceChatMode) {
            s1(0);
        } else {
            k1().getHostView().setVisibility(0);
        }
    }

    private final void v1(int visibility) {
        if (visibility == 0) {
            if (!this.isLongShotMode) {
                addChildVB(l1());
                k1().getHostView().setVisibility(8);
            }
            this.isLongShotMode = true;
        } else {
            if (this.isLongShotMode) {
                removeChildVB(l1());
                k1().getHostView().setVisibility(0);
            }
            this.isLongShotMode = false;
        }
        z1();
    }

    private final void w1(int visibility, String source) {
        if (visibility == 8) {
            this.isMultiSelectMode = false;
            this.multiSelectSource = "";
            r1();
            if (this.isAiVoiceChatMode) {
                s1(0);
                return;
            } else {
                k1().getHostView().setVisibility(0);
                return;
            }
        }
        this.isMultiSelectMode = true;
        this.multiSelectSource = source;
        d1(source);
        if (h1().contains(f1())) {
            removeChildVB(f1());
            h1().remove(f1());
        }
        if (h1().contains(i1())) {
            removeChildVB(i1());
            h1().remove(i1());
        }
        k1().getHostView().setVisibility(8);
    }

    static /* synthetic */ void x1(RobotAIOInputContainerVB robotAIOInputContainerVB, int i3, String str, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            str = "";
        }
        robotAIOInputContainerVB.w1(i3, str);
    }

    private final void y1(boolean show) {
        if (QLog.isDebugVersion()) {
            QLog.d("RobotAIOInputContainerVB", 4, "[setTroopBlockVisibility] show:" + show + ", isTroopBlockMode:" + this.isTroopBlockMode + ",  " + hashCode());
        }
        if (show) {
            if (!h1().contains(j1())) {
                addChildVB(j1());
                h1().add(j1());
            }
            k1().getHostView().setVisibility(8);
            this.isTroopBlockMode = true;
            return;
        }
        if (this.isTroopBlockMode && h1().contains(j1())) {
            removeChildVB(j1());
            h1().remove(j1());
        }
        k1().getHostView().setVisibility(0);
        this.isTroopBlockMode = false;
    }

    private final void z1() {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.aio.robot.inputbar.a
            @Override // java.lang.Runnable
            public final void run() {
                RobotAIOInputContainerVB.A1(RobotAIOInputContainerVB.this);
            }
        });
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        super.bindViewAndData();
        this.destoryed = false;
        if (this.isFullScreen) {
            o1(false);
        }
        u1(8);
        x1(this, 8, null, 2, null);
        v1(8);
        y1(false);
        if (QLog.isDebugVersion()) {
            QLog.d("RobotAIOInputContainerVB", 4, "[bindViewAndData]  " + hashCode());
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: e1, reason: merged with bridge method [inline-methods] */
    public com.tencent.aio.base.mvvm.b<at.a, InputUIState> getViewModel() {
        return new c();
    }

    public final int g1() {
        if (!AIOInputUtil.f189159a.l()) {
            return 0;
        }
        f.b bVar = new f.b(0, 1, null);
        sendIntent(bVar);
        return bVar.a() + ViewUtils.dpToPx(1.0f);
    }

    public final int getInputBarHeight() {
        boolean z16;
        if (this.isMultiSelectMode) {
            if (q1(this.multiSelectSource)) {
                return n1().getHostView().getMeasuredHeight();
            }
            return m1().getHostView().getMeasuredHeight();
        }
        if (this.isLongShotMode) {
            return l1().getHostView().getMeasuredHeight();
        }
        if (this.isTroopBlockMode) {
            return j1().getHostView().getMeasuredHeight();
        }
        if (this.isAiVoiceChatMode) {
            return f1().getHostView().getMeasuredHeight();
        }
        if (this.isCommunicationShareMode) {
            return i1().f1();
        }
        if (k1().getHostView().getVisibility() == 8) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return 0;
        }
        return k1().getHostView().getMeasuredHeight() - g1();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState>> initializeChildVB(@NotNull View hostView) {
        List<com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState>> list;
        Intrinsics.checkNotNullParameter(hostView, "hostView");
        list = CollectionsKt___CollectionsKt.toList(h1());
        return list;
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        RelativeLayout relativeLayout = new RelativeLayout(createViewParams.a());
        relativeLayout.setLayoutParams(com.tencent.aio.base.tool.b.f69219a.a(createViewParams.a(), -1, -2));
        this.mInputContainer = relativeLayout;
        return relativeLayout;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        super.onDestroy();
        this.destoryed = true;
        if (QLog.isDebugVersion()) {
            QLog.d("RobotAIOInputContainerVB", 4, "[onDestroy] " + hashCode());
        }
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: p1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull InputUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof AIOInputUIState.SetCommunicationShareBarVisibility) {
            u1(((AIOInputUIState.SetCommunicationShareBarVisibility) state).a());
            return;
        }
        if (state instanceof RobotInputUIState.SetMultiSelectBarVisibility) {
            RobotInputUIState.SetMultiSelectBarVisibility setMultiSelectBarVisibility = (RobotInputUIState.SetMultiSelectBarVisibility) state;
            w1(setMultiSelectBarVisibility.getVisibility(), setMultiSelectBarVisibility.getSource());
            return;
        }
        if (state instanceof AIOInputUIState.TroopBlockVisibleChange) {
            y1(((AIOInputUIState.TroopBlockVisibleChange) state).a());
            return;
        }
        if (state instanceof AIOInputUIState.SetLongShotBarVisibility) {
            v1(((AIOInputUIState.SetLongShotBarVisibility) state).a());
            return;
        }
        if (state instanceof AIOInputUIState.InputHide) {
            k1().getHostView().setVisibility(8);
            return;
        }
        if (state instanceof AIOInputUIState.InputShow) {
            k1().getHostView().setVisibility(0);
            return;
        }
        if (state instanceof AIOInputUIState.GetInputBarHeight) {
            ((AIOInputUIState.GetInputBarHeight) state).b(getInputBarHeight());
            return;
        }
        if (state instanceof AIOInputUIState.BeforeFullScreenAnimChanged) {
            o1(((AIOInputUIState.BeforeFullScreenAnimChanged) state).a());
        } else if (state instanceof AIOInputUIState.EnterAIVoiceChatState) {
            s1(0);
        } else if (state instanceof AIOInputUIState.ExitAIVoiceChatState) {
            s1(8);
        }
    }
}
