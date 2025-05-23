package com.tencent.state.square.chatland.component.share;

import com.tencent.state.square.components.fragment.SquareBaseComponent;
import com.tencent.state.template.data.EnterRoomInfo;
import com.tencent.state.template.data.User;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\u0004H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/state/square/chatland/component/share/ChatLandShareBaseComponent;", "Lcom/tencent/state/square/components/fragment/SquareBaseComponent;", "()V", "onEnterRoom", "", "info", "Lcom/tencent/state/template/data/EnterRoomInfo;", "onMeFocusEnd", "onMeFocusStart", QCircleAlphaUserReporter.KEY_USER, "Lcom/tencent/state/template/data/User;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public abstract class ChatLandShareBaseComponent extends SquareBaseComponent {
    public abstract void onEnterRoom(EnterRoomInfo info);

    public abstract void onMeFocusEnd();

    public abstract void onMeFocusStart(User user);
}
