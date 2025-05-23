package com.tencent.timi.game.ui.widget;

import android.content.Context;
import android.graphics.Color;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.ark.ArkViewImplement;
import com.tencent.ark.open.ArkAppInfo;
import com.tencent.ark.open.ArkView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import trpc.yes.common.MessageOuterClass$ArkBaseInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 @2\u00020\u0001:\u0001AB1\b\u0007\u0012\u0006\u0010<\u001a\u00020;\u0012\b\u0010*\u001a\u0004\u0018\u00010&\u0012\b\b\u0002\u0010=\u001a\u00020#\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0004\b>\u0010?J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u000e\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010J\u0006\u0010\u0014\u001a\u00020\u0013J\u0018\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017JB\u0010 \u001a\u00020\u001f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00132\b\u0010\u001b\u001a\u0004\u0018\u00010\u00132\b\u0010\u001c\u001a\u0004\u0018\u00010\u00132\b\u0010\u001d\u001a\u0004\u0018\u00010\u00132\b\u0010\u001e\u001a\u0004\u0018\u00010\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017J\u001a\u0010!\u001a\u00020\u001f2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017J\u000e\u0010\"\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010%\u001a\u00020\u00022\u0006\u0010$\u001a\u00020#R\u0019\u0010*\u001a\u0004\u0018\u00010&8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010'\u001a\u0004\b(\u0010)R\u0014\u0010,\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010+R\u0018\u0010.\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010-R\u0016\u00101\u001a\u00020/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u00100R\u0014\u00103\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u00102R\u0014\u00107\u001a\u0002048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010:\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109\u00a8\u0006B"}, d2 = {"Lcom/tencent/timi/game/ui/widget/TimiArkView;", "Landroid/widget/FrameLayout;", "", "i", "o", DomainData.DOMAIN_NAME, "f", "Landroidx/lifecycle/Lifecycle$Event;", "event", tl.h.F, "Lcom/tencent/ark/open/ArkView$InitInfo;", "initInfo", "d", "Lcom/tencent/ark/open/ArkAppInfo$Size;", "size", "p", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "e", "", "g", "Ltrpc/yes/common/MessageOuterClass$ArkBaseInfo;", "arkBaseInfo", "Lcom/tencent/ark/ArkViewImplement$LoadCallback;", "callback", "l", "appId", "view", "minVersion", PublicAccountMessageUtilImpl.META_NAME, DownloadInfo.spKey_Config, "", "k", "j", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "borderType", "setBorderType", "Landroid/util/AttributeSet;", "Landroid/util/AttributeSet;", "getAttrs", "()Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "Ljava/lang/String;", "mUniqueId", "Landroidx/lifecycle/LifecycleOwner;", "mLifecycleOwner", "Lcom/tencent/ark/open/ArkView;", "Lcom/tencent/ark/open/ArkView;", "mArkView", "Landroid/widget/FrameLayout;", "mLoadingView", "Landroidx/lifecycle/LifecycleEventObserver;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/LifecycleEventObserver;", "mLifecycleObserver", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/ark/ArkViewImplement$LoadCallback;", "mCurrentCallback", "Landroid/content/Context;", "context", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;ILandroidx/lifecycle/LifecycleOwner;)V", "D", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public class TimiArkView extends FrameLayout {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private ArkViewImplement.LoadCallback mCurrentCallback;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final AttributeSet attrs;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String mUniqueId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LifecycleOwner mLifecycleOwner;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArkView mArkView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FrameLayout mLoadingView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LifecycleEventObserver mLifecycleObserver;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes26.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f380125a;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            try {
                iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Lifecycle.Event.ON_PAUSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Lifecycle.Event.ON_DESTROY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f380125a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/timi/game/ui/widget/TimiArkView$c", "Lcom/tencent/ark/ArkViewImplement$LoadCallback;", "", "state", "errCode", "", "msg", "", "canRetry", "", "onLoadFailed", "onLoadState", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c implements ArkViewImplement.LoadCallback {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ArkViewImplement.LoadCallback f380126d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ TimiArkView f380127e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ArkView.InitInfo f380128f;

        c(ArkViewImplement.LoadCallback loadCallback, TimiArkView timiArkView, ArkView.InitInfo initInfo) {
            this.f380126d = loadCallback;
            this.f380127e = timiArkView;
            this.f380128f = initInfo;
        }

        @Override // com.tencent.ark.ArkViewImplement.LoadCallback
        public void onLoadFailed(int state, int errCode, @Nullable String msg2, boolean canRetry) {
            ArkViewImplement.LoadCallback loadCallback = this.f380126d;
            if (loadCallback != null) {
                loadCallback.onLoadFailed(state, errCode, msg2, canRetry);
            }
            this.f380127e.o();
        }

        @Override // com.tencent.ark.ArkViewImplement.LoadCallback
        public void onLoadState(int state) {
            String str;
            ArkView.InitInfo initInfo = this.f380128f;
            if (initInfo == null) {
                str = "null";
            } else {
                str = "id:" + initInfo.appID + ", meta:" + initInfo.meta;
            }
            com.tencent.timi.game.utils.l.h("TimiArkView_", 1, "onLoadState state:" + state + ", initInfo:" + str);
            if (state == 1) {
                this.f380127e.n();
            } else {
                this.f380127e.o();
            }
            ArkViewImplement.LoadCallback loadCallback = this.f380126d;
            if (loadCallback != null) {
                loadCallback.onLoadState(state);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TimiArkView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, null, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void d(ArkView.InitInfo initInfo) {
        JSONObject jSONObject;
        JSONException e16;
        com.tencent.timi.game.utils.l.h("TimiArkView_", 1, "meta before append:" + initInfo.meta);
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject = new JSONObject(initInfo.meta);
        } catch (JSONException e17) {
            jSONObject = jSONObject2;
            e16 = e17;
        }
        try {
            JSONObject jSONObject4 = jSONObject.getJSONObject(DownloadInfo.spKey_Config);
            Intrinsics.checkNotNullExpressionValue(jSONObject4, "metaJson.getJSONObject(ARK_META_KEY_CONFIG)");
            jSONObject3 = jSONObject4;
        } catch (JSONException e18) {
            e16 = e18;
            com.tencent.timi.game.utils.l.n("TimiArkView_", "metajson create failed!", e16);
            jSONObject3.put("arkuin", this.mUniqueId);
            JSONObject jSONObject5 = new JSONObject();
            String B = ((ll4.a) mm4.b.b(ll4.a.class)).B();
            String M3 = ((ll4.a) mm4.b.b(ll4.a.class)).M3();
            jSONObject5.put("uin", B);
            jSONObject5.put("yesId", M3);
            jSONObject3.put("loadTimestamp", String.valueOf(System.currentTimeMillis()));
            jSONObject3.put("visitorInfo", jSONObject5);
            jSONObject.put(DownloadInfo.spKey_Config, jSONObject3);
            String jSONObject6 = jSONObject.toString();
            initInfo.meta = jSONObject6;
            com.tencent.timi.game.utils.l.h("TimiArkView_", 1, "meta after append:" + jSONObject6);
        }
        jSONObject3.put("arkuin", this.mUniqueId);
        JSONObject jSONObject52 = new JSONObject();
        String B2 = ((ll4.a) mm4.b.b(ll4.a.class)).B();
        String M32 = ((ll4.a) mm4.b.b(ll4.a.class)).M3();
        jSONObject52.put("uin", B2);
        jSONObject52.put("yesId", M32);
        jSONObject3.put("loadTimestamp", String.valueOf(System.currentTimeMillis()));
        jSONObject3.put("visitorInfo", jSONObject52);
        jSONObject.put(DownloadInfo.spKey_Config, jSONObject3);
        String jSONObject62 = jSONObject.toString();
        initInfo.meta = jSONObject62;
        com.tencent.timi.game.utils.l.h("TimiArkView_", 1, "meta after append:" + jSONObject62);
    }

    private final void f() {
        removeView(this.mArkView);
        this.mArkView = new ArkView(getContext(), this.attrs);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        this.mArkView.setLayoutParams(layoutParams);
        addView(this.mArkView, layoutParams);
    }

    private final void h(Lifecycle.Event event) {
        Lifecycle lifecycle;
        int i3 = b.f380125a[event.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    this.mArkView.onDestroy();
                    LifecycleOwner lifecycleOwner = this.mLifecycleOwner;
                    if (lifecycleOwner != null && (lifecycle = lifecycleOwner.getLifecycle()) != null) {
                        lifecycle.removeObserver(this.mLifecycleObserver);
                    }
                    this.mCurrentCallback = null;
                    return;
                }
                return;
            }
            this.mArkView.onPause();
            return;
        }
        this.mArkView.onResume();
    }

    private final void i() {
        f();
        addView(this.mLoadingView, new FrameLayout.LayoutParams(com.tencent.timi.game.utils.b.a(270), com.tencent.timi.game.utils.b.a(158)));
        ImageView imageView = new ImageView(getContext());
        imageView.setImageResource(R.drawable.common_loading6);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(com.tencent.timi.game.utils.b.a(34), com.tencent.timi.game.utils.b.a(34));
        layoutParams.gravity = 17;
        this.mLoadingView.addView(imageView, layoutParams);
        fh4.g.e(fh4.g.c(this.mLoadingView, Color.parseColor("#D8DAE0")), com.tencent.timi.game.utils.b.c(6), com.tencent.timi.game.utils.b.c(6), com.tencent.timi.game.utils.b.c(6), com.tencent.timi.game.utils.b.c(6));
        o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(TimiArkView this$0, LifecycleOwner owner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(event, "event");
        this$0.h(event);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n() {
        this.mLoadingView.setVisibility(8);
        this.mArkView.setVisibility(0);
        getLayoutParams().height = this.mArkView.getLayoutParams().height;
        getLayoutParams().width = this.mArkView.getLayoutParams().width;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o() {
        this.mLoadingView.setVisibility(8);
        this.mArkView.setVisibility(4);
    }

    private final void p(ArkAppInfo.Size size) {
        this.mLoadingView.setLayoutParams(new FrameLayout.LayoutParams(size.width, size.height));
    }

    public final void e(@NotNull LifecycleOwner lifecycleOwner) {
        Lifecycle lifecycle;
        Lifecycle lifecycle2;
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        LifecycleOwner lifecycleOwner2 = this.mLifecycleOwner;
        if (lifecycleOwner2 != null && (lifecycle2 = lifecycleOwner2.getLifecycle()) != null) {
            lifecycle2.removeObserver(this.mLifecycleObserver);
        }
        this.mLifecycleOwner = lifecycleOwner;
        if (lifecycleOwner != null && (lifecycle = lifecycleOwner.getLifecycle()) != null) {
            lifecycle.addObserver(this.mLifecycleObserver);
        }
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final String getMUniqueId() {
        return this.mUniqueId;
    }

    public final boolean j(@Nullable ArkView.InitInfo initInfo, @Nullable ArkViewImplement.LoadCallback callback) {
        boolean z16;
        if (initInfo != null) {
            d(initInfo);
        }
        o();
        this.mCurrentCallback = new c(callback, this, initInfo);
        ArkView arkView = this.mArkView;
        boolean isAttachedToWindow = arkView.isAttachedToWindow();
        if (Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId()) {
            z16 = true;
        } else {
            z16 = false;
        }
        com.tencent.timi.game.utils.l.i("TimiArkView_", arkView + " isAttachedToWindow:" + isAttachedToWindow + ", isUiThread:" + z16);
        ViewTreeObserver viewTreeObserver = this.mArkView.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.dispatchOnGlobalLayout();
        }
        return this.mArkView.load(initInfo, this.mCurrentCallback);
    }

    public final boolean k(@Nullable String appId, @Nullable String view, @Nullable String minVersion, @Nullable String meta, @Nullable String config, @Nullable ArkViewImplement.LoadCallback callback) {
        ArkView.InitInfo initInfo = new ArkView.InitInfo();
        initInfo.appPath = "";
        initInfo.appID = appId;
        initInfo.view = view;
        initInfo.minVersion = minVersion;
        initInfo.meta = meta;
        initInfo.config = config;
        return j(initInfo, callback);
    }

    public final void l(@NotNull MessageOuterClass$ArkBaseInfo arkBaseInfo, @Nullable ArkViewImplement.LoadCallback callback) {
        Intrinsics.checkNotNullParameter(arkBaseInfo, "arkBaseInfo");
        k(arkBaseInfo.appid.get(), arkBaseInfo.view.get(), arkBaseInfo.version.get(), arkBaseInfo.meta.get(), null, callback);
    }

    public final void q(@NotNull ArkAppInfo.Size size) {
        Intrinsics.checkNotNullParameter(size, "size");
        this.mArkView.updateSize(size);
        p(size);
    }

    public final void setBorderType(int borderType) {
        this.mArkView.setBorderType(borderType);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TimiArkView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, null, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ TimiArkView(Context context, AttributeSet attributeSet, int i3, LifecycleOwner lifecycleOwner, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, attributeSet, (i16 & 4) != 0 ? 0 : i3, (i16 & 8) != 0 ? null : lifecycleOwner);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TimiArkView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, @Nullable LifecycleOwner lifecycleOwner) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.attrs = attributeSet;
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        this.mUniqueId = uuid;
        this.mArkView = new ArkView(context, attributeSet);
        this.mLoadingView = new FrameLayout(context, attributeSet, i3);
        this.mLifecycleObserver = new LifecycleEventObserver() { // from class: com.tencent.timi.game.ui.widget.aa
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner2, Lifecycle.Event event) {
                TimiArkView.m(TimiArkView.this, lifecycleOwner2, event);
            }
        };
        com.tencent.timi.game.utils.l.i("TimiArkView_", "this:" + this + ", mUniqueId:" + uuid);
        if (lifecycleOwner != null) {
            e(lifecycleOwner);
        }
        i();
    }
}
