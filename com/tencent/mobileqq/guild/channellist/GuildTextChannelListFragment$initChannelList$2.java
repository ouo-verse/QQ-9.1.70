package com.tencent.mobileqq.guild.channellist;

import android.view.View;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public /* synthetic */ class GuildTextChannelListFragment$initChannelList$2 extends FunctionReferenceImpl implements Function1<View, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public GuildTextChannelListFragment$initChannelList$2(Object obj) {
        super(1, obj, GuildTextChannelListFragment.class, NodeProps.ON_CLICK, "onClick(Landroid/view/View;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull View p06) {
        Intrinsics.checkNotNullParameter(p06, "p0");
        ((GuildTextChannelListFragment) this.receiver).onClick(p06);
    }
}
