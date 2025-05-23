package com.tencent.mobileqq.filemanager.api.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.filemanager.api.IQFileAssistantUtils;
import com.tencent.mobileqq.filemanager.fileassistant.util.QQFileAssistantUtils;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtilImpl;
import msf.msgcomm.msg_comm$Msg;

/* compiled from: P */
/* loaded from: classes12.dex */
public class QFileAssistantUtilsImpl implements IQFileAssistantUtils {
    @Override // com.tencent.mobileqq.filemanager.api.IQFileAssistantUtils
    public boolean checkNotifyDeviceOnline(BaseQQAppInterface baseQQAppInterface) {
        return QQFileAssistantUtils.a(baseQQAppInterface);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQFileAssistantUtils
    public int decodeMessageDeviceType(msg_comm$Msg msg_comm_msg) {
        return QQFileAssistantUtils.b(msg_comm_msg);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQFileAssistantUtils
    public int getCurrentDeviceType() {
        return QQFileAssistantUtils.c();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQFileAssistantUtils
    public int getCurrentTargetDeviceType() {
        return QQFileAssistantUtils.d();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQFileAssistantUtils
    public int getMachineHeadResId(int i3) {
        return QQFileAssistantUtils.f(i3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQFileAssistantUtils
    public String getMachineNickName(Context context, int i3) {
        return QQFileAssistantUtils.g(context, i3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQFileAssistantUtils
    public int getMachineType(int i3) {
        return QQFileAssistantUtils.h(i3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQFileAssistantUtils
    public String getNewVersionDatalineUin(BaseQQAppInterface baseQQAppInterface) {
        return QQFileAssistantUtils.i(baseQQAppInterface);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQFileAssistantUtils
    public long getOfflineDelay(BaseQQAppInterface baseQQAppInterface) {
        return QQFileAssistantUtils.j(baseQQAppInterface);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQFileAssistantUtils
    public long getOnlyOfflineLimitSize(BaseQQAppInterface baseQQAppInterface) {
        return QQFileAssistantUtils.k(baseQQAppInterface);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQFileAssistantUtils
    public boolean isAutoDownloadOffline(BaseQQAppInterface baseQQAppInterface, long j3) {
        return QQFileAssistantUtils.l(baseQQAppInterface, j3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQFileAssistantUtils
    public boolean isFileAssistantAio(String str) {
        return QQFileAssistantUtils.n(str);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQFileAssistantUtils
    public boolean isIgonreDataLineLogic(BaseQQAppInterface baseQQAppInterface, RecentUser recentUser) {
        return QQFileAssistantUtils.p(baseQQAppInterface, recentUser);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQFileAssistantUtils
    public boolean isMessageSender(MessageRecord messageRecord) {
        return QQFileAssistantUtils.q(messageRecord);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQFileAssistantUtils
    public boolean isNeedShowPadOpts(BaseQQAppInterface baseQQAppInterface) {
        return QQFileAssistantUtils.r(baseQQAppInterface);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQFileAssistantUtils
    public boolean isNewVersionDataline() {
        return QQFileAssistantUtils.s();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQFileAssistantUtils
    public boolean isOldDatalineMsgRecord(MessageRecord messageRecord) {
        return QQFileAssistantUtils.u(messageRecord);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQFileAssistantUtils
    public void notifyUpdateRecentFileAssistant(BaseQQAppInterface baseQQAppInterface) {
        QQFileAssistantUtils.v(baseQQAppInterface);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQFileAssistantUtils
    public void openNewDatalineAio(Context context) {
        QQFileAssistantUtils.w(context);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQFileAssistantUtils
    public void openNewDatalineAioSingle(Context context, Intent intent) {
        QQFileAssistantUtils.y(context, intent);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQFileAssistantUtils
    public void openNewVersionDatalineSwitch() {
        QQFileAssistantUtils.D(QQFileManagerUtilImpl.A0());
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQFileAssistantUtils
    public void reParseFileAssistantInfo(BaseQQAppInterface baseQQAppInterface, Intent intent, Bundle bundle) {
        QQFileAssistantUtils.z(baseQQAppInterface, intent, bundle);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQFileAssistantUtils
    public void resetFileAssistantOnlineMark(BaseQQAppInterface baseQQAppInterface) {
        QQFileAssistantUtils.A(baseQQAppInterface);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQFileAssistantUtils
    public void saveMessageDeviceType(MessageRecord messageRecord, int i3) {
        QQFileAssistantUtils.B(messageRecord, i3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQFileAssistantUtils
    public void setFileAssistantOnlineMark(BaseQQAppInterface baseQQAppInterface, int i3, boolean z16) {
        QQFileAssistantUtils.C(baseQQAppInterface, i3, z16);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQFileAssistantUtils
    public void setSendTarget(int i3) {
        QQFileAssistantUtils.E(i3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQFileAssistantUtils
    public boolean userOfflineOnly(BaseQQAppInterface baseQQAppInterface, long j3) {
        return QQFileAssistantUtils.F(baseQQAppInterface, j3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQFileAssistantUtils
    public boolean isNewVersionDataline(BaseQQAppInterface baseQQAppInterface) {
        return QQFileAssistantUtils.t(baseQQAppInterface);
    }
}
