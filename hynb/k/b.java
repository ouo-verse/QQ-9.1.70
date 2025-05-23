package hynb.k;

import com.huya.huyasdk.api.HuyaLiveJoinCallback;
import com.huya.huyasdk.api.HuyaLiveJoinConfig;
import com.huya.huyasdk.api.HuyaLiveJoinResult;
import com.huya.huyasdk.api.LiveRoomEventCallback;
import com.huya.huyasdk.service.api.ILiveRoomEventService;

/* compiled from: P */
/* loaded from: classes28.dex */
public class b extends hynb.j.a implements ILiveRoomEventService {

    /* renamed from: a, reason: collision with root package name */
    public long f406744a = 0;

    /* renamed from: b, reason: collision with root package name */
    public boolean f406745b = false;

    @Override // com.huya.huyasdk.service.api.ILiveRoomEventService
    public void enterLiveRoom(HuyaLiveJoinConfig huyaLiveJoinConfig, HuyaLiveJoinCallback huyaLiveJoinCallback) {
        long j3;
        if (huyaLiveJoinConfig != null) {
            j3 = huyaLiveJoinConfig.presenterUid;
        } else {
            j3 = 0;
        }
        this.f406744a = j3;
        this.f406745b = true;
        if (huyaLiveJoinCallback != null) {
            huyaLiveJoinCallback.onJoinResult(new HuyaLiveJoinResult(j3, true, 0));
        }
    }

    @Override // com.huya.huyasdk.service.api.ILiveRoomEventService
    public long getCurrentPid() {
        return this.f406744a;
    }

    @Override // com.huya.huyasdk.service.api.ILiveRoomEventService
    public boolean inLiveRoom() {
        return this.f406745b;
    }

    @Override // com.huya.huyasdk.service.api.ILiveRoomEventService
    public long quitLiveRoom() {
        long j3 = this.f406744a;
        this.f406744a = 0L;
        this.f406745b = false;
        return j3;
    }

    @Override // com.huya.huyasdk.service.api.ILiveRoomEventService
    public void registerLiveEvent(LiveRoomEventCallback liveRoomEventCallback) {
    }
}
