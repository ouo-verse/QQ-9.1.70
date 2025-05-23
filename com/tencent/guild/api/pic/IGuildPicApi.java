package com.tencent.guild.api.pic;

import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import kotlin.Metadata;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001c\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH&J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0005H&J \u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H&J\u0010\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0005H&J,\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u00172\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u001bH&\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/guild/api/pic/IGuildPicApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "checkAndDownloadThumbPic", "", "msgElement", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "msgItem", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "generateThumb", "", "srcPath", "", "dstPath", "getAIOImagePath", "getOriginImagePath", "picMsgElement", "getPicPath", "downloadType", "", "thumbSize", "getThumbImagePath198", "getThumbImagePath720", "scaleSize", "Lkotlin/Pair;", "width", "height", "maxPicSize", "", "nt-guild-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes6.dex */
public interface IGuildPicApi extends QRouteApi {
    void checkAndDownloadThumbPic(@NotNull MsgElement msgElement, @NotNull GuildMsgItem msgItem);

    boolean generateThumb(@Nullable String srcPath, @Nullable String dstPath);

    @NotNull
    String getAIOImagePath(@NotNull MsgElement msgElement);

    @NotNull
    String getOriginImagePath(@NotNull MsgElement picMsgElement);

    @NotNull
    String getPicPath(@NotNull MsgElement picMsgElement, int downloadType, int thumbSize);

    @NotNull
    String getThumbImagePath198(@NotNull MsgElement msgElement);

    @NotNull
    String getThumbImagePath720(@NotNull MsgElement msgElement);

    @NotNull
    Pair<Integer, Integer> scaleSize(int width, int height, float maxPicSize);
}
