package com.tencent.mobileqq.guild.home.parts;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.widget.RecyclerViewWithHeaderFooter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/uidata/b;", "kotlin.jvm.PlatformType", "list", "", "invoke", "(Ljava/util/List;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildHomeHeaderPart$initData$1 extends Lambda implements Function1<List<? extends com.tencent.mobileqq.guild.home.viewmodels.header.uidata.b>, Unit> {
    final /* synthetic */ GuildHomeHeaderPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildHomeHeaderPart$initData$1(GuildHomeHeaderPart guildHomeHeaderPart) {
        super(1);
        this.this$0 = guildHomeHeaderPart;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(boolean z16, final GuildHomeHeaderPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z16) {
            RecyclerViewWithHeaderFooter recyclerViewWithHeaderFooter = this$0.recyclerView;
            if (recyclerViewWithHeaderFooter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                recyclerViewWithHeaderFooter = null;
            }
            recyclerViewWithHeaderFooter.post(new Runnable() { // from class: com.tencent.mobileqq.guild.home.parts.ao
                @Override // java.lang.Runnable
                public final void run() {
                    GuildHomeHeaderPart$initData$1.d(GuildHomeHeaderPart.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(GuildHomeHeaderPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RecyclerViewWithHeaderFooter recyclerViewWithHeaderFooter = this$0.recyclerView;
        if (recyclerViewWithHeaderFooter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerViewWithHeaderFooter = null;
        }
        recyclerViewWithHeaderFooter.scrollToPosition(0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends com.tencent.mobileqq.guild.home.viewmodels.header.uidata.b> list) {
        invoke2(list);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<? extends com.tencent.mobileqq.guild.home.viewmodels.header.uidata.b> list) {
        hp1.a aVar;
        int collectionSizeOrDefault;
        View view;
        RecyclerViewWithHeaderFooter recyclerViewWithHeaderFooter = this.this$0.recyclerView;
        hp1.a aVar2 = null;
        if (recyclerViewWithHeaderFooter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerViewWithHeaderFooter = null;
        }
        final boolean z16 = false;
        RecyclerView.ViewHolder findViewHolderForAdapterPosition = recyclerViewWithHeaderFooter.findViewHolderForAdapterPosition(0);
        if (findViewHolderForAdapterPosition != null && (view = findViewHolderForAdapterPosition.itemView) != null && view.isAttachedToWindow()) {
            z16 = true;
        }
        Logger logger = Logger.f235387a;
        if (QLog.isDebugVersion()) {
            Logger.a d16 = logger.d();
            int size = list.size();
            Intrinsics.checkNotNullExpressionValue(list, "list");
            List<? extends com.tencent.mobileqq.guild.home.viewmodels.header.uidata.b> list2 = list;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(((com.tencent.mobileqq.guild.home.viewmodels.header.uidata.b) it.next()).getClass().getCanonicalName());
            }
            d16.d("Guild.NewHome.GuildHomeHeaderPart", 1, "\u5934\u90e8\u6570\u636e guildHomeHeaderBarsViewModel list.size: " + size + " --list:" + arrayList);
        }
        aVar = this.this$0.headerBarsAdapter;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("headerBarsAdapter");
        } else {
            aVar2 = aVar;
        }
        final GuildHomeHeaderPart guildHomeHeaderPart = this.this$0;
        aVar2.setItems(list, new Runnable() { // from class: com.tencent.mobileqq.guild.home.parts.an
            @Override // java.lang.Runnable
            public final void run() {
                GuildHomeHeaderPart$initData$1.c(z16, guildHomeHeaderPart);
            }
        });
    }
}
