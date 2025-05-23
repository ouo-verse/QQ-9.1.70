package com.tencent.state.publicchat;

import com.tencent.state.publicchat.action.MsgAction;
import com.tencent.state.publicchat.data.PublicChatConfInfo;
import com.tencent.state.publicchat.data.Scene;
import com.tencent.state.template.data.RoomThemeData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/state/publicchat/IPublicChatOwner;", "", "getAppId", "", "getRoomId", "", "getRoomThemeData", "Lcom/tencent/state/template/data/RoomThemeData;", "getScene", "Lcom/tencent/state/publicchat/data/Scene;", "onConfigLoaded", "", "conf", "Lcom/tencent/state/publicchat/data/PublicChatConfInfo;", "onMsgAction", "action", "Lcom/tencent/state/publicchat/action/MsgAction;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public interface IPublicChatOwner {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class DefaultImpls {
        public static long getRoomId(IPublicChatOwner iPublicChatOwner) {
            return 0L;
        }

        public static RoomThemeData getRoomThemeData(IPublicChatOwner iPublicChatOwner) {
            return null;
        }

        public static Scene getScene(IPublicChatOwner iPublicChatOwner) {
            return Scene.INSTANCE.parse(Integer.valueOf(iPublicChatOwner.getAppId()));
        }

        public static void onMsgAction(IPublicChatOwner iPublicChatOwner, MsgAction action) {
            Intrinsics.checkNotNullParameter(action, "action");
        }
    }

    int getAppId();

    long getRoomId();

    RoomThemeData getRoomThemeData();

    Scene getScene();

    void onConfigLoaded(PublicChatConfInfo conf);

    void onMsgAction(MsgAction action);
}
