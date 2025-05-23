package jm4;

import com.tencent.timi.game.tgpa.TGPAUtil;
import mqq.app.NewIntent;
import pl4.a;
import trpc.yes.common.YoloRoomOuterClass$YoloCommunityRoomParams;
import trpc.yes.common.YoloRoomOuterClass$YoloGameRoomParams;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomCreateReq;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomParams;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomTgpaData;

/* compiled from: P */
/* loaded from: classes26.dex */
public class b extends pl4.a {
    public static NewIntent d(YoloRoomOuterClass$YoloRoomParams yoloRoomOuterClass$YoloRoomParams, YoloRoomOuterClass$YoloGameRoomParams yoloRoomOuterClass$YoloGameRoomParams, YoloRoomOuterClass$YoloCommunityRoomParams yoloRoomOuterClass$YoloCommunityRoomParams) {
        YoloRoomOuterClass$YoloRoomCreateReq yoloRoomOuterClass$YoloRoomCreateReq = new YoloRoomOuterClass$YoloRoomCreateReq();
        if (yoloRoomOuterClass$YoloRoomParams != null) {
            yoloRoomOuterClass$YoloRoomCreateReq.room_params.set(yoloRoomOuterClass$YoloRoomParams);
        }
        if (yoloRoomOuterClass$YoloGameRoomParams != null) {
            yoloRoomOuterClass$YoloRoomCreateReq.game_room_params.set(yoloRoomOuterClass$YoloGameRoomParams);
        }
        if (yoloRoomOuterClass$YoloCommunityRoomParams != null) {
            yoloRoomOuterClass$YoloRoomCreateReq.comm_room_params.set(yoloRoomOuterClass$YoloCommunityRoomParams);
        }
        yoloRoomOuterClass$YoloRoomCreateReq.tgpa_data_info.set(e());
        return a.C11028a.a(yoloRoomOuterClass$YoloRoomCreateReq, b.class);
    }

    public static YoloRoomOuterClass$YoloRoomTgpaData e() {
        String b16 = TGPAUtil.b();
        YoloRoomOuterClass$YoloRoomTgpaData yoloRoomOuterClass$YoloRoomTgpaData = new YoloRoomOuterClass$YoloRoomTgpaData();
        yoloRoomOuterClass$YoloRoomTgpaData.xid.set(b16);
        return yoloRoomOuterClass$YoloRoomTgpaData;
    }

    @Override // pl4.a
    protected int b() {
        return 920;
    }
}
