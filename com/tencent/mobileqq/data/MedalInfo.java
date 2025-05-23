package com.tencent.mobileqq.data;

import com.tencent.mobileqq.medalwall.MedalID;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.util.Utils;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes10.dex */
public class MedalInfo extends Entity {

    @notColumn
    public static final int READ_STATE_DEFAULT = 0;

    @notColumn
    public static final int READ_STATE_LOCAL_READ = 2;

    @notColumn
    public static final int READ_STATE_UNREAD = 1;

    @unique
    public int iId;
    public int iLevel;
    public int iLevelCount;
    public int iNoProgress;
    public int iPointLevel1;
    public int iPointLevel2;
    public int iPointLevel3;
    public int iType;
    public int iUnreadLevel1;
    public int iUnreadLevel2;
    public int iUnreadLevel3;
    public long lEndTime;
    public long lObtainTimeLevel1;
    public long lObtainTimeLevel2;
    public long lObtainTimeLevel3;
    public long lSeqLevel1;
    public long lSeqLevel2;
    public long lSeqLevel3;
    public String strDescLevel1;
    public String strDescLevel2;
    public String strDescLevel3;
    public String strDetailUrlLevel1;
    public String strDetailUrlLevel2;
    public String strDetailUrlLevel3;
    public String strName;
    public String strResJson;
    public String strTaskDescLevel1;
    public String strTaskDescLevel2;
    public String strTaskDescLevel3;

    public boolean isNewer(MedalInfo medalInfo) {
        if (medalInfo == null) {
            return true;
        }
        long j3 = this.lObtainTimeLevel1;
        if (Utils.l(j3, this.lObtainTimeLevel2) < 0) {
            j3 = this.lObtainTimeLevel2;
        }
        if (Utils.l(j3, this.lObtainTimeLevel3) < 0) {
            j3 = this.lObtainTimeLevel3;
        }
        long j16 = medalInfo.lObtainTimeLevel1;
        if (Utils.l(j16, medalInfo.lObtainTimeLevel2) < 0) {
            j16 = medalInfo.lObtainTimeLevel2;
        }
        if (Utils.l(j16, medalInfo.lObtainTimeLevel3) < 0) {
            j16 = medalInfo.lObtainTimeLevel3;
        }
        if (Utils.l(j3, j16) > 0) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0031, code lost:
    
        if (r5.iUnreadLevel3 != 1) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x000a, code lost:
    
        if (r5.iUnreadLevel1 == 1) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x000d, code lost:
    
        r2 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean isUnread() {
        boolean z16;
        int i3 = this.iLevel;
        boolean z17 = true;
        if (i3 != 255) {
            if (this.iLevelCount <= 1) {
                return false;
            }
            if (i3 >= 1 && this.iUnreadLevel1 == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (i3 >= 2) {
                if (!z16 && this.iUnreadLevel2 != 1) {
                    z16 = false;
                } else {
                    z16 = true;
                }
            }
            if (i3 >= 3) {
                if (!z16) {
                }
                return z17;
            }
            return z16;
        }
    }

    public void putReportInfo(ArrayList<MedalID> arrayList) {
        if (arrayList == null) {
            return;
        }
        int i3 = this.iLevel;
        if (i3 == 255) {
            if (this.iUnreadLevel1 == 1) {
                arrayList.add(new MedalID(this.iId, 255));
                return;
            }
            return;
        }
        if (this.iUnreadLevel1 == 1 && i3 >= 1) {
            arrayList.add(new MedalID(this.iId, 1));
        }
        if (this.iUnreadLevel2 == 1 && this.iLevel >= 2) {
            arrayList.add(new MedalID(this.iId, 2));
        }
        if (this.iUnreadLevel3 == 1 && this.iLevel >= 3) {
            arrayList.add(new MedalID(this.iId, 3));
        }
    }

    public void setRead() {
        int i3 = this.iLevel;
        if (i3 == 255) {
            this.iUnreadLevel1 = 2;
            return;
        }
        if (i3 >= 1) {
            this.iUnreadLevel1 = 2;
        }
        if (i3 >= 2) {
            this.iUnreadLevel2 = 2;
        }
        if (i3 >= 3) {
            this.iUnreadLevel3 = 2;
        }
    }
}
