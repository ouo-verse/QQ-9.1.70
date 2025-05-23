package com.tencent.mobileqq.data.troop;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.vaswebviewplugin.VasBusiness;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ITroopMemberTempApi;
import com.tencent.qqnt.kernel.nativeinterface.GroupExt;
import com.tencent.qqnt.kernel.nativeinterface.GroupGame;
import com.tencent.qqnt.kernel.nativeinterface.GroupGameList;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberExtListResult;
import com.tencent.qqnt.kernel.nativeinterface.GroupMsgMask;
import com.tencent.qqnt.kernel.nativeinterface.GroupPermissions;
import com.tencent.qqnt.kernel.nativeinterface.GroupSecurityBannedFlag;
import com.tencent.qqnt.kernel.nativeinterface.GroupStatus;
import com.tencent.qqnt.kernel.nativeinterface.GroupTagRecord;
import com.tencent.qqnt.kernel.nativeinterface.MemberLevelName;
import com.tencent.qqnt.kernelpublic.nativeinterface.MemberRole;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class TroopInfo implements Serializable {
    public static final int ALLOW_HISTORY_MSG_READ_FOR_NEW_MEMBER = 4;
    public static final int ALLOW_UPLOAD_TROOP_ALBUM = 1;
    public static final int ALLOW_UPLOAD_TROOP_FILE = 2;
    public static final int CMDUIN_FLAG_EX3_SHOW_GAME_CARD = 1;
    public static final int CMDUIN_FLAG_EX3_SHOW_GAME_SKIN = 2;
    public static final int CMDUIN_FLAG_EX3_SHOW_META_DREAM_CARD = 8;
    public static final int CMDUIN_FLAG_EX3_SHOW_MY_APP_ICON = 64;
    public static final int CMDUIN_FLAG_EX3_SHOW_MY_APP_ICON_SET = 128;
    public static final int CMDUIN_FLAG_EX3_SHOW_MY_GAME_CARD = 16;
    public static final int CMDUIN_FLAG_EX3_SHOW_PLAY_TOGETHER = 4;
    public static final int CONFESS_TALK_OPEN_FLAG = 8192;
    public static final int DEL_PIC_REQ = 2;
    public static final int ESSENTIAL_MSG_PRIVILEGE_ALL_MEMBER = 2;
    public static final int ESSENTIAL_MSG_PRIVILEGE_DEFAULT = 0;
    public static final int ESSENTIAL_MSG_PRIVILEGE_OWNER_OR_ADMIN = 1;
    public static final int GROUP_CLASS_EXT_TYPE_CLASSMATES = 10011;
    public static final int GROUP_CLASS_EXT_TYPE_FANS = 27;
    public static final int GROUP_CLASS_EXT_TYPE_GAME = 25;
    public static final int GROUP_CLASS_EXT_TYPE_HOMEWORK = 32;
    public static final int GROUP_CLASS_EXT_TYPE_IGNORE = 0;
    public static final int GROUP_CLASS_EXT_TYPE_OFFICIAL = 10012;
    public static final int GROUP_CLASS_EXT_TYPE_RELATIVES = 10010;
    public static final int GROUP_CLASS_EXT_TYPE_WORKMATES = 10009;
    public static final int G_FLAG_EX4_HAS_SCHOOL_GROUP_INFO = 128;
    public static final int G_FLAG_EX4_TROOP_GAME_CARD_ENABLED = 4096;
    public static final int G_FLAG_EX4_TROOP_IS_LIVE = 1024;
    public static final int G_FLAG_PRO_1_MASK_HOK = 1;
    public static final int G_FLAG_PRO_1_MASK_MD = 2;
    public static final int INVITE_ROBOT_EXAMINE_DEFAULT = 0;
    public static final int INVITE_ROBOT_EXAMINE_NEED = 2;
    public static final int INVITE_ROBOT_EXAMINE_NONE = 1;
    public static final int INVITE_ROBOT_SWITCH_CLOSE = 1;
    public static final int INVITE_ROBOT_SWITCH_DEFAULT = 0;
    public static final int INVITE_ROBOT_SWITCH_OPEN = 2;
    public static final int JOIN_TROOP_OPTION_ANYBODY = 1;
    public static final int JOIN_TROOP_OPTION_NEED_VERIFY = 2;
    public static final int JOIN_TROOP_OPTION_NOBODY = 3;
    public static final int JOIN_TROOP_OPTION_PAY_TO_JOIN = 6;
    public static final int JOIN_TROOP_OPTION_QA_AUTO = 4;
    public static final int JOIN_TROOP_OPTION_QA_VERIFY = 5;
    public static final int KING_TEAM_APPID = 1104466820;
    public static final int KING_TEAM_TROOP_SUBTYPE_BATTLE = 0;
    public static final int MEMBER_INVITE_ROBOT_SWITCH_ALL = 2;
    public static final int MEMBER_INVITE_ROBOT_SWITCH_DEFAULT = 0;
    public static final int MEMBER_INVITE_ROBOT_SWITCH_ONLY_ADMIN = 1;

    @Deprecated
    public static final int MODIFY_ORDER = 0;
    public static final int NORMAL_MEMBER_CAN_MODIFY_TROOP_NAME_CLOSE = 1;
    public static final int NORMAL_MEMBER_CAN_MODIFY_TROOP_NAME_DEFAULT = 0;
    public static final int NORMAL_MEMBER_CAN_MODIFY_TROOP_NAME_OPEN = 2;
    public static final int ONLY_TROOP_MEMBER_INVITE_JOIN_TROOP = 4;
    public static final int PAY_CHOICE_PAY_TO_JOIN_TROOP = 512;
    public static final int PAY_PRIVILEGE_ALL = 448;
    public static final int PAY_PRIVILEGE_DELIVER_GIFT = 32;
    public static final int PAY_PRIVILEGE_GIFT_SETTLEMENT_ABILITY = 256;
    public static final int PAY_PRIVILEGE_GROUP_FEE = 64;
    public static final int PAY_PRIVILEGE_PAY_TO_JOIN_TROOP = 128;
    public static final int QIDIAN_PRIVATE_TROOP_FLAG = 32;
    public static final String QIDIAN_TROOP_MEMBER_DEF_NICK = HardCodeUtil.qqStr(R.string.f159901tk);
    public static final int QZONE_TROOP_ENTRANCE = 131072;
    public static final int SET_DEFAULT_PIC = 1;
    public static final String TABLE_NAME = "TroopInfoV2";
    public static final String TAG = "TroopInfo";
    public static final int TROOP_AUTO_APPROVAL = 1048576;
    public static final int TROOP_AVGAME_IS_OPENING = 268435456;
    public static final int TROOP_AVGAME_ONLY_ALLOW_MANAGER_CREATE = 536870912;
    public static final int TROOP_GAME_BIND = 2048;
    public static final int TROOP_GAME_TYPE_HONOR_OF_KINGS = 1;
    public static final int TROOP_GAME_TYPE_META_DREAM = 2;
    public static final int TROOP_GUILD_SWITCH_CLOSE = 1;
    public static final int TROOP_GUILD_SWITCH_NONE = -1;
    public static final int TROOP_GUILD_SWITCH_OPEN = 0;
    public static final int TROOP_HONOR_AIO_SWITCH = 33554432;
    public static final int TROOP_LISTEN_TOGETHER = 2097152;
    public static final int TROOP_LUCKY_CHAR_OPEN_SWITCH = 32768;
    public static final long TROOP_NAME_TIME_LIMIT = 86400000;
    public static final int TROOP_PRIVILEGE_INVITE_NEED_REVIEW = 101711872;
    public static final int TROOP_PRIVILEGE_INVITE_WITHOUT_REVIEW = 1048576;
    public static final int TROOP_PRIVILEGE_INVITE_WITHOUT_REVIEW_MEMCOUNT_IN_100 = 67108864;
    public static final int TROOP_PRIVILEGE_INVITE_WITHOUT_REVIEW_MEMCOUNT_IN_50 = 33554432;
    public static final int TROOP_SHARE_LOCATION = 67108864;
    public static final int TROOP_SING_TOGETHER = 16777216;
    public static final int TROOP_STUDY_ROOM_OPEN = 256;
    public static final int TROOP_WATCH_TOGETHER = 4194304;
    public static final int TROOP_WRITE_TOGETHER_SWITCH = 1073741824;
    public static final int TYPE_0X810_GROUP_RING_TONG_ID = 9;
    public static final int TYPE_0X810_GROUP_RING_TONG_SWITCH = 2048;
    public static final int TYPE_0X810_GROUP_VIBRATE_SWITCH = 4096;
    public static final int TYPE_0X810_MSG_HIDE_SWITCH = 512;
    public static final int TYPE_0X810_MSG_PREVIEW_SWITCH = 1024;

    @Deprecated
    public String Administrator;
    public int activeMemberNum;
    public int allowMemberAtAll;
    public int allowMemberKick;
    public long appealDeadline;
    public long associatePubAccount;
    public short cGroupOption;
    public int cityId;
    public long cmdUinFlagEx2;
    public long cmduinFlagEx3Grocery;

    /* renamed from: d, reason: collision with root package name */
    private transient List<MemberLevelName> f203186d;
    public long discussMaxSeq;
    public long discussToTroopTime;
    public String discussUin;
    public long dwAppPrivilegeFlag;
    public long dwAuthGroupType;
    public long dwCmdUinJoinTime;
    public long dwGagTimeStamp;
    public long dwGagTimeStamp_me;
    public long dwGroupClassExt;
    public long dwGroupFlag;
    public long dwGroupFlagExt;
    public long dwGroupFlagExt3;
    public long dwGroupInfoSeq;
    public long dwGroupLevelSeq;
    public int exitTroopReason;
    public TroopExtDBInfo extDBInfo;
    public String fingertroopmemo;
    public int grade;
    public long groupAllianceid;
    public ArrayList<String> groupCardPrefix;
    public String groupCardPrefixIntro;
    public transient GroupExt groupExt;
    public int groupFlagExt4;
    public int groupFreezeReason;
    public transient GroupGameList groupGameList;
    public GroupPermissions groupPermissions;
    public GroupStatus groupStatus;
    public boolean hadInitDetail;
    public boolean hadInitExt;
    public boolean hasSetNewTroopHead;
    public boolean hasSetNewTroopName;
    public long hlGuildAppid;
    public int hlGuildBinary;
    public int hlGuildOrgid;
    public long hlGuildSubType;
    public int inviteNoAuthLimitNum;
    public int isAllowHistoryMsgFlag;
    public boolean isExitByJce;
    public boolean isNewTroop;
    public boolean isTop;
    public boolean isTroopBlocked;
    public String joinTroopAnswer;
    public String joinTroopQuestion;
    public int joinTroopSeq;
    public long lastMsgTime;
    public String location;
    private volatile ConcurrentHashMap<Integer, String> mCachedNewLevelMap;
    public boolean mCanSearchByKeywords;
    public boolean mCanSearchByTroopUin;
    public String mGroupClassExtText;
    public int mIsFreezed;
    public long mMemberCardSeq;
    public boolean mMemberInvitingFlag;
    public long mMemberNickIconSeq;
    public long mMemberNumSeq;
    public String mRichFingerMemo;
    public String mTags;

    @Deprecated(since = "\u4ed8\u8d39\u7fa4\u4e0b\u67b6")
    public float mTroopNeedPayNumber;
    public List<TroopClipPic> mTroopPicList;
    public Set<String> mTroopVerifyingPics;
    public int maxAdminNum;
    public int maxInviteMemNum;
    public MemberRole memberRole;
    public int nMsgLimitFreq;
    public int nTroopGrade;
    public String school;
    public ArrayList<Integer> selectedGameId;
    public long setTopTime;
    public String strLocation;
    public String troopAuthenticateInfo;
    public long troopCreateTime;
    public long troopCreditLevel;
    public int troopLat;
    public int troopLon;
    public String troopNameFromNT;
    public String troopOwnerUid;
    public long troopPrivilegeFlag;
    public String troopRemark;
    public int troopTypeExt;

    @Deprecated
    public String troopcode;
    public short troopface;
    public GroupMsgMask troopmask;
    public String troopmemo;

    @Deprecated(since = "\u7528\u7684\u5730\u65b9\u592a\u591a\uff0c\u5148\u4fdd\u7559\u5b57\u6bb5\uff0c\u65b0\u9700\u6c42\u7d71\u4e00\u4f7f\u7528troopNameFromNT")
    public String troopname;
    public String troopowneruin;

    @unique
    public String troopuin;
    public long udwCmdUinRingtoneID;
    public int wMemberMax;
    public int wMemberNum;

    TroopInfo() {
        this.troopmask = GroupMsgMask.UNSPECIFIED;
        this.dwGroupFlagExt = 0L;
        this.dwAuthGroupType = 0L;
        this.dwGroupInfoSeq = 0L;
        this.mMemberNumSeq = -1L;
        this.mMemberCardSeq = -1L;
        this.mMemberNickIconSeq = -1L;
        this.troopLat = 0;
        this.troopLon = 0;
        this.cityId = 0;
        this.mTroopPicList = Collections.synchronizedList(new ArrayList(8));
        this.mTroopVerifyingPics = new HashSet();
        this.troopPrivilegeFlag = 0L;
        this.mTroopNeedPayNumber = 0.0f;
        this.troopCreditLevel = 5L;
        this.isTroopBlocked = false;
        this.appealDeadline = 0L;
        this.dwAppPrivilegeFlag = 0L;
        this.memberRole = MemberRole.UNSPECIFIED;
        this.groupStatus = null;
        this.troopTypeExt = -1;
        this.dwGroupFlagExt3 = 0L;
        this.cmdUinFlagEx2 = 0L;
        this.lastMsgTime = 0L;
        this.exitTroopReason = 0;
        this.isExitByJce = false;
        this.nMsgLimitFreq = 0;
        this.hlGuildBinary = 1;
        this.isAllowHistoryMsgFlag = 0;
        this.groupCardPrefix = new ArrayList<>();
        this.groupAllianceid = 0L;
        this.groupExt = new GroupExt();
        this.cmduinFlagEx3Grocery = 0L;
        this.extDBInfo = new TroopExtDBInfo();
        this.hadInitDetail = false;
        this.hadInitExt = false;
        this.groupPermissions = new GroupPermissions();
        this.groupGameList = new GroupGameList();
        this.selectedGameId = new ArrayList<>();
    }

    private String a() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return "";
        }
        return peekAppRuntime.getCurrentUid();
    }

    private String b() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return "";
        }
        return peekAppRuntime.getCurrentAccountUin();
    }

    private void c() {
        if (this.f203186d != null) {
            this.mCachedNewLevelMap = new ConcurrentHashMap<>();
            for (MemberLevelName memberLevelName : this.f203186d) {
                this.mCachedNewLevelMap.put(Integer.valueOf(memberLevelName.level), memberLevelName.strName);
            }
        }
    }

    public static String convertMemberUinListToString(List<String> list, int i3) {
        StringBuilder sb5 = new StringBuilder();
        Iterator<String> it = list.iterator();
        int i16 = 0;
        while (it.hasNext()) {
            sb5.append(it.next());
            sb5.append("|");
            i16++;
            if (i16 > i3) {
                break;
            }
        }
        return sb5.toString();
    }

    public static GroupMsgMask convertTroopMask(int i3) {
        for (GroupMsgMask groupMsgMask : GroupMsgMask.values()) {
            if (i3 == groupMsgMask.ordinal()) {
                return groupMsgMask;
            }
        }
        return GroupMsgMask.UNSPECIFIED;
    }

    private synchronized void d() {
        if (this.f203186d == null) {
            this.f203186d = com.tencent.mobileqq.troop.util.b.f301848a.b(this.extDBInfo.newLevelMapStr);
            c();
        }
    }

    private boolean e() {
        if ((this.cmduinFlagEx3Grocery & 4) == 0) {
            return true;
        }
        return false;
    }

    private void f() {
        ArrayList arrayList = new ArrayList(8);
        if (!TextUtils.isEmpty(this.extDBInfo.picListJson)) {
            try {
                JSONArray jSONArray = new JSONArray(this.extDBInfo.picListJson);
                if (jSONArray.length() > 0) {
                    for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i3);
                        String string = jSONObject.getString("id");
                        String optString = jSONObject.optString("clip");
                        if (!TextUtils.isEmpty(string)) {
                            TroopClipPic troopClipPic = new TroopClipPic();
                            if (string.equals(String.valueOf(this.extDBInfo.avatarId))) {
                                troopClipPic.type = 1;
                            }
                            troopClipPic.f203184id = string;
                            troopClipPic.clipInfo = optString;
                            arrayList.add(troopClipPic);
                        }
                    }
                }
            } catch (JSONException e16) {
                e16.printStackTrace();
            } catch (Exception e17) {
                e17.printStackTrace();
            }
        }
        this.mTroopPicList.clear();
        this.mTroopPicList.addAll(arrayList);
    }

    private void g(String str) {
        JSONArray jSONArray = new JSONArray();
        try {
            for (TroopClipPic troopClipPic : this.mTroopPicList) {
                if (!TextUtils.isEmpty(troopClipPic.f203184id)) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("id", troopClipPic.f203184id);
                    if (!TextUtils.isEmpty(troopClipPic.clipInfo)) {
                        jSONObject.put("clip", troopClipPic.clipInfo);
                    }
                    jSONArray.mo162put(jSONObject);
                }
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        } catch (Exception e17) {
            e17.printStackTrace();
        }
        this.extDBInfo.picListJson = jSONArray.toString();
        ((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).updateTroopInfoPicListJson(this.troopuin, jSONArray.toString(), "TroopInfo-" + str);
    }

    public static List<String> getTags(String str) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            for (String str2 : str.split("\n")) {
                arrayList.add(str2);
            }
        }
        return arrayList;
    }

    public static String getTagsString(List<String> list) {
        StringBuilder sb5 = new StringBuilder();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            sb5.append(it.next());
            sb5.append("\n");
        }
        if (sb5.length() > 0) {
            sb5.deleteCharAt(sb5.length() - 1);
        }
        return sb5.toString();
    }

    public static boolean hasCover(TroopInfo troopInfo) {
        if (troopInfo == null) {
            return false;
        }
        Iterator<TroopClipPic> it = troopInfo.mTroopPicList.iterator();
        while (it.hasNext()) {
            if (it.next().type == 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasPayPrivilege(long j3, int i3) {
        if (((j3 | 32) & i3) != 0) {
            return true;
        }
        return false;
    }

    public static boolean isCmdUinFlagEx2Open(long j3, int i3) {
        if ((j3 & i3) != 0) {
            return true;
        }
        return false;
    }

    public static boolean isQidianPrivateTroop(long j3) {
        return (j3 & 32) != 0;
    }

    public static boolean isVisitorSpeakEnabled(int i3) {
        if ((i3 & 8192) == 8192) {
            return true;
        }
        return false;
    }

    public static String parseNTTags(List<GroupTagRecord> list) {
        StringBuilder sb5 = new StringBuilder();
        if (list != null && list.size() > 0) {
            for (GroupTagRecord groupTagRecord : list) {
                if (!TextUtils.isEmpty(groupTagRecord.tagValue)) {
                    sb5.append(new String(groupTagRecord.tagValue.getBytes(StandardCharsets.UTF_8)));
                    sb5.append("\n");
                }
            }
            if (sb5.length() > 0) {
                sb5.deleteCharAt(sb5.length() - 1);
            }
        }
        return sb5.toString();
    }

    public boolean canModifyTroopName() {
        int memberChangeGroupNameSwitch;
        if (isOwnerOrAdmin() || (memberChangeGroupNameSwitch = getMemberChangeGroupNameSwitch()) == 2) {
            return true;
        }
        if (memberChangeGroupNameSwitch == 1) {
            return false;
        }
        return this.isNewTroop;
    }

    public boolean checkAdminByNt() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("105870", true);
    }

    public boolean checkFlagExt4(int i3) {
        if ((i3 & this.groupFlagExt4) > 0) {
            return true;
        }
        return false;
    }

    public boolean checkFreezeReason(int i3) {
        if ((i3 & this.groupFreezeReason) > 0) {
            return true;
        }
        return false;
    }

    public long getBlockExpireTime() {
        if (this.groupExt == null) {
            return 0L;
        }
        return r0.blacklistExpireTime;
    }

    public int getBlockType() {
        GroupExt groupExt = this.groupExt;
        if (groupExt == null) {
            return 0;
        }
        return groupExt.groupSecurityBannedFlag;
    }

    public int getFansTroopStarId() {
        GroupExt groupExt = this.groupExt;
        if (groupExt != null) {
            return groupExt.starId;
        }
        return 0;
    }

    public int getGroupFlagPro1MaskFromGameType(int i3) {
        int i16 = 1;
        if (i3 != 1) {
            i16 = 2;
            if (i3 != 2) {
                return 0;
            }
        }
        return i16;
    }

    public String getLatestMemo() {
        String str = this.extDBInfo.strLastAnnouncement;
        if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.troopmemo)) {
            return this.troopmemo;
        }
        return str;
    }

    public int getMemNumForAutoInviteIntoGroup(String str) {
        int i3;
        boolean z16;
        long j3 = this.troopPrivilegeFlag;
        if ((j3 & 1048576) == 1048576) {
            i3 = -1;
        } else if ((j3 & 33554432) == 33554432) {
            i3 = 50;
        } else if ((j3 & 67108864) == 67108864) {
            i3 = 100;
        } else {
            i3 = 0;
        }
        if (!isTroopOwner(str) && !isTroopAdmin(str)) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!hasInviteMemAuth() && !z16) {
            return 0;
        }
        if (i3 != -1 && !z16) {
            return Math.min(this.maxInviteMemNum, i3);
        }
        return this.maxInviteMemNum;
    }

    public int getMemberChangeGroupNameSwitch() {
        GroupExt groupExt = this.groupExt;
        if (groupExt == null) {
            return 0;
        }
        return groupExt.memberChangeGroupNameSwitch;
    }

    public int getMemberNum() {
        return this.wMemberNum;
    }

    public int getMemberNumClient() {
        int i3 = this.extDBInfo.memberNumClient;
        if (i3 == -1) {
            return this.wMemberNum;
        }
        return i3;
    }

    public ConcurrentHashMap<Integer, String> getNewTroopLevelMap() {
        if (this.mCachedNewLevelMap == null) {
            return new ConcurrentHashMap<>();
        }
        return this.mCachedNewLevelMap;
    }

    public String getNewTroopNameOrTroopName() {
        if (!TextUtils.isEmpty(this.troopNameFromNT)) {
            return this.troopNameFromNT;
        }
        return "";
    }

    public boolean getStudyRoomOpen() {
        return checkFlagExt4(256);
    }

    public long getTopBannerNotifySeq() {
        GroupExt groupExt = this.groupExt;
        if (groupExt == null) {
            return 0L;
        }
        return groupExt.topBannerSeq;
    }

    public String getTroopDisplayName() {
        if (!TextUtils.isEmpty(this.troopRemark)) {
            return this.troopRemark;
        }
        return getNewTroopNameOrTroopName();
    }

    public long getTroopGuildId() {
        GroupExt groupExt = this.groupExt;
        if (groupExt != null) {
            return groupExt.bindGuildId;
        }
        return 0L;
    }

    public String getTroopUin() {
        return this.troopuin;
    }

    public String getUniqueBlockFlag() {
        return this.isTroopBlocked + "-" + getBlockType() + "-" + getBlockExpireTime() + "-" + hadJoinTroop();
    }

    public int groupFlagPro1() {
        return (int) this.groupExt.groupFlagPro1;
    }

    public int groupFlagPro1Mask() {
        return (int) (this.groupExt.groupFlagPro1 >> 32);
    }

    public boolean hadJoinTroop() {
        GroupStatus groupStatus = this.groupStatus;
        if (groupStatus != null && groupStatus != GroupStatus.KDELETE && isMember()) {
            return true;
        }
        return false;
    }

    public boolean hasInviteMemAuth() {
        boolean z16;
        if (hasPayPrivilege(this.troopPrivilegeFlag, 128) && hasPayPrivilege(this.troopPrivilegeFlag, 512)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if ((this.mMemberInvitingFlag || isOwnerOrAdmin()) && (isOwnerOrAdmin() || this.cGroupOption != 3 || z16)) {
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TroopInfo.class.getSimpleName(), 2, "hasInviteMemAuth\uff1amMemberInvitingFlag=" + this.mMemberInvitingFlag + ", mTroopInfoData.isOwnerOrAdim() = " + isOwnerOrAdmin() + ", mTroopInfoData.cGroupOption=" + ((int) this.cGroupOption) + ", isPayToJoinTroop=" + z16);
        }
        return false;
    }

    public boolean hasOrgs() {
        return false;
    }

    public boolean hasSetTroopHead() {
        GroupExt groupExt;
        List<TroopClipPic> list;
        if (!TextUtils.isEmpty(this.discussUin) && this.discussUin.length() > 2) {
            if ((this.extDBInfo.avatarId > 0 && (list = this.mTroopPicList) != null && !list.isEmpty()) || (groupExt = this.groupExt) == null || groupExt.hasGroupCustomPortrait != 2) {
                return true;
            }
            return false;
        }
        if (!this.isNewTroop) {
            return true;
        }
        return this.hasSetNewTroopHead;
    }

    public boolean hasSetTroopName() {
        if (this.isNewTroop) {
            return this.hasSetNewTroopName;
        }
        return true;
    }

    public boolean hasTroopAssociation() {
        if (this.groupAllianceid != 0) {
            return true;
        }
        return false;
    }

    public boolean isAVGameOpen() {
        if ((this.dwGroupFlagExt3 & VasBusiness.QWALLET) != 0) {
            return true;
        }
        return false;
    }

    public boolean isAdmin() {
        if (checkAdminByNt()) {
            if (this.memberRole != MemberRole.ADMIN) {
                return false;
            }
            return true;
        }
        if (this.memberRole == MemberRole.ADMIN) {
            return true;
        }
        String b16 = b();
        if (TextUtils.isEmpty(b16)) {
            return false;
        }
        return isTroopAdmin(b16);
    }

    public boolean isAllowCreateDiscuss() {
        if ((this.troopPrivilegeFlag & 32768) == 0) {
            return true;
        }
        return false;
    }

    public boolean isAllowCreateTempConv() {
        if ((this.troopPrivilegeFlag & 65536) == 0) {
            return true;
        }
        return false;
    }

    public boolean isAutoApprovalOpen() {
        if ((this.dwGroupFlagExt3 & 1048576) == 1048576) {
            return true;
        }
        return false;
    }

    public boolean isDisband() {
        if (this.exitTroopReason == 2) {
            return true;
        }
        return false;
    }

    public boolean isExited() {
        if (this.exitTroopReason != 0) {
            return true;
        }
        return false;
    }

    public boolean isFansTroop() {
        if (this.dwGroupClassExt == 27) {
            return true;
        }
        return false;
    }

    public boolean isGameBind() {
        if ((this.dwGroupFlagExt3 & 2048) != 0) {
            return true;
        }
        return false;
    }

    public boolean isGameTroop() {
        if (this.dwGroupClassExt == 25) {
            return true;
        }
        return false;
    }

    public boolean isHistoryMsgReadEnableForNewMember() {
        if (this.isAllowHistoryMsgFlag == 1) {
            return true;
        }
        return false;
    }

    public boolean isHomeworkTroop() {
        if (this.dwGroupClassExt == 32) {
            return true;
        }
        return false;
    }

    public boolean isKicked() {
        if (this.exitTroopReason == 1) {
            return true;
        }
        return false;
    }

    public boolean isKingBattleTroop() {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "hlGuildAppid:" + this.hlGuildAppid + ",subType:" + this.hlGuildSubType);
        }
        if (this.hlGuildAppid == 1104466820 && this.hlGuildSubType == 0) {
            return true;
        }
        return false;
    }

    public boolean isLevelMapInited() {
        if (this.f203186d != null) {
            return true;
        }
        return false;
    }

    public boolean isListenTogetherOpen() {
        if ((this.dwGroupFlagExt3 & 2097152) != 0) {
            return true;
        }
        return false;
    }

    public boolean isMember() {
        MemberRole memberRole = this.memberRole;
        if (memberRole != MemberRole.MEMBER && memberRole != MemberRole.ADMIN && memberRole != MemberRole.OWNER) {
            return false;
        }
        return true;
    }

    public boolean isNeedClearAutoApproval() {
        if (this.cGroupOption == 2 && (this.troopPrivilegeFlag & 512) != 512) {
            return false;
        }
        return true;
    }

    public boolean isNeedInterceptOnBlockTroop() {
        if (this.isTroopBlocked && hadJoinTroop()) {
            return true;
        }
        return false;
    }

    public boolean isNewTroop() {
        return this.isNewTroop;
    }

    public boolean isNotSetTroopClassInfo() {
        if ((this.groupFlagExt4 & 128) == 0) {
            return true;
        }
        return false;
    }

    public boolean isOnlyAllowManagerCreateAVGame() {
        if ((this.dwGroupFlagExt3 & 536870912) != 0) {
            return true;
        }
        return false;
    }

    public boolean isOnlyTroopMemberInviteOption() {
        if ((this.dwGroupFlagExt3 & 4) != 0) {
            return true;
        }
        return false;
    }

    public boolean isOwner() {
        if (checkAdminByNt()) {
            if (this.memberRole != MemberRole.OWNER) {
                return false;
            }
            return true;
        }
        if (this.memberRole == MemberRole.OWNER) {
            return true;
        }
        String b16 = b();
        if (TextUtils.isEmpty(b16)) {
            return false;
        }
        return isTroopOwner(b16);
    }

    public boolean isOwnerOrAdmin(String str) {
        return isTroopOwner(str) || isTroopAdmin(str);
    }

    public boolean isPassiveExit() {
        if (!isKicked() && !isDisband()) {
            return false;
        }
        return true;
    }

    public boolean isReadableBlock() {
        if (this.isTroopBlocked && getBlockType() == GroupSecurityBannedFlag.READABLE.ordinal() && hadJoinTroop()) {
            return true;
        }
        return false;
    }

    public boolean isSharingLocation() {
        if ((this.dwGroupFlagExt3 & 67108864) != 0) {
            return true;
        }
        return false;
    }

    @Deprecated(since = "9.1.10")
    public boolean isShowMyGameCardEnabled() {
        if ((this.cmduinFlagEx3Grocery & 1) == 0) {
            return true;
        }
        return false;
    }

    public boolean isShowMyGameCardEnabledV2() {
        if ((this.cmduinFlagEx3Grocery & 16) == 0) {
            return true;
        }
        return false;
    }

    public boolean isThirdAppBind() {
        if (this.hlGuildBinary != 1) {
            return true;
        }
        return false;
    }

    public boolean isTogetherBusinessOpen(int i3) {
        if ((this.dwGroupFlagExt3 & i3) != 0) {
            return true;
        }
        return false;
    }

    public boolean isTroopAdmin(String str) {
        String str2 = this.Administrator;
        if (str2 != null && str2.contains(str)) {
            return true;
        }
        if (this.memberRole == MemberRole.ADMIN && str != null && str.equals(b())) {
            return true;
        }
        return false;
    }

    public boolean isTroopGameCardEnabled() {
        return isTroopHOKGameCardEnabled();
    }

    public boolean isTroopGameCardEnabledV2() {
        Iterator<GroupGame> it = this.groupGameList.gameInfos.iterator();
        while (it.hasNext()) {
            GroupGame next = it.next();
            if (next.notAllowSelected == 0 && this.selectedGameId.contains(Integer.valueOf(next.gameId))) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "isTroopGameCardEnabledV2: game=" + next.gameInfo);
                    return true;
                }
                return true;
            }
        }
        return false;
    }

    public boolean isTroopGuild() {
        if (getTroopGuildId() != 0) {
            return true;
        }
        return false;
    }

    public boolean isTroopGuildSwitchOpen() {
        if (this.extDBInfo.troopGuildSwitchOpen != 1) {
            return true;
        }
        return false;
    }

    public boolean isTroopHOKGameCardEnabled() {
        if ((groupFlagPro1Mask() & 1) == 1) {
            if ((groupFlagPro1() & 1) == 1) {
                return true;
            }
            return false;
        }
        if ((this.groupFlagExt4 & 4096) != 0) {
            return true;
        }
        return false;
    }

    public boolean isTroopHonorOpen() {
        if ((this.dwGroupFlagExt3 & 33554432) == 0) {
            return true;
        }
        return false;
    }

    public boolean isTroopIlive() {
        boolean z16;
        if ((this.groupFlagExt4 & 1024) != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.i("IliveGroup", 1, String.format("isTroopIlive %s", Boolean.valueOf(z16)));
        return z16;
    }

    public boolean isTroopMDGameCardEnabled() {
        if ((groupFlagPro1Mask() & 2) != 2 || (groupFlagPro1() & 2) != 2) {
            return false;
        }
        return true;
    }

    public boolean isTroopOwner(String str) {
        boolean z16;
        boolean z17;
        if (str != null && str.equals(this.troopowneruin)) {
            return true;
        }
        String troopMemberUidSync = ((ITroopMemberTempApi) QRoute.api(ITroopMemberTempApi.class)).getTroopMemberUidSync(str);
        if (troopMemberUidSync != null && troopMemberUidSync.equals(this.troopOwnerUid)) {
            this.troopowneruin = str;
            return true;
        }
        if (str != null && str.equals(b())) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (troopMemberUidSync != null && troopMemberUidSync.equals(a())) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (this.memberRole == MemberRole.OWNER && (z16 || z17)) {
            return true;
        }
        return false;
    }

    public boolean isUnreadableBlock() {
        if (this.isTroopBlocked && !isReadableBlock()) {
            return true;
        }
        return false;
    }

    public boolean isUseClassAvatar() {
        if (!this.isNewTroop && (this.dwGroupFlagExt & 131072) != 0) {
            return true;
        }
        return false;
    }

    public boolean isWatchTogetherOpen() {
        if ((this.dwGroupFlagExt3 & 4194304) != 0) {
            return true;
        }
        return false;
    }

    public void markHadJoinTroop() {
        this.groupStatus = GroupStatus.KENABLE;
        this.memberRole = MemberRole.MEMBER;
        if (this.dwCmdUinJoinTime <= 0) {
            this.dwCmdUinJoinTime = NetConnInfoCenter.getServerTime();
        }
    }

    public boolean memberCanInviteRobot() {
        if (isOwnerOrAdmin()) {
            return true;
        }
        if (!notAllowJoinTroop() && this.groupExt.inviteRobotMemberSwitch != 1) {
            return true;
        }
        return false;
    }

    public boolean normalMemberCanModifyTroopName() {
        int memberChangeGroupNameSwitch = getMemberChangeGroupNameSwitch();
        if (memberChangeGroupNameSwitch == 0) {
            return this.isNewTroop;
        }
        if (memberChangeGroupNameSwitch == 2) {
            return true;
        }
        return false;
    }

    public boolean notAllowJoinTroop() {
        if (this.cGroupOption == 3) {
            return true;
        }
        return false;
    }

    public void onLoadExtInfoFromDB() {
        f();
        d();
    }

    @Nullable
    @Deprecated
    public ArrayList<Long> parseTroopMemberList() {
        ArrayList<Long> arrayList = new ArrayList<>();
        String str = this.extDBInfo.troopSettingMemberList;
        if (str != null) {
            for (String str2 : str.split("\\|")) {
                try {
                    arrayList.add(Long.valueOf(Long.parseLong(str2)));
                } catch (NumberFormatException unused) {
                    if (QLog.isColorLevel()) {
                        QLog.d("troopInfo_member", 2, "parse error: " + str2);
                    }
                }
            }
        }
        return arrayList;
    }

    public void setCmdUinFlagEx2(boolean z16, int i3) {
        if (z16) {
            this.cmdUinFlagEx2 = i3 | this.cmdUinFlagEx2;
        } else {
            this.cmdUinFlagEx2 = (~i3) & this.cmdUinFlagEx2;
        }
    }

    public void setGroupFlagPro1(int i3, int i16) {
        int i17 = (int) (this.groupExt.groupFlagPro1 >> 32);
        int groupFlagPro1 = groupFlagPro1();
        int i18 = i17 | i3;
        int i19 = ((~i3) & groupFlagPro1) | i16;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "setGroupFlagPro1: old=" + i17 + ":" + groupFlagPro1 + ", new=" + i18 + ":" + i19);
        }
        this.groupExt.groupFlagPro1 = (i18 << 32) | i19;
    }

    public void setMemberNumClient(int i3) {
        TroopExtDBInfo troopExtDBInfo = this.extDBInfo;
        if (troopExtDBInfo.memberNumClient != -1) {
            troopExtDBInfo.memberNumClient = i3;
        }
    }

    public void setOnlyTroopMemberInviteOption(boolean z16) {
        if (z16) {
            this.dwGroupFlagExt3 |= 4;
        } else {
            this.dwGroupFlagExt3 &= -5;
        }
    }

    public void setTroopUin(String str) {
        this.troopuin = str;
        this.extDBInfo.troopUin = str;
    }

    @Deprecated(since = "9.1.10")
    public boolean shouldShowMyGameCard() {
        if (isTroopGameCardEnabled() && isShowMyGameCardEnabled()) {
            return true;
        }
        return false;
    }

    public boolean shouldShowPlayTogetherStatus() {
        return e();
    }

    public boolean shouldShowTroopLevel() {
        if ((this.dwGroupFlagExt & VasBusiness.CHAT_FONT_SWITCH) == VasBusiness.CHAT_FONT_SWITCH) {
            return true;
        }
        return false;
    }

    public String toString() {
        String fuzzyLog;
        String str = this.troopuin;
        String str2 = this.troopNameFromNT;
        if (TextUtils.isEmpty(str)) {
            str = "[no uin]";
        }
        if (TextUtils.isEmpty(str2)) {
            fuzzyLog = "[no name]";
        } else {
            fuzzyLog = ((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).fuzzyLog(str2);
        }
        return "TroopInfo:{uin:" + str + ", name:" + fuzzyLog + ", tUin:" + this.troopowneruin + ", memberRole:" + this.memberRole + ", exitTroopReason:" + this.exitTroopReason + ", groupStatus:" + this.groupStatus + "}";
    }

    public void updateHeadMemberList(String str) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "updateHeadMemberList=" + str);
        }
        this.extDBInfo.headerUinsNew = str;
    }

    public synchronized void updateTroopLevelMap(GroupMemberExtListResult groupMemberExtListResult) {
        this.f203186d = groupMemberExtListResult.msgLevelNameNew;
        this.dwGroupLevelSeq = groupMemberExtListResult.levelNameSeq;
        c();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "levelMap seq=" + this.dwGroupLevelSeq);
        }
    }

    public void updateTroopPicList(List<TroopClipPic> list, String str) {
        this.mTroopPicList.clear();
        this.mTroopPicList.addAll(list);
        g(str);
    }

    public boolean isOwnerOrAdmin() {
        if (checkAdminByNt()) {
            MemberRole memberRole = this.memberRole;
            return memberRole == MemberRole.ADMIN || memberRole == MemberRole.OWNER;
        }
        MemberRole memberRole2 = this.memberRole;
        if (memberRole2 == MemberRole.ADMIN || memberRole2 == MemberRole.OWNER) {
            return true;
        }
        String b16 = b();
        if (TextUtils.isEmpty(b16)) {
            return false;
        }
        return isTroopOwner(b16) || isTroopAdmin(b16);
    }

    public boolean isQidianPrivateTroop() {
        return isQidianPrivateTroop(this.dwGroupFlagExt3);
    }

    public TroopInfo(String str) {
        this.troopmask = GroupMsgMask.UNSPECIFIED;
        this.dwGroupFlagExt = 0L;
        this.dwAuthGroupType = 0L;
        this.dwGroupInfoSeq = 0L;
        this.mMemberNumSeq = -1L;
        this.mMemberCardSeq = -1L;
        this.mMemberNickIconSeq = -1L;
        this.troopLat = 0;
        this.troopLon = 0;
        this.cityId = 0;
        this.mTroopPicList = Collections.synchronizedList(new ArrayList(8));
        this.mTroopVerifyingPics = new HashSet();
        this.troopPrivilegeFlag = 0L;
        this.mTroopNeedPayNumber = 0.0f;
        this.troopCreditLevel = 5L;
        this.isTroopBlocked = false;
        this.appealDeadline = 0L;
        this.dwAppPrivilegeFlag = 0L;
        this.memberRole = MemberRole.UNSPECIFIED;
        this.groupStatus = null;
        this.troopTypeExt = -1;
        this.dwGroupFlagExt3 = 0L;
        this.cmdUinFlagEx2 = 0L;
        this.lastMsgTime = 0L;
        this.exitTroopReason = 0;
        this.isExitByJce = false;
        this.nMsgLimitFreq = 0;
        this.hlGuildBinary = 1;
        this.isAllowHistoryMsgFlag = 0;
        this.groupCardPrefix = new ArrayList<>();
        this.groupAllianceid = 0L;
        this.groupExt = new GroupExt();
        this.cmduinFlagEx3Grocery = 0L;
        this.extDBInfo = new TroopExtDBInfo();
        this.hadInitDetail = false;
        this.hadInitExt = false;
        this.groupPermissions = new GroupPermissions();
        this.groupGameList = new GroupGameList();
        this.selectedGameId = new ArrayList<>();
        this.troopuin = str;
        this.extDBInfo.troopUin = str;
    }

    public TroopInfo(long j3) {
        this(String.valueOf(j3));
    }
}
