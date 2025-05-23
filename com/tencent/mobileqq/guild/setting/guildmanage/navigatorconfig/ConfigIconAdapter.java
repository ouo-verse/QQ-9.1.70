package com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vp1.ce;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0004\b\u000f\u0010\u0010R0\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/navigatorconfig/ConfigIconAdapter;", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/g;", "Lcom/tencent/mobileqq/guild/setting/guildmanage/navigatorconfig/ConfigIconItem;", "Lvp1/ce;", "Lkotlin/Pair;", "", "D", "Lkotlin/Pair;", "l0", "()Lkotlin/Pair;", "m0", "(Lkotlin/Pair;)V", "currentSelectItem", "Landroid/view/LayoutInflater;", "inflater", "<init>", "(Landroid/view/LayoutInflater;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class ConfigIconAdapter extends com.tencent.mobileqq.guild.widget.adapterdelegates.g<ConfigIconItem, ce> {

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private Pair<Integer, ConfigIconItem> currentSelectItem;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConfigIconAdapter(@NotNull final LayoutInflater inflater) {
        super(new Function1<ViewGroup, ce>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.ConfigIconAdapter.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final ce invoke(@NotNull ViewGroup parent) {
                Intrinsics.checkNotNullParameter(parent, "parent");
                ce g16 = ce.g(inflater, parent, false);
                Intrinsics.checkNotNullExpressionValue(g16, "inflate(\n            inf\u2026          false\n        )");
                return g16;
            }
        }, null, new com.tencent.mobileqq.guild.widget.adapterdelegates.f(), 2, null);
        Intrinsics.checkNotNullParameter(inflater, "inflater");
    }

    @Nullable
    public final Pair<Integer, ConfigIconItem> l0() {
        return this.currentSelectItem;
    }

    public final void m0(@Nullable Pair<Integer, ConfigIconItem> pair) {
        this.currentSelectItem = pair;
    }
}
