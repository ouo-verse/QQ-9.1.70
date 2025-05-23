package com.tencent.mobileqq.aio.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.flashname.IFlashNickNameComponent;
import com.tencent.mobileqq.widget.t;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u00011B\u0013\b\u0016\u0012\b\u0010)\u001a\u0004\u0018\u00010(\u00a2\u0006\u0004\b*\u0010+B\u001f\b\u0016\u0012\b\u0010)\u001a\u0004\u0018\u00010(\u0012\n\b\u0001\u0010-\u001a\u0004\u0018\u00010,\u00a2\u0006\u0004\b*\u0010.B'\b\u0016\u0012\b\u0010)\u001a\u0004\u0018\u00010(\u0012\n\b\u0001\u0010-\u001a\u0004\u0018\u00010,\u0012\u0006\u0010/\u001a\u00020\u0010\u00a2\u0006\u0004\b*\u00100J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0014J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\r\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0018\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0014J\u0010\u0010\u0015\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013J0\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0010H\u0016J\b\u0010\u001e\u001a\u00020\u0006H\u0016R\u0018\u0010!\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010$\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010#R\u0016\u0010'\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/aio/widget/CommonTextView;", "Landroid/widget/TextView;", "Lcom/tencent/mobileqq/widget/t$a;", "Lx03/a;", "Landroid/graphics/Canvas;", PM.CANVAS, "", "draw", "onDraw", "superDrawMosaic", "superOnDrawMosaic", "Lcom/tencent/mobileqq/widget/t;", "mosaicEffect", "setMosaicEffect", "Landroid/view/View;", "changedView", "", "visibility", "onVisibilityChanged", "Lcom/tencent/mobileqq/aio/widget/CommonTextView$a;", "l", "setOnVisibilityChangedListener", "width", "height", "", "colorValue", "", "isSingle", "repeatCount", "e", "o", "d", "Lcom/tencent/mobileqq/widget/t;", "mMosaicEffect", "Lx03/b;", "Lx03/b;", "flashNickName", "f", "I", "textWidth", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class CommonTextView extends TextView implements t.a, x03.a {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private t mMosaicEffect;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private x03.b flashNickName;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int textWidth;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/mobileqq/aio/widget/CommonTextView$a;", "", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public interface a {
    }

    public CommonTextView(@Nullable Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    @Override // android.view.View
    public void draw(@NotNull Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) canvas);
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

    @Override // x03.a
    public void e(int width, int height, @NotNull String colorValue, boolean isSingle, int repeatCount) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Integer.valueOf(width), Integer.valueOf(height), colorValue, Boolean.valueOf(isSingle), Integer.valueOf(repeatCount));
            return;
        }
        Intrinsics.checkNotNullParameter(colorValue, "colorValue");
        this.textWidth = width;
        x03.b createFlashNickName = ((IFlashNickNameComponent) QRoute.api(IFlashNickNameComponent.class)).createFlashNickName(width, height, colorValue, isSingle, this);
        this.flashNickName = createFlashNickName;
        if (createFlashNickName != null) {
            createFlashNickName.c(repeatCount);
        }
    }

    @Override // x03.a
    public void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        x03.b bVar = this.flashNickName;
        if (bVar != null) {
            bVar.a();
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(@NotNull Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) canvas);
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
        x03.b bVar = this.flashNickName;
        if (bVar != null && !bVar.d()) {
            canvas.saveLayerAlpha(0.0f, 0.0f, this.textWidth, getHeight(), 255);
            super.onDraw(canvas);
            bVar.b(canvas);
            canvas.restore();
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onVisibilityChanged(@NotNull View changedView, int visibility) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) changedView, visibility);
        } else {
            Intrinsics.checkNotNullParameter(changedView, "changedView");
            super.onVisibilityChanged(changedView, visibility);
        }
    }

    @Override // com.tencent.mobileqq.widget.t.a
    public void setMosaicEffect(@Nullable t mosaicEffect) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) mosaicEffect);
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

    public final void setOnVisibilityChangedListener(@Nullable a l3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) l3);
        }
    }

    @Override // com.tencent.mobileqq.widget.t.a
    public void superDrawMosaic(@NotNull Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) canvas);
        } else {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            super.draw(canvas);
        }
    }

    @Override // com.tencent.mobileqq.widget.t.a
    public void superOnDrawMosaic(@NotNull Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) canvas);
        } else {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            super.onDraw(canvas);
        }
    }

    public CommonTextView(@Nullable Context context, @androidx.annotation.Nullable @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public CommonTextView(@Nullable Context context, @androidx.annotation.Nullable @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
    }
}
