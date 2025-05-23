package com.tencent.mobileqq.icgame.data.anchor.sso;

/* compiled from: P */
/* loaded from: classes15.dex */
public class QQLiveAnchorFansGroupItem {
    private static final String GROUP_CARD_SCHEMA = "mqqapi://card/show_pslcard?src_type=internal&version=1&card_type=group&source=external&uin={uin}&wSourceSubID=60003&authSig={authSig}";
    public String auth;
    public String groupCardSchema;
    public long groupId;
    public int isMember;
    public long memberNum;
    public String name;

    public static String fillGroupCardSchema(long j3, String str) {
        return GROUP_CARD_SCHEMA.replace("{uin}", j3 + "").replace("{authSig}", str + "");
    }

    public String toString() {
        return "QQLiveAnchorFansGroupItem{groupId=" + this.groupId + ", name='" + this.name + "', memberNum=" + this.memberNum + ", isMember=" + this.isMember + ", auth='" + this.auth + "', groupCardSchema='" + this.groupCardSchema + "'}";
    }
}
