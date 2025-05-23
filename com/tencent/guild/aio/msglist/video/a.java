package com.tencent.guild.aio.msglist.video;

import com.tencent.guild.aio.util.ui.UIUtil;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.RichMediaElementGetReq;
import com.tencent.qqnt.kernel.nativeinterface.VideoElement;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J$\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J \u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002J\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\b\u001a\u00020\u0007J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\b\u001a\u00020\u0007\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/guild/aio/msglist/video/a;", "", "", "width", "height", "Lkotlin/Pair;", "d", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "msgItem", "downType", "triggerType", "Lcom/tencent/qqnt/kernel/nativeinterface/RichMediaElementGetReq;", "a", "e", "Lcom/tencent/qqnt/kernel/nativeinterface/VideoElement;", "c", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "b", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f111981a = new a();

    a() {
    }

    private final Pair<Integer, Integer> d(int width, int height) {
        if (width <= 0) {
            return new Pair<>(Integer.valueOf(width), Integer.valueOf(height));
        }
        float l3 = UIUtil.f112434a.l() + 0.5f;
        if (width <= height) {
            l3 *= 0.7f;
        }
        return new Pair<>(Integer.valueOf((int) l3), Integer.valueOf((int) ((height * l3) / width)));
    }

    @Nullable
    public final RichMediaElementGetReq a(@NotNull GuildMsgItem msgItem, int downType, int triggerType) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        MsgElement b16 = b(msgItem);
        if (b16 == null) {
            return null;
        }
        return new RichMediaElementGetReq(msgItem.getMsgRecord().msgId, msgItem.getMsgRecord().peerUid, msgItem.getMsgRecord().chatType, b16.elementId, downType, 0, "", 0L, 0, triggerType);
    }

    @Nullable
    public final MsgElement b(@NotNull GuildMsgItem msgItem) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Iterator<MsgElement> it = msgItem.getMsgRecord().elements.iterator();
        while (it.hasNext()) {
            MsgElement next = it.next();
            if (next.elementType == 5) {
                return next;
            }
        }
        return null;
    }

    @Nullable
    public final VideoElement c(@NotNull GuildMsgItem msgItem) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        MsgElement b16 = b(msgItem);
        if (b16 != null) {
            return b16.videoElement;
        }
        return null;
    }

    @NotNull
    public final Pair<Integer, Integer> e(@NotNull GuildMsgItem msgItem) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        VideoElement c16 = c(msgItem);
        if (c16 != null) {
            return f111981a.d(c16.thumbWidth, c16.thumbHeight);
        }
        return new Pair<>(0, 0);
    }
}
