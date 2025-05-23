package com.tencent.qqnt.aio.api;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&JT\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u000b2\b\b\u0002\u0010\u0014\u001a\u00020\u0012H&JR\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0012H&J2\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0014\u001a\u00020\u0012H&\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/qqnt/aio/api/IMsgForwardNtUtil;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getForwardPreviewView", "Landroid/view/View;", "context", "Landroid/content/Context;", "msgItem", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "previewMsg", "", "chatType", "", "uid", "", "nick", "aioMsgItems", "", "isMultiForwardMsg", "", "forwardType", "needClearBg", "previewMsgWithMsgRecord", "aioMsgRecords", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "startForwardMiniAIO", "aio_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes23.dex */
public interface IMsgForwardNtUtil extends QRouteApi {
    @Nullable
    View getForwardPreviewView(@NotNull Context context, @NotNull AIOMsgItem msgItem);

    void previewMsg(@NotNull Context context, int chatType, @NotNull String uid, @NotNull String nick, @NotNull List<? extends AIOMsgItem> aioMsgItems, boolean isMultiForwardMsg, int forwardType, boolean needClearBg);

    void previewMsgWithMsgRecord(@NotNull Context context, int chatType, @NotNull String uid, @NotNull String nick, @NotNull List<MsgRecord> aioMsgRecords, boolean isMultiForwardMsg, int forwardType, boolean needClearBg);

    void startForwardMiniAIO(@NotNull Context context, int chatType, @NotNull String uid, @NotNull String nick, boolean needClearBg);
}
