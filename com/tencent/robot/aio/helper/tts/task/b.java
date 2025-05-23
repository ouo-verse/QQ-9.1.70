package com.tencent.robot.aio.helper.tts.task;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0016\u0010\u0007\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H&J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH&J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH&J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H&J \u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0010H&J\u0010\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\bH&J\u0010\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\bH&J\u001a\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\b2\b\b\u0002\u0010\u001a\u001a\u00020\u0010H&J\b\u0010\u001c\u001a\u00020\u0002H&J\u0010\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001dH&J\u0010\u0010!\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\rH&J\u0010\u0010\"\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\bH&J\b\u0010#\u001a\u00020\u0002H&\u00a8\u0006$"}, d2 = {"Lcom/tencent/robot/aio/helper/tts/task/b;", "", "", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "Lcom/tencent/aio/data/msglist/a;", TabPreloadItem.TAB_NAME_MESSAGE, "p", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "newMsgItem", "", "oldStreamStatus", "f", "", "msgId", "c", "", com.tencent.mobileqq.msf.core.f0.c.e.h.f248218g, tl.h.F, "isSupportTts", "isSupportAutoTts", "isAutoTtsSwitchOpened", "o", "msgItem", "e", "g", "needPlay", "b", "l", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "j", "msgID", "k", "d", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public interface b {
    void b(@NotNull AIOMsgItem msgItem, boolean needPlay);

    void c(long msgId);

    void d(@NotNull AIOMsgItem msgItem);

    void e(@NotNull AIOMsgItem msgItem);

    void f(@NotNull AIOMsgItem newMsgItem, int oldStreamStatus);

    void g(@NotNull AIOMsgItem msgItem);

    void h(boolean isOpen);

    void j(@NotNull MsgRecord msgRecord);

    void k(long msgID);

    void l();

    void m();

    void o(boolean isSupportTts, boolean isSupportAutoTts, boolean isAutoTtsSwitchOpened);

    void onDestroy();

    void p(@NotNull List<? extends com.tencent.aio.data.msglist.a> msgList);
}
