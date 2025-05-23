package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
@uniqueConstraints(clause = ConflictClause.REPLACE, columnNames = "feedsId")
/* loaded from: classes9.dex */
public class TroopNotificationCache extends Entity {
    static IPatchRedirector $redirector_ = null;
    public static final int FEED_TYPE_NEW_GUIDE = 34;
    public static final int FEED_TYPE_NOTICE = 23;
    public static final int SERVICE_ID_NEW_OBJ_STREAM = 20;
    public static final int SERVICE_ID_NOTIFICATION = 27;
    public int appId;
    public String ctrlStr;
    public String currentUin;
    public int feedType;
    public String feedsId;
    public long filterID;
    public boolean needConfirm;
    public boolean read;
    public int serviceID;
    public int src;
    public int time;
    public String title;
    public long troopUin;
    public long userUin;
    public byte[] xmlBytes;

    public TroopNotificationCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.feedType = 34;
            this.read = false;
        }
    }
}
