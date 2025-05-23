package com.tencent.mobileqq.vip.api.impl;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.view.animation.PathInterpolator;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.qq.wx.voice.util.ErrorCode;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.image.AbsAsyncDrawable;
import com.tencent.mobileqq.vas.image.ILoaderSucessCallback;
import com.tencent.mobileqq.vas.ui.IVipFrameDrawable;
import com.tencent.mobileqq.vip.api.impl.VipFrameIconDrawable;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0015\u0018\u0000 \b2\u00020\u00012\u00020\u0002:\u0002GHB\u001f\u0012\u0016\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0018j\b\u0012\u0004\u0012\u00020\u0003`\u0019\u00a2\u0006\u0004\bE\u0010FJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0006\u0010\b\u001a\u00020\u0007J\u001a\u0010\u000b\u001a\u00020\u00072\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\tJ\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\fH\u0016J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0005H\u0016R'\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0018j\b\u0012\u0004\u0012\u00020\u0003`\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR0\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R(\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00050&8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u00100\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0017\u00109\u001a\u0002048\u0006\u00a2\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\"\u0010>\u001a\u0002048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b:\u00106\u001a\u0004\b;\u00108\"\u0004\b<\u0010=R\"\u0010D\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010C\u00a8\u0006I"}, d2 = {"Lcom/tencent/mobileqq/vip/api/impl/VipFrameIconDrawable;", "Lcom/tencent/mobileqq/vas/image/AbsAsyncDrawable;", "Lcom/tencent/mobileqq/vas/ui/IVipFrameDrawable;", "", "url", "Landroid/graphics/drawable/Drawable;", BdhLogUtil.LogTag.Tag_Conn, "", "D", "Lkotlin/Function1;", "block", "setLoadedListener", "", "getIntrinsicHeight", "getIntrinsicWidth", "Landroid/graphics/Canvas;", PM.CANVAS, "draw", "", "isLoadSucess", "Lcom/tencent/mobileqq/vas/image/ILoaderSucessCallback;", "callback", "doLoadTask", "getDrawable", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "d", "Ljava/util/ArrayList;", "B", "()Ljava/util/ArrayList;", "urlStrs", "e", "Lkotlin/jvm/functions/Function1;", "getLoadCallback", "()Lkotlin/jvm/functions/Function1;", "setLoadCallback", "(Lkotlin/jvm/functions/Function1;)V", "loadCallback", "Ljava/util/concurrent/CopyOnWriteArrayList;", "f", "Ljava/util/concurrent/CopyOnWriteArrayList;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "()Ljava/util/concurrent/CopyOnWriteArrayList;", "setAllDrawable", "(Ljava/util/concurrent/CopyOnWriteArrayList;)V", "allDrawable", tl.h.F, "Z", "isLoaded", "()Z", "setLoaded", "(Z)V", "", "i", "J", "getStartAnimTimeMillis", "()J", "startAnimTimeMillis", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "getLastNum", "setLastNum", "(J)V", "lastNum", "I", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()I", "setLastIndex", "(I)V", "lastIndex", "<init>", "(Ljava/util/ArrayList;)V", "a", "b", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class VipFrameIconDrawable extends AbsAsyncDrawable implements IVipFrameDrawable {
    static IPatchRedirector $redirector_;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private static final float E;

    /* renamed from: C, reason: from kotlin metadata */
    private int lastIndex;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<String> urlStrs;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<? super IVipFrameDrawable, Unit> loadCallback;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private CopyOnWriteArrayList<Drawable> allDrawable;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isLoaded;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final long startAnimTimeMillis;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private long lastNum;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/vip/api/impl/VipFrameIconDrawable$a;", "", "", "ANIM_TIME_MILLIS", "J", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.vip.api.impl.VipFrameIconDrawable$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0015\u0018\u0000 \u001f2\u00020\u0001:\u0001\nB\u0017\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0015\u001a\u00020\u0005\u00a2\u0006\u0004\b\u001d\u0010\u001eJ(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u000e\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bR\u0017\u0010\u0012\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0015\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011R\"\u0010\u001c\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/vip/api/impl/VipFrameIconDrawable$b;", "Lcom/tencent/mobileqq/vas/image/d;", "Landroid/graphics/Canvas;", PM.CANVAS, "", "Landroid/graphics/drawable/Drawable;", "drawableStack", "Landroid/graphics/Rect;", "bounds", "", "a", "", "p", "c", "d", "Landroid/graphics/drawable/Drawable;", "getD1", "()Landroid/graphics/drawable/Drawable;", "d1", "e", "getD2", "d2", "f", UserInfo.SEX_FEMALE, "getAnimProgress", "()F", "setAnimProgress", "(F)V", "animProgress", "<init>", "(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V", "g", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class b extends com.tencent.mobileqq.vas.image.d {
        static IPatchRedirector $redirector_;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE;

        /* renamed from: h, reason: collision with root package name */
        @NotNull
        private static final PathInterpolator f312845h;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Drawable d1;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Drawable d2;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private float animProgress;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/vip/api/impl/VipFrameIconDrawable$b$a;", "", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.vip.api.impl.VipFrameIconDrawable$b$a, reason: from kotlin metadata */
        /* loaded from: classes20.dex */
        public static final class Companion {
            static IPatchRedirector $redirector_;

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                    return;
                }
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
            }

            Companion() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                    return;
                }
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50187);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 9)) {
                redirector.redirect((short) 9);
            } else {
                INSTANCE = new Companion(null);
                f312845h = new PathInterpolator(0.0f, 0.65f, 0.35f, 1.0f);
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b(@NotNull Drawable d16, @NotNull Drawable d26) {
            super(r0);
            List listOf;
            Intrinsics.checkNotNullParameter(d16, "d1");
            Intrinsics.checkNotNullParameter(d26, "d2");
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Drawable[]{d16, d26});
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) d16, (Object) d26);
            } else {
                this.d1 = d16;
                this.d2 = d26;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(b this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.invalidateSelf();
        }

        @Override // com.tencent.mobileqq.vas.image.d
        public void a(@NotNull Canvas canvas, @NotNull List<? extends Drawable> drawableStack, @Nullable Rect bounds) {
            Rect rect;
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, canvas, drawableStack, bounds);
                return;
            }
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            Intrinsics.checkNotNullParameter(drawableStack, "drawableStack");
            if (bounds == null) {
                rect = new Rect(0, 0, canvas.getWidth(), canvas.getHeight());
            } else {
                rect = bounds;
            }
            if (this.animProgress == 1.0f) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                Drawable drawable = drawableStack.get(1);
                drawable.setAlpha(255);
                drawable.setBounds(rect);
                drawable.draw(canvas);
                return;
            }
            Pair pair = TuplesKt.to(Integer.valueOf(rect.centerX()), Integer.valueOf(rect.centerY()));
            int intValue = ((Number) pair.component1()).intValue();
            int intValue2 = ((Number) pair.component2()).intValue();
            Pair pair2 = TuplesKt.to(Integer.valueOf(rect.width()), Integer.valueOf(rect.height()));
            int intValue3 = ((Number) pair2.component1()).intValue();
            int intValue4 = ((Number) pair2.component2()).intValue();
            Drawable drawable2 = drawableStack.get(1);
            int i3 = (intValue * 5) / 18;
            PathInterpolator pathInterpolator = f312845h;
            float interpolation = 1.0f - pathInterpolator.getInterpolation(this.animProgress);
            float f16 = intValue;
            int i16 = (int) ((((intValue + i3) - intValue) * interpolation) + f16);
            float f17 = intValue2;
            float f18 = ((intValue / 30) + intValue2) - intValue2;
            int i17 = (int) ((f18 * interpolation) + f17);
            float f19 = intValue3;
            float f26 = ((intValue3 * 8) / 10) - intValue3;
            int i18 = (int) (f19 + (f26 * interpolation));
            float f27 = intValue4;
            float f28 = ((intValue4 * 8) / 10) - intValue4;
            int i19 = i18 / 2;
            int i26 = ((int) (f27 + (f28 * interpolation))) / 2;
            rect.set(i16 - i19, i17 - i26, i16 + i19, i17 + i26);
            float f29 = 255;
            float f36 = 1;
            drawable2.setAlpha((int) ((f36 - interpolation) * f29));
            drawable2.setBounds(rect);
            drawable2.draw(canvas);
            Drawable drawable3 = drawableStack.get(0);
            float interpolation2 = pathInterpolator.getInterpolation(this.animProgress);
            int i27 = (int) (f16 + (((intValue - i3) - intValue) * interpolation2));
            int i28 = (int) (f17 + (f18 * interpolation2));
            int i29 = ((int) (f19 + (f26 * interpolation2))) / 2;
            int i36 = ((int) (f27 + (f28 * interpolation2))) / 2;
            rect.set(i27 - i29, i28 - i36, i27 + i29, i28 + i36);
            drawable3.setAlpha((int) (f29 * (f36 - interpolation2)));
            drawable3.setBounds(rect);
            drawable3.draw(canvas);
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x0027, code lost:
        
            if (r6 > 1.0f) goto L10;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void c(float p16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z16 = true;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, this, Float.valueOf(p16));
                return;
            }
            float f16 = 0.0f;
            if (p16 >= 0.0f) {
                f16 = 1.0f;
            }
            p16 = f16;
            if (this.animProgress != p16) {
                z16 = false;
            }
            if (!z16) {
                this.animProgress = p16;
                ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.vip.api.impl.v
                    @Override // java.lang.Runnable
                    public final void run() {
                        VipFrameIconDrawable.b.d(VipFrameIconDrawable.b.this);
                    }
                }, 16L);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(ErrorCode.SRERR_DECOMPRESS_AMR);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 26)) {
            redirector.redirect((short) 26);
        } else {
            INSTANCE = new Companion(null);
            E = ViewUtils.getScreenWidth() / 720.0f;
        }
    }

    public VipFrameIconDrawable(@NotNull ArrayList<String> urlStrs) {
        Intrinsics.checkNotNullParameter(urlStrs, "urlStrs");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) urlStrs);
            return;
        }
        this.urlStrs = urlStrs;
        this.allDrawable = new CopyOnWriteArrayList<>();
        this.startAnimTimeMillis = SystemClock.uptimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Drawable C(String url) {
        return new a(new File(url));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(VipFrameIconDrawable this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.invalidateSelf();
    }

    public final int A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return this.lastIndex;
    }

    @NotNull
    public final ArrayList<String> B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ArrayList) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.urlStrs;
    }

    public final void D() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        Function1<? super IVipFrameDrawable, Unit> function1 = this.loadCallback;
        if (function1 != null) {
            function1.invoke(this);
        }
        postSubTask(new Function0<Unit>() { // from class: com.tencent.mobileqq.vip.api.impl.VipFrameIconDrawable$init$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) VipFrameIconDrawable.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    AbsAsyncDrawable.load$default(VipFrameIconDrawable.this, false, 1, null);
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.vas.image.AbsAsyncDrawable
    public void doLoadTask(@NotNull ILoaderSucessCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(callback, "callback");
        final ArrayList arrayList = new ArrayList();
        int size = this.urlStrs.size();
        final z[] zVarArr = new z[size];
        for (int i3 = 0; i3 < size; i3++) {
            zVarArr[i3] = new z(null, 1, null);
        }
        final VipFrameIconDrawable$doLoadTask$download$1 vipFrameIconDrawable$doLoadTask$download$1 = new VipFrameIconDrawable$doLoadTask$download$1(zVarArr, this, arrayList);
        vipFrameIconDrawable$doLoadTask$download$1.invoke((VipFrameIconDrawable$doLoadTask$download$1) 0);
        this.isLoaded = true;
        Object obj = arrayList.get(0);
        Intrinsics.checkNotNullExpressionValue(obj, "localFiles[0]");
        this.allDrawable.add(C((String) obj));
        setTargetDrawableBuild(new Function0<Drawable>() { // from class: com.tencent.mobileqq.vip.api.impl.VipFrameIconDrawable$doLoadTask$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) VipFrameIconDrawable.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Drawable invoke() {
                Object first;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Drawable) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                first = CollectionsKt___CollectionsKt.first((List<? extends Object>) VipFrameIconDrawable.this.z());
                return (Drawable) first;
            }
        });
        callback.onLoadSucceed();
        if (size > 1) {
            postSubTask(new Function0<Unit>(zVarArr, vipFrameIconDrawable$doLoadTask$download$1, this, arrayList) { // from class: com.tencent.mobileqq.vip.api.impl.VipFrameIconDrawable$doLoadTask$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ Function1<Integer, Unit> $download;
                final /* synthetic */ z[] $loaders;
                final /* synthetic */ ArrayList<String> $localFiles;
                final /* synthetic */ VipFrameIconDrawable this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$loaders = zVarArr;
                    this.$download = vipFrameIconDrawable$doLoadTask$download$1;
                    this.this$0 = this;
                    this.$localFiles = arrayList;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, zVarArr, vipFrameIconDrawable$doLoadTask$download$1, this, arrayList);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Drawable C;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    z[] zVarArr2 = this.$loaders;
                    Function1<Integer, Unit> function1 = this.$download;
                    VipFrameIconDrawable vipFrameIconDrawable = this.this$0;
                    ArrayList<String> arrayList2 = this.$localFiles;
                    int length = zVarArr2.length;
                    int i16 = 0;
                    int i17 = 0;
                    while (i16 < length) {
                        z zVar = zVarArr2[i16];
                        int i18 = i17 + 1;
                        if (i17 != 0) {
                            function1.invoke(Integer.valueOf(i17));
                            String str = arrayList2.get(i17);
                            Intrinsics.checkNotNullExpressionValue(str, "localFiles[index]");
                            C = vipFrameIconDrawable.C(str);
                            vipFrameIconDrawable.z().add(C);
                        }
                        i16++;
                        i17 = i18;
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.vas.image.AbsAsyncDrawable, android.graphics.drawable.Drawable
    public void draw(@NotNull Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) canvas);
            return;
        }
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Drawable currentDrawable = getCurrentDrawable();
        if (currentDrawable != null) {
            currentDrawable.setAlpha(255);
        }
        super.draw(canvas);
        if (this.allDrawable.size() < 2) {
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis() - this.startAnimTimeMillis;
        long j3 = uptimeMillis / 5400;
        long j16 = this.lastNum;
        if (j16 != j3) {
            Ref.IntRef intRef = new Ref.IntRef();
            int i3 = this.lastIndex + 1;
            intRef.element = i3;
            if (i3 >= this.allDrawable.size()) {
                intRef.element = 0;
            }
            setTargetDrawableBuild(new VipFrameIconDrawable$draw$1(5400L, this, intRef));
            AbsAsyncDrawable.load$default(this, false, 1, null);
            this.lastNum = j3;
            this.lastIndex = intRef.element;
        } else if (j16 == 0) {
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.vip.api.impl.u
                @Override // java.lang.Runnable
                public final void run() {
                    VipFrameIconDrawable.y(VipFrameIconDrawable.this);
                }
            }, 5400L);
        }
        if (getCurrentDrawable() instanceof b) {
            Drawable currentDrawable2 = getCurrentDrawable();
            Intrinsics.checkNotNull(currentDrawable2, "null cannot be cast to non-null type com.tencent.mobileqq.vip.api.impl.VipFrameIconDrawable.TwoVipIconDrawable");
            b bVar = (b) currentDrawable2;
            float f16 = ((float) (uptimeMillis % 5400)) / 400.0f;
            bVar.c(f16);
            if (f16 < 1.0f) {
                bVar.c(f16);
            } else {
                bVar.c(1.0f);
            }
        }
    }

    @Override // com.tencent.mobileqq.vas.ui.IVipFrameDrawable
    @NotNull
    public Drawable getDrawable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (Drawable) iPatchRedirector.redirect((short) 25, (Object) this);
        }
        return this;
    }

    @Override // com.tencent.mobileqq.vas.image.AbsAsyncDrawable, android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this)).intValue();
        }
        return 44;
    }

    @Override // com.tencent.mobileqq.vas.image.AbsAsyncDrawable, android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this)).intValue();
        }
        return 132;
    }

    @Override // com.tencent.mobileqq.vas.image.AbsAsyncDrawable
    public boolean isLoadSucess() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this)).booleanValue();
        }
        return this.isLoaded;
    }

    public final void setLoadedListener(@NotNull Function1<? super IVipFrameDrawable, Unit> block) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) block);
        } else {
            Intrinsics.checkNotNullParameter(block, "block");
            this.loadCallback = block;
        }
    }

    @NotNull
    public final CopyOnWriteArrayList<Drawable> z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (CopyOnWriteArrayList) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.allDrawable;
    }
}
