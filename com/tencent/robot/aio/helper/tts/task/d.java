package com.tencent.robot.aio.helper.tts.task;

import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.aio.api.IAIOTtsApi;
import com.tencent.qqnt.audio.tts.ui.TtsPlayType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/robot/aio/helper/tts/task/d;", "Lcom/tencent/robot/aio/helper/tts/task/a;", "Lcom/tencent/robot/aio/helper/tts/task/e;", "processArgs", "", "a", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class d implements a {
    @Override // com.tencent.robot.aio.helper.tts.task.a
    public boolean a(@NotNull TtsPlayProcessArgs processArgs) {
        String str;
        Intrinsics.checkNotNullParameter(processArgs, "processArgs");
        AIOMsgItem msgItem = processArgs.getMsgItem();
        long msgId = msgItem.getMsgId();
        String valueOf = String.valueOf(msgItem.getMsgRecord().senderUin);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentUin();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        return com.tencent.qqnt.audio.tts.ui.e.INSTANCE.b().o(msgItem.getMsgId(), new com.tencent.qqnt.audio.tts.ui.b(msgId, valueOf, str, ((IAIOTtsApi) QRoute.api(IAIOTtsApi.class)).getTtsContent(msgItem), processArgs.getIsAutoTrigger(), com.tencent.qqnt.aio.msg.d.i(msgItem), null, processArgs.getTtsId(), TtsPlayType.TYPE_TEXT), processArgs.getPlayStateListener());
    }
}
