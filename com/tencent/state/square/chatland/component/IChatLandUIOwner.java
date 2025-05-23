package com.tencent.state.square.chatland.component;

import android.util.Size;
import android.view.View;
import com.tencent.state.publicchat.IPublicChatUIOwner;
import com.tencent.state.publicchat.action.MsgAction;
import com.tencent.state.publicchat.data.Scene;
import com.tencent.state.template.data.RoomThemeData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\n\u0010\t\u001a\u0004\u0018\u00010\nH&J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/state/square/chatland/component/IChatLandUIOwner;", "Lcom/tencent/state/publicchat/IPublicChatUIOwner;", "onAddBackgroundViewToMap", "", "view", "Landroid/view/View;", "onAddViewToMap", "onAddViewToParentFragment", "onAddViewToScreen", "onGetMapSize", "Landroid/util/Size;", "onOpenAIO", "uin", "", "nickname", "onRemoveViewFromScreen", "removeViewFromMap", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public interface IChatLandUIOwner extends IPublicChatUIOwner {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class DefaultImpls {
        public static long getRoomId(IChatLandUIOwner iChatLandUIOwner) {
            return IPublicChatUIOwner.DefaultImpls.getRoomId(iChatLandUIOwner);
        }

        public static RoomThemeData getRoomThemeData(IChatLandUIOwner iChatLandUIOwner) {
            return IPublicChatUIOwner.DefaultImpls.getRoomThemeData(iChatLandUIOwner);
        }

        public static Scene getScene(IChatLandUIOwner iChatLandUIOwner) {
            return IPublicChatUIOwner.DefaultImpls.getScene(iChatLandUIOwner);
        }

        public static void onMsgAction(IChatLandUIOwner iChatLandUIOwner, MsgAction action) {
            Intrinsics.checkNotNullParameter(action, "action");
            IPublicChatUIOwner.DefaultImpls.onMsgAction(iChatLandUIOwner, action);
        }
    }

    void onAddBackgroundViewToMap(View view);

    void onAddViewToMap(View view);

    void onAddViewToParentFragment(View view);

    void onAddViewToScreen(View view);

    Size onGetMapSize();

    void onOpenAIO(String uin, String nickname);

    void onRemoveViewFromScreen(View view);

    void removeViewFromMap(View view);
}
