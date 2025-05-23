package com.tencent.guild.aio.factory;

import com.tencent.common.config.pad.DeviceType;
import com.tencent.common.config.pad.PadUtil;
import com.tencent.guild.aio.msglist.ark.g;
import com.tencent.guild.aio.msglist.reaction.utils.ReactionUtilsKt;
import com.tencent.guild.aio.msglist.text.GuildTextContentComponent;
import com.tencent.guild.aio.util.ui.UIUtil;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.aio.utils.al;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgEmojiLikes;
import com.tencent.qqnt.msg.MsgExtKt;
import gq0.EmojiTaskItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u001e\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\u000e\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010\u000f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0018\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u001c\u0010\u0017\u001a\u00020\u00162\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/guild/aio/factory/d;", "", "", "Lcom/tencent/aio/data/msglist/a;", TabPreloadItem.TAB_NAME_MESSAGE, "", "targetCount", "", "a", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "msg", "g", "c", "f", "e", "i", "d", "", "content", h.F, "height", "b", "", "j", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f110653a = new d();

    d() {
    }

    private final float a(List<? extends com.tencent.aio.data.msglist.a> msgList, int targetCount) {
        float f16;
        float f17 = 0.0f;
        for (int size = msgList.size() - 1; -1 < size; size--) {
            com.tencent.aio.data.msglist.a aVar = msgList.get(size);
            if (aVar instanceof GuildMsgItem) {
                GuildMsgItem guildMsgItem = (GuildMsgItem) aVar;
                if (guildMsgItem.isGrayTipMsg()) {
                    f16 = 0.5f;
                } else if (qr0.d.n(guildMsgItem)) {
                    f16 = 1.5f;
                } else if (qr0.e.f(guildMsgItem.getMsgRecord())) {
                    f16 = 2.0f;
                } else if (MsgExtKt.w(guildMsgItem.getMsgRecord())) {
                    f16 = e(guildMsgItem, targetCount);
                } else if (al.h(guildMsgItem.getMsgRecord())) {
                    f16 = i(guildMsgItem, targetCount);
                } else if (MsgExtKt.y(guildMsgItem.getMsgRecord())) {
                    f16 = g(guildMsgItem, targetCount);
                } else if (qr0.d.g(guildMsgItem)) {
                    f16 = f(guildMsgItem);
                } else if (qr0.d.d(guildMsgItem)) {
                    f16 = c(guildMsgItem, targetCount);
                } else {
                    f16 = 1.0f;
                }
                f17 = f17 + f16 + d(guildMsgItem);
            }
            if (f17 > targetCount) {
                break;
            }
        }
        return f17;
    }

    private final float b(int height, int targetCount) {
        return height / (BaseApplication.getContext().getResources().getDisplayMetrics().heightPixels / targetCount);
    }

    private final float c(GuildMsgItem msg2, int targetCount) {
        Object last;
        int i3;
        String str;
        String str2;
        try {
            ArrayList<MsgElement> arrayList = msg2.getMsgRecord().elements;
            Intrinsics.checkNotNullExpressionValue(arrayList, "msg.msgRecord.elements");
            last = CollectionsKt___CollectionsKt.last((List<? extends Object>) arrayList);
            String arkDataJson = ((MsgElement) last).arkElement.bytesData;
            com.tencent.qqnt.msg.data.a aVar = new com.tencent.qqnt.msg.data.a();
            Intrinsics.checkNotNullExpressionValue(arkDataJson, "arkDataJson");
            if (aVar.o(arkDataJson)) {
                g d16 = g.INSTANCE.d();
                if (d16 != null) {
                    String str3 = msg2.getMsgRecord().guildId;
                    Intrinsics.checkNotNullExpressionValue(str3, "msg.msgRecord.guildId");
                    String str4 = msg2.getMsgRecord().channelId;
                    Intrinsics.checkNotNullExpressionValue(str4, "msg.msgRecord.channelId");
                    long msgId = msg2.getMsgId();
                    String d17 = aVar.d();
                    if (d17 == null) {
                        str = "";
                    } else {
                        str = d17;
                    }
                    String e16 = aVar.e();
                    if (e16 == null) {
                        str2 = "";
                    } else {
                        str2 = e16;
                    }
                    i3 = d16.d(str3, str4, msgId, str, str2);
                } else {
                    i3 = 0;
                }
                if (i3 > 0 && targetCount > 0) {
                    float b16 = b(i3, targetCount);
                    if (QLog.isDevelopLevel()) {
                        QLog.d("GuildMsgHeightCalculator", 4, "getArkMsgFactor: " + b16);
                    }
                    return b16;
                }
            }
        } catch (Exception e17) {
            QLog.e("GuildMsgHeightCalculator", 1, "getArkMsgFactor exception: " + e17.getMessage());
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("GuildMsgHeightCalculator", 4, "getArkMsgFactor: 1.5");
            return 1.5f;
        }
        return 1.5f;
    }

    private final float d(GuildMsgItem msg2) {
        boolean z16;
        int i3;
        boolean z17;
        ArrayList<EmojiTaskItem> g16 = ReactionUtilsKt.g(msg2);
        int size = g16.size();
        ArrayList<MsgEmojiLikes> arrayList = msg2.getMsgRecord().emojiLikesList;
        boolean z18 = false;
        if (arrayList != null && !arrayList.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            Iterator<MsgEmojiLikes> it = msg2.getMsgRecord().emojiLikesList.iterator();
            while (it.hasNext()) {
                MsgEmojiLikes emo = it.next();
                Iterator<EmojiTaskItem> it5 = g16.iterator();
                while (true) {
                    if (it5.hasNext()) {
                        EmojiTaskItem next = it5.next();
                        Intrinsics.checkNotNullExpressionValue(emo, "emo");
                        if (next.m(emo)) {
                            z17 = true;
                            break;
                        }
                    } else {
                        z17 = false;
                        break;
                    }
                }
                if (!z17) {
                    size++;
                }
            }
        }
        if (size > 1) {
            size++;
        }
        DeviceType a16 = PadUtil.a(BaseApplication.getContext());
        if (a16 == DeviceType.TABLET || a16 == DeviceType.FOLD) {
            z18 = true;
        }
        if (z18) {
            i3 = 10;
        } else {
            i3 = 7;
        }
        float f16 = (size / i3) * 0.3f;
        if (QLog.isDevelopLevel()) {
            QLog.d("GuildMsgHeightCalculator", 4, "getEmojiLikeFactor: emoCnt: " + size + ", factor: " + f16);
        }
        return f16;
    }

    private final float e(GuildMsgItem msg2, int targetCount) {
        Object last;
        float b16;
        if (!MsgExtKt.L(msg2.getMsgRecord()) && !MsgExtKt.X(msg2.getMsgRecord())) {
            b16 = 0.0f;
        } else {
            UIUtil uIUtil = UIUtil.f112434a;
            ArrayList<MsgElement> arrayList = msg2.getMsgRecord().elements;
            Intrinsics.checkNotNullExpressionValue(arrayList, "msg.msgRecord.elements");
            last = CollectionsKt___CollectionsKt.last((List<? extends Object>) arrayList);
            Intrinsics.checkNotNullExpressionValue(last, "msg.msgRecord.elements.last()");
            b16 = b(uIUtil.h((MsgElement) last, true, false).height, targetCount) + 0.0f;
        }
        if (b16 <= 0.0f) {
            b16 = 1.5f;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("GuildMsgHeightCalculator", 4, "getFileMsgFactor: " + b16);
        }
        return b16;
    }

    private final float f(GuildMsgItem msg2) {
        boolean z16;
        float h16;
        ArrayList<MsgElement> arrayList = msg2.getMsgRecord().elements;
        Intrinsics.checkNotNullExpressionValue(arrayList, "msg.msgRecord.elements");
        Iterator<T> it = arrayList.iterator();
        float f16 = 0.0f;
        while (true) {
            z16 = true;
            if (!it.hasNext()) {
                break;
            }
            MsgElement msgElement = (MsgElement) it.next();
            int i3 = msgElement.elementType;
            if (i3 != 1) {
                if (i3 == 17) {
                    h16 = msgElement.inlineKeyboardElement.rows.size() * 1.5f;
                }
            } else {
                d dVar = f110653a;
                String str = msgElement.textElement.content;
                Intrinsics.checkNotNullExpressionValue(str, "element.textElement.content");
                h16 = dVar.h(str);
            }
            f16 += h16;
        }
        if (f16 != 0.0f) {
            z16 = false;
        }
        if (z16) {
            if (QLog.isDevelopLevel()) {
                QLog.d("GuildMsgHeightCalculator", 4, "getMKDMsgFactor: 1.2");
            }
            return 1.2f;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("GuildMsgHeightCalculator", 4, "getMKDMsgFactor: " + f16);
            return f16;
        }
        return f16;
    }

    private final float g(GuildMsgItem msg2, int targetCount) {
        boolean z16;
        float h16;
        ArrayList<MsgElement> arrayList = msg2.getMsgRecord().elements;
        Intrinsics.checkNotNullExpressionValue(arrayList, "msg.msgRecord.elements");
        Iterator<T> it = arrayList.iterator();
        float f16 = 0.0f;
        while (true) {
            z16 = false;
            if (!it.hasNext()) {
                break;
            }
            MsgElement element = (MsgElement) it.next();
            int i3 = element.elementType;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 5) {
                        h16 = f110653a.b(com.tencent.guild.aio.msglist.video.a.f111981a.e(msg2).getSecond().intValue(), targetCount);
                    }
                } else {
                    UIUtil uIUtil = UIUtil.f112434a;
                    Intrinsics.checkNotNullExpressionValue(element, "element");
                    h16 = f110653a.b(uIUtil.h(element, true, false).height, targetCount);
                }
            } else {
                d dVar = f110653a;
                String str = element.textElement.content;
                Intrinsics.checkNotNullExpressionValue(str, "element.textElement.content");
                h16 = dVar.h(str);
            }
            f16 += h16;
        }
        ArrayList<MsgElement> arrayList2 = msg2.getMsgRecord().elements;
        Intrinsics.checkNotNullExpressionValue(arrayList2, "msg.msgRecord.elements");
        if (com.tencent.guild.aio.util.ex.e.d(arrayList2)) {
            f16 += b(GuildTextContentComponent.INSTANCE.a(), targetCount);
        }
        if (f16 == 0.0f) {
            z16 = true;
        }
        if (z16) {
            f16 = 1.0f;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("GuildMsgHeightCalculator", 4, "getMixMsgFactor: " + f16);
        }
        return f16;
    }

    private final float h(String content) {
        List split$default;
        int i3;
        int i16;
        if (content.length() <= 5000) {
            split$default = StringsKt__StringsKt.split$default((CharSequence) content, new String[]{"\n"}, false, 0, 6, (Object) null);
            Iterator it = split$default.iterator();
            int i17 = 0;
            while (it.hasNext()) {
                if (((String) it.next()).length() / 40 > 0) {
                    i16 = (int) Math.ceil(r1.length() / 40);
                } else {
                    i16 = 1;
                }
                i17 += i16;
            }
            if (i17 <= 0) {
                i3 = 1;
            } else {
                i3 = i17;
            }
        } else {
            i3 = content.length() / 40;
        }
        return 1 + ((i3 - 1) * 0.2f);
    }

    private final float i(GuildMsgItem msg2, int targetCount) {
        float b16 = b(com.tencent.guild.aio.msglist.video.a.f111981a.e(msg2).getSecond().intValue(), targetCount);
        if (QLog.isDevelopLevel()) {
            QLog.d("GuildMsgHeightCalculator", 4, "getVideoMsgFactor: " + b16);
        }
        return b16;
    }

    public final boolean j(@NotNull List<? extends com.tencent.aio.data.msglist.a> msgList, int targetCount) {
        Intrinsics.checkNotNullParameter(msgList, "msgList");
        try {
            float a16 = a(msgList, targetCount);
            QLog.i("GuildMsgHeightCalculator", 1, "hasEnoughMsgCount, factor: " + a16);
            float f16 = targetCount;
            if (a16 >= f16 || f16 - a16 < 2.0f) {
                return true;
            }
            return false;
        } catch (Exception e16) {
            QLog.e("GuildMsgHeightCalculator", 1, "hasEnoughMsgCount exception: " + e16.getMessage());
            return false;
        }
    }
}
