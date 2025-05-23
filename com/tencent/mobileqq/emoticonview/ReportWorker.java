package com.tencent.mobileqq.emoticonview;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.apollo.statistics.product.api.IApolloDtReportHelper;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.emoticon.EmoticonOperateReport;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.text.TextUtils;
import com.tencent.mobileqq.utils.fd;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes12.dex */
public class ReportWorker implements Runnable {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "ReportWorker";
    private BaseQQAppInterface mAppInterface;
    private int mCurType;
    private boolean mIsForward;
    private String mMsg;
    private WeakReference<IEmoticonMainPanel> mPanelReference;

    public ReportWorker(String str, boolean z16, IEmoticonMainPanel iEmoticonMainPanel, BaseQQAppInterface baseQQAppInterface, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Boolean.valueOf(z16), iEmoticonMainPanel, baseQQAppInterface, Integer.valueOf(i3));
            return;
        }
        this.mMsg = str;
        this.mIsForward = z16;
        this.mAppInterface = baseQQAppInterface;
        this.mPanelReference = new WeakReference<>(iEmoticonMainPanel);
        this.mCurType = i3;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i3;
        int i16;
        int i17;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        String str2 = this.mMsg;
        if (str2 != null && !"".equals(str2)) {
            StringBuilder sb5 = new StringBuilder(this.mMsg);
            ArrayList arrayList = new ArrayList();
            int i18 = 0;
            while (i18 < sb5.length()) {
                int codePointAt = sb5.codePointAt(i18);
                if (codePointAt == 20 && i18 < sb5.length() - 1) {
                    int i19 = i18 + 1;
                    char charAt = sb5.charAt(i19);
                    if (charAt >= EmotcationConstants.VALID_SYS_EMOTCATION_COUNT && '\u00fa' != charAt) {
                        if (charAt != '\u00ff') {
                            continue;
                        } else {
                            int i26 = i18 + 4;
                            if (i26 >= sb5.length()) {
                                return;
                            }
                            char[] cArr = new char[4];
                            cArr[0] = sb5.charAt(i26);
                            cArr[1] = sb5.charAt(i18 + 3);
                            cArr[2] = sb5.charAt(i18 + 2);
                            char charAt2 = sb5.charAt(i19);
                            cArr[3] = charAt2;
                            int i27 = 0;
                            for (int i28 = 3; i27 < i28; i28 = 3) {
                                char c16 = cArr[i27];
                                if (c16 == '\u00fa') {
                                    cArr[i27] = '\n';
                                } else if (c16 == '\u00fe') {
                                    cArr[i27] = '\r';
                                }
                                i27++;
                            }
                            int[] r16 = com.tencent.mobileqq.emosm.e.r(cArr);
                            if (r16 != null && r16.length == 2) {
                                i16 = r16[0];
                                i3 = r16[1];
                            } else {
                                i3 = 0;
                                i16 = 0;
                            }
                            WeakReference<IEmoticonMainPanel> weakReference = this.mPanelReference;
                            if (weakReference != null && weakReference.get() != null) {
                                i17 = this.mPanelReference.get().getEmoticonTab(Integer.toString(i16));
                            } else {
                                i17 = -1;
                            }
                            String num = Integer.toString(i17);
                            if (this.mIsForward) {
                                str = "0X800588C";
                            } else {
                                str = "0X80057AF";
                            }
                            String str3 = str;
                            ReportController.o(this.mAppInterface, "CliOper", "", "", "ep_mall", str3, 0, 0, i16 + "", i3 + "", num, "");
                            EmoticonOperateReport.reportAIOEmoticonMonitorSendStatus("0", 5);
                            if (QLog.isColorLevel()) {
                                QLog.d(TAG, 2, "report small emoticon send amount, epId:" + i16 + ",eId:" + i3 + ",tabOrder:" + num);
                            }
                            i18 = i26;
                        }
                    } else {
                        if ('\u00fa' == charAt) {
                            charAt = '\n';
                        }
                        ReportController.o(this.mAppInterface, "CliOper", "", "", "ep_mall", "0X80057A3", 0, 0, ((int) charAt) + "", "", "", "");
                        if (TextUtils.isApolloEmoticon(charAt)) {
                            fd.a(this.mAppInterface, "cmshow", "Apollo", "0X800812E", ((IApolloUtil) QRoute.api(IApolloUtil.class)).getReportSessionType(this.mCurType), 0, String.valueOf((int) charAt), "0");
                            arrayList.add(Integer.valueOf(QQSysFaceUtil.convertToServer(charAt)));
                        }
                        EmoticonOperateReport.reportAIOEmoticonMonitorSendStatus("0", 1);
                        if (QLog.isColorLevel()) {
                            QLog.d(TAG, 2, "report emoji send amount, index:" + ((int) charAt));
                        }
                    }
                } else {
                    int i29 = EmotcationConstants.EMOJI_MAP.get(codePointAt, -1);
                    if (i29 >= 0) {
                        ReportController.o(this.mAppInterface, "CliOper", "", "", "ep_mall", "0X80057A4", 0, 0, i29 + "", "", "", "");
                        EmoticonOperateReport.reportAIOEmoticonMonitorSendStatus("0", 1);
                        if (QLog.isColorLevel()) {
                            QLog.d(TAG, 2, "report system emoticon send amount, emoIdx:" + i29);
                        }
                    }
                }
                i18++;
            }
            try {
                ((IApolloDtReportHelper) QRoute.api(IApolloDtReportHelper.class)).apolloCmEmojiSendReport(arrayList, this.mAppInterface, this.mCurType);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "report apolloCmEmojiSendReport error!", e16);
                }
            }
        }
    }
}
