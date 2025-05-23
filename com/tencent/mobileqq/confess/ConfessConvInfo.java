package com.tencent.mobileqq.confess;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
@uniqueConstraints(clause = ConflictClause.FAIL, columnNames = "uin,type,topicId,holmesCurCount,holmesTolCount")
/* loaded from: classes5.dex */
public class ConfessConvInfo extends Entity {
    static IPatchRedirector $redirector_ = null;
    private static final String tableName = "confess_conv_info";
    public int holmesCurCount;
    public int holmesTolCount;
    public long lastread;
    public int topicId;
    public int type;
    public String uin;
    public int unreadCount;

    public ConfessConvInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this);
    }

    public static String getConversationInfoTableName() {
        return tableName;
    }

    @Override // com.tencent.mobileqq.persistence.Entity
    public String getTableName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (String) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return getConversationInfoTableName();
    }

    public ConfessConvInfo(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.uin = str;
        this.type = i3;
        this.topicId = i16;
    }

    public ConfessConvInfo(String str, int i3, int i16, long j3, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j3), Integer.valueOf(i17));
            return;
        }
        this.uin = str;
        this.type = i3;
        this.topicId = i16;
        this.lastread = j3;
        this.unreadCount = i17;
    }
}
