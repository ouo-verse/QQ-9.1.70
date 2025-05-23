package com.tencent.mobileqq.vas.ui;

import android.graphics.drawable.Drawable;
import com.tencent.image.ApngDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.mobileqq.vas.apng.api.IVasSharpPFactory;
import com.tencent.mobileqq.vas.apng.api.SharpPOptions;
import com.tencent.mobileqq.vas.image.AbsAsyncDrawable;
import com.tencent.mobileqq.vas.image.ILoaderSucessCallback;
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

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\tJ\u0006\u0010\u0014\u001a\u00020\u0015J\u0010\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0015H\u0016J\u0006\u0010\u001a\u001a\u00020\u000fJ\u0006\u0010\u001b\u001a\u00020\u000fJ\u0006\u0010\u001c\u001a\u00020\u000fJ\u001a\u0010\u001d\u001a\u00020\u000f2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u000f0\u000eJ\u000e\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020!R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\fR(\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/vas/ui/SharpPDrawable;", "Lcom/tencent/mobileqq/vas/image/AbsAsyncDrawable;", "urlStr", "", "(Ljava/lang/String;)V", "options", "Lcom/tencent/mobileqq/vas/apng/api/SharpPOptions;", "(Ljava/lang/String;Lcom/tencent/mobileqq/vas/apng/api/SharpPOptions;)V", "filePath", "(Ljava/lang/String;Lcom/tencent/mobileqq/vas/apng/api/SharpPOptions;Ljava/lang/String;)V", "isLoaded", "Ljava/util/concurrent/atomic/AtomicBoolean;", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "loadCallback", "Lkotlin/Function1;", "", "getLoadCallback", "()Lkotlin/jvm/functions/Function1;", "setLoadCallback", "(Lkotlin/jvm/functions/Function1;)V", "checkURLDrawable", "", "doLoadTask", "callback", "Lcom/tencent/mobileqq/vas/image/ILoaderSucessCallback;", "isLoadSucess", "pauseApng", "resetApng", "resumeApng", "setLoadedListener", "block", "setOnPlayRepeatListener", "listener", "Lcom/tencent/image/ApngDrawable$OnPlayRepeatListener;", "Companion", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class SharpPDrawable extends AbsAsyncDrawable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static boolean isUrlDrawableInited;

    @NotNull
    private final AtomicBoolean isLoaded;

    @Nullable
    private Function1<? super SharpPDrawable, Unit> loadCallback;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/vas/ui/SharpPDrawable$Companion;", "", "()V", "isUrlDrawableInited", "", "()Z", "setUrlDrawableInited", "(Z)V", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean isUrlDrawableInited() {
            return SharpPDrawable.isUrlDrawableInited;
        }

        public final void setUrlDrawableInited(boolean z16) {
            SharpPDrawable.isUrlDrawableInited = z16;
        }

        Companion() {
        }
    }

    public SharpPDrawable(@NotNull final String urlStr, @NotNull final SharpPOptions options, @NotNull final String filePath) {
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
        setFailedDrawableBuild(new Function0<Drawable>() { // from class: com.tencent.mobileqq.vas.ui.SharpPDrawable.1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Drawable invoke() {
                return SharpPOptions.this.getLoadingDrawable();
            }
        });
        setTargetDrawableBuild(new Function0<URLDrawable>() { // from class: com.tencent.mobileqq.vas.ui.SharpPDrawable.2

            @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\u000b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\nH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/vas/ui/SharpPDrawable$2$a", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "Lcom/tencent/image/URLDrawable;", "p0", "", "onLoadSuccessed", "", "p1", "onLoadFialed", "onLoadCanceled", "", "onLoadProgressed", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1})
            /* renamed from: com.tencent.mobileqq.vas.ui.SharpPDrawable$2$a */
            /* loaded from: classes20.dex */
            public static final class a implements URLDrawable.URLDrawableListener {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ SharpPDrawable f311130d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ URLDrawable.URLDrawableListener f311131e;

                a(SharpPDrawable sharpPDrawable, URLDrawable.URLDrawableListener uRLDrawableListener) {
                    this.f311130d = sharpPDrawable;
                    this.f311131e = uRLDrawableListener;
                }

                @Override // com.tencent.image.URLDrawable.URLDrawableListener
                public void onLoadCanceled(@Nullable URLDrawable p06) {
                    this.f311131e.onLoadCanceled(p06);
                }

                @Override // com.tencent.image.URLDrawable.URLDrawableListener
                public void onLoadFialed(@Nullable URLDrawable p06, @Nullable Throwable p16) {
                    this.f311131e.onLoadFialed(p06, p16);
                }

                @Override // com.tencent.image.URLDrawable.URLDrawableListener
                public void onLoadProgressed(@Nullable URLDrawable p06, int p16) {
                    this.f311131e.onLoadProgressed(p06, p16);
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
                        drawable.setColorFilter(this.f311130d.getColorFilter());
                    }
                    this.f311131e.onLoadSuccessed(p06);
                    Function1<SharpPDrawable, Unit> loadCallback = this.f311130d.getLoadCallback();
                    if (loadCallback != null) {
                        loadCallback.invoke(this.f311130d);
                    }
                    this.f311130d.getIsLoaded().set(true);
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
                SharpPOptions.this.setLoadListener(new a(this, SharpPOptions.this.getLoadListener()));
                return ((IVasSharpPFactory) QRoute.api(IVasSharpPFactory.class)).getSharpPURLDrawable(urlStr, SharpPOptions.this, filePath);
            }
        });
        AbsAsyncDrawable.load$default(this, false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void doLoadTask$lambda$0(SharpPDrawable this$0, ILoaderSucessCallback callback) {
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
            ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.vas.ui.h
                @Override // java.lang.Runnable
                public final void run() {
                    SharpPDrawable.doLoadTask$lambda$0(SharpPDrawable.this, callback);
                }
            });
        }
    }

    @Nullable
    public final Function1<SharpPDrawable, Unit> getLoadCallback() {
        return this.loadCallback;
    }

    @Override // com.tencent.mobileqq.vas.image.AbsAsyncDrawable
    /* renamed from: isLoadSucess */
    public boolean getIsLoadSuccess() {
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

    public final void setLoadCallback(@Nullable Function1<? super SharpPDrawable, Unit> function1) {
        this.loadCallback = function1;
    }

    public final void setLoadedListener(@NotNull Function1<? super SharpPDrawable, Unit> block) {
        Function1<? super SharpPDrawable, Unit> function1;
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

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SharpPDrawable(@NotNull String urlStr) {
        this(urlStr, r0, r1);
        Intrinsics.checkNotNullParameter(urlStr, "urlStr");
        SharpPOptions sharpPOptions = new SharpPOptions();
        String cacheFilePath = VasApngUtil.getCacheFilePath(urlStr);
        Intrinsics.checkNotNullExpressionValue(cacheFilePath, "getCacheFilePath(urlStr)");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SharpPDrawable(@NotNull String urlStr, @NotNull SharpPOptions options) {
        this(urlStr, options, r0);
        Intrinsics.checkNotNullParameter(urlStr, "urlStr");
        Intrinsics.checkNotNullParameter(options, "options");
        String cacheFilePath = VasApngUtil.getCacheFilePath(urlStr);
        Intrinsics.checkNotNullExpressionValue(cacheFilePath, "getCacheFilePath(urlStr)");
    }
}
