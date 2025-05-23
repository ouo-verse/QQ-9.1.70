package com.tencent.mobileqq.guild.live.danmu.dispatch;

import com.tencent.mobileqq.guild.live.danmu.item.GLiveDanmuPriority;
import com.tencent.mobileqq.guild.live.viewmodel.GLiveDanmuLogicVM;
import com.tencent.mobileqq.guild.util.Logger;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \r2\u00020\u0001:\u0001\u0007B\u000f\u0012\u0006\u0010\n\u001a\u00020\b\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001e\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00062\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\n\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\t\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/live/danmu/dispatch/a;", "", "", "pullSize", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/guild/live/danmu/item/a;", "Lkotlin/collections/ArrayList;", "a", "Lcom/tencent/mobileqq/guild/live/viewmodel/GLiveDanmuLogicVM;", "Lcom/tencent/mobileqq/guild/live/viewmodel/GLiveDanmuLogicVM;", "logicVM", "<init>", "(Lcom/tencent/mobileqq/guild/live/viewmodel/GLiveDanmuLogicVM;)V", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GLiveDanmuLogicVM logicVM;

    public a(@NotNull GLiveDanmuLogicVM logicVM) {
        Intrinsics.checkNotNullParameter(logicVM, "logicVM");
        this.logicVM = logicVM;
    }

    @NotNull
    public final ArrayList<com.tencent.mobileqq.guild.live.danmu.item.a> a(int pullSize) {
        List<GLiveDanmuPriority> listOf;
        GuildLiveDanmuStore danmuStore = this.logicVM.getDanmuStore();
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new GLiveDanmuPriority[]{GLiveDanmuPriority.HIGH, GLiveDanmuPriority.NORMAL, GLiveDanmuPriority.LOW});
        ArrayList<com.tencent.mobileqq.guild.live.danmu.item.a> arrayList = new ArrayList<>();
        for (GLiveDanmuPriority gLiveDanmuPriority : listOf) {
            ArrayList<com.tencent.mobileqq.guild.live.danmu.item.a> b16 = danmuStore.b(gLiveDanmuPriority, pullSize - arrayList.size());
            if (!b16.isEmpty()) {
                arrayList.addAll(b16);
                Logger.f235387a.d().d("QGL.GuildLiveDanmuConsumer", 1, "[getDanmuItemList] priority " + gLiveDanmuPriority + ", size " + b16.size());
            }
        }
        return arrayList;
    }
}
