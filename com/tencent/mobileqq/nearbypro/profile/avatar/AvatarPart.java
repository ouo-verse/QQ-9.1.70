package com.tencent.mobileqq.nearbypro.profile.avatar;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.airbnb.lottie.LottieAnimationView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.filament.zplan.business.impl.AbsBusinessScene;
import com.tencent.filament.zplan.manager.FilamentRenderFactory;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.nearbypro.base.j;
import com.tencent.mobileqq.nearbypro.profile.avatar.AvatarPart;
import com.tencent.mobileqq.nearbypro.profile.basepart.ProfileBasePart;
import com.tencent.mobileqq.nearbypro.utils.PicLoadUtilsKt;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.vas.widget.lottie.LottieLoader;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zplan.meme.api.IMemeHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.state.square.api.IDressKeyChangeListener;
import com.tencent.state.square.record.SquareRecordManager;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import uk0.e;
import vk0.b;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\t*\u0002KO\b\u0016\u0018\u0000 U2\u00020\u0001:\u0001VB\u0007\u00a2\u0006\u0004\bS\u0010TJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0003J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0015\u001a\u00020\u0004H\u0016J\u000e\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0016J\b\u0010\u001c\u001a\u00020\u001bH\u0016R\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010#\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0018\u00103\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010,R\"\u0010:\u001a\u00020\u00168\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\"\u0010=\u001a\u00020\u00168\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b5\u00105\u001a\u0004\b;\u00107\"\u0004\b<\u00109R\u0016\u0010?\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u00105R\u001b\u0010C\u001a\u00020\u00168BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u00107R\u0014\u0010F\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u001a\u0010J\u001a\b\u0012\u0004\u0012\u00020\r0G8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0014\u0010N\u001a\u00020K8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0014\u0010R\u001a\u00020O8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bP\u0010Q\u00a8\u0006W"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/profile/avatar/AvatarPart;", "Lcom/tencent/mobileqq/nearbypro/profile/basepart/ProfileBasePart;", "Landroid/view/ViewGroup;", "avatarContainer", "", "V9", "T9", Constants.BASE_IN_APP_NAME, "Lcom/tencent/filament/zplan/business/impl/AbsBusinessScene;", "P9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "S9", "U9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "onPartPause", "onPartDestroy", "W9", "", "status", "N9", "Landroid/view/ViewGroup$LayoutParams;", "L9", "Landroid/widget/FrameLayout$LayoutParams;", "M9", "Lwk0/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lwk0/a;", "filamentNativeApp", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", "filamentTextureView", "D", "Landroid/view/ViewGroup;", "O9", "()Landroid/view/ViewGroup;", "setAvatarContainer", "(Landroid/view/ViewGroup;)V", "Landroid/widget/ImageView;", "E", "Landroid/widget/ImageView;", "shadowView", "Lcom/airbnb/lottie/LottieAnimationView;", UserInfo.SEX_FEMALE, "Lcom/airbnb/lottie/LottieAnimationView;", "loadingView", "G", "backgroundBallView", "H", "I", "R9", "()I", "Y9", "(I)V", "relWidth", "Q9", "X9", "relHeight", "J", "currentAnimationStatus", "K", "Lkotlin/Lazy;", "getScreenHeight", "screenHeight", "L", "Ljava/lang/String;", "transformationAnimURL", "", "M", "Ljava/util/List;", "filamentEvents", "com/tencent/mobileqq/nearbypro/profile/avatar/AvatarPart$b", "N", "Lcom/tencent/mobileqq/nearbypro/profile/avatar/AvatarPart$b;", "jsEventListener", "com/tencent/mobileqq/nearbypro/profile/avatar/AvatarPart$c", "P", "Lcom/tencent/mobileqq/nearbypro/profile/avatar/AvatarPart$c;", "listener", "<init>", "()V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "a", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public class AvatarPart extends ProfileBasePart {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private View filamentTextureView;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private ViewGroup avatarContainer;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private ImageView shadowView;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private LottieAnimationView loadingView;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private ImageView backgroundBallView;

    /* renamed from: H, reason: from kotlin metadata */
    private int relWidth;

    /* renamed from: I, reason: from kotlin metadata */
    private int relHeight;

    /* renamed from: J, reason: from kotlin metadata */
    private int currentAnimationStatus = -1;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final Lazy screenHeight;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final String transformationAnimURL;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final List<String> filamentEvents;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final b jsEventListener;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final c listener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private wk0.a filamentNativeApp;

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/nearbypro/profile/avatar/AvatarPart$b", "Luk0/e;", "", "type", "eventData", "", "onEvent", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class b implements e {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(AvatarPart this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            View view = this$0.filamentTextureView;
            if (view != null) {
                view.setVisibility(0);
            }
            ImageView imageView = this$0.shadowView;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            ImageView imageView2 = this$0.backgroundBallView;
            if (imageView2 != null) {
                imageView2.setVisibility(0);
            }
            LottieAnimationView lottieAnimationView = this$0.loadingView;
            if (lottieAnimationView != null) {
                lottieAnimationView.setVisibility(8);
            }
        }

        @Override // uk0.e
        public void onEvent(@NotNull String type, @NotNull String eventData) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(eventData, "eventData");
            j.c().e("NBP.PersonalPart.AvatarPart", " onJsEvent. type: " + type + ", eventData: " + eventData);
            int hashCode = type.hashCode();
            if (hashCode != -1565730423) {
                if (hashCode != 1621140201) {
                    if (hashCode == 1719579098 && type.equals("onTouchEvent") && Intrinsics.areEqual(eventData, MyNearbyProBizScene.CLICK)) {
                        com.tencent.mobileqq.nearbypro.aio.utils.a.f253152a.a(AvatarPart.this.getAvatarContainer(), "em_nearby_avatar", null);
                        return;
                    }
                    return;
                }
                if (type.equals("onFirstFrameRenderEnd")) {
                    j.c().e("NBP.PersonalPart.AvatarPart", "filament_native_event_first_render");
                    AvatarPart.this.W9();
                    View view = AvatarPart.this.filamentTextureView;
                    if (view != null) {
                        final AvatarPart avatarPart = AvatarPart.this;
                        view.post(new Runnable() { // from class: com.tencent.mobileqq.nearbypro.profile.avatar.a
                            @Override // java.lang.Runnable
                            public final void run() {
                                AvatarPart.b.b(AvatarPart.this);
                            }
                        });
                        return;
                    }
                    return;
                }
                return;
            }
            if (type.equals("onFilamentRenderFail")) {
                j.c().e("NBP.PersonalPart.AvatarPart", "filament_native_event_render_fail");
                LottieAnimationView lottieAnimationView = AvatarPart.this.loadingView;
                if (lottieAnimationView != null) {
                    lottieAnimationView.setVisibility(0);
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/nearbypro/profile/avatar/AvatarPart$c", "Lcom/tencent/state/square/api/IDressKeyChangeListener;", "", "isMale", "", "onDressKeyChange", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class c implements IDressKeyChangeListener {
        c() {
        }

        @Override // com.tencent.state.square.api.IDressKeyChangeListener
        public void onDressKeyChange(boolean isMale) {
            j.c().e("NBP.PersonalPart.AvatarPart", "onDressKeyChange");
            wk0.a aVar = AvatarPart.this.filamentNativeApp;
            if (aVar != null) {
                b.a.a(aVar, "onCostumeChange", null, null, 4, null);
            }
        }
    }

    public AvatarPart() {
        Lazy lazy;
        List<String> listOf;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.mobileqq.nearbypro.profile.avatar.AvatarPart$screenHeight$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                return Integer.valueOf(ScreenUtil.getRealHeight(BaseApplication.context));
            }
        });
        this.screenHeight = lazy;
        this.transformationAnimURL = ((IMemeHelper) QRoute.api(IMemeHelper.class)).getLoadingResUrl();
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"onFilamentRenderFail", "onFirstFrameRenderEnd", "onTouchEvent"});
        this.filamentEvents = listOf;
        this.jsEventListener = new b();
        this.listener = new c();
    }

    private final void D3() {
        LottieAnimationView lottieAnimationView = new LottieAnimationView(getActivity());
        lottieAnimationView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        lottieAnimationView.setVisibility(0);
        ViewGroup viewGroup = this.avatarContainer;
        if (viewGroup != null) {
            viewGroup.addView(lottieAnimationView);
        }
        new LottieLoader(lottieAnimationView.getContext()).fromNetworkWithCacheBitmap(lottieAnimationView, this.transformationAnimURL);
        lottieAnimationView.setRepeatCount(-1);
        lottieAnimationView.setRepeatMode(1);
        this.loadingView = lottieAnimationView;
    }

    private final AbsBusinessScene P9() {
        if (getIsSelf()) {
            return new MyNearbyProBizScene();
        }
        return new GuestNearByProBizScene(getMTinyId());
    }

    private final void T9() {
        ImageView imageView = new ImageView(getActivity());
        this.shadowView = imageView;
        Intrinsics.checkNotNull(imageView);
        imageView.setLayoutParams(M9());
        PicLoadUtilsKt.d(S9(), imageView);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        ViewGroup viewGroup = this.avatarContainer;
        if (viewGroup != null) {
            viewGroup.addView(imageView);
        }
        imageView.setVisibility(8);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private final void V9(ViewGroup avatarContainer) {
        this.filamentNativeApp = FilamentRenderFactory.b(FilamentRenderFactory.f105773b, null, 0, null, null, 15, null);
        for (String str : this.filamentEvents) {
            wk0.a aVar = this.filamentNativeApp;
            if (aVar != null) {
                aVar.c(str, this.jsEventListener);
            }
        }
        wk0.a aVar2 = this.filamentNativeApp;
        if (aVar2 != null) {
            aVar2.y("bundle/scenes/drawer-page/main.js", P9());
        }
        Activity context = getActivity();
        wk0.a aVar3 = this.filamentNativeApp;
        if (aVar3 != null) {
            Intrinsics.checkNotNullExpressionValue(context, "context");
            View z16 = aVar3.z(context, Boolean.TRUE);
            if (z16 != null) {
                if (this.filamentTextureView == null) {
                    this.filamentTextureView = z16;
                    avatarContainer.removeAllViews();
                    U9();
                    avatarContainer.addView(z16, new FrameLayout.LayoutParams(-1, -1));
                    avatarContainer.setLayoutParams(L9());
                    z16.setVisibility(4);
                }
                wk0.a aVar4 = this.filamentNativeApp;
                if (aVar4 != null) {
                    aVar4.onResume();
                }
            }
        }
    }

    @NotNull
    public ViewGroup.LayoutParams L9() {
        throw null;
    }

    @NotNull
    public FrameLayout.LayoutParams M9() {
        throw null;
    }

    public final void N9(int status) {
        if (this.currentAnimationStatus == status) {
            return;
        }
        this.currentAnimationStatus = status;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("status", status);
        wk0.a aVar = this.filamentNativeApp;
        if (aVar != null) {
            b.a.a(aVar, "DrawerPageAvatar.onPlayStateChanged", jSONObject.toString(), null, 4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: O9, reason: from getter */
    public final ViewGroup getAvatarContainer() {
        return this.avatarContainer;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: Q9, reason: from getter */
    public final int getRelHeight() {
        return this.relHeight;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: R9, reason: from getter */
    public final int getRelWidth() {
        return this.relWidth;
    }

    @NotNull
    public String S9() {
        throw null;
    }

    public void U9() {
        throw null;
    }

    public void W9() {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void X9(int i3) {
        this.relHeight = i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void Y9(int i3) {
        this.relWidth = i3;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        ViewGroup viewGroup;
        super.onInitView(rootView);
        if (rootView != null) {
            viewGroup = (ViewGroup) rootView.findViewById(R.id.t19);
        } else {
            viewGroup = null;
        }
        this.avatarContainer = viewGroup;
        if (viewGroup != null) {
            V9(viewGroup);
        }
        T9();
        D3();
        if (getIsSelf()) {
            SquareRecordManager.INSTANCE.setDressKeyChangeListener(this.listener);
        }
    }

    @Override // com.tencent.mobileqq.nearbypro.part.e, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@NotNull Activity activity) {
        ViewGroup viewGroup;
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartDestroy(activity);
        wk0.a aVar = this.filamentNativeApp;
        if (aVar != null) {
            aVar.onDestroy();
        }
        this.filamentNativeApp = null;
        View view = this.filamentTextureView;
        if (view != null && (viewGroup = this.avatarContainer) != null) {
            viewGroup.removeView(view);
        }
        this.filamentTextureView = null;
        SquareRecordManager.INSTANCE.removeDressKeyChangeListener(this.listener);
    }

    @Override // com.tencent.mobileqq.nearbypro.part.e, com.tencent.biz.richframework.part.Part
    public void onPartPause(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartPause(activity);
        wk0.a aVar = this.filamentNativeApp;
        if (aVar != null) {
            aVar.onPause();
        }
    }

    @Override // com.tencent.mobileqq.nearbypro.part.e, com.tencent.biz.richframework.part.Part
    public void onPartResume(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartResume(activity);
        wk0.a aVar = this.filamentNativeApp;
        if (aVar != null) {
            aVar.onResume();
        }
    }
}
