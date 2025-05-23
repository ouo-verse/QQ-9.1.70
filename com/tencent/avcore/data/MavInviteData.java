package com.tencent.avcore.data;

import com.tencent.avcore.jni.data.MavAccountInfo;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes3.dex */
public class MavInviteData {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "MavInviteData";
    public ArrayList<AVInviteAccount> inviteAccountList;
    public int retCode;
    public String tip;

    public MavInviteData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static MavInviteData getInviteDataFromBuffer(byte[] bArr, int i3) {
        if (bArr == null) {
            if (AVCoreLog.isColorLevel()) {
                AVCoreLog.i(TAG, "getInviteDataFromBuffer detail is null");
            }
            return null;
        }
        if (i3 == 0) {
            if (AVCoreLog.isColorLevel()) {
                AVCoreLog.i(TAG, "getInviteDataFromBuffer buflen == 0");
            }
            return null;
        }
        MavInviteData mavInviteData = new MavInviteData();
        MavAccountInfo.MavInviteData mavInviteData2 = new MavAccountInfo.MavInviteData();
        try {
            mavInviteData2.mergeFrom(bArr);
            mavInviteData.retCode = mavInviteData2.friend_type.get();
            mavInviteData.tip = mavInviteData2.safe_tip.get();
            mavInviteData.inviteAccountList = new ArrayList<>();
            for (int i16 = 0; i16 < mavInviteData2.account_list.size(); i16++) {
                AVInviteAccount aVInviteAccount = new AVInviteAccount();
                aVInviteAccount.accountType = mavInviteData2.account_list.get(i16).account_type.get();
                aVInviteAccount.account = mavInviteData2.account_list.get(i16).account.get();
                TelInfo telInfo = new TelInfo();
                aVInviteAccount.msgTelInfo = telInfo;
                telInfo.nation = mavInviteData2.account_list.get(i16).tel_info.nation.get();
                aVInviteAccount.msgTelInfo.prefix = mavInviteData2.account_list.get(i16).tel_info.prefix.get();
                aVInviteAccount.msgTelInfo.mobile = mavInviteData2.account_list.get(i16).tel_info.mobile.get();
                aVInviteAccount.result = mavInviteData2.account_list.get(i16).result.get();
                aVInviteAccount.inviteType = mavInviteData2.account_list.get(i16).invite_type.get();
                mavInviteData.inviteAccountList.add(aVInviteAccount);
            }
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        AVCoreLog.e(TAG, String.format("getInviteDataFromBuffer retCode[%d], tips[%s]", Integer.valueOf(mavInviteData.retCode), mavInviteData.tip));
        return mavInviteData;
    }
}
