package o05;

import androidx.annotation.NonNull;
import cooperation.ilive.pb.LiveGroupTips$GetLiveGroupTipsRsp;

/* compiled from: P */
/* loaded from: classes28.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public long f421705a;

    /* renamed from: b, reason: collision with root package name */
    public String f421706b;

    /* renamed from: c, reason: collision with root package name */
    public String f421707c;

    /* renamed from: d, reason: collision with root package name */
    public String f421708d;

    /* renamed from: e, reason: collision with root package name */
    public String f421709e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f421710f;

    /* renamed from: g, reason: collision with root package name */
    public int f421711g;

    /* renamed from: h, reason: collision with root package name */
    public long f421712h;

    /* renamed from: i, reason: collision with root package name */
    public long f421713i;

    public static a a(LiveGroupTips$GetLiveGroupTipsRsp liveGroupTips$GetLiveGroupTipsRsp) {
        if (liveGroupTips$GetLiveGroupTipsRsp == null) {
            return null;
        }
        a aVar = new a();
        if (!liveGroupTips$GetLiveGroupTipsRsp.room_id.has()) {
            return null;
        }
        aVar.f421705a = liveGroupTips$GetLiveGroupTipsRsp.room_id.get();
        if (liveGroupTips$GetLiveGroupTipsRsp.room_title.has()) {
            aVar.f421706b = liveGroupTips$GetLiveGroupTipsRsp.room_title.get();
        }
        if (liveGroupTips$GetLiveGroupTipsRsp.room_icon.has()) {
            aVar.f421707c = liveGroupTips$GetLiveGroupTipsRsp.room_icon.get();
        }
        if (liveGroupTips$GetLiveGroupTipsRsp.room_viewer.has()) {
            aVar.f421712h = liveGroupTips$GetLiveGroupTipsRsp.room_viewer.get();
        }
        if (liveGroupTips$GetLiveGroupTipsRsp.viewer_text.has()) {
            aVar.f421708d = liveGroupTips$GetLiveGroupTipsRsp.viewer_text.get();
        }
        if (liveGroupTips$GetLiveGroupTipsRsp.puin.has()) {
            aVar.f421713i = liveGroupTips$GetLiveGroupTipsRsp.puin.get();
        }
        if (liveGroupTips$GetLiveGroupTipsRsp.room_schema.has()) {
            aVar.f421709e = liveGroupTips$GetLiveGroupTipsRsp.room_schema.get();
        }
        if (liveGroupTips$GetLiveGroupTipsRsp.is_living.has()) {
            boolean z16 = true;
            if (liveGroupTips$GetLiveGroupTipsRsp.is_living.get() != 1) {
                z16 = false;
            }
            aVar.f421710f = z16;
        }
        if (liveGroupTips$GetLiveGroupTipsRsp.interval.has()) {
            aVar.f421711g = liveGroupTips$GetLiveGroupTipsRsp.interval.get();
        }
        return aVar;
    }

    @NonNull
    public String toString() {
        return "mRoomId = " + this.f421705a + " mRoomTitle = " + this.f421706b + " mRoomSubTitle = " + this.f421708d + " mIsLiving = " + this.f421710f + " mPollTime = " + this.f421711g + " mViewNum = " + this.f421712h + " puin = " + this.f421713i;
    }
}
