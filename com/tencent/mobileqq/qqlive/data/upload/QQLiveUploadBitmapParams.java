package com.tencent.mobileqq.qqlive.data.upload;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes17.dex */
public class QQLiveUploadBitmapParams {
    static IPatchRedirector $redirector_;
    public String flag;
    public String format;
    public String roomId;
    public boolean useTestEnv;

    public QQLiveUploadBitmapParams() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, obj)).booleanValue();
        }
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        QQLiveUploadBitmapParams qQLiveUploadBitmapParams = (QQLiveUploadBitmapParams) obj;
        if (TextUtils.equals(this.format, qQLiveUploadBitmapParams.format) && TextUtils.equals(this.roomId, qQLiveUploadBitmapParams.roomId)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        String str = this.format;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i16 = (527 + hashCode) * 31;
        String str2 = this.roomId;
        if (str2 != null) {
            i3 = str2.hashCode();
        }
        return i16 + i3;
    }

    public QQLiveUploadBitmapParams(QQLiveUploadBitmapParams qQLiveUploadBitmapParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) qQLiveUploadBitmapParams);
        } else {
            if (qQLiveUploadBitmapParams == null) {
                return;
            }
            this.format = qQLiveUploadBitmapParams.format;
            this.roomId = qQLiveUploadBitmapParams.roomId;
            this.flag = qQLiveUploadBitmapParams.flag;
            this.useTestEnv = qQLiveUploadBitmapParams.useTestEnv;
        }
    }
}
