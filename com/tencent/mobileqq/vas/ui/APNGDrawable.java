package com.tencent.mobileqq.vas.ui;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.tencent.image.ApngDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.mobileqq.vas.image.AbsAsyncDrawable;
import com.tencent.mobileqq.vas.image.ILoaderSucessCallback;
import java.io.File;
import java.net.URL;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 -2\u00020\u00012\u00020\u0002:\u0001-B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0006B\u001f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tB%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u000bJ\u0006\u0010\u0016\u001a\u00020\u0017J\u0010\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cJ\u0014\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010!\u001a\u00020\u0017H\u0016J\b\u0010\"\u001a\u00020\u0017H\u0016J\u0006\u0010#\u001a\u00020\u0011J\u0006\u0010$\u001a\u00020\u0011J\u0006\u0010%\u001a\u00020\u0011J\u001c\u0010&\u001a\u00020\u00112\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00110\u0010H\u0016J\u000e\u0010(\u001a\u00020\u00112\u0006\u0010)\u001a\u00020*J\b\u0010+\u001a\u00020\u0011H\u0016J\b\u0010,\u001a\u00020\u0011H\u0016R\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000eR(\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/vas/ui/APNGDrawable;", "Lcom/tencent/mobileqq/vas/image/AbsAsyncDrawable;", "Lcom/tencent/mobileqq/vas/ui/IDynamicDrawable;", "from", "", "urlStr", "(Ljava/lang/String;Ljava/lang/String;)V", "options", "Lcom/tencent/mobileqq/vas/apng/api/ApngOptions;", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/vas/apng/api/ApngOptions;)V", "filePath", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/vas/apng/api/ApngOptions;Ljava/lang/String;)V", "isLoaded", "Ljava/util/concurrent/atomic/AtomicBoolean;", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "loadCallback", "Lkotlin/Function1;", "", "getLoadCallback", "()Lkotlin/jvm/functions/Function1;", "setLoadCallback", "(Lkotlin/jvm/functions/Function1;)V", "checkURLDrawable", "", "doLoadTask", "callback", "Lcom/tencent/mobileqq/vas/image/ILoaderSucessCallback;", "getFileInLocal", "Ljava/io/File;", "getNinePathBitmap", "Landroid/graphics/Bitmap;", "d", "Landroid/graphics/drawable/Drawable;", "isLoadSucess", "isRunning", "pauseApng", "resetApng", "resumeApng", "setLoadedListener", "block", "setOnPlayRepeatListener", "listener", "Lcom/tencent/image/ApngDrawable$OnPlayRepeatListener;", "start", "stop", "Companion", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class APNGDrawable extends AbsAsyncDrawable implements IDynamicDrawable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static boolean isUrlDrawableInited;

    @NotNull
    private final AtomicBoolean isLoaded;

    @Nullable
    private Function1<? super APNGDrawable, Unit> loadCallback;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/vas/ui/APNGDrawable$Companion;", "", "()V", "isUrlDrawableInited", "", "()Z", "setUrlDrawableInited", "(Z)V", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean isUrlDrawableInited() {
            return APNGDrawable.isUrlDrawableInited;
        }

        public final void setUrlDrawableInited(boolean z16) {
            APNGDrawable.isUrlDrawableInited = z16;
        }

        Companion() {
        }
    }

    public APNGDrawable(@NotNull String from, @NotNull final String urlStr, @NotNull final ApngOptions options, @NotNull final String filePath) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(urlStr, "urlStr");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        this.isLoaded = new AtomicBoolean(false);
        if (options.getRequestWidth() > 0) {
            setRequestLodingWidth(options.getRequestWidth());
        }
        if (options.getRequestHeight() > 0) {
            setRequestLodingHeight(options.getRequestHeight());
        }
        setFailedDrawableBuild(new Function0<Drawable>() { // from class: com.tencent.mobileqq.vas.ui.APNGDrawable.1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Drawable invoke() {
                return ApngOptions.this.getLoadingDrawable();
            }
        });
        setTargetDrawableBuild(new Function0<URLDrawable>() { // from class: com.tencent.mobileqq.vas.ui.APNGDrawable.2

            @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\u000b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\nH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/vas/ui/APNGDrawable$2$a", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "Lcom/tencent/image/URLDrawable;", "p0", "", "onLoadSuccessed", "", "p1", "onLoadFialed", "onLoadCanceled", "", "onLoadProgressed", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1})
            /* renamed from: com.tencent.mobileqq.vas.ui.APNGDrawable$2$a */
            /* loaded from: classes20.dex */
            public static final class a implements URLDrawable.URLDrawableListener {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ APNGDrawable f311126d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ URLDrawable.URLDrawableListener f311127e;

                a(APNGDrawable aPNGDrawable, URLDrawable.URLDrawableListener uRLDrawableListener) {
                    this.f311126d = aPNGDrawable;
                    this.f311127e = uRLDrawableListener;
                }

                @Override // com.tencent.image.URLDrawable.URLDrawableListener
                public void onLoadCanceled(@Nullable URLDrawable p06) {
                    this.f311127e.onLoadCanceled(p06);
                }

                @Override // com.tencent.image.URLDrawable.URLDrawableListener
                public void onLoadFialed(@Nullable URLDrawable p06, @Nullable Throwable p16) {
                    this.f311127e.onLoadFialed(p06, p16);
                }

                @Override // com.tencent.image.URLDrawable.URLDrawableListener
                public void onLoadProgressed(@Nullable URLDrawable p06, int p16) {
                    this.f311127e.onLoadProgressed(p06, p16);
                }

                @Override // com.tencent.image.URLDrawable.URLDrawableListener
                public void onLoadSuccessed(@Nullable URLDrawable p06) {
                    Drawable drawable;
                    if (p06 != null) {
                        drawable = p06.getCurrDrawable();
                    } else {
                        drawable = null;
                    }
                    if (drawable != null) {
                        drawable.setColorFilter(this.f311126d.getColorFilter());
                    }
                    this.f311127e.onLoadSuccessed(p06);
                    Function1<APNGDrawable, Unit> loadCallback = this.f311126d.getLoadCallback();
                    if (loadCallback != null) {
                        loadCallback.invoke(this.f311126d);
                    }
                    this.f311126d.getIsLoaded().set(true);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final URLDrawable invoke() {
                ApngOptions.this.setLoadListener(new a(this, ApngOptions.this.getLoadListener()));
                return ((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getApngURLDrawable(urlStr, ApngOptions.this, filePath);
            }
        });
        AbsAsyncDrawable.load$default(this, false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void doLoadTask$lambda$0(APNGDrawable this$0, ILoaderSucessCallback callback) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        for (int i3 = 0; i3 < 7; i3++) {
            if (this$0.checkURLDrawable()) {
                isUrlDrawableInited = true;
                callback.onLoadSucceed();
                return;
            }
            LockMethodProxy.sleep(500L);
        }
    }

    public final boolean checkURLDrawable() {
        try {
            new URL("vasapngdownloader", "", "");
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.tencent.mobileqq.vas.image.AbsAsyncDrawable
    public void doLoadTask(@NotNull final ILoaderSucessCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (isUrlDrawableInited) {
            callback.onLoadSucceed();
        } else {
            ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.vas.ui.a
                @Override // java.lang.Runnable
                public final void run() {
                    APNGDrawable.doLoadTask$lambda$0(APNGDrawable.this, callback);
                }
            });
        }
    }

    @Nullable
    public final File getFileInLocal() {
        Drawable currentDrawable = getCurrentDrawable();
        if (currentDrawable instanceof URLDrawable) {
            return ((URLDrawable) currentDrawable).getFileInLocal();
        }
        return null;
    }

    @Nullable
    public final Function1<APNGDrawable, Unit> getLoadCallback() {
        return this.loadCallback;
    }

    @Override // com.tencent.mobileqq.vas.image.AbsAsyncDrawable
    @Nullable
    public Bitmap getNinePathBitmap(@Nullable Drawable d16) {
        if (d16 instanceof URLDrawable) {
            Drawable currDrawable = ((URLDrawable) d16).getCurrDrawable();
            if (currDrawable instanceof ApngDrawable) {
                return ((ApngDrawable) currDrawable).getImage().getCurrentFrame();
            }
            return null;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.vas.image.AbsAsyncDrawable
    public boolean isLoadSucess() {
        if (isUrlDrawableInited) {
            return true;
        }
        boolean checkURLDrawable = checkURLDrawable();
        isUrlDrawableInited = checkURLDrawable;
        return checkURLDrawable;
    }

    @NotNull
    /* renamed from: isLoaded, reason: from getter */
    public final AtomicBoolean getIsLoaded() {
        return this.isLoaded;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return true;
    }

    public final void pauseApng() {
        Drawable currentDrawable = getCurrentDrawable();
        if (currentDrawable instanceof URLDrawable) {
            Drawable currDrawable = ((URLDrawable) currentDrawable).getCurrDrawable();
            if (currDrawable instanceof ApngDrawable) {
                ((ApngDrawable) currDrawable).getImage().pause();
            }
        }
    }

    public final void resetApng() {
        Drawable currentDrawable = getCurrentDrawable();
        if (currentDrawable instanceof URLDrawable) {
            Drawable currDrawable = ((URLDrawable) currentDrawable).getCurrDrawable();
            if (currDrawable instanceof ApngDrawable) {
                ((ApngDrawable) currDrawable).getImage().replay();
            }
        }
    }

    public final void resumeApng() {
        Drawable currentDrawable = getCurrentDrawable();
        if (currentDrawable instanceof URLDrawable) {
            Drawable currDrawable = ((URLDrawable) currentDrawable).getCurrDrawable();
            if (currDrawable instanceof ApngDrawable) {
                ((ApngDrawable) currDrawable).getImage().resume();
            }
        }
    }

    public final void setLoadCallback(@Nullable Function1<? super APNGDrawable, Unit> function1) {
        this.loadCallback = function1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.vas.ui.IDynamicDrawable
    public void setLoadedListener(@NotNull Function1<? super IDynamicDrawable, Unit> block) {
        Function1<? super APNGDrawable, Unit> function1;
        Intrinsics.checkNotNullParameter(block, "block");
        this.loadCallback = block;
        if (this.isLoaded.get() && (function1 = this.loadCallback) != null) {
            function1.invoke(this);
        }
    }

    public final void setOnPlayRepeatListener(@NotNull ApngDrawable.OnPlayRepeatListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        Drawable currentDrawable = getCurrentDrawable();
        if (currentDrawable instanceof URLDrawable) {
            Drawable currDrawable = ((URLDrawable) currentDrawable).getCurrDrawable();
            if (currDrawable instanceof ApngDrawable) {
                ((ApngDrawable) currDrawable).setOnPlayRepeatListener(listener);
            }
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        resumeApng();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        pauseApng();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public APNGDrawable(@NotNull String from, @NotNull String urlStr) {
        this(from, urlStr, r0, r1);
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(urlStr, "urlStr");
        ApngOptions apngOptions = new ApngOptions();
        String newCacheFilePath = VasApngUtil.getNewCacheFilePath(urlStr, from);
        Intrinsics.checkNotNullExpressionValue(newCacheFilePath, "getNewCacheFilePath(urlStr, from)");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public APNGDrawable(@NotNull String from, @NotNull String urlStr, @NotNull ApngOptions options) {
        this(from, urlStr, options, r0);
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(urlStr, "urlStr");
        Intrinsics.checkNotNullParameter(options, "options");
        String newCacheFilePath = VasApngUtil.getNewCacheFilePath(urlStr, from);
        Intrinsics.checkNotNullExpressionValue(newCacheFilePath, "getNewCacheFilePath(urlStr, from)");
    }
}
