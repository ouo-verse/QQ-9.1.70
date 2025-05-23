package com.tencent.qui.quiblurview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RenderEffect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.annotation.ChecksSdkIntAtLeast;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qui.quiblurview.f;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 l2\u00020\u00012\u00020\u0002:\u0003mnoB'\b\u0007\u0012\u0006\u0010f\u001a\u00020e\u0012\n\b\u0002\u0010h\u001a\u0004\u0018\u00010g\u0012\b\b\u0002\u0010i\u001a\u00020F\u00a2\u0006\u0004\bj\u0010kJ\b\u0010\u0004\u001a\u00020\u0003H\u0003J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0001J\u0006\u0010\u000b\u001a\u00020\u0007J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0015J\b\u0010\u000f\u001a\u00020\u0007H\u0016J\b\u0010\u0010\u001a\u00020\u0007H\u0014J\b\u0010\u0011\u001a\u00020\u0007H\u0014J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0003H\u0016R.\u0010\u001b\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR.\u0010\u001f\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u0016\u001a\u0004\b\u001d\u0010\u0018\"\u0004\b\u001e\u0010\u001aR.\u0010'\u001a\u0004\u0018\u00010 2\b\u0010\u0015\u001a\u0004\u0018\u00010 8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010.\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R*\u00103\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00038\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010/\u001a\u0004\b\u001c\u00100\"\u0004\b1\u00102R*\u00106\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00038\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b4\u0010/\u001a\u0004\b(\u00100\"\u0004\b5\u00102R\"\u0010>\u001a\u0002078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\"\u0010E\u001a\u00020?8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\b!\u0010B\"\u0004\bC\u0010DR\"\u0010M\u001a\u00020F8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u0018\u0010P\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010OR\u0014\u0010T\u001a\u00020Q8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bR\u0010SR\"\u0010X\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bU\u0010/\u001a\u0004\bV\u00100\"\u0004\bW\u00102R$\u0010_\u001a\u0004\u0018\u00010Y8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bH\u0010Z\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R\u0014\u0010b\u001a\u00020`8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u0010aR\u0016\u0010d\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bc\u0010/\u00a8\u0006p"}, d2 = {"Lcom/tencent/qui/quiblurview/QQNativeBlurView;", "Landroid/view/View;", "", "", "i", "", "radius", "", "setBlurRadius", "view", "setBackgroundView", "d", "Landroid/graphics/Canvas;", PM.CANVAS, "onDraw", "invalidate", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "isDirty", "j", "Landroid/graphics/drawable/Drawable;", "value", "Landroid/graphics/drawable/Drawable;", "g", "()Landroid/graphics/drawable/Drawable;", "setOverlay", "(Landroid/graphics/drawable/Drawable;)V", "overlay", "e", "getDisableBackgroundDrawable", "setDisableBackgroundDrawable", "disableBackgroundDrawable", "Lcom/tencent/qui/quiblurview/QQNativeBlurView$b;", "f", "Lcom/tencent/qui/quiblurview/QQNativeBlurView$b;", "getBlurSource", "()Lcom/tencent/qui/quiblurview/QQNativeBlurView$b;", "setBlurSource", "(Lcom/tencent/qui/quiblurview/QQNativeBlurView$b;)V", "blurSource", tl.h.F, UserInfo.SEX_FEMALE, "getScaleFactor", "()F", "setScaleFactor", "(F)V", "scaleFactor", "Z", "()Z", "setEnable", "(Z)V", "enable", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "setPause", "pause", "", BdhLogUtil.LogTag.Tag_Conn, "J", "getPreDrawInterval", "()J", "setPreDrawInterval", "(J)V", "preDrawInterval", "", "D", "Ljava/lang/String;", "()Ljava/lang/String;", "setMDebugTag", "(Ljava/lang/String;)V", "mDebugTag", "", "E", "I", "getClearColor", "()I", "setClearColor", "(I)V", "clearColor", "Landroid/graphics/Bitmap;", "Landroid/graphics/Bitmap;", "lastBackgroundBitmap", "Lcom/tencent/qui/quiblurview/QQNativeBlurView$a;", "G", "Lcom/tencent/qui/quiblurview/QQNativeBlurView$a;", "bitmapPool", "H", "getDirectDraw", "setDirectDraw", "directDraw", "Lcom/tencent/qui/quiblurview/f$c;", "Lcom/tencent/qui/quiblurview/f$c;", "getOnDrawBackgroundListener", "()Lcom/tencent/qui/quiblurview/f$c;", "setOnDrawBackgroundListener", "(Lcom/tencent/qui/quiblurview/f$c;)V", "onDrawBackgroundListener", "Landroid/graphics/Paint;", "Landroid/graphics/Paint;", "paint", "K", "forceRefresh", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "defaultStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "M", "a", "b", "c", "QUIBlurView_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes25.dex */
public class QQNativeBlurView extends View {
    static IPatchRedirector $redirector_;
    private static final boolean L;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private long preDrawInterval;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private String mDebugTag;

    /* renamed from: E, reason: from kotlin metadata */
    private int clearColor;

    /* renamed from: F, reason: from kotlin metadata */
    private Bitmap lastBackgroundBitmap;

    /* renamed from: G, reason: from kotlin metadata */
    private final a bitmapPool;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean directDraw;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private f.c onDrawBackgroundListener;

    /* renamed from: J, reason: from kotlin metadata */
    private final Paint paint;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean forceRefresh;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Drawable overlay;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Drawable disableBackgroundDrawable;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b blurSource;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private float scaleFactor;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean enable;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean pause;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J\u001e\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qui/quiblurview/QQNativeBlurView$a;", "", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "a", "b", "", "width", "height", "clearColor", "c", "Ljava/util/LinkedList;", "Ljava/util/LinkedList;", "bitmapPool", "<init>", "()V", "QUIBlurView_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes25.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final LinkedList<Bitmap> bitmapPool;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            } else {
                this.bitmapPool = new LinkedList<>();
            }
        }

        public final void a(@NotNull Bitmap bitmap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) bitmap);
                return;
            }
            Intrinsics.checkNotNullParameter(bitmap, "bitmap");
            synchronized (this.bitmapPool) {
                this.bitmapPool.addLast(bitmap);
                Unit unit = Unit.INSTANCE;
            }
        }

        public final void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            synchronized (this.bitmapPool) {
                Iterator<T> it = this.bitmapPool.iterator();
                while (it.hasNext()) {
                    ((Bitmap) it.next()).recycle();
                }
                this.bitmapPool.clear();
                Unit unit = Unit.INSTANCE;
            }
        }

        @NotNull
        public final Bitmap c(int width, int height, int clearColor) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Bitmap) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(width), Integer.valueOf(height), Integer.valueOf(clearColor));
            }
            synchronized (this.bitmapPool) {
                while (!this.bitmapPool.isEmpty()) {
                    Bitmap bitmap = this.bitmapPool.removeLast();
                    Intrinsics.checkNotNullExpressionValue(bitmap, "bitmap");
                    if (bitmap.getWidth() == width && bitmap.getHeight() == height) {
                        bitmap.eraseColor(clearColor);
                        return bitmap;
                    }
                    bitmap.recycle();
                }
                Unit unit = Unit.INSTANCE;
                Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                createBitmap.eraseColor(clearColor);
                Intrinsics.checkNotNullExpressionValue(createBitmap, "Bitmap.createBitmap(widt\u2026clearColor)\n            }");
                return createBitmap;
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH&J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH&J\b\u0010\u000e\u001a\u00020\rH&J\b\u0010\u000f\u001a\u00020\rH&J\u0014\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u0010H&\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qui/quiblurview/QQNativeBlurView$b;", "", "", "position", "", "a", "Landroid/graphics/Canvas;", PM.CANVAS, "draw", "Lcom/tencent/qui/quiblurview/QQNativeBlurView;", "qqNativeBlurView", "b", "c", "", "getScrollX", "getScrollY", "Lkotlin/Pair;", "", "getScale", "QUIBlurView_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes25.dex */
    public interface b {
        void a(@NotNull int[] position);

        void b(@NotNull QQNativeBlurView qqNativeBlurView);

        void c(@NotNull QQNativeBlurView qqNativeBlurView);

        void draw(@NotNull Canvas canvas);

        @NotNull
        Pair<Float, Float> getScale();

        int getScrollX();

        int getScrollY();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b%\u0010&J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J,\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J0\u0010\u0014\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0002H\u0002J0\u0010\u0015\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0002H\u0002R\u0017\u0010\u0017\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001e\u001a\u00020\u001d8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010#\u001a\u00020\"8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006'"}, d2 = {"Lcom/tencent/qui/quiblurview/QQNativeBlurView$c;", "", "", "value", "f", "viewWidth", "viewHeight", "", "scale", "Lkotlin/Pair;", "c", "Landroid/graphics/Canvas;", PM.CANVAS, "Lcom/tencent/qui/quiblurview/QQNativeBlurView$b;", "background", "Landroid/view/View;", "blurView", "targetWidth", "targetHeight", "", "d", "g", "", "VERBOSE_LOG", "Z", "e", "()Z", "DEFAULT_SCALE_FACTOR", UserInfo.SEX_FEMALE, "", "PRE_DRAW_INTERVAL", "J", "ROUNDING_VALUE", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "QUIBlurView_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.qui.quiblurview.QQNativeBlurView$c, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Pair<Integer, Integer> c(int viewWidth, int viewHeight, float scale) {
            int ceil = (int) Math.ceil(viewWidth / scale);
            int f16 = f(ceil);
            int f17 = f((int) Math.ceil(viewHeight / scale));
            if (f16 != 0 && f17 != 0) {
                return new Pair<>(Integer.valueOf(f16), Integer.valueOf(f17));
            }
            return new Pair<>(Integer.valueOf(viewWidth), Integer.valueOf(viewHeight));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void d(Canvas canvas, b background, View blurView, int targetWidth, int targetHeight) {
            long currentTimeMillis = System.currentTimeMillis();
            canvas.save();
            QQNativeBlurView.INSTANCE.g(canvas, blurView, background, targetWidth, targetHeight);
            background.draw(canvas);
            canvas.restore();
            if (e()) {
                Log.i("QQNativeBlurView", "[drawBackground] time=" + (System.currentTimeMillis() - currentTimeMillis) + " ms");
            }
        }

        private final int f(int value) {
            int i3 = value % 8;
            if (i3 != 0) {
                return (value - i3) + 8;
            }
            return value;
        }

        private final void g(Canvas canvas, View blurView, b background, int targetWidth, int targetHeight) {
            blurView.getLocationOnScreen(new int[2]);
            background.a(new int[2]);
            float width = (targetWidth * 1.0f) / blurView.getWidth();
            float height = (targetHeight * 1.0f) / blurView.getHeight();
            Pair<Float, Float> scale = background.getScale();
            canvas.translate((((-(r1[0] - r0[0])) * width) / scale.getFirst().floatValue()) - (background.getScrollX() * width), (((-(r1[1] - r0[1])) * height) / scale.getSecond().floatValue()) - (background.getScrollY() * height));
            canvas.scale(width, height);
            e();
        }

        public final boolean e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return QQNativeBlurView.L;
            }
            return ((Boolean) iPatchRedirector.redirect((short) 1, (Object) this)).booleanValue();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9262);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 35)) {
            redirector.redirect((short) 35);
        } else {
            INSTANCE = new Companion(null);
            L = ud0.g.b("blur_view_verbose_log_enabled_8895", false);
        }
    }

    @JvmOverloads
    public QQNativeBlurView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 34)) {
            return;
        }
        iPatchRedirector.redirect((short) 34, (Object) this, (Object) context);
    }

    @ChecksSdkIntAtLeast(api = 31)
    private final boolean i() {
        if (Build.VERSION.SDK_INT >= 31) {
            return true;
        }
        return false;
    }

    public final void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
            return;
        }
        Bitmap bitmap = this.lastBackgroundBitmap;
        if (bitmap != null) {
            this.lastBackgroundBitmap = null;
            bitmap.recycle();
        }
        this.bitmapPool.b();
    }

    public final boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return this.enable;
    }

    @NotNull
    public final String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this.mDebugTag;
    }

    @Nullable
    public final Drawable g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (Drawable) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return this.overlay;
    }

    public final boolean h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return this.pause;
    }

    @Override // android.view.View
    public void invalidate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this);
        } else {
            this.forceRefresh = true;
            super.invalidate();
        }
    }

    public void j(boolean isDirty) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, isDirty);
            return;
        }
        if (this.enable && d.a()) {
            if (!this.pause && this.blurSource != null && (isDirty || this.forceRefresh || this.lastBackgroundBitmap == null)) {
                this.forceRefresh = false;
                Companion companion = INSTANCE;
                Pair c16 = companion.c(getWidth(), getHeight(), this.scaleFactor);
                if (((Number) c16.getFirst()).intValue() != 0 && ((Number) c16.getSecond()).intValue() != 0) {
                    if (this.directDraw) {
                        if (isDirty) {
                            super.invalidate();
                        }
                    } else {
                        Bitmap bitmap = this.lastBackgroundBitmap;
                        Bitmap c17 = this.bitmapPool.c(((Number) c16.getFirst()).intValue(), ((Number) c16.getSecond()).intValue(), this.clearColor);
                        f.c cVar = this.onDrawBackgroundListener;
                        if (cVar != null) {
                            cVar.onDrawBegin();
                        }
                        Canvas canvas = new Canvas(c17);
                        b bVar = this.blurSource;
                        Intrinsics.checkNotNull(bVar);
                        companion.d(canvas, bVar, this, c17.getWidth(), c17.getHeight());
                        f.c cVar2 = this.onDrawBackgroundListener;
                        if (cVar2 != null) {
                            cVar2.a();
                        }
                        Unit unit = Unit.INSTANCE;
                        this.lastBackgroundBitmap = c17;
                        if (bitmap != null) {
                            this.bitmapPool.a(bitmap);
                        }
                        super.invalidate();
                    }
                    if (L) {
                        ud0.d.g("QQNativeBlurView", ud0.d.f438810d, "[onPreDraw] complete drawing, this=" + hashCode() + " size=" + ((Number) c16.getFirst()).intValue() + ',' + ((Number) c16.getSecond()).intValue());
                        return;
                    }
                    return;
                }
                if (L) {
                    ud0.d.g("QQNativeBlurView", ud0.d.f438810d, "[onPreDraw] scaled size is zero, this=" + hashCode());
                    return;
                }
                return;
            }
            if (L) {
                ud0.d.g("QQNativeBlurView", ud0.d.f438810d, "[onPreDraw] ignore drawing, this=" + hashCode() + " pause=" + this.pause + " dirty=" + isDirty);
                return;
            }
            return;
        }
        if (L) {
            ud0.d.g("QQNativeBlurView", ud0.d.f438810d, "[onPreDraw] enable is false, this=" + hashCode());
        }
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        Integer num;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this);
            return;
        }
        super.onAttachedToWindow();
        b bVar = this.blurSource;
        if (bVar != null) {
            bVar.b(this);
        }
        if (L) {
            int i3 = ud0.d.f438810d;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[onAttachedToWindow] this=");
            sb5.append(hashCode());
            sb5.append(" blurSource=");
            b bVar2 = this.blurSource;
            if (bVar2 != null) {
                num = Integer.valueOf(bVar2.hashCode());
            } else {
                num = null;
            }
            sb5.append(num);
            ud0.d.g("QQNativeBlurView", i3, sb5.toString());
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        Integer num;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this);
            return;
        }
        b bVar = this.blurSource;
        if (bVar != null) {
            bVar.c(this);
        }
        super.onDetachedFromWindow();
        if (L) {
            int i3 = ud0.d.f438810d;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[onDetachedFromWindow] this=");
            sb5.append(hashCode());
            sb5.append(" blurSource=");
            b bVar2 = this.blurSource;
            if (bVar2 != null) {
                num = Integer.valueOf(bVar2.hashCode());
            } else {
                num = null;
            }
            sb5.append(num);
            ud0.d.g("QQNativeBlurView", i3, sb5.toString());
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onDraw(@NotNull Canvas canvas) {
        Integer num;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) canvas);
            return;
        }
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        if (this.enable && d.a()) {
            if (this.directDraw) {
                b bVar = this.blurSource;
                if (bVar != null) {
                    INSTANCE.d(canvas, bVar, this, getWidth(), getHeight());
                }
            } else {
                Bitmap bitmap = this.lastBackgroundBitmap;
                if (bitmap != null) {
                    canvas.drawBitmap(bitmap, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), new Rect(0, 0, getWidth(), getHeight()), this.paint);
                }
            }
            Drawable drawable = this.overlay;
            if (drawable != null) {
                drawable.setBounds(0, 0, getWidth(), getHeight());
                drawable.draw(canvas);
            }
            if (L) {
                int i3 = ud0.d.f438810d;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("[onDraw] draw blurred background");
                sb5.append(", this=");
                sb5.append(hashCode());
                sb5.append(" size=");
                sb5.append(getWidth());
                sb5.append(',');
                sb5.append(getHeight());
                sb5.append(" bitmap=");
                Bitmap bitmap2 = this.lastBackgroundBitmap;
                if (bitmap2 != null) {
                    num = Integer.valueOf(bitmap2.hashCode());
                } else {
                    num = null;
                }
                sb5.append(num);
                ud0.d.g("QQNativeBlurView", i3, sb5.toString());
                return;
            }
            return;
        }
        Drawable drawable2 = this.disableBackgroundDrawable;
        if (drawable2 != null) {
            drawable2.setBounds(0, 0, getWidth(), getHeight());
            drawable2.draw(canvas);
        }
        if (L) {
            ud0.d.g("QQNativeBlurView", ud0.d.f438810d, "[onDraw] draw disable background, this=" + hashCode() + " pause=" + this.pause + " enable=" + this.enable);
        }
    }

    public final void setBackgroundView(@NotNull View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) view);
        } else {
            Intrinsics.checkNotNullParameter(view, "view");
            setBlurSource(new g(view, null, null, false, 8, null));
        }
    }

    public final void setBlurRadius(float radius) {
        RenderEffect createBlurEffect;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, Float.valueOf(radius));
            return;
        }
        if (!i()) {
            Log.i("QQNativeBlurView", "[setBlurRadius] not supported by this api level");
            return;
        }
        if (radius != 0.0f) {
            createBlurEffect = RenderEffect.createBlurEffect(radius, radius, Shader.TileMode.CLAMP);
            Intrinsics.checkNotNullExpressionValue(createBlurEffect, "RenderEffect.createBlurE\u2026s, Shader.TileMode.CLAMP)");
            setRenderEffect(createBlurEffect);
        } else {
            setRenderEffect(null);
        }
        invalidate();
    }

    public final void setBlurSource(@Nullable b bVar) {
        b bVar2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) bVar);
            return;
        }
        b bVar3 = this.blurSource;
        if (bVar3 != null) {
            bVar3.c(this);
        }
        this.blurSource = bVar;
        if (isAttachedToWindow() && (bVar2 = this.blurSource) != null) {
            bVar2.b(this);
        }
    }

    public final void setClearColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, i3);
        } else {
            this.clearColor = i3;
        }
    }

    public final void setDirectDraw(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, z16);
        } else {
            this.directDraw = z16;
        }
    }

    public final void setDisableBackgroundDrawable(@Nullable Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) drawable);
        } else {
            this.disableBackgroundDrawable = drawable;
            postInvalidate();
        }
    }

    public final void setEnable(boolean z16) {
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
            return;
        }
        if (z16 && i()) {
            z17 = true;
        } else {
            z17 = false;
        }
        this.enable = z17;
        postInvalidate();
    }

    public final void setMDebugTag(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.mDebugTag = str;
        }
    }

    public final void setOnDrawBackgroundListener(@Nullable f.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) cVar);
        } else {
            this.onDrawBackgroundListener = cVar;
        }
    }

    public final void setOverlay(@Nullable Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) drawable);
        } else {
            this.overlay = drawable;
            postInvalidate();
        }
    }

    public final void setPause(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, z16);
        } else {
            if (this.pause == z16) {
                return;
            }
            this.pause = z16;
            if (!z16) {
                postInvalidate();
            }
        }
    }

    public final void setPreDrawInterval(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, j3);
        } else {
            this.preDrawInterval = j3;
        }
    }

    public final void setScaleFactor(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Float.valueOf(f16));
        } else {
            this.scaleFactor = f16;
        }
    }

    @JvmOverloads
    public QQNativeBlurView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 33)) {
            return;
        }
        iPatchRedirector.redirect((short) 33, (Object) this, (Object) context, (Object) attributeSet);
    }

    public /* synthetic */ QQNativeBlurView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 32)) {
            return;
        }
        iPatchRedirector.redirect((short) 32, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QQNativeBlurView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.scaleFactor = 8.0f;
        this.enable = i();
        this.preDrawInterval = 4L;
        this.mDebugTag = "";
        this.bitmapPool = new a();
        Paint paint = new Paint();
        paint.setFilterBitmap(false);
        Unit unit = Unit.INSTANCE;
        this.paint = paint;
        setBackground(null);
    }
}
