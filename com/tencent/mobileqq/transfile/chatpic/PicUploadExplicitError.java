package com.tencent.mobileqq.transfile.chatpic;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes19.dex */
public class PicUploadExplicitError {
    static IPatchRedirector $redirector_ = null;
    private static final int ERROR_OVER_BACK_LIMIT = 2;
    private static final int ERROR_OVER_CLIENT_LIMIT = 1;
    private static final int ERROR_OVER_COUNT = 3;
    private static final String SEND_PHOTO_DAY_KEY = "SEND_PHOTO_DAY_KEY";
    public static final String TAG = "PicUploadExplicitError";
    public static final String TAG_REASON = "PicUploadExplicitErrorReason";

    public PicUploadExplicitError() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static int getError(int i3, MessageRecord messageRecord, String str) {
        if (i3 == 9063 || i3 == 90632) {
            return 1;
        }
        int i16 = messageRecord.istroop;
        if (i16 != 1 && i16 != 3000) {
            if (i3 == -9527) {
                int reasonServerErrCode = getReasonServerErrCode(str);
                if (reasonServerErrCode == 199) {
                    return 2;
                }
                if (reasonServerErrCode == 206 || reasonServerErrCode == 207) {
                    return 3;
                }
                return -1;
            }
            return -1;
        }
        if (i3 == -9527) {
            int reasonServerErrCode2 = getReasonServerErrCode(str);
            if (reasonServerErrCode2 == 197) {
                return 2;
            }
            if (reasonServerErrCode2 == 202 || reasonServerErrCode2 == 201) {
                return 3;
            }
            return -1;
        }
        return -1;
    }

    private static String getFailedTip(int i3) {
        if (i3 == 1 || i3 == 2) {
            return BaseApplication.getContext().getResources().getString(R.string.iie);
        }
        if (i3 != 3) {
            return null;
        }
        return BaseApplication.getContext().getResources().getString(R.string.iid);
    }

    private static int getReasonServerErrCode(String str) {
        String[] split;
        if (str != null && (split = str.split("_")) != null && split.length == 2) {
            try {
                return Integer.parseInt(split[1]);
            } catch (NumberFormatException e16) {
                e16.printStackTrace();
            }
        }
        return 0;
    }

    public static void uploadFailUpdateMsg(MessageRecord messageRecord, int i3, String str, String str2) {
        if (messageRecord instanceof MessageForPic) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "uploadFailUpdateMsg,errCode:" + i3 + " errStr:" + str + " uinType:" + messageRecord.istroop + " msg:" + messageRecord);
            }
            int error = getError(i3, messageRecord, str2);
            if (error > 0) {
                if (error == 3) {
                    messageRecord.saveExtInfoToExtStr(TAG, String.valueOf(i3));
                    messageRecord.saveExtInfoToExtStr(TAG_REASON, str2);
                    messageRecord.saveExtInfoToExtStr(SEND_PHOTO_DAY_KEY, String.valueOf(SystemClock.uptimeMillis()));
                } else {
                    messageRecord.saveExtInfoToExtStr(TAG, String.valueOf(i3));
                    messageRecord.saveExtInfoToExtStr(TAG_REASON, str2);
                }
                ((MessageForPic) messageRecord).updateMsgExtFiled();
            }
        }
    }

    public static String getFailedTip(MessageForPic messageForPic) {
        try {
            String extInfoFromExtStr = messageForPic.getExtInfoFromExtStr(TAG);
            if (!TextUtils.isEmpty(extInfoFromExtStr)) {
                int error = getError(Integer.parseInt(extInfoFromExtStr), messageForPic, messageForPic.getExtInfoFromExtStr(TAG_REASON));
                if (error == 3) {
                    String extInfoFromExtStr2 = messageForPic.getExtInfoFromExtStr(SEND_PHOTO_DAY_KEY);
                    if (!TextUtils.isEmpty(extInfoFromExtStr2)) {
                        long parseLong = Long.parseLong(extInfoFromExtStr2);
                        long uptimeMillis = SystemClock.uptimeMillis();
                        if (d.f(parseLong, uptimeMillis)) {
                            if (QLog.isColorLevel()) {
                                QLog.d(TAG, 2, "getFailedTip,lastSendPicTime:" + parseLong + " timeCurrent:" + uptimeMillis);
                            }
                            return getFailedTip(error);
                        }
                        messageForPic.removeExtInfoToExtStr(SEND_PHOTO_DAY_KEY);
                        messageForPic.updateMsgExtFiled();
                        return null;
                    }
                } else {
                    return getFailedTip(error);
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return null;
    }
}
