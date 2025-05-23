package com.tencent.mobileqq.aio.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.t;
import com.tencent.qqnt.base.widget.RoundRectImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0013\b\u0016\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0004\b\u0012\u0010\u0013B\u001f\b\u0016\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0001\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u00a2\u0006\u0004\b\u0012\u0010\u0016B'\b\u0016\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0001\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u00a2\u0006\u0004\b\u0012\u0010\u0019J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0014J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0012\u0010\f\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/aio/widget/CommonImageView;", "Lcom/tencent/qqnt/base/widget/RoundRectImageView;", "Lcom/tencent/mobileqq/widget/t$a;", "Landroid/graphics/Canvas;", PM.CANVAS, "", "draw", "onDraw", "superDrawMosaic", "superOnDrawMosaic", "Lcom/tencent/mobileqq/widget/t;", "mosaicEffect", "setMosaicEffect", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/widget/t;", "mMosaicEffect", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class CommonImageView extends RoundRectImageView implements t.a {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private t mMosaicEffect;

    public CommonImageView(@Nullable Context context) {
        super(context, null, 0, 6, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    @Override // com.tencent.qqnt.base.widget.RoundRectImageView, android.view.View
    public void draw(@NotNull Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) canvas);
            return;
        }
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        t tVar = this.mMosaicEffect;
        if (tVar != null) {
            Intrinsics.checkNotNull(tVar);
            tVar.a(canvas);
        } else {
            super.draw(canvas);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(@NotNull Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) canvas);
            return;
        }
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        t tVar = this.mMosaicEffect;
        if (tVar != null) {
            Intrinsics.checkNotNull(tVar);
            tVar.b(canvas);
        } else {
            super.onDraw(canvas);
        }
    }

    @Override // com.tencent.mobileqq.widget.t.a
    public void setMosaicEffect(@Nullable t mosaicEffect) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) mosaicEffect);
            return;
        }
        t tVar = this.mMosaicEffect;
        if (tVar != null) {
            tVar.c(null);
        }
        this.mMosaicEffect = mosaicEffect;
        if (mosaicEffect != null) {
            mosaicEffect.c(this);
        }
        invalidate();
    }

    @Override // com.tencent.mobileqq.widget.t.a
    public void superDrawMosaic(@NotNull Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) canvas);
        } else {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            super.draw(canvas);
        }
    }

    @Override // com.tencent.mobileqq.widget.t.a
    public void superOnDrawMosaic(@NotNull Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) canvas);
        } else {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            super.onDraw(canvas);
        }
    }

    public CommonImageView(@Nullable Context context, @androidx.annotation.Nullable @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, 0, 4, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public CommonImageView(@Nullable Context context, @androidx.annotation.Nullable @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
    }
}
