package com.tencent.mobileqq.data;

import com.tencent.biz.eqq.CrmUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.mp.mobileqq_mp$ConfigGroupInfo;
import com.tencent.mobileqq.mp.mobileqq_mp$ConfigInfo;
import com.tencent.mobileqq.mp.mobileqq_mp$EqqAccountInfo;
import com.tencent.mobileqq.mp.mobileqq_mp$GetEqqAccountDetailInfoResponse;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class EqqDetail extends Entity {
    public byte[] accountData;
    public String address;

    @notColumn
    public String certifiedDescription;
    public int certifiedGrade;
    public String displayNumber;
    public long eqqAccountFlag;
    public int followType;
    public List<mobileqq_mp$ConfigGroupInfo> groupInfoList;
    public boolean isConfirmed;
    public boolean isRecvMsg;
    public String latitude;
    public String longitude;
    public boolean mIsAgreeSyncLbs;
    public boolean mIsSyncLbs;
    public boolean mIsSyncLbsSelected;
    public int mShowMsgFlag;
    public String name;
    public String phoneNumber;
    public String realSummary;
    public int seqno;
    public String summary;

    @unique
    public String uin;

    public EqqDetail() {
        this.seqno = 0;
        this.name = HardCodeUtil.qqStr(R.string.m_m);
        this.summary = HardCodeUtil.qqStr(R.string.m_k);
        this.realSummary = "";
        this.displayNumber = "";
        this.latitude = "";
        this.longitude = "";
        this.phoneNumber = "";
        this.address = "";
        this.isRecvMsg = false;
        this.followType = 0;
        this.accountData = null;
        this.certifiedGrade = 0;
        this.eqqAccountFlag = 0L;
        this.isConfirmed = false;
        this.mShowMsgFlag = -1;
        this.mIsSyncLbs = false;
        this.mIsAgreeSyncLbs = false;
        this.mIsSyncLbsSelected = false;
        this.certifiedDescription = HardCodeUtil.qqStr(R.string.m_l);
    }

    public void clone(EqqDetail eqqDetail) {
        this.uin = eqqDetail.uin;
        this.seqno = eqqDetail.seqno;
        this.name = eqqDetail.name;
        this.summary = eqqDetail.summary;
        this.realSummary = eqqDetail.realSummary;
        this.isRecvMsg = eqqDetail.isRecvMsg;
        this.followType = eqqDetail.followType;
        this.latitude = eqqDetail.latitude;
        this.longitude = eqqDetail.longitude;
        this.accountData = eqqDetail.accountData;
        this.groupInfoList = eqqDetail.groupInfoList;
        this.displayNumber = eqqDetail.displayNumber;
        this.certifiedGrade = eqqDetail.certifiedGrade;
        this.address = eqqDetail.address;
        this.phoneNumber = eqqDetail.phoneNumber;
        this.mShowMsgFlag = eqqDetail.mShowMsgFlag;
        this.mIsSyncLbs = eqqDetail.mIsSyncLbs;
        this.mIsAgreeSyncLbs = eqqDetail.mIsAgreeSyncLbs;
        this.mIsSyncLbsSelected = eqqDetail.mIsSyncLbsSelected;
    }

    public boolean hasIvrAbility() {
        if (!CrmUtils.f78489b) {
            if (QLog.isDevelopLevel()) {
                QLog.d("EqqDetail", 4, "Don't support sharp");
            }
            return false;
        }
        if ((this.eqqAccountFlag & 4194304) != 4194304) {
            return false;
        }
        return true;
    }

    public EqqDetail(mobileqq_mp$GetEqqAccountDetailInfoResponse mobileqq_mp_geteqqaccountdetailinforesponse) {
        boolean z16;
        List<mobileqq_mp$ConfigGroupInfo> list;
        this.seqno = 0;
        this.name = HardCodeUtil.qqStr(R.string.m_m);
        this.summary = HardCodeUtil.qqStr(R.string.m_k);
        this.realSummary = "";
        this.displayNumber = "";
        this.latitude = "";
        this.longitude = "";
        this.phoneNumber = "";
        this.address = "";
        this.isRecvMsg = false;
        this.followType = 0;
        this.accountData = null;
        this.certifiedGrade = 0;
        this.eqqAccountFlag = 0L;
        this.isConfirmed = false;
        this.mShowMsgFlag = -1;
        this.mIsSyncLbs = false;
        this.mIsAgreeSyncLbs = false;
        this.mIsSyncLbsSelected = false;
        this.certifiedDescription = HardCodeUtil.qqStr(R.string.m_l);
        mobileqq_mp$EqqAccountInfo mobileqq_mp_eqqaccountinfo = mobileqq_mp_geteqqaccountdetailinforesponse.accountInfo.get();
        this.uin = "" + (mobileqq_mp_eqqaccountinfo.uin.get() & 4294967295L);
        this.seqno = mobileqq_mp_geteqqaccountdetailinforesponse.seqno.get();
        this.name = mobileqq_mp_eqqaccountinfo.name.get();
        this.summary = mobileqq_mp_eqqaccountinfo.summary.get();
        this.realSummary = mobileqq_mp_geteqqaccountdetailinforesponse.introduce.get();
        this.isRecvMsg = mobileqq_mp_geteqqaccountdetailinforesponse.is_recv_msg.get();
        this.groupInfoList = mobileqq_mp_geteqqaccountdetailinforesponse.config_group_info.get();
        this.followType = mobileqq_mp_geteqqaccountdetailinforesponse.follow_type.get();
        this.displayNumber = mobileqq_mp_eqqaccountinfo.display_number.get();
        this.phoneNumber = mobileqq_mp_geteqqaccountdetailinforesponse.phone_number.get();
        this.certifiedGrade = mobileqq_mp_eqqaccountinfo.certified_grade.get();
        this.eqqAccountFlag = mobileqq_mp_eqqaccountinfo.account_flag.has() ? mobileqq_mp_eqqaccountinfo.account_flag.get() : 0L;
        this.latitude = mobileqq_mp_geteqqaccountdetailinforesponse.lat.get();
        this.longitude = mobileqq_mp_geteqqaccountdetailinforesponse.lng.get();
        this.address = mobileqq_mp_geteqqaccountdetailinforesponse.address.get();
        this.accountData = mobileqq_mp_geteqqaccountdetailinforesponse.toByteArray();
        this.mShowMsgFlag = -1;
        if (mobileqq_mp_geteqqaccountdetailinforesponse.config_group_info.has() && !mobileqq_mp_geteqqaccountdetailinforesponse.config_group_info.isEmpty() && (list = mobileqq_mp_geteqqaccountdetailinforesponse.config_group_info.get()) != null && list.size() > 0) {
            z16 = false;
            boolean z17 = false;
            for (mobileqq_mp$ConfigGroupInfo mobileqq_mp_configgroupinfo : list) {
                if (mobileqq_mp_configgroupinfo.config_info.has() && !mobileqq_mp_configgroupinfo.config_info.isEmpty()) {
                    for (mobileqq_mp$ConfigInfo mobileqq_mp_configinfo : mobileqq_mp_configgroupinfo.config_info.get()) {
                        if (mobileqq_mp_configinfo.state_id.get() == 5) {
                            this.mShowMsgFlag = mobileqq_mp_configinfo.state.get() == 1 ? 1 : 0;
                            z17 = true;
                        }
                        if (mobileqq_mp_configinfo.type.has() && mobileqq_mp_configinfo.type.get() == 2 && mobileqq_mp_configinfo.state_id.has() && mobileqq_mp_configinfo.state_id.get() == 3) {
                            this.mIsSyncLbs = true;
                            if (mobileqq_mp_configinfo.state.has()) {
                                int i3 = mobileqq_mp_configinfo.state.get();
                                if (i3 == 0) {
                                    this.mIsSyncLbsSelected = false;
                                    this.mIsAgreeSyncLbs = false;
                                } else if (i3 == 1) {
                                    this.mIsSyncLbsSelected = true;
                                    this.mIsAgreeSyncLbs = true;
                                } else if (i3 != 2) {
                                    if (QLog.isColorLevel()) {
                                        QLog.e("EqqDetail", 2, "Error Eqq lbs state value: " + mobileqq_mp_configinfo.state.get());
                                    }
                                } else {
                                    this.mIsSyncLbsSelected = true;
                                    this.mIsAgreeSyncLbs = false;
                                }
                            }
                            z16 = true;
                        }
                        if (z17 && z16) {
                            break;
                        }
                    }
                }
                if (z17 && z16) {
                    break;
                }
            }
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        this.mIsSyncLbs = false;
    }
}
