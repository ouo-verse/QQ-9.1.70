package com.tencent.qqnt.aio.adapter.api;

import android.content.Context;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH&J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/IAIOGroupAlbumForwardApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "chatHistorySave2GroupAlbum", "", "context", "Landroid/content/Context;", "msgRecordList", "", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "forwardGroupAlbum", "msgItem", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "needShowAIOMenuGroupAlbumEntry", "", "peerUid", "", "needShowChatHistoryGroupAlbumEntry", "aio_adapter_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes23.dex */
public interface IAIOGroupAlbumForwardApi extends QRouteApi {
    void chatHistorySave2GroupAlbum(@NotNull Context context, @NotNull List<MsgRecord> msgRecordList);

    void forwardGroupAlbum(@NotNull Context context, @NotNull AIOMsgItem msgItem);

    boolean needShowAIOMenuGroupAlbumEntry(@NotNull String peerUid, @NotNull AIOMsgItem msgItem);

    boolean needShowChatHistoryGroupAlbumEntry(@NotNull String peerUid);
}
