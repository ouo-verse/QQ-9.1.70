package com.tencent.mobileqq.troop.data;

import NS_COMM.COMM;
import android.content.res.Resources;
import android.text.TextUtils;
import com.qq.wx.voice.util.ErrorCode;
import com.tencent.imsdk.BaseConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.vaswebviewplugin.VasBusiness;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.List;

/* compiled from: P */
@Deprecated
/* loaded from: classes19.dex */
public class TroopInfoData implements Serializable {
    static IPatchRedirector $redirector_ = null;
    public static final int FLAG_EXT4_PRETTY_GROUP = 1;
    public static final int FLAG_EXT4_SUPER_PRETTY_GROUP = 2;
    public static final int FREZEE_REASON_PRETTY_TROOP_FLAG = 2;
    public static final int INVITE_MODE_ANYONE_ENTRY_WITHOUT_REVIEW = 5;
    public static final int INVITE_MODE_ANYONE_ENTRY_WITH_PAYMENT = 6;
    public static final int INVITE_MODE_ENABLE_INVATE_WITHOUT_REVIEW = 2;
    public static final int INVITE_MODE_ENABLE_INVATE_WITHOUT_REVIEW_MEM_COUNT_IN_100 = 8;
    public static final int INVITE_MODE_ENABLE_INVATE_WITHOUT_REVIEW_MEM_COUNT_IN_50 = 7;
    public static final int INVITE_MODE_ENABLE_INVATE_WITH_REVIEW = 3;
    public static final int INVITE_MODE_NO_ENTRY = 4;
    public static final int INVITE_MODE_UNABLE_INVATE = 1;
    public static final int MEMBER_POWER_EXPAND = 1;
    public static final String TAG = "TroopInfoData";
    public int allowMemberAtAll;
    public int allowMemberKick;
    public boolean bAdmin;
    public boolean bOwner;
    public short cGroupOption;
    public String channelSourceItem;
    public int cityId;
    public long dwAuthGroupType;
    public long dwGroupClassExt;
    public long dwGroupFlagExt;
    public int grade;
    public long groupAllianceid;
    public int groupFlagExt4;
    public int groupFreezeReason;
    public boolean hasSetNewTroopHead;
    public boolean hasSetNewTroopName;
    public int inviteMode;
    public String inviteModeDescription;
    public boolean isMember;
    public boolean isNewTroop;
    public boolean isOnlyTroopMemberInvite;
    public boolean isQidianPrivateTroop;
    public boolean isTroopGuild;
    public boolean isUseClassAvatar;
    public String location;
    public int mIsFreezed;
    public boolean mMemberInvitingFlag;
    public int mNewGroupActivityNum;
    public int mNewTroopNotificationNum;
    public long mPoiId;
    public String mRichFingerMemo;
    public String mStrJoinAnswer;
    public String mStrJoinQuestion;
    public String mTroopClassExtText;
    public long mTroopCreateTime;
    public float mTroopNeedPayNumber;
    public int mTroopPrivilegeFlag;
    public int modifyCount;
    public int nActiveMemberNum;
    public int nGroupFlagExt;
    public int nNewFileMsgNum;
    public int nNewPhotoNum;
    public int nStatOption;
    public int nTroopGrade;
    public int nTroopMask;
    public int nTroopMaskToSet;
    public int nUnreadFileMsgnum;
    public int nUnreadMsgNum;
    private int nViewExtraFlag;
    public String newTroopName;

    /* renamed from: pa, reason: collision with root package name */
    public int f294880pa;
    public String remark;
    public String school;
    public long tribeId;
    public String tribeName;
    public int tribeStatus;
    public String troopAuthen;
    public String troopAuthenticateInfo;
    public String troopCard;
    public String troopClass;
    public String troopCode;
    public String troopColorNick;
    public int troopColorNickId;
    public boolean troopFeedSwitch;
    public int troopFeedTalkPermission;
    public String troopGuildChannelId;
    public String troopGuildId;
    public long troopInterestId;
    public String troopInterestName;
    public String troopIntro;
    public int troopLat;
    public String troopLocation;
    public int troopLon;
    public int troopMemberMaxNum;
    public String troopMemo;
    public String troopName;
    public String troopOwnerNick;
    public List<String> troopTags;
    public int troopTypeExt;
    public String troopUin;
    public short troopface;
    public String troopowneruid;
    public String troopowneruin;
    public String userFrom;
    public int wMemberNum;

    public TroopInfoData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.dwGroupClassExt = -1L;
        this.troopLat = 0;
        this.troopLon = 0;
        this.mTroopPrivilegeFlag = 0;
        this.mTroopNeedPayNumber = 0.0f;
        this.dwGroupFlagExt = 0L;
        this.dwAuthGroupType = 0L;
        this.nUnreadMsgNum = 0;
        this.nNewPhotoNum = 0;
        this.nUnreadFileMsgnum = 0;
        this.nNewFileMsgNum = 0;
        this.mNewTroopNotificationNum = 0;
        this.mNewGroupActivityNum = 0;
        this.troopTypeExt = -1;
        this.modifyCount = 5;
        this.groupAllianceid = 0L;
        this.isTroopGuild = false;
        this.troopFeedTalkPermission = -1;
        this.troopFeedSwitch = true;
        this.nViewExtraFlag = this.nViewExtraFlag | 4 | 2;
    }

    public static int getStatOption(int i3, int i16) {
        if (i3 != 0) {
            return i3;
        }
        if (i16 == 4) {
            return 10015;
        }
        if (i16 == 5) {
            return 21;
        }
        if (i16 == 6) {
            return 3;
        }
        if (i16 == 10) {
            return 11;
        }
        if (i16 == 11) {
            return 12;
        }
        if (i16 == 34) {
            return 85;
        }
        if (i16 == 35) {
            return 10004;
        }
        if (i16 == 112) {
            return 10033;
        }
        if (i16 == 113) {
            return 10032;
        }
        if (i16 != 1016 && i16 != 1017) {
            switch (i16) {
                case 2:
                    return 31;
                case 23:
                    return 30;
                case 27:
                    return 10002;
                case 32:
                    return 38;
                case 101:
                    return 10009;
                case 102:
                    return 10008;
                case 103:
                    return 10010;
                case 104:
                    return 10011;
                case 105:
                    return 10012;
                case 106:
                    return 10013;
                case 107:
                    return 10018;
                case 108:
                    return 10020;
                case 109:
                    return 10022;
                case 110:
                    return 10026;
                case 1025:
                case 10014:
                case ErrorCode.ERROR_CMD_INVALID /* 20101 */:
                case 30001:
                case 30002:
                case 30003:
                case 30004:
                case 30005:
                case 30006:
                case 30007:
                case BaseConstants.ERR_SVR_FRIENDSHIP_WRITE_CONFLICT /* 30008 */:
                case BaseConstants.ERR_SVR_FRIENDSHIP_ADD_FRIEND_DENY /* 30009 */:
                case BaseConstants.ERR_SVR_FRIENDSHIP_COUNT_LIMIT /* 30010 */:
                case BaseConstants.ERR_SVR_FRIENDSHIP_GROUP_COUNT_LIMIT /* 30011 */:
                case BaseConstants.ERR_SVR_FRIENDSHIP_PENDENCY_LIMIT /* 30012 */:
                case BaseConstants.ERR_SVR_FRIENDSHIP_BLACKLIST_LIMIT /* 30013 */:
                case BaseConstants.ERR_SVR_FRIENDSHIP_PEER_FRIEND_LIMIT /* 30014 */:
                case 30015:
                case 30016:
                case 30017:
                case 30018:
                case 30019:
                case 30020:
                case 30021:
                case 30022:
                case 30023:
                case 30024:
                case 50002:
                    break;
                default:
                    switch (i16) {
                        case 14:
                            return 19;
                        case 15:
                            return 10;
                        case 16:
                            return 18;
                        case 17:
                            return 10001;
                        case 18:
                            return 24;
                        case 19:
                            return 26;
                        case 20:
                            return 13;
                        case 21:
                            return 10003;
                        default:
                            switch (i16) {
                                case 1001:
                                case 1002:
                                case 1003:
                                    break;
                                default:
                                    switch (i16) {
                                        case 1019:
                                        case 1020:
                                        case 1021:
                                        case 1022:
                                            break;
                                        default:
                                            switch (i16) {
                                                case 10201:
                                                case COMM.qq_story_unread /* 10202 */:
                                                case COMM.qq_story_operation /* 10203 */:
                                                    break;
                                                default:
                                                    return i3;
                                            }
                                    }
                            }
                    }
            }
        }
        return i16;
    }

    public boolean canInviteMember() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        if (!this.bOwner && !this.bAdmin && !this.mMemberInvitingFlag) {
            return false;
        }
        return true;
    }

    public void coverFrom(TroopInfo troopInfo) {
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) troopInfo);
            return;
        }
        this.nTroopGrade = troopInfo.nTroopGrade;
        this.troopTags = TroopInfo.getTags(troopInfo.mTags);
        this.troopMemberMaxNum = troopInfo.wMemberMax;
        long j3 = troopInfo.dwGroupFlagExt;
        this.dwGroupFlagExt = j3;
        this.wMemberNum = troopInfo.wMemberNum;
        this.troopTypeExt = troopInfo.troopTypeExt;
        this.mTroopPrivilegeFlag = (int) troopInfo.troopPrivilegeFlag;
        long j16 = troopInfo.dwGroupFlagExt3;
        boolean z18 = true;
        if ((4 & j16) != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.isOnlyTroopMemberInvite = z16;
        if ((j16 & 32) != 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        this.isQidianPrivateTroop = z17;
        boolean z19 = troopInfo.isNewTroop;
        this.isNewTroop = z19;
        this.hasSetNewTroopHead = troopInfo.hasSetNewTroopHead;
        this.hasSetNewTroopName = troopInfo.hasSetNewTroopName;
        if (z19 || (j3 & 131072) == 0) {
            z18 = false;
        }
        this.isUseClassAvatar = z18;
        this.mTroopClassExtText = troopInfo.mGroupClassExtText;
        this.dwAuthGroupType = troopInfo.dwAuthGroupType;
        this.troopAuthenticateInfo = troopInfo.troopAuthenticateInfo;
        this.nActiveMemberNum = troopInfo.activeMemberNum;
        this.dwGroupClassExt = troopInfo.dwGroupClassExt;
        this.troopLocation = troopInfo.strLocation;
        this.troopLat = troopInfo.troopLat;
        this.troopLon = troopInfo.troopLon;
        this.cityId = troopInfo.cityId;
        this.troopIntro = troopInfo.fingertroopmemo;
        String str = troopInfo.mRichFingerMemo;
        this.mRichFingerMemo = str;
        if (TextUtils.isEmpty(str)) {
            this.mRichFingerMemo = this.troopIntro;
        } else {
            this.mRichFingerMemo = com.tencent.mobileqq.troop.util.a.c(this.mRichFingerMemo);
        }
        this.location = troopInfo.location;
        this.grade = troopInfo.grade;
        this.school = troopInfo.school;
        this.mTroopCreateTime = troopInfo.troopCreateTime;
        this.nGroupFlagExt = (int) troopInfo.dwGroupFlagExt;
        this.troopowneruin = String.valueOf(troopInfo.troopowneruin);
        this.troopowneruid = troopInfo.troopOwnerUid;
        if (this.newTroopName == null || !this.isNewTroop || this.hasSetNewTroopName) {
            this.newTroopName = this.troopName;
        }
        if (TextUtils.isEmpty(this.troopName)) {
            String str2 = troopInfo.troopname;
            this.troopName = str2;
            if (this.newTroopName == null) {
                this.newTroopName = str2;
            }
        }
        this.allowMemberKick = troopInfo.allowMemberKick;
        this.allowMemberAtAll = troopInfo.allowMemberAtAll;
        this.mIsFreezed = troopInfo.mIsFreezed;
        this.groupFlagExt4 = troopInfo.groupFlagExt4;
        this.groupFreezeReason = troopInfo.groupFreezeReason;
        this.groupAllianceid = troopInfo.groupAllianceid;
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "[coverFrom] troopUin:" + this.troopUin + ",groupAllianceid:" + this.groupAllianceid);
        }
    }

    public String getInviteModeDesWording(TroopInfo troopInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, (Object) this, (Object) troopInfo);
        }
        if (troopInfo == null) {
            return "";
        }
        long j3 = troopInfo.troopPrivilegeFlag;
        if ((101711872 & j3) == 0) {
            return HardCodeUtil.qqStr(R.string.e0c);
        }
        if ((j3 & 33554432) != 33554432 && (j3 & 67108864) != 67108864 && (j3 & 1048576) != 1048576) {
            return "";
        }
        return HardCodeUtil.qqStr(R.string.e0d);
    }

    public String getTroopOwnerName() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        if (!TextUtils.isEmpty(this.troopOwnerNick)) {
            str = this.troopOwnerNick;
        } else {
            str = this.troopowneruin;
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str;
    }

    public boolean hasTroopAssociation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this)).booleanValue();
        }
        if (this.groupAllianceid != 0) {
            return true;
        }
        return false;
    }

    public boolean isFansTroop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Boolean) iPatchRedirector.redirect((short) 25, (Object) this)).booleanValue();
        }
        if (this.dwGroupClassExt == 27) {
            return true;
        }
        return false;
    }

    public boolean isFetchedTroopOwnerUin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this)).booleanValue();
        }
        return !TextUtils.isEmpty(this.troopowneruin);
    }

    public boolean isGameTroop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this)).booleanValue();
        }
        if (this.dwGroupClassExt == 25) {
            return true;
        }
        return false;
    }

    public boolean isHomeworkTroop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this)).booleanValue();
        }
        if (this.dwGroupClassExt == 32) {
            return true;
        }
        return false;
    }

    public boolean isOwnerOrAdim() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        if (!this.bOwner && !this.bAdmin) {
            return false;
        }
        return true;
    }

    public boolean isShowActivityGrade() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this)).booleanValue();
        }
        if ((this.dwGroupFlagExt & VasBusiness.CHAT_FONT_SWITCH) == VasBusiness.CHAT_FONT_SWITCH) {
            return true;
        }
        return false;
    }

    public boolean isTroopAPPVisible() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        if ((this.nViewExtraFlag & 8) == 8) {
            return true;
        }
        return false;
    }

    public boolean isTroopBBSVisible() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        if ((this.nViewExtraFlag & 1) == 1) {
            return true;
        }
        return false;
    }

    public boolean isTroopFileVisible() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        if ((this.nViewExtraFlag & 2) == 2) {
            return true;
        }
        return false;
    }

    public boolean isTroopPhotosVisible() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        if ((this.nViewExtraFlag & 4) == 4) {
            return true;
        }
        return false;
    }

    public void setTroopAppVisible(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
        } else if (z16) {
            this.nViewExtraFlag |= 8;
        } else {
            this.nViewExtraFlag &= -9;
        }
    }

    public void setTroopBBSVisible(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
        } else if (z16) {
            this.nViewExtraFlag |= 1;
        } else {
            this.nViewExtraFlag &= -2;
        }
    }

    public void setTroopFileVisible(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else if (z16) {
            this.nViewExtraFlag |= 2;
        } else {
            this.nViewExtraFlag &= -3;
        }
    }

    public void updateForTroopChatSetting(TroopInfo troopInfo, Resources resources, String str) {
        String str2;
        short s16;
        boolean z16;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, troopInfo, resources, str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "updateForTroopChatSetting(), troopinfo = " + troopInfo);
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (troopInfo != null) {
            this.troopCode = troopInfo.troopcode;
            String str3 = troopInfo.troopuin;
            if (str3 != null) {
                this.troopUin = str3;
            }
            this.troopface = troopInfo.troopface;
            this.troopName = troopInfo.troopname;
            this.newTroopName = troopInfo.getNewTroopNameOrTroopName();
            this.cGroupOption = troopInfo.cGroupOption;
            this.isOnlyTroopMemberInvite = troopInfo.isOnlyTroopMemberInviteOption();
            this.isQidianPrivateTroop = troopInfo.isQidianPrivateTroop();
            this.troopMemo = troopInfo.troopmemo;
            this.troopIntro = troopInfo.fingertroopmemo;
            this.location = troopInfo.location;
            this.grade = troopInfo.grade;
            this.school = troopInfo.school;
            this.mRichFingerMemo = troopInfo.mRichFingerMemo;
            this.dwGroupClassExt = troopInfo.dwGroupClassExt;
            String str4 = troopInfo.mGroupClassExtText;
            if (str4 != null) {
                this.mTroopClassExtText = str4;
            }
            this.mTroopCreateTime = troopInfo.troopCreateTime;
            this.wMemberNum = troopInfo.wMemberNum;
            this.troopMemberMaxNum = troopInfo.wMemberMax;
            this.isNewTroop = troopInfo.isNewTroop;
            this.hasSetNewTroopHead = troopInfo.hasSetNewTroopHead;
            this.hasSetNewTroopName = troopInfo.hasSetNewTroopName;
            this.isUseClassAvatar = troopInfo.isUseClassAvatar();
            QLog.isColorLevel();
            this.mStrJoinQuestion = troopInfo.joinTroopQuestion;
            this.mStrJoinAnswer = troopInfo.joinTroopAnswer;
            long j3 = troopInfo.troopPrivilegeFlag;
            this.mTroopPrivilegeFlag = (int) j3;
            this.mTroopNeedPayNumber = troopInfo.mTroopNeedPayNumber;
            this.allowMemberAtAll = troopInfo.allowMemberAtAll;
            this.allowMemberKick = troopInfo.allowMemberKick;
            if (TroopInfo.hasPayPrivilege(j3, 128) && TroopInfo.hasPayPrivilege(troopInfo.troopPrivilegeFlag, 512)) {
                this.troopAuthen = HardCodeUtil.qqStr(R.string.i7e);
                s16 = 6;
            } else if (troopInfo.isOnlyTroopMemberInviteOption()) {
                this.troopAuthen = HardCodeUtil.qqStr(R.string.i76);
                this.dwGroupFlagExt |= 128;
                s16 = 0;
            } else {
                s16 = troopInfo.cGroupOption;
                if (s16 != 1) {
                    if (s16 != 2) {
                        if (s16 != 3) {
                            if (s16 != 4) {
                                if (s16 == 5) {
                                    this.troopAuthen = HardCodeUtil.qqStr(R.string.i78);
                                }
                            } else {
                                this.troopAuthen = HardCodeUtil.qqStr(R.string.i79);
                            }
                        } else {
                            this.troopAuthen = HardCodeUtil.qqStr(R.string.i7d);
                        }
                    } else {
                        this.troopAuthen = HardCodeUtil.qqStr(R.string.i7b);
                    }
                } else {
                    this.troopAuthen = HardCodeUtil.qqStr(R.string.i77);
                }
            }
            if (!Utils.p(this.troopowneruin, troopInfo.troopowneruin)) {
                this.troopowneruin = troopInfo.troopowneruin;
                this.troopOwnerNick = null;
                updateOwnerFlag(str);
            }
            this.bAdmin = troopInfo.isOwnerOrAdmin();
            if (!this.bOwner && troopInfo.isOwner()) {
                this.bOwner = true;
            }
            if (!this.bAdmin && troopInfo.isAdmin()) {
                this.bAdmin = true;
            }
            this.mMemberInvitingFlag = troopInfo.mMemberInvitingFlag;
            this.troopface = troopInfo.troopface;
            str2 = TAG;
            if ((troopInfo.dwGroupFlagExt & 128) == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (s16 == 3) {
                this.inviteModeDescription = HardCodeUtil.qqStr(R.string.e0e);
                this.inviteMode = 4;
            } else if (s16 == 1) {
                this.inviteModeDescription = HardCodeUtil.qqStr(R.string.e0b);
                this.inviteMode = 5;
            } else if (z16) {
                if (s16 == 6) {
                    this.inviteModeDescription = HardCodeUtil.qqStr(R.string.e0a);
                    this.inviteMode = 6;
                } else {
                    this.inviteModeDescription = getInviteModeDesWording(troopInfo);
                    long j16 = troopInfo.troopPrivilegeFlag;
                    if ((j16 & 1048576) == 1048576) {
                        this.inviteMode = 2;
                    } else if ((101711872 & j16) == 0) {
                        this.inviteMode = 3;
                    } else if ((j16 & 33554432) == 33554432) {
                        this.inviteMode = 7;
                    } else if ((j16 & 67108864) == 67108864) {
                        this.inviteMode = 8;
                    } else if (this.isOnlyTroopMemberInvite) {
                        this.inviteMode = 8;
                        this.inviteModeDescription = HardCodeUtil.qqStr(R.string.e0d);
                    }
                }
            } else {
                this.inviteModeDescription = HardCodeUtil.qqStr(R.string.e0f);
                this.inviteMode = 1;
            }
            this.nViewExtraFlag |= 4;
            this.dwGroupFlagExt = troopInfo.dwGroupFlagExt;
            this.troopAuthenticateInfo = troopInfo.troopAuthenticateInfo;
            this.dwAuthGroupType = troopInfo.dwAuthGroupType;
            this.nTroopGrade = troopInfo.nTroopGrade;
            this.troopLocation = troopInfo.strLocation;
            int i16 = troopInfo.troopLat;
            if (i16 != 0 && (i3 = troopInfo.troopLon) != 0) {
                this.troopLat = i16;
                this.troopLon = i3;
            }
            this.mIsFreezed = troopInfo.mIsFreezed;
        } else {
            str2 = TAG;
        }
        if (QLog.isColorLevel()) {
            QLog.i(str2, 2, "updateForTroopChatSetting: time = " + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public void updateForTroopInfo(TroopInfo troopInfo, String str) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) troopInfo, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "updateTroopInfoData(), troopinfo = " + troopInfo);
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (troopInfo != null) {
            String str2 = troopInfo.troopuin;
            if (str2 != null) {
                this.troopUin = str2;
            }
            this.troopCode = troopInfo.troopcode;
            this.troopface = troopInfo.troopface;
            this.troopName = troopInfo.troopname;
            this.newTroopName = troopInfo.getNewTroopNameOrTroopName();
            this.cGroupOption = troopInfo.cGroupOption;
            this.mStrJoinQuestion = troopInfo.joinTroopQuestion;
            this.mStrJoinAnswer = troopInfo.joinTroopAnswer;
            this.troopMemo = troopInfo.troopmemo;
            this.troopIntro = troopInfo.fingertroopmemo;
            this.mRichFingerMemo = troopInfo.mRichFingerMemo;
            this.location = troopInfo.location;
            this.grade = troopInfo.grade;
            this.school = troopInfo.school;
            if (this.troopClass == null || this.dwGroupClassExt != troopInfo.dwGroupClassExt) {
                this.dwGroupClassExt = troopInfo.dwGroupClassExt;
                this.troopClass = null;
            }
            if (this.mTroopClassExtText == null) {
                this.mTroopClassExtText = troopInfo.mGroupClassExtText;
            }
            this.isNewTroop = troopInfo.isNewTroop;
            this.hasSetNewTroopHead = troopInfo.hasSetNewTroopHead;
            this.hasSetNewTroopName = troopInfo.hasSetNewTroopName;
            this.isUseClassAvatar = troopInfo.isUseClassAvatar();
            QLog.isColorLevel();
            if (!Utils.p(this.troopowneruin, troopInfo.troopowneruin)) {
                this.troopowneruin = troopInfo.troopowneruin;
                this.troopOwnerNick = null;
                updateOwnerFlag(str);
            }
            this.bAdmin = troopInfo.isOwnerOrAdmin();
            if (!this.bOwner && troopInfo.isOwner()) {
                this.bOwner = true;
            }
            if (!this.bAdmin && troopInfo.isAdmin()) {
                this.bAdmin = true;
            }
            this.troopLocation = troopInfo.strLocation;
            int i16 = troopInfo.troopLat;
            if (i16 != 0 && (i3 = troopInfo.troopLon) != 0) {
                this.troopLat = i16;
                this.troopLon = i3;
            }
            this.dwGroupFlagExt = troopInfo.dwGroupFlagExt;
            this.troopAuthenticateInfo = troopInfo.troopAuthenticateInfo;
            this.dwAuthGroupType = troopInfo.dwAuthGroupType;
            this.mTroopPrivilegeFlag = (int) troopInfo.troopPrivilegeFlag;
            this.mTroopNeedPayNumber = troopInfo.mTroopNeedPayNumber;
            this.troopTags = TroopInfo.getTags(troopInfo.mTags);
            this.troopTypeExt = troopInfo.troopTypeExt;
            this.wMemberNum = troopInfo.wMemberNum;
            this.allowMemberKick = troopInfo.allowMemberKick;
            this.allowMemberAtAll = troopInfo.allowMemberAtAll;
            this.mIsFreezed = troopInfo.mIsFreezed;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "updateTroopInfoData: time = " + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public void updateOwnerFlag(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "updateOwnerFlag currentAccountUin = " + str);
        }
        this.bOwner = Utils.p(str, this.troopowneruin);
    }

    public void updateTroopAdmMemberNum(TroopInfo troopInfo, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) troopInfo, i3);
        } else {
            this.bAdmin = troopInfo.isOwnerOrAdmin();
            this.wMemberNum = i3;
        }
    }

    public void updateTroopOwner(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) str, (Object) str2);
            return;
        }
        this.troopowneruin = str;
        this.troopOwnerNick = null;
        updateOwnerFlag(str2);
        if (!this.bAdmin && this.bOwner) {
            this.bAdmin = true;
        }
    }

    public int getStatOption() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        int statOption = getStatOption(this.nStatOption, this.f294880pa);
        this.nStatOption = statOption;
        return statOption;
    }
}
