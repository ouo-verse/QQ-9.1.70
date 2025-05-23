package com.tencent.qui.quiblurview;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\bf\u0018\u00002\u00020\u0001:\u0004\u0005!%&J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0004H&J\b\u0010\u0007\u001a\u00020\u0004H&J\b\u0010\b\u001a\u00020\u0004H&J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH&J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH&J\u0012\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH&JB\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u001a\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u00152\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0019\u001a\u00020\fH&J\u0012\u0010\u001d\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH&J\u0012\u0010\u001f\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u001bH&J\b\u0010 \u001a\u00020\fH&J\b\u0010!\u001a\u00020\fH&J\b\u0010\"\u001a\u00020\u0004H&J\u0010\u0010$\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\fH&\u00a8\u0006'"}, d2 = {"Lcom/tencent/qui/quiblurview/f;", "", "Lcom/tencent/qui/quiblurview/f$a;", "param", "", "a", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "onResume", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "tag", "setDebugTag", "", "enable", "setEnableBlur", "Lcom/tencent/qui/quiblurview/f$c;", "listener", "setDrawBackgroundListener", "Landroid/view/View;", "bgView", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "bgList", "Lcom/tencent/qui/quiblurview/f$d;", "nativeBlurParam", "isViewScaled", "setBlurSource", "Landroid/graphics/drawable/Drawable;", "overlayDrawable", "setOverlayDrawable", "disableDrawable", "setDisableDrawable", "isPaused", "b", "invalidate", "directDraw", "setDirectDrawMode", "c", "d", "QUIBlurView_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes25.dex */
public interface f {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010#\u001a\u00020\u0007\u0012\u0006\u0010(\u001a\u00020$\u0012\b\u0010,\u001a\u0004\u0018\u00010)\u0012\u0006\u00100\u001a\u00020\u0004\u0012\b\u00104\u001a\u0004\u0018\u000101\u0012\b\u00107\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b8\u00109J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0013\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR$\u0010\u001b\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001f\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\n\u001a\u0004\b\u001d\u0010\f\"\u0004\b\u001e\u0010\u000eR\"\u0010\"\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010\n\u001a\u0004\b\u0015\u0010\f\"\u0004\b!\u0010\u000eR\u0017\u0010#\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b \u0010\fR\u0017\u0010(\u001a\u00020$8\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010%\u001a\u0004\b&\u0010'R\u0019\u0010,\u001a\u0004\u0018\u00010)8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010*\u001a\u0004\b\t\u0010+R\u0017\u00100\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b\u0010\u0010/R\u0019\u00104\u001a\u0004\u0018\u0001018\u0006\u00a2\u0006\f\n\u0004\b&\u00102\u001a\u0004\b-\u00103R\u0019\u00107\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001d\u00105\u001a\u0004\b\u001c\u00106\u00a8\u0006:"}, d2 = {"Lcom/tencent/qui/quiblurview/f$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "f", "()Z", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Z)V", "enableFixEmptyBlurBmp", "b", tl.h.F, "o", "openOptimization", "Lcom/tencent/qui/quiblurview/f$d;", "c", "Lcom/tencent/qui/quiblurview/f$d;", "g", "()Lcom/tencent/qui/quiblurview/f$d;", DomainData.DOMAIN_NAME, "(Lcom/tencent/qui/quiblurview/f$d;)V", "nativeBlurParam", "d", "k", "p", "isViewScaled", "e", "l", "directDraw", "enable", "", UserInfo.SEX_FEMALE, "j", "()F", "radius", "Landroid/view/View;", "Landroid/view/View;", "()Landroid/view/View;", "backgroundView", "i", "I", "()I", "clearColor", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/drawable/Drawable;", "()Landroid/graphics/drawable/Drawable;", "overlayDrawable", "Ljava/lang/Integer;", "()Ljava/lang/Integer;", "disableBlurDrawableRes", "<init>", "(ZFLandroid/view/View;ILandroid/graphics/drawable/Drawable;Ljava/lang/Integer;)V", "QUIBlurView_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes25.dex */
    public static final /* data */ class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private boolean enableFixEmptyBlurBmp;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private boolean openOptimization;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private d nativeBlurParam;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private boolean isViewScaled;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private boolean directDraw;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final boolean enable;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        private final float radius;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final View backgroundView;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        private final int clearColor;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final Drawable overlayDrawable;

        /* renamed from: k, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final Integer disableBlurDrawableRes;

        public a(boolean z16, float f16, @Nullable View view, int i3, @Nullable Drawable drawable, @Nullable Integer num) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                iPatchRedirector.redirect((short) 17, this, Boolean.valueOf(z16), Float.valueOf(f16), view, Integer.valueOf(i3), drawable, num);
                return;
            }
            this.enable = z16;
            this.radius = f16;
            this.backgroundView = view;
            this.clearColor = i3;
            this.overlayDrawable = drawable;
            this.disableBlurDrawableRes = num;
        }

        @Nullable
        public final View a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return (View) iPatchRedirector.redirect((short) 13, (Object) this);
            }
            return this.backgroundView;
        }

        public final int b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
            }
            return this.clearColor;
        }

        public final boolean c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
            }
            return this.directDraw;
        }

        @Nullable
        public final Integer d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                return (Integer) iPatchRedirector.redirect((short) 16, (Object) this);
            }
            return this.disableBlurDrawableRes;
        }

        public final boolean e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
            }
            return this.enable;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
                return ((Boolean) iPatchRedirector.redirect((short) 27, (Object) this, other)).booleanValue();
            }
            if (this != other) {
                if (other instanceof a) {
                    a aVar = (a) other;
                    if (this.enable != aVar.enable || Float.compare(this.radius, aVar.radius) != 0 || !Intrinsics.areEqual(this.backgroundView, aVar.backgroundView) || this.clearColor != aVar.clearColor || !Intrinsics.areEqual(this.overlayDrawable, aVar.overlayDrawable) || !Intrinsics.areEqual(this.disableBlurDrawableRes, aVar.disableBlurDrawableRes)) {
                        return false;
                    }
                    return true;
                }
                return false;
            }
            return true;
        }

        public final boolean f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                return ((Boolean) iPatchRedirector.redirect((short) 1, (Object) this)).booleanValue();
            }
            return this.enableFixEmptyBlurBmp;
        }

        @Nullable
        public final d g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (d) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return this.nativeBlurParam;
        }

        public final boolean h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return this.openOptimization;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v13 */
        /* JADX WARN: Type inference failed for: r0v17 */
        /* JADX WARN: Type inference failed for: r0v2, types: [int] */
        public int hashCode() {
            int i3;
            int i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
                return ((Integer) iPatchRedirector.redirect((short) 26, (Object) this)).intValue();
            }
            boolean z16 = this.enable;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            int floatToIntBits = ((r06 * 31) + Float.floatToIntBits(this.radius)) * 31;
            View view = this.backgroundView;
            int i17 = 0;
            if (view != null) {
                i3 = view.hashCode();
            } else {
                i3 = 0;
            }
            int i18 = (((floatToIntBits + i3) * 31) + this.clearColor) * 31;
            Drawable drawable = this.overlayDrawable;
            if (drawable != null) {
                i16 = drawable.hashCode();
            } else {
                i16 = 0;
            }
            int i19 = (i18 + i16) * 31;
            Integer num = this.disableBlurDrawableRes;
            if (num != null) {
                i17 = num.hashCode();
            }
            return i19 + i17;
        }

        @Nullable
        public final Drawable i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return (Drawable) iPatchRedirector.redirect((short) 15, (Object) this);
            }
            return this.overlayDrawable;
        }

        public final float j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return ((Float) iPatchRedirector.redirect((short) 12, (Object) this)).floatValue();
            }
            return this.radius;
        }

        public final boolean k() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
            }
            return this.isViewScaled;
        }

        public final void l(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                iPatchRedirector.redirect((short) 10, (Object) this, z16);
            } else {
                this.directDraw = z16;
            }
        }

        public final void m(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
            } else {
                this.enableFixEmptyBlurBmp = z16;
            }
        }

        public final void n(@Nullable d dVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) dVar);
            } else {
                this.nativeBlurParam = dVar;
            }
        }

        public final void o(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, z16);
            } else {
                this.openOptimization = z16;
            }
        }

        public final void p(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, z16);
            } else {
                this.isViewScaled = z16;
            }
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
                return (String) iPatchRedirector.redirect((short) 25, (Object) this);
            }
            return "BlurParam(enable=" + this.enable + ", radius=" + this.radius + ", backgroundView=" + this.backgroundView + ", clearColor=" + this.clearColor + ", overlayDrawable=" + this.overlayDrawable + ", disableBlurDrawableRes=" + this.disableBlurDrawableRes + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/qui/quiblurview/f$b;", "", "", "a", "QUIBlurView_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes25.dex */
    public interface b {
        boolean a();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/qui/quiblurview/f$c;", "", "", "onDrawBegin", "a", "QUIBlurView_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes25.dex */
    public interface c {
        void a();

        void onDrawBegin();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0012\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u000b\u001a\u0004\b\n\u0010\r\"\u0004\b\u0011\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/qui/quiblurview/f$d;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/qui/quiblurview/f$b;", "a", "Lcom/tencent/qui/quiblurview/f$b;", "b", "()Lcom/tencent/qui/quiblurview/f$b;", "d", "(Lcom/tencent/qui/quiblurview/f$b;)V", "parentBlurSourceDirtyState", "c", "childBlurSourceDirtyState", "<init>", "(Lcom/tencent/qui/quiblurview/f$b;Lcom/tencent/qui/quiblurview/f$b;)V", "QUIBlurView_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes25.dex */
    public static final /* data */ class d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private b parentBlurSourceDirtyState;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private b childBlurSourceDirtyState;

        public d() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
                return;
            }
            iPatchRedirector.redirect((short) 7, (Object) this);
        }

        @Nullable
        public final b a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (b) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.childBlurSourceDirtyState;
        }

        @Nullable
        public final b b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                return (b) iPatchRedirector.redirect((short) 1, (Object) this);
            }
            return this.parentBlurSourceDirtyState;
        }

        public final void c(@Nullable b bVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) bVar);
            } else {
                this.childBlurSourceDirtyState = bVar;
            }
        }

        public final void d(@Nullable b bVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar);
            } else {
                this.parentBlurSourceDirtyState = bVar;
            }
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, other)).booleanValue();
            }
            if (this != other) {
                if (other instanceof d) {
                    d dVar = (d) other;
                    if (!Intrinsics.areEqual(this.parentBlurSourceDirtyState, dVar.parentBlurSourceDirtyState) || !Intrinsics.areEqual(this.childBlurSourceDirtyState, dVar.childBlurSourceDirtyState)) {
                        return false;
                    }
                    return true;
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
            }
            b bVar = this.parentBlurSourceDirtyState;
            int i16 = 0;
            if (bVar != null) {
                i3 = bVar.hashCode();
            } else {
                i3 = 0;
            }
            int i17 = i3 * 31;
            b bVar2 = this.childBlurSourceDirtyState;
            if (bVar2 != null) {
                i16 = bVar2.hashCode();
            }
            return i17 + i16;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (String) iPatchRedirector.redirect((short) 11, (Object) this);
            }
            return "QQNativeBlurParam(parentBlurSourceDirtyState=" + this.parentBlurSourceDirtyState + ", childBlurSourceDirtyState=" + this.childBlurSourceDirtyState + ")";
        }

        public d(@Nullable b bVar, @Nullable b bVar2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) bVar, (Object) bVar2);
            } else {
                this.parentBlurSourceDirtyState = bVar;
                this.childBlurSourceDirtyState = bVar2;
            }
        }

        public /* synthetic */ d(b bVar, b bVar2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : bVar, (i3 & 2) == 0 ? bVar2 : null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                return;
            }
            iPatchRedirector.redirect((short) 6, this, bVar, bVar2, Integer.valueOf(i3), defaultConstructorMarker);
        }
    }

    void a(@NotNull a param);

    boolean b();

    void invalidate();

    boolean isPaused();

    void onDestroy();

    void onPause();

    void onResume();

    void setBlurSource(@NotNull View bgView, @Nullable ArrayList<Object> bgList, @Nullable d nativeBlurParam, boolean isViewScaled);

    void setDebugTag(@NotNull String tag);

    void setDirectDrawMode(boolean directDraw);

    void setDisableDrawable(@Nullable Drawable disableDrawable);

    void setDrawBackgroundListener(@Nullable c listener);

    void setEnableBlur(boolean enable);

    void setOverlayDrawable(@Nullable Drawable overlayDrawable);
}
