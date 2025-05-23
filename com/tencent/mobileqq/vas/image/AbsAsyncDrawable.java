package com.tencent.mobileqq.vas.image;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ams.mosaic.jsengine.animation.custom.CustomAnimation;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0083\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001d*\u0001\u0005\b&\u0018\u0000 m2\u00020\u00012\u00020\u0002:\u0002mnB\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\u0001H\u0004J\u0010\u0010@\u001a\u00020>2\u0006\u0010A\u001a\u00020BH&J\u0010\u0010C\u001a\u00020>2\u0006\u0010D\u001a\u00020EH\u0016J\n\u0010F\u001a\u0004\u0018\u00010GH\u0016J\b\u0010H\u001a\u00020#H\u0016J\b\u0010I\u001a\u00020#H\u0016J\u0014\u0010J\u001a\u0004\u0018\u00010K2\b\u0010L\u001a\u0004\u0018\u00010\u0001H\u0016J\b\u0010M\u001a\u00020#H\u0016J\u0006\u0010N\u001a\u00020#J\u0006\u0010O\u001a\u00020#J\u0010\u0010P\u001a\u00020\u00162\u0006\u0010Q\u001a\u00020RH\u0016J\b\u0010S\u001a\u00020\u0016H&J\u0012\u0010T\u001a\u00020>2\b\b\u0002\u0010U\u001a\u00020\u0016H\u0007J\b\u0010V\u001a\u00020>H\u0002J\u0012\u0010W\u001a\u00020>2\b\u0010X\u001a\u0004\u0018\u00010RH\u0014J\u0016\u0010Y\u001a\u00020>2\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020>0\u000eH\u0016J\u0016\u0010[\u001a\u00020>2\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020>0\u000eH\u0016J\u0010\u0010\\\u001a\u00020>2\u0006\u0010]\u001a\u00020#H\u0016J(\u0010^\u001a\u00020>2\u0006\u0010_\u001a\u00020#2\u0006\u0010`\u001a\u00020#2\u0006\u0010a\u001a\u00020#2\u0006\u0010b\u001a\u00020#H\u0016J\u0012\u0010c\u001a\u00020>2\b\u0010d\u001a\u0004\u0018\u000108H\u0016J\u0018\u0010c\u001a\u00020>2\u0006\u0010e\u001a\u00020#2\u0006\u0010f\u001a\u00020;H\u0016J\u0010\u0010g\u001a\u00020>2\u0006\u0010h\u001a\u00020\u0016H\u0016J\u0018\u0010i\u001a\u00020\u00162\u0006\u0010j\u001a\u00020\u00162\u0006\u0010k\u001a\u00020\u0016H\u0016J\b\u0010l\u001a\u00020>H\u0002R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0006R(\u0010\b\u001a\u0004\u0018\u00010\u00012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001@BX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R$\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u001f\u001a\u00020\u0016X\u0096\u000f\u00a2\u0006\f\u001a\u0004\b \u0010\u0018\"\u0004\b!\u0010\u001aR\u0018\u0010\"\u001a\u00020#X\u0096\u000f\u00a2\u0006\f\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0018\u0010(\u001a\u00020#X\u0096\u000f\u00a2\u0006\f\u001a\u0004\b)\u0010%\"\u0004\b*\u0010'R\u0018\u0010+\u001a\u00020,X\u0096\u000f\u00a2\u0006\f\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001a\u00101\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0018\"\u0004\b3\u0010\u001aR\"\u00104\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0012\"\u0004\b6\u0010\u0014R\u0010\u00107\u001a\u0004\u0018\u000108X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020#X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u00010;X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020#X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006o"}, d2 = {"Lcom/tencent/mobileqq/vas/image/AbsAsyncDrawable;", "Landroid/graphics/drawable/Drawable;", "Lcom/tencent/mobileqq/vas/image/IAsyncDrawableConfig;", "()V", "callbackProxy", "com/tencent/mobileqq/vas/image/AbsAsyncDrawable$callbackProxy$1", "Lcom/tencent/mobileqq/vas/image/AbsAsyncDrawable$callbackProxy$1;", "value", "currentDrawable", "getCurrentDrawable", "()Landroid/graphics/drawable/Drawable;", "setCurrentDrawable", "(Landroid/graphics/drawable/Drawable;)V", "doFailedDrawableBuild", "Lkotlin/Function0;", "doTargetDrawableBuild", "failedDrawableBuild", "getFailedDrawableBuild", "()Lkotlin/jvm/functions/Function0;", "setFailedDrawableBuild", "(Lkotlin/jvm/functions/Function0;)V", "needLoop", "", "getNeedLoop", "()Z", "setNeedLoop", "(Z)V", "ninePathCanvas", "Lcom/tencent/mobileqq/vas/image/NinePathCanvas;", "paint", "Landroid/graphics/Paint;", "requestLayoutAfterDrawableChange", "getRequestLayoutAfterDrawableChange", "setRequestLayoutAfterDrawableChange", "requestLodingHeight", "", "getRequestLodingHeight", "()I", "setRequestLodingHeight", "(I)V", "requestLodingWidth", "getRequestLodingWidth", "setRequestLodingWidth", "scaleXY", "", "getScaleXY", "()F", "setScaleXY", "(F)V", "supportNinePath", "getSupportNinePath", "setSupportNinePath", "targetDrawableBuild", "getTargetDrawableBuild", "setTargetDrawableBuild", "tmpColorFilter", "Landroid/graphics/ColorFilter;", "tmpColorFilterInt", "tmpColorFilterMode", "Landroid/graphics/PorterDuff$Mode;", "tmpalpha", "applyToDrawable", "", "child", "doLoadTask", "callback", "Lcom/tencent/mobileqq/vas/image/ILoaderSucessCallback;", "draw", PM.CANVAS, "Landroid/graphics/Canvas;", "getConstantState", "Landroid/graphics/drawable/Drawable$ConstantState;", "getIntrinsicHeight", "getIntrinsicWidth", "getNinePathBitmap", "Landroid/graphics/Bitmap;", "d", "getOpacity", "getOriginIntrinsicHeight", "getOriginIntrinsicWidth", "getPadding", "padding", "Landroid/graphics/Rect;", "isLoadSucess", "load", "isAsync", "loadAndRefresh", "onBoundsChange", "bounds", "postSubTask", "block", "postUITask", "setAlpha", com.tencent.luggage.wxa.c8.c.f123400v, "setBounds", "left", "top", "right", "bottom", "setColorFilter", CustomAnimation.KeyPath.COLOR_FILTER, "color", "mode", "setLoop", "loop", "setVisible", NodeProps.VISIBLE, "restart", "updateDrawableState", "Companion", "MyAsyncLoaderCallback", "vas_kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public abstract class AbsAsyncDrawable extends Drawable implements IAsyncDrawableConfig {

    @NotNull
    public static final String TAG = "AbsAsyncDrawable";

    @NotNull
    private final AbsAsyncDrawable$callbackProxy$1 callbackProxy;

    @Nullable
    private Drawable currentDrawable;

    @NotNull
    private final Function0<Drawable> doFailedDrawableBuild;

    @NotNull
    private final Function0<Drawable> doTargetDrawableBuild;

    @Nullable
    private Function0<? extends Drawable> failedDrawableBuild;

    @NotNull
    private final Paint paint;
    private boolean supportNinePath;

    @Nullable
    private ColorFilter tmpColorFilter;
    private int tmpColorFilterInt;

    @Nullable
    private PorterDuff.Mode tmpColorFilterMode;
    private int tmpalpha;
    private final /* synthetic */ AsyncDrawableConfigImpl $$delegate_0 = new AsyncDrawableConfigImpl();

    @NotNull
    private Function0<? extends Drawable> targetDrawableBuild = new Function0() { // from class: com.tencent.mobileqq.vas.image.AbsAsyncDrawable$targetDrawableBuild$1
        @Override // kotlin.jvm.functions.Function0
        @Nullable
        public final Void invoke() {
            return null;
        }
    };
    private boolean needLoop = true;

    @NotNull
    private final NinePathCanvas ninePathCanvas = new NinePathCanvas();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/vas/image/AbsAsyncDrawable$MyAsyncLoaderCallback;", "Lcom/tencent/mobileqq/vas/image/ILoaderSucessCallback;", "drawableRef", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/vas/image/AbsAsyncDrawable;", "(Ljava/lang/ref/WeakReference;)V", "getDrawableRef", "()Ljava/lang/ref/WeakReference;", "onLoadSucceed", "", "vas_kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static final class MyAsyncLoaderCallback implements ILoaderSucessCallback {

        @NotNull
        private final WeakReference<AbsAsyncDrawable> drawableRef;

        public MyAsyncLoaderCallback(@NotNull WeakReference<AbsAsyncDrawable> drawableRef) {
            Intrinsics.checkNotNullParameter(drawableRef, "drawableRef");
            this.drawableRef = drawableRef;
        }

        @NotNull
        public final WeakReference<AbsAsyncDrawable> getDrawableRef() {
            return this.drawableRef;
        }

        @Override // com.tencent.mobileqq.vas.image.ILoaderSucessCallback
        public void onLoadSucceed() {
            AbsAsyncDrawable absAsyncDrawable = this.drawableRef.get();
            if (absAsyncDrawable != null) {
                Drawable drawable = (Drawable) absAsyncDrawable.doTargetDrawableBuild.invoke();
                if (drawable != null) {
                    absAsyncDrawable.setCurrentDrawable(drawable);
                }
                if (absAsyncDrawable.getCurrentDrawable() == null) {
                    absAsyncDrawable.setCurrentDrawable((Drawable) absAsyncDrawable.doFailedDrawableBuild.invoke());
                }
            }
        }
    }

    public AbsAsyncDrawable() {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        this.paint = paint;
        this.doFailedDrawableBuild = new Function0<Drawable>() { // from class: com.tencent.mobileqq.vas.image.AbsAsyncDrawable$doFailedDrawableBuild$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Drawable invoke() {
                try {
                    Function0<Drawable> failedDrawableBuild = AbsAsyncDrawable.this.getFailedDrawableBuild();
                    if (failedDrawableBuild != null) {
                        return failedDrawableBuild.invoke();
                    }
                    return null;
                } catch (Throwable th5) {
                    QLog.e("AbsAsyncDrawable", 1, "error", th5);
                    return null;
                }
            }
        };
        this.doTargetDrawableBuild = new Function0<Drawable>() { // from class: com.tencent.mobileqq.vas.image.AbsAsyncDrawable$doTargetDrawableBuild$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Drawable invoke() {
                try {
                    return AbsAsyncDrawable.this.getTargetDrawableBuild().invoke();
                } catch (Throwable th5) {
                    QLog.e("AbsAsyncDrawable", 1, "error", th5);
                    return null;
                }
            }
        };
        this.callbackProxy = new AbsAsyncDrawable$callbackProxy$1(this);
        this.tmpalpha = 255;
    }

    public static /* synthetic */ void load$default(AbsAsyncDrawable absAsyncDrawable, boolean z16, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                z16 = true;
            }
            absAsyncDrawable.load(z16);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: load");
    }

    public final void loadAndRefresh() {
        MyAsyncLoaderCallback myAsyncLoaderCallback = new MyAsyncLoaderCallback(new WeakReference(this));
        if (isLoadSucess()) {
            myAsyncLoaderCallback.onLoadSucceed();
        } else {
            doLoadTask(myAsyncLoaderCallback);
        }
    }

    public static final void postSubTask$lambda$1(Function0 tmp0) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke();
    }

    public static final void postUITask$lambda$0(Function0 tmp0) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke();
    }

    public final void setCurrentDrawable(Drawable drawable) {
        if (!Intrinsics.areEqual(drawable, this.currentDrawable)) {
            Drawable drawable2 = this.currentDrawable;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            if (drawable != null) {
                drawable.setCallback(this.callbackProxy);
            }
            this.currentDrawable = drawable;
            updateDrawableState();
        }
    }

    private final void updateDrawableState() {
        postUITask(new Function0<Unit>() { // from class: com.tencent.mobileqq.vas.image.AbsAsyncDrawable$updateDrawableState$1
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
                Drawable currentDrawable = AbsAsyncDrawable.this.getCurrentDrawable();
                if (currentDrawable != null) {
                    AbsAsyncDrawable absAsyncDrawable = AbsAsyncDrawable.this;
                    absAsyncDrawable.applyToDrawable(currentDrawable);
                    absAsyncDrawable.invalidateSelf();
                }
            }
        });
    }

    public final void applyToDrawable(@NotNull Drawable child) {
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

    public abstract void doLoadTask(@NotNull ILoaderSucessCallback callback);

    @Override // android.graphics.drawable.Drawable
    public void draw(@NotNull Canvas r56) {
        Bitmap ninePathBitmap;
        Intrinsics.checkNotNullParameter(r56, "canvas");
        final Drawable drawable = this.currentDrawable;
        if (drawable != null) {
            if (this.supportNinePath && (ninePathBitmap = getNinePathBitmap(drawable)) != null) {
                this.ninePathCanvas.setPaint(this.paint);
                if (this.ninePathCanvas.draw(r56, ninePathBitmap, getBounds())) {
                    i.f309597a.a(new Function1<Canvas, Unit>() { // from class: com.tencent.mobileqq.vas.image.AbsAsyncDrawable$draw$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Canvas canvas) {
                            invoke2(canvas);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull Canvas canvas) {
                            Intrinsics.checkNotNullParameter(canvas, "canvas");
                            drawable.draw(canvas);
                        }
                    });
                    return;
                }
            }
            drawable.setBounds(getBounds());
            drawable.draw(r56);
        }
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
    public final Function0<Drawable> getFailedDrawableBuild() {
        return this.failedDrawableBuild;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        boolean z16;
        if (getScaleXY() == 1.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return getOriginIntrinsicHeight();
        }
        return (int) (getOriginIntrinsicHeight() * getScaleXY());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        boolean z16;
        if (getScaleXY() == 1.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return getOriginIntrinsicWidth();
        }
        return (int) (getOriginIntrinsicWidth() * getScaleXY());
    }

    public final boolean getNeedLoop() {
        return this.needLoop;
    }

    @Nullable
    public Bitmap getNinePathBitmap(@Nullable Drawable d16) {
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.currentDrawable;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    public final int getOriginIntrinsicHeight() {
        if (getRequestLodingHeight() != -1) {
            return getRequestLodingHeight();
        }
        Drawable drawable = this.currentDrawable;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return super.getIntrinsicHeight();
    }

    public final int getOriginIntrinsicWidth() {
        if (getRequestLodingWidth() != -1) {
            return getRequestLodingWidth();
        }
        Drawable drawable = this.currentDrawable;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return super.getIntrinsicWidth();
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

    @Override // com.tencent.mobileqq.vas.image.IAsyncDrawableConfig
    public boolean getRequestLayoutAfterDrawableChange() {
        return this.$$delegate_0.getRequestLayoutAfterDrawableChange();
    }

    @Override // com.tencent.mobileqq.vas.image.IAsyncDrawableConfig
    public int getRequestLodingHeight() {
        return this.$$delegate_0.getRequestLodingHeight();
    }

    @Override // com.tencent.mobileqq.vas.image.IAsyncDrawableConfig
    public int getRequestLodingWidth() {
        return this.$$delegate_0.getRequestLodingWidth();
    }

    @Override // com.tencent.mobileqq.vas.image.IAsyncDrawableConfig
    public float getScaleXY() {
        return this.$$delegate_0.getScaleXY();
    }

    public final boolean getSupportNinePath() {
        return this.supportNinePath;
    }

    @NotNull
    public final Function0<Drawable> getTargetDrawableBuild() {
        return this.targetDrawableBuild;
    }

    public abstract boolean isLoadSucess();

    @JvmOverloads
    public final void load() {
        load$default(this, false, 1, null);
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(@Nullable Rect bounds) {
        Drawable drawable;
        if (bounds != null && (drawable = this.currentDrawable) != null) {
            drawable.setBounds(bounds);
        }
        super.onBoundsChange(bounds);
    }

    public void postSubTask(@NotNull final Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vas.image.a
            @Override // java.lang.Runnable
            public final void run() {
                AbsAsyncDrawable.postSubTask$lambda$1(Function0.this);
            }
        }, 16, null, false);
    }

    public void postUITask(@NotNull final Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            block.invoke();
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.vas.image.b
                @Override // java.lang.Runnable
                public final void run() {
                    AbsAsyncDrawable.postUITask$lambda$0(Function0.this);
                }
            });
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r26) {
        Drawable drawable = this.currentDrawable;
        if (drawable != null) {
            drawable.setAlpha(r26);
        }
        this.tmpalpha = r26;
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
    public void setColorFilter(@Nullable ColorFilter r26) {
        Drawable drawable = this.currentDrawable;
        if (drawable != null) {
            drawable.setColorFilter(r26);
        }
        this.tmpColorFilter = r26;
        this.tmpColorFilterMode = null;
    }

    public final void setFailedDrawableBuild(@Nullable Function0<? extends Drawable> function0) {
        this.failedDrawableBuild = function0;
    }

    public void setLoop(boolean loop) {
        int i3;
        this.needLoop = loop;
        Object obj = this.currentDrawable;
        if (obj != null && (obj instanceof com.tencent.cachedrawable.dynamicdrawable.d)) {
            com.tencent.cachedrawable.dynamicdrawable.d dVar = (com.tencent.cachedrawable.dynamicdrawable.d) obj;
            if (loop) {
                i3 = Integer.MAX_VALUE;
            } else {
                i3 = 1;
            }
            dVar.setLoopCount(i3);
        }
    }

    public final void setNeedLoop(boolean z16) {
        this.needLoop = z16;
    }

    @Override // com.tencent.mobileqq.vas.image.IAsyncDrawableConfig
    public void setRequestLayoutAfterDrawableChange(boolean z16) {
        this.$$delegate_0.setRequestLayoutAfterDrawableChange(z16);
    }

    @Override // com.tencent.mobileqq.vas.image.IAsyncDrawableConfig
    public void setRequestLodingHeight(int i3) {
        this.$$delegate_0.setRequestLodingHeight(i3);
    }

    @Override // com.tencent.mobileqq.vas.image.IAsyncDrawableConfig
    public void setRequestLodingWidth(int i3) {
        this.$$delegate_0.setRequestLodingWidth(i3);
    }

    @Override // com.tencent.mobileqq.vas.image.IAsyncDrawableConfig
    public void setScaleXY(float f16) {
        this.$$delegate_0.setScaleXY(f16);
    }

    public final void setSupportNinePath(boolean z16) {
        this.supportNinePath = z16;
    }

    public final void setTargetDrawableBuild(@NotNull Function0<? extends Drawable> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.targetDrawableBuild = function0;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean r26, boolean restart) {
        Drawable drawable = this.currentDrawable;
        if (drawable != null) {
            drawable.setVisible(r26, restart);
        }
        return super.setVisible(r26, restart);
    }

    @JvmOverloads
    public final void load(boolean isAsync) {
        Drawable invoke;
        if (isAsync) {
            postSubTask(new Function0<Unit>() { // from class: com.tencent.mobileqq.vas.image.AbsAsyncDrawable$load$1
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
                    Drawable drawable;
                    if (!AbsAsyncDrawable.this.isLoadSucess() && (drawable = (Drawable) AbsAsyncDrawable.this.doFailedDrawableBuild.invoke()) != null) {
                        AbsAsyncDrawable.this.setCurrentDrawable(drawable);
                    }
                    AbsAsyncDrawable.this.loadAndRefresh();
                }
            });
            return;
        }
        if (!isLoadSucess() && (invoke = this.doFailedDrawableBuild.invoke()) != null) {
            setCurrentDrawable(invoke);
        }
        loadAndRefresh();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(int color, @NotNull PorterDuff.Mode mode) {
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
