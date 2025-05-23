package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.l;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import tencent.im.oidb.hotchat.Common$WifiPOIInfo;

/* compiled from: P */
/* loaded from: classes10.dex */
public class HotChatInfo extends Entity implements Serializable, Cloneable {
    public static final int RU_STATE_DELETED = 1;
    public static final int RU_STATE_NORMAL = 0;
    public static final int STATE_FORCE_PULL_TROOP_MSG = 8;
    public static final int STATE_HOT_CHAT_IS_DISBANDED = 7;
    public static final int STATE_JOINED = 0;
    public static final int STATE_KICK_OUT = 6;
    public static final int STATE_LEFT_AS_OVERCOUNT = 9;
    public static final int STATE_LEFT_LONG_TIME_NOT_SAY = 1;
    public static final int STATE_LEFT_LONG_WAY_TO_GO = 3;
    public static final int STATE_LEFT_NORMAL = 4;
    public static final int STATE_SHELL = 5;
    public static final int SUB_TYPE_PTT = 1;
    private static final long serialVersionUID = 4511795799007124151L;
    public int adminLevel;
    public int apolloGameId;
    public String detail;
    public String extra1;
    public int faceId;
    public boolean hasJoined;
    public int hotChatType;
    public int hotThemeGroupFlag;
    public String iconUrl;
    public boolean isWifiHotChat;
    public String joinUrl;
    public long lLastMsgSeq;
    public long leftTime;
    public int mFissionRoomNum;
    public int memberCount;
    public String memo;
    public boolean memoShowed;
    public String memoUrl;
    public String name;
    public String ownerUin;
    public int pkFlag;
    public long robotUin;
    public String signature;
    public String strAdminUins;
    public int subType;
    public boolean supportDemo;
    public boolean supportFlashPic;
    public String troopCode;

    @unique
    public String troopUin;
    public int uint32_group_flag_ext2;
    public int userCreate;
    public String uuid;
    public int state = 4;
    public int ruState = 0;
    public boolean isFavorite = false;
    public long praiseCount = 0;

    @notColumn
    public List<String> adminUins = new ArrayList();
    public boolean isGameRoom = false;
    public boolean isRobotHotChat = false;

    @notColumn
    private boolean mHasRedPoint = false;

    @notColumn
    private long mLastUpdateRedPointTime = 0;

    public static HotChatInfo createHotChat(Common$WifiPOIInfo common$WifiPOIInfo, boolean z16) {
        return createHotChat(common$WifiPOIInfo, z16, 0);
    }

    public static String pack(List<String> list) {
        if (list != null && !list.isEmpty()) {
            JSONArray jSONArray = new JSONArray();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                jSONArray.mo162put(it.next());
            }
            return jSONArray.toString();
        }
        return "";
    }

    public static List<String> unPack(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                String str2 = (String) jSONArray.get(i3);
                if (!TextUtils.isEmpty(str2)) {
                    arrayList.add(str2);
                }
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        return arrayList;
    }

    public void clearRedPoint() {
        long serverTime = NetConnInfoCenter.getServerTime();
        if (serverTime > this.mLastUpdateRedPointTime) {
            this.mHasRedPoint = false;
            this.mLastUpdateRedPointTime = serverTime;
        }
    }

    public String getName() {
        return "";
    }

    public boolean hasPostRedPoint() {
        return this.mHasRedPoint;
    }

    public boolean isBuLuoHotChat() {
        if (TextUtils.isEmpty(this.uuid)) {
            return false;
        }
        return Pattern.compile("(\\d+)(-T-)").matcher(this.uuid).find();
    }

    public boolean need2ReqRedPoint() {
        if (this.mLastUpdateRedPointTime == 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.Entity
    public void postRead() {
        super.postRead();
        if (!TextUtils.isEmpty(this.strAdminUins)) {
            this.adminUins = unPack(this.strAdminUins);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.Entity
    public void prewrite() {
        super.prewrite();
        List<String> list = this.adminUins;
        if (list != null && list.size() > 0) {
            this.strAdminUins = pack(this.adminUins);
        }
    }

    public void setHasRedPoint() {
        long serverTime = NetConnInfoCenter.getServerTime();
        if (serverTime > this.mLastUpdateRedPointTime) {
            this.mHasRedPoint = true;
            this.mLastUpdateRedPointTime = serverTime;
        }
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder(512);
        sb5.append("HotChatInfo [name=");
        sb5.append(this.name);
        sb5.append(", troopCode=");
        sb5.append(this.troopCode);
        sb5.append(", signature=");
        sb5.append(this.signature);
        sb5.append(", troopUin=");
        sb5.append(this.troopUin);
        sb5.append(", faceId=");
        sb5.append(this.faceId);
        sb5.append(", memberCount=");
        sb5.append(this.memberCount);
        sb5.append(", hasJoined=");
        sb5.append(this.hasJoined);
        sb5.append(", isWifiHotChat=");
        sb5.append(this.isWifiHotChat);
        sb5.append(", uuid=");
        sb5.append(this.uuid);
        sb5.append(", detail=");
        sb5.append(this.detail);
        sb5.append(", state=");
        sb5.append(this.state);
        sb5.append(", leftTime=");
        sb5.append(this.leftTime);
        sb5.append(",face_url=");
        sb5.append(this.iconUrl);
        sb5.append(", hot_theme_group_flag=");
        sb5.append(this.hotThemeGroupFlag);
        sb5.append(", supportFlashPic=");
        sb5.append(this.supportFlashPic);
        sb5.append(", supportDemo=");
        sb5.append(this.supportDemo);
        sb5.append(",adminLevel=");
        sb5.append(this.adminLevel);
        sb5.append(",joinUrl=");
        sb5.append(this.joinUrl);
        sb5.append(",hotChatType=");
        sb5.append(this.hotChatType);
        sb5.append(",memo=");
        sb5.append(this.memo);
        sb5.append(",memoUrl=");
        sb5.append(this.memoUrl);
        sb5.append(",userCreate=");
        sb5.append(this.userCreate);
        sb5.append(",strAdminUins=");
        sb5.append(this.strAdminUins);
        sb5.append(",ownerUin=");
        sb5.append(this.ownerUin);
        sb5.append(",pkFlag=");
        sb5.append(this.pkFlag);
        sb5.append(", subType=");
        sb5.append(this.subType);
        sb5.append(", lLastMsgSeq=");
        sb5.append(this.lLastMsgSeq);
        sb5.append(", extral=");
        sb5.append(this.extra1);
        sb5.append(", mFissionRoomNum=");
        sb5.append(this.mFissionRoomNum);
        sb5.append(", praiseCount=");
        sb5.append(this.praiseCount);
        sb5.append(", uint32_group_flag_ext2=");
        sb5.append(this.uint32_group_flag_ext2);
        sb5.append(", apolloGameId=");
        sb5.append(this.apolloGameId);
        sb5.append("]");
        return sb5.toString();
    }

    public static HotChatInfo createHotChat(Common$WifiPOIInfo common$WifiPOIInfo, boolean z16, int i3) {
        HotChatInfo hotChatInfo = new HotChatInfo();
        hotChatInfo.faceId = common$WifiPOIInfo.uint32_face_id.get();
        hotChatInfo.memberCount = common$WifiPOIInfo.uint32_visitor_num.get();
        hotChatInfo.troopUin = String.valueOf(Utils.P(common$WifiPOIInfo.uint32_group_code.get()));
        hotChatInfo.troopCode = String.valueOf(Utils.P(common$WifiPOIInfo.uint32_group_uin.get()));
        hotChatInfo.isWifiHotChat = z16;
        hotChatInfo.name = common$WifiPOIInfo.bytes_name.get().toStringUtf8();
        hotChatInfo.signature = common$WifiPOIInfo.bytes_sig.get().toStringUtf8();
        hotChatInfo.hasJoined = common$WifiPOIInfo.uint32_is_member.get() > 0;
        hotChatInfo.uuid = common$WifiPOIInfo.bytes_uid.get().toStringUtf8();
        hotChatInfo.iconUrl = common$WifiPOIInfo.face_url.get();
        hotChatInfo.hotThemeGroupFlag = common$WifiPOIInfo.hot_theme_group_flag.get();
        hotChatInfo.supportFlashPic = (common$WifiPOIInfo.uint32_special_flag.get() & 1) != 0;
        hotChatInfo.supportDemo = (i3 & 2) != 0;
        hotChatInfo.adminLevel = common$WifiPOIInfo.uint32_is_admin.get();
        hotChatInfo.joinUrl = common$WifiPOIInfo.string_join_group_url.get();
        hotChatInfo.hotChatType = common$WifiPOIInfo.uint32_group_type_flag.get();
        hotChatInfo.userCreate = common$WifiPOIInfo.uint32_is_user_create.get();
        hotChatInfo.ownerUin = String.valueOf(common$WifiPOIInfo.uint64_owner_uin.get());
        hotChatInfo.pkFlag = common$WifiPOIInfo.uint32_tv_pk_flag.get();
        hotChatInfo.isFavorite = common$WifiPOIInfo.uint64_favorites_time.get() > 0;
        hotChatInfo.subType = common$WifiPOIInfo.uint32_sub_type.get();
        hotChatInfo.lLastMsgSeq = common$WifiPOIInfo.uint64_last_msg_seq.get();
        hotChatInfo.mFissionRoomNum = common$WifiPOIInfo.uint32_group_id.get();
        hotChatInfo.praiseCount = common$WifiPOIInfo.uint64_praise_nums.has() ? common$WifiPOIInfo.uint64_praise_nums.get() : 0L;
        hotChatInfo.uint32_group_flag_ext2 = common$WifiPOIInfo.uint32_group_flag_ext2.get();
        hotChatInfo.isRobotHotChat = common$WifiPOIInfo.uint32_is_robot_group.has() && common$WifiPOIInfo.uint32_is_robot_group.get() == 1;
        hotChatInfo.robotUin = common$WifiPOIInfo.uint64_robot_uin.get();
        if (QLog.isDevelopLevel()) {
            l.c("PttShow", "createHotChat_WifiPOIInfo", hotChatInfo);
        }
        return hotChatInfo;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public HotChatInfo m170clone() {
        try {
            return (HotChatInfo) super.clone();
        } catch (Exception unused) {
            return null;
        }
    }
}
