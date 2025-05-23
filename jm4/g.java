package jm4;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBInt32Field;
import mqq.app.NewIntent;
import pl4.a;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomEnterReq;

/* compiled from: P */
/* loaded from: classes26.dex */
public class g extends pl4.a {
    public static NewIntent d(com.tencent.timi.game.room.impl.util.d dVar) {
        int i3;
        YoloRoomOuterClass$YoloRoomEnterReq yoloRoomOuterClass$YoloRoomEnterReq = new YoloRoomOuterClass$YoloRoomEnterReq();
        yoloRoomOuterClass$YoloRoomEnterReq.room_id.set(dVar.f379324a);
        yoloRoomOuterClass$YoloRoomEnterReq.enter_from.set(dVar.f379325b);
        yoloRoomOuterClass$YoloRoomEnterReq.sub_enter_from.set(dVar.f379326c);
        PBInt32Field pBInt32Field = yoloRoomOuterClass$YoloRoomEnterReq.voice_switch;
        if (dVar.f379327d) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        pBInt32Field.set(i3);
        yoloRoomOuterClass$YoloRoomEnterReq.room_type.set(dVar.f379328e);
        fm4.c cVar = dVar.f379329f;
        if (cVar != null) {
            yoloRoomOuterClass$YoloRoomEnterReq.guild_id.set(cVar.f399871a);
            yoloRoomOuterClass$YoloRoomEnterReq.channel_id.set(dVar.f379329f.f399872b);
            yoloRoomOuterClass$YoloRoomEnterReq.channel_name.set(dVar.f379329f.f399873c);
        }
        long j3 = dVar.f379330g;
        if (j3 != 0) {
            yoloRoomOuterClass$YoloRoomEnterReq.from_room_id.set(j3);
        }
        long j16 = dVar.f379331h;
        if (j16 != 0) {
            yoloRoomOuterClass$YoloRoomEnterReq.live_uid.set(j16);
        }
        yoloRoomOuterClass$YoloRoomEnterReq.ignore_online_route.set(dVar.f379332i);
        yoloRoomOuterClass$YoloRoomEnterReq.tgpa_data_info.set(b.e());
        if (!TextUtils.isEmpty(dVar.f379333j)) {
            yoloRoomOuterClass$YoloRoomEnterReq.show_nick.set(dVar.f379333j);
        }
        if (!TextUtils.isEmpty(dVar.f379334k)) {
            yoloRoomOuterClass$YoloRoomEnterReq.channel_tinyid.set(dVar.f379334k);
        }
        return a.C11028a.a(yoloRoomOuterClass$YoloRoomEnterReq, g.class);
    }

    @Override // pl4.a
    protected int b() {
        return 921;
    }
}
