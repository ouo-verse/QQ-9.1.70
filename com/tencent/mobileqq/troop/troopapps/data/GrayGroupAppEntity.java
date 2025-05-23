package com.tencent.mobileqq.troop.troopapps.data;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;
import com.tencent.mobileqq.troop.troopapps.g;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
@uniqueConstraints(clause = ConflictClause.REPLACE, columnNames = "groupUin")
/* loaded from: classes19.dex */
public class GrayGroupAppEntity extends Entity {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "GrayGroupAppEntity";
    public long groupUin;
    public int requestIntervalSecond;

    @notColumn
    public List<TroopAIOAppInfo> troopAIOAppInfos;
    private byte[] troopAIOAppInfosData;
    public long updatedTimestamp;

    public GrayGroupAppEntity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.troopAIOAppInfos = new ArrayList(20);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.Entity
    public void postRead() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.postRead();
        Object c16 = g.c(this.troopAIOAppInfosData);
        if (c16 != null) {
            try {
                this.troopAIOAppInfos = (List) c16;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "postRead: failed. ", e16);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.Entity
    public void prewrite() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            super.prewrite();
            this.troopAIOAppInfosData = g.h(this.troopAIOAppInfos);
        }
    }
}
