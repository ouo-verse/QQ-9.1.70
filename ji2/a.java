package ji2;

import com.tencent.mobileqq.qqlive.data.heart.FreeLove;
import com.tencent.mobileqq.qqlive.data.heart.QLBroadCastFreeLove;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes17.dex */
public interface a {
    void onReceiveFreeLove(long j3, ArrayList<FreeLove> arrayList, Boolean bool);

    void onReceiveRoomLikePush(QLBroadCastFreeLove qLBroadCastFreeLove);
}
