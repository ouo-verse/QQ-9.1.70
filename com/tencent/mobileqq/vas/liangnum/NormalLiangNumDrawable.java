package com.tencent.mobileqq.vas.liangnum;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.vas.liangnum.AbsLiangNumDrawable;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 #2\u00020\u0001:\u0001$B;\u0012\u0006\u0010\u0018\u001a\u00020\u0004\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\u001b\u001a\u00020\u0004\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\n\u0010\u001f\u001a\u0006\u0012\u0002\b\u00030\u001e\u0012\u0006\u0010 \u001a\u00020\u0019\u00a2\u0006\u0004\b!\u0010\"J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0014\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000bH\u0016J\b\u0010\r\u001a\u00020\u0006H\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/vas/liangnum/NormalLiangNumDrawable;", "Lcom/tencent/mobileqq/vas/liangnum/AbsLiangNumDrawable;", "Landroid/graphics/Canvas;", PM.CANVAS, "", "pointW", "", "c0", "", "U", "draw", "Lkotlin/Pair;", "O", "b0", "Landroid/graphics/drawable/Drawable;", "N", "Landroid/graphics/Bitmap;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/graphics/Bitmap;", "pointBitmap", "Landroid/graphics/Paint;", BdhLogUtil.LogTag.Tag_Req, "Landroid/graphics/Paint;", "paint", "id", "", "uin", "viewHeight", "Landroid/view/View;", "targetView", "Lcom/tencent/mobileqq/vas/updatesystem/business/QQVasUpdateBusiness;", "business", "scene", "<init>", "(ILjava/lang/String;ILandroid/view/View;Lcom/tencent/mobileqq/vas/updatesystem/business/QQVasUpdateBusiness;Ljava/lang/String;)V", ExifInterface.LATITUDE_SOUTH, "a", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class NormalLiangNumDrawable extends AbsLiangNumDrawable {

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private Bitmap pointBitmap;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final Paint paint;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/vas/liangnum/NormalLiangNumDrawable$b", "Lcom/tencent/mobileqq/vas/liangnum/AbsLiangNumDrawable$c;", "Landroid/graphics/Canvas;", PM.CANVAS, "Landroid/graphics/Rect;", "b", "c", "Lcom/tencent/mobileqq/vas/liangnum/AbsLiangNumDrawable$c$a;", "d", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class b extends AbsLiangNumDrawable.c {
        b(Drawable drawable, Drawable[] drawableArr, Drawable drawable2) {
            super(drawable, drawableArr, drawable2);
        }

        @Override // com.tencent.mobileqq.vas.liangnum.AbsLiangNumDrawable.c
        @NotNull
        public Rect b(@NotNull Canvas canvas) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            return new Rect(0, 0, canvas.getWidth(), canvas.getHeight());
        }

        @Override // com.tencent.mobileqq.vas.liangnum.AbsLiangNumDrawable.c
        @NotNull
        public Rect c(@NotNull Canvas canvas) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            float b06 = NormalLiangNumDrawable.this.b0() * 5;
            return new Rect((int) b06, 0, (int) (b06 + (((canvas.getHeight() * 1.0f) / NormalLiangNumDrawable.this.getIconH()) * NormalLiangNumDrawable.this.getIconW())), canvas.getHeight());
        }

        @Override // com.tencent.mobileqq.vas.liangnum.AbsLiangNumDrawable.c
        @NotNull
        public AbsLiangNumDrawable.c.NumInfo d() {
            return new AbsLiangNumDrawable.c.NumInfo((NormalLiangNumDrawable.this.getViewHeight() - NormalLiangNumDrawable.this.b0()) / 2.0f, NormalLiangNumDrawable.this.getViewHeight(), 0.0f, NormalLiangNumDrawable.this.b0(), (((NormalLiangNumDrawable.this.getViewHeight() * 1.0f) / NormalLiangNumDrawable.this.getIconH()) * NormalLiangNumDrawable.this.getIconW()) + (NormalLiangNumDrawable.this.b0() * 12));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NormalLiangNumDrawable(int i3, @NotNull String uin, int i16, @NotNull View targetView, @NotNull QQVasUpdateBusiness<?> business, @NotNull String scene) {
        super(i3, uin, i16, business, targetView, scene);
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(targetView, "targetView");
        Intrinsics.checkNotNullParameter(business, "business");
        Intrinsics.checkNotNullParameter(scene, "scene");
        this.paint = new Paint();
    }

    private final float c0(Canvas canvas, int pointW) {
        return (((canvas.getHeight() * 1.0f) / getIconH()) * getIconW()) + (b0() * 5) + (((b0() * 7) - pointW) / 2);
    }

    @Override // com.tencent.mobileqq.vas.liangnum.AbsLiangNumDrawable
    @NotNull
    public Drawable N() {
        Drawable bgImg = getBgImg();
        Intrinsics.checkNotNull(bgImg);
        b bVar = new b(bgImg, M(), getFgImg());
        postUITask(new Function0<Unit>() { // from class: com.tencent.mobileqq.vas.liangnum.NormalLiangNumDrawable$getTargetDrawable$2$1
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
                Function1<AbsLiangNumDrawable, Unit> loadCallback = NormalLiangNumDrawable.this.getLoadCallback();
                if (loadCallback != null) {
                    loadCallback.invoke(NormalLiangNumDrawable.this);
                }
            }
        });
        return bVar;
    }

    @Override // com.tencent.mobileqq.vas.liangnum.AbsLiangNumDrawable
    @NotNull
    public Pair<Integer, Integer> O() {
        return TuplesKt.to(Integer.valueOf((int) ((b0() * ((getUin().length() * 6) + 17)) + (((getViewHeight() * 1.0f) / getIconH()) * getIconW()))), Integer.valueOf(getViewHeight()));
    }

    @Override // com.tencent.mobileqq.vas.liangnum.AbsLiangNumDrawable
    public void U() {
        this.pointBitmap = BitmapFactory.decodeFile(J() + "/point.png");
        super.U();
    }

    public float b0() {
        return getViewHeight() / 13.0f;
    }

    @Override // com.tencent.mobileqq.vas.image.AbsAsyncDrawable, android.graphics.drawable.Drawable
    public void draw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.draw(canvas);
        Bitmap bitmap = this.pointBitmap;
        if (bitmap == null) {
            return;
        }
        canvas.save();
        canvas.drawBitmap(bitmap, c0(canvas, bitmap.getWidth()), (canvas.getHeight() - bitmap.getHeight()) / 2.0f, this.paint);
        canvas.restore();
    }
}
