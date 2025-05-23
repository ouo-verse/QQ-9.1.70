package com.tencent.qui.quiblurview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qui.quiblurview.f;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 02\u00020\u00012\u00020\u0002:\u0001\u0006B'\b\u0007\u0012\u0006\u0010)\u001a\u00020(\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*\u0012\b\b\u0002\u0010-\u001a\u00020,\u00a2\u0006\u0004\b.\u0010/J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0007H\u0016J\u0012\u0010\u0014\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J6\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00152\u001a\u0010\u001a\u001a\u0016\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017j\n\u0012\u0004\u0012\u00020\u0018\u0018\u0001`\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J>\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00152\u001a\u0010\u001a\u001a\u0016\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017j\n\u0012\u0004\u0012\u00020\u0018\u0018\u0001`\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001e\u001a\u00020\u0007H\u0016J\u0012\u0010!\u001a\u00020\u00052\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016J\u0012\u0010#\u001a\u00020\u00052\b\u0010\"\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010$\u001a\u00020\u0007H\u0016J\b\u0010%\u001a\u00020\u0007H\u0016J\u0010\u0010'\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u0007H\u0016\u00a8\u00061"}, d2 = {"Lcom/tencent/qui/quiblurview/QQNativeBlurViewWrapper;", "Lcom/tencent/qui/quiblurview/QQNativeBlurView;", "Lcom/tencent/qui/quiblurview/f;", "Lcom/tencent/qui/quiblurview/f$a;", "param", "", "a", "", NodeProps.VISIBLE, "setVisibility", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "onResume", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "tag", "setDebugTag", "enable", "setEnableBlur", "Lcom/tencent/qui/quiblurview/f$c;", "listener", "setDrawBackgroundListener", "Landroid/view/View;", "bgView", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "bgList", "Lcom/tencent/qui/quiblurview/f$d;", "nativeBlurParam", "setBlurSource", "isViewScaled", "Landroid/graphics/drawable/Drawable;", "overlayDrawable", "setOverlayDrawable", "disableDrawable", "setDisableDrawable", "isPaused", "b", "directDraw", "setDirectDrawMode", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "", "defaultStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "N", "QUIBlurView_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes25.dex */
public final class QQNativeBlurViewWrapper extends QQNativeBlurView implements f {
    static IPatchRedirector $redirector_;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qui/quiblurview/QQNativeBlurViewWrapper$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "QUIBlurView_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.qui.quiblurview.QQNativeBlurViewWrapper$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9417);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 22)) {
            redirector.redirect((short) 22);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    @JvmOverloads
    public QQNativeBlurViewWrapper(@NotNull Context context) {
        this(context, null, 0, 6, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 21)) {
            return;
        }
        iPatchRedirector.redirect((short) 21, (Object) this, (Object) context);
    }

    @Override // com.tencent.qui.quiblurview.f
    public void a(@NotNull f.a param) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) param);
            return;
        }
        Intrinsics.checkNotNullParameter(param, "param");
        if (ud0.d.h()) {
            ud0.d.a("QQBlurViewWrapper", ud0.d.f438810d, "[initBlurView] this=" + hashCode() + " tag=" + f() + " enable=" + param.e() + " directDraw=" + param.c());
        }
        setEnable(param.e());
        setOverlay(param.i());
        setClearColor(param.b());
        setDirectDraw(param.c());
        if (param.a() != null) {
            setBlurSource(param.a(), null, param.g(), param.k());
        }
        setBlurRadius(param.j());
        if (param.d() != null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            setDisableBackgroundDrawable(ResourcesCompat.getDrawable(context.getResources(), param.d().intValue(), null));
        }
    }

    @Override // com.tencent.qui.quiblurview.f
    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        return e();
    }

    @Override // com.tencent.qui.quiblurview.f
    public boolean isPaused() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        return h();
    }

    @Override // com.tencent.qui.quiblurview.f
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (ud0.d.i()) {
            ud0.d.a("QQBlurViewWrapper", ud0.d.f438810d, "[onDestroy] this=" + hashCode() + " tag=" + f());
        }
        d();
        setOnDrawBackgroundListener(null);
    }

    @Override // com.tencent.qui.quiblurview.f
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (ud0.d.i()) {
            ud0.d.a("QQBlurViewWrapper", ud0.d.f438810d, "[onPause] this=" + hashCode() + " tag=" + f());
        }
        setPause(true);
    }

    @Override // com.tencent.qui.quiblurview.f
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (ud0.d.i()) {
            ud0.d.a("QQBlurViewWrapper", ud0.d.f438810d, "[onResume] this=" + hashCode() + " tag=" + f());
        }
        setPause(false);
    }

    public void setBlurSource(@NotNull View bgView, @Nullable ArrayList<Object> bgList, @Nullable f.d nativeBlurParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, bgView, bgList, nativeBlurParam);
        } else {
            Intrinsics.checkNotNullParameter(bgView, "bgView");
            setBlurSource(bgView, bgList, nativeBlurParam, false);
        }
    }

    @Override // com.tencent.qui.quiblurview.f
    public void setDebugTag(@NotNull String tag) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) tag);
            return;
        }
        Intrinsics.checkNotNullParameter(tag, "tag");
        if (ud0.d.i()) {
            ud0.d.a("QQBlurViewWrapper", ud0.d.f438810d, "[setDebugTag] this=" + hashCode() + " tag=" + tag);
        }
        setMDebugTag(tag);
    }

    @Override // com.tencent.qui.quiblurview.f
    public void setDirectDrawMode(boolean directDraw) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, directDraw);
        } else {
            setDirectDraw(directDraw);
        }
    }

    @Override // com.tencent.qui.quiblurview.f
    public void setDisableDrawable(@Nullable Drawable disableDrawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) disableDrawable);
        } else {
            setDisableBackgroundDrawable(disableDrawable);
        }
    }

    @Override // com.tencent.qui.quiblurview.f
    public void setDrawBackgroundListener(@Nullable f.c listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) listener);
        } else {
            setOnDrawBackgroundListener(listener);
        }
    }

    @Override // com.tencent.qui.quiblurview.f
    public void setEnableBlur(boolean enable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, enable);
            return;
        }
        if (ud0.d.i()) {
            ud0.d.a("QQBlurViewWrapper", ud0.d.f438810d, "[setEnableBlur] this=" + hashCode() + " tag=" + f());
        }
        setEnable(enable);
    }

    @Override // com.tencent.qui.quiblurview.f
    public void setOverlayDrawable(@Nullable Drawable overlayDrawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) overlayDrawable);
        } else {
            setOverlay(overlayDrawable);
        }
    }

    public void setVisibility(boolean visible) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, visible);
            return;
        }
        if (visible) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        setVisibility(i3);
    }

    @JvmOverloads
    public QQNativeBlurViewWrapper(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 20)) {
            return;
        }
        iPatchRedirector.redirect((short) 20, (Object) this, (Object) context, (Object) attributeSet);
    }

    @Override // com.tencent.qui.quiblurview.f
    public void setBlurSource(@NotNull View bgView, @Nullable ArrayList<Object> bgList, @Nullable f.d nativeBlurParam, boolean isViewScaled) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, bgView, bgList, nativeBlurParam, Boolean.valueOf(isViewScaled));
        } else {
            Intrinsics.checkNotNullParameter(bgView, "bgView");
            setBlurSource(new g(bgView, bgList, nativeBlurParam, isViewScaled));
        }
    }

    public /* synthetic */ QQNativeBlurViewWrapper(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 19)) {
            return;
        }
        iPatchRedirector.redirect((short) 19, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QQNativeBlurViewWrapper(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 18)) {
            return;
        }
        iPatchRedirector.redirect((short) 18, this, context, attributeSet, Integer.valueOf(i3));
    }
}
