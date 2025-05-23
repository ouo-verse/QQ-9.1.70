package com.qwallet.temp.impl;

import com.qwallet.temp.IIndividualRedPacket;
import com.tencent.mobileqq.app.IndividualRedPacketManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.qwallet.hb.aio.elem.RedPacketInfo;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

/* loaded from: classes39.dex */
public class IndividualRedPacketImpl implements IIndividualRedPacket {
    private QQAppInterface mApp;

    private boolean checkAppRuntimeInValid() {
        if (QLog.isColorLevel()) {
            Object[] objArr = new Object[2];
            objArr[0] = "checkAppRuntimeInValid: ";
            objArr[1] = Boolean.valueOf(this.mApp == null);
            QLog.d("IndividualRedPacketImpl", 2, objArr);
        }
        return this.mApp == null;
    }

    private IndividualRedPacketManager getManager() {
        return (IndividualRedPacketManager) this.mApp.getManager(QQManagerFactory.INDIVIDUAL_RED_PACKET_MANAGER);
    }

    @Override // com.qwallet.temp.IIndividualRedPacket
    public void dealRedPacketToShow(RedPacketInfo redPacketInfo) {
        IndividualRedPacketManager.i(this.mApp, getManager(), redPacketInfo);
    }

    @Override // com.qwallet.temp.IIndividualRedPacket
    public boolean getIndividualRedPacketEnable() {
        if (checkAppRuntimeInValid()) {
            return false;
        }
        return getManager().v();
    }

    @Override // com.qwallet.temp.IIndividualRedPacket
    public String getMallURL(int i3) {
        return IndividualRedPacketManager.z(i3, this.mApp);
    }

    @Override // com.qwallet.temp.IIndividualRedPacket
    public int getRedPacketCannotUseFlag() {
        return 0;
    }

    @Override // com.qwallet.temp.IIndividualRedPacket
    public int getRedPacketEnableFlag() {
        return 0;
    }

    @Override // com.qwallet.temp.IIndividualRedPacket
    public String getTenpayCombineImg(String str, String str2) {
        if (checkAppRuntimeInValid()) {
            return null;
        }
        return getManager().D(str, str2);
    }

    @Override // com.qwallet.temp.IIndividualRedPacket
    public boolean isAllowShowRedpacket() {
        if (checkAppRuntimeInValid()) {
            return false;
        }
        return getManager().F();
    }

    @Override // com.qwallet.temp.IIndividualRedPacket
    public boolean isIndividualRedPacketEnable() {
        if (checkAppRuntimeInValid()) {
            return false;
        }
        return getManager().H();
    }

    @Override // com.qwallet.temp.IIndividualRedPacket
    public boolean isSDCardError() {
        if (checkAppRuntimeInValid()) {
            return false;
        }
        return getManager().G.get();
    }

    @Override // com.qwallet.temp.IIndividualRedPacket
    public boolean isShowRedpacket() {
        if (checkAppRuntimeInValid()) {
            return false;
        }
        return getManager().u().f311362j;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        if (appRuntime instanceof QQAppInterface) {
            this.mApp = (QQAppInterface) appRuntime;
        }
    }

    @Override // com.qwallet.temp.IIndividualRedPacket
    public void setRedPacketFlags(int i3, int i16, boolean z16) {
        if (checkAppRuntimeInValid()) {
            return;
        }
        getManager().Q(i3, i16, z16);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
    }
}
