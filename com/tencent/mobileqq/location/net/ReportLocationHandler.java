package com.tencent.mobileqq.location.net;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.location.data.LocationRoom;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tencent.im.oidb.location.RoomOperate$ReqReportLocation;
import tencent.im.oidb.location.RoomOperate$RspReportLocation;

/* compiled from: P */
/* loaded from: classes15.dex */
public class ReportLocationHandler extends com.tencent.mobileqq.location.net.a<LocationHandler> {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name */
    private static int f241337g;

    /* renamed from: a, reason: collision with root package name */
    private final Handler f241338a;

    /* renamed from: b, reason: collision with root package name */
    private final AtomicBoolean f241339b;

    /* renamed from: c, reason: collision with root package name */
    private Runnable f241340c;

    /* renamed from: d, reason: collision with root package name */
    private int f241341d;

    /* renamed from: e, reason: collision with root package name */
    private Long f241342e;

    /* renamed from: f, reason: collision with root package name */
    private a f241343f;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface a {
        com.tencent.mobileqq.location.data.a getLocation();
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26739);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            f241337g = 2000;
        }
    }

    public ReportLocationHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f241339b = new AtomicBoolean(true);
            this.f241338a = new Handler(ThreadManagerV2.getSubThreadLooper());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(int i3, long j3, com.tencent.mobileqq.location.data.a aVar) {
        if (QLog.isColorLevel()) {
            QLog.d("ReportLocationHandler", 2, "requestReportLocation: invoked. ", "uinType = [" + i3 + "], sessionUin = [" + j3 + "], locationItem = [" + aVar + "]");
        }
        RoomOperate$ReqReportLocation roomOperate$ReqReportLocation = new RoomOperate$ReqReportLocation();
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        roomOperate$ReqReportLocation.room_key.set(com.tencent.mobileqq.location.util.b.a(waitAppRuntime, 0, j3));
        roomOperate$ReqReportLocation.room_key.setHasFlag(true);
        roomOperate$ReqReportLocation.direction.set(aVar.c());
        LatLng b16 = aVar.b();
        if (b16 == null) {
            if (QLog.isColorLevel()) {
                QLog.d("ReportLocationHandler", 2, "requestReportLocation: invoked. ", " latLng: ", b16);
            }
        } else {
            roomOperate$ReqReportLocation.lat.set(b16.latitude);
            roomOperate$ReqReportLocation.lon.set(b16.longitude);
            ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", waitAppRuntime.getAccount(), "QQLBSShareSvc.report_location");
            toServiceMsg.putWupBuffer(roomOperate$ReqReportLocation.toByteArray());
            l().sendPbReq(toServiceMsg);
        }
    }

    private void v() {
        if (QLog.isColorLevel()) {
            QLog.d("ReportLocationHandler", 2, "stopReport: invoked. ", " loopReportStopped: ", this.f241339b);
        }
        this.f241339b.set(true);
        Runnable runnable = this.f241340c;
        if (runnable != null) {
            this.f241338a.removeCallbacks(runnable);
        }
    }

    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ReportLocationHandler", 2, "destroy: invoked. ");
        }
        v();
        this.f241338a.removeCallbacksAndMessages(null);
    }

    protected LocationHandler l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (LocationHandler) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return LocationHandler.K2();
    }

    public boolean m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return !this.f241339b.get();
    }

    public boolean n(LocationRoom.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) bVar)).booleanValue();
        }
        if (!m()) {
            return false;
        }
        return new LocationRoom.b(this.f241341d, "" + this.f241342e).equals(bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String o() {
        return this.f241342e + "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int p() {
        return this.f241341d;
    }

    public void s(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (a(toServiceMsg, fromServiceMsg, obj)) {
            try {
                RoomOperate$RspReportLocation mergeFrom = new RoomOperate$RspReportLocation().mergeFrom((byte[]) obj);
                if (com.tencent.mobileqq.location.util.b.e(mergeFrom.msg_result.get())) {
                    int i3 = mergeFrom.req_interval.get();
                    if (i3 != 0) {
                        f241337g = i3 * 1000;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("ReportLocationHandler", 2, "requestReportLocationResp: invoked. ", " intervalMillis: ", Integer.valueOf(f241337g));
                        return;
                    }
                    return;
                }
                q();
                return;
            } catch (Exception e16) {
                QLog.e("ReportLocationHandler", 1, "requestReportLocationResp: failed. ", e16);
                return;
            }
        }
        if (fromServiceMsg != null) {
            int resultCode = fromServiceMsg.getResultCode();
            if (QLog.isColorLevel()) {
                QLog.d("ReportLocationHandler", 2, "requestReportLocationResp: invoked. ", " resultCode: ", Integer.valueOf(resultCode));
            }
        }
        q();
    }

    public boolean t(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) str, i3)).booleanValue();
        }
        if (!TextUtils.isEmpty(o()) && o().equals(str) && p() == i3) {
            return true;
        }
        return false;
    }

    public void u(String str, int i3, a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, Integer.valueOf(i3), aVar);
            return;
        }
        this.f241343f = aVar;
        if (!this.f241339b.get()) {
            if (QLog.isColorLevel()) {
                QLog.d("ReportLocationHandler", 2, "startReportInLoop: invoked. still in loop, no need re-request ", " sessionUin: ", str);
            }
        } else {
            this.f241339b.set(false);
            Runnable runnable = new Runnable(i3, str) { // from class: com.tencent.mobileqq.location.net.ReportLocationHandler.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ int f241344d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ String f241345e;

                {
                    this.f241344d = i3;
                    this.f241345e = str;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, ReportLocationHandler.this, Integer.valueOf(i3), str);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    QLog.isColorLevel();
                    if (ReportLocationHandler.this.f241343f != null && ReportLocationHandler.this.f241343f.getLocation() != null) {
                        ReportLocationHandler.this.f241341d = this.f241344d;
                        ReportLocationHandler.this.f241342e = Long.valueOf(Long.parseLong(this.f241345e));
                        com.tencent.mobileqq.location.data.a location = ReportLocationHandler.this.f241343f.getLocation();
                        if (QLog.isColorLevel()) {
                            QLog.d("ReportLocationHandler", 2, "report run: invoked. ", "uinType = [" + ReportLocationHandler.this.f241341d + "], sessionUin = [" + ReportLocationHandler.this.f241342e + "], locationItem = [" + location + "]");
                        }
                        if (ReportLocationHandler.this.f241339b.get()) {
                            if (QLog.isColorLevel()) {
                                QLog.d("ReportLocationHandler", 2, "report run: invoked. stop old heartbeat ", " uinType: ", Integer.valueOf(ReportLocationHandler.this.f241341d), " sessionUin: ", ReportLocationHandler.this.f241342e, " locationItem: ", location);
                                return;
                            }
                            return;
                        }
                        ReportLocationHandler reportLocationHandler = ReportLocationHandler.this;
                        reportLocationHandler.r(reportLocationHandler.f241341d, ReportLocationHandler.this.f241342e.longValue(), location);
                    } else if (QLog.isColorLevel()) {
                        QLog.d("ReportLocationHandler", 2, "report run: invoked. ", " check null: mLocationCallback: ", ReportLocationHandler.this.f241343f);
                    }
                    ReportLocationHandler.this.f241338a.postDelayed(this, ReportLocationHandler.f241337g);
                }
            };
            this.f241340c = runnable;
            this.f241338a.post(runnable);
        }
    }

    private void q() {
    }
}
