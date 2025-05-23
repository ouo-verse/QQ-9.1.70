package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.graphics.Paint;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.ptt.IQQRecorderUtils;
import com.tencent.mobileqq.pttlogic.api.IPttUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.transfile.api.TransFileControllerBusHelper;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.ServerConfigManager;

/* compiled from: P */
/* loaded from: classes10.dex */
public class n {
    public static String a(int i3) {
        String str;
        int i16 = i3 / 60;
        int i17 = i3 % 60;
        if (i16 > 0) {
            str = i16 + "'";
        } else {
            str = "";
        }
        return str + i17 + "\"";
    }

    public static int b(Context context, int i3, String str, Paint paint, int i16) {
        int i17;
        int i18;
        float f16;
        int min = Math.min(60, Math.max(1, i3));
        if (min > 40) {
            i17 = min + 40;
        } else {
            i17 = min * 2;
        }
        int f17 = BaseAIOUtils.f(i17 + 20, context.getResources());
        if (str != null && paint != null) {
            int d16 = ((BaseChatItemLayout.N - BaseChatItemLayout.d()) - BaseChatItemLayout.c()) - 32;
            float measureText = paint.measureText(str) + i16;
            float f18 = d16;
            if (measureText > f18) {
                measureText = f18;
            }
            if (i3 > 99) {
                f16 = 38.0f;
            } else {
                if (i3 > 9) {
                    i18 = 34;
                } else {
                    i18 = 30;
                }
                f16 = i18;
            }
            int f19 = BaseAIOUtils.f(f16, context.getResources());
            int i19 = f17 + f19;
            if (i19 <= d16) {
                d16 = i19;
            }
            return Math.max(d16, (int) measureText) - f19;
        }
        return f17;
    }

    public static int c(QQAppInterface qQAppInterface, String str) {
        String serverConfigValue = qQAppInterface.getServerConfigValue(ServerConfigManager.ConfigType.common, str);
        if (QLog.isColorLevel()) {
            QLog.d("PttItemBuilder", 2, "key = " + str + ", time = " + serverConfigValue);
        }
        if (serverConfigValue != null) {
            try {
                int intValue = Integer.valueOf(serverConfigValue).intValue();
                if (intValue > 0) {
                    return intValue;
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("PttItemBuilder", 2, e16.toString());
                }
            }
        }
        if ("ConvertText_MaxPtt".equals(str) || "Normal_MaxPtt".equals(str)) {
            return 120;
        }
        if ("VIP_MaxPtt".equals(str)) {
            return 180;
        }
        if (!"SVIP_MaxPtt".equals(str)) {
            return 120;
        }
        return 300;
    }

    public static int d(Context context, int i3, float f16, int i16, int i17, boolean z16, boolean z17) {
        int j3;
        int i18;
        int i19;
        int min = Math.min(60, Math.max(1, i3));
        if (min == 1) {
            j3 = 25;
        } else {
            j3 = ((int) (PttAudioWaveView.j(min, 60, 1.5f) * 125.0f)) + 15;
        }
        if (z16) {
            i18 = 16;
        } else {
            i18 = 0;
        }
        if (z17) {
            i18 += 38;
        }
        if (i18 != 0 && j3 > (i19 = 170 - i18)) {
            j3 = i19;
        }
        if (j3 % 5 != 0) {
            j3 = (j3 / 5) * 5;
        }
        int f17 = BaseAIOUtils.f(j3, context.getResources());
        if (f16 > 0.0f) {
            int max = Math.max(f17 + BaseAIOUtils.f(i16, context.getResources()) + BaseAIOUtils.f(i17, context.getResources()), (int) f16);
            int d16 = ((BaseChatItemLayout.N - BaseChatItemLayout.d()) - BaseChatItemLayout.c()) - 32;
            if (max > d16) {
                max = d16;
            }
            return max - BaseAIOUtils.f(i16 - 40, context.getResources());
        }
        return f17 + BaseAIOUtils.f(i17, context.getResources());
    }

    protected static boolean e(MessageForPtt messageForPtt) {
        String lastRecorderPath = ((IQQRecorderUtils) QRoute.api(IQQRecorderUtils.class)).getLastRecorderPath();
        if (messageForPtt.fileSize == -2 && !TextUtils.isEmpty(lastRecorderPath) && lastRecorderPath.equals(messageForPtt.getLocalFilePath())) {
            return true;
        }
        return false;
    }

    public static int f(QQAppInterface qQAppInterface, MessageForPtt messageForPtt) {
        if (messageForPtt == null) {
            return 0;
        }
        if (QLog.isColorLevel()) {
            QLog.d("PttItemBuilder", 2, "parsePttStatus test fileSize " + messageForPtt.fileSize + " url " + messageForPtt.url + " uniseq " + messageForPtt.uniseq);
        }
        if (messageForPtt.isSendFromLocal()) {
            String str = messageForPtt.url;
            if (str != null && str.startsWith(AppConstants.SDCARD_ROOT)) {
                long j3 = messageForPtt.fileSize;
                if (j3 > 0) {
                    return 1003;
                }
                if (j3 != -1) {
                    if (j3 == -2) {
                        if (!e(messageForPtt)) {
                            messageForPtt.fileSize = -1L;
                        }
                        return 999;
                    }
                    if (j3 == -3) {
                        boolean containsProcessor = ((ITransFileController) qQAppInterface.getRuntimeService(ITransFileController.class)).containsProcessor(messageForPtt.frienduin, messageForPtt.uniseq);
                        int findProcessorFileStatus = TransFileControllerBusHelper.findProcessorFileStatus(qQAppInterface, messageForPtt.frienduin, messageForPtt.getLocalFilePath(), messageForPtt.uniseq);
                        if (QLog.isColorLevel()) {
                            QLog.d("PttItemBuilder", 2, "parsePttStatus transStatus  " + findProcessorFileStatus + ", hasTransProc " + containsProcessor);
                        }
                        if (containsProcessor && findProcessorFileStatus != 1005) {
                            if (findProcessorFileStatus != 7000) {
                                return 1001;
                            }
                            return 999;
                        }
                        messageForPtt.fileSize = -1L;
                    } else {
                        int findProcessorFileStatus2 = TransFileControllerBusHelper.findProcessorFileStatus(qQAppInterface, messageForPtt.frienduin, messageForPtt.getLocalFilePath(), messageForPtt.uniseq);
                        if (QLog.isColorLevel()) {
                            QLog.d("PttItemBuilder", 2, "parsePttStatus status  " + findProcessorFileStatus2);
                            return findProcessorFileStatus2;
                        }
                        return findProcessorFileStatus2;
                    }
                }
                return 1005;
            }
            return 1004;
        }
        if (QLog.isColorLevel()) {
            QLog.d("PttItemBuilder", 2, "handlePttItem recieve friendUin " + messageForPtt.frienduin + " url " + messageForPtt.url + " urlAtServer " + messageForPtt.urlAtServer + " uniseq " + messageForPtt.uniseq);
        }
        int receivedPTTStatus = ((IPttUtils) QRoute.api(IPttUtils.class)).getReceivedPTTStatus(qQAppInterface, messageForPtt);
        if (QLog.isColorLevel()) {
            QLog.d("PttItemBuilder", 2, "handlePttItem recieve status " + receivedPTTStatus + "   url " + messageForPtt.url + " uniseq " + messageForPtt.uniseq);
            return receivedPTTStatus;
        }
        return receivedPTTStatus;
    }
}
