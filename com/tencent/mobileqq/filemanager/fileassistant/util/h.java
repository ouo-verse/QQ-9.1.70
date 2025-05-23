package com.tencent.mobileqq.filemanager.fileassistant.util;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.filemanager.api.IQFileAssistantUtils;
import com.tencent.mobileqq.qroute.QRoute;
import msf.msgcomm.msg_comm$Msg;

/* compiled from: P */
/* loaded from: classes12.dex */
public class h {
    public static boolean A(BaseQQAppInterface baseQQAppInterface, long j3) {
        return c().userOfflineOnly(baseQQAppInterface, j3);
    }

    public static boolean a(BaseQQAppInterface baseQQAppInterface) {
        return c().checkNotifyDeviceOnline(baseQQAppInterface);
    }

    public static int b(msg_comm$Msg msg_comm_msg) {
        return c().decodeMessageDeviceType(msg_comm_msg);
    }

    public static IQFileAssistantUtils c() {
        return (IQFileAssistantUtils) QRoute.api(IQFileAssistantUtils.class);
    }

    public static int d() {
        return c().getCurrentDeviceType();
    }

    public static int e() {
        return c().getCurrentTargetDeviceType();
    }

    public static int f(int i3) {
        return c().getMachineType(i3);
    }

    public static String g(BaseQQAppInterface baseQQAppInterface) {
        return c().getNewVersionDatalineUin(baseQQAppInterface);
    }

    public static long h(BaseQQAppInterface baseQQAppInterface) {
        return c().getOfflineDelay(baseQQAppInterface);
    }

    public static long i(BaseQQAppInterface baseQQAppInterface) {
        return c().getOnlyOfflineLimitSize(baseQQAppInterface);
    }

    public static boolean j(BaseQQAppInterface baseQQAppInterface, long j3) {
        return c().isAutoDownloadOffline(baseQQAppInterface, j3);
    }

    public static boolean k(String str) {
        return c().isFileAssistantAio(str);
    }

    public static boolean l(BaseQQAppInterface baseQQAppInterface, RecentUser recentUser) {
        return c().isIgonreDataLineLogic(baseQQAppInterface, recentUser);
    }

    public static boolean m(MessageRecord messageRecord) {
        return c().isMessageSender(messageRecord);
    }

    public static boolean n(BaseQQAppInterface baseQQAppInterface) {
        return c().isNeedShowPadOpts(baseQQAppInterface);
    }

    public static boolean o() {
        return c().isNewVersionDataline();
    }

    public static boolean p(BaseQQAppInterface baseQQAppInterface) {
        return c().isNewVersionDataline(baseQQAppInterface);
    }

    public static boolean q(MessageRecord messageRecord) {
        return c().isOldDatalineMsgRecord(messageRecord);
    }

    public static void r(BaseQQAppInterface baseQQAppInterface) {
        c().notifyUpdateRecentFileAssistant(baseQQAppInterface);
    }

    public static void s(Context context) {
        c().openNewDatalineAio(context);
    }

    public static void t(Context context, Intent intent) {
        c().openNewDatalineAioSingle(context, intent);
    }

    @Deprecated
    public static void u() {
        c().openNewVersionDatalineSwitch();
    }

    public static void v(BaseQQAppInterface baseQQAppInterface, Intent intent, Bundle bundle) {
        c().reParseFileAssistantInfo(baseQQAppInterface, intent, bundle);
    }

    public static void w(BaseQQAppInterface baseQQAppInterface) {
        c().resetFileAssistantOnlineMark(baseQQAppInterface);
    }

    public static void x(MessageRecord messageRecord, int i3) {
        c().saveMessageDeviceType(messageRecord, i3);
    }

    public static void y(BaseQQAppInterface baseQQAppInterface, int i3, boolean z16) {
        c().setFileAssistantOnlineMark(baseQQAppInterface, i3, z16);
    }

    public static void z(int i3) {
        c().setSendTarget(i3);
    }
}
