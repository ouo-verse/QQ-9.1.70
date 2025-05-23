package com.tencent.mobileqq.ai;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Outline;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.kuikly.core.render.android.expand.module.l;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.ai.main.AIAvatarMainViewModel;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pendant.receiver.AvatarPendantEventReceiver;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.api.IAIAvatarConfig;
import com.tencent.mobileqq.vas.api.IVasKuiklyApi;
import com.tencent.mobileqq.vas.inject.IAvatarPendantView;
import com.tencent.mobileqq.vas.pendant.api.IPendantAvatarShopReport;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qui.quiblurview.QQBlurViewWrapper;
import com.tencent.qui.quiblurview.QQNativeBlurView;
import com.tencent.qui.quiblurview.f;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u0000 =2\u00020\u0001:\u0001>B\u0007\u00a2\u0006\u0004\b;\u0010<J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\r\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\u000e\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\"\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u000fH\u0016R\u001b\u0010\u001c\u001a\u00020\u00178BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\"\u0010$\u001a\u00020\u001d8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010+\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u001b\u00104\u001a\u0002008BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b1\u0010\u0019\u001a\u0004\b2\u00103R\u0017\u0010:\u001a\u0002058\u0006\u00a2\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109\u00a8\u0006?"}, d2 = {"Lcom/tencent/mobileqq/ai/AvatarDisplayPart;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "D9", "F9", "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartStart", "onPartResume", "onPartPause", "onPartStop", "onPartDestroy", "Landroid/content/Intent;", "newIntent", "onNewIntent", "", "requestCode", QzoneIPCModule.RESULT_CODE, "data", "onActivityResult", "Lcom/tencent/mobileqq/ai/main/AIAvatarMainViewModel;", "d", "Lkotlin/Lazy;", "C9", "()Lcom/tencent/mobileqq/ai/main/AIAvatarMainViewModel;", "vm", "Lcom/tencent/mobileqq/pendant/receiver/AvatarPendantEventReceiver;", "e", "Lcom/tencent/mobileqq/pendant/receiver/AvatarPendantEventReceiver;", "B9", "()Lcom/tencent/mobileqq/pendant/receiver/AvatarPendantEventReceiver;", "G9", "(Lcom/tencent/mobileqq/pendant/receiver/AvatarPendantEventReceiver;)V", "receiver", "Landroid/view/ViewGroup;", "f", "Landroid/view/ViewGroup;", "avatarContainer", tl.h.F, "Landroid/view/View;", "cameraBtn", "Lcom/tencent/qui/quiblurview/QQBlurViewWrapper;", "i", "Lcom/tencent/qui/quiblurview/QQBlurViewWrapper;", "blurView", "Lcom/tencent/mobileqq/vas/inject/IAvatarPendantView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "A9", "()Lcom/tencent/mobileqq/vas/inject/IAvatarPendantView;", "avatarPendantView", "Landroid/content/BroadcastReceiver;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/content/BroadcastReceiver;", "getKuiklyReceiver", "()Landroid/content/BroadcastReceiver;", "kuiklyReceiver", "<init>", "()V", "D", "a", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class AvatarDisplayPart extends Part {
    static IPatchRedirector $redirector_;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final BroadcastReceiver kuiklyReceiver;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy vm;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public AvatarPendantEventReceiver receiver;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ViewGroup avatarContainer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private View cameraBtn;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private QQBlurViewWrapper blurView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy avatarPendantView;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\b\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/ai/AvatarDisplayPart$a;", "", "", "BLUR_BG_COLOR", "I", "BLUR_COLOR", "", "BUNDLE_NAME", "Ljava/lang/String;", "PAGE_NAME", "TAG", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.ai.AvatarDisplayPart$a, reason: from kotlin metadata */
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

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/ai/AvatarDisplayPart$b", "Landroid/view/ViewOutlineProvider;", "Landroid/view/View;", "view", "Landroid/graphics/Outline;", "outline", "", "getOutline", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b extends ViewOutlineProvider {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(@NotNull View view, @NotNull Outline outline) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) outline);
                return;
            }
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(outline, "outline");
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), view.getHeight() / 2.0f);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21436);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AvatarDisplayPart() {
        Lazy lazy;
        Lazy lazy2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<AIAvatarMainViewModel>() { // from class: com.tencent.mobileqq.ai.AvatarDisplayPart$vm$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AvatarDisplayPart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final AIAvatarMainViewModel invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (AIAvatarMainViewModel) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    AIAvatarMainViewModel.Companion companion = AIAvatarMainViewModel.INSTANCE;
                    Fragment hostFragment = AvatarDisplayPart.this.getHostFragment();
                    Intrinsics.checkNotNullExpressionValue(hostFragment, "hostFragment");
                    return companion.a(hostFragment);
                }
            });
            this.vm = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(AvatarDisplayPart$avatarPendantView$2.INSTANCE);
            this.avatarPendantView = lazy2;
            this.kuiklyReceiver = new BroadcastReceiver() { // from class: com.tencent.mobileqq.ai.AvatarDisplayPart$kuiklyReceiver$1
                @Override // android.content.BroadcastReceiver
                public void onReceive(@NotNull Context context, @NotNull Intent intent) {
                    IAvatarPendantView A9;
                    IAvatarPendantView A92;
                    IAvatarPendantView A93;
                    IAvatarPendantView A94;
                    Intrinsics.checkNotNullParameter(context, "context");
                    Intrinsics.checkNotNullParameter(intent, "intent");
                    if (Intrinsics.areEqual(l.a(intent), "vas_avatar_pendant_page")) {
                        JSONObject b16 = l.b(intent);
                        if (QLog.isColorLevel()) {
                            QLog.d("AvatarDisplayPart", 2, "onReceive: data=" + b16);
                        }
                        String optString = b16.optString("action");
                        int optInt = b16.optInt("appid");
                        int optInt2 = b16.optInt("isOn");
                        int optInt3 = b16.optInt("id");
                        if (optInt3 > 0 && Intrinsics.areEqual(optString, "preview")) {
                            if (optInt == 23) {
                                if (optInt2 > 0) {
                                    A94 = AvatarDisplayPart.this.A9();
                                    A94.previewAvatar(optInt3, false);
                                    return;
                                } else {
                                    A93 = AvatarDisplayPart.this.A9();
                                    A93.cancelPreviewAvatar();
                                    return;
                                }
                            }
                            if (optInt2 > 0) {
                                A92 = AvatarDisplayPart.this.A9();
                                A92.previewPendant(optInt3, true);
                            } else {
                                A9 = AvatarDisplayPart.this.A9();
                                A9.cancelPreviewPendant();
                            }
                        }
                    }
                }
            };
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IAvatarPendantView A9() {
        Object value = this.avatarPendantView.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-avatarPendantView>(...)");
        return (IAvatarPendantView) value;
    }

    private final AIAvatarMainViewModel C9() {
        return (AIAvatarMainViewModel) this.vm.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00bc  */
    /* JADX WARN: Type inference failed for: r14v13, types: [android.view.View] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void D9(View rootView) {
        boolean z16;
        QQBlurViewWrapper qQBlurViewWrapper;
        ImageView imageView = (ImageView) A9().getHeadView().findViewById(R.id.a6f);
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        View findViewById = rootView.findViewById(R.id.sfi);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.ai_avatar_camera_btn)");
        this.cameraBtn = findViewById;
        QQBlurViewWrapper qQBlurViewWrapper2 = null;
        if (findViewById == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cameraBtn");
            findViewById = null;
        }
        View findViewById2 = findViewById.findViewById(R.id.sfh);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "cameraBtn.findViewById(R.id.ai_avatar_camera_bg)");
        this.blurView = (QQBlurViewWrapper) findViewById2;
        if (SimpleUIUtil.getSimpleUISwitch()) {
            ?? r142 = this.cameraBtn;
            if (r142 == 0) {
                Intrinsics.throwUninitializedPropertyAccessException("cameraBtn");
            } else {
                qQBlurViewWrapper2 = r142;
            }
            qQBlurViewWrapper2.setVisibility(8);
            return;
        }
        QQBlurViewWrapper qQBlurViewWrapper3 = this.blurView;
        if (qQBlurViewWrapper3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blurView");
            qQBlurViewWrapper3 = null;
        }
        qQBlurViewWrapper3.setOutlineProvider(new b());
        qQBlurViewWrapper3.setClipToOutline(true);
        if (Build.VERSION.SDK_INT >= 31) {
            QQBlurViewWrapper qQBlurViewWrapper4 = this.blurView;
            if (qQBlurViewWrapper4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("blurView");
                qQBlurViewWrapper4 = null;
            }
            if (qQBlurViewWrapper4.getChildAt(0) instanceof QQNativeBlurView) {
                z16 = true;
                f.a aVar = new f.a(z16, 20.0f, A9().getHeadView(), qQBlurViewWrapper3.getContext().getColor(R.color.qui_common_bg_bottom_light), new ColorDrawable(-1723842496), Integer.valueOf(R.drawable.l_2));
                aVar.p(true);
                qQBlurViewWrapper = this.blurView;
                if (qQBlurViewWrapper != null) {
                    Intrinsics.throwUninitializedPropertyAccessException("blurView");
                } else {
                    qQBlurViewWrapper2 = qQBlurViewWrapper;
                }
                qQBlurViewWrapper2.a(aVar);
                if (!((IAIAvatarConfig) QRoute.api(IAIAvatarConfig.class)).enableAvatarPageTransitionAnim()) {
                    qQBlurViewWrapper3.setAlpha(0.0f);
                    qQBlurViewWrapper3.animate().alpha(1.0f).setDuration(300L).setStartDelay(400L).start();
                    return;
                }
                return;
            }
        }
        z16 = false;
        f.a aVar2 = new f.a(z16, 20.0f, A9().getHeadView(), qQBlurViewWrapper3.getContext().getColor(R.color.qui_common_bg_bottom_light), new ColorDrawable(-1723842496), Integer.valueOf(R.drawable.l_2));
        aVar2.p(true);
        qQBlurViewWrapper = this.blurView;
        if (qQBlurViewWrapper != null) {
        }
        qQBlurViewWrapper2.a(aVar2);
        if (!((IAIAvatarConfig) QRoute.api(IAIAvatarConfig.class)).enableAvatarPageTransitionAnim()) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void F9() {
        QRouteApi api = QRoute.api(IVasKuiklyApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IVasKuiklyApi::class.java)");
        IVasKuiklyApi iVasKuiklyApi = (IVasKuiklyApi) api;
        if (!iVasKuiklyApi.isDexPageExist("vas_aio_fontbubble", "vas_aio_fontbubble")) {
            iVasKuiklyApi.preloadKuiklyResByRule("vas_aio_fontbubble", AvatarDisplayPart$preloadKuiklyBundle$1.INSTANCE);
        }
    }

    @NotNull
    public final AvatarPendantEventReceiver B9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (AvatarPendantEventReceiver) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        AvatarPendantEventReceiver avatarPendantEventReceiver = this.receiver;
        if (avatarPendantEventReceiver != null) {
            return avatarPendantEventReceiver;
        }
        Intrinsics.throwUninitializedPropertyAccessException("receiver");
        return null;
    }

    public final void G9(@NotNull AvatarPendantEventReceiver avatarPendantEventReceiver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) avatarPendantEventReceiver);
        } else {
            Intrinsics.checkNotNullParameter(avatarPendantEventReceiver, "<set-?>");
            this.receiver = avatarPendantEventReceiver;
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Integer.valueOf(requestCode), Integer.valueOf(resultCode), data);
        } else {
            super.onActivityResult(requestCode, resultCode, data);
            A9().doOnActivityResult(requestCode, resultCode, data);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        if (rootView == null) {
            return;
        }
        View findViewById = rootView.findViewById(R.id.sfj);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.ai_avatar_container)");
        this.avatarContainer = (ViewGroup) findViewById;
        Activity activity = getActivity();
        if (activity != null) {
            A9().initView((QBaseActivity) activity);
        }
        ViewGroup viewGroup = null;
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("106231", true)) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewUtils.dip2px(210.0f), ViewUtils.dip2px(210.0f));
            layoutParams.topMargin = ViewUtils.dip2px(88.0f);
            layoutParams.addRule(14);
            View findViewById2 = A9().getHeadView().findViewById(R.id.kgu);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "avatarPendantView.headVi\u2026Id(R.id.ui_widget_avatar)");
            View headView = A9().getHeadView();
            Intrinsics.checkNotNull(headView, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) headView).removeView(findViewById2);
            ViewGroup viewGroup2 = this.avatarContainer;
            if (viewGroup2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("avatarContainer");
            } else {
                viewGroup = viewGroup2;
            }
            viewGroup.addView(findViewById2, layoutParams);
        } else {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams2.topMargin = ViewUtils.dip2px(56.0f);
            ViewGroup viewGroup3 = this.avatarContainer;
            if (viewGroup3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("avatarContainer");
            } else {
                viewGroup = viewGroup3;
            }
            viewGroup.addView(A9().getHeadView(), layoutParams2);
            View headView2 = A9().getHeadView();
            headView2.setScaleX(1.5f);
            headView2.setScaleY(1.5f);
        }
        D9(rootView);
        View findViewById3 = A9().getHeadView().findViewById(R.id.a6e);
        if (findViewById3 != null) {
            findViewById3.setTransitionName("avatar");
        }
        QuickLiveData<Integer> W1 = C9().W1();
        LifecycleOwner viewLifecycleOwner = getHostFragment().getViewLifecycleOwner();
        final Function1<Integer, Unit> function1 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.ai.AvatarDisplayPart$onInitView$4
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AvatarDisplayPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer num) {
                IAvatarPendantView A9;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) num);
                } else {
                    A9 = AvatarDisplayPart.this.A9();
                    A9.showSelfMenu();
                }
            }
        };
        W1.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.ai.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AvatarDisplayPart.E9(Function1.this, obj);
            }
        });
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        l.c(context, this.kuiklyReceiver);
        c cVar = c.f187660a;
        Activity activity2 = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity2, "activity");
        cVar.b(activity2, rootView, A9());
        F9();
        ((IPendantAvatarShopReport) QRoute.api(IPendantAvatarShopReport.class)).onShopFirstViewExposeNew();
        G9(new AvatarPendantEventReceiver());
        B9().b();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onNewIntent(@Nullable Intent newIntent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) newIntent);
        } else {
            super.onNewIntent(newIntent);
            A9().doOnNewIntent(newIntent);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) activity);
            return;
        }
        super.onPartDestroy(activity);
        A9().doOnDestroy();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        l.f(context, this.kuiklyReceiver);
        B9().e();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) activity);
        } else {
            super.onPartPause(activity);
            A9().doOnPause();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) activity);
        } else {
            super.onPartResume(activity);
            A9().doOnResume();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartStart(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity);
        } else {
            super.onPartStart(activity);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartStop(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) activity);
        } else {
            super.onPartStop(activity);
        }
    }
}
