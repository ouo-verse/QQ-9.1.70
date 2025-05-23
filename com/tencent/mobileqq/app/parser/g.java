package com.tencent.mobileqq.app.parser;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class g extends com.tencent.mobileqq.utils.ax {
    static IPatchRedirector $redirector_;

    public g(QQAppInterface qQAppInterface, Context context) {
        super(qQAppInterface, context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) context);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x007a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean F(int i3) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, i3)).booleanValue();
        }
        String str = this.f307441f.get("pkid");
        String str2 = this.f307441f.get(AEEditorConstants.VIDEO_CLIP_START_TIME);
        String str3 = this.f307441f.get(AEEditorConstants.VIDEO_CLIP_END_TIME);
        String str4 = this.f307441f.get("iscj");
        String str5 = this.f307441f.get("fromtype");
        this.f307441f.get("uin");
        try {
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (!TextUtils.isEmpty(str5)) {
            i16 = Integer.valueOf(str5).intValue();
            if (str4 != null) {
                Integer.parseInt(str4);
            }
            if (QLog.isColorLevel()) {
                QLog.d("AVGameSpringHBAction", 2, "[doAction] pkID: ", str, ", startTime: ", str2, ", endTime: ", str3, ",sourceValue: ", Integer.valueOf(i16));
            }
            return true;
        }
        i16 = 0;
        if (str4 != null) {
        }
        if (QLog.isColorLevel()) {
        }
        return true;
    }

    @Override // com.tencent.mobileqq.utils.ax
    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return F(1);
    }
}
