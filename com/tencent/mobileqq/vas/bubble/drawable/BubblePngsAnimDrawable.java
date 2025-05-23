package com.tencent.mobileqq.vas.bubble.drawable;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.cachedrawable.dynamicdrawable.api.a;
import com.tencent.cachedrawable.dynamicdrawable.cachedrawable.FastDynamicDrawable;
import com.tencent.cachedrawable.dynamicdrawable.cachedrawable.k;
import com.tencent.cachedrawable.dynamicdrawable.d;
import com.tencent.mobileqq.vas.bubble.IBubbleManager;
import com.tencent.mobileqq.vas.image.AbsAsyncDrawable;
import com.tencent.mobileqq.vas.image.ILoaderSucessCallback;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.QZoneClickReport;
import f03.b;
import java.io.File;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B/\u0012\u0006\u0010\"\u001a\u00020!\u0012\u0006\u0010$\u001a\u00020#\u0012\u0006\u0010&\u001a\u00020%\u0012\u0006\u0010'\u001a\u00020\u0011\u0012\u0006\u0010(\u001a\u00020\u0003\u00a2\u0006\u0004\b)\u0010*J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u001c\u0010\u0010\u001a\u00020\u00072\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0013\u001a\u00020\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0007H\u0016J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0015H\u0016R$\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0018R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/vas/bubble/drawable/BubblePngsAnimDrawable;", "Lcom/tencent/mobileqq/vas/image/AbsAsyncDrawable;", "Lc03/a;", "", "isLoadSucess", "Lcom/tencent/mobileqq/vas/image/ILoaderSucessCallback;", "callback", "", "doLoadTask", "restart", "stop", "Lcom/tencent/cachedrawable/dynamicdrawable/d$a;", "listener", "d", "Lkotlin/Function1;", "block", "setLoadedListener", "", "getIntrinsicWidth", "getIntrinsicHeight", "destroy", "Landroid/graphics/Canvas;", PM.CANVAS, "draw", "Lkotlin/jvm/functions/Function1;", "loadCallback", "Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/FastDynamicDrawable;", "e", "Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/FastDynamicDrawable;", "curCacheDrawable", "f", "Z", "isNinePathPng", "Lf03/a;", "animationConfig", "Lf03/b;", "bubbleConfig", "", "drawablePath", "messageType", "isMirror", "<init>", "(Lf03/a;Lf03/b;Ljava/lang/String;IZ)V", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class BubblePngsAnimDrawable extends AbsAsyncDrawable implements c03.a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<? super c03.a, Unit> loadCallback;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FastDynamicDrawable curCacheDrawable;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isNinePathPng;

    public BubblePngsAnimDrawable(@NotNull final f03.a animationConfig, @NotNull final b bubbleConfig, @NotNull final String drawablePath, final int i3, final boolean z16) {
        Intrinsics.checkNotNullParameter(animationConfig, "animationConfig");
        Intrinsics.checkNotNullParameter(bubbleConfig, "bubbleConfig");
        Intrinsics.checkNotNullParameter(drawablePath, "drawablePath");
        setFailedDrawableBuild(new Function0() { // from class: com.tencent.mobileqq.vas.bubble.drawable.BubblePngsAnimDrawable.1
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Void invoke() {
                return null;
            }
        });
        setTargetDrawableBuild(new Function0<FastDynamicDrawable>() { // from class: com.tencent.mobileqq.vas.bubble.drawable.BubblePngsAnimDrawable.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FastDynamicDrawable invoke() {
                boolean endsWith$default;
                File file = new File(drawablePath);
                if (file.exists()) {
                    String[] list = file.list();
                    String[] strArr = null;
                    boolean z17 = false;
                    if (list != null) {
                        ArrayList arrayList = new ArrayList();
                        for (String it : list) {
                            Intrinsics.checkNotNullExpressionValue(it, "it");
                            endsWith$default = StringsKt__StringsJVMKt.endsWith$default(it, ".9.png", false, 2, null);
                            if (endsWith$default) {
                                arrayList.add(it);
                            }
                        }
                        Object[] array = arrayList.toArray(new String[0]);
                        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                        strArr = (String[]) array;
                    }
                    BubblePngsAnimDrawable bubblePngsAnimDrawable = this;
                    if (strArr != null) {
                        if (!(strArr.length == 0)) {
                            z17 = true;
                        }
                    }
                    bubblePngsAnimDrawable.isNinePathPng = z17;
                }
                a.C1005a h16 = com.tencent.cachedrawable.dynamicdrawable.api.a.a().d(drawablePath).c(com.tencent.cachedrawable.dynamicdrawable.decoder.b.f99048a).h(new Function1<k, Unit>() { // from class: com.tencent.mobileqq.vas.bubble.drawable.BubblePngsAnimDrawable$2$cacheDrawableBuilder$1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(k kVar) {
                        invoke2(kVar);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull k it5) {
                        Intrinsics.checkNotNullParameter(it5, "it");
                        it5.H(false);
                        it5.I(false);
                        it5.F(QZoneClickReport.ClickReportConfig.SOURCE_FROM_AIO);
                    }
                });
                if (this.isNinePathPng) {
                    h16.e(bubbleConfig.getNinePatchCenterX(), bubbleConfig.getNinePatchCenterY());
                }
                final FastDynamicDrawable a16 = h16.a();
                final f03.a aVar = animationConfig;
                final int i16 = i3;
                final boolean z18 = z16;
                final BubblePngsAnimDrawable bubblePngsAnimDrawable2 = this;
                a16.c0(new Function1<d, Unit>() { // from class: com.tencent.mobileqq.vas.bubble.drawable.BubblePngsAnimDrawable.2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(d dVar) {
                        invoke2(dVar);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull d it5) {
                        Intrinsics.checkNotNullParameter(it5, "it");
                        if (f03.a.this.getCycleCount() > 0) {
                            a16.setLoopCount(f03.a.this.getCycleCount() != Integer.MAX_VALUE ? f03.a.this.getCycleCount() + 1 : Integer.MAX_VALUE);
                        }
                        if (f03.a.this.getGifRect() != null) {
                            f03.a aVar2 = f03.a.this;
                            FastDynamicDrawable fastDynamicDrawable = a16;
                            int[] gifRect = aVar2.getGifRect();
                            Intrinsics.checkNotNull(gifRect);
                            int i17 = gifRect[0];
                            int[] gifRect2 = aVar2.getGifRect();
                            Intrinsics.checkNotNull(gifRect2);
                            int i18 = gifRect2[1];
                            int[] gifRect3 = aVar2.getGifRect();
                            Intrinsics.checkNotNull(gifRect3);
                            int i19 = gifRect3[2];
                            int[] gifRect4 = aVar2.getGifRect();
                            Intrinsics.checkNotNull(gifRect4);
                            fastDynamicDrawable.setBounds(new Rect(i17, i18, i19, gifRect4[3]));
                        }
                        String align = f03.a.this.getAlign();
                        if (align != null) {
                            FastDynamicDrawable fastDynamicDrawable2 = a16;
                            fastDynamicDrawable2.Z(align);
                            fastDynamicDrawable2.a0(-1);
                        }
                        if (i16 == IBubbleManager.INSTANCE.e()) {
                            a16.a0(3);
                            a16.stop();
                        } else {
                            a16.d0(new Rect(f03.a.this.getPaddingLeft(), f03.a.this.getCom.tencent.mtt.hippy.dom.node.NodeProps.PADDING_TOP java.lang.String(), f03.a.this.getCom.tencent.mtt.hippy.dom.node.NodeProps.PADDING_RIGHT java.lang.String(), f03.a.this.getPaddingBottom()));
                        }
                        a16.b0(z18);
                        bubblePngsAnimDrawable2.curCacheDrawable = a16;
                        Function1 function1 = bubblePngsAnimDrawable2.loadCallback;
                        if (function1 != null) {
                            function1.invoke(bubblePngsAnimDrawable2);
                        }
                    }
                });
                return a16;
            }
        });
        AbsAsyncDrawable.load$default(this, false, 1, null);
    }

    @Override // c03.a
    public void d(@NotNull d.a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        FastDynamicDrawable fastDynamicDrawable = this.curCacheDrawable;
        if (fastDynamicDrawable != null) {
            fastDynamicDrawable.d(listener);
        }
    }

    @Override // com.tencent.mobileqq.vas.image.AbsAsyncDrawable
    public void doLoadTask(@NotNull ILoaderSucessCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
    }

    @Override // com.tencent.mobileqq.vas.image.AbsAsyncDrawable, android.graphics.drawable.Drawable
    public void draw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Drawable currentDrawable = getCurrentDrawable();
        if (currentDrawable != null) {
            int save = canvas.save();
            if (this.isNinePathPng) {
                float f16 = BaseApplication.getContext().getResources().getDisplayMetrics().density / 2.0f;
                canvas.scale(f16, f16);
            }
            currentDrawable.setBounds(getBounds());
            currentDrawable.draw(canvas);
            canvas.restoreToCount(save);
        }
    }

    @Override // com.tencent.mobileqq.vas.image.AbsAsyncDrawable, android.graphics.drawable.Drawable
    /* renamed from: getIntrinsicHeight */
    public int getHeight() {
        FastDynamicDrawable fastDynamicDrawable = this.curCacheDrawable;
        if (fastDynamicDrawable != null) {
            return fastDynamicDrawable.getIntrinsicHeight();
        }
        return -1;
    }

    @Override // com.tencent.mobileqq.vas.image.AbsAsyncDrawable, android.graphics.drawable.Drawable
    /* renamed from: getIntrinsicWidth */
    public int getWidth() {
        FastDynamicDrawable fastDynamicDrawable = this.curCacheDrawable;
        if (fastDynamicDrawable != null) {
            return fastDynamicDrawable.getIntrinsicWidth();
        }
        return -1;
    }

    @Override // com.tencent.mobileqq.vas.image.AbsAsyncDrawable
    /* renamed from: isLoadSucess */
    public boolean getIsLoadSuccess() {
        return true;
    }

    @Override // c03.a
    public void restart() {
        FastDynamicDrawable fastDynamicDrawable = this.curCacheDrawable;
        if (fastDynamicDrawable != null) {
            fastDynamicDrawable.restart();
        }
    }

    @Override // c03.a
    public void setLoadedListener(@NotNull Function1<? super c03.a, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        this.loadCallback = block;
        if (this.curCacheDrawable != null) {
            block.invoke(this);
        }
    }

    @Override // c03.a
    public void stop() {
        FastDynamicDrawable fastDynamicDrawable = this.curCacheDrawable;
        if (fastDynamicDrawable != null) {
            fastDynamicDrawable.stop();
        }
    }

    @Override // c03.a
    public void destroy() {
    }
}
