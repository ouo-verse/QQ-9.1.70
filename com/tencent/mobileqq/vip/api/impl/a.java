package com.tencent.mobileqq.vip.api.impl;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ams.mosaic.jsengine.animation.custom.CustomAnimation;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.vas.ui.AbsDynamicDrawableState;
import com.tencent.mobileqq.vip.api.impl.a;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 )2\u00020\u00012\u00020\u0002:\u0002*+B\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u001a\u00a2\u0006\u0004\b$\u0010%B\u0011\b\u0016\u0012\u0006\u0010'\u001a\u00020&\u00a2\u0006\u0004\b$\u0010(J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0012\u0010\u0010\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u000bH\u0016J\b\u0010\u0012\u001a\u00020\u000bH\u0016J\b\u0010\u0013\u001a\u00020\u000bH\u0016J\b\u0010\u0014\u001a\u00020\u0005H\u0016J\u0018\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0016R\u0017\u0010\u001f\u001a\u00020\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/vip/api/impl/a;", "Landroid/graphics/drawable/Drawable;", "Lcom/tencent/mobileqq/vas/ui/AbsDynamicDrawableState$Callback;", "Landroid/graphics/Canvas;", PM.CANVAS, "", "draw", "invalidateSelf", "", "filter", "setFilterBitmap", "", com.tencent.luggage.wxa.c8.c.f123400v, "setAlpha", "Landroid/graphics/ColorFilter;", CustomAnimation.KeyPath.COLOR_FILTER, "setColorFilter", "getIntrinsicWidth", "getIntrinsicHeight", "getOpacity", "onInvalidateSelf", "Ljava/lang/Runnable;", "what", "", RemoteMessageConst.Notification.WHEN, "onScheduleSelf", "Lcom/tencent/mobileqq/vip/api/impl/a$b;", "d", "Lcom/tencent/mobileqq/vip/api/impl/a$b;", "getState", "()Lcom/tencent/mobileqq/vip/api/impl/a$b;", "state", "Landroid/graphics/Paint;", "e", "Landroid/graphics/Paint;", "mPaint", "<init>", "(Lcom/tencent/mobileqq/vip/api/impl/a$b;)V", "Ljava/io/File;", "file", "(Ljava/io/File;)V", "f", "a", "b", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class a extends Drawable implements AbsDynamicDrawableState.Callback {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private static final PngRenderingExecutor f312852h;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b state;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Paint mPaint;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/vip/api/impl/a$a;", "", "", "DEFAULT_DELAY_MS", "J", "MIN_DELAY_MS", "Lcom/tencent/mobileqq/vip/api/impl/PngRenderingExecutor;", "sExecutor", "Lcom/tencent/mobileqq/vip/api/impl/PngRenderingExecutor;", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.vip.api.impl.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
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
    @Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010G\u001a\u00020F\u00a2\u0006\u0004\bH\u0010IJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0006\u0010\n\u001a\u00020\tJ \u0010\u0011\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fR$\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00028\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\"\u0010\u001e\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010!\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR\u0016\u0010$\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010#R\u0014\u0010'\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010+\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010-\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010*R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0018\u00103\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00100R\u0018\u00105\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00100R\u0014\u00109\u001a\u0002068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010;\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010\u0019R&\u0010A\u001a\u0012\u0012\u0004\u0012\u00020=0<j\b\u0012\u0004\u0012\u00020=`>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0014\u0010E\u001a\u00020B8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bC\u0010D\u00a8\u0006J"}, d2 = {"Lcom/tencent/mobileqq/vip/api/impl/a$b;", "Lcom/tencent/mobileqq/vas/ui/AbsDynamicDrawableState;", "", "isReusable", "Lcom/tencent/mobileqq/vip/api/impl/a;", "c", "Landroid/content/res/Resources;", "res", "d", "", "scheduleNextRender", "Landroid/graphics/Canvas;", PM.CANVAS, "Landroid/graphics/Rect;", "bounds", "Landroid/graphics/Paint;", "mPaint", "draw", "<set-?>", "a", "Z", AppConstants.Key.COLUMN_IS_VALID, "()Z", "", "b", "I", "getWidth", "()I", "setWidth", "(I)V", "width", "getHeight", "setHeight", "height", "", "J", "mNextFrameRenderTime", "e", "Landroid/graphics/Rect;", "mSrcRect", "", "f", "Ljava/lang/Object;", "mLock", "g", "mBitmapLock", "Landroid/graphics/Bitmap;", tl.h.F, "Landroid/graphics/Bitmap;", "mCurrentBitmap", "i", "mLastBitmap", "j", "mUnusedBitmap", "Ljava/util/concurrent/atomic/AtomicBoolean;", "k", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mWaitDraw", "l", "mCurrentIndex", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/ArrayList;", "files", "Ljava/lang/Runnable;", DomainData.DOMAIN_NAME, "Ljava/lang/Runnable;", "mDecodeTask", "Ljava/io/File;", "file", "<init>", "(Ljava/io/File;)V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class b extends AbsDynamicDrawableState {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private boolean isValid;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private int width;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private int height;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private long mNextFrameRenderTime;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Rect mSrcRect;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Object mLock;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Object mBitmapLock;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Bitmap mCurrentBitmap;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Bitmap mLastBitmap;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Bitmap mUnusedBitmap;

        /* renamed from: k, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final AtomicBoolean mWaitDraw;

        /* renamed from: l, reason: collision with root package name and from kotlin metadata */
        private int mCurrentIndex;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private ArrayList<String> files;

        /* renamed from: n, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Runnable mDecodeTask;

        public b(@NotNull File file) {
            Intrinsics.checkNotNullParameter(file, "file");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) file);
                return;
            }
            this.mNextFrameRenderTime = Long.MIN_VALUE;
            this.mSrcRect = new Rect(0, 0, 0, 0);
            this.mLock = new Object();
            this.mBitmapLock = new Object();
            this.mWaitDraw = new AtomicBoolean(true);
            this.files = new ArrayList<>();
            this.mDecodeTask = new Runnable() { // from class: com.tencent.mobileqq.vip.api.impl.b
                @Override // java.lang.Runnable
                public final void run() {
                    a.b.b(a.b.this);
                }
            };
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    this.files.add(file2.getAbsolutePath());
                }
            }
            CollectionsKt__MutableCollectionsJVMKt.sort(this.files);
            this.mDecodeTask.run();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(b this$0) {
            long j3;
            int i3;
            int i16;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            synchronized (this$0.mLock) {
                long uptimeMillis = SystemClock.uptimeMillis();
                boolean z16 = true;
                try {
                    Bitmap decodeFile = BitmapFactory.decodeFile(this$0.files.get(this$0.mCurrentIndex));
                    this$0.mCurrentBitmap = decodeFile;
                    if (decodeFile != null) {
                        i3 = decodeFile.getWidth();
                    } else {
                        i3 = 0;
                    }
                    this$0.width = i3;
                    Bitmap bitmap = this$0.mCurrentBitmap;
                    if (bitmap != null) {
                        i16 = bitmap.getHeight();
                    } else {
                        i16 = 0;
                    }
                    this$0.height = i16;
                    Rect rect = this$0.mSrcRect;
                    rect.right = this$0.width;
                    rect.bottom = i16;
                    this$0.mCurrentIndex++;
                    this$0.mWaitDraw.set(true);
                    this$0.mUnusedBitmap = this$0.mLastBitmap;
                    this$0.mLastBitmap = this$0.mCurrentBitmap;
                    synchronized (this$0.mBitmapLock) {
                        Bitmap bitmap2 = this$0.mUnusedBitmap;
                        if (bitmap2 != null) {
                            bitmap2.recycle();
                            Unit unit = Unit.INSTANCE;
                        }
                    }
                    z16 = false;
                } catch (Throwable th5) {
                    PngRenderingExecutor.c(a.f312852h, "exception during decode " + th5.getMessage(), null, 2, null);
                }
                a.f312852h.d("decode: invalidateTimeMs=100");
                if (z16) {
                    j3 = Long.MIN_VALUE;
                } else {
                    j3 = uptimeMillis + 100;
                }
                this$0.mNextFrameRenderTime = j3;
                if (this$0.mCurrentIndex >= this$0.files.size()) {
                    this$0.mCurrentIndex = 0;
                }
                this$0.invalidateSelf();
                Unit unit2 = Unit.INSTANCE;
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NotNull
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public a newDrawable() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (a) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            return new a(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NotNull
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public a newDrawable(@Nullable Resources res) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (a) iPatchRedirector.redirect((short) 9, (Object) this, (Object) res);
            }
            return new a(this);
        }

        public final void draw(@NotNull Canvas canvas, @NotNull Rect bounds, @Nullable Paint mPaint) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                iPatchRedirector.redirect((short) 11, this, canvas, bounds, mPaint);
                return;
            }
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            Intrinsics.checkNotNullParameter(bounds, "bounds");
            if (this.mWaitDraw.compareAndSet(true, false)) {
                scheduleNextRender();
            }
            synchronized (this.mBitmapLock) {
                Bitmap bitmap = this.mCurrentBitmap;
                if (bitmap != null) {
                    if (!bitmap.isRecycled()) {
                        canvas.drawBitmap(bitmap, this.mSrcRect, bounds, mPaint);
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
        }

        public final int getHeight() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
            }
            return this.height;
        }

        public final int getWidth() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.width;
        }

        @Override // com.tencent.mobileqq.vas.ui.AbsDynamicDrawableState
        public boolean isReusable() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
            }
            return this.isValid;
        }

        public final void scheduleNextRender() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                iPatchRedirector.redirect((short) 10, (Object) this);
                return;
            }
            if (!this.mWaitDraw.get() && this.mNextFrameRenderTime != Long.MIN_VALUE) {
                a.f312852h.d("schedule: next");
                long max = Math.max(0L, this.mNextFrameRenderTime - SystemClock.uptimeMillis());
                this.mNextFrameRenderTime = Long.MIN_VALUE;
                a.f312852h.f(this.mDecodeTask);
                a.f312852h.e(this.mDecodeTask, max);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49666);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
        } else {
            INSTANCE = new Companion(null);
            f312852h = new PngRenderingExecutor();
        }
    }

    public a(@NotNull b state) {
        Intrinsics.checkNotNullParameter(state, "state");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) state);
            return;
        }
        this.state = state;
        this.mPaint = new Paint(2);
        state.addCallBack(this);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NotNull Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) canvas);
            return;
        }
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        b bVar = this.state;
        Rect bounds = getBounds();
        Intrinsics.checkNotNullExpressionValue(bounds, "bounds");
        bVar.draw(canvas, bounds, this.mPaint);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return this.state.getHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.state.getWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            super.invalidateSelf();
            this.state.scheduleNextRender();
        }
    }

    @Override // com.tencent.mobileqq.vas.ui.AbsDynamicDrawableState.Callback
    public void onInvalidateSelf() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            f312852h.a(this);
        }
    }

    @Override // com.tencent.mobileqq.vas.ui.AbsDynamicDrawableState.Callback
    public void onScheduleSelf(@NotNull Runnable what, long when) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, what, Long.valueOf(when));
            return;
        }
        Intrinsics.checkNotNullParameter(what, "what");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, alpha);
        } else {
            this.mPaint.setAlpha(alpha);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) colorFilter);
        } else {
            this.mPaint.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean filter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, filter);
        } else {
            this.mPaint.setFilterBitmap(filter);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(@NotNull File file) {
        this(new b(file));
        Intrinsics.checkNotNullParameter(file, "file");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, (Object) this, (Object) file);
    }
}
