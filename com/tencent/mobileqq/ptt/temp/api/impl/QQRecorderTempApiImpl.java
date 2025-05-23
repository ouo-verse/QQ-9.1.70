package com.tencent.mobileqq.ptt.temp.api.impl;

import android.content.Context;
import androidx.annotation.NonNull;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.ptt.IQQRecorderUtils;
import com.tencent.mobileqq.ptt.temp.api.IQQRecorderTempApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QQRecorderTempApiImpl implements IQQRecorderTempApi {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "QQRecorderTempImpl";

    public QQRecorderTempApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.ptt.temp.api.IQQRecorderTempApi
    public long AudioHelper_enlargeVolumWrapper(Context context, byte[] bArr, int i3, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, this, context, bArr, Integer.valueOf(i3), Float.valueOf(f16))).longValue();
        }
        return AudioHelper.b(context, bArr, i3, f16);
    }

    @Override // com.tencent.mobileqq.ptt.temp.api.IQQRecorderTempApi
    public int getFilePlayTime(MessageRecord messageRecord) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) messageRecord)).intValue();
        }
        if (messageRecord instanceof MessageForPtt) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "voiceLength getFilePlayTime " + ((MessageForPtt) messageRecord).voiceLength);
            }
            MessageForPtt messageForPtt = (MessageForPtt) messageRecord;
            int i3 = messageForPtt.voiceLength;
            if (i3 > 1) {
                return i3;
            }
            str = messageForPtt.getLocalFilePath();
        } else {
            str = messageRecord instanceof Message ? ((Message) messageRecord).pttUrl : null;
        }
        if (str != null) {
            return ((IQQRecorderUtils) QRoute.api(IQQRecorderUtils.class)).getFilePlayTime(str);
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.ptt.temp.api.IQQRecorderTempApi
    public int getFilePlayTime(@NonNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? ((IQQRecorderUtils) QRoute.api(IQQRecorderUtils.class)).getFilePlayTime(str) : ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str)).intValue();
    }
}
