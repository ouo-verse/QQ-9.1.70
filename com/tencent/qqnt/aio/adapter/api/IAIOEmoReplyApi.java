package com.tencent.qqnt.aio.adapter.api;

import android.content.Context;
import com.tencent.mobileqq.emoticonview.EmotionPanelData;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.aio.emoreply.f;
import com.tencent.qqnt.aio.emoreply.j;
import com.tencent.qqnt.kernel.nativeinterface.ISetMsgEmojiLikesCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J.\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u000e\u001a\u00020\u0004H&J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H&J\u0016\u0010\u0017\u001a\u00020\u000f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H&J2\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH&J*\u0010 \u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u001e2\b\b\u0002\u0010\u000e\u001a\u00020\u0004H&J\u000e\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H&\u00a8\u0006\""}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/IAIOEmoReplyApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "type", "", "localID", "", "isInEmoFilterList", "Landroid/content/Context;", "context", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "Lcom/tencent/qqnt/aio/emoreply/j;", "callBack", "from", "", "showAIOEmoReplyPanel", "", "groupUin", "isEmoReplyOpen", "", "Lcom/tencent/mobileqq/emoticonview/EmotionPanelData;", "recentList", "updateRecentEmoticon", "emojiId", "emojiType", "bClicked", "Lcom/tencent/qqnt/kernel/nativeinterface/ISetMsgEmojiLikesCallback;", "cb", "setEmojiLikes", "Lcom/tencent/qqnt/aio/emoreply/f;", "detailData", "showAIOEmoReplyDetailPanel", "getEmoReplyFilterData", "aio_adapter_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes23.dex */
public interface IAIOEmoReplyApi extends QRouteApi {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes23.dex */
    public static final class a {
        public static /* synthetic */ void a(IAIOEmoReplyApi iAIOEmoReplyApi, Context context, MsgRecord msgRecord, f fVar, String str, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 8) != 0) {
                    str = "1";
                }
                iAIOEmoReplyApi.showAIOEmoReplyDetailPanel(context, msgRecord, fVar, str);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showAIOEmoReplyDetailPanel");
        }

        public static /* synthetic */ void b(IAIOEmoReplyApi iAIOEmoReplyApi, Context context, MsgRecord msgRecord, j jVar, String str, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    jVar = null;
                }
                if ((i3 & 8) != 0) {
                    str = "1";
                }
                iAIOEmoReplyApi.showAIOEmoReplyPanel(context, msgRecord, jVar, str);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showAIOEmoReplyPanel");
        }
    }

    @NotNull
    List<EmotionPanelData> getEmoReplyFilterData();

    boolean isEmoReplyOpen(long groupUin);

    boolean isInEmoFilterList(int type, @NotNull String localID);

    void setEmojiLikes(@NotNull MsgRecord msgRecord, @NotNull String emojiId, int emojiType, boolean bClicked, @Nullable ISetMsgEmojiLikesCallback cb5);

    void showAIOEmoReplyDetailPanel(@NotNull Context context, @NotNull MsgRecord msgRecord, @NotNull f detailData, @NotNull String from);

    void showAIOEmoReplyPanel(@NotNull Context context, @NotNull MsgRecord msgRecord, @Nullable j callBack, @NotNull String from);

    void updateRecentEmoticon(@NotNull List<? extends EmotionPanelData> recentList);
}
