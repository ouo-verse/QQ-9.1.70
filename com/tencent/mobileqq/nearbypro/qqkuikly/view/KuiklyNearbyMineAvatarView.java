package com.tencent.mobileqq.nearbypro.qqkuikly.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.PointF;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.UiThread;
import androidx.exifinterface.media.ExifInterface;
import com.airbnb.lottie.LottieAnimationView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.filament.zplan.business.api.IBusinessScene;
import com.tencent.filament.zplan.business.impl.AbsBusinessScene;
import com.tencent.filament.zplan.manager.FilamentRenderFactory;
import com.tencent.filament.zplan.view.event.TouchEvent;
import com.tencent.filament.zplan.view.event.TouchEventState;
import com.tencent.filament.zplan.view.event.TouchEventType;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.nearbypro.base.j;
import com.tencent.mobileqq.nearbypro.profile.avatar.GuestNearByProBizScene;
import com.tencent.mobileqq.nearbypro.profile.avatar.MyNearbyProBizScene;
import com.tencent.mobileqq.nearbypro.qqkuikly.view.KuiklyNearbyMineAvatarView;
import com.tencent.mobileqq.nearbypro.utils.s;
import com.tencent.mobileqq.nearbypro.utils.t;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.widget.lottie.LottieLoader;
import com.tencent.mobileqq.zplan.meme.api.IMemeHelper;
import com.tencent.mobileqq.zplan.resource.api.IZPlanAvatarInfoHelper;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.state.ViewExtensionsKt;
import com.tencent.state.square.api.IDressKeyChangeListener;
import com.tencent.state.square.record.SquareRecordManager;
import i01.c;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import tl.h;
import uk0.e;
import vk0.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0002`c\u0018\u0000 \u000f2\u00020\u00012\u00020\u0002:\u0001jB\u000f\u0012\u0006\u0010g\u001a\u00020f\u00a2\u0006\u0004\bh\u0010iJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\u0011\u001a\u00020\u0003H\u0002J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\u0015\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u0016\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u0017\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u0018\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u0019\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\u001a\u001a\u00020\fH\u0002J\u001c\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\u001c2\u0006\u0010\u001b\u001a\u00020\u0006H\u0002J\u0010\u0010\u001e\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010 \u001a\u00020\u001f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010!\u001a\u00020\u0003H\u0002J\b\u0010\"\u001a\u00020\u0003H\u0002J\u0010\u0010%\u001a\u00020\u00032\u0006\u0010$\u001a\u00020#H\u0002J \u0010(\u001a\u00020\u00032\u0006\u0010%\u001a\u00020#2\u0006\u0010&\u001a\u00020#2\u0006\u0010'\u001a\u00020#H\u0002J\u0018\u0010+\u001a\u00020\u00032\u0006\u0010)\u001a\u00020#2\u0006\u0010*\u001a\u00020#H\u0002J\u0018\u0010-\u001a\u00020\f2\u0006\u0010,\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0016JI\u00105\u001a\u0004\u0018\u00010\n2\u0006\u0010.\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062+\u00104\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\n\u00a2\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(2\u0012\u0004\u0012\u00020\u0003\u0018\u00010/j\u0004\u0018\u0001`3H\u0016J\b\u00106\u001a\u00020\u0003H\u0014J\b\u00107\u001a\u00020\u0003H\u0016J\b\u00108\u001a\u00020\u0003H\u0016R\u0018\u0010<\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010@\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010D\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010F\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010CR\u0018\u0010J\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010L\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010\u0018R\u0016\u0010M\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010\u0018R\u0014\u0010O\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010NR\u001a\u0010R\u001a\b\u0012\u0004\u0012\u00020\u00060P8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u0010QR;\u0010T\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\n\u00a2\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(2\u0012\u0004\u0012\u00020\u0003\u0018\u00010/j\u0004\u0018\u0001`38\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010SR;\u0010U\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\n\u00a2\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(2\u0012\u0004\u0012\u00020\u0003\u0018\u00010/j\u0004\u0018\u0001`38\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010SR;\u0010V\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\n\u00a2\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(2\u0012\u0004\u0012\u00020\u0003\u0018\u00010/j\u0004\u0018\u0001`38\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010SR;\u0010W\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\n\u00a2\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(2\u0012\u0004\u0012\u00020\u0003\u0018\u00010/j\u0004\u0018\u0001`38\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010SR\u0016\u0010\u0013\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010NR\u0016\u0010Y\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010XR\u0016\u0010Z\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0018R\u0016\u0010[\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0018R\u0016\u0010\\\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010NR\u0018\u0010_\u001a\u0004\u0018\u00010]8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010^R\u0014\u0010b\u001a\u00020`8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010aR\u0014\u0010e\u001a\u00020c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010d\u00a8\u0006k"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/qqkuikly/view/KuiklyNearbyMineAvatarView;", "Landroid/widget/FrameLayout;", "Li01/c;", "", "N", "M", "", "params", "L", "D", "", "propValue", "", "O", "B", ExifInterface.LATITUDE_SOUTH, "T", HippyTKDListViewAdapter.X, "", "tinyId", UserInfo.SEX_FEMALE, BdhLogUtil.LogTag.Tag_Req, "J", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "I", "P", "v", "data", "", "w", "K", "Lcom/tencent/filament/zplan/business/impl/AbsBusinessScene;", BdhLogUtil.LogTag.Tag_Conn, "H", "G", "", "status", "y", "minInsetTop", "maxInsetTop", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "offset", NodeProps.MAX_HEIGHT, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "propKey", "b", "method", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "call", NodeProps.ON_ATTACHED_TO_WINDOW, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "E", "Lwk0/a;", "d", "Lwk0/a;", "filamentNativeApp", "Landroid/view/View;", "e", "Landroid/view/View;", "filamentTextureView", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "shadowView", h.F, "backgroundBallView", "Lcom/airbnb/lottie/LottieAnimationView;", "i", "Lcom/airbnb/lottie/LottieAnimationView;", "loadingView", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "currentAnimationStatus", "initAnimationStatus", "Ljava/lang/String;", "transformationAnimURL", "", "Ljava/util/List;", "filamentEvents", "Lkotlin/jvm/functions/Function1;", "renderFailCallback", "firstFrameCallback", "touchEventCallback", "updateAvatarCallback", "Z", "autoPlay", "currentState", "state", "avatarCharacterBase64", "Lcom/tencent/mobileqq/nearbypro/profile/avatar/MyNearbyProBizScene;", "Lcom/tencent/mobileqq/nearbypro/profile/avatar/MyNearbyProBizScene;", "mineAvatarScene", "com/tencent/mobileqq/nearbypro/qqkuikly/view/KuiklyNearbyMineAvatarView$b", "Lcom/tencent/mobileqq/nearbypro/qqkuikly/view/KuiklyNearbyMineAvatarView$b;", "jsEventListener", "com/tencent/mobileqq/nearbypro/qqkuikly/view/KuiklyNearbyMineAvatarView$c", "Lcom/tencent/mobileqq/nearbypro/qqkuikly/view/KuiklyNearbyMineAvatarView$c;", "listener", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "a", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class KuiklyNearbyMineAvatarView extends FrameLayout implements i01.c {

    /* renamed from: C, reason: from kotlin metadata */
    private int initAnimationStatus;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final String transformationAnimURL;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final List<String> filamentEvents;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private Function1<Object, Unit> renderFailCallback;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private Function1<Object, Unit> firstFrameCallback;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private Function1<Object, Unit> touchEventCallback;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private Function1<Object, Unit> updateAvatarCallback;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private String tinyId;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean autoPlay;

    /* renamed from: L, reason: from kotlin metadata */
    private int currentState;

    /* renamed from: M, reason: from kotlin metadata */
    private int state;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private String avatarCharacterBase64;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private MyNearbyProBizScene mineAvatarScene;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final b jsEventListener;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final c listener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private wk0.a filamentNativeApp;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View filamentTextureView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView shadowView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView backgroundBallView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LottieAnimationView loadingView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int currentAnimationStatus;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/nearbypro/qqkuikly/view/KuiklyNearbyMineAvatarView$b", "Luk0/e;", "", "type", "eventData", "", "onEvent", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class b implements e {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(KuiklyNearbyMineAvatarView this$0) {
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
            j.c().e("NearbyMineAvatarView", " onJsEvent. type: " + type + ", eventData: " + eventData);
            int hashCode = type.hashCode();
            if (hashCode != -1565730423) {
                if (hashCode != 1621140201) {
                    if (hashCode == 1719579098 && type.equals("onTouchEvent")) {
                        if (Intrinsics.areEqual(eventData, MyNearbyProBizScene.CLICK)) {
                            com.tencent.mobileqq.nearbypro.aio.utils.a.f253152a.a(KuiklyNearbyMineAvatarView.this, "em_nearby_avatar", null);
                        }
                        Function1 function1 = KuiklyNearbyMineAvatarView.this.touchEventCallback;
                        if (function1 != null) {
                            function1.invoke(KuiklyNearbyMineAvatarView.this.w(eventData));
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (type.equals("onFirstFrameRenderEnd")) {
                    KuiklyNearbyMineAvatarView.this.G();
                    View view = KuiklyNearbyMineAvatarView.this.filamentTextureView;
                    if (view != null) {
                        final KuiklyNearbyMineAvatarView kuiklyNearbyMineAvatarView = KuiklyNearbyMineAvatarView.this;
                        view.post(new Runnable() { // from class: com.tencent.mobileqq.nearbypro.qqkuikly.view.a
                            @Override // java.lang.Runnable
                            public final void run() {
                                KuiklyNearbyMineAvatarView.b.b(KuiklyNearbyMineAvatarView.this);
                            }
                        });
                    }
                    if (!KuiklyNearbyMineAvatarView.this.v()) {
                        KuiklyNearbyMineAvatarView.this.M();
                    }
                    Function1 function12 = KuiklyNearbyMineAvatarView.this.firstFrameCallback;
                    if (function12 != null) {
                        function12.invoke(KuiklyNearbyMineAvatarView.this.w(eventData));
                        return;
                    }
                    return;
                }
                return;
            }
            if (type.equals("onFilamentRenderFail")) {
                LottieAnimationView lottieAnimationView = KuiklyNearbyMineAvatarView.this.loadingView;
                if (lottieAnimationView != null) {
                    lottieAnimationView.setVisibility(8);
                }
                Function1 function13 = KuiklyNearbyMineAvatarView.this.renderFailCallback;
                if (function13 != null) {
                    function13.invoke(KuiklyNearbyMineAvatarView.this.w(eventData));
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/nearbypro/qqkuikly/view/KuiklyNearbyMineAvatarView$c", "Lcom/tencent/state/square/api/IDressKeyChangeListener;", "", "isMale", "", "onDressKeyChange", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class c implements IDressKeyChangeListener {
        c() {
        }

        @Override // com.tencent.state.square.api.IDressKeyChangeListener
        public void onDressKeyChange(boolean isMale) {
            j.c().e("NearbyMineAvatarView", "onDressKeyChange");
            if (Intrinsics.areEqual(KuiklyNearbyMineAvatarView.this.tinyId, "0")) {
                Function1 function1 = KuiklyNearbyMineAvatarView.this.updateAvatarCallback;
                if (function1 != null) {
                    function1.invoke(null);
                    return;
                }
                return;
            }
            wk0.a aVar = KuiklyNearbyMineAvatarView.this.filamentNativeApp;
            if (aVar != null) {
                b.a.a(aVar, "onCostumeChange", null, null, 4, null);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KuiklyNearbyMineAvatarView(@NotNull Context context) {
        super(context);
        List<String> listOf;
        Intrinsics.checkNotNullParameter(context, "context");
        this.currentAnimationStatus = -1;
        this.initAnimationStatus = -1;
        this.transformationAnimURL = ((IMemeHelper) QRoute.api(IMemeHelper.class)).getLoadingResUrl();
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"onFilamentRenderFail", "onFirstFrameRenderEnd", "onTouchEvent"});
        this.filamentEvents = listOf;
        this.tinyId = "0";
        this.avatarCharacterBase64 = "";
        this.jsEventListener = new b();
        this.listener = new c();
    }

    private final void A(int offset, int maxHeight) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(NodeProps.MAX_HEIGHT, maxHeight);
        jSONObject.put("offset", offset);
        wk0.a aVar = this.filamentNativeApp;
        if (aVar != null) {
            b.a.a(aVar, "DrawerPageAvatar.onScrollOffsetChanged", jSONObject.toString(), null, 4, null);
        }
        wk0.a aVar2 = this.filamentNativeApp;
        if (aVar2 != null) {
            b.a.a(aVar2, "onDrawFrame", null, null, 4, null);
        }
    }

    private final boolean B(Object propValue) {
        Intrinsics.checkNotNull(propValue, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = 'result')] kotlin.Any?, kotlin.Unit>{ com.tencent.kuikly.core.render.android.export.IKuiklyRenderModuleExportKt.KuiklyRenderCallback }");
        this.firstFrameCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propValue, 1);
        return true;
    }

    private final AbsBusinessScene C(long tinyId) {
        if (K(tinyId)) {
            return new MyNearbyProBizScene();
        }
        return new GuestNearByProBizScene(tinyId);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0077  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void D(String params) {
        boolean z16;
        JSONException jSONException;
        int i3;
        int i16;
        String str;
        wk0.a aVar;
        MyNearbyProBizScene myNearbyProBizScene;
        IBusinessScene iBusinessScene;
        JSONObject jSONObject;
        int i17 = 0;
        if (params != null && params.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        try {
            jSONObject = new JSONObject(params);
            i16 = jSONObject.getInt(HippyTKDListViewAdapter.X);
        } catch (JSONException e16) {
            jSONException = e16;
            i3 = 0;
        }
        try {
            i17 = jSONObject.getInt("y");
            str = jSONObject.getString("state");
            Intrinsics.checkNotNullExpressionValue(str, "data.getString(\"state\")");
        } catch (JSONException e17) {
            jSONException = e17;
            i3 = i17;
            i17 = i16;
            j.c().d("NearbyMineAvatarView", "parse eventData fail:" + jSONException);
            i16 = i17;
            i17 = i3;
            str = "";
            float f16 = getContext().getResources().getDisplayMetrics().density;
            aVar = this.filamentNativeApp;
            myNearbyProBizScene = null;
            if (aVar == null) {
            }
            if (iBusinessScene instanceof MyNearbyProBizScene) {
            }
            TouchEventState touchEventState = TouchEventState.Began;
            if (!Intrinsics.areEqual(str, "move")) {
            }
            TouchEventState touchEventState2 = touchEventState;
            if (myNearbyProBizScene == null) {
            }
        }
        float f162 = getContext().getResources().getDisplayMetrics().density;
        aVar = this.filamentNativeApp;
        myNearbyProBizScene = null;
        if (aVar == null) {
            iBusinessScene = aVar.getScene();
        } else {
            iBusinessScene = null;
        }
        if (iBusinessScene instanceof MyNearbyProBizScene) {
            myNearbyProBizScene = (MyNearbyProBizScene) iBusinessScene;
        }
        TouchEventState touchEventState3 = TouchEventState.Began;
        if (!Intrinsics.areEqual(str, "move")) {
            touchEventState3 = TouchEventState.Changed;
        } else if (Intrinsics.areEqual(str, "end")) {
            touchEventState3 = TouchEventState.Ended;
        }
        TouchEventState touchEventState22 = touchEventState3;
        if (myNearbyProBizScene == null) {
            myNearbyProBizScene.handlePanEvent(new TouchEvent(TouchEventType.Pan, touchEventState22, 1, new PointF(i16 * f162, i17 * f162), null, null, 48, null));
        }
    }

    private final void F(long tinyId) {
        wk0.a aVar;
        if (this.filamentNativeApp != null) {
            return;
        }
        this.filamentNativeApp = FilamentRenderFactory.b(FilamentRenderFactory.f105773b, null, 0, null, null, 15, null);
        for (String str : this.filamentEvents) {
            wk0.a aVar2 = this.filamentNativeApp;
            if (aVar2 != null) {
                aVar2.c(str, this.jsEventListener);
            }
        }
        if (tinyId != 0 && (aVar = this.filamentNativeApp) != null) {
            aVar.y("bundle/scenes/drawer-page/main.js", C(tinyId));
        }
        wk0.a aVar3 = this.filamentNativeApp;
        if (aVar3 != null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            View z16 = aVar3.z(context, Boolean.TRUE);
            if (z16 != null) {
                if (this.filamentTextureView == null) {
                    this.filamentTextureView = z16;
                    E();
                    addView(z16, new FrameLayout.LayoutParams(-1, -1));
                    z16.setVisibility(4);
                }
                SquareRecordManager.INSTANCE.setDressKeyChangeListener(this.listener);
                if (v()) {
                    N();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G() {
        int i3 = this.initAnimationStatus;
        if (i3 == -1) {
            if (K(Long.parseLong(this.tinyId))) {
                y(2);
                return;
            } else {
                y(0);
                return;
            }
        }
        y(i3);
    }

    private final void H() {
        LottieAnimationView lottieAnimationView = new LottieAnimationView(getActivity());
        lottieAnimationView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        lottieAnimationView.setVisibility(0);
        addView(lottieAnimationView);
        new LottieLoader(lottieAnimationView.getContext()).fromNetworkWithCacheBitmap(lottieAnimationView, this.transformationAnimURL);
        lottieAnimationView.setRepeatCount(-1);
        lottieAnimationView.setRepeatMode(1);
        this.loadingView = lottieAnimationView;
        lottieAnimationView.playAnimation();
    }

    private final boolean I(Object propValue) {
        return true;
    }

    private final boolean J(Object propValue) {
        Intrinsics.checkNotNull(propValue, "null cannot be cast to non-null type kotlin.Int");
        this.initAnimationStatus = ((Integer) propValue).intValue();
        return true;
    }

    private final boolean K(long tinyId) {
        if (s.a() == tinyId) {
            return true;
        }
        return false;
    }

    private final void L(String params) {
        boolean z16;
        int i3;
        int i16;
        JSONObject jSONObject;
        int i17 = 0;
        if (params != null && params.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        try {
            jSONObject = new JSONObject(params);
            i3 = jSONObject.getInt("minInsetTop");
            try {
                i16 = jSONObject.getInt("maxInsetTop");
            } catch (JSONException e16) {
                e = e16;
                i16 = 0;
            }
        } catch (JSONException e17) {
            e = e17;
            i3 = 0;
            i16 = 0;
        }
        try {
            i17 = jSONObject.getInt("offsetY");
        } catch (JSONException e18) {
            e = e18;
            j.c().d("NearbyMineAvatarView", "parse eventData fail:" + e);
            z(i17, i3, i16);
        }
        z(i17, i3, i16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M() {
        if (this.currentState == 1) {
            return;
        }
        this.currentState = 1;
        wk0.a aVar = this.filamentNativeApp;
        if (aVar != null) {
            aVar.onPause();
        }
        this.state = 0;
    }

    private final void N() {
        wk0.a aVar;
        if (this.currentState != 2 && (aVar = this.filamentNativeApp) != null) {
            this.currentState = 2;
            if (aVar != null) {
                aVar.onResume();
            }
            this.state = 1;
        }
    }

    private final boolean O(Object propValue) {
        Intrinsics.checkNotNull(propValue, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = 'result')] kotlin.Any?, kotlin.Unit>{ com.tencent.kuikly.core.render.android.export.IKuiklyRenderModuleExportKt.KuiklyRenderCallback }");
        this.renderFailCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propValue, 1);
        return true;
    }

    private final boolean P(Object propValue) {
        boolean z16;
        Intrinsics.checkNotNull(propValue, "null cannot be cast to non-null type kotlin.Int");
        if (((Integer) propValue).intValue() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.autoPlay = z16;
        if (v()) {
            N();
        }
        return true;
    }

    private final boolean Q(Object propValue) {
        wk0.a aVar;
        Intrinsics.checkNotNull(propValue, "null cannot be cast to non-null type kotlin.String");
        this.avatarCharacterBase64 = (String) propValue;
        if (Intrinsics.areEqual(this.tinyId, "0")) {
            byte[] byteValue = Base64.decode(this.avatarCharacterBase64, 0);
            IZPlanAvatarInfoHelper iZPlanAvatarInfoHelper = (IZPlanAvatarInfoHelper) QRoute.api(IZPlanAvatarInfoHelper.class);
            Intrinsics.checkNotNullExpressionValue(byteValue, "byteValue");
            JSONObject otherAvatarInfoForLPlan = iZPlanAvatarInfoHelper.getOtherAvatarInfoForLPlan(byteValue);
            MyNearbyProBizScene myNearbyProBizScene = this.mineAvatarScene;
            if (myNearbyProBizScene == null) {
                MyNearbyProBizScene myNearbyProBizScene2 = new MyNearbyProBizScene();
                this.mineAvatarScene = myNearbyProBizScene2;
                myNearbyProBizScene2.setAvatarCharacter(otherAvatarInfoForLPlan);
                MyNearbyProBizScene myNearbyProBizScene3 = this.mineAvatarScene;
                if (myNearbyProBizScene3 != null && (aVar = this.filamentNativeApp) != null) {
                    aVar.y("bundle/scenes/drawer-page/main.js", myNearbyProBizScene3);
                }
                SquareRecordManager.INSTANCE.setDressKeyChangeListener(this.listener);
                return true;
            }
            if (myNearbyProBizScene != null) {
                myNearbyProBizScene.setAvatarCharacter(otherAvatarInfoForLPlan);
            }
            wk0.a aVar2 = this.filamentNativeApp;
            if (aVar2 != null) {
                b.a.a(aVar2, "onCostumeChange", null, null, 4, null);
                return true;
            }
            return true;
        }
        return true;
    }

    private final boolean R(Object propValue) {
        Intrinsics.checkNotNull(propValue, "null cannot be cast to non-null type kotlin.String");
        this.tinyId = (String) propValue;
        return true;
    }

    private final boolean S(Object propValue) {
        Intrinsics.checkNotNull(propValue, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = 'result')] kotlin.Any?, kotlin.Unit>{ com.tencent.kuikly.core.render.android.export.IKuiklyRenderModuleExportKt.KuiklyRenderCallback }");
        this.touchEventCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propValue, 1);
        return true;
    }

    private final boolean T(Object propValue) {
        Intrinsics.checkNotNull(propValue, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = 'result')] kotlin.Any?, kotlin.Unit>{ com.tencent.kuikly.core.render.android.export.IKuiklyRenderModuleExportKt.KuiklyRenderCallback }");
        this.updateAvatarCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propValue, 1);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean v() {
        if (this.autoPlay && this.currentState != 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, Object> w(String data) {
        Map<String, Object> mapOf;
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("data", data));
        return mapOf;
    }

    private final void x() {
        wk0.a aVar = this.filamentNativeApp;
        if (aVar == null) {
            return;
        }
        if (aVar != null) {
            aVar.onDestroy();
        }
        this.filamentNativeApp = null;
        View view = this.filamentTextureView;
        if (view != null) {
            removeView(view);
        }
        this.filamentTextureView = null;
        SquareRecordManager.INSTANCE.removeDressKeyChangeListener(this.listener);
    }

    private final void y(int status) {
        if (this.currentAnimationStatus == status) {
            return;
        }
        this.currentAnimationStatus = status;
        this.initAnimationStatus = status;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("status", status);
        wk0.a aVar = this.filamentNativeApp;
        if (aVar != null) {
            b.a.a(aVar, "DrawerPageAvatar.onPlayStateChanged", jSONObject.toString(), null, 4, null);
        }
    }

    private final void z(int y16, int minInsetTop, int maxInsetTop) {
        if (y16 > 0 && !ViewExtensionsKt.isVisible(this)) {
            t.a(this, true);
        }
        int i3 = maxInsetTop - minInsetTop;
        int i16 = maxInsetTop - y16;
        if (i16 <= minInsetTop + 1) {
            y(0);
            return;
        }
        int i17 = i16 - minInsetTop;
        if (i17 < i3) {
            A(Math.max(0, i17), i3);
            y(1);
        } else {
            y(2);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0010. Please report as an issue. */
    @Override // i01.c
    public boolean b(@NotNull String propKey, @NotNull Object propValue) {
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        Intrinsics.checkNotNullParameter(propValue, "propValue");
        switch (propKey.hashCode()) {
            case -1621011813:
                if (propKey.equals("touchEvent")) {
                    return S(propValue);
                }
                return c.a.p(this, propKey, propValue);
            case -1454216318:
                if (propKey.equals("updateAvatar")) {
                    return T(propValue);
                }
                return c.a.p(this, propKey, propValue);
            case -1020641983:
                if (propKey.equals("shadowSize")) {
                    return I(propValue);
                }
                return c.a.p(this, propKey, propValue);
            case -892481550:
                if (propKey.equals("status")) {
                    return J(propValue);
                }
                return c.a.p(this, propKey, propValue);
            case -873620421:
                if (propKey.equals("tinyId")) {
                    return R(propValue);
                }
                return c.a.p(this, propKey, propValue);
            case -183954275:
                if (propKey.equals("firstFrame")) {
                    return B(propValue);
                }
                return c.a.p(this, propKey, propValue);
            case 210537936:
                if (propKey.equals("avatarCharacter")) {
                    return Q(propValue);
                }
                return c.a.p(this, propKey, propValue);
            case 1193660884:
                if (propKey.equals("renderFail")) {
                    return O(propValue);
                }
                return c.a.p(this, propKey, propValue);
            case 1438608771:
                if (propKey.equals("autoPlay")) {
                    return P(propValue);
                }
                return c.a.p(this, propKey, propValue);
            default:
                return c.a.p(this, propKey, propValue);
        }
    }

    @Override // i01.a
    @Nullable
    public Object call(@NotNull String str, @Nullable Object obj, @Nullable Function1<Object, Unit> function1) {
        return c.a.a(this, str, obj, function1);
    }

    @Override // i01.c
    public void e(@NotNull ViewGroup viewGroup) {
        c.a.l(this, viewGroup);
    }

    @Override // i01.c
    @NotNull
    public View f() {
        return c.a.r(this);
    }

    @Override // i01.c, i01.a
    @Nullable
    public Activity getActivity() {
        return c.a.e(this);
    }

    @Override // i01.c, i01.a
    @Nullable
    /* renamed from: getKuiklyRenderContext */
    public com.tencent.kuikly.core.render.android.a get_kuiklyRenderContext() {
        return c.a.f(this);
    }

    @Override // i01.c
    @UiThread
    public void h() {
        c.a.n(this);
    }

    @Override // i01.c
    /* renamed from: k */
    public boolean getReusable() {
        return c.a.g(this);
    }

    @Override // i01.c
    public void n(@NotNull ViewGroup viewGroup) {
        c.a.i(this, viewGroup);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        H();
        F(Long.parseLong(this.tinyId));
    }

    @Override // i01.a
    @UiThread
    public void onCreate() {
        c.a.j(this);
    }

    @Override // i01.c, i01.a
    public void onDestroy() {
        c.a.k(this);
        x();
    }

    @Override // i01.c
    @UiThread
    public boolean s(@NotNull String str) {
        return c.a.m(this, str);
    }

    @Override // i01.c, i01.a
    public void setKuiklyRenderContext(@Nullable com.tencent.kuikly.core.render.android.a aVar) {
        c.a.o(this, aVar);
    }

    @Override // i01.c
    @UiThread
    public void setShadow(@NotNull i01.b bVar) {
        c.a.q(this, bVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000a. Please report as an issue. */
    @Override // i01.c, i01.a
    @Nullable
    public Object call(@NotNull String method, @Nullable String params, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        switch (method.hashCode()) {
            case -1340212393:
                if (method.equals(MiniSDKConst.NOTIFY_EVENT_ONPAUSE)) {
                    M();
                    return Unit.INSTANCE;
                }
                return c.a.b(this, method, params, callback);
            case 110749:
                if (method.equals("pan")) {
                    D(params);
                    return Unit.INSTANCE;
                }
                return c.a.b(this, method, params, callback);
            case 1463983852:
                if (method.equals("onResume")) {
                    N();
                    return Unit.INSTANCE;
                }
                return c.a.b(this, method, params, callback);
            case 1552695079:
                if (method.equals("onContentOffsetChanged")) {
                    L(params);
                    return Unit.INSTANCE;
                }
                return c.a.b(this, method, params, callback);
            default:
                return c.a.b(this, method, params, callback);
        }
    }

    public void E() {
    }
}
