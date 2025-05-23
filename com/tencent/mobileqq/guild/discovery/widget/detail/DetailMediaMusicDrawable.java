package com.tencent.mobileqq.guild.discovery.widget.detail;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.media.ThumbnailUtils;
import android.util.Log;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ams.mosaic.jsengine.animation.custom.CustomAnimation;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.guild.picload.e;
import com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener;
import com.tencent.mobileqq.guild.util.GuildBannerPalette;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.v;
import com.tencent.qphone.base.util.QLog;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt___StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 $2\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\"\u0010#J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0012\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0010\u001a\u00020\nH\u0016R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001d\u001a\u00020\u00198BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001a\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u001eR\u0016\u0010!\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010 \u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/guild/discovery/widget/detail/DetailMediaMusicDrawable;", "Landroid/graphics/drawable/Drawable;", "", "d", "", "coverUrl", "e", "Landroid/graphics/Canvas;", PM.CANVAS, "draw", "", c.f123400v, "setAlpha", "Landroid/graphics/ColorFilter;", CustomAnimation.KeyPath.COLOR_FILTER, "setColorFilter", "getOpacity", "Landroid/graphics/Paint;", "a", "Landroid/graphics/Paint;", "mPaint", "Landroid/graphics/Bitmap;", "b", "Landroid/graphics/Bitmap;", "mCoverBitmap", "Landroid/graphics/LinearGradient;", "c", "Lkotlin/Lazy;", "()Landroid/graphics/LinearGradient;", "mGrayGradient", "Landroid/graphics/LinearGradient;", "mCoverGradient", "Ljava/lang/String;", "mCoverUrl", "<init>", "()V", "f", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class DetailMediaMusicDrawable extends Drawable {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Paint mPaint;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Bitmap mCoverBitmap;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mGrayGradient;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private LinearGradient mCoverGradient;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mCoverUrl;

    public DetailMediaMusicDrawable() {
        Lazy lazy;
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        this.mPaint = paint;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<LinearGradient>() { // from class: com.tencent.mobileqq.guild.discovery.widget.detail.DetailMediaMusicDrawable$mGrayGradient$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final LinearGradient invoke() {
                return new LinearGradient(DetailMediaMusicDrawable.this.getBounds().right, 0.0f, 0.0f, DetailMediaMusicDrawable.this.getBounds().bottom, new int[]{Color.parseColor("#00000000"), Color.parseColor("#40000000")}, (float[]) null, Shader.TileMode.CLAMP);
            }
        });
        this.mGrayGradient = lazy;
        this.mCoverGradient = new LinearGradient(getBounds().right, 0.0f, getBounds().right - (getBounds().bottom / ((float) Math.tan(65.68d))), getBounds().bottom, new int[]{Color.parseColor("#00000000"), Color.parseColor("#00000000")}, (float[]) null, Shader.TileMode.CLAMP);
        this.mCoverUrl = "";
    }

    private final LinearGradient c() {
        return (LinearGradient) this.mGrayGradient.getValue();
    }

    private final void d() {
        this.mCoverBitmap = null;
        this.mCoverGradient = new LinearGradient(getBounds().right, 0.0f, getBounds().right - (getBounds().bottom / ((float) Math.tan(65.68d))), getBounds().bottom, new int[]{Color.parseColor("#00000000"), Color.parseColor("#00000000")}, (float[]) null, Shader.TileMode.CLAMP);
        dh1.a aVar = dh1.a.f393835a;
        Option b16 = v.b(this.mCoverUrl, true, Integer.valueOf(aVar.e()), Integer.valueOf(aVar.d()));
        b16.setNeedFilterUrl(false);
        e.a().f(b16, new GuildPicStateListener() { // from class: com.tencent.mobileqq.guild.discovery.widget.detail.DetailMediaMusicDrawable$loadCover$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(true);
            }

            @Override // com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener
            public void c(@NotNull LoadState state, @NotNull Option option) {
                Intrinsics.checkNotNullParameter(state, "state");
                Intrinsics.checkNotNullParameter(option, "option");
                Logger logger = Logger.f235387a;
                if (QLog.isColorLevel()) {
                    logger.d().d("DetailMediaMusicDrawable", 2, "load image state:" + state + ", url:" + option.getUrl() + ", loadType:" + option.mLoadType);
                }
                if (state == LoadState.STATE_SUCCESS) {
                    DetailMediaMusicDrawable.this.mCoverBitmap = option.getResultBitMap();
                    Bitmap resultBitMap = option.getResultBitMap();
                    final DetailMediaMusicDrawable detailMediaMusicDrawable = DetailMediaMusicDrawable.this;
                    GuildBannerPalette.g(resultBitMap, new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.guild.discovery.widget.detail.DetailMediaMusicDrawable$loadCover$1$onStateChangeCallback$2
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                            invoke(num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(int i3) {
                            String takeLast;
                            String hexString = Integer.toHexString(i3);
                            Intrinsics.checkNotNullExpressionValue(hexString, "toHexString(color)");
                            takeLast = StringsKt___StringsKt.takeLast(hexString, 6);
                            Logger logger2 = Logger.f235387a;
                            if (QLog.isColorLevel()) {
                                logger2.d().d("DetailMediaMusicDrawable", 2, "obtainColorAsync | colorStr " + takeLast);
                            }
                            DetailMediaMusicDrawable.this.mCoverGradient = new LinearGradient(DetailMediaMusicDrawable.this.getBounds().right, 0.0f, DetailMediaMusicDrawable.this.getBounds().right - (DetailMediaMusicDrawable.this.getBounds().bottom / ((float) Math.tan(Math.toRadians(65.68d)))), DetailMediaMusicDrawable.this.getBounds().bottom, new int[]{Color.parseColor("#00" + takeLast), Color.parseColor("#F2" + takeLast)}, (float[]) null, Shader.TileMode.CLAMP);
                            DetailMediaMusicDrawable.this.invalidateSelf();
                        }
                    });
                }
            }
        });
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NotNull Canvas canvas) {
        boolean z16;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        this.mPaint.setShader(null);
        if (this.mCoverBitmap == null) {
            if (this.mCoverUrl.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                d();
            }
        } else {
            int width = getBounds().width();
            Bitmap bitmap = this.mCoverBitmap;
            Intrinsics.checkNotNull(bitmap);
            if (width != bitmap.getWidth()) {
                Logger logger = Logger.f235387a;
                if (QLog.isDevelopLevel()) {
                    Log.d("DetailMediaMusicDrawable", "bounds.width() != mBitmaps!!.width");
                }
                Bitmap bitmap2 = this.mCoverBitmap;
                Intrinsics.checkNotNull(bitmap2);
                this.mCoverBitmap = ThumbnailUtils.extractThumbnail(bitmap2, getBounds().width(), getBounds().height());
            }
            Bitmap bitmap3 = this.mCoverBitmap;
            Intrinsics.checkNotNull(bitmap3);
            canvas.drawBitmap(bitmap3, 0.0f, 0.0f, this.mPaint);
        }
        this.mPaint.setShader(this.mCoverGradient);
        canvas.drawRect(0.0f, 0.0f, getBounds().right, getBounds().bottom, this.mPaint);
        this.mPaint.setShader(c());
        canvas.drawRect(0.0f, 0.0f, getBounds().right, getBounds().bottom, this.mPaint);
    }

    public final void e(@Nullable String coverUrl) {
        boolean z16;
        if (!Intrinsics.areEqual(this.mCoverUrl, coverUrl)) {
            if (coverUrl != null && coverUrl.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                this.mCoverUrl = coverUrl;
                if (getBounds().width() != 0 && getBounds().height() != 0) {
                    d();
                }
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        this.mPaint.setAlpha(alpha);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }
}
