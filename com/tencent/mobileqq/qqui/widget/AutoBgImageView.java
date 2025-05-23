package com.tencent.mobileqq.qqui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b\u000b\u0010\fB\u001d\b\u0016\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0004\b\u000b\u0010\u000fB%\b\u0016\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0004\b\u000b\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/qqui/widget/AutoBgImageView;", "Landroid/widget/ImageView;", "", "drawableStateChanged", "", LayoutAttrDefine.PRESSED_ALPHA, "setPressedAlpha", "d", UserInfo.SEX_FEMALE, "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class AutoBgImageView extends ImageView {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private float pressedAlpha;

    public AutoBgImageView(@Nullable Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.pressedAlpha = 0.5f;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        float f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.drawableStateChanged();
        if (isPressed()) {
            f16 = this.pressedAlpha;
        } else {
            f16 = 1.0f;
        }
        setAlpha(f16);
        postInvalidate();
    }

    public final void setPressedAlpha(float pressedAlpha) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Float.valueOf(pressedAlpha));
        } else {
            this.pressedAlpha = pressedAlpha;
        }
    }

    public AutoBgImageView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.pressedAlpha = 0.5f;
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        }
    }

    public AutoBgImageView(@Nullable Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            this.pressedAlpha = 0.5f;
        } else {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        }
    }
}
