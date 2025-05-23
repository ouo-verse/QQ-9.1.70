package com.tencent.guild.aio.input.at.quickAt.selectmember.data;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001Ba\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004\u0012B\u0010\u0014\u001a>\u00124\u00122\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00010\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00020\n\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00020\n\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0006\u0010\u0003\u001a\u00020\u0002R\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bRS\u0010\u0014\u001a>\u00124\u00122\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00010\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00020\n\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0018\u001a\u00020\u00158F\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/guild/aio/input/at/quickAt/selectmember/data/GuildAtExpandItemData;", "Lcom/tencent/guild/aio/input/at/quickAt/selectmember/data/a;", "", "i", "", "d", "Ljava/util/List;", "k", "()Ljava/util/List;", "expandItems", "Lkotlin/Function1;", "Ljava/util/ArrayList;", "Lkotlin/ParameterName;", "name", "list", "updater", "e", "Lkotlin/jvm/functions/Function1;", "getUpdateList", "()Lkotlin/jvm/functions/Function1;", "updateList", "", "j", "()I", "count", "", "folderName", "<init>", "(Ljava/lang/String;Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildAtExpandItemData extends a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<a> expandItems;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<Function1<? super ArrayList<a>, Unit>, Unit> updateList;

    /* JADX WARN: Multi-variable type inference failed */
    public GuildAtExpandItemData(@NotNull String folderName, @NotNull List<? extends a> expandItems, @NotNull Function1<? super Function1<? super ArrayList<a>, Unit>, Unit> updateList) {
        Intrinsics.checkNotNullParameter(folderName, "folderName");
        Intrinsics.checkNotNullParameter(expandItems, "expandItems");
        Intrinsics.checkNotNullParameter(updateList, "updateList");
        this.expandItems = expandItems;
        this.updateList = updateList;
        f(folderName);
    }

    public final void i() {
        this.updateList.invoke(new Function1<ArrayList<a>, Unit>() { // from class: com.tencent.guild.aio.input.at.quickAt.selectmember.data.GuildAtExpandItemData$expend$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ArrayList<a> arrayList) {
                invoke2(arrayList);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull ArrayList<a> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                int indexOf = it.indexOf(GuildAtExpandItemData.this);
                if (indexOf == -1) {
                    return;
                }
                it.remove(indexOf);
                it.addAll(indexOf, GuildAtExpandItemData.this.k());
            }
        });
    }

    public final int j() {
        return this.expandItems.size();
    }

    @NotNull
    public final List<a> k() {
        return this.expandItems;
    }
}
