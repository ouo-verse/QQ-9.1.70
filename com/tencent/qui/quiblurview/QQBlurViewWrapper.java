package com.tencent.qui.quiblurview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
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
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0016\u0018\u0000 ;2\u00020\u00012\u00020\u0002:\u0001\bB'\b\u0007\u0012\u0006\u00104\u001a\u000203\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u000105\u0012\b\b\u0002\u00108\u001a\u000207\u00a2\u0006\u0004\b9\u0010:J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0003H\u0016J\b\u0010\u000b\u001a\u00020\u0007H\u0016J\b\u0010\f\u001a\u00020\u0007H\u0016J\b\u0010\r\u001a\u00020\u0007H\u0016J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0003H\u0016J\u0012\u0010\u0015\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J6\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00162\u001a\u0010\u001b\u001a\u0016\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018j\n\u0012\u0004\u0012\u00020\u0019\u0018\u0001`\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J>\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00162\u001a\u0010\u001b\u001a\u0016\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018j\n\u0012\u0004\u0012\u00020\u0019\u0018\u0001`\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001f\u001a\u00020\u0003H\u0016J\u0012\u0010\"\u001a\u00020\u00072\b\u0010!\u001a\u0004\u0018\u00010 H\u0016J\u0012\u0010$\u001a\u00020\u00072\b\u0010#\u001a\u0004\u0018\u00010 H\u0016J\b\u0010%\u001a\u00020\u0003H\u0016J\b\u0010&\u001a\u00020\u0003H\u0016J\b\u0010'\u001a\u00020\u0007H\u0016J\u0010\u0010)\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u0003H\u0016R\u0014\u0010,\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010/\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0014\u00102\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101\u00a8\u0006<"}, d2 = {"Lcom/tencent/qui/quiblurview/QQBlurViewWrapper;", "Landroid/widget/FrameLayout;", "Lcom/tencent/qui/quiblurview/f;", "", "c", "Lcom/tencent/qui/quiblurview/f$a;", "param", "", "a", NodeProps.VISIBLE, "setVisibility", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "onResume", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "tag", "setDebugTag", "enable", "setEnableBlur", "Lcom/tencent/qui/quiblurview/f$c;", "listener", "setDrawBackgroundListener", "Landroid/view/View;", "bgView", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "bgList", "Lcom/tencent/qui/quiblurview/f$d;", "nativeBlurParam", "setBlurSource", "isViewScaled", "Landroid/graphics/drawable/Drawable;", "overlayDrawable", "setOverlayDrawable", "disableDrawable", "setDisableDrawable", "isPaused", "b", "invalidate", "directDraw", "setDirectDrawMode", "d", "Landroid/view/View;", "blurView", "e", "Lcom/tencent/qui/quiblurview/f;", "qqBlurViewInterface", "f", "Z", "useNativeBlurView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attr", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "i", "QUIBlurView_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes25.dex */
public class QQBlurViewWrapper extends FrameLayout implements f {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name */
    private static boolean f363610h;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final View blurView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final f qqBlurViewInterface;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final boolean useNativeBlurView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qui/quiblurview/QQBlurViewWrapper$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "QUIBlurView_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.qui.quiblurview.QQBlurViewWrapper$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9103);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 23)) {
            redirector.redirect((short) 23);
        } else {
            INSTANCE = new Companion(null);
            f363610h = true;
        }
    }

    @JvmOverloads
    public QQBlurViewWrapper(@NotNull Context context) {
        this(context, null, 0, 6, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 22)) {
            return;
        }
        iPatchRedirector.redirect((short) 22, (Object) this, (Object) context);
    }

    private final boolean c() {
        if (Build.VERSION.SDK_INT < 31) {
            return false;
        }
        return ud0.g.b("enable_qq_native_blur_view", true);
    }

    @Override // com.tencent.qui.quiblurview.f
    public void a(@NotNull f.a param) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) param);
            return;
        }
        Intrinsics.checkNotNullParameter(param, "param");
        if (ud0.d.i()) {
            ud0.d.a("QQBlurViewWrapper", ud0.d.f438810d, "[initBlurView] this=" + hashCode() + " tag=" + getTag());
        }
        this.qqBlurViewInterface.a(param);
    }

    @Override // com.tencent.qui.quiblurview.f
    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        return this.qqBlurViewInterface.b();
    }

    @Override // android.view.View, com.tencent.qui.quiblurview.f
    public void invalidate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
        } else {
            this.qqBlurViewInterface.invalidate();
        }
    }

    @Override // com.tencent.qui.quiblurview.f
    public boolean isPaused() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        return this.qqBlurViewInterface.isPaused();
    }

    @Override // com.tencent.qui.quiblurview.f
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.qqBlurViewInterface.onDestroy();
        }
    }

    @Override // com.tencent.qui.quiblurview.f
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.qqBlurViewInterface.onPause();
        }
    }

    @Override // com.tencent.qui.quiblurview.f
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.qqBlurViewInterface.onResume();
        }
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
        } else {
            Intrinsics.checkNotNullParameter(tag, "tag");
            this.qqBlurViewInterface.setDebugTag(tag);
        }
    }

    @Override // com.tencent.qui.quiblurview.f
    public void setDirectDrawMode(boolean directDraw) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, directDraw);
        } else {
            this.qqBlurViewInterface.setDirectDrawMode(directDraw);
        }
    }

    @Override // com.tencent.qui.quiblurview.f
    public void setDisableDrawable(@Nullable Drawable disableDrawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) disableDrawable);
        } else {
            this.qqBlurViewInterface.setDisableDrawable(disableDrawable);
        }
    }

    @Override // com.tencent.qui.quiblurview.f
    public void setDrawBackgroundListener(@Nullable f.c listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) listener);
        } else {
            this.qqBlurViewInterface.setDrawBackgroundListener(listener);
        }
    }

    @Override // com.tencent.qui.quiblurview.f
    public void setEnableBlur(boolean enable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, enable);
        } else {
            this.qqBlurViewInterface.setEnableBlur(enable);
        }
    }

    @Override // com.tencent.qui.quiblurview.f
    public void setOverlayDrawable(@Nullable Drawable overlayDrawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) overlayDrawable);
        } else {
            this.qqBlurViewInterface.setOverlayDrawable(overlayDrawable);
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
            i3 = 4;
        }
        setVisibility(i3);
    }

    @JvmOverloads
    public QQBlurViewWrapper(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 21)) {
            return;
        }
        iPatchRedirector.redirect((short) 21, (Object) this, (Object) context, (Object) attributeSet);
    }

    @Override // com.tencent.qui.quiblurview.f
    public void setBlurSource(@NotNull View bgView, @Nullable ArrayList<Object> bgList, @Nullable f.d nativeBlurParam, boolean isViewScaled) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, bgView, bgList, nativeBlurParam, Boolean.valueOf(isViewScaled));
        } else {
            Intrinsics.checkNotNullParameter(bgView, "bgView");
            this.qqBlurViewInterface.setBlurSource(bgView, bgList, nativeBlurParam, isViewScaled);
        }
    }

    public /* synthetic */ QQBlurViewWrapper(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 20)) {
            return;
        }
        iPatchRedirector.redirect((short) 20, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QQBlurViewWrapper(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        boolean c16 = c();
        this.useNativeBlurView = c16;
        ud0.d.a("QQBlurViewWrapper", ud0.d.f438811e, "[init] useNativeBlurView=" + c16 + ", enableNativeBlurView=" + f363610h);
        if (c16 && f363610h) {
            QQNativeBlurViewWrapper qQNativeBlurViewWrapper = new QQNativeBlurViewWrapper(context, null, 0, 6, null);
            this.blurView = qQNativeBlurViewWrapper;
            this.qqBlurViewInterface = qQNativeBlurViewWrapper;
        } else {
            QQBlurView qQBlurView = new QQBlurView(context);
            this.blurView = qQBlurView;
            this.qqBlurViewInterface = qQBlurView;
        }
        addView(this.blurView, -1, -1);
    }
}
