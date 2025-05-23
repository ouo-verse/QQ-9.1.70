package com.tencent.mobileqq.vas.liangnum;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.mobileqq.app.AppConstants;
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

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B;\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u000f\u0012\u0006\u0010\u0011\u001a\u00020\n\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0014\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/vas/liangnum/XuanCaiLiangNumDrawable;", "Lcom/tencent/mobileqq/vas/liangnum/AbsLiangNumDrawable;", "Lkotlin/Pair;", "", "O", "", "b0", "Landroid/graphics/drawable/Drawable;", "N", "id", "", "uin", "viewHeight", "Landroid/view/View;", "targetView", "Lcom/tencent/mobileqq/vas/updatesystem/business/QQVasUpdateBusiness;", "business", "scene", "<init>", "(ILjava/lang/String;ILandroid/view/View;Lcom/tencent/mobileqq/vas/updatesystem/business/QQVasUpdateBusiness;Ljava/lang/String;)V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "a", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class XuanCaiLiangNumDrawable extends AbsLiangNumDrawable {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/vas/liangnum/XuanCaiLiangNumDrawable$b", "Lcom/tencent/mobileqq/vas/liangnum/AbsLiangNumDrawable$c;", "Landroid/graphics/Canvas;", PM.CANVAS, "Landroid/graphics/Rect;", "b", "c", "Lcom/tencent/mobileqq/vas/liangnum/AbsLiangNumDrawable$c$a;", "d", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class b extends AbsLiangNumDrawable.c {
        b(Drawable drawable, Drawable[] drawableArr, Drawable drawable2) {
            super(drawable, drawableArr, drawable2);
        }

        @Override // com.tencent.mobileqq.vas.liangnum.AbsLiangNumDrawable.c
        @NotNull
        public Rect b(@NotNull Canvas canvas) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            return new Rect((int) (((canvas.getHeight() * 1.0f) / XuanCaiLiangNumDrawable.this.getIconH()) * XuanCaiLiangNumDrawable.this.getIconW()), 0, canvas.getWidth(), canvas.getHeight());
        }

        @Override // com.tencent.mobileqq.vas.liangnum.AbsLiangNumDrawable.c
        @NotNull
        public Rect c(@NotNull Canvas canvas) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            return new Rect(0, 0, (int) (((canvas.getHeight() * 1.0f) / XuanCaiLiangNumDrawable.this.getIconH()) * XuanCaiLiangNumDrawable.this.getIconW()), canvas.getHeight());
        }

        @Override // com.tencent.mobileqq.vas.liangnum.AbsLiangNumDrawable.c
        @NotNull
        public AbsLiangNumDrawable.c.NumInfo d() {
            float viewHeight = (XuanCaiLiangNumDrawable.this.getViewHeight() / 120.0f) * 114;
            float f16 = viewHeight / 2;
            return new AbsLiangNumDrawable.c.NumInfo(f16, viewHeight, (f16 / 7.0f) * 0.3f, 0.0f, (((XuanCaiLiangNumDrawable.this.getViewHeight() * 1.0f) / XuanCaiLiangNumDrawable.this.getIconH()) * XuanCaiLiangNumDrawable.this.getIconW()) + (XuanCaiLiangNumDrawable.this.b0() * 1.5f));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public XuanCaiLiangNumDrawable(int i3, @NotNull String uin, int i16, @NotNull View targetView, @NotNull QQVasUpdateBusiness<?> business, @NotNull String scene) {
        super(i3, uin, i16, business, targetView, scene);
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(targetView, "targetView");
        Intrinsics.checkNotNullParameter(business, "business");
        Intrinsics.checkNotNullParameter(scene, "scene");
    }

    @Override // com.tencent.mobileqq.vas.liangnum.AbsLiangNumDrawable
    @NotNull
    public Drawable N() {
        Drawable bgImg = getBgImg();
        Intrinsics.checkNotNull(bgImg);
        b bVar = new b(bgImg, M(), getFgImg());
        postUITask(new Function0<Unit>() { // from class: com.tencent.mobileqq.vas.liangnum.XuanCaiLiangNumDrawable$getTargetDrawable$2$1
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
                Function1<AbsLiangNumDrawable, Unit> loadCallback = XuanCaiLiangNumDrawable.this.getLoadCallback();
                if (loadCallback != null) {
                    loadCallback.invoke(XuanCaiLiangNumDrawable.this);
                }
            }
        });
        return bVar;
    }

    @Override // com.tencent.mobileqq.vas.liangnum.AbsLiangNumDrawable
    @NotNull
    public Pair<Integer, Integer> O() {
        return TuplesKt.to(Integer.valueOf((int) (b0() * ((getUin().length() * 7) + 23 + ((getUin().length() - 1) * 0.3d)))), Integer.valueOf(getViewHeight()));
    }

    public float b0() {
        return getViewHeight() / 15.0f;
    }
}
