package com.tencent.util.notification;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.commonsdk.util.notification.NotificationReportController;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.bc;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes27.dex */
public class NotificationReportControllerImpl implements NotificationReportController, Handler.Callback {
    static IPatchRedirector $redirector_ = null;
    private static final String KEY_BEGINTIME = "key_begintime";
    private static final String KEY_TODAY_REPORTED_NOTIFY_IDS = "kay_reported_notify_ids";
    private boolean hasInitTodayReportedNotifyIds;
    private boolean isAfterActionB;
    private List<ReportEntry> mCache;
    bc mHandler;
    private Set<Integer> mTodayReportedNotifyIds;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class ReportEntry {
        static IPatchRedirector $redirector_;
        String mFromUin;
        int mMsgType;
        int mNId;
        int mUinType;

        public ReportEntry(int i3, int i16, String str, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), str, Integer.valueOf(i17));
                return;
            }
            this.mMsgType = i3;
            this.mNId = i16;
            this.mFromUin = str;
            this.mUinType = i17;
        }
    }

    public NotificationReportControllerImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.isAfterActionB = false;
        this.hasInitTodayReportedNotifyIds = false;
        this.mHandler = null;
        this.mCache = new ArrayList();
        this.mHandler = ThreadManagerV2.newHandlerRecycleThread("NotificationReportControllerImpl", 0).a(this);
    }

    private String getTodayReportedNotifyIdsInCache() {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<Integer> it = this.mTodayReportedNotifyIds.iterator();
        while (it.hasNext()) {
            stringBuffer.append(it.next());
            stringBuffer.append(",");
        }
        return stringBuffer.substring(0, stringBuffer.length() - 1);
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01e8 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void reportReal() {
        BaseQQAppInterface baseQQAppInterface;
        String str;
        String str2;
        int i3;
        int i16;
        ReportEntry reportEntry;
        int i17;
        String str3;
        AppRuntime peekAppRuntime;
        int i18 = 1;
        if (MobileQQ.sProcessId == 1 && (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) != null && (peekAppRuntime instanceof BaseQQAppInterface)) {
            baseQQAppInterface = (BaseQQAppInterface) peekAppRuntime;
        } else {
            baseQQAppInterface = null;
        }
        if (baseQQAppInterface != null && this.mCache.size() > 0) {
            for (ReportEntry reportEntry2 : this.mCache) {
                boolean shouldReportNetInfo = shouldReportNetInfo(baseQQAppInterface, reportEntry2.mNId);
                int i19 = reportEntry2.mMsgType;
                if (i19 != i18) {
                    if (i19 != 2) {
                        if (i19 != 3) {
                            if (i19 != 4) {
                                str2 = "";
                                i3 = reportEntry2.mUinType;
                                if (i3 == 7200 && i3 != 1008 && i3 != 7220) {
                                    if (reportEntry2.mNId == 527) {
                                        reportEntry = reportEntry2;
                                        ReportController.x(baseQQAppInterface, shouldReportNetInfo, "tech_push", "push", str2, "", 0, "", "", "", reportEntry2.mNId + "", "", "", "", "", "");
                                        SharedPreferences sharedPreferences = baseQQAppInterface.getApplication().getSharedPreferences("gamePushMsgSp", 0);
                                        if (sharedPreferences.contains("lastPush")) {
                                            int i26 = reportEntry.mMsgType;
                                            i17 = 1;
                                            if (i26 != 1 && i26 != 3) {
                                                str3 = "0X800AE74";
                                            } else {
                                                str3 = "0X800AE73";
                                            }
                                            String str4 = str3;
                                            ReportController.o(null, "dc00898", "", "", str4, str4, 10015, 0, sharedPreferences.getString("lastPush", ""), String.valueOf(reportEntry.mNId), "", "");
                                        } else {
                                            i17 = 1;
                                        }
                                        i16 = i17;
                                    } else {
                                        int i27 = i18;
                                        reportEntry = reportEntry2;
                                        i16 = i27;
                                        ReportController.x(baseQQAppInterface, shouldReportNetInfo, "tech_push", "push", str2, "", 0, "", "", "", reportEntry.mNId + "", "", "", "", "", "");
                                    }
                                } else {
                                    i16 = i18;
                                    reportEntry = reportEntry2;
                                    ReportController.x(baseQQAppInterface, shouldReportNetInfo, "tech_push", "push", str2, "", 0, "", "", reportEntry.mFromUin, reportEntry.mNId + "", "" + reportEntry.mUinType, "", "", "", "");
                                }
                                if (!QLog.isDevelopLevel()) {
                                    QLog.d("NotificationReportControllerImpl", 2, "report real msgType:" + reportEntry.mMsgType + "    frienduin:" + reportEntry.mFromUin + "   uinType:" + reportEntry.mUinType + "    nId:" + reportEntry.mNId);
                                }
                                i18 = i16;
                            } else {
                                str = "lock_clk";
                            }
                        } else {
                            str = "lock_arr";
                        }
                    } else {
                        str = "clk";
                    }
                } else {
                    str = "info_arr";
                }
                str2 = str;
                i3 = reportEntry2.mUinType;
                if (i3 == 7200) {
                }
                i16 = i18;
                reportEntry = reportEntry2;
                ReportController.x(baseQQAppInterface, shouldReportNetInfo, "tech_push", "push", str2, "", 0, "", "", reportEntry.mFromUin, reportEntry.mNId + "", "" + reportEntry.mUinType, "", "", "", "");
                if (!QLog.isDevelopLevel()) {
                }
                i18 = i16;
            }
            this.mCache.clear();
        }
    }

    private boolean shouldReportNetInfo(BaseQQAppInterface baseQQAppInterface, int i3) {
        if (!this.hasInitTodayReportedNotifyIds) {
            String account = baseQQAppInterface.getAccount();
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext());
            long j3 = defaultSharedPreferences.getLong("key_begintime_" + account, 0L);
            long longValue = NotificationController.getDayBegin().longValue();
            this.mTodayReportedNotifyIds = new HashSet();
            if (j3 == longValue) {
                String string = defaultSharedPreferences.getString("kay_reported_notify_ids_" + account, "");
                if (!TextUtils.isEmpty(string)) {
                    for (String str : string.split(",")) {
                        this.mTodayReportedNotifyIds.add(Integer.valueOf(str));
                    }
                }
            } else {
                defaultSharedPreferences.edit().putLong("key_begintime_" + account, longValue).apply();
            }
            this.hasInitTodayReportedNotifyIds = true;
        }
        if (this.mTodayReportedNotifyIds.contains(Integer.valueOf(i3))) {
            return false;
        }
        this.mTodayReportedNotifyIds.add(Integer.valueOf(i3));
        PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).edit().putString("kay_reported_notify_ids_" + baseQQAppInterface.getAccount(), getTodayReportedNotifyIdsInCache()).apply();
        return true;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) message)).booleanValue();
        }
        int i3 = message.what;
        if (i3 != 1 && i3 != 2 && i3 != 3 && i3 != 4) {
            if (i3 == 5) {
                this.isAfterActionB = true;
                reportReal();
            }
        } else {
            ReportEntry reportEntry = (ReportEntry) message.obj;
            if (this.isAfterActionB) {
                this.mCache.add(reportEntry);
                reportReal();
            } else {
                this.mCache.add(reportEntry);
            }
        }
        return true;
    }

    @Override // com.tencent.commonsdk.util.notification.NotificationReportController
    public void report(int i3, int i16, String str, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), str, Integer.valueOf(i17));
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("NotificationReportControllerImpl", 2, "msgType:" + i3 + "frienduin:" + str + "   uinType:" + i17 + "    nId:" + i16);
        }
        Message obtain = Message.obtain();
        obtain.what = i3;
        obtain.obj = new ReportEntry(i3, i16, str, i17);
        this.mHandler.h(obtain);
    }

    @Override // com.tencent.commonsdk.util.notification.NotificationReportController
    public void reportAll() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 5;
        this.mHandler.h(obtain);
    }
}
