package com.tencent.mobileqq.data;

import android.content.Context;
import android.os.SystemClock;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.j;
import com.tencent.mobileqq.mp.mobileqq_mp$ConfigGroupInfo;
import com.tencent.mobileqq.mp.mobileqq_mp$ConfigInfo;
import com.tencent.mobileqq.mp.mobileqq_mp$EqqAccountInfo;
import com.tencent.mobileqq.mp.mobileqq_mp$PublicAccountInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0xcf8.oidb_cmd0xcf8$ConfigGroupInfo;
import tencent.im.oidb.cmd0xcf8.oidb_cmd0xcf8$ConfigInfo;
import tencent.im.oidb.cmd0xcf8.oidb_cmd0xcf8$PublicAccountInfo;

/* loaded from: classes10.dex */
public class PublicAccountInfo extends Entity {
    public static final int SHOW_FLAG_INVISIBLE_BIT = 2048;
    public static final int SHOW_FLAG_NO = 2;
    public static final int SHOW_FLAG_YES = 1;
    public static final int SHOW_MSG_FLAG_TYPE = 5;
    public int accountFlag;
    public long accountFlag2;
    public long certifiedGrade;
    public int clickCount;
    public long dateTime;
    public String displayNumber;
    public long eqqAccountFlag;
    public int extendType;
    public boolean isRecvMsg;
    public boolean isRecvPush;
    public boolean isShieldMsg;
    public boolean isSyncLbs;
    public String logo;
    public int mComparePartInt;
    public String mCompareSpell;
    public boolean mIsAgreeSyncLbs;
    public boolean mIsSyncLbsSelected;
    public int mShowMsgFlag;
    public int messageSettingFlag;
    public String name;
    public int showFlag;
    public String summary;
    public String uid;

    @unique
    public long uin;

    @notColumn
    private String uinStr;

    @notColumn
    public boolean isOffLine = false;

    @notColumn
    public HashMap<String, Integer> Marks = null;

    @notColumn
    public int orderForMark = 0;
    public boolean isMsgDisturb = false;
    public long lastAIOReadTime = 0;

    private static void copyEqqLbsSwitch(mobileqq_mp$EqqAccountInfo mobileqq_mp_eqqaccountinfo, PublicAccountInfo publicAccountInfo) {
        boolean z16;
        if (mobileqq_mp_eqqaccountinfo.config_group_info.has() && !mobileqq_mp_eqqaccountinfo.config_group_info.isEmpty()) {
            z16 = false;
            for (mobileqq_mp$ConfigGroupInfo mobileqq_mp_configgroupinfo : mobileqq_mp_eqqaccountinfo.config_group_info.get()) {
                if (mobileqq_mp_configgroupinfo.config_info.has() && !mobileqq_mp_configgroupinfo.config_info.isEmpty()) {
                    Iterator<mobileqq_mp$ConfigInfo> it = mobileqq_mp_configgroupinfo.config_info.get().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        mobileqq_mp$ConfigInfo next = it.next();
                        if (next.type.has() && next.type.get() == 2 && next.state_id.has() && next.state_id.get() == 3) {
                            z16 = true;
                            publicAccountInfo.isSyncLbs = true;
                            if (next.state.has()) {
                                int i3 = next.state.get();
                                if (i3 != 0) {
                                    if (i3 != 1) {
                                        if (i3 != 2) {
                                            if (QLog.isColorLevel()) {
                                                QLog.e("PublicAccountInfo", 2, "Error Eqq lbs state value: " + next.state.get());
                                            }
                                        } else {
                                            publicAccountInfo.mIsSyncLbsSelected = true;
                                            publicAccountInfo.mIsAgreeSyncLbs = false;
                                        }
                                    } else {
                                        publicAccountInfo.mIsSyncLbsSelected = true;
                                        publicAccountInfo.mIsAgreeSyncLbs = true;
                                    }
                                } else {
                                    publicAccountInfo.mIsSyncLbsSelected = false;
                                    publicAccountInfo.mIsAgreeSyncLbs = false;
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
        if (!z16) {
            publicAccountInfo.isSyncLbs = false;
        }
    }

    public static PublicAccountInfo createLooker(Context context) {
        PublicAccountInfo publicAccountInfo = new PublicAccountInfo();
        publicAccountInfo.uin = 0L;
        publicAccountInfo.name = context.getString(R.string.f170112gn);
        publicAccountInfo.displayNumber = context.getString(R.string.f170112gn);
        publicAccountInfo.summary = "";
        publicAccountInfo.extendType = 1;
        return publicAccountInfo;
    }

    public static PublicAccountInfo createPublicAccount(IPublicAccountDetail iPublicAccountDetail, long j3) {
        PublicAccountInfo publicAccountInfo = new PublicAccountInfo();
        publicAccountInfo.uinStr = iPublicAccountDetail.getUin();
        publicAccountInfo.uin = Long.parseLong(iPublicAccountDetail.getUin());
        publicAccountInfo.name = iPublicAccountDetail.getName();
        publicAccountInfo.displayNumber = iPublicAccountDetail.getDisplayNumber();
        publicAccountInfo.summary = iPublicAccountDetail.getSummary();
        publicAccountInfo.isRecvMsg = iPublicAccountDetail.isRecvMsg();
        publicAccountInfo.isRecvPush = iPublicAccountDetail.isRecvPush();
        publicAccountInfo.certifiedGrade = iPublicAccountDetail.getCertifiedGrade();
        publicAccountInfo.isSyncLbs = iPublicAccountDetail.isSyncLbs();
        publicAccountInfo.mIsAgreeSyncLbs = iPublicAccountDetail.isAgreeSyncLbs();
        publicAccountInfo.mShowMsgFlag = iPublicAccountDetail.getShowMsgFlag();
        publicAccountInfo.showFlag = iPublicAccountDetail.getShowFlag();
        publicAccountInfo.accountFlag = iPublicAccountDetail.getAccountFlag();
        publicAccountInfo.accountFlag2 = iPublicAccountDetail.getAccountFlag2();
        publicAccountInfo.uid = iPublicAccountDetail.getUid();
        publicAccountInfo.isSyncLbs = iPublicAccountDetail.isSyncLbs();
        publicAccountInfo.mIsAgreeSyncLbs = iPublicAccountDetail.isAgreeSyncLbs();
        publicAccountInfo.mIsSyncLbsSelected = iPublicAccountDetail.isSyncLbsSelected();
        publicAccountInfo.dateTime = j3;
        j.h(publicAccountInfo);
        return publicAccountInfo;
    }

    public static PublicAccountInfo createPublicAccountInfo(mobileqq_mp$PublicAccountInfo mobileqq_mp_publicaccountinfo, long j3) {
        boolean z16;
        List<mobileqq_mp$ConfigGroupInfo> list;
        List<mobileqq_mp$ConfigGroupInfo> list2;
        PublicAccountInfo publicAccountInfo = new PublicAccountInfo();
        if (mobileqq_mp_publicaccountinfo.uin.has()) {
            publicAccountInfo.uin = mobileqq_mp_publicaccountinfo.uin.get() & 4294967295L;
        }
        if (mobileqq_mp_publicaccountinfo.name.has()) {
            publicAccountInfo.name = mobileqq_mp_publicaccountinfo.name.get();
        }
        if (mobileqq_mp_publicaccountinfo.summary.has()) {
            publicAccountInfo.summary = mobileqq_mp_publicaccountinfo.summary.get();
        }
        if (mobileqq_mp_publicaccountinfo.is_recv_msg.has()) {
            publicAccountInfo.isRecvMsg = mobileqq_mp_publicaccountinfo.is_recv_msg.get();
        }
        if (mobileqq_mp_publicaccountinfo.display_number.has()) {
            publicAccountInfo.displayNumber = mobileqq_mp_publicaccountinfo.display_number.get();
        }
        if (mobileqq_mp_publicaccountinfo.is_recv_push.has()) {
            publicAccountInfo.isRecvPush = mobileqq_mp_publicaccountinfo.is_recv_push.get();
        }
        if (mobileqq_mp_publicaccountinfo.certified_grade.has()) {
            publicAccountInfo.certifiedGrade = mobileqq_mp_publicaccountinfo.certified_grade.get();
        }
        if (mobileqq_mp_publicaccountinfo.show_flag.has()) {
            publicAccountInfo.showFlag = mobileqq_mp_publicaccountinfo.show_flag.get();
        }
        if (mobileqq_mp_publicaccountinfo.account_flag.has()) {
            publicAccountInfo.accountFlag = mobileqq_mp_publicaccountinfo.account_flag.get();
        }
        if (mobileqq_mp_publicaccountinfo.is_mute.has()) {
            publicAccountInfo.isMsgDisturb = mobileqq_mp_publicaccountinfo.is_mute.get();
        }
        if (mobileqq_mp_publicaccountinfo.account_uid.has()) {
            publicAccountInfo.uid = mobileqq_mp_publicaccountinfo.account_uid.get();
        }
        publicAccountInfo.mShowMsgFlag = -1;
        if (mobileqq_mp_publicaccountinfo.config_group_info.has() && (list2 = mobileqq_mp_publicaccountinfo.config_group_info.get()) != null && list2.size() > 0) {
            boolean z17 = false;
            for (mobileqq_mp$ConfigGroupInfo mobileqq_mp_configgroupinfo : list2) {
                if (mobileqq_mp_configgroupinfo.config_info.has()) {
                    Iterator<mobileqq_mp$ConfigInfo> it = mobileqq_mp_configgroupinfo.config_info.get().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        mobileqq_mp$ConfigInfo next = it.next();
                        if (next.state_id.get() == 5) {
                            publicAccountInfo.mShowMsgFlag = next.state.get() == 1 ? 1 : 0;
                            z17 = true;
                        }
                    }
                }
                if (z17) {
                    break;
                }
            }
        }
        publicAccountInfo.messageSettingFlag = -1;
        if (mobileqq_mp_publicaccountinfo.config_group_info_new.has() && (list = mobileqq_mp_publicaccountinfo.config_group_info_new.get()) != null && list.size() > 0) {
            for (mobileqq_mp$ConfigGroupInfo mobileqq_mp_configgroupinfo2 : list) {
                if (mobileqq_mp_configgroupinfo2.config_info.has()) {
                    Iterator<mobileqq_mp$ConfigInfo> it5 = mobileqq_mp_configgroupinfo2.config_info.get().iterator();
                    while (true) {
                        if (it5.hasNext()) {
                            mobileqq_mp$ConfigInfo next2 = it5.next();
                            if (next2.state_id.get() == 6) {
                                publicAccountInfo.isShieldMsg = next2.state.get() == 3;
                                publicAccountInfo.messageSettingFlag = next2.state.get();
                            }
                        }
                    }
                }
            }
        }
        if (mobileqq_mp_publicaccountinfo.is_sync_lbs.has()) {
            publicAccountInfo.mIsAgreeSyncLbs = mobileqq_mp_publicaccountinfo.is_sync_lbs.get();
        }
        publicAccountInfo.dateTime = j3;
        if (mobileqq_mp_publicaccountinfo.config_group_info_new.has() && !mobileqq_mp_publicaccountinfo.config_group_info_new.isEmpty()) {
            z16 = false;
            for (mobileqq_mp$ConfigGroupInfo mobileqq_mp_configgroupinfo3 : mobileqq_mp_publicaccountinfo.config_group_info_new.get()) {
                if (mobileqq_mp_configgroupinfo3.config_info.has() && !mobileqq_mp_configgroupinfo3.config_info.isEmpty()) {
                    Iterator<mobileqq_mp$ConfigInfo> it6 = mobileqq_mp_configgroupinfo3.config_info.get().iterator();
                    while (true) {
                        if (!it6.hasNext()) {
                            break;
                        }
                        mobileqq_mp$ConfigInfo next3 = it6.next();
                        if (next3.type.has() && next3.type.get() == 2 && next3.state_id.has() && next3.state_id.get() == 3) {
                            publicAccountInfo.isSyncLbs = true;
                            if (next3.state.has()) {
                                int i3 = next3.state.get();
                                if (i3 == 0) {
                                    publicAccountInfo.mIsSyncLbsSelected = false;
                                    publicAccountInfo.mIsAgreeSyncLbs = false;
                                } else if (i3 == 1) {
                                    publicAccountInfo.mIsSyncLbsSelected = true;
                                    publicAccountInfo.mIsAgreeSyncLbs = true;
                                } else if (i3 == 2) {
                                    publicAccountInfo.mIsSyncLbsSelected = true;
                                    publicAccountInfo.mIsAgreeSyncLbs = false;
                                }
                            }
                            z16 = true;
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
        if (!z16) {
            publicAccountInfo.isSyncLbs = false;
        }
        return publicAccountInfo;
    }

    public static PublicAccountInfo createPublicAccountInfoCf8(oidb_cmd0xcf8$PublicAccountInfo oidb_cmd0xcf8_publicaccountinfo, long j3) {
        boolean z16;
        List<oidb_cmd0xcf8$ConfigGroupInfo> list;
        boolean z17;
        List<oidb_cmd0xcf8$ConfigGroupInfo> list2;
        int i3;
        PublicAccountInfo publicAccountInfo = new PublicAccountInfo();
        if (oidb_cmd0xcf8_publicaccountinfo.luin.has()) {
            publicAccountInfo.uin = oidb_cmd0xcf8_publicaccountinfo.luin.get() & 4294967295L;
        }
        if (oidb_cmd0xcf8_publicaccountinfo.name.has()) {
            publicAccountInfo.name = oidb_cmd0xcf8_publicaccountinfo.name.get();
        }
        if (oidb_cmd0xcf8_publicaccountinfo.summary.has()) {
            publicAccountInfo.summary = oidb_cmd0xcf8_publicaccountinfo.summary.get();
        }
        if (oidb_cmd0xcf8_publicaccountinfo.is_recv_msg.has()) {
            publicAccountInfo.isRecvMsg = oidb_cmd0xcf8_publicaccountinfo.is_recv_msg.get();
        }
        if (oidb_cmd0xcf8_publicaccountinfo.display_number.has()) {
            publicAccountInfo.displayNumber = oidb_cmd0xcf8_publicaccountinfo.display_number.get();
        }
        if (oidb_cmd0xcf8_publicaccountinfo.is_recv_push.has()) {
            publicAccountInfo.isRecvPush = oidb_cmd0xcf8_publicaccountinfo.is_recv_push.get();
        }
        if (oidb_cmd0xcf8_publicaccountinfo.certified_grade.has()) {
            publicAccountInfo.certifiedGrade = oidb_cmd0xcf8_publicaccountinfo.certified_grade.get();
        }
        if (oidb_cmd0xcf8_publicaccountinfo.show_flag.has()) {
            publicAccountInfo.showFlag = oidb_cmd0xcf8_publicaccountinfo.show_flag.get();
        }
        if (oidb_cmd0xcf8_publicaccountinfo.account_flag.has()) {
            publicAccountInfo.accountFlag = oidb_cmd0xcf8_publicaccountinfo.account_flag.get();
        }
        if (oidb_cmd0xcf8_publicaccountinfo.account_flag2.has()) {
            publicAccountInfo.accountFlag2 = oidb_cmd0xcf8_publicaccountinfo.account_flag2.get();
        }
        if (oidb_cmd0xcf8_publicaccountinfo.account_uid.has()) {
            publicAccountInfo.uid = oidb_cmd0xcf8_publicaccountinfo.account_uid.get();
        }
        if (oidb_cmd0xcf8_publicaccountinfo.is_mute.has()) {
            publicAccountInfo.isMsgDisturb = oidb_cmd0xcf8_publicaccountinfo.is_mute.get();
        }
        publicAccountInfo.mShowMsgFlag = -1;
        if (oidb_cmd0xcf8_publicaccountinfo.config_group_info.has() && (list2 = oidb_cmd0xcf8_publicaccountinfo.config_group_info.get()) != null && list2.size() > 0) {
            boolean z18 = false;
            for (oidb_cmd0xcf8$ConfigGroupInfo oidb_cmd0xcf8_configgroupinfo : list2) {
                if (oidb_cmd0xcf8_configgroupinfo.config_info.has()) {
                    Iterator<oidb_cmd0xcf8$ConfigInfo> it = oidb_cmd0xcf8_configgroupinfo.config_info.get().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        oidb_cmd0xcf8$ConfigInfo next = it.next();
                        if (next.state_id.get() == 5) {
                            if (next.state.get() == 1) {
                                i3 = 1;
                            } else {
                                i3 = 0;
                            }
                            publicAccountInfo.mShowMsgFlag = i3;
                            z18 = true;
                        }
                    }
                }
                if (z18) {
                    break;
                }
            }
        }
        publicAccountInfo.messageSettingFlag = -1;
        if (oidb_cmd0xcf8_publicaccountinfo.config_group_info_new.has() && (list = oidb_cmd0xcf8_publicaccountinfo.config_group_info_new.get()) != null && list.size() > 0) {
            for (oidb_cmd0xcf8$ConfigGroupInfo oidb_cmd0xcf8_configgroupinfo2 : list) {
                if (oidb_cmd0xcf8_configgroupinfo2.config_info.has()) {
                    Iterator<oidb_cmd0xcf8$ConfigInfo> it5 = oidb_cmd0xcf8_configgroupinfo2.config_info.get().iterator();
                    while (true) {
                        if (it5.hasNext()) {
                            oidb_cmd0xcf8$ConfigInfo next2 = it5.next();
                            if (next2.state_id.get() == 6) {
                                if (next2.state.get() == 3) {
                                    z17 = true;
                                } else {
                                    z17 = false;
                                }
                                publicAccountInfo.isShieldMsg = z17;
                                publicAccountInfo.messageSettingFlag = next2.state.get();
                            }
                        }
                    }
                }
            }
        }
        if (oidb_cmd0xcf8_publicaccountinfo.is_sync_lbs.has()) {
            publicAccountInfo.mIsAgreeSyncLbs = oidb_cmd0xcf8_publicaccountinfo.is_sync_lbs.get();
        }
        publicAccountInfo.dateTime = j3;
        if (oidb_cmd0xcf8_publicaccountinfo.config_group_info_new.has() && !oidb_cmd0xcf8_publicaccountinfo.config_group_info_new.isEmpty()) {
            z16 = false;
            for (oidb_cmd0xcf8$ConfigGroupInfo oidb_cmd0xcf8_configgroupinfo3 : oidb_cmd0xcf8_publicaccountinfo.config_group_info_new.get()) {
                if (oidb_cmd0xcf8_configgroupinfo3.config_info.has() && !oidb_cmd0xcf8_configgroupinfo3.config_info.isEmpty()) {
                    Iterator<oidb_cmd0xcf8$ConfigInfo> it6 = oidb_cmd0xcf8_configgroupinfo3.config_info.get().iterator();
                    while (true) {
                        if (!it6.hasNext()) {
                            break;
                        }
                        oidb_cmd0xcf8$ConfigInfo next3 = it6.next();
                        if (next3.type.has() && next3.type.get() == 2 && next3.state_id.has() && next3.state_id.get() == 3) {
                            publicAccountInfo.isSyncLbs = true;
                            if (next3.state.has()) {
                                int i16 = next3.state.get();
                                if (i16 != 0) {
                                    if (i16 != 1) {
                                        if (i16 == 2) {
                                            publicAccountInfo.mIsSyncLbsSelected = true;
                                            publicAccountInfo.mIsAgreeSyncLbs = false;
                                        }
                                    } else {
                                        publicAccountInfo.mIsSyncLbsSelected = true;
                                        publicAccountInfo.mIsAgreeSyncLbs = true;
                                    }
                                } else {
                                    publicAccountInfo.mIsSyncLbsSelected = false;
                                    publicAccountInfo.mIsAgreeSyncLbs = false;
                                }
                            }
                            z16 = true;
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
        if (!z16) {
            publicAccountInfo.isSyncLbs = false;
        }
        return publicAccountInfo;
    }

    public static PublicAccountInfo createPublicAccountInfoFromEqq(mobileqq_mp$EqqAccountInfo mobileqq_mp_eqqaccountinfo, long j3) {
        List<mobileqq_mp$ConfigGroupInfo> list;
        int i3;
        PublicAccountInfo publicAccountInfo = new PublicAccountInfo();
        if (mobileqq_mp_eqqaccountinfo.uin.has()) {
            publicAccountInfo.uin = mobileqq_mp_eqqaccountinfo.uin.get() & 4294967295L;
        }
        if (mobileqq_mp_eqqaccountinfo.name.has()) {
            publicAccountInfo.name = mobileqq_mp_eqqaccountinfo.name.get();
        }
        if (mobileqq_mp_eqqaccountinfo.display_number.has()) {
            publicAccountInfo.displayNumber = mobileqq_mp_eqqaccountinfo.display_number.get();
        }
        if (mobileqq_mp_eqqaccountinfo.summary.has()) {
            publicAccountInfo.summary = mobileqq_mp_eqqaccountinfo.summary.get();
        }
        if (mobileqq_mp_eqqaccountinfo.certified_grade.has()) {
            publicAccountInfo.certifiedGrade = mobileqq_mp_eqqaccountinfo.certified_grade.get();
        }
        if (mobileqq_mp_eqqaccountinfo.logo.has()) {
            publicAccountInfo.logo = mobileqq_mp_eqqaccountinfo.logo.get();
        }
        if (mobileqq_mp_eqqaccountinfo.account_flag.has()) {
            publicAccountInfo.eqqAccountFlag = mobileqq_mp_eqqaccountinfo.account_flag.get();
        }
        publicAccountInfo.mShowMsgFlag = -1;
        if (mobileqq_mp_eqqaccountinfo.config_group_info.has() && (list = mobileqq_mp_eqqaccountinfo.config_group_info.get()) != null && list.size() > 0) {
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
                            if (next.state.get() == 1) {
                                i3 = 1;
                            } else {
                                i3 = 0;
                            }
                            publicAccountInfo.mShowMsgFlag = i3;
                            z16 = true;
                        }
                    }
                }
                if (z16) {
                    break;
                }
            }
        }
        publicAccountInfo.dateTime = j3;
        publicAccountInfo.showFlag = 1;
        publicAccountInfo.extendType = 2;
        copyEqqLbsSwitch(mobileqq_mp_eqqaccountinfo, publicAccountInfo);
        return publicAccountInfo;
    }

    public static List<PublicAccountInfo> createPublicAccountInfoList(List<mobileqq_mp$PublicAccountInfo> list, long j3) {
        if (list != null) {
            ArrayList arrayList = new ArrayList(list.size());
            Iterator<mobileqq_mp$PublicAccountInfo> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(createPublicAccountInfo(it.next(), j3));
            }
            return arrayList;
        }
        return null;
    }

    public static List<PublicAccountInfo> createPublicAccountInfoListCf8(List<oidb_cmd0xcf8$PublicAccountInfo> list, long j3) {
        if (list != null) {
            ArrayList arrayList = new ArrayList(list.size());
            Iterator<oidb_cmd0xcf8$PublicAccountInfo> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(createPublicAccountInfoCf8(it.next(), j3));
            }
            return arrayList;
        }
        return null;
    }

    public static List<PublicAccountInfo> createPublicAccountInfoListFromEqq(List<mobileqq_mp$EqqAccountInfo> list, long j3) {
        if (list != null) {
            ArrayList arrayList = new ArrayList(list.size());
            Iterator<mobileqq_mp$EqqAccountInfo> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(createPublicAccountInfoFromEqq(it.next(), j3));
            }
            return arrayList;
        }
        return null;
    }

    private boolean isHideInContacts() {
        if ((this.accountFlag & 2048) != 0) {
            return true;
        }
        return false;
    }

    public static boolean isLooker(PublicAccountInfo publicAccountInfo) {
        if (publicAccountInfo.extendType == 1) {
            return true;
        }
        return false;
    }

    public String getUin() {
        if (this.uinStr == null) {
            this.uinStr = String.valueOf(this.uin);
        }
        return this.uinStr;
    }

    public boolean hasIvrAbility() {
        if (2 != this.extendType) {
            return false;
        }
        if (!CrmUtils.f78489b) {
            if (QLog.isDevelopLevel()) {
                QLog.d("PublicAccountInfo", 4, "Don't support sharp");
            }
            return false;
        }
        if ((this.eqqAccountFlag & 4194304) != 4194304) {
            return false;
        }
        return true;
    }

    public boolean isNeedShow() {
        if (1 == this.showFlag) {
            return true;
        }
        return false;
    }

    public boolean isVisible() {
        if (1 == this.showFlag) {
            return true;
        }
        return false;
    }

    public static PublicAccountInfo createPublicAccount(EqqDetail eqqDetail, long j3) {
        PublicAccountInfo publicAccountInfo = new PublicAccountInfo();
        String str = eqqDetail.uin;
        publicAccountInfo.uinStr = str;
        try {
            publicAccountInfo.uin = Long.parseLong(str);
        } catch (NumberFormatException unused) {
            publicAccountInfo.uin = 0L;
        }
        publicAccountInfo.name = eqqDetail.name;
        publicAccountInfo.displayNumber = eqqDetail.displayNumber;
        publicAccountInfo.summary = eqqDetail.summary;
        publicAccountInfo.certifiedGrade = eqqDetail.certifiedGrade;
        publicAccountInfo.dateTime = j3;
        publicAccountInfo.showFlag = 1;
        publicAccountInfo.extendType = 2;
        publicAccountInfo.mShowMsgFlag = eqqDetail.mShowMsgFlag;
        publicAccountInfo.isSyncLbs = eqqDetail.mIsSyncLbs;
        publicAccountInfo.mIsAgreeSyncLbs = eqqDetail.mIsAgreeSyncLbs;
        publicAccountInfo.mIsSyncLbsSelected = eqqDetail.mIsSyncLbsSelected;
        publicAccountInfo.eqqAccountFlag = eqqDetail.eqqAccountFlag;
        return publicAccountInfo;
    }

    public static PublicAccountInfo createPublicAccountInfo(long j3, String str, String str2, String str3, int i3, HashMap<String, Integer> hashMap, int i16) {
        PublicAccountInfo publicAccountInfo = new PublicAccountInfo();
        publicAccountInfo.uin = j3;
        publicAccountInfo.uinStr = String.valueOf(j3);
        publicAccountInfo.displayNumber = str;
        publicAccountInfo.name = str2;
        publicAccountInfo.summary = str3;
        publicAccountInfo.certifiedGrade = i3;
        publicAccountInfo.Marks = hashMap;
        publicAccountInfo.isOffLine = true;
        publicAccountInfo.dateTime = SystemClock.uptimeMillis();
        publicAccountInfo.orderForMark = i16;
        return publicAccountInfo;
    }
}
