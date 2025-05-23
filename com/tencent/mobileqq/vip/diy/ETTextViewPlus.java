package com.tencent.mobileqq.vip.diy;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.TextView;
import com.etrump.mixlayout.ETTextView;
import com.etrump.mixlayout.k;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vas.font.api.FontLoadCallback;
import com.tencent.mobileqq.vas.font.api.IFontManagerService;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes20.dex */
public class ETTextViewPlus extends ETTextView implements FontLoadCallback, x03.a {
    static IPatchRedirector $redirector_;
    private IFontManagerService O0;
    private String P0;
    private int Q0;
    private int R0;
    private com.tencent.qqnt.classadapter.c S0;

    public ETTextViewPlus(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.Q0 = -1;
        this.R0 = -1;
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        this.O0 = (IFontManagerService) qQAppInterface.getRuntimeService(IFontManagerService.class, "");
        this.P0 = qQAppInterface.getCurrentUin();
        super.setSingleLine(true);
        setMaxWidth(UIUtils.m(getContext()) - UIUtils.b(context, 24.0f));
    }

    @Override // x03.a
    public void e(int i3, int i16, @NotNull String str, boolean z16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), Integer.valueOf(i16), str, Boolean.valueOf(z16), Integer.valueOf(i17));
            return;
        }
        com.tencent.qqnt.classadapter.c cVar = new com.tencent.qqnt.classadapter.c(i3, i16, str, z16, this);
        this.S0 = cVar;
        cVar.l(i17);
    }

    protected void finalize() throws Throwable {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        super.finalize();
        this.O0.removeFontLoadCallback(this);
        this.O0 = null;
    }

    @Override // x03.a
    public void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        com.tencent.qqnt.classadapter.c cVar = this.S0;
        if (cVar != null) {
            cVar.n();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.etrump.mixlayout.ETTextView, com.tencent.mobileqq.widget.AnimationTextView, android.view.View
    public void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.onDetachedFromWindow();
        hd0.c.t("DIYProfileTemplate.ETTextViewPlus", NodeProps.ON_DETACHED_FROM_WINDOW);
        this.O0.removeFontLoadCallback(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.etrump.mixlayout.ETTextView, com.tencent.mobileqq.widget.AnimationTextView, android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) canvas);
            return;
        }
        super.onDraw(canvas);
        com.tencent.qqnt.classadapter.c cVar = this.S0;
        if (cVar != null && !cVar.k()) {
            int height = getHeight();
            float j3 = this.S0.j();
            if (height == 0) {
                height = this.S0.i();
            }
            canvas.saveLayerAlpha(0.0f, 0.0f, j3, height, 255);
            super.onDraw(canvas);
            this.S0.h(canvas);
            canvas.restore();
        }
    }

    @Override // com.tencent.mobileqq.vas.font.api.FontLoadCallback
    public void onFontLoaded() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        hd0.c.t("DIYProfileTemplate.ETTextViewPlus", "setFontAsync download completed");
        k fontInfo = this.O0.getFontInfo(this.Q0, this.R0, false, this.P0, 0);
        if (fontInfo != null && fontInfo.f32756f != null) {
            hd0.c.t("DIYProfileTemplate.ETTextViewPlus", "setFontAsync [" + this.Q0 + "] download completed");
            setFont(fontInfo.f32756f, System.currentTimeMillis());
            if (Looper.myLooper() == Looper.getMainLooper()) {
                setText(getText());
            } else {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.vip.diy.ETTextViewPlus.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ETTextViewPlus.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else {
                            ETTextViewPlus eTTextViewPlus = ETTextViewPlus.this;
                            eTTextViewPlus.setText(eTTextViewPlus.getText());
                        }
                    }
                });
            }
            this.O0.removeFontLoadCallback(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.etrump.mixlayout.ETTextView, android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        } else {
            super.onTextChanged(charSequence, i3, i16, i17);
            this.f32609e0 = System.currentTimeMillis();
        }
    }

    public void setFontAsync(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (this.Q0 > 0) {
            AssertUtils.fail("DIYProfileTemplate.ETTextViewPluserror: it is not allow set font id multiple time! orig=" + this.Q0 + " set " + i3, new Object[0]);
            hd0.c.g("DIYProfileTemplate.ETTextViewPlus", "error: it is not allow set font id multiple time! orig=" + this.Q0 + " set " + i3);
            return;
        }
        this.Q0 = i3;
        this.R0 = i16;
        k fontInfo = this.O0.getFontInfo(i3, i16, false, this.P0, 0);
        if (fontInfo != null) {
            hd0.c.t("DIYProfileTemplate.ETTextViewPlus", "setFontAsync [" + i3 + "] success");
            setFont(fontInfo.f32756f, System.currentTimeMillis());
            return;
        }
        hd0.c.t("DIYProfileTemplate.ETTextViewPlus", "setFontAsync [" + i3 + "] need download");
        this.O0.addFontLoadCallback(this);
    }

    @Override // com.etrump.mixlayout.ETTextView, com.tencent.mobileqq.widget.AnimationTextView, com.tencent.mobileqq.widget.PatchedTextView, android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) charSequence, (Object) bufferType);
            return;
        }
        String charSequence2 = charSequence.toString();
        float measureText = getPaint().measureText(charSequence2);
        int i3 = this.f32605a0;
        if (i3 > 0 && i3 < measureText) {
            int length = (int) ((measureText - i3) / (measureText / charSequence2.length()));
            super.setText(charSequence2.substring(0, (charSequence2.length() - length) - 2) + MiniBoxNoticeInfo.APPNAME_SUFFIX, bufferType);
            return;
        }
        super.setText(charSequence, bufferType);
    }

    public ETTextViewPlus(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.Q0 = -1;
        this.R0 = -1;
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        this.O0 = (IFontManagerService) qQAppInterface.getRuntimeService(IFontManagerService.class, "");
        this.P0 = qQAppInterface.getCurrentUin();
        super.setSingleLine(true);
        setMaxWidth(UIUtils.m(getContext()) - UIUtils.b(context, 24.0f));
    }
}
