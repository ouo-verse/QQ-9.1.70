package com.tencent.guild.aio.factory.business.holder.msglist.scrollers;

import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListDataVM;
import com.tencent.guild.aio.factory.business.holder.msglist.scrollers.d;
import com.tencent.guild.aio.util.ui.GuildChatPicDownloader;
import com.tencent.guild.aio.util.ui.PicSize;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.qqnt.kernel.nativeinterface.FileTransNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\fB\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0019\u0010\u001aJ0\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016J8\u0010\f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u001e\u0010\r\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u001c\u0010\u0012\u001a\u00020\t2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0011\u001a\u00020\u0002J\u001c\u0010\u0013\u001a\u00020\t2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0011\u001a\u00020\u0002R\u0017\u0010\u0018\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/scrollers/GuildChatPicPreloadScrollListener;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/scrollers/d;", "", "firstVisiblePos", "lastVisiblePos", "firstCompletelyVisible", "lastCompletelyVisible", "Lcom/tencent/guild/aio/factory/business/holder/msglist/scrollers/ScrollDirection;", "direction", "", "b", "newState", "a", "d", "", "Lcom/tencent/aio/data/msglist/a;", TabPreloadItem.TAB_NAME_MESSAGE, "firstPrePos", "f", "e", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListDataVM;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListDataVM;", "getVm", "()Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListDataVM;", "vm", "<init>", "(Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListDataVM;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildChatPicPreloadScrollListener implements d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildMsgListDataVM vm;

    public GuildChatPicPreloadScrollListener(@NotNull GuildMsgListDataVM vm5) {
        Intrinsics.checkNotNullParameter(vm5, "vm");
        this.vm = vm5;
    }

    @Override // com.tencent.guild.aio.factory.business.holder.msglist.scrollers.d
    public void a(int newState, int firstVisiblePos, int lastVisiblePos, int firstCompletelyVisible, int lastCompletelyVisible, @NotNull ScrollDirection direction) {
        Intrinsics.checkNotNullParameter(direction, "direction");
        if (newState == 0) {
            d(ScrollDirection.IDLE, firstVisiblePos, lastVisiblePos);
        }
    }

    @Override // com.tencent.guild.aio.factory.business.holder.msglist.scrollers.d
    public void b(int firstVisiblePos, int lastVisiblePos, int firstCompletelyVisible, int lastCompletelyVisible, @NotNull ScrollDirection direction) {
        Intrinsics.checkNotNullParameter(direction, "direction");
        d(direction, firstVisiblePos, lastVisiblePos);
    }

    @Override // com.tencent.guild.aio.factory.business.holder.msglist.scrollers.d
    public void c(int i3, int i16, @NotNull ScrollDirection scrollDirection) {
        d.a.a(this, i3, i16, scrollDirection);
    }

    public final void d(@NotNull ScrollDirection direction, int firstVisiblePos, int lastVisiblePos) {
        List mutableList;
        Intrinsics.checkNotNullParameter(direction, "direction");
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) this.vm.l());
        if (mutableList.isEmpty()) {
            return;
        }
        Logger.f235387a.d().i("GUILD_MSGPIC.Preload", 1, "doPreload direction " + direction + "}");
        BuildersKt__Builders_commonKt.launch$default(this.vm.vmScope(), Dispatchers.getIO(), null, new GuildChatPicPreloadScrollListener$doPreload$2(direction, this, mutableList, firstVisiblePos, lastVisiblePos, null), 2, null);
    }

    public final void e(@NotNull List<? extends com.tencent.aio.data.msglist.a> msgList, int firstPrePos) {
        int coerceAtMost;
        GuildMsgItem guildMsgItem;
        MsgRecord msgRecord;
        ArrayList<MsgElement> arrayList;
        int i3 = firstPrePos;
        Intrinsics.checkNotNullParameter(msgList, "msgList");
        if (i3 < msgList.size() && i3 >= 0) {
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(i3 + 30, msgList.size() - 1);
            int i16 = 0;
            if (i3 <= coerceAtMost) {
                while (true) {
                    com.tencent.aio.data.msglist.a aVar = msgList.get(i3);
                    if (aVar instanceof GuildMsgItem) {
                        guildMsgItem = (GuildMsgItem) aVar;
                    } else {
                        guildMsgItem = null;
                    }
                    if (guildMsgItem != null && (msgRecord = guildMsgItem.getMsgRecord()) != null && (arrayList = msgRecord.elements) != null) {
                        for (MsgElement element : arrayList) {
                            GuildChatPicDownloader guildChatPicDownloader = GuildChatPicDownloader.f112420a;
                            PicSize picSize = PicSize.PIC_DOWNLOAD_AIO;
                            Intrinsics.checkNotNullExpressionValue(element, "element");
                            if (guildChatPicDownloader.w(picSize, element)) {
                                i16++;
                                Logger.f235387a.d().i("GUILD_MSGPIC.Preload", 1, " downPreload begin " + element.elementId);
                                guildChatPicDownloader.g(element, picSize, msgRecord, new Function1<FileTransNotifyInfo, Unit>() { // from class: com.tencent.guild.aio.factory.business.holder.msglist.scrollers.GuildChatPicPreloadScrollListener$downPreload$2$2
                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(FileTransNotifyInfo fileTransNotifyInfo) {
                                        invoke2(fileTransNotifyInfo);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(@NotNull FileTransNotifyInfo it) {
                                        Intrinsics.checkNotNullParameter(it, "it");
                                        Logger.f235387a.d().i("GUILD_MSGPIC.Preload", 1, " downPreload end   " + it);
                                    }
                                });
                            }
                            if (i16 >= 5) {
                                return;
                            }
                        }
                    }
                    if (i3 == coerceAtMost) {
                        break;
                    } else {
                        i3++;
                    }
                }
            }
            Logger.f235387a.d().i("GUILD_MSGPIC.Preload", 1, "downPreload picCount" + i16);
            return;
        }
        Logger logger = Logger.f235387a;
        Logger.b bVar = new Logger.b();
        String str = "downPreload PosERR " + i3;
        if (str instanceof String) {
            bVar.a().add(str);
        }
        Iterator<T> it = bVar.a().iterator();
        while (it.hasNext()) {
            Logger.f235387a.d().e("GUILD_MSGPIC.Preload", 1, (String) it.next(), null);
        }
    }

    public final void f(@NotNull List<? extends com.tencent.aio.data.msglist.a> msgList, int firstPrePos) {
        int coerceAtLeast;
        GuildMsgItem guildMsgItem;
        MsgRecord msgRecord;
        ArrayList<MsgElement> arrayList;
        int i3 = firstPrePos;
        Intrinsics.checkNotNullParameter(msgList, "msgList");
        int i16 = 1;
        if (i3 < msgList.size() && i3 > 0) {
            int i17 = 0;
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(i3 - 30, 0);
            if (coerceAtLeast <= i3) {
                while (true) {
                    com.tencent.aio.data.msglist.a aVar = msgList.get(i3);
                    if (aVar instanceof GuildMsgItem) {
                        guildMsgItem = (GuildMsgItem) aVar;
                    } else {
                        guildMsgItem = null;
                    }
                    if (guildMsgItem != null && (msgRecord = guildMsgItem.getMsgRecord()) != null && (arrayList = msgRecord.elements) != null) {
                        for (int size = arrayList.size() - i16; -1 < size; size--) {
                            MsgElement element = arrayList.get(size);
                            GuildChatPicDownloader guildChatPicDownloader = GuildChatPicDownloader.f112420a;
                            PicSize picSize = PicSize.PIC_DOWNLOAD_AIO;
                            Intrinsics.checkNotNullExpressionValue(element, "element");
                            if (guildChatPicDownloader.w(picSize, element)) {
                                i17++;
                                Logger.f235387a.d().i("GUILD_MSGPIC.Preload", 1, " upPreload begin " + element.elementId);
                                guildChatPicDownloader.g(element, picSize, msgRecord, new Function1<FileTransNotifyInfo, Unit>() { // from class: com.tencent.guild.aio.factory.business.holder.msglist.scrollers.GuildChatPicPreloadScrollListener$upPreload$2$2
                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(FileTransNotifyInfo fileTransNotifyInfo) {
                                        invoke2(fileTransNotifyInfo);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(@NotNull FileTransNotifyInfo it) {
                                        Intrinsics.checkNotNullParameter(it, "it");
                                        Logger.f235387a.d().i("GUILD_MSGPIC.Preload", 1, " upPreload cb   " + it);
                                    }
                                });
                            }
                            if (i17 >= 5) {
                                return;
                            }
                        }
                    }
                    if (i3 == coerceAtLeast) {
                        break;
                    }
                    i3--;
                    i16 = 1;
                }
            }
            Logger.f235387a.d().i("GUILD_MSGPIC.Preload", 1, "upPreload picCount" + i17);
            return;
        }
        Logger logger = Logger.f235387a;
        Logger.b bVar = new Logger.b();
        String str = "upPreload PosERR " + i3;
        if (str instanceof String) {
            bVar.a().add(str);
        }
        Iterator<T> it = bVar.a().iterator();
        while (it.hasNext()) {
            Logger.f235387a.d().e("GUILD_MSGPIC.Preload", 1, (String) it.next(), null);
        }
    }
}
