package com.tencent.mobileqq.highway.ipv6;

import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.conn.IConnection;
import com.tencent.mobileqq.highway.segment.RequestWorker;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public class HappyEyeballsRace {
    static IPatchRedirector $redirector_;
    public List<IConnection> mConnList;
    public boolean mIsIpv6Fast;
    public boolean mIsRacing;
    public Runnable mRacingRunnable;

    public HappyEyeballsRace() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.mConnList = new LinkedList();
        }
    }

    private synchronized void breakOtherConns(IConnection iConnection) {
        BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Conn, "HappyEyeballsRace.breakOtherConns, mConnList.size() = " + this.mConnList.size());
        Iterator<IConnection> it = this.mConnList.iterator();
        while (it.hasNext()) {
            IConnection next = it.next();
            if (next.getConnId() != iConnection.getConnId()) {
                BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Conn, "HappyEyeballsRace.breakOtherConns, connId = " + next.getConnId());
                next.disConnect();
            }
            it.remove();
        }
    }

    public void doOnConect(boolean z16, IConnection iConnection, HwEngine hwEngine) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), iConnection, hwEngine);
            return;
        }
        BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Conn, "HappyEyeballsRace.doOnConect , isSuccess = " + z16 + " ,connId = " + iConnection.getConnId());
        if (z16) {
            doOnConnSuc(iConnection, hwEngine);
        } else {
            doOnConnFail(iConnection);
        }
    }

    public synchronized void doOnConnFail(IConnection iConnection) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) iConnection);
            return;
        }
        BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Conn, "HappyEyeballsRace.doOnConnFail. mIsRacing = " + this.mIsRacing);
        if (this.mIsRacing) {
            this.mConnList.remove(iConnection);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("HappyEyeballsRace.doOnConnFail, mRacingRunnable == null : ");
            if (this.mRacingRunnable == null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            sb5.append(" , mConnList.size() = ");
            sb5.append(this.mConnList.size());
            BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Conn, sb5.toString());
            if (this.mRacingRunnable == null && this.mConnList.size() == 0) {
                this.mIsRacing = false;
            }
        }
    }

    public void doOnConnSuc(IConnection iConnection, HwEngine hwEngine) {
        RequestWorker.RequestHandler requestHandler;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) iConnection, (Object) hwEngine);
            return;
        }
        BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Conn, "HappyEyeballsRace.doOnConnSuc.");
        if (this.mIsRacing) {
            this.mIsRacing = false;
            Runnable runnable = this.mRacingRunnable;
            if (runnable != null && (requestHandler = hwEngine.mRequestWorker.mRequestHandler) != null) {
                requestHandler.removeCallbacks(runnable);
            }
            breakOtherConns(iConnection);
            this.mIsIpv6Fast = iConnection.isIpv6();
            BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Conn, "HappyEyeballsRace.doOnConnSuc, mIsIpv6Fast = " + this.mIsIpv6Fast);
        }
    }
}
