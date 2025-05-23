package com.tencent.ams.mosaic.jsengine.animation.layer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.ams.fusion.widget.utils.Utils;
import com.tencent.ams.mosaic.jsengine.component.text.TextComponent;
import com.tencent.ams.mosaic.utils.MosaicUtils;
import com.tencent.ams.mosaic.utils.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class TextLayer extends LayerBase<a> implements TextComponent {
    static IPatchRedirector $redirector_;
    private float S;
    private Paint.Align T;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class a extends com.tencent.ams.fusion.widget.animatorview.layer.TextLayer {
        static IPatchRedirector $redirector_;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TextLayer.this);
            } else {
                setEllipsizeAtEnd(true);
                setLineSpacingExtra(MosaicUtils.j(4.0f));
            }
        }

        @Override // com.tencent.ams.fusion.widget.animatorview.layer.TextLayer, com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer
        public void draw(Canvas canvas) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) canvas);
                return;
            }
            TextLayer.this.c(canvas);
            super.draw(canvas);
            TextLayer.this.b(canvas);
        }
    }

    public TextLayer(Context context, String str, float f16, float f17) {
        super(context, str, f16, f17);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, str, Float.valueOf(f16), Float.valueOf(f17));
        } else {
            this.S = 16.0f;
            this.T = Paint.Align.LEFT;
        }
    }

    private void e(float f16, float f17) {
        T t16 = this.K;
        if (t16 != 0) {
            Paint.Align align = this.T;
            if (align == Paint.Align.LEFT) {
                ((a) t16).setX(MosaicUtils.j(f16));
            } else if (align == Paint.Align.CENTER) {
                ((a) t16).setX(MosaicUtils.j(f16 + (this.f70736h / 2.0f)));
            } else if (align == Paint.Align.RIGHT) {
                ((a) t16).setX(MosaicUtils.j(f16 + this.f70736h));
            }
            ((a) this.K).setY(MosaicUtils.j(f17) + Utils.getTextPaintBaselineToTop(this.S));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ams.mosaic.jsengine.animation.layer.LayerBase
    @NonNull
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public a a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new a();
    }

    @Override // com.tencent.ams.mosaic.jsengine.animation.layer.LayerBase
    public void setFrame(float f16, float f17, float f18, float f19) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19));
            return;
        }
        this.H = f16;
        this.I = f17;
        setSize(f18, f19);
        e(f16, f17);
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.text.TextComponent
    public void setIncludeFontPadding(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, z16);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.text.TextComponent
    public void setLetterSpacing(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Float.valueOf(f16));
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.text.TextComponent
    public void setLineSpacingExtra(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Float.valueOf(f16));
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.text.TextComponent
    public void setMaxLines(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3);
        } else {
            ((a) this.K).setMaxLines(i3);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.animation.layer.LayerBase, com.tencent.ams.mosaic.jsengine.animation.AnimationProperty
    public void setPosition(float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Float.valueOf(f16), Float.valueOf(f17));
            return;
        }
        this.N = f16;
        this.P = f17;
        e(f16, f17);
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.text.TextComponent
    public void setScrollable(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, z16);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.text.TextComponent
    public void setShadow(float f16, float f17, float f18, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), str);
        } else {
            ((a) this.K).setShadowLayer(MosaicUtils.j(f16), MosaicUtils.j(f17), MosaicUtils.j(f18), MosaicUtils.O(str));
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.text.TextComponent
    public void setSpannableString(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.text.TextComponent
    public void setText(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else {
            ((a) this.K).setText(str);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.text.TextComponent
    public void setTextAlign(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
            return;
        }
        if ("left".equals(str)) {
            this.T = Paint.Align.LEFT;
        } else if ("center".equals(str)) {
            this.T = Paint.Align.CENTER;
        } else if ("right".equals(str)) {
            this.T = Paint.Align.RIGHT;
        }
        ((a) this.K).setTextAlign(this.T);
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.text.TextComponent
    public void setTextColor(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        } else {
            ((a) this.K).setTextColor(MosaicUtils.P(str, -16777216));
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.text.TextComponent
    public void setTextDecoration(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) str);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.text.TextComponent
    public void setTextDecorationColor(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) str);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.text.TextComponent
    public void setTextDecorationPadding(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Float.valueOf(f16));
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.text.TextComponent
    public void setTextDecorationWeight(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Float.valueOf(f16));
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.text.TextComponent
    public void setTextSize(float f16) {
        float f17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Float.valueOf(f16));
            return;
        }
        if (f16 > 0.0f) {
            f17 = MosaicUtils.j(f16);
        } else {
            f17 = 16.0f;
        }
        this.S = f17;
        ((a) this.K).setTextSize(f17);
        setPosition(this.N, this.P);
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.text.TextComponent
    public void setTextTypeface(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) str2);
        } else if (!TextUtils.isEmpty(str2)) {
            ((a) this.K).setTextBold("bold".equals(str2));
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.text.TextComponent
    public void setTruncateMode(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) str);
            return;
        }
        f.e("TextLayer", "setTruncateMode :" + str);
        if (TextUtils.isEmpty(str) || this.K == 0) {
            return;
        }
        if ("end".equals(str)) {
            ((a) this.K).setEllipsizeAtEnd(true);
        } else if ("none".equals(str)) {
            ((a) this.K).setEllipsizeAtEnd(false);
        }
    }
}
