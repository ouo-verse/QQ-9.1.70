package com.tencent.mobileqq.data;

/* compiled from: P */
/* loaded from: classes10.dex */
public class TroopMessageNavigateInfo extends BaseMessageNavigateInfo {
    public static final int EXT_OBJ_TYPE_NONE = 0;
    public static final int EXT_OBJ_TYPE_OFFLINE = 1;
    public String extObjJsonStr;
    public int extObjType = 0;
    public String troopCode;

    public String toString() {
        return "TroopMessageNavigateInfo{troopCode='" + this.troopCode + ", type=" + this.type + ", shmsgseq=" + this.shmsgseq + ", msgseq=" + this.msgseq + ", status=" + this.status + ", extObjType=" + this.extObjType + '}';
    }
}
