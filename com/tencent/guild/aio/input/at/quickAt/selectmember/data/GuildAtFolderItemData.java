package com.tencent.guild.aio.input.at.quickAt.selectmember.data;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u00ad\u0001\b\u0007\u0012\u0006\u00104\u001a\u000203\u0012L\u0010\u0011\u001aH\u0012>\u0012<\u0012#\u0012!\u0012\u0004\u0012\u00020\u00010\u0007j\b\u0012\u0004\u0012\u00020\u0001`\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00040\u0006\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00040\u0006\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012D\b\u0002\u0010\"\u001a>\u0012\u0013\u0012\u00110\u001a\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u001b\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00040\u0006\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00040\u0019\u00a2\u0006\u0004\b5\u00106J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R]\u0010\u0011\u001aH\u0012>\u0012<\u0012#\u0012!\u0012\u0004\u0012\u00020\u00010\u0007j\b\u0012\u0004\u0012\u00020\u0001`\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00040\u0006\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00040\u00068\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017RS\u0010\"\u001a>\u0012\u0013\u0012\u00110\u001a\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u001b\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00040\u0006\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00040\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R'\u0010'\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0007j\b\u0012\u0004\u0012\u00020\u0001`\b8\u0006\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\"\u0010+\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010\u0013\u001a\u0004\b)\u0010\u0015\"\u0004\b*\u0010\u0017R\"\u00102\u001a\u00020,8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101\u00a8\u00067"}, d2 = {"Lcom/tencent/guild/aio/input/at/quickAt/selectmember/data/GuildAtFolderItemData;", "Lcom/tencent/guild/aio/input/at/quickAt/selectmember/data/a;", "", "open", "", "i", "Lkotlin/Function1;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Lkotlin/ParameterName;", "name", "list", "updater", "d", "Lkotlin/jvm/functions/Function1;", "o", "()Lkotlin/jvm/functions/Function1;", "updateList", "e", "Z", "l", "()Z", "setNeedExpand", "(Z)V", "needExpand", "Lkotlin/Function2;", "Lcom/tencent/guild/aio/input/at/quickAt/selectmember/delegate/d;", "control", "", IECSearchBar.METHOD_SET_HINT, "f", "Lkotlin/jvm/functions/Function2;", "k", "()Lkotlin/jvm/functions/Function2;", "hintUpdater", "g", "Ljava/util/ArrayList;", "j", "()Ljava/util/ArrayList;", ParseCommon.CONTAINER, h.F, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "p", "opened", "", "I", DomainData.DOMAIN_NAME, "()I", "setPreviewItemCount", "(I)V", "previewItemCount", "", "folderName", "<init>", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;ZLkotlin/jvm/functions/Function2;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildAtFolderItemData extends a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<Function1<? super ArrayList<a>, Unit>, Unit> updateList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean needExpand;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function2<com.tencent.guild.aio.input.at.quickAt.selectmember.delegate.d, Function1<? super CharSequence, Unit>, Unit> hintUpdater;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<a> container;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean opened;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int previewItemCount;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildAtFolderItemData(@NotNull String folderName, @NotNull Function1<? super Function1<? super ArrayList<a>, Unit>, Unit> updateList, boolean z16) {
        this(folderName, updateList, z16, null, 8, null);
        Intrinsics.checkNotNullParameter(folderName, "folderName");
        Intrinsics.checkNotNullParameter(updateList, "updateList");
    }

    public final void i(final boolean open) {
        this.updateList.invoke(new Function1<ArrayList<a>, Unit>() { // from class: com.tencent.guild.aio.input.at.quickAt.selectmember.data.GuildAtFolderItemData$fold$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ArrayList<a> arrayList) {
                invoke2(arrayList);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull ArrayList<a> resultList) {
                Intrinsics.checkNotNullParameter(resultList, "resultList");
                int indexOf = resultList.indexOf(GuildAtFolderItemData.this);
                if (indexOf == -1) {
                    return;
                }
                if (open) {
                    if (GuildAtFolderItemData.this.getNeedExpand() && GuildAtFolderItemData.this.j().size() > GuildAtFolderItemData.this.getPreviewItemCount()) {
                        ArrayList arrayList = new ArrayList();
                        List<a> subList = GuildAtFolderItemData.this.j().subList(0, GuildAtFolderItemData.this.getPreviewItemCount() - 1);
                        Intrinsics.checkNotNullExpressionValue(subList, "container.subList(0, previewItemCount - 1)");
                        arrayList.addAll(subList);
                        String folderName = GuildAtFolderItemData.this.b();
                        Intrinsics.checkNotNullExpressionValue(folderName, "folderName");
                        arrayList.add(new GuildAtExpandItemData(folderName, new ArrayList(GuildAtFolderItemData.this.j().subList(GuildAtFolderItemData.this.getPreviewItemCount() - 1, GuildAtFolderItemData.this.j().size())), GuildAtFolderItemData.this.o()));
                        resultList.addAll(indexOf + 1, arrayList);
                    } else {
                        resultList.addAll(indexOf + 1, GuildAtFolderItemData.this.j());
                    }
                    GuildAtFolderItemData.this.j().clear();
                    return;
                }
                ListIterator<a> listIterator = resultList.listIterator(indexOf + 1);
                Intrinsics.checkNotNullExpressionValue(listIterator, "resultList.listIterator(thisIndex + 1)");
                while (listIterator.hasNext()) {
                    a next = listIterator.next();
                    Intrinsics.checkNotNullExpressionValue(next, "it.next()");
                    a aVar = next;
                    if (!Intrinsics.areEqual(aVar.b(), GuildAtFolderItemData.this.b())) {
                        return;
                    }
                    GuildAtFolderItemData.this.j().add(aVar);
                    listIterator.remove();
                }
            }
        });
    }

    @NotNull
    public final ArrayList<a> j() {
        return this.container;
    }

    @NotNull
    public final Function2<com.tencent.guild.aio.input.at.quickAt.selectmember.delegate.d, Function1<? super CharSequence, Unit>, Unit> k() {
        return this.hintUpdater;
    }

    /* renamed from: l, reason: from getter */
    public final boolean getNeedExpand() {
        return this.needExpand;
    }

    /* renamed from: m, reason: from getter */
    public final boolean getOpened() {
        return this.opened;
    }

    /* renamed from: n, reason: from getter */
    public final int getPreviewItemCount() {
        return this.previewItemCount;
    }

    @NotNull
    public final Function1<Function1<? super ArrayList<a>, Unit>, Unit> o() {
        return this.updateList;
    }

    public final void p(boolean z16) {
        this.opened = z16;
    }

    public /* synthetic */ GuildAtFolderItemData(String str, Function1 function1, boolean z16, Function2 function2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, function1, z16, (i3 & 8) != 0 ? new Function2<com.tencent.guild.aio.input.at.quickAt.selectmember.delegate.d, Function1<? super CharSequence, ? extends Unit>, Unit>() { // from class: com.tencent.guild.aio.input.at.quickAt.selectmember.data.GuildAtFolderItemData.1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.guild.aio.input.at.quickAt.selectmember.delegate.d dVar, Function1<? super CharSequence, ? extends Unit> function12) {
                invoke2(dVar, (Function1<? super CharSequence, Unit>) function12);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull com.tencent.guild.aio.input.at.quickAt.selectmember.delegate.d dVar, @NotNull Function1<? super CharSequence, Unit> setHint) {
                Intrinsics.checkNotNullParameter(dVar, "<anonymous parameter 0>");
                Intrinsics.checkNotNullParameter(setHint, "setHint");
                setHint.invoke("");
            }
        } : function2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public GuildAtFolderItemData(@NotNull String folderName, @NotNull Function1<? super Function1<? super ArrayList<a>, Unit>, Unit> updateList, boolean z16, @NotNull Function2<? super com.tencent.guild.aio.input.at.quickAt.selectmember.delegate.d, ? super Function1<? super CharSequence, Unit>, Unit> hintUpdater) {
        Intrinsics.checkNotNullParameter(folderName, "folderName");
        Intrinsics.checkNotNullParameter(updateList, "updateList");
        Intrinsics.checkNotNullParameter(hintUpdater, "hintUpdater");
        this.updateList = updateList;
        this.needExpand = z16;
        this.hintUpdater = hintUpdater;
        this.container = new ArrayList<>();
        this.opened = true;
        this.previewItemCount = 6;
        f(folderName);
    }
}
