package com.tencent.mobileqq.troop.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopAioTopADInfo extends Entity {
    static IPatchRedirector $redirector_;
    public int adId;
    public String backgroundUrl;
    public String jumpUrl;
    public String moreUrl;
    public String picUrl;
    public int showType;
    public String strWord;

    @unique
    public String troopUin;
    public String uiUrl;
    public long validTime;

    public TroopAioTopADInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "TroopAioTopADInfo{troopUin='" + this.troopUin + "', adId=" + this.adId + ", backgroundUrl='" + this.backgroundUrl + "', moreUrl='" + this.moreUrl + "', picUrl='" + this.picUrl + "', validTime=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.SIMPLIFIED_CHINESE).format(new Date(this.validTime * 1000)) + ", showType=" + this.showType + ", strWord='" + this.strWord + "', uiUrl='" + this.uiUrl + "', jumpUrl='" + this.jumpUrl + "'}";
    }
}
