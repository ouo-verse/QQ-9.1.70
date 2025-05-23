package com.tencent.mobileqq.zplan.meme.api.impl;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ams.mosaic.jsengine.animation.custom.CustomAnimation;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.utils.featureswitch.ZPlanFeatureSwitch;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 ;2\u00020\u0001:\u0001!B\u0017\u0012\u0006\u0010%\u001a\u00020 \u0012\u0006\u0010\u0010\u001a\u00020\u0002\u00a2\u0006\u0004\b9\u0010:J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J>\u0010\u0011\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0002J\u000e\u0010\u0013\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u0002J\u0006\u0010\u0014\u001a\u00020\u0006J\u0006\u0010\u0015\u001a\u00020\u0002J\u0006\u0010\u0016\u001a\u00020\u0002J\u0010\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u0010\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0002H\u0016J\b\u0010\u001c\u001a\u00020\u0002H\u0016J\u0012\u0010\u001f\u001a\u00020\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016R\u0017\u0010%\u001a\u00020 8\u0006\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0014\u0010\u0010\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R \u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020)0(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010/\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00101\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010.R\u0016\u00103\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u00102R\u0014\u00106\u001a\u0002048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u00105R\u0014\u00108\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u00107\u00a8\u0006<"}, d2 = {"Lcom/tencent/mobileqq/zplan/meme/api/impl/ApolloRepeatPngDrawable;", "Landroid/graphics/drawable/Drawable;", "", "nextIndex", "", "nextFrameTime", "", h.F, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "index", "", "pixels", "dataWidth", "dataHeight", "targetWidth", "targetHeight", "frameTime", "f", "", DomainData.DOMAIN_NAME, "o", "g", "p", "Landroid/graphics/Canvas;", PM.CANVAS, "draw", com.tencent.luggage.wxa.c8.c.f123400v, "setAlpha", "getOpacity", "Landroid/graphics/ColorFilter;", CustomAnimation.KeyPath.COLOR_FILTER, "setColorFilter", "", "a", "Ljava/lang/String;", "l", "()Ljava/lang/String;", "key", "b", "I", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mobileqq/zplan/meme/api/impl/d;", "c", "Ljava/util/concurrent/ConcurrentHashMap;", "frameDataMap", "d", "Lcom/tencent/mobileqq/zplan/meme/api/impl/d;", "currentFrame", "e", "nextFrame", "J", "lastFrameDrawTime", "Landroid/os/Handler;", "Landroid/os/Handler;", "mainHandler", "Z", "lowMemoryMode", "<init>", "(Ljava/lang/String;I)V", "i", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ApolloRepeatPngDrawable extends Drawable {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String key;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int frameTime;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final ConcurrentHashMap<Integer, FrameData> frameDataMap;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private FrameData currentFrame;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private FrameData nextFrame;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long lastFrameDrawTime;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final Handler mainHandler;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final boolean lowMemoryMode;

    public ApolloRepeatPngDrawable(String key, int i3) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.key = key;
        this.frameTime = i3;
        this.frameDataMap = new ConcurrentHashMap<>();
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.lowMemoryMode = ZPlanFeatureSwitch.f369852a.i3();
    }

    private final void h(final int nextIndex, final long nextFrameTime) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.meme.api.impl.a
            @Override // java.lang.Runnable
            public final void run() {
                ApolloRepeatPngDrawable.i(ApolloRepeatPngDrawable.this, nextIndex, nextFrameTime);
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(final ApolloRepeatPngDrawable this$0, int i3, long j3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        final FrameData frameData = this$0.frameDataMap.get(Integer.valueOf(i3));
        if ((frameData != null ? frameData.a() : null) == null) {
            QLog.w("[cmshow]ApolloRepeatPngDrawable", 1, this$0.key + " get null nextFrameBitmap for index: " + i3);
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        final Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.meme.api.impl.ApolloRepeatPngDrawable$decodeNextFrame$1$block$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                ApolloRepeatPngDrawable.this.nextFrame = frameData;
                super/*android.graphics.drawable.Drawable*/.invalidateSelf();
            }
        };
        if (uptimeMillis < j3) {
            this$0.mainHandler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.zplan.meme.api.impl.b
                @Override // java.lang.Runnable
                public final void run() {
                    ApolloRepeatPngDrawable.j(Function0.this);
                }
            }, j3 - uptimeMillis);
        } else {
            this$0.mainHandler.post(new Runnable() { // from class: com.tencent.mobileqq.zplan.meme.api.impl.c
                @Override // java.lang.Runnable
                public final void run() {
                    ApolloRepeatPngDrawable.k(Function0.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(Function0 tmp0) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(Function0 tmp0) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke();
    }

    private final int m() {
        int i3;
        FrameData frameData = this.currentFrame;
        if (frameData != null) {
            Intrinsics.checkNotNull(frameData);
            i3 = frameData.getIndex();
        } else {
            i3 = -1;
        }
        int i16 = i3 + 1;
        if (this.frameDataMap.containsKey(Integer.valueOf(i16))) {
            return i16;
        }
        if (this.lowMemoryMode) {
            return i3;
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        FrameData frameData;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        FrameData frameData2 = this.nextFrame;
        Bitmap bitmap = frameData2 != null ? frameData2.getCom.tencent.mobileqq.activity.photo.MimeHelper.IMAGE_SUBTYPE_BITMAP java.lang.String() : null;
        long uptimeMillis = SystemClock.uptimeMillis();
        if (bitmap != null && !bitmap.isRecycled()) {
            if (this.lowMemoryMode && (frameData = this.currentFrame) != null && this.nextFrame != null) {
                Intrinsics.checkNotNull(frameData);
                int index = frameData.getIndex();
                FrameData frameData3 = this.nextFrame;
                Intrinsics.checkNotNull(frameData3);
                if (index != frameData3.getIndex()) {
                    FrameData frameData4 = this.currentFrame;
                    Intrinsics.checkNotNull(frameData4);
                    frameData4.h();
                    ConcurrentHashMap<Integer, FrameData> concurrentHashMap = this.frameDataMap;
                    FrameData frameData5 = this.currentFrame;
                    Intrinsics.checkNotNull(frameData5);
                    concurrentHashMap.remove(Integer.valueOf(frameData5.getIndex()));
                    if (QLog.isColorLevel()) {
                        String str = this.key;
                        FrameData frameData6 = this.currentFrame;
                        QLog.i("[cmshow]ApolloRepeatPngDrawable", 2, this + " remove frame for " + str + " index:" + (frameData6 != null ? Integer.valueOf(frameData6.getIndex()) : null));
                    }
                }
            }
            this.currentFrame = this.nextFrame;
            this.nextFrame = null;
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
            if (this.lastFrameDrawTime > 0 && QLog.isColorLevel()) {
                QLog.i("[cmshow]ApolloRepeatPngDrawable", 2, this + " draw new frame for " + this.key + " interval " + (uptimeMillis - this.lastFrameDrawTime) + "ms");
            }
            this.lastFrameDrawTime = uptimeMillis;
        }
        h(m(), uptimeMillis + this.frameTime);
    }

    public final int g() {
        FrameData frameData = this.currentFrame;
        if (frameData == null) {
            return -1;
        }
        Intrinsics.checkNotNull(frameData);
        return frameData.getIndex();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    /* renamed from: l, reason: from getter */
    public final String getKey() {
        return this.key;
    }

    public final boolean n(int index) {
        return this.frameDataMap.containsKey(Integer.valueOf(index));
    }

    public final void o() {
        Collection<FrameData> values = this.frameDataMap.values();
        Intrinsics.checkNotNullExpressionValue(values, "frameDataMap.values");
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            ((FrameData) it.next()).h();
        }
        this.frameDataMap.clear();
        FrameData frameData = this.currentFrame;
        if (frameData != null) {
            frameData.h();
        }
        this.currentFrame = null;
        FrameData frameData2 = this.nextFrame;
        if (frameData2 != null) {
            frameData2.h();
        }
        this.nextFrame = null;
        QLog.i("[cmshow]ApolloRepeatPngDrawable", 1, this + " " + this.key + " recycle.");
    }

    public final int p() {
        return this.frameDataMap.size();
    }

    public final void f(int index, byte[] pixels, int dataWidth, int dataHeight, int targetWidth, int targetHeight, int frameTime) {
        Intrinsics.checkNotNullParameter(pixels, "pixels");
        if (this.frameDataMap.containsKey(Integer.valueOf(index))) {
            return;
        }
        ConcurrentHashMap<Integer, FrameData> concurrentHashMap = this.frameDataMap;
        Integer valueOf = Integer.valueOf(index);
        FrameData frameData = new FrameData(index, pixels, dataWidth, dataHeight, frameTime);
        frameData.k(targetWidth);
        frameData.j(targetHeight);
        concurrentHashMap.put(valueOf, frameData);
        if (QLog.isColorLevel()) {
            QLog.i("[cmshow]ApolloRepeatPngDrawable", 2, this + " add frame for " + this.key + " index:" + index);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}
