package com.tencent.mobileqq.troop.data;

import android.text.format.DateFormat;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopAIONotifyItem extends Entity {
    static IPatchRedirector $redirector_ = null;
    public static final int HIDE_AFTER_CLICK = 2;
    public static final int HIDE_AFTER_SHOW = 1;
    public static final int TYPE_APP_NOTIFY = 1;
    public static final int TYPE_PUSH_NOTIFY = 2;
    public long appId;
    public long expireTime;
    public int hideMode;
    public String icon;

    /* renamed from: id, reason: collision with root package name */
    @unique
    public String f294764id;
    public String summary;
    public String title;
    public String troopUin;
    public int type;
    public String url;

    public TroopAIONotifyItem() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public boolean equals(Object obj) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, obj)).booleanValue();
        }
        if ((obj instanceof TroopAIONotifyItem) && (str = this.f294764id) != null) {
            return str.equals(((TroopAIONotifyItem) obj).f294764id);
        }
        return false;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "[id=" + this.f294764id + ", title=" + this.title + ", summary=" + this.summary + ", jumpUrl=" + this.url + ", iconUrl=" + this.icon + ", type=" + this.type + ", expireTime=" + DateFormat.format("yyyy-MM-dd kk.mm.ss", this.expireTime * 1000).toString() + ", hideMode=" + this.hideMode + ", troopUin=" + this.troopUin + ", appId=" + this.appId + "]";
    }
}
