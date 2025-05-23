package com.tencent.mobileqq.troop.shortcutbar;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopShortcutBarInfo implements Serializable {
    static IPatchRedirector $redirector_;
    private ArrayList<TroopShortcutBarApp> appList;
    private long cache_ts_mil;
    private int disabled;
    private long groupClassExt;
    private int group_disabled;
    private long nextFetchRedPointTsMil;
    private int redPointCacheTsMil;
    private long switch_ts;
    private long troopCode;

    public TroopShortcutBarInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.cache_ts_mil = 0L;
        this.nextFetchRedPointTsMil = 0L;
        this.redPointCacheTsMil = 0;
        this.switch_ts = 0L;
        this.troopCode = 0L;
        this.disabled = 0;
        this.group_disabled = 0;
        this.appList = null;
        this.groupClassExt = 0L;
    }

    public TroopShortcutBarApp getApp(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (TroopShortcutBarApp) iPatchRedirector.redirect((short) 11, (Object) this, j3);
        }
        Iterator<TroopShortcutBarApp> it = this.appList.iterator();
        while (it.hasNext()) {
            TroopShortcutBarApp next = it.next();
            if (next.getAppId() == j3) {
                return next;
            }
        }
        return null;
    }

    public List<Long> getAppIds() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (List) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        ArrayList arrayList = new ArrayList();
        Iterator<TroopShortcutBarApp> it = this.appList.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(it.next().getAppId()));
        }
        return arrayList;
    }

    public ArrayList<TroopShortcutBarApp> getAppList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (ArrayList) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.appList;
    }

    public long getCacheTSMil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Long) iPatchRedirector.redirect((short) 7, (Object) this)).longValue();
        }
        return this.cache_ts_mil;
    }

    public int getDisabled() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.disabled;
    }

    public long getGroupClassExt() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Long) iPatchRedirector.redirect((short) 17, (Object) this)).longValue();
        }
        return this.groupClassExt;
    }

    public int getGroupDisabled() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.group_disabled;
    }

    public long getNextFetchRedPointTsMil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Long) iPatchRedirector.redirect((short) 12, (Object) this)).longValue();
        }
        return this.nextFetchRedPointTsMil;
    }

    public int getRedPointCacheTsMil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        return this.redPointCacheTsMil;
    }

    public long getSwitch_ts() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Long) iPatchRedirector.redirect((short) 16, (Object) this)).longValue();
        }
        return this.switch_ts;
    }

    public void setCacheTSMil(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
        } else {
            this.cache_ts_mil = i3;
        }
    }

    public void setDisabled(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else {
            this.disabled = i3;
        }
    }

    public void setGroupDisabled(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else {
            this.group_disabled = i3;
        }
    }

    public void setNextFetchRedPointTsMil(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, j3);
        } else {
            this.nextFetchRedPointTsMil = j3;
        }
    }

    public void setRedPointCacheTsMil(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, i3);
        } else {
            this.redPointCacheTsMil = i3;
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (String) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return "TroopShortcutBarInfo{troopCode='" + this.troopCode + "'disabled='" + this.disabled + "', group_disabled='" + this.group_disabled + "'}";
    }

    public TroopShortcutBarInfo(long j3, int i3, int i16, int i17, int i18, long j16, long j17, ArrayList<TroopShortcutBarApp> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Long.valueOf(j16), Long.valueOf(j17), arrayList);
            return;
        }
        this.cache_ts_mil = 0L;
        this.disabled = 0;
        this.group_disabled = 0;
        this.nextFetchRedPointTsMil = 0L;
        this.redPointCacheTsMil = 0;
        this.switch_ts = 0L;
        this.troopCode = j3;
        this.cache_ts_mil = System.currentTimeMillis() + (i3 * 1000);
        this.disabled = i16;
        this.group_disabled = i17;
        this.redPointCacheTsMil = i18 * 1000;
        this.appList = arrayList;
        this.switch_ts = j16;
        this.groupClassExt = j17;
    }
}
