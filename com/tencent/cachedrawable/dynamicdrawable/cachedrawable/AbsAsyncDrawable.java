package com.tencent.cachedrawable.dynamicdrawable.cachedrawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ams.mosaic.jsengine.animation.custom.CustomAnimation;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0007\n\u0002\b\u000b\b&\u0018\u0000 82\u00020\u00012\u00020\u0002:\u0003jklB\u0007\u00a2\u0006\u0004\bh\u0010iJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0016\u0010\b\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006H\u0016J\u0016\u0010\t\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006H\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016J\b\u0010\f\u001a\u00020\u000bH&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH&J\u0012\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u000bH\u0007J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J(\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0015H\u0016J\u0012\u0010\u001d\u001a\u00020\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0014J\b\u0010\u001e\u001a\u00020\u0015H\u0016J\u0006\u0010\u001f\u001a\u00020\u0015J\b\u0010 \u001a\u00020\u0015H\u0016J\u0006\u0010!\u001a\u00020\u0015J\b\u0010\"\u001a\u00020\u0015H\u0016J\n\u0010$\u001a\u0004\u0018\u00010#H\u0016J\u0010\u0010&\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u001bH\u0016J\u0010\u0010(\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u0001H\u0004J\u0010\u0010*\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\u0015H\u0016J\u0018\u0010-\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\u000bH\u0016J\u0012\u00100\u001a\u00020\u00032\b\u0010/\u001a\u0004\u0018\u00010.H\u0016J\u0018\u00100\u001a\u00020\u00032\u0006\u00101\u001a\u00020\u00152\u0006\u00103\u001a\u000202H\u0016R,\u0010:\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R*\u0010>\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b;\u00105\u001a\u0004\b<\u00107\"\u0004\b=\u00109R.\u0010F\u001a\u0004\u0018\u00010\u00012\b\u0010?\u001a\u0004\u0018\u00010\u00018\u0006@BX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001c\u0010H\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bG\u00105R\u001c\u0010I\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u00105R\u0014\u0010L\u001a\u00020J8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010KR\u0016\u0010O\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0018\u0010Q\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010PR\u0016\u0010S\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010NR\u0018\u0010U\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010TR\u001c\u0010Y\u001a\u00020\u000b8\u0016@\u0016X\u0096\u000f\u00a2\u0006\f\u001a\u0004\bV\u0010W\"\u0004\bN\u0010XR\u001c\u0010^\u001a\u00020\u00158\u0016@\u0016X\u0096\u000f\u00a2\u0006\f\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\u001c\u0010a\u001a\u00020\u00158\u0016@\u0016X\u0096\u000f\u00a2\u0006\f\u001a\u0004\b_\u0010[\"\u0004\b`\u0010]R\u001c\u0010g\u001a\u00020b8\u0016@\u0016X\u0096\u000f\u00a2\u0006\f\u001a\u0004\bc\u0010d\"\u0004\be\u0010f\u00a8\u0006m"}, d2 = {"Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/AbsAsyncDrawable;", "Landroid/graphics/drawable/Drawable;", "", "", "N", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lkotlin/Function0;", "block", "E", BdhLogUtil.LogTag.Tag_Conn, "B", "", HippyTKDListViewAdapter.X, "Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/m;", "callback", DomainData.DOMAIN_NAME, "isAsync", "y", "Landroid/graphics/Canvas;", PM.CANVAS, "draw", "", "left", "top", "right", "bottom", "setBounds", "Landroid/graphics/Rect;", "bounds", "onBoundsChange", "getIntrinsicHeight", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "getIntrinsicWidth", "r", "getOpacity", "Landroid/graphics/drawable/Drawable$ConstantState;", "getConstantState", "padding", "getPadding", "child", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, com.tencent.luggage.wxa.c8.c.f123400v, "setAlpha", NodeProps.VISIBLE, "restart", "setVisible", "Landroid/graphics/ColorFilter;", CustomAnimation.KeyPath.COLOR_FILTER, "setColorFilter", "color", "Landroid/graphics/PorterDuff$Mode;", "mode", "e", "Lkotlin/jvm/functions/Function0;", "p", "()Lkotlin/jvm/functions/Function0;", "H", "(Lkotlin/jvm/functions/Function0;)V", "failedDrawableBuild", "f", "w", "M", "targetDrawableBuild", "value", tl.h.F, "Landroid/graphics/drawable/Drawable;", "o", "()Landroid/graphics/drawable/Drawable;", "G", "(Landroid/graphics/drawable/Drawable;)V", "currentDrawable", "i", "doFailedDrawableBuild", "doTargetDrawableBuild", "Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/AbsAsyncDrawable$a;", "Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/AbsAsyncDrawable$a;", "callbackProxy", "D", "I", "tmpalpha", "Landroid/graphics/ColorFilter;", "tmpColorFilter", UserInfo.SEX_FEMALE, "tmpColorFilterInt", "Landroid/graphics/PorterDuff$Mode;", "tmpColorFilterMode", ReportConstant.COSTREPORT_PREFIX, "()Z", "(Z)V", "requestLayoutAfterDrawableChange", "t", "()I", "J", "(I)V", "requestLodingHeight", "u", "K", "requestLodingWidth", "", "v", "()F", "L", "(F)V", "scaleXY", "<init>", "()V", "a", "b", "c", "cachedrawable_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes5.dex */
public abstract class AbsAsyncDrawable extends Drawable {
    static IPatchRedirector $redirector_;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final Handler I;

    @NotNull
    private static final Handler J;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final a callbackProxy;

    /* renamed from: D, reason: from kotlin metadata */
    private int tmpalpha;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private ColorFilter tmpColorFilter;

    /* renamed from: F, reason: from kotlin metadata */
    private int tmpColorFilterInt;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private PorterDuff.Mode tmpColorFilterMode;

    /* renamed from: d, reason: collision with root package name */
    private final /* synthetic */ f f98884d;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function0<? extends Drawable> failedDrawableBuild;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Function0<? extends Drawable> targetDrawableBuild;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Drawable currentDrawable;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function0<Drawable> doFailedDrawableBuild;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function0<Drawable> doTargetDrawableBuild;

    /* compiled from: P */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u0018\u00a2\u0006\u0004\b \u0010\u001dJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016J \u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0006\u0010\b\u001a\u00020\rR\"\u0010\u0014\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0017\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\"\u0010\u001e\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/AbsAsyncDrawable$a;", "Landroid/graphics/drawable/Drawable$Callback;", "Landroid/graphics/drawable/Drawable;", "who", "Ljava/lang/Runnable;", "what", "", "unscheduleDrawable", "d", "invalidateDrawable", "", "time", "scheduleDrawable", "", "", "I", "c", "()I", "f", "(I)V", "lastWidth", "e", "b", "lastHeight", "Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/AbsAsyncDrawable;", "Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/AbsAsyncDrawable;", "a", "()Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/AbsAsyncDrawable;", "setDrawable", "(Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/AbsAsyncDrawable;)V", "drawable", "absAsyncDrawable", "<init>", "cachedrawable_debug"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes5.dex */
    public static final class a implements Drawable.Callback {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private int lastWidth;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private int lastHeight;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private AbsAsyncDrawable drawable;

        public a(@NotNull AbsAsyncDrawable absAsyncDrawable) {
            Intrinsics.checkNotNullParameter(absAsyncDrawable, "absAsyncDrawable");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) absAsyncDrawable);
            } else {
                this.drawable = absAsyncDrawable;
            }
        }

        @NotNull
        public final AbsAsyncDrawable a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (AbsAsyncDrawable) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return this.drawable;
        }

        public final int b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return this.lastHeight;
        }

        public final int c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.lastWidth;
        }

        public final boolean d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
            }
            if (this.drawable.getCallback() != null) {
                return true;
            }
            return false;
        }

        public final void e(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, i3);
            } else {
                this.lastHeight = i3;
            }
        }

        public final void f(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
            } else {
                this.lastWidth = i3;
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(@NotNull Drawable d16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, (Object) d16);
                return;
            }
            Intrinsics.checkNotNullParameter(d16, "d");
            Drawable.Callback callback = this.drawable.getCallback();
            if (callback != null) {
                callback.invalidateDrawable(a());
                if (a().s() && (callback instanceof View)) {
                    View view = (View) callback;
                    if (view.getLayoutParams() != null) {
                        if ((view.getLayoutParams().width == -2 || view.getLayoutParams().height == -2) && c() != d16.getIntrinsicWidth() && b() != d16.getIntrinsicHeight()) {
                            f(d16.getIntrinsicWidth());
                            e(d16.getIntrinsicHeight());
                            view.requestLayout();
                        }
                    }
                }
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(@NotNull Drawable who, @NotNull Runnable what, long time) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                iPatchRedirector.redirect((short) 10, this, who, what, Long.valueOf(time));
                return;
            }
            Intrinsics.checkNotNullParameter(who, "who");
            Intrinsics.checkNotNullParameter(what, "what");
            Drawable.Callback callback = this.drawable.getCallback();
            if (callback != null) {
                callback.scheduleDrawable(this.drawable, what, time);
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(@NotNull Drawable who, @NotNull Runnable what) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, (Object) who, (Object) what);
                return;
            }
            Intrinsics.checkNotNullParameter(who, "who");
            Intrinsics.checkNotNullParameter(what, "what");
            Drawable.Callback callback = this.drawable.getCallback();
            if (callback != null) {
                callback.unscheduleDrawable(this.drawable, what);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/AbsAsyncDrawable$b;", "", "Landroid/os/Handler;", "uiHandler", "Landroid/os/Handler;", "b", "()Landroid/os/Handler;", "subHandler", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "cachedrawable_debug"}, k = 1, mv = {1, 5, 1})
    /* renamed from: com.tencent.cachedrawable.dynamicdrawable.cachedrawable.AbsAsyncDrawable$b, reason: from kotlin metadata */
    /* loaded from: classes5.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final Handler a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return AbsAsyncDrawable.J;
            }
            return (Handler) iPatchRedirector.redirect((short) 3, (Object) this);
        }

        @NotNull
        public final Handler b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return AbsAsyncDrawable.I;
            }
            return (Handler) iPatchRedirector.redirect((short) 2, (Object) this);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/AbsAsyncDrawable$c;", "Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/m;", "", "onLoadSucceed", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/AbsAsyncDrawable;", "a", "Ljava/lang/ref/WeakReference;", "getDrawableRef", "()Ljava/lang/ref/WeakReference;", "drawableRef", "<init>", "(Ljava/lang/ref/WeakReference;)V", "cachedrawable_debug"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes5.dex */
    public static final class c implements m {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<AbsAsyncDrawable> drawableRef;

        public c(@NotNull WeakReference<AbsAsyncDrawable> drawableRef) {
            Intrinsics.checkNotNullParameter(drawableRef, "drawableRef");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) drawableRef);
            } else {
                this.drawableRef = drawableRef;
            }
        }

        @Override // com.tencent.cachedrawable.dynamicdrawable.cachedrawable.m
        public void onLoadSucceed() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            AbsAsyncDrawable absAsyncDrawable = this.drawableRef.get();
            if (absAsyncDrawable != null) {
                Drawable drawable = (Drawable) absAsyncDrawable.doTargetDrawableBuild.invoke();
                if (drawable != null) {
                    absAsyncDrawable.G(drawable);
                    absAsyncDrawable.B();
                }
                if (absAsyncDrawable.o() == null) {
                    absAsyncDrawable.G((Drawable) absAsyncDrawable.doFailedDrawableBuild.invoke());
                }
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(8547);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 38)) {
            redirector.redirect((short) 38);
            return;
        }
        INSTANCE = new Companion(null);
        I = new Handler(Looper.getMainLooper());
        J = new Handler(com.tencent.cachedrawable.dynamicdrawable.cachedrawable.manager.h.f99037a.d().getLooper());
    }

    public AbsAsyncDrawable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f98884d = new f();
        this.targetDrawableBuild = AbsAsyncDrawable$targetDrawableBuild$1.INSTANCE;
        this.doFailedDrawableBuild = new Function0<Drawable>() { // from class: com.tencent.cachedrawable.dynamicdrawable.cachedrawable.AbsAsyncDrawable$doFailedDrawableBuild$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AbsAsyncDrawable.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Drawable invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Drawable) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                try {
                    Function0<Drawable> p16 = AbsAsyncDrawable.this.p();
                    if (p16 == null) {
                        return null;
                    }
                    return p16.invoke();
                } catch (Throwable unused) {
                    return null;
                }
            }
        };
        this.doTargetDrawableBuild = new Function0<Drawable>() { // from class: com.tencent.cachedrawable.dynamicdrawable.cachedrawable.AbsAsyncDrawable$doTargetDrawableBuild$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AbsAsyncDrawable.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Drawable invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Drawable) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                try {
                    return AbsAsyncDrawable.this.w().invoke();
                } catch (Throwable unused) {
                    return null;
                }
            }
        };
        this.callbackProxy = new a(this);
        this.tmpalpha = 255;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A() {
        c cVar = new c(new WeakReference(this));
        if (x()) {
            cVar.onLoadSucceed();
        } else {
            n(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(Function0 tmp0) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(Function0 tmp0) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G(Drawable drawable) {
        if (!Intrinsics.areEqual(drawable, this.currentDrawable)) {
            this.currentDrawable = drawable;
            N();
        }
    }

    private final void N() {
        E(new Function0<Unit>() { // from class: com.tencent.cachedrawable.dynamicdrawable.cachedrawable.AbsAsyncDrawable$updateDrawableState$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AbsAsyncDrawable.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                Drawable o16 = AbsAsyncDrawable.this.o();
                if (o16 == null) {
                    return;
                }
                AbsAsyncDrawable absAsyncDrawable = AbsAsyncDrawable.this;
                absAsyncDrawable.m(o16);
                absAsyncDrawable.invalidateSelf();
            }
        });
    }

    public static /* synthetic */ void z(AbsAsyncDrawable absAsyncDrawable, boolean z16, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                z16 = true;
            }
            absAsyncDrawable.y(z16);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: load");
    }

    public void B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        }
    }

    public void C(@NotNull final Function0<Unit> block) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) block);
        } else {
            Intrinsics.checkNotNullParameter(block, "block");
            J.post(new Runnable() { // from class: com.tencent.cachedrawable.dynamicdrawable.cachedrawable.a
                @Override // java.lang.Runnable
                public final void run() {
                    AbsAsyncDrawable.D(Function0.this);
                }
            });
        }
    }

    public void E(@NotNull final Function0<Unit> block) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) block);
            return;
        }
        Intrinsics.checkNotNullParameter(block, "block");
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            block.invoke();
        } else {
            I.post(new Runnable() { // from class: com.tencent.cachedrawable.dynamicdrawable.cachedrawable.b
                @Override // java.lang.Runnable
                public final void run() {
                    AbsAsyncDrawable.F(Function0.this);
                }
            });
        }
    }

    public final void H(@Nullable Function0<? extends Drawable> function0) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) function0);
        } else {
            this.failedDrawableBuild = function0;
        }
    }

    public void I(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
        } else {
            this.f98884d.e(z16);
        }
    }

    public void J(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            this.f98884d.f(i3);
        }
    }

    public void K(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        } else {
            this.f98884d.g(i3);
        }
    }

    public void L(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Float.valueOf(f16));
        } else {
            this.f98884d.h(f16);
        }
    }

    public final void M(@NotNull Function0<? extends Drawable> function0) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) function0);
        } else {
            Intrinsics.checkNotNullParameter(function0, "<set-?>");
            this.targetDrawableBuild = function0;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NotNull Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) canvas);
            return;
        }
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Drawable drawable = this.currentDrawable;
        if (drawable != null) {
            drawable.setBounds(getBounds());
            drawable.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public Drawable.ConstantState getConstantState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (Drawable.ConstantState) iPatchRedirector.redirect((short) 30, (Object) this);
        }
        Drawable drawable = this.currentDrawable;
        if (drawable == null) {
            return null;
        }
        return drawable.getConstantState();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Integer) iPatchRedirector.redirect((short) 25, (Object) this)).intValue();
        }
        if (v() == 1.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return q();
        }
        return (int) (q() * v());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Integer) iPatchRedirector.redirect((short) 27, (Object) this)).intValue();
        }
        if (v() == 1.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return r();
        }
        return (int) (r() * v());
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Integer) iPatchRedirector.redirect((short) 29, (Object) this)).intValue();
        }
        Drawable drawable = this.currentDrawable;
        if (drawable == null) {
            return -3;
        }
        return drawable.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(@NotNull Rect padding) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Boolean) iPatchRedirector.redirect((short) 31, (Object) this, (Object) padding)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(padding, "padding");
        Drawable drawable = this.currentDrawable;
        if (drawable == null) {
            return super.getPadding(padding);
        }
        return drawable.getPadding(padding);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void m(@NotNull Drawable child) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, (Object) child);
            return;
        }
        Intrinsics.checkNotNullParameter(child, "child");
        child.setCallback(this.callbackProxy);
        child.setAlpha(this.tmpalpha);
        child.setBounds(getBounds());
        child.setVisible(isVisible(), false);
        ColorFilter colorFilter = this.tmpColorFilter;
        if (colorFilter != null) {
            child.setColorFilter(colorFilter);
        }
        PorterDuff.Mode mode = this.tmpColorFilterMode;
        if (mode != null) {
            child.setColorFilter(this.tmpColorFilterInt, mode);
        }
    }

    public abstract void n(@NotNull m callback);

    @Nullable
    public final Drawable o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (Drawable) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return this.currentDrawable;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(@Nullable Rect bounds) {
        Drawable drawable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) bounds);
            return;
        }
        if (bounds != null && (drawable = this.currentDrawable) != null) {
            drawable.setBounds(bounds);
        }
        super.onBoundsChange(bounds);
    }

    @Nullable
    public final Function0<Drawable> p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (Function0) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.failedDrawableBuild;
    }

    public final int q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Integer) iPatchRedirector.redirect((short) 26, (Object) this)).intValue();
        }
        if (t() != -1) {
            return t();
        }
        Drawable drawable = this.currentDrawable;
        if (drawable == null) {
            return super.getIntrinsicHeight();
        }
        return drawable.getIntrinsicHeight();
    }

    public final int r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Integer) iPatchRedirector.redirect((short) 28, (Object) this)).intValue();
        }
        if (u() != -1) {
            return u();
        }
        Drawable drawable = this.currentDrawable;
        if (drawable == null) {
            return super.getIntrinsicWidth();
        }
        return drawable.getIntrinsicWidth();
    }

    public boolean s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.f98884d.a();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, alpha);
            return;
        }
        Drawable drawable = this.currentDrawable;
        if (drawable != null) {
            drawable.setAlpha(alpha);
        }
        this.tmpalpha = alpha;
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int left, int top, int right, int bottom) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, Integer.valueOf(left), Integer.valueOf(top), Integer.valueOf(right), Integer.valueOf(bottom));
            return;
        }
        Drawable drawable = this.currentDrawable;
        if (drawable != null) {
            drawable.setBounds(left, top, right, bottom);
        }
        super.setBounds(left, top, right, bottom);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, (Object) colorFilter);
            return;
        }
        Drawable drawable = this.currentDrawable;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        }
        this.tmpColorFilter = colorFilter;
        this.tmpColorFilterMode = null;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean visible, boolean restart) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return ((Boolean) iPatchRedirector.redirect((short) 34, this, Boolean.valueOf(visible), Boolean.valueOf(restart))).booleanValue();
        }
        Drawable drawable = this.currentDrawable;
        if (drawable != null) {
            drawable.setVisible(visible, restart);
        }
        return super.setVisible(visible, restart);
    }

    public int t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.f98884d.b();
    }

    public int u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.f98884d.c();
    }

    public float v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Float) iPatchRedirector.redirect((short) 8, (Object) this)).floatValue();
        }
        return this.f98884d.d();
    }

    @NotNull
    public final Function0<Drawable> w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (Function0) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this.targetDrawableBuild;
    }

    public abstract boolean x();

    @JvmOverloads
    public final void y(boolean isAsync) {
        Drawable invoke;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, isAsync);
            return;
        }
        if (isAsync) {
            C(new Function0<Unit>() { // from class: com.tencent.cachedrawable.dynamicdrawable.cachedrawable.AbsAsyncDrawable$load$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AbsAsyncDrawable.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Drawable drawable;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (!AbsAsyncDrawable.this.x() && (drawable = (Drawable) AbsAsyncDrawable.this.doFailedDrawableBuild.invoke()) != null) {
                        AbsAsyncDrawable.this.G(drawable);
                    }
                    AbsAsyncDrawable.this.A();
                }
            });
            return;
        }
        if (!x() && (invoke = this.doFailedDrawableBuild.invoke()) != null) {
            G(invoke);
        }
        A();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(int color, @NotNull PorterDuff.Mode mode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, color, (Object) mode);
            return;
        }
        Intrinsics.checkNotNullParameter(mode, "mode");
        Drawable drawable = this.currentDrawable;
        if (drawable != null) {
            drawable.setColorFilter(color, mode);
        }
        this.tmpColorFilterInt = color;
        this.tmpColorFilterMode = mode;
        this.tmpColorFilter = null;
    }
}
