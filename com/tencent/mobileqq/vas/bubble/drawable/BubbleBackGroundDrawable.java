package com.tencent.mobileqq.vas.bubble.drawable;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.cachedrawable.dynamicdrawable.cachedrawable.AbsAsyncDrawable;
import com.tencent.cachedrawable.dynamicdrawable.cachedrawable.l;
import com.tencent.cachedrawable.dynamicdrawable.cachedrawable.m;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.vas.ar;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import f03.b;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\b\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0016R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/vas/bubble/drawable/BubbleBackGroundDrawable;", "Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/AbsAsyncDrawable;", "", "backDrawablePath", "Lf03/b;", "bubbleConfig", "", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "", HippyTKDListViewAdapter.X, "Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/m;", "callback", DomainData.DOMAIN_NAME, "Landroid/graphics/Canvas;", PM.CANVAS, "draw", "Landroid/graphics/drawable/Drawable;", "K", "Landroid/graphics/drawable/Drawable;", "mBackDrawable", "L", "Z", "mIsMirror", "isMirror", "<init>", "(Ljava/lang/String;ZLf03/b;)V", "M", "a", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class BubbleBackGroundDrawable extends AbsAsyncDrawable {
    private static final boolean N = ar.INSTANCE.b("shouyouye", "2024-07-02", "vas_fix_bubble_bg_null_2").isEnable(true);

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private volatile Drawable mBackDrawable;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean mIsMirror;

    public BubbleBackGroundDrawable(@NotNull final String backDrawablePath, boolean z16, @Nullable final b bVar) {
        Intrinsics.checkNotNullParameter(backDrawablePath, "backDrawablePath");
        this.mIsMirror = z16;
        H(new Function0() { // from class: com.tencent.mobileqq.vas.bubble.drawable.BubbleBackGroundDrawable.1
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Void invoke() {
                return null;
            }
        });
        if (N) {
            Q(backDrawablePath, bVar);
            if (this.mBackDrawable != null) {
                M(new Function0<Drawable>() { // from class: com.tencent.mobileqq.vas.bubble.drawable.BubbleBackGroundDrawable.2
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    @Nullable
                    public final Drawable invoke() {
                        return BubbleBackGroundDrawable.this.mBackDrawable;
                    }
                });
            } else {
                M(new Function0<Drawable>() { // from class: com.tencent.mobileqq.vas.bubble.drawable.BubbleBackGroundDrawable.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    @Nullable
                    public final Drawable invoke() {
                        Drawable bitmapDrawable;
                        Bitmap b16 = e03.a.f395321a.b(backDrawablePath);
                        if (b16 != null) {
                            BubbleBackGroundDrawable bubbleBackGroundDrawable = this;
                            b bVar2 = bVar;
                            if (bVar2 != null && bVar2.getNinePatchCenterX() != -1 && bVar2.getNinePatchCenterY() != -1) {
                                bitmapDrawable = new l(b16, new int[]{bVar2.getNinePatchCenterX(), bVar2.getNinePatchCenterX() + 1}, new int[]{bVar2.getNinePatchCenterY(), bVar2.getNinePatchCenterY() + 1});
                            } else if (NinePatch.isNinePatchChunk(b16.getNinePatchChunk())) {
                                bitmapDrawable = new NinePatchDrawable(b16, b16.getNinePatchChunk(), new Rect(), null);
                            } else {
                                bitmapDrawable = new BitmapDrawable(b16);
                            }
                            bubbleBackGroundDrawable.mBackDrawable = bitmapDrawable;
                        }
                        return this.mBackDrawable;
                    }
                });
            }
        } else {
            M(new Function0<Drawable>() { // from class: com.tencent.mobileqq.vas.bubble.drawable.BubbleBackGroundDrawable.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Drawable invoke() {
                    Drawable bitmapDrawable;
                    Bitmap b16 = e03.a.f395321a.b(backDrawablePath);
                    if (b16 != null) {
                        BubbleBackGroundDrawable bubbleBackGroundDrawable = this;
                        b bVar2 = bVar;
                        if (bVar2 != null && bVar2.getNinePatchCenterX() != -1 && bVar2.getNinePatchCenterY() != -1) {
                            bitmapDrawable = new l(b16, new int[]{bVar2.getNinePatchCenterX(), bVar2.getNinePatchCenterX() + 1}, new int[]{bVar2.getNinePatchCenterY(), bVar2.getNinePatchCenterY() + 1});
                        } else if (NinePatch.isNinePatchChunk(b16.getNinePatchChunk())) {
                            bitmapDrawable = new NinePatchDrawable(b16, b16.getNinePatchChunk(), new Rect(), null);
                        } else {
                            bitmapDrawable = new BitmapDrawable(b16);
                        }
                        bubbleBackGroundDrawable.mBackDrawable = bitmapDrawable;
                    }
                    return this.mBackDrawable;
                }
            });
        }
        AbsAsyncDrawable.z(this, false, 1, null);
    }

    private final void Q(String backDrawablePath, b bubbleConfig) {
        Drawable bitmapDrawable;
        Bitmap b16 = e03.a.f395321a.b(backDrawablePath);
        if (b16 != null) {
            if (bubbleConfig != null && bubbleConfig.getNinePatchCenterX() != -1 && bubbleConfig.getNinePatchCenterY() != -1) {
                bitmapDrawable = new l(b16, new int[]{bubbleConfig.getNinePatchCenterX(), bubbleConfig.getNinePatchCenterX() + 1}, new int[]{bubbleConfig.getNinePatchCenterY(), bubbleConfig.getNinePatchCenterY() + 1});
            } else if (NinePatch.isNinePatchChunk(b16.getNinePatchChunk())) {
                bitmapDrawable = new NinePatchDrawable(b16, b16.getNinePatchChunk(), new Rect(), null);
            } else {
                bitmapDrawable = new BitmapDrawable(b16);
            }
            this.mBackDrawable = bitmapDrawable;
        }
    }

    @Override // com.tencent.cachedrawable.dynamicdrawable.cachedrawable.AbsAsyncDrawable, android.graphics.drawable.Drawable
    public void draw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        int save = canvas.save();
        if (this.mBackDrawable != null) {
            float f16 = BaseApplication.getContext().getResources().getDisplayMetrics().density / 2.0f;
            canvas.scale(f16, f16);
        }
        Rect clipBounds = canvas.getClipBounds();
        Intrinsics.checkNotNullExpressionValue(clipBounds, "canvas.clipBounds");
        int save2 = canvas.save();
        if (this.mIsMirror) {
            canvas.translate(clipBounds.width(), 0.0f);
            canvas.scale(-1.0f, 1.0f);
        }
        try {
            Drawable drawable = this.mBackDrawable;
            if (drawable != null) {
                drawable.setBounds(clipBounds);
            }
            Drawable drawable2 = this.mBackDrawable;
            if (drawable2 != null) {
                drawable2.draw(canvas);
            }
        } catch (Exception e16) {
            if (QLog.isDebugVersion()) {
                QLog.e("BubbleBackGroundDrawable", 1, "draw : ", e16);
            }
        }
        canvas.restoreToCount(save2);
        canvas.restoreToCount(save);
    }

    @Override // com.tencent.cachedrawable.dynamicdrawable.cachedrawable.AbsAsyncDrawable
    public void n(@NotNull m callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
    }

    @Override // com.tencent.cachedrawable.dynamicdrawable.cachedrawable.AbsAsyncDrawable
    public boolean x() {
        return true;
    }
}
