package com.tencent.mobileqq.filemanager.fileassistant.util;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.filemanager.api.IQFileConfigManager;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtilImpl;
import com.tencent.mobileqq.msg.api.IFeatureSwitch;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import common.config.service.QzoneConfig;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import msf.msgcomm.msg_comm$Msg;
import org.json.JSONObject;
import tencent.im.msg.hummer.resv.generalflags$ResvAttr;
import tencent.im.msg.im_msg_body$Elem;

/* compiled from: P */
/* loaded from: classes12.dex */
public class QQFileAssistantUtils {

    /* renamed from: a, reason: collision with root package name */
    private static final SparseIntArray f208045a;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f208045a = sparseIntArray;
        sparseIntArray.put(65799, 1);
        sparseIntArray.put(67586, 1);
        sparseIntArray.put(Friends.TERM_TYPE_MOBILE_IPAD, 2);
        sparseIntArray.put(Friends.TERM_TYPE_MOBILE_IPAD_NEW, 2);
        sparseIntArray.put(65793, 3);
        sparseIntArray.put(81154, 3);
        sparseIntArray.put(Friends.TERM_TYPE_ANDROID_PAD, 2);
    }

    public static void A(BaseQQAppInterface baseQQAppInterface) {
        ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).resetFileAssistantOnlineMark(baseQQAppInterface);
    }

    public static void B(MessageRecord messageRecord, int i3) {
        String extInfoFromExtStr = messageRecord.getExtInfoFromExtStr("dataline_msg_device_type");
        if (i3 != 0) {
            extInfoFromExtStr = i3 + "";
        }
        if (!TextUtils.isEmpty(extInfoFromExtStr) && Integer.valueOf(extInfoFromExtStr).intValue() != 0) {
            messageRecord.saveExtInfoToExtStr("dataline_msg_device_type", extInfoFromExtStr);
            if (QLog.isColorLevel()) {
                QLog.i("QFileAssistantUtils", 1, "saveMessageDeviceType: mrType[" + messageRecord.msgtype + "] deviceType[" + extInfoFromExtStr + "]");
                return;
            }
            return;
        }
        messageRecord.saveExtInfoToExtStr("dataline_msg_device_type", "" + c());
        if (QLog.isColorLevel()) {
            QLog.i("QFileAssistantUtils", 1, "saveMessageDeviceType: mrType[" + messageRecord.msgtype + "] setDefault deviceType[1]");
        }
    }

    public static void C(BaseQQAppInterface baseQQAppInterface, int i3, boolean z16) {
        ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).setFileAssistantOnlineMark(baseQQAppInterface, i3, z16);
    }

    @Deprecated
    public static void D(final BaseQQAppInterface baseQQAppInterface) {
        if (t(baseQQAppInterface)) {
            return;
        }
        final com.tencent.mobileqq.config.business.qfile.d e16 = e(baseQQAppInterface);
        e16.b(true);
        ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.filemanager.fileassistant.util.QQFileAssistantUtils.1
            @Override // java.lang.Runnable
            public void run() {
                g.a(false);
                com.tencent.mobileqq.config.business.qfile.d.this.g(baseQQAppInterface, true);
            }
        });
    }

    public static void E(int i3) {
        ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).setDefaultTarget(QQFileManagerUtilImpl.A0(), i3);
    }

    public static boolean F(BaseQQAppInterface baseQQAppInterface, long j3) {
        if (k(baseQQAppInterface) >= j3) {
            return true;
        }
        return false;
    }

    public static boolean a(BaseQQAppInterface baseQQAppInterface) {
        return ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).checkNotifyDeviceOnline(baseQQAppInterface);
    }

    public static int b(msg_comm$Msg msg_comm_msg) {
        if (!msg_comm_msg.msg_body.has() || !msg_comm_msg.msg_body.rich_text.has()) {
            return 0;
        }
        Iterator<im_msg_body$Elem> it = msg_comm_msg.msg_body.rich_text.elems.get().iterator();
        while (it.hasNext()) {
            im_msg_body$Elem next = it.next();
            if (next.general_flags.has() && next.general_flags.bytes_pb_reserve.has()) {
                try {
                    generalflags$ResvAttr generalflags_resvattr = new generalflags$ResvAttr();
                    generalflags_resvattr.mergeFrom(next.general_flags.bytes_pb_reserve.get().toByteArray());
                    if (!generalflags_resvattr.uint32_device_type.has()) {
                        return 0;
                    }
                    return generalflags_resvattr.uint32_device_type.get();
                } catch (Exception unused) {
                    continue;
                }
            }
        }
        return 0;
    }

    public static int c() {
        return 65799;
    }

    public static int d() {
        return ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getDefaultTarget((BaseQQAppInterface) QQFileManagerUtilImpl.r1());
    }

    private static com.tencent.mobileqq.config.business.qfile.d e(BaseQQAppInterface baseQQAppInterface) {
        return ((IQFileConfigManager) baseQQAppInterface.getRuntimeService(IQFileConfigManager.class, "")).getDatalineConfig();
    }

    public static int f(int i3) {
        int h16 = h(i3);
        if (h16 == 3) {
            return R.drawable.qfile_dataline_pc_recent;
        }
        if (h16 == 2) {
            return R.drawable.qfile_dataline_ipad_recent;
        }
        return R.drawable.qfile_dataline_user_aio;
    }

    public static String g(Context context, int i3) {
        int h16 = h(i3);
        String string = context.getString(R.string.f187433tz);
        if (h16 == 3) {
            return context.getString(R.string.f187453u1);
        }
        if (h16 == 2) {
            return context.getString(R.string.f187443u0);
        }
        return string;
    }

    public static int h(int i3) {
        int i16 = f208045a.get(i3, 0);
        if (i16 == 0) {
            return 3;
        }
        return i16;
    }

    public static String i(BaseQQAppInterface baseQQAppInterface) {
        return AppConstants.DATALINE_NEW_VERSION_UIN;
    }

    public static long j(BaseQQAppInterface baseQQAppInterface) {
        return e(baseQQAppInterface).a();
    }

    public static long k(BaseQQAppInterface baseQQAppInterface) {
        return e(baseQQAppInterface).e();
    }

    public static boolean l(BaseQQAppInterface baseQQAppInterface, long j3) {
        if (e(baseQQAppInterface).c() >= j3) {
            return true;
        }
        return false;
    }

    private static boolean m(BaseQQAppInterface baseQQAppInterface, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        boolean s16 = s();
        boolean equals = str.equals(((IQFileConfigManager) baseQQAppInterface.getRuntimeService(IQFileConfigManager.class, "")).getDebugDatalineSettingUin());
        if (o()) {
            QLog.d("QFileAssistantUtils", 1, "isFileAssistantAio use toggle switch. actual now is new = " + s16 + ", isFileAssistantUin = " + equals);
            if (!s16 || !equals) {
                return false;
            }
            return true;
        }
        if (equals) {
            QLog.d("QFileAssistantUtils", 1, "isFileAssistantAio origin call. actual now is new = " + s16);
            D(baseQQAppInterface);
        }
        return equals;
    }

    public static boolean n(String str) {
        BaseQQAppInterface A0;
        if (!TextUtils.equals(str, AppConstants.FILE_ASSISTANT_UIN) || (A0 = QQFileManagerUtilImpl.A0()) == null) {
            return false;
        }
        return m(A0, str);
    }

    private static boolean o() {
        if (MobileQQ.sMobileQQ.peekAppRuntime() == null) {
            return true;
        }
        return ((IFeatureSwitch) QRoute.api(IFeatureSwitch.class)).isFeatureSwitchEnable("disable_file_assistant_modification");
    }

    public static boolean p(BaseQQAppInterface baseQQAppInterface, RecentUser recentUser) {
        boolean z16;
        boolean equals = TextUtils.equals(AppConstants.FILE_ASSISTANT_UIN, recentUser.uin);
        if (!TextUtils.equals(AppConstants.DATALINE_PC_UIN, recentUser.uin) && !TextUtils.equals(AppConstants.DATALINE_IPAD_UIN, recentUser.uin)) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!equals && !z16) {
            return false;
        }
        boolean t16 = t(baseQQAppInterface);
        if (equals && !t16) {
            return true;
        }
        if (t16 && z16) {
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.i("QFileAssistantUtils", 1, "recentUser:" + recentUser.uin + ", isNewVer:" + t16);
        }
        return false;
    }

    public static boolean q(MessageRecord messageRecord) {
        int c16 = c();
        String extInfoFromExtStr = messageRecord.getExtInfoFromExtStr("dataline_msg_device_type");
        if (TextUtils.isEmpty(extInfoFromExtStr)) {
            QLog.i("QFileAssistantUtils", 1, "isMessageSender: device type is null, msgType[" + messageRecord.msgtype + "]");
            return false;
        }
        if (h(c16) != h(Integer.valueOf(extInfoFromExtStr).intValue())) {
            return false;
        }
        return true;
    }

    public static boolean r(BaseQQAppInterface baseQQAppInterface) {
        return ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getIsOnline(baseQQAppInterface);
    }

    public static boolean s() {
        BaseQQAppInterface baseQQAppInterface;
        AppRuntime r16 = QQFileManagerUtilImpl.r1();
        if (r16 instanceof BaseQQAppInterface) {
            baseQQAppInterface = (BaseQQAppInterface) r16;
        } else {
            baseQQAppInterface = null;
        }
        if (baseQQAppInterface != null) {
            return t(baseQQAppInterface);
        }
        String c16 = com.tencent.mobileqq.filemanager.util.h.c(r16, "file_dataline_key", "{}");
        if (TextUtils.isEmpty(c16)) {
            QLog.i("QFileAssistantUtils", 1, "loadDatalineConfig: load dataline config. " + c16);
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(c16.toLowerCase());
            if (!jSONObject.has(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH)) {
                return false;
            }
            return jSONObject.getBoolean(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH);
        } catch (Exception e16) {
            QLog.e("QFileAssistantUtils", 1, e16.toString());
            return false;
        }
    }

    public static boolean t(BaseQQAppInterface baseQQAppInterface) {
        if (baseQQAppInterface == null) {
            return false;
        }
        return e(baseQQAppInterface).f();
    }

    public static boolean u(MessageRecord messageRecord) {
        if (messageRecord == null || "1".equalsIgnoreCase(messageRecord.getExtInfoFromExtStr("dataline_old_msg"))) {
            return true;
        }
        return false;
    }

    public static void v(BaseQQAppInterface baseQQAppInterface) {
        ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).notifyUpdateRecentFileAssistant(baseQQAppInterface);
    }

    public static void w(Context context) {
        x(context, null);
    }

    public static void x(Context context, Intent intent) {
        String debugDatalineSettingUin = ((IQFileConfigManager) QQFileManagerUtilImpl.r1().getRuntimeService(IQFileConfigManager.class, "")).getDebugDatalineSettingUin();
        Intent chatActivityIntent = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getChatActivityIntent(context);
        chatActivityIntent.putExtra("uin", debugDatalineSettingUin);
        chatActivityIntent.putExtra("uintype", 0);
        if (intent != null) {
            chatActivityIntent.setFlags(intent.getFlags());
            chatActivityIntent.putExtras(intent);
            chatActivityIntent.setAction(intent.getAction());
            chatActivityIntent.setType(intent.getType());
        }
        chatActivityIntent.putExtra(QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, 1);
        context.startActivity(chatActivityIntent);
    }

    public static void y(Context context, Intent intent) {
        Intent splashActivityIntent = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getSplashActivityIntent(context, ((IQFileConfigManager) QQFileManagerUtilImpl.r1().getRuntimeService(IQFileConfigManager.class, "")).getDebugDatalineSettingUin());
        if (intent != null) {
            splashActivityIntent.setFlags(intent.getFlags());
            splashActivityIntent.putExtras(intent);
            splashActivityIntent.setAction(intent.getAction());
            splashActivityIntent.setType(intent.getType());
        }
        context.startActivity(splashActivityIntent);
    }

    public static void z(BaseQQAppInterface baseQQAppInterface, Intent intent, Bundle bundle) {
        if (!t(baseQQAppInterface)) {
            return;
        }
        String string = bundle.getString("uin", "");
        if (!TextUtils.isEmpty(string) && AppConstants.DATALINE_PC_UIN.equals(string)) {
            bundle.putString("uin", AppConstants.DATALINE_NEW_VERSION_UIN);
            bundle.putInt("uintype", 0);
            bundle.putString("uinname", baseQQAppInterface.getApp().getString(R.string.f187533u9));
        }
        ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).setForwardBundle(intent, bundle);
    }
}
