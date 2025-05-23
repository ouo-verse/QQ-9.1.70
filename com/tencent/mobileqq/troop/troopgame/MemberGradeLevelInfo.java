package com.tencent.mobileqq.troop.troopgame;

import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.Serializable;

/* compiled from: P */
@uniqueConstraints(clause = ConflictClause.IGNORE, columnNames = "memberuin")
/* loaded from: classes19.dex */
public class MemberGradeLevelInfo extends Entity implements Serializable {
    static IPatchRedirector $redirector_;
    public int gameCardId;
    public int gameCardSwitch;
    public int gradeLevel;

    @unique
    public String memberuin;

    public MemberGradeLevelInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.gradeLevel = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.Entity
    public boolean entityByCursor(Cursor cursor) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) cursor)).booleanValue();
        }
        int columnIndex = cursor.getColumnIndex("memberuin");
        if (columnIndex >= 0) {
            this.memberuin = cursor.getString(columnIndex);
        }
        int columnIndex2 = cursor.getColumnIndex("gradeLevel");
        if (columnIndex2 >= 0) {
            this.gradeLevel = cursor.getInt(columnIndex2);
            return true;
        }
        return true;
    }

    public boolean equals(MemberGradeLevelInfo memberGradeLevelInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) memberGradeLevelInfo)).booleanValue();
        }
        if (memberGradeLevelInfo == null || TextUtils.isEmpty(this.memberuin) || TextUtils.isEmpty(memberGradeLevelInfo.memberuin) || !this.memberuin.equals(memberGradeLevelInfo.memberuin) || this.gradeLevel != memberGradeLevelInfo.gradeLevel || this.gameCardId != memberGradeLevelInfo.gameCardId || this.gameCardSwitch != memberGradeLevelInfo.gameCardSwitch) {
            return false;
        }
        return true;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "memberuin = " + this.memberuin + ", gradeLevel = " + this.gradeLevel + ", gameCardId = " + this.gameCardId + ", gameCardSwitch = " + this.gameCardSwitch;
    }
}
