package hynb.a;

import android.text.TextUtils;
import com.huya.huyasdk.api.HuyaLiveBarrageReceiveInfo;
import com.huya.huyasdk.api.HuyaLiveBarrageSendInfo;
import com.huya.huyasdk.api.HuyaLiveBarrageSendResult;
import com.huya.huyasdk.api.LiveBarrageCallback;
import com.huya.huyasdk.api.SendLiveBarrageCallback;
import com.huya.huyasdk.data.HYNSRequest;
import com.huya.huyasdk.data.RegisterResultInfo;
import com.huya.huyasdk.jce.OpenMessageNotice;
import com.huya.huyasdk.jce.OpenSendMessageReq;
import com.huya.huyasdk.jce.OpenSendMessageRsp;
import com.huya.huyasdk.service.api.ILiveRoomEventService;
import com.huya.huyasdk.service.api.ILoginService;
import hynb.b.g;
import hynb.b.h;
import hynb.b.i;
import hynb.b.l;
import hynb.j.d;
import hynb.o.e;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes28.dex */
public class a {

    /* renamed from: d, reason: collision with root package name */
    public static a f406608d = new a();

    /* renamed from: a, reason: collision with root package name */
    public LiveBarrageCallback f406609a = null;

    /* renamed from: b, reason: collision with root package name */
    public final Set<Long> f406610b = new HashSet();

    /* renamed from: c, reason: collision with root package name */
    public final hynb.g.a f406611c = new hynb.g.a() { // from class: o15.a
        @Override // hynb.g.a
        public final void a(int i3, Object obj) {
            hynb.a.a.this.a(i3, obj);
        }
    };

    /* compiled from: P */
    /* renamed from: hynb.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes28.dex */
    public class C10481a implements g {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f406612a;

        public C10481a(long j3) {
            this.f406612a = j3;
        }

        @Override // hynb.b.g
        public void a(RegisterResultInfo registerResultInfo) {
            hynb.p.g.f406799a.info("HuyaBarrageImpl", "register group success");
            if (!a.this.f406610b.contains(Long.valueOf(this.f406612a))) {
                return;
            }
            hynb.g.b.f406712m.a(1402, OpenMessageNotice.class);
            hynb.g.b.f406712m.a(a.this.f406611c);
            hynb.g.b.f406712m.b("HuyaBarrageImpl");
        }

        @Override // hynb.b.g
        public void b(RegisterResultInfo registerResultInfo) {
            hynb.p.g.f406799a.info("HuyaBarrageImpl", "register group failed");
            a.this.f406610b.remove(Long.valueOf(this.f406612a));
        }
    }

    public static List<String> c(long j3) {
        ArrayList arrayList = new ArrayList();
        if (hynb.n.a.a().f406767a.f406780m) {
            arrayList.add("open_chat_hy:" + j3);
            arrayList.add(String.format("%s%s:%s", "open_chat_", hynb.n.a.a().f406767a.f406781n, Long.valueOf(j3)));
        } else {
            arrayList.add("open_chat:" + j3);
        }
        return arrayList;
    }

    public synchronized void b(long j3) {
        if (!this.f406610b.add(Long.valueOf(j3))) {
            hynb.p.g.f406799a.c("HuyaBarrageImpl", "pid: %s, push already enabled", Long.valueOf(j3));
            return;
        }
        hynb.p.g.f406799a.a("HuyaBarrageImpl", "enablePush, register group for " + j3);
        hynb.g.b.f406712m.a("HuyaBarrageImpl", new ArrayList(c(j3)), new C10481a(j3));
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class b implements h<OpenSendMessageRsp> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SendLiveBarrageCallback f406614a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f406615b;

        public b(a aVar, SendLiveBarrageCallback sendLiveBarrageCallback, long j3) {
            this.f406614a = sendLiveBarrageCallback;
            this.f406615b = j3;
        }

        @Override // hynb.b.h
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(OpenSendMessageRsp openSendMessageRsp) {
            if (openSendMessageRsp == null) {
                return;
            }
            hynb.p.g.f406799a.a("HuyaBarrageImpl", "sendBarrage response, message: " + openSendMessageRsp.sMessage);
            SendLiveBarrageCallback sendLiveBarrageCallback = this.f406614a;
            if (sendLiveBarrageCallback != null) {
                sendLiveBarrageCallback.onLiveBarrageSend(new HuyaLiveBarrageSendResult(this.f406615b, true, 0));
            }
        }

        @Override // hynb.b.h
        public Class<OpenSendMessageRsp> getResponseClass() {
            return OpenSendMessageRsp.class;
        }

        @Override // hynb.b.h
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onError(int i3, String str, OpenSendMessageRsp openSendMessageRsp) {
            hynb.p.g.f406799a.c("HuyaBarrageImpl", "sendBarrage onError, retValue: %s, errMsg: %s, rsp: %s", Integer.valueOf(i3), str, openSendMessageRsp);
            SendLiveBarrageCallback sendLiveBarrageCallback = this.f406614a;
            if (sendLiveBarrageCallback != null) {
                sendLiveBarrageCallback.onLiveBarrageSend(new HuyaLiveBarrageSendResult(this.f406615b, false, -4));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(int i3, Object obj) {
        if (i3 == 1402) {
            OpenMessageNotice openMessageNotice = (OpenMessageNotice) obj;
            hynb.p.g.f406799a.a("HuyaBarrageImpl", "onEvent, OpenMessageNotice: " + openMessageNotice);
            b(openMessageNotice);
        }
    }

    public void a(LiveBarrageCallback liveBarrageCallback) {
        this.f406609a = liveBarrageCallback;
    }

    public synchronized void a(long j3) {
        if (!this.f406610b.remove(Long.valueOf(j3))) {
            hynb.p.g.f406799a.info("HuyaBarrageImpl", "push already disabled");
            return;
        }
        hynb.p.g.f406799a.a("HuyaBarrageImpl", "disablePush, unregister group for " + j3);
        hynb.g.b.f406712m.a("HuyaBarrageImpl", new ArrayList(c(j3)), (i) null);
        hynb.g.b.f406712m.a(1402);
        hynb.g.b.f406712m.b(this.f406611c);
        hynb.g.b.f406712m.a("HuyaBarrageImpl");
    }

    public final void b(OpenMessageNotice openMessageNotice) {
        String str;
        if (openMessageNotice == null) {
            hynb.p.g.f406799a.error("HuyaBarrageImpl", "onReceiveBarrage: notice is null");
            return;
        }
        if (this.f406609a != null) {
            if (!a(openMessageNotice)) {
                hynb.p.g.f406799a.a("HuyaBarrageImpl", "onReceiveBarrage illegal message, HuyaLiveRoom.mPresenterId:" + ((ILiveRoomEventService) d.a(ILiveRoomEventService.class)).getCurrentPid() + ", notice.lPresenterUid = " + openMessageNotice.lPresenterUid);
                return;
            }
            String str2 = openMessageNotice.sContent;
            if (str2 != null && (str = openMessageNotice.sSenderNick) != null) {
                HuyaLiveBarrageReceiveInfo huyaLiveBarrageReceiveInfo = new HuyaLiveBarrageReceiveInfo(openMessageNotice.lPresenterUid, openMessageNotice.lSenderUid, str, str2, openMessageNotice.sOpenAppName);
                hynb.p.g.f406799a.a("HuyaBarrageImpl", "onReceiveBarrage callback: " + huyaLiveBarrageReceiveInfo);
                this.f406609a.onLiveBarrageReceive(huyaLiveBarrageReceiveInfo);
                return;
            }
            hynb.p.g.f406799a.error("HuyaBarrageImpl", "onReceiveBarrage: content or senderNick is null, notice: " + openMessageNotice);
            return;
        }
        hynb.p.g.f406799a.error("HuyaBarrageImpl", "onReceiveBarrage: mCallback is null, notice: " + openMessageNotice);
    }

    public void a(HuyaLiveBarrageSendInfo huyaLiveBarrageSendInfo, SendLiveBarrageCallback sendLiveBarrageCallback) {
        long currentPid = ((ILiveRoomEventService) d.a(ILiveRoomEventService.class)).getCurrentPid();
        if (!((ILiveRoomEventService) d.a(ILiveRoomEventService.class)).inLiveRoom()) {
            hynb.p.g.f406799a.info("HuyaBarrageImpl", "sendBarrage fail not in live room");
            if (sendLiveBarrageCallback != null) {
                sendLiveBarrageCallback.onLiveBarrageSend(new HuyaLiveBarrageSendResult(0L, false, -2));
                return;
            }
            return;
        }
        if (!((ILoginService) d.a(ILoginService.class)).isLogin()) {
            hynb.p.g.f406799a.info("HuyaBarrageImpl", "sendBarrage fail not login");
            if (sendLiveBarrageCallback != null) {
                sendLiveBarrageCallback.onLiveBarrageSend(new HuyaLiveBarrageSendResult(currentPid, false, -3));
                return;
            }
            return;
        }
        if (huyaLiveBarrageSendInfo != null) {
            String str = huyaLiveBarrageSendInfo.content;
            if (!TextUtils.isEmpty(str == null ? "" : str.trim())) {
                String str2 = huyaLiveBarrageSendInfo.senderNick;
                if (!TextUtils.isEmpty(str2 != null ? str2.trim() : "")) {
                    hynb.p.g.f406799a.info("HuyaBarrageImpl", "sendBarrage start content: " + huyaLiveBarrageSendInfo.content);
                    OpenSendMessageReq openSendMessageReq = new OpenSendMessageReq();
                    openSendMessageReq.tId = e.a(l.i().m());
                    openSendMessageReq.sOpenAppId = hynb.n.a.a().f406767a.f406774g;
                    openSendMessageReq.lPresenterUid = currentPid;
                    openSendMessageReq.sContent = huyaLiveBarrageSendInfo.content;
                    openSendMessageReq.sNick = huyaLiveBarrageSendInfo.senderNick;
                    l.i().b(new HYNSRequest.Builder().sServantName("wupui").sFuncName("openSendMessage").jsonBodyObj(openSendMessageReq).build(), new b(this, sendLiveBarrageCallback, currentPid));
                    return;
                }
            }
        }
        hynb.p.g.f406799a.info("HuyaBarrageImpl", "sendBarrage fail content is blank");
        sendLiveBarrageCallback.onLiveBarrageSend(new HuyaLiveBarrageSendResult(currentPid, false, -1));
    }

    public final boolean a(OpenMessageNotice openMessageNotice) {
        long currentPid = ((ILiveRoomEventService) d.a(ILiveRoomEventService.class)).getCurrentPid();
        return currentPid != 0 && openMessageNotice.lPresenterUid == currentPid;
    }
}
