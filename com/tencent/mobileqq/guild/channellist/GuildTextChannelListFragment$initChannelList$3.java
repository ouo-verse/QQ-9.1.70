package com.tencent.mobileqq.guild.channellist;

import android.view.View;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public /* synthetic */ class GuildTextChannelListFragment$initChannelList$3 extends FunctionReferenceImpl implements Function1<View, Boolean> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public GuildTextChannelListFragment$initChannelList$3(Object obj) {
        super(1, obj, GuildTextChannelListFragment.class, NodeProps.ON_LONG_CLICK, "onLongClick(Landroid/view/View;)Z", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    @NotNull
    public final Boolean invoke(@NotNull View p06) {
        Intrinsics.checkNotNullParameter(p06, "p0");
        return Boolean.valueOf(((GuildTextChannelListFragment) this.receiver).gi(p06));
    }
}
