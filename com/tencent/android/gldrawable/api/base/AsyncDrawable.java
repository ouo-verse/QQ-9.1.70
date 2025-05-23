package com.tencent.android.gldrawable.api.base;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ams.mosaic.jsengine.animation.custom.CustomAnimation;
import com.tencent.android.gldrawable.api.GLDrawableApi;
import com.tencent.android.gldrawable.api.IAsyncDrawableConfig;
import com.tencent.android.gldrawable.api.IGLDrawable;
import com.tencent.android.gldrawable.api.ILoadUtils;
import com.tencent.android.gldrawable.api.ILoaderSucessCallback;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000q\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001QB\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\bH\u0002J\u0010\u0010*\u001a\u00020(2\u0006\u0010)\u001a\u00020\bH\u0002J\r\u0010+\u001a\u00020(H\u0000\u00a2\u0006\u0002\b,J\n\u0010-\u001a\u0004\u0018\u00010.H\u0016J\b\u0010/\u001a\u00020\u001bH\u0016J\b\u00100\u001a\u00020\u001bH\u0016J\b\u00101\u001a\u00020\u001bH\u0016J\u0010\u00102\u001a\u00020\u00172\u0006\u00103\u001a\u000204H\u0016J\b\u00105\u001a\u000206H\u0016J\b\u00107\u001a\u00020\u0017H\u0016J\b\u00108\u001a\u00020(H\u0002J\u0012\u00109\u001a\u00020(2\b\u0010:\u001a\u0004\u0018\u000104H\u0014J0\u0010;\u001a\u00020(2\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\u001b2\u0006\u0010?\u001a\u00020\u001b2\u0006\u0010@\u001a\u00020\u001b2\u0006\u0010A\u001a\u00020\u001bH\u0016J\u0018\u0010B\u001a\u00020(2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020DH\u0016J\b\u0010F\u001a\u00020(H\u0016J\u0010\u0010G\u001a\u00020(2\u0006\u0010H\u001a\u00020\u001bH\u0016J(\u0010I\u001a\u00020(2\u0006\u0010>\u001a\u00020\u001b2\u0006\u0010?\u001a\u00020\u001b2\u0006\u0010@\u001a\u00020\u001b2\u0006\u0010A\u001a\u00020\u001bH\u0016J\u0012\u0010J\u001a\u00020(2\b\u0010K\u001a\u0004\u0018\u00010LH\u0016J\u0018\u0010M\u001a\u00020\u00172\u0006\u0010N\u001a\u00020\u00172\u0006\u0010O\u001a\u00020\u0017H\u0016J\b\u0010P\u001a\u00020(H\u0002R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0006R(\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b@BX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R$\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u000fX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u001a\u001a\u00020\u001bX\u0096\u000f\u00a2\u0006\f\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0018\u0010 \u001a\u00020\u001bX\u0096\u000f\u00a2\u0006\f\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR\"\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u000fX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0013\"\u0004\b%\u0010\u0015R\u000e\u0010&\u001a\u00020\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006R"}, d2 = {"Lcom/tencent/android/gldrawable/api/base/AsyncDrawable;", "Lcom/tencent/android/gldrawable/api/base/ScaleTypeDrawable;", "Lcom/tencent/android/gldrawable/api/IAsyncDrawableConfig;", "()V", "callbackProxy", "com/tencent/android/gldrawable/api/base/AsyncDrawable$callbackProxy$1", "Lcom/tencent/android/gldrawable/api/base/AsyncDrawable$callbackProxy$1;", "value", "Landroid/graphics/drawable/Drawable;", "currentDrawable", "getCurrentDrawable", "()Landroid/graphics/drawable/Drawable;", "setCurrentDrawable", "(Landroid/graphics/drawable/Drawable;)V", "doFailedDrawableBuild", "Lkotlin/Function0;", "doTargetDrawableBuild", "failedDrawableBuild", "getFailedDrawableBuild$api_release", "()Lkotlin/jvm/functions/Function0;", "setFailedDrawableBuild$api_release", "(Lkotlin/jvm/functions/Function0;)V", "isRecycle", "", "loaderUtils", "Lcom/tencent/android/gldrawable/api/ILoadUtils;", "requestLodingHeight", "", "getRequestLodingHeight", "()I", "setRequestLodingHeight", "(I)V", "requestLodingWidth", "getRequestLodingWidth", "setRequestLodingWidth", "targetDrawableBuild", "getTargetDrawableBuild$api_release", "setTargetDrawableBuild$api_release", "tmpalpha", "applyToBaseDrawable", "", "child", "applyToDrawable", "build", "build$api_release", "getConstantState", "Landroid/graphics/drawable/Drawable$ConstantState;", "getIntrinsicHeight", "getIntrinsicWidth", "getOpacity", "getPadding", "padding", "Landroid/graphics/Rect;", "getResID", "", "isRecyclyed", "loadAndRefresh", "onBoundsChange", "bounds", "onDraw", PM.CANVAS, "Landroid/graphics/Canvas;", "left", "top", "right", "bottom", "onTouch", HippyTKDListViewAdapter.X, "", "y", "recycle", "setAlpha", c.f123400v, "setBounds", "setColorFilter", CustomAnimation.KeyPath.COLOR_FILTER, "Landroid/graphics/ColorFilter;", "setVisible", NodeProps.VISIBLE, "restart", "updateDrawableState", "MyAsyncLoaderCallback", "api_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes3.dex */
public final class AsyncDrawable extends ScaleTypeDrawable implements IAsyncDrawableConfig {

    @Nullable
    private Drawable currentDrawable;

    @Nullable
    private Function0<? extends Drawable> failedDrawableBuild;
    private boolean isRecycle;
    private final /* synthetic */ AsyncDrawableConfigImpl $$delegate_0 = new AsyncDrawableConfigImpl();

    @NotNull
    private Function0<? extends Drawable> targetDrawableBuild = new Function0() { // from class: com.tencent.android.gldrawable.api.base.AsyncDrawable$targetDrawableBuild$1
        @Override // kotlin.jvm.functions.Function0
        @Nullable
        public final Void invoke() {
            return null;
        }
    };
    private final ILoadUtils loaderUtils = GLDrawableApi.INSTANCE.getLoader().getLoaderUtils();
    private final Function0<Drawable> doFailedDrawableBuild = new Function0<Drawable>() { // from class: com.tencent.android.gldrawable.api.base.AsyncDrawable$doFailedDrawableBuild$1
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @Nullable
        public final Drawable invoke() {
            try {
                Function0<Drawable> failedDrawableBuild$api_release = AsyncDrawable.this.getFailedDrawableBuild$api_release();
                if (failedDrawableBuild$api_release != null) {
                    return failedDrawableBuild$api_release.invoke();
                }
                return null;
            } catch (Throwable th5) {
                GLDrawableApi.INSTANCE.getLogger$api_release().logE("error", th5);
                return null;
            }
        }
    };
    private final Function0<Drawable> doTargetDrawableBuild = new Function0<Drawable>() { // from class: com.tencent.android.gldrawable.api.base.AsyncDrawable$doTargetDrawableBuild$1
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @Nullable
        public final Drawable invoke() {
            try {
                return AsyncDrawable.this.getTargetDrawableBuild$api_release().invoke();
            } catch (Throwable th5) {
                GLDrawableApi.INSTANCE.getLogger$api_release().logE("error", th5);
                return null;
            }
        }
    };
    private final AsyncDrawable$callbackProxy$1 callbackProxy = new Drawable.Callback() { // from class: com.tencent.android.gldrawable.api.base.AsyncDrawable$callbackProxy$1
        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(@NotNull Drawable who) {
            Intrinsics.checkNotNullParameter(who, "who");
            Drawable.Callback callback = AsyncDrawable.this.getCallback();
            if (callback != null) {
                callback.invalidateDrawable(AsyncDrawable.this);
                if (callback instanceof View) {
                    View view = (View) callback;
                    if (view.getLayoutParams().width == -2 || view.getLayoutParams().height == -2) {
                        view.requestLayout();
                    }
                }
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(@NotNull Drawable who, @NotNull Runnable what, long time) {
            Intrinsics.checkNotNullParameter(who, "who");
            Intrinsics.checkNotNullParameter(what, "what");
            Drawable.Callback callback = AsyncDrawable.this.getCallback();
            if (callback != null) {
                callback.scheduleDrawable(AsyncDrawable.this, what, time);
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(@NotNull Drawable who, @NotNull Runnable what) {
            Intrinsics.checkNotNullParameter(who, "who");
            Intrinsics.checkNotNullParameter(what, "what");
            Drawable.Callback callback = AsyncDrawable.this.getCallback();
            if (callback != null) {
                callback.unscheduleDrawable(AsyncDrawable.this, what);
            }
        }
    };
    private int tmpalpha = 255;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/android/gldrawable/api/base/AsyncDrawable$MyAsyncLoaderCallback;", "Lcom/tencent/android/gldrawable/api/ILoaderSucessCallback;", "drawableRef", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/android/gldrawable/api/base/AsyncDrawable;", "(Ljava/lang/ref/WeakReference;)V", "getDrawableRef", "()Ljava/lang/ref/WeakReference;", "onLoadSucceed", "", "api_release"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes3.dex */
    public static final class MyAsyncLoaderCallback implements ILoaderSucessCallback {

        @NotNull
        private final WeakReference<AsyncDrawable> drawableRef;

        public MyAsyncLoaderCallback(@NotNull WeakReference<AsyncDrawable> drawableRef) {
            Intrinsics.checkNotNullParameter(drawableRef, "drawableRef");
            this.drawableRef = drawableRef;
        }

        @NotNull
        public final WeakReference<AsyncDrawable> getDrawableRef() {
            return this.drawableRef;
        }

        @Override // com.tencent.android.gldrawable.api.ILoaderSucessCallback
        public void onLoadSucceed() {
            final AsyncDrawable asyncDrawable = this.drawableRef.get();
            if (asyncDrawable != null) {
                asyncDrawable.loaderUtils.postSubTask(new Function0<Unit>() { // from class: com.tencent.android.gldrawable.api.base.AsyncDrawable$MyAsyncLoaderCallback$onLoadSucceed$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        Function0 function0;
                        Function0 function02;
                        function0 = AsyncDrawable.this.doTargetDrawableBuild;
                        Drawable drawable = (Drawable) function0.invoke();
                        if (drawable != null) {
                            AsyncDrawable.this.setCurrentDrawable(drawable);
                        }
                        if (AsyncDrawable.this.getCurrentDrawable() == null) {
                            AsyncDrawable asyncDrawable2 = AsyncDrawable.this;
                            function02 = asyncDrawable2.doFailedDrawableBuild;
                            asyncDrawable2.setCurrentDrawable((Drawable) function02.invoke());
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void applyToBaseDrawable(Drawable child) {
        if (child instanceof IGLDrawable) {
            if (this.isRecycle) {
                ((IGLDrawable) child).recycle();
            }
            if (child instanceof Animatable) {
                ((Animatable) child).start();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyToDrawable(Drawable child) {
        child.setCallback(this.callbackProxy);
        child.setAlpha(this.tmpalpha);
        child.setBounds(getBounds());
        child.setVisible(isVisible(), false);
    }

    private final void loadAndRefresh() {
        MyAsyncLoaderCallback myAsyncLoaderCallback = new MyAsyncLoaderCallback(new WeakReference(this));
        GLDrawableApi gLDrawableApi = GLDrawableApi.INSTANCE;
        if (gLDrawableApi.getState().isStaticModel()) {
            myAsyncLoaderCallback.onLoadSucceed();
        } else if (gLDrawableApi.getState().isDynamicReady()) {
            myAsyncLoaderCallback.onLoadSucceed();
        } else {
            gLDrawableApi.registerLoadSucessCallback$api_release(myAsyncLoaderCallback);
            gLDrawableApi.loadDynamicSync$api_release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setCurrentDrawable(Drawable drawable) {
        if (!Intrinsics.areEqual(drawable, this.currentDrawable)) {
            this.currentDrawable = drawable;
            updateDrawableState();
        }
    }

    private final void updateDrawableState() {
        this.loaderUtils.postUITask(new Function0<Unit>() { // from class: com.tencent.android.gldrawable.api.base.AsyncDrawable$updateDrawableState$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Drawable currentDrawable = AsyncDrawable.this.getCurrentDrawable();
                if (currentDrawable != null) {
                    AsyncDrawable.this.applyToDrawable(currentDrawable);
                    AsyncDrawable.this.applyToBaseDrawable(currentDrawable);
                    AsyncDrawable.this.invalidateSelf();
                }
            }
        });
    }

    public final void build$api_release() {
        Drawable invoke;
        GLDrawableApi gLDrawableApi = GLDrawableApi.INSTANCE;
        if (!gLDrawableApi.getState().isStaticModel() && !gLDrawableApi.getState().isDynamicReady() && (invoke = this.doFailedDrawableBuild.invoke()) != null) {
            setCurrentDrawable(invoke);
        }
        loadAndRefresh();
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public Drawable.ConstantState getConstantState() {
        Drawable drawable = this.currentDrawable;
        if (drawable != null) {
            return drawable.getConstantState();
        }
        return null;
    }

    @Nullable
    public final Drawable getCurrentDrawable() {
        return this.currentDrawable;
    }

    @Nullable
    public final Function0<Drawable> getFailedDrawableBuild$api_release() {
        return this.failedDrawableBuild;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.currentDrawable;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        if (getRequestLodingHeight() != -1) {
            return getRequestLodingHeight();
        }
        return super.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.currentDrawable;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        if (getRequestLodingWidth() != -1) {
            return getRequestLodingWidth();
        }
        return super.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.currentDrawable;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(@NotNull Rect padding) {
        Intrinsics.checkNotNullParameter(padding, "padding");
        Drawable drawable = this.currentDrawable;
        if (drawable != null) {
            return drawable.getPadding(padding);
        }
        return super.getPadding(padding);
    }

    @Override // com.tencent.android.gldrawable.api.IAsyncDrawableConfig
    public int getRequestLodingHeight() {
        return this.$$delegate_0.getRequestLodingHeight();
    }

    @Override // com.tencent.android.gldrawable.api.IAsyncDrawableConfig
    public int getRequestLodingWidth() {
        return this.$$delegate_0.getRequestLodingWidth();
    }

    @Override // com.tencent.android.gldrawable.api.IGLDrawable
    @NotNull
    public String getResID() {
        Drawable drawable = this.currentDrawable;
        if (drawable != null && (drawable instanceof IGLDrawable)) {
            return ((IGLDrawable) drawable).getResID();
        }
        return "";
    }

    @NotNull
    public final Function0<Drawable> getTargetDrawableBuild$api_release() {
        return this.targetDrawableBuild;
    }

    @Override // com.tencent.android.gldrawable.api.IGLDrawable
    public boolean isRecyclyed() {
        throw new RuntimeException("can not call isRecyclyed()");
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(@Nullable Rect bounds) {
        Drawable drawable;
        if (bounds != null && (drawable = this.currentDrawable) != null) {
            drawable.setBounds(bounds);
        }
        super.onBoundsChange(bounds);
    }

    @Override // com.tencent.android.gldrawable.api.base.ScaleTypeDrawable
    public void onDraw(@NotNull Canvas canvas, int left, int top, int right, int bottom) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Drawable drawable = this.currentDrawable;
        if (drawable != null) {
            drawable.setBounds(left, top, right, bottom);
            drawable.draw(canvas);
        }
    }

    @Override // com.tencent.android.gldrawable.api.IGLDrawable
    public void onTouch(float x16, float y16) {
        Drawable drawable = this.currentDrawable;
        if (drawable != null && (drawable instanceof IGLDrawable)) {
            ((IGLDrawable) drawable).onTouch(x16, y16);
        }
    }

    @Override // com.tencent.android.gldrawable.api.IGLDrawable
    public void recycle() {
        Drawable drawable = this.currentDrawable;
        if (drawable != null && (drawable instanceof IGLDrawable)) {
            ((IGLDrawable) drawable).recycle();
        }
        this.isRecycle = true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        Drawable drawable = this.currentDrawable;
        if (drawable != null) {
            drawable.setAlpha(alpha);
        }
        this.tmpalpha = alpha;
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int left, int top, int right, int bottom) {
        Drawable drawable = this.currentDrawable;
        if (drawable != null) {
            drawable.setBounds(left, top, right, bottom);
        }
        super.setBounds(left, top, right, bottom);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        Drawable drawable = this.currentDrawable;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        }
    }

    public final void setFailedDrawableBuild$api_release(@Nullable Function0<? extends Drawable> function0) {
        this.failedDrawableBuild = function0;
    }

    @Override // com.tencent.android.gldrawable.api.IAsyncDrawableConfig
    public void setRequestLodingHeight(int i3) {
        this.$$delegate_0.setRequestLodingHeight(i3);
    }

    @Override // com.tencent.android.gldrawable.api.IAsyncDrawableConfig
    public void setRequestLodingWidth(int i3) {
        this.$$delegate_0.setRequestLodingWidth(i3);
    }

    public final void setTargetDrawableBuild$api_release(@NotNull Function0<? extends Drawable> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.targetDrawableBuild = function0;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean visible, boolean restart) {
        Drawable drawable = this.currentDrawable;
        if (drawable != null) {
            drawable.setVisible(visible, restart);
        }
        return super.setVisible(visible, restart);
    }
}
