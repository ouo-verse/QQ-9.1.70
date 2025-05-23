package com.tencent.mobileqq.nearbypro.qqkuikly.view;

import android.app.Activity;
import android.content.Context;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.UiThread;
import com.airbnb.lottie.LottieAnimationView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.nearbypro.avatar.AvatarData;
import com.tencent.mobileqq.nearbypro.avatar.NearbyAvatarMotionView;
import com.tencent.mobileqq.nearbypro.base.j;
import com.tencent.mobileqq.nearbypro.utils.e;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.vas.widget.lottie.LottieLoader;
import com.tencent.mobileqq.zplan.meme.api.IMemeHelper;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.state.square.data.DressKeys;
import com.tencent.ttpic.openapi.filter.LightConstants;
import i01.c;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import rp4.f;
import tl.h;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 @2\u00020\u00012\u00020\u0002:\u0001AB\u000f\u0012\u0006\u0010=\u001a\u00020<\u00a2\u0006\u0004\b>\u0010?J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0003H\u0002J\b\u0010\n\u001a\u00020\u0003H\u0002J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\u0007H\u0002J\b\u0010\u000f\u001a\u00020\u0003H\u0002J\b\u0010\u0010\u001a\u00020\u0003H\u0002J\b\u0010\u0011\u001a\u00020\u0003H\u0002J\b\u0010\u0012\u001a\u00020\u0003H\u0002J\u000e\u0010\u0014\u001a\u0004\u0018\u00010\u000b*\u00020\u0013H\u0002J\u0018\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0017\u001a\u00020\u0003H\u0014JI\u0010 \u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0018\u001a\u00020\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u00132+\u0010\u001f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001aj\u0004\u0018\u0001`\u001eH\u0016J\b\u0010!\u001a\u00020\u0003H\u0016R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u001e\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010,\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R;\u0010/\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001aj\u0004\u0018\u0001`\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R;\u00100\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001aj\u0004\u0018\u0001`\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010.R;\u00101\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001aj\u0004\u0018\u0001`\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010.R\u0018\u00104\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0018\u00108\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0014\u0010;\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u0010:\u00a8\u0006B"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/qqkuikly/view/KuiklyNearbyProAvatarView;", "Landroid/widget/FrameLayout;", "Li01/c;", "", "l", "", "propValue", "", "t", "u", "j", "Lcom/tencent/mobileqq/nearbypro/avatar/b;", "avatarData", "r", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "o", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "i", "", "v", "propKey", "b", NodeProps.ON_ATTACHED_TO_WINDOW, "method", "params", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "call", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/nearbypro/avatar/NearbyAvatarMotionView;", "d", "Lcom/tencent/mobileqq/nearbypro/avatar/NearbyAvatarMotionView;", "avatarView", "Lkotlin/Function0;", "e", "Lkotlin/jvm/functions/Function0;", "lazyAttachWindowTask", "f", "Z", "didAttachWindow", h.F, "Lkotlin/jvm/functions/Function1;", "startLoadCallback", "loadSuccessCallback", "loadFailureCallback", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/nearbypro/avatar/b;", "currentAvatarData", "Lcom/airbnb/lottie/LottieAnimationView;", "D", "Lcom/airbnb/lottie/LottieAnimationView;", "loadingView", "E", "Ljava/lang/String;", "transformationAnimURL", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", UserInfo.SEX_FEMALE, "a", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class KuiklyNearbyProAvatarView extends FrameLayout implements i01.c {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private AvatarData currentAvatarData;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private LottieAnimationView loadingView;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final String transformationAnimURL;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private NearbyAvatarMotionView avatarView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function0<Unit> lazyAttachWindowTask;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean didAttachWindow;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<Object, Unit> startLoadCallback;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<Object, Unit> loadSuccessCallback;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<Object, Unit> loadFailureCallback;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/nearbypro/qqkuikly/view/KuiklyNearbyProAvatarView$b", "Lcom/tencent/mobileqq/nearbypro/avatar/NearbyAvatarMotionView$b;", "", "onShow", "onStart", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class b implements NearbyAvatarMotionView.b {
        b() {
        }

        @Override // com.tencent.mobileqq.nearbypro.avatar.NearbyAvatarMotionView.b
        public void onShow() {
            KuiklyNearbyProAvatarView.this.j();
        }

        @Override // com.tencent.mobileqq.nearbypro.avatar.NearbyAvatarMotionView.b
        public void onStart() {
            Map emptyMap;
            KuiklyNearbyProAvatarView.this.j();
            Function1 function1 = KuiklyNearbyProAvatarView.this.loadSuccessCallback;
            if (function1 != null) {
                emptyMap = MapsKt__MapsKt.emptyMap();
                function1.invoke(emptyMap);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KuiklyNearbyProAvatarView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.transformationAnimURL = ((IMemeHelper) QRoute.api(IMemeHelper.class)).getLoadingResUrl();
    }

    private final void i() {
        NearbyAvatarMotionView nearbyAvatarMotionView = this.avatarView;
        if (nearbyAvatarMotionView != null) {
            removeView(nearbyAvatarMotionView);
        }
        this.avatarView = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j() {
        LottieAnimationView lottieAnimationView = this.loadingView;
        if (lottieAnimationView != null) {
            lottieAnimationView.pauseAnimation();
            removeView(lottieAnimationView);
        }
    }

    private final void l() {
        u();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        NearbyAvatarMotionView nearbyAvatarMotionView = new NearbyAvatarMotionView(context, null, 0, 6, null);
        addView(nearbyAvatarMotionView, new FrameLayout.LayoutParams(-1, -1));
        this.avatarView = nearbyAvatarMotionView;
    }

    private final void m() {
        NearbyAvatarMotionView nearbyAvatarMotionView = this.avatarView;
        if (nearbyAvatarMotionView != null) {
            nearbyAvatarMotionView.p();
        }
    }

    private final void o() {
        NearbyAvatarMotionView nearbyAvatarMotionView = this.avatarView;
        if (nearbyAvatarMotionView != null) {
            nearbyAvatarMotionView.r();
        }
    }

    private final boolean p() {
        NearbyAvatarMotionView nearbyAvatarMotionView = this.avatarView;
        if (nearbyAvatarMotionView != null) {
            nearbyAvatarMotionView.s();
            return true;
        }
        return true;
    }

    private final void q() {
        NearbyAvatarMotionView nearbyAvatarMotionView = this.avatarView;
        if (nearbyAvatarMotionView != null) {
            nearbyAvatarMotionView.x();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r(AvatarData avatarData) {
        Map emptyMap;
        j.c().c("NearbyProAvatarView", "setAvatarData: tid=" + avatarData.getTid() + " motionId=" + avatarData.getResource().getActionId() + " filamentReady=" + avatarData.getResource().getFilamentReady());
        this.currentAvatarData = avatarData;
        Function1<Object, Unit> function1 = this.startLoadCallback;
        if (function1 != null) {
            emptyMap = MapsKt__MapsKt.emptyMap();
            function1.invoke(emptyMap);
        }
        u();
        NearbyAvatarMotionView nearbyAvatarMotionView = this.avatarView;
        if (nearbyAvatarMotionView != null) {
            nearbyAvatarMotionView.setData(avatarData, new b());
        }
    }

    private final boolean t(final Object propValue) {
        if (this.currentAvatarData != null) {
            return true;
        }
        Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.mobileqq.nearbypro.qqkuikly.view.KuiklyNearbyProAvatarView$setAvatarData$task$1
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

            /* JADX WARN: Code restructure failed: missing block: B:5:0x000c, code lost:
            
                r0 = r2.v(r0);
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke2() {
                AvatarData v3;
                Object obj = propValue;
                String str = obj instanceof String ? (String) obj : null;
                if (str == null || v3 == null) {
                    return;
                }
                this.r(v3);
            }
        };
        if (!this.didAttachWindow) {
            this.lazyAttachWindowTask = function0;
        } else {
            function0.invoke();
        }
        return true;
    }

    private final void u() {
        if (this.loadingView == null) {
            LottieAnimationView lottieAnimationView = new LottieAnimationView(getActivity());
            lottieAnimationView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            lottieAnimationView.setVisibility(0);
            new LottieLoader(lottieAnimationView.getContext()).fromNetworkWithCacheBitmap(lottieAnimationView, this.transformationAnimURL);
            lottieAnimationView.setRepeatCount(-1);
            lottieAnimationView.setRepeatMode(1);
            this.loadingView = lottieAnimationView;
        }
        LottieAnimationView lottieAnimationView2 = this.loadingView;
        if (lottieAnimationView2 != null) {
            if (indexOfChild(lottieAnimationView2) == -1) {
                addView(lottieAnimationView2);
            }
            lottieAnimationView2.playAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AvatarData v(String str) {
        DressKeys dressKeys;
        try {
            JSONObject jSONObject = new JSONObject(str);
            long optLong = jSONObject.optLong("tid");
            boolean optBoolean = jSONObject.optBoolean(LightConstants.MALE);
            boolean z16 = false;
            f resourceInfo = f.c(Base64.decode(jSONObject.optString("resourceInfo"), 0));
            String it = jSONObject.optString("dressKey");
            boolean optBoolean2 = jSONObject.optBoolean("autoPlay", true);
            Intrinsics.checkNotNullExpressionValue(it, "it");
            if (it.length() > 0) {
                z16 = true;
            }
            if (!z16) {
                it = null;
            }
            if (it != null) {
                dressKeys = new DressKeys(it, "");
            } else {
                dressKeys = null;
            }
            String longToString = StringUtil.longToString(optLong);
            Intrinsics.checkNotNullExpressionValue(longToString, "longToString(tid)");
            Intrinsics.checkNotNullExpressionValue(resourceInfo, "resourceInfo");
            return new AvatarData(longToString, optBoolean, e.e(resourceInfo, dressKeys), optBoolean2);
        } catch (Throwable th5) {
            j.c().d("NearbyProAvatarView", "parse avatar data  error: " + th5);
            return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0011. Please report as an issue. */
    @Override // i01.c
    public boolean b(@NotNull String propKey, @NotNull Object propValue) {
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        Intrinsics.checkNotNullParameter(propValue, "propValue");
        switch (propKey.hashCode()) {
            case -2129527704:
                if (propKey.equals("startLoad")) {
                    this.startLoadCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propValue, 1);
                    return true;
                }
                return c.a.p(this, propKey, propValue);
            case -1599351356:
                if (propKey.equals("loadFailure")) {
                    this.loadFailureCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propValue, 1);
                    return true;
                }
                return c.a.p(this, propKey, propValue);
            case -403648349:
                if (propKey.equals("avatarData")) {
                    return t(propValue);
                }
                return c.a.p(this, propKey, propValue);
            case 1915020349:
                if (propKey.equals("loadSuccess")) {
                    this.loadSuccessCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propValue, 1);
                    return true;
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
        l();
        this.didAttachWindow = true;
        Function0<Unit> function0 = this.lazyAttachWindowTask;
        if (function0 != null) {
            function0.invoke();
        }
        this.lazyAttachWindowTask = null;
    }

    @Override // i01.a
    @UiThread
    public void onCreate() {
        c.a.j(this);
    }

    @Override // i01.c, i01.a
    public void onDestroy() {
        c.a.k(this);
        i();
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
                    o();
                    return Unit.INSTANCE;
                }
                return c.a.b(this, method, params, callback);
            case -1013054029:
                if (method.equals("onPlay")) {
                    return Boolean.valueOf(p());
                }
                return c.a.b(this, method, params, callback);
            case 570398262:
                if (method.equals("interact")) {
                    m();
                    return Unit.INSTANCE;
                }
                return c.a.b(this, method, params, callback);
            case 1463983852:
                if (method.equals("onResume")) {
                    q();
                    return Unit.INSTANCE;
                }
                return c.a.b(this, method, params, callback);
            default:
                return c.a.b(this, method, params, callback);
        }
    }
}
