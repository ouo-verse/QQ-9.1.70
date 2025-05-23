package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.persistence.uniqueConstraints;

/* compiled from: P */
@uniqueConstraints(clause = ConflictClause.REPLACE, columnNames = "uin,type")
/* loaded from: classes10.dex */
public class DraftTextInfo extends Entity {
    public String guildArticleMsgMediaPreview;
    public String mAtInfoStr;
    public String mSourceAtInfoStr;
    public int mSourceMsgTime;
    public String mSourceRichMsg;
    public int mSourceSummaryFlag;
    public int mSourceType = 0;
    public long mSourceUid;
    public String mixedMsgInfoHtml;
    public long parentMsgSeq;
    public long rootMsgSeq;
    public long sourceMsgSeq;
    public String sourceMsgText;
    public String sourceMsgTroopName;
    public long sourceSenderUin;
    public long sourceToUin;
    public String text;
    public long time;
    public int type;

    @unique
    public String uin;
}
