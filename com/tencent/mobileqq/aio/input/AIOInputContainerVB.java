package com.tencent.mobileqq.aio.input;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.mobileqq.aio.input.AIOInputUIState;
import com.tencent.mobileqq.aio.input.blockstate.GroupBlockInputVB;
import com.tencent.mobileqq.aio.input.communicationshare.CommunicationShareBarVB;
import com.tencent.mobileqq.aio.input.f;
import com.tencent.mobileqq.aio.input.longshot.LongShotBarVB;
import com.tencent.mobileqq.aio.input.multiselect.MultiSelectBarVB;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qui.QUIImmersiveHelper;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.HashSet;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \\2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001]B\u001d\u0012\n\u0010X\u001a\u0006\u0012\u0002\b\u00030W\u0012\b\b\u0002\u0010Y\u001a\u00020\u000b\u00a2\u0006\u0004\bZ\u0010[J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\u0006H\u0002J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J&\u0010\u0019\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\b\u0001\u0012\u00020\u0017\u0012\u0006\b\u0001\u0012\u00020\u00180\u00010\u00162\u0006\u0010\u0015\u001a\u00020\u0013H\u0016J\u0014\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u001aH\u0016J\b\u0010\u001c\u001a\u00020\u0006H\u0016J\b\u0010\u001d\u001a\u00020\u0006H\u0016J\u0010\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u0003H\u0016J\u0006\u0010 \u001a\u00020\u0004J\u0006\u0010!\u001a\u00020\u0004J\u0006\u0010\"\u001a\u00020\u0004R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010)\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010(R\u0016\u0010-\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010(R\u0016\u0010/\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010(R\u0016\u00101\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010(R\u001b\u00107\u001a\u0002028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u001b\u0010<\u001a\u0002088BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b9\u00104\u001a\u0004\b:\u0010;R\u001b\u0010A\u001a\u00020=8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b>\u00104\u001a\u0004\b?\u0010@R\u001b\u0010F\u001a\u00020B8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bC\u00104\u001a\u0004\bD\u0010ER+\u0010J\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020\u0017\u0012\u0006\b\u0001\u0012\u00020\u00180\u00018BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bG\u00104\u001a\u0004\bH\u0010IR'\u0010M\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00018BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bK\u00104\u001a\u0004\bL\u0010IR;\u0010S\u001a\"\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00010Nj\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0001`O8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bP\u00104\u001a\u0004\bQ\u0010RR\u0016\u0010U\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010(R\u0016\u0010\u000f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010(\u00a8\u0006^"}, d2 = {"Lcom/tencent/mobileqq/aio/input/AIOInputContainerVB;", "Lcom/tencent/aio/base/mvvm/a;", "Lat/a;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "", "visibility", "", "q1", "p1", "r1", "o1", "", "show", ICustomDataEditor.STRING_PARAM_1, "u1", OpenHippyInfo.EXTRA_KEY_IS_FULL_SCREEN, "m1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "hostView", "", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "initializeChildVB", "Lcom/tencent/aio/base/mvvm/b;", "d1", "bindViewAndData", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "state", ICustomDataEditor.NUMBER_PARAM_1, "getInputBarHeight", "getVisibility", "f1", "Landroid/widget/RelativeLayout;", "d", "Landroid/widget/RelativeLayout;", "mInputContainer", "e", "Z", "isLongShotMode", "f", "isCommunicationShareMode", tl.h.F, "isMultiSelectMode", "i", "isAiVoiceChatMode", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "isTroopBlockMode", "Lcom/tencent/mobileqq/aio/input/multiselect/MultiSelectBarVB;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "l1", "()Lcom/tencent/mobileqq/aio/input/multiselect/MultiSelectBarVB;", "mMultiSelectBar", "Lcom/tencent/mobileqq/aio/input/communicationshare/CommunicationShareBarVB;", "D", "h1", "()Lcom/tencent/mobileqq/aio/input/communicationshare/CommunicationShareBarVB;", "mCommunicationShareBar", "Lcom/tencent/mobileqq/aio/input/blockstate/GroupBlockInputVB;", "E", "i1", "()Lcom/tencent/mobileqq/aio/input/blockstate/GroupBlockInputVB;", "mGroupBlockInputVB", "Lcom/tencent/mobileqq/aio/input/longshot/LongShotBarVB;", UserInfo.SEX_FEMALE, "k1", "()Lcom/tencent/mobileqq/aio/input/longshot/LongShotBarVB;", "mLongShotBar", "G", "e1", "()Lcom/tencent/aio/base/mvvm/a;", "aiVoiceChatBar", "H", "j1", "mInputBar", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "I", "g1", "()Ljava/util/HashSet;", "mChildVb", "J", "destoryed", "K", "Lcom/tencent/mobileqq/aio/input/adorn/a;", "inputBarAdornApi", "enableExpandable", "<init>", "(Lcom/tencent/mobileqq/aio/input/adorn/a;Z)V", "L", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class AIOInputContainerVB extends com.tencent.aio.base.mvvm.a<at.a, InputUIState> {
    static IPatchRedirector $redirector_;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy mMultiSelectBar;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy mCommunicationShareBar;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy mGroupBlockInputVB;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy mLongShotBar;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy aiVoiceChatBar;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Lazy mInputBar;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Lazy mChildVb;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean destoryed;

    /* renamed from: K, reason: from kotlin metadata */
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
    private boolean isAiVoiceChatMode;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isTroopBlockMode;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/input/AIOInputContainerVB$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.input.AIOInputContainerVB$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52610);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AIOInputContainerVB(@NotNull final com.tencent.mobileqq.aio.input.adorn.a<?> inputBarAdornApi, final boolean z16) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Lazy lazy6;
        Lazy lazy7;
        Intrinsics.checkNotNullParameter(inputBarAdornApi, "inputBarAdornApi");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, inputBarAdornApi, Boolean.valueOf(z16));
            return;
        }
        lazy = LazyKt__LazyJVMKt.lazy(AIOInputContainerVB$mMultiSelectBar$2.INSTANCE);
        this.mMultiSelectBar = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(AIOInputContainerVB$mCommunicationShareBar$2.INSTANCE);
        this.mCommunicationShareBar = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(AIOInputContainerVB$mGroupBlockInputVB$2.INSTANCE);
        this.mGroupBlockInputVB = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(AIOInputContainerVB$mLongShotBar$2.INSTANCE);
        this.mLongShotBar = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(AIOInputContainerVB$aiVoiceChatBar$2.INSTANCE);
        this.aiVoiceChatBar = lazy5;
        lazy6 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.aio.base.mvvm.a<at.a, InputUIState>>(z16, inputBarAdornApi) { // from class: com.tencent.mobileqq.aio.input.AIOInputContainerVB$mInputBar$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ boolean $enableExpandable;
            final /* synthetic */ com.tencent.mobileqq.aio.input.adorn.a<?> $inputBarAdornApi;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$enableExpandable = z16;
                this.$inputBarAdornApi = inputBarAdornApi;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, Boolean.valueOf(z16), inputBarAdornApi);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.aio.base.mvvm.a<at.a, InputUIState> invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (com.tencent.aio.base.mvvm.a) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                if (this.$enableExpandable) {
                    return new AIOInputExpandableVB(this.$inputBarAdornApi);
                }
                return new com.tencent.mobileqq.aio.input.inputbar.a(this.$inputBarAdornApi);
            }
        });
        this.mInputBar = lazy6;
        lazy7 = LazyKt__LazyJVMKt.lazy(new Function0<HashSet<com.tencent.aio.base.mvvm.a<?, ?>>>() { // from class: com.tencent.mobileqq.aio.input.AIOInputContainerVB$mChildVb$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOInputContainerVB.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final HashSet<com.tencent.aio.base.mvvm.a<?, ?>> invoke() {
                com.tencent.aio.base.mvvm.a<?, ?> j16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (HashSet) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                HashSet<com.tencent.aio.base.mvvm.a<?, ?>> hashSet = new HashSet<>();
                j16 = AIOInputContainerVB.this.j1();
                hashSet.add(j16);
                return hashSet;
            }
        });
        this.mChildVb = lazy7;
    }

    private final com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState> e1() {
        return (com.tencent.aio.base.mvvm.a) this.aiVoiceChatBar.getValue();
    }

    private final HashSet<com.tencent.aio.base.mvvm.a<?, ?>> g1() {
        return (HashSet) this.mChildVb.getValue();
    }

    private final CommunicationShareBarVB h1() {
        return (CommunicationShareBarVB) this.mCommunicationShareBar.getValue();
    }

    private final GroupBlockInputVB i1() {
        return (GroupBlockInputVB) this.mGroupBlockInputVB.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.aio.base.mvvm.a<at.a, InputUIState> j1() {
        return (com.tencent.aio.base.mvvm.a) this.mInputBar.getValue();
    }

    private final LongShotBarVB k1() {
        return (LongShotBarVB) this.mLongShotBar.getValue();
    }

    private final MultiSelectBarVB l1() {
        return (MultiSelectBarVB) this.mMultiSelectBar.getValue();
    }

    private final void m1(boolean isFullScreen) {
        if (QLog.isColorLevel()) {
            QLog.d("AIOInputContainerVB", 1, "handleFullScreenEvent isFullScreen = " + isFullScreen);
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

    private final void o1(int visibility) {
        if (visibility == 0) {
            this.isAiVoiceChatMode = true;
            if (!g1().contains(e1())) {
                addChildVB(e1());
                g1().add(e1());
            }
            j1().getHostView().setVisibility(8);
            return;
        }
        this.isAiVoiceChatMode = false;
        if (g1().contains(e1())) {
            removeChildVB(e1());
            g1().remove(e1());
        }
        j1().getHostView().setVisibility(0);
    }

    private final void p1(int visibility) {
        if (visibility == 0) {
            this.isCommunicationShareMode = true;
            if (!g1().contains(h1())) {
                addChildVB(h1());
                g1().add(h1());
            }
            if (g1().contains(l1())) {
                removeChildVB(l1());
                g1().remove(l1());
            }
            if (g1().contains(e1())) {
                removeChildVB(e1());
                g1().remove(e1());
            }
            j1().getHostView().setVisibility(8);
            return;
        }
        this.isCommunicationShareMode = false;
        if (g1().contains(h1())) {
            removeChildVB(h1());
            g1().remove(h1());
        }
        if (this.isAiVoiceChatMode) {
            o1(0);
        } else {
            j1().getHostView().setVisibility(0);
        }
    }

    private final void q1(int visibility) {
        if (visibility == 0) {
            if (!this.isLongShotMode) {
                addChildVB(k1());
                j1().getHostView().setVisibility(8);
            }
            this.isLongShotMode = true;
        } else {
            if (this.isLongShotMode) {
                removeChildVB(k1());
                j1().getHostView().setVisibility(0);
            }
            this.isLongShotMode = false;
        }
        u1();
    }

    private final void r1(int visibility) {
        if (visibility == 0) {
            this.isMultiSelectMode = true;
            if (!g1().contains(l1())) {
                addChildVB(l1());
                g1().add(l1());
            }
            if (g1().contains(e1())) {
                removeChildVB(e1());
                g1().remove(e1());
            }
            if (g1().contains(h1())) {
                removeChildVB(h1());
                g1().remove(h1());
            }
            j1().getHostView().setVisibility(8);
            return;
        }
        this.isMultiSelectMode = false;
        if (g1().contains(l1())) {
            removeChildVB(l1());
            g1().remove(l1());
        }
        if (this.isAiVoiceChatMode) {
            o1(0);
        } else {
            j1().getHostView().setVisibility(0);
        }
    }

    private final void s1(boolean show) {
        if (QLog.isDebugVersion()) {
            QLog.d("AIOInputContainerVB", 4, "[setTroopBlockVisibility] show:" + show + ", isTroopBlockMode:" + this.isTroopBlockMode + ",  " + hashCode());
        }
        if (show) {
            if (!g1().contains(i1())) {
                addChildVB(i1());
                g1().add(i1());
            }
            j1().getHostView().setVisibility(8);
            this.isTroopBlockMode = true;
            return;
        }
        if (this.isTroopBlockMode && g1().contains(i1())) {
            removeChildVB(i1());
            g1().remove(i1());
        }
        j1().getHostView().setVisibility(0);
        this.isTroopBlockMode = false;
    }

    private final void u1() {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.aio.input.a
            @Override // java.lang.Runnable
            public final void run() {
                AIOInputContainerVB.v1(AIOInputContainerVB.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v1(AIOInputContainerVB this$0) {
        QBaseActivity qBaseActivity;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.destoryed && (qBaseActivity = QBaseActivity.sTopActivity) != null) {
            QUIImmersiveHelper.s(qBaseActivity, false, true);
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.bindViewAndData();
        this.destoryed = false;
        if (this.isFullScreen) {
            m1(false);
        }
        p1(8);
        r1(8);
        q1(8);
        s1(false);
        if (QLog.isDebugVersion()) {
            QLog.d("AIOInputContainerVB", 4, "[bindViewAndData]  " + hashCode());
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: d1, reason: merged with bridge method [inline-methods] */
    public com.tencent.aio.base.mvvm.b<at.a, InputUIState> createVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (com.tencent.aio.base.mvvm.b) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return new c();
    }

    public final int f1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        if (!AIOInputUtil.f189159a.l()) {
            return 0;
        }
        f.b bVar = new f.b(0, 1, null);
        sendIntent(bVar);
        return bVar.a() + ViewUtils.dpToPx(1.0f);
    }

    public final int getInputBarHeight() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        if (this.isLongShotMode) {
            return k1().getHostView().getMeasuredHeight();
        }
        if (this.isTroopBlockMode) {
            return i1().getHostView().getMeasuredHeight();
        }
        if (this.isAiVoiceChatMode) {
            return e1().getHostView().getMeasuredHeight();
        }
        if (this.isCommunicationShareMode) {
            return h1().f1();
        }
        if (j1().getHostView().getVisibility() == 8) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return 0;
        }
        return j1().getHostView().getMeasuredHeight() - f1();
    }

    public final int getVisibility() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return j1().getHostView().getVisibility();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState>> initializeChildVB(@NotNull View hostView) {
        List<com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState>> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this, (Object) hostView);
        }
        Intrinsics.checkNotNullParameter(hostView, "hostView");
        list = CollectionsKt___CollectionsKt.toList(g1());
        return list;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: n1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull InputUIState state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof AIOInputUIState.SetCommunicationShareBarVisibility) {
            p1(((AIOInputUIState.SetCommunicationShareBarVisibility) state).a());
            return;
        }
        if (state instanceof AIOInputUIState.SetMultiSelectBarVisibility) {
            r1(((AIOInputUIState.SetMultiSelectBarVisibility) state).a());
            return;
        }
        if (state instanceof AIOInputUIState.TroopBlockVisibleChange) {
            s1(((AIOInputUIState.TroopBlockVisibleChange) state).a());
            return;
        }
        if (state instanceof AIOInputUIState.SetLongShotBarVisibility) {
            q1(((AIOInputUIState.SetLongShotBarVisibility) state).a());
            return;
        }
        if (state instanceof AIOInputUIState.InputHide) {
            j1().getHostView().setVisibility(8);
            return;
        }
        if (state instanceof AIOInputUIState.InputShow) {
            j1().getHostView().setVisibility(0);
            return;
        }
        if (state instanceof AIOInputUIState.GetInputBarHeight) {
            ((AIOInputUIState.GetInputBarHeight) state).b(getInputBarHeight());
            return;
        }
        if (state instanceof AIOInputUIState.BeforeFullScreenAnimChanged) {
            m1(((AIOInputUIState.BeforeFullScreenAnimChanged) state).a());
        } else if (state instanceof AIOInputUIState.EnterAIVoiceChatState) {
            o1(0);
        } else if (state instanceof AIOInputUIState.ExitAIVoiceChatState) {
            o1(8);
        }
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this, (Object) createViewParams);
        }
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        RelativeLayout relativeLayout = new RelativeLayout(createViewParams.a());
        relativeLayout.setLayoutParams(com.tencent.aio.base.tool.b.f69219a.a(createViewParams.a(), -1, -2));
        this.mInputContainer = relativeLayout;
        return relativeLayout;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.onDestroy();
        this.destoryed = true;
        if (QLog.isDebugVersion()) {
            QLog.d("AIOInputContainerVB", 4, "[onDestroy] " + hashCode());
        }
    }

    public /* synthetic */ AIOInputContainerVB(com.tencent.mobileqq.aio.input.adorn.a aVar, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(aVar, (i3 & 2) != 0 ? false : z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, aVar, Boolean.valueOf(z16), Integer.valueOf(i3), defaultConstructorMarker);
    }
}
