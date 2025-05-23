package com.tencent.biz.pubaccount.accountdetail.api.impl;

import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail;
import com.tencent.biz.pubaccount.api.IPublicAccountConfigAttr;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.mp.mobileqq_mp$ButtonInfo;
import com.tencent.mobileqq.mp.mobileqq_mp$ConfigGroupInfo;
import com.tencent.mobileqq.mp.mobileqq_mp$ConfigInfo;
import com.tencent.mobileqq.mp.mobileqq_mp$GetPublicAccountDetailInfoResponse;
import com.tencent.mobileqq.mp.mobileqq_mp$GetPublicAccountMenuResponse;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.pb.oac.OACProfilePb$ProfileDataRsp;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes32.dex */
public class PublicAccountDetailImpl extends Entity implements IPublicAccountDetail {

    @notColumn
    public static final int ANCIENT = 0;

    @notColumn
    public static final int VERSION_839 = 1;
    public byte[] accountData;
    public int accountFlag;
    public long accountFlag2;

    @notColumn
    public int cardStyle;
    public String certifiedDescription;

    @notColumn
    public String certifiedEnterprise;
    public int certifiedGrade;

    @notColumn
    public String certifiedWeixin;
    public String configBackgroundColor;

    @notColumn
    public String configBackgroundImg;

    @notColumn
    public List<IPublicAccountConfigAttr> customConfigAttrs;
    public String displayNumber;
    public int followType;

    @notColumn
    public List<IPublicAccountConfigAttr> fullscreenConfigAttrs;
    public int groupId;
    public List<mobileqq_mp$ConfigGroupInfo> groupInfoList;
    public boolean isAgreeSyncLbs;
    public boolean isConfirmed;
    public boolean isMute;
    public boolean isRecvMsg;
    public boolean isRecvPush;
    public boolean isShowFollowButton;
    public boolean isShowShareButton;
    public boolean isSyncLbs;
    public boolean isSyncLbsSelected;
    public String lastHistoryMsg;
    public int mShowMsgFlag;

    @notColumn
    public mobileqq_mp$GetPublicAccountMenuResponse menuButtonResp;
    public String name;
    public List<mobileqq_mp$ConfigGroupInfo> newGroupInfoList;

    @notColumn
    public List<IPublicAccountConfigAttr> paConfigAttrs;
    public byte[] protocol839Data;
    public int protocolVersion;
    public int seqno;
    public int sharedFollowerCount;
    public int showFlag;
    public String summary;
    public String uid;

    @unique
    public String uin;

    @notColumn
    public String unifiedDesrpition;

    public PublicAccountDetailImpl() {
        this.seqno = 0;
        this.name = HardCodeUtil.qqStr(R.string.j0z);
        this.summary = HardCodeUtil.qqStr(R.string.f171539j12);
        this.displayNumber = "";
        this.isRecvMsg = false;
        this.isShowShareButton = false;
        this.isShowFollowButton = false;
        this.isMute = false;
        this.followType = 0;
        this.groupId = 0;
        this.accountData = null;
        this.isRecvPush = false;
        this.isSyncLbs = false;
        this.isAgreeSyncLbs = false;
        this.certifiedGrade = 0;
        this.showFlag = 0;
        this.accountFlag = 0;
        this.accountFlag2 = 0L;
        this.isConfirmed = false;
        this.mShowMsgFlag = -1;
        this.configBackgroundColor = "3d7fe3";
        this.certifiedDescription = "";
        this.isSyncLbsSelected = false;
        this.lastHistoryMsg = null;
        this.protocolVersion = 0;
        this.protocol839Data = null;
        this.sharedFollowerCount = 0;
        this.configBackgroundImg = "";
        this.cardStyle = 0;
        this.certifiedEnterprise = "";
        this.certifiedWeixin = "";
    }

    @Override // com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail
    public void clone(IPublicAccountDetail iPublicAccountDetail) {
        PublicAccountDetailImpl publicAccountDetailImpl = (PublicAccountDetailImpl) iPublicAccountDetail;
        this.uin = publicAccountDetailImpl.uin;
        this.seqno = publicAccountDetailImpl.seqno;
        this.name = publicAccountDetailImpl.name;
        this.summary = publicAccountDetailImpl.summary;
        this.isRecvMsg = publicAccountDetailImpl.isRecvMsg;
        this.followType = publicAccountDetailImpl.followType;
        this.isShowFollowButton = publicAccountDetailImpl.isShowFollowButton;
        this.accountData = publicAccountDetailImpl.accountData;
        this.groupInfoList = publicAccountDetailImpl.groupInfoList;
        this.displayNumber = publicAccountDetailImpl.displayNumber;
        this.groupId = publicAccountDetailImpl.groupId;
        this.isRecvPush = publicAccountDetailImpl.isRecvPush;
        this.isSyncLbs = publicAccountDetailImpl.isSyncLbs;
        this.certifiedGrade = publicAccountDetailImpl.certifiedGrade;
        this.showFlag = publicAccountDetailImpl.showFlag;
        this.accountFlag = publicAccountDetailImpl.accountFlag;
        this.accountFlag2 = publicAccountDetailImpl.accountFlag2;
        this.uid = publicAccountDetailImpl.uid;
        this.mShowMsgFlag = publicAccountDetailImpl.mShowMsgFlag;
        this.configBackgroundColor = publicAccountDetailImpl.configBackgroundColor;
        this.configBackgroundImg = publicAccountDetailImpl.configBackgroundImg;
        this.newGroupInfoList = publicAccountDetailImpl.newGroupInfoList;
        this.certifiedDescription = publicAccountDetailImpl.certifiedDescription;
        this.isAgreeSyncLbs = publicAccountDetailImpl.isAgreeSyncLbs;
        this.isSyncLbsSelected = publicAccountDetailImpl.isSyncLbsSelected;
        this.unifiedDesrpition = publicAccountDetailImpl.unifiedDesrpition;
        this.paConfigAttrs = publicAccountDetailImpl.paConfigAttrs;
        this.customConfigAttrs = publicAccountDetailImpl.customConfigAttrs;
        this.fullscreenConfigAttrs = publicAccountDetailImpl.fullscreenConfigAttrs;
        this.cardStyle = publicAccountDetailImpl.cardStyle;
        this.menuButtonResp = publicAccountDetailImpl.menuButtonResp;
        this.protocolVersion = publicAccountDetailImpl.protocolVersion;
        this.protocol839Data = publicAccountDetailImpl.protocol839Data;
        this.sharedFollowerCount = publicAccountDetailImpl.sharedFollowerCount;
        this.isMute = publicAccountDetailImpl.isMute;
    }

    @Override // com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail
    public byte[] getAccountData() {
        return this.accountData;
    }

    @Override // com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail
    public int getAccountFlag() {
        return this.accountFlag;
    }

    @Override // com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail
    public long getAccountFlag2() {
        return this.accountFlag2;
    }

    public List<mobileqq_mp$ButtonInfo> getButtonInfo() {
        mobileqq_mp$GetPublicAccountMenuResponse mobileqq_mp_getpublicaccountmenuresponse = this.menuButtonResp;
        if (mobileqq_mp_getpublicaccountmenuresponse != null) {
            return mobileqq_mp_getpublicaccountmenuresponse.button_info.get();
        }
        if (this.protocol839Data != null) {
            OACProfilePb$ProfileDataRsp oACProfilePb$ProfileDataRsp = new OACProfilePb$ProfileDataRsp();
            try {
                oACProfilePb$ProfileDataRsp.mergeFrom(this.protocol839Data);
                mobileqq_mp$GetPublicAccountMenuResponse mobileqq_mp_getpublicaccountmenuresponse2 = oACProfilePb$ProfileDataRsp.menu_rsp;
                this.menuButtonResp = mobileqq_mp_getpublicaccountmenuresponse2;
                return mobileqq_mp_getpublicaccountmenuresponse2.button_info.get();
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    @Override // com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail
    public long getCertifiedGrade() {
        return this.certifiedGrade;
    }

    @Override // com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail
    public String getDisplayNumber() {
        return this.displayNumber;
    }

    @Override // com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail
    public int getFollowType() {
        return this.followType;
    }

    @Override // com.tencent.mobileqq.persistence.Entity, com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail
    public long getId() {
        return super.getId();
    }

    @Override // com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail
    public String getName() {
        return this.name;
    }

    @Override // com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail
    public int getReportAccountType(AppInterface appInterface, String str) {
        return getReportAccountType(appInterface, str, null);
    }

    @Override // com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail
    public int getShowFlag() {
        return this.showFlag;
    }

    @Override // com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail
    public int getShowMsgFlag() {
        return this.showFlag;
    }

    @Override // com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail
    public String getSummary() {
        return this.summary;
    }

    @Override // com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail
    public String getUid() {
        return this.uid;
    }

    @Override // com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail
    public String getUin() {
        return this.uin;
    }

    @Override // com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail
    public IPublicAccountDetail init(mobileqq_mp$GetPublicAccountDetailInfoResponse mobileqq_mp_getpublicaccountdetailinforesponse) {
        this.uin = "" + (mobileqq_mp_getpublicaccountdetailinforesponse.uin.get() & 4294967295L);
        this.seqno = mobileqq_mp_getpublicaccountdetailinforesponse.seqno.get();
        this.name = mobileqq_mp_getpublicaccountdetailinforesponse.name.get();
        this.summary = mobileqq_mp_getpublicaccountdetailinforesponse.summary.get();
        this.isRecvMsg = mobileqq_mp_getpublicaccountdetailinforesponse.is_recv_msg.get();
        this.isShowFollowButton = mobileqq_mp_getpublicaccountdetailinforesponse.is_show_follow_button.get();
        this.isShowShareButton = mobileqq_mp_getpublicaccountdetailinforesponse.is_show_share_button.get();
        this.groupInfoList = mobileqq_mp_getpublicaccountdetailinforesponse.config_group_info.get();
        this.followType = mobileqq_mp_getpublicaccountdetailinforesponse.follow_type.get();
        this.displayNumber = mobileqq_mp_getpublicaccountdetailinforesponse.display_number.get();
        this.groupId = mobileqq_mp_getpublicaccountdetailinforesponse.group_id.get();
        this.isRecvPush = mobileqq_mp_getpublicaccountdetailinforesponse.is_recv_push.get();
        this.certifiedGrade = mobileqq_mp_getpublicaccountdetailinforesponse.certified_grade.get();
        this.showFlag = mobileqq_mp_getpublicaccountdetailinforesponse.show_flag.get();
        this.accountFlag = mobileqq_mp_getpublicaccountdetailinforesponse.account_flag.get();
        this.accountFlag2 = mobileqq_mp_getpublicaccountdetailinforesponse.account_flag2.get();
        this.uid = mobileqq_mp_getpublicaccountdetailinforesponse.account_uid.get();
        this.accountData = mobileqq_mp_getpublicaccountdetailinforesponse.toByteArray();
        this.configBackgroundColor = mobileqq_mp_getpublicaccountdetailinforesponse.config_background_color.get();
        this.configBackgroundImg = mobileqq_mp_getpublicaccountdetailinforesponse.config_background_img.get();
        this.newGroupInfoList = mobileqq_mp_getpublicaccountdetailinforesponse.config_group_info_new.get();
        this.certifiedDescription = mobileqq_mp_getpublicaccountdetailinforesponse.certified_description.get();
        if (mobileqq_mp_getpublicaccountdetailinforesponse.unified_account_descrpition.has()) {
            this.unifiedDesrpition = mobileqq_mp_getpublicaccountdetailinforesponse.unified_account_descrpition.get();
        }
        parser();
        this.mShowMsgFlag = -1;
        if (this.unifiedDesrpition != null) {
            initShowMsgFlag_v5_9();
            initLbsItem_v5_9();
        } else {
            initShowMsgFlag(mobileqq_mp_getpublicaccountdetailinforesponse);
            initLbsItem(mobileqq_mp_getpublicaccountdetailinforesponse);
        }
        this.protocolVersion = 0;
        return this;
    }

    void initLbsItem(mobileqq_mp$GetPublicAccountDetailInfoResponse mobileqq_mp_getpublicaccountdetailinforesponse) {
        boolean z16;
        List<mobileqq_mp$ConfigGroupInfo> list;
        if (mobileqq_mp_getpublicaccountdetailinforesponse.config_group_info_new.has() && !mobileqq_mp_getpublicaccountdetailinforesponse.config_group_info_new.isEmpty() && (list = mobileqq_mp_getpublicaccountdetailinforesponse.config_group_info_new.get()) != null && list.size() > 0) {
            z16 = false;
            for (mobileqq_mp$ConfigGroupInfo mobileqq_mp_configgroupinfo : list) {
                if (mobileqq_mp_configgroupinfo.config_info.has() && !mobileqq_mp_configgroupinfo.config_info.isEmpty()) {
                    for (mobileqq_mp$ConfigInfo mobileqq_mp_configinfo : mobileqq_mp_configgroupinfo.config_info.get()) {
                        if (mobileqq_mp_configinfo.type.has() && mobileqq_mp_configinfo.type.get() == 2 && mobileqq_mp_configinfo.state_id.has() && mobileqq_mp_configinfo.state_id.get() == 3) {
                            z16 = true;
                            this.isSyncLbs = true;
                            if (mobileqq_mp_configinfo.state.has()) {
                                int i3 = mobileqq_mp_configinfo.state.get();
                                if (i3 == 0) {
                                    this.isSyncLbsSelected = false;
                                    this.isAgreeSyncLbs = false;
                                } else if (i3 == 1) {
                                    this.isSyncLbsSelected = true;
                                    this.isAgreeSyncLbs = true;
                                } else if (i3 != 2) {
                                    if (QLog.isColorLevel()) {
                                        QLog.e("EqqDetail", 2, "Error Eqq lbs state value: " + mobileqq_mp_configinfo.state.get());
                                    }
                                } else {
                                    this.isSyncLbsSelected = true;
                                    this.isAgreeSyncLbs = false;
                                }
                            }
                        }
                    }
                }
                if (z16) {
                    break;
                }
            }
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        this.isSyncLbs = false;
    }

    void initLbsItem_v5_9() {
        List<IPublicAccountConfigAttr> list = this.paConfigAttrs;
        if (list == null) {
            return;
        }
        boolean z16 = false;
        for (IPublicAccountConfigAttr iPublicAccountConfigAttr : list) {
            if (iPublicAccountConfigAttr.getType() != 1 && iPublicAccountConfigAttr.getConfigs() != null) {
                for (IPublicAccountConfigAttr.a aVar : iPublicAccountConfigAttr.getConfigs()) {
                    if (aVar.f79329a == 2 && aVar.f79335g == 3) {
                        this.isSyncLbs = true;
                        int i3 = aVar.f79334f;
                        if (i3 == 0) {
                            this.isSyncLbsSelected = false;
                            this.isAgreeSyncLbs = false;
                        } else if (i3 == 1) {
                            this.isSyncLbsSelected = true;
                            this.isAgreeSyncLbs = true;
                        } else if (i3 != 2) {
                            if (QLog.isColorLevel()) {
                                QLog.e("EqqDetail", 2, "Error Eqq lbs state value: " + aVar.f79334f);
                            }
                        } else {
                            this.isSyncLbsSelected = true;
                            this.isAgreeSyncLbs = false;
                        }
                        z16 = true;
                    }
                    if (z16) {
                        break;
                    }
                }
                if (z16) {
                    break;
                }
            }
        }
        if (z16) {
            return;
        }
        this.isSyncLbs = false;
    }

    void initShowMsgFlag(mobileqq_mp$GetPublicAccountDetailInfoResponse mobileqq_mp_getpublicaccountdetailinforesponse) {
        if (mobileqq_mp_getpublicaccountdetailinforesponse.config_group_info.has()) {
            parserMsgFlag(mobileqq_mp_getpublicaccountdetailinforesponse.config_group_info.get());
        }
        if (mobileqq_mp_getpublicaccountdetailinforesponse.config_group_info_new.has()) {
            parserMsgFlag(mobileqq_mp_getpublicaccountdetailinforesponse.config_group_info_new.get());
        }
    }

    void initShowMsgFlag_v5_9() {
        List<IPublicAccountConfigAttr> list = this.paConfigAttrs;
        if (list == null) {
            return;
        }
        boolean z16 = false;
        for (IPublicAccountConfigAttr iPublicAccountConfigAttr : list) {
            if (iPublicAccountConfigAttr.getType() != 1 && iPublicAccountConfigAttr.getConfigs() != null) {
                Iterator<IPublicAccountConfigAttr.a> it = iPublicAccountConfigAttr.getConfigs().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    IPublicAccountConfigAttr.a next = it.next();
                    if (next.f79335g == 5) {
                        this.mShowMsgFlag = next.f79334f == 1 ? 1 : 0;
                        z16 = true;
                    }
                }
                if (z16) {
                    return;
                }
            }
        }
    }

    @Override // com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail
    public boolean isAgreeSyncLbs() {
        return this.isAgreeSyncLbs;
    }

    @Override // com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail
    public boolean isRecvMsg() {
        return this.isRecvMsg;
    }

    @Override // com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail
    public boolean isRecvPush() {
        return this.isRecvPush;
    }

    @Override // com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail
    public boolean isShowFollowButton() {
        return this.isShowFollowButton;
    }

    @Override // com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail
    public boolean isSyncLbs() {
        return this.isSyncLbs;
    }

    @Override // com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail
    public boolean isSyncLbsSelected() {
        return this.isSyncLbsSelected;
    }

    public void parser() {
        if (this.unifiedDesrpition == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(this.unifiedDesrpition);
            this.certifiedDescription = jSONObject.optString(IPublicAccountConfigAttr.CERT_DESP);
            this.configBackgroundColor = jSONObject.optString("background_color");
            this.certifiedEnterprise = jSONObject.optString(IPublicAccountConfigAttr.CERT_ENT);
            this.certifiedWeixin = jSONObject.optString(IPublicAccountConfigAttr.CERT_WX);
            this.paConfigAttrs = ((IPublicAccountConfigAttr) QRoute.api(IPublicAccountConfigAttr.class)).parser(jSONObject.optJSONArray(IPublicAccountConfigAttr.CONFIG_ATTR));
            this.customConfigAttrs = ((IPublicAccountConfigAttr) QRoute.api(IPublicAccountConfigAttr.class)).parser(jSONObject.optJSONArray(IPublicAccountConfigAttr.CUSTOM_ATTR));
            this.fullscreenConfigAttrs = ((IPublicAccountConfigAttr) QRoute.api(IPublicAccountConfigAttr.class)).parser(jSONObject.optJSONArray(IPublicAccountConfigAttr.FULLSCREEN_ATTR));
            this.cardStyle = jSONObject.optInt(IPublicAccountConfigAttr.CARD_STYLE);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail
    public void setFollowType(int i3) {
        this.followType = i3;
    }

    public static int getReportAccountType(AppInterface appInterface, String str, PublicAccountDetailImpl publicAccountDetailImpl) {
        IPublicAccountDataManager iPublicAccountDataManager;
        if (appInterface == null && publicAccountDetailImpl == null) {
            return 1;
        }
        if (publicAccountDetailImpl == null && (iPublicAccountDataManager = (IPublicAccountDataManager) appInterface.getRuntimeService(IPublicAccountDataManager.class, "all")) != null) {
            publicAccountDetailImpl = (PublicAccountDetailImpl) iPublicAccountDataManager.findAccountDetailInfo(str);
            if (QLog.isColorLevel()) {
                QLog.d("PublicAccountDetailImpl", 2, "getReportAccountType--> input accountdetail null");
            }
        }
        if (publicAccountDetailImpl == null) {
            return 1;
        }
        int accountType = publicAccountDetailImpl.accountFlag < 0 ? -9 : ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).getAccountType(publicAccountDetailImpl.accountFlag);
        if (accountType == -9) {
            return 9;
        }
        if (accountType == -6) {
            return 7;
        }
        if (accountType == -5) {
            return 6;
        }
        if (accountType == -4) {
            return ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).getAccountType2(publicAccountDetailImpl.accountFlag2) == -8 ? 8 : 4;
        }
        if (accountType != -3) {
            return accountType != -2 ? 1 : 3;
        }
        return 5;
    }

    void parserMsgFlag(List<mobileqq_mp$ConfigGroupInfo> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        boolean z16 = false;
        for (mobileqq_mp$ConfigGroupInfo mobileqq_mp_configgroupinfo : list) {
            if (mobileqq_mp_configgroupinfo.config_info.has()) {
                Iterator<mobileqq_mp$ConfigInfo> it = mobileqq_mp_configgroupinfo.config_info.get().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    mobileqq_mp$ConfigInfo next = it.next();
                    if (next.state_id.get() == 5) {
                        this.mShowMsgFlag = next.state.get() == 1 ? 1 : 0;
                        z16 = true;
                    }
                }
            }
            if (z16) {
                return;
            }
        }
    }

    public PublicAccountDetailImpl(OACProfilePb$ProfileDataRsp oACProfilePb$ProfileDataRsp) {
        this.seqno = 0;
        this.name = HardCodeUtil.qqStr(R.string.j0z);
        this.summary = HardCodeUtil.qqStr(R.string.f171539j12);
        this.displayNumber = "";
        this.isRecvMsg = false;
        this.isShowShareButton = false;
        this.isShowFollowButton = false;
        this.isMute = false;
        this.followType = 0;
        this.groupId = 0;
        this.accountData = null;
        this.isRecvPush = false;
        this.isSyncLbs = false;
        this.isAgreeSyncLbs = false;
        this.certifiedGrade = 0;
        this.showFlag = 0;
        this.accountFlag = 0;
        this.accountFlag2 = 0L;
        this.isConfirmed = false;
        this.mShowMsgFlag = -1;
        this.configBackgroundColor = "3d7fe3";
        this.certifiedDescription = "";
        this.isSyncLbsSelected = false;
        this.lastHistoryMsg = null;
        this.protocolVersion = 0;
        this.protocol839Data = null;
        this.sharedFollowerCount = 0;
        this.configBackgroundImg = "";
        this.cardStyle = 0;
        this.certifiedEnterprise = "";
        this.certifiedWeixin = "";
        this.uin = "" + oACProfilePb$ProfileDataRsp.base_data.puin.get();
        this.name = oACProfilePb$ProfileDataRsp.base_data.name.get();
        this.summary = oACProfilePb$ProfileDataRsp.base_data.summary.get();
        this.isRecvMsg = oACProfilePb$ProfileDataRsp.base_data.is_recv_msg.get();
        this.isShowFollowButton = oACProfilePb$ProfileDataRsp.base_data.is_show_follow_button.get();
        this.followType = oACProfilePb$ProfileDataRsp.base_data.follow_type.get();
        this.isRecvPush = oACProfilePb$ProfileDataRsp.base_data.is_recv_push.get();
        this.accountFlag = oACProfilePb$ProfileDataRsp.base_data.account_flag.get();
        this.accountFlag2 = oACProfilePb$ProfileDataRsp.base_data.account_flag2.get();
        this.uid = oACProfilePb$ProfileDataRsp.base_data.account_uid.get();
        this.displayNumber = oACProfilePb$ProfileDataRsp.base_data.display_number.get();
        if (oACProfilePb$ProfileDataRsp.base_data.unified_account_descrpition.has()) {
            this.unifiedDesrpition = oACProfilePb$ProfileDataRsp.base_data.unified_account_descrpition.get();
        }
        parser();
        this.mShowMsgFlag = -1;
        this.menuButtonResp = oACProfilePb$ProfileDataRsp.menu_rsp;
        this.isMute = oACProfilePb$ProfileDataRsp.base_data.is_mute.get();
        this.protocolVersion = 1;
        this.protocol839Data = oACProfilePb$ProfileDataRsp.toByteArray();
        this.sharedFollowerCount = oACProfilePb$ProfileDataRsp.common_follower_count.get();
        this.showFlag = 1;
    }

    @Override // com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail
    public Entity getEntity() {
        return this;
    }
}
