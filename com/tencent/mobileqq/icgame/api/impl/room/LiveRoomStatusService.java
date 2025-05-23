package com.tencent.mobileqq.icgame.api.impl.room;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.icgame.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.data.message.LiveMsgExtInfo;
import com.tencent.mobileqq.qqlive.data.room.QQLiveRoomStatusInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes15.dex */
class LiveRoomStatusService {
    private static final String TAG = "ICGameAudienceRoomStatusModule";
    private final CopyOnWriteArrayList<b32.e> roomInfoListeners = new CopyOnWriteArrayList<>();
    private t32.b statusReceiver;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ba A[LOOP:3: B:35:0x00b4->B:37:0x00ba, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void parseData(@NonNull xy0.a aVar) {
        String str;
        Iterator<b32.e> it;
        byte[] bArr;
        QQLiveRoomStatusInfo qQLiveRoomStatusInfo = new QQLiveRoomStatusInfo();
        qQLiveRoomStatusInfo.uin = aVar.f449027a;
        qQLiveRoomStatusInfo.roomID = aVar.f449028b;
        QLog.i(TAG, 1, "rec 0x4b room: " + aVar.f449028b + " uin: " + aVar.f449027a + " type: " + aVar.f449030d);
        int i3 = aVar.f449030d;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        Iterator<b32.e> it5 = this.roomInfoListeners.iterator();
                        while (it5.hasNext()) {
                            it5.next().onRoomResume(qQLiveRoomStatusInfo);
                        }
                        return;
                    }
                    return;
                }
                Iterator<b32.e> it6 = this.roomInfoListeners.iterator();
                while (it6.hasNext()) {
                    it6.next().onRoomPause(qQLiveRoomStatusInfo);
                }
                return;
            }
            Iterator<b32.e> it7 = this.roomInfoListeners.iterator();
            while (it7.hasNext()) {
                it7.next().onRoomOpen(qQLiveRoomStatusInfo);
            }
            return;
        }
        if (aVar.f449034h == 10 && (bArr = aVar.f449035i) != null) {
            try {
                str = new String(bArr);
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "closeReason parse error", th5);
            }
            qQLiveRoomStatusInfo.closeType = aVar.f449034h;
            qQLiveRoomStatusInfo.closeReason = str;
            it = this.roomInfoListeners.iterator();
            while (it.hasNext()) {
                it.next().onRoomClose(qQLiveRoomStatusInfo);
            }
        }
        str = "";
        qQLiveRoomStatusInfo.closeType = aVar.f449034h;
        qQLiveRoomStatusInfo.closeReason = str;
        it = this.roomInfoListeners.iterator();
        while (it.hasNext()) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void destroy() {
        t32.b bVar = this.statusReceiver;
        if (bVar != null) {
            bVar.a();
        }
        this.roomInfoListeners.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void init(IQQLiveSDK iQQLiveSDK) {
        t32.b b16 = ((t32.a) iQQLiveSDK.getExtModule("roomPush")).b();
        this.statusReceiver = b16;
        b16.b(75, new ni2.a() { // from class: com.tencent.mobileqq.icgame.api.impl.room.LiveRoomStatusService.1
            @Override // ni2.a
            public void onRecv(int i3, byte[] bArr, LiveMsgExtInfo liveMsgExtInfo) {
                try {
                    byte[] e16 = t42.a.e(new ByteArrayInputStream(bArr), true);
                    if (e16 != null && e16.length != 0) {
                        LiveRoomStatusService.this.parseData(xy0.a.c(e16));
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
    public void registerRoomInfoListener(b32.e eVar) {
        if (!this.roomInfoListeners.contains(eVar)) {
            this.roomInfoListeners.add(eVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() {
        t32.b bVar = this.statusReceiver;
        if (bVar != null) {
            bVar.a();
        }
        this.roomInfoListeners.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void unRegisterRoomInfoListener(b32.e eVar) {
        this.roomInfoListeners.remove(eVar);
    }
}
