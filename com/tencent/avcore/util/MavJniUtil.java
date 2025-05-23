package com.tencent.avcore.util;

import com.tencent.avcore.jni.data.AVUserInfo;
import com.tencent.avcore.jni.data.MavAccountInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes3.dex */
public class MavJniUtil {
    static IPatchRedirector $redirector_ = null;
    static final String TAG = "MavJniUtil";

    public MavJniUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static AVUserInfo getAVInfoFromByte(byte[] bArr) {
        if (bArr == null) {
            AVCoreLog.e(TAG, "getAVInfoFromByte buf is null");
            return null;
        }
        MavAccountInfo.MavUserInfo mavUserInfo = new MavAccountInfo.MavUserInfo();
        try {
            mavUserInfo.mergeFrom(bArr);
            AVUserInfo aVUserInfo = new AVUserInfo();
            aVUserInfo.account = mavUserInfo.account.get();
            aVUserInfo.accountType = mavUserInfo.account_type.get();
            aVUserInfo.openId = mavUserInfo.open_id.get();
            aVUserInfo.pstnStatus = mavUserInfo.pstn_status.get();
            aVUserInfo.micAuthByAdmin = mavUserInfo.mic_auth.get();
            aVUserInfo.extInfoType = mavUserInfo.ext_business_type.get();
            aVUserInfo.extBusinessInfo = mavUserInfo.ext_business_info.get();
            aVUserInfo.netLevel = mavUserInfo.net_level.get();
            aVUserInfo.commonTipsInfo = mavUserInfo.common_tips_info.get();
            return aVUserInfo;
        } catch (InvalidProtocolBufferMicroException e16) {
            AVCoreLog.e(TAG, "getAVInfoFromByte parse PB failed");
            e16.printStackTrace();
            return null;
        }
    }

    public static ArrayList<AVUserInfo> getAVInfoListFromByte(byte[] bArr) {
        if (bArr == null) {
            AVCoreLog.e(TAG, "getAVInfoListFromByte buf is null");
            return null;
        }
        MavAccountInfo.MavUserInfoList mavUserInfoList = new MavAccountInfo.MavUserInfoList();
        try {
            mavUserInfoList.mergeFrom(bArr);
            ArrayList<AVUserInfo> arrayList = new ArrayList<>();
            if (mavUserInfoList.mav_user_infos.has() && mavUserInfoList.mav_user_infos.size() > 0) {
                for (int i3 = 0; i3 < mavUserInfoList.mav_user_infos.size(); i3++) {
                    AVUserInfo aVUserInfo = new AVUserInfo();
                    aVUserInfo.account = mavUserInfoList.mav_user_infos.get(i3).account.get();
                    aVUserInfo.accountType = mavUserInfoList.mav_user_infos.get(i3).account_type.get();
                    aVUserInfo.openId = mavUserInfoList.mav_user_infos.get(i3).open_id.get();
                    aVUserInfo.pstnStatus = mavUserInfoList.mav_user_infos.get(i3).pstn_status.get();
                    aVUserInfo.micAuthByAdmin = mavUserInfoList.mav_user_infos.get(i3).mic_auth.get();
                    aVUserInfo.extInfoType = mavUserInfoList.mav_user_infos.get(i3).ext_business_type.get();
                    aVUserInfo.extBusinessInfo = mavUserInfoList.mav_user_infos.get(i3).ext_business_info.get();
                    aVUserInfo.netLevel = mavUserInfoList.mav_user_infos.get(i3).net_level.get();
                    aVUserInfo.commonTipsInfo = mavUserInfoList.mav_user_infos.get(i3).common_tips_info.get();
                    arrayList.add(aVUserInfo);
                }
            }
            return arrayList;
        } catch (InvalidProtocolBufferMicroException e16) {
            AVCoreLog.e(TAG, "getAVInfoListFromByte parse PB failed");
            e16.printStackTrace();
            return null;
        }
    }

    public static int getIntFromByte(byte[] bArr) {
        int i3 = 0;
        for (int i16 = 0; i16 < 4; i16++) {
            int i17 = 3 - i16;
            i3 |= (bArr[i17] & 255) << (i17 * 4);
        }
        return i3;
    }

    public static long getLongFromByte(byte[] bArr) {
        long j3 = 0;
        for (int i3 = 0; i3 < 8; i3++) {
            j3 |= (bArr[r4] & 255) << ((7 - i3) * 8);
        }
        return j3;
    }

    public static String getStringFromByte(byte[] bArr) {
        return new String(bArr);
    }

    public static String[] getUinListFromBuf(byte[] bArr) {
        if (bArr == null) {
            AVCoreLog.e(TAG, "getUinListFromBuf buf is null");
            return null;
        }
        MavAccountInfo.AccountList accountList = new MavAccountInfo.AccountList();
        try {
            accountList.mergeFrom(bArr);
            if (accountList.account.has() && accountList.account.size() > 0) {
                int size = accountList.account.size();
                String[] strArr = new String[size];
                for (int i3 = 0; i3 < size; i3++) {
                    strArr[i3] = accountList.account.get(i3);
                }
                return strArr;
            }
        } catch (InvalidProtocolBufferMicroException e16) {
            AVCoreLog.e(TAG, "getUinListFromBuf parse PB failed");
            e16.printStackTrace();
        }
        return null;
    }
}
