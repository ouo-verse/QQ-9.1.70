package com.tencent.robot.aio.story;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.RenderEffect;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001f2\u00020\u0001:\u0001 B\u0011\b\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001a\u0010\u001bB\u001b\b\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u00a2\u0006\u0004\b\u001a\u0010\u001eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR*\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00028\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006!"}, d2 = {"Lcom/tencent/robot/aio/story/StoryBlurBgView;", "Landroidx/appcompat/widget/AppCompatImageView;", "", "radius", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/graphics/drawable/Drawable;", "drawable", "setImageDrawable", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/graphics/drawable/Drawable;", "mOriginDrawable", "", BdhLogUtil.LogTag.Tag_Conn, "Z", "mBlurRunning", "value", "D", "I", "p", "()I", "setBlurRadius", "(I)V", "blurRadius", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "E", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class StoryBlurBgView extends AppCompatImageView {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean mBlurRunning;

    /* renamed from: D, reason: from kotlin metadata */
    private int blurRadius;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Drawable mOriginDrawable;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoryBlurBgView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(final int radius) {
        URLDrawable uRLDrawable;
        Bitmap bitmap = null;
        RenderEffect renderEffect = null;
        if (Build.VERSION.SDK_INT >= 31) {
            if (radius > 0) {
                float f16 = radius;
                renderEffect = RenderEffect.createBlurEffect(f16, f16, Shader.TileMode.CLAMP);
            }
            setRenderEffect(renderEffect);
            return;
        }
        if (this.mBlurRunning) {
            QLog.d("StoryBlurBgView", 1, "blur is running");
            return;
        }
        Drawable drawable = this.mOriginDrawable;
        if (drawable instanceof URLDrawable) {
            uRLDrawable = (URLDrawable) drawable;
        } else {
            uRLDrawable = null;
        }
        if (uRLDrawable != null) {
            bitmap = com.tencent.mobileqq.opr.helper.a.b(uRLDrawable);
        }
        if (bitmap == null) {
            QLog.e("StoryBlurBgView", 1, "bitmap is null");
            return;
        }
        this.mBlurRunning = true;
        final long currentTimeMillis = System.currentTimeMillis();
        u64.g.f438512a.c(bitmap, radius, new Function1<Bitmap, Unit>() { // from class: com.tencent.robot.aio.story.StoryBlurBgView$invalidateBlur$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Bitmap bitmap2) {
                invoke2(bitmap2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Bitmap it) {
                Intrinsics.checkNotNullParameter(it, "it");
                StoryBlurBgView.this.mBlurRunning = false;
                super/*androidx.appcompat.widget.AppCompatImageView*/.setImageDrawable(new BitmapDrawable(StoryBlurBgView.this.getResources(), it));
                QLog.d("StoryBlurBgView", 4, "blur cost " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
                if (StoryBlurBgView.this.getBlurRadius() != radius) {
                    QLog.d("StoryBlurBgView", 1, "radius changed, invalidate");
                    StoryBlurBgView storyBlurBgView = StoryBlurBgView.this;
                    storyBlurBgView.q(storyBlurBgView.getBlurRadius());
                }
            }
        });
    }

    /* renamed from: p, reason: from getter */
    public final int getBlurRadius() {
        return this.blurRadius;
    }

    public final void setBlurRadius(int i3) {
        if (this.blurRadius == i3) {
            return;
        }
        this.blurRadius = i3;
        q(i3);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(@Nullable Drawable drawable) {
        this.mOriginDrawable = drawable;
        super.setImageDrawable(drawable);
        int i3 = this.blurRadius;
        if (i3 > 0) {
            q(i3);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoryBlurBgView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
