package com.tencent.biz.pubaccount.util;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.structmsg.view.StructMsgItemVideo;
import com.tencent.mobileqq.structmsg.view.y;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes4.dex */
public class g {
    public static boolean a(int i3) {
        if (i3 >= 1 && i3 <= 100) {
            return true;
        }
        return false;
    }

    public static void b(StructMsgForGeneralShare structMsgForGeneralShare) {
        if (structMsgForGeneralShare == null) {
            return;
        }
        Iterator<AbsStructMsgElement> it = structMsgForGeneralShare.iterator();
        while (true) {
            int i3 = 0;
            if (!it.hasNext()) {
                break;
            }
            AbsStructMsgElement next = it.next();
            if (next instanceof y) {
                Iterator<AbsStructMsgElement> it5 = ((y) next).U0.iterator();
                while (it5.hasNext()) {
                    AbsStructMsgElement next2 = it5.next();
                    if (next2 instanceof StructMsgItemVideo) {
                        StructMsgItemVideo structMsgItemVideo = (StructMsgItemVideo) next2;
                        if (structMsgItemVideo.v()) {
                            structMsgItemVideo.Y0 = null;
                            structMsgItemVideo.S0 = null;
                            structMsgItemVideo.T0 = i3;
                            if (QLog.isColorLevel()) {
                                QLog.d("PAVideoStructMsgUtil", 2, "simplifyForForward: summary = null");
                            }
                            ReportController.o(null, "dc00899", IPublicAccountHandler.MAIN_ACTION, "", "0X800682F", "0X800682F", 0, 0, structMsgItemVideo.W0, "" + structMsgItemVideo.f290495j1, "" + structMsgItemVideo.P0.msgId, "");
                        }
                    } else if (next2 instanceof StructMsgItemTitle) {
                        StructMsgItemTitle structMsgItemTitle = (StructMsgItemTitle) next2;
                        String t16 = structMsgItemTitle.t();
                        int length = t16.length();
                        if (QLog.isColorLevel()) {
                            QLog.d("PAVideoStructMsgUtil", 2, "simplifyForForward: title = " + structMsgItemTitle.t() + ", length=" + length);
                        }
                        if (length > 15) {
                            structMsgItemTitle.E(t16.substring(0, 15) + MiniBoxNoticeInfo.APPNAME_SUFFIX);
                            if (QLog.isColorLevel()) {
                                QLog.d("PAVideoStructMsgUtil", 2, "simplifyForForward: after reduce title length, title = " + structMsgItemTitle.t());
                            }
                        }
                    }
                    i3 = 0;
                }
            }
        }
        if (!TextUtils.isEmpty(structMsgForGeneralShare.mMsgBrief) && structMsgForGeneralShare.mMsgBrief.length() > 15) {
            structMsgForGeneralShare.mMsgBrief = structMsgForGeneralShare.mMsgBrief.substring(0, 15) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
        }
    }
}
