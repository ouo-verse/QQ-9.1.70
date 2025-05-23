package com.tencent.qqnt.aio.msg.api;

import android.content.Context;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msg.template.d;
import com.tencent.mobileqq.aio.msglist.holder.component.video.z;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.msg.data.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0004H&J0\u0010\f\u001a\"\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tj\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\u000b2\u0006\u0010\u0006\u001a\u00020\u0004H&J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0006\u001a\u00020\u0004H&J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0006\u001a\u00020\u0004H&J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H&J\u001a\u0010\u0017\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u0004H&J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0004H&J\u0010\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0004H&J\u0010\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0006\u001a\u00020\u0004H&J\u0016\u0010\u001f\u001a\u00020\u00072\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH&J\u0010\u0010 \u001a\u00020\u001a2\u0006\u0010\u0006\u001a\u00020\u0004H&J\u0010\u0010$\u001a\u00020#2\u0006\u0010\"\u001a\u00020!H&J\u0010\u0010&\u001a\u00020#2\u0006\u0010%\u001a\u00020\u0013H&J \u0010*\u001a\u0012\u0012\u0004\u0012\u00020\u001d0(j\b\u0012\u0004\u0012\u00020\u001d`)2\u0006\u0010'\u001a\u00020\u001aH&J&\u0010+\u001a\u0012\u0012\u0004\u0012\u00020\u001d0(j\b\u0012\u0004\u0012\u00020\u001d`)2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00110\u001cH&J\u0010\u0010-\u001a\u00020,2\u0006\u0010\u0006\u001a\u00020\u0004H&J\u001c\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\n0.2\u0006\u0010\u0006\u001a\u00020\u0004H&J\u001c\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\n0.2\u0006\u0010\u0006\u001a\u00020\u0004H&J\u001c\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\n0.2\u0006\u0010\u0006\u001a\u00020\u0004H&J\u001c\u00102\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\n0.2\u0006\u0010\u0006\u001a\u00020\u0004H&\u00a8\u00063"}, d2 = {"Lcom/tencent/qqnt/aio/msg/api/IAIOMsgItemApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "transformMsgRecordWithType", "msgItem", "", "getTextFromMsgItem", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getTextMapFromMsgItem", "Lcom/tencent/qqnt/msg/data/a;", "parseArkModel", "Lcom/tencent/mobileqq/aio/msg/template/d;", "parseTemplateMsgInfo", "", "arkAppContainer", "", "isNtArkAppContainer", "Landroid/content/Context;", "context", "getPreviewText", "getTranslateText", "getLocalIdOfAniStickerMsg", "", "getResultIdOfAniStickerMsg", "", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "msgElements", "buildContent", "getLocalPath", "Lcom/tencent/mobileqq/aio/msglist/holder/component/video/z;", "sendInfo", "", "generateVideoExtBuf", "hasRead", "generateFlashPicExtBuf", "commentStr", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getForwardCommentElement", "transformAioMsgToElements", "", "updateSkinBubbleInfoForPreview", "Lkotlin/Pair;", "getPaddingLeft", "getPaddingRight", "getPaddingTop", "getPaddingBottom", "aio_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes23.dex */
public interface IAIOMsgItemApi extends QRouteApi {
    @NotNull
    CharSequence buildContent(@NotNull List<MsgElement> msgElements);

    @NotNull
    byte[] generateFlashPicExtBuf(boolean hasRead);

    @NotNull
    byte[] generateVideoExtBuf(@NotNull z sendInfo);

    @NotNull
    ArrayList<MsgElement> getForwardCommentElement(@NotNull String commentStr);

    int getLocalIdOfAniStickerMsg(@NotNull AIOMsgItem msgItem);

    @NotNull
    String getLocalPath(@NotNull AIOMsgItem msgItem);

    @NotNull
    Pair<Boolean, Integer> getPaddingBottom(@NotNull AIOMsgItem msgItem);

    @NotNull
    Pair<Boolean, Integer> getPaddingLeft(@NotNull AIOMsgItem msgItem);

    @NotNull
    Pair<Boolean, Integer> getPaddingRight(@NotNull AIOMsgItem msgItem);

    @NotNull
    Pair<Boolean, Integer> getPaddingTop(@NotNull AIOMsgItem msgItem);

    @Nullable
    CharSequence getPreviewText(@NotNull Context context, @NotNull AIOMsgItem msgItem);

    @NotNull
    String getResultIdOfAniStickerMsg(@NotNull AIOMsgItem msgItem);

    @Nullable
    CharSequence getTextFromMsgItem(@NotNull AIOMsgItem msgItem);

    @Nullable
    HashMap<Integer, CharSequence> getTextMapFromMsgItem(@NotNull AIOMsgItem msgItem);

    @Nullable
    CharSequence getTranslateText(@NotNull AIOMsgItem msgItem);

    boolean isNtArkAppContainer(@NotNull Object arkAppContainer);

    @Nullable
    a parseArkModel(@NotNull AIOMsgItem msgItem);

    @Nullable
    d parseTemplateMsgInfo(@NotNull AIOMsgItem msgItem);

    @NotNull
    ArrayList<MsgElement> transformAioMsgToElements(@NotNull List<Object> msgElements);

    @NotNull
    AIOMsgItem transformMsgRecordWithType(@NotNull MsgRecord msgRecord);

    void updateSkinBubbleInfoForPreview(@NotNull AIOMsgItem msgItem);
}
