package com.tencent.guild.aio.reserve2.busi.chosen.view;

import android.widget.ImageView;
import com.tencent.guild.aio.util.ui.GuildChatPicDownloader;
import com.tencent.guild.aio.util.ui.PicSize;
import com.tencent.guild.aio.util.ui.UIUtil;
import com.tencent.guild.api.channel.IGuildChannelApi;
import com.tencent.guild.api.image.IGuildImageApi;
import com.tencent.guild.api.video.IGuildVideoApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.RichDownLoadReq;
import com.tencent.qqnt.kernel.nativeinterface.RichMediaElementGetReq;
import com.tencent.qqnt.msg.api.IMsgService;
import com.tencent.qqnt.msg.api.IRichMediaService;
import java.io.File;
import java.util.ArrayList;
import jr0.GuildImageOptions;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b!\u0010\"J,\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0004J\u0016\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012J\"\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u000e\u0010\u0017\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u0007R\"\u0010\u001d\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010 \u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001c\u00a8\u0006#"}, d2 = {"Lcom/tencent/guild/aio/reserve2/busi/chosen/view/a;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "", "downType", "thumbSize", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "msgElement", "Lcom/tencent/qqnt/kernel/nativeinterface/RichDownLoadReq;", "c", "", "d", "msg", "type", "e", "", "path", "Landroid/widget/ImageView;", "ivPic", "a", "Lcom/tencent/qqnt/kernel/nativeinterface/RichMediaElementGetReq;", "b", "f", "I", "getDEFAULT_PIC_HEIGHT", "()I", "setDEFAULT_PIC_HEIGHT", "(I)V", "DEFAULT_PIC_HEIGHT", "getDEFAULT_PIC_WIDTH", "setDEFAULT_PIC_WIDTH", "DEFAULT_PIC_WIDTH", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f112232a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static int DEFAULT_PIC_HEIGHT = com.tencent.guild.aio.util.c.b(37);

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static int DEFAULT_PIC_WIDTH = com.tencent.guild.aio.util.c.b(37);

    a() {
    }

    private final RichDownLoadReq c(MsgRecord msgRecord, int downType, int thumbSize, MsgElement msgElement) {
        if (msgElement == null) {
            return null;
        }
        return new RichDownLoadReq(downType, thumbSize, msgRecord.msgId, msgRecord.msgRandom, msgRecord.msgSeq, msgRecord.msgTime, msgRecord.chatType, msgRecord.senderUid, msgRecord.peerUid, msgRecord.guildId, msgElement, null);
    }

    @NotNull
    public final ImageView a(@NotNull String path, @NotNull ImageView ivPic) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(ivPic, "ivPic");
        if (!new File(path).exists()) {
            QLog.i("ChosenLoadPicUtil", 1, "applyPicView path is not exists");
            ivPic.setImageDrawable(UIUtil.t(DEFAULT_PIC_WIDTH, DEFAULT_PIC_HEIGHT));
        } else {
            int i3 = DEFAULT_PIC_WIDTH;
            int i16 = DEFAULT_PIC_HEIGHT;
            ((IGuildImageApi) QRoute.api(IGuildImageApi.class)).load(new GuildImageOptions(path, ivPic, false, i3, i16, UIUtil.t(i3, i16), UIUtil.u(DEFAULT_PIC_WIDTH, DEFAULT_PIC_HEIGHT)));
        }
        return ivPic;
    }

    @Nullable
    public final RichMediaElementGetReq b(@NotNull MsgRecord msgRecord, int downType, @Nullable MsgElement msgElement) {
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        if (msgElement == null) {
            return null;
        }
        return new RichMediaElementGetReq(msgRecord.msgId, msgRecord.peerUid, msgRecord.chatType, msgElement.elementId, downType, 0, "", 0L, 0, 0);
    }

    public final void d(@NotNull MsgRecord msgRecord) {
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        MsgElement e16 = e(msgRecord, 5);
        if (e16 == null) {
            return;
        }
        IGuildChannelApi iGuildChannelApi = (IGuildChannelApi) QRoute.api(IGuildChannelApi.class);
        String str = msgRecord.channelId;
        Intrinsics.checkNotNullExpressionValue(str, "msgRecord.channelId");
        String str2 = msgRecord.guildId;
        Intrinsics.checkNotNullExpressionValue(str2, "msgRecord.guildId");
        boolean isSelfGuest = iGuildChannelApi.isSelfGuest(str, str2);
        QLog.i("ChosenLoadPicUtil", 1, "downloadVideoThumbNail msgSeq=" + msgRecord.msgSeq);
        if (isSelfGuest) {
            ((IRichMediaService) QRoute.api(IRichMediaService.class)).downloadRichMediaInVisit(c(msgRecord, 2, 0, e16));
        } else {
            RichMediaElementGetReq b16 = b(msgRecord, 2, e16);
            if (b16 != null) {
                ((IMsgService) QRoute.api(IMsgService.class)).getRichMediaElement(b16);
            }
        }
    }

    @Nullable
    public final MsgElement e(@NotNull MsgRecord msg2, int type) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        ArrayList<MsgElement> arrayList = msg2.elements;
        if (arrayList != null) {
            for (MsgElement msgElement : arrayList) {
                if (msgElement.elementType == type) {
                    return msgElement;
                }
            }
            return null;
        }
        return null;
    }

    @NotNull
    public final String f(@NotNull MsgElement msgElement) {
        Intrinsics.checkNotNullParameter(msgElement, "msgElement");
        if (msgElement.elementType == 5) {
            QRouteApi api = QRoute.api(IGuildVideoApi.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IGuildVideoApi::class.java)");
            return IGuildVideoApi.a.b((IGuildVideoApi) api, msgElement, false, 2, null);
        }
        return GuildChatPicDownloader.f112420a.q(msgElement, PicSize.PIC_DOWNLOAD_THUMB);
    }
}
