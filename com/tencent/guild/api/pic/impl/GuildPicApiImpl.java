package com.tencent.guild.api.pic.impl;

import com.tencent.guild.api.channel.IGuildChannelApi;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guild.api.pic.IGuildPicApi;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.api.ICompressOperator;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import com.tencent.qqnt.kernel.nativeinterface.RichDownLoadReq;
import com.tencent.qqnt.kernel.nativeinterface.RichMediaElementGetReq;
import com.tencent.qqnt.kernel.nativeinterface.RichMediaFilePathInfo;
import com.tencent.qqnt.kernel.nativeinterface.cq;
import com.tencent.qqnt.msg.api.IRichMediaService;
import com.tencent.qqnt.msg.f;
import java.io.File;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001c\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0006H\u0016J \u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J,\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130\u00182\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u001cH\u0016\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/guild/api/pic/impl/GuildPicApiImpl;", "Lcom/tencent/guild/api/pic/IGuildPicApi;", "()V", "checkAndDownloadThumbPic", "", "msgElement", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "msgItem", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "generateThumb", "", "srcPath", "", "dstPath", "getAIOImagePath", "getOriginImagePath", "picMsgElement", "getPicPath", "downloadType", "", "thumbSize", "getThumbImagePath198", "getThumbImagePath720", "scaleSize", "Lkotlin/Pair;", "width", "height", "maxPicSize", "", "nt-guild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class GuildPicApiImpl implements IGuildPicApi {
    @Override // com.tencent.guild.api.pic.IGuildPicApi
    public void checkAndDownloadThumbPic(@NotNull MsgElement msgElement, @NotNull GuildMsgItem msgItem) {
        Intrinsics.checkNotNullParameter(msgElement, "msgElement");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (new File(getThumbImagePath198(msgElement)).exists()) {
            return;
        }
        IGuildChannelApi iGuildChannelApi = (IGuildChannelApi) QRoute.api(IGuildChannelApi.class);
        String str = msgItem.getMsgRecord().channelId;
        Intrinsics.checkNotNullExpressionValue(str, "msgItem.msgRecord.channelId");
        String str2 = msgItem.getMsgRecord().guildId;
        Intrinsics.checkNotNullExpressionValue(str2, "msgItem.msgRecord.guildId");
        if (iGuildChannelApi.isSelfGuest(str, str2)) {
            ((IRichMediaService) QRoute.api(IRichMediaService.class)).downloadRichMediaInVisit(new RichDownLoadReq(2, 198, msgItem.getMsgRecord().msgId, msgItem.getMsgRecord().msgRandom, msgItem.getMsgRecord().msgSeq, msgItem.getMsgRecord().msgTime, msgItem.getMsgRecord().chatType, msgItem.getMsgRecord().senderUid, msgItem.getMsgRecord().peerUid, msgItem.getMsgRecord().guildId, msgElement, null));
            return;
        }
        w e16 = f.e();
        if (e16 != null) {
            e16.getRichMediaElement(new RichMediaElementGetReq(msgItem.getMsgRecord().msgId, msgItem.getMsgRecord().peerUid, msgItem.getMsgRecord().chatType, msgElement.elementId, 2, 198, "", 0L, 0, 0));
        }
    }

    @Override // com.tencent.guild.api.pic.IGuildPicApi
    public boolean generateThumb(@Nullable String srcPath, @Nullable String dstPath) {
        CompressInfo compressInfo = new CompressInfo(srcPath, 0);
        ((ICompressOperator) QRoute.api(ICompressOperator.class)).start(compressInfo);
        String str = compressInfo.H;
        if (cq.n(str)) {
            cq.h(str, dstPath);
        }
        return cq.n(dstPath);
    }

    @Override // com.tencent.guild.api.pic.IGuildPicApi
    @NotNull
    public String getAIOImagePath(@NotNull MsgElement msgElement) {
        Intrinsics.checkNotNullParameter(msgElement, "msgElement");
        String originImagePath = getOriginImagePath(msgElement);
        if (new File(originImagePath).exists()) {
            return originImagePath;
        }
        return getThumbImagePath198(msgElement);
    }

    @Override // com.tencent.guild.api.pic.IGuildPicApi
    @NotNull
    public String getOriginImagePath(@NotNull MsgElement picMsgElement) {
        Intrinsics.checkNotNullParameter(picMsgElement, "picMsgElement");
        return getPicPath(picMsgElement, 1, 0);
    }

    @Override // com.tencent.guild.api.pic.IGuildPicApi
    @NotNull
    public String getPicPath(@NotNull MsgElement picMsgElement, int downloadType, int thumbSize) {
        String str;
        IKernelService iKernelService;
        w msgService;
        Intrinsics.checkNotNullParameter(picMsgElement, "picMsgElement");
        int i3 = picMsgElement.elementType;
        PicElement picElement = picMsgElement.picElement;
        RichMediaFilePathInfo richMediaFilePathInfo = new RichMediaFilePathInfo(i3, picElement.picSubType, picElement.md5HexStr, picElement.fileName, downloadType, thumbSize, picElement.importRichMediaContext, picElement.fileUuid, false);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && (iKernelService = (IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "")) != null && (msgService = iKernelService.getMsgService()) != null) {
            str = msgService.getRichMediaFilePathForGuild(richMediaFilePathInfo);
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    @Override // com.tencent.guild.api.pic.IGuildPicApi
    @NotNull
    public String getThumbImagePath198(@NotNull MsgElement msgElement) {
        Intrinsics.checkNotNullParameter(msgElement, "msgElement");
        return getPicPath(msgElement, 2, 198);
    }

    @Override // com.tencent.guild.api.pic.IGuildPicApi
    @NotNull
    public String getThumbImagePath720(@NotNull MsgElement msgElement) {
        Intrinsics.checkNotNullParameter(msgElement, "msgElement");
        return getPicPath(msgElement, 2, 720);
    }

    @Override // com.tencent.guild.api.pic.IGuildPicApi
    @NotNull
    public Pair<Integer, Integer> scaleSize(int width, int height, float maxPicSize) {
        float f16 = width;
        if (f16 > maxPicSize || height > maxPicSize) {
            float f17 = height;
            float max = Math.max(f16 / maxPicSize, f17 / maxPicSize);
            height = (int) (f17 / max);
            width = (int) (f16 / max);
        }
        if (width <= 0) {
            width = (int) maxPicSize;
        }
        if (height <= 0) {
            height = (int) maxPicSize;
        }
        return new Pair<>(Integer.valueOf(width), Integer.valueOf(height));
    }
}
