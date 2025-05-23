package com.tencent.kuikly.core.render.android.expand.component;

import android.content.Context;
import android.view.ViewGroup;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import d01.u;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 82\u00020\u00012\u00020\u0002:\u00019B\u000f\u0012\u0006\u00105\u001a\u000204\u00a2\u0006\u0004\b6\u00107J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0013\u001a\u00020\u0005H\u0002J\u0018\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0002H\u0016JI\u0010\u001f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0017\u001a\u00020\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\u00102+\u0010\u001e\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0019j\u0004\u0018\u0001`\u001dH\u0016J\u0012\u0010!\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010 H\u0016J\b\u0010\"\u001a\u00020\u0005H\u0016R\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010\u0004\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010)R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010*R;\u0010,\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0019j\u0004\u0018\u0001`\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010+R;\u0010-\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0019j\u0004\u0018\u0001`\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010+R;\u0010.\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0019j\u0004\u0018\u0001`\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010+R;\u00100\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0019j\u0004\u0018\u0001`\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010+R\u0014\u00103\u001a\u00020\n8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b1\u00102\u00a8\u0006:"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/component/KRVideoView;", "Lcom/tencent/kuikly/core/render/android/expand/component/KRView;", "", "Lcom/tencent/kuikly/core/render/android/expand/component/KRVideoViewPlayControl;", "playControl", "", "M", "", "rate", "N", "", "muted", "L", "Lcom/tencent/kuikly/core/render/android/expand/component/KRVideoViewContentMode;", NodeProps.RESIZE_MODE, "O", "", "src", "P", "K", "propKey", "propValue", "b", "method", "params", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "call", "Landroid/view/ViewGroup$LayoutParams;", "setLayoutParams", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "H", "Ljava/lang/String;", "I", "Lcom/tencent/kuikly/core/render/android/expand/component/KRVideoViewPlayControl;", "J", "Lcom/tencent/kuikly/core/render/android/expand/component/KRVideoViewContentMode;", "Z", UserInfo.SEX_FEMALE, "Lkotlin/jvm/functions/Function1;", "firstFrameCallback", "stateChangeCallback", "playTimeChangeCallback", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "customEventCallback", "k", "()Z", "reusable", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", BdhLogUtil.LogTag.Tag_Req, "a", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class KRVideoView extends KRView {

    /* renamed from: H, reason: from kotlin metadata */
    private String src;

    /* renamed from: I, reason: from kotlin metadata */
    private KRVideoViewPlayControl playControl;

    /* renamed from: J, reason: from kotlin metadata */
    private KRVideoViewContentMode resizeMode;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean muted;

    /* renamed from: L, reason: from kotlin metadata */
    private float rate;

    /* renamed from: M, reason: from kotlin metadata */
    private Function1<Object, Unit> firstFrameCallback;

    /* renamed from: N, reason: from kotlin metadata */
    private Function1<Object, Unit> stateChangeCallback;

    /* renamed from: P, reason: from kotlin metadata */
    private Function1<Object, Unit> playTimeChangeCallback;

    /* renamed from: Q, reason: from kotlin metadata */
    private Function1<Object, Unit> customEventCallback;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KRVideoView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.src = "";
        this.playControl = KRVideoViewPlayControl.KRVideoViewPlayControlNone;
        this.resizeMode = KRVideoViewContentMode.KRVideoViewContentModeScaleAspectFit;
        this.rate = -1.0f;
    }

    private final void K() {
        boolean z16;
        int h16 = com.tencent.kuikly.core.render.android.css.ktx.b.h(this);
        int g16 = com.tencent.kuikly.core.render.android.css.ktx.b.g(this);
        if (this.src.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && h16 != 0 && g16 != 0) {
            u.f392615m.m();
            throw new NullPointerException("null cannot be cast to non-null type android.view.View");
        }
    }

    private final void L(boolean muted) {
        this.muted = muted;
    }

    private final void M(KRVideoViewPlayControl playControl) {
        this.playControl = playControl;
        int i3 = e.f117866a[playControl.ordinal()];
    }

    private final void N(float rate) {
        this.rate = rate;
    }

    private final void O(KRVideoViewContentMode resizeMode) {
        this.resizeMode = resizeMode;
    }

    private final void P(String src) {
        boolean z16;
        if (src.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this.src = src;
            K();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.kuikly.core.render.android.expand.component.KRView, i01.c
    public boolean b(@NotNull String propKey, @NotNull Object propValue) {
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        Intrinsics.checkNotNullParameter(propValue, "propValue");
        boolean b16 = super.b(propKey, propValue);
        if (!b16) {
            boolean z16 = false;
            switch (propKey.hashCode()) {
                case -1801488983:
                    if (propKey.equals("customEvent")) {
                        this.customEventCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propValue, 1);
                        break;
                    }
                    return false;
                case -183954275:
                    if (propKey.equals("firstFrame")) {
                        this.firstFrameCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propValue, 1);
                        break;
                    }
                    return false;
                case 114148:
                    if (propKey.equals("src")) {
                        P((String) propValue);
                        break;
                    }
                    return false;
                case 3493088:
                    if (propKey.equals("rate")) {
                        N(com.tencent.kuikly.core.render.android.css.ktx.b.H(propValue));
                        break;
                    }
                    return false;
                case 104264043:
                    if (propKey.equals("muted")) {
                        if (((Integer) propValue).intValue() == 1) {
                            z16 = true;
                        }
                        L(z16);
                        break;
                    }
                    return false;
                case 374747017:
                    if (propKey.equals("playControl")) {
                        M(KRVideoViewPlayControl.INSTANCE.a(((Integer) propValue).intValue()));
                        break;
                    }
                    return false;
                case 722162593:
                    if (propKey.equals("stateChange")) {
                        this.stateChangeCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propValue, 1);
                        break;
                    }
                    return false;
                case 1154693937:
                    if (propKey.equals("playTimeChange")) {
                        this.playTimeChangeCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propValue, 1);
                        break;
                    }
                    return false;
                case 2144331182:
                    if (propKey.equals("resizeMod")) {
                        O(KRVideoViewContentMode.INSTANCE.a((String) propValue));
                        break;
                    }
                    return false;
                default:
                    return false;
            }
            return true;
        }
        return b16;
    }

    @Override // com.tencent.kuikly.core.render.android.expand.component.KRView, i01.c, i01.a
    @Nullable
    public Object call(@NotNull String method, @Nullable String params, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        return super.call(method, params, callback);
    }

    @Override // com.tencent.kuikly.core.render.android.expand.component.KRView, i01.c
    /* renamed from: k */
    public boolean getReusable() {
        return false;
    }

    @Override // com.tencent.kuikly.core.render.android.expand.component.KRView, i01.c, i01.a
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.view.View
    public void setLayoutParams(@Nullable ViewGroup.LayoutParams params) {
        super.setLayoutParams(params);
        K();
    }
}
