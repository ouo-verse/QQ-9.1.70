package com.tencent.mobileqq.profilecard.handler;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.profilecard.api.IProfileDataService;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.profilecard.api.ProfileContants;
import com.tencent.mobileqq.profilecard.api.impl.ProfileProtocolServiceImpl;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import com.tencent.mobileqq.profilecard.utils.ProfileCodecUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ev;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.ntrelation.friendsinfo.bean.d;
import hx3.c;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* loaded from: classes16.dex */
public class ProfileCardHandler extends BusinessHandler implements IProfileProtocolConst {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "ProfileCardHandler";

    public ProfileCardHandler(AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        }
    }

    private void handlerSetProfileDetailInner(Bundle bundle, Card card) {
        if (bundle.containsKey("nick")) {
            String string = bundle.getString("nick");
            card.strNick = string;
            saveRemark(string);
        }
        if (bundle.containsKey("sex")) {
            card.shGender = bundle.getByte("sex");
        }
        if (bundle.containsKey("birthday")) {
            card.lBirthday = bundle.getInt("birthday");
            card.age = (byte) bundle.getInt("age");
            card.constellation = bundle.getInt(IProfileProtocolConst.KEY_CONSTELLATION);
        }
        if (bundle.containsKey(IProfileProtocolConst.KEY_PROFESSION)) {
            card.iProfession = bundle.getInt(IProfileProtocolConst.KEY_PROFESSION);
        }
        if (bundle.containsKey(IProfileProtocolConst.KEY_COMPANY)) {
            card.strCompany = bundle.getString(IProfileProtocolConst.KEY_COMPANY);
        }
        if (bundle.containsKey(IProfileProtocolConst.KEY_COLLEGE)) {
            card.strSchool = bundle.getString(IProfileProtocolConst.KEY_COLLEGE);
        }
        if (bundle.containsKey("location")) {
            String[] stringArray = bundle.getStringArray("location");
            card.strLocationCodes = stringArray[0] + "-" + stringArray[1] + "-" + stringArray[2] + "-" + stringArray[3];
            card.strLocationDesc = bundle.getString(IProfileProtocolConst.KEY_LOCATION_DESC);
            String[] stringArray2 = bundle.getStringArray(IProfileProtocolConst.KEY_LOCATION_NAME);
            if (stringArray2 != null && stringArray2.length == 4) {
                card.strCountry = stringArray2[0];
                card.strProvince = stringArray2[1];
                card.strCity = stringArray2[2];
            }
        }
        if (bundle.containsKey(IProfileProtocolConst.KEY_HOMETOWN)) {
            String[] stringArray3 = bundle.getStringArray(IProfileProtocolConst.KEY_HOMETOWN);
            card.strHometownCodes = stringArray3[0] + "-" + stringArray3[1] + "-" + stringArray3[2] + "-" + stringArray3[3];
            card.strHometownDesc = bundle.getString(IProfileProtocolConst.KEY_HOMETOWN_DESC);
        }
        if (bundle.containsKey("email")) {
            card.strEmail = bundle.getString("email");
        }
        if (bundle.containsKey(IProfileProtocolConst.KEY_PERSONAL_NOTE)) {
            card.strPersonalNote = bundle.getString(IProfileProtocolConst.KEY_PERSONAL_NOTE);
        }
    }

    private void processProfileDetail1(ProfileDetailRecord profileDetailRecord, Bundle bundle) {
        if (bundle.containsKey("nick")) {
            String string = bundle.getString("nick");
            byte[] bytes = string.getBytes();
            short length = (short) bytes.length;
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, String.format("processProfileDetail1 nick=%s", string));
            }
            profileDetailRecord.fieldCount++;
            profileDetailRecord.contentSize += length + 4;
            profileDetailRecord.contentBuffer.putShort((short) 20002);
            profileDetailRecord.contentBuffer.putShort(length);
            profileDetailRecord.contentBuffer.put(bytes);
        }
        if (bundle.containsKey("sex")) {
            byte b16 = (byte) (bundle.getByte("sex") + 1);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, String.format("processProfileDetail1 sex=%s", Byte.valueOf(b16)));
            }
            profileDetailRecord.fieldCount++;
            profileDetailRecord.contentSize += 5;
            profileDetailRecord.contentBuffer.putShort(ProfileContants.FIELD_SEX);
            profileDetailRecord.contentBuffer.putShort((short) 1);
            profileDetailRecord.contentBuffer.put(b16);
        }
        if (bundle.containsKey("birthday")) {
            int i3 = bundle.getInt("birthday");
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, String.format("processProfileDetail1 birthday=%s", Integer.valueOf(i3)));
            }
            profileDetailRecord.fieldCount++;
            profileDetailRecord.contentSize += 8;
            profileDetailRecord.contentBuffer.putShort(ProfileContants.FIELD_SET_BIRTHDAY);
            profileDetailRecord.contentBuffer.putShort((short) 4);
            profileDetailRecord.contentBuffer.putInt(i3);
        }
        if (bundle.containsKey(IProfileProtocolConst.KEY_PROFESSION)) {
            int i16 = bundle.getInt(IProfileProtocolConst.KEY_PROFESSION);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, String.format("processProfileDetail1 jobId=%s", Integer.valueOf(i16)));
            }
            profileDetailRecord.fieldCount++;
            profileDetailRecord.contentSize += 8;
            profileDetailRecord.contentBuffer.putShort(ProfileContants.FIELD_PROFESSION);
            profileDetailRecord.contentBuffer.putShort((short) 4);
            profileDetailRecord.contentBuffer.putInt(i16);
        }
        if (bundle.containsKey(IProfileProtocolConst.KEY_COMPANY)) {
            String string2 = bundle.getString(IProfileProtocolConst.KEY_COMPANY);
            byte[] bytes2 = string2.getBytes();
            short length2 = (short) bytes2.length;
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, String.format("processProfileDetail1 company=%s", string2));
            }
            profileDetailRecord.fieldCount++;
            profileDetailRecord.contentSize += length2 + 4;
            profileDetailRecord.contentBuffer.putShort(ProfileContants.FIELD_COMPANY);
            profileDetailRecord.contentBuffer.putShort(length2);
            profileDetailRecord.contentBuffer.put(bytes2);
        }
    }

    private void processProfileDetail2(ProfileDetailRecord profileDetailRecord, Bundle bundle) {
        if (bundle.containsKey(IProfileProtocolConst.KEY_COLLEGE)) {
            String string = bundle.getString(IProfileProtocolConst.KEY_COLLEGE);
            byte[] bytes = string.getBytes();
            short length = (short) bytes.length;
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, String.format("processProfileDetail1 college=%s", string));
            }
            profileDetailRecord.fieldCount++;
            profileDetailRecord.contentSize += length + 4;
            profileDetailRecord.contentBuffer.putShort(ProfileContants.FIELD_COLLEGE);
            profileDetailRecord.contentBuffer.putShort(length);
            profileDetailRecord.contentBuffer.put(bytes);
        }
        if (bundle.containsKey("location")) {
            String[] stringArray = bundle.getStringArray("location");
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, String.format("processProfileDetail1 locationCodes=%s", Arrays.toString(stringArray)));
            }
            profileDetailRecord.fieldCount++;
            profileDetailRecord.contentSize += 16;
            profileDetailRecord.contentBuffer.putShort(ProfileContants.FIELD_QZONE_LOCATION).putShort((short) 12).putInt(ProfileCodecUtils.encodeLocCode(stringArray[0])).putInt(ProfileCodecUtils.encodeLocCode(stringArray[1])).putInt(ProfileCodecUtils.encodeLocCode(stringArray[2]));
            profileDetailRecord.fieldCount++;
            profileDetailRecord.contentSize += 8;
            profileDetailRecord.contentBuffer.putShort(ProfileContants.FIELD_QZONE_LOCATION_DISTRICT).putShort((short) 4).putInt(ProfileCodecUtils.encodeLocCode(stringArray[3]));
        }
        if (bundle.containsKey(IProfileProtocolConst.KEY_HOMETOWN)) {
            String[] stringArray2 = bundle.getStringArray(IProfileProtocolConst.KEY_HOMETOWN);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, String.format("processProfileDetail1 hometownCodes=%s", Arrays.toString(stringArray2)));
            }
            profileDetailRecord.fieldCount++;
            profileDetailRecord.contentSize += 16;
            profileDetailRecord.contentBuffer.putShort(ProfileContants.FIELD_QZONE_HOMETOWN).putShort((short) 12).putInt(ProfileCodecUtils.encodeLocCode(stringArray2[0])).putInt(ProfileCodecUtils.encodeLocCode(stringArray2[1])).putInt(ProfileCodecUtils.encodeLocCode(stringArray2[2]));
            profileDetailRecord.fieldCount++;
            profileDetailRecord.contentSize += 8;
            profileDetailRecord.contentBuffer.putShort(ProfileContants.FIELD_QZONE_HOMETOWN_DISTRICT).putShort((short) 4).putInt(ProfileCodecUtils.encodeLocCode(stringArray2[3]));
        }
        if (bundle.containsKey("email")) {
            String string2 = bundle.getString("email");
            byte[] bytes2 = string2.getBytes();
            short length2 = (short) bytes2.length;
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, String.format("processProfileDetail1 email=%s", string2));
            }
            profileDetailRecord.fieldCount++;
            profileDetailRecord.contentSize += length2 + 4;
            profileDetailRecord.contentBuffer.putShort(ProfileContants.FIELD_EMAIL).putShort(length2).put(bytes2);
        }
        if (bundle.containsKey(IProfileProtocolConst.KEY_PERSONAL_NOTE)) {
            String string3 = bundle.getString(IProfileProtocolConst.KEY_PERSONAL_NOTE);
            byte[] bytes3 = string3.getBytes();
            short length3 = (short) bytes3.length;
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, String.format("processProfileDetail1 note=%s", string3));
            }
            profileDetailRecord.fieldCount++;
            profileDetailRecord.contentSize += length3 + 4;
            profileDetailRecord.contentBuffer.putShort(ProfileContants.FIELD_PERSONAL_NOTE).putShort(length3).put(bytes3);
        }
    }

    private void saveRemark(String str) {
        IFriendsInfoService iFriendsInfoService = (IFriendsInfoService) QRoute.api(IFriendsInfoService.class);
        String b16 = ev.b(this.appRuntime.getCurrentUin());
        String remarkWithUid = iFriendsInfoService.getRemarkWithUid(b16, TAG);
        d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(b16, TAG);
        if (remarkWithUid == null) {
            QLog.d(TAG, 1, "handlerSetProfileDetailInner, oldRemark is null");
            remarkWithUid = "";
        }
        if (!remarkWithUid.equals(str) && friendsSimpleInfoWithUid != null) {
            d dVar = new d(b16, this.appRuntime.getCurrentUin());
            dVar.M();
            dVar.m0(str);
            dVar.g0(System.currentTimeMillis());
            iFriendsInfoService.accurateUpdateNTFriendSimpleInfo(dVar, TAG, (c<d>) null);
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Set) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add(IProfileProtocolConst.CMD_SET_PROFILE_DETAIL);
            this.allowCmdSet.add(IProfileProtocolConst.CMD_GET_PROFILE_DETAIL);
        }
        return this.allowCmdSet;
    }

    protected void handlerGetProfileDetail(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        int resultCode = fromServiceMsg.getResultCode();
        ProfileProtocolServiceImpl.getProfileProtocolService(this.appRuntime).responseGetProfileDetail(toServiceMsg.extraData, fromServiceMsg.isSuccess(), resultCode, obj);
    }

    protected void handlerSetProfileDetail(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        int resultCode = fromServiceMsg.getResultCode();
        boolean isSuccess = fromServiceMsg.isSuccess();
        Card card = null;
        if (isSuccess) {
            try {
                oidb_sso$OIDBSSOPkg mergeFrom = new oidb_sso$OIDBSSOPkg().mergeFrom((byte[]) obj);
                if (mergeFrom.uint32_result.has()) {
                    int i3 = mergeFrom.uint32_result.get();
                    if (i3 == 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    resultCode = i3;
                    isSuccess = z16;
                } else {
                    isSuccess = false;
                }
                if (isSuccess) {
                    IProfileDataService iProfileDataService = (IProfileDataService) this.appRuntime.getRuntimeService(IProfileDataService.class, "all");
                    card = iProfileDataService.getProfileCard(this.appRuntime.getCurrentUin(), true);
                    handlerSetProfileDetailInner(toServiceMsg.extraData, card);
                    iProfileDataService.saveProfileCard(card);
                }
            } catch (Exception e16) {
                QLog.e(TAG, 1, "handlerSetProfileDetail fail.", e16);
                isSuccess = false;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("handlerSetProfileDetail success=%s resultCode=%s", Boolean.valueOf(isSuccess), Integer.valueOf(resultCode)));
        }
        notifyUI(1003, isSuccess, new Object[]{Integer.valueOf(resultCode), card});
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Class) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return ProfileCardObserver.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        String serviceCmd = fromServiceMsg.getServiceCmd();
        if (msgCmdFilter(serviceCmd)) {
            return;
        }
        if (IProfileProtocolConst.CMD_SET_PROFILE_DETAIL.equals(serviceCmd)) {
            handlerSetProfileDetail(toServiceMsg, fromServiceMsg, obj);
        } else if (IProfileProtocolConst.CMD_GET_PROFILE_DETAIL.equals(serviceCmd)) {
            handlerGetProfileDetail(toServiceMsg, fromServiceMsg, obj);
        }
    }

    public void setProfileDetail(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) bundle);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("setProfileDetail params=%s", bundle));
        }
        String currentUin = this.appRuntime.getCurrentUin();
        ProfileDetailRecord profileDetailRecord = new ProfileDetailRecord(null);
        processProfileDetail1(profileDetailRecord, bundle);
        processProfileDetail2(profileDetailRecord, bundle);
        if (profileDetailRecord.fieldCount == 0) {
            notifyUI(1003, true, new Object[]{0, ((IProfileDataService) this.appRuntime.getRuntimeService(IProfileDataService.class, "all")).getProfileCard(currentUin, true)});
            return;
        }
        ByteBuffer allocate = ByteBuffer.allocate(profileDetailRecord.contentSize + 7);
        allocate.putInt((int) Long.parseLong(currentUin));
        allocate.put((byte) 0);
        allocate.putShort((short) profileDetailRecord.fieldCount);
        allocate.put(profileDetailRecord.contentBuffer.array(), 0, profileDetailRecord.contentSize);
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(1279);
        oidb_sso_oidbssopkg.uint32_service_type.set(9);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(allocate.array()));
        ToServiceMsg createToServiceMsg = createToServiceMsg(IProfileProtocolConst.CMD_SET_PROFILE_DETAIL);
        createToServiceMsg.extraData.putAll(bundle);
        createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
        sendPbReq(createToServiceMsg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes16.dex */
    public static class ProfileDetailRecord {
        static IPatchRedirector $redirector_;
        public ByteBuffer contentBuffer;
        public int contentSize;
        public int fieldCount;

        ProfileDetailRecord() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.fieldCount = 0;
            this.contentSize = 0;
            this.contentBuffer = ByteBuffer.allocate(1000);
        }

        /* synthetic */ ProfileDetailRecord(AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) anonymousClass1);
        }
    }
}
