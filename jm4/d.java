package jm4;

import mqq.app.NewIntent;
import pl4.a;
import trpc.yes.common.RecommendProxyOuterClass$GetHallDiversionRecommendRoomReq;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomEnterReq;

/* compiled from: P */
/* loaded from: classes26.dex */
public class d extends pl4.a {
    public static NewIntent d(int i3, int i16, int i17, int i18) {
        YoloRoomOuterClass$YoloRoomEnterReq yoloRoomOuterClass$YoloRoomEnterReq = new YoloRoomOuterClass$YoloRoomEnterReq();
        yoloRoomOuterClass$YoloRoomEnterReq.enter_from.set(i16);
        yoloRoomOuterClass$YoloRoomEnterReq.voice_switch.set(i17);
        yoloRoomOuterClass$YoloRoomEnterReq.room_type.set(i18);
        yoloRoomOuterClass$YoloRoomEnterReq.tgpa_data_info.set(b.e());
        RecommendProxyOuterClass$GetHallDiversionRecommendRoomReq recommendProxyOuterClass$GetHallDiversionRecommendRoomReq = new RecommendProxyOuterClass$GetHallDiversionRecommendRoomReq();
        recommendProxyOuterClass$GetHallDiversionRecommendRoomReq.enter_room_req.set(yoloRoomOuterClass$YoloRoomEnterReq);
        recommendProxyOuterClass$GetHallDiversionRecommendRoomReq.game_id.set(i3);
        return a.C11028a.a(recommendProxyOuterClass$GetHallDiversionRecommendRoomReq, d.class);
    }

    @Override // pl4.a
    protected int b() {
        return 1101;
    }
}
