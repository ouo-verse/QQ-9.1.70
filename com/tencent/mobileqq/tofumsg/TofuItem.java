package com.tencent.mobileqq.tofumsg;

import androidx.annotation.NonNull;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.troop.announcement.api.ITroopAnnouncementHelperApi;
import java.io.UnsupportedEncodingException;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import tencent.im.oidb.cmd0xe61.oidb_0xe61$BeancurdCubeInfo;

/* compiled from: P */
@KeepClassConstructor
@uniqueConstraints(clause = ConflictClause.REPLACE, columnNames = "frdUin,busId")
/* loaded from: classes18.dex */
public class TofuItem extends Entity {
    static IPatchRedirector $redirector_ = null;
    public static final long ONE_DAY_SECONDS = 86400;
    public int busId;

    @notColumn
    public byte[] bytesFromClient;

    @notColumn
    public byte[] bytesFromServer;

    @notColumn
    public long eventTs;

    @notColumn
    public long flags;
    public long frdUin;
    public long lastPullTsLocal;
    public long lastPullTsSvr;

    /* renamed from: msg, reason: collision with root package name */
    @notColumn
    public String f293239msg;
    public byte[] msgData;
    public long pullInterval;

    @notColumn
    public long validTime;

    public TofuItem() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.pullInterval = 86400L;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public boolean bInsertImmediate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        if ((this.flags & 2) != 0) {
            return true;
        }
        return false;
    }

    public boolean bNeedDelHistory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        if ((this.flags & 1) != 0) {
            return true;
        }
        return false;
    }

    public void cloneFrom(@NotNull TofuItem tofuItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) tofuItem);
            return;
        }
        this.eventTs = tofuItem.eventTs;
        this.pullInterval = tofuItem.pullInterval;
        this.lastPullTsSvr = tofuItem.lastPullTsSvr;
        this.lastPullTsLocal = tofuItem.lastPullTsLocal;
        this.validTime = tofuItem.validTime;
        this.flags = tofuItem.flags;
        this.bytesFromServer = tofuItem.bytesFromServer;
        this.bytesFromClient = tofuItem.bytesFromClient;
    }

    public oidb_0xe61$BeancurdCubeInfo packToPbReq() {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (oidb_0xe61$BeancurdCubeInfo) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        try {
            j3 = Long.valueOf(BaseApplicationImpl.getApplication().getRuntime().getAccount()).longValue();
        } catch (Exception unused) {
            j3 = 0;
        }
        if (j3 == 0) {
            return null;
        }
        oidb_0xe61$BeancurdCubeInfo oidb_0xe61_beancurdcubeinfo = new oidb_0xe61$BeancurdCubeInfo();
        oidb_0xe61_beancurdcubeinfo.uint64_frd_uin.set(this.frdUin);
        oidb_0xe61_beancurdcubeinfo.uint64_busi_id.set(k.a(this.busId));
        oidb_0xe61_beancurdcubeinfo.uint64_uin.set(j3);
        oidb_0xe61_beancurdcubeinfo.uint64_last_pull_time.set(this.lastPullTsSvr);
        return oidb_0xe61_beancurdcubeinfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.Entity
    public void postRead() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        try {
            byte[] bArr = this.msgData;
            if (bArr != null) {
                this.f293239msg = new String(bArr, "UTF-8");
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.Entity
    public void prewrite() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        String str = this.f293239msg;
        if (str != null && str != null) {
            try {
                this.msgData = str.getBytes("UTF-8");
            } catch (UnsupportedEncodingException e16) {
                e16.printStackTrace();
            }
        }
    }

    @NonNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return "frdUin" + ContainerUtils.KEY_VALUE_DELIMITER + MobileQQ.getShortUinStr(Long.toString(this.frdUin)) + "|busId" + ContainerUtils.KEY_VALUE_DELIMITER + k.b(this.busId) + "|eventTs" + ContainerUtils.KEY_VALUE_DELIMITER + this.eventTs + "|pullInterval" + ContainerUtils.KEY_VALUE_DELIMITER + this.pullInterval + "|lastPullTsLocal" + ContainerUtils.KEY_VALUE_DELIMITER + this.lastPullTsLocal + "|lastPullTsSvr" + ContainerUtils.KEY_VALUE_DELIMITER + this.lastPullTsSvr + "|" + ITroopAnnouncementHelperApi.CONTROL_INFO_VAILD_TIME + ContainerUtils.KEY_VALUE_DELIMITER + this.validTime + "|" + WadlProxyConsts.FLAGS + ContainerUtils.KEY_VALUE_DELIMITER + this.flags + "|msg" + ContainerUtils.KEY_VALUE_DELIMITER + this.f293239msg;
    }

    public TofuItem(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, i3);
            return;
        }
        this.pullInterval = 86400L;
        this.frdUin = Long.valueOf(str).longValue();
        this.busId = i3;
    }
}
