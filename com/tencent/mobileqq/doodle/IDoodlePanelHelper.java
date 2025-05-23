package com.tencent.mobileqq.doodle;

import android.content.Context;
import com.tencent.mobileqq.activity.aio.doodle.BaseDoodleMsgLayout;
import com.tencent.mobileqq.activity.aio.doodle.BaseDoodlePanel;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;

@QAPI(process = {"all"})
/* loaded from: classes10.dex */
public interface IDoodlePanelHelper extends QRouteApi {
    BaseDoodleMsgLayout createMsgLayout(Context context);

    void destroy();

    void destroyCache();

    BaseDoodlePanel getDoodlePanel(Context context);

    long getMsgID(ChatMessage chatMessage);

    long getUniID(ChatMessage chatMessage);

    boolean isNewMsgAndNotPlayed(long j3, long j16);

    void playLayout(BaseDoodleMsgLayout baseDoodleMsgLayout, boolean z16);

    void registLayout(long j3, long j16, int i3, BaseDoodleMsgLayout baseDoodleMsgLayout);

    void setLastMsgID(List<ChatMessage> list);

    void setScrollData(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28);

    void setScrollState(int i3);
}
