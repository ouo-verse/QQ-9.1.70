package com.tencent.guild.aio.msglist.graytips.combine;

import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.GrayTipElement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004J\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/guild/aio/msglist/graytips/combine/CombineGrayTipFilter;", "", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "msgItem", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/GrayTipElement;", "b", "grayTipElement", "", "c", "", "Lcom/tencent/aio/data/msglist/a;", TabPreloadItem.TAB_NAME_MESSAGE, "", "Lcom/tencent/guild/aio/msglist/graytips/combine/e;", "a", "Ljava/util/HashSet;", "", "Ljava/util/HashSet;", "mGrayTipsIdSet", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class CombineGrayTipFilter {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final CombineGrayTipFilter f111311a = new CombineGrayTipFilter();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashSet<Integer> mGrayTipsIdSet = new HashSet<Integer>() { // from class: com.tencent.guild.aio.msglist.graytips.combine.CombineGrayTipFilter$mGrayTipsIdSet$1
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            add(3);
        }

        public /* bridge */ boolean contains(Integer num) {
            return super.contains((Object) num);
        }

        public /* bridge */ int getSize() {
            return super.size();
        }

        public /* bridge */ boolean remove(Integer num) {
            return super.remove((Object) num);
        }

        @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final /* bridge */ int size() {
            return getSize();
        }

        @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof Integer) {
                return contains((Integer) obj);
            }
            return false;
        }

        @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final /* bridge */ boolean remove(Object obj) {
            if (obj == null ? true : obj instanceof Integer) {
                return remove((Integer) obj);
            }
            return false;
        }
    };

    CombineGrayTipFilter() {
    }

    @NotNull
    public final List<e> a(@NotNull List<? extends com.tencent.aio.data.msglist.a> msgList) {
        Intrinsics.checkNotNullParameter(msgList, "msgList");
        ArrayList arrayList = new ArrayList();
        if (msgList.isEmpty()) {
            return arrayList;
        }
        CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) msgList;
        int size = copyOnWriteArrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = copyOnWriteArrayList.get(i3);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.guild.api.data.msglist.GuildMsgItem");
            GuildMsgItem guildMsgItem = (GuildMsgItem) obj;
            GrayTipElement b16 = b(guildMsgItem);
            if (c(b16)) {
                com.tencent.aio.data.msglist.a cloneNewInstance = guildMsgItem.cloneNewInstance();
                copyOnWriteArrayList.set(i3, cloneNewInstance);
                Intrinsics.checkNotNull(b16);
                Intrinsics.checkNotNull(cloneNewInstance, "null cannot be cast to non-null type com.tencent.guild.api.data.msglist.GuildMsgItem");
                arrayList.add(new e(i3, b16, (GuildMsgItem) cloneNewInstance));
            }
        }
        return arrayList;
    }

    @Nullable
    public final GrayTipElement b(@NotNull GuildMsgItem msgItem) {
        ArrayList<MsgElement> arrayList;
        GrayTipElement grayTipElement;
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (msgItem.getMsgRecord().msgType == 5 && (arrayList = msgItem.getMsgRecord().elements) != null) {
            for (MsgElement msgElement : arrayList) {
                if (msgElement != null && (grayTipElement = msgElement.grayTipElement) != null) {
                    return grayTipElement;
                }
            }
            return null;
        }
        return null;
    }

    public final boolean c(@Nullable GrayTipElement grayTipElement) {
        if (grayTipElement == null) {
            return false;
        }
        return mGrayTipsIdSet.contains(Integer.valueOf(grayTipElement.subElementType));
    }
}
