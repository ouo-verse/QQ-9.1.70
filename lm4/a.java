package lm4;

import com.tencent.timi.game.room.impl.YoloRoomManager;
import fm4.o;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomAction;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a extends com.tencent.timi.game.room.impl.a {
    public a(YoloRoomManager yoloRoomManager, o oVar) {
        super(yoloRoomManager, oVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.timi.game.room.impl.a
    public boolean a(int i3, YoloRoomOuterClass$YoloRoomAction yoloRoomOuterClass$YoloRoomAction) {
        if (i3 == 201 || i3 == 203 || i3 == 250 || i3 == 252) {
            return true;
        }
        return false;
    }
}
