package com.tencent.mobileqq.guild.message.notify.api;

import android.graphics.Bitmap;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes14.dex */
public interface IGuildNotify extends IRuntimeService {
    boolean canNotify(String str, Object obj);

    boolean canNotifyByLogic(MsgRecord msgRecord);

    Bitmap getAvatarBitmap(String str);

    String getNotificationPrefix(Message message);

    void handleNotifyGuildMessage(Message message);

    void handleNotifyGuildMessage(MsgRecord msgRecord);

    boolean isRevokeNotify(Message message);

    boolean shieldNotifyMainBackground(Message message, boolean z16);

    boolean shieldNotifyMainForeground(Message message);
}
