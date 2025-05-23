package d30;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes4.dex */
public class b extends Drawable implements Drawable.Callback {

    /* renamed from: d, reason: collision with root package name */
    private Drawable f392720d;

    /* renamed from: f, reason: collision with root package name */
    private ColorFilter f392722f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f392723h;

    /* renamed from: m, reason: collision with root package name */
    private QCirclePicStateListener f392725m;

    /* renamed from: e, reason: collision with root package name */
    private int f392721e = 255;

    /* renamed from: i, reason: collision with root package name */
    private Rect f392724i = new Rect();

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a extends QCirclePicStateListener {
        a() {
        }

        @Override // com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener, com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(LoadState loadState, Option option) {
            QLog.d("QFSUrlDrawable", 1, "QFSUrlDrawable onStateChange loadState = " + loadState);
            if (loadState == LoadState.STATE_SUCCESS) {
                b.this.f392720d = new BitmapDrawable(RFWApplication.getApplication().getResources(), option.getResultBitMap());
                b.this.f392720d.setCallback(b.this);
                b.this.f392720d.setAlpha(b.this.f392721e);
                b.this.f392720d.setVisible(b.this.isVisible(), true);
                b.this.f392720d.setColorFilter(b.this.f392722f);
                b.this.f392720d.setState(b.this.getState());
                b.this.f392720d.setLevel(b.this.getLevel());
                b.this.f392720d.setBounds(b.this.f392724i);
                b.this.invalidateSelf();
                return;
            }
            if (loadState == LoadState.STATE_DOWNLOAD_FAILED || loadState == LoadState.STATE_DECODE_FAILED) {
                b.this.f392720d = option.getFailedDrawable();
                if (b.this.f392720d == null) {
                    QLog.e("QFSUrlDrawable", 1, "failedDrawable == null");
                    return;
                }
                b.this.f392720d.setCallback(b.this);
                b.this.f392720d.setAlpha(b.this.f392721e);
                b.this.f392720d.setVisible(b.this.isVisible(), true);
                b.this.f392720d.setColorFilter(b.this.f392722f);
                b.this.f392720d.setState(b.this.getState());
                b.this.f392720d.setLevel(b.this.getLevel());
                b.this.f392720d.setBounds(b.this.f392724i);
                b.this.invalidateSelf();
            }
        }
    }

    b(Option option) {
        if (option == null) {
            return;
        }
        this.f392720d = option.getLoadingDrawable();
        this.f392725m = new a();
        QCircleFeedPicLoader.g().loadImage(option, this.f392725m);
    }

    public static b f(Option option) {
        return new b(option);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Drawable drawable = this.f392720d;
        if (drawable == null) {
            return;
        }
        drawable.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.f392720d;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return super.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.f392720d;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return super.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(@NotNull Rect rect) {
        Drawable drawable = this.f392720d;
        if (drawable != null) {
            return drawable.getPadding(rect);
        }
        return super.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable drawable = this.f392720d;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.f392724i = rect;
        Drawable drawable = this.f392720d;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i3) {
        Drawable drawable = this.f392720d;
        if (drawable != null && drawable.setLevel(i3)) {
            return true;
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f392720d;
        if (drawable != null) {
            drawable.setState(iArr);
            return true;
        }
        return true;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j3) {
        scheduleSelf(runnable, j3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        if (this.f392721e == i3) {
            return;
        }
        this.f392721e = i3;
        Drawable drawable = this.f392720d;
        if (drawable == null) {
            return;
        }
        drawable.setAlpha(i3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        if (this.f392722f == colorFilter) {
            return;
        }
        this.f392722f = colorFilter;
        Drawable drawable = this.f392720d;
        if (drawable == null) {
            return;
        }
        drawable.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z16) {
        if (this.f392723h == z16) {
            return;
        }
        this.f392723h = z16;
        Drawable drawable = this.f392720d;
        if (drawable != null) {
            drawable.setDither(z16);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z16, boolean z17) {
        boolean visible = super.setVisible(z16, z17);
        Drawable drawable = this.f392720d;
        if (drawable != null) {
            drawable.setVisible(z16, z17);
        }
        return visible;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
