package com.tencent.mobileqq.location.net;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.location.data.LocationRoom;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tencent.im.oidb.location.RoomOperate$ReqRoomQuery;
import tencent.im.oidb.location.RoomOperate$RspRoomQuery;
import tencent.im.oidb.location.RoomOperate$UserData;

/* compiled from: P */
/* loaded from: classes15.dex */
public class RoomQueryHandler extends a<LocationHandler> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final Handler f241346a;

    /* renamed from: b, reason: collision with root package name */
    private long f241347b;

    /* renamed from: c, reason: collision with root package name */
    private final AtomicBoolean f241348c;

    /* renamed from: d, reason: collision with root package name */
    private final AtomicInteger f241349d;

    /* renamed from: e, reason: collision with root package name */
    private Runnable f241350e;

    public RoomQueryHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f241348c = new AtomicBoolean(true);
        this.f241349d = new AtomicInteger(0);
        this.f241346a = new Handler(ThreadManagerV2.getSubThreadLooper());
    }

    private void g() {
        f().notifyUI(2, false, null);
    }

    private void h(int i3, long j3, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("RoomQueryHandler", 2, "[queryLocationRoom] requestQueryRoom: invoked. ", " uinType: ", Integer.valueOf(i3), " sessionUin: ", Long.valueOf(j3), " noLimitReq: ", Boolean.valueOf(z16));
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f241347b < this.f241349d.get() * 1000 && !z16) {
            QLog.d("RoomQueryHandler", 1, "[queryLocationRoom] requestQueryRoomNoLimit: invoked. frequency limited", " requestIntervalSecond: ", this.f241349d);
            return;
        }
        this.f241347b = currentTimeMillis;
        RoomOperate$ReqRoomQuery roomOperate$ReqRoomQuery = new RoomOperate$ReqRoomQuery();
        roomOperate$ReqRoomQuery.no_limit.set(z16);
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        roomOperate$ReqRoomQuery.room_key.set(com.tencent.mobileqq.location.util.b.a(waitAppRuntime, i3, j3));
        roomOperate$ReqRoomQuery.room_key.setHasFlag(true);
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", waitAppRuntime.getAccount(), "QQLBSShareSvc.room_query");
        toServiceMsg.extraData.putInt("uintype", i3);
        toServiceMsg.extraData.putString("uin", String.valueOf(j3));
        toServiceMsg.putWupBuffer(roomOperate$ReqRoomQuery.toByteArray());
        f().sendPbReq(toServiceMsg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i3, String str) {
        long j3;
        try {
            j3 = Long.parseLong(str);
        } catch (NumberFormatException e16) {
            QLog.e("RoomQueryHandler", 1, "[queryLocationRoom] requestQueryRoom: failed. ", e16);
            j3 = 0;
        }
        h(i3, j3, false);
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            m();
        }
    }

    protected LocationHandler f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (LocationHandler) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return LocationHandler.K2();
    }

    public void i(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3, (Object) str);
            return;
        }
        if (!this.f241348c.get()) {
            if (QLog.isColorLevel()) {
                QLog.d("RoomQueryHandler", 2, "[queryLocationRoom] requestQueryRoomInLoop: invoked. still in loop, no need re-request ", " sessionUin: ", str);
            }
        } else {
            this.f241348c.set(false);
            Runnable runnable = new Runnable(i3, str) { // from class: com.tencent.mobileqq.location.net.RoomQueryHandler.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ int f241351d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ String f241352e;

                {
                    this.f241351d = i3;
                    this.f241352e = str;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, RoomQueryHandler.this, Integer.valueOf(i3), str);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else if (!RoomQueryHandler.this.f241348c.get()) {
                        RoomQueryHandler.this.j(this.f241351d, this.f241352e);
                        RoomQueryHandler.this.f241346a.postDelayed(this, 5000L);
                    } else {
                        QLog.d("RoomQueryHandler", 1, "run: invoked. stop old loop query ", " uinType: ", Integer.valueOf(this.f241351d), " sessionUin: ", this.f241352e);
                    }
                }
            };
            this.f241350e = runnable;
            this.f241346a.post(runnable);
        }
    }

    public void k(int i3, String str) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) str);
            return;
        }
        try {
            j3 = Long.parseLong(str);
        } catch (NumberFormatException e16) {
            QLog.e("RoomQueryHandler", 1, "[queryLocationRoom] requestQueryRoom: failed. ", e16);
            j3 = 0;
        }
        LocationHandler.K2().R2(i3, str);
        h(i3, j3, true);
    }

    public void l(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (a(toServiceMsg, fromServiceMsg, obj)) {
            try {
                RoomOperate$RspRoomQuery mergeFrom = new RoomOperate$RspRoomQuery().mergeFrom((byte[]) obj);
                int i3 = mergeFrom.room_state.get();
                if (QLog.isColorLevel()) {
                    List<RoomOperate$UserData> list = mergeFrom.user_list.get();
                    ArrayList arrayList = new ArrayList();
                    Iterator<RoomOperate$UserData> it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(Long.valueOf(it.next().uin.get()));
                    }
                    QLog.d("RoomQueryHandler", 2, "[queryLocationRoom] requestQueryRoomResp: invoked. ", " roomState: ", Integer.valueOf(i3), " OPEN = 1; //\u5f00\u542f\u4e2d CLOSED = 2; //\u5df2\u5173\u95ed \n users: ", arrayList);
                }
                if (com.tencent.mobileqq.location.util.b.e(mergeFrom.msg_result.get())) {
                    this.f241349d.set(mergeFrom.req_interval.get());
                    int i16 = toServiceMsg.extraData.getInt("uintype", -1);
                    String string = toServiceMsg.extraData.getString("uin");
                    if (i3 == 2) {
                        m();
                        LocationHandler.K2().O2(new LocationRoom.b(i16, string), -1);
                        com.tencent.mobileqq.location.util.b.f(MobileQQ.sMobileQQ.waitAppRuntime(null), i16, string, false);
                    }
                    f().notifyUI(2, true, new Object[]{mergeFrom, Integer.valueOf(i16), string});
                    return;
                }
                g();
                return;
            } catch (Exception e16) {
                QLog.e("RoomQueryHandler", 1, "[queryLocationRoom] requestQueryRoomResp: failed. ", e16);
                return;
            }
        }
        if (fromServiceMsg != null) {
            int resultCode = fromServiceMsg.getResultCode();
            if (QLog.isColorLevel()) {
                QLog.d("RoomQueryHandler", 2, "[queryLocationRoom] requestQueryRoomResp: invoked. ", " resultCode: ", Integer.valueOf(resultCode));
            }
        }
        g();
    }

    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("RoomQueryHandler", 2, "[queryLocationRoom] stopRequestQueryRoomInLoop: invoked. ", " loopQueryStopped: ", this.f241348c);
        }
        this.f241348c.set(true);
        this.f241346a.removeCallbacks(this.f241350e);
    }
}
