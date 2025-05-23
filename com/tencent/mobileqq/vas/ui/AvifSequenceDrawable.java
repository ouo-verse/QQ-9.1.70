package com.tencent.mobileqq.vas.ui;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ams.mosaic.jsengine.animation.custom.CustomAnimation;
import com.tencent.libavif.AvifDecoder;
import com.tencent.libavif.AvifImage;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.vas.ReportInfo;
import com.tencent.mobileqq.vas.report.VasCommonReporter;
import com.tencent.mobileqq.vas.ui.AbsDynamicDrawableState;
import com.tencent.mobileqq.vas.ui.AvifSequenceDrawable;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 52\u00020\u00012\u00020\u00022\u00020\u0003:\u0003567B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006B\r\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u000fH\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u000fH\u0016J\u0018\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u0013H\u0016J\u0012\u0010!\u001a\u00020\u000f2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0010\u0010$\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u0018H\u0016J\u001c\u0010&\u001a\u00020\u000f2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000f0(H\u0016J\u000e\u0010)\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020\u0013J\u000e\u0010+\u001a\u00020\u000f2\u0006\u0010,\u001a\u00020\u0013J\u0010\u0010-\u001a\u00020\u000f2\b\u0010.\u001a\u0004\u0018\u00010/J\u0018\u00100\u001a\u00020\u00182\u0006\u00101\u001a\u00020\u00182\u0006\u00102\u001a\u00020\u0018H\u0016J\b\u00103\u001a\u00020\u000fH\u0016J\b\u00104\u001a\u00020\u000fH\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/vas/ui/AvifSequenceDrawable;", "Landroid/graphics/drawable/Drawable;", "Lcom/tencent/mobileqq/vas/ui/IDynamicDrawable;", "Lcom/tencent/mobileqq/vas/ui/AbsDynamicDrawableState$Callback;", "file", "Ljava/io/File;", "(Ljava/io/File;)V", "state", "Lcom/tencent/mobileqq/vas/ui/AvifSequenceDrawable$State;", "(Lcom/tencent/mobileqq/vas/ui/AvifSequenceDrawable$State;)V", "mPaint", "Landroid/graphics/Paint;", "getState", "()Lcom/tencent/mobileqq/vas/ui/AvifSequenceDrawable$State;", "draw", "", PM.CANVAS, "Landroid/graphics/Canvas;", "getIntrinsicHeight", "", "getIntrinsicWidth", "getOpacity", "invalidateSelf", "isRunning", "", "onInvalidateSelf", "onScheduleSelf", "what", "Ljava/lang/Runnable;", RemoteMessageConst.Notification.WHEN, "", "setAlpha", com.tencent.luggage.wxa.c8.c.f123400v, "setColorFilter", CustomAnimation.KeyPath.COLOR_FILTER, "Landroid/graphics/ColorFilter;", "setFilterBitmap", "filter", "setLoadedListener", "block", "Lkotlin/Function1;", "setLoopBehavior", "loopBehavior", "setLoopCount", "loopCount", "setOnFinishedListener", "onFinishedListener", "Lcom/tencent/mobileqq/vas/ui/AvifSequenceDrawable$OnFinishedListener;", "setVisible", NodeProps.VISIBLE, "restart", "start", "stop", "Companion", "OnFinishedListener", "State", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class AvifSequenceDrawable extends Drawable implements IDynamicDrawable, AbsDynamicDrawableState.Callback {
    private static final long DEFAULT_DELAY_MS = 100;
    public static final int LOOP_DEFAULT = 3;
    public static final int LOOP_FINITE = 1;
    public static final int LOOP_INF = 2;
    private static final long MIN_DELAY_MS = 20;

    @NotNull
    private final Paint mPaint;

    @NotNull
    private final State state;

    @NotNull
    private static final AvifRenderingExecutor sExecutor = new AvifRenderingExecutor();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/vas/ui/AvifSequenceDrawable$OnFinishedListener;", "", "onFinished", "", "var1", "Lcom/tencent/mobileqq/vas/ui/AvifSequenceDrawable;", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public interface OnFinishedListener {
        void onFinished(@Nullable AvifSequenceDrawable var1);
    }

    public AvifSequenceDrawable(@NotNull State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        this.state = state;
        this.mPaint = new Paint(2);
        state.addCallBack(this);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        State state = this.state;
        Rect bounds = getBounds();
        Intrinsics.checkNotNullExpressionValue(bounds, "bounds");
        state.draw(canvas, bounds, this.mPaint);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.state.getHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.state.getWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    @NotNull
    public final State getState() {
        return this.state;
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        super.invalidateSelf();
        this.state.scheduleNextRender();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.state.isRunning();
    }

    @Override // com.tencent.mobileqq.vas.ui.AbsDynamicDrawableState.Callback
    public void onInvalidateSelf() {
        sExecutor.invalidateSelf(this);
    }

    @Override // com.tencent.mobileqq.vas.ui.AbsDynamicDrawableState.Callback
    public void onScheduleSelf(@NotNull Runnable what, long when) {
        Intrinsics.checkNotNullParameter(what, "what");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        this.mPaint.setAlpha(alpha);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean filter) {
        this.mPaint.setFilterBitmap(filter);
    }

    @Override // com.tencent.mobileqq.vas.ui.IDynamicDrawable
    public void setLoadedListener(@NotNull Function1<? super IDynamicDrawable, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    public final void setLoopBehavior(int loopBehavior) {
        this.state.setLoopCount(loopBehavior);
    }

    public final void setLoopCount(int loopCount) {
        this.state.setLoopCount(loopCount);
    }

    public final void setOnFinishedListener(@Nullable OnFinishedListener onFinishedListener) {
        this.state.setOnFinishedListener(onFinishedListener);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean visible, boolean restart) {
        boolean visible2 = super.setVisible(visible, restart);
        if (visible) {
            this.state.start();
        }
        return visible2;
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.state.start();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.state.stop();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J \u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020(2\b\u00103\u001a\u0004\u0018\u000104J\b\u00105\u001a\u00020/H\u0004J\u0012\u00106\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\b\u00107\u001a\u00020\fH\u0016J\u0006\u00108\u001a\u00020\fJ\b\u00109\u001a\u00020:H\u0016J\u0012\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010<H\u0016J\u0006\u0010=\u001a\u00020/J\u000e\u0010>\u001a\u00020/2\u0006\u0010?\u001a\u00020\u0006J\u000e\u0010@\u001a\u00020/2\u0006\u0010A\u001a\u00020\u0006J\u0010\u0010B\u001a\u00020/2\b\u0010C\u001a\u0004\u0018\u00010%J\u0006\u0010D\u001a\u00020/J\u0006\u0010E\u001a\u00020/R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u001dX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010+\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\b\"\u0004\b-\u0010\n\u00a8\u0006F"}, d2 = {"Lcom/tencent/mobileqq/vas/ui/AvifSequenceDrawable$State;", "Lcom/tencent/mobileqq/vas/ui/AbsDynamicDrawableState;", "file", "Ljava/io/File;", "(Ljava/io/File;)V", "height", "", "getHeight", "()I", "setHeight", "(I)V", "<set-?>", "", AppConstants.Key.COLUMN_IS_VALID, "()Z", "mAvifDecoder", "Lcom/tencent/libavif/AvifDecoder;", "mBitmapLock", "", "mBuffer", "Ljava/nio/MappedByteBuffer;", "mChannel", "Ljava/nio/channels/FileChannel;", "mCurrentBitmap", "Landroid/graphics/Bitmap;", "mCurrentLoop", "mDecodeTask", "Ljava/lang/Runnable;", "mIsRunning", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mLastBitmap", "mLock", "mLoopBehavior", "mLoopCount", "mNextFrameRenderTime", "", "mOnFinishedListener", "Lcom/tencent/mobileqq/vas/ui/AvifSequenceDrawable$OnFinishedListener;", "mReportSecondFrameFlag", "mSrcRect", "Landroid/graphics/Rect;", "mUnusedBitmap", "mWaitDraw", "width", "getWidth", "setWidth", "draw", "", PM.CANVAS, "Landroid/graphics/Canvas;", "bounds", "mPaint", "Landroid/graphics/Paint;", "finalize", "initDecoder", "isReusable", "isRunning", "newDrawable", "Lcom/tencent/mobileqq/vas/ui/AvifSequenceDrawable;", "res", "Landroid/content/res/Resources;", "scheduleNextRender", "setLoopBehavior", "loopBehavior", "setLoopCount", "loopCount", "setOnFinishedListener", "onFinishedListener", "start", "stop", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static final class State extends AbsDynamicDrawableState {
        private int height;
        private boolean isValid;

        @Nullable
        private AvifDecoder mAvifDecoder;

        @NotNull
        private final Object mBitmapLock;

        @Nullable
        private MappedByteBuffer mBuffer;

        @Nullable
        private FileChannel mChannel;

        @Nullable
        private Bitmap mCurrentBitmap;
        private int mCurrentLoop;

        @NotNull
        private final Runnable mDecodeTask;

        @NotNull
        private final AtomicBoolean mIsRunning;

        @Nullable
        private Bitmap mLastBitmap;

        @NotNull
        private final Object mLock;
        private int mLoopBehavior;
        private int mLoopCount;
        private long mNextFrameRenderTime;

        @Nullable
        private OnFinishedListener mOnFinishedListener;
        private boolean mReportSecondFrameFlag;

        @NotNull
        private final Rect mSrcRect;

        @Nullable
        private Bitmap mUnusedBitmap;

        @NotNull
        private final AtomicBoolean mWaitDraw;
        private int width;

        public State(@NotNull File file) {
            Intrinsics.checkNotNullParameter(file, "file");
            this.mNextFrameRenderTime = Long.MIN_VALUE;
            this.mIsRunning = new AtomicBoolean(false);
            this.mSrcRect = new Rect(0, 0, 0, 0);
            this.mLock = new Object();
            this.mBitmapLock = new Object();
            this.mLoopBehavior = 3;
            this.mLoopCount = 1;
            this.mWaitDraw = new AtomicBoolean(true);
            this.mReportSecondFrameFlag = true;
            this.mDecodeTask = new Runnable() { // from class: com.tencent.mobileqq.vas.ui.b
                @Override // java.lang.Runnable
                public final void run() {
                    AvifSequenceDrawable.State.mDecodeTask$lambda$2(AvifSequenceDrawable.State.this);
                }
            };
            long uptimeMillis = SystemClock.uptimeMillis();
            AvifDecoder initDecoder = initDecoder(file);
            if (initDecoder != null) {
                this.mAvifDecoder = initDecoder;
                try {
                    initDecoder.n();
                    this.isValid = true;
                } catch (Throwable th5) {
                    ReportInfo.report$default(VasCommonReporter.getAvif().setValue1("decoder").setValue2("next-error").setValue3(th5.getMessage()), false, 1, null);
                }
                AvifImage g16 = initDecoder.g();
                Intrinsics.checkNotNullExpressionValue(g16, "decoder.image");
                this.width = g16.h();
                int g17 = g16.g();
                this.height = g17;
                Rect rect = this.mSrcRect;
                rect.right = this.width;
                rect.bottom = g17;
                this.mCurrentBitmap = g16.d(true);
                ReportInfo.report$default(VasCommonReporter.getAvif().setValue1("decoder").setValue2("first-frame").setNum1(this.width).setNum2(this.width).setNum3(SystemClock.uptimeMillis() - uptimeMillis), false, 1, null);
                return;
            }
            this.isValid = false;
        }

        private final AvifDecoder initDecoder(File file) {
            MappedByteBuffer map;
            String encode = URLEncoder.encode(file.getAbsolutePath());
            Intrinsics.checkNotNullExpressionValue(encode, "encode(file.absolutePath)");
            try {
                FileChannel channel = new FileInputStream(file).getChannel();
                this.mChannel = channel;
                if (channel != null) {
                    try {
                        map = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size());
                    } catch (Exception unused) {
                        ReportInfo.report$default(VasCommonReporter.getAvif().setValue1("decoder").setValue2("buffer-error").setValue3(encode), false, 1, null);
                        return null;
                    }
                } else {
                    map = null;
                }
                this.mBuffer = map;
                try {
                    AvifDecoder e16 = AvifDecoder.e(map);
                    if (e16 == null) {
                        ReportInfo.report$default(VasCommonReporter.getAvif().setValue1("decoder").setValue2("decoder-is-null").setValue3(encode), false, 1, null);
                        return null;
                    }
                    ReportInfo.report$default(VasCommonReporter.getAvif().setValue1("decoder").setValue2("success").setValue3(encode), false, 1, null);
                    return e16;
                } catch (Throwable th5) {
                    ReportInfo.report$default(VasCommonReporter.getAvif().setValue1("decoder").setValue2("create-error").setValue3(th5.getMessage()), false, 1, null);
                    return null;
                }
            } catch (Exception unused2) {
                ReportInfo.report$default(VasCommonReporter.getAvif().setValue1("decoder").setValue2("file-error").setValue3(encode), false, 1, null);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00f0  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x010d  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x011e A[Catch: all -> 0x014a, TryCatch #4 {, blocks: (B:4:0x0009, B:7:0x0036, B:33:0x00f2, B:36:0x0111, B:38:0x011e, B:40:0x0127, B:42:0x012b, B:43:0x0136, B:44:0x0143, B:45:0x0110, B:51:0x00cb, B:57:0x007a, B:59:0x0146, B:10:0x003d, B:13:0x0046, B:15:0x004a), top: B:3:0x0009, inners: #3 }] */
        /* JADX WARN: Removed duplicated region for block: B:45:0x0110 A[Catch: all -> 0x014a, TryCatch #4 {, blocks: (B:4:0x0009, B:7:0x0036, B:33:0x00f2, B:36:0x0111, B:38:0x011e, B:40:0x0127, B:42:0x012b, B:43:0x0136, B:44:0x0143, B:45:0x0110, B:51:0x00cb, B:57:0x007a, B:59:0x0146, B:10:0x003d, B:13:0x0046, B:15:0x004a), top: B:3:0x0009, inners: #3 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static final void mDecodeTask$lambda$2(State this$0) {
            boolean z16;
            long j3;
            long j16;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            synchronized (this$0.mLock) {
                AvifSequenceDrawable.sExecutor.logI("decode: start mIsRunning[" + this$0.mIsRunning + "]");
                AvifDecoder avifDecoder = this$0.mAvifDecoder;
                if (this$0.mIsRunning.get() && avifDecoder != null) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    boolean z17 = false;
                    try {
                        if (avifDecoder.n() == 0) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (this$0.mReportSecondFrameFlag) {
                            ReportInfo.report$default(VasCommonReporter.getAvif().setValue1("decoder").setValue2("second-frame").setNum1(this$0.width).setNum2(this$0.height).setNum3(SystemClock.uptimeMillis() - uptimeMillis), false, 1, null);
                            this$0.mReportSecondFrameFlag = false;
                        }
                    } catch (Throwable th5) {
                        ReportInfo.report$default(VasCommonReporter.getAvif().setValue1("decoder").setValue2("next-error").setValue3(th5.getMessage()), false, 1, null);
                        z16 = false;
                    }
                    if (z16) {
                        try {
                            j3 = avifDecoder.i();
                        } catch (Throwable th6) {
                            th = th6;
                            j3 = 0;
                        }
                        try {
                            this$0.mCurrentBitmap = avifDecoder.g().d(true);
                            this$0.mWaitDraw.set(true);
                            this$0.mUnusedBitmap = this$0.mLastBitmap;
                            this$0.mLastBitmap = this$0.mCurrentBitmap;
                            synchronized (this$0.mBitmapLock) {
                                Bitmap bitmap = this$0.mUnusedBitmap;
                                if (bitmap != null) {
                                    bitmap.recycle();
                                    Unit unit = Unit.INSTANCE;
                                }
                            }
                        } catch (Throwable th7) {
                            th = th7;
                            AvifRenderingExecutor.logE$default(AvifSequenceDrawable.sExecutor, "exception during decode " + th.getMessage(), null, 2, null);
                            z17 = true;
                            if (j3 < 20) {
                            }
                            AvifSequenceDrawable.sExecutor.logI("decode: invalidateTimeMs=" + j3);
                            if (!z17) {
                            }
                            this$0.mNextFrameRenderTime = j16;
                            if (avifDecoder.j() >= avifDecoder.h() - 1) {
                            }
                            this$0.invalidateSelf();
                            Unit unit2 = Unit.INSTANCE;
                        }
                        if (j3 < 20) {
                            j3 = 100;
                        }
                        AvifSequenceDrawable.sExecutor.logI("decode: invalidateTimeMs=" + j3);
                        if (!z17) {
                            j16 = Long.MIN_VALUE;
                        } else {
                            j16 = uptimeMillis + j3;
                        }
                        this$0.mNextFrameRenderTime = j16;
                        if (avifDecoder.j() >= avifDecoder.h() - 1) {
                            int i3 = this$0.mCurrentLoop + 1;
                            this$0.mCurrentLoop = i3;
                            if (this$0.mLoopBehavior == 1 && i3 == this$0.mLoopCount) {
                                AvifSequenceDrawable.sExecutor.logI("schedule: finishrunnable");
                            } else {
                                AvifSequenceDrawable.sExecutor.logI("decode: reset");
                                avifDecoder.p();
                            }
                        }
                        this$0.invalidateSelf();
                    }
                }
                Unit unit22 = Unit.INSTANCE;
            }
        }

        public final void draw(@NotNull Canvas canvas, @NotNull Rect bounds, @Nullable Paint mPaint) {
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

        protected final void finalize() {
            try {
                FileChannel fileChannel = this.mChannel;
                if (fileChannel != null) {
                    fileChannel.close();
                }
                AvifDecoder avifDecoder = this.mAvifDecoder;
                if (avifDecoder != null) {
                    avifDecoder.b();
                }
                MappedByteBuffer mappedByteBuffer = this.mBuffer;
                if (mappedByteBuffer != null) {
                    mappedByteBuffer.clear();
                }
            } catch (Exception e16) {
                AvifSequenceDrawable.sExecutor.logE("finalize", e16);
            }
        }

        public final int getHeight() {
            return this.height;
        }

        public final int getWidth() {
            return this.width;
        }

        @Override // com.tencent.mobileqq.vas.ui.AbsDynamicDrawableState
        /* renamed from: isReusable, reason: from getter */
        public boolean getIsValid() {
            return this.isValid;
        }

        public final boolean isRunning() {
            return this.mIsRunning.get();
        }

        public final boolean isValid() {
            return this.isValid;
        }

        public final void scheduleNextRender() {
            if (!this.mWaitDraw.get() && isRunning() && this.mNextFrameRenderTime != Long.MIN_VALUE) {
                AvifSequenceDrawable.sExecutor.logI("schedule: next");
                long max = Math.max(0L, this.mNextFrameRenderTime - SystemClock.uptimeMillis());
                this.mNextFrameRenderTime = Long.MIN_VALUE;
                AvifSequenceDrawable.sExecutor.removeTask(this.mDecodeTask);
                AvifSequenceDrawable.sExecutor.postTaskDelay(this.mDecodeTask, max);
            }
        }

        public final void setHeight(int i3) {
            this.height = i3;
        }

        public final void setLoopBehavior(int loopBehavior) {
            this.mLoopBehavior = loopBehavior;
        }

        public final void setLoopCount(int loopCount) {
            this.mLoopCount = loopCount;
        }

        public final void setOnFinishedListener(@Nullable OnFinishedListener onFinishedListener) {
            this.mOnFinishedListener = onFinishedListener;
        }

        public final void setWidth(int i3) {
            this.width = i3;
        }

        public final void start() {
            if (!this.mIsRunning.compareAndSet(false, true)) {
                return;
            }
            this.mNextFrameRenderTime = SystemClock.uptimeMillis();
            this.mCurrentLoop = 0;
            scheduleNextRender();
        }

        public final void stop() {
            if (!this.mIsRunning.compareAndSet(true, false)) {
                return;
            }
            AvifSequenceDrawable.sExecutor.removeTask(this.mDecodeTask);
            this.mCurrentLoop = 0;
            AvifDecoder avifDecoder = this.mAvifDecoder;
            if (avifDecoder != null) {
                avifDecoder.p();
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NotNull
        public AvifSequenceDrawable newDrawable() {
            return new AvifSequenceDrawable(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NotNull
        public AvifSequenceDrawable newDrawable(@Nullable Resources res) {
            return new AvifSequenceDrawable(this);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AvifSequenceDrawable(@NotNull File file) {
        this(new State(file));
        Intrinsics.checkNotNullParameter(file, "file");
    }
}
