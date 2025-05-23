package com.tencent.mobileqq.text;

import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.style.ISmallEmojiSpan;
import com.tencent.mobileqq.text.style.api.ISmallEmojiSpanService;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes18.dex */
class k extends l {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    private ISmallEmojiSpan f292684c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(@NonNull String str, int i3, int i16) {
        super(3, str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (str.length() >= 6) {
            char[] cArr = new char[3];
            cArr[0] = str.charAt(3);
            cArr[1] = str.charAt(4);
            cArr[2] = (char) (str.charAt(5) & '\u00ff');
            for (int i17 = 0; i17 < 3; i17++) {
                char c16 = cArr[i17];
                if (c16 == '\u00fa') {
                    cArr[i17] = '\n';
                } else if (c16 == '\u00fe') {
                    cArr[i17] = '\r';
                }
            }
            this.f292684c = ((ISmallEmojiSpanService) QRoute.api(ISmallEmojiSpanService.class)).createSmallEmojiSpan(cArr, i16, true, i3 == 511);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.mobileqq.text.l
    public float c(@NonNull Paint paint) {
        Drawable drawable;
        ISmallEmojiSpan iSmallEmojiSpan = this.f292684c;
        if (iSmallEmojiSpan != null && (drawable = iSmallEmojiSpan.getDrawable()) != null) {
            float width = drawable.getBounds().width();
            if (QLog.isColorLevel()) {
                QLog.d("NickWrapper", 2, "getWidth small span width " + width);
            }
            return width;
        }
        if (QLog.isColorLevel()) {
            QLog.d("NickWrapper", 2, "getWidth with error drawable");
            return 0.0f;
        }
        return 0.0f;
    }
}
