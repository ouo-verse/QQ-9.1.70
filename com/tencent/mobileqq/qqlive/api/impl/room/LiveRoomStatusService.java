package com.tencent.mobileqq.qqlive.api.impl.room;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.callback.room.audience.LiveRoomStatusListener;
import com.tencent.mobileqq.qqlive.data.message.LiveMsgExtInfo;
import com.tencent.mobileqq.qqlive.data.room.QQLiveRoomStatusInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes17.dex */
public class LiveRoomStatusService {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "AudienceRoomStatusModule";
    private final CopyOnWriteArrayList<LiveRoomStatusListener> roomInfoListeners;
    private ni2.c statusReceiver;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LiveRoomStatusService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.roomInfoListeners = new CopyOnWriteArrayList<>();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ba A[LOOP:3: B:35:0x00b4->B:37:0x00ba, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void parseData(@NonNull qt3.a aVar) {
        String str;
        Iterator<LiveRoomStatusListener> it;
        byte[] bArr;
        QQLiveRoomStatusInfo qQLiveRoomStatusInfo = new QQLiveRoomStatusInfo();
        qQLiveRoomStatusInfo.uin = aVar.f429493a;
        qQLiveRoomStatusInfo.roomID = aVar.f429494b;
        QLog.i(TAG, 1, "rec 0x4b room: " + aVar.f429494b + " uin: " + aVar.f429493a + " type: " + aVar.f429496d);
        int i3 = aVar.f429496d;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        Iterator<LiveRoomStatusListener> it5 = this.roomInfoListeners.iterator();
                        while (it5.hasNext()) {
                            it5.next().onRoomResume(qQLiveRoomStatusInfo);
                        }
                        return;
                    }
                    return;
                }
                Iterator<LiveRoomStatusListener> it6 = this.roomInfoListeners.iterator();
                while (it6.hasNext()) {
                    it6.next().onRoomPause(qQLiveRoomStatusInfo);
                }
                return;
            }
            Iterator<LiveRoomStatusListener> it7 = this.roomInfoListeners.iterator();
            while (it7.hasNext()) {
                it7.next().onRoomOpen(qQLiveRoomStatusInfo);
            }
            return;
        }
        if (aVar.f429500h == 10 && (bArr = aVar.f429501i) != null) {
            try {
                str = new String(bArr);
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "closeReason parse error", th5);
            }
            qQLiveRoomStatusInfo.closeType = aVar.f429500h;
            qQLiveRoomStatusInfo.closeReason = str;
            it = this.roomInfoListeners.iterator();
            while (it.hasNext()) {
                it.next().onRoomClose(qQLiveRoomStatusInfo);
            }
        }
        str = "";
        qQLiveRoomStatusInfo.closeType = aVar.f429500h;
        qQLiveRoomStatusInfo.closeReason = str;
        it = this.roomInfoListeners.iterator();
        while (it.hasNext()) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void destroy() {
        ni2.c cVar = this.statusReceiver;
        if (cVar != null) {
            cVar.a();
        }
        this.roomInfoListeners.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void init(IQQLiveSDK iQQLiveSDK) {
        ni2.c b16 = ((ni2.b) iQQLiveSDK.getExtModule("roomPush")).b();
        this.statusReceiver = b16;
        b16.b(75, new ni2.a() { // from class: com.tencent.mobileqq.qqlive.api.impl.room.LiveRoomStatusService.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) LiveRoomStatusService.this);
                }
            }

            @Override // ni2.a
            public void onRecv(int i3, byte[] bArr, LiveMsgExtInfo liveMsgExtInfo) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), bArr, liveMsgExtInfo);
                    return;
                }
                try {
                    byte[] e16 = com.tencent.mobileqq.qqlive.utils.b.e(new ByteArrayInputStream(bArr), true);
                    if (e16 != null && e16.length != 0) {
                        LiveRoomStatusService.this.parseData(qt3.a.c(e16));
                        return;
                    }
                    QLog.e(LiveRoomStatusService.TAG, 1, "onRecv status error data == null");
                } catch (Exception e17) {
                    QLog.e(LiveRoomStatusService.TAG, 1, "onRecv status error " + e17.getMessage());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void registerRoomInfoListener(LiveRoomStatusListener liveRoomStatusListener) {
        if (!this.roomInfoListeners.contains(liveRoomStatusListener)) {
            this.roomInfoListeners.add(liveRoomStatusListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() {
        ni2.c cVar = this.statusReceiver;
        if (cVar != null) {
            cVar.a();
        }
        this.roomInfoListeners.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void unRegisterRoomInfoListener(LiveRoomStatusListener liveRoomStatusListener) {
        this.roomInfoListeners.remove(liveRoomStatusListener);
    }
}
