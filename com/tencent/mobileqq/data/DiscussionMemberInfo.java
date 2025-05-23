package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.uniqueConstraints;

/* compiled from: P */
@uniqueConstraints(clause = ConflictClause.IGNORE, columnNames = "discussionUin,memberUin")
/* loaded from: classes10.dex */
public class DiscussionMemberInfo extends Entity {
    public long dataTime;
    public String discussionUin;

    @notColumn
    public String displayedNamePinyinFirst;
    public byte flag;
    public String inteRemark;
    public long inteRemarkSource;
    public String memberName;
    public String memberUin;

    public String getDiscussionMemberName() {
        String str;
        if (!TextUtils.isEmpty(this.inteRemark)) {
            str = this.inteRemark;
        } else {
            str = this.memberName;
        }
        if (TextUtils.isEmpty(str)) {
            return this.memberUin;
        }
        return str;
    }
}
