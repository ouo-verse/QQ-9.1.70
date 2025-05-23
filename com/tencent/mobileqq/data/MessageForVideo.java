package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.util.aw;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes10.dex */
public class MessageForVideo extends ChatMessage {
    private static final String TAG = "MessageForVideo";
    public long businessFlag;
    public long hungUpMs;
    public long hungUpReason;
    public boolean isVideo;
    public boolean needParse = true;
    public long roomId;
    public int switchFlag;
    public String text;
    public int type;

    private void doParseInternal() {
        String[] strArr;
        boolean parseBoolean;
        String str = this.f203106msg;
        if (str != null) {
            strArr = str.split("\\|");
        } else {
            strArr = null;
        }
        boolean z16 = false;
        if (strArr != null && strArr.length > 0) {
            this.text = strArr[0].trim();
        } else {
            this.text = "";
        }
        if (strArr != null && strArr.length > 1) {
            try {
                this.type = Integer.parseInt(strArr[1]);
            } catch (Exception unused) {
                String str2 = this.f203106msg;
                if (str2 != null && str2.length() > 0 && this.f203106msg.charAt(0) == 22) {
                    throw new RuntimeException("java.lang.NumberFormatException: Invalid int: " + strArr[1] + " msg is " + this.f203106msg);
                }
                this.type = 5;
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "java.lang.NumberFormatException: Invalid int: " + strArr[1] + " msg byte " + aw.a(this.f203106msg));
                }
            }
        } else {
            this.type = 5;
        }
        if (strArr != null && strArr.length > 3) {
            if (strArr.length == 4) {
                this.isVideo = "1".equals(strArr[3]);
            } else {
                if (strArr.length > 5) {
                    try {
                        parseBoolean = Boolean.parseBoolean(strArr[5]);
                    } catch (Exception unused2) {
                    }
                    if (!parseBoolean || strArr[0].contains(HardCodeUtil.qqStr(R.string.o1w))) {
                        z16 = true;
                    }
                    this.isVideo = z16;
                }
                parseBoolean = false;
                if (!parseBoolean) {
                }
                z16 = true;
                this.isVideo = z16;
            }
        } else {
            this.isVideo = true;
        }
        if (QLog.isColorLevel() || QLog.isDebugVersion()) {
            QLog.d(TAG, 2, "text:= " + this.text + " isVideo:=" + this.isVideo + "type:=" + this.type);
        }
    }

    private void doServerParse() {
        boolean z16;
        String extInfoFromExtStr = getExtInfoFromExtStr("dav_bubble_room_id");
        String extInfoFromExtStr2 = getExtInfoFromExtStr("dav_bubble_hung_up_reason");
        String extInfoFromExtStr3 = getExtInfoFromExtStr("dav_bubble_hung_up_time");
        String extInfoFromExtStr4 = getExtInfoFromExtStr("dav_bubble_business_flag");
        String extInfoFromExtStr5 = getExtInfoFromExtStr("dav_bubble_switch_flag");
        try {
            this.roomId = Long.valueOf(extInfoFromExtStr).longValue();
        } catch (Exception e16) {
            this.roomId = 0L;
            QLog.e(TAG, 1, "[doParse] read from db, roomId parse error.", e16);
        }
        try {
            this.hungUpReason = Long.valueOf(extInfoFromExtStr2).longValue();
        } catch (Exception e17) {
            this.hungUpReason = 0L;
            QLog.e(TAG, 1, "[doParse] read from db, hungUpReasonStr parse error.", e17);
        }
        try {
            this.hungUpMs = Long.valueOf(extInfoFromExtStr3).longValue();
        } catch (Exception e18) {
            this.hungUpMs = 0L;
            QLog.e(TAG, 1, "[doParse] read from db, hungUpMsStr parse error.", e18);
        }
        try {
            long longValue = Long.valueOf(extInfoFromExtStr4).longValue();
            this.businessFlag = longValue;
            if (longValue == 2) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.isVideo = z16;
        } catch (Exception e19) {
            this.businessFlag = 0L;
            QLog.e(TAG, 1, "[doParse] read from db, businessFlag parse error.", e19);
        }
        try {
            this.switchFlag = Integer.valueOf(extInfoFromExtStr5).intValue();
        } catch (Exception e26) {
            this.switchFlag = 0;
            QLog.e(TAG, 1, "[doParse] read from db, switchFlagStr parse error.", e26);
        }
    }

    private void resetMessageType(boolean z16) {
        int i3;
        if (z16) {
            if (TextUtils.equals(this.selfuin, this.senderuin)) {
                i3 = 0;
            } else {
                i3 = 2;
            }
            this.type = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.ChatMessage
    public void doParse() {
        boolean isFromServer = isFromServer();
        if (isFromServer) {
            doServerParse();
        }
        if (this.needParse) {
            doParseInternal();
        }
        resetMessageType(isFromServer);
        if (QLog.isColorLevel() || QLog.isDebugVersion()) {
            QLog.d(TAG, 2, "[doParse] content: " + getDebugInfo());
        }
    }

    public String getDebugInfo() {
        StringBuffer stringBuffer = new StringBuffer("MessageForVideo{");
        stringBuffer.append("type = '");
        stringBuffer.append(this.type);
        stringBuffer.append('\'');
        stringBuffer.append(", isVideo = '");
        stringBuffer.append(this.isVideo);
        stringBuffer.append('\'');
        stringBuffer.append(", roomId = '");
        stringBuffer.append(this.roomId);
        stringBuffer.append('\'');
        stringBuffer.append(", hungUpReason = '");
        stringBuffer.append(this.hungUpReason);
        stringBuffer.append('\'');
        stringBuffer.append(", hungUpMs = ");
        stringBuffer.append(this.hungUpMs);
        stringBuffer.append('\'');
        stringBuffer.append(", businessFlag = ");
        stringBuffer.append(this.businessFlag);
        stringBuffer.append('\'');
        stringBuffer.append(", switchFlag = ");
        stringBuffer.append(this.switchFlag);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x002d A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean isFromServer() {
        long longValue;
        if (!TextUtils.isEmpty(getExtInfoFromExtStr("dav_bubble_room_id"))) {
            try {
                longValue = Long.valueOf(getExtInfoFromExtStr("dav_bubble_room_id")).longValue();
            } catch (Exception e16) {
                QLog.e(TAG, 1, "[doParse] read from db, roomId parse error.", e16);
            }
            if (longValue == 0) {
                return true;
            }
            return false;
        }
        longValue = 0;
        if (longValue == 0) {
        }
    }
}
