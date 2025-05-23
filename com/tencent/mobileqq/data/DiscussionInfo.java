package com.tencent.mobileqq.data;

import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.troopmemberlist.ITroopMemberListActivityApi;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes10.dex */
public class DiscussionInfo extends Entity {
    public static final long UIControlFlag_Hidden_RecentUser = 1;
    public static final long UIControlFlag_default = 0;
    public long createTime;
    public String discussionName;
    public String faceUinSet;
    public long groupCode;
    public long groupUin;
    public long infoSeq;
    public String inheritOwnerUin;

    @notColumn
    public long lastMsgTime;
    public int mComparePartInt;
    public String mCompareSpell;
    public String ownerUin;
    public long timeSec;

    @unique
    public String uin;
    public long DiscussionFlag = 536870912;
    public long mOrigin = -1;
    public long mOriginExtra = 0;
    public int mSelfRight = -1;
    public boolean hasCollect = false;

    @notColumn
    public int mUnreliableMemberCount = 100;
    public int createFrom = 0;
    public long uiControlFlag = 0;

    public static boolean isValidDisUin(String str) {
        try {
            if (Long.valueOf(Long.parseLong(str)).longValue() < 1000000) {
                return false;
            }
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.Entity
    public boolean entityByCursor(Cursor cursor) {
        boolean z16;
        int columnIndex = cursor.getColumnIndex("uin");
        if (columnIndex >= 0) {
            this.uin = cursor.getString(columnIndex);
        }
        int columnIndex2 = cursor.getColumnIndex("infoSeq");
        if (columnIndex2 >= 0) {
            this.infoSeq = cursor.getLong(columnIndex2);
        }
        int columnIndex3 = cursor.getColumnIndex("ownerUin");
        if (columnIndex3 >= 0) {
            this.ownerUin = cursor.getString(columnIndex3);
        }
        int columnIndex4 = cursor.getColumnIndex("discussionName");
        if (columnIndex4 >= 0) {
            this.discussionName = cursor.getString(columnIndex4);
        }
        int columnIndex5 = cursor.getColumnIndex(WadlProxyConsts.CREATE_TIME);
        if (columnIndex5 >= 0) {
            this.createTime = cursor.getLong(columnIndex5);
        }
        int columnIndex6 = cursor.getColumnIndex("timeSec");
        if (columnIndex6 >= 0) {
            this.timeSec = cursor.getLong(columnIndex6);
        }
        int columnIndex7 = cursor.getColumnIndex("faceUinSet");
        if (columnIndex7 >= 0) {
            this.faceUinSet = cursor.getString(columnIndex7);
        }
        int columnIndex8 = cursor.getColumnIndex("DiscussionFlag");
        if (columnIndex8 >= 0) {
            this.DiscussionFlag = cursor.getLong(columnIndex8);
        }
        int columnIndex9 = cursor.getColumnIndex("mComparePartInt");
        if (columnIndex9 >= 0) {
            this.mComparePartInt = cursor.getInt(columnIndex9);
        }
        int columnIndex10 = cursor.getColumnIndex("mCompareSpell");
        if (columnIndex10 >= 0) {
            this.mCompareSpell = cursor.getString(columnIndex10);
        }
        int columnIndex11 = cursor.getColumnIndex("groupCode");
        if (columnIndex11 >= 0) {
            this.groupCode = cursor.getLong(columnIndex11);
        }
        int columnIndex12 = cursor.getColumnIndex("groupUin");
        if (columnIndex12 >= 0) {
            this.groupUin = cursor.getLong(columnIndex12);
        }
        int columnIndex13 = cursor.getColumnIndex("hasCollect");
        if (columnIndex13 >= 0) {
            if (cursor.getInt(columnIndex13) != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.hasCollect = z16;
        }
        int columnIndex14 = cursor.getColumnIndex("inheritOwnerUin");
        if (columnIndex14 >= 0) {
            this.inheritOwnerUin = cursor.getString(columnIndex14);
        }
        int columnIndex15 = cursor.getColumnIndex("createFrom");
        if (columnIndex15 >= 0) {
            this.createFrom = cursor.getInt(columnIndex15);
        }
        int columnIndex16 = cursor.getColumnIndex("uiControlFlag");
        if (columnIndex16 >= 0) {
            this.uiControlFlag = cursor.getLong(columnIndex16);
        }
        int columnIndex17 = cursor.getColumnIndex("mOrigin");
        if (columnIndex17 >= 0) {
            this.mOrigin = cursor.getLong(columnIndex17);
        }
        int columnIndex18 = cursor.getColumnIndex("mOriginExtra");
        if (columnIndex18 >= 0) {
            this.mOriginExtra = cursor.getLong(columnIndex18);
        }
        int columnIndex19 = cursor.getColumnIndex("mSelfRight");
        if (columnIndex19 >= 0) {
            this.mSelfRight = cursor.getInt(columnIndex19);
        }
        if (QLog.isDevelopLevel()) {
            QLog.w("DiscussionInfo", 1, "DiscussionInfo, " + this);
        }
        return true;
    }

    public int getHrExtra() {
        return ((ITroopMemberListActivityApi) QRoute.api(ITroopMemberListActivityApi.class)).hrExtra(this.mOriginExtra);
    }

    public boolean hasRenamed() {
        if (((this.DiscussionFlag & 64) >>> 6) == 0) {
            return true;
        }
        return false;
    }

    public boolean isDiscussHrMeeting() {
        return ((ITroopMemberListActivityApi) QRoute.api(ITroopMemberListActivityApi.class)).isHRConf(this.mOrigin);
    }

    public boolean isHidden() {
        if ((this.mOrigin & 2) == 2 && getHrExtra() == 1 && ((ITroopMemberListActivityApi) QRoute.api(ITroopMemberListActivityApi.class)).isNoRight(this.mSelfRight)) {
            return true;
        }
        return false;
    }

    public boolean isOwnerOrInheritOwner(String str) {
        if (!TextUtils.isEmpty(this.inheritOwnerUin) && !"0".equals(this.inheritOwnerUin) && str.equals(this.inheritOwnerUin)) {
            return true;
        }
        if (!TextUtils.isEmpty(this.ownerUin) && !"0".equals(this.ownerUin) && str.equals(this.ownerUin)) {
            return true;
        }
        return false;
    }

    public boolean isPSTNConf() {
        return ((ITroopMemberListActivityApi) QRoute.api(ITroopMemberListActivityApi.class)).isPSTNConf(this.mOrigin);
    }

    public boolean isUIControlFlag_Hidden_RecentUser() {
        if ((this.uiControlFlag & 1) == 1) {
            return true;
        }
        return false;
    }

    public void removeUIControlFlag_Hidden_RecentUser() {
        this.uiControlFlag &= -2;
    }

    public String toString() {
        return "uin[" + this.uin + "], discussionName[" + this.discussionName + "], mOrigin[" + this.mOrigin + "], mOriginExtra[" + this.mOriginExtra + "], mSelfRight[" + this.mSelfRight + "], isHidden[" + isHidden() + "]";
    }
}
